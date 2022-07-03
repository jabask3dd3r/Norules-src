package net.minecraft.item.crafting;

import java.util.*;
import com.google.common.collect.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.item.*;

public class FurnaceRecipes
{
    private static final /* synthetic */ FurnaceRecipes SMELTING_BASE;
    private final /* synthetic */ Map<ItemStack, ItemStack> smeltingList;
    private final /* synthetic */ Map<ItemStack, Float> experienceList;
    
    public static FurnaceRecipes instance() {
        return FurnaceRecipes.SMELTING_BASE;
    }
    
    public void addSmeltingRecipe(final ItemStack lllllllllllllllllIIIlIIlIIIIlIll, final ItemStack lllllllllllllllllIIIlIIlIIIIlIlI, final float lllllllllllllllllIIIlIIlIIIIlIIl) {
        this.smeltingList.put(lllllllllllllllllIIIlIIlIIIIlIll, lllllllllllllllllIIIlIIlIIIIlIlI);
        this.experienceList.put(lllllllllllllllllIIIlIIlIIIIlIlI, lllllllllllllllllIIIlIIlIIIIlIIl);
    }
    
    public void addSmelting(final Item lllllllllllllllllIIIlIIlIIIllIll, final ItemStack lllllllllllllllllIIIlIIlIIIlIllI, final float lllllllllllllllllIIIlIIlIIIllIIl) {
        this.addSmeltingRecipe(new ItemStack(lllllllllllllllllIIIlIIlIIIllIll, 1, 32767), lllllllllllllllllIIIlIIlIIIlIllI, lllllllllllllllllIIIlIIlIIIllIIl);
    }
    
    public Map<ItemStack, ItemStack> getSmeltingList() {
        return this.smeltingList;
    }
    
    public float getSmeltingExperience(final ItemStack lllllllllllllllllIIIlIIIlllIlIll) {
        for (final Map.Entry<ItemStack, Float> lllllllllllllllllIIIlIIIlllIllIl : this.experienceList.entrySet()) {
            if (this.compareItemStacks(lllllllllllllllllIIIlIIIlllIlIll, lllllllllllllllllIIIlIIIlllIllIl.getKey())) {
                return lllllllllllllllllIIIlIIIlllIllIl.getValue();
            }
        }
        return 0.0f;
    }
    
