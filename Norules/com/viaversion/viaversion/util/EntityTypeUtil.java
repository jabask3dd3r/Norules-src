package com.viaversion.viaversion.util;

import com.viaversion.viaversion.api.minecraft.entities.*;
import java.util.*;

public class EntityTypeUtil
{
    public static EntityType[] toOrderedArray(final EntityType[] lllllllllllllIllIIIlIIIIllIlIIII) {
        final List<EntityType> lllllllllllllIllIIIlIIIIllIIllll = new ArrayList<EntityType>();
        final boolean lllllllllllllIllIIIlIIIIllIIllII = (Object)lllllllllllllIllIIIlIIIIllIlIIII;
        final char lllllllllllllIllIIIlIIIIllIIlIll = (char)lllllllllllllIllIIIlIIIIllIIllII.length;
        for (double lllllllllllllIllIIIlIIIIllIIlIlI = 0; lllllllllllllIllIIIlIIIIllIIlIlI < lllllllllllllIllIIIlIIIIllIIlIll; ++lllllllllllllIllIIIlIIIIllIIlIlI) {
            final EntityType lllllllllllllIllIIIlIIIIllIlIIIl = lllllllllllllIllIIIlIIIIllIIllII[lllllllllllllIllIIIlIIIIllIIlIlI];
            if (lllllllllllllIllIIIlIIIIllIlIIIl.getId() != -1) {
                lllllllllllllIllIIIlIIIIllIIllll.add(lllllllllllllIllIIIlIIIIllIlIIIl);
            }
        }
        lllllllllllllIllIIIlIIIIllIIllll.sort(Comparator.comparingInt(EntityType::getId));
        return lllllllllllllIllIIIlIIIIllIIllll.toArray(new EntityType[0]);
    }
    
    public static EntityType getTypeFromId(final EntityType[] lllllllllllllIllIIIlIIIIllIIIIll, final int lllllllllllllIllIIIlIIIIlIlllllI, final EntityType lllllllllllllIllIIIlIIIIlIllllIl) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iflt            18
        //     4: iload_1         /* lllllllllllllIllIIIlIIIIllIIIIlI */
        //     5: aload_0         /* lllllllllllllIllIIIlIIIIlIllllll */
        //     6: arraylength    
        //     7: if_icmpge       18
        //    10: aload_0         /* lllllllllllllIllIIIlIIIIlIllllll */
        //    11: iload_1         /* lllllllllllllIllIIIlIIIIllIIIIlI */
        //    12: aaload         
        //    13: dup            
        //    14: astore_3        /* lllllllllllllIllIIIlIIIIllIIIlII */
        //    15: ifnonnull       65
        //    18: invokestatic    com/viaversion/viaversion/api/Via.getPlatform:()Lcom/viaversion/viaversion/api/platform/ViaPlatform;
        //    21: invokeinterface com/viaversion/viaversion/api/platform/ViaPlatform.getLogger:()Ljava/util/logging/Logger;
        //    26: new             Ljava/lang/StringBuilder;
        //    29: dup            
        //    30: invokespecial   java/lang/StringBuilder.<init>:()V
        //    33: ldc             "Could not find "
        //    35: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    38: aload_2         /* lllllllllllllIllIIIlIIIIllIIIIIl */
        //    39: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //    42: invokevirtual   java/lang/Class.getSimpleName:()Ljava/lang/String;
        //    45: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    48: ldc             " type id "
        //    50: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    53: iload_1         /* lllllllllllllIllIIIlIIIIllIIIIlI */
        //    54: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    57: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    60: invokevirtual   java/util/logging/Logger.severe:(Ljava/lang/String;)V
        //    63: aload_2         /* lllllllllllllIllIIIlIIIIllIIIIIl */
        //    64: areturn        
        //    65: aload_3         /* lllllllllllllIllIIIlIIIIllIIIIII */
        //    66: areturn        
        //    StackMapTable: 00 02 12 FC 00 2E 07 00 13
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
