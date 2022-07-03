package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types;

import java.util.*;

public enum Particle
{
    SLIME("slime"), 
    ICON_CRACK("iconcrack", 2), 
    DRIP_LAVA("dripLava"), 
    SPELL_MOB("mobSpell"), 
    VILLAGER_ANGRY("angryVillager"), 
    HEART("heart"), 
    SMOKE_LARGE("largesmoke"), 
    TOWN_AURA("townaura"), 
    SNOWBALL("snowballpoof"), 
    BLOCK_CRACK("blockcrack", 1), 
    MOB_APPEARANCE("mobappearance"), 
    EXPLOSION_NORMAL("explode"), 
    SUSPENDED_DEPTH("depthsuspend");
    
    public final /* synthetic */ String name;
    
    WATER_SPLASH("splash"), 
    BARRIER("barrier"), 
    SPELL_WITCH("witchMagic"), 
    SUSPENDED("suspended"), 
    NOTE("note"), 
    WATER_DROP("droplet"), 
    CLOUD("cloud"), 
    SMOKE_NORMAL("smoke"), 
    FIREWORKS_SPARK("fireworksSpark"), 
    ITEM_TAKE("take"), 
    EXPLOSION_LARGE("largeexplode"), 
    REDSTONE("reddust"), 
    WATER_BUBBLE("bubble"), 
    VILLAGER_HAPPY("happyVillager");
    
    public final /* synthetic */ int extra;
    
    FOOTSTEP("footstep"), 
    SPELL("spell"), 
    SPELL_INSTANT("instantSpell"), 
    LAVA("lava"), 
    WATER_WAKE("wake"), 
    PORTAL("portal"), 
    SNOW_SHOVEL("snowshovel"), 
    BLOCK_DUST("blockdust", 1);
    
    private static final /* synthetic */ HashMap<String, Particle> particleMap;
    
    SPELL_MOB_AMBIENT("mobSpellAmbient"), 
    ENCHANTMENT_TABLE("enchantmenttable"), 
    CRIT("crit"), 
    DRIP_WATER("dripWater"), 
    CRIT_MAGIC("magicCrit"), 
    FLAME("flame"), 
    EXPLOSION_HUGE("hugeexplosion");
    
    private Particle(final String lllllllllllllIIIIIIIlIlIlIIIlIII) {
        this(lllllllllllllIIIIIIIlIlIlIIIlIII, 0);
    }
    
    static {
        particleMap = new HashMap<String, Particle>();
        final int lllllllllllllIIIIIIIlIlIIlIlIIlI;
        final Particle[] lllllllllllllIIIIIIIlIlIIlIlIlII = (Object)(lllllllllllllIIIIIIIlIlIIlIlIIlI = (int)(Object)values());
        final double lllllllllllllIIIIIIIlIlIIlIlIIIl = lllllllllllllIIIIIIIlIlIIlIlIIlI.length;
        for (char lllllllllllllIIIIIIIlIlIIlIlIIII = '\0'; lllllllllllllIIIIIIIlIlIIlIlIIII < lllllllllllllIIIIIIIlIlIIlIlIIIl; ++lllllllllllllIIIIIIIlIlIIlIlIIII) {
            final Particle lllllllllllllIIIIIIIlIlIIlIlIlIl = lllllllllllllIIIIIIIlIlIIlIlIIlI[lllllllllllllIIIIIIIlIlIIlIlIIII];
            Particle.particleMap.put(lllllllllllllIIIIIIIlIlIIlIlIlIl.name, lllllllllllllIIIIIIIlIlIIlIlIlIl);
        }
    }
    
    public static Particle find(final String lllllllllllllIIIIIIIlIlIIllIIlll) {
        return Particle.particleMap.get(lllllllllllllIIIIIIIlIlIIllIIlll);
    }
    
    private Particle(final String lllllllllllllIIIIIIIlIlIIlllIlll, final int lllllllllllllIIIIIIIlIlIIlllIIII) {
        this.name = lllllllllllllIIIIIIIlIlIIlllIlll;
        this.extra = lllllllllllllIIIIIIIlIlIIlllIIII;
    }
    
    public static Particle find(final int lllllllllllllIIIIIIIlIlIIlIlllll) {
        if (lllllllllllllIIIIIIIlIlIIlIlllll < 0) {
            return null;
        }
        final Particle[] lllllllllllllIIIIIIIlIlIIlIlllIl = values();
        return (lllllllllllllIIIIIIIlIlIIlIlllll >= lllllllllllllIIIIIIIlIlIIlIlllIl.length) ? null : lllllllllllllIIIIIIIlIlIIlIlllIl[lllllllllllllIIIIIIIlIlIIlIlllll];
    }
}
