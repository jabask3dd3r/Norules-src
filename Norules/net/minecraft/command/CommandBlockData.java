package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;

public class CommandBlockData extends CommandBase
{
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIlIIlIIIllIlIIlIlIl, final ICommandSender lllllllllllllIlIIlIIIllIlIIlIlII, final String[] lllllllllllllIlIIlIIIllIlIIlIIIl, @Nullable final BlockPos lllllllllllllIlIIlIIIllIlIIlIIlI) {
        return (lllllllllllllIlIIlIIIllIlIIlIIIl.length > 0 && lllllllllllllIlIIlIIIllIlIIlIIIl.length <= 3) ? CommandBase.getTabCompletionCoordinate(lllllllllllllIlIIlIIIllIlIIlIIIl, 0, lllllllllllllIlIIlIIIllIlIIlIIlI) : Collections.emptyList();
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIlIIlIIIllIlIlIllll, final ICommandSender lllllllllllllIlIIlIIIllIlIlIIIlI, final String[] lllllllllllllIlIIlIIIllIlIlIllIl) throws CommandException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: arraylength    
        //     2: iconst_4       
        //     3: if_icmpge       20
        //     6: new             Lnet/minecraft/command/WrongUsageException;
        //     9: dup            
        //    10: ldc             "commands.blockdata.usage"
        //    12: iconst_0       
        //    13: anewarray       Ljava/lang/Object;
        //    16: invokespecial   net/minecraft/command/WrongUsageException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //    19: athrow         
        //    20: aload_2         /* lllllllllllllIlIIlIIIllIlIlIlllI */
        //    21: getstatic       net/minecraft/command/CommandResultStats$Type.AFFECTED_BLOCKS:Lnet/minecraft/command/CommandResultStats$Type;
        //    24: iconst_0       
        //    25: invokeinterface net/minecraft/command/ICommandSender.setCommandStat:(Lnet/minecraft/command/CommandResultStats$Type;I)V
        //    30: aload_2         /* lllllllllllllIlIIlIIIllIlIlIlllI */
        //    31: aload_3         /* lllllllllllllIlIIlIIIllIlIlIIIIl */
        //    32: iconst_0       
        //    33: iconst_0       
        //    34: invokestatic    net/minecraft/command/CommandBlockData.parseBlockPos:(Lnet/minecraft/command/ICommandSender;[Ljava/lang/String;IZ)Lnet/minecraft/util/math/BlockPos;
        //    37: astore          lllllllllllllIlIIlIIIllIlIlIllII
        //    39: aload_2         /* lllllllllllllIlIIlIIIllIlIlIlllI */
        //    40: invokeinterface net/minecraft/command/ICommandSender.getEntityWorld:()Lnet/minecraft/world/World;
        //    45: astore          lllllllllllllIlIIlIIIllIlIlIlIll
        //    47: aload           lllllllllllllIlIIlIIIllIlIlIlIll
        //    49: aload           lllllllllllllIlIIlIIIllIlIlIllII
        //    51: invokevirtual   net/minecraft/world/World.isBlockLoaded:(Lnet/minecraft/util/math/BlockPos;)Z
        //    54: ifne            71
        //    57: new             Lnet/minecraft/command/CommandException;
        //    60: dup            
        //    61: ldc             "commands.blockdata.outOfWorld"
        //    63: iconst_0       
        //    64: anewarray       Ljava/lang/Object;
        //    67: invokespecial   net/minecraft/command/CommandException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //    70: athrow         
        //    71: aload           lllllllllllllIlIIlIIIllIlIlIlIll
        //    73: aload           lllllllllllllIlIIlIIIllIlIlIllII
        //    75: invokevirtual   net/minecraft/world/World.getBlockState:(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/state/IBlockState;
        //    78: astore          lllllllllllllIlIIlIIIllIlIlIlIlI
        //    80: aload           lllllllllllllIlIIlIIIllIlIlIlIll
        //    82: aload           lllllllllllllIlIIlIIIllIlIlIllII
        //    84: invokevirtual   net/minecraft/world/World.getTileEntity:(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/tileentity/TileEntity;
        //    87: astore          lllllllllllllIlIIlIIIllIlIlIlIIl
        //    89: aload           lllllllllllllIlIIlIIIllIlIlIlIIl
        //    91: ifnonnull       108
        //    94: new             Lnet/minecraft/command/CommandException;
        //    97: dup            
        //    98: ldc             "commands.blockdata.notValid"
        //   100: iconst_0       
        //   101: anewarray       Ljava/lang/Object;
        //   104: invokespecial   net/minecraft/command/CommandException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   107: athrow         
        //   108: aload           lllllllllllllIlIIlIIIllIlIlIlIIl
        //   110: new             Lnet/minecraft/nbt/NBTTagCompound;
        //   113: dup            
        //   114: invokespecial   net/minecraft/nbt/NBTTagCompound.<init>:()V
        //   117: invokevirtual   net/minecraft/tileentity/TileEntity.writeToNBT:(Lnet/minecraft/nbt/NBTTagCompound;)Lnet/minecraft/nbt/NBTTagCompound;
        //   120: astore          lllllllllllllIlIIlIIIllIlIlIlIII
        //   122: aload           lllllllllllllIlIIlIIIllIlIlIlIII
        //   124: invokevirtual   net/minecraft/nbt/NBTTagCompound.copy:()Lnet/minecraft/nbt/NBTTagCompound;
        //   127: astore          lllllllllllllIlIIlIIIllIlIlIIlll
        //   129: aload_3         /* lllllllllllllIlIIlIIIllIlIlIIIIl */
        //   130: iconst_3       
        //   131: invokestatic    net/minecraft/command/CommandBlockData.buildString:([Ljava/lang/String;I)Ljava/lang/String;
        //   134: invokestatic    net/minecraft/nbt/JsonToNBT.getTagFromJson:(Ljava/lang/String;)Lnet/minecraft/nbt/NBTTagCompound;
        //   137: astore          lllllllllllllIlIIlIIIllIlIlIIllI
        //   139: goto            166
        //   142: astore          lllllllllllllIlIIlIIIllIlIlIIlII
        //   144: new             Lnet/minecraft/command/CommandException;
        //   147: dup            
        //   148: ldc             "commands.blockdata.tagError"
        //   150: iconst_1       
        //   151: anewarray       Ljava/lang/Object;
        //   154: dup            
        //   155: iconst_0       
        //   156: aload           lllllllllllllIlIIlIIIllIlIlIIlII
        //   158: invokevirtual   net/minecraft/nbt/NBTException.getMessage:()Ljava/lang/String;
        //   161: aastore        
        //   162: invokespecial   net/minecraft/command/CommandException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   165: athrow         
        //   166: aload           lllllllllllllIlIIlIIIllIlIlIlIII
        //   168: aload           lllllllllllllIlIIlIIIllIlIlIIlIl
        //   170: invokevirtual   net/minecraft/nbt/NBTTagCompound.merge:(Lnet/minecraft/nbt/NBTTagCompound;)V
        //   173: aload           lllllllllllllIlIIlIIIllIlIlIlIII
        //   175: ldc             "x"
        //   177: aload           lllllllllllllIlIIlIIIllIlIlIllII
        //   179: invokevirtual   net/minecraft/util/math/BlockPos.getX:()I
        //   182: invokevirtual   net/minecraft/nbt/NBTTagCompound.setInteger:(Ljava/lang/String;I)V
        //   185: aload           lllllllllllllIlIIlIIIllIlIlIlIII
        //   187: ldc             "y"
        //   189: aload           lllllllllllllIlIIlIIIllIlIlIllII
        //   191: invokevirtual   net/minecraft/util/math/BlockPos.getY:()I
        //   194: invokevirtual   net/minecraft/nbt/NBTTagCompound.setInteger:(Ljava/lang/String;I)V
        //   197: aload           lllllllllllllIlIIlIIIllIlIlIlIII
        //   199: ldc             "z"
        //   201: aload           lllllllllllllIlIIlIIIllIlIlIllII
        //   203: invokevirtual   net/minecraft/util/math/BlockPos.getZ:()I
        //   206: invokevirtual   net/minecraft/nbt/NBTTagCompound.setInteger:(Ljava/lang/String;I)V
        //   209: aload           lllllllllllllIlIIlIIIllIlIlIlIII
        //   211: aload           lllllllllllllIlIIlIIIllIlIlIIlll
        //   213: invokevirtual   net/minecraft/nbt/NBTTagCompound.equals:(Ljava/lang/Object;)Z
        //   216: ifeq            241
        //   219: new             Lnet/minecraft/command/CommandException;
        //   222: dup            
        //   223: ldc             "commands.blockdata.failed"
        //   225: iconst_1       
        //   226: anewarray       Ljava/lang/Object;
        //   229: dup            
        //   230: iconst_0       
        //   231: aload           lllllllllllllIlIIlIIIllIlIlIlIII
        //   233: invokevirtual   net/minecraft/nbt/NBTTagCompound.toString:()Ljava/lang/String;
        //   236: aastore        
        //   237: invokespecial   net/minecraft/command/CommandException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   240: athrow         
        //   241: aload           lllllllllllllIlIIlIIIllIlIlIlIIl
        //   243: aload           lllllllllllllIlIIlIIIllIlIlIlIII
        //   245: invokevirtual   net/minecraft/tileentity/TileEntity.readFromNBT:(Lnet/minecraft/nbt/NBTTagCompound;)V
        //   248: aload           lllllllllllllIlIIlIIIllIlIlIlIIl
        //   250: invokevirtual   net/minecraft/tileentity/TileEntity.markDirty:()V
        //   253: aload           lllllllllllllIlIIlIIIllIlIlIlIll
        //   255: aload           lllllllllllllIlIIlIIIllIlIlIllII
        //   257: aload           lllllllllllllIlIIlIIIllIlIlIlIlI
        //   259: aload           lllllllllllllIlIIlIIIllIlIlIlIlI
        //   261: iconst_3       
        //   262: invokevirtual   net/minecraft/world/World.notifyBlockUpdate:(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/block/state/IBlockState;I)V
        //   265: aload_2         /* lllllllllllllIlIIlIIIllIlIlIlllI */
        //   266: getstatic       net/minecraft/command/CommandResultStats$Type.AFFECTED_BLOCKS:Lnet/minecraft/command/CommandResultStats$Type;
        //   269: iconst_1       
        //   270: invokeinterface net/minecraft/command/ICommandSender.setCommandStat:(Lnet/minecraft/command/CommandResultStats$Type;I)V
        //   275: aload_2         /* lllllllllllllIlIIlIIIllIlIlIlllI */
        //   276: aload_0         /* lllllllllllllIlIIlIIIllIlIllIIII */
        //   277: ldc             "commands.blockdata.success"
        //   279: iconst_1       
        //   280: anewarray       Ljava/lang/Object;
        //   283: dup            
        //   284: iconst_0       
        //   285: aload           lllllllllllllIlIIlIIIllIlIlIlIII
        //   287: invokevirtual   net/minecraft/nbt/NBTTagCompound.toString:()Ljava/lang/String;
        //   290: aastore        
        //   291: invokestatic    net/minecraft/command/CommandBlockData.notifyCommandListener:(Lnet/minecraft/command/ICommandSender;Lnet/minecraft/command/ICommand;Ljava/lang/String;[Ljava/lang/Object;)V
        //   294: return         
        //    Exceptions:
        //  throws net.minecraft.command.CommandException
        //    StackMapTable: 00 06 14 FD 00 32 07 00 83 07 00 4B FD 00 24 07 00 D2 07 00 63 FF 00 21 00 0A 07 00 02 07 00 D4 07 00 3D 07 00 D5 07 00 83 07 00 4B 07 00 D2 07 00 63 07 00 5E 07 00 5E 00 01 07 00 2D FC 00 17 07 00 5E FB 00 4A
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  129    139    142    166    Lnet/minecraft/nbt/NBTException;
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
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIlIIlIIIllIlIllllII) {
        return "commands.blockdata.usage";
    }
    
    @Override
    public String getCommandName() {
        return "blockdata";
    }
}
