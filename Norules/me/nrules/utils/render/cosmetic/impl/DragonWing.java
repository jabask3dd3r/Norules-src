package me.nrules.utils.render.cosmetic.impl;

import net.minecraft.client.model.*;
import net.minecraft.entity.player.*;
import org.lwjgl.opengl.*;
import me.nrules.module.render.*;
import net.minecraft.item.*;
import me.nrules.utils.render.cosmetic.*;
import net.minecraft.client.*;
import net.minecraft.util.*;

public class DragonWing extends ModelBase
{
    private static /* synthetic */ ModelRenderer mr2;
    private static /* synthetic */ ModelRenderer mr1;
    
    private static float calRotateBodyNowX(final float lllllllllllllIIlIlIIlIllIIIlIlIl, final float lllllllllllllIIlIlIIlIllIIIlIlII, final float lllllllllllllIIlIlIIlIllIIIlIIll) {
        final float lllllllllllllIIlIlIIlIllIIIlIIlI = (lllllllllllllIIlIlIIlIllIIIlIlIl + (lllllllllllllIIlIlIIlIllIIIlIlII - lllllllllllllIIlIlIIlIllIIIlIlIl) * lllllllllllllIIlIlIIlIllIIIlIIll) % 360.0f;
        return lllllllllllllIIlIlIIlIllIIIlIIlI;
    }
    
    public static void render(final EntityPlayer lllllllllllllIIlIlIIlIllIIlIlllI, final float lllllllllllllIIlIlIIlIllIIlIllIl) {
        final double lllllllllllllIIlIlIIlIllIIllIIlI = interpolate(lllllllllllllIIlIlIIlIllIIlIlllI.prevRenderYawOffset, lllllllllllllIIlIlIIlIllIIlIlllI.renderYawOffset, lllllllllllllIIlIlIIlIllIIlIllIl);
        GL11.glPushMatrix();
        GL11.glScaled(Cosmetics.scaleS.getValDouble(), Cosmetics.scaleS.getValDouble(), Cosmetics.scaleS.getValDouble());
        GL11.glRotated(Math.toRadians(lllllllllllllIIlIlIIlIllIIllIIlI) - 4.0, 0.0, 1.0, 0.0);
        GL11.glTranslated(0.0, 0.1, 0.095);
        if (lllllllllllllIIlIlIIlIllIIlIlllI.isSneaking()) {
            GL11.glTranslated(0.0, 0.2, 0.05);
        }
        if (!lllllllllllllIIlIlIIlIllIIlIlllI.inventory.armorInventory.get(2).func_190926_b()) {
            GL11.glTranslated(0.0, 0.0, 0.05);
        }
        final ResourceLocation lllllllllllllIIlIlIIlIllIIllIIIl = Cosmetic.getWing();
        Minecraft.getMinecraft().getTextureManager().bindTexture(lllllllllllllIIlIlIIlIllIIllIIIl);
        for (int lllllllllllllIIlIlIIlIllIIllIIII = 0; lllllllllllllIIlIlIIlIllIIllIIII < 2; ++lllllllllllllIIlIlIIlIllIIllIIII) {
            final float lllllllllllllIIlIlIIlIllIIlIllll = System.currentTimeMillis() % 1000L / 1000.0f * 3.1415927f * 2.0f;
            DragonWing.mr1.rotateAngleX = (float)(Math.toRadians(-80.0) - Math.cos(lllllllllllllIIlIlIIlIllIIlIllll) * 0.20000000298023224);
            DragonWing.mr1.rotateAngleY = (float)(Math.toRadians(30.0) + Math.sin(lllllllllllllIIlIlIIlIllIIlIllll) * 0.4000000059604645);
            DragonWing.mr1.rotateAngleZ = (float)Math.toRadians(20.0);
            DragonWing.mr2.rotateAngleZ = (float)(-(Math.sin(lllllllllllllIIlIlIIlIllIIlIllll + 2.0f) + 0.5) * 0.75);
            DragonWing.mr1.render(0.0625f);
            GL11.glScalef(-1.0f, 1.0f, 1.0f);
        }
        GL11.glCullFace(1029);
        GL11.glPopMatrix();
    }
    
