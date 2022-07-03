package com.viaversion.viaversion.sponge.providers;

import com.viaversion.viaversion.protocols.protocol1_9to1_8.providers.*;

public class SpongeViaMovementTransmitter extends MovementTransmitterProvider
{
    private /* synthetic */ Object idlePacket;
    private /* synthetic */ Object idlePacket2;
    
    @Override
    public Object getFlyingPacket() {
        if (this.idlePacket == null) {
            throw new NullPointerException("Could not locate flying packet");
        }
        return this.idlePacket2;
    }
    
    @Override
    public Object getGroundPacket() {
        if (this.idlePacket == null) {
            throw new NullPointerException("Could not locate flying packet");
        }
        return this.idlePacket;
    }
    
    public SpongeViaMovementTransmitter() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   com/viaversion/viaversion/protocols/protocol1_9to1_8/providers/MovementTransmitterProvider.<init>:()V
        //     4: ldc             "net.minecraft.network.play.client.C03PacketPlayer"
        //     6: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //     9: astore_1        /* lllllllllllllIlIllllIlIIIllIIIlI */
        //    10: goto            15
        //    13: astore_2        /* lllllllllllllIlIllllIlIIIllIlIII */
        //    14: return         
        //    15: aload_0         /* lllllllllllllIlIllllIlIIIllIIIll */
        //    16: aload_1         /* lllllllllllllIlIllllIlIIIllIIlII */
        //    17: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
        //    20: putfield        com/viaversion/viaversion/sponge/providers/SpongeViaMovementTransmitter.idlePacket:Ljava/lang/Object;
        //    23: aload_0         /* lllllllllllllIlIllllIlIIIllIIIll */
        //    24: aload_1         /* lllllllllllllIlIllllIlIIIllIIlII */
        //    25: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
        //    28: putfield        com/viaversion/viaversion/sponge/providers/SpongeViaMovementTransmitter.idlePacket2:Ljava/lang/Object;
        //    31: aload_1         /* lllllllllllllIlIllllIlIIIllIIlII */
        //    32: ldc             "field_149474_g"
        //    34: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //    37: astore_2        /* lllllllllllllIlIllllIlIIIllIIlll */
        //    38: aload_2         /* lllllllllllllIlIllllIlIIIllIIlll */
        //    39: iconst_1       
        //    40: invokevirtual   java/lang/reflect/Field.setAccessible:(Z)V
        //    43: aload_2         /* lllllllllllllIlIllllIlIIIllIIlll */
        //    44: aload_0         /* lllllllllllllIlIllllIlIIIllIIIll */
        //    45: getfield        com/viaversion/viaversion/sponge/providers/SpongeViaMovementTransmitter.idlePacket2:Ljava/lang/Object;
        //    48: iconst_1       
        //    49: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //    52: invokevirtual   java/lang/reflect/Field.set:(Ljava/lang/Object;Ljava/lang/Object;)V
        //    55: goto            70
        //    58: astore_2        /* lllllllllllllIlIllllIlIIIllIIllI */
        //    59: new             Ljava/lang/RuntimeException;
        //    62: dup            
        //    63: ldc             "Couldn't make player idle packet, help!"
        //    65: aload_2         /* lllllllllllllIlIllllIlIIIllIIllI */
        //    66: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //    69: athrow         
        //    70: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  4      10     13     15     Ljava/lang/ClassNotFoundException;
        //  15     55     58     70     Ljava/lang/NoSuchFieldException;
        //  15     55     58     70     Ljava/lang/InstantiationException;
        //  15     55     58     70     Ljava/lang/IllegalArgumentException;
        //  15     55     58     70     Ljava/lang/IllegalAccessException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:713)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:549)
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
}
