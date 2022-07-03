package net.minecraft.entity;

import javax.annotation.*;
import net.minecraft.potion.*;
import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import com.google.common.collect.*;
import net.minecraft.block.material.*;
import net.minecraft.network.datasync.*;

public class EntityAreaEffectCloud extends Entity
{
    private /* synthetic */ EntityLivingBase owner;
    private /* synthetic */ int reapplicationDelay;
    private /* synthetic */ int durationOnUse;
    private static final /* synthetic */ DataParameter<Integer> COLOR;
    private /* synthetic */ int waitTime;
    private /* synthetic */ UUID ownerUniqueId;
    private final /* synthetic */ Map<Entity, Integer> reapplicationDelayMap;
    private /* synthetic */ float radiusOnUse;
    private static final /* synthetic */ DataParameter<Boolean> IGNORE_RADIUS;
    private /* synthetic */ PotionType potion;
    private /* synthetic */ float radiusPerTick;
    private static final /* synthetic */ DataParameter<Integer> PARTICLE_PARAM_1;
    private static final /* synthetic */ DataParameter<Integer> PARTICLE_PARAM_2;
    private /* synthetic */ boolean colorSet;
    private /* synthetic */ int duration;
    private final /* synthetic */ List<PotionEffect> effects;
    private static final /* synthetic */ DataParameter<Float> RADIUS;
    private static final /* synthetic */ DataParameter<Integer> PARTICLE;
    
    @Nullable
    public EntityLivingBase getOwner() {
        if (this.owner == null && this.ownerUniqueId != null && this.world instanceof WorldServer) {
            final Entity lllllllllllllllIIlIllIlIIIlIIllI = ((WorldServer)this.world).getEntityFromUuid(this.ownerUniqueId);
            if (lllllllllllllllIIlIllIlIIIlIIllI instanceof EntityLivingBase) {
                this.owner = (EntityLivingBase)lllllllllllllllIIlIllIlIIIlIIllI;
            }
        }
        return this.owner;
    }
    
    public void setRadius(final float lllllllllllllllIIlIllIlIllIlIlll) {
        final double lllllllllllllllIIlIllIlIllIlIllI = this.posX;
        final double lllllllllllllllIIlIllIlIllIlIlIl = this.posY;
        final double lllllllllllllllIIlIllIlIllIlIlII = this.posZ;
        this.setSize(lllllllllllllllIIlIllIlIllIlIlll * 2.0f, 0.5f);
        this.setPosition(lllllllllllllllIIlIllIlIllIlIllI, lllllllllllllllIIlIllIlIllIlIlIl, lllllllllllllllIIlIllIlIllIlIlII);
        if (!this.world.isRemote) {
            this.getDataManager().set(EntityAreaEffectCloud.RADIUS, lllllllllllllllIIlIllIlIllIlIlll);
        }
    }
    
    public int getParticleParam1() {
        return this.getDataManager().get(EntityAreaEffectCloud.PARTICLE_PARAM_1);
    }
    
