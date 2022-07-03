package com.viaversion.viaversion.legacy.bossbar;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.legacy.bossbar.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import java.util.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.*;

public class CommonBoss implements BossBar
{
    private /* synthetic */ float health;
    private final /* synthetic */ UUID uuid;
    private /* synthetic */ BossColor color;
    private /* synthetic */ boolean visible;
    private /* synthetic */ BossStyle style;
    private final /* synthetic */ Map<UUID, UserConnection> connections;
    private final /* synthetic */ Set<BossFlag> flags;
    private /* synthetic */ String title;
    
    @Override
    public Set<UserConnection> getConnections() {
        return Collections.unmodifiableSet((Set<? extends UserConnection>)new HashSet<UserConnection>(this.connections.values()));
    }
    
    @Override
    public BossBar addFlag(final BossFlag llllllllllllllIllIIlIllllIllIlIl) {
        Preconditions.checkNotNull((Object)llllllllllllllIllIIlIllllIllIlIl);
        if (!this.hasFlag(llllllllllllllIllIIlIllllIllIlIl)) {
            this.flags.add(llllllllllllllIllIIlIllllIllIlIl);
        }
        this.sendPacket(UpdateAction.UPDATE_FLAGS);
        return this;
    }
    
    public CommonBoss(final String llllllllllllllIllIIlIlllllllllII, final float llllllllllllllIllIIlIlllllllIllI, final BossColor llllllllllllllIllIIlIlllllllIlIl, final BossStyle llllllllllllllIllIIlIlllllllIlII) {
        Preconditions.checkNotNull((Object)llllllllllllllIllIIlIlllllllllII, (Object)"Title cannot be null");
        Preconditions.checkArgument(llllllllllllllIllIIlIlllllllIllI >= 0.0f && llllllllllllllIllIIlIlllllllIllI <= 1.0f, (Object)String.valueOf(new StringBuilder().append("Health must be between 0 and 1. Input: ").append(llllllllllllllIllIIlIlllllllIllI)));
        this.uuid = UUID.randomUUID();
        this.title = llllllllllllllIllIIlIlllllllllII;
        this.health = llllllllllllllIllIIlIlllllllIllI;
        this.color = ((llllllllllllllIllIIlIlllllllIlIl == null) ? BossColor.PURPLE : llllllllllllllIllIIlIlllllllIlIl);
        this.style = ((llllllllllllllIllIIlIlllllllIlII == null) ? BossStyle.SOLID : llllllllllllllIllIIlIlllllllIlII);
        this.connections = (Map<UUID, UserConnection>)new MapMaker().weakValues().makeMap();
        this.flags = new HashSet<BossFlag>();
        this.visible = true;
    }
    
    @Override
    public BossBar addConnection(final UserConnection llllllllllllllIllIIlIlllllIIlIlI) {
        if (this.connections.put(llllllllllllllIllIIlIlllllIIlIlI.getProtocolInfo().getUuid(), llllllllllllllIllIIlIlllllIIlIlI) == null && this.visible) {
            this.sendPacketConnection(llllllllllllllIllIIlIlllllIIlIlI, this.getPacket(UpdateAction.ADD, llllllllllllllIllIIlIlllllIIlIlI));
        }
        return this;
    }
    
    @Override
    public BossBar setStyle(final BossStyle llllllllllllllIllIIlIlllllIllIll) {
        Preconditions.checkNotNull((Object)llllllllllllllIllIIlIlllllIllIll);
        this.style = llllllllllllllIllIIlIlllllIllIll;
        this.sendPacket(UpdateAction.UPDATE_STYLE);
        return this;
    }
    
    @Override
    public BossBar removeFlag(final BossFlag llllllllllllllIllIIlIllllIllIIIl) {
        Preconditions.checkNotNull((Object)llllllllllllllIllIIlIllllIllIIIl);
        if (this.hasFlag(llllllllllllllIllIIlIllllIllIIIl)) {
            this.flags.remove(llllllllllllllIllIIlIllllIllIIIl);
        }
        this.sendPacket(UpdateAction.UPDATE_FLAGS);
        return this;
    }
    
    @Override
    public BossStyle getStyle() {
        return this.style;
    }
    
    @Override
    public UUID getId() {
        return this.uuid;
    }
    
    public UUID getUuid() {
        return this.uuid;
    }
    
    @Override
    public BossBar show() {
        this.setVisible(true);
        return this;
    }
    
