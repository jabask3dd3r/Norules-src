package net.minecraft.client.renderer.entity;

import java.util.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import com.google.common.collect.*;
import net.minecraft.entity.passive.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class RenderAbstractHorse extends RenderLiving<AbstractHorse>
{
    private final /* synthetic */ float field_191360_j;
    private static final /* synthetic */ Map<Class<?>, ResourceLocation> field_191359_a;
    
    @Override
    protected ResourceLocation getEntityTexture(final AbstractHorse lllllllllllllIIlIIlIlllIIlIIIlIl) {
        return RenderAbstractHorse.field_191359_a.get(lllllllllllllIIlIIlIlllIIlIIIlIl.getClass());
    }
    
    public RenderAbstractHorse(final RenderManager lllllllllllllIIlIIlIlllIIlIlIIlI, final float lllllllllllllIIlIIlIlllIIlIlIlII) {
        super(lllllllllllllIIlIIlIlllIIlIlIIlI, new ModelHorse(), 0.75f);
        this.field_191360_j = lllllllllllllIIlIIlIlllIIlIlIlII;
    }
    
    static {
        (field_191359_a = Maps.newHashMap()).put(EntityDonkey.class, new ResourceLocation("textures/entity/horse/donkey.png"));
        RenderAbstractHorse.field_191359_a.put(EntityMule.class, new ResourceLocation("textures/entity/horse/mule.png"));
        RenderAbstractHorse.field_191359_a.put(EntityZombieHorse.class, new ResourceLocation("textures/entity/horse/horse_zombie.png"));
        RenderAbstractHorse.field_191359_a.put(EntitySkeletonHorse.class, new ResourceLocation("textures/entity/horse/horse_skeleton.png"));
    }
    
    @Override
    protected void preRenderCallback(final AbstractHorse lllllllllllllIIlIIlIlllIIlIIllII, final float lllllllllllllIIlIIlIlllIIlIIlIII) {
        GlStateManager.scale(this.field_191360_j, this.field_191360_j, this.field_191360_j);
        super.preRenderCallback(lllllllllllllIIlIIlIlllIIlIIllII, lllllllllllllIIlIIlIlllIIlIIlIII);
    }
    
    public RenderAbstractHorse(final RenderManager lllllllllllllIIlIIlIlllIIlIlllII) {
        this(lllllllllllllIIlIIlIlllIIlIlllII, 1.0f);
    }
}
