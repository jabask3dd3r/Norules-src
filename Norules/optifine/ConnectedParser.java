package optifine;

import net.minecraft.world.biome.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import java.lang.reflect.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import java.util.*;

public class ConnectedParser
{
    private /* synthetic */ String context;
    
    public Enum parseEnum(final String llllllllllllllIIIlIlIIIIIIIIIlll, final Enum[] llllllllllllllIIIlIlIIIIIIIIllIl, final String llllllllllllllIIIlIlIIIIIIIIIlIl) {
        if (llllllllllllllIIIlIlIIIIIIIIIlll == null) {
            return null;
        }
        final String llllllllllllllIIIlIlIIIIIIIIlIll = llllllllllllllIIIlIlIIIIIIIIIlll.toLowerCase().trim();
        for (int llllllllllllllIIIlIlIIIIIIIIlIlI = 0; llllllllllllllIIIlIlIIIIIIIIlIlI < llllllllllllllIIIlIlIIIIIIIIllIl.length; ++llllllllllllllIIIlIlIIIIIIIIlIlI) {
            final Enum llllllllllllllIIIlIlIIIIIIIIlIIl = llllllllllllllIIIlIlIIIIIIIIllIl[llllllllllllllIIIlIlIIIIIIIIlIlI];
            if (llllllllllllllIIIlIlIIIIIIIIlIIl.name().toLowerCase().equals(llllllllllllllIIIlIlIIIIIIIIlIll)) {
                return llllllllllllllIIIlIlIIIIIIIIlIIl;
            }
        }
        this.warn(String.valueOf(new StringBuilder("Invalid ").append(llllllllllllllIIIlIlIIIIIIIIIlIl).append(": ").append(llllllllllllllIIIlIlIIIIIIIIIlll)));
        return null;
    }
    
    public String parseName(final String llllllllllllllIIIlIlIIlIIIIIIllI) {
        String llllllllllllllIIIlIlIIlIIIIIIlIl = llllllllllllllIIIlIlIIlIIIIIIllI;
        final int llllllllllllllIIIlIlIIlIIIIIIlII = llllllllllllllIIIlIlIIlIIIIIIllI.lastIndexOf(47);
        if (llllllllllllllIIIlIlIIlIIIIIIlII >= 0) {
            llllllllllllllIIIlIlIIlIIIIIIlIl = llllllllllllllIIIlIlIIlIIIIIIllI.substring(llllllllllllllIIIlIlIIlIIIIIIlII + 1);
        }
        final int llllllllllllllIIIlIlIIlIIIIIIIll = llllllllllllllIIIlIlIIlIIIIIIlIl.lastIndexOf(46);
        if (llllllllllllllIIIlIlIIlIIIIIIIll >= 0) {
            llllllllllllllIIIlIlIIlIIIIIIlIl = llllllllllllllIIIlIlIIlIIIIIIlIl.substring(0, llllllllllllllIIIlIlIIlIIIIIIIll);
        }
        return llllllllllllllIIIlIlIIlIIIIIIlIl;
    }
    
    public boolean startsWithDigit(final String llllllllllllllIIIlIlIIIllIIlIllI) {
        if (llllllllllllllIIIlIlIIIllIIlIllI == null) {
            return false;
        }
        if (llllllllllllllIIIlIlIIIllIIlIllI.length() < 1) {
            return false;
        }
        final char llllllllllllllIIIlIlIIIllIIlIlIl = llllllllllllllIIIlIlIIIllIIlIllI.charAt(0);
        return Character.isDigit(llllllllllllllIIIlIlIIIllIIlIlIl);
    }
    
    public boolean isFullBlockName(final String[] llllllllllllllIIIlIlIIIllIIllIll) {
        if (llllllllllllllIIIlIlIIIllIIllIll.length < 2) {
            return false;
        }
        final String llllllllllllllIIIlIlIIIllIIlllIl = llllllllllllllIIIlIlIIIllIIllIll[1];
        return llllllllllllllIIIlIlIIIllIIlllIl.length() >= 1 && !this.startsWithDigit(llllllllllllllIIIlIlIIIllIIlllIl) && !llllllllllllllIIIlIlIIIllIIlllIl.contains("=");
    }
    
    public Biome findBiome(String llllllllllllllIIIlIlIIIIllIlIIII) {
        llllllllllllllIIIlIlIIIIllIlIIII = llllllllllllllIIIlIlIIIIllIlIIII.toLowerCase();
        if (llllllllllllllIIIlIlIIIIllIlIIII.equals("nether")) {
            return Biomes.HELL;
        }
        for (final ResourceLocation llllllllllllllIIIlIlIIIIllIlIIll : Biome.REGISTRY.getKeys()) {
            final Biome llllllllllllllIIIlIlIIIIllIlIIlI = Biome.REGISTRY.getObject(llllllllllllllIIIlIlIIIIllIlIIll);
            if (llllllllllllllIIIlIlIIIIllIlIIlI != null) {
                final String llllllllllllllIIIlIlIIIIllIlIIIl = llllllllllllllIIIlIlIIIIllIlIIlI.getBiomeName().replace(" ", "").toLowerCase();
                if (llllllllllllllIIIlIlIIIIllIlIIIl.equals(llllllllllllllIIIlIlIIIIllIlIIII)) {
                    return llllllllllllllIIIlIlIIIIllIlIIlI;
                }
                continue;
            }
        }
        return null;
    }
    
    public static Comparable parsePropertyValue(final IProperty llllllllllllllIIIlIlIIIlIIlIIIlI, final String llllllllllllllIIIlIlIIIlIIlIIllI) {
        final Class llllllllllllllIIIlIlIIIlIIlIIlIl = llllllllllllllIIIlIlIIIlIIlIIIlI.getValueClass();
        Comparable llllllllllllllIIIlIlIIIlIIlIIlII = parseValue(llllllllllllllIIIlIlIIIlIIlIIllI, llllllllllllllIIIlIlIIIlIIlIIlIl);
        if (llllllllllllllIIIlIlIIIlIIlIIlII == null) {
            final Collection llllllllllllllIIIlIlIIIlIIlIIIll = llllllllllllllIIIlIlIIIlIIlIIIlI.getAllowedValues();
            llllllllllllllIIIlIlIIIlIIlIIlII = getPropertyValue(llllllllllllllIIIlIlIIIlIIlIIllI, llllllllllllllIIIlIlIIIlIIlIIIll);
        }
        return llllllllllllllIIIlIlIIIlIIlIIlII;
    }
    
