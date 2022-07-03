package com.kisman.nr.cc.util;

import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.network.*;
import me.nrules.utils.player.*;
import net.minecraft.util.*;
import net.minecraft.network.play.client.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.item.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import java.util.*;

public class BlockUtil
{
    public static /* synthetic */ Vec3d[] platformOffsetList;
    public static /* synthetic */ Vec3d[] antiScaffoldOffsetList;
    public static final /* synthetic */ List blackList;
    public static /* synthetic */ Vec3d[] legOffsetList;
    public static /* synthetic */ Vec3d[] antiDropOffsetList;
    public static final /* synthetic */ List shulkerList;
    private static final /* synthetic */ Minecraft mc;
    public static /* synthetic */ Vec3d[] antiStepOffsetList;
    public static /* synthetic */ Vec3d[] OffsetList;
    
    public static Block getBlock(final double lllllllllllllIIIlllIlIIIlIlIlIIl, final double lllllllllllllIIIlllIlIIIlIlIIlIl, final double lllllllllllllIIIlllIlIIIlIlIIlll) {
        return BlockUtil.mc.world.getBlockState(new BlockPos(lllllllllllllIIIlllIlIIIlIlIlIIl, lllllllllllllIIIlllIlIIIlIlIIlIl, lllllllllllllIIIlllIlIIIlIlIIlll)).getBlock();
    }
    
    public static Vec3d[] convertVec3ds(final Vec3d lllllllllllllIIIlllIlIIIlIIIIllI, final Vec3d[] lllllllllllllIIIlllIlIIIlIIIlIIl) {
        final Vec3d[] lllllllllllllIIIlllIlIIIlIIIlIII = new Vec3d[lllllllllllllIIIlllIlIIIlIIIlIIl.length];
        for (int lllllllllllllIIIlllIlIIIlIIIIlll = 0; lllllllllllllIIIlllIlIIIlIIIIlll < lllllllllllllIIIlllIlIIIlIIIlIIl.length; ++lllllllllllllIIIlllIlIIIlIIIIlll) {
            lllllllllllllIIIlllIlIIIlIIIlIII[lllllllllllllIIIlllIlIIIlIIIIlll] = lllllllllllllIIIlllIlIIIlIIIIllI.add(lllllllllllllIIIlllIlIIIlIIIlIIl[lllllllllllllIIIlllIlIIIlIIIIlll]);
        }
        return lllllllllllllIIIlllIlIIIlIIIlIII;
    }
    
    public static boolean rayTracePlaceCheck(final BlockPos lllllllllllllIIIlllIlIIIIIlIlIIl, final boolean lllllllllllllIIIlllIlIIIIIlIlIII, final float lllllllllllllIIIlllIlIIIIIlIIlll) {
        return !lllllllllllllIIIlllIlIIIIIlIlIII || BlockUtil.mc.world.rayTraceBlocks(new Vec3d(BlockUtil.mc.player.posX, BlockUtil.mc.player.posY + BlockUtil.mc.player.getEyeHeight(), BlockUtil.mc.player.posZ), new Vec3d(lllllllllllllIIIlllIlIIIIIlIlIIl.getX(), lllllllllllllIIIlllIlIIIIIlIlIIl.getY() + lllllllllllllIIIlllIlIIIIIlIIlll, lllllllllllllIIIlllIlIIIIIlIlIIl.getZ()), false, true, false) == null;
    }
    
    public static boolean canBeClicked(final BlockPos lllllllllllllIIIlllIlIIIlIlIIIIl) {
        return getBlock(lllllllllllllIIIlllIlIIIlIlIIIIl).canCollideCheck(getState(lllllllllllllIIIlllIlIIIlIlIIIIl), false);
    }
    
