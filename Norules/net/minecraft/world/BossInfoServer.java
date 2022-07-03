package net.minecraft.world;

import net.minecraft.entity.player.*;
import net.minecraft.network.play.server.*;
import net.minecraft.util.text.*;
import com.google.common.base.*;
import net.minecraft.util.math.*;
import com.google.common.collect.*;
import net.minecraft.network.*;
import java.util.*;

public class BossInfoServer extends BossInfo
{
    private final /* synthetic */ Set<EntityPlayerMP> readOnlyPlayers;
    private final /* synthetic */ Set<EntityPlayerMP> players;
    private /* synthetic */ boolean visible;
    
    @Override
    public void setOverlay(final Overlay llllllllllllllllIIIlIlllIllllllI) {
        if (llllllllllllllllIIIlIlllIllllllI != this.overlay) {
            super.setOverlay(llllllllllllllllIIIlIlllIllllllI);
            this.sendUpdate(SPacketUpdateBossInfo.Operation.UPDATE_STYLE);
        }
    }
    
    @Override
    public void setName(final ITextComponent llllllllllllllllIIIlIlllIllIlIII) {
        if (!Objects.equal((Object)llllllllllllllllIIIlIlllIllIlIII, (Object)this.name)) {
            super.setName(llllllllllllllllIIIlIlllIllIlIII);
            this.sendUpdate(SPacketUpdateBossInfo.Operation.UPDATE_NAME);
        }
    }
    
    public BossInfoServer(final ITextComponent llllllllllllllllIIIlIllllIIlIllI, final Color llllllllllllllllIIIlIllllIIlIIIl, final Overlay llllllllllllllllIIIlIllllIIlIIII) {
        super(MathHelper.getRandomUUID(), llllllllllllllllIIIlIllllIIlIllI, llllllllllllllllIIIlIllllIIlIIIl, llllllllllllllllIIIlIllllIIlIIII);
        this.players = (Set<EntityPlayerMP>)Sets.newHashSet();
        this.readOnlyPlayers = Collections.unmodifiableSet((Set<? extends EntityPlayerMP>)this.players);
        this.visible = true;
    }
    
    public void addPlayer(final EntityPlayerMP llllllllllllllllIIIlIlllIlIlIIlI) {
        if (this.players.add(llllllllllllllllIIIlIlllIlIlIIlI) && this.visible) {
            llllllllllllllllIIIlIlllIlIlIIlI.connection.sendPacket(new SPacketUpdateBossInfo(SPacketUpdateBossInfo.Operation.ADD, this));
        }
    }
    
    public void removePlayer(final EntityPlayerMP llllllllllllllllIIIlIlllIlIIllII) {
        if (this.players.remove(llllllllllllllllIIIlIlllIlIIllII) && this.visible) {
            llllllllllllllllIIIlIlllIlIIllII.connection.sendPacket(new SPacketUpdateBossInfo(SPacketUpdateBossInfo.Operation.REMOVE, this));
        }
    }
    
    private void sendUpdate(final SPacketUpdateBossInfo.Operation llllllllllllllllIIIlIlllIlIllIll) {
        if (this.visible) {
            final SPacketUpdateBossInfo llllllllllllllllIIIlIlllIlIllllI = new SPacketUpdateBossInfo(llllllllllllllllIIIlIlllIlIllIll, this);
            for (final EntityPlayerMP llllllllllllllllIIIlIlllIlIlllIl : this.players) {
                llllllllllllllllIIIlIlllIlIlllIl.connection.sendPacket(llllllllllllllllIIIlIlllIlIllllI);
            }
        }
    }
    
    public Collection<EntityPlayerMP> getPlayers() {
        return this.readOnlyPlayers;
    }
    
    @Override
    public BossInfo setPlayEndBossMusic(final boolean llllllllllllllllIIIlIlllIlllIlII) {
        if (llllllllllllllllIIIlIlllIlllIlII != this.playEndBossMusic) {
            super.setPlayEndBossMusic(llllllllllllllllIIIlIlllIlllIlII);
            this.sendUpdate(SPacketUpdateBossInfo.Operation.UPDATE_PROPERTIES);
        }
        return this;
    }
    
    @Override
    public void setPercent(final float llllllllllllllllIIIlIllllIIIllII) {
        if (llllllllllllllllIIIlIllllIIIllII != this.percent) {
            super.setPercent(llllllllllllllllIIIlIllllIIIllII);
            this.sendUpdate(SPacketUpdateBossInfo.Operation.UPDATE_PCT);
        }
    }
    
    @Override
    public BossInfo setDarkenSky(final boolean llllllllllllllllIIIlIlllIllllIlI) {
        if (llllllllllllllllIIIlIlllIllllIlI != this.darkenSky) {
            super.setDarkenSky(llllllllllllllllIIIlIlllIllllIlI);
            this.sendUpdate(SPacketUpdateBossInfo.Operation.UPDATE_PROPERTIES);
        }
        return this;
    }
    
    @Override
    public void setColor(final Color llllllllllllllllIIIlIllllIIIIlII) {
        if (llllllllllllllllIIIlIllllIIIIlII != this.color) {
            super.setColor(llllllllllllllllIIIlIllllIIIIlII);
            this.sendUpdate(SPacketUpdateBossInfo.Operation.UPDATE_STYLE);
        }
    }
    
    public void setVisible(final boolean llllllllllllllllIIIlIlllIlIIIIll) {
        if (llllllllllllllllIIIlIlllIlIIIIll != this.visible) {
            this.visible = llllllllllllllllIIIlIlllIlIIIIll;
            for (final EntityPlayerMP llllllllllllllllIIIlIlllIlIIIlIl : this.players) {
                llllllllllllllllIIIlIlllIlIIIlIl.connection.sendPacket(new SPacketUpdateBossInfo(llllllllllllllllIIIlIlllIlIIIIll ? SPacketUpdateBossInfo.Operation.ADD : SPacketUpdateBossInfo.Operation.REMOVE, this));
            }
        }
    }
    
    @Override
    public BossInfo setCreateFog(final boolean llllllllllllllllIIIlIlllIllIllII) {
        if (llllllllllllllllIIIlIlllIllIllII != this.createFog) {
            super.setCreateFog(llllllllllllllllIIIlIlllIllIllII);
            this.sendUpdate(SPacketUpdateBossInfo.Operation.UPDATE_PROPERTIES);
        }
        return this;
    }
}
