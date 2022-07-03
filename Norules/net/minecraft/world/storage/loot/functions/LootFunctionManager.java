package net.minecraft.world.storage.loot.functions;

import java.util.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import java.lang.reflect.*;
import com.google.gson.*;

public class LootFunctionManager
{
    private static final /* synthetic */ Map<Class<? extends LootFunction>, LootFunction.Serializer<?>> CLASS_TO_SERIALIZER_MAP;
    private static final /* synthetic */ Map<ResourceLocation, LootFunction.Serializer<?>> NAME_TO_SERIALIZER_MAP;
    
    public static <T extends LootFunction> void registerFunction(final LootFunction.Serializer<? extends T> lllllllllllllIIlIlIlIIIlIIIllllI) {
        final ResourceLocation lllllllllllllIIlIlIlIIIlIIIlllIl = lllllllllllllIIlIlIlIIIlIIIllllI.getFunctionName();
        final Class<T> lllllllllllllIIlIlIlIIIlIIIlllII = (Class<T>)lllllllllllllIIlIlIlIIIlIIIllllI.getFunctionClass();
        if (LootFunctionManager.NAME_TO_SERIALIZER_MAP.containsKey(lllllllllllllIIlIlIlIIIlIIIlllIl)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Can't re-register item function name ").append(lllllllllllllIIlIlIlIIIlIIIlllIl)));
        }
        if (LootFunctionManager.CLASS_TO_SERIALIZER_MAP.containsKey(lllllllllllllIIlIlIlIIIlIIIlllII)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Can't re-register item function class ").append(lllllllllllllIIlIlIlIIIlIIIlllII.getName())));
        }
        LootFunctionManager.NAME_TO_SERIALIZER_MAP.put(lllllllllllllIIlIlIlIIIlIIIlllIl, lllllllllllllIIlIlIlIIIlIIIllllI);
        LootFunctionManager.CLASS_TO_SERIALIZER_MAP.put(lllllllllllllIIlIlIlIIIlIIIlllII, lllllllllllllIIlIlIlIIIlIIIllllI);
    }
    
    static {
        NAME_TO_SERIALIZER_MAP = Maps.newHashMap();
        CLASS_TO_SERIALIZER_MAP = Maps.newHashMap();
        registerFunction((LootFunction.Serializer<? extends LootFunction>)new SetCount.Serializer());
        registerFunction((LootFunction.Serializer<? extends LootFunction>)new SetMetadata.Serializer());
        registerFunction((LootFunction.Serializer<? extends LootFunction>)new EnchantWithLevels.Serializer());
        registerFunction((LootFunction.Serializer<? extends LootFunction>)new EnchantRandomly.Serializer());
        registerFunction((LootFunction.Serializer<? extends LootFunction>)new SetNBT.Serializer());
        registerFunction((LootFunction.Serializer<? extends LootFunction>)new Smelt.Serializer());
        registerFunction((LootFunction.Serializer<? extends LootFunction>)new LootingEnchantBonus.Serializer());
        registerFunction((LootFunction.Serializer<? extends LootFunction>)new SetDamage.Serializer());
        registerFunction((LootFunction.Serializer<? extends LootFunction>)new SetAttributes.Serializer());
    }
    
