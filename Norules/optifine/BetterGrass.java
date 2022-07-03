package optifine;

import net.minecraft.client.renderer.block.model.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.texture.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import java.io.*;

public class BetterGrass
{
    private static /* synthetic */ boolean modelsLoaded;
    private static /* synthetic */ boolean betterGrassPath;
    private static /* synthetic */ IBakedModel modelGrassPath;
    private static /* synthetic */ IBakedModel modelCubeMycelium;
    private static /* synthetic */ boolean betterGrassSnow;
    private static /* synthetic */ TextureAtlasSprite spriteSnow;
    private static /* synthetic */ boolean betterPodzolSnow;
    private static /* synthetic */ boolean betterMycelium;
    private static /* synthetic */ boolean betterPodzol;
    private static /* synthetic */ IBakedModel modelCubeGrass;
    private static /* synthetic */ TextureAtlasSprite spriteGrass;
    private static /* synthetic */ IBakedModel modelCubeGrassPath;
    private static /* synthetic */ IBakedModel modelCubeSnow;
    private static /* synthetic */ IBakedModel modelCubePodzol;
    private static /* synthetic */ boolean grassMultilayer;
    private static /* synthetic */ boolean spritesLoaded;
    private static /* synthetic */ TextureAtlasSprite spriteMycelium;
    private static /* synthetic */ TextureAtlasSprite spriteGrassSide;
    private static /* synthetic */ TextureAtlasSprite spritePodzol;
    private static /* synthetic */ boolean betterMyceliumSnow;
    private static /* synthetic */ TextureAtlasSprite spriteGrassPath;
    private static /* synthetic */ boolean betterGrass;
    
    private static Block getBlockAt(final BlockPos lIlIlllIIlIIIlI, final EnumFacing lIlIlllIIlIIllI, final IBlockAccess lIlIlllIIlIIIII) {
        final BlockPos lIlIlllIIlIIlII = lIlIlllIIlIIIlI.offset(lIlIlllIIlIIllI);
        final Block lIlIlllIIlIIIll = lIlIlllIIlIIIII.getBlockState(lIlIlllIIlIIlII).getBlock();
        return lIlIlllIIlIIIll;
    }
    
    private static List getFaceQuadsMycelium(final IBlockAccess lIlIlllIlllIIlI, final IBlockState lIlIlllIlllIIIl, final BlockPos lIlIlllIlllIIII, final EnumFacing lIlIlllIlllIllI, final List lIlIlllIlllIlIl) {
        final Block lIlIlllIlllIlII = lIlIlllIlllIIlI.getBlockState(lIlIlllIlllIIII.up()).getBlock();
        final boolean lIlIlllIlllIIll = lIlIlllIlllIlII == Blocks.SNOW || lIlIlllIlllIlII == Blocks.SNOW_LAYER;
        if (Config.isBetterGrassFancy()) {
            if (lIlIlllIlllIIll) {
                if (BetterGrass.betterMyceliumSnow && getBlockAt(lIlIlllIlllIIII, lIlIlllIlllIllI, lIlIlllIlllIIlI) == Blocks.SNOW_LAYER) {
                    return BetterGrass.modelCubeSnow.getQuads(lIlIlllIlllIIIl, lIlIlllIlllIllI, 0L);
                }
            }
            else if (BetterGrass.betterMycelium && getBlockAt(lIlIlllIlllIIII.down(), lIlIlllIlllIllI, lIlIlllIlllIIlI) == Blocks.MYCELIUM) {
                return BetterGrass.modelCubeMycelium.getQuads(lIlIlllIlllIIIl, lIlIlllIlllIllI, 0L);
            }
        }
        else if (lIlIlllIlllIIll) {
            if (BetterGrass.betterMyceliumSnow) {
                return BetterGrass.modelCubeSnow.getQuads(lIlIlllIlllIIIl, lIlIlllIlllIllI, 0L);
            }
        }
        else if (BetterGrass.betterMycelium) {
            return BetterGrass.modelCubeMycelium.getQuads(lIlIlllIlllIIIl, lIlIlllIlllIllI, 0L);
        }
        return lIlIlllIlllIlIl;
    }
    
    public static void updateIcons(final TextureMap lIlIlllllIIIIlI) {
        BetterGrass.spritesLoaded = false;
        BetterGrass.modelsLoaded = false;
        loadProperties(lIlIlllllIIIIlI);
    }
    