    public static boolean placeBlockSmartRotate(final BlockPos lllllllllllllIIIlllIIllllllllIlI, final EnumHand lllllllllllllIIIlllIIllllllIlllI, final boolean lllllllllllllIIIlllIIllllllIllIl, final boolean lllllllllllllIIIlllIIllllllIllII, final boolean lllllllllllllIIIlllIIlllllllIllI) {
        boolean lllllllllllllIIIlllIIlllllllIlIl = false;
        final EnumFacing lllllllllllllIIIlllIIlllllllIlII = getFirstFacing(lllllllllllllIIIlllIIllllllllIlI);
        if (lllllllllllllIIIlllIIlllllllIlII == null) {
            return lllllllllllllIIIlllIIlllllllIllI;
        }
        final BlockPos lllllllllllllIIIlllIIlllllllIIll = lllllllllllllIIIlllIIllllllllIlI.offset(lllllllllllllIIIlllIIlllllllIlII);
        final EnumFacing lllllllllllllIIIlllIIlllllllIIlI = lllllllllllllIIIlllIIlllllllIlII.getOpposite();
        final Vec3d lllllllllllllIIIlllIIlllllllIIIl = new Vec3d(lllllllllllllIIIlllIIlllllllIIll).add(new Vec3d(0.5, 0.5, 0.5)).add(new Vec3d(lllllllllllllIIIlllIIlllllllIIlI.getDirectionVec()).scale(0.5));
        final Block lllllllllllllIIIlllIIlllllllIIII = BlockUtil.mc.world.getBlockState(lllllllllllllIIIlllIIlllllllIIll).getBlock();
        if (!BlockUtil.mc.player.isSneaking() && (BlockUtil.blackList.contains(lllllllllllllIIIlllIIlllllllIIII) || BlockUtil.shulkerList.contains(lllllllllllllIIIlllIIlllllllIIII))) {
            BlockUtil.mc.player.connection.sendPacket(new CPacketEntityAction(BlockUtil.mc.player, CPacketEntityAction.Action.START_SNEAKING));
            lllllllllllllIIIlllIIlllllllIlIl = true;
        }
        if (lllllllllllllIIIlllIIllllllIllIl) {
            RotationUtils.lookAtVec3d(lllllllllllllIIIlllIIlllllllIIIl);
        }
        rightClickBlock(lllllllllllllIIIlllIIlllllllIIll, lllllllllllllIIIlllIIlllllllIIIl, lllllllllllllIIIlllIIllllllIlllI, lllllllllllllIIIlllIIlllllllIIlI, lllllllllllllIIIlllIIllllllIllII);
        BlockUtil.mc.player.swingArm(EnumHand.MAIN_HAND);
        BlockUtil.mc.rightClickDelayTimer = 4;
        return lllllllllllllIIIlllIIlllllllIlIl || lllllllllllllIIIlllIIlllllllIllI;
    }
    
    public static void rightClickBlock(final BlockPos lllllllllllllIIIlllIlIIIIIIIllIl, final Vec3d lllllllllllllIIIlllIlIIIIIIlIlII, final EnumHand lllllllllllllIIIlllIlIIIIIIlIIll, final EnumFacing lllllllllllllIIIlllIlIIIIIIlIIlI, final boolean lllllllllllllIIIlllIlIIIIIIIlIIl) {
        if (lllllllllllllIIIlllIlIIIIIIIlIIl) {
            final float lllllllllllllIIIlllIlIIIIIIlIIII = (float)(lllllllllllllIIIlllIlIIIIIIlIlII.xCoord - lllllllllllllIIIlllIlIIIIIIIllIl.getX());
            final float lllllllllllllIIIlllIlIIIIIIIllll = (float)(lllllllllllllIIIlllIlIIIIIIlIlII.yCoord - lllllllllllllIIIlllIlIIIIIIIllIl.getY());
            final float lllllllllllllIIIlllIlIIIIIIIlllI = (float)(lllllllllllllIIIlllIlIIIIIIlIlII.zCoord - lllllllllllllIIIlllIlIIIIIIIllIl.getZ());
            BlockUtil.mc.player.connection.sendPacket(new CPacketPlayerTryUseItemOnBlock(lllllllllllllIIIlllIlIIIIIIIllIl, lllllllllllllIIIlllIlIIIIIIlIIlI, lllllllllllllIIIlllIlIIIIIIlIIll, lllllllllllllIIIlllIlIIIIIIlIIII, lllllllllllllIIIlllIlIIIIIIIllll, lllllllllllllIIIlllIlIIIIIIIlllI));
        }
        else {
            BlockUtil.mc.playerController.processRightClickBlock(BlockUtil.mc.player, BlockUtil.mc.world, lllllllllllllIIIlllIlIIIIIIIllIl, lllllllllllllIIIlllIlIIIIIIlIIlI, lllllllllllllIIIlllIlIIIIIIlIlII, lllllllllllllIIIlllIlIIIIIIlIIll);
        }
        BlockUtil.mc.player.swingArm(EnumHand.MAIN_HAND);
        BlockUtil.mc.rightClickDelayTimer = 4;
    }
    