    public static LootFunction.Serializer<?> getSerializerForName(final ResourceLocation lllllllllllllIIlIlIlIIIlIIIlIlII) {
        final LootFunction.Serializer<?> lllllllllllllIIlIlIlIIIlIIIlIlIl = LootFunctionManager.NAME_TO_SERIALIZER_MAP.get(lllllllllllllIIlIlIlIIIlIIIlIlII);
        if (lllllllllllllIIlIlIlIIIlIIIlIlIl == null) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Unknown loot item function '").append(lllllllllllllIIlIlIlIIIlIIIlIlII).append("'")));
        }
        return lllllllllllllIIlIlIlIIIlIIIlIlIl;
    }
    
    public static <T extends LootFunction> LootFunction.Serializer<T> getSerializerFor(final T lllllllllllllIIlIlIlIIIlIIIlIIII) {
        final LootFunction.Serializer<T> lllllllllllllIIlIlIlIIIlIIIIllll = (LootFunction.Serializer<T>)LootFunctionManager.CLASS_TO_SERIALIZER_MAP.get(lllllllllllllIIlIlIlIIIlIIIlIIII.getClass());
        if (lllllllllllllIIlIlIlIIIlIIIIllll == null) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Unknown loot item function ").append(lllllllllllllIIlIlIlIIIlIIIlIIII)));
        }
        return lllllllllllllIIlIlIlIIIlIIIIllll;
    }
    
    public static class Serializer implements JsonDeserializer<LootFunction>, JsonSerializer<LootFunction>
    {
        public JsonElement serialize(final LootFunction llllllllllllllIIllIIIIlIIIlIIIII, final Type llllllllllllllIIllIIIIlIIIlIIlII, final JsonSerializationContext llllllllllllllIIllIIIIlIIIlIIIll) {
            final LootFunction.Serializer<LootFunction> llllllllllllllIIllIIIIlIIIlIIIlI = LootFunctionManager.getSerializerFor(llllllllllllllIIllIIIIlIIIlIIIII);
            final JsonObject llllllllllllllIIllIIIIlIIIlIIIIl = new JsonObject();
            llllllllllllllIIllIIIIlIIIlIIIlI.serialize(llllllllllllllIIllIIIIlIIIlIIIIl, llllllllllllllIIllIIIIlIIIlIIIII, llllllllllllllIIllIIIIlIIIlIIIll);
            llllllllllllllIIllIIIIlIIIlIIIIl.addProperty("function", llllllllllllllIIllIIIIlIIIlIIIlI.getFunctionName().toString());
            if (llllllllllllllIIllIIIIlIIIlIIIII.getConditions() != null && llllllllllllllIIllIIIIlIIIlIIIII.getConditions().length > 0) {
                llllllllllllllIIllIIIIlIIIlIIIIl.add("conditions", llllllllllllllIIllIIIIlIIIlIIIll.serialize((Object)llllllllllllllIIllIIIIlIIIlIIIII.getConditions()));
            }
            return (JsonElement)llllllllllllllIIllIIIIlIIIlIIIIl;
        }
        
        public LootFunction deserialize(final JsonElement llllllllllllllIIllIIIIlIIIlllIII, final Type llllllllllllllIIllIIIIlIIIllIlll, final JsonDeserializationContext llllllllllllllIIllIIIIlIIIllIllI) throws JsonParseException {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: ldc             "function"
            //     3: invokestatic    net/minecraft/util/JsonUtils.getJsonObject:(Lcom/google/gson/JsonElement;Ljava/lang/String;)Lcom/google/gson/JsonObject;
            //     6: astore          llllllllllllllIIllIIIIlIIIllIlIl
            //     8: new             Lnet/minecraft/util/ResourceLocation;
            //    11: dup            
            //    12: aload           llllllllllllllIIllIIIIlIIIllIlIl
            //    14: ldc             "function"
            //    16: invokestatic    net/minecraft/util/JsonUtils.getString:(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
            //    19: invokespecial   net/minecraft/util/ResourceLocation.<init>:(Ljava/lang/String;)V
            //    22: astore          llllllllllllllIIllIIIIlIIIllIlII
            //    24: aload           llllllllllllllIIllIIIIlIIIllIlII
            //    26: invokestatic    net/minecraft/world/storage/loot/functions/LootFunctionManager.getSerializerForName:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/world/storage/loot/functions/LootFunction$Serializer;
            //    29: astore          llllllllllllllIIllIIIIlIIIllIIll
            //    31: goto            66
            //    34: astore          llllllllllllllIIllIIIIlIIIllIIIl
            //    36: new             Lcom/google/gson/JsonSyntaxException;
            //    39: dup            
            //    40: new             Ljava/lang/StringBuilder;
            //    43: dup            
            //    44: ldc             "Unknown function '"
            //    46: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
            //    49: aload           llllllllllllllIIllIIIIlIIIllIlII
            //    51: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //    54: ldc             "'"
            //    56: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    59: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
            //    62: invokespecial   com/google/gson/JsonSyntaxException.<init>:(Ljava/lang/String;)V
            //    65: athrow         
            //    66: aload           llllllllllllllIIllIIIIlIIIllIIlI
            //    68: aload           llllllllllllllIIllIIIIlIIIllIlIl
            //    70: aload_3         /* llllllllllllllIIllIIIIlIIIlIllll */
            //    71: aload           llllllllllllllIIllIIIIlIIIllIlIl
            //    73: ldc             "conditions"
            //    75: iconst_0       
            //    76: anewarray       Lnet/minecraft/world/storage/loot/conditions/LootCondition;
            //    79: aload_3         /* llllllllllllllIIllIIIIlIIIlIllll */
            //    80: ldc             [Lnet/minecraft/world/storage/loot/conditions/LootCondition;.class
            //    82: invokestatic    net/minecraft/util/JsonUtils.deserializeClass:(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/Object;Lcom/google/gson/JsonDeserializationContext;Ljava/lang/Class;)Ljava/lang/Object;
            //    85: checkcast       [Lnet/minecraft/world/storage/loot/conditions/LootCondition;
            //    88: invokevirtual   net/minecraft/world/storage/loot/functions/LootFunction$Serializer.deserialize:(Lcom/google/gson/JsonObject;Lcom/google/gson/JsonDeserializationContext;[Lnet/minecraft/world/storage/loot/conditions/LootCondition;)Lnet/minecraft/world/storage/loot/functions/LootFunction;
            //    91: areturn        
            //    Exceptions:
            //  throws com.google.gson.JsonParseException
            //    StackMapTable: 00 02 FF 00 22 00 06 07 00 02 07 00 B7 07 00 B9 07 00 BB 07 00 27 07 00 36 00 01 07 00 6E FC 00 1F 07 00 0B
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                                
            //  -----  -----  -----  -----  ------------------------------------
            //  24     31     34     66     Ljava/lang/IllegalArgumentException;
            // 
            // The error that occurred was:
            // 
            // java.lang.NullPointerException
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
    }
}
