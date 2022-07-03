package net.minecraft.client.renderer;

import net.minecraft.client.renderer.color.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.gui.*;
import javax.annotation.*;
import net.minecraft.client.*;
import net.minecraft.client.entity.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.block.state.*;
import optifine.*;
import shadersmod.client.*;
import net.minecraft.client.resources.*;
import net.minecraft.util.*;
import net.minecraft.crash.*;
import font.*;
import net.minecraft.client.renderer.tileentity.*;
import java.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.block.model.*;

public class RenderItem implements IResourceManagerReloadListener
{
    private static final /* synthetic */ ResourceLocation RES_ITEM_GLINT;
    public /* synthetic */ float zLevel;
    private /* synthetic */ ResourceLocation modelLocation;
    private /* synthetic */ boolean renderItemGui;
    private /* synthetic */ boolean notRenderingEffectsInGUI;
    private final /* synthetic */ ItemColors itemColors;
    public /* synthetic */ ModelManager modelManager;
    private final /* synthetic */ TextureManager textureManager;
    private final /* synthetic */ ItemModelMesher itemModelMesher;
    
    public ItemModelMesher getItemModelMesher() {
        return this.itemModelMesher;
    }
    
    static {
        RES_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    }
    
    protected void registerBlock(final Block lllllllllllllIIllIIIlIIIIllIIlII, final int lllllllllllllIIllIIIlIIIIllIIIll, final String lllllllllllllIIllIIIlIIIIllIIIlI) {
        this.registerItem(Item.getItemFromBlock(lllllllllllllIIllIIIlIIIIllIIlII), lllllllllllllIIllIIIlIIIIllIIIll, lllllllllllllIIllIIIlIIIIllIIIlI);
    }
    
