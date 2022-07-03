package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.potion.*;
import java.util.*;
import com.google.common.collect.*;

public class ItemFishFood extends ItemFood
{
    private final /* synthetic */ boolean cooked;
    
    @Override
    public void getSubItems(final CreativeTabs lllllllllllllIIIllIlIllIIlllIlll, final NonNullList<ItemStack> lllllllllllllIIIllIlIllIIlllIllI) {
        if (this.func_194125_a(lllllllllllllIIIllIlIllIIlllIlll)) {
            final short lllllllllllllIIIllIlIllIIllIlllI;
            final int lllllllllllllIIIllIlIllIIllIllll = ((FishType[])(Object)(lllllllllllllIIIllIlIllIIllIlllI = (short)(Object)FishType.values())).length;
            for (byte lllllllllllllIIIllIlIllIIlllIIII = 0; lllllllllllllIIIllIlIllIIlllIIII < lllllllllllllIIIllIlIllIIllIllll; ++lllllllllllllIIIllIlIllIIlllIIII) {
                final FishType lllllllllllllIIIllIlIllIIlllIlIl = lllllllllllllIIIllIlIllIIllIlllI[lllllllllllllIIIllIlIllIIlllIIII];
                if (!this.cooked || lllllllllllllIIIllIlIllIIlllIlIl.canCook()) {
                    lllllllllllllIIIllIlIllIIlllIllI.add(new ItemStack(this, 1, lllllllllllllIIIllIlIllIIlllIlIl.getMetadata()));
                }
            }
        }
    }
    