    public void setParticleParam1(final int lllllllllllllllIIlIllIlIlIlIIlII) {
        this.getDataManager().set(EntityAreaEffectCloud.PARTICLE_PARAM_1, lllllllllllllllIIlIllIlIlIlIIlII);
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound lllllllllllllllIIlIllIlIIIIlllIl) {
        this.ticksExisted = lllllllllllllllIIlIllIlIIIIlllIl.getInteger("Age");
        this.duration = lllllllllllllllIIlIllIlIIIIlllIl.getInteger("Duration");
        this.waitTime = lllllllllllllllIIlIllIlIIIIlllIl.getInteger("WaitTime");
        this.reapplicationDelay = lllllllllllllllIIlIllIlIIIIlllIl.getInteger("ReapplicationDelay");
        this.durationOnUse = lllllllllllllllIIlIllIlIIIIlllIl.getInteger("DurationOnUse");
        this.radiusOnUse = lllllllllllllllIIlIllIlIIIIlllIl.getFloat("RadiusOnUse");
        this.radiusPerTick = lllllllllllllllIIlIllIlIIIIlllIl.getFloat("RadiusPerTick");
        this.setRadius(lllllllllllllllIIlIllIlIIIIlllIl.getFloat("Radius"));
        this.ownerUniqueId = lllllllllllllllIIlIllIlIIIIlllIl.getUniqueId("OwnerUUID");
        if (lllllllllllllllIIlIllIlIIIIlllIl.hasKey("Particle", 8)) {
            final EnumParticleTypes lllllllllllllllIIlIllIlIIIIlllII = EnumParticleTypes.getByName(lllllllllllllllIIlIllIlIIIIlllIl.getString("Particle"));
            if (lllllllllllllllIIlIllIlIIIIlllII != null) {
                this.setParticle(lllllllllllllllIIlIllIlIIIIlllII);
                this.setParticleParam1(lllllllllllllllIIlIllIlIIIIlllIl.getInteger("ParticleParam1"));
                this.setParticleParam2(lllllllllllllllIIlIllIlIIIIlllIl.getInteger("ParticleParam2"));
            }
        }
        if (lllllllllllllllIIlIllIlIIIIlllIl.hasKey("Color", 99)) {
            this.setColor(lllllllllllllllIIlIllIlIIIIlllIl.getInteger("Color"));
        }
        if (lllllllllllllllIIlIllIlIIIIlllIl.hasKey("Potion", 8)) {
            this.setPotion(PotionUtils.getPotionTypeFromNBT(lllllllllllllllIIlIllIlIIIIlllIl));
        }
        if (lllllllllllllllIIlIllIlIIIIlllIl.hasKey("Effects", 9)) {
            final NBTTagList lllllllllllllllIIlIllIlIIIIllIll = lllllllllllllllIIlIllIlIIIIlllIl.getTagList("Effects", 10);
            this.effects.clear();
            for (int lllllllllllllllIIlIllIlIIIIllIlI = 0; lllllllllllllllIIlIllIlIIIIllIlI < lllllllllllllllIIlIllIlIIIIllIll.tagCount(); ++lllllllllllllllIIlIllIlIIIIllIlI) {
                final PotionEffect lllllllllllllllIIlIllIlIIIIllIIl = PotionEffect.readCustomPotionEffectFromNBT(lllllllllllllllIIlIllIlIIIIllIll.getCompoundTagAt(lllllllllllllllIIlIllIlIIIIllIlI));
                if (lllllllllllllllIIlIllIlIIIIllIIl != null) {
                    this.addEffect(lllllllllllllllIIlIllIlIIIIllIIl);
                }
            }
        }
    }
    
