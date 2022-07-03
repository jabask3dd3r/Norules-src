package com.viaversion.viaversion.protocol;

import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.api.protocol.*;
import com.google.common.collect.*;
import com.viaversion.viaversion.api.*;
import java.util.concurrent.locks.*;
import com.google.common.util.concurrent.*;
import com.viaversion.viaversion.api.protocol.version.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.protocols.protocol1_9_1to1_9.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_9_1.*;
import com.viaversion.viaversion.protocols.protocol1_9_1_2to1_9_3_4.*;
import com.viaversion.viaversion.protocols.protocol1_10to1_9_3.*;
import com.viaversion.viaversion.protocols.protocol1_11to1_10.*;
import com.viaversion.viaversion.protocols.protocol1_11_1to1_11.*;
import com.viaversion.viaversion.protocols.protocol1_12to1_11_1.*;
import com.viaversion.viaversion.protocols.protocol1_12_1to1_12.*;
import com.viaversion.viaversion.protocols.protocol1_12_2to1_12_1.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.protocols.protocol1_13_1to1_13.*;
import com.viaversion.viaversion.protocols.protocol1_13_2to1_13_1.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.*;
import com.viaversion.viaversion.protocols.protocol1_14_1to1_14.*;
import com.viaversion.viaversion.protocols.protocol1_14_2to1_14_1.*;
import com.viaversion.viaversion.protocols.protocol1_14_3to1_14_2.*;
import com.viaversion.viaversion.protocols.protocol1_14_4to1_14_3.*;
import com.viaversion.viaversion.protocols.protocol1_15to1_14_4.*;
import com.viaversion.viaversion.protocols.protocol1_15_1to1_15.*;
import com.viaversion.viaversion.protocols.protocol1_15_2to1_15_1.*;
import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.*;
import com.viaversion.viaversion.protocols.protocol1_16_1to1_16.*;
import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.*;
import com.viaversion.viaversion.protocols.protocol1_16_3to1_16_2.*;
import com.viaversion.viaversion.protocols.protocol1_16_4to1_16_3.*;
import com.viaversion.viaversion.protocols.protocol1_17to1_16_4.*;
import com.viaversion.viaversion.protocols.protocol1_17_1to1_17.*;
import us.myles.ViaVersion.api.protocol.*;
import com.google.common.base.*;
import java.util.function.*;
import com.viaversion.viaversion.protocols.base.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import java.util.concurrent.*;
import com.viaversion.viaversion.api.data.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import java.util.*;

public class ProtocolManagerImpl implements ProtocolManager
{
    private static final /* synthetic */ Protocol BASE_PROTOCOL;
    private /* synthetic */ ThreadPoolExecutor mappingLoaderExecutor;
    private final /* synthetic */ ReadWriteLock mappingLoaderLock;
    private final /* synthetic */ List<Pair<Range<Integer>, Protocol>> baseProtocols;
    private final /* synthetic */ Map<Class<? extends Protocol>, Protocol> protocols;
    private /* synthetic */ Map<Class<? extends Protocol>, CompletableFuture<Void>> mappingLoaderFutures;
    private final /* synthetic */ Set<Integer> supportedVersions;
    private /* synthetic */ boolean mappingsLoaded;
    private final /* synthetic */ List<Protocol> registerList;
    private /* synthetic */ boolean onlyCheckLoweringPathEntries;
    private final /* synthetic */ Int2ObjectMap<Int2ObjectMap<Protocol>> registryMap;
    private final /* synthetic */ Map<ProtocolPathKey, List<ProtocolPathEntry>> pathCache;
    private /* synthetic */ ServerProtocolVersion serverProtocolVersion;
    private /* synthetic */ int maxProtocolPathSize;
    
    @Override
    public SortedSet<Integer> getSupportedVersions() {
        return Collections.unmodifiableSortedSet(new TreeSet<Integer>(this.supportedVersions));
    }
    
    @Override
    public void setOnlyCheckLoweringPathEntries(final boolean lllllllllllllIIIlIIIllIIIlllllll) {
        this.onlyCheckLoweringPathEntries = lllllllllllllIIIlIIIllIIIlllllll;
    }
    
