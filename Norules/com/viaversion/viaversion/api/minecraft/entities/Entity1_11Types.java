package com.viaversion.viaversion.api.minecraft.entities;

import com.viaversion.viaversion.api.*;
import java.util.*;

public class Entity1_11Types
{
    public static EntityType getTypeFromId(final int lllllllllllllIlllIlllllIIllIlIlI, final boolean lllllllllllllIlllIlllllIIllIlIIl) {
        Optional<EntityType> lllllllllllllIlllIlllllIIllIlIll = null;
        if (lllllllllllllIlllIlllllIIllIlIIl) {
            final Optional<EntityType> lllllllllllllIlllIlllllIIllIlllI = ObjectType.getPCEntity(lllllllllllllIlllIlllllIIllIlIlI);
        }
        else {
            lllllllllllllIlllIlllllIIllIlIll = EntityType.findById(lllllllllllllIlllIlllllIIllIlIlI);
        }
        if (!lllllllllllllIlllIlllllIIllIlIll.isPresent()) {
            Via.getPlatform().getLogger().severe(String.valueOf(new StringBuilder().append("Could not find 1.11 type id ").append(lllllllllllllIlllIlllllIIllIlIlI).append(" isObject=").append(lllllllllllllIlllIlllllIIllIlIIl)));
            return EntityType.ENTITY;
        }
        return lllllllllllllIlllIlllllIIllIlIll.get();
    }
    
    public enum ObjectType implements com.viaversion.viaversion.api.minecraft.entities.ObjectType
    {
        private final /* synthetic */ EntityType type;
        
        FIREWORK(76, EntityType.FIREWORK), 
        FISHIHNG_HOOK(90, EntityType.FISHING_HOOK), 
        THROWN_EXP_BOTTLE(75, EntityType.THROWN_EXP_BOTTLE), 
        ENDER_SIGNAL(72, EntityType.ENDER_SIGNAL), 
        SMALL_FIREBALL(64, EntityType.SMALL_FIREBALL), 
        ENDER_PEARL(65, EntityType.ENDER_PEARL), 
        LEASH(77, EntityType.LEASH_HITCH), 
        FALLING_BLOCK(70, EntityType.FALLING_BLOCK), 
        DRAGON_FIREBALL(93, EntityType.DRAGON_FIREBALL), 
        BOAT(1, EntityType.BOAT), 
        ITEM(2, EntityType.DROPPED_ITEM), 
        SNOWBALL(61, EntityType.SNOWBALL), 
        POTION(73, EntityType.SPLASH_POTION), 
        EVOCATION_FANGS(79, EntityType.EVOCATION_FANGS), 
        ARMOR_STAND(78, EntityType.ARMOR_STAND), 
        SHULKER_BULLET(67, EntityType.SHULKER_BULLET);
        
        private final /* synthetic */ int id;
        
        AREA_EFFECT_CLOUD(3, EntityType.AREA_EFFECT_CLOUD), 
        ENDER_CRYSTAL(51, EntityType.ENDER_CRYSTAL), 
        TNT_PRIMED(50, EntityType.PRIMED_TNT), 
        SPECTRAL_ARROW(91, EntityType.SPECTRAL_ARROW), 
        LIAMA_SPIT(68, EntityType.LIAMA_SPIT), 
        TIPPED_ARROW(60, EntityType.ARROW), 
        MINECART(10, EntityType.MINECART_RIDEABLE), 
        WITHER_SKULL(66, EntityType.WITHER_SKULL), 
        FIREBALL(63, EntityType.FIREBALL), 
        EGG(62, EntityType.EGG);
        
        private static final /* synthetic */ Map<Integer, ObjectType> TYPES;
        
        ITEM_FRAME(71, EntityType.ITEM_FRAME);
        
        public static Optional<EntityType> getPCEntity(final int llllllllllllllllIlllllIIIIlllIII) {
            final Optional<ObjectType> llllllllllllllllIlllllIIIIlllIIl = findById(llllllllllllllllIlllllIIIIlllIII);
            if (!llllllllllllllllIlllllIIIIlllIIl.isPresent()) {
                return Optional.empty();
            }
            return Optional.of(llllllllllllllllIlllllIIIIlllIIl.get().type);
        }
        
        @Override
        public int getId() {
            return this.id;
        }
        
        @Override
        public EntityType getType() {
            return this.type;
        }
        
        public static Optional<ObjectType> findById(final int llllllllllllllllIlllllIIIIllllIl) {
            if (llllllllllllllllIlllllIIIIllllIl == -1) {
                return Optional.empty();
            }
            return Optional.ofNullable(ObjectType.TYPES.get(llllllllllllllllIlllllIIIIllllIl));
        }
        
        static {
            TYPES = new HashMap<Integer, ObjectType>();
            final long llllllllllllllllIlllllIIIIlIlllI = (Object)values();
            final byte llllllllllllllllIlllllIIIIlIllIl = (byte)llllllllllllllllIlllllIIIIlIlllI.length;
            for (final ObjectType llllllllllllllllIlllllIIIIlIllll : llllllllllllllllIlllllIIIIlIlllI) {
                ObjectType.TYPES.put(llllllllllllllllIlllllIIIIlIllll.id, llllllllllllllllIlllllIIIIlIllll);
            }
        }
        
