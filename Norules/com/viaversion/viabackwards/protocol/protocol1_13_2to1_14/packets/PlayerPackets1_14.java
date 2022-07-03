package com.viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets;

import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viabackwards.protocol.protocol1_13_2to1_14.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.protocol.*;

public class PlayerPackets1_14 extends RewriterBase<Protocol1_13_2To1_14>
{
    @Override
    protected void registerPackets() {
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.SERVER_DIFFICULTY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.BOOLEAN, Type.NOTHING);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.OPEN_SIGN_EDITOR, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION1_14, Type.POSITION);
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)this.protocol).registerServerbound(ServerboundPackets1_13.QUERY_BLOCK_NBT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.POSITION, Type.POSITION1_14);
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)this.protocol).registerServerbound(ServerboundPackets1_13.PLAYER_DIGGING, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.POSITION, Type.POSITION1_14);
                this.map(Type.BYTE);
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)this.protocol).registerServerbound(ServerboundPackets1_13.RECIPE_BOOK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIIIIIIIllIllllll) throws Exception {
                        final int lllllllllllllIIIIIIIIIIlllIIIIII = lllllllllllllIIIIIIIIIIllIllllll.get((Type<Integer>)Type.VAR_INT, 0);
                        if (lllllllllllllIIIIIIIIIIlllIIIIII == 0) {
                            lllllllllllllIIIIIIIIIIllIllllll.passthrough(Type.STRING);
                        }
                        else if (lllllllllllllIIIIIIIIIIlllIIIIII == 1) {
                            lllllllllllllIIIIIIIIIIllIllllll.passthrough((Type<Object>)Type.BOOLEAN);
                            lllllllllllllIIIIIIIIIIllIllllll.passthrough((Type<Object>)Type.BOOLEAN);
                            lllllllllllllIIIIIIIIIIllIllllll.passthrough((Type<Object>)Type.BOOLEAN);
                            lllllllllllllIIIIIIIIIIllIllllll.passthrough((Type<Object>)Type.BOOLEAN);
                            lllllllllllllIIIIIIIIIIllIllllll.write(Type.BOOLEAN, false);
                            lllllllllllllIIIIIIIIIIllIllllll.write(Type.BOOLEAN, false);
                            lllllllllllllIIIIIIIIIIllIllllll.write(Type.BOOLEAN, false);
                            lllllllllllllIIIIIIIIIIllIllllll.write(Type.BOOLEAN, false);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)this.protocol).registerServerbound(ServerboundPackets1_13.UPDATE_COMMAND_BLOCK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION, Type.POSITION1_14);
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)this.protocol).registerServerbound(ServerboundPackets1_13.UPDATE_STRUCTURE_BLOCK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION, Type.POSITION1_14);
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)this.protocol).registerServerbound(ServerboundPackets1_13.UPDATE_SIGN, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION, Type.POSITION1_14);
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)this.protocol).registerServerbound(ServerboundPackets1_13.PLAYER_BLOCK_PLACEMENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIllIIllIIllIIlIIl) throws Exception {
                        final Position lllllllllllllllIllIIllIIllIIllll = lllllllllllllllIllIIllIIllIIlIIl.read(Type.POSITION);
                        final int lllllllllllllllIllIIllIIllIIlllI = lllllllllllllllIllIIllIIllIIlIIl.read((Type<Integer>)Type.VAR_INT);
                        final int lllllllllllllllIllIIllIIllIIllIl = lllllllllllllllIllIIllIIllIIlIIl.read((Type<Integer>)Type.VAR_INT);
                        final float lllllllllllllllIllIIllIIllIIllII = lllllllllllllllIllIIllIIllIIlIIl.read((Type<Float>)Type.FLOAT);
                        final float lllllllllllllllIllIIllIIllIIlIll = lllllllllllllllIllIIllIIllIIlIIl.read((Type<Float>)Type.FLOAT);
                        final float lllllllllllllllIllIIllIIllIIlIlI = lllllllllllllllIllIIllIIllIIlIIl.read((Type<Float>)Type.FLOAT);
                        lllllllllllllllIllIIllIIllIIlIIl.write(Type.VAR_INT, lllllllllllllllIllIIllIIllIIllIl);
                        lllllllllllllllIllIIllIIllIIlIIl.write(Type.POSITION1_14, lllllllllllllllIllIIllIIllIIllll);
                        lllllllllllllllIllIIllIIllIIlIIl.write(Type.VAR_INT, lllllllllllllllIllIIllIIllIIlllI);
                        lllllllllllllllIllIIllIIllIIlIIl.write(Type.FLOAT, lllllllllllllllIllIIllIIllIIllII);
                        lllllllllllllllIllIIllIIllIIlIIl.write(Type.FLOAT, lllllllllllllllIllIIllIIllIIlIll);
                        lllllllllllllllIllIIllIIllIIlIIl.write(Type.FLOAT, lllllllllllllllIllIIllIIllIIlIlI);
                        lllllllllllllllIllIIllIIllIIlIIl.write(Type.BOOLEAN, false);
                    }
                });
            }
        });
    }
    
    public PlayerPackets1_14(final Protocol1_13_2To1_14 lIlllllIIIlI) {
        super(lIlllllIIIlI);
    }
}
