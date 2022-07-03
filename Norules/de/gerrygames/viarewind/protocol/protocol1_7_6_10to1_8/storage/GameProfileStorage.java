package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage;

import com.viaversion.viaversion.api.connection.*;
import java.util.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import de.gerrygames.viarewind.utils.*;
import com.viaversion.viaversion.util.*;

public class GameProfileStorage extends StoredObject
{
    private /* synthetic */ Map<UUID, GameProfile> properties;
    
    public void putProperty(final UUID llllllllllllllIlllllIIIIIlIIlIll, final String llllllllllllllIlllllIIIIIlIIllll, final String llllllllllllllIlllllIIIIIlIIlIIl, final String llllllllllllllIlllllIIIIIlIIlIII) {
        this.putProperty(llllllllllllllIlllllIIIIIlIIlIll, new Property(llllllllllllllIlllllIIIIIlIIllll, llllllllllllllIlllllIIIIIlIIlIIl, llllllllllllllIlllllIIIIIlIIlIII));
    }
    
    public GameProfile get(final UUID llllllllllllllIlllllIIIIIlIIIIlI) {
        return this.properties.get(llllllllllllllIlllllIIIIIlIIIIlI);
    }
    
    public GameProfile get(String llllllllllllllIlllllIIIIIIllIlIl, final boolean llllllllllllllIlllllIIIIIIllIlll) {
        if (llllllllllllllIlllllIIIIIIllIlll) {
            llllllllllllllIlllllIIIIIIllIlIl = ((String)llllllllllllllIlllllIIIIIIllIlIl).toLowerCase();
        }
        for (final GameProfile llllllllllllllIlllllIIIIIIlllIlI : this.properties.values()) {
            if (llllllllllllllIlllllIIIIIIlllIlI.name == null) {
                continue;
            }
            final String llllllllllllllIlllllIIIIIIlllIll = llllllllllllllIlllllIIIIIIllIlll ? llllllllllllllIlllllIIIIIIlllIlI.name.toLowerCase() : llllllllllllllIlllllIIIIIIlllIlI.name;
            if (llllllllllllllIlllllIIIIIIlllIll.equals(llllllllllllllIlllllIIIIIIllIlIl)) {
                return llllllllllllllIlllllIIIIIIlllIlI;
            }
        }
        return null;
    }
    
    public List<GameProfile> getAllWithPrefix(String llllllllllllllIlllllIIIIIIlIIIlI, final boolean llllllllllllllIlllllIIIIIIlIIIIl) {
        if (llllllllllllllIlllllIIIIIIlIIIIl) {
            llllllllllllllIlllllIIIIIIlIIIlI = llllllllllllllIlllllIIIIIIlIIIlI.toLowerCase();
        }
        final ArrayList<GameProfile> llllllllllllllIlllllIIIIIIlIIlII = new ArrayList<GameProfile>();
        for (final GameProfile llllllllllllllIlllllIIIIIIlIlIII : this.properties.values()) {
            if (llllllllllllllIlllllIIIIIIlIlIII.name == null) {
                continue;
            }
            final String llllllllllllllIlllllIIIIIIlIlIIl = llllllllllllllIlllllIIIIIIlIIIIl ? llllllllllllllIlllllIIIIIIlIlIII.name.toLowerCase() : llllllllllllllIlllllIIIIIIlIlIII.name;
            if (!llllllllllllllIlllllIIIIIIlIlIIl.startsWith(llllllllllllllIlllllIIIIIIlIIIlI)) {
                continue;
            }
            llllllllllllllIlllllIIIIIIlIIlII.add(llllllllllllllIlllllIIIIIIlIlIII);
        }
        return llllllllllllllIlllllIIIIIIlIIlII;
    }
    
    public GameProfileStorage(final UserConnection llllllllllllllIlllllIIIIIllIllII) {
        super(llllllllllllllIlllllIIIIIllIllII);
        this.properties = new HashMap<UUID, GameProfile>();
    }
    
    public GameProfile remove(final UUID llllllllllllllIlllllIIIIIIIllIIl) {
        return this.properties.remove(llllllllllllllIlllllIIIIIIIllIIl);
    }
    
    public void putProperty(final UUID llllllllllllllIlllllIIIIIlIllIll, final Property llllllllllllllIlllllIIIIIlIlIlll) {
        this.properties.computeIfAbsent(llllllllllllllIlllllIIIIIlIllIll, llllllllllllllIlllllIIIIIIIlIlII -> new GameProfile(llllllllllllllIlllllIIIIIlIllIll, null)).properties.add(llllllllllllllIlllllIIIIIlIlIlll);
    }
    