    public static int isPositionPlaceable(final BlockPos lllllllllllllIIIlllIlIIIlIIlIlII, final boolean lllllllllllllIIIlllIlIIIlIIlIIll, final boolean lllllllllllllIIIlllIlIIIlIIlIIlI) {
        final Block lllllllllllllIIIlllIlIIIlIIlIlll = BlockUtil.mc.world.getBlockState(lllllllllllllIIIlllIlIIIlIIlIlII).getBlock();
        if (!(lllllllllllllIIIlllIlIIIlIIlIlll instanceof BlockAir) && !(lllllllllllllIIIlllIlIIIlIIlIlll instanceof BlockLiquid) && !(lllllllllllllIIIlllIlIIIlIIlIlll instanceof BlockTallGrass) && !(lllllllllllllIIIlllIlIIIlIIlIlll instanceof BlockFire) && !(lllllllllllllIIIlllIlIIIlIIlIlll instanceof BlockDeadBush) && !(lllllllllllllIIIlllIlIIIlIIlIlll instanceof BlockSnow)) {
            return 0;
        }
        if (!rayTracePlaceCheck(lllllllllllllIIIlllIlIIIlIIlIlII, lllllllllllllIIIlllIlIIIlIIlIIll, 0.0f)) {
            return -1;
        }
        if (lllllllllllllIIIlllIlIIIlIIlIIlI) {
            for (final Entity lllllllllllllIIIlllIlIIIlIIlIllI : BlockUtil.mc.world.getEntitiesWithinAABB((Class<? extends Entity>)Entity.class, new AxisAlignedBB(lllllllllllllIIIlllIlIIIlIIlIlII))) {
                if (!(lllllllllllllIIIlllIlIIIlIIlIllI instanceof EntityItem)) {
                    if (lllllllllllllIIIlllIlIIIlIIlIllI instanceof EntityXPOrb) {
                        continue;
                    }
                    return 1;
                }
            }
        }
        for (final EnumFacing lllllllllllllIIIlllIlIIIlIIlIlIl : getPossibleSides(lllllllllllllIIIlllIlIIIlIIlIlII)) {
            if (!canBeClicked(lllllllllllllIIIlllIlIIIlIIlIlII.offset(lllllllllllllIIIlllIlIIIlIIlIlIl))) {
                continue;
            }
            return 3;
        }
        return 2;
    }
    
    public static List<Vec3d> getUnsafeBlocksFromVec3d(final Vec3d lllllllllllllIIIlllIlIIIIlIIIIII, final int lllllllllllllIIIlllIlIIIIIllllll, final boolean lllllllllllllIIIlllIlIIIIIlllllI) {
        final ArrayList<Vec3d> lllllllllllllIIIlllIlIIIIIllllIl = new ArrayList<Vec3d>();
        final Exception lllllllllllllIIIlllIlIIIIIllIIlI;
        final String lllllllllllllIIIlllIlIIIIIllIIll = (String)((Vec3d[])(Object)(lllllllllllllIIIlllIlIIIIIllIIlI = (Exception)(Object)getOffsets(lllllllllllllIIIlllIlIIIIIllllll, lllllllllllllIIIlllIlIIIIIlllllI))).length;
        for (byte lllllllllllllIIIlllIlIIIIIllIlII = 0; lllllllllllllIIIlllIlIIIIIllIlII < lllllllllllllIIIlllIlIIIIIllIIll; ++lllllllllllllIIIlllIlIIIIIllIlII) {
            final Vec3d lllllllllllllIIIlllIlIIIIIllllII = lllllllllllllIIIlllIlIIIIIllIIlI[lllllllllllllIIIlllIlIIIIIllIlII];
            final BlockPos lllllllllllllIIIlllIlIIIIIlllIll = new BlockPos(lllllllllllllIIIlllIlIIIIlIIIIII).add(lllllllllllllIIIlllIlIIIIIllllII.xCoord, lllllllllllllIIIlllIlIIIIIllllII.yCoord, lllllllllllllIIIlllIlIIIIIllllII.zCoord);
            final Block lllllllllllllIIIlllIlIIIIIlllIlI = BlockUtil.mc.world.getBlockState(lllllllllllllIIIlllIlIIIIIlllIll).getBlock();
            if (lllllllllllllIIIlllIlIIIIIlllIlI instanceof BlockAir || lllllllllllllIIIlllIlIIIIIlllIlI instanceof BlockLiquid || lllllllllllllIIIlllIlIIIIIlllIlI instanceof BlockTallGrass || lllllllllllllIIIlllIlIIIIIlllIlI instanceof BlockFire || lllllllllllllIIIlllIlIIIIIlllIlI instanceof BlockDeadBush || lllllllllllllIIIlllIlIIIIIlllIlI instanceof BlockSnow) {
                lllllllllllllIIIlllIlIIIIIllllIl.add(lllllllllllllIIIlllIlIIIIIllllII);
            }
        }
        return lllllllllllllIIIlllIlIIIIIllllIl;
    }
    
