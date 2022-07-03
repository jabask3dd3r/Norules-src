package net.minecraft.world.storage.loot.conditions;

import net.minecraft.util.*;
import com.google.common.collect.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.world.storage.loot.*;
import java.lang.reflect.*;
import com.google.gson.*;

public class LootConditionManager
{
    private static final /* synthetic */ Map<Class<? extends LootCondition>, LootCondition.Serializer<?>> CLASS_TO_SERIALIZER_MAP;
    private static final /* synthetic */ Map<ResourceLocation, LootCondition.Serializer<?>> NAME_TO_SERIALIZER_MAP;
    
    public static <T extends LootCondition> LootCondition.Serializer<T> getSerializerFor(final T lllllllllllllIlIlIIIIllIIllIIIll) {
        final LootCondition.Serializer<T> lllllllllllllIlIlIIIIllIIllIIIlI = (LootCondition.Serializer<T>)LootConditionManager.CLASS_TO_SERIALIZER_MAP.get(lllllllllllllIlIlIIIIllIIllIIIll.getClass());
        if (lllllllllllllIlIlIIIIllIIllIIIlI == null) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Unknown loot item condition ").append(lllllllllllllIlIlIIIIllIIllIIIll)));
        }
        return lllllllllllllIlIlIIIIllIIllIIIlI;
    }
    
    static {
        NAME_TO_SERIALIZER_MAP = Maps.newHashMap();
        CLASS_TO_SERIALIZER_MAP = Maps.newHashMap();
        registerCondition((LootCondition.Serializer<? extends LootCondition>)new RandomChance.Serializer());
        registerCondition((LootCondition.Serializer<? extends LootCondition>)new RandomChanceWithLooting.Serializer());
        registerCondition((LootCondition.Serializer<? extends LootCondition>)new EntityHasProperty.Serializer());
        registerCondition((LootCondition.Serializer<? extends LootCondition>)new KilledByPlayer.Serializer());
        registerCondition((LootCondition.Serializer<? extends LootCondition>)new EntityHasScore.Serializer());
    }
    
    public static LootCondition.Serializer<?> getSerializerForName(final ResourceLocation lllllllllllllIlIlIIIIllIIllIlIIl) {
        final LootCondition.Serializer<?> lllllllllllllIlIlIIIIllIIllIlIII = LootConditionManager.NAME_TO_SERIALIZER_MAP.get(lllllllllllllIlIlIIIIllIIllIlIIl);
        if (lllllllllllllIlIlIIIIllIIllIlIII == null) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Unknown loot item condition '").append(lllllllllllllIlIlIIIIllIIllIlIIl).append("'")));
        }
        return lllllllllllllIlIlIIIIllIIllIlIII;
    }
    
    public static boolean testAllConditions(@Nullable final LootCondition[] lllllllllllllIlIlIIIIllIIlllIIlI, final Random lllllllllllllIlIlIIIIllIIlllIIIl, final LootContext lllllllllllllIlIlIIIIllIIlllIlII) {
        if (lllllllllllllIlIlIIIIllIIlllIIlI == null) {
            return true;
        }
        final char lllllllllllllIlIlIIIIllIIllIllII = (Object)lllllllllllllIlIlIIIIllIIlllIIlI;
        final short lllllllllllllIlIlIIIIllIIllIllIl = (short)lllllllllllllIlIlIIIIllIIlllIIlI.length;
        for (String lllllllllllllIlIlIIIIllIIllIlllI = (String)0; lllllllllllllIlIlIIIIllIIllIlllI < lllllllllllllIlIlIIIIllIIllIllIl; ++lllllllllllllIlIlIIIIllIIllIlllI) {
            final LootCondition lllllllllllllIlIlIIIIllIIlllIIll = lllllllllllllIlIlIIIIllIIllIllII[lllllllllllllIlIlIIIIllIIllIlllI];
            if (!lllllllllllllIlIlIIIIllIIlllIIll.testCondition(lllllllllllllIlIlIIIIllIIlllIIIl, lllllllllllllIlIlIIIIllIIlllIlII)) {
                return false;
            }
        }
        return true;
    }
    
    public static <T extends LootCondition> void registerCondition(final LootCondition.Serializer<? extends T> lllllllllllllIlIlIIIIllIlIIIIIll) {
        final ResourceLocation lllllllllllllIlIlIIIIllIlIIIIIlI = lllllllllllllIlIlIIIIllIlIIIIIll.getLootTableLocation();
        final Class<T> lllllllllllllIlIlIIIIllIlIIIIIIl = (Class<T>)lllllllllllllIlIlIIIIllIlIIIIIll.getConditionClass();
        if (LootConditionManager.NAME_TO_SERIALIZER_MAP.containsKey(lllllllllllllIlIlIIIIllIlIIIIIlI)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Can't re-register item condition name ").append(lllllllllllllIlIlIIIIllIlIIIIIlI)));
        }
        if (LootConditionManager.CLASS_TO_SERIALIZER_MAP.containsKey(lllllllllllllIlIlIIIIllIlIIIIIIl)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Can't re-register item condition class ").append(lllllllllllllIlIlIIIIllIlIIIIIIl.getName())));
        }
        LootConditionManager.NAME_TO_SERIALIZER_MAP.put(lllllllllllllIlIlIIIIllIlIIIIIlI, lllllllllllllIlIlIIIIllIlIIIIIll);
        LootConditionManager.CLASS_TO_SERIALIZER_MAP.put(lllllllllllllIlIlIIIIllIlIIIIIIl, lllllllllllllIlIlIIIIllIlIIIIIll);
    }
    
    public static class Serializer implements JsonDeserializer<LootCondition>, JsonSerializer<LootCondition>
    {
        public JsonElement serialize(final LootCondition llllllllllllllIIIlIIIIIlIlIlllII, final Type llllllllllllllIIIlIIIIIlIllIIIII, final JsonSerializationContext llllllllllllllIIIlIIIIIlIlIllIll) {
            final LootCondition.Serializer<LootCondition> llllllllllllllIIIlIIIIIlIlIllllI = LootConditionManager.getSerializerFor(llllllllllllllIIIlIIIIIlIlIlllII);
            final JsonObject llllllllllllllIIIlIIIIIlIlIlllIl = new JsonObject();
            llllllllllllllIIIlIIIIIlIlIllllI.serialize(llllllllllllllIIIlIIIIIlIlIlllIl, llllllllllllllIIIlIIIIIlIlIlllII, llllllllllllllIIIlIIIIIlIlIllIll);
            llllllllllllllIIIlIIIIIlIlIlllIl.addProperty("condition", llllllllllllllIIIlIIIIIlIlIllllI.getLootTableLocation().toString());
            return (JsonElement)llllllllllllllIIIlIIIIIlIlIlllIl;
        }
        
        public LootCondition deserialize(final JsonElement llllllllllllllIIIlIIIIIlIllIllII, final Type llllllllllllllIIIlIIIIIlIlllIIll, final JsonDeserializationContext llllllllllllllIIIlIIIIIlIllIlIll) throws JsonParseException {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: ldc             "condition"
            //     3: invokestatic    net/minecraft/util/JsonUtils.getJsonObject:(Lcom/google/gson/JsonElement;Ljava/lang/String;)Lcom/google/gson/JsonObject;
            //     6: astore          llllllllllllllIIIlIIIIIlIlllIIIl
            //     8: new             Lnet/minecraft/util/ResourceLocation;
            //    11: dup            
            //    12: aload           llllllllllllllIIIlIIIIIlIlllIIIl
            //    14: ldc             "condition"
            //    16: invokestatic    net/minecraft/util/JsonUtils.getString:(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
            //    19: invokespecial   net/minecraft/util/ResourceLocation.<init>:(Ljava/lang/String;)V
            //    22: astore          llllllllllllllIIIlIIIIIlIlllIIII
            //    24: aload           llllllllllllllIIIlIIIIIlIlllIIII
            //    26: invokestatic    net/minecraft/world/storage/loot/conditions/LootConditionManager.getSerializerForName:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/world/storage/loot/conditions/LootCondition$Serializer;
            //    29: astore          llllllllllllllIIIlIIIIIlIllIllll
            //    31: goto            66
            //    34: astore          llllllllllllllIIIlIIIIIlIllIllIl
            //    36: new             Lcom/google/gson/JsonSyntaxException;
            //    39: dup            
            //    40: new             Ljava/lang/StringBuilder;
            //    43: dup            
            //    44: ldc             "Unknown condition '"
            //    46: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
            //    49: aload           llllllllllllllIIIlIIIIIlIlllIIII
            //    51: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //    54: ldc             "'"
            //    56: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    59: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
            //    62: invokespecial   com/google/gson/JsonSyntaxException.<init>:(Ljava/lang/String;)V
            //    65: athrow         
            //    66: aload           llllllllllllllIIIlIIIIIlIllIlllI
            //    68: aload           llllllllllllllIIIlIIIIIlIlllIIIl
            //    70: aload_3         /* llllllllllllllIIIlIIIIIlIlllIIlI */
            //    71: invokevirtual   net/minecraft/world/storage/loot/conditions/LootCondition$Serializer.deserialize:(Lcom/google/gson/JsonObject;Lcom/google/gson/JsonDeserializationContext;)Lnet/minecraft/world/storage/loot/conditions/LootCondition;
            //    74: areturn        
            //    Exceptions:
            //  throws com.google.gson.JsonParseException
            //    StackMapTable: 00 02 FF 00 22 00 06 07 00 02 07 00 8E 07 00 90 07 00 92 07 00 1A 07 00 28 00 01 07 00 4B FC 00 1F 07 00 0B
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
