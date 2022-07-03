package com.viaversion.viaversion.libs.gson.internal;

public final class JavaVersion
{
    private static final /* synthetic */ int majorJavaVersion;
    
    static int getMajorJavaVersion(final String llllllllllllllllIllllIlIIIllllII) {
        int llllllllllllllllIllllIlIIIllllIl = parseDotted(llllllllllllllllIllllIlIIIllllII);
        if (llllllllllllllllIllllIlIIIllllIl == -1) {
            llllllllllllllllIllllIlIIIllllIl = extractBeginningInt(llllllllllllllllIllllIlIIIllllII);
        }
        if (llllllllllllllllIllllIlIIIllllIl == -1) {
            return 6;
        }
        return llllllllllllllllIllllIlIIIllllIl;
    }
    
    public static int getMajorJavaVersion() {
        return JavaVersion.majorJavaVersion;
    }
    
    static {
        majorJavaVersion = determineMajorJavaVersion();
    }
    
    public static boolean isJava9OrLater() {
        return JavaVersion.majorJavaVersion >= 9;
    }
    
    private static int determineMajorJavaVersion() {
        final String llllllllllllllllIllllIlIIlIIIIlI = System.getProperty("java.version");
        return getMajorJavaVersion(llllllllllllllllIllllIlIIlIIIIlI);
    }
    
    private static int parseDotted(final String llllllllllllllllIllllIlIIIllIlII) {
        try {
            final String[] llllllllllllllllIllllIlIIIllIlll = llllllllllllllllIllllIlIIIllIlII.split("[._]");
            final int llllllllllllllllIllllIlIIIllIllI = Integer.parseInt(llllllllllllllllIllllIlIIIllIlll[0]);
            if (llllllllllllllllIllllIlIIIllIllI == 1 && llllllllllllllllIllllIlIIIllIlll.length > 1) {
                return Integer.parseInt(llllllllllllllllIllllIlIIIllIlll[1]);
            }
            return llllllllllllllllIllllIlIIIllIllI;
        }
        catch (NumberFormatException llllllllllllllllIllllIlIIIllIlIl) {
            return -1;
        }
    }
    
    private static int extractBeginningInt(final String llllllllllllllllIllllIlIIIlIlIII) {
        try {
            final StringBuilder llllllllllllllllIllllIlIIIlIlIlI = new StringBuilder();
            for (int llllllllllllllllIllllIlIIIlIlIll = 0; llllllllllllllllIllllIlIIIlIlIll < llllllllllllllllIllllIlIIIlIlIII.length(); ++llllllllllllllllIllllIlIIIlIlIll) {
                final char llllllllllllllllIllllIlIIIlIllII = llllllllllllllllIllllIlIIIlIlIII.charAt(llllllllllllllllIllllIlIIIlIlIll);
                if (!Character.isDigit(llllllllllllllllIllllIlIIIlIllII)) {
                    break;
                }
                llllllllllllllllIllllIlIIIlIlIlI.append(llllllllllllllllIllllIlIIIlIllII);
            }
            return Integer.parseInt(String.valueOf(llllllllllllllllIllllIlIIIlIlIlI));
        }
        catch (NumberFormatException llllllllllllllllIllllIlIIIlIlIIl) {
            return -1;
        }
    }
    
    private JavaVersion() {
    }
}
