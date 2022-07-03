package optifine;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.chunk.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;

public class DynamicLight
{
    private /* synthetic */ int lastLightLevel;
    private /* synthetic */ boolean underwater;
    private /* synthetic */ double lastPosY;
    private /* synthetic */ long timeCheckMs;
    private /* synthetic */ double lastPosX;
    private /* synthetic */ Set<BlockPos> setLitChunkPos;
    private /* synthetic */ double offsetY;
    private /* synthetic */ BlockPos.MutableBlockPos blockPosMutable;
    private /* synthetic */ Entity entity;
    private /* synthetic */ double lastPosZ;
    
    private void updateChunkLight(final RenderChunk llllllllllllllIIIllllIIIlIlllllI, final Set<BlockPos> llllllllllllllIIIllllIIIlIllllIl, final Set<BlockPos> llllllllllllllIIIllllIIIlIllllII) {
        if (llllllllllllllIIIllllIIIlIlllllI != null) {
            final CompiledChunk llllllllllllllIIIllllIIIlIlllIll = llllllllllllllIIIllllIIIlIlllllI.getCompiledChunk();
            if (llllllllllllllIIIllllIIIlIlllIll != null && !llllllllllllllIIIllllIIIlIlllIll.isEmpty()) {
                llllllllllllllIIIllllIIIlIlllllI.setNeedsUpdate(false);
            }
            final BlockPos llllllllllllllIIIllllIIIlIlllIlI = llllllllllllllIIIllllIIIlIlllllI.getPosition().toImmutable();
            if (llllllllllllllIIIllllIIIlIllllIl != null) {
                llllllllllllllIIIllllIIIlIllllIl.remove(llllllllllllllIIIllllIIIlIlllIlI);
            }
            if (llllllllllllllIIIllllIIIlIllllII != null) {
                llllllllllllllIIIllllIIIlIllllII.add(llllllllllllllIIIllllIIIlIlllIlI);
            }
        }
    }
    
    private BlockPos getChunkPos(final RenderChunk llllllllllllllIIIllllIIIllIIlIlI, final BlockPos llllllllllllllIIIllllIIIllIIlIIl, final EnumFacing llllllllllllllIIIllllIIIllIIlIII) {
        return (llllllllllllllIIIllllIIIllIIlIlI != null) ? llllllllllllllIIIllllIIIllIIlIlI.getBlockPosOffset16(llllllllllllllIIIllllIIIllIIlIII) : llllllllllllllIIIllllIIIllIIlIIl.offset(llllllllllllllIIIllllIIIllIIlIII, 16);
    }
    
    public double getLastPosZ() {
        return this.lastPosZ;
    }
    
    public Entity getEntity() {
        return this.entity;
    }
    
    public int getLastLightLevel() {
        return this.lastLightLevel;
    }
    
