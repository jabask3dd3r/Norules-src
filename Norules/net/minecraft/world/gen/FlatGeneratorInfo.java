package net.minecraft.world.gen;

import net.minecraft.util.math.*;
import net.minecraft.world.biome.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.init.*;
import net.minecraft.block.*;

public class FlatGeneratorInfo
{
    private final /* synthetic */ List<FlatLayerInfo> flatLayers;
    private /* synthetic */ int biomeToUse;
    private final /* synthetic */ Map<String, Map<String, String>> worldFeatures;
    
    public List<FlatLayerInfo> getFlatLayers() {
        return this.flatLayers;
    }
    
    private static List<FlatLayerInfo> getLayersFromString(final int llllllllllllllIllIIIIllIlIlllIll, final String llllllllllllllIllIIIIllIllIIIIIl) {
        if (llllllllllllllIllIIIIllIllIIIIIl != null && llllllllllllllIllIIIIllIllIIIIIl.length() >= 1) {
            final List<FlatLayerInfo> llllllllllllllIllIIIIllIllIIIIII = (List<FlatLayerInfo>)Lists.newArrayList();
            final String[] llllllllllllllIllIIIIllIlIllllll = llllllllllllllIllIIIIllIllIIIIIl.split(",");
            int llllllllllllllIllIIIIllIlIlllllI = 0;
            final byte llllllllllllllIllIIIIllIlIllIIll;
            final char llllllllllllllIllIIIIllIlIllIlII = (char)((String[])(Object)(llllllllllllllIllIIIIllIlIllIIll = (byte)(Object)llllllllllllllIllIIIIllIlIllllll)).length;
            for (boolean llllllllllllllIllIIIIllIlIllIlIl = false; (llllllllllllllIllIIIIllIlIllIlIl ? 1 : 0) < llllllllllllllIllIIIIllIlIllIlII; ++llllllllllllllIllIIIIllIlIllIlIl) {
                final String llllllllllllllIllIIIIllIlIllllIl = llllllllllllllIllIIIIllIlIllIIll[llllllllllllllIllIIIIllIlIllIlIl];
                final FlatLayerInfo llllllllllllllIllIIIIllIlIllllII = getLayerFromString(llllllllllllllIllIIIIllIlIlllIll, llllllllllllllIllIIIIllIlIllllIl, llllllllllllllIllIIIIllIlIlllllI);
                if (llllllllllllllIllIIIIllIlIllllII == null) {
                    return null;
                }
                llllllllllllllIllIIIIllIllIIIIII.add(llllllllllllllIllIIIIllIlIllllII);
                llllllllllllllIllIIIIllIlIlllllI += llllllllllllllIllIIIIllIlIllllII.getLayerCount();
            }
            return llllllllllllllIllIIIIllIllIIIIII;
        }
        return null;
    }
    
