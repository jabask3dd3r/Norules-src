package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;

public class CommandTime extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllIIlllllllIlIIlllI) {
        return "commands.time.usage";
    }
    
    protected void incrementAllWorldTimes(final MinecraftServer lllllllllllllllIIllllllIllllIIll, final int lllllllllllllllIIllllllIllllIIIl) {
        for (int lllllllllllllllIIllllllIllllIlll = 0; lllllllllllllllIIllllllIllllIlll < lllllllllllllllIIllllllIllllIIll.worldServers.length; ++lllllllllllllllIIllllllIllllIlll) {
            final WorldServer lllllllllllllllIIllllllIllllIlIl = lllllllllllllllIIllllllIllllIIll.worldServers[lllllllllllllllIIllllllIllllIlll];
            lllllllllllllllIIllllllIllllIlIl.setWorldTime(lllllllllllllllIIllllllIllllIlIl.getWorldTime() + lllllllllllllllIIllllllIllllIIIl);
        }
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllllIIlllllllIIlllllI, final ICommandSender lllllllllllllllIIlllllllIIllllII, final String[] lllllllllllllllIIlllllllIIlIlIlI) throws CommandException {
        if (lllllllllllllllIIlllllllIIlIlIlI.length > 1) {
            if ("set".equals(lllllllllllllllIIlllllllIIlIlIlI[0])) {
                int lllllllllllllllIIlllllllIIllIlll = 0;
                if ("day".equals(lllllllllllllllIIlllllllIIlIlIlI[1])) {
                    final int lllllllllllllllIIlllllllIIlllIIl = 1000;
                }
                else if ("night".equals(lllllllllllllllIIlllllllIIlIlIlI[1])) {
                    final int lllllllllllllllIIlllllllIIlllIII = 13000;
                }
                else {
                    lllllllllllllllIIlllllllIIllIlll = CommandBase.parseInt(lllllllllllllllIIlllllllIIlIlIlI[1], 0);
                }
                this.setAllWorldTimes(lllllllllllllllIIlllllllIIlllllI, lllllllllllllllIIlllllllIIllIlll);
                CommandBase.notifyCommandListener(lllllllllllllllIIlllllllIIllllII, this, "commands.time.set", lllllllllllllllIIlllllllIIllIlll);
                return;
            }
            if ("add".equals(lllllllllllllllIIlllllllIIlIlIlI[0])) {
                final int lllllllllllllllIIlllllllIIllIllI = CommandBase.parseInt(lllllllllllllllIIlllllllIIlIlIlI[1], 0);
                this.incrementAllWorldTimes(lllllllllllllllIIlllllllIIlllllI, lllllllllllllllIIlllllllIIllIllI);
                CommandBase.notifyCommandListener(lllllllllllllllIIlllllllIIllllII, this, "commands.time.added", lllllllllllllllIIlllllllIIllIllI);
                return;
            }
            if ("query".equals(lllllllllllllllIIlllllllIIlIlIlI[0])) {
                if ("daytime".equals(lllllllllllllllIIlllllllIIlIlIlI[1])) {
                    final int lllllllllllllllIIlllllllIIllIlII = (int)(lllllllllllllllIIlllllllIIllllII.getEntityWorld().getWorldTime() % 24000L);
                    lllllllllllllllIIlllllllIIllllII.setCommandStat(CommandResultStats.Type.QUERY_RESULT, lllllllllllllllIIlllllllIIllIlII);
                    CommandBase.notifyCommandListener(lllllllllllllllIIlllllllIIllllII, this, "commands.time.query", lllllllllllllllIIlllllllIIllIlII);
                    return;
                }
                if ("day".equals(lllllllllllllllIIlllllllIIlIlIlI[1])) {
                    final int lllllllllllllllIIlllllllIIllIIlI = (int)(lllllllllllllllIIlllllllIIllllII.getEntityWorld().getWorldTime() / 24000L % 2147483647L);
                    lllllllllllllllIIlllllllIIllllII.setCommandStat(CommandResultStats.Type.QUERY_RESULT, lllllllllllllllIIlllllllIIllIIlI);
                    CommandBase.notifyCommandListener(lllllllllllllllIIlllllllIIllllII, this, "commands.time.query", lllllllllllllllIIlllllllIIllIIlI);
                    return;
                }
                if ("gametime".equals(lllllllllllllllIIlllllllIIlIlIlI[1])) {
                    final int lllllllllllllllIIlllllllIIllIIIl = (int)(lllllllllllllllIIlllllllIIllllII.getEntityWorld().getTotalWorldTime() % 2147483647L);
                    lllllllllllllllIIlllllllIIllllII.setCommandStat(CommandResultStats.Type.QUERY_RESULT, lllllllllllllllIIlllllllIIllIIIl);
                    CommandBase.notifyCommandListener(lllllllllllllllIIlllllllIIllllII, this, "commands.time.query", lllllllllllllllIIlllllllIIllIIIl);
                    return;
                }
            }
        }
        throw new WrongUsageException("commands.time.usage", new Object[0]);
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllllIIlllllllIIlIIIII, final ICommandSender lllllllllllllllIIlllllllIIIllllI, final String[] lllllllllllllllIIlllllllIIIllIII, @Nullable final BlockPos lllllllllllllllIIlllllllIIIllIlI) {
        if (lllllllllllllllIIlllllllIIIllIII.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIIlllllllIIIllIII, "set", "add", "query");
        }
        if (lllllllllllllllIIlllllllIIIllIII.length == 2 && "set".equals(lllllllllllllllIIlllllllIIIllIII[0])) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIIlllllllIIIllIII, "day", "night");
        }
        return (lllllllllllllllIIlllllllIIIllIII.length == 2 && "query".equals(lllllllllllllllIIlllllllIIIllIII[0])) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIIlllllllIIIllIII, "daytime", "gametime", "day") : Collections.emptyList();
    }
    
    protected void setAllWorldTimes(final MinecraftServer lllllllllllllllIIlllllllIIIIllII, final int lllllllllllllllIIlllllllIIIIlllI) {
        for (int lllllllllllllllIIlllllllIIIIllIl = 0; lllllllllllllllIIlllllllIIIIllIl < lllllllllllllllIIlllllllIIIIllII.worldServers.length; ++lllllllllllllllIIlllllllIIIIllIl) {
            lllllllllllllllIIlllllllIIIIllII.worldServers[lllllllllllllllIIlllllllIIIIllIl].setWorldTime(lllllllllllllllIIlllllllIIIIlllI);
        }
    }
    
    @Override
    public String getCommandName() {
        return "time";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
}
