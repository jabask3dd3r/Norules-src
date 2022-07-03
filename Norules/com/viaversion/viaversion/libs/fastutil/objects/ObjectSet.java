package com.viaversion.viaversion.libs.fastutil.objects;

import java.util.*;

public interface ObjectSet<K> extends ObjectCollection<K>, Set<K>
{
    ObjectIterator<K> iterator();
}
