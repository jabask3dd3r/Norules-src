package net.minecraft.network;

import net.minecraft.util.text.*;
import java.lang.reflect.*;
import net.minecraft.util.*;
import com.mojang.authlib.*;
import java.util.*;
import com.google.gson.*;

public class ServerStatusResponse
{
    private /* synthetic */ ITextComponent description;
    private /* synthetic */ Players players;
    private /* synthetic */ String favicon;
    private /* synthetic */ Version version;
    
    public Version getVersion() {
        return this.version;
    }
    
    public void setVersion(final Version lllllllllllllIlIIIlIIIlIIIIlIlll) {
        this.version = lllllllllllllIlIIIlIIIlIIIIlIlll;
    }
    
    public void setFavicon(final String lllllllllllllIlIIIlIIIlIIIIIllll) {
        this.favicon = lllllllllllllIlIIIlIIIlIIIIIllll;
    }
    
    public Players getPlayers() {
        return this.players;
    }
    
    public ITextComponent getServerDescription() {
        return this.description;
    }
    
    public void setServerDescription(final ITextComponent lllllllllllllIlIIIlIIIlIIIlIlIIl) {
        this.description = lllllllllllllIlIIIlIIIlIIIlIlIIl;
    }
    
    public void setPlayers(final Players lllllllllllllIlIIIlIIIlIIIlIIIII) {
        this.players = lllllllllllllIlIIIlIIIlIIIlIIIII;
    }
    
    public String getFavicon() {
        return this.favicon;
    }
    
    public static class Version
    {
        private final /* synthetic */ int protocol;
        private final /* synthetic */ String name;
        
        public int getProtocol() {
            return this.protocol;
        }
        
        public Version(final String lllllllllllllIIlIlIlIlIlllIlIIlI, final int lllllllllllllIIlIlIlIlIlllIIlllI) {
            this.name = lllllllllllllIIlIlIlIlIlllIlIIlI;
            this.protocol = lllllllllllllIIlIlIlIlIlllIIlllI;
        }
        
        public String getName() {
            return this.name;
        }
        
        public static class Serializer implements JsonDeserializer<Version>, JsonSerializer<Version>
        {
            public Version deserialize(final JsonElement llllllllllllllIIIIlllIlIlIlIllll, final Type llllllllllllllIIIIlllIlIlIlIlllI, final JsonDeserializationContext llllllllllllllIIIIlllIlIlIlIllIl) throws JsonParseException {
                final JsonObject llllllllllllllIIIIlllIlIlIlIllII = JsonUtils.getJsonObject(llllllllllllllIIIIlllIlIlIlIllll, "version");
                return new Version(JsonUtils.getString(llllllllllllllIIIIlllIlIlIlIllII, "name"), JsonUtils.getInt(llllllllllllllIIIIlllIlIlIlIllII, "protocol"));
            }
            
            public JsonElement serialize(final Version llllllllllllllIIIIlllIlIlIlIIllI, final Type llllllllllllllIIIIlllIlIlIlIIlIl, final JsonSerializationContext llllllllllllllIIIIlllIlIlIlIIlII) {
                final JsonObject llllllllllllllIIIIlllIlIlIlIIIll = new JsonObject();
                llllllllllllllIIIIlllIlIlIlIIIll.addProperty("name", llllllllllllllIIIIlllIlIlIlIIllI.getName());
                llllllllllllllIIIIlllIlIlIlIIIll.addProperty("protocol", (Number)llllllllllllllIIIIlllIlIlIlIIllI.getProtocol());
                return (JsonElement)llllllllllllllIIIIlllIlIlIlIIIll;
            }
        }
    }
    
    public static class Serializer implements JsonDeserializer<ServerStatusResponse>, JsonSerializer<ServerStatusResponse>
    {
        public JsonElement serialize(final ServerStatusResponse lllllllllllllllllllIlIlIIIIIlIIl, final Type lllllllllllllllllllIlIlIIIIIllII, final JsonSerializationContext lllllllllllllllllllIlIlIIIIIlIll) {
            final JsonObject lllllllllllllllllllIlIlIIIIIlIlI = new JsonObject();
            if (lllllllllllllllllllIlIlIIIIIlIIl.getServerDescription() != null) {
                lllllllllllllllllllIlIlIIIIIlIlI.add("description", lllllllllllllllllllIlIlIIIIIlIll.serialize((Object)lllllllllllllllllllIlIlIIIIIlIIl.getServerDescription()));
            }
            if (lllllllllllllllllllIlIlIIIIIlIIl.getPlayers() != null) {
                lllllllllllllllllllIlIlIIIIIlIlI.add("players", lllllllllllllllllllIlIlIIIIIlIll.serialize((Object)lllllllllllllllllllIlIlIIIIIlIIl.getPlayers()));
            }
            if (lllllllllllllllllllIlIlIIIIIlIIl.getVersion() != null) {
                lllllllllllllllllllIlIlIIIIIlIlI.add("version", lllllllllllllllllllIlIlIIIIIlIll.serialize((Object)lllllllllllllllllllIlIlIIIIIlIIl.getVersion()));
            }
            if (lllllllllllllllllllIlIlIIIIIlIIl.getFavicon() != null) {
                lllllllllllllllllllIlIlIIIIIlIlI.addProperty("favicon", lllllllllllllllllllIlIlIIIIIlIIl.getFavicon());
            }
            return (JsonElement)lllllllllllllllllllIlIlIIIIIlIlI;
        }
        
