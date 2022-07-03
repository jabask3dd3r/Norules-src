package net.minecraft.world.gen.feature;

import java.util.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.block.material.*;
import net.minecraft.tileentity.*;
import org.apache.logging.log4j.*;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;

public class WorldGenDungeons extends WorldGenerator
{
    private static final /* synthetic */ Logger LOGGER;
    private static final /* synthetic */ ResourceLocation[] SPAWNERTYPES;
    
    private ResourceLocation pickMobSpawner(final Random lllllllllllllIIlIlllIIlIIIlIlIll) {
        return WorldGenDungeons.SPAWNERTYPES[lllllllllllllIIlIlllIIlIIIlIlIll.nextInt(WorldGenDungeons.SPAWNERTYPES.length)];
    }
    
    @Override
    public boolean generate(final World lllllllllllllIIlIlllIIlIIllIIlIl, final Random lllllllllllllIIlIlllIIlIIllIIlII, final BlockPos lllllllllllllIIlIlllIIlIIlIIIIIl) {
        final int lllllllllllllIIlIlllIIlIIllIIIlI = 3;
        final int lllllllllllllIIlIlllIIlIIllIIIIl = lllllllllllllIIlIlllIIlIIllIIlII.nextInt(2) + 2;
        final int lllllllllllllIIlIlllIIlIIllIIIII = -lllllllllllllIIlIlllIIlIIllIIIIl - 1;
        final int lllllllllllllIIlIlllIIlIIlIlllll = lllllllllllllIIlIlllIIlIIllIIIIl + 1;
        final int lllllllllllllIIlIlllIIlIIlIllllI = -1;
        final int lllllllllllllIIlIlllIIlIIlIlllIl = 4;
        final int lllllllllllllIIlIlllIIlIIlIlllII = lllllllllllllIIlIlllIIlIIllIIlII.nextInt(2) + 2;
        final int lllllllllllllIIlIlllIIlIIlIllIll = -lllllllllllllIIlIlllIIlIIlIlllII - 1;
        final int lllllllllllllIIlIlllIIlIIlIllIlI = lllllllllllllIIlIlllIIlIIlIlllII + 1;
        int lllllllllllllIIlIlllIIlIIlIllIIl = 0;
        for (int lllllllllllllIIlIlllIIlIIlIllIII = lllllllllllllIIlIlllIIlIIllIIIII; lllllllllllllIIlIlllIIlIIlIllIII <= lllllllllllllIIlIlllIIlIIlIlllll; ++lllllllllllllIIlIlllIIlIIlIllIII) {
            for (int lllllllllllllIIlIlllIIlIIlIlIlll = -1; lllllllllllllIIlIlllIIlIIlIlIlll <= 4; ++lllllllllllllIIlIlllIIlIIlIlIlll) {
                for (int lllllllllllllIIlIlllIIlIIlIlIllI = lllllllllllllIIlIlllIIlIIlIllIll; lllllllllllllIIlIlllIIlIIlIlIllI <= lllllllllllllIIlIlllIIlIIlIllIlI; ++lllllllllllllIIlIlllIIlIIlIlIllI) {
                    final BlockPos lllllllllllllIIlIlllIIlIIlIlIlIl = lllllllllllllIIlIlllIIlIIlIIIIIl.add(lllllllllllllIIlIlllIIlIIlIllIII, lllllllllllllIIlIlllIIlIIlIlIlll, lllllllllllllIIlIlllIIlIIlIlIllI);
                    final Material lllllllllllllIIlIlllIIlIIlIlIlII = lllllllllllllIIlIlllIIlIIllIIlIl.getBlockState(lllllllllllllIIlIlllIIlIIlIlIlIl).getMaterial();
                    final boolean lllllllllllllIIlIlllIIlIIlIlIIll = lllllllllllllIIlIlllIIlIIlIlIlII.isSolid();
                    if (lllllllllllllIIlIlllIIlIIlIlIlll == -1 && !lllllllllllllIIlIlllIIlIIlIlIIll) {
                        return false;
                    }
                    if (lllllllllllllIIlIlllIIlIIlIlIlll == 4 && !lllllllllllllIIlIlllIIlIIlIlIIll) {
                        return false;
                    }
                    if ((lllllllllllllIIlIlllIIlIIlIllIII == lllllllllllllIIlIlllIIlIIllIIIII || lllllllllllllIIlIlllIIlIIlIllIII == lllllllllllllIIlIlllIIlIIlIlllll || lllllllllllllIIlIlllIIlIIlIlIllI == lllllllllllllIIlIlllIIlIIlIllIll || lllllllllllllIIlIlllIIlIIlIlIllI == lllllllllllllIIlIlllIIlIIlIllIlI) && lllllllllllllIIlIlllIIlIIlIlIlll == 0 && lllllllllllllIIlIlllIIlIIllIIlIl.isAirBlock(lllllllllllllIIlIlllIIlIIlIlIlIl) && lllllllllllllIIlIlllIIlIIllIIlIl.isAirBlock(lllllllllllllIIlIlllIIlIIlIlIlIl.up())) {
                        ++lllllllllllllIIlIlllIIlIIlIllIIl;
                    }
                }
            }
        }
        if (lllllllllllllIIlIlllIIlIIlIllIIl >= 1 && lllllllllllllIIlIlllIIlIIlIllIIl <= 5) {
            for (int lllllllllllllIIlIlllIIlIIlIlIIlI = lllllllllllllIIlIlllIIlIIllIIIII; lllllllllllllIIlIlllIIlIIlIlIIlI <= lllllllllllllIIlIlllIIlIIlIlllll; ++lllllllllllllIIlIlllIIlIIlIlIIlI) {
                for (int lllllllllllllIIlIlllIIlIIlIlIIIl = 3; lllllllllllllIIlIlllIIlIIlIlIIIl >= -1; --lllllllllllllIIlIlllIIlIIlIlIIIl) {
                    for (int lllllllllllllIIlIlllIIlIIlIlIIII = lllllllllllllIIlIlllIIlIIlIllIll; lllllllllllllIIlIlllIIlIIlIlIIII <= lllllllllllllIIlIlllIIlIIlIllIlI; ++lllllllllllllIIlIlllIIlIIlIlIIII) {
                        final BlockPos lllllllllllllIIlIlllIIlIIlIIllll = lllllllllllllIIlIlllIIlIIlIIIIIl.add(lllllllllllllIIlIlllIIlIIlIlIIlI, lllllllllllllIIlIlllIIlIIlIlIIIl, lllllllllllllIIlIlllIIlIIlIlIIII);
                        if (lllllllllllllIIlIlllIIlIIlIlIIlI != lllllllllllllIIlIlllIIlIIllIIIII && lllllllllllllIIlIlllIIlIIlIlIIIl != -1 && lllllllllllllIIlIlllIIlIIlIlIIII != lllllllllllllIIlIlllIIlIIlIllIll && lllllllllllllIIlIlllIIlIIlIlIIlI != lllllllllllllIIlIlllIIlIIlIlllll && lllllllllllllIIlIlllIIlIIlIlIIIl != 4 && lllllllllllllIIlIlllIIlIIlIlIIII != lllllllllllllIIlIlllIIlIIlIllIlI) {
                            if (lllllllllllllIIlIlllIIlIIllIIlIl.getBlockState(lllllllllllllIIlIlllIIlIIlIIllll).getBlock() != Blocks.CHEST) {
                                lllllllllllllIIlIlllIIlIIllIIlIl.setBlockToAir(lllllllllllllIIlIlllIIlIIlIIllll);
                            }
                        }
                        else if (lllllllllllllIIlIlllIIlIIlIIllll.getY() >= 0 && !lllllllllllllIIlIlllIIlIIllIIlIl.getBlockState(lllllllllllllIIlIlllIIlIIlIIllll.down()).getMaterial().isSolid()) {
                            lllllllllllllIIlIlllIIlIIllIIlIl.setBlockToAir(lllllllllllllIIlIlllIIlIIlIIllll);
                        }
                        else if (lllllllllllllIIlIlllIIlIIllIIlIl.getBlockState(lllllllllllllIIlIlllIIlIIlIIllll).getMaterial().isSolid() && lllllllllllllIIlIlllIIlIIllIIlIl.getBlockState(lllllllllllllIIlIlllIIlIIlIIllll).getBlock() != Blocks.CHEST) {
                            if (lllllllllllllIIlIlllIIlIIlIlIIIl == -1 && lllllllllllllIIlIlllIIlIIllIIlII.nextInt(4) != 0) {
                                lllllllllllllIIlIlllIIlIIllIIlIl.setBlockState(lllllllllllllIIlIlllIIlIIlIIllll, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 2);
                            }
                            else {
                                lllllllllllllIIlIlllIIlIIllIIlIl.setBlockState(lllllllllllllIIlIlllIIlIIlIIllll, Blocks.COBBLESTONE.getDefaultState(), 2);
                            }
                        }
                    }
                }
            }
            for (int lllllllllllllIIlIlllIIlIIlIIlllI = 0; lllllllllllllIIlIlllIIlIIlIIlllI < 2; ++lllllllllllllIIlIlllIIlIIlIIlllI) {
                for (int lllllllllllllIIlIlllIIlIIlIIllIl = 0; lllllllllllllIIlIlllIIlIIlIIllIl < 3; ++lllllllllllllIIlIlllIIlIIlIIllIl) {
                    final int lllllllllllllIIlIlllIIlIIlIIllII = lllllllllllllIIlIlllIIlIIlIIIIIl.getX() + lllllllllllllIIlIlllIIlIIllIIlII.nextInt(lllllllllllllIIlIlllIIlIIllIIIIl * 2 + 1) - lllllllllllllIIlIlllIIlIIllIIIIl;
                    final int lllllllllllllIIlIlllIIlIIlIIlIll = lllllllllllllIIlIlllIIlIIlIIIIIl.getY();
                    final int lllllllllllllIIlIlllIIlIIlIIlIlI = lllllllllllllIIlIlllIIlIIlIIIIIl.getZ() + lllllllllllllIIlIlllIIlIIllIIlII.nextInt(lllllllllllllIIlIlllIIlIIlIlllII * 2 + 1) - lllllllllllllIIlIlllIIlIIlIlllII;
                    final BlockPos lllllllllllllIIlIlllIIlIIlIIlIIl = new BlockPos(lllllllllllllIIlIlllIIlIIlIIllII, lllllllllllllIIlIlllIIlIIlIIlIll, lllllllllllllIIlIlllIIlIIlIIlIlI);
                    if (lllllllllllllIIlIlllIIlIIllIIlIl.isAirBlock(lllllllllllllIIlIlllIIlIIlIIlIIl)) {
                        int lllllllllllllIIlIlllIIlIIlIIlIII = 0;
                        for (final EnumFacing lllllllllllllIIlIlllIIlIIlIIIlll : EnumFacing.Plane.HORIZONTAL) {
                            if (lllllllllllllIIlIlllIIlIIllIIlIl.getBlockState(lllllllllllllIIlIlllIIlIIlIIlIIl.offset(lllllllllllllIIlIlllIIlIIlIIIlll)).getMaterial().isSolid()) {
                                ++lllllllllllllIIlIlllIIlIIlIIlIII;
                            }
                        }
                        if (lllllllllllllIIlIlllIIlIIlIIlIII == 1) {
                            lllllllllllllIIlIlllIIlIIllIIlIl.setBlockState(lllllllllllllIIlIlllIIlIIlIIlIIl, Blocks.CHEST.correctFacing(lllllllllllllIIlIlllIIlIIllIIlIl, lllllllllllllIIlIlllIIlIIlIIlIIl, Blocks.CHEST.getDefaultState()), 2);
                            final TileEntity lllllllllllllIIlIlllIIlIIlIIIllI = lllllllllllllIIlIlllIIlIIllIIlIl.getTileEntity(lllllllllllllIIlIlllIIlIIlIIlIIl);
                            if (lllllllllllllIIlIlllIIlIIlIIIllI instanceof TileEntityChest) {
                                ((TileEntityChest)lllllllllllllIIlIlllIIlIIlIIIllI).setLootTable(LootTableList.CHESTS_SIMPLE_DUNGEON, lllllllllllllIIlIlllIIlIIllIIlII.nextLong());
                                break;
                            }
                            break;
                        }
                    }
                }
            }
            lllllllllllllIIlIlllIIlIIllIIlIl.setBlockState(lllllllllllllIIlIlllIIlIIlIIIIIl, Blocks.MOB_SPAWNER.getDefaultState(), 2);
            final TileEntity lllllllllllllIIlIlllIIlIIlIIIlIl = lllllllllllllIIlIlllIIlIIllIIlIl.getTileEntity(lllllllllllllIIlIlllIIlIIlIIIIIl);
            if (lllllllllllllIIlIlllIIlIIlIIIlIl instanceof TileEntityMobSpawner) {
                ((TileEntityMobSpawner)lllllllllllllIIlIlllIIlIIlIIIlIl).getSpawnerBaseLogic().func_190894_a(this.pickMobSpawner(lllllllllllllIIlIlllIIlIIllIIlII));
            }
            else {
                WorldGenDungeons.LOGGER.error("Failed to fetch mob spawner entity at ({}, {}, {})", (Object)lllllllllllllIIlIlllIIlIIlIIIIIl.getX(), (Object)lllllllllllllIIlIlllIIlIIlIIIIIl.getY(), (Object)lllllllllllllIIlIlllIIlIIlIIIIIl.getZ());
            }
            return true;
        }
        return false;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        SPAWNERTYPES = new ResourceLocation[] { EntityList.func_191306_a(EntitySkeleton.class), EntityList.func_191306_a(EntityZombie.class), EntityList.func_191306_a(EntityZombie.class), EntityList.func_191306_a(EntitySpider.class) };
    }
}
