package net.minecraft.crash;

import java.lang.management.*;
import net.minecraft.world.gen.layer.*;
import com.google.common.collect.*;
import org.apache.commons.lang3.*;
import optifine.*;
import java.text.*;
import java.util.*;
import net.minecraft.util.*;
import org.apache.logging.log4j.*;
import java.io.*;
import org.apache.commons.io.*;

public class CrashReport
{
    private /* synthetic */ StackTraceElement[] stacktrace;
    private /* synthetic */ boolean firstCategoryInCrashReport;
    private /* synthetic */ File crashReportFile;
    private final /* synthetic */ CrashReportCategory theReportCategory;
    private final /* synthetic */ Throwable cause;
    private final /* synthetic */ List<CrashReportCategory> crashReportSections;
    private /* synthetic */ boolean reported;
    private final /* synthetic */ String description;
    
    private void populateEnvironment() {
        this.theReportCategory.setDetail("Minecraft Version", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                return "1.12.2";
            }
        });
        this.theReportCategory.setDetail("Operating System", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                return String.valueOf(new StringBuilder(String.valueOf(System.getProperty("os.name"))).append(" (").append(System.getProperty("os.arch")).append(") version ").append(System.getProperty("os.version")));
            }
        });
        this.theReportCategory.setDetail("Java Version", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                return String.valueOf(new StringBuilder(String.valueOf(System.getProperty("java.version"))).append(", ").append(System.getProperty("java.vendor")));
            }
        });
        this.theReportCategory.setDetail("Java VM Version", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                return String.valueOf(new StringBuilder(String.valueOf(System.getProperty("java.vm.name"))).append(" (").append(System.getProperty("java.vm.info")).append("), ").append(System.getProperty("java.vm.vendor")));
            }
        });
        this.theReportCategory.setDetail("Memory", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                final Runtime lllIIIlIIlIlII = Runtime.getRuntime();
                final long lllIIIlIIlIIll = lllIIIlIIlIlII.maxMemory();
                final long lllIIIlIIlIIlI = lllIIIlIIlIlII.totalMemory();
                final long lllIIIlIIlIIIl = lllIIIlIIlIlII.freeMemory();
                final long lllIIIlIIlIIII = lllIIIlIIlIIll / 1024L / 1024L;
                final long lllIIIlIIIllll = lllIIIlIIlIIlI / 1024L / 1024L;
                final long lllIIIlIIIlllI = lllIIIlIIlIIIl / 1024L / 1024L;
                return String.valueOf(new StringBuilder(String.valueOf(lllIIIlIIlIIIl)).append(" bytes (").append(lllIIIlIIIlllI).append(" MB) / ").append(lllIIIlIIlIIlI).append(" bytes (").append(lllIIIlIIIllll).append(" MB) up to ").append(lllIIIlIIlIIll).append(" bytes (").append(lllIIIlIIlIIII).append(" MB)"));
            }
        });
        this.theReportCategory.setDetail("JVM Flags", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                final RuntimeMXBean lllllllllllllllIIlllIlIlIlIlIlII = ManagementFactory.getRuntimeMXBean();
                final List<String> lllllllllllllllIIlllIlIlIlIlIIll = lllllllllllllllIIlllIlIlIlIlIlII.getInputArguments();
                int lllllllllllllllIIlllIlIlIlIlIIIl = 0;
                final StringBuilder lllllllllllllllIIlllIlIlIlIlIIII = new StringBuilder();
                for (final String lllllllllllllllIIlllIlIlIlIIllll : lllllllllllllllIIlllIlIlIlIlIIll) {
                    if (lllllllllllllllIIlllIlIlIlIIllll.startsWith("-X")) {
                        if (lllllllllllllllIIlllIlIlIlIlIIIl++ > 0) {
                            lllllllllllllllIIlllIlIlIlIlIIII.append(" ");
                        }
                        lllllllllllllllIIlllIlIlIlIlIIII.append(lllllllllllllllIIlllIlIlIlIIllll);
                    }
                }
                return String.format("%d total; %s", lllllllllllllllIIlllIlIlIlIlIIIl, String.valueOf(lllllllllllllllIIlllIlIlIlIlIIII));
            }
        });
        this.theReportCategory.setDetail("IntCache", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return IntCache.getCacheSizes();
            }
        });
        if (Reflector.FMLCommonHandler_enhanceCrashReport.exists()) {
            final Object lllllllllllllllIllIIIllIlIllIllI = Reflector.call(Reflector.FMLCommonHandler_instance, new Object[0]);
            Reflector.callString(lllllllllllllllIllIIIllIlIllIllI, Reflector.FMLCommonHandler_enhanceCrashReport, this, this.theReportCategory);
        }
    }
    
    public CrashReportCategory makeCategoryDepth(final String lllllllllllllllIllIIIllIIlIlIlII, final int lllllllllllllllIllIIIllIIlIIlIIl) {
        final CrashReportCategory lllllllllllllllIllIIIllIIlIlIIlI = new CrashReportCategory(this, lllllllllllllllIllIIIllIIlIlIlII);
        if (this.firstCategoryInCrashReport) {
            final int lllllllllllllllIllIIIllIIlIlIIIl = lllllllllllllllIllIIIllIIlIlIIlI.getPrunedStackTrace(lllllllllllllllIllIIIllIIlIIlIIl);
            final StackTraceElement[] lllllllllllllllIllIIIllIIlIlIIII = this.cause.getStackTrace();
            StackTraceElement lllllllllllllllIllIIIllIIlIIllll = null;
            StackTraceElement lllllllllllllllIllIIIllIIlIIlllI = null;
            final int lllllllllllllllIllIIIllIIlIIllIl = lllllllllllllllIllIIIllIIlIlIIII.length - lllllllllllllllIllIIIllIIlIlIIIl;
            if (lllllllllllllllIllIIIllIIlIIllIl < 0) {
                System.out.println(String.valueOf(new StringBuilder("Negative index in crash report handler (").append(lllllllllllllllIllIIIllIIlIlIIII.length).append("/").append(lllllllllllllllIllIIIllIIlIlIIIl).append(")")));
            }
            if (lllllllllllllllIllIIIllIIlIlIIII != null && lllllllllllllllIllIIIllIIlIIllIl >= 0 && lllllllllllllllIllIIIllIIlIIllIl < lllllllllllllllIllIIIllIIlIlIIII.length) {
                lllllllllllllllIllIIIllIIlIIllll = lllllllllllllllIllIIIllIIlIlIIII[lllllllllllllllIllIIIllIIlIIllIl];
                if (lllllllllllllllIllIIIllIIlIlIIII.length + 1 - lllllllllllllllIllIIIllIIlIlIIIl < lllllllllllllllIllIIIllIIlIlIIII.length) {
                    lllllllllllllllIllIIIllIIlIIlllI = lllllllllllllllIllIIIllIIlIlIIII[lllllllllllllllIllIIIllIIlIlIIII.length + 1 - lllllllllllllllIllIIIllIIlIlIIIl];
                }
            }
            this.firstCategoryInCrashReport = lllllllllllllllIllIIIllIIlIlIIlI.firstTwoElementsOfStackTraceMatch(lllllllllllllllIllIIIllIIlIIllll, lllllllllllllllIllIIIllIIlIIlllI);
            if (lllllllllllllllIllIIIllIIlIlIIIl > 0 && !this.crashReportSections.isEmpty()) {
                final CrashReportCategory lllllllllllllllIllIIIllIIlIIllII = this.crashReportSections.get(this.crashReportSections.size() - 1);
                lllllllllllllllIllIIIllIIlIIllII.trimStackTraceEntriesFromBottom(lllllllllllllllIllIIIllIIlIlIIIl);
            }
            else if (lllllllllllllllIllIIIllIIlIlIIII != null && lllllllllllllllIllIIIllIIlIlIIII.length >= lllllllllllllllIllIIIllIIlIlIIIl && lllllllllllllllIllIIIllIIlIIllIl >= 0 && lllllllllllllllIllIIIllIIlIIllIl < lllllllllllllllIllIIIllIIlIlIIII.length) {
                this.stacktrace = new StackTraceElement[lllllllllllllllIllIIIllIIlIIllIl];
                System.arraycopy(lllllllllllllllIllIIIllIIlIlIIII, 0, this.stacktrace, 0, this.stacktrace.length);
            }
            else {
                this.firstCategoryInCrashReport = false;
            }
        }
        this.crashReportSections.add(lllllllllllllllIllIIIllIIlIlIIlI);
        return lllllllllllllllIllIIIllIIlIlIIlI;
    }
    
    public CrashReport(final String lllllllllllllllIllIIIllIlIlllllI, final Throwable lllllllllllllllIllIIIllIlIllllIl) {
        this.theReportCategory = new CrashReportCategory(this, "System Details");
        this.crashReportSections = (List<CrashReportCategory>)Lists.newArrayList();
        this.firstCategoryInCrashReport = true;
        this.stacktrace = new StackTraceElement[0];
        this.reported = false;
        this.description = lllllllllllllllIllIIIllIlIlllllI;
        this.cause = lllllllllllllllIllIIIllIlIllllIl;
        this.populateEnvironment();
    }
    
    public void getSectionsInStringBuilder(final StringBuilder lllllllllllllllIllIIIllIlIlIIIlI) {
        if ((this.stacktrace == null || this.stacktrace.length <= 0) && !this.crashReportSections.isEmpty()) {
            this.stacktrace = (StackTraceElement[])ArrayUtils.subarray((Object[])this.crashReportSections.get(0).getStackTrace(), 0, 1);
        }
        if (this.stacktrace != null && this.stacktrace.length > 0) {
            lllllllllllllllIllIIIllIlIlIIIlI.append("-- Head --\n");
            lllllllllllllllIllIIIllIlIlIIIlI.append("Thread: ").append(Thread.currentThread().getName()).append("\n");
            lllllllllllllllIllIIIllIlIlIIIlI.append("Stacktrace:\n");
            final short lllllllllllllllIllIIIllIlIIllllI;
            final char lllllllllllllllIllIIIllIlIIlllll = (char)((StackTraceElement[])(Object)(lllllllllllllllIllIIIllIlIIllllI = (short)(Object)this.stacktrace)).length;
            for (float lllllllllllllllIllIIIllIlIlIIIII = 0; lllllllllllllllIllIIIllIlIlIIIII < lllllllllllllllIllIIIllIlIIlllll; ++lllllllllllllllIllIIIllIlIlIIIII) {
                final StackTraceElement lllllllllllllllIllIIIllIlIlIIlIl = lllllllllllllllIllIIIllIlIIllllI[lllllllllllllllIllIIIllIlIlIIIII];
                lllllllllllllllIllIIIllIlIlIIIlI.append("\t").append("at ").append(lllllllllllllllIllIIIllIlIlIIlIl);
                lllllllllllllllIllIIIllIlIlIIIlI.append("\n");
            }
            lllllllllllllllIllIIIllIlIlIIIlI.append("\n");
        }
        for (final CrashReportCategory lllllllllllllllIllIIIllIlIlIIlII : this.crashReportSections) {
            lllllllllllllllIllIIIllIlIlIIlII.appendToStringBuilder(lllllllllllllllIllIIIllIlIlIIIlI);
            lllllllllllllllIllIIIllIlIlIIIlI.append("\n\n");
        }
        this.theReportCategory.appendToStringBuilder(lllllllllllllllIllIIIllIlIlIIIlI);
    }
    
    public String getCompleteReport() {
        if (!this.reported) {
            this.reported = true;
            CrashReporter.onCrashReport(this, this.theReportCategory);
        }
        final StringBuilder lllllllllllllllIllIIIllIlIIIlIII = new StringBuilder();
        lllllllllllllllIllIIIllIlIIIlIII.append("---- Minecraft Crash Report ----\n");
        Reflector.call(Reflector.BlamingTransformer_onCrash, lllllllllllllllIllIIIllIlIIIlIII);
        Reflector.call(Reflector.CoreModManager_onCrash, lllllllllllllllIllIIIllIlIIIlIII);
        lllllllllllllllIllIIIllIlIIIlIII.append("// ");
        lllllllllllllllIllIIIllIlIIIlIII.append(getWittyComment());
        lllllllllllllllIllIIIllIlIIIlIII.append("\n\n");
        lllllllllllllllIllIIIllIlIIIlIII.append("Time: ");
        lllllllllllllllIllIIIllIlIIIlIII.append(new SimpleDateFormat().format(new Date()));
        lllllllllllllllIllIIIllIlIIIlIII.append("\n");
        lllllllllllllllIllIIIllIlIIIlIII.append("Description: ");
        lllllllllllllllIllIIIllIlIIIlIII.append(this.description);
        lllllllllllllllIllIIIllIlIIIlIII.append("\n\n");
        lllllllllllllllIllIIIllIlIIIlIII.append(this.getCauseStackTraceOrString());
        lllllllllllllllIllIIIllIlIIIlIII.append("\n\nA detailed walkthrough of the error, its code path and all known details is as follows:\n");
        for (int lllllllllllllllIllIIIllIlIIIIlll = 0; lllllllllllllllIllIIIllIlIIIIlll < 87; ++lllllllllllllllIllIIIllIlIIIIlll) {
            lllllllllllllllIllIIIllIlIIIlIII.append("-");
        }
        lllllllllllllllIllIIIllIlIIIlIII.append("\n\n");
        this.getSectionsInStringBuilder(lllllllllllllllIllIIIllIlIIIlIII);
        return String.valueOf(lllllllllllllllIllIIIllIlIIIlIII);
    }
    
    public static CrashReport makeCrashReport(final Throwable lllllllllllllllIllIIIllIIIllIlII, final String lllllllllllllllIllIIIllIIIllIIll) {
        CrashReport lllllllllllllllIllIIIllIIIllIlIl = null;
        if (lllllllllllllllIllIIIllIIIllIlII instanceof ReportedException) {
            final CrashReport lllllllllllllllIllIIIllIIIllIllI = ((ReportedException)lllllllllllllllIllIIIllIIIllIlII).getCrashReport();
        }
        else {
            lllllllllllllllIllIIIllIIIllIlIl = new CrashReport(lllllllllllllllIllIIIllIIIllIIll, lllllllllllllllIllIIIllIIIllIlII);
        }
        return lllllllllllllllIllIIIllIIIllIlIl;
    }
    
    public boolean saveToFile(final File lllllllllllllllIllIIIllIIllIllll) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/crash/CrashReport.crashReportFile:Ljava/io/File;
        //     4: ifnull          9
        //     7: iconst_0       
        //     8: ireturn        
        //     9: aload_1         /* lllllllllllllllIllIIIllIIlllIlll */
        //    10: invokevirtual   java/io/File.getParentFile:()Ljava/io/File;
        //    13: ifnull          24
        //    16: aload_1         /* lllllllllllllllIllIIIllIIlllIlll */
        //    17: invokevirtual   java/io/File.getParentFile:()Ljava/io/File;
        //    20: invokevirtual   java/io/File.mkdirs:()Z
        //    23: pop            
        //    24: aconst_null    
        //    25: astore_2        /* lllllllllllllllIllIIIllIIlllIllI */
        //    26: new             Ljava/io/OutputStreamWriter;
        //    29: dup            
        //    30: new             Ljava/io/FileOutputStream;
        //    33: dup            
        //    34: aload_1         /* lllllllllllllllIllIIIllIIlllIlll */
        //    35: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //    38: getstatic       java/nio/charset/StandardCharsets.UTF_8:Ljava/nio/charset/Charset;
        //    41: invokespecial   java/io/OutputStreamWriter.<init>:(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
        //    44: astore_2        /* lllllllllllllllIllIIIllIIlllIllI */
        //    45: aload_2         /* lllllllllllllllIllIIIllIIlllIllI */
        //    46: aload_0         /* lllllllllllllllIllIIIllIIllllIII */
        //    47: invokevirtual   net/minecraft/crash/CrashReport.getCompleteReport:()Ljava/lang/String;
        //    50: invokevirtual   java/io/Writer.write:(Ljava/lang/String;)V
        //    53: aload_0         /* lllllllllllllllIllIIIllIIllllIII */
        //    54: aload_1         /* lllllllllllllllIllIIIllIIlllIlll */
        //    55: putfield        net/minecraft/crash/CrashReport.crashReportFile:Ljava/io/File;
        //    58: iconst_1       
        //    59: istore          lllllllllllllllIllIIIllIIlllIIll
        //    61: iload           lllllllllllllllIllIIIllIIlllIIll
        //    63: istore          lllllllllllllllIllIIIllIIlllIIlI
        //    65: iload           lllllllllllllllIllIIIllIIlllIIlI
        //    67: istore          lllllllllllllllIllIIIllIIllIlIIl
        //    69: aload_2         /* lllllllllllllllIllIIIllIIlllIllI */
        //    70: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Writer;)V
        //    73: iload           lllllllllllllllIllIIIllIIllIlIIl
        //    75: ireturn        
        //    76: astore          lllllllllllllllIllIIIllIIlllIIIl
        //    78: getstatic       net/minecraft/crash/CrashReport.LOGGER:Lorg/apache/logging/log4j/Logger;
        //    81: ldc_w           "Could not save crash report to {}"
        //    84: aload_1         /* lllllllllllllllIllIIIllIIlllIlll */
        //    85: aload           lllllllllllllllIllIIIllIIlllIIIl
        //    87: invokeinterface org/apache/logging/log4j/Logger.error:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //    92: iconst_0       
        //    93: istore_3        /* lllllllllllllllIllIIIllIIlllIlIl */
        //    94: aload_2         /* lllllllllllllllIllIIIllIIlllIllI */
        //    95: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Writer;)V
        //    98: goto            110
        //   101: astore          lllllllllllllllIllIIIllIIllIlIlI
        //   103: aload_2         /* lllllllllllllllIllIIIllIIlllIllI */
        //   104: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Writer;)V
        //   107: aload           lllllllllllllllIllIIIllIIllIlIlI
        //   109: athrow         
        //   110: iload_3         /* lllllllllllllllIllIIIllIIlllIlII */
        //   111: ireturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  26     69     76     101    Ljava/lang/Throwable;
        //  26     69     101    110    Any
        //  76     94     101    110    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public File getFile() {
        return this.crashReportFile;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    private static String getWittyComment() {
        final String[] lllllllllllllllIllIIIllIIIllllll = { "Who set us up the TNT?", "Everything's going to plan. No, really, that was supposed to happen.", "Uh... Did I do that?", "Oops.", "Why did you do that?", "I feel sad now :(", "My bad.", "I'm sorry, Dave.", "I let you down. Sorry :(", "On the bright side, I bought you a teddy bear!", "Daisy, daisy...", "Oh - I know what I did wrong!", "Hey, that tickles! Hehehe!", "I blame Dinnerbone.", "You should try our sister game, Minceraft!", "Don't be sad. I'll do better next time, I promise!", "Don't be sad, have a hug! <3", "I just don't know what went wrong :(", "Shall we play a game?", "Quite honestly, I wouldn't worry myself about that.", "I bet Cylons wouldn't have this problem.", "Sorry :(", "Surprise! Haha. Well, this is awkward.", "Would you like a cupcake?", "Hi. I'm Minecraft, and I'm a crashaholic.", "Ooh. Shiny.", "This doesn't make any sense!", "Why is it breaking :(", "Don't do that.", "Ouch. That hurt :(", "You're mean.", "This is a token for 1 free hug. Redeem at your nearest Mojangsta: [~~HUG~~]", "There are four lights!", "But it works on my machine." };
        try {
            return lllllllllllllllIllIIIllIIIllllll[(int)(System.nanoTime() % lllllllllllllllIllIIIllIIIllllll.length)];
        }
        catch (Throwable lllllllllllllllIllIIIllIIIlllllI) {
            return "Witty comment unavailable :(";
        }
    }
    
    public CrashReportCategory makeCategory(final String lllllllllllllllIllIIIllIIllIIIII) {
        return this.makeCategoryDepth(lllllllllllllllIllIIIllIIllIIIII, 1);
    }
    
    public Throwable getCrashCause() {
        return this.cause;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public String getCauseStackTraceOrString() {
        StringWriter lllllllllllllllIllIIIllIlIIlIllI = null;
        PrintWriter lllllllllllllllIllIIIllIlIIlIlIl = null;
        Throwable lllllllllllllllIllIIIllIlIIlIlII = this.cause;
        if (lllllllllllllllIllIIIllIlIIlIlII.getMessage() == null) {
            if (lllllllllllllllIllIIIllIlIIlIlII instanceof NullPointerException) {
                lllllllllllllllIllIIIllIlIIlIlII = new NullPointerException(this.description);
            }
            else if (lllllllllllllllIllIIIllIlIIlIlII instanceof StackOverflowError) {
                lllllllllllllllIllIIIllIlIIlIlII = new StackOverflowError(this.description);
            }
            else if (lllllllllllllllIllIIIllIlIIlIlII instanceof OutOfMemoryError) {
                lllllllllllllllIllIIIllIlIIlIlII = new OutOfMemoryError(this.description);
            }
            lllllllllllllllIllIIIllIlIIlIlII.setStackTrace(this.cause.getStackTrace());
        }
        String lllllllllllllllIllIIIllIlIIlIIll = lllllllllllllllIllIIIllIlIIlIlII.toString();
        try {
            lllllllllllllllIllIIIllIlIIlIllI = new StringWriter();
            lllllllllllllllIllIIIllIlIIlIlIl = new PrintWriter(lllllllllllllllIllIIIllIlIIlIllI);
            lllllllllllllllIllIIIllIlIIlIlII.printStackTrace(lllllllllllllllIllIIIllIlIIlIlIl);
            lllllllllllllllIllIIIllIlIIlIIll = lllllllllllllllIllIIIllIlIIlIllI.toString();
        }
        finally {
            IOUtils.closeQuietly((Writer)lllllllllllllllIllIIIllIlIIlIllI);
            IOUtils.closeQuietly((Writer)lllllllllllllllIllIIIllIlIIlIlIl);
        }
        IOUtils.closeQuietly((Writer)lllllllllllllllIllIIIllIlIIlIllI);
        IOUtils.closeQuietly((Writer)lllllllllllllllIllIIIllIlIIlIlIl);
        return lllllllllllllllIllIIIllIlIIlIIll;
    }
    
    public CrashReportCategory getCategory() {
        return this.theReportCategory;
    }
}
