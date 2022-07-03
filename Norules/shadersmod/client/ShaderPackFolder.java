package shadersmod.client;

import optifine.*;
import java.io.*;

public class ShaderPackFolder implements IShaderPack
{
    protected /* synthetic */ File packFile;
    
    @Override
    public InputStream getResourceAsStream(final String lllllllllllllIlllllllIIIIIllIlIl) {
        try {
            final String lllllllllllllIlllllllIIIIIllIlII = StrUtils.removePrefixSuffix(lllllllllllllIlllllllIIIIIllIlIl, "/", "/");
            final File lllllllllllllIlllllllIIIIIllIIll = new File(this.packFile, lllllllllllllIlllllllIIIIIllIlII);
            InputStream inputStream;
            if (!lllllllllllllIlllllllIIIIIllIIll.exists()) {
                inputStream = null;
            }
            else {
                final FileInputStream fileInputStream;
                inputStream = new BufferedInputStream(fileInputStream);
                fileInputStream = new FileInputStream(lllllllllllllIlllllllIIIIIllIIll);
            }
            return inputStream;
        }
        catch (Exception lllllllllllllIlllllllIIIIIllIIlI) {
            return null;
        }
    }
    
    @Override
    public void close() {
    }
    
    public ShaderPackFolder(final String lllllllllllllIlllllllIIIIIllllll, final File lllllllllllllIlllllllIIIIIllllII) {
        this.packFile = lllllllllllllIlllllllIIIIIllllII;
    }
    
    @Override
    public String getName() {
        return this.packFile.getName();
    }
    
    @Override
    public boolean hasDirectory(final String lllllllllllllIlllllllIIIIIlIIllI) {
        final File lllllllllllllIlllllllIIIIIlIlIII = new File(this.packFile, lllllllllllllIlllllllIIIIIlIIllI.substring(1));
        return lllllllllllllIlllllllIIIIIlIlIII.exists() && lllllllllllllIlllllllIIIIIlIlIII.isDirectory();
    }
}
