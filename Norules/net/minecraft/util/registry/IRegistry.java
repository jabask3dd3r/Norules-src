package net.minecraft.util.registry;

import javax.annotation.*;
import java.util.*;

public interface IRegistry<K, V> extends Iterable<V>
{
    @Nullable
    V getObject(final K p0);
    
    void putObject(final K p0, final V p1);
    
    Set<K> getKeys();
}
