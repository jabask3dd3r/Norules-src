package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.data;

import com.viaversion.viaversion.libs.gson.*;
import java.util.*;
import com.google.common.collect.*;
import com.viaversion.viaversion.api.data.*;

public class MappingData extends MappingDataBase
{
    private final /* synthetic */ Map<String, Integer[]> itemTags;
    private final /* synthetic */ Map<String, String> mojangTranslation;
    private final /* synthetic */ BiMap<String, String> channelMappings;
    private final /* synthetic */ Map<String, Integer[]> fluidTags;
    private /* synthetic */ Mappings enchantmentMappings;
    private final /* synthetic */ BiMap<Short, String> oldEnchantmentsIds;
    private final /* synthetic */ Map<String, Integer[]> blockTags;
    private final /* synthetic */ Map<String, String> translateMapping;
    
    private void loadEnchantments(final Map<Short, String> lllllllllllllIlIIlIllIIIlIIIIlIl, final JsonObject lllllllllllllIlIIlIllIIIlIIIIlII) {
        for (final Map.Entry<String, JsonElement> lllllllllllllIlIIlIllIIIlIIIlIIl : lllllllllllllIlIIlIllIIIlIIIIlII.entrySet()) {
            lllllllllllllIlIIlIllIIIlIIIIlIl.put(Short.parseShort(lllllllllllllIlIIlIllIIIlIIIlIIl.getKey()), lllllllllllllIlIIlIllIIIlIIIlIIl.getValue().getAsString());
        }
    }
    
    public Map<String, String> getTranslateMapping() {
        return this.translateMapping;
    }
    
