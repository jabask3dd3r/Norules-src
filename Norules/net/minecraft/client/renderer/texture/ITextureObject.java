package net.minecraft.client.renderer.texture;

import shadersmod.client.*;
import net.minecraft.client.resources.*;
import java.io.*;

public interface ITextureObject
{
    MultiTexID getMultiTexID();
    
    void loadTexture(final IResourceManager p0) throws IOException;
    
    int getGlTextureId();
    
    void restoreLastBlurMipmap();
    
    void setBlurMipmap(final boolean p0, final boolean p1);
}
