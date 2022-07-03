package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;
import java.util.*;
import javax.annotation.*;
import net.minecraft.util.math.*;

public class WorldGenSpikes extends WorldGenerator
{
    private /* synthetic */ EndSpike spike;
    private /* synthetic */ boolean crystalInvulnerable;
    private /* synthetic */ BlockPos beamTarget;
    
    public void setCrystalInvulnerable(final boolean llllllllllllllllllIIIIIlIIIlllll) {
        this.crystalInvulnerable = llllllllllllllllllIIIIIlIIIlllll;
    }
    
    @Override
    public boolean generate(final World llllllllllllllllllIIIIIlIIIlIlII, final Random llllllllllllllllllIIIIIlIIIlIIll, final BlockPos llllllllllllllllllIIIIIlIIIIlIIl) {
        if (this.spike == null) {
            throw new IllegalStateException("Decoration requires priming with a spike");
        }
        final int llllllllllllllllllIIIIIlIIIlIIIl = this.spike.getRadius();
        for (final BlockPos.MutableBlockPos llllllllllllllllllIIIIIlIIIlIIII : BlockPos.getAllInBoxMutable(new BlockPos(llllllllllllllllllIIIIIlIIIIlIIl.getX() - llllllllllllllllllIIIIIlIIIlIIIl, 0, llllllllllllllllllIIIIIlIIIIlIIl.getZ() - llllllllllllllllllIIIIIlIIIlIIIl), new BlockPos(llllllllllllllllllIIIIIlIIIIlIIl.getX() + llllllllllllllllllIIIIIlIIIlIIIl, this.spike.getHeight() + 10, llllllllllllllllllIIIIIlIIIIlIIl.getZ() + llllllllllllllllllIIIIIlIIIlIIIl))) {
            if (llllllllllllllllllIIIIIlIIIlIIII.distanceSq(llllllllllllllllllIIIIIlIIIIlIIl.getX(), llllllllllllllllllIIIIIlIIIlIIII.getY(), llllllllllllllllllIIIIIlIIIIlIIl.getZ()) <= llllllllllllllllllIIIIIlIIIlIIIl * llllllllllllllllllIIIIIlIIIlIIIl + 1 && llllllllllllllllllIIIIIlIIIlIIII.getY() < this.spike.getHeight()) {
                this.setBlockAndNotifyAdequately(llllllllllllllllllIIIIIlIIIlIlII, llllllllllllllllllIIIIIlIIIlIIII, Blocks.OBSIDIAN.getDefaultState());
            }
            else {
                if (llllllllllllllllllIIIIIlIIIlIIII.getY() <= 65) {
                    continue;
                }
                this.setBlockAndNotifyAdequately(llllllllllllllllllIIIIIlIIIlIlII, llllllllllllllllllIIIIIlIIIlIIII, Blocks.AIR.getDefaultState());
            }
        }
        if (this.spike.isGuarded()) {
            for (int llllllllllllllllllIIIIIlIIIIllll = -2; llllllllllllllllllIIIIIlIIIIllll <= 2; ++llllllllllllllllllIIIIIlIIIIllll) {
                for (int llllllllllllllllllIIIIIlIIIIlllI = -2; llllllllllllllllllIIIIIlIIIIlllI <= 2; ++llllllllllllllllllIIIIIlIIIIlllI) {
                    if (MathHelper.abs(llllllllllllllllllIIIIIlIIIIllll) == 2 || MathHelper.abs(llllllllllllllllllIIIIIlIIIIlllI) == 2) {
                        this.setBlockAndNotifyAdequately(llllllllllllllllllIIIIIlIIIlIlII, new BlockPos(llllllllllllllllllIIIIIlIIIIlIIl.getX() + llllllllllllllllllIIIIIlIIIIllll, this.spike.getHeight(), llllllllllllllllllIIIIIlIIIIlIIl.getZ() + llllllllllllllllllIIIIIlIIIIlllI), Blocks.IRON_BARS.getDefaultState());
                        this.setBlockAndNotifyAdequately(llllllllllllllllllIIIIIlIIIlIlII, new BlockPos(llllllllllllllllllIIIIIlIIIIlIIl.getX() + llllllllllllllllllIIIIIlIIIIllll, this.spike.getHeight() + 1, llllllllllllllllllIIIIIlIIIIlIIl.getZ() + llllllllllllllllllIIIIIlIIIIlllI), Blocks.IRON_BARS.getDefaultState());
                        this.setBlockAndNotifyAdequately(llllllllllllllllllIIIIIlIIIlIlII, new BlockPos(llllllllllllllllllIIIIIlIIIIlIIl.getX() + llllllllllllllllllIIIIIlIIIIllll, this.spike.getHeight() + 2, llllllllllllllllllIIIIIlIIIIlIIl.getZ() + llllllllllllllllllIIIIIlIIIIlllI), Blocks.IRON_BARS.getDefaultState());
                    }
                    this.setBlockAndNotifyAdequately(llllllllllllllllllIIIIIlIIIlIlII, new BlockPos(llllllllllllllllllIIIIIlIIIIlIIl.getX() + llllllllllllllllllIIIIIlIIIIllll, this.spike.getHeight() + 3, llllllllllllllllllIIIIIlIIIIlIIl.getZ() + llllllllllllllllllIIIIIlIIIIlllI), Blocks.IRON_BARS.getDefaultState());
                }
            }
        }
        final EntityEnderCrystal llllllllllllllllllIIIIIlIIIIllIl = new EntityEnderCrystal(llllllllllllllllllIIIIIlIIIlIlII);
        llllllllllllllllllIIIIIlIIIIllIl.setBeamTarget(this.beamTarget);
        llllllllllllllllllIIIIIlIIIIllIl.setEntityInvulnerable(this.crystalInvulnerable);
        llllllllllllllllllIIIIIlIIIIllIl.setLocationAndAngles(llllllllllllllllllIIIIIlIIIIlIIl.getX() + 0.5f, this.spike.getHeight() + 1, llllllllllllllllllIIIIIlIIIIlIIl.getZ() + 0.5f, llllllllllllllllllIIIIIlIIIlIIll.nextFloat() * 360.0f, 0.0f);
        llllllllllllllllllIIIIIlIIIlIlII.spawnEntityInWorld(llllllllllllllllllIIIIIlIIIIllIl);
        this.setBlockAndNotifyAdequately(llllllllllllllllllIIIIIlIIIlIlII, new BlockPos(llllllllllllllllllIIIIIlIIIIlIIl.getX(), this.spike.getHeight(), llllllllllllllllllIIIIIlIIIIlIIl.getZ()), Blocks.BEDROCK.getDefaultState());
        return true;
    }
    
