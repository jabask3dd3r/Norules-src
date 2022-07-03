package com.viaversion.viaversion.api.protocol.version;

import com.viaversion.viaversion.libs.fastutil.ints.*;
import com.google.common.base.*;
import java.util.*;

public class ProtocolVersion
{
    private final /* synthetic */ String name;
    private final /* synthetic */ boolean versionWildcard;
    private static final /* synthetic */ Int2ObjectMap<ProtocolVersion> VERSIONS;
    private final /* synthetic */ int version;
    private final /* synthetic */ int snapshotVersion;
    private final /* synthetic */ Set<String> includedVersions;
    private static final /* synthetic */ List<ProtocolVersion> VERSION_LIST;
    
    public static ProtocolVersion register(final int lllllllllllllIlllIIIllIlIIIIIllI, final int lllllllllllllIlllIIIllIlIIIIIlIl, final String lllllllllllllIlllIIIllIlIIIIIlll) {
        return register(lllllllllllllIlllIIIllIlIIIIIllI, lllllllllllllIlllIIIllIlIIIIIlIl, lllllllllllllIlllIIIllIlIIIIIlll, null);
    }
    
    @Override
    public String toString() {
        return String.format("%s (%d)", this.name, this.version);
    }
    
    public static ProtocolVersion register(final int lllllllllllllIlllIIIllIIllllllIl, final String lllllllllllllIlllIIIllIIllllllII, final VersionRange lllllllllllllIlllIIIllIIlllllIll) {
        return register(lllllllllllllIlllIIIllIIllllllIl, -1, lllllllllllllIlllIIIllIIllllllII, lllllllllllllIlllIIIllIIlllllIll);
    }
    
    public int getOriginalVersion() {
        return (this.snapshotVersion == -1) ? this.version : (0x40000000 | this.snapshotVersion);
    }
    
    public Set<String> getIncludedVersions() {
        return Collections.unmodifiableSet((Set<? extends String>)this.includedVersions);
    }
    
    public static ProtocolVersion getClosest(final String lllllllllllllIlllIIIllIIllIlIlll) {
        for (final ProtocolVersion lllllllllllllIlllIIIllIIllIllIII : ProtocolVersion.VERSIONS.values()) {
            final String lllllllllllllIlllIIIllIIllIllIIl = lllllllllllllIlllIIIllIIllIllIII.getName();
            if (lllllllllllllIlllIIIllIIllIllIIl.equals(lllllllllllllIlllIIIllIIllIlIlll)) {
                return lllllllllllllIlllIIIllIIllIllIII;
            }
            if (lllllllllllllIlllIIIllIIllIllIII.isVersionWildcard()) {
                final String lllllllllllllIlllIIIllIIllIllIlI = lllllllllllllIlllIIIllIIllIllIIl.substring(0, lllllllllllllIlllIIIllIIllIllIIl.length() - 2);
                if (lllllllllllllIlllIIIllIIllIllIlI.equals(lllllllllllllIlllIIIllIIllIlIlll) || lllllllllllllIlllIIIllIIllIlIlll.startsWith(lllllllllllllIlllIIIllIIllIllIIl.substring(0, lllllllllllllIlllIIIllIIllIllIIl.length() - 1))) {
                    return lllllllllllllIlllIIIllIIllIllIII;
                }
                continue;
            }
            else {
                if (lllllllllllllIlllIIIllIIllIllIII.isRange() && lllllllllllllIlllIIIllIIllIllIII.getIncludedVersions().contains(lllllllllllllIlllIIIllIIllIlIlll)) {
                    return lllllllllllllIlllIIIllIIllIllIII;
                }
                continue;
            }
        }
        return null;
    }
    
    public ProtocolVersion(final int lllllllllllllIlllIIIllIIllIIllIl, final String lllllllllllllIlllIIIllIIllIIlIIl) {
        this(lllllllllllllIlllIIIllIIllIIllIl, -1, lllllllllllllIlllIIIllIIllIIlIIl, null);
    }
    
