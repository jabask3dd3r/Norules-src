package net.minecraft.util;

import javax.annotation.*;
import com.google.common.collect.*;
import java.util.*;

public enum EnumParticleTypes
{
    BLOCK_DUST("BLOCK_DUST", 38, "blockdust", 38, false, 1), 
    ITEM_TAKE("ITEM_TAKE", 40, "take", 40, false), 
    FALLING_DUST("FALLING_DUST", 46, "fallingdust", 46, false, 1), 
    PORTAL("PORTAL", 24, "portal", 24, false), 
    WATER_BUBBLE("WATER_BUBBLE", 4, "bubble", 4, false);
    
    private static final /* synthetic */ Map<String, EnumParticleTypes> BY_NAME;
    
    VILLAGER_ANGRY("VILLAGER_ANGRY", 20, "angryVillager", 20, false), 
    LAVA("LAVA", 27, "lava", 27, false), 
    HEART("HEART", 34, "heart", 34, false), 
    BARRIER("BARRIER", 35, "barrier", 35, false), 
    NOTE("NOTE", 23, "note", 23, false);
    
    private static final /* synthetic */ Map<Integer, EnumParticleTypes> PARTICLES;
    private final /* synthetic */ boolean shouldIgnoreRange;
    
    SNOWBALL("SNOWBALL", 31, "snowballpoof", 31, false), 
    WATER_WAKE("WATER_WAKE", 6, "wake", 6, false), 
    DRIP_LAVA("DRIP_LAVA", 19, "dripLava", 19, false), 
    TOWN_AURA("TOWN_AURA", 22, "townaura", 22, false), 
    SUSPENDED_DEPTH("SUSPENDED_DEPTH", 8, "depthsuspend", 8, false), 
    DRAGON_BREATH("DRAGON_BREATH", 42, "dragonbreath", 42, false), 
    FLAME("FLAME", 26, "flame", 26, false), 
    EXPLOSION_LARGE("EXPLOSION_LARGE", 1, "largeexplode", 1, true), 
    SUSPENDED("SUSPENDED", 7, "suspended", 7, false), 
    EXPLOSION_HUGE("EXPLOSION_HUGE", 2, "hugeexplosion", 2, true), 
    SMOKE_LARGE("SMOKE_LARGE", 12, "largesmoke", 12, false), 
    CRIT_MAGIC("CRIT_MAGIC", 10, "magicCrit", 10, false), 
    SLIME("SLIME", 33, "slime", 33, false), 
    REDSTONE("REDSTONE", 30, "reddust", 30, false), 
    FIREWORKS_SPARK("FIREWORKS_SPARK", 3, "fireworksSpark", 3, false);
    
    private final /* synthetic */ int argumentCount;
    
    ENCHANTMENT_TABLE("ENCHANTMENT_TABLE", 25, "enchantmenttable", 25, false), 
    VILLAGER_HAPPY("VILLAGER_HAPPY", 21, "happyVillager", 21, false), 
    WATER_SPLASH("WATER_SPLASH", 5, "splash", 5, false), 
    BLOCK_CRACK("BLOCK_CRACK", 37, "blockcrack", 37, false, 1), 
    CLOUD("CLOUD", 29, "cloud", 29, false), 
    MOB_APPEARANCE("MOB_APPEARANCE", 41, "mobappearance", 41, true), 
    CRIT("CRIT", 9, "crit", 9, false), 
    SNOW_SHOVEL("SNOW_SHOVEL", 32, "snowshovel", 32, false), 
    DRIP_WATER("DRIP_WATER", 18, "dripWater", 18, false), 
    SPELL_MOB("SPELL_MOB", 15, "mobSpell", 15, false), 
    SPELL("SPELL", 13, "spell", 13, false), 
    SPELL_WITCH("SPELL_WITCH", 17, "witchMagic", 17, false), 
    SMOKE_NORMAL("SMOKE_NORMAL", 11, "smoke", 11, false);
    
    private final /* synthetic */ String particleName;
    
    SWEEP_ATTACK("SWEEP_ATTACK", 45, "sweepAttack", 45, true), 
    FOOTSTEP("FOOTSTEP", 28, "footstep", 28, false), 
    SPELL_INSTANT("SPELL_INSTANT", 14, "instantSpell", 14, false), 
    ITEM_CRACK("ITEM_CRACK", 36, "iconcrack", 36, false, 2), 
    SPIT("SPIT", 48, "spit", 48, true);
    
