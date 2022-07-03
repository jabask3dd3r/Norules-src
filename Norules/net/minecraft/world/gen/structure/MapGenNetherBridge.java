package net.minecraft.world.gen.structure;

import net.minecraft.world.biome.*;
import com.google.common.collect.*;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import java.util.*;

public class MapGenNetherBridge extends MapGenStructure
{
    private final /* synthetic */ List<Biome.SpawnListEntry> spawnList;
    
    public MapGenNetherBridge() {
        this.spawnList = (List<Biome.SpawnListEntry>)Lists.newArrayList();
        this.spawnList.add(new Biome.SpawnListEntry(EntityBlaze.class, 10, 2, 3));
        this.spawnList.add(new Biome.SpawnListEntry(EntityPigZombie.class, 5, 4, 4));
        this.spawnList.add(new Biome.SpawnListEntry(EntityWitherSkeleton.class, 8, 5, 5));
        this.spawnList.add(new Biome.SpawnListEntry(EntitySkeleton.class, 2, 5, 5));
        this.spawnList.add(new Biome.SpawnListEntry(EntityMagmaCube.class, 3, 4, 4));
    }
    
    public List<Biome.SpawnListEntry> getSpawnList() {
        return this.spawnList;
    }
    
    @Override
    public BlockPos getClosestStrongholdPos(final World llllllllllllllIIlllIIIllIlIlIIll, final BlockPos llllllllllllllIIlllIIIllIlIlIIlI, final boolean llllllllllllllIIlllIIIllIlIlIIIl) {
        final int llllllllllllllIIlllIIIllIlIlIIII = 1000;
        final int llllllllllllllIIlllIIIllIlIIllll = llllllllllllllIIlllIIIllIlIlIIlI.getX() >> 4;
        final int llllllllllllllIIlllIIIllIlIIlllI = llllllllllllllIIlllIIIllIlIlIIlI.getZ() >> 4;
        for (int llllllllllllllIIlllIIIllIlIIllIl = 0; llllllllllllllIIlllIIIllIlIIllIl <= 1000; ++llllllllllllllIIlllIIIllIlIIllIl) {
            for (int llllllllllllllIIlllIIIllIlIIllII = -llllllllllllllIIlllIIIllIlIIllIl; llllllllllllllIIlllIIIllIlIIllII <= llllllllllllllIIlllIIIllIlIIllIl; ++llllllllllllllIIlllIIIllIlIIllII) {
                final boolean llllllllllllllIIlllIIIllIlIIlIll = llllllllllllllIIlllIIIllIlIIllII == -llllllllllllllIIlllIIIllIlIIllIl || llllllllllllllIIlllIIIllIlIIllII == llllllllllllllIIlllIIIllIlIIllIl;
                for (int llllllllllllllIIlllIIIllIlIIlIlI = -llllllllllllllIIlllIIIllIlIIllIl; llllllllllllllIIlllIIIllIlIIlIlI <= llllllllllllllIIlllIIIllIlIIllIl; ++llllllllllllllIIlllIIIllIlIIlIlI) {
                    final boolean llllllllllllllIIlllIIIllIlIIlIIl = llllllllllllllIIlllIIIllIlIIlIlI == -llllllllllllllIIlllIIIllIlIIllIl || llllllllllllllIIlllIIIllIlIIlIlI == llllllllllllllIIlllIIIllIlIIllIl;
                    if (llllllllllllllIIlllIIIllIlIIlIll || llllllllllllllIIlllIIIllIlIIlIIl) {
                        final int llllllllllllllIIlllIIIllIlIIlIII = llllllllllllllIIlllIIIllIlIIllll + llllllllllllllIIlllIIIllIlIIllII;
                        final int llllllllllllllIIlllIIIllIlIIIlll = llllllllllllllIIlllIIIllIlIIlllI + llllllllllllllIIlllIIIllIlIIlIlI;
                        if (this.canSpawnStructureAtCoords(llllllllllllllIIlllIIIllIlIIlIII, llllllllllllllIIlllIIIllIlIIIlll) && (!llllllllllllllIIlllIIIllIlIlIIIl || !llllllllllllllIIlllIIIllIlIlIIll.func_190526_b(llllllllllllllIIlllIIIllIlIIlIII, llllllllllllllIIlllIIIllIlIIIlll))) {
                            return new BlockPos((llllllllllllllIIlllIIIllIlIIlIII << 4) + 8, 64, (llllllllllllllIIlllIIIllIlIIIlll << 4) + 8);
                        }
                    }
                }
            }
        }
        return null;
    }
    
