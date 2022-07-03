package net.minecraft.world.storage.loot.conditions;

import net.minecraft.world.storage.loot.*;
import net.minecraft.entity.*;
import com.google.gson.*;
import net.minecraft.util.*;
import net.minecraft.world.storage.loot.properties.*;
import java.util.*;

public class EntityHasProperty implements LootCondition
{
    private final /* synthetic */ EntityProperty[] properties;
    private final /* synthetic */ LootContext.EntityTarget target;
    
    @Override
    public boolean testCondition(final Random llllllllllllllllllIIIlIIlIllIlll, final LootContext llllllllllllllllllIIIlIIlIllIllI) {
        final Entity llllllllllllllllllIIIlIIlIllIlIl = llllllllllllllllllIIIlIIlIllIllI.getEntity(this.target);
        if (llllllllllllllllllIIIlIIlIllIlIl == null) {
            return false;
        }
        final char llllllllllllllllllIIIlIIlIlIllII;
        final float llllllllllllllllllIIIlIIlIlIllIl = ((EntityProperty[])(Object)(llllllllllllllllllIIIlIIlIlIllII = (char)(Object)this.properties)).length;
        for (Exception llllllllllllllllllIIIlIIlIlIlllI = (Exception)0; llllllllllllllllllIIIlIIlIlIlllI < llllllllllllllllllIIIlIIlIlIllIl; ++llllllllllllllllllIIIlIIlIlIlllI) {
            final EntityProperty llllllllllllllllllIIIlIIlIllIlII = llllllllllllllllllIIIlIIlIlIllII[llllllllllllllllllIIIlIIlIlIlllI];
            if (!llllllllllllllllllIIIlIIlIllIlII.testProperty(llllllllllllllllllIIIlIIlIllIlll, llllllllllllllllllIIIlIIlIllIlIl)) {
                return false;
            }
        }
        return true;
    }
    
    public EntityHasProperty(final EntityProperty[] llllllllllllllllllIIIlIIllIIIIlI, final LootContext.EntityTarget llllllllllllllllllIIIlIIllIIIlII) {
        this.properties = llllllllllllllllllIIIlIIllIIIIlI;
        this.target = llllllllllllllllllIIIlIIllIIIlII;
    }
    
    public static class Serializer extends LootCondition.Serializer<EntityHasProperty>
    {
        @Override
        public EntityHasProperty deserialize(final JsonObject llllllllllllllllllIIIllIIlIlIllI, final JsonDeserializationContext llllllllllllllllllIIIllIIlIlIlII) {
            final Set<Map.Entry<String, JsonElement>> llllllllllllllllllIIIllIIlIlIIlI = (Set<Map.Entry<String, JsonElement>>)JsonUtils.getJsonObject(llllllllllllllllllIIIllIIlIlIllI, "properties").entrySet();
            final EntityProperty[] llllllllllllllllllIIIllIIlIlIIII = new EntityProperty[llllllllllllllllllIIIllIIlIlIIlI.size()];
            int llllllllllllllllllIIIllIIlIIllll = 0;
            for (final Map.Entry<String, JsonElement> llllllllllllllllllIIIllIIlIIllIl : llllllllllllllllllIIIllIIlIlIIlI) {
                llllllllllllllllllIIIllIIlIlIIII[llllllllllllllllllIIIllIIlIIllll++] = (EntityProperty)EntityPropertyManager.getSerializerForName(new ResourceLocation(llllllllllllllllllIIIllIIlIIllIl.getKey())).deserialize(llllllllllllllllllIIIllIIlIIllIl.getValue(), llllllllllllllllllIIIllIIlIlIlII);
            }
            return new EntityHasProperty(llllllllllllllllllIIIllIIlIlIIII, JsonUtils.deserializeClass(llllllllllllllllllIIIllIIlIlIllI, "entity", llllllllllllllllllIIIllIIlIlIlII, (Class<? extends LootContext.EntityTarget>)LootContext.EntityTarget.class));
        }
        
        @Override
        public void serialize(final JsonObject llllllllllllllllllIIIllIIlllIllI, final EntityHasProperty llllllllllllllllllIIIllIIlllllll, final JsonSerializationContext llllllllllllllllllIIIllIIlllllIl) {
            final JsonObject llllllllllllllllllIIIllIIllllIll = new JsonObject();
            final byte llllllllllllllllllIIIllIIllIllll;
            final char llllllllllllllllllIIIllIIlllIIII = (char)((EntityProperty[])(Object)(llllllllllllllllllIIIllIIllIllll = (byte)(Object)llllllllllllllllllIIIllIIlllllll.properties)).length;
            for (Exception llllllllllllllllllIIIllIIlllIIIl = (Exception)0; llllllllllllllllllIIIllIIlllIIIl < llllllllllllllllllIIIllIIlllIIII; ++llllllllllllllllllIIIllIIlllIIIl) {
                final EntityProperty llllllllllllllllllIIIllIIllllIII = llllllllllllllllllIIIllIIllIllll[llllllllllllllllllIIIllIIlllIIIl];
                final EntityProperty.Serializer<EntityProperty> llllllllllllllllllIIIllIIlllIlll = EntityPropertyManager.getSerializerFor(llllllllllllllllllIIIllIIllllIII);
                llllllllllllllllllIIIllIIllllIll.add(llllllllllllllllllIIIllIIlllIlll.getName().toString(), llllllllllllllllllIIIllIIlllIlll.serialize(llllllllllllllllllIIIllIIllllIII, llllllllllllllllllIIIllIIlllllIl));
            }
            llllllllllllllllllIIIllIIlllIllI.add("properties", (JsonElement)llllllllllllllllllIIIllIIllllIll);
            llllllllllllllllllIIIllIIlllIllI.add("entity", llllllllllllllllllIIIllIIlllllIl.serialize((Object)llllllllllllllllllIIIllIIlllllll.target));
        }
        
        protected Serializer() {
            super(new ResourceLocation("entity_properties"), EntityHasProperty.class);
        }
    }
}
