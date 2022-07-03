package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import net.minecraft.network.play.server.*;
import java.util.*;
import org.apache.logging.log4j.*;

public class CommandTitle extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllllIllIlIlllIlIIllI) {
        return "commands.title.usage";
    }
    
    @Override
    public String getCommandName() {
        return "title";
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllllIllIlIlllIIIlIlI, final ICommandSender llllllllllllllllIllIlIlllIIIlIIl, final String[] llllllllllllllllIllIlIlllIIllIII) throws CommandException {
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
        //    10: ldc             "commands.title.usage"
        //    12: iconst_0       
        //    13: anewarray       Ljava/lang/Object;
        //    16: invokespecial   net/minecraft/command/WrongUsageException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //    19: athrow         
        //    20: aload_3         /* llllllllllllllllIllIlIlllIIIlIII */
        //    21: arraylength    
        //    22: iconst_3       
        //    23: if_icmpge       98
        //    26: ldc             "title"
        //    28: aload_3         /* llllllllllllllllIllIlIlllIIIlIII */
        //    29: iconst_1       
        //    30: aaload         
        //    31: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    34: ifne            59
        //    37: ldc             "subtitle"
        //    39: aload_3         /* llllllllllllllllIllIlIlllIIIlIII */
        //    40: iconst_1       
        //    41: aaload         
        //    42: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    45: ifne            59
        //    48: ldc             "actionbar"
        //    50: aload_3         /* llllllllllllllllIllIlIlllIIIlIII */
        //    51: iconst_1       
        //    52: aaload         
        //    53: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    56: ifeq            73
        //    59: new             Lnet/minecraft/command/WrongUsageException;
        //    62: dup            
        //    63: ldc             "commands.title.usage.title"
        //    65: iconst_0       
        //    66: anewarray       Ljava/lang/Object;
        //    69: invokespecial   net/minecraft/command/WrongUsageException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //    72: athrow         
        //    73: ldc             "times"
        //    75: aload_3         /* llllllllllllllllIllIlIlllIIIlIII */
        //    76: iconst_1       
        //    77: aaload         
        //    78: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    81: ifeq            98
        //    84: new             Lnet/minecraft/command/WrongUsageException;
        //    87: dup            
        //    88: ldc             "commands.title.usage.times"
        //    90: iconst_0       
        //    91: anewarray       Ljava/lang/Object;
        //    94: invokespecial   net/minecraft/command/WrongUsageException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //    97: athrow         
        //    98: aload_1         /* llllllllllllllllIllIlIlllIIllIlI */
        //    99: aload_2         /* llllllllllllllllIllIlIlllIIllIIl */
        //   100: aload_3         /* llllllllllllllllIllIlIlllIIIlIII */
        //   101: iconst_0       
        //   102: aaload         
        //   103: invokestatic    net/minecraft/command/CommandTitle.getPlayer:(Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/command/ICommandSender;Ljava/lang/String;)Lnet/minecraft/entity/player/EntityPlayerMP;
        //   106: astore          llllllllllllllllIllIlIlllIIlIlll
        //   108: aload_3         /* llllllllllllllllIllIlIlllIIIlIII */
        //   109: iconst_1       
        //   110: aaload         
        //   111: invokestatic    net/minecraft/network/play/server/SPacketTitle$Type.byName:(Ljava/lang/String;)Lnet/minecraft/network/play/server/SPacketTitle$Type;
        //   114: astore          llllllllllllllllIllIlIlllIIlIllI
        //   116: aload           llllllllllllllllIllIlIlllIIlIllI
        //   118: getstatic       net/minecraft/network/play/server/SPacketTitle$Type.CLEAR:Lnet/minecraft/network/play/server/SPacketTitle$Type;
        //   121: if_acmpeq       311
        //   124: aload           llllllllllllllllIllIlIlllIIlIllI
        //   126: getstatic       net/minecraft/network/play/server/SPacketTitle$Type.RESET:Lnet/minecraft/network/play/server/SPacketTitle$Type;
        //   129: if_acmpeq       311
        //   132: aload           llllllllllllllllIllIlIlllIIlIllI
        //   134: getstatic       net/minecraft/network/play/server/SPacketTitle$Type.TIMES:Lnet/minecraft/network/play/server/SPacketTitle$Type;
        //   137: if_acmpne       223
        //   140: aload_3         /* llllllllllllllllIllIlIlllIIIlIII */
        //   141: arraylength    
        //   142: iconst_5       
        //   143: if_icmpeq       160
        //   146: new             Lnet/minecraft/command/WrongUsageException;
        //   149: dup            
        //   150: ldc             "commands.title.usage"
        //   152: iconst_0       
        //   153: anewarray       Ljava/lang/Object;
        //   156: invokespecial   net/minecraft/command/WrongUsageException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   159: athrow         
        //   160: aload_3         /* llllllllllllllllIllIlIlllIIIlIII */
        //   161: iconst_2       
        //   162: aaload         
        //   163: invokestatic    net/minecraft/command/CommandTitle.parseInt:(Ljava/lang/String;)I
        //   166: istore          llllllllllllllllIllIlIlllIIlIlIl
        //   168: aload_3         /* llllllllllllllllIllIlIlllIIIlIII */
        //   169: iconst_3       
        //   170: aaload         
        //   171: invokestatic    net/minecraft/command/CommandTitle.parseInt:(Ljava/lang/String;)I
        //   174: istore          llllllllllllllllIllIlIlllIIlIlII
        //   176: aload_3         /* llllllllllllllllIllIlIlllIIIlIII */
        //   177: iconst_4       
        //   178: aaload         
        //   179: invokestatic    net/minecraft/command/CommandTitle.parseInt:(Ljava/lang/String;)I
        //   182: istore          llllllllllllllllIllIlIlllIIlIIll
        //   184: new             Lnet/minecraft/network/play/server/SPacketTitle;
        //   187: dup            
        //   188: iload           llllllllllllllllIllIlIlllIIlIlIl
        //   190: iload           llllllllllllllllIllIlIlllIIlIlII
        //   192: iload           llllllllllllllllIllIlIlllIIlIIll
        //   194: invokespecial   net/minecraft/network/play/server/SPacketTitle.<init>:(III)V
        //   197: astore          llllllllllllllllIllIlIlllIIlIIlI
        //   199: aload           llllllllllllllllIllIlIlllIIlIlll
        //   201: getfield        net/minecraft/entity/player/EntityPlayerMP.connection:Lnet/minecraft/network/NetHandlerPlayServer;
        //   204: aload           llllllllllllllllIllIlIlllIIlIIlI
        //   206: invokevirtual   net/minecraft/network/NetHandlerPlayServer.sendPacket:(Lnet/minecraft/network/Packet;)V
        //   209: aload_2         /* llllllllllllllllIllIlIlllIIllIIl */
        //   210: aload_0         /* llllllllllllllllIllIlIlllIIllIll */
        //   211: ldc             "commands.title.success"
        //   213: iconst_0       
        //   214: anewarray       Ljava/lang/Object;
        //   217: invokestatic    net/minecraft/command/CommandTitle.notifyCommandListener:(Lnet/minecraft/command/ICommandSender;Lnet/minecraft/command/ICommand;Ljava/lang/String;[Ljava/lang/Object;)V
        //   220: goto            364
        //   223: aload_3         /* llllllllllllllllIllIlIlllIIIlIII */
        //   224: arraylength    
        //   225: iconst_3       
        //   226: if_icmpge       243
        //   229: new             Lnet/minecraft/command/WrongUsageException;
        //   232: dup            
        //   233: ldc             "commands.title.usage"
        //   235: iconst_0       
        //   236: anewarray       Ljava/lang/Object;
        //   239: invokespecial   net/minecraft/command/WrongUsageException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   242: athrow         
        //   243: aload_3         /* llllllllllllllllIllIlIlllIIIlIII */
        //   244: iconst_2       
        //   245: invokestatic    net/minecraft/command/CommandTitle.buildString:([Ljava/lang/String;I)Ljava/lang/String;
        //   248: astore          llllllllllllllllIllIlIlllIIlIIIl
        //   250: aload           llllllllllllllllIllIlIlllIIlIIIl
        //   252: invokestatic    net/minecraft/util/text/ITextComponent$Serializer.jsonToComponent:(Ljava/lang/String;)Lnet/minecraft/util/text/ITextComponent;
        //   255: astore          llllllllllllllllIllIlIlllIIlIIII
        //   257: goto            268
        //   260: astore          llllllllllllllllIllIlIlllIIIlllI
        //   262: aload           llllllllllllllllIllIlIlllIIIlllI
        //   264: invokestatic    net/minecraft/command/CommandTitle.toSyntaxException:(Lcom/google/gson/JsonParseException;)Lnet/minecraft/command/SyntaxErrorException;
        //   267: athrow         
        //   268: new             Lnet/minecraft/network/play/server/SPacketTitle;
        //   271: dup            
        //   272: aload           llllllllllllllllIllIlIlllIIlIllI
        //   274: aload_2         /* llllllllllllllllIllIlIlllIIllIIl */
        //   275: aload           llllllllllllllllIllIlIlllIIIllll
        //   277: aload           llllllllllllllllIllIlIlllIIlIlll
        //   279: invokestatic    net/minecraft/util/text/TextComponentUtils.processComponent:(Lnet/minecraft/command/ICommandSender;Lnet/minecraft/util/text/ITextComponent;Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/text/ITextComponent;
        //   282: invokespecial   net/minecraft/network/play/server/SPacketTitle.<init>:(Lnet/minecraft/network/play/server/SPacketTitle$Type;Lnet/minecraft/util/text/ITextComponent;)V
        //   285: astore          llllllllllllllllIllIlIlllIIIllIl
        //   287: aload           llllllllllllllllIllIlIlllIIlIlll
        //   289: getfield        net/minecraft/entity/player/EntityPlayerMP.connection:Lnet/minecraft/network/NetHandlerPlayServer;
        //   292: aload           llllllllllllllllIllIlIlllIIIllIl
        //   294: invokevirtual   net/minecraft/network/NetHandlerPlayServer.sendPacket:(Lnet/minecraft/network/Packet;)V
        //   297: aload_2         /* llllllllllllllllIllIlIlllIIllIIl */
        //   298: aload_0         /* llllllllllllllllIllIlIlllIIllIll */
        //   299: ldc             "commands.title.success"
        //   301: iconst_0       
        //   302: anewarray       Ljava/lang/Object;
        //   305: invokestatic    net/minecraft/command/CommandTitle.notifyCommandListener:(Lnet/minecraft/command/ICommandSender;Lnet/minecraft/command/ICommand;Ljava/lang/String;[Ljava/lang/Object;)V
        //   308: goto            364
        //   311: aload_3         /* llllllllllllllllIllIlIlllIIIlIII */
        //   312: arraylength    
        //   313: iconst_2       
        //   314: if_icmpeq       331
        //   317: new             Lnet/minecraft/command/WrongUsageException;
        //   320: dup            
        //   321: ldc             "commands.title.usage"
        //   323: iconst_0       
        //   324: anewarray       Ljava/lang/Object;
        //   327: invokespecial   net/minecraft/command/WrongUsageException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   330: athrow         
        //   331: new             Lnet/minecraft/network/play/server/SPacketTitle;
        //   334: dup            
        //   335: aload           llllllllllllllllIllIlIlllIIlIllI
        //   337: aconst_null    
        //   338: invokespecial   net/minecraft/network/play/server/SPacketTitle.<init>:(Lnet/minecraft/network/play/server/SPacketTitle$Type;Lnet/minecraft/util/text/ITextComponent;)V
        //   341: astore          llllllllllllllllIllIlIlllIIIllII
        //   343: aload           llllllllllllllllIllIlIlllIIlIlll
        //   345: getfield        net/minecraft/entity/player/EntityPlayerMP.connection:Lnet/minecraft/network/NetHandlerPlayServer;
        //   348: aload           llllllllllllllllIllIlIlllIIIllII
        //   350: invokevirtual   net/minecraft/network/NetHandlerPlayServer.sendPacket:(Lnet/minecraft/network/Packet;)V
        //   353: aload_2         /* llllllllllllllllIllIlIlllIIllIIl */
        //   354: aload_0         /* llllllllllllllllIllIlIlllIIllIll */
        //   355: ldc             "commands.title.success"
        //   357: iconst_0       
        //   358: anewarray       Ljava/lang/Object;
        //   361: invokestatic    net/minecraft/command/CommandTitle.notifyCommandListener:(Lnet/minecraft/command/ICommandSender;Lnet/minecraft/command/ICommand;Ljava/lang/String;[Ljava/lang/Object;)V
        //   364: return         
        //    Exceptions:
        //  throws net.minecraft.command.CommandException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  250    257    260    268    Lcom/google/gson/JsonParseException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllllllIllIlIllIlllIllI, final int llllllllllllllllIllIlIllIlllIlIl) {
        return llllllllllllllllIllIlIllIlllIlIl == 0;
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllllllIllIlIllIllllIlI, final ICommandSender llllllllllllllllIllIlIllIlllllIl, final String[] llllllllllllllllIllIlIllIlllllII, @Nullable final BlockPos llllllllllllllllIllIlIllIllllIll) {
        if (llllllllllllllllIllIlIllIlllllII.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllllllIllIlIllIlllllII, llllllllllllllllIllIlIllIllllIlI.getAllUsernames());
        }
        return (llllllllllllllllIllIlIllIlllllII.length == 2) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllllIllIlIllIlllllII, SPacketTitle.Type.getNames()) : Collections.emptyList();
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
}
