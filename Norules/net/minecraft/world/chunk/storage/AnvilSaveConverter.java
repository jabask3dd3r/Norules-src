package net.minecraft.world.chunk.storage;

import com.google.common.collect.*;
import org.apache.commons.lang3.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.client.*;
import net.minecraft.world.storage.*;
import org.apache.logging.log4j.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.world.biome.*;
import net.minecraft.nbt.*;
import java.io.*;
import java.util.*;
import net.minecraft.util.datafix.*;

public class AnvilSaveConverter extends SaveFormatOld
{
    private static final /* synthetic */ Logger LOGGER;
    
    @Override
    public List<WorldSummary> getSaveList() throws AnvilConverterException {
        if (this.savesDirectory != null && this.savesDirectory.exists() && this.savesDirectory.isDirectory()) {
            final List<WorldSummary> lllllllllllllIlllIIlIlllIIllllll = (List<WorldSummary>)Lists.newArrayList();
            final File[] lllllllllllllIlllIIlIlllIIlllllI = this.savesDirectory.listFiles();
            int lllllllllllllIlllIIlIlllIIllIIIl;
            for (char lllllllllllllIlllIIlIlllIIllIIlI = (char)((File[])(Object)(lllllllllllllIlllIIlIlllIIllIIIl = (int)(Object)lllllllllllllIlllIIlIlllIIlllllI)).length, lllllllllllllIlllIIlIlllIIllIIll = '\0'; lllllllllllllIlllIIlIlllIIllIIll < lllllllllllllIlllIIlIlllIIllIIlI; ++lllllllllllllIlllIIlIlllIIllIIll) {
                final File lllllllllllllIlllIIlIlllIIllllIl = lllllllllllllIlllIIlIlllIIllIIIl[lllllllllllllIlllIIlIlllIIllIIll];
                if (lllllllllllllIlllIIlIlllIIllllIl.isDirectory()) {
                    final String lllllllllllllIlllIIlIlllIIllllII = lllllllllllllIlllIIlIlllIIllllIl.getName();
                    final WorldInfo lllllllllllllIlllIIlIlllIIlllIll = this.getWorldInfo(lllllllllllllIlllIIlIlllIIllllII);
                    if (lllllllllllllIlllIIlIlllIIlllIll != null && (lllllllllllllIlllIIlIlllIIlllIll.getSaveVersion() == 19132 || lllllllllllllIlllIIlIlllIIlllIll.getSaveVersion() == 19133)) {
                        final boolean lllllllllllllIlllIIlIlllIIlllIlI = lllllllllllllIlllIIlIlllIIlllIll.getSaveVersion() != this.getSaveVersion();
                        String lllllllllllllIlllIIlIlllIIlllIIl = lllllllllllllIlllIIlIlllIIlllIll.getWorldName();
                        if (StringUtils.isEmpty((CharSequence)lllllllllllllIlllIIlIlllIIlllIIl)) {
                            lllllllllllllIlllIIlIlllIIlllIIl = lllllllllllllIlllIIlIlllIIllllII;
                        }
                        final long lllllllllllllIlllIIlIlllIIlllIII = 0L;
                        lllllllllllllIlllIIlIlllIIllllll.add(new WorldSummary(lllllllllllllIlllIIlIlllIIlllIll, lllllllllllllIlllIIlIlllIIllllII, lllllllllllllIlllIIlIlllIIlllIIl, 0L, lllllllllllllIlllIIlIlllIIlllIlI));
                    }
                }
            }
            return lllllllllllllIlllIIlIlllIIllllll;
        }
        throw new AnvilConverterException(I18n.translateToLocal("selectWorld.load_folder_access"));
    }
    
    @Override
    public void flushCache() {
        RegionFileCache.clearRegionFileReferences();
    }
    
    @Override
    public boolean isConvertible(final String lllllllllllllIlllIIlIlllIIIllIIl) {
        final WorldInfo lllllllllllllIlllIIlIlllIIIllIll = this.getWorldInfo(lllllllllllllIlllIIlIlllIIIllIIl);
        return lllllllllllllIlllIIlIlllIIIllIll != null && lllllllllllllIlllIIlIlllIIIllIll.getSaveVersion() == 19132;
    }
    
    @Override
    public ISaveHandler getSaveLoader(final String lllllllllllllIlllIIlIlllIIlIIIlI, final boolean lllllllllllllIlllIIlIlllIIlIIIIl) {
        return new AnvilSaveHandler(this.savesDirectory, lllllllllllllIlllIIlIlllIIlIIIlI, lllllllllllllIlllIIlIlllIIlIIIIl, this.dataFixer);
    }
    
