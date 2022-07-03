package com.viaversion.viabackwards.api.entities.storage;

public class EntityObjectData extends EntityData
{
    private final /* synthetic */ boolean isObject;
    private final /* synthetic */ int objectData;
    
    @Override
    public boolean isObjectType() {
        return this.isObject;
    }
    
    @Override
    public int objectData() {
        return this.objectData;
    }
    
    public EntityObjectData(final int lllIIlIllIIlIIl, final boolean lllIIlIllIIIIll, final int lllIIlIllIIIlll, final int lllIIlIllIIIllI) {
        super(lllIIlIllIIlIIl, lllIIlIllIIIlll);
        this.isObject = lllIIlIllIIIIll;
        this.objectData = lllIIlIllIIIllI;
    }
}
