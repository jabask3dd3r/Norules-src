package net.minecraft.potion;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;

public class PotionHealthBoost extends Potion
{
    public PotionHealthBoost(final boolean lllllllllllllIllllIIlllllllIIllI, final int lllllllllllllIllllIIlllllllIIIlI) {
        super(lllllllllllllIllllIIlllllllIIllI, lllllllllllllIllllIIlllllllIIIlI);
    }
    
    @Override
    public void removeAttributesModifiersFromEntity(final EntityLivingBase lllllllllllllIllllIIllllllIllIII, final AbstractAttributeMap lllllllllllllIllllIIllllllIllIll, final int lllllllllllllIllllIIllllllIllIlI) {
        super.removeAttributesModifiersFromEntity(lllllllllllllIllllIIllllllIllIII, lllllllllllllIllllIIllllllIllIll, lllllllllllllIllllIIllllllIllIlI);
        if (lllllllllllllIllllIIllllllIllIII.getHealth() > lllllllllllllIllllIIllllllIllIII.getMaxHealth()) {
            lllllllllllllIllllIIllllllIllIII.setHealth(lllllllllllllIllllIIllllllIllIII.getMaxHealth());
        }
    }
}