    public static FlatGeneratorInfo createFlatGeneratorFromString(final String llllllllllllllIllIIIIllIlIIIllll) {
        if (llllllllllllllIllIIIIllIlIIIllll == null) {
            return getDefaultFlatGenerator();
        }
        final String[] llllllllllllllIllIIIIllIlIIlllII = llllllllllllllIllIIIIllIlIIIllll.split(";", -1);
        final int llllllllllllllIllIIIIllIlIIllIll = (llllllllllllllIllIIIIllIlIIlllII.length == 1) ? 0 : MathHelper.getInt(llllllllllllllIllIIIIllIlIIlllII[0], 0);
        if (llllllllllllllIllIIIIllIlIIllIll < 0 || llllllllllllllIllIIIIllIlIIllIll > 3) {
            return getDefaultFlatGenerator();
        }
        final FlatGeneratorInfo llllllllllllllIllIIIIllIlIIllIlI = new FlatGeneratorInfo();
        int llllllllllllllIllIIIIllIlIIllIIl = (llllllllllllllIllIIIIllIlIIlllII.length != 1) ? 1 : 0;
        final List<FlatLayerInfo> llllllllllllllIllIIIIllIlIIllIII = getLayersFromString(llllllllllllllIllIIIIllIlIIllIll, llllllllllllllIllIIIIllIlIIlllII[llllllllllllllIllIIIIllIlIIllIIl++]);
        if (llllllllllllllIllIIIIllIlIIllIII != null && !llllllllllllllIllIIIIllIlIIllIII.isEmpty()) {
            llllllllllllllIllIIIIllIlIIllIlI.getFlatLayers().addAll(llllllllllllllIllIIIIllIlIIllIII);
            llllllllllllllIllIIIIllIlIIllIlI.updateLayers();
            int llllllllllllllIllIIIIllIlIIlIlll = Biome.getIdForBiome(Biomes.PLAINS);
            if (llllllllllllllIllIIIIllIlIIllIll > 0 && llllllllllllllIllIIIIllIlIIlllII.length > llllllllllllllIllIIIIllIlIIllIIl) {
                llllllllllllllIllIIIIllIlIIlIlll = MathHelper.getInt(llllllllllllllIllIIIIllIlIIlllII[llllllllllllllIllIIIIllIlIIllIIl++], llllllllllllllIllIIIIllIlIIlIlll);
            }
            llllllllllllllIllIIIIllIlIIllIlI.setBiome(llllllllllllllIllIIIIllIlIIlIlll);
            if (llllllllllllllIllIIIIllIlIIllIll > 0 && llllllllllllllIllIIIIllIlIIlllII.length > llllllllllllllIllIIIIllIlIIllIIl) {
                final String[] llllllllllllllIllIIIIllIlIIlIllI = llllllllllllllIllIIIIllIlIIlllII[llllllllllllllIllIIIIllIlIIllIIl++].toLowerCase(Locale.ROOT).split(",");
                final byte llllllllllllllIllIIIIllIlIIIIlII;
                final int llllllllllllllIllIIIIllIlIIIIlIl = ((String[])(Object)(llllllllllllllIllIIIIllIlIIIIlII = (byte)(Object)llllllllllllllIllIIIIllIlIIlIllI)).length;
                for (Exception llllllllllllllIllIIIIllIlIIIIllI = (Exception)0; llllllllllllllIllIIIIllIlIIIIllI < llllllllllllllIllIIIIllIlIIIIlIl; ++llllllllllllllIllIIIIllIlIIIIllI) {
                    final String llllllllllllllIllIIIIllIlIIlIlIl = llllllllllllllIllIIIIllIlIIIIlII[llllllllllllllIllIIIIllIlIIIIllI];
                    final String[] llllllllllllllIllIIIIllIlIIlIlII = llllllllllllllIllIIIIllIlIIlIlIl.split("\\(", 2);
                    final Map<String, String> llllllllllllllIllIIIIllIlIIlIIll = (Map<String, String>)Maps.newHashMap();
                    if (!llllllllllllllIllIIIIllIlIIlIlII[0].isEmpty()) {
                        llllllllllllllIllIIIIllIlIIllIlI.getWorldFeatures().put(llllllllllllllIllIIIIllIlIIlIlII[0], llllllllllllllIllIIIIllIlIIlIIll);
                        if (llllllllllllllIllIIIIllIlIIlIlII.length > 1 && llllllllllllllIllIIIIllIlIIlIlII[1].endsWith(")") && llllllllllllllIllIIIIllIlIIlIlII[1].length() > 1) {
                            final String[] llllllllllllllIllIIIIllIlIIlIIlI = llllllllllllllIllIIIIllIlIIlIlII[1].substring(0, llllllllllllllIllIIIIllIlIIlIlII[1].length() - 1).split(" ");
                            final long llllllllllllllIllIIIIllIIlllllIl;
                            final boolean llllllllllllllIllIIIIllIIllllllI = ((String[])(Object)(llllllllllllllIllIIIIllIIlllllIl = (long)(Object)llllllllllllllIllIIIIllIlIIlIIlI)).length != 0;
                            for (String llllllllllllllIllIIIIllIIlllllll = (String)0; llllllllllllllIllIIIIllIIlllllll < llllllllllllllIllIIIIllIIllllllI; ++llllllllllllllIllIIIIllIIlllllll) {
                                final String llllllllllllllIllIIIIllIlIIlIIIl = llllllllllllllIllIIIIllIIlllllIl[llllllllllllllIllIIIIllIIlllllll];
                                final String[] llllllllllllllIllIIIIllIlIIlIIII = llllllllllllllIllIIIIllIlIIlIIIl.split("=", 2);
                                if (llllllllllllllIllIIIIllIlIIlIIII.length == 2) {
                                    llllllllllllllIllIIIIllIlIIlIIll.put(llllllllllllllIllIIIIllIlIIlIIII[0], llllllllllllllIllIIIIllIlIIlIIII[1]);
                                }
                            }
                        }
                    }
                }
            }
            else {
                llllllllllllllIllIIIIllIlIIllIlI.getWorldFeatures().put("village", Maps.newHashMap());
            }
            return llllllllllllllIllIIIIllIlIIllIlI;
        }
        return getDefaultFlatGenerator();
    }
    
    public void setBiome(final int llllllllllllllIllIIIIlllIIIlIlll) {
        this.biomeToUse = llllllllllllllIllIIIIlllIIIlIlll;
    }
    
    public Map<String, Map<String, String>> getWorldFeatures() {
        return this.worldFeatures;
    }
    
