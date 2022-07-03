package com.kisman.nr.cc.util;

import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.block.state.*;

public class EntityUtil
{
    private static final /* synthetic */ Minecraft mc;
    
    public static float getBlockDensity(final Vec3d llllllllllllllIlllIlIlIIIIIIllIl, final AxisAlignedBB llllllllllllllIlllIlIlIIIIIIllII) {
        final double llllllllllllllIlllIlIlIIIIIllIlI = 1.0 / ((llllllllllllllIlllIlIlIIIIIIllII.maxX - llllllllllllllIlllIlIlIIIIIIllII.minX) * 2.0 + 1.0);
        final double llllllllllllllIlllIlIlIIIIIllIIl = 1.0 / ((llllllllllllllIlllIlIlIIIIIIllII.maxY - llllllllllllllIlllIlIlIIIIIIllII.minY) * 2.0 + 1.0);
        final double llllllllllllllIlllIlIlIIIIIllIII = 1.0 / ((llllllllllllllIlllIlIlIIIIIIllII.maxZ - llllllllllllllIlllIlIlIIIIIIllII.minZ) * 2.0 + 1.0);
        final double llllllllllllllIlllIlIlIIIIIlIlll = (1.0 - Math.floor(1.0 / llllllllllllllIlllIlIlIIIIIllIlI) * llllllllllllllIlllIlIlIIIIIllIlI) / 2.0;
        final double llllllllllllllIlllIlIlIIIIIlIllI = (1.0 - Math.floor(1.0 / llllllllllllllIlllIlIlIIIIIllIII) * llllllllllllllIlllIlIlIIIIIllIII) / 2.0;
        float llllllllllllllIlllIlIlIIIIIlIlIl = 0.0f;
        float llllllllllllllIlllIlIlIIIIIlIlII = 0.0f;
        for (float llllllllllllllIlllIlIlIIIIIlIIll = 0.0f; llllllllllllllIlllIlIlIIIIIlIIll <= 1.0f; llllllllllllllIlllIlIlIIIIIlIIll += (float)llllllllllllllIlllIlIlIIIIIllIlI) {
            for (float llllllllllllllIlllIlIlIIIIIlIIlI = 0.0f; llllllllllllllIlllIlIlIIIIIlIIlI <= 1.0f; llllllllllllllIlllIlIlIIIIIlIIlI += (float)llllllllllllllIlllIlIlIIIIIllIIl) {
                for (float llllllllllllllIlllIlIlIIIIIlIIIl = 0.0f; llllllllllllllIlllIlIlIIIIIlIIIl <= 1.0f; llllllllllllllIlllIlIlIIIIIlIIIl += (float)llllllllllllllIlllIlIlIIIIIllIII) {
                    final double llllllllllllllIlllIlIlIIIIIlIIII = llllllllllllllIlllIlIlIIIIIIllII.minX + (llllllllllllllIlllIlIlIIIIIIllII.maxX - llllllllllllllIlllIlIlIIIIIIllII.minX) * llllllllllllllIlllIlIlIIIIIlIIll;
                    final double llllllllllllllIlllIlIlIIIIIIllll = llllllllllllllIlllIlIlIIIIIIllII.minY + (llllllllllllllIlllIlIlIIIIIIllII.maxY - llllllllllllllIlllIlIlIIIIIIllII.minY) * llllllllllllllIlllIlIlIIIIIlIIlI;
                    final double llllllllllllllIlllIlIlIIIIIIlllI = llllllllllllllIlllIlIlIIIIIIllII.minZ + (llllllllllllllIlllIlIlIIIIIIllII.maxZ - llllllllllllllIlllIlIlIIIIIIllII.minZ) * llllllllllllllIlllIlIlIIIIIlIIIl;
                    if (rayTraceBlocks(new Vec3d(llllllllllllllIlllIlIlIIIIIlIIII + llllllllllllllIlllIlIlIIIIIlIlll, llllllllllllllIlllIlIlIIIIIIllll, llllllllllllllIlllIlIlIIIIIIlllI + llllllllllllllIlllIlIlIIIIIlIllI), llllllllllllllIlllIlIlIIIIIIllIl, false, false, false) == null) {
                        ++llllllllllllllIlllIlIlIIIIIlIlIl;
                    }
                    ++llllllllllllllIlllIlIlIIIIIlIlII;
                }
            }
        }
        return llllllllllllllIlllIlIlIIIIIlIlIl / llllllllllllllIlllIlIlIIIIIlIlII;
    }
    
