package net.minecraft.server.management;

import java.nio.charset.*;
import com.google.common.io.*;
import org.apache.commons.io.*;
import java.io.*;
import org.apache.logging.log4j.*;
import java.lang.reflect.*;
import java.util.*;
import com.google.common.collect.*;
import com.google.gson.*;

public class UserList<K, V extends UserListEntry<K>>
{
    protected final /* synthetic */ Gson gson;
    private /* synthetic */ boolean lanServer;
    private final /* synthetic */ File saveFile;
    private final /* synthetic */ Map<String, V> values;
    protected static final /* synthetic */ Logger LOGGER;
    
    protected String getObjectKey(final K llllllllllllllIIlllIIIIIlIIIIlll) {
        return llllllllllllllIIlllIIIIIlIIIIlll.toString();
    }
    
    public UserList(final File llllllllllllllIIlllIIIIIlIlIllll) {
        this.values = (Map<String, V>)Maps.newHashMap();
        this.lanServer = true;
        this.saveFile = llllllllllllllIIlllIIIIIlIlIllll;
        final GsonBuilder llllllllllllllIIlllIIIIIlIllIIIl = new GsonBuilder().setPrettyPrinting();
        llllllllllllllIIlllIIIIIlIllIIIl.registerTypeHierarchyAdapter((Class)UserListEntry.class, (Object)new Serializer((Serializer)null));
        this.gson = llllllllllllllIIlllIIIIIlIllIIIl.create();
    }
    
    public V getEntry(final K llllllllllllllIIlllIIIIIlIIllIII) {
        this.removeExpired();
        return this.values.get(this.getObjectKey(llllllllllllllIIlllIIIIIlIIllIII));
    }
    
    protected boolean hasEntry(final K llllllllllllllIIlllIIIIIlIIIIIlI) {
        return this.values.containsKey(this.getObjectKey(llllllllllllllIIlllIIIIIlIIIIIlI));
    }
    
    public void setLanServer(final boolean llllllllllllllIIlllIIIIIlIlIIlll) {
        this.lanServer = llllllllllllllIIlllIIIIIlIlIIlll;
    }
    
    public void writeChanges() throws IOException {
        final Collection<V> llllllllllllllIIlllIIIIIIllIIllI = this.values.values();
        final String llllllllllllllIIlllIIIIIIllIIlIl = this.gson.toJson((Object)llllllllllllllIIlllIIIIIIllIIllI);
        BufferedWriter llllllllllllllIIlllIIIIIIllIIlII = null;
        try {
            llllllllllllllIIlllIIIIIIllIIlII = Files.newWriter(this.saveFile, StandardCharsets.UTF_8);
            llllllllllllllIIlllIIIIIIllIIlII.write(llllllllllllllIIlllIIIIIIllIIlIl);
        }
        finally {
            IOUtils.closeQuietly((Writer)llllllllllllllIIlllIIIIIIllIIlII);
        }
        IOUtils.closeQuietly((Writer)llllllllllllllIIlllIIIIIIllIIlII);
    }
    
    protected UserListEntry<K> createEntry(final JsonObject llllllllllllllIIlllIIIIIIlllIIIl) {
        return new UserListEntry<K>(null, llllllllllllllIIlllIIIIIIlllIIIl);
    }
    
    public String[] getKeys() {
        return this.values.keySet().toArray(new String[this.values.size()]);
    }
    
    public void removeEntry(final K llllllllllllllIIlllIIIIIlIIlIIIl) {
        this.values.remove(this.getObjectKey(llllllllllllllIIlllIIIIIlIIlIIIl));
        try {
            this.writeChanges();
        }
        catch (IOException llllllllllllllIIlllIIIIIlIIlIIII) {
            UserList.LOGGER.warn("Could not save the list after removing a user.", (Throwable)llllllllllllllIIlllIIIIIlIIlIIII);
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
        USER_LIST_ENTRY_TYPE = new ParameterizedType() {
            @Override
            public Type getOwnerType() {
                return null;
            }
            
            @Override
            public Type getRawType() {
                return List.class;
            }
            
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[] { UserListEntry.class };
            }
        };
    }
    
    public void addEntry(final V llllllllllllllIIlllIIIIIlIlIIIII) {
        this.values.put(this.getObjectKey(llllllllllllllIIlllIIIIIlIlIIIII.getValue()), llllllllllllllIIlllIIIIIlIlIIIII);
        try {
            this.writeChanges();
        }
        catch (IOException llllllllllllllIIlllIIIIIlIIlllll) {
            UserList.LOGGER.warn("Could not save the list after adding a user.", (Throwable)llllllllllllllIIlllIIIIIlIIlllll);
        }
    }
    
    protected Map<String, V> getValues() {
        return this.values;
    }
    
    public boolean isLanServer() {
        return this.lanServer;
    }
    
    private void removeExpired() {
        final List<K> llllllllllllllIIlllIIIIIIllllIlI = (List<K>)Lists.newArrayList();
        for (final V llllllllllllllIIlllIIIIIIllllIIl : this.values.values()) {
            if (llllllllllllllIIlllIIIIIIllllIIl.hasBanExpired()) {
                llllllllllllllIIlllIIIIIIllllIlI.add(llllllllllllllIIlllIIIIIIllllIIl.getValue());
            }
        }
        for (final K llllllllllllllIIlllIIIIIIllllIII : llllllllllllllIIlllIIIIIIllllIlI) {
            this.values.remove(llllllllllllllIIlllIIIIIIllllIII);
        }
    }
    
    class Serializer implements JsonDeserializer<UserListEntry<K>>, JsonSerializer<UserListEntry<K>>
    {
        public JsonElement serialize(final UserListEntry<K> lllllllllllllIlIIIlIIIlIIlllllIl, final Type lllllllllllllIlIIIlIIIlIIlllllII, final JsonSerializationContext lllllllllllllIlIIIlIIIlIIllllIll) {
            final JsonObject lllllllllllllIlIIIlIIIlIIllllIlI = new JsonObject();
            lllllllllllllIlIIIlIIIlIIlllllIl.onSerialization(lllllllllllllIlIIIlIIIlIIllllIlI);
            return (JsonElement)lllllllllllllIlIIIlIIIlIIllllIlI;
        }
        
        private Serializer() {
        }
        
        public UserListEntry<K> deserialize(final JsonElement lllllllllllllIlIIIlIIIlIIlllIIll, final Type lllllllllllllIlIIIlIIIlIIlllIIlI, final JsonDeserializationContext lllllllllllllIlIIIlIIIlIIlllIIIl) throws JsonParseException {
            if (lllllllllllllIlIIIlIIIlIIlllIIll.isJsonObject()) {
                final JsonObject lllllllllllllIlIIIlIIIlIIlllIIII = lllllllllllllIlIIIlIIIlIIlllIIll.getAsJsonObject();
                return UserList.this.createEntry(lllllllllllllIlIIIlIIIlIIlllIIII);
            }
            return null;
        }
    }
}