    private void setVisible(final boolean llllllllllllllIllIIlIllllIIlIllI) {
        if (this.visible != llllllllllllllIllIIlIllllIIlIllI) {
            this.visible = llllllllllllllIllIIlIllllIIlIllI;
            this.sendPacket(llllllllllllllIllIIlIllllIIlIllI ? UpdateAction.ADD : UpdateAction.REMOVE);
        }
    }
    
    @Override
    public String getTitle() {
        return this.title;
    }
    
    @Override
    public Set<UUID> getPlayers() {
        return Collections.unmodifiableSet((Set<? extends UUID>)this.connections.keySet());
    }
    
    @Override
    public BossBar setColor(final BossColor llllllllllllllIllIIlIlllllIlllll) {
        Preconditions.checkNotNull((Object)llllllllllllllIllIIlIlllllIlllll);
        this.color = llllllllllllllIllIIlIlllllIlllll;
        this.sendPacket(UpdateAction.UPDATE_STYLE);
        return this;
    }
    
    @Override
    public BossBar removePlayer(final UUID llllllllllllllIllIIlIlllllIIIIlI) {
        final UserConnection llllllllllllllIllIIlIlllllIIIlII = this.connections.remove(llllllllllllllIllIIlIlllllIIIIlI);
        if (llllllllllllllIllIIlIlllllIIIlII != null) {
            this.sendPacketConnection(llllllllllllllIllIIlIlllllIIIlII, this.getPacket(UpdateAction.REMOVE, llllllllllllllIllIIlIlllllIIIlII));
        }
        return this;
    }
    
    @Override
    public boolean hasFlag(final BossFlag llllllllllllllIllIIlIllllIlIlIll) {
        Preconditions.checkNotNull((Object)llllllllllllllIllIIlIllllIlIlIll);
        return this.flags.contains(llllllllllllllIllIIlIllllIlIlIll);
    }
    
    private void sendPacket(final UpdateAction llllllllllllllIllIIlIlllIllIlIll) {
        for (final UserConnection llllllllllllllIllIIlIlllIllIllll : new ArrayList(this.connections.values())) {
            final PacketWrapper llllllllllllllIllIIlIlllIlllIIII = this.getPacket(llllllllllllllIllIIlIlllIllIlIll, llllllllllllllIllIIlIlllIllIllll);
            this.sendPacketConnection(llllllllllllllIllIIlIlllIllIllll, llllllllllllllIllIIlIlllIlllIIII);
        }
    }
    
    @Override
    public BossBar setTitle(final String llllllllllllllIllIIlIlllllllIIII) {
        Preconditions.checkNotNull((Object)llllllllllllllIllIIlIlllllllIIII);
        this.title = llllllllllllllIllIIlIlllllllIIII;
        this.sendPacket(UpdateAction.UPDATE_TITLE);
        return this;
    }
    
    @Override
    public BossBar removeConnection(final UserConnection llllllllllllllIllIIlIllllIllllIl) {
        this.removePlayer(llllllllllllllIllIIlIllllIllllIl.getProtocolInfo().getUuid());
        return this;
    }
    
    private PacketWrapper getPacket(final UpdateAction llllllllllllllIllIIlIlllIIlIlIII, final UserConnection llllllllllllllIllIIlIlllIIlIlIlI) {
        try {
            final PacketWrapper llllllllllllllIllIIlIlllIIllIIIl = PacketWrapper.create(ClientboundPackets1_9.BOSSBAR, null, llllllllllllllIllIIlIlllIIlIlIlI);
            llllllllllllllIllIIlIlllIIllIIIl.write(Type.UUID, this.uuid);
            llllllllllllllIllIIlIlllIIllIIIl.write(Type.VAR_INT, llllllllllllllIllIIlIlllIIlIlIII.getId());
            switch (llllllllllllllIllIIlIlllIIlIlIII) {
                case ADD: {
                    Protocol1_9To1_8.FIX_JSON.write(llllllllllllllIllIIlIlllIIllIIIl, this.title);
                    llllllllllllllIllIIlIlllIIllIIIl.write(Type.FLOAT, this.health);
                    llllllllllllllIllIIlIlllIIllIIIl.write(Type.VAR_INT, this.color.getId());
                    llllllllllllllIllIIlIlllIIllIIIl.write(Type.VAR_INT, this.style.getId());
                    llllllllllllllIllIIlIlllIIllIIIl.write(Type.BYTE, (byte)this.flagToBytes());
                }
                case UPDATE_HEALTH: {
                    llllllllllllllIllIIlIlllIIllIIIl.write(Type.FLOAT, this.health);
                    break;
                }
                case UPDATE_TITLE: {
                    Protocol1_9To1_8.FIX_JSON.write(llllllllllllllIllIIlIlllIIllIIIl, this.title);
                    break;
                }
                case UPDATE_STYLE: {
                    llllllllllllllIllIIlIlllIIllIIIl.write(Type.VAR_INT, this.color.getId());
                    llllllllllllllIllIIlIlllIIllIIIl.write(Type.VAR_INT, this.style.getId());
                    break;
                }
                case UPDATE_FLAGS: {
                    llllllllllllllIllIIlIlllIIllIIIl.write(Type.BYTE, (byte)this.flagToBytes());
                    break;
                }
            }
            return llllllllllllllIllIIlIlllIIllIIIl;
        }
        catch (Exception llllllllllllllIllIIlIlllIIlIlllI) {
            llllllllllllllIllIIlIlllIIlIlllI.printStackTrace();
            return null;
        }
    }
    
