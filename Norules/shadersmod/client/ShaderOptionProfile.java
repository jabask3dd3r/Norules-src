package shadersmod.client;

import optifine.*;
import java.util.*;

public class ShaderOptionProfile extends ShaderOption
{
    private /* synthetic */ ShaderProfile[] profiles;
    private /* synthetic */ ShaderOption[] options;
    
    private static String detectProfileName(final ShaderProfile[] llllllllllllllIIlIlIlIllllIlIlll, final ShaderOption[] llllllllllllllIIlIlIlIllllIlIllI, final boolean llllllllllllllIIlIlIlIllllIlIlIl) {
        final ShaderProfile llllllllllllllIIlIlIlIllllIllIII = ShaderUtils.detectProfile(llllllllllllllIIlIlIlIllllIlIlll, llllllllllllllIIlIlIlIllllIlIllI, llllllllllllllIIlIlIlIllllIlIlIl);
        return (llllllllllllllIIlIlIlIllllIllIII == null) ? "<custom>" : llllllllllllllIIlIlIlIllllIllIII.getName();
    }
    
    @Override
    public String getValueText(final String llllllllllllllIIlIlIlIlllllIlIll) {
        return llllllllllllllIIlIlIlIlllllIlIll.equals("<custom>") ? Lang.get("of.general.custom", "<custom>") : Shaders.translate(String.valueOf(new StringBuilder("profile.").append(llllllllllllllIIlIlIlIlllllIlIll)), llllllllllllllIIlIlIlIlllllIlIll);
    }
    
    public ShaderOptionProfile(final ShaderProfile[] llllllllllllllIIlIlIllIIIIlIlIIl, final ShaderOption[] llllllllllllllIIlIlIllIIIIlIlIll) {
        super("<profile>", "", detectProfileName(llllllllllllllIIlIlIllIIIIlIlIIl, llllllllllllllIIlIlIllIIIIlIlIll), getProfileNames(llllllllllllllIIlIlIllIIIIlIlIIl), detectProfileName(llllllllllllllIIlIlIllIIIIlIlIIl, llllllllllllllIIlIlIllIIIIlIlIll, true), null);
        this.profiles = null;
        this.options = null;
        this.profiles = llllllllllllllIIlIlIllIIIIlIlIIl;
        this.options = llllllllllllllIIlIlIllIIIIlIlIll;
    }
    
    private static String[] getProfileNames(final ShaderProfile[] llllllllllllllIIlIlIlIllllIIllll) {
        final List<String> llllllllllllllIIlIlIlIllllIIlllI = new ArrayList<String>();
        for (int llllllllllllllIIlIlIlIllllIIllIl = 0; llllllllllllllIIlIlIlIllllIIllIl < llllllllllllllIIlIlIlIllllIIllll.length; ++llllllllllllllIIlIlIlIllllIIllIl) {
            final ShaderProfile llllllllllllllIIlIlIlIllllIIllII = llllllllllllllIIlIlIlIllllIIllll[llllllllllllllIIlIlIlIllllIIllIl];
            llllllllllllllIIlIlIlIllllIIlllI.add(llllllllllllllIIlIlIlIllllIIllII.getName());
        }
        llllllllllllllIIlIlIlIllllIIlllI.add("<custom>");
        final String[] llllllllllllllIIlIlIlIllllIIlIll = llllllllllllllIIlIlIlIllllIIlllI.toArray(new String[llllllllllllllIIlIlIlIllllIIlllI.size()]);
        return llllllllllllllIIlIlIlIllllIIlIll;
    }
    
    public void updateProfile() {
        final ShaderProfile llllllllllllllIIlIlIllIIIIlIIIII = this.getProfile(this.getValue());
        if (llllllllllllllIIlIlIllIIIIlIIIII == null || !ShaderUtils.matchProfile(llllllllllllllIIlIlIllIIIIlIIIII, this.options, false)) {
            final String llllllllllllllIIlIlIllIIIIIlllll = detectProfileName(this.profiles, this.options);
            this.setValue(llllllllllllllIIlIlIllIIIIIlllll);
        }
    }
    
