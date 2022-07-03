package shadersmod.client;

import net.minecraft.client.renderer.texture.*;

public class CustomTexture implements ICustomTexture
{
    private /* synthetic */ int textureUnit;
    private /* synthetic */ ITextureObject texture;
    private /* synthetic */ String path;
    
    @Override
    public int getTextureUnit() {
        return this.textureUnit;
    }
    
    public CustomTexture(final int llllllllllllllllIIIlIlllllIIlIlI, final String llllllllllllllllIIIlIlllllIIlIIl, final ITextureObject llllllllllllllllIIIlIlllllIIllII) {
        this.textureUnit = -1;
        this.path = null;
        this.texture = null;
        this.textureUnit = llllllllllllllllIIIlIlllllIIlIlI;
        this.path = llllllllllllllllIIIlIlllllIIlIIl;
        this.texture = llllllllllllllllIIIlIlllllIIllII;
    }
    
    @Override
    public int getTextureId() {
        return this.texture.getGlTextureId();
    }
    
    public String getPath() {
        return this.path;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("textureUnit: ").append(this.textureUnit).append(", path: ").append(this.path).append(", glTextureId: ").append(this.texture.getGlTextureId()));
    }
    
    public ITextureObject getTexture() {
        return this.texture;
    }
    
    @Override
    public void deleteTexture() {
        TextureUtil.deleteTexture(this.texture.getGlTextureId());
    }
}