    @Override
    public String getStructureName() {
        return "Fortress";
    }
    
    @Override
    protected StructureStart getStructureStart(final int llllllllllllllIIlllIIIllIllIIlII, final int llllllllllllllIIlllIIIllIllIIllI) {
        return new Start(this.worldObj, this.rand, llllllllllllllIIlllIIIllIllIIlII, llllllllllllllIIlllIIIllIllIIllI);
    }
    
    @Override
    protected boolean canSpawnStructureAtCoords(final int llllllllllllllIIlllIIIllIlllIlII, final int llllllllllllllIIlllIIIllIlllIIll) {
        final int llllllllllllllIIlllIIIllIlllIIlI = llllllllllllllIIlllIIIllIlllIlII >> 4;
        final int llllllllllllllIIlllIIIllIlllIIIl = llllllllllllllIIlllIIIllIlllIIll >> 4;
        this.rand.setSeed((long)(llllllllllllllIIlllIIIllIlllIIlI ^ llllllllllllllIIlllIIIllIlllIIIl << 4) ^ this.worldObj.getSeed());
        this.rand.nextInt();
        return this.rand.nextInt(3) == 0 && llllllllllllllIIlllIIIllIlllIlII == (llllllllllllllIIlllIIIllIlllIIlI << 4) + 4 + this.rand.nextInt(8) && llllllllllllllIIlllIIIllIlllIIll == (llllllllllllllIIlllIIIllIlllIIIl << 4) + 4 + this.rand.nextInt(8);
    }
    
    public static class Start extends StructureStart
    {
        public Start(final World lllllllllllllIIIIlIIIllIIIlllIlI, final Random lllllllllllllIIIIlIIIllIIIlllIIl, final int lllllllllllllIIIIlIIIllIIIlllIII, final int lllllllllllllIIIIlIIIllIIIlIlllI) {
            super(lllllllllllllIIIIlIIIllIIIlllIII, lllllllllllllIIIIlIIIllIIIlIlllI);
            final StructureNetherBridgePieces.Start lllllllllllllIIIIlIIIllIIIllIllI = new StructureNetherBridgePieces.Start(lllllllllllllIIIIlIIIllIIIlllIIl, (lllllllllllllIIIIlIIIllIIIlllIII << 4) + 2, (lllllllllllllIIIIlIIIllIIIlIlllI << 4) + 2);
            this.components.add(lllllllllllllIIIIlIIIllIIIllIllI);
            lllllllllllllIIIIlIIIllIIIllIllI.buildComponent(lllllllllllllIIIIlIIIllIIIllIllI, this.components, lllllllllllllIIIIlIIIllIIIlllIIl);
            final List<StructureComponent> lllllllllllllIIIIlIIIllIIIllIlIl = lllllllllllllIIIIlIIIllIIIllIllI.pendingChildren;
            while (!lllllllllllllIIIIlIIIllIIIllIlIl.isEmpty()) {
                final int lllllllllllllIIIIlIIIllIIIllIlII = lllllllllllllIIIIlIIIllIIIlllIIl.nextInt(lllllllllllllIIIIlIIIllIIIllIlIl.size());
                final StructureComponent lllllllllllllIIIIlIIIllIIIllIIll = lllllllllllllIIIIlIIIllIIIllIlIl.remove(lllllllllllllIIIIlIIIllIIIllIlII);
                lllllllllllllIIIIlIIIllIIIllIIll.buildComponent(lllllllllllllIIIIlIIIllIIIllIllI, this.components, lllllllllllllIIIIlIIIllIIIlllIIl);
            }
            this.updateBoundingBox();
            this.setRandomHeight(lllllllllllllIIIIlIIIllIIIlllIlI, lllllllllllllIIIIlIIIllIIIlllIIl, 48, 70);
        }
        
        public Start() {
        }
    }
}
