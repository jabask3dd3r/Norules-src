package net.minecraft.util;

import javax.annotation.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.util.text.*;
import net.minecraft.entity.projectile.*;

public class DamageSource
{
    private /* synthetic */ boolean magicDamage;
    private /* synthetic */ boolean projectile;
    private /* synthetic */ boolean fireDamage;
    private /* synthetic */ boolean isUnblockable;
    private /* synthetic */ float hungerDamage;
    public /* synthetic */ String damageType;
    private /* synthetic */ boolean difficultyScaled;
    private /* synthetic */ boolean explosion;
    private /* synthetic */ boolean isDamageAllowedInCreativeMode;
    private /* synthetic */ boolean damageIsAbsolute;
    
    public DamageSource setMagicDamage() {
        this.magicDamage = true;
        return this;
    }
    
    protected DamageSource setFireDamage() {
        this.fireDamage = true;
        return this;
    }
    
    public static DamageSource causeThornsDamage(final Entity llllllllllllllllIlIlIlllllIIIlII) {
        return new EntityDamageSource("thorns", llllllllllllllllIlIlIlllllIIIlII).setIsThornsDamage().setMagicDamage();
    }
    
    public boolean isExplosion() {
        return this.explosion;
    }
    
    protected DamageSource setDamageAllowedInCreativeMode() {
        this.isDamageAllowedInCreativeMode = true;
        return this;
    }
    
    public static DamageSource causeArrowDamage(final EntityArrow llllllllllllllllIlIlIllllllIIlll, @Nullable final Entity llllllllllllllllIlIlIllllllIIlII) {
        return new EntityDamageSourceIndirect("arrow", llllllllllllllllIlIlIllllllIIlll, llllllllllllllllIlIlIllllllIIlII).setProjectile();
    }
    
    @Nullable
    public Entity getEntity() {
        return null;
    }
    
    public float getHungerDamage() {
        return this.hungerDamage;
    }
    
    public static DamageSource causeIndirectDamage(final Entity llllllllllllllllIlIlIlllllllIIII, final EntityLivingBase llllllllllllllllIlIlIllllllIllIl) {
        return new EntityDamageSourceIndirect("mob", llllllllllllllllIlIlIlllllllIIII, llllllllllllllllIlIlIllllllIllIl);
    }
    
    public DamageSource setDifficultyScaled() {
        this.difficultyScaled = true;
        return this;
    }
    
    public static DamageSource causeExplosionDamage(@Nullable final Explosion llllllllllllllllIlIlIlllllIIIIIl) {
        return (llllllllllllllllIlIlIlllllIIIIIl != null && llllllllllllllllIlIlIlllllIIIIIl.getExplosivePlacedBy() != null) ? new EntityDamageSource("explosion.player", llllllllllllllllIlIlIlllllIIIIIl.getExplosivePlacedBy()).setDifficultyScaled().setExplosion() : new DamageSource("explosion").setDifficultyScaled().setExplosion();
    }
    
    public boolean isCreativePlayer() {
        final Entity llllllllllllllllIlIlIlllIllIlIlI = this.getEntity();
        return llllllllllllllllIlIlIlllIllIlIlI instanceof EntityPlayer && ((EntityPlayer)llllllllllllllllIlIlIlllIllIlIlI).capabilities.isCreativeMode;
    }
    
    public static DamageSource causeIndirectMagicDamage(final Entity llllllllllllllllIlIlIlllllIIlIlI, @Nullable final Entity llllllllllllllllIlIlIlllllIIllII) {
        return new EntityDamageSourceIndirect("indirectMagic", llllllllllllllllIlIlIlllllIIlIlI, llllllllllllllllIlIlIlllllIIllII).setDamageBypassesArmor().setMagicDamage();
    }
    
    public DamageSource setProjectile() {
        this.projectile = true;
        return this;
    }
    
    public static DamageSource causeMobDamage(final EntityLivingBase llllllllllllllllIlIlIlllllllIIll) {
        return new EntityDamageSource("mob", llllllllllllllllIlIlIlllllllIIll);
    }
    
    public static DamageSource causeThrownDamage(final Entity llllllllllllllllIlIlIlllllIllIII, @Nullable final Entity llllllllllllllllIlIlIlllllIlIlII) {
        return new EntityDamageSourceIndirect("thrown", llllllllllllllllIlIlIlllllIllIII, llllllllllllllllIlIlIlllllIlIlII).setProjectile();
    }
    
    protected DamageSource setDamageIsAbsolute() {
        this.damageIsAbsolute = true;
        this.hungerDamage = 0.0f;
        return this;
    }
    
    public boolean isMagicDamage() {
        return this.magicDamage;
    }
    
    public boolean isFireDamage() {
        return this.fireDamage;
    }
    