    public static double getDistance(final double llllllllllllllIlllIlIIllIllIllll, final double llllllllllllllIlllIlIIllIllIllIl, final double llllllllllllllIlllIlIIllIlllIllI, final double llllllllllllllIlllIlIIllIllIlIll, final double llllllllllllllIlllIlIIllIlllIlII, final double llllllllllllllIlllIlIIllIllIlIIl) {
        final double llllllllllllllIlllIlIIllIlllIIlI = llllllllllllllIlllIlIIllIllIllll - llllllllllllllIlllIlIIllIllIlIll;
        final double llllllllllllllIlllIlIIllIlllIIIl = llllllllllllllIlllIlIIllIllIllIl - llllllllllllllIlllIlIIllIlllIlII;
        final double llllllllllllllIlllIlIIllIlllIIII = llllllllllllllIlllIlIIllIlllIllI - llllllllllllllIlllIlIIllIllIlIIl;
        return MathHelper.sqrt(llllllllllllllIlllIlIIllIlllIIlI * llllllllllllllIlllIlIIllIlllIIlI + llllllllllllllIlllIlIIllIlllIIIl * llllllllllllllIlllIlIIllIlllIIIl + llllllllllllllIlllIlIIllIlllIIII * llllllllllllllIlllIlIIllIlllIIII);
    }
    
    public static float getHealth(final EntityPlayer llllllllllllllIlllIlIlIIIIlllIII) {
        return llllllllllllllIlllIlIlIIIIlllIII.getHealth();
    }
    
    public static BlockPos getPosition(final Entity llllllllllllllIlllIlIIlllIIIIIll) {
        return new BlockPos(Math.floor(llllllllllllllIlllIlIIlllIIIIIll.posX), Math.floor(llllllllllllllIlllIlIIlllIIIIIll.posY), Math.floor(llllllllllllllIlllIlIIlllIIIIIll.posZ));
    }
    
    public static float getDamageMultiplied(final float llllllllllllllIlllIlIlIIIIlIllll) {
        final int llllllllllllllIlllIlIlIIIIlIlllI = EntityUtil.mc.world.getDifficulty().getDifficultyId();
        return llllllllllllllIlllIlIlIIIIlIllll * ((llllllllllllllIlllIlIlIIIIlIlllI == 0) ? 0.0f : ((llllllllllllllIlllIlIlIIIIlIlllI == 2) ? 1.0f : ((llllllllllllllIlllIlIlIIIIlIlllI == 1) ? 0.5f : 1.5f)));
    }
    
    public static BlockPos getRoundedBlockPos(final Entity llllllllllllllIlllIlIlIIIIllIlIl) {
        return new BlockPos(MathUtil.roundVec(llllllllllllllIlllIlIlIIIIllIlIl.getPositionVector(), 0));
    }
    
    public static boolean stopSneaking(final boolean llllllllllllllIlllIlIlIIIIllIIlI) {
        if (llllllllllllllIlllIlIlIIIIllIIlI && EntityUtil.mc.player != null) {
            EntityUtil.mc.player.connection.sendPacket(new CPacketEntityAction(EntityUtil.mc.player, CPacketEntityAction.Action.STOP_SNEAKING));
        }
        return false;
    }
    
    public static float clamp(float llllllllllllllIlllIlIIlllIIIIlll, final float llllllllllllllIlllIlIIlllIIIlIIl, final float llllllllllllllIlllIlIIlllIIIlIII) {
        if (llllllllllllllIlllIlIIlllIIIIlll <= llllllllllllllIlllIlIIlllIIIlIIl) {
            llllllllllllllIlllIlIIlllIIIIlll = llllllllllllllIlllIlIIlllIIIlIIl;
        }
        if (llllllllllllllIlllIlIIlllIIIIlll >= llllllllllllllIlllIlIIlllIIIlIII) {
            llllllllllllllIlllIlIIlllIIIIlll = llllllllllllllIlllIlIIlllIIIlIII;
        }
        return llllllllllllllIlllIlIIlllIIIIlll;
    }
    
