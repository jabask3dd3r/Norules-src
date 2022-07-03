package shadersmod.client;

import optifine.*;

public class ShaderUtils
{
    public static ShaderOption getShaderOption(final String llllllllllllIllllllllIlIIlllIlIl, final ShaderOption[] llllllllllllIllllllllIlIIlllIIII) {
        if (llllllllllllIllllllllIlIIlllIIII == null) {
            return null;
        }
        for (int llllllllllllIllllllllIlIIlllIIll = 0; llllllllllllIllllllllIlIIlllIIll < llllllllllllIllllllllIlIIlllIIII.length; ++llllllllllllIllllllllIlIIlllIIll) {
            final ShaderOption llllllllllllIllllllllIlIIlllIIlI = llllllllllllIllllllllIlIIlllIIII[llllllllllllIllllllllIlIIlllIIll];
            if (llllllllllllIllllllllIlIIlllIIlI.getName().equals(llllllllllllIllllllllIlIIlllIlIl)) {
                return llllllllllllIllllllllIlIIlllIIlI;
            }
        }
        return null;
    }
    
    public static boolean matchProfile(final ShaderProfile llllllllllllIllllllllIlIIlIIllII, final ShaderOption[] llllllllllllIllllllllIlIIlIlIlII, final boolean llllllllllllIllllllllIlIIlIlIIll) {
        if (llllllllllllIllllllllIlIIlIIllII == null) {
            return false;
        }
        if (llllllllllllIllllllllIlIIlIlIlII == null) {
            return false;
        }
        final String[] llllllllllllIllllllllIlIIlIlIIlI = llllllllllllIllllllllIlIIlIIllII.getOptions();
        for (int llllllllllllIllllllllIlIIlIlIIIl = 0; llllllllllllIllllllllIlIIlIlIIIl < llllllllllllIllllllllIlIIlIlIIlI.length; ++llllllllllllIllllllllIlIIlIlIIIl) {
            final String llllllllllllIllllllllIlIIlIlIIII = llllllllllllIllllllllIlIIlIlIIlI[llllllllllllIllllllllIlIIlIlIIIl];
            final ShaderOption llllllllllllIllllllllIlIIlIIllll = getShaderOption(llllllllllllIllllllllIlIIlIlIIII, llllllllllllIllllllllIlIIlIlIlII);
            if (llllllllllllIllllllllIlIIlIIllll != null) {
                final String llllllllllllIllllllllIlIIlIIlllI = llllllllllllIllllllllIlIIlIlIIll ? llllllllllllIllllllllIlIIlIIllll.getValueDefault() : llllllllllllIllllllllIlIIlIIllll.getValue();
                final String llllllllllllIllllllllIlIIlIIllIl = llllllllllllIllllllllIlIIlIIllII.getValue(llllllllllllIllllllllIlIIlIlIIII);
                if (!Config.equals(llllllllllllIllllllllIlIIlIIlllI, llllllllllllIllllllllIlIIlIIllIl)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static ShaderProfile detectProfile(final ShaderProfile[] llllllllllllIllllllllIlIIllIIIll, final ShaderOption[] llllllllllllIllllllllIlIIllIIIlI, final boolean llllllllllllIllllllllIlIIllIIIIl) {
        if (llllllllllllIllllllllIlIIllIIIll == null) {
            return null;
        }
        for (int llllllllllllIllllllllIlIIllIIlIl = 0; llllllllllllIllllllllIlIIllIIlIl < llllllllllllIllllllllIlIIllIIIll.length; ++llllllllllllIllllllllIlIIllIIlIl) {
            final ShaderProfile llllllllllllIllllllllIlIIllIIlII = llllllllllllIllllllllIlIIllIIIll[llllllllllllIllllllllIlIIllIIlIl];
            if (matchProfile(llllllllllllIllllllllIlIIllIIlII, llllllllllllIllllllllIlIIllIIIlI, llllllllllllIllllllllIlIIllIIIIl)) {
                return llllllllllllIllllllllIlIIllIIlII;
            }
        }
        return null;
    }
}
