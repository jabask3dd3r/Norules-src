package de.gerrygames.viarewind.protocol.protocol1_8to1_9.bossbar;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.type.types.version.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.*;
import de.gerrygames.viarewind.utils.*;
import com.viaversion.viaversion.api.protocol.*;
import java.util.*;
import com.viaversion.viaversion.api.legacy.bossbar.*;

public class WitherBossBar implements BossBar
{
    private /* synthetic */ double locZ;
    private /* synthetic */ double locX;
    private /* synthetic */ float health;
    private static /* synthetic */ int highestId;
    private /* synthetic */ UserConnection connection;
    private /* synthetic */ boolean visible;
    private final /* synthetic */ int entityId;
    private /* synthetic */ String title;
    private /* synthetic */ double locY;
    private final /* synthetic */ UUID uuid;
    
    public void setLocation(final double lllllllllllllIIllllIIIllIIIIIIlI, final double lllllllllllllIIllllIIIllIIIIIlIl, final double lllllllllllllIIllllIIIllIIIIIlII) {
        this.locX = lllllllllllllIIllllIIIllIIIIIIlI;
        this.locY = lllllllllllllIIllllIIIllIIIIIlIl;
        this.locZ = lllllllllllllIIllllIIIllIIIIIlII;
        this.updateLocation();
    }
    
    @Override
    public BossBar hide() {
        if (this.visible) {
            this.visible = false;
            this.despawnWither();
        }
        return this;
    }
    
    @Override
    public BossBar show() {
        if (!this.visible) {
            this.visible = true;
            this.spawnWither();
        }
        return this;
    }
    
    @Override
    public Set<UUID> getPlayers() {
        return Collections.singleton(this.connection.getProtocolInfo().getUuid());
    }
    
    @Override
    public BossBar removePlayer(final UUID lllllllllllllIIllllIIIllIIlIllIl) {
        throw new UnsupportedOperationException(String.valueOf(new StringBuilder().append(this.getClass().getName()).append(" is only for one UserConnection!")));
    }
    
    @Override
    public BossBar setStyle(final BossStyle lllllllllllllIIllllIIIllIIlllIIl) {
        throw new UnsupportedOperationException(String.valueOf(new StringBuilder().append(this.getClass().getName()).append(" does not support styles")));
    }
    
    @Override
    public BossBar addConnection(final UserConnection lllllllllllllIIllllIIIllIIllIIIl) {
        throw new UnsupportedOperationException(String.valueOf(new StringBuilder().append(this.getClass().getName()).append(" is only for one UserConnection!")));
    }
    
    @Override
    public String getTitle() {
        return this.title;
    }
    
    private void updateMetadata() {
        final PacketWrapper lllllllllllllIIllllIIIlIlllIllII = PacketWrapper.create(28, null, this.connection);
        lllllllllllllIIllllIIIlIlllIllII.write(Type.VAR_INT, this.entityId);
        final List<Metadata> lllllllllllllIIllllIIIlIlllIlIll = new ArrayList<Metadata>();
        lllllllllllllIIllllIIIlIlllIlIll.add(new Metadata(2, MetaType1_8.String, this.title));
        lllllllllllllIIllllIIIlIlllIlIll.add(new Metadata(6, MetaType1_8.Float, this.health * 300.0f));
        lllllllllllllIIllllIIIlIlllIllII.write(Types1_8.METADATA_LIST, lllllllllllllIIllllIIIlIlllIlIll);
        PacketUtil.sendPacket(lllllllllllllIIllllIIIlIlllIllII, Protocol1_8TO1_9.class, true, false);
    }
    
    @Override
    public Set<UserConnection> getConnections() {
        throw new UnsupportedOperationException(String.valueOf(new StringBuilder().append(this.getClass().getName()).append(" is only for one UserConnection!")));
    }
    
    @Override
    public UUID getId() {
        return this.uuid;
    }
    
    static {
        WitherBossBar.highestId = 2147473647;
    }
    
