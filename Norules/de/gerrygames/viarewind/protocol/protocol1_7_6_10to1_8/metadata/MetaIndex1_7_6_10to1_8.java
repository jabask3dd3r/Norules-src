package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.metadata;

import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_7_6_10.metadata.*;
import java.util.*;

public class MetaIndex1_7_6_10to1_8
{
    private static final /* synthetic */ HashMap<Pair<Entity1_10Types.EntityType, Integer>, MetaIndex1_8to1_7_6_10> metadataRewrites;
    
    private static Optional<MetaIndex1_8to1_7_6_10> getIndex(final Entity1_10Types.EntityType lllllllllllllIIIllIlIIIIlIlIlIll, final int lllllllllllllIIIllIlIIIIlIlIIlll) {
        final Pair lllllllllllllIIIllIlIIIIlIlIlIIl = new Pair((X)lllllllllllllIIIllIlIIIIlIlIlIll, (Y)lllllllllllllIIIllIlIIIIlIlIIlll);
        if (MetaIndex1_7_6_10to1_8.metadataRewrites.containsKey(lllllllllllllIIIllIlIIIIlIlIlIIl)) {
            return Optional.of(MetaIndex1_7_6_10to1_8.metadataRewrites.get(lllllllllllllIIIllIlIIIIlIlIlIIl));
        }
        return Optional.empty();
    }
    
    static {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/util/HashMap.<init>:()V
        //     7: putstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/metadata/MetaIndex1_7_6_10to1_8.metadataRewrites:Ljava/util/HashMap;
        //    10: invokestatic    de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.values:()[Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //    13: astore_0        /* lllllllllllllIIIllIlIIIIlIIlIlII */
        //    14: aload_0         /* lllllllllllllIIIllIlIIIIlIIlIlII */
        //    15: arraylength    
        //    16: istore_1        /* lllllllllllllIIIllIlIIIIlIIlIIll */
        //    17: iconst_0       
        //    18: istore_2        /* lllllllllllllIIIllIlIIIIlIIlIIlI */
        //    19: iload_2         /* lllllllllllllIIIllIlIIIIlIIlIIlI */
        //    20: iload_1         /* lllllllllllllIIIllIlIIIIlIIlIIll */
        //    21: if_icmpge       60
        //    24: aload_0         /* lllllllllllllIIIllIlIIIIlIIlIlII */
        //    25: iload_2         /* lllllllllllllIIIllIlIIIIlIIlIIlI */
        //    26: aaload         
        //    27: astore_3        /* lllllllllllllIIIllIlIIIIlIIlIIIl */
        //    28: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/metadata/MetaIndex1_7_6_10to1_8.metadataRewrites:Ljava/util/HashMap;
        //    31: new             Lcom/viaversion/viaversion/util/Pair;
        //    34: dup            
        //    35: aload_3         /* lllllllllllllIIIllIlIIIIlIIlIlIl */
        //    36: invokevirtual   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.getClazz:()Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //    39: aload_3         /* lllllllllllllIIIllIlIIIIlIIlIlIl */
        //    40: invokevirtual   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.getNewIndex:()I
        //    43: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    46: invokespecial   com/viaversion/viaversion/util/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //    49: aload_3         /* lllllllllllllIIIllIlIIIIlIIlIlIl */
        //    50: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    53: pop            
        //    54: iinc            lllllllllllllIIIllIlIIIIlIIlIIlI, 1
        //    57: goto            19
        //    60: return         
        //    StackMapTable: 00 02 FE 00 13 07 00 60 01 01 28
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.assembler.ir.StackMappingVisitor.push(StackMappingVisitor.java:290)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:833)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2030)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
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
    
    public static MetaIndex1_8to1_7_6_10 searchIndex(final Entity1_10Types.EntityType lllllllllllllIIIllIlIIIIlIIlllIl, final int lllllllllllllIIIllIlIIIIlIIlllll) {
        Entity1_10Types.EntityType lllllllllllllIIIllIlIIIIlIIllllI = lllllllllllllIIIllIlIIIIlIIlllIl;
        do {
            final Optional<MetaIndex1_8to1_7_6_10> lllllllllllllIIIllIlIIIIlIlIIIIl = getIndex(lllllllllllllIIIllIlIIIIlIIllllI, lllllllllllllIIIllIlIIIIlIIlllll);
            if (lllllllllllllIIIllIlIIIIlIlIIIIl.isPresent()) {
                return lllllllllllllIIIllIlIIIIlIlIIIIl.get();
            }
            lllllllllllllIIIllIlIIIIlIIllllI = lllllllllllllIIIllIlIIIIlIIllllI.getParent();
        } while (lllllllllllllIIIllIlIIIIlIIllllI != null);
        return null;
    }
}