    public int[] parseBlockMetadatas(final Block llllllllllllllIIIlIlIIIlIlIIlIll, final String[] llllllllllllllIIIlIlIIIlIlIIlIlI) {
        if (llllllllllllllIIIlIlIIIlIlIIlIlI.length <= 0) {
            return null;
        }
        final String llllllllllllllIIIlIlIIIlIllIIIlI = llllllllllllllIIIlIlIIIlIlIIlIlI[0];
        if (this.startsWithDigit(llllllllllllllIIIlIlIIIlIllIIIlI)) {
            final int[] llllllllllllllIIIlIlIIIlIllIIIIl = this.parseIntList(llllllllllllllIIIlIlIIIlIllIIIlI);
            return llllllllllllllIIIlIlIIIlIllIIIIl;
        }
        final IBlockState llllllllllllllIIIlIlIIIlIllIIIII = llllllllllllllIIIlIlIIIlIlIIlIll.getDefaultState();
        final Collection llllllllllllllIIIlIlIIIlIlIlllll = llllllllllllllIIIlIlIIIlIllIIIII.getPropertyNames();
        final Map<IProperty, List<Comparable>> llllllllllllllIIIlIlIIIlIlIllllI = new HashMap<IProperty, List<Comparable>>();
        for (int llllllllllllllIIIlIlIIIlIlIlllIl = 0; llllllllllllllIIIlIlIIIlIlIlllIl < llllllllllllllIIIlIlIIIlIlIIlIlI.length; ++llllllllllllllIIIlIlIIIlIlIlllIl) {
            final String llllllllllllllIIIlIlIIIlIlIlllII = llllllllllllllIIIlIlIIIlIlIIlIlI[llllllllllllllIIIlIlIIIlIlIlllIl];
            if (llllllllllllllIIIlIlIIIlIlIlllII.length() > 0) {
                final String[] llllllllllllllIIIlIlIIIlIlIllIll = Config.tokenize(llllllllllllllIIIlIlIIIlIlIlllII, "=");
                if (llllllllllllllIIIlIlIIIlIlIllIll.length != 2) {
                    this.warn(String.valueOf(new StringBuilder("Invalid block property: ").append(llllllllllllllIIIlIlIIIlIlIlllII)));
                    return null;
                }
                final String llllllllllllllIIIlIlIIIlIlIllIlI = llllllllllllllIIIlIlIIIlIlIllIll[0];
                final String llllllllllllllIIIlIlIIIlIlIllIIl = llllllllllllllIIIlIlIIIlIlIllIll[1];
                final IProperty llllllllllllllIIIlIlIIIlIlIllIII = ConnectedProperties.getProperty(llllllllllllllIIIlIlIIIlIlIllIlI, llllllllllllllIIIlIlIIIlIlIlllll);
                if (llllllllllllllIIIlIlIIIlIlIllIII == null) {
                    this.warn(String.valueOf(new StringBuilder("Property not found: ").append(llllllllllllllIIIlIlIIIlIlIllIlI).append(", block: ").append(llllllllllllllIIIlIlIIIlIlIIlIll)));
                    return null;
                }
                List<Comparable> llllllllllllllIIIlIlIIIlIlIlIlll = llllllllllllllIIIlIlIIIlIlIllllI.get(llllllllllllllIIIlIlIIIlIlIllIlI);
                if (llllllllllllllIIIlIlIIIlIlIlIlll == null) {
                    llllllllllllllIIIlIlIIIlIlIlIlll = new ArrayList<Comparable>();
                    llllllllllllllIIIlIlIIIlIlIllllI.put(llllllllllllllIIIlIlIIIlIlIllIII, llllllllllllllIIIlIlIIIlIlIlIlll);
                }
                final String[] llllllllllllllIIIlIlIIIlIlIlIllI = Config.tokenize(llllllllllllllIIIlIlIIIlIlIllIIl, ",");
                for (int llllllllllllllIIIlIlIIIlIlIlIlIl = 0; llllllllllllllIIIlIlIIIlIlIlIlIl < llllllllllllllIIIlIlIIIlIlIlIllI.length; ++llllllllllllllIIIlIlIIIlIlIlIlIl) {
                    final String llllllllllllllIIIlIlIIIlIlIlIlII = llllllllllllllIIIlIlIIIlIlIlIllI[llllllllllllllIIIlIlIIIlIlIlIlIl];
                    final Comparable llllllllllllllIIIlIlIIIlIlIlIIll = parsePropertyValue(llllllllllllllIIIlIlIIIlIlIllIII, llllllllllllllIIIlIlIIIlIlIlIlII);
                    if (llllllllllllllIIIlIlIIIlIlIlIIll == null) {
                        this.warn(String.valueOf(new StringBuilder("Property value not found: ").append(llllllllllllllIIIlIlIIIlIlIlIlII).append(", property: ").append(llllllllllllllIIIlIlIIIlIlIllIlI).append(", block: ").append(llllllllllllllIIIlIlIIIlIlIIlIll)));
                        return null;
                    }
                    llllllllllllllIIIlIlIIIlIlIlIlll.add(llllllllllllllIIIlIlIIIlIlIlIIll);
                }
            }
        }
        if (llllllllllllllIIIlIlIIIlIlIllllI.isEmpty()) {
            return null;
        }
        final List llllllllllllllIIIlIlIIIlIlIlIIlI = new ArrayList();
        for (int llllllllllllllIIIlIlIIIlIlIlIIIl = 0; llllllllllllllIIIlIlIIIlIlIlIIIl < 16; ++llllllllllllllIIIlIlIIIlIlIlIIIl) {
            final int llllllllllllllIIIlIlIIIlIlIlIIII = llllllllllllllIIIlIlIIIlIlIlIIIl;
            try {
                final IBlockState llllllllllllllIIIlIlIIIlIlIIllll = this.getStateFromMeta(llllllllllllllIIIlIlIIIlIlIIlIll, llllllllllllllIIIlIlIIIlIlIlIIII);
                if (this.matchState(llllllllllllllIIIlIlIIIlIlIIllll, llllllllllllllIIIlIlIIIlIlIllllI)) {
                    llllllllllllllIIIlIlIIIlIlIlIIlI.add(llllllllllllllIIIlIlIIIlIlIlIIII);
                }
            }
            catch (IllegalArgumentException ex) {}
        }
        if (llllllllllllllIIIlIlIIIlIlIlIIlI.size() == 16) {
            return null;
        }
        final int[] llllllllllllllIIIlIlIIIlIlIIlllI = new int[llllllllllllllIIIlIlIIIlIlIlIIlI.size()];
        for (int llllllllllllllIIIlIlIIIlIlIIllIl = 0; llllllllllllllIIIlIlIIIlIlIIllIl < llllllllllllllIIIlIlIIIlIlIIlllI.length; ++llllllllllllllIIIlIlIIIlIlIIllIl) {
            llllllllllllllIIIlIlIIIlIlIIlllI[llllllllllllllIIIlIlIIIlIlIIllIl] = llllllllllllllIIIlIlIIIlIlIlIIlI.get(llllllllllllllIIIlIlIIIlIlIIllIl);
        }
        return llllllllllllllIIIlIlIIIlIlIIlllI;
    }
    