        public ServerStatusResponse deserialize(final JsonElement lllllllllllllllllllIlIlIIIIlIlIl, final Type lllllllllllllllllllIlIlIIIIllIIl, final JsonDeserializationContext lllllllllllllllllllIlIlIIIIlIlII) throws JsonParseException {
            final JsonObject lllllllllllllllllllIlIlIIIIlIlll = JsonUtils.getJsonObject(lllllllllllllllllllIlIlIIIIlIlIl, "status");
            final ServerStatusResponse lllllllllllllllllllIlIlIIIIlIllI = new ServerStatusResponse();
            if (lllllllllllllllllllIlIlIIIIlIlll.has("description")) {
                lllllllllllllllllllIlIlIIIIlIllI.setServerDescription((ITextComponent)lllllllllllllllllllIlIlIIIIlIlII.deserialize(lllllllllllllllllllIlIlIIIIlIlll.get("description"), (Type)ITextComponent.class));
            }
            if (lllllllllllllllllllIlIlIIIIlIlll.has("players")) {
                lllllllllllllllllllIlIlIIIIlIllI.setPlayers((Players)lllllllllllllllllllIlIlIIIIlIlII.deserialize(lllllllllllllllllllIlIlIIIIlIlll.get("players"), (Type)Players.class));
            }
            if (lllllllllllllllllllIlIlIIIIlIlll.has("version")) {
                lllllllllllllllllllIlIlIIIIlIllI.setVersion((Version)lllllllllllllllllllIlIlIIIIlIlII.deserialize(lllllllllllllllllllIlIlIIIIlIlll.get("version"), (Type)Version.class));
            }
            if (lllllllllllllllllllIlIlIIIIlIlll.has("favicon")) {
                lllllllllllllllllllIlIlIIIIlIllI.setFavicon(JsonUtils.getString(lllllllllllllllllllIlIlIIIIlIlll, "favicon"));
            }
            return lllllllllllllllllllIlIlIIIIlIllI;
        }
    }
    
    public static class Players
    {
        private /* synthetic */ GameProfile[] players;
        private final /* synthetic */ int onlinePlayerCount;
        private final /* synthetic */ int maxPlayers;
        
        public GameProfile[] getPlayers() {
            return this.players;
        }
        
        public int getOnlinePlayerCount() {
            return this.onlinePlayerCount;
        }
        
        public Players(final int lllllllllllllIlIlIlllIIIlIlIIIlI, final int lllllllllllllIlIlIlllIIIlIlIIIIl) {
            this.maxPlayers = lllllllllllllIlIlIlllIIIlIlIIIlI;
            this.onlinePlayerCount = lllllllllllllIlIlIlllIIIlIlIIIIl;
        }
        
        public int getMaxPlayers() {
            return this.maxPlayers;
        }
        
        public void setPlayers(final GameProfile[] lllllllllllllIlIlIlllIIIlIIlIIIl) {
            this.players = lllllllllllllIlIlIlllIIIlIIlIIIl;
        }
        
