package net.minecraft.stats;

import javax.annotation.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.util.text.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import com.google.common.collect.*;
import net.minecraft.item.crafting.*;
import java.util.*;
import net.minecraft.item.*;

public class StatList
{
    public static final /* synthetic */ List<StatBase> ALL_STATS;
    private static final /* synthetic */ StatBase[] CRAFTS_STATS;
    protected static final /* synthetic */ Map<String, StatBase> ID_TO_STAT_MAP;
    private static final /* synthetic */ StatBase[] BLOCKS_STATS;
    private static final /* synthetic */ StatBase[] OBJECT_BREAK_STATS;
    public static final /* synthetic */ List<StatBase> BASIC_STATS;
    private static final /* synthetic */ StatBase[] OBJECTS_DROPPED_STATS;
    public static final /* synthetic */ List<StatCrafting> USE_ITEM_STATS;
    public static final /* synthetic */ List<StatCrafting> MINE_BLOCK_STATS;
    private static final /* synthetic */ StatBase[] OBJECTS_PICKED_UP_STATS;
    private static final /* synthetic */ StatBase[] OBJECT_USE_STATS;
    
    @Nullable
    public static StatBase getCraftStats(final Item lllllllllllllIIlIllIlIIlIIllIlIl) {
        return StatList.CRAFTS_STATS[Item.getIdFromItem(lllllllllllllIIlIllIlIIlIIllIlIl)];
    }
    
    @Nullable
    public static StatBase getObjectUseStats(final Item lllllllllllllIIlIllIlIIlIIllIIIl) {
        return StatList.OBJECT_USE_STATS[Item.getIdFromItem(lllllllllllllIIlIllIlIIlIIllIIIl)];
    }
    
    private static String getItemName(final Item lllllllllllllIIlIllIlIIIlllIIlIl) {
        final ResourceLocation lllllllllllllIIlIllIlIIIlllIIlII = Item.REGISTRY.getNameForObject(lllllllllllllIIlIllIlIIIlllIIlIl);
        return (lllllllllllllIIlIllIlIIIlllIIlII != null) ? lllllllllllllIIlIllIlIIIlllIIlII.toString().replace(':', '.') : null;
    }
    
    @Nullable
    public static StatBase getObjectBreakStats(final Item lllllllllllllIIlIllIlIIlIIlIllll) {
        return StatList.OBJECT_BREAK_STATS[Item.getIdFromItem(lllllllllllllIIlIllIlIIlIIlIllll)];
    }
    
    public static StatBase getStatEntityKilledBy(final EntityList.EntityEggInfo lllllllllllllIIlIllIlIIIllIIIlll) {
        final String lllllllllllllIIlIllIlIIIllIIIllI = EntityList.func_191302_a(lllllllllllllIIlIllIlIIIllIIIlll.spawnedID);
        return (lllllllllllllIIlIllIlIIIllIIIllI == null) ? null : new StatBase(String.valueOf(new StringBuilder("stat.entityKilledBy.").append(lllllllllllllIIlIllIlIIIllIIIllI)), new TextComponentTranslation("stat.entityKilledBy", new Object[] { new TextComponentTranslation(String.valueOf(new StringBuilder("entity.").append(lllllllllllllIIlIllIlIIIllIIIllI).append(".name")), new Object[0]) })).registerStat();
    }
    
    public static StatBase getStatKillEntity(final EntityList.EntityEggInfo lllllllllllllIIlIllIlIIIllIIllIl) {
        final String lllllllllllllIIlIllIlIIIllIIllII = EntityList.func_191302_a(lllllllllllllIIlIllIlIIIllIIllIl.spawnedID);
        return (lllllllllllllIIlIllIlIIIllIIllII == null) ? null : new StatBase(String.valueOf(new StringBuilder("stat.killEntity.").append(lllllllllllllIIlIllIlIIIllIIllII)), new TextComponentTranslation("stat.entityKill", new Object[] { new TextComponentTranslation(String.valueOf(new StringBuilder("entity.").append(lllllllllllllIIlIllIlIIIllIIllII).append(".name")), new Object[0]) })).registerStat();
    }
    
    @Nullable
    public static StatBase getBlockStats(final Block lllllllllllllIIlIllIlIIlIIllIlll) {
        return StatList.BLOCKS_STATS[Block.getIdFromBlock(lllllllllllllIIlIllIlIIlIIllIlll)];
    }
    
