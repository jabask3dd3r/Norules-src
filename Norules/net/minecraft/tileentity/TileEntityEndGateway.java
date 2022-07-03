package net.minecraft.tileentity;

import net.minecraft.util.*;
import net.minecraft.world.chunk.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import javax.annotation.*;
import org.apache.logging.log4j.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.network.play.server.*;
import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.world.gen.feature.*;

public class TileEntityEndGateway extends TileEntityEndPortal implements ITickable
{
    private /* synthetic */ BlockPos exitPortal;
    private /* synthetic */ int teleportCooldown;
    private /* synthetic */ boolean exactTeleport;
    private static final /* synthetic */ Logger LOG;
    private /* synthetic */ long age;
    
    private BlockPos findExitPosition() {
        final BlockPos lllllllllllllllIIIIIllIIIlIIlIlI = findHighestBlock(this.world, this.exitPortal, 5, false);
        TileEntityEndGateway.LOG.debug("Best exit position for portal at {} is {}", (Object)this.exitPortal, (Object)lllllllllllllllIIIIIllIIIlIIlIlI);
        return lllllllllllllllIIIIIllIIIlIIlIlI.up();
    }
    
    @Override
    public boolean shouldRenderFace(final EnumFacing lllllllllllllllIIIIIlIlllIlIIllI) {
        return this.getBlockType().getDefaultState().shouldSideBeRendered(this.world, this.getPos(), lllllllllllllllIIIIIlIlllIlIIllI);
    }
    
    @Nullable
    private static BlockPos findSpawnpointInChunk(final Chunk lllllllllllllllIIIIIlIllllIllIII) {
        final BlockPos lllllllllllllllIIIIIlIlllllIIlII = new BlockPos(lllllllllllllllIIIIIlIllllIllIII.xPosition * 16, 30, lllllllllllllllIIIIIlIllllIllIII.zPosition * 16);
        final int lllllllllllllllIIIIIlIlllllIIIll = lllllllllllllllIIIIIlIllllIllIII.getTopFilledSegment() + 16 - 1;
        final BlockPos lllllllllllllllIIIIIlIlllllIIIIl = new BlockPos(lllllllllllllllIIIIIlIllllIllIII.xPosition * 16 + 16 - 1, lllllllllllllllIIIIIlIlllllIIIll, lllllllllllllllIIIIIlIllllIllIII.zPosition * 16 + 16 - 1);
        BlockPos lllllllllllllllIIIIIlIllllIlllll = null;
        double lllllllllllllllIIIIIlIllllIlllIl = 0.0;
        for (final BlockPos lllllllllllllllIIIIIlIllllIllIll : BlockPos.getAllInBox(lllllllllllllllIIIIIlIlllllIIlII, lllllllllllllllIIIIIlIlllllIIIIl)) {
            final IBlockState lllllllllllllllIIIIIlIllllIllIlI = lllllllllllllllIIIIIlIllllIllIII.getBlockState(lllllllllllllllIIIIIlIllllIllIll);
            if (lllllllllllllllIIIIIlIllllIllIlI.getBlock() == Blocks.END_STONE && !lllllllllllllllIIIIIlIllllIllIII.getBlockState(lllllllllllllllIIIIIlIllllIllIll.up(1)).isBlockNormalCube() && !lllllllllllllllIIIIIlIllllIllIII.getBlockState(lllllllllllllllIIIIIlIllllIllIll.up(2)).isBlockNormalCube()) {
                final double lllllllllllllllIIIIIlIllllIllIIl = lllllllllllllllIIIIIlIllllIllIll.distanceSqToCenter(0.0, 0.0, 0.0);
                if (lllllllllllllllIIIIIlIllllIlllll != null && lllllllllllllllIIIIIlIllllIllIIl >= lllllllllllllllIIIIIlIllllIlllIl) {
                    continue;
                }
                lllllllllllllllIIIIIlIllllIlllll = lllllllllllllllIIIIIlIllllIllIll;
                lllllllllllllllIIIIIlIllllIlllIl = lllllllllllllllIIIIIlIllllIllIIl;
            }
        }
        return lllllllllllllllIIIIIlIllllIlllll;
    }
    
    static {
        LOG = LogManager.getLogger();
    }
    
