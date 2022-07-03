package net.minecraft.client.renderer.tileentity;

import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.block.*;
import net.minecraft.client.model.*;
import java.util.*;
import net.minecraft.tileentity.*;

public class TileEntityChestRenderer extends TileEntitySpecialRenderer<TileEntityChest>
{
    private static final /* synthetic */ ResourceLocation TEXTURE_TRAPPED;
    private /* synthetic */ boolean isChristmas;
    private final /* synthetic */ ModelChest simpleChest;
    private static final /* synthetic */ ResourceLocation TEXTURE_TRAPPED_DOUBLE;
    private static final /* synthetic */ ResourceLocation TEXTURE_CHRISTMAS;
    private static final /* synthetic */ ResourceLocation TEXTURE_NORMAL_DOUBLE;
    private final /* synthetic */ ModelChest largeChest;
    private static final /* synthetic */ ResourceLocation TEXTURE_CHRISTMAS_DOUBLE;
    private static final /* synthetic */ ResourceLocation TEXTURE_NORMAL;
    
    static {
        TEXTURE_TRAPPED_DOUBLE = new ResourceLocation("textures/entity/chest/trapped_double.png");
        TEXTURE_CHRISTMAS_DOUBLE = new ResourceLocation("textures/entity/chest/christmas_double.png");
        TEXTURE_NORMAL_DOUBLE = new ResourceLocation("textures/entity/chest/normal_double.png");
        TEXTURE_TRAPPED = new ResourceLocation("textures/entity/chest/trapped.png");
        TEXTURE_CHRISTMAS = new ResourceLocation("textures/entity/chest/christmas.png");
        TEXTURE_NORMAL = new ResourceLocation("textures/entity/chest/normal.png");
    }
    
