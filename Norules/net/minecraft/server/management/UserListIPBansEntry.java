package net.minecraft.server.management;

import com.google.gson.*;
import java.util.*;

public class UserListIPBansEntry extends UserListEntryBan<String>
{
    @Override
    protected void onSerialization(final JsonObject lllllllllllllllIIIlllIIIlIlIIlll) {
        if (this.getValue() != null) {
            lllllllllllllllIIIlllIIIlIlIIlll.addProperty("ip", (String)this.getValue());
            super.onSerialization(lllllllllllllllIIIlllIIIlIlIIlll);
        }
    }
    
    public UserListIPBansEntry(final String lllllllllllllllIIIlllIIIllIIlIII) {
        this(lllllllllllllllIIIlllIIIllIIlIII, null, null, null, null);
    }
    
    private static String getIPFromJson(final JsonObject lllllllllllllllIIIlllIIIlIlIlIll) {
        return lllllllllllllllIIIlllIIIlIlIlIll.has("ip") ? lllllllllllllllIIIlllIIIlIlIlIll.get("ip").getAsString() : null;
    }
    
    public UserListIPBansEntry(final String lllllllllllllllIIIlllIIIlIlllllI, final Date lllllllllllllllIIIlllIIIlIllIlll, final String lllllllllllllllIIIlllIIIlIllllII, final Date lllllllllllllllIIIlllIIIlIllIlIl, final String lllllllllllllllIIIlllIIIlIllIlII) {
        super(lllllllllllllllIIIlllIIIlIlllllI, lllllllllllllllIIIlllIIIlIllIlll, lllllllllllllllIIIlllIIIlIllllII, lllllllllllllllIIIlllIIIlIllIlIl, lllllllllllllllIIIlllIIIlIllIlII);
    }
    
    public UserListIPBansEntry(final JsonObject lllllllllllllllIIIlllIIIlIllIIII) {
        super(getIPFromJson(lllllllllllllllIIIlllIIIlIllIIII), lllllllllllllllIIIlllIIIlIllIIII);
    }
}
