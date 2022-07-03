package optifine;

import net.minecraft.block.*;
import java.util.regex.*;
import net.minecraft.world.*;
import net.minecraft.world.biome.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;
import java.io.*;
import java.awt.image.*;
import java.util.*;
import net.minecraft.init.*;

public class CustomColormap implements CustomColors.IColorizer
{
    private /* synthetic */ int yOffset;
    public /* synthetic */ String basePath;
    private /* synthetic */ int color;
    private /* synthetic */ int format;
    private /* synthetic */ int height;
    private /* synthetic */ int yVariance;
    private /* synthetic */ String source;
    private /* synthetic */ int[] colors;
    public /* synthetic */ String name;
    private /* synthetic */ MatchBlock[] matchBlocks;
    private /* synthetic */ int width;
    private /* synthetic */ float[][] colorsRgb;
    
    private MatchBlock[] detectMatchBlocks() {
        final Block lllllllllllllllIIIIlIlllIlllllll = Block.getBlockFromName(this.name);
        if (lllllllllllllllIIIIlIlllIlllllll != null) {
            return new MatchBlock[] { new MatchBlock(Block.getIdFromBlock(lllllllllllllllIIIIlIlllIlllllll)) };
        }
        final Pattern lllllllllllllllIIIIlIlllIllllllI = Pattern.compile("^block([0-9]+).*$");
        final Matcher lllllllllllllllIIIIlIlllIlllllIl = lllllllllllllllIIIIlIlllIllllllI.matcher(this.name);
        if (lllllllllllllllIIIIlIlllIlllllIl.matches()) {
            final String lllllllllllllllIIIIlIlllIlllllII = lllllllllllllllIIIIlIlllIlllllIl.group(1);
            final int lllllllllllllllIIIIlIlllIllllIll = Config.parseInt(lllllllllllllllIIIIlIlllIlllllII, -1);
            if (lllllllllllllllIIIIlIlllIllllIll >= 0) {
                return new MatchBlock[] { new MatchBlock(lllllllllllllllIIIIlIlllIllllIll) };
            }
        }
        final ConnectedParser lllllllllllllllIIIIlIlllIllllIlI = new ConnectedParser("Colormap");
        final MatchBlock[] lllllllllllllllIIIIlIlllIllllIIl = lllllllllllllllIIIIlIlllIllllIlI.parseMatchBlock(this.name);
        return (MatchBlock[])((lllllllllllllllIIIIlIlllIllllIIl != null) ? lllllllllllllllIIIIlIlllIllllIIl : null);
    }
    
    @Override
    public int getColor(final IBlockState lllllllllllllllIIIIlIlllIIIlIIlI, final IBlockAccess lllllllllllllllIIIIlIlllIIIlIIIl, final BlockPos lllllllllllllllIIIIlIlllIIIlIIII) {
        return this.getColor(lllllllllllllllIIIIlIlllIIIlIIIl, lllllllllllllllIIIIlIlllIIIlIIII);
    }
    
