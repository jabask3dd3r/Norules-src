package net.minecraft.world.storage.loot.properties;

import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import com.google.gson.*;

public interface EntityProperty
{
    boolean testProperty(final Random p0, final Entity p1);
    
    public abstract static class Serializer<T extends EntityProperty>
    {
        private final /* synthetic */ ResourceLocation name;
        private final /* synthetic */ Class<T> propertyClass;
        
        public Class<T> getPropertyClass() {
            return this.propertyClass;
        }
        
        public abstract T deserialize(final JsonElement p0, final JsonDeserializationContext p1);
        
        protected Serializer(final ResourceLocation llllllllllllIlllllIIlIIlIIlIIIIl, final Class<T> llllllllllllIlllllIIlIIlIIIlllIl) {
            this.name = llllllllllllIlllllIIlIIlIIlIIIIl;
            this.propertyClass = llllllllllllIlllllIIlIIlIIIlllIl;
        }
        
        public abstract JsonElement serialize(final T p0, final JsonSerializationContext p1);
        
        public ResourceLocation getName() {
            return this.name;
        }
    }
}
