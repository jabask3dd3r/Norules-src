package net.minecraft.world.storage.loot;

import net.minecraft.util.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import com.google.common.collect.*;
import com.google.gson.*;
import java.io.*;
import com.google.gson.stream.*;

public class LootContext
{
    @Nullable
    private final /* synthetic */ DamageSource damageSource;
    private final /* synthetic */ float luck;
    private final /* synthetic */ LootTableManager lootTableManager;
    private final /* synthetic */ Set<LootTable> lootTables;
    @Nullable
    private final /* synthetic */ Entity lootedEntity;
    private final /* synthetic */ WorldServer worldObj;
    @Nullable
    private final /* synthetic */ EntityPlayer player;
    
    public float getLuck() {
        return this.luck;
    }
    
    public LootContext(final float llllllllllllllIIlIlIlIIIIIIllllI, final WorldServer llllllllllllllIIlIlIlIIIIIIlllIl, final LootTableManager llllllllllllllIIlIlIlIIIIIIlllII, @Nullable final Entity llllllllllllllIIlIlIlIIIIIIllIll, @Nullable final EntityPlayer llllllllllllllIIlIlIlIIIIIIllIlI, @Nullable final DamageSource llllllllllllllIIlIlIlIIIIIIllIIl) {
        this.lootTables = (Set<LootTable>)Sets.newLinkedHashSet();
        this.luck = llllllllllllllIIlIlIlIIIIIIllllI;
        this.worldObj = llllllllllllllIIlIlIlIIIIIIlllIl;
        this.lootTableManager = llllllllllllllIIlIlIlIIIIIIlllII;
        this.lootedEntity = llllllllllllllIIlIlIlIIIIIIllIll;
        this.player = llllllllllllllIIlIlIlIIIIIIllIlI;
        this.damageSource = llllllllllllllIIlIlIlIIIIIIllIIl;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$world$storage$loot$LootContext$EntityTarget() {
        final int[] $switch_TABLE$net$minecraft$world$storage$loot$LootContext$EntityTarget = LootContext.$SWITCH_TABLE$net$minecraft$world$storage$loot$LootContext$EntityTarget;
        if ($switch_TABLE$net$minecraft$world$storage$loot$LootContext$EntityTarget != null) {
            return $switch_TABLE$net$minecraft$world$storage$loot$LootContext$EntityTarget;
        }
        final short llllllllllllllIIlIlIIlllllllIllI = (Object)new int[EntityTarget.values().length];
        try {
            llllllllllllllIIlIlIIlllllllIllI[EntityTarget.KILLER.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIlIlIIlllllllIllI[EntityTarget.KILLER_PLAYER.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIlIlIIlllllllIllI[EntityTarget.THIS.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return LootContext.$SWITCH_TABLE$net$minecraft$world$storage$loot$LootContext$EntityTarget = (int[])(Object)llllllllllllllIIlIlIIlllllllIllI;
    }
    
    public LootTableManager getLootTableManager() {
        return this.lootTableManager;
    }
    
    public boolean addLootTable(final LootTable llllllllllllllIIlIlIlIIIIIIIlIlI) {
        return this.lootTables.add(llllllllllllllIIlIlIlIIIIIIIlIlI);
    }
    
    @Nullable
    public Entity getKillerPlayer() {
        return this.player;
    }
    
    @Nullable
    public Entity getLootedEntity() {
        return this.lootedEntity;
    }
    
    public void removeLootTable(final LootTable llllllllllllllIIlIlIlIIIIIIIIlII) {
        this.lootTables.remove(llllllllllllllIIlIlIlIIIIIIIIlII);
    }
    
    @Nullable
    public Entity getEntity(final EntityTarget llllllllllllllIIlIlIIllllllllIlI) {
        switch ($SWITCH_TABLE$net$minecraft$world$storage$loot$LootContext$EntityTarget()[llllllllllllllIIlIlIIllllllllIlI.ordinal()]) {
            case 1: {
                return this.getLootedEntity();
            }
            case 2: {
                return this.getKiller();
            }
            case 3: {
                return this.getKillerPlayer();
            }
            default: {
                return null;
            }
        }
    }
    
    @Nullable
    public Entity getKiller() {
        return (this.damageSource == null) ? null : this.damageSource.getEntity();
    }
    
    public enum EntityTarget
    {
        private final /* synthetic */ String targetType;
        
        KILLER_PLAYER("KILLER_PLAYER", 2, "killer_player"), 
        KILLER("KILLER", 1, "killer"), 
        THIS("THIS", 0, "this");
        
        private EntityTarget(final String lllllllllllllIIllIIIIlIIllllllIl, final int lllllllllllllIIllIIIIlIIllllllII, final String lllllllllllllIIllIIIIlIIllllllll) {
            this.targetType = lllllllllllllIIllIIIIlIIllllllll;
        }
        
        public static EntityTarget fromString(final String lllllllllllllIIllIIIIlIIllllIlIl) {
            final short lllllllllllllIIllIIIIlIIlllIllll;
            final String lllllllllllllIIllIIIIlIIllllIIII = (String)((EntityTarget[])(Object)(lllllllllllllIIllIIIIlIIlllIllll = (short)(Object)values())).length;
            for (boolean lllllllllllllIIllIIIIlIIllllIIIl = false; lllllllllllllIIllIIIIlIIllllIIIl < lllllllllllllIIllIIIIlIIllllIIII; ++lllllllllllllIIllIIIIlIIllllIIIl) {
                final EntityTarget lllllllllllllIIllIIIIlIIllllIlII = lllllllllllllIIllIIIIlIIlllIllll[lllllllllllllIIllIIIIlIIllllIIIl];
                if (lllllllllllllIIllIIIIlIIllllIlII.targetType.equals(lllllllllllllIIllIIIIlIIllllIlIl)) {
                    return lllllllllllllIIllIIIIlIIllllIlII;
                }
            }
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Invalid entity target ").append(lllllllllllllIIllIIIIlIIllllIlIl)));
        }
        
        public static class Serializer extends TypeAdapter<EntityTarget>
        {
            public void write(final JsonWriter lllllllllllllllIlIllIIIIIlIIIIlI, final EntityTarget lllllllllllllllIlIllIIIIIlIIIIIl) throws IOException {
                lllllllllllllllIlIllIIIIIlIIIIlI.value(lllllllllllllllIlIllIIIIIlIIIIIl.targetType);
            }
            
            public EntityTarget read(final JsonReader lllllllllllllllIlIllIIIIIIllllIl) throws IOException {
                return EntityTarget.fromString(lllllllllllllllIlIllIIIIIIllllIl.nextString());
            }
        }
    }
    
    public static class Builder
    {
        private /* synthetic */ EntityPlayer player;
        private /* synthetic */ float luck;
        private /* synthetic */ Entity lootedEntity;
        private /* synthetic */ DamageSource damageSource;
        private final /* synthetic */ WorldServer worldObj;
        
        public Builder withLuck(final float lllllllllllllllIIIIIlllllIlIlIIl) {
            this.luck = lllllllllllllllIIIIIlllllIlIlIIl;
            return this;
        }
        
        public Builder withLootedEntity(final Entity lllllllllllllllIIIIIlllllIlIIlIl) {
            this.lootedEntity = lllllllllllllllIIIIIlllllIlIIlIl;
            return this;
        }
        
        public Builder withDamageSource(final DamageSource lllllllllllllllIIIIIlllllIIllIIl) {
            this.damageSource = lllllllllllllllIIIIIlllllIIllIIl;
            return this;
        }
        
        public LootContext build() {
            return new LootContext(this.luck, this.worldObj, this.worldObj.getLootTableManager(), this.lootedEntity, this.player, this.damageSource);
        }
        
        public Builder(final WorldServer lllllllllllllllIIIIIlllllIllIIIl) {
            this.worldObj = lllllllllllllllIIIIIlllllIllIIIl;
        }
        
        public Builder withPlayer(final EntityPlayer lllllllllllllllIIIIIlllllIIlllIl) {
            this.player = lllllllllllllllIIIIIlllllIIlllIl;
            return this;
        }
    }
}
