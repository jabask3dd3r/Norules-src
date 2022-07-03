package shadersmod.client;

import optifine.*;

public class PropertyDefaultFastFancyOff extends Property
{
    public static final /* synthetic */ String[] USER_VALUES;
    public static final /* synthetic */ String[] PROPERTY_VALUES;
    
    public boolean isFast() {
        return this.getValue() == 1;
    }
    
    public boolean isFancy() {
        return this.getValue() == 2;
    }
    
    public boolean isOff() {
        return this.getValue() == 3;
    }
    
    public PropertyDefaultFastFancyOff(final String lllllllllllllIIIlIlIlIIlIlIIIIlI, final String lllllllllllllIIIlIlIlIIlIlIIIIIl, final int lllllllllllllIIIlIlIlIIlIIllllII) {
        super(lllllllllllllIIIlIlIlIIlIlIIIIlI, PropertyDefaultFastFancyOff.PROPERTY_VALUES, lllllllllllllIIIlIlIlIIlIlIIIIIl, PropertyDefaultFastFancyOff.USER_VALUES, lllllllllllllIIIlIlIlIIlIIllllII);
    }
    
    static {
        PROPERTY_VALUES = new String[] { "default", "fast", "fancy", "off" };
        USER_VALUES = new String[] { "Default", "Fast", "Fancy", "OFF" };
    }
    
    public boolean isDefault() {
        return this.getValue() == 0;
    }
    
    @Override
    public boolean setPropertyValue(String lllllllllllllIIIlIlIlIIlIIlIlIlI) {
        if (Config.equals(lllllllllllllIIIlIlIlIIlIIlIlIlI, "none")) {
            lllllllllllllIIIlIlIlIIlIIlIlIlI = "off";
        }
        return super.setPropertyValue(lllllllllllllIIIlIlIlIIlIIlIlIlI);
    }
}
