package shadersmod.client;

import java.io.*;

public interface IShaderPack
{
    String getName();
    
    void close();
    
    boolean hasDirectory(final String p0);
    
    InputStream getResourceAsStream(final String p0);
}
