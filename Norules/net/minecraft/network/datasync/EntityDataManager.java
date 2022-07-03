package net.minecraft.network.datasync;

import net.minecraft.entity.*;
import org.apache.commons.lang3.*;
import net.minecraft.network.*;
import java.util.*;
import java.io.*;
import javax.annotation.*;
import com.google.common.collect.*;
import java.util.concurrent.locks.*;
import org.apache.logging.log4j.*;
import io.netty.handler.codec.*;

public class EntityDataManager
{
    private final /* synthetic */ Entity entity;
    private /* synthetic */ boolean empty;
    private static final /* synthetic */ Map<Class<? extends Entity>, Integer> NEXT_ID_MAP;
    private final /* synthetic */ Map<Integer, DataEntry<?>> entries;
    private /* synthetic */ boolean dirty;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ ReadWriteLock lock;
    
    private <T> void setEntry(final DataParameter<T> llllllllllllllllIIlIIlIIIlIlIIII, final T llllllllllllllllIIlIIlIIIlIIllll) {
        final DataEntry<T> llllllllllllllllIIlIIlIIIlIIlllI = new DataEntry<T>(llllllllllllllllIIlIIlIIIlIlIIII, llllllllllllllllIIlIIlIIIlIIllll);
        this.lock.writeLock().lock();
        this.entries.put(llllllllllllllllIIlIIlIIIlIlIIII.getId(), llllllllllllllllIIlIIlIIIlIIlllI);
        this.empty = false;
        this.lock.writeLock().unlock();
    }
    
    public <T> void set(final DataParameter<T> llllllllllllllllIIlIIlIIIIlIlIll, final T llllllllllllllllIIlIIlIIIIlIlIlI) {
        final DataEntry<T> llllllllllllllllIIlIIlIIIIlIlIIl = this.getEntry(llllllllllllllllIIlIIlIIIIlIlIll);
        if (ObjectUtils.notEqual((Object)llllllllllllllllIIlIIlIIIIlIlIlI, (Object)llllllllllllllllIIlIIlIIIIlIlIIl.getValue())) {
            llllllllllllllllIIlIIlIIIIlIlIIl.setValue(llllllllllllllllIIlIIlIIIIlIlIlI);
            this.entity.notifyDataManagerChange(llllllllllllllllIIlIIlIIIIlIlIll);
            llllllllllllllllIIlIIlIIIIlIlIIl.setDirty(true);
            this.dirty = true;
        }
    }
    
    private <T> DataEntry<T> getEntry(final DataParameter<T> llllllllllllllllIIlIIlIIIlIIIIlI) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/network/datasync/EntityDataManager.lock:Ljava/util/concurrent/locks/ReadWriteLock;
        //     4: invokeinterface java/util/concurrent/locks/ReadWriteLock.readLock:()Ljava/util/concurrent/locks/Lock;
        //     9: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    14: aload_0         /* llllllllllllllllIIlIIlIIIIllllII */
        //    15: getfield        net/minecraft/network/datasync/EntityDataManager.entries:Ljava/util/Map;
        //    18: aload_1         /* llllllllllllllllIIlIIlIIIIlllIll */
        //    19: invokevirtual   net/minecraft/network/datasync/DataParameter.getId:()I
        //    22: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    25: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    30: checkcast       Lnet/minecraft/network/datasync/EntityDataManager$DataEntry;
        //    33: astore_2        /* llllllllllllllllIIlIIlIIIlIIIIIl */
        //    34: goto            73
        //    37: astore_3        /* llllllllllllllllIIlIIlIIIIllllll */
        //    38: aload_3         /* llllllllllllllllIIlIIlIIIIllllll */
        //    39: ldc             "Getting synched entity data"
        //    41: invokestatic    net/minecraft/crash/CrashReport.makeCrashReport:(Ljava/lang/Throwable;Ljava/lang/String;)Lnet/minecraft/crash/CrashReport;
        //    44: astore          llllllllllllllllIIlIIlIIIIlllllI
        //    46: aload           llllllllllllllllIIlIIlIIIIlllllI
        //    48: ldc             "Synched entity data"
        //    50: invokevirtual   net/minecraft/crash/CrashReport.makeCategory:(Ljava/lang/String;)Lnet/minecraft/crash/CrashReportCategory;
        //    53: astore          llllllllllllllllIIlIIlIIIIllllIl
        //    55: aload           llllllllllllllllIIlIIlIIIIllllIl
        //    57: ldc             "Data ID"
        //    59: aload_1         /* llllllllllllllllIIlIIlIIIIlllIll */
        //    60: invokevirtual   net/minecraft/crash/CrashReportCategory.addCrashSection:(Ljava/lang/String;Ljava/lang/Object;)V
        //    63: new             Lnet/minecraft/util/ReportedException;
        //    66: dup            
        //    67: aload           llllllllllllllllIIlIIlIIIIlllllI
        //    69: invokespecial   net/minecraft/util/ReportedException.<init>:(Lnet/minecraft/crash/CrashReport;)V
        //    72: athrow         
        //    73: aload_0         /* llllllllllllllllIIlIIlIIIIllllII */
        //    74: getfield        net/minecraft/network/datasync/EntityDataManager.lock:Ljava/util/concurrent/locks/ReadWriteLock;
        //    77: invokeinterface java/util/concurrent/locks/ReadWriteLock.readLock:()Ljava/util/concurrent/locks/Lock;
        //    82: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    87: aload_2         /* llllllllllllllllIIlIIlIIIlIIIIII */
        //    88: areturn        
        //    Signature:
        //  <T:Ljava/lang/Object;>(Lnet/minecraft/network/datasync/DataParameter<TT;>;)Lnet/minecraft/network/datasync/EntityDataManager$DataEntry<TT;>;
        //    StackMapTable: 00 02 65 07 00 82 FC 00 23 07 00 06
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  14     34     37     73     Ljava/lang/Throwable;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public <T> T get(final DataParameter<T> llllllllllllllllIIlIIlIIIIllIIIl) {
        return this.getEntry(llllllllllllllllIIlIIlIIIIllIIIl).getValue();
    }
    
