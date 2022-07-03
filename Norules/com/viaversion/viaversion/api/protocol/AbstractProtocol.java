package com.viaversion.viaversion.api.protocol;

import com.viaversion.viaversion.exception.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.google.common.base.*;
import java.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.api.*;
import java.util.logging.*;

public abstract class AbstractProtocol<C1 extends ClientboundPacketType, C2 extends ClientboundPacketType, S1 extends ServerboundPacketType, S2 extends ServerboundPacketType> implements Protocol<C1, C2, S1, S2>
{
    protected final /* synthetic */ Class<C1> oldClientboundPacketEnum;
    private /* synthetic */ boolean initialized;
    private final /* synthetic */ Map<Packet, ProtocolPacket> serverbound;
    private final /* synthetic */ Map<Class<?>, Object> storedObjects;
    protected final /* synthetic */ Class<S1> oldServerboundPacketEnum;
    private final /* synthetic */ Map<Packet, ProtocolPacket> clientbound;
    protected final /* synthetic */ Class<C2> newClientboundPacketEnum;
    protected final /* synthetic */ Class<S2> newServerboundPacketEnum;
    
    @Override
    public void transform(final Direction lllllllllllllllIIllIllIIllIlIIlI, final State lllllllllllllllIIllIllIIllIllIlI, final PacketWrapper lllllllllllllllIIllIllIIllIlIIII) throws Exception {
        final Packet lllllllllllllllIIllIllIIllIllIII = new Packet(lllllllllllllllIIllIllIIllIllIlI, lllllllllllllllIIllIllIIllIlIIII.getId());
        final Map<Packet, ProtocolPacket> lllllllllllllllIIllIllIIllIlIlll = (lllllllllllllllIIllIllIIllIlIIlI == Direction.CLIENTBOUND) ? this.clientbound : this.serverbound;
        final ProtocolPacket lllllllllllllllIIllIllIIllIlIllI = lllllllllllllllIIllIllIIllIlIlll.get(lllllllllllllllIIllIllIIllIllIII);
        if (lllllllllllllllIIllIllIIllIlIllI == null) {
            return;
        }
        final int lllllllllllllllIIllIllIIllIlIlIl = lllllllllllllllIIllIllIIllIlIIII.getId();
        if (lllllllllllllllIIllIllIIllIlIllI.isMappedOverTypes()) {
            lllllllllllllllIIllIllIIllIlIIII.setPacketType(lllllllllllllllIIllIllIIllIlIllI.getMappedPacketType());
        }
        else {
            final int lllllllllllllllIIllIllIIllIllllI = (lllllllllllllllIIllIllIIllIlIIlI == Direction.CLIENTBOUND) ? lllllllllllllllIIllIllIIllIlIllI.getNewId() : lllllllllllllllIIllIllIIllIlIllI.getOldId();
            if (lllllllllllllllIIllIllIIllIlIlIl != lllllllllllllllIIllIllIIllIllllI) {
                lllllllllllllllIIllIllIIllIlIIII.setId(lllllllllllllllIIllIllIIllIllllI);
            }
        }
        final PacketRemapper lllllllllllllllIIllIllIIllIlIlII = lllllllllllllllIIllIllIIllIlIllI.getRemapper();
        if (lllllllllllllllIIllIllIIllIlIlII != null) {
            try {
                lllllllllllllllIIllIllIIllIlIlII.remap(lllllllllllllllIIllIllIIllIlIIII);
            }
            catch (InformativeException lllllllllllllllIIllIllIIllIlllIl) {
                this.throwRemapError(lllllllllllllllIIllIllIIllIlIIlI, lllllllllllllllIIllIllIIllIllIlI, lllllllllllllllIIllIllIIllIlIlIl, lllllllllllllllIIllIllIIllIlIIII.getId(), lllllllllllllllIIllIllIIllIlllIl);
                return;
            }
            if (lllllllllllllllIIllIllIIllIlIIII.isCancelled()) {
                throw CancelException.generate();
            }
        }
    }
    
