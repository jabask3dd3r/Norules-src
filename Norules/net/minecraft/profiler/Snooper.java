package net.minecraft.profiler;

import java.lang.management.*;
import com.google.common.collect.*;
import java.net.*;
import java.util.*;

public class Snooper
{
    private final /* synthetic */ Map<String, Object> clientStats;
    private final /* synthetic */ Map<String, Object> snooperStats;
    private final /* synthetic */ Timer threadTrigger;
    private final /* synthetic */ Object syncLock;
    private /* synthetic */ boolean isRunning;
    private final /* synthetic */ long minecraftStartTimeMilis;
    private final /* synthetic */ ISnooperInfo playerStatsCollector;
    private final /* synthetic */ URL serverUrl;
    private final /* synthetic */ String uniqueID;
    
    public void addStatToSnooper(final String lllllllllllllllIIIIlIlIIIlIIlllI, final Object lllllllllllllllIIIIlIlIIIlIlIIII) {
        synchronized (this.syncLock) {
            this.snooperStats.put(lllllllllllllllIIIIlIlIIIlIIlllI, lllllllllllllllIIIIlIlIIIlIlIIII);
        }
        // monitorexit(this.syncLock)
    }
    
    public void addClientStat(final String lllllllllllllllIIIIlIlIIIlIlllII, final Object lllllllllllllllIIIIlIlIIIlIllIll) {
        synchronized (this.syncLock) {
            this.clientStats.put(lllllllllllllllIIIIlIlIIIlIlllII, lllllllllllllllIIIIlIlIIIlIllIll);
        }
        // monitorexit(this.syncLock)
    }
    
    public long getMinecraftStartTimeMillis() {
        return this.minecraftStartTimeMilis;
    }
    
    public boolean isSnooperRunning() {
        return this.isRunning;
    }
    
    private void addOSData() {
        this.addJvmArgsToSnooper();
        this.addClientStat("snooper_token", this.uniqueID);
        this.addStatToSnooper("snooper_token", this.uniqueID);
        this.addStatToSnooper("os_name", System.getProperty("os.name"));
        this.addStatToSnooper("os_version", System.getProperty("os.version"));
        this.addStatToSnooper("os_architecture", System.getProperty("os.arch"));
        this.addStatToSnooper("java_version", System.getProperty("java.version"));
        this.addClientStat("version", "1.12.2");
        this.playerStatsCollector.addServerTypeToSnooper(this);
    }
    
    private void addJvmArgsToSnooper() {
        final RuntimeMXBean lllllllllllllllIIIIlIlIIIllIlllI = ManagementFactory.getRuntimeMXBean();
        final List<String> lllllllllllllllIIIIlIlIIIllIllIl = lllllllllllllllIIIIlIlIIIllIlllI.getInputArguments();
        int lllllllllllllllIIIIlIlIIIllIllII = 0;
        for (final String lllllllllllllllIIIIlIlIIIllIlIll : lllllllllllllllIIIIlIlIIIllIllIl) {
            if (lllllllllllllllIIIIlIlIIIllIlIll.startsWith("-X")) {
                this.addClientStat(String.valueOf(new StringBuilder("jvm_arg[").append(lllllllllllllllIIIIlIlIIIllIllII++).append("]")), lllllllllllllllIIIIlIlIIIllIlIll);
            }
        }
        this.addClientStat("jvm_args", lllllllllllllllIIIIlIlIIIllIllII);
    }
    
    public void addMemoryStatsToSnooper() {
        this.addStatToSnooper("memory_total", Runtime.getRuntime().totalMemory());
        this.addStatToSnooper("memory_max", Runtime.getRuntime().maxMemory());
        this.addStatToSnooper("memory_free", Runtime.getRuntime().freeMemory());
        this.addStatToSnooper("cpu_cores", Runtime.getRuntime().availableProcessors());
        this.playerStatsCollector.addServerStatsToSnooper(this);
    }
    
    public void stopSnooper() {
        this.threadTrigger.cancel();
    }
    
    public String getUniqueID() {
        return this.uniqueID;
    }
    
    public Snooper(final String lllllllllllllllIIIIlIlIIlIIIIlII, final ISnooperInfo lllllllllllllllIIIIlIlIIlIIIIIll, final long lllllllllllllllIIIIlIlIIIlllllIl) {
        this.snooperStats = (Map<String, Object>)Maps.newHashMap();
        this.clientStats = (Map<String, Object>)Maps.newHashMap();
        this.uniqueID = UUID.randomUUID().toString();
        this.threadTrigger = new Timer("Snooper Timer", true);
        this.syncLock = new Object();
        try {
            this.serverUrl = new URL(String.valueOf(new StringBuilder("http://snoop.minecraft.net/").append(lllllllllllllllIIIIlIlIIlIIIIlII).append("?version=").append(2)));
        }
        catch (MalformedURLException lllllllllllllllIIIIlIlIIlIIIIIIl) {
            throw new IllegalArgumentException();
        }
        this.playerStatsCollector = lllllllllllllllIIIIlIlIIlIIIIIll;
        this.minecraftStartTimeMilis = lllllllllllllllIIIIlIlIIIlllllIl;
    }
    
