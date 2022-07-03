package net.minecraft.util;

import javax.annotation.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.util.text.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;

public class EntityDamageSource extends DamageSource
{
    private /* synthetic */ boolean isThornsDamage;
    @Nullable
    protected /* synthetic */ Entity damageSourceEntity;
    
    public EntityDamageSource setIsThornsDamage() {
        this.isThornsDamage = true;
        return this;
    }
    
    @Override
    public ITextComponent getDeathMessage(final EntityLivingBase llllllllllllllIIIIIlIIlIIIllIlIl) {
        final ItemStack llllllllllllllIIIIIlIIlIIIlllIll = (this.damageSourceEntity instanceof EntityLivingBase) ? ((EntityLivingBase)this.damageSourceEntity).getHeldItemMainhand() : ItemStack.field_190927_a;
        final String llllllllllllllIIIIIlIIlIIIlllIIl = String.valueOf(new StringBuilder("death.attack.").append(this.damageType));
        final String llllllllllllllIIIIIlIIlIIIllIlll = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIlIIlIIIlllIIl)).append(".item"));
        return (!llllllllllllllIIIIIlIIlIIIlllIll.func_190926_b() && llllllllllllllIIIIIlIIlIIIlllIll.hasDisplayName() && I18n.canTranslate(llllllllllllllIIIIIlIIlIIIllIlll)) ? new TextComponentTranslation(llllllllllllllIIIIIlIIlIIIllIlll, new Object[] { llllllllllllllIIIIIlIIlIIIllIlIl.getDisplayName(), this.damageSourceEntity.getDisplayName(), llllllllllllllIIIIIlIIlIIIlllIll.getTextComponent() }) : new TextComponentTranslation(llllllllllllllIIIIIlIIlIIIlllIIl, new Object[] { llllllllllllllIIIIIlIIlIIIllIlIl.getDisplayName(), this.damageSourceEntity.getDisplayName() });
    }
    
    @Override
    public boolean isDifficultyScaled() {
        return this.damageSourceEntity != null && this.damageSourceEntity instanceof EntityLivingBase && !(this.damageSourceEntity instanceof EntityPlayer);
    }
    
    @Nullable
    @Override
    public Entity getEntity() {
        return this.damageSourceEntity;
    }
    
    @Nullable
    @Override
    public Vec3d getDamageLocation() {
        return new Vec3d(this.damageSourceEntity.posX, this.damageSourceEntity.posY, this.damageSourceEntity.posZ);
    }
    
    public boolean getIsThornsDamage() {
        return this.isThornsDamage;
    }
    
    public EntityDamageSource(final String llllllllllllllIIIIIlIIlIIllIlIII, @Nullable final Entity llllllllllllllIIIIIlIIlIIllIIllI) {
        super(llllllllllllllIIIIIlIIlIIllIlIII);
        this.damageSourceEntity = llllllllllllllIIIIIlIIlIIllIIllI;
    }
}
