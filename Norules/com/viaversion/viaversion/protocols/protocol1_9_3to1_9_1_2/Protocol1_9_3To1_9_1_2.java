package com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2;

import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.types.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.chunks.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.api.protocol.*;

public class Protocol1_9_3To1_9_1_2 extends AbstractProtocol<ClientboundPackets1_9, ClientboundPackets1_9_3, ServerboundPackets1_9, ServerboundPackets1_9_3>
{
    public static final /* synthetic */ ValueTransformer<Short, Short> ADJUST_PITCH;
    
    @Override
    public void init(final UserConnection llllllllllllllIllllIIlIlIIIIIIIl) {
        if (!llllllllllllllIllllIIlIlIIIIIIIl.has(ClientWorld.class)) {
            llllllllllllllIllllIIlIlIIIIIIIl.put(new ClientWorld(llllllllllllllIllllIIlIlIIIIIIIl));
        }
    }
    
    public Protocol1_9_3To1_9_1_2() {
        super(ClientboundPackets1_9.class, ClientboundPackets1_9_3.class, ServerboundPackets1_9.class, ServerboundPackets1_9_3.class);
    }
    
    static {
        ADJUST_PITCH = new ValueTransformer<Short, Short>((Type)Type.UNSIGNED_BYTE) {
            @Override
            public Short transform(final PacketWrapper llllllllllllllIllllIIllIlIllIIIl, final Short llllllllllllllIllllIIllIlIllIIII) throws Exception {
                return (short)Math.round(llllllllllllllIllllIIllIlIllIIII / 63.5f * 63.0f);
            }
        };
    }
    