    public void setSpike(final EndSpike llllllllllllllllllIIIIIlIIlIIIll) {
        this.spike = llllllllllllllllllIIIIIlIIlIIIll;
    }
    
    public void setBeamTarget(@Nullable final BlockPos llllllllllllllllllIIIIIlIIIIIIII) {
        this.beamTarget = llllllllllllllllllIIIIIlIIIIIIII;
    }
    
    public static class EndSpike
    {
        private final /* synthetic */ int centerZ;
        private final /* synthetic */ boolean guarded;
        private final /* synthetic */ int centerX;
        private final /* synthetic */ int radius;
        private final /* synthetic */ AxisAlignedBB topBoundingBox;
        private final /* synthetic */ int height;
        
        public int getCenterZ() {
            return this.centerZ;
        }
        
        public int getHeight() {
            return this.height;
        }
        
        public boolean isGuarded() {
            return this.guarded;
        }
        
        public boolean doesStartInChunk(final BlockPos lllllllllllllIlIlIlllIIIllIIIIll) {
            final int lllllllllllllIlIlIlllIIIllIIIIlI = this.centerX - this.radius;
            final int lllllllllllllIlIlIlllIIIllIIIIIl = this.centerZ - this.radius;
            return lllllllllllllIlIlIlllIIIllIIIIll.getX() == (lllllllllllllIlIlIlllIIIllIIIIlI & 0xFFFFFFF0) && lllllllllllllIlIlIlllIIIllIIIIll.getZ() == (lllllllllllllIlIlIlllIIIllIIIIIl & 0xFFFFFFF0);
        }
        
        public EndSpike(final int lllllllllllllIlIlIlllIIIllIlIIll, final int lllllllllllllIlIlIlllIIIllIlIIlI, final int lllllllllllllIlIlIlllIIIllIIlIll, final int lllllllllllllIlIlIlllIIIllIlIIII, final boolean lllllllllllllIlIlIlllIIIllIIlIIl) {
            this.centerX = lllllllllllllIlIlIlllIIIllIlIIll;
            this.centerZ = lllllllllllllIlIlIlllIIIllIlIIlI;
            this.radius = lllllllllllllIlIlIlllIIIllIIlIll;
            this.height = lllllllllllllIlIlIlllIIIllIlIIII;
            this.guarded = lllllllllllllIlIlIlllIIIllIIlIIl;
            this.topBoundingBox = new AxisAlignedBB(lllllllllllllIlIlIlllIIIllIlIIll - lllllllllllllIlIlIlllIIIllIIlIll, 0.0, lllllllllllllIlIlIlllIIIllIlIIlI - lllllllllllllIlIlIlllIIIllIIlIll, lllllllllllllIlIlIlllIIIllIlIIll + lllllllllllllIlIlIlllIIIllIIlIll, 256.0, lllllllllllllIlIlIlllIIIllIlIIlI + lllllllllllllIlIlIlllIIIllIIlIll);
        }
        
        public int getRadius() {
            return this.radius;
        }
        
        public AxisAlignedBB getTopBoundingBox() {
            return this.topBoundingBox;
        }
        
        public int getCenterX() {
            return this.centerX;
        }
    }
}