    public static DamageSource causeExplosionDamage(@Nullable final EntityLivingBase llllllllllllllllIlIlIllllIlllllI) {
        return (llllllllllllllllIlIlIllllIlllllI != null) ? new EntityDamageSource("explosion.player", llllllllllllllllIlIlIllllIlllllI).setDifficultyScaled().setExplosion() : new DamageSource("explosion").setDifficultyScaled().setExplosion();
    }
    
    public String getDamageType() {
        return this.damageType;
    }
    
    public boolean isDamageAbsolute() {
        return this.damageIsAbsolute;
    }
    
    @Nullable
    public Vec3d getDamageLocation() {
        return null;
    }
    
    public DamageSource setExplosion() {
        this.explosion = true;
        return this;
    }
    
    public boolean isDifficultyScaled() {
        return this.difficultyScaled;
    }
    
    protected DamageSource(final String llllllllllllllllIlIlIllllIlIIIIl) {
        this.hungerDamage = 0.1f;
        this.damageType = llllllllllllllllIlIlIllllIlIIIIl;
    }
    
    public boolean isUnblockable() {
        return this.isUnblockable;
    }
    
    protected DamageSource setDamageBypassesArmor() {
        this.isUnblockable = true;
        this.hungerDamage = 0.0f;
        return this;
    }
    
    public ITextComponent getDeathMessage(final EntityLivingBase llllllllllllllllIlIlIllllIIIIIll) {
        final EntityLivingBase llllllllllllllllIlIlIllllIIIIlll = llllllllllllllllIlIlIllllIIIIIll.getAttackingEntity();
        final String llllllllllllllllIlIlIllllIIIIllI = String.valueOf(new StringBuilder("death.attack.").append(this.damageType));
        final String llllllllllllllllIlIlIllllIIIIlIl = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIlIlIllllIIIIllI)).append(".player"));
        return (llllllllllllllllIlIlIllllIIIIlll != null && I18n.canTranslate(llllllllllllllllIlIlIllllIIIIlIl)) ? new TextComponentTranslation(llllllllllllllllIlIlIllllIIIIlIl, new Object[] { llllllllllllllllIlIlIllllIIIIIll.getDisplayName(), llllllllllllllllIlIlIllllIIIIlll.getDisplayName() }) : new TextComponentTranslation(llllllllllllllllIlIlIllllIIIIllI, new Object[] { llllllllllllllllIlIlIllllIIIIIll.getDisplayName() });
    }
    
    static {
        inFire = new DamageSource("inFire").setFireDamage();
        lightningBolt = new DamageSource("lightningBolt");
        onFire = new DamageSource("onFire").setDamageBypassesArmor().setFireDamage();
        lava = new DamageSource("lava").setFireDamage();
        hotFloor = new DamageSource("hotFloor").setFireDamage();
        inWall = new DamageSource("inWall").setDamageBypassesArmor();
        field_191291_g = new DamageSource("cramming").setDamageBypassesArmor();
        drown = new DamageSource("drown").setDamageBypassesArmor();
        starve = new DamageSource("starve").setDamageBypassesArmor().setDamageIsAbsolute();
        cactus = new DamageSource("cactus");
        fall = new DamageSource("fall").setDamageBypassesArmor();
        flyIntoWall = new DamageSource("flyIntoWall").setDamageBypassesArmor();
        outOfWorld = new DamageSource("outOfWorld").setDamageBypassesArmor().setDamageAllowedInCreativeMode();
        generic = new DamageSource("generic").setDamageBypassesArmor();
        magic = new DamageSource("magic").setDamageBypassesArmor().setMagicDamage();
        wither = new DamageSource("wither").setDamageBypassesArmor();
        anvil = new DamageSource("anvil");
        fallingBlock = new DamageSource("fallingBlock");
        dragonBreath = new DamageSource("dragonBreath").setDamageBypassesArmor();
        field_191552_t = new DamageSource("fireworks").setExplosion();
    }
    
    @Nullable
    public Entity getSourceOfDamage() {
        return this.getEntity();
    }
    
    public boolean canHarmInCreative() {
        return this.isDamageAllowedInCreativeMode;
    }
    
    public static DamageSource causeFireballDamage(final EntityFireball llllllllllllllllIlIlIlllllIlllll, @Nullable final Entity llllllllllllllllIlIlIlllllIllllI) {
        return (llllllllllllllllIlIlIlllllIllllI == null) ? new EntityDamageSourceIndirect("onFire", llllllllllllllllIlIlIlllllIlllll, llllllllllllllllIlIlIlllllIlllll).setFireDamage().setProjectile() : new EntityDamageSourceIndirect("fireball", llllllllllllllllIlIlIlllllIlllll, llllllllllllllllIlIlIlllllIllllI).setFireDamage().setProjectile();
    }
    
    public boolean isProjectile() {
        return this.projectile;
    }
    
    public static DamageSource causePlayerDamage(final EntityPlayer llllllllllllllllIlIlIllllllIlIlI) {
        return new EntityDamageSource("player", llllllllllllllllIlIlIllllllIlIlI);
    }
}
