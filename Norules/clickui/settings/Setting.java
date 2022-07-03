package clickui.settings;

import me.nrules.module.*;
import java.util.*;
import java.util.function.*;

public class Setting
{
    private /* synthetic */ double max;
    public /* synthetic */ boolean percentage;
    private /* synthetic */ boolean comboExpand;
    private /* synthetic */ Enum svalEnum;
    private /* synthetic */ String name;
    private /* synthetic */ String sval;
    private /* synthetic */ String dString;
    private /* synthetic */ boolean onlyint;
    public /* synthetic */ String mode;
    private /* synthetic */ Supplier<Boolean> visibility;
    private /* synthetic */ Module parent;
    private /* synthetic */ double dval;
    private /* synthetic */ Enum optionEnum;
    private /* synthetic */ ArrayList<String> options;
    private /* synthetic */ int index;
    private /* synthetic */ double min;
    private /* synthetic */ boolean bval;
    
    public boolean isComboExpand() {
        return this.comboExpand;
    }
    
    public String getdString() {
        return this.dString;
    }
    
    public Setting(final String lllllllllllllIllllllIllIIIlllIIl, final Module lllllllllllllIllllllIllIIIlllIII, final String lllllllllllllIllllllIllIIIllIlll, final ArrayList<String> lllllllllllllIllllllIllIIIllIllI, final Supplier<Boolean> lllllllllllllIllllllIllIIIllIlIl) {
        this.index = 0;
        this.onlyint = false;
        this.name = lllllllllllllIllllllIllIIIlllIIl;
        this.parent = lllllllllllllIllllllIllIIIlllIII;
        this.sval = lllllllllllllIllllllIllIIIllIlll;
        this.svalEnum = null;
        this.options = lllllllllllllIllllllIllIIIllIllI;
        this.optionEnum = null;
        this.comboExpand = false;
        this.mode = "Combo";
        this.visibility = lllllllllllllIllllllIllIIIllIlIl;
    }
    
    public void setValStringNoSave(final String lllllllllllllIllllllIlIlIllIIIII) {
        this.sval = lllllllllllllIllllllIlIlIllIIIII;
    }
    
    public void setValString(final String lllllllllllllIllllllIlIlIllIlIII) {
        this.sval = lllllllllllllIllllllIlIlIllIlIII;
    }
    
    public boolean isString() {
        return this.mode.equalsIgnoreCase("String");
    }
    
    public Setting(final String lllllllllllllIllllllIlIllllllIll, final Module lllllllllllllIllllllIlIlllllIIlI, final double lllllllllllllIllllllIlIllllllIIl, final double lllllllllllllIllllllIlIllllllIII, final double lllllllllllllIllllllIlIllllIllll, final boolean lllllllllllllIllllllIlIllllIlllI, final Supplier<Boolean> lllllllllllllIllllllIlIlllllIlIl) {
        this.index = 0;
        this.onlyint = false;
        this.name = lllllllllllllIllllllIlIllllllIll;
        this.parent = lllllllllllllIllllllIlIlllllIIlI;
        this.dval = lllllllllllllIllllllIlIllllllIIl;
        this.min = lllllllllllllIllllllIlIllllllIII;
        this.max = lllllllllllllIllllllIlIllllIllll;
        this.onlyint = lllllllllllllIllllllIlIllllIlllI;
        this.mode = "Slider";
        this.visibility = lllllllllllllIllllllIlIlllllIlIl;
    }
    
    public void setValBoolean(final boolean lllllllllllllIllllllIlIlIlIlIlII) {
        this.bval = lllllllllllllIllllllIlIlIlIlIlII;
    }
    
    public void setComboExpand(final boolean lllllllllllllIllllllIlIlIIIllIII) {
        this.comboExpand = lllllllllllllIllllllIlIlIIIllIII;
    }
    
    public Setting(final String lllllllllllllIllllllIlIllIllIIlI, final Module lllllllllllllIllllllIlIllIlllIlI, final double lllllllllllllIllllllIlIllIllIIII, final double lllllllllllllIllllllIlIllIlllIII, final double lllllllllllllIllllllIlIllIlIlllI, final boolean lllllllllllllIllllllIlIllIlIllIl, final boolean lllllllllllllIllllllIlIllIllIlIl, final Supplier<Boolean> lllllllllllllIllllllIlIllIllIlII) {
        this.index = 0;
        this.onlyint = false;
        this.name = lllllllllllllIllllllIlIllIllIIlI;
        this.parent = lllllllllllllIllllllIlIllIlllIlI;
        this.dval = lllllllllllllIllllllIlIllIllIIII;
        this.min = lllllllllllllIllllllIlIllIlllIII;
        this.max = lllllllllllllIllllllIlIllIlIlllI;
        this.onlyint = lllllllllllllIllllllIlIllIlIllIl;
        this.mode = "Slider";
        this.percentage = lllllllllllllIllllllIlIllIllIlIl;
        this.visibility = lllllllllllllIllllllIlIllIllIlII;
    }
    
