package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.packets;

import com.viaversion.viaversion.protocols.protocol1_8.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.types.*;
import com.viaversion.viaversion.api.type.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.items.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import de.gerrygames.viarewind.replacement.*;
import com.viaversion.viaversion.api.minecraft.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.chunks.*;
import com.viaversion.viaversion.util.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.types.*;
import de.gerrygames.viarewind.utils.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage.*;
import de.gerrygames.viarewind.types.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.*;
import com.viaversion.viaversion.api.protocol.*;

public class WorldPackets
{
    public static void register(final Protocol1_7_6_10TO1_8 lllllllllllllIIlIlIlIlIlllIlIlll) {
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIIlIlIlIlIlllIlIlll).registerClientbound(ClientboundPackets1_8.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                final ClientWorld lllllllllllllllIIllIlIllIIlllIll;
                final Chunk lllllllllllllllIIllIlIllIIlllIlI;
                final String lllllllllllllllIIllIlIllIIllIllI;
                int lllllllllllllllIIllIlIllIIllIlIl;
                short lllllllllllllllIIllIlIllIIllIlII;
                ChunkSection lllllllllllllllIIllIlIllIIllllIl;
                int lllllllllllllllIIllIlIllIIlllllI;
                int lllllllllllllllIIllIlIllIlIIIIII;
                int lllllllllllllllIIllIlIllIIllllll;
                this.handler(lllllllllllllllIIllIlIllIIlllIIl -> {
                    lllllllllllllllIIllIlIllIIlllIll = lllllllllllllllIIllIlIllIIlllIIl.user().get(ClientWorld.class);
                    lllllllllllllllIIllIlIllIIlllIlI = lllllllllllllllIIllIlIllIIlllIIl.read((Type<Chunk>)new Chunk1_8Type(lllllllllllllllIIllIlIllIIlllIll));
                    lllllllllllllllIIllIlIllIIlllIIl.write((Type<Chunk>)new Chunk1_7_10Type(lllllllllllllllIIllIlIllIIlllIll), lllllllllllllllIIllIlIllIIlllIlI);
                    lllllllllllllllIIllIlIllIIllIllI = (String)(Object)lllllllllllllllIIllIlIllIIlllIlI.getSections();
                    for (lllllllllllllllIIllIlIllIIllIlIl = lllllllllllllllIIllIlIllIIllIllI.length, lllllllllllllllIIllIlIllIIllIlII = 0; lllllllllllllllIIllIlIllIIllIlII < lllllllllllllllIIllIlIllIIllIlIl; ++lllllllllllllllIIllIlIllIIllIlII) {
                        lllllllllllllllIIllIlIllIIllllIl = lllllllllllllllIIllIlIllIIllIllI[lllllllllllllllIIllIlIllIIllIlII];
                        if (lllllllllllllllIIllIlIllIIllllIl != null) {
                            for (lllllllllllllllIIllIlIllIIlllllI = 0; lllllllllllllllIIllIlIllIIlllllI < lllllllllllllllIIllIlIllIIllllIl.getPaletteSize(); ++lllllllllllllllIIllIlIllIIlllllI) {
                                lllllllllllllllIIllIlIllIlIIIIII = lllllllllllllllIIllIlIllIIllllIl.getPaletteEntry(lllllllllllllllIIllIlIllIIlllllI);
                                lllllllllllllllIIllIlIllIIllllll = ReplacementRegistry1_7_6_10to1_8.replace(lllllllllllllllIIllIlIllIlIIIIII);
                                lllllllllllllllIIllIlIllIIllllIl.setPaletteEntry(lllllllllllllllIIllIlIllIIlllllI, lllllllllllllllIIllIlIllIIllllll);
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIIlIlIlIlIlllIlIlll).registerClientbound(ClientboundPackets1_8.MULTI_BLOCK_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.INT);
                final BlockChangeRecord[] lllllllllllllIIIIlIIIIIIIlIlIlIl;
                final char lllllllllllllIIIIlIIIIIIIlIlIIlI;
                String lllllllllllllIIIIlIIIIIIIlIlIIIl;
                int lllllllllllllIIIIlIIIIIIIlIlIIII;
                BlockChangeRecord lllllllllllllIIIIlIIIIIIIlIlIlll;
                short lllllllllllllIIIIlIIIIIIIlIllIIl;
                int lllllllllllllIIIIlIIIIIIIlIllIII;
                this.handler(lllllllllllllIIIIlIIIIIIIlIlIllI -> {
                    lllllllllllllIIIIlIIIIIIIlIlIlIl = lllllllllllllIIIIlIIIIIIIlIlIllI.read(Type.BLOCK_CHANGE_RECORD_ARRAY);
                    lllllllllllllIIIIlIIIIIIIlIlIllI.write(Type.SHORT, (short)lllllllllllllIIIIlIIIIIIIlIlIlIl.length);
                    lllllllllllllIIIIlIIIIIIIlIlIllI.write(Type.INT, lllllllllllllIIIIlIIIIIIIlIlIlIl.length * 4);
                    lllllllllllllIIIIlIIIIIIIlIlIIlI = (char)(Object)lllllllllllllIIIIlIIIIIIIlIlIlIl;
                    for (lllllllllllllIIIIlIIIIIIIlIlIIIl = (String)lllllllllllllIIIIlIIIIIIIlIlIIlI.length, lllllllllllllIIIIlIIIIIIIlIlIIII = 0; lllllllllllllIIIIlIIIIIIIlIlIIII < lllllllllllllIIIIlIIIIIIIlIlIIIl; ++lllllllllllllIIIIlIIIIIIIlIlIIII) {
                        lllllllllllllIIIIlIIIIIIIlIlIlll = lllllllllllllIIIIlIIIIIIIlIlIIlI[lllllllllllllIIIIlIIIIIIIlIlIIII];
                        lllllllllllllIIIIlIIIIIIIlIllIIl = (short)(lllllllllllllIIIIlIIIIIIIlIlIlll.getSectionX() << 12 | lllllllllllllIIIIlIIIIIIIlIlIlll.getSectionZ() << 8 | lllllllllllllIIIIlIIIIIIIlIlIlll.getY());
                        lllllllllllllIIIIlIIIIIIIlIlIllI.write(Type.SHORT, lllllllllllllIIIIlIIIIIIIlIllIIl);
                        lllllllllllllIIIIlIIIIIIIlIllIII = ReplacementRegistry1_7_6_10to1_8.replace(lllllllllllllIIIIlIIIIIIIlIlIlll.getBlockId());
                        lllllllllllllIIIIlIIIIIIIlIlIllI.write(Type.SHORT, (short)lllllllllllllIIIIlIIIIIIIlIllIII);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIIlIlIlIlIlllIlIlll).registerClientbound(ClientboundPackets1_8.BLOCK_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                final Position lllllllllllllIIllllIIIIllIlIlIll;
                this.handler(lllllllllllllIIllllIIIIllIlIlIlI -> {
                    lllllllllllllIIllllIIIIllIlIlIll = lllllllllllllIIllllIIIIllIlIlIlI.read(Type.POSITION);
                    lllllllllllllIIllllIIIIllIlIlIlI.write(Type.INT, lllllllllllllIIllllIIIIllIlIlIll.getX());
                    lllllllllllllIIllllIIIIllIlIlIlI.write(Type.UNSIGNED_BYTE, (short)lllllllllllllIIllllIIIIllIlIlIll.getY());
                    lllllllllllllIIllllIIIIllIlIlIlI.write(Type.INT, lllllllllllllIIllllIIIIllIlIlIll.getZ());
                    return;
                });
                final int lllllllllllllIIllllIIIIllIllIlll;
                int lllllllllllllIIllllIIIIllIllIllI;
                int lllllllllllllIIllllIIIIllIllIlIl;
                final Replacement lllllllllllllIIllllIIIIllIllIlII;
                this.handler(lllllllllllllIIllllIIIIllIlllIII -> {
                    lllllllllllllIIllllIIIIllIllIlll = lllllllllllllIIllllIIIIllIlllIII.read((Type<Integer>)Type.VAR_INT);
                    lllllllllllllIIllllIIIIllIllIllI = lllllllllllllIIllllIIIIllIllIlll >> 4;
                    lllllllllllllIIllllIIIIllIllIlIl = (lllllllllllllIIllllIIIIllIllIlll & 0xF);
                    lllllllllllllIIllllIIIIllIllIlII = ReplacementRegistry1_7_6_10to1_8.getReplacement(lllllllllllllIIllllIIIIllIllIllI, lllllllllllllIIllllIIIIllIllIlIl);
                    if (lllllllllllllIIllllIIIIllIllIlII != null) {
                        lllllllllllllIIllllIIIIllIllIllI = lllllllllllllIIllllIIIIllIllIlII.getId();
                        lllllllllllllIIllllIIIIllIllIlIl = lllllllllllllIIllllIIIIllIllIlII.replaceData(lllllllllllllIIllllIIIIllIllIlIl);
                    }
                    lllllllllllllIIllllIIIIllIlllIII.write(Type.VAR_INT, lllllllllllllIIllllIIIIllIllIllI);
                    lllllllllllllIIllllIIIIllIlllIII.write(Type.UNSIGNED_BYTE, (short)lllllllllllllIIllllIIIIllIllIlIl);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIIlIlIlIlIlllIlIlll).registerClientbound(ClientboundPackets1_8.BLOCK_ACTION, new PacketRemapper() {
            @Override
            public void registerMap() {
                final Position llllllllllllllIIIIIIllIllIIIlIll;
                this.handler(llllllllllllllIIIIIIllIllIIIlIlI -> {
                    llllllllllllllIIIIIIllIllIIIlIll = llllllllllllllIIIIIIllIllIIIlIlI.read(Type.POSITION);
                    llllllllllllllIIIIIIllIllIIIlIlI.write(Type.INT, llllllllllllllIIIIIIllIllIIIlIll.getX());
                    llllllllllllllIIIIIIllIllIIIlIlI.write(Type.SHORT, (short)llllllllllllllIIIIIIllIllIIIlIll.getY());
                    llllllllllllllIIIIIIllIllIIIlIlI.write(Type.INT, llllllllllllllIIIIIIllIllIIIlIll.getZ());
                    return;
                });
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.VAR_INT);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIIlIlIlIlIlllIlIlll).registerClientbound(ClientboundPackets1_8.BLOCK_BREAK_ANIMATION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                final Position lllllllllllllIIlllIllIIlIlIlIlII;
                this.handler(lllllllllllllIIlllIllIIlIlIlIlIl -> {
                    lllllllllllllIIlllIllIIlIlIlIlII = lllllllllllllIIlllIllIIlIlIlIlIl.read(Type.POSITION);
                    lllllllllllllIIlllIllIIlIlIlIlIl.write(Type.INT, lllllllllllllIIlllIllIIlIlIlIlII.getX());
                    lllllllllllllIIlllIllIIlIlIlIlIl.write(Type.INT, lllllllllllllIIlllIllIIlIlIlIlII.getY());
                    lllllllllllllIIlllIllIIlIlIlIlIl.write(Type.INT, lllllllllllllIIlllIllIIlIlIlIlII.getZ());
                    return;
                });
                this.map(Type.BYTE);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIIlIlIlIlIlllIlIlll).registerClientbound(ClientboundPackets1_8.MAP_BULK_CHUNK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(ChunkPacketTransformer::transformChunkBulk);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIIlIlIlIlIlllIlIlll).registerClientbound(ClientboundPackets1_8.EFFECT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                final Position lllllllllllllIlIIlIIIIllIlIlIllI;
                this.handler(lllllllllllllIlIIlIIIIllIlIlIlll -> {
                    lllllllllllllIlIIlIIIIllIlIlIllI = lllllllllllllIlIIlIIIIllIlIlIlll.read(Type.POSITION);
                    lllllllllllllIlIIlIIIIllIlIlIlll.write(Type.INT, lllllllllllllIlIIlIIIIllIlIlIllI.getX());
                    lllllllllllllIlIIlIIIIllIlIlIlll.write(Type.BYTE, (byte)lllllllllllllIlIIlIIIIllIlIlIllI.getY());
                    lllllllllllllIlIIlIIIIllIlIlIlll.write(Type.INT, lllllllllllllIlIIlIIIIllIlIlIllI.getZ());
                    return;
                });
                this.map(Type.INT);
                this.map(Type.BOOLEAN);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIIlIlIlIlIlllIlIlll).registerClientbound(ClientboundPackets1_8.SPAWN_PARTICLE, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int llllllllllllllIIIIIllIIllIIIIIII;
                Particle llllllllllllllIIIIIllIIlIlllllll;
                this.handler(llllllllllllllIIIIIllIIllIIIIIIl -> {
                    llllllllllllllIIIIIllIIllIIIIIII = llllllllllllllIIIIIllIIllIIIIIIl.read((Type<Integer>)Type.INT);
                    llllllllllllllIIIIIllIIlIlllllll = Particle.find(llllllllllllllIIIIIllIIllIIIIIII);
                    if (llllllllllllllIIIIIllIIlIlllllll == null) {
                        llllllllllllllIIIIIllIIlIlllllll = Particle.CRIT;
                    }
                    llllllllllllllIIIIIllIIllIIIIIIl.write(Type.STRING, llllllllllllllIIIIIllIIlIlllllll.name);
                    llllllllllllllIIIIIllIIllIIIIIIl.read((Type<Object>)Type.BOOLEAN);
                    return;
                });
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.INT);
                String llllllllllllllIIIIIllIIllIIIlIll;
                Particle llllllllllllllIIIIIllIIllIIIlIlI;
                int llllllllllllllIIIIIllIIllIIIlllI;
                int llllllllllllllIIIIIllIIllIIIllIl;
                this.handler(llllllllllllllIIIIIllIIllIIIlIIl -> {
                    llllllllllllllIIIIIllIIllIIIlIll = llllllllllllllIIIIIllIIllIIIlIIl.get(Type.STRING, 0);
                    llllllllllllllIIIIIllIIllIIIlIlI = Particle.find(llllllllllllllIIIIIllIIllIIIlIll);
                    if (llllllllllllllIIIIIllIIllIIIlIlI == Particle.ICON_CRACK || llllllllllllllIIIIIllIIllIIIlIlI == Particle.BLOCK_CRACK || llllllllllllllIIIIIllIIllIIIlIlI == Particle.BLOCK_DUST) {
                        llllllllllllllIIIIIllIIllIIIlllI = llllllllllllllIIIIIllIIllIIIlIIl.read((Type<Integer>)Type.VAR_INT);
                        llllllllllllllIIIIIllIIllIIIllIl = ((llllllllllllllIIIIIllIIllIIIlIlI == Particle.ICON_CRACK) ? llllllllllllllIIIIIllIIllIIIlIIl.read((Type<Integer>)Type.VAR_INT) : 0);
                        if ((llllllllllllllIIIIIllIIllIIIlllI >= 256 && llllllllllllllIIIIIllIIllIIIlllI <= 422) || (llllllllllllllIIIIIllIIllIIIlllI >= 2256 && llllllllllllllIIIIIllIIllIIIlllI <= 2267)) {
                            llllllllllllllIIIIIllIIllIIIlIlI = Particle.ICON_CRACK;
                        }
                        else if ((llllllllllllllIIIIIllIIllIIIlllI >= 0 && llllllllllllllIIIIIllIIllIIIlllI <= 164) || (llllllllllllllIIIIIllIIllIIIlllI >= 170 && llllllllllllllIIIIIllIIllIIIlllI <= 175)) {
                            if (llllllllllllllIIIIIllIIllIIIlIlI == Particle.ICON_CRACK) {
                                llllllllllllllIIIIIllIIllIIIlIlI = Particle.BLOCK_CRACK;
                            }
                        }
                        else {
                            llllllllllllllIIIIIllIIllIIIlIIl.cancel();
                            return;
                        }
                        llllllllllllllIIIIIllIIllIIIlIll = String.valueOf(new StringBuilder().append(llllllllllllllIIIIIllIIllIIIlIlI.name).append("_").append(llllllllllllllIIIIIllIIllIIIlllI).append("_").append(llllllllllllllIIIIIllIIllIIIllIl));
                    }
                    llllllllllllllIIIIIllIIllIIIlIIl.set(Type.STRING, 0, llllllllllllllIIIIIllIIllIIIlIll);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIIlIlIlIlIlllIlIlll).registerClientbound(ClientboundPackets1_8.UPDATE_SIGN, new PacketRemapper() {
            @Override
            public void registerMap() {
                final Position lllllllllllllllIIIllllllIIIllIIl;
                this.handler(lllllllllllllllIIIllllllIIIllIII -> {
                    lllllllllllllllIIIllllllIIIllIIl = lllllllllllllllIIIllllllIIIllIII.read(Type.POSITION);
                    lllllllllllllllIIIllllllIIIllIII.write(Type.INT, lllllllllllllllIIIllllllIIIllIIl.getX());
                    lllllllllllllllIIIllllllIIIllIII.write(Type.SHORT, (short)lllllllllllllllIIIllllllIIIllIIl.getY());
                    lllllllllllllllIIIllllllIIIllIII.write(Type.INT, lllllllllllllllIIIllllllIIIllIIl.getZ());
                    return;
                });
                int lllllllllllllllIIIllllllIIlIIIIl;
                String lllllllllllllllIIIllllllIIlIIIlI;
                String lllllllllllllllIIIllllllIIlIIIlI2;
                String lllllllllllllllIIIllllllIIlIIIlI3;
                this.handler(lllllllllllllllIIIllllllIIlIIIII -> {
                    for (lllllllllllllllIIIllllllIIlIIIIl = 0; lllllllllllllllIIIllllllIIlIIIIl < 4; ++lllllllllllllllIIIllllllIIlIIIIl) {
                        lllllllllllllllIIIllllllIIlIIIlI = lllllllllllllllIIIllllllIIlIIIII.read(Type.STRING);
                        lllllllllllllllIIIllllllIIlIIIlI2 = ChatUtil.jsonToLegacy(lllllllllllllllIIIllllllIIlIIIlI);
                        lllllllllllllllIIIllllllIIlIIIlI3 = ChatUtil.removeUnusedColor(lllllllllllllllIIIllllllIIlIIIlI2, '0');
                        if (lllllllllllllllIIIllllllIIlIIIlI3.length() > 15) {
                            lllllllllllllllIIIllllllIIlIIIlI3 = ChatColorUtil.stripColor(lllllllllllllllIIIllllllIIlIIIlI3);
                            if (lllllllllllllllIIIllllllIIlIIIlI3.length() > 15) {
                                lllllllllllllllIIIllllllIIlIIIlI3 = lllllllllllllllIIIllllllIIlIIIlI3.substring(0, 15);
                            }
                        }
                        lllllllllllllllIIIllllllIIlIIIII.write(Type.STRING, lllllllllllllllIIIllllllIIlIIIlI3);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIIlIlIlIlIlllIlIlll).registerClientbound(ClientboundPackets1_8.MAP_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int lllllllllllllIIllIIllIllIIIlIlII;
                final byte lllllllllllllIIllIIllIllIIIlIIll;
                final int lllllllllllllIIllIIllIllIIIlIIlI;
                final byte[] lllllllllllllIIllIIllIllIIIlIIIl;
                int lllllllllllllIIllIIllIllIIlIIIlI;
                int lllllllllllllIIllIIllIllIIlIIIll;
                final short lllllllllllllIIllIIllIllIIIlIIII;
                short lllllllllllllIIllIIllIllIIIlllIl;
                short lllllllllllllIIllIIllIllIIIlllII;
                short lllllllllllllIIllIIllIllIIIllIll;
                byte[] lllllllllllllIIllIIllIllIIIllIlI;
                int lllllllllllllIIllIIllIllIIIllllI;
                byte[] lllllllllllllIIllIIllIllIIlIIIII;
                int lllllllllllllIIllIIllIllIIlIIIIl;
                PacketWrapper lllllllllllllIIllIIllIllIIIlllll;
                byte[] lllllllllllllIIllIIllIllIIIllIII;
                int lllllllllllllIIllIIllIllIIIllIIl;
                PacketWrapper lllllllllllllIIllIIllIllIIIlIlll;
                CustomByteType lllllllllllllIIllIIllIllIIIlIllI;
                final PacketWrapper lllllllllllllIIllIIllIllIIIIllll;
                this.handler(lllllllllllllIIllIIllIllIIIlIlIl -> {
                    lllllllllllllIIllIIllIllIIIlIlIl.cancel();
                    lllllllllllllIIllIIllIllIIIlIlII = lllllllllllllIIllIIllIllIIIlIlIl.read((Type<Integer>)Type.VAR_INT);
                    lllllllllllllIIllIIllIllIIIlIIll = lllllllllllllIIllIIllIllIIIlIlIl.read((Type<Byte>)Type.BYTE);
                    lllllllllllllIIllIIllIllIIIlIIlI = lllllllllllllIIllIIllIllIIIlIlIl.read((Type<Integer>)Type.VAR_INT);
                    lllllllllllllIIllIIllIllIIIlIIIl = new byte[lllllllllllllIIllIIllIllIIIlIIlI * 4];
                    for (lllllllllllllIIllIIllIllIIlIIIlI = 0; lllllllllllllIIllIIllIllIIlIIIlI < lllllllllllllIIllIIllIllIIIlIIlI; ++lllllllllllllIIllIIllIllIIlIIIlI) {
                        lllllllllllllIIllIIllIllIIlIIIll = lllllllllllllIIllIIllIllIIIlIlIl.read((Type<Byte>)Type.BYTE);
                        lllllllllllllIIllIIllIllIIIlIIIl[lllllllllllllIIllIIllIllIIlIIIlI * 4] = (byte)(lllllllllllllIIllIIllIllIIlIIIll >> 4 & 0xF);
                        lllllllllllllIIllIIllIllIIIlIIIl[lllllllllllllIIllIIllIllIIlIIIlI * 4 + 1] = lllllllllllllIIllIIllIllIIIlIlIl.read((Type<Byte>)Type.BYTE);
                        lllllllllllllIIllIIllIllIIIlIIIl[lllllllllllllIIllIIllIllIIlIIIlI * 4 + 2] = lllllllllllllIIllIIllIllIIIlIlIl.read((Type<Byte>)Type.BYTE);
                        lllllllllllllIIllIIllIllIIIlIIIl[lllllllllllllIIllIIllIllIIlIIIlI * 4 + 3] = (byte)(lllllllllllllIIllIIllIllIIlIIIll & 0xF);
                    }
                    lllllllllllllIIllIIllIllIIIlIIII = lllllllllllllIIllIIllIllIIIlIlIl.read((Type<Short>)Type.UNSIGNED_BYTE);
                    if (lllllllllllllIIllIIllIllIIIlIIII > 0) {
                        lllllllllllllIIllIIllIllIIIlllIl = lllllllllllllIIllIIllIllIIIlIlIl.read((Type<Short>)Type.UNSIGNED_BYTE);
                        lllllllllllllIIllIIllIllIIIlllII = lllllllllllllIIllIIllIllIIIlIlIl.read((Type<Short>)Type.UNSIGNED_BYTE);
                        lllllllllllllIIllIIllIllIIIllIll = lllllllllllllIIllIIllIllIIIlIlIl.read((Type<Short>)Type.UNSIGNED_BYTE);
                        lllllllllllllIIllIIllIllIIIllIlI = lllllllllllllIIllIIllIllIIIlIlIl.read(Type.BYTE_ARRAY_PRIMITIVE);
                        for (lllllllllllllIIllIIllIllIIIllllI = 0; lllllllllllllIIllIIllIllIIIllllI < lllllllllllllIIllIIllIllIIIlIIII; ++lllllllllllllIIllIIllIllIIIllllI) {
                            lllllllllllllIIllIIllIllIIlIIIII = new byte[lllllllllllllIIllIIllIllIIIlllIl + 3];
                            lllllllllllllIIllIIllIllIIlIIIII[0] = 0;
                            lllllllllllllIIllIIllIllIIlIIIII[1] = (byte)(lllllllllllllIIllIIllIllIIIlllII + lllllllllllllIIllIIllIllIIIllllI);
                            lllllllllllllIIllIIllIllIIlIIIII[2] = (byte)lllllllllllllIIllIIllIllIIIllIll;
                            for (lllllllllllllIIllIIllIllIIlIIIIl = 0; lllllllllllllIIllIIllIllIIlIIIIl < lllllllllllllIIllIIllIllIIIlllIl; ++lllllllllllllIIllIIllIllIIlIIIIl) {
                                lllllllllllllIIllIIllIllIIlIIIII[lllllllllllllIIllIIllIllIIlIIIIl + 3] = lllllllllllllIIllIIllIllIIIllIlI[lllllllllllllIIllIIllIllIIIllllI + lllllllllllllIIllIIllIllIIlIIIIl * lllllllllllllIIllIIllIllIIIlIIII];
                            }
                            lllllllllllllIIllIIllIllIIIlllll = PacketWrapper.create(52, null, lllllllllllllIIllIIllIllIIIlIlIl.user());
                            lllllllllllllIIllIIllIllIIIlllll.write(Type.VAR_INT, lllllllllllllIIllIIllIllIIIlIlII);
                            lllllllllllllIIllIIllIllIIIlllll.write(Type.SHORT, (short)lllllllllllllIIllIIllIllIIlIIIII.length);
                            lllllllllllllIIllIIllIllIIIlllll.write((Type<byte[]>)new CustomByteType(lllllllllllllIIllIIllIllIIlIIIII.length), lllllllllllllIIllIIllIllIIlIIIII);
                            PacketUtil.sendPacket(lllllllllllllIIllIIllIllIIIlllll, Protocol1_7_6_10TO1_8.class, true, true);
                        }
                    }
                    if (lllllllllllllIIllIIllIllIIIlIIlI > 0) {
                        lllllllllllllIIllIIllIllIIIllIII = new byte[lllllllllllllIIllIIllIllIIIlIIlI * 3 + 1];
                        lllllllllllllIIllIIllIllIIIllIII[0] = 1;
                        for (lllllllllllllIIllIIllIllIIIllIIl = 0; lllllllllllllIIllIIllIllIIIllIIl < lllllllllllllIIllIIllIllIIIlIIlI; ++lllllllllllllIIllIIllIllIIIllIIl) {
                            lllllllllllllIIllIIllIllIIIllIII[lllllllllllllIIllIIllIllIIIllIIl * 3 + 1] = (byte)(lllllllllllllIIllIIllIllIIIlIIIl[lllllllllllllIIllIIllIllIIIllIIl * 4] << 4 | (lllllllllllllIIllIIllIllIIIlIIIl[lllllllllllllIIllIIllIllIIIllIIl * 4 + 3] & 0xF));
                            lllllllllllllIIllIIllIllIIIllIII[lllllllllllllIIllIIllIllIIIllIIl * 3 + 2] = lllllllllllllIIllIIllIllIIIlIIIl[lllllllllllllIIllIIllIllIIIllIIl * 4 + 1];
                            lllllllllllllIIllIIllIllIIIllIII[lllllllllllllIIllIIllIllIIIllIIl * 3 + 3] = lllllllllllllIIllIIllIllIIIlIIIl[lllllllllllllIIllIIllIllIIIllIIl * 4 + 2];
                        }
                        lllllllllllllIIllIIllIllIIIlIlll = PacketWrapper.create(52, null, lllllllllllllIIllIIllIllIIIlIlIl.user());
                        lllllllllllllIIllIIllIllIIIlIlll.write(Type.VAR_INT, lllllllllllllIIllIIllIllIIIlIlII);
                        lllllllllllllIIllIIllIllIIIlIlll.write(Type.SHORT, (short)lllllllllllllIIllIIllIllIIIllIII.length);
                        lllllllllllllIIllIIllIllIIIlIllI = new CustomByteType(lllllllllllllIIllIIllIllIIIllIII.length);
                        lllllllllllllIIllIIllIllIIIlIlll.write((Type<byte[]>)lllllllllllllIIllIIllIllIIIlIllI, lllllllllllllIIllIIllIllIIIllIII);
                        PacketUtil.sendPacket(lllllllllllllIIllIIllIllIIIlIlll, Protocol1_7_6_10TO1_8.class, true, true);
                    }
                    lllllllllllllIIllIIllIllIIIIllll = PacketWrapper.create(52, null, lllllllllllllIIllIIllIllIIIlIlIl.user());
                    lllllllllllllIIllIIllIllIIIIllll.write(Type.VAR_INT, lllllllllllllIIllIIllIllIIIlIlII);
                    lllllllllllllIIllIIllIllIIIIllll.write(Type.SHORT, (Short)2);
                    lllllllllllllIIllIIllIllIIIIllll.write((Type<byte[]>)new CustomByteType(2), new byte[] { 2, lllllllllllllIIllIIllIllIIIlIIll });
                    PacketUtil.sendPacket(lllllllllllllIIllIIllIllIIIIllll, Protocol1_7_6_10TO1_8.class, true, true);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIIlIlIlIlIlllIlIlll).registerClientbound(ClientboundPackets1_8.BLOCK_ENTITY_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                final Position llllllllllllllIIIlIIIlIlIllllIlI;
                this.handler(llllllllllllllIIIlIIIlIlIllllIll -> {
                    llllllllllllllIIIlIIIlIlIllllIlI = llllllllllllllIIIlIIIlIlIllllIll.read(Type.POSITION);
                    llllllllllllllIIIlIIIlIlIllllIll.write(Type.INT, llllllllllllllIIIlIIIlIlIllllIlI.getX());
                    llllllllllllllIIIlIIIlIlIllllIll.write(Type.SHORT, (short)llllllllllllllIIIlIIIlIlIllllIlI.getY());
                    llllllllllllllIIIlIIIlIlIllllIll.write(Type.INT, llllllllllllllIIIlIIIlIlIllllIlI.getZ());
                    return;
                });
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.NBT, Types1_7_6_10.COMPRESSED_NBT);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIIlIlIlIlIlllIlIlll).cancelClientbound(ClientboundPackets1_8.SERVER_DIFFICULTY);
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIIlIlIlIlIlllIlIlll).cancelClientbound(ClientboundPackets1_8.COMBAT_EVENT);
        ((Protocol<ClientboundPackets1_8, ClientboundPackets1_7, S1, S2>)lllllllllllllIIlIlIlIlIlllIlIlll).registerClientbound(ClientboundPackets1_8.WORLD_BORDER, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int lllllllllllllllIlIIIIIIllIlIllIl;
                final WorldBorder lllllllllllllllIlIIIIIIllIlIllII;
                this.handler(lllllllllllllllIlIIIIIIllIlIlIll -> {
                    lllllllllllllllIlIIIIIIllIlIllIl = lllllllllllllllIlIIIIIIllIlIlIll.read((Type<Integer>)Type.VAR_INT);
                    lllllllllllllllIlIIIIIIllIlIllII = lllllllllllllllIlIIIIIIllIlIlIll.user().get(WorldBorder.class);
                    if (lllllllllllllllIlIIIIIIllIlIllIl == 0) {
                        lllllllllllllllIlIIIIIIllIlIllII.setSize(lllllllllllllllIlIIIIIIllIlIlIll.read((Type<Double>)Type.DOUBLE));
                    }
                    else if (lllllllllllllllIlIIIIIIllIlIllIl == 1) {
                        lllllllllllllllIlIIIIIIllIlIllII.lerpSize(lllllllllllllllIlIIIIIIllIlIlIll.read((Type<Double>)Type.DOUBLE), lllllllllllllllIlIIIIIIllIlIlIll.read((Type<Double>)Type.DOUBLE), lllllllllllllllIlIIIIIIllIlIlIll.read((Type<Long>)VarLongType.VAR_LONG));
                    }
                    else if (lllllllllllllllIlIIIIIIllIlIllIl == 2) {
                        lllllllllllllllIlIIIIIIllIlIllII.setCenter(lllllllllllllllIlIIIIIIllIlIlIll.read((Type<Double>)Type.DOUBLE), lllllllllllllllIlIIIIIIllIlIlIll.read((Type<Double>)Type.DOUBLE));
                    }
                    else if (lllllllllllllllIlIIIIIIllIlIllIl == 3) {
                        lllllllllllllllIlIIIIIIllIlIllII.init(lllllllllllllllIlIIIIIIllIlIlIll.read((Type<Double>)Type.DOUBLE), lllllllllllllllIlIIIIIIllIlIlIll.read((Type<Double>)Type.DOUBLE), lllllllllllllllIlIIIIIIllIlIlIll.read((Type<Double>)Type.DOUBLE), lllllllllllllllIlIIIIIIllIlIlIll.read((Type<Double>)Type.DOUBLE), lllllllllllllllIlIIIIIIllIlIlIll.read((Type<Long>)VarLongType.VAR_LONG), lllllllllllllllIlIIIIIIllIlIlIll.read((Type<Integer>)Type.VAR_INT), lllllllllllllllIlIIIIIIllIlIlIll.read((Type<Integer>)Type.VAR_INT), lllllllllllllllIlIIIIIIllIlIlIll.read((Type<Integer>)Type.VAR_INT));
                    }
                    else if (lllllllllllllllIlIIIIIIllIlIllIl == 4) {
                        lllllllllllllllIlIIIIIIllIlIllII.setWarningTime(lllllllllllllllIlIIIIIIllIlIlIll.read((Type<Integer>)Type.VAR_INT));
                    }
                    else if (lllllllllllllllIlIIIIIIllIlIllIl == 5) {
                        lllllllllllllllIlIIIIIIllIlIllII.setWarningBlocks(lllllllllllllllIlIIIIIIllIlIlIll.read((Type<Integer>)Type.VAR_INT));
                    }
                    lllllllllllllllIlIIIIIIllIlIlIll.cancel();
                });
            }
        });
    }
}
