package shadersmod.client;

import optifine.*;
import java.util.regex.*;

public class ShaderOptionSwitch extends ShaderOption
{
    private static final /* synthetic */ Pattern PATTERN_IFDEF;
    private static final /* synthetic */ Pattern PATTERN_DEFINE;
    
    @Override
    public String getValueColor(final String llllllllllllllIlIIlIllIlIIIlIlII) {
        return isTrue(llllllllllllllIlIIlIllIlIIIlIlII) ? "§a" : "§c";
    }
    
    @Override
    public String getSourceLine() {
        return isTrue(this.getValue()) ? String.valueOf(new StringBuilder("#define ").append(this.getName()).append(" // Shader option ON")) : String.valueOf(new StringBuilder("//#define ").append(this.getName()).append(" // Shader option OFF"));
    }
    
    @Override
    public String getValueText(final String llllllllllllllIlIIlIllIlIIIllIIl) {
        final String llllllllllllllIlIIlIllIlIIIllIll = super.getValueText(llllllllllllllIlIIlIllIlIIIllIIl);
        if (llllllllllllllIlIIlIllIlIIIllIll != llllllllllllllIlIIlIllIlIIIllIIl) {
            return llllllllllllllIlIIlIllIlIIIllIll;
        }
        return isTrue(llllllllllllllIlIIlIllIlIIIllIIl) ? Lang.getOn() : Lang.getOff();
    }
    
    public static ShaderOption parseOption(final String llllllllllllllIlIIlIllIlIIIIlIlI, String llllllllllllllIlIIlIllIlIIIIIIII) {
        final Matcher llllllllllllllIlIIlIllIlIIIIlIII = ShaderOptionSwitch.PATTERN_DEFINE.matcher(llllllllllllllIlIIlIllIlIIIIlIlI);
        if (!llllllllllllllIlIIlIllIlIIIIlIII.matches()) {
            return null;
        }
        final String llllllllllllllIlIIlIllIlIIIIIlll = llllllllllllllIlIIlIllIlIIIIlIII.group(1);
        final String llllllllllllllIlIIlIllIlIIIIIllI = llllllllllllllIlIIlIllIlIIIIlIII.group(2);
        final String llllllllllllllIlIIlIllIlIIIIIlIl = llllllllllllllIlIIlIllIlIIIIlIII.group(3);
        if (llllllllllllllIlIIlIllIlIIIIIllI != null && llllllllllllllIlIIlIllIlIIIIIllI.length() > 0) {
            final boolean llllllllllllllIlIIlIllIlIIIIIlII = Config.equals(llllllllllllllIlIIlIllIlIIIIIlll, "//");
            final boolean llllllllllllllIlIIlIllIlIIIIIIll = !llllllllllllllIlIIlIllIlIIIIIlII;
            llllllllllllllIlIIlIllIlIIIIIIII = (float)StrUtils.removePrefix((String)llllllllllllllIlIIlIllIlIIIIIIII, "/shaders/");
            final ShaderOption llllllllllllllIlIIlIllIlIIIIIIlI = new ShaderOptionSwitch(llllllllllllllIlIIlIllIlIIIIIllI, llllllllllllllIlIIlIllIlIIIIIlIl, String.valueOf(llllllllllllllIlIIlIllIlIIIIIIll), (String)llllllllllllllIlIIlIllIlIIIIIIII);
            return llllllllllllllIlIIlIllIlIIIIIIlI;
        }
        return null;
    }
    
    static {
        PATTERN_DEFINE = Pattern.compile("^\\s*(//)?\\s*#define\\s+([A-Za-z0-9_]+)\\s*(//.*)?$");
        PATTERN_IFDEF = Pattern.compile("^\\s*#if(n)?def\\s+([A-Za-z0-9_]+)(\\s*)?$");
    }
    
    @Override
    public boolean checkUsed() {
        return true;
    }
    
    @Override
    public boolean matchesLine(final String llllllllllllllIlIIlIllIIlllIllll) {
        final Matcher llllllllllllllIlIIlIllIIllllIIlI = ShaderOptionSwitch.PATTERN_DEFINE.matcher(llllllllllllllIlIIlIllIIlllIllll);
        if (!llllllllllllllIlIIlIllIIllllIIlI.matches()) {
            return false;
        }
        final String llllllllllllllIlIIlIllIIllllIIIl = llllllllllllllIlIIlIllIIllllIIlI.group(2);
        return llllllllllllllIlIIlIllIIllllIIIl.matches(this.getName());
    }
    
    @Override
    public boolean isUsedInLine(final String llllllllllllllIlIIlIllIIlllIIllI) {
        final Matcher llllllllllllllIlIIlIllIIlllIIlIl = ShaderOptionSwitch.PATTERN_IFDEF.matcher(llllllllllllllIlIIlIllIIlllIIllI);
        if (llllllllllllllIlIIlIllIIlllIIlIl.matches()) {
            final String llllllllllllllIlIIlIllIIlllIIlII = llllllllllllllIlIIlIllIIlllIIlIl.group(2);
            if (llllllllllllllIlIIlIllIIlllIIlII.equals(this.getName())) {
                return true;
            }
        }
        return false;
    }
    
    public ShaderOptionSwitch(final String llllllllllllllIlIIlIllIlIIlIIlll, final String llllllllllllllIlIIlIllIlIIlIlIll, final String llllllllllllllIlIIlIllIlIIlIIlIl, final String llllllllllllllIlIIlIllIlIIlIIlII) {
        super(llllllllllllllIlIIlIllIlIIlIIlll, llllllllllllllIlIIlIllIlIIlIlIll, llllllllllllllIlIIlIllIlIIlIIlIl, new String[] { "false", "true" }, llllllllllllllIlIIlIllIlIIlIIlIl, llllllllllllllIlIIlIllIlIIlIIlII);
    }
    
    public static boolean isTrue(final String llllllllllllllIlIIlIllIIllIllllI) {
        return Boolean.valueOf(llllllllllllllIlIIlIllIIllIllllI);
    }
}
