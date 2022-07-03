package de.gerrygames.viarewind.protocol.protocol1_8to1_9.packets;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.protocols.protocol1_8.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.util.*;
import io.netty.buffer.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.*;
import de.gerrygames.viarewind.utils.*;
import de.gerrygames.viarewind.replacement.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.metadata.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.items.*;
import com.viaversion.viaversion.util.*;
import java.util.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage.*;

public class EntityPackets
{
    public static void register(final Protocol<ClientboundPackets1_9, ClientboundPackets1_8, ServerboundPackets1_9, ServerboundPackets1_8> llllllllllllllIIIIIlIlllIllIllII) {
        llllllllllllllIIIIIlIlllIllIllII.registerClientbound(ClientboundPackets1_9.ENTITY_STATUS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                final byte lllllllllllllIIllIllIIIIIIllIllI;
                this.handler(lllllllllllllIIllIllIIIIIIllIlll -> {
                    lllllllllllllIIllIllIIIIIIllIllI = lllllllllllllIIllIllIIIIIIllIlll.read((Type<Byte>)Type.BYTE);
                    if (lllllllllllllIIllIllIIIIIIllIllI > 23) {
                        lllllllllllllIIllIllIIIIIIllIlll.cancel();
                    }
                    else {
                        lllllllllllllIIllIllIIIIIIllIlll.write(Type.BYTE, lllllllllllllIIllIllIIIIIIllIllI);
                    }
                });
            }
        });
        llllllllllllllIIIIIlIlllIllIllII.registerClientbound(ClientboundPackets1_9.ENTITY_POSITION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                final int llllllllllllllIIlIlIlIIIlIllIlII;
                final int llllllllllllllIIlIlIlIIIlIllIIlI;
                final int llllllllllllllIIlIlIlIIIlIllIIII;
                final int llllllllllllllIIlIlIlIIIlIlIlllI;
                final EntityTracker llllllllllllllIIlIlIlIIIlIlIllIl;
                final EntityReplacement llllllllllllllIIlIlIlIIIlIlIllII;
                Vector[] llllllllllllllIIlIlIlIIIlIlIlIll;
                boolean llllllllllllllIIlIlIlIIIlIlIlIlI;
                PacketWrapper llllllllllllllIIlIlIlIIIlIllIlll;
                this.handler(llllllllllllllIIlIlIlIIIlIlIlIIl -> {
                    llllllllllllllIIlIlIlIIIlIllIlII = llllllllllllllIIlIlIlIIIlIlIlIIl.get((Type<Integer>)Type.VAR_INT, 0);
                    llllllllllllllIIlIlIlIIIlIllIIlI = llllllllllllllIIlIlIlIIIlIlIlIIl.read((Type<Short>)Type.SHORT);
                    llllllllllllllIIlIlIlIIIlIllIIII = llllllllllllllIIlIlIlIIIlIlIlIIl.read((Type<Short>)Type.SHORT);
                    llllllllllllllIIlIlIlIIIlIlIlllI = llllllllllllllIIlIlIlIIIlIlIlIIl.read((Type<Short>)Type.SHORT);
                    llllllllllllllIIlIlIlIIIlIlIllIl = llllllllllllllIIlIlIlIIIlIlIlIIl.user().get(EntityTracker.class);
                    llllllllllllllIIlIlIlIIIlIlIllII = llllllllllllllIIlIlIlIIIlIlIllIl.getEntityReplacement(llllllllllllllIIlIlIlIIIlIllIlII);
                    if (llllllllllllllIIlIlIlIIIlIlIllII != null) {
                        llllllllllllllIIlIlIlIIIlIlIlIIl.cancel();
                        llllllllllllllIIlIlIlIIIlIlIllII.relMove(llllllllllllllIIlIlIlIIIlIllIIlI / 4096.0, llllllllllllllIIlIlIlIIIlIllIIII / 4096.0, llllllllllllllIIlIlIlIIIlIlIlllI / 4096.0);
                    }
                    else {
                        llllllllllllllIIlIlIlIIIlIlIlIll = RelativeMoveUtil.calculateRelativeMoves(llllllllllllllIIlIlIlIIIlIlIlIIl.user(), llllllllllllllIIlIlIlIIIlIllIlII, llllllllllllllIIlIlIlIIIlIllIIlI, llllllllllllllIIlIlIlIIIlIllIIII, llllllllllllllIIlIlIlIIIlIlIlllI);
                        llllllllllllllIIlIlIlIIIlIlIlIIl.write(Type.BYTE, (byte)llllllllllllllIIlIlIlIIIlIlIlIll[0].getBlockX());
                        llllllllllllllIIlIlIlIIIlIlIlIIl.write(Type.BYTE, (byte)llllllllllllllIIlIlIlIIIlIlIlIll[0].getBlockY());
                        llllllllllllllIIlIlIlIIIlIlIlIIl.write(Type.BYTE, (byte)llllllllllllllIIlIlIlIIIlIlIlIll[0].getBlockZ());
                        llllllllllllllIIlIlIlIIIlIlIlIlI = llllllllllllllIIlIlIlIIIlIlIlIIl.passthrough((Type<Boolean>)Type.BOOLEAN);
                        if (llllllllllllllIIlIlIlIIIlIlIlIll.length > 1) {
                            llllllllllllllIIlIlIlIIIlIllIlll = PacketWrapper.create(21, null, llllllllllllllIIlIlIlIIIlIlIlIIl.user());
                            llllllllllllllIIlIlIlIIIlIllIlll.write(Type.VAR_INT, (Integer)llllllllllllllIIlIlIlIIIlIlIlIIl.get((Type<T>)Type.VAR_INT, 0));
                            llllllllllllllIIlIlIlIIIlIllIlll.write(Type.BYTE, (byte)llllllllllllllIIlIlIlIIIlIlIlIll[1].getBlockX());
                            llllllllllllllIIlIlIlIIIlIllIlll.write(Type.BYTE, (byte)llllllllllllllIIlIlIlIIIlIlIlIll[1].getBlockY());
                            llllllllllllllIIlIlIlIIIlIllIlll.write(Type.BYTE, (byte)llllllllllllllIIlIlIlIIIlIlIlIll[1].getBlockZ());
                            llllllllllllllIIlIlIlIIIlIllIlll.write(Type.BOOLEAN, llllllllllllllIIlIlIlIIIlIlIlIlI);
                            PacketUtil.sendPacket(llllllllllllllIIlIlIlIIIlIllIlll, Protocol1_8TO1_9.class);
                        }
                    }
                });
            }
        });
        llllllllllllllIIIIIlIlllIllIllII.registerClientbound(ClientboundPackets1_9.ENTITY_POSITION_AND_ROTATION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                final int lllllllllllllIlIIIlIIlIlIlIllIll;
                final int lllllllllllllIlIIIlIIlIlIlIllIlI;
                final int lllllllllllllIlIIIlIIlIlIlIllIIl;
                final int lllllllllllllIlIIIlIIlIlIlIllIII;
                final EntityTracker lllllllllllllIlIIIlIIlIlIlIlIlll;
                final EntityReplacement lllllllllllllIlIIIlIIlIlIlIlIllI;
                Vector[] lllllllllllllIlIIIlIIlIlIlIlIlIl;
                byte lllllllllllllIlIIIlIIlIlIlIlIlII;
                byte lllllllllllllIlIIIlIIlIlIlIlIIll;
                boolean lllllllllllllIlIIIlIIlIlIlIlIIlI;
                Entity1_10Types.EntityType lllllllllllllIlIIIlIIlIlIlIlIIIl;
                PacketWrapper lllllllllllllIlIIIlIIlIlIlIlllIl;
                this.handler(lllllllllllllIlIIIlIIlIlIlIlIIII -> {
                    lllllllllllllIlIIIlIIlIlIlIllIll = lllllllllllllIlIIIlIIlIlIlIlIIII.get((Type<Integer>)Type.VAR_INT, 0);
                    lllllllllllllIlIIIlIIlIlIlIllIlI = lllllllllllllIlIIIlIIlIlIlIlIIII.read((Type<Short>)Type.SHORT);
                    lllllllllllllIlIIIlIIlIlIlIllIIl = lllllllllllllIlIIIlIIlIlIlIlIIII.read((Type<Short>)Type.SHORT);
                    lllllllllllllIlIIIlIIlIlIlIllIII = lllllllllllllIlIIIlIIlIlIlIlIIII.read((Type<Short>)Type.SHORT);
                    lllllllllllllIlIIIlIIlIlIlIlIlll = lllllllllllllIlIIIlIIlIlIlIlIIII.user().get(EntityTracker.class);
                    lllllllllllllIlIIIlIIlIlIlIlIllI = lllllllllllllIlIIIlIIlIlIlIlIlll.getEntityReplacement(lllllllllllllIlIIIlIIlIlIlIllIll);
                    if (lllllllllllllIlIIIlIIlIlIlIlIllI != null) {
                        lllllllllllllIlIIIlIIlIlIlIlIIII.cancel();
                        lllllllllllllIlIIIlIIlIlIlIlIllI.relMove(lllllllllllllIlIIIlIIlIlIlIllIlI / 4096.0, lllllllllllllIlIIIlIIlIlIlIllIIl / 4096.0, lllllllllllllIlIIIlIIlIlIlIllIII / 4096.0);
                        lllllllllllllIlIIIlIIlIlIlIlIllI.setYawPitch(lllllllllllllIlIIIlIIlIlIlIlIIII.read((Type<Byte>)Type.BYTE) * 360.0f / 256.0f, lllllllllllllIlIIIlIIlIlIlIlIIII.read((Type<Byte>)Type.BYTE) * 360.0f / 256.0f);
                    }
                    else {
                        lllllllllllllIlIIIlIIlIlIlIlIlIl = RelativeMoveUtil.calculateRelativeMoves(lllllllllllllIlIIIlIIlIlIlIlIIII.user(), lllllllllllllIlIIIlIIlIlIlIllIll, lllllllllllllIlIIIlIIlIlIlIllIlI, lllllllllllllIlIIIlIIlIlIlIllIIl, lllllllllllllIlIIIlIIlIlIlIllIII);
                        lllllllllllllIlIIIlIIlIlIlIlIIII.write(Type.BYTE, (byte)lllllllllllllIlIIIlIIlIlIlIlIlIl[0].getBlockX());
                        lllllllllllllIlIIIlIIlIlIlIlIIII.write(Type.BYTE, (byte)lllllllllllllIlIIIlIIlIlIlIlIlIl[0].getBlockY());
                        lllllllllllllIlIIIlIIlIlIlIlIIII.write(Type.BYTE, (byte)lllllllllllllIlIIIlIIlIlIlIlIlIl[0].getBlockZ());
                        lllllllllllllIlIIIlIIlIlIlIlIlII = lllllllllllllIlIIIlIIlIlIlIlIIII.passthrough((Type<Byte>)Type.BYTE);
                        lllllllllllllIlIIIlIIlIlIlIlIIll = lllllllllllllIlIIIlIIlIlIlIlIIII.passthrough((Type<Byte>)Type.BYTE);
                        lllllllllllllIlIIIlIIlIlIlIlIIlI = lllllllllllllIlIIIlIIlIlIlIlIIII.passthrough((Type<Boolean>)Type.BOOLEAN);
                        lllllllllllllIlIIIlIIlIlIlIlIIIl = lllllllllllllIlIIIlIIlIlIlIlIIII.user().get(EntityTracker.class).getClientEntityTypes().get(lllllllllllllIlIIIlIIlIlIlIllIll);
                        if (lllllllllllllIlIIIlIIlIlIlIlIIIl == Entity1_10Types.EntityType.BOAT) {
                            lllllllllllllIlIIIlIIlIlIlIlIlII -= 64;
                            lllllllllllllIlIIIlIIlIlIlIlIIII.set(Type.BYTE, 3, lllllllllllllIlIIIlIIlIlIlIlIlII);
                        }
                        if (lllllllllllllIlIIIlIIlIlIlIlIlIl.length > 1) {
                            lllllllllllllIlIIIlIIlIlIlIlllIl = PacketWrapper.create(23, null, lllllllllllllIlIIIlIIlIlIlIlIIII.user());
                            lllllllllllllIlIIIlIIlIlIlIlllIl.write(Type.VAR_INT, (Integer)lllllllllllllIlIIIlIIlIlIlIlIIII.get((Type<T>)Type.VAR_INT, 0));
                            lllllllllllllIlIIIlIIlIlIlIlllIl.write(Type.BYTE, (byte)lllllllllllllIlIIIlIIlIlIlIlIlIl[1].getBlockX());
                            lllllllllllllIlIIIlIIlIlIlIlllIl.write(Type.BYTE, (byte)lllllllllllllIlIIIlIIlIlIlIlIlIl[1].getBlockY());
                            lllllllllllllIlIIIlIIlIlIlIlllIl.write(Type.BYTE, (byte)lllllllllllllIlIIIlIIlIlIlIlIlIl[1].getBlockZ());
                            lllllllllllllIlIIIlIIlIlIlIlllIl.write(Type.BYTE, lllllllllllllIlIIIlIIlIlIlIlIlII);
                            lllllllllllllIlIIIlIIlIlIlIlllIl.write(Type.BYTE, lllllllllllllIlIIIlIIlIlIlIlIIll);
                            lllllllllllllIlIIIlIIlIlIlIlllIl.write(Type.BOOLEAN, lllllllllllllIlIIIlIIlIlIlIlIIlI);
                            PacketUtil.sendPacket(lllllllllllllIlIIIlIIlIlIlIlllIl, Protocol1_8TO1_9.class);
                        }
                    }
                });
            }
        });
        llllllllllllllIIIIIlIlllIllIllII.registerClientbound(ClientboundPackets1_9.ENTITY_ROTATION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.BOOLEAN);
                final int lllllllllllllIlllIIllllIllllIllI;
                final EntityTracker lllllllllllllIlllIIllllIllllIlII;
                final EntityReplacement lllllllllllllIlllIIllllIllllIIlI;
                int lllllllllllllIlllIIllllIllllllII;
                int lllllllllllllIlllIIllllIlllllIlI;
                this.handler(lllllllllllllIlllIIllllIllllIIII -> {
                    lllllllllllllIlllIIllllIllllIllI = lllllllllllllIlllIIllllIllllIIII.get((Type<Integer>)Type.VAR_INT, 0);
                    lllllllllllllIlllIIllllIllllIlII = lllllllllllllIlllIIllllIllllIIII.user().get(EntityTracker.class);
                    lllllllllllllIlllIIllllIllllIIlI = lllllllllllllIlllIIllllIllllIlII.getEntityReplacement(lllllllllllllIlllIIllllIllllIllI);
                    if (lllllllllllllIlllIIllllIllllIIlI != null) {
                        lllllllllllllIlllIIllllIllllIIII.cancel();
                        lllllllllllllIlllIIllllIllllllII = lllllllllllllIlllIIllllIllllIIII.get((Type<Byte>)Type.BYTE, 0);
                        lllllllllllllIlllIIllllIlllllIlI = lllllllllllllIlllIIllllIllllIIII.get((Type<Byte>)Type.BYTE, 1);
                        lllllllllllllIlllIIllllIllllIIlI.setYawPitch(lllllllllllllIlllIIllllIllllllII * 360.0f / 256.0f, lllllllllllllIlllIIllllIlllllIlI * 360.0f / 256.0f);
                    }
                    return;
                });
                final int lllllllllllllIlllIIlllllIIIIllIl;
                final Entity1_10Types.EntityType lllllllllllllIlllIIlllllIIIIllII;
                byte lllllllllllllIlllIIlllllIIIlIIII;
                byte lllllllllllllIlllIIlllllIIIlIIII2;
                this.handler(lllllllllllllIlllIIlllllIIIIlllI -> {
                    lllllllllllllIlllIIlllllIIIIllIl = lllllllllllllIlllIIlllllIIIIlllI.get((Type<Integer>)Type.VAR_INT, 0);
                    lllllllllllllIlllIIlllllIIIIllII = lllllllllllllIlllIIlllllIIIIlllI.user().get(EntityTracker.class).getClientEntityTypes().get(lllllllllllllIlllIIlllllIIIIllIl);
                    if (lllllllllllllIlllIIlllllIIIIllII == Entity1_10Types.EntityType.BOAT) {
                        lllllllllllllIlllIIlllllIIIlIIII = lllllllllllllIlllIIlllllIIIIlllI.get((Type<Byte>)Type.BYTE, 0);
                        lllllllllllllIlllIIlllllIIIlIIII2 = (byte)(lllllllllllllIlllIIlllllIIIlIIII - 64);
                        lllllllllllllIlllIIlllllIIIIlllI.set(Type.BYTE, 0, lllllllllllllIlllIIlllllIIIlIIII2);
                    }
                });
            }
        });
        llllllllllllllIIIIIlIlllIllIllII.registerClientbound(ClientboundPackets1_9.VEHICLE_MOVE, ClientboundPackets1_8.ENTITY_TELEPORT, new PacketRemapper() {
            @Override
            public void registerMap() {
                final EntityTracker lllllllllllllIlIlIllIlIIllIlIllI;
                final int lllllllllllllIlIlIllIlIIllIlIlIl;
                this.handler(lllllllllllllIlIlIllIlIIllIlIlII -> {
                    lllllllllllllIlIlIllIlIIllIlIllI = lllllllllllllIlIlIllIlIIllIlIlII.user().get(EntityTracker.class);
                    lllllllllllllIlIlIllIlIIllIlIlIl = lllllllllllllIlIlIllIlIIllIlIllI.getVehicle(lllllllllllllIlIlIllIlIIllIlIllI.getPlayerId());
                    if (lllllllllllllIlIlIllIlIIllIlIlIl == -1) {
                        lllllllllllllIlIlIllIlIIllIlIlII.cancel();
                    }
                    lllllllllllllIlIlIllIlIIllIlIlII.write(Type.VAR_INT, lllllllllllllIlIlIllIlIIllIlIlIl);
                    return;
                });
                this.map(Type.DOUBLE, Protocol1_8TO1_9.TO_OLD_INT);
                this.map(Type.DOUBLE, Protocol1_8TO1_9.TO_OLD_INT);
                this.map(Type.DOUBLE, Protocol1_8TO1_9.TO_OLD_INT);
                this.map(Type.FLOAT, Protocol1_8TO1_9.DEGREES_TO_ANGLE);
                this.map(Type.FLOAT, Protocol1_8TO1_9.DEGREES_TO_ANGLE);
                PlayerPosition lllllllllllllIlIlIllIlIIlllIlIll;
                double lllllllllllllIlIlIllIlIIlllIlIlI;
                double lllllllllllllIlIlIllIlIIlllIlIII;
                double lllllllllllllIlIlIllIlIIlllIIlll;
                this.handler(lllllllllllllIlIlIllIlIIlllIllII -> {
                    if (lllllllllllllIlIlIllIlIIlllIllII.isCancelled()) {
                        return;
                    }
                    else {
                        lllllllllllllIlIlIllIlIIlllIlIll = lllllllllllllIlIlIllIlIIlllIllII.user().get(PlayerPosition.class);
                        lllllllllllllIlIlIllIlIIlllIlIlI = lllllllllllllIlIlIllIlIIlllIllII.get((Type<Integer>)Type.INT, 0) / 32.0;
                        lllllllllllllIlIlIllIlIIlllIlIII = lllllllllllllIlIlIllIlIIlllIllII.get((Type<Integer>)Type.INT, 1) / 32.0;
                        lllllllllllllIlIlIllIlIIlllIIlll = lllllllllllllIlIlIllIlIIlllIllII.get((Type<Integer>)Type.INT, 2) / 32.0;
                        lllllllllllllIlIlIllIlIIlllIlIll.setPos(lllllllllllllIlIlIllIlIIlllIlIlI, lllllllllllllIlIlIllIlIIlllIlIII, lllllllllllllIlIlIllIlIIlllIIlll);
                        return;
                    }
                });
                this.create(Type.BOOLEAN, true);
                final int lllllllllllllIlIlIllIlIIlllllIll;
                final Entity1_10Types.EntityType lllllllllllllIlIlIllIlIIlllllIIl;
                byte lllllllllllllIlIlIllIlIIlllllllI;
                byte lllllllllllllIlIlIllIlIIlllllllI2;
                int lllllllllllllIlIlIllIlIIllllllIl;
                this.handler(lllllllllllllIlIlIllIlIIlllllIII -> {
                    lllllllllllllIlIlIllIlIIlllllIll = lllllllllllllIlIlIllIlIIlllllIII.get((Type<Integer>)Type.VAR_INT, 0);
                    lllllllllllllIlIlIllIlIIlllllIIl = lllllllllllllIlIlIllIlIIlllllIII.user().get(EntityTracker.class).getClientEntityTypes().get(lllllllllllllIlIlIllIlIIlllllIll);
                    if (lllllllllllllIlIlIllIlIIlllllIIl == Entity1_10Types.EntityType.BOAT) {
                        lllllllllllllIlIlIllIlIIlllllllI = lllllllllllllIlIlIllIlIIlllllIII.get((Type<Byte>)Type.BYTE, 1);
                        lllllllllllllIlIlIllIlIIlllllllI2 = (byte)(lllllllllllllIlIlIllIlIIlllllllI - 64);
                        lllllllllllllIlIlIllIlIIlllllIII.set(Type.BYTE, 0, lllllllllllllIlIlIllIlIIlllllllI2);
                        lllllllllllllIlIlIllIlIIllllllIl = lllllllllllllIlIlIllIlIIlllllIII.get((Type<Integer>)Type.INT, 1);
                        lllllllllllllIlIlIllIlIIllllllIl += 10;
                        lllllllllllllIlIlIllIlIIlllllIII.set(Type.INT, 1, lllllllllllllIlIlIllIlIIllllllIl);
                    }
                });
            }
        });
        llllllllllllllIIIIIlIlllIllIllII.registerClientbound(ClientboundPackets1_9.DESTROY_ENTITIES, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT_ARRAY_PRIMITIVE);
                final EntityTracker llllllllllllllIllIIllIlIlIIlIIIl;
                final boolean llllllllllllllIllIIllIlIlIIIlllI;
                float llllllllllllllIllIIllIlIlIIIllIl;
                String llllllllllllllIllIIllIlIlIIIllII;
                int llllllllllllllIllIIllIlIlIIlIIll;
                this.handler(llllllllllllllIllIIllIlIlIIlIIlI -> {
                    llllllllllllllIllIIllIlIlIIlIIIl = llllllllllllllIllIIllIlIlIIlIIlI.user().get(EntityTracker.class);
                    llllllllllllllIllIIllIlIlIIIlllI = llllllllllllllIllIIllIlIlIIlIIlI.get((Type<Boolean>)Type.VAR_INT_ARRAY_PRIMITIVE, 0);
                    for (llllllllllllllIllIIllIlIlIIIllIl = llllllllllllllIllIIllIlIlIIIlllI.length, llllllllllllllIllIIllIlIlIIIllII = (String)0; llllllllllllllIllIIllIlIlIIIllII < llllllllllllllIllIIllIlIlIIIllIl; ++llllllllllllllIllIIllIlIlIIIllII) {
                        llllllllllllllIllIIllIlIlIIlIIll = llllllllllllllIllIIllIlIlIIIlllI[llllllllllllllIllIIllIlIlIIIllII];
                        llllllllllllllIllIIllIlIlIIlIIIl.removeEntity(llllllllllllllIllIIllIlIlIIlIIll);
                    }
                });
            }
        });
        llllllllllllllIIIIIlIlllIllIllII.registerClientbound(ClientboundPackets1_9.REMOVE_ENTITY_EFFECT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.BYTE);
                final int lllllllllllllllIllIIllIIIllllIll;
                Levitation lllllllllllllllIllIIllIIIlllllIl;
                this.handler(lllllllllllllllIllIIllIIIllllIlI -> {
                    lllllllllllllllIllIIllIIIllllIll = lllllllllllllllIllIIllIIIllllIlI.get((Type<Byte>)Type.BYTE, 0);
                    if (lllllllllllllllIllIIllIIIllllIll > 23) {
                        lllllllllllllllIllIIllIIIllllIlI.cancel();
                    }
                    if (lllllllllllllllIllIIllIIIllllIll == 25) {
                        if (lllllllllllllllIllIIllIIIllllIlI.get((Type<Integer>)Type.VAR_INT, 0) == lllllllllllllllIllIIllIIIllllIlI.user().get(EntityTracker.class).getPlayerId()) {
                            lllllllllllllllIllIIllIIIlllllIl = lllllllllllllllIllIIllIIIllllIlI.user().get(Levitation.class);
                            lllllllllllllllIllIIllIIIlllllIl.setActive(false);
                        }
                    }
                });
            }
        });
        llllllllllllllIIIIIlIlllIllIllII.registerClientbound(ClientboundPackets1_9.ENTITY_HEAD_LOOK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.BYTE);
                final int lllllllllllllIIIIlIIlllllIIlllIl;
                final EntityTracker lllllllllllllIIIIlIIlllllIIlllII;
                final EntityReplacement lllllllllllllIIIIlIIlllllIIllIll;
                int lllllllllllllIIIIlIIlllllIIlllll;
                this.handler(lllllllllllllIIIIlIIlllllIIllllI -> {
                    lllllllllllllIIIIlIIlllllIIlllIl = lllllllllllllIIIIlIIlllllIIllllI.get((Type<Integer>)Type.VAR_INT, 0);
                    lllllllllllllIIIIlIIlllllIIlllII = lllllllllllllIIIIlIIlllllIIllllI.user().get(EntityTracker.class);
                    lllllllllllllIIIIlIIlllllIIllIll = lllllllllllllIIIIlIIlllllIIlllII.getEntityReplacement(lllllllllllllIIIIlIIlllllIIlllIl);
                    if (lllllllllllllIIIIlIIlllllIIllIll != null) {
                        lllllllllllllIIIIlIIlllllIIllllI.cancel();
                        lllllllllllllIIIIlIIlllllIIlllll = lllllllllllllIIIIlIIlllllIIllllI.get((Type<Byte>)Type.BYTE, 0);
                        lllllllllllllIIIIlIIlllllIIllIll.setHeadYaw(lllllllllllllIIIIlIIlllllIIlllll * 360.0f / 256.0f);
                    }
                });
            }
        });
        llllllllllllllIIIIIlIlllIllIllII.registerClientbound(ClientboundPackets1_9.ENTITY_METADATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Types1_9.METADATA_LIST, Types1_8.METADATA_LIST);
                final List<Metadata> lllllllllllllllllllIllIIIIIIllIl;
                final int lllllllllllllllllllIllIIIIIIllII;
                final EntityTracker lllllllllllllllllllIllIIIIIIlIll;
                this.handler(lllllllllllllllllllIllIIIIIIlllI -> {
                    lllllllllllllllllllIllIIIIIIllIl = lllllllllllllllllllIllIIIIIIlllI.get(Types1_8.METADATA_LIST, 0);
                    lllllllllllllllllllIllIIIIIIllII = lllllllllllllllllllIllIIIIIIlllI.get((Type<Integer>)Type.VAR_INT, 0);
                    lllllllllllllllllllIllIIIIIIlIll = lllllllllllllllllllIllIIIIIIlllI.user().get(EntityTracker.class);
                    if (lllllllllllllllllllIllIIIIIIlIll.getClientEntityTypes().containsKey(lllllllllllllllllllIllIIIIIIllII)) {
                        MetadataRewriter.transform(lllllllllllllllllllIllIIIIIIlIll.getClientEntityTypes().get(lllllllllllllllllllIllIIIIIIllII), lllllllllllllllllllIllIIIIIIllIl);
                        if (lllllllllllllllllllIllIIIIIIllIl.isEmpty()) {
                            lllllllllllllllllllIllIIIIIIlllI.cancel();
                        }
                    }
                    else {
                        lllllllllllllllllllIllIIIIIIlIll.addMetadataToBuffer(lllllllllllllllllllIllIIIIIIllII, lllllllllllllllllllIllIIIIIIllIl);
                        lllllllllllllllllllIllIIIIIIlllI.cancel();
                    }
                });
            }
        });
        llllllllllllllIIIIIlIlllIllIllII.registerClientbound(ClientboundPackets1_9.ATTACH_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.INT);
                this.create(Type.BOOLEAN, true);
            }
        });
        llllllllllllllIIIIIlIlllIllIllII.registerClientbound(ClientboundPackets1_9.ENTITY_EQUIPMENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                int llllllllllllllIlIIllIIllIllIllIl;
                this.handler(llllllllllllllIlIIllIIllIllIlllI -> {
                    llllllllllllllIlIIllIIllIllIllIl = llllllllllllllIlIIllIIllIllIlllI.read((Type<Integer>)Type.VAR_INT);
                    if (llllllllllllllIlIIllIIllIllIllIl == 1) {
                        llllllllllllllIlIIllIIllIllIlllI.cancel();
                    }
                    else if (llllllllllllllIlIIllIIllIllIllIl > 1) {
                        --llllllllllllllIlIIllIIllIllIllIl;
                    }
                    llllllllllllllIlIIllIIllIllIlllI.write(Type.SHORT, (short)llllllllllllllIlIIllIIllIllIllIl);
                    return;
                });
                this.map(Type.ITEM);
                this.handler(llllllllllllllIlIIllIIllIlllIIlI -> llllllllllllllIlIIllIIllIlllIIlI.set(Type.ITEM, 0, ItemRewriter.toClient(llllllllllllllIlIIllIIllIlllIIlI.get(Type.ITEM, 0))));
            }
        });
        llllllllllllllIIIIIlIlllIllIllII.registerClientbound(ClientboundPackets1_9.SET_PASSENGERS, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                final EntityTracker llllllllllllllIlIIIIlIlIIIlIIlIl;
                final int llllllllllllllIlIIIIlIlIIIlIIlII;
                final int llllllllllllllIlIIIIlIlIIIlIIIll;
                final ArrayList<Integer> llllllllllllllIlIIIIlIlIIIlIIIlI;
                int llllllllllllllIlIIIIlIlIIIlIllIl;
                final List<Integer> llllllllllllllIlIIIIlIlIIIlIIIIl;
                final Iterator<Integer> iterator;
                Integer llllllllllllllIlIIIIlIlIIIlIlIll;
                PacketWrapper llllllllllllllIlIIIIlIlIIIlIllII;
                int llllllllllllllIlIIIIlIlIIIlIIlll;
                int llllllllllllllIlIIIIlIlIIIlIlIlI;
                int llllllllllllllIlIIIIlIlIIIlIlIIl;
                PacketWrapper llllllllllllllIlIIIIlIlIIIlIlIII;
                this.handler(llllllllllllllIlIIIIlIlIIIlIIIII -> {
                    llllllllllllllIlIIIIlIlIIIlIIIII.cancel();
                    llllllllllllllIlIIIIlIlIIIlIIlIl = llllllllllllllIlIIIIlIlIIIlIIIII.user().get(EntityTracker.class);
                    llllllllllllllIlIIIIlIlIIIlIIlII = llllllllllllllIlIIIIlIlIIIlIIIII.read((Type<Integer>)Type.VAR_INT);
                    llllllllllllllIlIIIIlIlIIIlIIIll = llllllllllllllIlIIIIlIlIIIlIIIII.read((Type<Integer>)Type.VAR_INT);
                    llllllllllllllIlIIIIlIlIIIlIIIlI = new ArrayList<Integer>();
                    for (llllllllllllllIlIIIIlIlIIIlIllIl = 0; llllllllllllllIlIIIIlIlIIIlIllIl < llllllllllllllIlIIIIlIlIIIlIIIll; ++llllllllllllllIlIIIIlIlIIIlIllIl) {
                        llllllllllllllIlIIIIlIlIIIlIIIlI.add(llllllllllllllIlIIIIlIlIIIlIIIII.read((Type<Integer>)Type.VAR_INT));
                    }
                    llllllllllllllIlIIIIlIlIIIlIIIIl = llllllllllllllIlIIIIlIlIIIlIIlIl.getPassengers(llllllllllllllIlIIIIlIlIIIlIIlII);
                    llllllllllllllIlIIIIlIlIIIlIIlIl.setPassengers(llllllllllllllIlIIIIlIlIIIlIIlII, llllllllllllllIlIIIIlIlIIIlIIIlI);
                    if (!llllllllllllllIlIIIIlIlIIIlIIIIl.isEmpty()) {
                        llllllllllllllIlIIIIlIlIIIlIIIIl.iterator();
                        while (iterator.hasNext()) {
                            llllllllllllllIlIIIIlIlIIIlIlIll = iterator.next();
                            llllllllllllllIlIIIIlIlIIIlIllII = PacketWrapper.create(27, null, llllllllllllllIlIIIIlIlIIIlIIIII.user());
                            llllllllllllllIlIIIIlIlIIIlIllII.write(Type.INT, llllllllllllllIlIIIIlIlIIIlIlIll);
                            llllllllllllllIlIIIIlIlIIIlIllII.write(Type.INT, -1);
                            llllllllllllllIlIIIIlIlIIIlIllII.write(Type.BOOLEAN, false);
                            PacketUtil.sendPacket(llllllllllllllIlIIIIlIlIIIlIllII, Protocol1_8TO1_9.class);
                        }
                    }
                    for (llllllllllllllIlIIIIlIlIIIlIIlll = 0; llllllllllllllIlIIIIlIlIIIlIIlll < llllllllllllllIlIIIIlIlIIIlIIIll; ++llllllllllllllIlIIIIlIlIIIlIIlll) {
                        llllllllllllllIlIIIIlIlIIIlIlIlI = ((llllllllllllllIlIIIIlIlIIIlIIlll == 0) ? llllllllllllllIlIIIIlIlIIIlIIlII : llllllllllllllIlIIIIlIlIIIlIIIlI.get(llllllllllllllIlIIIIlIlIIIlIIlll - 1));
                        llllllllllllllIlIIIIlIlIIIlIlIIl = llllllllllllllIlIIIIlIlIIIlIIIlI.get(llllllllllllllIlIIIIlIlIIIlIIlll);
                        llllllllllllllIlIIIIlIlIIIlIlIII = PacketWrapper.create(27, null, llllllllllllllIlIIIIlIlIIIlIIIII.user());
                        llllllllllllllIlIIIIlIlIIIlIlIII.write(Type.INT, llllllllllllllIlIIIIlIlIIIlIlIIl);
                        llllllllllllllIlIIIIlIlIIIlIlIII.write(Type.INT, llllllllllllllIlIIIIlIlIIIlIlIlI);
                        llllllllllllllIlIIIIlIlIIIlIlIII.write(Type.BOOLEAN, false);
                        PacketUtil.sendPacket(llllllllllllllIlIIIIlIlIIIlIlIII, Protocol1_8TO1_9.class);
                    }
                });
            }
        });
        llllllllllllllIIIIIlIlllIllIllII.registerClientbound(ClientboundPackets1_9.ENTITY_TELEPORT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.DOUBLE, Protocol1_8TO1_9.TO_OLD_INT);
                this.map(Type.DOUBLE, Protocol1_8TO1_9.TO_OLD_INT);
                this.map(Type.DOUBLE, Protocol1_8TO1_9.TO_OLD_INT);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.BOOLEAN);
                final int lllllllllllllIlIllllIlllIIlIllIl;
                final Entity1_10Types.EntityType lllllllllllllIlIllllIlllIIlIllII;
                byte lllllllllllllIlIllllIlllIIllIIII;
                byte lllllllllllllIlIllllIlllIIllIIII2;
                int lllllllllllllIlIllllIlllIIlIllll;
                this.handler(lllllllllllllIlIllllIlllIIlIlIll -> {
                    lllllllllllllIlIllllIlllIIlIllIl = lllllllllllllIlIllllIlllIIlIlIll.get((Type<Integer>)Type.VAR_INT, 0);
                    lllllllllllllIlIllllIlllIIlIllII = lllllllllllllIlIllllIlllIIlIlIll.user().get(EntityTracker.class).getClientEntityTypes().get(lllllllllllllIlIllllIlllIIlIllIl);
                    if (lllllllllllllIlIllllIlllIIlIllII == Entity1_10Types.EntityType.BOAT) {
                        lllllllllllllIlIllllIlllIIllIIII = lllllllllllllIlIllllIlllIIlIlIll.get((Type<Byte>)Type.BYTE, 1);
                        lllllllllllllIlIllllIlllIIllIIII2 = (byte)(lllllllllllllIlIllllIlllIIllIIII - 64);
                        lllllllllllllIlIllllIlllIIlIlIll.set(Type.BYTE, 0, lllllllllllllIlIllllIlllIIllIIII2);
                        lllllllllllllIlIllllIlllIIlIllll = lllllllllllllIlIllllIlllIIlIlIll.get((Type<Integer>)Type.INT, 1);
                        lllllllllllllIlIllllIlllIIlIllll += 10;
                        lllllllllllllIlIllllIlllIIlIlIll.set(Type.INT, 1, lllllllllllllIlIllllIlllIIlIllll);
                    }
                    return;
                });
                final int lllllllllllllIlIllllIlllIIlllIII;
                this.handler(lllllllllllllIlIllllIlllIIllIlll -> {
                    lllllllllllllIlIllllIlllIIlllIII = lllllllllllllIlIllllIlllIIllIlll.get((Type<Integer>)Type.VAR_INT, 0);
                    lllllllllllllIlIllllIlllIIllIlll.user().get(EntityTracker.class).resetEntityOffset(lllllllllllllIlIllllIlllIIlllIII);
                    return;
                });
                final int lllllllllllllIlIllllIlllIlIIIlll;
                final EntityTracker lllllllllllllIlIllllIlllIlIIIllI;
                final EntityReplacement lllllllllllllIlIllllIlllIlIIIlIl;
                int lllllllllllllIlIllllIlllIlIIllIl;
                int lllllllllllllIlIllllIlllIlIIllII;
                int lllllllllllllIlIllllIlllIlIIlIll;
                int lllllllllllllIlIllllIlllIlIIlIlI;
                int lllllllllllllIlIllllIlllIlIIlIIl;
                this.handler(lllllllllllllIlIllllIlllIlIIIlII -> {
                    lllllllllllllIlIllllIlllIlIIIlll = lllllllllllllIlIllllIlllIlIIIlII.get((Type<Integer>)Type.VAR_INT, 0);
                    lllllllllllllIlIllllIlllIlIIIllI = lllllllllllllIlIllllIlllIlIIIlII.user().get(EntityTracker.class);
                    lllllllllllllIlIllllIlllIlIIIlIl = lllllllllllllIlIllllIlllIlIIIllI.getEntityReplacement(lllllllllllllIlIllllIlllIlIIIlll);
                    if (lllllllllllllIlIllllIlllIlIIIlIl != null) {
                        lllllllllllllIlIllllIlllIlIIIlII.cancel();
                        lllllllllllllIlIllllIlllIlIIllIl = lllllllllllllIlIllllIlllIlIIIlII.get((Type<Integer>)Type.INT, 0);
                        lllllllllllllIlIllllIlllIlIIllII = lllllllllllllIlIllllIlllIlIIIlII.get((Type<Integer>)Type.INT, 1);
                        lllllllllllllIlIllllIlllIlIIlIll = lllllllllllllIlIllllIlllIlIIIlII.get((Type<Integer>)Type.INT, 2);
                        lllllllllllllIlIllllIlllIlIIlIlI = lllllllllllllIlIllllIlllIlIIIlII.get((Type<Byte>)Type.BYTE, 0);
                        lllllllllllllIlIllllIlllIlIIlIIl = lllllllllllllIlIllllIlllIlIIIlII.get((Type<Byte>)Type.BYTE, 1);
                        lllllllllllllIlIllllIlllIlIIIlIl.setLocation(lllllllllllllIlIllllIlllIlIIllIl / 32.0, lllllllllllllIlIllllIlllIlIIllII / 32.0, lllllllllllllIlIllllIlllIlIIlIll / 32.0);
                        lllllllllllllIlIllllIlllIlIIIlIl.setYawPitch(lllllllllllllIlIllllIlllIlIIlIlI * 360.0f / 256.0f, lllllllllllllIlIllllIlllIlIIlIIl * 360.0f / 256.0f);
                    }
                });
            }
        });
        llllllllllllllIIIIIlIlllIllIllII.registerClientbound(ClientboundPackets1_9.ENTITY_PROPERTIES, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.INT);
                final boolean lllllllllllllIllIIlIIIIIlIIIIIll;
                final int lllllllllllllIllIIlIIIIIlIIIIIlI;
                int lllllllllllllIllIIlIIIIIlIIIIIIl;
                int lllllllllllllIllIIlIIIIIlIIIIlIl;
                String lllllllllllllIllIIlIIIIIlIIIlIlI;
                boolean lllllllllllllIllIIlIIIIIlIIIlIIl;
                double lllllllllllllIllIIlIIIIIlIIIlIII;
                int lllllllllllllIllIIlIIIIIlIIIIlll;
                ArrayList<Pair<Byte, Double>> lllllllllllllIllIIlIIIIIlIIIIllI;
                int lllllllllllllIllIIlIIIIIlIIIlIll;
                UUID lllllllllllllIllIIlIIIIIlIIIlllI;
                double lllllllllllllIllIIlIIIIIlIIIllIl;
                byte lllllllllllllIllIIlIIIIIlIIIllII;
                this.handler(lllllllllllllIllIIlIIIIIlIIIIIII -> {
                    lllllllllllllIllIIlIIIIIlIIIIIll = (lllllllllllllIllIIlIIIIIlIIIIIII.get((Type<Integer>)Type.VAR_INT, 0) == lllllllllllllIllIIlIIIIIlIIIIIII.user().get(EntityTracker.class).getPlayerId());
                    lllllllllllllIllIIlIIIIIlIIIIIlI = lllllllllllllIllIIlIIIIIlIIIIIII.get((Type<Integer>)Type.INT, 0);
                    lllllllllllllIllIIlIIIIIlIIIIIIl = 0;
                    for (lllllllllllllIllIIlIIIIIlIIIIlIl = 0; lllllllllllllIllIIlIIIIIlIIIIlIl < lllllllllllllIllIIlIIIIIlIIIIIlI; ++lllllllllllllIllIIlIIIIIlIIIIlIl) {
                        lllllllllllllIllIIlIIIIIlIIIlIlI = lllllllllllllIllIIlIIIIIlIIIIIII.read(Type.STRING);
                        lllllllllllllIllIIlIIIIIlIIIlIIl = !Protocol1_8TO1_9.VALID_ATTRIBUTES.contains(lllllllllllllIllIIlIIIIIlIIIlIlI);
                        lllllllllllllIllIIlIIIIIlIIIlIII = lllllllllllllIllIIlIIIIIlIIIIIII.read((Type<Double>)Type.DOUBLE);
                        lllllllllllllIllIIlIIIIIlIIIIlll = lllllllllllllIllIIlIIIIIlIIIIIII.read((Type<Integer>)Type.VAR_INT);
                        if (!lllllllllllllIllIIlIIIIIlIIIlIIl) {
                            lllllllllllllIllIIlIIIIIlIIIIIII.write(Type.STRING, lllllllllllllIllIIlIIIIIlIIIlIlI);
                            lllllllllllllIllIIlIIIIIlIIIIIII.write(Type.DOUBLE, lllllllllllllIllIIlIIIIIlIIIlIII);
                            lllllllllllllIllIIlIIIIIlIIIIIII.write(Type.VAR_INT, lllllllllllllIllIIlIIIIIlIIIIlll);
                        }
                        else {
                            ++lllllllllllllIllIIlIIIIIlIIIIIIl;
                        }
                        lllllllllllllIllIIlIIIIIlIIIIllI = new ArrayList<Pair<Byte, Double>>();
                        for (lllllllllllllIllIIlIIIIIlIIIlIll = 0; lllllllllllllIllIIlIIIIIlIIIlIll < lllllllllllllIllIIlIIIIIlIIIIlll; ++lllllllllllllIllIIlIIIIIlIIIlIll) {
                            lllllllllllllIllIIlIIIIIlIIIlllI = lllllllllllllIllIIlIIIIIlIIIIIII.read(Type.UUID);
                            lllllllllllllIllIIlIIIIIlIIIllIl = lllllllllllllIllIIlIIIIIlIIIIIII.read((Type<Double>)Type.DOUBLE);
                            lllllllllllllIllIIlIIIIIlIIIllII = lllllllllllllIllIIlIIIIIlIIIIIII.read((Type<Byte>)Type.BYTE);
                            lllllllllllllIllIIlIIIIIlIIIIllI.add(new Pair<Byte, Double>(lllllllllllllIllIIlIIIIIlIIIllII, lllllllllllllIllIIlIIIIIlIIIllIl));
                            if (!lllllllllllllIllIIlIIIIIlIIIlIIl) {
                                lllllllllllllIllIIlIIIIIlIIIIIII.write(Type.UUID, lllllllllllllIllIIlIIIIIlIIIlllI);
                                lllllllllllllIllIIlIIIIIlIIIIIII.write(Type.DOUBLE, lllllllllllllIllIIlIIIIIlIIIllIl);
                                lllllllllllllIllIIlIIIIIlIIIIIII.write(Type.BYTE, lllllllllllllIllIIlIIIIIlIIIllII);
                            }
                        }
                        if (lllllllllllllIllIIlIIIIIlIIIIIll && lllllllllllllIllIIlIIIIIlIIIlIlI.equals("generic.attackSpeed")) {
                            lllllllllllllIllIIlIIIIIlIIIIIII.user().get(Cooldown.class).setAttackSpeed(lllllllllllllIllIIlIIIIIlIIIlIII, lllllllllllllIllIIlIIIIIlIIIIllI);
                        }
                    }
                    lllllllllllllIllIIlIIIIIlIIIIIII.set(Type.INT, 0, lllllllllllllIllIIlIIIIIlIIIIIlI - lllllllllllllIllIIlIIIIIlIIIIIIl);
                });
            }
        });
        llllllllllllllIIIIIlIlllIllIllII.registerClientbound(ClientboundPackets1_9.ENTITY_EFFECT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.VAR_INT);
                this.map(Type.BYTE);
                final int llllllllllllllIlIllIlIIllllIllll;
                Levitation llllllllllllllIlIllIlIIlllllIIIl;
                this.handler(llllllllllllllIlIllIlIIlllllIIII -> {
                    llllllllllllllIlIllIlIIllllIllll = llllllllllllllIlIllIlIIlllllIIII.get((Type<Byte>)Type.BYTE, 0);
                    if (llllllllllllllIlIllIlIIllllIllll > 23) {
                        llllllllllllllIlIllIlIIlllllIIII.cancel();
                    }
                    if (llllllllllllllIlIllIlIIllllIllll == 25) {
                        if (llllllllllllllIlIllIlIIlllllIIII.get((Type<Integer>)Type.VAR_INT, 0) == llllllllllllllIlIllIlIIlllllIIII.user().get(EntityTracker.class).getPlayerId()) {
                            llllllllllllllIlIllIlIIlllllIIIl = llllllllllllllIlIllIlIIlllllIIII.user().get(Levitation.class);
                            llllllllllllllIlIllIlIIlllllIIIl.setActive(true);
                            llllllllllllllIlIllIlIIlllllIIIl.setAmplifier(llllllllllllllIlIllIlIIlllllIIII.get((Type<Byte>)Type.BYTE, 1));
                        }
                    }
                });
            }
        });
    }
}
