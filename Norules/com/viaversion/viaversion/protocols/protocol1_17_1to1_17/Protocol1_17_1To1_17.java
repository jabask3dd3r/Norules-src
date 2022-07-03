package com.viaversion.viaversion.protocols.protocol1_17_1to1_17;

import com.viaversion.viaversion.protocols.protocol1_17to1_16_4.*;
import com.viaversion.viaversion.api.type.types.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.protocol.*;

public final class Protocol1_17_1To1_17 extends AbstractProtocol<ClientboundPackets1_17, ClientboundPackets1_17_1, ServerboundPackets1_17, ServerboundPackets1_17>
{
    private static final /* synthetic */ StringType PAGE_STRING_TYPE;
    private static final /* synthetic */ StringType TITLE_STRING_TYPE;
    
    @Override
    protected void registerPackets() {
        ((Protocol<ClientboundPackets1_17, ClientboundPackets1_17_1, S1, S2>)this).registerClientbound(ClientboundPackets1_17.REMOVE_ENTITY, ClientboundPackets1_17_1.REMOVE_ENTITIES, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int lllIIllIlIlI;
                this.handler(lllIIllIlIll -> {
                    lllIIllIlIlI = lllIIllIlIll.read((Type<Integer>)Type.VAR_INT);
                    lllIIllIlIll.write(Type.VAR_INT_ARRAY_PRIMITIVE, new int[] { lllIIllIlIlI });
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_17.SET_SLOT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.create(Type.VAR_INT, 0);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_17.WINDOW_ITEMS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.create(Type.VAR_INT, 0);
                this.handler(lllllllllllllIIlllIIIIIIlllIIIll -> {
                    lllllllllllllIIlllIIIIIIlllIIIll.write(Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT, (Item[])(Object)lllllllllllllIIlllIIIIIIlllIIIll.read((Type<T>)Type.FLAT_VAR_INT_ITEM_ARRAY));
                    lllllllllllllIIlllIIIIIIlllIIIll.write(Type.FLAT_VAR_INT_ITEM, null);
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_17>)this).registerServerbound(ServerboundPackets1_17.CLICK_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.read(Type.VAR_INT);
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_17>)this).registerServerbound(ServerboundPackets1_17.EDIT_BOOK, new PacketRemapper() {
            @Override
            public void registerMap() {
                final CompoundTag llllllllllllllIIIllIllIllllIIIll;
                final Item llllllllllllllIIIllIllIllllIIIlI;
                final int llllllllllllllIIIllIllIllllIIIIl;
                final int llllllllllllllIIIllIllIllllIIIII;
                final ListTag llllllllllllllIIIllIllIlllIlllll;
                int llllllllllllllIIIllIllIllllIIllI;
                String llllllllllllllIIIllIllIllllIIlll;
                String llllllllllllllIIIllIllIllllIIlIl;
                this.handler(llllllllllllllIIIllIllIlllIllllI -> {
                    llllllllllllllIIIllIllIllllIIIll = new CompoundTag();
                    llllllllllllllIIIllIllIllllIIIlI = new DataItem(942, (byte)1, (short)0, llllllllllllllIIIllIllIllllIIIll);
                    llllllllllllllIIIllIllIlllIllllI.write(Type.FLAT_VAR_INT_ITEM, llllllllllllllIIIllIllIllllIIIlI);
                    llllllllllllllIIIllIllIllllIIIIl = llllllllllllllIIIllIllIlllIllllI.read((Type<Integer>)Type.VAR_INT);
                    llllllllllllllIIIllIllIllllIIIII = llllllllllllllIIIllIllIlllIllllI.read((Type<Integer>)Type.VAR_INT);
                    llllllllllllllIIIllIllIlllIlllll = new ListTag(StringTag.class);
                    for (llllllllllllllIIIllIllIllllIIllI = 0; llllllllllllllIIIllIllIllllIIllI < llllllllllllllIIIllIllIllllIIIII; ++llllllllllllllIIIllIllIllllIIllI) {
                        llllllllllllllIIIllIllIllllIIlll = llllllllllllllIIIllIllIlllIllllI.read((Type<String>)Protocol1_17_1To1_17.PAGE_STRING_TYPE);
                        llllllllllllllIIIllIllIlllIlllll.add(new StringTag(llllllllllllllIIIllIllIllllIIlll));
                    }
                    if (llllllllllllllIIIllIllIlllIlllll.size() == 0) {
                        llllllllllllllIIIllIllIlllIlllll.add(new StringTag(""));
                    }
                    llllllllllllllIIIllIllIllllIIIll.put("pages", llllllllllllllIIIllIllIlllIlllll);
                    if (llllllllllllllIIIllIllIlllIllllI.read((Type<Boolean>)Type.BOOLEAN)) {
                        llllllllllllllIIIllIllIllllIIlIl = llllllllllllllIIIllIllIlllIllllI.read((Type<String>)Protocol1_17_1To1_17.TITLE_STRING_TYPE);
                        llllllllllllllIIIllIllIllllIIIll.put("title", new StringTag(llllllllllllllIIIllIllIllllIIlIl));
                        llllllllllllllIIIllIllIllllIIIll.put("author", new StringTag(llllllllllllllIIIllIllIlllIllllI.user().getProtocolInfo().getUsername()));
                        llllllllllllllIIIllIllIlllIllllI.write(Type.BOOLEAN, true);
                    }
                    else {
                        llllllllllllllIIIllIllIlllIllllI.write(Type.BOOLEAN, false);
                    }
                    llllllllllllllIIIllIllIlllIllllI.write(Type.VAR_INT, llllllllllllllIIIllIllIllllIIIIl);
                });
            }
        });
    }
    
    static {
        PAGE_STRING_TYPE = new StringType(8192);
        TITLE_STRING_TYPE = new StringType(128);
    }
    
    public Protocol1_17_1To1_17() {
        super(ClientboundPackets1_17.class, ClientboundPackets1_17_1.class, ServerboundPackets1_17.class, ServerboundPackets1_17.class);
    }
}
