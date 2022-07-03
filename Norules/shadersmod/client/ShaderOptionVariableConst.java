package shadersmod.client;

import java.util.regex.*;
import optifine.*;

public class ShaderOptionVariableConst extends ShaderOptionVariable
{
    private /* synthetic */ String type;
    private static final /* synthetic */ Pattern PATTERN_CONST;
    
    static {
        PATTERN_CONST = Pattern.compile("^\\s*const\\s*(float|int)\\s*([A-Za-z0-9_]+)\\s*=\\s*(-?[0-9\\.]+f?F?)\\s*;\\s*(//.*)?$");
    }
    
    @Override
    public boolean matchesLine(final String llllllllllllIlllllIIlIIIIIlIlIll) {
        final Matcher llllllllllllIlllllIIlIIIIIlIlIlI = ShaderOptionVariableConst.PATTERN_CONST.matcher(llllllllllllIlllllIIlIIIIIlIlIll);
        if (!llllllllllllIlllllIIlIIIIIlIlIlI.matches()) {
            return false;
        }
        final String llllllllllllIlllllIIlIIIIIlIlIIl = llllllllllllIlllllIIlIIIIIlIlIlI.group(2);
        return llllllllllllIlllllIIlIIIIIlIlIIl.matches(this.getName());
    }
    
    @Override
    public String getSourceLine() {
        return String.valueOf(new StringBuilder("const ").append(this.type).append(" ").append(this.getName()).append(" = ").append(this.getValue()).append("; // Shader option ").append(this.getValue()));
    }
    
    public static ShaderOption parseOption(final String llllllllllllIlllllIIlIIIIIIllIlI, String llllllllllllIlllllIIlIIIIIIIllll) {
        final Matcher llllllllllllIlllllIIlIIIIIIllIII = ShaderOptionVariableConst.PATTERN_CONST.matcher(llllllllllllIlllllIIlIIIIIIllIlI);
        if (!llllllllllllIlllllIIlIIIIIIllIII.matches()) {
            return null;
        }
        final String llllllllllllIlllllIIlIIIIIIlIlll = llllllllllllIlllllIIlIIIIIIllIII.group(1);
        final String llllllllllllIlllllIIlIIIIIIlIllI = llllllllllllIlllllIIlIIIIIIllIII.group(2);
        final String llllllllllllIlllllIIlIIIIIIlIlIl = llllllllllllIlllllIIlIIIIIIllIII.group(3);
        String llllllllllllIlllllIIlIIIIIIlIlII = llllllllllllIlllllIIlIIIIIIllIII.group(4);
        final String llllllllllllIlllllIIlIIIIIIlIIll = StrUtils.getSegment(llllllllllllIlllllIIlIIIIIIlIlII, "[", "]");
        if (llllllllllllIlllllIIlIIIIIIlIIll != null && llllllllllllIlllllIIlIIIIIIlIIll.length() > 0) {
            llllllllllllIlllllIIlIIIIIIlIlII = llllllllllllIlllllIIlIIIIIIlIlII.replace(llllllllllllIlllllIIlIIIIIIlIIll, "").trim();
        }
        final String[] llllllllllllIlllllIIlIIIIIIlIIlI = ShaderOptionVariable.parseValues(llllllllllllIlllllIIlIIIIIIlIlIl, llllllllllllIlllllIIlIIIIIIlIIll);
        if (llllllllllllIlllllIIlIIIIIIlIllI != null && llllllllllllIlllllIIlIIIIIIlIllI.length() > 0) {
            llllllllllllIlllllIIlIIIIIIIllll = StrUtils.removePrefix(llllllllllllIlllllIIlIIIIIIIllll, "/shaders/");
            final ShaderOption llllllllllllIlllllIIlIIIIIIlIIIl = new ShaderOptionVariableConst(llllllllllllIlllllIIlIIIIIIlIllI, llllllllllllIlllllIIlIIIIIIlIlll, llllllllllllIlllllIIlIIIIIIlIlII, llllllllllllIlllllIIlIIIIIIlIlIl, llllllllllllIlllllIIlIIIIIIlIIlI, llllllllllllIlllllIIlIIIIIIIllll);
            return llllllllllllIlllllIIlIIIIIIlIIIl;
        }
        return null;
    }
    
    public ShaderOptionVariableConst(final String llllllllllllIlllllIIlIIIIlIIIIII, final String llllllllllllIlllllIIlIIIIIlllIII, final String llllllllllllIlllllIIlIIIIIlllllI, final String llllllllllllIlllllIIlIIIIIllIllI, final String[] llllllllllllIlllllIIlIIIIIllllII, final String llllllllllllIlllllIIlIIIIIlllIll) {
        super(llllllllllllIlllllIIlIIIIlIIIIII, llllllllllllIlllllIIlIIIIIlllllI, llllllllllllIlllllIIlIIIIIllIllI, llllllllllllIlllllIIlIIIIIllllII, llllllllllllIlllllIIlIIIIIlllIll);
        this.type = null;
        this.type = llllllllllllIlllllIIlIIIIIlllIII;
    }
}