    @Override
    public void func_192841_a(final TileEntityChest lIIIlIllIIlIIlI, final double lIIIlIllIIlIIIl, final double lIIIlIllIIlIIII, final double lIIIlIlIllllllI, final float lIIIlIllIIIlllI, final int lIIIlIllIIIllIl, final float lIIIlIlIllllIll) {
        GlStateManager.enableDepth();
        GlStateManager.depthFunc(515);
        GlStateManager.depthMask(true);
        int lIIIlIllIIIlIlI;
        if (lIIIlIllIIlIIlI.hasWorldObj()) {
            final Block lIIIlIllIIIlIIl = lIIIlIllIIlIIlI.getBlockType();
            int lIIIlIllIIIlIll = lIIIlIllIIlIIlI.getBlockMetadata();
            if (lIIIlIllIIIlIIl instanceof BlockChest && lIIIlIllIIIlIll == 0) {
                ((BlockChest)lIIIlIllIIIlIIl).checkForSurroundingChests(lIIIlIllIIlIIlI.getWorld(), lIIIlIllIIlIIlI.getPos(), lIIIlIllIIlIIlI.getWorld().getBlockState(lIIIlIllIIlIIlI.getPos()));
                lIIIlIllIIIlIll = lIIIlIllIIlIIlI.getBlockMetadata();
            }
            lIIIlIllIIlIIlI.checkForAdjacentChests();
        }
        else {
            lIIIlIllIIIlIlI = 0;
        }
        if (lIIIlIllIIlIIlI.adjacentChestZNeg == null && lIIIlIllIIlIIlI.adjacentChestXNeg == null) {
            ModelChest lIIIlIllIIIIlll = null;
            if (lIIIlIllIIlIIlI.adjacentChestXPos == null && lIIIlIllIIlIIlI.adjacentChestZPos == null) {
                final ModelChest lIIIlIllIIIlIII = this.simpleChest;
                if (lIIIlIllIIIllIl >= 0) {
                    this.bindTexture(TileEntityChestRenderer.DESTROY_STAGES[lIIIlIllIIIllIl]);
                    GlStateManager.matrixMode(5890);
                    GlStateManager.pushMatrix();
                    GlStateManager.scale(4.0f, 4.0f, 1.0f);
                    GlStateManager.translate(0.0625f, 0.0625f, 0.0625f);
                    GlStateManager.matrixMode(5888);
                }
                else if (this.isChristmas) {
                    this.bindTexture(TileEntityChestRenderer.TEXTURE_CHRISTMAS);
                }
                else if (lIIIlIllIIlIIlI.getChestType() == BlockChest.Type.TRAP) {
                    this.bindTexture(TileEntityChestRenderer.TEXTURE_TRAPPED);
                }
                else {
                    this.bindTexture(TileEntityChestRenderer.TEXTURE_NORMAL);
                }
            }
            else {
                lIIIlIllIIIIlll = this.largeChest;
                if (lIIIlIllIIIllIl >= 0) {
                    this.bindTexture(TileEntityChestRenderer.DESTROY_STAGES[lIIIlIllIIIllIl]);
                    GlStateManager.matrixMode(5890);
                    GlStateManager.pushMatrix();
                    GlStateManager.scale(8.0f, 4.0f, 1.0f);
                    GlStateManager.translate(0.0625f, 0.0625f, 0.0625f);
                    GlStateManager.matrixMode(5888);
                }
                else if (this.isChristmas) {
                    this.bindTexture(TileEntityChestRenderer.TEXTURE_CHRISTMAS_DOUBLE);
                }
                else if (lIIIlIllIIlIIlI.getChestType() == BlockChest.Type.TRAP) {
                    this.bindTexture(TileEntityChestRenderer.TEXTURE_TRAPPED_DOUBLE);
                }
                else {
                    this.bindTexture(TileEntityChestRenderer.TEXTURE_NORMAL_DOUBLE);
                }
            }
            GlStateManager.pushMatrix();
            GlStateManager.enableRescaleNormal();
            if (lIIIlIllIIIllIl < 0) {
                GlStateManager.color(1.0f, 1.0f, 1.0f, lIIIlIlIllllIll);
            }
            GlStateManager.translate((float)lIIIlIllIIlIIIl, (float)lIIIlIllIIlIIII + 1.0f, (float)lIIIlIlIllllllI + 1.0f);
            GlStateManager.scale(1.0f, -1.0f, -1.0f);
            GlStateManager.translate(0.5f, 0.5f, 0.5f);
            int lIIIlIllIIIIllI = 0;
            if (lIIIlIllIIIlIlI == 2) {
                lIIIlIllIIIIllI = 180;
            }
            if (lIIIlIllIIIlIlI == 3) {
                lIIIlIllIIIIllI = 0;
            }
            if (lIIIlIllIIIlIlI == 4) {
                lIIIlIllIIIIllI = 90;
            }
            if (lIIIlIllIIIlIlI == 5) {
                lIIIlIllIIIIllI = -90;
            }
            if (lIIIlIllIIIlIlI == 2 && lIIIlIllIIlIIlI.adjacentChestXPos != null) {
                GlStateManager.translate(1.0f, 0.0f, 0.0f);
            }
            if (lIIIlIllIIIlIlI == 5 && lIIIlIllIIlIIlI.adjacentChestZPos != null) {
                GlStateManager.translate(0.0f, 0.0f, -1.0f);
            }
            GlStateManager.rotate((float)lIIIlIllIIIIllI, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(-0.5f, -0.5f, -0.5f);
            float lIIIlIllIIIIlIl = lIIIlIllIIlIIlI.prevLidAngle + (lIIIlIllIIlIIlI.lidAngle - lIIIlIllIIlIIlI.prevLidAngle) * lIIIlIllIIIlllI;
            if (lIIIlIllIIlIIlI.adjacentChestZNeg != null) {
                final float lIIIlIllIIIIlII = lIIIlIllIIlIIlI.adjacentChestZNeg.prevLidAngle + (lIIIlIllIIlIIlI.adjacentChestZNeg.lidAngle - lIIIlIllIIlIIlI.adjacentChestZNeg.prevLidAngle) * lIIIlIllIIIlllI;
                if (lIIIlIllIIIIlII > lIIIlIllIIIIlIl) {
                    lIIIlIllIIIIlIl = lIIIlIllIIIIlII;
                }
            }
            if (lIIIlIllIIlIIlI.adjacentChestXNeg != null) {
                final float lIIIlIllIIIIIll = lIIIlIllIIlIIlI.adjacentChestXNeg.prevLidAngle + (lIIIlIllIIlIIlI.adjacentChestXNeg.lidAngle - lIIIlIllIIlIIlI.adjacentChestXNeg.prevLidAngle) * lIIIlIllIIIlllI;
                if (lIIIlIllIIIIIll > lIIIlIllIIIIlIl) {
                    lIIIlIllIIIIlIl = lIIIlIllIIIIIll;
                }
            }
            lIIIlIllIIIIlIl = 1.0f - lIIIlIllIIIIlIl;
            lIIIlIllIIIIlIl = 1.0f - lIIIlIllIIIIlIl * lIIIlIllIIIIlIl * lIIIlIllIIIIlIl;
            lIIIlIllIIIIlll.chestLid.rotateAngleX = -(lIIIlIllIIIIlIl * 1.5707964f);
            lIIIlIllIIIIlll.renderAll();
            GlStateManager.disableRescaleNormal();
            GlStateManager.popMatrix();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            if (lIIIlIllIIIllIl >= 0) {
                GlStateManager.matrixMode(5890);
                GlStateManager.popMatrix();
                GlStateManager.matrixMode(5888);
            }
        }
    }
    
    public TileEntityChestRenderer() {
        this.simpleChest = new ModelChest();
        this.largeChest = new ModelLargeChest();
        final Calendar lIIIlIllIlIIIll = Calendar.getInstance();
        if (lIIIlIllIlIIIll.get(2) + 1 == 12 && lIIIlIllIlIIIll.get(5) >= 24 && lIIIlIllIlIIIll.get(5) <= 26) {
            this.isChristmas = true;
        }
    }
}