    @Override
    public boolean isOldMapFormat(final String lllllllllllllIlllIIlIlllIIIlIIII) {
        final WorldInfo lllllllllllllIlllIIlIlllIIIlIIlI = this.getWorldInfo(lllllllllllllIlllIIlIlllIIIlIIII);
        return lllllllllllllIlllIIlIlllIIIlIIlI != null && lllllllllllllIlllIIlIlllIIIlIIlI.getSaveVersion() != this.getSaveVersion();
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    protected int getSaveVersion() {
        return 19133;
    }
    
    private void convertFile(final File lllllllllllllIlllIIlIllIllIIIIll, final Iterable<File> lllllllllllllIlllIIlIllIllIIlIll, final BiomeProvider lllllllllllllIlllIIlIllIllIIIIIl, int lllllllllllllIlllIIlIllIllIIlIIl, final int lllllllllllllIlllIIlIllIlIllllll, final IProgressUpdate lllllllllllllIlllIIlIllIllIIIlll) {
        for (final File lllllllllllllIlllIIlIllIllIIIllI : lllllllllllllIlllIIlIllIllIIlIll) {
            this.convertChunks(lllllllllllllIlllIIlIllIllIIIIll, lllllllllllllIlllIIlIllIllIIIllI, lllllllllllllIlllIIlIllIllIIIIIl, lllllllllllllIlllIIlIllIllIIlIIl, lllllllllllllIlllIIlIllIlIllllll, lllllllllllllIlllIIlIllIllIIIlll);
            ++lllllllllllllIlllIIlIllIllIIlIIl;
            final int lllllllllllllIlllIIlIllIllIIIlIl = (int)Math.round(100.0 * lllllllllllllIlllIIlIllIllIIlIIl / lllllllllllllIlllIIlIllIlIllllll);
            lllllllllllllIlllIIlIllIllIIIlll.setLoadingProgress(lllllllllllllIlllIIlIllIllIIIlIl);
        }
    }
    
    @Override
    public String getName() {
        return "Anvil";
    }
    
    @Override
    public boolean convertMapFormat(final String lllllllllllllIlllIIlIlllIIIIIIII, final IProgressUpdate lllllllllllllIlllIIlIllIllllllll) {
        lllllllllllllIlllIIlIllIllllllll.setLoadingProgress(0);
        final List<File> lllllllllllllIlllIIlIllIlllllllI = (List<File>)Lists.newArrayList();
        final List<File> lllllllllllllIlllIIlIllIllllllIl = (List<File>)Lists.newArrayList();
        final List<File> lllllllllllllIlllIIlIllIllllllII = (List<File>)Lists.newArrayList();
        final File lllllllllllllIlllIIlIllIlllllIll = new File(this.savesDirectory, lllllllllllllIlllIIlIlllIIIIIIII);
        final File lllllllllllllIlllIIlIllIlllllIlI = new File(lllllllllllllIlllIIlIllIlllllIll, "DIM-1");
        final File lllllllllllllIlllIIlIllIlllllIIl = new File(lllllllllllllIlllIIlIllIlllllIll, "DIM1");
        AnvilSaveConverter.LOGGER.info("Scanning folders...");
        this.addRegionFilesToCollection(lllllllllllllIlllIIlIllIlllllIll, lllllllllllllIlllIIlIllIlllllllI);
        if (lllllllllllllIlllIIlIllIlllllIlI.exists()) {
            this.addRegionFilesToCollection(lllllllllllllIlllIIlIllIlllllIlI, lllllllllllllIlllIIlIllIllllllIl);
        }
        if (lllllllllllllIlllIIlIllIlllllIIl.exists()) {
            this.addRegionFilesToCollection(lllllllllllllIlllIIlIllIlllllIIl, lllllllllllllIlllIIlIllIllllllII);
        }
        final int lllllllllllllIlllIIlIllIlllllIII = lllllllllllllIlllIIlIllIlllllllI.size() + lllllllllllllIlllIIlIllIllllllIl.size() + lllllllllllllIlllIIlIllIllllllII.size();
        AnvilSaveConverter.LOGGER.info("Total conversion count is {}", (Object)lllllllllllllIlllIIlIllIlllllIII);
        final WorldInfo lllllllllllllIlllIIlIllIllllIlll = this.getWorldInfo(lllllllllllllIlllIIlIlllIIIIIIII);
        BiomeProvider lllllllllllllIlllIIlIllIllllIlIl = null;
        if (lllllllllllllIlllIIlIllIllllIlll != null && lllllllllllllIlllIIlIllIllllIlll.getTerrainType() == WorldType.FLAT) {
            final BiomeProvider lllllllllllllIlllIIlIllIllllIllI = new BiomeProviderSingle(Biomes.PLAINS);
        }
        else {
            lllllllllllllIlllIIlIllIllllIlIl = new BiomeProvider(lllllllllllllIlllIIlIllIllllIlll);
        }
        this.convertFile(new File(lllllllllllllIlllIIlIllIlllllIll, "region"), lllllllllllllIlllIIlIllIlllllllI, lllllllllllllIlllIIlIllIllllIlIl, 0, lllllllllllllIlllIIlIllIlllllIII, lllllllllllllIlllIIlIllIllllllll);
        this.convertFile(new File(lllllllllllllIlllIIlIllIlllllIlI, "region"), lllllllllllllIlllIIlIllIllllllIl, new BiomeProviderSingle(Biomes.HELL), lllllllllllllIlllIIlIllIlllllllI.size(), lllllllllllllIlllIIlIllIlllllIII, lllllllllllllIlllIIlIllIllllllll);
        this.convertFile(new File(lllllllllllllIlllIIlIllIlllllIIl, "region"), lllllllllllllIlllIIlIllIllllllII, new BiomeProviderSingle(Biomes.SKY), lllllllllllllIlllIIlIllIlllllllI.size() + lllllllllllllIlllIIlIllIllllllIl.size(), lllllllllllllIlllIIlIllIlllllIII, lllllllllllllIlllIIlIllIllllllll);
        lllllllllllllIlllIIlIllIllllIlll.setSaveVersion(19133);
        if (lllllllllllllIlllIIlIllIllllIlll.getTerrainType() == WorldType.DEFAULT_1_1) {
            lllllllllllllIlllIIlIllIllllIlll.setTerrainType(WorldType.DEFAULT);
        }
        this.createFile(lllllllllllllIlllIIlIlllIIIIIIII);
        final ISaveHandler lllllllllllllIlllIIlIllIllllIlII = this.getSaveLoader(lllllllllllllIlllIIlIlllIIIIIIII, false);
        lllllllllllllIlllIIlIllIllllIlII.saveWorldInfo(lllllllllllllIlllIIlIllIllllIlll);
        return true;
    }
    
    private void convertChunks(final File lllllllllllllIlllIIlIllIlIIlIIlI, final File lllllllllllllIlllIIlIllIlIIlIIIl, final BiomeProvider lllllllllllllIlllIIlIllIlIIlIIII, final int lllllllllllllIlllIIlIllIlIlIIlII, final int lllllllllllllIlllIIlIllIlIlIIIll, final IProgressUpdate lllllllllllllIlllIIlIllIlIIIllIl) {
        try {
            final String lllllllllllllIlllIIlIllIlIlIIIIl = lllllllllllllIlllIIlIllIlIIlIIIl.getName();
            final RegionFile lllllllllllllIlllIIlIllIlIlIIIII = new RegionFile(lllllllllllllIlllIIlIllIlIIlIIIl);
            final RegionFile lllllllllllllIlllIIlIllIlIIlllll = new RegionFile(new File(lllllllllllllIlllIIlIllIlIIlIIlI, String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIIlIllIlIlIIIIl.substring(0, lllllllllllllIlllIIlIllIlIlIIIIl.length() - ".mcr".length()))).append(".mca"))));
            for (int lllllllllllllIlllIIlIllIlIIllllI = 0; lllllllllllllIlllIIlIllIlIIllllI < 32; ++lllllllllllllIlllIIlIllIlIIllllI) {
                for (int lllllllllllllIlllIIlIllIlIIlllIl = 0; lllllllllllllIlllIIlIllIlIIlllIl < 32; ++lllllllllllllIlllIIlIllIlIIlllIl) {
                    if (lllllllllllllIlllIIlIllIlIlIIIII.isChunkSaved(lllllllllllllIlllIIlIllIlIIllllI, lllllllllllllIlllIIlIllIlIIlllIl) && !lllllllllllllIlllIIlIllIlIIlllll.isChunkSaved(lllllllllllllIlllIIlIllIlIIllllI, lllllllllllllIlllIIlIllIlIIlllIl)) {
                        final DataInputStream lllllllllllllIlllIIlIllIlIIlllII = lllllllllllllIlllIIlIllIlIlIIIII.getChunkDataInputStream(lllllllllllllIlllIIlIllIlIIllllI, lllllllllllllIlllIIlIllIlIIlllIl);
                        if (lllllllllllllIlllIIlIllIlIIlllII == null) {
                            AnvilSaveConverter.LOGGER.warn("Failed to fetch input stream");
                        }
                        else {
                            final NBTTagCompound lllllllllllllIlllIIlIllIlIIllIll = CompressedStreamTools.read(lllllllllllllIlllIIlIllIlIIlllII);
                            lllllllllllllIlllIIlIllIlIIlllII.close();
                            final NBTTagCompound lllllllllllllIlllIIlIllIlIIllIlI = lllllllllllllIlllIIlIllIlIIllIll.getCompoundTag("Level");
                            final ChunkLoader.AnvilConverterData lllllllllllllIlllIIlIllIlIIllIIl = ChunkLoader.load(lllllllllllllIlllIIlIllIlIIllIlI);
                            final NBTTagCompound lllllllllllllIlllIIlIllIlIIllIII = new NBTTagCompound();
                            final NBTTagCompound lllllllllllllIlllIIlIllIlIIlIlll = new NBTTagCompound();
                            lllllllllllllIlllIIlIllIlIIllIII.setTag("Level", lllllllllllllIlllIIlIllIlIIlIlll);
                            ChunkLoader.convertToAnvilFormat(lllllllllllllIlllIIlIllIlIIllIIl, lllllllllllllIlllIIlIllIlIIlIlll, lllllllllllllIlllIIlIllIlIIlIIII);
                            final DataOutputStream lllllllllllllIlllIIlIllIlIIlIllI = lllllllllllllIlllIIlIllIlIIlllll.getChunkDataOutputStream(lllllllllllllIlllIIlIllIlIIllllI, lllllllllllllIlllIIlIllIlIIlllIl);
                            CompressedStreamTools.write(lllllllllllllIlllIIlIllIlIIllIII, lllllllllllllIlllIIlIllIlIIlIllI);
                            lllllllllllllIlllIIlIllIlIIlIllI.close();
                        }
                    }
                }
                final int lllllllllllllIlllIIlIllIlIIlIlIl = (int)Math.round(100.0 * (lllllllllllllIlllIIlIllIlIlIIlII * 1024) / (lllllllllllllIlllIIlIllIlIlIIIll * 1024));
                final int lllllllllllllIlllIIlIllIlIIlIlII = (int)Math.round(100.0 * ((lllllllllllllIlllIIlIllIlIIllllI + 1) * 32 + lllllllllllllIlllIIlIllIlIlIIlII * 1024) / (lllllllllllllIlllIIlIllIlIlIIIll * 1024));
                if (lllllllllllllIlllIIlIllIlIIlIlII > lllllllllllllIlllIIlIllIlIIlIlIl) {
                    lllllllllllllIlllIIlIllIlIIIllIl.setLoadingProgress(lllllllllllllIlllIIlIllIlIIlIlII);
                }
            }
            lllllllllllllIlllIIlIllIlIlIIIII.close();
            lllllllllllllIlllIIlIllIlIIlllll.close();
        }
        catch (IOException lllllllllllllIlllIIlIllIlIIlIIll) {
            lllllllllllllIlllIIlIllIlIIlIIll.printStackTrace();
        }
    }
    
    private void addRegionFilesToCollection(final File lllllllllllllIlllIIlIllIIlllIlIl, final Collection<File> lllllllllllllIlllIIlIllIIlllIlII) {
        final File lllllllllllllIlllIIlIllIIllllIII = new File(lllllllllllllIlllIIlIllIIlllIlIl, "region");
        final File[] lllllllllllllIlllIIlIllIIlllIlll = lllllllllllllIlllIIlIllIIllllIII.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(final File lllllllllllllllIIllIlIllIIlIIIlI, final String lllllllllllllllIIllIlIllIIlIIIII) {
                return lllllllllllllllIIllIlIllIIlIIIII.endsWith(".mcr");
            }
        });
        if (lllllllllllllIlllIIlIllIIlllIlll != null) {
            Collections.addAll(lllllllllllllIlllIIlIllIIlllIlII, lllllllllllllIlllIIlIllIIlllIlll);
        }
    }
    
    public AnvilSaveConverter(final File lllllllllllllIlllIIlIlllIlIlIIlI, final DataFixer lllllllllllllIlllIIlIlllIlIIlllI) {
        super(lllllllllllllIlllIIlIlllIlIlIIlI, lllllllllllllIlllIIlIlllIlIIlllI);
    }
    
    private void createFile(final String lllllllllllllIlllIIlIllIlllIIIII) {
        final File lllllllllllllIlllIIlIllIllIlllll = new File(this.savesDirectory, lllllllllllllIlllIIlIllIlllIIIII);
        if (!lllllllllllllIlllIIlIllIllIlllll.exists()) {
            AnvilSaveConverter.LOGGER.warn("Unable to create level.dat_mcr backup");
        }
        else {
            final File lllllllllllllIlllIIlIllIllIllllI = new File(lllllllllllllIlllIIlIllIllIlllll, "level.dat");
            if (!lllllllllllllIlllIIlIllIllIllllI.exists()) {
                AnvilSaveConverter.LOGGER.warn("Unable to create level.dat_mcr backup");
            }
            else {
                final File lllllllllllllIlllIIlIllIllIlllIl = new File(lllllllllllllIlllIIlIllIllIlllll, "level.dat_mcr");
                if (!lllllllllllllIlllIIlIllIllIllllI.renameTo(lllllllllllllIlllIIlIllIllIlllIl)) {
                    AnvilSaveConverter.LOGGER.warn("Unable to create level.dat_mcr backup");
                }
            }
        }
    }
}
