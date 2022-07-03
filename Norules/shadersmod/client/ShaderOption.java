package shadersmod.client;

import java.util.*;
import optifine.*;

public abstract class ShaderOption
{
    private /* synthetic */ String[] values;
    private /* synthetic */ String valueDefault;
    private /* synthetic */ String description;
    private /* synthetic */ String value;
    private /* synthetic */ String[] paths;
    private /* synthetic */ String name;
    private /* synthetic */ boolean visible;
    private /* synthetic */ boolean enabled;
    
    public void setEnabled(final boolean llllllllllllllIIlllIIllllllIlIll) {
        this.enabled = llllllllllllllIIlllIIllllllIlIll;
    }
    
    public void addPaths(final String[] llllllllllllllIIlllIIlllllllIlll) {
        final List<String> llllllllllllllIIlllIIllllllllIll = Arrays.asList(this.paths);
        for (int llllllllllllllIIlllIIllllllllIlI = 0; llllllllllllllIIlllIIllllllllIlI < llllllllllllllIIlllIIlllllllIlll.length; ++llllllllllllllIIlllIIllllllllIlI) {
            final String llllllllllllllIIlllIIllllllllIIl = llllllllllllllIIlllIIlllllllIlll[llllllllllllllIIlllIIllllllllIlI];
            if (!llllllllllllllIIlllIIllllllllIll.contains(llllllllllllllIIlllIIllllllllIIl)) {
                this.paths = (String[])Config.addObjectToArray(this.paths, llllllllllllllIIlllIIllllllllIIl);
            }
        }
    }
    
    private static int getIndex(final String llllllllllllllIIlllIlIIIIIIlIIlI, final String[] llllllllllllllIIlllIlIIIIIIlIIII) {
        for (int llllllllllllllIIlllIlIIIIIIIlllI = 0; llllllllllllllIIlllIlIIIIIIIlllI < llllllllllllllIIlllIlIIIIIIlIIII.length; ++llllllllllllllIIlllIlIIIIIIIlllI) {
            final String llllllllllllllIIlllIlIIIIIIIllII = llllllllllllllIIlllIlIIIIIIlIIII[llllllllllllllIIlllIlIIIIIIIlllI];
            if (llllllllllllllIIlllIlIIIIIIIllII.equals(llllllllllllllIIlllIlIIIIIIlIIlI)) {
                return llllllllllllllIIlllIlIIIIIIIlllI;
            }
        }
        return -1;
    }
    
    public boolean isUsedInLine(final String llllllllllllllIIlllIIlllllIIlIIl) {
        return false;
    }
    
    public void resetValue() {
        this.value = this.valueDefault;
    }
    
    public boolean setValue(final String llllllllllllllIIlllIlIIIIlIIlIIl) {
        final int llllllllllllllIIlllIlIIIIlIIlIll = getIndex(llllllllllllllIIlllIlIIIIlIIlIIl, this.values);
        if (llllllllllllllIIlllIlIIIIlIIlIll < 0) {
            return false;
        }
        this.value = llllllllllllllIIlllIlIIIIlIIlIIl;
        return true;
    }
    
    public String getSourceLine() {
        return null;
    }
    
    public String getValue() {
        return this.value;
    }
    
    public boolean matchesLine(final String llllllllllllllIIlllIIlllllIIllII) {
        return false;
    }
    
    public ShaderOption(final String llllllllllllllIIlllIlIIIIlllIIlI, final String llllllllllllllIIlllIlIIIIlllIIIl, final String llllllllllllllIIlllIlIIIIlllIIII, final String[] llllllllllllllIIlllIlIIIIllIlIII, final String llllllllllllllIIlllIlIIIIllIIlll, final String llllllllllllllIIlllIlIIIIllIllIl) {
        this.name = null;
        this.description = null;
        this.value = null;
        this.values = null;
        this.valueDefault = null;
        this.paths = null;
        this.enabled = true;
        this.visible = true;
        this.name = llllllllllllllIIlllIlIIIIlllIIlI;
        this.description = llllllllllllllIIlllIlIIIIlllIIIl;
        this.value = llllllllllllllIIlllIlIIIIlllIIII;
        this.values = llllllllllllllIIlllIlIIIIllIlIII;
        this.valueDefault = llllllllllllllIIlllIlIIIIllIIlll;
        if (llllllllllllllIIlllIlIIIIllIllIl != null) {
            this.paths = new String[] { llllllllllllllIIlllIlIIIIllIllIl };
        }
    }
    
