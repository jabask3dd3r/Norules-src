package com.viaversion.viaversion.libs.opennbt.tag;

import java.util.function.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class TagRegistry
{
    private static final /* synthetic */ Int2ObjectMap<Class<? extends Tag>> idToTag;
    private static final /* synthetic */ Object2IntMap<Class<? extends Tag>> tagToId;
    private static final /* synthetic */ Int2ObjectMap<Supplier<? extends Tag>> instanceSuppliers;
    
    public static void unregister(final int llllllllllllllllIlIlIIIIIIIIlIll) {
        TagRegistry.tagToId.removeInt(getClassFor(llllllllllllllllIlIlIIIIIIIIlIll));
        TagRegistry.idToTag.remove(llllllllllllllllIlIlIIIIIIIIlIll);
    }
    
    public static void register(final int llllllllllllllllIlIlIIIIIIIIllll, final Class<? extends Tag> llllllllllllllllIlIlIIIIIIIIlllI, final Supplier<? extends Tag> llllllllllllllllIlIlIIIIIIIIllIl) throws TagRegisterException {
        if (TagRegistry.idToTag.containsKey(llllllllllllllllIlIlIIIIIIIIllll)) {
            throw new TagRegisterException(String.valueOf(new StringBuilder().append("Tag ID \"").append(llllllllllllllllIlIlIIIIIIIIllll).append("\" is already in use.")));
        }
        if (TagRegistry.tagToId.containsKey(llllllllllllllllIlIlIIIIIIIIlllI)) {
            throw new TagRegisterException(String.valueOf(new StringBuilder().append("Tag \"").append(llllllllllllllllIlIlIIIIIIIIlllI.getSimpleName()).append("\" is already registered.")));
        }
        TagRegistry.instanceSuppliers.put(llllllllllllllllIlIlIIIIIIIIllll, llllllllllllllllIlIlIIIIIIIIllIl);
        TagRegistry.idToTag.put(llllllllllllllllIlIlIIIIIIIIllll, llllllllllllllllIlIlIIIIIIIIlllI);
        TagRegistry.tagToId.put(llllllllllllllllIlIlIIIIIIIIlllI, llllllllllllllllIlIlIIIIIIIIllll);
    }
    
    @Nullable
    public static Class<? extends Tag> getClassFor(final int llllllllllllllllIlIlIIIIIIIIlIII) {
        return TagRegistry.idToTag.get(llllllllllllllllIlIlIIIIIIIIlIII);
    }
    
    public static int getIdFor(final Class<? extends Tag> llllllllllllllllIlIlIIIIIIIIIlIl) {
        return TagRegistry.tagToId.getInt(llllllllllllllllIlIlIIIIIIIIIlIl);
    }
    
    static {
        idToTag = new Int2ObjectOpenHashMap<Class<? extends Tag>>();
        tagToId = new Object2IntOpenHashMap<Class<? extends Tag>>();
        instanceSuppliers = new Int2ObjectOpenHashMap<Supplier<? extends Tag>>();
        TagRegistry.tagToId.defaultReturnValue(-1);
        register(1, ByteTag.class, ByteTag::new);
        register(2, ShortTag.class, ShortTag::new);
        register(3, IntTag.class, IntTag::new);
        register(4, LongTag.class, LongTag::new);
        register(5, FloatTag.class, FloatTag::new);
        register(6, DoubleTag.class, DoubleTag::new);
        register(7, ByteArrayTag.class, ByteArrayTag::new);
        register(8, StringTag.class, StringTag::new);
        register(9, ListTag.class, ListTag::new);
        register(10, CompoundTag.class, CompoundTag::new);
        register(11, IntArrayTag.class, IntArrayTag::new);
        register(12, LongArrayTag.class, LongArrayTag::new);
    }
    
    public static Tag createInstance(final int llllllllllllllllIlIIllllllllllll) throws TagCreateException {
        final Supplier<? extends Tag> llllllllllllllllIlIlIIIIIIIIIIII = TagRegistry.instanceSuppliers.get(llllllllllllllllIlIIllllllllllll);
        if (llllllllllllllllIlIlIIIIIIIIIIII == null) {
            throw new TagCreateException(String.valueOf(new StringBuilder().append("Could not find tag with ID \"").append(llllllllllllllllIlIIllllllllllll).append("\".")));
        }
        return (Tag)llllllllllllllllIlIlIIIIIIIIIIII.get();
    }
}
