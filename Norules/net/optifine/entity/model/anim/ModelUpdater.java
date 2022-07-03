package net.optifine.entity.model.anim;

public class ModelUpdater
{
    private /* synthetic */ ModelVariableUpdater[] modelVariableUpdaters;
    
    public boolean initialize(final IModelResolver llllllllllllllIIllllIlllIlIIlIll) {
        for (int llllllllllllllIIllllIlllIlIIlIlI = 0; llllllllllllllIIllllIlllIlIIlIlI < this.modelVariableUpdaters.length; ++llllllllllllllIIllllIlllIlIIlIlI) {
            final ModelVariableUpdater llllllllllllllIIllllIlllIlIIlIIl = this.modelVariableUpdaters[llllllllllllllIIllllIlllIlIIlIlI];
            if (!llllllllllllllIIllllIlllIlIIlIIl.initialize(llllllllllllllIIllllIlllIlIIlIll)) {
                return false;
            }
        }
        return true;
    }
    
    public ModelUpdater(final ModelVariableUpdater[] llllllllllllllIIllllIlllIlIllIlI) {
        this.modelVariableUpdaters = llllllllllllllIIllllIlllIlIllIlI;
    }
    
    public void update() {
        for (int llllllllllllllIIllllIlllIlIlIlIl = 0; llllllllllllllIIllllIlllIlIlIlIl < this.modelVariableUpdaters.length; ++llllllllllllllIIllllIlllIlIlIlIl) {
            final ModelVariableUpdater llllllllllllllIIllllIlllIlIlIlII = this.modelVariableUpdaters[llllllllllllllIIllllIlllIlIlIlIl];
            llllllllllllllIIllllIlllIlIlIlII.update();
        }
    }
}