    public static Vec3d[] getOffsets(final int lllllllllllllIIIlllIlIIIIlIlIIlI, final boolean lllllllllllllIIIlllIlIIIIlIlIIIl) {
        final List<Vec3d> lllllllllllllIIIlllIlIIIIlIlIIII = getOffsetList(lllllllllllllIIIlllIlIIIIlIlIIlI, lllllllllllllIIIlllIlIIIIlIlIIIl);
        final Vec3d[] lllllllllllllIIIlllIlIIIIlIIllll = new Vec3d[lllllllllllllIIIlllIlIIIIlIlIIII.size()];
        return lllllllllllllIIIlllIlIIIIlIlIIII.toArray(lllllllllllllIIIlllIlIIIIlIIllll);
    }
    
    public static List<EnumFacing> getPossibleSides(final BlockPos lllllllllllllIIIlllIlIIIlIlllIlI) {
        final ArrayList<EnumFacing> lllllllllllllIIIlllIlIIIlIlllllI = new ArrayList<EnumFacing>();
        if (BlockUtil.mc.world == null || lllllllllllllIIIlllIlIIIlIlllIlI == null) {
            return lllllllllllllIIIlllIlIIIlIlllllI;
        }
        final float lllllllllllllIIIlllIlIIIlIllIlIl;
        final short lllllllllllllIIIlllIlIIIlIllIllI = (short)((EnumFacing[])(Object)(lllllllllllllIIIlllIlIIIlIllIlIl = (float)(Object)EnumFacing.values())).length;
        for (byte lllllllllllllIIIlllIlIIIlIllIlll = 0; lllllllllllllIIIlllIlIIIlIllIlll < lllllllllllllIIIlllIlIIIlIllIllI; ++lllllllllllllIIIlllIlIIIlIllIlll) {
            final EnumFacing lllllllllllllIIIlllIlIIIlIllllIl = lllllllllllllIIIlllIlIIIlIllIlIl[lllllllllllllIIIlllIlIIIlIllIlll];
            final BlockPos lllllllllllllIIIlllIlIIIlIllllII = lllllllllllllIIIlllIlIIIlIlllIlI.offset(lllllllllllllIIIlllIlIIIlIllllIl);
            final IBlockState lllllllllllllIIIlllIlIIIlIlllIll = BlockUtil.mc.world.getBlockState(lllllllllllllIIIlllIlIIIlIllllII);
            if (lllllllllllllIIIlllIlIIIlIlllIll != null && lllllllllllllIIIlllIlIIIlIlllIll.getBlock().canCollideCheck(lllllllllllllIIIlllIlIIIlIlllIll, false) && !lllllllllllllIIIlllIlIIIlIlllIll.getMaterial().isReplaceable()) {
                lllllllllllllIIIlllIlIIIlIlllllI.add(lllllllllllllIIIlllIlIIIlIllllIl);
            }
        }
        return lllllllllllllIIIlllIlIIIlIlllllI;
    }
    
    public static EnumFacing getFirstFacing(final BlockPos lllllllllllllIIIlllIlIIIIIlIIIII) {
        final Iterator<EnumFacing> lllllllllllllIIIlllIlIIIIIlIIIlI = getPossibleSides(lllllllllllllIIIlllIlIIIIIlIIIII).iterator();
        if (lllllllllllllIIIlllIlIIIIIlIIIlI.hasNext()) {
            final EnumFacing lllllllllllllIIIlllIlIIIIIlIIIIl = lllllllllllllIIIlllIlIIIIIlIIIlI.next();
            return lllllllllllllIIIlllIlIIIIIlIIIIl;
        }
        return null;
    }
    
