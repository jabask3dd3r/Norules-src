package com.viaversion.viaversion.update;

import java.util.*;
import java.util.regex.*;
import com.google.common.base.*;

public class Version implements Comparable<Version>
{
    private final /* synthetic */ int[] parts;
    private static final /* synthetic */ Pattern semVer;
    private final /* synthetic */ String tag;
    
    @Override
    public int hashCode() {
        int llllllllllllllIlllIIIlIIllIlIlIl = Objects.hash(this.tag);
        llllllllllllllIlllIIIlIIllIlIlIl = 31 * llllllllllllllIlllIIIlIIllIlIlIl + Arrays.hashCode(this.parts);
        return llllllllllllllIlllIIIlIIllIlIlIl;
    }
    
    static {
        semVer = Pattern.compile("(?<a>0|[1-9]\\d*)\\.(?<b>0|[1-9]\\d*)(?:\\.(?<c>0|[1-9]\\d*))?(?:-(?<tag>[A-z0-9.-]*))?");
    }
    
    public Version(final String llllllllllllllIlllIIIlIlIIIIIlll) {
        this.parts = new int[3];
        if (llllllllllllllIlllIIIlIlIIIIIlll == null) {
            throw new IllegalArgumentException("Version can not be null");
        }
        final Matcher llllllllllllllIlllIIIlIlIIIIlIIl = Version.semVer.matcher(llllllllllllllIlllIIIlIlIIIIIlll);
        if (!llllllllllllllIlllIIIlIlIIIIlIIl.matches()) {
            throw new IllegalArgumentException("Invalid version format");
        }
        this.parts[0] = Integer.parseInt(llllllllllllllIlllIIIlIlIIIIlIIl.group("a"));
        this.parts[1] = Integer.parseInt(llllllllllllllIlllIIIlIlIIIIlIIl.group("b"));
        this.parts[2] = ((llllllllllllllIlllIIIlIlIIIIlIIl.group("c") == null) ? 0 : Integer.parseInt(llllllllllllllIlllIIIlIlIIIIlIIl.group("c")));
        this.tag = ((llllllllllllllIlllIIIlIlIIIIlIIl.group("tag") == null) ? "" : llllllllllllllIlllIIIlIlIIIIlIIl.group("tag"));
    }
    
    @Override
    public int compareTo(final Version llllllllllllllIlllIIIlIIlllIIIIl) {
        return compare(this, llllllllllllllIlllIIIlIIlllIIIIl);
    }
    
    public static boolean equals(final Version llllllllllllllIlllIIIlIIlllIllll, final Version llllllllllllllIlllIIIlIIlllIlllI) {
        return llllllllllllllIlllIIIlIIlllIllll == llllllllllllllIlllIIIlIIlllIlllI || (llllllllllllllIlllIIIlIIlllIllll != null && llllllllllllllIlllIIIlIIlllIlllI != null && compare(llllllllllllllIlllIIIlIIlllIllll, llllllllllllllIlllIIIlIIlllIlllI) == 0);
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIlllIIIlIIllIllIll) {
        return llllllllllllllIlllIIIlIIllIllIll instanceof Version && equals(this, (Version)llllllllllllllIlllIIIlIIllIllIll);
    }
    
    public static int compare(final Version llllllllllllllIlllIIIlIIlllllIIl, final Version llllllllllllllIlllIIIlIIlllllIll) {
        if (llllllllllllllIlllIIIlIIlllllIIl == llllllllllllllIlllIIIlIIlllllIll) {
            return 0;
        }
        if (llllllllllllllIlllIIIlIIlllllIIl == null) {
            return -1;
        }
        if (llllllllllllllIlllIIIlIIlllllIll == null) {
            return 1;
        }
        for (int llllllllllllllIlllIIIlIIlllllIlI = Math.max(llllllllllllllIlllIIIlIIlllllIIl.parts.length, llllllllllllllIlllIIIlIIlllllIll.parts.length), llllllllllllllIlllIIIlIIllllllIl = 0; llllllllllllllIlllIIIlIIllllllIl < llllllllllllllIlllIIIlIIlllllIlI; ++llllllllllllllIlllIIIlIIllllllIl) {
            final int llllllllllllllIlllIIIlIIllllllll = (llllllllllllllIlllIIIlIIllllllIl < llllllllllllllIlllIIIlIIlllllIIl.parts.length) ? llllllllllllllIlllIIIlIIlllllIIl.parts[llllllllllllllIlllIIIlIIllllllIl] : 0;
            final int llllllllllllllIlllIIIlIIlllllllI = (llllllllllllllIlllIIIlIIllllllIl < llllllllllllllIlllIIIlIIlllllIll.parts.length) ? llllllllllllllIlllIIIlIIlllllIll.parts[llllllllllllllIlllIIIlIIllllllIl] : 0;
            if (llllllllllllllIlllIIIlIIllllllll < llllllllllllllIlllIIIlIIlllllllI) {
                return -1;
            }
            if (llllllllllllllIlllIIIlIIllllllll > llllllllllllllIlllIIIlIIlllllllI) {
                return 1;
            }
        }
        if (llllllllllllllIlllIIIlIIlllllIIl.tag.isEmpty() && !llllllllllllllIlllIIIlIIlllllIll.tag.isEmpty()) {
            return 1;
        }
        if (!llllllllllllllIlllIIIlIIlllllIIl.tag.isEmpty() && llllllllllllllIlllIIIlIIlllllIll.tag.isEmpty()) {
            return -1;
        }
        return 0;
    }
    
    public String getTag() {
        return this.tag;
    }
    
    @Override
    public String toString() {
        final String[] llllllllllllllIlllIIIlIIlllIlIII = new String[this.parts.length];
        for (int llllllllllllllIlllIIIlIIlllIlIlI = 0; llllllllllllllIlllIIIlIIlllIlIlI < this.parts.length; ++llllllllllllllIlllIIIlIIlllIlIlI) {
            llllllllllllllIlllIIIlIIlllIlIII[llllllllllllllIlllIIIlIIlllIlIlI] = String.valueOf(this.parts[llllllllllllllIlllIIIlIIlllIlIlI]);
        }
        return String.valueOf(new StringBuilder().append(Joiner.on(".").join((Object[])llllllllllllllIlllIIIlIIlllIlIII)).append(this.tag.isEmpty() ? "" : String.valueOf(new StringBuilder().append("-").append(this.tag))));
    }
}