    private void registerItems() {
        this.registerBlock(Blocks.ANVIL, "anvil_intact");
        this.registerBlock(Blocks.ANVIL, 1, "anvil_slightly_damaged");
        this.registerBlock(Blocks.ANVIL, 2, "anvil_very_damaged");
        this.registerBlock(Blocks.CARPET, EnumDyeColor.BLACK.getMetadata(), "black_carpet");
        this.registerBlock(Blocks.CARPET, EnumDyeColor.BLUE.getMetadata(), "blue_carpet");
        this.registerBlock(Blocks.CARPET, EnumDyeColor.BROWN.getMetadata(), "brown_carpet");
        this.registerBlock(Blocks.CARPET, EnumDyeColor.CYAN.getMetadata(), "cyan_carpet");
        this.registerBlock(Blocks.CARPET, EnumDyeColor.GRAY.getMetadata(), "gray_carpet");
        this.registerBlock(Blocks.CARPET, EnumDyeColor.GREEN.getMetadata(), "green_carpet");
        this.registerBlock(Blocks.CARPET, EnumDyeColor.LIGHT_BLUE.getMetadata(), "light_blue_carpet");
        this.registerBlock(Blocks.CARPET, EnumDyeColor.LIME.getMetadata(), "lime_carpet");
        this.registerBlock(Blocks.CARPET, EnumDyeColor.MAGENTA.getMetadata(), "magenta_carpet");
        this.registerBlock(Blocks.CARPET, EnumDyeColor.ORANGE.getMetadata(), "orange_carpet");
        this.registerBlock(Blocks.CARPET, EnumDyeColor.PINK.getMetadata(), "pink_carpet");
        this.registerBlock(Blocks.CARPET, EnumDyeColor.PURPLE.getMetadata(), "purple_carpet");
        this.registerBlock(Blocks.CARPET, EnumDyeColor.RED.getMetadata(), "red_carpet");
        this.registerBlock(Blocks.CARPET, EnumDyeColor.SILVER.getMetadata(), "silver_carpet");
        this.registerBlock(Blocks.CARPET, EnumDyeColor.WHITE.getMetadata(), "white_carpet");
        this.registerBlock(Blocks.CARPET, EnumDyeColor.YELLOW.getMetadata(), "yellow_carpet");
        this.registerBlock(Blocks.COBBLESTONE_WALL, BlockWall.EnumType.MOSSY.getMetadata(), "mossy_cobblestone_wall");
        this.registerBlock(Blocks.COBBLESTONE_WALL, BlockWall.EnumType.NORMAL.getMetadata(), "cobblestone_wall");
        this.registerBlock(Blocks.DIRT, BlockDirt.DirtType.COARSE_DIRT.getMetadata(), "coarse_dirt");
        this.registerBlock(Blocks.DIRT, BlockDirt.DirtType.DIRT.getMetadata(), "dirt");
        this.registerBlock(Blocks.DIRT, BlockDirt.DirtType.PODZOL.getMetadata(), "podzol");
        this.registerBlock(Blocks.DOUBLE_PLANT, BlockDoublePlant.EnumPlantType.FERN.getMeta(), "double_fern");
        this.registerBlock(Blocks.DOUBLE_PLANT, BlockDoublePlant.EnumPlantType.GRASS.getMeta(), "double_grass");
        this.registerBlock(Blocks.DOUBLE_PLANT, BlockDoublePlant.EnumPlantType.PAEONIA.getMeta(), "paeonia");
        this.registerBlock(Blocks.DOUBLE_PLANT, BlockDoublePlant.EnumPlantType.ROSE.getMeta(), "double_rose");
        this.registerBlock(Blocks.DOUBLE_PLANT, BlockDoublePlant.EnumPlantType.SUNFLOWER.getMeta(), "sunflower");
        this.registerBlock(Blocks.DOUBLE_PLANT, BlockDoublePlant.EnumPlantType.SYRINGA.getMeta(), "syringa");
        this.registerBlock(Blocks.LEAVES, BlockPlanks.EnumType.BIRCH.getMetadata(), "birch_leaves");
        this.registerBlock(Blocks.LEAVES, BlockPlanks.EnumType.JUNGLE.getMetadata(), "jungle_leaves");
        this.registerBlock(Blocks.LEAVES, BlockPlanks.EnumType.OAK.getMetadata(), "oak_leaves");
        this.registerBlock(Blocks.LEAVES, BlockPlanks.EnumType.SPRUCE.getMetadata(), "spruce_leaves");
        this.registerBlock(Blocks.LEAVES2, BlockPlanks.EnumType.ACACIA.getMetadata() - 4, "acacia_leaves");
        this.registerBlock(Blocks.LEAVES2, BlockPlanks.EnumType.DARK_OAK.getMetadata() - 4, "dark_oak_leaves");
        this.registerBlock(Blocks.LOG, BlockPlanks.EnumType.BIRCH.getMetadata(), "birch_log");
        this.registerBlock(Blocks.LOG, BlockPlanks.EnumType.JUNGLE.getMetadata(), "jungle_log");
        this.registerBlock(Blocks.LOG, BlockPlanks.EnumType.OAK.getMetadata(), "oak_log");
        this.registerBlock(Blocks.LOG, BlockPlanks.EnumType.SPRUCE.getMetadata(), "spruce_log");
        this.registerBlock(Blocks.LOG2, BlockPlanks.EnumType.ACACIA.getMetadata() - 4, "acacia_log");
        this.registerBlock(Blocks.LOG2, BlockPlanks.EnumType.DARK_OAK.getMetadata() - 4, "dark_oak_log");
        this.registerBlock(Blocks.MONSTER_EGG, BlockSilverfish.EnumType.CHISELED_STONEBRICK.getMetadata(), "chiseled_brick_monster_egg");
        this.registerBlock(Blocks.MONSTER_EGG, BlockSilverfish.EnumType.COBBLESTONE.getMetadata(), "cobblestone_monster_egg");
        this.registerBlock(Blocks.MONSTER_EGG, BlockSilverfish.EnumType.CRACKED_STONEBRICK.getMetadata(), "cracked_brick_monster_egg");
        this.registerBlock(Blocks.MONSTER_EGG, BlockSilverfish.EnumType.MOSSY_STONEBRICK.getMetadata(), "mossy_brick_monster_egg");
        this.registerBlock(Blocks.MONSTER_EGG, BlockSilverfish.EnumType.STONE.getMetadata(), "stone_monster_egg");
        this.registerBlock(Blocks.MONSTER_EGG, BlockSilverfish.EnumType.STONEBRICK.getMetadata(), "stone_brick_monster_egg");
        this.registerBlock(Blocks.PLANKS, BlockPlanks.EnumType.ACACIA.getMetadata(), "acacia_planks");
        this.registerBlock(Blocks.PLANKS, BlockPlanks.EnumType.BIRCH.getMetadata(), "birch_planks");
        this.registerBlock(Blocks.PLANKS, BlockPlanks.EnumType.DARK_OAK.getMetadata(), "dark_oak_planks");
        this.registerBlock(Blocks.PLANKS, BlockPlanks.EnumType.JUNGLE.getMetadata(), "jungle_planks");
        this.registerBlock(Blocks.PLANKS, BlockPlanks.EnumType.OAK.getMetadata(), "oak_planks");
        this.registerBlock(Blocks.PLANKS, BlockPlanks.EnumType.SPRUCE.getMetadata(), "spruce_planks");
        this.registerBlock(Blocks.PRISMARINE, BlockPrismarine.EnumType.BRICKS.getMetadata(), "prismarine_bricks");
        this.registerBlock(Blocks.PRISMARINE, BlockPrismarine.EnumType.DARK.getMetadata(), "dark_prismarine");
        this.registerBlock(Blocks.PRISMARINE, BlockPrismarine.EnumType.ROUGH.getMetadata(), "prismarine");
        this.registerBlock(Blocks.QUARTZ_BLOCK, BlockQuartz.EnumType.CHISELED.getMetadata(), "chiseled_quartz_block");
        this.registerBlock(Blocks.QUARTZ_BLOCK, BlockQuartz.EnumType.DEFAULT.getMetadata(), "quartz_block");
        this.registerBlock(Blocks.QUARTZ_BLOCK, BlockQuartz.EnumType.LINES_Y.getMetadata(), "quartz_column");
        this.registerBlock(Blocks.RED_FLOWER, BlockFlower.EnumFlowerType.ALLIUM.getMeta(), "allium");
        this.registerBlock(Blocks.RED_FLOWER, BlockFlower.EnumFlowerType.BLUE_ORCHID.getMeta(), "blue_orchid");
        this.registerBlock(Blocks.RED_FLOWER, BlockFlower.EnumFlowerType.HOUSTONIA.getMeta(), "houstonia");
        this.registerBlock(Blocks.RED_FLOWER, BlockFlower.EnumFlowerType.ORANGE_TULIP.getMeta(), "orange_tulip");
        this.registerBlock(Blocks.RED_FLOWER, BlockFlower.EnumFlowerType.OXEYE_DAISY.getMeta(), "oxeye_daisy");
        this.registerBlock(Blocks.RED_FLOWER, BlockFlower.EnumFlowerType.PINK_TULIP.getMeta(), "pink_tulip");
        this.registerBlock(Blocks.RED_FLOWER, BlockFlower.EnumFlowerType.POPPY.getMeta(), "poppy");
        this.registerBlock(Blocks.RED_FLOWER, BlockFlower.EnumFlowerType.RED_TULIP.getMeta(), "red_tulip");
        this.registerBlock(Blocks.RED_FLOWER, BlockFlower.EnumFlowerType.WHITE_TULIP.getMeta(), "white_tulip");
        this.registerBlock(Blocks.SAND, BlockSand.EnumType.RED_SAND.getMetadata(), "red_sand");
        this.registerBlock(Blocks.SAND, BlockSand.EnumType.SAND.getMetadata(), "sand");
        this.registerBlock(Blocks.SANDSTONE, BlockSandStone.EnumType.CHISELED.getMetadata(), "chiseled_sandstone");
        this.registerBlock(Blocks.SANDSTONE, BlockSandStone.EnumType.DEFAULT.getMetadata(), "sandstone");
        this.registerBlock(Blocks.SANDSTONE, BlockSandStone.EnumType.SMOOTH.getMetadata(), "smooth_sandstone");
        this.registerBlock(Blocks.RED_SANDSTONE, BlockRedSandstone.EnumType.CHISELED.getMetadata(), "chiseled_red_sandstone");
        this.registerBlock(Blocks.RED_SANDSTONE, BlockRedSandstone.EnumType.DEFAULT.getMetadata(), "red_sandstone");
        this.registerBlock(Blocks.RED_SANDSTONE, BlockRedSandstone.EnumType.SMOOTH.getMetadata(), "smooth_red_sandstone");
        this.registerBlock(Blocks.SAPLING, BlockPlanks.EnumType.ACACIA.getMetadata(), "acacia_sapling");
        this.registerBlock(Blocks.SAPLING, BlockPlanks.EnumType.BIRCH.getMetadata(), "birch_sapling");
        this.registerBlock(Blocks.SAPLING, BlockPlanks.EnumType.DARK_OAK.getMetadata(), "dark_oak_sapling");
        this.registerBlock(Blocks.SAPLING, BlockPlanks.EnumType.JUNGLE.getMetadata(), "jungle_sapling");
        this.registerBlock(Blocks.SAPLING, BlockPlanks.EnumType.OAK.getMetadata(), "oak_sapling");
        this.registerBlock(Blocks.SAPLING, BlockPlanks.EnumType.SPRUCE.getMetadata(), "spruce_sapling");
        this.registerBlock(Blocks.SPONGE, 0, "sponge");
        this.registerBlock(Blocks.SPONGE, 1, "sponge_wet");
        this.registerBlock(Blocks.STAINED_GLASS, EnumDyeColor.BLACK.getMetadata(), "black_stained_glass");
        this.registerBlock(Blocks.STAINED_GLASS, EnumDyeColor.BLUE.getMetadata(), "blue_stained_glass");
        this.registerBlock(Blocks.STAINED_GLASS, EnumDyeColor.BROWN.getMetadata(), "brown_stained_glass");
        this.registerBlock(Blocks.STAINED_GLASS, EnumDyeColor.CYAN.getMetadata(), "cyan_stained_glass");
        this.registerBlock(Blocks.STAINED_GLASS, EnumDyeColor.GRAY.getMetadata(), "gray_stained_glass");
        this.registerBlock(Blocks.STAINED_GLASS, EnumDyeColor.GREEN.getMetadata(), "green_stained_glass");
        this.registerBlock(Blocks.STAINED_GLASS, EnumDyeColor.LIGHT_BLUE.getMetadata(), "light_blue_stained_glass");
        this.registerBlock(Blocks.STAINED_GLASS, EnumDyeColor.LIME.getMetadata(), "lime_stained_glass");
        this.registerBlock(Blocks.STAINED_GLASS, EnumDyeColor.MAGENTA.getMetadata(), "magenta_stained_glass");
        this.registerBlock(Blocks.STAINED_GLASS, EnumDyeColor.ORANGE.getMetadata(), "orange_stained_glass");
        this.registerBlock(Blocks.STAINED_GLASS, EnumDyeColor.PINK.getMetadata(), "pink_stained_glass");
        this.registerBlock(Blocks.STAINED_GLASS, EnumDyeColor.PURPLE.getMetadata(), "purple_stained_glass");
        this.registerBlock(Blocks.STAINED_GLASS, EnumDyeColor.RED.getMetadata(), "red_stained_glass");
        this.registerBlock(Blocks.STAINED_GLASS, EnumDyeColor.SILVER.getMetadata(), "silver_stained_glass");
        this.registerBlock(Blocks.STAINED_GLASS, EnumDyeColor.WHITE.getMetadata(), "white_stained_glass");
        this.registerBlock(Blocks.STAINED_GLASS, EnumDyeColor.YELLOW.getMetadata(), "yellow_stained_glass");
        this.registerBlock(Blocks.STAINED_GLASS_PANE, EnumDyeColor.BLACK.getMetadata(), "black_stained_glass_pane");
        this.registerBlock(Blocks.STAINED_GLASS_PANE, EnumDyeColor.BLUE.getMetadata(), "blue_stained_glass_pane");
        this.registerBlock(Blocks.STAINED_GLASS_PANE, EnumDyeColor.BROWN.getMetadata(), "brown_stained_glass_pane");
        this.registerBlock(Blocks.STAINED_GLASS_PANE, EnumDyeColor.CYAN.getMetadata(), "cyan_stained_glass_pane");
        this.registerBlock(Blocks.STAINED_GLASS_PANE, EnumDyeColor.GRAY.getMetadata(), "gray_stained_glass_pane");
        this.registerBlock(Blocks.STAINED_GLASS_PANE, EnumDyeColor.GREEN.getMetadata(), "green_stained_glass_pane");
        this.registerBlock(Blocks.STAINED_GLASS_PANE, EnumDyeColor.LIGHT_BLUE.getMetadata(), "light_blue_stained_glass_pane");
        this.registerBlock(Blocks.STAINED_GLASS_PANE, EnumDyeColor.LIME.getMetadata(), "lime_stained_glass_pane");
        this.registerBlock(Blocks.STAINED_GLASS_PANE, EnumDyeColor.MAGENTA.getMetadata(), "magenta_stained_glass_pane");
        this.registerBlock(Blocks.STAINED_GLASS_PANE, EnumDyeColor.ORANGE.getMetadata(), "orange_stained_glass_pane");
        this.registerBlock(Blocks.STAINED_GLASS_PANE, EnumDyeColor.PINK.getMetadata(), "pink_stained_glass_pane");
        this.registerBlock(Blocks.STAINED_GLASS_PANE, EnumDyeColor.PURPLE.getMetadata(), "purple_stained_glass_pane");
        this.registerBlock(Blocks.STAINED_GLASS_PANE, EnumDyeColor.RED.getMetadata(), "red_stained_glass_pane");
        this.registerBlock(Blocks.STAINED_GLASS_PANE, EnumDyeColor.SILVER.getMetadata(), "silver_stained_glass_pane");
        this.registerBlock(Blocks.STAINED_GLASS_PANE, EnumDyeColor.WHITE.getMetadata(), "white_stained_glass_pane");
        this.registerBlock(Blocks.STAINED_GLASS_PANE, EnumDyeColor.YELLOW.getMetadata(), "yellow_stained_glass_pane");
        this.registerBlock(Blocks.STAINED_HARDENED_CLAY, EnumDyeColor.BLACK.getMetadata(), "black_stained_hardened_clay");
        this.registerBlock(Blocks.STAINED_HARDENED_CLAY, EnumDyeColor.BLUE.getMetadata(), "blue_stained_hardened_clay");
        this.registerBlock(Blocks.STAINED_HARDENED_CLAY, EnumDyeColor.BROWN.getMetadata(), "brown_stained_hardened_clay");
        this.registerBlock(Blocks.STAINED_HARDENED_CLAY, EnumDyeColor.CYAN.getMetadata(), "cyan_stained_hardened_clay");
        this.registerBlock(Blocks.STAINED_HARDENED_CLAY, EnumDyeColor.GRAY.getMetadata(), "gray_stained_hardened_clay");
        this.registerBlock(Blocks.STAINED_HARDENED_CLAY, EnumDyeColor.GREEN.getMetadata(), "green_stained_hardened_clay");
        this.registerBlock(Blocks.STAINED_HARDENED_CLAY, EnumDyeColor.LIGHT_BLUE.getMetadata(), "light_blue_stained_hardened_clay");
        this.registerBlock(Blocks.STAINED_HARDENED_CLAY, EnumDyeColor.LIME.getMetadata(), "lime_stained_hardened_clay");
        this.registerBlock(Blocks.STAINED_HARDENED_CLAY, EnumDyeColor.MAGENTA.getMetadata(), "magenta_stained_hardened_clay");
        this.registerBlock(Blocks.STAINED_HARDENED_CLAY, EnumDyeColor.ORANGE.getMetadata(), "orange_stained_hardened_clay");
        this.registerBlock(Blocks.STAINED_HARDENED_CLAY, EnumDyeColor.PINK.getMetadata(), "pink_stained_hardened_clay");
        this.registerBlock(Blocks.STAINED_HARDENED_CLAY, EnumDyeColor.PURPLE.getMetadata(), "purple_stained_hardened_clay");
        this.registerBlock(Blocks.STAINED_HARDENED_CLAY, EnumDyeColor.RED.getMetadata(), "red_stained_hardened_clay");
        this.registerBlock(Blocks.STAINED_HARDENED_CLAY, EnumDyeColor.SILVER.getMetadata(), "silver_stained_hardened_clay");
        this.registerBlock(Blocks.STAINED_HARDENED_CLAY, EnumDyeColor.WHITE.getMetadata(), "white_stained_hardened_clay");
        this.registerBlock(Blocks.STAINED_HARDENED_CLAY, EnumDyeColor.YELLOW.getMetadata(), "yellow_stained_hardened_clay");
        this.registerBlock(Blocks.STONE, BlockStone.EnumType.ANDESITE.getMetadata(), "andesite");
        this.registerBlock(Blocks.STONE, BlockStone.EnumType.ANDESITE_SMOOTH.getMetadata(), "andesite_smooth");
        this.registerBlock(Blocks.STONE, BlockStone.EnumType.DIORITE.getMetadata(), "diorite");
        this.registerBlock(Blocks.STONE, BlockStone.EnumType.DIORITE_SMOOTH.getMetadata(), "diorite_smooth");
        this.registerBlock(Blocks.STONE, BlockStone.EnumType.GRANITE.getMetadata(), "granite");
        this.registerBlock(Blocks.STONE, BlockStone.EnumType.GRANITE_SMOOTH.getMetadata(), "granite_smooth");
        this.registerBlock(Blocks.STONE, BlockStone.EnumType.STONE.getMetadata(), "stone");
        this.registerBlock(Blocks.STONEBRICK, BlockStoneBrick.EnumType.CRACKED.getMetadata(), "cracked_stonebrick");
        this.registerBlock(Blocks.STONEBRICK, BlockStoneBrick.EnumType.DEFAULT.getMetadata(), "stonebrick");
        this.registerBlock(Blocks.STONEBRICK, BlockStoneBrick.EnumType.CHISELED.getMetadata(), "chiseled_stonebrick");
        this.registerBlock(Blocks.STONEBRICK, BlockStoneBrick.EnumType.MOSSY.getMetadata(), "mossy_stonebrick");
        this.registerBlock(Blocks.STONE_SLAB, BlockStoneSlab.EnumType.BRICK.getMetadata(), "brick_slab");
        this.registerBlock(Blocks.STONE_SLAB, BlockStoneSlab.EnumType.COBBLESTONE.getMetadata(), "cobblestone_slab");
        this.registerBlock(Blocks.STONE_SLAB, BlockStoneSlab.EnumType.WOOD.getMetadata(), "old_wood_slab");
        this.registerBlock(Blocks.STONE_SLAB, BlockStoneSlab.EnumType.NETHERBRICK.getMetadata(), "nether_brick_slab");
        this.registerBlock(Blocks.STONE_SLAB, BlockStoneSlab.EnumType.QUARTZ.getMetadata(), "quartz_slab");
        this.registerBlock(Blocks.STONE_SLAB, BlockStoneSlab.EnumType.SAND.getMetadata(), "sandstone_slab");
        this.registerBlock(Blocks.STONE_SLAB, BlockStoneSlab.EnumType.SMOOTHBRICK.getMetadata(), "stone_brick_slab");
        this.registerBlock(Blocks.STONE_SLAB, BlockStoneSlab.EnumType.STONE.getMetadata(), "stone_slab");
        this.registerBlock(Blocks.STONE_SLAB2, BlockStoneSlabNew.EnumType.RED_SANDSTONE.getMetadata(), "red_sandstone_slab");
        this.registerBlock(Blocks.TALLGRASS, BlockTallGrass.EnumType.DEAD_BUSH.getMeta(), "dead_bush");
        this.registerBlock(Blocks.TALLGRASS, BlockTallGrass.EnumType.FERN.getMeta(), "fern");
        this.registerBlock(Blocks.TALLGRASS, BlockTallGrass.EnumType.GRASS.getMeta(), "tall_grass");
        this.registerBlock(Blocks.WOODEN_SLAB, BlockPlanks.EnumType.ACACIA.getMetadata(), "acacia_slab");
        this.registerBlock(Blocks.WOODEN_SLAB, BlockPlanks.EnumType.BIRCH.getMetadata(), "birch_slab");
        this.registerBlock(Blocks.WOODEN_SLAB, BlockPlanks.EnumType.DARK_OAK.getMetadata(), "dark_oak_slab");
        this.registerBlock(Blocks.WOODEN_SLAB, BlockPlanks.EnumType.JUNGLE.getMetadata(), "jungle_slab");
        this.registerBlock(Blocks.WOODEN_SLAB, BlockPlanks.EnumType.OAK.getMetadata(), "oak_slab");
        this.registerBlock(Blocks.WOODEN_SLAB, BlockPlanks.EnumType.SPRUCE.getMetadata(), "spruce_slab");
        this.registerBlock(Blocks.WOOL, EnumDyeColor.BLACK.getMetadata(), "black_wool");
        this.registerBlock(Blocks.WOOL, EnumDyeColor.BLUE.getMetadata(), "blue_wool");
        this.registerBlock(Blocks.WOOL, EnumDyeColor.BROWN.getMetadata(), "brown_wool");
        this.registerBlock(Blocks.WOOL, EnumDyeColor.CYAN.getMetadata(), "cyan_wool");
        this.registerBlock(Blocks.WOOL, EnumDyeColor.GRAY.getMetadata(), "gray_wool");
        this.registerBlock(Blocks.WOOL, EnumDyeColor.GREEN.getMetadata(), "green_wool");
        this.registerBlock(Blocks.WOOL, EnumDyeColor.LIGHT_BLUE.getMetadata(), "light_blue_wool");
        this.registerBlock(Blocks.WOOL, EnumDyeColor.LIME.getMetadata(), "lime_wool");
        this.registerBlock(Blocks.WOOL, EnumDyeColor.MAGENTA.getMetadata(), "magenta_wool");
        this.registerBlock(Blocks.WOOL, EnumDyeColor.ORANGE.getMetadata(), "orange_wool");
        this.registerBlock(Blocks.WOOL, EnumDyeColor.PINK.getMetadata(), "pink_wool");
        this.registerBlock(Blocks.WOOL, EnumDyeColor.PURPLE.getMetadata(), "purple_wool");
        this.registerBlock(Blocks.WOOL, EnumDyeColor.RED.getMetadata(), "red_wool");
        this.registerBlock(Blocks.WOOL, EnumDyeColor.SILVER.getMetadata(), "silver_wool");
        this.registerBlock(Blocks.WOOL, EnumDyeColor.WHITE.getMetadata(), "white_wool");
        this.registerBlock(Blocks.WOOL, EnumDyeColor.YELLOW.getMetadata(), "yellow_wool");
        this.registerBlock(Blocks.FARMLAND, "farmland");
        this.registerBlock(Blocks.ACACIA_STAIRS, "acacia_stairs");
        this.registerBlock(Blocks.ACTIVATOR_RAIL, "activator_rail");
        this.registerBlock(Blocks.BEACON, "beacon");
        this.registerBlock(Blocks.BEDROCK, "bedrock");
        this.registerBlock(Blocks.BIRCH_STAIRS, "birch_stairs");
        this.registerBlock(Blocks.BOOKSHELF, "bookshelf");
        this.registerBlock(Blocks.BRICK_BLOCK, "brick_block");
        this.registerBlock(Blocks.BRICK_BLOCK, "brick_block");
        this.registerBlock(Blocks.BRICK_STAIRS, "brick_stairs");
        this.registerBlock(Blocks.BROWN_MUSHROOM, "brown_mushroom");
        this.registerBlock(Blocks.CACTUS, "cactus");
        this.registerBlock(Blocks.CLAY, "clay");
        this.registerBlock(Blocks.COAL_BLOCK, "coal_block");
        this.registerBlock(Blocks.COAL_ORE, "coal_ore");
        this.registerBlock(Blocks.COBBLESTONE, "cobblestone");
        this.registerBlock(Blocks.CRAFTING_TABLE, "crafting_table");
        this.registerBlock(Blocks.DARK_OAK_STAIRS, "dark_oak_stairs");
        this.registerBlock(Blocks.DAYLIGHT_DETECTOR, "daylight_detector");
        this.registerBlock(Blocks.DEADBUSH, "dead_bush");
        this.registerBlock(Blocks.DETECTOR_RAIL, "detector_rail");
        this.registerBlock(Blocks.DIAMOND_BLOCK, "diamond_block");
        this.registerBlock(Blocks.DIAMOND_ORE, "diamond_ore");
        this.registerBlock(Blocks.DISPENSER, "dispenser");
        this.registerBlock(Blocks.DROPPER, "dropper");
        this.registerBlock(Blocks.EMERALD_BLOCK, "emerald_block");
        this.registerBlock(Blocks.EMERALD_ORE, "emerald_ore");
        this.registerBlock(Blocks.ENCHANTING_TABLE, "enchanting_table");
        this.registerBlock(Blocks.END_PORTAL_FRAME, "end_portal_frame");
        this.registerBlock(Blocks.END_STONE, "end_stone");
        this.registerBlock(Blocks.OAK_FENCE, "oak_fence");
        this.registerBlock(Blocks.SPRUCE_FENCE, "spruce_fence");
        this.registerBlock(Blocks.BIRCH_FENCE, "birch_fence");
        this.registerBlock(Blocks.JUNGLE_FENCE, "jungle_fence");
        this.registerBlock(Blocks.DARK_OAK_FENCE, "dark_oak_fence");
        this.registerBlock(Blocks.ACACIA_FENCE, "acacia_fence");
        this.registerBlock(Blocks.OAK_FENCE_GATE, "oak_fence_gate");
        this.registerBlock(Blocks.SPRUCE_FENCE_GATE, "spruce_fence_gate");
        this.registerBlock(Blocks.BIRCH_FENCE_GATE, "birch_fence_gate");
        this.registerBlock(Blocks.JUNGLE_FENCE_GATE, "jungle_fence_gate");
        this.registerBlock(Blocks.DARK_OAK_FENCE_GATE, "dark_oak_fence_gate");
        this.registerBlock(Blocks.ACACIA_FENCE_GATE, "acacia_fence_gate");
        this.registerBlock(Blocks.FURNACE, "furnace");
        this.registerBlock(Blocks.GLASS, "glass");
        this.registerBlock(Blocks.GLASS_PANE, "glass_pane");
        this.registerBlock(Blocks.GLOWSTONE, "glowstone");
        this.registerBlock(Blocks.GOLDEN_RAIL, "golden_rail");
        this.registerBlock(Blocks.GOLD_BLOCK, "gold_block");
        this.registerBlock(Blocks.GOLD_ORE, "gold_ore");
        this.registerBlock(Blocks.GRASS, "grass");
        this.registerBlock(Blocks.GRASS_PATH, "grass_path");
        this.registerBlock(Blocks.GRAVEL, "gravel");
        this.registerBlock(Blocks.HARDENED_CLAY, "hardened_clay");
        this.registerBlock(Blocks.HAY_BLOCK, "hay_block");
        this.registerBlock(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, "heavy_weighted_pressure_plate");
        this.registerBlock(Blocks.HOPPER, "hopper");
        this.registerBlock(Blocks.ICE, "ice");
        this.registerBlock(Blocks.IRON_BARS, "iron_bars");
        this.registerBlock(Blocks.IRON_BLOCK, "iron_block");
        this.registerBlock(Blocks.IRON_ORE, "iron_ore");
        this.registerBlock(Blocks.IRON_TRAPDOOR, "iron_trapdoor");
        this.registerBlock(Blocks.JUKEBOX, "jukebox");
        this.registerBlock(Blocks.JUNGLE_STAIRS, "jungle_stairs");
        this.registerBlock(Blocks.LADDER, "ladder");
        this.registerBlock(Blocks.LAPIS_BLOCK, "lapis_block");
        this.registerBlock(Blocks.LAPIS_ORE, "lapis_ore");
        this.registerBlock(Blocks.LEVER, "lever");
        this.registerBlock(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE, "light_weighted_pressure_plate");
        this.registerBlock(Blocks.LIT_PUMPKIN, "lit_pumpkin");
        this.registerBlock(Blocks.MELON_BLOCK, "melon_block");
        this.registerBlock(Blocks.MOSSY_COBBLESTONE, "mossy_cobblestone");
        this.registerBlock(Blocks.MYCELIUM, "mycelium");
        this.registerBlock(Blocks.NETHERRACK, "netherrack");
        this.registerBlock(Blocks.NETHER_BRICK, "nether_brick");
        this.registerBlock(Blocks.NETHER_BRICK_FENCE, "nether_brick_fence");
        this.registerBlock(Blocks.NETHER_BRICK_STAIRS, "nether_brick_stairs");
        this.registerBlock(Blocks.NOTEBLOCK, "noteblock");
        this.registerBlock(Blocks.OAK_STAIRS, "oak_stairs");
        this.registerBlock(Blocks.OBSIDIAN, "obsidian");
        this.registerBlock(Blocks.PACKED_ICE, "packed_ice");
        this.registerBlock(Blocks.PISTON, "piston");
        this.registerBlock(Blocks.PUMPKIN, "pumpkin");
        this.registerBlock(Blocks.QUARTZ_ORE, "quartz_ore");
        this.registerBlock(Blocks.QUARTZ_STAIRS, "quartz_stairs");
        this.registerBlock(Blocks.RAIL, "rail");
        this.registerBlock(Blocks.REDSTONE_BLOCK, "redstone_block");
        this.registerBlock(Blocks.REDSTONE_LAMP, "redstone_lamp");
        this.registerBlock(Blocks.REDSTONE_ORE, "redstone_ore");
        this.registerBlock(Blocks.REDSTONE_TORCH, "redstone_torch");
        this.registerBlock(Blocks.RED_MUSHROOM, "red_mushroom");
        this.registerBlock(Blocks.SANDSTONE_STAIRS, "sandstone_stairs");
        this.registerBlock(Blocks.RED_SANDSTONE_STAIRS, "red_sandstone_stairs");
        this.registerBlock(Blocks.SEA_LANTERN, "sea_lantern");
        this.registerBlock(Blocks.SLIME_BLOCK, "slime");
        this.registerBlock(Blocks.SNOW, "snow");
        this.registerBlock(Blocks.SNOW_LAYER, "snow_layer");
        this.registerBlock(Blocks.SOUL_SAND, "soul_sand");
        this.registerBlock(Blocks.SPRUCE_STAIRS, "spruce_stairs");
        this.registerBlock(Blocks.STICKY_PISTON, "sticky_piston");
        this.registerBlock(Blocks.STONE_BRICK_STAIRS, "stone_brick_stairs");
        this.registerBlock(Blocks.STONE_BUTTON, "stone_button");
        this.registerBlock(Blocks.STONE_PRESSURE_PLATE, "stone_pressure_plate");
        this.registerBlock(Blocks.STONE_STAIRS, "stone_stairs");
        this.registerBlock(Blocks.TNT, "tnt");
        this.registerBlock(Blocks.TORCH, "torch");
        this.registerBlock(Blocks.TRAPDOOR, "trapdoor");
        this.registerBlock(Blocks.TRIPWIRE_HOOK, "tripwire_hook");
        this.registerBlock(Blocks.VINE, "vine");
        this.registerBlock(Blocks.WATERLILY, "waterlily");
        this.registerBlock(Blocks.WEB, "web");
        this.registerBlock(Blocks.WOODEN_BUTTON, "wooden_button");
        this.registerBlock(Blocks.WOODEN_PRESSURE_PLATE, "wooden_pressure_plate");
        this.registerBlock(Blocks.YELLOW_FLOWER, BlockFlower.EnumFlowerType.DANDELION.getMeta(), "dandelion");
        this.registerBlock(Blocks.END_ROD, "end_rod");
        this.registerBlock(Blocks.CHORUS_PLANT, "chorus_plant");
        this.registerBlock(Blocks.CHORUS_FLOWER, "chorus_flower");
        this.registerBlock(Blocks.PURPUR_BLOCK, "purpur_block");
        this.registerBlock(Blocks.PURPUR_PILLAR, "purpur_pillar");
        this.registerBlock(Blocks.PURPUR_STAIRS, "purpur_stairs");
        this.registerBlock(Blocks.PURPUR_SLAB, "purpur_slab");
        this.registerBlock(Blocks.PURPUR_DOUBLE_SLAB, "purpur_double_slab");
        this.registerBlock(Blocks.END_BRICKS, "end_bricks");
        this.registerBlock(Blocks.MAGMA, "magma");
        this.registerBlock(Blocks.NETHER_WART_BLOCK, "nether_wart_block");
        this.registerBlock(Blocks.RED_NETHER_BRICK, "red_nether_brick");
        this.registerBlock(Blocks.BONE_BLOCK, "bone_block");
        this.registerBlock(Blocks.STRUCTURE_VOID, "structure_void");
        this.registerBlock(Blocks.field_190976_dk, "observer");
        this.registerBlock(Blocks.field_190977_dl, "white_shulker_box");
        this.registerBlock(Blocks.field_190978_dm, "orange_shulker_box");
        this.registerBlock(Blocks.field_190979_dn, "magenta_shulker_box");
        this.registerBlock(Blocks.field_190980_do, "light_blue_shulker_box");
        this.registerBlock(Blocks.field_190981_dp, "yellow_shulker_box");
        this.registerBlock(Blocks.field_190982_dq, "lime_shulker_box");
        this.registerBlock(Blocks.field_190983_dr, "pink_shulker_box");
        this.registerBlock(Blocks.field_190984_ds, "gray_shulker_box");
        this.registerBlock(Blocks.field_190985_dt, "silver_shulker_box");
        this.registerBlock(Blocks.field_190986_du, "cyan_shulker_box");
        this.registerBlock(Blocks.field_190987_dv, "purple_shulker_box");
        this.registerBlock(Blocks.field_190988_dw, "blue_shulker_box");
        this.registerBlock(Blocks.field_190989_dx, "brown_shulker_box");
        this.registerBlock(Blocks.field_190990_dy, "green_shulker_box");
        this.registerBlock(Blocks.field_190991_dz, "red_shulker_box");
        this.registerBlock(Blocks.field_190975_dA, "black_shulker_box");
        this.registerBlock(Blocks.field_192427_dB, "white_glazed_terracotta");
        this.registerBlock(Blocks.field_192428_dC, "orange_glazed_terracotta");
        this.registerBlock(Blocks.field_192429_dD, "magenta_glazed_terracotta");
        this.registerBlock(Blocks.field_192430_dE, "light_blue_glazed_terracotta");
        this.registerBlock(Blocks.field_192431_dF, "yellow_glazed_terracotta");
        this.registerBlock(Blocks.field_192432_dG, "lime_glazed_terracotta");
        this.registerBlock(Blocks.field_192433_dH, "pink_glazed_terracotta");
        this.registerBlock(Blocks.field_192434_dI, "gray_glazed_terracotta");
        this.registerBlock(Blocks.field_192435_dJ, "silver_glazed_terracotta");
        this.registerBlock(Blocks.field_192436_dK, "cyan_glazed_terracotta");
        this.registerBlock(Blocks.field_192437_dL, "purple_glazed_terracotta");
        this.registerBlock(Blocks.field_192438_dM, "blue_glazed_terracotta");
        this.registerBlock(Blocks.field_192439_dN, "brown_glazed_terracotta");
        this.registerBlock(Blocks.field_192440_dO, "green_glazed_terracotta");
        this.registerBlock(Blocks.field_192441_dP, "red_glazed_terracotta");
        this.registerBlock(Blocks.field_192442_dQ, "black_glazed_terracotta");
        final boolean lllllllllllllIIllIIIIllIlIIIlIII;
        final char lllllllllllllIIllIIIIllIlIIIlIIl = (char)((EnumDyeColor[])(Object)(lllllllllllllIIllIIIIllIlIIIlIII = (boolean)(Object)EnumDyeColor.values())).length;
        for (short lllllllllllllIIllIIIIllIlIIIlIlI = 0; lllllllllllllIIllIIIIllIlIIIlIlI < lllllllllllllIIllIIIIllIlIIIlIIl; ++lllllllllllllIIllIIIIllIlIIIlIlI) {
            final EnumDyeColor lllllllllllllIIllIIIIllIlIIIllIl = lllllllllllllIIllIIIIllIlIIIlIII[lllllllllllllIIllIIIIllIlIIIlIlI];
            this.registerBlock(Blocks.field_192443_dR, lllllllllllllIIllIIIIllIlIIIllIl.getMetadata(), String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIllIIIIllIlIIIllIl.func_192396_c())).append("_concrete")));
            this.registerBlock(Blocks.field_192444_dS, lllllllllllllIIllIIIIllIlIIIllIl.getMetadata(), String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIllIIIIllIlIIIllIl.func_192396_c())).append("_concrete_powder")));
        }
        this.registerBlock(Blocks.CHEST, "chest");
        this.registerBlock(Blocks.TRAPPED_CHEST, "trapped_chest");
        this.registerBlock(Blocks.ENDER_CHEST, "ender_chest");
        this.registerItem(Items.IRON_SHOVEL, "iron_shovel");
        this.registerItem(Items.IRON_PICKAXE, "iron_pickaxe");
        this.registerItem(Items.IRON_AXE, "iron_axe");
        this.registerItem(Items.FLINT_AND_STEEL, "flint_and_steel");
        this.registerItem(Items.APPLE, "apple");
        this.registerItem(Items.BOW, "bow");
        this.registerItem(Items.ARROW, "arrow");
        this.registerItem(Items.SPECTRAL_ARROW, "spectral_arrow");
        this.registerItem(Items.TIPPED_ARROW, "tipped_arrow");
        this.registerItem(Items.COAL, 0, "coal");
        this.registerItem(Items.COAL, 1, "charcoal");
        this.registerItem(Items.DIAMOND, "diamond");
        this.registerItem(Items.IRON_INGOT, "iron_ingot");
        this.registerItem(Items.GOLD_INGOT, "gold_ingot");
        this.registerItem(Items.IRON_SWORD, "iron_sword");
        this.registerItem(Items.WOODEN_SWORD, "wooden_sword");
        this.registerItem(Items.WOODEN_SHOVEL, "wooden_shovel");
        this.registerItem(Items.WOODEN_PICKAXE, "wooden_pickaxe");
        this.registerItem(Items.WOODEN_AXE, "wooden_axe");
        this.registerItem(Items.STONE_SWORD, "stone_sword");
        this.registerItem(Items.STONE_SHOVEL, "stone_shovel");
        this.registerItem(Items.STONE_PICKAXE, "stone_pickaxe");
        this.registerItem(Items.STONE_AXE, "stone_axe");
        this.registerItem(Items.DIAMOND_SWORD, "diamond_sword");
        this.registerItem(Items.DIAMOND_SHOVEL, "diamond_shovel");
        this.registerItem(Items.DIAMOND_PICKAXE, "diamond_pickaxe");
        this.registerItem(Items.DIAMOND_AXE, "diamond_axe");
        this.registerItem(Items.STICK, "stick");
        this.registerItem(Items.BOWL, "bowl");
        this.registerItem(Items.MUSHROOM_STEW, "mushroom_stew");
        this.registerItem(Items.GOLDEN_SWORD, "golden_sword");
        this.registerItem(Items.GOLDEN_SHOVEL, "golden_shovel");
        this.registerItem(Items.GOLDEN_PICKAXE, "golden_pickaxe");
        this.registerItem(Items.GOLDEN_AXE, "golden_axe");
        this.registerItem(Items.STRING, "string");
        this.registerItem(Items.FEATHER, "feather");
        this.registerItem(Items.GUNPOWDER, "gunpowder");
        this.registerItem(Items.WOODEN_HOE, "wooden_hoe");
        this.registerItem(Items.STONE_HOE, "stone_hoe");
        this.registerItem(Items.IRON_HOE, "iron_hoe");
        this.registerItem(Items.DIAMOND_HOE, "diamond_hoe");
        this.registerItem(Items.GOLDEN_HOE, "golden_hoe");
        this.registerItem(Items.WHEAT_SEEDS, "wheat_seeds");
        this.registerItem(Items.WHEAT, "wheat");
        this.registerItem(Items.BREAD, "bread");
        this.registerItem(Items.LEATHER_HELMET, "leather_helmet");
        this.registerItem(Items.LEATHER_CHESTPLATE, "leather_chestplate");
        this.registerItem(Items.LEATHER_LEGGINGS, "leather_leggings");
        this.registerItem(Items.LEATHER_BOOTS, "leather_boots");
        this.registerItem(Items.CHAINMAIL_HELMET, "chainmail_helmet");
        this.registerItem(Items.CHAINMAIL_CHESTPLATE, "chainmail_chestplate");
        this.registerItem(Items.CHAINMAIL_LEGGINGS, "chainmail_leggings");
        this.registerItem(Items.CHAINMAIL_BOOTS, "chainmail_boots");
        this.registerItem(Items.IRON_HELMET, "iron_helmet");
        this.registerItem(Items.IRON_CHESTPLATE, "iron_chestplate");
        this.registerItem(Items.IRON_LEGGINGS, "iron_leggings");
        this.registerItem(Items.IRON_BOOTS, "iron_boots");
        this.registerItem(Items.DIAMOND_HELMET, "diamond_helmet");
        this.registerItem(Items.DIAMOND_CHESTPLATE, "diamond_chestplate");
        this.registerItem(Items.DIAMOND_LEGGINGS, "diamond_leggings");
        this.registerItem(Items.DIAMOND_BOOTS, "diamond_boots");
        this.registerItem(Items.GOLDEN_HELMET, "golden_helmet");
        this.registerItem(Items.GOLDEN_CHESTPLATE, "golden_chestplate");
        this.registerItem(Items.GOLDEN_LEGGINGS, "golden_leggings");
        this.registerItem(Items.GOLDEN_BOOTS, "golden_boots");
        this.registerItem(Items.FLINT, "flint");
        this.registerItem(Items.PORKCHOP, "porkchop");
        this.registerItem(Items.COOKED_PORKCHOP, "cooked_porkchop");
        this.registerItem(Items.PAINTING, "painting");
        this.registerItem(Items.GOLDEN_APPLE, "golden_apple");
        this.registerItem(Items.GOLDEN_APPLE, 1, "golden_apple");
        this.registerItem(Items.SIGN, "sign");
        this.registerItem(Items.OAK_DOOR, "oak_door");
        this.registerItem(Items.SPRUCE_DOOR, "spruce_door");
        this.registerItem(Items.BIRCH_DOOR, "birch_door");
        this.registerItem(Items.JUNGLE_DOOR, "jungle_door");
        this.registerItem(Items.ACACIA_DOOR, "acacia_door");
        this.registerItem(Items.DARK_OAK_DOOR, "dark_oak_door");
        this.registerItem(Items.BUCKET, "bucket");
        this.registerItem(Items.WATER_BUCKET, "water_bucket");
        this.registerItem(Items.LAVA_BUCKET, "lava_bucket");
        this.registerItem(Items.MINECART, "minecart");
        this.registerItem(Items.SADDLE, "saddle");
        this.registerItem(Items.IRON_DOOR, "iron_door");
        this.registerItem(Items.REDSTONE, "redstone");
        this.registerItem(Items.SNOWBALL, "snowball");
        this.registerItem(Items.BOAT, "oak_boat");
        this.registerItem(Items.SPRUCE_BOAT, "spruce_boat");
        this.registerItem(Items.BIRCH_BOAT, "birch_boat");
        this.registerItem(Items.JUNGLE_BOAT, "jungle_boat");
        this.registerItem(Items.ACACIA_BOAT, "acacia_boat");
        this.registerItem(Items.DARK_OAK_BOAT, "dark_oak_boat");
        this.registerItem(Items.LEATHER, "leather");
        this.registerItem(Items.MILK_BUCKET, "milk_bucket");
        this.registerItem(Items.BRICK, "brick");
        this.registerItem(Items.CLAY_BALL, "clay_ball");
        this.registerItem(Items.REEDS, "reeds");
        this.registerItem(Items.PAPER, "paper");
        this.registerItem(Items.BOOK, "book");
        this.registerItem(Items.SLIME_BALL, "slime_ball");
        this.registerItem(Items.CHEST_MINECART, "chest_minecart");
        this.registerItem(Items.FURNACE_MINECART, "furnace_minecart");
        this.registerItem(Items.EGG, "egg");
        this.registerItem(Items.COMPASS, "compass");
        this.registerItem(Items.FISHING_ROD, "fishing_rod");
        this.registerItem(Items.CLOCK, "clock");
        this.registerItem(Items.GLOWSTONE_DUST, "glowstone_dust");
        this.registerItem(Items.FISH, ItemFishFood.FishType.COD.getMetadata(), "cod");
        this.registerItem(Items.FISH, ItemFishFood.FishType.SALMON.getMetadata(), "salmon");
        this.registerItem(Items.FISH, ItemFishFood.FishType.CLOWNFISH.getMetadata(), "clownfish");
        this.registerItem(Items.FISH, ItemFishFood.FishType.PUFFERFISH.getMetadata(), "pufferfish");
        this.registerItem(Items.COOKED_FISH, ItemFishFood.FishType.COD.getMetadata(), "cooked_cod");
        this.registerItem(Items.COOKED_FISH, ItemFishFood.FishType.SALMON.getMetadata(), "cooked_salmon");
        this.registerItem(Items.DYE, EnumDyeColor.BLACK.getDyeDamage(), "dye_black");
        this.registerItem(Items.DYE, EnumDyeColor.RED.getDyeDamage(), "dye_red");
        this.registerItem(Items.DYE, EnumDyeColor.GREEN.getDyeDamage(), "dye_green");
        this.registerItem(Items.DYE, EnumDyeColor.BROWN.getDyeDamage(), "dye_brown");
        this.registerItem(Items.DYE, EnumDyeColor.BLUE.getDyeDamage(), "dye_blue");
        this.registerItem(Items.DYE, EnumDyeColor.PURPLE.getDyeDamage(), "dye_purple");
        this.registerItem(Items.DYE, EnumDyeColor.CYAN.getDyeDamage(), "dye_cyan");
        this.registerItem(Items.DYE, EnumDyeColor.SILVER.getDyeDamage(), "dye_silver");
        this.registerItem(Items.DYE, EnumDyeColor.GRAY.getDyeDamage(), "dye_gray");
        this.registerItem(Items.DYE, EnumDyeColor.PINK.getDyeDamage(), "dye_pink");
        this.registerItem(Items.DYE, EnumDyeColor.LIME.getDyeDamage(), "dye_lime");
        this.registerItem(Items.DYE, EnumDyeColor.YELLOW.getDyeDamage(), "dye_yellow");
        this.registerItem(Items.DYE, EnumDyeColor.LIGHT_BLUE.getDyeDamage(), "dye_light_blue");
        this.registerItem(Items.DYE, EnumDyeColor.MAGENTA.getDyeDamage(), "dye_magenta");
        this.registerItem(Items.DYE, EnumDyeColor.ORANGE.getDyeDamage(), "dye_orange");
        this.registerItem(Items.DYE, EnumDyeColor.WHITE.getDyeDamage(), "dye_white");
        this.registerItem(Items.BONE, "bone");
        this.registerItem(Items.SUGAR, "sugar");
        this.registerItem(Items.CAKE, "cake");
        this.registerItem(Items.REPEATER, "repeater");
        this.registerItem(Items.COOKIE, "cookie");
        this.registerItem(Items.SHEARS, "shears");
        this.registerItem(Items.MELON, "melon");
        this.registerItem(Items.PUMPKIN_SEEDS, "pumpkin_seeds");
        this.registerItem(Items.MELON_SEEDS, "melon_seeds");
        this.registerItem(Items.BEEF, "beef");
        this.registerItem(Items.COOKED_BEEF, "cooked_beef");
        this.registerItem(Items.CHICKEN, "chicken");
        this.registerItem(Items.COOKED_CHICKEN, "cooked_chicken");
        this.registerItem(Items.RABBIT, "rabbit");
        this.registerItem(Items.COOKED_RABBIT, "cooked_rabbit");
        this.registerItem(Items.MUTTON, "mutton");
        this.registerItem(Items.COOKED_MUTTON, "cooked_mutton");
        this.registerItem(Items.RABBIT_FOOT, "rabbit_foot");
        this.registerItem(Items.RABBIT_HIDE, "rabbit_hide");
        this.registerItem(Items.RABBIT_STEW, "rabbit_stew");
        this.registerItem(Items.ROTTEN_FLESH, "rotten_flesh");
        this.registerItem(Items.ENDER_PEARL, "ender_pearl");
        this.registerItem(Items.BLAZE_ROD, "blaze_rod");
        this.registerItem(Items.GHAST_TEAR, "ghast_tear");
        this.registerItem(Items.GOLD_NUGGET, "gold_nugget");
        this.registerItem(Items.NETHER_WART, "nether_wart");
        this.registerItem(Items.BEETROOT, "beetroot");
        this.registerItem(Items.BEETROOT_SEEDS, "beetroot_seeds");
        this.registerItem(Items.BEETROOT_SOUP, "beetroot_soup");
        this.registerItem(Items.field_190929_cY, "totem");
        this.registerItem(Items.POTIONITEM, "bottle_drinkable");
        this.registerItem(Items.SPLASH_POTION, "bottle_splash");
        this.registerItem(Items.LINGERING_POTION, "bottle_lingering");
        this.registerItem(Items.GLASS_BOTTLE, "glass_bottle");
        this.registerItem(Items.DRAGON_BREATH, "dragon_breath");
        this.registerItem(Items.SPIDER_EYE, "spider_eye");
        this.registerItem(Items.FERMENTED_SPIDER_EYE, "fermented_spider_eye");
        this.registerItem(Items.BLAZE_POWDER, "blaze_powder");
        this.registerItem(Items.MAGMA_CREAM, "magma_cream");
        this.registerItem(Items.BREWING_STAND, "brewing_stand");
        this.registerItem(Items.CAULDRON, "cauldron");
        this.registerItem(Items.ENDER_EYE, "ender_eye");
        this.registerItem(Items.SPECKLED_MELON, "speckled_melon");
        this.itemModelMesher.register(Items.SPAWN_EGG, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(final ItemStack lllllllllllllIIlIlIIIlIIIlIllIll) {
                return new ModelResourceLocation("spawn_egg", "inventory");
            }
        });
        this.registerItem(Items.EXPERIENCE_BOTTLE, "experience_bottle");
        this.registerItem(Items.FIRE_CHARGE, "fire_charge");
        this.registerItem(Items.WRITABLE_BOOK, "writable_book");
        this.registerItem(Items.EMERALD, "emerald");
        this.registerItem(Items.ITEM_FRAME, "item_frame");
        this.registerItem(Items.FLOWER_POT, "flower_pot");
        this.registerItem(Items.CARROT, "carrot");
        this.registerItem(Items.POTATO, "potato");
        this.registerItem(Items.BAKED_POTATO, "baked_potato");
        this.registerItem(Items.POISONOUS_POTATO, "poisonous_potato");
        this.registerItem(Items.MAP, "map");
        this.registerItem(Items.GOLDEN_CARROT, "golden_carrot");
        this.registerItem(Items.SKULL, 0, "skull_skeleton");
        this.registerItem(Items.SKULL, 1, "skull_wither");
        this.registerItem(Items.SKULL, 2, "skull_zombie");
        this.registerItem(Items.SKULL, 3, "skull_char");
        this.registerItem(Items.SKULL, 4, "skull_creeper");
        this.registerItem(Items.SKULL, 5, "skull_dragon");
        this.registerItem(Items.CARROT_ON_A_STICK, "carrot_on_a_stick");
        this.registerItem(Items.NETHER_STAR, "nether_star");
        this.registerItem(Items.END_CRYSTAL, "end_crystal");
        this.registerItem(Items.PUMPKIN_PIE, "pumpkin_pie");
        this.registerItem(Items.FIREWORK_CHARGE, "firework_charge");
        this.registerItem(Items.COMPARATOR, "comparator");
        this.registerItem(Items.NETHERBRICK, "netherbrick");
        this.registerItem(Items.QUARTZ, "quartz");
        this.registerItem(Items.TNT_MINECART, "tnt_minecart");
        this.registerItem(Items.HOPPER_MINECART, "hopper_minecart");
        this.registerItem(Items.ARMOR_STAND, "armor_stand");
        this.registerItem(Items.IRON_HORSE_ARMOR, "iron_horse_armor");
        this.registerItem(Items.GOLDEN_HORSE_ARMOR, "golden_horse_armor");
        this.registerItem(Items.DIAMOND_HORSE_ARMOR, "diamond_horse_armor");
        this.registerItem(Items.LEAD, "lead");
        this.registerItem(Items.NAME_TAG, "name_tag");
        this.itemModelMesher.register(Items.BANNER, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(final ItemStack lllllllllllllIIIllllllIllIllIIII) {
                return new ModelResourceLocation("banner", "inventory");
            }
        });
        this.itemModelMesher.register(Items.BED, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(final ItemStack llllllllllllllllIIlIIIIIIllIIIll) {
                return new ModelResourceLocation("bed", "inventory");
            }
        });
        this.itemModelMesher.register(Items.SHIELD, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(final ItemStack llllllllllllllllIllllIlllllIlIII) {
                return new ModelResourceLocation("shield", "inventory");
            }
        });
        this.registerItem(Items.ELYTRA, "elytra");
        this.registerItem(Items.CHORUS_FRUIT, "chorus_fruit");
        this.registerItem(Items.CHORUS_FRUIT_POPPED, "chorus_fruit_popped");
        this.registerItem(Items.field_190930_cZ, "shulker_shell");
        this.registerItem(Items.field_191525_da, "iron_nugget");
        this.registerItem(Items.RECORD_13, "record_13");
        this.registerItem(Items.RECORD_CAT, "record_cat");
        this.registerItem(Items.RECORD_BLOCKS, "record_blocks");
        this.registerItem(Items.RECORD_CHIRP, "record_chirp");
        this.registerItem(Items.RECORD_FAR, "record_far");
        this.registerItem(Items.RECORD_MALL, "record_mall");
        this.registerItem(Items.RECORD_MELLOHI, "record_mellohi");
        this.registerItem(Items.RECORD_STAL, "record_stal");
        this.registerItem(Items.RECORD_STRAD, "record_strad");
        this.registerItem(Items.RECORD_WARD, "record_ward");
        this.registerItem(Items.RECORD_11, "record_11");
        this.registerItem(Items.RECORD_WAIT, "record_wait");
        this.registerItem(Items.PRISMARINE_SHARD, "prismarine_shard");
        this.registerItem(Items.PRISMARINE_CRYSTALS, "prismarine_crystals");
        this.registerItem(Items.field_192397_db, "knowledge_book");
        this.itemModelMesher.register(Items.ENCHANTED_BOOK, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(final ItemStack llllllllllllllllIlllllIllllIlIll) {
                return new ModelResourceLocation("enchanted_book", "inventory");
            }
        });
        this.itemModelMesher.register(Items.FILLED_MAP, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(final ItemStack lllllllllllllIIIllllllllIIlIIllI) {
                return new ModelResourceLocation("filled_map", "inventory");
            }
        });
        this.registerBlock(Blocks.COMMAND_BLOCK, "command_block");
        this.registerItem(Items.FIREWORKS, "fireworks");
        this.registerItem(Items.COMMAND_BLOCK_MINECART, "command_block_minecart");
        this.registerBlock(Blocks.BARRIER, "barrier");
        this.registerBlock(Blocks.MOB_SPAWNER, "mob_spawner");
        this.registerItem(Items.WRITTEN_BOOK, "written_book");
        this.registerBlock(Blocks.BROWN_MUSHROOM_BLOCK, BlockHugeMushroom.EnumType.ALL_INSIDE.getMetadata(), "brown_mushroom_block");
        this.registerBlock(Blocks.RED_MUSHROOM_BLOCK, BlockHugeMushroom.EnumType.ALL_INSIDE.getMetadata(), "red_mushroom_block");
        this.registerBlock(Blocks.DRAGON_EGG, "dragon_egg");
        this.registerBlock(Blocks.REPEATING_COMMAND_BLOCK, "repeating_command_block");
        this.registerBlock(Blocks.CHAIN_COMMAND_BLOCK, "chain_command_block");
        this.registerBlock(Blocks.STRUCTURE_BLOCK, TileEntityStructure.Mode.SAVE.getModeId(), "structure_block");
        this.registerBlock(Blocks.STRUCTURE_BLOCK, TileEntityStructure.Mode.LOAD.getModeId(), "structure_block");
        this.registerBlock(Blocks.STRUCTURE_BLOCK, TileEntityStructure.Mode.CORNER.getModeId(), "structure_block");
        this.registerBlock(Blocks.STRUCTURE_BLOCK, TileEntityStructure.Mode.DATA.getModeId(), "structure_block");
        if (Reflector.ModelLoader_onRegisterItems.exists()) {
            Reflector.call(Reflector.ModelLoader_onRegisterItems, this.itemModelMesher);
        }
    }
    
    public void renderItemOverlayIntoGUI(final FontRenderer lllllllllllllIIllIIIIllIllllIIIl, final ItemStack lllllllllllllIIllIIIIllIllllIIII, final int lllllllllllllIIllIIIIlllIIIIIlIl, final int lllllllllllllIIllIIIIlllIIIIIlII, @Nullable final String lllllllllllllIIllIIIIlllIIIIIIll) {
        if (!lllllllllllllIIllIIIIllIllllIIII.func_190926_b()) {
            if (lllllllllllllIIllIIIIllIllllIIII.func_190916_E() != 1 || lllllllllllllIIllIIIIlllIIIIIIll != null) {
                final String lllllllllllllIIllIIIIlllIIIIIIlI = (lllllllllllllIIllIIIIlllIIIIIIll == null) ? String.valueOf(lllllllllllllIIllIIIIllIllllIIII.func_190916_E()) : lllllllllllllIIllIIIIlllIIIIIIll;
                GlStateManager.disableLighting();
                GlStateManager.disableDepth();
                GlStateManager.disableBlend();
                lllllllllllllIIllIIIIllIllllIIIl.drawStringWithShadow(lllllllllllllIIllIIIIlllIIIIIIlI, (float)(lllllllllllllIIllIIIIlllIIIIIlIl + 19 - 2 - lllllllllllllIIllIIIIllIllllIIIl.getStringWidth(lllllllllllllIIllIIIIlllIIIIIIlI)), (float)(lllllllllllllIIllIIIIlllIIIIIlII + 6 + 3), 16777215);
                GlStateManager.enableLighting();
                GlStateManager.enableDepth();
                GlStateManager.enableBlend();
            }
            if (ReflectorForge.isItemDamaged(lllllllllllllIIllIIIIllIllllIIII)) {
                GlStateManager.disableLighting();
                GlStateManager.disableDepth();
                GlStateManager.disableTexture2D();
                GlStateManager.disableAlpha();
                GlStateManager.disableBlend();
                final Tessellator lllllllllllllIIllIIIIlllIIIIIIIl = Tessellator.getInstance();
                final BufferBuilder lllllllllllllIIllIIIIlllIIIIIIII = lllllllllllllIIllIIIIlllIIIIIIIl.getBuffer();
                final float lllllllllllllIIllIIIIllIllllllll = (float)lllllllllllllIIllIIIIllIllllIIII.getItemDamage();
                final float lllllllllllllIIllIIIIllIlllllllI = (float)lllllllllllllIIllIIIIllIllllIIII.getMaxDamage();
                final float lllllllllllllIIllIIIIllIllllllIl = Math.max(0.0f, (lllllllllllllIIllIIIIllIlllllllI - lllllllllllllIIllIIIIllIllllllll) / lllllllllllllIIllIIIIllIlllllllI);
                int lllllllllllllIIllIIIIllIllllllII = Math.round(13.0f - lllllllllllllIIllIIIIllIllllllll * 13.0f / lllllllllllllIIllIIIIllIlllllllI);
                int lllllllllllllIIllIIIIllIlllllIll = MathHelper.hsvToRGB(lllllllllllllIIllIIIIllIllllllIl / 3.0f, 1.0f, 1.0f);
                if (Reflector.ForgeItem_getDurabilityForDisplay.exists() && Reflector.ForgeItem_getRGBDurabilityForDisplay.exists()) {
                    final double lllllllllllllIIllIIIIllIlllllIlI = Reflector.callDouble(lllllllllllllIIllIIIIllIllllIIII.getItem(), Reflector.ForgeItem_getDurabilityForDisplay, lllllllllllllIIllIIIIllIllllIIII);
                    final int lllllllllllllIIllIIIIllIlllllIIl = Reflector.callInt(lllllllllllllIIllIIIIllIllllIIII.getItem(), Reflector.ForgeItem_getRGBDurabilityForDisplay, lllllllllllllIIllIIIIllIllllIIII);
                    lllllllllllllIIllIIIIllIllllllII = Math.round(13.0f - (float)lllllllllllllIIllIIIIllIlllllIlI * 13.0f);
                    lllllllllllllIIllIIIIllIlllllIll = lllllllllllllIIllIIIIllIlllllIIl;
                }
                if (Config.isCustomColors()) {
                    lllllllllllllIIllIIIIllIlllllIll = CustomColors.getDurabilityColor(lllllllllllllIIllIIIIllIllllllIl, lllllllllllllIIllIIIIllIlllllIll);
                }
                if (Reflector.ForgeItem_getDurabilityForDisplay.exists() && Reflector.ForgeItem_getRGBDurabilityForDisplay.exists()) {
                    final double lllllllllllllIIllIIIIllIlllllIII = Reflector.callDouble(lllllllllllllIIllIIIIllIllllIIII.getItem(), Reflector.ForgeItem_getDurabilityForDisplay, lllllllllllllIIllIIIIllIllllIIII);
                    final int lllllllllllllIIllIIIIllIllllIlll = Reflector.callInt(lllllllllllllIIllIIIIllIllllIIII.getItem(), Reflector.ForgeItem_getRGBDurabilityForDisplay, lllllllllllllIIllIIIIllIllllIIII);
                    lllllllllllllIIllIIIIllIllllllII = Math.round(13.0f - (float)lllllllllllllIIllIIIIllIlllllIII * 13.0f);
                    lllllllllllllIIllIIIIllIlllllIll = lllllllllllllIIllIIIIllIllllIlll;
                }
                if (Config.isCustomColors()) {
                    lllllllllllllIIllIIIIllIlllllIll = CustomColors.getDurabilityColor(lllllllllllllIIllIIIIllIllllllIl, lllllllllllllIIllIIIIllIlllllIll);
                }
                this.draw(lllllllllllllIIllIIIIlllIIIIIIII, lllllllllllllIIllIIIIlllIIIIIlIl + 2, lllllllllllllIIllIIIIlllIIIIIlII + 13, 13, 2, 0, 0, 0, 255);
                this.draw(lllllllllllllIIllIIIIlllIIIIIIII, lllllllllllllIIllIIIIlllIIIIIlIl + 2, lllllllllllllIIllIIIIlllIIIIIlII + 13, lllllllllllllIIllIIIIllIllllllII, 1, lllllllllllllIIllIIIIllIlllllIll >> 16 & 0xFF, lllllllllllllIIllIIIIllIlllllIll >> 8 & 0xFF, lllllllllllllIIllIIIIllIlllllIll & 0xFF, 255);
                GlStateManager.enableBlend();
                GlStateManager.enableAlpha();
                GlStateManager.enableTexture2D();
                GlStateManager.enableLighting();
                GlStateManager.enableDepth();
            }
            final EntityPlayerSP lllllllllllllIIllIIIIllIllllIllI = Minecraft.getMinecraft().player;
            final float lllllllllllllIIllIIIIllIllllIlIl = (lllllllllllllIIllIIIIllIllllIllI == null) ? 0.0f : lllllllllllllIIllIIIIllIllllIllI.getCooldownTracker().getCooldown(lllllllllllllIIllIIIIllIllllIIII.getItem(), Minecraft.getMinecraft().getRenderPartialTicks());
            if (lllllllllllllIIllIIIIllIllllIlIl > 0.0f) {
                GlStateManager.disableLighting();
                GlStateManager.disableDepth();
                GlStateManager.disableTexture2D();
                final Tessellator lllllllllllllIIllIIIIllIllllIlII = Tessellator.getInstance();
                final BufferBuilder lllllllllllllIIllIIIIllIllllIIll = lllllllllllllIIllIIIIllIllllIlII.getBuffer();
                this.draw(lllllllllllllIIllIIIIllIllllIIll, lllllllllllllIIllIIIIlllIIIIIlIl, lllllllllllllIIllIIIIlllIIIIIlII + MathHelper.floor(16.0f * (1.0f - lllllllllllllIIllIIIIllIllllIlIl)), 16, MathHelper.ceil(16.0f * lllllllllllllIIllIIIIllIllllIlIl), 255, 255, 255, 127);
                GlStateManager.enableTexture2D();
                GlStateManager.enableLighting();
                GlStateManager.enableDepth();
            }
        }
    }
    
    private void setupGuiTransform(final int lllllllllllllIIllIIIIlllIllIIIII, final int lllllllllllllIIllIIIIlllIlIlllll, final boolean lllllllllllllIIllIIIIlllIlIllllI) {
        GlStateManager.translate((float)lllllllllllllIIllIIIIlllIllIIIII, (float)lllllllllllllIIllIIIIlllIlIlllll, 100.0f + this.zLevel);
        GlStateManager.translate(8.0f, 8.0f, 0.0f);
        GlStateManager.scale(1.0f, -1.0f, 1.0f);
        GlStateManager.scale(16.0f, 16.0f, 16.0f);
        if (lllllllllllllIIllIIIIlllIlIllllI) {
            GlStateManager.enableLighting();
        }
        else {
            GlStateManager.disableLighting();
        }
    }
    
    public void renderItemIntoGUI(final ItemStack lllllllllllllIIllIIIIlllIllllIll, final int lllllllllllllIIllIIIIlllIlllIllI, final int lllllllllllllIIllIIIIlllIllllIIl) {
        this.func_191962_a(lllllllllllllIIllIIIIlllIllllIll, lllllllllllllIIllIIIIlllIlllIllI, lllllllllllllIIllIIIIlllIllllIIl, this.getItemModelWithOverrides(lllllllllllllIIllIIIIlllIllllIll, null, null));
    }
    
    private void func_191967_a(final IBakedModel lllllllllllllIIllIIIlIIIIIllIIII, final int lllllllllllllIIllIIIlIIIIIlIllll, final ItemStack lllllllllllllIIllIIIlIIIIIlIlllI) {
        final Tessellator lllllllllllllIIllIIIlIIIIIlIllIl = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIllIIIlIIIIIlIllII = lllllllllllllIIllIIIlIIIIIlIllIl.getBuffer();
        final boolean lllllllllllllIIllIIIlIIIIIlIlIll = Minecraft.getMinecraft().getTextureMapBlocks().isTextureBound();
        final boolean lllllllllllllIIllIIIlIIIIIlIlIlI = Config.isMultiTexture() && lllllllllllllIIllIIIlIIIIIlIlIll;
        if (lllllllllllllIIllIIIlIIIIIlIlIlI) {
            lllllllllllllIIllIIIlIIIIIlIllII.setBlockLayer(BlockRenderLayer.SOLID);
        }
        lllllllllllllIIllIIIlIIIIIlIllII.begin(7, DefaultVertexFormats.ITEM);
        final Exception lllllllllllllIIllIIIlIIIIIIlllIl;
        final boolean lllllllllllllIIllIIIlIIIIIIllllI = ((EnumFacing[])(Object)(lllllllllllllIIllIIIlIIIIIIlllIl = (Exception)(Object)EnumFacing.VALUES)).length != 0;
        for (byte lllllllllllllIIllIIIlIIIIIIlllll = 0; lllllllllllllIIllIIIlIIIIIIlllll < (lllllllllllllIIllIIIlIIIIIIllllI ? 1 : 0); ++lllllllllllllIIllIIIlIIIIIIlllll) {
            final EnumFacing lllllllllllllIIllIIIlIIIIIlIlIIl = lllllllllllllIIllIIIlIIIIIIlllIl[lllllllllllllIIllIIIlIIIIIIlllll];
            this.func_191970_a(lllllllllllllIIllIIIlIIIIIlIllII, lllllllllllllIIllIIIlIIIIIllIIII.getQuads(null, lllllllllllllIIllIIIlIIIIIlIlIIl, 0L), lllllllllllllIIllIIIlIIIIIlIllll, lllllllllllllIIllIIIlIIIIIlIlllI);
        }
        this.func_191970_a(lllllllllllllIIllIIIlIIIIIlIllII, lllllllllllllIIllIIIlIIIIIllIIII.getQuads(null, null, 0L), lllllllllllllIIllIIIlIIIIIlIllll, lllllllllllllIIllIIIlIIIIIlIlllI);
        lllllllllllllIIllIIIlIIIIIlIllIl.draw();
        if (lllllllllllllIIllIIIlIIIIIlIlIlI) {
            lllllllllllllIIllIIIlIIIIIlIllII.setBlockLayer(null);
            GlStateManager.bindCurrentTexture();
        }
    }
    
    private void func_191966_a(final IBakedModel lllllllllllllIIllIIIlIIIIIIIlllI) {
        if ((!Config.isCustomItems() || CustomItems.isUseGlint()) && (!Config.isShaders() || !Shaders.isShadowPass)) {
            GlStateManager.depthMask(false);
            GlStateManager.depthFunc(514);
            GlStateManager.disableLighting();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_COLOR, GlStateManager.DestFactor.ONE);
            this.textureManager.bindTexture(RenderItem.RES_ITEM_GLINT);
            if (Config.isShaders() && !this.renderItemGui) {
                ShadersRender.renderEnchantedGlintBegin();
            }
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(8.0f, 8.0f, 8.0f);
            final float lllllllllllllIIllIIIlIIIIIIIllIl = Minecraft.getSystemTime() % 3000L / 3000.0f / 8.0f;
            GlStateManager.translate(lllllllllllllIIllIIIlIIIIIIIllIl, 0.0f, 0.0f);
            GlStateManager.rotate(-50.0f, 0.0f, 0.0f, 1.0f);
            this.func_191965_a(lllllllllllllIIllIIIlIIIIIIIlllI, -8372020);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(8.0f, 8.0f, 8.0f);
            final float lllllllllllllIIllIIIlIIIIIIIllII = Minecraft.getSystemTime() % 4873L / 4873.0f / 8.0f;
            GlStateManager.translate(-lllllllllllllIIllIIIlIIIIIIIllII, 0.0f, 0.0f);
            GlStateManager.rotate(10.0f, 0.0f, 0.0f, 1.0f);
            this.func_191965_a(lllllllllllllIIllIIIlIIIIIIIlllI, -8372020);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            GlStateManager.enableLighting();
            GlStateManager.depthFunc(515);
            GlStateManager.depthMask(true);
            this.textureManager.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            if (Config.isShaders() && !this.renderItemGui) {
                ShadersRender.renderEnchantedGlintEnd();
            }
        }
    }
    
    public boolean shouldRenderItemIn3D(final ItemStack lllllllllllllIIllIIIIlllllIIllII) {
        final IBakedModel lllllllllllllIIllIIIIlllllIIlllI = this.itemModelMesher.getItemModel(lllllllllllllIIllIIIIlllllIIllII);
        return lllllllllllllIIllIIIIlllllIIlllI != null && lllllllllllllIIllIIIIlllllIIlllI.isGui3d();
    }
    
    public void renderItemAndEffectIntoGUI(final ItemStack lllllllllllllIIllIIIIlllIlIlIIII, final int lllllllllllllIIllIIIIlllIlIlIIll, final int lllllllllllllIIllIIIIlllIlIlIIlI) {
        this.renderItemAndEffectIntoGUI(Minecraft.getMinecraft().player, lllllllllllllIIllIIIIlllIlIlIIII, lllllllllllllIIllIIIIlllIlIlIIll, lllllllllllllIIllIIIIlllIlIlIIlI);
    }
    
    private void func_191961_a(final IBakedModel lllllllllllllIIllIIIlIIIIlIIlIII, final ItemStack lllllllllllllIIllIIIlIIIIlIIIlll) {
        this.func_191967_a(lllllllllllllIIllIIIlIIIIlIIlIII, -1, lllllllllllllIIllIIIlIIIIlIIIlll);
    }
    
    private void registerBlock(final Block lllllllllllllIIllIIIlIIIIlIllIlI, final String lllllllllllllIIllIIIlIIIIlIlllII) {
        this.registerBlock(lllllllllllllIIllIIIlIIIIlIllIlI, 0, lllllllllllllIIllIIIlIIIIlIlllII);
    }
    
    public void renderItem(final ItemStack lllllllllllllIIllIIIIllllIIllIll, final EntityLivingBase lllllllllllllIIllIIIIllllIlIIIII, final ItemCameraTransforms.TransformType lllllllllllllIIllIIIIllllIIllIIl, final boolean lllllllllllllIIllIIIIllllIIllllI) {
        if (!lllllllllllllIIllIIIIllllIIllIll.func_190926_b() && lllllllllllllIIllIIIIllllIlIIIII != null) {
            final IBakedModel lllllllllllllIIllIIIIllllIIlllIl = this.getItemModelWithOverrides(lllllllllllllIIllIIIIllllIIllIll, lllllllllllllIIllIIIIllllIlIIIII.world, lllllllllllllIIllIIIIllllIlIIIII);
            this.renderItemModel(lllllllllllllIIllIIIIllllIIllIll, lllllllllllllIIllIIIIllllIIlllIl, lllllllllllllIIllIIIIllllIIllIIl, lllllllllllllIIllIIIIllllIIllllI);
        }
    }
    
    public IBakedModel getItemModelWithOverrides(final ItemStack lllllllllllllIIllIIIIllllIllIllI, @Nullable final World lllllllllllllIIllIIIIllllIllIlIl, @Nullable final EntityLivingBase lllllllllllllIIllIIIIllllIllIlII) {
        final IBakedModel lllllllllllllIIllIIIIllllIllIIll = this.itemModelMesher.getItemModel(lllllllllllllIIllIIIIllllIllIllI);
        final Item lllllllllllllIIllIIIIllllIllIIlI = lllllllllllllIIllIIIIllllIllIllI.getItem();
        if (Config.isCustomItems()) {
            if (lllllllllllllIIllIIIIllllIllIIlI != null && lllllllllllllIIllIIIIllllIllIIlI.hasCustomProperties()) {
                this.modelLocation = lllllllllllllIIllIIIIllllIllIIll.getOverrides().applyOverride(lllllllllllllIIllIIIIllllIllIllI, lllllllllllllIIllIIIIllllIllIlIl, lllllllllllllIIllIIIIllllIllIlII);
            }
            final IBakedModel lllllllllllllIIllIIIIllllIllIIIl = CustomItems.getCustomItemModel(lllllllllllllIIllIIIIllllIllIllI, lllllllllllllIIllIIIIllllIllIIll, this.modelLocation, true);
            if (lllllllllllllIIllIIIIllllIllIIIl != lllllllllllllIIllIIIIllllIllIIll) {
                return lllllllllllllIIllIIIIllllIllIIIl;
            }
        }
        if (Reflector.ForgeItemOverrideList_handleItemState.exists()) {
            return (IBakedModel)Reflector.call(lllllllllllllIIllIIIIllllIllIIll.getOverrides(), Reflector.ForgeItemOverrideList_handleItemState, lllllllllllllIIllIIIIllllIllIIll, lllllllllllllIIllIIIIllllIllIllI, lllllllllllllIIllIIIIllllIllIlIl, lllllllllllllIIllIIIIllllIllIlII);
        }
        if (lllllllllllllIIllIIIIllllIllIIlI != null && lllllllllllllIIllIIIIllllIllIIlI.hasCustomProperties()) {
            final ResourceLocation lllllllllllllIIllIIIIllllIllIIII = lllllllllllllIIllIIIIllllIllIIll.getOverrides().applyOverride(lllllllllllllIIllIIIIllllIllIllI, lllllllllllllIIllIIIIllllIllIlIl, lllllllllllllIIllIIIIllllIllIlII);
            return (lllllllllllllIIllIIIIllllIllIIII == null) ? lllllllllllllIIllIIIIllllIllIIll : this.itemModelMesher.getModelManager().getModel(new ModelResourceLocation(lllllllllllllIIllIIIIllllIllIIII, "inventory"));
        }
        return lllllllllllllIIllIIIIllllIllIIll;
    }
    
    private void draw(final BufferBuilder lllllllllllllIIllIIIIllIlIlIIlIl, final int lllllllllllllIIllIIIIllIlIlIIlII, final int lllllllllllllIIllIIIIllIlIlIIIll, final int lllllllllllllIIllIIIIllIlIlIIIlI, final int lllllllllllllIIllIIIIllIlIlIIIIl, final int lllllllllllllIIllIIIIllIlIlIIIII, final int lllllllllllllIIllIIIIllIlIIlIllI, final int lllllllllllllIIllIIIIllIlIIllllI, final int lllllllllllllIIllIIIIllIlIIlIlII) {
        lllllllllllllIIllIIIIllIlIlIIlIl.begin(7, DefaultVertexFormats.POSITION_COLOR);
        lllllllllllllIIllIIIIllIlIlIIlIl.pos(lllllllllllllIIllIIIIllIlIlIIlII + 0, lllllllllllllIIllIIIIllIlIlIIIll + 0, 0.0).color(lllllllllllllIIllIIIIllIlIlIIIII, lllllllllllllIIllIIIIllIlIIlIllI, lllllllllllllIIllIIIIllIlIIllllI, lllllllllllllIIllIIIIllIlIIlIlII).endVertex();
        lllllllllllllIIllIIIIllIlIlIIlIl.pos(lllllllllllllIIllIIIIllIlIlIIlII + 0, lllllllllllllIIllIIIIllIlIlIIIll + lllllllllllllIIllIIIIllIlIlIIIIl, 0.0).color(lllllllllllllIIllIIIIllIlIlIIIII, lllllllllllllIIllIIIIllIlIIlIllI, lllllllllllllIIllIIIIllIlIIllllI, lllllllllllllIIllIIIIllIlIIlIlII).endVertex();
        lllllllllllllIIllIIIIllIlIlIIlIl.pos(lllllllllllllIIllIIIIllIlIlIIlII + lllllllllllllIIllIIIIllIlIlIIIlI, lllllllllllllIIllIIIIllIlIlIIIll + lllllllllllllIIllIIIIllIlIlIIIIl, 0.0).color(lllllllllllllIIllIIIIllIlIlIIIII, lllllllllllllIIllIIIIllIlIIlIllI, lllllllllllllIIllIIIIllIlIIllllI, lllllllllllllIIllIIIIllIlIIlIlII).endVertex();
        lllllllllllllIIllIIIIllIlIlIIlIl.pos(lllllllllllllIIllIIIIllIlIlIIlII + lllllllllllllIIllIIIIllIlIlIIIlI, lllllllllllllIIllIIIIllIlIlIIIll + 0, 0.0).color(lllllllllllllIIllIIIIllIlIlIIIII, lllllllllllllIIllIIIIllIlIIlIllI, lllllllllllllIIllIIIIllIlIIllllI, lllllllllllllIIllIIIIllIlIIlIlII).endVertex();
        Tessellator.getInstance().draw();
    }
    
    private void func_191969_a(final BufferBuilder lllllllllllllIIllIIIIlllllllIlII, final BakedQuad lllllllllllllIIllIIIIlllllllIIll, final int lllllllllllllIIllIIIIlllllllIllI) {
        if (lllllllllllllIIllIIIIlllllllIlII.isMultiTexture()) {
            lllllllllllllIIllIIIIlllllllIlII.addVertexData(lllllllllllllIIllIIIIlllllllIIll.getVertexDataSingle());
            lllllllllllllIIllIIIIlllllllIlII.putSprite(lllllllllllllIIllIIIIlllllllIIll.getSprite());
        }
        else {
            lllllllllllllIIllIIIIlllllllIlII.addVertexData(lllllllllllllIIllIIIIlllllllIIll.getVertexData());
        }
        if (Reflector.ForgeHooksClient_putQuadColor.exists()) {
            Reflector.call(Reflector.ForgeHooksClient_putQuadColor, lllllllllllllIIllIIIIlllllllIlII, lllllllllllllIIllIIIIlllllllIIll, lllllllllllllIIllIIIIlllllllIllI);
        }
        else {
            lllllllllllllIIllIIIIlllllllIlII.putColor4(lllllllllllllIIllIIIIlllllllIllI);
        }
        this.putQuadNormal(lllllllllllllIIllIIIIlllllllIlII, lllllllllllllIIllIIIIlllllllIIll);
    }
    
    private void registerItem(final Item lllllllllllllIIllIIIlIIIIlIlIlII, final String lllllllllllllIIllIIIlIIIIlIlIIll) {
        this.registerItem(lllllllllllllIIllIIIlIIIIlIlIlII, 0, lllllllllllllIIllIIIlIIIIlIlIIll);
    }
    
    public RenderItem(final TextureManager lllllllllllllIIllIIIlIIIIlllllll, final ModelManager lllllllllllllIIllIIIlIIIIllllllI, final ItemColors lllllllllllllIIllIIIlIIIlIIIIIIl) {
        this.notRenderingEffectsInGUI = true;
        this.modelLocation = null;
        this.renderItemGui = false;
        this.modelManager = null;
        this.textureManager = lllllllllllllIIllIIIlIIIIlllllll;
        this.modelManager = lllllllllllllIIllIIIlIIIIllllllI;
        if (Reflector.ItemModelMesherForge_Constructor.exists()) {
            this.itemModelMesher = (ItemModelMesher)Reflector.newInstance(Reflector.ItemModelMesherForge_Constructor, lllllllllllllIIllIIIlIIIIllllllI);
        }
        else {
            this.itemModelMesher = new ItemModelMesher(lllllllllllllIIllIIIlIIIIllllllI);
        }
        this.registerItems();
        this.itemColors = lllllllllllllIIllIIIlIIIlIIIIIIl;
    }
    
    public void renderItem(final ItemStack lllllllllllllIIllIIIIlllllIIIIIl, final ItemCameraTransforms.TransformType lllllllllllllIIllIIIIlllllIIIIII) {
        if (!lllllllllllllIIllIIIIlllllIIIIIl.func_190926_b()) {
            final IBakedModel lllllllllllllIIllIIIIlllllIIIIll = this.getItemModelWithOverrides(lllllllllllllIIllIIIIlllllIIIIIl, null, null);
            this.renderItemModel(lllllllllllllIIllIIIIlllllIIIIIl, lllllllllllllIIllIIIIlllllIIIIll, lllllllllllllIIllIIIIlllllIIIIII, false);
        }
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager lllllllllllllIIllIIIIllIlIIIIlIl) {
        this.itemModelMesher.rebuildCache();
    }
    
    public void renderItemAndEffectIntoGUI(@Nullable final EntityLivingBase lllllllllllllIIllIIIIlllIlIIIlII, final ItemStack lllllllllllllIIllIIIIlllIIlllIll, final int lllllllllllllIIllIIIIlllIlIIIIlI, final int lllllllllllllIIllIIIIlllIlIIIIIl) {
        if (!lllllllllllllIIllIIIIlllIIlllIll.func_190926_b()) {
            this.zLevel += 50.0f;
            try {
                this.func_191962_a(lllllllllllllIIllIIIIlllIIlllIll, lllllllllllllIIllIIIIlllIlIIIIlI, lllllllllllllIIllIIIIlllIlIIIIIl, this.getItemModelWithOverrides(lllllllllllllIIllIIIIlllIIlllIll, null, lllllllllllllIIllIIIIlllIlIIIlII));
            }
            catch (Throwable lllllllllllllIIllIIIIlllIlIIIIII) {
                final CrashReport lllllllllllllIIllIIIIlllIIllllll = CrashReport.makeCrashReport(lllllllllllllIIllIIIIlllIlIIIIII, "Rendering item");
                final CrashReportCategory lllllllllllllIIllIIIIlllIIlllllI = lllllllllllllIIllIIIIlllIIllllll.makeCategory("Item being rendered");
                lllllllllllllIIllIIIIlllIIlllllI.setDetail("Item Type", new ICrashReportDetail<String>() {
                    @Override
                    public String call() throws Exception {
                        return String.valueOf(lllllllllllllIIllIIIIlllIIlllIll.getItem());
                    }
                });
                lllllllllllllIIllIIIIlllIIlllllI.setDetail("Item Aux", new ICrashReportDetail<String>() {
                    @Override
                    public String call() throws Exception {
                        return String.valueOf(lllllllllllllIIllIIIIlllIIlllIll.getMetadata());
                    }
                });
                lllllllllllllIIllIIIIlllIIlllllI.setDetail("Item NBT", new ICrashReportDetail<String>() {
                    @Override
                    public String call() throws Exception {
                        return String.valueOf(lllllllllllllIIllIIIIlllIIlllIll.getTagCompound());
                    }
                });
                lllllllllllllIIllIIIIlllIIlllllI.setDetail("Item Foil", new ICrashReportDetail<String>() {
                    @Override
                    public String call() throws Exception {
                        return String.valueOf(lllllllllllllIIllIIIIlllIIlllIll.hasEffect());
                    }
                });
                throw new ReportedException(lllllllllllllIIllIIIIlllIIllllll);
            }
            this.zLevel -= 50.0f;
        }
    }
    
    public void renderItemOverlaysCustom(final MinecraftFontRenderer lllllllllllllIIllIIIIlllIIIllIll, final ItemStack lllllllllllllIIllIIIIlllIIIllIlI, final int lllllllllllllIIllIIIIlllIIIllllI, final int lllllllllllllIIllIIIIlllIIIllIII) {
        this.renderItemOverlayIntoGUI(lllllllllllllIIllIIIIlllIIIllIll, lllllllllllllIIllIIIIlllIIIllIlI, lllllllllllllIIllIIIIlllIIIllllI, lllllllllllllIIllIIIIlllIIIllIII, null);
    }
    
    protected void registerItem(final Item lllllllllllllIIllIIIlIIIIlllIIII, final int lllllllllllllIIllIIIlIIIIllIllll, final String lllllllllllllIIllIIIlIIIIllIlllI) {
        this.itemModelMesher.register(lllllllllllllIIllIIIlIIIIlllIIII, lllllllllllllIIllIIIlIIIIllIllll, new ModelResourceLocation(lllllllllllllIIllIIIlIIIIllIlllI, "inventory"));
    }
    
    public void renderItem(final ItemStack lllllllllllllIIllIIIlIIIIIIlIlIl, IBakedModel lllllllllllllIIllIIIlIIIIIIlIlII) {
        if (!lllllllllllllIIllIIIlIIIIIIlIlIl.func_190926_b()) {
            GlStateManager.pushMatrix();
            GlStateManager.translate(-0.5f, -0.5f, -0.5f);
            if (((IBakedModel)lllllllllllllIIllIIIlIIIIIIlIlII).isBuiltInRenderer()) {
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                GlStateManager.enableRescaleNormal();
                TileEntityItemStackRenderer.instance.renderByItem(lllllllllllllIIllIIIlIIIIIIlIlIl);
            }
            else {
                if (Config.isCustomItems()) {
                    lllllllllllllIIllIIIlIIIIIIlIlII = CustomItems.getCustomItemModel(lllllllllllllIIllIIIlIIIIIIlIlIl, (IBakedModel)lllllllllllllIIllIIIlIIIIIIlIlII, this.modelLocation, false);
                    this.modelLocation = null;
                }
                this.func_191961_a((IBakedModel)lllllllllllllIIllIIIlIIIIIIlIlII, lllllllllllllIIllIIIlIIIIIIlIlIl);
                if (lllllllllllllIIllIIIlIIIIIIlIlIl.hasEffect() && (!Config.isCustomItems() || !CustomItems.renderCustomEffect(this, lllllllllllllIIllIIIlIIIIIIlIlIl, (IBakedModel)lllllllllllllIIllIIIlIIIIIIlIlII))) {
                    this.func_191966_a((IBakedModel)lllllllllllllIIllIIIlIIIIIIlIlII);
                }
            }
            GlStateManager.popMatrix();
        }
    }
    
    private void func_191970_a(final BufferBuilder lllllllllllllIIllIIIIllllllIIllI, final List<BakedQuad> lllllllllllllIIllIIIIllllllIIlIl, final int lllllllllllllIIllIIIIllllllIIlII, final ItemStack lllllllllllllIIllIIIIllllllIIIll) {
        final boolean lllllllllllllIIllIIIIllllllIIIlI = lllllllllllllIIllIIIIllllllIIlII == -1 && !lllllllllllllIIllIIIIllllllIIIll.func_190926_b();
        for (int lllllllllllllIIllIIIIllllllIIIIl = 0, lllllllllllllIIllIIIIllllllIIIII = lllllllllllllIIllIIIIllllllIIlIl.size(); lllllllllllllIIllIIIIllllllIIIIl < lllllllllllllIIllIIIIllllllIIIII; ++lllllllllllllIIllIIIIllllllIIIIl) {
            final BakedQuad lllllllllllllIIllIIIIlllllIlllll = lllllllllllllIIllIIIIllllllIIlIl.get(lllllllllllllIIllIIIIllllllIIIIl);
            int lllllllllllllIIllIIIIlllllIllllI = lllllllllllllIIllIIIIllllllIIlII;
            if (lllllllllllllIIllIIIIllllllIIIlI && lllllllllllllIIllIIIIlllllIlllll.hasTintIndex()) {
                lllllllllllllIIllIIIIlllllIllllI = this.itemColors.getColorFromItemstack(lllllllllllllIIllIIIIllllllIIIll, lllllllllllllIIllIIIIlllllIlllll.getTintIndex());
                if (Config.isCustomColors()) {
                    lllllllllllllIIllIIIIlllllIllllI = CustomColors.getColorFromItemStack(lllllllllllllIIllIIIIllllllIIIll, lllllllllllllIIllIIIIlllllIlllll.getTintIndex(), lllllllllllllIIllIIIIlllllIllllI);
                }
                if (EntityRenderer.anaglyphEnable) {
                    lllllllllllllIIllIIIIlllllIllllI = TextureUtil.anaglyphColor(lllllllllllllIIllIIIIlllllIllllI);
                }
                lllllllllllllIIllIIIIlllllIllllI |= 0xFF000000;
            }
            this.func_191969_a(lllllllllllllIIllIIIIllllllIIllI, lllllllllllllIIllIIIIlllllIlllll, lllllllllllllIIllIIIIlllllIllllI);
        }
    }
    
    public void renderItemOverlayIntoGUI(final MinecraftFontRenderer lllllllllllllIIllIIIIllIllIlIIll, final ItemStack lllllllllllllIIllIIIIllIllIlIIlI, final int lllllllllllllIIllIIIIllIlIlllIll, final int lllllllllllllIIllIIIIllIlIlllIlI, @Nullable final String lllllllllllllIIllIIIIllIlIlllIIl) {
        if (!lllllllllllllIIllIIIIllIllIlIIlI.func_190926_b()) {
            if (lllllllllllllIIllIIIIllIllIlIIlI.func_190916_E() != 1 || lllllllllllllIIllIIIIllIlIlllIIl != null) {
                final String lllllllllllllIIllIIIIllIllIIlllI = (lllllllllllllIIllIIIIllIlIlllIIl == null) ? String.valueOf(lllllllllllllIIllIIIIllIllIlIIlI.func_190916_E()) : lllllllllllllIIllIIIIllIlIlllIIl;
                GlStateManager.disableLighting();
                GlStateManager.disableDepth();
                GlStateManager.disableBlend();
                lllllllllllllIIllIIIIllIllIlIIll.drawStringWithShadow(lllllllllllllIIllIIIIllIllIIlllI, lllllllllllllIIllIIIIllIlIlllIll + 19 - 2 - lllllllllllllIIllIIIIllIllIlIIll.getStringWidth(lllllllllllllIIllIIIIllIllIIlllI), lllllllllllllIIllIIIIllIlIlllIlI + 6 + 3, 16777215);
                GlStateManager.enableLighting();
                GlStateManager.enableDepth();
                GlStateManager.enableBlend();
            }
            if (ReflectorForge.isItemDamaged(lllllllllllllIIllIIIIllIllIlIIlI)) {
                GlStateManager.disableLighting();
                GlStateManager.disableDepth();
                GlStateManager.disableTexture2D();
                GlStateManager.disableAlpha();
                GlStateManager.disableBlend();
                final Tessellator lllllllllllllIIllIIIIllIllIIllIl = Tessellator.getInstance();
                final BufferBuilder lllllllllllllIIllIIIIllIllIIllII = lllllllllllllIIllIIIIllIllIIllIl.getBuffer();
                final float lllllllllllllIIllIIIIllIllIIlIll = (float)lllllllllllllIIllIIIIllIllIlIIlI.getItemDamage();
                final float lllllllllllllIIllIIIIllIllIIlIlI = (float)lllllllllllllIIllIIIIllIllIlIIlI.getMaxDamage();
                final float lllllllllllllIIllIIIIllIllIIlIIl = Math.max(0.0f, (lllllllllllllIIllIIIIllIllIIlIlI - lllllllllllllIIllIIIIllIllIIlIll) / lllllllllllllIIllIIIIllIllIIlIlI);
                int lllllllllllllIIllIIIIllIllIIlIII = Math.round(13.0f - lllllllllllllIIllIIIIllIllIIlIll * 13.0f / lllllllllllllIIllIIIIllIllIIlIlI);
                int lllllllllllllIIllIIIIllIllIIIlll = MathHelper.hsvToRGB(lllllllllllllIIllIIIIllIllIIlIIl / 3.0f, 1.0f, 1.0f);
                if (Reflector.ForgeItem_getDurabilityForDisplay.exists() && Reflector.ForgeItem_getRGBDurabilityForDisplay.exists()) {
                    final double lllllllllllllIIllIIIIllIllIIIllI = Reflector.callDouble(lllllllllllllIIllIIIIllIllIlIIlI.getItem(), Reflector.ForgeItem_getDurabilityForDisplay, lllllllllllllIIllIIIIllIllIlIIlI);
                    final int lllllllllllllIIllIIIIllIllIIIlIl = Reflector.callInt(lllllllllllllIIllIIIIllIllIlIIlI.getItem(), Reflector.ForgeItem_getRGBDurabilityForDisplay, lllllllllllllIIllIIIIllIllIlIIlI);
                    lllllllllllllIIllIIIIllIllIIlIII = Math.round(13.0f - (float)lllllllllllllIIllIIIIllIllIIIllI * 13.0f);
                    lllllllllllllIIllIIIIllIllIIIlll = lllllllllllllIIllIIIIllIllIIIlIl;
                }
                if (Config.isCustomColors()) {
                    lllllllllllllIIllIIIIllIllIIIlll = CustomColors.getDurabilityColor(lllllllllllllIIllIIIIllIllIIlIIl, lllllllllllllIIllIIIIllIllIIIlll);
                }
                if (Reflector.ForgeItem_getDurabilityForDisplay.exists() && Reflector.ForgeItem_getRGBDurabilityForDisplay.exists()) {
                    final double lllllllllllllIIllIIIIllIllIIIlII = Reflector.callDouble(lllllllllllllIIllIIIIllIllIlIIlI.getItem(), Reflector.ForgeItem_getDurabilityForDisplay, lllllllllllllIIllIIIIllIllIlIIlI);
                    final int lllllllllllllIIllIIIIllIllIIIIll = Reflector.callInt(lllllllllllllIIllIIIIllIllIlIIlI.getItem(), Reflector.ForgeItem_getRGBDurabilityForDisplay, lllllllllllllIIllIIIIllIllIlIIlI);
                    lllllllllllllIIllIIIIllIllIIlIII = Math.round(13.0f - (float)lllllllllllllIIllIIIIllIllIIIlII * 13.0f);
                    lllllllllllllIIllIIIIllIllIIIlll = lllllllllllllIIllIIIIllIllIIIIll;
                }
                if (Config.isCustomColors()) {
                    lllllllllllllIIllIIIIllIllIIIlll = CustomColors.getDurabilityColor(lllllllllllllIIllIIIIllIllIIlIIl, lllllllllllllIIllIIIIllIllIIIlll);
                }
                this.draw(lllllllllllllIIllIIIIllIllIIllII, lllllllllllllIIllIIIIllIlIlllIll + 2, lllllllllllllIIllIIIIllIlIlllIlI + 13, 13, 2, 0, 0, 0, 255);
                this.draw(lllllllllllllIIllIIIIllIllIIllII, lllllllllllllIIllIIIIllIlIlllIll + 2, lllllllllllllIIllIIIIllIlIlllIlI + 13, lllllllllllllIIllIIIIllIllIIlIII, 1, lllllllllllllIIllIIIIllIllIIIlll >> 16 & 0xFF, lllllllllllllIIllIIIIllIllIIIlll >> 8 & 0xFF, lllllllllllllIIllIIIIllIllIIIlll & 0xFF, 255);
                GlStateManager.enableBlend();
                GlStateManager.enableAlpha();
                GlStateManager.enableTexture2D();
                GlStateManager.enableLighting();
                GlStateManager.enableDepth();
            }
            final EntityPlayerSP lllllllllllllIIllIIIIllIllIIIIlI = Minecraft.getMinecraft().player;
            final float lllllllllllllIIllIIIIllIllIIIIIl = (lllllllllllllIIllIIIIllIllIIIIlI == null) ? 0.0f : lllllllllllllIIllIIIIllIllIIIIlI.getCooldownTracker().getCooldown(lllllllllllllIIllIIIIllIllIlIIlI.getItem(), Minecraft.getMinecraft().getRenderPartialTicks());
            if (lllllllllllllIIllIIIIllIllIIIIIl > 0.0f) {
                GlStateManager.disableLighting();
                GlStateManager.disableDepth();
                GlStateManager.disableTexture2D();
                final Tessellator lllllllllllllIIllIIIIllIllIIIIII = Tessellator.getInstance();
                final BufferBuilder lllllllllllllIIllIIIIllIlIllllll = lllllllllllllIIllIIIIllIllIIIIII.getBuffer();
                this.draw(lllllllllllllIIllIIIIllIlIllllll, lllllllllllllIIllIIIIllIlIlllIll, lllllllllllllIIllIIIIllIlIlllIlI + MathHelper.floor(16.0f * (1.0f - lllllllllllllIIllIIIIllIllIIIIIl)), 16, MathHelper.ceil(16.0f * lllllllllllllIIllIIIIllIllIIIIIl), 255, 255, 255, 127);
                GlStateManager.enableTexture2D();
                GlStateManager.enableLighting();
                GlStateManager.enableDepth();
            }
        }
    }
    
    protected void renderItemModel(final ItemStack lllllllllllllIIllIIIIllllIIIllll, IBakedModel lllllllllllllIIllIIIIllllIIIlIII, final ItemCameraTransforms.TransformType lllllllllllllIIllIIIIllllIIIIlll, final boolean lllllllllllllIIllIIIIllllIIIIllI) {
        if (!lllllllllllllIIllIIIIllllIIIllll.func_190926_b()) {
            this.textureManager.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            this.textureManager.getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).setBlurMipmap(false, false);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.enableRescaleNormal();
            GlStateManager.alphaFunc(516, 0.1f);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.pushMatrix();
            if (Reflector.ForgeHooksClient_handleCameraTransforms.exists()) {
                lllllllllllllIIllIIIIllllIIIlIII = Reflector.call(Reflector.ForgeHooksClient_handleCameraTransforms, lllllllllllllIIllIIIIllllIIIlIII, lllllllllllllIIllIIIIllllIIIIlll, lllllllllllllIIllIIIIllllIIIIllI);
            }
            else {
                final ItemCameraTransforms lllllllllllllIIllIIIIllllIIIlIll = ((IBakedModel)lllllllllllllIIllIIIIllllIIIlIII).getItemCameraTransforms();
                ItemCameraTransforms.applyTransformSide(lllllllllllllIIllIIIIllllIIIlIll.getTransform(lllllllllllllIIllIIIIllllIIIIlll), lllllllllllllIIllIIIIllllIIIIllI);
                if (this.isThereOneNegativeScale(lllllllllllllIIllIIIIllllIIIlIll.getTransform(lllllllllllllIIllIIIIllllIIIIlll))) {
                    GlStateManager.cullFace(GlStateManager.CullFace.FRONT);
                }
            }
            CustomItems.setRenderOffHand(lllllllllllllIIllIIIIllllIIIIllI);
            this.renderItem(lllllllllllllIIllIIIIllllIIIllll, (IBakedModel)lllllllllllllIIllIIIIllllIIIlIII);
            CustomItems.setRenderOffHand(false);
            GlStateManager.cullFace(GlStateManager.CullFace.BACK);
            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
            GlStateManager.disableBlend();
            this.textureManager.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            this.textureManager.getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).restoreLastBlurMipmap();
        }
    }
    
    public void func_191965_a(final IBakedModel lllllllllllllIIllIIIlIIIIlIIIIlI, final int lllllllllllllIIllIIIlIIIIIlllllI) {
        this.func_191967_a(lllllllllllllIIllIIIlIIIIlIIIIlI, lllllllllllllIIllIIIlIIIIIlllllI, ItemStack.field_190927_a);
    }
    
    private void putQuadNormal(final BufferBuilder lllllllllllllIIllIIIlIIIIIIIIIll, final BakedQuad lllllllllllllIIllIIIIlllllllllll) {
        final Vec3i lllllllllllllIIllIIIlIIIIIIIIIIl = lllllllllllllIIllIIIIlllllllllll.getFace().getDirectionVec();
        lllllllllllllIIllIIIlIIIIIIIIIll.putNormal((float)lllllllllllllIIllIIIlIIIIIIIIIIl.getX(), (float)lllllllllllllIIllIIIlIIIIIIIIIIl.getY(), (float)lllllllllllllIIllIIIlIIIIIIIIIIl.getZ());
    }
    
    protected void func_191962_a(final ItemStack lllllllllllllIIllIIIIlllIllIlllI, final int lllllllllllllIIllIIIIlllIllIlIII, final int lllllllllllllIIllIIIIlllIllIllII, IBakedModel lllllllllllllIIllIIIIlllIllIIllI) {
        this.renderItemGui = true;
        GlStateManager.pushMatrix();
        this.textureManager.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        this.textureManager.getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).setBlurMipmap(false, false);
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(516, 0.1f);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.setupGuiTransform(lllllllllllllIIllIIIIlllIllIlIII, lllllllllllllIIllIIIIlllIllIllII, ((IBakedModel)lllllllllllllIIllIIIIlllIllIIllI).isGui3d());
        if (Reflector.ForgeHooksClient_handleCameraTransforms.exists()) {
            lllllllllllllIIllIIIIlllIllIIllI = Reflector.call(Reflector.ForgeHooksClient_handleCameraTransforms, lllllllllllllIIllIIIIlllIllIIllI, ItemCameraTransforms.TransformType.GUI, false);
        }
        else {
            ((IBakedModel)lllllllllllllIIllIIIIlllIllIIllI).getItemCameraTransforms().applyTransform(ItemCameraTransforms.TransformType.GUI);
        }
        this.renderItem(lllllllllllllIIllIIIIlllIllIlllI, (IBakedModel)lllllllllllllIIllIIIIlllIllIIllI);
        GlStateManager.disableAlpha();
        GlStateManager.disableRescaleNormal();
        GlStateManager.disableLighting();
        GlStateManager.popMatrix();
        this.textureManager.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        this.textureManager.getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).restoreLastBlurMipmap();
        this.renderItemGui = false;
    }
    
    public void renderItemOverlays(final FontRenderer lllllllllllllIIllIIIIlllIIlIlIlI, final ItemStack lllllllllllllIIllIIIIlllIIlIlllI, final int lllllllllllllIIllIIIIlllIIlIlIII, final int lllllllllllllIIllIIIIlllIIlIIlll) {
        this.renderItemOverlayIntoGUI(lllllllllllllIIllIIIIlllIIlIlIlI, lllllllllllllIIllIIIIlllIIlIlllI, lllllllllllllIIllIIIIlllIIlIlIII, lllllllllllllIIllIIIIlllIIlIIlll, null);
    }
    
    private boolean isThereOneNegativeScale(final ItemTransformVec3f lllllllllllllIIllIIIIllllIIIIIlI) {
        return lllllllllllllIIllIIIIllllIIIIIlI.scale.x < 0.0f ^ lllllllllllllIIllIIIIllllIIIIIlI.scale.y < 0.0f ^ lllllllllllllIIllIIIIllllIIIIIlI.scale.z < 0.0f;
    }
}
