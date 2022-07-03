package com.viaversion.viabackwards.protocol.protocol1_17to1_17_1;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.protocols.protocol1_17_1to1_17.*;
import com.viaversion.viaversion.protocols.protocol1_17to1_16_4.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viabackwards.protocol.protocol1_17to1_17_1.storage.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.protocol.*;

public final class Protocol1_17To1_17_1 extends BackwardsProtocol<ClientboundPackets1_17_1, ClientboundPackets1_17, ServerboundPackets1_17, ServerboundPackets1_17>
{
    public Protocol1_17To1_17_1() {
        super(ClientboundPackets1_17_1.class, ClientboundPackets1_17.class, ServerboundPackets1_17.class, ServerboundPackets1_17.class);
    }
    
    @Override
    protected void registerPackets() {
        ((Protocol<ClientboundPackets1_17_1, ClientboundPackets1_17, S1, S2>)this).registerClientbound(ClientboundPackets1_17_1.REMOVE_ENTITIES, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int[] llllllllllllllIIlIIlIllIlIllllll;
                final float llllllllllllllIIlIIlIllIlIllllII;
                Exception llllllllllllllIIlIIlIllIlIlllIll;
                double llllllllllllllIIlIIlIllIlIlllIlI;
                int llllllllllllllIIlIIlIllIllIIIIIl;
                PacketWrapper llllllllllllllIIlIIlIllIllIIIIlI;
                this.handler(llllllllllllllIIlIIlIllIlIlllllI -> {
                    llllllllllllllIIlIIlIllIlIllllll = llllllllllllllIIlIIlIllIlIlllllI.read(Type.VAR_INT_ARRAY_PRIMITIVE);
                    llllllllllllllIIlIIlIllIlIlllllI.cancel();
                    llllllllllllllIIlIIlIllIlIllllII = (float)(Object)llllllllllllllIIlIIlIllIlIllllll;
                    for (llllllllllllllIIlIIlIllIlIlllIll = (Exception)llllllllllllllIIlIIlIllIlIllllII.length, llllllllllllllIIlIIlIllIlIlllIlI = 0; llllllllllllllIIlIIlIllIlIlllIlI < llllllllllllllIIlIIlIllIlIlllIll; ++llllllllllllllIIlIIlIllIlIlllIlI) {
                        llllllllllllllIIlIIlIllIllIIIIIl = llllllllllllllIIlIIlIllIlIllllII[llllllllllllllIIlIIlIllIlIlllIlI];
                        llllllllllllllIIlIIlIllIllIIIIlI = llllllllllllllIIlIIlIllIlIlllllI.create(ClientboundPackets1_17.REMOVE_ENTITY);
                        llllllllllllllIIlIIlIllIllIIIIlI.write(Type.VAR_INT, llllllllllllllIIlIIlIllIllIIIIIl);
                        llllllllllllllIIlIIlIllIllIIIIlI.send(Protocol1_17To1_17_1.class);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_17_1.CLOSE_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                final short lllllllllllllllIlIlIIlIlIlIIIIIl;
                this.handler(lllllllllllllllIlIlIIlIlIlIIIIII -> {
                    lllllllllllllllIlIlIIlIlIlIIIIIl = lllllllllllllllIlIlIIlIlIlIIIIII.passthrough((Type<Short>)Type.UNSIGNED_BYTE);
                    lllllllllllllllIlIlIIlIlIlIIIIII.user().get(InventoryStateIds.class).removeStateId(lllllllllllllllIlIlIIlIlIlIIIIIl);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_17_1.SET_SLOT, new PacketRemapper() {
            @Override
            public void registerMap() {
                final short lllllllllllllIIllIIIIlIlIIIIlIIl;
                final int lllllllllllllIIllIIIIlIlIIIIlIII;
                this.handler(lllllllllllllIIllIIIIlIlIIIIIlll -> {
                    lllllllllllllIIllIIIIlIlIIIIlIIl = lllllllllllllIIllIIIIlIlIIIIIlll.passthrough((Type<Short>)Type.UNSIGNED_BYTE);
                    lllllllllllllIIllIIIIlIlIIIIlIII = lllllllllllllIIllIIIIlIlIIIIIlll.read((Type<Integer>)Type.VAR_INT);
                    lllllllllllllIIllIIIIlIlIIIIIlll.user().get(InventoryStateIds.class).setStateId(lllllllllllllIIllIIIIlIlIIIIlIIl, lllllllllllllIIllIIIIlIlIIIIlIII);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_17_1.WINDOW_ITEMS, new PacketRemapper() {
            @Override
            public void registerMap() {
                final short lllllllllllllIlIlIllIllIllIlIIlI;
                final int lllllllllllllIlIlIllIllIllIlIIIl;
                this.handler(lllllllllllllIlIlIllIllIllIlIIII -> {
                    lllllllllllllIlIlIllIllIllIlIIlI = lllllllllllllIlIlIllIllIllIlIIII.passthrough((Type<Short>)Type.UNSIGNED_BYTE);
                    lllllllllllllIlIlIllIllIllIlIIIl = lllllllllllllIlIlIllIllIllIlIIII.read((Type<Integer>)Type.VAR_INT);
                    lllllllllllllIlIlIllIllIllIlIIII.user().get(InventoryStateIds.class).setStateId(lllllllllllllIlIlIllIllIllIlIIlI, lllllllllllllIlIlIllIllIllIlIIIl);
                    lllllllllllllIlIlIllIllIllIlIIII.write(Type.FLAT_VAR_INT_ITEM_ARRAY, (Item[])(Object)lllllllllllllIlIlIllIllIllIlIIII.read((Type<T>)Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT));
                    lllllllllllllIlIlIllIllIllIlIIII.read(Type.FLAT_VAR_INT_ITEM);
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_17>)this).registerServerbound(ServerboundPackets1_17.CLOSE_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                final short lllllllllllllIllIllIlIIIlIIIlllI;
                this.handler(lllllllllllllIllIllIlIIIlIIIllll -> {
                    lllllllllllllIllIllIlIIIlIIIlllI = lllllllllllllIllIllIlIIIlIIIllll.passthrough((Type<Short>)Type.UNSIGNED_BYTE);
                    lllllllllllllIllIllIlIIIlIIIllll.user().get(InventoryStateIds.class).removeStateId(lllllllllllllIllIllIlIIIlIIIlllI);
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_17>)this).registerServerbound(ServerboundPackets1_17.CLICK_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                final short lllllllllllllIlIIlIIlIIllIlIIlll;
                final int lllllllllllllIlIIlIIlIIllIlIIllI;
                this.handler(lllllllllllllIlIIlIIlIIllIlIlIII -> {
                    lllllllllllllIlIIlIIlIIllIlIIlll = lllllllllllllIlIIlIIlIIllIlIlIII.passthrough((Type<Short>)Type.UNSIGNED_BYTE);
                    lllllllllllllIlIIlIIlIIllIlIIllI = lllllllllllllIlIIlIIlIIllIlIlIII.user().get(InventoryStateIds.class).removeStateId(lllllllllllllIlIIlIIlIIllIlIIlll);
                    lllllllllllllIlIIlIIlIIllIlIlIII.write(Type.VAR_INT, (lllllllllllllIlIIlIIlIIllIlIIllI == Integer.MAX_VALUE) ? 0 : lllllllllllllIlIIlIIlIIllIlIIllI);
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_17>)this).registerServerbound(ServerboundPackets1_17.EDIT_BOOK, new PacketRemapper() {
            @Override
            public void registerMap() {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: invokedynamic   BootstrapMethod #0, handle:()Lcom/viaversion/viaversion/api/protocol/remapper/PacketHandler;
                //     6: invokevirtual   com/viaversion/viabackwards/protocol/protocol1_17to1_17_1/Protocol1_17To1_17_1$7.handler:(Lcom/viaversion/viaversion/api/protocol/remapper/PacketHandler;)V
                //     9: return         
                // 
                // The error that occurred was:
                // 
                // java.lang.NullPointerException
                // 
                throw new IllegalStateException("An error occurred while decompiling this method.");
            }
        });
    }
    
    static {
        MAX_PAGE_LENGTH = 8192;
        MAX_TITLE_LENGTH = 128;
        MAX_PAGES = 200;
    }
    
    @Override
    public void init(final UserConnection lllllllllllllIlIIIIlIlIlllIIllII) {
        lllllllllllllIlIIIIlIlIlllIIllII.put(new InventoryStateIds());
    }
}