    public boolean isEmpty() {
        return this.empty;
    }
    
    protected <T> void setEntryValue(final DataEntry<T> llllllllllllllllIIlIIIlllIllllII, final DataEntry<?> llllllllllllllllIIlIIIlllIllllIl) {
        llllllllllllllllIIlIIIlllIllllII.setValue((T)llllllllllllllllIIlIIIlllIllllIl.getValue());
    }
    
    @Nullable
    public static List<DataEntry<?>> readEntries(final PacketBuffer llllllllllllllllIIlIIIllllIllIlI) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_1        /* llllllllllllllllIIlIIIllllIlIIll */
        //     2: goto            83
        //     5: aload_1         /* llllllllllllllllIIlIIIllllIllIIl */
        //     6: ifnonnull       13
        //     9: invokestatic    com/google/common/collect/Lists.newArrayList:()Ljava/util/ArrayList;
        //    12: astore_1        /* llllllllllllllllIIlIIIllllIllIIl */
        //    13: aload_0         /* llllllllllllllllIIlIIIllllIlIlII */
        //    14: invokevirtual   net/minecraft/network/PacketBuffer.readVarIntFromBuffer:()I
        //    17: istore_3        /* llllllllllllllllIIlIIIllllIlIIIl */
        //    18: iload_3         /* llllllllllllllllIIlIIIllllIlIllI */
        //    19: invokestatic    net/minecraft/network/datasync/DataSerializers.getSerializer:(I)Lnet/minecraft/network/datasync/DataSerializer;
        //    22: astore          llllllllllllllllIIlIIIllllIlIlIl
        //    24: aload           llllllllllllllllIIlIIIllllIlIlIl
        //    26: ifnonnull       53
        //    29: new             Lio/netty/handler/codec/DecoderException;
        //    32: dup            
        //    33: new             Ljava/lang/StringBuilder;
        //    36: dup            
        //    37: ldc             "Unknown serializer type "
        //    39: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    42: iload_3         /* llllllllllllllllIIlIIIllllIlIllI */
        //    43: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    46: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    49: invokespecial   io/netty/handler/codec/DecoderException.<init>:(Ljava/lang/String;)V
        //    52: athrow         
        //    53: aload_1         /* llllllllllllllllIIlIIIllllIllIIl */
        //    54: new             Lnet/minecraft/network/datasync/EntityDataManager$DataEntry;
        //    57: dup            
        //    58: aload           llllllllllllllllIIlIIIllllIlIlIl
        //    60: iload_2         /* llllllllllllllllIIlIIIllllIllIII */
        //    61: invokeinterface net/minecraft/network/datasync/DataSerializer.createKey:(I)Lnet/minecraft/network/datasync/DataParameter;
        //    66: aload           llllllllllllllllIIlIIIllllIlIlIl
        //    68: aload_0         /* llllllllllllllllIIlIIIllllIlIlII */
        //    69: invokeinterface net/minecraft/network/datasync/DataSerializer.read:(Lnet/minecraft/network/PacketBuffer;)Ljava/lang/Object;
        //    74: invokespecial   net/minecraft/network/datasync/EntityDataManager$DataEntry.<init>:(Lnet/minecraft/network/datasync/DataParameter;Ljava/lang/Object;)V
        //    77: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //    82: pop            
        //    83: aload_0         /* llllllllllllllllIIlIIIllllIlIlII */
        //    84: invokevirtual   net/minecraft/network/PacketBuffer.readUnsignedByte:()S
        //    87: dup            
        //    88: istore_2        /* llllllllllllllllIIlIIIllllIlIIlI */
        //    89: sipush          255
        //    92: if_icmpne       5
        //    95: aload_1         /* llllllllllllllllIIlIIIllllIllIIl */
        //    96: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    Signature:
        //  (Lnet/minecraft/network/PacketBuffer;)Ljava/util/List<Lnet/minecraft/network/datasync/EntityDataManager$DataEntry<*>;>;
        //    RuntimeVisibleTypeAnnotations: 00 01 14 00 00 CF 00 00
        //    StackMapTable: 00 04 FD 00 05 07 01 19 01 07 FD 00 27 01 07 00 F5 F8 00 1D
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public boolean isDirty() {
        return this.dirty;
    }
    
