package net.minecraft.command;

import net.minecraft.server.*;
import java.text.*;
import java.nio.charset.*;
import org.apache.commons.io.*;
import java.io.*;
import net.minecraft.profiler.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;
import org.apache.logging.log4j.*;

public class CommandDebug extends CommandBase
{
    private /* synthetic */ long profileStartTime;
    private /* synthetic */ int profileStartTick;
    private static final /* synthetic */ Logger LOGGER;
    
    private void saveProfilerResults(final long lllllllllllllIIIllIlIIllIlIIlIll, final int lllllllllllllIIIllIlIIllIlIIIIll, final MinecraftServer lllllllllllllIIIllIlIIllIlIIIIlI) {
        final File lllllllllllllIIIllIlIIllIlIIlIII = new File(lllllllllllllIIIllIlIIllIlIIIIlI.getFile("debug"), String.valueOf(new StringBuilder("profile-results-").append(new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date())).append(".txt")));
        lllllllllllllIIIllIlIIllIlIIlIII.getParentFile().mkdirs();
        Writer lllllllllllllIIIllIlIIllIlIIIlll = null;
        try {
            lllllllllllllIIIllIlIIllIlIIIlll = new OutputStreamWriter(new FileOutputStream(lllllllllllllIIIllIlIIllIlIIlIII), StandardCharsets.UTF_8);
            lllllllllllllIIIllIlIIllIlIIIlll.write(this.getProfilerResults(lllllllllllllIIIllIlIIllIlIIlIll, lllllllllllllIIIllIlIIllIlIIIIll, lllllllllllllIIIllIlIIllIlIIIIlI));
        }
        catch (Throwable lllllllllllllIIIllIlIIllIlIIIllI) {
            CommandDebug.LOGGER.error("Could not save profiler results to {}", (Object)lllllllllllllIIIllIlIIllIlIIlIII, (Object)lllllllllllllIIIllIlIIllIlIIIllI);
            return;
        }
        finally {
            IOUtils.closeQuietly(lllllllllllllIIIllIlIIllIlIIIlll);
        }
        IOUtils.closeQuietly(lllllllllllllIIIllIlIIllIlIIIlll);
    }
    
    private void appendProfilerResults(final int lllllllllllllIIIllIlIIllIIlIIlII, final String lllllllllllllIIIllIlIIllIIIllIIl, final StringBuilder lllllllllllllIIIllIlIIllIIlIIIlI, final MinecraftServer lllllllllllllIIIllIlIIllIIIlIlll) {
        final List<Profiler.Result> lllllllllllllIIIllIlIIllIIlIIIII = lllllllllllllIIIllIlIIllIIIlIlll.theProfiler.getProfilingData(lllllllllllllIIIllIlIIllIIIllIIl);
        if (lllllllllllllIIIllIlIIllIIlIIIII != null && lllllllllllllIIIllIlIIllIIlIIIII.size() >= 3) {
            for (int lllllllllllllIIIllIlIIllIIIlllll = 1; lllllllllllllIIIllIlIIllIIIlllll < lllllllllllllIIIllIlIIllIIlIIIII.size(); ++lllllllllllllIIIllIlIIllIIIlllll) {
                final Profiler.Result lllllllllllllIIIllIlIIllIIIllllI = lllllllllllllIIIllIlIIllIIlIIIII.get(lllllllllllllIIIllIlIIllIIIlllll);
                lllllllllllllIIIllIlIIllIIlIIIlI.append(String.format("[%02d] ", lllllllllllllIIIllIlIIllIIlIIlII));
                for (int lllllllllllllIIIllIlIIllIIIlllIl = 0; lllllllllllllIIIllIlIIllIIIlllIl < lllllllllllllIIIllIlIIllIIlIIlII; ++lllllllllllllIIIllIlIIllIIIlllIl) {
                    lllllllllllllIIIllIlIIllIIlIIIlI.append("|   ");
                }
                lllllllllllllIIIllIlIIllIIlIIIlI.append(lllllllllllllIIIllIlIIllIIIllllI.profilerName).append(" - ").append(String.format("%.2f", lllllllllllllIIIllIlIIllIIIllllI.usePercentage)).append("%/").append(String.format("%.2f", lllllllllllllIIIllIlIIllIIIllllI.totalUsePercentage)).append("%\n");
                if (!"unspecified".equals(lllllllllllllIIIllIlIIllIIIllllI.profilerName)) {
                    try {
                        this.appendProfilerResults(lllllllllllllIIIllIlIIllIIlIIlII + 1, String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIllIlIIllIIIllIIl)).append(".").append(lllllllllllllIIIllIlIIllIIIllllI.profilerName)), lllllllllllllIIIllIlIIllIIlIIIlI, lllllllllllllIIIllIlIIllIIIlIlll);
                    }
                    catch (Exception lllllllllllllIIIllIlIIllIIIlllII) {
                        lllllllllllllIIIllIlIIllIIlIIIlI.append("[[ EXCEPTION ").append(lllllllllllllIIIllIlIIllIIIlllII).append(" ]]");
                    }
                }
            }
        }
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIIIllIlIIllIlIllIll, final ICommandSender lllllllllllllIIIllIlIIllIlIllIlI, final String[] lllllllllllllIIIllIlIIllIllIIIIl) throws CommandException {
        if (lllllllllllllIIIllIlIIllIllIIIIl.length < 1) {
            throw new WrongUsageException("commands.debug.usage", new Object[0]);
        }
        if ("start".equals(lllllllllllllIIIllIlIIllIllIIIIl[0])) {
            if (lllllllllllllIIIllIlIIllIllIIIIl.length != 1) {
                throw new WrongUsageException("commands.debug.usage", new Object[0]);
            }
            CommandBase.notifyCommandListener(lllllllllllllIIIllIlIIllIlIllIlI, this, "commands.debug.start", new Object[0]);
            lllllllllllllIIIllIlIIllIlIllIll.enableProfiling();
            this.profileStartTime = MinecraftServer.getCurrentTimeMillis();
            this.profileStartTick = lllllllllllllIIIllIlIIllIlIllIll.getTickCounter();
        }
        else {
            if (!"stop".equals(lllllllllllllIIIllIlIIllIllIIIIl[0])) {
                throw new WrongUsageException("commands.debug.usage", new Object[0]);
            }
            if (lllllllllllllIIIllIlIIllIllIIIIl.length != 1) {
                throw new WrongUsageException("commands.debug.usage", new Object[0]);
            }
            if (!lllllllllllllIIIllIlIIllIlIllIll.theProfiler.profilingEnabled) {
                throw new CommandException("commands.debug.notStarted", new Object[0]);
            }
            final long lllllllllllllIIIllIlIIllIllIIIII = MinecraftServer.getCurrentTimeMillis();
            final int lllllllllllllIIIllIlIIllIlIlllll = lllllllllllllIIIllIlIIllIlIllIll.getTickCounter();
            final long lllllllllllllIIIllIlIIllIlIllllI = lllllllllllllIIIllIlIIllIllIIIII - this.profileStartTime;
            final int lllllllllllllIIIllIlIIllIlIlllIl = lllllllllllllIIIllIlIIllIlIlllll - this.profileStartTick;
            this.saveProfilerResults(lllllllllllllIIIllIlIIllIlIllllI, lllllllllllllIIIllIlIIllIlIlllIl, lllllllllllllIIIllIlIIllIlIllIll);
            lllllllllllllIIIllIlIIllIlIllIll.theProfiler.profilingEnabled = false;
            CommandBase.notifyCommandListener(lllllllllllllIIIllIlIIllIlIllIlI, this, "commands.debug.stop", String.format("%.2f", lllllllllllllIIIllIlIIllIlIllllI / 1000.0f), lllllllllllllIIIllIlIIllIlIlllIl);
        }
    }
    
    private static String getWittyComment() {
        final String[] lllllllllllllIIIllIlIIllIIIlIIII = { "Shiny numbers!", "Am I not running fast enough? :(", "I'm working as hard as I can!", "Will I ever be good enough for you? :(", "Speedy. Zoooooom!", "Hello world", "40% better than a crash report.", "Now with extra numbers", "Now with less numbers", "Now with the same numbers", "You should add flames to things, it makes them go faster!", "Do you feel the need for... optimization?", "*cracks redstone whip*", "Maybe if you treated it better then it'll have more motivation to work faster! Poor server." };
        try {
            return lllllllllllllIIIllIlIIllIIIlIIII[(int)(System.nanoTime() % lllllllllllllIIIllIlIIllIIIlIIII.length)];
        }
        catch (Throwable lllllllllllllIIIllIlIIllIIIIllll) {
            return "Witty comment unavailable :(";
        }
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIIIllIlIIllIllIllIl) {
        return "commands.debug.usage";
    }
    
    private String getProfilerResults(final long lllllllllllllIIIllIlIIllIIllIIlI, final int lllllllllllllIIIllIlIIllIIllIIIl, final MinecraftServer lllllllllllllIIIllIlIIllIIllIIII) {
        final StringBuilder lllllllllllllIIIllIlIIllIIllIlII = new StringBuilder();
        lllllllllllllIIIllIlIIllIIllIlII.append("---- Minecraft Profiler Results ----\n");
        lllllllllllllIIIllIlIIllIIllIlII.append("// ");
        lllllllllllllIIIllIlIIllIIllIlII.append(getWittyComment());
        lllllllllllllIIIllIlIIllIIllIlII.append("\n\n");
        lllllllllllllIIIllIlIIllIIllIlII.append("Time span: ").append(lllllllllllllIIIllIlIIllIIllIIlI).append(" ms\n");
        lllllllllllllIIIllIlIIllIIllIlII.append("Tick span: ").append(lllllllllllllIIIllIlIIllIIllIIIl).append(" ticks\n");
        lllllllllllllIIIllIlIIllIIllIlII.append("// This is approximately ").append(String.format("%.2f", lllllllllllllIIIllIlIIllIIllIIIl / (lllllllllllllIIIllIlIIllIIllIIlI / 1000.0f))).append(" ticks per second. It should be ").append(20).append(" ticks per second\n\n");
        lllllllllllllIIIllIlIIllIIllIlII.append("--- BEGIN PROFILE DUMP ---\n\n");
        this.appendProfilerResults(0, "root", lllllllllllllIIIllIlIIllIIllIlII, lllllllllllllIIIllIlIIllIIllIIII);
        lllllllllllllIIIllIlIIllIIllIlII.append("--- END PROFILE DUMP ---\n\n");
        return String.valueOf(lllllllllllllIIIllIlIIllIIllIlII);
    }
    
    @Override
    public String getCommandName() {
        return "debug";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIIIllIlIIllIIIIlIlI, final ICommandSender lllllllllllllIIIllIlIIllIIIIlIIl, final String[] lllllllllllllIIIllIlIIllIIIIlIII, @Nullable final BlockPos lllllllllllllIIIllIlIIllIIIIIlll) {
        return (lllllllllllllIIIllIlIIllIIIIlIII.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIIllIlIIllIIIIlIII, "start", "stop") : Collections.emptyList();
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
}