    private static BlockPos findHighestBlock(final World lllllllllllllllIIIIIllIIIIlIllll, final BlockPos lllllllllllllllIIIIIllIIIIlIlllI, final int lllllllllllllllIIIIIllIIIIlIIIII, final boolean lllllllllllllllIIIIIllIIIIlIllII) {
        BlockPos lllllllllllllllIIIIIllIIIIlIlIll = null;
        for (int lllllllllllllllIIIIIllIIIIlIlIlI = -lllllllllllllllIIIIIllIIIIlIIIII; lllllllllllllllIIIIIllIIIIlIlIlI <= lllllllllllllllIIIIIllIIIIlIIIII; ++lllllllllllllllIIIIIllIIIIlIlIlI) {
            for (int lllllllllllllllIIIIIllIIIIlIlIIl = -lllllllllllllllIIIIIllIIIIlIIIII; lllllllllllllllIIIIIllIIIIlIlIIl <= lllllllllllllllIIIIIllIIIIlIIIII; ++lllllllllllllllIIIIIllIIIIlIlIIl) {
                if (lllllllllllllllIIIIIllIIIIlIlIlI != 0 || lllllllllllllllIIIIIllIIIIlIlIIl != 0 || lllllllllllllllIIIIIllIIIIlIllII) {
                    for (int lllllllllllllllIIIIIllIIIIlIIlll = 255; lllllllllllllllIIIIIllIIIIlIIlll > ((lllllllllllllllIIIIIllIIIIlIlIll == null) ? 0 : lllllllllllllllIIIIIllIIIIlIlIll.getY()); --lllllllllllllllIIIIIllIIIIlIIlll) {
                        final BlockPos lllllllllllllllIIIIIllIIIIlIIllI = new BlockPos(lllllllllllllllIIIIIllIIIIlIlllI.getX() + lllllllllllllllIIIIIllIIIIlIlIlI, lllllllllllllllIIIIIllIIIIlIIlll, lllllllllllllllIIIIIllIIIIlIlllI.getZ() + lllllllllllllllIIIIIllIIIIlIlIIl);
                        final IBlockState lllllllllllllllIIIIIllIIIIlIIlII = lllllllllllllllIIIIIllIIIIlIllll.getBlockState(lllllllllllllllIIIIIllIIIIlIIllI);
                        if (lllllllllllllllIIIIIllIIIIlIIlII.isBlockNormalCube() && (lllllllllllllllIIIIIllIIIIlIllII || lllllllllllllllIIIIIllIIIIlIIlII.getBlock() != Blocks.BEDROCK)) {
                            lllllllllllllllIIIIIllIIIIlIlIll = lllllllllllllllIIIIIllIIIIlIIllI;
                            break;
                        }
                    }
                }
            }
        }
        return (lllllllllllllllIIIIIllIIIIlIlIll == null) ? lllllllllllllllIIIIIllIIIIlIlllI : lllllllllllllllIIIIIllIIIIlIlIll;
    }
    
    public void triggerCooldown() {
        if (!this.world.isRemote) {
            this.teleportCooldown = 40;
            this.world.addBlockEvent(this.getPos(), this.getBlockType(), 1, 0);
            this.markDirty();
        }
    }
    
    public void teleportEntity(final Entity lllllllllllllllIIIIIllIIIlIIllll) {
        if (!this.world.isRemote && !this.isCoolingDown()) {
            this.teleportCooldown = 100;
            if (this.exitPortal == null && this.world.provider instanceof WorldProviderEnd) {
                this.findExitPortal();
            }
            if (this.exitPortal != null) {
                final BlockPos lllllllllllllllIIIIIllIIIlIlIIIl = this.exactTeleport ? this.exitPortal : this.findExitPosition();
                lllllllllllllllIIIIIllIIIlIIllll.setPositionAndUpdate(lllllllllllllllIIIIIllIIIlIlIIIl.getX() + 0.5, lllllllllllllllIIIIIllIIIlIlIIIl.getY() + 0.5, lllllllllllllllIIIIIllIIIlIlIIIl.getZ() + 0.5);
            }
            this.triggerCooldown();
        }
    }
    
    private static Chunk getChunk(final World lllllllllllllllIIIIIllIIIIIIlIIl, final Vec3d lllllllllllllllIIIIIllIIIIIIlIll) {
        return lllllllllllllllIIIIIllIIIIIIlIIl.getChunkFromChunkCoords(MathHelper.floor(lllllllllllllllIIIIIllIIIIIIlIll.xCoord / 16.0), MathHelper.floor(lllllllllllllllIIIIIllIIIIIIlIll.zCoord / 16.0));
    }
    
    public boolean isSpawning() {
        return this.age < 200L;
    }
    
