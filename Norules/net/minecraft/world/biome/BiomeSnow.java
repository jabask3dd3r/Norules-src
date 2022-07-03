package net.minecraft.world.biome;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.init.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;
import java.util.*;

public class BiomeSnow extends Biome
{
    private final /* synthetic */ WorldGenIceSpike iceSpike;
    private final /* synthetic */ boolean superIcy;
    private final /* synthetic */ WorldGenIcePath icePatch;
    
    @Override
    public void decorate(final World lllllllllllllIllllIIllIIlIIIIIIl, final Random lllllllllllllIllllIIllIIlIIIlIlI, final BlockPos lllllllllllllIllllIIllIIlIIIlIIl) {
        if (this.superIcy) {
            for (int lllllllllllllIllllIIllIIlIIIlIII = 0; lllllllllllllIllllIIllIIlIIIlIII < 3; ++lllllllllllllIllllIIllIIlIIIlIII) {
                final int lllllllllllllIllllIIllIIlIIIIlll = lllllllllllllIllllIIllIIlIIIlIlI.nextInt(16) + 8;
                final int lllllllllllllIllllIIllIIlIIIIllI = lllllllllllllIllllIIllIIlIIIlIlI.nextInt(16) + 8;
                this.iceSpike.generate(lllllllllllllIllllIIllIIlIIIIIIl, lllllllllllllIllllIIllIIlIIIlIlI, lllllllllllllIllllIIllIIlIIIIIIl.getHeight(lllllllllllllIllllIIllIIlIIIlIIl.add(lllllllllllllIllllIIllIIlIIIIlll, 0, lllllllllllllIllllIIllIIlIIIIllI)));
            }
            for (int lllllllllllllIllllIIllIIlIIIIlIl = 0; lllllllllllllIllllIIllIIlIIIIlIl < 2; ++lllllllllllllIllllIIllIIlIIIIlIl) {
                final int lllllllllllllIllllIIllIIlIIIIlII = lllllllllllllIllllIIllIIlIIIlIlI.nextInt(16) + 8;
                final int lllllllllllllIllllIIllIIlIIIIIll = lllllllllllllIllllIIllIIlIIIlIlI.nextInt(16) + 8;
                this.icePatch.generate(lllllllllllllIllllIIllIIlIIIIIIl, lllllllllllllIllllIIllIIlIIIlIlI, lllllllllllllIllllIIllIIlIIIIIIl.getHeight(lllllllllllllIllllIIllIIlIIIlIIl.add(lllllllllllllIllllIIllIIlIIIIlII, 0, lllllllllllllIllllIIllIIlIIIIIll)));
            }
        }
        super.decorate(lllllllllllllIllllIIllIIlIIIIIIl, lllllllllllllIllllIIllIIlIIIlIlI, lllllllllllllIllllIIllIIlIIIlIIl);
    }
    
    @Override
    public float getSpawningChance() {
        return 0.07f;
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random lllllllllllllIllllIIllIIIllllIlI) {
        return new WorldGenTaiga2(false);
    }
    
    public BiomeSnow(final boolean lllllllllllllIllllIIllIIlIIllIII, final BiomeProperties lllllllllllllIllllIIllIIlIIlllII) {
        super(lllllllllllllIllllIIllIIlIIlllII);
        this.iceSpike = new WorldGenIceSpike();
        this.icePatch = new WorldGenIcePath(4);
        this.superIcy = lllllllllllllIllllIIllIIlIIllIII;
        if (lllllllllllllIllllIIllIIlIIllIII) {
            this.topBlock = Blocks.SNOW.getDefaultState();
        }
        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityRabbit.class, 10, 2, 3));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPolarBear.class, 1, 1, 2));
        final Iterator<SpawnListEntry> lllllllllllllIllllIIllIIlIIllIll = this.spawnableMonsterList.iterator();
        while (lllllllllllllIllllIIllIIlIIllIll.hasNext()) {
            final SpawnListEntry lllllllllllllIllllIIllIIlIIllIlI = lllllllllllllIllllIIllIIlIIllIll.next();
            if (lllllllllllllIllllIIllIIlIIllIlI.entityClass == EntitySkeleton.class) {
                lllllllllllllIllllIIllIIlIIllIll.remove();
            }
        }
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 20, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityStray.class, 80, 4, 4));
    }
}
