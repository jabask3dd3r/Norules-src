package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import javax.annotation.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.registry.*;
import net.minecraft.block.*;
import net.minecraft.inventory.*;
import net.minecraft.potion.*;
import net.minecraft.entity.item.*;
import net.minecraft.block.state.*;
import net.minecraft.util.text.translation.*;
import java.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.ai.attributes.*;
import com.google.common.collect.*;
import net.minecraft.init.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.nbt.*;

public class Item
{
    private static final /* synthetic */ IItemPropertyGetter DAMAGED_GETTER;
    protected /* synthetic */ boolean bFull3D;
    private static final /* synthetic */ IItemPropertyGetter DAMAGE_GETTER;
    private /* synthetic */ CreativeTabs tabToDisplayOn;
    protected static /* synthetic */ Random itemRand;
    private static final /* synthetic */ IItemPropertyGetter COOLDOWN_GETTER;
    public static final /* synthetic */ RegistryNamespaced<ResourceLocation, Item> REGISTRY;
    protected /* synthetic */ boolean hasSubtypes;
    private /* synthetic */ int maxDamage;
    private /* synthetic */ String unlocalizedName;
    private static final /* synthetic */ Map<Block, Item> BLOCK_TO_ITEM;
    private /* synthetic */ Item containerItem;
    private static final /* synthetic */ IItemPropertyGetter LEFTHANDED_GETTER;
    private final /* synthetic */ IRegistry<ResourceLocation, IItemPropertyGetter> properties;
    protected /* synthetic */ int maxStackSize;
    
    public Item setCreativeTab(final CreativeTabs llIIIIIlllIlll) {
        this.tabToDisplayOn = llIIIIIlllIlll;
        return this;
    }
    
    public boolean isMap() {
        return false;
    }
    
    static {
        REGISTRY = new RegistryNamespaced<ResourceLocation, Item>();
        BLOCK_TO_ITEM = Maps.newHashMap();
        DAMAGED_GETTER = new IItemPropertyGetter() {
            @Override
            public float apply(final ItemStack lllllllllllllIIIlIIIIIllIllIIIlI, @Nullable final World lllllllllllllIIIlIIIIIllIllIIIIl, @Nullable final EntityLivingBase lllllllllllllIIIlIIIIIllIllIIIII) {
                return lllllllllllllIIIlIIIIIllIllIIIlI.isItemDamaged() ? 1.0f : 0.0f;
            }
        };
        DAMAGE_GETTER = new IItemPropertyGetter() {
            @Override
            public float apply(final ItemStack lllllllllllllIllIllIllIlIlIIIIII, @Nullable final World lllllllllllllIllIllIllIlIIllllll, @Nullable final EntityLivingBase lllllllllllllIllIllIllIlIIlllllI) {
                return MathHelper.clamp(lllllllllllllIllIllIllIlIlIIIIII.getItemDamage() / (float)lllllllllllllIllIllIllIlIlIIIIII.getMaxDamage(), 0.0f, 1.0f);
            }
        };
        LEFTHANDED_GETTER = new IItemPropertyGetter() {
            @Override
            public float apply(final ItemStack lllllllllllllIllIllIlllIllIlIlll, @Nullable final World lllllllllllllIllIllIlllIllIlIllI, @Nullable final EntityLivingBase lllllllllllllIllIllIlllIllIlIlII) {
                return (lllllllllllllIllIllIlllIllIlIlII != null && lllllllllllllIllIllIlllIllIlIlII.getPrimaryHand() != EnumHandSide.RIGHT) ? 1.0f : 0.0f;
            }
        };
        COOLDOWN_GETTER = new IItemPropertyGetter() {
            @Override
            public float apply(final ItemStack lllllllllllllIlIIlIllllIlIlIllll, @Nullable final World lllllllllllllIlIIlIllllIlIllIIIl, @Nullable final EntityLivingBase lllllllllllllIlIIlIllllIlIllIIII) {
                return (lllllllllllllIlIIlIllllIlIllIIII instanceof EntityPlayer) ? ((EntityPlayer)lllllllllllllIlIIlIllllIlIllIIII).getCooldownTracker().getCooldown(lllllllllllllIlIIlIllllIlIlIllll.getItem(), 0.0f) : 0.0f;
            }
        };
        ATTACK_DAMAGE_MODIFIER = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
        ATTACK_SPEED_MODIFIER = UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3");
        Item.itemRand = new Random();
    }
    
    public Item() {
        this.properties = new RegistrySimple<ResourceLocation, IItemPropertyGetter>();
        this.maxStackSize = 64;
        this.addPropertyOverride(new ResourceLocation("lefthanded"), Item.LEFTHANDED_GETTER);
        this.addPropertyOverride(new ResourceLocation("cooldown"), Item.COOLDOWN_GETTER);
    }
    
    public EnumRarity getRarity(final ItemStack llIIIIllIIlIIl) {
        return llIIIIllIIlIIl.isItemEnchanted() ? EnumRarity.RARE : EnumRarity.COMMON;
    }
    
    public boolean getIsRepairable(final ItemStack llIIIIIlllIIlI, final ItemStack llIIIIIlllIIIl) {
        return false;
    }
    
    public int getMaxDamage() {
        return this.maxDamage;
    }
    
    public void onPlayerStoppedUsing(final ItemStack llIIIIllIlllll, final World llIIIIllIllllI, final EntityLivingBase llIIIIllIlllIl, final int llIIIIllIlllII) {
    }
    