    private static String parseTexture(String lllllllllllllllIIIIlIlllIlIIlIlI, final String lllllllllllllllIIIIlIlllIlIIlIIl, final String lllllllllllllllIIIIlIlllIlIIlIII) {
        if (lllllllllllllllIIIIlIlllIlIIlIlI != null) {
            lllllllllllllllIIIIlIlllIlIIlIlI = lllllllllllllllIIIIlIlllIlIIlIlI.trim();
            final String lllllllllllllllIIIIlIlllIlIIIlll = ".png";
            if (lllllllllllllllIIIIlIlllIlIIlIlI.endsWith(lllllllllllllllIIIIlIlllIlIIIlll)) {
                lllllllllllllllIIIIlIlllIlIIlIlI = lllllllllllllllIIIIlIlllIlIIlIlI.substring(0, lllllllllllllllIIIIlIlllIlIIlIlI.length() - lllllllllllllllIIIIlIlllIlIIIlll.length());
            }
            lllllllllllllllIIIIlIlllIlIIlIlI = fixTextureName(lllllllllllllllIIIIlIlllIlIIlIlI, lllllllllllllllIIIIlIlllIlIIlIII);
            return lllllllllllllllIIIIlIlllIlIIlIlI;
        }
        String lllllllllllllllIIIIlIlllIlIIIllI = lllllllllllllllIIIIlIlllIlIIlIIl;
        final int lllllllllllllllIIIIlIlllIlIIIlIl = lllllllllllllllIIIIlIlllIlIIlIIl.lastIndexOf(47);
        if (lllllllllllllllIIIIlIlllIlIIIlIl >= 0) {
            lllllllllllllllIIIIlIlllIlIIIllI = lllllllllllllllIIIIlIlllIlIIlIIl.substring(lllllllllllllllIIIIlIlllIlIIIlIl + 1);
        }
        final int lllllllllllllllIIIIlIlllIlIIIlII = lllllllllllllllIIIIlIlllIlIIIllI.lastIndexOf(46);
        if (lllllllllllllllIIIIlIlllIlIIIlII >= 0) {
            lllllllllllllllIIIIlIlllIlIIIllI = lllllllllllllllIIIIlIlllIlIIIllI.substring(0, lllllllllllllllIIIIlIlllIlIIIlII);
        }
        lllllllllllllllIIIIlIlllIlIIIllI = fixTextureName(lllllllllllllllIIIIlIlllIlIIIllI, lllllllllllllllIIIIlIlllIlIIlIII);
        return lllllllllllllllIIIIlIlllIlIIIllI;
    }
    
    public void addMatchBlock(final int lllllllllllllllIIIIlIllIIlIllllI, final int lllllllllllllllIIIIlIllIIllIIIIl) {
        final MatchBlock lllllllllllllllIIIIlIllIIllIIIII = this.getMatchBlock(lllllllllllllllIIIIlIllIIlIllllI);
        if (lllllllllllllllIIIIlIllIIllIIIII != null) {
            if (lllllllllllllllIIIIlIllIIllIIIIl >= 0) {
                lllllllllllllllIIIIlIllIIllIIIII.addMetadata(lllllllllllllllIIIIlIllIIllIIIIl);
            }
        }
        else {
            this.addMatchBlock(new MatchBlock(lllllllllllllllIIIIlIllIIlIllllI, lllllllllllllllIIIIlIllIIllIIIIl));
        }
    }
    
    public float[][] getColorsRgb() {
        if (this.colorsRgb == null) {
            this.colorsRgb = toRgb(this.colors);
        }
        return this.colorsRgb;
    }
    
    private static void dbg(final String lllllllllllllllIIIIlIlllIlIlIlIl) {
        Config.dbg(String.valueOf(new StringBuilder("CustomColors: ").append(lllllllllllllllIIIIlIlllIlIlIlIl)));
    }
    
    public int getColor(final Biome lllllllllllllllIIIIlIllIllllIllI, final BlockPos lllllllllllllllIIIIlIllIllllIlIl) {
        if (this.format == 0) {
            return this.getColorVanilla(lllllllllllllllIIIIlIllIllllIllI, lllllllllllllllIIIIlIllIllllIlIl);
        }
        return (this.format == 1) ? this.getColorGrid(lllllllllllllllIIIIlIllIllllIllI, lllllllllllllllIIIIlIllIllllIlIl) : this.color;
    }
    