    public int getDuration() {
        return this.duration;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        final boolean lllllllllllllllIIlIllIlIIlllIlII = this.shouldIgnoreRadius();
        float lllllllllllllllIIlIllIlIIlllIIll = this.getRadius();
        if (this.world.isRemote) {
            final EnumParticleTypes lllllllllllllllIIlIllIlIIlllIIlI = this.getParticle();
            final int[] lllllllllllllllIIlIllIlIIlllIIIl = new int[lllllllllllllllIIlIllIlIIlllIIlI.getArgumentCount()];
            if (lllllllllllllllIIlIllIlIIlllIIIl.length > 0) {
                lllllllllllllllIIlIllIlIIlllIIIl[0] = this.getParticleParam1();
            }
            if (lllllllllllllllIIlIllIlIIlllIIIl.length > 1) {
                lllllllllllllllIIlIllIlIIlllIIIl[1] = this.getParticleParam2();
            }
            if (lllllllllllllllIIlIllIlIIlllIlII) {
                if (this.rand.nextBoolean()) {
                    for (int lllllllllllllllIIlIllIlIIlllIIII = 0; lllllllllllllllIIlIllIlIIlllIIII < 2; ++lllllllllllllllIIlIllIlIIlllIIII) {
                        final float lllllllllllllllIIlIllIlIIllIllll = this.rand.nextFloat() * 6.2831855f;
                        final float lllllllllllllllIIlIllIlIIllIlllI = MathHelper.sqrt(this.rand.nextFloat()) * 0.2f;
                        final float lllllllllllllllIIlIllIlIIllIllIl = MathHelper.cos(lllllllllllllllIIlIllIlIIllIllll) * lllllllllllllllIIlIllIlIIllIlllI;
                        final float lllllllllllllllIIlIllIlIIllIllII = MathHelper.sin(lllllllllllllllIIlIllIlIIllIllll) * lllllllllllllllIIlIllIlIIllIlllI;
                        if (lllllllllllllllIIlIllIlIIlllIIlI == EnumParticleTypes.SPELL_MOB) {
                            final int lllllllllllllllIIlIllIlIIllIlIll = this.rand.nextBoolean() ? 16777215 : this.getColor();
                            final int lllllllllllllllIIlIllIlIIllIlIlI = lllllllllllllllIIlIllIlIIllIlIll >> 16 & 0xFF;
                            final int lllllllllllllllIIlIllIlIIllIlIIl = lllllllllllllllIIlIllIlIIllIlIll >> 8 & 0xFF;
                            final int lllllllllllllllIIlIllIlIIllIlIII = lllllllllllllllIIlIllIlIIllIlIll & 0xFF;
                            this.world.func_190523_a(EnumParticleTypes.SPELL_MOB.getParticleID(), this.posX + lllllllllllllllIIlIllIlIIllIllIl, this.posY, this.posZ + lllllllllllllllIIlIllIlIIllIllII, lllllllllllllllIIlIllIlIIllIlIlI / 255.0f, lllllllllllllllIIlIllIlIIllIlIIl / 255.0f, lllllllllllllllIIlIllIlIIllIlIII / 255.0f, new int[0]);
                        }
                        else {
                            this.world.func_190523_a(lllllllllllllllIIlIllIlIIlllIIlI.getParticleID(), this.posX + lllllllllllllllIIlIllIlIIllIllIl, this.posY, this.posZ + lllllllllllllllIIlIllIlIIllIllII, 0.0, 0.0, 0.0, lllllllllllllllIIlIllIlIIlllIIIl);
                        }
                    }
                }
            }
            else {
                final float lllllllllllllllIIlIllIlIIllIIlll = 3.1415927f * lllllllllllllllIIlIllIlIIlllIIll * lllllllllllllllIIlIllIlIIlllIIll;
                for (int lllllllllllllllIIlIllIlIIllIIllI = 0; lllllllllllllllIIlIllIlIIllIIllI < lllllllllllllllIIlIllIlIIllIIlll; ++lllllllllllllllIIlIllIlIIllIIllI) {
                    final float lllllllllllllllIIlIllIlIIllIIlIl = this.rand.nextFloat() * 6.2831855f;
                    final float lllllllllllllllIIlIllIlIIllIIlII = MathHelper.sqrt(this.rand.nextFloat()) * lllllllllllllllIIlIllIlIIlllIIll;
                    final float lllllllllllllllIIlIllIlIIllIIIll = MathHelper.cos(lllllllllllllllIIlIllIlIIllIIlIl) * lllllllllllllllIIlIllIlIIllIIlII;
                    final float lllllllllllllllIIlIllIlIIllIIIlI = MathHelper.sin(lllllllllllllllIIlIllIlIIllIIlIl) * lllllllllllllllIIlIllIlIIllIIlII;
                    if (lllllllllllllllIIlIllIlIIlllIIlI == EnumParticleTypes.SPELL_MOB) {
                        final int lllllllllllllllIIlIllIlIIllIIIIl = this.getColor();
                        final int lllllllllllllllIIlIllIlIIllIIIII = lllllllllllllllIIlIllIlIIllIIIIl >> 16 & 0xFF;
                        final int lllllllllllllllIIlIllIlIIlIlllll = lllllllllllllllIIlIllIlIIllIIIIl >> 8 & 0xFF;
                        final int lllllllllllllllIIlIllIlIIlIllllI = lllllllllllllllIIlIllIlIIllIIIIl & 0xFF;
                        this.world.func_190523_a(EnumParticleTypes.SPELL_MOB.getParticleID(), this.posX + lllllllllllllllIIlIllIlIIllIIIll, this.posY, this.posZ + lllllllllllllllIIlIllIlIIllIIIlI, lllllllllllllllIIlIllIlIIllIIIII / 255.0f, lllllllllllllllIIlIllIlIIlIlllll / 255.0f, lllllllllllllllIIlIllIlIIlIllllI / 255.0f, new int[0]);
                    }
                    else {
                        this.world.func_190523_a(lllllllllllllllIIlIllIlIIlllIIlI.getParticleID(), this.posX + lllllllllllllllIIlIllIlIIllIIIll, this.posY, this.posZ + lllllllllllllllIIlIllIlIIllIIIlI, (0.5 - this.rand.nextDouble()) * 0.15, 0.009999999776482582, (0.5 - this.rand.nextDouble()) * 0.15, lllllllllllllllIIlIllIlIIlllIIIl);
                    }
                }
            }
        }
        else {
            if (this.ticksExisted >= this.waitTime + this.duration) {
                this.setDead();
                return;
            }
            final boolean lllllllllllllllIIlIllIlIIlIlllIl = this.ticksExisted < this.waitTime;
            if (lllllllllllllllIIlIllIlIIlllIlII != lllllllllllllllIIlIllIlIIlIlllIl) {
                this.setIgnoreRadius(lllllllllllllllIIlIllIlIIlIlllIl);
            }
            if (lllllllllllllllIIlIllIlIIlIlllIl) {
                return;
            }
            if (this.radiusPerTick != 0.0f) {
                lllllllllllllllIIlIllIlIIlllIIll += this.radiusPerTick;
                if (lllllllllllllllIIlIllIlIIlllIIll < 0.5f) {
                    this.setDead();
                    return;
                }
                this.setRadius(lllllllllllllllIIlIllIlIIlllIIll);
            }
            if (this.ticksExisted % 5 == 0) {
                final Iterator<Map.Entry<Entity, Integer>> lllllllllllllllIIlIllIlIIlIlllII = this.reapplicationDelayMap.entrySet().iterator();
                while (lllllllllllllllIIlIllIlIIlIlllII.hasNext()) {
                    final Map.Entry<Entity, Integer> lllllllllllllllIIlIllIlIIlIllIll = lllllllllllllllIIlIllIlIIlIlllII.next();
                    if (this.ticksExisted >= lllllllllllllllIIlIllIlIIlIllIll.getValue()) {
                        lllllllllllllllIIlIllIlIIlIlllII.remove();
                    }
                }
                final List<PotionEffect> lllllllllllllllIIlIllIlIIlIllIlI = (List<PotionEffect>)Lists.newArrayList();
                for (final PotionEffect lllllllllllllllIIlIllIlIIlIllIIl : this.potion.getEffects()) {
                    lllllllllllllllIIlIllIlIIlIllIlI.add(new PotionEffect(lllllllllllllllIIlIllIlIIlIllIIl.getPotion(), lllllllllllllllIIlIllIlIIlIllIIl.getDuration() / 4, lllllllllllllllIIlIllIlIIlIllIIl.getAmplifier(), lllllllllllllllIIlIllIlIIlIllIIl.getIsAmbient(), lllllllllllllllIIlIllIlIIlIllIIl.doesShowParticles()));
                }
                lllllllllllllllIIlIllIlIIlIllIlI.addAll(this.effects);
                if (lllllllllllllllIIlIllIlIIlIllIlI.isEmpty()) {
                    this.reapplicationDelayMap.clear();
                }
                else {
                    final List<EntityLivingBase> lllllllllllllllIIlIllIlIIlIllIII = this.world.getEntitiesWithinAABB((Class<? extends EntityLivingBase>)EntityLivingBase.class, this.getEntityBoundingBox());
                    if (!lllllllllllllllIIlIllIlIIlIllIII.isEmpty()) {
                        for (final EntityLivingBase lllllllllllllllIIlIllIlIIlIlIlll : lllllllllllllllIIlIllIlIIlIllIII) {
                            if (!this.reapplicationDelayMap.containsKey(lllllllllllllllIIlIllIlIIlIlIlll) && lllllllllllllllIIlIllIlIIlIlIlll.canBeHitWithPotion()) {
                                final double lllllllllllllllIIlIllIlIIlIlIllI = lllllllllllllllIIlIllIlIIlIlIlll.posX - this.posX;
                                final double lllllllllllllllIIlIllIlIIlIlIlIl = lllllllllllllllIIlIllIlIIlIlIlll.posZ - this.posZ;
                                final double lllllllllllllllIIlIllIlIIlIlIlII = lllllllllllllllIIlIllIlIIlIlIllI * lllllllllllllllIIlIllIlIIlIlIllI + lllllllllllllllIIlIllIlIIlIlIlIl * lllllllllllllllIIlIllIlIIlIlIlIl;
                                if (lllllllllllllllIIlIllIlIIlIlIlII > lllllllllllllllIIlIllIlIIlllIIll * lllllllllllllllIIlIllIlIIlllIIll) {
                                    continue;
                                }
                                this.reapplicationDelayMap.put(lllllllllllllllIIlIllIlIIlIlIlll, this.ticksExisted + this.reapplicationDelay);
                                for (final PotionEffect lllllllllllllllIIlIllIlIIlIlIIll : lllllllllllllllIIlIllIlIIlIllIlI) {
                                    if (lllllllllllllllIIlIllIlIIlIlIIll.getPotion().isInstant()) {
                                        lllllllllllllllIIlIllIlIIlIlIIll.getPotion().affectEntity(this, this.getOwner(), lllllllllllllllIIlIllIlIIlIlIlll, lllllllllllllllIIlIllIlIIlIlIIll.getAmplifier(), 0.5);
                                    }
                                    else {
                                        lllllllllllllllIIlIllIlIIlIlIlll.addPotionEffect(new PotionEffect(lllllllllllllllIIlIllIlIIlIlIIll));
                                    }
                                }
                                if (this.radiusOnUse != 0.0f) {
                                    lllllllllllllllIIlIllIlIIlllIIll += this.radiusOnUse;
                                    if (lllllllllllllllIIlIllIlIIlllIIll < 0.5f) {
                                        this.setDead();
                                        return;
                                    }
                                    this.setRadius(lllllllllllllllIIlIllIlIIlllIIll);
                                }
                                if (this.durationOnUse == 0) {
                                    continue;
                                }
                                this.duration += this.durationOnUse;
                                if (this.duration <= 0) {
                                    this.setDead();
                                    return;
                                }
                                continue;
                            }
                        }
                    }
                }
            }
        }
    }
    
