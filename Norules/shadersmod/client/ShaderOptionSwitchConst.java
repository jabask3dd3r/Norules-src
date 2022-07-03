package shadersmod.client;

import java.util.regex.*;
import optifine.*;

public class ShaderOptionSwitchConst extends ShaderOptionSwitch
{
    private static final /* synthetic */ Pattern PATTERN_CONST;
    
    public ShaderOptionSwitchConst(final String lllllllllllllIlllIIIlIlIIlIIllll, final String lllllllllllllIlllIIIlIlIIlIIlllI, final String lllllllllllllIlllIIIlIlIIlIIllIl, final String lllllllllllllIlllIIIlIlIIlIlIIIl) {
        super(lllllllllllllIlllIIIlIlIIlIIllll, lllllllllllllIlllIIIlIlIIlIIlllI, lllllllllllllIlllIIIlIlIIlIIllIl, lllllllllllllIlllIIIlIlIIlIlIIIl);
    }
    
    @Override
    public String getSourceLine() {
        return String.valueOf(new StringBuilder("const bool ").append(this.getName()).append(" = ").append(this.getValue()).append("; // Shader option ").append(this.getValue()));
    }
    
    @Override
    public boolean matchesLine(final String lllllllllllllIlllIIIlIlIIIlIlIlI) {
        final Matcher lllllllllllllIlllIIIlIlIIIlIllIl = ShaderOptionSwitchConst.PATTERN_CONST.matcher(lllllllllllllIlllIIIlIlIIIlIlIlI);
        if (!lllllllllllllIlllIIIlIlIIIlIllIl.matches()) {
            return false;
        }
        final String lllllllllllllIlllIIIlIlIIIlIllII = lllllllllllllIlllIIIlIlIIIlIllIl.group(1);
        return lllllllllllllIlllIIIlIlIIIlIllII.matches(this.getName());
    }
    
    public static ShaderOption parseOption(final String lllllllllllllIlllIIIlIlIIlIIIIIl, String lllllllllllllIlllIIIlIlIIIlllIIl) {
        final Matcher lllllllllllllIlllIIIlIlIIIllllll = ShaderOptionSwitchConst.PATTERN_CONST.matcher(lllllllllllllIlllIIIlIlIIlIIIIIl);
        if (!lllllllllllllIlllIIIlIlIIIllllll.matches()) {
            return null;
        }
        final String lllllllllllllIlllIIIlIlIIIlllllI = lllllllllllllIlllIIIlIlIIIllllll.group(1);
        final String lllllllllllllIlllIIIlIlIIIllllIl = lllllllllllllIlllIIIlIlIIIllllll.group(2);
        final String lllllllllllllIlllIIIlIlIIIllllII = lllllllllllllIlllIIIlIlIIIllllll.group(3);
        if (lllllllllllllIlllIIIlIlIIIlllllI != null && lllllllllllllIlllIIIlIlIIIlllllI.length() > 0) {
            lllllllllllllIlllIIIlIlIIIlllIIl = (boolean)StrUtils.removePrefix((String)lllllllllllllIlllIIIlIlIIIlllIIl, "/shaders/");
            final ShaderOption lllllllllllllIlllIIIlIlIIIlllIll = new ShaderOptionSwitchConst(lllllllllllllIlllIIIlIlIIIlllllI, lllllllllllllIlllIIIlIlIIIllllII, lllllllllllllIlllIIIlIlIIIllllIl, (String)lllllllllllllIlllIIIlIlIIIlllIIl);
            lllllllllllllIlllIIIlIlIIIlllIll.setVisible(false);
            return lllllllllllllIlllIIIlIlIIIlllIll;
        }
        return null;
    }
    
    static {
        PATTERN_CONST = Pattern.compile("^\\s*const\\s*bool\\s*([A-Za-z0-9_]+)\\s*=\\s*(true|false)\\s*;\\s*(//.*)?$");
    }
    
    @Override
    public boolean checkUsed() {
        return false;
    }
}