    public int getColorSmooth(final IBlockAccess lllllllllllllllIIIIlIllIlllIIIlI, final double lllllllllllllllIIIIlIllIllIIllIl, final double lllllllllllllllIIIIlIllIllIIllII, final double lllllllllllllllIIIIlIllIllIIlIll, final int lllllllllllllllIIIIlIllIllIIlIlI) {
        if (this.format == 2) {
            return this.color;
        }
        final int lllllllllllllllIIIIlIllIllIlllIl = MathHelper.floor(lllllllllllllllIIIIlIllIllIIllIl);
        final int lllllllllllllllIIIIlIllIllIlllII = MathHelper.floor(lllllllllllllllIIIIlIllIllIIllII);
        final int lllllllllllllllIIIIlIllIllIllIll = MathHelper.floor(lllllllllllllllIIIIlIllIllIIlIll);
        int lllllllllllllllIIIIlIllIllIllIlI = 0;
        int lllllllllllllllIIIIlIllIllIllIIl = 0;
        int lllllllllllllllIIIIlIllIllIllIII = 0;
        int lllllllllllllllIIIIlIllIllIlIlll = 0;
        final BlockPosM lllllllllllllllIIIIlIllIllIlIllI = new BlockPosM(0, 0, 0);
        for (int lllllllllllllllIIIIlIllIllIlIlIl = lllllllllllllllIIIIlIllIllIlllIl - lllllllllllllllIIIIlIllIllIIlIlI; lllllllllllllllIIIIlIllIllIlIlIl <= lllllllllllllllIIIIlIllIllIlllIl + lllllllllllllllIIIIlIllIllIIlIlI; ++lllllllllllllllIIIIlIllIllIlIlIl) {
            for (int lllllllllllllllIIIIlIllIllIlIlII = lllllllllllllllIIIIlIllIllIllIll - lllllllllllllllIIIIlIllIllIIlIlI; lllllllllllllllIIIIlIllIllIlIlII <= lllllllllllllllIIIIlIllIllIllIll + lllllllllllllllIIIIlIllIllIIlIlI; ++lllllllllllllllIIIIlIllIllIlIlII) {
                lllllllllllllllIIIIlIllIllIlIllI.setXyz(lllllllllllllllIIIIlIllIllIlIlIl, lllllllllllllllIIIIlIllIllIlllII, lllllllllllllllIIIIlIllIllIlIlII);
                final int lllllllllllllllIIIIlIllIllIlIIll = this.getColor(lllllllllllllllIIIIlIllIlllIIIlI, lllllllllllllllIIIIlIllIllIlIllI);
                lllllllllllllllIIIIlIllIllIllIlI += (lllllllllllllllIIIIlIllIllIlIIll >> 16 & 0xFF);
                lllllllllllllllIIIIlIllIllIllIIl += (lllllllllllllllIIIIlIllIllIlIIll >> 8 & 0xFF);
                lllllllllllllllIIIIlIllIllIllIII += (lllllllllllllllIIIIlIllIllIlIIll & 0xFF);
                ++lllllllllllllllIIIIlIllIllIlIlll;
            }
        }
        final int lllllllllllllllIIIIlIllIllIlIIlI = lllllllllllllllIIIIlIllIllIllIlI / lllllllllllllllIIIIlIllIllIlIlll;
        final int lllllllllllllllIIIIlIllIllIlIIIl = lllllllllllllllIIIIlIllIllIllIIl / lllllllllllllllIIIIlIllIllIlIlll;
        final int lllllllllllllllIIIIlIllIllIlIIII = lllllllllllllllIIIIlIllIllIllIII / lllllllllllllllIIIIlIllIllIlIlll;
        return lllllllllllllllIIIIlIllIllIlIIlI << 16 | lllllllllllllllIIIIlIllIllIlIIIl << 8 | lllllllllllllllIIIIlIllIllIlIIII;
    }
    
    public int getColor(final IBlockAccess lllllllllllllllIIIIlIlllIIIIIlll, final BlockPos lllllllllllllllIIIIlIlllIIIIIllI) {
        final Biome lllllllllllllllIIIIlIlllIIIIIlIl = CustomColors.getColorBiome(lllllllllllllllIIIIlIlllIIIIIlll, lllllllllllllllIIIIlIlllIIIIIllI);
        return this.getColor(lllllllllllllllIIIIlIlllIIIIIlIl, lllllllllllllllIIIIlIlllIIIIIllI);
    }
    
    public boolean matchesBlock(final BlockStateBase lllllllllllllllIIIIlIlllIIlIllll) {
        return Matches.block(lllllllllllllllIIIIlIlllIIlIllll, this.matchBlocks);
    }
    
