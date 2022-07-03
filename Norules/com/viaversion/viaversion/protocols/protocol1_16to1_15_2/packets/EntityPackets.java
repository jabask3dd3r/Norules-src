package com.viaversion.viaversion.protocols.protocol1_16to1_15_2.packets;

import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.metadata.*;
import com.viaversion.viaversion.protocols.protocol1_15to1_14_4.*;
import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import java.util.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.data.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.protocol.*;

public class EntityPackets
{
    public static final /* synthetic */ CompoundTag DIMENSIONS_TAG;
    private static final /* synthetic */ PacketHandler DIMENSION_HANDLER;
    private static final /* synthetic */ String[] WORLD_NAMES;
    
    private static CompoundTag createEndEntry() {
        final CompoundTag llllllllllllllllIIlIlIlIllIIlllI = new CompoundTag();
        llllllllllllllllIIlIlIlIllIIlllI.put("piglin_safe", new ByteTag((byte)0));
        llllllllllllllllIIlIlIlIllIIlllI.put("natural", new ByteTag((byte)0));
        llllllllllllllllIIlIlIlIllIIlllI.put("ambient_light", new FloatTag(0.0f));
        llllllllllllllllIIlIlIlIllIIlllI.put("infiniburn", new StringTag("minecraft:infiniburn_end"));
        llllllllllllllllIIlIlIlIllIIlllI.put("respawn_anchor_works", new ByteTag((byte)0));
        llllllllllllllllIIlIlIlIllIIlllI.put("has_skylight", new ByteTag((byte)0));
        llllllllllllllllIIlIlIlIllIIlllI.put("bed_works", new ByteTag((byte)0));
        llllllllllllllllIIlIlIlIllIIlllI.put("fixed_time", new LongTag(6000L));
        llllllllllllllllIIlIlIlIllIIlllI.put("has_raids", new ByteTag((byte)1));
        llllllllllllllllIIlIlIlIllIIlllI.put("name", new StringTag("minecraft:the_end"));
        llllllllllllllllIIlIlIlIllIIlllI.put("logical_height", new IntTag(256));
        llllllllllllllllIIlIlIlIllIIlllI.put("shrunk", new ByteTag((byte)0));
        llllllllllllllllIIlIlIlIllIIlllI.put("ultrawarm", new ByteTag((byte)0));
        llllllllllllllllIIlIlIlIllIIlllI.put("has_ceiling", new ByteTag((byte)0));
        return llllllllllllllllIIlIlIlIllIIlllI;
    }
    
