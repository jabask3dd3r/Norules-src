package net.minecraft.block.material;

public class MaterialLiquid extends Material
{
    public MaterialLiquid(final MapColor lllllllllllllllIIlIlIllIllIllllI) {
        super(lllllllllllllllIIlIlIllIllIllllI);
        this.setReplaceable();
        this.setNoPushMobility();
    }
    
    @Override
    public boolean isLiquid() {
        return true;
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
