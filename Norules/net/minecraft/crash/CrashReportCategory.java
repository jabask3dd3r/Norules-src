package net.minecraft.crash;

import java.util.*;
import com.google.common.collect.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;

public class CrashReportCategory
{
    private final /* synthetic */ String name;
    private final /* synthetic */ CrashReport crashReport;
    private /* synthetic */ StackTraceElement[] stackTrace;
    private final /* synthetic */ List<Entry> children;
    
    public CrashReportCategory(final CrashReport llIIlIIllIllIII, final String llIIlIIllIlIlII) {
        this.children = (List<Entry>)Lists.newArrayList();
        this.stackTrace = new StackTraceElement[0];
        this.crashReport = llIIlIIllIllIII;
        this.name = llIIlIIllIlIlII;
    }
    
    public boolean firstTwoElementsOfStackTraceMatch(final StackTraceElement llIIlIIIllIIlIl, final StackTraceElement llIIlIIIllIIIII) {
        if (this.stackTrace.length == 0 || llIIlIIIllIIlIl == null) {
            return false;
        }
        final StackTraceElement llIIlIIIllIIIll = this.stackTrace[0];
        if (llIIlIIIllIIIll.isNativeMethod() != llIIlIIIllIIlIl.isNativeMethod() || !llIIlIIIllIIIll.getClassName().equals(llIIlIIIllIIlIl.getClassName()) || !llIIlIIIllIIIll.getFileName().equals(llIIlIIIllIIlIl.getFileName()) || !llIIlIIIllIIIll.getMethodName().equals(llIIlIIIllIIlIl.getMethodName())) {
            return false;
        }
        if (llIIlIIIllIIIII != null != this.stackTrace.length > 1) {
            return false;
        }
        if (llIIlIIIllIIIII != null && !this.stackTrace[1].equals(llIIlIIIllIIIII)) {
            return false;
        }
        this.stackTrace[0] = llIIlIIIllIIlIl;
        return true;
    }
    
    public void addCrashSection(final String llIIlIIIllllllI, final Object llIIlIIlIIIIIII) {
        this.children.add(new Entry(llIIlIIIllllllI, llIIlIIlIIIIIII));
    }
    
    public void appendToStringBuilder(final StringBuilder llIIlIIIlIIlllI) {
        llIIlIIIlIIlllI.append("-- ").append(this.name).append(" --\n");
        llIIlIIIlIIlllI.append("Details:");
        for (final Entry llIIlIIIlIIllIl : this.children) {
            llIIlIIIlIIlllI.append("\n\t");
            llIIlIIIlIIlllI.append(llIIlIIIlIIllIl.getKey());
            llIIlIIIlIIlllI.append(": ");
            llIIlIIIlIIlllI.append(llIIlIIIlIIllIl.getValue());
        }
        if (this.stackTrace != null && this.stackTrace.length > 0) {
            llIIlIIIlIIlllI.append("\nStacktrace:");
            final double llIIlIIIlIIIllI;
            final boolean llIIlIIIlIIIlll = ((StackTraceElement[])(Object)(llIIlIIIlIIIllI = (double)(Object)this.stackTrace)).length != 0;
            for (byte llIIlIIIlIIlIII = 0; llIIlIIIlIIlIII < (llIIlIIIlIIIlll ? 1 : 0); ++llIIlIIIlIIlIII) {
                final StackTraceElement llIIlIIIlIIllII = llIIlIIIlIIIllI[llIIlIIIlIIlIII];
                llIIlIIIlIIlllI.append("\n\tat ");
                llIIlIIIlIIlllI.append(llIIlIIIlIIllII);
            }
        }
    }
    
