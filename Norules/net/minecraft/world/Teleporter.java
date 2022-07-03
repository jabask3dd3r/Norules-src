package net.minecraft.world;

import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.state.pattern.*;
import it.unimi.dsi.fastutil.objects.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import it.unimi.dsi.fastutil.longs.*;

public class Teleporter
{
    private final /* synthetic */ WorldServer worldServerInstance;
    private final /* synthetic */ Long2ObjectMap<PortalPosition> destinationCoordinateCache;
    private final /* synthetic */ Random random;
    
    public void placeInPortal(final Entity lllllllllllllllIlIlIIIIIllIIllll, final float lllllllllllllllIlIlIIIIIllIIlllI) {
        if (this.worldServerInstance.provider.getDimensionType().getId() != 1) {
            if (!this.placeInExistingPortal(lllllllllllllllIlIlIIIIIllIIllll, lllllllllllllllIlIlIIIIIllIIlllI)) {
                this.makePortal(lllllllllllllllIlIlIIIIIllIIllll);
                this.placeInExistingPortal(lllllllllllllllIlIlIIIIIllIIllll, lllllllllllllllIlIlIIIIIllIIlllI);
            }
        }
        else {
            final int lllllllllllllllIlIlIIIIIllIlllII = MathHelper.floor(lllllllllllllllIlIlIIIIIllIIllll.posX);
            final int lllllllllllllllIlIlIIIIIllIllIll = MathHelper.floor(lllllllllllllllIlIlIIIIIllIIllll.posY) - 1;
            final int lllllllllllllllIlIlIIIIIllIllIlI = MathHelper.floor(lllllllllllllllIlIlIIIIIllIIllll.posZ);
            final int lllllllllllllllIlIlIIIIIllIllIIl = 1;
            final int lllllllllllllllIlIlIIIIIllIllIII = 0;
            for (int lllllllllllllllIlIlIIIIIllIlIlll = -2; lllllllllllllllIlIlIIIIIllIlIlll <= 2; ++lllllllllllllllIlIlIIIIIllIlIlll) {
                for (int lllllllllllllllIlIlIIIIIllIlIllI = -2; lllllllllllllllIlIlIIIIIllIlIllI <= 2; ++lllllllllllllllIlIlIIIIIllIlIllI) {
                    for (int lllllllllllllllIlIlIIIIIllIlIlIl = -1; lllllllllllllllIlIlIIIIIllIlIlIl < 3; ++lllllllllllllllIlIlIIIIIllIlIlIl) {
                        final int lllllllllllllllIlIlIIIIIllIlIlII = lllllllllllllllIlIlIIIIIllIlllII + lllllllllllllllIlIlIIIIIllIlIllI * 1 + lllllllllllllllIlIlIIIIIllIlIlll * 0;
                        final int lllllllllllllllIlIlIIIIIllIlIIll = lllllllllllllllIlIlIIIIIllIllIll + lllllllllllllllIlIlIIIIIllIlIlIl;
                        final int lllllllllllllllIlIlIIIIIllIlIIlI = lllllllllllllllIlIlIIIIIllIllIlI + lllllllllllllllIlIlIIIIIllIlIllI * 0 - lllllllllllllllIlIlIIIIIllIlIlll * 1;
                        final boolean lllllllllllllllIlIlIIIIIllIlIIIl = lllllllllllllllIlIlIIIIIllIlIlIl < 0;
                        this.worldServerInstance.setBlockState(new BlockPos(lllllllllllllllIlIlIIIIIllIlIlII, lllllllllllllllIlIlIIIIIllIlIIll, lllllllllllllllIlIlIIIIIllIlIIlI), lllllllllllllllIlIlIIIIIllIlIIIl ? Blocks.OBSIDIAN.getDefaultState() : Blocks.AIR.getDefaultState());
                    }
                }
            }
            lllllllllllllllIlIlIIIIIllIIllll.setLocationAndAngles(lllllllllllllllIlIlIIIIIllIlllII, lllllllllllllllIlIlIIIIIllIllIll, lllllllllllllllIlIlIIIIIllIllIlI, lllllllllllllllIlIlIIIIIllIIllll.rotationYaw, 0.0f);
            lllllllllllllllIlIlIIIIIllIIllll.motionX = 0.0;
            lllllllllllllllIlIlIIIIIllIIllll.motionY = 0.0;
            lllllllllllllllIlIlIIIIIllIIllll.motionZ = 0.0;
        }
    }
    
