package com.viaversion.viaversion.libs.javassist;

import java.util.*;
import java.util.jar.*;
import java.io.*;
import java.net.*;

final class JarClassPath implements ClassPath
{
    /* synthetic */ String jarfileURL;
    /* synthetic */ Set<String> jarfileEntries;
    
    @Override
    public String toString() {
        return (this.jarfileURL == null) ? "<null>" : this.jarfileURL.toString();
    }
    
    @Override
    public URL find(final String llllllllllllllllIlllIIIlIIIIlIll) {
        final String llllllllllllllllIlllIIIlIIIIlIlI = String.valueOf(new StringBuilder().append(llllllllllllllllIlllIIIlIIIIlIll.replace('.', '/')).append(".class"));
        if (this.jarfileEntries.contains(llllllllllllllllIlllIIIlIIIIlIlI)) {
            try {
                return new URL(String.format("jar:%s!/%s", this.jarfileURL, llllllllllllllllIlllIIIlIIIIlIlI));
            }
            catch (MalformedURLException ex) {}
        }
        return null;
    }
    
    JarClassPath(final String llllllllllllllllIlllIIIlIIllIllI) throws NotFoundException {
        JarFile llllllllllllllllIlllIIIlIIlllIlI = null;
        try {
            llllllllllllllllIlllIIIlIIlllIlI = new JarFile(llllllllllllllllIlllIIIlIIllIllI);
            this.jarfileEntries = new HashSet<String>();
            for (final JarEntry llllllllllllllllIlllIIIlIlIIIIII : Collections.list(llllllllllllllllIlllIIIlIIlllIlI.entries())) {
                if (llllllllllllllllIlllIIIlIlIIIIII.getName().endsWith(".class")) {
                    this.jarfileEntries.add(llllllllllllllllIlllIIIlIlIIIIII.getName());
                }
            }
            this.jarfileURL = new File(llllllllllllllllIlllIIIlIIllIllI).getCanonicalFile().toURI().toURL().toString();
            return;
        }
        catch (IOException llllllllllllllllIlllIIIlIIllIlII) {}
        finally {
            if (null != llllllllllllllllIlllIIIlIIlllIlI) {
                try {
                    llllllllllllllllIlllIIIlIIlllIlI.close();
                }
                catch (IOException ex) {}
            }
        }
        throw new NotFoundException(llllllllllllllllIlllIIIlIIllIllI);
    }
    
    @Override
    public InputStream openClassfile(final String llllllllllllllllIlllIIIlIIlIIIlI) throws NotFoundException {
        final URL llllllllllllllllIlllIIIlIIlIIIIl = this.find(llllllllllllllllIlllIIIlIIlIIIlI);
        if (null != llllllllllllllllIlllIIIlIIlIIIIl) {
            try {
                if (ClassPool.cacheOpenedJarFile) {
                    return llllllllllllllllIlllIIIlIIlIIIIl.openConnection().getInputStream();
                }
                final URLConnection llllllllllllllllIlllIIIlIIlIlIII = llllllllllllllllIlllIIIlIIlIIIIl.openConnection();
                llllllllllllllllIlllIIIlIIlIlIII.setUseCaches(false);
                return llllllllllllllllIlllIIIlIIlIlIII.getInputStream();
            }
            catch (IOException llllllllllllllllIlllIIIlIIlIIllI) {
                throw new NotFoundException(String.valueOf(new StringBuilder().append("broken jar file?: ").append(llllllllllllllllIlllIIIlIIlIIIlI)));
            }
        }
        return null;
    }
}