    public static String getCoordinateInfo(final int llIIlIIlIlllIIl, final int llIIlIIlIIllllI, final int llIIlIIlIIlllIl) {
        final StringBuilder llIIlIIlIllIllI = new StringBuilder();
        try {
            llIIlIIlIllIllI.append(String.format("World: (%d,%d,%d)", llIIlIIlIlllIIl, llIIlIIlIIllllI, llIIlIIlIIlllIl));
        }
        catch (Throwable llIIlIIlIllIlIl) {
            llIIlIIlIllIllI.append("(Error finding world loc)");
        }
        llIIlIIlIllIllI.append(", ");
        try {
            final int llIIlIIlIllIlII = llIIlIIlIlllIIl >> 4;
            final int llIIlIIlIllIIll = llIIlIIlIIlllIl >> 4;
            final int llIIlIIlIllIIlI = llIIlIIlIlllIIl & 0xF;
            final int llIIlIIlIllIIIl = llIIlIIlIIllllI >> 4;
            final int llIIlIIlIllIIII = llIIlIIlIIlllIl & 0xF;
            final int llIIlIIlIlIllll = llIIlIIlIllIlII << 4;
            final int llIIlIIlIlIlllI = llIIlIIlIllIIll << 4;
            final int llIIlIIlIlIllIl = (llIIlIIlIllIlII + 1 << 4) - 1;
            final int llIIlIIlIlIllII = (llIIlIIlIllIIll + 1 << 4) - 1;
            llIIlIIlIllIllI.append(String.format("Chunk: (at %d,%d,%d in %d,%d; contains blocks %d,0,%d to %d,255,%d)", llIIlIIlIllIIlI, llIIlIIlIllIIIl, llIIlIIlIllIIII, llIIlIIlIllIlII, llIIlIIlIllIIll, llIIlIIlIlIllll, llIIlIIlIlIlllI, llIIlIIlIlIllIl, llIIlIIlIlIllII));
        }
        catch (Throwable llIIlIIlIlIlIll) {
            llIIlIIlIllIllI.append("(Error finding chunk loc)");
        }
        llIIlIIlIllIllI.append(", ");
        try {
            final int llIIlIIlIlIlIlI = llIIlIIlIlllIIl >> 9;
            final int llIIlIIlIlIlIIl = llIIlIIlIIlllIl >> 9;
            final int llIIlIIlIlIlIII = llIIlIIlIlIlIlI << 5;
            final int llIIlIIlIlIIlll = llIIlIIlIlIlIIl << 5;
            final int llIIlIIlIlIIllI = (llIIlIIlIlIlIlI + 1 << 5) - 1;
            final int llIIlIIlIlIIlIl = (llIIlIIlIlIlIIl + 1 << 5) - 1;
            final int llIIlIIlIlIIlII = llIIlIIlIlIlIlI << 9;
            final int llIIlIIlIlIIIll = llIIlIIlIlIlIIl << 9;
            final int llIIlIIlIlIIIlI = (llIIlIIlIlIlIlI + 1 << 9) - 1;
            final int llIIlIIlIlIIIIl = (llIIlIIlIlIlIIl + 1 << 9) - 1;
            llIIlIIlIllIllI.append(String.format("Region: (%d,%d; contains chunks %d,%d to %d,%d, blocks %d,0,%d to %d,255,%d)", llIIlIIlIlIlIlI, llIIlIIlIlIlIIl, llIIlIIlIlIlIII, llIIlIIlIlIIlll, llIIlIIlIlIIllI, llIIlIIlIlIIlIl, llIIlIIlIlIIlII, llIIlIIlIlIIIll, llIIlIIlIlIIIlI, llIIlIIlIlIIIIl));
        }
        catch (Throwable llIIlIIlIlIIIII) {
            llIIlIIlIllIllI.append("(Error finding world loc)");
        }
        return String.valueOf(llIIlIIlIllIllI);
    }
    
    public static String getCoordinateInfo(final double llIIlIIllIlIIII, final double llIIlIIllIIllll, final double llIIlIIllIIlIll) {
        return String.format("%.2f,%.2f,%.2f - %s", llIIlIIllIlIIII, llIIlIIllIIllll, llIIlIIllIIlIll, getCoordinateInfo(new BlockPos(llIIlIIllIlIIII, llIIlIIllIIllll, llIIlIIllIIlIll)));
    }
    
    public void trimStackTraceEntriesFromBottom(final int llIIlIIIlIlIlll) {
        final StackTraceElement[] llIIlIIIlIllIIl = new StackTraceElement[this.stackTrace.length - llIIlIIIlIlIlll];
        System.arraycopy(this.stackTrace, 0, llIIlIIIlIllIIl, 0, llIIlIIIlIllIIl.length);
        this.stackTrace = llIIlIIIlIllIIl;
    }
    
    public StackTraceElement[] getStackTrace() {
        return this.stackTrace;
    }
    
