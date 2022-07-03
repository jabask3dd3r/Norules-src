package net.minecraft.pathfinding;

import java.util.*;
import com.google.common.collect.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import javax.annotation.*;
import net.minecraft.util.*;

public class PathWorldListener implements IWorldEventListener
{
    private final /* synthetic */ List<PathNavigate> navigations;
    
    public PathWorldListener() {
        this.navigations = (List<PathNavigate>)Lists.newArrayList();
    }
    
    @Override
    public void playRecord(final SoundEvent llllllllllllllIlllIIIllIIllIllll, final BlockPos llllllllllllllIlllIIIllIIllIlllI) {
    }
    
    @Override
    public void notifyBlockUpdate(final World llllllllllllllIlllIIIllIllIIlllI, final BlockPos llllllllllllllIlllIIIllIllIIllIl, final IBlockState llllllllllllllIlllIIIllIllIIllII, final IBlockState llllllllllllllIlllIIIllIlIlllllI, final int llllllllllllllIlllIIIllIllIIlIlI) {
        if (this.didBlockChange(llllllllllllllIlllIIIllIllIIlllI, llllllllllllllIlllIIIllIllIIllIl, llllllllllllllIlllIIIllIllIIllII, llllllllllllllIlllIIIllIlIlllllI)) {
            for (int llllllllllllllIlllIIIllIllIIlIIl = 0, llllllllllllllIlllIIIllIllIIlIII = this.navigations.size(); llllllllllllllIlllIIIllIllIIlIIl < llllllllllllllIlllIIIllIllIIlIII; ++llllllllllllllIlllIIIllIllIIlIIl) {
                final PathNavigate llllllllllllllIlllIIIllIllIIIlll = this.navigations.get(llllllllllllllIlllIIIllIllIIlIIl);
                if (llllllllllllllIlllIIIllIllIIIlll != null && !llllllllllllllIlllIIIllIllIIIlll.canUpdatePathOnTimeout()) {
                    final Path llllllllllllllIlllIIIllIllIIIllI = llllllllllllllIlllIIIllIllIIIlll.getPath();
                    if (llllllllllllllIlllIIIllIllIIIllI != null && !llllllllllllllIlllIIIllIllIIIllI.isFinished() && llllllllllllllIlllIIIllIllIIIllI.getCurrentPathLength() != 0) {
                        final PathPoint llllllllllllllIlllIIIllIllIIIlIl = llllllllllllllIlllIIIllIllIIIlll.currentPath.getFinalPathPoint();
                        final double llllllllllllllIlllIIIllIllIIIlII = llllllllllllllIlllIIIllIllIIllIl.distanceSq((llllllllllllllIlllIIIllIllIIIlIl.xCoord + llllllllllllllIlllIIIllIllIIIlll.theEntity.posX) / 2.0, (llllllllllllllIlllIIIllIllIIIlIl.yCoord + llllllllllllllIlllIIIllIllIIIlll.theEntity.posY) / 2.0, (llllllllllllllIlllIIIllIllIIIlIl.zCoord + llllllllllllllIlllIIIllIllIIIlll.theEntity.posZ) / 2.0);
                        final int llllllllllllllIlllIIIllIllIIIIll = (llllllllllllllIlllIIIllIllIIIllI.getCurrentPathLength() - llllllllllllllIlllIIIllIllIIIllI.getCurrentPathIndex()) * (llllllllllllllIlllIIIllIllIIIllI.getCurrentPathLength() - llllllllllllllIlllIIIllIllIIIllI.getCurrentPathIndex());
                        if (llllllllllllllIlllIIIllIllIIIlII < llllllllllllllIlllIIIllIllIIIIll) {
                            llllllllllllllIlllIIIllIllIIIlll.updatePath();
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public void onEntityAdded(final Entity llllllllllllllIlllIIIllIIlllIlll) {
        if (llllllllllllllIlllIIIllIIlllIlll instanceof EntityLiving) {
            this.navigations.add(((EntityLiving)llllllllllllllIlllIIIllIIlllIlll).getNavigator());
        }
    }
    
    @Override
    public void spawnParticle(final int llllllllllllllIlllIIIllIlIIlIIII, final boolean llllllllllllllIlllIIIllIlIIIllll, final double llllllllllllllIlllIIIllIlIIIlllI, final double llllllllllllllIlllIIIllIlIIIllIl, final double llllllllllllllIlllIIIllIlIIIllII, final double llllllllllllllIlllIIIllIlIIIlIll, final double llllllllllllllIlllIIIllIlIIIlIlI, final double llllllllllllllIlllIIIllIlIIIlIIl, final int... llllllllllllllIlllIIIllIlIIIlIII) {
    }
    
    @Override
    public void onEntityRemoved(final Entity llllllllllllllIlllIIIllIIlllIIll) {
        if (llllllllllllllIlllIIIllIIlllIIll instanceof EntityLiving) {
            this.navigations.remove(((EntityLiving)llllllllllllllIlllIIIllIIlllIIll).getNavigator());
        }
    }
    
    @Override
    public void func_190570_a(final int llllllllllllllIlllIIIllIlIIIIllI, final boolean llllllllllllllIlllIIIllIlIIIIlIl, final boolean llllllllllllllIlllIIIllIlIIIIlII, final double llllllllllllllIlllIIIllIlIIIIIll, final double llllllllllllllIlllIIIllIlIIIIIlI, final double llllllllllllllIlllIIIllIlIIIIIIl, final double llllllllllllllIlllIIIllIlIIIIIII, final double llllllllllllllIlllIIIllIIlllllll, final double llllllllllllllIlllIIIllIIllllllI, final int... llllllllllllllIlllIIIllIIlllllIl) {
    }
    
    @Override
    public void broadcastSound(final int llllllllllllllIlllIIIllIIllIllII, final BlockPos llllllllllllllIlllIIIllIIllIlIll, final int llllllllllllllIlllIIIllIIllIlIlI) {
    }
    
    @Override
    public void markBlockRangeForRenderUpdate(final int llllllllllllllIlllIIIllIlIlIIIII, final int llllllllllllllIlllIIIllIlIIlllll, final int llllllllllllllIlllIIIllIlIIllllI, final int llllllllllllllIlllIIIllIlIIlllIl, final int llllllllllllllIlllIIIllIlIIlllII, final int llllllllllllllIlllIIIllIlIIllIll) {
    }
    
    @Override
    public void notifyLightSet(final BlockPos llllllllllllllIlllIIIllIlIlIIIlI) {
    }
    
    @Override
    public void sendBlockBreakProgress(final int llllllllllllllIlllIIIllIIllIIIll, final BlockPos llllllllllllllIlllIIIllIIllIIIlI, final int llllllllllllllIlllIIIllIIllIIIIl) {
    }
    
    protected boolean didBlockChange(final World llllllllllllllIlllIIIllIlIlIllll, final BlockPos llllllllllllllIlllIIIllIlIlIlllI, final IBlockState llllllllllllllIlllIIIllIlIlIIlll, final IBlockState llllllllllllllIlllIIIllIlIlIIllI) {
        final AxisAlignedBB llllllllllllllIlllIIIllIlIlIlIll = llllllllllllllIlllIIIllIlIlIIlll.getCollisionBoundingBox(llllllllllllllIlllIIIllIlIlIllll, llllllllllllllIlllIIIllIlIlIlllI);
        final AxisAlignedBB llllllllllllllIlllIIIllIlIlIlIlI = llllllllllllllIlllIIIllIlIlIIllI.getCollisionBoundingBox(llllllllllllllIlllIIIllIlIlIllll, llllllllllllllIlllIIIllIlIlIlllI);
        return llllllllllllllIlllIIIllIlIlIlIll != llllllllllllllIlllIIIllIlIlIlIlI && (llllllllllllllIlllIIIllIlIlIlIll == null || !llllllllllllllIlllIIIllIlIlIlIll.equals(llllllllllllllIlllIIIllIlIlIlIlI));
    }
    
    @Override
    public void playEvent(final EntityPlayer llllllllllllllIlllIIIllIIllIlIII, final int llllllllllllllIlllIIIllIIllIIlll, final BlockPos llllllllllllllIlllIIIllIIllIIllI, final int llllllllllllllIlllIIIllIIllIIlIl) {
    }
    
    @Override
    public void playSoundToAllNearExcept(@Nullable final EntityPlayer llllllllllllllIlllIIIllIlIIllIIl, final SoundEvent llllllllllllllIlllIIIllIlIIllIII, final SoundCategory llllllllllllllIlllIIIllIlIIlIlll, final double llllllllllllllIlllIIIllIlIIlIllI, final double llllllllllllllIlllIIIllIlIIlIlIl, final double llllllllllllllIlllIIIllIlIIlIlII, final float llllllllllllllIlllIIIllIlIIlIIll, final float llllllllllllllIlllIIIllIlIIlIIlI) {
    }
}
