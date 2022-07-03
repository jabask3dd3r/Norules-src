package net.minecraft.profiler;

import optifine.*;
import net.minecraft.client.renderer.*;
import org.apache.logging.log4j.*;
import java.util.function.*;
import java.util.*;
import com.google.common.collect.*;

public class Profiler
{
    private static final /* synthetic */ int HASH_DISPLAY;
    private static final /* synthetic */ int HASH_RENDER;
    private static final /* synthetic */ int HASH_PRE_RENDER_ERRORS;
    public /* synthetic */ boolean profilerGlobalEnabled;
    private /* synthetic */ boolean profilerLocalEnabled;
    public /* synthetic */ boolean profilingEnabled;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ List<String> sectionList;
    private static final /* synthetic */ int HASH_SCHEDULED_EXECUTABLES;
    private static final /* synthetic */ int HASH_TICK;
    private /* synthetic */ String profilingSection;
    private final /* synthetic */ List<Long> timestampList;
    private final /* synthetic */ Map<String, Long> profilingMap;
    
    public void clearProfiling() {
        this.profilingMap.clear();
        this.profilingSection = "";
        this.sectionList.clear();
        this.profilerLocalEnabled = this.profilerGlobalEnabled;
    }
    
    public void startSection(final String lllllllllllllllllIlllIIllIIIllll) {
        if (Lagometer.isActive()) {
            final int lllllllllllllllllIlllIIllIIIlllI = lllllllllllllllllIlllIIllIIIllll.hashCode();
            if (lllllllllllllllllIlllIIllIIIlllI == Profiler.HASH_SCHEDULED_EXECUTABLES && lllllllllllllllllIlllIIllIIIllll.equals("scheduledExecutables")) {
                Lagometer.timerScheduledExecutables.start();
            }
            else if (lllllllllllllllllIlllIIllIIIlllI == Profiler.HASH_TICK && lllllllllllllllllIlllIIllIIIllll.equals("tick") && Config.isMinecraftThread()) {
                Lagometer.timerScheduledExecutables.end();
                Lagometer.timerTick.start();
            }
            else if (lllllllllllllllllIlllIIllIIIlllI == Profiler.HASH_PRE_RENDER_ERRORS && lllllllllllllllllIlllIIllIIIllll.equals("preRenderErrors")) {
                Lagometer.timerTick.end();
            }
        }
        if (Config.isFastRender()) {
            final int lllllllllllllllllIlllIIllIIIllIl = lllllllllllllllllIlllIIllIIIllll.hashCode();
            if (lllllllllllllllllIlllIIllIIIllIl == Profiler.HASH_RENDER && lllllllllllllllllIlllIIllIIIllll.equals("render")) {
                GlStateManager.clearEnabled = false;
            }
            else if (lllllllllllllllllIlllIIllIIIllIl == Profiler.HASH_DISPLAY && lllllllllllllllllIlllIIllIIIllll.equals("display")) {
                GlStateManager.clearEnabled = true;
            }
        }
        if (this.profilerLocalEnabled && this.profilingEnabled) {
            if (!this.profilingSection.isEmpty()) {
                this.profilingSection = String.valueOf(new StringBuilder(String.valueOf(this.profilingSection)).append("."));
            }
            this.profilingSection = String.valueOf(new StringBuilder(String.valueOf(this.profilingSection)).append(lllllllllllllllllIlllIIllIIIllll));
            this.sectionList.add(this.profilingSection);
            this.timestampList.add(System.nanoTime());
        }
    }
    
    static {
        DISPLAY = "display";
        TICK = "tick";
        SCHEDULED_EXECUTABLES = "scheduledExecutables";
        PRE_RENDER_ERRORS = "preRenderErrors";
        RENDER = "render";
        LOGGER = LogManager.getLogger();
        HASH_SCHEDULED_EXECUTABLES = "scheduledExecutables".hashCode();
        HASH_TICK = "tick".hashCode();
        HASH_PRE_RENDER_ERRORS = "preRenderErrors".hashCode();
        HASH_RENDER = "render".hashCode();
        HASH_DISPLAY = "display".hashCode();
    }
    
    public void startSection(final Class<?> lllllllllllllllllIlllIIlIIllllIl) {
        if (this.profilingEnabled) {
            this.startSection(lllllllllllllllllIlllIIlIIllllIl.getSimpleName());
        }
    }
    
    public void func_194340_a(final Supplier<String> lllllllllllllllllIlllIIllIIIIlII) {
        if (this.profilerLocalEnabled && this.profilingEnabled) {
            this.startSection(lllllllllllllllllIlllIIllIIIIlII.get());
        }
    }
    
