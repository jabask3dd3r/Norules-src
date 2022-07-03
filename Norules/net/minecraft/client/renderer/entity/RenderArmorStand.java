package net.minecraft.client.renderer.entity;

import net.minecraft.entity.item.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;

public class RenderArmorStand extends RenderLivingBase<EntityArmorStand>
{
    public static final /* synthetic */ ResourceLocation TEXTURE_ARMOR_STAND;
    
    @Override
    protected boolean canRenderName(final EntityArmorStand lllllllllllllllIIIllIllIlIIIlIll) {
        return lllllllllllllllIIIllIllIlIIIlIll.getAlwaysRenderNameTag();
    }
    
    public RenderArmorStand(final RenderManager lllllllllllllllIIIllIllIlIlIIlll) {
        super(lllllllllllllllIIIllIllIlIlIIlll, new ModelArmorStand(), 0.0f);
        final LayerBipedArmor lllllllllllllllIIIllIllIlIlIlIIl = new LayerBipedArmor(this) {
            @Override
            protected void initArmor() {
                this.modelLeggings = (T)new ModelArmorStandArmor(0.5f);
                this.modelArmor = (T)new ModelArmorStandArmor(1.0f);
            }
        };
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(lllllllllllllllIIIllIllIlIlIlIIl);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerHeldItem(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerElytra(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerCustomHead(this.getMainModel().bipedHead));
    }
    
    @Override
    public ModelArmorStand getMainModel() {
        return (ModelArmorStand)super.getMainModel();
    }
    
    @Override
    public void doRender(final EntityArmorStand lllllllllllllllIIIllIllIIlllIlll, final double lllllllllllllllIIIllIllIIllIlllI, final double lllllllllllllllIIIllIllIIlllIlIl, final double lllllllllllllllIIIllIllIIllIlIll, final float lllllllllllllllIIIllIllIIlllIIll, final float lllllllllllllllIIIllIllIIlllIIlI) {
        if (lllllllllllllllIIIllIllIIlllIlll.hasMarker()) {
            this.renderMarker = true;
        }
        super.doRender(lllllllllllllllIIIllIllIIlllIlll, lllllllllllllllIIIllIllIIllIlllI, lllllllllllllllIIIllIllIIlllIlIl, lllllllllllllllIIIllIllIIllIlIll, lllllllllllllllIIIllIllIIlllIIll, lllllllllllllllIIIllIllIIlllIIlI);
        if (lllllllllllllllIIIllIllIIlllIlll.hasMarker()) {
            this.renderMarker = false;
        }
    }
    
    @Override
    protected void rotateCorpse(final EntityArmorStand lllllllllllllllIIIllIllIlIIlIllI, final float lllllllllllllllIIIllIllIlIIlIlIl, final float lllllllllllllllIIIllIllIlIIlIlII, final float lllllllllllllllIIIllIllIlIIIllll) {
        GlStateManager.rotate(180.0f - lllllllllllllllIIIllIllIlIIlIlII, 0.0f, 1.0f, 0.0f);
        final float lllllllllllllllIIIllIllIlIIlIIlI = lllllllllllllllIIIllIllIlIIlIllI.world.getTotalWorldTime() - lllllllllllllllIIIllIllIlIIlIllI.punchCooldown + lllllllllllllllIIIllIllIlIIIllll;
        if (lllllllllllllllIIIllIllIlIIlIIlI < 5.0f) {
            GlStateManager.rotate(MathHelper.sin(lllllllllllllllIIIllIllIlIIlIIlI / 1.5f * 3.1415927f) * 3.0f, 0.0f, 1.0f, 0.0f);
        }
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityArmorStand lllllllllllllllIIIllIllIlIlIIlII) {
        return RenderArmorStand.TEXTURE_ARMOR_STAND;
    }
    
    static {
        TEXTURE_ARMOR_STAND = new ResourceLocation("textures/entity/armorstand/wood.png");
    }
}
