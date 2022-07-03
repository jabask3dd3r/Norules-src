package net.optifine.entity.model;

import net.minecraft.tileentity.*;
import optifine.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.client.model.*;

public class ModelAdapterHeadSkeleton extends ModelAdapter
{
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIllIIIlIIlIlIIIIlIl, final float lllllllllllllIllIIIlIIlIlIIIlIII) {
        final TileEntityRendererDispatcher lllllllllllllIllIIIlIIlIlIIIIlll = TileEntityRendererDispatcher.instance;
        TileEntitySpecialRenderer lllllllllllllIllIIIlIIlIlIIIIllI = lllllllllllllIllIIIlIIlIlIIIIlll.getSpecialRendererByClass(TileEntitySkull.class);
        if (!(lllllllllllllIllIIIlIIlIlIIIIllI instanceof TileEntitySkullRenderer)) {
            return null;
        }
        if (lllllllllllllIllIIIlIIlIlIIIIllI.getEntityClass() == null) {
            lllllllllllllIllIIIlIIlIlIIIIllI = new TileEntitySkullRenderer();
            lllllllllllllIllIIIlIIlIlIIIIllI.setRendererDispatcher(lllllllllllllIllIIIlIIlIlIIIIlll);
        }
        if (!Reflector.TileEntitySkullRenderer_humanoidHead.exists()) {
            Config.warn("Field not found: TileEntitySkullRenderer.humanoidHead");
            return null;
        }
        Reflector.setFieldValue(lllllllllllllIllIIIlIIlIlIIIIllI, Reflector.TileEntitySkullRenderer_humanoidHead, lllllllllllllIllIIIlIIlIlIIIIlIl);
        return lllllllllllllIllIIIlIIlIlIIIIllI;
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelSkeletonHead(0, 0, 64, 32);
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllIllIIIlIIlIlIIlIIII, final String lllllllllllllIllIIIlIIlIlIIIllll) {
        if (!(lllllllllllllIllIIIlIIlIlIIlIIII instanceof ModelSkeletonHead)) {
            return null;
        }
        final ModelSkeletonHead lllllllllllllIllIIIlIIlIlIIlIIIl = (ModelSkeletonHead)lllllllllllllIllIIIlIIlIlIIlIIII;
        return lllllllllllllIllIIIlIIlIlIIIllll.equals("head") ? lllllllllllllIllIIIlIIlIlIIlIIIl.skeletonHead : null;
    }
    
    public ModelAdapterHeadSkeleton() {
        super(TileEntitySkull.class, "head_skeleton", 0.0f);
    }
}
