package net.minecraft.block.material;

public class MaterialLogic extends Material
{
    public MaterialLogic(final MapColor lllllllllllllIIllIlIlIllIlllIlIl) {
        super(lllllllllllllIIllIlIlIllIlllIlIl);
        this.setAdventureModeExempt();
    }
    
    @Override
    public boolean blocksLight() {
        return false;
    }
    
    @Override
    public boolean isSolid() {
        return false;
    }
    
    @Override
    public boolean blocksMovement() {
        return false;
    }
}
