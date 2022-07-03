package com.viaversion.viaversion.protocols.protocol1_9_1_2to1_9_3_4;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.protocols.protocol1_9_1_2to1_9_3_4.types.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.types.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.protocols.protocol1_9_1_2to1_9_3_4.chunks.*;

public class Protocol1_9_1_2To1_9_3_4 extends AbstractProtocol<ClientboundPackets1_9_3, ClientboundPackets1_9, ServerboundPackets1_9_3, ServerboundPackets1_9>
{
    @Override
    public void init(final UserConnection lllllllllllllIIllIIIllIlIIIlIlII) {
        if (!lllllllllllllIIllIIIllIlIIIlIlII.has(ClientWorld.class)) {
            lllllllllllllIIllIIIllIlIIIlIlII.put(new ClientWorld(lllllllllllllIIllIIIllIlIIIlIlII));
        }
    }
    
    @Override
    protected void registerPackets() {
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.BLOCK_ENTITY_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.NBT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIlllIlIIllIIIIlIlI) throws Exception {
                        if (lllllllllllllIIlllIlIIllIIIIlIlI.get((Type<Short>)Type.UNSIGNED_BYTE, 0) == 9) {
                            final Position lllllllllllllIIlllIlIIllIIIIllIl = lllllllllllllIIlllIlIIllIIIIlIlI.get(Type.POSITION, 0);
                            final CompoundTag lllllllllllllIIlllIlIIllIIIIllII = lllllllllllllIIlllIlIIllIIIIlIlI.get(Type.NBT, 0);
                            lllllllllllllIIlllIlIIllIIIIlIlI.clearPacket();
                            lllllllllllllIIlllIlIIllIIIIlIlI.setId(ClientboundPackets1_9.UPDATE_SIGN.ordinal());
                            lllllllllllllIIlllIlIIllIIIIlIlI.write(Type.POSITION, lllllllllllllIIlllIlIIllIIIIllIl);
                            for (int lllllllllllllIIlllIlIIllIIIIlllI = 1; lllllllllllllIIlllIlIIllIIIIlllI < 5; ++lllllllllllllIIlllIlIIllIIIIlllI) {
                                lllllllllllllIIlllIlIIllIIIIlIlI.write(Type.STRING, (String)lllllllllllllIIlllIlIIllIIIIllII.get(String.valueOf(new StringBuilder().append("Text").append(lllllllllllllIIlllIlIIllIIIIlllI))).getValue());
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllIllllIlllllIIIIIIlll) throws Exception {
                        final ClientWorld llllllllllllIllllIlllllIIIIIIllI = llllllllllllIllllIlllllIIIIIIlll.user().get(ClientWorld.class);
                        final Chunk1_9_3_4Type llllllllllllIllllIlllllIIIIIIlIl = new Chunk1_9_3_4Type(llllllllllllIllllIlllllIIIIIIllI);
                        final Chunk1_9_1_2Type llllllllllllIllllIlllllIIIIIIlII = new Chunk1_9_1_2Type(llllllllllllIllllIlllllIIIIIIllI);
                        final Chunk llllllllllllIllllIlllllIIIIIIIll = llllllllllllIllllIlllllIIIIIIlll.read((Type<Chunk>)llllllllllllIllllIlllllIIIIIIlIl);
                        llllllllllllIllllIlllllIIIIIIlll.write((Type<Chunk>)llllllllllllIllllIlllllIIIIIIlII, llllllllllllIllllIlllllIIIIIIIll);
                        BlockEntity.handle(llllllllllllIllllIlllllIIIIIIIll.getBlockEntities(), llllllllllllIllllIlllllIIIIIIlll.user());
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.JOIN_GAME, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIllIlllllllIIIll) throws Exception {
                        final ClientWorld lllllllllllllIIIIllIlllllllIIlIl = lllllllllllllIIIIllIlllllllIIIll.user().get(ClientWorld.class);
                        final int lllllllllllllIIIIllIlllllllIIlII = lllllllllllllIIIIllIlllllllIIIll.get((Type<Integer>)Type.INT, 1);
                        lllllllllllllIIIIllIlllllllIIlIl.setEnvironment(lllllllllllllIIIIllIlllllllIIlII);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.RESPAWN, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllIlIIIlIIIlII) throws Exception {
                        final ClientWorld lllIlIIIlIIIIll = lllIlIIIlIIIlII.user().get(ClientWorld.class);
                        final int lllIlIIIlIIIIlI = lllIlIIIlIIIlII.get((Type<Integer>)Type.INT, 0);
                        lllIlIIIlIIIIll.setEnvironment(lllIlIIIlIIIIlI);
                    }
                });
            }
        });
    }
    
    public Protocol1_9_1_2To1_9_3_4() {
        super(ClientboundPackets1_9_3.class, ClientboundPackets1_9.class, ServerboundPackets1_9_3.class, ServerboundPackets1_9.class);
    }
}
