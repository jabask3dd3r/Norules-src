package net.optifine.entity.model;

import net.minecraft.client.model.*;

public abstract class ModelAdapter
{
    private /* synthetic */ float shadowSize;
    private /* synthetic */ Class entityClass;
    private /* synthetic */ String name;
    
    public float getShadowSize() {
        return this.shadowSize;
    }
    
    public abstract ModelBase makeModel();
    
    public String getName() {
        return this.name;
    }
    
    public abstract ModelRenderer getModelRenderer(final ModelBase p0, final String p1);
    
    public Class getEntityClass() {
        return this.entityClass;
    }
    
    public ModelAdapter(final Class llllllllllllllllIIllllIIIIIIIIlI, final String llllllllllllllllIIllllIIIIIIIIIl, final float llllllllllllllllIIllllIIIIIIIIII) {
        this.entityClass = llllllllllllllllIIllllIIIIIIIIlI;
        this.name = llllllllllllllllIIllllIIIIIIIIIl;
        this.shadowSize = llllllllllllllllIIllllIIIIIIIIII;
    }
    
    public abstract IEntityRenderer makeEntityRender(final ModelBase p0, final float p1);
}