    public void setValBooleanNoSave(final boolean lllllllllllllIllllllIlIlIlIIlllI) {
        this.bval = lllllllllllllIllllllIlIlIlIIlllI;
    }
    
    public Enum getValEnum() {
        return this.svalEnum;
    }
    
    public Setting(final String lllllllllllllIllllllIlIlllIllIll, final Module lllllllllllllIllllllIlIlllIllIlI, final double lllllllllllllIllllllIlIllllIIIIl, final double lllllllllllllIllllllIlIllllIIIII, final double lllllllllllllIllllllIlIlllIlIlll, final boolean lllllllllllllIllllllIlIlllIllllI, final boolean lllllllllllllIllllllIlIlllIlllIl) {
        this.index = 0;
        this.onlyint = false;
        this.name = lllllllllllllIllllllIlIlllIllIll;
        this.parent = lllllllllllllIllllllIlIlllIllIlI;
        this.dval = lllllllllllllIllllllIlIllllIIIIl;
        this.min = lllllllllllllIllllllIlIllllIIIII;
        this.max = lllllllllllllIllllllIlIlllIlIlll;
        this.onlyint = lllllllllllllIllllllIlIlllIllllI;
        this.mode = "Slider";
        this.percentage = lllllllllllllIllllllIlIlllIlllIl;
        this.visibility = (() -> true);
    }
    
    public boolean getValBoolean() {
        return this.bval;
    }
    
    public Setting(final String lllllllllllllIllllllIlIlllIIlIIl, final Module lllllllllllllIllllllIlIlllIIlIII, final String lllllllllllllIllllllIlIlllIIIlll, final String lllllllllllllIllllllIlIlllIIIllI) {
        this.index = 0;
        this.onlyint = false;
        this.name = lllllllllllllIllllllIlIlllIIlIIl;
        this.parent = lllllllllllllIllllllIlIlllIIlIII;
        this.sval = lllllllllllllIllllllIlIlllIIIlll;
        this.dString = lllllllllllllIllllllIlIlllIIIllI;
        this.mode = "String";
        this.visibility = (() -> true);
    }
    
    public long getValLong() {
        if (this.onlyint) {
            this.dval = (int)this.dval;
        }
        return (long)this.dval;
    }
    
    public Enum getOptionEnum() {
        return this.optionEnum;
    }
    
    public double getMax() {
        return this.max;
    }
    
    public ArrayList<String> getOptions() {
        return this.options;
    }
    
    public Enum getDoModeEnum() {
        if (this.optionEnum != null) {
            final Enum lllllllllllllIllllllIlIllIIlIIIl = this.optionEnum;
            final String[] lllllllllllllIllllllIlIllIIlIIII = Arrays.stream((Enum[])lllllllllllllIllllllIlIllIIlIIIl.getClass().getEnumConstants()).map((Function<? super Enum, ?>)Enum::name).toArray(String[]::new);
            this.index = ((this.index-- < 0) ? lllllllllllllIllllllIlIllIIlIIII.length : this.index);
            return (Enum)Enum.valueOf(lllllllllllllIllllllIlIllIIlIIIl.getClass(), lllllllllllllIllllllIlIllIIlIIII[this.index]);
        }
        return null;
    }
    
    public void setOptionEnum(final Enum lllllllllllllIllllllIlIllIIIIIll) {
        this.optionEnum = lllllllllllllIllllllIlIllIIIIIll;
    }
    
    public Setting(final String lllllllllllllIllllllIllIIIlIllll, final Module lllllllllllllIllllllIllIIIlIlllI, final boolean lllllllllllllIllllllIllIIIlIlIIl) {
        this.index = 0;
        this.onlyint = false;
        this.name = lllllllllllllIllllllIllIIIlIllll;
        this.parent = lllllllllllllIllllllIllIIIlIlllI;
        this.bval = lllllllllllllIllllllIllIIIlIlIIl;
        this.mode = "Check";
        this.visibility = (() -> true);
    }
    
    public boolean onlyInt() {
        return this.onlyint;
    }
    
    public void setValDoubleNoSave(final double lllllllllllllIllllllIlIlIIllllll) {
        this.dval = lllllllllllllIllllllIlIlIIllllll;
    }
    
    public int getValInt() {
        if (this.onlyint) {
            this.dval = (int)this.dval;
        }
        return (int)this.dval;
    }
    
    public String getMode() {
        return this.sval;
    }
    
    public double getMin() {
        return this.min;
    }
    
    public String getName() {
        return this.name;
    }
    
    public boolean isCombo() {
        return this.mode.equalsIgnoreCase("Combo");
    }
    
