package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.data;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.libs.gson.*;

public class ComponentRewriter1_13 extends ComponentRewriter
{
    public ComponentRewriter1_13() {
        super(Via.getManager().getProtocolManager().getProtocol(Protocol1_13To1_12_2.class));
    }
    
    @Override
    protected void handleTranslate(final JsonObject lllllllllllllIllIIlllIlIIlIlIlII, final String lllllllllllllIllIIlllIlIIlIlIIll) {
        super.handleTranslate(lllllllllllllIllIIlllIlIIlIlIlII, lllllllllllllIllIIlllIlIIlIlIIll);
        String lllllllllllllIllIIlllIlIIlIlIllI = Protocol1_13To1_12_2.MAPPINGS.getTranslateMapping().get(lllllllllllllIllIIlllIlIIlIlIIll);
        if (lllllllllllllIllIIlllIlIIlIlIllI == null) {
            lllllllllllllIllIIlllIlIIlIlIllI = Protocol1_13To1_12_2.MAPPINGS.getMojangTranslation().get(lllllllllllllIllIIlllIlIIlIlIIll);
        }
        if (lllllllllllllIllIIlllIlIIlIlIllI != null) {
            lllllllllllllIllIIlllIlIIlIlIlII.addProperty("translate", lllllllllllllIllIIlllIlIIlIlIllI);
        }
    }
    
