package net.minecraft.world.storage.loot.conditions;

import java.util.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.util.*;
import com.google.gson.*;

public interface LootCondition
{
    boolean testCondition(final Random p0, final LootContext p1);
    
    public abstract static class Serializer<T extends LootCondition>
    {
        private final /* synthetic */ Class<T> conditionClass;
        private final /* synthetic */ ResourceLocation lootTableLocation;
        
        public Class<T> getConditionClass() {
            return this.conditionClass;
        }
        
        protected Serializer(final ResourceLocation lllllllllllllIIlllIlllllllIIlIIl, final Class<T> lllllllllllllIIlllIlllllllIIlIII) {
            this.lootTableLocation = lllllllllllllIIlllIlllllllIIlIIl;
            this.conditionClass = lllllllllllllIIlllIlllllllIIlIII;
        }
        
        public ResourceLocation getLootTableLocation() {
            return this.lootTableLocation;
        }
        
        public abstract T deserialize(final JsonObject p0, final JsonDeserializationContext p1);
        
        public abstract void serialize(final JsonObject p0, final T p1, final JsonSerializationContext p2);
    }
}