        private ObjectType(final int llllllllllllllllIlllllIIIlIIIlll, final EntityType llllllllllllllllIlllllIIIlIIIllI) {
            this.id = llllllllllllllllIlllllIIIlIIIlll;
            this.type = llllllllllllllllIlllllIIIlIIIllI;
        }
    }
    
    public enum EntityType implements com.viaversion.viaversion.api.minecraft.entities.EntityType
    {
        public static final /* synthetic */ EntityType ENDER_CRYSTAL;
        public static final /* synthetic */ EntityType ENDER_SIGNAL;
        private final /* synthetic */ int id;
        public static final /* synthetic */ EntityType EVOCATION_FANGS;
        public static final /* synthetic */ EntityType ENDER_PEARL;
        private final /* synthetic */ EntityType parent;
        public static final /* synthetic */ EntityType SHULKER_BULLET;
        public static final /* synthetic */ EntityType DROPPED_ITEM;
        public static final /* synthetic */ EntityType EGG;
        public static final /* synthetic */ EntityType ITEM_FRAME;
        public static final /* synthetic */ EntityType FALLING_BLOCK;
        public static final /* synthetic */ EntityType ARROW;
        public static final /* synthetic */ EntityType BOAT;
        public static final /* synthetic */ EntityType ENTITY;
        public static final /* synthetic */ EntityType FIREBALL;
        public static final /* synthetic */ EntityType MINECART_RIDEABLE;
        public static final /* synthetic */ EntityType THROWN_EXP_BOTTLE;
        public static final /* synthetic */ EntityType AREA_EFFECT_CLOUD;
        public static final /* synthetic */ EntityType SPLASH_POTION;
        public static final /* synthetic */ EntityType LIAMA_SPIT;
        public static final /* synthetic */ EntityType DRAGON_FIREBALL;
        private static final /* synthetic */ Map<Integer, EntityType> TYPES;
        public static final /* synthetic */ EntityType LEASH_HITCH;
        public static final /* synthetic */ EntityType SMALL_FIREBALL;
        public static final /* synthetic */ EntityType SNOWBALL;
        public static final /* synthetic */ EntityType WITHER_SKULL;
        public static final /* synthetic */ EntityType FIREWORK;
        public static final /* synthetic */ EntityType SPECTRAL_ARROW;
        public static final /* synthetic */ EntityType FISHING_HOOK;
        public static final /* synthetic */ EntityType ARMOR_STAND;
        public static final /* synthetic */ EntityType PRIMED_TNT;
        
        private EntityType(final int lllllllllllllIlIlIIlIlllIIIIIIIl) {
            this.id = lllllllllllllIlIlIIlIlllIIIIIIIl;
            this.parent = null;
        }
        
        private EntityType(final int lllllllllllllIlIlIIlIllIlllllIlI, final EntityType lllllllllllllIlIlIIlIllIllllIlII) {
            this.id = lllllllllllllIlIlIIlIllIlllllIlI;
            this.parent = lllllllllllllIlIlIIlIllIllllIlII;
        }
        
        @Override
        public EntityType getParent() {
            return this.parent;
        }
        