    public DragonWing() {
        this.setTextureOffset("wing.bone", 0, 0);
        this.setTextureOffset("wing.skin", -10, 8);
        this.setTextureOffset("wingtip.bone", 0, 5);
        this.setTextureOffset("wingtip.skin", -10, 18);
        (DragonWing.mr1 = new ModelRenderer(this, "wing")).setTextureSize(30, 30);
        DragonWing.mr1.setRotationPoint(-2.0f, 0.0f, 0.0f);
        DragonWing.mr1.addBox("bone", -10.0f, -1.0f, -1.0f, 10, 2, 2);
        DragonWing.mr1.addBox("skin", -10.0f, 0.0f, 0.5f, 10, 0, 10);
        (DragonWing.mr2 = new ModelRenderer(this, "wingtip")).setTextureSize(30, 30);
        DragonWing.mr2.setRotationPoint(-10.0f, 0.0f, 0.0f);
        DragonWing.mr2.addBox("bone", -10.0f, -0.5f, -0.5f, 10, 1, 1);
        DragonWing.mr2.addBox("skin", -10.0f, 0.0f, 0.5f, 10, 0, 10);
        DragonWing.mr1.addChild(DragonWing.mr2);
    }
    
    private static float interpolate(final float lllllllllllllIIlIlIIlIlIlllllIIl, final float lllllllllllllIIlIlIIlIlIllllllII, final float lllllllllllllIIlIlIIlIlIlllllIll) {
        float lllllllllllllIIlIlIIlIlIlllllIlI = (lllllllllllllIIlIlIIlIlIlllllIIl + (lllllllllllllIIlIlIIlIlIllllllII - lllllllllllllIIlIlIIlIlIlllllIIl) * lllllllllllllIIlIlIIlIlIlllllIll) % 360.0f;
        if (lllllllllllllIIlIlIIlIlIlllllIlI < 0.0f) {
            lllllllllllllIIlIlIIlIlIlllllIlI += 360.0f;
        }
        return lllllllllllllIIlIlIIlIlIlllllIlI;
    }
    
    private static float calRotateHeadNowY(final float lllllllllllllIIlIlIIlIllIIIIIlIl, final float lllllllllllllIIlIlIIlIllIIIIlIII, final float lllllllllllllIIlIlIIlIllIIIIIlll) {
        final float lllllllllllllIIlIlIIlIllIIIIIllI = (lllllllllllllIIlIlIIlIllIIIIIlIl + (lllllllllllllIIlIlIIlIllIIIIlIII - lllllllllllllIIlIlIIlIllIIIIIlIl) * lllllllllllllIIlIlIIlIllIIIIIlll) % 180.0f;
        return lllllllllllllIIlIlIIlIllIIIIIllI;
    }
    
    private static float calRotateHeadNowX(final float lllllllllllllIIlIlIIlIllIIlIIIll, final float lllllllllllllIIlIlIIlIllIIlIIIlI, final float lllllllllllllIIlIlIIlIllIIIlllII, final EntityPlayer lllllllllllllIIlIlIIlIllIIIllIll) {
        if (!lllllllllllllIIlIlIIlIllIIIllIll.equals(Minecraft.getMinecraft().player) && ((0.0f > lllllllllllllIIlIlIIlIllIIlIIIll && 0.0f < lllllllllllllIIlIlIIlIllIIlIIIlI) || (0.0f < lllllllllllllIIlIlIIlIllIIlIIIll && 0.0f > lllllllllllllIIlIlIIlIllIIlIIIlI))) {
            return lllllllllllllIIlIlIIlIllIIlIIIlI;
        }
        final float lllllllllllllIIlIlIIlIllIIIlllll = (lllllllllllllIIlIlIIlIllIIlIIIll + (lllllllllllllIIlIlIIlIllIIlIIIlI - lllllllllllllIIlIlIIlIllIIlIIIll) * lllllllllllllIIlIlIIlIllIIIlllII) % 360.0f;
        return lllllllllllllIIlIlIIlIllIIIlllll;
    }
}