    static {
        VERSIONS = new Int2ObjectOpenHashMap<ProtocolVersion>();
        VERSION_LIST = new ArrayList<ProtocolVersion>();
        v1_4_6 = register(51, "1.4.6/7", new VersionRange("1.4", 6, 7));
        v1_5_1 = register(60, "1.5.1");
        v1_5_2 = register(61, "1.5.2");
        v_1_6_1 = register(73, "1.6.1");
        v_1_6_2 = register(74, "1.6.2");
        v_1_6_3 = register(77, "1.6.3");
        v_1_6_4 = register(78, "1.6.4");
        v1_7_1 = register(4, "1.7-1.7.5", new VersionRange("1.7", 0, 5));
        v1_7_6 = register(5, "1.7.6-1.7.10", new VersionRange("1.7", 6, 10));
        v1_8 = register(47, "1.8.x");
        v1_9 = register(107, "1.9");
        v1_9_1 = register(108, "1.9.1");
        v1_9_2 = register(109, "1.9.2");
        v1_9_3 = register(110, "1.9.3/4", new VersionRange("1.9", 3, 4));
        v1_10 = register(210, "1.10.x");
        v1_11 = register(315, "1.11");
        v1_11_1 = register(316, "1.11.1/2", new VersionRange("1.11", 1, 2));
        v1_12 = register(335, "1.12");
        v1_12_1 = register(338, "1.12.1");
        v1_12_2 = register(340, "1.12.2");
        v1_13 = register(393, "1.13");
        v1_13_1 = register(401, "1.13.1");
        v1_13_2 = register(404, "1.13.2");
        v1_14 = register(477, "1.14");
        v1_14_1 = register(480, "1.14.1");
        v1_14_2 = register(485, "1.14.2");
        v1_14_3 = register(490, "1.14.3");
        v1_14_4 = register(498, "1.14.4");
        v1_15 = register(573, "1.15");
        v1_15_1 = register(575, "1.15.1");
        v1_15_2 = register(578, "1.15.2");
        v1_16 = register(735, "1.16");
        v1_16_1 = register(736, "1.16.1");
        v1_16_2 = register(751, "1.16.2");
        v1_16_3 = register(753, "1.16.3");
        v1_16_4 = register(754, "1.16.4/5", new VersionRange("1.16", 4, 5));
        v1_17 = register(755, "1.17");
        v1_17_1 = register(756, "1.17.1");
        unknown = register(-1, "UNKNOWN");
    }
    
    @Override
    public int hashCode() {
        return this.version;
    }
    
    public static ProtocolVersion register(final int lllllllllllllIlllIIIllIlIIIIlllI, final String lllllllllllllIlllIIIllIlIIIIllIl) {
        return register(lllllllllllllIlllIIIllIlIIIIlllI, -1, lllllllllllllIlllIIIllIlIIIIllIl);
    }
    
    public boolean isVersionWildcard() {
        return this.versionWildcard;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlllIIIllIIlIIlIlII) {
        if (this == lllllllllllllIlllIIIllIIlIIlIlII) {
            return true;
        }
        if (lllllllllllllIlllIIIllIIlIIlIlII == null || this.getClass() != lllllllllllllIlllIIIllIIlIIlIlII.getClass()) {
            return false;
        }
        final ProtocolVersion lllllllllllllIlllIIIllIIlIIlIIll = (ProtocolVersion)lllllllllllllIlllIIIllIIlIIlIlII;
        return this.version == lllllllllllllIlllIIIllIIlIIlIIll.version;
    }
    
    public int getVersion() {
        return this.version;
    }
    
    public boolean isRange() {
        return this.includedVersions.size() != 1;
    }
    
    public int getSnapshotVersion() {
        Preconditions.checkArgument(this.isSnapshot());
        return this.snapshotVersion;
    }
    
    public static ProtocolVersion register(final int lllllllllllllIlllIIIllIIllllIIII, final int lllllllllllllIlllIIIllIIllllIlII, final String lllllllllllllIlllIIIllIIllllIIll, final VersionRange lllllllllllllIlllIIIllIIlllIllIl) {
        final ProtocolVersion lllllllllllllIlllIIIllIIllllIIIl = new ProtocolVersion(lllllllllllllIlllIIIllIIllllIIII, lllllllllllllIlllIIIllIIllllIlII, lllllllllllllIlllIIIllIIllllIIll, lllllllllllllIlllIIIllIIlllIllIl);
        ProtocolVersion.VERSION_LIST.add(lllllllllllllIlllIIIllIIllllIIIl);
        ProtocolVersion.VERSIONS.put(lllllllllllllIlllIIIllIIllllIIIl.getVersion(), lllllllllllllIlllIIIllIIllllIIIl);
        if (lllllllllllllIlllIIIllIIllllIIIl.isSnapshot()) {
            ProtocolVersion.VERSIONS.put(lllllllllllllIlllIIIllIIllllIIIl.getFullSnapshotVersion(), lllllllllllllIlllIIIllIIllllIIIl);
        }
        return lllllllllllllIlllIIIllIIllllIIIl;
    }
    