    public int parseInt(String llllllllllllllIIIlIlIIIIllIIIlll) {
        if (llllllllllllllIIIlIlIIIIllIIIlll == null) {
            return -1;
        }
        llllllllllllllIIIlIlIIIIllIIIlll = llllllllllllllIIIlIlIIIIllIIIlll.trim();
        final int llllllllllllllIIIlIlIIIIllIIIllI = Config.parseInt(llllllllllllllIIIlIlIIIIllIIIlll, -1);
        if (llllllllllllllIIIlIlIIIIllIIIllI < 0) {
            this.warn(String.valueOf(new StringBuilder("Invalid number: ").append(llllllllllllllIIIlIlIIIIllIIIlll)));
        }
        return llllllllllllllIIIlIlIIIIllIIIllI;
    }
    
    public MatchBlock[] parseMatchBlocks(final String llllllllllllllIIIlIlIIIllllIIlll) {
        if (llllllllllllllIIIlIlIIIllllIIlll == null) {
            return null;
        }
        final List llllllllllllllIIIlIlIIIllllIlllI = new ArrayList();
        final String[] llllllllllllllIIIlIlIIIllllIllIl = Config.tokenize(llllllllllllllIIIlIlIIIllllIIlll, " ");
        for (int llllllllllllllIIIlIlIIIllllIllII = 0; llllllllllllllIIIlIlIIIllllIllII < llllllllllllllIIIlIlIIIllllIllIl.length; ++llllllllllllllIIIlIlIIIllllIllII) {
            final String llllllllllllllIIIlIlIIIllllIlIll = llllllllllllllIIIlIlIIIllllIllIl[llllllllllllllIIIlIlIIIllllIllII];
            final MatchBlock[] llllllllllllllIIIlIlIIIllllIlIlI = this.parseMatchBlock(llllllllllllllIIIlIlIIIllllIlIll);
            if (llllllllllllllIIIlIlIIIllllIlIlI != null) {
                llllllllllllllIIIlIlIIIllllIlllI.addAll(Arrays.asList(llllllllllllllIIIlIlIIIllllIlIlI));
            }
        }
        final MatchBlock[] llllllllllllllIIIlIlIIIllllIlIIl = llllllllllllllIIIlIlIIIllllIlllI.toArray(new MatchBlock[llllllllllllllIIIlIlIIIllllIlllI.size()]);
        return llllllllllllllIIIlIlIIIllllIlIIl;
    }
    
    public MatchBlock[] parseMatchBlock(String llllllllllllllIIIlIlIIIllIllllIl) {
        if (llllllllllllllIIIlIlIIIllIllllIl == null) {
            return null;
        }
        llllllllllllllIIIlIlIIIllIllllIl = llllllllllllllIIIlIlIIIllIllllIl.trim();
        if (llllllllllllllIIIlIlIIIllIllllIl.length() <= 0) {
            return null;
        }
        final String[] llllllllllllllIIIlIlIIIllIllllII = Config.tokenize(llllllllllllllIIIlIlIIIllIllllIl, ":");
        String llllllllllllllIIIlIlIIIllIlllIll = "minecraft";
        int llllllllllllllIIIlIlIIIllIlllIlI = 0;
        if (llllllllllllllIIIlIlIIIllIllllII.length > 1 && this.isFullBlockName(llllllllllllllIIIlIlIIIllIllllII)) {
            llllllllllllllIIIlIlIIIllIlllIll = llllllllllllllIIIlIlIIIllIllllII[0];
            llllllllllllllIIIlIlIIIllIlllIlI = 1;
        }
        else {
            llllllllllllllIIIlIlIIIllIlllIll = "minecraft";
            llllllllllllllIIIlIlIIIllIlllIlI = 0;
        }
        final String llllllllllllllIIIlIlIIIllIlllIIl = llllllllllllllIIIlIlIIIllIllllII[llllllllllllllIIIlIlIIIllIlllIlI];
        final String[] llllllllllllllIIIlIlIIIllIlllIII = Arrays.copyOfRange(llllllllllllllIIIlIlIIIllIllllII, llllllllllllllIIIlIlIIIllIlllIlI + 1, llllllllllllllIIIlIlIIIllIllllII.length);
        final Block[] llllllllllllllIIIlIlIIIllIllIlll = this.parseBlockPart(llllllllllllllIIIlIlIIIllIlllIll, llllllllllllllIIIlIlIIIllIlllIIl);
        if (llllllllllllllIIIlIlIIIllIllIlll == null) {
            return null;
        }
        final MatchBlock[] llllllllllllllIIIlIlIIIllIllIllI = new MatchBlock[llllllllllllllIIIlIlIIIllIllIlll.length];
        for (int llllllllllllllIIIlIlIIIllIllIlIl = 0; llllllllllllllIIIlIlIIIllIllIlIl < llllllllllllllIIIlIlIIIllIllIlll.length; ++llllllllllllllIIIlIlIIIllIllIlIl) {
            final Block llllllllllllllIIIlIlIIIllIllIlII = llllllllllllllIIIlIlIIIllIllIlll[llllllllllllllIIIlIlIIIllIllIlIl];
            final int llllllllllllllIIIlIlIIIllIllIIll = Block.getIdFromBlock(llllllllllllllIIIlIlIIIllIllIlII);
            int[] llllllllllllllIIIlIlIIIllIllIIlI = null;
            if (llllllllllllllIIIlIlIIIllIlllIII.length > 0) {
                llllllllllllllIIIlIlIIIllIllIIlI = this.parseBlockMetadatas(llllllllllllllIIIlIlIIIllIllIlII, llllllllllllllIIIlIlIIIllIlllIII);
                if (llllllllllllllIIIlIlIIIllIllIIlI == null) {
                    return null;
                }
            }
            final MatchBlock llllllllllllllIIIlIlIIIllIllIIIl = new MatchBlock(llllllllllllllIIIlIlIIIllIllIIll, llllllllllllllIIIlIlIIIllIllIIlI);
            llllllllllllllIIIlIlIIIllIllIllI[llllllllllllllIIIlIlIIIllIllIlIl] = llllllllllllllIIIlIlIIIllIllIIIl;
        }
        return llllllllllllllIIIlIlIIIllIllIllI;
    }
    
