package shadersmod.client;

import optifine.*;
import java.util.regex.*;
import java.io.*;
import java.util.*;

public class ShaderPackParser
{
    private static final /* synthetic */ Pattern PATTERN_VERSION;
    private static final /* synthetic */ Set<String> setConstNames;
    private static final /* synthetic */ Pattern PATTERN_INCLUDE;
    
    private static String loadFile(final String llllllllllllllllllIlIIIIllllIIlI, final IShaderPack llllllllllllllllllIlIIIIllllIIIl, final int llllllllllllllllllIlIIIIllllIIII, final List<String> llllllllllllllllllIlIIIIlllIllll, int llllllllllllllllllIlIIIIlllllIII) throws IOException {
        if (llllllllllllllllllIlIIIIlllllIII >= 10) {
            throw new IOException(String.valueOf(new StringBuilder("#include depth exceeded: ").append(llllllllllllllllllIlIIIIlllllIII).append(", file: ").append(llllllllllllllllllIlIIIIllllIIlI)));
        }
        ++llllllllllllllllllIlIIIIlllllIII;
        final InputStream llllllllllllllllllIlIIIIllllIlll = llllllllllllllllllIlIIIIllllIIIl.getResourceAsStream(llllllllllllllllllIlIIIIllllIIlI);
        if (llllllllllllllllllIlIIIIllllIlll == null) {
            return null;
        }
        final InputStreamReader llllllllllllllllllIlIIIIllllIllI = new InputStreamReader(llllllllllllllllllIlIIIIllllIlll, "ASCII");
        BufferedReader llllllllllllllllllIlIIIIllllIlIl = new BufferedReader(llllllllllllllllllIlIIIIllllIllI);
        llllllllllllllllllIlIIIIllllIlIl = resolveIncludes(llllllllllllllllllIlIIIIllllIlIl, llllllllllllllllllIlIIIIllllIIlI, llllllllllllllllllIlIIIIllllIIIl, llllllllllllllllllIlIIIIllllIIII, llllllllllllllllllIlIIIIlllIllll, llllllllllllllllllIlIIIIlllllIII);
        final CharArrayWriter llllllllllllllllllIlIIIIllllIlII = new CharArrayWriter();
        while (true) {
            final String llllllllllllllllllIlIIIIllllIIll = llllllllllllllllllIlIIIIllllIlIl.readLine();
            if (llllllllllllllllllIlIIIIllllIIll == null) {
                break;
            }
            llllllllllllllllllIlIIIIllllIlII.write(llllllllllllllllllIlIIIIllllIIll);
            llllllllllllllllllIlIIIIllllIlII.write("\n");
        }
        return llllllllllllllllllIlIIIIllllIlII.toString();
    }
    
    private static ShaderOption getShaderOption(final String llllllllllllllllllIlIIlIIIIIlIIl, final String llllllllllllllllllIlIIlIIIIIlIII) {
        ShaderOption llllllllllllllllllIlIIlIIIIIIlll = null;
        if (llllllllllllllllllIlIIlIIIIIIlll == null) {
            llllllllllllllllllIlIIlIIIIIIlll = ShaderOptionSwitch.parseOption(llllllllllllllllllIlIIlIIIIIlIIl, llllllllllllllllllIlIIlIIIIIlIII);
        }
        if (llllllllllllllllllIlIIlIIIIIIlll == null) {
            llllllllllllllllllIlIIlIIIIIIlll = ShaderOptionVariable.parseOption(llllllllllllllllllIlIIlIIIIIlIIl, llllllllllllllllllIlIIlIIIIIlIII);
        }
        if (llllllllllllllllllIlIIlIIIIIIlll != null) {
            return llllllllllllllllllIlIIlIIIIIIlll;
        }
        if (llllllllllllllllllIlIIlIIIIIIlll == null) {
            llllllllllllllllllIlIIlIIIIIIlll = ShaderOptionSwitchConst.parseOption(llllllllllllllllllIlIIlIIIIIlIIl, llllllllllllllllllIlIIlIIIIIlIII);
        }
        if (llllllllllllllllllIlIIlIIIIIIlll == null) {
            llllllllllllllllllIlIIlIIIIIIlll = ShaderOptionVariableConst.parseOption(llllllllllllllllllIlIIlIIIIIlIIl, llllllllllllllllllIlIIlIIIIIlIII);
        }
        return (llllllllllllllllllIlIIlIIIIIIlll != null && ShaderPackParser.setConstNames.contains(llllllllllllllllllIlIIlIIIIIIlll.getName())) ? llllllllllllllllllIlIIlIIIIIIlll : null;
    }
    
    public static ShaderProfile[] parseProfiles(final Properties llllllllllllllllllIlIIIlllllIllI, final ShaderOption[] llllllllllllllllllIlIIIllllIlIll) {
        final String llllllllllllllllllIlIIIlllllIlII = "profile.";
        final List<ShaderProfile> llllllllllllllllllIlIIIlllllIIll = new ArrayList<ShaderProfile>();
        for (final Object llllllllllllllllllIlIIIlllllIIlI : ((Hashtable<Object, V>)llllllllllllllllllIlIIIlllllIllI).keySet()) {
            final String llllllllllllllllllIlIIIlllllIIIl = (String)llllllllllllllllllIlIIIlllllIIlI;
            if (llllllllllllllllllIlIIIlllllIIIl.startsWith(llllllllllllllllllIlIIIlllllIlII)) {
                final String llllllllllllllllllIlIIIlllllIIII = llllllllllllllllllIlIIIlllllIIIl.substring(llllllllllllllllllIlIIIlllllIlII.length());
                llllllllllllllllllIlIIIlllllIllI.getProperty(llllllllllllllllllIlIIIlllllIIIl);
                final Set<String> llllllllllllllllllIlIIIllllIllll = new HashSet<String>();
                final ShaderProfile llllllllllllllllllIlIIIllllIlllI = parseProfile(llllllllllllllllllIlIIIlllllIIII, llllllllllllllllllIlIIIlllllIllI, llllllllllllllllllIlIIIllllIllll, llllllllllllllllllIlIIIllllIlIll);
                if (llllllllllllllllllIlIIIllllIlllI == null) {
                    continue;
                }
                llllllllllllllllllIlIIIlllllIIll.add(llllllllllllllllllIlIIIllllIlllI);
            }
        }
        if (llllllllllllllllllIlIIIlllllIIll.size() <= 0) {
            return null;
        }
        final ShaderProfile[] llllllllllllllllllIlIIIllllIllIl = llllllllllllllllllIlIIIlllllIIll.toArray(new ShaderProfile[llllllllllllllllllIlIIIlllllIIll.size()]);
        return llllllllllllllllllIlIIIllllIllIl;
    }
    
