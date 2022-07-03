package shadersmod.client;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.resources.*;

public class DefaultTexture extends AbstractTexture
{
    @Override
    public void loadTexture(final IResourceManager lllllllllllllIIlIlIIlIIllllIllII) {
        final int[] lllllllllllllIIlIlIIlIIllllIlIll = ShadersTex.createAIntImage(1, -1);
        ShadersTex.setupTexture(this.getMultiTexID(), lllllllllllllIIlIlIIlIIllllIlIll, 1, 1, false, false);
    }
    
    public DefaultTexture() {
        this.loadTexture(null);
    }
}
