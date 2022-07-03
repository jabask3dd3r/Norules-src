package org.yaml.snakeyaml.constructor;

public class CustomClassLoaderConstructor extends Constructor
{
    private /* synthetic */ ClassLoader loader;
    
    public CustomClassLoaderConstructor(final Class<?> llllllllllllllIIlIIllllIlIlIlllI, final ClassLoader llllllllllllllIIlIIllllIlIlIllIl) {
        super(llllllllllllllIIlIIllllIlIlIlllI);
        this.loader = CustomClassLoaderConstructor.class.getClassLoader();
        if (llllllllllllllIIlIIllllIlIlIllIl == null) {
            throw new NullPointerException("Loader must be provided.");
        }
        this.loader = llllllllllllllIIlIIllllIlIlIllIl;
    }
    
    @Override
    protected Class<?> getClassForName(final String llllllllllllllIIlIIllllIlIlIIlII) throws ClassNotFoundException {
        return Class.forName(llllllllllllllIIlIIllllIlIlIIlII, true, this.loader);
    }
    
    public CustomClassLoaderConstructor(final ClassLoader llllllllllllllIIlIIllllIlIllIIll) {
        this(Object.class, llllllllllllllIIlIIllllIlIllIIll);
    }
}