    public boolean placeInExistingPortal(final Entity lllllllllllllllIlIlIIIIIlIIIlIll, final float lllllllllllllllIlIlIIIIIlIIIlIlI) {
        final int lllllllllllllllIlIlIIIIIlIlIIllI = 128;
        double lllllllllllllllIlIlIIIIIlIlIIlIl = -1.0;
        final int lllllllllllllllIlIlIIIIIlIlIIlII = MathHelper.floor(lllllllllllllllIlIlIIIIIlIIIlIll.posX);
        final int lllllllllllllllIlIlIIIIIlIlIIIll = MathHelper.floor(lllllllllllllllIlIlIIIIIlIIIlIll.posZ);
        boolean lllllllllllllllIlIlIIIIIlIlIIIlI = true;
        BlockPos lllllllllllllllIlIlIIIIIlIlIIIIl = BlockPos.ORIGIN;
        final long lllllllllllllllIlIlIIIIIlIlIIIII = ChunkPos.asLong(lllllllllllllllIlIlIIIIIlIlIIlII, lllllllllllllllIlIlIIIIIlIlIIIll);
        if (this.destinationCoordinateCache.containsKey(lllllllllllllllIlIlIIIIIlIlIIIII)) {
            final PortalPosition lllllllllllllllIlIlIIIIIlIIlllll = (PortalPosition)this.destinationCoordinateCache.get(lllllllllllllllIlIlIIIIIlIlIIIII);
            lllllllllllllllIlIlIIIIIlIlIIlIl = 0.0;
            lllllllllllllllIlIlIIIIIlIlIIIIl = lllllllllllllllIlIlIIIIIlIIlllll;
            lllllllllllllllIlIlIIIIIlIIlllll.lastUpdateTime = this.worldServerInstance.getTotalWorldTime();
            lllllllllllllllIlIlIIIIIlIlIIIlI = false;
        }
        else {
            final BlockPos lllllllllllllllIlIlIIIIIlIIllllI = new BlockPos(lllllllllllllllIlIlIIIIIlIIIlIll);
            for (int lllllllllllllllIlIlIIIIIlIIlllIl = -128; lllllllllllllllIlIlIIIIIlIIlllIl <= 128; ++lllllllllllllllIlIlIIIIIlIIlllIl) {
                for (int lllllllllllllllIlIlIIIIIlIIllIll = -128; lllllllllllllllIlIlIIIIIlIIllIll <= 128; ++lllllllllllllllIlIlIIIIIlIIllIll) {
                    BlockPos lllllllllllllllIlIlIIIIIlIIlllII;
                    for (BlockPos lllllllllllllllIlIlIIIIIlIIllIlI = lllllllllllllllIlIlIIIIIlIIllllI.add(lllllllllllllllIlIlIIIIIlIIlllIl, this.worldServerInstance.getActualHeight() - 1 - lllllllllllllllIlIlIIIIIlIIllllI.getY(), lllllllllllllllIlIlIIIIIlIIllIll); lllllllllllllllIlIlIIIIIlIIllIlI.getY() >= 0; lllllllllllllllIlIlIIIIIlIIllIlI = lllllllllllllllIlIlIIIIIlIIlllII) {
                        lllllllllllllllIlIlIIIIIlIIlllII = lllllllllllllllIlIlIIIIIlIIllIlI.down();
                        if (this.worldServerInstance.getBlockState(lllllllllllllllIlIlIIIIIlIIllIlI).getBlock() == Blocks.PORTAL) {
                            for (lllllllllllllllIlIlIIIIIlIIlllII = lllllllllllllllIlIlIIIIIlIIllIlI.down(); this.worldServerInstance.getBlockState(lllllllllllllllIlIlIIIIIlIIlllII).getBlock() == Blocks.PORTAL; lllllllllllllllIlIlIIIIIlIIlllII = lllllllllllllllIlIlIIIIIlIIlllII.down()) {
                                lllllllllllllllIlIlIIIIIlIIllIlI = lllllllllllllllIlIlIIIIIlIIlllII;
                            }
                            final double lllllllllllllllIlIlIIIIIlIIllIIl = lllllllllllllllIlIlIIIIIlIIllIlI.distanceSq(lllllllllllllllIlIlIIIIIlIIllllI);
                            if (lllllllllllllllIlIlIIIIIlIlIIlIl < 0.0 || lllllllllllllllIlIlIIIIIlIIllIIl < lllllllllllllllIlIlIIIIIlIlIIlIl) {
                                lllllllllllllllIlIlIIIIIlIlIIlIl = lllllllllllllllIlIlIIIIIlIIllIIl;
                                lllllllllllllllIlIlIIIIIlIlIIIIl = lllllllllllllllIlIlIIIIIlIIllIlI;
                            }
                        }
                    }
                }
            }
        }
        if (lllllllllllllllIlIlIIIIIlIlIIlIl >= 0.0) {
            if (lllllllllllllllIlIlIIIIIlIlIIIlI) {
                this.destinationCoordinateCache.put(lllllllllllllllIlIlIIIIIlIlIIIII, (Object)new PortalPosition(lllllllllllllllIlIlIIIIIlIlIIIIl, this.worldServerInstance.getTotalWorldTime()));
            }
            double lllllllllllllllIlIlIIIIIlIIllIII = lllllllllllllllIlIlIIIIIlIlIIIIl.getX() + 0.5;
            double lllllllllllllllIlIlIIIIIlIIlIlll = lllllllllllllllIlIlIIIIIlIlIIIIl.getZ() + 0.5;
            final BlockPattern.PatternHelper lllllllllllllllIlIlIIIIIlIIlIllI = Blocks.PORTAL.createPatternHelper(this.worldServerInstance, lllllllllllllllIlIlIIIIIlIlIIIIl);
            final boolean lllllllllllllllIlIlIIIIIlIIlIlIl = lllllllllllllllIlIlIIIIIlIIlIllI.getForwards().rotateY().getAxisDirection() == EnumFacing.AxisDirection.NEGATIVE;
            double lllllllllllllllIlIlIIIIIlIIlIlII = (lllllllllllllllIlIlIIIIIlIIlIllI.getForwards().getAxis() == EnumFacing.Axis.X) ? lllllllllllllllIlIlIIIIIlIIlIllI.getFrontTopLeft().getZ() : ((double)lllllllllllllllIlIlIIIIIlIIlIllI.getFrontTopLeft().getX());
            final double lllllllllllllllIlIlIIIIIlIIlIIll = lllllllllllllllIlIlIIIIIlIIlIllI.getFrontTopLeft().getY() + 1 - lllllllllllllllIlIlIIIIIlIIIlIll.getLastPortalVec().yCoord * lllllllllllllllIlIlIIIIIlIIlIllI.getHeight();
            if (lllllllllllllllIlIlIIIIIlIIlIlIl) {
                ++lllllllllllllllIlIlIIIIIlIIlIlII;
            }
            if (lllllllllllllllIlIlIIIIIlIIlIllI.getForwards().getAxis() == EnumFacing.Axis.X) {
                lllllllllllllllIlIlIIIIIlIIlIlll = lllllllllllllllIlIlIIIIIlIIlIlII + (1.0 - lllllllllllllllIlIlIIIIIlIIIlIll.getLastPortalVec().xCoord) * lllllllllllllllIlIlIIIIIlIIlIllI.getWidth() * lllllllllllllllIlIlIIIIIlIIlIllI.getForwards().rotateY().getAxisDirection().getOffset();
            }
            else {
                lllllllllllllllIlIlIIIIIlIIllIII = lllllllllllllllIlIlIIIIIlIIlIlII + (1.0 - lllllllllllllllIlIlIIIIIlIIIlIll.getLastPortalVec().xCoord) * lllllllllllllllIlIlIIIIIlIIlIllI.getWidth() * lllllllllllllllIlIlIIIIIlIIlIllI.getForwards().rotateY().getAxisDirection().getOffset();
            }
            float lllllllllllllllIlIlIIIIIlIIlIIlI = 0.0f;
            float lllllllllllllllIlIlIIIIIlIIlIIIl = 0.0f;
            float lllllllllllllllIlIlIIIIIlIIlIIII = 0.0f;
            float lllllllllllllllIlIlIIIIIlIIIllll = 0.0f;
            if (lllllllllllllllIlIlIIIIIlIIlIllI.getForwards().getOpposite() == lllllllllllllllIlIlIIIIIlIIIlIll.getTeleportDirection()) {
                lllllllllllllllIlIlIIIIIlIIlIIlI = 1.0f;
                lllllllllllllllIlIlIIIIIlIIlIIIl = 1.0f;
            }
            else if (lllllllllllllllIlIlIIIIIlIIlIllI.getForwards().getOpposite() == lllllllllllllllIlIlIIIIIlIIIlIll.getTeleportDirection().getOpposite()) {
                lllllllllllllllIlIlIIIIIlIIlIIlI = -1.0f;
                lllllllllllllllIlIlIIIIIlIIlIIIl = -1.0f;
            }
            else if (lllllllllllllllIlIlIIIIIlIIlIllI.getForwards().getOpposite() == lllllllllllllllIlIlIIIIIlIIIlIll.getTeleportDirection().rotateY()) {
                lllllllllllllllIlIlIIIIIlIIlIIII = 1.0f;
                lllllllllllllllIlIlIIIIIlIIIllll = -1.0f;
            }
            else {
                lllllllllllllllIlIlIIIIIlIIlIIII = -1.0f;
                lllllllllllllllIlIlIIIIIlIIIllll = 1.0f;
            }
            final double lllllllllllllllIlIlIIIIIlIIIlllI = lllllllllllllllIlIlIIIIIlIIIlIll.motionX;
            final double lllllllllllllllIlIlIIIIIlIIIllIl = lllllllllllllllIlIlIIIIIlIIIlIll.motionZ;
            lllllllllllllllIlIlIIIIIlIIIlIll.motionX = lllllllllllllllIlIlIIIIIlIIIlllI * lllllllllllllllIlIlIIIIIlIIlIIlI + lllllllllllllllIlIlIIIIIlIIIllIl * lllllllllllllllIlIlIIIIIlIIIllll;
            lllllllllllllllIlIlIIIIIlIIIlIll.motionZ = lllllllllllllllIlIlIIIIIlIIIlllI * lllllllllllllllIlIlIIIIIlIIlIIII + lllllllllllllllIlIlIIIIIlIIIllIl * lllllllllllllllIlIlIIIIIlIIlIIIl;
            lllllllllllllllIlIlIIIIIlIIIlIll.rotationYaw = lllllllllllllllIlIlIIIIIlIIIlIlI - lllllllllllllllIlIlIIIIIlIIIlIll.getTeleportDirection().getOpposite().getHorizontalIndex() * 90 + lllllllllllllllIlIlIIIIIlIIlIllI.getForwards().getHorizontalIndex() * 90;
            if (lllllllllllllllIlIlIIIIIlIIIlIll instanceof EntityPlayerMP) {
                ((EntityPlayerMP)lllllllllllllllIlIlIIIIIlIIIlIll).connection.setPlayerLocation(lllllllllllllllIlIlIIIIIlIIllIII, lllllllllllllllIlIlIIIIIlIIlIIll, lllllllllllllllIlIlIIIIIlIIlIlll, lllllllllllllllIlIlIIIIIlIIIlIll.rotationYaw, lllllllllllllllIlIlIIIIIlIIIlIll.rotationPitch);
            }
            else {
                lllllllllllllllIlIlIIIIIlIIIlIll.setLocationAndAngles(lllllllllllllllIlIlIIIIIlIIllIII, lllllllllllllllIlIlIIIIIlIIlIIll, lllllllllllllllIlIlIIIIIlIIlIlll, lllllllllllllllIlIlIIIIIlIIIlIll.rotationYaw, lllllllllllllllIlIlIIIIIlIIIlIll.rotationPitch);
            }
            return true;
        }
        return false;
    }
    
