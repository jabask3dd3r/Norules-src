package net.minecraft.world.biome;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.init.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;
import java.util.*;

public class BiomeDesert extends Biome
{
    @Override
    public void decorate(final World llllllllllllllIIIlIIIIllIlIlllII, final Random llllllllllllllIIIlIIIIllIlIllIll, final BlockPos llllllllllllllIIIlIIIIllIlIlIIll) {
        super.decorate(llllllllllllllIIIlIIIIllIlIlllII, llllllllllllllIIIlIIIIllIlIllIll, llllllllllllllIIIlIIIIllIlIlIIll);
        if (llllllllllllllIIIlIIIIllIlIllIll.nextInt(1000) == 0) {
            final int llllllllllllllIIIlIIIIllIlIllIIl = llllllllllllllIIIlIIIIllIlIllIll.nextInt(16) + 8;
            final int llllllllllllllIIIlIIIIllIlIllIII = llllllllllllllIIIlIIIIllIlIllIll.nextInt(16) + 8;
            final BlockPos llllllllllllllIIIlIIIIllIlIlIlll = llllllllllllllIIIlIIIIllIlIlllII.getHeight(llllllllllllllIIIlIIIIllIlIlIIll.add(llllllllllllllIIIlIIIIllIlIllIIl, 0, llllllllllllllIIIlIIIIllIlIllIII)).up();
            new WorldGenDesertWells().generate(llllllllllllllIIIlIIIIllIlIlllII, llllllllllllllIIIlIIIIllIlIllIll, llllllllllllllIIIlIIIIllIlIlIlll);
        }
        if (llllllllllllllIIIlIIIIllIlIllIll.nextInt(64) == 0) {
            new WorldGenFossils().generate(llllllllllllllIIIlIIIIllIlIlllII, llllllllllllllIIIlIIIIllIlIllIll, llllllllllllllIIIlIIIIllIlIlIIll);
        }
    }
    
    public BiomeDesert(final BiomeProperties llllllllllllllIIIlIIIIllIllIIlll) {
        super(llllllllllllllIIIlIIIIllIllIIlll);
        this.spawnableCreatureList.clear();
        this.topBlock = Blocks.SAND.getDefaultState();
        this.fillerBlock = Blocks.SAND.getDefaultState();
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.deadBushPerChunk = 2;
        this.theBiomeDecorator.reedsPerChunk = 50;
        this.theBiomeDecorator.cactiPerChunk = 10;
        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityRabbit.class, 4, 2, 3));
        final Iterator<SpawnListEntry> llllllllllllllIIIlIIIIllIllIlIlI = this.spawnableMonsterList.iterator();
        while (llllllllllllllIIIlIIIIllIllIlIlI.hasNext()) {
            final SpawnListEntry llllllllllllllIIIlIIIIllIllIlIIl = llllllllllllllIIIlIIIIllIllIlIlI.next();
            if (llllllllllllllIIIlIIIIllIllIlIIl.entityClass == EntityZombie.class || llllllllllllllIIIlIIIIllIllIlIIl.entityClass == EntityZombieVillager.class) {
                llllllllllllllIIIlIIIIllIllIlIlI.remove();
            }
        }
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 19, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombieVillager.class, 1, 1, 1));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityHusk.class, 80, 4, 4));
    }
}
