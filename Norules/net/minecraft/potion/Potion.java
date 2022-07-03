package net.minecraft.potion;

import net.minecraft.util.registry.*;
import javax.annotation.*;
import net.minecraft.init.*;
import com.google.common.collect.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;

public class Potion
{
    private /* synthetic */ int statusIconIndex;
    private final /* synthetic */ int liquidColor;
    private final /* synthetic */ boolean isBadEffect;
    private /* synthetic */ String name;
    private /* synthetic */ double effectiveness;
    private final /* synthetic */ Map<IAttribute, AttributeModifier> attributeModifierMap;
    private /* synthetic */ boolean beneficial;
    public static final /* synthetic */ RegistryNamespaced<ResourceLocation, Potion> REGISTRY;
    
    public Map<IAttribute, AttributeModifier> getAttributeModifierMap() {
        return this.attributeModifierMap;
    }
    
    protected Potion setEffectiveness(final double lllllllllllllllIIIllIIlllIIIllll) {
        this.effectiveness = lllllllllllllllIIIllIIlllIIIllll;
        return this;
    }
    
    public void affectEntity(@Nullable final Entity lllllllllllllllIIIllIIllllIIlIlI, @Nullable final Entity lllllllllllllllIIIllIIllllIlIIIl, final EntityLivingBase lllllllllllllllIIIllIIllllIIlIII, final int lllllllllllllllIIIllIIllllIIIlll, final double lllllllllllllllIIIllIIllllIIIllI) {
        if ((this != MobEffects.INSTANT_HEALTH || lllllllllllllllIIIllIIllllIIlIII.isEntityUndead()) && (this != MobEffects.INSTANT_DAMAGE || !lllllllllllllllIIIllIIllllIIlIII.isEntityUndead())) {
            if ((this == MobEffects.INSTANT_DAMAGE && !lllllllllllllllIIIllIIllllIIlIII.isEntityUndead()) || (this == MobEffects.INSTANT_HEALTH && lllllllllllllllIIIllIIllllIIlIII.isEntityUndead())) {
                final int lllllllllllllllIIIllIIllllIIllIl = (int)(lllllllllllllllIIIllIIllllIIIllI * (6 << lllllllllllllllIIIllIIllllIIIlll) + 0.5);
                if (lllllllllllllllIIIllIIllllIIlIlI == null) {
                    lllllllllllllllIIIllIIllllIIlIII.attackEntityFrom(DamageSource.magic, (float)lllllllllllllllIIIllIIllllIIllIl);
                }
                else {
                    lllllllllllllllIIIllIIllllIIlIII.attackEntityFrom(DamageSource.causeIndirectMagicDamage(lllllllllllllllIIIllIIllllIIlIlI, lllllllllllllllIIIllIIllllIlIIIl), (float)lllllllllllllllIIIllIIllllIIllIl);
                }
            }
        }
        else {
            final int lllllllllllllllIIIllIIllllIIllII = (int)(lllllllllllllllIIIllIIllllIIIllI * (4 << lllllllllllllllIIIllIIllllIIIlll) + 0.5);
            lllllllllllllllIIIllIIllllIIlIII.heal((float)lllllllllllllllIIIllIIllllIIllII);
        }
    }
    
    protected Potion(final boolean lllllllllllllllIIIllIIllllllIIIl, final int lllllllllllllllIIIllIIllllllIIII) {
        this.attributeModifierMap = (Map<IAttribute, AttributeModifier>)Maps.newHashMap();
        this.name = "";
        this.statusIconIndex = -1;
        this.isBadEffect = lllllllllllllllIIIllIIllllllIIIl;
        if (lllllllllllllllIIIllIIllllllIIIl) {
            this.effectiveness = 0.5;
        }
        else {
            this.effectiveness = 1.0;
        }
        this.liquidColor = lllllllllllllllIIIllIIllllllIIII;
    }
    
