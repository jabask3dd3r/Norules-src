package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocols.protocol1_8.*;
import de.gerrygames.viarewind.utils.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.storage.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.packets.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.type.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.provider.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.platform.providers.*;
import com.viaversion.viaversion.api.protocol.packet.*;

public class Protocol1_7_6_10TO1_8 extends AbstractProtocol<ClientboundPackets1_8, ClientboundPackets1_7, ServerboundPackets1_8, ServerboundPackets1_7>
{
    @Override
    public void init(final UserConnection lllllllllllllllIIlIlllIIIlIllIIl) {
        Ticker.init();
        lllllllllllllllIIlIlllIIIlIllIIl.put(new Windows(lllllllllllllllIIlIlllIIIlIllIIl));
        lllllllllllllllIIlIlllIIIlIllIIl.put(new EntityTracker(lllllllllllllllIIlIlllIIIlIllIIl));
        lllllllllllllllIIlIlllIIIlIllIIl.put(new PlayerPosition(lllllllllllllllIIlIlllIIIlIllIIl));
        lllllllllllllllIIlIlllIIIlIllIIl.put(new GameProfileStorage(lllllllllllllllIIlIlllIIIlIllIIl));
        lllllllllllllllIIlIlllIIIlIllIIl.put(new ClientChunks(lllllllllllllllIIlIlllIIIlIllIIl));
        lllllllllllllllIIlIlllIIIlIllIIl.put(new Scoreboard(lllllllllllllllIIlIlllIIIlIllIIl));
        lllllllllllllllIIlIlllIIIlIllIIl.put(new CompressionSendStorage(lllllllllllllllIIlIlllIIIlIllIIl));
        lllllllllllllllIIlIlllIIIlIllIIl.put(new WorldBorder(lllllllllllllllIIlIlllIIIlIllIIl));
        lllllllllllllllIIlIlllIIIlIllIIl.put(new PlayerAbilities(lllllllllllllllIIlIlllIIIlIllIIl));
        lllllllllllllllIIlIlllIIIlIllIIl.put(new ClientWorld(lllllllllllllllIIlIlllIIIlIllIIl));
    }
    
    public Protocol1_7_6_10TO1_8() {
        super(ClientboundPackets1_8.class, ClientboundPackets1_7.class, ServerboundPackets1_8.class, ServerboundPackets1_7.class);
    }
    
    @Override
    protected void registerPackets() {
        EntityPackets.register(this);
        InventoryPackets.register(this);
        PlayerPackets.register(this);
        ScoreboardPackets.register(this);
        SpawnPackets.register(this);
        WorldPackets.register(this);
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_8.KEEP_ALIVE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT, Type.INT);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)this).cancelClientbound(ClientboundPackets1_8.SET_COMPRESSION);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_7>)this).registerServerbound(ServerboundPackets1_7.KEEP_ALIVE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT, Type.VAR_INT);
            }
        });
        this.registerClientbound(State.LOGIN, 1, 1, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.map(Type.BYTE_ARRAY_PRIMITIVE, Type.SHORT_BYTE_ARRAY);
                this.map(Type.BYTE_ARRAY_PRIMITIVE, Type.SHORT_BYTE_ARRAY);
            }
        });
        this.registerClientbound(State.LOGIN, 3, 3, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(lllllllllllllIIllIIlIllIIllllIIl -> {
                    Via.getManager().getProviders().get(CompressionHandlerProvider.class).handleSetCompression(lllllllllllllIIllIIlIllIIllllIIl.user(), lllllllllllllIIllIIlIllIIllllIIl.read((Type<Integer>)Type.VAR_INT));
                    lllllllllllllIIllIIlIllIIllllIIl.cancel();
                });
            }
        });
        this.registerServerbound(State.LOGIN, 1, 1, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.SHORT_BYTE_ARRAY, Type.BYTE_ARRAY_PRIMITIVE);
                this.map(Type.SHORT_BYTE_ARRAY, Type.BYTE_ARRAY_PRIMITIVE);
            }
        });
    }
    
    @Override
    public void register(final ViaProviders lllllllllllllllIIlIlllIIIlIlIllI) {
        lllllllllllllllIIlIlllIIIlIlIllI.register(CompressionHandlerProvider.class, new CompressionHandlerProvider());
    }
    
    @Override
    public void transform(final Direction lllllllllllllllIIlIlllIIIllIIIll, final State lllllllllllllllIIlIlllIIIlIllllI, final PacketWrapper lllllllllllllllIIlIlllIIIllIIIIl) throws Exception {
        Via.getManager().getProviders().get(CompressionHandlerProvider.class).handleTransform(lllllllllllllllIIlIlllIIIllIIIIl.user());
        super.transform(lllllllllllllllIIlIlllIIIllIIIll, lllllllllllllllIIlIlllIIIlIllllI, lllllllllllllllIIlIlllIIIllIIIIl);
    }
}
