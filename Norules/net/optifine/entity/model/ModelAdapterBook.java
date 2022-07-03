package net.optifine.entity.model;

import net.minecraft.tileentity.*;
import optifine.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.client.model.*;

public class ModelAdapterBook extends ModelAdapter
{
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIIIlIIlIIIIIIIIIlII, final float lllllllllllllIIIlIIlIIIIIIIIIIll) {
        final TileEntityRendererDispatcher lllllllllllllIIIlIIlIIIIIIIIIIlI = TileEntityRendererDispatcher.instance;
        TileEntitySpecialRenderer lllllllllllllIIIlIIlIIIIIIIIIIIl = lllllllllllllIIIlIIlIIIIIIIIIIlI.getSpecialRendererByClass(TileEntityEnchantmentTable.class);
        if (!(lllllllllllllIIIlIIlIIIIIIIIIIIl instanceof TileEntityEnchantmentTableRenderer)) {
            return null;
        }
        if (lllllllllllllIIIlIIlIIIIIIIIIIIl.getEntityClass() == null) {
            lllllllllllllIIIlIIlIIIIIIIIIIIl = new TileEntityEnchantmentTableRenderer();
            lllllllllllllIIIlIIlIIIIIIIIIIIl.setRendererDispatcher(lllllllllllllIIIlIIlIIIIIIIIIIlI);
        }
        if (!Reflector.TileEntityEnchantmentTableRenderer_modelBook.exists()) {
            Config.warn("Field not found: TileEntityEnchantmentTableRenderer.modelBook");
            return null;
        }
        Reflector.setFieldValue(lllllllllllllIIIlIIlIIIIIIIIIIIl, Reflector.TileEntityEnchantmentTableRenderer_modelBook, lllllllllllllIIIlIIlIIIIIIIIIlII);
        return lllllllllllllIIIlIIlIIIIIIIIIIIl;
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllIIIlIIlIIIIIIIIlIll, final String lllllllllllllIIIlIIlIIIIIIIIllIl) {
        if (!(lllllllllllllIIIlIIlIIIIIIIIlIll instanceof ModelBook)) {
            return null;
        }
        final ModelBook lllllllllllllIIIlIIlIIIIIIIIllII = (ModelBook)lllllllllllllIIIlIIlIIIIIIIIlIll;
        if (lllllllllllllIIIlIIlIIIIIIIIllIl.equals("cover_right")) {
            return lllllllllllllIIIlIIlIIIIIIIIllII.coverRight;
        }
        if (lllllllllllllIIIlIIlIIIIIIIIllIl.equals("cover_left")) {
            return lllllllllllllIIIlIIlIIIIIIIIllII.coverLeft;
        }
        if (lllllllllllllIIIlIIlIIIIIIIIllIl.equals("pages_right")) {
            return lllllllllllllIIIlIIlIIIIIIIIllII.pagesRight;
        }
        if (lllllllllllllIIIlIIlIIIIIIIIllIl.equals("pages_left")) {
            return lllllllllllllIIIlIIlIIIIIIIIllII.pagesLeft;
        }
        if (lllllllllllllIIIlIIlIIIIIIIIllIl.equals("flipping_page_right")) {
            return lllllllllllllIIIlIIlIIIIIIIIllII.flippingPageRight;
        }
        if (lllllllllllllIIIlIIlIIIIIIIIllIl.equals("flipping_page_left")) {
            return lllllllllllllIIIlIIlIIIIIIIIllII.flippingPageLeft;
        }
        return lllllllllllllIIIlIIlIIIIIIIIllIl.equals("book_spine") ? lllllllllllllIIIlIIlIIIIIIIIllII.bookSpine : null;
    }
    
    public ModelAdapterBook() {
        super(TileEntityEnchantmentTable.class, "book", 0.0f);
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelBook();
    }
}
