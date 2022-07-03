package net.minecraft.client.util;

import com.google.common.collect.*;
import java.util.*;
import it.unimi.dsi.fastutil.ints.*;
import it.unimi.dsi.fastutil.*;
import org.apache.logging.log4j.*;

public class SuffixArray<T>
{
    private static final /* synthetic */ Logger field_194064_d;
    protected final /* synthetic */ List<T> field_194061_a;
    private /* synthetic */ int field_194069_i;
    private final /* synthetic */ IntList field_194066_f;
    private /* synthetic */ IntList field_194068_h;
    private /* synthetic */ IntList field_194067_g;
    private static final /* synthetic */ boolean field_194063_c;
    private final /* synthetic */ IntList field_194065_e;
    private static final /* synthetic */ boolean field_194062_b;
    
    public List<T> func_194055_a(final String llllllllllllllIlIlllIIIIIllIllII) {
        final int llllllllllllllIlIlllIIIIIllllIll = this.field_194067_g.size();
        int llllllllllllllIlIlllIIIIIllllIlI = 0;
        int llllllllllllllIlIlllIIIIIllllIIl = llllllllllllllIlIlllIIIIIllllIll;
        while (llllllllllllllIlIlllIIIIIllllIlI < llllllllllllllIlIlllIIIIIllllIIl) {
            final int llllllllllllllIlIlllIIIIIllllIII = llllllllllllllIlIlllIIIIIllllIlI + (llllllllllllllIlIlllIIIIIllllIIl - llllllllllllllIlIlllIIIIIllllIlI) / 2;
            final int llllllllllllllIlIlllIIIIIlllIlll = this.func_194056_a(llllllllllllllIlIlllIIIIIllIllII, llllllllllllllIlIlllIIIIIllllIII);
            if (SuffixArray.field_194062_b) {
                SuffixArray.field_194064_d.debug("comparing lower \"{}\" with {} \"{}\": {}", (Object)llllllllllllllIlIlllIIIIIllIllII, (Object)llllllllllllllIlIlllIIIIIllllIII, (Object)this.func_194059_a(llllllllllllllIlIlllIIIIIllllIII), (Object)llllllllllllllIlIlllIIIIIlllIlll);
            }
            if (llllllllllllllIlIlllIIIIIlllIlll > 0) {
                llllllllllllllIlIlllIIIIIllllIlI = llllllllllllllIlIlllIIIIIllllIII + 1;
            }
            else {
                llllllllllllllIlIlllIIIIIllllIIl = llllllllllllllIlIlllIIIIIllllIII;
            }
        }
        if (llllllllllllllIlIlllIIIIIllllIlI >= 0 && llllllllllllllIlIlllIIIIIllllIlI < llllllllllllllIlIlllIIIIIllllIll) {
            final int llllllllllllllIlIlllIIIIIlllIllI = llllllllllllllIlIlllIIIIIllllIlI;
            llllllllllllllIlIlllIIIIIllllIIl = llllllllllllllIlIlllIIIIIllllIll;
            while (llllllllllllllIlIlllIIIIIllllIlI < llllllllllllllIlIlllIIIIIllllIIl) {
                final int llllllllllllllIlIlllIIIIIlllIlIl = llllllllllllllIlIlllIIIIIllllIlI + (llllllllllllllIlIlllIIIIIllllIIl - llllllllllllllIlIlllIIIIIllllIlI) / 2;
                final int llllllllllllllIlIlllIIIIIlllIlII = this.func_194056_a(llllllllllllllIlIlllIIIIIllIllII, llllllllllllllIlIlllIIIIIlllIlIl);
                if (SuffixArray.field_194062_b) {
                    SuffixArray.field_194064_d.debug("comparing upper \"{}\" with {} \"{}\": {}", (Object)llllllllllllllIlIlllIIIIIllIllII, (Object)llllllllllllllIlIlllIIIIIlllIlIl, (Object)this.func_194059_a(llllllllllllllIlIlllIIIIIlllIlIl), (Object)llllllllllllllIlIlllIIIIIlllIlII);
                }
                if (llllllllllllllIlIlllIIIIIlllIlII >= 0) {
                    llllllllllllllIlIlllIIIIIllllIlI = llllllllllllllIlIlllIIIIIlllIlIl + 1;
                }
                else {
                    llllllllllllllIlIlllIIIIIllllIIl = llllllllllllllIlIlllIIIIIlllIlIl;
                }
            }
            final int llllllllllllllIlIlllIIIIIlllIIll = llllllllllllllIlIlllIIIIIllllIlI;
            final IntSet llllllllllllllIlIlllIIIIIlllIIlI = (IntSet)new IntOpenHashSet();
            for (int llllllllllllllIlIlllIIIIIlllIIIl = llllllllllllllIlIlllIIIIIlllIllI; llllllllllllllIlIlllIIIIIlllIIIl < llllllllllllllIlIlllIIIIIlllIIll; ++llllllllllllllIlIlllIIIIIlllIIIl) {
                llllllllllllllIlIlllIIIIIlllIIlI.add(this.field_194067_g.getInt(llllllllllllllIlIlllIIIIIlllIIIl));
            }
            final int[] llllllllllllllIlIlllIIIIIlllIIII = llllllllllllllIlIlllIIIIIlllIIlI.toIntArray();
            Arrays.sort(llllllllllllllIlIlllIIIIIlllIIII);
            final Set<T> llllllllllllllIlIlllIIIIIllIllll = (Set<T>)Sets.newLinkedHashSet();
            final short llllllllllllllIlIlllIIIIIllIIIII;
            final float llllllllllllllIlIlllIIIIIllIIIIl = ((int[])(Object)(llllllllllllllIlIlllIIIIIllIIIII = (short)(Object)llllllllllllllIlIlllIIIIIlllIIII)).length;
            for (boolean llllllllllllllIlIlllIIIIIllIIIlI = false; (llllllllllllllIlIlllIIIIIllIIIlI ? 1 : 0) < llllllllllllllIlIlllIIIIIllIIIIl; ++llllllllllllllIlIlllIIIIIllIIIlI) {
                final int llllllllllllllIlIlllIIIIIllIlllI = llllllllllllllIlIlllIIIIIllIIIII[llllllllllllllIlIlllIIIIIllIIIlI];
                llllllllllllllIlIlllIIIIIllIllll.add(this.field_194061_a.get(llllllllllllllIlIlllIIIIIllIlllI));
            }
            return (List<T>)Lists.newArrayList((Iterable)llllllllllllllIlIlllIIIIIllIllll);
        }
        return Collections.emptyList();
    }
    