    private void checkPacketType(final PacketType lllllllllllllllIIllIllIIlIlIIIlI, final boolean lllllllllllllllIIllIllIIlIlIIIll) {
        if (!lllllllllllllllIIllIllIIlIlIIIll) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Packet type ").append(lllllllllllllllIIllIllIIlIlIIIlI).append(" in ").append(lllllllllllllllIIllIllIIlIlIIIlI.getClass().getSimpleName()).append(" is taken from the wrong enum")));
        }
    }
    
    @Override
    public void cancelServerbound(final State lllllllllllllllIIllIllIllIlIlIlI, final int lllllllllllllllIIllIllIllIlIllIl, final int lllllllllllllllIIllIllIllIlIlIII) {
        this.registerServerbound(lllllllllllllllIIllIllIllIlIlIlI, lllllllllllllllIIllIllIllIlIllIl, lllllllllllllllIIllIllIllIlIlIII, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(PacketWrapper::cancel);
            }
        });
    }
    
    protected void registerServerboundChannelIdChanges() {
        final S1[] lllllllllllllllIIllIllIllllIIIll = this.oldServerboundPacketEnum.getEnumConstants();
        final Map<String, S1> lllllllllllllllIIllIllIllllIIIlI = new HashMap<String, S1>(lllllllllllllllIIllIllIllllIIIll.length);
        double lllllllllllllllIIllIllIlllIllllI = (Object)lllllllllllllllIIllIllIllllIIIll;
        char lllllllllllllllIIllIllIlllIlllIl = (char)lllllllllllllllIIllIllIlllIllllI.length;
        for (float lllllllllllllllIIllIllIlllIlllII = 0; lllllllllllllllIIllIllIlllIlllII < lllllllllllllllIIllIllIlllIlllIl; ++lllllllllllllllIIllIllIlllIlllII) {
            final S1 lllllllllllllllIIllIllIllllIIlll = lllllllllllllllIIllIllIlllIllllI[lllllllllllllllIIllIllIlllIlllII];
            lllllllllllllllIIllIllIllllIIIlI.put(lllllllllllllllIIllIllIllllIIlll.getName(), lllllllllllllllIIllIllIllllIIlll);
        }
        lllllllllllllllIIllIllIlllIllllI = (double)(Object)this.newServerboundPacketEnum.getEnumConstants();
        lllllllllllllllIIllIllIlllIlllIl = (char)lllllllllllllllIIllIllIlllIllllI.length;
        for (float lllllllllllllllIIllIllIlllIlllII = 0; lllllllllllllllIIllIllIlllIlllII < lllllllllllllllIIllIllIlllIlllIl; ++lllllllllllllllIIllIllIlllIlllII) {
            final S2 lllllllllllllllIIllIllIllllIIlIl = lllllllllllllllIIllIllIlllIllllI[lllllllllllllllIIllIllIlllIlllII];
            final S1 lllllllllllllllIIllIllIllllIIllI = lllllllllllllllIIllIllIllllIIIlI.get(lllllllllllllllIIllIllIllllIIlIl.getName());
            if (lllllllllllllllIIllIllIllllIIllI == null) {
                Preconditions.checkArgument(this.hasRegisteredServerbound(lllllllllllllllIIllIllIllllIIlIl), (Object)String.valueOf(new StringBuilder().append("Packet ").append(lllllllllllllllIIllIllIllllIIlIl).append(" in ").append(this.getClass().getSimpleName()).append(" has no mapping - it needs to be manually cancelled or remapped!")));
            }
            else if (!this.hasRegisteredServerbound(lllllllllllllllIIllIllIllllIIlIl)) {
                this.registerServerbound(lllllllllllllllIIllIllIllllIIlIl, lllllllllllllllIIllIllIllllIIllI);
            }
        }
    }
    
    @Override
    public void registerClientbound(final C1 lllllllllllllllIIllIllIlIllllllI, final PacketRemapper lllllllllllllllIIllIllIlIllllIIl) {
        this.checkPacketType(lllllllllllllllIIllIllIlIllllllI, this.oldClientboundPacketEnum == null || lllllllllllllllIIllIllIlIllllllI.getClass() == this.oldClientboundPacketEnum);
        final C2 lllllllllllllllIIllIllIlIlllllII = (C2)((this.oldClientboundPacketEnum == this.newClientboundPacketEnum) ? lllllllllllllllIIllIllIlIllllllI : ((C2)Arrays.stream(this.newClientboundPacketEnum.getEnumConstants()).filter(lllllllllllllllIIllIllIIlIIIIIll -> lllllllllllllllIIllIllIIlIIIIIll.getName().equals(lllllllllllllllIIllIllIlIllllllI.getName())).findAny().orElse(null)));
        Preconditions.checkNotNull((Object)lllllllllllllllIIllIllIlIlllllII, (Object)String.valueOf(new StringBuilder().append("Packet type ").append(lllllllllllllllIIllIllIlIllllllI).append(" in ").append(lllllllllllllllIIllIllIlIllllllI.getClass().getSimpleName()).append(" could not be automatically mapped!")));
        this.registerClientbound(lllllllllllllllIIllIllIlIllllllI, lllllllllllllllIIllIllIlIlllllII, lllllllllllllllIIllIllIlIllllIIl);
    }
    
    protected void addEntityTracker(final UserConnection lllllllllllllllIIllIllIlllIIllIl, final EntityTracker lllllllllllllllIIllIllIlllIIllll) {
        lllllllllllllllIIllIllIlllIIllIl.addEntityTracker(this.getClass(), lllllllllllllllIIllIllIlllIIllll);
    }
    
    protected void registerClientboundChannelIdChanges() {
        final C2[] lllllllllllllllIIllIllIllllllIIl = this.newClientboundPacketEnum.getEnumConstants();
        final Map<String, C2> lllllllllllllllIIllIllIllllllIII = new HashMap<String, C2>(lllllllllllllllIIllIllIllllllIIl.length);
        float lllllllllllllllIIllIllIlllllIlII = (Object)lllllllllllllllIIllIllIllllllIIl;
        String lllllllllllllllIIllIllIlllllIIll = (String)lllllllllllllllIIllIllIlllllIlII.length;
        for (float lllllllllllllllIIllIllIlllllIIlI = 0; lllllllllllllllIIllIllIlllllIIlI < lllllllllllllllIIllIllIlllllIIll; ++lllllllllllllllIIllIllIlllllIIlI) {
            final C2 lllllllllllllllIIllIllIlllllllIl = lllllllllllllllIIllIllIlllllIlII[lllllllllllllllIIllIllIlllllIIlI];
            lllllllllllllllIIllIllIllllllIII.put(lllllllllllllllIIllIllIlllllllIl.getName(), lllllllllllllllIIllIllIlllllllIl);
        }
        lllllllllllllllIIllIllIlllllIlII = (float)(Object)this.oldClientboundPacketEnum.getEnumConstants();
        lllllllllllllllIIllIllIlllllIIll = (String)lllllllllllllllIIllIllIlllllIlII.length;
        for (float lllllllllllllllIIllIllIlllllIIlI = 0; lllllllllllllllIIllIllIlllllIIlI < lllllllllllllllIIllIllIlllllIIll; ++lllllllllllllllIIllIllIlllllIIlI) {
            final C1 lllllllllllllllIIllIllIllllllIll = lllllllllllllllIIllIllIlllllIlII[lllllllllllllllIIllIllIlllllIIlI];
            final C2 lllllllllllllllIIllIllIlllllllII = lllllllllllllllIIllIllIllllllIII.get(lllllllllllllllIIllIllIllllllIll.getName());
            if (lllllllllllllllIIllIllIlllllllII == null) {
                Preconditions.checkArgument(this.hasRegisteredClientbound(lllllllllllllllIIllIllIllllllIll), (Object)String.valueOf(new StringBuilder().append("Packet ").append(lllllllllllllllIIllIllIllllllIll).append(" in ").append(this.getClass().getSimpleName()).append(" has no mapping - it needs to be manually cancelled or remapped!")));
            }
            else if (!this.hasRegisteredClientbound(lllllllllllllllIIllIllIllllllIll)) {
                this.registerClientbound(lllllllllllllllIIllIllIllllllIll, lllllllllllllllIIllIllIlllllllII);
            }
        }
    }
    
    @Override
    public final void loadMappingData() {
        this.getMappingData().load();
        this.onMappingDataLoaded();
    }
    
    @Override
    public void registerServerbound(final S2 lllllllllllllllIIllIllIlIlIllIIl, final PacketRemapper lllllllllllllllIIllIllIlIlIlllII) {
        this.checkPacketType(lllllllllllllllIIllIllIlIlIllIIl, this.newServerboundPacketEnum == null || lllllllllllllllIIllIllIlIlIllIIl.getClass() == this.newServerboundPacketEnum);
        final S1 lllllllllllllllIIllIllIlIlIllIll = (S1)((this.oldServerboundPacketEnum == this.newServerboundPacketEnum) ? lllllllllllllllIIllIllIlIlIllIIl : ((S1)Arrays.stream(this.oldServerboundPacketEnum.getEnumConstants()).filter(lllllllllllllllIIllIllIIlIIIlIll -> lllllllllllllllIIllIllIIlIIIlIll.getName().equals(lllllllllllllllIIllIllIlIlIllIIl.getName())).findAny().orElse(null)));
        Preconditions.checkNotNull((Object)lllllllllllllllIIllIllIlIlIllIll, (Object)String.valueOf(new StringBuilder().append("Packet type ").append(lllllllllllllllIIllIllIlIlIllIIl).append(" in ").append(lllllllllllllllIIllIllIlIlIllIIl.getClass().getSimpleName()).append(" could not be automatically mapped!")));
        this.registerServerbound(lllllllllllllllIIllIllIlIlIllIIl, lllllllllllllllIIllIllIlIlIllIll, lllllllllllllllIIllIllIlIlIlllII);
    }
    
    protected void onMappingDataLoaded() {
    }
    
    protected AbstractProtocol(final Class<C1> lllllllllllllllIIllIlllIIIIIllII, final Class<C2> lllllllllllllllIIllIlllIIIIIlIll, final Class<S1> lllllllllllllllIIllIlllIIIIIlIlI, final Class<S2> lllllllllllllllIIllIlllIIIIIlIIl) {
        this.serverbound = new HashMap<Packet, ProtocolPacket>();
        this.clientbound = new HashMap<Packet, ProtocolPacket>();
        this.storedObjects = new HashMap<Class<?>, Object>();
        this.oldClientboundPacketEnum = lllllllllllllllIIllIlllIIIIIllII;
        this.newClientboundPacketEnum = lllllllllllllllIIllIlllIIIIIlIll;
        this.oldServerboundPacketEnum = lllllllllllllllIIllIlllIIIIIlIlI;
        this.newServerboundPacketEnum = lllllllllllllllIIllIlllIIIIIlIIl;
    }
    
    private String toNiceHex(final int lllllllllllllllIIllIllIIlIlIlIll) {
        final String lllllllllllllllIIllIllIIlIlIlIlI = Integer.toHexString(lllllllllllllllIIllIllIIlIlIlIll).toUpperCase();
        return String.valueOf(new StringBuilder().append((lllllllllllllllIIllIllIIlIlIlIlI.length() == 1) ? "0x0" : "0x").append(lllllllllllllllIIllIllIIlIlIlIlI));
    }
    
    @Override
    public void registerClientbound(final State lllllllllllllllIIllIllIllIIIlIlI, final int lllllllllllllllIIllIllIllIIlIIIl, final int lllllllllllllllIIllIllIllIIIlIII, final PacketRemapper lllllllllllllllIIllIllIllIIIllll, final boolean lllllllllllllllIIllIllIllIIIIllI) {
        final ProtocolPacket lllllllllllllllIIllIllIllIIIllIl = new ProtocolPacket(lllllllllllllllIIllIllIllIIIlIlI, lllllllllllllllIIllIllIllIIlIIIl, lllllllllllllllIIllIllIllIIIlIII, lllllllllllllllIIllIllIllIIIllll);
        final Packet lllllllllllllllIIllIllIllIIIllII = new Packet(lllllllllllllllIIllIllIllIIIlIlI, lllllllllllllllIIllIllIllIIlIIIl);
        if (!lllllllllllllllIIllIllIllIIIIllI && this.clientbound.containsKey(lllllllllllllllIIllIllIllIIIllII)) {
            Via.getPlatform().getLogger().log(Level.WARNING, String.valueOf(new StringBuilder().append(lllllllllllllllIIllIllIllIIIllII).append(" already registered! If override is intentional, set override to true. Stacktrace: ")), new Exception());
        }
        this.clientbound.put(lllllllllllllllIIllIllIllIIIllII, lllllllllllllllIIllIllIllIIIllIl);
    }
    
    @Override
    public boolean hasMappingDataToLoad() {
        return this.getMappingData() != null;
    }
    
    protected void registerPackets() {
    }
    
    private void throwRemapError(final Direction lllllllllllllllIIllIllIIlIllllIl, final State lllllllllllllllIIllIllIIlIllllII, final int lllllllllllllllIIllIllIIlIllIlII, final int lllllllllllllllIIllIllIIlIllIIll, final InformativeException lllllllllllllllIIllIllIIlIlllIIl) throws InformativeException {
        if (lllllllllllllllIIllIllIIlIllllII == State.HANDSHAKE) {
            throw lllllllllllllllIIllIllIIlIlllIIl;
        }
        final Class<? extends PacketType> lllllllllllllllIIllIllIIlIlllIII = (Class<? extends PacketType>)((lllllllllllllllIIllIllIIlIllllII == State.PLAY) ? ((lllllllllllllllIIllIllIIlIllllIl == Direction.CLIENTBOUND) ? this.oldClientboundPacketEnum : this.newServerboundPacketEnum) : null);
        if (lllllllllllllllIIllIllIIlIlllIII != null) {
            final PacketType[] lllllllllllllllIIllIllIIllIIIIII = (PacketType[])lllllllllllllllIIllIllIIlIlllIII.getEnumConstants();
            final PacketType lllllllllllllllIIllIllIIlIllllll = (lllllllllllllllIIllIllIIlIllIlII < lllllllllllllllIIllIllIIllIIIIII.length && lllllllllllllllIIllIllIIlIllIlII >= 0) ? lllllllllllllllIIllIllIIllIIIIII[lllllllllllllllIIllIllIIlIllIlII] : null;
            Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("ERROR IN ").append(this.getClass().getSimpleName()).append(" IN REMAP OF ").append(lllllllllllllllIIllIllIIlIllllll).append(" (").append(this.toNiceHex(lllllllllllllllIIllIllIIlIllIlII)).append(")")));
        }
        else {
            Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("ERROR IN ").append(this.getClass().getSimpleName()).append(" IN REMAP OF ").append(this.toNiceHex(lllllllllllllllIIllIllIIlIllIlII)).append("->").append(this.toNiceHex(lllllllllllllllIIllIllIIlIllIIll))));
        }
        throw lllllllllllllllIIllIllIIlIlllIIl;
    }
    
    @Override
    public void registerClientbound(final C1 lllllllllllllllIIllIllIlIllIllII, final C2 lllllllllllllllIIllIllIlIllIlIll, final PacketRemapper lllllllllllllllIIllIllIlIllIllll, final boolean lllllllllllllllIIllIllIlIllIlIIl) {
        this.register(this.clientbound, lllllllllllllllIIllIllIlIllIllII, lllllllllllllllIIllIllIlIllIlIll, this.oldClientboundPacketEnum, this.newClientboundPacketEnum, lllllllllllllllIIllIllIlIllIllll, lllllllllllllllIIllIllIlIllIlIIl);
    }
    
    @Override
    public boolean hasRegisteredServerbound(final State lllllllllllllllIIllIllIIlllIllll, final int lllllllllllllllIIllIllIIlllIlIlI) {
        final Packet lllllllllllllllIIllIllIIlllIllIl = new Packet(lllllllllllllllIIllIllIIlllIllll, lllllllllllllllIIllIllIIlllIlIlI);
        return this.serverbound.containsKey(lllllllllllllllIIllIllIIlllIllIl);
    }
    
    @Override
    public boolean hasRegisteredClientbound(final State lllllllllllllllIIllIllIIlllllIll, final int lllllllllllllllIIllIllIIllllIllI) {
        final Packet lllllllllllllllIIllIllIIlllllIIl = new Packet(lllllllllllllllIIllIllIIlllllIll, lllllllllllllllIIllIllIIllllIllI);
        return this.clientbound.containsKey(lllllllllllllllIIllIllIIlllllIIl);
    }
    
    @Override
    public void cancelClientbound(final C1 lllllllllllllllIIllIllIlIllIIIll) {
        this.registerClientbound(lllllllllllllllIIllIllIlIllIIIll, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(PacketWrapper::cancel);
            }
        });
    }
    
    @Override
    public boolean hasRegisteredServerbound(final S2 lllllllllllllllIIllIllIlIIIIIlll) {
        return this.hasRegisteredServerbound(lllllllllllllllIIllIllIlIIIIIlll.state(), lllllllllllllllIIllIllIlIIIIIlll.getId());
    }
    
    @Override
    public <T> T get(final Class<T> lllllllllllllllIIllIllIIlIIllIll) {
        return (T)this.storedObjects.get(lllllllllllllllIIllIllIIlIIllIll);
    }
    
    @Override
    public void put(final Object lllllllllllllllIIllIllIIlIIlIlIl) {
        this.storedObjects.put(lllllllllllllllIIllIllIIlIIlIlIl.getClass(), lllllllllllllllIIllIllIIlIIlIlIl);
    }
    
    @Override
    public final void initialize() {
        Preconditions.checkArgument(!this.initialized);
        this.initialized = true;
        this.registerPackets();
        if (this.oldClientboundPacketEnum != null && this.newClientboundPacketEnum != null && this.oldClientboundPacketEnum != this.newClientboundPacketEnum) {
            this.registerClientboundChannelIdChanges();
        }
        if (this.oldServerboundPacketEnum != null && this.newServerboundPacketEnum != null && this.oldServerboundPacketEnum != this.newServerboundPacketEnum) {
            this.registerServerboundChannelIdChanges();
        }
    }
    
    @Override
    public void registerServerbound(final S2 lllllllllllllllIIllIllIlIlIlIIII, final S1 lllllllllllllllIIllIllIlIlIIllll, final PacketRemapper lllllllllllllllIIllIllIlIlIIlllI, final boolean lllllllllllllllIIllIllIlIlIIllIl) {
        this.register(this.serverbound, lllllllllllllllIIllIllIlIlIlIIII, lllllllllllllllIIllIllIlIlIIllll, this.newServerboundPacketEnum, this.oldServerboundPacketEnum, lllllllllllllllIIllIllIlIlIIlllI, lllllllllllllllIIllIllIlIlIIllIl);
    }
    
    @Override
    public void cancelClientbound(final State lllllllllllllllIIllIllIllIIllllI, final int lllllllllllllllIIllIllIllIIlllIl, final int lllllllllllllllIIllIllIllIIlllII) {
        this.registerClientbound(lllllllllllllllIIllIllIllIIllllI, lllllllllllllllIIllIllIllIIlllIl, lllllllllllllllIIllIllIllIIlllII, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(PacketWrapper::cancel);
            }
        });
    }
    
    protected AbstractProtocol() {
        this(null, null, null, null);
    }
    
    @Override
    public boolean hasRegisteredClientbound(final C1 lllllllllllllllIIllIllIlIIIlIIlI) {
        return this.hasRegisteredClientbound(lllllllllllllllIIllIllIlIIIlIIlI.state(), lllllllllllllllIIllIllIlIIIlIIlI.getId());
    }
    
    @Override
    public void registerServerbound(final State lllllllllllllllIIllIllIlllIIIIlI, final int lllllllllllllllIIllIllIllIlllIIl, final int lllllllllllllllIIllIllIllIlllIII, final PacketRemapper lllllllllllllllIIllIllIllIllllll, final boolean lllllllllllllllIIllIllIllIlllllI) {
        final ProtocolPacket lllllllllllllllIIllIllIllIllllIl = new ProtocolPacket(lllllllllllllllIIllIllIlllIIIIlI, lllllllllllllllIIllIllIllIlllIIl, lllllllllllllllIIllIllIllIlllIII, lllllllllllllllIIllIllIllIllllll);
        final Packet lllllllllllllllIIllIllIllIllllII = new Packet(lllllllllllllllIIllIllIlllIIIIlI, lllllllllllllllIIllIllIllIlllIII);
        if (!lllllllllllllllIIllIllIllIlllllI && this.serverbound.containsKey(lllllllllllllllIIllIllIllIllllII)) {
            Via.getPlatform().getLogger().log(Level.WARNING, String.valueOf(new StringBuilder().append(lllllllllllllllIIllIllIllIllllII).append(" already registered! If this override is intentional, set override to true. Stacktrace: ")), new Exception());
        }
        this.serverbound.put(lllllllllllllllIIllIllIllIllllII, lllllllllllllllIIllIllIllIllllIl);
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("Protocol:").append(this.getClass().getSimpleName()));
    }
    
    @Override
    public void cancelServerbound(final S2 lllllllllllllllIIllIllIlIlIIIlII) {
        this.registerServerbound(lllllllllllllllIIllIllIlIlIIIlII, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(PacketWrapper::cancel);
            }
        });
    }
    
    private void register(final Map<Packet, ProtocolPacket> lllllllllllllllIIllIllIlIIlIlIll, final PacketType lllllllllllllllIIllIllIlIIlIlIIl, final PacketType lllllllllllllllIIllIllIlIIlIlIII, final Class<? extends PacketType> lllllllllllllllIIllIllIlIIllIIll, final Class<? extends PacketType> lllllllllllllllIIllIllIlIIllIIlI, final PacketRemapper lllllllllllllllIIllIllIlIIllIIIl, final boolean lllllllllllllllIIllIllIlIIlIIIlI) {
        this.checkPacketType(lllllllllllllllIIllIllIlIIlIlIIl, lllllllllllllllIIllIllIlIIllIIll == null || lllllllllllllllIIllIllIlIIlIlIIl.getClass() == lllllllllllllllIIllIllIlIIllIIll);
        this.checkPacketType(lllllllllllllllIIllIllIlIIlIlIII, lllllllllllllllIIllIllIlIIlIlIII == null || lllllllllllllllIIllIllIlIIllIIlI == null || lllllllllllllllIIllIllIlIIlIlIII.getClass() == lllllllllllllllIIllIllIlIIllIIlI);
        Preconditions.checkArgument(lllllllllllllllIIllIllIlIIlIlIII == null || lllllllllllllllIIllIllIlIIlIlIIl.state() == lllllllllllllllIIllIllIlIIlIlIII.state(), (Object)"Packet type state does not match mapped packet type state");
        final ProtocolPacket lllllllllllllllIIllIllIlIIlIllll = new ProtocolPacket(lllllllllllllllIIllIllIlIIlIlIIl.state(), lllllllllllllllIIllIllIlIIlIlIIl, lllllllllllllllIIllIllIlIIlIlIII, lllllllllllllllIIllIllIlIIllIIIl);
        final Packet lllllllllllllllIIllIllIlIIlIlllI = new Packet(lllllllllllllllIIllIllIlIIlIlIIl.state(), lllllllllllllllIIllIllIlIIlIlIIl.getId());
        if (!lllllllllllllllIIllIllIlIIlIIIlI && lllllllllllllllIIllIllIlIIlIlIll.containsKey(lllllllllllllllIIllIllIlIIlIlllI)) {
            Via.getPlatform().getLogger().log(Level.WARNING, String.valueOf(new StringBuilder().append(lllllllllllllllIIllIllIlIIlIlllI).append(" already registered! If override is intentional, set override to true. Stacktrace: ")), new Exception());
        }
        lllllllllllllllIIllIllIlIIlIlIll.put(lllllllllllllllIIllIllIlIIlIlllI, lllllllllllllllIIllIllIlIIlIllll);
    }
    
    public static final class Packet
    {
        private final /* synthetic */ State state;
        private final /* synthetic */ int packetId;
        
        @Override
        public boolean equals(final Object lllllllllllllIIlllIIlIIIIIllIIIl) {
            if (this == lllllllllllllIIlllIIlIIIIIllIIIl) {
                return true;
            }
            if (lllllllllllllIIlllIIlIIIIIllIIIl == null || this.getClass() != lllllllllllllIIlllIIlIIIIIllIIIl.getClass()) {
                return false;
            }
            final Packet lllllllllllllIIlllIIlIIIIIllIIII = (Packet)lllllllllllllIIlllIIlIIIIIllIIIl;
            return this.packetId == lllllllllllllIIlllIIlIIIIIllIIII.packetId && this.state == lllllllllllllIIlllIIlIIIIIllIIII.state;
        }
        
        public State getState() {
            return this.state;
        }
        
        public int getPacketId() {
            return this.packetId;
        }
        
        public Packet(final State lllllllllllllIIlllIIlIIIIlIIlIIl, final int lllllllllllllIIlllIIlIIIIlIIllII) {
            this.state = lllllllllllllIIlllIIlIIIIlIIlIIl;
            this.packetId = lllllllllllllIIlllIIlIIIIlIIllII;
        }
        
        @Override
        public int hashCode() {
            int lllllllllllllIIlllIIlIIIIIIlIIll = (this.state != null) ? this.state.hashCode() : 0;
            lllllllllllllIIlllIIlIIIIIIlIIll = 31 * lllllllllllllIIlllIIlIIIIIIlIIll + this.packetId;
            return lllllllllllllIIlllIIlIIIIIIlIIll;
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append("Packet{state=").append(this.state).append(", packetId=").append(this.packetId).append('}'));
        }
    }
    
    public static final class ProtocolPacket
    {
        private final /* synthetic */ PacketType mappedPacketType;
        private final /* synthetic */ PacketRemapper remapper;
        private final /* synthetic */ int oldId;
        private final /* synthetic */ State state;
        private final /* synthetic */ PacketType unmappedPacketType;
        private final /* synthetic */ int newId;
        
        public PacketType getMappedPacketType() {
            return this.mappedPacketType;
        }
        
        public boolean isMappedOverTypes() {
            return this.unmappedPacketType != null;
        }
        
        public PacketRemapper getRemapper() {
            return this.remapper;
        }
        
        public ProtocolPacket(final State llllllllllllllIIIIlIlIlllIIIllll, final PacketType llllllllllllllIIIIlIlIlllIIIlllI, final PacketType llllllllllllllIIIIlIlIlllIIlIIlI, final PacketRemapper llllllllllllllIIIIlIlIlllIIIllII) {
            this.state = llllllllllllllIIIIlIlIlllIIIllll;
            this.unmappedPacketType = llllllllllllllIIIIlIlIlllIIIlllI;
            if (llllllllllllllIIIIlIlIlllIIIlllI.direction() == Direction.CLIENTBOUND) {
                this.oldId = llllllllllllllIIIIlIlIlllIIIlllI.getId();
                this.newId = ((llllllllllllllIIIIlIlIlllIIlIIlI != null) ? llllllllllllllIIIIlIlIlllIIlIIlI.getId() : -1);
            }
            else {
                this.oldId = ((llllllllllllllIIIIlIlIlllIIlIIlI != null) ? llllllllllllllIIIIlIlIlllIIlIIlI.getId() : -1);
                this.newId = llllllllllllllIIIIlIlIlllIIIlllI.getId();
            }
            this.mappedPacketType = llllllllllllllIIIIlIlIlllIIlIIlI;
            this.remapper = llllllllllllllIIIIlIlIlllIIIllII;
        }
        
        public State getState() {
            return this.state;
        }
        
        @Deprecated
        public int getOldId() {
            return this.oldId;
        }
        
        @Deprecated
        public ProtocolPacket(final State llllllllllllllIIIIlIlIlllIIllllI, final int llllllllllllllIIIIlIlIlllIIlllIl, final int llllllllllllllIIIIlIlIlllIlIIIIl, final PacketRemapper llllllllllllllIIIIlIlIlllIIllIll) {
            this.state = llllllllllllllIIIIlIlIlllIIllllI;
            this.oldId = llllllllllllllIIIIlIlIlllIIlllIl;
            this.newId = llllllllllllllIIIIlIlIlllIlIIIIl;
            this.remapper = llllllllllllllIIIIlIlIlllIIllIll;
            this.unmappedPacketType = null;
            this.mappedPacketType = null;
        }
        
        public PacketType getUnmappedPacketType() {
            return this.unmappedPacketType;
        }
        
        @Deprecated
        public int getNewId() {
            return this.newId;
        }
    }
}
