package net.minecraft.util;

import javax.annotation.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.util.text.*;

public class EntityDamageSourceIndirect extends EntityDamageSource
{
    private final /* synthetic */ Entity indirectEntity;
    
    public EntityDamageSourceIndirect(final String lllllllllllllIlIlIllIIlIllIlIlll, final Entity lllllllllllllIlIlIllIIlIllIllIlI, @Nullable final Entity lllllllllllllIlIlIllIIlIllIlIlIl) {
        super(lllllllllllllIlIlIllIIlIllIlIlll, lllllllllllllIlIlIllIIlIllIllIlI);
        this.indirectEntity = lllllllllllllIlIlIllIIlIllIlIlIl;
    }
    
    @Override
    public ITextComponent getDeathMessage(final EntityLivingBase lllllllllllllIlIlIllIIlIllIIIIIl) {
        final ITextComponent lllllllllllllIlIlIllIIlIllIIIllI = (this.indirectEntity == null) ? this.damageSourceEntity.getDisplayName() : this.indirectEntity.getDisplayName();
        final ItemStack lllllllllllllIlIlIllIIlIllIIIlIl = (this.indirectEntity instanceof EntityLivingBase) ? ((EntityLivingBase)this.indirectEntity).getHeldItemMainhand() : ItemStack.field_190927_a;
        final String lllllllllllllIlIlIllIIlIllIIIlII = String.valueOf(new StringBuilder("death.attack.").append(this.damageType));
        final String lllllllllllllIlIlIllIIlIllIIIIll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIlIllIIlIllIIIlII)).append(".item"));
        return (!lllllllllllllIlIlIllIIlIllIIIlIl.func_190926_b() && lllllllllllllIlIlIllIIlIllIIIlIl.hasDisplayName() && I18n.canTranslate(lllllllllllllIlIlIllIIlIllIIIIll)) ? new TextComponentTranslation(lllllllllllllIlIlIllIIlIllIIIIll, new Object[] { lllllllllllllIlIlIllIIlIllIIIIIl.getDisplayName(), lllllllllllllIlIlIllIIlIllIIIllI, lllllllllllllIlIlIllIIlIllIIIlIl.getTextComponent() }) : new TextComponentTranslation(lllllllllllllIlIlIllIIlIllIIIlII, new Object[] { lllllllllllllIlIlIllIIlIllIIIIIl.getDisplayName(), lllllllllllllIlIlIllIIlIllIIIllI });
    }
    
    @Nullable
    @Override
    public Entity getSourceOfDamage() {
        return this.damageSourceEntity;
    }
    
    @Nullable
    @Override
    public Entity getEntity() {
        return this.indirectEntity;
    }
}
