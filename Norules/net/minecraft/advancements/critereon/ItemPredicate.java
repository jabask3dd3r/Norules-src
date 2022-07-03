package net.minecraft.advancements.critereon;

import net.minecraft.item.*;
import net.minecraft.potion.*;
import java.util.*;
import net.minecraft.enchantment.*;
import javax.annotation.*;
import net.minecraft.util.*;
import com.google.gson.*;

public class ItemPredicate
{
    private final /* synthetic */ PotionType field_192500_f;
    private final /* synthetic */ EnchantmentPredicate[] field_192499_e;
    private final /* synthetic */ MinMaxBounds field_192498_d;
    private final /* synthetic */ Item field_192496_b;
    private final /* synthetic */ Integer field_192497_c;
    public static final /* synthetic */ ItemPredicate field_192495_a;
    private final /* synthetic */ MinMaxBounds field_193444_e;
    private final /* synthetic */ NBTPredicate field_193445_h;
    
    public boolean func_192493_a(final ItemStack llllllllllllIllllllIlIIlIIIlIllI) {
        if (this.field_192496_b != null && llllllllllllIllllllIlIIlIIIlIllI.getItem() != this.field_192496_b) {
            return false;
        }
        if (this.field_192497_c != null && llllllllllllIllllllIlIIlIIIlIllI.getMetadata() != this.field_192497_c) {
            return false;
        }
        if (!this.field_192498_d.func_192514_a((float)llllllllllllIllllllIlIIlIIIlIllI.func_190916_E())) {
            return false;
        }
        if (this.field_193444_e != MinMaxBounds.field_192516_a && !llllllllllllIllllllIlIIlIIIlIllI.isItemStackDamageable()) {
            return false;
        }
        if (!this.field_193444_e.func_192514_a((float)(llllllllllllIllllllIlIIlIIIlIllI.getMaxDamage() - llllllllllllIllllllIlIIlIIIlIllI.getItemDamage()))) {
            return false;
        }
        if (!this.field_193445_h.func_193478_a(llllllllllllIllllllIlIIlIIIlIllI)) {
            return false;
        }
        final Map<Enchantment, Integer> llllllllllllIllllllIlIIlIIIllIlI = EnchantmentHelper.getEnchantments(llllllllllllIllllllIlIIlIIIlIllI);
        for (int llllllllllllIllllllIlIIlIIIllIIl = 0; llllllllllllIllllllIlIIlIIIllIIl < this.field_192499_e.length; ++llllllllllllIllllllIlIIlIIIllIIl) {
            if (!this.field_192499_e[llllllllllllIllllllIlIIlIIIllIIl].func_192463_a(llllllllllllIllllllIlIIlIIIllIlI)) {
                return false;
            }
        }
        final PotionType llllllllllllIllllllIlIIlIIIllIII = PotionUtils.getPotionFromItem(llllllllllllIllllllIlIIlIIIlIllI);
        return this.field_192500_f == null || this.field_192500_f == llllllllllllIllllllIlIIlIIIllIII;
    }
    