    public int getLength() {
        return (this.format == 2) ? 1 : this.colors.length;
    }
    
    public int[] getMatchBlockIds() {
        if (this.matchBlocks == null) {
            return null;
        }
        final Set lllllllllllllllIIIIlIllIIlIIlIIl = new HashSet();
        for (int lllllllllllllllIIIIlIllIIlIIlIII = 0; lllllllllllllllIIIIlIllIIlIIlIII < this.matchBlocks.length; ++lllllllllllllllIIIIlIllIIlIIlIII) {
            final MatchBlock lllllllllllllllIIIIlIllIIlIIIlll = this.matchBlocks[lllllllllllllllIIIIlIllIIlIIlIII];
            if (lllllllllllllllIIIIlIllIIlIIIlll.getBlockId() >= 0) {
                lllllllllllllllIIIIlIllIIlIIlIIl.add(lllllllllllllllIIIIlIllIIlIIIlll.getBlockId());
            }
        }
        final Integer[] lllllllllllllllIIIIlIllIIlIIIllI = lllllllllllllllIIIIlIllIIlIIlIIl.toArray(new Integer[lllllllllllllllIIIIlIllIIlIIlIIl.size()]);
        final int[] lllllllllllllllIIIIlIllIIlIIIlIl = new int[lllllllllllllllIIIIlIllIIlIIIllI.length];
        for (int lllllllllllllllIIIIlIllIIlIIIlII = 0; lllllllllllllllIIIIlIllIIlIIIlII < lllllllllllllllIIIIlIllIIlIIIllI.length; ++lllllllllllllllIIIIlIllIIlIIIlII) {
            lllllllllllllllIIIIlIllIIlIIIlIl[lllllllllllllllIIIIlIllIIlIIIlII] = lllllllllllllllIIIIlIllIIlIIIllI[lllllllllllllllIIIIlIllIIlIIIlII];
        }
        return lllllllllllllllIIIIlIllIIlIIIlIl;
    }
    
    private void readColors() {
        try {
            this.colors = null;
            if (this.source == null) {
                return;
            }
            final String lllllllllllllllIIIIlIlllIllIlIII = String.valueOf(new StringBuilder(String.valueOf(this.source)).append(".png"));
            final ResourceLocation lllllllllllllllIIIIlIlllIllIIlll = new ResourceLocation(lllllllllllllllIIIIlIlllIllIlIII);
            final InputStream lllllllllllllllIIIIlIlllIllIIllI = Config.getResourceStream(lllllllllllllllIIIIlIlllIllIIlll);
            if (lllllllllllllllIIIIlIlllIllIIllI == null) {
                return;
            }
            final BufferedImage lllllllllllllllIIIIlIlllIllIIlIl = TextureUtil.readBufferedImage(lllllllllllllllIIIIlIlllIllIIllI);
            if (lllllllllllllllIIIIlIlllIllIIlIl == null) {
                return;
            }
            final int lllllllllllllllIIIIlIlllIllIIlII = lllllllllllllllIIIIlIlllIllIIlIl.getWidth();
            final int lllllllllllllllIIIIlIlllIllIIIll = lllllllllllllllIIIIlIlllIllIIlIl.getHeight();
            final boolean lllllllllllllllIIIIlIlllIllIIIlI = this.width < 0 || this.width == lllllllllllllllIIIIlIlllIllIIlII;
            final boolean lllllllllllllllIIIIlIlllIllIIIIl = this.height < 0 || this.height == lllllllllllllllIIIIlIlllIllIIIll;
            if (!lllllllllllllllIIIIlIlllIllIIIlI || !lllllllllllllllIIIIlIlllIllIIIIl) {
                dbg(String.valueOf(new StringBuilder("Non-standard palette size: ").append(lllllllllllllllIIIIlIlllIllIIlII).append("x").append(lllllllllllllllIIIIlIlllIllIIIll).append(", should be: ").append(this.width).append("x").append(this.height).append(", path: ").append(lllllllllllllllIIIIlIlllIllIlIII)));
            }
            this.width = lllllllllllllllIIIIlIlllIllIIlII;
            this.height = lllllllllllllllIIIIlIlllIllIIIll;
            if (this.width <= 0 || this.height <= 0) {
                warn(String.valueOf(new StringBuilder("Invalid palette size: ").append(lllllllllllllllIIIIlIlllIllIIlII).append("x").append(lllllllllllllllIIIIlIlllIllIIIll).append(", path: ").append(lllllllllllllllIIIIlIlllIllIlIII)));
                return;
            }
            this.colors = new int[lllllllllllllllIIIIlIlllIllIIlII * lllllllllllllllIIIIlIlllIllIIIll];
            lllllllllllllllIIIIlIlllIllIIlIl.getRGB(0, 0, lllllllllllllllIIIIlIlllIllIIlII, lllllllllllllllIIIIlIlllIllIIIll, this.colors, 0, lllllllllllllllIIIIlIlllIllIIlII);
        }
        catch (IOException lllllllllllllllIIIIlIlllIllIIIII) {
            lllllllllllllllIIIIlIlllIllIIIII.printStackTrace();
        }
    }
    