    public static RayTraceResult rayTraceBlocks(Vec3d llllllllllllllIlllIlIIlllIlllllI, final Vec3d llllllllllllllIlllIlIIlllIllllIl, final boolean llllllllllllllIlllIlIIlllIllllII, final boolean llllllllllllllIlllIlIIllllIlllII, final boolean llllllllllllllIlllIlIIlllIlllIlI) {
        final int llllllllllllllIlllIlIIllllIllIlI = MathHelper.floor(llllllllllllllIlllIlIIlllIllllIl.xCoord);
        final int llllllllllllllIlllIlIIllllIllIIl = MathHelper.floor(llllllllllllllIlllIlIIlllIllllIl.yCoord);
        final int llllllllllllllIlllIlIIllllIllIII = MathHelper.floor(llllllllllllllIlllIlIIlllIllllIl.zCoord);
        int llllllllllllllIlllIlIIllllIlIlll = MathHelper.floor(llllllllllllllIlllIlIIlllIlllllI.xCoord);
        int llllllllllllllIlllIlIIllllIlIllI = MathHelper.floor(llllllllllllllIlllIlIIlllIlllllI.yCoord);
        int llllllllllllllIlllIlIIllllIlIlIl = MathHelper.floor(llllllllllllllIlllIlIIlllIlllllI.zCoord);
        BlockPos llllllllllllllIlllIlIIllllIlIlII = new BlockPos(llllllllllllllIlllIlIIllllIlIlll, llllllllllllllIlllIlIIllllIlIllI, llllllllllllllIlllIlIIllllIlIlIl);
        final IBlockState llllllllllllllIlllIlIIllllIlIIll = EntityUtil.mc.world.getBlockState(llllllllllllllIlllIlIIllllIlIlII);
        final Block llllllllllllllIlllIlIIllllIlIIlI = llllllllllllllIlllIlIIllllIlIIll.getBlock();
        if ((!llllllllllllllIlllIlIIllllIlllII || llllllllllllllIlllIlIIllllIlIIll.getCollisionBoundingBox(EntityUtil.mc.world, llllllllllllllIlllIlIIllllIlIlII) != Block.NULL_AABB) && llllllllllllllIlllIlIIllllIlIIlI.canCollideCheck(llllllllllllllIlllIlIIllllIlIIll, llllllllllllllIlllIlIIlllIllllII)) {
            return llllllllllllllIlllIlIIllllIlIIll.collisionRayTrace(EntityUtil.mc.world, llllllllllllllIlllIlIIllllIlIlII, llllllllllllllIlllIlIIlllIlllllI, llllllllllllllIlllIlIIlllIllllIl);
        }
        RayTraceResult llllllllllllllIlllIlIIllllIlIIIl = null;
        int llllllllllllllIlllIlIIllllIlIIII = 200;
        while (llllllllllllllIlllIlIIllllIlIIII-- >= 0) {
            if (Double.isNaN(llllllllllllllIlllIlIIlllIlllllI.xCoord) || Double.isNaN(llllllllllllllIlllIlIIlllIlllllI.yCoord) || Double.isNaN(llllllllllllllIlllIlIIlllIlllllI.zCoord)) {
                return null;
            }
            if (llllllllllllllIlllIlIIllllIlIlll == llllllllllllllIlllIlIIllllIllIlI && llllllllllllllIlllIlIIllllIlIllI == llllllllllllllIlllIlIIllllIllIIl && llllllllllllllIlllIlIIllllIlIlIl == llllllllllllllIlllIlIIllllIllIII) {
                return llllllllllllllIlllIlIIlllIlllIlI ? llllllllllllllIlllIlIIllllIlIIIl : null;
            }
            boolean llllllllllllllIlllIlIIllllIIllll = true;
            boolean llllllllllllllIlllIlIIllllIIlllI = true;
            boolean llllllllllllllIlllIlIIllllIIllIl = true;
            double llllllllllllllIlllIlIIllllIIllII = 999.0;
            double llllllllllllllIlllIlIIllllIIlIll = 999.0;
            double llllllllllllllIlllIlIIllllIIlIlI = 999.0;
            if (llllllllllllllIlllIlIIllllIllIlI > llllllllllllllIlllIlIIllllIlIlll) {
                llllllllllllllIlllIlIIllllIIllII = llllllllllllllIlllIlIIllllIlIlll + 1.0;
            }
            else if (llllllllllllllIlllIlIIllllIllIlI < llllllllllllllIlllIlIIllllIlIlll) {
                llllllllllllllIlllIlIIllllIIllII = llllllllllllllIlllIlIIllllIlIlll + 0.0;
            }
            else {
                llllllllllllllIlllIlIIllllIIllll = false;
            }
            if (llllllllllllllIlllIlIIllllIllIIl > llllllllllllllIlllIlIIllllIlIllI) {
                llllllllllllllIlllIlIIllllIIlIll = llllllllllllllIlllIlIIllllIlIllI + 1.0;
            }
            else if (llllllllllllllIlllIlIIllllIllIIl < llllllllllllllIlllIlIIllllIlIllI) {
                llllllllllllllIlllIlIIllllIIlIll = llllllllllllllIlllIlIIllllIlIllI + 0.0;
            }
            else {
                llllllllllllllIlllIlIIllllIIlllI = false;
            }
            if (llllllllllllllIlllIlIIllllIllIII > llllllllllllllIlllIlIIllllIlIlIl) {
                llllllllllllllIlllIlIIllllIIlIlI = llllllllllllllIlllIlIIllllIlIlIl + 1.0;
            }
            else if (llllllllllllllIlllIlIIllllIllIII < llllllllllllllIlllIlIIllllIlIlIl) {
                llllllllllllllIlllIlIIllllIIlIlI = llllllllllllllIlllIlIIllllIlIlIl + 0.0;
            }
            else {
                llllllllllllllIlllIlIIllllIIllIl = false;
            }
            double llllllllllllllIlllIlIIllllIIlIIl = 999.0;
            double llllllllllllllIlllIlIIllllIIlIII = 999.0;
            double llllllllllllllIlllIlIIllllIIIlll = 999.0;
            final double llllllllllllllIlllIlIIllllIIIllI = llllllllllllllIlllIlIIlllIllllIl.xCoord - llllllllllllllIlllIlIIlllIlllllI.xCoord;
            final double llllllllllllllIlllIlIIllllIIIlIl = llllllllllllllIlllIlIIlllIllllIl.yCoord - llllllllllllllIlllIlIIlllIlllllI.yCoord;
            final double llllllllllllllIlllIlIIllllIIIlII = llllllllllllllIlllIlIIlllIllllIl.zCoord - llllllllllllllIlllIlIIlllIlllllI.zCoord;
            if (llllllllllllllIlllIlIIllllIIllll) {
                llllllllllllllIlllIlIIllllIIlIIl = (llllllllllllllIlllIlIIllllIIllII - llllllllllllllIlllIlIIlllIlllllI.xCoord) / llllllllllllllIlllIlIIllllIIIllI;
            }
            if (llllllllllllllIlllIlIIllllIIlllI) {
                llllllllllllllIlllIlIIllllIIlIII = (llllllllllllllIlllIlIIllllIIlIll - llllllllllllllIlllIlIIlllIlllllI.yCoord) / llllllllllllllIlllIlIIllllIIIlIl;
            }
            if (llllllllllllllIlllIlIIllllIIllIl) {
                llllllllllllllIlllIlIIllllIIIlll = (llllllllllllllIlllIlIIllllIIlIlI - llllllllllllllIlllIlIIlllIlllllI.zCoord) / llllllllllllllIlllIlIIllllIIIlII;
            }
            if (llllllllllllllIlllIlIIllllIIlIIl == -0.0) {
                llllllllllllllIlllIlIIllllIIlIIl = -1.0E-4;
            }
            if (llllllllllllllIlllIlIIllllIIlIII == -0.0) {
                llllllllllllllIlllIlIIllllIIlIII = -1.0E-4;
            }
            if (llllllllllllllIlllIlIIllllIIIlll == -0.0) {
                llllllllllllllIlllIlIIllllIIIlll = -1.0E-4;
            }
            EnumFacing llllllllllllllIlllIlIIllllIIIIIl = null;
            if (llllllllllllllIlllIlIIllllIIlIIl < llllllllllllllIlllIlIIllllIIlIII && llllllllllllllIlllIlIIllllIIlIIl < llllllllllllllIlllIlIIllllIIIlll) {
                final EnumFacing llllllllllllllIlllIlIIllllIIIIll = (llllllllllllllIlllIlIIllllIllIlI > llllllllllllllIlllIlIIllllIlIlll) ? EnumFacing.WEST : EnumFacing.EAST;
                llllllllllllllIlllIlIIlllIlllllI = new Vec3d(llllllllllllllIlllIlIIllllIIllII, llllllllllllllIlllIlIIlllIlllllI.yCoord + llllllllllllllIlllIlIIllllIIIlIl * llllllllllllllIlllIlIIllllIIlIIl, llllllllllllllIlllIlIIlllIlllllI.zCoord + llllllllllllllIlllIlIIllllIIIlII * llllllllllllllIlllIlIIllllIIlIIl);
            }
            else if (llllllllllllllIlllIlIIllllIIlIII < llllllllllllllIlllIlIIllllIIIlll) {
                final EnumFacing llllllllllllllIlllIlIIllllIIIIlI = (llllllllllllllIlllIlIIllllIllIIl > llllllllllllllIlllIlIIllllIlIllI) ? EnumFacing.DOWN : EnumFacing.UP;
                llllllllllllllIlllIlIIlllIlllllI = new Vec3d(llllllllllllllIlllIlIIlllIlllllI.xCoord + llllllllllllllIlllIlIIllllIIIllI * llllllllllllllIlllIlIIllllIIlIII, llllllllllllllIlllIlIIllllIIlIll, llllllllllllllIlllIlIIlllIlllllI.zCoord + llllllllllllllIlllIlIIllllIIIlII * llllllllllllllIlllIlIIllllIIlIII);
            }
            else {
                llllllllllllllIlllIlIIllllIIIIIl = ((llllllllllllllIlllIlIIllllIllIII > llllllllllllllIlllIlIIllllIlIlIl) ? EnumFacing.NORTH : EnumFacing.SOUTH);
                llllllllllllllIlllIlIIlllIlllllI = new Vec3d(llllllllllllllIlllIlIIlllIlllllI.xCoord + llllllllllllllIlllIlIIllllIIIllI * llllllllllllllIlllIlIIllllIIIlll, llllllllllllllIlllIlIIlllIlllllI.yCoord + llllllllllllllIlllIlIIllllIIIlIl * llllllllllllllIlllIlIIllllIIIlll, llllllllllllllIlllIlIIllllIIlIlI);
            }
            llllllllllllllIlllIlIIllllIlIlll = MathHelper.floor(llllllllllllllIlllIlIIlllIlllllI.xCoord) - ((llllllllllllllIlllIlIIllllIIIIIl == EnumFacing.EAST) ? 1 : 0);
            llllllllllllllIlllIlIIllllIlIllI = MathHelper.floor(llllllllllllllIlllIlIIlllIlllllI.yCoord) - ((llllllllllllllIlllIlIIllllIIIIIl == EnumFacing.UP) ? 1 : 0);
            llllllllllllllIlllIlIIllllIlIlIl = MathHelper.floor(llllllllllllllIlllIlIIlllIlllllI.zCoord) - ((llllllllllllllIlllIlIIllllIIIIIl == EnumFacing.SOUTH) ? 1 : 0);
            llllllllllllllIlllIlIIllllIlIlII = new BlockPos(llllllllllllllIlllIlIIllllIlIlll, llllllllllllllIlllIlIIllllIlIllI, llllllllllllllIlllIlIIllllIlIlIl);
            final IBlockState llllllllllllllIlllIlIIllllIIIIII = EntityUtil.mc.world.getBlockState(llllllllllllllIlllIlIIllllIlIlII);
            final Block llllllllllllllIlllIlIIlllIllllll = llllllllllllllIlllIlIIllllIIIIII.getBlock();
            if (llllllllllllllIlllIlIIllllIlllII && llllllllllllllIlllIlIIllllIIIIII.getMaterial() != Material.PORTAL && llllllllllllllIlllIlIIllllIIIIII.getCollisionBoundingBox(EntityUtil.mc.world, llllllllllllllIlllIlIIllllIlIlII) == Block.NULL_AABB) {
                continue;
            }
            if (llllllllllllllIlllIlIIlllIllllll.canCollideCheck(llllllllllllllIlllIlIIllllIIIIII, llllllllllllllIlllIlIIlllIllllII) && !(llllllllllllllIlllIlIIlllIllllll instanceof BlockWeb)) {
                return llllllllllllllIlllIlIIllllIIIIII.collisionRayTrace(EntityUtil.mc.world, llllllllllllllIlllIlIIllllIlIlII, llllllllllllllIlllIlIIlllIlllllI, llllllllllllllIlllIlIIlllIllllIl);
            }
            llllllllllllllIlllIlIIllllIlIIIl = new RayTraceResult(RayTraceResult.Type.MISS, llllllllllllllIlllIlIIlllIlllllI, llllllllllllllIlllIlIIllllIIIIIl, llllllllllllllIlllIlIIllllIlIlII);
        }
        return llllllllllllllIlllIlIIlllIlllIlI ? llllllllllllllIlllIlIIllllIlIIIl : null;
    }
    
