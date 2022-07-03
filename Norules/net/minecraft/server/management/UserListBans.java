package net.minecraft.server.management;

import com.mojang.authlib.*;
import java.io.*;
import com.google.gson.*;

public class UserListBans extends UserList<GameProfile, UserListBansEntry>
{
    @Override
    public String[] getKeys() {
        final String[] lllllllllllllIIllIIIIIIllllIIIll = new String[((UserList<K, UserListBansEntry>)this).getValues().size()];
        int lllllllllllllIIllIIIIIIllllIIIlI = 0;
        for (final UserListBansEntry lllllllllllllIIllIIIIIIllllIIIIl : ((UserList<K, UserListBansEntry>)this).getValues().values()) {
            lllllllllllllIIllIIIIIIllllIIIll[lllllllllllllIIllIIIIIIllllIIIlI++] = lllllllllllllIIllIIIIIIllllIIIIl.getValue().getName();
        }
        return lllllllllllllIIllIIIIIIllllIIIll;
    }
    
    public UserListBans(final File lllllllllllllIIllIIIIIIlllllIllI) {
        super(lllllllllllllIIllIIIIIIlllllIllI);
    }
    
    @Override
    protected String getObjectKey(final GameProfile lllllllllllllIIllIIIIIIlllIllIII) {
        return lllllllllllllIIllIIIIIIlllIllIII.getId().toString();
    }
    
    public GameProfile getBannedProfile(final String lllllllllllllIIllIIIIIIlllIlIIlI) {
        for (final UserListBansEntry lllllllllllllIIllIIIIIIlllIlIIIl : ((UserList<K, UserListBansEntry>)this).getValues().values()) {
            if (lllllllllllllIIllIIIIIIlllIlIIlI.equalsIgnoreCase(lllllllllllllIIllIIIIIIlllIlIIIl.getValue().getName())) {
                return lllllllllllllIIllIIIIIIlllIlIIIl.getValue();
            }
        }
        return null;
    }
    
    public boolean isBanned(final GameProfile lllllllllllllIIllIIIIIIllllIlIlI) {
        return ((UserList<GameProfile, V>)this).hasEntry(lllllllllllllIIllIIIIIIllllIlIlI);
    }
    
    @Override
    protected UserListEntry<GameProfile> createEntry(final JsonObject lllllllllllllIIllIIIIIIlllllIIIl) {
        return new UserListBansEntry(lllllllllllllIIllIIIIIIlllllIIIl);
    }
}
