package com.viaversion.viaversion.rewriter;

import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.data.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.entities.*;

public class TagRewriter
{
    private final /* synthetic */ Map<RegistryType, List<TagData>> newTags;
    private final /* synthetic */ Protocol protocol;
    private static final /* synthetic */ int[] EMPTY_ARRAY;
    
    public PacketHandler getGenericHandler() {
        int llllllllllllllIIlIIIlllIllllIIll;
        int llllllllllllllIIlIIIlllIllllIllI;
        String llllllllllllllIIlIIIlllIlllllIII;
        RegistryType llllllllllllllIIlIIIlllIllllIlll;
        return llllllllllllllIIlIIIlllIllllIIIl -> {
            for (llllllllllllllIIlIIIlllIllllIIll = llllllllllllllIIlIIIlllIllllIIIl.passthrough((Type<Integer>)Type.VAR_INT), llllllllllllllIIlIIIlllIllllIllI = 0; llllllllllllllIIlIIIlllIllllIllI < llllllllllllllIIlIIIlllIllllIIll; ++llllllllllllllIIlIIIlllIllllIllI) {
                llllllllllllllIIlIIIlllIlllllIII = llllllllllllllIIlIIIlllIllllIIIl.passthrough(Type.STRING);
                if (llllllllllllllIIlIIIlllIlllllIII.startsWith("minecraft:")) {
                    llllllllllllllIIlIIIlllIlllllIII = llllllllllllllIIlIIIlllIlllllIII.substring(10);
                }
                llllllllllllllIIlIIIlllIllllIlll = RegistryType.getByKey(llllllllllllllIIlIIIlllIlllllIII);
                if (llllllllllllllIIlIIIlllIllllIlll != null) {
                    this.handle(llllllllllllllIIlIIIlllIllllIIIl, this.getRewriter(llllllllllllllIIlIIIlllIllllIlll), this.getNewTags(llllllllllllllIIlIIIlllIllllIlll));
                }
                else {
                    this.handle(llllllllllllllIIlIIIlllIllllIIIl, null, null);
                }
            }
        };
    }
    
    public void addTagRaw(final RegistryType llllllllllllllIIlIIIllllIlIlllII, final String llllllllllllllIIlIIIllllIlIllIll, final int... llllllllllllllIIlIIIllllIlIllIlI) {
        this.getOrComputeNewTags(llllllllllllllIIlIIIllllIlIlllII).add(new TagData(llllllllllllllIIlIIIllllIlIllIll, llllllllllllllIIlIIIllllIlIllIlI));
    }
    