    private final /* synthetic */ int particleID;
    
    DAMAGE_INDICATOR("DAMAGE_INDICATOR", 44, "damageIndicator", 44, true), 
    TOTEM("TOTEM", 47, "totem", 47, false), 
    SPELL_MOB_AMBIENT("SPELL_MOB_AMBIENT", 16, "mobSpellAmbient", 16, false), 
    END_ROD("END_ROD", 43, "endRod", 43, false), 
    WATER_DROP("WATER_DROP", 39, "droplet", 39, false), 
    EXPLOSION_NORMAL("EXPLOSION_NORMAL", 0, "explode", 0, true);
    
    public int getParticleID() {
        return this.particleID;
    }
    
    private EnumParticleTypes(final String lllllllllllllIIIIllIllIIIlIlIlll, final int lllllllllllllIIIIllIllIIIlIlIllI, final String lllllllllllllIIIIllIllIIIlIlIlIl, final int lllllllllllllIIIIllIllIIIlIlIlII, final boolean lllllllllllllIIIIllIllIIIlIllIIl) {
        this(lllllllllllllIIIIllIllIIIlIlIlll, lllllllllllllIIIIllIllIIIlIlIllI, lllllllllllllIIIIllIllIIIlIlIlIl, lllllllllllllIIIIllIllIIIlIlIlII, lllllllllllllIIIIllIllIIIlIllIIl, 0);
    }
    
    public boolean getShouldIgnoreRange() {
        return this.shouldIgnoreRange;
    }
    
    @Nullable
    public static EnumParticleTypes getParticleFromId(final int lllllllllllllIIIIllIllIIIlIIIlII) {
        return EnumParticleTypes.PARTICLES.get(lllllllllllllIIIIllIllIIIlIIIlII);
    }
    
    public String getParticleName() {
        return this.particleName;
    }
    
    public int getArgumentCount() {
        return this.argumentCount;
    }
    
    static {
        PARTICLES = Maps.newHashMap();
        BY_NAME = Maps.newHashMap();
        final byte lllllllllllllIIIIllIllIIIlllIllI;
        final float lllllllllllllIIIIllIllIIIlllIlll = ((EnumParticleTypes[])(Object)(lllllllllllllIIIIllIllIIIlllIllI = (byte)(Object)values())).length;
        for (byte lllllllllllllIIIIllIllIIIllllIII = 0; lllllllllllllIIIIllIllIIIllllIII < lllllllllllllIIIIllIllIIIlllIlll; ++lllllllllllllIIIIllIllIIIllllIII) {
            final EnumParticleTypes lllllllllllllIIIIllIllIIIllllIlI = lllllllllllllIIIIllIllIIIlllIllI[lllllllllllllIIIIllIllIIIllllIII];
            EnumParticleTypes.PARTICLES.put(lllllllllllllIIIIllIllIIIllllIlI.getParticleID(), lllllllllllllIIIIllIllIIIllllIlI);
            EnumParticleTypes.BY_NAME.put(lllllllllllllIIIIllIllIIIllllIlI.getParticleName(), lllllllllllllIIIIllIllIIIllllIlI);
        }
    }
    
    public static Set<String> getParticleNames() {
        return EnumParticleTypes.BY_NAME.keySet();
    }
    
    private EnumParticleTypes(final String lllllllllllllIIIIllIllIIIllIlIII, final int lllllllllllllIIIIllIllIIIllIIlll, final String lllllllllllllIIIIllIllIIIllIIllI, final int lllllllllllllIIIIllIllIIIllIIlIl, final boolean lllllllllllllIIIIllIllIIIllIIlII, final int lllllllllllllIIIIllIllIIIllIIIll) {
        this.particleName = lllllllllllllIIIIllIllIIIllIIllI;
        this.particleID = lllllllllllllIIIIllIllIIIllIIlIl;
        this.shouldIgnoreRange = lllllllllllllIIIIllIllIIIllIIlII;
        this.argumentCount = lllllllllllllIIIIllIllIIIllIIIll;
    }
    
    @Nullable
    public static EnumParticleTypes getByName(final String lllllllllllllIIIIllIllIIIlIIIIIl) {
        return EnumParticleTypes.BY_NAME.get(lllllllllllllIIIIllIllIIIlIIIIIl);
    }
}