    public boolean isReady(final int lllllllllllllllIIIllIIlllIllIIll, final int lllllllllllllllIIIllIIlllIllIIlI) {
        if (this == MobEffects.REGENERATION) {
            final int lllllllllllllllIIIllIIlllIllIlll = 50 >> lllllllllllllllIIIllIIlllIllIIlI;
            return lllllllllllllllIIIllIIlllIllIlll <= 0 || lllllllllllllllIIIllIIlllIllIIll % lllllllllllllllIIIllIIlllIllIlll == 0;
        }
        if (this == MobEffects.POISON) {
            final int lllllllllllllllIIIllIIlllIllIllI = 25 >> lllllllllllllllIIIllIIlllIllIIlI;
            return lllllllllllllllIIIllIIlllIllIllI <= 0 || lllllllllllllllIIIllIIlllIllIIll % lllllllllllllllIIIllIIlllIllIllI == 0;
        }
        if (this == MobEffects.WITHER) {
            final int lllllllllllllllIIIllIIlllIllIlIl = 40 >> lllllllllllllllIIIllIIlllIllIIlI;
            return lllllllllllllllIIIllIIlllIllIlIl <= 0 || lllllllllllllllIIIllIIlllIllIIll % lllllllllllllllIIIllIIlllIllIlIl == 0;
        }
        return this == MobEffects.HUNGER;
    }
    
    public double getAttributeModifierAmount(final int lllllllllllllllIIIllIIllIlIIllII, final AttributeModifier lllllllllllllllIIIllIIllIlIIlIll) {
        return lllllllllllllllIIIllIIllIlIIlIll.getAmount() * (lllllllllllllllIIIllIIllIlIIllII + 1);
    }
    
    public void applyAttributesModifiersToEntity(final EntityLivingBase lllllllllllllllIIIllIIllIlIllllI, final AbstractAttributeMap lllllllllllllllIIIllIIllIlIlllIl, final int lllllllllllllllIIIllIIllIlIlllII) {
        for (final Map.Entry<IAttribute, AttributeModifier> lllllllllllllllIIIllIIllIlIllIll : this.attributeModifierMap.entrySet()) {
            final IAttributeInstance lllllllllllllllIIIllIIllIlIllIlI = lllllllllllllllIIIllIIllIlIlllIl.getAttributeInstance(lllllllllllllllIIIllIIllIlIllIll.getKey());
            if (lllllllllllllllIIIllIIllIlIllIlI != null) {
                final AttributeModifier lllllllllllllllIIIllIIllIlIllIIl = lllllllllllllllIIIllIIllIlIllIll.getValue();
                lllllllllllllllIIIllIIllIlIllIlI.removeModifier(lllllllllllllllIIIllIIllIlIllIIl);
                lllllllllllllllIIIllIIllIlIllIlI.applyModifier(new AttributeModifier(lllllllllllllllIIIllIIllIlIllIIl.getID(), String.valueOf(new StringBuilder(String.valueOf(this.getName())).append(" ").append(lllllllllllllllIIIllIIllIlIlllII)), this.getAttributeModifierAmount(lllllllllllllllIIIllIIllIlIlllII, lllllllllllllllIIIllIIllIlIllIIl), lllllllllllllllIIIllIIllIlIllIIl.getOperation()));
            }
        }
    }
    
    public boolean hasStatusIcon() {
        return this.statusIconIndex >= 0;
    }
    
    public Potion setPotionName(final String lllllllllllllllIIIllIIlllIlIllII) {
        this.name = lllllllllllllllIIIllIIlllIlIllII;
        return this;
    }
    
    public boolean isBadEffect() {
        return this.isBadEffect;
    }
    
    public int getLiquidColor() {
        return this.liquidColor;
    }
    
    static {
        REGISTRY = new RegistryNamespaced<ResourceLocation, Potion>();
    }
    
    public void removeAttributesModifiersFromEntity(final EntityLivingBase lllllllllllllllIIIllIIllIlllIIII, final AbstractAttributeMap lllllllllllllllIIIllIIllIllIlIlI, final int lllllllllllllllIIIllIIllIllIlllI) {
        for (final Map.Entry<IAttribute, AttributeModifier> lllllllllllllllIIIllIIllIllIllIl : this.attributeModifierMap.entrySet()) {
            final IAttributeInstance lllllllllllllllIIIllIIllIllIllII = lllllllllllllllIIIllIIllIllIlIlI.getAttributeInstance(lllllllllllllllIIIllIIllIllIllIl.getKey());
            if (lllllllllllllllIIIllIIllIllIllII != null) {
                lllllllllllllllIIIllIIllIllIllII.removeModifier(lllllllllllllllIIIllIIllIllIllIl.getValue());
            }
        }
    }
    
