package com.viaversion.viaversion.api.command;

import com.viaversion.viaversion.util.*;
import java.util.*;

public abstract class ViaSubCommand
{
    public static void sendMessage(final ViaCommandSender llllllllllllllIIIlllIIllIIIIllIl, final String llllllllllllllIIIlllIIllIIIIllII, final Object... llllllllllllllIIIlllIIllIIIIlllI) {
        llllllllllllllIIIlllIIllIIIIllIl.sendMessage(color((llllllllllllllIIIlllIIllIIIIlllI == null) ? llllllllllllllIIIlllIIllIIIIllII : String.format(llllllllllllllIIIlllIIllIIIIllII, llllllllllllllIIIlllIIllIIIIlllI)));
    }
    
    public abstract String description();
    
    public abstract String name();
    
    public static String color(final String llllllllllllllIIIlllIIllIIIlIlII) {
        return ChatColorUtil.translateAlternateColorCodes(llllllllllllllIIIlllIIllIIIlIlII);
    }
    
    public List<String> onTabComplete(final ViaCommandSender llllllllllllllIIIlllIIllIIIllIIl, final String[] llllllllllllllIIIlllIIllIIIlIlll) {
        return Collections.emptyList();
    }
    
    public String usage() {
        return this.name();
    }
    
    public String permission() {
        return "viaversion.admin";
    }
    
    public abstract boolean execute(final ViaCommandSender p0, final String[] p1);
}