    public static void register(final Protocol1_16To1_15_2 llllllllllllllllIIlIlIlIlIlllllI) {
        final MetadataRewriter1_16To1_15_2 llllllllllllllllIIlIlIlIllIIIIII = llllllllllllllllIIlIlIlIlIlllllI.get(MetadataRewriter1_16To1_15_2.class);
        ((Protocol<ClientboundPackets1_15, ClientboundPackets1_16, S1, S2>)llllllllllllllllIIlIlIlIlIlllllI).registerClientbound(ClientboundPackets1_15.SPAWN_GLOBAL_ENTITY, ClientboundPackets1_16.SPAWN_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int llllllllllllllIIIIllIlIlIIIIIlII;
                this.handler(llllllllllllllIIIIllIlIlIIIIIIll -> {
                    llllllllllllllIIIIllIlIlIIIIIlII = llllllllllllllIIIIllIlIlIIIIIIll.passthrough((Type<Integer>)Type.VAR_INT);
                    llllllllllllllIIIIllIlIlIIIIIIll.user().getEntityTracker(Protocol1_16To1_15_2.class).addEntity(llllllllllllllIIIIllIlIlIIIIIlII, Entity1_16Types.LIGHTNING_BOLT);
                    llllllllllllllIIIIllIlIlIIIIIIll.write(Type.UUID, UUID.randomUUID());
                    llllllllllllllIIIIllIlIlIIIIIIll.write(Type.VAR_INT, Entity1_16Types.LIGHTNING_BOLT.getId());
                    llllllllllllllIIIIllIlIlIIIIIIll.read((Type<Object>)Type.BYTE);
                    llllllllllllllIIIIllIlIlIIIIIIll.passthrough((Type<Object>)Type.DOUBLE);
                    llllllllllllllIIIIllIlIlIIIIIIll.passthrough((Type<Object>)Type.DOUBLE);
                    llllllllllllllIIIIllIlIlIIIIIIll.passthrough((Type<Object>)Type.DOUBLE);
                    llllllllllllllIIIIllIlIlIIIIIIll.write(Type.BYTE, (Byte)0);
                    llllllllllllllIIIIllIlIlIIIIIIll.write(Type.BYTE, (Byte)0);
                    llllllllllllllIIIIllIlIlIIIIIIll.write(Type.INT, 0);
                    llllllllllllllIIIIllIlIlIIIIIIll.write(Type.SHORT, (Short)0);
                    llllllllllllllIIIIllIlIlIIIIIIll.write(Type.SHORT, (Short)0);
                    llllllllllllllIIIIllIlIlIIIIIIll.write(Type.SHORT, (Short)0);
                });
            }
        });
        llllllllllllllllIIlIlIlIllIIIIII.registerTrackerWithData(ClientboundPackets1_15.SPAWN_ENTITY, Entity1_16Types.FALLING_BLOCK);
        llllllllllllllllIIlIlIlIllIIIIII.registerTracker(ClientboundPackets1_15.SPAWN_MOB);
        llllllllllllllllIIlIlIlIllIIIIII.registerTracker(ClientboundPackets1_15.SPAWN_PLAYER, Entity1_16Types.PLAYER);
        llllllllllllllllIIlIlIlIllIIIIII.registerMetadataRewriter(ClientboundPackets1_15.ENTITY_METADATA, Types1_14.METADATA_LIST, Types1_16.METADATA_LIST);
        llllllllllllllllIIlIlIlIllIIIIII.registerRemoveEntities(ClientboundPackets1_15.DESTROY_ENTITIES);
        ((AbstractProtocol<ClientboundPackets1_15, C2, S1, S2>)llllllllllllllllIIlIlIlIlIlllllI).registerClientbound(ClientboundPackets1_15.RESPAWN, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(EntityPackets.DIMENSION_HANDLER);
                this.map(Type.LONG);
                this.map(Type.UNSIGNED_BYTE);
                final String lllllllllllllllIlIllIIIIIIlIlIIl;
                this.handler(lllllllllllllllIlIllIIIIIIlIlIlI -> {
                    lllllllllllllllIlIllIIIIIIlIlIlI.write(Type.BYTE, (Byte)(-1));
                    lllllllllllllllIlIllIIIIIIlIlIIl = lllllllllllllllIlIllIIIIIIlIlIlI.read(Type.STRING);
                    lllllllllllllllIlIllIIIIIIlIlIlI.write(Type.BOOLEAN, false);
                    lllllllllllllllIlIllIIIIIIlIlIlI.write(Type.BOOLEAN, lllllllllllllllIlIllIIIIIIlIlIIl.equals("flat"));
                    lllllllllllllllIlIllIIIIIIlIlIlI.write(Type.BOOLEAN, true);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_15, C2, S1, S2>)llllllllllllllllIIlIlIlIlIlllllI).registerClientbound(ClientboundPackets1_15.JOIN_GAME, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.UNSIGNED_BYTE);
                this.handler(llllllllllllIllllllllIlIlIIlIIIl -> {
                    llllllllllllIllllllllIlIlIIlIIIl.write(Type.BYTE, (Byte)(-1));
                    llllllllllllIllllllllIlIlIIlIIIl.write(Type.STRING_ARRAY, EntityPackets.WORLD_NAMES);
                    llllllllllllIllllllllIlIlIIlIIIl.write(Type.NBT, EntityPackets.DIMENSIONS_TAG);
                    return;
                });
                this.handler(EntityPackets.DIMENSION_HANDLER);
                this.map(Type.LONG);
                this.map(Type.UNSIGNED_BYTE);
                final String llllllllllllIllllllllIlIlIIlIlIl;
                this.handler(llllllllllllIllllllllIlIlIIlIlII -> {
                    llllllllllllIllllllllIlIlIIlIlII.user().getEntityTracker(Protocol1_16To1_15_2.class).addEntity(llllllllllllIllllllllIlIlIIlIlII.get((Type<Integer>)Type.INT, 0), Entity1_16Types.PLAYER);
                    llllllllllllIllllllllIlIlIIlIlIl = llllllllllllIllllllllIlIlIIlIlII.read(Type.STRING);
                    llllllllllllIllllllllIlIlIIlIlII.passthrough((Type<Object>)Type.VAR_INT);
                    llllllllllllIllllllllIlIlIIlIlII.passthrough((Type<Object>)Type.BOOLEAN);
                    llllllllllllIllllllllIlIlIIlIlII.passthrough((Type<Object>)Type.BOOLEAN);
                    llllllllllllIllllllllIlIlIIlIlII.write(Type.BOOLEAN, false);
                    llllllllllllIllllllllIlIlIIlIlII.write(Type.BOOLEAN, llllllllllllIllllllllIlIlIIlIlIl.equals("flat"));
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_15, C2, S1, S2>)llllllllllllllllIIlIlIlIlIlllllI).registerClientbound(ClientboundPackets1_15.ENTITY_PROPERTIES, new PacketRemapper() {
            @Override
            public void registerMap() {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: aload_0         /* lllllllllllllIlIlIlIllIIIlIlIlIl */
                //     2: getfield        com/viaversion/viaversion/protocols/protocol1_16to1_15_2/packets/EntityPackets$4.val$protocol:Lcom/viaversion/viaversion/protocols/protocol1_16to1_15_2/Protocol1_16To1_15_2;
                //     5: invokedynamic   BootstrapMethod #0, handle:(Lcom/viaversion/viaversion/protocols/protocol1_16to1_15_2/Protocol1_16To1_15_2;)Lcom/viaversion/viaversion/api/protocol/remapper/PacketHandler;
                //    10: invokevirtual   com/viaversion/viaversion/protocols/protocol1_16to1_15_2/packets/EntityPackets$4.handler:(Lcom/viaversion/viaversion/api/protocol/remapper/PacketHandler;)V
                //    13: return         
                // 
                // The error that occurred was:
                // 
                // java.lang.IllegalStateException: Could not infer any expression.
                //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:374)
                //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:96)
                //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
                //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1164)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1009)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
                //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
                //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
                //     at us.deathmarine.luyten.FileSaver.doSaveJarDecompiled(FileSaver.java:192)
                //     at us.deathmarine.luyten.FileSaver.access$300(FileSaver.java:45)
                //     at us.deathmarine.luyten.FileSaver$4.run(FileSaver.java:112)
                //     at java.lang.Thread.run(Unknown Source)
                // 
                throw new IllegalStateException("An error occurred while decompiling this method.");
            }
        });
    }
    
    private static void addSharedOverwaldEntries(final CompoundTag llllllllllllllllIIlIlIlIlllIlIIl) {
        llllllllllllllllIIlIlIlIlllIlIIl.put("piglin_safe", new ByteTag((byte)0));
        llllllllllllllllIIlIlIlIlllIlIIl.put("natural", new ByteTag((byte)1));
        llllllllllllllllIIlIlIlIlllIlIIl.put("ambient_light", new FloatTag(0.0f));
        llllllllllllllllIIlIlIlIlllIlIIl.put("infiniburn", new StringTag("minecraft:infiniburn_overworld"));
        llllllllllllllllIIlIlIlIlllIlIIl.put("respawn_anchor_works", new ByteTag((byte)0));
        llllllllllllllllIIlIlIlIlllIlIIl.put("has_skylight", new ByteTag((byte)1));
        llllllllllllllllIIlIlIlIlllIlIIl.put("bed_works", new ByteTag((byte)1));
        llllllllllllllllIIlIlIlIlllIlIIl.put("has_raids", new ByteTag((byte)1));
        llllllllllllllllIIlIlIlIlllIlIIl.put("logical_height", new IntTag(256));
        llllllllllllllllIIlIlIlIlllIlIIl.put("shrunk", new ByteTag((byte)0));
        llllllllllllllllIIlIlIlIlllIlIIl.put("ultrawarm", new ByteTag((byte)0));
    }
    
    private static CompoundTag createOverworldCavesEntry() {
        final CompoundTag llllllllllllllllIIlIlIlIlllIlllI = new CompoundTag();
        llllllllllllllllIIlIlIlIlllIlllI.put("name", new StringTag("minecraft:overworld_caves"));
        llllllllllllllllIIlIlIlIlllIlllI.put("has_ceiling", new ByteTag((byte)1));
        addSharedOverwaldEntries(llllllllllllllllIIlIlIlIlllIlllI);
        return llllllllllllllllIIlIlIlIlllIlllI;
    }
    
    private static CompoundTag createNetherEntry() {
        final CompoundTag llllllllllllllllIIlIlIlIlllIIIII = new CompoundTag();
        llllllllllllllllIIlIlIlIlllIIIII.put("piglin_safe", new ByteTag((byte)1));
        llllllllllllllllIIlIlIlIlllIIIII.put("natural", new ByteTag((byte)0));
        llllllllllllllllIIlIlIlIlllIIIII.put("ambient_light", new FloatTag(0.1f));
        llllllllllllllllIIlIlIlIlllIIIII.put("infiniburn", new StringTag("minecraft:infiniburn_nether"));
        llllllllllllllllIIlIlIlIlllIIIII.put("respawn_anchor_works", new ByteTag((byte)1));
        llllllllllllllllIIlIlIlIlllIIIII.put("has_skylight", new ByteTag((byte)0));
        llllllllllllllllIIlIlIlIlllIIIII.put("bed_works", new ByteTag((byte)0));
        llllllllllllllllIIlIlIlIlllIIIII.put("fixed_time", new LongTag(18000L));
        llllllllllllllllIIlIlIlIlllIIIII.put("has_raids", new ByteTag((byte)0));
        llllllllllllllllIIlIlIlIlllIIIII.put("name", new StringTag("minecraft:the_nether"));
        llllllllllllllllIIlIlIlIlllIIIII.put("logical_height", new IntTag(128));
        llllllllllllllllIIlIlIlIlllIIIII.put("shrunk", new ByteTag((byte)1));
        llllllllllllllllIIlIlIlIlllIIIII.put("ultrawarm", new ByteTag((byte)1));
        llllllllllllllllIIlIlIlIlllIIIII.put("has_ceiling", new ByteTag((byte)1));
        return llllllllllllllllIIlIlIlIlllIIIII;
    }
    
    private static CompoundTag createOverworldEntry() {
        final CompoundTag llllllllllllllllIIlIlIlIlllllIII = new CompoundTag();
        llllllllllllllllIIlIlIlIlllllIII.put("name", new StringTag("minecraft:overworld"));
        llllllllllllllllIIlIlIlIlllllIII.put("has_ceiling", new ByteTag((byte)0));
        addSharedOverwaldEntries(llllllllllllllllIIlIlIlIlllllIII);
        return llllllllllllllllIIlIlIlIlllllIII;
    }
    
    static {
        final int llllllllllllllllIIlIlIlIlIlIllII;
        final String llllllllllllllllIIlIlIlIlIllIIIl;
        final String llllllllllllllllIIlIlIlIlIlIllll;
        final String llllllllllllllllIIlIlIlIlIlIlllI;
        final String llllllllllllllllIIlIlIlIlIlIlIll;
        DIMENSION_HANDLER = (llllllllllllllllIIlIlIlIlIlIlIlI -> {
            llllllllllllllllIIlIlIlIlIlIllII = llllllllllllllllIIlIlIlIlIlIlIlI.read((Type<Integer>)Type.INT);
            switch (llllllllllllllllIIlIlIlIlIlIllII) {
                case -1: {
                    llllllllllllllllIIlIlIlIlIllIIIl = "minecraft:the_nether";
                    break;
                }
                case 0: {
                    llllllllllllllllIIlIlIlIlIlIllll = "minecraft:overworld";
                    break;
                }
                case 1: {
                    llllllllllllllllIIlIlIlIlIlIlllI = "minecraft:the_end";
                    break;
                }
                default: {
                    Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Invalid dimension id: ").append(llllllllllllllllIIlIlIlIlIlIllII)));
                    llllllllllllllllIIlIlIlIlIlIlIll = "minecraft:overworld";
                    break;
                }
            }
            llllllllllllllllIIlIlIlIlIlIlIlI.write(Type.STRING, llllllllllllllllIIlIlIlIlIlIlIll);
            llllllllllllllllIIlIlIlIlIlIlIlI.write(Type.STRING, llllllllllllllllIIlIlIlIlIlIlIll);
            return;
        });
        DIMENSIONS_TAG = new CompoundTag();
        WORLD_NAMES = new String[] { "minecraft:overworld", "minecraft:the_nether", "minecraft:the_end" };
        final ListTag llllllllllllllllIIlIlIlIlIlIIIII = new ListTag(CompoundTag.class);
        llllllllllllllllIIlIlIlIlIlIIIII.add(createOverworldEntry());
        llllllllllllllllIIlIlIlIlIlIIIII.add(createOverworldCavesEntry());
        llllllllllllllllIIlIlIlIlIlIIIII.add(createNetherEntry());
        llllllllllllllllIIlIlIlIlIlIIIII.add(createEndEntry());
        EntityPackets.DIMENSIONS_TAG.put("dimension", llllllllllllllllIIlIlIlIlIlIIIII);
    }
}
