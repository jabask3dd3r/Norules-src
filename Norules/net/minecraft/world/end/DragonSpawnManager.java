package net.minecraft.world.end;

import net.minecraft.entity.item.*;
import net.minecraft.util.math.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.world.gen.feature.*;
import java.util.*;

public enum DragonSpawnManager
{
    SUMMONING_PILLARS(2) {
        @Override
        public void process(final WorldServer lllllllllllllIlIlllIIlIlIIllllII, final DragonFightManager lllllllllllllIlIlllIIlIlIlIIlIlI, final List<EntityEnderCrystal> lllllllllllllIlIlllIIlIlIlIIlIIl, final int lllllllllllllIlIlllIIlIlIIlllIIl, final BlockPos lllllllllllllIlIlllIIlIlIlIIIlll) {
            final int lllllllllllllIlIlllIIlIlIlIIIllI = 40;
            final boolean lllllllllllllIlIlllIIlIlIlIIIlIl = lllllllllllllIlIlllIIlIlIIlllIIl % 40 == 0;
            final boolean lllllllllllllIlIlllIIlIlIlIIIlII = lllllllllllllIlIlllIIlIlIIlllIIl % 40 == 39;
            if (lllllllllllllIlIlllIIlIlIlIIIlIl || lllllllllllllIlIlllIIlIlIlIIIlII) {
                final WorldGenSpikes.EndSpike[] lllllllllllllIlIlllIIlIlIlIIIIll = BiomeEndDecorator.getSpikesForWorld(lllllllllllllIlIlllIIlIlIIllllII);
                final int lllllllllllllIlIlllIIlIlIlIIIIlI = lllllllllllllIlIlllIIlIlIIlllIIl / 40;
                if (lllllllllllllIlIlllIIlIlIlIIIIlI < lllllllllllllIlIlllIIlIlIlIIIIll.length) {
                    final WorldGenSpikes.EndSpike lllllllllllllIlIlllIIlIlIlIIIIIl = lllllllllllllIlIlllIIlIlIlIIIIll[lllllllllllllIlIlllIIlIlIlIIIIlI];
                    if (lllllllllllllIlIlllIIlIlIlIIIlIl) {
                        for (final EntityEnderCrystal lllllllllllllIlIlllIIlIlIlIIIIII : lllllllllllllIlIlllIIlIlIlIIlIIl) {
                            lllllllllllllIlIlllIIlIlIlIIIIII.setBeamTarget(new BlockPos(lllllllllllllIlIlllIIlIlIlIIIIIl.getCenterX(), lllllllllllllIlIlllIIlIlIlIIIIIl.getHeight() + 1, lllllllllllllIlIlllIIlIlIlIIIIIl.getCenterZ()));
                        }
                    }
                    else {
                        final int lllllllllllllIlIlllIIlIlIIllllll = 10;
                        for (final BlockPos.MutableBlockPos lllllllllllllIlIlllIIlIlIIlllllI : BlockPos.getAllInBoxMutable(new BlockPos(lllllllllllllIlIlllIIlIlIlIIIIIl.getCenterX() - 10, lllllllllllllIlIlllIIlIlIlIIIIIl.getHeight() - 10, lllllllllllllIlIlllIIlIlIlIIIIIl.getCenterZ() - 10), new BlockPos(lllllllllllllIlIlllIIlIlIlIIIIIl.getCenterX() + 10, lllllllllllllIlIlllIIlIlIlIIIIIl.getHeight() + 10, lllllllllllllIlIlllIIlIlIlIIIIIl.getCenterZ() + 10))) {
                            lllllllllllllIlIlllIIlIlIIllllII.setBlockToAir(lllllllllllllIlIlllIIlIlIIlllllI);
                        }
                        lllllllllllllIlIlllIIlIlIIllllII.createExplosion(null, lllllllllllllIlIlllIIlIlIlIIIIIl.getCenterX() + 0.5f, lllllllllllllIlIlllIIlIlIlIIIIIl.getHeight(), lllllllllllllIlIlllIIlIlIlIIIIIl.getCenterZ() + 0.5f, 5.0f, true);
                        final WorldGenSpikes lllllllllllllIlIlllIIlIlIIllllIl = new WorldGenSpikes();
                        lllllllllllllIlIlllIIlIlIIllllIl.setSpike(lllllllllllllIlIlllIIlIlIlIIIIIl);
                        lllllllllllllIlIlllIIlIlIIllllIl.setCrystalInvulnerable(true);
                        lllllllllllllIlIlllIIlIlIIllllIl.setBeamTarget(new BlockPos(0, 128, 0));
                        lllllllllllllIlIlllIIlIlIIllllIl.generate(lllllllllllllIlIlllIIlIlIIllllII, new Random(), new BlockPos(lllllllllllllIlIlllIIlIlIlIIIIIl.getCenterX(), 45, lllllllllllllIlIlllIIlIlIlIIIIIl.getCenterZ()));
                    }
                }
                else if (lllllllllllllIlIlllIIlIlIlIIIlIl) {
                    lllllllllllllIlIlllIIlIlIlIIlIlI.setRespawnState(DragonSpawnManager$3.SUMMONING_DRAGON);
                }
            }
        }
    }, 
    PREPARING_TO_SUMMON_PILLARS(1) {
        @Override
        public void process(final WorldServer llllllllllllllIlIlllIlIllIIIIIlI, final DragonFightManager llllllllllllllIlIlllIlIllIIIIIII, final List<EntityEnderCrystal> llllllllllllllIlIlllIlIllIIIlIII, final int llllllllllllllIlIlllIlIllIIIIllI, final BlockPos llllllllllllllIlIlllIlIllIIIIlII) {
            if (llllllllllllllIlIlllIlIllIIIIllI < 100) {
                if (llllllllllllllIlIlllIlIllIIIIllI == 0 || llllllllllllllIlIlllIlIllIIIIllI == 50 || llllllllllllllIlIlllIlIllIIIIllI == 51 || llllllllllllllIlIlllIlIllIIIIllI == 52 || llllllllllllllIlIlllIlIllIIIIllI >= 95) {
                    llllllllllllllIlIlllIlIllIIIIIlI.playEvent(3001, new BlockPos(0, 128, 0), 0);
                }
            }
            else {
                llllllllllllllIlIlllIlIllIIIIIII.setRespawnState(DragonSpawnManager$2.SUMMONING_PILLARS);
            }
        }
    }, 
    END(4) {
        @Override
        public void process(final WorldServer lllllllllllllIlIlIIlllIlIIlIIlll, final DragonFightManager lllllllllllllIlIlIIlllIlIIlIIllI, final List<EntityEnderCrystal> lllllllllllllIlIlIIlllIlIIlIIlIl, final int lllllllllllllIlIlIIlllIlIIlIIlII, final BlockPos lllllllllllllIlIlIIlllIlIIlIIIll) {
        }
    }, 
    SUMMONING_DRAGON(3) {
        @Override
        public void process(final WorldServer lllllllllllllIllllIlIllIllIIIlll, final DragonFightManager lllllllllllllIllllIlIllIlIllllll, final List<EntityEnderCrystal> lllllllllllllIllllIlIllIlIlllllI, final int lllllllllllllIllllIlIllIllIIIlII, final BlockPos lllllllllllllIllllIlIllIllIIIIll) {
            if (lllllllllllllIllllIlIllIllIIIlII >= 100) {
                lllllllllllllIllllIlIllIlIllllll.setRespawnState(DragonSpawnManager$4.END);
                lllllllllllllIllllIlIllIlIllllll.resetSpikeCrystals();
                for (final EntityEnderCrystal lllllllllllllIllllIlIllIllIIIIlI : lllllllllllllIllllIlIllIlIlllllI) {
                    lllllllllllllIllllIlIllIllIIIIlI.setBeamTarget(null);
                    lllllllllllllIllllIlIllIllIIIlll.createExplosion(lllllllllllllIllllIlIllIllIIIIlI, lllllllllllllIllllIlIllIllIIIIlI.posX, lllllllllllllIllllIlIllIllIIIIlI.posY, lllllllllllllIllllIlIllIllIIIIlI.posZ, 6.0f, false);
                    lllllllllllllIllllIlIllIllIIIIlI.setDead();
                }
            }
            else if (lllllllllllllIllllIlIllIllIIIlII >= 80) {
                lllllllllllllIllllIlIllIllIIIlll.playEvent(3001, new BlockPos(0, 128, 0), 0);
            }
            else if (lllllllllllllIllllIlIllIllIIIlII == 0) {
                for (final EntityEnderCrystal lllllllllllllIllllIlIllIllIIIIIl : lllllllllllllIllllIlIllIlIlllllI) {
                    lllllllllllllIllllIlIllIllIIIIIl.setBeamTarget(new BlockPos(0, 128, 0));
                }
            }
            else if (lllllllllllllIllllIlIllIllIIIlII < 5) {
                lllllllllllllIllllIlIllIllIIIlll.playEvent(3001, new BlockPos(0, 128, 0), 0);
            }
        }
    }, 
    START(0) {
        @Override
        public void process(final WorldServer llllllllllllllIlIIllIllIlIIIIIIl, final DragonFightManager llllllllllllllIlIIllIllIIllllIlI, final List<EntityEnderCrystal> llllllllllllllIlIIllIllIIlllllll, final int llllllllllllllIlIIllIllIIllllllI, final BlockPos llllllllllllllIlIIllIllIIlllllIl) {
            final BlockPos llllllllllllllIlIIllIllIIlllllII = new BlockPos(0, 128, 0);
            for (final EntityEnderCrystal llllllllllllllIlIIllIllIIllllIll : llllllllllllllIlIIllIllIIlllllll) {
                llllllllllllllIlIIllIllIIllllIll.setBeamTarget(llllllllllllllIlIIllIllIIlllllII);
            }
            llllllllllllllIlIIllIllIIllllIlI.setRespawnState(DragonSpawnManager$1.PREPARING_TO_SUMMON_PILLARS);
        }
    };
    
    public abstract void process(final WorldServer p0, final DragonFightManager p1, final List<EntityEnderCrystal> p2, final int p3, final BlockPos p4);
    
    private DragonSpawnManager(final String lllllllllllllIllllllIlIIIIIlIIll, final int lllllllllllllIllllllIlIIIIIlIIlI) {
    }
}
