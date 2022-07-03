package net.minecraft.server.management;

import java.net.*;
import java.io.*;
import com.google.gson.*;

public class UserListIPBans extends UserList<String, UserListIPBansEntry>
{
    public UserListIPBansEntry getBanEntry(final SocketAddress llllllllllllllIlllIIIllllIIlIlII) {
        final String llllllllllllllIlllIIIllllIIlIllI = this.addressToString(llllllllllllllIlllIIIllllIIlIlII);
        return this.getEntry(llllllllllllllIlllIIIllllIIlIllI);
    }
    
    public UserListIPBans(final File llllllllllllllIlllIIIllllIlIlIIl) {
        super(llllllllllllllIlllIIIllllIlIlIIl);
    }
    
    public boolean isBanned(final SocketAddress llllllllllllllIlllIIIllllIIlllIl) {
        final String llllllllllllllIlllIIIllllIIlllll = this.addressToString(llllllllllllllIlllIIIllllIIlllIl);
        return ((UserList<String, V>)this).hasEntry(llllllllllllllIlllIIIllllIIlllll);
    }
    
    @Override
    protected UserListEntry<String> createEntry(final JsonObject llllllllllllllIlllIIIllllIlIIlIl) {
        return new UserListIPBansEntry(llllllllllllllIlllIIIllllIlIIlIl);
    }
    
    private String addressToString(final SocketAddress llllllllllllllIlllIIIllllIIIllIl) {
        String llllllllllllllIlllIIIllllIIIlllI = llllllllllllllIlllIIIllllIIIllIl.toString();
        if (llllllllllllllIlllIIIllllIIIlllI.contains("/")) {
            llllllllllllllIlllIIIllllIIIlllI = llllllllllllllIlllIIIllllIIIlllI.substring(llllllllllllllIlllIIIllllIIIlllI.indexOf(47) + 1);
        }
        if (llllllllllllllIlllIIIllllIIIlllI.contains(":")) {
            llllllllllllllIlllIIIllllIIIlllI = llllllllllllllIlllIIIllllIIIlllI.substring(0, llllllllllllllIlllIIIllllIIIlllI.indexOf(58));
        }
        return llllllllllllllIlllIIIllllIIIlllI;
    }
}
