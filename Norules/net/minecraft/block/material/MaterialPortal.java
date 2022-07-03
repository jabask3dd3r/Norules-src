package net.minecraft.block.material;

public class MaterialPortal extends Material
{
    @Override
    public boolean blocksLight() {
        return false;
    }
    
    @Override
    public boolean blocksMovement() {
        return false;
    }
    
    public MaterialPortal(final MapColor lllllllllllllIlIIIIlIllIIlIllIlI) {
        super(lllllllllllllIlIIIIlIllIIlIllIlI);
    }
    
    @Override
    public boolean isSolid() {
        return false;
    }
}
