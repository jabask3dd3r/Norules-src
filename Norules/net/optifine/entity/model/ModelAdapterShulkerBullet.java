package net.optifine.entity.model;

import net.minecraft.client.*;
import optifine.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.client.model.*;

public class ModelAdapterShulkerBullet extends ModelAdapter
{
    @Override
    public ModelBase makeModel() {
        return new ModelShulkerBullet();
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIIIIllIlllIIlllIllI, final float lllllllllllllIIIIllIlllIIllllIIl) {
        final RenderManager lllllllllllllIIIIllIlllIIllllIII = Minecraft.getMinecraft().getRenderManager();
        final RenderShulkerBullet lllllllllllllIIIIllIlllIIlllIlll = new RenderShulkerBullet(lllllllllllllIIIIllIlllIIllllIII);
        if (!Reflector.RenderShulkerBullet_model.exists()) {
            Config.warn("Field not found: RenderShulkerBullet.model");
            return null;
        }
        Reflector.setFieldValue(lllllllllllllIIIIllIlllIIlllIlll, Reflector.RenderShulkerBullet_model, lllllllllllllIIIIllIlllIIlllIllI);
        lllllllllllllIIIIllIlllIIlllIlll.shadowSize = lllllllllllllIIIIllIlllIIllllIIl;
        return lllllllllllllIIIIllIlllIIlllIlll;
    }
    
    public ModelAdapterShulkerBullet() {
        super(EntityShulkerBullet.class, "shulker_bullet", 0.0f);
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllIIIIllIlllIlIIIIIlI, final String lllllllllllllIIIIllIlllIlIIIIlII) {
        if (!(lllllllllllllIIIIllIlllIlIIIIIlI instanceof ModelShulkerBullet)) {
            return null;
        }
        final ModelShulkerBullet lllllllllllllIIIIllIlllIlIIIIIll = (ModelShulkerBullet)lllllllllllllIIIIllIlllIlIIIIIlI;
        return lllllllllllllIIIIllIlllIlIIIIlII.equals("bullet") ? lllllllllllllIIIIllIlllIlIIIIIll.renderer : null;
    }
}
