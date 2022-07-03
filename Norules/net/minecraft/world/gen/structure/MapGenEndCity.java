package net.minecraft.world.gen.structure;

import net.minecraft.world.gen.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;

public class MapGenEndCity extends MapGenStructure
{
    private final /* synthetic */ ChunkGeneratorEnd endProvider;
    
    public MapGenEndCity(final ChunkGeneratorEnd lllllllIlllIIII) {
        this.endProvider = lllllllIlllIIII;
    }
    
    @Override
    protected StructureStart getStructureStart(final int lllllllIlIIllll, final int lllllllIlIIlIll) {
        return new Start(this.worldObj, this.endProvider, this.rand, lllllllIlIIllll, lllllllIlIIlIll);
    }
    
    private static int func_191070_b(final int lllllllIIlIIlII, final int lllllllIIlIIIll, final ChunkGeneratorEnd lllllllIIlIllll) {
        final Random lllllllIIlIlllI = new Random(lllllllIIlIIlII + lllllllIIlIIIll * 10387313);
        final Rotation lllllllIIlIllIl = Rotation.values()[lllllllIIlIlllI.nextInt(Rotation.values().length)];
        final ChunkPrimer lllllllIIlIllII = new ChunkPrimer();
        lllllllIIlIllll.setBlocksInChunk(lllllllIIlIIlII, lllllllIIlIIIll, lllllllIIlIllII);
        int lllllllIIlIlIll = 5;
        int lllllllIIlIlIlI = 5;
        if (lllllllIIlIllIl == Rotation.CLOCKWISE_90) {
            lllllllIIlIlIll = -5;
        }
        else if (lllllllIIlIllIl == Rotation.CLOCKWISE_180) {
            lllllllIIlIlIll = -5;
            lllllllIIlIlIlI = -5;
        }
        else if (lllllllIIlIllIl == Rotation.COUNTERCLOCKWISE_90) {
            lllllllIIlIlIlI = -5;
        }
        final int lllllllIIlIlIIl = lllllllIIlIllII.findGroundBlockIdx(7, 7);
        final int lllllllIIlIlIII = lllllllIIlIllII.findGroundBlockIdx(7, 7 + lllllllIIlIlIlI);
        final int lllllllIIlIIlll = lllllllIIlIllII.findGroundBlockIdx(7 + lllllllIIlIlIll, 7);
        final int lllllllIIlIIllI = lllllllIIlIllII.findGroundBlockIdx(7 + lllllllIIlIlIll, 7 + lllllllIIlIlIlI);
        final int lllllllIIlIIlIl = Math.min(Math.min(lllllllIIlIlIIl, lllllllIIlIlIII), Math.min(lllllllIIlIIlll, lllllllIIlIIllI));
        return lllllllIIlIIlIl;
    }
    
    @Override
    public String getStructureName() {
        return "EndCity";
    }
    
    @Override
    protected boolean canSpawnStructureAtCoords(int lllllllIllIIlII, int lllllllIlIllIlI) {
        final int lllllllIllIIIlI = lllllllIllIIlII;
        final int lllllllIllIIIIl = lllllllIlIllIlI;
        if (lllllllIllIIlII < 0) {
            lllllllIllIIlII -= 19;
        }
        if (lllllllIlIllIlI < 0) {
            lllllllIlIllIlI -= 19;
        }
        int lllllllIllIIIII = lllllllIllIIlII / 20;
        int lllllllIlIlllll = lllllllIlIllIlI / 20;
        final Random lllllllIlIllllI = this.worldObj.setRandomSeed(lllllllIllIIIII, lllllllIlIlllll, 10387313);
        lllllllIllIIIII *= 20;
        lllllllIlIlllll *= 20;
        lllllllIllIIIII += (lllllllIlIllllI.nextInt(9) + lllllllIlIllllI.nextInt(9)) / 2;
        lllllllIlIlllll += (lllllllIlIllllI.nextInt(9) + lllllllIlIllllI.nextInt(9)) / 2;
        if (lllllllIllIIIlI == lllllllIllIIIII && lllllllIllIIIIl == lllllllIlIlllll && this.endProvider.isIslandChunk(lllllllIllIIIlI, lllllllIllIIIIl)) {
            final int lllllllIlIlllIl = func_191070_b(lllllllIllIIIlI, lllllllIllIIIIl, this.endProvider);
            return lllllllIlIlllIl >= 60;
        }
        return false;
    }
    
