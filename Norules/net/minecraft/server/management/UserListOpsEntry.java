package net.minecraft.server.management;

import com.mojang.authlib.*;
import com.google.gson.*;

public class UserListOpsEntry extends UserListEntry<GameProfile>
{
    private final /* synthetic */ boolean bypassesPlayerLimit;
    private final /* synthetic */ int permissionLevel;
    
    @Override
    protected void onSerialization(final JsonObject lllllllllllllIIIIlIlIlIIIlIllIII) {
        if (this.getValue() != null) {
            lllllllllllllIIIIlIlIlIIIlIllIII.addProperty("uuid", (this.getValue().getId() == null) ? "" : this.getValue().getId().toString());
            lllllllllllllIIIIlIlIlIIIlIllIII.addProperty("name", this.getValue().getName());
            super.onSerialization(lllllllllllllIIIIlIlIlIIIlIllIII);
            lllllllllllllIIIIlIlIlIIIlIllIII.addProperty("level", (Number)this.permissionLevel);
            lllllllllllllIIIIlIlIlIIIlIllIII.addProperty("bypassesPlayerLimit", Boolean.valueOf(this.bypassesPlayerLimit));
        }
    }
    
    public UserListOpsEntry(final GameProfile lllllllllllllIIIIlIlIlIIIllIlIlI, final int lllllllllllllIIIIlIlIlIIIllIlIIl, final boolean lllllllllllllIIIIlIlIlIIIllIlIII) {
        super(lllllllllllllIIIIlIlIlIIIllIlIlI);
        this.permissionLevel = lllllllllllllIIIIlIlIlIIIllIlIIl;
        this.bypassesPlayerLimit = lllllllllllllIIIIlIlIlIIIllIlIII;
    }
    
    private static GameProfile constructProfile(final JsonObject lllllllllllllIIIIlIlIlIIIlIlIIIl) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "uuid"
        //     3: invokevirtual   com/google/gson/JsonObject.has:(Ljava/lang/String;)Z
        //     6: ifeq            57
        //     9: aload_0         /* lllllllllllllIIIIlIlIlIIIlIIllII */
        //    10: ldc             "name"
        //    12: invokevirtual   com/google/gson/JsonObject.has:(Ljava/lang/String;)Z
        //    15: ifeq            57
        //    18: aload_0         /* lllllllllllllIIIIlIlIlIIIlIIllII */
        //    19: ldc             "uuid"
        //    21: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
        //    24: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
        //    27: astore_1        /* lllllllllllllIIIIlIlIlIIIlIIlIll */
        //    28: aload_1         /* lllllllllllllIIIIlIlIlIIIlIlIIII */
        //    29: invokestatic    java/util/UUID.fromString:(Ljava/lang/String;)Ljava/util/UUID;
        //    32: astore_2        /* lllllllllllllIIIIlIlIlIIIlIIllll */
        //    33: goto            39
        //    36: astore_3        /* lllllllllllllIIIIlIlIlIIIlIIlIIl */
        //    37: aconst_null    
        //    38: areturn        
        //    39: new             Lcom/mojang/authlib/GameProfile;
        //    42: dup            
        //    43: aload_2         /* lllllllllllllIIIIlIlIlIIIlIIlllI */
        //    44: aload_0         /* lllllllllllllIIIIlIlIlIIIlIIllII */
        //    45: ldc             "name"
        //    47: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
        //    50: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
        //    53: invokespecial   com/mojang/authlib/GameProfile.<init>:(Ljava/util/UUID;Ljava/lang/String;)V
        //    56: areturn        
        //    57: aconst_null    
        //    58: areturn        
        //    StackMapTable: 00 03 FF 00 24 00 02 07 00 21 07 00 4E 00 01 07 00 64 FC 00 02 07 00 1B F9 00 11
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
    
    public UserListOpsEntry(final JsonObject lllllllllllllIIIIlIlIlIIIllIIIlI) {
        super(constructProfile(lllllllllllllIIIIlIlIlIIIllIIIlI), lllllllllllllIIIIlIlIlIIIllIIIlI);
        this.permissionLevel = (lllllllllllllIIIIlIlIlIIIllIIIlI.has("level") ? lllllllllllllIIIIlIlIlIIIllIIIlI.get("level").getAsInt() : 0);
        this.bypassesPlayerLimit = (lllllllllllllIIIIlIlIlIIIllIIIlI.has("bypassesPlayerLimit") && lllllllllllllIIIIlIlIlIIIllIIIlI.get("bypassesPlayerLimit").getAsBoolean());
    }
    
    public boolean bypassesPlayerLimit() {
        return this.bypassesPlayerLimit;
    }
    
    public int getPermissionLevel() {
        return this.permissionLevel;
    }
}
