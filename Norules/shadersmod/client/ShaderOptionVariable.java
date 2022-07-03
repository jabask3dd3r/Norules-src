package shadersmod.client;

import java.util.regex.*;
import optifine.*;
import java.util.*;

public class ShaderOptionVariable extends ShaderOption
{
    private static final /* synthetic */ Pattern PATTERN_VARIABLE;
    
    public static ShaderOption parseOption(final String llIlIlllIIlIlI, String llIlIlllIIIIII) {
        final Matcher llIlIlllIIlIII = ShaderOptionVariable.PATTERN_VARIABLE.matcher(llIlIlllIIlIlI);
        if (!llIlIlllIIlIII.matches()) {
            return null;
        }
        final String llIlIlllIIIlll = llIlIlllIIlIII.group(1);
        final String llIlIlllIIIllI = llIlIlllIIlIII.group(2);
        String llIlIlllIIIlIl = llIlIlllIIlIII.group(3);
        final String llIlIlllIIIlII = StrUtils.getSegment(llIlIlllIIIlIl, "[", "]");
        if (llIlIlllIIIlII != null && llIlIlllIIIlII.length() > 0) {
            llIlIlllIIIlIl = llIlIlllIIIlIl.replace(llIlIlllIIIlII, "").trim();
        }
        final String[] llIlIlllIIIIll = parseValues(llIlIlllIIIllI, llIlIlllIIIlII);
        if (llIlIlllIIIlll != null && llIlIlllIIIlll.length() > 0) {
            llIlIlllIIIIII = (double)StrUtils.removePrefix((String)llIlIlllIIIIII, "/shaders/");
            final ShaderOption llIlIlllIIIIlI = new ShaderOptionVariable(llIlIlllIIIlll, llIlIlllIIIlIl, llIlIlllIIIllI, llIlIlllIIIIll, (String)llIlIlllIIIIII);
            return llIlIlllIIIIlI;
        }
        return null;
    }
    
    @Override
    public String getSourceLine() {
        return String.valueOf(new StringBuilder("#define ").append(this.getName()).append(" ").append(this.getValue()).append(" // Shader option ").append(this.getValue()));
    }
    
    public static String[] parseValues(final String llIlIllIllIIII, String llIlIllIllIIll) {
        final String[] llIlIllIllIIlI = { llIlIllIllIIII };
        if (llIlIllIllIIll == null) {
            return llIlIllIllIIlI;
        }
        llIlIllIllIIll = llIlIllIllIIll.trim();
        llIlIllIllIIll = StrUtils.removePrefix(llIlIllIllIIll, "[");
        llIlIllIllIIll = StrUtils.removeSuffix(llIlIllIllIIll, "]");
        llIlIllIllIIll = llIlIllIllIIll.trim();
        if (llIlIllIllIIll.length() <= 0) {
            return llIlIllIllIIlI;
        }
        String[] llIlIllIllIIIl = Config.tokenize(llIlIllIllIIll, " ");
        if (llIlIllIllIIIl.length <= 0) {
            return llIlIllIllIIlI;
        }
        if (!Arrays.asList(llIlIllIllIIIl).contains(llIlIllIllIIII)) {
            llIlIllIllIIIl = (String[])Config.addObjectToArray(llIlIllIllIIIl, llIlIllIllIIII, 0);
        }
        return llIlIllIllIIIl;
    }
    
    @Override
    public boolean matchesLine(final String llIlIlllIllIlI) {
        final Matcher llIlIlllIllIIl = ShaderOptionVariable.PATTERN_VARIABLE.matcher(llIlIlllIllIlI);
        if (!llIlIlllIllIIl.matches()) {
            return false;
        }
        final String llIlIlllIllIII = llIlIlllIllIIl.group(1);
        return llIlIlllIllIII.matches(this.getName());
    }
    
    @Override
    public String getValueColor(final String llIlIllllIIIIl) {
        final String llIlIllllIIIlI = llIlIllllIIIIl.toLowerCase();
        return (!llIlIllllIIIlI.equals("false") && !llIlIllllIIIlI.equals("off")) ? "§a" : "§c";
    }
    
    public ShaderOptionVariable(final String llIllIIIIIIIII, final String llIllIIIIIIlIl, final String llIlIllllllllI, final String[] llIlIlllllllIl, final String llIlIlllllllII) {
        super(llIllIIIIIIIII, llIllIIIIIIlIl, llIlIllllllllI, llIlIlllllllIl, llIlIllllllllI, llIlIlllllllII);
        this.setVisible(this.getValues().length > 1);
    }
    
    @Override
    public String getValueText(final String llIlIlllllIIIl) {
        final String llIlIlllllIIII = Shaders.translate(String.valueOf(new StringBuilder("prefix.").append(this.getName())), "");
        final String llIlIllllIllll = super.getValueText(llIlIlllllIIIl);
        final String llIlIllllIlllI = Shaders.translate(String.valueOf(new StringBuilder("suffix.").append(this.getName())), "");
        final String llIlIllllIllIl = String.valueOf(new StringBuilder(String.valueOf(llIlIlllllIIII)).append(llIlIllllIllll).append(llIlIllllIlllI));
        return llIlIllllIllIl;
    }
    
    static {
        PATTERN_VARIABLE = Pattern.compile("^\\s*#define\\s+(\\w+)\\s+(-?[0-9\\.Ff]+|\\w+)\\s*(//.*)?$");
    }
}