    @Override
    protected void registerPackets() {
        ((Protocol<ClientboundPackets1_9, ClientboundPackets1_9_3, S1, S2>)this).registerClientbound(ClientboundPackets1_9.UPDATE_SIGN, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIllIIIllIlIllllIll) throws Exception {
                        final Position lllllllllllllIIllIIIllIlIllllIlI = lllllllllllllIIllIIIllIlIllllIll.read(Type.POSITION);
                        final JsonElement[] lllllllllllllIIllIIIllIlIllllIIl = new JsonElement[4];
                        for (int lllllllllllllIIllIIIllIlIllllllI = 0; lllllllllllllIIllIIIllIlIllllllI < 4; ++lllllllllllllIIllIIIllIlIllllllI) {
                            lllllllllllllIIllIIIllIlIllllIIl[lllllllllllllIIllIIIllIlIllllllI] = lllllllllllllIIllIIIllIlIllllIll.read(Type.COMPONENT);
                        }
                        lllllllllllllIIllIIIllIlIllllIll.clearInputBuffer();
                        lllllllllllllIIllIIIllIlIllllIll.setId(9);
                        lllllllllllllIIllIIIllIlIllllIll.write(Type.POSITION, lllllllllllllIIllIIIllIlIllllIlI);
                        lllllllllllllIIllIIIllIlIllllIll.write(Type.UNSIGNED_BYTE, (Short)9);
                        final CompoundTag lllllllllllllIIllIIIllIlIllllIII = new CompoundTag();
                        lllllllllllllIIllIIIllIlIllllIII.put("id", new StringTag("Sign"));
                        lllllllllllllIIllIIIllIlIllllIII.put("x", new IntTag(lllllllllllllIIllIIIllIlIllllIlI.getX()));
                        lllllllllllllIIllIIIllIlIllllIII.put("y", new IntTag(lllllllllllllIIllIIIllIlIllllIlI.getY()));
                        lllllllllllllIIllIIIllIlIllllIII.put("z", new IntTag(lllllllllllllIIllIIIllIlIllllIlI.getZ()));
                        for (int lllllllllllllIIllIIIllIlIlllllIl = 0; lllllllllllllIIllIIIllIlIlllllIl < lllllllllllllIIllIIIllIlIllllIIl.length; ++lllllllllllllIIllIIIllIlIlllllIl) {
                            lllllllllllllIIllIIIllIlIllllIII.put(String.valueOf(new StringBuilder().append("Text").append(lllllllllllllIIllIIIllIlIlllllIl + 1)), new StringTag(lllllllllllllIIllIIIllIlIllllIIl[lllllllllllllIIllIIIllIlIlllllIl].toString()));
                        }
                        lllllllllllllIIllIIIllIlIllllIll.write(Type.NBT, lllllllllllllIIllIIIllIlIllllIII);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIllIlIlllIIIlIllI) throws Exception {
                        final ClientWorld lllllllllllllIIIllIlIlllIIIllIlI = lllllllllllllIIIllIlIlllIIIlIllI.user().get(ClientWorld.class);
                        final Chunk1_9_1_2Type lllllllllllllIIIllIlIlllIIIllIIl = new Chunk1_9_1_2Type(lllllllllllllIIIllIlIlllIIIllIlI);
                        final Chunk lllllllllllllIIIllIlIlllIIIllIII = lllllllllllllIIIllIlIlllIIIlIllI.passthrough((Type<Chunk>)lllllllllllllIIIllIlIlllIIIllIIl);
                        final List<CompoundTag> lllllllllllllIIIllIlIlllIIIlIlll = lllllllllllllIIIllIlIlllIIIllIII.getBlockEntities();
                        for (int lllllllllllllIIIllIlIlllIIIlllIl = 0; lllllllllllllIIIllIlIlllIIIlllIl < lllllllllllllIIIllIlIlllIIIllIII.getSections().length; ++lllllllllllllIIIllIlIlllIIIlllIl) {
                            final ChunkSection lllllllllllllIIIllIlIlllIIIllllI = lllllllllllllIIIllIlIlllIIIllIII.getSections()[lllllllllllllIIIllIlIlllIIIlllIl];
                            if (lllllllllllllIIIllIlIlllIIIllllI != null) {
                                for (int lllllllllllllIIIllIlIlllIIIlllll = 0; lllllllllllllIIIllIlIlllIIIlllll < 16; ++lllllllllllllIIIllIlIlllIIIlllll) {
                                    for (int lllllllllllllIIIllIlIlllIIlIIIII = 0; lllllllllllllIIIllIlIlllIIlIIIII < 16; ++lllllllllllllIIIllIlIlllIIlIIIII) {
                                        for (int lllllllllllllIIIllIlIlllIIlIIIIl = 0; lllllllllllllIIIllIlIlllIIlIIIIl < 16; ++lllllllllllllIIIllIlIlllIIlIIIIl) {
                                            final int lllllllllllllIIIllIlIlllIIlIIIlI = lllllllllllllIIIllIlIlllIIIllllI.getBlockWithoutData(lllllllllllllIIIllIlIlllIIlIIIIl, lllllllllllllIIIllIlIlllIIIlllll, lllllllllllllIIIllIlIlllIIlIIIII);
                                            if (FakeTileEntity.hasBlock(lllllllllllllIIIllIlIlllIIlIIIlI)) {
                                                lllllllllllllIIIllIlIlllIIIlIlll.add(FakeTileEntity.getFromBlock(lllllllllllllIIIllIlIlllIIlIIIIl + (lllllllllllllIIIllIlIlllIIIllIII.getX() << 4), lllllllllllllIIIllIlIlllIIIlllll + (lllllllllllllIIIllIlIlllIIIlllIl << 4), lllllllllllllIIIllIlIlllIIlIIIII + (lllllllllllllIIIllIlIlllIIIllIII.getZ() << 4), lllllllllllllIIIllIlIlllIIlIIIlI));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        lllllllllllllIIIllIlIlllIIIlIllI.write(Type.NBT_ARRAY, lllllllllllllIIIllIlIlllIIIllIII.getBlockEntities().toArray(new CompoundTag[0]));
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9.JOIN_GAME, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllllllIlIlIlIllllIll) throws Exception {
                        final ClientWorld llllllllllllllllllIlIlIlIlllllIl = llllllllllllllllllIlIlIlIllllIll.user().get(ClientWorld.class);
                        final int llllllllllllllllllIlIlIlIlllllII = llllllllllllllllllIlIlIlIllllIll.get((Type<Integer>)Type.INT, 1);
                        llllllllllllllllllIlIlIlIlllllIl.setEnvironment(llllllllllllllllllIlIlIlIlllllII);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9.RESPAWN, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlllIlIlIllIlIIIlII) throws Exception {
                        final ClientWorld lllllllllllllIlllIlIlIllIlIIIllI = lllllllllllllIlllIlIlIllIlIIIlII.user().get(ClientWorld.class);
                        final int lllllllllllllIlllIlIlIllIlIIIlIl = lllllllllllllIlllIlIlIllIlIIIlII.get((Type<Integer>)Type.INT, 0);
                        lllllllllllllIlllIlIlIllIlIIIllI.setEnvironment(lllllllllllllIlllIlIlIllIlIIIlIl);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9.SOUND, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.FLOAT);
                this.map(Protocol1_9_3To1_9_1_2.ADJUST_PITCH);
            }
        });
    }
}