    private static void initMiningStats() {
        for (final Block lllllllllllllIIlIllIlIIlIIIlIIIl : Block.REGISTRY) {
            final Item lllllllllllllIIlIllIlIIlIIIlIIII = Item.getItemFromBlock(lllllllllllllIIlIllIlIIlIIIlIIIl);
            if (lllllllllllllIIlIllIlIIlIIIlIIII != Items.field_190931_a) {
                final int lllllllllllllIIlIllIlIIlIIIIllll = Block.getIdFromBlock(lllllllllllllIIlIllIlIIlIIIlIIIl);
                final String lllllllllllllIIlIllIlIIlIIIIlllI = getItemName(lllllllllllllIIlIllIlIIlIIIlIIII);
                if (lllllllllllllIIlIllIlIIlIIIIlllI == null || !lllllllllllllIIlIllIlIIlIIIlIIIl.getEnableStats()) {
                    continue;
                }
                StatList.BLOCKS_STATS[lllllllllllllIIlIllIlIIlIIIIllll] = new StatCrafting("stat.mineBlock.", lllllllllllllIIlIllIlIIlIIIIlllI, new TextComponentTranslation("stat.mineBlock", new Object[] { new ItemStack(lllllllllllllIIlIllIlIIlIIIlIIIl).getTextComponent() }), lllllllllllllIIlIllIlIIlIIIlIIII).registerStat();
                StatList.MINE_BLOCK_STATS.add((StatCrafting)StatList.BLOCKS_STATS[lllllllllllllIIlIllIlIIlIIIIllll]);
            }
        }
        replaceAllSimilarBlocks(StatList.BLOCKS_STATS);
    }
    
    @Nullable
    public static StatBase getDroppedObjectStats(final Item lllllllllllllIIlIllIlIIlIIlIlIIl) {
        return StatList.OBJECTS_DROPPED_STATS[Item.getIdFromItem(lllllllllllllIIlIllIlIIlIIlIlIIl)];
    }
    
    private static void initItemDepleteStats() {
        for (final Item lllllllllllllIIlIllIlIIIlllllIIl : Item.REGISTRY) {
            if (lllllllllllllIIlIllIlIIIlllllIIl != null) {
                final int lllllllllllllIIlIllIlIIIlllllIII = Item.getIdFromItem(lllllllllllllIIlIllIlIIIlllllIIl);
                final String lllllllllllllIIlIllIlIIIllllIlll = getItemName(lllllllllllllIIlIllIlIIIlllllIIl);
                if (lllllllllllllIIlIllIlIIIllllIlll == null || !lllllllllllllIIlIllIlIIIlllllIIl.isDamageable()) {
                    continue;
                }
                StatList.OBJECT_BREAK_STATS[lllllllllllllIIlIllIlIIIlllllIII] = new StatCrafting("stat.breakItem.", lllllllllllllIIlIllIlIIIllllIlll, new TextComponentTranslation("stat.breakItem", new Object[] { new ItemStack(lllllllllllllIIlIllIlIIIlllllIIl).getTextComponent() }), lllllllllllllIIlIllIlIIIlllllIIl).registerStat();
            }
        }
        replaceAllSimilarBlocks(StatList.OBJECT_BREAK_STATS);
    }
    
    private static void mergeStatBases(final StatBase[] lllllllllllllIIlIllIlIIIllIlIlII, final Block lllllllllllllIIlIllIlIIIllIllIII, final Block lllllllllllllIIlIllIlIIIllIlIlll) {
        final int lllllllllllllIIlIllIlIIIllIlIllI = Block.getIdFromBlock(lllllllllllllIIlIllIlIIIllIllIII);
        final int lllllllllllllIIlIllIlIIIllIlIlIl = Block.getIdFromBlock(lllllllllllllIIlIllIlIIIllIlIlll);
        if (lllllllllllllIIlIllIlIIIllIlIlII[lllllllllllllIIlIllIlIIIllIlIllI] != null && lllllllllllllIIlIllIlIIIllIlIlII[lllllllllllllIIlIllIlIIIllIlIlIl] == null) {
            lllllllllllllIIlIllIlIIIllIlIlII[lllllllllllllIIlIllIlIIIllIlIlIl] = lllllllllllllIIlIllIlIIIllIlIlII[lllllllllllllIIlIllIlIIIllIlIllI];
        }
        else {
            StatList.ALL_STATS.remove(lllllllllllllIIlIllIlIIIllIlIlII[lllllllllllllIIlIllIlIIIllIlIllI]);
            StatList.MINE_BLOCK_STATS.remove(lllllllllllllIIlIllIlIIIllIlIlII[lllllllllllllIIlIllIlIIIllIlIllI]);
            StatList.BASIC_STATS.remove(lllllllllllllIIlIllIlIIIllIlIlII[lllllllllllllIIlIllIlIIIllIlIllI]);
            lllllllllllllIIlIllIlIIIllIlIlII[lllllllllllllIIlIllIlIIIllIlIllI] = lllllllllllllIIlIllIlIIIllIlIlII[lllllllllllllIIlIllIlIIIllIlIlIl];
        }
    }
    