    public <T> void register(final DataParameter<T> llllllllllllllllIIlIIlIIIlIllIII, final T llllllllllllllllIIlIIlIIIlIllIll) {
        final int llllllllllllllllIIlIIlIIIlIllIlI = llllllllllllllllIIlIIlIIIlIllIII.getId();
        if (llllllllllllllllIIlIIlIIIlIllIlI > 254) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Data value id is too big with ").append(llllllllllllllllIIlIIlIIIlIllIlI).append("! (Max is ").append(254).append(")")));
        }
        if (this.entries.containsKey(llllllllllllllllIIlIIlIIIlIllIlI)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Duplicate id value for ").append(llllllllllllllllIIlIIlIIIlIllIlI).append("!")));
        }
        if (DataSerializers.getSerializerId(llllllllllllllllIIlIIlIIIlIllIII.getSerializer()) < 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Unregistered serializer ").append(llllllllllllllllIIlIIlIIIlIllIII.getSerializer()).append(" for ").append(llllllllllllllllIIlIIlIIIlIllIlI).append("!")));
        }
        this.setEntry((DataParameter<Object>)llllllllllllllllIIlIIlIIIlIllIII, llllllllllllllllIIlIIlIIIlIllIll);
    }
    
    public void setEntryValues(final List<DataEntry<?>> llllllllllllllllIIlIIIllllIIIlIl) {
        this.lock.writeLock().lock();
        for (final DataEntry<?> llllllllllllllllIIlIIIllllIIlIII : llllllllllllllllIIlIIIllllIIIlIl) {
            final DataEntry<?> llllllllllllllllIIlIIIllllIIIlll = this.entries.get(llllllllllllllllIIlIIIllllIIlIII.getKey().getId());
            if (llllllllllllllllIIlIIIllllIIIlll != null) {
                this.setEntryValue(llllllllllllllllIIlIIIllllIIIlll, llllllllllllllllIIlIIIllllIIlIII);
                this.entity.notifyDataManagerChange(llllllllllllllllIIlIIIllllIIlIII.getKey());
            }
        }
        this.lock.writeLock().unlock();
        this.dirty = true;
    }
    
    public static <T> DataParameter<T> createKey(final Class<? extends Entity> llllllllllllllllIIlIIlIIIllIllIl, final DataSerializer<T> llllllllllllllllIIlIIlIIIllIIlIl) {
        if (EntityDataManager.LOGGER.isDebugEnabled()) {
            try {
                final Class<?> llllllllllllllllIIlIIlIIIllIlIll = Class.forName(Thread.currentThread().getStackTrace()[2].getClassName());
                if (!llllllllllllllllIIlIIlIIIllIlIll.equals(llllllllllllllllIIlIIlIIIllIllIl)) {
                    EntityDataManager.LOGGER.debug("defineId called for: {} from {}", (Object)llllllllllllllllIIlIIlIIIllIllIl, (Object)llllllllllllllllIIlIIlIIIllIlIll, (Object)new RuntimeException());
                }
            }
            catch (ClassNotFoundException ex) {}
        }
        int llllllllllllllllIIlIIlIIIllIlIIl = 0;
        if (EntityDataManager.NEXT_ID_MAP.containsKey(llllllllllllllllIIlIIlIIIllIllIl)) {
            final int llllllllllllllllIIlIIlIIIllIlIlI = EntityDataManager.NEXT_ID_MAP.get(llllllllllllllllIIlIIlIIIllIllIl) + 1;
        }
        else {
            int llllllllllllllllIIlIIlIIIllIlIII = 0;
            Class<?> llllllllllllllllIIlIIlIIIllIIlll = llllllllllllllllIIlIIlIIIllIllIl;
            while (llllllllllllllllIIlIIlIIIllIIlll != Entity.class) {
                llllllllllllllllIIlIIlIIIllIIlll = llllllllllllllllIIlIIlIIIllIIlll.getSuperclass();
                if (EntityDataManager.NEXT_ID_MAP.containsKey(llllllllllllllllIIlIIlIIIllIIlll)) {
                    llllllllllllllllIIlIIlIIIllIlIII = EntityDataManager.NEXT_ID_MAP.get(llllllllllllllllIIlIIlIIIllIIlll) + 1;
                    break;
                }
            }
            llllllllllllllllIIlIIlIIIllIlIIl = llllllllllllllllIIlIIlIIIllIlIII;
        }
        if (llllllllllllllllIIlIIlIIIllIlIIl > 254) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Data value id is too big with ").append(llllllllllllllllIIlIIlIIIllIlIIl).append("! (Max is ").append(254).append(")")));
        }
        EntityDataManager.NEXT_ID_MAP.put(llllllllllllllllIIlIIlIIIllIllIl, llllllllllllllllIIlIIlIIIllIlIIl);
        return llllllllllllllllIIlIIlIIIllIIlIl.createKey(llllllllllllllllIIlIIlIIIllIlIIl);
    }
    
    @Nullable
    public List<DataEntry<?>> getDirty() {
        List<DataEntry<?>> llllllllllllllllIIlIIlIIIIIIIlll = null;
        if (this.dirty) {
            this.lock.readLock().lock();
            for (final DataEntry<?> llllllllllllllllIIlIIlIIIIIIIllI : this.entries.values()) {
                if (llllllllllllllllIIlIIlIIIIIIIllI.isDirty()) {
                    llllllllllllllllIIlIIlIIIIIIIllI.setDirty(false);
                    if (llllllllllllllllIIlIIlIIIIIIIlll == null) {
                        llllllllllllllllIIlIIlIIIIIIIlll = (List<DataEntry<?>>)Lists.newArrayList();
                    }
                    llllllllllllllllIIlIIlIIIIIIIlll.add(llllllllllllllllIIlIIlIIIIIIIllI.func_192735_d());
                }
            }
            this.lock.readLock().unlock();
        }
        this.dirty = false;
        return llllllllllllllllIIlIIlIIIIIIIlll;
    }
    
    public void writeEntries(final PacketBuffer llllllllllllllllIIlIIIlllllllIIl) throws IOException {
        this.lock.readLock().lock();
        for (final DataEntry<?> llllllllllllllllIIlIIIlllllllIll : this.entries.values()) {
            writeEntry(llllllllllllllllIIlIIIlllllllIIl, llllllllllllllllIIlIIIlllllllIll);
        }
        this.lock.readLock().unlock();
        llllllllllllllllIIlIIIlllllllIIl.writeByte(255);
    }
    
    public EntityDataManager(final Entity llllllllllllllllIIlIIlIIIlllIlIl) {
        this.entries = (Map<Integer, DataEntry<?>>)Maps.newHashMap();
        this.lock = new ReentrantReadWriteLock();
        this.empty = true;
        this.entity = llllllllllllllllIIlIIlIIIlllIlIl;
    }
    
    public <T> void setDirty(final DataParameter<T> llllllllllllllllIIlIIlIIIIIlllll) {
        DataEntry.access$0((DataEntry<Object>)this.getEntry(llllllllllllllllIIlIIlIIIIIlllll), true);
        this.dirty = true;
    }
    
    @Nullable
    public List<DataEntry<?>> getAll() {
        List<DataEntry<?>> llllllllllllllllIIlIIIllllllIIIl = null;
        this.lock.readLock().lock();
        for (final DataEntry<?> llllllllllllllllIIlIIIllllllIIII : this.entries.values()) {
            if (llllllllllllllllIIlIIIllllllIIIl == null) {
                llllllllllllllllIIlIIIllllllIIIl = (List<DataEntry<?>>)Lists.newArrayList();
            }
            llllllllllllllllIIlIIIllllllIIIl.add(llllllllllllllllIIlIIIllllllIIII.func_192735_d());
        }
        this.lock.readLock().unlock();
        return llllllllllllllllIIlIIIllllllIIIl;
    }
    
    public static void writeEntries(final List<DataEntry<?>> llllllllllllllllIIlIIlIIIIIlIllI, final PacketBuffer llllllllllllllllIIlIIlIIIIIlIlIl) throws IOException {
        if (llllllllllllllllIIlIIlIIIIIlIllI != null) {
            for (int llllllllllllllllIIlIIlIIIIIlIlII = 0, llllllllllllllllIIlIIlIIIIIlIIll = llllllllllllllllIIlIIlIIIIIlIllI.size(); llllllllllllllllIIlIIlIIIIIlIlII < llllllllllllllllIIlIIlIIIIIlIIll; ++llllllllllllllllIIlIIlIIIIIlIlII) {
                final DataEntry<?> llllllllllllllllIIlIIlIIIIIlIIlI = llllllllllllllllIIlIIlIIIIIlIllI.get(llllllllllllllllIIlIIlIIIIIlIlII);
                writeEntry(llllllllllllllllIIlIIlIIIIIlIlIl, llllllllllllllllIIlIIlIIIIIlIIlI);
            }
        }
        llllllllllllllllIIlIIlIIIIIlIlIl.writeByte(255);
    }
    
    public void setClean() {
        this.dirty = false;
        this.lock.readLock().lock();
        for (final DataEntry<?> llllllllllllllllIIlIIIlllIllIIll : this.entries.values()) {
            llllllllllllllllIIlIIIlllIllIIll.setDirty(false);
        }
        this.lock.readLock().unlock();
    }
    
    static {
        LOGGER = LogManager.getLogger();
        NEXT_ID_MAP = Maps.newHashMap();
    }
    
    private static <T> void writeEntry(final PacketBuffer llllllllllllllllIIlIIIlllllIIlll, final DataEntry<T> llllllllllllllllIIlIIIlllllIIIlI) throws IOException {
        final DataParameter<T> llllllllllllllllIIlIIIlllllIIlIl = llllllllllllllllIIlIIIlllllIIIlI.getKey();
        final int llllllllllllllllIIlIIIlllllIIlII = DataSerializers.getSerializerId(llllllllllllllllIIlIIIlllllIIlIl.getSerializer());
        if (llllllllllllllllIIlIIIlllllIIlII < 0) {
            throw new EncoderException(String.valueOf(new StringBuilder("Unknown serializer type ").append(llllllllllllllllIIlIIIlllllIIlIl.getSerializer())));
        }
        llllllllllllllllIIlIIIlllllIIlll.writeByte(llllllllllllllllIIlIIIlllllIIlIl.getId());
        llllllllllllllllIIlIIIlllllIIlll.writeVarIntToBuffer(llllllllllllllllIIlIIIlllllIIlII);
        llllllllllllllllIIlIIIlllllIIlIl.getSerializer().write(llllllllllllllllIIlIIIlllllIIlll, llllllllllllllllIIlIIIlllllIIIlI.getValue());
    }
    
    public static class DataEntry<T>
    {
        private /* synthetic */ T value;
        private /* synthetic */ boolean dirty;
        private final /* synthetic */ DataParameter<T> key;
        
        public DataEntry<T> func_192735_d() {
            return new DataEntry<T>(this.key, this.key.getSerializer().func_192717_a(this.value));
        }
        
        public T getValue() {
            return this.value;
        }
        
        public DataParameter<T> getKey() {
            return this.key;
        }
        
        public boolean isDirty() {
            return this.dirty;
        }
        
        static /* synthetic */ void access$0(final DataEntry lllllllllllllIIlIIIlIIIIlIlIlIIl, final boolean lllllllllllllIIlIIIlIIIIlIlIlIII) {
            lllllllllllllIIlIIIlIIIIlIlIlIIl.dirty = lllllllllllllIIlIIIlIIIIlIlIlIII;
        }
        
        public void setValue(final T lllllllllllllIIlIIIlIIIIlIllllIl) {
            this.value = lllllllllllllIIlIIIlIIIIlIllllIl;
        }
        
        public void setDirty(final boolean lllllllllllllIIlIIIlIIIIlIlIllll) {
            this.dirty = lllllllllllllIIlIIIlIIIIlIlIllll;
        }
        
        public DataEntry(final DataParameter<T> lllllllllllllIIlIIIlIIIIllIIlIII, final T lllllllllllllIIlIIIlIIIIllIIIlll) {
            this.key = lllllllllllllIIlIIIlIIIIllIIlIII;
            this.value = lllllllllllllIIlIIIlIIIIllIIIlll;
            this.dirty = true;
        }
    }
}