    public static void registerItems() {
        registerItemBlock(Blocks.AIR, new ItemAir(Blocks.AIR));
        registerItemBlock(Blocks.STONE, new ItemMultiTexture(Blocks.STONE, Blocks.STONE, new ItemMultiTexture.Mapper() {
            @Override
            public String apply(final ItemStack lllllllllllllIIlllIIIIIllIIlIlIl) {
                return BlockStone.EnumType.byMetadata(lllllllllllllIIlllIIIIIllIIlIlIl.getMetadata()).getUnlocalizedName();
            }
        }).setUnlocalizedName("stone"));
        registerItemBlock(Blocks.GRASS, new ItemColored(Blocks.GRASS, false));
        registerItemBlock(Blocks.DIRT, new ItemMultiTexture(Blocks.DIRT, Blocks.DIRT, new ItemMultiTexture.Mapper() {
            @Override
            public String apply(final ItemStack lllllllllllllllIlllllIIllIllllII) {
                return BlockDirt.DirtType.byMetadata(lllllllllllllllIlllllIIllIllllII.getMetadata()).getUnlocalizedName();
            }
        }).setUnlocalizedName("dirt"));
        registerItemBlock(Blocks.COBBLESTONE);
        registerItemBlock(Blocks.PLANKS, new ItemMultiTexture(Blocks.PLANKS, Blocks.PLANKS, new ItemMultiTexture.Mapper() {
            @Override
            public String apply(final ItemStack llllllllllllllIIIlIIlllIIlIlIllI) {
                return BlockPlanks.EnumType.byMetadata(llllllllllllllIIIlIIlllIIlIlIllI.getMetadata()).getUnlocalizedName();
            }
        }).setUnlocalizedName("wood"));
        registerItemBlock(Blocks.SAPLING, new ItemMultiTexture(Blocks.SAPLING, Blocks.SAPLING, new ItemMultiTexture.Mapper() {
            @Override
            public String apply(final ItemStack lIllIIIIIlllI) {
                return BlockPlanks.EnumType.byMetadata(lIllIIIIIlllI.getMetadata()).getUnlocalizedName();
            }
        }).setUnlocalizedName("sapling"));
        registerItemBlock(Blocks.BEDROCK);
        registerItemBlock(Blocks.SAND, new ItemMultiTexture(Blocks.SAND, Blocks.SAND, new ItemMultiTexture.Mapper() {
            @Override
            public String apply(final ItemStack lllllllllllllIIIlIlIIllIIlIIIIlI) {
                return BlockSand.EnumType.byMetadata(lllllllllllllIIIlIlIIllIIlIIIIlI.getMetadata()).getUnlocalizedName();
            }
        }).setUnlocalizedName("sand"));
        registerItemBlock(Blocks.GRAVEL);
        registerItemBlock(Blocks.GOLD_ORE);
        registerItemBlock(Blocks.IRON_ORE);
        registerItemBlock(Blocks.COAL_ORE);
        registerItemBlock(Blocks.LOG, new ItemMultiTexture(Blocks.LOG, Blocks.LOG, new ItemMultiTexture.Mapper() {
            @Override
            public String apply(final ItemStack lllllllllllllIlllllIllllllIIlIlI) {
                return BlockPlanks.EnumType.byMetadata(lllllllllllllIlllllIllllllIIlIlI.getMetadata()).getUnlocalizedName();
            }
        }).setUnlocalizedName("log"));
        registerItemBlock(Blocks.LOG2, new ItemMultiTexture(Blocks.LOG2, Blocks.LOG2, new ItemMultiTexture.Mapper() {
            @Override
            public String apply(final ItemStack lllllllllllllIIllllIIIIIlIIllIIl) {
                return BlockPlanks.EnumType.byMetadata(lllllllllllllIIllllIIIIIlIIllIIl.getMetadata() + 4).getUnlocalizedName();
            }
        }).setUnlocalizedName("log"));
        registerItemBlock(Blocks.LEAVES, new ItemLeaves(Blocks.LEAVES).setUnlocalizedName("leaves"));
        registerItemBlock(Blocks.LEAVES2, new ItemLeaves(Blocks.LEAVES2).setUnlocalizedName("leaves"));
        registerItemBlock(Blocks.SPONGE, new ItemMultiTexture(Blocks.SPONGE, Blocks.SPONGE, new ItemMultiTexture.Mapper() {
            @Override
            public String apply(final ItemStack llllllllllllIlllllIlIlIIIIIIllll) {
                return ((llllllllllllIlllllIlIlIIIIIIllll.getMetadata() & 0x1) == 0x1) ? "wet" : "dry";
            }
        }).setUnlocalizedName("sponge"));
        registerItemBlock(Blocks.GLASS);
        registerItemBlock(Blocks.LAPIS_ORE);
        registerItemBlock(Blocks.LAPIS_BLOCK);
        registerItemBlock(Blocks.DISPENSER);
        registerItemBlock(Blocks.SANDSTONE, new ItemMultiTexture(Blocks.SANDSTONE, Blocks.SANDSTONE, new ItemMultiTexture.Mapper() {
            @Override
            public String apply(final ItemStack lllllllllllllllIIIlllIIlIlIllllI) {
                return BlockSandStone.EnumType.byMetadata(lllllllllllllllIIIlllIIlIlIllllI.getMetadata()).getUnlocalizedName();
            }
        }).setUnlocalizedName("sandStone"));
        registerItemBlock(Blocks.NOTEBLOCK);
        registerItemBlock(Blocks.GOLDEN_RAIL);
        registerItemBlock(Blocks.DETECTOR_RAIL);
        registerItemBlock(Blocks.STICKY_PISTON, new ItemPiston(Blocks.STICKY_PISTON));
        registerItemBlock(Blocks.WEB);
        registerItemBlock(Blocks.TALLGRASS, new ItemColored(Blocks.TALLGRASS, true).setSubtypeNames(new String[] { "shrub", "grass", "fern" }));
        registerItemBlock(Blocks.DEADBUSH);
        registerItemBlock(Blocks.PISTON, new ItemPiston(Blocks.PISTON));
        registerItemBlock(Blocks.WOOL, new ItemCloth(Blocks.WOOL).setUnlocalizedName("cloth"));
        registerItemBlock(Blocks.YELLOW_FLOWER, new ItemMultiTexture(Blocks.YELLOW_FLOWER, Blocks.YELLOW_FLOWER, new ItemMultiTexture.Mapper() {
            @Override
            public String apply(final ItemStack llllllllllllllIIIIIllIIIIIIlIlII) {
                return BlockFlower.EnumFlowerType.getType(BlockFlower.EnumFlowerColor.YELLOW, llllllllllllllIIIIIllIIIIIIlIlII.getMetadata()).getUnlocalizedName();
            }
        }).setUnlocalizedName("flower"));
        registerItemBlock(Blocks.RED_FLOWER, new ItemMultiTexture(Blocks.RED_FLOWER, Blocks.RED_FLOWER, new ItemMultiTexture.Mapper() {
            @Override
            public String apply(final ItemStack llllllllllllllllIlIIlllllIlIIlll) {
                return BlockFlower.EnumFlowerType.getType(BlockFlower.EnumFlowerColor.RED, llllllllllllllllIlIIlllllIlIIlll.getMetadata()).getUnlocalizedName();
            }
        }).setUnlocalizedName("rose"));
        registerItemBlock(Blocks.BROWN_MUSHROOM);
        registerItemBlock(Blocks.RED_MUSHROOM);
        registerItemBlock(Blocks.GOLD_BLOCK);
        registerItemBlock(Blocks.IRON_BLOCK);
        registerItemBlock(Blocks.STONE_SLAB, new ItemSlab(Blocks.STONE_SLAB, Blocks.STONE_SLAB, Blocks.DOUBLE_STONE_SLAB).setUnlocalizedName("stoneSlab"));
        registerItemBlock(Blocks.BRICK_BLOCK);
        registerItemBlock(Blocks.TNT);
        registerItemBlock(Blocks.BOOKSHELF);
        registerItemBlock(Blocks.MOSSY_COBBLESTONE);
        registerItemBlock(Blocks.OBSIDIAN);
        registerItemBlock(Blocks.TORCH);
        registerItemBlock(Blocks.END_ROD);
        registerItemBlock(Blocks.CHORUS_PLANT);
        registerItemBlock(Blocks.CHORUS_FLOWER);
        registerItemBlock(Blocks.PURPUR_BLOCK);
        registerItemBlock(Blocks.PURPUR_PILLAR);
        registerItemBlock(Blocks.PURPUR_STAIRS);
        registerItemBlock(Blocks.PURPUR_SLAB, new ItemSlab(Blocks.PURPUR_SLAB, Blocks.PURPUR_SLAB, Blocks.PURPUR_DOUBLE_SLAB).setUnlocalizedName("purpurSlab"));
        registerItemBlock(Blocks.MOB_SPAWNER);
        registerItemBlock(Blocks.OAK_STAIRS);
        registerItemBlock(Blocks.CHEST);
        registerItemBlock(Blocks.DIAMOND_ORE);
        registerItemBlock(Blocks.DIAMOND_BLOCK);
        registerItemBlock(Blocks.CRAFTING_TABLE);
        registerItemBlock(Blocks.FARMLAND);
        registerItemBlock(Blocks.FURNACE);
        registerItemBlock(Blocks.LADDER);
        registerItemBlock(Blocks.RAIL);
        registerItemBlock(Blocks.STONE_STAIRS);
        registerItemBlock(Blocks.LEVER);
        registerItemBlock(Blocks.STONE_PRESSURE_PLATE);
        registerItemBlock(Blocks.WOODEN_PRESSURE_PLATE);
        registerItemBlock(Blocks.REDSTONE_ORE);
        registerItemBlock(Blocks.REDSTONE_TORCH);
        registerItemBlock(Blocks.STONE_BUTTON);
        registerItemBlock(Blocks.SNOW_LAYER, new ItemSnow(Blocks.SNOW_LAYER));
        registerItemBlock(Blocks.ICE);
        registerItemBlock(Blocks.SNOW);
        registerItemBlock(Blocks.CACTUS);
        registerItemBlock(Blocks.CLAY);
        registerItemBlock(Blocks.JUKEBOX);
        registerItemBlock(Blocks.OAK_FENCE);
        registerItemBlock(Blocks.SPRUCE_FENCE);
        registerItemBlock(Blocks.BIRCH_FENCE);
        registerItemBlock(Blocks.JUNGLE_FENCE);
        registerItemBlock(Blocks.DARK_OAK_FENCE);
        registerItemBlock(Blocks.ACACIA_FENCE);
        registerItemBlock(Blocks.PUMPKIN);
        registerItemBlock(Blocks.NETHERRACK);
        registerItemBlock(Blocks.SOUL_SAND);
        registerItemBlock(Blocks.GLOWSTONE);
        registerItemBlock(Blocks.LIT_PUMPKIN);
        registerItemBlock(Blocks.TRAPDOOR);
        registerItemBlock(Blocks.MONSTER_EGG, new ItemMultiTexture(Blocks.MONSTER_EGG, Blocks.MONSTER_EGG, new ItemMultiTexture.Mapper() {
            @Override
            public String apply(final ItemStack llllllllllllIllllllIlIIIIIIIllIl) {
                return BlockSilverfish.EnumType.byMetadata(llllllllllllIllllllIlIIIIIIIllIl.getMetadata()).getUnlocalizedName();
            }
        }).setUnlocalizedName("monsterStoneEgg"));
        registerItemBlock(Blocks.STONEBRICK, new ItemMultiTexture(Blocks.STONEBRICK, Blocks.STONEBRICK, new ItemMultiTexture.Mapper() {
            @Override
            public String apply(final ItemStack lllllllllllllIlIIIlIllIIllIlIIII) {
                return BlockStoneBrick.EnumType.byMetadata(lllllllllllllIlIIIlIllIIllIlIIII.getMetadata()).getUnlocalizedName();
            }
        }).setUnlocalizedName("stonebricksmooth"));
        registerItemBlock(Blocks.BROWN_MUSHROOM_BLOCK);
        registerItemBlock(Blocks.RED_MUSHROOM_BLOCK);
        registerItemBlock(Blocks.IRON_BARS);
        registerItemBlock(Blocks.GLASS_PANE);
        registerItemBlock(Blocks.MELON_BLOCK);
        registerItemBlock(Blocks.VINE, new ItemColored(Blocks.VINE, false));
        registerItemBlock(Blocks.OAK_FENCE_GATE);
        registerItemBlock(Blocks.SPRUCE_FENCE_GATE);
        registerItemBlock(Blocks.BIRCH_FENCE_GATE);
        registerItemBlock(Blocks.JUNGLE_FENCE_GATE);
        registerItemBlock(Blocks.DARK_OAK_FENCE_GATE);
        registerItemBlock(Blocks.ACACIA_FENCE_GATE);
        registerItemBlock(Blocks.BRICK_STAIRS);
        registerItemBlock(Blocks.STONE_BRICK_STAIRS);
        registerItemBlock(Blocks.MYCELIUM);
        registerItemBlock(Blocks.WATERLILY, new ItemLilyPad(Blocks.WATERLILY));
        registerItemBlock(Blocks.NETHER_BRICK);
        registerItemBlock(Blocks.NETHER_BRICK_FENCE);
        registerItemBlock(Blocks.NETHER_BRICK_STAIRS);
        registerItemBlock(Blocks.ENCHANTING_TABLE);
        registerItemBlock(Blocks.END_PORTAL_FRAME);
        registerItemBlock(Blocks.END_STONE);
        registerItemBlock(Blocks.END_BRICKS);
        registerItemBlock(Blocks.DRAGON_EGG);
        registerItemBlock(Blocks.REDSTONE_LAMP);
        registerItemBlock(Blocks.WOODEN_SLAB, new ItemSlab(Blocks.WOODEN_SLAB, Blocks.WOODEN_SLAB, Blocks.DOUBLE_WOODEN_SLAB).setUnlocalizedName("woodSlab"));
        registerItemBlock(Blocks.SANDSTONE_STAIRS);
        registerItemBlock(Blocks.EMERALD_ORE);
        registerItemBlock(Blocks.ENDER_CHEST);
        registerItemBlock(Blocks.TRIPWIRE_HOOK);
        registerItemBlock(Blocks.EMERALD_BLOCK);
        registerItemBlock(Blocks.SPRUCE_STAIRS);
        registerItemBlock(Blocks.BIRCH_STAIRS);
        registerItemBlock(Blocks.JUNGLE_STAIRS);
        registerItemBlock(Blocks.COMMAND_BLOCK);
        registerItemBlock(Blocks.BEACON);
        registerItemBlock(Blocks.COBBLESTONE_WALL, new ItemMultiTexture(Blocks.COBBLESTONE_WALL, Blocks.COBBLESTONE_WALL, new ItemMultiTexture.Mapper() {
            @Override
            public String apply(final ItemStack llllllllllllllIIIlIIIIIlIlllllll) {
                return BlockWall.EnumType.byMetadata(llllllllllllllIIIlIIIIIlIlllllll.getMetadata()).getUnlocalizedName();
            }
        }).setUnlocalizedName("cobbleWall"));
        registerItemBlock(Blocks.WOODEN_BUTTON);
        registerItemBlock(Blocks.ANVIL, new ItemAnvilBlock(Blocks.ANVIL).setUnlocalizedName("anvil"));
        registerItemBlock(Blocks.TRAPPED_CHEST);
        registerItemBlock(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE);
        registerItemBlock(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
        registerItemBlock(Blocks.DAYLIGHT_DETECTOR);
        registerItemBlock(Blocks.REDSTONE_BLOCK);
        registerItemBlock(Blocks.QUARTZ_ORE);
        registerItemBlock(Blocks.HOPPER);
        registerItemBlock(Blocks.QUARTZ_BLOCK, new ItemMultiTexture(Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BLOCK, new String[] { "default", "chiseled", "lines" }).setUnlocalizedName("quartzBlock"));
        registerItemBlock(Blocks.QUARTZ_STAIRS);
        registerItemBlock(Blocks.ACTIVATOR_RAIL);
        registerItemBlock(Blocks.DROPPER);
        registerItemBlock(Blocks.STAINED_HARDENED_CLAY, new ItemCloth(Blocks.STAINED_HARDENED_CLAY).setUnlocalizedName("clayHardenedStained"));
        registerItemBlock(Blocks.BARRIER);
        registerItemBlock(Blocks.IRON_TRAPDOOR);
        registerItemBlock(Blocks.HAY_BLOCK);
        registerItemBlock(Blocks.CARPET, new ItemCloth(Blocks.CARPET).setUnlocalizedName("woolCarpet"));
        registerItemBlock(Blocks.HARDENED_CLAY);
        registerItemBlock(Blocks.COAL_BLOCK);
        registerItemBlock(Blocks.PACKED_ICE);
        registerItemBlock(Blocks.ACACIA_STAIRS);
        registerItemBlock(Blocks.DARK_OAK_STAIRS);
        registerItemBlock(Blocks.SLIME_BLOCK);
        registerItemBlock(Blocks.GRASS_PATH);
        registerItemBlock(Blocks.DOUBLE_PLANT, new ItemMultiTexture(Blocks.DOUBLE_PLANT, Blocks.DOUBLE_PLANT, new ItemMultiTexture.Mapper() {
            @Override
            public String apply(final ItemStack lllllllllllllIlllIllllIIIllIlIll) {
                return BlockDoublePlant.EnumPlantType.byMetadata(lllllllllllllIlllIllllIIIllIlIll.getMetadata()).getUnlocalizedName();
            }
        }).setUnlocalizedName("doublePlant"));
        registerItemBlock(Blocks.STAINED_GLASS, new ItemCloth(Blocks.STAINED_GLASS).setUnlocalizedName("stainedGlass"));
        registerItemBlock(Blocks.STAINED_GLASS_PANE, new ItemCloth(Blocks.STAINED_GLASS_PANE).setUnlocalizedName("stainedGlassPane"));
        registerItemBlock(Blocks.PRISMARINE, new ItemMultiTexture(Blocks.PRISMARINE, Blocks.PRISMARINE, new ItemMultiTexture.Mapper() {
            @Override
            public String apply(final ItemStack lllllllllllllIIlIllIllIIllIIllll) {
                return BlockPrismarine.EnumType.byMetadata(lllllllllllllIIlIllIllIIllIIllll.getMetadata()).getUnlocalizedName();
            }
        }).setUnlocalizedName("prismarine"));
        registerItemBlock(Blocks.SEA_LANTERN);
        registerItemBlock(Blocks.RED_SANDSTONE, new ItemMultiTexture(Blocks.RED_SANDSTONE, Blocks.RED_SANDSTONE, new ItemMultiTexture.Mapper() {
            @Override
            public String apply(final ItemStack llllllllllllllIlIllIlIllllIIlIIl) {
                return BlockRedSandstone.EnumType.byMetadata(llllllllllllllIlIllIlIllllIIlIIl.getMetadata()).getUnlocalizedName();
            }
        }).setUnlocalizedName("redSandStone"));
        registerItemBlock(Blocks.RED_SANDSTONE_STAIRS);
        registerItemBlock(Blocks.STONE_SLAB2, new ItemSlab(Blocks.STONE_SLAB2, Blocks.STONE_SLAB2, Blocks.DOUBLE_STONE_SLAB2).setUnlocalizedName("stoneSlab2"));
        registerItemBlock(Blocks.REPEATING_COMMAND_BLOCK);
        registerItemBlock(Blocks.CHAIN_COMMAND_BLOCK);
        registerItemBlock(Blocks.MAGMA);
        registerItemBlock(Blocks.NETHER_WART_BLOCK);
        registerItemBlock(Blocks.RED_NETHER_BRICK);
        registerItemBlock(Blocks.BONE_BLOCK);
        registerItemBlock(Blocks.STRUCTURE_VOID);
        registerItemBlock(Blocks.field_190976_dk);
        registerItemBlock(Blocks.field_190977_dl, new ItemShulkerBox(Blocks.field_190977_dl));
        registerItemBlock(Blocks.field_190978_dm, new ItemShulkerBox(Blocks.field_190978_dm));
        registerItemBlock(Blocks.field_190979_dn, new ItemShulkerBox(Blocks.field_190979_dn));
        registerItemBlock(Blocks.field_190980_do, new ItemShulkerBox(Blocks.field_190980_do));
        registerItemBlock(Blocks.field_190981_dp, new ItemShulkerBox(Blocks.field_190981_dp));
        registerItemBlock(Blocks.field_190982_dq, new ItemShulkerBox(Blocks.field_190982_dq));
        registerItemBlock(Blocks.field_190983_dr, new ItemShulkerBox(Blocks.field_190983_dr));
        registerItemBlock(Blocks.field_190984_ds, new ItemShulkerBox(Blocks.field_190984_ds));
        registerItemBlock(Blocks.field_190985_dt, new ItemShulkerBox(Blocks.field_190985_dt));
        registerItemBlock(Blocks.field_190986_du, new ItemShulkerBox(Blocks.field_190986_du));
        registerItemBlock(Blocks.field_190987_dv, new ItemShulkerBox(Blocks.field_190987_dv));
        registerItemBlock(Blocks.field_190988_dw, new ItemShulkerBox(Blocks.field_190988_dw));
        registerItemBlock(Blocks.field_190989_dx, new ItemShulkerBox(Blocks.field_190989_dx));
        registerItemBlock(Blocks.field_190990_dy, new ItemShulkerBox(Blocks.field_190990_dy));
        registerItemBlock(Blocks.field_190991_dz, new ItemShulkerBox(Blocks.field_190991_dz));
        registerItemBlock(Blocks.field_190975_dA, new ItemShulkerBox(Blocks.field_190975_dA));
        registerItemBlock(Blocks.field_192427_dB);
        registerItemBlock(Blocks.field_192428_dC);
        registerItemBlock(Blocks.field_192429_dD);
        registerItemBlock(Blocks.field_192430_dE);
        registerItemBlock(Blocks.field_192431_dF);
        registerItemBlock(Blocks.field_192432_dG);
        registerItemBlock(Blocks.field_192433_dH);
        registerItemBlock(Blocks.field_192434_dI);
        registerItemBlock(Blocks.field_192435_dJ);
        registerItemBlock(Blocks.field_192436_dK);
        registerItemBlock(Blocks.field_192437_dL);
        registerItemBlock(Blocks.field_192438_dM);
        registerItemBlock(Blocks.field_192439_dN);
        registerItemBlock(Blocks.field_192440_dO);
        registerItemBlock(Blocks.field_192441_dP);
        registerItemBlock(Blocks.field_192442_dQ);
        registerItemBlock(Blocks.field_192443_dR, new ItemCloth(Blocks.field_192443_dR).setUnlocalizedName("concrete"));
        registerItemBlock(Blocks.field_192444_dS, new ItemCloth(Blocks.field_192444_dS).setUnlocalizedName("concrete_powder"));
        registerItemBlock(Blocks.STRUCTURE_BLOCK);
        registerItem(256, "iron_shovel", new ItemSpade(ToolMaterial.IRON).setUnlocalizedName("shovelIron"));
        registerItem(257, "iron_pickaxe", new ItemPickaxe(ToolMaterial.IRON).setUnlocalizedName("pickaxeIron"));
        registerItem(258, "iron_axe", new ItemAxe(ToolMaterial.IRON).setUnlocalizedName("hatchetIron"));
        registerItem(259, "flint_and_steel", new ItemFlintAndSteel().setUnlocalizedName("flintAndSteel"));
        registerItem(260, "apple", new ItemFood(4, 0.3f, false).setUnlocalizedName("apple"));
        registerItem(261, "bow", new ItemBow().setUnlocalizedName("bow"));
        registerItem(262, "arrow", new ItemArrow().setUnlocalizedName("arrow"));
        registerItem(263, "coal", new ItemCoal().setUnlocalizedName("coal"));
        registerItem(264, "diamond", new Item().setUnlocalizedName("diamond").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(265, "iron_ingot", new Item().setUnlocalizedName("ingotIron").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(266, "gold_ingot", new Item().setUnlocalizedName("ingotGold").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(267, "iron_sword", new ItemSword(ToolMaterial.IRON).setUnlocalizedName("swordIron"));
        registerItem(268, "wooden_sword", new ItemSword(ToolMaterial.WOOD).setUnlocalizedName("swordWood"));
        registerItem(269, "wooden_shovel", new ItemSpade(ToolMaterial.WOOD).setUnlocalizedName("shovelWood"));
        registerItem(270, "wooden_pickaxe", new ItemPickaxe(ToolMaterial.WOOD).setUnlocalizedName("pickaxeWood"));
        registerItem(271, "wooden_axe", new ItemAxe(ToolMaterial.WOOD).setUnlocalizedName("hatchetWood"));
        registerItem(272, "stone_sword", new ItemSword(ToolMaterial.STONE).setUnlocalizedName("swordStone"));
        registerItem(273, "stone_shovel", new ItemSpade(ToolMaterial.STONE).setUnlocalizedName("shovelStone"));
        registerItem(274, "stone_pickaxe", new ItemPickaxe(ToolMaterial.STONE).setUnlocalizedName("pickaxeStone"));
        registerItem(275, "stone_axe", new ItemAxe(ToolMaterial.STONE).setUnlocalizedName("hatchetStone"));
        registerItem(276, "diamond_sword", new ItemSword(ToolMaterial.DIAMOND).setUnlocalizedName("swordDiamond"));
        registerItem(277, "diamond_shovel", new ItemSpade(ToolMaterial.DIAMOND).setUnlocalizedName("shovelDiamond"));
        registerItem(278, "diamond_pickaxe", new ItemPickaxe(ToolMaterial.DIAMOND).setUnlocalizedName("pickaxeDiamond"));
        registerItem(279, "diamond_axe", new ItemAxe(ToolMaterial.DIAMOND).setUnlocalizedName("hatchetDiamond"));
        registerItem(280, "stick", new Item().setFull3D().setUnlocalizedName("stick").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(281, "bowl", new Item().setUnlocalizedName("bowl").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(282, "mushroom_stew", new ItemSoup(6).setUnlocalizedName("mushroomStew"));
        registerItem(283, "golden_sword", new ItemSword(ToolMaterial.GOLD).setUnlocalizedName("swordGold"));
        registerItem(284, "golden_shovel", new ItemSpade(ToolMaterial.GOLD).setUnlocalizedName("shovelGold"));
        registerItem(285, "golden_pickaxe", new ItemPickaxe(ToolMaterial.GOLD).setUnlocalizedName("pickaxeGold"));
        registerItem(286, "golden_axe", new ItemAxe(ToolMaterial.GOLD).setUnlocalizedName("hatchetGold"));
        registerItem(287, "string", new ItemBlockSpecial(Blocks.TRIPWIRE).setUnlocalizedName("string").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(288, "feather", new Item().setUnlocalizedName("feather").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(289, "gunpowder", new Item().setUnlocalizedName("sulphur").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(290, "wooden_hoe", new ItemHoe(ToolMaterial.WOOD).setUnlocalizedName("hoeWood"));
        registerItem(291, "stone_hoe", new ItemHoe(ToolMaterial.STONE).setUnlocalizedName("hoeStone"));
        registerItem(292, "iron_hoe", new ItemHoe(ToolMaterial.IRON).setUnlocalizedName("hoeIron"));
        registerItem(293, "diamond_hoe", new ItemHoe(ToolMaterial.DIAMOND).setUnlocalizedName("hoeDiamond"));
        registerItem(294, "golden_hoe", new ItemHoe(ToolMaterial.GOLD).setUnlocalizedName("hoeGold"));
        registerItem(295, "wheat_seeds", new ItemSeeds(Blocks.WHEAT, Blocks.FARMLAND).setUnlocalizedName("seeds"));
        registerItem(296, "wheat", new Item().setUnlocalizedName("wheat").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(297, "bread", new ItemFood(5, 0.6f, false).setUnlocalizedName("bread"));
        registerItem(298, "leather_helmet", new ItemArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("helmetCloth"));
        registerItem(299, "leather_chestplate", new ItemArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("chestplateCloth"));
        registerItem(300, "leather_leggings", new ItemArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("leggingsCloth"));
        registerItem(301, "leather_boots", new ItemArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("bootsCloth"));
        registerItem(302, "chainmail_helmet", new ItemArmor(ItemArmor.ArmorMaterial.CHAIN, 1, EntityEquipmentSlot.HEAD).setUnlocalizedName("helmetChain"));
        registerItem(303, "chainmail_chestplate", new ItemArmor(ItemArmor.ArmorMaterial.CHAIN, 1, EntityEquipmentSlot.CHEST).setUnlocalizedName("chestplateChain"));
        registerItem(304, "chainmail_leggings", new ItemArmor(ItemArmor.ArmorMaterial.CHAIN, 1, EntityEquipmentSlot.LEGS).setUnlocalizedName("leggingsChain"));
        registerItem(305, "chainmail_boots", new ItemArmor(ItemArmor.ArmorMaterial.CHAIN, 1, EntityEquipmentSlot.FEET).setUnlocalizedName("bootsChain"));
        registerItem(306, "iron_helmet", new ItemArmor(ItemArmor.ArmorMaterial.IRON, 2, EntityEquipmentSlot.HEAD).setUnlocalizedName("helmetIron"));
        registerItem(307, "iron_chestplate", new ItemArmor(ItemArmor.ArmorMaterial.IRON, 2, EntityEquipmentSlot.CHEST).setUnlocalizedName("chestplateIron"));
        registerItem(308, "iron_leggings", new ItemArmor(ItemArmor.ArmorMaterial.IRON, 2, EntityEquipmentSlot.LEGS).setUnlocalizedName("leggingsIron"));
        registerItem(309, "iron_boots", new ItemArmor(ItemArmor.ArmorMaterial.IRON, 2, EntityEquipmentSlot.FEET).setUnlocalizedName("bootsIron"));
        registerItem(310, "diamond_helmet", new ItemArmor(ItemArmor.ArmorMaterial.DIAMOND, 3, EntityEquipmentSlot.HEAD).setUnlocalizedName("helmetDiamond"));
        registerItem(311, "diamond_chestplate", new ItemArmor(ItemArmor.ArmorMaterial.DIAMOND, 3, EntityEquipmentSlot.CHEST).setUnlocalizedName("chestplateDiamond"));
        registerItem(312, "diamond_leggings", new ItemArmor(ItemArmor.ArmorMaterial.DIAMOND, 3, EntityEquipmentSlot.LEGS).setUnlocalizedName("leggingsDiamond"));
        registerItem(313, "diamond_boots", new ItemArmor(ItemArmor.ArmorMaterial.DIAMOND, 3, EntityEquipmentSlot.FEET).setUnlocalizedName("bootsDiamond"));
        registerItem(314, "golden_helmet", new ItemArmor(ItemArmor.ArmorMaterial.GOLD, 4, EntityEquipmentSlot.HEAD).setUnlocalizedName("helmetGold"));
        registerItem(315, "golden_chestplate", new ItemArmor(ItemArmor.ArmorMaterial.GOLD, 4, EntityEquipmentSlot.CHEST).setUnlocalizedName("chestplateGold"));
        registerItem(316, "golden_leggings", new ItemArmor(ItemArmor.ArmorMaterial.GOLD, 4, EntityEquipmentSlot.LEGS).setUnlocalizedName("leggingsGold"));
        registerItem(317, "golden_boots", new ItemArmor(ItemArmor.ArmorMaterial.GOLD, 4, EntityEquipmentSlot.FEET).setUnlocalizedName("bootsGold"));
        registerItem(318, "flint", new Item().setUnlocalizedName("flint").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(319, "porkchop", new ItemFood(3, 0.3f, true).setUnlocalizedName("porkchopRaw"));
        registerItem(320, "cooked_porkchop", new ItemFood(8, 0.8f, true).setUnlocalizedName("porkchopCooked"));
        registerItem(321, "painting", new ItemHangingEntity(EntityPainting.class).setUnlocalizedName("painting"));
        registerItem(322, "golden_apple", new ItemAppleGold(4, 1.2f, false).setAlwaysEdible().setUnlocalizedName("appleGold"));
        registerItem(323, "sign", new ItemSign().setUnlocalizedName("sign"));
        registerItem(324, "wooden_door", new ItemDoor(Blocks.OAK_DOOR).setUnlocalizedName("doorOak"));
        final Item llIIIIIllIllII = new ItemBucket(Blocks.AIR).setUnlocalizedName("bucket").setMaxStackSize(16);
        registerItem(325, "bucket", llIIIIIllIllII);
        registerItem(326, "water_bucket", new ItemBucket(Blocks.FLOWING_WATER).setUnlocalizedName("bucketWater").setContainerItem(llIIIIIllIllII));
        registerItem(327, "lava_bucket", new ItemBucket(Blocks.FLOWING_LAVA).setUnlocalizedName("bucketLava").setContainerItem(llIIIIIllIllII));
        registerItem(328, "minecart", new ItemMinecart(EntityMinecart.Type.RIDEABLE).setUnlocalizedName("minecart"));
        registerItem(329, "saddle", new ItemSaddle().setUnlocalizedName("saddle"));
        registerItem(330, "iron_door", new ItemDoor(Blocks.IRON_DOOR).setUnlocalizedName("doorIron"));
        registerItem(331, "redstone", new ItemRedstone().setUnlocalizedName("redstone"));
        registerItem(332, "snowball", new ItemSnowball().setUnlocalizedName("snowball"));
        registerItem(333, "boat", new ItemBoat(EntityBoat.Type.OAK));
        registerItem(334, "leather", new Item().setUnlocalizedName("leather").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(335, "milk_bucket", new ItemBucketMilk().setUnlocalizedName("milk").setContainerItem(llIIIIIllIllII));
        registerItem(336, "brick", new Item().setUnlocalizedName("brick").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(337, "clay_ball", new Item().setUnlocalizedName("clay").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(338, "reeds", new ItemBlockSpecial(Blocks.REEDS).setUnlocalizedName("reeds").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(339, "paper", new Item().setUnlocalizedName("paper").setCreativeTab(CreativeTabs.MISC));
        registerItem(340, "book", new ItemBook().setUnlocalizedName("book").setCreativeTab(CreativeTabs.MISC));
        registerItem(341, "slime_ball", new Item().setUnlocalizedName("slimeball").setCreativeTab(CreativeTabs.MISC));
        registerItem(342, "chest_minecart", new ItemMinecart(EntityMinecart.Type.CHEST).setUnlocalizedName("minecartChest"));
        registerItem(343, "furnace_minecart", new ItemMinecart(EntityMinecart.Type.FURNACE).setUnlocalizedName("minecartFurnace"));
        registerItem(344, "egg", new ItemEgg().setUnlocalizedName("egg"));
        registerItem(345, "compass", new ItemCompass().setUnlocalizedName("compass").setCreativeTab(CreativeTabs.TOOLS));
        registerItem(346, "fishing_rod", new ItemFishingRod().setUnlocalizedName("fishingRod"));
        registerItem(347, "clock", new ItemClock().setUnlocalizedName("clock").setCreativeTab(CreativeTabs.TOOLS));
        registerItem(348, "glowstone_dust", new Item().setUnlocalizedName("yellowDust").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(349, "fish", new ItemFishFood(false).setUnlocalizedName("fish").setHasSubtypes(true));
        registerItem(350, "cooked_fish", new ItemFishFood(true).setUnlocalizedName("fish").setHasSubtypes(true));
        registerItem(351, "dye", new ItemDye().setUnlocalizedName("dyePowder"));
        registerItem(352, "bone", new Item().setUnlocalizedName("bone").setFull3D().setCreativeTab(CreativeTabs.MISC));
        registerItem(353, "sugar", new Item().setUnlocalizedName("sugar").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(354, "cake", new ItemBlockSpecial(Blocks.CAKE).setMaxStackSize(1).setUnlocalizedName("cake").setCreativeTab(CreativeTabs.FOOD));
        registerItem(355, "bed", new ItemBed().setMaxStackSize(1).setUnlocalizedName("bed"));
        registerItem(356, "repeater", new ItemBlockSpecial(Blocks.UNPOWERED_REPEATER).setUnlocalizedName("diode").setCreativeTab(CreativeTabs.REDSTONE));
        registerItem(357, "cookie", new ItemFood(2, 0.1f, false).setUnlocalizedName("cookie"));
        registerItem(358, "filled_map", new ItemMap().setUnlocalizedName("map"));
        registerItem(359, "shears", new ItemShears().setUnlocalizedName("shears"));
        registerItem(360, "melon", new ItemFood(2, 0.3f, false).setUnlocalizedName("melon"));
        registerItem(361, "pumpkin_seeds", new ItemSeeds(Blocks.PUMPKIN_STEM, Blocks.FARMLAND).setUnlocalizedName("seeds_pumpkin"));
        registerItem(362, "melon_seeds", new ItemSeeds(Blocks.MELON_STEM, Blocks.FARMLAND).setUnlocalizedName("seeds_melon"));
        registerItem(363, "beef", new ItemFood(3, 0.3f, true).setUnlocalizedName("beefRaw"));
        registerItem(364, "cooked_beef", new ItemFood(8, 0.8f, true).setUnlocalizedName("beefCooked"));
        registerItem(365, "chicken", new ItemFood(2, 0.3f, true).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 0), 0.3f).setUnlocalizedName("chickenRaw"));
        registerItem(366, "cooked_chicken", new ItemFood(6, 0.6f, true).setUnlocalizedName("chickenCooked"));
        registerItem(367, "rotten_flesh", new ItemFood(4, 0.1f, true).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 0), 0.8f).setUnlocalizedName("rottenFlesh"));
        registerItem(368, "ender_pearl", new ItemEnderPearl().setUnlocalizedName("enderPearl"));
        registerItem(369, "blaze_rod", new Item().setUnlocalizedName("blazeRod").setCreativeTab(CreativeTabs.MATERIALS).setFull3D());
        registerItem(370, "ghast_tear", new Item().setUnlocalizedName("ghastTear").setCreativeTab(CreativeTabs.BREWING));
        registerItem(371, "gold_nugget", new Item().setUnlocalizedName("goldNugget").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(372, "nether_wart", new ItemSeeds(Blocks.NETHER_WART, Blocks.SOUL_SAND).setUnlocalizedName("netherStalkSeeds"));
        registerItem(373, "potion", new ItemPotion().setUnlocalizedName("potion"));
        final Item llIIIIIllIlIll = new ItemGlassBottle().setUnlocalizedName("glassBottle");
        registerItem(374, "glass_bottle", llIIIIIllIlIll);
        registerItem(375, "spider_eye", new ItemFood(2, 0.8f, false).setPotionEffect(new PotionEffect(MobEffects.POISON, 100, 0), 1.0f).setUnlocalizedName("spiderEye"));
        registerItem(376, "fermented_spider_eye", new Item().setUnlocalizedName("fermentedSpiderEye").setCreativeTab(CreativeTabs.BREWING));
        registerItem(377, "blaze_powder", new Item().setUnlocalizedName("blazePowder").setCreativeTab(CreativeTabs.BREWING));
        registerItem(378, "magma_cream", new Item().setUnlocalizedName("magmaCream").setCreativeTab(CreativeTabs.BREWING));
        registerItem(379, "brewing_stand", new ItemBlockSpecial(Blocks.BREWING_STAND).setUnlocalizedName("brewingStand").setCreativeTab(CreativeTabs.BREWING));
        registerItem(380, "cauldron", new ItemBlockSpecial(Blocks.CAULDRON).setUnlocalizedName("cauldron").setCreativeTab(CreativeTabs.BREWING));
        registerItem(381, "ender_eye", new ItemEnderEye().setUnlocalizedName("eyeOfEnder"));
        registerItem(382, "speckled_melon", new Item().setUnlocalizedName("speckledMelon").setCreativeTab(CreativeTabs.BREWING));
        registerItem(383, "spawn_egg", new ItemMonsterPlacer().setUnlocalizedName("monsterPlacer"));
        registerItem(384, "experience_bottle", new ItemExpBottle().setUnlocalizedName("expBottle"));
        registerItem(385, "fire_charge", new ItemFireball().setUnlocalizedName("fireball"));
        registerItem(386, "writable_book", new ItemWritableBook().setUnlocalizedName("writingBook").setCreativeTab(CreativeTabs.MISC));
        registerItem(387, "written_book", new ItemWrittenBook().setUnlocalizedName("writtenBook").setMaxStackSize(16));
        registerItem(388, "emerald", new Item().setUnlocalizedName("emerald").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(389, "item_frame", new ItemHangingEntity(EntityItemFrame.class).setUnlocalizedName("frame"));
        registerItem(390, "flower_pot", new ItemBlockSpecial(Blocks.FLOWER_POT).setUnlocalizedName("flowerPot").setCreativeTab(CreativeTabs.DECORATIONS));
        registerItem(391, "carrot", new ItemSeedFood(3, 0.6f, Blocks.CARROTS, Blocks.FARMLAND).setUnlocalizedName("carrots"));
        registerItem(392, "potato", new ItemSeedFood(1, 0.3f, Blocks.POTATOES, Blocks.FARMLAND).setUnlocalizedName("potato"));
        registerItem(393, "baked_potato", new ItemFood(5, 0.6f, false).setUnlocalizedName("potatoBaked"));
        registerItem(394, "poisonous_potato", new ItemFood(2, 0.3f, false).setPotionEffect(new PotionEffect(MobEffects.POISON, 100, 0), 0.6f).setUnlocalizedName("potatoPoisonous"));
        registerItem(395, "map", new ItemEmptyMap().setUnlocalizedName("emptyMap"));
        registerItem(396, "golden_carrot", new ItemFood(6, 1.2f, false).setUnlocalizedName("carrotGolden").setCreativeTab(CreativeTabs.BREWING));
        registerItem(397, "skull", new ItemSkull().setUnlocalizedName("skull"));
        registerItem(398, "carrot_on_a_stick", new ItemCarrotOnAStick().setUnlocalizedName("carrotOnAStick"));
        registerItem(399, "nether_star", new ItemSimpleFoiled().setUnlocalizedName("netherStar").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(400, "pumpkin_pie", new ItemFood(8, 0.3f, false).setUnlocalizedName("pumpkinPie").setCreativeTab(CreativeTabs.FOOD));
        registerItem(401, "fireworks", new ItemFirework().setUnlocalizedName("fireworks"));
        registerItem(402, "firework_charge", new ItemFireworkCharge().setUnlocalizedName("fireworksCharge").setCreativeTab(CreativeTabs.MISC));
        registerItem(403, "enchanted_book", new ItemEnchantedBook().setMaxStackSize(1).setUnlocalizedName("enchantedBook"));
        registerItem(404, "comparator", new ItemBlockSpecial(Blocks.UNPOWERED_COMPARATOR).setUnlocalizedName("comparator").setCreativeTab(CreativeTabs.REDSTONE));
        registerItem(405, "netherbrick", new Item().setUnlocalizedName("netherbrick").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(406, "quartz", new Item().setUnlocalizedName("netherquartz").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(407, "tnt_minecart", new ItemMinecart(EntityMinecart.Type.TNT).setUnlocalizedName("minecartTnt"));
        registerItem(408, "hopper_minecart", new ItemMinecart(EntityMinecart.Type.HOPPER).setUnlocalizedName("minecartHopper"));
        registerItem(409, "prismarine_shard", new Item().setUnlocalizedName("prismarineShard").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(410, "prismarine_crystals", new Item().setUnlocalizedName("prismarineCrystals").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(411, "rabbit", new ItemFood(3, 0.3f, true).setUnlocalizedName("rabbitRaw"));
        registerItem(412, "cooked_rabbit", new ItemFood(5, 0.6f, true).setUnlocalizedName("rabbitCooked"));
        registerItem(413, "rabbit_stew", new ItemSoup(10).setUnlocalizedName("rabbitStew"));
        registerItem(414, "rabbit_foot", new Item().setUnlocalizedName("rabbitFoot").setCreativeTab(CreativeTabs.BREWING));
        registerItem(415, "rabbit_hide", new Item().setUnlocalizedName("rabbitHide").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(416, "armor_stand", new ItemArmorStand().setUnlocalizedName("armorStand").setMaxStackSize(16));
        registerItem(417, "iron_horse_armor", new Item().setUnlocalizedName("horsearmormetal").setMaxStackSize(1).setCreativeTab(CreativeTabs.MISC));
        registerItem(418, "golden_horse_armor", new Item().setUnlocalizedName("horsearmorgold").setMaxStackSize(1).setCreativeTab(CreativeTabs.MISC));
        registerItem(419, "diamond_horse_armor", new Item().setUnlocalizedName("horsearmordiamond").setMaxStackSize(1).setCreativeTab(CreativeTabs.MISC));
        registerItem(420, "lead", new ItemLead().setUnlocalizedName("leash"));
        registerItem(421, "name_tag", new ItemNameTag().setUnlocalizedName("nameTag"));
        registerItem(422, "command_block_minecart", new ItemMinecart(EntityMinecart.Type.COMMAND_BLOCK).setUnlocalizedName("minecartCommandBlock").setCreativeTab(null));
        registerItem(423, "mutton", new ItemFood(2, 0.3f, true).setUnlocalizedName("muttonRaw"));
        registerItem(424, "cooked_mutton", new ItemFood(6, 0.8f, true).setUnlocalizedName("muttonCooked"));
        registerItem(425, "banner", new ItemBanner().setUnlocalizedName("banner"));
        registerItem(426, "end_crystal", new ItemEndCrystal());
        registerItem(427, "spruce_door", new ItemDoor(Blocks.SPRUCE_DOOR).setUnlocalizedName("doorSpruce"));
        registerItem(428, "birch_door", new ItemDoor(Blocks.BIRCH_DOOR).setUnlocalizedName("doorBirch"));
        registerItem(429, "jungle_door", new ItemDoor(Blocks.JUNGLE_DOOR).setUnlocalizedName("doorJungle"));
        registerItem(430, "acacia_door", new ItemDoor(Blocks.ACACIA_DOOR).setUnlocalizedName("doorAcacia"));
        registerItem(431, "dark_oak_door", new ItemDoor(Blocks.DARK_OAK_DOOR).setUnlocalizedName("doorDarkOak"));
        registerItem(432, "chorus_fruit", new ItemChorusFruit(4, 0.3f).setAlwaysEdible().setUnlocalizedName("chorusFruit").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(433, "chorus_fruit_popped", new Item().setUnlocalizedName("chorusFruitPopped").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(434, "beetroot", new ItemFood(1, 0.6f, false).setUnlocalizedName("beetroot"));
        registerItem(435, "beetroot_seeds", new ItemSeeds(Blocks.BEETROOTS, Blocks.FARMLAND).setUnlocalizedName("beetroot_seeds"));
        registerItem(436, "beetroot_soup", new ItemSoup(6).setUnlocalizedName("beetroot_soup"));
        registerItem(437, "dragon_breath", new Item().setCreativeTab(CreativeTabs.BREWING).setUnlocalizedName("dragon_breath").setContainerItem(llIIIIIllIlIll));
        registerItem(438, "splash_potion", new ItemSplashPotion().setUnlocalizedName("splash_potion"));
        registerItem(439, "spectral_arrow", new ItemSpectralArrow().setUnlocalizedName("spectral_arrow"));
        registerItem(440, "tipped_arrow", new ItemTippedArrow().setUnlocalizedName("tipped_arrow"));
        registerItem(441, "lingering_potion", new ItemLingeringPotion().setUnlocalizedName("lingering_potion"));
        registerItem(442, "shield", new ItemShield().setUnlocalizedName("shield"));
        registerItem(443, "elytra", new ItemElytra().setUnlocalizedName("elytra"));
        registerItem(444, "spruce_boat", new ItemBoat(EntityBoat.Type.SPRUCE));
        registerItem(445, "birch_boat", new ItemBoat(EntityBoat.Type.BIRCH));
        registerItem(446, "jungle_boat", new ItemBoat(EntityBoat.Type.JUNGLE));
        registerItem(447, "acacia_boat", new ItemBoat(EntityBoat.Type.ACACIA));
        registerItem(448, "dark_oak_boat", new ItemBoat(EntityBoat.Type.DARK_OAK));
        registerItem(449, "totem_of_undying", new Item().setUnlocalizedName("totem").setMaxStackSize(1).setCreativeTab(CreativeTabs.COMBAT));
        registerItem(450, "shulker_shell", new Item().setUnlocalizedName("shulkerShell").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(452, "iron_nugget", new Item().setUnlocalizedName("ironNugget").setCreativeTab(CreativeTabs.MATERIALS));
        registerItem(453, "knowledge_book", new ItemKnowledgeBook().setUnlocalizedName("knowledgeBook"));
        registerItem(2256, "record_13", new ItemRecord("13", SoundEvents.RECORD_13).setUnlocalizedName("record"));
        registerItem(2257, "record_cat", new ItemRecord("cat", SoundEvents.RECORD_CAT).setUnlocalizedName("record"));
        registerItem(2258, "record_blocks", new ItemRecord("blocks", SoundEvents.RECORD_BLOCKS).setUnlocalizedName("record"));
        registerItem(2259, "record_chirp", new ItemRecord("chirp", SoundEvents.RECORD_CHIRP).setUnlocalizedName("record"));
        registerItem(2260, "record_far", new ItemRecord("far", SoundEvents.RECORD_FAR).setUnlocalizedName("record"));
        registerItem(2261, "record_mall", new ItemRecord("mall", SoundEvents.RECORD_MALL).setUnlocalizedName("record"));
        registerItem(2262, "record_mellohi", new ItemRecord("mellohi", SoundEvents.RECORD_MELLOHI).setUnlocalizedName("record"));
        registerItem(2263, "record_stal", new ItemRecord("stal", SoundEvents.RECORD_STAL).setUnlocalizedName("record"));
        registerItem(2264, "record_strad", new ItemRecord("strad", SoundEvents.RECORD_STRAD).setUnlocalizedName("record"));
        registerItem(2265, "record_ward", new ItemRecord("ward", SoundEvents.RECORD_WARD).setUnlocalizedName("record"));
        registerItem(2266, "record_11", new ItemRecord("11", SoundEvents.RECORD_11).setUnlocalizedName("record"));
        registerItem(2267, "record_wait", new ItemRecord("wait", SoundEvents.RECORD_WAIT).setUnlocalizedName("record"));
    }
    
    protected boolean func_194125_a(final CreativeTabs llIIIIIlllllll) {
        final CreativeTabs llIIIIlIIIIIIl = this.getCreativeTab();
        return llIIIIlIIIIIIl != null && (llIIIIIlllllll == CreativeTabs.SEARCH || llIIIIIlllllll == llIIIIlIIIIIIl);
    }
    
    public ActionResult<ItemStack> onItemRightClick(final World llIIIlIlIIllII, final EntityPlayer llIIIlIlIIlIll, final EnumHand llIIIlIlIIlIlI) {
        return new ActionResult<ItemStack>(EnumActionResult.PASS, llIIIlIlIIlIll.getHeldItem(llIIIlIlIIlIlI));
    }
    
    @Nullable
    public CreativeTabs getCreativeTab() {
        return this.tabToDisplayOn;
    }
    
    public boolean onBlockDestroyed(final ItemStack llIIIlIIlIIIlI, final World llIIIlIIlIIIIl, final IBlockState llIIIlIIlIIIII, final BlockPos llIIIlIIIlllll, final EntityLivingBase llIIIlIIIllllI) {
        return false;
    }
    
    public boolean hasEffect(final ItemStack llIIIIllIIlllI) {
        return llIIIIllIIlllI.isItemEnchanted();
    }
    
    public void getSubItems(final CreativeTabs llIIIIlIIIlIll, final NonNullList<ItemStack> llIIIIlIIIIlll) {
        if (this.func_194125_a(llIIIIlIIIlIll)) {
            llIIIIlIIIIlll.add(new ItemStack(this));
        }
    }
    
    public static Item getItemById(final int llIIIllIIIIlll) {
        return Item.REGISTRY.getObjectById(llIIIllIIIIlll);
    }
    
    protected Item setMaxDamage(final int llIIIlIIlIllIl) {
        this.maxDamage = llIIIlIIlIllIl;
        if (llIIIlIIlIllIl > 0) {
            this.addPropertyOverride(new ResourceLocation("damaged"), Item.DAMAGED_GETTER);
            this.addPropertyOverride(new ResourceLocation("damage"), Item.DAMAGE_GETTER);
        }
        return this;
    }
    
    @Nullable
    public Item getContainerItem() {
        return this.containerItem;
    }
    
    public Item setContainerItem(final Item llIIIIllllIlll) {
        this.containerItem = llIIIIllllIlll;
        return this;
    }
    
    @Nullable
    public static Item getByNameOrId(final String llIIIlIlllllIl) {
        final Item llIIIlIlllllII = Item.REGISTRY.getObject(new ResourceLocation(llIIIlIlllllIl));
        if (llIIIlIlllllII == null) {
            try {
                return getItemById(Integer.parseInt(llIIIlIlllllIl));
            }
            catch (NumberFormatException ex) {}
        }
        return llIIIlIlllllII;
    }
    
    public void onCreated(final ItemStack llIIIIlllIlIII, final World llIIIIlllIIlll, final EntityPlayer llIIIIlllIIllI) {
    }
    
    public boolean hasCustomProperties() {
        return !this.properties.getKeys().isEmpty();
    }
    
    public int getItemStackLimit() {
        return this.maxStackSize;
    }
    
    public Item setFull3D() {
        this.bFull3D = true;
        return this;
    }
    
    public int getItemEnchantability() {
        return 0;
    }
    
    private static void registerItem(final int llIIIIIlIlllII, final String llIIIIIlIllIII, final Item llIIIIIlIllIlI) {
        registerItem(llIIIIIlIlllII, new ResourceLocation(llIIIIIlIllIII), llIIIIIlIllIlI);
    }
    
    public int getMetadata(final int llIIIlIIllllIl) {
        return 0;
    }
    
    public ItemStack func_190903_i() {
        return new ItemStack(this);
    }
    
    protected Item setHasSubtypes(final boolean llIIIlIIllIlII) {
        this.hasSubtypes = llIIIlIIllIlII;
        return this;
    }
    
    public String getUnlocalizedNameInefficiently(final ItemStack llIIIlIIIIIllI) {
        return I18n.translateToLocal(this.getUnlocalizedName(llIIIlIIIIIllI));
    }
    
    public boolean shouldRotateAroundWhenRendering() {
        return false;
    }
    
    public boolean canItemEditBlocks() {
        return false;
    }
    
    public String getUnlocalizedName(final ItemStack llIIIIlllllllI) {
        return String.valueOf(new StringBuilder("item.").append(this.unlocalizedName));
    }
    
    public boolean isItemTool(final ItemStack llIIIIllIIIllI) {
        return this.getItemStackLimit() == 1 && this.isDamageable();
    }
    
    public boolean hitEntity(final ItemStack llIIIlIIlIIllI, final EntityLivingBase llIIIlIIlIIlIl, final EntityLivingBase llIIIlIIlIIlII) {
        return false;
    }
    
    public void addInformation(final ItemStack llIIIIllIllIlI, @Nullable final World llIIIIllIllIIl, final List<String> llIIIIllIllIII, final ITooltipFlag llIIIIllIlIlll) {
    }
    
    private static void registerItemBlock(final Block llIIIIIllIIlll) {
        registerItemBlock(llIIIIIllIIlll, new ItemBlock(llIIIIIllIIlll));
    }
    
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(final EntityEquipmentSlot llIIIIIllIllll) {
        return (Multimap<String, AttributeModifier>)HashMultimap.create();
    }
    
    public boolean getShareTag() {
        return true;
    }
    
    @Nullable
    public IItemPropertyGetter getPropertyGetter(final ResourceLocation llIIIlIllIlIlI) {
        return this.properties.getObject(llIIIlIllIlIlI);
    }
    
    protected static void registerItemBlock(final Block llIIIIIllIIIIl, final Item llIIIIIllIIIII) {
        registerItem(Block.getIdFromBlock(llIIIIIllIIIIl), Block.REGISTRY.getNameForObject(llIIIIIllIIIIl), llIIIIIllIIIII);
        Item.BLOCK_TO_ITEM.put(llIIIIIllIIIIl, llIIIIIllIIIII);
    }
    
    public boolean isDamageable() {
        return this.maxDamage > 0 && (!this.hasSubtypes || this.maxStackSize == 1);
    }
    
    public ItemStack onItemUseFinish(final ItemStack llIIIlIlIIIlIl, final World llIIIlIlIIIlII, final EntityLivingBase llIIIlIlIIIIll) {
        return llIIIlIlIIIlIl;
    }
    
    public int getMaxItemUseDuration(final ItemStack llIIIIlllIIIIl) {
        return 0;
    }
    
    private static void registerItem(final int llIIIIIlIlIIII, final ResourceLocation llIIIIIlIlIIlI, final Item llIIIIIlIlIIIl) {
        Item.REGISTRY.register(llIIIIIlIlIIII, llIIIIIlIlIIlI, llIIIIIlIlIIIl);
    }
    
    public String getUnlocalizedName() {
        return String.valueOf(new StringBuilder("item.").append(this.unlocalizedName));
    }
    
    public Item setUnlocalizedName(final String llIIIlIIIIlIlI) {
        this.unlocalizedName = llIIIlIIIIlIlI;
        return this;
    }
    
    public boolean itemInteractionForEntity(final ItemStack llIIIlIIIllIlI, final EntityPlayer llIIIlIIIllIIl, final EntityLivingBase llIIIlIIIllIII, final EnumHand llIIIlIIIlIlll) {
        return false;
    }
    
    public float getStrVsBlock(final ItemStack llIIIlIlIlIIIl, final IBlockState llIIIlIlIlIIII) {
        return 1.0f;
    }
    
    public boolean hasContainerItem() {
        return this.containerItem != null;
    }
    
    public boolean getHasSubtypes() {
        return this.hasSubtypes;
    }
    
    public static Item getItemFromBlock(final Block llIIIllIIIIlII) {
        final Item llIIIllIIIIIll = Item.BLOCK_TO_ITEM.get(llIIIllIIIIlII);
        return (llIIIllIIIIIll == null) ? Items.field_190931_a : llIIIllIIIIIll;
    }
    
    public EnumAction getItemUseAction(final ItemStack llIIIIlllIIIll) {
        return EnumAction.NONE;
    }
    
    public static int getIdFromItem(final Item llIIIllIIIlIll) {
        return (llIIIllIIIlIll == null) ? 0 : Item.REGISTRY.getIDForObject(llIIIllIIIlIll);
    }
    
    public boolean canHarvestBlock(final IBlockState llIIIlIIIlllII) {
        return false;
    }
    
    public String getItemStackDisplayName(final ItemStack llIIIIllIlIIll) {
        return I18n.translateToLocal(String.valueOf(new StringBuilder(String.valueOf(this.getUnlocalizedNameInefficiently(llIIIIllIlIIll))).append(".name"))).trim();
    }
    
    protected RayTraceResult rayTrace(final World llIIIIlIllIIlI, final EntityPlayer llIIIIlIllIIIl, final boolean llIIIIlIIlllll) {
        final float llIIIIlIlIllll = llIIIIlIllIIIl.rotationPitch;
        final float llIIIIlIlIlllI = llIIIIlIllIIIl.rotationYaw;
        final double llIIIIlIlIllIl = llIIIIlIllIIIl.posX;
        final double llIIIIlIlIllII = llIIIIlIllIIIl.posY + llIIIIlIllIIIl.getEyeHeight();
        final double llIIIIlIlIlIll = llIIIIlIllIIIl.posZ;
        final Vec3d llIIIIlIlIlIlI = new Vec3d(llIIIIlIlIllIl, llIIIIlIlIllII, llIIIIlIlIlIll);
        final float llIIIIlIlIlIIl = MathHelper.cos(-llIIIIlIlIlllI * 0.017453292f - 3.1415927f);
        final float llIIIIlIlIlIII = MathHelper.sin(-llIIIIlIlIlllI * 0.017453292f - 3.1415927f);
        final float llIIIIlIlIIlll = -MathHelper.cos(-llIIIIlIlIllll * 0.017453292f);
        final float llIIIIlIlIIllI = MathHelper.sin(-llIIIIlIlIllll * 0.017453292f);
        final float llIIIIlIlIIlIl = llIIIIlIlIlIII * llIIIIlIlIIlll;
        final float llIIIIlIlIIlII = llIIIIlIlIlIIl * llIIIIlIlIIlll;
        final double llIIIIlIlIIIll = 5.0;
        final Vec3d llIIIIlIlIIIlI = llIIIIlIlIlIlI.addVector(llIIIIlIlIIlIl * 5.0, llIIIIlIlIIllI * 5.0, llIIIIlIlIIlII * 5.0);
        return llIIIIlIllIIlI.rayTraceBlocks(llIIIIlIlIlIlI, llIIIIlIlIIIlI, llIIIIlIIlllll, !llIIIIlIIlllll, false);
    }
    
    public final void addPropertyOverride(final ResourceLocation llIIIlIlllIIIl, final IItemPropertyGetter llIIIlIlllIIII) {
        this.properties.putObject(llIIIlIlllIIIl, llIIIlIlllIIII);
    }
    
    public EnumActionResult onItemUse(final EntityPlayer llIIIlIlIllIlI, final World llIIIlIlIllIIl, final BlockPos llIIIlIlIllIII, final EnumHand llIIIlIlIlIlll, final EnumFacing llIIIlIlIlIllI, final float llIIIlIlIlIlIl, final float llIIIlIlIlIlII, final float llIIIlIlIlIIll) {
        return EnumActionResult.PASS;
    }
    
    public Item setMaxStackSize(final int llIIIlIlIlllII) {
        this.maxStackSize = llIIIlIlIlllII;
        return this;
    }
    
    public boolean isFull3D() {
        return this.bFull3D;
    }
    
    public void onUpdate(final ItemStack llIIIIlllIlllI, final World llIIIIlllIllIl, final Entity llIIIIlllIllII, final int llIIIIlllIlIll, final boolean llIIIIlllIlIlI) {
    }
    
    public boolean updateItemStackNBT(final NBTTagCompound llIIIlIllIIlIl) {
        return false;
    }
    
    public enum ToolMaterial
    {
        private final /* synthetic */ int harvestLevel;
        private final /* synthetic */ int maxUses;
        private final /* synthetic */ float damageVsEntity;
        
        STONE("STONE", 1, 1, 131, 4.0f, 1.0f, 5);
        
        private final /* synthetic */ int enchantability;
        
        IRON("IRON", 2, 2, 250, 6.0f, 2.0f, 14);
        
        private final /* synthetic */ float efficiencyOnProperMaterial;
        
        GOLD("GOLD", 4, 0, 32, 12.0f, 0.0f, 22), 
        DIAMOND("DIAMOND", 3, 3, 1561, 8.0f, 3.0f, 10), 
        WOOD("WOOD", 0, 0, 59, 2.0f, 0.0f, 15);
        
        public int getEnchantability() {
            return this.enchantability;
        }
        
        public float getDamageVsEntity() {
            return this.damageVsEntity;
        }
        
        public Item getRepairItem() {
            if (this == ToolMaterial.WOOD) {
                return Item.getItemFromBlock(Blocks.PLANKS);
            }
            if (this == ToolMaterial.STONE) {
                return Item.getItemFromBlock(Blocks.COBBLESTONE);
            }
            if (this == ToolMaterial.GOLD) {
                return Items.GOLD_INGOT;
            }
            if (this == ToolMaterial.IRON) {
                return Items.IRON_INGOT;
            }
            return (this == ToolMaterial.DIAMOND) ? Items.DIAMOND : null;
        }
        
        private ToolMaterial(final String llllllllllllllllIIIllIIIIIllIIII, final int llllllllllllllllIIIllIIIIIlIllll, final int llllllllllllllllIIIllIIIIIllIllI, final int llllllllllllllllIIIllIIIIIlIllIl, final float llllllllllllllllIIIllIIIIIlIllII, final float llllllllllllllllIIIllIIIIIlIlIll, final int llllllllllllllllIIIllIIIIIlIlIlI) {
            this.harvestLevel = llllllllllllllllIIIllIIIIIllIllI;
            this.maxUses = llllllllllllllllIIIllIIIIIlIllIl;
            this.efficiencyOnProperMaterial = llllllllllllllllIIIllIIIIIlIllII;
            this.damageVsEntity = llllllllllllllllIIIllIIIIIlIlIll;
            this.enchantability = llllllllllllllllIIIllIIIIIlIlIlI;
        }
        
        public int getHarvestLevel() {
            return this.harvestLevel;
        }
        
        public int getMaxUses() {
            return this.maxUses;
        }
        
        public float getEfficiencyOnProperMaterial() {
            return this.efficiencyOnProperMaterial;
        }
    }
}