    private int func_194056_a(final String llllllllllllllIlIlllIIIIlIIlIIll, final int llllllllllllllIlIlllIIIIlIIllIll) {
        final int llllllllllllllIlIlllIIIIlIIllIlI = this.field_194066_f.getInt(this.field_194067_g.getInt(llllllllllllllIlIlllIIIIlIIllIll));
        final int llllllllllllllIlIlllIIIIlIIllIIl = this.field_194068_h.getInt(llllllllllllllIlIlllIIIIlIIllIll);
        for (int llllllllllllllIlIlllIIIIlIIllIII = 0; llllllllllllllIlIlllIIIIlIIllIII < llllllllllllllIlIlllIIIIlIIlIIll.length(); ++llllllllllllllIlIlllIIIIlIIllIII) {
            final int llllllllllllllIlIlllIIIIlIIlIlll = this.field_194065_e.getInt(llllllllllllllIlIlllIIIIlIIllIlI + llllllllllllllIlIlllIIIIlIIllIIl + llllllllllllllIlIlllIIIIlIIllIII);
            if (llllllllllllllIlIlllIIIIlIIlIlll == -1) {
                return 1;
            }
            final char llllllllllllllIlIlllIIIIlIIlIllI = llllllllllllllIlIlllIIIIlIIlIIll.charAt(llllllllllllllIlIlllIIIIlIIllIII);
            final char llllllllllllllIlIlllIIIIlIIlIlIl = (char)llllllllllllllIlIlllIIIIlIIlIlll;
            if (llllllllllllllIlIlllIIIIlIIlIllI < llllllllllllllIlIlllIIIIlIIlIlIl) {
                return -1;
            }
            if (llllllllllllllIlIlllIIIIlIIlIllI > llllllllllllllIlIlllIIIIlIIlIlIl) {
                return 1;
            }
        }
        return 0;
    }
    
