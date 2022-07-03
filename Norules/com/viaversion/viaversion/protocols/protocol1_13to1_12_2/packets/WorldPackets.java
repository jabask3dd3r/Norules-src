package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.packets;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.storage.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocols.protocol1_12_1to1_12.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.providers.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.protocols.protocol1_9_1_2to1_9_3_4.types.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.types.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.data.*;
import com.viaversion.viaversion.api.type.types.*;
import java.util.*;

public class WorldPackets
{
    private static final /* synthetic */ IntSet VALID_BIOMES;
    
    private static int checkStorage(final UserConnection llllllllllllllIlIIIlIlIlIIlIIIlI, final Position llllllllllllllIlIIIlIlIlIIIlllIl, final int llllllllllllllIlIIIlIlIlIIIlllII) {
        final BlockStorage llllllllllllllIlIIIlIlIlIIIlllll = llllllllllllllIlIIIlIlIlIIlIIIlI.get(BlockStorage.class);
        if (llllllllllllllIlIIIlIlIlIIIlllll.contains(llllllllllllllIlIIIlIlIlIIIlllIl)) {
            final BlockStorage.ReplacementData llllllllllllllIlIIIlIlIlIIlIIIll = llllllllllllllIlIIIlIlIlIIIlllll.get(llllllllllllllIlIIIlIlIlIIIlllIl);
            if (llllllllllllllIlIIIlIlIlIIlIIIll.getOriginal() == llllllllllllllIlIIIlIlIlIIIlllII) {
                if (llllllllllllllIlIIIlIlIlIIlIIIll.getReplacement() != -1) {
                    return llllllllllllllIlIIIlIlIlIIlIIIll.getReplacement();
                }
            }
            else {
                llllllllllllllIlIIIlIlIlIIIlllll.remove(llllllllllllllIlIIIlIlIlIIIlllIl);
                if (llllllllllllllIlIIIlIlIlIIIlllll.isWelcome(llllllllllllllIlIIIlIlIlIIIlllII)) {
                    llllllllllllllIlIIIlIlIlIIIlllll.store(llllllllllllllIlIIIlIlIlIIIlllIl, llllllllllllllIlIIIlIlIlIIIlllII);
                }
            }
        }
        else if (llllllllllllllIlIIIlIlIlIIIlllll.isWelcome(llllllllllllllIlIIIlIlIlIIIlllII)) {
            llllllllllllllIlIIIlIlIlIIIlllll.store(llllllllllllllIlIIIlIlIlIIIlllIl, llllllllllllllIlIIIlIlIlIIIlllII);
        }
        return llllllllllllllIlIIIlIlIlIIIlllII;
    }
    
    public static int toNewId(int llllllllllllllIlIIIlIlIlIIlIlIlI) {
        if (llllllllllllllIlIIIlIlIlIIlIlIlI < 0) {
            llllllllllllllIlIIIlIlIlIIlIlIlI = 0;
        }
        int llllllllllllllIlIIIlIlIlIIlIlIll = Protocol1_13To1_12_2.MAPPINGS.getBlockMappings().getNewId(llllllllllllllIlIIIlIlIlIIlIlIlI);
        if (llllllllllllllIlIIIlIlIlIIlIlIll != -1) {
            return llllllllllllllIlIIIlIlIlIIlIlIll;
        }
        llllllllllllllIlIIIlIlIlIIlIlIll = Protocol1_13To1_12_2.MAPPINGS.getBlockMappings().getNewId(llllllllllllllIlIIIlIlIlIIlIlIlI & 0xFFFFFFF0);
        if (llllllllllllllIlIIIlIlIlIIlIlIll != -1) {
            if (!Via.getConfig().isSuppressConversionWarnings() || Via.getManager().isDebug()) {
                Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Missing block ").append(llllllllllllllIlIIIlIlIlIIlIlIlI)));
            }
            return llllllllllllllIlIIIlIlIlIIlIlIll;
        }
        if (!Via.getConfig().isSuppressConversionWarnings() || Via.getManager().isDebug()) {
            Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Missing block completely ").append(llllllllllllllIlIIIlIlIlIIlIlIlI)));
        }
        return 1;
    }
    
    static {
        VALID_BIOMES = new IntOpenHashSet(70, 1.0f);
        for (int llllllllllllllIlIIIlIlIlIIIIllll = 0; llllllllllllllIlIIIlIlIlIIIIllll < 50; ++llllllllllllllIlIIIlIlIlIIIIllll) {
            WorldPackets.VALID_BIOMES.add(llllllllllllllIlIIIlIlIlIIIIllll);
        }
        WorldPackets.VALID_BIOMES.add(127);
        for (int llllllllllllllIlIIIlIlIlIIIIlllI = 129; llllllllllllllIlIIIlIlIlIIIIlllI <= 134; ++llllllllllllllIlIIIlIlIlIIIIlllI) {
            WorldPackets.VALID_BIOMES.add(llllllllllllllIlIIIlIlIlIIIIlllI);
        }
        WorldPackets.VALID_BIOMES.add(140);
        WorldPackets.VALID_BIOMES.add(149);
        WorldPackets.VALID_BIOMES.add(151);
        for (int llllllllllllllIlIIIlIlIlIIIIllIl = 155; llllllllllllllIlIIIlIlIlIIIIllIl <= 158; ++llllllllllllllIlIIIlIlIlIIIIllIl) {
            WorldPackets.VALID_BIOMES.add(llllllllllllllIlIIIlIlIlIIIIllIl);
        }
        for (int llllllllllllllIlIIIlIlIlIIIIllII = 160; llllllllllllllIlIIIlIlIlIIIIllII <= 167; ++llllllllllllllIlIIIlIlIlIIIIllII) {
            WorldPackets.VALID_BIOMES.add(llllllllllllllIlIIIlIlIlIIIIllII);
        }
    }
    
