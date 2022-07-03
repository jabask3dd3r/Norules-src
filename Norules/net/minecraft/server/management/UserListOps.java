package net.minecraft.server.management;

import com.mojang.authlib.*;
import com.google.gson.*;
import java.io.*;

public class UserListOps extends UserList<GameProfile, UserListOpsEntry>
{
    @Override
    protected UserListEntry<GameProfile> createEntry(final JsonObject lllllllllllllIlIIIIIIllIlllIIlII) {
        return new UserListOpsEntry(lllllllllllllIlIIIIIIllIlllIIlII);
    }
    
    @Override
    public String[] getKeys() {
        final String[] lllllllllllllIlIIIIIIllIllIlllII = new String[((UserList<K, UserListOpsEntry>)this).getValues().size()];
        int lllllllllllllIlIIIIIIllIllIllIll = 0;
        for (final UserListOpsEntry lllllllllllllIlIIIIIIllIllIllIlI : ((UserList<K, UserListOpsEntry>)this).getValues().values()) {
            lllllllllllllIlIIIIIIllIllIlllII[lllllllllllllIlIIIIIIllIllIllIll++] = lllllllllllllIlIIIIIIllIllIllIlI.getValue().getName();
        }
        return lllllllllllllIlIIIIIIllIllIlllII;
    }
    
    public GameProfile getGameProfileFromName(final String lllllllllllllIlIIIIIIllIIlIIlIll) {
        for (final UserListOpsEntry lllllllllllllIlIIIIIIllIIlIIllIl : ((UserList<K, UserListOpsEntry>)this).getValues().values()) {
            if (lllllllllllllIlIIIIIIllIIlIIlIll.equalsIgnoreCase(lllllllllllllIlIIIIIIllIIlIIllIl.getValue().getName())) {
                return lllllllllllllIlIIIIIIllIIlIIllIl.getValue();
            }
        }
        return null;
    }
    
    public UserListOps(final File lllllllllllllIlIIIIIIllIlllIIlll) {
        super(lllllllllllllIlIIIIIIllIlllIIlll);
    }
    
    @Override
    protected String getObjectKey(final GameProfile lllllllllllllIlIIIIIIllIIlIlIlII) {
        return lllllllllllllIlIIIIIIllIIlIlIlII.getId().toString();
    }
    
    public int getPermissionLevel(final GameProfile lllllllllllllIlIIIIIIllIllIlIIII) {
        final UserListOpsEntry lllllllllllllIlIIIIIIllIllIIllll = this.getEntry(lllllllllllllIlIIIIIIllIllIlIIII);
        return (lllllllllllllIlIIIIIIllIllIIllll != null) ? lllllllllllllIlIIIIIIllIllIIllll.getPermissionLevel() : 0;
    }
    
    public boolean bypassesPlayerLimit(final GameProfile lllllllllllllIlIIIIIIllIllIIIlII) {
        final UserListOpsEntry lllllllllllllIlIIIIIIllIllIIIllI = this.getEntry(lllllllllllllIlIIIIIIllIllIIIlII);
        return lllllllllllllIlIIIIIIllIllIIIllI != null && lllllllllllllIlIIIIIIllIllIIIllI.bypassesPlayerLimit();
    }
}