    public void endSection() {
        if (this.profilerLocalEnabled && this.profilingEnabled) {
            final long lllllllllllllllllIlllIIlIllllllI = System.nanoTime();
            final long lllllllllllllllllIlllIIlIlllllIl = this.timestampList.remove(this.timestampList.size() - 1);
            this.sectionList.remove(this.sectionList.size() - 1);
            final long lllllllllllllllllIlllIIlIlllllII = lllllllllllllllllIlllIIlIllllllI - lllllllllllllllllIlllIIlIlllllIl;
            if (this.profilingMap.containsKey(this.profilingSection)) {
                this.profilingMap.put(this.profilingSection, this.profilingMap.get(this.profilingSection) + lllllllllllllllllIlllIIlIlllllII);
            }
            else {
                this.profilingMap.put(this.profilingSection, lllllllllllllllllIlllIIlIlllllII);
            }
            if (lllllllllllllllllIlllIIlIlllllII > 100000000L) {
                Profiler.LOGGER.warn("Something's taking too long! '{}' took aprox {} ms", (Object)this.profilingSection, (Object)(lllllllllllllllllIlllIIlIlllllII / 1000000.0));
            }
            this.profilingSection = (this.sectionList.isEmpty() ? "" : this.sectionList.get(this.sectionList.size() - 1));
        }
    }
    