    private void updateLocation() {
        final PacketWrapper lllllllllllllIIllllIIIlIllllIIll = PacketWrapper.create(24, null, this.connection);
        lllllllllllllIIllllIIIlIllllIIll.write(Type.VAR_INT, this.entityId);
        lllllllllllllIIllllIIIlIllllIIll.write(Type.INT, (int)(this.locX * 32.0));
        lllllllllllllIIllllIIIlIllllIIll.write(Type.INT, (int)(this.locY * 32.0));
        lllllllllllllIIllllIIIlIllllIIll.write(Type.INT, (int)(this.locZ * 32.0));
        lllllllllllllIIllllIIIlIllllIIll.write(Type.BYTE, (Byte)0);
        lllllllllllllIIllllIIIlIllllIIll.write(Type.BYTE, (Byte)0);
        lllllllllllllIIllllIIIlIllllIIll.write(Type.BOOLEAN, false);
        PacketUtil.sendPacket(lllllllllllllIIllllIIIlIllllIIll, Protocol1_8TO1_9.class, true, false);
    }
    
    @Override
    public BossBar addFlag(final BossFlag lllllllllllllIIllllIIIllIIlIIlIl) {
        throw new UnsupportedOperationException(String.valueOf(new StringBuilder().append(this.getClass().getName()).append(" does not support flags")));
    }
    
    @Override
    public boolean isVisible() {
        return this.visible;
    }
    
    @Override
    public BossStyle getStyle() {
        return null;
    }
    
    @Override
    public BossColor getColor() {
        return null;
    }
    
    @Override
    public boolean hasFlag(final BossFlag lllllllllllllIIllllIIIllIIIllllI) {
        return false;
    }
    
    public void setPlayerLocation(double lllllllllllllIIllllIIIlIllIlIIII, double lllllllllllllIIllllIIIlIllIIllll, double lllllllllllllIIllllIIIlIllIIlllI, final float lllllllllllllIIllllIIIlIllIIllIl, final float lllllllllllllIIllllIIIlIllIIllII) {
        final double lllllllllllllIIllllIIIlIllIlIIll = Math.toRadians(lllllllllllllIIllllIIIlIllIIllIl);
        final double lllllllllllllIIllllIIIlIllIlIIlI = Math.toRadians(lllllllllllllIIllllIIIlIllIIllII);
        lllllllllllllIIllllIIIlIllIlIIII -= Math.cos(lllllllllllllIIllllIIIlIllIlIIlI) * Math.sin(lllllllllllllIIllllIIIlIllIlIIll) * 48.0;
        lllllllllllllIIllllIIIlIllIIllll -= Math.sin(lllllllllllllIIllllIIIlIllIlIIlI) * 48.0;
        lllllllllllllIIllllIIIlIllIIlllI += (short)(Math.cos(lllllllllllllIIllllIIIlIllIlIIlI) * Math.cos(lllllllllllllIIllllIIIlIllIlIIll) * 48.0);
        this.setLocation(lllllllllllllIIllllIIIlIllIlIIII, lllllllllllllIIllllIIIlIllIIllll, lllllllllllllIIllllIIIlIllIIlllI);
    }
    
    @Override
    public float getHealth() {
        return this.health;
    }
    
    private void despawnWither() {
        final PacketWrapper lllllllllllllIIllllIIIlIlllIIlII = PacketWrapper.create(19, null, this.connection);
        lllllllllllllIIllllIIIlIlllIIlII.write(Type.VAR_INT_ARRAY_PRIMITIVE, new int[] { this.entityId });
        PacketUtil.sendPacket(lllllllllllllIIllllIIIlIlllIIlII, Protocol1_8TO1_9.class, true, false);
    }
    
    @Override
    public BossBar addPlayer(final UUID lllllllllllllIIllllIIIllIIllIlIl) {
        throw new UnsupportedOperationException(String.valueOf(new StringBuilder().append(this.getClass().getName()).append(" is only for one UserConnection!")));
    }
    
    @Override
    public BossBar removeFlag(final BossFlag lllllllllllllIIllllIIIllIIlIIIIl) {
        throw new UnsupportedOperationException(String.valueOf(new StringBuilder().append(this.getClass().getName()).append(" does not support flags")));
    }
    
