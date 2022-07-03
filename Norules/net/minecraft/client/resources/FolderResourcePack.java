package net.minecraft.client.resources;

import com.google.common.base.*;
import com.google.common.collect.*;
import org.apache.commons.io.filefilter.*;
import java.util.*;
import javax.annotation.*;
import net.minecraft.util.*;
import java.io.*;

public class FolderResourcePack extends AbstractResourcePack
{
    private static final /* synthetic */ boolean field_191386_b;
    private static final /* synthetic */ CharMatcher field_191387_c;
    
    public FolderResourcePack(final File lllllllllllllIllllIllIlIIlIlIlIl) {
        super(lllllllllllllIllllIllIlIIlIlIlIl);
    }
    
    @Override
    public Set<String> getResourceDomains() {
        final Set<String> lllllllllllllIllllIllIlIIIlIlIlI = (Set<String>)Sets.newHashSet();
        final File lllllllllllllIllllIllIlIIIlIlIIl = new File(this.resourcePackFile, "assets/");
        if (lllllllllllllIllllIllIlIIIlIlIIl.isDirectory()) {
            final boolean lllllllllllllIllllIllIlIIIlIIIII;
            final Exception lllllllllllllIllllIllIlIIIlIIIIl = (Exception)((File[])(Object)(lllllllllllllIllllIllIlIIIlIIIII = (boolean)(Object)lllllllllllllIllllIllIlIIIlIlIIl.listFiles((FileFilter)DirectoryFileFilter.DIRECTORY))).length;
            for (boolean lllllllllllllIllllIllIlIIIlIIIlI = false; lllllllllllllIllllIllIlIIIlIIIlI < lllllllllllllIllllIllIlIIIlIIIIl; ++lllllllllllllIllllIllIlIIIlIIIlI) {
                final File lllllllllllllIllllIllIlIIIlIlIII = lllllllllllllIllllIllIlIIIlIIIII[lllllllllllllIllllIllIlIIIlIIIlI];
                final String lllllllllllllIllllIllIlIIIlIIlll = AbstractResourcePack.getRelativeName(lllllllllllllIllllIllIlIIIlIlIIl, lllllllllllllIllllIllIlIIIlIlIII);
                if (lllllllllllllIllllIllIlIIIlIIlll.equals(lllllllllllllIllllIllIlIIIlIIlll.toLowerCase(Locale.ROOT))) {
                    lllllllllllllIllllIllIlIIIlIlIlI.add(lllllllllllllIllllIllIlIIIlIIlll.substring(0, lllllllllllllIllllIllIlIIIlIIlll.length() - 1));
                }
                else {
                    this.logNameNotLowercase(lllllllllllllIllllIllIlIIIlIIlll);
                }
            }
        }
        return lllllllllllllIllllIllIlIIIlIlIlI;
    }
    
    @Nullable
    private File func_191385_d(final String lllllllllllllIllllIllIlIIIlllIII) {
        try {
            final File lllllllllllllIllllIllIlIIIllIlll = new File(this.resourcePackFile, lllllllllllllIllllIllIlIIIlllIII);
            if (lllllllllllllIllllIllIlIIIllIlll.isFile() && func_191384_a(lllllllllllllIllllIllIlIIIllIlll, lllllllllllllIllllIllIlIIIlllIII)) {
                return lllllllllllllIllllIllIlIIIllIlll;
            }
        }
        catch (IOException ex) {}
        return null;
    }
    
    static {
        field_191386_b = (Util.getOSType() == Util.EnumOS.WINDOWS);
        field_191387_c = CharMatcher.is('\\');
    }
    
    @Override
    protected InputStream getInputStreamByName(final String lllllllllllllIllllIllIlIIlIIIlll) throws IOException {
        final File lllllllllllllIllllIllIlIIlIIIllI = this.func_191385_d(lllllllllllllIllllIllIlIIlIIIlll);
        if (lllllllllllllIllllIllIlIIlIIIllI == null) {
            throw new ResourcePackFileNotFoundException(this.resourcePackFile, lllllllllllllIllllIllIlIIlIIIlll);
        }
        return new BufferedInputStream(new FileInputStream(lllllllllllllIllllIllIlIIlIIIllI));
    }
    
    protected static boolean func_191384_a(final File lllllllllllllIllllIllIlIIlIlIIIl, final String lllllllllllllIllllIllIlIIlIIllIl) throws IOException {
        String lllllllllllllIllllIllIlIIlIIllll = lllllllllllllIllllIllIlIIlIlIIIl.getCanonicalPath();
        if (FolderResourcePack.field_191386_b) {
            lllllllllllllIllllIllIlIIlIIllll = FolderResourcePack.field_191387_c.replaceFrom((CharSequence)lllllllllllllIllllIllIlIIlIIllll, '/');
        }
        return lllllllllllllIllllIllIlIIlIIllll.endsWith(lllllllllllllIllllIllIlIIlIIllIl);
    }
    
    @Override
    protected boolean hasResourceName(final String lllllllllllllIllllIllIlIIIllllIl) {
        return this.func_191385_d(lllllllllllllIllllIllIlIIIllllIl) != null;
    }
}
