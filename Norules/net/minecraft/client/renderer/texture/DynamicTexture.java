package net.minecraft.client.renderer.texture;

import net.minecraft.client.resources.*;
import java.io.*;
import optifine.*;
import shadersmod.client.*;
import java.awt.image.*;

public class DynamicTexture extends AbstractTexture
{
    private final /* synthetic */ int[] dynamicTextureData;
    private final /* synthetic */ int width;
    private final /* synthetic */ int height;
    private /* synthetic */ boolean shadersInitialized;
    
    public int[] getTextureData() {
        return this.dynamicTextureData;
    }
    
    @Override
    public void loadTexture(final IResourceManager lllllllllllllllIIIlIlIlllIIllIll) throws IOException {
    }
    
    public DynamicTexture(final int lllllllllllllllIIIlIlIlllIIllllI, final int lllllllllllllllIIIlIlIlllIlIIIII) {
        this.shadersInitialized = false;
        this.width = lllllllllllllllIIIlIlIlllIIllllI;
        this.height = lllllllllllllllIIIlIlIlllIlIIIII;
        this.dynamicTextureData = new int[lllllllllllllllIIIlIlIlllIIllllI * lllllllllllllllIIIlIlIlllIlIIIII * 3];
        if (Config.isShaders()) {
            ShadersTex.initDynamicTexture(this.getGlTextureId(), lllllllllllllllIIIlIlIlllIIllllI, lllllllllllllllIIIlIlIlllIlIIIII, this);
            this.shadersInitialized = true;
        }
        else {
            TextureUtil.allocateTexture(this.getGlTextureId(), lllllllllllllllIIIlIlIlllIIllllI, lllllllllllllllIIIlIlIlllIlIIIII);
        }
    }
    
    public DynamicTexture(final BufferedImage lllllllllllllllIIIlIlIlllIlIlIII) {
        this(lllllllllllllllIIIlIlIlllIlIlIII.getWidth(), lllllllllllllllIIIlIlIlllIlIlIII.getHeight());
        lllllllllllllllIIIlIlIlllIlIlIII.getRGB(0, 0, lllllllllllllllIIIlIlIlllIlIlIII.getWidth(), lllllllllllllllIIIlIlIlllIlIlIII.getHeight(), this.dynamicTextureData, 0, lllllllllllllllIIIlIlIlllIlIlIII.getWidth());
        this.updateDynamicTexture();
    }
    
    public void updateDynamicTexture() {
        if (Config.isShaders()) {
            if (!this.shadersInitialized) {
                ShadersTex.initDynamicTexture(this.getGlTextureId(), this.width, this.height, this);
                this.shadersInitialized = true;
            }
            ShadersTex.updateDynamicTexture(this.getGlTextureId(), this.dynamicTextureData, this.width, this.height, this);
        }
        else {
            TextureUtil.uploadTexture(this.getGlTextureId(), this.dynamicTextureData, this.width, this.height);
        }
    }
}
