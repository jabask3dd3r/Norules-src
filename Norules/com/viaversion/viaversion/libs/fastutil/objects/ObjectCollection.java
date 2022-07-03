package com.viaversion.viaversion.libs.fastutil.objects;

import java.util.*;

public interface ObjectCollection<K> extends Collection<K>, ObjectIterable<K>
{
    ObjectIterator<K> iterator();
}
