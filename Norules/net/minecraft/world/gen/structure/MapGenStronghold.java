package net.minecraft.world.gen.structure;

import net.minecraft.world.biome.*;
import net.minecraft.world.*;
import it.unimi.dsi.fastutil.objects.*;
import java.util.*;
import net.minecraft.util.math.*;
import com.google.common.collect.*;

public class MapGenStronghold extends MapGenStructure
{
    private /* synthetic */ double distance;
    private /* synthetic */ boolean ranBiomeCheck;
    private /* synthetic */ ChunkPos[] structureCoords;
    private final /* synthetic */ List<Biome> allowedBiomes;
    private /* synthetic */ int spread;
    
    @Override
    public String getStructureName() {
        return "Stronghold";
    }
    
    @Override
    protected StructureStart getStructureStart(final int lllllllllllllIIIIllIlIlIIllIIIll, final int lllllllllllllIIIIllIlIlIIllIIIlI) {
        Start lllllllllllllIIIIllIlIlIIllIIIIl;
        for (lllllllllllllIIIIllIlIlIIllIIIIl = new Start(this.worldObj, this.rand, lllllllllllllIIIIllIlIlIIllIIIll, lllllllllllllIIIIllIlIlIIllIIIlI); lllllllllllllIIIIllIlIlIIllIIIIl.getComponents().isEmpty() || lllllllllllllIIIIllIlIlIIllIIIIl.getComponents().get(0).strongholdPortalRoom == null; lllllllllllllIIIIllIlIlIIllIIIIl = new Start(this.worldObj, this.rand, lllllllllllllIIIIllIlIlIIllIIIll, lllllllllllllIIIIllIlIlIIllIIIlI)) {}
        return lllllllllllllIIIIllIlIlIIllIIIIl;
    }
    