    private static TextureAtlasSprite registerSprite(final Properties lIlIllllIlIIIlI, final String lIlIllllIIllIIl, final String lIlIllllIlIIIII, final TextureMap lIlIllllIIlIlll) {
        String lIlIllllIIllllI = lIlIllllIlIIIlI.getProperty(lIlIllllIIllIIl);
        if (lIlIllllIIllllI == null) {
            lIlIllllIIllllI = lIlIllllIlIIIII;
        }
        final ResourceLocation lIlIllllIIlllIl = new ResourceLocation(String.valueOf(new StringBuilder("textures/").append(lIlIllllIIllllI).append(".png")));
        if (!Config.hasResource(lIlIllllIIlllIl)) {
            Config.warn(String.valueOf(new StringBuilder("BetterGrass texture not found: ").append(lIlIllllIIlllIl)));
            lIlIllllIIllllI = lIlIllllIlIIIII;
        }
        final ResourceLocation lIlIllllIIlllII = new ResourceLocation(lIlIllllIIllllI);
        final TextureAtlasSprite lIlIllllIIllIll = lIlIllllIIlIlll.registerSprite(lIlIllllIIlllII);
        return lIlIllllIIllIll;
    }
    
    public static List getFaceQuads(final IBlockAccess lIlIllllIIIllII, final IBlockState lIlIllllIIIIlIl, final BlockPos lIlIllllIIIlIlI, final EnumFacing lIlIllllIIIlIIl, final List lIlIllllIIIIIlI) {
        if (lIlIllllIIIlIIl == EnumFacing.UP || lIlIllllIIIlIIl == EnumFacing.DOWN) {
            return lIlIllllIIIIIlI;
        }
        if (!BetterGrass.modelsLoaded) {
            return lIlIllllIIIIIlI;
        }
        final Block lIlIllllIIIIlll = lIlIllllIIIIlIl.getBlock();
        if (lIlIllllIIIIlll instanceof BlockMycelium) {
            return getFaceQuadsMycelium(lIlIllllIIIllII, lIlIllllIIIIlIl, lIlIllllIIIlIlI, lIlIllllIIIlIIl, lIlIllllIIIIIlI);
        }
        if (lIlIllllIIIIlll instanceof BlockGrassPath) {
            return getFaceQuadsGrassPath(lIlIllllIIIllII, lIlIllllIIIIlIl, lIlIllllIIIlIlI, lIlIllllIIIlIIl, lIlIllllIIIIIlI);
        }
        if (lIlIllllIIIIlll instanceof BlockDirt) {
            return getFaceQuadsDirt(lIlIllllIIIllII, lIlIllllIIIIlIl, lIlIllllIIIlIlI, lIlIllllIIIlIIl, lIlIllllIIIIIlI);
        }
        return (lIlIllllIIIIlll instanceof BlockGrass) ? getFaceQuadsGrass(lIlIllllIIIllII, lIlIllllIIIIlIl, lIlIllllIIIlIlI, lIlIllllIIIlIIl, lIlIllllIIIIIlI) : lIlIllllIIIIIlI;
    }
    
    private static List getFaceQuadsGrass(final IBlockAccess lIlIlllIIlllIlI, final IBlockState lIlIlllIIllIIlI, final BlockPos lIlIlllIIlllIII, final EnumFacing lIlIlllIIllIIII, final List lIlIlllIIlIllll) {
        final Block lIlIlllIIllIlIl = lIlIlllIIlllIlI.getBlockState(lIlIlllIIlllIII.up()).getBlock();
        final boolean lIlIlllIIllIlII = lIlIlllIIllIlIl == Blocks.SNOW || lIlIlllIIllIlIl == Blocks.SNOW_LAYER;
        if (Config.isBetterGrassFancy()) {
            if (lIlIlllIIllIlII) {
                if (BetterGrass.betterGrassSnow && getBlockAt(lIlIlllIIlllIII, lIlIlllIIllIIII, lIlIlllIIlllIlI) == Blocks.SNOW_LAYER) {
                    return BetterGrass.modelCubeSnow.getQuads(lIlIlllIIllIIlI, lIlIlllIIllIIII, 0L);
                }
            }
            else if (BetterGrass.betterGrass && getBlockAt(lIlIlllIIlllIII.down(), lIlIlllIIllIIII, lIlIlllIIlllIlI) == Blocks.GRASS) {
                return BetterGrass.modelCubeGrass.getQuads(lIlIlllIIllIIlI, lIlIlllIIllIIII, 0L);
            }
        }
        else if (lIlIlllIIllIlII) {
            if (BetterGrass.betterGrassSnow) {
                return BetterGrass.modelCubeSnow.getQuads(lIlIlllIIllIIlI, lIlIlllIIllIIII, 0L);
            }
        }
        else if (BetterGrass.betterGrass) {
            return BetterGrass.modelCubeGrass.getQuads(lIlIlllIIllIIlI, lIlIlllIIllIIII, 0L);
        }
        return lIlIlllIIlIllll;
    }
    