    private static void replaceAllSimilarBlocks(final StatBase[] lllllllllllllIIlIllIlIIIllIlllll) {
        mergeStatBases(lllllllllllllIIlIllIlIIIllIlllll, Blocks.WATER, Blocks.FLOWING_WATER);
        mergeStatBases(lllllllllllllIIlIllIlIIIllIlllll, Blocks.LAVA, Blocks.FLOWING_LAVA);
        mergeStatBases(lllllllllllllIIlIllIlIIIllIlllll, Blocks.LIT_PUMPKIN, Blocks.PUMPKIN);
        mergeStatBases(lllllllllllllIIlIllIlIIIllIlllll, Blocks.LIT_FURNACE, Blocks.FURNACE);
        mergeStatBases(lllllllllllllIIlIllIlIIIllIlllll, Blocks.LIT_REDSTONE_ORE, Blocks.REDSTONE_ORE);
        mergeStatBases(lllllllllllllIIlIllIlIIIllIlllll, Blocks.POWERED_REPEATER, Blocks.UNPOWERED_REPEATER);
        mergeStatBases(lllllllllllllIIlIllIlIIIllIlllll, Blocks.POWERED_COMPARATOR, Blocks.UNPOWERED_COMPARATOR);
        mergeStatBases(lllllllllllllIIlIllIlIIIllIlllll, Blocks.REDSTONE_TORCH, Blocks.UNLIT_REDSTONE_TORCH);
        mergeStatBases(lllllllllllllIIlIllIlIIIllIlllll, Blocks.LIT_REDSTONE_LAMP, Blocks.REDSTONE_LAMP);
        mergeStatBases(lllllllllllllIIlIllIlIIIllIlllll, Blocks.DOUBLE_STONE_SLAB, Blocks.STONE_SLAB);
        mergeStatBases(lllllllllllllIIlIllIlIIIllIlllll, Blocks.DOUBLE_WOODEN_SLAB, Blocks.WOODEN_SLAB);
        mergeStatBases(lllllllllllllIIlIllIlIIIllIlllll, Blocks.DOUBLE_STONE_SLAB2, Blocks.STONE_SLAB2);
        mergeStatBases(lllllllllllllIIlIllIlIIIllIlllll, Blocks.GRASS, Blocks.DIRT);
        mergeStatBases(lllllllllllllIIlIllIlIIIllIlllll, Blocks.FARMLAND, Blocks.DIRT);
    }
    
    private static void initPickedUpAndDroppedStats() {
        for (final Item lllllllllllllIIlIllIlIIIlllIlllI : Item.REGISTRY) {
            if (lllllllllllllIIlIllIlIIIlllIlllI != null) {
                final int lllllllllllllIIlIllIlIIIlllIllIl = Item.getIdFromItem(lllllllllllllIIlIllIlIIIlllIlllI);
                final String lllllllllllllIIlIllIlIIIlllIllII = getItemName(lllllllllllllIIlIllIlIIIlllIlllI);
                if (lllllllllllllIIlIllIlIIIlllIllII == null) {
                    continue;
                }
                StatList.OBJECTS_PICKED_UP_STATS[lllllllllllllIIlIllIlIIIlllIllIl] = new StatCrafting("stat.pickup.", lllllllllllllIIlIllIlIIIlllIllII, new TextComponentTranslation("stat.pickup", new Object[] { new ItemStack(lllllllllllllIIlIllIlIIIlllIlllI).getTextComponent() }), lllllllllllllIIlIllIlIIIlllIlllI).registerStat();
                StatList.OBJECTS_DROPPED_STATS[lllllllllllllIIlIllIlIIIlllIllIl] = new StatCrafting("stat.drop.", lllllllllllllIIlIllIlIIIlllIllII, new TextComponentTranslation("stat.drop", new Object[] { new ItemStack(lllllllllllllIIlIllIlIIIlllIlllI).getTextComponent() }), lllllllllllllIIlIllIlIIIlllIlllI).registerStat();
            }
        }
        replaceAllSimilarBlocks(StatList.OBJECT_BREAK_STATS);
    }
    
