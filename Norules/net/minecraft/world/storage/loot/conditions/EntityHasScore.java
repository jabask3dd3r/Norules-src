package net.minecraft.world.storage.loot.conditions;

import net.minecraft.world.storage.loot.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.scoreboard.*;
import com.google.gson.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.util.*;

public class EntityHasScore implements LootCondition
{
    private final /* synthetic */ Map<String, RandomValueRange> scores;
    private final /* synthetic */ LootContext.EntityTarget target;
    
    @Override
    public boolean testCondition(final Random lllllllllllllllllIllllIlIllIIlIl, final LootContext lllllllllllllllllIllllIlIlIlllll) {
        final Entity lllllllllllllllllIllllIlIllIIIll = lllllllllllllllllIllllIlIlIlllll.getEntity(this.target);
        if (lllllllllllllllllIllllIlIllIIIll == null) {
            return false;
        }
        final Scoreboard lllllllllllllllllIllllIlIllIIIlI = lllllllllllllllllIllllIlIllIIIll.world.getScoreboard();
        for (final Map.Entry<String, RandomValueRange> lllllllllllllllllIllllIlIllIIIIl : this.scores.entrySet()) {
            if (!this.entityScoreMatch(lllllllllllllllllIllllIlIllIIIll, lllllllllllllllllIllllIlIllIIIlI, lllllllllllllllllIllllIlIllIIIIl.getKey(), lllllllllllllllllIllllIlIllIIIIl.getValue())) {
                return false;
            }
        }
        return true;
    }
    
    public EntityHasScore(final Map<String, RandomValueRange> lllllllllllllllllIllllIlIllIlllI, final LootContext.EntityTarget lllllllllllllllllIllllIlIlllIIII) {
        this.scores = lllllllllllllllllIllllIlIllIlllI;
        this.target = lllllllllllllllllIllllIlIlllIIII;
    }
    
    protected boolean entityScoreMatch(final Entity lllllllllllllllllIllllIlIlIIllIl, final Scoreboard lllllllllllllllllIllllIlIlIlIIlI, final String lllllllllllllllllIllllIlIlIIlIll, final RandomValueRange lllllllllllllllllIllllIlIlIIlIlI) {
        final ScoreObjective lllllllllllllllllIllllIlIlIIllll = lllllllllllllllllIllllIlIlIlIIlI.getObjective(lllllllllllllllllIllllIlIlIIlIll);
        if (lllllllllllllllllIllllIlIlIIllll == null) {
            return false;
        }
        final String lllllllllllllllllIllllIlIlIIlllI = (lllllllllllllllllIllllIlIlIIllIl instanceof EntityPlayerMP) ? lllllllllllllllllIllllIlIlIIllIl.getName() : lllllllllllllllllIllllIlIlIIllIl.getCachedUniqueIdString();
        return lllllllllllllllllIllllIlIlIlIIlI.entityHasObjective(lllllllllllllllllIllllIlIlIIlllI, lllllllllllllllllIllllIlIlIIllll) && lllllllllllllllllIllllIlIlIIlIlI.isInRange(lllllllllllllllllIllllIlIlIlIIlI.getOrCreateScore(lllllllllllllllllIllllIlIlIIlllI, lllllllllllllllllIllllIlIlIIllll).getScorePoints());
    }
    
    public static class Serializer extends LootCondition.Serializer<EntityHasScore>
    {
        @Override
        public void serialize(final JsonObject lllllllllllllIlIIlIIIIlllllIllIl, final EntityHasScore lllllllllllllIlIIlIIIIllllllIIIl, final JsonSerializationContext lllllllllllllIlIIlIIIIlllllIlIll) {
            final JsonObject lllllllllllllIlIIlIIIIlllllIllll = new JsonObject();
            for (final Map.Entry<String, RandomValueRange> lllllllllllllIlIIlIIIIlllllIlllI : lllllllllllllIlIIlIIIIllllllIIIl.scores.entrySet()) {
                lllllllllllllIlIIlIIIIlllllIllll.add((String)lllllllllllllIlIIlIIIIlllllIlllI.getKey(), lllllllllllllIlIIlIIIIlllllIlIll.serialize((Object)lllllllllllllIlIIlIIIIlllllIlllI.getValue()));
            }
            lllllllllllllIlIIlIIIIlllllIllIl.add("scores", (JsonElement)lllllllllllllIlIIlIIIIlllllIllll);
            lllllllllllllIlIIlIIIIlllllIllIl.add("entity", lllllllllllllIlIIlIIIIlllllIlIll.serialize((Object)lllllllllllllIlIIlIIIIllllllIIIl.target));
        }
        
        @Override
        public EntityHasScore deserialize(final JsonObject lllllllllllllIlIIlIIIIlllllIIIII, final JsonDeserializationContext lllllllllllllIlIIlIIIIllllIlllll) {
            final Set<Map.Entry<String, JsonElement>> lllllllllllllIlIIlIIIIllllIllllI = (Set<Map.Entry<String, JsonElement>>)JsonUtils.getJsonObject(lllllllllllllIlIIlIIIIlllllIIIII, "scores").entrySet();
            final Map<String, RandomValueRange> lllllllllllllIlIIlIIIIllllIlllIl = (Map<String, RandomValueRange>)Maps.newLinkedHashMap();
            for (final Map.Entry<String, JsonElement> lllllllllllllIlIIlIIIIllllIlllII : lllllllllllllIlIIlIIIIllllIllllI) {
                lllllllllllllIlIIlIIIIllllIlllIl.put(lllllllllllllIlIIlIIIIllllIlllII.getKey(), JsonUtils.deserializeClass((JsonElement)lllllllllllllIlIIlIIIIllllIlllII.getValue(), "score", lllllllllllllIlIIlIIIIllllIlllll, (Class<? extends RandomValueRange>)RandomValueRange.class));
            }
            return new EntityHasScore(lllllllllllllIlIIlIIIIllllIlllIl, JsonUtils.deserializeClass(lllllllllllllIlIIlIIIIlllllIIIII, "entity", lllllllllllllIlIIlIIIIllllIlllll, (Class<? extends LootContext.EntityTarget>)LootContext.EntityTarget.class));
        }
        
        protected Serializer() {
            super(new ResourceLocation("entity_scores"), EntityHasScore.class);
        }
    }
}
