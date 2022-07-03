package com.viaversion.viaversion.api.minecraft.entities;

import com.viaversion.viaversion.api.*;
import java.util.*;

public class Entity1_13Types
{
    public static EntityType getTypeFromId(final int lllllllllllllIlIIIIIIIIIlIllIlIl, final boolean lllllllllllllIlIIIIIIIIIlIllIlII) {
        Optional<EntityType> lllllllllllllIlIIIIIIIIIlIllIIll = null;
        if (lllllllllllllIlIIIIIIIIIlIllIlII) {
            final Optional<EntityType> lllllllllllllIlIIIIIIIIIlIllIllI = ObjectType.getPCEntity(lllllllllllllIlIIIIIIIIIlIllIlIl);
        }
        else {
            lllllllllllllIlIIIIIIIIIlIllIIll = EntityType.findById(lllllllllllllIlIIIIIIIIIlIllIlIl);
        }
        if (!lllllllllllllIlIIIIIIIIIlIllIIll.isPresent()) {
            Via.getPlatform().getLogger().severe(String.valueOf(new StringBuilder().append("Could not find 1.13 type id ").append(lllllllllllllIlIIIIIIIIIlIllIlIl).append(" isObject=").append(lllllllllllllIlIIIIIIIIIlIllIlII)));
            return EntityType.ENTITY;
        }
        return lllllllllllllIlIIIIIIIIIlIllIIll.get();
    }
    
    public enum EntityType implements com.viaversion.viaversion.api.minecraft.entities.EntityType
    {
        public static final /* synthetic */ EntityType ENTITY;
        private final /* synthetic */ int id;
        private final /* synthetic */ EntityType parent;
        private static final /* synthetic */ Map<Integer, EntityType> TYPES;
        
        private EntityType(final int lllllllllllllllIIIllllIIIIlllIII, final EntityType lllllllllllllllIIIllllIIIIllIlll) {
            this.id = lllllllllllllllIIIllllIIIIlllIII;
            this.parent = lllllllllllllllIIIllllIIIIllIlll;
        }
        
