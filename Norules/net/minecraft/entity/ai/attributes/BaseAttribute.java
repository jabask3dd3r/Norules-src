package net.minecraft.entity.ai.attributes;

import javax.annotation.*;

public abstract class BaseAttribute implements IAttribute
{
    private /* synthetic */ boolean shouldWatch;
    private final /* synthetic */ IAttribute parent;
    private final /* synthetic */ double defaultValue;
    private final /* synthetic */ String unlocalizedName;
    
    @Nullable
    @Override
    public IAttribute getParent() {
        return this.parent;
    }
    
    @Override
    public boolean getShouldWatch() {
        return this.shouldWatch;
    }
    
    public BaseAttribute setShouldWatch(final boolean llllllllllllllIIIIlIIlIIlIlIllII) {
        this.shouldWatch = llllllllllllllIIIIlIIlIIlIlIllII;
        return this;
    }
    
    @Override
    public String getAttributeUnlocalizedName() {
        return this.unlocalizedName;
    }
    
    @Override
    public double getDefaultValue() {
        return this.defaultValue;
    }
    
    @Override
    public int hashCode() {
        return this.unlocalizedName.hashCode();
    }
    
    protected BaseAttribute(@Nullable final IAttribute llllllllllllllIIIIlIIlIIlIllllIl, final String llllllllllllllIIIIlIIlIIllIIIIII, final double llllllllllllllIIIIlIIlIIlIllllll) {
        this.parent = llllllllllllllIIIIlIIlIIlIllllIl;
        this.unlocalizedName = llllllllllllllIIIIlIIlIIllIIIIII;
        this.defaultValue = llllllllllllllIIIIlIIlIIlIllllll;
        if (llllllllllllllIIIIlIIlIIllIIIIII == null) {
            throw new IllegalArgumentException("Name cannot be null!");
        }
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIIIIlIIlIIlIlIIIII) {
        return llllllllllllllIIIIlIIlIIlIlIIIII instanceof IAttribute && this.unlocalizedName.equals(((IAttribute)llllllllllllllIIIIlIIlIIlIlIIIII).getAttributeUnlocalizedName());
    }
}