    public Map<String, String> getCurrentStats() {
        final Map<String, String> lllllllllllllllIIIIlIlIIIlIIIlIl = (Map<String, String>)Maps.newLinkedHashMap();
        synchronized (this.syncLock) {
            this.addMemoryStatsToSnooper();
            for (final Map.Entry<String, Object> lllllllllllllllIIIIlIlIIIlIIIlII : this.snooperStats.entrySet()) {
                lllllllllllllllIIIIlIlIIIlIIIlIl.put(lllllllllllllllIIIIlIlIIIlIIIlII.getKey(), lllllllllllllllIIIIlIlIIIlIIIlII.getValue().toString());
            }
            for (final Map.Entry<String, Object> lllllllllllllllIIIIlIlIIIlIIIIll : this.clientStats.entrySet()) {
                lllllllllllllllIIIIlIlIIIlIIIlIl.put(lllllllllllllllIIIIlIlIIIlIIIIll.getKey(), lllllllllllllllIIIIlIlIIIlIIIIll.getValue().toString());
            }
            // monitorexit(this.syncLock)
            return lllllllllllllllIIIIlIlIIIlIIIlIl;
        }
    }
    
    public void startSnooper() {
        if (!this.isRunning) {
            this.isRunning = true;
            this.addOSData();
            this.threadTrigger.schedule(new TimerTask() {
                @Override
                public void run() {
                    // 
                    // This method could not be decompiled.
                    // 
                    // Original Bytecode:
                    // 
                    //     1: getfield        net/minecraft/profiler/Snooper$1.this$0:Lnet/minecraft/profiler/Snooper;
                    //     4: invokestatic    net/minecraft/profiler/Snooper.access$0:(Lnet/minecraft/profiler/Snooper;)Lnet/minecraft/profiler/ISnooperInfo;
                    //     7: invokeinterface net/minecraft/profiler/ISnooperInfo.isSnooperEnabled:()Z
                    //    12: ifeq            162
                    //    15: aload_0         /* lllllllllllllIIIIIllIlIlIIIlIIII */
                    //    16: getfield        net/minecraft/profiler/Snooper$1.this$0:Lnet/minecraft/profiler/Snooper;
                    //    19: invokestatic    net/minecraft/profiler/Snooper.access$1:(Lnet/minecraft/profiler/Snooper;)Ljava/lang/Object;
                    //    22: dup            
                    //    23: astore_2        /* lllllllllllllIIIIIllIlIlIIIIlllI */
                    //    24: monitorenter   
                    //    25: aload_0         /* lllllllllllllIIIIIllIlIlIIIlIIII */
                    //    26: getfield        net/minecraft/profiler/Snooper$1.this$0:Lnet/minecraft/profiler/Snooper;
                    //    29: invokestatic    net/minecraft/profiler/Snooper.access$2:(Lnet/minecraft/profiler/Snooper;)Ljava/util/Map;
                    //    32: invokestatic    com/google/common/collect/Maps.newHashMap:(Ljava/util/Map;)Ljava/util/HashMap;
                    //    35: astore_1        /* lllllllllllllIIIIIllIlIlIIIIllll */
                    //    36: aload_0         /* lllllllllllllIIIIIllIlIlIIIlIIII */
                    //    37: getfield        net/minecraft/profiler/Snooper$1.this$0:Lnet/minecraft/profiler/Snooper;
                    //    40: invokestatic    net/minecraft/profiler/Snooper.access$3:(Lnet/minecraft/profiler/Snooper;)I
                    //    43: ifne            59
                    //    46: aload_1         /* lllllllllllllIIIIIllIlIlIIIlIIll */
                    //    47: aload_0         /* lllllllllllllIIIIIllIlIlIIIlIIII */
                    //    48: getfield        net/minecraft/profiler/Snooper$1.this$0:Lnet/minecraft/profiler/Snooper;
                    //    51: invokestatic    net/minecraft/profiler/Snooper.access$4:(Lnet/minecraft/profiler/Snooper;)Ljava/util/Map;
                    //    54: invokeinterface java/util/Map.putAll:(Ljava/util/Map;)V
                    //    59: aload_1         /* lllllllllllllIIIIIllIlIlIIIlIIll */
                    //    60: ldc             "snooper_count"
                    //    62: aload_0         /* lllllllllllllIIIIIllIlIlIIIlIIII */
                    //    63: getfield        net/minecraft/profiler/Snooper$1.this$0:Lnet/minecraft/profiler/Snooper;
                    //    66: dup            
                    //    67: invokestatic    net/minecraft/profiler/Snooper.access$3:(Lnet/minecraft/profiler/Snooper;)I
                    //    70: dup_x1         
                    //    71: iconst_1       
                    //    72: iadd           
                    //    73: invokestatic    net/minecraft/profiler/Snooper.access$5:(Lnet/minecraft/profiler/Snooper;I)V
                    //    76: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                    //    79: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //    84: pop            
                    //    85: aload_1         /* lllllllllllllIIIIIllIlIlIIIlIIll */
                    //    86: ldc             "snooper_token"
                    //    88: aload_0         /* lllllllllllllIIIIIllIlIlIIIlIIII */
                    //    89: getfield        net/minecraft/profiler/Snooper$1.this$0:Lnet/minecraft/profiler/Snooper;
                    //    92: invokestatic    net/minecraft/profiler/Snooper.access$6:(Lnet/minecraft/profiler/Snooper;)Ljava/lang/String;
                    //    95: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   100: pop            
                    //   101: aload_2         /* lllllllllllllIIIIIllIlIlIIIIlllI */
                    //   102: monitorexit    
                    //   103: goto            109
                    //   106: aload_2         /* lllllllllllllIIIIIllIlIlIIIIlllI */
                    //   107: monitorexit    
                    //   108: athrow         
                    //   109: aload_0         /* lllllllllllllIIIIIllIlIlIIIlIIII */
                    //   110: getfield        net/minecraft/profiler/Snooper$1.this$0:Lnet/minecraft/profiler/Snooper;
                    //   113: invokestatic    net/minecraft/profiler/Snooper.access$0:(Lnet/minecraft/profiler/Snooper;)Lnet/minecraft/profiler/ISnooperInfo;
                    //   116: instanceof      Lnet/minecraft/server/MinecraftServer;
                    //   119: ifeq            135
                    //   122: aload_0         /* lllllllllllllIIIIIllIlIlIIIlIIII */
                    //   123: getfield        net/minecraft/profiler/Snooper$1.this$0:Lnet/minecraft/profiler/Snooper;
                    //   126: invokestatic    net/minecraft/profiler/Snooper.access$0:(Lnet/minecraft/profiler/Snooper;)Lnet/minecraft/profiler/ISnooperInfo;
                    //   129: checkcast       Lnet/minecraft/server/MinecraftServer;
                    //   132: goto            136
                    //   135: aconst_null    
                    //   136: astore_2        /* lllllllllllllIIIIIllIlIlIIIIlllI */
                    //   137: aload_0         /* lllllllllllllIIIIIllIlIlIIIlIIII */
                    //   138: getfield        net/minecraft/profiler/Snooper$1.this$0:Lnet/minecraft/profiler/Snooper;
                    //   141: invokestatic    net/minecraft/profiler/Snooper.access$7:(Lnet/minecraft/profiler/Snooper;)Ljava/net/URL;
                    //   144: aload_1         /* lllllllllllllIIIIIllIlIlIIIlIIlI */
                    //   145: iconst_1       
                    //   146: aload_2         /* lllllllllllllIIIIIllIlIlIIIlIIIl */
                    //   147: ifnonnull       154
                    //   150: aconst_null    
                    //   151: goto            158
                    //   154: aload_2         /* lllllllllllllIIIIIllIlIlIIIlIIIl */
                    //   155: invokevirtual   net/minecraft/server/MinecraftServer.getServerProxy:()Ljava/net/Proxy;
                    //   158: invokestatic    net/minecraft/util/HttpUtil.postMap:(Ljava/net/URL;Ljava/util/Map;ZLjava/net/Proxy;)Ljava/lang/String;
                    //   161: pop            
                    //   162: return         
                    //    StackMapTable: 00 08 FD 00 3B 07 00 71 07 00 73 FF 00 2E 00 03 07 00 02 00 07 00 73 00 01 07 00 75 FF 00 02 00 03 07 00 02 07 00 71 07 00 73 00 00 19 40 07 00 55 FF 00 11 00 03 07 00 02 07 00 71 07 00 55 00 03 07 00 77 07 00 71 01 FF 00 03 00 03 07 00 02 07 00 71 07 00 55 00 04 07 00 77 07 00 71 01 07 00 79 F9 00 03
                    //    Exceptions:
                    //  Try           Handler
                    //  Start  End    Start  End    Type
                    //  -----  -----  -----  -----  ----
                    //  25     103    106    109    Any
                    //  106    108    106    109    Any
                    // 
                    // The error that occurred was:
                    // 
                    // java.lang.NullPointerException
                    // 
                    throw new IllegalStateException("An error occurred while decompiling this method.");
                }
            }, 0L, 900000L);
        }
    }
}