    private FurnaceRecipes() {
        this.smeltingList = (Map<ItemStack, ItemStack>)Maps.newHashMap();
        this.experienceList = (Map<ItemStack, Float>)Maps.newHashMap();
        this.addSmeltingRecipeForBlock(Blocks.IRON_ORE, new ItemStack(Items.IRON_INGOT), 0.7f);
        this.addSmeltingRecipeForBlock(Blocks.GOLD_ORE, new ItemStack(Items.GOLD_INGOT), 1.0f);
        this.addSmeltingRecipeForBlock(Blocks.DIAMOND_ORE, new ItemStack(Items.DIAMOND), 1.0f);
        this.addSmeltingRecipeForBlock(Blocks.SAND, new ItemStack(Blocks.GLASS), 0.1f);
        this.addSmelting(Items.PORKCHOP, new ItemStack(Items.COOKED_PORKCHOP), 0.35f);
        this.addSmelting(Items.BEEF, new ItemStack(Items.COOKED_BEEF), 0.35f);
        this.addSmelting(Items.CHICKEN, new ItemStack(Items.COOKED_CHICKEN), 0.35f);
        this.addSmelting(Items.RABBIT, new ItemStack(Items.COOKED_RABBIT), 0.35f);
        this.addSmelting(Items.MUTTON, new ItemStack(Items.COOKED_MUTTON), 0.35f);
        this.addSmeltingRecipeForBlock(Blocks.COBBLESTONE, new ItemStack(Blocks.STONE), 0.1f);
        this.addSmeltingRecipe(new ItemStack(Blocks.STONEBRICK, 1, BlockStoneBrick.DEFAULT_META), new ItemStack(Blocks.STONEBRICK, 1, BlockStoneBrick.CRACKED_META), 0.1f);
        this.addSmelting(Items.CLAY_BALL, new ItemStack(Items.BRICK), 0.3f);
        this.addSmeltingRecipeForBlock(Blocks.CLAY, new ItemStack(Blocks.HARDENED_CLAY), 0.35f);
        this.addSmeltingRecipeForBlock(Blocks.CACTUS, new ItemStack(Items.DYE, 1, EnumDyeColor.GREEN.getDyeDamage()), 0.2f);
        this.addSmeltingRecipeForBlock(Blocks.LOG, new ItemStack(Items.COAL, 1, 1), 0.15f);
        this.addSmeltingRecipeForBlock(Blocks.LOG2, new ItemStack(Items.COAL, 1, 1), 0.15f);
        this.addSmeltingRecipeForBlock(Blocks.EMERALD_ORE, new ItemStack(Items.EMERALD), 1.0f);
        this.addSmelting(Items.POTATO, new ItemStack(Items.BAKED_POTATO), 0.35f);
        this.addSmeltingRecipeForBlock(Blocks.NETHERRACK, new ItemStack(Items.NETHERBRICK), 0.1f);
        this.addSmeltingRecipe(new ItemStack(Blocks.SPONGE, 1, 1), new ItemStack(Blocks.SPONGE, 1, 0), 0.15f);
        this.addSmelting(Items.CHORUS_FRUIT, new ItemStack(Items.CHORUS_FRUIT_POPPED), 0.1f);
        final float lllllllllllllllllIIIlIIlIIlIllIl;
        final String lllllllllllllllllIIIlIIlIIlIlllI = (String)((ItemFishFood.FishType[])(Object)(lllllllllllllllllIIIlIIlIIlIllIl = (float)(Object)ItemFishFood.FishType.values())).length;
        for (long lllllllllllllllllIIIlIIlIIlIllll = 0; lllllllllllllllllIIIlIIlIIlIllll < lllllllllllllllllIIIlIIlIIlIlllI; ++lllllllllllllllllIIIlIIlIIlIllll) {
            final ItemFishFood.FishType lllllllllllllllllIIIlIIlIIllIIlI = lllllllllllllllllIIIlIIlIIlIllIl[lllllllllllllllllIIIlIIlIIlIllll];
            if (lllllllllllllllllIIIlIIlIIllIIlI.canCook()) {
                this.addSmeltingRecipe(new ItemStack(Items.FISH, 1, lllllllllllllllllIIIlIIlIIllIIlI.getMetadata()), new ItemStack(Items.COOKED_FISH, 1, lllllllllllllllllIIIlIIlIIllIIlI.getMetadata()), 0.35f);
            }
        }
        this.addSmeltingRecipeForBlock(Blocks.COAL_ORE, new ItemStack(Items.COAL), 0.1f);
        this.addSmeltingRecipeForBlock(Blocks.REDSTONE_ORE, new ItemStack(Items.REDSTONE), 0.7f);
        this.addSmeltingRecipeForBlock(Blocks.LAPIS_ORE, new ItemStack(Items.DYE, 1, EnumDyeColor.BLUE.getDyeDamage()), 0.2f);
        this.addSmeltingRecipeForBlock(Blocks.QUARTZ_ORE, new ItemStack(Items.QUARTZ), 0.2f);
        this.addSmelting(Items.CHAINMAIL_HELMET, new ItemStack(Items.field_191525_da), 0.1f);
        this.addSmelting(Items.CHAINMAIL_CHESTPLATE, new ItemStack(Items.field_191525_da), 0.1f);
        this.addSmelting(Items.CHAINMAIL_LEGGINGS, new ItemStack(Items.field_191525_da), 0.1f);
        this.addSmelting(Items.CHAINMAIL_BOOTS, new ItemStack(Items.field_191525_da), 0.1f);
        this.addSmelting(Items.IRON_PICKAXE, new ItemStack(Items.field_191525_da), 0.1f);
        this.addSmelting(Items.IRON_SHOVEL, new ItemStack(Items.field_191525_da), 0.1f);
        this.addSmelting(Items.IRON_AXE, new ItemStack(Items.field_191525_da), 0.1f);
        this.addSmelting(Items.IRON_HOE, new ItemStack(Items.field_191525_da), 0.1f);
        this.addSmelting(Items.IRON_SWORD, new ItemStack(Items.field_191525_da), 0.1f);
        this.addSmelting(Items.IRON_HELMET, new ItemStack(Items.field_191525_da), 0.1f);
        this.addSmelting(Items.IRON_CHESTPLATE, new ItemStack(Items.field_191525_da), 0.1f);
        this.addSmelting(Items.IRON_LEGGINGS, new ItemStack(Items.field_191525_da), 0.1f);
        this.addSmelting(Items.IRON_BOOTS, new ItemStack(Items.field_191525_da), 0.1f);
        this.addSmelting(Items.IRON_HORSE_ARMOR, new ItemStack(Items.field_191525_da), 0.1f);
        this.addSmelting(Items.GOLDEN_PICKAXE, new ItemStack(Items.GOLD_NUGGET), 0.1f);
        this.addSmelting(Items.GOLDEN_SHOVEL, new ItemStack(Items.GOLD_NUGGET), 0.1f);
        this.addSmelting(Items.GOLDEN_AXE, new ItemStack(Items.GOLD_NUGGET), 0.1f);
        this.addSmelting(Items.GOLDEN_HOE, new ItemStack(Items.GOLD_NUGGET), 0.1f);
        this.addSmelting(Items.GOLDEN_SWORD, new ItemStack(Items.GOLD_NUGGET), 0.1f);
        this.addSmelting(Items.GOLDEN_HELMET, new ItemStack(Items.GOLD_NUGGET), 0.1f);
        this.addSmelting(Items.GOLDEN_CHESTPLATE, new ItemStack(Items.GOLD_NUGGET), 0.1f);
        this.addSmelting(Items.GOLDEN_LEGGINGS, new ItemStack(Items.GOLD_NUGGET), 0.1f);
        this.addSmelting(Items.GOLDEN_BOOTS, new ItemStack(Items.GOLD_NUGGET), 0.1f);
        this.addSmelting(Items.GOLDEN_HORSE_ARMOR, new ItemStack(Items.GOLD_NUGGET), 0.1f);
        this.addSmeltingRecipe(new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.WHITE.getMetadata()), new ItemStack(Blocks.field_192427_dB), 0.1f);
        this.addSmeltingRecipe(new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.ORANGE.getMetadata()), new ItemStack(Blocks.field_192428_dC), 0.1f);
        this.addSmeltingRecipe(new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.MAGENTA.getMetadata()), new ItemStack(Blocks.field_192429_dD), 0.1f);
        this.addSmeltingRecipe(new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.LIGHT_BLUE.getMetadata()), new ItemStack(Blocks.field_192430_dE), 0.1f);
        this.addSmeltingRecipe(new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.YELLOW.getMetadata()), new ItemStack(Blocks.field_192431_dF), 0.1f);
        this.addSmeltingRecipe(new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.LIME.getMetadata()), new ItemStack(Blocks.field_192432_dG), 0.1f);
        this.addSmeltingRecipe(new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.PINK.getMetadata()), new ItemStack(Blocks.field_192433_dH), 0.1f);
        this.addSmeltingRecipe(new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.GRAY.getMetadata()), new ItemStack(Blocks.field_192434_dI), 0.1f);
        this.addSmeltingRecipe(new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.SILVER.getMetadata()), new ItemStack(Blocks.field_192435_dJ), 0.1f);
        this.addSmeltingRecipe(new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.CYAN.getMetadata()), new ItemStack(Blocks.field_192436_dK), 0.1f);
        this.addSmeltingRecipe(new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.PURPLE.getMetadata()), new ItemStack(Blocks.field_192437_dL), 0.1f);
        this.addSmeltingRecipe(new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.BLUE.getMetadata()), new ItemStack(Blocks.field_192438_dM), 0.1f);
        this.addSmeltingRecipe(new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.BROWN.getMetadata()), new ItemStack(Blocks.field_192439_dN), 0.1f);
        this.addSmeltingRecipe(new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.GREEN.getMetadata()), new ItemStack(Blocks.field_192440_dO), 0.1f);
        this.addSmeltingRecipe(new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.RED.getMetadata()), new ItemStack(Blocks.field_192441_dP), 0.1f);
        this.addSmeltingRecipe(new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.BLACK.getMetadata()), new ItemStack(Blocks.field_192442_dQ), 0.1f);
    }
    
    public ItemStack getSmeltingResult(final ItemStack lllllllllllllllllIIIlIIlIIIIIIII) {
        for (final Map.Entry<ItemStack, ItemStack> lllllllllllllllllIIIlIIlIIIIIIlI : this.smeltingList.entrySet()) {
            if (this.compareItemStacks(lllllllllllllllllIIIlIIlIIIIIIII, lllllllllllllllllIIIlIIlIIIIIIlI.getKey())) {
                return lllllllllllllllllIIIlIIlIIIIIIlI.getValue();
            }
        }
        return ItemStack.field_190927_a;
    }
    
    private boolean compareItemStacks(final ItemStack lllllllllllllllllIIIlIIIlllllIII, final ItemStack lllllllllllllllllIIIlIIIlllllIIl) {
        return lllllllllllllllllIIIlIIIlllllIIl.getItem() == lllllllllllllllllIIIlIIIlllllIII.getItem() && (lllllllllllllllllIIIlIIIlllllIIl.getMetadata() == 32767 || lllllllllllllllllIIIlIIIlllllIIl.getMetadata() == lllllllllllllllllIIIlIIIlllllIII.getMetadata());
    }
    
    public void addSmeltingRecipeForBlock(final Block lllllllllllllllllIIIlIIlIIlIIlll, final ItemStack lllllllllllllllllIIIlIIlIIlIIllI, final float lllllllllllllllllIIIlIIlIIlIIlIl) {
        this.addSmelting(Item.getItemFromBlock(lllllllllllllllllIIIlIIlIIlIIlll), lllllllllllllllllIIIlIIlIIlIIllI, lllllllllllllllllIIIlIIlIIlIIlIl);
    }
    
    static {
        SMELTING_BASE = new FurnaceRecipes();
    }
}