    public float getRadius() {
        return this.getDataManager().get(EntityAreaEffectCloud.RADIUS);
    }
    
    @Override
    protected void entityInit() {
        this.getDataManager().register(EntityAreaEffectCloud.COLOR, 0);
        this.getDataManager().register(EntityAreaEffectCloud.RADIUS, 0.5f);
        this.getDataManager().register(EntityAreaEffectCloud.IGNORE_RADIUS, false);
        this.getDataManager().register(EntityAreaEffectCloud.PARTICLE, EnumParticleTypes.SPELL_MOB.getParticleID());
        this.getDataManager().register(EntityAreaEffectCloud.PARTICLE_PARAM_1, 0);
        this.getDataManager().register(EntityAreaEffectCloud.PARTICLE_PARAM_2, 0);
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound lllllllllllllllIIlIllIlIIIIIlIIl) {
        lllllllllllllllIIlIllIlIIIIIlIIl.setInteger("Age", this.ticksExisted);
        lllllllllllllllIIlIllIlIIIIIlIIl.setInteger("Duration", this.duration);
        lllllllllllllllIIlIllIlIIIIIlIIl.setInteger("WaitTime", this.waitTime);
        lllllllllllllllIIlIllIlIIIIIlIIl.setInteger("ReapplicationDelay", this.reapplicationDelay);
        lllllllllllllllIIlIllIlIIIIIlIIl.setInteger("DurationOnUse", this.durationOnUse);
        lllllllllllllllIIlIllIlIIIIIlIIl.setFloat("RadiusOnUse", this.radiusOnUse);
        lllllllllllllllIIlIllIlIIIIIlIIl.setFloat("RadiusPerTick", this.radiusPerTick);
        lllllllllllllllIIlIllIlIIIIIlIIl.setFloat("Radius", this.getRadius());
        lllllllllllllllIIlIllIlIIIIIlIIl.setString("Particle", this.getParticle().getParticleName());
        lllllllllllllllIIlIllIlIIIIIlIIl.setInteger("ParticleParam1", this.getParticleParam1());
        lllllllllllllllIIlIllIlIIIIIlIIl.setInteger("ParticleParam2", this.getParticleParam2());
        if (this.ownerUniqueId != null) {
            lllllllllllllllIIlIllIlIIIIIlIIl.setUniqueId("OwnerUUID", this.ownerUniqueId);
        }
        if (this.colorSet) {
            lllllllllllllllIIlIllIlIIIIIlIIl.setInteger("Color", this.getColor());
        }
        if (this.potion != PotionTypes.EMPTY && this.potion != null) {
            lllllllllllllllIIlIllIlIIIIIlIIl.setString("Potion", PotionType.REGISTRY.getNameForObject(this.potion).toString());
        }
        if (!this.effects.isEmpty()) {
            final NBTTagList lllllllllllllllIIlIllIlIIIIIllII = new NBTTagList();
            for (final PotionEffect lllllllllllllllIIlIllIlIIIIIlIll : this.effects) {
                lllllllllllllllIIlIllIlIIIIIllII.appendTag(lllllllllllllllIIlIllIlIIIIIlIll.writeCustomPotionEffectToNBT(new NBTTagCompound()));
            }
            lllllllllllllllIIlIllIlIIIIIlIIl.setTag("Effects", lllllllllllllllIIlIllIlIIIIIllII);
        }
    }
    