    public void func_194058_a() {
        final int llllllllllllllIlIlllIIIIllIllllI = this.field_194065_e.size();
        final int[] llllllllllllllIlIlllIIIIllIlllIl = new int[llllllllllllllIlIlllIIIIllIllllI];
        final int[] llllllllllllllIlIlllIIIIllIlllII = new int[llllllllllllllIlIlllIIIIllIllllI];
        final int[] llllllllllllllIlIlllIIIIllIllIll = new int[llllllllllllllIlIlllIIIIllIllllI];
        final int[] llllllllllllllIlIlllIIIIllIllIlI = new int[llllllllllllllIlIlllIIIIllIllllI];
        final IntComparator llllllllllllllIlIlllIIIIllIllIIl = (IntComparator)new IntComparator() {
            public int compare(final int lllllllllllllIIlIIlIIlIlIIlIlIlI, final int lllllllllllllIIlIIlIIlIlIIlIlIIl) {
                return (llllllllllllllIlIlllIIIIllIlllII[lllllllllllllIIlIIlIIlIlIIlIlIlI] == llllllllllllllIlIlllIIIIllIlllII[lllllllllllllIIlIIlIIlIlIIlIlIIl]) ? Integer.compare(llllllllllllllIlIlllIIIIllIllIll[lllllllllllllIIlIIlIIlIlIIlIlIlI], llllllllllllllIlIlllIIIIllIllIll[lllllllllllllIIlIIlIIlIlIIlIlIIl]) : Integer.compare(llllllllllllllIlIlllIIIIllIlllII[lllllllllllllIIlIIlIIlIlIIlIlIlI], llllllllllllllIlIlllIIIIllIlllII[lllllllllllllIIlIIlIIlIlIIlIlIIl]);
            }
            
            public int compare(final Integer lllllllllllllIIlIIlIIlIlIIIllllI, final Integer lllllllllllllIIlIIlIIlIlIIlIIIII) {
                return this.compare((int)lllllllllllllIIlIIlIIlIlIIIllllI, (int)lllllllllllllIIlIIlIIlIlIIlIIIII);
            }
        };
        final Swapper llllllllllllllIlIlllIIIIllIllIII = (llllllllllllllIlIlllIIIIIlIlIIll, llllllllllllllIlIlllIIIIIlIllIII) -> {
            if (llllllllllllllIlIlllIIIIIlIlIIll != llllllllllllllIlIlllIIIIIlIllIII) {
                int llllllllllllllIlIlllIIIIIlIlIlll = llllllllllllllIlIlllIIIIllIlllII[llllllllllllllIlIlllIIIIIlIlIIll];
                llllllllllllllIlIlllIIIIllIlllII[llllllllllllllIlIlllIIIIIlIlIIll] = llllllllllllllIlIlllIIIIllIlllII[llllllllllllllIlIlllIIIIIlIllIII];
                llllllllllllllIlIlllIIIIllIlllII[llllllllllllllIlIlllIIIIIlIllIII] = llllllllllllllIlIlllIIIIIlIlIlll;
                llllllllllllllIlIlllIIIIIlIlIlll = llllllllllllllIlIlllIIIIllIllIll[llllllllllllllIlIlllIIIIIlIlIIll];
                llllllllllllllIlIlllIIIIllIllIll[llllllllllllllIlIlllIIIIIlIlIIll] = llllllllllllllIlIlllIIIIllIllIll[llllllllllllllIlIlllIIIIIlIllIII];
                llllllllllllllIlIlllIIIIllIllIll[llllllllllllllIlIlllIIIIIlIllIII] = llllllllllllllIlIlllIIIIIlIlIlll;
                llllllllllllllIlIlllIIIIIlIlIlll = llllllllllllllIlIlllIIIIllIllIlI[llllllllllllllIlIlllIIIIIlIlIIll];
                llllllllllllllIlIlllIIIIllIllIlI[llllllllllllllIlIlllIIIIIlIlIIll] = llllllllllllllIlIlllIIIIllIllIlI[llllllllllllllIlIlllIIIIIlIllIII];
                llllllllllllllIlIlllIIIIllIllIlI[llllllllllllllIlIlllIIIIIlIllIII] = llllllllllllllIlIlllIIIIIlIlIlll;
            }
        };
        for (int llllllllllllllIlIlllIIIIllIlIlll = 0; llllllllllllllIlIlllIIIIllIlIlll < llllllllllllllIlIlllIIIIllIllllI; ++llllllllllllllIlIlllIIIIllIlIlll) {
            llllllllllllllIlIlllIIIIllIlllIl[llllllllllllllIlIlllIIIIllIlIlll] = this.field_194065_e.getInt(llllllllllllllIlIlllIIIIllIlIlll);
        }
        for (int llllllllllllllIlIlllIIIIllIlIllI = 1, llllllllllllllIlIlllIIIIllIlIlIl = Math.min(llllllllllllllIlIlllIIIIllIllllI, this.field_194069_i); llllllllllllllIlIlllIIIIllIlIllI * 2 < llllllllllllllIlIlllIIIIllIlIlIl; llllllllllllllIlIlllIIIIllIlIllI *= 2) {
            for (int llllllllllllllIlIlllIIIIllIlIlII = 0; llllllllllllllIlIlllIIIIllIlIlII < llllllllllllllIlIlllIIIIllIllllI; llllllllllllllIlIlllIIIIllIllIlI[llllllllllllllIlIlllIIIIllIlIlII] = llllllllllllllIlIlllIIIIllIlIlII++) {
                llllllllllllllIlIlllIIIIllIlllII[llllllllllllllIlIlllIIIIllIlIlII] = llllllllllllllIlIlllIIIIllIlllIl[llllllllllllllIlIlllIIIIllIlIlII];
                llllllllllllllIlIlllIIIIllIllIll[llllllllllllllIlIlllIIIIllIlIlII] = ((llllllllllllllIlIlllIIIIllIlIlII + llllllllllllllIlIlllIIIIllIlIllI < llllllllllllllIlIlllIIIIllIllllI) ? llllllllllllllIlIlllIIIIllIlllIl[llllllllllllllIlIlllIIIIllIlIlII + llllllllllllllIlIlllIIIIllIlIllI] : -2);
            }
            it.unimi.dsi.fastutil.Arrays.quickSort(0, llllllllllllllIlIlllIIIIllIllllI, llllllllllllllIlIlllIIIIllIllIIl, llllllllllllllIlIlllIIIIllIllIII);
            for (int llllllllllllllIlIlllIIIIllIlIIll = 0; llllllllllllllIlIlllIIIIllIlIIll < llllllllllllllIlIlllIIIIllIllllI; ++llllllllllllllIlIlllIIIIllIlIIll) {
                if (llllllllllllllIlIlllIIIIllIlIIll > 0 && llllllllllllllIlIlllIIIIllIlllII[llllllllllllllIlIlllIIIIllIlIIll] == llllllllllllllIlIlllIIIIllIlllII[llllllllllllllIlIlllIIIIllIlIIll - 1] && llllllllllllllIlIlllIIIIllIllIll[llllllllllllllIlIlllIIIIllIlIIll] == llllllllllllllIlIlllIIIIllIllIll[llllllllllllllIlIlllIIIIllIlIIll - 1]) {
                    llllllllllllllIlIlllIIIIllIlllIl[llllllllllllllIlIlllIIIIllIllIlI[llllllllllllllIlIlllIIIIllIlIIll]] = llllllllllllllIlIlllIIIIllIlllIl[llllllllllllllIlIlllIIIIllIllIlI[llllllllllllllIlIlllIIIIllIlIIll - 1]];
                }
                else {
                    llllllllllllllIlIlllIIIIllIlllIl[llllllllllllllIlIlllIIIIllIllIlI[llllllllllllllIlIlllIIIIllIlIIll]] = llllllllllllllIlIlllIIIIllIlIIll;
                }
            }
        }
        final IntList llllllllllllllIlIlllIIIIllIlIIlI = this.field_194067_g;
        final IntList llllllllllllllIlIlllIIIIllIlIIIl = this.field_194068_h;
        this.field_194067_g = (IntList)new IntArrayList(llllllllllllllIlIlllIIIIllIlIIlI.size());
        this.field_194068_h = (IntList)new IntArrayList(llllllllllllllIlIlllIIIIllIlIIIl.size());
        for (final int llllllllllllllIlIlllIIIIllIIllll : llllllllllllllIlIlllIIIIllIllIlI) {
            this.field_194067_g.add(llllllllllllllIlIlllIIIIllIlIIlI.getInt(llllllllllllllIlIlllIIIIllIIllll));
            this.field_194068_h.add(llllllllllllllIlIlllIIIIllIlIIIl.getInt(llllllllllllllIlIlllIIIIllIIllll));
        }
        if (SuffixArray.field_194063_c) {
            this.func_194060_b();
        }
    }
    
