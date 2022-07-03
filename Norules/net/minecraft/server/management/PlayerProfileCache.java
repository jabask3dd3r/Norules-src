package net.minecraft.server.management;

import java.text.*;
import java.lang.reflect.*;
import java.nio.charset.*;
import com.google.common.io.*;
import net.minecraft.util.*;
import org.apache.commons.io.*;
import javax.annotation.*;
import com.mojang.authlib.*;
import net.minecraft.entity.player.*;
import com.google.common.collect.*;
import java.io.*;
import java.util.*;
import com.google.gson.*;

public class PlayerProfileCache
{
    private final /* synthetic */ Deque<GameProfile> gameProfiles;
    public static final /* synthetic */ SimpleDateFormat DATE_FORMAT;
    private final /* synthetic */ Map<String, ProfileEntry> usernameToProfileEntryMap;
    private static /* synthetic */ boolean onlineMode;
    private final /* synthetic */ File usercacheFile;
    private final /* synthetic */ GameProfileRepository profileRepo;
    protected final /* synthetic */ Gson gson;
    private final /* synthetic */ Map<UUID, ProfileEntry> uuidToProfileEntryMap;
    private static final /* synthetic */ ParameterizedType TYPE;
    
    static {
        DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        TYPE = new ParameterizedType() {
            @Override
            public Type getOwnerType() {
                return null;
            }
            
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[] { ProfileEntry.class };
            }
            
            @Override
            public Type getRawType() {
                return List.class;
            }
        };
    }
    
    public void addEntry(final GameProfile lllllllllllllIllIIIIIIllllllIIIl) {
        this.addEntry(lllllllllllllIllIIIIIIllllllIIIl, null);
    }
    
    public void load() {
        BufferedReader lllllllllllllIllIIIIIIlllIlIIllI = null;
        try {
            lllllllllllllIllIIIIIIlllIlIIllI = Files.newReader(this.usercacheFile, StandardCharsets.UTF_8);
            final List<ProfileEntry> lllllllllllllIllIIIIIIlllIlIIlIl = JsonUtils.func_193841_a(this.gson, lllllllllllllIllIIIIIIlllIlIIllI, PlayerProfileCache.TYPE);
            this.usernameToProfileEntryMap.clear();
            this.uuidToProfileEntryMap.clear();
            this.gameProfiles.clear();
            if (lllllllllllllIllIIIIIIlllIlIIlIl != null) {
                for (final ProfileEntry lllllllllllllIllIIIIIIlllIlIIlII : Lists.reverse((List)lllllllllllllIllIIIIIIlllIlIIlIl)) {
                    if (lllllllllllllIllIIIIIIlllIlIIlII != null) {
                        this.addEntry(lllllllllllllIllIIIIIIlllIlIIlII.getGameProfile(), lllllllllllllIllIIIIIIlllIlIIlII.getExpirationDate());
                    }
                }
            }
        }
        catch (FileNotFoundException lllllllllllllIllIIIIIIlllIlIIIIl) {}
        catch (JsonParseException lllllllllllllIllIIIIIIlllIlIIIIl) {}
        finally {
            IOUtils.closeQuietly((Reader)lllllllllllllIllIIIIIIlllIlIIllI);
        }
        IOUtils.closeQuietly((Reader)lllllllllllllIllIIIIIIlllIlIIllI);
    }
    
    public PlayerProfileCache(final GameProfileRepository lllllllllllllIllIIIIIlIIIIIIllII, final File lllllllllllllIllIIIIIlIIIIIIlIll) {
        this.usernameToProfileEntryMap = (Map<String, ProfileEntry>)Maps.newHashMap();
        this.uuidToProfileEntryMap = (Map<UUID, ProfileEntry>)Maps.newHashMap();
        this.gameProfiles = (Deque<GameProfile>)Lists.newLinkedList();
        this.profileRepo = lllllllllllllIllIIIIIlIIIIIIllII;
        this.usercacheFile = lllllllllllllIllIIIIIlIIIIIIlIll;
        final GsonBuilder lllllllllllllIllIIIIIlIIIIIIlllI = new GsonBuilder();
        lllllllllllllIllIIIIIlIIIIIIlllI.registerTypeHierarchyAdapter((Class)ProfileEntry.class, (Object)new Serializer((Serializer)null));
        this.gson = lllllllllllllIllIIIIIlIIIIIIlllI.create();
        this.load();
    }
    
    @Nullable
    public GameProfile getGameProfileForUsername(final String lllllllllllllIllIIIIIIllllIlIIlI) {
        final String lllllllllllllIllIIIIIIllllIlIIIl = lllllllllllllIllIIIIIIllllIlIIlI.toLowerCase(Locale.ROOT);
        ProfileEntry lllllllllllllIllIIIIIIllllIlIIII = this.usernameToProfileEntryMap.get(lllllllllllllIllIIIIIIllllIlIIIl);
        if (lllllllllllllIllIIIIIIllllIlIIII != null && new Date().getTime() >= lllllllllllllIllIIIIIIllllIlIIII.expirationDate.getTime()) {
            this.uuidToProfileEntryMap.remove(lllllllllllllIllIIIIIIllllIlIIII.getGameProfile().getId());
            this.usernameToProfileEntryMap.remove(lllllllllllllIllIIIIIIllllIlIIII.getGameProfile().getName().toLowerCase(Locale.ROOT));
            this.gameProfiles.remove(lllllllllllllIllIIIIIIllllIlIIII.getGameProfile());
            lllllllllllllIllIIIIIIllllIlIIII = null;
        }
        if (lllllllllllllIllIIIIIIllllIlIIII != null) {
            final GameProfile lllllllllllllIllIIIIIIllllIIllll = lllllllllllllIllIIIIIIllllIlIIII.getGameProfile();
            this.gameProfiles.remove(lllllllllllllIllIIIIIIllllIIllll);
            this.gameProfiles.addFirst(lllllllllllllIllIIIIIIllllIIllll);
        }
        else {
            final GameProfile lllllllllllllIllIIIIIIllllIIlllI = lookupProfile(this.profileRepo, lllllllllllllIllIIIIIIllllIlIIIl);
            if (lllllllllllllIllIIIIIIllllIIlllI != null) {
                this.addEntry(lllllllllllllIllIIIIIIllllIIlllI);
                lllllllllllllIllIIIIIIllllIlIIII = this.usernameToProfileEntryMap.get(lllllllllllllIllIIIIIIllllIlIIIl);
            }
        }
        this.save();
        return (lllllllllllllIllIIIIIIllllIlIIII == null) ? null : lllllllllllllIllIIIIIIllllIlIIII.getGameProfile();
    }
    
    private static boolean isOnlineMode() {
        return PlayerProfileCache.onlineMode;
    }
    
    private ProfileEntry getByUUID(final UUID lllllllllllllIllIIIIIIlllIllIlII) {
        final ProfileEntry lllllllllllllIllIIIIIIlllIllIIll = this.uuidToProfileEntryMap.get(lllllllllllllIllIIIIIIlllIllIlII);
        if (lllllllllllllIllIIIIIIlllIllIIll != null) {
            final GameProfile lllllllllllllIllIIIIIIlllIllIIlI = lllllllllllllIllIIIIIIlllIllIIll.getGameProfile();
            this.gameProfiles.remove(lllllllllllllIllIIIIIIlllIllIIlI);
            this.gameProfiles.addFirst(lllllllllllllIllIIIIIIlllIllIIlI);
        }
        return lllllllllllllIllIIIIIIlllIllIIll;
    }
    
    @Nullable
    public GameProfile getProfileByUUID(final UUID lllllllllllllIllIIIIIIlllIlllIll) {
        final ProfileEntry lllllllllllllIllIIIIIIlllIllllIl = this.uuidToProfileEntryMap.get(lllllllllllllIllIIIIIIlllIlllIll);
        return (lllllllllllllIllIIIIIIlllIllllIl == null) ? null : lllllllllllllIllIIIIIIlllIllllIl.getGameProfile();
    }
    
    public static void setOnlineMode(final boolean lllllllllllllIllIIIIIIllllllIllI) {
        PlayerProfileCache.onlineMode = lllllllllllllIllIIIIIIllllllIllI;
    }
    
    private static GameProfile lookupProfile(final GameProfileRepository lllllllllllllIllIIIIIIllllllllIl, final String lllllllllllllIllIIIIIlIIIIIIIIlI) {
        final GameProfile[] lllllllllllllIllIIIIIlIIIIIIIIIl = { null };
        final ProfileLookupCallback lllllllllllllIllIIIIIlIIIIIIIIII = (ProfileLookupCallback)new ProfileLookupCallback() {
            public void onProfileLookupFailed(final GameProfile lllllllllllllIIIlllllllIlllIllll, final Exception lllllllllllllIIIlllllllIlllIlllI) {
                lllllllllllllIllIIIIIlIIIIIIIIIl[0] = null;
            }
            
            public void onProfileLookupSucceeded(final GameProfile lllllllllllllIIIlllllllIllllIIlI) {
                lllllllllllllIllIIIIIlIIIIIIIIIl[0] = lllllllllllllIIIlllllllIllllIIlI;
            }
        };
        lllllllllllllIllIIIIIIllllllllIl.findProfilesByNames(new String[] { lllllllllllllIllIIIIIlIIIIIIIIlI }, Agent.MINECRAFT, lllllllllllllIllIIIIIlIIIIIIIIII);
        if (!isOnlineMode() && lllllllllllllIllIIIIIlIIIIIIIIIl[0] == null) {
            final UUID lllllllllllllIllIIIIIIllllllllll = EntityPlayer.getUUID(new GameProfile((UUID)null, lllllllllllllIllIIIIIlIIIIIIIIlI));
            final GameProfile lllllllllllllIllIIIIIIlllllllllI = new GameProfile(lllllllllllllIllIIIIIIllllllllll, lllllllllllllIllIIIIIlIIIIIIIIlI);
            lllllllllllllIllIIIIIlIIIIIIIIII.onProfileLookupSucceeded(lllllllllllllIllIIIIIIlllllllllI);
        }
        return lllllllllllllIllIIIIIlIIIIIIIIIl[0];
    }
    
    public String[] getUsernames() {
        final List<String> lllllllllllllIllIIIIIIllllIIIlIl = (List<String>)Lists.newArrayList((Iterable)this.usernameToProfileEntryMap.keySet());
        return lllllllllllllIllIIIIIIllllIIIlIl.toArray(new String[lllllllllllllIllIIIIIIllllIIIlIl.size()]);
    }
    
    private List<ProfileEntry> getEntriesWithLimit(final int lllllllllllllIllIIIIIIlllIIIlIII) {
        final List<ProfileEntry> lllllllllllllIllIIIIIIlllIIIIlll = (List<ProfileEntry>)Lists.newArrayList();
        for (final GameProfile lllllllllllllIllIIIIIIlllIIIIllI : Lists.newArrayList(Iterators.limit((Iterator)this.gameProfiles.iterator(), lllllllllllllIllIIIIIIlllIIIlIII))) {
            final ProfileEntry lllllllllllllIllIIIIIIlllIIIIlIl = this.getByUUID(lllllllllllllIllIIIIIIlllIIIIllI.getId());
            if (lllllllllllllIllIIIIIIlllIIIIlIl != null) {
                lllllllllllllIllIIIIIIlllIIIIlll.add(lllllllllllllIllIIIIIIlllIIIIlIl);
            }
        }
        return lllllllllllllIllIIIIIIlllIIIIlll;
    }
    
    public void save() {
        final String lllllllllllllIllIIIIIIlllIIlIlll = this.gson.toJson((Object)this.getEntriesWithLimit(1000));
        BufferedWriter lllllllllllllIllIIIIIIlllIIlIllI = null;
        try {
            lllllllllllllIllIIIIIIlllIIlIllI = Files.newWriter(this.usercacheFile, StandardCharsets.UTF_8);
            lllllllllllllIllIIIIIIlllIIlIllI.write(lllllllllllllIllIIIIIIlllIIlIlll);
        }
        catch (FileNotFoundException ex) {}
        catch (IOException lllllllllllllIllIIIIIIlllIIlIlIl) {}
        finally {
            IOUtils.closeQuietly((Writer)lllllllllllllIllIIIIIIlllIIlIllI);
        }
    }
    
    private void addEntry(final GameProfile lllllllllllllIllIIIIIIllllIllllI, Date lllllllllllllIllIIIIIIllllIlllIl) {
        final UUID lllllllllllllIllIIIIIIlllllIIlII = lllllllllllllIllIIIIIIllllIllllI.getId();
        if (lllllllllllllIllIIIIIIllllIlllIl == null) {
            final Calendar lllllllllllllIllIIIIIIlllllIIIll = Calendar.getInstance();
            lllllllllllllIllIIIIIIlllllIIIll.setTime(new Date());
            lllllllllllllIllIIIIIIlllllIIIll.add(2, 1);
            lllllllllllllIllIIIIIIllllIlllIl = lllllllllllllIllIIIIIIlllllIIIll.getTime();
        }
        final String lllllllllllllIllIIIIIIlllllIIIlI = lllllllllllllIllIIIIIIllllIllllI.getName().toLowerCase(Locale.ROOT);
        final ProfileEntry lllllllllllllIllIIIIIIlllllIIIIl = new ProfileEntry(lllllllllllllIllIIIIIIllllIllllI, (Date)lllllllllllllIllIIIIIIllllIlllIl, (ProfileEntry)null);
        if (this.uuidToProfileEntryMap.containsKey(lllllllllllllIllIIIIIIlllllIIlII)) {
            final ProfileEntry lllllllllllllIllIIIIIIlllllIIIII = this.uuidToProfileEntryMap.get(lllllllllllllIllIIIIIIlllllIIlII);
            this.usernameToProfileEntryMap.remove(lllllllllllllIllIIIIIIlllllIIIII.getGameProfile().getName().toLowerCase(Locale.ROOT));
            this.gameProfiles.remove(lllllllllllllIllIIIIIIllllIllllI);
        }
        this.usernameToProfileEntryMap.put(lllllllllllllIllIIIIIIllllIllllI.getName().toLowerCase(Locale.ROOT), lllllllllllllIllIIIIIIlllllIIIIl);
        this.uuidToProfileEntryMap.put(lllllllllllllIllIIIIIIlllllIIlII, lllllllllllllIllIIIIIIlllllIIIIl);
        this.gameProfiles.addFirst(lllllllllllllIllIIIIIIllllIllllI);
        this.save();
    }
    
    class ProfileEntry
    {
        private final /* synthetic */ GameProfile gameProfile;
        private final /* synthetic */ Date expirationDate;
        
        public Date getExpirationDate() {
            return this.expirationDate;
        }
        
        public GameProfile getGameProfile() {
            return this.gameProfile;
        }
        
        private ProfileEntry(final GameProfile lllllllllllllIIlIlIIlIlllIllllll, final Date lllllllllllllIIlIlIIlIlllIllIIIl) {
            this.gameProfile = lllllllllllllIIlIlIIlIlllIllllll;
            this.expirationDate = lllllllllllllIIlIlIIlIlllIllIIIl;
        }
    }
    
    class Serializer implements JsonDeserializer<ProfileEntry>, JsonSerializer<ProfileEntry>
    {
        public JsonElement serialize(final ProfileEntry lllllllllllllllIIlllIIllIllIIIIl, final Type lllllllllllllllIIlllIIllIllIIlIl, final JsonSerializationContext lllllllllllllllIIlllIIllIllIIlII) {
            final JsonObject lllllllllllllllIIlllIIllIllIIIll = new JsonObject();
            lllllllllllllllIIlllIIllIllIIIll.addProperty("name", lllllllllllllllIIlllIIllIllIIIIl.getGameProfile().getName());
            final UUID lllllllllllllllIIlllIIllIllIIIlI = lllllllllllllllIIlllIIllIllIIIIl.getGameProfile().getId();
            lllllllllllllllIIlllIIllIllIIIll.addProperty("uuid", (lllllllllllllllIIlllIIllIllIIIlI == null) ? "" : lllllllllllllllIIlllIIllIllIIIlI.toString());
            lllllllllllllllIIlllIIllIllIIIll.addProperty("expiresOn", PlayerProfileCache.DATE_FORMAT.format(lllllllllllllllIIlllIIllIllIIIIl.getExpirationDate()));
            return (JsonElement)lllllllllllllllIIlllIIllIllIIIll;
        }
        
        private Serializer() {
        }
        
        public ProfileEntry deserialize(final JsonElement lllllllllllllllIIlllIIllIlIIIIll, final Type lllllllllllllllIIlllIIllIlIlIIIl, final JsonDeserializationContext lllllllllllllllIIlllIIllIlIlIIII) throws JsonParseException {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: invokevirtual   com/google/gson/JsonElement.isJsonObject:()Z
            //     4: ifeq            152
            //     7: aload_1         /* lllllllllllllllIIlllIIllIlIlIIlI */
            //     8: invokevirtual   com/google/gson/JsonElement.getAsJsonObject:()Lcom/google/gson/JsonObject;
            //    11: astore          lllllllllllllllIIlllIIllIlIIllll
            //    13: aload           lllllllllllllllIIlllIIllIlIIllll
            //    15: ldc             "name"
            //    17: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
            //    20: astore          lllllllllllllllIIlllIIllIlIIlllI
            //    22: aload           lllllllllllllllIIlllIIllIlIIllll
            //    24: ldc             "uuid"
            //    26: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
            //    29: astore          lllllllllllllllIIlllIIllIlIIllIl
            //    31: aload           lllllllllllllllIIlllIIllIlIIllll
            //    33: ldc             "expiresOn"
            //    35: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
            //    38: astore          lllllllllllllllIIlllIIllIlIIllII
            //    40: aload           lllllllllllllllIIlllIIllIlIIlllI
            //    42: ifnull          150
            //    45: aload           lllllllllllllllIIlllIIllIlIIllIl
            //    47: ifnull          150
            //    50: aload           lllllllllllllllIIlllIIllIlIIllIl
            //    52: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
            //    55: astore          lllllllllllllllIIlllIIllIlIIlIll
            //    57: aload           lllllllllllllllIIlllIIllIlIIlllI
            //    59: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
            //    62: astore          lllllllllllllllIIlllIIllIlIIlIlI
            //    64: aconst_null    
            //    65: astore          lllllllllllllllIIlllIIllIlIIlIIl
            //    67: aload           lllllllllllllllIIlllIIllIlIIllII
            //    69: ifnull          93
            //    72: getstatic       net/minecraft/server/management/PlayerProfileCache.DATE_FORMAT:Ljava/text/SimpleDateFormat;
            //    75: aload           lllllllllllllllIIlllIIllIlIIllII
            //    77: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
            //    80: invokevirtual   java/text/SimpleDateFormat.parse:(Ljava/lang/String;)Ljava/util/Date;
            //    83: astore          lllllllllllllllIIlllIIllIlIIlIIl
            //    85: goto            93
            //    88: astore          lllllllllllllllIIlllIIllIlIIlIII
            //    90: aconst_null    
            //    91: astore          lllllllllllllllIIlllIIllIlIIlIIl
            //    93: aload           lllllllllllllllIIlllIIllIlIIlIlI
            //    95: ifnull          148
            //    98: aload           lllllllllllllllIIlllIIllIlIIlIll
            //   100: ifnull          148
            //   103: aload           lllllllllllllllIIlllIIllIlIIlIll
            //   105: invokestatic    java/util/UUID.fromString:(Ljava/lang/String;)Ljava/util/UUID;
            //   108: astore          lllllllllllllllIIlllIIllIlIIIlll
            //   110: goto            117
            //   113: astore          lllllllllllllllIIlllIIllIlIIIlIl
            //   115: aconst_null    
            //   116: areturn        
            //   117: new             Lnet/minecraft/server/management/PlayerProfileCache$ProfileEntry;
            //   120: dup            
            //   121: aload_0         /* lllllllllllllllIIlllIIllIlIlIIll */
            //   122: getfield        net/minecraft/server/management/PlayerProfileCache$Serializer.this$0:Lnet/minecraft/server/management/PlayerProfileCache;
            //   125: dup            
            //   126: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
            //   129: pop            
            //   130: new             Lcom/mojang/authlib/GameProfile;
            //   133: dup            
            //   134: aload           lllllllllllllllIIlllIIllIlIIIllI
            //   136: aload           lllllllllllllllIIlllIIllIlIIlIlI
            //   138: invokespecial   com/mojang/authlib/GameProfile.<init>:(Ljava/util/UUID;Ljava/lang/String;)V
            //   141: aload           lllllllllllllllIIlllIIllIlIIlIIl
            //   143: aconst_null    
            //   144: invokespecial   net/minecraft/server/management/PlayerProfileCache$ProfileEntry.<init>:(Lnet/minecraft/server/management/PlayerProfileCache;Lcom/mojang/authlib/GameProfile;Ljava/util/Date;Lnet/minecraft/server/management/PlayerProfileCache$ProfileEntry;)V
            //   147: areturn        
            //   148: aconst_null    
            //   149: areturn        
            //   150: aconst_null    
            //   151: areturn        
            //   152: aconst_null    
            //   153: areturn        
            //    Exceptions:
            //  throws com.google.gson.JsonParseException
            //    StackMapTable: 00 07 FF 00 58 00 0B 07 00 02 07 00 87 07 00 5A 07 00 CB 07 00 15 07 00 87 07 00 87 07 00 87 07 00 5E 07 00 5E 07 00 CD 00 01 07 00 83 04 53 07 00 85 FC 00 03 07 00 33 FA 00 1E F8 00 01 FF 00 01 00 04 07 00 02 07 00 87 07 00 5A 07 00 CB 00 00
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                      
            //  -----  -----  -----  -----  --------------------------
            //  72     85     88     93     Ljava/text/ParseException;
            //  103    110    113    117    Ljava/lang/Throwable;
            // 
            // The error that occurred was:
            // 
            // java.lang.NullPointerException
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
    }
}
