package us.myles.ViaVersion.api.protocol;

import com.viaversion.viaversion.api.protocol.version.*;
import com.google.common.base.*;
import java.util.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;

@Deprecated
public class ProtocolVersion
{
    private final /* synthetic */ boolean versionWildcard;
    private final /* synthetic */ Set<String> includedVersions;
    private final /* synthetic */ int version;
    private static final /* synthetic */ List<ProtocolVersion> versionList;
    private static final /* synthetic */ Int2ObjectMap<ProtocolVersion> versions;
    private final /* synthetic */ String name;
    private final /* synthetic */ int snapshotVersion;
    
    public static ProtocolVersion register(final int lIlllllllIIIll, final int lIlllllllIIIlI, final String lIllllllIlllII, final VersionRange lIlllllllIIIII) {
        final ProtocolVersion lIllllllIlllll = new ProtocolVersion(lIlllllllIIIll, lIlllllllIIIlI, lIllllllIlllII, lIlllllllIIIII);
        ProtocolVersion.versionList.add(lIllllllIlllll);
        ProtocolVersion.versions.put(lIllllllIlllll.getVersion(), lIllllllIlllll);
        if (lIllllllIlllll.isSnapshot()) {
            ProtocolVersion.versions.put(lIllllllIlllll.getFullSnapshotVersion(), lIllllllIlllll);
        }
        return lIllllllIlllll;
    }
    
    public int getId() {
        return this.version;
    }
    
    public int getVersion() {
        return this.version;
    }
    
    public String getName() {
        return this.name;
    }
    
    public ProtocolVersion(final int lIlllllIlllIll, final String lIlllllIlllIlI) {
        this(lIlllllIlllIll, -1, lIlllllIlllIlI, null);
    }
    
    public int getSnapshotVersion() {
        Preconditions.checkArgument(this.isSnapshot());
        return this.snapshotVersion;
    }
    
    public static ProtocolVersion getClosest(final String lIllllllIIIlIl) {
        for (final ProtocolVersion lIllllllIIIllI : ProtocolVersion.versions.values()) {
            final String lIllllllIIIlll = lIllllllIIIllI.getName();
            if (lIllllllIIIlll.equals(lIllllllIIIlIl)) {
                return lIllllllIIIllI;
            }
            if (lIllllllIIIllI.isVersionWildcard()) {
                final String lIllllllIIlIII = lIllllllIIIlll.substring(0, lIllllllIIIlll.length() - 2);
                if (lIllllllIIlIII.equals(lIllllllIIIlIl) || lIllllllIIIlIl.startsWith(lIllllllIIIlll.substring(0, lIllllllIIIlll.length() - 1))) {
                    return lIllllllIIIllI;
                }
                continue;
            }
            else {
                if (lIllllllIIIllI.isRange() && lIllllllIIIllI.getIncludedVersions().contains(lIllllllIIIlIl)) {
                    return lIllllllIIIllI;
                }
                continue;
            }
        }
        return null;
    }
    
    @Override
    public int hashCode() {
        return this.version;
    }
    
    public static List<ProtocolVersion> getProtocols() {
        return Collections.unmodifiableList((List<? extends ProtocolVersion>)new ArrayList<ProtocolVersion>(ProtocolVersion.versions.values()));
    }
    
    public boolean isSnapshot() {
        return this.snapshotVersion != -1;
    }
    
    public int getFullSnapshotVersion() {
        Preconditions.checkArgument(this.isSnapshot());
        return 0x40000000 | this.snapshotVersion;
    }
    
    @Override
    public boolean equals(final Object lIllllIlllllll) {
        if (this == lIllllIlllllll) {
            return true;
        }
        if (lIllllIlllllll == null || this.getClass() != lIllllIlllllll.getClass()) {
            return false;
        }
        final ProtocolVersion lIllllIllllllI = (ProtocolVersion)lIllllIlllllll;
        return this.version == lIllllIllllllI.version;
    }
    
    public ProtocolVersion(final int lIlllllIlIlIIl, final int lIlllllIlIllIl, final String lIlllllIlIllII, final VersionRange lIlllllIlIlIll) {
        this.version = lIlllllIlIlIIl;
        this.snapshotVersion = lIlllllIlIllIl;
        this.name = lIlllllIlIllII;
        this.versionWildcard = lIlllllIlIllII.endsWith(".x");
        Preconditions.checkArgument(!this.versionWildcard || lIlllllIlIlIll == null, (Object)"A version cannot be a wildcard and a range at the same time!");
        if (lIlllllIlIlIll != null) {
            this.includedVersions = new LinkedHashSet<String>();
            for (int lIlllllIllIIII = lIlllllIlIlIll.getRangeFrom(); lIlllllIllIIII <= lIlllllIlIlIll.getRangeTo(); ++lIlllllIllIIII) {
                if (lIlllllIllIIII == 0) {
                    this.includedVersions.add(lIlllllIlIlIll.getBaseVersion());
                }
                this.includedVersions.add(String.valueOf(new StringBuilder().append(lIlllllIlIlIll.getBaseVersion()).append(".").append(lIlllllIllIIII)));
            }
        }
        else {
            this.includedVersions = Collections.singleton(lIlllllIlIllII);
        }
    }
    
    public boolean isKnown() {
        return this.version != -1;
    }
    
    @Override
    public String toString() {
        return String.format("%s (%d)", this.name, this.version);
    }
    
    public int getOriginalVersion() {
        return (this.snapshotVersion == -1) ? this.version : (0x40000000 | this.snapshotVersion);
    }
    
    public boolean isRange() {
        return this.includedVersions.size() != 1;
    }
    
    public static ProtocolVersion register(final int lIllllllllllII, final String lIlllllllllIll) {
        return register(lIllllllllllII, -1, lIlllllllllIll);
    }
    
    public static ProtocolVersion register(final int lIllllllllIlll, final int lIllllllllIIll, final String lIllllllllIIlI) {
        return register(lIllllllllIlll, lIllllllllIIll, lIllllllllIIlI, null);
    }
    
    public boolean isVersionWildcard() {
        return this.versionWildcard;
    }
    
    public static ProtocolVersion getProtocol(final int lIllllllIlIIlI) {
        final ProtocolVersion lIllllllIlIIll = ProtocolVersion.versions.get(lIllllllIlIIlI);
        if (lIllllllIlIIll != null) {
            return lIllllllIlIIll;
        }
        return new ProtocolVersion(lIllllllIlIIlI, String.valueOf(new StringBuilder().append("Unknown (").append(lIllllllIlIIlI).append(")")));
    }
    
    public Set<String> getIncludedVersions() {
        return Collections.unmodifiableSet((Set<? extends String>)this.includedVersions);
    }
    
    static {
        versions = new Int2ObjectOpenHashMap<ProtocolVersion>();
        versionList = new ArrayList<ProtocolVersion>();
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
    
    public static ProtocolVersion register(final int lIlllllllIlIll, final String lIlllllllIllIl, final VersionRange lIlllllllIlIIl) {
        return register(lIlllllllIlIll, -1, lIlllllllIllIl, lIlllllllIlIIl);
    }
    
    public static boolean isRegistered(final int lIllllllIlIlll) {
        return ProtocolVersion.versions.containsKey(lIllllllIlIlll);
    }
    
    public static int getIndex(final ProtocolVersion lIllllllIIllll) {
        return ProtocolVersion.versionList.indexOf(lIllllllIIllll);
    }
}