    private void func_194060_b() {
        for (int llllllllllllllIlIlllIIIIlIlllllI = 0; llllllllllllllIlIlllIIIIlIlllllI < this.field_194067_g.size(); ++llllllllllllllIlIlllIIIIlIlllllI) {
            SuffixArray.field_194064_d.debug("{} {}", (Object)llllllllllllllIlIlllIIIIlIlllllI, (Object)this.func_194059_a(llllllllllllllIlIlllIIIIlIlllllI));
        }
        SuffixArray.field_194064_d.debug("");
    }
    
    private String func_194059_a(final int llllllllllllllIlIlllIIIIlIlIllII) {
        final int llllllllllllllIlIlllIIIIlIllIIlI = this.field_194068_h.getInt(llllllllllllllIlIlllIIIIlIlIllII);
        final int llllllllllllllIlIlllIIIIlIllIIIl = this.field_194066_f.getInt(this.field_194067_g.getInt(llllllllllllllIlIlllIIIIlIlIllII));
        final StringBuilder llllllllllllllIlIlllIIIIlIllIIII = new StringBuilder();
        for (int llllllllllllllIlIlllIIIIlIlIllll = 0; llllllllllllllIlIlllIIIIlIllIIIl + llllllllllllllIlIlllIIIIlIlIllll < this.field_194065_e.size(); ++llllllllllllllIlIlllIIIIlIlIllll) {
            if (llllllllllllllIlIlllIIIIlIlIllll == llllllllllllllIlIlllIIIIlIllIIlI) {
                llllllllllllllIlIlllIIIIlIllIIII.append('^');
            }
            final int llllllllllllllIlIlllIIIIlIlIlllI = (int)this.field_194065_e.get(llllllllllllllIlIlllIIIIlIllIIIl + llllllllllllllIlIlllIIIIlIlIllll);
            if (llllllllllllllIlIlllIIIIlIlIlllI == -1) {
                break;
            }
            llllllllllllllIlIlllIIIIlIllIIII.append((char)llllllllllllllIlIlllIIIIlIlIlllI);
        }
        return String.valueOf(llllllllllllllIlIlllIIIIlIllIIII);
    }
    
