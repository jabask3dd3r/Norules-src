package net.minecraft.client.renderer.entity;

import net.minecraft.entity.*;
import net.minecraft.util.*;
import javax.annotation.*;
import net.minecraft.client.renderer.*;

public class RenderEntity extends Render<Entity>
{
    public RenderEntity(final RenderManager lllllllllllllIIIIIIllIlIllIlIIIl) {
        super(lllllllllllllIIIIIIllIlIllIlIIIl);
    }
    
    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(final Entity lllllllllllllIIIIIIllIlIlIlllIlI) {
        return null;
    }
    
    @Override
    public void doRender(final Entity lllllllllllllIIIIIIllIlIllIIlIII, final double lllllllllllllIIIIIIllIlIllIIIIII, final double lllllllllllllIIIIIIllIlIllIIIllI, final double lllllllllllllIIIIIIllIlIlIlllllI, final float lllllllllllllIIIIIIllIlIlIllllIl, final float lllllllllllllIIIIIIllIlIlIllllII) {
        GlStateManager.pushMatrix();
        Render.renderOffsetAABB(lllllllllllllIIIIIIllIlIllIIlIII.getEntityBoundingBox(), lllllllllllllIIIIIIllIlIllIIIIII - lllllllllllllIIIIIIllIlIllIIlIII.lastTickPosX, lllllllllllllIIIIIIllIlIllIIIllI - lllllllllllllIIIIIIllIlIllIIlIII.lastTickPosY, lllllllllllllIIIIIIllIlIlIlllllI - lllllllllllllIIIIIIllIlIllIIlIII.lastTickPosZ);
        GlStateManager.popMatrix();
        super.doRender(lllllllllllllIIIIIIllIlIllIIlIII, lllllllllllllIIIIIIllIlIllIIIIII, lllllllllllllIIIIIIllIlIllIIIllI, lllllllllllllIIIIIIllIlIlIlllllI, lllllllllllllIIIIIIllIlIlIllllIl, lllllllllllllIIIIIIllIlIlIllllII);
    }
}