    public static FlatGeneratorInfo getDefaultFlatGenerator() {
        final FlatGeneratorInfo llllllllllllllIllIIIIllIIllllIlI = new FlatGeneratorInfo();
        llllllllllllllIllIIIIllIIllllIlI.setBiome(Biome.getIdForBiome(Biomes.PLAINS));
        llllllllllllllIllIIIIllIIllllIlI.getFlatLayers().add(new FlatLayerInfo(1, Blocks.BEDROCK));
        llllllllllllllIllIIIIllIIllllIlI.getFlatLayers().add(new FlatLayerInfo(2, Blocks.DIRT));
        llllllllllllllIllIIIIllIIllllIlI.getFlatLayers().add(new FlatLayerInfo(1, Blocks.GRASS));
        llllllllllllllIllIIIIllIIllllIlI.updateLayers();
        llllllllllllllIllIIIIllIIllllIlI.getWorldFeatures().put("village", Maps.newHashMap());
        return llllllllllllllIllIIIIllIIllllIlI;
    }
    
    private static FlatLayerInfo getLayerFromString(final int llllllllllllllIllIIIIllIlllIIIIl, final String llllllllllllllIllIIIIllIlllIIIII, final int llllllllllllllIllIIIIllIllIlIIlI) {
        String[] llllllllllllllIllIIIIllIllIllllI = (llllllllllllllIllIIIIllIlllIIIIl >= 3) ? llllllllllllllIllIIIIllIlllIIIII.split("\\*", 2) : llllllllllllllIllIIIIllIlllIIIII.split("x", 2);
        int llllllllllllllIllIIIIllIllIlllIl = 1;
        int llllllllllllllIllIIIIllIllIlllII = 0;
        if (llllllllllllllIllIIIIllIllIllllI.length == 2) {
            try {
                llllllllllllllIllIIIIllIllIlllIl = Integer.parseInt(llllllllllllllIllIIIIllIllIllllI[0]);
                if (llllllllllllllIllIIIIllIllIlIIlI + llllllllllllllIllIIIIllIllIlllIl >= 256) {
                    llllllllllllllIllIIIIllIllIlllIl = 256 - llllllllllllllIllIIIIllIllIlIIlI;
                }
                if (llllllllllllllIllIIIIllIllIlllIl < 0) {
                    llllllllllllllIllIIIIllIllIlllIl = 0;
                }
            }
            catch (Throwable llllllllllllllIllIIIIllIllIllIll) {
                return null;
            }
        }
        try {
            final String llllllllllllllIllIIIIllIllIlIlll = llllllllllllllIllIIIIllIllIllllI[llllllllllllllIllIIIIllIllIllllI.length - 1];
            Block llllllllllllllIllIIIIllIllIllIIl = null;
            if (llllllllllllllIllIIIIllIlllIIIIl < 3) {
                llllllllllllllIllIIIIllIllIllllI = llllllllllllllIllIIIIllIllIlIlll.split(":", 2);
                if (llllllllllllllIllIIIIllIllIllllI.length > 1) {
                    llllllllllllllIllIIIIllIllIlllII = Integer.parseInt(llllllllllllllIllIIIIllIllIllllI[1]);
                }
                final Block llllllllllllllIllIIIIllIllIllIlI = Block.getBlockById(Integer.parseInt(llllllllllllllIllIIIIllIllIllllI[0]));
            }
            else {
                llllllllllllllIllIIIIllIllIllllI = llllllllllllllIllIIIIllIllIlIlll.split(":", 3);
                llllllllllllllIllIIIIllIllIllIIl = ((llllllllllllllIllIIIIllIllIllllI.length > 1) ? Block.getBlockFromName(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIIIIllIllIllllI[0])).append(":").append(llllllllllllllIllIIIIllIllIllllI[1]))) : null);
                if (llllllllllllllIllIIIIllIllIllIIl != null) {
                    llllllllllllllIllIIIIllIllIlllII = ((llllllllllllllIllIIIIllIllIllllI.length > 2) ? Integer.parseInt(llllllllllllllIllIIIIllIllIllllI[2]) : 0);
                }
                else {
                    llllllllllllllIllIIIIllIllIllIIl = Block.getBlockFromName(llllllllllllllIllIIIIllIllIllllI[0]);
                    if (llllllllllllllIllIIIIllIllIllIIl != null) {
                        llllllllllllllIllIIIIllIllIlllII = ((llllllllllllllIllIIIIllIllIllllI.length > 1) ? Integer.parseInt(llllllllllllllIllIIIIllIllIllllI[1]) : 0);
                    }
                }
                if (llllllllllllllIllIIIIllIllIllIIl == null) {
                    return null;
                }
            }
            if (llllllllllllllIllIIIIllIllIllIIl == Blocks.AIR) {
                llllllllllllllIllIIIIllIllIlllII = 0;
            }
            if (llllllllllllllIllIIIIllIllIlllII < 0 || llllllllllllllIllIIIIllIllIlllII > 15) {
                llllllllllllllIllIIIIllIllIlllII = 0;
            }
        }
        catch (Throwable llllllllllllllIllIIIIllIllIlIllI) {
            return null;
        }
        final Block llllllllllllllIllIIIIllIllIllIII;
        final FlatLayerInfo llllllllllllllIllIIIIllIllIlIlIl = new FlatLayerInfo(llllllllllllllIllIIIIllIlllIIIIl, llllllllllllllIllIIIIllIllIlllIl, llllllllllllllIllIIIIllIllIllIII, llllllllllllllIllIIIIllIllIlllII);
        llllllllllllllIllIIIIllIllIlIlIl.setMinY(llllllllllllllIllIIIIllIllIlIIlI);
        return llllllllllllllIllIIIIllIllIlIlIl;
    }
    
    @Override
    public String toString() {
        final StringBuilder llllllllllllllIllIIIIllIlllllIIl = new StringBuilder();
        llllllllllllllIllIIIIllIlllllIIl.append(3);
        llllllllllllllIllIIIIllIlllllIIl.append(";");
        for (int llllllllllllllIllIIIIllIlllllIII = 0; llllllllllllllIllIIIIllIlllllIII < this.flatLayers.size(); ++llllllllllllllIllIIIIllIlllllIII) {
            if (llllllllllllllIllIIIIllIlllllIII > 0) {
                llllllllllllllIllIIIIllIlllllIIl.append(",");
            }
            llllllllllllllIllIIIIllIlllllIIl.append(this.flatLayers.get(llllllllllllllIllIIIIllIlllllIII));
        }
        llllllllllllllIllIIIIllIlllllIIl.append(";");
        llllllllllllllIllIIIIllIlllllIIl.append(this.biomeToUse);
        if (this.worldFeatures.isEmpty()) {
            llllllllllllllIllIIIIllIlllllIIl.append(";");
        }
        else {
            llllllllllllllIllIIIIllIlllllIIl.append(";");
            int llllllllllllllIllIIIIllIllllIlll = 0;
            for (final Map.Entry<String, Map<String, String>> llllllllllllllIllIIIIllIllllIllI : this.worldFeatures.entrySet()) {
                if (llllllllllllllIllIIIIllIllllIlll++ > 0) {
                    llllllllllllllIllIIIIllIlllllIIl.append(",");
                }
                llllllllllllllIllIIIIllIlllllIIl.append(llllllllllllllIllIIIIllIllllIllI.getKey().toLowerCase(Locale.ROOT));
                final Map<String, String> llllllllllllllIllIIIIllIllllIlIl = llllllllllllllIllIIIIllIllllIllI.getValue();
                if (!llllllllllllllIllIIIIllIllllIlIl.isEmpty()) {
                    llllllllllllllIllIIIIllIlllllIIl.append("(");
                    int llllllllllllllIllIIIIllIllllIlII = 0;
                    for (final Map.Entry<String, String> llllllllllllllIllIIIIllIllllIIll : llllllllllllllIllIIIIllIllllIlIl.entrySet()) {
                        if (llllllllllllllIllIIIIllIllllIlII++ > 0) {
                            llllllllllllllIllIIIIllIlllllIIl.append(" ");
                        }
                        llllllllllllllIllIIIIllIlllllIIl.append(llllllllllllllIllIIIIllIllllIIll.getKey());
                        llllllllllllllIllIIIIllIlllllIIl.append("=");
                        llllllllllllllIllIIIIllIlllllIIl.append(llllllllllllllIllIIIIllIllllIIll.getValue());
                    }
                    llllllllllllllIllIIIIllIlllllIIl.append(")");
                }
            }
        }
        return String.valueOf(llllllllllllllIllIIIIllIlllllIIl);
    }
    
    public FlatGeneratorInfo() {
        this.flatLayers = (List<FlatLayerInfo>)Lists.newArrayList();
        this.worldFeatures = (Map<String, Map<String, String>>)Maps.newHashMap();
    }
    
    public int getBiome() {
        return this.biomeToUse;
    }
    
    public void updateLayers() {
        int llllllllllllllIllIIIIlllIIIIlIIl = 0;
        for (final FlatLayerInfo llllllllllllllIllIIIIlllIIIIlIII : this.flatLayers) {
            llllllllllllllIllIIIIlllIIIIlIII.setMinY(llllllllllllllIllIIIIlllIIIIlIIl);
            llllllllllllllIllIIIIlllIIIIlIIl += llllllllllllllIllIIIIlllIIIIlIII.getLayerCount();
        }
    }
}
