package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.inventory.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.entity.*;
import net.minecraft.entity.player.*;
import optifine.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.item.*;

public class LayerElytra implements LayerRenderer<EntityLivingBase>
{
    protected final /* synthetic */ RenderLivingBase<?> renderPlayer;
    private final /* synthetic */ ModelElytra modelElytra;
    private static final /* synthetic */ ResourceLocation TEXTURE_ELYTRA;
    
    static {
        TEXTURE_ELYTRA = new ResourceLocation("textures/entity/elytra.png");
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase lllllllllllllIIlllllIllIIIllIIlI, final float lllllllllllllIIlllllIllIIIlllllI, final float lllllllllllllIIlllllIllIIIllIIII, final float lllllllllllllIIlllllIllIIIllllII, final float lllllllllllllIIlllllIllIIIlIlllI, final float lllllllllllllIIlllllIllIIIlllIlI, final float lllllllllllllIIlllllIllIIIlllIIl, final float lllllllllllllIIlllllIllIIIlIlIll) {
        final ItemStack lllllllllllllIIlllllIllIIIllIlll = lllllllllllllIIlllllIllIIIllIIlI.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
        if (lllllllllllllIIlllllIllIIIllIlll.getItem() == Items.ELYTRA) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            if (lllllllllllllIIlllllIllIIIllIIlI instanceof AbstractClientPlayer) {
                final AbstractClientPlayer lllllllllllllIIlllllIllIIIllIllI = (AbstractClientPlayer)lllllllllllllIIlllllIllIIIllIIlI;
                if (lllllllllllllIIlllllIllIIIllIllI.isPlayerInfoSet() && lllllllllllllIIlllllIllIIIllIllI.getLocationElytra() != null) {
                    this.renderPlayer.bindTexture(lllllllllllllIIlllllIllIIIllIllI.getLocationElytra());
                }
                else if (lllllllllllllIIlllllIllIIIllIllI.hasElytraCape() && lllllllllllllIIlllllIllIIIllIllI.hasPlayerInfo() && lllllllllllllIIlllllIllIIIllIllI.getLocationCape() != null && lllllllllllllIIlllllIllIIIllIllI.isWearing(EnumPlayerModelParts.CAPE)) {
                    this.renderPlayer.bindTexture(lllllllllllllIIlllllIllIIIllIllI.getLocationCape());
                }
                else {
                    ResourceLocation lllllllllllllIIlllllIllIIIllIlIl = LayerElytra.TEXTURE_ELYTRA;
                    if (Config.isCustomItems()) {
                        lllllllllllllIIlllllIllIIIllIlIl = CustomItems.getCustomElytraTexture(lllllllllllllIIlllllIllIIIllIlll, lllllllllllllIIlllllIllIIIllIlIl);
                    }
                    this.renderPlayer.bindTexture(lllllllllllllIIlllllIllIIIllIlIl);
                }
            }
            else {
                ResourceLocation lllllllllllllIIlllllIllIIIllIlII = LayerElytra.TEXTURE_ELYTRA;
                if (Config.isCustomItems()) {
                    lllllllllllllIIlllllIllIIIllIlII = CustomItems.getCustomElytraTexture(lllllllllllllIIlllllIllIIIllIlll, lllllllllllllIIlllllIllIIIllIlII);
                }
                this.renderPlayer.bindTexture(lllllllllllllIIlllllIllIIIllIlII);
            }
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, 0.0f, 0.125f);
            this.modelElytra.setRotationAngles(lllllllllllllIIlllllIllIIIlllllI, lllllllllllllIIlllllIllIIIllIIII, lllllllllllllIIlllllIllIIIlIlllI, lllllllllllllIIlllllIllIIIlllIlI, lllllllllllllIIlllllIllIIIlllIIl, lllllllllllllIIlllllIllIIIlIlIll, lllllllllllllIIlllllIllIIIllIIlI);
            this.modelElytra.render(lllllllllllllIIlllllIllIIIllIIlI, lllllllllllllIIlllllIllIIIlllllI, lllllllllllllIIlllllIllIIIllIIII, lllllllllllllIIlllllIllIIIlIlllI, lllllllllllllIIlllllIllIIIlllIlI, lllllllllllllIIlllllIllIIIlllIIl, lllllllllllllIIlllllIllIIIlIlIll);
            if (lllllllllllllIIlllllIllIIIllIlll.isItemEnchanted()) {
                LayerArmorBase.renderEnchantedGlint(this.renderPlayer, lllllllllllllIIlllllIllIIIllIIlI, this.modelElytra, lllllllllllllIIlllllIllIIIlllllI, lllllllllllllIIlllllIllIIIllIIII, lllllllllllllIIlllllIllIIIllllII, lllllllllllllIIlllllIllIIIlIlllI, lllllllllllllIIlllllIllIIIlllIlI, lllllllllllllIIlllllIllIIIlllIIl, lllllllllllllIIlllllIllIIIlIlIll);
            }
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }
    
    public LayerElytra(final RenderLivingBase<?> lllllllllllllIIlllllIllIIlIIllll) {
        this.modelElytra = new ModelElytra();
        this.renderPlayer = lllllllllllllIIlllllIllIIlIIllll;
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
