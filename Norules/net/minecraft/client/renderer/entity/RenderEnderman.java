package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.*;

public class RenderEnderman extends RenderLiving<EntityEnderman>
{
    private final /* synthetic */ Random rnd;
    private static final /* synthetic */ ResourceLocation ENDERMAN_TEXTURES;
    
    @Override
    public void doRender(final EntityEnderman lllllllllllllllIIIllIlIIIlIIIIll, double lllllllllllllllIIIllIlIIIlIIIIlI, final double lllllllllllllllIIIllIlIIIlIIIIIl, double lllllllllllllllIIIllIlIIIlIIIIII, final float lllllllllllllllIIIllIlIIIlIIlIIl, final float lllllllllllllllIIIllIlIIIIlllllI) {
        final IBlockState lllllllllllllllIIIllIlIIIlIIIlll = lllllllllllllllIIIllIlIIIlIIIIll.getHeldBlockState();
        final ModelEnderman lllllllllllllllIIIllIlIIIlIIIllI = this.getMainModel();
        lllllllllllllllIIIllIlIIIlIIIllI.isCarrying = (lllllllllllllllIIIllIlIIIlIIIlll != null);
        lllllllllllllllIIIllIlIIIlIIIllI.isAttacking = lllllllllllllllIIIllIlIIIlIIIIll.isScreaming();
        if (lllllllllllllllIIIllIlIIIlIIIIll.isScreaming()) {
            final double lllllllllllllllIIIllIlIIIlIIIlIl = 0.02;
            lllllllllllllllIIIllIlIIIlIIIIlI += this.rnd.nextGaussian() * 0.02;
            lllllllllllllllIIIllIlIIIlIIIIII += this.rnd.nextGaussian() * 0.02;
        }
        super.doRender(lllllllllllllllIIIllIlIIIlIIIIll, lllllllllllllllIIIllIlIIIlIIIIlI, lllllllllllllllIIIllIlIIIlIIIIIl, (double)lllllllllllllllIIIllIlIIIlIIIIII, lllllllllllllllIIIllIlIIIlIIlIIl, lllllllllllllllIIIllIlIIIIlllllI);
    }
    
    static {
        ENDERMAN_TEXTURES = new ResourceLocation("textures/entity/enderman/enderman.png");
    }
    
    public RenderEnderman(final RenderManager lllllllllllllllIIIllIlIIIlIllllI) {
        super(lllllllllllllllIIIllIlIIIlIllllI, new ModelEnderman(0.0f), 0.5f);
        this.rnd = new Random();
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerEndermanEyes(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerHeldBlock(this));
    }
    
    @Override
    public ModelEnderman getMainModel() {
        return (ModelEnderman)super.getMainModel();
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityEnderman lllllllllllllllIIIllIlIIIIlllIIl) {
        return RenderEnderman.ENDERMAN_TEXTURES;
    }
}
