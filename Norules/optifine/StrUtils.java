package optifine;

import java.util.*;

public class StrUtils
{
    public static int findSuffix(final String[] lllllllllllllIlIIIllllIllIlIllIl, final String lllllllllllllIlIIIllllIllIlIlIII) {
        if (lllllllllllllIlIIIllllIllIlIllIl != null && lllllllllllllIlIIIllllIllIlIlIII != null) {
            for (int lllllllllllllIlIIIllllIllIlIlIll = 0; lllllllllllllIlIIIllllIllIlIlIll < lllllllllllllIlIIIllllIllIlIllIl.length; ++lllllllllllllIlIIIllllIllIlIlIll) {
                final String lllllllllllllIlIIIllllIllIlIlIlI = lllllllllllllIlIIIllllIllIlIllIl[lllllllllllllIlIIIllllIllIlIlIll];
                if (lllllllllllllIlIIIllllIllIlIlIlI.endsWith(lllllllllllllIlIIIllllIllIlIlIII)) {
                    return lllllllllllllIlIIIllllIllIlIlIll;
                }
            }
            return -1;
        }
        return -1;
    }
    
    public static boolean equalsMask(final String lllllllllllllIlIIIlllllIllIlllII, final String lllllllllllllIlIIIlllllIllIllIll, final char lllllllllllllIlIIIlllllIllIIllIl, final char lllllllllllllIlIIIlllllIllIllIIl) {
        if (lllllllllllllIlIIIlllllIllIllIll == null || lllllllllllllIlIIIlllllIllIlllII == null) {
            return lllllllllllllIlIIIlllllIllIllIll == lllllllllllllIlIIIlllllIllIlllII;
        }
        if (lllllllllllllIlIIIlllllIllIllIll.indexOf(lllllllllllllIlIIIlllllIllIIllIl) < 0) {
            return (lllllllllllllIlIIIlllllIllIllIll.indexOf(lllllllllllllIlIIIlllllIllIllIIl) < 0) ? lllllllllllllIlIIIlllllIllIllIll.equals(lllllllllllllIlIIIlllllIllIlllII) : equalsMaskSingle(lllllllllllllIlIIIlllllIllIlllII, lllllllllllllIlIIIlllllIllIllIll, lllllllllllllIlIIIlllllIllIllIIl);
        }
        final List lllllllllllllIlIIIlllllIllIllIII = new ArrayList();
        final String lllllllllllllIlIIIlllllIllIlIlll = String.valueOf(new StringBuilder().append(lllllllllllllIlIIIlllllIllIIllIl));
        if (lllllllllllllIlIIIlllllIllIllIll.startsWith(lllllllllllllIlIIIlllllIllIlIlll)) {
            lllllllllllllIlIIIlllllIllIllIII.add("");
        }
        final StringTokenizer lllllllllllllIlIIIlllllIllIlIllI = new StringTokenizer(lllllllllllllIlIIIlllllIllIllIll, lllllllllllllIlIIIlllllIllIlIlll);
        while (lllllllllllllIlIIIlllllIllIlIllI.hasMoreElements()) {
            lllllllllllllIlIIIlllllIllIllIII.add(lllllllllllllIlIIIlllllIllIlIllI.nextToken());
        }
        if (lllllllllllllIlIIIlllllIllIllIll.endsWith(lllllllllllllIlIIIlllllIllIlIlll)) {
            lllllllllllllIlIIIlllllIllIllIII.add("");
        }
        final String lllllllllllllIlIIIlllllIllIlIlIl = lllllllllllllIlIIIlllllIllIllIII.get(0);
        if (!startsWithMaskSingle(lllllllllllllIlIIIlllllIllIlllII, lllllllllllllIlIIIlllllIllIlIlIl, lllllllllllllIlIIIlllllIllIllIIl)) {
            return false;
        }
        final String lllllllllllllIlIIIlllllIllIlIlII = lllllllllllllIlIIIlllllIllIllIII.get(lllllllllllllIlIIIlllllIllIllIII.size() - 1);
        if (!endsWithMaskSingle(lllllllllllllIlIIIlllllIllIlllII, lllllllllllllIlIIIlllllIllIlIlII, lllllllllllllIlIIIlllllIllIllIIl)) {
            return false;
        }
        int lllllllllllllIlIIIlllllIllIlIIll = 0;
        for (int lllllllllllllIlIIIlllllIllIlIIlI = 0; lllllllllllllIlIIIlllllIllIlIIlI < lllllllllllllIlIIIlllllIllIllIII.size(); ++lllllllllllllIlIIIlllllIllIlIIlI) {
            final String lllllllllllllIlIIIlllllIllIlIIIl = lllllllllllllIlIIIlllllIllIllIII.get(lllllllllllllIlIIIlllllIllIlIIlI);
            if (lllllllllllllIlIIIlllllIllIlIIIl.length() > 0) {
                final int lllllllllllllIlIIIlllllIllIlIIII = indexOfMaskSingle(lllllllllllllIlIIIlllllIllIlllII, lllllllllllllIlIIIlllllIllIlIIIl, lllllllllllllIlIIIlllllIllIlIIll, lllllllllllllIlIIIlllllIllIllIIl);
                if (lllllllllllllIlIIIlllllIllIlIIII < 0) {
                    return false;
                }
                lllllllllllllIlIIIlllllIllIlIIll = lllllllllllllIlIIIlllllIllIlIIII + lllllllllllllIlIIIlllllIllIlIIIl.length();
            }
        }
        return true;
    }
    
