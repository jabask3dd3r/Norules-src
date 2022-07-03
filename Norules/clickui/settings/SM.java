package clickui.settings;

import java.util.*;
import me.nrules.module.*;

public class SM
{
    private /* synthetic */ ArrayList<Setting> settings;
    
    public Setting getSettingByModByName(final Module lllllllllllllIIlIlIlIlIlIIlllllI, final String lllllllllllllIIlIlIlIlIlIIllllIl) {
        for (final Setting lllllllllllllIIlIlIlIlIlIIllllII : this.getSettings()) {
            if (lllllllllllllIIlIlIlIlIlIIllllII.getParentMod().equals(lllllllllllllIIlIlIlIlIlIIlllllI) && lllllllllllllIIlIlIlIlIlIIllllII.getName().equalsIgnoreCase(lllllllllllllIIlIlIlIlIlIIllllIl)) {
                return lllllllllllllIIlIlIlIlIlIIllllII;
            }
        }
        return null;
    }
    
    public ArrayList<Setting> getSettingsByMod(final Module lllllllllllllIIlIlIlIlIlIllIlIII) {
        final ArrayList<Setting> lllllllllllllIIlIlIlIlIlIllIIlll = new ArrayList<Setting>();
        for (final Setting lllllllllllllIIlIlIlIlIlIllIIllI : this.getSettings()) {
            if (lllllllllllllIIlIlIlIlIlIllIIllI.getParentMod().equals(lllllllllllllIIlIlIlIlIlIllIlIII)) {
                lllllllllllllIIlIlIlIlIlIllIIlll.add(lllllllllllllIIlIlIlIlIlIllIIllI);
            }
        }
        if (lllllllllllllIIlIlIlIlIlIllIIlll.isEmpty()) {
            return null;
        }
        return lllllllllllllIIlIlIlIlIlIllIIlll;
    }
    
    public ArrayList<Setting> getSettings() {
        return this.settings;
    }
    
    public Setting getSettingByName(final String lllllllllllllIIlIlIlIlIlIIllIIIl) {
        for (final Setting lllllllllllllIIlIlIlIlIlIIllIIII : this.getSettings()) {
            if (lllllllllllllIIlIlIlIlIlIIllIIII.getName().equalsIgnoreCase(lllllllllllllIIlIlIlIlIlIIllIIIl)) {
                return lllllllllllllIIlIlIlIlIlIIllIIII;
            }
        }
        return null;
    }
    
    public void Property(final Setting lllllllllllllIIlIlIlIlIlIlllIIlI) {
        this.settings.add(lllllllllllllIIlIlIlIlIlIlllIIlI);
    }
    
    public ArrayList<String> getSettingsNameByMod(final Module lllllllllllllIIlIlIlIlIlIlIllIlI) {
        final ArrayList<String> lllllllllllllIIlIlIlIlIlIlIllIIl = new ArrayList<String>();
        for (final Setting lllllllllllllIIlIlIlIlIlIlIllIII : this.getSettings()) {
            if (lllllllllllllIIlIlIlIlIlIlIllIII.getParentMod().equals(lllllllllllllIIlIlIlIlIlIlIllIlI)) {
                lllllllllllllIIlIlIlIlIlIlIllIIl.add(lllllllllllllIIlIlIlIlIlIlIllIII.getName());
            }
        }
        if (lllllllllllllIIlIlIlIlIlIlIllIIl.isEmpty()) {
            return null;
        }
        return lllllllllllllIIlIlIlIlIlIlIllIIl;
    }
    
    public SM() {
        this.settings = new ArrayList<Setting>();
    }
    
    public Setting getSettingByName(final Module lllllllllllllIIlIlIlIlIlIlIIlIII, final String lllllllllllllIIlIlIlIlIlIlIIlIll) {
        for (final Setting lllllllllllllIIlIlIlIlIlIlIIlIlI : this.getSettings()) {
            if (lllllllllllllIIlIlIlIlIlIlIIlIlI.getName().equalsIgnoreCase(lllllllllllllIIlIlIlIlIlIlIIlIll) && lllllllllllllIIlIlIlIlIlIlIIlIlI.getParentMod().equals(lllllllllllllIIlIlIlIlIlIlIIlIII)) {
                return lllllllllllllIIlIlIlIlIlIlIIlIlI;
            }
        }
        return null;
    }
}
