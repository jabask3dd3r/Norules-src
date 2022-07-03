package optifine;

public class ReflectorClass
{
    private /* synthetic */ boolean checked;
    private /* synthetic */ Class targetClass;
    private /* synthetic */ String targetClassName;
    
    public boolean isInstance(final Object lllllllllllllllIIIlllIIlllllIlII) {
        return this.getTargetClass() != null && this.getTargetClass().isInstance(lllllllllllllllIIIlllIIlllllIlII);
    }
    
    public ReflectorMethod makeMethod(final String lllllllllllllllIIIlllIIllllIlIII) {
        return new ReflectorMethod(this, lllllllllllllllIIIlllIIllllIlIII);
    }
    
    public ReflectorMethod makeMethod(final String lllllllllllllllIIIlllIIlllIlIlIl, final Class[] lllllllllllllllIIIlllIIlllIlIlII, final boolean lllllllllllllllIIIlllIIlllIlIIll) {
        return new ReflectorMethod(this, lllllllllllllllIIIlllIIlllIlIlIl, lllllllllllllllIIIlllIIlllIlIlII, lllllllllllllllIIIlllIIlllIlIIll);
    }
    
    public ReflectorClass(final String lllllllllllllllIIIlllIlIIIIllIII, final boolean lllllllllllllllIIIlllIlIIIIllIlI) {
        this.targetClassName = null;
        this.checked = false;
        this.targetClass = null;
        this.targetClassName = lllllllllllllllIIIlllIlIIIIllIII;
        if (!lllllllllllllllIIIlllIlIIIIllIlI) {
            final float lllllllllllllllIIIlllIlIIIIlIllI = (float)this.getTargetClass();
        }
    }
    
    public ReflectorMethod makeMethod(final String lllllllllllllllIIIlllIIllllIIIII, final Class[] lllllllllllllllIIIlllIIllllIIIlI) {
        return new ReflectorMethod(this, lllllllllllllllIIIlllIIllllIIIII, lllllllllllllllIIIlllIIllllIIIlI);
    }
    
    public ReflectorClass(final Class lllllllllllllllIIIlllIlIIIIlIIII) {
        this.targetClassName = null;
        this.checked = false;
        this.targetClass = null;
        this.targetClass = lllllllllllllllIIIlllIlIIIIlIIII;
        this.targetClassName = lllllllllllllllIIIlllIlIIIIlIIII.getName();
        this.checked = true;
    }
    
    public boolean exists() {
        return this.getTargetClass() != null;
    }
    
    public ReflectorField makeField(final String lllllllllllllllIIIlllIIllllIlllI) {
        return new ReflectorField(this, lllllllllllllllIIIlllIIllllIlllI);
    }
    
    public String getTargetClassName() {
        return this.targetClassName;
    }
    
    public Class getTargetClass() {
        if (this.checked) {
            return this.targetClass;
        }
        this.checked = true;
        try {
            this.targetClass = Class.forName(this.targetClassName);
        }
        catch (ClassNotFoundException lllllllllllllllIIIlllIlIIIIIIllI) {
            Config.log(String.valueOf(new StringBuilder("(Reflector) Class not present: ").append(this.targetClassName)));
        }
        catch (Throwable lllllllllllllllIIIlllIlIIIIIIlIl) {
            lllllllllllllllIIIlllIlIIIIIIlIl.printStackTrace();
        }
        return this.targetClass;
    }
    
    public ReflectorClass(final String lllllllllllllllIIIlllIlIIIlIIIll) {
        this(lllllllllllllllIIIlllIlIIIlIIIll, false);
    }
}
