package optifine;

import net.minecraft.client.model.*;

public class PlayerItemRenderer
{
    private /* synthetic */ int attachTo;
    private /* synthetic */ ModelRenderer modelRenderer;
    
    public ModelRenderer getModelRenderer() {
        return this.modelRenderer;
    }
    
    public PlayerItemRenderer(final int llllllllllllllIlllllIllIIIlllllI, final ModelRenderer llllllllllllllIlllllIllIIIlllIlI) {
        this.attachTo = 0;
        this.modelRenderer = null;
        this.attachTo = llllllllllllllIlllllIllIIIlllllI;
        this.modelRenderer = llllllllllllllIlllllIllIIIlllIlI;
    }
    
    public void render(final ModelBiped llllllllllllllIlllllIllIIIlIllIl, final float llllllllllllllIlllllIllIIIlIllII) {
        final ModelRenderer llllllllllllllIlllllIllIIIlIllll = PlayerItemModel.getAttachModel(llllllllllllllIlllllIllIIIlIllIl, this.attachTo);
        if (llllllllllllllIlllllIllIIIlIllll != null) {
            llllllllllllllIlllllIllIIIlIllll.postRender(llllllllllllllIlllllIllIIIlIllII);
        }
        this.modelRenderer.render(llllllllllllllIlllllIllIIIlIllII);
    }
}