    @Override
    public BlockPos getClosestStrongholdPos(final World lllllllIlIIIlIl, final BlockPos lllllllIlIIIlII, final boolean lllllllIIllllll) {
        this.worldObj = lllllllIlIIIlIl;
        return MapGenStructure.func_191069_a(lllllllIlIIIlIl, this, lllllllIlIIIlII, 20, 11, 10387313, true, 100, lllllllIIllllll);
    }
    
    public static class Start extends StructureStart
    {
        private /* synthetic */ boolean isSizeable;
        
        private void create(final World lllllllllllllIIIIIIlIlIllIIlIIII, final ChunkGeneratorEnd lllllllllllllIIIIIIlIlIllIIIllll, final Random lllllllllllllIIIIIIlIlIllIIIlllI, final int lllllllllllllIIIIIIlIlIllIIlIlll, final int lllllllllllllIIIIIIlIlIllIIIllII) {
            final Random lllllllllllllIIIIIIlIlIllIIlIlIl = new Random(lllllllllllllIIIIIIlIlIllIIlIlll + lllllllllllllIIIIIIlIlIllIIIllII * 10387313);
            final Rotation lllllllllllllIIIIIIlIlIllIIlIlII = Rotation.values()[lllllllllllllIIIIIIlIlIllIIlIlIl.nextInt(Rotation.values().length)];
            final int lllllllllllllIIIIIIlIlIllIIlIIll = func_191070_b(lllllllllllllIIIIIIlIlIllIIlIlll, lllllllllllllIIIIIIlIlIllIIIllII, lllllllllllllIIIIIIlIlIllIIIllll);
            if (lllllllllllllIIIIIIlIlIllIIlIIll < 60) {
                this.isSizeable = false;
            }
            else {
                final BlockPos lllllllllllllIIIIIIlIlIllIIlIIlI = new BlockPos(lllllllllllllIIIIIIlIlIllIIlIlll * 16 + 8, lllllllllllllIIIIIIlIlIllIIlIIll, lllllllllllllIIIIIIlIlIllIIIllII * 16 + 8);
                StructureEndCityPieces.func_191087_a(lllllllllllllIIIIIIlIlIllIIlIIII.getSaveHandler().getStructureTemplateManager(), lllllllllllllIIIIIIlIlIllIIlIIlI, lllllllllllllIIIIIIlIlIllIIlIlII, this.components, lllllllllllllIIIIIIlIlIllIIIlllI);
                this.updateBoundingBox();
                this.isSizeable = true;
            }
        }
        
        public Start(final World lllllllllllllIIIIIIlIlIllIllIIII, final ChunkGeneratorEnd lllllllllllllIIIIIIlIlIllIlIlIIl, final Random lllllllllllllIIIIIIlIlIllIlIlIII, final int lllllllllllllIIIIIIlIlIllIlIllIl, final int lllllllllllllIIIIIIlIlIllIlIIllI) {
            super(lllllllllllllIIIIIIlIlIllIlIllIl, lllllllllllllIIIIIIlIlIllIlIIllI);
            this.create(lllllllllllllIIIIIIlIlIllIllIIII, lllllllllllllIIIIIIlIlIllIlIlIIl, lllllllllllllIIIIIIlIlIllIlIlIII, lllllllllllllIIIIIIlIlIllIlIllIl, lllllllllllllIIIIIIlIlIllIlIIllI);
        }
        
        @Override
        public boolean isSizeableStructure() {
            return this.isSizeable;
        }
        
        public Start() {
        }
    }
}
