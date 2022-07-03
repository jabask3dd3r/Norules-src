package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.packets;

import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.*;
import com.viaversion.viaversion.protocols.protocol1_8.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types.*;
import de.gerrygames.viarewind.utils.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.metadata.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.items.*;
import de.gerrygames.viarewind.replacement.*;
import com.viaversion.viaversion.api.type.types.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.entityreplacements.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.protocol.*;
import java.util.*;

public class SpawnPackets
{
    public static void register(final Protocol1_7_6_10TO1_8 lllllllllllllIlIlIllllIlllllIlIl) {
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIlIlIllllIlllllIlIl).registerClientbound(ClientboundPackets1_8.SPAWN_PLAYER, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                final UUID lllllllllllllIIlllllllIllllIIlIl;
                final GameProfileStorage lllllllllllllIIlllllllIllllIIlII;
                final GameProfileStorage.GameProfile lllllllllllllIIlllllllIllllIIIll;
                Exception lllllllllllllIIlllllllIlllIlllIl;
                GameProfileStorage.Property lllllllllllllIIlllllllIllllIlIlI;
                int lllllllllllllIIlllllllIllllIlIII;
                PacketWrapper lllllllllllllIIlllllllIllllIIlll;
                short lllllllllllllIIlllllllIllllIlIIl;
                PacketWrapper lllllllllllllIIlllllllIllllIIlll2;
                final EntityTracker lllllllllllllIIlllllllIllllIIIlI;
                this.handler(lllllllllllllIIlllllllIllllIIllI -> {
                    lllllllllllllIIlllllllIllllIIlIl = lllllllllllllIIlllllllIllllIIllI.read(Type.UUID);
                    lllllllllllllIIlllllllIllllIIllI.write(Type.STRING, lllllllllllllIIlllllllIllllIIlIl.toString());
                    lllllllllllllIIlllllllIllllIIlII = lllllllllllllIIlllllllIllllIIllI.user().get(GameProfileStorage.class);
                    lllllllllllllIIlllllllIllllIIIll = lllllllllllllIIlllllllIllllIIlII.get(lllllllllllllIIlllllllIllllIIlIl);
                    if (lllllllllllllIIlllllllIllllIIIll == null) {
                        lllllllllllllIIlllllllIllllIIllI.write(Type.STRING, "");
                        lllllllllllllIIlllllllIllllIIllI.write(Type.VAR_INT, 0);
                    }
                    else {
                        lllllllllllllIIlllllllIllllIIllI.write(Type.STRING, (lllllllllllllIIlllllllIllllIIIll.name.length() > 16) ? lllllllllllllIIlllllllIllllIIIll.name.substring(0, 16) : lllllllllllllIIlllllllIllllIIIll.name);
                        lllllllllllllIIlllllllIllllIIllI.write(Type.VAR_INT, lllllllllllllIIlllllllIllllIIIll.properties.size());
                        lllllllllllllIIlllllllIlllIlllIl = (Exception)lllllllllllllIIlllllllIllllIIIll.properties.iterator();
                        while (((Iterator)lllllllllllllIIlllllllIlllIlllIl).hasNext()) {
                            lllllllllllllIIlllllllIllllIlIlI = ((Iterator<GameProfileStorage.Property>)lllllllllllllIIlllllllIlllIlllIl).next();
                            lllllllllllllIIlllllllIllllIIllI.write(Type.STRING, lllllllllllllIIlllllllIllllIlIlI.name);
                            lllllllllllllIIlllllllIllllIIllI.write(Type.STRING, lllllllllllllIIlllllllIllllIlIlI.value);
                            lllllllllllllIIlllllllIllllIIllI.write(Type.STRING, (lllllllllllllIIlllllllIllllIlIlI.signature == null) ? "" : lllllllllllllIIlllllllIllllIlIlI.signature);
                        }
                    }
                    if (lllllllllllllIIlllllllIllllIIIll != null && lllllllllllllIIlllllllIllllIIIll.gamemode == 3) {
                        lllllllllllllIIlllllllIllllIlIII = lllllllllllllIIlllllllIllllIIllI.get((Type<Integer>)Type.VAR_INT, 0);
                        lllllllllllllIIlllllllIllllIIlll = PacketWrapper.create(4, null, lllllllllllllIIlllllllIllllIIllI.user());
                        lllllllllllllIIlllllllIllllIIlll.write(Type.INT, lllllllllllllIIlllllllIllllIlIII);
                        lllllllllllllIIlllllllIllllIIlll.write(Type.SHORT, (Short)4);
                        lllllllllllllIIlllllllIllllIIlll.write(Types1_7_6_10.COMPRESSED_NBT_ITEM, lllllllllllllIIlllllllIllllIIIll.getSkull());
                        PacketUtil.sendPacket(lllllllllllllIIlllllllIllllIIlll, Protocol1_7_6_10TO1_8.class);
                        for (lllllllllllllIIlllllllIllllIlIIl = 0; lllllllllllllIIlllllllIllllIlIIl < 4; ++lllllllllllllIIlllllllIllllIlIIl) {
                            lllllllllllllIIlllllllIllllIIlll2 = PacketWrapper.create(4, null, lllllllllllllIIlllllllIllllIIllI.user());
                            lllllllllllllIIlllllllIllllIIlll2.write(Type.INT, lllllllllllllIIlllllllIllllIlIII);
                            lllllllllllllIIlllllllIllllIIlll2.write(Type.SHORT, lllllllllllllIIlllllllIllllIlIIl);
                            lllllllllllllIIlllllllIllllIIlll2.write(Types1_7_6_10.COMPRESSED_NBT_ITEM, null);
                            PacketUtil.sendPacket(lllllllllllllIIlllllllIllllIIlll2, Protocol1_7_6_10TO1_8.class);
                        }
                    }
                    lllllllllllllIIlllllllIllllIIIlI = lllllllllllllIIlllllllIllllIIllI.user().get(EntityTracker.class);
                    lllllllllllllIIlllllllIllllIIIlI.addPlayer(lllllllllllllIIlllllllIllllIIllI.get((Type<Integer>)Type.VAR_INT, 0), lllllllllllllIIlllllllIllllIIlIl);
                    return;
                });
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.SHORT);
                this.map(Types1_8.METADATA_LIST, Types1_7_6_10.METADATA_LIST);
                final List<Metadata> lllllllllllllIIlllllllIlllllIlII;
                this.handler(lllllllllllllIIlllllllIlllllIIll -> {
                    lllllllllllllIIlllllllIlllllIlII = lllllllllllllIIlllllllIlllllIIll.get(Types1_7_6_10.METADATA_LIST, 0);
                    MetadataRewriter.transform(Entity1_10Types.EntityType.PLAYER, lllllllllllllIIlllllllIlllllIlII);
                    return;
                });
                final int lllllllllllllIIlllllllIlllllllII;
                final EntityTracker lllllllllllllIIlllllllIllllllIll;
                this.handler(lllllllllllllIIlllllllIllllllIlI -> {
                    lllllllllllllIIlllllllIlllllllII = lllllllllllllIIlllllllIllllllIlI.get((Type<Integer>)Type.VAR_INT, 0);
                    lllllllllllllIIlllllllIllllllIll = lllllllllllllIIlllllllIllllllIlI.user().get(EntityTracker.class);
                    lllllllllllllIIlllllllIllllllIll.getClientEntityTypes().put(lllllllllllllIIlllllllIlllllllII, Entity1_10Types.EntityType.PLAYER);
                    lllllllllllllIIlllllllIllllllIll.sendMetadataBuffer(lllllllllllllIIlllllllIlllllllII);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIlIlIllllIlllllIlIl).registerClientbound(ClientboundPackets1_8.SPAWN_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.BYTE);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.INT);
                final int llllllllllllllIIIlIIllllIllIIllI;
                final byte llllllllllllllIIIlIIllllIllIIlIl;
                int llllllllllllllIIIlIIllllIllIIlII;
                int llllllllllllllIIIlIIllllIllIIIll;
                int llllllllllllllIIIlIIllllIllIIIlI;
                final byte llllllllllllllIIIlIIllllIllIIIIl;
                byte llllllllllllllIIIlIIllllIllIIIII;
                EntityTracker llllllllllllllIIIlIIllllIllIllII;
                ArmorStandReplacement llllllllllllllIIIlIIllllIllIlIll;
                final EntityTracker llllllllllllllIIIlIIllllIlIlllll;
                final Entity1_10Types.EntityType llllllllllllllIIIlIIllllIlIllllI;
                int llllllllllllllIIIlIIllllIlIlllIl;
                int llllllllllllllIIIlIIllllIllIlIlI;
                int llllllllllllllIIIlIIllllIllIlIIl;
                Replacement llllllllllllllIIIlIIllllIllIlIII;
                IntType int1;
                final int n;
                final int n2;
                this.handler(llllllllllllllIIIlIIllllIlIlllII -> {
                    llllllllllllllIIIlIIllllIllIIllI = llllllllllllllIIIlIIllllIlIlllII.get((Type<Integer>)Type.VAR_INT, 0);
                    llllllllllllllIIIlIIllllIllIIlIl = llllllllllllllIIIlIIllllIlIlllII.get((Type<Byte>)Type.BYTE, 0);
                    llllllllllllllIIIlIIllllIllIIlII = llllllllllllllIIIlIIllllIlIlllII.get((Type<Integer>)Type.INT, 0);
                    llllllllllllllIIIlIIllllIllIIIll = llllllllllllllIIIlIIllllIlIlllII.get((Type<Integer>)Type.INT, 1);
                    llllllllllllllIIIlIIllllIllIIIlI = llllllllllllllIIIlIIllllIlIlllII.get((Type<Integer>)Type.INT, 2);
                    llllllllllllllIIIlIIllllIllIIIIl = llllllllllllllIIIlIIllllIlIlllII.get((Type<Byte>)Type.BYTE, 1);
                    llllllllllllllIIIlIIllllIllIIIII = llllllllllllllIIIlIIllllIlIlllII.get((Type<Byte>)Type.BYTE, 2);
                    if (llllllllllllllIIIlIIllllIllIIlIl == 71) {
                        switch (llllllllllllllIIIlIIllllIllIIIII) {
                            case Byte.MIN_VALUE: {
                                llllllllllllllIIIlIIllllIllIIIlI += 32;
                                llllllllllllllIIIlIIllllIllIIIII = 0;
                                break;
                            }
                            case -64: {
                                llllllllllllllIIIlIIllllIllIIlII -= 32;
                                llllllllllllllIIIlIIllllIllIIIII = -64;
                                break;
                            }
                            case 0: {
                                llllllllllllllIIIlIIllllIllIIIlI -= 32;
                                llllllllllllllIIIlIIllllIllIIIII = -128;
                                break;
                            }
                            case 64: {
                                llllllllllllllIIIlIIllllIllIIlII += 32;
                                llllllllllllllIIIlIIllllIllIIIII = 64;
                                break;
                            }
                        }
                    }
                    else if (llllllllllllllIIIlIIllllIllIIlIl == 78) {
                        llllllllllllllIIIlIIllllIlIlllII.cancel();
                        llllllllllllllIIIlIIllllIllIllII = llllllllllllllIIIlIIllllIlIlllII.user().get(EntityTracker.class);
                        llllllllllllllIIIlIIllllIllIlIll = new ArmorStandReplacement(llllllllllllllIIIlIIllllIllIIllI, llllllllllllllIIIlIIllllIlIlllII.user());
                        llllllllllllllIIIlIIllllIllIlIll.setLocation(llllllllllllllIIIlIIllllIllIIlII / 32.0, llllllllllllllIIIlIIllllIllIIIll / 32.0, llllllllllllllIIIlIIllllIllIIIlI / 32.0);
                        llllllllllllllIIIlIIllllIllIlIll.setYawPitch(llllllllllllllIIIlIIllllIllIIIII * 360.0f / 256.0f, llllllllllllllIIIlIIllllIllIIIIl * 360.0f / 256.0f);
                        llllllllllllllIIIlIIllllIllIlIll.setHeadYaw(llllllllllllllIIIlIIllllIllIIIII * 360.0f / 256.0f);
                        llllllllllllllIIIlIIllllIllIllII.addEntityReplacement(llllllllllllllIIIlIIllllIllIlIll);
                    }
                    else if (llllllllllllllIIIlIIllllIllIIlIl == 10) {
                        llllllllllllllIIIlIIllllIllIIIll += 12;
                    }
                    llllllllllllllIIIlIIllllIlIlllII.set(Type.BYTE, 0, llllllllllllllIIIlIIllllIllIIlIl);
                    llllllllllllllIIIlIIllllIlIlllII.set(Type.INT, 0, llllllllllllllIIIlIIllllIllIIlII);
                    llllllllllllllIIIlIIllllIlIlllII.set(Type.INT, 1, llllllllllllllIIIlIIllllIllIIIll);
                    llllllllllllllIIIlIIllllIlIlllII.set(Type.INT, 2, llllllllllllllIIIlIIllllIllIIIlI);
                    llllllllllllllIIIlIIllllIlIlllII.set(Type.BYTE, 1, llllllllllllllIIIlIIllllIllIIIIl);
                    llllllllllllllIIIlIIllllIlIlllII.set(Type.BYTE, 2, llllllllllllllIIIlIIllllIllIIIII);
                    llllllllllllllIIIlIIllllIlIlllll = llllllllllllllIIIlIIllllIlIlllII.user().get(EntityTracker.class);
                    llllllllllllllIIIlIIllllIlIllllI = Entity1_10Types.getTypeFromId(llllllllllllllIIIlIIllllIllIIlIl, true);
                    llllllllllllllIIIlIIllllIlIlllll.getClientEntityTypes().put(llllllllllllllIIIlIIllllIllIIllI, llllllllllllllIIIlIIllllIlIllllI);
                    llllllllllllllIIIlIIllllIlIlllll.sendMetadataBuffer(llllllllllllllIIIlIIllllIllIIllI);
                    llllllllllllllIIIlIIllllIlIlllIl = llllllllllllllIIIlIIllllIlIlllII.get((Type<Integer>)Type.INT, 3);
                    if (llllllllllllllIIIlIIllllIlIllllI != null && llllllllllllllIIIlIIllllIlIllllI.isOrHasParent(Entity1_10Types.EntityType.FALLING_BLOCK)) {
                        llllllllllllllIIIlIIllllIllIlIlI = (llllllllllllllIIIlIIllllIlIlllIl & 0xFFF);
                        llllllllllllllIIIlIIllllIllIlIIl = (llllllllllllllIIIlIIllllIlIlllIl >> 12 & 0xF);
                        llllllllllllllIIIlIIllllIllIlIII = ReplacementRegistry1_7_6_10to1_8.getReplacement(llllllllllllllIIIlIIllllIllIlIlI, llllllllllllllIIIlIIllllIllIlIIl);
                        if (llllllllllllllIIIlIIllllIllIlIII != null) {
                            llllllllllllllIIIlIIllllIllIlIlI = llllllllllllllIIIlIIllllIllIlIII.getId();
                            llllllllllllllIIIlIIllllIllIlIIl = llllllllllllllIIIlIIllllIllIlIII.replaceData(llllllllllllllIIIlIIllllIllIlIIl);
                        }
                        int1 = Type.INT;
                        llllllllllllllIIIlIIllllIlIlllIl = (llllllllllllllIIIlIIllllIllIlIlI | llllllllllllllIIIlIIllllIllIlIIl << 16);
                        llllllllllllllIIIlIIllllIlIlllII.set(int1, n, n2);
                    }
                    if (llllllllllllllIIIlIIllllIlIlllIl > 0) {
                        llllllllllllllIIIlIIllllIlIlllII.passthrough((Type<Object>)Type.SHORT);
                        llllllllllllllIIIlIIllllIlIlllII.passthrough((Type<Object>)Type.SHORT);
                        llllllllllllllIIIlIIllllIlIlllII.passthrough((Type<Object>)Type.SHORT);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIlIlIllllIlllllIlIl).registerClientbound(ClientboundPackets1_8.SPAWN_MOB, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Types1_8.METADATA_LIST, Types1_7_6_10.METADATA_LIST);
                final int lllllllllllllIlIIIlIIIIlIlIlllIl;
                final int lllllllllllllIlIIIlIIIIlIlIlllII;
                final int lllllllllllllIlIIIlIIIIlIlIllIll;
                final int lllllllllllllIlIIIlIIIIlIlIllIlI;
                final int lllllllllllllIlIIIlIIIIlIlIllIIl;
                final byte lllllllllllllIlIIIlIIIIlIlIllIII;
                final byte lllllllllllllIlIIIlIIIIlIlIlIlll;
                final byte lllllllllllllIlIIIlIIIIlIlIlIllI;
                EntityTracker lllllllllllllIlIIIlIIIIlIllIIlII;
                ArmorStandReplacement lllllllllllllIlIIIlIIIIlIllIIIll;
                EntityTracker lllllllllllllIlIIIlIIIIlIllIIIlI;
                GuardianReplacement lllllllllllllIlIIIlIIIIlIllIIIIl;
                EntityTracker lllllllllllllIlIIIlIIIIlIllIIIII;
                EndermiteReplacement lllllllllllllIlIIIlIIIIlIlIlllll;
                this.handler(lllllllllllllIlIIIlIIIIlIlIlIlIl -> {
                    lllllllllllllIlIIIlIIIIlIlIlllIl = lllllllllllllIlIIIlIIIIlIlIlIlIl.get((Type<Integer>)Type.VAR_INT, 0);
                    lllllllllllllIlIIIlIIIIlIlIlllII = lllllllllllllIlIIIlIIIIlIlIlIlIl.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                    lllllllllllllIlIIIlIIIIlIlIllIll = lllllllllllllIlIIIlIIIIlIlIlIlIl.get((Type<Integer>)Type.INT, 0);
                    lllllllllllllIlIIIlIIIIlIlIllIlI = lllllllllllllIlIIIlIIIIlIlIlIlIl.get((Type<Integer>)Type.INT, 1);
                    lllllllllllllIlIIIlIIIIlIlIllIIl = lllllllllllllIlIIIlIIIIlIlIlIlIl.get((Type<Integer>)Type.INT, 2);
                    lllllllllllllIlIIIlIIIIlIlIllIII = lllllllllllllIlIIIlIIIIlIlIlIlIl.get((Type<Byte>)Type.BYTE, 1);
                    lllllllllllllIlIIIlIIIIlIlIlIlll = lllllllllllllIlIIIlIIIIlIlIlIlIl.get((Type<Byte>)Type.BYTE, 0);
                    lllllllllllllIlIIIlIIIIlIlIlIllI = lllllllllllllIlIIIlIIIIlIlIlIlIl.get((Type<Byte>)Type.BYTE, 2);
                    if (lllllllllllllIlIIIlIIIIlIlIlllII == 30) {
                        lllllllllllllIlIIIlIIIIlIlIlIlIl.cancel();
                        lllllllllllllIlIIIlIIIIlIllIIlII = lllllllllllllIlIIIlIIIIlIlIlIlIl.user().get(EntityTracker.class);
                        lllllllllllllIlIIIlIIIIlIllIIIll = new ArmorStandReplacement(lllllllllllllIlIIIlIIIIlIlIlllIl, lllllllllllllIlIIIlIIIIlIlIlIlIl.user());
                        lllllllllllllIlIIIlIIIIlIllIIIll.setLocation(lllllllllllllIlIIIlIIIIlIlIllIll / 32.0, lllllllllllllIlIIIlIIIIlIlIllIlI / 32.0, lllllllllllllIlIIIlIIIIlIlIllIIl / 32.0);
                        lllllllllllllIlIIIlIIIIlIllIIIll.setYawPitch(lllllllllllllIlIIIlIIIIlIlIlIlll * 360.0f / 256.0f, lllllllllllllIlIIIlIIIIlIlIllIII * 360.0f / 256.0f);
                        lllllllllllllIlIIIlIIIIlIllIIIll.setHeadYaw(lllllllllllllIlIIIlIIIIlIlIlIllI * 360.0f / 256.0f);
                        lllllllllllllIlIIIlIIIIlIllIIlII.addEntityReplacement(lllllllllllllIlIIIlIIIIlIllIIIll);
                    }
                    else if (lllllllllllllIlIIIlIIIIlIlIlllII == 68) {
                        lllllllllllllIlIIIlIIIIlIlIlIlIl.cancel();
                        lllllllllllllIlIIIlIIIIlIllIIIlI = lllllllllllllIlIIIlIIIIlIlIlIlIl.user().get(EntityTracker.class);
                        lllllllllllllIlIIIlIIIIlIllIIIIl = new GuardianReplacement(lllllllllllllIlIIIlIIIIlIlIlllIl, lllllllllllllIlIIIlIIIIlIlIlIlIl.user());
                        lllllllllllllIlIIIlIIIIlIllIIIIl.setLocation(lllllllllllllIlIIIlIIIIlIlIllIll / 32.0, lllllllllllllIlIIIlIIIIlIlIllIlI / 32.0, lllllllllllllIlIIIlIIIIlIlIllIIl / 32.0);
                        lllllllllllllIlIIIlIIIIlIllIIIIl.setYawPitch(lllllllllllllIlIIIlIIIIlIlIlIlll * 360.0f / 256.0f, lllllllllllllIlIIIlIIIIlIlIllIII * 360.0f / 256.0f);
                        lllllllllllllIlIIIlIIIIlIllIIIIl.setHeadYaw(lllllllllllllIlIIIlIIIIlIlIlIllI * 360.0f / 256.0f);
                        lllllllllllllIlIIIlIIIIlIllIIIlI.addEntityReplacement(lllllllllllllIlIIIlIIIIlIllIIIIl);
                    }
                    else if (lllllllllllllIlIIIlIIIIlIlIlllII == 67) {
                        lllllllllllllIlIIIlIIIIlIlIlIlIl.cancel();
                        lllllllllllllIlIIIlIIIIlIllIIIII = lllllllllllllIlIIIlIIIIlIlIlIlIl.user().get(EntityTracker.class);
                        lllllllllllllIlIIIlIIIIlIlIlllll = new EndermiteReplacement(lllllllllllllIlIIIlIIIIlIlIlllIl, lllllllllllllIlIIIlIIIIlIlIlIlIl.user());
                        lllllllllllllIlIIIlIIIIlIlIlllll.setLocation(lllllllllllllIlIIIlIIIIlIlIllIll / 32.0, lllllllllllllIlIIIlIIIIlIlIllIlI / 32.0, lllllllllllllIlIIIlIIIIlIlIllIIl / 32.0);
                        lllllllllllllIlIIIlIIIIlIlIlllll.setYawPitch(lllllllllllllIlIIIlIIIIlIlIlIlll * 360.0f / 256.0f, lllllllllllllIlIIIlIIIIlIlIllIII * 360.0f / 256.0f);
                        lllllllllllllIlIIIlIIIIlIlIlllll.setHeadYaw(lllllllllllllIlIIIlIIIIlIlIlIllI * 360.0f / 256.0f);
                        lllllllllllllIlIIIlIIIIlIllIIIII.addEntityReplacement(lllllllllllllIlIIIlIIIIlIlIlllll);
                    }
                    else if (lllllllllllllIlIIIlIIIIlIlIlllII == 101 || lllllllllllllIlIIIlIIIIlIlIlllII == 255 || lllllllllllllIlIIIlIIIIlIlIlllII == -1) {
                        lllllllllllllIlIIIlIIIIlIlIlIlIl.cancel();
                    }
                    return;
                });
                final int lllllllllllllIlIIIlIIIIlIlllIllI;
                final int lllllllllllllIlIIIlIIIIlIlllIlIl;
                final EntityTracker lllllllllllllIlIIIlIIIIlIlllIlII;
                this.handler(lllllllllllllIlIIIlIIIIlIlllIlll -> {
                    lllllllllllllIlIIIlIIIIlIlllIllI = lllllllllllllIlIIIlIIIIlIlllIlll.get((Type<Integer>)Type.VAR_INT, 0);
                    lllllllllllllIlIIIlIIIIlIlllIlIl = lllllllllllllIlIIIlIIIIlIlllIlll.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                    lllllllllllllIlIIIlIIIIlIlllIlII = lllllllllllllIlIIIlIIIIlIlllIlll.user().get(EntityTracker.class);
                    lllllllllllllIlIIIlIIIIlIlllIlII.getClientEntityTypes().put(lllllllllllllIlIIIlIIIIlIlllIllI, Entity1_10Types.getTypeFromId(lllllllllllllIlIIIlIIIIlIlllIlIl, false));
                    lllllllllllllIlIIIlIIIIlIlllIlII.sendMetadataBuffer(lllllllllllllIlIIIlIIIIlIlllIllI);
                    return;
                });
                final List<Metadata> lllllllllllllIlIIIlIIIIllIIIIIlI;
                final int lllllllllllllIlIIIlIIIIllIIIIIIl;
                final EntityTracker lllllllllllllIlIIIlIIIIllIIIIIII;
                this.handler(lllllllllllllIlIIIlIIIIlIlllllll -> {
                    lllllllllllllIlIIIlIIIIllIIIIIlI = lllllllllllllIlIIIlIIIIlIlllllll.get(Types1_7_6_10.METADATA_LIST, 0);
                    lllllllllllllIlIIIlIIIIllIIIIIIl = lllllllllllllIlIIIlIIIIlIlllllll.get((Type<Integer>)Type.VAR_INT, 0);
                    lllllllllllllIlIIIlIIIIllIIIIIII = lllllllllllllIlIIIlIIIIlIlllllll.user().get(EntityTracker.class);
                    if (lllllllllllllIlIIIlIIIIllIIIIIII.getEntityReplacement(lllllllllllllIlIIIlIIIIllIIIIIIl) != null) {
                        lllllllllllllIlIIIlIIIIllIIIIIII.getEntityReplacement(lllllllllllllIlIIIlIIIIllIIIIIIl).updateMetadata(lllllllllllllIlIIIlIIIIllIIIIIlI);
                    }
                    else if (lllllllllllllIlIIIlIIIIllIIIIIII.getClientEntityTypes().containsKey(lllllllllllllIlIIIlIIIIllIIIIIIl)) {
                        MetadataRewriter.transform(lllllllllllllIlIIIlIIIIllIIIIIII.getClientEntityTypes().get(lllllllllllllIlIIIlIIIIllIIIIIIl), lllllllllllllIlIIIlIIIIllIIIIIlI);
                    }
                    else {
                        lllllllllllllIlIIIlIIIIlIlllllll.cancel();
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIlIlIllllIlllllIlIl).registerClientbound(ClientboundPackets1_8.SPAWN_PAINTING, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.STRING);
                final Position llllllllllllIllllllIlIllllIIIIII;
                this.handler(llllllllllllIllllllIlIllllIIIIIl -> {
                    llllllllllllIllllllIlIllllIIIIII = llllllllllllIllllllIlIllllIIIIIl.read(Type.POSITION);
                    llllllllllllIllllllIlIllllIIIIIl.write(Type.INT, llllllllllllIllllllIlIllllIIIIII.getX());
                    llllllllllllIllllllIlIllllIIIIIl.write(Type.INT, llllllllllllIllllllIlIllllIIIIII.getY());
                    llllllllllllIllllllIlIllllIIIIIl.write(Type.INT, llllllllllllIllllllIlIllllIIIIII.getZ());
                    return;
                });
                this.map(Type.UNSIGNED_BYTE, Type.INT);
                final int llllllllllllIllllllIlIllllIIlIII;
                final EntityTracker llllllllllllIllllllIlIllllIIIlll;
                this.handler(llllllllllllIllllllIlIllllIIIllI -> {
                    llllllllllllIllllllIlIllllIIlIII = llllllllllllIllllllIlIllllIIIllI.get((Type<Integer>)Type.VAR_INT, 0);
                    llllllllllllIllllllIlIllllIIIlll = llllllllllllIllllllIlIllllIIIllI.user().get(EntityTracker.class);
                    llllllllllllIllllllIlIllllIIIlll.getClientEntityTypes().put(llllllllllllIllllllIlIllllIIlIII, Entity1_10Types.EntityType.PAINTING);
                    llllllllllllIllllllIlIllllIIIlll.sendMetadataBuffer(llllllllllllIllllllIlIllllIIlIII);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIlIlIllllIlllllIlIl).registerClientbound(ClientboundPackets1_8.SPAWN_EXPERIENCE_ORB, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.SHORT);
                final int lllllllllllllIIlllIIlllIIIllIIlI;
                final EntityTracker lllllllllllllIIlllIIlllIIIllIIIl;
                this.handler(lllllllllllllIIlllIIlllIIIllIIll -> {
                    lllllllllllllIIlllIIlllIIIllIIlI = lllllllllllllIIlllIIlllIIIllIIll.get((Type<Integer>)Type.VAR_INT, 0);
                    lllllllllllllIIlllIIlllIIIllIIIl = lllllllllllllIIlllIIlllIIIllIIll.user().get(EntityTracker.class);
                    lllllllllllllIIlllIIlllIIIllIIIl.getClientEntityTypes().put(lllllllllllllIIlllIIlllIIIllIIlI, Entity1_10Types.EntityType.EXPERIENCE_ORB);
                    lllllllllllllIIlllIIlllIIIllIIIl.sendMetadataBuffer(lllllllllllllIIlllIIlllIIIllIIlI);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIlIlIllllIlllllIlIl).registerClientbound(ClientboundPackets1_8.SPAWN_GLOBAL_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.BYTE);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.INT);
                final int llllllllllllllIIIIIllIIlIIllIIII;
                final EntityTracker llllllllllllllIIIIIllIIlIIlIllll;
                this.handler(llllllllllllllIIIIIllIIlIIlIlllI -> {
                    llllllllllllllIIIIIllIIlIIllIIII = llllllllllllllIIIIIllIIlIIlIlllI.get((Type<Integer>)Type.VAR_INT, 0);
                    llllllllllllllIIIIIllIIlIIlIllll = llllllllllllllIIIIIllIIlIIlIlllI.user().get(EntityTracker.class);
                    llllllllllllllIIIIIllIIlIIlIllll.getClientEntityTypes().put(llllllllllllllIIIIIllIIlIIllIIII, Entity1_10Types.EntityType.LIGHTNING);
                    llllllllllllllIIIIIllIIlIIlIllll.sendMetadataBuffer(llllllllllllllIIIIIllIIlIIllIIII);
                });
            }
        });
    }
}