    public List<Result> getProfilingData(String lllllllllllllllllIlllIIlIlIllIll) {
        if (!this.profilingEnabled) {
            return Collections.emptyList();
        }
        long lllllllllllllllllIlllIIlIllIlIII = this.profilingMap.containsKey("root") ? this.profilingMap.get("root") : 0L;
        final long lllllllllllllllllIlllIIlIllIIlll = this.profilingMap.containsKey(lllllllllllllllllIlllIIlIlIllIll) ? this.profilingMap.get(lllllllllllllllllIlllIIlIlIllIll) : -1L;
        final List<Result> lllllllllllllllllIlllIIlIllIIllI = (List<Result>)Lists.newArrayList();
        if (!lllllllllllllllllIlllIIlIlIllIll.isEmpty()) {
            lllllllllllllllllIlllIIlIlIllIll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllllIlllIIlIlIllIll)).append("."));
        }
        long lllllllllllllllllIlllIIlIllIIlIl = 0L;
        for (final String lllllllllllllllllIlllIIlIllIIlII : this.profilingMap.keySet()) {
            if (lllllllllllllllllIlllIIlIllIIlII.length() > lllllllllllllllllIlllIIlIlIllIll.length() && lllllllllllllllllIlllIIlIllIIlII.startsWith(lllllllllllllllllIlllIIlIlIllIll) && lllllllllllllllllIlllIIlIllIIlII.indexOf(".", lllllllllllllllllIlllIIlIlIllIll.length() + 1) < 0) {
                lllllllllllllllllIlllIIlIllIIlIl += this.profilingMap.get(lllllllllllllllllIlllIIlIllIIlII);
            }
        }
        final float lllllllllllllllllIlllIIlIllIIIll = (float)lllllllllllllllllIlllIIlIllIIlIl;
        if (lllllllllllllllllIlllIIlIllIIlIl < lllllllllllllllllIlllIIlIllIIlll) {
            lllllllllllllllllIlllIIlIllIIlIl = lllllllllllllllllIlllIIlIllIIlll;
        }
        if (lllllllllllllllllIlllIIlIllIlIII < lllllllllllllllllIlllIIlIllIIlIl) {
            lllllllllllllllllIlllIIlIllIlIII = lllllllllllllllllIlllIIlIllIIlIl;
        }
        for (final String lllllllllllllllllIlllIIlIllIIIlI : this.profilingMap.keySet()) {
            if (lllllllllllllllllIlllIIlIllIIIlI.length() > lllllllllllllllllIlllIIlIlIllIll.length() && lllllllllllllllllIlllIIlIllIIIlI.startsWith(lllllllllllllllllIlllIIlIlIllIll) && lllllllllllllllllIlllIIlIllIIIlI.indexOf(".", lllllllllllllllllIlllIIlIlIllIll.length() + 1) < 0) {
                final long lllllllllllllllllIlllIIlIllIIIIl = this.profilingMap.get(lllllllllllllllllIlllIIlIllIIIlI);
                final double lllllllllllllllllIlllIIlIllIIIII = lllllllllllllllllIlllIIlIllIIIIl * 100.0 / lllllllllllllllllIlllIIlIllIIlIl;
                final double lllllllllllllllllIlllIIlIlIlllll = lllllllllllllllllIlllIIlIllIIIIl * 100.0 / lllllllllllllllllIlllIIlIllIlIII;
                final String lllllllllllllllllIlllIIlIlIllllI = lllllllllllllllllIlllIIlIllIIIlI.substring(lllllllllllllllllIlllIIlIlIllIll.length());
                lllllllllllllllllIlllIIlIllIIllI.add(new Result(lllllllllllllllllIlllIIlIlIllllI, lllllllllllllllllIlllIIlIllIIIII, lllllllllllllllllIlllIIlIlIlllll));
            }
        }
        for (final String lllllllllllllllllIlllIIlIlIlllIl : this.profilingMap.keySet()) {
            this.profilingMap.put(lllllllllllllllllIlllIIlIlIlllIl, this.profilingMap.get(lllllllllllllllllIlllIIlIlIlllIl) * 950L / 1000L);
        }
        if (lllllllllllllllllIlllIIlIllIIlIl > lllllllllllllllllIlllIIlIllIIIll) {
            lllllllllllllllllIlllIIlIllIIllI.add(new Result("unspecified", (lllllllllllllllllIlllIIlIllIIlIl - lllllllllllllllllIlllIIlIllIIIll) * 100.0 / lllllllllllllllllIlllIIlIllIIlIl, (lllllllllllllllllIlllIIlIllIIlIl - lllllllllllllllllIlllIIlIllIIIll) * 100.0 / lllllllllllllllllIlllIIlIllIlIII));
        }
        Collections.sort(lllllllllllllllllIlllIIlIllIIllI);
        lllllllllllllllllIlllIIlIllIIllI.add(0, new Result(lllllllllllllllllIlllIIlIlIllIll, 100.0, lllllllllllllllllIlllIIlIllIIlIl * 100.0 / lllllllllllllllllIlllIIlIllIlIII));
        return lllllllllllllllllIlllIIlIllIIllI;
    }
    
    public void endStartSection(final String lllllllllllllllllIlllIIlIlIIlIlI) {
        if (this.profilerLocalEnabled) {
            this.endSection();
            this.startSection(lllllllllllllllllIlllIIlIlIIlIlI);
        }
    }
    
    public Profiler() {
        this.sectionList = (List<String>)Lists.newArrayList();
        this.timestampList = (List<Long>)Lists.newArrayList();
        this.profilingSection = "";
        this.profilingMap = (Map<String, Long>)Maps.newHashMap();
        this.profilerGlobalEnabled = true;
        this.profilerLocalEnabled = this.profilerGlobalEnabled;
    }
    
    public String getNameOfLastSection() {
        return this.sectionList.isEmpty() ? "[UNKNOWN]" : this.sectionList.get(this.sectionList.size() - 1);
    }
    
    public void func_194339_b(final Supplier<String> lllllllllllllllllIlllIIlIlIIIllI) {
        if (this.profilerLocalEnabled) {
            this.endSection();
            this.func_194340_a(lllllllllllllllllIlllIIlIlIIIllI);
        }
    }
    
    public static final class Result implements Comparable<Result>
    {
        public /* synthetic */ String profilerName;
        public /* synthetic */ double usePercentage;
        public /* synthetic */ double totalUsePercentage;
        
        public int getColor() {
            return (this.profilerName.hashCode() & 0xAAAAAA) + 4473924;
        }
        
        @Override
        public int compareTo(final Result lllllllllllllIIIIlIIlIIlIIIllIll) {
            if (lllllllllllllIIIIlIIlIIlIIIllIll.usePercentage < this.usePercentage) {
                return -1;
            }
            return (lllllllllllllIIIIlIIlIIlIIIllIll.usePercentage > this.usePercentage) ? 1 : lllllllllllllIIIIlIIlIIlIIIllIll.profilerName.compareTo(this.profilerName);
        }
        
        public Result(final String lllllllllllllIIIIlIIlIIlIIlIIlll, final double lllllllllllllIIIIlIIlIIlIIlIIIlI, final double lllllllllllllIIIIlIIlIIlIIlIIIIl) {
            this.profilerName = lllllllllllllIIIIlIIlIIlIIlIIlll;
            this.usePercentage = lllllllllllllIIIIlIIlIIlIIlIIIlI;
            this.totalUsePercentage = lllllllllllllIIIIlIIlIIlIIlIIIIl;
        }
    }
}
