package net.minecraft.server.management;

import com.mojang.authlib.*;
import java.io.*;
import com.google.gson.*;

public class UserListWhitelist extends UserList<GameProfile, UserListWhitelistEntry>
{
    public GameProfile getByName(final String lllllllllllllIlIllIlllllllIlIIll) {
        for (final UserListWhitelistEntry lllllllllllllIlIllIlllllllIlIIlI : ((UserList<K, UserListWhitelistEntry>)this).getValues().values()) {
            if (lllllllllllllIlIllIlllllllIlIIll.equalsIgnoreCase(lllllllllllllIlIllIlllllllIlIIlI.getValue().getName())) {
                return lllllllllllllIlIllIlllllllIlIIlI.getValue();
            }
        }
        return null;
    }
    
    @Override
    protected String getObjectKey(final GameProfile lllllllllllllIlIllIlllllllIllIIl) {
        return lllllllllllllIlIllIlllllllIllIIl.getId().toString();
    }
    
    public UserListWhitelist(final File lllllllllllllIlIllIlllllllllIIIl) {
        super(lllllllllllllIlIllIlllllllllIIIl);
    }
    
    @Override
    protected UserListEntry<GameProfile> createEntry(final JsonObject lllllllllllllIlIllIllllllllIlIll) {
        return new UserListWhitelistEntry(lllllllllllllIlIllIllllllllIlIll);
    }
    
    @Override
    public String[] getKeys() {
        final String[] lllllllllllllIlIllIllllllllIIlII = new String[((UserList<K, UserListWhitelistEntry>)this).getValues().size()];
        int lllllllllllllIlIllIllllllllIIIll = 0;
        for (final UserListWhitelistEntry lllllllllllllIlIllIllllllllIIIlI : ((UserList<K, UserListWhitelistEntry>)this).getValues().values()) {
            lllllllllllllIlIllIllllllllIIlII[lllllllllllllIlIllIllllllllIIIll++] = lllllllllllllIlIllIllllllllIIIlI.getValue().getName();
        }
        return lllllllllllllIlIllIllllllllIIlII;
    }
}
