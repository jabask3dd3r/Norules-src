package net.minecraft.block.material;

public class MaterialTransparent extends Material
{
    @Override
    public boolean blocksMovement() {
        return false;
    }
    
    @Override
    public boolean isSolid() {
        return false;
    }
    
    public MaterialTransparent(final MapColor lllllllllllllIllIlIIllIllIIIIIlI) {
        super(lllllllllllllIllIlIIllIllIIIIIlI);
        this.setReplaceable();
    }
    
    @Override
    public boolean blocksLight() {
        return false;
    }
}
