package com.viaversion.viaversion.libs.opennbt.conversion;

import java.io.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.libs.opennbt.conversion.builtin.*;
import java.util.*;

public class ConverterRegistry
{
    private static final /* synthetic */ Map<Class<?>, TagConverter<? extends Tag, ?>> typeToConverter;
    private static final /* synthetic */ Map<Class<? extends Tag>, TagConverter<? extends Tag, ?>> tagToConverter;
    
    private static Set<Class<?>> getAllClasses(final Class<?> lllllllllllllIllIlIIlIIlllllIlIl) {
        final Set<Class<?>> lllllllllllllIllIlIIlIIlllllIlII = new LinkedHashSet<Class<?>>();
        for (Class<?> lllllllllllllIllIlIIlIIlllllIIll = lllllllllllllIllIlIIlIIlllllIlIl; lllllllllllllIllIlIIlIIlllllIIll != null; lllllllllllllIllIlIIlIIlllllIIll = lllllllllllllIllIlIIlIIlllllIIll.getSuperclass()) {
            lllllllllllllIllIlIIlIIlllllIlII.add(lllllllllllllIllIlIIlIIlllllIIll);
            lllllllllllllIllIlIIlIIlllllIlII.addAll(getAllSuperInterfaces(lllllllllllllIllIlIIlIIlllllIIll));
        }
        if (lllllllllllllIllIlIIlIIlllllIlII.contains(Serializable.class)) {
            lllllllllllllIllIlIIlIIlllllIlII.remove(Serializable.class);
            lllllllllllllIllIlIIlIIlllllIlII.add(Serializable.class);
        }
        return lllllllllllllIllIlIIlIIlllllIlII;
    }
    
    public static <T extends Tag, V> void register(final Class<T> lllllllllllllIllIlIIlIlIIIIlIlll, final Class<V> lllllllllllllIllIlIIlIlIIIIlIllI, final TagConverter<T, V> lllllllllllllIllIlIIlIlIIIIlIIlI) throws ConverterRegisterException {
        if (ConverterRegistry.tagToConverter.containsKey(lllllllllllllIllIlIIlIlIIIIlIlll)) {
            throw new ConverterRegisterException(String.valueOf(new StringBuilder().append("Type conversion to tag ").append(lllllllllllllIllIlIIlIlIIIIlIlll.getName()).append(" is already registered.")));
        }
        if (ConverterRegistry.typeToConverter.containsKey(lllllllllllllIllIlIIlIlIIIIlIllI)) {
            throw new ConverterRegisterException(String.valueOf(new StringBuilder().append("Tag conversion to type ").append(lllllllllllllIllIlIIlIlIIIIlIllI.getName()).append(" is already registered.")));
        }
        ConverterRegistry.tagToConverter.put(lllllllllllllIllIlIIlIlIIIIlIlll, lllllllllllllIllIlIIlIlIIIIlIIlI);
        ConverterRegistry.typeToConverter.put(lllllllllllllIllIlIIlIlIIIIlIllI, lllllllllllllIllIlIIlIlIIIIlIIlI);
    }
    
    public static <T extends Tag, V> V convertToValue(final T lllllllllllllIllIlIIlIlIIIIIIlll) throws ConversionException {
        if (lllllllllllllIllIlIIlIlIIIIIIlll == null || lllllllllllllIllIlIIlIlIIIIIIlll.getValue() == null) {
            return null;
        }
        if (!ConverterRegistry.tagToConverter.containsKey(lllllllllllllIllIlIIlIlIIIIIIlll.getClass())) {
            throw new ConversionException(String.valueOf(new StringBuilder().append("Tag type ").append(lllllllllllllIllIlIIlIlIIIIIIlll.getClass().getName()).append(" has no converter.")));
        }
        final TagConverter<T, ?> lllllllllllllIllIlIIlIlIIIIIlIII = (TagConverter<T, ?>)ConverterRegistry.tagToConverter.get(lllllllllllllIllIlIIlIlIIIIIIlll.getClass());
        return (V)lllllllllllllIllIlIIlIlIIIIIlIII.convert(lllllllllllllIllIlIIlIlIIIIIIlll);
    }
    
