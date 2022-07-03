package net.minecraft.world.gen.structure;

import java.util.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.world.biome.*;

public class MapGenMineshaft extends MapGenStructure
{
    private /* synthetic */ double chance;
    
    public MapGenMineshaft(final Map<String, String> lllllllllllllIllIlIlIllIIIIIlIII) {
        this.chance = 0.004;
        for (final Map.Entry<String, String> lllllllllllllIllIlIlIllIIIIIIlll : lllllllllllllIllIlIlIllIIIIIlIII.entrySet()) {
            if (lllllllllllllIllIlIlIllIIIIIIlll.getKey().equals("chance")) {
                this.chance = MathHelper.getDouble(lllllllllllllIllIlIlIllIIIIIIlll.getValue(), this.chance);
            }
        }
    }
    
    @Override
    public BlockPos getClosestStrongholdPos(final World lllllllllllllIllIlIlIlIllllIlIlI, final BlockPos lllllllllllllIllIlIlIlIllllIlIIl, final boolean lllllllllllllIllIlIlIlIllllIlIII) {
        final int lllllllllllllIllIlIlIlIllllIIlll = 1000;
        final int lllllllllllllIllIlIlIlIllllIIllI = lllllllllllllIllIlIlIlIllllIlIIl.getX() >> 4;
        final int lllllllllllllIllIlIlIlIllllIIlIl = lllllllllllllIllIlIlIlIllllIlIIl.getZ() >> 4;
        for (int lllllllllllllIllIlIlIlIllllIIlII = 0; lllllllllllllIllIlIlIlIllllIIlII <= 1000; ++lllllllllllllIllIlIlIlIllllIIlII) {
            for (int lllllllllllllIllIlIlIlIllllIIIll = -lllllllllllllIllIlIlIlIllllIIlII; lllllllllllllIllIlIlIlIllllIIIll <= lllllllllllllIllIlIlIlIllllIIlII; ++lllllllllllllIllIlIlIlIllllIIIll) {
                final boolean lllllllllllllIllIlIlIlIllllIIIlI = lllllllllllllIllIlIlIlIllllIIIll == -lllllllllllllIllIlIlIlIllllIIlII || lllllllllllllIllIlIlIlIllllIIIll == lllllllllllllIllIlIlIlIllllIIlII;
                for (int lllllllllllllIllIlIlIlIllllIIIIl = -lllllllllllllIllIlIlIlIllllIIlII; lllllllllllllIllIlIlIlIllllIIIIl <= lllllllllllllIllIlIlIlIllllIIlII; ++lllllllllllllIllIlIlIlIllllIIIIl) {
                    final boolean lllllllllllllIllIlIlIlIllllIIIII = lllllllllllllIllIlIlIlIllllIIIIl == -lllllllllllllIllIlIlIlIllllIIlII || lllllllllllllIllIlIlIlIllllIIIIl == lllllllllllllIllIlIlIlIllllIIlII;
                    if (lllllllllllllIllIlIlIlIllllIIIlI || lllllllllllllIllIlIlIlIllllIIIII) {
                        final int lllllllllllllIllIlIlIlIlllIlllll = lllllllllllllIllIlIlIlIllllIIllI + lllllllllllllIllIlIlIlIllllIIIll;
                        final int lllllllllllllIllIlIlIlIlllIllllI = lllllllllllllIllIlIlIlIllllIIlIl + lllllllllllllIllIlIlIlIllllIIIIl;
                        this.rand.setSeed((long)(lllllllllllllIllIlIlIlIlllIlllll ^ lllllllllllllIllIlIlIlIlllIllllI) ^ lllllllllllllIllIlIlIlIllllIlIlI.getSeed());
                        this.rand.nextInt();
                        if (this.canSpawnStructureAtCoords(lllllllllllllIllIlIlIlIlllIlllll, lllllllllllllIllIlIlIlIlllIllllI) && (!lllllllllllllIllIlIlIlIllllIlIII || !lllllllllllllIllIlIlIlIllllIlIlI.func_190526_b(lllllllllllllIllIlIlIlIlllIlllll, lllllllllllllIllIlIlIlIlllIllllI))) {
                            return new BlockPos((lllllllllllllIllIlIlIlIlllIlllll << 4) + 8, 64, (lllllllllllllIllIlIlIlIlllIllllI << 4) + 8);
                        }
                    }
                }
            }
        }
        return null;
    }
    
    @Override
    protected boolean canSpawnStructureAtCoords(final int lllllllllllllIllIlIlIlIllllllIll, final int lllllllllllllIllIlIlIlIllllllIlI) {
        return this.rand.nextDouble() < this.chance && this.rand.nextInt(80) < Math.max(Math.abs(lllllllllllllIllIlIlIlIllllllIll), Math.abs(lllllllllllllIllIlIlIlIllllllIlI));
    }
    
    public MapGenMineshaft() {
        this.chance = 0.004;
    }
    
    @Override
    protected StructureStart getStructureStart(final int lllllllllllllIllIlIlIlIlllIIIlII, final int lllllllllllllIllIlIlIlIlllIIlIII) {
        final Biome lllllllllllllIllIlIlIlIlllIIIlll = this.worldObj.getBiome(new BlockPos((lllllllllllllIllIlIlIlIlllIIIlII << 4) + 8, 64, (lllllllllllllIllIlIlIlIlllIIlIII << 4) + 8));
        final Type lllllllllllllIllIlIlIlIlllIIIllI = (lllllllllllllIllIlIlIlIlllIIIlll instanceof BiomeMesa) ? Type.MESA : Type.NORMAL;
        return new StructureMineshaftStart(this.worldObj, this.rand, lllllllllllllIllIlIlIlIlllIIIlII, lllllllllllllIllIlIlIlIlllIIlIII, lllllllllllllIllIlIlIlIlllIIIllI);
    }
    
    @Override
    public String getStructureName() {
        return "Mineshaft";
    }
    
    public enum Type
    {
        MESA("MESA", 1), 
        NORMAL("NORMAL", 0);
        
        private Type(final String lllllllllllllIIlllIIlIlIllIIIIII, final int lllllllllllllIIlllIIlIlIlIllllll) {
        }
        
        public static Type byId(final int lllllllllllllIIlllIIlIlIlIllllII) {
            return (lllllllllllllIIlllIIlIlIlIllllII >= 0 && lllllllllllllIIlllIIlIlIlIllllII < values().length) ? values()[lllllllllllllIIlllIIlIlIlIllllII] : Type.NORMAL;
        }
    }
}
