package optifine;

import net.minecraft.client.renderer.color.*;
import net.minecraft.client.*;
import org.apache.commons.lang3.tuple.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.particle.*;
import net.minecraft.block.material.*;
import javax.imageio.*;
import java.awt.image.*;
import net.minecraft.potion.*;
import net.minecraft.init.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import java.io.*;
import net.minecraft.nbt.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.block.*;
import java.util.*;

public class CustomColors
{
    private static /* synthetic */ CustomColormap[] colorsBlockColormaps;
    private static /* synthetic */ CustomColormap skyColors;
    private static final /* synthetic */ IColorizer COLORIZER_FOLIAGE_BIRCH;
    private static /* synthetic */ boolean useDefaultGrassFoliageColors;
    private static /* synthetic */ CustomColorFader underwaterColorFader;
    private static /* synthetic */ int[] spawnEggPrimaryColors;
    private static /* synthetic */ String paletteFormatDefault;
    private static final /* synthetic */ IColorizer COLORIZER_FOLIAGE;
    private static /* synthetic */ CustomColormap myceliumParticleColors;
    private static final /* synthetic */ IColorizer COLORIZER_FOLIAGE_PINE;
    private static /* synthetic */ CustomColormap fogColors;
    private static final /* synthetic */ IColorizer COLORIZER_WATER;
    private static /* synthetic */ CustomColormap redstoneColors;
    private static /* synthetic */ int expBarTextColor;
    private static /* synthetic */ int[] mapColorsOriginal;
    private static /* synthetic */ CustomColormap waterColors;
    private static /* synthetic */ int signTextColor;
    private static /* synthetic */ float[][] wolfCollarColors;
    private static /* synthetic */ int bossTextColor;
    private static /* synthetic */ CustomColormap stemMelonColors;
    private static /* synthetic */ CustomColormap underlavaColors;
    private static final /* synthetic */ IBlockState BLOCK_STATE_DIRT;
    private static /* synthetic */ int xpOrbTime;
    private static /* synthetic */ int lightmapMinDimensionId;
    private static /* synthetic */ CustomColormap[] lightMapsColorsRgb;
    private static /* synthetic */ CustomColormap xpOrbColors;
    private static /* synthetic */ CustomColormap durabilityColors;
    private static final /* synthetic */ IColorizer COLORIZER_GRASS;
    private static final /* synthetic */ IBlockState BLOCK_STATE_WATER;
    private static /* synthetic */ int[] spawnEggSecondaryColors;
    private static /* synthetic */ Vec3d fogColorEnd;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$world$DimensionType;
    private static /* synthetic */ int[] textColors;
    private static /* synthetic */ float[][] sunRgbs;
    private static /* synthetic */ int[] potionColors;
    private static /* synthetic */ CustomColormap stemPumpkinColors;
    private static /* synthetic */ CustomColormap swampFoliageColors;
    private static /* synthetic */ Vec3d skyColorEnd;
    private static /* synthetic */ CustomColorFader fogColorFader;
    private static /* synthetic */ float[][] sheepColors;
    private static /* synthetic */ float[][] torchRgbs;
    private static /* synthetic */ CustomColormap underwaterColors;
    private static /* synthetic */ int particleWaterColor;
    private static /* synthetic */ Vec3d fogColorNether;
    private static /* synthetic */ CustomColormap swampGrassColors;
    private static /* synthetic */ CustomColormap[][] blockColormaps;
    private static /* synthetic */ int lilyPadColor;
    public static /* synthetic */ Random random;
    private static /* synthetic */ CustomColormap stemColors;
    private static /* synthetic */ int particlePortalColor;
    private static /* synthetic */ CustomColorFader skyColorFader;
    private static /* synthetic */ CustomColormap foliagePineColors;
    private static /* synthetic */ CustomColorFader underlavaColorFader;
    private static /* synthetic */ CustomColormap foliageBirchColors;
    
    public static void updateUseDefaultGrassFoliageColors() {
        CustomColors.useDefaultGrassFoliageColors = (CustomColors.foliageBirchColors == null && CustomColors.foliagePineColors == null && CustomColors.swampGrassColors == null && CustomColors.swampFoliageColors == null && Config.isSwampColors() && Config.isSmoothBiomes());
    }
    
    public static int getTextColor(final int lllllllllllllIlllIIIlllIIIIIllll, final int lllllllllllllIlllIIIlllIIIIIlllI) {
        if (CustomColors.textColors == null) {
            return lllllllllllllIlllIIIlllIIIIIlllI;
        }
        if (lllllllllllllIlllIIIlllIIIIIllll >= 0 && lllllllllllllIlllIIIlllIIIIIllll < CustomColors.textColors.length) {
            final int lllllllllllllIlllIIIlllIIIIlIIII = CustomColors.textColors[lllllllllllllIlllIIIlllIIIIIllll];
            return (lllllllllllllIlllIIIlllIIIIlIIII < 0) ? lllllllllllllIlllIIIlllIIIIIlllI : lllllllllllllIlllIIIlllIIIIlIIII;
        }
        return lllllllllllllIlllIIIlllIIIIIlllI;
    }
    