    public Setting(final String lllllllllllllIllllllIllIIlIlllll, final Module lllllllllllllIllllllIllIIlIllllI, final String lllllllllllllIllllllIllIIlIlllII, final ArrayList<String> lllllllllllllIllllllIllIIlIllIlI) {
        this.index = 0;
        this.onlyint = false;
        this.name = lllllllllllllIllllllIllIIlIlllll;
        this.parent = lllllllllllllIllllllIllIIlIllllI;
        this.sval = lllllllllllllIllllllIllIIlIlllII;
        this.options = lllllllllllllIllllllIllIIlIllIlI;
        this.comboExpand = false;
        this.mode = "Combo";
        this.visibility = (() -> true);
    }
    
    public Setting(final String lllllllllllllIllllllIllIIIIlIIIl, final Module lllllllllllllIllllllIllIIIIIlIIl, final double lllllllllllllIllllllIllIIIIIlIII, final double lllllllllllllIllllllIllIIIIIlllI, final double lllllllllllllIllllllIllIIIIIIllI, final boolean lllllllllllllIllllllIllIIIIIIlIl) {
        this.index = 0;
        this.onlyint = false;
        this.name = lllllllllllllIllllllIllIIIIlIIIl;
        this.parent = lllllllllllllIllllllIllIIIIIlIIl;
        this.dval = lllllllllllllIllllllIllIIIIIlIII;
        this.min = lllllllllllllIllllllIllIIIIIlllI;
        this.max = lllllllllllllIllllllIllIIIIIIllI;
        this.onlyint = lllllllllllllIllllllIllIIIIIIlIl;
        this.mode = "Slider";
        this.visibility = (() -> true);
    }
    
    public Setting(final String lllllllllllllIllllllIlIllIlIIlIl, final Module lllllllllllllIllllllIlIllIlIIIII, final Enum lllllllllllllIllllllIlIllIIlllll) {
        this.index = 0;
        this.onlyint = false;
        this.name = lllllllllllllIllllllIlIllIlIIlIl;
        this.parent = lllllllllllllIllllllIlIllIlIIIII;
        this.sval = lllllllllllllIllllllIlIllIIlllll.name();
        this.svalEnum = lllllllllllllIllllllIlIllIIlllll;
        this.options = null;
        this.optionEnum = lllllllllllllIllllllIlIllIIlllll;
        this.mode = "Combo";
        this.visibility = (() -> true);
    }
    
    public void setValDouble(final double lllllllllllllIllllllIlIlIlIIIlIl) {
        this.dval = lllllllllllllIllllllIlIlIlIIIlIl;
    }
    
    public void setValEnum(final Enum lllllllllllllIllllllIlIlIllllIlI) {
        this.svalEnum = lllllllllllllIllllllIlIlIllllIlI;
    }
    
    public Setting(final String lllllllllllllIllllllIllIIIIlllIl, final Module lllllllllllllIllllllIllIIIlIIIIl, final boolean lllllllllllllIllllllIllIIIIllIll, final Supplier<Boolean> lllllllllllllIllllllIllIIIIlllll) {
        this.index = 0;
        this.onlyint = false;
        this.name = lllllllllllllIllllllIllIIIIlllIl;
        this.parent = lllllllllllllIllllllIllIIIlIIIIl;
        this.bval = lllllllllllllIllllllIllIIIIllIll;
        this.mode = "Check";
        this.visibility = lllllllllllllIllllllIllIIIIlllll;
    }
    
    public boolean isCheck() {
        return this.mode.equalsIgnoreCase("Check");
    }
    
    public boolean isSlider() {
        return this.mode.equalsIgnoreCase("Slider");
    }
    
    public boolean isVisible() {
        return this.visibility.get();
    }
    
    public String getValString() {
        return this.sval;
    }
    
    public Module getParentMod() {
        return this.parent;
    }
    
    public float getValFloat() {
        if (this.onlyint) {
            this.dval = (int)this.dval;
        }
        return (float)this.dval;
    }
    
    public Enum getNextModeEnum() {
        if (this.optionEnum != null) {
            final Enum lllllllllllllIllllllIlIllIIllIlI = this.optionEnum;
            final String[] lllllllllllllIllllllIlIllIIllIIl = Arrays.stream((Enum[])lllllllllllllIllllllIlIllIIllIlI.getClass().getEnumConstants()).map((Function<? super Enum, ?>)Enum::name).toArray(String[]::new);
            this.index = ((this.index + 1 > lllllllllllllIllllllIlIllIIllIIl.length - 1) ? 0 : (this.index + 1));
            return (Enum)Enum.valueOf(lllllllllllllIllllllIlIllIIllIlI.getClass(), lllllllllllllIllllllIlIllIIllIIl[this.index]);
        }
        return null;
    }
    
    public double getValDouble() {
        if (this.onlyint) {
            this.dval = (int)this.dval;
        }
        return this.dval;
    }
}
