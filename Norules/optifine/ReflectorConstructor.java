package optifine;

import java.lang.reflect.*;

public class ReflectorConstructor
{
    private /* synthetic */ Class[] parameterTypes;
    private /* synthetic */ ReflectorClass reflectorClass;
    private /* synthetic */ Constructor targetConstructor;
    private /* synthetic */ boolean checked;
    
    public boolean exists() {
        if (this.checked) {
            return this.targetConstructor != null;
        }
        return this.getTargetConstructor() != null;
    }
    
    public ReflectorConstructor(final ReflectorClass llllllllllllllIIIllllIlIlIlIlllI, final Class[] llllllllllllllIIIllllIlIlIllIIIl) {
        this.reflectorClass = null;
        this.parameterTypes = null;
        this.checked = false;
        this.targetConstructor = null;
        this.reflectorClass = llllllllllllllIIIllllIlIlIlIlllI;
        this.parameterTypes = llllllllllllllIIIllllIlIlIllIIIl;
        final Constructor llllllllllllllIIIllllIlIlIllIIII = this.getTargetConstructor();
    }
    
    public void deactivate() {
        this.checked = true;
        this.targetConstructor = null;
    }
    
    private static Constructor findConstructor(final Class llllllllllllllIIIllllIlIlIIlIllI, final Class[] llllllllllllllIIIllllIlIlIIllIll) {
        final Constructor[] llllllllllllllIIIllllIlIlIIllIlI = llllllllllllllIIIllllIlIlIIlIllI.getDeclaredConstructors();
        for (int llllllllllllllIIIllllIlIlIIllIIl = 0; llllllllllllllIIIllllIlIlIIllIIl < llllllllllllllIIIllllIlIlIIllIlI.length; ++llllllllllllllIIIllllIlIlIIllIIl) {
            final Constructor llllllllllllllIIIllllIlIlIIllIII = llllllllllllllIIIllllIlIlIIllIlI[llllllllllllllIIIllllIlIlIIllIIl];
            final Class[] llllllllllllllIIIllllIlIlIIlIlll = llllllllllllllIIIllllIlIlIIllIII.getParameterTypes();
            if (Reflector.matchesTypes(llllllllllllllIIIllllIlIlIIllIll, llllllllllllllIIIllllIlIlIIlIlll)) {
                return llllllllllllllIIIllllIlIlIIllIII;
            }
        }
        return null;
    }
    
    public Constructor getTargetConstructor() {
        if (this.checked) {
            return this.targetConstructor;
        }
        this.checked = true;
        final Class llllllllllllllIIIllllIlIlIlIIlll = this.reflectorClass.getTargetClass();
        if (llllllllllllllIIIllllIlIlIlIIlll == null) {
            return null;
        }
        try {
            this.targetConstructor = findConstructor(llllllllllllllIIIllllIlIlIlIIlll, this.parameterTypes);
            if (this.targetConstructor == null) {
                Config.dbg(String.valueOf(new StringBuilder("(Reflector) Constructor not present: ").append(llllllllllllllIIIllllIlIlIlIIlll.getName()).append(", params: ").append(Config.arrayToString(this.parameterTypes))));
            }
            if (this.targetConstructor != null) {
                this.targetConstructor.setAccessible(true);
            }
        }
        catch (Throwable llllllllllllllIIIllllIlIlIlIIllI) {
            llllllllllllllIIIllllIlIlIlIIllI.printStackTrace();
        }
        return this.targetConstructor;
    }
}