    public static Block getBlock(final BlockPos lllllllllllllIIIlllIlIIIlIlIlllI) {
        return getState(lllllllllllllIIIlllIlIIIlIlIlllI).getBlock();
    }
    
    public static List<Vec3d> targets(final Vec3d lllllllllllllIIIlllIlIIIIllIlIll, final boolean lllllllllllllIIIlllIlIIIIllIlIlI, final boolean lllllllllllllIIIlllIlIIIIlllIlII, final boolean lllllllllllllIIIlllIlIIIIllIlIII, final boolean lllllllllllllIIIlllIlIIIIllIIlll, final boolean lllllllllllllIIIlllIlIIIIllIIllI, final boolean lllllllllllllIIIlllIlIIIIlllIIII) {
        final ArrayList<Vec3d> lllllllllllllIIIlllIlIIIIllIllll = new ArrayList<Vec3d>();
        if (lllllllllllllIIIlllIlIIIIllIIllI) {
            Collections.addAll(lllllllllllllIIIlllIlIIIIllIllll, convertVec3ds(lllllllllllllIIIlllIlIIIIllIlIll, BlockUtil.antiDropOffsetList));
        }
        if (lllllllllllllIIIlllIlIIIIllIIlll) {
            Collections.addAll(lllllllllllllIIIlllIlIIIIllIllll, convertVec3ds(lllllllllllllIIIlllIlIIIIllIlIll, BlockUtil.platformOffsetList));
        }
        if (lllllllllllllIIIlllIlIIIIllIlIII) {
            Collections.addAll(lllllllllllllIIIlllIlIIIIllIllll, convertVec3ds(lllllllllllllIIIlllIlIIIIllIlIll, BlockUtil.legOffsetList));
        }
        Collections.addAll(lllllllllllllIIIlllIlIIIIllIllll, convertVec3ds(lllllllllllllIIIlllIlIIIIllIlIll, BlockUtil.OffsetList));
        if (lllllllllllllIIIlllIlIIIIlllIlII) {
            Collections.addAll(lllllllllllllIIIlllIlIIIIllIllll, convertVec3ds(lllllllllllllIIIlllIlIIIIllIlIll, BlockUtil.antiStepOffsetList));
        }
        else {
            final List<Vec3d> lllllllllllllIIIlllIlIIIIllIlllI = getUnsafeBlocksFromVec3d(lllllllllllllIIIlllIlIIIIllIlIll, 2, false);
            if (lllllllllllllIIIlllIlIIIIllIlllI.size() == 4) {
                for (final Vec3d lllllllllllllIIIlllIlIIIIllIllIl : lllllllllllllIIIlllIlIIIIllIlllI) {
                    final BlockPos lllllllllllllIIIlllIlIIIIllIllII = new BlockPos(lllllllllllllIIIlllIlIIIIllIlIll).add(lllllllllllllIIIlllIlIIIIllIllIl.xCoord, lllllllllllllIIIlllIlIIIIllIllIl.yCoord, lllllllllllllIIIlllIlIIIIllIllIl.zCoord);
                    switch (isPositionPlaceable(lllllllllllllIIIlllIlIIIIllIllII, lllllllllllllIIIlllIlIIIIlllIIII, true)) {
                        case -1:
                        case 1:
                        case 2: {
                            continue;
                        }
                        case 3: {
                            lllllllllllllIIIlllIlIIIIllIllll.add(lllllllllllllIIIlllIlIIIIllIlIll.add(lllllllllllllIIIlllIlIIIIllIllIl));
                            break;
                        }
                    }
                    if (lllllllllllllIIIlllIlIIIIllIlIlI) {
                        Collections.addAll(lllllllllllllIIIlllIlIIIIllIllll, convertVec3ds(lllllllllllllIIIlllIlIIIIllIlIll, BlockUtil.antiScaffoldOffsetList));
                    }
                    return lllllllllllllIIIlllIlIIIIllIllll;
                }
            }
        }
        if (lllllllllllllIIIlllIlIIIIllIlIlI) {
            Collections.addAll(lllllllllllllIIIlllIlIIIIllIllll, convertVec3ds(lllllllllllllIIIlllIlIIIIllIlIll, BlockUtil.antiScaffoldOffsetList));
        }
        return lllllllllllllIIIlllIlIIIIllIllll;
    }
    