    public Block[] parseBlockPart(final String llllllllllllllIIIlIlIIIllIIIlIIl, final String llllllllllllllIIIlIlIIIlIlllllIl) {
        if (this.startsWithDigit(llllllllllllllIIIlIlIIIlIlllllIl)) {
            final int[] llllllllllllllIIIlIlIIIllIIIIlll = this.parseIntList(llllllllllllllIIIlIlIIIlIlllllIl);
            if (llllllllllllllIIIlIlIIIllIIIIlll == null) {
                return null;
            }
            final Block[] llllllllllllllIIIlIlIIIllIIIIllI = new Block[llllllllllllllIIIlIlIIIllIIIIlll.length];
            for (int llllllllllllllIIIlIlIIIllIIIIlIl = 0; llllllllllllllIIIlIlIIIllIIIIlIl < llllllllllllllIIIlIlIIIllIIIIlll.length; ++llllllllllllllIIIlIlIIIllIIIIlIl) {
                final int llllllllllllllIIIlIlIIIllIIIIlII = llllllllllllllIIIlIlIIIllIIIIlll[llllllllllllllIIIlIlIIIllIIIIlIl];
                final Block llllllllllllllIIIlIlIIIllIIIIIll = Block.getBlockById(llllllllllllllIIIlIlIIIllIIIIlII);
                if (llllllllllllllIIIlIlIIIllIIIIIll == null) {
                    this.warn(String.valueOf(new StringBuilder("Block not found for id: ").append(llllllllllllllIIIlIlIIIllIIIIlII)));
                    return null;
                }
                llllllllllllllIIIlIlIIIllIIIIllI[llllllllllllllIIIlIlIIIllIIIIlIl] = llllllllllllllIIIlIlIIIllIIIIIll;
            }
            return llllllllllllllIIIlIlIIIllIIIIllI;
        }
        else {
            final String llllllllllllllIIIlIlIIIllIIIIIlI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIlIlIIIllIIIlIIl)).append(":").append(llllllllllllllIIIlIlIIIlIlllllIl));
            final Block llllllllllllllIIIlIlIIIllIIIIIIl = Block.getBlockFromName(llllllllllllllIIIlIlIIIllIIIIIlI);
            if (llllllllllllllIIIlIlIIIllIIIIIIl == null) {
                this.warn(String.valueOf(new StringBuilder("Block not found for name: ").append(llllllllllllllIIIlIlIIIllIIIIIlI)));
                return null;
            }
            final Block[] llllllllllllllIIIlIlIIIllIIIIIII = { llllllllllllllIIIlIlIIIllIIIIIIl };
            return llllllllllllllIIIlIlIIIllIIIIIII;
        }
    }
    
    public static int parseColor(String llllllllllllllIIIlIlIIIIIIllIlll, final int llllllllllllllIIIlIlIIIIIIllIIlI) {
        if (llllllllllllllIIIlIlIIIIIIllIlll == null) {
            return llllllllllllllIIIlIlIIIIIIllIIlI;
        }
        llllllllllllllIIIlIlIIIIIIllIlll = llllllllllllllIIIlIlIIIIIIllIlll.trim();
        try {
            final int llllllllllllllIIIlIlIIIIIIllIlIl = Integer.parseInt(llllllllllllllIIIlIlIIIIIIllIlll, 16) & 0xFFFFFF;
            return llllllllllllllIIIlIlIIIIIIllIlIl;
        }
        catch (NumberFormatException llllllllllllllIIIlIlIIIIIIllIlII) {
            return llllllllllllllIIIlIlIIIIIIllIIlI;
        }
    }
    
    public Enum[] parseEnums(String llllllllllllllIIIlIIlllllllIllII, final Enum[] llllllllllllllIIIlIIllllllllIlIl, final String llllllllllllllIIIlIIlllllllIlIlI, final Enum[] llllllllllllllIIIlIIlllllllIlIIl) {
        if (llllllllllllllIIIlIIlllllllIllII == null) {
            return null;
        }
        llllllllllllllIIIlIIlllllllIllII = llllllllllllllIIIlIIlllllllIllII.toLowerCase().trim();
        final String[] llllllllllllllIIIlIIllllllllIIlI = Config.tokenize(llllllllllllllIIIlIIlllllllIllII, " ");
        final Enum[] llllllllllllllIIIlIIllllllllIIIl = (Enum[])Array.newInstance(llllllllllllllIIIlIIllllllllIlIl.getClass().getComponentType(), llllllllllllllIIIlIIllllllllIIlI.length);
        for (int llllllllllllllIIIlIIllllllllIIII = 0; llllllllllllllIIIlIIllllllllIIII < llllllllllllllIIIlIIllllllllIIlI.length; ++llllllllllllllIIIlIIllllllllIIII) {
            final String llllllllllllllIIIlIIlllllllIllll = llllllllllllllIIIlIIllllllllIIlI[llllllllllllllIIIlIIllllllllIIII];
            final Enum llllllllllllllIIIlIIlllllllIlllI = this.parseEnum(llllllllllllllIIIlIIlllllllIllll, llllllllllllllIIIlIIllllllllIlIl, llllllllllllllIIIlIIlllllllIlIlI);
            if (llllllllllllllIIIlIIlllllllIlllI == null) {
                return llllllllllllllIIIlIIlllllllIlIIl;
            }
            llllllllllllllIIIlIIllllllllIIIl[llllllllllllllIIIlIIllllllllIIII] = llllllllllllllIIIlIIlllllllIlllI;
        }
        return llllllllllllllIIIlIIllllllllIIIl;
    }
    
    public ConnectedParser(final String llllllllllllllIIIlIlIIlIIIIIlllI) {
        this.context = null;
        this.context = llllllllllllllIIIlIlIIlIIIIIlllI;
    }
    
    public void warn(final String llllllllllllllIIIlIlIIIIIllIlllI) {
        Config.warn(String.valueOf(new StringBuilder().append(this.context).append(": ").append(llllllllllllllIIIlIlIIIIIllIlllI)));
    }
    
    public String parseBasePath(final String llllllllllllllIIIlIlIIIllllllIIl) {
        final int llllllllllllllIIIlIlIIIllllllIlI = llllllllllllllIIIlIlIIIllllllIIl.lastIndexOf(47);
        return (llllllllllllllIIIlIlIIIllllllIlI < 0) ? "" : llllllllllllllIIIlIlIIIllllllIIl.substring(0, llllllllllllllIIIlIlIIIllllllIlI);
    }
    
    private IBlockState getStateFromMeta(final Block llllllllllllllIIIlIlIIIlIIllIlIl, final int llllllllllllllIIIlIlIIIlIIlIllll) {
        try {
            IBlockState llllllllllllllIIIlIlIIIlIIllIIll = llllllllllllllIIIlIlIIIlIIllIlIl.getStateFromMeta(llllllllllllllIIIlIlIIIlIIlIllll);
            if (llllllllllllllIIIlIlIIIlIIllIlIl == Blocks.DOUBLE_PLANT && llllllllllllllIIIlIlIIIlIIlIllll > 7) {
                final IBlockState llllllllllllllIIIlIlIIIlIIllIIlI = llllllllllllllIIIlIlIIIlIIllIlIl.getStateFromMeta(llllllllllllllIIIlIlIIIlIIlIllll & 0x7);
                llllllllllllllIIIlIlIIIlIIllIIll = llllllllllllllIIIlIlIIIlIIllIIll.withProperty(BlockDoublePlant.VARIANT, (BlockDoublePlant.EnumPlantType)llllllllllllllIIIlIlIIIlIIllIIlI.getValue((IProperty<V>)BlockDoublePlant.VARIANT));
            }
            if (llllllllllllllIIIlIlIIIlIIllIlIl == Blocks.field_190976_dk && (llllllllllllllIIIlIlIIIlIIlIllll & 0x8) != 0x0) {
                llllllllllllllIIIlIlIIIlIIllIIll = llllllllllllllIIIlIlIIIlIIllIIll.withProperty((IProperty<Comparable>)BlockObserver.field_190963_a, true);
            }
            return llllllllllllllIIIlIlIIIlIIllIIll;
        }
        catch (IllegalArgumentException llllllllllllllIIIlIlIIIlIIllIIIl) {
            return llllllllllllllIIIlIlIIIlIIllIlIl.getDefaultState();
        }
    }
    
    public RangeListInt parseRangeListInt(final String llllllllllllllIIIlIlIIIIIlIlllII) {
        if (llllllllllllllIIIlIlIIIIIlIlllII == null) {
            return null;
        }
        final RangeListInt llllllllllllllIIIlIlIIIIIllIIIlI = new RangeListInt();
        final String[] llllllllllllllIIIlIlIIIIIllIIIIl = Config.tokenize(llllllllllllllIIIlIlIIIIIlIlllII, " ,");
        for (int llllllllllllllIIIlIlIIIIIllIIIII = 0; llllllllllllllIIIlIlIIIIIllIIIII < llllllllllllllIIIlIlIIIIIllIIIIl.length; ++llllllllllllllIIIlIlIIIIIllIIIII) {
            final String llllllllllllllIIIlIlIIIIIlIlllll = llllllllllllllIIIlIlIIIIIllIIIIl[llllllllllllllIIIlIlIIIIIllIIIII];
            final RangeInt llllllllllllllIIIlIlIIIIIlIllllI = this.parseRangeInt(llllllllllllllIIIlIlIIIIIlIlllll);
            if (llllllllllllllIIIlIlIIIIIlIllllI == null) {
                return null;
            }
            llllllllllllllIIIlIlIIIIIllIIIlI.addRange(llllllllllllllIIIlIlIIIIIlIllllI);
        }
        return llllllllllllllIIIlIlIIIIIllIIIlI;
    }
    
    public BlockRenderLayer parseBlockRenderLayer(String llllllllllllllIIIlIlIIIIIIlIIIII, final BlockRenderLayer llllllllllllllIIIlIlIIIIIIIlllll) {
        if (llllllllllllllIIIlIlIIIIIIlIIIII == null) {
            return llllllllllllllIIIlIlIIIIIIIlllll;
        }
        llllllllllllllIIIlIlIIIIIIlIIIII = llllllllllllllIIIlIlIIIIIIlIIIII.toLowerCase().trim();
        final BlockRenderLayer[] llllllllllllllIIIlIlIIIIIIIllllI = BlockRenderLayer.values();
        for (int llllllllllllllIIIlIlIIIIIIIlllIl = 0; llllllllllllllIIIlIlIIIIIIIlllIl < llllllllllllllIIIlIlIIIIIIIllllI.length; ++llllllllllllllIIIlIlIIIIIIIlllIl) {
            final BlockRenderLayer llllllllllllllIIIlIlIIIIIIIlllII = llllllllllllllIIIlIlIIIIIIIllllI[llllllllllllllIIIlIlIIIIIIIlllIl];
            if (llllllllllllllIIIlIlIIIIIIlIIIII.equals(llllllllllllllIIIlIlIIIIIIIlllII.name().toLowerCase())) {
                return llllllllllllllIIIlIlIIIIIIIlllII;
            }
        }
        return llllllllllllllIIIlIlIIIIIIIlllll;
    }
    
    public static boolean parseBoolean(final String llllllllllllllIIIlIlIIIIIlIIIlII) {
        return llllllllllllllIIIlIlIIIIIlIIIlII != null && llllllllllllllIIIlIlIIIIIlIIIlII.trim().toLowerCase().equals("true");
    }
    
    public Biome[] parseBiomes(String llllllllllllllIIIlIlIIIIlllIIIIl) {
        if (llllllllllllllIIIlIlIIIIlllIIIIl == null) {
            return null;
        }
        llllllllllllllIIIlIlIIIIlllIIIIl = llllllllllllllIIIlIlIIIIlllIIIIl.trim();
        boolean llllllllllllllIIIlIlIIIIlllIlIlI = false;
        if (llllllllllllllIIIlIlIIIIlllIIIIl.startsWith("!")) {
            llllllllllllllIIIlIlIIIIlllIlIlI = true;
            llllllllllllllIIIlIlIIIIlllIIIIl = llllllllllllllIIIlIlIIIIlllIIIIl.substring(1);
        }
        final String[] llllllllllllllIIIlIlIIIIlllIlIIl = Config.tokenize(llllllllllllllIIIlIlIIIIlllIIIIl, " ");
        List llllllllllllllIIIlIlIIIIlllIlIII = new ArrayList();
        for (int llllllllllllllIIIlIlIIIIlllIIlll = 0; llllllllllllllIIIlIlIIIIlllIIlll < llllllllllllllIIIlIlIIIIlllIlIIl.length; ++llllllllllllllIIIlIlIIIIlllIIlll) {
            final String llllllllllllllIIIlIlIIIIlllIIllI = llllllllllllllIIIlIlIIIIlllIlIIl[llllllllllllllIIIlIlIIIIlllIIlll];
            final Biome llllllllllllllIIIlIlIIIIlllIIlIl = this.findBiome(llllllllllllllIIIlIlIIIIlllIIllI);
            if (llllllllllllllIIIlIlIIIIlllIIlIl == null) {
                this.warn(String.valueOf(new StringBuilder("Biome not found: ").append(llllllllllllllIIIlIlIIIIlllIIllI)));
            }
            else {
                llllllllllllllIIIlIlIIIIlllIlIII.add(llllllllllllllIIIlIlIIIIlllIIlIl);
            }
        }
        if (llllllllllllllIIIlIlIIIIlllIlIlI) {
            final List<Biome> llllllllllllllIIIlIlIIIIlllIIlII = (List<Biome>)Lists.newArrayList((Iterator)Biome.REGISTRY.iterator());
            llllllllllllllIIIlIlIIIIlllIIlII.removeAll(llllllllllllllIIIlIlIIIIlllIlIII);
            llllllllllllllIIIlIlIIIIlllIlIII = llllllllllllllIIIlIlIIIIlllIIlII;
        }
        final Biome[] llllllllllllllIIIlIlIIIIlllIIIll = llllllllllllllIIIlIlIIIIlllIlIII.toArray(new Biome[llllllllllllllIIIlIlIIIIlllIlIII.size()]);
        return llllllllllllllIIIlIlIIIIlllIIIll;
    }
    
    public static Comparable parseValue(final String llllllllllllllIIIlIlIIIlIIIIlIlI, final Class llllllllllllllIIIlIlIIIlIIIIlIIl) {
        if (llllllllllllllIIIlIlIIIlIIIIlIIl == String.class) {
            return llllllllllllllIIIlIlIIIlIIIIlIlI;
        }
        if (llllllllllllllIIIlIlIIIlIIIIlIIl == Boolean.class) {
            return Boolean.valueOf(llllllllllllllIIIlIlIIIlIIIIlIlI);
        }
        if (llllllllllllllIIIlIlIIIlIIIIlIIl == Float.class) {
            return Float.valueOf(llllllllllllllIIIlIlIIIlIIIIlIlI);
        }
        if (llllllllllllllIIIlIlIIIlIIIIlIIl == Double.class) {
            return Double.valueOf(llllllllllllllIIIlIlIIIlIIIIlIlI);
        }
        if (llllllllllllllIIIlIlIIIlIIIIlIIl == Integer.class) {
            return Integer.valueOf(llllllllllllllIIIlIlIIIlIIIIlIlI);
        }
        return (llllllllllllllIIIlIlIIIlIIIIlIIl == Long.class) ? Long.valueOf(llllllllllllllIIIlIlIIIlIIIIlIlI) : null;
    }
    
    public IBlockState parseBlockState(final String llllllllllllllIIIlIlIIIlllIlIIlI, final IBlockState llllllllllllllIIIlIlIIIlllIllIII) {
        final MatchBlock[] llllllllllllllIIIlIlIIIlllIlIlll = this.parseMatchBlock(llllllllllllllIIIlIlIIIlllIlIIlI);
        if (llllllllllllllIIIlIlIIIlllIlIlll == null) {
            return llllllllllllllIIIlIlIIIlllIllIII;
        }
        if (llllllllllllllIIIlIlIIIlllIlIlll.length != 1) {
            return llllllllllllllIIIlIlIIIlllIllIII;
        }
        final MatchBlock llllllllllllllIIIlIlIIIlllIlIllI = llllllllllllllIIIlIlIIIlllIlIlll[0];
        final int llllllllllllllIIIlIlIIIlllIlIlIl = llllllllllllllIIIlIlIIIlllIlIllI.getBlockId();
        final Block llllllllllllllIIIlIlIIIlllIlIlII = Block.getBlockById(llllllllllllllIIIlIlIIIlllIlIlIl);
        return llllllllllllllIIIlIlIIIlllIlIlII.getDefaultState();
    }
    
    public int[] parseIntList(final String llllllllllllllIIIlIlIIIIlIIllllI) {
        if (llllllllllllllIIIlIlIIIIlIIllllI == null) {
            return null;
        }
        final List llllllllllllllIIIlIlIIIIlIlIlIlI = new ArrayList();
        final String[] llllllllllllllIIIlIlIIIIlIlIlIIl = Config.tokenize(llllllllllllllIIIlIlIIIIlIIllllI, " ,");
        for (int llllllllllllllIIIlIlIIIIlIlIlIII = 0; llllllllllllllIIIlIlIIIIlIlIlIII < llllllllllllllIIIlIlIIIIlIlIlIIl.length; ++llllllllllllllIIIlIlIIIIlIlIlIII) {
            final String llllllllllllllIIIlIlIIIIlIlIIlll = llllllllllllllIIIlIlIIIIlIlIlIIl[llllllllllllllIIIlIlIIIIlIlIlIII];
            if (llllllllllllllIIIlIlIIIIlIlIIlll.contains("-")) {
                final String[] llllllllllllllIIIlIlIIIIlIlIIllI = Config.tokenize(llllllllllllllIIIlIlIIIIlIlIIlll, "-");
                if (llllllllllllllIIIlIlIIIIlIlIIllI.length != 2) {
                    this.warn(String.valueOf(new StringBuilder("Invalid interval: ").append(llllllllllllllIIIlIlIIIIlIlIIlll).append(", when parsing: ").append(llllllllllllllIIIlIlIIIIlIIllllI)));
                }
                else {
                    final int llllllllllllllIIIlIlIIIIlIlIIlIl = Config.parseInt(llllllllllllllIIIlIlIIIIlIlIIllI[0], -1);
                    final int llllllllllllllIIIlIlIIIIlIlIIlII = Config.parseInt(llllllllllllllIIIlIlIIIIlIlIIllI[1], -1);
                    if (llllllllllllllIIIlIlIIIIlIlIIlIl >= 0 && llllllllllllllIIIlIlIIIIlIlIIlII >= 0 && llllllllllllllIIIlIlIIIIlIlIIlIl <= llllllllllllllIIIlIlIIIIlIlIIlII) {
                        for (int llllllllllllllIIIlIlIIIIlIlIIIll = llllllllllllllIIIlIlIIIIlIlIIlIl; llllllllllllllIIIlIlIIIIlIlIIIll <= llllllllllllllIIIlIlIIIIlIlIIlII; ++llllllllllllllIIIlIlIIIIlIlIIIll) {
                            llllllllllllllIIIlIlIIIIlIlIlIlI.add(llllllllllllllIIIlIlIIIIlIlIIIll);
                        }
                    }
                    else {
                        this.warn(String.valueOf(new StringBuilder("Invalid interval: ").append(llllllllllllllIIIlIlIIIIlIlIIlll).append(", when parsing: ").append(llllllllllllllIIIlIlIIIIlIIllllI)));
                    }
                }
            }
            else {
                final int llllllllllllllIIIlIlIIIIlIlIIIlI = Config.parseInt(llllllllllllllIIIlIlIIIIlIlIIlll, -1);
                if (llllllllllllllIIIlIlIIIIlIlIIIlI < 0) {
                    this.warn(String.valueOf(new StringBuilder("Invalid number: ").append(llllllllllllllIIIlIlIIIIlIlIIlll).append(", when parsing: ").append(llllllllllllllIIIlIlIIIIlIIllllI)));
                }
                else {
                    llllllllllllllIIIlIlIIIIlIlIlIlI.add(llllllllllllllIIIlIlIIIIlIlIIIlI);
                }
            }
        }
        final int[] llllllllllllllIIIlIlIIIIlIlIIIIl = new int[llllllllllllllIIIlIlIIIIlIlIlIlI.size()];
        for (int llllllllllllllIIIlIlIIIIlIlIIIII = 0; llllllllllllllIIIlIlIIIIlIlIIIII < llllllllllllllIIIlIlIIIIlIlIIIIl.length; ++llllllllllllllIIIlIlIIIIlIlIIIII) {
            llllllllllllllIIIlIlIIIIlIlIIIIl[llllllllllllllIIIlIlIIIIlIlIIIII] = llllllllllllllIIIlIlIIIIlIlIlIlI.get(llllllllllllllIIIlIlIIIIlIlIIIII);
        }
        return llllllllllllllIIIlIlIIIIlIlIIIIl;
    }
    
    private RangeInt parseRangeInt(final String llllllllllllllIIIlIlIIIIIlIIlIlI) {
        if (llllllllllllllIIIlIlIIIIIlIIlIlI == null) {
            return null;
        }
        if (llllllllllllllIIIlIlIIIIIlIIlIlI.indexOf(45) >= 0) {
            final String[] llllllllllllllIIIlIlIIIIIlIIllll = Config.tokenize(llllllllllllllIIIlIlIIIIIlIIlIlI, "-");
            if (llllllllllllllIIIlIlIIIIIlIIllll.length != 2) {
                this.warn(String.valueOf(new StringBuilder("Invalid range: ").append(llllllllllllllIIIlIlIIIIIlIIlIlI)));
                return null;
            }
            final int llllllllllllllIIIlIlIIIIIlIIlllI = Config.parseInt(llllllllllllllIIIlIlIIIIIlIIllll[0], -1);
            final int llllllllllllllIIIlIlIIIIIlIIllIl = Config.parseInt(llllllllllllllIIIlIlIIIIIlIIllll[1], -1);
            if (llllllllllllllIIIlIlIIIIIlIIlllI >= 0 && llllllllllllllIIIlIlIIIIIlIIllIl >= 0) {
                return new RangeInt(llllllllllllllIIIlIlIIIIIlIIlllI, llllllllllllllIIIlIlIIIIIlIIllIl);
            }
            this.warn(String.valueOf(new StringBuilder("Invalid range: ").append(llllllllllllllIIIlIlIIIIIlIIlIlI)));
            return null;
        }
        else {
            final int llllllllllllllIIIlIlIIIIIlIIllII = Config.parseInt(llllllllllllllIIIlIlIIIIIlIIlIlI, -1);
            if (llllllllllllllIIIlIlIIIIIlIIllII < 0) {
                this.warn(String.valueOf(new StringBuilder("Invalid integer: ").append(llllllllllllllIIIlIlIIIIIlIIlIlI)));
                return null;
            }
            return new RangeInt(llllllllllllllIIIlIlIIIIIlIIllII, llllllllllllllIIIlIlIIIIIlIIllII);
        }
    }
    
    public boolean matchState(final IBlockState llllllllllllllIIIlIlIIIIlllllIlI, final Map<IProperty, List<Comparable>> llllllllllllllIIIlIlIIIIlllllIIl) {
        for (final IProperty llllllllllllllIIIlIlIIIIllllllIl : llllllllllllllIIIlIlIIIIlllllIIl.keySet()) {
            final List<Comparable> llllllllllllllIIIlIlIIIIllllllII = llllllllllllllIIIlIlIIIIlllllIIl.get(llllllllllllllIIIlIlIIIIllllllIl);
            final Comparable llllllllllllllIIIlIlIIIIlllllIll = llllllllllllllIIIlIlIIIIlllllIlI.getValue((IProperty<Comparable>)llllllllllllllIIIlIlIIIIllllllIl);
            if (llllllllllllllIIIlIlIIIIlllllIll == null) {
                return false;
            }
            if (!llllllllllllllIIIlIlIIIIllllllII.contains(llllllllllllllIIIlIlIIIIlllllIll)) {
                return false;
            }
        }
        return true;
    }
    
    public Boolean parseBooleanObject(final String llllllllllllllIIIlIlIIIIIIllllll) {
        if (llllllllllllllIIIlIlIIIIIIllllll == null) {
            return null;
        }
        final String llllllllllllllIIIlIlIIIIIIlllllI = llllllllllllllIIIlIlIIIIIIllllll.toLowerCase().trim();
        if (llllllllllllllIIIlIlIIIIIIlllllI.equals("true")) {
            return Boolean.TRUE;
        }
        if (llllllllllllllIIIlIlIIIIIIlllllI.equals("false")) {
            return Boolean.FALSE;
        }
        this.warn(String.valueOf(new StringBuilder("Invalid boolean: ").append(llllllllllllllIIIlIlIIIIIIllllll)));
        return null;
    }
    
    private static Object getValueName(final Comparable llllllllllllllIIIlIlIIIlIIIlIIII) {
        if (llllllllllllllIIIlIlIIIlIIIlIIII instanceof IStringSerializable) {
            final IStringSerializable llllllllllllllIIIlIlIIIlIIIIllll = (IStringSerializable)llllllllllllllIIIlIlIIIlIIIlIIII;
            return llllllllllllllIIIlIlIIIlIIIIllll.getName();
        }
        return llllllllllllllIIIlIlIIIlIIIlIIII.toString();
    }
    
    public static Comparable getPropertyValue(final String llllllllllllllIIIlIlIIIlIIIlIllI, final Collection llllllllllllllIIIlIlIIIlIIIllIII) {
        for (final Object llllllllllllllIIIlIlIIIlIIIlIlll : llllllllllllllIIIlIlIIIlIIIllIII) {
            if (getValueName((Comparable)llllllllllllllIIIlIlIIIlIIIlIlll).equals(llllllllllllllIIIlIlIIIlIIIlIllI)) {
                return (Comparable)llllllllllllllIIIlIlIIIlIIIlIlll;
            }
        }
        return null;
    }
    
    public EnumFacing parseFace(String llllllllllllllIIIlIlIIIIIllllIII) {
        llllllllllllllIIIlIlIIIIIllllIII = llllllllllllllIIIlIlIIIIIllllIII.toLowerCase();
        if (llllllllllllllIIIlIlIIIIIllllIII.equals("bottom") || llllllllllllllIIIlIlIIIIIllllIII.equals("down")) {
            return EnumFacing.DOWN;
        }
        if (llllllllllllllIIIlIlIIIIIllllIII.equals("top") || llllllllllllllIIIlIlIIIIIllllIII.equals("up")) {
            return EnumFacing.UP;
        }
        if (llllllllllllllIIIlIlIIIIIllllIII.equals("north")) {
            return EnumFacing.NORTH;
        }
        if (llllllllllllllIIIlIlIIIIIllllIII.equals("south")) {
            return EnumFacing.SOUTH;
        }
        if (llllllllllllllIIIlIlIIIIIllllIII.equals("east")) {
            return EnumFacing.EAST;
        }
        if (llllllllllllllIIIlIlIIIIIllllIII.equals("west")) {
            return EnumFacing.WEST;
        }
        Config.warn(String.valueOf(new StringBuilder("Unknown face: ").append(llllllllllllllIIIlIlIIIIIllllIII)));
        return null;
    }
    
    public boolean[] parseFaces(final String llllllllllllllIIIlIlIIIIlIIIIIlI, final boolean[] llllllllllllllIIIlIlIIIIlIIIIIIl) {
        if (llllllllllllllIIIlIlIIIIlIIIIIlI == null) {
            return llllllllllllllIIIlIlIIIIlIIIIIIl;
        }
        final EnumSet llllllllllllllIIIlIlIIIIlIIIlIlI = EnumSet.allOf(EnumFacing.class);
        final String[] llllllllllllllIIIlIlIIIIlIIIlIIl = Config.tokenize(llllllllllllllIIIlIlIIIIlIIIIIlI, " ,");
        for (int llllllllllllllIIIlIlIIIIlIIIlIII = 0; llllllllllllllIIIlIlIIIIlIIIlIII < llllllllllllllIIIlIlIIIIlIIIlIIl.length; ++llllllllllllllIIIlIlIIIIlIIIlIII) {
            final String llllllllllllllIIIlIlIIIIlIIIIlll = llllllllllllllIIIlIlIIIIlIIIlIIl[llllllllllllllIIIlIlIIIIlIIIlIII];
            if (llllllllllllllIIIlIlIIIIlIIIIlll.equals("sides")) {
                llllllllllllllIIIlIlIIIIlIIIlIlI.add(EnumFacing.NORTH);
                llllllllllllllIIIlIlIIIIlIIIlIlI.add(EnumFacing.SOUTH);
                llllllllllllllIIIlIlIIIIlIIIlIlI.add(EnumFacing.WEST);
                llllllllllllllIIIlIlIIIIlIIIlIlI.add(EnumFacing.EAST);
            }
            else if (llllllllllllllIIIlIlIIIIlIIIIlll.equals("all")) {
                llllllllllllllIIIlIlIIIIlIIIlIlI.addAll(Arrays.asList(EnumFacing.VALUES));
            }
            else {
                final EnumFacing llllllllllllllIIIlIlIIIIlIIIIllI = this.parseFace(llllllllllllllIIIlIlIIIIlIIIIlll);
                if (llllllllllllllIIIlIlIIIIlIIIIllI != null) {
                    llllllllllllllIIIlIlIIIIlIIIlIlI.add(llllllllllllllIIIlIlIIIIlIIIIllI);
                }
            }
        }
        final boolean[] llllllllllllllIIIlIlIIIIlIIIIlIl = new boolean[EnumFacing.VALUES.length];
        for (int llllllllllllllIIIlIlIIIIlIIIIlII = 0; llllllllllllllIIIlIlIIIIlIIIIlII < llllllllllllllIIIlIlIIIIlIIIIlIl.length; ++llllllllllllllIIIlIlIIIIlIIIIlII) {
            llllllllllllllIIIlIlIIIIlIIIIlIl[llllllllllllllIIIlIlIIIIlIIIIlII] = llllllllllllllIIIlIlIIIIlIIIlIlI.contains(EnumFacing.VALUES[llllllllllllllIIIlIlIIIIlIIIIlII]);
        }
        return llllllllllllllIIIlIlIIIIlIIIIlIl;
    }
    
    public void dbg(final String llllllllllllllIIIlIlIIIIIlllIlII) {
        Config.dbg(String.valueOf(new StringBuilder().append(this.context).append(": ").append(llllllllllllllIIIlIlIIIIIlllIlII)));
    }
    
    public int parseInt(String llllllllllllllIIIlIlIIIIlIlllIIl, final int llllllllllllllIIIlIlIIIIlIlllIII) {
        if (llllllllllllllIIIlIlIIIIlIlllIIl == null) {
            return llllllllllllllIIIlIlIIIIlIlllIII;
        }
        llllllllllllllIIIlIlIIIIlIlllIIl = llllllllllllllIIIlIlIIIIlIlllIIl.trim();
        final int llllllllllllllIIIlIlIIIIlIlllIll = Config.parseInt(llllllllllllllIIIlIlIIIIlIlllIIl, -1);
        if (llllllllllllllIIIlIlIIIIlIlllIll < 0) {
            this.warn(String.valueOf(new StringBuilder("Invalid number: ").append(llllllllllllllIIIlIlIIIIlIlllIIl)));
            return llllllllllllllIIIlIlIIIIlIlllIII;
        }
        return llllllllllllllIIIlIlIIIIlIlllIll;
    }
    
    public static int parseColor4(String llllllllllllllIIIlIlIIIIIIlIllIl, final int llllllllllllllIIIlIlIIIIIIlIlIII) {
        if (llllllllllllllIIIlIlIIIIIIlIllIl == null) {
            return llllllllllllllIIIlIlIIIIIIlIlIII;
        }
        llllllllllllllIIIlIlIIIIIIlIllIl = llllllllllllllIIIlIlIIIIIIlIllIl.trim();
        try {
            final int llllllllllllllIIIlIlIIIIIIlIlIll = (int)(Long.parseLong(llllllllllllllIIIlIlIIIIIIlIllIl, 16) & -1L);
            return llllllllllllllIIIlIlIIIIIIlIlIll;
        }
        catch (NumberFormatException llllllllllllllIIIlIlIIIIIIlIlIlI) {
            return llllllllllllllIIIlIlIIIIIIlIlIII;
        }
    }
}
