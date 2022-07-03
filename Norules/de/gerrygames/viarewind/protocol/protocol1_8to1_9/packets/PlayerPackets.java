package de.gerrygames.viarewind.protocol.protocol1_8to1_9.packets;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.protocols.protocol1_8.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.items.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.minecraft.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.*;
import de.gerrygames.viarewind.utils.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.type.types.version.*;
import java.util.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class PlayerPackets
{
    public static void register(final Protocol<ClientboundPackets1_9, ClientboundPackets1_8, ServerboundPackets1_9, ServerboundPackets1_8> llllllllllllllIllllIlIlIlllllIlI) {
        llllllllllllllIllllIlIlIlllllIlI.registerClientbound(ClientboundPackets1_9.BOSSBAR, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                final UUID lllllllllllllIllIllIlllIIllIllIl;
                final int lllllllllllllIllIllIlllIIllIllII;
                final BossBarStorage lllllllllllllIllIllIlllIIllIlIll;
                String lllllllllllllIllIllIlllIIllIllll;
                this.handler(lllllllllllllIllIllIlllIIllIlIlI -> {
                    lllllllllllllIllIllIlllIIllIlIlI.cancel();
                    lllllllllllllIllIllIlllIIllIllIl = lllllllllllllIllIllIlllIIllIlIlI.read(Type.UUID);
                    lllllllllllllIllIllIlllIIllIllII = lllllllllllllIllIllIlllIIllIlIlI.read((Type<Integer>)Type.VAR_INT);
                    lllllllllllllIllIllIlllIIllIlIll = lllllllllllllIllIllIlllIIllIlIlI.user().get(BossBarStorage.class);
                    if (lllllllllllllIllIllIlllIIllIllII == 0) {
                        lllllllllllllIllIllIlllIIllIlIll.add(lllllllllllllIllIllIlllIIllIllIl, ChatUtil.jsonToLegacy(lllllllllllllIllIllIlllIIllIlIlI.read(Type.COMPONENT)), lllllllllllllIllIllIlllIIllIlIlI.read((Type<Float>)Type.FLOAT));
                        lllllllllllllIllIllIlllIIllIlIlI.read((Type<Object>)Type.VAR_INT);
                        lllllllllllllIllIllIlllIIllIlIlI.read((Type<Object>)Type.VAR_INT);
                        lllllllllllllIllIllIlllIIllIlIlI.read((Type<Object>)Type.UNSIGNED_BYTE);
                    }
                    else if (lllllllllllllIllIllIlllIIllIllII == 1) {
                        lllllllllllllIllIllIlllIIllIlIll.remove(lllllllllllllIllIllIlllIIllIllIl);
                    }
                    else if (lllllllllllllIllIllIlllIIllIllII == 2) {
                        lllllllllllllIllIllIlllIIllIlIll.updateHealth(lllllllllllllIllIllIlllIIllIllIl, lllllllllllllIllIllIlllIIllIlIlI.read((Type<Float>)Type.FLOAT));
                    }
                    else if (lllllllllllllIllIllIlllIIllIllII == 3) {
                        lllllllllllllIllIllIlllIIllIllll = ChatUtil.jsonToLegacy(lllllllllllllIllIllIlllIIllIlIlI.read(Type.COMPONENT));
                        lllllllllllllIllIllIlllIIllIlIll.updateTitle(lllllllllllllIllIllIlllIIllIllIl, lllllllllllllIllIllIlllIIllIllll);
                    }
                });
            }
        });
        llllllllllllllIllllIlIlIlllllIlI.cancelClientbound(ClientboundPackets1_9.COOLDOWN);
        llllllllllllllIllllIlIlIlllllIlI.registerClientbound(ClientboundPackets1_9.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                final String lllllllllllllIlIIlIIIlIllIIllIll;
                int lllllllllllllIlIIlIIIlIllIlIIIlI;
                int lllllllllllllIlIIlIIIlIllIIlllll = 0;
                int lllllllllllllIlIIlIIIlIllIlIIIII;
                boolean lllllllllllllIlIIlIIIlIllIlIIIIl;
                this.handler(lllllllllllllIlIIlIIIlIllIIlllIl -> {
                    lllllllllllllIlIIlIIIlIllIIllIll = lllllllllllllIlIIlIIIlIllIIlllIl.get(Type.STRING, 0);
                    if (lllllllllllllIlIIlIIIlIllIIllIll.equalsIgnoreCase("MC|TrList")) {
                        lllllllllllllIlIIlIIIlIllIIlllIl.passthrough((Type<Object>)Type.INT);
                        if (lllllllllllllIlIIlIIIlIllIIlllIl.isReadable(Type.BYTE, 0)) {
                            lllllllllllllIlIIlIIIlIllIlIIIlI = lllllllllllllIlIIlIIIlIllIIlllIl.passthrough((Type<Byte>)Type.BYTE);
                        }
                        else {
                            lllllllllllllIlIIlIIIlIllIIlllll = lllllllllllllIlIIlIIIlIllIIlllIl.passthrough((Type<Short>)Type.UNSIGNED_BYTE);
                        }
                        for (lllllllllllllIlIIlIIIlIllIlIIIII = 0; lllllllllllllIlIIlIIIlIllIlIIIII < lllllllllllllIlIIlIIIlIllIIlllll; ++lllllllllllllIlIIlIIIlIllIlIIIII) {
                            lllllllllllllIlIIlIIIlIllIIlllIl.write(Type.ITEM, ItemRewriter.toClient(lllllllllllllIlIIlIIIlIllIIlllIl.read(Type.ITEM)));
                            lllllllllllllIlIIlIIIlIllIIlllIl.write(Type.ITEM, ItemRewriter.toClient(lllllllllllllIlIIlIIIlIllIIlllIl.read(Type.ITEM)));
                            lllllllllllllIlIIlIIIlIllIlIIIIl = lllllllllllllIlIIlIIIlIllIIlllIl.passthrough((Type<Boolean>)Type.BOOLEAN);
                            if (lllllllllllllIlIIlIIIlIllIlIIIIl) {
                                lllllllllllllIlIIlIIIlIllIIlllIl.write(Type.ITEM, ItemRewriter.toClient(lllllllllllllIlIIlIIIlIllIIlllIl.read(Type.ITEM)));
                            }
                            lllllllllllllIlIIlIIIlIllIIlllIl.passthrough((Type<Object>)Type.BOOLEAN);
                            lllllllllllllIlIIlIIIlIllIIlllIl.passthrough((Type<Object>)Type.INT);
                            lllllllllllllIlIIlIIIlIllIIlllIl.passthrough((Type<Object>)Type.INT);
                        }
                    }
                    else if (lllllllllllllIlIIlIIIlIllIIllIll.equalsIgnoreCase("MC|BOpen")) {
                        lllllllllllllIlIIlIIIlIllIIlllIl.read((Type<Object>)Type.VAR_INT);
                    }
                });
            }
        });
        llllllllllllllIllllIlIlIlllllIlI.registerClientbound(ClientboundPackets1_9.GAME_EVENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.FLOAT);
                final int llllllllllllllIllIIlIIllIIlIlllI;
                this.handler(llllllllllllllIllIIlIIllIIlIllll -> {
                    llllllllllllllIllIIlIIllIIlIlllI = llllllllllllllIllIIlIIllIIlIllll.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                    if (llllllllllllllIllIIlIIllIIlIlllI == 3) {
                        llllllllllllllIllIIlIIllIIlIllll.user().get(EntityTracker.class).setPlayerGamemode(llllllllllllllIllIIlIIllIIlIllll.get((Type<Float>)Type.FLOAT, 0).intValue());
                    }
                });
            }
        });
        llllllllllllllIllllIlIlIlllllIlI.registerClientbound(ClientboundPackets1_9.JOIN_GAME, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.BYTE);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.STRING);
                this.map(Type.BOOLEAN);
                final EntityTracker lllllllllllllIIlIlIllIlllIIIIlII;
                this.handler(lllllllllllllIIlIlIllIlllIIIIlIl -> {
                    lllllllllllllIIlIlIllIlllIIIIlII = lllllllllllllIIlIlIllIlllIIIIlIl.user().get(EntityTracker.class);
                    lllllllllllllIIlIlIllIlllIIIIlII.setPlayerId(lllllllllllllIIlIlIllIlllIIIIlIl.get((Type<Integer>)Type.INT, 0));
                    lllllllllllllIIlIlIllIlllIIIIlII.setPlayerGamemode(lllllllllllllIIlIlIllIlllIIIIlIl.get((Type<Short>)Type.UNSIGNED_BYTE, 0));
                    lllllllllllllIIlIlIllIlllIIIIlII.getClientEntityTypes().put(lllllllllllllIIlIlIllIlllIIIIlII.getPlayerId(), Entity1_10Types.EntityType.ENTITY_HUMAN);
                    return;
                });
                final ClientWorld lllllllllllllIIlIlIllIlllIIIlIlI;
                this.handler(lllllllllllllIIlIlIllIlllIIIlIll -> {
                    lllllllllllllIIlIlIllIlllIIIlIlI = lllllllllllllIIlIlIllIlllIIIlIll.user().get(ClientWorld.class);
                    lllllllllllllIIlIlIllIlllIIIlIlI.setEnvironment(lllllllllllllIIlIlIllIlllIIIlIll.get((Type<Byte>)Type.BYTE, 0));
                });
            }
        });
        llllllllllllllIllllIlIlIlllllIlI.registerClientbound(ClientboundPackets1_9.PLAYER_POSITION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.BYTE);
                final PlayerPosition lllllllllllllIIIlIIIIlIIllIlllII;
                final int lllllllllllllIIIlIIIIlIIllIllIll;
                final byte lllllllllllllIIIlIIIIlIIllIllIlI;
                double lllllllllllllIIIlIIIIlIIllIllIIl;
                double lllllllllllllIIIlIIIIlIIllIllIII;
                double lllllllllllllIIIlIIIIlIIllIlIlll;
                float lllllllllllllIIIlIIIIlIIllIlIllI;
                float lllllllllllllIIIlIIIIlIIllIlIlIl;
                this.handler(lllllllllllllIIIlIIIIlIIllIlllIl -> {
                    lllllllllllllIIIlIIIIlIIllIlllII = lllllllllllllIIIlIIIIlIIllIlllIl.user().get(PlayerPosition.class);
                    lllllllllllllIIIlIIIIlIIllIllIll = lllllllllllllIIIlIIIIlIIllIlllIl.read((Type<Integer>)Type.VAR_INT);
                    lllllllllllllIIIlIIIIlIIllIlllII.setConfirmId(lllllllllllllIIIlIIIIlIIllIllIll);
                    lllllllllllllIIIlIIIIlIIllIllIlI = lllllllllllllIIIlIIIIlIIllIlllIl.get((Type<Byte>)Type.BYTE, 0);
                    lllllllllllllIIIlIIIIlIIllIllIIl = lllllllllllllIIIlIIIIlIIllIlllIl.get((Type<Double>)Type.DOUBLE, 0);
                    lllllllllllllIIIlIIIIlIIllIllIII = lllllllllllllIIIlIIIIlIIllIlllIl.get((Type<Double>)Type.DOUBLE, 1);
                    lllllllllllllIIIlIIIIlIIllIlIlll = lllllllllllllIIIlIIIIlIIllIlllIl.get((Type<Double>)Type.DOUBLE, 2);
                    lllllllllllllIIIlIIIIlIIllIlIllI = lllllllllllllIIIlIIIIlIIllIlllIl.get((Type<Float>)Type.FLOAT, 0);
                    lllllllllllllIIIlIIIIlIIllIlIlIl = lllllllllllllIIIlIIIIlIIllIlllIl.get((Type<Float>)Type.FLOAT, 1);
                    lllllllllllllIIIlIIIIlIIllIlllIl.set(Type.BYTE, 0, (Byte)0);
                    if (lllllllllllllIIIlIIIIlIIllIllIlI != 0) {
                        if ((lllllllllllllIIIlIIIIlIIllIllIlI & 0x1) != 0x0) {
                            lllllllllllllIIIlIIIIlIIllIllIIl += lllllllllllllIIIlIIIIlIIllIlllII.getPosX();
                            lllllllllllllIIIlIIIIlIIllIlllIl.set(Type.DOUBLE, 0, lllllllllllllIIIlIIIIlIIllIllIIl);
                        }
                        if ((lllllllllllllIIIlIIIIlIIllIllIlI & 0x2) != 0x0) {
                            lllllllllllllIIIlIIIIlIIllIllIII += lllllllllllllIIIlIIIIlIIllIlllII.getPosY();
                            lllllllllllllIIIlIIIIlIIllIlllIl.set(Type.DOUBLE, 1, lllllllllllllIIIlIIIIlIIllIllIII);
                        }
                        if ((lllllllllllllIIIlIIIIlIIllIllIlI & 0x4) != 0x0) {
                            lllllllllllllIIIlIIIIlIIllIlIlll += lllllllllllllIIIlIIIIlIIllIlllII.getPosZ();
                            lllllllllllllIIIlIIIIlIIllIlllIl.set(Type.DOUBLE, 2, lllllllllllllIIIlIIIIlIIllIlIlll);
                        }
                        if ((lllllllllllllIIIlIIIIlIIllIllIlI & 0x8) != 0x0) {
                            lllllllllllllIIIlIIIIlIIllIlIllI += lllllllllllllIIIlIIIIlIIllIlllII.getYaw();
                            lllllllllllllIIIlIIIIlIIllIlllIl.set(Type.FLOAT, 0, lllllllllllllIIIlIIIIlIIllIlIllI);
                        }
                        if ((lllllllllllllIIIlIIIIlIIllIllIlI & 0x10) != 0x0) {
                            lllllllllllllIIIlIIIIlIIllIlIlIl += lllllllllllllIIIlIIIIlIIllIlllII.getPitch();
                            lllllllllllllIIIlIIIIlIIllIlllIl.set(Type.FLOAT, 1, lllllllllllllIIIlIIIIlIIllIlIlIl);
                        }
                    }
                    lllllllllllllIIIlIIIIlIIllIlllII.setPos(lllllllllllllIIIlIIIIlIIllIllIIl, lllllllllllllIIIlIIIIlIIllIllIII, lllllllllllllIIIlIIIIlIIllIlIlll);
                    lllllllllllllIIIlIIIIlIIllIlllII.setYaw(lllllllllllllIIIlIIIIlIIllIlIllI);
                    lllllllllllllIIIlIIIIlIIllIlllII.setPitch(lllllllllllllIIIlIIIIlIIllIlIlIl);
                });
            }
        });
        llllllllllllllIllllIlIlIlllllIlI.registerClientbound(ClientboundPackets1_9.RESPAWN, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.STRING);
                this.handler(llllIIllIlIIlIl -> llllIIllIlIIlIl.user().get(EntityTracker.class).setPlayerGamemode(llllIIllIlIIlIl.get((Type<Short>)Type.UNSIGNED_BYTE, 1)));
                this.handler(llllIIllIlIlIII -> {
                    llllIIllIlIlIII.user().get(BossBarStorage.class).updateLocation();
                    llllIIllIlIlIII.user().get(BossBarStorage.class).changeWorld();
                    return;
                });
                final ClientWorld llllIIllIlIllII;
                this.handler(llllIIllIlIllIl -> {
                    llllIIllIlIllII = llllIIllIlIllIl.user().get(ClientWorld.class);
                    llllIIllIlIllII.setEnvironment(llllIIllIlIllIl.get((Type<Integer>)Type.INT, 0));
                });
            }
        });
        llllllllllllllIllllIlIlIlllllIlI.registerServerbound(ServerboundPackets1_8.CHAT_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                final String llllllllllllllIIlIlIIllllIIllllI;
                PacketWrapper llllllllllllllIIlIlIIllllIlIIIII;
                this.handler(llllllllllllllIIlIlIIllllIIlllll -> {
                    llllllllllllllIIlIlIIllllIIllllI = llllllllllllllIIlIlIIllllIIlllll.get(Type.STRING, 0);
                    if (llllllllllllllIIlIlIIllllIIllllI.toLowerCase().startsWith("/offhand")) {
                        llllllllllllllIIlIlIIllllIIlllll.cancel();
                        llllllllllllllIIlIlIIllllIlIIIII = PacketWrapper.create(19, null, llllllllllllllIIlIlIIllllIIlllll.user());
                        llllllllllllllIIlIlIIllllIlIIIII.write(Type.VAR_INT, 6);
                        llllllllllllllIIlIlIIllllIlIIIII.write(Type.POSITION, new Position(0, (short)0, 0));
                        llllllllllllllIIlIlIIllllIlIIIII.write(Type.BYTE, (Byte)(-1));
                        PacketUtil.sendToServer(llllllllllllllIIlIlIIllllIlIIIII, Protocol1_8TO1_9.class, true, true);
                    }
                });
            }
        });
        llllllllllllllIllllIlIlIlllllIlI.registerServerbound(ServerboundPackets1_8.INTERACT_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                final int lllllllllllllIIlIllIlllIlIllIIII;
                this.handler(lllllllllllllIIlIllIlllIlIlIllll -> {
                    lllllllllllllIIlIllIlllIlIllIIII = lllllllllllllIIlIllIlllIlIlIllll.get((Type<Integer>)Type.VAR_INT, 1);
                    if (lllllllllllllIIlIllIlllIlIllIIII == 2) {
                        lllllllllllllIIlIllIlllIlIlIllll.passthrough((Type<Object>)Type.FLOAT);
                        lllllllllllllIIlIllIlllIlIlIllll.passthrough((Type<Object>)Type.FLOAT);
                        lllllllllllllIIlIllIlllIlIlIllll.passthrough((Type<Object>)Type.FLOAT);
                    }
                    if (lllllllllllllIIlIllIlllIlIllIIII == 2 || lllllllllllllIIlIllIlllIlIllIIII == 0) {
                        lllllllllllllIIlIllIlllIlIlIllll.write(Type.VAR_INT, 0);
                    }
                });
            }
        });
        llllllllllllllIllllIlIlIlllllIlI.registerServerbound(ServerboundPackets1_8.PLAYER_MOVEMENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.BOOLEAN);
                final EntityTracker lllllllllllllIIIIIlIlIlllIlIIIIl;
                final int lllllllllllllIIIIIlIlIlllIlIIIII;
                this.handler(lllllllllllllIIIIIlIlIlllIlIIIlI -> {
                    lllllllllllllIIIIIlIlIlllIlIIIIl = lllllllllllllIIIIIlIlIlllIlIIIlI.user().get(EntityTracker.class);
                    lllllllllllllIIIIIlIlIlllIlIIIII = lllllllllllllIIIIIlIlIlllIlIIIIl.getPlayerId();
                    if (lllllllllllllIIIIIlIlIlllIlIIIIl.isInsideVehicle(lllllllllllllIIIIIlIlIlllIlIIIII)) {
                        lllllllllllllIIIIIlIlIlllIlIIIlI.cancel();
                    }
                });
            }
        });
        llllllllllllllIllllIlIlIlllllIlI.registerServerbound(ServerboundPackets1_8.PLAYER_POSITION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BOOLEAN);
                final PlayerPosition lllllllllllllIlIlIlIlIllIIlIlIll;
                this.handler(lllllllllllllIlIlIlIlIllIIlIllII -> {
                    lllllllllllllIlIlIlIlIllIIlIlIll = lllllllllllllIlIlIlIlIllIIlIllII.user().get(PlayerPosition.class);
                    if (lllllllllllllIlIlIlIlIllIIlIlIll.getConfirmId() != -1) {
                        return;
                    }
                    else {
                        lllllllllllllIlIlIlIlIllIIlIlIll.setPos(lllllllllllllIlIlIlIlIllIIlIllII.get((Type<Double>)Type.DOUBLE, 0), lllllllllllllIlIlIlIlIllIIlIllII.get((Type<Double>)Type.DOUBLE, 1), lllllllllllllIlIlIlIlIllIIlIllII.get((Type<Double>)Type.DOUBLE, 2));
                        lllllllllllllIlIlIlIlIllIIlIlIll.setOnGround(lllllllllllllIlIlIlIlIllIIlIllII.get((Type<Boolean>)Type.BOOLEAN, 0));
                        return;
                    }
                });
                this.handler(lllllllllllllIlIlIlIlIllIIllIIII -> lllllllllllllIlIlIlIlIllIIllIIII.user().get(BossBarStorage.class).updateLocation());
            }
        });
        llllllllllllllIllllIlIlIlllllIlI.registerServerbound(ServerboundPackets1_8.PLAYER_ROTATION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.BOOLEAN);
                final PlayerPosition lllllllllllllIIlIllllIIllIllIlIl;
                this.handler(lllllllllllllIIlIllllIIllIllIllI -> {
                    lllllllllllllIIlIllllIIllIllIlIl = lllllllllllllIIlIllllIIllIllIllI.user().get(PlayerPosition.class);
                    if (lllllllllllllIIlIllllIIllIllIlIl.getConfirmId() != -1) {
                        return;
                    }
                    else {
                        lllllllllllllIIlIllllIIllIllIlIl.setYaw(lllllllllllllIIlIllllIIllIllIllI.get((Type<Float>)Type.FLOAT, 0));
                        lllllllllllllIIlIllllIIllIllIlIl.setPitch(lllllllllllllIIlIllllIIllIllIllI.get((Type<Float>)Type.FLOAT, 1));
                        lllllllllllllIIlIllllIIllIllIlIl.setOnGround(lllllllllllllIIlIllllIIllIllIllI.get((Type<Boolean>)Type.BOOLEAN, 0));
                        return;
                    }
                });
                this.handler(lllllllllllllIIlIllllIIllIlllIIl -> lllllllllllllIIlIllllIIllIlllIIl.user().get(BossBarStorage.class).updateLocation());
            }
        });
        llllllllllllllIllllIlIlIlllllIlI.registerServerbound(ServerboundPackets1_8.PLAYER_POSITION_AND_ROTATION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.BOOLEAN);
                final double lllllllllllllllIlIllIlIIIlIIIlll;
                final double lllllllllllllllIlIllIlIIIlIIIllI;
                final double lllllllllllllllIlIllIlIIIlIIIlIl;
                final float lllllllllllllllIlIllIlIIIlIIIlII;
                final float lllllllllllllllIlIllIlIIIlIIIIll;
                final boolean lllllllllllllllIlIllIlIIIlIIIIlI;
                final PlayerPosition lllllllllllllllIlIllIlIIIlIIIIIl;
                PacketWrapper lllllllllllllllIlIllIlIIIlIIlIIl;
                this.handler(lllllllllllllllIlIllIlIIIlIIlIII -> {
                    lllllllllllllllIlIllIlIIIlIIIlll = lllllllllllllllIlIllIlIIIlIIlIII.get((Type<Double>)Type.DOUBLE, 0);
                    lllllllllllllllIlIllIlIIIlIIIllI = lllllllllllllllIlIllIlIIIlIIlIII.get((Type<Double>)Type.DOUBLE, 1);
                    lllllllllllllllIlIllIlIIIlIIIlIl = lllllllllllllllIlIllIlIIIlIIlIII.get((Type<Double>)Type.DOUBLE, 2);
                    lllllllllllllllIlIllIlIIIlIIIlII = lllllllllllllllIlIllIlIIIlIIlIII.get((Type<Float>)Type.FLOAT, 0);
                    lllllllllllllllIlIllIlIIIlIIIIll = lllllllllllllllIlIllIlIIIlIIlIII.get((Type<Float>)Type.FLOAT, 1);
                    lllllllllllllllIlIllIlIIIlIIIIlI = lllllllllllllllIlIllIlIIIlIIlIII.get((Type<Boolean>)Type.BOOLEAN, 0);
                    lllllllllllllllIlIllIlIIIlIIIIIl = lllllllllllllllIlIllIlIIIlIIlIII.user().get(PlayerPosition.class);
                    if (lllllllllllllllIlIllIlIIIlIIIIIl.getConfirmId() != -1) {
                        if (lllllllllllllllIlIllIlIIIlIIIIIl.getPosX() == lllllllllllllllIlIllIlIIIlIIIlll && lllllllllllllllIlIllIlIIIlIIIIIl.getPosY() == lllllllllllllllIlIllIlIIIlIIIllI && lllllllllllllllIlIllIlIIIlIIIIIl.getPosZ() == lllllllllllllllIlIllIlIIIlIIIlIl && lllllllllllllllIlIllIlIIIlIIIIIl.getYaw() == lllllllllllllllIlIllIlIIIlIIIlII && lllllllllllllllIlIllIlIIIlIIIIIl.getPitch() == lllllllllllllllIlIllIlIIIlIIIIll) {
                            lllllllllllllllIlIllIlIIIlIIlIIl = lllllllllllllllIlIllIlIIIlIIlIII.create(0);
                            lllllllllllllllIlIllIlIIIlIIlIIl.write(Type.VAR_INT, lllllllllllllllIlIllIlIIIlIIIIIl.getConfirmId());
                            PacketUtil.sendToServer(lllllllllllllllIlIllIlIIIlIIlIIl, Protocol1_8TO1_9.class, true, true);
                            lllllllllllllllIlIllIlIIIlIIIIIl.setConfirmId(-1);
                        }
                    }
                    else {
                        lllllllllllllllIlIllIlIIIlIIIIIl.setPos(lllllllllllllllIlIllIlIIIlIIIlll, lllllllllllllllIlIllIlIIIlIIIllI, lllllllllllllllIlIllIlIIIlIIIlIl);
                        lllllllllllllllIlIllIlIIIlIIIIIl.setYaw(lllllllllllllllIlIllIlIIIlIIIlII);
                        lllllllllllllllIlIllIlIIIlIIIIIl.setPitch(lllllllllllllllIlIllIlIIIlIIIIll);
                        lllllllllllllllIlIllIlIIIlIIIIIl.setOnGround(lllllllllllllllIlIllIlIIIlIIIIlI);
                        lllllllllllllllIlIllIlIIIlIIlIII.user().get(BossBarStorage.class).updateLocation();
                    }
                });
            }
        });
        llllllllllllllIllllIlIlIlllllIlI.registerServerbound(ServerboundPackets1_8.PLAYER_DIGGING, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.BYTE, Type.VAR_INT);
                this.map(Type.POSITION);
                this.map(Type.BYTE);
                final int llllllllllllllIIlIlIlllIlIIIlIIl;
                BlockPlaceDestroyTracker llllllllllllllIIlIlIlllIlIIIllII;
                BlockPlaceDestroyTracker llllllllllllllIIlIlIlllIlIIIlIll;
                this.handler(llllllllllllllIIlIlIlllIlIIIlIlI -> {
                    llllllllllllllIIlIlIlllIlIIIlIIl = llllllllllllllIIlIlIlllIlIIIlIlI.get((Type<Integer>)Type.VAR_INT, 0);
                    if (llllllllllllllIIlIlIlllIlIIIlIIl == 0) {
                        llllllllllllllIIlIlIlllIlIIIlIlI.user().get(BlockPlaceDestroyTracker.class).setMining(true);
                    }
                    else if (llllllllllllllIIlIlIlllIlIIIlIIl == 2) {
                        llllllllllllllIIlIlIlllIlIIIllII = llllllllllllllIIlIlIlllIlIIIlIlI.user().get(BlockPlaceDestroyTracker.class);
                        llllllllllllllIIlIlIlllIlIIIllII.setMining(false);
                        llllllllllllllIIlIlIlllIlIIIllII.setLastMining(System.currentTimeMillis() + 100L);
                        llllllllllllllIIlIlIlllIlIIIlIlI.user().get(Cooldown.class).setLastHit(0L);
                    }
                    else if (llllllllllllllIIlIlIlllIlIIIlIIl == 1) {
                        llllllllllllllIIlIlIlllIlIIIlIll = llllllllllllllIIlIlIlllIlIIIlIlI.user().get(BlockPlaceDestroyTracker.class);
                        llllllllllllllIIlIlIlllIlIIIlIll.setMining(false);
                        llllllllllllllIIlIlIlllIlIIIlIll.setLastMining(0L);
                        llllllllllllllIIlIlIlllIlIIIlIlI.user().get(Cooldown.class).hit();
                    }
                });
            }
        });
        llllllllllllllIllllIlIlIlllllIlI.registerServerbound(ServerboundPackets1_8.PLAYER_BLOCK_PLACEMENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                this.map(Type.BYTE, Type.VAR_INT);
                this.map(Type.ITEM, Type.NOTHING);
                this.create(Type.VAR_INT, 0);
                this.map(Type.BYTE, Type.UNSIGNED_BYTE);
                this.map(Type.BYTE, Type.UNSIGNED_BYTE);
                this.map(Type.BYTE, Type.UNSIGNED_BYTE);
                PacketWrapper lllllllllllllllllllllIIlllIlIlIl;
                this.handler(lllllllllllllllllllllIIlllIlIIll -> {
                    if (lllllllllllllllllllllIIlllIlIIll.get((Type<Integer>)Type.VAR_INT, 0) == -1) {
                        lllllllllllllllllllllIIlllIlIIll.cancel();
                        lllllllllllllllllllllIIlllIlIlIl = PacketWrapper.create(29, null, lllllllllllllllllllllIIlllIlIIll.user());
                        lllllllllllllllllllllIIlllIlIlIl.write(Type.VAR_INT, 0);
                        PacketUtil.sendToServer(lllllllllllllllllllllIIlllIlIlIl, Protocol1_8TO1_9.class, true, true);
                    }
                    return;
                });
                this.handler(lllllllllllllllllllllIIlllIllIIl -> {
                    if (lllllllllllllllllllllIIlllIllIIl.get((Type<Integer>)Type.VAR_INT, 0) != -1) {
                        lllllllllllllllllllllIIlllIllIIl.user().get(BlockPlaceDestroyTracker.class).place();
                    }
                });
            }
        });
        llllllllllllllIllllIlIlIlllllIlI.registerServerbound(ServerboundPackets1_8.HELD_ITEM_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(lllllllllllllIIIIllIIlIlllllIlll -> lllllllllllllIIIIllIIlIlllllIlll.user().get(Cooldown.class).hit());
            }
        });
        llllllllllllllIllllIlIlIlllllIlI.registerServerbound(ServerboundPackets1_8.ANIMATION, new PacketRemapper() {
            @Override
            public void registerMap() {
                final PacketWrapper lllllllllllllIIlIlIlIIllIIIIllIl;
                this.handler(lllllllllllllIIlIlIlIIllIIIIlIll -> {
                    lllllllllllllIIlIlIlIIllIIIIlIll.cancel();
                    lllllllllllllIIlIlIlIIllIIIIllIl = PacketWrapper.create(26, null, lllllllllllllIIlIlIlIIllIIIIlIll.user());
                    lllllllllllllIIlIlIlIIllIIIIllIl.write(Type.VAR_INT, 0);
                    Protocol1_8TO1_9.TIMER.schedule(new TimerTask() {
                        final /* synthetic */ PacketWrapper val$delayedPacket;
                        
                        @Override
                        public void run() {
                            PacketUtil.sendToServer(lllllllllllllIIlIlIlIIllIIIIllIl, Protocol1_8TO1_9.class);
                        }
                    }, 5L);
                    return;
                });
                this.handler(lllllllllllllIIlIlIlIIllIIIlIIll -> {
                    lllllllllllllIIlIlIlIIllIIIlIIll.user().get(BlockPlaceDestroyTracker.class).updateMining();
                    lllllllllllllIIlIlIlIIllIIIlIIll.user().get(Cooldown.class).hit();
                });
            }
        });
        llllllllllllllIllllIlIlIlllllIlI.registerServerbound(ServerboundPackets1_8.ENTITY_ACTION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                final int llllllllllllllIllIIlIIlIIlIlIllI;
                PlayerPosition llllllllllllllIllIIlIIlIIlIllIII;
                PacketWrapper llllllllllllllIllIIlIIlIIlIllIIl;
                this.handler(llllllllllllllIllIIlIIlIIlIlIlll -> {
                    llllllllllllllIllIIlIIlIIlIlIllI = llllllllllllllIllIIlIIlIIlIlIlll.get((Type<Integer>)Type.VAR_INT, 1);
                    if (llllllllllllllIllIIlIIlIIlIlIllI == 6) {
                        llllllllllllllIllIIlIIlIIlIlIlll.set(Type.VAR_INT, 1, 7);
                    }
                    else if (llllllllllllllIllIIlIIlIIlIlIllI == 0) {
                        llllllllllllllIllIIlIIlIIlIllIII = llllllllllllllIllIIlIIlIIlIlIlll.user().get(PlayerPosition.class);
                        if (!llllllllllllllIllIIlIIlIIlIllIII.isOnGround()) {
                            llllllllllllllIllIIlIIlIIlIllIIl = PacketWrapper.create(20, null, llllllllllllllIllIIlIIlIIlIlIlll.user());
                            llllllllllllllIllIIlIIlIIlIllIIl.write(Type.VAR_INT, (Integer)llllllllllllllIllIIlIIlIIlIlIlll.get((Type<T>)Type.VAR_INT, 0));
                            llllllllllllllIllIIlIIlIIlIllIIl.write(Type.VAR_INT, 8);
                            llllllllllllllIllIIlIIlIIlIllIIl.write(Type.VAR_INT, 0);
                            PacketUtil.sendToServer(llllllllllllllIllIIlIIlIIlIllIIl, Protocol1_8TO1_9.class, true, false);
                        }
                    }
                });
            }
        });
        llllllllllllllIllllIlIlIlllllIlI.registerServerbound(ServerboundPackets1_8.STEER_VEHICLE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.UNSIGNED_BYTE);
                final EntityTracker lllllllllllllIlIIlllllIlllIIlllI;
                final int lllllllllllllIlIIlllllIlllIIllIl;
                final int lllllllllllllIlIIlllllIlllIIllII;
                PacketWrapper lllllllllllllIlIIlllllIlllIlIIlI;
                float lllllllllllllIlIIlllllIlllIlIIIl;
                float lllllllllllllIlIIlllllIlllIlIIII;
                this.handler(lllllllllllllIlIIlllllIlllIIllll -> {
                    lllllllllllllIlIIlllllIlllIIlllI = lllllllllllllIlIIlllllIlllIIllll.user().get(EntityTracker.class);
                    lllllllllllllIlIIlllllIlllIIllIl = lllllllllllllIlIIlllllIlllIIlllI.getPlayerId();
                    lllllllllllllIlIIlllllIlllIIllII = lllllllllllllIlIIlllllIlllIIlllI.getVehicle(lllllllllllllIlIIlllllIlllIIllIl);
                    if (lllllllllllllIlIIlllllIlllIIllII != -1 && lllllllllllllIlIIlllllIlllIIlllI.getClientEntityTypes().get(lllllllllllllIlIIlllllIlllIIllII) == Entity1_10Types.EntityType.BOAT) {
                        lllllllllllllIlIIlllllIlllIlIIlI = PacketWrapper.create(17, null, lllllllllllllIlIIlllllIlllIIllll.user());
                        lllllllllllllIlIIlllllIlllIlIIIl = lllllllllllllIlIIlllllIlllIIllll.get((Type<Float>)Type.FLOAT, 0);
                        lllllllllllllIlIIlllllIlllIlIIII = lllllllllllllIlIIlllllIlllIIllll.get((Type<Float>)Type.FLOAT, 1);
                        lllllllllllllIlIIlllllIlllIlIIlI.write(Type.BOOLEAN, lllllllllllllIlIIlllllIlllIlIIII != 0.0f || lllllllllllllIlIIlllllIlllIlIIIl < 0.0f);
                        lllllllllllllIlIIlllllIlllIlIIlI.write(Type.BOOLEAN, lllllllllllllIlIIlllllIlllIlIIII != 0.0f || lllllllllllllIlIIlllllIlllIlIIIl > 0.0f);
                        PacketUtil.sendToServer(lllllllllllllIlIIlllllIlllIlIIlI, Protocol1_8TO1_9.class);
                    }
                });
            }
        });
        llllllllllllllIllllIlIlIlllllIlI.registerServerbound(ServerboundPackets1_8.UPDATE_SIGN, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                int lllllllllllllIllllIllIllIlIlllII;
                this.handler(lllllllllllllIllllIllIllIlIllIlI -> {
                    for (lllllllllllllIllllIllIllIlIlllII = 0; lllllllllllllIllllIllIllIlIlllII < 4; ++lllllllllllllIllllIllIllIlIlllII) {
                        lllllllllllllIllllIllIllIlIllIlI.write(Type.STRING, ChatUtil.jsonToLegacy(lllllllllllllIllllIllIllIlIllIlI.read(Type.COMPONENT)));
                    }
                });
            }
        });
        llllllllllllllIllllIlIlIlllllIlI.registerServerbound(ServerboundPackets1_8.TAB_COMPLETE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.handler(llllllllllllllIlIIIlIIIlllllIlIl -> llllllllllllllIlIIIlIIIlllllIlIl.write(Type.BOOLEAN, false));
                this.map(Type.OPTIONAL_POSITION);
            }
        });
        llllllllllllllIllllIlIlIlllllIlI.registerServerbound(ServerboundPackets1_8.CLIENT_SETTINGS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.map(Type.BYTE);
                this.map(Type.BYTE, Type.VAR_INT);
                this.map(Type.BOOLEAN);
                this.map(Type.UNSIGNED_BYTE);
                this.create(Type.VAR_INT, 1);
                final short llllllllllllllIlIIIIllIlIlIlIlll;
                final PacketWrapper llllllllllllllIlIIIIllIlIlIlIllI;
                final ArrayList<Metadata> llllllllllllllIlIIIIllIlIlIlIlIl;
                this.handler(llllllllllllllIlIIIIllIlIlIllIII -> {
                    llllllllllllllIlIIIIllIlIlIlIlll = llllllllllllllIlIIIIllIlIlIllIII.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                    llllllllllllllIlIIIIllIlIlIlIllI = PacketWrapper.create(28, null, llllllllllllllIlIIIIllIlIlIllIII.user());
                    llllllllllllllIlIIIIllIlIlIlIllI.write(Type.VAR_INT, llllllllllllllIlIIIIllIlIlIllIII.user().get(EntityTracker.class).getPlayerId());
                    llllllllllllllIlIIIIllIlIlIlIlIl = new ArrayList<Metadata>();
                    llllllllllllllIlIIIIllIlIlIlIlIl.add(new Metadata(10, MetaType1_8.Byte, (byte)llllllllllllllIlIIIIllIlIlIlIlll));
                    llllllllllllllIlIIIIllIlIlIlIllI.write(Types1_8.METADATA_LIST, llllllllllllllIlIIIIllIlIlIlIlIl);
                    PacketUtil.sendPacket(llllllllllllllIlIIIIllIlIlIlIllI, Protocol1_8TO1_9.class);
                });
            }
        });
        llllllllllllllIllllIlIlIlllllIlI.registerServerbound(ServerboundPackets1_8.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                final String llllllllllllllllIllllIIIIIIIlllI;
                Item llllllllllllllllIllllIIIIIIlIIIl;
                CompoundTag llllllllllllllllIllllIIIIIIlIIII;
                ListTag llllllllllllllllIllllIIIIIIlIIlI;
                int llllllllllllllllIllllIIIIIIlIIll;
                StringTag llllllllllllllllIllllIIIIIIlIlIl;
                String llllllllllllllllIllllIIIIIIlIlII;
                String llllllllllllllllIllllIIIIIIlIlII2;
                Type<String> string;
                String llllllllllllllllIllllIIIIIIIlllI2;
                final int n;
                final T t;
                this.handler(llllllllllllllllIllllIIIIIIIllll -> {
                    llllllllllllllllIllllIIIIIIIlllI = llllllllllllllllIllllIIIIIIIllll.get(Type.STRING, 0);
                    if (llllllllllllllllIllllIIIIIIIlllI.equalsIgnoreCase("MC|BEdit") || llllllllllllllllIllllIIIIIIIlllI.equalsIgnoreCase("MC|BSign")) {
                        llllllllllllllllIllllIIIIIIlIIIl = llllllllllllllllIllllIIIIIIIllll.passthrough(Type.ITEM);
                        llllllllllllllllIllllIIIIIIlIIIl.setIdentifier(386);
                        llllllllllllllllIllllIIIIIIlIIII = llllllllllllllllIllllIIIIIIlIIIl.tag();
                        if (llllllllllllllllIllllIIIIIIlIIII.contains("pages")) {
                            for (llllllllllllllllIllllIIIIIIlIIlI = llllllllllllllllIllllIIIIIIlIIII.get("pages"), llllllllllllllllIllllIIIIIIlIIll = 0; llllllllllllllllIllllIIIIIIlIIll < llllllllllllllllIllllIIIIIIlIIlI.size(); ++llllllllllllllllIllllIIIIIIlIIll) {
                                llllllllllllllllIllllIIIIIIlIlIl = llllllllllllllllIllllIIIIIIlIIlI.get(llllllllllllllllIllllIIIIIIlIIll);
                                llllllllllllllllIllllIIIIIIlIlII = llllllllllllllllIllllIIIIIIlIlIl.getValue();
                                llllllllllllllllIllllIIIIIIlIlII2 = ChatUtil.jsonToLegacy(llllllllllllllllIllllIIIIIIlIlII);
                                llllllllllllllllIllllIIIIIIlIlIl.setValue(llllllllllllllllIllllIIIIIIlIlII2);
                            }
                        }
                    }
                    else if (llllllllllllllllIllllIIIIIIIlllI.equalsIgnoreCase("MC|AdvCdm")) {
                        string = Type.STRING;
                        llllllllllllllllIllllIIIIIIIlllI2 = "MC|AdvCmd";
                        llllllllllllllllIllllIIIIIIIllll.set(string, n, (String)t);
                    }
                });
            }
        });
    }
}
