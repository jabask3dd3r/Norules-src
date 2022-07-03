package net.minecraft.world.storage.loot.properties;

import java.util.*;
import net.minecraft.entity.*;
import com.google.gson.*;
import net.minecraft.util.*;

public class EntityOnFire implements EntityProperty
{
    private final /* synthetic */ boolean onFire;
    
    public EntityOnFire(final boolean llllllllllllllIlIIIIllIIlllIIIIl) {
        this.onFire = llllllllllllllIlIIIIllIIlllIIIIl;
    }
    
    @Override
    public boolean testProperty(final Random llllllllllllllIlIIIIllIIllIlllIl, final Entity llllllllllllllIlIIIIllIIllIllIlI) {
        return llllllllllllllIlIIIIllIIllIllIlI.isBurning() == this.onFire;
    }
    
    public static class Serializer extends EntityProperty.Serializer<EntityOnFire>
    {
        @Override
        public JsonElement serialize(final EntityOnFire llllllllllllIllllllIlIIIIlIllIlI, final JsonSerializationContext llllllllllllIllllllIlIIIIlIllIIl) {
            return (JsonElement)new JsonPrimitive(Boolean.valueOf(llllllllllllIllllllIlIIIIlIllIlI.onFire));
        }
        
        @Override
        public EntityOnFire deserialize(final JsonElement llllllllllllIllllllIlIIIIlIlIlIl, final JsonDeserializationContext llllllllllllIllllllIlIIIIlIlIlII) {
            return new EntityOnFire(JsonUtils.getBoolean(llllllllllllIllllllIlIIIIlIlIlIl, "on_fire"));
        }
        
        protected Serializer() {
            super(new ResourceLocation("on_fire"), EntityOnFire.class);
        }
    }
}