    private static boolean parseGuiScreen(final String llllllllllllllllllIlIIIlIllllIll, final Properties llllllllllllllllllIlIIIlIllIIllI, final Map<String, ScreenShaderOptions> llllllllllllllllllIlIIIlIllllIIl, final ShaderProfile[] llllllllllllllllllIlIIIlIllIIlII, final ShaderOption[] llllllllllllllllllIlIIIlIlllIlll) {
        final String llllllllllllllllllIlIIIlIlllIllI = llllllllllllllllllIlIIIlIllIIllI.getProperty(llllllllllllllllllIlIIIlIllllIll);
        if (llllllllllllllllllIlIIIlIlllIllI == null) {
            return false;
        }
        final List<ShaderOption> llllllllllllllllllIlIIIlIlllIlIl = new ArrayList<ShaderOption>();
        final Set<String> llllllllllllllllllIlIIIlIlllIlII = new HashSet<String>();
        final String[] llllllllllllllllllIlIIIlIlllIIll = Config.tokenize(llllllllllllllllllIlIIIlIlllIllI, " ");
        for (int llllllllllllllllllIlIIIlIlllIIlI = 0; llllllllllllllllllIlIIIlIlllIIlI < llllllllllllllllllIlIIIlIlllIIll.length; ++llllllllllllllllllIlIIIlIlllIIlI) {
            final String llllllllllllllllllIlIIIlIlllIIIl = llllllllllllllllllIlIIIlIlllIIll[llllllllllllllllllIlIIIlIlllIIlI];
            if (llllllllllllllllllIlIIIlIlllIIIl.equals("<empty>")) {
                llllllllllllllllllIlIIIlIlllIlIl.add(null);
            }
            else if (llllllllllllllllllIlIIIlIlllIlII.contains(llllllllllllllllllIlIIIlIlllIIIl)) {
                Config.warn(String.valueOf(new StringBuilder("[Shaders] Duplicate option: ").append(llllllllllllllllllIlIIIlIlllIIIl).append(", key: ").append(llllllllllllllllllIlIIIlIllllIll)));
            }
            else {
                llllllllllllllllllIlIIIlIlllIlII.add(llllllllllllllllllIlIIIlIlllIIIl);
                if (llllllllllllllllllIlIIIlIlllIIIl.equals("<profile>")) {
                    if (llllllllllllllllllIlIIIlIllIIlII == null) {
                        Config.warn(String.valueOf(new StringBuilder("[Shaders] Option profile can not be used, no profiles defined: ").append(llllllllllllllllllIlIIIlIlllIIIl).append(", key: ").append(llllllllllllllllllIlIIIlIllllIll)));
                    }
                    else {
                        final ShaderOptionProfile llllllllllllllllllIlIIIlIlllIIII = new ShaderOptionProfile(llllllllllllllllllIlIIIlIllIIlII, llllllllllllllllllIlIIIlIlllIlll);
                        llllllllllllllllllIlIIIlIlllIlIl.add(llllllllllllllllllIlIIIlIlllIIII);
                    }
                }
                else if (llllllllllllllllllIlIIIlIlllIIIl.equals("*")) {
                    final ShaderOption llllllllllllllllllIlIIIlIllIllll = new ShaderOptionRest("<rest>");
                    llllllllllllllllllIlIIIlIlllIlIl.add(llllllllllllllllllIlIIIlIllIllll);
                }
                else if (llllllllllllllllllIlIIIlIlllIIIl.startsWith("[") && llllllllllllllllllIlIIIlIlllIIIl.endsWith("]")) {
                    final String llllllllllllllllllIlIIIlIllIlllI = StrUtils.removePrefixSuffix(llllllllllllllllllIlIIIlIlllIIIl, "[", "]");
                    if (!llllllllllllllllllIlIIIlIllIlllI.matches("^[a-zA-Z0-9_]+$")) {
                        Config.warn(String.valueOf(new StringBuilder("[Shaders] Invalid screen: ").append(llllllllllllllllllIlIIIlIlllIIIl).append(", key: ").append(llllllllllllllllllIlIIIlIllllIll)));
                    }
                    else if (!parseGuiScreen(String.valueOf(new StringBuilder("screen.").append(llllllllllllllllllIlIIIlIllIlllI)), llllllllllllllllllIlIIIlIllIIllI, llllllllllllllllllIlIIIlIllllIIl, llllllllllllllllllIlIIIlIllIIlII, llllllllllllllllllIlIIIlIlllIlll)) {
                        Config.warn(String.valueOf(new StringBuilder("[Shaders] Invalid screen: ").append(llllllllllllllllllIlIIIlIlllIIIl).append(", key: ").append(llllllllllllllllllIlIIIlIllllIll)));
                    }
                    else {
                        final ShaderOptionScreen llllllllllllllllllIlIIIlIllIllIl = new ShaderOptionScreen(llllllllllllllllllIlIIIlIllIlllI);
                        llllllllllllllllllIlIIIlIlllIlIl.add(llllllllllllllllllIlIIIlIllIllIl);
                    }
                }
                else {
                    final ShaderOption llllllllllllllllllIlIIIlIllIllII = ShaderUtils.getShaderOption(llllllllllllllllllIlIIIlIlllIIIl, llllllllllllllllllIlIIIlIlllIlll);
                    if (llllllllllllllllllIlIIIlIllIllII == null) {
                        Config.warn(String.valueOf(new StringBuilder("[Shaders] Invalid option: ").append(llllllllllllllllllIlIIIlIlllIIIl).append(", key: ").append(llllllllllllllllllIlIIIlIllllIll)));
                        llllllllllllllllllIlIIIlIlllIlIl.add(null);
                    }
                    else {
                        llllllllllllllllllIlIIIlIllIllII.setVisible(true);
                        llllllllllllllllllIlIIIlIlllIlIl.add(llllllllllllllllllIlIIIlIllIllII);
                    }
                }
            }
        }
        final ShaderOption[] llllllllllllllllllIlIIIlIllIlIll = llllllllllllllllllIlIIIlIlllIlIl.toArray(new ShaderOption[llllllllllllllllllIlIIIlIlllIlIl.size()]);
        final String llllllllllllllllllIlIIIlIllIlIlI = llllllllllllllllllIlIIIlIllIIllI.getProperty(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIlIIIlIllllIll)).append(".columns")));
        final int llllllllllllllllllIlIIIlIllIlIIl = Config.parseInt(llllllllllllllllllIlIIIlIllIlIlI, 2);
        final ScreenShaderOptions llllllllllllllllllIlIIIlIllIlIII = new ScreenShaderOptions(llllllllllllllllllIlIIIlIllllIll, llllllllllllllllllIlIIIlIllIlIll, llllllllllllllllllIlIIIlIllIlIIl);
        llllllllllllllllllIlIIIlIllllIIl.put(llllllllllllllllllIlIIIlIllllIll, llllllllllllllllllIlIIIlIllIlIII);
        return true;
    }
    
    public static BufferedReader resolveIncludes(final BufferedReader llllllllllllllllllIlIIIlIlIIlIII, final String llllllllllllllllllIlIIIlIIlIIlll, final IShaderPack llllllllllllllllllIlIIIlIlIIIllI, final int llllllllllllllllllIlIIIlIIlIIlIl, final List<String> llllllllllllllllllIlIIIlIIlIIlII, final int llllllllllllllllllIlIIIlIIlIIIll) throws IOException {
        String llllllllllllllllllIlIIIlIlIIIIlI = "/";
        final int llllllllllllllllllIlIIIlIlIIIIIl = llllllllllllllllllIlIIIlIIlIIlll.lastIndexOf("/");
        if (llllllllllllllllllIlIIIlIlIIIIIl >= 0) {
            llllllllllllllllllIlIIIlIlIIIIlI = llllllllllllllllllIlIIIlIIlIIlll.substring(0, llllllllllllllllllIlIIIlIlIIIIIl);
        }
        final CharArrayWriter llllllllllllllllllIlIIIlIlIIIIII = new CharArrayWriter();
        int llllllllllllllllllIlIIIlIIllllll = -1;
        final Set<String> llllllllllllllllllIlIIIlIIlllllI = new LinkedHashSet<String>();
        int llllllllllllllllllIlIIIlIIllllIl = 1;
        while (true) {
            String llllllllllllllllllIlIIIlIIllllII = llllllllllllllllllIlIIIlIlIIlIII.readLine();
            if (llllllllllllllllllIlIIIlIIllllII == null) {
                char[] llllllllllllllllllIlIIIlIIlllIll = llllllllllllllllllIlIIIlIlIIIIII.toCharArray();
                if (llllllllllllllllllIlIIIlIIllllll >= 0 && llllllllllllllllllIlIIIlIIlllllI.size() > 0) {
                    final StringBuilder llllllllllllllllllIlIIIlIIlllIlI = new StringBuilder();
                    for (final String llllllllllllllllllIlIIIlIIlllIIl : llllllllllllllllllIlIIIlIIlllllI) {
                        llllllllllllllllllIlIIIlIIlllIlI.append("#define ");
                        llllllllllllllllllIlIIIlIIlllIlI.append(llllllllllllllllllIlIIIlIIlllIIl);
                        llllllllllllllllllIlIIIlIIlllIlI.append("\n");
                    }
                    final String llllllllllllllllllIlIIIlIIlllIII = String.valueOf(llllllllllllllllllIlIIIlIIlllIlI);
                    final StringBuilder llllllllllllllllllIlIIIlIIllIlll = new StringBuilder(new String(llllllllllllllllllIlIIIlIIlllIll));
                    llllllllllllllllllIlIIIlIIllIlll.insert(llllllllllllllllllIlIIIlIIllllll, llllllllllllllllllIlIIIlIIlllIII);
                    final String llllllllllllllllllIlIIIlIIllIllI = String.valueOf(llllllllllllllllllIlIIIlIIllIlll);
                    llllllllllllllllllIlIIIlIIlllIll = llllllllllllllllllIlIIIlIIllIllI.toCharArray();
                }
                final CharArrayReader llllllllllllllllllIlIIIlIIllIlIl = new CharArrayReader(llllllllllllllllllIlIIIlIIlllIll);
                return new BufferedReader(llllllllllllllllllIlIIIlIIllIlIl);
            }
            if (llllllllllllllllllIlIIIlIIllllll < 0) {
                final Matcher llllllllllllllllllIlIIIlIIllIlII = ShaderPackParser.PATTERN_VERSION.matcher(llllllllllllllllllIlIIIlIIllllII);
                if (llllllllllllllllllIlIIIlIIllIlII.matches()) {
                    final String llllllllllllllllllIlIIIlIIllIIll = ShaderMacros.getMacroLines();
                    final String llllllllllllllllllIlIIIlIIllIIlI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIlIIIlIIllllII)).append("\n").append(llllllllllllllllllIlIIIlIIllIIll));
                    final String llllllllllllllllllIlIIIlIIllIIIl = String.valueOf(new StringBuilder("#line ").append(llllllllllllllllllIlIIIlIIllllIl + 1).append(" ").append(llllllllllllllllllIlIIIlIIlIIlIl));
                    llllllllllllllllllIlIIIlIIllllII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIlIIIlIIllIIlI)).append(llllllllllllllllllIlIIIlIIllIIIl));
                    llllllllllllllllllIlIIIlIIllllll = llllllllllllllllllIlIIIlIlIIIIII.size() + llllllllllllllllllIlIIIlIIllIIlI.length();
                }
            }
            final Matcher llllllllllllllllllIlIIIlIIllIIII = ShaderPackParser.PATTERN_INCLUDE.matcher(llllllllllllllllllIlIIIlIIllllII);
            if (llllllllllllllllllIlIIIlIIllIIII.matches()) {
                final String llllllllllllllllllIlIIIlIIlIllll = llllllllllllllllllIlIIIlIIllIIII.group(1);
                final boolean llllllllllllllllllIlIIIlIIlIlllI = llllllllllllllllllIlIIIlIIlIllll.startsWith("/");
                final String llllllllllllllllllIlIIIlIIlIllIl = llllllllllllllllllIlIIIlIIlIlllI ? String.valueOf(new StringBuilder("/shaders").append(llllllllllllllllllIlIIIlIIlIllll)) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIlIIIlIlIIIIlI)).append("/").append(llllllllllllllllllIlIIIlIIlIllll));
                if (!llllllllllllllllllIlIIIlIIlIIlII.contains(llllllllllllllllllIlIIIlIIlIllIl)) {
                    llllllllllllllllllIlIIIlIIlIIlII.add(llllllllllllllllllIlIIIlIIlIllIl);
                }
                final int llllllllllllllllllIlIIIlIIlIllII = llllllllllllllllllIlIIIlIIlIIlII.indexOf(llllllllllllllllllIlIIIlIIlIllIl) + 1;
                llllllllllllllllllIlIIIlIIllllII = loadFile(llllllllllllllllllIlIIIlIIlIllIl, llllllllllllllllllIlIIIlIlIIIllI, llllllllllllllllllIlIIIlIIlIllII, llllllllllllllllllIlIIIlIIlIIlII, llllllllllllllllllIlIIIlIIlIIIll);
                if (llllllllllllllllllIlIIIlIIllllII == null) {
                    throw new IOException(String.valueOf(new StringBuilder("Included file not found: ").append(llllllllllllllllllIlIIIlIIlIIlll)));
                }
                if (llllllllllllllllllIlIIIlIIllllII.endsWith("\n")) {
                    llllllllllllllllllIlIIIlIIllllII = llllllllllllllllllIlIIIlIIllllII.substring(0, llllllllllllllllllIlIIIlIIllllII.length() - 1);
                }
                llllllllllllllllllIlIIIlIIllllII = String.valueOf(new StringBuilder("#line 1 ").append(llllllllllllllllllIlIIIlIIlIllII).append("\n").append(llllllllllllllllllIlIIIlIIllllII).append("\n#line ").append(llllllllllllllllllIlIIIlIIllllIl + 1).append(" ").append(llllllllllllllllllIlIIIlIIlIIlIl));
            }
            if (llllllllllllllllllIlIIIlIIllllll >= 0 && llllllllllllllllllIlIIIlIIllllII.contains(ShaderMacros.getPrefixMacro())) {
                final String[] llllllllllllllllllIlIIIlIIlIlIll = findExtensions(llllllllllllllllllIlIIIlIIllllII, ShaderMacros.getExtensions());
                for (int llllllllllllllllllIlIIIlIIlIlIlI = 0; llllllllllllllllllIlIIIlIIlIlIlI < llllllllllllllllllIlIIIlIIlIlIll.length; ++llllllllllllllllllIlIIIlIIlIlIlI) {
                    final String llllllllllllllllllIlIIIlIIlIlIIl = llllllllllllllllllIlIIIlIIlIlIll[llllllllllllllllllIlIIIlIIlIlIlI];
                    llllllllllllllllllIlIIIlIIlllllI.add(llllllllllllllllllIlIIIlIIlIlIIl);
                }
            }
            llllllllllllllllllIlIIIlIlIIIIII.write(llllllllllllllllllIlIIIlIIllllII);
            llllllllllllllllllIlIIIlIlIIIIII.write("\n");
            ++llllllllllllllllllIlIIIlIIllllIl;
        }
    }
    
    private static String[] getLines(final IShaderPack llllllllllllllllllIlIIlIIIIlIIlI, final String llllllllllllllllllIlIIlIIIIllIII) {
        try {
            final List<String> llllllllllllllllllIlIIlIIIIlIlll = new ArrayList<String>();
            final String llllllllllllllllllIlIIlIIIIlIllI = loadFile(llllllllllllllllllIlIIlIIIIllIII, llllllllllllllllllIlIIlIIIIlIIlI, 0, llllllllllllllllllIlIIlIIIIlIlll, 0);
            if (llllllllllllllllllIlIIlIIIIlIllI == null) {
                return new String[0];
            }
            final ByteArrayInputStream llllllllllllllllllIlIIlIIIIlIlIl = new ByteArrayInputStream(llllllllllllllllllIlIIlIIIIlIllI.getBytes());
            final String[] llllllllllllllllllIlIIlIIIIlIlII = Config.readLines(llllllllllllllllllIlIIlIIIIlIlIl);
            return llllllllllllllllllIlIIlIIIIlIlII;
        }
        catch (IOException llllllllllllllllllIlIIlIIIIlIIll) {
            Config.dbg(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIlIIlIIIIlIIll.getClass().getName())).append(": ").append(llllllllllllllllllIlIIlIIIIlIIll.getMessage())));
            return new String[0];
        }
    }
    
    public static ShaderOption[] parseShaderPackOptions(final IShaderPack llllllllllllllllllIlIIlIIllIIllI, final String[] llllllllllllllllllIlIIlIIllIllll, final List<Integer> llllllllllllllllllIlIIlIIllIlllI) {
        if (llllllllllllllllllIlIIlIIllIIllI == null) {
            return new ShaderOption[0];
        }
        final Map<String, ShaderOption> llllllllllllllllllIlIIlIIllIllIl = new HashMap<String, ShaderOption>();
        collectShaderOptions(llllllllllllllllllIlIIlIIllIIllI, "/shaders", llllllllllllllllllIlIIlIIllIllll, llllllllllllllllllIlIIlIIllIllIl);
        for (final int llllllllllllllllllIlIIlIIllIlIll : llllllllllllllllllIlIIlIIllIlllI) {
            final String llllllllllllllllllIlIIlIIllIlIlI = String.valueOf(new StringBuilder("/shaders/world").append(llllllllllllllllllIlIIlIIllIlIll));
            collectShaderOptions(llllllllllllllllllIlIIlIIllIIllI, llllllllllllllllllIlIIlIIllIlIlI, llllllllllllllllllIlIIlIIllIllll, llllllllllllllllllIlIIlIIllIllIl);
        }
        final Collection<ShaderOption> llllllllllllllllllIlIIlIIllIlIIl = llllllllllllllllllIlIIlIIllIllIl.values();
        final ShaderOption[] llllllllllllllllllIlIIlIIllIlIII = llllllllllllllllllIlIIlIIllIlIIl.toArray(new ShaderOption[llllllllllllllllllIlIIlIIllIlIIl.size()]);
        final Comparator<ShaderOption> llllllllllllllllllIlIIlIIllIIlll = new Comparator<ShaderOption>() {
            @Override
            public int compare(final ShaderOption lllllllllllllllllIIIlIlllIllIlII, final ShaderOption lllllllllllllllllIIIlIlllIllIIIl) {
                return lllllllllllllllllIIIlIlllIllIlII.getName().compareToIgnoreCase(lllllllllllllllllIIIlIlllIllIIIl.getName());
            }
        };
        Arrays.sort(llllllllllllllllllIlIIlIIllIlIII, llllllllllllllllllIlIIlIIllIIlll);
        return llllllllllllllllllIlIIlIIllIlIII;
    }
    
    private static String[] findExtensions(final String llllllllllllllllllIlIIIlIIIlIIIl, final String[] llllllllllllllllllIlIIIlIIIIlIlI) {
        final List<String> llllllllllllllllllIlIIIlIIIIllll = new ArrayList<String>();
        for (int llllllllllllllllllIlIIIlIIIIlllI = 0; llllllllllllllllllIlIIIlIIIIlllI < llllllllllllllllllIlIIIlIIIIlIlI.length; ++llllllllllllllllllIlIIIlIIIIlllI) {
            final String llllllllllllllllllIlIIIlIIIIllIl = llllllllllllllllllIlIIIlIIIIlIlI[llllllllllllllllllIlIIIlIIIIlllI];
            if (llllllllllllllllllIlIIIlIIIlIIIl.contains(llllllllllllllllllIlIIIlIIIIllIl)) {
                llllllllllllllllllIlIIIlIIIIllll.add(llllllllllllllllllIlIIIlIIIIllIl);
            }
        }
        final String[] llllllllllllllllllIlIIIlIIIIllII = llllllllllllllllllIlIIIlIIIIllll.toArray(new String[llllllllllllllllllIlIIIlIIIIllll.size()]);
        return llllllllllllllllllIlIIIlIIIIllII;
    }
    
    public static Set<String> parseOptionSliders(final Properties llllllllllllllllllIlIIIlllIlIIlI, final ShaderOption[] llllllllllllllllllIlIIIlllIlIIIl) {
        final Set<String> llllllllllllllllllIlIIIlllIllIII = new HashSet<String>();
        final String llllllllllllllllllIlIIIlllIlIlll = llllllllllllllllllIlIIIlllIlIIlI.getProperty("sliders");
        if (llllllllllllllllllIlIIIlllIlIlll == null) {
            return llllllllllllllllllIlIIIlllIllIII;
        }
        final String[] llllllllllllllllllIlIIIlllIlIllI = Config.tokenize(llllllllllllllllllIlIIIlllIlIlll, " ");
        for (int llllllllllllllllllIlIIIlllIlIlIl = 0; llllllllllllllllllIlIIIlllIlIlIl < llllllllllllllllllIlIIIlllIlIllI.length; ++llllllllllllllllllIlIIIlllIlIlIl) {
            final String llllllllllllllllllIlIIIlllIlIlII = llllllllllllllllllIlIIIlllIlIllI[llllllllllllllllllIlIIIlllIlIlIl];
            final ShaderOption llllllllllllllllllIlIIIlllIlIIll = ShaderUtils.getShaderOption(llllllllllllllllllIlIIIlllIlIlII, llllllllllllllllllIlIIIlllIlIIIl);
            if (llllllllllllllllllIlIIIlllIlIIll == null) {
                Config.warn(String.valueOf(new StringBuilder("Invalid shader option: ").append(llllllllllllllllllIlIIIlllIlIlII)));
            }
            else {
                llllllllllllllllllIlIIIlllIllIII.add(llllllllllllllllllIlIIIlllIlIlII);
            }
        }
        return llllllllllllllllllIlIIIlllIllIII;
    }
    
    public static Map<String, ScreenShaderOptions> parseGuiScreens(final Properties llllllllllllllllllIlIIIllIIlIIII, final ShaderProfile[] llllllllllllllllllIlIIIllIIIlIll, final ShaderOption[] llllllllllllllllllIlIIIllIIIlIlI) {
        final Map<String, ScreenShaderOptions> llllllllllllllllllIlIIIllIIIllIl = new HashMap<String, ScreenShaderOptions>();
        parseGuiScreen("screen", llllllllllllllllllIlIIIllIIlIIII, llllllllllllllllllIlIIIllIIIllIl, llllllllllllllllllIlIIIllIIIlIll, llllllllllllllllllIlIIIllIIIlIlI);
        return llllllllllllllllllIlIIIllIIIllIl.isEmpty() ? null : llllllllllllllllllIlIIIllIIIllIl;
    }
    
    private static void collectShaderOptions(final IShaderPack llllllllllllllllllIlIIlIIlIlIllI, final String llllllllllllllllllIlIIlIIlIlIlIl, final String[] llllllllllllllllllIlIIlIIlIlIlII, final Map<String, ShaderOption> llllllllllllllllllIlIIlIIlIIlIll) {
        for (int llllllllllllllllllIlIIlIIlIlIIlI = 0; llllllllllllllllllIlIIlIIlIlIIlI < llllllllllllllllllIlIIlIIlIlIlII.length; ++llllllllllllllllllIlIIlIIlIlIIlI) {
            final String llllllllllllllllllIlIIlIIlIlIIIl = llllllllllllllllllIlIIlIIlIlIlII[llllllllllllllllllIlIIlIIlIlIIlI];
            if (!llllllllllllllllllIlIIlIIlIlIIIl.equals("")) {
                final String llllllllllllllllllIlIIlIIlIlIIII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIlIIlIIlIlIlIl)).append("/").append(llllllllllllllllllIlIIlIIlIlIIIl).append(".vsh"));
                final String llllllllllllllllllIlIIlIIlIIllll = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIlIIlIIlIlIlIl)).append("/").append(llllllllllllllllllIlIIlIIlIlIIIl).append(".fsh"));
                collectShaderOptions(llllllllllllllllllIlIIlIIlIlIllI, llllllllllllllllllIlIIlIIlIlIIII, llllllllllllllllllIlIIlIIlIIlIll);
                collectShaderOptions(llllllllllllllllllIlIIlIIlIlIllI, llllllllllllllllllIlIIlIIlIIllll, llllllllllllllllllIlIIlIIlIIlIll);
            }
        }
    }
    
    private static void collectShaderOptions(final IShaderPack llllllllllllllllllIlIIlIIIllIlII, final String llllllllllllllllllIlIIlIIIllIIll, final Map<String, ShaderOption> llllllllllllllllllIlIIlIIIllIIlI) {
        final String[] llllllllllllllllllIlIIlIIIlllIlI = getLines(llllllllllllllllllIlIIlIIIllIlII, llllllllllllllllllIlIIlIIIllIIll);
        for (int llllllllllllllllllIlIIlIIIlllIIl = 0; llllllllllllllllllIlIIlIIIlllIIl < llllllllllllllllllIlIIlIIIlllIlI.length; ++llllllllllllllllllIlIIlIIIlllIIl) {
            final String llllllllllllllllllIlIIlIIIlllIII = llllllllllllllllllIlIIlIIIlllIlI[llllllllllllllllllIlIIlIIIlllIIl];
            final ShaderOption llllllllllllllllllIlIIlIIIllIlll = getShaderOption(llllllllllllllllllIlIIlIIIlllIII, llllllllllllllllllIlIIlIIIllIIll);
            if (llllllllllllllllllIlIIlIIIllIlll != null && !llllllllllllllllllIlIIlIIIllIlll.getName().startsWith(ShaderMacros.getPrefixMacro()) && (!llllllllllllllllllIlIIlIIIllIlll.checkUsed() || isOptionUsed(llllllllllllllllllIlIIlIIIllIlll, llllllllllllllllllIlIIlIIIlllIlI))) {
                final String llllllllllllllllllIlIIlIIIllIllI = llllllllllllllllllIlIIlIIIllIlll.getName();
                final ShaderOption llllllllllllllllllIlIIlIIIllIlIl = llllllllllllllllllIlIIlIIIllIIlI.get(llllllllllllllllllIlIIlIIIllIllI);
                if (llllllllllllllllllIlIIlIIIllIlIl != null) {
                    if (!Config.equals(llllllllllllllllllIlIIlIIIllIlIl.getValueDefault(), llllllllllllllllllIlIIlIIIllIlll.getValueDefault())) {
                        Config.warn(String.valueOf(new StringBuilder("Ambiguous shader option: ").append(llllllllllllllllllIlIIlIIIllIlll.getName())));
                        Config.warn(String.valueOf(new StringBuilder(" - in ").append(Config.arrayToString(llllllllllllllllllIlIIlIIIllIlIl.getPaths())).append(": ").append(llllllllllllllllllIlIIlIIIllIlIl.getValueDefault())));
                        Config.warn(String.valueOf(new StringBuilder(" - in ").append(Config.arrayToString(llllllllllllllllllIlIIlIIIllIlll.getPaths())).append(": ").append(llllllllllllllllllIlIIlIIIllIlll.getValueDefault())));
                        llllllllllllllllllIlIIlIIIllIlIl.setEnabled(false);
                    }
                    if (llllllllllllllllllIlIIlIIIllIlIl.getDescription() == null || llllllllllllllllllIlIIlIIIllIlIl.getDescription().length() <= 0) {
                        llllllllllllllllllIlIIlIIIllIlIl.setDescription(llllllllllllllllllIlIIlIIIllIlll.getDescription());
                    }
                    llllllllllllllllllIlIIlIIIllIlIl.addPaths(llllllllllllllllllIlIIlIIIllIlll.getPaths());
                }
                else {
                    llllllllllllllllllIlIIlIIIllIIlI.put(llllllllllllllllllIlIIlIIIllIllI, llllllllllllllllllIlIIlIIIllIlll);
                }
            }
        }
    }
    
    private static boolean isOptionUsed(final ShaderOption llllllllllllllllllIlIIlIIIlIIIll, final String[] llllllllllllllllllIlIIlIIIlIIllI) {
        for (int llllllllllllllllllIlIIlIIIlIIlIl = 0; llllllllllllllllllIlIIlIIIlIIlIl < llllllllllllllllllIlIIlIIIlIIllI.length; ++llllllllllllllllllIlIIlIIIlIIlIl) {
            final String llllllllllllllllllIlIIlIIIlIIlII = llllllllllllllllllIlIIlIIIlIIllI[llllllllllllllllllIlIIlIIIlIIlIl];
            if (llllllllllllllllllIlIIlIIIlIIIll.isUsedInLine(llllllllllllllllllIlIIlIIIlIIlII)) {
                return true;
            }
        }
        return false;
    }
    
    private static Set<String> makeSetConstNames() {
        final Set<String> llllllllllllllllllIlIIlIIIIIIIlI = new HashSet<String>();
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowMapResolution");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowMapFov");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowDistance");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowDistanceRenderMul");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowIntervalSize");
        llllllllllllllllllIlIIlIIIIIIIlI.add("generateShadowMipmap");
        llllllllllllllllllIlIIlIIIIIIIlI.add("generateShadowColorMipmap");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowHardwareFiltering");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowHardwareFiltering0");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowHardwareFiltering1");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowtex0Mipmap");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowtexMipmap");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowtex1Mipmap");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowcolor0Mipmap");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowColor0Mipmap");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowcolor1Mipmap");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowColor1Mipmap");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowtex0Nearest");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowtexNearest");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadow0MinMagNearest");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowtex1Nearest");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadow1MinMagNearest");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowcolor0Nearest");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowColor0Nearest");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowColor0MinMagNearest");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowcolor1Nearest");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowColor1Nearest");
        llllllllllllllllllIlIIlIIIIIIIlI.add("shadowColor1MinMagNearest");
        llllllllllllllllllIlIIlIIIIIIIlI.add("wetnessHalflife");
        llllllllllllllllllIlIIlIIIIIIIlI.add("drynessHalflife");
        llllllllllllllllllIlIIlIIIIIIIlI.add("eyeBrightnessHalflife");
        llllllllllllllllllIlIIlIIIIIIIlI.add("centerDepthHalflife");
        llllllllllllllllllIlIIlIIIIIIIlI.add("sunPathRotation");
        llllllllllllllllllIlIIlIIIIIIIlI.add("ambientOcclusionLevel");
        llllllllllllllllllIlIIlIIIIIIIlI.add("superSamplingLevel");
        llllllllllllllllllIlIIlIIIIIIIlI.add("noiseTextureResolution");
        return llllllllllllllllllIlIIlIIIIIIIlI;
    }
    
    private static ShaderProfile parseProfile(final String llllllllllllllllllIlIIIllIlllIlI, final Properties llllllllllllllllllIlIIIllIlllIIl, final Set<String> llllllllllllllllllIlIIIllIlIIIlI, final ShaderOption[] llllllllllllllllllIlIIIllIllIlll) {
        final String llllllllllllllllllIlIIIllIllIllI = "profile.";
        final String llllllllllllllllllIlIIIllIllIlIl = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIlIIIllIllIllI)).append(llllllllllllllllllIlIIIllIlllIlI));
        if (llllllllllllllllllIlIIIllIlIIIlI.contains(llllllllllllllllllIlIIIllIllIlIl)) {
            Config.warn(String.valueOf(new StringBuilder("[Shaders] Profile already parsed: ").append(llllllllllllllllllIlIIIllIlllIlI)));
            return null;
        }
        llllllllllllllllllIlIIIllIlIIIlI.add(llllllllllllllllllIlIIIllIlllIlI);
        final ShaderProfile llllllllllllllllllIlIIIllIllIlII = new ShaderProfile(llllllllllllllllllIlIIIllIlllIlI);
        final String llllllllllllllllllIlIIIllIllIIll = llllllllllllllllllIlIIIllIlllIIl.getProperty(llllllllllllllllllIlIIIllIllIlIl);
        final String[] llllllllllllllllllIlIIIllIllIIlI = Config.tokenize(llllllllllllllllllIlIIIllIllIIll, " ");
        for (int llllllllllllllllllIlIIIllIllIIIl = 0; llllllllllllllllllIlIIIllIllIIIl < llllllllllllllllllIlIIIllIllIIlI.length; ++llllllllllllllllllIlIIIllIllIIIl) {
            final String llllllllllllllllllIlIIIllIllIIII = llllllllllllllllllIlIIIllIllIIlI[llllllllllllllllllIlIIIllIllIIIl];
            if (llllllllllllllllllIlIIIllIllIIII.startsWith(llllllllllllllllllIlIIIllIllIllI)) {
                final String llllllllllllllllllIlIIIllIlIllll = llllllllllllllllllIlIIIllIllIIII.substring(llllllllllllllllllIlIIIllIllIllI.length());
                final ShaderProfile llllllllllllllllllIlIIIllIlIlllI = parseProfile(llllllllllllllllllIlIIIllIlIllll, llllllllllllllllllIlIIIllIlllIIl, llllllllllllllllllIlIIIllIlIIIlI, llllllllllllllllllIlIIIllIllIlll);
                if (llllllllllllllllllIlIIIllIllIlII != null) {
                    llllllllllllllllllIlIIIllIllIlII.addOptionValues(llllllllllllllllllIlIIIllIlIlllI);
                    llllllllllllllllllIlIIIllIllIlII.addDisabledPrograms(llllllllllllllllllIlIIIllIlIlllI.getDisabledPrograms());
                }
            }
            else {
                final String[] llllllllllllllllllIlIIIllIlIllIl = Config.tokenize(llllllllllllllllllIlIIIllIllIIII, ":=");
                if (llllllllllllllllllIlIIIllIlIllIl.length == 1) {
                    String llllllllllllllllllIlIIIllIlIllII = llllllllllllllllllIlIIIllIlIllIl[0];
                    boolean llllllllllllllllllIlIIIllIlIlIll = true;
                    if (llllllllllllllllllIlIIIllIlIllII.startsWith("!")) {
                        llllllllllllllllllIlIIIllIlIlIll = false;
                        llllllllllllllllllIlIIIllIlIllII = llllllllllllllllllIlIIIllIlIllII.substring(1);
                    }
                    final String llllllllllllllllllIlIIIllIlIlIlI = "program.";
                    if (!llllllllllllllllllIlIIIllIlIlIll && llllllllllllllllllIlIIIllIlIllII.startsWith("program.")) {
                        final String llllllllllllllllllIlIIIllIlIlIIl = llllllllllllllllllIlIIIllIlIllII.substring(llllllllllllllllllIlIIIllIlIlIlI.length());
                        if (!Shaders.isProgramPath(llllllllllllllllllIlIIIllIlIlIIl)) {
                            Config.warn(String.valueOf(new StringBuilder("Invalid program: ").append(llllllllllllllllllIlIIIllIlIlIIl).append(" in profile: ").append(llllllllllllllllllIlIIIllIllIlII.getName())));
                        }
                        else {
                            llllllllllllllllllIlIIIllIllIlII.addDisabledProgram(llllllllllllllllllIlIIIllIlIlIIl);
                        }
                    }
                    else {
                        final ShaderOption llllllllllllllllllIlIIIllIlIlIII = ShaderUtils.getShaderOption(llllllllllllllllllIlIIIllIlIllII, llllllllllllllllllIlIIIllIllIlll);
                        if (!(llllllllllllllllllIlIIIllIlIlIII instanceof ShaderOptionSwitch)) {
                            Config.warn(String.valueOf(new StringBuilder("[Shaders] Invalid option: ").append(llllllllllllllllllIlIIIllIlIllII)));
                        }
                        else {
                            llllllllllllllllllIlIIIllIllIlII.addOptionValue(llllllllllllllllllIlIIIllIlIllII, String.valueOf(llllllllllllllllllIlIIIllIlIlIll));
                            llllllllllllllllllIlIIIllIlIlIII.setVisible(true);
                        }
                    }
                }
                else if (llllllllllllllllllIlIIIllIlIllIl.length != 2) {
                    Config.warn(String.valueOf(new StringBuilder("[Shaders] Invalid option value: ").append(llllllllllllllllllIlIIIllIllIIII)));
                }
                else {
                    final String llllllllllllllllllIlIIIllIlIIlll = llllllllllllllllllIlIIIllIlIllIl[0];
                    final String llllllllllllllllllIlIIIllIlIIllI = llllllllllllllllllIlIIIllIlIllIl[1];
                    final ShaderOption llllllllllllllllllIlIIIllIlIIlIl = ShaderUtils.getShaderOption(llllllllllllllllllIlIIIllIlIIlll, llllllllllllllllllIlIIIllIllIlll);
                    if (llllllllllllllllllIlIIIllIlIIlIl == null) {
                        Config.warn(String.valueOf(new StringBuilder("[Shaders] Invalid option: ").append(llllllllllllllllllIlIIIllIllIIII)));
                    }
                    else if (!llllllllllllllllllIlIIIllIlIIlIl.isValidValue(llllllllllllllllllIlIIIllIlIIllI)) {
                        Config.warn(String.valueOf(new StringBuilder("[Shaders] Invalid value: ").append(llllllllllllllllllIlIIIllIllIIII)));
                    }
                    else {
                        llllllllllllllllllIlIIIllIlIIlIl.setVisible(true);
                        llllllllllllllllllIlIIIllIllIlII.addOptionValue(llllllllllllllllllIlIIIllIlIIlll, llllllllllllllllllIlIIIllIlIIllI);
                    }
                }
            }
        }
        return llllllllllllllllllIlIIIllIllIlII;
    }
    
    static {
        PATTERN_VERSION = Pattern.compile("^\\s*#version\\s+.*$");
        PATTERN_INCLUDE = Pattern.compile("^\\s*#include\\s+\"([A-Za-z0-9_/\\.]+)\".*$");
        setConstNames = makeSetConstNames();
    }
}