    public String getNameText() {
        return Shaders.translate(String.valueOf(new StringBuilder("option.").append(this.name)), this.name);
    }
    
    public String getValueDefault() {
        return this.valueDefault;
    }
    
    public void setIndexNormalized(float llllllllllllllIIlllIIllllIllIlII) {
        if (this.values.length > 1) {
            llllllllllllllIIlllIIllllIllIlII = Config.limit(llllllllllllllIIlllIIllllIllIlII, 0.0f, 1.0f);
            final int llllllllllllllIIlllIIllllIllIllI = Math.round(llllllllllllllIIlllIIllllIllIlII * (this.values.length - 1));
            this.value = this.values[llllllllllllllIIlllIIllllIllIllI];
        }
    }
    
    public String getValueColor(final String llllllllllllllIIlllIIlllllIIlllI) {
        return "";
    }
    
    public float getIndexNormalized() {
        if (this.values.length <= 1) {
            return 0.0f;
        }
        final int llllllllllllllIIlllIIlllllIIIIII = getIndex(this.value, this.values);
        if (llllllllllllllIIlllIIlllllIIIIII < 0) {
            return 0.0f;
        }
        final float llllllllllllllIIlllIIllllIllllll = 1.0f * llllllllllllllIIlllIIlllllIIIIII / (this.values.length - 1.0f);
        return llllllllllllllIIlllIIllllIllllll;
    }
    
    public String[] getValues() {
        return this.values.clone();
    }
    
    public boolean isEnabled() {
        return this.enabled;
    }
    
    public void prevValue() {
        int llllllllllllllIIlllIlIIIIIlIIIll = getIndex(this.value, this.values);
        if (llllllllllllllIIlllIlIIIIIlIIIll >= 0) {
            llllllllllllllIIlllIlIIIIIlIIIll = (llllllllllllllIIlllIlIIIIIlIIIll - 1 + this.values.length) % this.values.length;
            this.value = this.values[llllllllllllllIIlllIlIIIIIlIIIll];
        }
    }
    
    public void setDescription(final String llllllllllllllIIlllIlIIIIlIlIlII) {
        this.description = llllllllllllllIIlllIlIIIIlIlIlII;
    }
    
    public String getDescriptionText() {
        String llllllllllllllIIlllIlIIIIlIlllII = Config.normalize(this.description);
        llllllllllllllIIlllIlIIIIlIlllII = StrUtils.removePrefix(llllllllllllllIIlllIlIIIIlIlllII, "//");
        llllllllllllllIIlllIlIIIIlIlllII = Shaders.translate(String.valueOf(new StringBuilder("option.").append(this.getName()).append(".comment")), llllllllllllllIIlllIlIIIIlIlllII);
        return llllllllllllllIIlllIlIIIIlIlllII;
    }
    
    public void nextValue() {
        int llllllllllllllIIlllIlIIIIIllIIII = getIndex(this.value, this.values);
        if (llllllllllllllIIlllIlIIIIIllIIII >= 0) {
            llllllllllllllIIlllIlIIIIIllIIII = (llllllllllllllIIlllIlIIIIIllIIII + 1) % this.values.length;
            this.value = this.values[llllllllllllllIIlllIlIIIIIllIIII];
        }
    }
    
    public boolean isVisible() {
        return this.visible;
    }
    
    public boolean checkUsed() {
        return false;
    }
    
    public String[] getPaths() {
        return this.paths;
    }
    
    public boolean isChanged() {
        return !Config.equals(this.value, this.valueDefault);
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.name).append(", value: ").append(this.value).append(", valueDefault: ").append(this.valueDefault).append(", paths: ").append(Config.arrayToString(this.paths)));
    }
    
    public void setVisible(final boolean llllllllllllllIIlllIIlllllIlllll) {
        this.visible = llllllllllllllIIlllIIlllllIlllll;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public String getName() {
        return this.name;
    }
    
    public boolean isValidValue(final String llllllllllllllIIlllIIlllllIllIll) {
        return getIndex(llllllllllllllIIlllIIlllllIllIll, this.values) >= 0;
    }
    
    static {
        COLOR_RED = "§c";
        COLOR_BLUE = "§9";
        COLOR_GREEN = "§a";
    }
    
    public String getValueText(final String llllllllllllllIIlllIIlllllIlIIlI) {
        return Shaders.translate(String.valueOf(new StringBuilder("value.").append(this.name).append(".").append(llllllllllllllIIlllIIlllllIlIIlI)), llllllllllllllIIlllIIlllllIlIIlI);
    }
}
