package net.minecraft.world;

public class WorldProviderSurface extends WorldProvider
{
    @Override
    public boolean canDropChunk(final int llllllllllllllllIIllllllllllIllI, final int llllllllllllllllIIllllllllllIIlI) {
        return !this.worldObj.isSpawnChunk(llllllllllllllllIIllllllllllIllI, llllllllllllllllIIllllllllllIIlI);
    }
    
    @Override
    public DimensionType getDimensionType() {
        return DimensionType.OVERWORLD;
    }
}