    static {
        field_194062_b = Boolean.parseBoolean(System.getProperty("SuffixArray.printComparisons", "false"));
        field_194063_c = Boolean.parseBoolean(System.getProperty("SuffixArray.printArray", "false"));
        field_194064_d = LogManager.getLogger();
    }
    
    public SuffixArray() {
        this.field_194061_a = (List<T>)Lists.newArrayList();
        this.field_194065_e = (IntList)new IntArrayList();
        this.field_194066_f = (IntList)new IntArrayList();
        this.field_194067_g = (IntList)new IntArrayList();
        this.field_194068_h = (IntList)new IntArrayList();
    }
    
    public void func_194057_a(final T llllllllllllllIlIlllIIIIllllIlIl, final String llllllllllllllIlIlllIIIIllllIlII) {
        this.field_194069_i = Math.max(this.field_194069_i, llllllllllllllIlIlllIIIIllllIlII.length());
        final int llllllllllllllIlIlllIIIIllllIIll = this.field_194061_a.size();
        this.field_194061_a.add(llllllllllllllIlIlllIIIIllllIlIl);
        this.field_194066_f.add(this.field_194065_e.size());
        for (int llllllllllllllIlIlllIIIIllllIIlI = 0; llllllllllllllIlIlllIIIIllllIIlI < llllllllllllllIlIlllIIIIllllIlII.length(); ++llllllllllllllIlIlllIIIIllllIIlI) {
            this.field_194067_g.add(llllllllllllllIlIlllIIIIllllIIll);
            this.field_194068_h.add(llllllllllllllIlIlllIIIIllllIIlI);
            this.field_194065_e.add((int)llllllllllllllIlIlllIIIIllllIlII.charAt(llllllllllllllIlIlllIIIIllllIIlI));
        }
        this.field_194067_g.add(llllllllllllllIlIlllIIIIllllIIll);
        this.field_194068_h.add(llllllllllllllIlIlllIIIIllllIlII.length());
        this.field_194065_e.add(-1);
    }
}
