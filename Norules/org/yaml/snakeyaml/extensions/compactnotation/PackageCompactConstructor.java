package org.yaml.snakeyaml.extensions.compactnotation;

public class PackageCompactConstructor extends CompactConstructor
{
    private /* synthetic */ String packageName;
    
    @Override
    protected Class<?> getClassForName(final String lllllllllllllIIIIIlIlIIlIIllIllI) throws ClassNotFoundException {
        if (lllllllllllllIIIIIlIlIIlIIllIllI.indexOf(46) < 0) {
            try {
                final Class<?> lllllllllllllIIIIIlIlIIlIIlllIll = Class.forName(String.valueOf(new StringBuilder().append(this.packageName).append(".").append(lllllllllllllIIIIIlIlIIlIIllIllI)));
                return lllllllllllllIIIIIlIlIIlIIlllIll;
            }
            catch (ClassNotFoundException ex) {}
        }
        return super.getClassForName(lllllllllllllIIIIIlIlIIlIIllIllI);
    }
    
    public PackageCompactConstructor(final String lllllllllllllIIIIIlIlIIlIIllllll) {
        this.packageName = lllllllllllllIIIIIlIlIIlIIllllll;
    }
}
