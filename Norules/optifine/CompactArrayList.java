package optifine;

import java.util.*;

public class CompactArrayList
{
    private /* synthetic */ ArrayList list;
    private /* synthetic */ int initialCapacity;
    private /* synthetic */ int countValid;
    private /* synthetic */ float loadFactor;
    
    public boolean contains(final Object llllllllllllllIIlllIIlIIIllllIIl) {
        return this.list.contains(llllllllllllllIIlllIIlIIIllllIIl);
    }
    
    public CompactArrayList() {
        this(10, 0.75f);
    }
    
    public void compact() {
        if (this.countValid <= 0 && this.list.size() <= 0) {
            this.clear();
        }
        else if (this.list.size() > this.initialCapacity) {
            final float llllllllllllllIIlllIIlIIlIIlllIl = this.countValid * 1.0f / this.list.size();
            if (llllllllllllllIIlllIIlIIlIIlllIl <= this.loadFactor) {
                int llllllllllllllIIlllIIlIIlIIllIll = 0;
                for (int llllllllllllllIIlllIIlIIlIIllIIl = 0; llllllllllllllIIlllIIlIIlIIllIIl < this.list.size(); ++llllllllllllllIIlllIIlIIlIIllIIl) {
                    final Object llllllllllllllIIlllIIlIIlIIlIlll = this.list.get(llllllllllllllIIlllIIlIIlIIllIIl);
                    if (llllllllllllllIIlllIIlIIlIIlIlll != null) {
                        if (llllllllllllllIIlllIIlIIlIIllIIl != llllllllllllllIIlllIIlIIlIIllIll) {
                            this.list.set(llllllllllllllIIlllIIlIIlIIllIll, llllllllllllllIIlllIIlIIlIIlIlll);
                        }
                        ++llllllllllllllIIlllIIlIIlIIllIll;
                    }
                }
                for (int llllllllllllllIIlllIIlIIlIIlIlIl = this.list.size() - 1; llllllllllllllIIlllIIlIIlIIlIlIl >= llllllllllllllIIlllIIlIIlIIllIll; --llllllllllllllIIlllIIlIIlIIlIlIl) {
                    this.list.remove(llllllllllllllIIlllIIlIIlIIlIlIl);
                }
            }
        }
    }
    
    public Object get(final int llllllllllllllIIlllIIlIIIlllIIII) {
        return this.list.get(llllllllllllllIIlllIIlIIIlllIIII);
    }
    
    public int getCountValid() {
        return this.countValid;
    }
    
    public int size() {
        return this.list.size();
    }
    
    public boolean add(final Object llllllllllllllIIlllIIlIIlllllIII) {
        if (llllllllllllllIIlllIIlIIlllllIII != null) {
            ++this.countValid;
        }
        return this.list.add(llllllllllllllIIlllIIlIIlllllIII);
    }
    
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
    
    public void clear() {
        this.list.clear();
        this.countValid = 0;
    }
    
    public void add(final int llllllllllllllIIlllIIlIIllllllIl, final Object llllllllllllllIIlllIIlIIllllllll) {
        if (llllllllllllllIIlllIIlIIllllllll != null) {
            ++this.countValid;
        }
        this.list.add(llllllllllllllIIlllIIlIIllllllIl, llllllllllllllIIlllIIlIIllllllll);
    }
    
    public Object set(final int llllllllllllllIIlllIIlIIlllIllII, final Object llllllllllllllIIlllIIlIIlllIlIll) {
        final Object llllllllllllllIIlllIIlIIlllIlllI = this.list.set(llllllllllllllIIlllIIlIIlllIllII, llllllllllllllIIlllIIlIIlllIlIll);
        if (llllllllllllllIIlllIIlIIlllIlIll != llllllllllllllIIlllIIlIIlllIlllI) {
            if (llllllllllllllIIlllIIlIIlllIlllI == null) {
                ++this.countValid;
            }
            if (llllllllllllllIIlllIIlIIlllIlIll == null) {
                --this.countValid;
            }
        }
        return llllllllllllllIIlllIIlIIlllIlllI;
    }
    
    public CompactArrayList(final int llllllllllllllIIlllIIlIlIIIIIllI, final float llllllllllllllIIlllIIlIlIIIIIlIl) {
        this.list = null;
        this.initialCapacity = 0;
        this.loadFactor = 1.0f;
        this.countValid = 0;
        this.list = new ArrayList(llllllllllllllIIlllIIlIlIIIIIllI);
        this.initialCapacity = llllllllllllllIIlllIIlIlIIIIIllI;
        this.loadFactor = llllllllllllllIIlllIIlIlIIIIIlIl;
    }
    
    public Object remove(final int llllllllllllllIIlllIIlIIlllIIIlI) {
        final Object llllllllllllllIIlllIIlIIlllIIlII = this.list.remove(llllllllllllllIIlllIIlIIlllIIIlI);
        if (llllllllllllllIIlllIIlIIlllIIlII != null) {
            --this.countValid;
        }
        return llllllllllllllIIlllIIlIIlllIIlII;
    }
    
    public CompactArrayList(final int llllllllllllllIIlllIIlIlIIIlIIII) {
        this(llllllllllllllIIlllIIlIlIIIlIIII, 0.75f);
    }
}
