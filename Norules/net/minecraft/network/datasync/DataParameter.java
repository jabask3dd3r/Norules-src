package net.minecraft.network.datasync;

public class DataParameter<T>
{
    private final /* synthetic */ DataSerializer<T> serializer;
    private final /* synthetic */ int id;
    
    @Override
    public boolean equals(final Object lllllllllllllllIlIIIIIIllIIIllll) {
        if (this == lllllllllllllllIlIIIIIIllIIIllll) {
            return true;
        }
        if (lllllllllllllllIlIIIIIIllIIIllll != null && this.getClass() == lllllllllllllllIlIIIIIIllIIIllll.getClass()) {
            final DataParameter<?> lllllllllllllllIlIIIIIIllIIIlllI = (DataParameter<?>)lllllllllllllllIlIIIIIIllIIIllll;
            return this.id == lllllllllllllllIlIIIIIIllIIIlllI.id;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.id;
    }
    
    public DataParameter(final int lllllllllllllllIlIIIIIIllIIllIll, final DataSerializer<T> lllllllllllllllIlIIIIIIllIIlllIl) {
        this.id = lllllllllllllllIlIIIIIIllIIllIll;
        this.serializer = lllllllllllllllIlIIIIIIllIIlllIl;
    }
    
    public int getId() {
        return this.id;
    }
    
    public DataSerializer<T> getSerializer() {
        return this.serializer;
    }
}
