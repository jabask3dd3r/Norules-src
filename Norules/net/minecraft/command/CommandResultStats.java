package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.nbt.*;
import javax.annotation.*;

public class CommandResultStats
{
    private static final /* synthetic */ int NUM_RESULT_TYPES;
    private static final /* synthetic */ String[] STRING_RESULT_TYPES;
    private /* synthetic */ String[] objectives;
    private /* synthetic */ String[] entitiesID;
    
    public void readStatsFromNBT(final NBTTagCompound lllllllllllllIllIlllIllIIllIIIlI) {
        if (lllllllllllllIllIlllIllIIllIIIlI.hasKey("CommandStats", 10)) {
            final NBTTagCompound lllllllllllllIllIlllIllIIllIIIIl = lllllllllllllIllIlllIllIIllIIIlI.getCompoundTag("CommandStats");
            final short lllllllllllllIllIlllIllIIlIlIlIl;
            final float lllllllllllllIllIlllIllIIlIlIllI = ((Type[])(Object)(lllllllllllllIllIlllIllIIlIlIlIl = (short)(Object)Type.values())).length;
            for (long lllllllllllllIllIlllIllIIlIlIlll = 0; lllllllllllllIllIlllIllIIlIlIlll < lllllllllllllIllIlllIllIIlIlIllI; ++lllllllllllllIllIlllIllIIlIlIlll) {
                final Type lllllllllllllIllIlllIllIIllIIIII = lllllllllllllIllIlllIllIIlIlIlIl[lllllllllllllIllIlllIllIIlIlIlll];
                final String lllllllllllllIllIlllIllIIlIlllll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIllIlllIllIIllIIIII.getTypeName())).append("Name"));
                final String lllllllllllllIllIlllIllIIlIllllI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIllIlllIllIIllIIIII.getTypeName())).append("Objective"));
                if (lllllllllllllIllIlllIllIIllIIIIl.hasKey(lllllllllllllIllIlllIllIIlIlllll, 8) && lllllllllllllIllIlllIllIIllIIIIl.hasKey(lllllllllllllIllIlllIllIIlIllllI, 8)) {
                    final String lllllllllllllIllIlllIllIIlIlllIl = lllllllllllllIllIlllIllIIllIIIIl.getString(lllllllllllllIllIlllIllIIlIlllll);
                    final String lllllllllllllIllIlllIllIIlIlllII = lllllllllllllIllIlllIllIIllIIIIl.getString(lllllllllllllIllIlllIllIIlIllllI);
                    setScoreBoardStat(this, lllllllllllllIllIlllIllIIllIIIII, lllllllllllllIllIlllIllIIlIlllIl, lllllllllllllIllIlllIllIIlIlllII);
                }
            }
        }
    }
    
    public void addAllStats(final CommandResultStats lllllllllllllIllIlllIllIIIIlIIll) {
        final float lllllllllllllIllIlllIllIIIIIllII;
        final short lllllllllllllIllIlllIllIIIIIllIl = (short)((Type[])(Object)(lllllllllllllIllIlllIllIIIIIllII = (float)(Object)Type.values())).length;
        for (float lllllllllllllIllIlllIllIIIIIlllI = 0; lllllllllllllIllIlllIllIIIIIlllI < lllllllllllllIllIlllIllIIIIIllIl; ++lllllllllllllIllIlllIllIIIIIlllI) {
            final Type lllllllllllllIllIlllIllIIIIlIIlI = lllllllllllllIllIlllIllIIIIIllII[lllllllllllllIllIlllIllIIIIIlllI];
            setScoreBoardStat(this, lllllllllllllIllIlllIllIIIIlIIlI, lllllllllllllIllIlllIllIIIIlIIll.entitiesID[lllllllllllllIllIlllIllIIIIlIIlI.getTypeID()], lllllllllllllIllIlllIllIIIIlIIll.objectives[lllllllllllllIllIlllIllIIIIlIIlI.getTypeID()]);
        }
    }
    
    public void setCommandStatForSender(final MinecraftServer lllllllllllllIllIlllIllIIllllIIl, final ICommandSender lllllllllllllIllIlllIllIIllllIII, final Type lllllllllllllIllIlllIllIIlllIlll, final int lllllllllllllIllIlllIllIlIIIIlII) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/command/CommandResultStats.entitiesID:[Ljava/lang/String;
        //     4: aload_3         /* lllllllllllllIllIlllIllIlIIIIlIl */
        //     5: invokevirtual   net/minecraft/command/CommandResultStats$Type.getTypeID:()I
        //     8: aaload         
        //     9: astore          lllllllllllllIllIlllIllIlIIIIIll
        //    11: aload           lllllllllllllIllIlllIllIlIIIIIll
        //    13: ifnull          114
        //    16: new             Lnet/minecraft/command/CommandResultStats$1;
        //    19: dup            
        //    20: aload_0         /* lllllllllllllIllIlllIllIIllllIlI */
        //    21: aload_2         /* lllllllllllllIllIlllIllIlIIIIllI */
        //    22: invokespecial   net/minecraft/command/CommandResultStats$1.<init>:(Lnet/minecraft/command/CommandResultStats;Lnet/minecraft/command/ICommandSender;)V
        //    25: astore          lllllllllllllIllIlllIllIlIIIIIlI
        //    27: aload_1         /* lllllllllllllIllIlllIllIlIIIIlll */
        //    28: aload           lllllllllllllIllIlllIllIlIIIIIlI
        //    30: aload           lllllllllllllIllIlllIllIlIIIIIll
        //    32: invokestatic    net/minecraft/command/CommandBase.getEntityName:(Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/command/ICommandSender;Ljava/lang/String;)Ljava/lang/String;
        //    35: astore          lllllllllllllIllIlllIllIlIIIIIIl
        //    37: goto            43
        //    40: astore          lllllllllllllIllIlllIllIIlllllll
        //    42: return         
        //    43: aload_0         /* lllllllllllllIllIlllIllIIllllIlI */
        //    44: getfield        net/minecraft/command/CommandResultStats.objectives:[Ljava/lang/String;
        //    47: aload_3         /* lllllllllllllIllIlllIllIlIIIIlIl */
        //    48: invokevirtual   net/minecraft/command/CommandResultStats$Type.getTypeID:()I
        //    51: aaload         
        //    52: astore          lllllllllllllIllIlllIllIIllllllI
        //    54: aload           lllllllllllllIllIlllIllIIllllllI
        //    56: ifnull          114
        //    59: aload_2         /* lllllllllllllIllIlllIllIlIIIIllI */
        //    60: invokeinterface net/minecraft/command/ICommandSender.getEntityWorld:()Lnet/minecraft/world/World;
        //    65: invokevirtual   net/minecraft/world/World.getScoreboard:()Lnet/minecraft/scoreboard/Scoreboard;
        //    68: astore          lllllllllllllIllIlllIllIIlllllIl
        //    70: aload           lllllllllllllIllIlllIllIIlllllIl
        //    72: aload           lllllllllllllIllIlllIllIIllllllI
        //    74: invokevirtual   net/minecraft/scoreboard/Scoreboard.getObjective:(Ljava/lang/String;)Lnet/minecraft/scoreboard/ScoreObjective;
        //    77: astore          lllllllllllllIllIlllIllIIlllllII
        //    79: aload           lllllllllllllIllIlllIllIIlllllII
        //    81: ifnull          114
        //    84: aload           lllllllllllllIllIlllIllIIlllllIl
        //    86: aload           lllllllllllllIllIlllIllIlIIIIIII
        //    88: aload           lllllllllllllIllIlllIllIIlllllII
        //    90: invokevirtual   net/minecraft/scoreboard/Scoreboard.entityHasObjective:(Ljava/lang/String;Lnet/minecraft/scoreboard/ScoreObjective;)Z
        //    93: ifeq            114
        //    96: aload           lllllllllllllIllIlllIllIIlllllIl
        //    98: aload           lllllllllllllIllIlllIllIlIIIIIII
        //   100: aload           lllllllllllllIllIlllIllIIlllllII
        //   102: invokevirtual   net/minecraft/scoreboard/Scoreboard.getOrCreateScore:(Ljava/lang/String;Lnet/minecraft/scoreboard/ScoreObjective;)Lnet/minecraft/scoreboard/Score;
        //   105: astore          lllllllllllllIllIlllIllIIllllIll
        //   107: aload           lllllllllllllIllIlllIllIIllllIll
        //   109: iload           lllllllllllllIllIlllIllIIlllIllI
        //   111: invokevirtual   net/minecraft/scoreboard/Score.setScorePoints:(I)V
        //   114: return         
        //    StackMapTable: 00 03 FF 00 28 00 07 07 00 02 07 00 C4 07 00 82 07 00 06 01 07 00 29 07 00 09 00 01 07 00 77 FC 00 02 07 00 29 F9 00 46
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                    
        //  -----  -----  -----  -----  ----------------------------------------
        //  27     37     40     43     Lnet/minecraft/command/CommandException;
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
    
    public CommandResultStats() {
        this.entitiesID = CommandResultStats.STRING_RESULT_TYPES;
        this.objectives = CommandResultStats.STRING_RESULT_TYPES;
    }
    
    public void writeStatsToNBT(final NBTTagCompound lllllllllllllIllIlllIllIIlIIIIII) {
        final NBTTagCompound lllllllllllllIllIlllIllIIlIIIlIl = new NBTTagCompound();
        final byte lllllllllllllIllIlllIllIIIlllIll;
        final double lllllllllllllIllIlllIllIIIllllII = ((Type[])(Object)(lllllllllllllIllIlllIllIIIlllIll = (byte)(Object)Type.values())).length;
        for (long lllllllllllllIllIlllIllIIIllllIl = 0; lllllllllllllIllIlllIllIIIllllIl < lllllllllllllIllIlllIllIIIllllII; ++lllllllllllllIllIlllIllIIIllllIl) {
            final Type lllllllllllllIllIlllIllIIlIIIlII = lllllllllllllIllIlllIllIIIlllIll[lllllllllllllIllIlllIllIIIllllIl];
            final String lllllllllllllIllIlllIllIIlIIIIll = this.entitiesID[lllllllllllllIllIlllIllIIlIIIlII.getTypeID()];
            final String lllllllllllllIllIlllIllIIlIIIIlI = this.objectives[lllllllllllllIllIlllIllIIlIIIlII.getTypeID()];
            if (lllllllllllllIllIlllIllIIlIIIIll != null && lllllllllllllIllIlllIllIIlIIIIlI != null) {
                lllllllllllllIllIlllIllIIlIIIlIl.setString(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIllIlllIllIIlIIIlII.getTypeName())).append("Name")), lllllllllllllIllIlllIllIIlIIIIll);
                lllllllllllllIllIlllIllIIlIIIlIl.setString(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIllIlllIllIIlIIIlII.getTypeName())).append("Objective")), lllllllllllllIllIlllIllIIlIIIIlI);
            }
        }
        if (!lllllllllllllIllIlllIllIIlIIIlIl.hasNoTags()) {
            lllllllllllllIllIlllIllIIlIIIIII.setTag("CommandStats", lllllllllllllIllIlllIllIIlIIIlIl);
        }
    }
    
    static {
        NUM_RESULT_TYPES = Type.values().length;
        STRING_RESULT_TYPES = new String[CommandResultStats.NUM_RESULT_TYPES];
    }
    
    private static void removeScoreBoardStat(final CommandResultStats lllllllllllllIllIlllIllIIIlIIlIl, final Type lllllllllllllIllIlllIllIIIlIIIII) {
        if (lllllllllllllIllIlllIllIIIlIIlIl.entitiesID != CommandResultStats.STRING_RESULT_TYPES && lllllllllllllIllIlllIllIIIlIIlIl.objectives != CommandResultStats.STRING_RESULT_TYPES) {
            lllllllllllllIllIlllIllIIIlIIlIl.entitiesID[lllllllllllllIllIlllIllIIIlIIIII.getTypeID()] = null;
            lllllllllllllIllIlllIllIIIlIIlIl.objectives[lllllllllllllIllIlllIllIIIlIIIII.getTypeID()] = null;
            boolean lllllllllllllIllIlllIllIIIlIIIll = true;
            final Exception lllllllllllllIllIlllIllIIIIllIll;
            final String lllllllllllllIllIlllIllIIIIlllII = (String)((Type[])(Object)(lllllllllllllIllIlllIllIIIIllIll = (Exception)(Object)Type.values())).length;
            for (short lllllllllllllIllIlllIllIIIIlllIl = 0; lllllllllllllIllIlllIllIIIIlllIl < lllllllllllllIllIlllIllIIIIlllII; ++lllllllllllllIllIlllIllIIIIlllIl) {
                final Type lllllllllllllIllIlllIllIIIlIIIlI = lllllllllllllIllIlllIllIIIIllIll[lllllllllllllIllIlllIllIIIIlllIl];
                if (lllllllllllllIllIlllIllIIIlIIlIl.entitiesID[lllllllllllllIllIlllIllIIIlIIIlI.getTypeID()] != null && lllllllllllllIllIlllIllIIIlIIlIl.objectives[lllllllllllllIllIlllIllIIIlIIIlI.getTypeID()] != null) {
                    lllllllllllllIllIlllIllIIIlIIIll = false;
                    break;
                }
            }
            if (lllllllllllllIllIlllIllIIIlIIIll) {
                lllllllllllllIllIlllIllIIIlIIlIl.entitiesID = CommandResultStats.STRING_RESULT_TYPES;
                lllllllllllllIllIlllIllIIIlIIlIl.objectives = CommandResultStats.STRING_RESULT_TYPES;
            }
        }
    }
    
    public static void setScoreBoardStat(final CommandResultStats lllllllllllllIllIlllIllIIIllIIII, final Type lllllllllllllIllIlllIllIIIllIIll, @Nullable final String lllllllllllllIllIlllIllIIIllIIlI, @Nullable final String lllllllllllllIllIlllIllIIIllIIIl) {
        if (lllllllllllllIllIlllIllIIIllIIlI != null && !lllllllllllllIllIlllIllIIIllIIlI.isEmpty() && lllllllllllllIllIlllIllIIIllIIIl != null && !lllllllllllllIllIlllIllIIIllIIIl.isEmpty()) {
            if (lllllllllllllIllIlllIllIIIllIIII.entitiesID == CommandResultStats.STRING_RESULT_TYPES || lllllllllllllIllIlllIllIIIllIIII.objectives == CommandResultStats.STRING_RESULT_TYPES) {
                lllllllllllllIllIlllIllIIIllIIII.entitiesID = new String[CommandResultStats.NUM_RESULT_TYPES];
                lllllllllllllIllIlllIllIIIllIIII.objectives = new String[CommandResultStats.NUM_RESULT_TYPES];
            }
            lllllllllllllIllIlllIllIIIllIIII.entitiesID[lllllllllllllIllIlllIllIIIllIIll.getTypeID()] = lllllllllllllIllIlllIllIIIllIIlI;
            lllllllllllllIllIlllIllIIIllIIII.objectives[lllllllllllllIllIlllIllIIIllIIll.getTypeID()] = lllllllllllllIllIlllIllIIIllIIIl;
        }
        else {
            removeScoreBoardStat(lllllllllllllIllIlllIllIIIllIIII, lllllllllllllIllIlllIllIIIllIIll);
        }
    }
    
    public enum Type
    {
        SUCCESS_COUNT("SUCCESS_COUNT", 0, 0, "SuccessCount");
        
        final /* synthetic */ String typeName;
        
        AFFECTED_BLOCKS("AFFECTED_BLOCKS", 1, 1, "AffectedBlocks");
        
        final /* synthetic */ int typeID;
        
        AFFECTED_ENTITIES("AFFECTED_ENTITIES", 2, 2, "AffectedEntities"), 
        AFFECTED_ITEMS("AFFECTED_ITEMS", 3, 3, "AffectedItems"), 
        QUERY_RESULT("QUERY_RESULT", 4, 4, "QueryResult");
        
        @Nullable
        public static Type getTypeByName(final String lllllllllllllllIlllIIIIIlllIllIl) {
            final boolean lllllllllllllllIlllIIIIIlllIlIIl;
            final boolean lllllllllllllllIlllIIIIIlllIlIlI = ((Type[])(Object)(lllllllllllllllIlllIIIIIlllIlIIl = (boolean)(Object)values())).length != 0;
            for (Exception lllllllllllllllIlllIIIIIlllIlIll = (Exception)0; lllllllllllllllIlllIIIIIlllIlIll < lllllllllllllllIlllIIIIIlllIlIlI; ++lllllllllllllllIlllIIIIIlllIlIll) {
                final Type lllllllllllllllIlllIIIIIlllIlllI = lllllllllllllllIlllIIIIIlllIlIIl[lllllllllllllllIlllIIIIIlllIlIll];
                if (lllllllllllllllIlllIIIIIlllIlllI.getTypeName().equals(lllllllllllllllIlllIIIIIlllIllIl)) {
                    return lllllllllllllllIlllIIIIIlllIlllI;
                }
            }
            return null;
        }
        
        private Type(final String lllllllllllllllIlllIIIIlIIIIllIl, final int lllllllllllllllIlllIIIIlIIIIllII, final int lllllllllllllllIlllIIIIlIIIlIIII, final String lllllllllllllllIlllIIIIlIIIIlIlI) {
            this.typeID = lllllllllllllllIlllIIIIlIIIlIIII;
            this.typeName = lllllllllllllllIlllIIIIlIIIIlIlI;
        }
        
        public String getTypeName() {
            return this.typeName;
        }
        
        public static String[] getTypeNames() {
            final String[] lllllllllllllllIlllIIIIIllllllIl = new String[values().length];
            int lllllllllllllllIlllIIIIIllllllII = 0;
            final char lllllllllllllllIlllIIIIIllllIlIl;
            final Exception lllllllllllllllIlllIIIIIllllIllI = (Exception)((Type[])(Object)(lllllllllllllllIlllIIIIIllllIlIl = (char)(Object)values())).length;
            for (char lllllllllllllllIlllIIIIIllllIlll = '\0'; lllllllllllllllIlllIIIIIllllIlll < lllllllllllllllIlllIIIIIllllIllI; ++lllllllllllllllIlllIIIIIllllIlll) {
                final Type lllllllllllllllIlllIIIIIlllllIll = lllllllllllllllIlllIIIIIllllIlIl[lllllllllllllllIlllIIIIIllllIlll];
                lllllllllllllllIlllIIIIIllllllIl[lllllllllllllllIlllIIIIIllllllII++] = lllllllllllllllIlllIIIIIlllllIll.getTypeName();
            }
            return lllllllllllllllIlllIIIIIllllllIl;
        }
        
        public int getTypeID() {
            return this.typeID;
        }
    }
}