    public void handle(final PacketWrapper llllllllllllllIIlIIIllllIIlIIllI, final IdRewriteFunction llllllllllllllIIlIIIllllIIlIIlIl, final List<TagData> llllllllllllllIIlIIIllllIIlIIlII) throws Exception {
        final int llllllllllllllIIlIIIllllIIlIIlll = llllllllllllllIIlIIIllllIIlIIllI.read((Type<Integer>)Type.VAR_INT);
        llllllllllllllIIlIIIllllIIlIIllI.write(Type.VAR_INT, (llllllllllllllIIlIIIllllIIlIIlII != null) ? (llllllllllllllIIlIIIllllIIlIIlll + llllllllllllllIIlIIIllllIIlIIlII.size()) : llllllllllllllIIlIIIllllIIlIIlll);
        for (int llllllllllllllIIlIIIllllIIlIllIl = 0; llllllllllllllIIlIIIllllIIlIllIl < llllllllllllllIIlIIIllllIIlIIlll; ++llllllllllllllIIlIIIllllIIlIllIl) {
            llllllllllllllIIlIIIllllIIlIIllI.passthrough(Type.STRING);
            final int[] llllllllllllllIIlIIIllllIIlIlllI = llllllllllllllIIlIIIllllIIlIIllI.read(Type.VAR_INT_ARRAY_PRIMITIVE);
            if (llllllllllllllIIlIIIllllIIlIIlIl != null) {
                final IntList llllllllllllllIIlIIIllllIIlIllll = new IntArrayList(llllllllllllllIIlIIIllllIIlIlllI.length);
                final int llllllllllllllIIlIIIllllIIIlllll = (Object)llllllllllllllIIlIIIllllIIlIlllI;
                final double llllllllllllllIIlIIIllllIIIllllI = llllllllllllllIIlIIIllllIIIlllll.length;
                for (final int llllllllllllllIIlIIIllllIIllIIII : llllllllllllllIIlIIIllllIIIlllll) {
                    final int llllllllllllllIIlIIIllllIIllIIIl = llllllllllllllIIlIIIllllIIlIIlIl.rewrite(llllllllllllllIIlIIIllllIIllIIII);
                    if (llllllllllllllIIlIIIllllIIllIIIl != -1) {
                        llllllllllllllIIlIIIllllIIlIllll.add(llllllllllllllIIlIIIllllIIllIIIl);
                    }
                }
                llllllllllllllIIlIIIllllIIlIIllI.write(Type.VAR_INT_ARRAY_PRIMITIVE, llllllllllllllIIlIIIllllIIlIllll.toArray(TagRewriter.EMPTY_ARRAY));
            }
            else {
                llllllllllllllIIlIIIllllIIlIIllI.write(Type.VAR_INT_ARRAY_PRIMITIVE, llllllllllllllIIlIIIllllIIlIlllI);
            }
        }
        if (llllllllllllllIIlIIIllllIIlIIlII != null) {
            for (final TagData llllllllllllllIIlIIIllllIIlIllII : llllllllllllllIIlIIIllllIIlIIlII) {
                llllllllllllllIIlIIIllllIIlIIllI.write(Type.STRING, llllllllllllllIIlIIIllllIIlIllII.identifier());
                llllllllllllllIIlIIIllllIIlIIllI.write(Type.VAR_INT_ARRAY_PRIMITIVE, llllllllllllllIIlIIIllllIIlIllII.entries());
            }
        }
    }
    
    public TagRewriter(final Protocol llllllllllllllIIlIIIlllllIlllIII) {
        this.newTags = new EnumMap<RegistryType, List<TagData>>(RegistryType.class);
        this.protocol = llllllllllllllIIlIIIlllllIlllIII;
    }
    
