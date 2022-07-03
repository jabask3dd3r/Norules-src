package net.minecraft.command;

import net.minecraft.server.*;

public class CommandEntityData extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandName() {
        return "entitydata";
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllllllIlIllIIlIllIIllll, final int lllllllllllllllIlIllIIlIllIIlllI) {
        return lllllllllllllllIlIllIIlIllIIlllI == 0;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllIlIllIIlIlllIllll) {
        return "commands.entitydata.usage";
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllllIlIllIIlIllIllIIl, final ICommandSender lllllllllllllllIlIllIIlIlllIIIll, final String[] lllllllllllllllIlIllIIlIlllIIIlI) throws CommandException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: arraylength    
        //     2: iconst_2       
        //     3: if_icmpge       20
        //     6: new             Lnet/minecraft/command/WrongUsageException;
        //     9: dup            
        //    10: ldc             "commands.entitydata.usage"
        //    12: iconst_0       
        //    13: anewarray       Ljava/lang/Object;
        //    16: invokespecial   net/minecraft/command/WrongUsageException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //    19: athrow         
        //    20: aload_1         /* lllllllllllllllIlIllIIlIlllIIlII */
        //    21: aload_2         /* lllllllllllllllIlIllIIlIllIllIII */
        //    22: aload_3         /* lllllllllllllllIlIllIIlIllIlIlll */
        //    23: iconst_0       
        //    24: aaload         
        //    25: invokestatic    net/minecraft/command/CommandEntityData.getEntity:(Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/command/ICommandSender;Ljava/lang/String;)Lnet/minecraft/entity/Entity;
        //    28: astore          lllllllllllllllIlIllIIlIlllIIIIl
        //    30: aload           lllllllllllllllIlIllIIlIlllIIIIl
        //    32: instanceof      Lnet/minecraft/entity/player/EntityPlayer;
        //    35: ifeq            60
        //    38: new             Lnet/minecraft/command/CommandException;
        //    41: dup            
        //    42: ldc             "commands.entitydata.noPlayers"
        //    44: iconst_1       
        //    45: anewarray       Ljava/lang/Object;
        //    48: dup            
        //    49: iconst_0       
        //    50: aload           lllllllllllllllIlIllIIlIlllIIIIl
        //    52: invokevirtual   net/minecraft/entity/Entity.getDisplayName:()Lnet/minecraft/util/text/ITextComponent;
        //    55: aastore        
        //    56: invokespecial   net/minecraft/command/CommandException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //    59: athrow         
        //    60: aload           lllllllllllllllIlIllIIlIlllIIIIl
        //    62: invokestatic    net/minecraft/command/CommandEntityData.entityToNBT:(Lnet/minecraft/entity/Entity;)Lnet/minecraft/nbt/NBTTagCompound;
        //    65: astore          lllllllllllllllIlIllIIlIlllIIIII
        //    67: aload           lllllllllllllllIlIllIIlIlllIIIII
        //    69: invokevirtual   net/minecraft/nbt/NBTTagCompound.copy:()Lnet/minecraft/nbt/NBTTagCompound;
        //    72: astore          lllllllllllllllIlIllIIlIllIlllll
        //    74: aload_3         /* lllllllllllllllIlIllIIlIllIlIlll */
        //    75: iconst_1       
        //    76: invokestatic    net/minecraft/command/CommandEntityData.buildString:([Ljava/lang/String;I)Ljava/lang/String;
        //    79: invokestatic    net/minecraft/nbt/JsonToNBT.getTagFromJson:(Ljava/lang/String;)Lnet/minecraft/nbt/NBTTagCompound;
        //    82: astore          lllllllllllllllIlIllIIlIllIllllI
        //    84: goto            111
        //    87: astore          lllllllllllllllIlIllIIlIllIlllII
        //    89: new             Lnet/minecraft/command/CommandException;
        //    92: dup            
        //    93: ldc             "commands.entitydata.tagError"
        //    95: iconst_1       
        //    96: anewarray       Ljava/lang/Object;
        //    99: dup            
        //   100: iconst_0       
        //   101: aload           lllllllllllllllIlIllIIlIllIlllII
        //   103: invokevirtual   net/minecraft/nbt/NBTException.getMessage:()Ljava/lang/String;
        //   106: aastore        
        //   107: invokespecial   net/minecraft/command/CommandException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   110: athrow         
        //   111: aload           lllllllllllllllIlIllIIlIlllIIIIl
        //   113: invokevirtual   net/minecraft/entity/Entity.getUniqueID:()Ljava/util/UUID;
        //   116: astore          lllllllllllllllIlIllIIlIllIllIll
        //   118: aload           lllllllllllllllIlIllIIlIlllIIIII
        //   120: aload           lllllllllllllllIlIllIIlIllIlllIl
        //   122: invokevirtual   net/minecraft/nbt/NBTTagCompound.merge:(Lnet/minecraft/nbt/NBTTagCompound;)V
        //   125: aload           lllllllllllllllIlIllIIlIlllIIIIl
        //   127: aload           lllllllllllllllIlIllIIlIllIllIll
        //   129: invokevirtual   net/minecraft/entity/Entity.setUniqueId:(Ljava/util/UUID;)V
        //   132: aload           lllllllllllllllIlIllIIlIlllIIIII
        //   134: aload           lllllllllllllllIlIllIIlIllIlllll
        //   136: invokevirtual   net/minecraft/nbt/NBTTagCompound.equals:(Ljava/lang/Object;)Z
        //   139: ifeq            164
        //   142: new             Lnet/minecraft/command/CommandException;
        //   145: dup            
        //   146: ldc             "commands.entitydata.failed"
        //   148: iconst_1       
        //   149: anewarray       Ljava/lang/Object;
        //   152: dup            
        //   153: iconst_0       
        //   154: aload           lllllllllllllllIlIllIIlIlllIIIII
        //   156: invokevirtual   net/minecraft/nbt/NBTTagCompound.toString:()Ljava/lang/String;
        //   159: aastore        
        //   160: invokespecial   net/minecraft/command/CommandException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   163: athrow         
        //   164: aload           lllllllllllllllIlIllIIlIlllIIIIl
        //   166: aload           lllllllllllllllIlIllIIlIlllIIIII
        //   168: invokevirtual   net/minecraft/entity/Entity.readFromNBT:(Lnet/minecraft/nbt/NBTTagCompound;)V
        //   171: aload_2         /* lllllllllllllllIlIllIIlIllIllIII */
        //   172: aload_0         /* lllllllllllllllIlIllIIlIlllIIlIl */
        //   173: ldc             "commands.entitydata.success"
        //   175: iconst_1       
        //   176: anewarray       Ljava/lang/Object;
        //   179: dup            
        //   180: iconst_0       
        //   181: aload           lllllllllllllllIlIllIIlIlllIIIII
        //   183: invokevirtual   net/minecraft/nbt/NBTTagCompound.toString:()Ljava/lang/String;
        //   186: aastore        
        //   187: invokestatic    net/minecraft/command/CommandEntityData.notifyCommandListener:(Lnet/minecraft/command/ICommandSender;Lnet/minecraft/command/ICommand;Ljava/lang/String;[Ljava/lang/Object;)V
        //   190: return         
        //    Exceptions:
        //  throws net.minecraft.command.CommandException
        //    StackMapTable: 00 05 14 FC 00 27 07 00 3C FF 00 1A 00 07 07 00 02 07 00 98 07 00 9A 07 00 9B 07 00 3C 07 00 47 07 00 47 00 01 07 00 2B FC 00 17 07 00 47 FC 00 34 07 00 9D
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  74     84     87     111    Lnet/minecraft/nbt/NBTException;
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
}
