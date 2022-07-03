package net.minecraft.world.storage.loot.functions;

import net.minecraft.item.*;
import java.util.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.inventory.*;
import net.minecraft.world.storage.loot.conditions.*;
import org.apache.logging.log4j.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import com.google.gson.*;
import net.minecraft.util.*;

public class SetAttributes extends LootFunction
{
    private final /* synthetic */ Modifier[] modifiers;
    
    @Override
    public ItemStack apply(final ItemStack lllllllllllllIIlIllIllIIlIlllIll, final Random lllllllllllllIIlIllIllIIlIlllIlI, final LootContext lllllllllllllIIlIllIllIIlIlllIIl) {
        final float lllllllllllllIIlIllIllIIlIlIllll;
        final Exception lllllllllllllIIlIllIllIIlIllIIII = (Exception)((Modifier[])(Object)(lllllllllllllIIlIllIllIIlIlIllll = (float)(Object)this.modifiers)).length;
        for (byte lllllllllllllIIlIllIllIIlIllIIIl = 0; lllllllllllllIIlIllIllIIlIllIIIl < lllllllllllllIIlIllIllIIlIllIIII; ++lllllllllllllIIlIllIllIIlIllIIIl) {
            final Modifier lllllllllllllIIlIllIllIIlIlllIII = lllllllllllllIIlIllIllIIlIlIllll[lllllllllllllIIlIllIllIIlIllIIIl];
            UUID lllllllllllllIIlIllIllIIlIllIlll = lllllllllllllIIlIllIllIIlIlllIII.uuid;
            if (lllllllllllllIIlIllIllIIlIllIlll == null) {
                lllllllllllllIIlIllIllIIlIllIlll = UUID.randomUUID();
            }
            final EntityEquipmentSlot lllllllllllllIIlIllIllIIlIllIllI = lllllllllllllIIlIllIllIIlIlllIII.slots[lllllllllllllIIlIllIllIIlIlllIlI.nextInt(lllllllllllllIIlIllIllIIlIlllIII.slots.length)];
            lllllllllllllIIlIllIllIIlIlllIll.addAttributeModifier(lllllllllllllIIlIllIllIIlIlllIII.attributeName, new AttributeModifier(lllllllllllllIIlIllIllIIlIllIlll, lllllllllllllIIlIllIllIIlIlllIII.modifierName, lllllllllllllIIlIllIllIIlIlllIII.amount.generateFloat(lllllllllllllIIlIllIllIIlIlllIlI), lllllllllllllIIlIllIllIIlIlllIII.operation), lllllllllllllIIlIllIllIIlIllIllI);
        }
        return lllllllllllllIIlIllIllIIlIlllIll;
    }
    