    public void register(final ClientboundPacketType llllllllllllllIIlIIIllllIlIlIIIl, final RegistryType llllllllllllllIIlIIIllllIlIIllIl) {
        this.protocol.registerClientbound(llllllllllllllIIlIIIllllIlIlIIIl, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(TagRewriter.this.getHandler(llllllllllllllIIlIIIllllIlIIllIl));
            }
        });
    }
    
    public void addEmptyTag(final RegistryType llllllllllllllIIlIIIlllllIlIIIlI, final String llllllllllllllIIlIIIlllllIIllllI) {
        this.getOrComputeNewTags(llllllllllllllIIlIIIlllllIlIIIlI).add(new TagData(llllllllllllllIIlIIIlllllIIllllI, TagRewriter.EMPTY_ARRAY));
    }
    
    public List<TagData> getNewTags(final RegistryType llllllllllllllIIlIIIllllIIIlIlIl) {
        return this.newTags.get(llllllllllllllIIlIIIllllIIIlIlIl);
    }
    
    static {
        EMPTY_ARRAY = new int[0];
    }
    
    public IdRewriteFunction getRewriter(final RegistryType llllllllllllllIIlIIIllllIIIIlIlI) {
        final MappingData llllllllllllllIIlIIIllllIIIIlIIl = this.protocol.getMappingData();
        switch (llllllllllllllIIlIIIllllIIIIlIlI) {
            case BLOCK: {
                IdRewriteFunction idRewriteFunction;
                if (llllllllllllllIIlIIIllllIIIIlIIl != null && llllllllllllllIIlIIIllllIIIIlIIl.getBlockMappings() != null) {
                    final MappingData mappingData = llllllllllllllIIlIIIllllIIIIlIIl;
                    Objects.requireNonNull(mappingData);
                    idRewriteFunction = mappingData::getNewBlockId;
                }
                else {
                    idRewriteFunction = null;
                }
                return idRewriteFunction;
            }
            case ITEM: {
                IdRewriteFunction idRewriteFunction2;
                if (llllllllllllllIIlIIIllllIIIIlIIl != null && llllllllllllllIIlIIIllllIIIIlIIl.getItemMappings() != null) {
                    final MappingData mappingData2 = llllllllllllllIIlIIIllllIIIIlIIl;
                    Objects.requireNonNull(mappingData2);
                    idRewriteFunction2 = mappingData2::getNewItemId;
                }
                else {
                    idRewriteFunction2 = null;
                }
                return idRewriteFunction2;
            }
            case ENTITY: {
                return (this.protocol.getEntityRewriter() != null) ? (llllllllllllllIIlIIIllllIIIIIIII -> this.protocol.getEntityRewriter().newEntityId(llllllllllllllIIlIIIllllIIIIIIII)) : null;
            }
            default: {
                return null;
            }
        }
    }
    
    public void loadFromMappingData() {
        final short llllllllllllllIIlIIIlllllIlIlIll = (Object)RegistryType.getValues();
        final double llllllllllllllIIlIIIlllllIlIlIlI = llllllllllllllIIlIIIlllllIlIlIll.length;
        for (short llllllllllllllIIlIIIlllllIlIlIIl = 0; llllllllllllllIIlIIIlllllIlIlIIl < llllllllllllllIIlIIIlllllIlIlIlI; ++llllllllllllllIIlIIIlllllIlIlIIl) {
            final RegistryType llllllllllllllIIlIIIlllllIlIlllI = llllllllllllllIIlIIIlllllIlIlIll[llllllllllllllIIlIIIlllllIlIlIIl];
            final List<TagData> llllllllllllllIIlIIIlllllIlIllll = this.protocol.getMappingData().getTags(llllllllllllllIIlIIIlllllIlIlllI);
            if (llllllllllllllIIlIIIlllllIlIllll != null) {
                this.getOrComputeNewTags(llllllllllllllIIlIIIlllllIlIlllI).addAll(llllllllllllllIIlIIIlllllIlIllll);
            }
        }
    }
    
    public void addEmptyTags(final RegistryType llllllllllllllIIlIIIlllllIIIllll, final String... llllllllllllllIIlIIIlllllIIIlllI) {
        final List<TagData> llllllllllllllIIlIIIlllllIIlIIIl = this.getOrComputeNewTags(llllllllllllllIIlIIIlllllIIIllll);
        final float llllllllllllllIIlIIIlllllIIIllII = (Object)llllllllllllllIIlIIIlllllIIIlllI;
        final byte llllllllllllllIIlIIIlllllIIIlIll = (byte)llllllllllllllIIlIIIlllllIIIllII.length;
        for (Exception llllllllllllllIIlIIIlllllIIIlIlI = (Exception)0; llllllllllllllIIlIIIlllllIIIlIlI < llllllllllllllIIlIIIlllllIIIlIll; ++llllllllllllllIIlIIIlllllIIIlIlI) {
            final String llllllllllllllIIlIIIlllllIIlIlIl = llllllllllllllIIlIIIlllllIIIllII[llllllllllllllIIlIIIlllllIIIlIlI];
            llllllllllllllIIlIIIlllllIIlIIIl.add(new TagData(llllllllllllllIIlIIIlllllIIlIlIl, TagRewriter.EMPTY_ARRAY));
        }
    }
    
    public void addTag(final RegistryType llllllllllllllIIlIIIllllIllIlIII, final String llllllllllllllIIlIIIllllIllIIlll, final int... llllllllllllllIIlIIIllllIllIllII) {
        final List<TagData> llllllllllllllIIlIIIllllIllIlIll = this.getOrComputeNewTags(llllllllllllllIIlIIIllllIllIlIII);
        final IdRewriteFunction llllllllllllllIIlIIIllllIllIlIlI = this.getRewriter(llllllllllllllIIlIIIllllIllIlIII);
        for (int llllllllllllllIIlIIIllllIlllIIII = 0; llllllllllllllIIlIIIllllIlllIIII < llllllllllllllIIlIIIllllIllIllII.length; ++llllllllllllllIIlIIIllllIlllIIII) {
            final int llllllllllllllIIlIIIllllIlllIIIl = llllllllllllllIIlIIIllllIllIllII[llllllllllllllIIlIIIllllIlllIIII];
            llllllllllllllIIlIIIllllIllIllII[llllllllllllllIIlIIIllllIlllIIII] = llllllllllllllIIlIIIllllIllIlIlI.rewrite(llllllllllllllIIlIIIllllIlllIIIl);
        }
        llllllllllllllIIlIIIllllIllIlIll.add(new TagData(llllllllllllllIIlIIIllllIllIIlll, llllllllllllllIIlIIIllllIllIllII));
    }
    
    public PacketHandler getHandler(final RegistryType llllllllllllllIIlIIIllllIlIIIIll) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1         /* llllllllllllllIIlIIIllllIlIIIIIl */
        //     2: invokedynamic   BootstrapMethod #4, handle:(Lcom/viaversion/viaversion/rewriter/TagRewriter;Lcom/viaversion/viaversion/api/minecraft/RegistryType;)Lcom/viaversion/viaversion/api/protocol/remapper/PacketHandler;
        //     7: areturn        
        //    RuntimeVisibleTypeAnnotations: 00 01 16 00 00 00 72 00 00
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.assembler.ir.StackMappingVisitor.push(StackMappingVisitor.java:290)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:833)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2030)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.ast.AstOptimizer$InlineLambdasOptimization.tryInlineLambda(AstOptimizer.java:3600)
        //     at com.strobel.decompiler.ast.AstOptimizer$InlineLambdasOptimization.run(AstOptimizer.java:3488)
        //     at com.strobel.decompiler.ast.AstOptimizer.runOptimization(AstOptimizer.java:3876)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:220)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
    
    public void addEntityTag(final String llllllllllllllIIlIIIlllllIIIIIIl, final EntityType... llllllllllllllIIlIIIlllllIIIIIII) {
        final int[] llllllllllllllIIlIIIllllIlllllll = new int[llllllllllllllIIlIIIlllllIIIIIII.length];
        for (int llllllllllllllIIlIIIlllllIIIIIll = 0; llllllllllllllIIlIIIlllllIIIIIll < llllllllllllllIIlIIIlllllIIIIIII.length; ++llllllllllllllIIlIIIlllllIIIIIll) {
            llllllllllllllIIlIIIllllIlllllll[llllllllllllllIIlIIIlllllIIIIIll] = llllllllllllllIIlIIIlllllIIIIIII[llllllllllllllIIlIIIlllllIIIIIll].getId();
        }
        this.addTagRaw(RegistryType.ENTITY, llllllllllllllIIlIIIlllllIIIIIIl, llllllllllllllIIlIIIllllIlllllll);
    }
    
    public void registerGeneric(final ClientboundPacketType llllllllllllllIIlIIIllllIlIIlIIl) {
        this.protocol.registerClientbound(llllllllllllllIIlIIIllllIlIIlIIl, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(TagRewriter.this.getGenericHandler());
            }
        });
    }
    
    public List<TagData> getOrComputeNewTags(final RegistryType llllllllllllllIIlIIIllllIIIlIIIl) {
        return this.newTags.computeIfAbsent(llllllllllllllIIlIIIllllIIIlIIIl, llllllllllllllIIlIIIlllIllllllll -> new ArrayList());
    }
}
