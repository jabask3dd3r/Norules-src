package com.viaversion.viaversion.api.minecraft.entities;

import com.viaversion.viaversion.api.*;
import java.util.*;

public class Entity1_10Types
{
    public static EntityType getTypeFromId(final int lIIIIIllIIlIlll, final boolean lIIIIIllIIllIIl) {
        Optional<EntityType> lIIIIIllIIllIII = null;
        if (lIIIIIllIIllIIl) {
            final Optional<EntityType> lIIIIIllIIllIll = ObjectType.getPCEntity(lIIIIIllIIlIlll);
        }
        else {
            lIIIIIllIIllIII = EntityType.findById(lIIIIIllIIlIlll);
        }
        if (!lIIIIIllIIllIII.isPresent()) {
            Via.getPlatform().getLogger().severe(String.valueOf(new StringBuilder().append("Could not find 1.10 type id ").append(lIIIIIllIIlIlll).append(" isObject=").append(lIIIIIllIIllIIl)));
            return EntityType.ENTITY;
        }
        return lIIIIIllIIllIII.get();
    }
    
    public enum ObjectType implements com.viaversion.viaversion.api.minecraft.entities.ObjectType
    {
        ITEM_FRAME(71, EntityType.ITEM_FRAME), 
        SHULKER_BULLET(67, EntityType.SHULKER_BULLET), 
        DRAGON_FIREBALL(93, EntityType.DRAGON_FIREBALL), 
        FISHIHNG_HOOK(90, EntityType.FISHING_HOOK), 
        SPECTRAL_ARROW(91, EntityType.SPECTRAL_ARROW), 
        BOAT(1, EntityType.BOAT), 
        FIREBALL(63, EntityType.FIREBALL), 
        SMALL_FIREBALL(64, EntityType.SMALL_FIREBALL), 
        TIPPED_ARROW(60, EntityType.TIPPED_ARROW), 
        POTION(73, EntityType.SPLASH_POTION), 
        WITHER_SKULL(66, EntityType.WITHER_SKULL), 
        AREA_EFFECT_CLOUD(3, EntityType.AREA_EFFECT_CLOUD), 
        THROWN_EXP_BOTTLE(75, EntityType.THROWN_EXP_BOTTLE);
        
        private final /* synthetic */ EntityType type;
        private static final /* synthetic */ Map<Integer, ObjectType> TYPES;
        
        LEASH(77, EntityType.LEASH_HITCH);
        
        private final /* synthetic */ int id;
        
        ENDER_PEARL(65, EntityType.ENDER_PEARL), 
        EGG(62, EntityType.EGG), 
        ARMOR_STAND(78, EntityType.ARMOR_STAND), 
        FIREWORK(76, EntityType.FIREWORK), 
        TNT_PRIMED(50, EntityType.PRIMED_TNT), 
        ITEM(2, EntityType.DROPPED_ITEM), 
        ENDER_SIGNAL(72, EntityType.ENDER_SIGNAL), 
        ENDER_CRYSTAL(51, EntityType.ENDER_CRYSTAL), 
        SNOWBALL(61, EntityType.SNOWBALL), 
        FALLING_BLOCK(70, EntityType.FALLING_BLOCK), 
        MINECART(10, EntityType.MINECART_RIDEABLE);
        
        static {
            TYPES = new HashMap<Integer, ObjectType>();
            final boolean lllllllllllllIIlIlIlllIllIlIlIll = (Object)values();
            for (boolean lllllllllllllIIlIlIlllIllIlIlIlI = lllllllllllllIIlIlIlllIllIlIlIll.length != 0, lllllllllllllIIlIlIlllIllIlIlIIl = false; lllllllllllllIIlIlIlllIllIlIlIIl < lllllllllllllIIlIlIlllIllIlIlIlI; ++lllllllllllllIIlIlIlllIllIlIlIIl) {
                final ObjectType lllllllllllllIIlIlIlllIllIlIllII = lllllllllllllIIlIlIlllIllIlIlIll[lllllllllllllIIlIlIlllIllIlIlIIl];
                ObjectType.TYPES.put(lllllllllllllIIlIlIlllIllIlIllII.id, lllllllllllllIIlIlIlllIllIlIllII);
            }
        }
        
        @Override
        public EntityType getType() {
            return this.type;
        }
        
