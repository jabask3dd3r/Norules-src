package net.minecraft.world.gen.structure;

import net.minecraft.world.gen.*;
import net.minecraft.world.*;
import net.minecraft.world.biome.*;
import net.minecraft.util.*;
import net.minecraft.world.chunk.*;
import com.google.common.collect.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import java.util.*;

public class WoodlandMansion extends MapGenStructure
{
    private final /* synthetic */ ChunkGeneratorOverworld field_191075_h;
    public static final /* synthetic */ List<Biome> field_191072_a;
    
    public WoodlandMansion(final ChunkGeneratorOverworld lIllIllIllIIIl) {
        this.field_191075_h = lIllIllIllIIIl;
    }
    
    @Override
    protected StructureStart getStructureStart(final int lIllIlIllllllI, final int lIllIlIlllllIl) {
        return new Start(this.worldObj, this.field_191075_h, this.rand, lIllIlIllllllI, lIllIlIlllllIl);
    }
    
    @Override
    public BlockPos getClosestStrongholdPos(final World lIllIllIIIlllI, final BlockPos lIllIllIIIlIII, final boolean lIllIllIIIIlll) {
        this.worldObj = lIllIllIIIlllI;
        final BiomeProvider lIllIllIIIlIll = lIllIllIIIlllI.getBiomeProvider();
        return (lIllIllIIIlIll.func_190944_c() && lIllIllIIIlIll.func_190943_d() != Biomes.ROOFED_FOREST) ? null : MapGenStructure.func_191069_a(lIllIllIIIlllI, this, lIllIllIIIlIII, 80, 20, 10387319, true, 100, lIllIllIIIIlll);
    }
    
    @Override
    protected boolean canSpawnStructureAtCoords(final int lIllIllIlIIlIl, final int lIllIllIIllIll) {
        int lIllIllIlIIIll = lIllIllIlIIlIl;
        int lIllIllIlIIIlI = lIllIllIIllIll;
        if (lIllIllIlIIlIl < 0) {
            lIllIllIlIIIll = lIllIllIlIIlIl - 79;
        }
        if (lIllIllIIllIll < 0) {
            lIllIllIlIIIlI = lIllIllIIllIll - 79;
        }
        int lIllIllIlIIIIl = lIllIllIlIIIll / 80;
        int lIllIllIlIIIII = lIllIllIlIIIlI / 80;
        final Random lIllIllIIlllll = this.worldObj.setRandomSeed(lIllIllIlIIIIl, lIllIllIlIIIII, 10387319);
        lIllIllIlIIIIl *= 80;
        lIllIllIlIIIII *= 80;
        lIllIllIlIIIIl += (lIllIllIIlllll.nextInt(60) + lIllIllIIlllll.nextInt(60)) / 2;
        lIllIllIlIIIII += (lIllIllIIlllll.nextInt(60) + lIllIllIIlllll.nextInt(60)) / 2;
        if (lIllIllIlIIlIl == lIllIllIlIIIIl && lIllIllIIllIll == lIllIllIlIIIII) {
            final boolean lIllIllIIllllI = this.worldObj.getBiomeProvider().areBiomesViable(lIllIllIlIIlIl * 16 + 8, lIllIllIIllIll * 16 + 8, 32, WoodlandMansion.field_191072_a);
            if (lIllIllIIllllI) {
                return true;
            }
        }
        return false;
    }
    
