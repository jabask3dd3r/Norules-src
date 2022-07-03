package net.minecraft.world.storage;

import org.apache.logging.log4j.*;
import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;
import javax.annotation.*;
import java.io.*;
import net.minecraft.util.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.client.*;

public class SaveFormatOld implements ISaveFormat
{
    private static final /* synthetic */ Logger LOGGER;
    protected final /* synthetic */ File savesDirectory;
    protected final /* synthetic */ DataFixer dataFixer;
    
    @Override
    public boolean canLoadWorld(final String llllllllllllllIlIIlllIIllIIlIIII) {
        final File llllllllllllllIlIIlllIIllIIIllll = new File(this.savesDirectory, llllllllllllllIlIIlllIIllIIlIIII);
        return llllllllllllllIlIIlllIIllIIIllll.isDirectory();
    }
    
    @Override
    public ISaveHandler getSaveLoader(final String llllllllllllllIlIIlllIIllIlIIIII, final boolean llllllllllllllIlIIlllIIllIIlllII) {
        return new SaveHandler(this.savesDirectory, llllllllllllllIlIIlllIIllIlIIIII, llllllllllllllIlIIlllIIllIIlllII, this.dataFixer);
    }
    
    @Override
    public File getFile(final String llllllllllllllIlIIlllIIllIIIIlll, final String llllllllllllllIlIIlllIIllIIIIIll) {
        return new File(new File(this.savesDirectory, llllllllllllllIlIIlllIIllIIIIlll), llllllllllllllIlIIlllIIllIIIIIll);
    }
    
