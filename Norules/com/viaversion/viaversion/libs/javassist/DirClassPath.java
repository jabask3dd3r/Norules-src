package com.viaversion.viaversion.libs.javassist;

import java.net.*;
import java.io.*;

final class DirClassPath implements ClassPath
{
    /* synthetic */ String directory;
    
    DirClassPath(final String llllllllllllllllllIlllllllllIllI) {
        this.directory = llllllllllllllllllIlllllllllIllI;
    }
    
    @Override
    public URL find(final String llllllllllllllllllIllllllllIIIII) {
        final char llllllllllllllllllIlllllllIlllll = File.separatorChar;
        final String llllllllllllllllllIlllllllIllllI = String.valueOf(new StringBuilder().append(this.directory).append(llllllllllllllllllIlllllllIlllll).append(llllllllllllllllllIllllllllIIIII.replace('.', llllllllllllllllllIlllllllIlllll)).append(".class"));
        final File llllllllllllllllllIlllllllIlllIl = new File(llllllllllllllllllIlllllllIllllI);
        if (llllllllllllllllllIlllllllIlllIl.exists()) {
            try {
                return llllllllllllllllllIlllllllIlllIl.getCanonicalFile().toURI().toURL();
            }
            catch (MalformedURLException llllllllllllllllllIlllllllIlIlll) {}
            catch (IOException ex) {}
        }
        return null;
    }
    
    @Override
    public InputStream openClassfile(final String llllllllllllllllllIllllllllIllII) {
        try {
            final char llllllllllllllllllIllllllllIllll = File.separatorChar;
            final String llllllllllllllllllIllllllllIlllI = String.valueOf(new StringBuilder().append(this.directory).append(llllllllllllllllllIllllllllIllll).append(llllllllllllllllllIllllllllIllII.replace('.', llllllllllllllllllIllllllllIllll)).append(".class"));
            return new FileInputStream(llllllllllllllllllIllllllllIlllI.toString());
        }
        catch (FileNotFoundException llllllllllllllllllIllllllllIlIIl) {}
        catch (SecurityException ex) {}
        return null;
    }
    
    @Override
    public String toString() {
        return this.directory;
    }
}