    static {
        tagToConverter = new HashMap<Class<? extends Tag>, TagConverter<? extends Tag, ?>>();
        typeToConverter = new HashMap<Class<?>, TagConverter<? extends Tag, ?>>();
        register(ByteTag.class, Byte.class, new ByteTagConverter());
        register(ShortTag.class, Short.class, new ShortTagConverter());
        register(IntTag.class, Integer.class, new IntTagConverter());
        register(LongTag.class, Long.class, new LongTagConverter());
        register(FloatTag.class, Float.class, new FloatTagConverter());
        register(DoubleTag.class, Double.class, new DoubleTagConverter());
        register(ByteArrayTag.class, byte[].class, new ByteArrayTagConverter());
        register(StringTag.class, String.class, new StringTagConverter());
        register(ListTag.class, List.class, new ListTagConverter());
        register(CompoundTag.class, Map.class, new CompoundTagConverter());
        register(IntArrayTag.class, int[].class, new IntArrayTagConverter());
        register(LongArrayTag.class, long[].class, new LongArrayTagConverter());
    }
    
    public static <T extends Tag, V> void unregister(final Class<T> lllllllllllllIllIlIIlIlIIIIIllIl, final Class<V> lllllllllllllIllIlIIlIlIIIIIlllI) {
        ConverterRegistry.tagToConverter.remove(lllllllllllllIllIlIIlIlIIIIIllIl);
        ConverterRegistry.typeToConverter.remove(lllllllllllllIllIlIIlIlIIIIIlllI);
    }
    
    private static Set<Class<?>> getAllSuperInterfaces(final Class<?> lllllllllllllIllIlIIlIIllllIlIII) {
        final Set<Class<?>> lllllllllllllIllIlIIlIIllllIIlll = new HashSet<Class<?>>();
        final long lllllllllllllIllIlIIlIIllllIIlII = (Object)lllllllllllllIllIlIIlIIllllIlIII.getInterfaces();
        final String lllllllllllllIllIlIIlIIllllIIIll = (String)lllllllllllllIllIlIIlIIllllIIlII.length;
        for (double lllllllllllllIllIlIIlIIllllIIIlI = 0; lllllllllllllIllIlIIlIIllllIIIlI < lllllllllllllIllIlIIlIIllllIIIll; ++lllllllllllllIllIlIIlIIllllIIIlI) {
            final Class<?> lllllllllllllIllIlIIlIIllllIlIIl = lllllllllllllIllIlIIlIIllllIIlII[lllllllllllllIllIlIIlIIllllIIIlI];
            lllllllllllllIllIlIIlIIllllIIlll.add(lllllllllllllIllIlIIlIIllllIlIIl);
            lllllllllllllIllIlIIlIIllllIIlll.addAll(getAllSuperInterfaces(lllllllllllllIllIlIIlIIllllIlIIl));
        }
        return lllllllllllllIllIlIIlIIllllIIlll;
    }
    
    public static <V, T extends Tag> T convertToTag(final V lllllllllllllIllIlIIlIIlllllllll) throws ConversionException {
        if (lllllllllllllIllIlIIlIIlllllllll == null) {
            return null;
        }
        TagConverter<T, V> lllllllllllllIllIlIIlIIllllllllI = (TagConverter<T, V>)ConverterRegistry.typeToConverter.get(lllllllllllllIllIlIIlIIlllllllll.getClass());
        if (lllllllllllllIllIlIIlIIllllllllI == null) {
            for (final Class<?> lllllllllllllIllIlIIlIlIIIIIIIII : getAllClasses(lllllllllllllIllIlIIlIIlllllllll.getClass())) {
                if (ConverterRegistry.typeToConverter.containsKey(lllllllllllllIllIlIIlIlIIIIIIIII)) {
                    try {
                        lllllllllllllIllIlIIlIIllllllllI = (TagConverter<T, V>)ConverterRegistry.typeToConverter.get(lllllllllllllIllIlIIlIlIIIIIIIII);
                        break;
                    }
                    catch (ClassCastException ex) {}
                }
            }
        }
        if (lllllllllllllIllIlIIlIIllllllllI == null) {
            throw new ConversionException(String.valueOf(new StringBuilder().append("Value type ").append(lllllllllllllIllIlIIlIIlllllllll.getClass().getName()).append(" has no converter.")));
        }
        return lllllllllllllIllIlIIlIIllllllllI.convert(lllllllllllllIllIlIIlIIlllllllll);
    }
}