    public static String fillLeft(String lllllllllllllIlIIIlllllIIIIIlIlI, final int lllllllllllllIlIIIlllllIIIIIlIIl, final char lllllllllllllIlIIIlllllIIIIIlIII) {
        if (lllllllllllllIlIIIlllllIIIIIlIlI == null) {
            lllllllllllllIlIIIlllllIIIIIlIlI = "";
        }
        if (lllllllllllllIlIIIlllllIIIIIlIlI.length() >= lllllllllllllIlIIIlllllIIIIIlIIl) {
            return lllllllllllllIlIIIlllllIIIIIlIlI;
        }
        final StringBuffer lllllllllllllIlIIIlllllIIIIIllII = new StringBuffer();
        final int lllllllllllllIlIIIlllllIIIIIlIll = lllllllllllllIlIIIlllllIIIIIlIIl - lllllllllllllIlIIIlllllIIIIIlIlI.length();
        while (lllllllllllllIlIIIlllllIIIIIllII.length() < lllllllllllllIlIIIlllllIIIIIlIll) {
            lllllllllllllIlIIIlllllIIIIIllII.append(lllllllllllllIlIIIlllllIIIIIlIII);
        }
        return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIIIlllllIIIIIllII.toString())).append(lllllllllllllIlIIIlllllIIIIIlIlI));
    }
    
    public static boolean isEmpty(final String lllllllllllllIlIIIlllllIIIllIIll) {
        return lllllllllllllIlIIIlllllIIIllIIll == null || lllllllllllllIlIIIlllllIIIllIIll.trim().length() <= 0;
    }
    
    public static int findPrefix(final String[] lllllllllllllIlIIIllllIllIllIlIl, final String lllllllllllllIlIIIllllIllIllIlII) {
        if (lllllllllllllIlIIIllllIllIllIlIl != null && lllllllllllllIlIIIllllIllIllIlII != null) {
            for (int lllllllllllllIlIIIllllIllIllIlll = 0; lllllllllllllIlIIIllllIllIllIlll < lllllllllllllIlIIIllllIllIllIlIl.length; ++lllllllllllllIlIIIllllIllIllIlll) {
                final String lllllllllllllIlIIIllllIllIllIllI = lllllllllllllIlIIIllllIllIllIlIl[lllllllllllllIlIIIllllIllIllIlll];
                if (lllllllllllllIlIIIllllIllIllIllI.startsWith(lllllllllllllIlIIIllllIllIllIlII)) {
                    return lllllllllllllIlIIIllllIllIllIlll;
                }
            }
            return -1;
        }
        return -1;
    }
    
    public static boolean equals(final Object lllllllllllllIlIIIllllIlllllIlll, final Object lllllllllllllIlIIIllllIlllllIlII) {
        return lllllllllllllIlIIIllllIlllllIlll == lllllllllllllIlIIIllllIlllllIlII || (lllllllllllllIlIIIllllIlllllIlll != null && lllllllllllllIlIIIllllIlllllIlll.equals(lllllllllllllIlIIIllllIlllllIlII)) || (lllllllllllllIlIIIllllIlllllIlII != null && lllllllllllllIlIIIllllIlllllIlII.equals(lllllllllllllIlIIIllllIlllllIlll));
    }
    
    private static boolean endsWithMaskSingle(final String lllllllllllllIlIIIlllllIlIIllIIl, final String lllllllllllllIlIIIlllllIlIIlllII, final char lllllllllllllIlIIIlllllIlIIllIll) {
        if (lllllllllllllIlIIIlllllIlIIllIIl == null || lllllllllllllIlIIIlllllIlIIlllII == null) {
            return lllllllllllllIlIIIlllllIlIIllIIl == lllllllllllllIlIIIlllllIlIIlllII;
        }
        if (lllllllllllllIlIIIlllllIlIIllIIl.length() < lllllllllllllIlIIIlllllIlIIlllII.length()) {
            return false;
        }
        final String lllllllllllllIlIIIlllllIlIIllIlI = lllllllllllllIlIIIlllllIlIIllIIl.substring(lllllllllllllIlIIIlllllIlIIllIIl.length() - lllllllllllllIlIIIlllllIlIIlllII.length(), lllllllllllllIlIIIlllllIlIIllIIl.length());
        return equalsMaskSingle(lllllllllllllIlIIIlllllIlIIllIlI, lllllllllllllIlIIIlllllIlIIlllII, lllllllllllllIlIIIlllllIlIIllIll);
    }
    
    public static boolean endsWith(final String lllllllllllllIlIIIllllIlllIlllll, final String[] lllllllllllllIlIIIllllIllllIIIlI) {
        if (lllllllllllllIlIIIllllIlllIlllll == null) {
            return false;
        }
        if (lllllllllllllIlIIIllllIllllIIIlI == null) {
            return false;
        }
        for (int lllllllllllllIlIIIllllIllllIIIIl = 0; lllllllllllllIlIIIllllIllllIIIIl < lllllllllllllIlIIIllllIllllIIIlI.length; ++lllllllllllllIlIIIllllIllllIIIIl) {
            final String lllllllllllllIlIIIllllIllllIIIII = lllllllllllllIlIIIllllIllllIIIlI[lllllllllllllIlIIIllllIllllIIIIl];
            if (lllllllllllllIlIIIllllIlllIlllll.endsWith(lllllllllllllIlIIIllllIllllIIIII)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean equalsMask(final String lllllllllllllIlIIIlllllIIlllllll, final String[] lllllllllllllIlIIIlllllIIllllllI, final char lllllllllllllIlIIIlllllIlIIIIIlI) {
        for (int lllllllllllllIlIIIlllllIlIIIIIIl = 0; lllllllllllllIlIIIlllllIlIIIIIIl < lllllllllllllIlIIIlllllIIllllllI.length; ++lllllllllllllIlIIIlllllIlIIIIIIl) {
            final String lllllllllllllIlIIIlllllIlIIIIIII = lllllllllllllIlIIIlllllIIllllllI[lllllllllllllIlIIIlllllIlIIIIIIl];
            if (equalsMask(lllllllllllllIlIIIlllllIIlllllll, lllllllllllllIlIIIlllllIlIIIIIII, lllllllllllllIlIIIlllllIlIIIIIlI)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean equalsMask(final String lllllllllllllIlIIIlllllIIllIlllI, final String lllllllllllllIlIIIlllllIIllIIIIl, final char lllllllllllllIlIIIlllllIIllIllII) {
        if (lllllllllllllIlIIIlllllIIllIIIIl == null || lllllllllllllIlIIIlllllIIllIlllI == null) {
            return lllllllllllllIlIIIlllllIIllIIIIl == lllllllllllllIlIIIlllllIIllIlllI;
        }
        if (lllllllllllllIlIIIlllllIIllIIIIl.indexOf(lllllllllllllIlIIIlllllIIllIllII) < 0) {
            return lllllllllllllIlIIIlllllIIllIIIIl.equals(lllllllllllllIlIIIlllllIIllIlllI);
        }
        final List lllllllllllllIlIIIlllllIIllIlIll = new ArrayList();
        final String lllllllllllllIlIIIlllllIIllIlIlI = String.valueOf(new StringBuilder().append(lllllllllllllIlIIIlllllIIllIllII));
        if (lllllllllllllIlIIIlllllIIllIIIIl.startsWith(lllllllllllllIlIIIlllllIIllIlIlI)) {
            lllllllllllllIlIIIlllllIIllIlIll.add("");
        }
        final StringTokenizer lllllllllllllIlIIIlllllIIllIlIIl = new StringTokenizer(lllllllllllllIlIIIlllllIIllIIIIl, lllllllllllllIlIIIlllllIIllIlIlI);
        while (lllllllllllllIlIIIlllllIIllIlIIl.hasMoreElements()) {
            lllllllllllllIlIIIlllllIIllIlIll.add(lllllllllllllIlIIIlllllIIllIlIIl.nextToken());
        }
        if (lllllllllllllIlIIIlllllIIllIIIIl.endsWith(lllllllllllllIlIIIlllllIIllIlIlI)) {
            lllllllllllllIlIIIlllllIIllIlIll.add("");
        }
        final String lllllllllllllIlIIIlllllIIllIlIII = lllllllllllllIlIIIlllllIIllIlIll.get(0);
        if (!lllllllllllllIlIIIlllllIIllIlllI.startsWith(lllllllllllllIlIIIlllllIIllIlIII)) {
            return false;
        }
        final String lllllllllllllIlIIIlllllIIllIIlll = lllllllllllllIlIIIlllllIIllIlIll.get(lllllllllllllIlIIIlllllIIllIlIll.size() - 1);
        if (!lllllllllllllIlIIIlllllIIllIlllI.endsWith(lllllllllllllIlIIIlllllIIllIIlll)) {
            return false;
        }
        int lllllllllllllIlIIIlllllIIllIIllI = 0;
        for (int lllllllllllllIlIIIlllllIIllIIlIl = 0; lllllllllllllIlIIIlllllIIllIIlIl < lllllllllllllIlIIIlllllIIllIlIll.size(); ++lllllllllllllIlIIIlllllIIllIIlIl) {
            final String lllllllllllllIlIIIlllllIIllIIlII = lllllllllllllIlIIIlllllIIllIlIll.get(lllllllllllllIlIIIlllllIIllIIlIl);
            if (lllllllllllllIlIIIlllllIIllIIlII.length() > 0) {
                final int lllllllllllllIlIIIlllllIIllIIIll = lllllllllllllIlIIIlllllIIllIlllI.indexOf(lllllllllllllIlIIIlllllIIllIIlII, lllllllllllllIlIIIlllllIIllIIllI);
                if (lllllllllllllIlIIIlllllIIllIIIll < 0) {
                    return false;
                }
                lllllllllllllIlIIIlllllIIllIIllI = lllllllllllllIlIIIlllllIIllIIIll + lllllllllllllIlIIIlllllIIllIIlII.length();
            }
        }
        return true;
    }
    
    public static String stringInc(final String lllllllllllllIlIIIlllllIIIlIllll) {
        int lllllllllllllIlIIIlllllIIIlIlllI = parseInt(lllllllllllllIlIIIlllllIIIlIllll, -1);
        if (lllllllllllllIlIIIlllllIIIlIlllI == -1) {
            return "";
        }
        ++lllllllllllllIlIIIlllllIIIlIlllI;
        final String lllllllllllllIlIIIlllllIIIlIllIl = String.valueOf(new StringBuilder().append(lllllllllllllIlIIIlllllIIIlIlllI));
        return (lllllllllllllIlIIIlllllIIIlIllIl.length() > lllllllllllllIlIIIlllllIIIlIllll.length()) ? "" : fillLeft(String.valueOf(new StringBuilder().append(lllllllllllllIlIIIlllllIIIlIlllI)), lllllllllllllIlIIIlllllIIIlIllll.length(), '0');
    }
    
    public static String fillRight(String lllllllllllllIlIIIllllIlllllllIl, final int lllllllllllllIlIIIlllllIIIIIIIII, final char lllllllllllllIlIIIllllIlllllllll) {
        if (lllllllllllllIlIIIllllIlllllllIl == null) {
            lllllllllllllIlIIIllllIlllllllIl = "";
        }
        if (lllllllllllllIlIIIllllIlllllllIl.length() >= lllllllllllllIlIIIlllllIIIIIIIII) {
            return lllllllllllllIlIIIllllIlllllllIl;
        }
        final StringBuffer lllllllllllllIlIIIllllIllllllllI = new StringBuffer(lllllllllllllIlIIIllllIlllllllIl);
        while (lllllllllllllIlIIIllllIllllllllI.length() < lllllllllllllIlIIIlllllIIIIIIIII) {
            lllllllllllllIlIIIllllIllllllllI.append(lllllllllllllIlIIIllllIlllllllll);
        }
        return lllllllllllllIlIIIllllIllllllllI.toString();
    }
    
    public static String addIfNotContains(String lllllllllllllIlIIIlllllIIIIlIlll, final String lllllllllllllIlIIIlllllIIIIlIllI) {
        for (int lllllllllllllIlIIIlllllIIIIllIII = 0; lllllllllllllIlIIIlllllIIIIllIII < lllllllllllllIlIIIlllllIIIIlIllI.length(); ++lllllllllllllIlIIIlllllIIIIllIII) {
            if (lllllllllllllIlIIIlllllIIIIlIlll.indexOf(lllllllllllllIlIIIlllllIIIIlIllI.charAt(lllllllllllllIlIIIlllllIIIIllIII)) < 0) {
                lllllllllllllIlIIIlllllIIIIlIlll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIIIlllllIIIIlIlll)).append(lllllllllllllIlIIIlllllIIIIlIllI.charAt(lllllllllllllIlIIIlllllIIIIllIII)));
            }
        }
        return lllllllllllllIlIIIlllllIIIIlIlll;
    }
    
    public static String removeSuffix(String lllllllllllllIlIIIllllIllIIIlIII, final String[] lllllllllllllIlIIIllllIllIIIIlll) {
        if (lllllllllllllIlIIIllllIllIIIlIII != null && lllllllllllllIlIIIllllIllIIIIlll != null) {
            final int lllllllllllllIlIIIllllIllIIIlIll = ((String)lllllllllllllIlIIIllllIllIIIlIII).length();
            for (int lllllllllllllIlIIIllllIllIIIlIlI = 0; lllllllllllllIlIIIllllIllIIIlIlI < lllllllllllllIlIIIllllIllIIIIlll.length; ++lllllllllllllIlIIIllllIllIIIlIlI) {
                final String lllllllllllllIlIIIllllIllIIIlIIl = lllllllllllllIlIIIllllIllIIIIlll[lllllllllllllIlIIIllllIllIIIlIlI];
                lllllllllllllIlIIIllllIllIIIlIII = removeSuffix((String)lllllllllllllIlIIIllllIllIIIlIII, lllllllllllllIlIIIllllIllIIIlIIl);
                if (((String)lllllllllllllIlIIIllllIllIIIlIII).length() != lllllllllllllIlIIIllllIllIIIlIll) {
                    break;
                }
            }
            return (String)lllllllllllllIlIIIllllIllIIIlIII;
        }
        return (String)lllllllllllllIlIIIllllIllIIIlIII;
    }
    
    public static String[] split(final String lllllllllllllIlIIIlllllIIlIIlIlI, final String lllllllllllllIlIIIlllllIIlIIlIIl) {
        if (lllllllllllllIlIIIlllllIIlIIlIlI == null || lllllllllllllIlIIIlllllIIlIIlIlI.length() <= 0) {
            return new String[0];
        }
        if (lllllllllllllIlIIIlllllIIlIIlIIl == null) {
            return new String[] { lllllllllllllIlIIIlllllIIlIIlIlI };
        }
        final List lllllllllllllIlIIIlllllIIlIIlllI = new ArrayList();
        int lllllllllllllIlIIIlllllIIlIIllIl = 0;
        for (int lllllllllllllIlIIIlllllIIlIIllII = 0; lllllllllllllIlIIIlllllIIlIIllII < lllllllllllllIlIIIlllllIIlIIlIlI.length(); ++lllllllllllllIlIIIlllllIIlIIllII) {
            final char lllllllllllllIlIIIlllllIIlIIlIll = lllllllllllllIlIIIlllllIIlIIlIlI.charAt(lllllllllllllIlIIIlllllIIlIIllII);
            if (equals(lllllllllllllIlIIIlllllIIlIIlIll, lllllllllllllIlIIIlllllIIlIIlIIl)) {
                lllllllllllllIlIIIlllllIIlIIlllI.add(lllllllllllllIlIIIlllllIIlIIlIlI.substring(lllllllllllllIlIIIlllllIIlIIllIl, lllllllllllllIlIIIlllllIIlIIllII));
                lllllllllllllIlIIIlllllIIlIIllIl = lllllllllllllIlIIIlllllIIlIIllII + 1;
            }
        }
        lllllllllllllIlIIIlllllIIlIIlllI.add(lllllllllllllIlIIIlllllIIlIIlIlI.substring(lllllllllllllIlIIIlllllIIlIIllIl, lllllllllllllIlIIIlllllIIlIIlIlI.length()));
        return lllllllllllllIlIIIlllllIIlIIlllI.toArray(new String[lllllllllllllIlIIIlllllIIlIIlllI.size()]);
    }
    
    private static boolean startsWithMaskSingle(final String lllllllllllllIlIIIlllllIlIIlIIIl, final String lllllllllllllIlIIIlllllIlIIlIIII, final char lllllllllllllIlIIIlllllIlIIIllll) {
        if (lllllllllllllIlIIIlllllIlIIlIIIl == null || lllllllllllllIlIIIlllllIlIIlIIII == null) {
            return lllllllllllllIlIIIlllllIlIIlIIIl == lllllllllllllIlIIIlllllIlIIlIIII;
        }
        if (lllllllllllllIlIIIlllllIlIIlIIIl.length() < lllllllllllllIlIIIlllllIlIIlIIII.length()) {
            return false;
        }
        final String lllllllllllllIlIIIlllllIlIIIlllI = lllllllllllllIlIIIlllllIlIIlIIIl.substring(0, lllllllllllllIlIIIlllllIlIIlIIII.length());
        return equalsMaskSingle(lllllllllllllIlIIIlllllIlIIIlllI, lllllllllllllIlIIIlllllIlIIlIIII, lllllllllllllIlIIIlllllIlIIIllll);
    }
    
    public static String getSegment(final String lllllllllllllIlIIIllllIlIlIlIlII, final String lllllllllllllIlIIIllllIlIlIlIIll, final String lllllllllllllIlIIIllllIlIlIlIIlI) {
        if (lllllllllllllIlIIIllllIlIlIlIlII == null || lllllllllllllIlIIIllllIlIlIlIIll == null || lllllllllllllIlIIIllllIlIlIlIIlI == null) {
            return null;
        }
        final int lllllllllllllIlIIIllllIlIlIlIIIl = lllllllllllllIlIIIllllIlIlIlIlII.indexOf(lllllllllllllIlIIIllllIlIlIlIIll);
        if (lllllllllllllIlIIIllllIlIlIlIIIl < 0) {
            return null;
        }
        final int lllllllllllllIlIIIllllIlIlIlIIII = lllllllllllllIlIIIllllIlIlIlIlII.indexOf(lllllllllllllIlIIIllllIlIlIlIIlI, lllllllllllllIlIIIllllIlIlIlIIIl);
        return (lllllllllllllIlIIIllllIlIlIlIIII < 0) ? null : lllllllllllllIlIIIllllIlIlIlIlII.substring(lllllllllllllIlIIIllllIlIlIlIIIl, lllllllllllllIlIIIllllIlIlIlIIII + lllllllllllllIlIIIllllIlIlIlIIlI.length());
    }
    
    public static String addSuffixCheck(final String lllllllllllllIlIIIllllIlIlIIIllI, final String lllllllllllllIlIIIllllIlIlIIIlIl) {
        if (lllllllllllllIlIIIllllIlIlIIIllI != null && lllllllllllllIlIIIllllIlIlIIIlIl != null) {
            return lllllllllllllIlIIIllllIlIlIIIllI.endsWith(lllllllllllllIlIIIllllIlIlIIIlIl) ? lllllllllllllIlIIIllllIlIlIIIllI : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIIIllllIlIlIIIllI)).append(lllllllllllllIlIIIllllIlIlIIIlIl));
        }
        return lllllllllllllIlIIIllllIlIlIIIllI;
    }
    
    public static boolean equalsTrim(String lllllllllllllIlIIIlllllIIIllIlll, String lllllllllllllIlIIIlllllIIIllIllI) {
        if (lllllllllllllIlIIIlllllIIIllIlll != null) {
            lllllllllllllIlIIIlllllIIIllIlll = lllllllllllllIlIIIlllllIIIllIlll.trim();
        }
        if (lllllllllllllIlIIIlllllIIIllIllI != null) {
            lllllllllllllIlIIIlllllIIIllIllI = lllllllllllllIlIIIlllllIIIllIllI.trim();
        }
        return equals(lllllllllllllIlIIIlllllIIIllIlll, lllllllllllllIlIIIlllllIIIllIllI);
    }
    
    public static String removePrefix(String lllllllllllllIlIIIllllIlllIlIlll, final String lllllllllllllIlIIIllllIlllIlIllI) {
        if (lllllllllllllIlIIIllllIlllIlIlll != null && lllllllllllllIlIIIllllIlllIlIllI != null) {
            if (((String)lllllllllllllIlIIIllllIlllIlIlll).startsWith(lllllllllllllIlIIIllllIlllIlIllI)) {
                lllllllllllllIlIIIllllIlllIlIlll = ((String)lllllllllllllIlIIIllllIlllIlIlll).substring(lllllllllllllIlIIIllllIlllIlIllI.length());
            }
            return (String)lllllllllllllIlIIIllllIlllIlIlll;
        }
        return (String)lllllllllllllIlIIIllllIlllIlIlll;
    }
    
    public static int parseInt(final String lllllllllllllIlIIIlllllIIIlIIllI, final int lllllllllllllIlIIIlllllIIIlIIIlI) {
        if (lllllllllllllIlIIIlllllIIIlIIllI == null) {
            return lllllllllllllIlIIIlllllIIIlIIIlI;
        }
        try {
            return Integer.parseInt(lllllllllllllIlIIIlllllIIIlIIllI);
        }
        catch (NumberFormatException lllllllllllllIlIIIlllllIIIlIIlII) {
            return lllllllllllllIlIIIlllllIIIlIIIlI;
        }
    }
    
    public static String[] remove(final String[] lllllllllllllIlIIIllllIllIIllIII, final int lllllllllllllIlIIIllllIllIIllllI, final int lllllllllllllIlIIIllllIllIIlIllI) {
        if (lllllllllllllIlIIIllllIllIIllIII == null) {
            return lllllllllllllIlIIIllllIllIIllIII;
        }
        if (lllllllllllllIlIIIllllIllIIlIllI <= 0 || lllllllllllllIlIIIllllIllIIllllI >= lllllllllllllIlIIIllllIllIIllIII.length) {
            return lllllllllllllIlIIIllllIllIIllIII;
        }
        if (lllllllllllllIlIIIllllIllIIllllI >= lllllllllllllIlIIIllllIllIIlIllI) {
            return lllllllllllllIlIIIllllIllIIllIII;
        }
        final List<String> lllllllllllllIlIIIllllIllIIlllII = new ArrayList<String>(lllllllllllllIlIIIllllIllIIllIII.length);
        for (int lllllllllllllIlIIIllllIllIIllIll = 0; lllllllllllllIlIIIllllIllIIllIll < lllllllllllllIlIIIllllIllIIllIII.length; ++lllllllllllllIlIIIllllIllIIllIll) {
            final String lllllllllllllIlIIIllllIllIIllIlI = lllllllllllllIlIIIllllIllIIllIII[lllllllllllllIlIIIllllIllIIllIll];
            if (lllllllllllllIlIIIllllIllIIllIll < lllllllllllllIlIIIllllIllIIllllI || lllllllllllllIlIIIllllIllIIllIll >= lllllllllllllIlIIIllllIllIIlIllI) {
                lllllllllllllIlIIIllllIllIIlllII.add(lllllllllllllIlIIIllllIllIIllIlI);
            }
        }
        final String[] lllllllllllllIlIIIllllIllIIllIIl = lllllllllllllIlIIIllllIllIIlllII.toArray(new String[lllllllllllllIlIIIllllIllIIlllII.size()]);
        return lllllllllllllIlIIIllllIllIIllIIl;
    }
    
    public static String removeSuffix(String lllllllllllllIlIIIllllIlllIlIIIl, final String lllllllllllllIlIIIllllIlllIlIIlI) {
        if (lllllllllllllIlIIIllllIlllIlIIIl != null && lllllllllllllIlIIIllllIlllIlIIlI != null) {
            if (lllllllllllllIlIIIllllIlllIlIIIl.endsWith(lllllllllllllIlIIIllllIlllIlIIlI)) {
                lllllllllllllIlIIIllllIlllIlIIIl = lllllllllllllIlIIIllllIlllIlIIIl.substring(0, lllllllllllllIlIIIllllIlllIlIIIl.length() - lllllllllllllIlIIIllllIlllIlIIlI.length());
            }
            return lllllllllllllIlIIIllllIlllIlIIIl;
        }
        return lllllllllllllIlIIIllllIlllIlIIIl;
    }
    
    private static boolean equalsMaskSingle(final String lllllllllllllIlIIIlllllIlIlllIII, final String lllllllllllllIlIIIlllllIlIllllII, final char lllllllllllllIlIIIlllllIlIlllIll) {
        if (lllllllllllllIlIIIlllllIlIlllIII == null || lllllllllllllIlIIIlllllIlIllllII == null) {
            return lllllllllllllIlIIIlllllIlIlllIII == lllllllllllllIlIIIlllllIlIllllII;
        }
        if (lllllllllllllIlIIIlllllIlIlllIII.length() != lllllllllllllIlIIIlllllIlIllllII.length()) {
            return false;
        }
        for (int lllllllllllllIlIIIlllllIlIlllIlI = 0; lllllllllllllIlIIIlllllIlIlllIlI < lllllllllllllIlIIIlllllIlIllllII.length(); ++lllllllllllllIlIIIlllllIlIlllIlI) {
            final char lllllllllllllIlIIIlllllIlIlllIIl = lllllllllllllIlIIIlllllIlIllllII.charAt(lllllllllllllIlIIIlllllIlIlllIlI);
            if (lllllllllllllIlIIIlllllIlIlllIIl != lllllllllllllIlIIIlllllIlIlllIll && lllllllllllllIlIIIlllllIlIlllIII.charAt(lllllllllllllIlIIIlllllIlIlllIlI) != lllllllllllllIlIIIlllllIlIlllIIl) {
                return false;
            }
        }
        return true;
    }
    
    private static int indexOfMaskSingle(final String lllllllllllllIlIIIlllllIlIlIllIl, final String lllllllllllllIlIIIlllllIlIlIllII, final int lllllllllllllIlIIIlllllIlIlIIlIl, final char lllllllllllllIlIIIlllllIlIlIlIlI) {
        if (lllllllllllllIlIIIlllllIlIlIllIl == null || lllllllllllllIlIIIlllllIlIlIllII == null) {
            return -1;
        }
        if (lllllllllllllIlIIIlllllIlIlIIlIl < 0 || lllllllllllllIlIIIlllllIlIlIIlIl > lllllllllllllIlIIIlllllIlIlIllIl.length()) {
            return -1;
        }
        if (lllllllllllllIlIIIlllllIlIlIllIl.length() < lllllllllllllIlIIIlllllIlIlIIlIl + lllllllllllllIlIIIlllllIlIlIllII.length()) {
            return -1;
        }
        for (int lllllllllllllIlIIIlllllIlIlIlIIl = lllllllllllllIlIIIlllllIlIlIIlIl; lllllllllllllIlIIIlllllIlIlIlIIl + lllllllllllllIlIIIlllllIlIlIllII.length() <= lllllllllllllIlIIIlllllIlIlIllIl.length(); ++lllllllllllllIlIIIlllllIlIlIlIIl) {
            final String lllllllllllllIlIIIlllllIlIlIlIII = lllllllllllllIlIIIlllllIlIlIllIl.substring(lllllllllllllIlIIIlllllIlIlIlIIl, lllllllllllllIlIIIlllllIlIlIlIIl + lllllllllllllIlIIIlllllIlIlIllII.length());
            if (equalsMaskSingle(lllllllllllllIlIIIlllllIlIlIlIII, lllllllllllllIlIIIlllllIlIlIllII, lllllllllllllIlIIIlllllIlIlIlIlI)) {
                return lllllllllllllIlIIIlllllIlIlIlIIl;
            }
        }
        return -1;
    }
    
    public static String removePrefixSuffix(String lllllllllllllIlIIIllllIlIllIIlIl, final String[] lllllllllllllIlIIIllllIlIllIIlll, final String[] lllllllllllllIlIIIllllIlIllIIIll) {
        lllllllllllllIlIIIllllIlIllIIlIl = (float)removePrefix((String)lllllllllllllIlIIIllllIlIllIIlIl, lllllllllllllIlIIIllllIlIllIIlll);
        lllllllllllllIlIIIllllIlIllIIlIl = (float)removeSuffix((String)lllllllllllllIlIIIllllIlIllIIlIl, lllllllllllllIlIIIllllIlIllIIIll);
        return (String)lllllllllllllIlIIIllllIlIllIIlIl;
    }
    
    public static String replacePrefix(String lllllllllllllIlIIIllllIlllIIIIll, final String lllllllllllllIlIIIllllIllIllllll, String lllllllllllllIlIIIllllIllIlllllI) {
        if (lllllllllllllIlIIIllllIlllIIIIll == null || lllllllllllllIlIIIllllIllIllllll == null) {
            return lllllllllllllIlIIIllllIlllIIIIll;
        }
        if (!lllllllllllllIlIIIllllIlllIIIIll.startsWith(lllllllllllllIlIIIllllIllIllllll)) {
            return lllllllllllllIlIIIllllIlllIIIIll;
        }
        if (lllllllllllllIlIIIllllIllIlllllI == null) {
            lllllllllllllIlIIIllllIllIlllllI = "";
        }
        lllllllllllllIlIIIllllIlllIIIIll = lllllllllllllIlIIIllllIlllIIIIll.substring(lllllllllllllIlIIIllllIllIllllll.length());
        return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIIIllllIllIlllllI)).append(lllllllllllllIlIIIllllIlllIIIIll));
    }
    
    public static String replaceSuffix(String lllllllllllllIlIIIllllIlllIIllII, final String lllllllllllllIlIIIllllIlllIIlIll, String lllllllllllllIlIIIllllIlllIIIlll) {
        if (lllllllllllllIlIIIllllIlllIIllII == null || lllllllllllllIlIIIllllIlllIIlIll == null) {
            return lllllllllllllIlIIIllllIlllIIllII;
        }
        if (!lllllllllllllIlIIIllllIlllIIllII.endsWith(lllllllllllllIlIIIllllIlllIIlIll)) {
            return lllllllllllllIlIIIllllIlllIIllII;
        }
        if (lllllllllllllIlIIIllllIlllIIIlll == null) {
            lllllllllllllIlIIIllllIlllIIIlll = "";
        }
        lllllllllllllIlIIIllllIlllIIllII = lllllllllllllIlIIIllllIlllIIllII.substring(0, lllllllllllllIlIIIllllIlllIIllII.length() - lllllllllllllIlIIIllllIlllIIlIll.length());
        return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIIIllllIlllIIllII)).append((String)lllllllllllllIlIIIllllIlllIIIlll));
    }
    
    public static String removePrefix(String lllllllllllllIlIIIllllIlIlllIIII, final String[] lllllllllllllIlIIIllllIlIllIllll) {
        if (lllllllllllllIlIIIllllIlIlllIIII != null && lllllllllllllIlIIIllllIlIllIllll != null) {
            final int lllllllllllllIlIIIllllIlIlllIIll = ((String)lllllllllllllIlIIIllllIlIlllIIII).length();
            for (int lllllllllllllIlIIIllllIlIlllIIlI = 0; lllllllllllllIlIIIllllIlIlllIIlI < lllllllllllllIlIIIllllIlIllIllll.length; ++lllllllllllllIlIIIllllIlIlllIIlI) {
                final String lllllllllllllIlIIIllllIlIlllIIIl = lllllllllllllIlIIIllllIlIllIllll[lllllllllllllIlIIIllllIlIlllIIlI];
                lllllllllllllIlIIIllllIlIlllIIII = removePrefix((String)lllllllllllllIlIIIllllIlIlllIIII, lllllllllllllIlIIIllllIlIlllIIIl);
                if (((String)lllllllllllllIlIIIllllIlIlllIIII).length() != lllllllllllllIlIIIllllIlIlllIIll) {
                    break;
                }
            }
            return (String)lllllllllllllIlIIIllllIlIlllIIII;
        }
        return (String)lllllllllllllIlIIIllllIlIlllIIII;
    }
    
    public static String removePrefixSuffix(final String lllllllllllllIlIIIllllIlIlIlllll, final String lllllllllllllIlIIIllllIlIlIllIll, final String lllllllllllllIlIIIllllIlIlIllIlI) {
        return removePrefixSuffix(lllllllllllllIlIIIllllIlIlIlllll, new String[] { lllllllllllllIlIIIllllIlIlIllIll }, new String[] { lllllllllllllIlIIIllllIlIlIllIlI });
    }
    
    public static String addPrefixCheck(final String lllllllllllllIlIIIllllIlIlIIIIII, final String lllllllllllllIlIIIllllIlIlIIIIIl) {
        if (lllllllllllllIlIIIllllIlIlIIIIII != null && lllllllllllllIlIIIllllIlIlIIIIIl != null) {
            return lllllllllllllIlIIIllllIlIlIIIIII.endsWith(lllllllllllllIlIIIllllIlIlIIIIIl) ? lllllllllllllIlIIIllllIlIlIIIIII : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIIIllllIlIlIIIIIl)).append(lllllllllllllIlIIIllllIlIlIIIIII));
        }
        return lllllllllllllIlIIIllllIlIlIIIIII;
    }
    
    public static boolean isFilled(final String lllllllllllllIlIIIlllllIIIIllllI) {
        return !isEmpty(lllllllllllllIlIIIlllllIIIIllllI);
    }
    
    public static boolean startsWith(final String lllllllllllllIlIIIllllIllllIlIll, final String[] lllllllllllllIlIIIllllIllllIlIlI) {
        if (lllllllllllllIlIIIllllIllllIlIll == null) {
            return false;
        }
        if (lllllllllllllIlIIIllllIllllIlIlI == null) {
            return false;
        }
        for (int lllllllllllllIlIIIllllIllllIllIl = 0; lllllllllllllIlIIIllllIllllIllIl < lllllllllllllIlIIIllllIllllIlIlI.length; ++lllllllllllllIlIIIllllIllllIllIl) {
            final String lllllllllllllIlIIIllllIllllIllII = lllllllllllllIlIIIllllIllllIlIlI[lllllllllllllIlIIIllllIllllIllIl];
            if (lllllllllllllIlIIIllllIllllIlIll.startsWith(lllllllllllllIlIIIllllIllllIllII)) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean equals(final char lllllllllllllIlIIIlllllIIIlllllI, final String lllllllllllllIlIIIlllllIIIllllIl) {
        for (int lllllllllllllIlIIIlllllIIIllllll = 0; lllllllllllllIlIIIlllllIIIllllll < lllllllllllllIlIIIlllllIIIllllIl.length(); ++lllllllllllllIlIIIlllllIIIllllll) {
            if (lllllllllllllIlIIIlllllIIIllllIl.charAt(lllllllllllllIlIIIlllllIIIllllll) == lllllllllllllIlIIIlllllIIIlllllI) {
                return true;
            }
        }
        return false;
    }
}
