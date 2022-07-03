package de.gerrygames.viarewind.protocol.protocol1_8to1_7_6_10.metadata;

import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.util.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types.*;
import java.util.*;

public enum MetaIndex1_8to1_7_6_10
{
    private /* synthetic */ int newIndex;
    private /* synthetic */ MetaType1_8 newType;
    private /* synthetic */ Entity1_10Types.EntityType clazz;
    private /* synthetic */ int index;
    private static final /* synthetic */ HashMap<Pair<Entity1_10Types.EntityType, Integer>, MetaIndex1_8to1_7_6_10> metadataRewrites;
    private /* synthetic */ MetaType1_7_6_10 oldType;
    
    private MetaIndex1_8to1_7_6_10(final Entity1_10Types.EntityType llllllllllllIlllllIIlIllIlIlIlIl, final int llllllllllllIlllllIIlIllIlIIllIl, final MetaType1_7_6_10 llllllllllllIlllllIIlIllIlIIllII, final MetaType1_8 llllllllllllIlllllIIlIllIlIlIIlI) {
        this.clazz = llllllllllllIlllllIIlIllIlIlIlIl;
        this.index = llllllllllllIlllllIIlIllIlIIllIl;
        this.newIndex = llllllllllllIlllllIIlIllIlIIllIl;
        this.oldType = llllllllllllIlllllIIlIllIlIIllII;
        this.newType = llllllllllllIlllllIIlIllIlIlIIlI;
    }
    
    public int getNewIndex() {
        return this.newIndex;
    }
    
    public MetaType1_7_6_10 getOldType() {
        return this.oldType;
    }
    