    public GameProfile put(final UUID llllllllllllllIlllllIIIIIllIIIlI, final String llllllllllllllIlllllIIIIIllIIIIl) {
        final GameProfile llllllllllllllIlllllIIIIIllIIlII = new GameProfile(llllllllllllllIlllllIIIIIllIIIlI, llllllllllllllIlllllIIIIIllIIIIl);
        this.properties.put(llllllllllllllIlllllIIIIIllIIIlI, llllllllllllllIlllllIIIIIllIIlII);
        return llllllllllllllIlllllIIIIIllIIlII;
    }
    
    public static class Property
    {
        public /* synthetic */ String signature;
        public /* synthetic */ String value;
        public /* synthetic */ String name;
        
        public Property(final String lllllllllllllIIlllIIIIllIIlIIIIl, final String lllllllllllllIIlllIIIIllIIlIIIII, final String lllllllllllllIIlllIIIIllIIIlllll) {
            this.name = lllllllllllllIIlllIIIIllIIlIIIIl;
            this.value = lllllllllllllIIlllIIIIllIIlIIIII;
            this.signature = lllllllllllllIIlllIIIIllIIIlllll;
        }
    }
    
    public static class GameProfile
    {
        public /* synthetic */ List<Property> properties;
        public /* synthetic */ UUID uuid;
        public /* synthetic */ String name;
        public /* synthetic */ int gamemode;
        public /* synthetic */ String displayName;
        
        public Item getSkull() {
            final CompoundTag lllllllllllllIIllIllIIlIlllIIIIl = new CompoundTag();
            final CompoundTag lllllllllllllIIllIllIIlIlllIIIII = new CompoundTag();
            lllllllllllllIIllIllIIlIlllIIIIl.put("SkullOwner", lllllllllllllIIllIllIIlIlllIIIII);
            lllllllllllllIIllIllIIlIlllIIIII.put("Id", new StringTag(this.uuid.toString()));
            final CompoundTag lllllllllllllIIllIllIIlIllIlllll = new CompoundTag();
            lllllllllllllIIllIllIIlIlllIIIII.put("Properties", lllllllllllllIIllIllIIlIllIlllll);
            final ListTag lllllllllllllIIllIllIIlIllIllllI = new ListTag(CompoundTag.class);
            lllllllllllllIIllIllIIlIllIlllll.put("textures", lllllllllllllIIllIllIIlIllIllllI);
            for (final Property lllllllllllllIIllIllIIlIlllIIIll : this.properties) {
                if (lllllllllllllIIllIllIIlIlllIIIll.name.equals("textures")) {
                    final CompoundTag lllllllllllllIIllIllIIlIlllIIlII = new CompoundTag();
                    lllllllllllllIIllIllIIlIlllIIlII.put("Value", new StringTag(lllllllllllllIIllIllIIlIlllIIIll.value));
                    if (lllllllllllllIIllIllIIlIlllIIIll.signature != null) {
                        lllllllllllllIIllIllIIlIlllIIlII.put("Signature", new StringTag(lllllllllllllIIllIllIIlIlllIIIll.signature));
                    }
                    lllllllllllllIIllIllIIlIllIllllI.add(lllllllllllllIIllIllIIlIlllIIlII);
                }
            }
            return new DataItem(397, (byte)1, (short)3, lllllllllllllIIllIllIIlIlllIIIIl);
        }
        
        public GameProfile(final UUID lllllllllllllIIllIllIIlIlllIlllI, final String lllllllllllllIIllIllIIlIlllIllIl) {
            this.properties = new ArrayList<Property>();
            this.gamemode = 0;
            this.name = lllllllllllllIIllIllIIlIlllIllIl;
            this.uuid = lllllllllllllIIllIllIIlIlllIlllI;
        }
        
        public String getDisplayName() {
            String lllllllllllllIIllIllIIlIllIlIIlI = (this.displayName == null) ? this.name : this.displayName;
            if (lllllllllllllIIllIllIIlIllIlIIlI.length() > 16) {
                lllllllllllllIIllIllIIlIllIlIIlI = ChatUtil.removeUnusedColor(lllllllllllllIIllIllIIlIllIlIIlI, 'f');
            }
            if (lllllllllllllIIllIllIIlIllIlIIlI.length() > 16) {
                lllllllllllllIIllIllIIlIllIlIIlI = ChatColorUtil.stripColor(lllllllllllllIIllIllIIlIllIlIIlI);
            }
            if (lllllllllllllIIllIllIIlIllIlIIlI.length() > 16) {
                lllllllllllllIIllIllIIlIllIlIIlI = lllllllllllllIIllIllIIlIllIlIIlI.substring(0, 16);
            }
            return lllllllllllllIIllIllIIlIllIlIIlI;
        }
        
        public void setDisplayName(final String lllllllllllllIIllIllIIlIllIIlIlI) {
            this.displayName = lllllllllllllIIllIllIIlIllIIlIlI;
        }
    }
}
