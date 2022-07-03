package de.gerrygames.viarewind.protocol.protocol1_8to1_9.packets;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.protocols.protocol1_8.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage.*;
import de.gerrygames.viarewind.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.items.*;
import io.netty.buffer.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.*;
import de.gerrygames.viarewind.utils.*;
import de.gerrygames.viarewind.replacement.*;
import com.viaversion.viaversion.api.type.types.version.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.entityreplacement.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.metadata.*;

public class SpawnPackets
{
    public static void register(final Protocol<ClientboundPackets1_9, ClientboundPackets1_8, ServerboundPackets1_9, ServerboundPackets1_8> lllllllllllllllIlIIIIIIIIIIlllll) {
        lllllllllllllllIlIIIIIIIIIIlllll.registerClientbound(ClientboundPackets1_9.SPAWN_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID, Type.NOTHING);
                this.map(Type.BYTE);
                this.map(Type.DOUBLE, Protocol1_8TO1_9.TO_OLD_INT);
                this.map(Type.DOUBLE, Protocol1_8TO1_9.TO_OLD_INT);
                this.map(Type.DOUBLE, Protocol1_8TO1_9.TO_OLD_INT);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.INT);
                final int llllllllllllllIlllIlIlIIllllllII;
                final int llllllllllllllIlllIlIlIIlllllIll;
                final EntityTracker llllllllllllllIlllIlIlIIlllllIlI;
                final Entity1_10Types.EntityType llllllllllllllIlllIlIlIIlllllIIl;
                int llllllllllllllIlllIlIlIIlllllIII;
                int llllllllllllllIlllIlIlIIllllIlll;
                int llllllllllllllIlllIlIlIIllllIllI;
                byte llllllllllllllIlllIlIlIlIIIIIllI;
                byte llllllllllllllIlllIlIlIlIIIIIllI2;
                ShulkerBulletReplacement llllllllllllllIlllIlIlIlIIIIIlIl;
                int llllllllllllllIlllIlIlIIllllIlIl;
                int llllllllllllllIlllIlIlIlIIIIIlII;
                int llllllllllllllIlllIlIlIlIIIIIIll;
                Replacement llllllllllllllIlllIlIlIlIIIIIIlI;
                short llllllllllllllIlllIlIlIlIIIIIIIl;
                short llllllllllllllIlllIlIlIlIIIIIIII;
                short llllllllllllllIlllIlIlIIllllllll;
                PacketWrapper llllllllllllllIlllIlIlIIlllllllI;
                this.handler(llllllllllllllIlllIlIlIIllllllIl -> {
                    llllllllllllllIlllIlIlIIllllllII = llllllllllllllIlllIlIlIIllllllIl.get((Type<Integer>)Type.VAR_INT, 0);
                    llllllllllllllIlllIlIlIIlllllIll = llllllllllllllIlllIlIlIIllllllIl.get((Type<Byte>)Type.BYTE, 0);
                    llllllllllllllIlllIlIlIIlllllIlI = llllllllllllllIlllIlIlIIllllllIl.user().get(EntityTracker.class);
                    llllllllllllllIlllIlIlIIlllllIIl = Entity1_10Types.getTypeFromId(llllllllllllllIlllIlIlIIlllllIll, true);
                    if (llllllllllllllIlllIlIlIIlllllIll == 3 || llllllllllllllIlllIlIlIIlllllIll == 91 || llllllllllllllIlllIlIlIIlllllIll == 92 || llllllllllllllIlllIlIlIIlllllIll == 93) {
                        llllllllllllllIlllIlIlIIllllllIl.cancel();
                    }
                    else if (llllllllllllllIlllIlIlIIlllllIIl == null) {
                        ViaRewind.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("[ViaRewind] Unhandled Spawn Object Type: ").append(llllllllllllllIlllIlIlIIlllllIll)));
                        llllllllllllllIlllIlIlIIllllllIl.cancel();
                    }
                    else {
                        llllllllllllllIlllIlIlIIlllllIII = llllllllllllllIlllIlIlIIllllllIl.get((Type<Integer>)Type.INT, 0);
                        llllllllllllllIlllIlIlIIllllIlll = llllllllllllllIlllIlIlIIllllllIl.get((Type<Integer>)Type.INT, 1);
                        llllllllllllllIlllIlIlIIllllIllI = llllllllllllllIlllIlIlIIllllllIl.get((Type<Integer>)Type.INT, 2);
                        if (llllllllllllllIlllIlIlIIlllllIIl.is(Entity1_10Types.EntityType.BOAT)) {
                            llllllllllllllIlllIlIlIlIIIIIllI = llllllllllllllIlllIlIlIIllllllIl.get((Type<Byte>)Type.BYTE, 1);
                            llllllllllllllIlllIlIlIlIIIIIllI2 = (byte)(llllllllllllllIlllIlIlIlIIIIIllI - 64);
                            llllllllllllllIlllIlIlIIllllllIl.set(Type.BYTE, 1, llllllllllllllIlllIlIlIlIIIIIllI2);
                            llllllllllllllIlllIlIlIIllllIlll += 10;
                            llllllllllllllIlllIlIlIIllllllIl.set(Type.INT, 1, llllllllllllllIlllIlIlIIllllIlll);
                        }
                        else if (llllllllllllllIlllIlIlIIlllllIIl.is(Entity1_10Types.EntityType.SHULKER_BULLET)) {
                            llllllllllllllIlllIlIlIIllllllIl.cancel();
                            llllllllllllllIlllIlIlIlIIIIIlIl = new ShulkerBulletReplacement(llllllllllllllIlllIlIlIIllllllII, llllllllllllllIlllIlIlIIllllllIl.user());
                            llllllllllllllIlllIlIlIlIIIIIlIl.setLocation(llllllllllllllIlllIlIlIIlllllIII / 32.0, llllllllllllllIlllIlIlIIllllIlll / 32.0, llllllllllllllIlllIlIlIIllllIllI / 32.0);
                            llllllllllllllIlllIlIlIIlllllIlI.addEntityReplacement(llllllllllllllIlllIlIlIlIIIIIlIl);
                            return;
                        }
                        llllllllllllllIlllIlIlIIllllIlIl = llllllllllllllIlllIlIlIIllllllIl.get((Type<Integer>)Type.INT, 3);
                        if (llllllllllllllIlllIlIlIIlllllIIl.isOrHasParent(Entity1_10Types.EntityType.ARROW) && llllllllllllllIlllIlIlIIllllIlIl != 0) {
                            llllllllllllllIlllIlIlIIllllllIl.set(Type.INT, 3, --llllllllllllllIlllIlIlIIllllIlIl);
                        }
                        if (llllllllllllllIlllIlIlIIlllllIIl.is(Entity1_10Types.EntityType.FALLING_BLOCK)) {
                            llllllllllllllIlllIlIlIlIIIIIlII = (llllllllllllllIlllIlIlIIllllIlIl & 0xFFF);
                            llllllllllllllIlllIlIlIlIIIIIIll = (llllllllllllllIlllIlIlIIllllIlIl >> 12 & 0xF);
                            llllllllllllllIlllIlIlIlIIIIIIlI = ReplacementRegistry1_8to1_9.getReplacement(llllllllllllllIlllIlIlIlIIIIIlII, llllllllllllllIlllIlIlIlIIIIIIll);
                            if (llllllllllllllIlllIlIlIlIIIIIIlI != null) {
                                llllllllllllllIlllIlIlIIllllllIl.set(Type.INT, 3, llllllllllllllIlllIlIlIlIIIIIIlI.getId() | llllllllllllllIlllIlIlIlIIIIIIlI.replaceData(llllllllllllllIlllIlIlIIllllIlIl) << 12);
                            }
                        }
                        if (llllllllllllllIlllIlIlIIllllIlIl > 0) {
                            llllllllllllllIlllIlIlIIllllllIl.passthrough((Type<Object>)Type.SHORT);
                            llllllllllllllIlllIlIlIIllllllIl.passthrough((Type<Object>)Type.SHORT);
                            llllllllllllllIlllIlIlIIllllllIl.passthrough((Type<Object>)Type.SHORT);
                        }
                        else {
                            llllllllllllllIlllIlIlIlIIIIIIIl = llllllllllllllIlllIlIlIIllllllIl.read((Type<Short>)Type.SHORT);
                            llllllllllllllIlllIlIlIlIIIIIIII = llllllllllllllIlllIlIlIIllllllIl.read((Type<Short>)Type.SHORT);
                            llllllllllllllIlllIlIlIIllllllll = llllllllllllllIlllIlIlIIllllllIl.read((Type<Short>)Type.SHORT);
                            llllllllllllllIlllIlIlIIlllllllI = PacketWrapper.create(18, null, llllllllllllllIlllIlIlIIllllllIl.user());
                            llllllllllllllIlllIlIlIIlllllllI.write(Type.VAR_INT, llllllllllllllIlllIlIlIIllllllII);
                            llllllllllllllIlllIlIlIIlllllllI.write(Type.SHORT, llllllllllllllIlllIlIlIlIIIIIIIl);
                            llllllllllllllIlllIlIlIIlllllllI.write(Type.SHORT, llllllllllllllIlllIlIlIlIIIIIIII);
                            llllllllllllllIlllIlIlIIlllllllI.write(Type.SHORT, llllllllllllllIlllIlIlIIllllllll);
                            PacketUtil.sendPacket(llllllllllllllIlllIlIlIIlllllllI, Protocol1_8TO1_9.class);
                        }
                        llllllllllllllIlllIlIlIIlllllIlI.getClientEntityTypes().put(llllllllllllllIlllIlIlIIllllllII, llllllllllllllIlllIlIlIIlllllIIl);
                        llllllllllllllIlllIlIlIIlllllIlI.sendMetadataBuffer(llllllllllllllIlllIlIlIIllllllII);
                    }
                });
            }
        });
        lllllllllllllllIlIIIIIIIIIIlllll.registerClientbound(ClientboundPackets1_9.SPAWN_EXPERIENCE_ORB, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.DOUBLE, Protocol1_8TO1_9.TO_OLD_INT);
                this.map(Type.DOUBLE, Protocol1_8TO1_9.TO_OLD_INT);
                this.map(Type.DOUBLE, Protocol1_8TO1_9.TO_OLD_INT);
                this.map(Type.SHORT);
                final int llllllllllllllIllIIIlIIllIIllIII;
                final EntityTracker llllllllllllllIllIIIlIIllIIlIlll;
                this.handler(llllllllllllllIllIIIlIIllIIlIllI -> {
                    llllllllllllllIllIIIlIIllIIllIII = llllllllllllllIllIIIlIIllIIlIllI.get((Type<Integer>)Type.VAR_INT, 0);
                    llllllllllllllIllIIIlIIllIIlIlll = llllllllllllllIllIIIlIIllIIlIllI.user().get(EntityTracker.class);
                    llllllllllllllIllIIIlIIllIIlIlll.getClientEntityTypes().put(llllllllllllllIllIIIlIIllIIllIII, Entity1_10Types.EntityType.EXPERIENCE_ORB);
                    llllllllllllllIllIIIlIIllIIlIlll.sendMetadataBuffer(llllllllllllllIllIIIlIIllIIllIII);
                });
            }
        });
        lllllllllllllllIlIIIIIIIIIIlllll.registerClientbound(ClientboundPackets1_9.SPAWN_GLOBAL_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.BYTE);
                this.map(Type.DOUBLE, Protocol1_8TO1_9.TO_OLD_INT);
                this.map(Type.DOUBLE, Protocol1_8TO1_9.TO_OLD_INT);
                this.map(Type.DOUBLE, Protocol1_8TO1_9.TO_OLD_INT);
                final int lllllllllllllIIIIlllIlIIlllIIIII;
                final EntityTracker lllllllllllllIIIIlllIlIIllIlllll;
                this.handler(lllllllllllllIIIIlllIlIIlllIIIIl -> {
                    lllllllllllllIIIIlllIlIIlllIIIII = lllllllllllllIIIIlllIlIIlllIIIIl.get((Type<Integer>)Type.VAR_INT, 0);
                    lllllllllllllIIIIlllIlIIllIlllll = lllllllllllllIIIIlllIlIIlllIIIIl.user().get(EntityTracker.class);
                    lllllllllllllIIIIlllIlIIllIlllll.getClientEntityTypes().put(lllllllllllllIIIIlllIlIIlllIIIII, Entity1_10Types.EntityType.LIGHTNING);
                    lllllllllllllIIIIlllIlIIllIlllll.sendMetadataBuffer(lllllllllllllIIIIlllIlIIlllIIIII);
                });
            }
        });
        lllllllllllllllIlIIIIIIIIIIlllll.registerClientbound(ClientboundPackets1_9.SPAWN_MOB, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID, Type.NOTHING);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.DOUBLE, Protocol1_8TO1_9.TO_OLD_INT);
                this.map(Type.DOUBLE, Protocol1_8TO1_9.TO_OLD_INT);
                this.map(Type.DOUBLE, Protocol1_8TO1_9.TO_OLD_INT);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Types1_9.METADATA_LIST, Types1_8.METADATA_LIST);
                final int lIllIlIIIlIlIll;
                final int lIllIlIIIlIlIlI;
                final int lIllIlIIIlIlIIl;
                final int lIllIlIIIlIlIII;
                final int lIllIlIIIlIIlll;
                final byte lIllIlIIIlIIllI;
                final byte lIllIlIIIlIIlIl;
                final byte lIllIlIIIlIIlII;
                EntityTracker lIllIlIIIlIlllI;
                ShulkerReplacement lIllIlIIIlIllIl;
                this.handler(lIllIlIIIlIIIll -> {
                    lIllIlIIIlIlIll = lIllIlIIIlIIIll.get((Type<Integer>)Type.VAR_INT, 0);
                    lIllIlIIIlIlIlI = lIllIlIIIlIIIll.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                    lIllIlIIIlIlIIl = lIllIlIIIlIIIll.get((Type<Integer>)Type.INT, 0);
                    lIllIlIIIlIlIII = lIllIlIIIlIIIll.get((Type<Integer>)Type.INT, 1);
                    lIllIlIIIlIIlll = lIllIlIIIlIIIll.get((Type<Integer>)Type.INT, 2);
                    lIllIlIIIlIIllI = lIllIlIIIlIIIll.get((Type<Byte>)Type.BYTE, 1);
                    lIllIlIIIlIIlIl = lIllIlIIIlIIIll.get((Type<Byte>)Type.BYTE, 0);
                    lIllIlIIIlIIlII = lIllIlIIIlIIIll.get((Type<Byte>)Type.BYTE, 2);
                    if (lIllIlIIIlIlIlI == 69) {
                        lIllIlIIIlIIIll.cancel();
                        lIllIlIIIlIlllI = lIllIlIIIlIIIll.user().get(EntityTracker.class);
                        lIllIlIIIlIllIl = new ShulkerReplacement(lIllIlIIIlIlIll, lIllIlIIIlIIIll.user());
                        lIllIlIIIlIllIl.setLocation(lIllIlIIIlIlIIl / 32.0, lIllIlIIIlIlIII / 32.0, lIllIlIIIlIIlll / 32.0);
                        lIllIlIIIlIllIl.setYawPitch(lIllIlIIIlIIlIl * 360.0f / 256.0f, lIllIlIIIlIIllI * 360.0f / 256.0f);
                        lIllIlIIIlIllIl.setHeadYaw(lIllIlIIIlIIlII * 360.0f / 256.0f);
                        lIllIlIIIlIlllI.addEntityReplacement(lIllIlIIIlIllIl);
                    }
                    else if (lIllIlIIIlIlIlI == -1 || lIllIlIIIlIlIlI == 255) {
                        lIllIlIIIlIIIll.cancel();
                    }
                    return;
                });
                final int lIllIlIIlIIIIII;
                final int lIllIlIIIllllll;
                final EntityTracker lIllIlIIIlllllI;
                this.handler(lIllIlIIIllllIl -> {
                    lIllIlIIlIIIIII = lIllIlIIIllllIl.get((Type<Integer>)Type.VAR_INT, 0);
                    lIllIlIIIllllll = lIllIlIIIllllIl.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                    lIllIlIIIlllllI = lIllIlIIIllllIl.user().get(EntityTracker.class);
                    lIllIlIIIlllllI.getClientEntityTypes().put(lIllIlIIlIIIIII, Entity1_10Types.getTypeFromId(lIllIlIIIllllll, false));
                    lIllIlIIIlllllI.sendMetadataBuffer(lIllIlIIlIIIIII);
                    return;
                });
                final List<Metadata> lIllIlIIlIIlllI;
                final int lIllIlIIlIIllIl;
                final EntityTracker lIllIlIIlIIllII;
                final EntityReplacement lIllIlIIlIIlIll;
                final Object o;
                this.handler(lIllIlIIlIIlIlI -> {
                    lIllIlIIlIIlllI = lIllIlIIlIIlIlI.get(Types1_8.METADATA_LIST, 0);
                    lIllIlIIlIIllIl = lIllIlIIlIIlIlI.get((Type<Integer>)Type.VAR_INT, 0);
                    lIllIlIIlIIllII = lIllIlIIlIIlIlI.user().get(EntityTracker.class);
                    lIllIlIIlIIlIll = lIllIlIIlIIllII.getEntityReplacement(lIllIlIIlIIllIl);
                    if (o != null) {
                        lIllIlIIlIIlIll.updateMetadata(lIllIlIIlIIlllI);
                    }
                    else if (lIllIlIIlIIllII.getClientEntityTypes().containsKey(lIllIlIIlIIllIl)) {
                        MetadataRewriter.transform(lIllIlIIlIIllII.getClientEntityTypes().get(lIllIlIIlIIllIl), lIllIlIIlIIlllI);
                    }
                    else {
                        lIllIlIIlIIlIlI.cancel();
                    }
                });
            }
        });
        lllllllllllllllIlIIIIIIIIIIlllll.registerClientbound(ClientboundPackets1_9.SPAWN_PAINTING, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID, Type.NOTHING);
                this.map(Type.STRING);
                this.map(Type.POSITION);
                this.map(Type.BYTE, Type.UNSIGNED_BYTE);
                final int llllllllllllllIIlllIllIlIlIIlIlI;
                final EntityTracker llllllllllllllIIlllIllIlIlIIlIII;
                this.handler(llllllllllllllIIlllIllIlIlIIllII -> {
                    llllllllllllllIIlllIllIlIlIIlIlI = llllllllllllllIIlllIllIlIlIIllII.get((Type<Integer>)Type.VAR_INT, 0);
                    llllllllllllllIIlllIllIlIlIIlIII = llllllllllllllIIlllIllIlIlIIllII.user().get(EntityTracker.class);
                    llllllllllllllIIlllIllIlIlIIlIII.getClientEntityTypes().put(llllllllllllllIIlllIllIlIlIIlIlI, Entity1_10Types.EntityType.PAINTING);
                    llllllllllllllIIlllIllIlIlIIlIII.sendMetadataBuffer(llllllllllllllIIlllIllIlIlIIlIlI);
                });
            }
        });
        lllllllllllllllIlIIIIIIIIIIlllll.registerClientbound(ClientboundPackets1_9.SPAWN_PLAYER, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.DOUBLE, Protocol1_8TO1_9.TO_OLD_INT);
                this.map(Type.DOUBLE, Protocol1_8TO1_9.TO_OLD_INT);
                this.map(Type.DOUBLE, Protocol1_8TO1_9.TO_OLD_INT);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.handler(llllllllllllllIlllIIlIIIllIllIll -> llllllllllllllIlllIIlIIIllIllIll.write(Type.SHORT, (Short)0));
                this.map(Types1_9.METADATA_LIST, Types1_8.METADATA_LIST);
                final List<Metadata> llllllllllllllIlllIIlIIIlllIIIII;
                this.handler(llllllllllllllIlllIIlIIIlllIIIIl -> {
                    llllllllllllllIlllIIlIIIlllIIIII = llllllllllllllIlllIIlIIIlllIIIIl.get(Types1_8.METADATA_LIST, 0);
                    MetadataRewriter.transform(Entity1_10Types.EntityType.PLAYER, llllllllllllllIlllIIlIIIlllIIIII);
                    return;
                });
                final int llllllllllllllIlllIIlIIIlllIlIII;
                final EntityTracker llllllllllllllIlllIIlIIIlllIIlll;
                this.handler(llllllllllllllIlllIIlIIIlllIlIIl -> {
                    llllllllllllllIlllIIlIIIlllIlIII = llllllllllllllIlllIIlIIIlllIlIIl.get((Type<Integer>)Type.VAR_INT, 0);
                    llllllllllllllIlllIIlIIIlllIIlll = llllllllllllllIlllIIlIIIlllIlIIl.user().get(EntityTracker.class);
                    llllllllllllllIlllIIlIIIlllIIlll.getClientEntityTypes().put(llllllllllllllIlllIIlIIIlllIlIII, Entity1_10Types.EntityType.PLAYER);
                    llllllllllllllIlllIIlIIIlllIIlll.sendMetadataBuffer(llllllllllllllIlllIIlIIIlllIlIII);
                });
            }
        });
    }
}
