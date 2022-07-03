package net.minecraft.world;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import net.minecraft.network.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.player.*;
import javax.annotation.*;
import net.minecraft.util.*;
import net.minecraft.network.play.server.*;
import net.minecraft.entity.*;

public class ServerWorldEventHandler implements IWorldEventListener
{
    private final /* synthetic */ WorldServer theWorldServer;
    private final /* synthetic */ MinecraftServer mcServer;
    
    @Override
    public void spawnParticle(final int lllllllllllllIlllIllIIllIlIlIllI, final boolean lllllllllllllIlllIllIIllIlIlIlIl, final double lllllllllllllIlllIllIIllIlIlIlII, final double lllllllllllllIlllIllIIllIlIlIIll, final double lllllllllllllIlllIllIIllIlIlIIlI, final double lllllllllllllIlllIllIIllIlIlIIIl, final double lllllllllllllIlllIllIIllIlIlIIII, final double lllllllllllllIlllIllIIllIlIIllll, final int... lllllllllllllIlllIllIIllIlIIlllI) {
    }
    
    @Override
    public void broadcastSound(final int lllllllllllllIlllIllIIlIllllIIIl, final BlockPos lllllllllllllIlllIllIIlIlllIllII, final int lllllllllllllIlllIllIIlIlllIllll) {
        this.mcServer.getPlayerList().sendPacketToAllPlayers(new SPacketEffect(lllllllllllllIlllIllIIlIllllIIIl, lllllllllllllIlllIllIIlIlllIllII, lllllllllllllIlllIllIIlIlllIllll, true));
    }
    
    @Override
    public void playRecord(final SoundEvent lllllllllllllIlllIllIIllIIIIIlll, final BlockPos lllllllllllllIlllIllIIllIIIIIllI) {
    }
    
    @Override
    public void func_190570_a(final int lllllllllllllIlllIllIIllIlIIllII, final boolean lllllllllllllIlllIllIIllIlIIlIll, final boolean lllllllllllllIlllIllIIllIlIIlIlI, final double lllllllllllllIlllIllIIllIlIIlIIl, final double lllllllllllllIlllIllIIllIlIIlIII, final double lllllllllllllIlllIllIIllIlIIIlll, final double lllllllllllllIlllIllIIllIlIIIllI, final double lllllllllllllIlllIllIIllIlIIIlIl, final double lllllllllllllIlllIllIIllIlIIIlII, final int... lllllllllllllIlllIllIIllIlIIIIll) {
    }
    
    @Override
    public void sendBlockBreakProgress(final int lllllllllllllIlllIllIIlIllIllIIl, final BlockPos lllllllllllllIlllIllIIlIllIIlIIl, final int lllllllllllllIlllIllIIlIllIIIlll) {
        for (final EntityPlayerMP lllllllllllllIlllIllIIlIllIlIlIl : this.mcServer.getPlayerList().getPlayerList()) {
            if (lllllllllllllIlllIllIIlIllIlIlIl != null && lllllllllllllIlllIllIIlIllIlIlIl.world == this.theWorldServer && lllllllllllllIlllIllIIlIllIlIlIl.getEntityId() != lllllllllllllIlllIllIIlIllIllIIl) {
                final double lllllllllllllIlllIllIIlIllIlIIll = lllllllllllllIlllIllIIlIllIIlIIl.getX() - lllllllllllllIlllIllIIlIllIlIlIl.posX;
                final double lllllllllllllIlllIllIIlIllIlIIIl = lllllllllllllIlllIllIIlIllIIlIIl.getY() - lllllllllllllIlllIllIIlIllIlIlIl.posY;
                final double lllllllllllllIlllIllIIlIllIIllll = lllllllllllllIlllIllIIlIllIIlIIl.getZ() - lllllllllllllIlllIllIIlIllIlIlIl.posZ;
                if (lllllllllllllIlllIllIIlIllIlIIll * lllllllllllllIlllIllIIlIllIlIIll + lllllllllllllIlllIllIIlIllIlIIIl * lllllllllllllIlllIllIIlIllIlIIIl + lllllllllllllIlllIllIIlIllIIllll * lllllllllllllIlllIllIIlIllIIllll >= 1024.0) {
                    continue;
                }
                lllllllllllllIlllIllIIlIllIlIlIl.connection.sendPacket(new SPacketBlockBreakAnim(lllllllllllllIlllIllIIlIllIllIIl, lllllllllllllIlllIllIIlIllIIlIIl, lllllllllllllIlllIllIIlIllIIIlll));
            }
        }
    }
    
    @Override
    public void notifyBlockUpdate(final World lllllllllllllIlllIllIIllIIIlIIIl, final BlockPos lllllllllllllIlllIllIIllIIIIlIll, final IBlockState lllllllllllllIlllIllIIllIIIIllll, final IBlockState lllllllllllllIlllIllIIllIIIIlllI, final int lllllllllllllIlllIllIIllIIIIllIl) {
        this.theWorldServer.getPlayerChunkMap().markBlockForUpdate(lllllllllllllIlllIllIIllIIIIlIll);
    }
    