    @Override
    protected void handleHoverEvent(final JsonObject lllllllllllllIllIIlllIlIIllllIIl) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1         /* lllllllllllllIllIIlllIlIlIIIIlIl */
        //     2: invokespecial   com/viaversion/viaversion/rewriter/ComponentRewriter.handleHoverEvent:(Lcom/viaversion/viaversion/libs/gson/JsonObject;)V
        //     5: aload_1         /* lllllllllllllIllIIlllIlIlIIIIlIl */
        //     6: ldc             "action"
        //     8: invokevirtual   com/viaversion/viaversion/libs/gson/JsonObject.getAsJsonPrimitive:(Ljava/lang/String;)Lcom/viaversion/viaversion/libs/gson/JsonPrimitive;
        //    11: invokevirtual   com/viaversion/viaversion/libs/gson/JsonPrimitive.getAsString:()Ljava/lang/String;
        //    14: astore_2        /* lllllllllllllIllIIlllIlIIllllIII */
        //    15: aload_2         /* lllllllllllllIllIIlllIlIlIIIIlII */
        //    16: ldc             "show_item"
        //    18: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    21: ifne            25
        //    24: return         
        //    25: aload_1         /* lllllllllllllIllIIlllIlIlIIIIlIl */
        //    26: ldc             "value"
        //    28: invokevirtual   com/viaversion/viaversion/libs/gson/JsonObject.get:(Ljava/lang/String;)Lcom/viaversion/viaversion/libs/gson/JsonElement;
        //    31: astore_3        /* lllllllllllllIllIIlllIlIIlllIlll */
        //    32: aload_3         /* lllllllllllllIllIIlllIlIlIIIIIll */
        //    33: ifnonnull       37
        //    36: return         
        //    37: aload_0         /* lllllllllllllIllIIlllIlIIllllIlI */
        //    38: aload_3         /* lllllllllllllIllIIlllIlIlIIIIIll */
        //    39: invokevirtual   com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/ComponentRewriter1_13.findItemNBT:(Lcom/viaversion/viaversion/libs/gson/JsonElement;)Ljava/lang/String;
        //    42: astore          lllllllllllllIllIIlllIlIlIIIIIlI
        //    44: aload           lllllllllllllIllIIlllIlIlIIIIIlI
        //    46: ifnonnull       50
        //    49: return         
        //    50: aload           lllllllllllllIllIIlllIlIlIIIIIlI
        //    52: invokestatic    com/viaversion/viaversion/api/minecraft/nbt/BinaryTagIO.readString:(Ljava/lang/String;)Lcom/viaversion/viaversion/libs/opennbt/tag/builtin/CompoundTag;
        //    55: astore          lllllllllllllIllIIlllIlIlIIIlIlI
        //    57: goto            121
        //    60: astore          lllllllllllllIllIIlllIlIlIIIlIIl
        //    62: invokestatic    com/viaversion/viaversion/api/Via.getConfig:()Lcom/viaversion/viaversion/api/configuration/ViaVersionConfig;
        //    65: invokeinterface com/viaversion/viaversion/api/configuration/ViaVersionConfig.isSuppressConversionWarnings:()Z
        //    70: ifeq            84
        //    73: invokestatic    com/viaversion/viaversion/api/Via.getManager:()Lcom/viaversion/viaversion/api/ViaManager;
        //    76: invokeinterface com/viaversion/viaversion/api/ViaManager.isDebug:()Z
        //    81: ifeq            120
        //    84: invokestatic    com/viaversion/viaversion/api/Via.getPlatform:()Lcom/viaversion/viaversion/api/platform/ViaPlatform;
        //    87: invokeinterface com/viaversion/viaversion/api/platform/ViaPlatform.getLogger:()Ljava/util/logging/Logger;
        //    92: new             Ljava/lang/StringBuilder;
        //    95: dup            
        //    96: invokespecial   java/lang/StringBuilder.<init>:()V
        //    99: ldc             "Error reading NBT in show_item:"
        //   101: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   104: aload           lllllllllllllIllIIlllIlIlIIIIIlI
        //   106: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   109: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   112: invokevirtual   java/util/logging/Logger.warning:(Ljava/lang/String;)V
        //   115: aload           lllllllllllllIllIIlllIlIlIIIlIIl
        //   117: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   120: return         
        //   121: aload           lllllllllllllIllIIlllIlIlIIIIIIl
        //   123: ldc             "tag"
        //   125: invokevirtual   com/viaversion/viaversion/libs/opennbt/tag/builtin/CompoundTag.get:(Ljava/lang/String;)Lcom/viaversion/viaversion/libs/opennbt/tag/builtin/Tag;
        //   128: checkcast       Lcom/viaversion/viaversion/libs/opennbt/tag/builtin/CompoundTag;
        //   131: astore          lllllllllllllIllIIlllIlIlIIIIIII
        //   133: aload           lllllllllllllIllIIlllIlIlIIIIIIl
        //   135: ldc             "Damage"
        //   137: invokevirtual   com/viaversion/viaversion/libs/opennbt/tag/builtin/CompoundTag.get:(Ljava/lang/String;)Lcom/viaversion/viaversion/libs/opennbt/tag/builtin/Tag;
        //   140: checkcast       Lcom/viaversion/viaversion/libs/opennbt/tag/builtin/ShortTag;
        //   143: astore          lllllllllllllIllIIlllIlIIlllllll
        //   145: aload           lllllllllllllIllIIlllIlIIlllllll
        //   147: ifnull          158
        //   150: aload           lllllllllllllIllIIlllIlIIlllllll
        //   152: invokevirtual   com/viaversion/viaversion/libs/opennbt/tag/builtin/ShortTag.asShort:()S
        //   155: goto            159
        //   158: iconst_0       
        //   159: istore          lllllllllllllIllIIlllIlIIllllllI
        //   161: new             Lcom/viaversion/viaversion/api/minecraft/item/DataItem;
        //   164: dup            
        //   165: invokespecial   com/viaversion/viaversion/api/minecraft/item/DataItem.<init>:()V
        //   168: astore          lllllllllllllIllIIlllIlIIlllllIl
        //   170: aload           lllllllllllllIllIIlllIlIIlllllIl
        //   172: iload           lllllllllllllIllIIlllIlIIllllllI
        //   174: invokeinterface com/viaversion/viaversion/api/minecraft/item/Item.setData:(S)V
        //   179: aload           lllllllllllllIllIIlllIlIIlllllIl
        //   181: aload           lllllllllllllIllIIlllIlIlIIIIIII
        //   183: invokeinterface com/viaversion/viaversion/api/minecraft/item/Item.setTag:(Lcom/viaversion/viaversion/libs/opennbt/tag/builtin/CompoundTag;)V
        //   188: aload_0         /* lllllllllllllIllIIlllIlIIllllIlI */
        //   189: getfield        com/viaversion/viaversion/protocols/protocol1_13to1_12_2/data/ComponentRewriter1_13.protocol:Lcom/viaversion/viaversion/api/protocol/Protocol;
        //   192: invokeinterface com/viaversion/viaversion/api/protocol/Protocol.getItemRewriter:()Lcom/viaversion/viaversion/api/rewriter/ItemRewriter;
        //   197: aload           lllllllllllllIllIIlllIlIIlllllIl
        //   199: invokeinterface com/viaversion/viaversion/api/rewriter/ItemRewriter.handleItemToClient:(Lcom/viaversion/viaversion/api/minecraft/item/Item;)Lcom/viaversion/viaversion/api/minecraft/item/Item;
        //   204: pop            
        //   205: iload           lllllllllllllIllIIlllIlIIllllllI
        //   207: aload           lllllllllllllIllIIlllIlIIlllllIl
        //   209: invokeinterface com/viaversion/viaversion/api/minecraft/item/Item.data:()S
        //   214: if_icmpeq       239
        //   217: aload           lllllllllllllIllIIlllIlIlIIIIIIl
        //   219: ldc             "Damage"
        //   221: new             Lcom/viaversion/viaversion/libs/opennbt/tag/builtin/ShortTag;
        //   224: dup            
        //   225: aload           lllllllllllllIllIIlllIlIIlllllIl
        //   227: invokeinterface com/viaversion/viaversion/api/minecraft/item/Item.data:()S
        //   232: invokespecial   com/viaversion/viaversion/libs/opennbt/tag/builtin/ShortTag.<init>:(S)V
        //   235: invokevirtual   com/viaversion/viaversion/libs/opennbt/tag/builtin/CompoundTag.put:(Ljava/lang/String;Lcom/viaversion/viaversion/libs/opennbt/tag/builtin/Tag;)Lcom/viaversion/viaversion/libs/opennbt/tag/builtin/Tag;
        //   238: pop            
        //   239: aload           lllllllllllllIllIIlllIlIlIIIIIII
        //   241: ifnull          254
        //   244: aload           lllllllllllllIllIIlllIlIlIIIIIIl
        //   246: ldc             "tag"
        //   248: aload           lllllllllllllIllIIlllIlIlIIIIIII
        //   250: invokevirtual   com/viaversion/viaversion/libs/opennbt/tag/builtin/CompoundTag.put:(Ljava/lang/String;Lcom/viaversion/viaversion/libs/opennbt/tag/builtin/Tag;)Lcom/viaversion/viaversion/libs/opennbt/tag/builtin/Tag;
        //   253: pop            
        //   254: new             Lcom/viaversion/viaversion/libs/gson/JsonArray;
        //   257: dup            
        //   258: invokespecial   com/viaversion/viaversion/libs/gson/JsonArray.<init>:()V
        //   261: astore          lllllllllllllIllIIlllIlIIlllllII
        //   263: new             Lcom/viaversion/viaversion/libs/gson/JsonObject;
        //   266: dup            
        //   267: invokespecial   com/viaversion/viaversion/libs/gson/JsonObject.<init>:()V
        //   270: astore          lllllllllllllIllIIlllIlIIllllIll
        //   272: aload           lllllllllllllIllIIlllIlIIlllllII
        //   274: aload           lllllllllllllIllIIlllIlIIllllIll
        //   276: invokevirtual   com/viaversion/viaversion/libs/gson/JsonArray.add:(Lcom/viaversion/viaversion/libs/gson/JsonElement;)V
        //   279: aload           lllllllllllllIllIIlllIlIlIIIIIIl
        //   281: invokestatic    com/viaversion/viaversion/api/minecraft/nbt/BinaryTagIO.writeString:(Lcom/viaversion/viaversion/libs/opennbt/tag/builtin/CompoundTag;)Ljava/lang/String;
        //   284: astore          lllllllllllllIllIIlllIlIlIIIlIII
        //   286: aload           lllllllllllllIllIIlllIlIIllllIll
        //   288: ldc             "text"
        //   290: aload           lllllllllllllIllIIlllIlIlIIIlIII
        //   292: invokevirtual   com/viaversion/viaversion/libs/gson/JsonObject.addProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   295: aload_1         /* lllllllllllllIllIIlllIlIlIIIIlIl */
        //   296: ldc             "value"
        //   298: aload           lllllllllllllIllIIlllIlIIlllllII
        //   300: invokevirtual   com/viaversion/viaversion/libs/gson/JsonObject.add:(Ljava/lang/String;Lcom/viaversion/viaversion/libs/gson/JsonElement;)V
        //   303: goto            344
        //   306: astore          lllllllllllllIllIIlllIlIlIIIIlll
        //   308: invokestatic    com/viaversion/viaversion/api/Via.getPlatform:()Lcom/viaversion/viaversion/api/platform/ViaPlatform;
        //   311: invokeinterface com/viaversion/viaversion/api/platform/ViaPlatform.getLogger:()Ljava/util/logging/Logger;
        //   316: new             Ljava/lang/StringBuilder;
        //   319: dup            
        //   320: invokespecial   java/lang/StringBuilder.<init>:()V
        //   323: ldc             "Error writing NBT in show_item:"
        //   325: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   328: aload           lllllllllllllIllIIlllIlIlIIIIIlI
        //   330: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   333: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   336: invokevirtual   java/util/logging/Logger.warning:(Ljava/lang/String;)V
        //   339: aload           lllllllllllllIllIIlllIlIlIIIIlll
        //   341: invokevirtual   java/io/IOException.printStackTrace:()V
        //   344: return         
        //    StackMapTable: 00 0D FC 00 19 07 00 37 FC 00 0B 07 01 1A FC 00 0C 07 00 37 49 07 00 53 FD 00 17 00 07 00 53 23 FF 00 00 00 06 07 00 02 07 00 3E 07 00 37 07 01 1A 07 00 37 07 00 AA 00 00 FD 00 24 07 00 AA 07 00 B1 40 01 FD 00 4F 01 07 00 B7 0E FF 00 33 00 0C 07 00 02 07 00 3E 07 00 37 07 01 1A 07 00 37 07 00 AA 07 00 AA 07 00 B1 01 07 00 B7 07 00 DD 07 00 3E 00 01 07 00 55 25
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  50     57     60     121    Ljava/lang/Exception;
        //  279    303    306    344    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public ComponentRewriter1_13(final Protocol lllllllllllllIllIIlllIlIlIIllllI) {
        super(lllllllllllllIllIIlllIlIlIIllllI);
    }
    
    protected String findItemNBT(final JsonElement lllllllllllllIllIIlllIlIIllIIIll) {
        if (lllllllllllllIllIIlllIlIIllIIIll.isJsonArray()) {
            for (final JsonElement lllllllllllllIllIIlllIlIIllIIllI : lllllllllllllIllIIlllIlIIllIIIll.getAsJsonArray()) {
                final String lllllllllllllIllIIlllIlIIllIIlll = this.findItemNBT(lllllllllllllIllIIlllIlIIllIIllI);
                if (lllllllllllllIllIIlllIlIIllIIlll != null) {
                    return lllllllllllllIllIIlllIlIIllIIlll;
                }
            }
        }
        else if (lllllllllllllIllIIlllIlIIllIIIll.isJsonObject()) {
            final JsonPrimitive lllllllllllllIllIIlllIlIIllIIlIl = lllllllllllllIllIIlllIlIIllIIIll.getAsJsonObject().getAsJsonPrimitive("text");
            if (lllllllllllllIllIIlllIlIIllIIlIl != null) {
                return lllllllllllllIllIIlllIlIIllIIlIl.getAsString();
            }
        }
        else if (lllllllllllllIllIIlllIlIIllIIIll.isJsonPrimitive()) {
            return lllllllllllllIllIIlllIlIIllIIIll.getAsJsonPrimitive().getAsString();
        }
        return null;
    }
}