    public static void update() {
        if (BetterGrass.spritesLoaded) {
            BetterGrass.modelCubeGrass = BlockModelUtils.makeModelCube(BetterGrass.spriteGrass, 0);
            if (BetterGrass.grassMultilayer) {
                final IBakedModel lIlIlllllIIIIII = BlockModelUtils.makeModelCube(BetterGrass.spriteGrassSide, -1);
                BetterGrass.modelCubeGrass = BlockModelUtils.joinModelsCube(lIlIlllllIIIIII, BetterGrass.modelCubeGrass);
            }
            final TextureAtlasSprite lIlIllllIllllll = Config.getTextureMap().registerSprite(new ResourceLocation("blocks/grass_path_side"));
            BetterGrass.modelGrassPath = BlockModelUtils.makeModel("grass_path", lIlIllllIllllll, BetterGrass.spriteGrassPath);
            BetterGrass.modelCubeGrassPath = BlockModelUtils.makeModelCube(BetterGrass.spriteGrassPath, -1);
            BetterGrass.modelCubeMycelium = BlockModelUtils.makeModelCube(BetterGrass.spriteMycelium, -1);
            BetterGrass.modelCubePodzol = BlockModelUtils.makeModelCube(BetterGrass.spritePodzol, 0);
            BetterGrass.modelCubeSnow = BlockModelUtils.makeModelCube(BetterGrass.spriteSnow, -1);
            BetterGrass.modelsLoaded = true;
        }
    }
    
    private static List getFaceQuadsDirt(final IBlockAccess lIlIlllIlIIlIlI, final IBlockState lIlIlllIlIlIIlI, final BlockPos lIlIlllIlIlIIIl, final EnumFacing lIlIlllIlIIIlll, final List lIlIlllIlIIIllI) {
        final Block lIlIlllIlIIlllI = getBlockAt(lIlIlllIlIlIIIl, EnumFacing.UP, lIlIlllIlIIlIlI);
        if (lIlIlllIlIlIIlI.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.PODZOL) {
            final boolean lIlIlllIlIIllIl = lIlIlllIlIIlllI == Blocks.SNOW || lIlIlllIlIIlllI == Blocks.SNOW_LAYER;
            if (Config.isBetterGrassFancy()) {
                if (lIlIlllIlIIllIl) {
                    if (BetterGrass.betterPodzolSnow && getBlockAt(lIlIlllIlIlIIIl, lIlIlllIlIIIlll, lIlIlllIlIIlIlI) == Blocks.SNOW_LAYER) {
                        return BetterGrass.modelCubeSnow.getQuads(lIlIlllIlIlIIlI, lIlIlllIlIIIlll, 0L);
                    }
                }
                else if (BetterGrass.betterPodzol) {
                    final BlockPos lIlIlllIlIIllII = lIlIlllIlIlIIIl.down().offset(lIlIlllIlIIIlll);
                    final IBlockState lIlIlllIlIIlIll = lIlIlllIlIIlIlI.getBlockState(lIlIlllIlIIllII);
                    if (lIlIlllIlIIlIll.getBlock() == Blocks.DIRT && lIlIlllIlIIlIll.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.PODZOL) {
                        return BetterGrass.modelCubePodzol.getQuads(lIlIlllIlIlIIlI, lIlIlllIlIIIlll, 0L);
                    }
                }
            }
            else if (lIlIlllIlIIllIl) {
                if (BetterGrass.betterPodzolSnow) {
                    return BetterGrass.modelCubeSnow.getQuads(lIlIlllIlIlIIlI, lIlIlllIlIIIlll, 0L);
                }
            }
            else if (BetterGrass.betterPodzol) {
                return BetterGrass.modelCubePodzol.getQuads(lIlIlllIlIlIIlI, lIlIlllIlIIIlll, 0L);
            }
            return lIlIlllIlIIIllI;
        }
        if (lIlIlllIlIIlllI == Blocks.GRASS_PATH) {
            return (BetterGrass.betterGrassPath && getBlockAt(lIlIlllIlIlIIIl, lIlIlllIlIIIlll, lIlIlllIlIIlIlI) == Blocks.GRASS_PATH) ? BetterGrass.modelCubeGrassPath.getQuads(lIlIlllIlIlIIlI, lIlIlllIlIIIlll, 0L) : lIlIlllIlIIIllI;
        }
        return lIlIlllIlIIIllI;
    }
    
