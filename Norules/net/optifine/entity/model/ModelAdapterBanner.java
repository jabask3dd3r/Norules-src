package net.optifine.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.tileentity.*;
import optifine.*;
import net.minecraft.client.renderer.tileentity.*;

public class ModelAdapterBanner extends ModelAdapter
{
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllIllIIlIlIlIIIlIIlIl, final String lllllllllllllIllIIlIlIlIIIlIIlII) {
        if (!(lllllllllllllIllIIlIlIlIIIlIIlIl instanceof ModelBanner)) {
            return null;
        }
        final ModelBanner lllllllllllllIllIIlIlIlIIIlIIllI = (ModelBanner)lllllllllllllIllIIlIlIlIIIlIIlIl;
        if (lllllllllllllIllIIlIlIlIIIlIIlII.equals("slate")) {
            return lllllllllllllIllIIlIlIlIIIlIIllI.bannerSlate;
        }
        if (lllllllllllllIllIIlIlIlIIIlIIlII.equals("stand")) {
            return lllllllllllllIllIIlIlIlIIIlIIllI.bannerStand;
        }
        return lllllllllllllIllIIlIlIlIIIlIIlII.equals("top") ? lllllllllllllIllIIlIlIlIIIlIIllI.bannerTop : null;
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIllIIlIlIlIIIIllllI, final float lllllllllllllIllIIlIlIlIIIIlllIl) {
        final TileEntityRendererDispatcher lllllllllllllIllIIlIlIlIIIIlllII = TileEntityRendererDispatcher.instance;
        TileEntitySpecialRenderer lllllllllllllIllIIlIlIlIIIIllIll = lllllllllllllIllIIlIlIlIIIIlllII.getSpecialRendererByClass(TileEntityBanner.class);
        if (!(lllllllllllllIllIIlIlIlIIIIllIll instanceof TileEntityBannerRenderer)) {
            return null;
        }
        if (lllllllllllllIllIIlIlIlIIIIllIll.getEntityClass() == null) {
            lllllllllllllIllIIlIlIlIIIIllIll = new TileEntityBannerRenderer();
            lllllllllllllIllIIlIlIlIIIIllIll.setRendererDispatcher(lllllllllllllIllIIlIlIlIIIIlllII);
        }
        if (!Reflector.TileEntityBannerRenderer_bannerModel.exists()) {
            Config.warn("Field not found: TileEntityBannerRenderer.bannerModel");
            return null;
        }
        Reflector.setFieldValue(lllllllllllllIllIIlIlIlIIIIllIll, Reflector.TileEntityBannerRenderer_bannerModel, lllllllllllllIllIIlIlIlIIIIllllI);
        return lllllllllllllIllIIlIlIlIIIIllIll;
    }
    
    public ModelAdapterBanner() {
        super(TileEntityBanner.class, "banner", 0.0f);
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelBanner();
    }
}