        public static class Serializer implements JsonDeserializer<Players>, JsonSerializer<Players>
        {
            public Players deserialize(final JsonElement lllllllllllllIlIlIIIlIIlIllIllIl, final Type lllllllllllllIlIlIIIlIIlIlllIlll, final JsonDeserializationContext lllllllllllllIlIlIIIlIIlIlllIllI) throws JsonParseException {
                final JsonObject lllllllllllllIlIlIIIlIIlIlllIlIl = JsonUtils.getJsonObject(lllllllllllllIlIlIIIlIIlIllIllIl, "players");
                final Players lllllllllllllIlIlIIIlIIlIlllIlII = new Players(JsonUtils.getInt(lllllllllllllIlIlIIIlIIlIlllIlIl, "max"), JsonUtils.getInt(lllllllllllllIlIlIIIlIIlIlllIlIl, "online"));
                if (JsonUtils.isJsonArray(lllllllllllllIlIlIIIlIIlIlllIlIl, "sample")) {
                    final JsonArray lllllllllllllIlIlIIIlIIlIlllIIll = JsonUtils.getJsonArray(lllllllllllllIlIlIIIlIIlIlllIlIl, "sample");
                    if (lllllllllllllIlIlIIIlIIlIlllIIll.size() > 0) {
                        final GameProfile[] lllllllllllllIlIlIIIlIIlIlllIIlI = new GameProfile[lllllllllllllIlIlIIIlIIlIlllIIll.size()];
                        for (int lllllllllllllIlIlIIIlIIlIlllIIIl = 0; lllllllllllllIlIlIIIlIIlIlllIIIl < lllllllllllllIlIlIIIlIIlIlllIIlI.length; ++lllllllllllllIlIlIIIlIIlIlllIIIl) {
                            final JsonObject lllllllllllllIlIlIIIlIIlIllIllll = JsonUtils.getJsonObject(lllllllllllllIlIlIIIlIIlIlllIIll.get(lllllllllllllIlIlIIIlIIlIlllIIIl), String.valueOf(new StringBuilder("player[").append(lllllllllllllIlIlIIIlIIlIlllIIIl).append("]")));
                            final String lllllllllllllIlIlIIIlIIlIllIlllI = JsonUtils.getString(lllllllllllllIlIlIIIlIIlIllIllll, "id");
                            lllllllllllllIlIlIIIlIIlIlllIIlI[lllllllllllllIlIlIIIlIIlIlllIIIl] = new GameProfile(UUID.fromString(lllllllllllllIlIlIIIlIIlIllIlllI), JsonUtils.getString(lllllllllllllIlIlIIIlIIlIllIllll, "name"));
                        }
                        lllllllllllllIlIlIIIlIIlIlllIlII.setPlayers(lllllllllllllIlIlIIIlIIlIlllIIlI);
                    }
                }
                return lllllllllllllIlIlIIIlIIlIlllIlII;
            }
            
            public JsonElement serialize(final Players lllllllllllllIlIlIIIlIIlIIllIllI, final Type lllllllllllllIlIlIIIlIIlIIllllIl, final JsonSerializationContext lllllllllllllIlIlIIIlIIlIIllllII) {
                final JsonObject lllllllllllllIlIlIIIlIIlIIlllIll = new JsonObject();
                lllllllllllllIlIlIIIlIIlIIlllIll.addProperty("max", (Number)lllllllllllllIlIlIIIlIIlIIllIllI.getMaxPlayers());
                lllllllllllllIlIlIIIlIIlIIlllIll.addProperty("online", (Number)lllllllllllllIlIlIIIlIIlIIllIllI.getOnlinePlayerCount());
                if (lllllllllllllIlIlIIIlIIlIIllIllI.getPlayers() != null && lllllllllllllIlIlIIIlIIlIIllIllI.getPlayers().length > 0) {
                    final JsonArray lllllllllllllIlIlIIIlIIlIIlllIlI = new JsonArray();
                    for (int lllllllllllllIlIlIIIlIIlIIlllIIl = 0; lllllllllllllIlIlIIIlIIlIIlllIIl < lllllllllllllIlIlIIIlIIlIIllIllI.getPlayers().length; ++lllllllllllllIlIlIIIlIIlIIlllIIl) {
                        final JsonObject lllllllllllllIlIlIIIlIIlIIlllIII = new JsonObject();
                        final UUID lllllllllllllIlIlIIIlIIlIIllIlll = lllllllllllllIlIlIIIlIIlIIllIllI.getPlayers()[lllllllllllllIlIlIIIlIIlIIlllIIl].getId();
                        lllllllllllllIlIlIIIlIIlIIlllIII.addProperty("id", (lllllllllllllIlIlIIIlIIlIIllIlll == null) ? "" : lllllllllllllIlIlIIIlIIlIIllIlll.toString());
                        lllllllllllllIlIlIIIlIIlIIlllIII.addProperty("name", lllllllllllllIlIlIIIlIIlIIllIllI.getPlayers()[lllllllllllllIlIlIIIlIIlIIlllIIl].getName());
                        lllllllllllllIlIlIIIlIIlIIlllIlI.add((JsonElement)lllllllllllllIlIlIIIlIIlIIlllIII);
                    }
                    lllllllllllllIlIlIIIlIIlIIlllIll.add("sample", (JsonElement)lllllllllllllIlIlIIIlIIlIIlllIlI);
                }
                return (JsonElement)lllllllllllllIlIlIIIlIIlIIlllIll;
            }
        }
    }
}