    public static void init() {
        initMiningStats();
        initStats();
        initItemDepleteStats();
        initCraftableStats();
        initPickedUpAndDroppedStats();
    }
    
    @Nullable
    public static StatBase getObjectsPickedUpStats(final Item lllllllllllllIIlIllIlIIlIIlIllII) {
        return StatList.OBJECTS_PICKED_UP_STATS[Item.getIdFromItem(lllllllllllllIIlIllIlIIlIIlIllII)];
    }
    
    static {
        ID_TO_STAT_MAP = Maps.newHashMap();
        ALL_STATS = Lists.newArrayList();
        BASIC_STATS = Lists.newArrayList();
        USE_ITEM_STATS = Lists.newArrayList();
        MINE_BLOCK_STATS = Lists.newArrayList();
        LEAVE_GAME = new StatBasic("stat.leaveGame", new TextComponentTranslation("stat.leaveGame", new Object[0])).initIndependentStat().registerStat();
        PLAY_ONE_MINUTE = new StatBasic("stat.playOneMinute", new TextComponentTranslation("stat.playOneMinute", new Object[0]), StatBase.timeStatType).initIndependentStat().registerStat();
        TIME_SINCE_DEATH = new StatBasic("stat.timeSinceDeath", new TextComponentTranslation("stat.timeSinceDeath", new Object[0]), StatBase.timeStatType).initIndependentStat().registerStat();
        SNEAK_TIME = new StatBasic("stat.sneakTime", new TextComponentTranslation("stat.sneakTime", new Object[0]), StatBase.timeStatType).initIndependentStat().registerStat();
        WALK_ONE_CM = new StatBasic("stat.walkOneCm", new TextComponentTranslation("stat.walkOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        CROUCH_ONE_CM = new StatBasic("stat.crouchOneCm", new TextComponentTranslation("stat.crouchOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        SPRINT_ONE_CM = new StatBasic("stat.sprintOneCm", new TextComponentTranslation("stat.sprintOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        SWIM_ONE_CM = new StatBasic("stat.swimOneCm", new TextComponentTranslation("stat.swimOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        FALL_ONE_CM = new StatBasic("stat.fallOneCm", new TextComponentTranslation("stat.fallOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        CLIMB_ONE_CM = new StatBasic("stat.climbOneCm", new TextComponentTranslation("stat.climbOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        FLY_ONE_CM = new StatBasic("stat.flyOneCm", new TextComponentTranslation("stat.flyOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        DIVE_ONE_CM = new StatBasic("stat.diveOneCm", new TextComponentTranslation("stat.diveOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        MINECART_ONE_CM = new StatBasic("stat.minecartOneCm", new TextComponentTranslation("stat.minecartOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        BOAT_ONE_CM = new StatBasic("stat.boatOneCm", new TextComponentTranslation("stat.boatOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        PIG_ONE_CM = new StatBasic("stat.pigOneCm", new TextComponentTranslation("stat.pigOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        HORSE_ONE_CM = new StatBasic("stat.horseOneCm", new TextComponentTranslation("stat.horseOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        AVIATE_ONE_CM = new StatBasic("stat.aviateOneCm", new TextComponentTranslation("stat.aviateOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
        JUMP = new StatBasic("stat.jump", new TextComponentTranslation("stat.jump", new Object[0])).initIndependentStat().registerStat();
        DROP = new StatBasic("stat.drop", new TextComponentTranslation("stat.drop", new Object[0])).initIndependentStat().registerStat();
        DAMAGE_DEALT = new StatBasic("stat.damageDealt", new TextComponentTranslation("stat.damageDealt", new Object[0]), StatBase.divideByTen).registerStat();
        DAMAGE_TAKEN = new StatBasic("stat.damageTaken", new TextComponentTranslation("stat.damageTaken", new Object[0]), StatBase.divideByTen).registerStat();
        DEATHS = new StatBasic("stat.deaths", new TextComponentTranslation("stat.deaths", new Object[0])).registerStat();
        MOB_KILLS = new StatBasic("stat.mobKills", new TextComponentTranslation("stat.mobKills", new Object[0])).registerStat();
        ANIMALS_BRED = new StatBasic("stat.animalsBred", new TextComponentTranslation("stat.animalsBred", new Object[0])).registerStat();
        PLAYER_KILLS = new StatBasic("stat.playerKills", new TextComponentTranslation("stat.playerKills", new Object[0])).registerStat();
        FISH_CAUGHT = new StatBasic("stat.fishCaught", new TextComponentTranslation("stat.fishCaught", new Object[0])).registerStat();
        TALKED_TO_VILLAGER = new StatBasic("stat.talkedToVillager", new TextComponentTranslation("stat.talkedToVillager", new Object[0])).registerStat();
        TRADED_WITH_VILLAGER = new StatBasic("stat.tradedWithVillager", new TextComponentTranslation("stat.tradedWithVillager", new Object[0])).registerStat();
        CAKE_SLICES_EATEN = new StatBasic("stat.cakeSlicesEaten", new TextComponentTranslation("stat.cakeSlicesEaten", new Object[0])).registerStat();
        CAULDRON_FILLED = new StatBasic("stat.cauldronFilled", new TextComponentTranslation("stat.cauldronFilled", new Object[0])).registerStat();
        CAULDRON_USED = new StatBasic("stat.cauldronUsed", new TextComponentTranslation("stat.cauldronUsed", new Object[0])).registerStat();
        ARMOR_CLEANED = new StatBasic("stat.armorCleaned", new TextComponentTranslation("stat.armorCleaned", new Object[0])).registerStat();
        BANNER_CLEANED = new StatBasic("stat.bannerCleaned", new TextComponentTranslation("stat.bannerCleaned", new Object[0])).registerStat();
        BREWINGSTAND_INTERACTION = new StatBasic("stat.brewingstandInteraction", new TextComponentTranslation("stat.brewingstandInteraction", new Object[0])).registerStat();
        BEACON_INTERACTION = new StatBasic("stat.beaconInteraction", new TextComponentTranslation("stat.beaconInteraction", new Object[0])).registerStat();
        DROPPER_INSPECTED = new StatBasic("stat.dropperInspected", new TextComponentTranslation("stat.dropperInspected", new Object[0])).registerStat();
        HOPPER_INSPECTED = new StatBasic("stat.hopperInspected", new TextComponentTranslation("stat.hopperInspected", new Object[0])).registerStat();
        DISPENSER_INSPECTED = new StatBasic("stat.dispenserInspected", new TextComponentTranslation("stat.dispenserInspected", new Object[0])).registerStat();
        NOTEBLOCK_PLAYED = new StatBasic("stat.noteblockPlayed", new TextComponentTranslation("stat.noteblockPlayed", new Object[0])).registerStat();
        NOTEBLOCK_TUNED = new StatBasic("stat.noteblockTuned", new TextComponentTranslation("stat.noteblockTuned", new Object[0])).registerStat();
        FLOWER_POTTED = new StatBasic("stat.flowerPotted", new TextComponentTranslation("stat.flowerPotted", new Object[0])).registerStat();
        TRAPPED_CHEST_TRIGGERED = new StatBasic("stat.trappedChestTriggered", new TextComponentTranslation("stat.trappedChestTriggered", new Object[0])).registerStat();
        ENDERCHEST_OPENED = new StatBasic("stat.enderchestOpened", new TextComponentTranslation("stat.enderchestOpened", new Object[0])).registerStat();
        ITEM_ENCHANTED = new StatBasic("stat.itemEnchanted", new TextComponentTranslation("stat.itemEnchanted", new Object[0])).registerStat();
        RECORD_PLAYED = new StatBasic("stat.recordPlayed", new TextComponentTranslation("stat.recordPlayed", new Object[0])).registerStat();
        FURNACE_INTERACTION = new StatBasic("stat.furnaceInteraction", new TextComponentTranslation("stat.furnaceInteraction", new Object[0])).registerStat();
        CRAFTING_TABLE_INTERACTION = new StatBasic("stat.craftingTableInteraction", new TextComponentTranslation("stat.workbenchInteraction", new Object[0])).registerStat();
        CHEST_OPENED = new StatBasic("stat.chestOpened", new TextComponentTranslation("stat.chestOpened", new Object[0])).registerStat();
        SLEEP_IN_BED = new StatBasic("stat.sleepInBed", new TextComponentTranslation("stat.sleepInBed", new Object[0])).registerStat();
        field_191272_ae = new StatBasic("stat.shulkerBoxOpened", new TextComponentTranslation("stat.shulkerBoxOpened", new Object[0])).registerStat();
        BLOCKS_STATS = new StatBase[4096];
        CRAFTS_STATS = new StatBase[32000];
        OBJECT_USE_STATS = new StatBase[32000];
        OBJECT_BREAK_STATS = new StatBase[32000];
        OBJECTS_PICKED_UP_STATS = new StatBase[32000];
        OBJECTS_DROPPED_STATS = new StatBase[32000];
    }
    
    @Nullable
    public static StatBase getOneShotStat(final String lllllllllllllIIlIllIlIIIllIIIIIl) {
        return StatList.ID_TO_STAT_MAP.get(lllllllllllllIIlIllIlIIIllIIIIIl);
    }
    
    private static void initCraftableStats() {
        final Set<Item> lllllllllllllIIlIllIlIIlIIlIIIlI = (Set<Item>)Sets.newHashSet();
        for (final IRecipe lllllllllllllIIlIllIlIIlIIlIIIIl : CraftingManager.field_193380_a) {
            final ItemStack lllllllllllllIIlIllIlIIlIIlIIIII = lllllllllllllIIlIllIlIIlIIlIIIIl.getRecipeOutput();
            if (!lllllllllllllIIlIllIlIIlIIlIIIII.func_190926_b()) {
                lllllllllllllIIlIllIlIIlIIlIIIlI.add(lllllllllllllIIlIllIlIIlIIlIIIIl.getRecipeOutput().getItem());
            }
        }
        for (final ItemStack lllllllllllllIIlIllIlIIlIIIlllll : FurnaceRecipes.instance().getSmeltingList().values()) {
            lllllllllllllIIlIllIlIIlIIlIIIlI.add(lllllllllllllIIlIllIlIIlIIIlllll.getItem());
        }
        for (final Item lllllllllllllIIlIllIlIIlIIIllllI : lllllllllllllIIlIllIlIIlIIlIIIlI) {
            if (lllllllllllllIIlIllIlIIlIIIllllI != null) {
                final int lllllllllllllIIlIllIlIIlIIIlllIl = Item.getIdFromItem(lllllllllllllIIlIllIlIIlIIIllllI);
                final String lllllllllllllIIlIllIlIIlIIIlllII = getItemName(lllllllllllllIIlIllIlIIlIIIllllI);
                if (lllllllllllllIIlIllIlIIlIIIlllII == null) {
                    continue;
                }
                StatList.CRAFTS_STATS[lllllllllllllIIlIllIlIIlIIIlllIl] = new StatCrafting("stat.craftItem.", lllllllllllllIIlIllIlIIlIIIlllII, new TextComponentTranslation("stat.craftItem", new Object[] { new ItemStack(lllllllllllllIIlIllIlIIlIIIllllI).getTextComponent() }), lllllllllllllIIlIllIlIIlIIIllllI).registerStat();
            }
        }
        replaceAllSimilarBlocks(StatList.CRAFTS_STATS);
    }
    
    private static void initStats() {
        for (final Item lllllllllllllIIlIllIlIIlIIIIIlII : Item.REGISTRY) {
            if (lllllllllllllIIlIllIlIIlIIIIIlII != null) {
                final int lllllllllllllIIlIllIlIIlIIIIIIll = Item.getIdFromItem(lllllllllllllIIlIllIlIIlIIIIIlII);
                final String lllllllllllllIIlIllIlIIlIIIIIIlI = getItemName(lllllllllllllIIlIllIlIIlIIIIIlII);
                if (lllllllllllllIIlIllIlIIlIIIIIIlI == null) {
                    continue;
                }
                StatList.OBJECT_USE_STATS[lllllllllllllIIlIllIlIIlIIIIIIll] = new StatCrafting("stat.useItem.", lllllllllllllIIlIllIlIIlIIIIIIlI, new TextComponentTranslation("stat.useItem", new Object[] { new ItemStack(lllllllllllllIIlIllIlIIlIIIIIlII).getTextComponent() }), lllllllllllllIIlIllIlIIlIIIIIlII).registerStat();
                if (lllllllllllllIIlIllIlIIlIIIIIlII instanceof ItemBlock) {
                    continue;
                }
                StatList.USE_ITEM_STATS.add((StatCrafting)StatList.OBJECT_USE_STATS[lllllllllllllIIlIllIlIIlIIIIIIll]);
            }
        }
        replaceAllSimilarBlocks(StatList.OBJECT_USE_STATS);
    }
}