    private MatchBlock getMatchBlock(final int lllllllllllllllIIIIlIllIIlIlIIlI) {
        if (this.matchBlocks == null) {
            return null;
        }
        for (int lllllllllllllllIIIIlIllIIlIlIlIl = 0; lllllllllllllllIIIIlIllIIlIlIlIl < this.matchBlocks.length; ++lllllllllllllllIIIIlIllIIlIlIlIl) {
            final MatchBlock lllllllllllllllIIIIlIllIIlIlIlII = this.matchBlocks[lllllllllllllllIIIIlIllIIlIlIlIl];
            if (lllllllllllllllIIIIlIllIIlIlIlII.getBlockId() == lllllllllllllllIIIIlIllIIlIlIIlI) {
                return lllllllllllllllIIIIlIllIIlIlIlII;
            }
        }
        return null;
    }
    
    public int getColor(int lllllllllllllllIIIIlIlllIIIllIll, int lllllllllllllllIIIIlIlllIIIllIlI) {
        lllllllllllllllIIIIlIlllIIIllIll = (short)Config.limit(lllllllllllllllIIIIlIlllIIIllIll, 0, this.width - 1);
        lllllllllllllllIIIIlIlllIIIllIlI = (short)Config.limit(lllllllllllllllIIIIlIlllIIIllIlI, 0, this.height - 1);
        return this.colors[lllllllllllllllIIIIlIlllIIIllIlI * this.width + lllllllllllllllIIIIlIlllIIIllIll] & 0xFFFFFF;
    }
    