    public void performEffect(final EntityLivingBase lllllllllllllllIIIllIIllllIlllll, final int lllllllllllllllIIIllIIllllIllllI) {
        if (this == MobEffects.REGENERATION) {
            if (lllllllllllllllIIIllIIllllIlllll.getHealth() < lllllllllllllllIIIllIIllllIlllll.getMaxHealth()) {
                lllllllllllllllIIIllIIllllIlllll.heal(1.0f);
            }
        }
        else if (this == MobEffects.POISON) {
            if (lllllllllllllllIIIllIIllllIlllll.getHealth() > 1.0f) {
                lllllllllllllllIIIllIIllllIlllll.attackEntityFrom(DamageSource.magic, 1.0f);
            }
        }
        else if (this == MobEffects.WITHER) {
            lllllllllllllllIIIllIIllllIlllll.attackEntityFrom(DamageSource.wither, 1.0f);
        }
        else if (this == MobEffects.HUNGER && lllllllllllllllIIIllIIllllIlllll instanceof EntityPlayer) {
            ((EntityPlayer)lllllllllllllllIIIllIIllllIlllll).addExhaustion(0.005f * (lllllllllllllllIIIllIIllllIllllI + 1));
        }
        else if (this == MobEffects.SATURATION && lllllllllllllllIIIllIIllllIlllll instanceof EntityPlayer) {
            if (!lllllllllllllllIIIllIIllllIlllll.world.isRemote) {
                ((EntityPlayer)lllllllllllllllIIIllIIllllIlllll).getFoodStats().addStats(lllllllllllllllIIIllIIllllIllllI + 1, 1.0f);
            }
        }
        else if ((this != MobEffects.INSTANT_HEALTH || lllllllllllllllIIIllIIllllIlllll.isEntityUndead()) && (this != MobEffects.INSTANT_DAMAGE || !lllllllllllllllIIIllIIllllIlllll.isEntityUndead())) {
            if ((this == MobEffects.INSTANT_DAMAGE && !lllllllllllllllIIIllIIllllIlllll.isEntityUndead()) || (this == MobEffects.INSTANT_HEALTH && lllllllllllllllIIIllIIllllIlllll.isEntityUndead())) {
                lllllllllllllllIIIllIIllllIlllll.attackEntityFrom(DamageSource.magic, (float)(6 << lllllllllllllllIIIllIIllllIllllI));
            }
        }
        else {
            lllllllllllllllIIIllIIllllIlllll.heal((float)Math.max(4 << lllllllllllllllIIIllIIllllIllllI, 0));
        }
    }
    
    @Nullable
    public static Potion getPotionById(final int lllllllllllllllIIIllIIllllllllIl) {
        return Potion.REGISTRY.getObjectById(lllllllllllllllIIIllIIllllllllIl);
    }
    
    public Potion registerPotionAttributeModifier(final IAttribute lllllllllllllllIIIllIIllIllllllI, final String lllllllllllllllIIIllIIllIlllllIl, final double lllllllllllllllIIIllIIllIlllllII, final int lllllllllllllllIIIllIIllIllllIll) {
        final AttributeModifier lllllllllllllllIIIllIIlllIIIIIII = new AttributeModifier(UUID.fromString(lllllllllllllllIIIllIIllIlllllIl), this.getName(), lllllllllllllllIIIllIIllIlllllII, lllllllllllllllIIIllIIllIllllIll);
        this.attributeModifierMap.put(lllllllllllllllIIIllIIllIllllllI, lllllllllllllllIIIllIIlllIIIIIII);
        return this;
    }
    
    public static int getIdFromPotion(final Potion lllllllllllllllIIIllIIlllllllIlI) {
        return Potion.REGISTRY.getIDForObject(lllllllllllllllIIIllIIlllllllIlI);
    }
    