    @Override
    public boolean isConvertible(final String llllllllllllllIlIIlllIIllIIllIlI) {
        return false;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public void flushCache() {
    }
    
    @Override
    public boolean deleteWorldDirectory(final String llllllllllllllIlIIlllIIllIlllIII) {
        final File llllllllllllllIlIIlllIIllIllIlll = new File(this.savesDirectory, llllllllllllllIlIIlllIIllIlllIII);
        if (!llllllllllllllIlIIlllIIllIllIlll.exists()) {
            return true;
        }
        SaveFormatOld.LOGGER.info("Deleting level {}", (Object)llllllllllllllIlIIlllIIllIlllIII);
        for (int llllllllllllllIlIIlllIIllIllIllI = 1; llllllllllllllIlIIlllIIllIllIllI <= 5; ++llllllllllllllIlIIlllIIllIllIllI) {
            SaveFormatOld.LOGGER.info("Attempt {}...", (Object)llllllllllllllIlIIlllIIllIllIllI);
            if (deleteFiles(llllllllllllllIlIIlllIIllIllIlll.listFiles())) {
                break;
            }
            SaveFormatOld.LOGGER.warn("Unsuccessful in deleting contents.");
            if (llllllllllllllIlIIlllIIllIllIllI < 5) {
                try {
                    Thread.sleep(500L);
                }
                catch (InterruptedException ex) {}
            }
        }
        return llllllllllllllIlIIlllIIllIllIlll.delete();
    }
    
    @Override
    public boolean isNewLevelIdAcceptable(final String llllllllllllllIlIIlllIIlllIIIIIl) {
        final File llllllllllllllIlIIlllIIlllIIIlII = new File(this.savesDirectory, llllllllllllllIlIIlllIIlllIIIIIl);
        if (llllllllllllllIlIIlllIIlllIIIlII.exists()) {
            return false;
        }
        try {
            llllllllllllllIlIIlllIIlllIIIlII.mkdir();
            llllllllllllllIlIIlllIIlllIIIlII.delete();
            return true;
        }
        catch (Throwable llllllllllllllIlIIlllIIlllIIIIll) {
            SaveFormatOld.LOGGER.warn("Couldn't make new level", llllllllllllllIlIIlllIIlllIIIIll);
            return false;
        }
    }
    
    @Override
    public String getName() {
        return "Old Format";
    }
    
    @Nullable
    public static WorldInfo getWorldData(final File llllllllllllllIlIIlllIIllllIIlII, final DataFixer llllllllllllllIlIIlllIIllllIIIll) {
        try {
            final NBTTagCompound llllllllllllllIlIIlllIIllllIIlll = CompressedStreamTools.readCompressed(new FileInputStream(llllllllllllllIlIIlllIIllllIIlII));
            final NBTTagCompound llllllllllllllIlIIlllIIllllIIllI = llllllllllllllIlIIlllIIllllIIlll.getCompoundTag("Data");
            return new WorldInfo(llllllllllllllIlIIlllIIllllIIIll.process(FixTypes.LEVEL, llllllllllllllIlIIlllIIllllIIllI));
        }
        catch (Exception llllllllllllllIlIIlllIIllllIIlIl) {
            SaveFormatOld.LOGGER.error("Exception reading {}", (Object)llllllllllllllIlIIlllIIllllIIlII, (Object)llllllllllllllIlIIlllIIllllIIlIl);
            return null;
        }
    }
    
    @Override
    public void renameWorld(final String llllllllllllllIlIIlllIIlllIllIII, final String llllllllllllllIlIIlllIIlllIIllll) {
        final File llllllllllllllIlIIlllIIlllIlIllI = new File(this.savesDirectory, llllllllllllllIlIIlllIIlllIllIII);
        if (llllllllllllllIlIIlllIIlllIlIllI.exists()) {
            final File llllllllllllllIlIIlllIIlllIlIlIl = new File(llllllllllllllIlIIlllIIlllIlIllI, "level.dat");
            if (llllllllllllllIlIIlllIIlllIlIlIl.exists()) {
                try {
                    final NBTTagCompound llllllllllllllIlIIlllIIlllIlIlII = CompressedStreamTools.readCompressed(new FileInputStream(llllllllllllllIlIIlllIIlllIlIlIl));
                    final NBTTagCompound llllllllllllllIlIIlllIIlllIlIIll = llllllllllllllIlIIlllIIlllIlIlII.getCompoundTag("Data");
                    llllllllllllllIlIIlllIIlllIlIIll.setString("LevelName", llllllllllllllIlIIlllIIlllIIllll);
                    CompressedStreamTools.writeCompressed(llllllllllllllIlIIlllIIlllIlIlII, new FileOutputStream(llllllllllllllIlIIlllIIlllIlIlIl));
                }
                catch (Exception llllllllllllllIlIIlllIIlllIlIIlI) {
                    llllllllllllllIlIIlllIIlllIlIIlI.printStackTrace();
                }
            }
        }
    }
    
    @Nullable
    @Override
    public WorldInfo getWorldInfo(final String llllllllllllllIlIIlllIIlllllIllI) {
        final File llllllllllllllIlIIlllIIlllllIlIl = new File(this.savesDirectory, llllllllllllllIlIIlllIIlllllIllI);
        if (!llllllllllllllIlIIlllIIlllllIlIl.exists()) {
            return null;
        }
        File llllllllllllllIlIIlllIIlllllIlII = new File(llllllllllllllIlIIlllIIlllllIlIl, "level.dat");
        if (llllllllllllllIlIIlllIIlllllIlII.exists()) {
            final WorldInfo llllllllllllllIlIIlllIIlllllIIll = getWorldData(llllllllllllllIlIIlllIIlllllIlII, this.dataFixer);
            if (llllllllllllllIlIIlllIIlllllIIll != null) {
                return llllllllllllllIlIIlllIIlllllIIll;
            }
        }
        llllllllllllllIlIIlllIIlllllIlII = new File(llllllllllllllIlIIlllIIlllllIlIl, "level.dat_old");
        return llllllllllllllIlIIlllIIlllllIlII.exists() ? getWorldData(llllllllllllllIlIIlllIIlllllIlII, this.dataFixer) : null;
    }
    
    @Override
    public boolean convertMapFormat(final String llllllllllllllIlIIlllIIllIIlIllI, final IProgressUpdate llllllllllllllIlIIlllIIllIIlIlIl) {
        return false;
    }
    
    @Override
    public boolean isOldMapFormat(final String llllllllllllllIlIIlllIIllIIllIII) {
        return false;
    }
    
    protected static boolean deleteFiles(final File[] llllllllllllllIlIIlllIIllIlIlIll) {
        final float llllllllllllllIlIIlllIIllIlIIlIl = (Object)llllllllllllllIlIIlllIIllIlIlIll;
        final int llllllllllllllIlIIlllIIllIlIIllI = llllllllllllllIlIIlllIIllIlIlIll.length;
        for (short llllllllllllllIlIIlllIIllIlIIlll = 0; llllllllllllllIlIIlllIIllIlIIlll < llllllllllllllIlIIlllIIllIlIIllI; ++llllllllllllllIlIIlllIIllIlIIlll) {
            final File llllllllllllllIlIIlllIIllIlIlIlI = llllllllllllllIlIIlllIIllIlIIlIl[llllllllllllllIlIIlllIIllIlIIlll];
            SaveFormatOld.LOGGER.debug("Deleting {}", (Object)llllllllllllllIlIIlllIIllIlIlIlI);
            if (llllllllllllllIlIIlllIIllIlIlIlI.isDirectory() && !deleteFiles(llllllllllllllIlIIlllIIllIlIlIlI.listFiles())) {
                SaveFormatOld.LOGGER.warn("Couldn't delete directory {}", (Object)llllllllllllllIlIIlllIIllIlIlIlI);
                return false;
            }
            if (!llllllllllllllIlIIlllIIllIlIlIlI.delete()) {
                SaveFormatOld.LOGGER.warn("Couldn't delete file {}", (Object)llllllllllllllIlIIlllIIllIlIlIlI);
                return false;
            }
        }
        return true;
    }
    
    @Override
    public List<WorldSummary> getSaveList() throws AnvilConverterException {
        final List<WorldSummary> llllllllllllllIlIIlllIlIIIIIIllI = (List<WorldSummary>)Lists.newArrayList();
        for (int llllllllllllllIlIIlllIlIIIIIIlIl = 0; llllllllllllllIlIIlllIlIIIIIIlIl < 5; ++llllllllllllllIlIIlllIlIIIIIIlIl) {
            final String llllllllllllllIlIIlllIlIIIIIIlII = String.valueOf(new StringBuilder("World").append(llllllllllllllIlIIlllIlIIIIIIlIl + 1));
            final WorldInfo llllllllllllllIlIIlllIlIIIIIIIll = this.getWorldInfo(llllllllllllllIlIIlllIlIIIIIIlII);
            if (llllllllllllllIlIIlllIlIIIIIIIll != null) {
                llllllllllllllIlIIlllIlIIIIIIllI.add(new WorldSummary(llllllllllllllIlIIlllIlIIIIIIIll, llllllllllllllIlIIlllIlIIIIIIlII, "", llllllllllllllIlIIlllIlIIIIIIIll.getSizeOnDisk(), false));
            }
        }
        return llllllllllllllIlIIlllIlIIIIIIllI;
    }
    
    public SaveFormatOld(final File llllllllllllllIlIIlllIlIIIIIllll, final DataFixer llllllllllllllIlIIlllIlIIIIlIIIl) {
        this.dataFixer = llllllllllllllIlIIlllIlIIIIlIIIl;
        if (!llllllllllllllIlIIlllIlIIIIIllll.exists()) {
            llllllllllllllIlIIlllIlIIIIIllll.mkdirs();
        }
        this.savesDirectory = llllllllllllllIlIIlllIlIIIIIllll;
    }
}