    public ServerWorldEventHandler(final MinecraftServer lllllllllllllIlllIllIIllIlIlllII, final WorldServer lllllllllllllIlllIllIIllIlIllIII) {
        this.mcServer = lllllllllllllIlllIllIIllIlIlllII;
        this.theWorldServer = lllllllllllllIlllIllIIllIlIllIII;
    }
    
    @Override
    public void playEvent(final EntityPlayer lllllllllllllIlllIllIIlIllllllll, final int lllllllllllllIlllIllIIlIlllllIIl, final BlockPos lllllllllllllIlllIllIIlIllllllIl, final int lllllllllllllIlllIllIIlIllllIlll) {
        this.mcServer.getPlayerList().sendToAllNearExcept(lllllllllllllIlllIllIIlIllllllll, lllllllllllllIlllIllIIlIllllllIl.getX(), lllllllllllllIlllIllIIlIllllllIl.getY(), lllllllllllllIlllIllIIlIllllllIl.getZ(), 64.0, this.theWorldServer.provider.getDimensionType().getId(), new SPacketEffect(lllllllllllllIlllIllIIlIlllllIIl, lllllllllllllIlllIllIIlIllllllIl, lllllllllllllIlllIllIIlIllllIlll, false));
    }
    
    @Override
    public void notifyLightSet(final BlockPos lllllllllllllIlllIllIIllIIIIlIIl) {
    }
    
    @Override
    public void playSoundToAllNearExcept(@Nullable final EntityPlayer lllllllllllllIlllIllIIllIIlIIIll, final SoundEvent lllllllllllllIlllIllIIllIIlIlIll, final SoundCategory lllllllllllllIlllIllIIllIIlIlIlI, final double lllllllllllllIlllIllIIllIIlIlIIl, final double lllllllllllllIlllIllIIllIIlIlIII, final double lllllllllllllIlllIllIIllIIlIIlll, final float lllllllllllllIlllIllIIllIIlIIllI, final float lllllllllllllIlllIllIIllIIlIIlIl) {
        this.mcServer.getPlayerList().sendToAllNearExcept(lllllllllllllIlllIllIIllIIlIIIll, lllllllllllllIlllIllIIllIIlIlIIl, lllllllllllllIlllIllIIllIIlIlIII, lllllllllllllIlllIllIIllIIlIIlll, (lllllllllllllIlllIllIIllIIlIIllI > 1.0f) ? ((double)(16.0f * lllllllllllllIlllIllIIllIIlIIllI)) : 16.0, this.theWorldServer.provider.getDimensionType().getId(), new SPacketSoundEffect(lllllllllllllIlllIllIIllIIlIlIll, lllllllllllllIlllIllIIllIIlIlIlI, lllllllllllllIlllIllIIllIIlIlIIl, lllllllllllllIlllIllIIllIIlIlIII, lllllllllllllIlllIllIIllIIlIIlll, lllllllllllllIlllIllIIllIIlIIllI, lllllllllllllIlllIllIIllIIlIIlIl));
    }
    
    @Override
    public void onEntityAdded(final Entity lllllllllllllIlllIllIIllIIllllll) {
        this.theWorldServer.getEntityTracker().trackEntity(lllllllllllllIlllIllIIllIIllllll);
        if (lllllllllllllIlllIllIIllIIllllll instanceof EntityPlayerMP) {
            this.theWorldServer.provider.onPlayerAdded((EntityPlayerMP)lllllllllllllIlllIllIIllIIllllll);
        }
    }
    
    @Override
    public void onEntityRemoved(final Entity lllllllllllllIlllIllIIllIIlllIIl) {
        this.theWorldServer.getEntityTracker().untrackEntity(lllllllllllllIlllIllIIllIIlllIIl);
        this.theWorldServer.getScoreboard().removeEntity(lllllllllllllIlllIllIIllIIlllIIl);
        if (lllllllllllllIlllIllIIllIIlllIIl instanceof EntityPlayerMP) {
            this.theWorldServer.provider.onPlayerRemoved((EntityPlayerMP)lllllllllllllIlllIllIIllIIlllIIl);
        }
    }
    
    @Override
    public void markBlockRangeForRenderUpdate(final int lllllllllllllIlllIllIIllIIIllIlI, final int lllllllllllllIlllIllIIllIIIllIIl, final int lllllllllllllIlllIllIIllIIIllIII, final int lllllllllllllIlllIllIIllIIIlIlll, final int lllllllllllllIlllIllIIllIIIlIllI, final int lllllllllllllIlllIllIIllIIIlIlIl) {
    }
}