        static {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     3: dup            
            //     4: ldc             "ENTITY"
            //     6: iconst_0       
            //     7: iconst_m1      
            //     8: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;II)V
            //    11: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //    14: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //    17: dup            
            //    18: ldc             "AREA_EFFECT_CLOUD"
            //    20: iconst_1       
            //    21: iconst_0       
            //    22: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //    25: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //    28: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.AREA_EFFECT_CLOUD:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //    31: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //    34: dup            
            //    35: ldc             "END_CRYSTAL"
            //    37: iconst_2       
            //    38: bipush          16
            //    40: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //    43: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //    46: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.END_CRYSTAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //    49: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //    52: dup            
            //    53: ldc             "EVOKER_FANGS"
            //    55: iconst_3       
            //    56: bipush          20
            //    58: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //    61: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //    64: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.EVOKER_FANGS:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //    67: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //    70: dup            
            //    71: ldc             "EXPERIENCE_ORB"
            //    73: iconst_4       
            //    74: bipush          22
            //    76: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //    79: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //    82: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.EXPERIENCE_ORB:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //    85: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //    88: dup            
            //    89: ldc             "EYE_OF_ENDER"
            //    91: iconst_5       
            //    92: bipush          23
            //    94: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //    97: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   100: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.EYE_OF_ENDER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   103: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   106: dup            
            //   107: ldc             "FALLING_BLOCK"
            //   109: bipush          6
            //   111: bipush          24
            //   113: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   116: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   119: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.FALLING_BLOCK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   122: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   125: dup            
            //   126: ldc             "FIREWORK_ROCKET"
            //   128: bipush          7
            //   130: bipush          25
            //   132: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   135: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   138: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.FIREWORK_ROCKET:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   141: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   144: dup            
            //   145: ldc             "ITEM"
            //   147: bipush          8
            //   149: bipush          32
            //   151: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   154: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   157: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ITEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   160: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   163: dup            
            //   164: ldc             "LLAMA_SPIT"
            //   166: bipush          9
            //   168: bipush          37
            //   170: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   173: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   176: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.LLAMA_SPIT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   179: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   182: dup            
            //   183: ldc             "TNT"
            //   185: bipush          10
            //   187: bipush          55
            //   189: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   192: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   195: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.TNT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   198: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   201: dup            
            //   202: ldc             "SHULKER_BULLET"
            //   204: bipush          11
            //   206: bipush          60
            //   208: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   211: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   214: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SHULKER_BULLET:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   217: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   220: dup            
            //   221: ldc             "FISHING_BOBBER"
            //   223: bipush          12
            //   225: bipush          93
            //   227: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   230: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   233: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.FISHING_BOBBER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   236: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   239: dup            
            //   240: ldc             "LIVINGENTITY"
            //   242: bipush          13
            //   244: iconst_m1      
            //   245: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   248: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   251: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.LIVINGENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   254: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   257: dup            
            //   258: ldc             "ARMOR_STAND"
            //   260: bipush          14
            //   262: iconst_1       
            //   263: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.LIVINGENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   266: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   269: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ARMOR_STAND:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   272: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   275: dup            
            //   276: ldc             "PLAYER"
            //   278: bipush          15
            //   280: bipush          92
            //   282: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.LIVINGENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   285: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   288: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.PLAYER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   291: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   294: dup            
            //   295: ldc             "ABSTRACT_INSENTIENT"
            //   297: bipush          16
            //   299: iconst_m1      
            //   300: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.LIVINGENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   303: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   306: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   309: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   312: dup            
            //   313: ldc             "ENDER_DRAGON"
            //   315: bipush          17
            //   317: bipush          17
            //   319: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   322: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   325: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENDER_DRAGON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   328: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   331: dup            
            //   332: ldc             "ABSTRACT_CREATURE"
            //   334: bipush          18
            //   336: iconst_m1      
            //   337: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   340: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   343: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_CREATURE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   346: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   349: dup            
            //   350: ldc             "ABSTRACT_AGEABLE"
            //   352: bipush          19
            //   354: iconst_m1      
            //   355: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_CREATURE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   358: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   361: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   364: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   367: dup            
            //   368: ldc             "VILLAGER"
            //   370: bipush          20
            //   372: bipush          79
            //   374: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   377: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   380: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.VILLAGER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   383: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   386: dup            
            //   387: ldc             "ABSTRACT_ANIMAL"
            //   389: bipush          21
            //   391: iconst_m1      
            //   392: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   395: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   398: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   401: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   404: dup            
            //   405: ldc             "CHICKEN"
            //   407: bipush          22
            //   409: bipush          7
            //   411: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   414: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   417: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.CHICKEN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   420: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   423: dup            
            //   424: ldc             "COW"
            //   426: bipush          23
            //   428: bipush          9
            //   430: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   433: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   436: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.COW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   439: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   442: dup            
            //   443: ldc             "MOOSHROOM"
            //   445: bipush          24
            //   447: bipush          47
            //   449: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.COW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   452: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   455: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.MOOSHROOM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   458: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   461: dup            
            //   462: ldc             "PIG"
            //   464: bipush          25
            //   466: bipush          51
            //   468: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   471: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   474: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.PIG:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   477: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   480: dup            
            //   481: ldc             "POLAR_BEAR"
            //   483: bipush          26
            //   485: bipush          54
            //   487: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   490: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   493: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.POLAR_BEAR:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   496: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   499: dup            
            //   500: ldc             "RABBIT"
            //   502: bipush          27
            //   504: bipush          56
            //   506: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   509: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   512: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.RABBIT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   515: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   518: dup            
            //   519: ldc             "SHEEP"
            //   521: bipush          28
            //   523: bipush          58
            //   525: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   528: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   531: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SHEEP:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   534: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   537: dup            
            //   538: ldc_w           "TURTLE"
            //   541: bipush          29
            //   543: bipush          73
            //   545: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   548: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   551: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.TURTLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   554: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   557: dup            
            //   558: ldc_w           "ABSTRACT_TAMEABLE_ANIMAL"
            //   561: bipush          30
            //   563: iconst_m1      
            //   564: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   567: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   570: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_TAMEABLE_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   573: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   576: dup            
            //   577: ldc_w           "OCELOT"
            //   580: bipush          31
            //   582: bipush          48
            //   584: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_TAMEABLE_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   587: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   590: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.OCELOT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   593: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   596: dup            
            //   597: ldc_w           "WOLF"
            //   600: bipush          32
            //   602: bipush          86
            //   604: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_TAMEABLE_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   607: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   610: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.WOLF:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   613: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   616: dup            
            //   617: ldc_w           "ABSTRACT_PARROT"
            //   620: bipush          33
            //   622: iconst_m1      
            //   623: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_TAMEABLE_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   626: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   629: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_PARROT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   632: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   635: dup            
            //   636: ldc_w           "PARROT"
            //   639: bipush          34
            //   641: bipush          50
            //   643: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_PARROT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   646: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   649: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.PARROT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   652: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   655: dup            
            //   656: ldc_w           "ABSTRACT_HORSE"
            //   659: bipush          35
            //   661: iconst_m1      
            //   662: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   665: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   668: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   671: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   674: dup            
            //   675: ldc_w           "CHESTED_HORSE"
            //   678: bipush          36
            //   680: iconst_m1      
            //   681: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   684: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   687: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.CHESTED_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   690: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   693: dup            
            //   694: ldc_w           "DONKEY"
            //   697: bipush          37
            //   699: bipush          11
            //   701: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.CHESTED_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   704: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   707: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.DONKEY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   710: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   713: dup            
            //   714: ldc_w           "MULE"
            //   717: bipush          38
            //   719: bipush          46
            //   721: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.CHESTED_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   724: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   727: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.MULE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   730: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   733: dup            
            //   734: ldc_w           "LLAMA"
            //   737: bipush          39
            //   739: bipush          36
            //   741: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.CHESTED_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   744: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   747: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.LLAMA:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   750: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   753: dup            
            //   754: ldc_w           "HORSE"
            //   757: bipush          40
            //   759: bipush          29
            //   761: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   764: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   767: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   770: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   773: dup            
            //   774: ldc_w           "SKELETON_HORSE"
            //   777: bipush          41
            //   779: bipush          63
            //   781: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   784: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   787: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SKELETON_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   790: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   793: dup            
            //   794: ldc_w           "ZOMBIE_HORSE"
            //   797: bipush          42
            //   799: bipush          88
            //   801: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   804: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   807: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ZOMBIE_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   810: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   813: dup            
            //   814: ldc_w           "ABSTRACT_GOLEM"
            //   817: bipush          43
            //   819: iconst_m1      
            //   820: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_CREATURE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   823: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   826: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_GOLEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   829: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   832: dup            
            //   833: ldc_w           "SNOW_GOLEM"
            //   836: bipush          44
            //   838: bipush          66
            //   840: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_GOLEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   843: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   846: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SNOW_GOLEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   849: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   852: dup            
            //   853: ldc_w           "IRON_GOLEM"
            //   856: bipush          45
            //   858: bipush          80
            //   860: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_GOLEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   863: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   866: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.IRON_GOLEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   869: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   872: dup            
            //   873: ldc_w           "SHULKER"
            //   876: bipush          46
            //   878: bipush          59
            //   880: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_GOLEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   883: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   886: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SHULKER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   889: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   892: dup            
            //   893: ldc_w           "ABSTRACT_FISHES"
            //   896: bipush          47
            //   898: iconst_m1      
            //   899: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_CREATURE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   902: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   905: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_FISHES:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   908: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   911: dup            
            //   912: ldc_w           "COD"
            //   915: bipush          48
            //   917: bipush          8
            //   919: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_FISHES:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   922: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   925: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.COD:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   928: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   931: dup            
            //   932: ldc_w           "PUFFERFISH"
            //   935: bipush          49
            //   937: bipush          52
            //   939: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_FISHES:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   942: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   945: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.PUFFERFISH:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   948: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   951: dup            
            //   952: ldc_w           "SALMON"
            //   955: bipush          50
            //   957: bipush          57
            //   959: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_FISHES:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   962: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   965: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SALMON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   968: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   971: dup            
            //   972: ldc_w           "TROPICAL_FISH"
            //   975: bipush          51
            //   977: bipush          72
            //   979: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_FISHES:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   982: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   985: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.TROPICAL_FISH:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   988: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   991: dup            
            //   992: ldc_w           "ABSTRACT_MONSTER"
            //   995: bipush          52
            //   997: iconst_m1      
            //   998: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_CREATURE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1001: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1004: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_MONSTER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1007: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1010: dup            
            //  1011: ldc_w           "BLAZE"
            //  1014: bipush          53
            //  1016: iconst_4       
            //  1017: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_MONSTER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1020: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1023: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.BLAZE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1026: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1029: dup            
            //  1030: ldc_w           "CREEPER"
            //  1033: bipush          54
            //  1035: bipush          10
            //  1037: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_MONSTER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1040: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1043: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.CREEPER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1046: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1049: dup            
            //  1050: ldc_w           "ENDERMITE"
            //  1053: bipush          55
            //  1055: bipush          19
            //  1057: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_MONSTER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1060: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1063: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENDERMITE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1066: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1069: dup            
            //  1070: ldc_w           "ENDERMAN"
            //  1073: bipush          56
            //  1075: bipush          18
            //  1077: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_MONSTER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1080: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1083: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENDERMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1086: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1089: dup            
            //  1090: ldc_w           "GIANT"
            //  1093: bipush          57
            //  1095: bipush          27
            //  1097: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_MONSTER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1100: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1103: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.GIANT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1106: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1109: dup            
            //  1110: ldc_w           "SILVERFISH"
            //  1113: bipush          58
            //  1115: bipush          61
            //  1117: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_MONSTER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1120: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1123: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SILVERFISH:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1126: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1129: dup            
            //  1130: ldc_w           "VEX"
            //  1133: bipush          59
            //  1135: bipush          78
            //  1137: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_MONSTER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1140: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1143: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.VEX:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1146: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1149: dup            
            //  1150: ldc_w           "WITCH"
            //  1153: bipush          60
            //  1155: bipush          82
            //  1157: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_MONSTER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1160: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1163: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.WITCH:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1166: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1169: dup            
            //  1170: ldc_w           "WITHER"
            //  1173: bipush          61
            //  1175: bipush          83
            //  1177: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_MONSTER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1180: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1183: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.WITHER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1186: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1189: dup            
            //  1190: ldc_w           "ABSTRACT_ILLAGER_BASE"
            //  1193: bipush          62
            //  1195: iconst_m1      
            //  1196: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_MONSTER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1199: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1202: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_ILLAGER_BASE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1205: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1208: dup            
            //  1209: ldc_w           "ABSTRACT_EVO_ILLU_ILLAGER"
            //  1212: bipush          63
            //  1214: iconst_m1      
            //  1215: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_ILLAGER_BASE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1218: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1221: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_EVO_ILLU_ILLAGER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1224: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1227: dup            
            //  1228: ldc_w           "EVOKER"
            //  1231: bipush          64
            //  1233: bipush          21
            //  1235: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_EVO_ILLU_ILLAGER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1238: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1241: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.EVOKER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1244: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1247: dup            
            //  1248: ldc_w           "ILLUSIONER"
            //  1251: bipush          65
            //  1253: bipush          31
            //  1255: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_EVO_ILLU_ILLAGER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1258: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1261: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ILLUSIONER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1264: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1267: dup            
            //  1268: ldc_w           "VINDICATOR"
            //  1271: bipush          66
            //  1273: bipush          81
            //  1275: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_ILLAGER_BASE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1278: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1281: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.VINDICATOR:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1284: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1287: dup            
            //  1288: ldc_w           "ABSTRACT_SKELETON"
            //  1291: bipush          67
            //  1293: iconst_m1      
            //  1294: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_MONSTER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1297: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1300: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_SKELETON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1303: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1306: dup            
            //  1307: ldc_w           "SKELETON"
            //  1310: bipush          68
            //  1312: bipush          62
            //  1314: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_SKELETON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1317: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1320: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SKELETON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1323: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1326: dup            
            //  1327: ldc_w           "STRAY"
            //  1330: bipush          69
            //  1332: bipush          71
            //  1334: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_SKELETON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1337: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1340: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.STRAY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1343: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1346: dup            
            //  1347: ldc_w           "WITHER_SKELETON"
            //  1350: bipush          70
            //  1352: bipush          84
            //  1354: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_SKELETON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1357: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1360: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.WITHER_SKELETON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1363: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1366: dup            
            //  1367: ldc_w           "GUARDIAN"
            //  1370: bipush          71
            //  1372: bipush          28
            //  1374: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_MONSTER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1377: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1380: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.GUARDIAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1383: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1386: dup            
            //  1387: ldc_w           "ELDER_GUARDIAN"
            //  1390: bipush          72
            //  1392: bipush          15
            //  1394: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.GUARDIAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1397: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1400: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ELDER_GUARDIAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1403: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1406: dup            
            //  1407: ldc_w           "SPIDER"
            //  1410: bipush          73
            //  1412: bipush          69
            //  1414: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_MONSTER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1417: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1420: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SPIDER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1423: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1426: dup            
            //  1427: ldc_w           "CAVE_SPIDER"
            //  1430: bipush          74
            //  1432: bipush          6
            //  1434: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SPIDER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1437: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1440: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.CAVE_SPIDER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1443: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1446: dup            
            //  1447: ldc_w           "ZOMBIE"
            //  1450: bipush          75
            //  1452: bipush          87
            //  1454: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_MONSTER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1457: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1460: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ZOMBIE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1463: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1466: dup            
            //  1467: ldc_w           "DROWNED"
            //  1470: bipush          76
            //  1472: bipush          14
            //  1474: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ZOMBIE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1477: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1480: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.DROWNED:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1483: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1486: dup            
            //  1487: ldc_w           "HUSK"
            //  1490: bipush          77
            //  1492: bipush          30
            //  1494: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ZOMBIE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1497: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1500: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.HUSK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1503: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1506: dup            
            //  1507: ldc_w           "ZOMBIE_PIGMAN"
            //  1510: bipush          78
            //  1512: bipush          53
            //  1514: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ZOMBIE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1517: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1520: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ZOMBIE_PIGMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1523: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1526: dup            
            //  1527: ldc_w           "ZOMBIE_VILLAGER"
            //  1530: bipush          79
            //  1532: bipush          89
            //  1534: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ZOMBIE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1537: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1540: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ZOMBIE_VILLAGER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1543: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1546: dup            
            //  1547: ldc_w           "ABSTRACT_FLYING"
            //  1550: bipush          80
            //  1552: iconst_m1      
            //  1553: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1556: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1559: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_FLYING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1562: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1565: dup            
            //  1566: ldc_w           "GHAST"
            //  1569: bipush          81
            //  1571: bipush          26
            //  1573: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_FLYING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1576: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1579: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.GHAST:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1582: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1585: dup            
            //  1586: ldc_w           "PHANTOM"
            //  1589: bipush          82
            //  1591: bipush          90
            //  1593: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_FLYING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1596: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1599: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.PHANTOM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1602: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1605: dup            
            //  1606: ldc_w           "ABSTRACT_AMBIENT"
            //  1609: bipush          83
            //  1611: iconst_m1      
            //  1612: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1615: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1618: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_AMBIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1621: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1624: dup            
            //  1625: ldc_w           "BAT"
            //  1628: bipush          84
            //  1630: iconst_3       
            //  1631: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_AMBIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1634: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1637: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.BAT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1640: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1643: dup            
            //  1644: ldc_w           "ABSTRACT_WATERMOB"
            //  1647: bipush          85
            //  1649: iconst_m1      
            //  1650: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1653: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1656: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_WATERMOB:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1659: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1662: dup            
            //  1663: ldc_w           "SQUID"
            //  1666: bipush          86
            //  1668: bipush          70
            //  1670: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_WATERMOB:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1673: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1676: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SQUID:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1679: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1682: dup            
            //  1683: ldc_w           "DOLPHIN"
            //  1686: bipush          87
            //  1688: bipush          12
            //  1690: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_WATERMOB:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1693: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1696: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.DOLPHIN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1699: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1702: dup            
            //  1703: ldc_w           "SLIME"
            //  1706: bipush          88
            //  1708: bipush          64
            //  1710: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1713: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1716: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SLIME:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1719: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1722: dup            
            //  1723: ldc_w           "MAGMA_CUBE"
            //  1726: bipush          89
            //  1728: bipush          38
            //  1730: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SLIME:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1733: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1736: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.MAGMA_CUBE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1739: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1742: dup            
            //  1743: ldc_w           "ABSTRACT_HANGING"
            //  1746: bipush          90
            //  1748: iconst_m1      
            //  1749: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1752: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1755: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_HANGING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1758: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1761: dup            
            //  1762: ldc_w           "LEASH_KNOT"
            //  1765: bipush          91
            //  1767: bipush          35
            //  1769: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_HANGING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1772: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1775: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.LEASH_KNOT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1778: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1781: dup            
            //  1782: ldc_w           "ITEM_FRAME"
            //  1785: bipush          92
            //  1787: bipush          33
            //  1789: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_HANGING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1792: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1795: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ITEM_FRAME:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1798: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1801: dup            
            //  1802: ldc_w           "PAINTING"
            //  1805: bipush          93
            //  1807: bipush          49
            //  1809: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_HANGING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1812: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1815: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.PAINTING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1818: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1821: dup            
            //  1822: ldc_w           "ABSTRACT_LIGHTNING"
            //  1825: bipush          94
            //  1827: iconst_m1      
            //  1828: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1831: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1834: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_LIGHTNING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1837: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1840: dup            
            //  1841: ldc_w           "LIGHTNING_BOLT"
            //  1844: bipush          95
            //  1846: bipush          91
            //  1848: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_LIGHTNING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1851: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1854: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.LIGHTNING_BOLT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1857: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1860: dup            
            //  1861: ldc_w           "ABSTRACT_ARROW"
            //  1864: bipush          96
            //  1866: iconst_m1      
            //  1867: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1870: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1873: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1876: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1879: dup            
            //  1880: ldc_w           "ARROW"
            //  1883: bipush          97
            //  1885: iconst_2       
            //  1886: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1889: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1892: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1895: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1898: dup            
            //  1899: ldc_w           "SPECTRAL_ARROW"
            //  1902: bipush          98
            //  1904: bipush          68
            //  1906: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1909: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1912: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SPECTRAL_ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1915: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1918: dup            
            //  1919: ldc_w           "TRIDENT"
            //  1922: bipush          99
            //  1924: bipush          94
            //  1926: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1929: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1932: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.TRIDENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1935: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1938: dup            
            //  1939: ldc_w           "ABSTRACT_FIREBALL"
            //  1942: bipush          100
            //  1944: iconst_m1      
            //  1945: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1948: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1951: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1954: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1957: dup            
            //  1958: ldc_w           "DRAGON_FIREBALL"
            //  1961: bipush          101
            //  1963: bipush          13
            //  1965: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1968: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1971: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.DRAGON_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1974: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1977: dup            
            //  1978: ldc_w           "FIREBALL"
            //  1981: bipush          102
            //  1983: bipush          34
            //  1985: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1988: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  1991: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1994: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  1997: dup            
            //  1998: ldc_w           "SMALL_FIREBALL"
            //  2001: bipush          103
            //  2003: bipush          65
            //  2005: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2008: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  2011: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SMALL_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2014: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2017: dup            
            //  2018: ldc_w           "WITHER_SKULL"
            //  2021: bipush          104
            //  2023: bipush          85
            //  2025: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2028: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  2031: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.WITHER_SKULL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2034: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2037: dup            
            //  2038: ldc_w           "PROJECTILE_ABSTRACT"
            //  2041: bipush          105
            //  2043: iconst_m1      
            //  2044: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2047: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  2050: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.PROJECTILE_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2053: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2056: dup            
            //  2057: ldc_w           "SNOWBALL"
            //  2060: bipush          106
            //  2062: bipush          67
            //  2064: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.PROJECTILE_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2067: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  2070: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SNOWBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2073: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2076: dup            
            //  2077: ldc_w           "ENDER_PEARL"
            //  2080: bipush          107
            //  2082: bipush          75
            //  2084: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.PROJECTILE_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2087: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  2090: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENDER_PEARL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2093: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2096: dup            
            //  2097: ldc_w           "EGG"
            //  2100: bipush          108
            //  2102: bipush          74
            //  2104: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.PROJECTILE_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2107: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  2110: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.EGG:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2113: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2116: dup            
            //  2117: ldc_w           "POTION"
            //  2120: bipush          109
            //  2122: bipush          77
            //  2124: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.PROJECTILE_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2127: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  2130: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.POTION:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2133: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2136: dup            
            //  2137: ldc_w           "EXPERIENCE_BOTTLE"
            //  2140: bipush          110
            //  2142: bipush          76
            //  2144: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.PROJECTILE_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2147: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  2150: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.EXPERIENCE_BOTTLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2153: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2156: dup            
            //  2157: ldc_w           "MINECART_ABSTRACT"
            //  2160: bipush          111
            //  2162: iconst_m1      
            //  2163: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2166: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  2169: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2172: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2175: dup            
            //  2176: ldc_w           "CHESTED_MINECART_ABSTRACT"
            //  2179: bipush          112
            //  2181: iconst_m1      
            //  2182: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2185: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  2188: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.CHESTED_MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2191: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2194: dup            
            //  2195: ldc_w           "CHEST_MINECART"
            //  2198: bipush          113
            //  2200: bipush          40
            //  2202: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.CHESTED_MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2205: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  2208: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.CHEST_MINECART:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2211: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2214: dup            
            //  2215: ldc_w           "HOPPER_MINECART"
            //  2218: bipush          114
            //  2220: bipush          43
            //  2222: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.CHESTED_MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2225: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  2228: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.HOPPER_MINECART:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2231: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2234: dup            
            //  2235: ldc_w           "MINECART"
            //  2238: bipush          115
            //  2240: bipush          39
            //  2242: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2245: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  2248: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.MINECART:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2251: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2254: dup            
            //  2255: ldc_w           "FURNACE_MINECART"
            //  2258: bipush          116
            //  2260: bipush          42
            //  2262: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2265: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  2268: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.FURNACE_MINECART:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2271: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2274: dup            
            //  2275: ldc_w           "COMMAND_BLOCK_MINECART"
            //  2278: bipush          117
            //  2280: bipush          41
            //  2282: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2285: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  2288: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.COMMAND_BLOCK_MINECART:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2291: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2294: dup            
            //  2295: ldc_w           "TNT_MINECART"
            //  2298: bipush          118
            //  2300: bipush          45
            //  2302: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2305: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  2308: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.TNT_MINECART:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2311: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2314: dup            
            //  2315: ldc_w           "SPAWNER_MINECART"
            //  2318: bipush          119
            //  2320: bipush          44
            //  2322: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2325: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  2328: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SPAWNER_MINECART:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2331: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2334: dup            
            //  2335: ldc_w           "BOAT"
            //  2338: bipush          120
            //  2340: iconst_5       
            //  2341: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2344: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //  2347: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.BOAT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2350: bipush          121
            //  2352: anewarray       Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2355: dup            
            //  2356: iconst_0       
            //  2357: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2360: aastore        
            //  2361: dup            
            //  2362: iconst_1       
            //  2363: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.AREA_EFFECT_CLOUD:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2366: aastore        
            //  2367: dup            
            //  2368: iconst_2       
            //  2369: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.END_CRYSTAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2372: aastore        
            //  2373: dup            
            //  2374: iconst_3       
            //  2375: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.EVOKER_FANGS:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2378: aastore        
            //  2379: dup            
            //  2380: iconst_4       
            //  2381: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.EXPERIENCE_ORB:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2384: aastore        
            //  2385: dup            
            //  2386: iconst_5       
            //  2387: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.EYE_OF_ENDER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2390: aastore        
            //  2391: dup            
            //  2392: bipush          6
            //  2394: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.FALLING_BLOCK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2397: aastore        
            //  2398: dup            
            //  2399: bipush          7
            //  2401: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.FIREWORK_ROCKET:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2404: aastore        
            //  2405: dup            
            //  2406: bipush          8
            //  2408: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ITEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2411: aastore        
            //  2412: dup            
            //  2413: bipush          9
            //  2415: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.LLAMA_SPIT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2418: aastore        
            //  2419: dup            
            //  2420: bipush          10
            //  2422: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.TNT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2425: aastore        
            //  2426: dup            
            //  2427: bipush          11
            //  2429: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SHULKER_BULLET:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2432: aastore        
            //  2433: dup            
            //  2434: bipush          12
            //  2436: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.FISHING_BOBBER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2439: aastore        
            //  2440: dup            
            //  2441: bipush          13
            //  2443: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.LIVINGENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2446: aastore        
            //  2447: dup            
            //  2448: bipush          14
            //  2450: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ARMOR_STAND:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2453: aastore        
            //  2454: dup            
            //  2455: bipush          15
            //  2457: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.PLAYER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2460: aastore        
            //  2461: dup            
            //  2462: bipush          16
            //  2464: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2467: aastore        
            //  2468: dup            
            //  2469: bipush          17
            //  2471: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENDER_DRAGON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2474: aastore        
            //  2475: dup            
            //  2476: bipush          18
            //  2478: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_CREATURE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2481: aastore        
            //  2482: dup            
            //  2483: bipush          19
            //  2485: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2488: aastore        
            //  2489: dup            
            //  2490: bipush          20
            //  2492: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.VILLAGER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2495: aastore        
            //  2496: dup            
            //  2497: bipush          21
            //  2499: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2502: aastore        
            //  2503: dup            
            //  2504: bipush          22
            //  2506: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.CHICKEN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2509: aastore        
            //  2510: dup            
            //  2511: bipush          23
            //  2513: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.COW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2516: aastore        
            //  2517: dup            
            //  2518: bipush          24
            //  2520: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.MOOSHROOM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2523: aastore        
            //  2524: dup            
            //  2525: bipush          25
            //  2527: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.PIG:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2530: aastore        
            //  2531: dup            
            //  2532: bipush          26
            //  2534: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.POLAR_BEAR:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2537: aastore        
            //  2538: dup            
            //  2539: bipush          27
            //  2541: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.RABBIT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2544: aastore        
            //  2545: dup            
            //  2546: bipush          28
            //  2548: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SHEEP:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2551: aastore        
            //  2552: dup            
            //  2553: bipush          29
            //  2555: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.TURTLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2558: aastore        
            //  2559: dup            
            //  2560: bipush          30
            //  2562: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_TAMEABLE_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2565: aastore        
            //  2566: dup            
            //  2567: bipush          31
            //  2569: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.OCELOT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2572: aastore        
            //  2573: dup            
            //  2574: bipush          32
            //  2576: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.WOLF:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2579: aastore        
            //  2580: dup            
            //  2581: bipush          33
            //  2583: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_PARROT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2586: aastore        
            //  2587: dup            
            //  2588: bipush          34
            //  2590: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.PARROT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2593: aastore        
            //  2594: dup            
            //  2595: bipush          35
            //  2597: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2600: aastore        
            //  2601: dup            
            //  2602: bipush          36
            //  2604: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.CHESTED_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2607: aastore        
            //  2608: dup            
            //  2609: bipush          37
            //  2611: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.DONKEY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2614: aastore        
            //  2615: dup            
            //  2616: bipush          38
            //  2618: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.MULE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2621: aastore        
            //  2622: dup            
            //  2623: bipush          39
            //  2625: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.LLAMA:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2628: aastore        
            //  2629: dup            
            //  2630: bipush          40
            //  2632: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2635: aastore        
            //  2636: dup            
            //  2637: bipush          41
            //  2639: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SKELETON_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2642: aastore        
            //  2643: dup            
            //  2644: bipush          42
            //  2646: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ZOMBIE_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2649: aastore        
            //  2650: dup            
            //  2651: bipush          43
            //  2653: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_GOLEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2656: aastore        
            //  2657: dup            
            //  2658: bipush          44
            //  2660: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SNOW_GOLEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2663: aastore        
            //  2664: dup            
            //  2665: bipush          45
            //  2667: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.IRON_GOLEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2670: aastore        
            //  2671: dup            
            //  2672: bipush          46
            //  2674: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SHULKER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2677: aastore        
            //  2678: dup            
            //  2679: bipush          47
            //  2681: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_FISHES:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2684: aastore        
            //  2685: dup            
            //  2686: bipush          48
            //  2688: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.COD:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2691: aastore        
            //  2692: dup            
            //  2693: bipush          49
            //  2695: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.PUFFERFISH:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2698: aastore        
            //  2699: dup            
            //  2700: bipush          50
            //  2702: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SALMON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2705: aastore        
            //  2706: dup            
            //  2707: bipush          51
            //  2709: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.TROPICAL_FISH:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2712: aastore        
            //  2713: dup            
            //  2714: bipush          52
            //  2716: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_MONSTER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2719: aastore        
            //  2720: dup            
            //  2721: bipush          53
            //  2723: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.BLAZE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2726: aastore        
            //  2727: dup            
            //  2728: bipush          54
            //  2730: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.CREEPER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2733: aastore        
            //  2734: dup            
            //  2735: bipush          55
            //  2737: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENDERMITE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2740: aastore        
            //  2741: dup            
            //  2742: bipush          56
            //  2744: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENDERMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2747: aastore        
            //  2748: dup            
            //  2749: bipush          57
            //  2751: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.GIANT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2754: aastore        
            //  2755: dup            
            //  2756: bipush          58
            //  2758: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SILVERFISH:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2761: aastore        
            //  2762: dup            
            //  2763: bipush          59
            //  2765: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.VEX:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2768: aastore        
            //  2769: dup            
            //  2770: bipush          60
            //  2772: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.WITCH:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2775: aastore        
            //  2776: dup            
            //  2777: bipush          61
            //  2779: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.WITHER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2782: aastore        
            //  2783: dup            
            //  2784: bipush          62
            //  2786: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_ILLAGER_BASE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2789: aastore        
            //  2790: dup            
            //  2791: bipush          63
            //  2793: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_EVO_ILLU_ILLAGER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2796: aastore        
            //  2797: dup            
            //  2798: bipush          64
            //  2800: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.EVOKER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2803: aastore        
            //  2804: dup            
            //  2805: bipush          65
            //  2807: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ILLUSIONER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2810: aastore        
            //  2811: dup            
            //  2812: bipush          66
            //  2814: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.VINDICATOR:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2817: aastore        
            //  2818: dup            
            //  2819: bipush          67
            //  2821: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_SKELETON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2824: aastore        
            //  2825: dup            
            //  2826: bipush          68
            //  2828: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SKELETON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2831: aastore        
            //  2832: dup            
            //  2833: bipush          69
            //  2835: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.STRAY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2838: aastore        
            //  2839: dup            
            //  2840: bipush          70
            //  2842: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.WITHER_SKELETON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2845: aastore        
            //  2846: dup            
            //  2847: bipush          71
            //  2849: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.GUARDIAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2852: aastore        
            //  2853: dup            
            //  2854: bipush          72
            //  2856: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ELDER_GUARDIAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2859: aastore        
            //  2860: dup            
            //  2861: bipush          73
            //  2863: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SPIDER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2866: aastore        
            //  2867: dup            
            //  2868: bipush          74
            //  2870: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.CAVE_SPIDER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2873: aastore        
            //  2874: dup            
            //  2875: bipush          75
            //  2877: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ZOMBIE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2880: aastore        
            //  2881: dup            
            //  2882: bipush          76
            //  2884: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.DROWNED:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2887: aastore        
            //  2888: dup            
            //  2889: bipush          77
            //  2891: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.HUSK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2894: aastore        
            //  2895: dup            
            //  2896: bipush          78
            //  2898: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ZOMBIE_PIGMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2901: aastore        
            //  2902: dup            
            //  2903: bipush          79
            //  2905: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ZOMBIE_VILLAGER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2908: aastore        
            //  2909: dup            
            //  2910: bipush          80
            //  2912: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_FLYING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2915: aastore        
            //  2916: dup            
            //  2917: bipush          81
            //  2919: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.GHAST:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2922: aastore        
            //  2923: dup            
            //  2924: bipush          82
            //  2926: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.PHANTOM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2929: aastore        
            //  2930: dup            
            //  2931: bipush          83
            //  2933: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_AMBIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2936: aastore        
            //  2937: dup            
            //  2938: bipush          84
            //  2940: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.BAT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2943: aastore        
            //  2944: dup            
            //  2945: bipush          85
            //  2947: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_WATERMOB:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2950: aastore        
            //  2951: dup            
            //  2952: bipush          86
            //  2954: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SQUID:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2957: aastore        
            //  2958: dup            
            //  2959: bipush          87
            //  2961: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.DOLPHIN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2964: aastore        
            //  2965: dup            
            //  2966: bipush          88
            //  2968: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SLIME:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2971: aastore        
            //  2972: dup            
            //  2973: bipush          89
            //  2975: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.MAGMA_CUBE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2978: aastore        
            //  2979: dup            
            //  2980: bipush          90
            //  2982: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_HANGING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2985: aastore        
            //  2986: dup            
            //  2987: bipush          91
            //  2989: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.LEASH_KNOT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2992: aastore        
            //  2993: dup            
            //  2994: bipush          92
            //  2996: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ITEM_FRAME:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  2999: aastore        
            //  3000: dup            
            //  3001: bipush          93
            //  3003: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.PAINTING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3006: aastore        
            //  3007: dup            
            //  3008: bipush          94
            //  3010: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_LIGHTNING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3013: aastore        
            //  3014: dup            
            //  3015: bipush          95
            //  3017: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.LIGHTNING_BOLT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3020: aastore        
            //  3021: dup            
            //  3022: bipush          96
            //  3024: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3027: aastore        
            //  3028: dup            
            //  3029: bipush          97
            //  3031: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3034: aastore        
            //  3035: dup            
            //  3036: bipush          98
            //  3038: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SPECTRAL_ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3041: aastore        
            //  3042: dup            
            //  3043: bipush          99
            //  3045: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.TRIDENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3048: aastore        
            //  3049: dup            
            //  3050: bipush          100
            //  3052: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ABSTRACT_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3055: aastore        
            //  3056: dup            
            //  3057: bipush          101
            //  3059: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.DRAGON_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3062: aastore        
            //  3063: dup            
            //  3064: bipush          102
            //  3066: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3069: aastore        
            //  3070: dup            
            //  3071: bipush          103
            //  3073: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SMALL_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3076: aastore        
            //  3077: dup            
            //  3078: bipush          104
            //  3080: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.WITHER_SKULL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3083: aastore        
            //  3084: dup            
            //  3085: bipush          105
            //  3087: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.PROJECTILE_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3090: aastore        
            //  3091: dup            
            //  3092: bipush          106
            //  3094: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SNOWBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3097: aastore        
            //  3098: dup            
            //  3099: bipush          107
            //  3101: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENDER_PEARL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3104: aastore        
            //  3105: dup            
            //  3106: bipush          108
            //  3108: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.EGG:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3111: aastore        
            //  3112: dup            
            //  3113: bipush          109
            //  3115: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.POTION:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3118: aastore        
            //  3119: dup            
            //  3120: bipush          110
            //  3122: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.EXPERIENCE_BOTTLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3125: aastore        
            //  3126: dup            
            //  3127: bipush          111
            //  3129: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3132: aastore        
            //  3133: dup            
            //  3134: bipush          112
            //  3136: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.CHESTED_MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3139: aastore        
            //  3140: dup            
            //  3141: bipush          113
            //  3143: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.CHEST_MINECART:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3146: aastore        
            //  3147: dup            
            //  3148: bipush          114
            //  3150: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.HOPPER_MINECART:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3153: aastore        
            //  3154: dup            
            //  3155: bipush          115
            //  3157: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.MINECART:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3160: aastore        
            //  3161: dup            
            //  3162: bipush          116
            //  3164: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.FURNACE_MINECART:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3167: aastore        
            //  3168: dup            
            //  3169: bipush          117
            //  3171: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.COMMAND_BLOCK_MINECART:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3174: aastore        
            //  3175: dup            
            //  3176: bipush          118
            //  3178: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.TNT_MINECART:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3181: aastore        
            //  3182: dup            
            //  3183: bipush          119
            //  3185: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SPAWNER_MINECART:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3188: aastore        
            //  3189: dup            
            //  3190: bipush          120
            //  3192: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.BOAT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3195: aastore        
            //  3196: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.$VALUES:[Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3199: new             Ljava/util/HashMap;
            //  3202: dup            
            //  3203: invokespecial   java/util/HashMap.<init>:()V
            //  3206: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.TYPES:Ljava/util/Map;
            //  3209: invokestatic    com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.values:()[Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //  3212: astore_0        /* lllllllllllllllIIIllllIIIIlIIlIl */
            //  3213: aload_0         /* lllllllllllllllIIIllllIIIIlIIlIl */
            //  3214: arraylength    
            //  3215: istore_1        /* lllllllllllllllIIIllllIIIIlIIlII */
            //  3216: iconst_0       
            //  3217: istore_2        /* lllllllllllllllIIIllllIIIIlIIIll */
            //  3218: iload_2         /* lllllllllllllllIIIllllIIIIlIIIll */
            //  3219: iload_1         /* lllllllllllllllIIIllllIIIIlIIlII */
            //  3220: if_icmpge       3250
            //  3223: aload_0         /* lllllllllllllllIIIllllIIIIlIIlIl */
            //  3224: iload_2         /* lllllllllllllllIIIllllIIIIlIIIll */
            //  3225: aaload         
            //  3226: astore_3        /* lllllllllllllllIIIllllIIIIlIIllI */
            //  3227: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.TYPES:Ljava/util/Map;
            //  3230: aload_3         /* lllllllllllllllIIIllllIIIIlIIllI */
            //  3231: getfield        com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.id:I
            //  3234: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
            //  3237: aload_3         /* lllllllllllllllIIIllllIIIIlIIllI */
            //  3238: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
            //  3243: pop            
            //  3244: iinc            lllllllllllllllIIIllllIIIIlIIIll, 1
            //  3247: goto            3218
            //  3250: return         
            //    StackMapTable: 00 02 FE 0C 92 07 02 35 01 01 1F
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
        
        private EntityType(final int lllllllllllllllIIIllllIIIlIIIlII) {
            this.id = lllllllllllllllIIIllllIIIlIIIlII;
            this.parent = null;
        }
        
        @Override
        public int getId() {
            return this.id;
        }
        
        @Override
        public EntityType getParent() {
            return this.parent;
        }
        
        public static Optional<EntityType> findById(final int lllllllllllllllIIIllllIIIIlIllll) {
            if (lllllllllllllllIIIllllIIIIlIllll == -1) {
                return Optional.empty();
            }
            return Optional.ofNullable(EntityType.TYPES.get(lllllllllllllllIIIllllIIIIlIllll));
        }
    }
    
