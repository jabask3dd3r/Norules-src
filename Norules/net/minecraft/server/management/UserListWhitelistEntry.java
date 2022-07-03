package net.minecraft.server.management;

import com.mojang.authlib.*;
import com.google.gson.*;

public class UserListWhitelistEntry extends UserListEntry<GameProfile>
{
    private static GameProfile gameProfileFromJsonObject(final JsonObject lllllllllllllIllIlIlllllIllIllII) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "uuid"
        //     3: invokevirtual   com/google/gson/JsonObject.has:(Ljava/lang/String;)Z
        //     6: ifeq            57
        //     9: aload_0         /* lllllllllllllIllIlIlllllIlllIIIl */
        //    10: ldc             "name"
        //    12: invokevirtual   com/google/gson/JsonObject.has:(Ljava/lang/String;)Z
        //    15: ifeq            57
        //    18: aload_0         /* lllllllllllllIllIlIlllllIlllIIIl */
        //    19: ldc             "uuid"
        //    21: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
        //    24: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
        //    27: astore_1        /* lllllllllllllIllIlIlllllIllIlIll */
        //    28: aload_1         /* lllllllllllllIllIlIlllllIlllIIII */
        //    29: invokestatic    java/util/UUID.fromString:(Ljava/lang/String;)Ljava/util/UUID;
        //    32: astore_2        /* lllllllllllllIllIlIlllllIllIllll */
        //    33: goto            39
        //    36: astore_3        /* lllllllllllllIllIlIlllllIllIllIl */
        //    37: aconst_null    
        //    38: areturn        
        //    39: new             Lcom/mojang/authlib/GameProfile;
        //    42: dup            
        //    43: aload_2         /* lllllllllllllIllIlIlllllIllIlllI */
        //    44: aload_0         /* lllllllllllllIllIlIlllllIlllIIIl */
        //    45: ldc             "name"
        //    47: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
        //    50: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
        //    53: invokespecial   com/mojang/authlib/GameProfile.<init>:(Ljava/util/UUID;Ljava/lang/String;)V
        //    56: areturn        
        //    57: aconst_null    
        //    58: areturn        
        //    StackMapTable: 00 03 FF 00 24 00 02 07 00 0D 07 00 3C 00 01 07 00 09 FC 00 02 07 00 1F F9 00 11
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  28     33     36     39     Ljava/lang/Throwable;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public UserListWhitelistEntry(final GameProfile lllllllllllllIllIlIllllllIIIIIlI) {
        super(lllllllllllllIllIlIllllllIIIIIlI);
    }
    
    @Override
    protected void onSerialization(final JsonObject lllllllllllllIllIlIlllllIllllIII) {
        if (this.getValue() != null) {
            lllllllllllllIllIlIlllllIllllIII.addProperty("uuid", (this.getValue().getId() == null) ? "" : this.getValue().getId().toString());
            lllllllllllllIllIlIlllllIllllIII.addProperty("name", this.getValue().getName());
            super.onSerialization(lllllllllllllIllIlIlllllIllllIII);
        }
    }
    
    public UserListWhitelistEntry(final JsonObject lllllllllllllIllIlIlllllIllllllI) {
        super(gameProfileFromJsonObject(lllllllllllllIllIlIlllllIllllllI), lllllllllllllIllIlIlllllIllllllI);
    }
}