    private static float[][] readDyeColors(final Properties lllllllllllllIlllIIIlllIIllIllII, final String lllllllllllllIlllIIIlllIIllIlIll, final String lllllllllllllIlllIIIlllIIllIlIlI, final String lllllllllllllIlllIIIlllIIlIllIlI) {
        final EnumDyeColor[] lllllllllllllIlllIIIlllIIllIlIII = EnumDyeColor.values();
        final Map<String, EnumDyeColor> lllllllllllllIlllIIIlllIIllIIlll = new HashMap<String, EnumDyeColor>();
        for (int lllllllllllllIlllIIIlllIIllIIllI = 0; lllllllllllllIlllIIIlllIIllIIllI < lllllllllllllIlllIIIlllIIllIlIII.length; ++lllllllllllllIlllIIIlllIIllIIllI) {
            final EnumDyeColor lllllllllllllIlllIIIlllIIllIIlIl = lllllllllllllIlllIIIlllIIllIlIII[lllllllllllllIlllIIIlllIIllIIllI];
            lllllllllllllIlllIIIlllIIllIIlll.put(lllllllllllllIlllIIIlllIIllIIlIl.getName(), lllllllllllllIlllIIIlllIIllIIlIl);
        }
        final float[][] lllllllllllllIlllIIIlllIIllIIlII = new float[lllllllllllllIlllIIIlllIIllIlIII.length][];
        int lllllllllllllIlllIIIlllIIllIIIll = 0;
        for (final Object lllllllllllllIlllIIIlllIIllIIIlI : ((Hashtable<Object, V>)lllllllllllllIlllIIIlllIIllIllII).keySet()) {
            final String lllllllllllllIlllIIIlllIIllIIIIl = lllllllllllllIlllIIIlllIIllIllII.getProperty((String)lllllllllllllIlllIIIlllIIllIIIlI);
            if (((String)lllllllllllllIlllIIIlllIIllIIIlI).startsWith(lllllllllllllIlllIIIlllIIllIlIlI)) {
                String lllllllllllllIlllIIIlllIIllIIIII = StrUtils.removePrefix((String)lllllllllllllIlllIIIlllIIllIIIlI, lllllllllllllIlllIIIlllIIllIlIlI);
                if (lllllllllllllIlllIIIlllIIllIIIII.equals("lightBlue")) {
                    lllllllllllllIlllIIIlllIIllIIIII = "light_blue";
                }
                final EnumDyeColor lllllllllllllIlllIIIlllIIlIlllll = lllllllllllllIlllIIIlllIIllIIlll.get(lllllllllllllIlllIIIlllIIllIIIII);
                final int lllllllllllllIlllIIIlllIIlIllllI = parseColor(lllllllllllllIlllIIIlllIIllIIIIl);
                if (lllllllllllllIlllIIIlllIIlIlllll != null && lllllllllllllIlllIIIlllIIlIllllI >= 0) {
                    final float[] lllllllllllllIlllIIIlllIIlIlllIl = { (lllllllllllllIlllIIIlllIIlIllllI >> 16 & 0xFF) / 255.0f, (lllllllllllllIlllIIIlllIIlIllllI >> 8 & 0xFF) / 255.0f, (lllllllllllllIlllIIIlllIIlIllllI & 0xFF) / 255.0f };
                    lllllllllllllIlllIIIlllIIllIIlII[lllllllllllllIlllIIIlllIIlIlllll.ordinal()] = lllllllllllllIlllIIIlllIIlIlllIl;
                    ++lllllllllllllIlllIIIlllIIllIIIll;
                }
                else {
                    warn(String.valueOf(new StringBuilder("Invalid color: ").append(lllllllllllllIlllIIIlllIIllIIIlI).append(" = ").append(lllllllllllllIlllIIIlllIIllIIIIl)));
                }
            }
        }
        if (lllllllllllllIlllIIIlllIIllIIIll <= 0) {
            return null;
        }
        dbg(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIIIlllIIlIllIlI)).append(" colors: ").append(lllllllllllllIlllIIIlllIIllIIIll)));
        return lllllllllllllIlllIIIlllIIllIIlII;
    }
    
    public static BlockColors getBlockColors() {
        return Minecraft.getMinecraft().getBlockColors();
    }
    
    private static int[] readMapColors(final Properties lllllllllllllIlllIIIlllIIIIIIIIl, final String lllllllllllllIlllIIIlllIIIIIIIII, final String lllllllllllllIlllIIIllIlllllllll, final String lllllllllllllIlllIIIllIllllllllI) {
        final int[] lllllllllllllIlllIIIllIlllllllIl = new int[MapColor.COLORS.length];
        Arrays.fill(lllllllllllllIlllIIIllIlllllllIl, -1);
        int lllllllllllllIlllIIIllIlllllllII = 0;
        for (final Object lllllllllllllIlllIIIllIllllllIll : ((Hashtable<Object, V>)lllllllllllllIlllIIIlllIIIIIIIIl).keySet()) {
            final String lllllllllllllIlllIIIllIllllllIlI = lllllllllllllIlllIIIlllIIIIIIIIl.getProperty((String)lllllllllllllIlllIIIllIllllllIll);
            if (((String)lllllllllllllIlllIIIllIllllllIll).startsWith(lllllllllllllIlllIIIllIlllllllll)) {
                final String lllllllllllllIlllIIIllIllllllIIl = StrUtils.removePrefix((String)lllllllllllllIlllIIIllIllllllIll, lllllllllllllIlllIIIllIlllllllll);
                final int lllllllllllllIlllIIIllIllllllIII = getMapColorIndex(lllllllllllllIlllIIIllIllllllIIl);
                final int lllllllllllllIlllIIIllIlllllIlll = parseColor(lllllllllllllIlllIIIllIllllllIlI);
                if (lllllllllllllIlllIIIllIllllllIII >= 0 && lllllllllllllIlllIIIllIllllllIII < lllllllllllllIlllIIIllIlllllllIl.length && lllllllllllllIlllIIIllIlllllIlll >= 0) {
                    lllllllllllllIlllIIIllIlllllllIl[lllllllllllllIlllIIIllIllllllIII] = lllllllllllllIlllIIIllIlllllIlll;
                    ++lllllllllllllIlllIIIllIlllllllII;
                }
                else {
                    warn(String.valueOf(new StringBuilder("Invalid color: ").append(lllllllllllllIlllIIIllIllllllIll).append(" = ").append(lllllllllllllIlllIIIllIllllllIlI)));
                }
            }
        }
        if (lllllllllllllIlllIIIllIlllllllII <= 0) {
            return null;
        }
        dbg(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIIIllIllllllllI)).append(" colors: ").append(lllllllllllllIlllIIIllIlllllllII)));
        return lllllllllllllIlllIIIllIlllllllIl;
    }
    
    private static Pair<CustomColormap[], Integer> parseLightmapsRgb() {
        final String lllllllllllllIlllIIlIIlIlIIIllII = "mcpatcher/lightmap/world";
        final String lllllllllllllIlllIIlIIlIlIIIlIll = ".png";
        final String[] lllllllllllllIlllIIlIIlIlIIIlIlI = ResUtils.collectFiles(lllllllllllllIlllIIlIIlIlIIIllII, lllllllllllllIlllIIlIIlIlIIIlIll);
        final Map<Integer, String> lllllllllllllIlllIIlIIlIlIIIlIIl = new HashMap<Integer, String>();
        for (int lllllllllllllIlllIIlIIlIlIIIlIII = 0; lllllllllllllIlllIIlIIlIlIIIlIII < lllllllllllllIlllIIlIIlIlIIIlIlI.length; ++lllllllllllllIlllIIlIIlIlIIIlIII) {
            final String lllllllllllllIlllIIlIIlIlIIIIlll = lllllllllllllIlllIIlIIlIlIIIlIlI[lllllllllllllIlllIIlIIlIlIIIlIII];
            final String lllllllllllllIlllIIlIIlIlIIIIllI = StrUtils.removePrefixSuffix(lllllllllllllIlllIIlIIlIlIIIIlll, lllllllllllllIlllIIlIIlIlIIIllII, lllllllllllllIlllIIlIIlIlIIIlIll);
            final int lllllllllllllIlllIIlIIlIlIIIIlIl = Config.parseInt(lllllllllllllIlllIIlIIlIlIIIIllI, Integer.MIN_VALUE);
            if (lllllllllllllIlllIIlIIlIlIIIIlIl == Integer.MIN_VALUE) {
                warn(String.valueOf(new StringBuilder("Invalid dimension ID: ").append(lllllllllllllIlllIIlIIlIlIIIIllI).append(", path: ").append(lllllllllllllIlllIIlIIlIlIIIIlll)));
            }
            else {
                lllllllllllllIlllIIlIIlIlIIIlIIl.put(lllllllllllllIlllIIlIIlIlIIIIlIl, lllllllllllllIlllIIlIIlIlIIIIlll);
            }
        }
        final Set<Integer> lllllllllllllIlllIIlIIlIlIIIIlII = lllllllllllllIlllIIlIIlIlIIIlIIl.keySet();
        final Integer[] lllllllllllllIlllIIlIIlIlIIIIIll = lllllllllllllIlllIIlIIlIlIIIIlII.toArray(new Integer[lllllllllllllIlllIIlIIlIlIIIIlII.size()]);
        Arrays.sort(lllllllllllllIlllIIlIIlIlIIIIIll);
        if (lllllllllllllIlllIIlIIlIlIIIIIll.length <= 0) {
            return (Pair<CustomColormap[], Integer>)new ImmutablePair((Object)null, (Object)0);
        }
        final int lllllllllllllIlllIIlIIlIlIIIIIlI = lllllllllllllIlllIIlIIlIlIIIIIll[0];
        final int lllllllllllllIlllIIlIIlIlIIIIIIl = lllllllllllllIlllIIlIIlIlIIIIIll[lllllllllllllIlllIIlIIlIlIIIIIll.length - 1];
        final int lllllllllllllIlllIIlIIlIlIIIIIII = lllllllllllllIlllIIlIIlIlIIIIIIl - lllllllllllllIlllIIlIIlIlIIIIIlI + 1;
        final CustomColormap[] lllllllllllllIlllIIlIIlIIlllllll = new CustomColormap[lllllllllllllIlllIIlIIlIlIIIIIII];
        for (int lllllllllllllIlllIIlIIlIIllllllI = 0; lllllllllllllIlllIIlIIlIIllllllI < lllllllllllllIlllIIlIIlIlIIIIIll.length; ++lllllllllllllIlllIIlIIlIIllllllI) {
            final Integer lllllllllllllIlllIIlIIlIIlllllIl = lllllllllllllIlllIIlIIlIlIIIIIll[lllllllllllllIlllIIlIIlIIllllllI];
            final String lllllllllllllIlllIIlIIlIIlllllII = lllllllllllllIlllIIlIIlIlIIIlIIl.get(lllllllllllllIlllIIlIIlIIlllllIl);
            final CustomColormap lllllllllllllIlllIIlIIlIIllllIll = getCustomColors(lllllllllllllIlllIIlIIlIIlllllII, -1, -1);
            if (lllllllllllllIlllIIlIIlIIllllIll != null) {
                if (lllllllllllllIlllIIlIIlIIllllIll.getWidth() < 16) {
                    warn(String.valueOf(new StringBuilder("Invalid lightmap width: ").append(lllllllllllllIlllIIlIIlIIllllIll.getWidth()).append(", path: ").append(lllllllllllllIlllIIlIIlIIlllllII)));
                }
                else {
                    final int lllllllllllllIlllIIlIIlIIllllIlI = lllllllllllllIlllIIlIIlIIlllllIl - lllllllllllllIlllIIlIIlIlIIIIIlI;
                    lllllllllllllIlllIIlIIlIIlllllll[lllllllllllllIlllIIlIIlIIllllIlI] = lllllllllllllIlllIIlIIlIIllllIll;
                }
            }
        }
        return (Pair<CustomColormap[], Integer>)new ImmutablePair((Object)lllllllllllllIlllIIlIIlIIlllllll, (Object)lllllllllllllIlllIIlIIlIlIIIIIlI);
    }
    
    public static Vec3d getWorldSkyColor(Vec3d lllllllllllllIlllIIIlllIllIIllIl, final World lllllllllllllIlllIIIlllIllIlIIlI, final Entity lllllllllllllIlllIIIlllIllIlIIIl, final float lllllllllllllIlllIIIlllIllIlIIII) {
        final DimensionType lllllllllllllIlllIIIlllIllIIllll = lllllllllllllIlllIIIlllIllIlIIlI.provider.getDimensionType();
        switch ($SWITCH_TABLE$net$minecraft$world$DimensionType()[lllllllllllllIlllIIIlllIllIIllll.ordinal()]) {
            case 1: {
                final Minecraft lllllllllllllIlllIIIlllIllIIlllI = Minecraft.getMinecraft();
                lllllllllllllIlllIIIlllIllIIllIl = getSkyColor(lllllllllllllIlllIIIlllIllIIllIl, lllllllllllllIlllIIIlllIllIIlllI.world, lllllllllllllIlllIIIlllIllIlIIIl.posX, lllllllllllllIlllIIIlllIllIlIIIl.posY + 1.0, lllllllllllllIlllIIIlllIllIlIIIl.posZ);
                break;
            }
            case 3: {
                lllllllllllllIlllIIIlllIllIIllIl = getSkyColorEnd(lllllllllllllIlllIIIlllIllIIllIl);
                break;
            }
        }
        return lllllllllllllIlllIIIlllIllIIllIl;
    }
    
    public static int getDurabilityColor(final float lllllllllllllIlllIIlIIIIIlIlIIIl, final int lllllllllllllIlllIIlIIIIIlIlIIII) {
        if (CustomColors.durabilityColors == null) {
            return lllllllllllllIlllIIlIIIIIlIlIIII;
        }
        final int lllllllllllllIlllIIlIIIIIlIlIIll = (int)(lllllllllllllIlllIIlIIIIIlIlIIIl * CustomColors.durabilityColors.getLength());
        final int lllllllllllllIlllIIlIIIIIlIlIIlI = CustomColors.durabilityColors.getColor(lllllllllllllIlllIIlIIIIIlIlIIll);
        return lllllllllllllIlllIIlIIIIIlIlIIlI;
    }
    
    public static void update() {
        CustomColors.paletteFormatDefault = "vanilla";
        CustomColors.waterColors = null;
        CustomColors.foliageBirchColors = null;
        CustomColors.foliagePineColors = null;
        CustomColors.swampGrassColors = null;
        CustomColors.swampFoliageColors = null;
        CustomColors.skyColors = null;
        CustomColors.fogColors = null;
        CustomColors.underwaterColors = null;
        CustomColors.underlavaColors = null;
        CustomColors.redstoneColors = null;
        CustomColors.xpOrbColors = null;
        CustomColors.xpOrbTime = -1;
        CustomColors.durabilityColors = null;
        CustomColors.stemColors = null;
        CustomColors.myceliumParticleColors = null;
        CustomColors.lightMapsColorsRgb = null;
        CustomColors.particleWaterColor = -1;
        CustomColors.particlePortalColor = -1;
        CustomColors.lilyPadColor = -1;
        CustomColors.expBarTextColor = -1;
        CustomColors.bossTextColor = -1;
        CustomColors.signTextColor = -1;
        CustomColors.fogColorNether = null;
        CustomColors.fogColorEnd = null;
        CustomColors.skyColorEnd = null;
        CustomColors.colorsBlockColormaps = null;
        CustomColors.blockColormaps = null;
        CustomColors.useDefaultGrassFoliageColors = true;
        CustomColors.spawnEggPrimaryColors = null;
        CustomColors.spawnEggSecondaryColors = null;
        CustomColors.wolfCollarColors = null;
        CustomColors.sheepColors = null;
        CustomColors.textColors = null;
        setMapColors(CustomColors.mapColorsOriginal);
        CustomColors.potionColors = null;
        CustomColors.paletteFormatDefault = getValidProperty("mcpatcher/color.properties", "palette.format", CustomColormap.FORMAT_STRINGS, "vanilla");
        final String lllllllllllllIlllIIlIIlIllIlIlII = "mcpatcher/colormap/";
        final String[] lllllllllllllIlllIIlIIlIllIlIIll = { "water.png", "watercolorX.png" };
        CustomColors.waterColors = getCustomColors(lllllllllllllIlllIIlIIlIllIlIlII, lllllllllllllIlllIIlIIlIllIlIIll, 256, 256);
        updateUseDefaultGrassFoliageColors();
        if (Config.isCustomColors()) {
            final String[] lllllllllllllIlllIIlIIlIllIlIIlI = { "pine.png", "pinecolor.png" };
            CustomColors.foliagePineColors = getCustomColors(lllllllllllllIlllIIlIIlIllIlIlII, lllllllllllllIlllIIlIIlIllIlIIlI, 256, 256);
            final String[] lllllllllllllIlllIIlIIlIllIlIIIl = { "birch.png", "birchcolor.png" };
            CustomColors.foliageBirchColors = getCustomColors(lllllllllllllIlllIIlIIlIllIlIlII, lllllllllllllIlllIIlIIlIllIlIIIl, 256, 256);
            final String[] lllllllllllllIlllIIlIIlIllIlIIII = { "swampgrass.png", "swampgrasscolor.png" };
            CustomColors.swampGrassColors = getCustomColors(lllllllllllllIlllIIlIIlIllIlIlII, lllllllllllllIlllIIlIIlIllIlIIII, 256, 256);
            final String[] lllllllllllllIlllIIlIIlIllIIllll = { "swampfoliage.png", "swampfoliagecolor.png" };
            CustomColors.swampFoliageColors = getCustomColors(lllllllllllllIlllIIlIIlIllIlIlII, lllllllllllllIlllIIlIIlIllIIllll, 256, 256);
            final String[] lllllllllllllIlllIIlIIlIllIIlllI = { "sky0.png", "skycolor0.png" };
            CustomColors.skyColors = getCustomColors(lllllllllllllIlllIIlIIlIllIlIlII, lllllllllllllIlllIIlIIlIllIIlllI, 256, 256);
            final String[] lllllllllllllIlllIIlIIlIllIIllIl = { "fog0.png", "fogcolor0.png" };
            CustomColors.fogColors = getCustomColors(lllllllllllllIlllIIlIIlIllIlIlII, lllllllllllllIlllIIlIIlIllIIllIl, 256, 256);
            final String[] lllllllllllllIlllIIlIIlIllIIllII = { "underwater.png", "underwatercolor.png" };
            CustomColors.underwaterColors = getCustomColors(lllllllllllllIlllIIlIIlIllIlIlII, lllllllllllllIlllIIlIIlIllIIllII, 256, 256);
            final String[] lllllllllllllIlllIIlIIlIllIIlIll = { "underlava.png", "underlavacolor.png" };
            CustomColors.underlavaColors = getCustomColors(lllllllllllllIlllIIlIIlIllIlIlII, lllllllllllllIlllIIlIIlIllIIlIll, 256, 256);
            final String[] lllllllllllllIlllIIlIIlIllIIlIlI = { "redstone.png", "redstonecolor.png" };
            CustomColors.redstoneColors = getCustomColors(lllllllllllllIlllIIlIIlIllIlIlII, lllllllllllllIlllIIlIIlIllIIlIlI, 16, 1);
            CustomColors.xpOrbColors = getCustomColors(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIIlIIlIllIlIlII)).append("xporb.png")), -1, -1);
            CustomColors.durabilityColors = getCustomColors(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIIlIIlIllIlIlII)).append("durability.png")), -1, -1);
            final String[] lllllllllllllIlllIIlIIlIllIIlIIl = { "stem.png", "stemcolor.png" };
            CustomColors.stemColors = getCustomColors(lllllllllllllIlllIIlIIlIllIlIlII, lllllllllllllIlllIIlIIlIllIIlIIl, 8, 1);
            CustomColors.stemPumpkinColors = getCustomColors(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIIlIIlIllIlIlII)).append("pumpkinstem.png")), 8, 1);
            CustomColors.stemMelonColors = getCustomColors(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIIlIIlIllIlIlII)).append("melonstem.png")), 8, 1);
            final String[] lllllllllllllIlllIIlIIlIllIIlIII = { "myceliumparticle.png", "myceliumparticlecolor.png" };
            CustomColors.myceliumParticleColors = getCustomColors(lllllllllllllIlllIIlIIlIllIlIlII, lllllllllllllIlllIIlIIlIllIIlIII, -1, -1);
            final Pair<CustomColormap[], Integer> lllllllllllllIlllIIlIIlIllIIIlll = parseLightmapsRgb();
            CustomColors.lightMapsColorsRgb = (CustomColormap[])lllllllllllllIlllIIlIIlIllIIIlll.getLeft();
            CustomColors.lightmapMinDimensionId = (int)lllllllllllllIlllIIlIIlIllIIIlll.getRight();
            readColorProperties("mcpatcher/color.properties");
            CustomColors.blockColormaps = readBlockColormaps(new String[] { String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIIlIIlIllIlIlII)).append("custom/")), String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIIlIIlIllIlIlII)).append("blocks/")) }, CustomColors.colorsBlockColormaps, 256, 256);
            updateUseDefaultGrassFoliageColors();
        }
    }
    
    public static boolean updateLightmap(final World lllllllllllllIlllIIIllllIIlIllII, final float lllllllllllllIlllIIIllllIlIIIlII, final int[] lllllllllllllIlllIIIllllIIlIlIlI, final boolean lllllllllllllIlllIIIllllIlIIIIlI) {
        if (lllllllllllllIlllIIIllllIIlIllII == null) {
            return false;
        }
        if (CustomColors.lightMapsColorsRgb == null) {
            return false;
        }
        final int lllllllllllllIlllIIIllllIlIIIIIl = lllllllllllllIlllIIIllllIIlIllII.provider.getDimensionType().getId();
        final int lllllllllllllIlllIIIllllIlIIIIII = lllllllllllllIlllIIIllllIlIIIIIl - CustomColors.lightmapMinDimensionId;
        if (lllllllllllllIlllIIIllllIlIIIIII < 0 || lllllllllllllIlllIIIllllIlIIIIII >= CustomColors.lightMapsColorsRgb.length) {
            return false;
        }
        final CustomColormap lllllllllllllIlllIIIllllIIllllll = CustomColors.lightMapsColorsRgb[lllllllllllllIlllIIIllllIlIIIIII];
        if (lllllllllllllIlllIIIllllIIllllll == null) {
            return false;
        }
        final int lllllllllllllIlllIIIllllIIlllllI = lllllllllllllIlllIIIllllIIllllll.getHeight();
        if (lllllllllllllIlllIIIllllIlIIIIlI && lllllllllllllIlllIIIllllIIlllllI < 64) {
            return false;
        }
        final int lllllllllllllIlllIIIllllIIllllIl = lllllllllllllIlllIIIllllIIllllll.getWidth();
        if (lllllllllllllIlllIIIllllIIllllIl < 16) {
            warn(String.valueOf(new StringBuilder("Invalid lightmap width: ").append(lllllllllllllIlllIIIllllIIllllIl).append(" for dimension: ").append(lllllllllllllIlllIIIllllIlIIIIIl)));
            CustomColors.lightMapsColorsRgb[lllllllllllllIlllIIIllllIlIIIIII] = null;
            return false;
        }
        int lllllllllllllIlllIIIllllIIllllII = 0;
        if (lllllllllllllIlllIIIllllIlIIIIlI) {
            lllllllllllllIlllIIIllllIIllllII = lllllllllllllIlllIIIllllIIllllIl * 16 * 2;
        }
        float lllllllllllllIlllIIIllllIIlllIll = 1.1666666f * (lllllllllllllIlllIIIllllIIlIllII.getSunBrightness(1.0f) - 0.2f);
        if (lllllllllllllIlllIIIllllIIlIllII.getLastLightningBolt() > 0) {
            lllllllllllllIlllIIIllllIIlllIll = 1.0f;
        }
        lllllllllllllIlllIIIllllIIlllIll = Config.limitTo1(lllllllllllllIlllIIIllllIIlllIll);
        final float lllllllllllllIlllIIIllllIIlllIlI = lllllllllllllIlllIIIllllIIlllIll * (lllllllllllllIlllIIIllllIIllllIl - 1);
        final float lllllllllllllIlllIIIllllIIlllIIl = Config.limitTo1(lllllllllllllIlllIIIllllIlIIIlII + 0.5f) * (lllllllllllllIlllIIIllllIIllllIl - 1);
        final float lllllllllllllIlllIIIllllIIlllIII = Config.limitTo1(Config.getGameSettings().gammaSetting);
        final boolean lllllllllllllIlllIIIllllIIllIlll = lllllllllllllIlllIIIllllIIlllIII > 1.0E-4f;
        final float[][] lllllllllllllIlllIIIllllIIllIllI = lllllllllllllIlllIIIllllIIllllll.getColorsRgb();
        getLightMapColumn(lllllllllllllIlllIIIllllIIllIllI, lllllllllllllIlllIIIllllIIlllIlI, lllllllllllllIlllIIIllllIIllllII, lllllllllllllIlllIIIllllIIllllIl, CustomColors.sunRgbs);
        getLightMapColumn(lllllllllllllIlllIIIllllIIllIllI, lllllllllllllIlllIIIllllIIlllIIl, lllllllllllllIlllIIIllllIIllllII + 16 * lllllllllllllIlllIIIllllIIllllIl, lllllllllllllIlllIIIllllIIllllIl, CustomColors.torchRgbs);
        final float[] lllllllllllllIlllIIIllllIIllIlIl = new float[3];
        for (int lllllllllllllIlllIIIllllIIllIlII = 0; lllllllllllllIlllIIIllllIIllIlII < 16; ++lllllllllllllIlllIIIllllIIllIlII) {
            for (int lllllllllllllIlllIIIllllIIllIIll = 0; lllllllllllllIlllIIIllllIIllIIll < 16; ++lllllllllllllIlllIIIllllIIllIIll) {
                for (int lllllllllllllIlllIIIllllIIllIIlI = 0; lllllllllllllIlllIIIllllIIllIIlI < 3; ++lllllllllllllIlllIIIllllIIllIIlI) {
                    float lllllllllllllIlllIIIllllIIllIIIl = Config.limitTo1(CustomColors.sunRgbs[lllllllllllllIlllIIIllllIIllIlII][lllllllllllllIlllIIIllllIIllIIlI] + CustomColors.torchRgbs[lllllllllllllIlllIIIllllIIllIIll][lllllllllllllIlllIIIllllIIllIIlI]);
                    if (lllllllllllllIlllIIIllllIIllIlll) {
                        float lllllllllllllIlllIIIllllIIllIIII = 1.0f - lllllllllllllIlllIIIllllIIllIIIl;
                        lllllllllllllIlllIIIllllIIllIIII = 1.0f - lllllllllllllIlllIIIllllIIllIIII * lllllllllllllIlllIIIllllIIllIIII * lllllllllllllIlllIIIllllIIllIIII * lllllllllllllIlllIIIllllIIllIIII;
                        lllllllllllllIlllIIIllllIIllIIIl = lllllllllllllIlllIIIllllIIlllIII * lllllllllllllIlllIIIllllIIllIIII + (1.0f - lllllllllllllIlllIIIllllIIlllIII) * lllllllllllllIlllIIIllllIIllIIIl;
                    }
                    lllllllllllllIlllIIIllllIIllIlIl[lllllllllllllIlllIIIllllIIllIIlI] = lllllllllllllIlllIIIllllIIllIIIl;
                }
                final int lllllllllllllIlllIIIllllIIlIllll = (int)(lllllllllllllIlllIIIllllIIllIlIl[0] * 255.0f);
                final int lllllllllllllIlllIIIllllIIlIlllI = (int)(lllllllllllllIlllIIIllllIIllIlIl[1] * 255.0f);
                final int lllllllllllllIlllIIIllllIIlIllIl = (int)(lllllllllllllIlllIIIllllIIllIlIl[2] * 255.0f);
                lllllllllllllIlllIIIllllIIlIlIlI[lllllllllllllIlllIIIllllIIllIlII * 16 + lllllllllllllIlllIIIllllIIllIIll] = (0xFF000000 | lllllllllllllIlllIIIllllIIlIllll << 16 | lllllllllllllIlllIIIllllIIlIlllI << 8 | lllllllllllllIlllIIIllllIIlIllIl);
            }
        }
        return true;
    }
    
    private static Vec3d getSkyColorEnd(final Vec3d lllllllllllllIlllIIlIIIIIIIIllIl) {
        return (CustomColors.skyColorEnd == null) ? lllllllllllllIlllIIlIIIIIIIIllIl : CustomColors.skyColorEnd;
    }
    
    public static Vec3d getUnderwaterColor(final IBlockAccess lllllllllllllIlllIIIlllllIlIIIll, final double lllllllllllllIlllIIIlllllIlIIllI, final double lllllllllllllIlllIIIlllllIlIIlIl, final double lllllllllllllIlllIIIlllllIlIIlII) {
        return getUnderFluidColor(lllllllllllllIlllIIIlllllIlIIIll, lllllllllllllIlllIIIlllllIlIIllI, lllllllllllllIlllIIIlllllIlIIlIl, lllllllllllllIlllIIIlllllIlIIlII, CustomColors.underwaterColors, CustomColors.underwaterColorFader);
    }
    
    private static int[] readSpawnEggColors(final Properties lllllllllllllIlllIIIlllIlIllllII, final String lllllllllllllIlllIIIlllIlIlllIll, final String lllllllllllllIlllIIIlllIlIlIllIl, final String lllllllllllllIlllIIIlllIlIlIllII) {
        final List<Integer> lllllllllllllIlllIIIlllIlIlllIII = new ArrayList<Integer>();
        final Set lllllllllllllIlllIIIlllIlIllIlll = lllllllllllllIlllIIIlllIlIllllII.keySet();
        int lllllllllllllIlllIIIlllIlIllIllI = 0;
        for (final Object lllllllllllllIlllIIIlllIlIllIlIl : lllllllllllllIlllIIIlllIlIllIlll) {
            final String lllllllllllllIlllIIIlllIlIllIlII = lllllllllllllIlllIIIlllIlIllllII.getProperty((String)lllllllllllllIlllIIIlllIlIllIlIl);
            if (((String)lllllllllllllIlllIIIlllIlIllIlIl).startsWith(lllllllllllllIlllIIIlllIlIlIllIl)) {
                final String lllllllllllllIlllIIIlllIlIllIIll = StrUtils.removePrefix((String)lllllllllllllIlllIIIlllIlIllIlIl, lllllllllllllIlllIIIlllIlIlIllIl);
                int lllllllllllllIlllIIIlllIlIllIIlI = EntityUtils.getEntityIdByName(lllllllllllllIlllIIIlllIlIllIIll);
                if (lllllllllllllIlllIIIlllIlIllIIlI < 0) {
                    lllllllllllllIlllIIIlllIlIllIIlI = EntityUtils.getEntityIdByLocation(new ResourceLocation(lllllllllllllIlllIIIlllIlIllIIll).toString());
                }
                if (lllllllllllllIlllIIIlllIlIllIIlI < 0) {
                    warn(String.valueOf(new StringBuilder("Invalid spawn egg name: ").append(lllllllllllllIlllIIIlllIlIllIlIl)));
                }
                else {
                    final int lllllllllllllIlllIIIlllIlIllIIIl = parseColor(lllllllllllllIlllIIIlllIlIllIlII);
                    if (lllllllllllllIlllIIIlllIlIllIIIl < 0) {
                        warn(String.valueOf(new StringBuilder("Invalid spawn egg color: ").append(lllllllllllllIlllIIIlllIlIllIlIl).append(" = ").append(lllllllllllllIlllIIIlllIlIllIlII)));
                    }
                    else {
                        while (lllllllllllllIlllIIIlllIlIlllIII.size() <= lllllllllllllIlllIIIlllIlIllIIlI) {
                            lllllllllllllIlllIIIlllIlIlllIII.add(-1);
                        }
                        lllllllllllllIlllIIIlllIlIlllIII.set(lllllllllllllIlllIIIlllIlIllIIlI, lllllllllllllIlllIIIlllIlIllIIIl);
                        ++lllllllllllllIlllIIIlllIlIllIllI;
                    }
                }
            }
        }
        if (lllllllllllllIlllIIIlllIlIllIllI <= 0) {
            return null;
        }
        dbg(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIIIlllIlIlIllII)).append(" colors: ").append(lllllllllllllIlllIIIlllIlIllIllI)));
        final int[] lllllllllllllIlllIIIlllIlIllIIII = new int[lllllllllllllIlllIIIlllIlIlllIII.size()];
        for (int lllllllllllllIlllIIIlllIlIlIllll = 0; lllllllllllllIlllIIIlllIlIlIllll < lllllllllllllIlllIIIlllIlIllIIII.length; ++lllllllllllllIlllIIIlllIlIlIllll) {
            lllllllllllllIlllIIIlllIlIllIIII[lllllllllllllIlllIIIlllIlIlIllll] = lllllllllllllIlllIIIlllIlIlllIII.get(lllllllllllllIlllIIIlllIlIlIllll);
        }
        return lllllllllllllIlllIIIlllIlIllIIII;
    }
    
    private static int[] getMapColors() {
        final MapColor[] lllllllllllllIlllIIIllIllIIllIll = MapColor.COLORS;
        final int[] lllllllllllllIlllIIIllIllIIllIlI = new int[lllllllllllllIlllIIIllIllIIllIll.length];
        Arrays.fill(lllllllllllllIlllIIIllIllIIllIlI, -1);
        for (int lllllllllllllIlllIIIllIllIIllIIl = 0; lllllllllllllIlllIIIllIllIIllIIl < lllllllllllllIlllIIIllIllIIllIll.length && lllllllllllllIlllIIIllIllIIllIIl < lllllllllllllIlllIIIllIllIIllIlI.length; ++lllllllllllllIlllIIIllIllIIllIIl) {
            final MapColor lllllllllllllIlllIIIllIllIIllIII = lllllllllllllIlllIIIllIllIIllIll[lllllllllllllIlllIIIllIllIIllIIl];
            if (lllllllllllllIlllIIIllIllIIllIII != null) {
                lllllllllllllIlllIIIllIllIIllIlI[lllllllllllllIlllIIIllIllIIllIIl] = lllllllllllllIlllIIIllIllIIllIII.colorValue;
            }
        }
        return lllllllllllllIlllIIIllIllIIllIlI;
    }
    
    private static void getLightMapColumn(final float[][] lllllllllllllIlllIIIllllIIIIlIII, final float lllllllllllllIlllIIIllllIIIIIlll, final int lllllllllllllIlllIIIlllIllllIlII, final int lllllllllllllIlllIIIlllIllllIIll, final float[][] lllllllllllllIlllIIIlllIllllIIlI) {
        final int lllllllllllllIlllIIIllllIIIIIIll = (int)Math.floor(lllllllllllllIlllIIIllllIIIIIlll);
        final int lllllllllllllIlllIIIllllIIIIIIlI = (int)Math.ceil(lllllllllllllIlllIIIllllIIIIIlll);
        if (lllllllllllllIlllIIIllllIIIIIIll == lllllllllllllIlllIIIllllIIIIIIlI) {
            for (int lllllllllllllIlllIIIllllIIIIIIIl = 0; lllllllllllllIlllIIIllllIIIIIIIl < 16; ++lllllllllllllIlllIIIllllIIIIIIIl) {
                final float[] lllllllllllllIlllIIIllllIIIIIIII = lllllllllllllIlllIIIllllIIIIlIII[lllllllllllllIlllIIIlllIllllIlII + lllllllllllllIlllIIIllllIIIIIIIl * lllllllllllllIlllIIIlllIllllIIll + lllllllllllllIlllIIIllllIIIIIIll];
                final float[] lllllllllllllIlllIIIlllIllllllll = lllllllllllllIlllIIIlllIllllIIlI[lllllllllllllIlllIIIllllIIIIIIIl];
                for (int lllllllllllllIlllIIIlllIlllllllI = 0; lllllllllllllIlllIIIlllIlllllllI < 3; ++lllllllllllllIlllIIIlllIlllllllI) {
                    lllllllllllllIlllIIIlllIllllllll[lllllllllllllIlllIIIlllIlllllllI] = lllllllllllllIlllIIIllllIIIIIIII[lllllllllllllIlllIIIlllIlllllllI];
                }
            }
        }
        else {
            final float lllllllllllllIlllIIIlllIllllllIl = 1.0f - (lllllllllllllIlllIIIllllIIIIIlll - lllllllllllllIlllIIIllllIIIIIIll);
            final float lllllllllllllIlllIIIlllIllllllII = 1.0f - (lllllllllllllIlllIIIllllIIIIIIlI - lllllllllllllIlllIIIllllIIIIIlll);
            for (int lllllllllllllIlllIIIlllIlllllIll = 0; lllllllllllllIlllIIIlllIlllllIll < 16; ++lllllllllllllIlllIIIlllIlllllIll) {
                final float[] lllllllllllllIlllIIIlllIlllllIlI = lllllllllllllIlllIIIllllIIIIlIII[lllllllllllllIlllIIIlllIllllIlII + lllllllllllllIlllIIIlllIlllllIll * lllllllllllllIlllIIIlllIllllIIll + lllllllllllllIlllIIIllllIIIIIIll];
                final float[] lllllllllllllIlllIIIlllIlllllIIl = lllllllllllllIlllIIIllllIIIIlIII[lllllllllllllIlllIIIlllIllllIlII + lllllllllllllIlllIIIlllIlllllIll * lllllllllllllIlllIIIlllIllllIIll + lllllllllllllIlllIIIllllIIIIIIlI];
                final float[] lllllllllllllIlllIIIlllIlllllIII = lllllllllllllIlllIIIlllIllllIIlI[lllllllllllllIlllIIIlllIlllllIll];
                for (int lllllllllllllIlllIIIlllIllllIlll = 0; lllllllllllllIlllIIIlllIllllIlll < 3; ++lllllllllllllIlllIIIlllIllllIlll) {
                    lllllllllllllIlllIIIlllIlllllIII[lllllllllllllIlllIIIlllIllllIlll] = lllllllllllllIlllIIIlllIlllllIlI[lllllllllllllIlllIIIlllIllllIlll] * lllllllllllllIlllIIIlllIllllllIl + lllllllllllllIlllIIIlllIlllllIIl[lllllllllllllIlllIIIlllIllllIlll] * lllllllllllllIlllIIIlllIllllllII;
                }
            }
        }
    }
    
    public static void updatePortalFX(final Particle lllllllllllllIlllIIlIIIIllIIlIlI) {
        if (CustomColors.particlePortalColor >= 0) {
            final int lllllllllllllIlllIIlIIIIllIlIIIl = CustomColors.particlePortalColor;
            final int lllllllllllllIlllIIlIIIIllIlIIII = lllllllllllllIlllIIlIIIIllIlIIIl >> 16 & 0xFF;
            final int lllllllllllllIlllIIlIIIIllIIllll = lllllllllllllIlllIIlIIIIllIlIIIl >> 8 & 0xFF;
            final int lllllllllllllIlllIIlIIIIllIIlllI = lllllllllllllIlllIIlIIIIllIlIIIl & 0xFF;
            final float lllllllllllllIlllIIlIIIIllIIllIl = lllllllllllllIlllIIlIIIIllIlIIII / 255.0f;
            final float lllllllllllllIlllIIlIIIIllIIllII = lllllllllllllIlllIIlIIIIllIIllll / 255.0f;
            final float lllllllllllllIlllIIlIIIIllIIlIll = lllllllllllllIlllIIlIIIIllIIlllI / 255.0f;
            lllllllllllllIlllIIlIIIIllIIlIlI.setRBGColorF(lllllllllllllIlllIIlIIIIllIIllIl, lllllllllllllIlllIIlIIIIllIIllII, lllllllllllllIlllIIlIIIIllIIlIll);
        }
    }
    
    public static int getFluidColor(final IBlockAccess lllllllllllllIlllIIlIIIIlllIIIII, final IBlockState lllllllllllllIlllIIlIIIIlllIIlIl, final BlockPos lllllllllllllIlllIIlIIIIlllIIlII, final RenderEnv lllllllllllllIlllIIlIIIIllIlllIl) {
        final Block lllllllllllllIlllIIlIIIIlllIIIlI = lllllllllllllIlllIIlIIIIlllIIlIl.getBlock();
        IColorizer lllllllllllllIlllIIlIIIIlllIIIIl = getBlockColormap(lllllllllllllIlllIIlIIIIlllIIlIl);
        if (lllllllllllllIlllIIlIIIIlllIIIIl == null && lllllllllllllIlllIIlIIIIlllIIlIl.getMaterial() == Material.WATER) {
            lllllllllllllIlllIIlIIIIlllIIIIl = CustomColors.COLORIZER_WATER;
        }
        if (lllllllllllllIlllIIlIIIIlllIIIIl == null) {
            return getBlockColors().colorMultiplier(lllllllllllllIlllIIlIIIIlllIIlIl, lllllllllllllIlllIIlIIIIlllIIIII, lllllllllllllIlllIIlIIIIlllIIlII, 0);
        }
        return (Config.isSmoothBiomes() && !lllllllllllllIlllIIlIIIIlllIIIIl.isColorConstant()) ? getSmoothColorMultiplier(lllllllllllllIlllIIlIIIIlllIIlIl, lllllllllllllIlllIIlIIIIlllIIIII, lllllllllllllIlllIIlIIIIlllIIlII, lllllllllllllIlllIIlIIIIlllIIIIl, lllllllllllllIlllIIlIIIIllIlllIl.getColorizerBlockPosM()) : lllllllllllllIlllIIlIIIIlllIIIIl.getColor(lllllllllllllIlllIIlIIIIlllIIlIl, lllllllllllllIlllIIlIIIIlllIIIII, lllllllllllllIlllIIlIIIIlllIIlII);
    }
    
    private static int[] readPotionColors(final Properties lllllllllllllIlllIIIllIlllIlIlll, final String lllllllllllllIlllIIIllIllllIIIII, final String lllllllllllllIlllIIIllIlllIlIllI, final String lllllllllllllIlllIIIllIlllIlIlIl) {
        final int[] lllllllllllllIlllIIIllIlllIlllIl = new int[getMaxPotionId()];
        Arrays.fill(lllllllllllllIlllIIIllIlllIlllIl, -1);
        int lllllllllllllIlllIIIllIlllIlllII = 0;
        for (final Object lllllllllllllIlllIIIllIlllIllIll : ((Hashtable<Object, V>)lllllllllllllIlllIIIllIlllIlIlll).keySet()) {
            final String lllllllllllllIlllIIIllIlllIllIlI = lllllllllllllIlllIIIllIlllIlIlll.getProperty((String)lllllllllllllIlllIIIllIlllIllIll);
            if (((String)lllllllllllllIlllIIIllIlllIllIll).startsWith(lllllllllllllIlllIIIllIlllIlIllI)) {
                final int lllllllllllllIlllIIIllIlllIllIIl = getPotionId((String)lllllllllllllIlllIIIllIlllIllIll);
                final int lllllllllllllIlllIIIllIlllIllIII = parseColor(lllllllllllllIlllIIIllIlllIllIlI);
                if (lllllllllllllIlllIIIllIlllIllIIl >= 0 && lllllllllllllIlllIIIllIlllIllIIl < lllllllllllllIlllIIIllIlllIlllIl.length && lllllllllllllIlllIIIllIlllIllIII >= 0) {
                    lllllllllllllIlllIIIllIlllIlllIl[lllllllllllllIlllIIIllIlllIllIIl] = lllllllllllllIlllIIIllIlllIllIII;
                    ++lllllllllllllIlllIIIllIlllIlllII;
                }
                else {
                    warn(String.valueOf(new StringBuilder("Invalid color: ").append(lllllllllllllIlllIIIllIlllIllIll).append(" = ").append(lllllllllllllIlllIIIllIlllIllIlI)));
                }
            }
        }
        if (lllllllllllllIlllIIIllIlllIlllII <= 0) {
            return null;
        }
        dbg(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIIIllIlllIlIlIl)).append(" colors: ").append(lllllllllllllIlllIIIllIlllIlllII)));
        return lllllllllllllIlllIIIllIlllIlllIl;
    }
    
    private static int getRedstoneColor(final IBlockState lllllllllllllIlllIIlIIIIlIlIIlII) {
        if (CustomColors.redstoneColors == null) {
            return -1;
        }
        final int lllllllllllllIlllIIlIIIIlIlIIllI = getRedstoneLevel(lllllllllllllIlllIIlIIIIlIlIIlII, 15);
        final int lllllllllllllIlllIIlIIIIlIlIIlIl = CustomColors.redstoneColors.getColor(lllllllllllllIlllIIlIIIIlIlIIllI);
        return lllllllllllllIlllIIlIIIIlIlIIlIl;
    }
    
    public static void updateWaterFX(final Particle lllllllllllllIlllIIlIIIIIIlIlIll, final IBlockAccess lllllllllllllIlllIIlIIIIIIlIlIlI, final double lllllllllllllIlllIIlIIIIIIlIlIIl, final double lllllllllllllIlllIIlIIIIIIlIlIII, final double lllllllllllllIlllIIlIIIIIIlllIII, final RenderEnv lllllllllllllIlllIIlIIIIIIllIlll) {
        if (CustomColors.waterColors != null || CustomColors.blockColormaps != null) {
            final BlockPos lllllllllllllIlllIIlIIIIIIllIllI = new BlockPos(lllllllllllllIlllIIlIIIIIIlIlIIl, lllllllllllllIlllIIlIIIIIIlIlIII, lllllllllllllIlllIIlIIIIIIlllIII);
            lllllllllllllIlllIIlIIIIIIllIlll.reset(lllllllllllllIlllIIlIIIIIIlIlIlI, CustomColors.BLOCK_STATE_WATER, lllllllllllllIlllIIlIIIIIIllIllI);
            final int lllllllllllllIlllIIlIIIIIIllIlIl = getFluidColor(lllllllllllllIlllIIlIIIIIIlIlIlI, CustomColors.BLOCK_STATE_WATER, lllllllllllllIlllIIlIIIIIIllIllI, lllllllllllllIlllIIlIIIIIIllIlll);
            final int lllllllllllllIlllIIlIIIIIIllIlII = lllllllllllllIlllIIlIIIIIIllIlIl >> 16 & 0xFF;
            final int lllllllllllllIlllIIlIIIIIIllIIll = lllllllllllllIlllIIlIIIIIIllIlIl >> 8 & 0xFF;
            final int lllllllllllllIlllIIlIIIIIIllIIlI = lllllllllllllIlllIIlIIIIIIllIlIl & 0xFF;
            float lllllllllllllIlllIIlIIIIIIllIIIl = lllllllllllllIlllIIlIIIIIIllIlII / 255.0f;
            float lllllllllllllIlllIIlIIIIIIllIIII = lllllllllllllIlllIIlIIIIIIllIIll / 255.0f;
            float lllllllllllllIlllIIlIIIIIIlIllll = lllllllllllllIlllIIlIIIIIIllIIlI / 255.0f;
            if (CustomColors.particleWaterColor >= 0) {
                final int lllllllllllllIlllIIlIIIIIIlIlllI = CustomColors.particleWaterColor >> 16 & 0xFF;
                final int lllllllllllllIlllIIlIIIIIIlIllIl = CustomColors.particleWaterColor >> 8 & 0xFF;
                final int lllllllllllllIlllIIlIIIIIIlIllII = CustomColors.particleWaterColor & 0xFF;
                lllllllllllllIlllIIlIIIIIIllIIIl *= lllllllllllllIlllIIlIIIIIIlIlllI / 255.0f;
                lllllllllllllIlllIIlIIIIIIllIIII *= lllllllllllllIlllIIlIIIIIIlIllIl / 255.0f;
                lllllllllllllIlllIIlIIIIIIlIllll *= lllllllllllllIlllIIlIIIIIIlIllII / 255.0f;
            }
            lllllllllllllIlllIIlIIIIIIlIlIll.setRBGColorF(lllllllllllllIlllIIlIIIIIIllIIIl, lllllllllllllIlllIIlIIIIIIllIIII, lllllllllllllIlllIIlIIIIIIlIllll);
        }
    }
    
    private static CustomColormap getCustomColors(final String lllllllllllllIlllIIlIIIlIllllIll, final String[] lllllllllllllIlllIIlIIIllIIIIIIl, final int lllllllllllllIlllIIlIIIllIIIIIII, final int lllllllllllllIlllIIlIIIlIlllllll) {
        for (int lllllllllllllIlllIIlIIIlIllllllI = 0; lllllllllllllIlllIIlIIIlIllllllI < lllllllllllllIlllIIlIIIllIIIIIIl.length; ++lllllllllllllIlllIIlIIIlIllllllI) {
            String lllllllllllllIlllIIlIIIlIlllllIl = lllllllllllllIlllIIlIIIllIIIIIIl[lllllllllllllIlllIIlIIIlIllllllI];
            lllllllllllllIlllIIlIIIlIlllllIl = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIIlIIIlIllllIll)).append(lllllllllllllIlllIIlIIIlIlllllIl));
            final CustomColormap lllllllllllllIlllIIlIIIlIlllllII = getCustomColors(lllllllllllllIlllIIlIIIlIlllllIl, lllllllllllllIlllIIlIIIllIIIIIII, lllllllllllllIlllIIlIIIlIlllllll);
            if (lllllllllllllIlllIIlIIIlIlllllII != null) {
                return lllllllllllllIlllIIlIIIlIlllllII;
            }
        }
        return null;
    }
    
    private static int parseColor(String lllllllllllllIlllIIlIIIllIlIlIIl) {
        if (lllllllllllllIlllIIlIIIllIlIlIIl == null) {
            return -1;
        }
        lllllllllllllIlllIIlIIIllIlIlIIl = lllllllllllllIlllIIlIIIllIlIlIIl.trim();
        try {
            final int lllllllllllllIlllIIlIIIllIlIlIII = Integer.parseInt(lllllllllllllIlllIIlIIIllIlIlIIl, 16) & 0xFFFFFF;
            return lllllllllllllIlllIIlIIIllIlIlIII;
        }
        catch (NumberFormatException lllllllllllllIlllIIlIIIllIlIIlll) {
            return -1;
        }
    }
    
    private static void addToList(final CustomColormap lllllllllllllIlllIIlIIIlllIllIIl, final List lllllllllllllIlllIIlIIIlllIlllII, final int lllllllllllllIlllIIlIIIlllIlIlll) {
        while (lllllllllllllIlllIIlIIIlllIlIlll >= lllllllllllllIlllIIlIIIlllIlllII.size()) {
            lllllllllllllIlllIIlIIIlllIlllII.add(null);
        }
        List lllllllllllllIlllIIlIIIlllIllIlI = lllllllllllllIlllIIlIIIlllIlllII.get(lllllllllllllIlllIIlIIIlllIlIlll);
        if (lllllllllllllIlllIIlIIIlllIllIlI == null) {
            lllllllllllllIlllIIlIIIlllIllIlI = new ArrayList();
            lllllllllllllIlllIIlIIIlllIlllII.set(lllllllllllllIlllIIlIIIlllIlIlll, lllllllllllllIlllIIlIIIlllIllIlI);
        }
        lllllllllllllIlllIIlIIIlllIllIlI.add(lllllllllllllIlllIIlIIIlllIllIIl);
    }
    
    public static Vec3d getSkyColor(final Vec3d lllllllllllllIlllIIIlllllllllIll, final IBlockAccess lllllllllllllIlllIIIlllllllIlIlI, final double lllllllllllllIlllIIIlllllllIlIIl, final double lllllllllllllIlllIIIlllllllIlIII, final double lllllllllllllIlllIIIlllllllIIlll) {
        if (CustomColors.skyColors == null) {
            return lllllllllllllIlllIIIlllllllllIll;
        }
        final int lllllllllllllIlllIIIllllllllIllI = CustomColors.skyColors.getColorSmooth(lllllllllllllIlllIIIlllllllIlIlI, lllllllllllllIlllIIIlllllllIlIIl, lllllllllllllIlllIIIlllllllIlIII, lllllllllllllIlllIIIlllllllIIlll, 3);
        final int lllllllllllllIlllIIIllllllllIlIl = lllllllllllllIlllIIIllllllllIllI >> 16 & 0xFF;
        final int lllllllllllllIlllIIIllllllllIlII = lllllllllllllIlllIIIllllllllIllI >> 8 & 0xFF;
        final int lllllllllllllIlllIIIllllllllIIll = lllllllllllllIlllIIIllllllllIllI & 0xFF;
        float lllllllllllllIlllIIIllllllllIIlI = lllllllllllllIlllIIIllllllllIlIl / 255.0f;
        float lllllllllllllIlllIIIllllllllIIIl = lllllllllllllIlllIIIllllllllIlII / 255.0f;
        float lllllllllllllIlllIIIllllllllIIII = lllllllllllllIlllIIIllllllllIIll / 255.0f;
        final float lllllllllllllIlllIIIlllllllIllll = (float)lllllllllllllIlllIIIlllllllllIll.xCoord / 0.5f;
        final float lllllllllllllIlllIIIlllllllIlllI = (float)lllllllllllllIlllIIIlllllllllIll.yCoord / 0.66275f;
        final float lllllllllllllIlllIIIlllllllIllIl = (float)lllllllllllllIlllIIIlllllllllIll.zCoord;
        lllllllllllllIlllIIIllllllllIIlI *= lllllllllllllIlllIIIlllllllIllll;
        lllllllllllllIlllIIIllllllllIIIl *= lllllllllllllIlllIIIlllllllIlllI;
        lllllllllllllIlllIIIllllllllIIII *= lllllllllllllIlllIIIlllllllIllIl;
        final Vec3d lllllllllllllIlllIIIlllllllIllII = CustomColors.skyColorFader.getColor(lllllllllllllIlllIIIllllllllIIlI, lllllllllllllIlllIIIllllllllIIIl, lllllllllllllIlllIIIllllllllIIII);
        return lllllllllllllIlllIIIlllllllIllII;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$world$DimensionType() {
        final int[] $switch_TABLE$net$minecraft$world$DimensionType = CustomColors.$SWITCH_TABLE$net$minecraft$world$DimensionType;
        if ($switch_TABLE$net$minecraft$world$DimensionType != null) {
            return $switch_TABLE$net$minecraft$world$DimensionType;
        }
        final char lllllllllllllIlllIIIllIlIlllIIIl = (Object)new int[DimensionType.values().length];
        try {
            lllllllllllllIlllIIIllIlIlllIIIl[DimensionType.NETHER.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlllIIIllIlIlllIIIl[DimensionType.OVERWORLD.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlllIIIllIlIlllIIIl[DimensionType.THE_END.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return CustomColors.$SWITCH_TABLE$net$minecraft$world$DimensionType = (int[])(Object)lllllllllllllIlllIIIllIlIlllIIIl;
    }
    
    public static void updateMyceliumFX(final Particle lllllllllllllIlllIIlIIIIlIllIIlI) {
        if (CustomColors.myceliumParticleColors != null) {
            final int lllllllllllllIlllIIlIIIIlIlllIIl = CustomColors.myceliumParticleColors.getColorRandom();
            final int lllllllllllllIlllIIlIIIIlIlllIII = lllllllllllllIlllIIlIIIIlIlllIIl >> 16 & 0xFF;
            final int lllllllllllllIlllIIlIIIIlIllIlll = lllllllllllllIlllIIlIIIIlIlllIIl >> 8 & 0xFF;
            final int lllllllllllllIlllIIlIIIIlIllIllI = lllllllllllllIlllIIlIIIIlIlllIIl & 0xFF;
            final float lllllllllllllIlllIIlIIIIlIllIlIl = lllllllllllllIlllIIlIIIIlIlllIII / 255.0f;
            final float lllllllllllllIlllIIlIIIIlIllIlII = lllllllllllllIlllIIlIIIIlIllIlll / 255.0f;
            final float lllllllllllllIlllIIlIIIIlIllIIll = lllllllllllllIlllIIlIIIIlIllIllI / 255.0f;
            lllllllllllllIlllIIlIIIIlIllIIlI.setRBGColorF(lllllllllllllIlllIIlIIIIlIllIlIl, lllllllllllllIlllIIlIIIIlIllIlII, lllllllllllllIlllIIlIIIIlIllIIll);
        }
    }
    
    private static void setMapColors(final int[] lllllllllllllIlllIIIllIllIIIIlll) {
        if (lllllllllllllIlllIIIllIllIIIIlll != null) {
            final MapColor[] lllllllllllllIlllIIIllIllIIIllII = MapColor.COLORS;
            boolean lllllllllllllIlllIIIllIllIIIlIll = false;
            for (int lllllllllllllIlllIIIllIllIIIlIlI = 0; lllllllllllllIlllIIIllIllIIIlIlI < lllllllllllllIlllIIIllIllIIIllII.length && lllllllllllllIlllIIIllIllIIIlIlI < lllllllllllllIlllIIIllIllIIIIlll.length; ++lllllllllllllIlllIIIllIllIIIlIlI) {
                final MapColor lllllllllllllIlllIIIllIllIIIlIIl = lllllllllllllIlllIIIllIllIIIllII[lllllllllllllIlllIIIllIllIIIlIlI];
                if (lllllllllllllIlllIIIllIllIIIlIIl != null) {
                    final int lllllllllllllIlllIIIllIllIIIlIII = lllllllllllllIlllIIIllIllIIIIlll[lllllllllllllIlllIIIllIllIIIlIlI];
                    if (lllllllllllllIlllIIIllIllIIIlIII >= 0 && lllllllllllllIlllIIIllIllIIIlIIl.colorValue != lllllllllllllIlllIIIllIllIIIlIII) {
                        lllllllllllllIlllIIIllIllIIIlIIl.colorValue = lllllllllllllIlllIIIllIllIIIlIII;
                        lllllllllllllIlllIIIllIllIIIlIll = true;
                    }
                }
            }
            if (lllllllllllllIlllIIIllIllIIIlIll) {
                Minecraft.getMinecraft().getTextureManager().reloadBannerTextures();
            }
        }
    }
    
    private static int getTextureHeight(final String lllllllllllllIlllIIlIIlIIllIIllI, final int lllllllllllllIlllIIlIIlIIllIIIII) {
        try {
            final InputStream lllllllllllllIlllIIlIIlIIllIIlII = Config.getResourceStream(new ResourceLocation(lllllllllllllIlllIIlIIlIIllIIllI));
            if (lllllllllllllIlllIIlIIlIIllIIlII == null) {
                return lllllllllllllIlllIIlIIlIIllIIIII;
            }
            final BufferedImage lllllllllllllIlllIIlIIlIIllIIIll = ImageIO.read(lllllllllllllIlllIIlIIlIIllIIlII);
            lllllllllllllIlllIIlIIlIIllIIlII.close();
            return (lllllllllllllIlllIIlIIlIIllIIIll == null) ? lllllllllllllIlllIIlIIlIIllIIIII : lllllllllllllIlllIIlIIlIIllIIIll.getHeight();
        }
        catch (IOException lllllllllllllIlllIIlIIlIIllIIIlI) {
            return lllllllllllllIlllIIlIIlIIllIIIII;
        }
    }
    
    private static int readColor(final Properties lllllllllllllIlllIIlIIIllIllllII, final String[] lllllllllllllIlllIIlIIIlllIIIIII) {
        for (int lllllllllllllIlllIIlIIIllIllllll = 0; lllllllllllllIlllIIlIIIllIllllll < lllllllllllllIlllIIlIIIlllIIIIII.length; ++lllllllllllllIlllIIlIIIllIllllll) {
            final String lllllllllllllIlllIIlIIIllIlllllI = lllllllllllllIlllIIlIIIlllIIIIII[lllllllllllllIlllIIlIIIllIllllll];
            final int lllllllllllllIlllIIlIIIllIllllIl = readColor(lllllllllllllIlllIIlIIIllIllllII, lllllllllllllIlllIIlIIIllIlllllI);
            if (lllllllllllllIlllIIlIIIllIllllIl >= 0) {
                return lllllllllllllIlllIIlIIIllIllllIl;
            }
        }
        return -1;
    }
    
    private static void warn(final String lllllllllllllIlllIIIllIlIlllllII) {
        Config.warn(String.valueOf(new StringBuilder("CustomColors: ").append(lllllllllllllIlllIIIllIlIlllllII)));
    }
    
    private static int getSmoothColorMultiplier(final IBlockState lllllllllllllIlllIIlIIIlIIIIllIl, final IBlockAccess lllllllllllllIlllIIlIIIIlllllIlI, final BlockPos lllllllllllllIlllIIlIIIlIIIIlIll, final IColorizer lllllllllllllIlllIIlIIIlIIIIlIlI, final BlockPosM lllllllllllllIlllIIlIIIlIIIIlIIl) {
        int lllllllllllllIlllIIlIIIlIIIIlIII = 0;
        int lllllllllllllIlllIIlIIIlIIIIIlll = 0;
        int lllllllllllllIlllIIlIIIlIIIIIllI = 0;
        final int lllllllllllllIlllIIlIIIlIIIIIlIl = lllllllllllllIlllIIlIIIlIIIIlIll.getX();
        final int lllllllllllllIlllIIlIIIlIIIIIlII = lllllllllllllIlllIIlIIIlIIIIlIll.getY();
        final int lllllllllllllIlllIIlIIIlIIIIIIll = lllllllllllllIlllIIlIIIlIIIIlIll.getZ();
        final BlockPosM lllllllllllllIlllIIlIIIlIIIIIIlI = lllllllllllllIlllIIlIIIlIIIIlIIl;
        for (int lllllllllllllIlllIIlIIIlIIIIIIIl = lllllllllllllIlllIIlIIIlIIIIIlIl - 1; lllllllllllllIlllIIlIIIlIIIIIIIl <= lllllllllllllIlllIIlIIIlIIIIIlIl + 1; ++lllllllllllllIlllIIlIIIlIIIIIIIl) {
            for (int lllllllllllllIlllIIlIIIlIIIIIIII = lllllllllllllIlllIIlIIIlIIIIIIll - 1; lllllllllllllIlllIIlIIIlIIIIIIII <= lllllllllllllIlllIIlIIIlIIIIIIll + 1; ++lllllllllllllIlllIIlIIIlIIIIIIII) {
                lllllllllllllIlllIIlIIIlIIIIIIlI.setXyz(lllllllllllllIlllIIlIIIlIIIIIIIl, lllllllllllllIlllIIlIIIlIIIIIlII, lllllllllllllIlllIIlIIIlIIIIIIII);
                final int lllllllllllllIlllIIlIIIIllllllll = lllllllllllllIlllIIlIIIlIIIIlIlI.getColor(lllllllllllllIlllIIlIIIlIIIIllIl, lllllllllllllIlllIIlIIIIlllllIlI, lllllllllllllIlllIIlIIIlIIIIIIlI);
                lllllllllllllIlllIIlIIIlIIIIlIII += (lllllllllllllIlllIIlIIIIllllllll >> 16 & 0xFF);
                lllllllllllllIlllIIlIIIlIIIIIlll += (lllllllllllllIlllIIlIIIIllllllll >> 8 & 0xFF);
                lllllllllllllIlllIIlIIIlIIIIIllI += (lllllllllllllIlllIIlIIIIllllllll & 0xFF);
            }
        }
        final int lllllllllllllIlllIIlIIIIlllllllI = lllllllllllllIlllIIlIIIlIIIIlIII / 9;
        final int lllllllllllllIlllIIlIIIIllllllIl = lllllllllllllIlllIIlIIIlIIIIIlll / 9;
        final int lllllllllllllIlllIIlIIIIllllllII = lllllllllllllIlllIIlIIIlIIIIIllI / 9;
        return lllllllllllllIlllIIlIIIIlllllllI << 16 | lllllllllllllIlllIIlIIIIllllllIl << 8 | lllllllllllllIlllIIlIIIIllllllII;
    }
    
    public static int getPotionColor(final Potion lllllllllllllIlllIIIllIllIllIIIl, final int lllllllllllllIlllIIIllIllIllIIII) {
        int lllllllllllllIlllIIIllIllIlIllll = 0;
        if (lllllllllllllIlllIIIllIllIllIIIl != null) {
            lllllllllllllIlllIIIllIllIlIllll = Potion.getIdFromPotion(lllllllllllllIlllIIIllIllIllIIIl);
        }
        return getPotionColor(lllllllllllllIlllIIIllIllIlIllll, lllllllllllllIlllIIIllIllIllIIII);
    }
    
    static {
        CustomColors.paletteFormatDefault = "vanilla";
        CustomColors.waterColors = null;
        CustomColors.foliagePineColors = null;
        CustomColors.foliageBirchColors = null;
        CustomColors.swampFoliageColors = null;
        CustomColors.swampGrassColors = null;
        CustomColors.colorsBlockColormaps = null;
        CustomColors.blockColormaps = null;
        CustomColors.skyColors = null;
        CustomColors.skyColorFader = new CustomColorFader();
        CustomColors.fogColors = null;
        CustomColors.fogColorFader = new CustomColorFader();
        CustomColors.underwaterColors = null;
        CustomColors.underwaterColorFader = new CustomColorFader();
        CustomColors.underlavaColors = null;
        CustomColors.underlavaColorFader = new CustomColorFader();
        CustomColors.lightMapsColorsRgb = null;
        CustomColors.lightmapMinDimensionId = 0;
        CustomColors.sunRgbs = new float[16][3];
        CustomColors.torchRgbs = new float[16][3];
        CustomColors.redstoneColors = null;
        CustomColors.xpOrbColors = null;
        CustomColors.xpOrbTime = -1;
        CustomColors.durabilityColors = null;
        CustomColors.stemColors = null;
        CustomColors.stemMelonColors = null;
        CustomColors.stemPumpkinColors = null;
        CustomColors.myceliumParticleColors = null;
        CustomColors.useDefaultGrassFoliageColors = true;
        CustomColors.particleWaterColor = -1;
        CustomColors.particlePortalColor = -1;
        CustomColors.lilyPadColor = -1;
        CustomColors.expBarTextColor = -1;
        CustomColors.bossTextColor = -1;
        CustomColors.signTextColor = -1;
        CustomColors.fogColorNether = null;
        CustomColors.fogColorEnd = null;
        CustomColors.skyColorEnd = null;
        CustomColors.spawnEggPrimaryColors = null;
        CustomColors.spawnEggSecondaryColors = null;
        CustomColors.wolfCollarColors = null;
        CustomColors.sheepColors = null;
        CustomColors.textColors = null;
        CustomColors.mapColorsOriginal = null;
        CustomColors.potionColors = null;
        BLOCK_STATE_DIRT = Blocks.DIRT.getDefaultState();
        BLOCK_STATE_WATER = Blocks.WATER.getDefaultState();
        CustomColors.random = new Random();
        COLORIZER_GRASS = new IColorizer() {
            @Override
            public int getColor(final IBlockState lllllllllllllllIIIIIlIIIIlIllllI, final IBlockAccess lllllllllllllllIIIIIlIIIIlIlllIl, final BlockPos lllllllllllllllIIIIIlIIIIlIllIIl) {
                final Biome lllllllllllllllIIIIIlIIIIlIllIll = CustomColors.getColorBiome(lllllllllllllllIIIIIlIIIIlIlllIl, lllllllllllllllIIIIIlIIIIlIllIIl);
                return (CustomColors.swampGrassColors != null && lllllllllllllllIIIIIlIIIIlIllIll == Biomes.SWAMPLAND) ? CustomColors.swampGrassColors.getColor(lllllllllllllllIIIIIlIIIIlIllIll, lllllllllllllllIIIIIlIIIIlIllIIl) : lllllllllllllllIIIIIlIIIIlIllIll.getGrassColorAtPos(lllllllllllllllIIIIIlIIIIlIllIIl);
            }
            
            @Override
            public boolean isColorConstant() {
                return false;
            }
        };
        COLORIZER_FOLIAGE = new IColorizer() {
            @Override
            public boolean isColorConstant() {
                return false;
            }
            
            @Override
            public int getColor(final IBlockState llllllllllllllIIlIIllllIllllIlll, final IBlockAccess llllllllllllllIIlIIllllIllllIIll, final BlockPos llllllllllllllIIlIIllllIllllIlIl) {
                final Biome llllllllllllllIIlIIllllIllllIlII = CustomColors.getColorBiome(llllllllllllllIIlIIllllIllllIIll, llllllllllllllIIlIIllllIllllIlIl);
                return (CustomColors.swampFoliageColors != null && llllllllllllllIIlIIllllIllllIlII == Biomes.SWAMPLAND) ? CustomColors.swampFoliageColors.getColor(llllllllllllllIIlIIllllIllllIlII, llllllllllllllIIlIIllllIllllIlIl) : llllllllllllllIIlIIllllIllllIlII.getFoliageColorAtPos(llllllllllllllIIlIIllllIllllIlIl);
            }
        };
        COLORIZER_FOLIAGE_PINE = new IColorizer() {
            @Override
            public int getColor(final IBlockState lllllllllllllllIlIIlllIIlIlIlIIl, final IBlockAccess lllllllllllllllIlIIlllIIlIlIlIII, final BlockPos lllllllllllllllIlIIlllIIlIlIIlIl) {
                return (CustomColors.foliagePineColors != null) ? CustomColors.foliagePineColors.getColor(lllllllllllllllIlIIlllIIlIlIlIII, lllllllllllllllIlIIlllIIlIlIIlIl) : ColorizerFoliage.getFoliageColorPine();
            }
            
            @Override
            public boolean isColorConstant() {
                return CustomColors.foliagePineColors == null;
            }
        };
        COLORIZER_FOLIAGE_BIRCH = new IColorizer() {
            @Override
            public int getColor(final IBlockState lIlIlllIlllII, final IBlockAccess lIlIlllIllIll, final BlockPos lIlIlllIllIlI) {
                return (CustomColors.foliageBirchColors != null) ? CustomColors.foliageBirchColors.getColor(lIlIlllIllIll, lIlIlllIllIlI) : ColorizerFoliage.getFoliageColorBirch();
            }
            
            @Override
            public boolean isColorConstant() {
                return CustomColors.foliageBirchColors == null;
            }
        };
        COLORIZER_WATER = new IColorizer() {
            @Override
            public boolean isColorConstant() {
                return false;
            }
            
            @Override
            public int getColor(final IBlockState llllllllllllllllIIIllllIlllIIIll, final IBlockAccess llllllllllllllllIIIllllIllIlllll, final BlockPos llllllllllllllllIIIllllIllIllllI) {
                final Biome llllllllllllllllIIIllllIlllIIIII = CustomColors.getColorBiome(llllllllllllllllIIIllllIllIlllll, llllllllllllllllIIIllllIllIllllI);
                if (CustomColors.waterColors != null) {
                    return CustomColors.waterColors.getColor(llllllllllllllllIIIllllIlllIIIII, llllllllllllllllIIIllllIllIllllI);
                }
                return Reflector.ForgeBiome_getWaterColorMultiplier.exists() ? Reflector.callInt(llllllllllllllllIIIllllIlllIIIII, Reflector.ForgeBiome_getWaterColorMultiplier, new Object[0]) : llllllllllllllllIIIllllIlllIIIII.getWaterColor();
            }
        };
    }
    
    private static Vec3d readColorVec3(final Properties lllllllllllllIlllIIlIIIllIIllIll, final String lllllllllllllIlllIIlIIIllIIlIIIl) {
        final int lllllllllllllIlllIIlIIIllIIllIIl = readColor(lllllllllllllIlllIIlIIIllIIllIll, lllllllllllllIlllIIlIIIllIIlIIIl);
        if (lllllllllllllIlllIIlIIIllIIllIIl < 0) {
            return null;
        }
        final int lllllllllllllIlllIIlIIIllIIllIII = lllllllllllllIlllIIlIIIllIIllIIl >> 16 & 0xFF;
        final int lllllllllllllIlllIIlIIIllIIlIlll = lllllllllllllIlllIIlIIIllIIllIIl >> 8 & 0xFF;
        final int lllllllllllllIlllIIlIIIllIIlIllI = lllllllllllllIlllIIlIIIllIIllIIl & 0xFF;
        final float lllllllllllllIlllIIlIIIllIIlIlIl = lllllllllllllIlllIIlIIIllIIllIII / 255.0f;
        final float lllllllllllllIlllIIlIIIllIIlIlII = lllllllllllllIlllIIlIIIllIIlIlll / 255.0f;
        final float lllllllllllllIlllIIlIIIllIIlIIll = lllllllllllllIlllIIlIIIllIIlIllI / 255.0f;
        return new Vec3d(lllllllllllllIlllIIlIIIllIIlIlIl, lllllllllllllIlllIIlIIIllIIlIlII, lllllllllllllIlllIIlIIIllIIlIIll);
    }
    
    private static int getMapColorIndex(final String lllllllllllllIlllIIIllIllIlIIIII) {
        if (lllllllllllllIlllIIIllIllIlIIIII == null) {
            return -1;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("air")) {
            return MapColor.AIR.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("grass")) {
            return MapColor.GRASS.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("sand")) {
            return MapColor.SAND.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("cloth")) {
            return MapColor.CLOTH.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("tnt")) {
            return MapColor.TNT.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("ice")) {
            return MapColor.ICE.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("iron")) {
            return MapColor.IRON.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("foliage")) {
            return MapColor.FOLIAGE.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("clay")) {
            return MapColor.CLAY.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("dirt")) {
            return MapColor.DIRT.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("stone")) {
            return MapColor.STONE.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("water")) {
            return MapColor.WATER.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("wood")) {
            return MapColor.WOOD.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("quartz")) {
            return MapColor.QUARTZ.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("gold")) {
            return MapColor.GOLD.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("diamond")) {
            return MapColor.DIAMOND.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("lapis")) {
            return MapColor.LAPIS.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("emerald")) {
            return MapColor.EMERALD.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("podzol")) {
            return MapColor.OBSIDIAN.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("netherrack")) {
            return MapColor.NETHERRACK.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("snow") || lllllllllllllIlllIIIllIllIlIIIII.equals("white")) {
            return MapColor.SNOW.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("adobe") || lllllllllllllIlllIIIllIllIlIIIII.equals("orange")) {
            return MapColor.ADOBE.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("magenta")) {
            return MapColor.MAGENTA.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("light_blue") || lllllllllllllIlllIIIllIllIlIIIII.equals("lightBlue")) {
            return MapColor.LIGHT_BLUE.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("yellow")) {
            return MapColor.YELLOW.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("lime")) {
            return MapColor.LIME.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("pink")) {
            return MapColor.PINK.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("gray")) {
            return MapColor.GRAY.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("silver")) {
            return MapColor.SILVER.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("cyan")) {
            return MapColor.CYAN.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("purple")) {
            return MapColor.PURPLE.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("blue")) {
            return MapColor.BLUE.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("brown")) {
            return MapColor.BROWN.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("green")) {
            return MapColor.GREEN.colorIndex;
        }
        if (lllllllllllllIlllIIIllIllIlIIIII.equals("red")) {
            return MapColor.RED.colorIndex;
        }
        return lllllllllllllIlllIIIllIllIlIIIII.equals("black") ? MapColor.BLACK.colorIndex : -1;
    }
    
    public static int getSignTextColor(final int lllllllllllllIlllIIIllIlIlllIIll) {
        return (CustomColors.signTextColor < 0) ? lllllllllllllIlllIIIllIlIlllIIll : CustomColors.signTextColor;
    }
    
    public static int getXpOrbColor(final float lllllllllllllIlllIIlIIIIIlIlllll) {
        if (CustomColors.xpOrbColors == null) {
            return -1;
        }
        final int lllllllllllllIlllIIlIIIIIlIllllI = (int)Math.round((MathHelper.sin(lllllllllllllIlllIIlIIIIIlIlllll) + 1.0f) * (CustomColors.xpOrbColors.getLength() - 1) / 2.0);
        final int lllllllllllllIlllIIlIIIIIlIlllIl = CustomColors.xpOrbColors.getColor(lllllllllllllIlllIIlIIIIIlIllllI);
        return lllllllllllllIlllIIlIIIIIlIlllIl;
    }
    
    public static int getPotionId(String lllllllllllllIlllIIIllIllIlllIll) {
        if (lllllllllllllIlllIIIllIllIlllIll.equals("potion.water")) {
            return 0;
        }
        lllllllllllllIlllIIIllIllIlllIll = StrUtils.replacePrefix(lllllllllllllIlllIIIllIllIlllIll, "potion.", "effect.");
        for (final ResourceLocation lllllllllllllIlllIIIllIllIlllIlI : Potion.REGISTRY.getKeys()) {
            final Potion lllllllllllllIlllIIIllIllIlllIIl = Potion.REGISTRY.getObject(lllllllllllllIlllIIIllIllIlllIlI);
            if (lllllllllllllIlllIIIllIllIlllIIl.getName().equals(lllllllllllllIlllIIIllIllIlllIll)) {
                return Potion.getIdFromPotion(lllllllllllllIlllIIIllIllIlllIIl);
            }
        }
        return -1;
    }
    
    public static Vec3d getWorldFogColor(Vec3d lllllllllllllIlllIIIlllIllIlllIl, final World lllllllllllllIlllIIIlllIllIlllII, final Entity lllllllllllllIlllIIIlllIlllIIIIl, final float lllllllllllllIlllIIIlllIlllIIIII) {
        final DimensionType lllllllllllllIlllIIIlllIllIlllll = lllllllllllllIlllIIIlllIllIlllII.provider.getDimensionType();
        switch ($SWITCH_TABLE$net$minecraft$world$DimensionType()[lllllllllllllIlllIIIlllIllIlllll.ordinal()]) {
            case 2: {
                lllllllllllllIlllIIIlllIllIlllIl = getFogColorNether((Vec3d)lllllllllllllIlllIIIlllIllIlllIl);
                break;
            }
            case 1: {
                final Minecraft lllllllllllllIlllIIIlllIllIllllI = Minecraft.getMinecraft();
                lllllllllllllIlllIIIlllIllIlllIl = getFogColor((Vec3d)lllllllllllllIlllIIIlllIllIlllIl, lllllllllllllIlllIIIlllIllIllllI.world, lllllllllllllIlllIIIlllIlllIIIIl.posX, lllllllllllllIlllIIIlllIlllIIIIl.posY + 1.0, lllllllllllllIlllIIIlllIlllIIIIl.posZ);
                break;
            }
            case 3: {
                lllllllllllllIlllIIIlllIllIlllIl = getFogColorEnd((Vec3d)lllllllllllllIlllIIIlllIllIlllIl);
                break;
            }
        }
        return (Vec3d)lllllllllllllIlllIIIlllIllIlllIl;
    }
    
    private static int getStemColorMultiplier(final Block lllllllllllllIlllIIIllllIlIlllll, final IBlockAccess lllllllllllllIlllIIIllllIllIIlII, final BlockPos lllllllllllllIlllIIIllllIllIIIll, final RenderEnv lllllllllllllIlllIIIllllIllIIIlI) {
        CustomColormap lllllllllllllIlllIIIllllIllIIIIl = CustomColors.stemColors;
        if (lllllllllllllIlllIIIllllIlIlllll == Blocks.PUMPKIN_STEM && CustomColors.stemPumpkinColors != null) {
            lllllllllllllIlllIIIllllIllIIIIl = CustomColors.stemPumpkinColors;
        }
        if (lllllllllllllIlllIIIllllIlIlllll == Blocks.MELON_STEM && CustomColors.stemMelonColors != null) {
            lllllllllllllIlllIIIllllIllIIIIl = CustomColors.stemMelonColors;
        }
        if (lllllllllllllIlllIIIllllIllIIIIl == null) {
            return -1;
        }
        final int lllllllllllllIlllIIIllllIllIIIII = lllllllllllllIlllIIIllllIllIIIlI.getMetadata();
        return lllllllllllllIlllIIIllllIllIIIIl.getColor(lllllllllllllIlllIIIllllIllIIIII);
    }
    
    private static int getRedstoneLevel(final IBlockState lllllllllllllIlllIIlIIIIIlllIIlI, final int lllllllllllllIlllIIlIIIIIllIllII) {
        final Block lllllllllllllIlllIIlIIIIIlllIIII = lllllllllllllIlllIIlIIIIIlllIIlI.getBlock();
        if (!(lllllllllllllIlllIIlIIIIIlllIIII instanceof BlockRedstoneWire)) {
            return lllllllllllllIlllIIlIIIIIllIllII;
        }
        final Object lllllllllllllIlllIIlIIIIIllIllll = lllllllllllllIlllIIlIIIIIlllIIlI.getValue((IProperty<Object>)BlockRedstoneWire.POWER);
        if (!(lllllllllllllIlllIIlIIIIIllIllll instanceof Integer)) {
            return lllllllllllllIlllIIlIIIIIllIllII;
        }
        final Integer lllllllllllllIlllIIlIIIIIllIlllI = (Integer)lllllllllllllIlllIIlIIIIIllIllll;
        return lllllllllllllIlllIIlIIIIIllIlllI;
    }
    
    private static CustomColormap getBlockColormap(final IBlockState lllllllllllllIlllIIlIIIlIIlIIIlI) {
        if (CustomColors.blockColormaps == null) {
            return null;
        }
        if (!(lllllllllllllIlllIIlIIIlIIlIIIlI instanceof BlockStateBase)) {
            return null;
        }
        final BlockStateBase lllllllllllllIlllIIlIIIlIIlIIlll = (BlockStateBase)lllllllllllllIlllIIlIIIlIIlIIIlI;
        final int lllllllllllllIlllIIlIIIlIIlIIllI = lllllllllllllIlllIIlIIIlIIlIIlll.getBlockId();
        if (lllllllllllllIlllIIlIIIlIIlIIllI < 0 || lllllllllllllIlllIIlIIIlIIlIIllI >= CustomColors.blockColormaps.length) {
            return null;
        }
        final CustomColormap[] lllllllllllllIlllIIlIIIlIIlIIlIl = CustomColors.blockColormaps[lllllllllllllIlllIIlIIIlIIlIIllI];
        if (lllllllllllllIlllIIlIIIlIIlIIlIl == null) {
            return null;
        }
        for (int lllllllllllllIlllIIlIIIlIIlIIlII = 0; lllllllllllllIlllIIlIIIlIIlIIlII < lllllllllllllIlllIIlIIIlIIlIIlIl.length; ++lllllllllllllIlllIIlIIIlIIlIIlII) {
            final CustomColormap lllllllllllllIlllIIlIIIlIIlIIIll = lllllllllllllIlllIIlIIIlIIlIIlIl[lllllllllllllIlllIIlIIIlIIlIIlII];
            if (lllllllllllllIlllIIlIIIlIIlIIIll.matchesBlock(lllllllllllllIlllIIlIIIlIIlIIlll)) {
                return lllllllllllllIlllIIlIIIlIIlIIIll;
            }
        }
        return null;
    }
    
    public static Vec3d getUnderlavaColor(final IBlockAccess lllllllllllllIlllIIIlllllIIlIlll, final double lllllllllllllIlllIIIlllllIIlIllI, final double lllllllllllllIlllIIIlllllIIlIlIl, final double lllllllllllllIlllIIIlllllIIlIlII) {
        return getUnderFluidColor(lllllllllllllIlllIIIlllllIIlIlll, lllllllllllllIlllIIIlllllIIlIllI, lllllllllllllIlllIIIlllllIIlIlIl, lllllllllllllIlllIIIlllllIIlIlII, CustomColors.underlavaColors, CustomColors.underlavaColorFader);
    }
    
    private static float[] getDyeColors(final EnumDyeColor lllllllllllllIlllIIIlllIIlIIIllI, final float[][] lllllllllllllIlllIIIlllIIlIIIlIl, final float[] lllllllllllllIlllIIIlllIIlIIIlII) {
        if (lllllllllllllIlllIIIlllIIlIIIlIl == null) {
            return lllllllllllllIlllIIIlllIIlIIIlII;
        }
        if (lllllllllllllIlllIIIlllIIlIIIllI == null) {
            return lllllllllllllIlllIIIlllIIlIIIlII;
        }
        final float[] lllllllllllllIlllIIIlllIIlIIIlll = lllllllllllllIlllIIIlllIIlIIIlIl[lllllllllllllIlllIIIlllIIlIIIllI.ordinal()];
        return (lllllllllllllIlllIIIlllIIlIIIlll == null) ? lllllllllllllIlllIIIlllIIlIIIlII : lllllllllllllIlllIIIlllIIlIIIlll;
    }
    
    private static void dbg(final String lllllllllllllIlllIIIllIllIIIIIII) {
        Config.dbg(String.valueOf(new StringBuilder("CustomColors: ").append(lllllllllllllIlllIIIllIllIIIIIII)));
    }
    
    public static float[] getWolfCollarColors(final EnumDyeColor lllllllllllllIlllIIIlllIIIlllllI, final float[] lllllllllllllIlllIIIlllIIIllllIl) {
        return getDyeColors(lllllllllllllIlllIIIlllIIIlllllI, CustomColors.wolfCollarColors, lllllllllllllIlllIIIlllIIIllllIl);
    }
    
    private static Vec3d getFogColorNether(final Vec3d lllllllllllllIlllIIlIIIIIIIlIIll) {
        return (CustomColors.fogColorNether == null) ? lllllllllllllIlllIIlIIIIIIIlIIll : CustomColors.fogColorNether;
    }
    
    public static void updateReddustFX(final Particle lllllllllllllIlllIIlIIIIlIIIIlIl, final IBlockAccess lllllllllllllIlllIIlIIIIlIIlIIlI, final double lllllllllllllIlllIIlIIIIlIIlIIIl, final double lllllllllllllIlllIIlIIIIlIIIIIlI, final double lllllllllllllIlllIIlIIIIlIIIIIIl) {
        if (CustomColors.redstoneColors != null) {
            final IBlockState lllllllllllllIlllIIlIIIIlIIIlllI = lllllllllllllIlllIIlIIIIlIIlIIlI.getBlockState(new BlockPos(lllllllllllllIlllIIlIIIIlIIlIIIl, lllllllllllllIlllIIlIIIIlIIIIIlI, lllllllllllllIlllIIlIIIIlIIIIIIl));
            final int lllllllllllllIlllIIlIIIIlIIIllIl = getRedstoneLevel(lllllllllllllIlllIIlIIIIlIIIlllI, 15);
            final int lllllllllllllIlllIIlIIIIlIIIllII = CustomColors.redstoneColors.getColor(lllllllllllllIlllIIlIIIIlIIIllIl);
            final int lllllllllllllIlllIIlIIIIlIIIlIll = lllllllllllllIlllIIlIIIIlIIIllII >> 16 & 0xFF;
            final int lllllllllllllIlllIIlIIIIlIIIlIlI = lllllllllllllIlllIIlIIIIlIIIllII >> 8 & 0xFF;
            final int lllllllllllllIlllIIlIIIIlIIIlIIl = lllllllllllllIlllIIlIIIIlIIIllII & 0xFF;
            final float lllllllllllllIlllIIlIIIIlIIIlIII = lllllllllllllIlllIIlIIIIlIIIlIll / 255.0f;
            final float lllllllllllllIlllIIlIIIIlIIIIlll = lllllllllllllIlllIIlIIIIlIIIlIlI / 255.0f;
            final float lllllllllllllIlllIIlIIIIlIIIIllI = lllllllllllllIlllIIlIIIIlIIIlIIl / 255.0f;
            lllllllllllllIlllIIlIIIIlIIIIlIl.setRBGColorF(lllllllllllllIlllIIlIIIIlIIIlIII, lllllllllllllIlllIIlIIIIlIIIIlll, lllllllllllllIlllIIlIIIIlIIIIllI);
        }
    }
    
    private static int getLilypadColorMultiplier(final IBlockAccess lllllllllllllIlllIIlIIIIIIIlIllI, final BlockPos lllllllllllllIlllIIlIIIIIIIlIlll) {
        return (CustomColors.lilyPadColor < 0) ? getBlockColors().colorMultiplier(Blocks.WATERLILY.getDefaultState(), lllllllllllllIlllIIlIIIIIIIlIllI, lllllllllllllIlllIIlIIIIIIIlIlll, 0) : CustomColors.lilyPadColor;
    }
    
    public static int getPotionColor(final int lllllllllllllIlllIIIllIllIlIlIII, final int lllllllllllllIlllIIIllIllIlIIlII) {
        if (CustomColors.potionColors == null) {
            return lllllllllllllIlllIIIllIllIlIIlII;
        }
        if (lllllllllllllIlllIIIllIllIlIlIII >= 0 && lllllllllllllIlllIIIllIllIlIlIII < CustomColors.potionColors.length) {
            final int lllllllllllllIlllIIIllIllIlIIllI = CustomColors.potionColors[lllllllllllllIlllIIIllIllIlIlIII];
            return (lllllllllllllIlllIIIllIllIlIIllI < 0) ? lllllllllllllIlllIIIllIllIlIIlII : lllllllllllllIlllIIIllIllIlIIllI;
        }
        return lllllllllllllIlllIIIllIllIlIIlII;
    }
    
    private static void readColorProperties(final String lllllllllllllIlllIIlIIlIIlIllIII) {
        try {
            final ResourceLocation lllllllllllllIlllIIlIIlIIlIlIlll = new ResourceLocation(lllllllllllllIlllIIlIIlIIlIllIII);
            final InputStream lllllllllllllIlllIIlIIlIIlIlIllI = Config.getResourceStream(lllllllllllllIlllIIlIIlIIlIlIlll);
            if (lllllllllllllIlllIIlIIlIIlIlIllI == null) {
                return;
            }
            dbg(String.valueOf(new StringBuilder("Loading ").append(lllllllllllllIlllIIlIIlIIlIllIII)));
            final Properties lllllllllllllIlllIIlIIlIIlIlIlIl = new Properties();
            lllllllllllllIlllIIlIIlIIlIlIlIl.load(lllllllllllllIlllIIlIIlIIlIlIllI);
            lllllllllllllIlllIIlIIlIIlIlIllI.close();
            CustomColors.particleWaterColor = readColor(lllllllllllllIlllIIlIIlIIlIlIlIl, new String[] { "particle.water", "drop.water" });
            CustomColors.particlePortalColor = readColor(lllllllllllllIlllIIlIIlIIlIlIlIl, "particle.portal");
            CustomColors.lilyPadColor = readColor(lllllllllllllIlllIIlIIlIIlIlIlIl, "lilypad");
            CustomColors.expBarTextColor = readColor(lllllllllllllIlllIIlIIlIIlIlIlIl, "text.xpbar");
            CustomColors.bossTextColor = readColor(lllllllllllllIlllIIlIIlIIlIlIlIl, "text.boss");
            CustomColors.signTextColor = readColor(lllllllllllllIlllIIlIIlIIlIlIlIl, "text.sign");
            CustomColors.fogColorNether = readColorVec3(lllllllllllllIlllIIlIIlIIlIlIlIl, "fog.nether");
            CustomColors.fogColorEnd = readColorVec3(lllllllllllllIlllIIlIIlIIlIlIlIl, "fog.end");
            CustomColors.skyColorEnd = readColorVec3(lllllllllllllIlllIIlIIlIIlIlIlIl, "sky.end");
            CustomColors.colorsBlockColormaps = readCustomColormaps(lllllllllllllIlllIIlIIlIIlIlIlIl, lllllllllllllIlllIIlIIlIIlIllIII);
            CustomColors.spawnEggPrimaryColors = readSpawnEggColors(lllllllllllllIlllIIlIIlIIlIlIlIl, lllllllllllllIlllIIlIIlIIlIllIII, "egg.shell.", "Spawn egg shell");
            CustomColors.spawnEggSecondaryColors = readSpawnEggColors(lllllllllllllIlllIIlIIlIIlIlIlIl, lllllllllllllIlllIIlIIlIIlIllIII, "egg.spots.", "Spawn egg spot");
            CustomColors.wolfCollarColors = readDyeColors(lllllllllllllIlllIIlIIlIIlIlIlIl, lllllllllllllIlllIIlIIlIIlIllIII, "collar.", "Wolf collar");
            CustomColors.sheepColors = readDyeColors(lllllllllllllIlllIIlIIlIIlIlIlIl, lllllllllllllIlllIIlIIlIIlIllIII, "sheep.", "Sheep");
            CustomColors.textColors = readTextColors(lllllllllllllIlllIIlIIlIIlIlIlIl, lllllllllllllIlllIIlIIlIIlIllIII, "text.code.", "Text");
            final int[] lllllllllllllIlllIIlIIlIIlIlIlII = readMapColors(lllllllllllllIlllIIlIIlIIlIlIlIl, lllllllllllllIlllIIlIIlIIlIllIII, "map.", "Map");
            if (lllllllllllllIlllIIlIIlIIlIlIlII != null) {
                if (CustomColors.mapColorsOriginal == null) {
                    CustomColors.mapColorsOriginal = getMapColors();
                }
                setMapColors(lllllllllllllIlllIIlIIlIIlIlIlII);
            }
            CustomColors.potionColors = readPotionColors(lllllllllllllIlllIIlIIlIIlIlIlIl, lllllllllllllIlllIIlIIlIIlIllIII, "potion.", "Potion");
            CustomColors.xpOrbTime = Config.parseInt(lllllllllllllIlllIIlIIlIIlIlIlIl.getProperty("xporb.time"), -1);
        }
        catch (FileNotFoundException lllllllllllllIlllIIlIIlIIlIlIIll) {}
        catch (IOException lllllllllllllIlllIIlIIlIIlIlIIlI) {
            lllllllllllllIlllIIlIIlIIlIlIIlI.printStackTrace();
        }
    }
    
    private static void addToBlockList(final CustomColormap lllllllllllllIlllIIlIIIllllIIllI, final List lllllllllllllIlllIIlIIIllllIlIlI) {
        final int[] lllllllllllllIlllIIlIIIllllIlIIl = lllllllllllllIlllIIlIIIllllIIllI.getMatchBlockIds();
        if (lllllllllllllIlllIIlIIIllllIlIIl != null && lllllllllllllIlllIIlIIIllllIlIIl.length > 0) {
            for (int lllllllllllllIlllIIlIIIllllIlIII = 0; lllllllllllllIlllIIlIIIllllIlIII < lllllllllllllIlllIIlIIIllllIlIIl.length; ++lllllllllllllIlllIIlIIIllllIlIII) {
                final int lllllllllllllIlllIIlIIIllllIIlll = lllllllllllllIlllIIlIIIllllIlIIl[lllllllllllllIlllIIlIIIllllIlIII];
                if (lllllllllllllIlllIIlIIIllllIIlll < 0) {
                    warn(String.valueOf(new StringBuilder("Invalid block ID: ").append(lllllllllllllIlllIIlIIIllllIIlll)));
                }
                else {
                    addToList(lllllllllllllIlllIIlIIIllllIIllI, lllllllllllllIlllIIlIIIllllIlIlI, lllllllllllllIlllIIlIIIllllIIlll);
                }
            }
        }
        else {
            warn(String.valueOf(new StringBuilder("No match blocks: ").append(Config.arrayToString(lllllllllllllIlllIIlIIIllllIlIIl))));
        }
    }
    
    public static Vec3d getUnderFluidColor(final IBlockAccess lllllllllllllIlllIIIllllIlllIlll, final double lllllllllllllIlllIIIlllllIIIIlII, final double lllllllllllllIlllIIIllllIlllIlIl, final double lllllllllllllIlllIIIllllIlllIlII, final CustomColormap lllllllllllllIlllIIIlllllIIIIIIl, final CustomColorFader lllllllllllllIlllIIIlllllIIIIIII) {
        if (lllllllllllllIlllIIIlllllIIIIIIl == null) {
            return null;
        }
        final int lllllllllllllIlllIIIllllIlllllll = lllllllllllllIlllIIIlllllIIIIIIl.getColorSmooth(lllllllllllllIlllIIIllllIlllIlll, lllllllllllllIlllIIIlllllIIIIlII, lllllllllllllIlllIIIllllIlllIlIl, lllllllllllllIlllIIIllllIlllIlII, 3);
        final int lllllllllllllIlllIIIllllIllllllI = lllllllllllllIlllIIIllllIlllllll >> 16 & 0xFF;
        final int lllllllllllllIlllIIIllllIlllllIl = lllllllllllllIlllIIIllllIlllllll >> 8 & 0xFF;
        final int lllllllllllllIlllIIIllllIlllllII = lllllllllllllIlllIIIllllIlllllll & 0xFF;
        final float lllllllllllllIlllIIIllllIllllIll = lllllllllllllIlllIIIllllIllllllI / 255.0f;
        final float lllllllllllllIlllIIIllllIllllIlI = lllllllllllllIlllIIIllllIlllllIl / 255.0f;
        final float lllllllllllllIlllIIIllllIllllIIl = lllllllllllllIlllIIIllllIlllllII / 255.0f;
        final Vec3d lllllllllllllIlllIIIllllIllllIII = lllllllllllllIlllIIIlllllIIIIIII.getColor(lllllllllllllIlllIIIllllIllllIll, lllllllllllllIlllIIIllllIllllIlI, lllllllllllllIlllIIIllllIllllIIl);
        return lllllllllllllIlllIIIllllIllllIII;
    }
    
    private static int[] readTextColors(final Properties lllllllllllllIlllIIIlllIIIlIlIll, final String lllllllllllllIlllIIIlllIIIlIlIlI, final String lllllllllllllIlllIIIlllIIIIlllll, final String lllllllllllllIlllIIIlllIIIlIlIII) {
        final int[] lllllllllllllIlllIIIlllIIIlIIlll = new int[32];
        Arrays.fill(lllllllllllllIlllIIIlllIIIlIIlll, -1);
        int lllllllllllllIlllIIIlllIIIlIIllI = 0;
        for (final Object lllllllllllllIlllIIIlllIIIlIIlIl : ((Hashtable<Object, V>)lllllllllllllIlllIIIlllIIIlIlIll).keySet()) {
            final String lllllllllllllIlllIIIlllIIIlIIlII = lllllllllllllIlllIIIlllIIIlIlIll.getProperty((String)lllllllllllllIlllIIIlllIIIlIIlIl);
            if (((String)lllllllllllllIlllIIIlllIIIlIIlIl).startsWith(lllllllllllllIlllIIIlllIIIIlllll)) {
                final String lllllllllllllIlllIIIlllIIIlIIIll = StrUtils.removePrefix((String)lllllllllllllIlllIIIlllIIIlIIlIl, lllllllllllllIlllIIIlllIIIIlllll);
                final int lllllllllllllIlllIIIlllIIIlIIIlI = Config.parseInt(lllllllllllllIlllIIIlllIIIlIIIll, -1);
                final int lllllllllllllIlllIIIlllIIIlIIIIl = parseColor(lllllllllllllIlllIIIlllIIIlIIlII);
                if (lllllllllllllIlllIIIlllIIIlIIIlI >= 0 && lllllllllllllIlllIIIlllIIIlIIIlI < lllllllllllllIlllIIIlllIIIlIIlll.length && lllllllllllllIlllIIIlllIIIlIIIIl >= 0) {
                    lllllllllllllIlllIIIlllIIIlIIlll[lllllllllllllIlllIIIlllIIIlIIIlI] = lllllllllllllIlllIIIlllIIIlIIIIl;
                    ++lllllllllllllIlllIIIlllIIIlIIllI;
                }
                else {
                    warn(String.valueOf(new StringBuilder("Invalid color: ").append(lllllllllllllIlllIIIlllIIIlIIlIl).append(" = ").append(lllllllllllllIlllIIIlllIIIlIIlII)));
                }
            }
        }
        if (lllllllllllllIlllIIIlllIIIlIIllI <= 0) {
            return null;
        }
        dbg(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIIIlllIIIlIlIII)).append(" colors: ").append(lllllllllllllIlllIIIlllIIIlIIllI)));
        return lllllllllllllIlllIIIlllIIIlIIlll;
    }
    
    private static Vec3d getFogColorEnd(final Vec3d lllllllllllllIlllIIlIIIIIIIIllll) {
        return (CustomColors.fogColorEnd == null) ? lllllllllllllIlllIIlIIIIIIIIllll : CustomColors.fogColorEnd;
    }
    
    public static int getExpBarTextColor(final int lllllllllllllIlllIIIllIlIllllIlI) {
        return (CustomColors.expBarTextColor < 0) ? lllllllllllllIlllIIIllIlIllllIlI : CustomColors.expBarTextColor;
    }
    
    private static int getSpawnEggColor(final ItemMonsterPlacer lllllllllllllIlllIIIlllIlIIllIIl, final ItemStack lllllllllllllIlllIIIlllIlIIIllll, final int lllllllllllllIlllIIIlllIlIIIlllI, final int lllllllllllllIlllIIIlllIlIIIllIl) {
        if (CustomColors.spawnEggPrimaryColors == null && CustomColors.spawnEggSecondaryColors == null) {
            return lllllllllllllIlllIIIlllIlIIIllIl;
        }
        final NBTTagCompound lllllllllllllIlllIIIlllIlIIlIlIl = lllllllllllllIlllIIIlllIlIIIllll.getTagCompound();
        if (lllllllllllllIlllIIIlllIlIIlIlIl == null) {
            return lllllllllllllIlllIIIlllIlIIIllIl;
        }
        final NBTTagCompound lllllllllllllIlllIIIlllIlIIlIlII = lllllllllllllIlllIIIlllIlIIlIlIl.getCompoundTag("EntityTag");
        if (lllllllllllllIlllIIIlllIlIIlIlII == null) {
            return lllllllllllllIlllIIIlllIlIIIllIl;
        }
        final String lllllllllllllIlllIIIlllIlIIlIIll = lllllllllllllIlllIIIlllIlIIlIlII.getString("id");
        final int lllllllllllllIlllIIIlllIlIIlIIlI = EntityUtils.getEntityIdByLocation(lllllllllllllIlllIIIlllIlIIlIIll);
        final int[] lllllllllllllIlllIIIlllIlIIlIIIl = (lllllllllllllIlllIIIlllIlIIIlllI == 0) ? CustomColors.spawnEggPrimaryColors : CustomColors.spawnEggSecondaryColors;
        if (lllllllllllllIlllIIIlllIlIIlIIIl == null) {
            return lllllllllllllIlllIIIlllIlIIIllIl;
        }
        if (lllllllllllllIlllIIIlllIlIIlIIlI >= 0 && lllllllllllllIlllIIIlllIlIIlIIlI < lllllllllllllIlllIIIlllIlIIlIIIl.length) {
            final int lllllllllllllIlllIIIlllIlIIlIIII = lllllllllllllIlllIIIlllIlIIlIIIl[lllllllllllllIlllIIIlllIlIIlIIlI];
            return (lllllllllllllIlllIIIlllIlIIlIIII < 0) ? lllllllllllllIlllIIIlllIlIIIllIl : lllllllllllllIlllIIIlllIlIIlIIII;
        }
        return lllllllllllllIlllIIIlllIlIIIllIl;
    }
    
    private static CustomColormap[] readCustomColormaps(final Properties lllllllllllllIlllIIlIIlIIIlIlIIl, final String lllllllllllllIlllIIlIIlIIIlllIll) {
        final List lllllllllllllIlllIIlIIlIIIlllIlI = new ArrayList();
        final String lllllllllllllIlllIIlIIlIIIlllIIl = "palette.block.";
        final Map lllllllllllllIlllIIlIIlIIIlllIII = new HashMap();
        for (final Object lllllllllllllIlllIIlIIlIIIllIlll : ((Hashtable<Object, V>)lllllllllllllIlllIIlIIlIIIlIlIIl).keySet()) {
            final String lllllllllllllIlllIIlIIlIIIllIllI = lllllllllllllIlllIIlIIlIIIlIlIIl.getProperty((String)lllllllllllllIlllIIlIIlIIIllIlll);
            if (((String)lllllllllllllIlllIIlIIlIIIllIlll).startsWith(lllllllllllllIlllIIlIIlIIIlllIIl)) {
                lllllllllllllIlllIIlIIlIIIlllIII.put(lllllllllllllIlllIIlIIlIIIllIlll, lllllllllllllIlllIIlIIlIIIllIllI);
            }
        }
        final String[] lllllllllllllIlllIIlIIlIIIllIlIl = (String[])lllllllllllllIlllIIlIIlIIIlllIII.keySet().toArray(new String[lllllllllllllIlllIIlIIlIIIlllIII.size()]);
        for (int lllllllllllllIlllIIlIIlIIIllIlII = 0; lllllllllllllIlllIIlIIlIIIllIlII < lllllllllllllIlllIIlIIlIIIllIlIl.length; ++lllllllllllllIlllIIlIIlIIIllIlII) {
            final String lllllllllllllIlllIIlIIlIIIllIIll = lllllllllllllIlllIIlIIlIIIllIlIl[lllllllllllllIlllIIlIIlIIIllIlII];
            final String lllllllllllllIlllIIlIIlIIIllIIlI = lllllllllllllIlllIIlIIlIIIlIlIIl.getProperty(lllllllllllllIlllIIlIIlIIIllIIll);
            dbg(String.valueOf(new StringBuilder("Block palette: ").append(lllllllllllllIlllIIlIIlIIIllIIll).append(" = ").append(lllllllllllllIlllIIlIIlIIIllIIlI)));
            String lllllllllllllIlllIIlIIlIIIllIIIl = lllllllllllllIlllIIlIIlIIIllIIll.substring(lllllllllllllIlllIIlIIlIIIlllIIl.length());
            final String lllllllllllllIlllIIlIIlIIIllIIII = TextureUtils.getBasePath(lllllllllllllIlllIIlIIlIIIlllIll);
            lllllllllllllIlllIIlIIlIIIllIIIl = TextureUtils.fixResourcePath(lllllllllllllIlllIIlIIlIIIllIIIl, lllllllllllllIlllIIlIIlIIIllIIII);
            final CustomColormap lllllllllllllIlllIIlIIlIIIlIllll = getCustomColors(lllllllllllllIlllIIlIIlIIIllIIIl, 256, 256);
            if (lllllllllllllIlllIIlIIlIIIlIllll == null) {
                warn(String.valueOf(new StringBuilder("Colormap not found: ").append(lllllllllllllIlllIIlIIlIIIllIIIl)));
            }
            else {
                final ConnectedParser lllllllllllllIlllIIlIIlIIIlIlllI = new ConnectedParser("CustomColors");
                final MatchBlock[] lllllllllllllIlllIIlIIlIIIlIllIl = lllllllllllllIlllIIlIIlIIIlIlllI.parseMatchBlocks(lllllllllllllIlllIIlIIlIIIllIIlI);
                if (lllllllllllllIlllIIlIIlIIIlIllIl != null && lllllllllllllIlllIIlIIlIIIlIllIl.length > 0) {
                    for (int lllllllllllllIlllIIlIIlIIIlIllII = 0; lllllllllllllIlllIIlIIlIIIlIllII < lllllllllllllIlllIIlIIlIIIlIllIl.length; ++lllllllllllllIlllIIlIIlIIIlIllII) {
                        final MatchBlock lllllllllllllIlllIIlIIlIIIlIlIll = lllllllllllllIlllIIlIIlIIIlIllIl[lllllllllllllIlllIIlIIlIIIlIllII];
                        lllllllllllllIlllIIlIIlIIIlIllll.addMatchBlock(lllllllllllllIlllIIlIIlIIIlIlIll);
                    }
                    lllllllllllllIlllIIlIIlIIIlllIlI.add(lllllllllllllIlllIIlIIlIIIlIllll);
                }
                else {
                    warn(String.valueOf(new StringBuilder("Invalid match blocks: ").append(lllllllllllllIlllIIlIIlIIIllIIlI)));
                }
            }
        }
        if (lllllllllllllIlllIIlIIlIIIlllIlI.size() <= 0) {
            return null;
        }
        final CustomColormap[] lllllllllllllIlllIIlIIlIIIlIlIlI = lllllllllllllIlllIIlIIlIIIlllIlI.toArray(new CustomColormap[lllllllllllllIlllIIlIIlIIIlllIlI.size()]);
        return lllllllllllllIlllIIlIIlIIIlIlIlI;
    }
    
    protected static Biome getColorBiome(final IBlockAccess lllllllllllllIlllIIlIIIlIIllIlII, final BlockPos lllllllllllllIlllIIlIIIlIIllIIll) {
        Biome lllllllllllllIlllIIlIIIlIIllIIlI = lllllllllllllIlllIIlIIIlIIllIlII.getBiome(lllllllllllllIlllIIlIIIlIIllIIll);
        if (lllllllllllllIlllIIlIIIlIIllIIlI == Biomes.SWAMPLAND && !Config.isSwampColors()) {
            lllllllllllllIlllIIlIIIlIIllIIlI = Biomes.PLAINS;
        }
        return lllllllllllllIlllIIlIIIlIIllIIlI;
    }
    
    public static float[] getSheepColors(final EnumDyeColor lllllllllllllIlllIIIlllIIIlllIII, final float[] lllllllllllllIlllIIIlllIIIllIlll) {
        return getDyeColors(lllllllllllllIlllIIIlllIIIlllIII, CustomColors.sheepColors, lllllllllllllIlllIIIlllIIIllIlll);
    }
    
    private static Vec3d getFogColor(final Vec3d lllllllllllllIlllIIIlllllIlllIll, final IBlockAccess lllllllllllllIlllIIIlllllIlllIlI, final double lllllllllllllIlllIIIlllllIlllIIl, final double lllllllllllllIlllIIIllllllIIlIII, final double lllllllllllllIlllIIIllllllIIIlll) {
        if (CustomColors.fogColors == null) {
            return lllllllllllllIlllIIIlllllIlllIll;
        }
        final int lllllllllllllIlllIIIllllllIIIllI = CustomColors.fogColors.getColorSmooth(lllllllllllllIlllIIIlllllIlllIlI, lllllllllllllIlllIIIlllllIlllIIl, lllllllllllllIlllIIIllllllIIlIII, lllllllllllllIlllIIIllllllIIIlll, 3);
        final int lllllllllllllIlllIIIllllllIIIlIl = lllllllllllllIlllIIIllllllIIIllI >> 16 & 0xFF;
        final int lllllllllllllIlllIIIllllllIIIlII = lllllllllllllIlllIIIllllllIIIllI >> 8 & 0xFF;
        final int lllllllllllllIlllIIIllllllIIIIll = lllllllllllllIlllIIIllllllIIIllI & 0xFF;
        float lllllllllllllIlllIIIllllllIIIIlI = lllllllllllllIlllIIIllllllIIIlIl / 255.0f;
        float lllllllllllllIlllIIIllllllIIIIIl = lllllllllllllIlllIIIllllllIIIlII / 255.0f;
        float lllllllllllllIlllIIIllllllIIIIII = lllllllllllllIlllIIIllllllIIIIll / 255.0f;
        final float lllllllllllllIlllIIIlllllIllllll = (float)lllllllllllllIlllIIIlllllIlllIll.xCoord / 0.753f;
        final float lllllllllllllIlllIIIlllllIlllllI = (float)lllllllllllllIlllIIIlllllIlllIll.yCoord / 0.8471f;
        final float lllllllllllllIlllIIIlllllIllllIl = (float)lllllllllllllIlllIIIlllllIlllIll.zCoord;
        lllllllllllllIlllIIIllllllIIIIlI *= lllllllllllllIlllIIIlllllIllllll;
        lllllllllllllIlllIIIllllllIIIIIl *= lllllllllllllIlllIIIlllllIlllllI;
        lllllllllllllIlllIIIllllllIIIIII *= lllllllllllllIlllIIIlllllIllllIl;
        final Vec3d lllllllllllllIlllIIIlllllIllllII = CustomColors.fogColorFader.getColor(lllllllllllllIlllIIIllllllIIIIlI, lllllllllllllIlllIIIllllllIIIIIl, lllllllllllllIlllIIIllllllIIIIII);
        return lllllllllllllIlllIIIlllllIllllII;
    }
    
    private static int readColor(final Properties lllllllllllllIlllIIlIIIllIllIIll, final String lllllllllllllIlllIIlIIIllIlIlllI) {
        String lllllllllllllIlllIIlIIIllIllIIIl = lllllllllllllIlllIIlIIIllIllIIll.getProperty(lllllllllllllIlllIIlIIIllIlIlllI);
        if (lllllllllllllIlllIIlIIIllIllIIIl == null) {
            return -1;
        }
        lllllllllllllIlllIIlIIIllIllIIIl = lllllllllllllIlllIIlIIIllIllIIIl.trim();
        final int lllllllllllllIlllIIlIIIllIllIIII = parseColor(lllllllllllllIlllIIlIIIllIllIIIl);
        if (lllllllllllllIlllIIlIIIllIllIIII < 0) {
            warn(String.valueOf(new StringBuilder("Invalid color: ").append(lllllllllllllIlllIIlIIIllIlIlllI).append(" = ").append(lllllllllllllIlllIIlIIIllIllIIIl)));
            return lllllllllllllIlllIIlIIIllIllIIII;
        }
        dbg(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIIlIIIllIlIlllI)).append(" = ").append(lllllllllllllIlllIIlIIIllIllIIIl)));
        return lllllllllllllIlllIIlIIIllIllIIII;
    }
    
    public static int getColorFromItemStack(final ItemStack lllllllllllllIlllIIIlllIIllllllI, final int lllllllllllllIlllIIIlllIlIIIIIIl, final int lllllllllllllIlllIIIlllIlIIIIIII) {
        if (lllllllllllllIlllIIIlllIIllllllI == null) {
            return lllllllllllllIlllIIIlllIlIIIIIII;
        }
        final Item lllllllllllllIlllIIIlllIIlllllll = lllllllllllllIlllIIIlllIIllllllI.getItem();
        if (lllllllllllllIlllIIIlllIIlllllll == null) {
            return lllllllllllllIlllIIIlllIlIIIIIII;
        }
        return (lllllllllllllIlllIIIlllIIlllllll instanceof ItemMonsterPlacer) ? getSpawnEggColor((ItemMonsterPlacer)lllllllllllllIlllIIIlllIIlllllll, lllllllllllllIlllIIIlllIIllllllI, lllllllllllllIlllIIIlllIlIIIIIIl, lllllllllllllIlllIIIlllIlIIIIIII) : lllllllllllllIlllIIIlllIlIIIIIII;
    }
    
    private static CustomColormap[][] blockListToArray(final List lllllllllllllIlllIIlIIIlllIIlIll) {
        final CustomColormap[][] lllllllllllllIlllIIlIIIlllIIllll = new CustomColormap[lllllllllllllIlllIIlIIIlllIIlIll.size()][];
        for (int lllllllllllllIlllIIlIIIlllIIlllI = 0; lllllllllllllIlllIIlIIIlllIIlllI < lllllllllllllIlllIIlIIIlllIIlIll.size(); ++lllllllllllllIlllIIlIIIlllIIlllI) {
            final List lllllllllllllIlllIIlIIIlllIIllIl = lllllllllllllIlllIIlIIIlllIIlIll.get(lllllllllllllIlllIIlIIIlllIIlllI);
            if (lllllllllllllIlllIIlIIIlllIIllIl != null) {
                final CustomColormap[] lllllllllllllIlllIIlIIIlllIIllII = lllllllllllllIlllIIlIIIlllIIllIl.toArray(new CustomColormap[lllllllllllllIlllIIlIIIlllIIllIl.size()]);
                lllllllllllllIlllIIlIIIlllIIllll[lllllllllllllIlllIIlIIIlllIIlllI] = lllllllllllllIlllIIlIIIlllIIllII;
            }
        }
        return lllllllllllllIlllIIlIIIlllIIllll;
    }
    
    public static CustomColormap getCustomColors(final String lllllllllllllIlllIIlIIIlIllIIIlI, final int lllllllllllllIlllIIlIIIlIllIlIll, final int lllllllllllllIlllIIlIIIlIllIIIII) {
        try {
            final ResourceLocation lllllllllllllIlllIIlIIIlIllIlIIl = new ResourceLocation(lllllllllllllIlllIIlIIIlIllIIIlI);
            if (!Config.hasResource(lllllllllllllIlllIIlIIIlIllIlIIl)) {
                return null;
            }
            dbg(String.valueOf(new StringBuilder("Colormap ").append(lllllllllllllIlllIIlIIIlIllIIIlI)));
            final Properties lllllllllllllIlllIIlIIIlIllIlIII = new Properties();
            String lllllllllllllIlllIIlIIIlIllIIlll = StrUtils.replaceSuffix(lllllllllllllIlllIIlIIIlIllIIIlI, ".png", ".properties");
            final ResourceLocation lllllllllllllIlllIIlIIIlIllIIllI = new ResourceLocation(lllllllllllllIlllIIlIIIlIllIIlll);
            if (Config.hasResource(lllllllllllllIlllIIlIIIlIllIIllI)) {
                final InputStream lllllllllllllIlllIIlIIIlIllIIlIl = Config.getResourceStream(lllllllllllllIlllIIlIIIlIllIIllI);
                lllllllllllllIlllIIlIIIlIllIlIII.load(lllllllllllllIlllIIlIIIlIllIIlIl);
                lllllllllllllIlllIIlIIIlIllIIlIl.close();
                dbg(String.valueOf(new StringBuilder("Colormap properties: ").append(lllllllllllllIlllIIlIIIlIllIIlll)));
            }
            else {
                ((Hashtable<String, String>)lllllllllllllIlllIIlIIIlIllIlIII).put("format", CustomColors.paletteFormatDefault);
                ((Hashtable<String, String>)lllllllllllllIlllIIlIIIlIllIlIII).put("source", lllllllllllllIlllIIlIIIlIllIIIlI);
                lllllllllllllIlllIIlIIIlIllIIlll = lllllllllllllIlllIIlIIIlIllIIIlI;
            }
            final CustomColormap lllllllllllllIlllIIlIIIlIllIIlII = new CustomColormap(lllllllllllllIlllIIlIIIlIllIlIII, lllllllllllllIlllIIlIIIlIllIIlll, lllllllllllllIlllIIlIIIlIllIlIll, lllllllllllllIlllIIlIIIlIllIIIII, CustomColors.paletteFormatDefault);
            return lllllllllllllIlllIIlIIIlIllIIlII.isValid(lllllllllllllIlllIIlIIIlIllIIlll) ? lllllllllllllIlllIIlIIIlIllIIlII : null;
        }
        catch (Exception lllllllllllllIlllIIlIIIlIllIIIll) {
            lllllllllllllIlllIIlIIIlIllIIIll.printStackTrace();
            return null;
        }
    }
    
    private static String getValidProperty(final String lllllllllllllIlllIIlIIlIlIlIIlII, final String lllllllllllllIlllIIlIIlIlIlIIIll, final String[] lllllllllllllIlllIIlIIlIlIlIIIlI, final String lllllllllllllIlllIIlIIlIlIlIllII) {
        try {
            final ResourceLocation lllllllllllllIlllIIlIIlIlIlIlIll = new ResourceLocation(lllllllllllllIlllIIlIIlIlIlIIlII);
            final InputStream lllllllllllllIlllIIlIIlIlIlIlIlI = Config.getResourceStream(lllllllllllllIlllIIlIIlIlIlIlIll);
            if (lllllllllllllIlllIIlIIlIlIlIlIlI == null) {
                return lllllllllllllIlllIIlIIlIlIlIllII;
            }
            final Properties lllllllllllllIlllIIlIIlIlIlIlIIl = new Properties();
            lllllllllllllIlllIIlIIlIlIlIlIIl.load(lllllllllllllIlllIIlIIlIlIlIlIlI);
            lllllllllllllIlllIIlIIlIlIlIlIlI.close();
            final String lllllllllllllIlllIIlIIlIlIlIlIII = lllllllllllllIlllIIlIIlIlIlIlIIl.getProperty(lllllllllllllIlllIIlIIlIlIlIIIll);
            if (lllllllllllllIlllIIlIIlIlIlIlIII == null) {
                return lllllllllllllIlllIIlIIlIlIlIllII;
            }
            final List<String> lllllllllllllIlllIIlIIlIlIlIIlll = Arrays.asList(lllllllllllllIlllIIlIIlIlIlIIIlI);
            if (!lllllllllllllIlllIIlIIlIlIlIIlll.contains(lllllllllllllIlllIIlIIlIlIlIlIII)) {
                warn(String.valueOf(new StringBuilder("Invalid value: ").append(lllllllllllllIlllIIlIIlIlIlIIIll).append("=").append(lllllllllllllIlllIIlIIlIlIlIlIII)));
                warn(String.valueOf(new StringBuilder("Expected values: ").append(Config.arrayToString(lllllllllllllIlllIIlIIlIlIlIIIlI))));
                return lllllllllllllIlllIIlIIlIlIlIllII;
            }
            dbg(String.valueOf(new StringBuilder().append(lllllllllllllIlllIIlIIlIlIlIIIll).append("=").append(lllllllllllllIlllIIlIIlIlIlIlIII)));
            return lllllllllllllIlllIIlIIlIlIlIlIII;
        }
        catch (FileNotFoundException lllllllllllllIlllIIlIIlIlIlIIllI) {
            return lllllllllllllIlllIIlIIlIlIlIllII;
        }
        catch (IOException lllllllllllllIlllIIlIIlIlIlIIlIl) {
            lllllllllllllIlllIIlIIlIlIlIIlIl.printStackTrace();
            return lllllllllllllIlllIIlIIlIlIlIllII;
        }
    }
    
    public static int getBossTextColor(final int lllllllllllllIlllIIIllIlIlllIlll) {
        return (CustomColors.bossTextColor < 0) ? lllllllllllllIlllIIIllIlIlllIlll : CustomColors.bossTextColor;
    }
    
    private static int getMaxPotionId() {
        int lllllllllllllIlllIIIllIlllIIlIII = 0;
        for (final ResourceLocation lllllllllllllIlllIIIllIlllIIIlll : Potion.REGISTRY.getKeys()) {
            final Potion lllllllllllllIlllIIIllIlllIIIllI = Potion.REGISTRY.getObject(lllllllllllllIlllIIIllIlllIIIlll);
            final int lllllllllllllIlllIIIllIlllIIIlIl = Potion.getIdFromPotion(lllllllllllllIlllIIIllIlllIIIllI);
            if (lllllllllllllIlllIIIllIlllIIIlIl > lllllllllllllIlllIIIllIlllIIlIII) {
                lllllllllllllIlllIIIllIlllIIlIII = lllllllllllllIlllIIIllIlllIIIlIl;
            }
        }
        return lllllllllllllIlllIIIllIlllIIlIII;
    }
    
    public static float getXpOrbTimer(final float lllllllllllllIlllIIlIIIIIllIIlII) {
        if (CustomColors.xpOrbTime <= 0) {
            return lllllllllllllIlllIIlIIIIIllIIlII;
        }
        final float lllllllllllllIlllIIlIIIIIllIIlIl = 628.0f / CustomColors.xpOrbTime;
        return lllllllllllllIlllIIlIIIIIllIIlII * lllllllllllllIlllIIlIIIIIllIIlIl;
    }
    
    public static int getColorMultiplier(final BakedQuad lllllllllllllIlllIIlIIIlIlIlIIIl, final IBlockState lllllllllllllIlllIIlIIIlIlIlIIII, final IBlockAccess lllllllllllllIlllIIlIIIlIlIIllll, BlockPos lllllllllllllIlllIIlIIIlIIllllIl, final RenderEnv lllllllllllllIlllIIlIIIlIlIIllIl) {
        final Block lllllllllllllIlllIIlIIIlIlIIllII = lllllllllllllIlllIIlIIIlIlIlIIII.getBlock();
        IBlockState lllllllllllllIlllIIlIIIlIlIIlIll = lllllllllllllIlllIIlIIIlIlIIllIl.getBlockState();
        if (CustomColors.blockColormaps != null) {
            if (!lllllllllllllIlllIIlIIIlIlIlIIIl.hasTintIndex()) {
                if (lllllllllllllIlllIIlIIIlIlIIllII == Blocks.GRASS) {
                    lllllllllllllIlllIIlIIIlIlIIlIll = CustomColors.BLOCK_STATE_DIRT;
                }
                if (lllllllllllllIlllIIlIIIlIlIIllII == Blocks.REDSTONE_WIRE) {
                    return -1;
                }
            }
            if (lllllllllllllIlllIIlIIIlIlIIllII == Blocks.DOUBLE_PLANT && lllllllllllllIlllIIlIIIlIlIIllIl.getMetadata() >= 8) {
                lllllllllllllIlllIIlIIIlIIllllIl = lllllllllllllIlllIIlIIIlIIllllIl.down();
                lllllllllllllIlllIIlIIIlIlIIlIll = lllllllllllllIlllIIlIIIlIlIIllll.getBlockState(lllllllllllllIlllIIlIIIlIIllllIl);
            }
            final CustomColormap lllllllllllllIlllIIlIIIlIlIIlIlI = getBlockColormap(lllllllllllllIlllIIlIIIlIlIIlIll);
            if (lllllllllllllIlllIIlIIIlIlIIlIlI != null) {
                if (Config.isSmoothBiomes() && !lllllllllllllIlllIIlIIIlIlIIlIlI.isColorConstant()) {
                    return getSmoothColorMultiplier(lllllllllllllIlllIIlIIIlIlIlIIII, lllllllllllllIlllIIlIIIlIlIIllll, lllllllllllllIlllIIlIIIlIIllllIl, lllllllllllllIlllIIlIIIlIlIIlIlI, lllllllllllllIlllIIlIIIlIlIIllIl.getColorizerBlockPosM());
                }
                return lllllllllllllIlllIIlIIIlIlIIlIlI.getColor(lllllllllllllIlllIIlIIIlIlIIllll, lllllllllllllIlllIIlIIIlIIllllIl);
            }
        }
        if (!lllllllllllllIlllIIlIIIlIlIlIIIl.hasTintIndex()) {
            return -1;
        }
        if (lllllllllllllIlllIIlIIIlIlIIllII == Blocks.WATERLILY) {
            return getLilypadColorMultiplier(lllllllllllllIlllIIlIIIlIlIIllll, lllllllllllllIlllIIlIIIlIIllllIl);
        }
        if (lllllllllllllIlllIIlIIIlIlIIllII == Blocks.REDSTONE_WIRE) {
            return getRedstoneColor(lllllllllllllIlllIIlIIIlIlIIllIl.getBlockState());
        }
        if (lllllllllllllIlllIIlIIIlIlIIllII instanceof BlockStem) {
            return getStemColorMultiplier(lllllllllllllIlllIIlIIIlIlIIllII, lllllllllllllIlllIIlIIIlIlIIllll, lllllllllllllIlllIIlIIIlIIllllIl, lllllllllllllIlllIIlIIIlIlIIllIl);
        }
        if (CustomColors.useDefaultGrassFoliageColors) {
            return -1;
        }
        final int lllllllllllllIlllIIlIIIlIlIIlIIl = lllllllllllllIlllIIlIIIlIlIIllIl.getMetadata();
        IColorizer lllllllllllllIlllIIlIIIlIlIIIIIl = null;
        if (lllllllllllllIlllIIlIIIlIlIIllII != Blocks.GRASS && lllllllllllllIlllIIlIIIlIlIIllII != Blocks.TALLGRASS && lllllllllllllIlllIIlIIIlIlIIllII != Blocks.DOUBLE_PLANT) {
            if (lllllllllllllIlllIIlIIIlIlIIllII == Blocks.DOUBLE_PLANT) {
                final IColorizer lllllllllllllIlllIIlIIIlIlIIlIII = CustomColors.COLORIZER_GRASS;
                if (lllllllllllllIlllIIlIIIlIlIIlIIl >= 8) {
                    lllllllllllllIlllIIlIIIlIIllllIl = lllllllllllllIlllIIlIIIlIIllllIl.down();
                }
            }
            else if (lllllllllllllIlllIIlIIIlIlIIllII == Blocks.LEAVES) {
                switch (lllllllllllllIlllIIlIIIlIlIIlIIl & 0x3) {
                    case 0: {
                        final IColorizer lllllllllllllIlllIIlIIIlIlIIIlll = CustomColors.COLORIZER_FOLIAGE;
                        break;
                    }
                    case 1: {
                        final IColorizer lllllllllllllIlllIIlIIIlIlIIIllI = CustomColors.COLORIZER_FOLIAGE_PINE;
                        break;
                    }
                    case 2: {
                        final IColorizer lllllllllllllIlllIIlIIIlIlIIIlIl = CustomColors.COLORIZER_FOLIAGE_BIRCH;
                        break;
                    }
                    default: {
                        final IColorizer lllllllllllllIlllIIlIIIlIlIIIlII = CustomColors.COLORIZER_FOLIAGE;
                        break;
                    }
                }
            }
            else if (lllllllllllllIlllIIlIIIlIlIIllII == Blocks.LEAVES2) {
                final IColorizer lllllllllllllIlllIIlIIIlIlIIIIll = CustomColors.COLORIZER_FOLIAGE;
            }
            else {
                if (lllllllllllllIlllIIlIIIlIlIIllII != Blocks.VINE) {
                    return -1;
                }
                final IColorizer lllllllllllllIlllIIlIIIlIlIIIIlI = CustomColors.COLORIZER_FOLIAGE;
            }
        }
        else {
            lllllllllllllIlllIIlIIIlIlIIIIIl = CustomColors.COLORIZER_GRASS;
        }
        return (Config.isSmoothBiomes() && !lllllllllllllIlllIIlIIIlIlIIIIIl.isColorConstant()) ? getSmoothColorMultiplier(lllllllllllllIlllIIlIIIlIlIlIIII, lllllllllllllIlllIIlIIIlIlIIllll, lllllllllllllIlllIIlIIIlIIllllIl, lllllllllllllIlllIIlIIIlIlIIIIIl, lllllllllllllIlllIIlIIIlIlIIllIl.getColorizerBlockPosM()) : lllllllllllllIlllIIlIIIlIlIIIIIl.getColor(lllllllllllllIlllIIlIIIlIlIIlIll, lllllllllllllIlllIIlIIIlIlIIllll, lllllllllllllIlllIIlIIIlIIllllIl);
    }
    
    private static CustomColormap[][] readBlockColormaps(final String[] lllllllllllllIlllIIlIIIlllllllII, final CustomColormap[] lllllllllllllIlllIIlIIlIIIIIllII, final int lllllllllllllIlllIIlIIIllllllIlI, final int lllllllllllllIlllIIlIIlIIIIIlIlI) {
        final String[] lllllllllllllIlllIIlIIlIIIIIlIIl = ResUtils.collectFiles(lllllllllllllIlllIIlIIIlllllllII, new String[] { ".properties" });
        Arrays.sort(lllllllllllllIlllIIlIIlIIIIIlIIl);
        final List lllllllllllllIlllIIlIIlIIIIIlIII = new ArrayList();
        for (int lllllllllllllIlllIIlIIlIIIIIIlll = 0; lllllllllllllIlllIIlIIlIIIIIIlll < lllllllllllllIlllIIlIIlIIIIIlIIl.length; ++lllllllllllllIlllIIlIIlIIIIIIlll) {
            final String lllllllllllllIlllIIlIIlIIIIIIllI = lllllllllllllIlllIIlIIlIIIIIlIIl[lllllllllllllIlllIIlIIlIIIIIIlll];
            dbg(String.valueOf(new StringBuilder("Block colormap: ").append(lllllllllllllIlllIIlIIlIIIIIIllI)));
            try {
                final ResourceLocation lllllllllllllIlllIIlIIlIIIIIIlIl = new ResourceLocation("minecraft", lllllllllllllIlllIIlIIlIIIIIIllI);
                final InputStream lllllllllllllIlllIIlIIlIIIIIIlII = Config.getResourceStream(lllllllllllllIlllIIlIIlIIIIIIlIl);
                if (lllllllllllllIlllIIlIIlIIIIIIlII == null) {
                    warn(String.valueOf(new StringBuilder("File not found: ").append(lllllllllllllIlllIIlIIlIIIIIIllI)));
                }
                else {
                    final Properties lllllllllllllIlllIIlIIlIIIIIIIll = new Properties();
                    lllllllllllllIlllIIlIIlIIIIIIIll.load(lllllllllllllIlllIIlIIlIIIIIIlII);
                    final CustomColormap lllllllllllllIlllIIlIIlIIIIIIIlI = new CustomColormap(lllllllllllllIlllIIlIIlIIIIIIIll, lllllllllllllIlllIIlIIlIIIIIIllI, lllllllllllllIlllIIlIIIllllllIlI, lllllllllllllIlllIIlIIlIIIIIlIlI, CustomColors.paletteFormatDefault);
                    if (lllllllllllllIlllIIlIIlIIIIIIIlI.isValid(lllllllllllllIlllIIlIIlIIIIIIllI) && lllllllllllllIlllIIlIIlIIIIIIIlI.isValidMatchBlocks(lllllllllllllIlllIIlIIlIIIIIIllI)) {
                        addToBlockList(lllllllllllllIlllIIlIIlIIIIIIIlI, lllllllllllllIlllIIlIIlIIIIIlIII);
                    }
                }
            }
            catch (FileNotFoundException lllllllllllllIlllIIlIIlIIIIIIIIl) {
                warn(String.valueOf(new StringBuilder("File not found: ").append(lllllllllllllIlllIIlIIlIIIIIIllI)));
            }
            catch (Exception lllllllllllllIlllIIlIIlIIIIIIIII) {
                lllllllllllllIlllIIlIIlIIIIIIIII.printStackTrace();
            }
        }
        if (lllllllllllllIlllIIlIIlIIIIIllII != null) {
            for (int lllllllllllllIlllIIlIIIlllllllll = 0; lllllllllllllIlllIIlIIIlllllllll < lllllllllllllIlllIIlIIlIIIIIllII.length; ++lllllllllllllIlllIIlIIIlllllllll) {
                final CustomColormap lllllllllllllIlllIIlIIIllllllllI = lllllllllllllIlllIIlIIlIIIIIllII[lllllllllllllIlllIIlIIIlllllllll];
                addToBlockList(lllllllllllllIlllIIlIIIllllllllI, lllllllllllllIlllIIlIIlIIIIIlIII);
            }
        }
        if (lllllllllllllIlllIIlIIlIIIIIlIII.size() <= 0) {
            return null;
        }
        final CustomColormap[][] lllllllllllllIlllIIlIIIlllllllIl = blockListToArray(lllllllllllllIlllIIlIIlIIIIIlIII);
        return lllllllllllllIlllIIlIIIlllllllIl;
    }
    
    public interface IColorizer
    {
        boolean isColorConstant();
        
        int getColor(final IBlockState p0, final IBlockAccess p1, final BlockPos p2);
    }
}
