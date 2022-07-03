package shadersmod.client;

import java.io.*;

public class ShaderPackDefault implements IShaderPack
{
    @Override
    public InputStream getResourceAsStream(final String lllllllllllllIIllIIllIllIlIllllI) {
        return ShaderPackDefault.class.getResourceAsStream(lllllllllllllIIllIIllIllIlIllllI);
    }
    
    @Override
    public void close() {
    }
    
    @Override
    public String getName() {
        return Shaders.packNameDefault;
    }
    
    @Override
    public boolean hasDirectory(final String lllllllllllllIIllIIllIllIlIllIll) {
        return false;
    }
}