    @Override
    public String getValueColor(final String llllllllllllllIIlIlIlIlllllIIllI) {
        return llllllllllllllIIlIlIlIlllllIIllI.equals("<custom>") ? "§c" : "§a";
    }
    
    @Override
    public String getNameText() {
        return Lang.get("of.shaders.profile");
    }
    
    @Override
    public void nextValue() {
        super.nextValue();
        if (this.getValue().equals("<custom>")) {
            super.nextValue();
        }
        this.applyProfileOptions();
    }
    
    private ShaderProfile getProfile(final String llllllllllllllIIlIlIlIllllllIIIl) {
        for (int llllllllllllllIIlIlIlIllllllIlII = 0; llllllllllllllIIlIlIlIllllllIlII < this.profiles.length; ++llllllllllllllIIlIlIlIllllllIlII) {
            final ShaderProfile llllllllllllllIIlIlIlIllllllIIll = this.profiles[llllllllllllllIIlIlIlIllllllIlII];
            if (llllllllllllllIIlIlIlIllllllIIll.getName().equals(llllllllllllllIIlIlIlIllllllIIIl)) {
                return llllllllllllllIIlIlIlIllllllIIll;
            }
        }
        return null;
    }
    
    private ShaderOption getOption(final String llllllllllllllIIlIlIlIllllllllIl) {
        for (int llllllllllllllIIlIlIllIIIIIIIIII = 0; llllllllllllllIIlIlIllIIIIIIIIII < this.options.length; ++llllllllllllllIIlIlIllIIIIIIIIII) {
            final ShaderOption llllllllllllllIIlIlIlIllllllllll = this.options[llllllllllllllIIlIlIllIIIIIIIIII];
            if (llllllllllllllIIlIlIlIllllllllll.getName().equals(llllllllllllllIIlIlIlIllllllllIl)) {
                return llllllllllllllIIlIlIlIllllllllll;
            }
        }
        return null;
    }
    
    private void applyProfileOptions() {
        final ShaderProfile llllllllllllllIIlIlIllIIIIIlIIll = this.getProfile(this.getValue());
        if (llllllllllllllIIlIlIllIIIIIlIIll != null) {
            final String[] llllllllllllllIIlIlIllIIIIIlIIlI = llllllllllllllIIlIlIllIIIIIlIIll.getOptions();
            for (int llllllllllllllIIlIlIllIIIIIlIIIl = 0; llllllllllllllIIlIlIllIIIIIlIIIl < llllllllllllllIIlIlIllIIIIIlIIlI.length; ++llllllllllllllIIlIlIllIIIIIlIIIl) {
                final String llllllllllllllIIlIlIllIIIIIlIIII = llllllllllllllIIlIlIllIIIIIlIIlI[llllllllllllllIIlIlIllIIIIIlIIIl];
                final ShaderOption llllllllllllllIIlIlIllIIIIIIllll = this.getOption(llllllllllllllIIlIlIllIIIIIlIIII);
                if (llllllllllllllIIlIlIllIIIIIIllll != null) {
                    final String llllllllllllllIIlIlIllIIIIIIlllI = llllllllllllllIIlIlIllIIIIIlIIll.getValue(llllllllllllllIIlIlIllIIIIIlIIII);
                    llllllllllllllIIlIlIllIIIIIIllll.setValue(llllllllllllllIIlIlIllIIIIIIlllI);
                }
            }
        }
    }
    
    private static String detectProfileName(final ShaderProfile[] llllllllllllllIIlIlIlIlllllIIIll, final ShaderOption[] llllllllllllllIIlIlIlIlllllIIIII) {
        return detectProfileName(llllllllllllllIIlIlIlIlllllIIIll, llllllllllllllIIlIlIlIlllllIIIII, false);
    }
    
    static {
        NAME_PROFILE = "<profile>";
        VALUE_CUSTOM = "<custom>";
    }
}
