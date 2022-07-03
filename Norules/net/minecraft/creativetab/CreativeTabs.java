package net.minecraft.creativetab;

import net.minecraft.enchantment.*;
import javax.annotation.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;

public abstract class CreativeTabs
{
    private final /* synthetic */ String tabLabel;
    private /* synthetic */ boolean drawTitle;
    private final /* synthetic */ int tabIndex;
    private /* synthetic */ String theTexture;
    private /* synthetic */ boolean hasScrollbar;
    private /* synthetic */ EnumEnchantmentType[] enchantmentTypes;
    private /* synthetic */ ItemStack iconItemStack;
    public static final /* synthetic */ CreativeTabs[] CREATIVE_TAB_ARRAY;
    public static final /* synthetic */ CreativeTabs MISC;
    
    public int getTabIndex() {
        return this.tabIndex;
    }
    
    public boolean isTabInFirstRow() {
        return this.tabIndex < 6;
    }
    
    public String getTranslatedTabLabel() {
        return String.valueOf(new StringBuilder("itemGroup.").append(this.getTabLabel()));
    }
    
    public boolean hasRelevantEnchantmentType(@Nullable final EnumEnchantmentType llllllllllllllIlllIIIlllIIlllIIl) {
        if (llllllllllllllIlllIIIlllIIlllIIl != null) {
            final int llllllllllllllIlllIIIlllIIllIIlI;
            final int llllllllllllllIlllIIIlllIIllIIll = ((EnumEnchantmentType[])(Object)(llllllllllllllIlllIIIlllIIllIIlI = (int)(Object)this.enchantmentTypes)).length;
            for (String llllllllllllllIlllIIIlllIIllIlII = (String)0; llllllllllllllIlllIIIlllIIllIlII < llllllllllllllIlllIIIlllIIllIIll; ++llllllllllllllIlllIIIlllIIllIlII) {
                final EnumEnchantmentType llllllllllllllIlllIIIlllIIlllIII = llllllllllllllIlllIIIlllIIllIIlI[llllllllllllllIlllIIIlllIIllIlII];
                if (llllllllllllllIlllIIIlllIIlllIII == llllllllllllllIlllIIIlllIIlllIIl) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public int getTabColumn() {
        return this.tabIndex % 6;
    }
    
    public String getBackgroundImageName() {
        return this.theTexture;
    }
    
    public CreativeTabs setBackgroundImageName(final String llllllllllllllIlllIIIlllIllIIIIl) {
        this.theTexture = llllllllllllllIlllIIIlllIllIIIIl;
        return this;
    }
    
    public boolean shouldHidePlayerInventory() {
        return this.hasScrollbar;
    }
    
    public CreativeTabs setNoScrollbar() {
        this.hasScrollbar = false;
        return this;
    }
    
    public EnumEnchantmentType[] getRelevantEnchantmentTypes() {
        return this.enchantmentTypes;
    }
    
    public CreativeTabs(final int llllllllllllllIlllIIIlllIllllIII, final String llllllllllllllIlllIIIlllIlllIlII) {
        this.theTexture = "items.png";
        this.hasScrollbar = true;
        this.drawTitle = true;
        this.enchantmentTypes = new EnumEnchantmentType[0];
        this.tabIndex = llllllllllllllIlllIIIlllIllllIII;
        this.tabLabel = llllllllllllllIlllIIIlllIlllIlII;
        this.iconItemStack = ItemStack.field_190927_a;
        CreativeTabs.CREATIVE_TAB_ARRAY[llllllllllllllIlllIIIlllIllllIII] = this;
    }
    
    public ItemStack getIconItemStack() {
        if (this.iconItemStack.func_190926_b()) {
            this.iconItemStack = this.getTabIconItem();
        }
        return this.iconItemStack;
    }
    
    public boolean drawInForegroundOfTab() {
        return this.drawTitle;
    }
    
    public CreativeTabs setRelevantEnchantmentTypes(final EnumEnchantmentType... llllllllllllllIlllIIIlllIlIIIIll) {
        this.enchantmentTypes = llllllllllllllIlllIIIlllIlIIIIll;
        return this;
    }
    
    public boolean func_192394_m() {
        return this.getTabColumn() == 5;
    }
    
    static {
        CREATIVE_TAB_ARRAY = new CreativeTabs[12];
        BUILDING_BLOCKS = new CreativeTabs("buildingBlocks") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Item.getItemFromBlock(Blocks.BRICK_BLOCK));
            }
        };
        DECORATIONS = new CreativeTabs("decorations") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Item.getItemFromBlock(Blocks.DOUBLE_PLANT), 1, BlockDoublePlant.EnumPlantType.PAEONIA.getMeta());
            }
        };
        REDSTONE = new CreativeTabs("redstone") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Items.REDSTONE);
            }
        };
        TRANSPORTATION = new CreativeTabs("transportation") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Item.getItemFromBlock(Blocks.GOLDEN_RAIL));
            }
        };
        MISC = new CreativeTabs("misc") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Items.LAVA_BUCKET);
            }
        };
        SEARCH = new CreativeTabs("search") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Items.COMPASS);
            }
        }.setBackgroundImageName("item_search.png");
        FOOD = new CreativeTabs("food") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Items.APPLE);
            }
        };
        TOOLS = new CreativeTabs("tools") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Items.IRON_AXE);
            }
        }.setRelevantEnchantmentTypes(EnumEnchantmentType.ALL, EnumEnchantmentType.DIGGER, EnumEnchantmentType.FISHING_ROD, EnumEnchantmentType.BREAKABLE);
        COMBAT = new CreativeTabs("combat") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Items.GOLDEN_SWORD);
            }
        }.setRelevantEnchantmentTypes(EnumEnchantmentType.ALL, EnumEnchantmentType.ARMOR, EnumEnchantmentType.ARMOR_FEET, EnumEnchantmentType.ARMOR_HEAD, EnumEnchantmentType.ARMOR_LEGS, EnumEnchantmentType.ARMOR_CHEST, EnumEnchantmentType.BOW, EnumEnchantmentType.WEAPON, EnumEnchantmentType.WEARABLE, EnumEnchantmentType.BREAKABLE);
        BREWING = new CreativeTabs("brewing") {
            @Override
            public ItemStack getTabIconItem() {
                return PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER);
            }
        };
        MATERIALS = CreativeTabs.MISC;
        field_192395_m = new CreativeTabs("hotbar") {
            @Override
            public boolean func_192394_m() {
                return true;
            }
            
            @Override
            public void displayAllRelevantItems(final NonNullList<ItemStack> lIllllIllIIllll) {
                throw new RuntimeException("Implement exception client-side.");
            }
            
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Blocks.BOOKSHELF);
            }
        };
        INVENTORY = new CreativeTabs("inventory") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Item.getItemFromBlock(Blocks.CHEST));
            }
        }.setBackgroundImageName("inventory.png").setNoScrollbar().setNoTitle();
    }
    
    public abstract ItemStack getTabIconItem();
    
    public CreativeTabs setNoTitle() {
        this.drawTitle = false;
        return this;
    }
    
    public String getTabLabel() {
        return this.tabLabel;
    }
    
    public void displayAllRelevantItems(final NonNullList<ItemStack> llllllllllllllIlllIIIlllIIlIlIIl) {
        for (final Item llllllllllllllIlllIIIlllIIlIlIll : Item.REGISTRY) {
            llllllllllllllIlllIIIlllIIlIlIll.getSubItems(this, llllllllllllllIlllIIIlllIIlIlIIl);
        }
    }
}
