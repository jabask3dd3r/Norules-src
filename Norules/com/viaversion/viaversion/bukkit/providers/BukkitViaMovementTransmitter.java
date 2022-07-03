package com.viaversion.viaversion.bukkit.providers;

import com.viaversion.viaversion.protocols.protocol1_9to1_8.providers.*;
import com.viaversion.viaversion.api.connection.*;
import org.bukkit.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.storage.*;
import java.lang.reflect.*;
import org.bukkit.entity.*;

public class BukkitViaMovementTransmitter extends MovementTransmitterProvider
{
    private /* synthetic */ Object idlePacket;
    private static /* synthetic */ boolean USE_NMS;
    private /* synthetic */ Field connection;
    private /* synthetic */ Method handleFlying;
    private /* synthetic */ Method getHandle;
    private /* synthetic */ Object idlePacket2;
    
    @Override
    public Object getGroundPacket() {
        if (this.idlePacket == null) {
            throw new NullPointerException("Could not locate flying packet");
        }
        return this.idlePacket;
    }
    
    public BukkitViaMovementTransmitter() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   com/viaversion/viaversion/protocols/protocol1_9to1_8/providers/MovementTransmitterProvider.<init>:()V
        //     4: invokestatic    com/viaversion/viaversion/api/Via.getConfig:()Lcom/viaversion/viaversion/api/configuration/ViaVersionConfig;
        //     7: invokeinterface com/viaversion/viaversion/api/configuration/ViaVersionConfig.isNMSPlayerTicking:()Z
        //    12: putstatic       com/viaversion/viaversion/bukkit/providers/BukkitViaMovementTransmitter.USE_NMS:Z
        //    15: ldc             "PacketPlayInFlying"
        //    17: invokestatic    com/viaversion/viaversion/bukkit/util/NMSUtil.nms:(Ljava/lang/String;)Ljava/lang/Class;
        //    20: astore_1        /* lllllllllllllIIllIlIIIIIllllIlII */
        //    21: goto            26
        //    24: astore_2        /* lllllllllllllIIllIlIIIIIlllIlIIl */
        //    25: return         
        //    26: aload_0         /* lllllllllllllIIllIlIIIIIlllIllIl */
        //    27: aload_1         /* lllllllllllllIIllIlIIIIIlllIllII */
        //    28: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
        //    31: putfield        com/viaversion/viaversion/bukkit/providers/BukkitViaMovementTransmitter.idlePacket:Ljava/lang/Object;
        //    34: aload_0         /* lllllllllllllIIllIlIIIIIlllIllIl */
        //    35: aload_1         /* lllllllllllllIIllIlIIIIIlllIllII */
        //    36: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
        //    39: putfield        com/viaversion/viaversion/bukkit/providers/BukkitViaMovementTransmitter.idlePacket2:Ljava/lang/Object;
        //    42: aload_1         /* lllllllllllllIIllIlIIIIIlllIllII */
        //    43: ldc             "f"
        //    45: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //    48: astore_2        /* lllllllllllllIIllIlIIIIIlllIlIIl */
        //    49: aload_2         /* lllllllllllllIIllIlIIIIIllllIIlI */
        //    50: iconst_1       
        //    51: invokevirtual   java/lang/reflect/Field.setAccessible:(Z)V
        //    54: aload_2         /* lllllllllllllIIllIlIIIIIllllIIlI */
        //    55: aload_0         /* lllllllllllllIIllIlIIIIIlllIllIl */
        //    56: getfield        com/viaversion/viaversion/bukkit/providers/BukkitViaMovementTransmitter.idlePacket2:Ljava/lang/Object;
        //    59: iconst_1       
        //    60: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //    63: invokevirtual   java/lang/reflect/Field.set:(Ljava/lang/Object;Ljava/lang/Object;)V
        //    66: goto            81
        //    69: astore_2        /* lllllllllllllIIllIlIIIIIlllIlIIl */
        //    70: new             Ljava/lang/RuntimeException;
        //    73: dup            
        //    74: ldc             "Couldn't make player idle packet, help!"
        //    76: aload_2         /* lllllllllllllIIllIlIIIIIllllIIIl */
        //    77: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //    80: athrow         
        //    81: getstatic       com/viaversion/viaversion/bukkit/providers/BukkitViaMovementTransmitter.USE_NMS:Z
        //    84: ifeq            186
        //    87: aload_0         /* lllllllllllllIIllIlIIIIIlllIllIl */
        //    88: ldc             "entity.CraftPlayer"
        //    90: invokestatic    com/viaversion/viaversion/bukkit/util/NMSUtil.obc:(Ljava/lang/String;)Ljava/lang/Class;
        //    93: ldc             "getHandle"
        //    95: iconst_0       
        //    96: anewarray       Ljava/lang/Class;
        //    99: invokevirtual   java/lang/Class.getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   102: putfield        com/viaversion/viaversion/bukkit/providers/BukkitViaMovementTransmitter.getHandle:Ljava/lang/reflect/Method;
        //   105: goto            120
        //   108: astore_2        /* lllllllllllllIIllIlIIIIIlllIlIIl */
        //   109: new             Ljava/lang/RuntimeException;
        //   112: dup            
        //   113: ldc             "Couldn't find CraftPlayer"
        //   115: aload_2         /* lllllllllllllIIllIlIIIIIllllIIII */
        //   116: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   119: athrow         
        //   120: aload_0         /* lllllllllllllIIllIlIIIIIlllIllIl */
        //   121: ldc             "EntityPlayer"
        //   123: invokestatic    com/viaversion/viaversion/bukkit/util/NMSUtil.nms:(Ljava/lang/String;)Ljava/lang/Class;
        //   126: ldc             "playerConnection"
        //   128: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   131: putfield        com/viaversion/viaversion/bukkit/providers/BukkitViaMovementTransmitter.connection:Ljava/lang/reflect/Field;
        //   134: goto            149
        //   137: astore_2        /* lllllllllllllIIllIlIIIIIlllIlIIl */
        //   138: new             Ljava/lang/RuntimeException;
        //   141: dup            
        //   142: ldc             "Couldn't find Player Connection"
        //   144: aload_2         /* lllllllllllllIIllIlIIIIIlllIllll */
        //   145: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   148: athrow         
        //   149: aload_0         /* lllllllllllllIIllIlIIIIIlllIllIl */
        //   150: ldc             "PlayerConnection"
        //   152: invokestatic    com/viaversion/viaversion/bukkit/util/NMSUtil.nms:(Ljava/lang/String;)Ljava/lang/Class;
        //   155: ldc             "a"
        //   157: iconst_1       
        //   158: anewarray       Ljava/lang/Class;
        //   161: dup            
        //   162: iconst_0       
        //   163: aload_1         /* lllllllllllllIIllIlIIIIIlllIllII */
        //   164: aastore        
        //   165: invokevirtual   java/lang/Class.getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   168: putfield        com/viaversion/viaversion/bukkit/providers/BukkitViaMovementTransmitter.handleFlying:Ljava/lang/reflect/Method;
        //   171: goto            186
        //   174: astore_2        /* lllllllllllllIIllIlIIIIIlllIlIIl */
        //   175: new             Ljava/lang/RuntimeException;
        //   178: dup            
        //   179: ldc             "Couldn't find CraftPlayer"
        //   181: aload_2         /* lllllllllllllIIllIlIIIIIlllIlllI */
        //   182: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   185: athrow         
        //   186: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  15     21     24     26     Ljava/lang/ClassNotFoundException;
        //  26     66     69     81     Ljava/lang/NoSuchFieldException;
        //  26     66     69     81     Ljava/lang/InstantiationException;
        //  26     66     69     81     Ljava/lang/IllegalArgumentException;
        //  26     66     69     81     Ljava/lang/IllegalAccessException;
        //  87     105    108    120    Ljava/lang/NoSuchMethodException;
        //  87     105    108    120    Ljava/lang/ClassNotFoundException;
        //  120    134    137    149    Ljava/lang/NoSuchFieldException;
        //  120    134    137    149    Ljava/lang/ClassNotFoundException;
        //  149    171    174    186    Ljava/lang/NoSuchMethodException;
        //  149    171    174    186    Ljava/lang/ClassNotFoundException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public void sendPlayer(final UserConnection lllllllllllllIIllIlIIIIIllIllIII) {
        if (BukkitViaMovementTransmitter.USE_NMS) {
            final Player lllllllllllllIIllIlIIIIIllIllIlI = Bukkit.getPlayer(lllllllllllllIIllIlIIIIIllIllIII.getProtocolInfo().getUuid());
            if (lllllllllllllIIllIlIIIIIllIllIlI != null) {
                try {
                    final Object lllllllllllllIIllIlIIIIIllIlllIl = this.getHandle.invoke(lllllllllllllIIllIlIIIIIllIllIlI, new Object[0]);
                    final Object lllllllllllllIIllIlIIIIIllIlllII = this.connection.get(lllllllllllllIIllIlIIIIIllIlllIl);
                    if (lllllllllllllIIllIlIIIIIllIlllII != null) {
                        this.handleFlying.invoke(lllllllllllllIIllIlIIIIIllIlllII, lllllllllllllIIllIlIIIIIllIllIII.get(MovementTracker.class).isGround() ? this.idlePacket2 : this.idlePacket);
                        lllllllllllllIIllIlIIIIIllIllIII.get(MovementTracker.class).incrementIdlePacket();
                    }
                }
                catch (IllegalAccessException | InvocationTargetException ex2) {
                    final ReflectiveOperationException ex;
                    final ReflectiveOperationException lllllllllllllIIllIlIIIIIllIllIll = ex;
                    lllllllllllllIIllIlIIIIIllIllIll.printStackTrace();
                }
            }
        }
        else {
            super.sendPlayer(lllllllllllllIIllIlIIIIIllIllIII);
        }
    }
    
    @Override
    public Object getFlyingPacket() {
        if (this.idlePacket == null) {
            throw new NullPointerException("Could not locate flying packet");
        }
        return this.idlePacket2;
    }
    
    static {
        BukkitViaMovementTransmitter.USE_NMS = true;
    }
}
