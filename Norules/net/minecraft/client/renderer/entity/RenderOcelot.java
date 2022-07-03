package net.minecraft.client.renderer.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RenderOcelot extends RenderLiving<EntityOcelot>
{
    private static final /* synthetic */ ResourceLocation BLACK_OCELOT_TEXTURES;
    private static final /* synthetic */ ResourceLocation SIAMESE_OCELOT_TEXTURES;
    private static final /* synthetic */ ResourceLocation RED_OCELOT_TEXTURES;
    private static final /* synthetic */ ResourceLocation OCELOT_TEXTURES;
    
    @Override
    protected void preRenderCallback(final EntityOcelot lllllllllllllllIlIIllIllIIllllII, final float lllllllllllllllIlIIllIllIIlllIlI) {
        super.preRenderCallback(lllllllllllllllIlIIllIllIIllllII, lllllllllllllllIlIIllIllIIlllIlI);
        if (lllllllllllllllIlIIllIllIIllllII.isTamed()) {
            GlStateManager.scale(0.8f, 0.8f, 0.8f);
        }
    }
    
    public RenderOcelot(final RenderManager lllllllllllllllIlIIllIllIlIIlIll) {
        super(lllllllllllllllIlIIllIllIlIIlIll, new ModelOcelot(), 0.4f);
    }
    
    static {
        BLACK_OCELOT_TEXTURES = new ResourceLocation("textures/entity/cat/black.png");
        OCELOT_TEXTURES = new ResourceLocation("textures/entity/cat/ocelot.png");
        RED_OCELOT_TEXTURES = new ResourceLocation("textures/entity/cat/red.png");
        SIAMESE_OCELOT_TEXTURES = new ResourceLocation("textures/entity/cat/siamese.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityOcelot lllllllllllllllIlIIllIllIlIIIlIl) {
        switch (lllllllllllllllIlIIllIllIlIIIlIl.getTameSkin()) {
            default: {
                return RenderOcelot.OCELOT_TEXTURES;
            }
            case 1: {
                return RenderOcelot.BLACK_OCELOT_TEXTURES;
            }
            case 2: {
                return RenderOcelot.RED_OCELOT_TEXTURES;
            }
            case 3: {
                return RenderOcelot.SIAMESE_OCELOT_TEXTURES;
            }
        }
    }
}