    public void update(final RenderGlobal llllllllllllllIIIllllIIIlllIllII) {
        if (Config.isDynamicLightsFast()) {
            final long llllllllllllllIIIllllIIlIIIIllIl = System.currentTimeMillis();
            if (llllllllllllllIIIllllIIlIIIIllIl < this.timeCheckMs + 500L) {
                return;
            }
            this.timeCheckMs = llllllllllllllIIIllllIIlIIIIllIl;
        }
        final double llllllllllllllIIIllllIIlIIIIllII = this.entity.posX - 0.5;
        final double llllllllllllllIIIllllIIlIIIIlIll = this.entity.posY - 0.5 + this.offsetY;
        final double llllllllllllllIIIllllIIlIIIIlIlI = this.entity.posZ - 0.5;
        final int llllllllllllllIIIllllIIlIIIIlIIl = DynamicLights.getLightLevel(this.entity);
        final double llllllllllllllIIIllllIIlIIIIlIII = llllllllllllllIIIllllIIlIIIIllII - this.lastPosX;
        final double llllllllllllllIIIllllIIlIIIIIlll = llllllllllllllIIIllllIIlIIIIlIll - this.lastPosY;
        final double llllllllllllllIIIllllIIlIIIIIllI = llllllllllllllIIIllllIIlIIIIlIlI - this.lastPosZ;
        final double llllllllllllllIIIllllIIlIIIIIlIl = 0.1;
        if (Math.abs(llllllllllllllIIIllllIIlIIIIlIII) > llllllllllllllIIIllllIIlIIIIIlIl || Math.abs(llllllllllllllIIIllllIIlIIIIIlll) > llllllllllllllIIIllllIIlIIIIIlIl || Math.abs(llllllllllllllIIIllllIIlIIIIIllI) > llllllllllllllIIIllllIIlIIIIIlIl || this.lastLightLevel != llllllllllllllIIIllllIIlIIIIlIIl) {
            this.lastPosX = llllllllllllllIIIllllIIlIIIIllII;
            this.lastPosY = llllllllllllllIIIllllIIlIIIIlIll;
            this.lastPosZ = llllllllllllllIIIllllIIlIIIIlIlI;
            this.lastLightLevel = llllllllllllllIIIllllIIlIIIIlIIl;
            this.underwater = false;
            final World llllllllllllllIIIllllIIlIIIIIlII = llllllllllllllIIIllllIIIlllIllII.getWorld();
            if (llllllllllllllIIIllllIIlIIIIIlII != null) {
                this.blockPosMutable.setPos(MathHelper.floor(llllllllllllllIIIllllIIlIIIIllII), MathHelper.floor(llllllllllllllIIIllllIIlIIIIlIll), MathHelper.floor(llllllllllllllIIIllllIIlIIIIlIlI));
                final IBlockState llllllllllllllIIIllllIIlIIIIIIll = llllllllllllllIIIllllIIlIIIIIlII.getBlockState(this.blockPosMutable);
                final Block llllllllllllllIIIllllIIlIIIIIIlI = llllllllllllllIIIllllIIlIIIIIIll.getBlock();
                this.underwater = (llllllllllllllIIIllllIIlIIIIIIlI == Blocks.WATER);
            }
            final Set<BlockPos> llllllllllllllIIIllllIIlIIIIIIIl = new HashSet<BlockPos>();
            if (llllllllllllllIIIllllIIlIIIIlIIl > 0) {
                final EnumFacing llllllllllllllIIIllllIIlIIIIIIII = ((MathHelper.floor(llllllllllllllIIIllllIIlIIIIllII) & 0xF) >= 8) ? EnumFacing.EAST : EnumFacing.WEST;
                final EnumFacing llllllllllllllIIIllllIIIllllllll = ((MathHelper.floor(llllllllllllllIIIllllIIlIIIIlIll) & 0xF) >= 8) ? EnumFacing.UP : EnumFacing.DOWN;
                final EnumFacing llllllllllllllIIIllllIIIlllllllI = ((MathHelper.floor(llllllllllllllIIIllllIIlIIIIlIlI) & 0xF) >= 8) ? EnumFacing.SOUTH : EnumFacing.NORTH;
                final BlockPos llllllllllllllIIIllllIIIllllllIl = new BlockPos(llllllllllllllIIIllllIIlIIIIllII, llllllllllllllIIIllllIIlIIIIlIll, llllllllllllllIIIllllIIlIIIIlIlI);
                final RenderChunk llllllllllllllIIIllllIIIllllllII = llllllllllllllIIIllllIIIlllIllII.getRenderChunk(llllllllllllllIIIllllIIIllllllIl);
                final BlockPos llllllllllllllIIIllllIIIlllllIll = this.getChunkPos(llllllllllllllIIIllllIIIllllllII, llllllllllllllIIIllllIIIllllllIl, llllllllllllllIIIllllIIlIIIIIIII);
                final RenderChunk llllllllllllllIIIllllIIIlllllIlI = llllllllllllllIIIllllIIIlllIllII.getRenderChunk(llllllllllllllIIIllllIIIlllllIll);
                final BlockPos llllllllllllllIIIllllIIIlllllIIl = this.getChunkPos(llllllllllllllIIIllllIIIllllllII, llllllllllllllIIIllllIIIllllllIl, llllllllllllllIIIllllIIIlllllllI);
                final RenderChunk llllllllllllllIIIllllIIIlllllIII = llllllllllllllIIIllllIIIlllIllII.getRenderChunk(llllllllllllllIIIllllIIIlllllIIl);
                final BlockPos llllllllllllllIIIllllIIIllllIlll = this.getChunkPos(llllllllllllllIIIllllIIIlllllIlI, llllllllllllllIIIllllIIIlllllIll, llllllllllllllIIIllllIIIlllllllI);
                final RenderChunk llllllllllllllIIIllllIIIllllIllI = llllllllllllllIIIllllIIIlllIllII.getRenderChunk(llllllllllllllIIIllllIIIllllIlll);
                final BlockPos llllllllllllllIIIllllIIIllllIlIl = this.getChunkPos(llllllllllllllIIIllllIIIllllllII, llllllllllllllIIIllllIIIllllllIl, llllllllllllllIIIllllIIIllllllll);
                final RenderChunk llllllllllllllIIIllllIIIllllIlII = llllllllllllllIIIllllIIIlllIllII.getRenderChunk(llllllllllllllIIIllllIIIllllIlIl);
                final BlockPos llllllllllllllIIIllllIIIllllIIll = this.getChunkPos(llllllllllllllIIIllllIIIllllIlII, llllllllllllllIIIllllIIIllllIlIl, llllllllllllllIIIllllIIlIIIIIIII);
                final RenderChunk llllllllllllllIIIllllIIIllllIIlI = llllllllllllllIIIllllIIIlllIllII.getRenderChunk(llllllllllllllIIIllllIIIllllIIll);
                final BlockPos llllllllllllllIIIllllIIIllllIIIl = this.getChunkPos(llllllllllllllIIIllllIIIllllIlII, llllllllllllllIIIllllIIIllllIlIl, llllllllllllllIIIllllIIIlllllllI);
                final RenderChunk llllllllllllllIIIllllIIIllllIIII = llllllllllllllIIIllllIIIlllIllII.getRenderChunk(llllllllllllllIIIllllIIIllllIIIl);
                final BlockPos llllllllllllllIIIllllIIIlllIllll = this.getChunkPos(llllllllllllllIIIllllIIIllllIIlI, llllllllllllllIIIllllIIIllllIIll, llllllllllllllIIIllllIIIlllllllI);
                final RenderChunk llllllllllllllIIIllllIIIlllIlllI = llllllllllllllIIIllllIIIlllIllII.getRenderChunk(llllllllllllllIIIllllIIIlllIllll);
                this.updateChunkLight(llllllllllllllIIIllllIIIllllllII, this.setLitChunkPos, llllllllllllllIIIllllIIlIIIIIIIl);
                this.updateChunkLight(llllllllllllllIIIllllIIIlllllIlI, this.setLitChunkPos, llllllllllllllIIIllllIIlIIIIIIIl);
                this.updateChunkLight(llllllllllllllIIIllllIIIlllllIII, this.setLitChunkPos, llllllllllllllIIIllllIIlIIIIIIIl);
                this.updateChunkLight(llllllllllllllIIIllllIIIllllIllI, this.setLitChunkPos, llllllllllllllIIIllllIIlIIIIIIIl);
                this.updateChunkLight(llllllllllllllIIIllllIIIllllIlII, this.setLitChunkPos, llllllllllllllIIIllllIIlIIIIIIIl);
                this.updateChunkLight(llllllllllllllIIIllllIIIllllIIlI, this.setLitChunkPos, llllllllllllllIIIllllIIlIIIIIIIl);
                this.updateChunkLight(llllllllllllllIIIllllIIIllllIIII, this.setLitChunkPos, llllllllllllllIIIllllIIlIIIIIIIl);
                this.updateChunkLight(llllllllllllllIIIllllIIIlllIlllI, this.setLitChunkPos, llllllllllllllIIIllllIIlIIIIIIIl);
            }
            this.updateLitChunks(llllllllllllllIIIllllIIIlllIllII);
            this.setLitChunkPos = llllllllllllllIIIllllIIlIIIIIIIl;
        }
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("Entity: ").append(this.entity).append(", offsetY: ").append(this.offsetY));
    }
    
    public double getLastPosX() {
        return this.lastPosX;
    }
    
    public boolean isUnderwater() {
        return this.underwater;
    }
    
    public double getLastPosY() {
        return this.lastPosY;
    }
    
    public void updateLitChunks(final RenderGlobal llllllllllllllIIIllllIIIlIlIlIlI) {
        for (final BlockPos llllllllllllllIIIllllIIIlIlIllIl : this.setLitChunkPos) {
            final RenderChunk llllllllllllllIIIllllIIIlIlIllII = llllllllllllllIIIllllIIIlIlIlIlI.getRenderChunk(llllllllllllllIIIllllIIIlIlIllIl);
            this.updateChunkLight(llllllllllllllIIIllllIIIlIlIllII, null, null);
        }
    }
    
    public DynamicLight(final Entity llllllllllllllIIIllllIIlIIllIIIl) {
        this.entity = null;
        this.offsetY = 0.0;
        this.lastPosX = -2.147483648E9;
        this.lastPosY = -2.147483648E9;
        this.lastPosZ = -2.147483648E9;
        this.lastLightLevel = 0;
        this.underwater = false;
        this.timeCheckMs = 0L;
        this.setLitChunkPos = new HashSet<BlockPos>();
        this.blockPosMutable = new BlockPos.MutableBlockPos();
        this.entity = llllllllllllllIIIllllIIlIIllIIIl;
        this.offsetY = llllllllllllllIIIllllIIlIIllIIIl.getEyeHeight();
    }
    
    public double getOffsetY() {
        return this.offsetY;
    }
}
