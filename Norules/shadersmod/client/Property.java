package shadersmod.client;

import org.apache.commons.lang3.*;
import optifine.*;
import java.util.*;

public class Property
{
    private /* synthetic */ int[] values;
    private /* synthetic */ String userName;
    private /* synthetic */ String[] userValues;
    private /* synthetic */ String propertyName;
    private /* synthetic */ int value;
    private /* synthetic */ int defaultValue;
    private /* synthetic */ String[] propertyValues;
    
    public void setValue(final int lllllllllllllllIllllllIIlllllllI) {
        this.value = lllllllllllllllIllllllIIlllllllI;
        if (this.value < 0 || this.value >= this.propertyValues.length) {
            this.value = this.defaultValue;
        }
    }
    
    public void resetValue() {
        this.value = this.defaultValue;
    }
    
    public String getUserName() {
        return this.userName;
    }
    
    public boolean setPropertyValue(final String lllllllllllllllIllllllIlIIIIlIIl) {
        if (lllllllllllllllIllllllIlIIIIlIIl == null) {
            this.value = this.defaultValue;
            return false;
        }
        this.value = ArrayUtils.indexOf((Object[])this.propertyValues, (Object)lllllllllllllllIllllllIlIIIIlIIl);
        if (this.value >= 0 && this.value < this.propertyValues.length) {
            return true;
        }
        this.value = this.defaultValue;
        return false;
    }
    
    public String getPropertyName() {
        return this.propertyName;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.propertyName).append("=").append(this.getPropertyValue()).append(" [").append(Config.arrayToString(this.propertyValues)).append("], value: ").append(this.value));
    }
    
    public boolean loadFrom(final Properties lllllllllllllllIllllllIIlllIIlII) {
        this.resetValue();
        if (lllllllllllllllIllllllIIlllIIlII == null) {
            return false;
        }
        final String lllllllllllllllIllllllIIlllIIllI = lllllllllllllllIllllllIIlllIIlII.getProperty(this.propertyName);
        return lllllllllllllllIllllllIIlllIIllI != null && this.setPropertyValue(lllllllllllllllIllllllIIlllIIllI);
    }
    
    public Property(final String lllllllllllllllIllllllIlIIIlIIIl, final String[] lllllllllllllllIllllllIlIIIlIllI, final String lllllllllllllllIllllllIlIIIlIlIl, final String[] lllllllllllllllIllllllIlIIIlIlII, final int lllllllllllllllIllllllIlIIIIllIl) {
        this.values = null;
        this.defaultValue = 0;
        this.propertyName = null;
        this.propertyValues = null;
        this.userName = null;
        this.userValues = null;
        this.value = 0;
        this.propertyName = lllllllllllllllIllllllIlIIIlIIIl;
        this.propertyValues = lllllllllllllllIllllllIlIIIlIllI;
        this.userName = lllllllllllllllIllllllIlIIIlIlIl;
        this.userValues = lllllllllllllllIllllllIlIIIlIlII;
        this.defaultValue = lllllllllllllllIllllllIlIIIIllIl;
        if (lllllllllllllllIllllllIlIIIlIllI.length != lllllllllllllllIllllllIlIIIlIlII.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Property and user values have different lengths: ").append(lllllllllllllllIllllllIlIIIlIllI.length).append(" != ").append(lllllllllllllllIllllllIlIIIlIlII.length)));
        }
        if (lllllllllllllllIllllllIlIIIIllIl >= 0 && lllllllllllllllIllllllIlIIIIllIl < lllllllllllllllIllllllIlIIIlIllI.length) {
            this.value = lllllllllllllllIllllllIlIIIIllIl;
            return;
        }
        throw new IllegalArgumentException(String.valueOf(new StringBuilder("Invalid default value: ").append(lllllllllllllllIllllllIlIIIIllIl)));
    }
    
    public String getUserValue() {
        return this.userValues[this.value];
    }
    
    public int getValue() {
        return this.value;
    }
    
    public void saveTo(final Properties lllllllllllllllIllllllIIllIlllIl) {
        if (lllllllllllllllIllllllIIllIlllIl != null) {
            lllllllllllllllIllllllIIllIlllIl.setProperty(this.getPropertyName(), this.getPropertyValue());
        }
    }
    
    public String getPropertyValue() {
        return this.propertyValues[this.value];
    }
    
    public void nextValue() {
        ++this.value;
        if (this.value < 0 || this.value >= this.propertyValues.length) {
            this.value = 0;
        }
    }
}
