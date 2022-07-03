package net.optifine.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.tileentity.*;
import optifine.*;
import net.minecraft.client.renderer.tileentity.*;

public class ModelAdapterHeadHumanoid extends ModelAdapter
{
    public ModelAdapterHeadHumanoid() {
        super(TileEntitySkull.class, "head_humanoid", 0.0f);
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase llllllllllllllIIIIIllIIIllIIIlIl, final String llllllllllllllIIIIIllIIIllIIIlII) {
        if (!(llllllllllllllIIIIIllIIIllIIIlIl instanceof ModelHumanoidHead)) {
            return null;
        }
        final ModelHumanoidHead llllllllllllllIIIIIllIIIllIIIIll = (ModelHumanoidHead)llllllllllllllIIIIIllIIIllIIIlIl;
        if (llllllllllllllIIIIIllIIIllIIIlII.equals("head")) {
            return llllllllllllllIIIIIllIIIllIIIIll.skeletonHead;
        }
        if (llllllllllllllIIIIIllIIIllIIIlII.equals("head2")) {
            return Reflector.ModelHumanoidHead_head.exists() ? ((ModelRenderer)Reflector.getFieldValue(llllllllllllllIIIIIllIIIllIIIIll, Reflector.ModelHumanoidHead_head)) : null;
        }
        return null;
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelHumanoidHead();
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llllllllllllllIIIIIllIIIlIlllIll, final float llllllllllllllIIIIIllIIIlIlllIlI) {
        final TileEntityRendererDispatcher llllllllllllllIIIIIllIIIlIlllIIl = TileEntityRendererDispatcher.instance;
        TileEntitySpecialRenderer llllllllllllllIIIIIllIIIlIlllIII = llllllllllllllIIIIIllIIIlIlllIIl.getSpecialRendererByClass(TileEntitySkull.class);
        if (!(llllllllllllllIIIIIllIIIlIlllIII instanceof TileEntitySkullRenderer)) {
            return null;
        }
        if (llllllllllllllIIIIIllIIIlIlllIII.getEntityClass() == null) {
            llllllllllllllIIIIIllIIIlIlllIII = new TileEntitySkullRenderer();
            llllllllllllllIIIIIllIIIlIlllIII.setRendererDispatcher(llllllllllllllIIIIIllIIIlIlllIIl);
        }
        if (!Reflector.TileEntitySkullRenderer_humanoidHead.exists()) {
            Config.warn("Field not found: TileEntitySkullRenderer.humanoidHead");
            return null;
        }
        Reflector.setFieldValue(llllllllllllllIIIIIllIIIlIlllIII, Reflector.TileEntitySkullRenderer_humanoidHead, llllllllllllllIIIIIllIIIlIlllIll);
        return llllllllllllllIIIIIllIIIlIlllIII;
    }
}
