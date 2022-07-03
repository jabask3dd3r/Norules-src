package com.viaversion.viaversion.util;

import org.yaml.snakeyaml.constructor.*;
import org.yaml.snakeyaml.nodes.*;
import java.util.concurrent.*;
import java.util.*;

public class YamlConstructor extends SafeConstructor
{
    public YamlConstructor() {
        this.yamlClassConstructors.put(NodeId.mapping, new ConstructYamlMap());
        this.yamlConstructors.put(Tag.OMAP, new ConstructYamlOmap());
    }
    
    class ConstructYamlOmap extends SafeConstructor.ConstructYamlOmap
    {
        @Override
        public Object construct(final Node lllllllllllllIlIIIIIIIllIlIllIII) {
            final Object lllllllllllllIlIIIIIIIllIlIlIlll = super.construct(lllllllllllllIlIIIIIIIllIlIllIII);
            if (lllllllllllllIlIIIIIIIllIlIlIlll instanceof Map && !(lllllllllllllIlIIIIIIIllIlIlIlll instanceof ConcurrentSkipListMap)) {
                return new ConcurrentSkipListMap((java.util.Map<?, ?>)lllllllllllllIlIIIIIIIllIlIlIlll);
            }
            return lllllllllllllIlIIIIIIIllIlIlIlll;
        }
    }
    
    class Map extends ConstructYamlMap
    {
        @Override
        public Object construct(final Node lllllllllllllIlIlIIllIllIlllIIII) {
            final Object lllllllllllllIlIlIIllIllIlllIIlI = super.construct(lllllllllllllIlIlIIllIllIlllIIII);
            if (lllllllllllllIlIlIIllIllIlllIIlI instanceof Map && !(lllllllllllllIlIlIIllIllIlllIIlI instanceof ConcurrentSkipListMap)) {
                return new ConcurrentSkipListMap((java.util.Map<?, ?>)lllllllllllllIlIlIIllIllIlllIIlI);
            }
            return lllllllllllllIlIlIIllIllIlllIIlI;
        }
    }
}
