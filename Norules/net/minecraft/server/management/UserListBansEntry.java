package net.minecraft.server.management;

import com.mojang.authlib.*;
import com.google.gson.*;
import java.util.*;

public class UserListBansEntry extends UserListEntryBan<GameProfile>
{
    @Override
    protected void onSerialization(final JsonObject lllllllllllllIIlIlIlIIllIllIlIll) {
        if (this.getValue() != null) {
            lllllllllllllIIlIlIlIIllIllIlIll.addProperty("uuid", (this.getValue().getId() == null) ? "" : this.getValue().getId().toString());
            lllllllllllllIIlIlIlIIllIllIlIll.addProperty("name", this.getValue().getName());
            super.onSerialization(lllllllllllllIIlIlIlIIllIllIlIll);
        }
    }
    
    public UserListBansEntry(final GameProfile lllllllllllllIIlIlIlIIllIllllIlI, final Date lllllllllllllIIlIlIlIIllIlllllll, final String lllllllllllllIIlIlIlIIllIllllIIl, final Date lllllllllllllIIlIlIlIIllIllllIII, final String lllllllllllllIIlIlIlIIllIlllllII) {
        super(lllllllllllllIIlIlIlIIllIllllIlI, lllllllllllllIIlIlIlIIllIllllIII, lllllllllllllIIlIlIlIIllIllllIIl, lllllllllllllIIlIlIlIIllIllllIII, lllllllllllllIIlIlIlIIllIlllllII);
    }
    
    public UserListBansEntry(final GameProfile lllllllllllllIIlIlIlIIlllIIIIlll) {
        this(lllllllllllllIIlIlIlIIlllIIIIlll, null, null, null, null);
    }
    
    public UserListBansEntry(final JsonObject lllllllllllllIIlIlIlIIllIlllIIIl) {
        super(toGameProfile(lllllllllllllIIlIlIlIIllIlllIIIl), lllllllllllllIIlIlIlIIllIlllIIIl);
    }
    
    private static GameProfile toGameProfile(final JsonObject lllllllllllllIIlIlIlIIllIllIIIIl) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "uuid"
        //     3: invokevirtual   com/google/gson/JsonObject.has:(Ljava/lang/String;)Z
        //     6: ifeq            57
        //     9: aload_0         /* lllllllllllllIIlIlIlIIllIllIIllI */
        //    10: ldc             "name"
        //    12: invokevirtual   com/google/gson/JsonObject.has:(Ljava/lang/String;)Z
        //    15: ifeq            57
        //    18: aload_0         /* lllllllllllllIIlIlIlIIllIllIIllI */
        //    19: ldc             "uuid"
        //    21: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
        //    24: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
        //    27: astore_1        /* lllllllllllllIIlIlIlIIllIllIIIII */
        //    28: aload_1         /* lllllllllllllIIlIlIlIIllIllIIlIl */
        //    29: invokestatic    java/util/UUID.fromString:(Ljava/lang/String;)Ljava/util/UUID;
        //    32: astore_2        /* lllllllllllllIIlIlIlIIllIlIlllll */
        //    33: goto            39
        //    36: astore_3        /* lllllllllllllIIlIlIlIIllIlIllllI */
        //    37: aconst_null    
        //    38: areturn        
        //    39: new             Lcom/mojang/authlib/GameProfile;
        //    42: dup            
        //    43: aload_2         /* lllllllllllllIIlIlIlIIllIllIIIll */
        //    44: aload_0         /* lllllllllllllIIlIlIlIIllIllIIllI */
        //    45: ldc             "name"
        //    47: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
        //    50: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
        //    53: invokespecial   com/mojang/authlib/GameProfile.<init>:(Ljava/util/UUID;Ljava/lang/String;)V
        //    56: areturn        
        //    57: aconst_null    
        //    58: areturn        
        //    StackMapTable: 00 03 FF 00 24 00 02 07 00 1D 07 00 31 00 01 07 00 5F FC 00 02 07 00 17 F9 00 11
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
}
