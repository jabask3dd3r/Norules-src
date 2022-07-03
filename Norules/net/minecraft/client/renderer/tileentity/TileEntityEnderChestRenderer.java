package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.model.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.tileentity.*;

public class TileEntityEnderChestRenderer extends TileEntitySpecialRenderer<TileEntityEnderChest>
{
    private final /* synthetic */ ModelChest modelChest;
    private static final /* synthetic */ ResourceLocation ENDER_CHEST_TEXTURE;
    
    @Override
    public void func_192841_a(final TileEntityEnderChest llllllllllllllIIllIIIllIlllIIllI, final double llllllllllllllIIllIIIllIllllIIII, final double llllllllllllllIIllIIIllIlllIIlII, final double llllllllllllllIIllIIIllIlllIlllI, final float llllllllllllllIIllIIIllIlllIIIlI, final int llllllllllllllIIllIIIllIlllIllII, final float llllllllllllllIIllIIIllIlllIIIII) {
        int llllllllllllllIIllIIIllIlllIlIlI = 0;
        if (llllllllllllllIIllIIIllIlllIIllI.hasWorldObj()) {
            llllllllllllllIIllIIIllIlllIlIlI = llllllllllllllIIllIIIllIlllIIllI.getBlockMetadata();
        }
        if (llllllllllllllIIllIIIllIlllIllII >= 0) {
            this.bindTexture(TileEntityEnderChestRenderer.DESTROY_STAGES[llllllllllllllIIllIIIllIlllIllII]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0f, 4.0f, 1.0f);
            GlStateManager.translate(0.0625f, 0.0625f, 0.0625f);
            GlStateManager.matrixMode(5888);
        }
        else {
            this.bindTexture(TileEntityEnderChestRenderer.ENDER_CHEST_TEXTURE);
        }
        GlStateManager.pushMatrix();
        GlStateManager.enableRescaleNormal();
        GlStateManager.color(1.0f, 1.0f, 1.0f, llllllllllllllIIllIIIllIlllIIIII);
        GlStateManager.translate((float)llllllllllllllIIllIIIllIllllIIII, (float)llllllllllllllIIllIIIllIlllIIlII + 1.0f, (float)llllllllllllllIIllIIIllIlllIlllI + 1.0f);
        GlStateManager.scale(1.0f, -1.0f, -1.0f);
        GlStateManager.translate(0.5f, 0.5f, 0.5f);
        int llllllllllllllIIllIIIllIlllIlIIl = 0;
        if (llllllllllllllIIllIIIllIlllIlIlI == 2) {
            llllllllllllllIIllIIIllIlllIlIIl = 180;
        }
        if (llllllllllllllIIllIIIllIlllIlIlI == 3) {
            llllllllllllllIIllIIIllIlllIlIIl = 0;
        }
        if (llllllllllllllIIllIIIllIlllIlIlI == 4) {
            llllllllllllllIIllIIIllIlllIlIIl = 90;
        }
        if (llllllllllllllIIllIIIllIlllIlIlI == 5) {
            llllllllllllllIIllIIIllIlllIlIIl = -90;
        }
        GlStateManager.rotate((float)llllllllllllllIIllIIIllIlllIlIIl, 0.0f, 1.0f, 0.0f);
        GlStateManager.translate(-0.5f, -0.5f, -0.5f);
        float llllllllllllllIIllIIIllIlllIlIII = llllllllllllllIIllIIIllIlllIIllI.prevLidAngle + (llllllllllllllIIllIIIllIlllIIllI.lidAngle - llllllllllllllIIllIIIllIlllIIllI.prevLidAngle) * llllllllllllllIIllIIIllIlllIIIlI;
        llllllllllllllIIllIIIllIlllIlIII = 1.0f - llllllllllllllIIllIIIllIlllIlIII;
        llllllllllllllIIllIIIllIlllIlIII = 1.0f - llllllllllllllIIllIIIllIlllIlIII * llllllllllllllIIllIIIllIlllIlIII * llllllllllllllIIllIIIllIlllIlIII;
        this.modelChest.chestLid.rotateAngleX = -(llllllllllllllIIllIIIllIlllIlIII * 1.5707964f);
        this.modelChest.renderAll();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        if (llllllllllllllIIllIIIllIlllIllII >= 0) {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }
    
    static {
        ENDER_CHEST_TEXTURE = new ResourceLocation("textures/entity/chest/ender.png");
    }
    
    public TileEntityEnderChestRenderer() {
        this.modelChest = new ModelChest();
    }
}
