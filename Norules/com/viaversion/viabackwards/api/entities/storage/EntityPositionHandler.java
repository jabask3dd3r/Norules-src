package com.viaversion.viabackwards.api.entities.storage;

import com.viaversion.viabackwards.api.rewriters.*;
import java.util.function.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viaversion.api.data.entity.*;

public class EntityPositionHandler
{
    private final /* synthetic */ EntityRewriterBase entityRewriter;
    private /* synthetic */ boolean warnedForMissingEntity;
    private final /* synthetic */ Class<? extends EntityPositionStorage> storageClass;
    private final /* synthetic */ Supplier<? extends EntityPositionStorage> storageSupplier;
    
    public static void writeFacingAngles(final PacketWrapper llllllllllllllIIIlllllIIllIIllII, final double llllllllllllllIIIlllllIIllIIlIll, final double llllllllllllllIIIlllllIIllIIlIlI, final double llllllllllllllIIIlllllIIllIlIllI, final double llllllllllllllIIIlllllIIllIlIlIl, final double llllllllllllllIIIlllllIIllIIIlll, final double llllllllllllllIIIlllllIIllIIIllI) {
        final double llllllllllllllIIIlllllIIllIlIIlI = llllllllllllllIIIlllllIIllIlIlIl - llllllllllllllIIIlllllIIllIIlIll;
        final double llllllllllllllIIIlllllIIllIlIIIl = llllllllllllllIIIlllllIIllIIIlll - llllllllllllllIIIlllllIIllIIlIlI;
        final double llllllllllllllIIIlllllIIllIlIIII = llllllllllllllIIIlllllIIllIIIllI - llllllllllllllIIIlllllIIllIlIllI;
        final double llllllllllllllIIIlllllIIllIIllll = Math.sqrt(llllllllllllllIIIlllllIIllIlIIlI * llllllllllllllIIIlllllIIllIlIIlI + llllllllllllllIIIlllllIIllIlIIIl * llllllllllllllIIIlllllIIllIlIIIl + llllllllllllllIIIlllllIIllIlIIII * llllllllllllllIIIlllllIIllIlIIII);
        double llllllllllllllIIIlllllIIllIIlllI = -Math.atan2(llllllllllllllIIIlllllIIllIlIIlI, llllllllllllllIIIlllllIIllIlIIII) / 3.141592653589793 * 180.0;
        if (llllllllllllllIIIlllllIIllIIlllI < 0.0) {
            llllllllllllllIIIlllllIIllIIlllI += 360.0;
        }
        final double llllllllllllllIIIlllllIIllIIllIl = -Math.asin(llllllllllllllIIIlllllIIllIlIIIl / llllllllllllllIIIlllllIIllIIllll) / 3.141592653589793 * 180.0;
        llllllllllllllIIIlllllIIllIIllII.write(Type.BYTE, (byte)(llllllllllllllIIIlllllIIllIIlllI * 256.0 / 360.0));
        llllllllllllllIIIlllllIIllIIllII.write(Type.BYTE, (byte)(llllllllllllllIIIlllllIIllIIllIl * 256.0 / 360.0));
    }
    
    public EntityPositionHandler(final EntityRewriterBase llllllllllllllIIIlllllIlIIlIlIII, final Class<? extends EntityPositionStorage> llllllllllllllIIIlllllIlIIlIIIll, final Supplier<? extends EntityPositionStorage> llllllllllllllIIIlllllIlIIlIIIlI) {
        this.entityRewriter = llllllllllllllIIIlllllIlIIlIlIII;
        this.storageClass = llllllllllllllIIIlllllIlIIlIIIll;
        this.storageSupplier = llllllllllllllIIIlllllIlIIlIIIlI;
    }
    
