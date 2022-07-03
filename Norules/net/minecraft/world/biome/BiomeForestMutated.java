package net.minecraft.world.biome;

import java.util.*;
import net.minecraft.world.gen.feature.*;

public class BiomeForestMutated extends BiomeForest
{
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random llllllllllllllIIllIlIIlllllIIIll) {
        return llllllllllllllIIllIlIIlllllIIIll.nextBoolean() ? BiomeForest.SUPER_BIRCH_TREE : BiomeForest.BIRCH_TREE;
    }
    
    public BiomeForestMutated(final BiomeProperties llllllllllllllIIllIlIIlllllIlIIl) {
        super(Type.BIRCH, llllllllllllllIIllIlIIlllllIlIIl);
    }
}