    public static Vec3d getInterpolatedAmount(final Entity llllllllllllllIlllIlIIlllIIlIlIl, final double llllllllllllllIlllIlIIlllIIlIIII, final double llllllllllllllIlllIlIIlllIIIllll, final double llllllllllllllIlllIlIIlllIIlIIlI) {
        return new Vec3d((llllllllllllllIlllIlIIlllIIlIlIl.posX - llllllllllllllIlllIlIIlllIIlIlIl.lastTickPosX) * llllllllllllllIlllIlIIlllIIlIIII, (llllllllllllllIlllIlIIlllIIlIlIl.posY - llllllllllllllIlllIlIIlllIIlIlIl.lastTickPosY) * llllllllllllllIlllIlIIlllIIIllll, (llllllllllllllIlllIlIIlllIIlIlIl.posZ - llllllllllllllIlllIlIIlllIIlIlIl.lastTickPosZ) * llllllllllllllIlllIlIIlllIIlIIlI);
    }
    
    public static Vec3d getInterpolatedAmount(final Entity llllllllllllllIlllIlIIlllIIlllIl, final double llllllllllllllIlllIlIIlllIIlllII) {
        return getInterpolatedAmount(llllllllllllllIlllIlIIlllIIlllIl, llllllllllllllIlllIlIIlllIIlllII, llllllllllllllIlllIlIIlllIIlllII, llllllllllllllIlllIlIIlllIIlllII);
    }
    
    static {
        mc = Minecraft.getMinecraft();
    }
    
    public static double getSpeedBPS(final Entity llllllllllllllIlllIlIlIIIIlllllI) {
        final double llllllllllllllIlllIlIlIIIlIIIIIl = Math.abs(llllllllllllllIlllIlIlIIIIlllllI.posX - llllllllllllllIlllIlIlIIIIlllllI.prevPosX);
        final double llllllllllllllIlllIlIlIIIlIIIIII = Math.abs(llllllllllllllIlllIlIlIIIIlllllI.posZ - llllllllllllllIlllIlIlIIIIlllllI.prevPosZ);
        double llllllllllllllIlllIlIlIIIIllllll = Math.sqrt(llllllllllllllIlllIlIlIIIlIIIIIl * llllllllllllllIlllIlIlIIIlIIIIIl + llllllllllllllIlllIlIlIIIlIIIIII * llllllllllllllIlllIlIlIIIlIIIIII);
        llllllllllllllIlllIlIlIIIIllllll *= EntityUtil.mc.getRenderPartialTicks();
        return llllllllllllllIlllIlIlIIIIllllll * 20.0;
    }
}
