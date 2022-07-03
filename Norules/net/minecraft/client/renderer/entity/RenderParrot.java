package net.minecraft.client.renderer.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RenderParrot extends RenderLiving<EntityParrot>
{
    public static final /* synthetic */ ResourceLocation[] field_192862_a;
    
    private float func_192861_b(final EntityParrot lllllllllllllIlIlllIIIIIIIllllII, final float lllllllllllllIlIlllIIIIIIIllIlll) {
        final float lllllllllllllIlIlllIIIIIIIlllIlI = lllllllllllllIlIlllIIIIIIIllllII.field_192011_bE + (lllllllllllllIlIlllIIIIIIIllllII.field_192008_bB - lllllllllllllIlIlllIIIIIIIllllII.field_192011_bE) * lllllllllllllIlIlllIIIIIIIllIlll;
        final float lllllllllllllIlIlllIIIIIIIlllIIl = lllllllllllllIlIlllIIIIIIIllllII.field_192010_bD + (lllllllllllllIlIlllIIIIIIIllllII.field_192009_bC - lllllllllllllIlIlllIIIIIIIllllII.field_192010_bD) * lllllllllllllIlIlllIIIIIIIllIlll;
        return (MathHelper.sin(lllllllllllllIlIlllIIIIIIIlllIlI) + 1.0f) * lllllllllllllIlIlllIIIIIIIlllIIl;
    }
    
    public RenderParrot(final RenderManager lllllllllllllIlIlllIIIIIIlIIllll) {
        super(lllllllllllllIlIlllIIIIIIlIIllll, new ModelParrot(), 0.3f);
    }
    
    static {
        field_192862_a = new ResourceLocation[] { new ResourceLocation("textures/entity/parrot/parrot_red_blue.png"), new ResourceLocation("textures/entity/parrot/parrot_blue.png"), new ResourceLocation("textures/entity/parrot/parrot_green.png"), new ResourceLocation("textures/entity/parrot/parrot_yellow_blue.png"), new ResourceLocation("textures/entity/parrot/parrot_grey.png") };
    }
    
    public float handleRotationFloat(final EntityParrot lllllllllllllIlIlllIIIIIIlIIIllI, final float lllllllllllllIlIlllIIIIIIlIIIIlI) {
        return this.func_192861_b(lllllllllllllIlIlllIIIIIIlIIIllI, lllllllllllllIlIlllIIIIIIlIIIIlI);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityParrot lllllllllllllIlIlllIIIIIIlIIllII) {
        return RenderParrot.field_192862_a[lllllllllllllIlIlllIIIIIIlIIllII.func_191998_ds()];
    }
}