    private void sendPacketConnection(final UserConnection llllllllllllllIllIIlIlllIlIIlIll, final PacketWrapper llllllllllllllIllIIlIlllIlIIlllI) {
        if (llllllllllllllIllIIlIlllIlIIlIll.getProtocolInfo() == null || !llllllllllllllIllIIlIlllIlIIlIll.getProtocolInfo().getPipeline().contains(Protocol1_9To1_8.class)) {
            this.connections.remove(llllllllllllllIllIIlIlllIlIIlIll.getProtocolInfo().getUuid());
            return;
        }
        try {
            llllllllllllllIllIIlIlllIlIIlllI.scheduleSend(Protocol1_9To1_8.class);
        }
        catch (Exception llllllllllllllIllIIlIlllIlIlIlII) {
            llllllllllllllIllIIlIlllIlIlIlII.printStackTrace();
        }
    }
    
    @Override
    public BossBar hide() {
        this.setVisible(false);
        return this;
    }
    
    @Override
    public boolean isVisible() {
        return this.visible;
    }
    
    @Override
    public float getHealth() {
        return this.health;
    }
    
    @Override
    public BossColor getColor() {
        return this.color;
    }
    
    @Override
    public BossBar addPlayer(final UUID llllllllllllllIllIIlIlllllIlIlII) {
        final UserConnection llllllllllllllIllIIlIlllllIlIIll = Via.getManager().getConnectionManager().getConnectedClient(llllllllllllllIllIIlIlllllIlIlII);
        if (llllllllllllllIllIIlIlllllIlIIll != null) {
            this.addConnection(llllllllllllllIllIIlIlllllIlIIll);
        }
        return this;
    }
    
    public Set<BossFlag> getFlags() {
        return this.flags;
    }
    
    private int flagToBytes() {
        int llllllllllllllIllIIlIlllIIIlllll = 0;
        for (final BossFlag llllllllllllllIllIIlIlllIIlIIIIl : this.flags) {
            llllllllllllllIllIIlIlllIIIlllll |= llllllllllllllIllIIlIlllIIlIIIIl.getId();
        }
        return llllllllllllllIllIIlIlllIIIlllll;
    }
    
    @Override
    public BossBar setHealth(final float llllllllllllllIllIIlIllllllIlIlI) {
        Preconditions.checkArgument(llllllllllllllIllIIlIllllllIlIlI >= 0.0f && llllllllllllllIllIIlIllllllIlIlI <= 1.0f, (Object)String.valueOf(new StringBuilder().append("Health must be between 0 and 1. Input: ").append(llllllllllllllIllIIlIllllllIlIlI)));
        this.health = llllllllllllllIllIIlIllllllIlIlI;
        this.sendPacket(UpdateAction.UPDATE_HEALTH);
        return this;
    }
    
    private enum UpdateAction
    {
        UPDATE_HEALTH(2), 
        UPDATE_FLAGS(5), 
        REMOVE(1);
        
        private final /* synthetic */ int id;
        
        UPDATE_TITLE(3), 
        UPDATE_STYLE(4), 
        ADD(0);
        
        private UpdateAction(final int llllllllllllllIllIIlllIlIllIlIIl) {
            this.id = llllllllllllllIllIIlllIlIllIlIIl;
        }
        
        public int getId() {
            return this.id;
        }
    }
}