    public void loadExtras(final JsonObject lllllllllllllIlIIlIllIIIllIIIllI, final JsonObject lllllllllllllIlIIlIllIIIllIIlIll, final JsonObject lllllllllllllIlIIlIllIIIllIIlIlI) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_0         /* lllllllllllllIlIIlIllIIIllIIllIl */
        //     2: getfield        com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData.blockTags:Ljava/util/Map;
        //     5: aload_2         /* lllllllllllllIlIIlIllIIIllIIIlIl */
        //     6: ldc             "block_tags"
        //     8: invokevirtual   com/viaversion/viaversion/libs/gson/JsonObject.getAsJsonObject:(Ljava/lang/String;)Lcom/viaversion/viaversion/libs/gson/JsonObject;
        //    11: invokespecial   com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData.loadTags:(Ljava/util/Map;Lcom/viaversion/viaversion/libs/gson/JsonObject;)V
        //    14: aload_0         /* lllllllllllllIlIIlIllIIIllIIllIl */
        //    15: aload_0         /* lllllllllllllIlIIlIllIIIllIIllIl */
        //    16: getfield        com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData.itemTags:Ljava/util/Map;
        //    19: aload_2         /* lllllllllllllIlIIlIllIIIllIIIlIl */
        //    20: ldc             "item_tags"
        //    22: invokevirtual   com/viaversion/viaversion/libs/gson/JsonObject.getAsJsonObject:(Ljava/lang/String;)Lcom/viaversion/viaversion/libs/gson/JsonObject;
        //    25: invokespecial   com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData.loadTags:(Ljava/util/Map;Lcom/viaversion/viaversion/libs/gson/JsonObject;)V
        //    28: aload_0         /* lllllllllllllIlIIlIllIIIllIIllIl */
        //    29: aload_0         /* lllllllllllllIlIIlIllIIIllIIllIl */
        //    30: getfield        com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData.fluidTags:Ljava/util/Map;
        //    33: aload_2         /* lllllllllllllIlIIlIllIIIllIIIlIl */
        //    34: ldc             "fluid_tags"
        //    36: invokevirtual   com/viaversion/viaversion/libs/gson/JsonObject.getAsJsonObject:(Ljava/lang/String;)Lcom/viaversion/viaversion/libs/gson/JsonObject;
        //    39: invokespecial   com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData.loadTags:(Ljava/util/Map;Lcom/viaversion/viaversion/libs/gson/JsonObject;)V
        //    42: aload_0         /* lllllllllllllIlIIlIllIIIllIIllIl */
        //    43: aload_0         /* lllllllllllllIlIIlIllIIIllIIllIl */
        //    44: getfield        com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData.oldEnchantmentsIds:Lcom/google/common/collect/BiMap;
        //    47: aload_1         /* lllllllllllllIlIIlIllIIIllIIllII */
        //    48: ldc             "enchantments"
        //    50: invokevirtual   com/viaversion/viaversion/libs/gson/JsonObject.getAsJsonObject:(Ljava/lang/String;)Lcom/viaversion/viaversion/libs/gson/JsonObject;
        //    53: invokespecial   com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData.loadEnchantments:(Ljava/util/Map;Lcom/viaversion/viaversion/libs/gson/JsonObject;)V
        //    56: aload_0         /* lllllllllllllIlIIlIllIIIllIIllIl */
        //    57: new             Lcom/viaversion/viaversion/api/data/IntArrayMappings;
        //    60: dup            
        //    61: bipush          72
        //    63: aload_1         /* lllllllllllllIlIIlIllIIIllIIllII */
        //    64: ldc             "enchantments"
        //    66: invokevirtual   com/viaversion/viaversion/libs/gson/JsonObject.getAsJsonObject:(Ljava/lang/String;)Lcom/viaversion/viaversion/libs/gson/JsonObject;
        //    69: aload_2         /* lllllllllllllIlIIlIllIIIllIIIlIl */
        //    70: ldc             "enchantments"
        //    72: invokevirtual   com/viaversion/viaversion/libs/gson/JsonObject.getAsJsonObject:(Ljava/lang/String;)Lcom/viaversion/viaversion/libs/gson/JsonObject;
        //    75: invokespecial   com/viaversion/viaversion/api/data/IntArrayMappings.<init>:(ILcom/viaversion/viaversion/libs/gson/JsonObject;Lcom/viaversion/viaversion/libs/gson/JsonObject;)V
        //    78: putfield        com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData.enchantmentMappings:Lcom/viaversion/viaversion/api/data/Mappings;
        //    81: invokestatic    com/viaversion/viaversion/api/Via.getConfig:()Lcom/viaversion/viaversion/api/configuration/ViaVersionConfig;
        //    84: invokeinterface com/viaversion/viaversion/api/configuration/ViaVersionConfig.isSnowCollisionFix:()Z
        //    89: ifeq            107
        //    92: aload_0         /* lllllllllllllIlIIlIllIIIllIIllIl */
        //    93: getfield        com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData.blockMappings:Lcom/viaversion/viaversion/api/data/Mappings;
        //    96: sipush          1248
        //    99: sipush          3416
        //   102: invokeinterface com/viaversion/viaversion/api/data/Mappings.setNewId:(II)V
        //   107: invokestatic    com/viaversion/viaversion/api/Via.getConfig:()Lcom/viaversion/viaversion/api/configuration/ViaVersionConfig;
        //   110: invokeinterface com/viaversion/viaversion/api/configuration/ViaVersionConfig.isInfestedBlocksFix:()Z
        //   115: ifeq            205
        //   118: aload_0         /* lllllllllllllIlIIlIllIIIllIIllIl */
        //   119: getfield        com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData.blockMappings:Lcom/viaversion/viaversion/api/data/Mappings;
        //   122: sipush          1552
        //   125: iconst_1       
        //   126: invokeinterface com/viaversion/viaversion/api/data/Mappings.setNewId:(II)V
        //   131: aload_0         /* lllllllllllllIlIIlIllIIIllIIllIl */
        //   132: getfield        com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData.blockMappings:Lcom/viaversion/viaversion/api/data/Mappings;
        //   135: sipush          1553
        //   138: bipush          14
        //   140: invokeinterface com/viaversion/viaversion/api/data/Mappings.setNewId:(II)V
        //   145: aload_0         /* lllllllllllllIlIIlIllIIIllIIllIl */
        //   146: getfield        com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData.blockMappings:Lcom/viaversion/viaversion/api/data/Mappings;
        //   149: sipush          1554
        //   152: sipush          3983
        //   155: invokeinterface com/viaversion/viaversion/api/data/Mappings.setNewId:(II)V
        //   160: aload_0         /* lllllllllllllIlIIlIllIIIllIIllIl */
        //   161: getfield        com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData.blockMappings:Lcom/viaversion/viaversion/api/data/Mappings;
        //   164: sipush          1555
        //   167: sipush          3984
        //   170: invokeinterface com/viaversion/viaversion/api/data/Mappings.setNewId:(II)V
        //   175: aload_0         /* lllllllllllllIlIIlIllIIIllIIllIl */
        //   176: getfield        com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData.blockMappings:Lcom/viaversion/viaversion/api/data/Mappings;
        //   179: sipush          1556
        //   182: sipush          3985
        //   185: invokeinterface com/viaversion/viaversion/api/data/Mappings.setNewId:(II)V
        //   190: aload_0         /* lllllllllllllIlIIlIllIIIllIIllIl */
        //   191: getfield        com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData.blockMappings:Lcom/viaversion/viaversion/api/data/Mappings;
        //   194: sipush          1557
        //   197: sipush          3986
        //   200: invokeinterface com/viaversion/viaversion/api/data/Mappings.setNewId:(II)V
        //   205: ldc             "channelmappings-1.13.json"
        //   207: invokestatic    com/viaversion/viaversion/api/data/MappingDataLoader.loadFromDataDir:(Ljava/lang/String;)Lcom/viaversion/viaversion/libs/gson/JsonObject;
        //   210: astore          lllllllllllllIlIIlIllIIIllIIlIIl
        //   212: aload           lllllllllllllIlIIlIllIIIllIIlIIl
        //   214: ifnull          342
        //   217: aload           lllllllllllllIlIIlIllIIIllIIlIIl
        //   219: invokevirtual   com/viaversion/viaversion/libs/gson/JsonObject.entrySet:()Ljava/util/Set;
        //   222: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //   227: astore          lllllllllllllIlIIlIllIIIllIIIIll
        //   229: aload           lllllllllllllIlIIlIllIIIllIIIIll
        //   231: invokeinterface java/util/Iterator.hasNext:()Z
        //   236: ifeq            342
        //   239: aload           lllllllllllllIlIIlIllIIIllIIIIll
        //   241: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   246: checkcast       Ljava/util/Map$Entry;
        //   249: astore          lllllllllllllIlIIlIllIIIllIlIlll
        //   251: aload           lllllllllllllIlIIlIllIIIllIlIlll
        //   253: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   258: checkcast       Ljava/lang/String;
        //   261: astore          lllllllllllllIlIIlIllIIIllIllIIl
        //   263: aload           lllllllllllllIlIIlIllIIIllIlIlll
        //   265: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   270: checkcast       Lcom/viaversion/viaversion/libs/gson/JsonElement;
        //   273: invokevirtual   com/viaversion/viaversion/libs/gson/JsonElement.getAsString:()Ljava/lang/String;
        //   276: astore          lllllllllllllIlIIlIllIIIllIllIII
        //   278: aload           lllllllllllllIlIIlIllIIIllIllIII
        //   280: invokestatic    com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData.isValid1_13Channel:(Ljava/lang/String;)Z
        //   283: ifne            325
        //   286: invokestatic    com/viaversion/viaversion/api/Via.getPlatform:()Lcom/viaversion/viaversion/api/platform/ViaPlatform;
        //   289: invokeinterface com/viaversion/viaversion/api/platform/ViaPlatform.getLogger:()Ljava/util/logging/Logger;
        //   294: new             Ljava/lang/StringBuilder;
        //   297: dup            
        //   298: invokespecial   java/lang/StringBuilder.<init>:()V
        //   301: ldc             "Channel '"
        //   303: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   306: aload           lllllllllllllIlIIlIllIIIllIllIII
        //   308: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   311: ldc             "' is not a valid 1.13 plugin channel, please check your configuration!"
        //   313: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   316: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   319: invokevirtual   java/util/logging/Logger.warning:(Ljava/lang/String;)V
        //   322: goto            229
        //   325: aload_0         /* lllllllllllllIlIIlIllIIIllIIllIl */
        //   326: getfield        com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData.channelMappings:Lcom/google/common/collect/BiMap;
        //   329: aload           lllllllllllllIlIIlIllIIIllIllIIl
        //   331: aload           lllllllllllllIlIIlIllIIIllIllIII
        //   333: invokeinterface com/google/common/collect/BiMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   338: pop            
        //   339: goto            229
        //   342: invokestatic    com/viaversion/viaversion/util/GsonUtil.getGson:()Lcom/viaversion/viaversion/libs/gson/Gson;
        //   345: new             Ljava/io/InputStreamReader;
        //   348: dup            
        //   349: ldc             Lcom/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData;.class
        //   351: invokevirtual   java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader;
        //   354: ldc             "assets/viaversion/data/mapping-lang-1.12-1.13.json"
        //   356: invokevirtual   java/lang/ClassLoader.getResourceAsStream:(Ljava/lang/String;)Ljava/io/InputStream;
        //   359: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //   362: new             Lcom/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData$1;
        //   365: dup            
        //   366: aload_0         /* lllllllllllllIlIIlIllIIIllIIllIl */
        //   367: invokespecial   com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData$1.<init>:(Lcom/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData;)V
        //   370: invokevirtual   com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData$1.getType:()Ljava/lang/reflect/Type;
        //   373: invokevirtual   com/viaversion/viaversion/libs/gson/Gson.fromJson:(Ljava/io/Reader;Ljava/lang/reflect/Type;)Ljava/lang/Object;
        //   376: checkcast       Ljava/util/Map;
        //   379: astore          lllllllllllllIlIIlIllIIIllIIlIII
        //   381: new             Ljava/io/InputStreamReader;
        //   384: dup            
        //   385: ldc             Lcom/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData;.class
        //   387: invokevirtual   java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader;
        //   390: ldc             "assets/viaversion/data/en_US.properties"
        //   392: invokevirtual   java/lang/ClassLoader.getResourceAsStream:(Ljava/lang/String;)Ljava/io/InputStream;
        //   395: getstatic       java/nio/charset/StandardCharsets.UTF_8:Ljava/nio/charset/Charset;
        //   398: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
        //   401: astore          lllllllllllllIlIIlIllIIIllIlIlIl
        //   403: aload           lllllllllllllIlIIlIllIIIllIlIlIl
        //   405: invokestatic    com/google/common/io/CharStreams.toString:(Ljava/lang/Readable;)Ljava/lang/String;
        //   408: ldc_w           "\n"
        //   411: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //   414: astore          lllllllllllllIlIIlIllIIIllIlIllI
        //   416: aload           lllllllllllllIlIIlIllIIIllIlIlIl
        //   418: invokevirtual   java/io/Reader.close:()V
        //   421: goto            446
        //   424: astore          8
        //   426: aload           lllllllllllllIlIIlIllIIIllIlIlIl
        //   428: invokevirtual   java/io/Reader.close:()V
        //   431: goto            443
        //   434: astore          lllllllllllllIlIIlIllIIIlIllllll
        //   436: aload           8
        //   438: aload           lllllllllllllIlIIlIllIIIlIllllll
        //   440: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
        //   443: aload           8
        //   445: athrow         
        //   446: aload           lllllllllllllIlIIlIllIIIllIIllll
        //   448: astore          7
        //   450: aload           7
        //   452: arraylength    
        //   453: istore          8
        //   455: iconst_0       
        //   456: istore          lllllllllllllIlIIlIllIIIlIllllll
        //   458: iload           lllllllllllllIlIIlIllIIIlIllllll
        //   460: iload           8
        //   462: if_icmpge       593
        //   465: aload           7
        //   467: iload           lllllllllllllIlIIlIllIIIlIllllll
        //   469: aaload         
        //   470: astore          lllllllllllllIlIIlIllIIIllIlIIII
        //   472: aload           lllllllllllllIlIIlIllIIIllIlIIII
        //   474: invokevirtual   java/lang/String.isEmpty:()Z
        //   477: ifeq            483
        //   480: goto            587
        //   483: aload           lllllllllllllIlIIlIllIIIllIlIIII
        //   485: ldc_w           "="
        //   488: iconst_2       
        //   489: invokevirtual   java/lang/String.split:(Ljava/lang/String;I)[Ljava/lang/String;
        //   492: astore          lllllllllllllIlIIlIllIIIllIlIIlI
        //   494: aload           lllllllllllllIlIIlIllIIIllIlIIlI
        //   496: arraylength    
        //   497: iconst_2       
        //   498: if_icmpeq       504
        //   501: goto            587
        //   504: aload           lllllllllllllIlIIlIllIIIllIlIIlI
        //   506: iconst_0       
        //   507: aaload         
        //   508: astore          lllllllllllllIlIIlIllIIIllIlIIIl
        //   510: aload           lllllllllllllIlIIlIllIIIllIIlIII
        //   512: aload           lllllllllllllIlIIlIllIIIllIlIIIl
        //   514: invokeinterface java/util/Map.containsKey:(Ljava/lang/Object;)Z
        //   519: ifne            554
        //   522: aload           lllllllllllllIlIIlIllIIIllIlIIlI
        //   524: iconst_1       
        //   525: aaload         
        //   526: ldc_w           "%(\\d\\$)?d"
        //   529: ldc_w           "%$1s"
        //   532: invokevirtual   java/lang/String.replaceAll:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   535: astore          lllllllllllllIlIIlIllIIIllIlIlII
        //   537: aload_0         /* lllllllllllllIlIIlIllIIIllIIllIl */
        //   538: getfield        com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData.mojangTranslation:Ljava/util/Map;
        //   541: aload           lllllllllllllIlIIlIllIIIllIlIIIl
        //   543: aload           lllllllllllllIlIIlIllIIIllIlIlII
        //   545: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   550: pop            
        //   551: goto            587
        //   554: aload           lllllllllllllIlIIlIllIIIllIIlIII
        //   556: aload           lllllllllllllIlIIlIllIIIllIlIIIl
        //   558: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   563: checkcast       Ljava/lang/String;
        //   566: astore          lllllllllllllIlIIlIllIIIllIlIIll
        //   568: aload           lllllllllllllIlIIlIllIIIllIlIIll
        //   570: ifnull          587
        //   573: aload_0         /* lllllllllllllIlIIlIllIIIllIIllIl */
        //   574: getfield        com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/MappingData.translateMapping:Ljava/util/Map;
        //   577: aload           lllllllllllllIlIIlIllIIIllIlIIIl
        //   579: aload           lllllllllllllIlIIlIllIIIllIlIIll
        //   581: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   586: pop            
        //   587: iinc            lllllllllllllIlIIlIllIIIlIllllll, 1
        //   590: goto            458
        //   593: goto            603
        //   596: astore          lllllllllllllIlIIlIllIIIllIIlllI
        //   598: aload           lllllllllllllIlIIlIllIIIllIIlllI
        //   600: invokevirtual   java/io/IOException.printStackTrace:()V
        //   603: return         
        //    StackMapTable: 00 11 FB 00 6B FB 00 61 FD 00 17 07 00 1F 07 00 2B FE 00 5F 07 00 08 07 00 38 07 00 38 FF 00 10 00 05 07 00 02 07 00 1F 07 00 1F 07 00 1F 07 00 1F 00 00 FF 00 51 00 08 07 00 02 07 00 1F 07 00 1F 07 00 1F 07 00 1F 07 00 0A 00 07 00 DE 00 01 07 00 6C FF 00 09 00 09 07 00 02 07 00 1F 07 00 1F 07 00 1F 07 00 1F 07 00 0A 00 07 00 DE 07 00 6C 00 01 07 00 6C 08 FF 00 02 00 08 07 00 02 07 00 1F 07 00 1F 07 00 1F 07 00 1F 07 00 0A 07 01 5F 07 00 DE 00 00 FF 00 0B 00 0A 07 00 02 07 00 1F 07 00 1F 07 00 1F 07 00 1F 07 00 0A 07 01 5F 07 01 5F 01 01 00 00 FC 00 18 07 00 38 FC 00 14 07 01 5F FC 00 31 07 00 38 F9 00 20 FA 00 05 FF 00 02 00 06 07 00 02 07 00 1F 07 00 1F 07 00 1F 07 00 1F 07 00 0A 00 01 07 00 6E FC 00 06 07 01 61
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  403    416    424    446    Ljava/lang/Throwable;
        //  426    431    434    443    Ljava/lang/Throwable;
        //  381    593    596    603    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void loadTags(final Map<String, Integer[]> lllllllllllllIlIIlIllIIIlIIlIlII, final JsonObject lllllllllllllIlIIlIllIIIlIIlIlIl) {
        for (final Map.Entry<String, JsonElement> lllllllllllllIlIIlIllIIIlIIllIII : lllllllllllllIlIIlIllIIIlIIlIlIl.entrySet()) {
            final JsonArray lllllllllllllIlIIlIllIIIlIIllIlI = lllllllllllllIlIIlIllIIIlIIllIII.getValue().getAsJsonArray();
            final Integer[] lllllllllllllIlIIlIllIIIlIIllIIl = new Integer[lllllllllllllIlIIlIllIIIlIIllIlI.size()];
            for (int lllllllllllllIlIIlIllIIIlIIllIll = 0; lllllllllllllIlIIlIllIIIlIIllIll < lllllllllllllIlIIlIllIIIlIIllIlI.size(); ++lllllllllllllIlIIlIllIIIlIIllIll) {
                lllllllllllllIlIIlIllIIIlIIllIIl[lllllllllllllIlIIlIllIIIlIIllIll] = lllllllllllllIlIIlIllIIIlIIllIlI.get(lllllllllllllIlIIlIllIIIlIIllIll).getAsInt();
            }
            lllllllllllllIlIIlIllIIIlIIlIlII.put(lllllllllllllIlIIlIllIIIlIIllIII.getKey(), lllllllllllllIlIIlIllIIIlIIllIIl);
        }
    }
    
    public MappingData() {
        super("1.12", "1.13");
        this.blockTags = new HashMap<String, Integer[]>();
        this.itemTags = new HashMap<String, Integer[]>();
        this.fluidTags = new HashMap<String, Integer[]>();
        this.oldEnchantmentsIds = (BiMap<Short, String>)HashBiMap.create();
        this.translateMapping = new HashMap<String, String>();
        this.mojangTranslation = new HashMap<String, String>();
        this.channelMappings = (BiMap<String, String>)HashBiMap.create();
    }
    
    public Map<String, String> getMojangTranslation() {
        return this.mojangTranslation;
    }
    
    public static boolean isValid1_13Channel(final String lllllllllllllIlIIlIllIIIlIlIIIll) {
        return lllllllllllllIlIIlIllIIIlIlIIIll.matches("([0-9a-z_.-]+):([0-9a-z_/.-]+)");
    }
    
    public BiMap<String, String> getChannelMappings() {
        return this.channelMappings;
    }
    
    @Override
    protected Mappings loadFromObject(final JsonObject lllllllllllllIlIIlIllIIIlIllIlII, final JsonObject lllllllllllllIlIIlIllIIIlIlIlllI, final JsonObject lllllllllllllIlIIlIllIIIlIllIIlI, final String lllllllllllllIlIIlIllIIIlIlIllII) {
        if (lllllllllllllIlIIlIllIIIlIlIllII.equals("blocks")) {
            return new IntArrayMappings(4084, lllllllllllllIlIIlIllIIIlIllIlII.getAsJsonObject("blocks"), lllllllllllllIlIIlIllIIIlIlIlllI.getAsJsonObject("blockstates"));
        }
        return super.loadFromObject(lllllllllllllIlIIlIllIIIlIllIlII, lllllllllllllIlIIlIllIIIlIlIlllI, lllllllllllllIlIIlIllIIIlIllIIlI, lllllllllllllIlIIlIllIIIlIlIllII);
    }
    
    public Mappings getEnchantmentMappings() {
        return this.enchantmentMappings;
    }
    
    public BiMap<Short, String> getOldEnchantmentsIds() {
        return this.oldEnchantmentsIds;
    }
    
    public Map<String, Integer[]> getFluidTags() {
        return this.fluidTags;
    }
    
    public static String validateNewChannel(String lllllllllllllIlIIlIllIIIlIlIIlll) {
        if (!isValid1_13Channel((String)lllllllllllllIlIIlIllIIIlIlIIlll)) {
            return null;
        }
        final int lllllllllllllIlIIlIllIIIlIlIlIII = ((String)lllllllllllllIlIIlIllIIIlIlIIlll).indexOf(58);
        if ((lllllllllllllIlIIlIllIIIlIlIlIII == -1 || lllllllllllllIlIIlIllIIIlIlIlIII == 0) && ((String)lllllllllllllIlIIlIllIIIlIlIIlll).length() <= 10) {
            lllllllllllllIlIIlIllIIIlIlIIlll = String.valueOf(new StringBuilder().append("minecraft:").append((String)lllllllllllllIlIIlIllIIIlIlIIlll));
        }
        return (String)lllllllllllllIlIIlIllIIIlIlIIlll;
    }
    
    public Map<String, Integer[]> getItemTags() {
        return this.itemTags;
    }
    
    public Map<String, Integer[]> getBlockTags() {
        return this.blockTags;
    }
}