    private static String fixTextureName(String lllllllllllllllIIIIlIlllIIllIlll, final String lllllllllllllllIIIIlIlllIIlllIIl) {
        lllllllllllllllIIIIlIlllIIllIlll = (byte)TextureUtils.fixResourcePath((String)lllllllllllllllIIIIlIlllIIllIlll, lllllllllllllllIIIIlIlllIIlllIIl);
        if (!((String)lllllllllllllllIIIIlIlllIIllIlll).startsWith(lllllllllllllllIIIIlIlllIIlllIIl) && !((String)lllllllllllllllIIIIlIlllIIllIlll).startsWith("textures/") && !((String)lllllllllllllllIIIIlIlllIIllIlll).startsWith("mcpatcher/")) {
            lllllllllllllllIIIIlIlllIIllIlll = (byte)String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIIlIlllIIlllIIl)).append("/").append((String)lllllllllllllllIIIIlIlllIIllIlll));
        }
        if (((String)lllllllllllllllIIIIlIlllIIllIlll).endsWith(".png")) {
            lllllllllllllllIIIIlIlllIIllIlll = (byte)((String)lllllllllllllllIIIIlIlllIIllIlll).substring(0, ((String)lllllllllllllllIIIIlIlllIIllIlll).length() - 4);
        }
        final String lllllllllllllllIIIIlIlllIIlllIII = "textures/blocks/";
        if (((String)lllllllllllllllIIIIlIlllIIllIlll).startsWith(lllllllllllllllIIIIlIlllIIlllIII)) {
            lllllllllllllllIIIIlIlllIIllIlll = (byte)((String)lllllllllllllllIIIIlIlllIIllIlll).substring(lllllllllllllllIIIIlIlllIIlllIII.length());
        }
        if (((String)lllllllllllllllIIIIlIlllIIllIlll).startsWith("/")) {
            lllllllllllllllIIIIlIlllIIllIlll = (byte)((String)lllllllllllllllIIIIlIlllIIllIlll).substring(1);
        }
        return (String)lllllllllllllllIIIIlIlllIIllIlll;
    }
    
    private int getColorGrid(final Biome lllllllllllllllIIIIlIllIlIIlIllI, final BlockPos lllllllllllllllIIIIlIllIlIIlIlIl) {
        final int lllllllllllllllIIIIlIllIlIIlllIl = Biome.getIdForBiome(lllllllllllllllIIIIlIllIlIIlIllI);
        int lllllllllllllllIIIIlIllIlIIlllII = lllllllllllllllIIIIlIllIlIIlIlIl.getY() - this.yOffset;
        if (this.yVariance > 0) {
            final int lllllllllllllllIIIIlIllIlIIllIll = lllllllllllllllIIIIlIllIlIIlIlIl.getX() << 16 + lllllllllllllllIIIIlIllIlIIlIlIl.getZ();
            final int lllllllllllllllIIIIlIllIlIIllIlI = Config.intHash(lllllllllllllllIIIIlIllIlIIllIll);
            final int lllllllllllllllIIIIlIllIlIIllIIl = this.yVariance * 2 + 1;
            final int lllllllllllllllIIIIlIllIlIIllIII = (lllllllllllllllIIIIlIllIlIIllIlI & 0xFF) % lllllllllllllllIIIIlIllIlIIllIIl - this.yVariance;
            lllllllllllllllIIIIlIllIlIIlllII += lllllllllllllllIIIIlIllIlIIllIII;
        }
        return this.getColor(lllllllllllllllIIIIlIllIlIIlllIl, lllllllllllllllIIIIlIllIlIIlllII);
    }
    
    private int getColorVanilla(final Biome lllllllllllllllIIIIlIllIlIllIllI, final BlockPos lllllllllllllllIIIIlIllIlIllIlIl) {
        final double lllllllllllllllIIIIlIllIlIllIlII = MathHelper.clamp(lllllllllllllllIIIIlIllIlIllIllI.getFloatTemperature(lllllllllllllllIIIIlIllIlIllIlIl), 0.0f, 1.0f);
        double lllllllllllllllIIIIlIllIlIllIIll = MathHelper.clamp(lllllllllllllllIIIIlIllIlIllIllI.getRainfall(), 0.0f, 1.0f);
        lllllllllllllllIIIIlIllIlIllIIll *= lllllllllllllllIIIIlIllIlIllIlII;
        final int lllllllllllllllIIIIlIllIlIllIIlI = (int)((1.0 - lllllllllllllllIIIIlIllIlIllIlII) * (this.width - 1));
        final int lllllllllllllllIIIIlIllIlIllIIIl = (int)((1.0 - lllllllllllllllIIIIlIllIlIllIIll) * (this.height - 1));
        return this.getColor(lllllllllllllllIIIIlIllIlIllIIlI, lllllllllllllllIIIIlIllIlIllIIIl);
    }
    
    public int getColorRandom() {
        if (this.format == 2) {
            return this.color;
        }
        final int lllllllllllllllIIIIlIlllIIlIlIll = CustomColors.random.nextInt(this.colors.length);
        return this.colors[lllllllllllllllIIIIlIlllIIlIlIll];
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.basePath).append("/").append(this.name).append(", blocks: ").append(Config.arrayToString(this.matchBlocks)).append(", source: ").append(this.source));
    }
    
    public int getHeight() {
        return this.height;
    }
    
    private static void warn(final String lllllllllllllllIIIIlIlllIlIlIIlI) {
        Config.warn(String.valueOf(new StringBuilder("CustomColors: ").append(lllllllllllllllIIIIlIlllIlIlIIlI)));
    }
    
    @Override
    public boolean isColorConstant() {
        return this.format == 2;
    }
    
    private static float[][] toRgb(final int[] lllllllllllllllIIIIlIllIIlllIlIl) {
        final float[][] lllllllllllllllIIIIlIllIIlllllII = new float[lllllllllllllllIIIIlIllIIlllIlIl.length][3];
        for (int lllllllllllllllIIIIlIllIIllllIll = 0; lllllllllllllllIIIIlIllIIllllIll < lllllllllllllllIIIIlIllIIlllIlIl.length; ++lllllllllllllllIIIIlIllIIllllIll) {
            final int lllllllllllllllIIIIlIllIIllllIlI = lllllllllllllllIIIIlIllIIlllIlIl[lllllllllllllllIIIIlIllIIllllIll];
            final float lllllllllllllllIIIIlIllIIllllIIl = (lllllllllllllllIIIIlIllIIllllIlI >> 16 & 0xFF) / 255.0f;
            final float lllllllllllllllIIIIlIllIIllllIII = (lllllllllllllllIIIIlIllIIllllIlI >> 8 & 0xFF) / 255.0f;
            final float lllllllllllllllIIIIlIllIIlllIlll = (lllllllllllllllIIIIlIllIIllllIlI & 0xFF) / 255.0f;
            final float[] lllllllllllllllIIIIlIllIIlllIllI = lllllllllllllllIIIIlIllIIlllllII[lllllllllllllllIIIIlIllIIllllIll];
            lllllllllllllllIIIIlIllIIlllIllI[0] = lllllllllllllllIIIIlIllIIllllIIl;
            lllllllllllllllIIIIlIllIIlllIllI[1] = lllllllllllllllIIIIlIllIIllllIII;
            lllllllllllllllIIIIlIllIIlllIllI[2] = lllllllllllllllIIIIlIllIIlllIlll;
        }
        return lllllllllllllllIIIIlIllIIlllllII;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    static {
        FORMAT_GRID_STRING = "grid";
        FORMAT_GRID = 1;
        FORMAT_FIXED = 2;
        FORMAT_VANILLA = 0;
        FORMAT_FIXED_STRING = "fixed";
        KEY_SOURCE = "source";
        KEY_Y_OFFSET = "yOffset";
        KEY_Y_VARIANCE = "yVariance";
        KEY_FORMAT = "format";
        FORMAT_VANILLA_STRING = "vanilla";
        KEY_COLOR = "color";
        FORMAT_UNKNOWN = -1;
        KEY_BLOCKS = "blocks";
        FORMAT_STRINGS = new String[] { "vanilla", "grid", "fixed" };
    }
    
    private int parseFormat(String lllllllllllllllIIIIlIllllIIlIlII) {
        if (lllllllllllllllIIIIlIllllIIlIlII == null) {
            return 0;
        }
        lllllllllllllllIIIIlIllllIIlIlII = lllllllllllllllIIIIlIllllIIlIlII.trim();
        if (lllllllllllllllIIIIlIllllIIlIlII.equals("vanilla")) {
            return 0;
        }
        if (lllllllllllllllIIIIlIllllIIlIlII.equals("grid")) {
            return 1;
        }
        if (lllllllllllllllIIIIlIllllIIlIlII.equals("fixed")) {
            return 2;
        }
        warn(String.valueOf(new StringBuilder("Unknown format: ").append(lllllllllllllllIIIIlIllllIIlIlII)));
        return -1;
    }
    
    public CustomColormap(final Properties lllllllllllllllIIIIlIllllIlIIIll, final String lllllllllllllllIIIIlIllllIIllIll, final int lllllllllllllllIIIIlIllllIlIIIIl, final int lllllllllllllllIIIIlIllllIlIIIII, final String lllllllllllllllIIIIlIllllIIllIII) {
        this.name = null;
        this.basePath = null;
        this.format = -1;
        this.matchBlocks = null;
        this.source = null;
        this.color = -1;
        this.yVariance = 0;
        this.yOffset = 0;
        this.width = 0;
        this.height = 0;
        this.colors = null;
        this.colorsRgb = null;
        final ConnectedParser lllllllllllllllIIIIlIllllIIllllI = new ConnectedParser("Colormap");
        this.name = lllllllllllllllIIIIlIllllIIllllI.parseName(lllllllllllllllIIIIlIllllIIllIll);
        this.basePath = lllllllllllllllIIIIlIllllIIllllI.parseBasePath(lllllllllllllllIIIIlIllllIIllIll);
        this.format = this.parseFormat(lllllllllllllllIIIIlIllllIlIIIll.getProperty("format", lllllllllllllllIIIIlIllllIIllIII));
        this.matchBlocks = lllllllllllllllIIIIlIllllIIllllI.parseMatchBlocks(lllllllllllllllIIIIlIllllIlIIIll.getProperty("blocks"));
        this.source = parseTexture(lllllllllllllllIIIIlIllllIlIIIll.getProperty("source"), lllllllllllllllIIIIlIllllIIllIll, this.basePath);
        this.color = ConnectedParser.parseColor(lllllllllllllllIIIIlIllllIlIIIll.getProperty("color"), -1);
        this.yVariance = lllllllllllllllIIIIlIllllIIllllI.parseInt(lllllllllllllllIIIIlIllllIlIIIll.getProperty("yVariance"), 0);
        this.yOffset = lllllllllllllllIIIIlIllllIIllllI.parseInt(lllllllllllllllIIIIlIllllIlIIIll.getProperty("yOffset"), 0);
        this.width = lllllllllllllllIIIIlIllllIlIIIIl;
        this.height = lllllllllllllllIIIIlIllllIlIIIII;
    }
    
    public boolean isValidMatchBlocks(final String lllllllllllllllIIIIlIllllIIIIlll) {
        if (this.matchBlocks == null) {
            this.matchBlocks = this.detectMatchBlocks();
            if (this.matchBlocks == null) {
                warn(String.valueOf(new StringBuilder("Match blocks not defined: ").append(lllllllllllllllIIIIlIllllIIIIlll)));
                return false;
            }
        }
        return true;
    }
    
    public boolean isValid(final String lllllllllllllllIIIIlIllllIIIllll) {
        if (this.format != 0 && this.format != 1) {
            if (this.format != 2) {
                return false;
            }
            if (this.color < 0) {
                this.color = 16777215;
            }
        }
        else {
            if (this.source == null) {
                warn(String.valueOf(new StringBuilder("Source not defined: ").append(lllllllllllllllIIIIlIllllIIIllll)));
                return false;
            }
            this.readColors();
            if (this.colors == null) {
                return false;
            }
            if (this.color < 0) {
                if (this.format == 0) {
                    this.color = this.getColor(127, 127);
                }
                if (this.format == 1) {
                    this.color = this.getColorGrid(Biomes.PLAINS, new BlockPos(0, 64, 0));
                }
            }
        }
        return true;
    }
    
    public int getColor(int lllllllllllllllIIIIlIlllIIlIIIll) {
        lllllllllllllllIIIIlIlllIIlIIIll = Config.limit(lllllllllllllllIIIIlIlllIIlIIIll, 0, this.colors.length - 1);
        return this.colors[lllllllllllllllIIIIlIlllIIlIIIll] & 0xFFFFFF;
    }
    
    public void addMatchBlock(final MatchBlock lllllllllllllllIIIIlIllIIllIlIII) {
        if (this.matchBlocks == null) {
            this.matchBlocks = new MatchBlock[0];
        }
        this.matchBlocks = (MatchBlock[])Config.addObjectToArray(this.matchBlocks, lllllllllllllllIIIIlIllIIllIlIII);
    }
}