    public enum ObjectType implements com.viaversion.viaversion.api.minecraft.entities.ObjectType
    {
        private final /* synthetic */ EntityType type;
        private static final /* synthetic */ Map<Integer, ObjectType> TYPES;
        private final /* synthetic */ int id;
        
        private ObjectType(final int lllllllllllllIlllIlIIllIIIIlIlIl, final EntityType lllllllllllllIlllIlIIllIIIIIllll) {
            this.id = lllllllllllllIlllIlIIllIIIIlIlIl;
            this.type = lllllllllllllIlllIlIIllIIIIIllll;
        }
        
        @Override
        public EntityType getType() {
            return this.type;
        }
        
        static {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     3: dup            
            //     4: ldc             "BOAT"
            //     6: iconst_0       
            //     7: iconst_1       
            //     8: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.BOAT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //    11: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //    14: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.BOAT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //    17: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //    20: dup            
            //    21: ldc             "ITEM"
            //    23: iconst_1       
            //    24: iconst_2       
            //    25: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ITEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //    28: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //    31: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.ITEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //    34: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //    37: dup            
            //    38: ldc             "AREA_EFFECT_CLOUD"
            //    40: iconst_2       
            //    41: iconst_3       
            //    42: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.AREA_EFFECT_CLOUD:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //    45: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //    48: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.AREA_EFFECT_CLOUD:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //    51: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //    54: dup            
            //    55: ldc             "MINECART"
            //    57: iconst_3       
            //    58: bipush          10
            //    60: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.MINECART:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //    63: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //    66: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.MINECART:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //    69: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //    72: dup            
            //    73: ldc             "TNT_PRIMED"
            //    75: iconst_4       
            //    76: bipush          50
            //    78: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.TNT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //    81: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //    84: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.TNT_PRIMED:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //    87: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //    90: dup            
            //    91: ldc             "ENDER_CRYSTAL"
            //    93: iconst_5       
            //    94: bipush          51
            //    96: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.END_CRYSTAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //    99: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   102: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.ENDER_CRYSTAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   105: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   108: dup            
            //   109: ldc             "TIPPED_ARROW"
            //   111: bipush          6
            //   113: bipush          60
            //   115: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   118: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   121: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.TIPPED_ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   124: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   127: dup            
            //   128: ldc             "SNOWBALL"
            //   130: bipush          7
            //   132: bipush          61
            //   134: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SNOWBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   137: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   140: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.SNOWBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   143: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   146: dup            
            //   147: ldc             "EGG"
            //   149: bipush          8
            //   151: bipush          62
            //   153: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.EGG:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   156: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   159: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.EGG:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   162: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   165: dup            
            //   166: ldc             "FIREBALL"
            //   168: bipush          9
            //   170: bipush          63
            //   172: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   175: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   178: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   181: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   184: dup            
            //   185: ldc             "SMALL_FIREBALL"
            //   187: bipush          10
            //   189: bipush          64
            //   191: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SMALL_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   194: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   197: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.SMALL_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   200: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   203: dup            
            //   204: ldc             "ENDER_PEARL"
            //   206: bipush          11
            //   208: bipush          65
            //   210: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ENDER_PEARL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   213: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   216: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.ENDER_PEARL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   219: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   222: dup            
            //   223: ldc             "WITHER_SKULL"
            //   225: bipush          12
            //   227: bipush          66
            //   229: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.WITHER_SKULL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   232: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   235: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.WITHER_SKULL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   238: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   241: dup            
            //   242: ldc             "SHULKER_BULLET"
            //   244: bipush          13
            //   246: bipush          67
            //   248: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SHULKER_BULLET:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   251: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   254: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.SHULKER_BULLET:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   257: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   260: dup            
            //   261: ldc             "LLAMA_SPIT"
            //   263: bipush          14
            //   265: bipush          68
            //   267: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.LLAMA_SPIT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   270: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   273: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.LLAMA_SPIT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   276: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   279: dup            
            //   280: ldc             "FALLING_BLOCK"
            //   282: bipush          15
            //   284: bipush          70
            //   286: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.FALLING_BLOCK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   289: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   292: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.FALLING_BLOCK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   295: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   298: dup            
            //   299: ldc             "ITEM_FRAME"
            //   301: bipush          16
            //   303: bipush          71
            //   305: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ITEM_FRAME:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   308: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   311: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.ITEM_FRAME:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   314: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   317: dup            
            //   318: ldc             "EYE_OF_ENDER"
            //   320: bipush          17
            //   322: bipush          72
            //   324: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.EYE_OF_ENDER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   327: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   330: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.EYE_OF_ENDER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   333: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   336: dup            
            //   337: ldc             "POTION"
            //   339: bipush          18
            //   341: bipush          73
            //   343: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.POTION:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   346: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   349: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.POTION:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   352: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   355: dup            
            //   356: ldc             "EXPERIENCE_BOTTLE"
            //   358: bipush          19
            //   360: bipush          75
            //   362: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.EXPERIENCE_BOTTLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   365: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   368: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.EXPERIENCE_BOTTLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   371: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   374: dup            
            //   375: ldc             "FIREWORK_ROCKET"
            //   377: bipush          20
            //   379: bipush          76
            //   381: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.FIREWORK_ROCKET:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   384: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   387: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.FIREWORK_ROCKET:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   390: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   393: dup            
            //   394: ldc             "LEASH"
            //   396: bipush          21
            //   398: bipush          77
            //   400: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.LEASH_KNOT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   403: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   406: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.LEASH:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   409: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   412: dup            
            //   413: ldc             "ARMOR_STAND"
            //   415: bipush          22
            //   417: bipush          78
            //   419: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.ARMOR_STAND:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   422: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   425: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.ARMOR_STAND:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   428: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   431: dup            
            //   432: ldc             "EVOKER_FANGS"
            //   434: bipush          23
            //   436: bipush          79
            //   438: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.EVOKER_FANGS:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   441: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   444: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.EVOKER_FANGS:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   447: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   450: dup            
            //   451: ldc             "FISHIHNG_HOOK"
            //   453: bipush          24
            //   455: bipush          90
            //   457: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.FISHING_BOBBER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   460: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   463: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.FISHIHNG_HOOK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   466: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   469: dup            
            //   470: ldc             "SPECTRAL_ARROW"
            //   472: bipush          25
            //   474: bipush          91
            //   476: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.SPECTRAL_ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   479: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   482: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.SPECTRAL_ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   485: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   488: dup            
            //   489: ldc             "DRAGON_FIREBALL"
            //   491: bipush          26
            //   493: bipush          93
            //   495: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.DRAGON_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   498: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   501: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.DRAGON_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   504: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   507: dup            
            //   508: ldc             "TRIDENT"
            //   510: bipush          27
            //   512: bipush          94
            //   514: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType.TRIDENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;
            //   517: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$EntityType;)V
            //   520: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.TRIDENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   523: bipush          28
            //   525: anewarray       Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   528: dup            
            //   529: iconst_0       
            //   530: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.BOAT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   533: aastore        
            //   534: dup            
            //   535: iconst_1       
            //   536: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.ITEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   539: aastore        
            //   540: dup            
            //   541: iconst_2       
            //   542: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.AREA_EFFECT_CLOUD:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   545: aastore        
            //   546: dup            
            //   547: iconst_3       
            //   548: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.MINECART:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   551: aastore        
            //   552: dup            
            //   553: iconst_4       
            //   554: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.TNT_PRIMED:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   557: aastore        
            //   558: dup            
            //   559: iconst_5       
            //   560: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.ENDER_CRYSTAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   563: aastore        
            //   564: dup            
            //   565: bipush          6
            //   567: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.TIPPED_ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   570: aastore        
            //   571: dup            
            //   572: bipush          7
            //   574: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.SNOWBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   577: aastore        
            //   578: dup            
            //   579: bipush          8
            //   581: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.EGG:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   584: aastore        
            //   585: dup            
            //   586: bipush          9
            //   588: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   591: aastore        
            //   592: dup            
            //   593: bipush          10
            //   595: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.SMALL_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   598: aastore        
            //   599: dup            
            //   600: bipush          11
            //   602: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.ENDER_PEARL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   605: aastore        
            //   606: dup            
            //   607: bipush          12
            //   609: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.WITHER_SKULL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   612: aastore        
            //   613: dup            
            //   614: bipush          13
            //   616: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.SHULKER_BULLET:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   619: aastore        
            //   620: dup            
            //   621: bipush          14
            //   623: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.LLAMA_SPIT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   626: aastore        
            //   627: dup            
            //   628: bipush          15
            //   630: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.FALLING_BLOCK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   633: aastore        
            //   634: dup            
            //   635: bipush          16
            //   637: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.ITEM_FRAME:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   640: aastore        
            //   641: dup            
            //   642: bipush          17
            //   644: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.EYE_OF_ENDER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   647: aastore        
            //   648: dup            
            //   649: bipush          18
            //   651: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.POTION:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   654: aastore        
            //   655: dup            
            //   656: bipush          19
            //   658: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.EXPERIENCE_BOTTLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   661: aastore        
            //   662: dup            
            //   663: bipush          20
            //   665: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.FIREWORK_ROCKET:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   668: aastore        
            //   669: dup            
            //   670: bipush          21
            //   672: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.LEASH:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   675: aastore        
            //   676: dup            
            //   677: bipush          22
            //   679: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.ARMOR_STAND:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   682: aastore        
            //   683: dup            
            //   684: bipush          23
            //   686: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.EVOKER_FANGS:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   689: aastore        
            //   690: dup            
            //   691: bipush          24
            //   693: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.FISHIHNG_HOOK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   696: aastore        
            //   697: dup            
            //   698: bipush          25
            //   700: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.SPECTRAL_ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   703: aastore        
            //   704: dup            
            //   705: bipush          26
            //   707: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.DRAGON_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   710: aastore        
            //   711: dup            
            //   712: bipush          27
            //   714: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.TRIDENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   717: aastore        
            //   718: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.$VALUES:[Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   721: new             Ljava/util/HashMap;
            //   724: dup            
            //   725: invokespecial   java/util/HashMap.<init>:()V
            //   728: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.TYPES:Ljava/util/Map;
            //   731: invokestatic    com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.values:()[Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType;
            //   734: astore_0        /* lllllllllllllIlllIlIIlIllllIlIll */
            //   735: aload_0         /* lllllllllllllIlllIlIIlIllllIlIll */
            //   736: arraylength    
            //   737: istore_1        /* lllllllllllllIlllIlIIlIllllIlIlI */
            //   738: iconst_0       
            //   739: istore_2        /* lllllllllllllIlllIlIIlIllllIlIIl */
            //   740: iload_2         /* lllllllllllllIlllIlIIlIllllIlIIl */
            //   741: iload_1         /* lllllllllllllIlllIlIIlIllllIlIlI */
            //   742: if_icmpge       772
            //   745: aload_0         /* lllllllllllllIlllIlIIlIllllIlIll */
            //   746: iload_2         /* lllllllllllllIlllIlIIlIllllIlIIl */
            //   747: aaload         
            //   748: astore_3        /* lllllllllllllIlllIlIIlIllllIlIII */
            //   749: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.TYPES:Ljava/util/Map;
            //   752: aload_3         /* lllllllllllllIlllIlIIlIllllIllII */
            //   753: getfield        com/viaversion/viaversion/api/minecraft/entities/Entity1_13Types$ObjectType.id:I
            //   756: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
            //   759: aload_3         /* lllllllllllllIlllIlIIlIllllIllII */
            //   760: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
            //   765: pop            
            //   766: iinc            lllllllllllllIlllIlIIlIllllIlIIl, 1
            //   769: goto            740
            //   772: return         
            //    StackMapTable: 00 02 FE 02 E4 07 01 0C 01 01 1F
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
        
        public static Optional<ObjectType> fromEntityType(final EntityType lllllllllllllIlllIlIIlIllllllIIl) {
            final short lllllllllllllIlllIlIIlIlllllIlll = (Object)values();
            final char lllllllllllllIlllIlIIlIlllllIllI = (char)lllllllllllllIlllIlIIlIlllllIlll.length;
            for (double lllllllllllllIlllIlIIlIlllllIlIl = 0; lllllllllllllIlllIlIIlIlllllIlIl < lllllllllllllIlllIlIIlIlllllIllI; ++lllllllllllllIlllIlIIlIlllllIlIl) {
                final ObjectType lllllllllllllIlllIlIIlIllllllIlI = lllllllllllllIlllIlIIlIlllllIlll[lllllllllllllIlllIlIIlIlllllIlIl];
                if (lllllllllllllIlllIlIIlIllllllIlI.type == lllllllllllllIlllIlIIlIllllllIIl) {
                    return Optional.of(lllllllllllllIlllIlIIlIllllllIlI);
                }
            }
            return Optional.empty();
        }
        
        public static Optional<ObjectType> findById(final int lllllllllllllIlllIlIIllIIIIIIllI) {
            if (lllllllllllllIlllIlIIllIIIIIIllI == -1) {
                return Optional.empty();
            }
            return Optional.ofNullable(ObjectType.TYPES.get(lllllllllllllIlllIlIIllIIIIIIllI));
        }
        
        @Override
        public int getId() {
            return this.id;
        }
        
        public static Optional<EntityType> getPCEntity(final int lllllllllllllIlllIlIIllIIIIIIIIl) {
            final Optional<ObjectType> lllllllllllllIlllIlIIllIIIIIIIlI = findById(lllllllllllllIlllIlIIllIIIIIIIIl);
            if (!lllllllllllllIlllIlIIllIIIIIIIlI.isPresent()) {
                return Optional.empty();
            }
            return Optional.of(lllllllllllllIlllIlIIllIIIIIIIlI.get().type);
        }
    }
}