    public EntityPositionStorage getStorage(final UserConnection llllllllllllllIIIlllllIIlllIlIlI, final int llllllllllllllIIIlllllIIlllIlIIl) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/viaversion/viabackwards/api/entities/storage/EntityPositionHandler.entityRewriter:Lcom/viaversion/viabackwards/api/rewriters/EntityRewriterBase;
        //     4: aload_1         /* llllllllllllllIIIlllllIIlllIllll */
        //     5: invokevirtual   com/viaversion/viabackwards/api/rewriters/EntityRewriterBase.tracker:(Lcom/viaversion/viaversion/api/connection/UserConnection;)Lcom/viaversion/viaversion/api/data/entity/EntityTracker;
        //     8: iload_2         /* llllllllllllllIIIlllllIIlllIlllI */
        //     9: invokeinterface com/viaversion/viaversion/api/data/entity/EntityTracker.entityData:(I)Lcom/viaversion/viaversion/api/data/entity/StoredEntityData;
        //    14: astore_3        /* llllllllllllllIIIlllllIIlllIllIl */
        //    15: aload_3         /* llllllllllllllIIIlllllIIlllIllIl */
        //    16: ifnull          36
        //    19: aload_3         /* llllllllllllllIIIlllllIIlllIllIl */
        //    20: ldc             Lcom/viaversion/viabackwards/api/entities/storage/EntityPositionStorage;.class
        //    22: invokeinterface com/viaversion/viaversion/api/data/entity/StoredEntityData.get:(Ljava/lang/Class;)Ljava/lang/Object;
        //    27: checkcast       Lcom/viaversion/viabackwards/api/entities/storage/EntityPositionStorage;
        //    30: dup            
        //    31: astore          llllllllllllllIIIlllllIIllllIIIl
        //    33: ifnonnull       83
        //    36: invokestatic    com/viaversion/viabackwards/ViaBackwards.getPlatform:()Lcom/viaversion/viabackwards/api/ViaBackwardsPlatform;
        //    39: invokeinterface com/viaversion/viabackwards/api/ViaBackwardsPlatform.getLogger:()Ljava/util/logging/Logger;
        //    44: new             Ljava/lang/StringBuilder;
        //    47: dup            
        //    48: invokespecial   java/lang/StringBuilder.<init>:()V
        //    51: ldc             "Untracked entity with id "
        //    53: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    56: iload_2         /* llllllllllllllIIIlllllIIlllIlllI */
        //    57: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    60: ldc             " in "
        //    62: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    65: aload_0         /* llllllllllllllIIIlllllIIllllIIII */
        //    66: getfield        com/viaversion/viabackwards/api/entities/storage/EntityPositionHandler.storageClass:Ljava/lang/Class;
        //    69: invokevirtual   java/lang/Class.getSimpleName:()Ljava/lang/String;
        //    72: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    75: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    78: invokevirtual   java/util/logging/Logger.warning:(Ljava/lang/String;)V
        //    81: aconst_null    
        //    82: areturn        
        //    83: aload           llllllllllllllIIIlllllIIlllIllII
        //    85: areturn        
        //    StackMapTable: 00 02 FC 00 24 07 00 85 FC 00 2E 07 00 83
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void cacheEntityPosition(final PacketWrapper llllllllllllllIIIlllllIlIIIIlIIl, final double llllllllllllllIIIlllllIlIIIIlIII, final double llllllllllllllIIIlllllIIllllllIl, final double llllllllllllllIIIlllllIIllllllII, final boolean llllllllllllllIIIlllllIlIIIIIlIl, final boolean llllllllllllllIIIlllllIIlllllIlI) throws Exception {
        final int llllllllllllllIIIlllllIlIIIIIIll = llllllllllllllIIIlllllIlIIIIlIIl.get((Type<Integer>)Type.VAR_INT, 0);
        final StoredEntityData llllllllllllllIIIlllllIlIIIIIIlI = this.entityRewriter.tracker(llllllllllllllIIIlllllIlIIIIlIIl.user()).entityData(llllllllllllllIIIlllllIlIIIIIIll);
        if (llllllllllllllIIIlllllIlIIIIIIlI == null) {
            if (Via.getManager().isDebug()) {
                ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Stored entity with id ").append(llllllllllllllIIIlllllIlIIIIIIll).append(" missing at position: ").append(llllllllllllllIIIlllllIlIIIIlIII).append(" - ").append(llllllllllllllIIIlllllIIllllllIl).append(" - ").append(llllllllllllllIIIlllllIIllllllII).append(" in ").append(this.storageClass.getSimpleName())));
                if (llllllllllllllIIIlllllIlIIIIIIll == -1 && llllllllllllllIIIlllllIlIIIIlIII == 0.0 && llllllllllllllIIIlllllIIllllllIl == 0.0 && llllllllllllllIIIlllllIIllllllII == 0.0) {
                    ViaBackwards.getPlatform().getLogger().warning("DO NOT REPORT THIS TO VIA, THIS IS A PLUGIN ISSUE");
                }
                else if (!this.warnedForMissingEntity) {
                    this.warnedForMissingEntity = true;
                    ViaBackwards.getPlatform().getLogger().warning("This is very likely caused by a plugin sending a teleport packet for an entity outside of the player's range.");
                }
            }
            return;
        }
        EntityPositionStorage llllllllllllllIIIlllllIlIIIIIIIl = null;
        if (llllllllllllllIIIlllllIlIIIIIlIl) {
            final EntityPositionStorage llllllllllllllIIIlllllIlIIIIlIll = (EntityPositionStorage)this.storageSupplier.get();
            llllllllllllllIIIlllllIlIIIIIIlI.put(llllllllllllllIIIlllllIlIIIIlIll);
        }
        else {
            llllllllllllllIIIlllllIlIIIIIIIl = llllllllllllllIIIlllllIlIIIIIIlI.get(this.storageClass);
            if (llllllllllllllIIIlllllIlIIIIIIIl == null) {
                ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Stored entity with id ").append(llllllllllllllIIIlllllIlIIIIIIll).append(" missing ").append(this.storageClass.getSimpleName())));
                return;
            }
        }
        llllllllllllllIIIlllllIlIIIIIIIl.setCoordinates(llllllllllllllIIIlllllIlIIIIlIII, llllllllllllllIIIlllllIIllllllIl, llllllllllllllIIIlllllIIllllllII, llllllllllllllIIIlllllIIlllllIlI);
    }
    
