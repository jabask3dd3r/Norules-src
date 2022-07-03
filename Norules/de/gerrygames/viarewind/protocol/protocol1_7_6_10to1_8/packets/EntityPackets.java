package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.packets;

import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.*;
import com.viaversion.viaversion.protocols.protocol1_8.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.items.*;
import com.viaversion.viaversion.api.minecraft.*;
import io.netty.buffer.*;
import de.gerrygames.viarewind.utils.*;
import de.gerrygames.viarewind.replacement.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.metadata.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.api.protocol.*;

public class EntityPackets
{
    public static void register(final Protocol1_7_6_10TO1_8 lllllllllllllllllIlllllIlIlIllII) {
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIlllllIlIlIllII).registerClientbound(ClientboundPackets1_8.ENTITY_EQUIPMENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT, Type.INT);
                this.map(Type.SHORT);
                this.map(Type.ITEM, Types1_7_6_10.COMPRESSED_NBT_ITEM);
                final Item lllllllllllllllIIllllIlIllllIIlI;
                this.handler(lllllllllllllllIIllllIlIllllIIll -> {
                    lllllllllllllllIIllllIlIllllIIlI = lllllllllllllllIIllllIlIllllIIll.get(Types1_7_6_10.COMPRESSED_NBT_ITEM, 0);
                    ItemRewriter.toClient(lllllllllllllllIIllllIlIllllIIlI);
                    lllllllllllllllIIllllIlIllllIIll.set(Types1_7_6_10.COMPRESSED_NBT_ITEM, 0, lllllllllllllllIIllllIlIllllIIlI);
                    return;
                });
                this.handler(lllllllllllllllIIllllIlIllllIlll -> {
                    if (lllllllllllllllIIllllIlIllllIlll.get((Type<Short>)Type.SHORT, 0) > 4) {
                        lllllllllllllllIIllllIlIllllIlll.cancel();
                    }
                    return;
                });
                EntityTracker lllllllllllllllIIllllIllIIIIIIll;
                UUID lllllllllllllllIIllllIllIIIIIIlI;
                Item[] lllllllllllllllIIllllIllIIIIIIIl;
                final EntityTracker entityTracker;
                final UUID lllllllllllllIllllIlIIllIIllIllI;
                final Item[] lllllllllllllIllllIlIIllIIllIlIl;
                GameProfileStorage lllllllllllllllIIllllIllIIIIIIII;
                GameProfileStorage.GameProfile lllllllllllllllIIllllIlIllllllll;
                this.handler(lllllllllllllllIIllllIllIIIIIlII -> {
                    if (!lllllllllllllllIIllllIllIIIIIlII.isCancelled()) {
                        lllllllllllllllIIllllIllIIIIIIll = lllllllllllllllIIllllIllIIIIIlII.user().get(EntityTracker.class);
                        lllllllllllllllIIllllIllIIIIIIlI = lllllllllllllllIIllllIllIIIIIIll.getPlayerUUID(lllllllllllllllIIllllIllIIIIIlII.get((Type<Integer>)Type.INT, 0));
                        if (lllllllllllllllIIllllIllIIIIIIlI != null) {
                            lllllllllllllllIIllllIllIIIIIIIl = lllllllllllllllIIllllIllIIIIIIll.getPlayerEquipment(lllllllllllllllIIllllIllIIIIIIlI);
                            if (lllllllllllllllIIllllIllIIIIIIIl == null) {
                                lllllllllllllllIIllllIllIIIIIIIl = new Item[5];
                                entityTracker.setPlayerEquipment(lllllllllllllIllllIlIIllIIllIllI, lllllllllllllIllllIlIIllIIllIlIl);
                            }
                            lllllllllllllllIIllllIllIIIIIIIl[lllllllllllllllIIllllIllIIIIIlII.get((Type<Short>)Type.SHORT, 0)] = lllllllllllllllIIllllIllIIIIIlII.get(Types1_7_6_10.COMPRESSED_NBT_ITEM, 0);
                            lllllllllllllllIIllllIllIIIIIIII = lllllllllllllllIIllllIllIIIIIlII.user().get(GameProfileStorage.class);
                            lllllllllllllllIIllllIlIllllllll = lllllllllllllllIIllllIllIIIIIIII.get(lllllllllllllllIIllllIllIIIIIIlI);
                            if (lllllllllllllllIIllllIlIllllllll != null && lllllllllllllllIIllllIlIllllllll.gamemode == 3) {
                                lllllllllllllllIIllllIllIIIIIlII.cancel();
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIlllllIlIlIllII).registerClientbound(ClientboundPackets1_8.USE_BED, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT, Type.INT);
                final Position lllIIIIIllIllI;
                this.handler(lllIIIIIllIlll -> {
                    lllIIIIIllIllI = lllIIIIIllIlll.read(Type.POSITION);
                    lllIIIIIllIlll.write(Type.INT, lllIIIIIllIllI.getX());
                    lllIIIIIllIlll.write(Type.UNSIGNED_BYTE, (short)lllIIIIIllIllI.getY());
                    lllIIIIIllIlll.write(Type.INT, lllIIIIIllIllI.getZ());
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIlllllIlIlIllII).registerClientbound(ClientboundPackets1_8.COLLECT_ITEM, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT, Type.INT);
                this.map(Type.VAR_INT, Type.INT);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIlllllIlIlIllII).registerClientbound(ClientboundPackets1_8.ENTITY_VELOCITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT, Type.INT);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIlllllIlIlIllII).registerClientbound(ClientboundPackets1_8.DESTROY_ENTITIES, new PacketRemapper() {
            @Override
            public void registerMap() {
                int[] lllllllllllllIlIIIIlllIlIIlIIIlI;
                final EntityTracker lllllllllllllIlIIIIlllIlIIlIIIIl;
                final int[] array;
                boolean lllllllllllllIlIIIIlllIlIIIlllII;
                int i = 0;
                int lllllllllllllIlIIIIlllIlIIlIIlll;
                int[] lllllllllllllIlIIIIlllIlIIlIIllI;
                int[] lllllllllllllIlIIIIlllIlIIlIIlIl;
                PacketWrapper lllllllllllllIlIIIIlllIlIIlIIlII;
                this.handler(lllllllllllllIlIIIIlllIlIIlIIIII -> {
                    lllllllllllllIlIIIIlllIlIIlIIIlI = lllllllllllllIlIIIIlllIlIIlIIIII.read(Type.VAR_INT_ARRAY_PRIMITIVE);
                    lllllllllllllIlIIIIlllIlIIlIIIIl = lllllllllllllIlIIIIlllIlIIlIIIII.user().get(EntityTracker.class);
                    for (lllllllllllllIlIIIIlllIlIIIlllII = (array.length != 0); i < (lllllllllllllIlIIIIlllIlIIIlllII ? 1 : 0); ++i) {
                        lllllllllllllIlIIIIlllIlIIlIIlll = array[i];
                        lllllllllllllIlIIIIlllIlIIlIIIIl.removeEntity(lllllllllllllIlIIIIlllIlIIlIIlll);
                    }
                    while (lllllllllllllIlIIIIlllIlIIlIIIlI.length > 127) {
                        lllllllllllllIlIIIIlllIlIIlIIllI = new int[127];
                        System.arraycopy(lllllllllllllIlIIIIlllIlIIlIIIlI, 0, lllllllllllllIlIIIIlllIlIIlIIllI, 0, 127);
                        lllllllllllllIlIIIIlllIlIIlIIlIl = new int[lllllllllllllIlIIIIlllIlIIlIIIlI.length - 127];
                        System.arraycopy(lllllllllllllIlIIIIlllIlIIlIIIlI, 127, lllllllllllllIlIIIIlllIlIIlIIlIl, 0, lllllllllllllIlIIIIlllIlIIlIIlIl.length);
                        lllllllllllllIlIIIIlllIlIIlIIIlI = lllllllllllllIlIIIIlllIlIIlIIlIl;
                        lllllllllllllIlIIIIlllIlIIlIIlII = PacketWrapper.create(19, null, lllllllllllllIlIIIIlllIlIIlIIIII.user());
                        lllllllllllllIlIIIIlllIlIIlIIlII.write(Types1_7_6_10.INT_ARRAY, lllllllllllllIlIIIIlllIlIIlIIllI);
                        PacketUtil.sendPacket(lllllllllllllIlIIIIlllIlIIlIIlII, Protocol1_7_6_10TO1_8.class);
                    }
                    lllllllllllllIlIIIIlllIlIIlIIIII.write(Types1_7_6_10.INT_ARRAY, lllllllllllllIlIIIIlllIlIIlIIIlI);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIlllllIlIlIllII).registerClientbound(ClientboundPackets1_8.ENTITY_MOVEMENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT, Type.INT);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIlllllIlIlIllII).registerClientbound(ClientboundPackets1_8.ENTITY_POSITION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT, Type.INT);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.BOOLEAN, Type.NOTHING);
                final int lllllllllllllIIllllllllIIlIlllIl;
                final EntityTracker lllllllllllllIIllllllllIIlIlllII;
                final EntityReplacement lllllllllllllIIllllllllIIlIllIll;
                int lllllllllllllIIllllllllIIllIIIIl;
                int lllllllllllllIIllllllllIIllIIIII;
                int lllllllllllllIIllllllllIIlIlllll;
                this.handler(lllllllllllllIIllllllllIIlIllIlI -> {
                    lllllllllllllIIllllllllIIlIlllIl = lllllllllllllIIllllllllIIlIllIlI.get((Type<Integer>)Type.INT, 0);
                    lllllllllllllIIllllllllIIlIlllII = lllllllllllllIIllllllllIIlIllIlI.user().get(EntityTracker.class);
                    lllllllllllllIIllllllllIIlIllIll = lllllllllllllIIllllllllIIlIlllII.getEntityReplacement(lllllllllllllIIllllllllIIlIlllIl);
                    if (lllllllllllllIIllllllllIIlIllIll != null) {
                        lllllllllllllIIllllllllIIlIllIlI.cancel();
                        lllllllllllllIIllllllllIIllIIIIl = lllllllllllllIIllllllllIIlIllIlI.get((Type<Byte>)Type.BYTE, 0);
                        lllllllllllllIIllllllllIIllIIIII = lllllllllllllIIllllllllIIlIllIlI.get((Type<Byte>)Type.BYTE, 1);
                        lllllllllllllIIllllllllIIlIlllll = lllllllllllllIIllllllllIIlIllIlI.get((Type<Byte>)Type.BYTE, 2);
                        lllllllllllllIIllllllllIIlIllIll.relMove(lllllllllllllIIllllllllIIllIIIIl / 32.0, lllllllllllllIIllllllllIIllIIIII / 32.0, lllllllllllllIIllllllllIIlIlllll / 32.0);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIlllllIlIlIllII).registerClientbound(ClientboundPackets1_8.ENTITY_ROTATION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT, Type.INT);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.BOOLEAN, Type.NOTHING);
                final int lllllllllllllIIIlIlIlllIlllllIll;
                final EntityTracker lllllllllllllIIIlIlIlllIlllllIlI;
                final EntityReplacement lllllllllllllIIIlIlIlllIlllllIIl;
                int lllllllllllllIIIlIlIlllIlllllllI;
                int lllllllllllllIIIlIlIlllIllllllIl;
                this.handler(lllllllllllllIIIlIlIlllIlllllIII -> {
                    lllllllllllllIIIlIlIlllIlllllIll = lllllllllllllIIIlIlIlllIlllllIII.get((Type<Integer>)Type.INT, 0);
                    lllllllllllllIIIlIlIlllIlllllIlI = lllllllllllllIIIlIlIlllIlllllIII.user().get(EntityTracker.class);
                    lllllllllllllIIIlIlIlllIlllllIIl = lllllllllllllIIIlIlIlllIlllllIlI.getEntityReplacement(lllllllllllllIIIlIlIlllIlllllIll);
                    if (lllllllllllllIIIlIlIlllIlllllIIl != null) {
                        lllllllllllllIIIlIlIlllIlllllIII.cancel();
                        lllllllllllllIIIlIlIlllIlllllllI = lllllllllllllIIIlIlIlllIlllllIII.get((Type<Byte>)Type.BYTE, 0);
                        lllllllllllllIIIlIlIlllIllllllIl = lllllllllllllIIIlIlIlllIlllllIII.get((Type<Byte>)Type.BYTE, 1);
                        lllllllllllllIIIlIlIlllIlllllIIl.setYawPitch(lllllllllllllIIIlIlIlllIlllllllI * 360.0f / 256.0f, lllllllllllllIIIlIlIlllIllllllIl * 360.0f / 256.0f);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIlllllIlIlIllII).registerClientbound(ClientboundPackets1_8.ENTITY_POSITION_AND_ROTATION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT, Type.INT);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.BOOLEAN, Type.NOTHING);
                final int lllllllllllllIIlllllIlIllllIIlII;
                final EntityTracker lllllllllllllIIlllllIlIllllIIIll;
                final EntityReplacement lllllllllllllIIlllllIlIllllIIIlI;
                int lllllllllllllIIlllllIlIllllIlIlI;
                int lllllllllllllIIlllllIlIllllIlIIl;
                int lllllllllllllIIlllllIlIllllIlIII;
                int lllllllllllllIIlllllIlIllllIIlll;
                int lllllllllllllIIlllllIlIllllIIllI;
                this.handler(lllllllllllllIIlllllIlIllllIIlIl -> {
                    lllllllllllllIIlllllIlIllllIIlII = lllllllllllllIIlllllIlIllllIIlIl.get((Type<Integer>)Type.INT, 0);
                    lllllllllllllIIlllllIlIllllIIIll = lllllllllllllIIlllllIlIllllIIlIl.user().get(EntityTracker.class);
                    lllllllllllllIIlllllIlIllllIIIlI = lllllllllllllIIlllllIlIllllIIIll.getEntityReplacement(lllllllllllllIIlllllIlIllllIIlII);
                    if (lllllllllllllIIlllllIlIllllIIIlI != null) {
                        lllllllllllllIIlllllIlIllllIIlIl.cancel();
                        lllllllllllllIIlllllIlIllllIlIlI = lllllllllllllIIlllllIlIllllIIlIl.get((Type<Byte>)Type.BYTE, 0);
                        lllllllllllllIIlllllIlIllllIlIIl = lllllllllllllIIlllllIlIllllIIlIl.get((Type<Byte>)Type.BYTE, 1);
                        lllllllllllllIIlllllIlIllllIlIII = lllllllllllllIIlllllIlIllllIIlIl.get((Type<Byte>)Type.BYTE, 2);
                        lllllllllllllIIlllllIlIllllIIlll = lllllllllllllIIlllllIlIllllIIlIl.get((Type<Byte>)Type.BYTE, 3);
                        lllllllllllllIIlllllIlIllllIIllI = lllllllllllllIIlllllIlIllllIIlIl.get((Type<Byte>)Type.BYTE, 4);
                        lllllllllllllIIlllllIlIllllIIIlI.relMove(lllllllllllllIIlllllIlIllllIlIlI / 32.0, lllllllllllllIIlllllIlIllllIlIIl / 32.0, lllllllllllllIIlllllIlIllllIlIII / 32.0);
                        lllllllllllllIIlllllIlIllllIIIlI.setYawPitch(lllllllllllllIIlllllIlIllllIIlll * 360.0f / 256.0f, lllllllllllllIIlllllIlIllllIIllI * 360.0f / 256.0f);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIlllllIlIlIllII).registerClientbound(ClientboundPackets1_8.ENTITY_TELEPORT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT, Type.INT);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.BOOLEAN, Type.NOTHING);
                final int llllllllllllllIIllIlIlllIIIIIIlI;
                final EntityTracker llllllllllllllIIllIlIlllIIIIIIIl;
                final Entity1_10Types.EntityType llllllllllllllIIllIlIlllIIIIIIII;
                int llllllllllllllIIllIlIlllIIIIIlII;
                this.handler(llllllllllllllIIllIlIlllIIIIIIll -> {
                    llllllllllllllIIllIlIlllIIIIIIlI = llllllllllllllIIllIlIlllIIIIIIll.get((Type<Integer>)Type.INT, 0);
                    llllllllllllllIIllIlIlllIIIIIIIl = llllllllllllllIIllIlIlllIIIIIIll.user().get(EntityTracker.class);
                    llllllllllllllIIllIlIlllIIIIIIII = llllllllllllllIIllIlIlllIIIIIIIl.getClientEntityTypes().get(llllllllllllllIIllIlIlllIIIIIIlI);
                    if (llllllllllllllIIllIlIlllIIIIIIII == Entity1_10Types.EntityType.MINECART_ABSTRACT) {
                        llllllllllllllIIllIlIlllIIIIIlII = llllllllllllllIIllIlIlllIIIIIIll.get((Type<Integer>)Type.INT, 2);
                        llllllllllllllIIllIlIlllIIIIIlII += 12;
                        llllllllllllllIIllIlIlllIIIIIIll.set(Type.INT, 2, llllllllllllllIIllIlIlllIIIIIlII);
                    }
                    return;
                });
                final int llllllllllllllIIllIlIlllIIIlIlIl;
                final EntityTracker llllllllllllllIIllIlIlllIIIlIlII;
                final EntityReplacement llllllllllllllIIllIlIlllIIIlIIll;
                int llllllllllllllIIllIlIlllIIIllIll;
                int llllllllllllllIIllIlIlllIIIllIlI;
                int llllllllllllllIIllIlIlllIIIllIIl;
                int llllllllllllllIIllIlIlllIIIllIII;
                int llllllllllllllIIllIlIlllIIIlIlll;
                this.handler(llllllllllllllIIllIlIlllIIIlIIlI -> {
                    llllllllllllllIIllIlIlllIIIlIlIl = llllllllllllllIIllIlIlllIIIlIIlI.get((Type<Integer>)Type.INT, 0);
                    llllllllllllllIIllIlIlllIIIlIlII = llllllllllllllIIllIlIlllIIIlIIlI.user().get(EntityTracker.class);
                    llllllllllllllIIllIlIlllIIIlIIll = llllllllllllllIIllIlIlllIIIlIlII.getEntityReplacement(llllllllllllllIIllIlIlllIIIlIlIl);
                    if (llllllllllllllIIllIlIlllIIIlIIll != null) {
                        llllllllllllllIIllIlIlllIIIlIIlI.cancel();
                        llllllllllllllIIllIlIlllIIIllIll = llllllllllllllIIllIlIlllIIIlIIlI.get((Type<Integer>)Type.INT, 1);
                        llllllllllllllIIllIlIlllIIIllIlI = llllllllllllllIIllIlIlllIIIlIIlI.get((Type<Integer>)Type.INT, 2);
                        llllllllllllllIIllIlIlllIIIllIIl = llllllllllllllIIllIlIlllIIIlIIlI.get((Type<Integer>)Type.INT, 3);
                        llllllllllllllIIllIlIlllIIIllIII = llllllllllllllIIllIlIlllIIIlIIlI.get((Type<Byte>)Type.BYTE, 0);
                        llllllllllllllIIllIlIlllIIIlIlll = llllllllllllllIIllIlIlllIIIlIIlI.get((Type<Byte>)Type.BYTE, 1);
                        llllllllllllllIIllIlIlllIIIlIIll.setLocation(llllllllllllllIIllIlIlllIIIllIll / 32.0, llllllllllllllIIllIlIlllIIIllIlI / 32.0, llllllllllllllIIllIlIlllIIIllIIl / 32.0);
                        llllllllllllllIIllIlIlllIIIlIIll.setYawPitch(llllllllllllllIIllIlIlllIIIllIII * 360.0f / 256.0f, llllllllllllllIIllIlIlllIIIlIlll * 360.0f / 256.0f);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIlllllIlIlIllII).registerClientbound(ClientboundPackets1_8.ENTITY_HEAD_LOOK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT, Type.INT);
                this.map(Type.BYTE);
                final int lllllllllllllIlIIIIllIIlIlllIIll;
                final EntityTracker lllllllllllllIlIIIIllIIlIlllIIlI;
                final EntityReplacement lllllllllllllIlIIIIllIIlIlllIIIl;
                int lllllllllllllIlIIIIllIIlIlllIlIl;
                this.handler(lllllllllllllIlIIIIllIIlIlllIlII -> {
                    lllllllllllllIlIIIIllIIlIlllIIll = lllllllllllllIlIIIIllIIlIlllIlII.get((Type<Integer>)Type.INT, 0);
                    lllllllllllllIlIIIIllIIlIlllIIlI = lllllllllllllIlIIIIllIIlIlllIlII.user().get(EntityTracker.class);
                    lllllllllllllIlIIIIllIIlIlllIIIl = lllllllllllllIlIIIIllIIlIlllIIlI.getEntityReplacement(lllllllllllllIlIIIIllIIlIlllIIll);
                    if (lllllllllllllIlIIIIllIIlIlllIIIl != null) {
                        lllllllllllllIlIIIIllIIlIlllIlII.cancel();
                        lllllllllllllIlIIIIllIIlIlllIlIl = lllllllllllllIlIIIIllIIlIlllIlII.get((Type<Byte>)Type.BYTE, 0);
                        lllllllllllllIlIIIIllIIlIlllIIIl.setHeadYaw(lllllllllllllIlIIIIllIIlIlllIlIl * 360.0f / 256.0f);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIlllllIlIlIllII).registerClientbound(ClientboundPackets1_8.ATTACH_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.BOOLEAN);
                final boolean lllllllllllllIIIIlIIIIIlIIIIIIlI;
                int lllllllllllllIIIIlIIIIIlIIIIIIIl;
                int lllllllllllllIIIIlIIIIIlIIIIIIII;
                EntityTracker lllllllllllllIIIIlIIIIIIllllllll;
                this.handler(lllllllllllllIIIIlIIIIIlIIIIIIll -> {
                    lllllllllllllIIIIlIIIIIlIIIIIIlI = lllllllllllllIIIIlIIIIIlIIIIIIll.get((Type<Boolean>)Type.BOOLEAN, 0);
                    if (!lllllllllllllIIIIlIIIIIlIIIIIIlI) {
                        lllllllllllllIIIIlIIIIIlIIIIIIIl = lllllllllllllIIIIlIIIIIlIIIIIIll.get((Type<Integer>)Type.INT, 0);
                        lllllllllllllIIIIlIIIIIlIIIIIIII = lllllllllllllIIIIlIIIIIlIIIIIIll.get((Type<Integer>)Type.INT, 1);
                        lllllllllllllIIIIlIIIIIIllllllll = lllllllllllllIIIIlIIIIIlIIIIIIll.user().get(EntityTracker.class);
                        lllllllllllllIIIIlIIIIIIllllllll.setPassenger(lllllllllllllIIIIlIIIIIlIIIIIIII, lllllllllllllIIIIlIIIIIlIIIIIIIl);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIlllllIlIlIllII).registerClientbound(ClientboundPackets1_8.ENTITY_METADATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT, Type.INT);
                this.map(Types1_8.METADATA_LIST, Types1_7_6_10.METADATA_LIST);
                final List<Metadata> lllllllllllllllIIllIlllllIllIIll;
                final int lllllllllllllllIIllIlllllIllIIlI;
                final EntityTracker lllllllllllllllIIllIlllllIllIIIl;
                EntityReplacement lllllllllllllllIIllIlllllIllIlIl;
                this.handler(lllllllllllllllIIllIlllllIllIIII -> {
                    lllllllllllllllIIllIlllllIllIIll = lllllllllllllllIIllIlllllIllIIII.get(Types1_7_6_10.METADATA_LIST, 0);
                    lllllllllllllllIIllIlllllIllIIlI = lllllllllllllllIIllIlllllIllIIII.get((Type<Integer>)Type.INT, 0);
                    lllllllllllllllIIllIlllllIllIIIl = lllllllllllllllIIllIlllllIllIIII.user().get(EntityTracker.class);
                    if (lllllllllllllllIIllIlllllIllIIIl.getClientEntityTypes().containsKey(lllllllllllllllIIllIlllllIllIIlI)) {
                        lllllllllllllllIIllIlllllIllIlIl = lllllllllllllllIIllIlllllIllIIIl.getEntityReplacement(lllllllllllllllIIllIlllllIllIIlI);
                        if (lllllllllllllllIIllIlllllIllIlIl != null) {
                            lllllllllllllllIIllIlllllIllIIII.cancel();
                            lllllllllllllllIIllIlllllIllIlIl.updateMetadata(lllllllllllllllIIllIlllllIllIIll);
                        }
                        else {
                            MetadataRewriter.transform(lllllllllllllllIIllIlllllIllIIIl.getClientEntityTypes().get(lllllllllllllllIIllIlllllIllIIlI), lllllllllllllllIIllIlllllIllIIll);
                            if (lllllllllllllllIIllIlllllIllIIll.isEmpty()) {
                                lllllllllllllllIIllIlllllIllIIII.cancel();
                            }
                        }
                    }
                    else {
                        lllllllllllllllIIllIlllllIllIIIl.addMetadataToBuffer(lllllllllllllllIIllIlllllIllIIlI, lllllllllllllllIIllIlllllIllIIll);
                        lllllllllllllllIIllIlllllIllIIII.cancel();
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIlllllIlIlIllII).registerClientbound(ClientboundPackets1_8.ENTITY_EFFECT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT, Type.INT);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.VAR_INT, Type.SHORT);
                this.map(Type.BYTE, Type.NOTHING);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIlllllIlIlIllII).registerClientbound(ClientboundPackets1_8.REMOVE_ENTITY_EFFECT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT, Type.INT);
                this.map(Type.BYTE);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIlllllIlIlIllII).registerClientbound(ClientboundPackets1_8.ENTITY_PROPERTIES, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT, Type.INT);
                final int lllllllllllllIIIIIlIIlIIIlIlIlIl;
                final EntityTracker lllllllllllllIIIIIlIIlIIIlIlIlII;
                int lllllllllllllIIIIIlIIlIIIlIlIIll;
                int lllllllllllllIIIIIlIIlIIIlIlIlll;
                int lllllllllllllIIIIIlIIlIIIlIllIII;
                int lllllllllllllIIIIIlIIlIIIlIllIIl;
                this.handler(lllllllllllllIIIIIlIIlIIIlIlIIlI -> {
                    lllllllllllllIIIIIlIIlIIIlIlIlIl = lllllllllllllIIIIIlIIlIIIlIlIIlI.get((Type<Integer>)Type.INT, 0);
                    lllllllllllllIIIIIlIIlIIIlIlIlII = lllllllllllllIIIIIlIIlIIIlIlIIlI.user().get(EntityTracker.class);
                    if (lllllllllllllIIIIIlIIlIIIlIlIlII.getEntityReplacement(lllllllllllllIIIIIlIIlIIIlIlIlIl) != null) {
                        lllllllllllllIIIIIlIIlIIIlIlIIlI.cancel();
                    }
                    else {
                        for (lllllllllllllIIIIIlIIlIIIlIlIIll = lllllllllllllIIIIIlIIlIIIlIlIIlI.passthrough((Type<Integer>)Type.INT), lllllllllllllIIIIIlIIlIIIlIlIlll = 0; lllllllllllllIIIIIlIIlIIIlIlIlll < lllllllllllllIIIIIlIIlIIIlIlIIll; ++lllllllllllllIIIIIlIIlIIIlIlIlll) {
                            lllllllllllllIIIIIlIIlIIIlIlIIlI.passthrough(Type.STRING);
                            lllllllllllllIIIIIlIIlIIIlIlIIlI.passthrough((Type<Object>)Type.DOUBLE);
                            lllllllllllllIIIIIlIIlIIIlIllIII = lllllllllllllIIIIIlIIlIIIlIlIIlI.read((Type<Integer>)Type.VAR_INT);
                            lllllllllllllIIIIIlIIlIIIlIlIIlI.write(Type.SHORT, (short)lllllllllllllIIIIIlIIlIIIlIllIII);
                            for (lllllllllllllIIIIIlIIlIIIlIllIIl = 0; lllllllllllllIIIIIlIIlIIIlIllIIl < lllllllllllllIIIIIlIIlIIIlIllIII; ++lllllllllllllIIIIIlIIlIIIlIllIIl) {
                                lllllllllllllIIIIIlIIlIIIlIlIIlI.passthrough(Type.UUID);
                                lllllllllllllIIIIIlIIlIIIlIlIIlI.passthrough((Type<Object>)Type.DOUBLE);
                                lllllllllllllIIIIIlIIlIIIlIlIIlI.passthrough((Type<Object>)Type.BYTE);
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIlllllIlIlIllII).cancelClientbound(ClientboundPackets1_8.UPDATE_ENTITY_NBT);
    }
}
