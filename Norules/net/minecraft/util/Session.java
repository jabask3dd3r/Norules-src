package net.minecraft.util;

import com.mojang.authlib.*;
import com.mojang.util.*;
import com.google.common.collect.*;
import java.util.*;
import javax.annotation.*;

public class Session
{
    private final /* synthetic */ String playerID;
    private final /* synthetic */ Type sessionType;
    private final /* synthetic */ String token;
    private final /* synthetic */ String username;
    
    public String getSessionID() {
        return String.valueOf(new StringBuilder("token:").append(this.token).append(":").append(this.playerID));
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public GameProfile getProfile() {
        try {
            final UUID lllllllllllllIlllIIlIlIIIIIllIll = UUIDTypeAdapter.fromString(this.getPlayerID());
            return new GameProfile(lllllllllllllIlllIIlIlIIIIIllIll, this.getUsername());
        }
        catch (IllegalArgumentException lllllllllllllIlllIIlIlIIIIIllIlI) {
            return new GameProfile((UUID)null, this.getUsername());
        }
    }
    
    public String getToken() {
        return this.token;
    }
    
    public Session(final String lllllllllllllIlllIIlIlIIIIllIIll, final String lllllllllllllIlllIIlIlIIIIllIIlI, final String lllllllllllllIlllIIlIlIIIIllIIIl, final String lllllllllllllIlllIIlIlIIIIlIlIll) {
        this.username = lllllllllllllIlllIIlIlIIIIllIIll;
        this.playerID = lllllllllllllIlllIIlIlIIIIllIIlI;
        this.token = lllllllllllllIlllIIlIlIIIIllIIIl;
        this.sessionType = Type.setSessionType(lllllllllllllIlllIIlIlIIIIlIlIll);
    }
    
    public String getPlayerID() {
        return this.playerID;
    }
    
    public enum Type
    {
        private final /* synthetic */ String sessionType;
        
        LEGACY("LEGACY", 0, "legacy");
        
        private static final /* synthetic */ Map<String, Type> SESSION_TYPES;
        
        MOJANG("MOJANG", 1, "mojang");
        
        private Type(final String lllllllllllllIIIIllIIIlIIlllIIIl, final int lllllllllllllIIIIllIIIlIIlllIIII, final String lllllllllllllIIIIllIIIlIIlllIIll) {
            this.sessionType = lllllllllllllIIIIllIIIlIIlllIIll;
        }
        
        static {
            SESSION_TYPES = Maps.newHashMap();
            final int lllllllllllllIIIIllIIIlIIllllIIl;
            final Exception lllllllllllllIIIIllIIIlIIllllIlI = (Exception)((Type[])(Object)(lllllllllllllIIIIllIIIlIIllllIIl = (int)(Object)values())).length;
            for (short lllllllllllllIIIIllIIIlIIllllIll = 0; lllllllllllllIIIIllIIIlIIllllIll < lllllllllllllIIIIllIIIlIIllllIlI; ++lllllllllllllIIIIllIIIlIIllllIll) {
                final Type lllllllllllllIIIIllIIIlIIlllllIl = lllllllllllllIIIIllIIIlIIllllIIl[lllllllllllllIIIIllIIIlIIllllIll];
                Type.SESSION_TYPES.put(lllllllllllllIIIIllIIIlIIlllllIl.sessionType, lllllllllllllIIIIllIIIlIIlllllIl);
            }
        }
        
        @Nullable
        public static Type setSessionType(final String lllllllllllllIIIIllIIIlIIllIllIl) {
            return Type.SESSION_TYPES.get(lllllllllllllIIIIllIIIlIIllIllIl.toLowerCase(Locale.ROOT));
        }
    }
}