    public float getCooldownPercent(final float lllllllllllllllIIIIIllIIIllIlIll) {
        return 1.0f - MathHelper.clamp((this.teleportCooldown - lllllllllllllllIIIIIllIIIllIlIll) / 40.0f, 0.0f, 1.0f);
    }
    
    public boolean isCoolingDown() {
        return this.teleportCooldown > 0;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllllllIIIIIllIIlIIIlIlI) {
        super.readFromNBT(lllllllllllllllIIIIIllIIlIIIlIlI);
        this.age = lllllllllllllllIIIIIllIIlIIIlIlI.getLong("Age");
        if (lllllllllllllllIIIIIllIIlIIIlIlI.hasKey("ExitPortal", 10)) {
            this.exitPortal = NBTUtil.getPosFromTag(lllllllllllllllIIIIIllIIlIIIlIlI.getCompoundTag("ExitPortal"));
        }
        this.exactTeleport = lllllllllllllllIIIIIllIIlIIIlIlI.getBoolean("ExactTeleport");
    }
    
    @Override
    public double getMaxRenderDistanceSquared() {
        return 65536.0;
    }
    
    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 8, this.getUpdateTag());
    }
    
    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }
    
    public void func_190603_b(final BlockPos lllllllllllllllIIIIIlIlllIIlIIII) {
        this.exactTeleport = true;
        this.exitPortal = lllllllllllllllIIIIIlIlllIIlIIII;
    }
    
    private void createExitPortal(final BlockPos lllllllllllllllIIIIIlIlllIllllIl) {
        new WorldGenEndGateway().generate(this.world, new Random(), lllllllllllllllIIIIIlIlllIllllIl);
        final TileEntity lllllllllllllllIIIIIlIlllIllllII = this.world.getTileEntity(lllllllllllllllIIIIIlIlllIllllIl);
        if (lllllllllllllllIIIIIlIlllIllllII instanceof TileEntityEndGateway) {
            final TileEntityEndGateway lllllllllllllllIIIIIlIlllIlllIll = (TileEntityEndGateway)lllllllllllllllIIIIIlIlllIllllII;
            lllllllllllllllIIIIIlIlllIlllIll.exitPortal = new BlockPos(this.getPos());
            lllllllllllllllIIIIIlIlllIlllIll.markDirty();
        }
        else {
            TileEntityEndGateway.LOG.warn("Couldn't save exit portal at {}", (Object)lllllllllllllllIIIIIlIlllIllllIl);
        }
    }
    
    @Override
    public void update() {
        final boolean lllllllllllllllIIIIIllIIlIIIIIIl = this.isSpawning();
        final boolean lllllllllllllllIIIIIllIIlIIIIIII = this.isCoolingDown();
        ++this.age;
        if (lllllllllllllllIIIIIllIIlIIIIIII) {
            --this.teleportCooldown;
        }
        else if (!this.world.isRemote) {
            final List<Entity> lllllllllllllllIIIIIllIIIlllllll = this.world.getEntitiesWithinAABB((Class<? extends Entity>)Entity.class, new AxisAlignedBB(this.getPos()));
            if (!lllllllllllllllIIIIIllIIIlllllll.isEmpty()) {
                this.teleportEntity(lllllllllllllllIIIIIllIIIlllllll.get(0));
            }
            if (this.age % 2400L == 0L) {
                this.triggerCooldown();
            }
        }
        if (lllllllllllllllIIIIIllIIlIIIIIIl != this.isSpawning() || lllllllllllllllIIIIIllIIlIIIIIII != this.isCoolingDown()) {
            this.markDirty();
        }
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllllllIIIIIllIIlIIlIIII) {
        super.writeToNBT(lllllllllllllllIIIIIllIIlIIlIIII);
        lllllllllllllllIIIIIllIIlIIlIIII.setLong("Age", this.age);
        if (this.exitPortal != null) {
            lllllllllllllllIIIIIllIIlIIlIIII.setTag("ExitPortal", NBTUtil.createPosTag(this.exitPortal));
        }
        if (this.exactTeleport) {
            lllllllllllllllIIIIIllIIlIIlIIII.setBoolean("ExactTeleport", this.exactTeleport);
        }
        return lllllllllllllllIIIIIllIIlIIlIIII;
    }
    
    public float getSpawnPercent(final float lllllllllllllllIIIIIllIIIllIllll) {
        return MathHelper.clamp((this.age + lllllllllllllllIIIIIllIIIllIllll) / 200.0f, 0.0f, 1.0f);
    }
    
    private void findExitPortal() {
        final Vec3d lllllllllllllllIIIIIllIIIlIIIIlI = new Vec3d(this.getPos().getX(), 0.0, this.getPos().getZ()).normalize();
        Vec3d lllllllllllllllIIIIIllIIIlIIIIIl = lllllllllllllllIIIIIllIIIlIIIIlI.scale(1024.0);
        for (int lllllllllllllllIIIIIllIIIlIIIIII = 16; getChunk(this.world, lllllllllllllllIIIIIllIIIlIIIIIl).getTopFilledSegment() > 0 && lllllllllllllllIIIIIllIIIlIIIIII-- > 0; lllllllllllllllIIIIIllIIIlIIIIIl = lllllllllllllllIIIIIllIIIlIIIIIl.add(lllllllllllllllIIIIIllIIIlIIIIlI.scale(-16.0))) {
            TileEntityEndGateway.LOG.debug("Skipping backwards past nonempty chunk at {}", (Object)lllllllllllllllIIIIIllIIIlIIIIIl);
        }
        for (int lllllllllllllllIIIIIllIIIIllllll = 16; getChunk(this.world, lllllllllllllllIIIIIllIIIlIIIIIl).getTopFilledSegment() == 0 && lllllllllllllllIIIIIllIIIIllllll-- > 0; lllllllllllllllIIIIIllIIIlIIIIIl = lllllllllllllllIIIIIllIIIlIIIIIl.add(lllllllllllllllIIIIIllIIIlIIIIlI.scale(16.0))) {
            TileEntityEndGateway.LOG.debug("Skipping forward past empty chunk at {}", (Object)lllllllllllllllIIIIIllIIIlIIIIIl);
        }
        TileEntityEndGateway.LOG.debug("Found chunk at {}", (Object)lllllllllllllllIIIIIllIIIlIIIIIl);
        final Chunk lllllllllllllllIIIIIllIIIIlllllI = getChunk(this.world, lllllllllllllllIIIIIllIIIlIIIIIl);
        this.exitPortal = findSpawnpointInChunk(lllllllllllllllIIIIIllIIIIlllllI);
        if (this.exitPortal == null) {
            this.exitPortal = new BlockPos(lllllllllllllllIIIIIllIIIlIIIIIl.xCoord + 0.5, 75.0, lllllllllllllllIIIIIllIIIlIIIIIl.zCoord + 0.5);
            TileEntityEndGateway.LOG.debug("Failed to find suitable block, settling on {}", (Object)this.exitPortal);
            new WorldGenEndIsland().generate(this.world, new Random(this.exitPortal.toLong()), this.exitPortal);
        }
        else {
            TileEntityEndGateway.LOG.debug("Found block at {}", (Object)this.exitPortal);
        }
        this.exitPortal = findHighestBlock(this.world, this.exitPortal, 16, true);
        TileEntityEndGateway.LOG.debug("Creating portal at {}", (Object)this.exitPortal);
        this.exitPortal = this.exitPortal.up(10);
        this.createExitPortal(this.exitPortal);
        this.markDirty();
    }
    
    @Override
    public boolean receiveClientEvent(final int lllllllllllllllIIIIIllIIIlIllIll, final int lllllllllllllllIIIIIllIIIlIllIlI) {
        if (lllllllllllllllIIIIIllIIIlIllIll == 1) {
            this.teleportCooldown = 40;
            return true;
        }
        return super.receiveClientEvent(lllllllllllllllIIIIIllIIIlIllIll, lllllllllllllllIIIIIllIIIlIllIlI);
    }
    
    public int getParticleAmount() {
        int lllllllllllllllIIIIIlIlllIIllIll = 0;
        final char lllllllllllllllIIIIIlIlllIIlIlII;
        final String lllllllllllllllIIIIIlIlllIIlIlIl = (String)((EnumFacing[])(Object)(lllllllllllllllIIIIIlIlllIIlIlII = (char)(Object)EnumFacing.values())).length;
        for (byte lllllllllllllllIIIIIlIlllIIlIllI = 0; lllllllllllllllIIIIIlIlllIIlIllI < lllllllllllllllIIIIIlIlllIIlIlIl; ++lllllllllllllllIIIIIlIlllIIlIllI) {
            final EnumFacing lllllllllllllllIIIIIlIlllIIllIlI = lllllllllllllllIIIIIlIlllIIlIlII[lllllllllllllllIIIIIlIlllIIlIllI];
            lllllllllllllllIIIIIlIlllIIllIll += (this.shouldRenderFace(lllllllllllllllIIIIIlIlllIIllIlI) ? 1 : 0);
        }
        return lllllllllllllllIIIIIlIlllIIllIll;
    }
}
