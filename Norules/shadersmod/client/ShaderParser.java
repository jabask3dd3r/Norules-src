package shadersmod.client;

import java.util.regex.*;

public class ShaderParser
{
    public static /* synthetic */ Pattern PATTERN_COMPOSITE_FSH;
    public static /* synthetic */ Pattern PATTERN_DRAW_BUFFERS;
    public static /* synthetic */ Pattern PATTERN_UNIFORM;
    public static /* synthetic */ Pattern PATTERN_CONST_FLOAT;
    public static /* synthetic */ Pattern PATTERN_CONST_BOOL;
    public static /* synthetic */ Pattern PATTERN_CONST_INT;
    public static /* synthetic */ Pattern PATTERN_FINAL_FSH;
    public static /* synthetic */ Pattern PATTERN_COMMENT;
    
    public static boolean isValidDrawBuffers(final String llIllllIllIllII) {
        return ShaderParser.PATTERN_DRAW_BUFFERS.matcher(llIllllIllIllII).matches();
    }
    
    public static int getShadowColorIndex(final String llIllllIllllllI) {
        byte llIllllIlllllll = -1;
        switch (llIllllIllllllI.hashCode()) {
            case -1560188349: {
                if (llIllllIllllllI.equals("shadowcolor")) {
                    llIllllIlllllll = 0;
                    break;
                }
                break;
            }
        }
        switch (llIllllIlllllll) {
            case 0: {
                return 0;
            }
            default: {
                return getIndex(llIllllIllllllI, "shadowcolor", 0, 1);
            }
        }
    }
    
    public static int getColorIndex(final String llIllllIlllIlll) {
        final int llIllllIlllIllI = getIndex(llIllllIlllIlll, "gaux", 1, 4);
        return (llIllllIlllIllI > 0) ? (llIllllIlllIllI + 3) : getIndex(llIllllIlllIlll, "colortex", 4, 7);
    }
    
    static {
        ShaderParser.PATTERN_UNIFORM = Pattern.compile("\\s*uniform\\s+\\w+\\s+(\\w+).*");
        ShaderParser.PATTERN_COMMENT = Pattern.compile("\\s*/\\*\\s+([A-Z]+):(\\S+)\\s+\\*/.*");
        ShaderParser.PATTERN_CONST_INT = Pattern.compile("\\s*const\\s+int\\s+(\\w+)\\s*=\\s*([-+.\\w]+)\\s*;.*");
        ShaderParser.PATTERN_CONST_FLOAT = Pattern.compile("\\s*const\\s+float\\s+(\\w+)\\s*=\\s*([-+.\\w]+)\\s*;.*");
        ShaderParser.PATTERN_CONST_BOOL = Pattern.compile("\\s*const\\s+bool\\s+(\\w+)\\s*=\\s*(\\w+)\\s*;.*");
        ShaderParser.PATTERN_COMPOSITE_FSH = Pattern.compile(".*composite[0-9]?\\.fsh");
        ShaderParser.PATTERN_FINAL_FSH = Pattern.compile(".*final\\.fsh");
        ShaderParser.PATTERN_DRAW_BUFFERS = Pattern.compile("[0-7N]*");
    }
    
    public static int getShadowDepthIndex(final String llIlllllIIIIlII) {
        byte llIlllllIIIIlIl = -1;
        switch (llIlllllIIIIlII.hashCode()) {
            case -903579360: {
                if (llIlllllIIIIlII.equals("shadow")) {
                    llIlllllIIIIlIl = 0;
                    break;
                }
                break;
            }
            case 1235669239: {
                if (llIlllllIIIIlII.equals("watershadow")) {
                    llIlllllIIIIlIl = 1;
                    break;
                }
                break;
            }
        }
        switch (llIlllllIIIIlIl) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            default: {
                return getIndex(llIlllllIIIIlII, "shadowtex", 0, 1);
            }
        }
    }
    
    public static int getDepthIndex(final String llIllllIllllIlI) {
        return getIndex(llIllllIllllIlI, "depthtex", 0, 2);
    }
    
    public static int getIndex(final String llIlllllIIIllIl, final String llIlllllIIlIIIl, final int llIlllllIIlIIII, final int llIlllllIIIlIlI) {
        if (llIlllllIIIllIl.length() != llIlllllIIlIIIl.length() + 1) {
            return -1;
        }
        if (!llIlllllIIIllIl.startsWith(llIlllllIIlIIIl)) {
            return -1;
        }
        final int llIlllllIIIlllI = llIlllllIIIllIl.charAt(llIlllllIIlIIIl.length()) - '0';
        return (llIlllllIIIlllI >= llIlllllIIlIIII && llIlllllIIIlllI <= llIlllllIIIlIlI) ? llIlllllIIIlllI : -1;
    }
    
    public static boolean isComposite(final String llIllllIlllIIIl) {
        return ShaderParser.PATTERN_COMPOSITE_FSH.matcher(llIllllIlllIIIl).matches();
    }
    
    public static boolean isFinal(final String llIllllIllIllll) {
        return ShaderParser.PATTERN_FINAL_FSH.matcher(llIllllIllIllll).matches();
    }
    
    public static ShaderLine parseLine(final String llIlllllIlIIIll) {
        final Matcher llIlllllIlIIIlI = ShaderParser.PATTERN_UNIFORM.matcher(llIlllllIlIIIll);
        if (llIlllllIlIIIlI.matches()) {
            return new ShaderLine(1, llIlllllIlIIIlI.group(1), "", llIlllllIlIIIll);
        }
        final Matcher llIlllllIlIIIIl = ShaderParser.PATTERN_COMMENT.matcher(llIlllllIlIIIll);
        if (llIlllllIlIIIIl.matches()) {
            return new ShaderLine(2, llIlllllIlIIIIl.group(1), llIlllllIlIIIIl.group(2), llIlllllIlIIIll);
        }
        final Matcher llIlllllIlIIIII = ShaderParser.PATTERN_CONST_INT.matcher(llIlllllIlIIIll);
        if (llIlllllIlIIIII.matches()) {
            return new ShaderLine(3, llIlllllIlIIIII.group(1), llIlllllIlIIIII.group(2), llIlllllIlIIIll);
        }
        final Matcher llIlllllIIlllll = ShaderParser.PATTERN_CONST_FLOAT.matcher(llIlllllIlIIIll);
        if (llIlllllIIlllll.matches()) {
            return new ShaderLine(4, llIlllllIIlllll.group(1), llIlllllIIlllll.group(2), llIlllllIlIIIll);
        }
        final Matcher llIlllllIIllllI = ShaderParser.PATTERN_CONST_BOOL.matcher(llIlllllIlIIIll);
        return llIlllllIIllllI.matches() ? new ShaderLine(5, llIlllllIIllllI.group(1), llIlllllIIllllI.group(2), llIlllllIlIIIll) : null;
    }
}
