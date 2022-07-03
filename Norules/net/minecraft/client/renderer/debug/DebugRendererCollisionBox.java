package net.minecraft.client.renderer.debug;

import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.*;
import net.minecraft.world.*;
import java.util.*;

public class DebugRendererCollisionBox implements DebugRenderer.IDebugRenderer
{
    private /* synthetic */ double field_191316_e;
    private /* synthetic */ double field_191314_c;
    private final /* synthetic */ Minecraft field_191312_a;
    private /* synthetic */ double field_191315_d;
    private /* synthetic */ EntityPlayer field_191313_b;
    
    @Override
    public void render(final float llllllllllllllIIlIIllIIIIlIIIllI, final long llllllllllllllIIlIIllIIIIlIIIlIl) {
        this.field_191313_b = this.field_191312_a.player;
        this.field_191314_c = this.field_191313_b.lastTickPosX + (this.field_191313_b.posX - this.field_191313_b.lastTickPosX) * llllllllllllllIIlIIllIIIIlIIIllI;
        this.field_191315_d = this.field_191313_b.lastTickPosY + (this.field_191313_b.posY - this.field_191313_b.lastTickPosY) * llllllllllllllIIlIIllIIIIlIIIllI;
        this.field_191316_e = this.field_191313_b.lastTickPosZ + (this.field_191313_b.posZ - this.field_191313_b.lastTickPosZ) * llllllllllllllIIlIIllIIIIlIIIllI;
        final World llllllllllllllIIlIIllIIIIlIIIlII = this.field_191312_a.player.world;
        final List<AxisAlignedBB> llllllllllllllIIlIIllIIIIlIIIIll = llllllllllllllIIlIIllIIIIlIIIlII.getCollisionBoxes(this.field_191313_b, this.field_191313_b.getEntityBoundingBox().expandXyz(6.0));
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.glLineWidth(2.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask(false);
        for (final AxisAlignedBB llllllllllllllIIlIIllIIIIlIIIIlI : llllllllllllllIIlIIllIIIIlIIIIll) {
            RenderGlobal.drawSelectionBoundingBox(llllllllllllllIIlIIllIIIIlIIIIlI.expandXyz(0.002).offset(-this.field_191314_c, -this.field_191315_d, -this.field_191316_e), 1.0f, 1.0f, 1.0f, 1.0f);
        }
        GlStateManager.depthMask(true);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
    
    public DebugRendererCollisionBox(final Minecraft llllllllllllllIIlIIllIIIIlIlIIII) {
        this.field_191312_a = llllllllllllllIIlIIllIIIIlIlIIII;
    }
}