        public static Optional<EntityType> findById(final int lllllllllllllIlIlIIlIllIlllIlIll) {
            if (lllllllllllllIlIlIIlIllIlllIlIll == -1) {
                return Optional.empty();
            }
            return Optional.ofNullable(EntityType.TYPES.get(lllllllllllllIlIlIIlIllIlllIlIll));
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
            //     8: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;II)V
            //    11: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //    14: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //    17: dup            
            //    18: ldc             "DROPPED_ITEM"
            //    20: iconst_1       
            //    21: iconst_1       
            //    22: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //    25: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //    28: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.DROPPED_ITEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //    31: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //    34: dup            
            //    35: ldc             "EXPERIENCE_ORB"
            //    37: iconst_2       
            //    38: iconst_2       
            //    39: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //    42: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //    45: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.EXPERIENCE_ORB:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //    48: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //    51: dup            
            //    52: ldc             "LEASH_HITCH"
            //    54: iconst_3       
            //    55: bipush          8
            //    57: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //    60: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //    63: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.LEASH_HITCH:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //    66: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //    69: dup            
            //    70: ldc             "PAINTING"
            //    72: iconst_4       
            //    73: bipush          9
            //    75: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //    78: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //    81: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.PAINTING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //    84: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //    87: dup            
            //    88: ldc             "ARROW"
            //    90: iconst_5       
            //    91: bipush          10
            //    93: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //    96: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //    99: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   102: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   105: dup            
            //   106: ldc             "SNOWBALL"
            //   108: bipush          6
            //   110: bipush          11
            //   112: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   115: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   118: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SNOWBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   121: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   124: dup            
            //   125: ldc             "FIREBALL"
            //   127: bipush          7
            //   129: bipush          12
            //   131: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   134: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   137: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   140: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   143: dup            
            //   144: ldc             "SMALL_FIREBALL"
            //   146: bipush          8
            //   148: bipush          13
            //   150: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   153: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   156: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SMALL_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   159: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   162: dup            
            //   163: ldc             "ENDER_PEARL"
            //   165: bipush          9
            //   167: bipush          14
            //   169: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   172: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   175: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENDER_PEARL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   178: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   181: dup            
            //   182: ldc             "ENDER_SIGNAL"
            //   184: bipush          10
            //   186: bipush          15
            //   188: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   191: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   194: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENDER_SIGNAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   197: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   200: dup            
            //   201: ldc             "THROWN_EXP_BOTTLE"
            //   203: bipush          11
            //   205: bipush          17
            //   207: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   210: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   213: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.THROWN_EXP_BOTTLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   216: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   219: dup            
            //   220: ldc             "ITEM_FRAME"
            //   222: bipush          12
            //   224: bipush          18
            //   226: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   229: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   232: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ITEM_FRAME:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   235: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   238: dup            
            //   239: ldc             "WITHER_SKULL"
            //   241: bipush          13
            //   243: bipush          19
            //   245: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   248: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   251: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.WITHER_SKULL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   254: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   257: dup            
            //   258: ldc             "PRIMED_TNT"
            //   260: bipush          14
            //   262: bipush          20
            //   264: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   267: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   270: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.PRIMED_TNT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   273: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   276: dup            
            //   277: ldc             "FALLING_BLOCK"
            //   279: bipush          15
            //   281: bipush          21
            //   283: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   286: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   289: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.FALLING_BLOCK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   292: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   295: dup            
            //   296: ldc_w           "FIREWORK"
            //   299: bipush          16
            //   301: bipush          22
            //   303: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   306: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   309: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.FIREWORK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   312: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   315: dup            
            //   316: ldc_w           "SPECTRAL_ARROW"
            //   319: bipush          17
            //   321: bipush          24
            //   323: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   326: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   329: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SPECTRAL_ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   332: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   335: dup            
            //   336: ldc_w           "SHULKER_BULLET"
            //   339: bipush          18
            //   341: bipush          25
            //   343: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   346: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   349: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SHULKER_BULLET:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   352: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   355: dup            
            //   356: ldc_w           "DRAGON_FIREBALL"
            //   359: bipush          19
            //   361: bipush          26
            //   363: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   366: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   369: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.DRAGON_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   372: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   375: dup            
            //   376: ldc_w           "EVOCATION_FANGS"
            //   379: bipush          20
            //   381: bipush          33
            //   383: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   386: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   389: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.EVOCATION_FANGS:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   392: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   395: dup            
            //   396: ldc_w           "ENTITY_LIVING"
            //   399: bipush          21
            //   401: iconst_m1      
            //   402: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   405: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   408: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_LIVING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   411: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   414: dup            
            //   415: ldc_w           "ENTITY_INSENTIENT"
            //   418: bipush          22
            //   420: iconst_m1      
            //   421: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_LIVING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   424: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   427: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   430: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   433: dup            
            //   434: ldc_w           "ENTITY_AGEABLE"
            //   437: bipush          23
            //   439: iconst_m1      
            //   440: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   443: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   446: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   449: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   452: dup            
            //   453: ldc_w           "ENTITY_TAMEABLE_ANIMAL"
            //   456: bipush          24
            //   458: iconst_m1      
            //   459: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   462: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   465: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_TAMEABLE_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   468: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   471: dup            
            //   472: ldc_w           "ENTITY_HUMAN"
            //   475: bipush          25
            //   477: iconst_m1      
            //   478: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_LIVING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   481: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   484: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_HUMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   487: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   490: dup            
            //   491: ldc_w           "ARMOR_STAND"
            //   494: bipush          26
            //   496: bipush          30
            //   498: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_LIVING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   501: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   504: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ARMOR_STAND:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   507: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   510: dup            
            //   511: ldc_w           "EVOCATION_ILLAGER"
            //   514: bipush          27
            //   516: bipush          34
            //   518: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   521: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   524: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.EVOCATION_ILLAGER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   527: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   530: dup            
            //   531: ldc_w           "VEX"
            //   534: bipush          28
            //   536: bipush          35
            //   538: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   541: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   544: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.VEX:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   547: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   550: dup            
            //   551: ldc_w           "VINDICATION_ILLAGER"
            //   554: bipush          29
            //   556: bipush          36
            //   558: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   561: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   564: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.VINDICATION_ILLAGER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   567: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   570: dup            
            //   571: ldc_w           "MINECART_ABSTRACT"
            //   574: bipush          30
            //   576: iconst_m1      
            //   577: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   580: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   583: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   586: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   589: dup            
            //   590: ldc_w           "MINECART_COMMAND"
            //   593: bipush          31
            //   595: bipush          40
            //   597: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   600: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   603: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MINECART_COMMAND:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   606: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   609: dup            
            //   610: ldc_w           "BOAT"
            //   613: bipush          32
            //   615: bipush          41
            //   617: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   620: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   623: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.BOAT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   626: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   629: dup            
            //   630: ldc_w           "MINECART_RIDEABLE"
            //   633: bipush          33
            //   635: bipush          42
            //   637: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   640: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   643: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MINECART_RIDEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   646: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   649: dup            
            //   650: ldc_w           "MINECART_CHEST"
            //   653: bipush          34
            //   655: bipush          43
            //   657: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   660: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   663: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MINECART_CHEST:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   666: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   669: dup            
            //   670: ldc_w           "MINECART_FURNACE"
            //   673: bipush          35
            //   675: bipush          44
            //   677: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   680: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   683: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MINECART_FURNACE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   686: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   689: dup            
            //   690: ldc_w           "MINECART_TNT"
            //   693: bipush          36
            //   695: bipush          45
            //   697: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   700: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   703: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MINECART_TNT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   706: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   709: dup            
            //   710: ldc_w           "MINECART_HOPPER"
            //   713: bipush          37
            //   715: bipush          46
            //   717: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   720: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   723: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MINECART_HOPPER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   726: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   729: dup            
            //   730: ldc_w           "MINECART_MOB_SPAWNER"
            //   733: bipush          38
            //   735: bipush          47
            //   737: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   740: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   743: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MINECART_MOB_SPAWNER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   746: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   749: dup            
            //   750: ldc_w           "CREEPER"
            //   753: bipush          39
            //   755: bipush          50
            //   757: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   760: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   763: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.CREEPER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   766: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   769: dup            
            //   770: ldc_w           "ABSTRACT_SKELETON"
            //   773: bipush          40
            //   775: iconst_m1      
            //   776: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   779: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   782: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ABSTRACT_SKELETON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   785: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   788: dup            
            //   789: ldc_w           "SKELETON"
            //   792: bipush          41
            //   794: bipush          51
            //   796: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ABSTRACT_SKELETON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   799: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   802: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SKELETON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   805: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   808: dup            
            //   809: ldc_w           "WITHER_SKELETON"
            //   812: bipush          42
            //   814: iconst_5       
            //   815: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ABSTRACT_SKELETON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   818: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   821: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.WITHER_SKELETON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   824: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   827: dup            
            //   828: ldc_w           "STRAY"
            //   831: bipush          43
            //   833: bipush          6
            //   835: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ABSTRACT_SKELETON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   838: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   841: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.STRAY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   844: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   847: dup            
            //   848: ldc_w           "SPIDER"
            //   851: bipush          44
            //   853: bipush          52
            //   855: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   858: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   861: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SPIDER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   864: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   867: dup            
            //   868: ldc_w           "GIANT"
            //   871: bipush          45
            //   873: bipush          53
            //   875: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   878: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   881: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.GIANT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   884: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   887: dup            
            //   888: ldc_w           "ZOMBIE"
            //   891: bipush          46
            //   893: bipush          54
            //   895: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   898: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   901: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ZOMBIE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   904: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   907: dup            
            //   908: ldc_w           "HUSK"
            //   911: bipush          47
            //   913: bipush          23
            //   915: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ZOMBIE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   918: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   921: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.HUSK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   924: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   927: dup            
            //   928: ldc_w           "ZOMBIE_VILLAGER"
            //   931: bipush          48
            //   933: bipush          27
            //   935: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ZOMBIE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   938: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   941: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ZOMBIE_VILLAGER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   944: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   947: dup            
            //   948: ldc_w           "SLIME"
            //   951: bipush          49
            //   953: bipush          55
            //   955: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   958: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   961: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SLIME:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   964: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   967: dup            
            //   968: ldc_w           "GHAST"
            //   971: bipush          50
            //   973: bipush          56
            //   975: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   978: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //   981: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.GHAST:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   984: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   987: dup            
            //   988: ldc_w           "PIG_ZOMBIE"
            //   991: bipush          51
            //   993: bipush          57
            //   995: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ZOMBIE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //   998: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1001: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.PIG_ZOMBIE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1004: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1007: dup            
            //  1008: ldc_w           "ENDERMAN"
            //  1011: bipush          52
            //  1013: bipush          58
            //  1015: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1018: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1021: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENDERMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1024: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1027: dup            
            //  1028: ldc_w           "CAVE_SPIDER"
            //  1031: bipush          53
            //  1033: bipush          59
            //  1035: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SPIDER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1038: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1041: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.CAVE_SPIDER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1044: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1047: dup            
            //  1048: ldc_w           "SILVERFISH"
            //  1051: bipush          54
            //  1053: bipush          60
            //  1055: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1058: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1061: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SILVERFISH:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1064: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1067: dup            
            //  1068: ldc_w           "BLAZE"
            //  1071: bipush          55
            //  1073: bipush          61
            //  1075: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1078: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1081: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.BLAZE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1084: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1087: dup            
            //  1088: ldc_w           "MAGMA_CUBE"
            //  1091: bipush          56
            //  1093: bipush          62
            //  1095: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SLIME:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1098: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1101: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MAGMA_CUBE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1104: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1107: dup            
            //  1108: ldc_w           "ENDER_DRAGON"
            //  1111: bipush          57
            //  1113: bipush          63
            //  1115: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1118: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1121: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENDER_DRAGON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1124: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1127: dup            
            //  1128: ldc_w           "WITHER"
            //  1131: bipush          58
            //  1133: bipush          64
            //  1135: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1138: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1141: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.WITHER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1144: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1147: dup            
            //  1148: ldc_w           "BAT"
            //  1151: bipush          59
            //  1153: bipush          65
            //  1155: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1158: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1161: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.BAT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1164: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1167: dup            
            //  1168: ldc_w           "WITCH"
            //  1171: bipush          60
            //  1173: bipush          66
            //  1175: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1178: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1181: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.WITCH:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1184: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1187: dup            
            //  1188: ldc_w           "ENDERMITE"
            //  1191: bipush          61
            //  1193: bipush          67
            //  1195: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1198: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1201: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENDERMITE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1204: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1207: dup            
            //  1208: ldc_w           "GUARDIAN"
            //  1211: bipush          62
            //  1213: bipush          68
            //  1215: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1218: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1221: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.GUARDIAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1224: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1227: dup            
            //  1228: ldc_w           "ELDER_GUARDIAN"
            //  1231: bipush          63
            //  1233: iconst_4       
            //  1234: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.GUARDIAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1237: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1240: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ELDER_GUARDIAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1243: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1246: dup            
            //  1247: ldc_w           "IRON_GOLEM"
            //  1250: bipush          64
            //  1252: bipush          99
            //  1254: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1257: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1260: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.IRON_GOLEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1263: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1266: dup            
            //  1267: ldc_w           "SHULKER"
            //  1270: bipush          65
            //  1272: bipush          69
            //  1274: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.IRON_GOLEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1277: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1280: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SHULKER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1283: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1286: dup            
            //  1287: ldc_w           "PIG"
            //  1290: bipush          66
            //  1292: bipush          90
            //  1294: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1297: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1300: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.PIG:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1303: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1306: dup            
            //  1307: ldc_w           "SHEEP"
            //  1310: bipush          67
            //  1312: bipush          91
            //  1314: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1317: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1320: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SHEEP:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1323: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1326: dup            
            //  1327: ldc_w           "COW"
            //  1330: bipush          68
            //  1332: bipush          92
            //  1334: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1337: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1340: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.COW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1343: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1346: dup            
            //  1347: ldc_w           "CHICKEN"
            //  1350: bipush          69
            //  1352: bipush          93
            //  1354: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1357: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1360: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.CHICKEN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1363: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1366: dup            
            //  1367: ldc_w           "SQUID"
            //  1370: bipush          70
            //  1372: bipush          94
            //  1374: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1377: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1380: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SQUID:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1383: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1386: dup            
            //  1387: ldc_w           "WOLF"
            //  1390: bipush          71
            //  1392: bipush          95
            //  1394: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_TAMEABLE_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1397: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1400: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.WOLF:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1403: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1406: dup            
            //  1407: ldc_w           "MUSHROOM_COW"
            //  1410: bipush          72
            //  1412: bipush          96
            //  1414: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.COW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1417: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1420: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MUSHROOM_COW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1423: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1426: dup            
            //  1427: ldc_w           "SNOWMAN"
            //  1430: bipush          73
            //  1432: bipush          97
            //  1434: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.IRON_GOLEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1437: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1440: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SNOWMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1443: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1446: dup            
            //  1447: ldc_w           "OCELOT"
            //  1450: bipush          74
            //  1452: bipush          98
            //  1454: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_TAMEABLE_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1457: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1460: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.OCELOT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1463: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1466: dup            
            //  1467: ldc_w           "ABSTRACT_HORSE"
            //  1470: bipush          75
            //  1472: iconst_m1      
            //  1473: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1476: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1479: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ABSTRACT_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1482: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1485: dup            
            //  1486: ldc_w           "HORSE"
            //  1489: bipush          76
            //  1491: bipush          100
            //  1493: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ABSTRACT_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1496: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1499: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1502: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1505: dup            
            //  1506: ldc_w           "SKELETON_HORSE"
            //  1509: bipush          77
            //  1511: bipush          28
            //  1513: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ABSTRACT_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1516: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1519: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SKELETON_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1522: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1525: dup            
            //  1526: ldc_w           "ZOMBIE_HORSE"
            //  1529: bipush          78
            //  1531: bipush          29
            //  1533: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ABSTRACT_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1536: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1539: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ZOMBIE_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1542: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1545: dup            
            //  1546: ldc_w           "CHESTED_HORSE"
            //  1549: bipush          79
            //  1551: iconst_m1      
            //  1552: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ABSTRACT_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1555: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1558: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.CHESTED_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1561: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1564: dup            
            //  1565: ldc_w           "DONKEY"
            //  1568: bipush          80
            //  1570: bipush          31
            //  1572: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.CHESTED_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1575: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1578: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.DONKEY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1581: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1584: dup            
            //  1585: ldc_w           "MULE"
            //  1588: bipush          81
            //  1590: bipush          32
            //  1592: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.CHESTED_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1595: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1598: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MULE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1601: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1604: dup            
            //  1605: ldc_w           "LIAMA"
            //  1608: bipush          82
            //  1610: bipush          103
            //  1612: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.CHESTED_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1615: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1618: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.LIAMA:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1621: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1624: dup            
            //  1625: ldc_w           "RABBIT"
            //  1628: bipush          83
            //  1630: bipush          101
            //  1632: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1635: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1638: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.RABBIT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1641: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1644: dup            
            //  1645: ldc_w           "POLAR_BEAR"
            //  1648: bipush          84
            //  1650: bipush          102
            //  1652: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1655: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1658: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.POLAR_BEAR:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1661: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1664: dup            
            //  1665: ldc_w           "VILLAGER"
            //  1668: bipush          85
            //  1670: bipush          120
            //  1672: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1675: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1678: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.VILLAGER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1681: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1684: dup            
            //  1685: ldc_w           "ENDER_CRYSTAL"
            //  1688: bipush          86
            //  1690: sipush          200
            //  1693: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1696: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1699: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENDER_CRYSTAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1702: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1705: dup            
            //  1706: ldc_w           "SPLASH_POTION"
            //  1709: bipush          87
            //  1711: iconst_m1      
            //  1712: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1715: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1718: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SPLASH_POTION:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1721: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1724: dup            
            //  1725: ldc_w           "LINGERING_POTION"
            //  1728: bipush          88
            //  1730: iconst_m1      
            //  1731: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SPLASH_POTION:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1734: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1737: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.LINGERING_POTION:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1740: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1743: dup            
            //  1744: ldc_w           "AREA_EFFECT_CLOUD"
            //  1747: bipush          89
            //  1749: iconst_m1      
            //  1750: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1753: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1756: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.AREA_EFFECT_CLOUD:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1759: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1762: dup            
            //  1763: ldc_w           "EGG"
            //  1766: bipush          90
            //  1768: iconst_m1      
            //  1769: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1772: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1775: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.EGG:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1778: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1781: dup            
            //  1782: ldc_w           "FISHING_HOOK"
            //  1785: bipush          91
            //  1787: iconst_m1      
            //  1788: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1791: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1794: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.FISHING_HOOK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1797: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1800: dup            
            //  1801: ldc_w           "LIGHTNING"
            //  1804: bipush          92
            //  1806: iconst_m1      
            //  1807: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1810: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1813: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.LIGHTNING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1816: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1819: dup            
            //  1820: ldc_w           "WEATHER"
            //  1823: bipush          93
            //  1825: iconst_m1      
            //  1826: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1829: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1832: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.WEATHER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1835: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1838: dup            
            //  1839: ldc_w           "PLAYER"
            //  1842: bipush          94
            //  1844: iconst_m1      
            //  1845: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_HUMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1848: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1851: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.PLAYER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1854: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1857: dup            
            //  1858: ldc_w           "COMPLEX_PART"
            //  1861: bipush          95
            //  1863: iconst_m1      
            //  1864: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1867: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1870: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.COMPLEX_PART:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1873: new             Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1876: dup            
            //  1877: ldc_w           "LIAMA_SPIT"
            //  1880: bipush          96
            //  1882: iconst_m1      
            //  1883: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1886: invokespecial   com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.<init>:(Ljava/lang/String;IILcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;)V
            //  1889: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.LIAMA_SPIT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1892: bipush          97
            //  1894: anewarray       Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1897: dup            
            //  1898: iconst_0       
            //  1899: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1902: aastore        
            //  1903: dup            
            //  1904: iconst_1       
            //  1905: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.DROPPED_ITEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1908: aastore        
            //  1909: dup            
            //  1910: iconst_2       
            //  1911: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.EXPERIENCE_ORB:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1914: aastore        
            //  1915: dup            
            //  1916: iconst_3       
            //  1917: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.LEASH_HITCH:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1920: aastore        
            //  1921: dup            
            //  1922: iconst_4       
            //  1923: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.PAINTING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1926: aastore        
            //  1927: dup            
            //  1928: iconst_5       
            //  1929: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1932: aastore        
            //  1933: dup            
            //  1934: bipush          6
            //  1936: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SNOWBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1939: aastore        
            //  1940: dup            
            //  1941: bipush          7
            //  1943: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1946: aastore        
            //  1947: dup            
            //  1948: bipush          8
            //  1950: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SMALL_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1953: aastore        
            //  1954: dup            
            //  1955: bipush          9
            //  1957: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENDER_PEARL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1960: aastore        
            //  1961: dup            
            //  1962: bipush          10
            //  1964: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENDER_SIGNAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1967: aastore        
            //  1968: dup            
            //  1969: bipush          11
            //  1971: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.THROWN_EXP_BOTTLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1974: aastore        
            //  1975: dup            
            //  1976: bipush          12
            //  1978: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ITEM_FRAME:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1981: aastore        
            //  1982: dup            
            //  1983: bipush          13
            //  1985: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.WITHER_SKULL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1988: aastore        
            //  1989: dup            
            //  1990: bipush          14
            //  1992: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.PRIMED_TNT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  1995: aastore        
            //  1996: dup            
            //  1997: bipush          15
            //  1999: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.FALLING_BLOCK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2002: aastore        
            //  2003: dup            
            //  2004: bipush          16
            //  2006: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.FIREWORK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2009: aastore        
            //  2010: dup            
            //  2011: bipush          17
            //  2013: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SPECTRAL_ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2016: aastore        
            //  2017: dup            
            //  2018: bipush          18
            //  2020: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SHULKER_BULLET:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2023: aastore        
            //  2024: dup            
            //  2025: bipush          19
            //  2027: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.DRAGON_FIREBALL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2030: aastore        
            //  2031: dup            
            //  2032: bipush          20
            //  2034: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.EVOCATION_FANGS:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2037: aastore        
            //  2038: dup            
            //  2039: bipush          21
            //  2041: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_LIVING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2044: aastore        
            //  2045: dup            
            //  2046: bipush          22
            //  2048: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_INSENTIENT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2051: aastore        
            //  2052: dup            
            //  2053: bipush          23
            //  2055: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2058: aastore        
            //  2059: dup            
            //  2060: bipush          24
            //  2062: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_TAMEABLE_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2065: aastore        
            //  2066: dup            
            //  2067: bipush          25
            //  2069: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENTITY_HUMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2072: aastore        
            //  2073: dup            
            //  2074: bipush          26
            //  2076: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ARMOR_STAND:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2079: aastore        
            //  2080: dup            
            //  2081: bipush          27
            //  2083: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.EVOCATION_ILLAGER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2086: aastore        
            //  2087: dup            
            //  2088: bipush          28
            //  2090: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.VEX:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2093: aastore        
            //  2094: dup            
            //  2095: bipush          29
            //  2097: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.VINDICATION_ILLAGER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2100: aastore        
            //  2101: dup            
            //  2102: bipush          30
            //  2104: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2107: aastore        
            //  2108: dup            
            //  2109: bipush          31
            //  2111: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MINECART_COMMAND:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2114: aastore        
            //  2115: dup            
            //  2116: bipush          32
            //  2118: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.BOAT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2121: aastore        
            //  2122: dup            
            //  2123: bipush          33
            //  2125: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MINECART_RIDEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2128: aastore        
            //  2129: dup            
            //  2130: bipush          34
            //  2132: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MINECART_CHEST:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2135: aastore        
            //  2136: dup            
            //  2137: bipush          35
            //  2139: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MINECART_FURNACE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2142: aastore        
            //  2143: dup            
            //  2144: bipush          36
            //  2146: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MINECART_TNT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2149: aastore        
            //  2150: dup            
            //  2151: bipush          37
            //  2153: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MINECART_HOPPER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2156: aastore        
            //  2157: dup            
            //  2158: bipush          38
            //  2160: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MINECART_MOB_SPAWNER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2163: aastore        
            //  2164: dup            
            //  2165: bipush          39
            //  2167: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.CREEPER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2170: aastore        
            //  2171: dup            
            //  2172: bipush          40
            //  2174: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ABSTRACT_SKELETON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2177: aastore        
            //  2178: dup            
            //  2179: bipush          41
            //  2181: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SKELETON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2184: aastore        
            //  2185: dup            
            //  2186: bipush          42
            //  2188: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.WITHER_SKELETON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2191: aastore        
            //  2192: dup            
            //  2193: bipush          43
            //  2195: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.STRAY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2198: aastore        
            //  2199: dup            
            //  2200: bipush          44
            //  2202: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SPIDER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2205: aastore        
            //  2206: dup            
            //  2207: bipush          45
            //  2209: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.GIANT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2212: aastore        
            //  2213: dup            
            //  2214: bipush          46
            //  2216: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ZOMBIE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2219: aastore        
            //  2220: dup            
            //  2221: bipush          47
            //  2223: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.HUSK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2226: aastore        
            //  2227: dup            
            //  2228: bipush          48
            //  2230: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ZOMBIE_VILLAGER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2233: aastore        
            //  2234: dup            
            //  2235: bipush          49
            //  2237: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SLIME:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2240: aastore        
            //  2241: dup            
            //  2242: bipush          50
            //  2244: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.GHAST:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2247: aastore        
            //  2248: dup            
            //  2249: bipush          51
            //  2251: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.PIG_ZOMBIE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2254: aastore        
            //  2255: dup            
            //  2256: bipush          52
            //  2258: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENDERMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2261: aastore        
            //  2262: dup            
            //  2263: bipush          53
            //  2265: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.CAVE_SPIDER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2268: aastore        
            //  2269: dup            
            //  2270: bipush          54
            //  2272: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SILVERFISH:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2275: aastore        
            //  2276: dup            
            //  2277: bipush          55
            //  2279: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.BLAZE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2282: aastore        
            //  2283: dup            
            //  2284: bipush          56
            //  2286: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MAGMA_CUBE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2289: aastore        
            //  2290: dup            
            //  2291: bipush          57
            //  2293: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENDER_DRAGON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2296: aastore        
            //  2297: dup            
            //  2298: bipush          58
            //  2300: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.WITHER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2303: aastore        
            //  2304: dup            
            //  2305: bipush          59
            //  2307: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.BAT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2310: aastore        
            //  2311: dup            
            //  2312: bipush          60
            //  2314: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.WITCH:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2317: aastore        
            //  2318: dup            
            //  2319: bipush          61
            //  2321: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENDERMITE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2324: aastore        
            //  2325: dup            
            //  2326: bipush          62
            //  2328: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.GUARDIAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2331: aastore        
            //  2332: dup            
            //  2333: bipush          63
            //  2335: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ELDER_GUARDIAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2338: aastore        
            //  2339: dup            
            //  2340: bipush          64
            //  2342: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.IRON_GOLEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2345: aastore        
            //  2346: dup            
            //  2347: bipush          65
            //  2349: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SHULKER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2352: aastore        
            //  2353: dup            
            //  2354: bipush          66
            //  2356: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.PIG:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2359: aastore        
            //  2360: dup            
            //  2361: bipush          67
            //  2363: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SHEEP:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2366: aastore        
            //  2367: dup            
            //  2368: bipush          68
            //  2370: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.COW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2373: aastore        
            //  2374: dup            
            //  2375: bipush          69
            //  2377: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.CHICKEN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2380: aastore        
            //  2381: dup            
            //  2382: bipush          70
            //  2384: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SQUID:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2387: aastore        
            //  2388: dup            
            //  2389: bipush          71
            //  2391: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.WOLF:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2394: aastore        
            //  2395: dup            
            //  2396: bipush          72
            //  2398: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MUSHROOM_COW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2401: aastore        
            //  2402: dup            
            //  2403: bipush          73
            //  2405: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SNOWMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2408: aastore        
            //  2409: dup            
            //  2410: bipush          74
            //  2412: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.OCELOT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2415: aastore        
            //  2416: dup            
            //  2417: bipush          75
            //  2419: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ABSTRACT_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2422: aastore        
            //  2423: dup            
            //  2424: bipush          76
            //  2426: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2429: aastore        
            //  2430: dup            
            //  2431: bipush          77
            //  2433: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SKELETON_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2436: aastore        
            //  2437: dup            
            //  2438: bipush          78
            //  2440: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ZOMBIE_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2443: aastore        
            //  2444: dup            
            //  2445: bipush          79
            //  2447: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.CHESTED_HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2450: aastore        
            //  2451: dup            
            //  2452: bipush          80
            //  2454: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.DONKEY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2457: aastore        
            //  2458: dup            
            //  2459: bipush          81
            //  2461: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.MULE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2464: aastore        
            //  2465: dup            
            //  2466: bipush          82
            //  2468: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.LIAMA:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2471: aastore        
            //  2472: dup            
            //  2473: bipush          83
            //  2475: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.RABBIT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2478: aastore        
            //  2479: dup            
            //  2480: bipush          84
            //  2482: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.POLAR_BEAR:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2485: aastore        
            //  2486: dup            
            //  2487: bipush          85
            //  2489: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.VILLAGER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2492: aastore        
            //  2493: dup            
            //  2494: bipush          86
            //  2496: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.ENDER_CRYSTAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2499: aastore        
            //  2500: dup            
            //  2501: bipush          87
            //  2503: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.SPLASH_POTION:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2506: aastore        
            //  2507: dup            
            //  2508: bipush          88
            //  2510: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.LINGERING_POTION:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2513: aastore        
            //  2514: dup            
            //  2515: bipush          89
            //  2517: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.AREA_EFFECT_CLOUD:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2520: aastore        
            //  2521: dup            
            //  2522: bipush          90
            //  2524: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.EGG:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2527: aastore        
            //  2528: dup            
            //  2529: bipush          91
            //  2531: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.FISHING_HOOK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2534: aastore        
            //  2535: dup            
            //  2536: bipush          92
            //  2538: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.LIGHTNING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2541: aastore        
            //  2542: dup            
            //  2543: bipush          93
            //  2545: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.WEATHER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2548: aastore        
            //  2549: dup            
            //  2550: bipush          94
            //  2552: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.PLAYER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2555: aastore        
            //  2556: dup            
            //  2557: bipush          95
            //  2559: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.COMPLEX_PART:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2562: aastore        
            //  2563: dup            
            //  2564: bipush          96
            //  2566: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.LIAMA_SPIT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2569: aastore        
            //  2570: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.$VALUES:[Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2573: new             Ljava/util/HashMap;
            //  2576: dup            
            //  2577: invokespecial   java/util/HashMap.<init>:()V
            //  2580: putstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.TYPES:Ljava/util/Map;
            //  2583: invokestatic    com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.values:()[Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType;
            //  2586: astore_0        /* lllllllllllllIlIlIIlIllIlllIIIlI */
            //  2587: aload_0         /* lllllllllllllIlIlIIlIllIlllIIIlI */
            //  2588: arraylength    
            //  2589: istore_1        /* lllllllllllllIlIlIIlIllIlllIIIIl */
            //  2590: iconst_0       
            //  2591: istore_2        /* lllllllllllllIlIlIIlIllIlllIIIII */
            //  2592: iload_2         /* lllllllllllllIlIlIIlIllIlllIIIII */
            //  2593: iload_1         /* lllllllllllllIlIlIIlIllIlllIIIIl */
            //  2594: if_icmpge       2624
            //  2597: aload_0         /* lllllllllllllIlIlIIlIllIlllIIIlI */
            //  2598: iload_2         /* lllllllllllllIlIlIIlIllIlllIIIII */
            //  2599: aaload         
            //  2600: astore_3        /* lllllllllllllIlIlIIlIllIlllIIIll */
            //  2601: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.TYPES:Ljava/util/Map;
            //  2604: aload_3         /* lllllllllllllIlIlIIlIllIlllIIIll */
            //  2605: getfield        com/viaversion/viaversion/api/minecraft/entities/Entity1_11Types$EntityType.id:I
            //  2608: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
            //  2611: aload_3         /* lllllllllllllIlIlIIlIllIlllIIIll */
            //  2612: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
            //  2617: pop            
            //  2618: iinc            lllllllllllllIlIlIIlIllIlllIIIII, 1
            //  2621: goto            2592
            //  2624: return         
            //    StackMapTable: 00 02 FE 0A 20 07 00 81 01 01 1F
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
        
        @Override
        public int getId() {
            return this.id;
        }
    }
}