    @Override
    protected void onFoodEaten(final ItemStack lllllllllllllIIIllIlIllIlIIIIIll, final World lllllllllllllIIIllIlIllIlIIIIlll, final EntityPlayer lllllllllllllIIIllIlIllIlIIIIllI) {
        final FishType lllllllllllllIIIllIlIllIlIIIIlIl = FishType.byItemStack(lllllllllllllIIIllIlIllIlIIIIIll);
        if (lllllllllllllIIIllIlIllIlIIIIlIl == FishType.PUFFERFISH) {
            lllllllllllllIIIllIlIllIlIIIIllI.addPotionEffect(new PotionEffect(MobEffects.POISON, 1200, 3));
            lllllllllllllIIIllIlIllIlIIIIllI.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 300, 2));
            lllllllllllllIIIllIlIllIlIIIIllI.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 300, 1));
        }
        super.onFoodEaten(lllllllllllllIIIllIlIllIlIIIIIll, lllllllllllllIIIllIlIllIlIIIIlll, lllllllllllllIIIllIlIllIlIIIIllI);
    }
    
    public ItemFishFood(final boolean lllllllllllllIIIllIlIllIlIlIIIIl) {
        super(0, 0.0f, false);
        this.cooked = lllllllllllllIIIllIlIllIlIlIIIIl;
    }
    
    @Override
    public String getUnlocalizedName(final ItemStack lllllllllllllIIIllIlIllIIllIlIIl) {
        final FishType lllllllllllllIIIllIlIllIIllIlIII = FishType.byItemStack(lllllllllllllIIIllIlIllIIllIlIIl);
        return String.valueOf(new StringBuilder(String.valueOf(this.getUnlocalizedName())).append(".").append(lllllllllllllIIIllIlIllIIllIlIII.getUnlocalizedName()).append(".").append((this.cooked && lllllllllllllIIIllIlIllIIllIlIII.canCook()) ? "cooked" : "raw"));
    }
    
    @Override
    public int getHealAmount(final ItemStack lllllllllllllIIIllIlIllIlIIlllII) {
        final FishType lllllllllllllIIIllIlIllIlIIllIll = FishType.byItemStack(lllllllllllllIIIllIlIllIlIIlllII);
        return (this.cooked && lllllllllllllIIIllIlIllIlIIllIll.canCook()) ? lllllllllllllIIIllIlIllIlIIllIll.getCookedHealAmount() : lllllllllllllIIIllIlIllIlIIllIll.getUncookedHealAmount();
    }
    
    @Override
    public float getSaturationModifier(final ItemStack lllllllllllllIIIllIlIllIlIIlIIII) {
        final FishType lllllllllllllIIIllIlIllIlIIlIIlI = FishType.byItemStack(lllllllllllllIIIllIlIllIlIIlIIII);
        return (this.cooked && lllllllllllllIIIllIlIllIlIIlIIlI.canCook()) ? lllllllllllllIIIllIlIllIlIIlIIlI.getCookedSaturationModifier() : lllllllllllllIIIllIlIllIlIIlIIlI.getUncookedSaturationModifier();
    }
    
    public enum FishType
    {
        SALMON("SALMON", 1, 1, "salmon", 2, 0.1f, 6, 0.8f);
        
        private final /* synthetic */ String unlocalizedName;
        
        CLOWNFISH("CLOWNFISH", 2, 2, "clownfish", 1, 0.1f);
        
        private final /* synthetic */ boolean cookable;
        private final /* synthetic */ float cookedSaturationModifier;
        private static final /* synthetic */ Map<Integer, FishType> META_LOOKUP;
        
        COD("COD", 0, 0, "cod", 2, 0.1f, 5, 0.6f);
        
        private final /* synthetic */ int cookedHealAmount;
        private final /* synthetic */ int uncookedHealAmount;
        private final /* synthetic */ float uncookedSaturationModifier;
        
        PUFFERFISH("PUFFERFISH", 3, 3, "pufferfish", 1, 0.1f);
        
        private final /* synthetic */ int meta;
        
        public int getUncookedHealAmount() {
            return this.uncookedHealAmount;
        }
        
        public float getCookedSaturationModifier() {
            return this.cookedSaturationModifier;
        }
        
        private FishType(final String lllllllllllllIlIIIIlllIllllIIIll, final int lllllllllllllIlIIIIlllIllllIIIlI, final int lllllllllllllIlIIIIlllIllllIlIII, final String lllllllllllllIlIIIIlllIllllIIIII, final int lllllllllllllIlIIIIlllIlllIlllll, final float lllllllllllllIlIIIIlllIllllIIlIl) {
            this.meta = lllllllllllllIlIIIIlllIllllIlIII;
            this.unlocalizedName = lllllllllllllIlIIIIlllIllllIIIII;
            this.uncookedHealAmount = lllllllllllllIlIIIIlllIlllIlllll;
            this.uncookedSaturationModifier = lllllllllllllIlIIIIlllIllllIIlIl;
            this.cookedHealAmount = 0;
            this.cookedSaturationModifier = 0.0f;
            this.cookable = false;
        }
        
        public static FishType byItemStack(final ItemStack lllllllllllllIlIIIIlllIlllIIIIII) {
            return (lllllllllllllIlIIIIlllIlllIIIIII.getItem() instanceof ItemFishFood) ? byMetadata(lllllllllllllIlIIIIlllIlllIIIIII.getMetadata()) : FishType.COD;
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        static {
            META_LOOKUP = Maps.newHashMap();
            final int lllllllllllllIlIIIIllllIIIIIlIlI;
            final long lllllllllllllIlIIIIllllIIIIIlIll = ((FishType[])(Object)(lllllllllllllIlIIIIllllIIIIIlIlI = (int)(Object)values())).length;
            for (double lllllllllllllIlIIIIllllIIIIIllII = 0; lllllllllllllIlIIIIllllIIIIIllII < lllllllllllllIlIIIIllllIIIIIlIll; ++lllllllllllllIlIIIIllllIIIIIllII) {
                final FishType lllllllllllllIlIIIIllllIIIIIlllI = lllllllllllllIlIIIIllllIIIIIlIlI[lllllllllllllIlIIIIllllIIIIIllII];
                FishType.META_LOOKUP.put(lllllllllllllIlIIIIllllIIIIIlllI.getMetadata(), lllllllllllllIlIIIIllllIIIIIlllI);
            }
        }
        
        public static FishType byMetadata(final int lllllllllllllIlIIIIlllIlllIIIllI) {
            final FishType lllllllllllllIlIIIIlllIlllIIIlIl = FishType.META_LOOKUP.get(lllllllllllllIlIIIIlllIlllIIIllI);
            return (lllllllllllllIlIIIIlllIlllIIIlIl == null) ? FishType.COD : lllllllllllllIlIIIIlllIlllIIIlIl;
        }
        
        public float getUncookedSaturationModifier() {
            return this.uncookedSaturationModifier;
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
        
        public boolean canCook() {
            return this.cookable;
        }
        
        public int getCookedHealAmount() {
            return this.cookedHealAmount;
        }
        
        private FishType(final String lllllllllllllIlIIIIlllIllllllIII, final int lllllllllllllIlIIIIlllIlllllIlll, final int lllllllllllllIlIIIIlllIlllllllll, final String lllllllllllllIlIIIIlllIllllllllI, final int lllllllllllllIlIIIIlllIlllllllIl, final float lllllllllllllIlIIIIlllIlllllIIll, final int lllllllllllllIlIIIIlllIllllllIll, final float lllllllllllllIlIIIIlllIlllllIIIl) {
            this.meta = lllllllllllllIlIIIIlllIlllllllll;
            this.unlocalizedName = lllllllllllllIlIIIIlllIllllllllI;
            this.uncookedHealAmount = lllllllllllllIlIIIIlllIlllllllIl;
            this.uncookedSaturationModifier = lllllllllllllIlIIIIlllIlllllIIll;
            this.cookedHealAmount = lllllllllllllIlIIIIlllIllllllIll;
            this.cookedSaturationModifier = lllllllllllllIlIIIIlllIlllllIIIl;
            this.cookable = true;
        }
    }
}