    public static void writeFacingDegrees(final PacketWrapper llllllllllllllIIIlllllIIlIllIIlI, final double llllllllllllllIIIlllllIIlIllIIIl, final double llllllllllllllIIIlllllIIlIllIIII, final double llllllllllllllIIIlllllIIlIlIllll, final double llllllllllllllIIIlllllIIlIlIIIIl, final double llllllllllllllIIIlllllIIlIlIllIl, final double llllllllllllllIIIlllllIIlIlIllII) {
        final double llllllllllllllIIIlllllIIlIlIlIll = llllllllllllllIIIlllllIIlIlIIIIl - llllllllllllllIIIlllllIIlIllIIIl;
        final double llllllllllllllIIIlllllIIlIlIlIlI = llllllllllllllIIIlllllIIlIlIllIl - llllllllllllllIIIlllllIIlIllIIII;
        final double llllllllllllllIIIlllllIIlIlIlIIl = llllllllllllllIIIlllllIIlIlIllII - llllllllllllllIIIlllllIIlIlIllll;
        final double llllllllllllllIIIlllllIIlIlIlIII = Math.sqrt(llllllllllllllIIIlllllIIlIlIlIll * llllllllllllllIIIlllllIIlIlIlIll + llllllllllllllIIIlllllIIlIlIlIlI * llllllllllllllIIIlllllIIlIlIlIlI + llllllllllllllIIIlllllIIlIlIlIIl * llllllllllllllIIIlllllIIlIlIlIIl);
        double llllllllllllllIIIlllllIIlIlIIlll = -Math.atan2(llllllllllllllIIIlllllIIlIlIlIll, llllllllllllllIIIlllllIIlIlIlIIl) / 3.141592653589793 * 180.0;
        if (llllllllllllllIIIlllllIIlIlIIlll < 0.0) {
            llllllllllllllIIIlllllIIlIlIIlll += 360.0;
        }
        final double llllllllllllllIIIlllllIIlIlIIllI = -Math.asin(llllllllllllllIIIlllllIIlIlIlIlI / llllllllllllllIIIlllllIIlIlIlIII) / 3.141592653589793 * 180.0;
        llllllllllllllIIIlllllIIlIllIIlI.write(Type.FLOAT, (float)llllllllllllllIIIlllllIIlIlIIlll);
        llllllllllllllIIIlllllIIlIllIIlI.write(Type.FLOAT, (float)llllllllllllllIIIlllllIIlIlIIllI);
    }
    
    public void cacheEntityPosition(final PacketWrapper llllllllllllllIIIlllllIlIIIllIII, final boolean llllllllllllllIIIlllllIlIIIlIlll, final boolean llllllllllllllIIIlllllIlIIIlIllI) throws Exception {
        this.cacheEntityPosition(llllllllllllllIIIlllllIlIIIllIII, llllllllllllllIIIlllllIlIIIllIII.get((Type<Double>)Type.DOUBLE, 0), llllllllllllllIIIlllllIlIIIllIII.get((Type<Double>)Type.DOUBLE, 1), llllllllllllllIIIlllllIlIIIllIII.get((Type<Double>)Type.DOUBLE, 2), llllllllllllllIIIlllllIlIIIlIlll, llllllllllllllIIIlllllIlIIIlIllI);
    }
}