    public SetAttributes(final LootCondition[] lllllllllllllIIlIllIllIIllIIlIlI, final Modifier[] lllllllllllllIIlIllIllIIllIIlIIl) {
        super(lllllllllllllIIlIllIllIIllIIlIlI);
        this.modifiers = lllllllllllllIIlIllIllIIllIIlIIl;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    static class Modifier
    {
        private final /* synthetic */ RandomValueRange amount;
        private final /* synthetic */ String modifierName;
        @Nullable
        private final /* synthetic */ UUID uuid;
        private final /* synthetic */ int operation;
        private final /* synthetic */ String attributeName;
        private final /* synthetic */ EntityEquipmentSlot[] slots;
        
        public static Modifier deserialize(final JsonObject llllllllllllllllIIlIlIlIllIllIII, final JsonDeserializationContext llllllllllllllllIIlIlIlIllIlIlll) {
            final String llllllllllllllllIIlIlIlIllIlIllI = JsonUtils.getString(llllllllllllllllIIlIlIlIllIllIII, "name");
            final String llllllllllllllllIIlIlIlIllIlIlIl = JsonUtils.getString(llllllllllllllllIIlIlIlIllIllIII, "attribute");
            final int llllllllllllllllIIlIlIlIllIlIlII = getOperationFromInt(JsonUtils.getString(llllllllllllllllIIlIlIlIllIllIII, "operation"));
            final RandomValueRange llllllllllllllllIIlIlIlIllIlIIll = JsonUtils.deserializeClass(llllllllllllllllIIlIlIlIllIllIII, "amount", llllllllllllllllIIlIlIlIllIlIlll, (Class<? extends RandomValueRange>)RandomValueRange.class);
            UUID llllllllllllllllIIlIlIlIllIlIIlI = null;
            EntityEquipmentSlot[] llllllllllllllllIIlIlIlIllIIllll = null;
            if (JsonUtils.isString(llllllllllllllllIIlIlIlIllIllIII, "slot")) {
                final EntityEquipmentSlot[] llllllllllllllllIIlIlIlIllIlIIIl = { EntityEquipmentSlot.fromString(JsonUtils.getString(llllllllllllllllIIlIlIlIllIllIII, "slot")) };
            }
            else {
                if (!JsonUtils.isJsonArray(llllllllllllllllIIlIlIlIllIllIII, "slot")) {
                    throw new JsonSyntaxException("Invalid or missing attribute modifier slot; must be either string or array of strings.");
                }
                final JsonArray llllllllllllllllIIlIlIlIllIIllIl = JsonUtils.getJsonArray(llllllllllllllllIIlIlIlIllIllIII, "slot");
                llllllllllllllllIIlIlIlIllIIllll = new EntityEquipmentSlot[llllllllllllllllIIlIlIlIllIIllIl.size()];
                int llllllllllllllllIIlIlIlIllIIlIll = 0;
                for (final JsonElement llllllllllllllllIIlIlIlIllIIlIlI : llllllllllllllllIIlIlIlIllIIllIl) {
                    llllllllllllllllIIlIlIlIllIIllll[llllllllllllllllIIlIlIlIllIIlIll++] = EntityEquipmentSlot.fromString(JsonUtils.getString(llllllllllllllllIIlIlIlIllIIlIlI, "slot"));
                }
                if (llllllllllllllllIIlIlIlIllIIllll.length == 0) {
                    throw new JsonSyntaxException("Invalid attribute modifier slot; must contain at least one entry.");
                }
            }
            if (llllllllllllllllIIlIlIlIllIllIII.has("id")) {
                final String llllllllllllllllIIlIlIlIllIIlIIl = JsonUtils.getString(llllllllllllllllIIlIlIlIllIllIII, "id");
                try {
                    llllllllllllllllIIlIlIlIllIlIIlI = UUID.fromString(llllllllllllllllIIlIlIlIllIIlIIl);
                }
                catch (IllegalArgumentException llllllllllllllllIIlIlIlIllIIlIII) {
                    throw new JsonSyntaxException(String.valueOf(new StringBuilder("Invalid attribute modifier id '").append(llllllllllllllllIIlIlIlIllIIlIIl).append("' (must be UUID format, with dashes)")));
                }
            }
            return new Modifier(llllllllllllllllIIlIlIlIllIlIllI, llllllllllllllllIIlIlIlIllIlIlIl, llllllllllllllllIIlIlIlIllIlIlII, llllllllllllllllIIlIlIlIllIlIIll, llllllllllllllllIIlIlIlIllIIllll, llllllllllllllllIIlIlIlIllIlIIlI);
        }
        
        private Modifier(final String llllllllllllllllIIlIlIllIIIIlllI, final String llllllllllllllllIIlIlIllIIIIllIl, final int llllllllllllllllIIlIlIllIIIIllII, final RandomValueRange llllllllllllllllIIlIlIllIIIIlIll, final EntityEquipmentSlot[] llllllllllllllllIIlIlIllIIIlIIIl, @Nullable final UUID llllllllllllllllIIlIlIllIIIlIIII) {
            this.modifierName = llllllllllllllllIIlIlIllIIIIlllI;
            this.attributeName = llllllllllllllllIIlIlIllIIIIllIl;
            this.operation = llllllllllllllllIIlIlIllIIIIllII;
            this.amount = llllllllllllllllIIlIlIllIIIIlIll;
            this.uuid = llllllllllllllllIIlIlIllIIIlIIII;
            this.slots = llllllllllllllllIIlIlIllIIIlIIIl;
        }
        
        public JsonObject serialize(final JsonSerializationContext llllllllllllllllIIlIlIlIllllIlII) {
            final JsonObject llllllllllllllllIIlIlIlIlllllIlI = new JsonObject();
            llllllllllllllllIIlIlIlIlllllIlI.addProperty("name", this.modifierName);
            llllllllllllllllIIlIlIlIlllllIlI.addProperty("attribute", this.attributeName);
            llllllllllllllllIIlIlIlIlllllIlI.addProperty("operation", getOperationFromStr(this.operation));
            llllllllllllllllIIlIlIlIlllllIlI.add("amount", llllllllllllllllIIlIlIlIllllIlII.serialize((Object)this.amount));
            if (this.uuid != null) {
                llllllllllllllllIIlIlIlIlllllIlI.addProperty("id", this.uuid.toString());
            }
            if (this.slots.length == 1) {
                llllllllllllllllIIlIlIlIlllllIlI.addProperty("slot", this.slots[0].getName());
            }
            else {
                final JsonArray llllllllllllllllIIlIlIlIlllllIIl = new JsonArray();
                final int llllllllllllllllIIlIlIlIlllIllII;
                final char llllllllllllllllIIlIlIlIlllIllIl = (char)((EntityEquipmentSlot[])(Object)(llllllllllllllllIIlIlIlIlllIllII = (int)(Object)this.slots)).length;
                for (final EntityEquipmentSlot llllllllllllllllIIlIlIlIllllIlll : llllllllllllllllIIlIlIlIlllIllII) {
                    llllllllllllllllIIlIlIlIlllllIIl.add((JsonElement)new JsonPrimitive(llllllllllllllllIIlIlIlIllllIlll.getName()));
                }
                llllllllllllllllIIlIlIlIlllllIlI.add("slot", (JsonElement)llllllllllllllllIIlIlIlIlllllIIl);
            }
            return llllllllllllllllIIlIlIlIlllllIlI;
        }
        
        private static String getOperationFromStr(final int llllllllllllllllIIlIlIlIlIllIIlI) {
            switch (llllllllllllllllIIlIlIlIlIllIIlI) {
                case 0: {
                    return "addition";
                }
                case 1: {
                    return "multiply_base";
                }
                case 2: {
                    return "multiply_total";
                }
                default: {
                    throw new IllegalArgumentException(String.valueOf(new StringBuilder("Unknown operation ").append(llllllllllllllllIIlIlIlIlIllIIlI)));
                }
            }
        }
        
        private static int getOperationFromInt(final String llllllllllllllllIIlIlIlIlIlIIlIl) {
            if ("addition".equals(llllllllllllllllIIlIlIlIlIlIIlIl)) {
                return 0;
            }
            if ("multiply_base".equals(llllllllllllllllIIlIlIlIlIlIIlIl)) {
                return 1;
            }
            if ("multiply_total".equals(llllllllllllllllIIlIlIlIlIlIIlIl)) {
                return 2;
            }
            throw new JsonSyntaxException(String.valueOf(new StringBuilder("Unknown attribute modifier operation ").append(llllllllllllllllIIlIlIlIlIlIIlIl)));
        }
    }
    
    public static class Serializer extends LootFunction.Serializer<SetAttributes>
    {
        public Serializer() {
            super(new ResourceLocation("set_attributes"), SetAttributes.class);
        }
        
        @Override
        public SetAttributes deserialize(final JsonObject lllllllllllllIIlllIllIllIllIlIlI, final JsonDeserializationContext lllllllllllllIIlllIllIllIllIIIlI, final LootCondition[] lllllllllllllIIlllIllIllIllIIIIl) {
            final JsonArray lllllllllllllIIlllIllIllIllIIlll = JsonUtils.getJsonArray(lllllllllllllIIlllIllIllIllIlIlI, "modifiers");
            final Modifier[] lllllllllllllIIlllIllIllIllIIllI = new Modifier[lllllllllllllIIlllIllIllIllIIlll.size()];
            int lllllllllllllIIlllIllIllIllIIlIl = 0;
            for (final JsonElement lllllllllllllIIlllIllIllIllIIlII : lllllllllllllIIlllIllIllIllIIlll) {
                lllllllllllllIIlllIllIllIllIIllI[lllllllllllllIIlllIllIllIllIIlIl++] = Modifier.deserialize(JsonUtils.getJsonObject(lllllllllllllIIlllIllIllIllIIlII, "modifier"), lllllllllllllIIlllIllIllIllIIIlI);
            }
            if (lllllllllllllIIlllIllIllIllIIllI.length == 0) {
                throw new JsonSyntaxException("Invalid attribute modifiers array; cannot be empty");
            }
            return new SetAttributes(lllllllllllllIIlllIllIllIllIIIIl, lllllllllllllIIlllIllIllIllIIllI);
        }
        
        @Override
        public void serialize(final JsonObject lllllllllllllIIlllIllIlllIIIIIII, final SetAttributes lllllllllllllIIlllIllIllIlllllll, final JsonSerializationContext lllllllllllllIIlllIllIllIllllllI) {
            final JsonArray lllllllllllllIIlllIllIllIlllllIl = new JsonArray();
            final boolean lllllllllllllIIlllIllIllIlllIlII;
            final byte lllllllllllllIIlllIllIllIlllIlIl = (byte)((Modifier[])(Object)(lllllllllllllIIlllIllIllIlllIlII = (boolean)(Object)lllllllllllllIIlllIllIllIlllllll.modifiers)).length;
            for (short lllllllllllllIIlllIllIllIlllIllI = 0; lllllllllllllIIlllIllIllIlllIllI < lllllllllllllIIlllIllIllIlllIlIl; ++lllllllllllllIIlllIllIllIlllIllI) {
                final Modifier lllllllllllllIIlllIllIllIlllllII = lllllllllllllIIlllIllIllIlllIlII[lllllllllllllIIlllIllIllIlllIllI];
                lllllllllllllIIlllIllIllIlllllIl.add((JsonElement)lllllllllllllIIlllIllIllIlllllII.serialize(lllllllllllllIIlllIllIllIllllllI));
            }
            lllllllllllllIIlllIllIlllIIIIIII.add("modifiers", (JsonElement)lllllllllllllIIlllIllIllIlllllIl);
        }
    }
}