        public static Optional<ObjectType> findById(final int lllllllllllllIIlIlIlllIllIlllIlI) {
            if (lllllllllllllIIlIlIlllIllIlllIlI == -1) {
                return Optional.empty();
            }
            return Optional.ofNullable(ObjectType.TYPES.get(lllllllllllllIIlIlIlllIllIlllIlI));
        }
        
        public static Optional<EntityType> getPCEntity(final int lllllllllllllIIlIlIlllIllIllIlIl) {
            final Optional<ObjectType> lllllllllllllIIlIlIlllIllIllIllI = findById(lllllllllllllIIlIlIlllIllIllIlIl);
            if (!lllllllllllllIIlIlIlllIllIllIllI.isPresent()) {
                return Optional.empty();
            }
            return Optional.of(lllllllllllllIIlIlIlllIllIllIllI.get().type);
        }
        
        @Override
        public int getId() {
            return this.id;
        }
        
        private ObjectType(final int lllllllllllllIIlIlIlllIlllIIlIIl, final EntityType lllllllllllllIIlIlIlllIlllIIIIll) {
            this.id = lllllllllllllIIlIlIlllIlllIIlIIl;
            this.type = lllllllllllllIIlIlIlllIlllIIIIll;
        }
    }
    
    public enum EntityType implements com.viaversion.viaversion.api.minecraft.entities.EntityType
    {
        public static final /* synthetic */ EntityType ITEM_FRAME;
        public static final /* synthetic */ EntityType FISHING_HOOK;
        public static final /* synthetic */ EntityType TIPPED_ARROW;
        private final /* synthetic */ int id;
        private static final /* synthetic */ Map<Integer, EntityType> TYPES;
        public static final /* synthetic */ EntityType ENDER_PEARL;
        public static final /* synthetic */ EntityType ENTITY;
        public static final /* synthetic */ EntityType BOAT;
        public static final /* synthetic */ EntityType FIREBALL;
        public static final /* synthetic */ EntityType DROPPED_ITEM;
        public static final /* synthetic */ EntityType SMALL_FIREBALL;
        public static final /* synthetic */ EntityType ENDER_SIGNAL;
        public static final /* synthetic */ EntityType PRIMED_TNT;
        public static final /* synthetic */ EntityType MINECART_RIDEABLE;
        public static final /* synthetic */ EntityType WITHER_SKULL;
        public static final /* synthetic */ EntityType ARMOR_STAND;
        public static final /* synthetic */ EntityType SHULKER_BULLET;
        public static final /* synthetic */ EntityType EGG;
        public static final /* synthetic */ EntityType AREA_EFFECT_CLOUD;
        public static final /* synthetic */ EntityType SNOWBALL;
        public static final /* synthetic */ EntityType SPLASH_POTION;
        public static final /* synthetic */ EntityType LEASH_HITCH;
        public static final /* synthetic */ EntityType FIREWORK;
        public static final /* synthetic */ EntityType SPECTRAL_ARROW;
        public static final /* synthetic */ EntityType DRAGON_FIREBALL;
        public static final /* synthetic */ EntityType THROWN_EXP_BOTTLE;
        private final /* synthetic */ EntityType parent;
        public static final /* synthetic */ EntityType FALLING_BLOCK;
        public static final /* synthetic */ EntityType ENDER_CRYSTAL;
        
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
            //     8: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;II)V
            //    11: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //    14: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //    17: dup            
            //    18: ldc             "DROPPED_ITEM"
            //    20: iconst_1       
            //    21: iconst_1       
            //    22: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //    25: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //    28: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.DROPPED_ITEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //    31: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //    34: dup            
            //    35: ldc             "EXPERIENCE_ORB"
            //    37: iconst_2       
            //    38: iconst_2       
            //    39: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //    42: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //    45: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.EXPERIENCE_ORB:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //    48: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //    51: dup            
            //    52: ldc             "LEASH_HITCH"
            //    54: iconst_3       
            //    55: bipush          8
            //    57: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //    60: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //    63: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.LEASH_HITCH:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //    66: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //    69: dup            
            //    70: ldc             "PAINTING"
            //    72: iconst_4       
            //    73: bipush          9
            //    75: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //    78: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //    81: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.PAINTING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //    84: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //    87: dup            
            //    88: ldc             "ARROW"
            //    90: iconst_5       
            //    91: bipush          10
            //    93: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //    96: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //    99: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   102: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   105: dup            
            //   106: ldc             "SNOWBALL"
            //   108: bipush          6
            //   110: bipush          11
            //   112: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   115: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   118: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SNOWBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   121: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   124: dup            
            //   125: ldc             "FIREBALL"
            //   127: bipush          7
            //   129: bipush          12
            //   131: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   134: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   137: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   140: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   143: dup            
            //   144: ldc             "SMALL_FIREBALL"
            //   146: bipush          8
            //   148: bipush          13
            //   150: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   153: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   156: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SMALL_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   159: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   162: dup            
            //   163: ldc             "ENDER_PEARL"
            //   165: bipush          9
            //   167: bipush          14
            //   169: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   172: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   175: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENDER_PEARL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   178: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   181: dup            
            //   182: ldc             "ENDER_SIGNAL"
            //   184: bipush          10
            //   186: bipush          15
            //   188: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   191: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   194: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENDER_SIGNAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   197: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   200: dup            
            //   201: ldc             "THROWN_EXP_BOTTLE"
            //   203: bipush          11
            //   205: bipush          17
            //   207: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   210: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   213: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.THROWN_EXP_BOTTLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   216: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   219: dup            
            //   220: ldc             "ITEM_FRAME"
            //   222: bipush          12
            //   224: bipush          18
            //   226: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   229: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   232: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ITEM_FRAME:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   235: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   238: dup            
            //   239: ldc             "WITHER_SKULL"
            //   241: bipush          13
            //   243: bipush          19
            //   245: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   248: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   251: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.WITHER_SKULL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   254: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   257: dup            
            //   258: ldc             "PRIMED_TNT"
            //   260: bipush          14
            //   262: bipush          20
            //   264: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   267: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   270: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.PRIMED_TNT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   273: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   276: dup            
            //   277: ldc             "FALLING_BLOCK"
            //   279: bipush          15
            //   281: bipush          21
            //   283: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   286: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   289: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.FALLING_BLOCK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   292: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   295: dup            
            //   296: ldc             "FIREWORK"
            //   298: bipush          16
            //   300: bipush          22
            //   302: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   305: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   308: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.FIREWORK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   311: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   314: dup            
            //   315: ldc             "TIPPED_ARROW"
            //   317: bipush          17
            //   319: bipush          23
            //   321: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   324: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   327: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.TIPPED_ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   330: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   333: dup            
            //   334: ldc             "SPECTRAL_ARROW"
            //   336: bipush          18
            //   338: bipush          24
            //   340: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   343: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   346: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SPECTRAL_ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   349: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   352: dup            
            //   353: ldc             "SHULKER_BULLET"
            //   355: bipush          19
            //   357: bipush          25
            //   359: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   362: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   365: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SHULKER_BULLET:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   368: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   371: dup            
            //   372: ldc             "DRAGON_FIREBALL"
            //   374: bipush          20
            //   376: bipush          26
            //   378: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   381: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   384: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.DRAGON_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   387: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   390: dup            
            //   391: ldc             "ENTITY_LIVING"
            //   393: bipush          21
            //   395: iconst_m1      
            //   396: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   399: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   402: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_LIVING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   405: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   408: dup            
            //   409: ldc             "ENTITY_INSENTIENT"
            //   411: bipush          22
            //   413: iconst_m1      
            //   414: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_LIVING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   417: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   420: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   423: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   426: dup            
            //   427: ldc             "ENTITY_AGEABLE"
            //   429: bipush          23
            //   431: iconst_m1      
            //   432: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   435: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   438: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   441: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   444: dup            
            //   445: ldc             "ENTITY_TAMEABLE_ANIMAL"
            //   447: bipush          24
            //   449: iconst_m1      
            //   450: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   453: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   456: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_TAMEABLE_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   459: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   462: dup            
            //   463: ldc             "ENTITY_HUMAN"
            //   465: bipush          25
            //   467: iconst_m1      
            //   468: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_LIVING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   471: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   474: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_HUMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   477: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   480: dup            
            //   481: ldc             "ARMOR_STAND"
            //   483: bipush          26
            //   485: bipush          30
            //   487: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_LIVING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   490: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   493: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ARMOR_STAND:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   496: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   499: dup            
            //   500: ldc             "MINECART_ABSTRACT"
            //   502: bipush          27
            //   504: iconst_m1      
            //   505: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   508: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   511: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   514: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   517: dup            
            //   518: ldc             "MINECART_COMMAND"
            //   520: bipush          28
            //   522: bipush          40
            //   524: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   527: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   530: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_COMMAND:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   533: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   536: dup            
            //   537: ldc             "BOAT"
            //   539: bipush          29
            //   541: bipush          41
            //   543: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   546: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   549: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.BOAT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   552: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   555: dup            
            //   556: ldc             "MINECART_RIDEABLE"
            //   558: bipush          30
            //   560: bipush          42
            //   562: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   565: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   568: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_RIDEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   571: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   574: dup            
            //   575: ldc             "MINECART_CHEST"
            //   577: bipush          31
            //   579: bipush          43
            //   581: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   584: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   587: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_CHEST:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   590: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   593: dup            
            //   594: ldc             "MINECART_FURNACE"
            //   596: bipush          32
            //   598: bipush          44
            //   600: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   603: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   606: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_FURNACE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   609: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   612: dup            
            //   613: ldc             "MINECART_TNT"
            //   615: bipush          33
            //   617: bipush          45
            //   619: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   622: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   625: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_TNT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   628: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   631: dup            
            //   632: ldc             "MINECART_HOPPER"
            //   634: bipush          34
            //   636: bipush          46
            //   638: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   641: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   644: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_HOPPER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   647: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   650: dup            
            //   651: ldc             "MINECART_MOB_SPAWNER"
            //   653: bipush          35
            //   655: bipush          47
            //   657: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   660: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   663: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_MOB_SPAWNER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   666: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   669: dup            
            //   670: ldc             "CREEPER"
            //   672: bipush          36
            //   674: bipush          50
            //   676: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   679: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   682: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.CREEPER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   685: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   688: dup            
            //   689: ldc             "SKELETON"
            //   691: bipush          37
            //   693: bipush          51
            //   695: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   698: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   701: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SKELETON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   704: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   707: dup            
            //   708: ldc             "SPIDER"
            //   710: bipush          38
            //   712: bipush          52
            //   714: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   717: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   720: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SPIDER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   723: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   726: dup            
            //   727: ldc             "GIANT"
            //   729: bipush          39
            //   731: bipush          53
            //   733: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   736: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   739: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.GIANT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   742: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   745: dup            
            //   746: ldc             "ZOMBIE"
            //   748: bipush          40
            //   750: bipush          54
            //   752: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   755: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   758: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ZOMBIE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   761: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   764: dup            
            //   765: ldc             "SLIME"
            //   767: bipush          41
            //   769: bipush          55
            //   771: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   774: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   777: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SLIME:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   780: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   783: dup            
            //   784: ldc             "GHAST"
            //   786: bipush          42
            //   788: bipush          56
            //   790: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   793: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   796: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.GHAST:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   799: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   802: dup            
            //   803: ldc             "PIG_ZOMBIE"
            //   805: bipush          43
            //   807: bipush          57
            //   809: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ZOMBIE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   812: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   815: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.PIG_ZOMBIE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   818: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   821: dup            
            //   822: ldc             "ENDERMAN"
            //   824: bipush          44
            //   826: bipush          58
            //   828: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   831: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   834: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENDERMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   837: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   840: dup            
            //   841: ldc             "CAVE_SPIDER"
            //   843: bipush          45
            //   845: bipush          59
            //   847: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SPIDER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   850: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   853: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.CAVE_SPIDER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   856: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   859: dup            
            //   860: ldc             "SILVERFISH"
            //   862: bipush          46
            //   864: bipush          60
            //   866: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   869: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   872: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SILVERFISH:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   875: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   878: dup            
            //   879: ldc             "BLAZE"
            //   881: bipush          47
            //   883: bipush          61
            //   885: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   888: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   891: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.BLAZE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   894: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   897: dup            
            //   898: ldc             "MAGMA_CUBE"
            //   900: bipush          48
            //   902: bipush          62
            //   904: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SLIME:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   907: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   910: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MAGMA_CUBE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   913: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   916: dup            
            //   917: ldc_w           "ENDER_DRAGON"
            //   920: bipush          49
            //   922: bipush          63
            //   924: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   927: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   930: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENDER_DRAGON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   933: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   936: dup            
            //   937: ldc_w           "WITHER"
            //   940: bipush          50
            //   942: bipush          64
            //   944: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   947: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   950: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.WITHER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   953: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   956: dup            
            //   957: ldc_w           "BAT"
            //   960: bipush          51
            //   962: bipush          65
            //   964: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   967: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   970: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.BAT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   973: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   976: dup            
            //   977: ldc_w           "WITCH"
            //   980: bipush          52
            //   982: bipush          66
            //   984: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   987: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //   990: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.WITCH:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   993: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //   996: dup            
            //   997: ldc_w           "ENDERMITE"
            //  1000: bipush          53
            //  1002: bipush          67
            //  1004: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1007: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1010: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENDERMITE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1013: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1016: dup            
            //  1017: ldc_w           "GUARDIAN"
            //  1020: bipush          54
            //  1022: bipush          68
            //  1024: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1027: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1030: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.GUARDIAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1033: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1036: dup            
            //  1037: ldc_w           "IRON_GOLEM"
            //  1040: bipush          55
            //  1042: bipush          99
            //  1044: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1047: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1050: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.IRON_GOLEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1053: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1056: dup            
            //  1057: ldc_w           "SHULKER"
            //  1060: bipush          56
            //  1062: bipush          69
            //  1064: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.IRON_GOLEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1067: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1070: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SHULKER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1073: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1076: dup            
            //  1077: ldc_w           "PIG"
            //  1080: bipush          57
            //  1082: bipush          90
            //  1084: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1087: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1090: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.PIG:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1093: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1096: dup            
            //  1097: ldc_w           "SHEEP"
            //  1100: bipush          58
            //  1102: bipush          91
            //  1104: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1107: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1110: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SHEEP:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1113: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1116: dup            
            //  1117: ldc_w           "COW"
            //  1120: bipush          59
            //  1122: bipush          92
            //  1124: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1127: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1130: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.COW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1133: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1136: dup            
            //  1137: ldc_w           "CHICKEN"
            //  1140: bipush          60
            //  1142: bipush          93
            //  1144: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1147: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1150: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.CHICKEN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1153: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1156: dup            
            //  1157: ldc_w           "SQUID"
            //  1160: bipush          61
            //  1162: bipush          94
            //  1164: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1167: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1170: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SQUID:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1173: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1176: dup            
            //  1177: ldc_w           "WOLF"
            //  1180: bipush          62
            //  1182: bipush          95
            //  1184: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_TAMEABLE_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1187: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1190: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.WOLF:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1193: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1196: dup            
            //  1197: ldc_w           "MUSHROOM_COW"
            //  1200: bipush          63
            //  1202: bipush          96
            //  1204: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.COW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1207: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1210: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MUSHROOM_COW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1213: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1216: dup            
            //  1217: ldc_w           "SNOWMAN"
            //  1220: bipush          64
            //  1222: bipush          97
            //  1224: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.IRON_GOLEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1227: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1230: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SNOWMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1233: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1236: dup            
            //  1237: ldc_w           "OCELOT"
            //  1240: bipush          65
            //  1242: bipush          98
            //  1244: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_TAMEABLE_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1247: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1250: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.OCELOT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1253: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1256: dup            
            //  1257: ldc_w           "HORSE"
            //  1260: bipush          66
            //  1262: bipush          100
            //  1264: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1267: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1270: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1273: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1276: dup            
            //  1277: ldc_w           "RABBIT"
            //  1280: bipush          67
            //  1282: bipush          101
            //  1284: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1287: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1290: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.RABBIT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1293: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1296: dup            
            //  1297: ldc_w           "POLAR_BEAR"
            //  1300: bipush          68
            //  1302: bipush          102
            //  1304: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1307: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1310: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.POLAR_BEAR:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1313: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1316: dup            
            //  1317: ldc_w           "VILLAGER"
            //  1320: bipush          69
            //  1322: bipush          120
            //  1324: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1327: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1330: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.VILLAGER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1333: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1336: dup            
            //  1337: ldc_w           "ENDER_CRYSTAL"
            //  1340: bipush          70
            //  1342: sipush          200
            //  1345: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1348: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1351: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENDER_CRYSTAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1354: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1357: dup            
            //  1358: ldc_w           "SPLASH_POTION"
            //  1361: bipush          71
            //  1363: iconst_m1      
            //  1364: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1367: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1370: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SPLASH_POTION:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1373: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1376: dup            
            //  1377: ldc_w           "LINGERING_POTION"
            //  1380: bipush          72
            //  1382: iconst_m1      
            //  1383: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SPLASH_POTION:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1386: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1389: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.LINGERING_POTION:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1392: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1395: dup            
            //  1396: ldc_w           "AREA_EFFECT_CLOUD"
            //  1399: bipush          73
            //  1401: iconst_m1      
            //  1402: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1405: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1408: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.AREA_EFFECT_CLOUD:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1411: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1414: dup            
            //  1415: ldc_w           "EGG"
            //  1418: bipush          74
            //  1420: iconst_m1      
            //  1421: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1424: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1427: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.EGG:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1430: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1433: dup            
            //  1434: ldc_w           "FISHING_HOOK"
            //  1437: bipush          75
            //  1439: iconst_m1      
            //  1440: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1443: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1446: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.FISHING_HOOK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1449: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1452: dup            
            //  1453: ldc_w           "LIGHTNING"
            //  1456: bipush          76
            //  1458: iconst_m1      
            //  1459: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1462: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1465: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.LIGHTNING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1468: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1471: dup            
            //  1472: ldc_w           "WEATHER"
            //  1475: bipush          77
            //  1477: iconst_m1      
            //  1478: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1481: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1484: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.WEATHER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1487: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1490: dup            
            //  1491: ldc_w           "PLAYER"
            //  1494: bipush          78
            //  1496: iconst_m1      
            //  1497: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_HUMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1500: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1503: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.PLAYER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1506: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1509: dup            
            //  1510: ldc_w           "COMPLEX_PART"
            //  1513: bipush          79
            //  1515: iconst_m1      
            //  1516: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1519: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;)V
            //  1522: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.COMPLEX_PART:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1525: bipush          80
            //  1527: anewarray       Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1530: dup            
            //  1531: iconst_0       
            //  1532: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1535: aastore        
            //  1536: dup            
            //  1537: iconst_1       
            //  1538: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.DROPPED_ITEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1541: aastore        
            //  1542: dup            
            //  1543: iconst_2       
            //  1544: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.EXPERIENCE_ORB:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1547: aastore        
            //  1548: dup            
            //  1549: iconst_3       
            //  1550: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.LEASH_HITCH:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1553: aastore        
            //  1554: dup            
            //  1555: iconst_4       
            //  1556: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.PAINTING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1559: aastore        
            //  1560: dup            
            //  1561: iconst_5       
            //  1562: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1565: aastore        
            //  1566: dup            
            //  1567: bipush          6
            //  1569: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SNOWBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1572: aastore        
            //  1573: dup            
            //  1574: bipush          7
            //  1576: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1579: aastore        
            //  1580: dup            
            //  1581: bipush          8
            //  1583: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SMALL_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1586: aastore        
            //  1587: dup            
            //  1588: bipush          9
            //  1590: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENDER_PEARL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1593: aastore        
            //  1594: dup            
            //  1595: bipush          10
            //  1597: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENDER_SIGNAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1600: aastore        
            //  1601: dup            
            //  1602: bipush          11
            //  1604: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.THROWN_EXP_BOTTLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1607: aastore        
            //  1608: dup            
            //  1609: bipush          12
            //  1611: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ITEM_FRAME:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1614: aastore        
            //  1615: dup            
            //  1616: bipush          13
            //  1618: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.WITHER_SKULL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1621: aastore        
            //  1622: dup            
            //  1623: bipush          14
            //  1625: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.PRIMED_TNT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1628: aastore        
            //  1629: dup            
            //  1630: bipush          15
            //  1632: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.FALLING_BLOCK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1635: aastore        
            //  1636: dup            
            //  1637: bipush          16
            //  1639: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.FIREWORK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1642: aastore        
            //  1643: dup            
            //  1644: bipush          17
            //  1646: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.TIPPED_ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1649: aastore        
            //  1650: dup            
            //  1651: bipush          18
            //  1653: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SPECTRAL_ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1656: aastore        
            //  1657: dup            
            //  1658: bipush          19
            //  1660: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SHULKER_BULLET:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1663: aastore        
            //  1664: dup            
            //  1665: bipush          20
            //  1667: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.DRAGON_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1670: aastore        
            //  1671: dup            
            //  1672: bipush          21
            //  1674: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_LIVING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1677: aastore        
            //  1678: dup            
            //  1679: bipush          22
            //  1681: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1684: aastore        
            //  1685: dup            
            //  1686: bipush          23
            //  1688: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1691: aastore        
            //  1692: dup            
            //  1693: bipush          24
            //  1695: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_TAMEABLE_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1698: aastore        
            //  1699: dup            
            //  1700: bipush          25
            //  1702: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_HUMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1705: aastore        
            //  1706: dup            
            //  1707: bipush          26
            //  1709: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ARMOR_STAND:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1712: aastore        
            //  1713: dup            
            //  1714: bipush          27
            //  1716: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1719: aastore        
            //  1720: dup            
            //  1721: bipush          28
            //  1723: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_COMMAND:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1726: aastore        
            //  1727: dup            
            //  1728: bipush          29
            //  1730: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.BOAT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1733: aastore        
            //  1734: dup            
            //  1735: bipush          30
            //  1737: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_RIDEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1740: aastore        
            //  1741: dup            
            //  1742: bipush          31
            //  1744: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_CHEST:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1747: aastore        
            //  1748: dup            
            //  1749: bipush          32
            //  1751: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_FURNACE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1754: aastore        
            //  1755: dup            
            //  1756: bipush          33
            //  1758: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_TNT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1761: aastore        
            //  1762: dup            
            //  1763: bipush          34
            //  1765: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_HOPPER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1768: aastore        
            //  1769: dup            
            //  1770: bipush          35
            //  1772: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_MOB_SPAWNER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1775: aastore        
            //  1776: dup            
            //  1777: bipush          36
            //  1779: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.CREEPER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1782: aastore        
            //  1783: dup            
            //  1784: bipush          37
            //  1786: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SKELETON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1789: aastore        
            //  1790: dup            
            //  1791: bipush          38
            //  1793: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SPIDER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1796: aastore        
            //  1797: dup            
            //  1798: bipush          39
            //  1800: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.GIANT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1803: aastore        
            //  1804: dup            
            //  1805: bipush          40
            //  1807: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ZOMBIE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1810: aastore        
            //  1811: dup            
            //  1812: bipush          41
            //  1814: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SLIME:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1817: aastore        
            //  1818: dup            
            //  1819: bipush          42
            //  1821: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.GHAST:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1824: aastore        
            //  1825: dup            
            //  1826: bipush          43
            //  1828: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.PIG_ZOMBIE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1831: aastore        
            //  1832: dup            
            //  1833: bipush          44
            //  1835: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENDERMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1838: aastore        
            //  1839: dup            
            //  1840: bipush          45
            //  1842: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.CAVE_SPIDER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1845: aastore        
            //  1846: dup            
            //  1847: bipush          46
            //  1849: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SILVERFISH:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1852: aastore        
            //  1853: dup            
            //  1854: bipush          47
            //  1856: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.BLAZE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1859: aastore        
            //  1860: dup            
            //  1861: bipush          48
            //  1863: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MAGMA_CUBE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1866: aastore        
            //  1867: dup            
            //  1868: bipush          49
            //  1870: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENDER_DRAGON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1873: aastore        
            //  1874: dup            
            //  1875: bipush          50
            //  1877: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.WITHER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1880: aastore        
            //  1881: dup            
            //  1882: bipush          51
            //  1884: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.BAT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1887: aastore        
            //  1888: dup            
            //  1889: bipush          52
            //  1891: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.WITCH:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1894: aastore        
            //  1895: dup            
            //  1896: bipush          53
            //  1898: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENDERMITE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1901: aastore        
            //  1902: dup            
            //  1903: bipush          54
            //  1905: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.GUARDIAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1908: aastore        
            //  1909: dup            
            //  1910: bipush          55
            //  1912: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.IRON_GOLEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1915: aastore        
            //  1916: dup            
            //  1917: bipush          56
            //  1919: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SHULKER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1922: aastore        
            //  1923: dup            
            //  1924: bipush          57
            //  1926: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.PIG:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1929: aastore        
            //  1930: dup            
            //  1931: bipush          58
            //  1933: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SHEEP:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1936: aastore        
            //  1937: dup            
            //  1938: bipush          59
            //  1940: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.COW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1943: aastore        
            //  1944: dup            
            //  1945: bipush          60
            //  1947: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.CHICKEN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1950: aastore        
            //  1951: dup            
            //  1952: bipush          61
            //  1954: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SQUID:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1957: aastore        
            //  1958: dup            
            //  1959: bipush          62
            //  1961: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.WOLF:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1964: aastore        
            //  1965: dup            
            //  1966: bipush          63
            //  1968: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MUSHROOM_COW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1971: aastore        
            //  1972: dup            
            //  1973: bipush          64
            //  1975: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SNOWMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1978: aastore        
            //  1979: dup            
            //  1980: bipush          65
            //  1982: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.OCELOT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1985: aastore        
            //  1986: dup            
            //  1987: bipush          66
            //  1989: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1992: aastore        
            //  1993: dup            
            //  1994: bipush          67
            //  1996: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.RABBIT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  1999: aastore        
            //  2000: dup            
            //  2001: bipush          68
            //  2003: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.POLAR_BEAR:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  2006: aastore        
            //  2007: dup            
            //  2008: bipush          69
            //  2010: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.VILLAGER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  2013: aastore        
            //  2014: dup            
            //  2015: bipush          70
            //  2017: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENDER_CRYSTAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  2020: aastore        
            //  2021: dup            
            //  2022: bipush          71
            //  2024: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SPLASH_POTION:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  2027: aastore        
            //  2028: dup            
            //  2029: bipush          72
            //  2031: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.LINGERING_POTION:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  2034: aastore        
            //  2035: dup            
            //  2036: bipush          73
            //  2038: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.AREA_EFFECT_CLOUD:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  2041: aastore        
            //  2042: dup            
            //  2043: bipush          74
            //  2045: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.EGG:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  2048: aastore        
            //  2049: dup            
            //  2050: bipush          75
            //  2052: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.FISHING_HOOK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  2055: aastore        
            //  2056: dup            
            //  2057: bipush          76
            //  2059: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.LIGHTNING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  2062: aastore        
            //  2063: dup            
            //  2064: bipush          77
            //  2066: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.WEATHER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  2069: aastore        
            //  2070: dup            
            //  2071: bipush          78
            //  2073: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.PLAYER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  2076: aastore        
            //  2077: dup            
            //  2078: bipush          79
            //  2080: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.COMPLEX_PART:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  2083: aastore        
            //  2084: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.$VALUES:[Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  2087: new             Ljava/util/HashMap;
            //  2090: dup            
            //  2091: invokespecial   java/util/HashMap.<init>:()V
            //  2094: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.TYPES:Ljava/util/Map;
            //  2097: invokestatic    com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.values:()[Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
            //  2100: astore_0        /* llllllllllllllIIllIIIlllIlIIllIl */
            //  2101: aload_0         /* llllllllllllllIIllIIIlllIlIIllIl */
            //  2102: arraylength    
            //  2103: istore_1        /* llllllllllllllIIllIIIlllIlIIllII */
            //  2104: iconst_0       
            //  2105: istore_2        /* llllllllllllllIIllIIIlllIlIIlIll */
            //  2106: iload_2         /* llllllllllllllIIllIIIlllIlIIlIll */
            //  2107: iload_1         /* llllllllllllllIIllIIIlllIlIIllII */
            //  2108: if_icmpge       2138
            //  2111: aload_0         /* llllllllllllllIIllIIIlllIlIIllIl */
            //  2112: iload_2         /* llllllllllllllIIllIIIlllIlIIlIll */
            //  2113: aaload         
            //  2114: astore_3        /* llllllllllllllIIllIIIlllIlIIlIlI */
            //  2115: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.TYPES:Ljava/util/Map;
            //  2118: aload_3         /* llllllllllllllIIllIIIlllIlIIlllI */
            //  2119: getfield        com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.id:I
            //  2122: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
            //  2125: aload_3         /* llllllllllllllIIllIIIlllIlIIlllI */
            //  2126: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
            //  2131: pop            
            //  2132: iinc            llllllllllllllIIllIIIlllIlIIlIll, 1
            //  2135: goto            2106
            //  2138: return         
            //    StackMapTable: 00 02 FE 08 3A 07 01 7F 01 01 1F
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
        
        private EntityType(final int llllllllllllllIIllIIIlllIllIIIII, final EntityType llllllllllllllIIllIIIlllIlIlllll) {
            this.id = llllllllllllllIIllIIIlllIllIIIII;
            this.parent = llllllllllllllIIllIIIlllIlIlllll;
        }
        
        @Override
        public EntityType getParent() {
            return this.parent;
        }
        
        private EntityType(final int llllllllllllllIIllIIIlllIllIllII) {
            this.id = llllllllllllllIIllIIIlllIllIllII;
            this.parent = null;
        }
        
        @Override
        public int getId() {
            return this.id;
        }
        
        public static Optional<EntityType> findById(final int llllllllllllllIIllIIIlllIlIlllII) {
            if (llllllllllllllIIllIIIlllIlIlllII == -1) {
                return Optional.empty();
            }
            return Optional.ofNullable(EntityType.TYPES.get(llllllllllllllIIllIIIlllIlIlllII));
        }
    }
}
