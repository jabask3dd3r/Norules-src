package com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.block_entity_handlers;

import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.providers.*;
import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.*;
import com.viaversion.viaversion.api.connection.*;
import java.util.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class PistonHandler implements BackwardsBlockEntityProvider.BackwardsBlockEntityHandler
{
    private final /* synthetic */ Map<String, Integer> pistonIds;
    
    public PistonHandler() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.<init>:()V
        //     4: aload_0         /* llIIllIIlIlIll */
        //     5: new             Ljava/util/HashMap;
        //     8: dup            
        //     9: invokespecial   java/util/HashMap.<init>:()V
        //    12: putfield        com/viaversion/viabackwards/protocol/protocol1_12_2to1_13/block_entity_handlers/PistonHandler.pistonIds:Ljava/util/Map;
        //    15: invokestatic    com/viaversion/viaversion/api/Via.getConfig:()Lcom/viaversion/viaversion/api/configuration/ViaVersionConfig;
        //    18: invokeinterface com/viaversion/viaversion/api/configuration/ViaVersionConfig.isServersideBlockConnections:()Z
        //    23: ifeq            139
        //    26: ldc             Lcom/viaversion/viaversion/protocols/protocol1_13to1_12_2/blockconnections/ConnectionData;.class
        //    28: ldc             "keyToId"
        //    30: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //    33: astore_2        /* llIIllIIllIlII */
        //    34: aload_2         /* llIIllIIllIlII */
        //    35: iconst_1       
        //    36: invokevirtual   java/lang/reflect/Field.setAccessible:(Z)V
        //    39: aload_2         /* llIIllIIllIlII */
        //    40: aconst_null    
        //    41: invokevirtual   java/lang/reflect/Field.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    44: checkcast       Ljava/util/Map;
        //    47: astore_1        /* llIIllIIllIIll */
        //    48: goto            57
        //    51: astore_2        /* llIIllIIllIIlI */
        //    52: aload_2         /* llIIllIIllIIlI */
        //    53: invokevirtual   java/lang/ReflectiveOperationException.printStackTrace:()V
        //    56: return         
        //    57: aload_1         /* llIIllIIllIIII */
        //    58: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
        //    63: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //    68: astore_2       
        //    69: aload_2        
        //    70: invokeinterface java/util/Iterator.hasNext:()Z
        //    75: ifeq            136
        //    78: aload_2        
        //    79: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    84: checkcast       Ljava/util/Map$Entry;
        //    87: astore_3        /* llIIllIIllIIIl */
        //    88: aload_3         /* llIIllIIllIIIl */
        //    89: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //    94: checkcast       Ljava/lang/String;
        //    97: ldc             "piston"
        //    99: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   102: ifne            108
        //   105: goto            69
        //   108: aload_0         /* llIIllIIlIlIll */
        //   109: aload_3         /* llIIllIIllIIIl */
        //   110: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   115: checkcast       Ljava/lang/String;
        //   118: aload_3         /* llIIllIIllIIIl */
        //   119: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   124: checkcast       Ljava/lang/Integer;
        //   127: invokevirtual   java/lang/Integer.intValue:()I
        //   130: invokespecial   com/viaversion/viabackwards/protocol/protocol1_12_2to1_13/block_entity_handlers/PistonHandler.addEntries:(Ljava/lang/String;I)V
        //   133: goto            69
        //   136: goto            235
        //   139: invokestatic    com/viaversion/viaversion/api/data/MappingDataLoader.getMappingsCache:()Ljava/util/Map;
        //   142: ldc             "mapping-1.13.json"
        //   144: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   149: checkcast       Lcom/viaversion/viaversion/libs/gson/JsonObject;
        //   152: ldc             "blockstates"
        //   154: invokevirtual   com/viaversion/viaversion/libs/gson/JsonObject.getAsJsonObject:(Ljava/lang/String;)Lcom/viaversion/viaversion/libs/gson/JsonObject;
        //   157: astore_1        /* llIIllIIlIllIl */
        //   158: aload_1         /* llIIllIIlIllIl */
        //   159: invokevirtual   com/viaversion/viaversion/libs/gson/JsonObject.entrySet:()Ljava/util/Set;
        //   162: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //   167: astore_2       
        //   168: aload_2        
        //   169: invokeinterface java/util/Iterator.hasNext:()Z
        //   174: ifeq            235
        //   177: aload_2        
        //   178: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   183: checkcast       Ljava/util/Map$Entry;
        //   186: astore_3        /* llIIllIIlIlllI */
        //   187: aload_3         /* llIIllIIlIlllI */
        //   188: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   193: checkcast       Lcom/viaversion/viaversion/libs/gson/JsonElement;
        //   196: invokevirtual   com/viaversion/viaversion/libs/gson/JsonElement.getAsString:()Ljava/lang/String;
        //   199: astore          llIIllIIlIllll
        //   201: aload           llIIllIIlIllll
        //   203: ldc             "piston"
        //   205: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   208: ifne            214
        //   211: goto            168
        //   214: aload_0         /* llIIllIIlIlIll */
        //   215: aload           llIIllIIlIllll
        //   217: aload_3         /* llIIllIIlIlllI */
        //   218: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   223: checkcast       Ljava/lang/String;
        //   226: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   229: invokespecial   com/viaversion/viabackwards/protocol/protocol1_12_2to1_13/block_entity_handlers/PistonHandler.addEntries:(Ljava/lang/String;I)V
        //   232: goto            168
        //   235: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                              
        //  -----  -----  -----  -----  ----------------------------------
        //  26     48     51     57     Ljava/lang/IllegalAccessException;
        //  26     48     51     57     Ljava/lang/NoSuchFieldException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void addEntries(String llIIllIIIllIIl, int llIIllIIIllIII) {
        llIIllIIIllIII = Protocol1_12_2To1_13.MAPPINGS.getNewBlockStateId(llIIllIIIllIII);
        this.pistonIds.put(llIIllIIIllIIl, llIIllIIIllIII);
        final String llIIllIIIlllIl = llIIllIIIllIIl.substring(10);
        if (!llIIllIIIlllIl.startsWith("piston") && !llIIllIIIlllIl.startsWith("sticky_piston")) {
            return;
        }
        final String[] llIIllIIIlllII = llIIllIIIllIIl.substring(0, llIIllIIIllIIl.length() - 1).split("\\[");
        final String[] llIIllIIIllIll = llIIllIIIlllII[1].split(",");
        llIIllIIIllIIl = String.valueOf(new StringBuilder().append(llIIllIIIlllII[0]).append("[").append(llIIllIIIllIll[1]).append(",").append(llIIllIIIllIll[0]).append("]"));
        this.pistonIds.put(llIIllIIIllIIl, llIIllIIIllIII);
    }
    
    @Override
    public CompoundTag transform(final UserConnection llIIllIIIIlllI, final int llIIllIIIIllIl, final CompoundTag llIIllIIIIllII) {
        final CompoundTag llIIllIIIIlIll = llIIllIIIIllII.get("blockState");
        if (llIIllIIIIlIll == null) {
            return llIIllIIIIllII;
        }
        final String llIIllIIIIlIlI = this.getDataFromTag(llIIllIIIIlIll);
        if (llIIllIIIIlIlI == null) {
            return llIIllIIIIllII;
        }
        final Integer llIIllIIIIlIIl = this.pistonIds.get(llIIllIIIIlIlI);
        if (llIIllIIIIlIIl == null) {
            return llIIllIIIIllII;
        }
        llIIllIIIIllII.put("blockId", new IntTag(llIIllIIIIlIIl >> 4));
        llIIllIIIIllII.put("blockData", new IntTag(llIIllIIIIlIIl & 0xF));
        return llIIllIIIIllII;
    }
    
    private String getDataFromTag(final CompoundTag llIIlIlllllIll) {
        final StringTag llIIlIlllllIlI = llIIlIlllllIll.get("Name");
        if (llIIlIlllllIlI == null) {
            return null;
        }
        final CompoundTag llIIlIlllllIIl = llIIlIlllllIll.get("Properties");
        if (llIIlIlllllIIl == null) {
            return llIIlIlllllIlI.getValue();
        }
        final StringJoiner llIIlIlllllIII = new StringJoiner(",", String.valueOf(new StringBuilder().append(llIIlIlllllIlI.getValue()).append("[")), "]");
        for (final Map.Entry<String, Tag> llIIlIllllllIl : llIIlIlllllIIl) {
            if (!(llIIlIllllllIl.getValue() instanceof StringTag)) {
                continue;
            }
            llIIlIlllllIII.add(String.valueOf(new StringBuilder().append(llIIlIllllllIl.getKey()).append("=").append(llIIlIllllllIl.getValue().getValue())));
        }
        return llIIlIlllllIII.toString();
    }
}