    public static ItemPredicate func_192492_a(@Nullable final JsonElement llllllllllllIllllllIlIIlIIIIlIIl) {
        if (llllllllllllIllllllIlIIlIIIIlIIl != null && !llllllllllllIllllllIlIIlIIIIlIIl.isJsonNull()) {
            final JsonObject llllllllllllIllllllIlIIlIIIIlIII = JsonUtils.getJsonObject(llllllllllllIllllllIlIIlIIIIlIIl, "item");
            final MinMaxBounds llllllllllllIllllllIlIIlIIIIIlll = MinMaxBounds.func_192515_a(llllllllllllIllllllIlIIlIIIIlIII.get("count"));
            final MinMaxBounds llllllllllllIllllllIlIIlIIIIIllI = MinMaxBounds.func_192515_a(llllllllllllIllllllIlIIlIIIIlIII.get("durability"));
            final Integer llllllllllllIllllllIlIIlIIIIIlIl = llllllllllllIllllllIlIIlIIIIlIII.has("data") ? Integer.valueOf(JsonUtils.getInt(llllllllllllIllllllIlIIlIIIIlIII, "data")) : null;
            final NBTPredicate llllllllllllIllllllIlIIlIIIIIlII = NBTPredicate.func_193476_a(llllllllllllIllllllIlIIlIIIIlIII.get("nbt"));
            Item llllllllllllIllllllIlIIlIIIIIIll = null;
            if (llllllllllllIllllllIlIIlIIIIlIII.has("item")) {
                final ResourceLocation llllllllllllIllllllIlIIlIIIIIIlI = new ResourceLocation(JsonUtils.getString(llllllllllllIllllllIlIIlIIIIlIII, "item"));
                llllllllllllIllllllIlIIlIIIIIIll = Item.REGISTRY.getObject(llllllllllllIllllllIlIIlIIIIIIlI);
                if (llllllllllllIllllllIlIIlIIIIIIll == null) {
                    throw new JsonSyntaxException(String.valueOf(new StringBuilder("Unknown item id '").append(llllllllllllIllllllIlIIlIIIIIIlI).append("'")));
                }
            }
            final EnchantmentPredicate[] llllllllllllIllllllIlIIlIIIIIIIl = EnchantmentPredicate.func_192465_b(llllllllllllIllllllIlIIlIIIIlIII.get("enchantments"));
            PotionType llllllllllllIllllllIlIIlIIIIIIII = null;
            if (llllllllllllIllllllIlIIlIIIIlIII.has("potion")) {
                final ResourceLocation llllllllllllIllllllIlIIIllllllll = new ResourceLocation(JsonUtils.getString(llllllllllllIllllllIlIIlIIIIlIII, "potion"));
                if (!PotionType.REGISTRY.containsKey(llllllllllllIllllllIlIIIllllllll)) {
                    throw new JsonSyntaxException(String.valueOf(new StringBuilder("Unknown potion '").append(llllllllllllIllllllIlIIIllllllll).append("'")));
                }
                llllllllllllIllllllIlIIlIIIIIIII = PotionType.REGISTRY.getObject(llllllllllllIllllllIlIIIllllllll);
            }
            return new ItemPredicate(llllllllllllIllllllIlIIlIIIIIIll, llllllllllllIllllllIlIIlIIIIIlIl, llllllllllllIllllllIlIIlIIIIIlll, llllllllllllIllllllIlIIlIIIIIllI, llllllllllllIllllllIlIIlIIIIIIIl, llllllllllllIllllllIlIIlIIIIIIII, llllllllllllIllllllIlIIlIIIIIlII);
        }
        return ItemPredicate.field_192495_a;
    }
    
    public static ItemPredicate[] func_192494_b(@Nullable final JsonElement llllllllllllIllllllIlIIIllllIIII) {
        if (llllllllllllIllllllIlIIIllllIIII != null && !llllllllllllIllllllIlIIIllllIIII.isJsonNull()) {
            final JsonArray llllllllllllIllllllIlIIIlllIllll = JsonUtils.getJsonArray(llllllllllllIllllllIlIIIllllIIII, "items");
            final ItemPredicate[] llllllllllllIllllllIlIIIlllIlllI = new ItemPredicate[llllllllllllIllllllIlIIIlllIllll.size()];
            for (int llllllllllllIllllllIlIIIlllIllIl = 0; llllllllllllIllllllIlIIIlllIllIl < llllllllllllIllllllIlIIIlllIlllI.length; ++llllllllllllIllllllIlIIIlllIllIl) {
                llllllllllllIllllllIlIIIlllIlllI[llllllllllllIllllllIlIIIlllIllIl] = func_192492_a(llllllllllllIllllllIlIIIlllIllll.get(llllllllllllIllllllIlIIIlllIllIl));
            }
            return llllllllllllIllllllIlIIIlllIlllI;
        }
        return new ItemPredicate[0];
    }
    
    public ItemPredicate(@Nullable final Item llllllllllllIllllllIlIIlIIlIllll, @Nullable final Integer llllllllllllIllllllIlIIlIIlIlllI, final MinMaxBounds llllllllllllIllllllIlIIlIIlIllIl, final MinMaxBounds llllllllllllIllllllIlIIlIIlIllII, final EnchantmentPredicate[] llllllllllllIllllllIlIIlIIlIIIll, @Nullable final PotionType llllllllllllIllllllIlIIlIIlIIIlI, final NBTPredicate llllllllllllIllllllIlIIlIIlIIIIl) {
        this.field_192496_b = llllllllllllIllllllIlIIlIIlIllll;
        this.field_192497_c = llllllllllllIllllllIlIIlIIlIlllI;
        this.field_192498_d = llllllllllllIllllllIlIIlIIlIllIl;
        this.field_193444_e = llllllllllllIllllllIlIIlIIlIllII;
        this.field_192499_e = llllllllllllIllllllIlIIlIIlIIIll;
        this.field_192500_f = llllllllllllIllllllIlIIlIIlIIIlI;
        this.field_193445_h = llllllllllllIllllllIlIIlIIlIIIIl;
    }
    
    public ItemPredicate() {
        this.field_192496_b = null;
        this.field_192497_c = null;
        this.field_192500_f = null;
        this.field_192498_d = MinMaxBounds.field_192516_a;
        this.field_193444_e = MinMaxBounds.field_192516_a;
        this.field_192499_e = new EnchantmentPredicate[0];
        this.field_193445_h = NBTPredicate.field_193479_a;
    }
    
    static {
        field_192495_a = new ItemPredicate();
    }
}
