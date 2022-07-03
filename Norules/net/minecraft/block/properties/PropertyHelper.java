package net.minecraft.block.properties;

import com.google.common.base.*;

public abstract class PropertyHelper<T extends Comparable<T>> implements IProperty<T>
{
    private final /* synthetic */ Class<T> valueClass;
    private final /* synthetic */ String name;
    
    @Override
    public boolean equals(final Object llllllllllllllllIIlIlllIIllllllI) {
        if (this == llllllllllllllllIIlIlllIIllllllI) {
            return true;
        }
        if (!(llllllllllllllllIIlIlllIIllllllI instanceof PropertyHelper)) {
            return false;
        }
        final PropertyHelper<?> llllllllllllllllIIlIlllIIlllllIl = (PropertyHelper<?>)llllllllllllllllIIlIlllIIllllllI;
        return this.valueClass.equals(llllllllllllllllIIlIlllIIlllllIl.valueClass) && this.name.equals(llllllllllllllllIIlIlllIIlllllIl.name);
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public int hashCode() {
        return 31 * this.valueClass.hashCode() + this.name.hashCode();
    }
    
    protected PropertyHelper(final String llllllllllllllllIIlIlllIlIIlIIII, final Class<T> llllllllllllllllIIlIlllIlIIIllII) {
        this.valueClass = llllllllllllllllIIlIlllIlIIIllII;
        this.name = llllllllllllllllIIlIlllIlIIlIIII;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper((Object)this).add("name", (Object)this.name).add("clazz", (Object)this.valueClass).add("values", (Object)this.getAllowedValues()).toString();
    }
    
    @Override
    public Class<T> getValueClass() {
        return this.valueClass;
    }
}