    private void spawnWither() {
        final PacketWrapper lllllllllllllIIllllIIIlIlllllIll = PacketWrapper.create(15, null, this.connection);
        lllllllllllllIIllllIIIlIlllllIll.write(Type.VAR_INT, this.entityId);
        lllllllllllllIIllllIIIlIlllllIll.write(Type.UNSIGNED_BYTE, (Short)64);
        lllllllllllllIIllllIIIlIlllllIll.write(Type.INT, (int)(this.locX * 32.0));
        lllllllllllllIIllllIIIlIlllllIll.write(Type.INT, (int)(this.locY * 32.0));
        lllllllllllllIIllllIIIlIlllllIll.write(Type.INT, (int)(this.locZ * 32.0));
        lllllllllllllIIllllIIIlIlllllIll.write(Type.BYTE, (Byte)0);
        lllllllllllllIIllllIIIlIlllllIll.write(Type.BYTE, (Byte)0);
        lllllllllllllIIllllIIIlIlllllIll.write(Type.BYTE, (Byte)0);
        lllllllllllllIIllllIIIlIlllllIll.write(Type.SHORT, (Short)0);
        lllllllllllllIIllllIIIlIlllllIll.write(Type.SHORT, (Short)0);
        lllllllllllllIIllllIIIlIlllllIll.write(Type.SHORT, (Short)0);
        final List<Metadata> lllllllllllllIIllllIIIlIlllllIlI = new ArrayList<Metadata>();
        lllllllllllllIIllllIIIlIlllllIlI.add(new Metadata(0, MetaType1_8.Byte, 32));
        lllllllllllllIIllllIIIlIlllllIlI.add(new Metadata(2, MetaType1_8.String, this.title));
        lllllllllllllIIllllIIIlIlllllIlI.add(new Metadata(3, MetaType1_8.Byte, 1));
        lllllllllllllIIllllIIIlIlllllIlI.add(new Metadata(6, MetaType1_8.Float, this.health * 300.0f));
        lllllllllllllIIllllIIIlIlllllIll.write(Types1_8.METADATA_LIST, lllllllllllllIIllllIIIlIlllllIlI);
        PacketUtil.sendPacket(lllllllllllllIIllllIIIlIlllllIll, Protocol1_8TO1_9.class, true, false);
    }
    
    @Override
    public BossBar setTitle(final String lllllllllllllIIllllIIIllIlIIlIll) {
        this.title = lllllllllllllIIllllIIIllIlIIlIll;
        if (this.visible) {
            this.updateMetadata();
        }
        return this;
    }
    
    @Override
    public BossBar removeConnection(final UserConnection lllllllllllllIIllllIIIllIIlIlIIl) {
        throw new UnsupportedOperationException(String.valueOf(new StringBuilder().append(this.getClass().getName()).append(" is only for one UserConnection!")));
    }
    
    public WitherBossBar(final UserConnection lllllllllllllIIllllIIIllIlIlllII, final UUID lllllllllllllIIllllIIIllIlIllIll, final String lllllllllllllIIllllIIIllIlIllIlI, final float lllllllllllllIIllllIIIllIlIlIlII) {
        this.visible = false;
        this.entityId = WitherBossBar.highestId++;
        this.connection = lllllllllllllIIllllIIIllIlIlllII;
        this.uuid = lllllllllllllIIllllIIIllIlIllIll;
        this.title = lllllllllllllIIllllIIIllIlIllIlI;
        this.health = lllllllllllllIIllllIIIllIlIlIlII;
    }
    
    @Override
    public BossBar setHealth(final float lllllllllllllIIllllIIIllIlIIIlII) {
        this.health = lllllllllllllIIllllIIIllIlIIIlII;
        if (this.health <= 0.0f) {
            this.health = 1.0E-4f;
        }
        if (this.visible) {
            this.updateMetadata();
        }
        return this;
    }
    
    @Override
    public BossBar setColor(final BossColor lllllllllllllIIllllIIIllIIlllllI) {
        throw new UnsupportedOperationException(String.valueOf(new StringBuilder().append(this.getClass().getName()).append(" does not support color")));
    }
}