    @Override
    protected boolean canSpawnStructureAtCoords(final int lllllllllllllIIIIllIlIlIlIIlIllI, final int lllllllllllllIIIIllIlIlIlIIllIIl) {
        if (!this.ranBiomeCheck) {
            this.generatePositions();
            this.ranBiomeCheck = true;
        }
        final String lllllllllllllIIIIllIlIlIlIIlIIIl;
        final Exception lllllllllllllIIIIllIlIlIlIIlIIlI = (Exception)((ChunkPos[])(Object)(lllllllllllllIIIIllIlIlIlIIlIIIl = (String)(Object)this.structureCoords)).length;
        for (boolean lllllllllllllIIIIllIlIlIlIIlIIll = false; lllllllllllllIIIIllIlIlIlIIlIIll < lllllllllllllIIIIllIlIlIlIIlIIlI; ++lllllllllllllIIIIllIlIlIlIIlIIll) {
            final ChunkPos lllllllllllllIIIIllIlIlIlIIllIII = lllllllllllllIIIIllIlIlIlIIlIIIl[lllllllllllllIIIIllIlIlIlIIlIIll];
            if (lllllllllllllIIIIllIlIlIlIIlIllI == lllllllllllllIIIIllIlIlIlIIllIII.chunkXPos && lllllllllllllIIIIllIlIlIlIIllIIl == lllllllllllllIIIIllIlIlIlIIllIII.chunkZPos) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public BlockPos getClosestStrongholdPos(final World lllllllllllllIIIIllIlIlIlIllIlII, final BlockPos lllllllllllllIIIIllIlIlIlIllIIll, final boolean lllllllllllllIIIIllIlIlIlIllIIlI) {
        if (!this.ranBiomeCheck) {
            this.generatePositions();
            this.ranBiomeCheck = true;
        }
        BlockPos lllllllllllllIIIIllIlIlIlIllIIIl = null;
        final BlockPos.MutableBlockPos lllllllllllllIIIIllIlIlIlIllIIII = new BlockPos.MutableBlockPos(0, 0, 0);
        double lllllllllllllIIIIllIlIlIlIlIllll = Double.MAX_VALUE;
        final float lllllllllllllIIIIllIlIlIlIlIIlII;
        final short lllllllllllllIIIIllIlIlIlIlIIlIl = (short)((ChunkPos[])(Object)(lllllllllllllIIIIllIlIlIlIlIIlII = (float)(Object)this.structureCoords)).length;
        for (boolean lllllllllllllIIIIllIlIlIlIlIIllI = false; (lllllllllllllIIIIllIlIlIlIlIIllI ? 1 : 0) < lllllllllllllIIIIllIlIlIlIlIIlIl; ++lllllllllllllIIIIllIlIlIlIlIIllI) {
            final ChunkPos lllllllllllllIIIIllIlIlIlIlIlllI = lllllllllllllIIIIllIlIlIlIlIIlII[lllllllllllllIIIIllIlIlIlIlIIllI];
            lllllllllllllIIIIllIlIlIlIllIIII.setPos((lllllllllllllIIIIllIlIlIlIlIlllI.chunkXPos << 4) + 8, 32, (lllllllllllllIIIIllIlIlIlIlIlllI.chunkZPos << 4) + 8);
            final double lllllllllllllIIIIllIlIlIlIlIllIl = lllllllllllllIIIIllIlIlIlIllIIII.distanceSq(lllllllllllllIIIIllIlIlIlIllIIll);
            if (lllllllllllllIIIIllIlIlIlIllIIIl == null) {
                lllllllllllllIIIIllIlIlIlIllIIIl = new BlockPos(lllllllllllllIIIIllIlIlIlIllIIII);
                lllllllllllllIIIIllIlIlIlIlIllll = lllllllllllllIIIIllIlIlIlIlIllIl;
            }
            else if (lllllllllllllIIIIllIlIlIlIlIllIl < lllllllllllllIIIIllIlIlIlIlIllll) {
                lllllllllllllIIIIllIlIlIlIllIIIl = new BlockPos(lllllllllllllIIIIllIlIlIlIllIIII);
                lllllllllllllIIIIllIlIlIlIlIllll = lllllllllllllIIIIllIlIlIlIlIllIl;
            }
        }
        return lllllllllllllIIIIllIlIlIlIllIIIl;
    }
    
    private void generatePositions() {
        this.initializeStructureData(this.worldObj);
        int lllllllllllllIIIIllIlIlIlIIIIIlI = 0;
        for (final StructureStart lllllllllllllIIIIllIlIlIlIIIIIII : this.structureMap.values()) {
            if (lllllllllllllIIIIllIlIlIlIIIIIlI < this.structureCoords.length) {
                this.structureCoords[lllllllllllllIIIIllIlIlIlIIIIIlI++] = new ChunkPos(lllllllllllllIIIIllIlIlIlIIIIIII.getChunkPosX(), lllllllllllllIIIIllIlIlIlIIIIIII.getChunkPosZ());
            }
        }
        final Random lllllllllllllIIIIllIlIlIIlllllll = new Random();
        lllllllllllllIIIIllIlIlIIlllllll.setSeed(this.worldObj.getSeed());
        double lllllllllllllIIIIllIlIlIIllllllI = lllllllllllllIIIIllIlIlIIlllllll.nextDouble() * 3.141592653589793 * 2.0;
        int lllllllllllllIIIIllIlIlIIlllllIl = 0;
        int lllllllllllllIIIIllIlIlIIlllllII = 0;
        final int lllllllllllllIIIIllIlIlIIllllIll = this.structureMap.size();
        if (lllllllllllllIIIIllIlIlIIllllIll < this.structureCoords.length) {
            for (int lllllllllllllIIIIllIlIlIIllllIlI = 0; lllllllllllllIIIIllIlIlIIllllIlI < this.structureCoords.length; ++lllllllllllllIIIIllIlIlIIllllIlI) {
                final double lllllllllllllIIIIllIlIlIIllllIIl = 4.0 * this.distance + this.distance * lllllllllllllIIIIllIlIlIIlllllIl * 6.0 + (lllllllllllllIIIIllIlIlIIlllllll.nextDouble() - 0.5) * this.distance * 2.5;
                int lllllllllllllIIIIllIlIlIIllllIII = (int)Math.round(Math.cos(lllllllllllllIIIIllIlIlIIllllllI) * lllllllllllllIIIIllIlIlIIllllIIl);
                int lllllllllllllIIIIllIlIlIIlllIlll = (int)Math.round(Math.sin(lllllllllllllIIIIllIlIlIIllllllI) * lllllllllllllIIIIllIlIlIIllllIIl);
                final BlockPos lllllllllllllIIIIllIlIlIIlllIllI = this.worldObj.getBiomeProvider().findBiomePosition((lllllllllllllIIIIllIlIlIIllllIII << 4) + 8, (lllllllllllllIIIIllIlIlIIlllIlll << 4) + 8, 112, this.allowedBiomes, lllllllllllllIIIIllIlIlIIlllllll);
                if (lllllllllllllIIIIllIlIlIIlllIllI != null) {
                    lllllllllllllIIIIllIlIlIIllllIII = lllllllllllllIIIIllIlIlIIlllIllI.getX() >> 4;
                    lllllllllllllIIIIllIlIlIIlllIlll = lllllllllllllIIIIllIlIlIIlllIllI.getZ() >> 4;
                }
                if (lllllllllllllIIIIllIlIlIIllllIlI >= lllllllllllllIIIIllIlIlIIllllIll) {
                    this.structureCoords[lllllllllllllIIIIllIlIlIIllllIlI] = new ChunkPos(lllllllllllllIIIIllIlIlIIllllIII, lllllllllllllIIIIllIlIlIIlllIlll);
                }
                lllllllllllllIIIIllIlIlIIllllllI += 6.283185307179586 / this.spread;
                if (++lllllllllllllIIIIllIlIlIIlllllII == this.spread) {
                    ++lllllllllllllIIIIllIlIlIIlllllIl;
                    lllllllllllllIIIIllIlIlIIlllllII = 0;
                    this.spread += 2 * this.spread / (lllllllllllllIIIIllIlIlIIlllllIl + 1);
                    this.spread = Math.min(this.spread, this.structureCoords.length - lllllllllllllIIIIllIlIlIIllllIlI);
                    lllllllllllllIIIIllIlIlIIllllllI += lllllllllllllIIIIllIlIlIIlllllll.nextDouble() * 3.141592653589793 * 2.0;
                }
            }
        }
    }
    
    public MapGenStronghold(final Map<String, String> lllllllllllllIIIIllIlIlIllIIIllI) {
        this();
        for (final Map.Entry<String, String> lllllllllllllIIIIllIlIlIllIIIlIl : lllllllllllllIIIIllIlIlIllIIIllI.entrySet()) {
            if (lllllllllllllIIIIllIlIlIllIIIlIl.getKey().equals("distance")) {
                this.distance = MathHelper.getDouble(lllllllllllllIIIIllIlIlIllIIIlIl.getValue(), this.distance, 1.0);
            }
            else if (lllllllllllllIIIIllIlIlIllIIIlIl.getKey().equals("count")) {
                this.structureCoords = new ChunkPos[MathHelper.getInt(lllllllllllllIIIIllIlIlIllIIIlIl.getValue(), this.structureCoords.length, 1)];
            }
            else {
                if (!lllllllllllllIIIIllIlIlIllIIIlIl.getKey().equals("spread")) {
                    continue;
                }
                this.spread = MathHelper.getInt(lllllllllllllIIIIllIlIlIllIIIlIl.getValue(), this.spread, 1);
            }
        }
    }
    
    public MapGenStronghold() {
        this.structureCoords = new ChunkPos[128];
        this.distance = 32.0;
        this.spread = 3;
        this.allowedBiomes = (List<Biome>)Lists.newArrayList();
        for (final Biome lllllllllllllIIIIllIlIlIllIIllll : Biome.REGISTRY) {
            if (lllllllllllllIIIIllIlIlIllIIllll != null && lllllllllllllIIIIllIlIlIllIIllll.getBaseHeight() > 0.0f) {
                this.allowedBiomes.add(lllllllllllllIIIIllIlIlIllIIllll);
            }
        }
    }
    
    public static class Start extends StructureStart
    {
        public Start(final World llllllllllllllIlIlIIlIlllIIIIlll, final Random llllllllllllllIlIlIIlIllIlllIIll, final int llllllllllllllIlIlIIlIlllIIIIIll, final int llllllllllllllIlIlIIlIllIllIllll) {
            super(llllllllllllllIlIlIIlIlllIIIIIll, llllllllllllllIlIlIIlIllIllIllll);
            StructureStrongholdPieces.prepareStructurePieces();
            final StructureStrongholdPieces.Stairs2 llllllllllllllIlIlIIlIllIlllllll = new StructureStrongholdPieces.Stairs2(0, llllllllllllllIlIlIIlIllIlllIIll, (llllllllllllllIlIlIIlIlllIIIIIll << 4) + 2, (llllllllllllllIlIlIIlIllIllIllll << 4) + 2);
            this.components.add(llllllllllllllIlIlIIlIllIlllllll);
            llllllllllllllIlIlIIlIllIlllllll.buildComponent(llllllllllllllIlIlIIlIllIlllllll, this.components, llllllllllllllIlIlIIlIllIlllIIll);
            final List<StructureComponent> llllllllllllllIlIlIIlIllIlllllIl = llllllllllllllIlIlIIlIllIlllllll.pendingChildren;
            while (!llllllllllllllIlIlIIlIllIlllllIl.isEmpty()) {
                final int llllllllllllllIlIlIIlIllIllllIll = llllllllllllllIlIlIIlIllIlllIIll.nextInt(llllllllllllllIlIlIIlIllIlllllIl.size());
                final StructureComponent llllllllllllllIlIlIIlIllIllllIIl = llllllllllllllIlIlIIlIllIlllllIl.remove(llllllllllllllIlIlIIlIllIllllIll);
                llllllllllllllIlIlIIlIllIllllIIl.buildComponent(llllllllllllllIlIlIIlIllIlllllll, this.components, llllllllllllllIlIlIIlIllIlllIIll);
            }
            this.updateBoundingBox();
            this.markAvailableHeight(llllllllllllllIlIlIIlIlllIIIIlll, llllllllllllllIlIlIIlIllIlllIIll, 10);
        }
        
        public Start() {
        }
    }
}
