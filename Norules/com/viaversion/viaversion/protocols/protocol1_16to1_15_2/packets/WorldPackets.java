package com.viaversion.viaversion.protocols.protocol1_16to1_15_2.packets;

import com.viaversion.viaversion.api.type.types.*;
import java.util.*;
import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_15to1_14_4.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.protocols.protocol1_15to1_14_4.types.*;
import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.types.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.protocol.*;

public class WorldPackets
{
    private static void handleBlockEntity(final CompoundTag lllIlIIlIIllIlI) {
        final StringTag lllIlIIlIIllIIl = lllIlIIlIIllIlI.get("id");
        if (lllIlIIlIIllIIl == null) {
            return;
        }
        final String lllIlIIlIIllIII = lllIlIIlIIllIIl.getValue();
        if (lllIlIIlIIllIII.equals("minecraft:conduit")) {
            final Tag lllIlIIlIlIIIIl = lllIlIIlIIllIlI.remove("target_uuid");
            if (!(lllIlIIlIlIIIIl instanceof StringTag)) {
                return;
            }
            final UUID lllIlIIlIlIIIII = UUID.fromString((String)lllIlIIlIlIIIIl.getValue());
            lllIlIIlIIllIlI.put("Target", new IntArrayTag(UUIDIntArrayType.uuidToIntArray(lllIlIIlIlIIIII)));
        }
        else if (lllIlIIlIIllIII.equals("minecraft:skull") && lllIlIIlIIllIlI.get("Owner") instanceof CompoundTag) {
            final CompoundTag lllIlIIlIIlllIl = lllIlIIlIIllIlI.remove("Owner");
            final StringTag lllIlIIlIIlllII = lllIlIIlIIlllIl.remove("Id");
            if (lllIlIIlIIlllII != null) {
                final UUID lllIlIIlIIlllll = UUID.fromString(lllIlIIlIIlllII.getValue());
                lllIlIIlIIlllIl.put("Id", new IntArrayTag(UUIDIntArrayType.uuidToIntArray(lllIlIIlIIlllll)));
            }
            final CompoundTag lllIlIIlIIllIll = new CompoundTag();
            for (final Map.Entry<String, Tag> lllIlIIlIIllllI : lllIlIIlIIlllIl.entrySet()) {
                lllIlIIlIIllIll.put(lllIlIIlIIllllI.getKey(), lllIlIIlIIllllI.getValue());
            }
            lllIlIIlIIllIlI.put("SkullOwner", lllIlIIlIIllIll);
        }
    }
    
    public static void register(final Protocol1_16To1_15_2 lllIlIIlIlIlIll) {
        final BlockRewriter lllIlIIlIlIllII = new BlockRewriter(lllIlIIlIlIlIll, Type.POSITION1_14);
        lllIlIIlIlIllII.registerBlockAction(ClientboundPackets1_15.BLOCK_ACTION);
        lllIlIIlIlIllII.registerBlockChange(ClientboundPackets1_15.BLOCK_CHANGE);
        lllIlIIlIlIllII.registerMultiBlockChange(ClientboundPackets1_15.MULTI_BLOCK_CHANGE);
        lllIlIIlIlIllII.registerAcknowledgePlayerDigging(ClientboundPackets1_15.ACKNOWLEDGE_PLAYER_DIGGING);
        ((AbstractProtocol<ClientboundPackets1_15, C2, S1, S2>)lllIlIIlIlIlIll).registerClientbound(ClientboundPackets1_15.UPDATE_LIGHT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.handler(lllllllllllllIIllllllIIlllIlllII -> lllllllllllllIIllllllIIlllIlllII.write(Type.BOOLEAN, true));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_15, C2, S1, S2>)lllIlIIlIlIlIll).registerClientbound(ClientboundPackets1_15.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: aload_0         /* lllllllllllllIIllIllIllIIIIlIIIl */
                //     2: getfield        com/viaversion/viaversion/protocols/protocol1_16to1_15_2/packets/WorldPackets$2.val$protocol:Lcom/viaversion/viaversion/protocols/protocol1_16to1_15_2/Protocol1_16To1_15_2;
                //     5: invokedynamic   BootstrapMethod #2, handle:(Lcom/viaversion/viaversion/protocols/protocol1_16to1_15_2/Protocol1_16To1_15_2;)Lcom/viaversion/viaversion/api/protocol/remapper/PacketHandler;
                //    10: invokevirtual   com/viaversion/viaversion/protocols/protocol1_16to1_15_2/packets/WorldPackets$2.handler:(Lcom/viaversion/viaversion/api/protocol/remapper/PacketHandler;)V
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
        ((AbstractProtocol<ClientboundPackets1_15, C2, S1, S2>)lllIlIIlIlIlIll).registerClientbound(ClientboundPackets1_15.BLOCK_ENTITY_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                final Position lllllllllllllllIIllIllllIIIIlIlI;
                final short lllllllllllllllIIllIllllIIIIlIIl;
                final CompoundTag lllllllllllllllIIllIllllIIIIlIII;
                this.handler(lllllllllllllllIIllIllllIIIIIlll -> {
                    lllllllllllllllIIllIllllIIIIlIlI = lllllllllllllllIIllIllllIIIIIlll.passthrough(Type.POSITION1_14);
                    lllllllllllllllIIllIllllIIIIlIIl = lllllllllllllllIIllIllllIIIIIlll.passthrough((Type<Short>)Type.UNSIGNED_BYTE);
                    lllllllllllllllIIllIllllIIIIlIII = lllllllllllllllIIllIllllIIIIIlll.passthrough(Type.NBT);
                    handleBlockEntity(lllllllllllllllIIllIllllIIIIlIII);
                });
            }
        });
        lllIlIIlIlIllII.registerEffect(ClientboundPackets1_15.EFFECT, 1010, 2001);
    }
}
