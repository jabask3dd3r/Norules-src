package com.viaversion.viabackwards.protocol.protocol1_16_4to1_17;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.*;
import com.viaversion.viabackwards.api.data.*;
import com.viaversion.viaversion.protocols.protocol1_17to1_16_4.*;
import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.*;
import java.util.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viabackwards.protocol.protocol1_16_4to1_17.storage.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.data.entity.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viabackwards.protocol.protocol1_16_4to1_17.packets.*;
import com.viaversion.viaversion.api.data.*;
import com.viaversion.viaversion.api.protocol.*;

public final class Protocol1_16_4To1_17 extends BackwardsProtocol<ClientboundPackets1_17, ClientboundPackets1_16_2, ServerboundPackets1_17, ServerboundPackets1_16_2>
{
    private /* synthetic */ TranslatableRewriter translatableRewriter;
    private final /* synthetic */ EntityRewriter entityRewriter;
    private /* synthetic */ BlockItemPackets1_17 blockItemPackets;
    public static final /* synthetic */ BackwardsMappings MAPPINGS;
    
    static {
        MAPPINGS = new BackwardsMappings("1.17", "1.16.2", Protocol1_17To1_16_4.class, true);
        EMPTY_ARRAY = new int[0];
    }
    
    @Override
    protected void registerPackets() {
        final Class<Protocol1_17To1_16_4> llllllllllllllllllIIIlIlIllIllIl = Protocol1_17To1_16_4.class;
        final BackwardsMappings mappings = Protocol1_16_4To1_17.MAPPINGS;
        Objects.requireNonNull(mappings);
        this.executeAsyncAfterLoaded(llllllllllllllllllIIIlIlIllIllIl, mappings::load);
        this.translatableRewriter = new TranslatableRewriter(this);
        this.translatableRewriter.registerChatMessage(ClientboundPackets1_17.CHAT_MESSAGE);
        this.translatableRewriter.registerBossBar(ClientboundPackets1_17.BOSSBAR);
        this.translatableRewriter.registerDisconnect(ClientboundPackets1_17.DISCONNECT);
        this.translatableRewriter.registerTabList(ClientboundPackets1_17.TAB_LIST);
        this.translatableRewriter.registerOpenWindow(ClientboundPackets1_17.OPEN_WINDOW);
        this.translatableRewriter.registerPing();
        this.blockItemPackets = new BlockItemPackets1_17(this, this.translatableRewriter);
        this.blockItemPackets.register();
        this.entityRewriter.register();
        final SoundRewriter llllllllllllllIIllIlIIIlIIlIIlII = new SoundRewriter(this);
        llllllllllllllIIllIlIIIlIIlIIlII.registerSound(ClientboundPackets1_17.SOUND);
        llllllllllllllIIllIlIIIlIIlIIlII.registerSound(ClientboundPackets1_17.ENTITY_SOUND);
        llllllllllllllIIllIlIIIlIIlIIlII.registerNamedSound(ClientboundPackets1_17.NAMED_SOUND);
        llllllllllllllIIllIlIIIlIIlIIlII.registerStopSound(ClientboundPackets1_17.STOP_SOUND);
        final TagRewriter llllllllllllllIIllIlIIIlIIlIIIll = new TagRewriter(this);
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_17.TAGS, new PacketRemapper() {
            @Override
            public void registerMap() {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: aload_0         /* lllllllllllllIlIlIlIllIIIIllIllI */
                //     2: getfield        com/viaversion/viabackwards/protocol/protocol1_16_4to1_17/Protocol1_16_4To1_17$1.val$tagRewriter:Lcom/viaversion/viaversion/rewriter/TagRewriter;
                //     5: invokedynamic   BootstrapMethod #0, handle:(Lcom/viaversion/viaversion/rewriter/TagRewriter;)Lcom/viaversion/viaversion/api/protocol/remapper/PacketHandler;
                //    10: invokevirtual   com/viaversion/viabackwards/protocol/protocol1_16_4to1_17/Protocol1_16_4To1_17$1.handler:(Lcom/viaversion/viaversion/api/protocol/remapper/PacketHandler;)V
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
        new StatisticsRewriter(this).register(ClientboundPackets1_17.STATISTICS);
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_17.RESOURCE_PACK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(lllllllllllllIlllIIIIIIIlIIIllII -> {
                    lllllllllllllIlllIIIIIIIlIIIllII.passthrough(Type.STRING);
                    lllllllllllllIlllIIIIIIIlIIIllII.passthrough(Type.STRING);
                    lllllllllllllIlllIIIIIIIlIIIllII.read((Type<Object>)Type.BOOLEAN);
                    lllllllllllllIlllIIIIIIIlIIIllII.read(Type.OPTIONAL_COMPONENT);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_17.EXPLOSION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.handler(lllllllllllllIllIlIIIlIllIlIlllI -> lllllllllllllIllIlIIIlIllIlIlllI.write(Type.INT, (Integer)lllllllllllllIllIlIIIlIllIlIlllI.read((Type<T>)Type.VAR_INT)));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_17.SPAWN_POSITION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION1_14);
                this.handler(llllllllllllllIIlIIIlllIlIIIlIII -> llllllllllllllIIlIIIlllIlIIIlIII.read((Type<Object>)Type.FLOAT));
            }
        });
        ((Protocol<ClientboundPackets1_17, ClientboundPackets1_16_2, S1, S2>)this).registerClientbound(ClientboundPackets1_17.PING, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int lllllllllllllIIlIllIIIllllIllIII;
                final short lllllllllllllIIlIllIIIllllIlIlll;
                PacketWrapper lllllllllllllIIlIllIIIllllIllIlI;
                PacketWrapper lllllllllllllIIlIllIIIllllIlIllI;
                this.handler(lllllllllllllIIlIllIIIllllIlIlIl -> {
                    lllllllllllllIIlIllIIIllllIlIlIl.cancel();
                    lllllllllllllIIlIllIIIllllIllIII = lllllllllllllIIlIllIIIllllIlIlIl.read((Type<Integer>)Type.INT);
                    lllllllllllllIIlIllIIIllllIlIlll = (short)lllllllllllllIIlIllIIIllllIllIII;
                    if (lllllllllllllIIlIllIIIllllIllIII == lllllllllllllIIlIllIIIllllIlIlll && ViaBackwards.getConfig().handlePingsAsInvAcknowledgements()) {
                        lllllllllllllIIlIllIIIllllIlIlIl.user().get(PingRequests.class).addId(lllllllllllllIIlIllIIIllllIlIlll);
                        lllllllllllllIIlIllIIIllllIllIlI = lllllllllllllIIlIllIIIllllIlIlIl.create(ClientboundPackets1_16_2.WINDOW_CONFIRMATION);
                        lllllllllllllIIlIllIIIllllIllIlI.write(Type.UNSIGNED_BYTE, (Short)0);
                        lllllllllllllIIlIllIIIllllIllIlI.write(Type.SHORT, lllllllllllllIIlIllIIIllllIlIlll);
                        lllllllllllllIIlIllIIIllllIllIlI.write(Type.BOOLEAN, false);
                        lllllllllllllIIlIllIIIllllIllIlI.send(Protocol1_16_4To1_17.class);
                    }
                    else {
                        lllllllllllllIIlIllIIIllllIlIllI = lllllllllllllIIlIllIIIllllIlIlIl.create(ServerboundPackets1_17.PONG);
                        lllllllllllllIIlIllIIIllllIlIllI.write(Type.INT, lllllllllllllIIlIllIIIllllIllIII);
                        lllllllllllllIIlIllIIIllllIlIllI.sendToServer(Protocol1_16_4To1_17.class);
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_16_2>)this).registerServerbound(ServerboundPackets1_16_2.CLIENT_SETTINGS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.map(Type.BYTE);
                this.map(Type.VAR_INT);
                this.map(Type.BOOLEAN);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.VAR_INT);
                this.handler(lllllllllllllIIIIlIllIIlIIlIIlIl -> lllllllllllllIIIIlIllIIlIIlIIlIl.write(Type.BOOLEAN, false));
            }
        });
        this.mergePacket(ClientboundPackets1_17.TITLE_TEXT, ClientboundPackets1_16_2.TITLE, 0);
        this.mergePacket(ClientboundPackets1_17.TITLE_SUBTITLE, ClientboundPackets1_16_2.TITLE, 1);
        this.mergePacket(ClientboundPackets1_17.ACTIONBAR, ClientboundPackets1_16_2.TITLE, 2);
        this.mergePacket(ClientboundPackets1_17.TITLE_TIMES, ClientboundPackets1_16_2.TITLE, 3);
        ((Protocol<ClientboundPackets1_17, ClientboundPackets1_16_2, S1, S2>)this).registerClientbound(ClientboundPackets1_17.CLEAR_TITLES, ClientboundPackets1_16_2.TITLE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(llIlIIIIlIllII -> {
                    if (llIlIIIIlIllII.read((Type<Boolean>)Type.BOOLEAN)) {
                        llIlIIIIlIllII.write(Type.VAR_INT, 5);
                    }
                    else {
                        llIlIIIIlIllII.write(Type.VAR_INT, 4);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this).cancelClientbound(ClientboundPackets1_17.ADD_VIBRATION_SIGNAL);
    }
    
    public void mergePacket(final ClientboundPackets1_17 llllllllllllllIIllIlIIIlIIIIllII, final ClientboundPackets1_16_2 llllllllllllllIIllIlIIIlIIIIllll, final int llllllllllllllIIllIlIIIlIIIIlIlI) {
        ((Protocol<ClientboundPackets1_17, ClientboundPackets1_16_2, S1, S2>)this).registerClientbound(llllllllllllllIIllIlIIIlIIIIllII, llllllllllllllIIllIlIIIlIIIIllll, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(llllllllllllllIIIlllIllIIIIlIlll -> llllllllllllllIIIlllIllIIIIlIlll.write(Type.VAR_INT, llllllllllllllIIllIlIIIlIIIIlIlI));
            }
        });
    }
    
    @Override
    public EntityRewriter getEntityRewriter() {
        return this.entityRewriter;
    }
    
    @Override
    public void init(final UserConnection llllllllllllllIIllIlIIIlIIIllIlI) {
        this.addEntityTracker(llllllllllllllIIllIlIIIlIIIllIlI, new EntityTrackerBase(llllllllllllllIIllIlIIIlIIIllIlI, Entity1_17Types.PLAYER));
        llllllllllllllIIllIlIIIlIIIllIlI.put(new PingRequests());
    }
    
    @Override
    public BackwardsMappings getMappingData() {
        return Protocol1_16_4To1_17.MAPPINGS;
    }
    
    @Override
    public ItemRewriter getItemRewriter() {
        return this.blockItemPackets;
    }
    
    public Protocol1_16_4To1_17() {
        super(ClientboundPackets1_17.class, ClientboundPackets1_16_2.class, ServerboundPackets1_17.class, ServerboundPackets1_16_2.class);
        this.entityRewriter = new EntityPackets1_17(this);
    }
    
    @Override
    public TranslatableRewriter getTranslatableRewriter() {
        return this.translatableRewriter;
    }
}
