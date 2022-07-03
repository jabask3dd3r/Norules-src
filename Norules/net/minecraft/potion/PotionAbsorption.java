package net.minecraft.potion;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;

public class PotionAbsorption extends Potion
{
    @Override
    public void applyAttributesModifiersToEntity(final EntityLivingBase llllllllllllllIlllIllIlllIIIlIII, final AbstractAttributeMap llllllllllllllIlllIllIlllIIIIIll, final int llllllllllllllIlllIllIlllIIIIllI) {
        llllllllllllllIlllIllIlllIIIlIII.setAbsorptionAmount(llllllllllllllIlllIllIlllIIIlIII.getAbsorptionAmount() + 4 * (llllllllllllllIlllIllIlllIIIIllI + 1));
        super.applyAttributesModifiersToEntity(llllllllllllllIlllIllIlllIIIlIII, llllllllllllllIlllIllIlllIIIIIll, llllllllllllllIlllIllIlllIIIIllI);
    }
    
    protected PotionAbsorption(final boolean llllllllllllllIlllIllIlllIIllIll, final int llllllllllllllIlllIllIlllIIllIlI) {
        super(llllllllllllllIlllIllIlllIIllIll, llllllllllllllIlllIllIlllIIllIlI);
    }
    
    @Override
    public void removeAttributesModifiersFromEntity(final EntityLivingBase llllllllllllllIlllIllIlllIIlIIII, final AbstractAttributeMap llllllllllllllIlllIllIlllIIlIIll, final int llllllllllllllIlllIllIlllIIlIIlI) {
        llllllllllllllIlllIllIlllIIlIIII.setAbsorptionAmount(llllllllllllllIlllIllIlllIIlIIII.getAbsorptionAmount() - 4 * (llllllllllllllIlllIllIlllIIlIIlI + 1));
        super.removeAttributesModifiersFromEntity(llllllllllllllIlllIllIlllIIlIIII, llllllllllllllIlllIllIlllIIlIIll, llllllllllllllIlllIllIlllIIlIIlI);
    }
}
