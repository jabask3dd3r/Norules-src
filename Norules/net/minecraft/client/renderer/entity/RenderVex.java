package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class RenderVex extends RenderBiped<EntityVex>
{
    private static final /* synthetic */ ResourceLocation field_191344_j;
    private /* synthetic */ int field_191345_k;
    private static final /* synthetic */ ResourceLocation field_191343_a;
    
    public RenderVex(final RenderManager lllllllllllllIlIllIlIlIIlIIIIIlI) {
        super(lllllllllllllIlIllIlIlIIlIIIIIlI, new ModelVex(), 0.3f);
        this.field_191345_k = ((ModelVex)this.mainModel).func_191228_a();
    }
    
    @Override
    public void doRender(final EntityVex lllllllllllllIlIllIlIlIIIllIlIlI, final double lllllllllllllIlIllIlIlIIIlllIIIl, final double lllllllllllllIlIllIlIlIIIllIlIII, final double lllllllllllllIlIllIlIlIIIllIllll, final float lllllllllllllIlIllIlIlIIIllIlllI, final float lllllllllllllIlIllIlIlIIIllIIlIl) {
        final int lllllllllllllIlIllIlIlIIIllIllII = ((ModelVex)this.mainModel).func_191228_a();
        if (lllllllllllllIlIllIlIlIIIllIllII != this.field_191345_k) {
            this.mainModel = new ModelVex();
            this.field_191345_k = lllllllllllllIlIllIlIlIIIllIllII;
        }
        super.doRender(lllllllllllllIlIllIlIlIIIllIlIlI, lllllllllllllIlIllIlIlIIIlllIIIl, lllllllllllllIlIllIlIlIIIllIlIII, lllllllllllllIlIllIlIlIIIllIllll, lllllllllllllIlIllIlIlIIIllIlllI, lllllllllllllIlIllIlIlIIIllIIlIl);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityVex lllllllllllllIlIllIlIlIIIlllllII) {
        return lllllllllllllIlIllIlIlIIIlllllII.func_190647_dj() ? RenderVex.field_191344_j : RenderVex.field_191343_a;
    }
    
    static {
        field_191343_a = new ResourceLocation("textures/entity/illager/vex.png");
        field_191344_j = new ResourceLocation("textures/entity/illager/vex_charging.png");
    }
    
    @Override
    protected void preRenderCallback(final EntityVex lllllllllllllIlIllIlIlIIIllIIIlI, final float lllllllllllllIlIllIlIlIIIllIIIIl) {
        GlStateManager.scale(0.4f, 0.4f, 0.4f);
    }
}
