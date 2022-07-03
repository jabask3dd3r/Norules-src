package com.viaversion.viaversion.libs.opennbt.tag.builtin;

import com.google.common.base.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.opennbt.tag.*;
import java.util.*;
import java.io.*;

public class CompoundTag extends Tag implements Iterable<Map.Entry<String, Tag>>
{
    private /* synthetic */ Map<String, Tag> value;
    
    public void setValue(final LinkedHashMap<String, Tag> llllllllllllIlllllIllIIIllIIIIII) {
        Preconditions.checkNotNull((Object)llllllllllllIlllllIllIIIllIIIIII);
        this.value = llllllllllllIlllllIllIIIllIIIIII;
    }
    
    public CompoundTag(final Map<String, Tag> llllllllllllIlllllIllIIIllIlIlIl) {
        this.value = new LinkedHashMap<String, Tag>(llllllllllllIlllllIllIIIllIlIlIl);
    }
    
    public int size() {
        return this.value.size();
    }
    
    @Override
    public boolean equals(final Object llllllllllllIlllllIllIIIIllIlIlI) {
        if (this == llllllllllllIlllllIllIIIIllIlIlI) {
            return true;
        }
        if (llllllllllllIlllllIllIIIIllIlIlI == null || this.getClass() != llllllllllllIlllllIllIIIIllIlIlI.getClass()) {
            return false;
        }
        final CompoundTag llllllllllllIlllllIllIIIIllIlIIl = (CompoundTag)llllllllllllIlllllIllIIIIllIlIlI;
        return this.value.equals(llllllllllllIlllllIllIIIIllIlIIl.value);
    }
    
    static {
        ID = 10;
    }
    
    @Nullable
    public <T extends Tag> T remove(final String llllllllllllIlllllIllIIIlIlIIIlI) {
        return (T)this.value.remove(llllllllllllIlllllIllIIIlIlIIIlI);
    }
    
    @Override
    public void read(final DataInput llllllllllllIlllllIllIIIlIIIIIlI) throws IOException {
        try {
            while (true) {
                final int llllllllllllIlllllIllIIIlIIIIllI = llllllllllllIlllllIllIIIlIIIIIlI.readByte();
                if (llllllllllllIlllllIllIIIlIIIIllI == 0) {
                    break;
                }
                final String llllllllllllIlllllIllIIIlIIIlIII = llllllllllllIlllllIllIIIlIIIIIlI.readUTF();
                final Tag llllllllllllIlllllIllIIIlIIIIlll = TagRegistry.createInstance(llllllllllllIlllllIllIIIlIIIIllI);
                llllllllllllIlllllIllIIIlIIIIlll.read(llllllllllllIlllllIllIIIlIIIIIlI);
                this.value.put(llllllllllllIlllllIllIIIlIIIlIII, llllllllllllIlllllIllIIIlIIIIlll);
            }
        }
        catch (TagCreateException llllllllllllIlllllIllIIIlIIIIlIl) {
            throw new IOException("Failed to create tag.", llllllllllllIlllllIllIIIlIIIIlIl);
        }
        catch (EOFException llllllllllllIlllllIllIIIlIIIIlII) {
            throw new IOException("Closing tag was not found!");
        }
    }
    
    @Override
    public Iterator<Map.Entry<String, Tag>> iterator() {
        return this.value.entrySet().iterator();
    }
    
    public Set<String> keySet() {
        return this.value.keySet();
    }
    
    public void clear() {
        this.value.clear();
    }
    
    public CompoundTag() {
        this(new LinkedHashMap<String, Tag>());
    }
    
    public CompoundTag(final LinkedHashMap<String, Tag> llllllllllllIlllllIllIIIllIIllll) {
        Preconditions.checkNotNull((Object)llllllllllllIlllllIllIIIllIIllll);
        this.value = llllllllllllIlllllIllIIIllIIllll;
    }
    
    @Override
    public final CompoundTag clone() {
        final LinkedHashMap<String, Tag> llllllllllllIlllllIllIIIIlIlllII = new LinkedHashMap<String, Tag>();
        for (final Map.Entry<String, Tag> llllllllllllIlllllIllIIIIlIllllI : this.value.entrySet()) {
            llllllllllllIlllllIllIIIIlIlllII.put(llllllllllllIlllllIllIIIIlIllllI.getKey(), llllllllllllIlllllIllIIIIlIllllI.getValue().clone());
        }
        return new CompoundTag(llllllllllllIlllllIllIIIIlIlllII);
    }
    
    public Collection<Tag> values() {
        return this.value.values();
    }
    
    public Set<Map.Entry<String, Tag>> entrySet() {
        return this.value.entrySet();
    }
    
    public boolean contains(final String llllllllllllIlllllIllIIIlIllIlIl) {
        return this.value.containsKey(llllllllllllIlllllIllIIIlIllIlIl);
    }
    
    public boolean isEmpty() {
        return this.value.isEmpty();
    }
    
    @Override
    public Map<String, Tag> getValue() {
        return this.value;
    }
    
    @Override
    public int getTagId() {
        return 10;
    }
    
    @Override
    public void write(final DataOutput llllllllllllIlllllIllIIIIlllIIlI) throws IOException {
        for (final Map.Entry<String, Tag> llllllllllllIlllllIllIIIIlllIllI : this.value.entrySet()) {
            final Tag llllllllllllIlllllIllIIIIlllIlll = llllllllllllIlllllIllIIIIlllIllI.getValue();
            llllllllllllIlllllIllIIIIlllIIlI.writeByte(llllllllllllIlllllIllIIIIlllIlll.getTagId());
            llllllllllllIlllllIllIIIIlllIIlI.writeUTF(llllllllllllIlllllIllIIIIlllIllI.getKey());
            llllllllllllIlllllIllIIIIlllIlll.write(llllllllllllIlllllIllIIIIlllIIlI);
        }
        llllllllllllIlllllIllIIIIlllIIlI.writeByte(0);
    }
    
    public void setValue(final Map<String, Tag> llllllllllllIlllllIllIIIllIIIlII) {
        Preconditions.checkNotNull((Object)llllllllllllIlllllIllIIIllIIIlII);
        this.value = new LinkedHashMap<String, Tag>(llllllllllllIlllllIllIIIllIIIlII);
    }
    
    @Override
    public int hashCode() {
        return this.value.hashCode();
    }
    
    @Nullable
    public <T extends Tag> T put(final String llllllllllllIlllllIllIIIlIlIlIlI, final T llllllllllllIlllllIllIIIlIlIlIIl) {
        return (T)this.value.put(llllllllllllIlllllIllIIIlIlIlIlI, llllllllllllIlllllIllIIIlIlIlIIl);
    }
    
    @Nullable
    public <T extends Tag> T get(final String llllllllllllIlllllIllIIIlIllIIIl) {
        return (T)this.value.get(llllllllllllIlllllIllIIIlIllIIIl);
    }
}
