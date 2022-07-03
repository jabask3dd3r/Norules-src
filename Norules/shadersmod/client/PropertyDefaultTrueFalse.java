package shadersmod.client;

import optifine.*;

public class PropertyDefaultTrueFalse extends Property
{
    public static final /* synthetic */ String[] USER_VALUES;
    public static final /* synthetic */ String[] PROPERTY_VALUES;
    
    public boolean isFalse() {
        return this.getValue() == 2;
    }
    
    @Override
    public String getUserValue() {
        if (this.isDefault()) {
            return Lang.getDefault();
        }
        if (this.isTrue()) {
            return Lang.getOn();
        }
        return this.isFalse() ? Lang.getOff() : super.getUserValue();
    }
    
    public boolean isTrue() {
        return this.getValue() == 1;
    }
    
    public PropertyDefaultTrueFalse(final String lllllllllllllIIIIIlIIllIIIIIIIIl, final String lllllllllllllIIIIIlIIllIIIIIIIII, final int lllllllllllllIIIIIlIIlIlllllllll) {
        super(lllllllllllllIIIIIlIIllIIIIIIIIl, PropertyDefaultTrueFalse.PROPERTY_VALUES, lllllllllllllIIIIIlIIllIIIIIIIII, PropertyDefaultTrueFalse.USER_VALUES, lllllllllllllIIIIIlIIlIlllllllll);
    }
    
    static {
        PROPERTY_VALUES = new String[] { "default", "true", "false" };
        USER_VALUES = new String[] { "Default", "ON", "OFF" };
    }
    
    public boolean isDefault() {
        return this.getValue() == 0;
    }
}