    static {
        field_191072_a = Arrays.asList(Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
    }
    
    @Override
    public String getStructureName() {
        return "Mansion";
    }
    
    public static class Start extends StructureStart
    {
        private /* synthetic */ boolean field_191093_c;
        
        public Start(final World lllllllllllllIIIllIIllIllIIlllIl, final ChunkGeneratorOverworld lllllllllllllIIIllIIllIllIIlIllI, final Random lllllllllllllIIIllIIllIllIIllIll, final int lllllllllllllIIIllIIllIllIIlIlII, final int lllllllllllllIIIllIIllIllIIlIIll) {
            super(lllllllllllllIIIllIIllIllIIlIlII, lllllllllllllIIIllIIllIllIIlIIll);
            this.func_191092_a(lllllllllllllIIIllIIllIllIIlllIl, lllllllllllllIIIllIIllIllIIlIllI, lllllllllllllIIIllIIllIllIIllIll, lllllllllllllIIIllIIllIllIIlIlII, lllllllllllllIIIllIIllIllIIlIIll);
        }
        
        private void func_191092_a(final World lllllllllllllIIIllIIllIllIIIIIII, final ChunkGeneratorOverworld lllllllllllllIIIllIIllIlIlllllll, final Random lllllllllllllIIIllIIllIlIllIllIl, final int lllllllllllllIIIllIIllIlIlllllIl, final int lllllllllllllIIIllIIllIlIlllllII) {
            final Rotation lllllllllllllIIIllIIllIlIllllIll = Rotation.values()[lllllllllllllIIIllIIllIlIllIllIl.nextInt(Rotation.values().length)];
            final ChunkPrimer lllllllllllllIIIllIIllIlIllllIlI = new ChunkPrimer();
            lllllllllllllIIIllIIllIlIlllllll.setBlocksInChunk(lllllllllllllIIIllIIllIlIlllllIl, lllllllllllllIIIllIIllIlIlllllII, lllllllllllllIIIllIIllIlIllllIlI);
            int lllllllllllllIIIllIIllIlIllllIIl = 5;
            int lllllllllllllIIIllIIllIlIllllIII = 5;
            if (lllllllllllllIIIllIIllIlIllllIll == Rotation.CLOCKWISE_90) {
                lllllllllllllIIIllIIllIlIllllIIl = -5;
            }
            else if (lllllllllllllIIIllIIllIlIllllIll == Rotation.CLOCKWISE_180) {
                lllllllllllllIIIllIIllIlIllllIIl = -5;
                lllllllllllllIIIllIIllIlIllllIII = -5;
            }
            else if (lllllllllllllIIIllIIllIlIllllIll == Rotation.COUNTERCLOCKWISE_90) {
                lllllllllllllIIIllIIllIlIllllIII = -5;
            }
            final int lllllllllllllIIIllIIllIlIlllIlll = lllllllllllllIIIllIIllIlIllllIlI.findGroundBlockIdx(7, 7);
            final int lllllllllllllIIIllIIllIlIlllIllI = lllllllllllllIIIllIIllIlIllllIlI.findGroundBlockIdx(7, 7 + lllllllllllllIIIllIIllIlIllllIII);
            final int lllllllllllllIIIllIIllIlIlllIlIl = lllllllllllllIIIllIIllIlIllllIlI.findGroundBlockIdx(7 + lllllllllllllIIIllIIllIlIllllIIl, 7);
            final int lllllllllllllIIIllIIllIlIlllIlII = lllllllllllllIIIllIIllIlIllllIlI.findGroundBlockIdx(7 + lllllllllllllIIIllIIllIlIllllIIl, 7 + lllllllllllllIIIllIIllIlIllllIII);
            final int lllllllllllllIIIllIIllIlIlllIIll = Math.min(Math.min(lllllllllllllIIIllIIllIlIlllIlll, lllllllllllllIIIllIIllIlIlllIllI), Math.min(lllllllllllllIIIllIIllIlIlllIlIl, lllllllllllllIIIllIIllIlIlllIlII));
            if (lllllllllllllIIIllIIllIlIlllIIll < 60) {
                this.field_191093_c = false;
            }
            else {
                final BlockPos lllllllllllllIIIllIIllIlIlllIIlI = new BlockPos(lllllllllllllIIIllIIllIlIlllllIl * 16 + 8, lllllllllllllIIIllIIllIlIlllIIll + 1, lllllllllllllIIIllIIllIlIlllllII * 16 + 8);
                final List<WoodlandMansionPieces.MansionTemplate> lllllllllllllIIIllIIllIlIlllIIIl = (List<WoodlandMansionPieces.MansionTemplate>)Lists.newLinkedList();
                WoodlandMansionPieces.func_191152_a(lllllllllllllIIIllIIllIllIIIIIII.getSaveHandler().getStructureTemplateManager(), lllllllllllllIIIllIIllIlIlllIIlI, lllllllllllllIIIllIIllIlIllllIll, lllllllllllllIIIllIIllIlIlllIIIl, lllllllllllllIIIllIIllIlIllIllIl);
                this.components.addAll(lllllllllllllIIIllIIllIlIlllIIIl);
                this.updateBoundingBox();
                this.field_191093_c = true;
            }
        }
        
        @Override
        public boolean isSizeableStructure() {
            return this.field_191093_c;
        }
        
        @Override
        public void generateStructure(final World lllllllllllllIIIllIIllIlIlIIIlll, final Random lllllllllllllIIIllIIllIlIlIIIllI, final StructureBoundingBox lllllllllllllIIIllIIllIlIlIIIlIl) {
            super.generateStructure(lllllllllllllIIIllIIllIlIlIIIlll, lllllllllllllIIIllIIllIlIlIIIllI, lllllllllllllIIIllIIllIlIlIIIlIl);
            final int lllllllllllllIIIllIIllIlIlIlIIII = this.boundingBox.minY;
            for (int lllllllllllllIIIllIIllIlIlIIllll = lllllllllllllIIIllIIllIlIlIIIlIl.minX; lllllllllllllIIIllIIllIlIlIIllll <= lllllllllllllIIIllIIllIlIlIIIlIl.maxX; ++lllllllllllllIIIllIIllIlIlIIllll) {
                for (int lllllllllllllIIIllIIllIlIlIIlllI = lllllllllllllIIIllIIllIlIlIIIlIl.minZ; lllllllllllllIIIllIIllIlIlIIlllI <= lllllllllllllIIIllIIllIlIlIIIlIl.maxZ; ++lllllllllllllIIIllIIllIlIlIIlllI) {
                    final BlockPos lllllllllllllIIIllIIllIlIlIIllIl = new BlockPos(lllllllllllllIIIllIIllIlIlIIllll, lllllllllllllIIIllIIllIlIlIlIIII, lllllllllllllIIIllIIllIlIlIIlllI);
                    if (!lllllllllllllIIIllIIllIlIlIIIlll.isAirBlock(lllllllllllllIIIllIIllIlIlIIllIl) && this.boundingBox.isVecInside(lllllllllllllIIIllIIllIlIlIIllIl)) {
                        boolean lllllllllllllIIIllIIllIlIlIIllII = false;
                        for (final StructureComponent lllllllllllllIIIllIIllIlIlIIlIll : this.components) {
                            if (lllllllllllllIIIllIIllIlIlIIlIll.boundingBox.isVecInside(lllllllllllllIIIllIIllIlIlIIllIl)) {
                                lllllllllllllIIIllIIllIlIlIIllII = true;
                                break;
                            }
                        }
                        if (lllllllllllllIIIllIIllIlIlIIllII) {
                            for (int lllllllllllllIIIllIIllIlIlIIlIlI = lllllllllllllIIIllIIllIlIlIlIIII - 1; lllllllllllllIIIllIIllIlIlIIlIlI > 1; --lllllllllllllIIIllIIllIlIlIIlIlI) {
                                final BlockPos lllllllllllllIIIllIIllIlIlIIlIIl = new BlockPos(lllllllllllllIIIllIIllIlIlIIllll, lllllllllllllIIIllIIllIlIlIIlIlI, lllllllllllllIIIllIIllIlIlIIlllI);
                                if (!lllllllllllllIIIllIIllIlIlIIIlll.isAirBlock(lllllllllllllIIIllIIllIlIlIIlIIl) && !lllllllllllllIIIllIIllIlIlIIIlll.getBlockState(lllllllllllllIIIllIIllIlIlIIlIIl).getMaterial().isLiquid()) {
                                    break;
                                }
                                lllllllllllllIIIllIIllIlIlIIIlll.setBlockState(lllllllllllllIIIllIIllIlIlIIlIIl, Blocks.COBBLESTONE.getDefaultState(), 2);
                            }
                        }
                    }
                }
            }
        }
        
        public Start() {
        }
    }
}
