package net.minecraft.world.biome;

public class BiomeOcean extends Biome
{
    @Override
    public TempCategory getTempCategory() {
        return TempCategory.OCEAN;
    }
    
    public BiomeOcean(final BiomeProperties llllllllllllllIlIlIlIlllIlllIllI) {
        super(llllllllllllllIlIlIlIlllIlllIllI);
        this.spawnableCreatureList.clear();
    }
}
