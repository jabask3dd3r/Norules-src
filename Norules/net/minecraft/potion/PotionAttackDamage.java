package net.minecraft.potion;

import net.minecraft.entity.ai.attributes.*;

public class PotionAttackDamage extends Potion
{
    protected final /* synthetic */ double bonusPerLevel;
    
    protected PotionAttackDamage(final boolean lllllllllllllIIIlIlIlIIIIIIIIIII, final int lllllllllllllIIIlIlIIlllllllllll, final double lllllllllllllIIIlIlIIllllllllIlI) {
        super(lllllllllllllIIIlIlIlIIIIIIIIIII, lllllllllllllIIIlIlIIlllllllllll);
        this.bonusPerLevel = lllllllllllllIIIlIlIIllllllllIlI;
    }
    
    @Override
    public double getAttributeModifierAmount(final int lllllllllllllIIIlIlIIlllllllIllI, final AttributeModifier lllllllllllllIIIlIlIIlllllllIlIl) {
        return this.bonusPerLevel * (lllllllllllllIIIlIlIIlllllllIllI + 1);
    }
}
