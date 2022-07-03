package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.packets;

import com.viaversion.viaversion.api.protocol.remapper.*;
import de.gerrygames.viarewind.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.items.*;
import java.nio.charset.*;
import io.netty.buffer.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.provider.*;
import com.viaversion.viaversion.api.*;
import de.gerrygames.viarewind.utils.*;
import com.viaversion.viaversion.protocols.protocol1_8.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.entityreplacements.*;
import de.gerrygames.viarewind.replacement.*;
import de.gerrygames.viarewind.utils.math.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.api.type.types.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.protocol.*;
import java.util.*;

public class PlayerPackets
{
    public static void register(final Protocol1_7_6_10TO1_8 lllllllllllllIlIlllIIlIllIlIlIIl) {
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIlIlllIIlIllIlIlIIl).registerClientbound(ClientboundPackets1_8.JOIN_GAME, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.BYTE);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.STRING);
                this.map(Type.BOOLEAN, Type.NOTHING);
                this.handler(lllllllllllllIIlIIllIIIlIIlllllI -> {
                    if (!ViaRewind.getConfig().isReplaceAdventureMode()) {
                        return;
                    }
                    else {
                        if (lllllllllllllIIlIIllIIIlIIlllllI.get((Type<Short>)Type.UNSIGNED_BYTE, 0) == 2) {
                            lllllllllllllIIlIIllIIIlIIlllllI.set(Type.UNSIGNED_BYTE, 0, (Short)0);
                        }
                        return;
                    }
                });
                final EntityTracker lllllllllllllIIlIIllIIIlIlIIIIll;
                this.handler(lllllllllllllIIlIIllIIIlIlIIIIlI -> {
                    lllllllllllllIIlIIllIIIlIlIIIIll = lllllllllllllIIlIIllIIIlIlIIIIlI.user().get(EntityTracker.class);
                    lllllllllllllIIlIIllIIIlIlIIIIll.setGamemode(lllllllllllllIIlIIllIIIlIlIIIIlI.get((Type<Short>)Type.UNSIGNED_BYTE, 0));
                    lllllllllllllIIlIIllIIIlIlIIIIll.setPlayerId(lllllllllllllIIlIIllIIIlIlIIIIlI.get((Type<Integer>)Type.INT, 0));
                    lllllllllllllIIlIIllIIIlIlIIIIll.getClientEntityTypes().put(lllllllllllllIIlIIllIIIlIlIIIIll.getPlayerId(), Entity1_10Types.EntityType.ENTITY_HUMAN);
                    lllllllllllllIIlIIllIIIlIlIIIIll.setDimension(lllllllllllllIIlIIllIIIlIlIIIIlI.get((Type<Byte>)Type.BYTE, 0));
                    return;
                });
                final ClientWorld lllllllllllllIIlIIllIIIlIlIIlIIl;
                this.handler(lllllllllllllIIlIIllIIIlIlIIlIII -> {
                    lllllllllllllIIlIIllIIIlIlIIlIIl = lllllllllllllIIlIIllIIIlIlIIlIII.user().get(ClientWorld.class);
                    lllllllllllllIIlIIllIIIlIlIIlIIl.setEnvironment(lllllllllllllIIlIIllIIIlIlIIlIII.get((Type<Byte>)Type.BYTE, 0));
                    return;
                });
                this.handler(lllllllllllllIIlIIllIIIlIlIIllIl -> lllllllllllllIIlIIllIIIlIlIIllIl.user().put(new Scoreboard(lllllllllllllIIlIIllIIIlIlIIllIl.user())));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIlIlllIIlIllIlIlIIl).registerClientbound(ClientboundPackets1_8.CHAT_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.COMPONENT);
                final int llllllllllllllIlIllIllIllIIllIll;
                this.handler(llllllllllllllIlIllIllIllIIllIlI -> {
                    llllllllllllllIlIllIllIllIIllIll = llllllllllllllIlIllIllIllIIllIlI.read((Type<Byte>)Type.BYTE);
                    if (llllllllllllllIlIllIllIllIIllIll == 2) {
                        llllllllllllllIlIllIllIllIIllIlI.cancel();
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIlIlllIIlIllIlIlIIl).registerClientbound(ClientboundPackets1_8.SPAWN_POSITION, new PacketRemapper() {
            @Override
            public void registerMap() {
                final Position lllllllllllllIlIllllIIlIlIIIllIl;
                this.handler(lllllllllllllIlIllllIIlIlIIIllII -> {
                    lllllllllllllIlIllllIIlIlIIIllIl = lllllllllllllIlIllllIIlIlIIIllII.read(Type.POSITION);
                    lllllllllllllIlIllllIIlIlIIIllII.write(Type.INT, lllllllllllllIlIllllIIlIlIIIllIl.getX());
                    lllllllllllllIlIllllIIlIlIIIllII.write(Type.INT, lllllllllllllIlIllllIIlIlIIIllIl.getY());
                    lllllllllllllIlIllllIIlIlIIIllII.write(Type.INT, lllllllllllllIlIllllIIlIlIIIllIl.getZ());
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIlIlllIIlIllIlIlIIl).registerClientbound(ClientboundPackets1_8.UPDATE_HEALTH, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.FLOAT);
                this.map(Type.VAR_INT, Type.SHORT);
                this.map(Type.FLOAT);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIlIlllIIlIllIlIlIIl).registerClientbound(ClientboundPackets1_8.RESPAWN, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.STRING);
                this.handler(lllllllllllllIlIllllIllIllIlllII -> {
                    if (!ViaRewind.getConfig().isReplaceAdventureMode()) {
                        return;
                    }
                    else {
                        if (lllllllllllllIlIllllIllIllIlllII.get((Type<Short>)Type.UNSIGNED_BYTE, 1) == 2) {
                            lllllllllllllIlIllllIllIllIlllII.set(Type.UNSIGNED_BYTE, 1, (Short)0);
                        }
                        return;
                    }
                });
                final EntityTracker lllllllllllllIlIllllIllIlllIIIIl;
                this.handler(lllllllllllllIlIllllIllIlllIIIII -> {
                    lllllllllllllIlIllllIllIlllIIIIl = lllllllllllllIlIllllIllIlllIIIII.user().get(EntityTracker.class);
                    lllllllllllllIlIllllIllIlllIIIIl.setGamemode(lllllllllllllIlIllllIllIlllIIIII.get((Type<Short>)Type.UNSIGNED_BYTE, 1));
                    if (lllllllllllllIlIllllIllIlllIIIIl.getDimension() != lllllllllllllIlIllllIllIlllIIIII.get((Type<Integer>)Type.INT, 0)) {
                        lllllllllllllIlIllllIllIlllIIIIl.setDimension(lllllllllllllIlIllllIllIlllIIIII.get((Type<Integer>)Type.INT, 0));
                        lllllllllllllIlIllllIllIlllIIIIl.clearEntities();
                        lllllllllllllIlIllllIllIlllIIIIl.getClientEntityTypes().put(lllllllllllllIlIllllIllIlllIIIIl.getPlayerId(), Entity1_10Types.EntityType.ENTITY_HUMAN);
                    }
                    return;
                });
                final ClientWorld lllllllllllllIlIllllIllIlllIIlll;
                this.handler(lllllllllllllIlIllllIllIlllIIllI -> {
                    lllllllllllllIlIllllIllIlllIIlll = lllllllllllllIlIllllIllIlllIIllI.user().get(ClientWorld.class);
                    lllllllllllllIlIllllIllIlllIIlll.setEnvironment(lllllllllllllIlIllllIllIlllIIllI.get((Type<Integer>)Type.INT, 0));
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIlIlllIIlIllIlIlIIl).registerClientbound(ClientboundPackets1_8.PLAYER_POSITION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                final PlayerPosition llllllllllllllIlIIIllIlIIIIllIIl;
                final int llllllllllllllIlIIIllIlIIIIllIII;
                double llllllllllllllIlIIIllIlIIIIllllI;
                double llllllllllllllIlIIIllIlIIIIllllI2;
                double llllllllllllllIlIIIllIlIIIIlIlll;
                final double llllllllllllllIlIIIllIlIIIIlIlll2;
                double llllllllllllllIlIIIllIlIIIIlllIl;
                double llllllllllllllIlIIIllIlIIIIlllIl2;
                float llllllllllllllIlIIIllIlIIIIlllII;
                float llllllllllllllIlIIIllIlIIIIlllII2;
                float llllllllllllllIlIIIllIlIIIIllIll;
                float llllllllllllllIlIIIllIlIIIIllIll2;
                this.handler(llllllllllllllIlIIIllIlIIIIlIllI -> {
                    llllllllllllllIlIIIllIlIIIIllIIl = llllllllllllllIlIIIllIlIIIIlIllI.user().get(PlayerPosition.class);
                    llllllllllllllIlIIIllIlIIIIllIIl.setPositionPacketReceived(true);
                    llllllllllllllIlIIIllIlIIIIllIII = llllllllllllllIlIIIllIlIIIIlIllI.read((Type<Byte>)Type.BYTE);
                    if ((llllllllllllllIlIIIllIlIIIIllIII & 0x1) == 0x1) {
                        llllllllllllllIlIIIllIlIIIIllllI = llllllllllllllIlIIIllIlIIIIlIllI.get((Type<Double>)Type.DOUBLE, 0);
                        llllllllllllllIlIIIllIlIIIIllllI2 = llllllllllllllIlIIIllIlIIIIllllI + llllllllllllllIlIIIllIlIIIIllIIl.getPosX();
                        llllllllllllllIlIIIllIlIIIIlIllI.set(Type.DOUBLE, 0, llllllllllllllIlIIIllIlIIIIllllI2);
                    }
                    llllllllllllllIlIIIllIlIIIIlIlll = llllllllllllllIlIIIllIlIIIIlIllI.get((Type<Double>)Type.DOUBLE, 1);
                    if ((llllllllllllllIlIIIllIlIIIIllIII & 0x2) == 0x2) {
                        llllllllllllllIlIIIllIlIIIIlIlll += llllllllllllllIlIIIllIlIIIIllIIl.getPosY();
                    }
                    llllllllllllllIlIIIllIlIIIIllIIl.setReceivedPosY(llllllllllllllIlIIIllIlIIIIlIlll);
                    llllllllllllllIlIIIllIlIIIIlIlll2 = llllllllllllllIlIIIllIlIIIIlIlll + 1.6200000047683716;
                    llllllllllllllIlIIIllIlIIIIlIllI.set(Type.DOUBLE, 1, llllllllllllllIlIIIllIlIIIIlIlll2);
                    if ((llllllllllllllIlIIIllIlIIIIllIII & 0x4) == 0x4) {
                        llllllllllllllIlIIIllIlIIIIlllIl = llllllllllllllIlIIIllIlIIIIlIllI.get((Type<Double>)Type.DOUBLE, 2);
                        llllllllllllllIlIIIllIlIIIIlllIl2 = llllllllllllllIlIIIllIlIIIIlllIl + llllllllllllllIlIIIllIlIIIIllIIl.getPosZ();
                        llllllllllllllIlIIIllIlIIIIlIllI.set(Type.DOUBLE, 2, llllllllllllllIlIIIllIlIIIIlllIl2);
                    }
                    if ((llllllllllllllIlIIIllIlIIIIllIII & 0x8) == 0x8) {
                        llllllllllllllIlIIIllIlIIIIlllII = llllllllllllllIlIIIllIlIIIIlIllI.get((Type<Float>)Type.FLOAT, 0);
                        llllllllllllllIlIIIllIlIIIIlllII2 = llllllllllllllIlIIIllIlIIIIlllII + llllllllllllllIlIIIllIlIIIIllIIl.getYaw();
                        llllllllllllllIlIIIllIlIIIIlIllI.set(Type.FLOAT, 0, llllllllllllllIlIIIllIlIIIIlllII2);
                    }
                    if ((llllllllllllllIlIIIllIlIIIIllIII & 0x10) == 0x10) {
                        llllllllllllllIlIIIllIlIIIIllIll = llllllllllllllIlIIIllIlIIIIlIllI.get((Type<Float>)Type.FLOAT, 1);
                        llllllllllllllIlIIIllIlIIIIllIll2 = llllllllllllllIlIIIllIlIIIIllIll + llllllllllllllIlIIIllIlIIIIllIIl.getPitch();
                        llllllllllllllIlIIIllIlIIIIlIllI.set(Type.FLOAT, 1, llllllllllllllIlIIIllIlIIIIllIll2);
                    }
                    return;
                });
                final PlayerPosition llllllllllllllIlIIIllIlIIIllIIII;
                this.handler(llllllllllllllIlIIIllIlIIIlIlllI -> {
                    llllllllllllllIlIIIllIlIIIllIIII = llllllllllllllIlIIIllIlIIIlIlllI.user().get(PlayerPosition.class);
                    llllllllllllllIlIIIllIlIIIlIlllI.write(Type.BOOLEAN, llllllllllllllIlIIIllIlIIIllIIII.isOnGround());
                    return;
                });
                final EntityTracker llllllllllllllIlIIIllIlIIIllllII;
                this.handler(llllllllllllllIlIIIllIlIIIlllIlI -> {
                    llllllllllllllIlIIIllIlIIIllllII = llllllllllllllIlIIIllIlIIIlllIlI.user().get(EntityTracker.class);
                    if (llllllllllllllIlIIIllIlIIIllllII.getSpectating() != llllllllllllllIlIIIllIlIIIllllII.getPlayerId()) {
                        llllllllllllllIlIIIllIlIIIlllIlI.cancel();
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIlIlllIIlIllIlIlIIl).registerClientbound(ClientboundPackets1_8.SET_EXPERIENCE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.FLOAT);
                this.map(Type.VAR_INT, Type.SHORT);
                this.map(Type.VAR_INT, Type.SHORT);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIlIlllIIlIllIlIlIIl).registerClientbound(ClientboundPackets1_8.GAME_EVENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.FLOAT);
                final int llllllllllllllllIlIlllIIlIllllII;
                int llllllllllllllllIlIlllIIlIlllIll;
                EntityTracker llllllllllllllllIlIlllIIlIlllIlI;
                UUID llllllllllllllllIlIlllIIlIllllll;
                GameProfileStorage.GameProfile llllllllllllllllIlIlllIIllIIIIll;
                Item[] llllllllllllllllIlIlllIIllIIIIlI;
                Item[] llllllllllllllllIlIlllIIlIlllllI = null;
                int llllllllllllllllIlIlllIIllIIIIII;
                PacketWrapper llllllllllllllllIlIlllIIllIIIIIl;
                this.handler(llllllllllllllllIlIlllIIlIllllIl -> {
                    llllllllllllllllIlIlllIIlIllllII = llllllllllllllllIlIlllIIlIllllIl.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                    if (llllllllllllllllIlIlllIIlIllllII != 3) {
                        return;
                    }
                    else {
                        llllllllllllllllIlIlllIIlIlllIll = llllllllllllllllIlIlllIIlIllllIl.get((Type<Float>)Type.FLOAT, 0).intValue();
                        llllllllllllllllIlIlllIIlIlllIlI = llllllllllllllllIlIlllIIlIllllIl.user().get(EntityTracker.class);
                        if (llllllllllllllllIlIlllIIlIlllIll == 3 || llllllllllllllllIlIlllIIlIlllIlI.getGamemode() == 3) {
                            llllllllllllllllIlIlllIIlIllllll = llllllllllllllllIlIlllIIlIllllIl.user().getProtocolInfo().getUuid();
                            if (llllllllllllllllIlIlllIIlIlllIll == 3) {
                                llllllllllllllllIlIlllIIllIIIIll = llllllllllllllllIlIlllIIlIllllIl.user().get(GameProfileStorage.class).get(llllllllllllllllIlIlllIIlIllllll);
                                llllllllllllllllIlIlllIIllIIIIlI = new Item[] { null, null, null, null, llllllllllllllllIlIlllIIllIIIIll.getSkull() };
                            }
                            else {
                                llllllllllllllllIlIlllIIlIlllllI = llllllllllllllllIlIlllIIlIlllIlI.getPlayerEquipment(llllllllllllllllIlIlllIIlIllllll);
                                if (llllllllllllllllIlIlllIIlIlllllI == null) {
                                    llllllllllllllllIlIlllIIlIlllllI = new Item[5];
                                }
                            }
                            for (llllllllllllllllIlIlllIIllIIIIII = 1; llllllllllllllllIlIlllIIllIIIIII < 5; ++llllllllllllllllIlIlllIIllIIIIII) {
                                llllllllllllllllIlIlllIIllIIIIIl = PacketWrapper.create(47, null, llllllllllllllllIlIlllIIlIllllIl.user());
                                llllllllllllllllIlIlllIIllIIIIIl.write(Type.BYTE, (Byte)0);
                                llllllllllllllllIlIlllIIllIIIIIl.write(Type.SHORT, (short)(9 - llllllllllllllllIlIlllIIllIIIIII));
                                llllllllllllllllIlIlllIIllIIIIIl.write(Types1_7_6_10.COMPRESSED_NBT_ITEM, llllllllllllllllIlIlllIIlIlllllI[llllllllllllllllIlIlllIIllIIIIII]);
                                PacketUtil.sendPacket(llllllllllllllllIlIlllIIllIIIIIl, Protocol1_7_6_10TO1_8.class);
                            }
                        }
                        return;
                    }
                });
                final int llllllllllllllllIlIlllIIllIIllll;
                int llllllllllllllllIlIlllIIllIlIIIl;
                this.handler(llllllllllllllllIlIlllIIllIlIIII -> {
                    llllllllllllllllIlIlllIIllIIllll = llllllllllllllllIlIlllIIllIlIIII.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                    if (llllllllllllllllIlIlllIIllIIllll == 3) {
                        llllllllllllllllIlIlllIIllIlIIIl = llllllllllllllllIlIlllIIllIlIIII.get((Type<Float>)Type.FLOAT, 0).intValue();
                        if (llllllllllllllllIlIlllIIllIlIIIl == 2 && ViaRewind.getConfig().isReplaceAdventureMode()) {
                            llllllllllllllllIlIlllIIllIlIIIl = 0;
                            llllllllllllllllIlIlllIIllIlIIII.set(Type.FLOAT, 0, 0.0f);
                        }
                        llllllllllllllllIlIlllIIllIlIIII.user().get(EntityTracker.class).setGamemode(llllllllllllllllIlIlllIIllIlIIIl);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIlIlllIIlIllIlIlIIl).registerClientbound(ClientboundPackets1_8.OPEN_SIGN_EDITOR, new PacketRemapper() {
            @Override
            public void registerMap() {
                final Position llllllllllllllllIllIIllIlIIIlIll;
                this.handler(llllllllllllllllIllIIllIlIIIlIlI -> {
                    llllllllllllllllIllIIllIlIIIlIll = llllllllllllllllIllIIllIlIIIlIlI.read(Type.POSITION);
                    llllllllllllllllIllIIllIlIIIlIlI.write(Type.INT, llllllllllllllllIllIIllIlIIIlIll.getX());
                    llllllllllllllllIllIIllIlIIIlIlI.write(Type.INT, llllllllllllllllIllIIllIlIIIlIll.getY());
                    llllllllllllllllIllIIllIlIIIlIlI.write(Type.INT, llllllllllllllllIllIIllIlIIIlIll.getZ());
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIlIlllIIlIllIlIlIIl).registerClientbound(ClientboundPackets1_8.PLAYER_INFO, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int lllllllllllllllllllllllIIIlllllI;
                final int lllllllllllllllllllllllIIIllllIl;
                final GameProfileStorage lllllllllllllllllllllllIIIllllII;
                int lllllllllllllllllllllllIIlIIIIII;
                UUID lllllllllllllllllllllllIIlIIIIIl;
                String lllllllllllllllllllllllIIlIlIllI;
                GameProfileStorage.GameProfile lllllllllllllllllllllllIIlIlIlIl;
                int lllllllllllllllllllllllIIlIlIlII;
                final Object o;
                List<GameProfileStorage.Property> properties;
                final GameProfileStorage.Property property;
                int lllllllllllllllllllllllIIlIlIIll;
                int lllllllllllllllllllllllIIlIlIIlI;
                PacketWrapper lllllllllllllllllllllllIIlIlIIIl;
                int lllllllllllllllllllllllIIlIIlIlI;
                GameProfileStorage.GameProfile lllllllllllllllllllllllIIlIIlIIl;
                EntityTracker lllllllllllllllllllllllIIlIIllII;
                int lllllllllllllllllllllllIIlIIlIll;
                Item[] lllllllllllllllllllllllIIlIlIIII;
                Item[] lllllllllllllllllllllllIIlIIllIl = null;
                short lllllllllllllllllllllllIIlIIlllI;
                PacketWrapper lllllllllllllllllllllllIIlIIllll;
                int lllllllllllllllllllllllIIlIIlIII;
                GameProfileStorage.GameProfile lllllllllllllllllllllllIIlIIIlll;
                PacketWrapper lllllllllllllllllllllllIIlIIIllI;
                String lllllllllllllllllllllllIIlIIIlIl;
                GameProfileStorage.GameProfile lllllllllllllllllllllllIIlIIIlII;
                GameProfileStorage.GameProfile lllllllllllllllllllllllIIlIIIIll;
                PacketWrapper lllllllllllllllllllllllIIlIIIIlI;
                this.handler(lllllllllllllllllllllllIIIllllll -> {
                    lllllllllllllllllllllllIIIllllll.cancel();
                    lllllllllllllllllllllllIIIlllllI = lllllllllllllllllllllllIIIllllll.read((Type<Integer>)Type.VAR_INT);
                    lllllllllllllllllllllllIIIllllIl = lllllllllllllllllllllllIIIllllll.read((Type<Integer>)Type.VAR_INT);
                    lllllllllllllllllllllllIIIllllII = lllllllllllllllllllllllIIIllllll.user().get(GameProfileStorage.class);
                    for (lllllllllllllllllllllllIIlIIIIII = 0; lllllllllllllllllllllllIIlIIIIII < lllllllllllllllllllllllIIIllllIl; ++lllllllllllllllllllllllIIlIIIIII) {
                        lllllllllllllllllllllllIIlIIIIIl = lllllllllllllllllllllllIIIllllll.read(Type.UUID);
                        if (lllllllllllllllllllllllIIIlllllI == 0) {
                            lllllllllllllllllllllllIIlIlIllI = lllllllllllllllllllllllIIIllllll.read(Type.STRING);
                            lllllllllllllllllllllllIIlIlIlIl = lllllllllllllllllllllllIIIllllII.get(lllllllllllllllllllllllIIlIIIIIl);
                            if (lllllllllllllllllllllllIIlIlIlIl == null) {
                                lllllllllllllllllllllllIIlIlIlIl = lllllllllllllllllllllllIIIllllII.put(lllllllllllllllllllllllIIlIIIIIl, lllllllllllllllllllllllIIlIlIllI);
                            }
                            lllllllllllllllllllllllIIlIlIlII = lllllllllllllllllllllllIIIllllll.read((Type<Integer>)Type.VAR_INT);
                            while (true) {
                                lllllllllllllllllllllllIIlIlIlII--;
                                if (o > 0) {
                                    properties = lllllllllllllllllllllllIIlIlIlIl.properties;
                                    new GameProfileStorage.Property(lllllllllllllllllllllllIIIllllll.read(Type.STRING), lllllllllllllllllllllllIIIllllll.read(Type.STRING), lllllllllllllllllllllllIIIllllll.read((Type<Boolean>)Type.BOOLEAN) ? lllllllllllllllllllllllIIIllllll.read(Type.STRING) : null);
                                    properties.add(property);
                                }
                                else {
                                    break;
                                }
                            }
                            lllllllllllllllllllllllIIlIlIIll = lllllllllllllllllllllllIIIllllll.read((Type<Integer>)Type.VAR_INT);
                            lllllllllllllllllllllllIIlIlIIlI = lllllllllllllllllllllllIIIllllll.read((Type<Integer>)Type.VAR_INT);
                            lllllllllllllllllllllllIIlIlIlIl.ping = lllllllllllllllllllllllIIlIlIIlI;
                            lllllllllllllllllllllllIIlIlIlIl.gamemode = lllllllllllllllllllllllIIlIlIIll;
                            if (lllllllllllllllllllllllIIIllllll.read((Type<Boolean>)Type.BOOLEAN)) {
                                lllllllllllllllllllllllIIlIlIlIl.setDisplayName(ChatUtil.jsonToLegacy(lllllllllllllllllllllllIIIllllll.read(Type.COMPONENT)));
                            }
                            lllllllllllllllllllllllIIlIlIIIl = PacketWrapper.create(56, null, lllllllllllllllllllllllIIIllllll.user());
                            lllllllllllllllllllllllIIlIlIIIl.write(Type.STRING, lllllllllllllllllllllllIIlIlIlIl.name);
                            lllllllllllllllllllllllIIlIlIIIl.write(Type.BOOLEAN, true);
                            lllllllllllllllllllllllIIlIlIIIl.write(Type.SHORT, (short)lllllllllllllllllllllllIIlIlIIlI);
                            PacketUtil.sendPacket(lllllllllllllllllllllllIIlIlIIIl, Protocol1_7_6_10TO1_8.class);
                        }
                        else if (lllllllllllllllllllllllIIIlllllI == 1) {
                            lllllllllllllllllllllllIIlIIlIlI = lllllllllllllllllllllllIIIllllll.read((Type<Integer>)Type.VAR_INT);
                            lllllllllllllllllllllllIIlIIlIIl = lllllllllllllllllllllllIIIllllII.get(lllllllllllllllllllllllIIlIIIIIl);
                            if (lllllllllllllllllllllllIIlIIlIIl != null) {
                                if (lllllllllllllllllllllllIIlIIlIIl.gamemode != lllllllllllllllllllllllIIlIIlIlI) {
                                    if (lllllllllllllllllllllllIIlIIlIlI == 3 || lllllllllllllllllllllllIIlIIlIIl.gamemode == 3) {
                                        lllllllllllllllllllllllIIlIIllII = lllllllllllllllllllllllIIIllllll.user().get(EntityTracker.class);
                                        lllllllllllllllllllllllIIlIIlIll = lllllllllllllllllllllllIIlIIllII.getPlayerEntityId(lllllllllllllllllllllllIIlIIIIIl);
                                        if (lllllllllllllllllllllllIIlIIlIll != -1) {
                                            if (lllllllllllllllllllllllIIlIIlIlI == 3) {
                                                lllllllllllllllllllllllIIlIlIIII = new Item[] { null, null, null, null, lllllllllllllllllllllllIIlIIlIIl.getSkull() };
                                            }
                                            else {
                                                lllllllllllllllllllllllIIlIIllIl = lllllllllllllllllllllllIIlIIllII.getPlayerEquipment(lllllllllllllllllllllllIIlIIIIIl);
                                                if (lllllllllllllllllllllllIIlIIllIl == null) {
                                                    lllllllllllllllllllllllIIlIIllIl = new Item[5];
                                                }
                                            }
                                            for (lllllllllllllllllllllllIIlIIlllI = 0; lllllllllllllllllllllllIIlIIlllI < 5; ++lllllllllllllllllllllllIIlIIlllI) {
                                                lllllllllllllllllllllllIIlIIllll = PacketWrapper.create(4, null, lllllllllllllllllllllllIIIllllll.user());
                                                lllllllllllllllllllllllIIlIIllll.write(Type.INT, lllllllllllllllllllllllIIlIIlIll);
                                                lllllllllllllllllllllllIIlIIllll.write(Type.SHORT, lllllllllllllllllllllllIIlIIlllI);
                                                lllllllllllllllllllllllIIlIIllll.write(Types1_7_6_10.COMPRESSED_NBT_ITEM, lllllllllllllllllllllllIIlIIllIl[lllllllllllllllllllllllIIlIIlllI]);
                                                PacketUtil.sendPacket(lllllllllllllllllllllllIIlIIllll, Protocol1_7_6_10TO1_8.class);
                                            }
                                        }
                                    }
                                    lllllllllllllllllllllllIIlIIlIIl.gamemode = lllllllllllllllllllllllIIlIIlIlI;
                                }
                            }
                        }
                        else if (lllllllllllllllllllllllIIIlllllI == 2) {
                            lllllllllllllllllllllllIIlIIlIII = lllllllllllllllllllllllIIIllllll.read((Type<Integer>)Type.VAR_INT);
                            lllllllllllllllllllllllIIlIIIlll = lllllllllllllllllllllllIIIllllII.get(lllllllllllllllllllllllIIlIIIIIl);
                            if (lllllllllllllllllllllllIIlIIIlll != null) {
                                lllllllllllllllllllllllIIlIIIlll.ping = lllllllllllllllllllllllIIlIIlIII;
                                lllllllllllllllllllllllIIlIIIllI = PacketWrapper.create(56, null, lllllllllllllllllllllllIIIllllll.user());
                                lllllllllllllllllllllllIIlIIIllI.write(Type.STRING, lllllllllllllllllllllllIIlIIIlll.name);
                                lllllllllllllllllllllllIIlIIIllI.write(Type.BOOLEAN, true);
                                lllllllllllllllllllllllIIlIIIllI.write(Type.SHORT, (short)lllllllllllllllllllllllIIlIIlIII);
                                PacketUtil.sendPacket(lllllllllllllllllllllllIIlIIIllI, Protocol1_7_6_10TO1_8.class);
                            }
                        }
                        else if (lllllllllllllllllllllllIIIlllllI == 3) {
                            lllllllllllllllllllllllIIlIIIlIl = (lllllllllllllllllllllllIIIllllll.read((Type<Boolean>)Type.BOOLEAN) ? ChatUtil.jsonToLegacy(lllllllllllllllllllllllIIIllllll.read(Type.COMPONENT)) : null);
                            lllllllllllllllllllllllIIlIIIlII = lllllllllllllllllllllllIIIllllII.get(lllllllllllllllllllllllIIlIIIIIl);
                            if (lllllllllllllllllllllllIIlIIIlII != null) {
                                if (lllllllllllllllllllllllIIlIIIlII.displayName != null || lllllllllllllllllllllllIIlIIIlIl != null) {
                                    if ((lllllllllllllllllllllllIIlIIIlII.displayName == null && lllllllllllllllllllllllIIlIIIlIl != null) || (lllllllllllllllllllllllIIlIIIlII.displayName != null && lllllllllllllllllllllllIIlIIIlIl == null) || !lllllllllllllllllllllllIIlIIIlII.displayName.equals(lllllllllllllllllllllllIIlIIIlIl)) {
                                        lllllllllllllllllllllllIIlIIIlII.setDisplayName(lllllllllllllllllllllllIIlIIIlIl);
                                    }
                                }
                            }
                        }
                        else if (lllllllllllllllllllllllIIIlllllI == 4) {
                            lllllllllllllllllllllllIIlIIIIll = lllllllllllllllllllllllIIIllllII.remove(lllllllllllllllllllllllIIlIIIIIl);
                            if (lllllllllllllllllllllllIIlIIIIll != null) {
                                lllllllllllllllllllllllIIlIIIIlI = PacketWrapper.create(56, null, lllllllllllllllllllllllIIIllllll.user());
                                lllllllllllllllllllllllIIlIIIIlI.write(Type.STRING, lllllllllllllllllllllllIIlIIIIll.name);
                                lllllllllllllllllllllllIIlIIIIlI.write(Type.BOOLEAN, false);
                                lllllllllllllllllllllllIIlIIIIlI.write(Type.SHORT, (short)lllllllllllllllllllllllIIlIIIIll.ping);
                                PacketUtil.sendPacket(lllllllllllllllllllllllIIlIIIIlI, Protocol1_7_6_10TO1_8.class);
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIlIlllIIlIllIlIlIIl).registerClientbound(ClientboundPackets1_8.PLAYER_ABILITIES, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.BYTE);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                final byte lllllllllllllllIllIIIllIllIlIIIl;
                final float lllllllllllllllIllIIIllIllIlIIII;
                final float lllllllllllllllIllIIIllIllIIllll;
                final PlayerAbilities lllllllllllllllIllIIIllIllIIlllI;
                this.handler(lllllllllllllllIllIIIllIllIlIIlI -> {
                    lllllllllllllllIllIIIllIllIlIIIl = lllllllllllllllIllIIIllIllIlIIlI.get((Type<Byte>)Type.BYTE, 0);
                    lllllllllllllllIllIIIllIllIlIIII = lllllllllllllllIllIIIllIllIlIIlI.get((Type<Float>)Type.FLOAT, 0);
                    lllllllllllllllIllIIIllIllIIllll = lllllllllllllllIllIIIllIllIlIIlI.get((Type<Float>)Type.FLOAT, 1);
                    lllllllllllllllIllIIIllIllIIlllI = lllllllllllllllIllIIIllIllIlIIlI.user().get(PlayerAbilities.class);
                    lllllllllllllllIllIIIllIllIIlllI.setInvincible((lllllllllllllllIllIIIllIllIlIIIl & 0x8) == 0x8);
                    lllllllllllllllIllIIIllIllIIlllI.setAllowFly((lllllllllllllllIllIIIllIllIlIIIl & 0x4) == 0x4);
                    lllllllllllllllIllIIIllIllIIlllI.setFlying((lllllllllllllllIllIIIllIllIlIIIl & 0x2) == 0x2);
                    lllllllllllllllIllIIIllIllIIlllI.setCreative((lllllllllllllllIllIIIllIllIlIIIl & 0x1) == 0x1);
                    lllllllllllllllIllIIIllIllIIlllI.setFlySpeed(lllllllllllllllIllIIIllIllIlIIII);
                    lllllllllllllllIllIIIllIllIIlllI.setWalkSpeed(lllllllllllllllIllIIIllIllIIllll);
                    if (lllllllllllllllIllIIIllIllIIlllI.isSprinting() && lllllllllllllllIllIIIllIllIIlllI.isFlying()) {
                        lllllllllllllllIllIIIllIllIlIIlI.set(Type.FLOAT, 0, lllllllllllllllIllIIIllIllIIlllI.getFlySpeed() * 2.0f);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIlIlllIIlIllIlIlIIl).registerClientbound(ClientboundPackets1_8.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                final String lllllllllllllllIIIIlllIIllIlIIlI;
                int lllllllllllllllIIIIlllIIllIllllI;
                int lllllllllllllllIIIIlllIIllIlIllI = 0;
                int lllllllllllllllIIIIlllIIllIllIII;
                Item lllllllllllllllIIIIlllIIllIlllII;
                Item lllllllllllllllIIIIlllIIllIlllII2;
                boolean lllllllllllllllIIIIlllIIllIllIlI;
                Item lllllllllllllllIIIIlllIIllIlllII3;
                final ByteBuf lllllllllllllllIIIIlllIIllIlIIII;
                final PacketWrapper lllllllllllllllIIIIlllIIllIIlllI;
                this.handler(lllllllllllllllIIIIlllIIllIlIlII -> {
                    lllllllllllllllIIIIlllIIllIlIIlI = lllllllllllllllIIIIlllIIllIlIlII.get(Type.STRING, 0);
                    if (lllllllllllllllIIIIlllIIllIlIIlI.equalsIgnoreCase("MC|TrList")) {
                        lllllllllllllllIIIIlllIIllIlIlII.passthrough((Type<Object>)Type.INT);
                        if (lllllllllllllllIIIIlllIIllIlIlII.isReadable(Type.BYTE, 0)) {
                            lllllllllllllllIIIIlllIIllIllllI = lllllllllllllllIIIIlllIIllIlIlII.passthrough((Type<Byte>)Type.BYTE);
                        }
                        else {
                            lllllllllllllllIIIIlllIIllIlIllI = lllllllllllllllIIIIlllIIllIlIlII.passthrough((Type<Short>)Type.UNSIGNED_BYTE);
                        }
                        for (lllllllllllllllIIIIlllIIllIllIII = 0; lllllllllllllllIIIIlllIIllIllIII < lllllllllllllllIIIIlllIIllIlIllI; ++lllllllllllllllIIIIlllIIllIllIII) {
                            lllllllllllllllIIIIlllIIllIlllII = ItemRewriter.toClient(lllllllllllllllIIIIlllIIllIlIlII.read(Type.ITEM));
                            lllllllllllllllIIIIlllIIllIlIlII.write(Types1_7_6_10.COMPRESSED_NBT_ITEM, lllllllllllllllIIIIlllIIllIlllII);
                            lllllllllllllllIIIIlllIIllIlllII2 = ItemRewriter.toClient(lllllllllllllllIIIIlllIIllIlIlII.read(Type.ITEM));
                            lllllllllllllllIIIIlllIIllIlIlII.write(Types1_7_6_10.COMPRESSED_NBT_ITEM, lllllllllllllllIIIIlllIIllIlllII2);
                            lllllllllllllllIIIIlllIIllIllIlI = lllllllllllllllIIIIlllIIllIlIlII.passthrough((Type<Boolean>)Type.BOOLEAN);
                            if (lllllllllllllllIIIIlllIIllIllIlI) {
                                lllllllllllllllIIIIlllIIllIlllII3 = ItemRewriter.toClient(lllllllllllllllIIIIlllIIllIlIlII.read(Type.ITEM));
                                lllllllllllllllIIIIlllIIllIlIlII.write(Types1_7_6_10.COMPRESSED_NBT_ITEM, lllllllllllllllIIIIlllIIllIlllII3);
                            }
                            lllllllllllllllIIIIlllIIllIlIlII.passthrough((Type<Object>)Type.BOOLEAN);
                            lllllllllllllllIIIIlllIIllIlIlII.read((Type<Object>)Type.INT);
                            lllllllllllllllIIIIlllIIllIlIlII.read((Type<Object>)Type.INT);
                        }
                    }
                    else if (lllllllllllllllIIIIlllIIllIlIIlI.equalsIgnoreCase("MC|Brand")) {
                        lllllllllllllllIIIIlllIIllIlIlII.write(Type.REMAINING_BYTES, lllllllllllllllIIIIlllIIllIlIlII.read(Type.STRING).getBytes(StandardCharsets.UTF_8));
                    }
                    lllllllllllllllIIIIlllIIllIlIlII.cancel();
                    lllllllllllllllIIIIlllIIllIlIlII.setId(-1);
                    lllllllllllllllIIIIlllIIllIlIIII = Unpooled.buffer();
                    lllllllllllllllIIIIlllIIllIlIlII.writeToBuffer(lllllllllllllllIIIIlllIIllIlIIII);
                    lllllllllllllllIIIIlllIIllIIlllI = PacketWrapper.create(63, lllllllllllllllIIIIlllIIllIlIIII, lllllllllllllllIIIIlllIIllIlIlII.user());
                    lllllllllllllllIIIIlllIIllIIlllI.passthrough(Type.STRING);
                    if (lllllllllllllllIIIIlllIIllIlIIII.readableBytes() <= 32767) {
                        lllllllllllllllIIIIlllIIllIIlllI.write(Type.SHORT, (short)lllllllllllllllIIIIlllIIllIlIIII.readableBytes());
                        lllllllllllllllIIIIlllIIllIIlllI.send(Protocol1_7_6_10TO1_8.class);
                    }
                });
            }
        });
        ((Protocol<ClientboundPackets1_8, ClientboundPackets1_7, S1, S2>)lllllllllllllIlIlllIIlIllIlIlIIl).registerClientbound(ClientboundPackets1_8.CAMERA, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                final EntityTracker lllllllllllllIlIIlIIIlIIIllIIIIl;
                final int lllllllllllllIlIIlIIIlIIIllIIIII;
                final int lllllllllllllIlIIlIIIlIIIlIlllll;
                this.handler(lllllllllllllIlIIlIIIlIIIlIllllI -> {
                    lllllllllllllIlIIlIIIlIIIlIllllI.cancel();
                    lllllllllllllIlIIlIIIlIIIllIIIIl = lllllllllllllIlIIlIIIlIIIlIllllI.user().get(EntityTracker.class);
                    lllllllllllllIlIIlIIIlIIIllIIIII = lllllllllllllIlIIlIIIlIIIlIllllI.read((Type<Integer>)Type.VAR_INT);
                    lllllllllllllIlIIlIIIlIIIlIlllll = lllllllllllllIlIIlIIIlIIIllIIIIl.getSpectating();
                    if (lllllllllllllIlIIlIIIlIIIlIlllll != lllllllllllllIlIIlIIIlIIIllIIIII) {
                        lllllllllllllIlIIlIIIlIIIllIIIIl.setSpectating(lllllllllllllIlIIlIIIlIIIllIIIII);
                    }
                });
            }
        });
        ((Protocol<ClientboundPackets1_8, ClientboundPackets1_7, S1, S2>)lllllllllllllIlIlllIIlIllIlIlIIl).registerClientbound(ClientboundPackets1_8.TITLE, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                final TitleRenderProvider lllllllllllllIllIllIlllIIIIIIlll;
                int lllllllllllllIllIllIlllIIIIIIllI;
                UUID lllllllllllllIllIllIlllIIIIIIlIl;
                this.handler(lllllllllllllIllIllIlllIIIIIIlII -> {
                    lllllllllllllIllIllIlllIIIIIIlII.cancel();
                    lllllllllllllIllIllIlllIIIIIIlll = Via.getManager().getProviders().get(TitleRenderProvider.class);
                    if (lllllllllllllIllIllIlllIIIIIIlll != null) {
                        lllllllllllllIllIllIlllIIIIIIllI = lllllllllllllIllIllIlllIIIIIIlII.read((Type<Integer>)Type.VAR_INT);
                        lllllllllllllIllIllIlllIIIIIIlIl = Utils.getUUID(lllllllllllllIllIllIlllIIIIIIlII.user());
                        switch (lllllllllllllIllIllIlllIIIIIIllI) {
                            case 0: {
                                lllllllllllllIllIllIlllIIIIIIlll.setTitle(lllllllllllllIllIllIlllIIIIIIlIl, lllllllllllllIllIllIlllIIIIIIlII.read(Type.STRING));
                                break;
                            }
                            case 1: {
                                lllllllllllllIllIllIlllIIIIIIlll.setSubTitle(lllllllllllllIllIllIlllIIIIIIlIl, lllllllllllllIllIllIlllIIIIIIlII.read(Type.STRING));
                                break;
                            }
                            case 2: {
                                lllllllllllllIllIllIlllIIIIIIlll.setTimings(lllllllllllllIllIllIlllIIIIIIlIl, lllllllllllllIllIllIlllIIIIIIlII.read((Type<Integer>)Type.INT), lllllllllllllIllIllIlllIIIIIIlII.read((Type<Integer>)Type.INT), lllllllllllllIllIllIlllIIIIIIlII.read((Type<Integer>)Type.INT));
                                break;
                            }
                            case 3: {
                                lllllllllllllIllIllIlllIIIIIIlll.clear(lllllllllllllIllIllIlllIIIIIIlIl);
                                break;
                            }
                            case 4: {
                                lllllllllllllIllIllIlllIIIIIIlll.reset(lllllllllllllIllIllIlllIIIIIIlIl);
                                break;
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIlIlllIIlIllIlIlIIl).cancelClientbound(ClientboundPackets1_8.TAB_LIST);
        ((Protocol<ClientboundPackets1_8, ClientboundPackets1_7, S1, S2>)lllllllllllllIlIlllIIlIllIlIlIIl).registerClientbound(ClientboundPackets1_8.RESOURCE_PACK, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                final PacketWrapper lllllllllllllIllIllllIIIIIlIllIl;
                this.handler(lllllllllllllIllIllllIIIIIlIlllI -> {
                    lllllllllllllIllIllllIIIIIlIlllI.cancel();
                    lllllllllllllIllIllllIIIIIlIllIl = lllllllllllllIllIllllIIIIIlIlllI.create(ServerboundPackets1_8.RESOURCE_PACK_STATUS);
                    lllllllllllllIllIllllIIIIIlIllIl.write(Type.STRING, (String)lllllllllllllIllIllllIIIIIlIlllI.read((Type<T>)Type.STRING));
                    lllllllllllllIllIllllIIIIIlIllIl.write(Type.VAR_INT, 2);
                    lllllllllllllIllIllllIIIIIlIllIl.sendToServer(Protocol1_7_6_10TO1_8.class);
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_7>)lllllllllllllIlIlllIIlIllIlIlIIl).registerServerbound(ServerboundPackets1_7.CHAT_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                final String llllllllllllllIIlIIIIllIlllIIIII;
                final int llllllllllllllIIlIIIIllIllIlllll;
                String llllllllllllllIIlIIIIllIlllIIlII;
                GameProfileStorage llllllllllllllIIlIIIIllIlllIIIll;
                GameProfileStorage.GameProfile llllllllllllllIIlIIIIllIlllIIIlI;
                PacketWrapper llllllllllllllIIlIIIIllIlllIIlIl;
                this.handler(llllllllllllllIIlIIIIllIllIllllI -> {
                    llllllllllllllIIlIIIIllIlllIIIII = llllllllllllllIIlIIIIllIllIllllI.get(Type.STRING, 0);
                    llllllllllllllIIlIIIIllIllIlllll = llllllllllllllIIlIIIIllIllIllllI.user().get(EntityTracker.class).getGamemode();
                    if (llllllllllllllIIlIIIIllIllIlllll == 3 && llllllllllllllIIlIIIIllIlllIIIII.toLowerCase().startsWith("/stp ")) {
                        llllllllllllllIIlIIIIllIlllIIlII = llllllllllllllIIlIIIIllIlllIIIII.split(" ")[1];
                        llllllllllllllIIlIIIIllIlllIIIll = llllllllllllllIIlIIIIllIllIllllI.user().get(GameProfileStorage.class);
                        llllllllllllllIIlIIIIllIlllIIIlI = llllllllllllllIIlIIIIllIlllIIIll.get(llllllllllllllIIlIIIIllIlllIIlII, true);
                        if (llllllllllllllIIlIIIIllIlllIIIlI != null && llllllllllllllIIlIIIIllIlllIIIlI.uuid != null) {
                            llllllllllllllIIlIIIIllIllIllllI.cancel();
                            llllllllllllllIIlIIIIllIlllIIlIl = PacketWrapper.create(24, null, llllllllllllllIIlIIIIllIllIllllI.user());
                            llllllllllllllIIlIIIIllIlllIIlIl.write(Type.UUID, llllllllllllllIIlIIIIllIlllIIIlI.uuid);
                            PacketUtil.sendToServer(llllllllllllllIIlIIIIllIlllIIlIl, Protocol1_7_6_10TO1_8.class, true, true);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_7>)lllllllllllllIlIlllIIlIllIlIlIIl).registerServerbound(ServerboundPackets1_7.INTERACT_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT, Type.VAR_INT);
                this.map(Type.BYTE, Type.VAR_INT);
                final int lllllllllllllIIlllIIlIlIIlllIIll;
                int lllllllllllllIIlllIIlIlIIlllIIlI;
                EntityTracker lllllllllllllIIlllIIlIlIIlllIIIl;
                EntityReplacement lllllllllllllIIlllIIlIlIIlllIIII;
                ArmorStandReplacement lllllllllllllIIlllIIlIlIIllIllll;
                AABB lllllllllllllIIlllIIlIlIIllIlllI;
                PlayerPosition lllllllllllllIIlllIIlIlIIllIllII;
                Vector3d lllllllllllllIIlllIIlIlIIllIlIll;
                double lllllllllllllIIlllIIlIlIIllIlIlI;
                double lllllllllllllIIlllIIlIlIIllIIlll;
                Vector3d lllllllllllllIIlllIIlIlIIllIIllI;
                Ray3d lllllllllllllIIlllIIlIlIIllIIlIl;
                Vector3d lllllllllllllIIlllIIlIlIIllIIlII;
                int lllllllllllllIIlllIIlIlIIlllIIll2;
                this.handler(lllllllllllllIIlllIIlIlIIllIIIll -> {
                    lllllllllllllIIlllIIlIlIIlllIIll = lllllllllllllIIlllIIlIlIIllIIIll.get((Type<Integer>)Type.VAR_INT, 1);
                    if (lllllllllllllIIlllIIlIlIIlllIIll == 0) {
                        lllllllllllllIIlllIIlIlIIlllIIlI = lllllllllllllIIlllIIlIlIIllIIIll.get((Type<Integer>)Type.VAR_INT, 0);
                        lllllllllllllIIlllIIlIlIIlllIIIl = lllllllllllllIIlllIIlIlIIllIIIll.user().get(EntityTracker.class);
                        lllllllllllllIIlllIIlIlIIlllIIII = lllllllllllllIIlllIIlIlIIlllIIIl.getEntityReplacement(lllllllllllllIIlllIIlIlIIlllIIlI);
                        if (!(!(lllllllllllllIIlllIIlIlIIlllIIII instanceof ArmorStandReplacement))) {
                            lllllllllllllIIlllIIlIlIIllIllll = (ArmorStandReplacement)lllllllllllllIIlllIIlIlIIlllIIII;
                            lllllllllllllIIlllIIlIlIIllIlllI = lllllllllllllIIlllIIlIlIIllIllll.getBoundingBox();
                            lllllllllllllIIlllIIlIlIIllIllII = lllllllllllllIIlllIIlIlIIllIIIll.user().get(PlayerPosition.class);
                            lllllllllllllIIlllIIlIlIIllIlIll = new Vector3d(lllllllllllllIIlllIIlIlIIllIllII.getPosX(), lllllllllllllIIlllIIlIlIIllIllII.getPosY() + 1.8, lllllllllllllIIlllIIlIlIIllIllII.getPosZ());
                            lllllllllllllIIlllIIlIlIIllIlIlI = Math.toRadians(lllllllllllllIIlllIIlIlIIllIllII.getYaw());
                            lllllllllllllIIlllIIlIlIIllIIlll = Math.toRadians(lllllllllllllIIlllIIlIlIIllIllII.getPitch());
                            lllllllllllllIIlllIIlIlIIllIIllI = new Vector3d(-Math.cos(lllllllllllllIIlllIIlIlIIllIIlll) * Math.sin(lllllllllllllIIlllIIlIlIIllIlIlI), -Math.sin(lllllllllllllIIlllIIlIlIIllIIlll), Math.cos(lllllllllllllIIlllIIlIlIIllIIlll) * Math.cos(lllllllllllllIIlllIIlIlIIllIlIlI));
                            lllllllllllllIIlllIIlIlIIllIIlIl = new Ray3d(lllllllllllllIIlllIIlIlIIllIlIll, lllllllllllllIIlllIIlIlIIllIIllI);
                            lllllllllllllIIlllIIlIlIIllIIlII = RayTracing.trace(lllllllllllllIIlllIIlIlIIllIIlIl, lllllllllllllIIlllIIlIlIIllIlllI, 5.0);
                            if (lllllllllllllIIlllIIlIlIIllIIlII != null) {
                                lllllllllllllIIlllIIlIlIIllIIlII.substract(lllllllllllllIIlllIIlIlIIllIlllI.getMin());
                                lllllllllllllIIlllIIlIlIIlllIIll2 = 2;
                                lllllllllllllIIlllIIlIlIIllIIIll.set(Type.VAR_INT, 1, lllllllllllllIIlllIIlIlIIlllIIll2);
                                lllllllllllllIIlllIIlIlIIllIIIll.write(Type.FLOAT, (float)lllllllllllllIIlllIIlIlIIllIIlII.getX());
                                lllllllllllllIIlllIIlIlIIllIIIll.write(Type.FLOAT, (float)lllllllllllllIIlllIIlIlIIllIIlII.getY());
                                lllllllllllllIIlllIIlIlIIllIIIll.write(Type.FLOAT, (float)lllllllllllllIIlllIIlIlIIllIIlII.getZ());
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_7>)lllllllllllllIlIlllIIlIllIlIlIIl).registerServerbound(ServerboundPackets1_7.PLAYER_MOVEMENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.BOOLEAN);
                final PlayerPosition lllllllllllllIIIlIIIIIllIlIlIIll;
                this.handler(lllllllllllllIIIlIIIIIllIlIlIIlI -> {
                    lllllllllllllIIIlIIIIIllIlIlIIll = lllllllllllllIIIlIIIIIllIlIlIIlI.user().get(PlayerPosition.class);
                    lllllllllllllIIIlIIIIIllIlIlIIll.setOnGround(lllllllllllllIIIlIIIIIllIlIlIIlI.get((Type<Boolean>)Type.BOOLEAN, 0));
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_7>)lllllllllllllIlIlllIIlIllIlIlIIl).registerServerbound(ServerboundPackets1_7.PLAYER_POSITION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE, Type.NOTHING);
                this.map(Type.DOUBLE);
                this.map(Type.BOOLEAN);
                final double lllllllllllllllIlIIlllIlIllIIIlI;
                double lllllllllllllllIlIIlllIlIllIIIIl;
                final double lllllllllllllllIlIIlllIlIllIIIII;
                final PlayerPosition lllllllllllllllIlIIlllIlIlIlllll;
                this.handler(lllllllllllllllIlIIlllIlIlIllllI -> {
                    lllllllllllllllIlIIlllIlIllIIIlI = lllllllllllllllIlIIlllIlIlIllllI.get((Type<Double>)Type.DOUBLE, 0);
                    lllllllllllllllIlIIlllIlIllIIIIl = lllllllllllllllIlIIlllIlIlIllllI.get((Type<Double>)Type.DOUBLE, 1);
                    lllllllllllllllIlIIlllIlIllIIIII = lllllllllllllllIlIIlllIlIlIllllI.get((Type<Double>)Type.DOUBLE, 2);
                    lllllllllllllllIlIIlllIlIlIlllll = lllllllllllllllIlIIlllIlIlIllllI.user().get(PlayerPosition.class);
                    if (lllllllllllllllIlIIlllIlIlIlllll.isPositionPacketReceived()) {
                        lllllllllllllllIlIIlllIlIlIlllll.setPositionPacketReceived(false);
                        lllllllllllllllIlIIlllIlIllIIIIl -= 0.01;
                        lllllllllllllllIlIIlllIlIlIllllI.set(Type.DOUBLE, 1, lllllllllllllllIlIIlllIlIllIIIIl);
                    }
                    lllllllllllllllIlIIlllIlIlIlllll.setOnGround(lllllllllllllllIlIIlllIlIlIllllI.get((Type<Boolean>)Type.BOOLEAN, 0));
                    lllllllllllllllIlIIlllIlIlIlllll.setPos(lllllllllllllllIlIIlllIlIllIIIlI, lllllllllllllllIlIIlllIlIllIIIIl, lllllllllllllllIlIIlllIlIllIIIII);
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_7>)lllllllllllllIlIlllIIlIllIlIlIIl).registerServerbound(ServerboundPackets1_7.PLAYER_ROTATION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.BOOLEAN);
                final PlayerPosition llllllllllllllllIlIIlllIllllllII;
                this.handler(llllllllllllllllIlIIlllIllllllIl -> {
                    llllllllllllllllIlIIlllIllllllII = llllllllllllllllIlIIlllIllllllIl.user().get(PlayerPosition.class);
                    llllllllllllllllIlIIlllIllllllII.setYaw(llllllllllllllllIlIIlllIllllllIl.get((Type<Float>)Type.FLOAT, 0));
                    llllllllllllllllIlIIlllIllllllII.setPitch(llllllllllllllllIlIIlllIllllllIl.get((Type<Float>)Type.FLOAT, 1));
                    llllllllllllllllIlIIlllIllllllII.setOnGround(llllllllllllllllIlIIlllIllllllIl.get((Type<Boolean>)Type.BOOLEAN, 0));
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_7>)lllllllllllllIlIlllIIlIllIlIlIIl).registerServerbound(ServerboundPackets1_7.PLAYER_POSITION_AND_ROTATION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE, Type.NOTHING);
                this.map(Type.DOUBLE);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.BOOLEAN);
                final double llllllllllllIlllllIIlIllIllIllll;
                double llllllllllllIlllllIIlIllIllIlllI;
                final double llllllllllllIlllllIIlIllIllIllIl;
                final float llllllllllllIlllllIIlIllIllIllII;
                final float llllllllllllIlllllIIlIllIllIlIll;
                final PlayerPosition llllllllllllIlllllIIlIllIllIlIlI;
                this.handler(llllllllllllIlllllIIlIllIllIlIIl -> {
                    llllllllllllIlllllIIlIllIllIllll = llllllllllllIlllllIIlIllIllIlIIl.get((Type<Double>)Type.DOUBLE, 0);
                    llllllllllllIlllllIIlIllIllIlllI = llllllllllllIlllllIIlIllIllIlIIl.get((Type<Double>)Type.DOUBLE, 1);
                    llllllllllllIlllllIIlIllIllIllIl = llllllllllllIlllllIIlIllIllIlIIl.get((Type<Double>)Type.DOUBLE, 2);
                    llllllllllllIlllllIIlIllIllIllII = llllllllllllIlllllIIlIllIllIlIIl.get((Type<Float>)Type.FLOAT, 0);
                    llllllllllllIlllllIIlIllIllIlIll = llllllllllllIlllllIIlIllIllIlIIl.get((Type<Float>)Type.FLOAT, 1);
                    llllllllllllIlllllIIlIllIllIlIlI = llllllllllllIlllllIIlIllIllIlIIl.user().get(PlayerPosition.class);
                    if (llllllllllllIlllllIIlIllIllIlIlI.isPositionPacketReceived()) {
                        llllllllllllIlllllIIlIllIllIlIlI.setPositionPacketReceived(false);
                        llllllllllllIlllllIIlIllIllIlllI = llllllllllllIlllllIIlIllIllIlIlI.getReceivedPosY();
                        llllllllllllIlllllIIlIllIllIlIIl.set(Type.DOUBLE, 1, llllllllllllIlllllIIlIllIllIlllI);
                    }
                    llllllllllllIlllllIIlIllIllIlIlI.setOnGround(llllllllllllIlllllIIlIllIllIlIIl.get((Type<Boolean>)Type.BOOLEAN, 0));
                    llllllllllllIlllllIIlIllIllIlIlI.setPos(llllllllllllIlllllIIlIllIllIllll, llllllllllllIlllllIIlIllIllIlllI, llllllllllllIlllllIIlIllIllIllIl);
                    llllllllllllIlllllIIlIllIllIlIlI.setYaw(llllllllllllIlllllIIlIllIllIllII);
                    llllllllllllIlllllIIlIllIllIlIlI.setPitch(llllllllllllIlllllIIlIllIllIlIll);
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_7>)lllllllllllllIlIlllIIlIllIlIlIIl).registerServerbound(ServerboundPackets1_7.PLAYER_DIGGING, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.BYTE);
                final int lllllllllllllIIllllIIlIlllllIIII;
                final short lllllllllllllIIllllIIlIllllIllll;
                final int lllllllllllllIIllllIIlIllllIlllI;
                this.handler(lllllllllllllIIllllIIlIllllIllIl -> {
                    lllllllllllllIIllllIIlIlllllIIII = lllllllllllllIIllllIIlIllllIllIl.read((Type<Integer>)Type.INT);
                    lllllllllllllIIllllIIlIllllIllll = lllllllllllllIIllllIIlIllllIllIl.read((Type<Short>)Type.UNSIGNED_BYTE);
                    lllllllllllllIIllllIIlIllllIlllI = lllllllllllllIIllllIIlIllllIllIl.read((Type<Integer>)Type.INT);
                    lllllllllllllIIllllIIlIllllIllIl.write(Type.POSITION, new Position(lllllllllllllIIllllIIlIlllllIIII, lllllllllllllIIllllIIlIllllIllll, lllllllllllllIIllllIIlIllllIlllI));
                    return;
                });
                this.map(Type.BYTE);
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_7>)lllllllllllllIlIlllIIlIllIlIlIIl).registerServerbound(ServerboundPackets1_7.PLAYER_BLOCK_PLACEMENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int llllllllllllllIIIIIIlIIIIllIlIII;
                final short llllllllllllllIIIIIIlIIIIllIIlll;
                final int llllllllllllllIIIIIIlIIIIllIIllI;
                final Item llllllllllllllIIIIIIlIIIIllIIlIl;
                final Item llllllllllllllIIIIIIlIIIIllIIlIl2;
                int llllllllllllllIIIIIIlIIIIllIlIlI;
                this.handler(llllllllllllllIIIIIIlIIIIllIIlII -> {
                    llllllllllllllIIIIIIlIIIIllIlIII = llllllllllllllIIIIIIlIIIIllIIlII.read((Type<Integer>)Type.INT);
                    llllllllllllllIIIIIIlIIIIllIIlll = llllllllllllllIIIIIIlIIIIllIIlII.read((Type<Short>)Type.UNSIGNED_BYTE);
                    llllllllllllllIIIIIIlIIIIllIIllI = llllllllllllllIIIIIIlIIIIllIIlII.read((Type<Integer>)Type.INT);
                    llllllllllllllIIIIIIlIIIIllIIlII.write(Type.POSITION, new Position(llllllllllllllIIIIIIlIIIIllIlIII, llllllllllllllIIIIIIlIIIIllIIlll, llllllllllllllIIIIIIlIIIIllIIllI));
                    llllllllllllllIIIIIIlIIIIllIIlII.passthrough((Type<Object>)Type.BYTE);
                    llllllllllllllIIIIIIlIIIIllIIlIl = llllllllllllllIIIIIIlIIIIllIIlII.read(Types1_7_6_10.COMPRESSED_NBT_ITEM);
                    llllllllllllllIIIIIIlIIIIllIIlIl2 = ItemRewriter.toServer(llllllllllllllIIIIIIlIIIIllIIlIl);
                    llllllllllllllIIIIIIlIIIIllIIlII.write(Type.ITEM, llllllllllllllIIIIIIlIIIIllIIlIl2);
                    for (llllllllllllllIIIIIIlIIIIllIlIlI = 0; llllllllllllllIIIIIIlIIIIllIlIlI < 3; ++llllllllllllllIIIIIIlIIIIllIlIlI) {
                        llllllllllllllIIIIIIlIIIIllIIlII.passthrough((Type<Object>)Type.BYTE);
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_7>)lllllllllllllIlIlllIIlIllIlIlIIl).registerServerbound(ServerboundPackets1_7.ANIMATION, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int lllllllllllllIlIIIIIIIIIIlllIlll;
                final int lllllllllllllIlIIIIIIIIIIlllIllI;
                int lllllllllllllIlIIIIIIIIIIlllIllI2 = 0;
                PacketWrapper lllllllllllllIlIIIIIIIIIIlllIlIl;
                this.handler(lllllllllllllIlIIIIIIIIIIlllIlII -> {
                    lllllllllllllIlIIIIIIIIIIlllIlll = lllllllllllllIlIIIIIIIIIIlllIlII.read((Type<Integer>)Type.INT);
                    lllllllllllllIlIIIIIIIIIIlllIllI = lllllllllllllIlIIIIIIIIIIlllIlII.read((Type<Byte>)Type.BYTE);
                    if (lllllllllllllIlIIIIIIIIIIlllIllI != 1) {
                        lllllllllllllIlIIIIIIIIIIlllIlII.cancel();
                        switch (lllllllllllllIlIIIIIIIIIIlllIllI) {
                            case 104: {
                                lllllllllllllIlIIIIIIIIIIlllIllI2 = 0;
                                break;
                            }
                            case 105: {
                                lllllllllllllIlIIIIIIIIIIlllIllI2 = 1;
                                break;
                            }
                            case 3: {
                                lllllllllllllIlIIIIIIIIIIlllIllI2 = 2;
                                break;
                            }
                            default: {
                                return;
                            }
                        }
                        lllllllllllllIlIIIIIIIIIIlllIlIl = PacketWrapper.create(11, null, lllllllllllllIlIIIIIIIIIIlllIlII.user());
                        lllllllllllllIlIIIIIIIIIIlllIlIl.write(Type.VAR_INT, lllllllllllllIlIIIIIIIIIIlllIlll);
                        lllllllllllllIlIIIIIIIIIIlllIlIl.write(Type.VAR_INT, lllllllllllllIlIIIIIIIIIIlllIllI2);
                        lllllllllllllIlIIIIIIIIIIlllIlIl.write(Type.VAR_INT, 0);
                        PacketUtil.sendPacket(lllllllllllllIlIIIIIIIIIIlllIlIl, Protocol1_7_6_10TO1_8.class, true, true);
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_7>)lllllllllllllIlIlllIIlIllIlIlIIl).registerServerbound(ServerboundPackets1_7.ENTITY_ACTION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT, Type.VAR_INT);
                this.handler(lllllllllllllIIIlIlIIllllIllIIlI -> lllllllllllllIIIlIlIIllllIllIIlI.write(Type.VAR_INT, lllllllllllllIIIlIlIIllllIllIIlI.read((Type<Byte>)Type.BYTE) - 1));
                this.map(Type.INT, Type.VAR_INT);
                final int lllllllllllllIIIlIlIIllllIlllIII;
                PlayerAbilities lllllllllllllIIIlIlIIllllIlllIll;
                PacketWrapper lllllllllllllIIIlIlIIllllIlllIlI;
                this.handler(lllllllllllllIIIlIlIIllllIllIlll -> {
                    lllllllllllllIIIlIlIIllllIlllIII = lllllllllllllIIIlIlIIllllIllIlll.get((Type<Integer>)Type.VAR_INT, 1);
                    if (lllllllllllllIIIlIlIIllllIlllIII == 3 || lllllllllllllIIIlIlIIllllIlllIII == 4) {
                        lllllllllllllIIIlIlIIllllIlllIll = lllllllllllllIIIlIlIIllllIllIlll.user().get(PlayerAbilities.class);
                        lllllllllllllIIIlIlIIllllIlllIll.setSprinting(lllllllllllllIIIlIlIIllllIlllIII == 3);
                        lllllllllllllIIIlIlIIllllIlllIlI = PacketWrapper.create(57, null, lllllllllllllIIIlIlIIllllIllIlll.user());
                        lllllllllllllIIIlIlIIllllIlllIlI.write(Type.BYTE, lllllllllllllIIIlIlIIllllIlllIll.getFlags());
                        lllllllllllllIIIlIlIIllllIlllIlI.write(Type.FLOAT, lllllllllllllIIIlIlIIllllIlllIll.isSprinting() ? (lllllllllllllIIIlIlIIllllIlllIll.getFlySpeed() * 2.0f) : lllllllllllllIIIlIlIIllllIlllIll.getFlySpeed());
                        lllllllllllllIIIlIlIIllllIlllIlI.write(Type.FLOAT, lllllllllllllIIIlIlIIllllIlllIll.getWalkSpeed());
                        PacketUtil.sendPacket(lllllllllllllIIIlIlIIllllIlllIlI, Protocol1_7_6_10TO1_8.class);
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_7>)lllllllllllllIlIlllIIlIllIlIlIIl).registerServerbound(ServerboundPackets1_7.STEER_VEHICLE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                final boolean lllllllllllllIIllllllIlIlllIlllI;
                final boolean lllllllllllllIIllllllIlIlllIllIl;
                short lllllllllllllIIllllllIlIlllIllII;
                EntityTracker lllllllllllllIIllllllIlIllllIIII;
                PacketWrapper lllllllllllllIIllllllIlIllllIIlI;
                PacketWrapper lllllllllllllIIllllllIlIllllIIIl;
                this.handler(lllllllllllllIIllllllIlIlllIlIll -> {
                    lllllllllllllIIllllllIlIlllIlllI = lllllllllllllIIllllllIlIlllIlIll.read((Type<Boolean>)Type.BOOLEAN);
                    lllllllllllllIIllllllIlIlllIllIl = lllllllllllllIIllllllIlIlllIlIll.read((Type<Boolean>)Type.BOOLEAN);
                    lllllllllllllIIllllllIlIlllIllII = 0;
                    if (lllllllllllllIIllllllIlIlllIlllI) {
                        ++lllllllllllllIIllllllIlIlllIllII;
                    }
                    if (lllllllllllllIIllllllIlIlllIllIl) {
                        lllllllllllllIIllllllIlIlllIllII += 2;
                    }
                    lllllllllllllIIllllllIlIlllIlIll.write(Type.UNSIGNED_BYTE, lllllllllllllIIllllllIlIlllIllII);
                    if (lllllllllllllIIllllllIlIlllIllIl) {
                        lllllllllllllIIllllllIlIllllIIII = lllllllllllllIIllllllIlIlllIlIll.user().get(EntityTracker.class);
                        if (lllllllllllllIIllllllIlIllllIIII.getSpectating() != lllllllllllllIIllllllIlIllllIIII.getPlayerId()) {
                            lllllllllllllIIllllllIlIllllIIlI = PacketWrapper.create(11, null, lllllllllllllIIllllllIlIlllIlIll.user());
                            lllllllllllllIIllllllIlIllllIIlI.write(Type.VAR_INT, lllllllllllllIIllllllIlIllllIIII.getPlayerId());
                            lllllllllllllIIllllllIlIllllIIlI.write(Type.VAR_INT, 0);
                            lllllllllllllIIllllllIlIllllIIlI.write(Type.VAR_INT, 0);
                            lllllllllllllIIllllllIlIllllIIIl = PacketWrapper.create(11, null, lllllllllllllIIllllllIlIlllIlIll.user());
                            lllllllllllllIIllllllIlIllllIIIl.write(Type.VAR_INT, lllllllllllllIIllllllIlIllllIIII.getPlayerId());
                            lllllllllllllIIllllllIlIllllIIIl.write(Type.VAR_INT, 1);
                            lllllllllllllIIllllllIlIllllIIIl.write(Type.VAR_INT, 0);
                            PacketUtil.sendToServer(lllllllllllllIIllllllIlIllllIIlI, Protocol1_7_6_10TO1_8.class);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_7>)lllllllllllllIlIlllIIlIllIlIlIIl).registerServerbound(ServerboundPackets1_7.UPDATE_SIGN, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int llllllllllllllIIIlIlllIIIlIIlIIl;
                final short llllllllllllllIIIlIlllIIIlIIlIII;
                final int llllllllllllllIIIlIlllIIIlIIIlll;
                int llllllllllllllIIIlIlllIIIlIIlIll;
                String llllllllllllllIIIlIlllIIIlIIllII;
                String llllllllllllllIIIlIlllIIIlIIllII2;
                this.handler(llllllllllllllIIIlIlllIIIlIIlIlI -> {
                    llllllllllllllIIIlIlllIIIlIIlIIl = llllllllllllllIIIlIlllIIIlIIlIlI.read((Type<Integer>)Type.INT);
                    llllllllllllllIIIlIlllIIIlIIlIII = llllllllllllllIIIlIlllIIIlIIlIlI.read((Type<Short>)Type.SHORT);
                    llllllllllllllIIIlIlllIIIlIIIlll = llllllllllllllIIIlIlllIIIlIIlIlI.read((Type<Integer>)Type.INT);
                    llllllllllllllIIIlIlllIIIlIIlIlI.write(Type.POSITION, new Position(llllllllllllllIIIlIlllIIIlIIlIIl, llllllllllllllIIIlIlllIIIlIIlIII, llllllllllllllIIIlIlllIIIlIIIlll));
                    for (llllllllllllllIIIlIlllIIIlIIlIll = 0; llllllllllllllIIIlIlllIIIlIIlIll < 4; ++llllllllllllllIIIlIlllIIIlIIlIll) {
                        llllllllllllllIIIlIlllIIIlIIllII = llllllllllllllIIIlIlllIIIlIIlIlI.read(Type.STRING);
                        llllllllllllllIIIlIlllIIIlIIllII2 = ChatUtil.legacyToJson(llllllllllllllIIIlIlllIIIlIIllII);
                        llllllllllllllIIIlIlllIIIlIIlIlI.write(Type.COMPONENT, JsonParser.parseString(llllllllllllllIIIlIlllIIIlIIllII2));
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_7>)lllllllllllllIlIlllIIlIllIlIlIIl).registerServerbound(ServerboundPackets1_7.PLAYER_ABILITIES, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.BYTE);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                final PlayerAbilities lllllllllllllllIlIIIIIIIIIllllll;
                byte lllllllllllllllIlIIIIIIIIlIIIIIl;
                this.handler(lllllllllllllllIlIIIIIIIIIlllllI -> {
                    lllllllllllllllIlIIIIIIIIIllllll = lllllllllllllllIlIIIIIIIIIlllllI.user().get(PlayerAbilities.class);
                    if (lllllllllllllllIlIIIIIIIIIllllll.isAllowFly()) {
                        lllllllllllllllIlIIIIIIIIlIIIIIl = lllllllllllllllIlIIIIIIIIIlllllI.get((Type<Byte>)Type.BYTE, 0);
                        lllllllllllllllIlIIIIIIIIIllllll.setFlying((lllllllllllllllIlIIIIIIIIlIIIIIl & 0x2) == 0x2);
                    }
                    lllllllllllllllIlIIIIIIIIIlllllI.set(Type.FLOAT, 0, lllllllllllllllIlIIIIIIIIIllllll.getFlySpeed());
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_7>)lllllllllllllIlIlllIIlIllIlIlIIl).registerServerbound(ServerboundPackets1_7.TAB_COMPLETE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.create(Type.OPTIONAL_POSITION, null);
                final String lIlIlIlIIIIlllI;
                String[] lIlIlIlIIIlIIII;
                String lIlIlIlIIIlIlll;
                GameProfileStorage lIlIlIlIIIlIllI;
                List<GameProfileStorage.GameProfile> lIlIlIlIIIlIlII;
                PacketWrapper lIlIlIlIIIlIIlI;
                double lIlIlIlIIIIIlII;
                GameProfileStorage.GameProfile lIlIlIlIIIllIII;
                this.handler(lIlIlIlIIIIllIl -> {
                    lIlIlIlIIIIlllI = lIlIlIlIIIIllIl.get(Type.STRING, 0);
                    if (lIlIlIlIIIIlllI.toLowerCase().startsWith("/stp ")) {
                        lIlIlIlIIIIllIl.cancel();
                        lIlIlIlIIIlIIII = lIlIlIlIIIIlllI.split(" ");
                        if (lIlIlIlIIIlIIII.length <= 2) {
                            lIlIlIlIIIlIlll = ((lIlIlIlIIIlIIII.length == 1) ? "" : lIlIlIlIIIlIIII[1]);
                            lIlIlIlIIIlIllI = lIlIlIlIIIIllIl.user().get(GameProfileStorage.class);
                            lIlIlIlIIIlIlII = lIlIlIlIIIlIllI.getAllWithPrefix(lIlIlIlIIIlIlll, true);
                            lIlIlIlIIIlIIlI = PacketWrapper.create(58, null, lIlIlIlIIIIllIl.user());
                            lIlIlIlIIIlIIlI.write(Type.VAR_INT, lIlIlIlIIIlIlII.size());
                            lIlIlIlIIIIIlII = (double)lIlIlIlIIIlIlII.iterator();
                            while (((Iterator)lIlIlIlIIIIIlII).hasNext()) {
                                lIlIlIlIIIllIII = ((Iterator<GameProfileStorage.GameProfile>)lIlIlIlIIIIIlII).next();
                                lIlIlIlIIIlIIlI.write(Type.STRING, lIlIlIlIIIllIII.name);
                            }
                            PacketUtil.sendPacket(lIlIlIlIIIlIIlI, Protocol1_7_6_10TO1_8.class);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_7>)lllllllllllllIlIlllIIlIllIlIlIIl).registerServerbound(ServerboundPackets1_7.CLIENT_SETTINGS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.BOOLEAN);
                this.map(Type.BYTE, Type.NOTHING);
                final boolean llllllllllllllIllIlllllIIIIIIlIl;
                this.handler(llllllllllllllIllIlllllIIIIIIlII -> {
                    llllllllllllllIllIlllllIIIIIIlIl = llllllllllllllIllIlllllIIIIIIlII.read((Type<Boolean>)Type.BOOLEAN);
                    llllllllllllllIllIlllllIIIIIIlII.write(Type.UNSIGNED_BYTE, (short)(llllllllllllllIllIlllllIIIIIIlIl ? 127 : 126));
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_7>)lllllllllllllIlIlllIIlIllIlIlIIl).registerServerbound(ServerboundPackets1_7.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                final String llllllllllllllIlIllllllIlIIIlIIl;
                final int llllllllllllllIlIllllllIlIIIlIII;
                CustomByteType llllllllllllllIlIllllllIlIIlIllI;
                byte[] llllllllllllllIlIllllllIlIIlIlIl;
                String llllllllllllllIlIllllllIlIIlIlII;
                ByteBuf llllllllllllllIlIllllllIlIIlIIll;
                byte[] llllllllllllllIlIllllllIlIIlIlIl2;
                Windows llllllllllllllIlIllllllIlIIlIIlI;
                PacketWrapper llllllllllllllIlIllllllIlIIlIIIl;
                Item llllllllllllllIlIllllllIlIIIllII;
                CompoundTag llllllllllllllIlIllllllIlIIIlIll;
                ListTag llllllllllllllIlIllllllIlIIIllIl;
                int llllllllllllllIlIllllllIlIIIlllI;
                StringTag llllllllllllllIlIllllllIlIIlIIII;
                String llllllllllllllIlIllllllIlIIIllll;
                String llllllllllllllIlIllllllIlIIIllll2;
                this.handler(llllllllllllllIlIllllllIlIIIIlll -> {
                    llllllllllllllIlIllllllIlIIIlIIl = llllllllllllllIlIllllllIlIIIIlll.get(Type.STRING, 0);
                    llllllllllllllIlIllllllIlIIIlIII = llllllllllllllIlIllllllIlIIIIlll.read((Type<Short>)Type.SHORT);
                    if (llllllllllllllIlIllllllIlIIIlIIl.equalsIgnoreCase("MC|ItemName")) {
                        llllllllllllllIlIllllllIlIIlIllI = new CustomByteType(llllllllllllllIlIllllllIlIIIlIII);
                        llllllllllllllIlIllllllIlIIlIlIl = llllllllllllllIlIllllllIlIIIIlll.read((Type<byte[]>)llllllllllllllIlIllllllIlIIlIllI);
                        llllllllllllllIlIllllllIlIIlIlII = new String(llllllllllllllIlIllllllIlIIlIlIl, StandardCharsets.UTF_8);
                        llllllllllllllIlIllllllIlIIlIIll = llllllllllllllIlIllllllIlIIIIlll.user().getChannel().alloc().buffer();
                        Type.STRING.write(llllllllllllllIlIllllllIlIIlIIll, llllllllllllllIlIllllllIlIIlIlII);
                        llllllllllllllIlIllllllIlIIlIlIl2 = new byte[llllllllllllllIlIllllllIlIIlIIll.readableBytes()];
                        llllllllllllllIlIllllllIlIIlIIll.readBytes(llllllllllllllIlIllllllIlIIlIlIl2);
                        llllllllllllllIlIllllllIlIIlIIll.release();
                        llllllllllllllIlIllllllIlIIIIlll.write(Type.REMAINING_BYTES, llllllllllllllIlIllllllIlIIlIlIl2);
                        llllllllllllllIlIllllllIlIIlIIlI = llllllllllllllIlIllllllIlIIIIlll.user().get(Windows.class);
                        llllllllllllllIlIllllllIlIIlIIIl = PacketWrapper.create(49, null, llllllllllllllIlIllllllIlIIIIlll.user());
                        llllllllllllllIlIllllllIlIIlIIIl.write(Type.UNSIGNED_BYTE, llllllllllllllIlIllllllIlIIlIIlI.anvilId);
                        llllllllllllllIlIllllllIlIIlIIIl.write(Type.SHORT, (Short)0);
                        llllllllllllllIlIllllllIlIIlIIIl.write(Type.SHORT, llllllllllllllIlIllllllIlIIlIIlI.levelCost);
                        PacketUtil.sendPacket(llllllllllllllIlIllllllIlIIlIIIl, Protocol1_7_6_10TO1_8.class, true, true);
                    }
                    else if (llllllllllllllIlIllllllIlIIIlIIl.equalsIgnoreCase("MC|BEdit") || llllllllllllllIlIllllllIlIIIlIIl.equalsIgnoreCase("MC|BSign")) {
                        llllllllllllllIlIllllllIlIIIllII = llllllllllllllIlIllllllIlIIIIlll.read(Types1_7_6_10.COMPRESSED_NBT_ITEM);
                        llllllllllllllIlIllllllIlIIIlIll = llllllllllllllIlIllllllIlIIIllII.tag();
                        if (llllllllllllllIlIllllllIlIIIlIll != null && llllllllllllllIlIllllllIlIIIlIll.contains("pages")) {
                            for (llllllllllllllIlIllllllIlIIIllIl = llllllllllllllIlIllllllIlIIIlIll.get("pages"), llllllllllllllIlIllllllIlIIIlllI = 0; llllllllllllllIlIllllllIlIIIlllI < llllllllllllllIlIllllllIlIIIllIl.size(); ++llllllllllllllIlIllllllIlIIIlllI) {
                                llllllllllllllIlIllllllIlIIlIIII = llllllllllllllIlIllllllIlIIIllIl.get(llllllllllllllIlIllllllIlIIIlllI);
                                llllllllllllllIlIllllllIlIIIllll = llllllllllllllIlIllllllIlIIlIIII.getValue();
                                llllllllllllllIlIllllllIlIIIllll2 = ChatUtil.legacyToJson(llllllllllllllIlIllllllIlIIIllll);
                                llllllllllllllIlIllllllIlIIlIIII.setValue(llllllllllllllIlIllllllIlIIIllll2);
                            }
                        }
                        llllllllllllllIlIllllllIlIIIIlll.write(Type.ITEM, llllllllllllllIlIllllllIlIIIllII);
                    }
                    else if (llllllllllllllIlIllllllIlIIIlIIl.equalsIgnoreCase("MC|Brand")) {
                        llllllllllllllIlIllllllIlIIIIlll.write(Type.VAR_INT, llllllllllllllIlIllllllIlIIIlIII);
                    }
                });
            }
        });
    }
}
