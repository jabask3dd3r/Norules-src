package net.minecraft.client.renderer.entity.layers;

import net.minecraft.inventory.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.*;

public class LayerBipedArmor extends LayerArmorBase<ModelBiped>
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot;
    
    @Override
    protected void initArmor() {
        this.modelLeggings = (T)new ModelBiped(0.5f);
        this.modelArmor = (T)new ModelBiped(1.0f);
    }
    
    protected void setModelVisible(final ModelBiped lllllllllllllIlIIllIlllIIIlIlIlI) {
        lllllllllllllIlIIllIlllIIIlIlIlI.setInvisible(false);
    }
    
    @Override
    protected void setModelSlotVisible(final ModelBiped lllllllllllllIlIIllIlllIIIllIIlI, final EntityEquipmentSlot lllllllllllllIlIIllIlllIIIllIIIl) {
        this.setModelVisible(lllllllllllllIlIIllIlllIIIllIIlI);
        switch ($SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot()[lllllllllllllIlIIllIlllIIIllIIIl.ordinal()]) {
            case 6: {
                lllllllllllllIlIIllIlllIIIllIIlI.bipedHead.showModel = true;
                lllllllllllllIlIIllIlllIIIllIIlI.bipedHeadwear.showModel = true;
                break;
            }
            case 5: {
                lllllllllllllIlIIllIlllIIIllIIlI.bipedBody.showModel = true;
                lllllllllllllIlIIllIlllIIIllIIlI.bipedRightArm.showModel = true;
                lllllllllllllIlIIllIlllIIIllIIlI.bipedLeftArm.showModel = true;
                break;
            }
            case 4: {
                lllllllllllllIlIIllIlllIIIllIIlI.bipedBody.showModel = true;
                lllllllllllllIlIIllIlllIIIllIIlI.bipedRightLeg.showModel = true;
                lllllllllllllIlIIllIlllIIIllIIlI.bipedLeftLeg.showModel = true;
                break;
            }
            case 3: {
                lllllllllllllIlIIllIlllIIIllIIlI.bipedRightLeg.showModel = true;
                lllllllllllllIlIIllIlllIIIllIIlI.bipedLeftLeg.showModel = true;
                break;
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot() {
        final int[] $switch_TABLE$net$minecraft$inventory$EntityEquipmentSlot = LayerBipedArmor.$SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot;
        if ($switch_TABLE$net$minecraft$inventory$EntityEquipmentSlot != null) {
            return $switch_TABLE$net$minecraft$inventory$EntityEquipmentSlot;
        }
        final double lllllllllllllIlIIllIlllIIIlIIIlI = (Object)new int[EntityEquipmentSlot.values().length];
        try {
            lllllllllllllIlIIllIlllIIIlIIIlI[EntityEquipmentSlot.CHEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlIIllIlllIIIlIIIlI[EntityEquipmentSlot.FEET.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlIIllIlllIIIlIIIlI[EntityEquipmentSlot.HEAD.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIlIIllIlllIIIlIIIlI[EntityEquipmentSlot.LEGS.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIlIIllIlllIIIlIIIlI[EntityEquipmentSlot.MAINHAND.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIlIIllIlllIIIlIIIlI[EntityEquipmentSlot.OFFHAND.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return LayerBipedArmor.$SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot = (int[])(Object)lllllllllllllIlIIllIlllIIIlIIIlI;
    }
    
    public LayerBipedArmor(final RenderLivingBase<?> lllllllllllllIlIIllIlllIIIllllII) {
        super(lllllllllllllIlIIllIlllIIIllllII);
    }
}
