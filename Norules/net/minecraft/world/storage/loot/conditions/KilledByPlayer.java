package net.minecraft.world.storage.loot.conditions;

import java.util.*;
import net.minecraft.world.storage.loot.*;
import com.google.gson.*;
import net.minecraft.util.*;

public class KilledByPlayer implements LootCondition
{
    private final /* synthetic */ boolean inverse;
    
    public KilledByPlayer(final boolean lllllllllllllIlIIIllIIlIIlIIllIl) {
        this.inverse = lllllllllllllIlIIIllIIlIIlIIllIl;
    }
    
    @Override
    public boolean testCondition(final Random lllllllllllllIlIIIllIIlIIlIIIllI, final LootContext lllllllllllllIlIIIllIIlIIlIIIlIl) {
        final boolean lllllllllllllIlIIIllIIlIIlIIIlII = lllllllllllllIlIIIllIIlIIlIIIlIl.getKillerPlayer() != null;
        return lllllllllllllIlIIIllIIlIIlIIIlII == !this.inverse;
    }
    
    public static class Serializer extends LootCondition.Serializer<KilledByPlayer>
    {
        @Override
        public void serialize(final JsonObject llllllllllllllIlIllIlIIlIlIIlIII, final KilledByPlayer llllllllllllllIlIllIlIIlIlIIIlll, final JsonSerializationContext llllllllllllllIlIllIlIIlIlIIIllI) {
            llllllllllllllIlIllIlIIlIlIIlIII.addProperty("inverse", Boolean.valueOf(llllllllllllllIlIllIlIIlIlIIIlll.inverse));
        }
        
        @Override
        public KilledByPlayer deserialize(final JsonObject llllllllllllllIlIllIlIIlIIllllll, final JsonDeserializationContext llllllllllllllIlIllIlIIlIlIIIIII) {
            return new KilledByPlayer(JsonUtils.getBoolean(llllllllllllllIlIllIlIIlIIllllll, "inverse", false));
        }
        
        protected Serializer() {
            super(new ResourceLocation("killed_by_player"), KilledByPlayer.class);
        }
    }
}
