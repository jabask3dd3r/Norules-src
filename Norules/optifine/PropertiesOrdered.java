package optifine;

import java.util.*;

public class PropertiesOrdered extends Properties
{
    private /* synthetic */ Set<Object> keysOrdered;
    
    @Override
    public synchronized Enumeration<Object> keys() {
        return Collections.enumeration(this.keySet());
    }
    
    @Override
    public synchronized Object put(final Object lllllllllllllllllIlllllllIlllIlI, final Object lllllllllllllllllIlllllllIllllII) {
        this.keysOrdered.add(lllllllllllllllllIlllllllIlllIlI);
        return super.put(lllllllllllllllllIlllllllIlllIlI, lllllllllllllllllIlllllllIllllII);
    }
    
    @Override
    public Set<Object> keySet() {
        final Set<Object> lllllllllllllllllIlllllllIllIlIl = super.keySet();
        this.keysOrdered.retainAll(lllllllllllllllllIlllllllIllIlIl);
        return Collections.unmodifiableSet((Set<?>)this.keysOrdered);
    }
    
    public PropertiesOrdered() {
        this.keysOrdered = new LinkedHashSet<Object>();
    }
}