    public static void addBlockInfo(final CrashReportCategory llIIlIIIIllIIII, final BlockPos llIIlIIIIlIllll, final IBlockState llIIlIIIIlIlIll) {
        llIIlIIIIllIIII.setDetail("Block", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return llIIlIIIIlIlIll.toString();
            }
        });
        llIIlIIIIllIIII.setDetail("Block location", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return CrashReportCategory.getCoordinateInfo(llIIlIIIIlIllll);
            }
        });
    }
    
    public void addCrashSectionThrowable(final String llIIlIIIllllIII, final Throwable llIIlIIIlllIlII) {
        this.addCrashSection(llIIlIIIllllIII, llIIlIIIlllIlII);
    }
    
    public int getPrunedStackTrace(final int llIIlIIIllIllII) {
        final StackTraceElement[] llIIlIIIllIlllI = Thread.currentThread().getStackTrace();
        if (llIIlIIIllIlllI.length <= 0) {
            return 0;
        }
        this.stackTrace = new StackTraceElement[llIIlIIIllIlllI.length - 3 - llIIlIIIllIllII];
        System.arraycopy(llIIlIIIllIlllI, 3 + llIIlIIIllIllII, this.stackTrace, 0, this.stackTrace.length);
        return this.stackTrace.length;
    }
    
    public void setDetail(final String llIIlIIlIIIllII, final ICrashReportDetail<String> llIIlIIlIIIlIll) {
        try {
            this.addCrashSection(llIIlIIlIIIllII, llIIlIIlIIIlIll.call());
        }
        catch (Throwable llIIlIIlIIIlIlI) {
            this.addCrashSectionThrowable(llIIlIIlIIIllII, llIIlIIlIIIlIlI);
        }
    }
    
    public static String getCoordinateInfo(final BlockPos llIIlIIllIIlIIl) {
        return getCoordinateInfo(llIIlIIllIIlIIl.getX(), llIIlIIllIIlIIl.getY(), llIIlIIllIIlIIl.getZ());
    }
    
    public static void addBlockInfo(final CrashReportCategory llIIlIIIIllllIl, final BlockPos llIIlIIIIllIlll, final Block llIIlIIIIllIllI, final int llIIlIIIIlllIlI) {
        final int llIIlIIIIlllIIl = Block.getIdFromBlock(llIIlIIIIllIllI);
        llIIlIIIIllllIl.setDetail("Block type", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                try {
                    return String.format("ID #%d (%s // %s)", llIIlIIIIlllIIl, llIIlIIIIllIllI.getUnlocalizedName(), llIIlIIIIllIllI.getClass().getCanonicalName());
                }
                catch (Throwable lllllllllllllllIIIlIlllllIIIlIIl) {
                    return String.valueOf(new StringBuilder("ID #").append(llIIlIIIIlllIIl));
                }
            }
        });
        llIIlIIIIllllIl.setDetail("Block data value", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                if (llIIlIIIIlllIlI < 0) {
                    return String.valueOf(new StringBuilder("Unknown? (Got ").append(llIIlIIIIlllIlI).append(")"));
                }
                final String lllllllllllllIIIIIIIIIllIIllIlII = String.format("%4s", Integer.toBinaryString(llIIlIIIIlllIlI)).replace(" ", "0");
                return String.format("%1$d / 0x%1$X / 0b%2$s", llIIlIIIIlllIlI, lllllllllllllIIIIIIIIIllIIllIlII);
            }
        });
        llIIlIIIIllllIl.setDetail("Block location", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return CrashReportCategory.getCoordinateInfo(llIIlIIIIllIlll);
            }
        });
    }
    
    static class Entry
    {
        private final /* synthetic */ String value;
        private final /* synthetic */ String key;
        
        public String getKey() {
            return this.key;
        }
        
        public Entry(final String llllllllllllllIlllIIlllIIlllIlII, final Object llllllllllllllIlllIIlllIIlllIIll) {
            this.key = llllllllllllllIlllIIlllIIlllIlII;
            if (llllllllllllllIlllIIlllIIlllIIll == null) {
                this.value = "~~NULL~~";
            }
            else if (llllllllllllllIlllIIlllIIlllIIll instanceof Throwable) {
                final Throwable llllllllllllllIlllIIlllIIlllIllI = (Throwable)llllllllllllllIlllIIlllIIlllIIll;
                this.value = String.valueOf(new StringBuilder("~~ERROR~~ ").append(llllllllllllllIlllIIlllIIlllIllI.getClass().getSimpleName()).append(": ").append(llllllllllllllIlllIIlllIIlllIllI.getMessage()));
            }
            else {
                this.value = llllllllllllllIlllIIlllIIlllIIll.toString();
            }
        }
        
        public String getValue() {
            return this.value;
        }
    }
}
