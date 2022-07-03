package com.viaversion.viaversion.protocols.protocol1_14to1_13_2.packets;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.minecraft.*;

public class PlayerPackets
{
    public static void register(final Protocol llllllllllllllIlllIIIIIIlIlIIIIl) {
        llllllllllllllIlllIIIIIIlIlIIIIl.registerClientbound(ClientboundPackets1_13.OPEN_SIGN_EDITOR, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION, Type.POSITION1_14);
            }
        });
        llllllllllllllIlllIIIIIIlIlIIIIl.registerServerbound(ServerboundPackets1_14.QUERY_BLOCK_NBT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.POSITION1_14, Type.POSITION);
            }
        });
        llllllllllllllIlllIIIIIIlIlIIIIl.registerServerbound(ServerboundPackets1_14.EDIT_BOOK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllllIIIIlIllIIllIIll) throws Exception {
                        final Item llllllllllllllllIIIIlIllIIllIlIl = llllllllllllllllIIIIlIllIIllIIll.passthrough(Type.FLAT_VAR_INT_ITEM);
                        llllllllllllllIlllIIIIIIlIlIIIIl.getItemRewriter().handleItemToServer(llllllllllllllllIIIIlIllIIllIlIl);
                        if (Via.getConfig().isTruncate1_14Books()) {
                            if (llllllllllllllllIIIIlIllIIllIlIl == null) {
                                return;
                            }
                            final CompoundTag llllllllllllllllIIIIlIllIIlllIlI = llllllllllllllllIIIIlIllIIllIlIl.tag();
                            if (llllllllllllllllIIIIlIllIIlllIlI == null) {
                                return;
                            }
                            final Tag llllllllllllllllIIIIlIllIIlllIIl = llllllllllllllllIIIIlIllIIlllIlI.get("pages");
                            if (!(llllllllllllllllIIIIlIllIIlllIIl instanceof ListTag)) {
                                return;
                            }
                            final ListTag llllllllllllllllIIIIlIllIIlllIII = (ListTag)llllllllllllllllIIIIlIllIIlllIIl;
                            if (llllllllllllllllIIIIlIllIIlllIII.size() <= 50) {
                                return;
                            }
                            llllllllllllllllIIIIlIllIIlllIII.setValue(llllllllllllllllIIIIlIllIIlllIII.getValue().subList(0, 50));
                        }
                    }
                });
            }
        });
        llllllllllllllIlllIIIIIIlIlIIIIl.registerServerbound(ServerboundPackets1_14.PLAYER_DIGGING, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.POSITION1_14, Type.POSITION);
                this.map(Type.BYTE);
            }
        });
        llllllllllllllIlllIIIIIIlIlIIIIl.registerServerbound(ServerboundPackets1_14.RECIPE_BOOK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIIllIlIllIlllIIII) throws Exception {
                        final int llllllllllllllIIIllIlIllIllIllll = llllllllllllllIIIllIlIllIlllIIII.get((Type<Integer>)Type.VAR_INT, 0);
                        if (llllllllllllllIIIllIlIllIllIllll == 0) {
                            llllllllllllllIIIllIlIllIlllIIII.passthrough(Type.STRING);
                        }
                        else if (llllllllllllllIIIllIlIllIllIllll == 1) {
                            llllllllllllllIIIllIlIllIlllIIII.passthrough((Type<Object>)Type.BOOLEAN);
                            llllllllllllllIIIllIlIllIlllIIII.passthrough((Type<Object>)Type.BOOLEAN);
                            llllllllllllllIIIllIlIllIlllIIII.passthrough((Type<Object>)Type.BOOLEAN);
                            llllllllllllllIIIllIlIllIlllIIII.passthrough((Type<Object>)Type.BOOLEAN);
                            llllllllllllllIIIllIlIllIlllIIII.read((Type<Object>)Type.BOOLEAN);
                            llllllllllllllIIIllIlIllIlllIIII.read((Type<Object>)Type.BOOLEAN);
                            llllllllllllllIIIllIlIllIlllIIII.read((Type<Object>)Type.BOOLEAN);
                            llllllllllllllIIIllIlIllIlllIIII.read((Type<Object>)Type.BOOLEAN);
                        }
                    }
                });
            }
        });
        llllllllllllllIlllIIIIIIlIlIIIIl.registerServerbound(ServerboundPackets1_14.UPDATE_COMMAND_BLOCK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION1_14, Type.POSITION);
            }
        });
        llllllllllllllIlllIIIIIIlIlIIIIl.registerServerbound(ServerboundPackets1_14.UPDATE_STRUCTURE_BLOCK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION1_14, Type.POSITION);
            }
        });
        llllllllllllllIlllIIIIIIlIlIIIIl.registerServerbound(ServerboundPackets1_14.UPDATE_SIGN, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION1_14, Type.POSITION);
            }
        });
        llllllllllllllIlllIIIIIIlIlIIIIl.registerServerbound(ServerboundPackets1_14.PLAYER_BLOCK_PLACEMENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIlIlIIIIllIlIlllI) throws Exception {
                        final int lllllllllllllIlIlIlIIIIllIllIlII = lllllllllllllIlIlIlIIIIllIlIlllI.read((Type<Integer>)Type.VAR_INT);
                        final Position lllllllllllllIlIlIlIIIIllIllIIll = lllllllllllllIlIlIlIIIIllIlIlllI.read(Type.POSITION1_14);
                        final int lllllllllllllIlIlIlIIIIllIllIIlI = lllllllllllllIlIlIlIIIIllIlIlllI.read((Type<Integer>)Type.VAR_INT);
                        final float lllllllllllllIlIlIlIIIIllIllIIIl = lllllllllllllIlIlIlIIIIllIlIlllI.read((Type<Float>)Type.FLOAT);
                        final float lllllllllllllIlIlIlIIIIllIllIIII = lllllllllllllIlIlIlIIIIllIlIlllI.read((Type<Float>)Type.FLOAT);
                        final float lllllllllllllIlIlIlIIIIllIlIllll = lllllllllllllIlIlIlIIIIllIlIlllI.read((Type<Float>)Type.FLOAT);
                        lllllllllllllIlIlIlIIIIllIlIlllI.read((Type<Object>)Type.BOOLEAN);
                        lllllllllllllIlIlIlIIIIllIlIlllI.write(Type.POSITION, lllllllllllllIlIlIlIIIIllIllIIll);
                        lllllllllllllIlIlIlIIIIllIlIlllI.write(Type.VAR_INT, lllllllllllllIlIlIlIIIIllIllIIlI);
                        lllllllllllllIlIlIlIIIIllIlIlllI.write(Type.VAR_INT, lllllllllllllIlIlIlIIIIllIllIlII);
                        lllllllllllllIlIlIlIIIIllIlIlllI.write(Type.FLOAT, lllllllllllllIlIlIlIIIIllIllIIIl);
                        lllllllllllllIlIlIlIIIIllIlIlllI.write(Type.FLOAT, lllllllllllllIlIlIlIIIIllIllIIII);
                        lllllllllllllIlIlIlIIIIllIlIlllI.write(Type.FLOAT, lllllllllllllIlIlIlIIIIllIlIllll);
                    }
                });
            }
        });
    }
}