    static {
        TEXTURE_PODZOL_DEFAULT = "blocks/dirt_podzol_top";
        TEXTURE_SNOW_DEFAULT = "blocks/snow";
        TEXTURE_GRASS_PATH_DEFAULT = "blocks/grass_path_top";
        TEXTURE_GRASS_SIDE_DEFAULT = "blocks/grass_side";
        TEXTURE_MYCELIUM_DEFAULT = "blocks/mycelium_top";
        TEXTURE_GRASS_DEFAULT = "blocks/grass_top";
        BetterGrass.betterGrass = true;
        BetterGrass.betterGrassPath = true;
        BetterGrass.betterMycelium = true;
        BetterGrass.betterPodzol = true;
        BetterGrass.betterGrassSnow = true;
        BetterGrass.betterMyceliumSnow = true;
        BetterGrass.betterPodzolSnow = true;
        BetterGrass.grassMultilayer = false;
        BetterGrass.spriteGrass = null;
        BetterGrass.spriteGrassSide = null;
        BetterGrass.spriteGrassPath = null;
        BetterGrass.spriteMycelium = null;
        BetterGrass.spritePodzol = null;
        BetterGrass.spriteSnow = null;
        BetterGrass.spritesLoaded = false;
        BetterGrass.modelCubeGrass = null;
        BetterGrass.modelGrassPath = null;
        BetterGrass.modelCubeGrassPath = null;
        BetterGrass.modelCubeMycelium = null;
        BetterGrass.modelCubePodzol = null;
        BetterGrass.modelCubeSnow = null;
        BetterGrass.modelsLoaded = false;
    }
    