    public boolean isSnapshot() {
        return this.snapshotVersion != -1;
    }
    
    public static ProtocolVersion getProtocol(final int lllllllllllllIlllIIIllIIlllIIlII) {
        final ProtocolVersion lllllllllllllIlllIIIllIIlllIIlIl = ProtocolVersion.VERSIONS.get(lllllllllllllIlllIIIllIIlllIIlII);
        if (lllllllllllllIlllIIIllIIlllIIlIl != null) {
            return lllllllllllllIlllIIIllIIlllIIlIl;
        }
        return new ProtocolVersion(lllllllllllllIlllIIIllIIlllIIlII, String.valueOf(new StringBuilder().append("Unknown (").append(lllllllllllllIlllIIIllIIlllIIlII).append(")")));
    }
    
    public String getName() {
        return this.name;
    }
    
    public boolean isKnown() {
        return this.version != -1;
    }
    
    public static int getIndex(final ProtocolVersion lllllllllllllIlllIIIllIIlllIIIII) {
        return ProtocolVersion.VERSION_LIST.indexOf(lllllllllllllIlllIIIllIIlllIIIII);
    }
    
    public static boolean isRegistered(final int lllllllllllllIlllIIIllIIlllIlIlI) {
        return ProtocolVersion.VERSIONS.containsKey(lllllllllllllIlllIIIllIIlllIlIlI);
    }
    
    public static List<ProtocolVersion> getProtocols() {
        return Collections.unmodifiableList((List<? extends ProtocolVersion>)ProtocolVersion.VERSION_LIST);
    }
    
    public ProtocolVersion(final int lllllllllllllIlllIIIllIIllIIIIII, final int lllllllllllllIlllIIIllIIlIlllIlI, final String lllllllllllllIlllIIIllIIlIlllllI, final VersionRange lllllllllllllIlllIIIllIIlIlllIII) {
        this.version = lllllllllllllIlllIIIllIIllIIIIII;
        this.snapshotVersion = lllllllllllllIlllIIIllIIlIlllIlI;
        this.name = lllllllllllllIlllIIIllIIlIlllllI;
        this.versionWildcard = lllllllllllllIlllIIIllIIlIlllllI.endsWith(".x");
        Preconditions.checkArgument(!this.versionWildcard || lllllllllllllIlllIIIllIIlIlllIII == null, (Object)"A version cannot be a wildcard and a range at the same time!");
        if (lllllllllllllIlllIIIllIIlIlllIII != null) {
            this.includedVersions = new LinkedHashSet<String>();
            for (int lllllllllllllIlllIIIllIIllIIIIlI = lllllllllllllIlllIIIllIIlIlllIII.getRangeFrom(); lllllllllllllIlllIIIllIIllIIIIlI <= lllllllllllllIlllIIIllIIlIlllIII.getRangeTo(); ++lllllllllllllIlllIIIllIIllIIIIlI) {
                if (lllllllllllllIlllIIIllIIllIIIIlI == 0) {
                    this.includedVersions.add(lllllllllllllIlllIIIllIIlIlllIII.getBaseVersion());
                }
                this.includedVersions.add(String.valueOf(new StringBuilder().append(lllllllllllllIlllIIIllIIlIlllIII.getBaseVersion()).append(".").append(lllllllllllllIlllIIIllIIllIIIIlI)));
            }
        }
        else {
            this.includedVersions = Collections.singleton(lllllllllllllIlllIIIllIIlIlllllI);
        }
    }
    
    public int getFullSnapshotVersion() {
        Preconditions.checkArgument(this.isSnapshot());
        return 0x40000000 | this.snapshotVersion;
    }
}