    public void setColor(final int lllllllllllllllIIlIllIlIlIllIllI) {
        this.colorSet = true;
        this.getDataManager().set(EntityAreaEffectCloud.COLOR, lllllllllllllllIIlIllIlIlIllIllI);
    }
    
    public EntityAreaEffectCloud(final World lllllllllllllllIIlIllIlIlllIIlII, final double lllllllllllllllIIlIllIlIlllIIIll, final double lllllllllllllllIIlIllIlIlllIIIlI, final double lllllllllllllllIIlIllIlIlllIIllI) {
        this(lllllllllllllllIIlIllIlIlllIIlII);
        this.setPosition(lllllllllllllllIIlIllIlIlllIIIll, lllllllllllllllIIlIllIlIlllIIIlI, lllllllllllllllIIlIllIlIlllIIllI);
    }
    
    public int getColor() {
        return this.getDataManager().get(EntityAreaEffectCloud.COLOR);
    }
    
    public void setWaitTime(final int lllllllllllllllIIlIllIlIIIllIIII) {
        this.waitTime = lllllllllllllllIIlIllIlIIIllIIII;
    }
    
    public void setRadiusPerTick(final float lllllllllllllllIIlIllIlIIIlllIII) {
        this.radiusPerTick = lllllllllllllllIIlIllIlIIIlllIII;
    }
    