    static {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: ldc             "ENTITY_FLAGS"
        //     6: iconst_0       
        //     7: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //    10: iconst_0       
        //    11: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //    14: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //    17: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //    20: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_FLAGS:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //    23: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //    26: dup            
        //    27: ldc             "ENTITY_AIR"
        //    29: iconst_1       
        //    30: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //    33: iconst_1       
        //    34: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Short:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //    37: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Short:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //    40: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //    43: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_AIR:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //    46: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //    49: dup            
        //    50: ldc             "ENTITY_NAME_TAG"
        //    52: iconst_2       
        //    53: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //    56: iconst_m1      
        //    57: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.NonExistent:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //    60: iconst_2       
        //    61: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.String:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //    64: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;ILcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //    67: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_NAME_TAG:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //    70: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //    73: dup            
        //    74: ldc             "ENTITY_NAME_TAG_VISIBILITY"
        //    76: iconst_3       
        //    77: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //    80: iconst_m1      
        //    81: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.NonExistent:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //    84: iconst_3       
        //    85: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //    88: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;ILcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //    91: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_NAME_TAG_VISIBILITY:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //    94: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //    97: dup            
        //    98: ldc             "ENTITY_SILENT"
        //   100: iconst_4       
        //   101: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   104: iconst_m1      
        //   105: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.NonExistent:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   108: iconst_4       
        //   109: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   112: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;ILcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   115: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_SILENT:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   118: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   121: dup            
        //   122: ldc             "ENTITY_LIVING_HEALTH"
        //   124: iconst_5       
        //   125: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_LIVING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   128: bipush          6
        //   130: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Float:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   133: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Float:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   136: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   139: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_LIVING_HEALTH:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   142: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   145: dup            
        //   146: ldc             "ENTITY_LIVING_POTION_EFFECT_COLOR"
        //   148: bipush          6
        //   150: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_LIVING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   153: bipush          7
        //   155: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Int:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   158: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Int:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   161: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   164: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_LIVING_POTION_EFFECT_COLOR:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   167: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   170: dup            
        //   171: ldc             "ENTITY_LIVING_IS_POTION_EFFECT_AMBIENT"
        //   173: bipush          7
        //   175: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_LIVING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   178: bipush          8
        //   180: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   183: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   186: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   189: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_LIVING_IS_POTION_EFFECT_AMBIENT:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   192: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   195: dup            
        //   196: ldc             "ENTITY_LIVING_ARROWS"
        //   198: bipush          8
        //   200: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_LIVING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   203: bipush          9
        //   205: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   208: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   211: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   214: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_LIVING_ARROWS:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   217: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   220: dup            
        //   221: ldc             "ENTITY_LIVING_NAME_TAG"
        //   223: bipush          9
        //   225: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_LIVING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   228: bipush          10
        //   230: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.String:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   233: iconst_2       
        //   234: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.String:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   237: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;ILcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   240: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_LIVING_NAME_TAG:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   243: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   246: dup            
        //   247: ldc             "ENTITY_LIVING_NAME_TAG_VISIBILITY"
        //   249: bipush          10
        //   251: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_LIVING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   254: bipush          11
        //   256: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   259: iconst_3       
        //   260: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   263: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;ILcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   266: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_LIVING_NAME_TAG_VISIBILITY:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   269: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   272: dup            
        //   273: ldc             "ENTITY_LIVING_AI"
        //   275: bipush          11
        //   277: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_LIVING:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   280: iconst_m1      
        //   281: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.NonExistent:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   284: bipush          15
        //   286: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   289: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;ILcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   292: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_LIVING_AI:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   295: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   298: dup            
        //   299: ldc             "ENTITY_AGEABLE_AGE"
        //   301: bipush          12
        //   303: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_AGEABLE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   306: bipush          12
        //   308: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Int:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   311: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   314: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   317: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_AGEABLE_AGE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   320: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   323: dup            
        //   324: ldc             "ARMOR_STAND_FLAGS"
        //   326: bipush          13
        //   328: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ARMOR_STAND:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   331: iconst_m1      
        //   332: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.NonExistent:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   335: bipush          10
        //   337: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   340: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;ILcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   343: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ARMOR_STAND_FLAGS:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   346: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   349: dup            
        //   350: ldc             "ARMOR_STAND_HEAD_POSITION"
        //   352: bipush          14
        //   354: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ARMOR_STAND:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   357: iconst_m1      
        //   358: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.NonExistent:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   361: bipush          11
        //   363: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Rotation:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   366: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;ILcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   369: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ARMOR_STAND_HEAD_POSITION:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   372: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   375: dup            
        //   376: ldc             "ARMOR_STAND_BODY_POSITION"
        //   378: bipush          15
        //   380: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ARMOR_STAND:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   383: iconst_m1      
        //   384: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.NonExistent:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   387: bipush          12
        //   389: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Rotation:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   392: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;ILcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   395: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ARMOR_STAND_BODY_POSITION:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   398: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   401: dup            
        //   402: ldc             "ARMOR_STAND_LEFT_ARM_POSITION"
        //   404: bipush          16
        //   406: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ARMOR_STAND:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   409: iconst_m1      
        //   410: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.NonExistent:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   413: bipush          13
        //   415: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Rotation:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   418: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;ILcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   421: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ARMOR_STAND_LEFT_ARM_POSITION:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   424: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   427: dup            
        //   428: ldc             "ARMOR_STAND_RIGHT_ARM_POSITION"
        //   430: bipush          17
        //   432: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ARMOR_STAND:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   435: iconst_m1      
        //   436: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.NonExistent:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   439: bipush          14
        //   441: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Rotation:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   444: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;ILcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   447: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ARMOR_STAND_RIGHT_ARM_POSITION:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   450: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   453: dup            
        //   454: ldc             "ARMOR_STAND_LEFT_LEG_POSITION"
        //   456: bipush          18
        //   458: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ARMOR_STAND:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   461: iconst_m1      
        //   462: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.NonExistent:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   465: bipush          15
        //   467: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Rotation:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   470: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;ILcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   473: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ARMOR_STAND_LEFT_LEG_POSITION:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   476: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   479: dup            
        //   480: ldc             "ARMOR_STAND_RIGHT_LEG_POSITION"
        //   482: bipush          19
        //   484: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ARMOR_STAND:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   487: iconst_m1      
        //   488: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.NonExistent:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   491: bipush          16
        //   493: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Rotation:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   496: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;ILcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   499: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ARMOR_STAND_RIGHT_LEG_POSITION:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   502: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   505: dup            
        //   506: ldc_w           "HUMAN_SKIN_FLAGS"
        //   509: bipush          20
        //   511: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_HUMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   514: bipush          16
        //   516: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   519: bipush          10
        //   521: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   524: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;ILcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   527: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.HUMAN_SKIN_FLAGS:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   530: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   533: dup            
        //   534: ldc_w           "HUMAN_UNUSED"
        //   537: bipush          21
        //   539: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_HUMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   542: iconst_m1      
        //   543: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.NonExistent:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   546: bipush          16
        //   548: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   551: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;ILcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   554: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.HUMAN_UNUSED:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   557: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   560: dup            
        //   561: ldc_w           "HUMAN_ABSORPTION_HEATS"
        //   564: bipush          22
        //   566: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_HUMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   569: bipush          17
        //   571: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Float:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   574: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Float:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   577: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   580: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.HUMAN_ABSORPTION_HEATS:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   583: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   586: dup            
        //   587: ldc_w           "HUMAN_SCORE"
        //   590: bipush          23
        //   592: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_HUMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   595: bipush          18
        //   597: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Int:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   600: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Int:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   603: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   606: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.HUMAN_SCORE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   609: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   612: dup            
        //   613: ldc_w           "HORSE_FLAGS"
        //   616: bipush          24
        //   618: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   621: bipush          16
        //   623: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Int:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   626: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Int:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   629: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   632: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.HORSE_FLAGS:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   635: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   638: dup            
        //   639: ldc_w           "HORSE_TYPE"
        //   642: bipush          25
        //   644: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   647: bipush          19
        //   649: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   652: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   655: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   658: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.HORSE_TYPE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   661: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   664: dup            
        //   665: ldc_w           "HORSE_COLOR"
        //   668: bipush          26
        //   670: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   673: bipush          20
        //   675: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Int:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   678: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Int:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   681: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   684: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.HORSE_COLOR:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   687: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   690: dup            
        //   691: ldc_w           "HORSE_OWNER"
        //   694: bipush          27
        //   696: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   699: bipush          21
        //   701: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.String:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   704: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.String:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   707: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   710: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.HORSE_OWNER:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   713: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   716: dup            
        //   717: ldc_w           "HORSE_ARMOR"
        //   720: bipush          28
        //   722: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.HORSE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   725: bipush          22
        //   727: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Int:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   730: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Int:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   733: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   736: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.HORSE_ARMOR:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   739: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   742: dup            
        //   743: ldc_w           "BAT_HANGING"
        //   746: bipush          29
        //   748: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.BAT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   751: bipush          16
        //   753: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   756: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   759: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   762: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.BAT_HANGING:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   765: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   768: dup            
        //   769: ldc_w           "TAMEABLE_FLAGS"
        //   772: bipush          30
        //   774: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_TAMEABLE_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   777: bipush          16
        //   779: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   782: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   785: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   788: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.TAMEABLE_FLAGS:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   791: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   794: dup            
        //   795: ldc_w           "TAMEABLE_OWNER"
        //   798: bipush          31
        //   800: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENTITY_TAMEABLE_ANIMAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   803: bipush          17
        //   805: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.String:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   808: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.String:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   811: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   814: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.TAMEABLE_OWNER:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   817: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   820: dup            
        //   821: ldc_w           "OCELOT_TYPE"
        //   824: bipush          32
        //   826: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.OCELOT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   829: bipush          18
        //   831: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   834: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   837: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   840: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.OCELOT_TYPE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   843: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   846: dup            
        //   847: ldc_w           "WOLF_FLAGS"
        //   850: bipush          33
        //   852: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.WOLF:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   855: bipush          16
        //   857: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   860: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   863: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   866: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.WOLF_FLAGS:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   869: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   872: dup            
        //   873: ldc_w           "WOLF_HEALTH"
        //   876: bipush          34
        //   878: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.WOLF:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   881: bipush          18
        //   883: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Float:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   886: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Float:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   889: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   892: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.WOLF_HEALTH:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   895: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   898: dup            
        //   899: ldc_w           "WOLF_BEGGING"
        //   902: bipush          35
        //   904: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.WOLF:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   907: bipush          19
        //   909: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   912: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   915: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   918: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.WOLF_BEGGING:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   921: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   924: dup            
        //   925: ldc_w           "WOLF_COLLAR_COLOR"
        //   928: bipush          36
        //   930: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.WOLF:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   933: bipush          20
        //   935: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   938: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   941: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   944: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.WOLF_COLLAR_COLOR:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   947: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   950: dup            
        //   951: ldc_w           "PIG_SADDLE"
        //   954: bipush          37
        //   956: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.PIG:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   959: bipush          16
        //   961: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   964: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   967: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   970: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.PIG_SADDLE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   973: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   976: dup            
        //   977: ldc_w           "SHEEP_COLOR_OR_SHEARED"
        //   980: bipush          38
        //   982: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SHEEP:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //   985: bipush          16
        //   987: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //   990: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //   993: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //   996: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.SHEEP_COLOR_OR_SHEARED:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //   999: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1002: dup            
        //  1003: ldc_w           "VILLAGER_TYPE"
        //  1006: bipush          39
        //  1008: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.VILLAGER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1011: bipush          16
        //  1013: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Int:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1016: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Int:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1019: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1022: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.VILLAGER_TYPE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1025: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1028: dup            
        //  1029: ldc_w           "ENDERMAN_CARRIED_BLOCK"
        //  1032: bipush          40
        //  1034: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENDERMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1037: bipush          16
        //  1039: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.NonExistent:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1042: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Short:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1045: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1048: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENDERMAN_CARRIED_BLOCK:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1051: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1054: dup            
        //  1055: ldc_w           "ENDERMAN_CARRIED_BLOCK_DATA"
        //  1058: bipush          41
        //  1060: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENDERMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1063: bipush          17
        //  1065: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.NonExistent:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1068: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1071: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1074: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENDERMAN_CARRIED_BLOCK_DATA:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1077: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1080: dup            
        //  1081: ldc_w           "ENDERMAN_IS_SCREAMING"
        //  1084: bipush          42
        //  1086: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENDERMAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1089: bipush          18
        //  1091: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1094: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1097: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1100: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENDERMAN_IS_SCREAMING:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1103: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1106: dup            
        //  1107: ldc_w           "ZOMBIE_CHILD"
        //  1110: bipush          43
        //  1112: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ZOMBIE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1115: bipush          12
        //  1117: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1120: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1123: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1126: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ZOMBIE_CHILD:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1129: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1132: dup            
        //  1133: ldc_w           "ZOMBIE_VILLAGER"
        //  1136: bipush          44
        //  1138: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ZOMBIE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1141: bipush          13
        //  1143: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1146: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1149: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1152: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ZOMBIE_VILLAGER:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1155: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1158: dup            
        //  1159: ldc_w           "ZOMBIE_CONVERTING"
        //  1162: bipush          45
        //  1164: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ZOMBIE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1167: bipush          14
        //  1169: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1172: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1175: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1178: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ZOMBIE_CONVERTING:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1181: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1184: dup            
        //  1185: ldc_w           "BLAZE_ON_FIRE"
        //  1188: bipush          46
        //  1190: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.BLAZE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1193: bipush          16
        //  1195: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1198: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1201: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1204: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.BLAZE_ON_FIRE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1207: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1210: dup            
        //  1211: ldc_w           "SPIDER_CLIMBING"
        //  1214: bipush          47
        //  1216: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SPIDER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1219: bipush          16
        //  1221: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1224: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1227: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1230: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.SPIDER_CLIMBING:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1233: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1236: dup            
        //  1237: ldc_w           "CREEPER_STATE"
        //  1240: bipush          48
        //  1242: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.CREEPER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1245: bipush          16
        //  1247: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1250: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1253: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1256: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.CREEPER_STATE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1259: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1262: dup            
        //  1263: ldc_w           "CREEPER_POWERED"
        //  1266: bipush          49
        //  1268: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.CREEPER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1271: bipush          17
        //  1273: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1276: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1279: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1282: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.CREEPER_POWERED:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1285: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1288: dup            
        //  1289: ldc_w           "GHAST_STATE"
        //  1292: bipush          50
        //  1294: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.GHAST:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1297: bipush          16
        //  1299: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1302: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1305: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1308: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.GHAST_STATE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1311: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1314: dup            
        //  1315: ldc_w           "GHAST_IS_POWERED"
        //  1318: bipush          51
        //  1320: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.GHAST:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1323: bipush          17
        //  1325: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.NonExistent:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1328: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1331: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1334: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.GHAST_IS_POWERED:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1337: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1340: dup            
        //  1341: ldc_w           "SLIME_SIZE"
        //  1344: bipush          52
        //  1346: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SLIME:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1349: bipush          16
        //  1351: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1354: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1357: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1360: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.SLIME_SIZE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1363: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1366: dup            
        //  1367: ldc_w           "SKELETON_TYPE"
        //  1370: bipush          53
        //  1372: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.SKELETON:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1375: bipush          13
        //  1377: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1380: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1383: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1386: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.SKELETON_TYPE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1389: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1392: dup            
        //  1393: ldc_w           "WITCH_AGRESSIVE"
        //  1396: bipush          54
        //  1398: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.WITCH:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1401: bipush          21
        //  1403: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1406: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1409: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1412: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.WITCH_AGRESSIVE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1415: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1418: dup            
        //  1419: ldc_w           "IRON_GOLEM_IS_PLAYER_CREATED"
        //  1422: bipush          55
        //  1424: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.IRON_GOLEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1427: bipush          16
        //  1429: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1432: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1435: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1438: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.IRON_GOLEM_IS_PLAYER_CREATED:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1441: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1444: dup            
        //  1445: ldc_w           "WITHER_WATCHED_TAGRET_1"
        //  1448: bipush          56
        //  1450: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.WITHER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1453: bipush          17
        //  1455: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Int:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1458: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Int:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1461: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1464: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.WITHER_WATCHED_TAGRET_1:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1467: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1470: dup            
        //  1471: ldc_w           "WITHER_WATCHED_TAGRET_2"
        //  1474: bipush          57
        //  1476: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.WITHER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1479: bipush          18
        //  1481: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Int:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1484: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Int:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1487: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1490: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.WITHER_WATCHED_TAGRET_2:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1493: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1496: dup            
        //  1497: ldc_w           "WITHER_WATCHED_TAGRET_3"
        //  1500: bipush          58
        //  1502: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.WITHER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1505: bipush          19
        //  1507: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Int:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1510: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Int:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1513: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1516: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.WITHER_WATCHED_TAGRET_3:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1519: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1522: dup            
        //  1523: ldc_w           "WITHER_INVULNERABLE_TIME"
        //  1526: bipush          59
        //  1528: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.WITHER:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1531: bipush          20
        //  1533: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Int:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1536: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Int:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1539: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1542: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.WITHER_INVULNERABLE_TIME:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1545: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1548: dup            
        //  1549: ldc_w           "GUARDIAN_FLAGS"
        //  1552: bipush          60
        //  1554: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.GUARDIAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1557: bipush          16
        //  1559: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.NonExistent:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1562: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1565: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1568: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.GUARDIAN_FLAGS:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1571: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1574: dup            
        //  1575: ldc_w           "GUARDIAN_TARGET"
        //  1578: bipush          61
        //  1580: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.GUARDIAN:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1583: bipush          17
        //  1585: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.NonExistent:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1588: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Int:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1591: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1594: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.GUARDIAN_TARGET:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1597: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1600: dup            
        //  1601: ldc_w           "BOAT_TIME_SINCE_HIT"
        //  1604: bipush          62
        //  1606: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.BOAT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1609: bipush          17
        //  1611: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Int:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1614: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Int:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1617: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1620: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.BOAT_TIME_SINCE_HIT:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1623: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1626: dup            
        //  1627: ldc_w           "BOAT_FORWARD_DIRECTION"
        //  1630: bipush          63
        //  1632: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.BOAT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1635: bipush          18
        //  1637: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Int:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1640: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Int:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1643: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1646: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.BOAT_FORWARD_DIRECTION:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1649: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1652: dup            
        //  1653: ldc_w           "BOAT_DAMAGE_TAKEN"
        //  1656: bipush          64
        //  1658: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.BOAT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1661: bipush          19
        //  1663: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Float:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1666: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Float:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1669: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1672: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.BOAT_DAMAGE_TAKEN:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1675: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1678: dup            
        //  1679: ldc_w           "MINECART_SHAKING_POWER"
        //  1682: bipush          65
        //  1684: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1687: bipush          17
        //  1689: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Int:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1692: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Int:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1695: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1698: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.MINECART_SHAKING_POWER:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1701: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1704: dup            
        //  1705: ldc_w           "MINECART_SHAKING_DIRECTION"
        //  1708: bipush          66
        //  1710: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1713: bipush          18
        //  1715: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Int:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1718: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Int:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1721: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1724: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.MINECART_SHAKING_DIRECTION:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1727: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1730: dup            
        //  1731: ldc_w           "MINECART_DAMAGE_TAKEN"
        //  1734: bipush          67
        //  1736: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1739: bipush          19
        //  1741: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Float:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1744: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Float:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1747: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1750: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.MINECART_DAMAGE_TAKEN:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1753: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1756: dup            
        //  1757: ldc_w           "MINECART_BLOCK_INSIDE"
        //  1760: bipush          68
        //  1762: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1765: bipush          20
        //  1767: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Int:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1770: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Int:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1773: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1776: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.MINECART_BLOCK_INSIDE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1779: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1782: dup            
        //  1783: ldc_w           "MINECART_BLOCK_Y"
        //  1786: bipush          69
        //  1788: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1791: bipush          21
        //  1793: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Int:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1796: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Int:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1799: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1802: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.MINECART_BLOCK_Y:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1805: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1808: dup            
        //  1809: ldc_w           "MINECART_SHOW_BLOCK"
        //  1812: bipush          70
        //  1814: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_ABSTRACT:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1817: bipush          22
        //  1819: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1822: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1825: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1828: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.MINECART_SHOW_BLOCK:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1831: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1834: dup            
        //  1835: ldc_w           "FURNACE_MINECART_IS_POWERED"
        //  1838: bipush          71
        //  1840: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.MINECART_FURNACE:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1843: bipush          16
        //  1845: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1848: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1851: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1854: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.FURNACE_MINECART_IS_POWERED:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1857: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1860: dup            
        //  1861: ldc_w           "ITEM_ITEM"
        //  1864: bipush          72
        //  1866: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.DROPPED_ITEM:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1869: bipush          10
        //  1871: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Slot:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1874: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Slot:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1877: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1880: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ITEM_ITEM:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1883: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1886: dup            
        //  1887: ldc_w           "ARROW_IS_CRITICAL"
        //  1890: bipush          73
        //  1892: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ARROW:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1895: bipush          16
        //  1897: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1900: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1903: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1906: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ARROW_IS_CRITICAL:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1909: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1912: dup            
        //  1913: ldc_w           "FIREWORK_INFO"
        //  1916: bipush          74
        //  1918: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.FIREWORK:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1921: bipush          8
        //  1923: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Slot:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1926: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Slot:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1929: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1932: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.FIREWORK_INFO:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1935: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1938: dup            
        //  1939: ldc_w           "ITEM_FRAME_ITEM"
        //  1942: bipush          75
        //  1944: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ITEM_FRAME:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1947: iconst_2       
        //  1948: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Slot:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1951: bipush          8
        //  1953: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Slot:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1956: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;ILcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1959: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ITEM_FRAME_ITEM:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1962: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1965: dup            
        //  1966: ldc_w           "ITEM_FRAME_ROTATION"
        //  1969: bipush          76
        //  1971: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ITEM_FRAME:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  1974: iconst_3       
        //  1975: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Byte:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  1978: bipush          9
        //  1980: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Byte:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  1983: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;ILcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  1986: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ITEM_FRAME_ROTATION:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1989: new             Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  1992: dup            
        //  1993: ldc_w           "ENDER_CRYSTAL_HEALTH"
        //  1996: bipush          77
        //  1998: getstatic       com/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType.ENDER_CRYSTAL:Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  2001: bipush          8
        //  2003: getstatic       de/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10.Int:Lde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;
        //  2006: bipush          9
        //  2008: getstatic       com/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8.Int:Lcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;
        //  2011: invokespecial   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.<init>:(Ljava/lang/String;ILcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;ILde/gerrygames/viarewind/protocol/protocol1_7_6_10to1_8/types/MetaType1_7_6_10;ILcom/viaversion/viaversion/api/minecraft/metadata/types/MetaType1_8;)V
        //  2014: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENDER_CRYSTAL_HEALTH:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2017: bipush          78
        //  2019: anewarray       Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2022: dup            
        //  2023: iconst_0       
        //  2024: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_FLAGS:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2027: aastore        
        //  2028: dup            
        //  2029: iconst_1       
        //  2030: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_AIR:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2033: aastore        
        //  2034: dup            
        //  2035: iconst_2       
        //  2036: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_NAME_TAG:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2039: aastore        
        //  2040: dup            
        //  2041: iconst_3       
        //  2042: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_NAME_TAG_VISIBILITY:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2045: aastore        
        //  2046: dup            
        //  2047: iconst_4       
        //  2048: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_SILENT:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2051: aastore        
        //  2052: dup            
        //  2053: iconst_5       
        //  2054: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_LIVING_HEALTH:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2057: aastore        
        //  2058: dup            
        //  2059: bipush          6
        //  2061: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_LIVING_POTION_EFFECT_COLOR:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2064: aastore        
        //  2065: dup            
        //  2066: bipush          7
        //  2068: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_LIVING_IS_POTION_EFFECT_AMBIENT:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2071: aastore        
        //  2072: dup            
        //  2073: bipush          8
        //  2075: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_LIVING_ARROWS:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2078: aastore        
        //  2079: dup            
        //  2080: bipush          9
        //  2082: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_LIVING_NAME_TAG:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2085: aastore        
        //  2086: dup            
        //  2087: bipush          10
        //  2089: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_LIVING_NAME_TAG_VISIBILITY:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2092: aastore        
        //  2093: dup            
        //  2094: bipush          11
        //  2096: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_LIVING_AI:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2099: aastore        
        //  2100: dup            
        //  2101: bipush          12
        //  2103: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENTITY_AGEABLE_AGE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2106: aastore        
        //  2107: dup            
        //  2108: bipush          13
        //  2110: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ARMOR_STAND_FLAGS:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2113: aastore        
        //  2114: dup            
        //  2115: bipush          14
        //  2117: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ARMOR_STAND_HEAD_POSITION:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2120: aastore        
        //  2121: dup            
        //  2122: bipush          15
        //  2124: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ARMOR_STAND_BODY_POSITION:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2127: aastore        
        //  2128: dup            
        //  2129: bipush          16
        //  2131: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ARMOR_STAND_LEFT_ARM_POSITION:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2134: aastore        
        //  2135: dup            
        //  2136: bipush          17
        //  2138: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ARMOR_STAND_RIGHT_ARM_POSITION:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2141: aastore        
        //  2142: dup            
        //  2143: bipush          18
        //  2145: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ARMOR_STAND_LEFT_LEG_POSITION:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2148: aastore        
        //  2149: dup            
        //  2150: bipush          19
        //  2152: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ARMOR_STAND_RIGHT_LEG_POSITION:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2155: aastore        
        //  2156: dup            
        //  2157: bipush          20
        //  2159: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.HUMAN_SKIN_FLAGS:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2162: aastore        
        //  2163: dup            
        //  2164: bipush          21
        //  2166: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.HUMAN_UNUSED:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2169: aastore        
        //  2170: dup            
        //  2171: bipush          22
        //  2173: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.HUMAN_ABSORPTION_HEATS:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2176: aastore        
        //  2177: dup            
        //  2178: bipush          23
        //  2180: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.HUMAN_SCORE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2183: aastore        
        //  2184: dup            
        //  2185: bipush          24
        //  2187: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.HORSE_FLAGS:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2190: aastore        
        //  2191: dup            
        //  2192: bipush          25
        //  2194: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.HORSE_TYPE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2197: aastore        
        //  2198: dup            
        //  2199: bipush          26
        //  2201: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.HORSE_COLOR:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2204: aastore        
        //  2205: dup            
        //  2206: bipush          27
        //  2208: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.HORSE_OWNER:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2211: aastore        
        //  2212: dup            
        //  2213: bipush          28
        //  2215: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.HORSE_ARMOR:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2218: aastore        
        //  2219: dup            
        //  2220: bipush          29
        //  2222: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.BAT_HANGING:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2225: aastore        
        //  2226: dup            
        //  2227: bipush          30
        //  2229: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.TAMEABLE_FLAGS:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2232: aastore        
        //  2233: dup            
        //  2234: bipush          31
        //  2236: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.TAMEABLE_OWNER:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2239: aastore        
        //  2240: dup            
        //  2241: bipush          32
        //  2243: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.OCELOT_TYPE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2246: aastore        
        //  2247: dup            
        //  2248: bipush          33
        //  2250: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.WOLF_FLAGS:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2253: aastore        
        //  2254: dup            
        //  2255: bipush          34
        //  2257: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.WOLF_HEALTH:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2260: aastore        
        //  2261: dup            
        //  2262: bipush          35
        //  2264: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.WOLF_BEGGING:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2267: aastore        
        //  2268: dup            
        //  2269: bipush          36
        //  2271: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.WOLF_COLLAR_COLOR:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2274: aastore        
        //  2275: dup            
        //  2276: bipush          37
        //  2278: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.PIG_SADDLE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2281: aastore        
        //  2282: dup            
        //  2283: bipush          38
        //  2285: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.SHEEP_COLOR_OR_SHEARED:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2288: aastore        
        //  2289: dup            
        //  2290: bipush          39
        //  2292: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.VILLAGER_TYPE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2295: aastore        
        //  2296: dup            
        //  2297: bipush          40
        //  2299: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENDERMAN_CARRIED_BLOCK:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2302: aastore        
        //  2303: dup            
        //  2304: bipush          41
        //  2306: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENDERMAN_CARRIED_BLOCK_DATA:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2309: aastore        
        //  2310: dup            
        //  2311: bipush          42
        //  2313: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENDERMAN_IS_SCREAMING:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2316: aastore        
        //  2317: dup            
        //  2318: bipush          43
        //  2320: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ZOMBIE_CHILD:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2323: aastore        
        //  2324: dup            
        //  2325: bipush          44
        //  2327: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ZOMBIE_VILLAGER:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2330: aastore        
        //  2331: dup            
        //  2332: bipush          45
        //  2334: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ZOMBIE_CONVERTING:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2337: aastore        
        //  2338: dup            
        //  2339: bipush          46
        //  2341: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.BLAZE_ON_FIRE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2344: aastore        
        //  2345: dup            
        //  2346: bipush          47
        //  2348: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.SPIDER_CLIMBING:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2351: aastore        
        //  2352: dup            
        //  2353: bipush          48
        //  2355: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.CREEPER_STATE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2358: aastore        
        //  2359: dup            
        //  2360: bipush          49
        //  2362: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.CREEPER_POWERED:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2365: aastore        
        //  2366: dup            
        //  2367: bipush          50
        //  2369: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.GHAST_STATE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2372: aastore        
        //  2373: dup            
        //  2374: bipush          51
        //  2376: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.GHAST_IS_POWERED:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2379: aastore        
        //  2380: dup            
        //  2381: bipush          52
        //  2383: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.SLIME_SIZE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2386: aastore        
        //  2387: dup            
        //  2388: bipush          53
        //  2390: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.SKELETON_TYPE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2393: aastore        
        //  2394: dup            
        //  2395: bipush          54
        //  2397: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.WITCH_AGRESSIVE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2400: aastore        
        //  2401: dup            
        //  2402: bipush          55
        //  2404: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.IRON_GOLEM_IS_PLAYER_CREATED:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2407: aastore        
        //  2408: dup            
        //  2409: bipush          56
        //  2411: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.WITHER_WATCHED_TAGRET_1:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2414: aastore        
        //  2415: dup            
        //  2416: bipush          57
        //  2418: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.WITHER_WATCHED_TAGRET_2:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2421: aastore        
        //  2422: dup            
        //  2423: bipush          58
        //  2425: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.WITHER_WATCHED_TAGRET_3:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2428: aastore        
        //  2429: dup            
        //  2430: bipush          59
        //  2432: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.WITHER_INVULNERABLE_TIME:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2435: aastore        
        //  2436: dup            
        //  2437: bipush          60
        //  2439: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.GUARDIAN_FLAGS:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2442: aastore        
        //  2443: dup            
        //  2444: bipush          61
        //  2446: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.GUARDIAN_TARGET:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2449: aastore        
        //  2450: dup            
        //  2451: bipush          62
        //  2453: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.BOAT_TIME_SINCE_HIT:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2456: aastore        
        //  2457: dup            
        //  2458: bipush          63
        //  2460: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.BOAT_FORWARD_DIRECTION:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2463: aastore        
        //  2464: dup            
        //  2465: bipush          64
        //  2467: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.BOAT_DAMAGE_TAKEN:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2470: aastore        
        //  2471: dup            
        //  2472: bipush          65
        //  2474: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.MINECART_SHAKING_POWER:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2477: aastore        
        //  2478: dup            
        //  2479: bipush          66
        //  2481: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.MINECART_SHAKING_DIRECTION:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2484: aastore        
        //  2485: dup            
        //  2486: bipush          67
        //  2488: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.MINECART_DAMAGE_TAKEN:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2491: aastore        
        //  2492: dup            
        //  2493: bipush          68
        //  2495: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.MINECART_BLOCK_INSIDE:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2498: aastore        
        //  2499: dup            
        //  2500: bipush          69
        //  2502: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.MINECART_BLOCK_Y:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2505: aastore        
        //  2506: dup            
        //  2507: bipush          70
        //  2509: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.MINECART_SHOW_BLOCK:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2512: aastore        
        //  2513: dup            
        //  2514: bipush          71
        //  2516: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.FURNACE_MINECART_IS_POWERED:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2519: aastore        
        //  2520: dup            
        //  2521: bipush          72
        //  2523: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ITEM_ITEM:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2526: aastore        
        //  2527: dup            
        //  2528: bipush          73
        //  2530: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ARROW_IS_CRITICAL:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2533: aastore        
        //  2534: dup            
        //  2535: bipush          74
        //  2537: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.FIREWORK_INFO:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2540: aastore        
        //  2541: dup            
        //  2542: bipush          75
        //  2544: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ITEM_FRAME_ITEM:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2547: aastore        
        //  2548: dup            
        //  2549: bipush          76
        //  2551: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ITEM_FRAME_ROTATION:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2554: aastore        
        //  2555: dup            
        //  2556: bipush          77
        //  2558: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.ENDER_CRYSTAL_HEALTH:Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2561: aastore        
        //  2562: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.$VALUES:[Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2565: new             Ljava/util/HashMap;
        //  2568: dup            
        //  2569: invokespecial   java/util/HashMap.<init>:()V
        //  2572: putstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.metadataRewrites:Ljava/util/HashMap;
        //  2575: invokestatic    de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.values:()[Lde/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10;
        //  2578: astore_0        /* llllllllllllIlllllIIlIllIIIIlIll */
        //  2579: aload_0         /* llllllllllllIlllllIIlIllIIIIlIll */
        //  2580: arraylength    
        //  2581: istore_1        /* llllllllllllIlllllIIlIllIIIIlIlI */
        //  2582: iconst_0       
        //  2583: istore_2        /* llllllllllllIlllllIIlIllIIIIlIIl */
        //  2584: iload_2         /* llllllllllllIlllllIIlIllIIIIlIIl */
        //  2585: iload_1         /* llllllllllllIlllllIIlIllIIIIlIlI */
        //  2586: if_icmpge       2625
        //  2589: aload_0         /* llllllllllllIlllllIIlIllIIIIlIll */
        //  2590: iload_2         /* llllllllllllIlllllIIlIllIIIIlIIl */
        //  2591: aaload         
        //  2592: astore_3        /* llllllllllllIlllllIIlIllIIIIllII */
        //  2593: getstatic       de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.metadataRewrites:Ljava/util/HashMap;
        //  2596: new             Lcom/viaversion/viaversion/util/Pair;
        //  2599: dup            
        //  2600: aload_3         /* llllllllllllIlllllIIlIllIIIIllII */
        //  2601: invokevirtual   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.getClazz:()Lcom/viaversion/viaversion/api/minecraft/entities/Entity1_10Types$EntityType;
        //  2604: aload_3         /* llllllllllllIlllllIIlIllIIIIllII */
        //  2605: invokevirtual   de/gerrygames/viarewind/protocol/protocol1_8to1_7_6_10/metadata/MetaIndex1_8to1_7_6_10.getIndex:()I
        //  2608: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //  2611: invokespecial   com/viaversion/viaversion/util/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //  2614: aload_3         /* llllllllllllIlllllIIlIllIIIIllII */
        //  2615: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  2618: pop            
        //  2619: iinc            llllllllllllIlllllIIlIllIIIIlIIl, 1
        //  2622: goto            2584
        //  2625: return         
        //    StackMapTable: 00 02 FE 0A 18 07 02 34 01 01 28
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
    
    public MetaType1_8 getNewType() {
        return this.newType;
    }
    
    private static Optional<MetaIndex1_8to1_7_6_10> getIndex(final Entity1_10Types.EntityType llllllllllllIlllllIIlIllIIlIlllI, final int llllllllllllIlllllIIlIllIIlIllIl) {
        final Pair llllllllllllIlllllIIlIllIIlIllll = new Pair((X)llllllllllllIlllllIIlIllIIlIlllI, (Y)llllllllllllIlllllIIlIllIIlIllIl);
        if (MetaIndex1_8to1_7_6_10.metadataRewrites.containsKey(llllllllllllIlllllIIlIllIIlIllll)) {
            return Optional.of(MetaIndex1_8to1_7_6_10.metadataRewrites.get(llllllllllllIlllllIIlIllIIlIllll));
        }
        return Optional.empty();
    }
    
    public int getIndex() {
        return this.index;
    }
    
    private MetaIndex1_8to1_7_6_10(final Entity1_10Types.EntityType llllllllllllIlllllIIlIllIlIIIIIl, final int llllllllllllIlllllIIlIllIlIIIIII, final MetaType1_7_6_10 llllllllllllIlllllIIlIllIIllIlll, final int llllllllllllIlllllIIlIllIIllIllI, final MetaType1_8 llllllllllllIlllllIIlIllIIllllIl) {
        this.clazz = llllllllllllIlllllIIlIllIlIIIIIl;
        this.index = llllllllllllIlllllIIlIllIlIIIIII;
        this.oldType = llllllllllllIlllllIIlIllIIllIlll;
        this.newIndex = llllllllllllIlllllIIlIllIIllIllI;
        this.newType = llllllllllllIlllllIIlIllIIllllIl;
    }
    
    public static MetaIndex1_8to1_7_6_10 searchIndex(final Entity1_10Types.EntityType llllllllllllIlllllIIlIllIIIlIlll, final int llllllllllllIlllllIIlIllIIIlIIll) {
        Entity1_10Types.EntityType llllllllllllIlllllIIlIllIIIlIlIl = llllllllllllIlllllIIlIllIIIlIlll;
        do {
            final Optional<MetaIndex1_8to1_7_6_10> llllllllllllIlllllIIlIllIIIllIII = getIndex(llllllllllllIlllllIIlIllIIIlIlIl, llllllllllllIlllllIIlIllIIIlIIll);
            if (llllllllllllIlllllIIlIllIIIllIII.isPresent()) {
                return llllllllllllIlllllIIlIllIIIllIII.get();
            }
            llllllllllllIlllllIIlIllIIIlIlIl = llllllllllllIlllllIIlIllIIIlIlIl.getParent();
        } while (llllllllllllIlllllIIlIllIIIlIlIl != null);
        return null;
    }
    
    public Entity1_10Types.EntityType getClazz() {
        return this.clazz;
    }
}
