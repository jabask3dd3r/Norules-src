package net.minecraft.init;

import java.util.*;
import net.minecraft.block.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import javax.annotation.*;

public class Blocks
{
    private static final /* synthetic */ Set<Block> CACHE;
    
    static {
        if (!Bootstrap.isRegistered()) {
            throw new RuntimeException("Accessed Blocks before Bootstrap!");
        }
        CACHE = Sets.newHashSet();
        AIR = getRegisteredBlock("air");
        STONE = getRegisteredBlock("stone");
        GRASS = (BlockGrass)getRegisteredBlock("grass");
        DIRT = getRegisteredBlock("dirt");
        COBBLESTONE = getRegisteredBlock("cobblestone");
        PLANKS = getRegisteredBlock("planks");
        SAPLING = getRegisteredBlock("sapling");
        BEDROCK = getRegisteredBlock("bedrock");
        FLOWING_WATER = (BlockDynamicLiquid)getRegisteredBlock("flowing_water");
        WATER = (BlockStaticLiquid)getRegisteredBlock("water");
        FLOWING_LAVA = (BlockDynamicLiquid)getRegisteredBlock("flowing_lava");
        LAVA = (BlockStaticLiquid)getRegisteredBlock("lava");
        SAND = (BlockSand)getRegisteredBlock("sand");
        GRAVEL = getRegisteredBlock("gravel");
        GOLD_ORE = getRegisteredBlock("gold_ore");
        IRON_ORE = getRegisteredBlock("iron_ore");
        COAL_ORE = getRegisteredBlock("coal_ore");
        LOG = getRegisteredBlock("log");
        LOG2 = getRegisteredBlock("log2");
        LEAVES = (BlockLeaves)getRegisteredBlock("leaves");
        LEAVES2 = (BlockLeaves)getRegisteredBlock("leaves2");
        SPONGE = getRegisteredBlock("sponge");
        GLASS = getRegisteredBlock("glass");
        LAPIS_ORE = getRegisteredBlock("lapis_ore");
        LAPIS_BLOCK = getRegisteredBlock("lapis_block");
        DISPENSER = getRegisteredBlock("dispenser");
        SANDSTONE = getRegisteredBlock("sandstone");
        NOTEBLOCK = getRegisteredBlock("noteblock");
        BED = getRegisteredBlock("bed");
        GOLDEN_RAIL = getRegisteredBlock("golden_rail");
        DETECTOR_RAIL = getRegisteredBlock("detector_rail");
        STICKY_PISTON = (BlockPistonBase)getRegisteredBlock("sticky_piston");
        WEB = getRegisteredBlock("web");
        TALLGRASS = (BlockTallGrass)getRegisteredBlock("tallgrass");
        DEADBUSH = (BlockDeadBush)getRegisteredBlock("deadbush");
        PISTON = (BlockPistonBase)getRegisteredBlock("piston");
        PISTON_HEAD = (BlockPistonExtension)getRegisteredBlock("piston_head");
        WOOL = getRegisteredBlock("wool");
        PISTON_EXTENSION = (BlockPistonMoving)getRegisteredBlock("piston_extension");
        YELLOW_FLOWER = (BlockFlower)getRegisteredBlock("yellow_flower");
        RED_FLOWER = (BlockFlower)getRegisteredBlock("red_flower");
        BROWN_MUSHROOM = (BlockBush)getRegisteredBlock("brown_mushroom");
        RED_MUSHROOM = (BlockBush)getRegisteredBlock("red_mushroom");
        GOLD_BLOCK = getRegisteredBlock("gold_block");
        IRON_BLOCK = getRegisteredBlock("iron_block");
        DOUBLE_STONE_SLAB = (BlockSlab)getRegisteredBlock("double_stone_slab");
        STONE_SLAB = (BlockSlab)getRegisteredBlock("stone_slab");
        BRICK_BLOCK = getRegisteredBlock("brick_block");
        TNT = getRegisteredBlock("tnt");
        BOOKSHELF = getRegisteredBlock("bookshelf");
        MOSSY_COBBLESTONE = getRegisteredBlock("mossy_cobblestone");
        OBSIDIAN = getRegisteredBlock("obsidian");
        TORCH = getRegisteredBlock("torch");
        FIRE = (BlockFire)getRegisteredBlock("fire");
        MOB_SPAWNER = getRegisteredBlock("mob_spawner");
        OAK_STAIRS = getRegisteredBlock("oak_stairs");
        CHEST = (BlockChest)getRegisteredBlock("chest");
        REDSTONE_WIRE = (BlockRedstoneWire)getRegisteredBlock("redstone_wire");
        DIAMOND_ORE = getRegisteredBlock("diamond_ore");
        DIAMOND_BLOCK = getRegisteredBlock("diamond_block");
        CRAFTING_TABLE = getRegisteredBlock("crafting_table");
        WHEAT = getRegisteredBlock("wheat");
        FARMLAND = getRegisteredBlock("farmland");
        FURNACE = getRegisteredBlock("furnace");
        LIT_FURNACE = getRegisteredBlock("lit_furnace");
        STANDING_SIGN = getRegisteredBlock("standing_sign");
        OAK_DOOR = (BlockDoor)getRegisteredBlock("wooden_door");
        SPRUCE_DOOR = (BlockDoor)getRegisteredBlock("spruce_door");
        BIRCH_DOOR = (BlockDoor)getRegisteredBlock("birch_door");
        JUNGLE_DOOR = (BlockDoor)getRegisteredBlock("jungle_door");
        ACACIA_DOOR = (BlockDoor)getRegisteredBlock("acacia_door");
        DARK_OAK_DOOR = (BlockDoor)getRegisteredBlock("dark_oak_door");
        LADDER = getRegisteredBlock("ladder");
        RAIL = getRegisteredBlock("rail");
        STONE_STAIRS = getRegisteredBlock("stone_stairs");
        WALL_SIGN = getRegisteredBlock("wall_sign");
        LEVER = getRegisteredBlock("lever");
        STONE_PRESSURE_PLATE = getRegisteredBlock("stone_pressure_plate");
        IRON_DOOR = (BlockDoor)getRegisteredBlock("iron_door");
        WOODEN_PRESSURE_PLATE = getRegisteredBlock("wooden_pressure_plate");
        REDSTONE_ORE = getRegisteredBlock("redstone_ore");
        LIT_REDSTONE_ORE = getRegisteredBlock("lit_redstone_ore");
        UNLIT_REDSTONE_TORCH = getRegisteredBlock("unlit_redstone_torch");
        REDSTONE_TORCH = getRegisteredBlock("redstone_torch");
        STONE_BUTTON = getRegisteredBlock("stone_button");
        SNOW_LAYER = getRegisteredBlock("snow_layer");
        ICE = getRegisteredBlock("ice");
        SNOW = getRegisteredBlock("snow");
        CACTUS = (BlockCactus)getRegisteredBlock("cactus");
        CLAY = getRegisteredBlock("clay");
        REEDS = (BlockReed)getRegisteredBlock("reeds");
        JUKEBOX = getRegisteredBlock("jukebox");
        OAK_FENCE = getRegisteredBlock("fence");
        SPRUCE_FENCE = getRegisteredBlock("spruce_fence");
        BIRCH_FENCE = getRegisteredBlock("birch_fence");
        JUNGLE_FENCE = getRegisteredBlock("jungle_fence");
        DARK_OAK_FENCE = getRegisteredBlock("dark_oak_fence");
        ACACIA_FENCE = getRegisteredBlock("acacia_fence");
        PUMPKIN = getRegisteredBlock("pumpkin");
        NETHERRACK = getRegisteredBlock("netherrack");
        SOUL_SAND = getRegisteredBlock("soul_sand");
        GLOWSTONE = getRegisteredBlock("glowstone");
        PORTAL = (BlockPortal)getRegisteredBlock("portal");
        LIT_PUMPKIN = getRegisteredBlock("lit_pumpkin");
        CAKE = getRegisteredBlock("cake");
        UNPOWERED_REPEATER = (BlockRedstoneRepeater)getRegisteredBlock("unpowered_repeater");
        POWERED_REPEATER = (BlockRedstoneRepeater)getRegisteredBlock("powered_repeater");
        TRAPDOOR = getRegisteredBlock("trapdoor");
        MONSTER_EGG = getRegisteredBlock("monster_egg");
        STONEBRICK = getRegisteredBlock("stonebrick");
        BROWN_MUSHROOM_BLOCK = getRegisteredBlock("brown_mushroom_block");
        RED_MUSHROOM_BLOCK = getRegisteredBlock("red_mushroom_block");
        IRON_BARS = getRegisteredBlock("iron_bars");
        GLASS_PANE = getRegisteredBlock("glass_pane");
        MELON_BLOCK = getRegisteredBlock("melon_block");
        PUMPKIN_STEM = getRegisteredBlock("pumpkin_stem");
        MELON_STEM = getRegisteredBlock("melon_stem");
        VINE = getRegisteredBlock("vine");
        OAK_FENCE_GATE = getRegisteredBlock("fence_gate");
        SPRUCE_FENCE_GATE = getRegisteredBlock("spruce_fence_gate");
        BIRCH_FENCE_GATE = getRegisteredBlock("birch_fence_gate");
        JUNGLE_FENCE_GATE = getRegisteredBlock("jungle_fence_gate");
        DARK_OAK_FENCE_GATE = getRegisteredBlock("dark_oak_fence_gate");
        ACACIA_FENCE_GATE = getRegisteredBlock("acacia_fence_gate");
        BRICK_STAIRS = getRegisteredBlock("brick_stairs");
        STONE_BRICK_STAIRS = getRegisteredBlock("stone_brick_stairs");
        MYCELIUM = (BlockMycelium)getRegisteredBlock("mycelium");
        WATERLILY = getRegisteredBlock("waterlily");
        NETHER_BRICK = getRegisteredBlock("nether_brick");
        NETHER_BRICK_FENCE = getRegisteredBlock("nether_brick_fence");
        NETHER_BRICK_STAIRS = getRegisteredBlock("nether_brick_stairs");
        NETHER_WART = getRegisteredBlock("nether_wart");
        ENCHANTING_TABLE = getRegisteredBlock("enchanting_table");
        BREWING_STAND = getRegisteredBlock("brewing_stand");
        CAULDRON = (BlockCauldron)getRegisteredBlock("cauldron");
        END_PORTAL = getRegisteredBlock("end_portal");
        END_PORTAL_FRAME = getRegisteredBlock("end_portal_frame");
        END_STONE = getRegisteredBlock("end_stone");
        DRAGON_EGG = getRegisteredBlock("dragon_egg");
        REDSTONE_LAMP = getRegisteredBlock("redstone_lamp");
        LIT_REDSTONE_LAMP = getRegisteredBlock("lit_redstone_lamp");
        DOUBLE_WOODEN_SLAB = (BlockSlab)getRegisteredBlock("double_wooden_slab");
        WOODEN_SLAB = (BlockSlab)getRegisteredBlock("wooden_slab");
        COCOA = getRegisteredBlock("cocoa");
        SANDSTONE_STAIRS = getRegisteredBlock("sandstone_stairs");
        EMERALD_ORE = getRegisteredBlock("emerald_ore");
        ENDER_CHEST = getRegisteredBlock("ender_chest");
        TRIPWIRE_HOOK = (BlockTripWireHook)getRegisteredBlock("tripwire_hook");
        TRIPWIRE = getRegisteredBlock("tripwire");
        EMERALD_BLOCK = getRegisteredBlock("emerald_block");
        SPRUCE_STAIRS = getRegisteredBlock("spruce_stairs");
        BIRCH_STAIRS = getRegisteredBlock("birch_stairs");
        JUNGLE_STAIRS = getRegisteredBlock("jungle_stairs");
        COMMAND_BLOCK = getRegisteredBlock("command_block");
        BEACON = (BlockBeacon)getRegisteredBlock("beacon");
        COBBLESTONE_WALL = getRegisteredBlock("cobblestone_wall");
        FLOWER_POT = getRegisteredBlock("flower_pot");
        CARROTS = getRegisteredBlock("carrots");
        POTATOES = getRegisteredBlock("potatoes");
        WOODEN_BUTTON = getRegisteredBlock("wooden_button");
        SKULL = (BlockSkull)getRegisteredBlock("skull");
        ANVIL = getRegisteredBlock("anvil");
        TRAPPED_CHEST = getRegisteredBlock("trapped_chest");
        LIGHT_WEIGHTED_PRESSURE_PLATE = getRegisteredBlock("light_weighted_pressure_plate");
        HEAVY_WEIGHTED_PRESSURE_PLATE = getRegisteredBlock("heavy_weighted_pressure_plate");
        UNPOWERED_COMPARATOR = (BlockRedstoneComparator)getRegisteredBlock("unpowered_comparator");
        POWERED_COMPARATOR = (BlockRedstoneComparator)getRegisteredBlock("powered_comparator");
        DAYLIGHT_DETECTOR = (BlockDaylightDetector)getRegisteredBlock("daylight_detector");
        DAYLIGHT_DETECTOR_INVERTED = (BlockDaylightDetector)getRegisteredBlock("daylight_detector_inverted");
        REDSTONE_BLOCK = getRegisteredBlock("redstone_block");
        QUARTZ_ORE = getRegisteredBlock("quartz_ore");
        HOPPER = (BlockHopper)getRegisteredBlock("hopper");
        QUARTZ_BLOCK = getRegisteredBlock("quartz_block");
        QUARTZ_STAIRS = getRegisteredBlock("quartz_stairs");
        ACTIVATOR_RAIL = getRegisteredBlock("activator_rail");
        DROPPER = getRegisteredBlock("dropper");
        STAINED_HARDENED_CLAY = getRegisteredBlock("stained_hardened_clay");
        BARRIER = getRegisteredBlock("barrier");
        IRON_TRAPDOOR = getRegisteredBlock("iron_trapdoor");
        HAY_BLOCK = getRegisteredBlock("hay_block");
        CARPET = getRegisteredBlock("carpet");
        HARDENED_CLAY = getRegisteredBlock("hardened_clay");
        COAL_BLOCK = getRegisteredBlock("coal_block");
        PACKED_ICE = getRegisteredBlock("packed_ice");
        ACACIA_STAIRS = getRegisteredBlock("acacia_stairs");
        DARK_OAK_STAIRS = getRegisteredBlock("dark_oak_stairs");
        SLIME_BLOCK = getRegisteredBlock("slime");
        DOUBLE_PLANT = (BlockDoublePlant)getRegisteredBlock("double_plant");
        STAINED_GLASS = (BlockStainedGlass)getRegisteredBlock("stained_glass");
        STAINED_GLASS_PANE = (BlockStainedGlassPane)getRegisteredBlock("stained_glass_pane");
        PRISMARINE = getRegisteredBlock("prismarine");
        SEA_LANTERN = getRegisteredBlock("sea_lantern");
        STANDING_BANNER = getRegisteredBlock("standing_banner");
        WALL_BANNER = getRegisteredBlock("wall_banner");
        RED_SANDSTONE = getRegisteredBlock("red_sandstone");
        RED_SANDSTONE_STAIRS = getRegisteredBlock("red_sandstone_stairs");
        DOUBLE_STONE_SLAB2 = (BlockSlab)getRegisteredBlock("double_stone_slab2");
        STONE_SLAB2 = (BlockSlab)getRegisteredBlock("stone_slab2");
        END_ROD = getRegisteredBlock("end_rod");
        CHORUS_PLANT = getRegisteredBlock("chorus_plant");
        CHORUS_FLOWER = getRegisteredBlock("chorus_flower");
        PURPUR_BLOCK = getRegisteredBlock("purpur_block");
        PURPUR_PILLAR = getRegisteredBlock("purpur_pillar");
        PURPUR_STAIRS = getRegisteredBlock("purpur_stairs");
        PURPUR_DOUBLE_SLAB = (BlockSlab)getRegisteredBlock("purpur_double_slab");
        PURPUR_SLAB = (BlockSlab)getRegisteredBlock("purpur_slab");
        END_BRICKS = getRegisteredBlock("end_bricks");
        BEETROOTS = getRegisteredBlock("beetroots");
        GRASS_PATH = getRegisteredBlock("grass_path");
        END_GATEWAY = getRegisteredBlock("end_gateway");
        REPEATING_COMMAND_BLOCK = getRegisteredBlock("repeating_command_block");
        CHAIN_COMMAND_BLOCK = getRegisteredBlock("chain_command_block");
        FROSTED_ICE = getRegisteredBlock("frosted_ice");
        MAGMA = getRegisteredBlock("magma");
        NETHER_WART_BLOCK = getRegisteredBlock("nether_wart_block");
        RED_NETHER_BRICK = getRegisteredBlock("red_nether_brick");
        BONE_BLOCK = getRegisteredBlock("bone_block");
        STRUCTURE_VOID = getRegisteredBlock("structure_void");
        field_190976_dk = getRegisteredBlock("observer");
        field_190977_dl = getRegisteredBlock("white_shulker_box");
        field_190978_dm = getRegisteredBlock("orange_shulker_box");
        field_190979_dn = getRegisteredBlock("magenta_shulker_box");
        field_190980_do = getRegisteredBlock("light_blue_shulker_box");
        field_190981_dp = getRegisteredBlock("yellow_shulker_box");
        field_190982_dq = getRegisteredBlock("lime_shulker_box");
        field_190983_dr = getRegisteredBlock("pink_shulker_box");
        field_190984_ds = getRegisteredBlock("gray_shulker_box");
        field_190985_dt = getRegisteredBlock("silver_shulker_box");
        field_190986_du = getRegisteredBlock("cyan_shulker_box");
        field_190987_dv = getRegisteredBlock("purple_shulker_box");
        field_190988_dw = getRegisteredBlock("blue_shulker_box");
        field_190989_dx = getRegisteredBlock("brown_shulker_box");
        field_190990_dy = getRegisteredBlock("green_shulker_box");
        field_190991_dz = getRegisteredBlock("red_shulker_box");
        field_190975_dA = getRegisteredBlock("black_shulker_box");
        field_192427_dB = getRegisteredBlock("white_glazed_terracotta");
        field_192428_dC = getRegisteredBlock("orange_glazed_terracotta");
        field_192429_dD = getRegisteredBlock("magenta_glazed_terracotta");
        field_192430_dE = getRegisteredBlock("light_blue_glazed_terracotta");
        field_192431_dF = getRegisteredBlock("yellow_glazed_terracotta");
        field_192432_dG = getRegisteredBlock("lime_glazed_terracotta");
        field_192433_dH = getRegisteredBlock("pink_glazed_terracotta");
        field_192434_dI = getRegisteredBlock("gray_glazed_terracotta");
        field_192435_dJ = getRegisteredBlock("silver_glazed_terracotta");
        field_192436_dK = getRegisteredBlock("cyan_glazed_terracotta");
        field_192437_dL = getRegisteredBlock("purple_glazed_terracotta");
        field_192438_dM = getRegisteredBlock("blue_glazed_terracotta");
        field_192439_dN = getRegisteredBlock("brown_glazed_terracotta");
        field_192440_dO = getRegisteredBlock("green_glazed_terracotta");
        field_192441_dP = getRegisteredBlock("red_glazed_terracotta");
        field_192442_dQ = getRegisteredBlock("black_glazed_terracotta");
        field_192443_dR = getRegisteredBlock("concrete");
        field_192444_dS = getRegisteredBlock("concrete_powder");
        STRUCTURE_BLOCK = getRegisteredBlock("structure_block");
        Blocks.CACHE.clear();
    }
    
    @Nullable
    private static Block getRegisteredBlock(final String lllllllllllllIllllIIIIIIlIIIllll) {
        final Block lllllllllllllIllllIIIIIIlIIlIIII = Block.REGISTRY.getObject(new ResourceLocation(lllllllllllllIllllIIIIIIlIIIllll));
        if (!Blocks.CACHE.add(lllllllllllllIllllIIIIIIlIIlIIII)) {
            throw new IllegalStateException(String.valueOf(new StringBuilder("Invalid Block requested: ").append(lllllllllllllIllllIIIIIIlIIIllll)));
        }
        return lllllllllllllIllllIIIIIIlIIlIIII;
    }
}