    public void addEffect(final PotionEffect lllllllllllllllIIlIllIlIlIllllIl) {
        this.effects.add(lllllllllllllllIIlIllIlIlIllllIl);
        if (!this.colorSet) {
            this.func_190618_C();
        }
    }
    
    public int getParticleParam2() {
        return this.getDataManager().get(EntityAreaEffectCloud.PARTICLE_PARAM_2);
    }
    
    private void func_190618_C() {
        if (this.potion == PotionTypes.EMPTY && this.effects.isEmpty()) {
            this.getDataManager().set(EntityAreaEffectCloud.COLOR, 0);
        }
        else {
            this.getDataManager().set(EntityAreaEffectCloud.COLOR, PotionUtils.getPotionColorFromEffectList(PotionUtils.mergeEffects(this.potion, this.effects)));
        }
    }
    
    public EntityAreaEffectCloud(final World lllllllllllllllIIlIllIlIllllIIlI) {
        super(lllllllllllllllIIlIllIlIllllIIlI);
        this.potion = PotionTypes.EMPTY;
        this.effects = (List<PotionEffect>)Lists.newArrayList();
        this.reapplicationDelayMap = (Map<Entity, Integer>)Maps.newHashMap();
        this.duration = 600;
        this.waitTime = 20;
        this.reapplicationDelay = 20;
        this.noClip = true;
        this.isImmuneToFire = true;
        this.setRadius(3.0f);
    }
    