    public static List<Vec3d> getOffsetList(final int lllllllllllllIIIlllIlIIIIlIlllII, final boolean lllllllllllllIIIlllIlIIIIlIllIII) {
        final ArrayList<Vec3d> lllllllllllllIIIlllIlIIIIlIllIlI = new ArrayList<Vec3d>();
        lllllllllllllIIIlllIlIIIIlIllIlI.add(new Vec3d(-1.0, lllllllllllllIIIlllIlIIIIlIlllII, 0.0));
        lllllllllllllIIIlllIlIIIIlIllIlI.add(new Vec3d(1.0, lllllllllllllIIIlllIlIIIIlIlllII, 0.0));
        lllllllllllllIIIlllIlIIIIlIllIlI.add(new Vec3d(0.0, lllllllllllllIIIlllIlIIIIlIlllII, -1.0));
        lllllllllllllIIIlllIlIIIIlIllIlI.add(new Vec3d(0.0, lllllllllllllIIIlllIlIIIIlIlllII, 1.0));
        if (lllllllllllllIIIlllIlIIIIlIllIII) {
            lllllllllllllIIIlllIlIIIIlIllIlI.add(new Vec3d(0.0, lllllllllllllIIIlllIlIIIIlIlllII - 1, 0.0));
        }
        return lllllllllllllIIIlllIlIIIIlIllIlI;
    }
    
    public static IBlockState getState(final BlockPos lllllllllllllIIIlllIlIIIlIllIIIl) {
        return BlockUtil.mc.world.getBlockState(lllllllllllllIIIlllIlIIIlIllIIIl);
    }
    
    static {
        mc = Minecraft.getMinecraft();
        BlockUtil.antiDropOffsetList = new Vec3d[] { new Vec3d(0.0, -2.0, 0.0) };
        BlockUtil.platformOffsetList = new Vec3d[] { new Vec3d(0.0, -1.0, 0.0), new Vec3d(0.0, -1.0, -1.0), new Vec3d(0.0, -1.0, 1.0), new Vec3d(-1.0, -1.0, 0.0), new Vec3d(1.0, -1.0, 0.0) };
        BlockUtil.legOffsetList = new Vec3d[] { new Vec3d(-1.0, 0.0, 0.0), new Vec3d(1.0, 0.0, 0.0), new Vec3d(0.0, 0.0, -1.0), new Vec3d(0.0, 0.0, 1.0) };
        BlockUtil.OffsetList = new Vec3d[] { new Vec3d(1.0, 1.0, 0.0), new Vec3d(-1.0, 1.0, 0.0), new Vec3d(0.0, 1.0, 1.0), new Vec3d(0.0, 1.0, -1.0), new Vec3d(0.0, 2.0, 0.0) };
        BlockUtil.antiStepOffsetList = new Vec3d[] { new Vec3d(-1.0, 2.0, 0.0), new Vec3d(1.0, 2.0, 0.0), new Vec3d(0.0, 2.0, 1.0), new Vec3d(0.0, 2.0, -1.0) };
        BlockUtil.antiScaffoldOffsetList = new Vec3d[] { new Vec3d(0.0, 3.0, 0.0) };
        blackList = Arrays.asList(Blocks.ENDER_CHEST, Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.CRAFTING_TABLE, Blocks.ANVIL, Blocks.BREWING_STAND, Blocks.HOPPER, Blocks.DROPPER, Blocks.DISPENSER);
        shulkerList = Arrays.asList(Blocks.field_190981_dp, Blocks.field_190982_dq, Blocks.field_190983_dr, Blocks.field_190984_ds, Blocks.field_190985_dt, Blocks.field_190986_du, Blocks.field_190987_dv, Blocks.field_190988_dw, Blocks.field_190989_dx, Blocks.field_190990_dy, Blocks.field_190991_dz, Blocks.field_190975_dA, Blocks.field_192427_dB, Blocks.field_192428_dC, Blocks.field_192429_dD, Blocks.field_192430_dE);
    }
}
