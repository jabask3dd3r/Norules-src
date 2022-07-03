package net.minecraft.world.storage.loot.functions;

import net.minecraft.world.storage.loot.*;
import com.google.common.collect.*;
import net.minecraft.init.*;
import net.minecraft.util.math.*;
import net.minecraft.enchantment.*;
import net.minecraft.item.*;
import org.apache.logging.log4j.*;
import net.minecraft.world.storage.loot.conditions.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.util.*;
import com.google.gson.*;

public class EnchantRandomly extends LootFunction
{
    private final /* synthetic */ List<Enchantment> enchantments;
    private static final /* synthetic */ Logger LOGGER;
    
    @Override
    public ItemStack apply(ItemStack llllllllllllllIIIlllIllIlIlIlllI, final Random llllllllllllllIIIlllIllIlIllIllI, final LootContext llllllllllllllIIIlllIllIlIllIlIl) {
        Enchantment llllllllllllllIIIlllIllIlIllIIll = null;
        if (this.enchantments.isEmpty()) {
            final List<Enchantment> llllllllllllllIIIlllIllIlIllIIlI = (List<Enchantment>)Lists.newArrayList();
            for (final Enchantment llllllllllllllIIIlllIllIlIllIIIl : Enchantment.REGISTRY) {
                if (((ItemStack)llllllllllllllIIIlllIllIlIlIlllI).getItem() == Items.BOOK || llllllllllllllIIIlllIllIlIllIIIl.canApply((ItemStack)llllllllllllllIIIlllIllIlIlIlllI)) {
                    llllllllllllllIIIlllIllIlIllIIlI.add(llllllllllllllIIIlllIllIlIllIIIl);
                }
            }
            if (llllllllllllllIIIlllIllIlIllIIlI.isEmpty()) {
                EnchantRandomly.LOGGER.warn("Couldn't find a compatible enchantment for {}", llllllllllllllIIIlllIllIlIlIlllI);
                return (ItemStack)llllllllllllllIIIlllIllIlIlIlllI;
            }
            final Enchantment llllllllllllllIIIlllIllIlIllIlII = llllllllllllllIIIlllIllIlIllIIlI.get(llllllllllllllIIIlllIllIlIllIllI.nextInt(llllllllllllllIIIlllIllIlIllIIlI.size()));
        }
        else {
            llllllllllllllIIIlllIllIlIllIIll = this.enchantments.get(llllllllllllllIIIlllIllIlIllIllI.nextInt(this.enchantments.size()));
        }
        final int llllllllllllllIIIlllIllIlIllIIII = MathHelper.getInt(llllllllllllllIIIlllIllIlIllIllI, llllllllllllllIIIlllIllIlIllIIll.getMinLevel(), llllllllllllllIIIlllIllIlIllIIll.getMaxLevel());
        if (((ItemStack)llllllllllllllIIIlllIllIlIlIlllI).getItem() == Items.BOOK) {
            llllllllllllllIIIlllIllIlIlIlllI = new ItemStack(Items.ENCHANTED_BOOK);
            ItemEnchantedBook.addEnchantment((ItemStack)llllllllllllllIIIlllIllIlIlIlllI, new EnchantmentData(llllllllllllllIIIlllIllIlIllIIll, llllllllllllllIIIlllIllIlIllIIII));
        }
        else {
            ((ItemStack)llllllllllllllIIIlllIllIlIlIlllI).addEnchantment(llllllllllllllIIIlllIllIlIllIIll, llllllllllllllIIIlllIllIlIllIIII);
        }
        return (ItemStack)llllllllllllllIIIlllIllIlIlIlllI;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public EnchantRandomly(final LootCondition[] llllllllllllllIIIlllIllIllIIIIIl, @Nullable final List<Enchantment> llllllllllllllIIIlllIllIllIIIIll) {
        super(llllllllllllllIIIlllIllIllIIIIIl);
        this.enchantments = ((llllllllllllllIIIlllIllIllIIIIll == null) ? Collections.emptyList() : llllllllllllllIIIlllIllIllIIIIll);
    }
    
    public static class Serializer extends LootFunction.Serializer<EnchantRandomly>
    {
        @Override
        public void serialize(final JsonObject llllllllllllllIlIlIlIlllIllIlIlI, final EnchantRandomly llllllllllllllIlIlIlIlllIllIIIll, final JsonSerializationContext llllllllllllllIlIlIlIlllIllIlIII) {
            if (!llllllllllllllIlIlIlIlllIllIIIll.enchantments.isEmpty()) {
                final JsonArray llllllllllllllIlIlIlIlllIllIIlll = new JsonArray();
                for (final Enchantment llllllllllllllIlIlIlIlllIllIIllI : llllllllllllllIlIlIlIlllIllIIIll.enchantments) {
                    final ResourceLocation llllllllllllllIlIlIlIlllIllIIlIl = Enchantment.REGISTRY.getNameForObject(llllllllllllllIlIlIlIlllIllIIllI);
                    if (llllllllllllllIlIlIlIlllIllIIlIl == null) {
                        throw new IllegalArgumentException(String.valueOf(new StringBuilder("Don't know how to serialize enchantment ").append(llllllllllllllIlIlIlIlllIllIIllI)));
                    }
                    llllllllllllllIlIlIlIlllIllIIlll.add((JsonElement)new JsonPrimitive(llllllllllllllIlIlIlIlllIllIIlIl.toString()));
                }
                llllllllllllllIlIlIlIlllIllIlIlI.add("enchantments", (JsonElement)llllllllllllllIlIlIlIlllIllIIlll);
            }
        }
        
        public Serializer() {
            super(new ResourceLocation("enchant_randomly"), EnchantRandomly.class);
        }
        
        @Override
        public EnchantRandomly deserialize(final JsonObject llllllllllllllIlIlIlIlllIlIlIllI, final JsonDeserializationContext llllllllllllllIlIlIlIlllIlIlIlIl, final LootCondition[] llllllllllllllIlIlIlIlllIlIlIlII) {
            final List<Enchantment> llllllllllllllIlIlIlIlllIlIlIIll = (List<Enchantment>)Lists.newArrayList();
            if (llllllllllllllIlIlIlIlllIlIlIllI.has("enchantments")) {
                for (final JsonElement llllllllllllllIlIlIlIlllIlIlIIlI : JsonUtils.getJsonArray(llllllllllllllIlIlIlIlllIlIlIllI, "enchantments")) {
                    final String llllllllllllllIlIlIlIlllIlIlIIIl = JsonUtils.getString(llllllllllllllIlIlIlIlllIlIlIIlI, "enchantment");
                    final Enchantment llllllllllllllIlIlIlIlllIlIlIIII = Enchantment.REGISTRY.getObject(new ResourceLocation(llllllllllllllIlIlIlIlllIlIlIIIl));
                    if (llllllllllllllIlIlIlIlllIlIlIIII == null) {
                        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Unknown enchantment '").append(llllllllllllllIlIlIlIlllIlIlIIIl).append("'")));
                    }
                    llllllllllllllIlIlIlIlllIlIlIIll.add(llllllllllllllIlIlIlIlllIlIlIIII);
                }
            }
            return new EnchantRandomly(llllllllllllllIlIlIlIlllIlIlIlII, llllllllllllllIlIlIlIlllIlIlIIll);
        }
    }
}
