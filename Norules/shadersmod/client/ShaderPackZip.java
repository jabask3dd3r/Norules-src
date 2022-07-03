package shadersmod.client;

import optifine.*;
import java.util.zip.*;
import java.io.*;

public class ShaderPackZip implements IShaderPack
{
    protected /* synthetic */ File packFile;
    protected /* synthetic */ ZipFile packZipFile;
    
    @Override
    public boolean hasDirectory(final String lllllllllllllIIlIllIIIIlIlIIllIl) {
        try {
            if (this.packZipFile == null) {
                this.packZipFile = new ZipFile(this.packFile);
            }
            final String lllllllllllllIIlIllIIIIlIlIlIIIl = StrUtils.removePrefix(lllllllllllllIIlIllIIIIlIlIIllIl, "/");
            final ZipEntry lllllllllllllIIlIllIIIIlIlIlIIII = this.packZipFile.getEntry(lllllllllllllIIlIllIIIIlIlIlIIIl);
            return lllllllllllllIIlIllIIIIlIlIlIIII != null;
        }
        catch (IOException lllllllllllllIIlIllIIIIlIlIIllll) {
            return false;
        }
    }
    
    @Override
    public InputStream getResourceAsStream(final String lllllllllllllIIlIllIIIIlIlIllIlI) {
        try {
            if (this.packZipFile == null) {
                this.packZipFile = new ZipFile(this.packFile);
            }
            final String lllllllllllllIIlIllIIIIlIlIllllI = StrUtils.removePrefix(lllllllllllllIIlIllIIIIlIlIllIlI, "/");
            final ZipEntry lllllllllllllIIlIllIIIIlIlIlllIl = this.packZipFile.getEntry(lllllllllllllIIlIllIIIIlIlIllllI);
            return (lllllllllllllIIlIllIIIIlIlIlllIl == null) ? null : this.packZipFile.getInputStream(lllllllllllllIIlIllIIIIlIlIlllIl);
        }
        catch (Exception lllllllllllllIIlIllIIIIlIlIlllII) {
            return null;
        }
    }
    
    @Override
    public void close() {
        if (this.packZipFile != null) {
            try {
                this.packZipFile.close();
            }
            catch (Exception ex) {}
            this.packZipFile = null;
        }
    }
    
    public ShaderPackZip(final String lllllllllllllIIlIllIIIIlIllIllIl, final File lllllllllllllIIlIllIIIIlIllIllII) {
        this.packFile = lllllllllllllIIlIllIIIIlIllIllII;
        this.packZipFile = null;
    }
    
    @Override
    public String getName() {
        return this.packFile.getName();
    }
}
