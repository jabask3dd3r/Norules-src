package shadersmod.client;

import java.io.*;

public class ShaderPackNone implements IShaderPack
{
    @Override
    public InputStream getResourceAsStream(final String lllllllllllllIllIlIlIIlIIllIllll) {
        return null;
    }
    
    @Override
    public String getName() {
        return Shaders.packNameNone;
    }
    
    @Override
    public void close() {
    }
    
    @Override
    public boolean hasDirectory(final String lllllllllllllIllIlIlIIlIIllIllIl) {
        return false;
    }
}