    @Override
    public Protocol getBaseProtocol(final int lllllllllllllIIIlIIIllIIlIllllll) {
        for (final Pair<Range<Integer>, Protocol> lllllllllllllIIIlIIIllIIllIIIIIl : Lists.reverse((List)this.baseProtocols)) {
            if (lllllllllllllIIIlIIIllIIllIIIIIl.getKey().contains((Comparable)lllllllllllllIIIlIIIllIIlIllllll)) {
                return lllllllllllllIIIlIIIllIIllIIIIIl.getValue();
            }
        }
        throw new IllegalStateException(String.valueOf(new StringBuilder().append("No Base Protocol for ").append(lllllllllllllIIIlIIIllIIlIllllll)));
    }
    
    public void onServerLoaded() {
        for (final Protocol lllllllllllllIIIlIIIllIIIIIIlIlI : this.registerList) {
            lllllllllllllIIIlIIIllIIIIIIlIlI.register(Via.getManager().getProviders());
        }
        this.registerList.clear();
    }
    
    public ProtocolManagerImpl() {
        this.registryMap = new Int2ObjectOpenHashMap<Int2ObjectMap<Protocol>>(32);
        this.protocols = new HashMap<Class<? extends Protocol>, Protocol>();
        this.pathCache = new ConcurrentHashMap<ProtocolPathKey, List<ProtocolPathEntry>>();
        this.supportedVersions = new HashSet<Integer>();
        this.baseProtocols = (List<Pair<Range<Integer>, Protocol>>)Lists.newCopyOnWriteArrayList();
        this.registerList = new ArrayList<Protocol>();
        this.mappingLoaderLock = new ReentrantReadWriteLock();
        this.mappingLoaderFutures = new HashMap<Class<? extends Protocol>, CompletableFuture<Void>>();
        this.serverProtocolVersion = new ServerProtocolVersionSingleton(-1);
        this.onlyCheckLoweringPathEntries = true;
        this.maxProtocolPathSize = 50;
        final ThreadFactory lllllllllllllIIIlIIIllIlllIllIII = new ThreadFactoryBuilder().setNameFormat("Via-Mappingloader-%d").build();
        this.mappingLoaderExecutor = new ThreadPoolExecutor(5, 16, 45L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), lllllllllllllIIIlIIIllIlllIllIII);
        this.mappingLoaderExecutor.allowCoreThreadTimeOut(true);
    }
    
    public void registerProtocols() {
        this.registerBaseProtocol(ProtocolManagerImpl.BASE_PROTOCOL, (Range<Integer>)Range.lessThan((Comparable)Integer.MIN_VALUE));
        this.registerBaseProtocol(new BaseProtocol1_7(), (Range<Integer>)Range.lessThan((Comparable)ProtocolVersion.v1_16.getVersion()));
        this.registerBaseProtocol(new BaseProtocol1_16(), (Range<Integer>)Range.atLeast((Comparable)ProtocolVersion.v1_16.getVersion()));
        this.registerProtocol(new Protocol1_9To1_8(), ProtocolVersion.v1_9, ProtocolVersion.v1_8);
        this.registerProtocol(new Protocol1_9_1To1_9(), Arrays.asList(ProtocolVersion.v1_9_1.getVersion(), ProtocolVersion.v1_9_2.getVersion()), ProtocolVersion.v1_9.getVersion());
        this.registerProtocol(new Protocol1_9_3To1_9_1_2(), ProtocolVersion.v1_9_3, ProtocolVersion.v1_9_2);
        this.registerProtocol(new Protocol1_9To1_9_1(), ProtocolVersion.v1_9, ProtocolVersion.v1_9_1);
        this.registerProtocol(new Protocol1_9_1_2To1_9_3_4(), Arrays.asList(ProtocolVersion.v1_9_1.getVersion(), ProtocolVersion.v1_9_2.getVersion()), ProtocolVersion.v1_9_3.getVersion());
        this.registerProtocol(new Protocol1_10To1_9_3_4(), ProtocolVersion.v1_10, ProtocolVersion.v1_9_3);
        this.registerProtocol(new Protocol1_11To1_10(), ProtocolVersion.v1_11, ProtocolVersion.v1_10);
        this.registerProtocol(new Protocol1_11_1To1_11(), ProtocolVersion.v1_11_1, ProtocolVersion.v1_11);
        this.registerProtocol(new Protocol1_12To1_11_1(), ProtocolVersion.v1_12, ProtocolVersion.v1_11_1);
        this.registerProtocol(new Protocol1_12_1To1_12(), ProtocolVersion.v1_12_1, ProtocolVersion.v1_12);
        this.registerProtocol(new Protocol1_12_2To1_12_1(), ProtocolVersion.v1_12_2, ProtocolVersion.v1_12_1);
        this.registerProtocol(new Protocol1_13To1_12_2(), ProtocolVersion.v1_13, ProtocolVersion.v1_12_2);
        this.registerProtocol(new Protocol1_13_1To1_13(), ProtocolVersion.v1_13_1, ProtocolVersion.v1_13);
        this.registerProtocol(new Protocol1_13_2To1_13_1(), ProtocolVersion.v1_13_2, ProtocolVersion.v1_13_1);
        this.registerProtocol(new Protocol1_14To1_13_2(), ProtocolVersion.v1_14, ProtocolVersion.v1_13_2);
        this.registerProtocol(new Protocol1_14_1To1_14(), ProtocolVersion.v1_14_1, ProtocolVersion.v1_14);
        this.registerProtocol(new Protocol1_14_2To1_14_1(), ProtocolVersion.v1_14_2, ProtocolVersion.v1_14_1);
        this.registerProtocol(new Protocol1_14_3To1_14_2(), ProtocolVersion.v1_14_3, ProtocolVersion.v1_14_2);
        this.registerProtocol(new Protocol1_14_4To1_14_3(), ProtocolVersion.v1_14_4, ProtocolVersion.v1_14_3);
        this.registerProtocol(new Protocol1_15To1_14_4(), ProtocolVersion.v1_15, ProtocolVersion.v1_14_4);
        this.registerProtocol(new Protocol1_15_1To1_15(), ProtocolVersion.v1_15_1, ProtocolVersion.v1_15);
        this.registerProtocol(new Protocol1_15_2To1_15_1(), ProtocolVersion.v1_15_2, ProtocolVersion.v1_15_1);
        this.registerProtocol(new Protocol1_16To1_15_2(), ProtocolVersion.v1_16, ProtocolVersion.v1_15_2);
        this.registerProtocol(new Protocol1_16_1To1_16(), ProtocolVersion.v1_16_1, ProtocolVersion.v1_16);
        this.registerProtocol(new Protocol1_16_2To1_16_1(), ProtocolVersion.v1_16_2, ProtocolVersion.v1_16_1);
        this.registerProtocol(new Protocol1_16_3To1_16_2(), ProtocolVersion.v1_16_3, ProtocolVersion.v1_16_2);
        this.registerProtocol(new Protocol1_16_4To1_16_3(), ProtocolVersion.v1_16_4, ProtocolVersion.v1_16_3);
        this.registerProtocol(new Protocol1_17To1_16_4(), ProtocolVersion.v1_17, ProtocolVersion.v1_16_4);
        this.registerProtocol(new Protocol1_17_1To1_17(), ProtocolVersion.v1_17_1, ProtocolVersion.v1_17);
    }
    
    @Override
    public <T extends Protocol> T getProtocol(final Class<T> lllllllllllllIIIlIIIllIIlllIIIll) {
        return (T)this.protocols.get(lllllllllllllIIIlIIIllIIlllIIIll);
    }
    
    public void setServerProtocol(final ServerProtocolVersion lllllllllllllIIIlIIIllIIlIlIlIII) {
        this.serverProtocolVersion = lllllllllllllIIIlIIIllIIlIlIlIII;
        ProtocolRegistry.SERVER_PROTOCOL = lllllllllllllIIIlIIIllIIlIlIlIII.lowestSupportedVersion();
    }
    
    @Override
    public void registerProtocol(final Protocol lllllllllllllIIIlIIIllIllIIlIlII, final List<Integer> lllllllllllllIIIlIIIllIllIIlIIll, final int lllllllllllllIIIlIIIllIllIIlIIlI) {
        lllllllllllllIIIlIIIllIllIIlIlII.initialize();
        if (!this.pathCache.isEmpty()) {
            this.pathCache.clear();
        }
        this.protocols.put(lllllllllllllIIIlIIIllIllIIlIlII.getClass(), lllllllllllllIIIlIIIllIllIIlIlII);
        for (final int lllllllllllllIIIlIIIllIllIIllllI : lllllllllllllIIIlIIIllIllIIlIIll) {
            Preconditions.checkArgument(lllllllllllllIIIlIIIllIllIIllllI != lllllllllllllIIIlIIIllIllIIlIIlI);
            final Int2ObjectMap<Protocol> lllllllllllllIIIlIIIllIllIIlllll = this.registryMap.computeIfAbsent(lllllllllllllIIIlIIIllIllIIllllI, lllllllllllllIIIlIIIlIllllllIIll -> new Int2ObjectOpenHashMap(2));
            lllllllllllllIIIlIIIllIllIIlllll.put(lllllllllllllIIIlIIIllIllIIlIIlI, lllllllllllllIIIlIIIllIllIIlIlII);
        }
        if (Via.getPlatform().isPluginEnabled()) {
            lllllllllllllIIIlIIIllIllIIlIlII.register(Via.getManager().getProviders());
            this.refreshVersions();
        }
        else {
            this.registerList.add(lllllllllllllIIIlIIIllIllIIlIlII);
        }
        if (lllllllllllllIIIlIIIllIllIIlIlII.hasMappingDataToLoad()) {
            if (this.mappingLoaderExecutor != null) {
                final Class<? extends Protocol> class1 = lllllllllllllIIIlIIIllIllIIlIlII.getClass();
                Objects.requireNonNull(lllllllllllllIIIlIIIllIllIIlIlII);
                this.addMappingLoaderFuture(class1, lllllllllllllIIIlIIIllIllIIlIlII::loadMappingData);
            }
            else {
                lllllllllllllIIIlIIIllIllIIlIlII.loadMappingData();
            }
        }
    }
    
    @Override
    public boolean onlyCheckLoweringPathEntries() {
        return this.onlyCheckLoweringPathEntries;
    }
    
    @Override
    public void completeMappingDataLoading(final Class<? extends Protocol> lllllllllllllIIIlIIIllIIIlIllIll) throws Exception {
        if (this.mappingsLoaded) {
            return;
        }
        final CompletableFuture<Void> lllllllllllllIIIlIIIllIIIlIllIlI = this.getMappingLoaderFuture(lllllllllllllIIIlIIIllIIIlIllIll);
        if (lllllllllllllIIIlIIIllIIIlIllIlI != null) {
            lllllllllllllIIIlIIIllIIIlIllIlI.get();
        }
    }
    
    @Override
    public void registerProtocol(final Protocol lllllllllllllIIIlIIIllIllIlllIlI, final ProtocolVersion lllllllllllllIIIlIIIllIllIllIlll, final ProtocolVersion lllllllllllllIIIlIIIllIllIllllIl) {
        this.registerProtocol(lllllllllllllIIIlIIIllIllIlllIlI, Collections.singletonList(lllllllllllllIIIlIIIllIllIllIlll.getVersion()), lllllllllllllIIIlIIIllIllIllllIl.getVersion());
    }
    
    private Function<Throwable, Void> mappingLoaderThrowable(final Class<? extends Protocol> lllllllllllllIIIlIIIlIllllllllll) {
        return (Function<Throwable, Void>)(lllllllllllllIIIlIIIlIlllllllIll -> {
            Via.getPlatform().getLogger().severe(String.valueOf(new StringBuilder().append("Error during mapping loading of ").append(lllllllllllllIIIlIIIlIllllllllll.getSimpleName())));
            lllllllllllllIIIlIIIlIlllllllIll.printStackTrace();
            return null;
        });
    }
    
    @Override
    public boolean isWorkingPipe() {
        for (final Int2ObjectMap<Protocol> lllllllllllllIIIlIIIllIIlIIlIlIl : this.registryMap.values()) {
            for (final int lllllllllllllIIIlIIIllIIlIIlIlll : this.serverProtocolVersion.supportedVersions()) {
                if (lllllllllllllIIIlIIIllIIlIIlIlIl.containsKey(lllllllllllllIIIlIIIllIIlIIlIlll)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    static {
        BASE_PROTOCOL = new BaseProtocol();
    }
    
    @Override
    public void registerBaseProtocol(final Protocol lllllllllllllIIIlIIIllIllIIIIIIl, final Range<Integer> lllllllllllllIIIlIIIllIlIlllllIl) {
        Preconditions.checkArgument(lllllllllllllIIIlIIIllIllIIIIIIl.isBaseProtocol(), (Object)"Protocol is not a base protocol");
        lllllllllllllIIIlIIIllIllIIIIIIl.initialize();
        this.baseProtocols.add(new Pair<Range<Integer>, Protocol>(lllllllllllllIIIlIIIllIlIlllllIl, lllllllllllllIIIlIIIllIllIIIIIIl));
        if (Via.getPlatform().isPluginEnabled()) {
            lllllllllllllIIIlIIIllIllIIIIIIl.register(Via.getManager().getProviders());
            this.refreshVersions();
        }
        else {
            this.registerList.add(lllllllllllllIIIlIIIllIllIIIIIIl);
        }
    }
    
    @Override
    public List<ProtocolPathEntry> getProtocolPath(final int lllllllllllllIIIlIIIllIlIlIIIlll, final int lllllllllllllIIIlIIIllIlIIllllIl) {
        if (lllllllllllllIIIlIIIllIlIlIIIlll == lllllllllllllIIIlIIIllIlIIllllIl) {
            return null;
        }
        final ProtocolPathKey lllllllllllllIIIlIIIllIlIlIIIlIl = new ProtocolPathKeyImpl(lllllllllllllIIIlIIIllIlIlIIIlll, lllllllllllllIIIlIIIllIlIIllllIl);
        final List<ProtocolPathEntry> lllllllllllllIIIlIIIllIlIlIIIlII = this.pathCache.get(lllllllllllllIIIlIIIllIlIlIIIlIl);
        if (lllllllllllllIIIlIIIllIlIlIIIlII != null) {
            return lllllllllllllIIIlIIIllIlIlIIIlII;
        }
        final Int2ObjectSortedMap<Protocol> lllllllllllllIIIlIIIllIlIlIIIIll = this.getProtocolPath(new Int2ObjectLinkedOpenHashMap<Protocol>(), lllllllllllllIIIlIIIllIlIlIIIlll, lllllllllllllIIIlIIIllIlIIllllIl);
        if (lllllllllllllIIIlIIIllIlIlIIIIll == null) {
            return null;
        }
        final List<ProtocolPathEntry> lllllllllllllIIIlIIIllIlIlIIIIlI = new ArrayList<ProtocolPathEntry>(lllllllllllllIIIlIIIllIlIlIIIIll.size());
        for (final Int2ObjectMap.Entry<Protocol> lllllllllllllIIIlIIIllIlIlIIlIIl : lllllllllllllIIIlIIIllIlIlIIIIll.int2ObjectEntrySet()) {
            lllllllllllllIIIlIIIllIlIlIIIIlI.add(new ProtocolPathEntryImpl(lllllllllllllIIIlIIIllIlIlIIlIIl.getIntKey(), lllllllllllllIIIlIIIllIlIlIIlIIl.getValue()));
        }
        this.pathCache.put(lllllllllllllIIIlIIIllIlIlIIIlIl, lllllllllllllIIIlIIIllIlIlIIIIlI);
        return lllllllllllllIIIlIIIllIlIlIIIIlI;
    }
    
    private Int2ObjectSortedMap<Protocol> getProtocolPath(final Int2ObjectSortedMap<Protocol> lllllllllllllIIIlIIIllIlIIIIIlII, final int lllllllllllllIIIlIIIllIlIIIIIIlI, final int lllllllllllllIIIlIIIllIlIIIIIIIl) {
        if (lllllllllllllIIIlIIIllIlIIIIIlII.size() > this.maxProtocolPathSize) {
            return null;
        }
        final Int2ObjectMap<Protocol> lllllllllllllIIIlIIIllIlIIIIIIII = this.registryMap.get(lllllllllllllIIIlIIIllIlIIIIIIlI);
        if (lllllllllllllIIIlIIIllIlIIIIIIII == null) {
            return null;
        }
        final Protocol lllllllllllllIIIlIIIllIIllllllll = lllllllllllllIIIlIIIllIlIIIIIIII.get(lllllllllllllIIIlIIIllIlIIIIIIIl);
        if (lllllllllllllIIIlIIIllIIllllllll != null) {
            lllllllllllllIIIlIIIllIlIIIIIlII.put(lllllllllllllIIIlIIIllIlIIIIIIIl, lllllllllllllIIIlIIIllIIllllllll);
            return lllllllllllllIIIlIIIllIlIIIIIlII;
        }
        Int2ObjectSortedMap<Protocol> lllllllllllllIIIlIIIllIIlllllllI = null;
        for (final Int2ObjectMap.Entry<Protocol> lllllllllllllIIIlIIIllIlIIIIIllI : lllllllllllllIIIlIIIllIlIIIIIIII.int2ObjectEntrySet()) {
            final int lllllllllllllIIIlIIIllIlIIIIlIll = lllllllllllllIIIlIIIllIlIIIIIllI.getIntKey();
            if (lllllllllllllIIIlIIIllIlIIIIIlII.containsKey(lllllllllllllIIIlIIIllIlIIIIlIll)) {
                continue;
            }
            if (this.onlyCheckLoweringPathEntries && Math.abs(lllllllllllllIIIlIIIllIlIIIIIIIl - lllllllllllllIIIlIIIllIlIIIIlIll) > Math.abs(lllllllllllllIIIlIIIllIlIIIIIIIl - lllllllllllllIIIlIIIllIlIIIIIIlI)) {
                continue;
            }
            Int2ObjectSortedMap<Protocol> lllllllllllllIIIlIIIllIlIIIIlIII = new Int2ObjectLinkedOpenHashMap<Protocol>(lllllllllllllIIIlIIIllIlIIIIIlII);
            lllllllllllllIIIlIIIllIlIIIIlIII.put(lllllllllllllIIIlIIIllIlIIIIlIll, lllllllllllllIIIlIIIllIlIIIIIllI.getValue());
            lllllllllllllIIIlIIIllIlIIIIlIII = this.getProtocolPath(lllllllllllllIIIlIIIllIlIIIIlIII, lllllllllllllIIIlIIIllIlIIIIlIll, lllllllllllllIIIlIIIllIlIIIIIIIl);
            if (lllllllllllllIIIlIIIllIlIIIIlIII == null || (lllllllllllllIIIlIIIllIIlllllllI != null && lllllllllllllIIIlIIIllIlIIIIlIII.size() >= lllllllllllllIIIlIIIllIIlllllllI.size())) {
                continue;
            }
            lllllllllllllIIIlIIIllIIlllllllI = lllllllllllllIIIlIIIllIlIIIIlIII;
        }
        return lllllllllllllIIIlIIIllIIlllllllI;
    }
    
    @Override
    public void addMappingLoaderFuture(final Class<? extends Protocol> lllllllllllllIIIlIIIllIIIIllIlIl, final Class<? extends Protocol> lllllllllllllIIIlIIIllIIIIlIllll, final Runnable lllllllllllllIIIlIIIllIIIIllIIll) {
        final CompletableFuture<Void> lllllllllllllIIIlIIIllIIIIllIIlI = this.getMappingLoaderFuture(lllllllllllllIIIlIIIllIIIIlIllll).whenCompleteAsync((lllllllllllllIIIlIIIlIllllllIllI, lllllllllllllIIIlIIIlIllllllIlIl) -> lllllllllllllIIIlIIIllIIIIllIIll.run(), (Executor)this.mappingLoaderExecutor).exceptionally((Function<Throwable, ? extends Void>)this.mappingLoaderThrowable(lllllllllllllIIIlIIIllIIIIllIlIl));
        this.mappingLoaderLock.writeLock().lock();
        try {
            this.mappingLoaderFutures.put(lllllllllllllIIIlIIIllIIIIllIlIl, lllllllllllllIIIlIIIllIIIIllIIlI);
        }
        finally {
            this.mappingLoaderLock.writeLock().unlock();
        }
    }
    
    private void shutdownLoaderExecutor() {
        Preconditions.checkArgument(!this.mappingsLoaded);
        Via.getPlatform().getLogger().info("Finished mapping loading, shutting down loader executor!");
        this.mappingsLoaded = true;
        this.mappingLoaderExecutor.shutdown();
        this.mappingLoaderExecutor = null;
        this.mappingLoaderFutures.clear();
        this.mappingLoaderFutures = null;
        if (MappingDataLoader.isCacheJsonMappings()) {
            MappingDataLoader.getMappingsCache().clear();
        }
    }
    
    @Override
    public void addMappingLoaderFuture(final Class<? extends Protocol> lllllllllllllIIIlIIIllIIIlIIIIII, final Runnable lllllllllllllIIIlIIIllIIIIllllll) {
        final CompletableFuture<Void> lllllllllllllIIIlIIIllIIIlIIIIlI = CompletableFuture.runAsync(lllllllllllllIIIlIIIllIIIIllllll, this.mappingLoaderExecutor).exceptionally((Function<Throwable, ? extends Void>)this.mappingLoaderThrowable(lllllllllllllIIIlIIIllIIIlIIIIII));
        this.mappingLoaderLock.writeLock().lock();
        try {
            this.mappingLoaderFutures.put(lllllllllllllIIIlIIIllIIIlIIIIII, lllllllllllllIIIlIIIllIIIlIIIIlI);
        }
        finally {
            this.mappingLoaderLock.writeLock().unlock();
        }
    }
    
    @Deprecated
    @Override
    public PacketWrapper createPacketWrapper(final int lllllllllllllIIIlIIIllIIIIIlIIII, final ByteBuf lllllllllllllIIIlIIIllIIIIIlIIlI, final UserConnection lllllllllllllIIIlIIIllIIIIIIlllI) {
        return new PacketWrapperImpl(lllllllllllllIIIlIIIllIIIIIlIIII, lllllllllllllIIIlIIIllIIIIIlIIlI, lllllllllllllIIIlIIIllIIIIIIlllI);
    }
    
    @Override
    public Protocol getBaseProtocol() {
        return ProtocolManagerImpl.BASE_PROTOCOL;
    }
    
    @Override
    public <C extends ClientboundPacketType, S extends ServerboundPacketType> VersionedPacketTransformer<C, S> createPacketTransformer(final ProtocolVersion lllllllllllllIIIlIIIllIlIIlIllIl, final Class<C> lllllllllllllIIIlIIIllIlIIlIllII, final Class<S> lllllllllllllIIIlIIIllIlIIlIlllI) {
        Preconditions.checkArgument(lllllllllllllIIIlIIIllIlIIlIllII != ClientboundPacketType.class && lllllllllllllIIIlIIIllIlIIlIlllI != ServerboundPacketType.class);
        return new VersionedPacketTransformerImpl<C, S>(lllllllllllllIIIlIIIllIlIIlIllIl, lllllllllllllIIIlIIIllIlIIlIllII, lllllllllllllIIIlIIIllIlIIlIlllI);
    }
    
    @Override
    public PacketWrapper createPacketWrapper(final PacketType lllllllllllllIIIlIIIllIIIIIllIlI, final ByteBuf lllllllllllllIIIlIIIllIIIIIllIIl, final UserConnection lllllllllllllIIIlIIIllIIIIIllIII) {
        return new PacketWrapperImpl(lllllllllllllIIIlIIIllIIIIIllIlI, lllllllllllllIIIlIIIllIIIIIllIIl, lllllllllllllIIIlIIIllIIIIIllIII);
    }
    
    @Override
    public Protocol getProtocol(final int lllllllllllllIIIlIIIllIIllIIllIl, final int lllllllllllllIIIlIIIllIIllIlIllI) {
        final Int2ObjectMap<Protocol> lllllllllllllIIIlIIIllIIllIlIlII = this.registryMap.get(lllllllllllllIIIlIIIllIIllIIllIl);
        return (lllllllllllllIIIlIIIllIIllIlIlII != null) ? lllllllllllllIIIlIIIllIIllIlIlII.get(lllllllllllllIIIlIIIllIIllIlIllI) : null;
    }
    
    public void refreshVersions() {
        this.supportedVersions.clear();
        this.supportedVersions.add(this.serverProtocolVersion.lowestSupportedVersion());
        for (final ProtocolVersion lllllllllllllIIIlIIIllIlIllIlIIl : ProtocolVersion.getProtocols()) {
            final List<ProtocolPathEntry> lllllllllllllIIIlIIIllIlIllIlIll = this.getProtocolPath(lllllllllllllIIIlIIIllIlIllIlIIl.getVersion(), this.serverProtocolVersion.lowestSupportedVersion());
            if (lllllllllllllIIIlIIIllIlIllIlIll == null) {
                continue;
            }
            this.supportedVersions.add(lllllllllllllIIIlIIIllIlIllIlIIl.getVersion());
            for (final ProtocolPathEntry lllllllllllllIIIlIIIllIlIllIllIl : lllllllllllllIIIlIIIllIlIllIlIll) {
                this.supportedVersions.add(lllllllllllllIIIlIIIllIlIllIllIl.getOutputProtocolVersion());
            }
        }
    }
    
    @Override
    public ServerProtocolVersion getServerProtocolVersion() {
        return this.serverProtocolVersion;
    }
    
    @Override
    public boolean checkForMappingCompletion() {
        this.mappingLoaderLock.readLock().lock();
        try {
            if (this.mappingsLoaded) {
                final char lllllllllllllIIIlIIIllIIIlIIlllI = '\0';
                return lllllllllllllIIIlIIIllIIIlIIlllI != '\0';
            }
            char lllllllllllllIIIlIIIllIIIlIIlllI = (char)this.mappingLoaderFutures.values().iterator();
            while (((Iterator)lllllllllllllIIIlIIIllIIIlIIlllI).hasNext()) {
                final CompletableFuture<Void> lllllllllllllIIIlIIIllIIIlIlIIIl = ((Iterator<CompletableFuture<Void>>)lllllllllllllIIIlIIIllIIIlIIlllI).next();
                if (!lllllllllllllIIIlIIIllIIIlIlIIIl.isDone()) {
                    final double lllllllllllllIIIlIIIllIIIlIIllII = 0;
                    return lllllllllllllIIIlIIIllIIIlIIllII != 0.0;
                }
            }
            this.shutdownLoaderExecutor();
            lllllllllllllIIIlIIIllIIIlIIlllI = '\u0001';
            return lllllllllllllIIIlIIIllIIIlIIlllI != '\0';
        }
        finally {
            this.mappingLoaderLock.readLock().unlock();
        }
    }
    
    @Override
    public CompletableFuture<Void> getMappingLoaderFuture(final Class<? extends Protocol> lllllllllllllIIIlIIIllIIIIlIIlII) {
        this.mappingLoaderLock.readLock().lock();
        try {
            final char lllllllllllllIIIlIIIllIIIIlIIIll = (char)(this.mappingsLoaded ? null : this.mappingLoaderFutures.get(lllllllllllllIIIlIIIllIIIIlIIlII));
            return (CompletableFuture<Void>)lllllllllllllIIIlIIIllIIIIlIIIll;
        }
        finally {
            this.mappingLoaderLock.readLock().unlock();
        }
    }
    
    @Override
    public int getMaxProtocolPathSize() {
        return this.maxProtocolPathSize;
    }
    
    @Override
    public void setMaxProtocolPathSize(final int lllllllllllllIIIlIIIllIIIllIlIIl) {
        this.maxProtocolPathSize = lllllllllllllIIIlIIIllIIIllIlIIl;
    }
}
