package net.minecraft.world.biome;

import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;

public class BiomeHell extends Biome
{
    public BiomeHell(final BiomeProperties llllllllllllllIIIlIIIlIlllIllIll) {
        super(llllllllllllllIIIlIIIlIlllIllIll);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntityGhast.class, 50, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityPigZombie.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityMagmaCube.class, 2, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 1, 4, 4));
        this.theBiomeDecorator = new BiomeHellDecorator();
    }
}
