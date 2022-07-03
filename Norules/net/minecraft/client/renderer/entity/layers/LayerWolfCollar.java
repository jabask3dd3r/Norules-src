package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.entity.*;
import optifine.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class LayerWolfCollar implements LayerRenderer<EntityWolf>
{
    private static final /* synthetic */ ResourceLocation WOLF_COLLAR;
    private final /* synthetic */ RenderWolf wolfRenderer;
    
    static {
        WOLF_COLLAR = new ResourceLocation("textures/entity/wolf/wolf_collar.png");
    }
    
    @Override
    public void doRenderLayer(final EntityWolf lllllllllllllIllllIllIIIIllIIIIl, final float lllllllllllllIllllIllIIIIllIlIlI, final float lllllllllllllIllllIllIIIIlIlllll, final float lllllllllllllIllllIllIIIIllIlIII, final float lllllllllllllIllllIllIIIIllIIlll, final float lllllllllllllIllllIllIIIIllIIllI, final float lllllllllllllIllllIllIIIIllIIlIl, final float lllllllllllllIllllIllIIIIlIllIll) {
        if (lllllllllllllIllllIllIIIIllIIIIl.isTamed() && !lllllllllllllIllllIllIIIIllIIIIl.isInvisible()) {
            this.wolfRenderer.bindTexture(LayerWolfCollar.WOLF_COLLAR);
            float[] lllllllllllllIllllIllIIIIllIIIll = lllllllllllllIllllIllIIIIllIIIIl.getCollarColor().func_193349_f();
            if (Config.isCustomColors()) {
                lllllllllllllIllllIllIIIIllIIIll = CustomColors.getWolfCollarColors(lllllllllllllIllllIllIIIIllIIIIl.getCollarColor(), lllllllllllllIllllIllIIIIllIIIll);
            }
            GlStateManager.color(lllllllllllllIllllIllIIIIllIIIll[0], lllllllllllllIllllIllIIIIllIIIll[1], lllllllllllllIllllIllIIIIllIIIll[2]);
            this.wolfRenderer.getMainModel().render(lllllllllllllIllllIllIIIIllIIIIl, lllllllllllllIllllIllIIIIllIlIlI, lllllllllllllIllllIllIIIIlIlllll, lllllllllllllIllllIllIIIIllIIlll, lllllllllllllIllllIllIIIIllIIllI, lllllllllllllIllllIllIIIIllIIlIl, lllllllllllllIllllIllIIIIlIllIll);
        }
    }
    
    public LayerWolfCollar(final RenderWolf lllllllllllllIllllIllIIIIlllIllI) {
        this.wolfRenderer = lllllllllllllIllllIllIIIIlllIllI;
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
}