    public void removeStalePortalLocations(final long lllllllllllllllIlIIllllllllIlllI) {
        if (lllllllllllllllIlIIllllllllIlllI % 100L == 0L) {
            final long lllllllllllllllIlIIllllllllIllIl = lllllllllllllllIlIIllllllllIlllI - 300L;
            final ObjectIterator<PortalPosition> lllllllllllllllIlIIllllllllIllII = (ObjectIterator<PortalPosition>)this.destinationCoordinateCache.values().iterator();
            while (lllllllllllllllIlIIllllllllIllII.hasNext()) {
                final PortalPosition lllllllllllllllIlIIllllllllIlIll = (PortalPosition)lllllllllllllllIlIIllllllllIllII.next();
                if (lllllllllllllllIlIIllllllllIlIll == null || lllllllllllllllIlIIllllllllIlIll.lastUpdateTime < lllllllllllllllIlIIllllllllIllIl) {
                    lllllllllllllllIlIIllllllllIllII.remove();
                }
            }
        }
    }
    
    public boolean makePortal(final Entity lllllllllllllllIlIlIIIIIIlIlIllI) {
        final int lllllllllllllllIlIlIIIIIIlIlIlIl = 16;
        double lllllllllllllllIlIlIIIIIIlIlIlII = -1.0;
        final int lllllllllllllllIlIlIIIIIIlIlIIll = MathHelper.floor(lllllllllllllllIlIlIIIIIIlIlIllI.posX);
        final int lllllllllllllllIlIlIIIIIIlIlIIlI = MathHelper.floor(lllllllllllllllIlIlIIIIIIlIlIllI.posY);
        final int lllllllllllllllIlIlIIIIIIlIlIIIl = MathHelper.floor(lllllllllllllllIlIlIIIIIIlIlIllI.posZ);
        int lllllllllllllllIlIlIIIIIIlIlIIII = lllllllllllllllIlIlIIIIIIlIlIIll;
        int lllllllllllllllIlIlIIIIIIlIIllll = lllllllllllllllIlIlIIIIIIlIlIIlI;
        int lllllllllllllllIlIlIIIIIIlIIlllI = lllllllllllllllIlIlIIIIIIlIlIIIl;
        int lllllllllllllllIlIlIIIIIIlIIllIl = 0;
        final int lllllllllllllllIlIlIIIIIIlIIllII = this.random.nextInt(4);
        final BlockPos.MutableBlockPos lllllllllllllllIlIlIIIIIIlIIlIll = new BlockPos.MutableBlockPos();
        for (int lllllllllllllllIlIlIIIIIIlIIlIlI = lllllllllllllllIlIlIIIIIIlIlIIll - 16; lllllllllllllllIlIlIIIIIIlIIlIlI <= lllllllllllllllIlIlIIIIIIlIlIIll + 16; ++lllllllllllllllIlIlIIIIIIlIIlIlI) {
            final double lllllllllllllllIlIlIIIIIIlIIlIIl = lllllllllllllllIlIlIIIIIIlIIlIlI + 0.5 - lllllllllllllllIlIlIIIIIIlIlIllI.posX;
            for (int lllllllllllllllIlIlIIIIIIlIIlIII = lllllllllllllllIlIlIIIIIIlIlIIIl - 16; lllllllllllllllIlIlIIIIIIlIIlIII <= lllllllllllllllIlIlIIIIIIlIlIIIl + 16; ++lllllllllllllllIlIlIIIIIIlIIlIII) {
                final double lllllllllllllllIlIlIIIIIIlIIIlll = lllllllllllllllIlIlIIIIIIlIIlIII + 0.5 - lllllllllllllllIlIlIIIIIIlIlIllI.posZ;
            Label_0446:
                for (int lllllllllllllllIlIlIIIIIIlIIIllI = this.worldServerInstance.getActualHeight() - 1; lllllllllllllllIlIlIIIIIIlIIIllI >= 0; --lllllllllllllllIlIlIIIIIIlIIIllI) {
                    if (this.worldServerInstance.isAirBlock(lllllllllllllllIlIlIIIIIIlIIlIll.setPos(lllllllllllllllIlIlIIIIIIlIIlIlI, lllllllllllllllIlIlIIIIIIlIIIllI, lllllllllllllllIlIlIIIIIIlIIlIII))) {
                        while (lllllllllllllllIlIlIIIIIIlIIIllI > 0 && this.worldServerInstance.isAirBlock(lllllllllllllllIlIlIIIIIIlIIlIll.setPos(lllllllllllllllIlIlIIIIIIlIIlIlI, lllllllllllllllIlIlIIIIIIlIIIllI - 1, lllllllllllllllIlIlIIIIIIlIIlIII))) {
                            --lllllllllllllllIlIlIIIIIIlIIIllI;
                        }
                        for (int lllllllllllllllIlIlIIIIIIlIIIlIl = lllllllllllllllIlIlIIIIIIlIIllII; lllllllllllllllIlIlIIIIIIlIIIlIl < lllllllllllllllIlIlIIIIIIlIIllII + 4; ++lllllllllllllllIlIlIIIIIIlIIIlIl) {
                            int lllllllllllllllIlIlIIIIIIlIIIlII = lllllllllllllllIlIlIIIIIIlIIIlIl % 2;
                            int lllllllllllllllIlIlIIIIIIlIIIIll = 1 - lllllllllllllllIlIlIIIIIIlIIIlII;
                            if (lllllllllllllllIlIlIIIIIIlIIIlIl % 4 >= 2) {
                                lllllllllllllllIlIlIIIIIIlIIIlII = -lllllllllllllllIlIlIIIIIIlIIIlII;
                                lllllllllllllllIlIlIIIIIIlIIIIll = -lllllllllllllllIlIlIIIIIIlIIIIll;
                            }
                            for (int lllllllllllllllIlIlIIIIIIlIIIIlI = 0; lllllllllllllllIlIlIIIIIIlIIIIlI < 3; ++lllllllllllllllIlIlIIIIIIlIIIIlI) {
                                for (int lllllllllllllllIlIlIIIIIIlIIIIIl = 0; lllllllllllllllIlIlIIIIIIlIIIIIl < 4; ++lllllllllllllllIlIlIIIIIIlIIIIIl) {
                                    for (int lllllllllllllllIlIlIIIIIIlIIIIII = -1; lllllllllllllllIlIlIIIIIIlIIIIII < 4; ++lllllllllllllllIlIlIIIIIIlIIIIII) {
                                        final int lllllllllllllllIlIlIIIIIIIllllll = lllllllllllllllIlIlIIIIIIlIIlIlI + (lllllllllllllllIlIlIIIIIIlIIIIIl - 1) * lllllllllllllllIlIlIIIIIIlIIIlII + lllllllllllllllIlIlIIIIIIlIIIIlI * lllllllllllllllIlIlIIIIIIlIIIIll;
                                        final int lllllllllllllllIlIlIIIIIIIlllllI = lllllllllllllllIlIlIIIIIIlIIIllI + lllllllllllllllIlIlIIIIIIlIIIIII;
                                        final int lllllllllllllllIlIlIIIIIIIllllIl = lllllllllllllllIlIlIIIIIIlIIlIII + (lllllllllllllllIlIlIIIIIIlIIIIIl - 1) * lllllllllllllllIlIlIIIIIIlIIIIll - lllllllllllllllIlIlIIIIIIlIIIIlI * lllllllllllllllIlIlIIIIIIlIIIlII;
                                        lllllllllllllllIlIlIIIIIIlIIlIll.setPos(lllllllllllllllIlIlIIIIIIIllllll, lllllllllllllllIlIlIIIIIIIlllllI, lllllllllllllllIlIlIIIIIIIllllIl);
                                        if (lllllllllllllllIlIlIIIIIIlIIIIII < 0 && !this.worldServerInstance.getBlockState(lllllllllllllllIlIlIIIIIIlIIlIll).getMaterial().isSolid()) {
                                            continue Label_0446;
                                        }
                                        if (lllllllllllllllIlIlIIIIIIlIIIIII >= 0 && !this.worldServerInstance.isAirBlock(lllllllllllllllIlIlIIIIIIlIIlIll)) {
                                            continue Label_0446;
                                        }
                                    }
                                }
                            }
                            final double lllllllllllllllIlIlIIIIIIIllllII = lllllllllllllllIlIlIIIIIIlIIIllI + 0.5 - lllllllllllllllIlIlIIIIIIlIlIllI.posY;
                            final double lllllllllllllllIlIlIIIIIIIlllIll = lllllllllllllllIlIlIIIIIIlIIlIIl * lllllllllllllllIlIlIIIIIIlIIlIIl + lllllllllllllllIlIlIIIIIIIllllII * lllllllllllllllIlIlIIIIIIIllllII + lllllllllllllllIlIlIIIIIIlIIIlll * lllllllllllllllIlIlIIIIIIlIIIlll;
                            if (lllllllllllllllIlIlIIIIIIlIlIlII < 0.0 || lllllllllllllllIlIlIIIIIIIlllIll < lllllllllllllllIlIlIIIIIIlIlIlII) {
                                lllllllllllllllIlIlIIIIIIlIlIlII = lllllllllllllllIlIlIIIIIIIlllIll;
                                lllllllllllllllIlIlIIIIIIlIlIIII = lllllllllllllllIlIlIIIIIIlIIlIlI;
                                lllllllllllllllIlIlIIIIIIlIIllll = lllllllllllllllIlIlIIIIIIlIIIllI;
                                lllllllllllllllIlIlIIIIIIlIIlllI = lllllllllllllllIlIlIIIIIIlIIlIII;
                                lllllllllllllllIlIlIIIIIIlIIllIl = lllllllllllllllIlIlIIIIIIlIIIlIl % 4;
                            }
                        }
                    }
                }
            }
        }
        if (lllllllllllllllIlIlIIIIIIlIlIlII < 0.0) {
            for (int lllllllllllllllIlIlIIIIIIIlllIlI = lllllllllllllllIlIlIIIIIIlIlIIll - 16; lllllllllllllllIlIlIIIIIIIlllIlI <= lllllllllllllllIlIlIIIIIIlIlIIll + 16; ++lllllllllllllllIlIlIIIIIIIlllIlI) {
                final double lllllllllllllllIlIlIIIIIIIlllIIl = lllllllllllllllIlIlIIIIIIIlllIlI + 0.5 - lllllllllllllllIlIlIIIIIIlIlIllI.posX;
                for (int lllllllllllllllIlIlIIIIIIIlllIII = lllllllllllllllIlIlIIIIIIlIlIIIl - 16; lllllllllllllllIlIlIIIIIIIlllIII <= lllllllllllllllIlIlIIIIIIlIlIIIl + 16; ++lllllllllllllllIlIlIIIIIIIlllIII) {
                    final double lllllllllllllllIlIlIIIIIIIllIlll = lllllllllllllllIlIlIIIIIIIlllIII + 0.5 - lllllllllllllllIlIlIIIIIIlIlIllI.posZ;
                Label_0819:
                    for (int lllllllllllllllIlIlIIIIIIIllIllI = this.worldServerInstance.getActualHeight() - 1; lllllllllllllllIlIlIIIIIIIllIllI >= 0; --lllllllllllllllIlIlIIIIIIIllIllI) {
                        if (this.worldServerInstance.isAirBlock(lllllllllllllllIlIlIIIIIIlIIlIll.setPos(lllllllllllllllIlIlIIIIIIIlllIlI, lllllllllllllllIlIlIIIIIIIllIllI, lllllllllllllllIlIlIIIIIIIlllIII))) {
                            while (lllllllllllllllIlIlIIIIIIIllIllI > 0 && this.worldServerInstance.isAirBlock(lllllllllllllllIlIlIIIIIIlIIlIll.setPos(lllllllllllllllIlIlIIIIIIIlllIlI, lllllllllllllllIlIlIIIIIIIllIllI - 1, lllllllllllllllIlIlIIIIIIIlllIII))) {
                                --lllllllllllllllIlIlIIIIIIIllIllI;
                            }
                            for (int lllllllllllllllIlIlIIIIIIIllIlIl = lllllllllllllllIlIlIIIIIIlIIllII; lllllllllllllllIlIlIIIIIIIllIlIl < lllllllllllllllIlIlIIIIIIlIIllII + 2; ++lllllllllllllllIlIlIIIIIIIllIlIl) {
                                final int lllllllllllllllIlIlIIIIIIIllIlII = lllllllllllllllIlIlIIIIIIIllIlIl % 2;
                                final int lllllllllllllllIlIlIIIIIIIllIIll = 1 - lllllllllllllllIlIlIIIIIIIllIlII;
                                for (int lllllllllllllllIlIlIIIIIIIllIIlI = 0; lllllllllllllllIlIlIIIIIIIllIIlI < 4; ++lllllllllllllllIlIlIIIIIIIllIIlI) {
                                    for (int lllllllllllllllIlIlIIIIIIIllIIIl = -1; lllllllllllllllIlIlIIIIIIIllIIIl < 4; ++lllllllllllllllIlIlIIIIIIIllIIIl) {
                                        final int lllllllllllllllIlIlIIIIIIIllIIII = lllllllllllllllIlIlIIIIIIIlllIlI + (lllllllllllllllIlIlIIIIIIIllIIlI - 1) * lllllllllllllllIlIlIIIIIIIllIlII;
                                        final int lllllllllllllllIlIlIIIIIIIlIllll = lllllllllllllllIlIlIIIIIIIllIllI + lllllllllllllllIlIlIIIIIIIllIIIl;
                                        final int lllllllllllllllIlIlIIIIIIIlIlllI = lllllllllllllllIlIlIIIIIIIlllIII + (lllllllllllllllIlIlIIIIIIIllIIlI - 1) * lllllllllllllllIlIlIIIIIIIllIIll;
                                        lllllllllllllllIlIlIIIIIIlIIlIll.setPos(lllllllllllllllIlIlIIIIIIIllIIII, lllllllllllllllIlIlIIIIIIIlIllll, lllllllllllllllIlIlIIIIIIIlIlllI);
                                        if (lllllllllllllllIlIlIIIIIIIllIIIl < 0 && !this.worldServerInstance.getBlockState(lllllllllllllllIlIlIIIIIIlIIlIll).getMaterial().isSolid()) {
                                            continue Label_0819;
                                        }
                                        if (lllllllllllllllIlIlIIIIIIIllIIIl >= 0 && !this.worldServerInstance.isAirBlock(lllllllllllllllIlIlIIIIIIlIIlIll)) {
                                            continue Label_0819;
                                        }
                                    }
                                }
                                final double lllllllllllllllIlIlIIIIIIIlIllIl = lllllllllllllllIlIlIIIIIIIllIllI + 0.5 - lllllllllllllllIlIlIIIIIIlIlIllI.posY;
                                final double lllllllllllllllIlIlIIIIIIIlIllII = lllllllllllllllIlIlIIIIIIIlllIIl * lllllllllllllllIlIlIIIIIIIlllIIl + lllllllllllllllIlIlIIIIIIIlIllIl * lllllllllllllllIlIlIIIIIIIlIllIl + lllllllllllllllIlIlIIIIIIIllIlll * lllllllllllllllIlIlIIIIIIIllIlll;
                                if (lllllllllllllllIlIlIIIIIIlIlIlII < 0.0 || lllllllllllllllIlIlIIIIIIIlIllII < lllllllllllllllIlIlIIIIIIlIlIlII) {
                                    lllllllllllllllIlIlIIIIIIlIlIlII = lllllllllllllllIlIlIIIIIIIlIllII;
                                    lllllllllllllllIlIlIIIIIIlIlIIII = lllllllllllllllIlIlIIIIIIIlllIlI;
                                    lllllllllllllllIlIlIIIIIIlIIllll = lllllllllllllllIlIlIIIIIIIllIllI;
                                    lllllllllllllllIlIlIIIIIIlIIlllI = lllllllllllllllIlIlIIIIIIIlllIII;
                                    lllllllllllllllIlIlIIIIIIlIIllIl = lllllllllllllllIlIlIIIIIIIllIlIl % 2;
                                }
                            }
                        }
                    }
                }
            }
        }
        final int lllllllllllllllIlIlIIIIIIIlIlIll = lllllllllllllllIlIlIIIIIIlIlIIII;
        int lllllllllllllllIlIlIIIIIIIlIlIlI = lllllllllllllllIlIlIIIIIIlIIllll;
        final int lllllllllllllllIlIlIIIIIIIlIlIIl = lllllllllllllllIlIlIIIIIIlIIlllI;
        int lllllllllllllllIlIlIIIIIIIlIlIII = lllllllllllllllIlIlIIIIIIlIIllIl % 2;
        int lllllllllllllllIlIlIIIIIIIlIIlll = 1 - lllllllllllllllIlIlIIIIIIIlIlIII;
        if (lllllllllllllllIlIlIIIIIIlIIllIl % 4 >= 2) {
            lllllllllllllllIlIlIIIIIIIlIlIII = -lllllllllllllllIlIlIIIIIIIlIlIII;
            lllllllllllllllIlIlIIIIIIIlIIlll = -lllllllllllllllIlIlIIIIIIIlIIlll;
        }
        if (lllllllllllllllIlIlIIIIIIlIlIlII < 0.0) {
            lllllllllllllllIlIlIIIIIIlIIllll = (lllllllllllllllIlIlIIIIIIIlIlIlI = MathHelper.clamp(lllllllllllllllIlIlIIIIIIlIIllll, 70, this.worldServerInstance.getActualHeight() - 10));
            for (int lllllllllllllllIlIlIIIIIIIlIIllI = -1; lllllllllllllllIlIlIIIIIIIlIIllI <= 1; ++lllllllllllllllIlIlIIIIIIIlIIllI) {
                for (int lllllllllllllllIlIlIIIIIIIlIIlIl = 1; lllllllllllllllIlIlIIIIIIIlIIlIl < 3; ++lllllllllllllllIlIlIIIIIIIlIIlIl) {
                    for (int lllllllllllllllIlIlIIIIIIIlIIlII = -1; lllllllllllllllIlIlIIIIIIIlIIlII < 3; ++lllllllllllllllIlIlIIIIIIIlIIlII) {
                        final int lllllllllllllllIlIlIIIIIIIlIIIll = lllllllllllllllIlIlIIIIIIIlIlIll + (lllllllllllllllIlIlIIIIIIIlIIlIl - 1) * lllllllllllllllIlIlIIIIIIIlIlIII + lllllllllllllllIlIlIIIIIIIlIIllI * lllllllllllllllIlIlIIIIIIIlIIlll;
                        final int lllllllllllllllIlIlIIIIIIIlIIIlI = lllllllllllllllIlIlIIIIIIIlIlIlI + lllllllllllllllIlIlIIIIIIIlIIlII;
                        final int lllllllllllllllIlIlIIIIIIIlIIIIl = lllllllllllllllIlIlIIIIIIIlIlIIl + (lllllllllllllllIlIlIIIIIIIlIIlIl - 1) * lllllllllllllllIlIlIIIIIIIlIIlll - lllllllllllllllIlIlIIIIIIIlIIllI * lllllllllllllllIlIlIIIIIIIlIlIII;
                        final boolean lllllllllllllllIlIlIIIIIIIlIIIII = lllllllllllllllIlIlIIIIIIIlIIlII < 0;
                        this.worldServerInstance.setBlockState(new BlockPos(lllllllllllllllIlIlIIIIIIIlIIIll, lllllllllllllllIlIlIIIIIIIlIIIlI, lllllllllllllllIlIlIIIIIIIlIIIIl), lllllllllllllllIlIlIIIIIIIlIIIII ? Blocks.OBSIDIAN.getDefaultState() : Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        final IBlockState lllllllllllllllIlIlIIIIIIIIlllll = Blocks.PORTAL.getDefaultState().withProperty(BlockPortal.AXIS, (lllllllllllllllIlIlIIIIIIIlIlIII == 0) ? EnumFacing.Axis.Z : EnumFacing.Axis.X);
        for (int lllllllllllllllIlIlIIIIIIIIllllI = 0; lllllllllllllllIlIlIIIIIIIIllllI < 4; ++lllllllllllllllIlIlIIIIIIIIllllI) {
            for (int lllllllllllllllIlIlIIIIIIIIlllIl = 0; lllllllllllllllIlIlIIIIIIIIlllIl < 4; ++lllllllllllllllIlIlIIIIIIIIlllIl) {
                for (int lllllllllllllllIlIlIIIIIIIIlllII = -1; lllllllllllllllIlIlIIIIIIIIlllII < 4; ++lllllllllllllllIlIlIIIIIIIIlllII) {
                    final int lllllllllllllllIlIlIIIIIIIIllIll = lllllllllllllllIlIlIIIIIIIlIlIll + (lllllllllllllllIlIlIIIIIIIIlllIl - 1) * lllllllllllllllIlIlIIIIIIIlIlIII;
                    final int lllllllllllllllIlIlIIIIIIIIllIlI = lllllllllllllllIlIlIIIIIIIlIlIlI + lllllllllllllllIlIlIIIIIIIIlllII;
                    final int lllllllllllllllIlIlIIIIIIIIllIIl = lllllllllllllllIlIlIIIIIIIlIlIIl + (lllllllllllllllIlIlIIIIIIIIlllIl - 1) * lllllllllllllllIlIlIIIIIIIlIIlll;
                    final boolean lllllllllllllllIlIlIIIIIIIIllIII = lllllllllllllllIlIlIIIIIIIIlllIl == 0 || lllllllllllllllIlIlIIIIIIIIlllIl == 3 || lllllllllllllllIlIlIIIIIIIIlllII == -1 || lllllllllllllllIlIlIIIIIIIIlllII == 3;
                    this.worldServerInstance.setBlockState(new BlockPos(lllllllllllllllIlIlIIIIIIIIllIll, lllllllllllllllIlIlIIIIIIIIllIlI, lllllllllllllllIlIlIIIIIIIIllIIl), lllllllllllllllIlIlIIIIIIIIllIII ? Blocks.OBSIDIAN.getDefaultState() : lllllllllllllllIlIlIIIIIIIIlllll, 2);
                }
            }
            for (int lllllllllllllllIlIlIIIIIIIIlIlll = 0; lllllllllllllllIlIlIIIIIIIIlIlll < 4; ++lllllllllllllllIlIlIIIIIIIIlIlll) {
                for (int lllllllllllllllIlIlIIIIIIIIlIllI = -1; lllllllllllllllIlIlIIIIIIIIlIllI < 4; ++lllllllllllllllIlIlIIIIIIIIlIllI) {
                    final int lllllllllllllllIlIlIIIIIIIIlIlIl = lllllllllllllllIlIlIIIIIIIlIlIll + (lllllllllllllllIlIlIIIIIIIIlIlll - 1) * lllllllllllllllIlIlIIIIIIIlIlIII;
                    final int lllllllllllllllIlIlIIIIIIIIlIlII = lllllllllllllllIlIlIIIIIIIlIlIlI + lllllllllllllllIlIlIIIIIIIIlIllI;
                    final int lllllllllllllllIlIlIIIIIIIIlIIll = lllllllllllllllIlIlIIIIIIIlIlIIl + (lllllllllllllllIlIlIIIIIIIIlIlll - 1) * lllllllllllllllIlIlIIIIIIIlIIlll;
                    final BlockPos lllllllllllllllIlIlIIIIIIIIlIIlI = new BlockPos(lllllllllllllllIlIlIIIIIIIIlIlIl, lllllllllllllllIlIlIIIIIIIIlIlII, lllllllllllllllIlIlIIIIIIIIlIIll);
                    this.worldServerInstance.notifyNeighborsOfStateChange(lllllllllllllllIlIlIIIIIIIIlIIlI, this.worldServerInstance.getBlockState(lllllllllllllllIlIlIIIIIIIIlIIlI).getBlock(), false);
                }
            }
        }
        return true;
    }
    
    public Teleporter(final WorldServer lllllllllllllllIlIlIIIIIllllIIIl) {
        this.destinationCoordinateCache = (Long2ObjectMap<PortalPosition>)new Long2ObjectOpenHashMap(4096);
        this.worldServerInstance = lllllllllllllllIlIlIIIIIllllIIIl;
        this.random = new Random(lllllllllllllllIlIlIIIIIllllIIIl.getSeed());
    }
    
    public class PortalPosition extends BlockPos
    {
        public /* synthetic */ long lastUpdateTime;
        
        public PortalPosition(final BlockPos llllllllllllllllIIIIIlIlllIIlIIl, final long llllllllllllllllIIIIIlIlllIIllII) {
            super(llllllllllllllllIIIIIlIlllIIlIIl.getX(), llllllllllllllllIIIIIlIlllIIlIIl.getY(), llllllllllllllllIIIIIlIlllIIlIIl.getZ());
            this.lastUpdateTime = llllllllllllllllIIIIIlIlllIIllII;
        }
    }
}
