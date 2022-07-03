package net.minecraft.client.renderer;

import java.util.*;
import net.minecraft.block.state.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.init.*;
import com.google.common.collect.*;
import net.minecraft.block.properties.*;
import net.minecraft.client.renderer.block.statemap.*;
import net.minecraft.util.*;
import net.minecraft.block.*;

public class BlockModelShapes
{
    private final /* synthetic */ Map<IBlockState, IBakedModel> bakedModelStore;
    private final /* synthetic */ BlockStateMapper blockStateMapper;
    private final /* synthetic */ ModelManager modelManager;
    
    public void reloadModels() {
        this.bakedModelStore.clear();
        for (final Map.Entry<IBlockState, ModelResourceLocation> lllllllllllllIIlIllllIIllIIIlIIl : this.blockStateMapper.putAllStateModelLocations().entrySet()) {
            this.bakedModelStore.put(lllllllllllllIIlIllllIIllIIIlIIl.getKey(), this.modelManager.getModel(lllllllllllllIIlIllllIIllIIIlIIl.getValue()));
        }
    }
    
    public TextureAtlasSprite getTexture(final IBlockState lllllllllllllIIlIllllIIllIIlllII) {
        final Block lllllllllllllIIlIllllIIllIIlllll = lllllllllllllIIlIllllIIllIIlllII.getBlock();
        IBakedModel lllllllllllllIIlIllllIIllIIllllI = this.getModelForState(lllllllllllllIIlIllllIIllIIlllII);
        if (lllllllllllllIIlIllllIIllIIllllI == null || lllllllllllllIIlIllllIIllIIllllI == this.modelManager.getMissingModel()) {
            if (lllllllllllllIIlIllllIIllIIlllll == Blocks.WALL_SIGN || lllllllllllllIIlIllllIIllIIlllll == Blocks.STANDING_SIGN || lllllllllllllIIlIllllIIllIIlllll == Blocks.CHEST || lllllllllllllIIlIllllIIllIIlllll == Blocks.TRAPPED_CHEST || lllllllllllllIIlIllllIIllIIlllll == Blocks.STANDING_BANNER || lllllllllllllIIlIllllIIllIIlllll == Blocks.WALL_BANNER || lllllllllllllIIlIllllIIllIIlllll == Blocks.BED) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/planks_oak");
            }
            if (lllllllllllllIIlIllllIIllIIlllll == Blocks.ENDER_CHEST) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/obsidian");
            }
            if (lllllllllllllIIlIllllIIllIIlllll == Blocks.FLOWING_LAVA || lllllllllllllIIlIllllIIllIIlllll == Blocks.LAVA) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/lava_still");
            }
            if (lllllllllllllIIlIllllIIllIIlllll == Blocks.FLOWING_WATER || lllllllllllllIIlIllllIIllIIlllll == Blocks.WATER) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/water_still");
            }
            if (lllllllllllllIIlIllllIIllIIlllll == Blocks.SKULL) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/soul_sand");
            }
            if (lllllllllllllIIlIllllIIllIIlllll == Blocks.BARRIER) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:items/barrier");
            }
            if (lllllllllllllIIlIllllIIllIIlllll == Blocks.STRUCTURE_VOID) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:items/structure_void");
            }
            if (lllllllllllllIIlIllllIIllIIlllll == Blocks.field_190977_dl) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_white");
            }
            if (lllllllllllllIIlIllllIIllIIlllll == Blocks.field_190978_dm) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_orange");
            }
            if (lllllllllllllIIlIllllIIllIIlllll == Blocks.field_190979_dn) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_magenta");
            }
            if (lllllllllllllIIlIllllIIllIIlllll == Blocks.field_190980_do) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_light_blue");
            }
            if (lllllllllllllIIlIllllIIllIIlllll == Blocks.field_190981_dp) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_yellow");
            }
            if (lllllllllllllIIlIllllIIllIIlllll == Blocks.field_190982_dq) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_lime");
            }
            if (lllllllllllllIIlIllllIIllIIlllll == Blocks.field_190983_dr) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_pink");
            }
            if (lllllllllllllIIlIllllIIllIIlllll == Blocks.field_190984_ds) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_gray");
            }
            if (lllllllllllllIIlIllllIIllIIlllll == Blocks.field_190985_dt) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_silver");
            }
            if (lllllllllllllIIlIllllIIllIIlllll == Blocks.field_190986_du) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_cyan");
            }
            if (lllllllllllllIIlIllllIIllIIlllll == Blocks.field_190987_dv) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_purple");
            }
            if (lllllllllllllIIlIllllIIllIIlllll == Blocks.field_190988_dw) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_blue");
            }
            if (lllllllllllllIIlIllllIIllIIlllll == Blocks.field_190989_dx) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_brown");
            }
            if (lllllllllllllIIlIllllIIllIIlllll == Blocks.field_190990_dy) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_green");
            }
            if (lllllllllllllIIlIllllIIllIIlllll == Blocks.field_190991_dz) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_red");
            }
            if (lllllllllllllIIlIllllIIllIIlllll == Blocks.field_190975_dA) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_black");
            }
        }
        if (lllllllllllllIIlIllllIIllIIllllI == null) {
            lllllllllllllIIlIllllIIllIIllllI = this.modelManager.getMissingModel();
        }
        return lllllllllllllIIlIllllIIllIIllllI.getParticleTexture();
    }
    
    public void registerBuiltInBlocks(final Block... lllllllllllllIIlIllllIIlIllllIIl) {
        this.blockStateMapper.registerBuiltInBlocks(lllllllllllllIIlIllllIIlIllllIIl);
    }
    
    public BlockStateMapper getBlockStateMapper() {
        return this.blockStateMapper;
    }
    
    public BlockModelShapes(final ModelManager lllllllllllllIIlIllllIIllIlIlIIl) {
        this.bakedModelStore = (Map<IBlockState, IBakedModel>)Maps.newIdentityHashMap();
        this.blockStateMapper = new BlockStateMapper();
        this.modelManager = lllllllllllllIIlIllllIIllIlIlIIl;
        this.registerAllBlocks();
    }
    
    private void registerAllBlocks() {
        this.registerBuiltInBlocks(Blocks.AIR, Blocks.FLOWING_WATER, Blocks.WATER, Blocks.FLOWING_LAVA, Blocks.LAVA, Blocks.PISTON_EXTENSION, Blocks.CHEST, Blocks.ENDER_CHEST, Blocks.TRAPPED_CHEST, Blocks.STANDING_SIGN, Blocks.SKULL, Blocks.END_PORTAL, Blocks.BARRIER, Blocks.WALL_SIGN, Blocks.WALL_BANNER, Blocks.STANDING_BANNER, Blocks.END_GATEWAY, Blocks.STRUCTURE_VOID, Blocks.field_190977_dl, Blocks.field_190978_dm, Blocks.field_190979_dn, Blocks.field_190980_do, Blocks.field_190981_dp, Blocks.field_190982_dq, Blocks.field_190983_dr, Blocks.field_190984_ds, Blocks.field_190985_dt, Blocks.field_190986_du, Blocks.field_190987_dv, Blocks.field_190988_dw, Blocks.field_190989_dx, Blocks.field_190990_dy, Blocks.field_190991_dz, Blocks.field_190975_dA, Blocks.BED);
        this.registerBlockWithStateMapper(Blocks.STONE, new StateMap.Builder().withName(BlockStone.VARIANT).build());
        this.registerBlockWithStateMapper(Blocks.PRISMARINE, new StateMap.Builder().withName(BlockPrismarine.VARIANT).build());
        this.registerBlockWithStateMapper(Blocks.LEAVES, new StateMap.Builder().withName(BlockOldLeaf.VARIANT).withSuffix("_leaves").ignore(BlockLeaves.CHECK_DECAY, BlockLeaves.DECAYABLE).build());
        this.registerBlockWithStateMapper(Blocks.LEAVES2, new StateMap.Builder().withName(BlockNewLeaf.VARIANT).withSuffix("_leaves").ignore(BlockLeaves.CHECK_DECAY, BlockLeaves.DECAYABLE).build());
        this.registerBlockWithStateMapper(Blocks.CACTUS, new StateMap.Builder().ignore(BlockCactus.AGE).build());
        this.registerBlockWithStateMapper(Blocks.REEDS, new StateMap.Builder().ignore(BlockReed.AGE).build());
        this.registerBlockWithStateMapper(Blocks.JUKEBOX, new StateMap.Builder().ignore(BlockJukebox.HAS_RECORD).build());
        this.registerBlockWithStateMapper(Blocks.COBBLESTONE_WALL, new StateMap.Builder().withName(BlockWall.VARIANT).withSuffix("_wall").build());
        this.registerBlockWithStateMapper(Blocks.DOUBLE_PLANT, new StateMap.Builder().withName(BlockDoublePlant.VARIANT).ignore(BlockDoublePlant.FACING).build());
        this.registerBlockWithStateMapper(Blocks.OAK_FENCE_GATE, new StateMap.Builder().ignore(BlockFenceGate.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.SPRUCE_FENCE_GATE, new StateMap.Builder().ignore(BlockFenceGate.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.BIRCH_FENCE_GATE, new StateMap.Builder().ignore(BlockFenceGate.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.JUNGLE_FENCE_GATE, new StateMap.Builder().ignore(BlockFenceGate.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.DARK_OAK_FENCE_GATE, new StateMap.Builder().ignore(BlockFenceGate.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.ACACIA_FENCE_GATE, new StateMap.Builder().ignore(BlockFenceGate.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.TRIPWIRE, new StateMap.Builder().ignore(BlockTripWire.DISARMED, BlockTripWire.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.DOUBLE_WOODEN_SLAB, new StateMap.Builder().withName(BlockPlanks.VARIANT).withSuffix("_double_slab").build());
        this.registerBlockWithStateMapper(Blocks.WOODEN_SLAB, new StateMap.Builder().withName(BlockPlanks.VARIANT).withSuffix("_slab").build());
        this.registerBlockWithStateMapper(Blocks.TNT, new StateMap.Builder().ignore(BlockTNT.EXPLODE).build());
        this.registerBlockWithStateMapper(Blocks.FIRE, new StateMap.Builder().ignore(BlockFire.AGE).build());
        this.registerBlockWithStateMapper(Blocks.REDSTONE_WIRE, new StateMap.Builder().ignore(BlockRedstoneWire.POWER).build());
        this.registerBlockWithStateMapper(Blocks.OAK_DOOR, new StateMap.Builder().ignore(BlockDoor.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.SPRUCE_DOOR, new StateMap.Builder().ignore(BlockDoor.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.BIRCH_DOOR, new StateMap.Builder().ignore(BlockDoor.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.JUNGLE_DOOR, new StateMap.Builder().ignore(BlockDoor.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.ACACIA_DOOR, new StateMap.Builder().ignore(BlockDoor.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.DARK_OAK_DOOR, new StateMap.Builder().ignore(BlockDoor.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.IRON_DOOR, new StateMap.Builder().ignore(BlockDoor.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.WOOL, new StateMap.Builder().withName(BlockColored.COLOR).withSuffix("_wool").build());
        this.registerBlockWithStateMapper(Blocks.CARPET, new StateMap.Builder().withName(BlockColored.COLOR).withSuffix("_carpet").build());
        this.registerBlockWithStateMapper(Blocks.STAINED_HARDENED_CLAY, new StateMap.Builder().withName(BlockColored.COLOR).withSuffix("_stained_hardened_clay").build());
        this.registerBlockWithStateMapper(Blocks.STAINED_GLASS_PANE, new StateMap.Builder().withName(BlockColored.COLOR).withSuffix("_stained_glass_pane").build());
        this.registerBlockWithStateMapper(Blocks.STAINED_GLASS, new StateMap.Builder().withName(BlockColored.COLOR).withSuffix("_stained_glass").build());
        this.registerBlockWithStateMapper(Blocks.SANDSTONE, new StateMap.Builder().withName(BlockSandStone.TYPE).build());
        this.registerBlockWithStateMapper(Blocks.RED_SANDSTONE, new StateMap.Builder().withName(BlockRedSandstone.TYPE).build());
        this.registerBlockWithStateMapper(Blocks.TALLGRASS, new StateMap.Builder().withName(BlockTallGrass.TYPE).build());
        this.registerBlockWithStateMapper(Blocks.YELLOW_FLOWER, new StateMap.Builder().withName(Blocks.YELLOW_FLOWER.getTypeProperty()).build());
        this.registerBlockWithStateMapper(Blocks.RED_FLOWER, new StateMap.Builder().withName(Blocks.RED_FLOWER.getTypeProperty()).build());
        this.registerBlockWithStateMapper(Blocks.STONE_SLAB, new StateMap.Builder().withName(BlockStoneSlab.VARIANT).withSuffix("_slab").build());
        this.registerBlockWithStateMapper(Blocks.STONE_SLAB2, new StateMap.Builder().withName(BlockStoneSlabNew.VARIANT).withSuffix("_slab").build());
        this.registerBlockWithStateMapper(Blocks.MONSTER_EGG, new StateMap.Builder().withName(BlockSilverfish.VARIANT).withSuffix("_monster_egg").build());
        this.registerBlockWithStateMapper(Blocks.STONEBRICK, new StateMap.Builder().withName(BlockStoneBrick.VARIANT).build());
        this.registerBlockWithStateMapper(Blocks.DISPENSER, new StateMap.Builder().ignore(BlockDispenser.TRIGGERED).build());
        this.registerBlockWithStateMapper(Blocks.DROPPER, new StateMap.Builder().ignore(BlockDropper.TRIGGERED).build());
        this.registerBlockWithStateMapper(Blocks.LOG, new StateMap.Builder().withName(BlockOldLog.VARIANT).withSuffix("_log").build());
        this.registerBlockWithStateMapper(Blocks.LOG2, new StateMap.Builder().withName(BlockNewLog.VARIANT).withSuffix("_log").build());
        this.registerBlockWithStateMapper(Blocks.PLANKS, new StateMap.Builder().withName(BlockPlanks.VARIANT).withSuffix("_planks").build());
        this.registerBlockWithStateMapper(Blocks.SAPLING, new StateMap.Builder().withName(BlockSapling.TYPE).withSuffix("_sapling").build());
        this.registerBlockWithStateMapper(Blocks.SAND, new StateMap.Builder().withName(BlockSand.VARIANT).build());
        this.registerBlockWithStateMapper(Blocks.HOPPER, new StateMap.Builder().ignore(BlockHopper.ENABLED).build());
        this.registerBlockWithStateMapper(Blocks.FLOWER_POT, new StateMap.Builder().ignore(BlockFlowerPot.LEGACY_DATA).build());
        this.registerBlockWithStateMapper(Blocks.field_192443_dR, new StateMap.Builder().withName(BlockColored.COLOR).withSuffix("_concrete").build());
        this.registerBlockWithStateMapper(Blocks.field_192444_dS, new StateMap.Builder().withName(BlockColored.COLOR).withSuffix("_concrete_powder").build());
        this.registerBlockWithStateMapper(Blocks.QUARTZ_BLOCK, new StateMapperBase() {
            private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockQuartz$EnumType;
            
            @Override
            protected ModelResourceLocation getModelResourceLocation(final IBlockState lllllllllllllIIllIIlllIIIllllIll) {
                final BlockQuartz.EnumType lllllllllllllIIllIIlllIIIlllllII = lllllllllllllIIllIIlllIIIllllIll.getValue(BlockQuartz.VARIANT);
                switch ($SWITCH_TABLE$net$minecraft$block$BlockQuartz$EnumType()[lllllllllllllIIllIIlllIIIlllllII.ordinal()]) {
                    default: {
                        return new ModelResourceLocation("quartz_block", "normal");
                    }
                    case 2: {
                        return new ModelResourceLocation("chiseled_quartz_block", "normal");
                    }
                    case 3: {
                        return new ModelResourceLocation("quartz_column", "axis=y");
                    }
                    case 4: {
                        return new ModelResourceLocation("quartz_column", "axis=x");
                    }
                    case 5: {
                        return new ModelResourceLocation("quartz_column", "axis=z");
                    }
                }
            }
            
            static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockQuartz$EnumType() {
                final int[] $switch_TABLE$net$minecraft$block$BlockQuartz$EnumType = BlockModelShapes$1.$SWITCH_TABLE$net$minecraft$block$BlockQuartz$EnumType;
                if ($switch_TABLE$net$minecraft$block$BlockQuartz$EnumType != null) {
                    return $switch_TABLE$net$minecraft$block$BlockQuartz$EnumType;
                }
                final float lllllllllllllIIllIIlllIIIllllIII = (Object)new int[BlockQuartz.EnumType.values().length];
                try {
                    lllllllllllllIIllIIlllIIIllllIII[BlockQuartz.EnumType.CHISELED.ordinal()] = 2;
                }
                catch (NoSuchFieldError noSuchFieldError) {}
                try {
                    lllllllllllllIIllIIlllIIIllllIII[BlockQuartz.EnumType.DEFAULT.ordinal()] = true;
                }
                catch (NoSuchFieldError noSuchFieldError2) {}
                try {
                    lllllllllllllIIllIIlllIIIllllIII[BlockQuartz.EnumType.LINES_X.ordinal()] = 4;
                }
                catch (NoSuchFieldError noSuchFieldError3) {}
                try {
                    lllllllllllllIIllIIlllIIIllllIII[BlockQuartz.EnumType.LINES_Y.ordinal()] = 3;
                }
                catch (NoSuchFieldError noSuchFieldError4) {}
                try {
                    lllllllllllllIIllIIlllIIIllllIII[BlockQuartz.EnumType.LINES_Z.ordinal()] = 5;
                }
                catch (NoSuchFieldError noSuchFieldError5) {}
                return BlockModelShapes$1.$SWITCH_TABLE$net$minecraft$block$BlockQuartz$EnumType = (int[])(Object)lllllllllllllIIllIIlllIIIllllIII;
            }
        });
        this.registerBlockWithStateMapper(Blocks.DEADBUSH, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(final IBlockState lllllllllllllllIIlllIlIlllIIllll) {
                return new ModelResourceLocation("dead_bush", "normal");
            }
        });
        this.registerBlockWithStateMapper(Blocks.PUMPKIN_STEM, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(final IBlockState llllllllllllllIIIIlIllIlllIIlllI) {
                final Map<IProperty<?>, Comparable<?>> llllllllllllllIIIIlIllIlllIIllIl = (Map<IProperty<?>, Comparable<?>>)Maps.newLinkedHashMap((Map)llllllllllllllIIIIlIllIlllIIlllI.getProperties());
                if (llllllllllllllIIIIlIllIlllIIlllI.getValue((IProperty<Comparable>)BlockStem.FACING) != EnumFacing.UP) {
                    llllllllllllllIIIIlIllIlllIIllIl.remove(BlockStem.AGE);
                }
                return new ModelResourceLocation(Block.REGISTRY.getNameForObject(llllllllllllllIIIIlIllIlllIIlllI.getBlock()), this.getPropertyString(llllllllllllllIIIIlIllIlllIIllIl));
            }
        });
        this.registerBlockWithStateMapper(Blocks.MELON_STEM, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(final IBlockState lIIlIIIIllIllII) {
                final Map<IProperty<?>, Comparable<?>> lIIlIIIIllIlllI = (Map<IProperty<?>, Comparable<?>>)Maps.newLinkedHashMap((Map)lIIlIIIIllIllII.getProperties());
                if (lIIlIIIIllIllII.getValue((IProperty<Comparable>)BlockStem.FACING) != EnumFacing.UP) {
                    lIIlIIIIllIlllI.remove(BlockStem.AGE);
                }
                return new ModelResourceLocation(Block.REGISTRY.getNameForObject(lIIlIIIIllIllII.getBlock()), this.getPropertyString(lIIlIIIIllIlllI));
            }
        });
        this.registerBlockWithStateMapper(Blocks.DIRT, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(final IBlockState lllllllllllllIIIllIIIIIlllIlIlll) {
                final Map<IProperty<?>, Comparable<?>> lllllllllllllIIIllIIIIIlllIllllI = (Map<IProperty<?>, Comparable<?>>)Maps.newLinkedHashMap((Map)lllllllllllllIIIllIIIIIlllIlIlll.getProperties());
                final String lllllllllllllIIIllIIIIIlllIllIll = BlockDirt.VARIANT.getName(lllllllllllllIIIllIIIIIlllIllllI.remove(BlockDirt.VARIANT));
                if (BlockDirt.DirtType.PODZOL != lllllllllllllIIIllIIIIIlllIlIlll.getValue(BlockDirt.VARIANT)) {
                    lllllllllllllIIIllIIIIIlllIllllI.remove(BlockDirt.SNOWY);
                }
                return new ModelResourceLocation(lllllllllllllIIIllIIIIIlllIllIll, this.getPropertyString(lllllllllllllIIIllIIIIIlllIllllI));
            }
        });
        this.registerBlockWithStateMapper(Blocks.DOUBLE_STONE_SLAB, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(final IBlockState lllllllllllllIIlIllllIllllllIlII) {
                final Map<IProperty<?>, Comparable<?>> lllllllllllllIIlIllllIllllllIlll = (Map<IProperty<?>, Comparable<?>>)Maps.newLinkedHashMap((Map)lllllllllllllIIlIllllIllllllIlII.getProperties());
                final String lllllllllllllIIlIllllIllllllIllI = BlockStoneSlab.VARIANT.getName(lllllllllllllIIlIllllIllllllIlll.remove(BlockStoneSlab.VARIANT));
                lllllllllllllIIlIllllIllllllIlll.remove(BlockStoneSlab.SEAMLESS);
                final String lllllllllllllIIlIllllIllllllIlIl = lllllllllllllIIlIllllIllllllIlII.getValue((IProperty<Boolean>)BlockStoneSlab.SEAMLESS) ? "all" : "normal";
                return new ModelResourceLocation(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIlIllllIllllllIllI)).append("_double_slab")), lllllllllllllIIlIllllIllllllIlIl);
            }
        });
        this.registerBlockWithStateMapper(Blocks.DOUBLE_STONE_SLAB2, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(final IBlockState llllllllllllllIIIIlllIIllIIlllIl) {
                final Map<IProperty<?>, Comparable<?>> llllllllllllllIIIIlllIIllIlIIIII = (Map<IProperty<?>, Comparable<?>>)Maps.newLinkedHashMap((Map)llllllllllllllIIIIlllIIllIIlllIl.getProperties());
                final String llllllllllllllIIIIlllIIllIIlllll = BlockStoneSlabNew.VARIANT.getName(llllllllllllllIIIIlllIIllIlIIIII.remove(BlockStoneSlabNew.VARIANT));
                llllllllllllllIIIIlllIIllIlIIIII.remove(BlockStoneSlab.SEAMLESS);
                final String llllllllllllllIIIIlllIIllIIllllI = llllllllllllllIIIIlllIIllIIlllIl.getValue((IProperty<Boolean>)BlockStoneSlabNew.SEAMLESS) ? "all" : "normal";
                return new ModelResourceLocation(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIlllIIllIIlllll)).append("_double_slab")), llllllllllllllIIIIlllIIllIIllllI);
            }
        });
    }
    
    public IBakedModel getModelForState(final IBlockState lllllllllllllIIlIllllIIllIIlIlIl) {
        IBakedModel lllllllllllllIIlIllllIIllIIlIlII = this.bakedModelStore.get(lllllllllllllIIlIllllIIllIIlIlIl);
        if (lllllllllllllIIlIllllIIllIIlIlII == null) {
            lllllllllllllIIlIllllIIllIIlIlII = this.modelManager.getMissingModel();
        }
        return lllllllllllllIIlIllllIIllIIlIlII;
    }
    
    public void registerBlockWithStateMapper(final Block lllllllllllllIIlIllllIIllIIIIIIl, final IStateMapper lllllllllllllIIlIllllIIlIlllllIl) {
        this.blockStateMapper.registerBlockStateMapper(lllllllllllllIIlIllllIIllIIIIIIl, lllllllllllllIIlIllllIIlIlllllIl);
    }
    
    public ModelManager getModelManager() {
        return this.modelManager;
    }
}
