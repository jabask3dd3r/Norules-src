package net.minecraft.world.storage.loot.properties;

import java.util.*;
import net.minecraft.util.*;
import com.google.common.collect.*;

public class EntityPropertyManager
{
    private static final /* synthetic */ Map<Class<? extends EntityProperty>, EntityProperty.Serializer<?>> CLASS_TO_SERIALIZER_MAP;
    private static final /* synthetic */ Map<ResourceLocation, EntityProperty.Serializer<?>> NAME_TO_SERIALIZER_MAP;
    
    public static <T extends EntityProperty> void registerProperty(final EntityProperty.Serializer<? extends T> lllllllllllllIlIlIIlIIllllIlIIII) {
        final ResourceLocation lllllllllllllIlIlIIlIIllllIlIlII = lllllllllllllIlIlIIlIIllllIlIIII.getName();
        final Class<T> lllllllllllllIlIlIIlIIllllIlIIlI = (Class<T>)lllllllllllllIlIlIIlIIllllIlIIII.getPropertyClass();
        if (EntityPropertyManager.NAME_TO_SERIALIZER_MAP.containsKey(lllllllllllllIlIlIIlIIllllIlIlII)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Can't re-register entity property name ").append(lllllllllllllIlIlIIlIIllllIlIlII)));
        }
        if (EntityPropertyManager.CLASS_TO_SERIALIZER_MAP.containsKey(lllllllllllllIlIlIIlIIllllIlIIlI)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Can't re-register entity property class ").append(lllllllllllllIlIlIIlIIllllIlIIlI.getName())));
        }
        EntityPropertyManager.NAME_TO_SERIALIZER_MAP.put(lllllllllllllIlIlIIlIIllllIlIlII, lllllllllllllIlIlIIlIIllllIlIIII);
        EntityPropertyManager.CLASS_TO_SERIALIZER_MAP.put(lllllllllllllIlIlIIlIIllllIlIIlI, lllllllllllllIlIlIIlIIllllIlIIII);
    }
    
    public static EntityProperty.Serializer<?> getSerializerForName(final ResourceLocation lllllllllllllIlIlIIlIIllllIIIIlI) {
        final EntityProperty.Serializer<?> lllllllllllllIlIlIIlIIllllIIIIll = EntityPropertyManager.NAME_TO_SERIALIZER_MAP.get(lllllllllllllIlIlIIlIIllllIIIIlI);
        if (lllllllllllllIlIlIIlIIllllIIIIll == null) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Unknown loot entity property '").append(lllllllllllllIlIlIIlIIllllIIIIlI).append("'")));
        }
        return lllllllllllllIlIlIIlIIllllIIIIll;
    }
    
    static {
        NAME_TO_SERIALIZER_MAP = Maps.newHashMap();
        CLASS_TO_SERIALIZER_MAP = Maps.newHashMap();
        registerProperty((EntityProperty.Serializer<? extends EntityProperty>)new EntityOnFire.Serializer());
    }
    
    public static <T extends EntityProperty> EntityProperty.Serializer<T> getSerializerFor(final T lllllllllllllIlIlIIlIIlllIlllIIl) {
        final EntityProperty.Serializer<?> lllllllllllllIlIlIIlIIlllIlllIII = EntityPropertyManager.CLASS_TO_SERIALIZER_MAP.get(lllllllllllllIlIlIIlIIlllIlllIIl.getClass());
        if (lllllllllllllIlIlIIlIIlllIlllIII == null) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Unknown loot entity property ").append(lllllllllllllIlIlIIlIIlllIlllIIl)));
        }
        return (EntityProperty.Serializer<T>)lllllllllllllIlIlIIlIIlllIlllIII;
    }
}