    public static void register(final Protocol llllllllllllllIlIIIlIlIlIIllIIII) {
        llllllllllllllIlIIIlIlIlIIllIIII.registerClientbound(ClientboundPackets1_12_1.SPAWN_PAINTING, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllllllllIIlIlIlIIll) throws Exception {
                        final PaintingProvider lllllllllllllllllllllIIlIlIlIIlI = Via.getManager().getProviders().get(PaintingProvider.class);
                        final String lllllllllllllllllllllIIlIlIlIIIl = lllllllllllllllllllllIIlIlIlIIll.read(Type.STRING);
                        final Optional<Integer> lllllllllllllllllllllIIlIlIlIIII = lllllllllllllllllllllIIlIlIlIIlI.getIntByIdentifier(lllllllllllllllllllllIIlIlIlIIIl);
                        if (!lllllllllllllllllllllIIlIlIlIIII.isPresent() && (!Via.getConfig().isSuppressConversionWarnings() || Via.getManager().isDebug())) {
                            Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Could not find painting motive: ").append(lllllllllllllllllllllIIlIlIlIIIl).append(" falling back to default (0)")));
                        }
                        lllllllllllllllllllllIIlIlIlIIll.write(Type.VAR_INT, lllllllllllllllllllllIIlIlIlIIII.orElse(0));
                    }
                });
            }
        });
        llllllllllllllIlIIIlIlIlIIllIIII.registerClientbound(ClientboundPackets1_12_1.BLOCK_ENTITY_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.NBT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIlIIIIIIlllllIlIII) throws Exception {
                        final Position llllllllllllllIlIIIIIIlllllIllIl = llllllllllllllIlIIIIIIlllllIlIII.get(Type.POSITION, 0);
                        final short llllllllllllllIlIIIIIIlllllIllII = llllllllllllllIlIIIIIIlllllIlIII.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                        final CompoundTag llllllllllllllIlIIIIIIlllllIlIll = llllllllllllllIlIIIIIIlllllIlIII.get(Type.NBT, 0);
                        final BlockEntityProvider llllllllllllllIlIIIIIIlllllIlIlI = Via.getManager().getProviders().get(BlockEntityProvider.class);
                        final int llllllllllllllIlIIIIIIlllllIlIIl = llllllllllllllIlIIIIIIlllllIlIlI.transform(llllllllllllllIlIIIIIIlllllIlIII.user(), llllllllllllllIlIIIIIIlllllIllIl, llllllllllllllIlIIIIIIlllllIlIll, true);
                        if (llllllllllllllIlIIIIIIlllllIlIIl != -1) {
                            final BlockStorage llllllllllllllIlIIIIIIllllllIIIl = llllllllllllllIlIIIIIIlllllIlIII.user().get(BlockStorage.class);
                            final BlockStorage.ReplacementData llllllllllllllIlIIIIIIllllllIIII = llllllllllllllIlIIIIIIllllllIIIl.get(llllllllllllllIlIIIIIIlllllIllIl);
                            if (llllllllllllllIlIIIIIIllllllIIII != null) {
                                llllllllllllllIlIIIIIIllllllIIII.setReplacement(llllllllllllllIlIIIIIIlllllIlIIl);
                            }
                        }
                        if (llllllllllllllIlIIIIIIlllllIllII == 5) {
                            llllllllllllllIlIIIIIIlllllIlIII.cancel();
                        }
                    }
                });
            }
        });
        llllllllllllllIlIIIlIlIlIIllIIII.registerClientbound(ClientboundPackets1_12_1.BLOCK_ACTION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIlIllIIIlllIIlllIl) throws Exception {
                        final Position llllllllllllllIlIllIIIlllIlIIIIl = llllllllllllllIlIllIIIlllIIlllIl.get(Type.POSITION, 0);
                        final short llllllllllllllIlIllIIIlllIlIIIII = llllllllllllllIlIllIIIlllIIlllIl.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                        final short llllllllllllllIlIllIIIlllIIlllll = llllllllllllllIlIllIIIlllIIlllIl.get((Type<Short>)Type.UNSIGNED_BYTE, 1);
                        int llllllllllllllIlIllIIIlllIIllllI = llllllllllllllIlIllIIIlllIIlllIl.get((Type<Integer>)Type.VAR_INT, 0);
                        if (llllllllllllllIlIllIIIlllIIllllI == 25) {
                            llllllllllllllIlIllIIIlllIIllllI = 73;
                        }
                        else if (llllllllllllllIlIllIIIlllIIllllI == 33) {
                            llllllllllllllIlIllIIIlllIIllllI = 99;
                        }
                        else if (llllllllllllllIlIllIIIlllIIllllI == 29) {
                            llllllllllllllIlIllIIIlllIIllllI = 92;
                        }
                        else if (llllllllllllllIlIllIIIlllIIllllI == 54) {
                            llllllllllllllIlIllIIIlllIIllllI = 142;
                        }
                        else if (llllllllllllllIlIllIIIlllIIllllI == 146) {
                            llllllllllllllIlIllIIIlllIIllllI = 305;
                        }
                        else if (llllllllllllllIlIllIIIlllIIllllI == 130) {
                            llllllllllllllIlIllIIIlllIIllllI = 249;
                        }
                        else if (llllllllllllllIlIllIIIlllIIllllI == 138) {
                            llllllllllllllIlIllIIIlllIIllllI = 257;
                        }
                        else if (llllllllllllllIlIllIIIlllIIllllI == 52) {
                            llllllllllllllIlIllIIIlllIIllllI = 140;
                        }
                        else if (llllllllllllllIlIllIIIlllIIllllI == 209) {
                            llllllllllllllIlIllIIIlllIIllllI = 472;
                        }
                        else if (llllllllllllllIlIllIIIlllIIllllI >= 219 && llllllllllllllIlIllIIIlllIIllllI <= 234) {
                            llllllllllllllIlIllIIIlllIIllllI = llllllllllllllIlIllIIIlllIIllllI - 219 + 483;
                        }
                        if (llllllllllllllIlIllIIIlllIIllllI == 73) {
                            final PacketWrapper llllllllllllllIlIllIIIlllIlIIlII = llllllllllllllIlIllIIIlllIIlllIl.create(11);
                            llllllllllllllIlIllIIIlllIlIIlII.write(Type.POSITION, new Position(llllllllllllllIlIllIIIlllIlIIIIl));
                            llllllllllllllIlIllIIIlllIlIIlII.write(Type.VAR_INT, 249 + llllllllllllllIlIllIIIlllIlIIIII * 24 * 2 + llllllllllllllIlIllIIIlllIIlllll * 2);
                            llllllllllllllIlIllIIIlllIlIIlII.send(Protocol1_13To1_12_2.class);
                        }
                        llllllllllllllIlIllIIIlllIIlllIl.set(Type.VAR_INT, 0, llllllllllllllIlIllIIIlllIIllllI);
                    }
                });
            }
        });
        llllllllllllllIlIIIlIlIlIIllIIII.registerClientbound(ClientboundPackets1_12_1.BLOCK_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIIlllIlIIlIlllllI) throws Exception {
                        final Position lllllllllllllllIIlllIlIIllIIIIIl = lllllllllllllllIIlllIlIIlIlllllI.get(Type.POSITION, 0);
                        int lllllllllllllllIIlllIlIIllIIIIII = WorldPackets.toNewId(lllllllllllllllIIlllIlIIlIlllllI.get((Type<Integer>)Type.VAR_INT, 0));
                        final UserConnection lllllllllllllllIIlllIlIIlIllllll = lllllllllllllllIIlllIlIIlIlllllI.user();
                        if (Via.getConfig().isServersideBlockConnections()) {
                            ConnectionData.updateBlockStorage(lllllllllllllllIIlllIlIIlIllllll, lllllllllllllllIIlllIlIIllIIIIIl.getX(), lllllllllllllllIIlllIlIIllIIIIIl.getY(), lllllllllllllllIIlllIlIIllIIIIIl.getZ(), lllllllllllllllIIlllIlIIllIIIIII);
                            lllllllllllllllIIlllIlIIllIIIIII = ConnectionData.connect(lllllllllllllllIIlllIlIIlIllllll, lllllllllllllllIIlllIlIIllIIIIIl, lllllllllllllllIIlllIlIIllIIIIII);
                        }
                        lllllllllllllllIIlllIlIIlIlllllI.set(Type.VAR_INT, 0, checkStorage(lllllllllllllllIIlllIlIIlIlllllI.user(), lllllllllllllllIIlllIlIIllIIIIIl, lllllllllllllllIIlllIlIIllIIIIII));
                        if (Via.getConfig().isServersideBlockConnections()) {
                            lllllllllllllllIIlllIlIIlIlllllI.send(Protocol1_13To1_12_2.class);
                            lllllllllllllllIIlllIlIIlIlllllI.cancel();
                            ConnectionData.update(lllllllllllllllIIlllIlIIlIllllll, lllllllllllllllIIlllIlIIllIIIIIl);
                        }
                    }
                });
            }
        });
        llllllllllllllIlIIIlIlIlIIllIIII.registerClientbound(ClientboundPackets1_12_1.MULTI_BLOCK_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.BLOCK_CHANGE_RECORD_ARRAY);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIlIlIllIIlIIIIIlI) throws Exception {
                        final int lllllllllllllIlIlIlIllIIlIIIIIIl = lllllllllllllIlIlIlIllIIlIIIIIlI.get((Type<Integer>)Type.INT, 0);
                        final int lllllllllllllIlIlIlIllIIlIIIIIII = lllllllllllllIlIlIlIllIIlIIIIIlI.get((Type<Integer>)Type.INT, 1);
                        final UserConnection lllllllllllllIlIlIlIllIIIlllllll = lllllllllllllIlIlIlIllIIlIIIIIlI.user();
                        short lllllllllllllIlIlIlIllIIIllllIII;
                        final BlockChangeRecord[] lllllllllllllIlIlIlIllIIIllllllI = (Object)(lllllllllllllIlIlIlIllIIIllllIII = (short)(Object)lllllllllllllIlIlIlIllIIlIIIIIlI.get(Type.BLOCK_CHANGE_RECORD_ARRAY, 0));
                        int lllllllllllllIlIlIlIllIIIlllIlll = lllllllllllllIlIlIlIllIIIllllIII.length;
                        for (short lllllllllllllIlIlIlIllIIIlllIllI = 0; lllllllllllllIlIlIlIllIIIlllIllI < lllllllllllllIlIlIlIllIIIlllIlll; ++lllllllllllllIlIlIlIllIIIlllIllI) {
                            final BlockChangeRecord lllllllllllllIlIlIlIllIIlIIIlIlI = lllllllllllllIlIlIlIllIIIllllIII[lllllllllllllIlIlIlIllIIIlllIllI];
                            final int lllllllllllllIlIlIlIllIIlIIIllII = WorldPackets.toNewId(lllllllllllllIlIlIlIllIIlIIIlIlI.getBlockId());
                            final Position lllllllllllllIlIlIlIllIIlIIIlIll = new Position(lllllllllllllIlIlIlIllIIlIIIlIlI.getSectionX() + lllllllllllllIlIlIlIllIIlIIIIIIl * 16, lllllllllllllIlIlIlIllIIlIIIlIlI.getY(), lllllllllllllIlIlIlIllIIlIIIlIlI.getSectionZ() + lllllllllllllIlIlIlIllIIlIIIIIII * 16);
                            if (Via.getConfig().isServersideBlockConnections()) {
                                ConnectionData.updateBlockStorage(lllllllllllllIlIlIlIllIIIlllllll, lllllllllllllIlIlIlIllIIlIIIlIll.getX(), lllllllllllllIlIlIlIllIIlIIIlIll.getY(), lllllllllllllIlIlIlIllIIlIIIlIll.getZ(), lllllllllllllIlIlIlIllIIlIIIllII);
                            }
                            lllllllllllllIlIlIlIllIIlIIIlIlI.setBlockId(checkStorage(lllllllllllllIlIlIlIllIIlIIIIIlI.user(), lllllllllllllIlIlIlIllIIlIIIlIll, lllllllllllllIlIlIlIllIIlIIIllII));
                        }
                        if (Via.getConfig().isServersideBlockConnections()) {
                            lllllllllllllIlIlIlIllIIIllllIII = (short)(Object)lllllllllllllIlIlIlIllIIIllllllI;
                            lllllllllllllIlIlIlIllIIIlllIlll = lllllllllllllIlIlIlIllIIIllllIII.length;
                            for (short lllllllllllllIlIlIlIllIIIlllIllI = 0; lllllllllllllIlIlIlIllIIIlllIllI < lllllllllllllIlIlIlIllIIIlllIlll; ++lllllllllllllIlIlIlIllIIIlllIllI) {
                                final BlockChangeRecord lllllllllllllIlIlIlIllIIlIIIIllI = lllllllllllllIlIlIlIllIIIllllIII[lllllllllllllIlIlIlIllIIIlllIllI];
                                int lllllllllllllIlIlIlIllIIlIIIlIIl = lllllllllllllIlIlIlIllIIlIIIIllI.getBlockId();
                                final Position lllllllllllllIlIlIlIllIIlIIIlIII = new Position(lllllllllllllIlIlIlIllIIlIIIIllI.getSectionX() + lllllllllllllIlIlIlIllIIlIIIIIIl * 16, lllllllllllllIlIlIlIllIIlIIIIllI.getY(), lllllllllllllIlIlIlIllIIlIIIIllI.getSectionZ() + lllllllllllllIlIlIlIllIIlIIIIIII * 16);
                                final ConnectionHandler lllllllllllllIlIlIlIllIIlIIIIlll = ConnectionData.getConnectionHandler(lllllllllllllIlIlIlIllIIlIIIlIIl);
                                if (lllllllllllllIlIlIlIllIIlIIIIlll != null) {
                                    lllllllllllllIlIlIlIllIIlIIIlIIl = lllllllllllllIlIlIlIllIIlIIIIlll.connect(lllllllllllllIlIlIlIllIIIlllllll, lllllllllllllIlIlIlIllIIlIIIlIII, lllllllllllllIlIlIlIllIIlIIIlIIl);
                                    lllllllllllllIlIlIlIllIIlIIIIllI.setBlockId(lllllllllllllIlIlIlIllIIlIIIlIIl);
                                }
                            }
                            lllllllllllllIlIlIlIllIIlIIIIIlI.send(Protocol1_13To1_12_2.class);
                            lllllllllllllIlIlIlIllIIlIIIIIlI.cancel();
                            lllllllllllllIlIlIlIllIIIllllIII = (short)(Object)lllllllllllllIlIlIlIllIIIllllllI;
                            lllllllllllllIlIlIlIllIIIlllIlll = lllllllllllllIlIlIlIllIIIllllIII.length;
                            for (short lllllllllllllIlIlIlIllIIIlllIllI = 0; lllllllllllllIlIlIlIllIIIlllIllI < lllllllllllllIlIlIlIllIIIlllIlll; ++lllllllllllllIlIlIlIllIIIlllIllI) {
                                final BlockChangeRecord lllllllllllllIlIlIlIllIIlIIIIlII = lllllllllllllIlIlIlIllIIIllllIII[lllllllllllllIlIlIlIllIIIlllIllI];
                                final Position lllllllllllllIlIlIlIllIIlIIIIlIl = new Position(lllllllllllllIlIlIlIllIIlIIIIlII.getSectionX() + lllllllllllllIlIlIlIllIIlIIIIIIl * 16, lllllllllllllIlIlIlIllIIlIIIIlII.getY(), lllllllllllllIlIlIlIllIIlIIIIlII.getSectionZ() + lllllllllllllIlIlIlIllIIlIIIIIII * 16);
                                ConnectionData.update(lllllllllllllIlIlIlIllIIIlllllll, lllllllllllllIlIlIlIllIIlIIIIlIl);
                            }
                        }
                    }
                });
            }
        });
        llllllllllllllIlIIIlIlIlIIllIIII.registerClientbound(ClientboundPackets1_12_1.EXPLOSION, new PacketRemapper() {
            @Override
            public void registerMap() {
                if (!Via.getConfig().isServersideBlockConnections()) {
                    return;
                }
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllllllllllIlIIIIllI) throws Exception {
                        final UserConnection lllllllllllllllllllllllIlIIIllII = lllllllllllllllllllllllIlIIIIllI.user();
                        final int lllllllllllllllllllllllIlIIIlIll = (int)Math.floor(lllllllllllllllllllllllIlIIIIllI.get((Type<Float>)Type.FLOAT, 0));
                        final int lllllllllllllllllllllllIlIIIlIlI = (int)Math.floor(lllllllllllllllllllllllIlIIIIllI.get((Type<Float>)Type.FLOAT, 1));
                        final int lllllllllllllllllllllllIlIIIlIIl = (int)Math.floor(lllllllllllllllllllllllIlIIIIllI.get((Type<Float>)Type.FLOAT, 2));
                        final int lllllllllllllllllllllllIlIIIlIII = lllllllllllllllllllllllIlIIIIllI.get((Type<Integer>)Type.INT, 0);
                        final Position[] lllllllllllllllllllllllIlIIIIlll = new Position[lllllllllllllllllllllllIlIIIlIII];
                        for (int lllllllllllllllllllllllIlIIlIIII = 0; lllllllllllllllllllllllIlIIlIIII < lllllllllllllllllllllllIlIIIlIII; ++lllllllllllllllllllllllIlIIlIIII) {
                            final Position lllllllllllllllllllllllIlIIlIIIl = new Position(lllllllllllllllllllllllIlIIIlIll + lllllllllllllllllllllllIlIIIIllI.passthrough((Type<Byte>)Type.BYTE), (short)(lllllllllllllllllllllllIlIIIlIlI + lllllllllllllllllllllllIlIIIIllI.passthrough((Type<Byte>)Type.BYTE)), lllllllllllllllllllllllIlIIIlIIl + lllllllllllllllllllllllIlIIIIllI.passthrough((Type<Byte>)Type.BYTE));
                            lllllllllllllllllllllllIlIIIIlll[lllllllllllllllllllllllIlIIlIIII] = lllllllllllllllllllllllIlIIlIIIl;
                            ConnectionData.updateBlockStorage(lllllllllllllllllllllllIlIIIllII, lllllllllllllllllllllllIlIIlIIIl.getX(), lllllllllllllllllllllllIlIIlIIIl.getY(), lllllllllllllllllllllllIlIIlIIIl.getZ(), 0);
                        }
                        lllllllllllllllllllllllIlIIIIllI.send(Protocol1_13To1_12_2.class);
                        lllllllllllllllllllllllIlIIIIllI.cancel();
                        for (int lllllllllllllllllllllllIlIIIllll = 0; lllllllllllllllllllllllIlIIIllll < lllllllllllllllllllllllIlIIIlIII; ++lllllllllllllllllllllllIlIIIllll) {
                            ConnectionData.update(lllllllllllllllllllllllIlIIIllII, lllllllllllllllllllllllIlIIIIlll[lllllllllllllllllllllllIlIIIllll]);
                        }
                    }
                });
            }
        });
        llllllllllllllIlIIIlIlIlIIllIIII.registerClientbound(ClientboundPackets1_12_1.UNLOAD_CHUNK, new PacketRemapper() {
            @Override
            public void registerMap() {
                if (Via.getConfig().isServersideBlockConnections()) {
                    this.handler(new PacketHandler() {
                        @Override
                        public void handle(final PacketWrapper lllllllllllllIllIIIIlllIIlllIIIl) throws Exception {
                            final int lllllllllllllIllIIIIlllIIlllIIll = lllllllllllllIllIIIIlllIIlllIIIl.passthrough((Type<Integer>)Type.INT);
                            final int lllllllllllllIllIIIIlllIIlllIIlI = lllllllllllllIllIIIIlllIIlllIIIl.passthrough((Type<Integer>)Type.INT);
                            ConnectionData.blockConnectionProvider.unloadChunk(lllllllllllllIllIIIIlllIIlllIIIl.user(), lllllllllllllIllIIIIlllIIlllIIll, lllllllllllllIllIIIIlllIIlllIIlI);
                        }
                    });
                }
            }
        });
        llllllllllllllIlIIIlIlIlIIllIIII.registerClientbound(ClientboundPackets1_12_1.NAMED_SOUND, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIlIlIlIIIIlllllll) throws Exception {
                        final String lllllllllllllIIIlIlIlIIIlIIIIIIl = lllllllllllllIIIlIlIlIIIIlllllll.get(Type.STRING, 0).replace("minecraft:", "");
                        final String lllllllllllllIIIlIlIlIIIlIIIIIII = NamedSoundRewriter.getNewId(lllllllllllllIIIlIlIlIIIlIIIIIIl);
                        lllllllllllllIIIlIlIlIIIIlllllll.set(Type.STRING, 0, lllllllllllllIIIlIlIlIIIlIIIIIII);
                    }
                });
            }
        });
        llllllllllllllIlIIIlIlIlIIllIIII.registerClientbound(ClientboundPackets1_12_1.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIIIllllIIIIlIIII) throws Exception {
                        final ClientWorld lllllllllllllIIIIIIllllIIIIlIllI = lllllllllllllIIIIIIllllIIIIlIIII.user().get(ClientWorld.class);
                        final BlockStorage lllllllllllllIIIIIIllllIIIIlIlIl = lllllllllllllIIIIIIllllIIIIlIIII.user().get(BlockStorage.class);
                        final Chunk1_9_3_4Type lllllllllllllIIIIIIllllIIIIlIlII = new Chunk1_9_3_4Type(lllllllllllllIIIIIIllllIIIIlIllI);
                        final Chunk1_13Type lllllllllllllIIIIIIllllIIIIlIIll = new Chunk1_13Type(lllllllllllllIIIIIIllllIIIIlIllI);
                        final Chunk lllllllllllllIIIIIIllllIIIIlIIlI = lllllllllllllIIIIIIllllIIIIlIIII.read((Type<Chunk>)lllllllllllllIIIIIIllllIIIIlIlII);
                        lllllllllllllIIIIIIllllIIIIlIIII.write((Type<Chunk>)lllllllllllllIIIIIIllllIIIIlIIll, lllllllllllllIIIIIIllllIIIIlIIlI);
                        for (int lllllllllllllIIIIIIllllIIIlIIlIl = 0; lllllllllllllIIIIIIllllIIIlIIlIl < lllllllllllllIIIIIIllllIIIIlIIlI.getSections().length; ++lllllllllllllIIIIIIllllIIIlIIlIl) {
                            final ChunkSection lllllllllllllIIIIIIllllIIIlIlIII = lllllllllllllIIIIIIllllIIIIlIIlI.getSections()[lllllllllllllIIIIIIllllIIIlIIlIl];
                            if (lllllllllllllIIIIIIllllIIIlIlIII != null) {
                                for (int lllllllllllllIIIIIIllllIIIllIlIl = 0; lllllllllllllIIIIIIllllIIIllIlIl < lllllllllllllIIIIIIllllIIIlIlIII.getPaletteSize(); ++lllllllllllllIIIIIIllllIIIllIlIl) {
                                    final int lllllllllllllIIIIIIllllIIIllIlll = lllllllllllllIIIIIIllllIIIlIlIII.getPaletteEntry(lllllllllllllIIIIIIllllIIIllIlIl);
                                    final int lllllllllllllIIIIIIllllIIIllIllI = WorldPackets.toNewId(lllllllllllllIIIIIIllllIIIllIlll);
                                    lllllllllllllIIIIIIllllIIIlIlIII.setPaletteEntry(lllllllllllllIIIIIIllllIIIllIlIl, lllllllllllllIIIIIIllllIIIllIllI);
                                }
                                boolean lllllllllllllIIIIIIllllIIIlIIlll = false;
                                for (int lllllllllllllIIIIIIllllIIIllIIll = 0; lllllllllllllIIIIIIllllIIIllIIll < lllllllllllllIIIIIIllllIIIlIlIII.getPaletteSize(); ++lllllllllllllIIIIIIllllIIIllIIll) {
                                    final int lllllllllllllIIIIIIllllIIIllIlII = lllllllllllllIIIIIIllllIIIlIlIII.getPaletteEntry(lllllllllllllIIIIIIllllIIIllIIll);
                                    if (lllllllllllllIIIIIIllllIIIIlIlIl.isWelcome(lllllllllllllIIIIIIllllIIIllIlII)) {
                                        lllllllllllllIIIIIIllllIIIlIIlll = true;
                                        break;
                                    }
                                }
                                boolean lllllllllllllIIIIIIllllIIIlIIllI = false;
                                if (Via.getConfig().isServersideBlockConnections() && ConnectionData.needStoreBlocks()) {
                                    for (int lllllllllllllIIIIIIllllIIIllIIIl = 0; lllllllllllllIIIIIIllllIIIllIIIl < lllllllllllllIIIIIIllllIIIlIlIII.getPaletteSize(); ++lllllllllllllIIIIIIllllIIIllIIIl) {
                                        final int lllllllllllllIIIIIIllllIIIllIIlI = lllllllllllllIIIIIIllllIIIlIlIII.getPaletteEntry(lllllllllllllIIIIIIllllIIIllIIIl);
                                        if (ConnectionData.isWelcome(lllllllllllllIIIIIIllllIIIllIIlI)) {
                                            lllllllllllllIIIIIIllllIIIlIIllI = true;
                                            break;
                                        }
                                    }
                                }
                                if (lllllllllllllIIIIIIllllIIIlIIlll) {
                                    for (int lllllllllllllIIIIIIllllIIIlIllIl = 0; lllllllllllllIIIIIIllllIIIlIllIl < 16; ++lllllllllllllIIIIIIllllIIIlIllIl) {
                                        for (int lllllllllllllIIIIIIllllIIIlIlllI = 0; lllllllllllllIIIIIIllllIIIlIlllI < 16; ++lllllllllllllIIIIIIllllIIIlIlllI) {
                                            for (int lllllllllllllIIIIIIllllIIIlIllll = 0; lllllllllllllIIIIIIllllIIIlIllll < 16; ++lllllllllllllIIIIIIllllIIIlIllll) {
                                                final int lllllllllllllIIIIIIllllIIIllIIII = lllllllllllllIIIIIIllllIIIlIlIII.getFlatBlock(lllllllllllllIIIIIIllllIIIlIllll, lllllllllllllIIIIIIllllIIIlIllIl, lllllllllllllIIIIIIllllIIIlIlllI);
                                                if (lllllllllllllIIIIIIllllIIIIlIlIl.isWelcome(lllllllllllllIIIIIIllllIIIllIIII)) {
                                                    lllllllllllllIIIIIIllllIIIIlIlIl.store(new Position(lllllllllllllIIIIIIllllIIIlIllll + (lllllllllllllIIIIIIllllIIIIlIIlI.getX() << 4), (short)(lllllllllllllIIIIIIllllIIIlIllIl + (lllllllllllllIIIIIIllllIIIlIIlIl << 4)), lllllllllllllIIIIIIllllIIIlIlllI + (lllllllllllllIIIIIIllllIIIIlIIlI.getZ() << 4)), lllllllllllllIIIIIIllllIIIllIIII);
                                                }
                                            }
                                        }
                                    }
                                }
                                if (lllllllllllllIIIIIIllllIIIlIIllI) {
                                    for (int lllllllllllllIIIIIIllllIIIlIlIIl = 0; lllllllllllllIIIIIIllllIIIlIlIIl < 16; ++lllllllllllllIIIIIIllllIIIlIlIIl) {
                                        for (int lllllllllllllIIIIIIllllIIIlIlIlI = 0; lllllllllllllIIIIIIllllIIIlIlIlI < 16; ++lllllllllllllIIIIIIllllIIIlIlIlI) {
                                            for (int lllllllllllllIIIIIIllllIIIlIlIll = 0; lllllllllllllIIIIIIllllIIIlIlIll < 16; ++lllllllllllllIIIIIIllllIIIlIlIll) {
                                                final int lllllllllllllIIIIIIllllIIIlIllII = lllllllllllllIIIIIIllllIIIlIlIII.getFlatBlock(lllllllllllllIIIIIIllllIIIlIlIll, lllllllllllllIIIIIIllllIIIlIlIIl, lllllllllllllIIIIIIllllIIIlIlIlI);
                                                if (ConnectionData.isWelcome(lllllllllllllIIIIIIllllIIIlIllII)) {
                                                    ConnectionData.blockConnectionProvider.storeBlock(lllllllllllllIIIIIIllllIIIIlIIII.user(), lllllllllllllIIIIIIllllIIIlIlIll + (lllllllllllllIIIIIIllllIIIIlIIlI.getX() << 4), lllllllllllllIIIIIIllllIIIlIlIIl + (lllllllllllllIIIIIIllllIIIlIIlIl << 4), lllllllllllllIIIIIIllllIIIlIlIlI + (lllllllllllllIIIIIIllllIIIIlIIlI.getZ() << 4), lllllllllllllIIIIIIllllIIIlIllII);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (lllllllllllllIIIIIIllllIIIIlIIlI.isBiomeData()) {
                            int lllllllllllllIIIIIIllllIIIlIIIlI = Integer.MIN_VALUE;
                            for (int lllllllllllllIIIIIIllllIIIlIIIll = 0; lllllllllllllIIIIIIllllIIIlIIIll < 256; ++lllllllllllllIIIIIIllllIIIlIIIll) {
                                final int lllllllllllllIIIIIIllllIIIlIIlII = lllllllllllllIIIIIIllllIIIIlIIlI.getBiomeData()[lllllllllllllIIIIIIllllIIIlIIIll];
                                if (!WorldPackets.VALID_BIOMES.contains(lllllllllllllIIIIIIllllIIIlIIlII)) {
                                    if (lllllllllllllIIIIIIllllIIIlIIlII != 255 && lllllllllllllIIIIIIllllIIIlIIIlI != lllllllllllllIIIIIIllllIIIlIIlII) {
                                        if (!Via.getConfig().isSuppressConversionWarnings() || Via.getManager().isDebug()) {
                                            Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Received invalid biome id ").append(lllllllllllllIIIIIIllllIIIlIIlII)));
                                        }
                                        lllllllllllllIIIIIIllllIIIlIIIlI = lllllllllllllIIIIIIllllIIIlIIlII;
                                    }
                                    lllllllllllllIIIIIIllllIIIIlIIlI.getBiomeData()[lllllllllllllIIIIIIllllIIIlIIIll] = 1;
                                }
                            }
                        }
                        final BlockEntityProvider lllllllllllllIIIIIIllllIIIIlIIIl = Via.getManager().getProviders().get(BlockEntityProvider.class);
                        for (final CompoundTag lllllllllllllIIIIIIllllIIIIllIll : lllllllllllllIIIIIIllllIIIIlIIlI.getBlockEntities()) {
                            final int lllllllllllllIIIIIIllllIIIIlllII = lllllllllllllIIIIIIllllIIIIlIIIl.transform(lllllllllllllIIIIIIllllIIIIlIIII.user(), null, lllllllllllllIIIIIIllllIIIIllIll, false);
                            if (lllllllllllllIIIIIIllllIIIIlllII != -1) {
                                final int lllllllllllllIIIIIIllllIIIlIIIIl = lllllllllllllIIIIIIllllIIIIllIll.get("x").asInt();
                                final int lllllllllllllIIIIIIllllIIIlIIIII = lllllllllllllIIIIIIllllIIIIllIll.get("y").asInt();
                                final int lllllllllllllIIIIIIllllIIIIlllll = lllllllllllllIIIIIIllllIIIIllIll.get("z").asInt();
                                final Position lllllllllllllIIIIIIllllIIIIllllI = new Position(lllllllllllllIIIIIIllllIIIlIIIIl, (short)lllllllllllllIIIIIIllllIIIlIIIII, lllllllllllllIIIIIIllllIIIIlllll);
                                final BlockStorage.ReplacementData lllllllllllllIIIIIIllllIIIIlllIl = lllllllllllllIIIIIIllllIIIIlIlIl.get(lllllllllllllIIIIIIllllIIIIllllI);
                                if (lllllllllllllIIIIIIllllIIIIlllIl != null) {
                                    lllllllllllllIIIIIIllllIIIIlllIl.setReplacement(lllllllllllllIIIIIIllllIIIIlllII);
                                }
                                lllllllllllllIIIIIIllllIIIIlIIlI.getSections()[lllllllllllllIIIIIIllllIIIlIIIII >> 4].setFlatBlock(lllllllllllllIIIIIIllllIIIlIIIIl & 0xF, lllllllllllllIIIIIIllllIIIlIIIII & 0xF, lllllllllllllIIIIIIllllIIIIlllll & 0xF, lllllllllllllIIIIIIllllIIIIlllII);
                            }
                        }
                        if (Via.getConfig().isServersideBlockConnections()) {
                            ConnectionData.connectBlocks(lllllllllllllIIIIIIllllIIIIlIIII.user(), lllllllllllllIIIIIIllllIIIIlIIlI);
                            lllllllllllllIIIIIIllllIIIIlIIII.send(Protocol1_13To1_12_2.class);
                            lllllllllllllIIIIIIllllIIIIlIIII.cancel();
                            for (int lllllllllllllIIIIIIllllIIIIllIIl = 0; lllllllllllllIIIIIIllllIIIIllIIl < lllllllllllllIIIIIIllllIIIIlIIlI.getSections().length; ++lllllllllllllIIIIIIllllIIIIllIIl) {
                                final ChunkSection lllllllllllllIIIIIIllllIIIIllIlI = lllllllllllllIIIIIIllllIIIIlIIlI.getSections()[lllllllllllllIIIIIIllllIIIIllIIl];
                                if (lllllllllllllIIIIIIllllIIIIllIlI != null) {
                                    ConnectionData.updateChunkSectionNeighbours(lllllllllllllIIIIIIllllIIIIlIIII.user(), lllllllllllllIIIIIIllllIIIIlIIlI.getX(), lllllllllllllIIIIIIllllIIIIlIIlI.getZ(), lllllllllllllIIIIIIllllIIIIllIIl);
                                }
                            }
                        }
                    }
                });
            }
        });
        llllllllllllllIlIIIlIlIlIIllIIII.registerClientbound(ClientboundPackets1_12_1.SPAWN_PARTICLE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.BOOLEAN);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllIllllllllIlIlllIIIll) throws Exception {
                        final int llllllllllllIllllllllIlIlllIIIlI = llllllllllllIllllllllIlIlllIIIll.get((Type<Integer>)Type.INT, 0);
                        int llllllllllllIllllllllIlIlllIIIIl = 0;
                        if (llllllllllllIllllllllIlIlllIIIlI == 37 || llllllllllllIllllllllIlIlllIIIlI == 38 || llllllllllllIllllllllIlIlllIIIlI == 46) {
                            llllllllllllIllllllllIlIlllIIIIl = 1;
                        }
                        else if (llllllllllllIllllllllIlIlllIIIlI == 36) {
                            llllllllllllIllllllllIlIlllIIIIl = 2;
                        }
                        final Integer[] llllllllllllIllllllllIlIlllIIIII = new Integer[llllllllllllIllllllllIlIlllIIIIl];
                        for (int llllllllllllIllllllllIlIlllIlIll = 0; llllllllllllIllllllllIlIlllIlIll < llllllllllllIllllllllIlIlllIIIII.length; ++llllllllllllIllllllllIlIlllIlIll) {
                            llllllllllllIllllllllIlIlllIIIII[llllllllllllIllllllllIlIlllIlIll] = llllllllllllIllllllllIlIlllIIIll.read((Type<Integer>)Type.VAR_INT);
                        }
                        final Particle llllllllllllIllllllllIlIllIlllll = ParticleRewriter.rewriteParticle(llllllllllllIllllllllIlIlllIIIlI, llllllllllllIllllllllIlIlllIIIII);
                        if (llllllllllllIllllllllIlIllIlllll == null || llllllllllllIllllllllIlIllIlllll.getId() == -1) {
                            llllllllllllIllllllllIlIlllIIIll.cancel();
                            return;
                        }
                        if (llllllllllllIllllllllIlIllIlllll.getId() == 11) {
                            final int llllllllllllIllllllllIlIlllIIlll = llllllllllllIllllllllIlIlllIIIll.get((Type<Integer>)Type.INT, 1);
                            final float llllllllllllIllllllllIlIlllIIllI = llllllllllllIllllllllIlIlllIIIll.get((Type<Float>)Type.FLOAT, 6);
                            if (llllllllllllIllllllllIlIlllIIlll == 0) {
                                llllllllllllIllllllllIlIlllIIIll.set(Type.INT, 1, 1);
                                llllllllllllIllllllllIlIlllIIIll.set(Type.FLOAT, 6, 0.0f);
                                final List<Particle.ParticleData> llllllllllllIllllllllIlIlllIlIII = llllllllllllIllllllllIlIllIlllll.getArguments();
                                for (int llllllllllllIllllllllIlIlllIlIIl = 0; llllllllllllIllllllllIlIlllIlIIl < 3; ++llllllllllllIllllllllIlIlllIlIIl) {
                                    float llllllllllllIllllllllIlIlllIlIlI = llllllllllllIllllllllIlIlllIIIll.get((Type<Float>)Type.FLOAT, llllllllllllIllllllllIlIlllIlIIl + 3) * llllllllllllIllllllllIlIlllIIllI;
                                    if (llllllllllllIllllllllIlIlllIlIlI == 0.0f && llllllllllllIllllllllIlIlllIlIIl == 0) {
                                        llllllllllllIllllllllIlIlllIlIlI = 1.0f;
                                    }
                                    llllllllllllIllllllllIlIlllIlIII.get(llllllllllllIllllllllIlIlllIlIIl).setValue(llllllllllllIllllllllIlIlllIlIlI);
                                    llllllllllllIllllllllIlIlllIIIll.set(Type.FLOAT, llllllllllllIllllllllIlIlllIlIIl + 3, 0.0f);
                                }
                            }
                        }
                        llllllllllllIllllllllIlIlllIIIll.set(Type.INT, 0, llllllllllllIllllllllIlIllIlllll.getId());
                        for (final Particle.ParticleData llllllllllllIllllllllIlIlllIIlIl : llllllllllllIllllllllIlIllIlllll.getArguments()) {
                            llllllllllllIllllllllIlIlllIIIll.write(llllllllllllIllllllllIlIlllIIlIl.getType(), llllllllllllIllllllllIlIlllIIlIl.getValue());
                        }
                    }
                });
            }
        });
    }
}
