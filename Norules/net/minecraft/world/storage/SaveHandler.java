package net.minecraft.world.storage;

import net.minecraft.world.gen.structure.template.*;
import net.minecraft.world.chunk.storage.*;
import javax.annotation.*;
import net.minecraft.nbt.*;
import org.apache.logging.log4j.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.datafix.*;
import net.minecraft.server.*;
import java.io.*;
import net.minecraft.world.*;

public class SaveHandler implements IPlayerFileData, ISaveHandler
{
    protected final /* synthetic */ DataFixer dataFixer;
    private final /* synthetic */ File worldDirectory;
    private final /* synthetic */ TemplateManager structureTemplateManager;
    private final /* synthetic */ File mapDataDir;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ File playersDirectory;
    private final /* synthetic */ long initializationTime;
    private final /* synthetic */ String saveDirectoryName;
    
    @Override
    public IChunkLoader getChunkLoader(final WorldProvider lllllllllllllIIIlllIIllllIlIlIIl) {
        throw new RuntimeException("Old Chunk Storage is no longer supported.");
    }
    
    @Override
    public IPlayerFileData getPlayerNBTManager() {
        return this;
    }
    
    @Override
    public void saveWorldInfoWithPlayer(final WorldInfo lllllllllllllIIIlllIIllllIIlIllI, @Nullable final NBTTagCompound lllllllllllllIIIlllIIllllIIlIlIl) {
        final NBTTagCompound lllllllllllllIIIlllIIllllIIlIlII = lllllllllllllIIIlllIIllllIIlIllI.cloneNBTCompound(lllllllllllllIIIlllIIllllIIlIlIl);
        final NBTTagCompound lllllllllllllIIIlllIIllllIIlIIll = new NBTTagCompound();
        lllllllllllllIIIlllIIllllIIlIIll.setTag("Data", lllllllllllllIIIlllIIllllIIlIlII);
        try {
            final File lllllllllllllIIIlllIIllllIIlIIlI = new File(this.worldDirectory, "level.dat_new");
            final File lllllllllllllIIIlllIIllllIIlIIIl = new File(this.worldDirectory, "level.dat_old");
            final File lllllllllllllIIIlllIIllllIIlIIII = new File(this.worldDirectory, "level.dat");
            CompressedStreamTools.writeCompressed(lllllllllllllIIIlllIIllllIIlIIll, new FileOutputStream(lllllllllllllIIIlllIIllllIIlIIlI));
            if (lllllllllllllIIIlllIIllllIIlIIIl.exists()) {
                lllllllllllllIIIlllIIllllIIlIIIl.delete();
            }
            lllllllllllllIIIlllIIllllIIlIIII.renameTo(lllllllllllllIIIlllIIllllIIlIIIl);
            if (lllllllllllllIIIlllIIllllIIlIIII.exists()) {
                lllllllllllllIIIlllIIllllIIlIIII.delete();
            }
            lllllllllllllIIIlllIIllllIIlIIlI.renameTo(lllllllllllllIIIlllIIllllIIlIIII);
            if (lllllllllllllIIIlllIIllllIIlIIlI.exists()) {
                lllllllllllllIIIlllIIllllIIlIIlI.delete();
            }
        }
        catch (Exception lllllllllllllIIIlllIIllllIIIllll) {
            lllllllllllllIIIlllIIllllIIIllll.printStackTrace();
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public TemplateManager getStructureTemplateManager() {
        return this.structureTemplateManager;
    }
    
    @Override
    public File getWorldDirectory() {
        return this.worldDirectory;
    }
    
    @Override
    public void saveWorldInfo(final WorldInfo lllllllllllllIIIlllIIllllIIIIIll) {
        this.saveWorldInfoWithPlayer(lllllllllllllIIIlllIIllllIIIIIll, null);
    }
    
    @Nullable
    @Override
    public WorldInfo loadWorldInfo() {
        File lllllllllllllIIIlllIIllllIlIIlII = new File(this.worldDirectory, "level.dat");
        if (lllllllllllllIIIlllIIllllIlIIlII.exists()) {
            final WorldInfo lllllllllllllIIIlllIIllllIlIIIll = SaveFormatOld.getWorldData(lllllllllllllIIIlllIIllllIlIIlII, this.dataFixer);
            if (lllllllllllllIIIlllIIllllIlIIIll != null) {
                return lllllllllllllIIIlllIIllllIlIIIll;
            }
        }
        lllllllllllllIIIlllIIllllIlIIlII = new File(this.worldDirectory, "level.dat_old");
        return lllllllllllllIIIlllIIllllIlIIlII.exists() ? SaveFormatOld.getWorldData(lllllllllllllIIIlllIIllllIlIIlII, this.dataFixer) : null;
    }
    
    @Nullable
    @Override
    public NBTTagCompound readPlayerData(final EntityPlayer lllllllllllllIIIlllIIlllIllIIllI) {
        NBTTagCompound lllllllllllllIIIlllIIlllIllIlIlI = null;
        try {
            final File lllllllllllllIIIlllIIlllIllIlIIl = new File(this.playersDirectory, String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIlllIIlllIllIIllI.getCachedUniqueIdString())).append(".dat")));
            if (lllllllllllllIIIlllIIlllIllIlIIl.exists() && lllllllllllllIIIlllIIlllIllIlIIl.isFile()) {
                lllllllllllllIIIlllIIlllIllIlIlI = CompressedStreamTools.readCompressed(new FileInputStream(lllllllllllllIIIlllIIlllIllIlIIl));
            }
        }
        catch (Exception lllllllllllllIIIlllIIlllIllIlIII) {
            SaveHandler.LOGGER.warn("Failed to load player data for {}", (Object)lllllllllllllIIIlllIIlllIllIIllI.getName());
        }
        if (lllllllllllllIIIlllIIlllIllIlIlI != null) {
            lllllllllllllIIIlllIIlllIllIIllI.readFromNBT(this.dataFixer.process(FixTypes.PLAYER, lllllllllllllIIIlllIIlllIllIlIlI));
        }
        return lllllllllllllIIIlllIIlllIllIlIlI;
    }
    
    @Override
    public void writePlayerData(final EntityPlayer lllllllllllllIIIlllIIlllIlllIlII) {
        try {
            final NBTTagCompound lllllllllllllIIIlllIIlllIllllIIl = lllllllllllllIIIlllIIlllIlllIlII.writeToNBT(new NBTTagCompound());
            final File lllllllllllllIIIlllIIlllIllllIII = new File(this.playersDirectory, String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIlllIIlllIlllIlII.getCachedUniqueIdString())).append(".dat.tmp")));
            final File lllllllllllllIIIlllIIlllIlllIlll = new File(this.playersDirectory, String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIlllIIlllIlllIlII.getCachedUniqueIdString())).append(".dat")));
            CompressedStreamTools.writeCompressed(lllllllllllllIIIlllIIlllIllllIIl, new FileOutputStream(lllllllllllllIIIlllIIlllIllllIII));
            if (lllllllllllllIIIlllIIlllIlllIlll.exists()) {
                lllllllllllllIIIlllIIlllIlllIlll.delete();
            }
            lllllllllllllIIIlllIIlllIllllIII.renameTo(lllllllllllllIIIlllIIlllIlllIlll);
        }
        catch (Exception lllllllllllllIIIlllIIlllIlllIllI) {
            SaveHandler.LOGGER.warn("Failed to save player data for {}", (Object)lllllllllllllIIIlllIIlllIlllIlII.getName());
        }
    }
    
    @Override
    public File getMapFileFromName(final String lllllllllllllIIIlllIIlllIlIlIIIl) {
        return new File(this.mapDataDir, String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIlllIIlllIlIlIIIl)).append(".dat")));
    }
    
    private void setSessionLock() {
        try {
            final File lllllllllllllIIIlllIIlllllIIIIII = new File(this.worldDirectory, "session.lock");
            final DataOutputStream lllllllllllllIIIlllIIllllIllllll = new DataOutputStream(new FileOutputStream(lllllllllllllIIIlllIIlllllIIIIII));
            try {
                lllllllllllllIIIlllIIllllIllllll.writeLong(this.initializationTime);
            }
            finally {
                lllllllllllllIIIlllIIllllIllllll.close();
            }
            lllllllllllllIIIlllIIllllIllllll.close();
        }
        catch (IOException lllllllllllllIIIlllIIllllIlllllI) {
            lllllllllllllIIIlllIIllllIlllllI.printStackTrace();
            throw new RuntimeException("Failed to check session lock, aborting");
        }
    }
    
    public SaveHandler(final File lllllllllllllIIIlllIIlllllIIlIIl, final String lllllllllllllIIIlllIIlllllIIllIl, final boolean lllllllllllllIIIlllIIlllllIIIlll, final DataFixer lllllllllllllIIIlllIIlllllIIlIll) {
        this.initializationTime = MinecraftServer.getCurrentTimeMillis();
        this.dataFixer = lllllllllllllIIIlllIIlllllIIlIll;
        this.worldDirectory = new File(lllllllllllllIIIlllIIlllllIIlIIl, lllllllllllllIIIlllIIlllllIIllIl);
        this.worldDirectory.mkdirs();
        this.playersDirectory = new File(this.worldDirectory, "playerdata");
        this.mapDataDir = new File(this.worldDirectory, "data");
        this.mapDataDir.mkdirs();
        this.saveDirectoryName = lllllllllllllIIIlllIIlllllIIllIl;
        if (lllllllllllllIIIlllIIlllllIIIlll) {
            this.playersDirectory.mkdirs();
            this.structureTemplateManager = new TemplateManager(new File(this.worldDirectory, "structures").toString(), lllllllllllllIIIlllIIlllllIIlIll);
        }
        else {
            this.structureTemplateManager = null;
        }
        this.setSessionLock();
    }
    
    @Override
    public void flush() {
    }
    
    @Override
    public void checkSessionLock() throws MinecraftException {
        try {
            final File lllllllllllllIIIlllIIllllIllIIIl = new File(this.worldDirectory, "session.lock");
            final DataInputStream lllllllllllllIIIlllIIllllIllIIII = new DataInputStream(new FileInputStream(lllllllllllllIIIlllIIllllIllIIIl));
            try {
                if (lllllllllllllIIIlllIIllllIllIIII.readLong() != this.initializationTime) {
                    throw new MinecraftException("The save is being accessed from another location, aborting");
                }
            }
            finally {
                lllllllllllllIIIlllIIllllIllIIII.close();
            }
            lllllllllllllIIIlllIIllllIllIIII.close();
        }
        catch (IOException lllllllllllllIIIlllIIllllIlIllll) {
            throw new MinecraftException("Failed to check session lock, aborting");
        }
    }
    
    @Override
    public String[] getAvailablePlayerDat() {
        String[] lllllllllllllIIIlllIIlllIlIlllII = this.playersDirectory.list();
        if (lllllllllllllIIIlllIIlllIlIlllII == null) {
            lllllllllllllIIIlllIIlllIlIlllII = new String[0];
        }
        for (int lllllllllllllIIIlllIIlllIlIllIll = 0; lllllllllllllIIIlllIIlllIlIllIll < lllllllllllllIIIlllIIlllIlIlllII.length; ++lllllllllllllIIIlllIIlllIlIllIll) {
            if (lllllllllllllIIIlllIIlllIlIlllII[lllllllllllllIIIlllIIlllIlIllIll].endsWith(".dat")) {
                lllllllllllllIIIlllIIlllIlIlllII[lllllllllllllIIIlllIIlllIlIllIll] = lllllllllllllIIIlllIIlllIlIlllII[lllllllllllllIIIlllIIlllIlIllIll].substring(0, lllllllllllllIIIlllIIlllIlIlllII[lllllllllllllIIIlllIIlllIlIllIll].length() - 4);
            }
        }
        return lllllllllllllIIIlllIIlllIlIlllII;
    }
}