    private static void loadProperties(final TextureMap lIlIllllIllIIII) {
        BetterGrass.betterGrass = true;
        BetterGrass.betterGrassPath = true;
        BetterGrass.betterMycelium = true;
        BetterGrass.betterPodzol = true;
        BetterGrass.betterGrassSnow = true;
        BetterGrass.betterMyceliumSnow = true;
        BetterGrass.betterPodzolSnow = true;
        BetterGrass.spriteGrass = lIlIllllIllIIII.registerSprite(new ResourceLocation("blocks/grass_top"));
        BetterGrass.spriteGrassSide = lIlIllllIllIIII.registerSprite(new ResourceLocation("blocks/grass_side"));
        BetterGrass.spriteGrassPath = lIlIllllIllIIII.registerSprite(new ResourceLocation("blocks/grass_path_top"));
        BetterGrass.spriteMycelium = lIlIllllIllIIII.registerSprite(new ResourceLocation("blocks/mycelium_top"));
        BetterGrass.spritePodzol = lIlIllllIllIIII.registerSprite(new ResourceLocation("blocks/dirt_podzol_top"));
        BetterGrass.spriteSnow = lIlIllllIllIIII.registerSprite(new ResourceLocation("blocks/snow"));
        BetterGrass.spritesLoaded = true;
        final String lIlIllllIllIllI = "optifine/bettergrass.properties";
        try {
            final ResourceLocation lIlIllllIllIlIl = new ResourceLocation(lIlIllllIllIllI);
            if (!Config.hasResource(lIlIllllIllIlIl)) {
                return;
            }
            final InputStream lIlIllllIllIlII = Config.getResourceStream(lIlIllllIllIlIl);
            if (lIlIllllIllIlII == null) {
                return;
            }
            final boolean lIlIllllIllIIll = Config.isFromDefaultResourcePack(lIlIllllIllIlIl);
            if (lIlIllllIllIIll) {
                Config.dbg(String.valueOf(new StringBuilder("BetterGrass: Parsing default configuration ").append(lIlIllllIllIllI)));
            }
            else {
                Config.dbg(String.valueOf(new StringBuilder("BetterGrass: Parsing configuration ").append(lIlIllllIllIllI)));
            }
            final Properties lIlIllllIllIIlI = new Properties();
            lIlIllllIllIIlI.load(lIlIllllIllIlII);
            BetterGrass.betterGrass = getBoolean(lIlIllllIllIIlI, "grass", true);
            BetterGrass.betterGrassPath = getBoolean(lIlIllllIllIIlI, "grass_path", true);
            BetterGrass.betterMycelium = getBoolean(lIlIllllIllIIlI, "mycelium", true);
            BetterGrass.betterPodzol = getBoolean(lIlIllllIllIIlI, "podzol", true);
            BetterGrass.betterGrassSnow = getBoolean(lIlIllllIllIIlI, "grass.snow", true);
            BetterGrass.betterMyceliumSnow = getBoolean(lIlIllllIllIIlI, "mycelium.snow", true);
            BetterGrass.betterPodzolSnow = getBoolean(lIlIllllIllIIlI, "podzol.snow", true);
            BetterGrass.grassMultilayer = getBoolean(lIlIllllIllIIlI, "grass.multilayer", false);
            BetterGrass.spriteGrass = registerSprite(lIlIllllIllIIlI, "texture.grass", "blocks/grass_top", lIlIllllIllIIII);
            BetterGrass.spriteGrassSide = registerSprite(lIlIllllIllIIlI, "texture.grass_side", "blocks/grass_side", lIlIllllIllIIII);
            BetterGrass.spriteGrassPath = registerSprite(lIlIllllIllIIlI, "texture.grass_path", "blocks/grass_path_top", lIlIllllIllIIII);
            BetterGrass.spriteMycelium = registerSprite(lIlIllllIllIIlI, "texture.mycelium", "blocks/mycelium_top", lIlIllllIllIIII);
            BetterGrass.spritePodzol = registerSprite(lIlIllllIllIIlI, "texture.podzol", "blocks/dirt_podzol_top", lIlIllllIllIIII);
            BetterGrass.spriteSnow = registerSprite(lIlIllllIllIIlI, "texture.snow", "blocks/snow", lIlIllllIllIIII);
        }
        catch (IOException lIlIllllIllIIIl) {
            Config.warn(String.valueOf(new StringBuilder("Error reading: ").append(lIlIllllIllIllI).append(", ").append(lIlIllllIllIIIl.getClass().getName()).append(": ").append(lIlIllllIllIIIl.getMessage())));
        }
    }
    
    private static boolean getBoolean(final Properties lIlIlllIIIllIIl, final String lIlIlllIIIllIII, final boolean lIlIlllIIIlIlll) {
        final String lIlIlllIIIlIllI = lIlIlllIIIllIIl.getProperty(lIlIlllIIIllIII);
        return (lIlIlllIIIlIllI == null) ? lIlIlllIIIlIlll : Boolean.parseBoolean(lIlIlllIIIlIllI);
    }
    
    private static List getFaceQuadsGrassPath(final IBlockAccess lIlIlllIllIIllI, final IBlockState lIlIlllIllIIlIl, final BlockPos lIlIlllIlIlllll, final EnumFacing lIlIlllIlIllllI, final List lIlIlllIlIlllIl) {
        if (!BetterGrass.betterGrassPath) {
            return lIlIlllIlIlllIl;
        }
        if (Config.isBetterGrassFancy()) {
            return (getBlockAt(lIlIlllIlIlllll.down(), lIlIlllIlIllllI, lIlIlllIllIIllI) == Blocks.GRASS_PATH) ? BetterGrass.modelGrassPath.getQuads(lIlIlllIllIIlIl, lIlIlllIlIllllI, 0L) : lIlIlllIlIlllIl;
        }
        return BetterGrass.modelGrassPath.getQuads(lIlIlllIllIIlIl, lIlIlllIlIllllI, 0L);
    }
}
