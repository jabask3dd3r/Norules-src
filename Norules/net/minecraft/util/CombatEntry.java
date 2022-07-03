package net.minecraft.util;

import javax.annotation.*;
import net.minecraft.util.text.*;
import net.minecraft.entity.*;

public class CombatEntry
{
    private final /* synthetic */ DamageSource damageSrc;
    private final /* synthetic */ float fallDistance;
    private final /* synthetic */ float health;
    private final /* synthetic */ String fallSuffix;
    private final /* synthetic */ int time;
    private final /* synthetic */ float damage;
    
    public CombatEntry(final DamageSource lllllllllllllIlllIIIlIIlllIIlllI, final int lllllllllllllIlllIIIlIIlllIIIllI, final float lllllllllllllIlllIIIlIIlllIIllII, final float lllllllllllllIlllIIIlIIlllIIIlII, final String lllllllllllllIlllIIIlIIlllIIIIll, final float lllllllllllllIlllIIIlIIlllIIlIIl) {
        this.damageSrc = lllllllllllllIlllIIIlIIlllIIlllI;
        this.time = lllllllllllllIlllIIIlIIlllIIIllI;
        this.damage = lllllllllllllIlllIIIlIIlllIIIlII;
        this.health = lllllllllllllIlllIIIlIIlllIIllII;
        this.fallSuffix = lllllllllllllIlllIIIlIIlllIIIIll;
        this.fallDistance = lllllllllllllIlllIIIlIIlllIIlIIl;
    }
    
    @Nullable
    public String getFallSuffix() {
        return this.fallSuffix;
    }
    
    public DamageSource getDamageSrc() {
        return this.damageSrc;
    }
    
    public float getDamageAmount() {
        return (this.damageSrc == DamageSource.outOfWorld) ? Float.MAX_VALUE : this.fallDistance;
    }
    
    @Nullable
    public ITextComponent getDamageSrcDisplayName() {
        return (this.getDamageSrc().getEntity() == null) ? null : this.getDamageSrc().getEntity().getDisplayName();
    }
    
    public float getDamage() {
        return this.damage;
    }
    
    public boolean isLivingDamageSrc() {
        return this.damageSrc.getEntity() instanceof EntityLivingBase;
    }
}