    public EnumParticleTypes getParticle() {
        return EnumParticleTypes.getParticleFromId(this.getDataManager().get(EntityAreaEffectCloud.PARTICLE));
    }
    
    public void setDuration(final int lllllllllllllllIIlIllIlIlIIIlIIl) {
        this.duration = lllllllllllllllIIlIllIlIlIIIlIIl;
    }
    
    public void setRadiusOnUse(final float lllllllllllllllIIlIllIlIIIlllllI) {
        this.radiusOnUse = lllllllllllllllIIlIllIlIIIlllllI;
    }
    
    @Override
    public void notifyDataManagerChange(final DataParameter<?> lllllllllllllllIIlIllIIlllllllll) {
        if (EntityAreaEffectCloud.RADIUS.equals(lllllllllllllllIIlIllIIlllllllll)) {
            this.setRadius(this.getRadius());
        }
        super.notifyDataManagerChange(lllllllllllllllIIlIllIIlllllllll);
    }
    
    public void setParticle(final EnumParticleTypes lllllllllllllllIIlIllIlIlIlIllIl) {
        this.getDataManager().set(EntityAreaEffectCloud.PARTICLE, lllllllllllllllIIlIllIlIlIlIllIl.getParticleID());
    }
    
    protected void setIgnoreRadius(final boolean lllllllllllllllIIlIllIlIlIIlIIll) {
        this.getDataManager().set(EntityAreaEffectCloud.IGNORE_RADIUS, lllllllllllllllIIlIllIlIlIIlIIll);
    }
    
    @Override
    public EnumPushReaction getPushReaction() {
        return EnumPushReaction.IGNORE;
    }
    
    public void setOwner(@Nullable final EntityLivingBase lllllllllllllllIIlIllIlIIIlIlIlI) {
        this.owner = lllllllllllllllIIlIllIlIIIlIlIlI;
        this.ownerUniqueId = ((lllllllllllllllIIlIllIlIIIlIlIlI == null) ? null : lllllllllllllllIIlIllIlIIIlIlIlI.getUniqueID());
    }
    
    public boolean shouldIgnoreRadius() {
        return this.getDataManager().get(EntityAreaEffectCloud.IGNORE_RADIUS);
    }
    
    public void setPotion(final PotionType lllllllllllllllIIlIllIlIllIIlIII) {
        this.potion = lllllllllllllllIIlIllIlIllIIlIII;
        if (!this.colorSet) {
            this.func_190618_C();
        }
    }
    
    static {
        RADIUS = EntityDataManager.createKey(EntityAreaEffectCloud.class, DataSerializers.FLOAT);
        COLOR = EntityDataManager.createKey(EntityAreaEffectCloud.class, DataSerializers.VARINT);
        IGNORE_RADIUS = EntityDataManager.createKey(EntityAreaEffectCloud.class, DataSerializers.BOOLEAN);
        PARTICLE = EntityDataManager.createKey(EntityAreaEffectCloud.class, DataSerializers.VARINT);
        PARTICLE_PARAM_1 = EntityDataManager.createKey(EntityAreaEffectCloud.class, DataSerializers.VARINT);
        PARTICLE_PARAM_2 = EntityDataManager.createKey(EntityAreaEffectCloud.class, DataSerializers.VARINT);
    }
    
    public void setParticleParam2(final int lllllllllllllllIIlIllIlIlIIllIIl) {
        this.getDataManager().set(EntityAreaEffectCloud.PARTICLE_PARAM_2, lllllllllllllllIIlIllIlIlIIllIIl);
    }
}
