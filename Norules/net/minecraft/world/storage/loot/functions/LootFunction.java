package net.minecraft.world.storage.loot.functions;

import net.minecraft.world.storage.loot.conditions.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.util.*;
import com.google.gson.*;

public abstract class LootFunction
{
    private final /* synthetic */ LootCondition[] conditions;
    
    protected LootFunction(final LootCondition[] lllllllllllllIIllIIlIlllIIlIIlIl) {
        this.conditions = lllllllllllllIIllIIlIlllIIlIIlIl;
    }
    
    public abstract ItemStack apply(final ItemStack p0, final Random p1, final LootContext p2);
    
    public LootCondition[] getConditions() {
        return this.conditions;
    }
    
    public abstract static class Serializer<T extends LootFunction>
    {
        private final /* synthetic */ ResourceLocation lootTableLocation;
        private final /* synthetic */ Class<T> functionClass;
        
        public ResourceLocation getFunctionName() {
            return this.lootTableLocation;
        }
        
        public abstract void serialize(final JsonObject p0, final T p1, final JsonSerializationContext p2);
        
        protected Serializer(final ResourceLocation lllllllllllllIIlIlllllIlIIIllIIl, final Class<T> lllllllllllllIIlIlllllIlIIIllIII) {
            this.lootTableLocation = lllllllllllllIIlIlllllIlIIIllIIl;
            this.functionClass = lllllllllllllIIlIlllllIlIIIllIII;
        }
        
        public Class<T> getFunctionClass() {
            return this.functionClass;
        }
        
        public abstract T deserialize(final JsonObject p0, final JsonDeserializationContext p1, final LootCondition[] p2);
    }
}