    public String getName() {
        return this.name;
    }
    
    public static void registerPotions() {
        Potion.REGISTRY.register(1, new ResourceLocation("speed"), new Potion(false, 8171462).setPotionName("effect.moveSpeed").setIconIndex(0, 0).registerPotionAttributeModifier(SharedMonsterAttributes.MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635", 0.20000000298023224, 2).setBeneficial());
        Potion.REGISTRY.register(2, new ResourceLocation("slowness"), new Potion(true, 5926017).setPotionName("effect.moveSlowdown").setIconIndex(1, 0).registerPotionAttributeModifier(SharedMonsterAttributes.MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.15000000596046448, 2));
        Potion.REGISTRY.register(3, new ResourceLocation("haste"), new Potion(false, 14270531).setPotionName("effect.digSpeed").setIconIndex(2, 0).setEffectiveness(1.5).setBeneficial().registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_SPEED, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3", 0.10000000149011612, 2));
        Potion.REGISTRY.register(4, new ResourceLocation("mining_fatigue"), new Potion(true, 4866583).setPotionName("effect.digSlowDown").setIconIndex(3, 0).registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_SPEED, "55FCED67-E92A-486E-9800-B47F202C4386", -0.10000000149011612, 2));
        Potion.REGISTRY.register(5, new ResourceLocation("strength"), new PotionAttackDamage(false, 9643043, 3.0).setPotionName("effect.damageBoost").setIconIndex(4, 0).registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_DAMAGE, "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9", 0.0, 0).setBeneficial());
        Potion.REGISTRY.register(6, new ResourceLocation("instant_health"), new PotionHealth(false, 16262179).setPotionName("effect.heal").setBeneficial());
        Potion.REGISTRY.register(7, new ResourceLocation("instant_damage"), new PotionHealth(true, 4393481).setPotionName("effect.harm").setBeneficial());
        Potion.REGISTRY.register(8, new ResourceLocation("jump_boost"), new Potion(false, 2293580).setPotionName("effect.jump").setIconIndex(2, 1).setBeneficial());
        Potion.REGISTRY.register(9, new ResourceLocation("nausea"), new Potion(true, 5578058).setPotionName("effect.confusion").setIconIndex(3, 1).setEffectiveness(0.25));
        Potion.REGISTRY.register(10, new ResourceLocation("regeneration"), new Potion(false, 13458603).setPotionName("effect.regeneration").setIconIndex(7, 0).setEffectiveness(0.25).setBeneficial());
        Potion.REGISTRY.register(11, new ResourceLocation("resistance"), new Potion(false, 10044730).setPotionName("effect.resistance").setIconIndex(6, 1).setBeneficial());
        Potion.REGISTRY.register(12, new ResourceLocation("fire_resistance"), new Potion(false, 14981690).setPotionName("effect.fireResistance").setIconIndex(7, 1).setBeneficial());
        Potion.REGISTRY.register(13, new ResourceLocation("water_breathing"), new Potion(false, 3035801).setPotionName("effect.waterBreathing").setIconIndex(0, 2).setBeneficial());
        Potion.REGISTRY.register(14, new ResourceLocation("invisibility"), new Potion(false, 8356754).setPotionName("effect.invisibility").setIconIndex(0, 1).setBeneficial());
        Potion.REGISTRY.register(15, new ResourceLocation("blindness"), new Potion(true, 2039587).setPotionName("effect.blindness").setIconIndex(5, 1).setEffectiveness(0.25));
        Potion.REGISTRY.register(16, new ResourceLocation("night_vision"), new Potion(false, 2039713).setPotionName("effect.nightVision").setIconIndex(4, 1).setBeneficial());
        Potion.REGISTRY.register(17, new ResourceLocation("hunger"), new Potion(true, 5797459).setPotionName("effect.hunger").setIconIndex(1, 1));
        Potion.REGISTRY.register(18, new ResourceLocation("weakness"), new PotionAttackDamage(true, 4738376, -4.0).setPotionName("effect.weakness").setIconIndex(5, 0).registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_DAMAGE, "22653B89-116E-49DC-9B6B-9971489B5BE5", 0.0, 0));
        Potion.REGISTRY.register(19, new ResourceLocation("poison"), new Potion(true, 5149489).setPotionName("effect.poison").setIconIndex(6, 0).setEffectiveness(0.25));
        Potion.REGISTRY.register(20, new ResourceLocation("wither"), new Potion(true, 3484199).setPotionName("effect.wither").setIconIndex(1, 2).setEffectiveness(0.25));
        Potion.REGISTRY.register(21, new ResourceLocation("health_boost"), new PotionHealthBoost(false, 16284963).setPotionName("effect.healthBoost").setIconIndex(7, 2).registerPotionAttributeModifier(SharedMonsterAttributes.MAX_HEALTH, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CC", 4.0, 0).setBeneficial());
        Potion.REGISTRY.register(22, new ResourceLocation("absorption"), new PotionAbsorption(false, 2445989).setPotionName("effect.absorption").setIconIndex(2, 2).setBeneficial());
        Potion.REGISTRY.register(23, new ResourceLocation("saturation"), new PotionHealth(false, 16262179).setPotionName("effect.saturation").setBeneficial());
        Potion.REGISTRY.register(24, new ResourceLocation("glowing"), new Potion(false, 9740385).setPotionName("effect.glowing").setIconIndex(4, 2));
        Potion.REGISTRY.register(25, new ResourceLocation("levitation"), new Potion(true, 13565951).setPotionName("effect.levitation").setIconIndex(3, 2));
        Potion.REGISTRY.register(26, new ResourceLocation("luck"), new Potion(false, 3381504).setPotionName("effect.luck").setIconIndex(5, 2).setBeneficial().registerPotionAttributeModifier(SharedMonsterAttributes.LUCK, "03C3C89D-7037-4B42-869F-B146BCB64D2E", 1.0, 0));
        Potion.REGISTRY.register(27, new ResourceLocation("unluck"), new Potion(true, 12624973).setPotionName("effect.unluck").setIconIndex(6, 2).registerPotionAttributeModifier(SharedMonsterAttributes.LUCK, "CC5AF142-2BD2-4215-B636-2605AED11727", -1.0, 0));
    }
    
    public int getStatusIconIndex() {
        return this.statusIconIndex;
    }
    
    public static String getPotionDurationString(final PotionEffect lllllllllllllllIIIllIIlllIIllIlI, final float lllllllllllllllIIIllIIlllIIllIIl) {
        if (lllllllllllllllIIIllIIlllIIllIlI.getIsPotionDurationMax()) {
            return "**:**";
        }
        final int lllllllllllllllIIIllIIlllIIllIII = MathHelper.floor(lllllllllllllllIIIllIIlllIIllIlI.getDuration() * lllllllllllllllIIIllIIlllIIllIIl);
        return StringUtils.ticksToElapsedTime(lllllllllllllllIIIllIIlllIIllIII);
    }
    
    public static String getDurationString(final PotionEffect lllllllllllllllIIIllIIllllIIIIlI) {
        if (lllllllllllllllIIIllIIllllIIIIlI.getIsPotionDurationMax()) {
            return "**:**";
        }
        final int lllllllllllllllIIIllIIllllIIIIIl = lllllllllllllllIIIllIIllllIIIIlI.getDuration();
        return StringUtils.ticksToElapsedTime(lllllllllllllllIIIllIIllllIIIIIl);
    }
    
    public Potion setBeneficial() {
        this.beneficial = true;
        return this;
    }
    
    @Nullable
    public static Potion getPotionFromResourceLocation(final String lllllllllllllllIIIllIIllllllIllI) {
        return Potion.REGISTRY.getObject(new ResourceLocation(lllllllllllllllIIIllIIllllllIllI));
    }
    
    protected Potion setIconIndex(final int lllllllllllllllIIIllIIlllllIlIII, final int lllllllllllllllIIIllIIlllllIIlII) {
        this.statusIconIndex = lllllllllllllllIIIllIIlllllIlIII + lllllllllllllllIIIllIIlllllIIlII * 8;
        return this;
    }
    
    public boolean isBeneficial() {
        return this.beneficial;
    }
    
    public boolean isInstant() {
        return false;
    }
}
