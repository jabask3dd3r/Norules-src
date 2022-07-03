package com.viaversion.viaversion.libs.javassist.tools.reflect;

public class Sample
{
    private static /* synthetic */ ClassMetaobject _classobject;
    private /* synthetic */ Metaobject _metaobject;
    
    public static Object trapRead(final Object[] lllIlIllIIIIlIl, final String lllIlIllIIIIllI) {
        if (lllIlIllIIIIlIl[0] == null) {
            return Sample._classobject.trapFieldRead(lllIlIllIIIIllI);
        }
        return ((Metalevel)lllIlIllIIIIlIl[0])._getMetaobject().trapFieldRead(lllIlIllIIIIllI);
    }
    
    public static Object trapWrite(final Object[] lllIlIlIlllllIl, final String lllIlIlIlllllII) {
        final Metalevel lllIlIlIllllllI = (Metalevel)lllIlIlIlllllIl[0];
        if (lllIlIlIllllllI == null) {
            Sample._classobject.trapFieldWrite(lllIlIlIlllllII, lllIlIlIlllllIl[1]);
        }
        else {
            lllIlIlIllllllI._getMetaobject().trapFieldWrite(lllIlIlIlllllII, lllIlIlIlllllIl[1]);
        }
        return null;
    }
    
    public static Object trapStatic(final Object[] lllIlIllIIIlIll, final int lllIlIllIIIllII) throws Throwable {
        return Sample._classobject.trapMethodcall(lllIlIllIIIllII, lllIlIllIIIlIll);
    }
    
    public Object trap(final Object[] lllIlIllIIlIIlI, final int lllIlIllIIlIlIl) throws Throwable {
        final Metaobject lllIlIllIIlIlII = this._metaobject;
        if (lllIlIllIIlIlII == null) {
            return ClassMetaobject.invoke(this, lllIlIllIIlIlIl, lllIlIllIIlIIlI);
        }
        return lllIlIllIIlIlII.trapMethodcall(lllIlIllIIlIlIl, lllIlIllIIlIIlI);
    }
}
