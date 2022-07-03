package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.entity.player.*;

public class CommandXP extends CommandBase
{
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIlIIlIlIlIIlIlIlllI, final ICommandSender lllllllllllllIlIIlIlIlIIlIlIllIl, final String[] lllllllllllllIlIIlIlIlIIlIlIlIIl, @Nullable final BlockPos lllllllllllllIlIIlIlIlIIlIlIlIll) {
        return (lllllllllllllIlIIlIlIlIIlIlIlIIl.length == 2) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIlIIlIlIlIIlIlIlIIl, lllllllllllllIlIIlIlIlIIlIlIlllI.getAllUsernames()) : Collections.emptyList();
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllllIlIIlIlIlIIlIlIIllI, final int lllllllllllllIlIIlIlIlIIlIlIIlII) {
        return lllllllllllllIlIIlIlIlIIlIlIIlII == 1;
    }
    
    @Override
    public String getCommandName() {
        return "xp";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIlIIlIlIlIIlIlllIIl, final ICommandSender lllllllllllllIlIIlIlIlIIlIlllIII, final String[] lllllllllllllIlIIlIlIlIIlIllIlll) throws CommandException {
        if (lllllllllllllIlIIlIlIlIIlIllIlll.length <= 0) {
            throw new WrongUsageException("commands.xp.usage", new Object[0]);
        }
        String lllllllllllllIlIIlIlIlIIlIllllll = lllllllllllllIlIIlIlIlIIlIllIlll[0];
        final boolean lllllllllllllIlIIlIlIlIIlIlllllI = lllllllllllllIlIIlIlIlIIlIllllll.endsWith("l") || lllllllllllllIlIIlIlIlIIlIllllll.endsWith("L");
        if (lllllllllllllIlIIlIlIlIIlIlllllI && lllllllllllllIlIIlIlIlIIlIllllll.length() > 1) {
            lllllllllllllIlIIlIlIlIIlIllllll = lllllllllllllIlIIlIlIlIIlIllllll.substring(0, lllllllllllllIlIIlIlIlIIlIllllll.length() - 1);
        }
        int lllllllllllllIlIIlIlIlIIlIllllIl = CommandBase.parseInt(lllllllllllllIlIIlIlIlIIlIllllll);
        final boolean lllllllllllllIlIIlIlIlIIlIllllII = lllllllllllllIlIIlIlIlIIlIllllIl < 0;
        if (lllllllllllllIlIIlIlIlIIlIllllII) {
            lllllllllllllIlIIlIlIlIIlIllllIl *= -1;
        }
        final EntityPlayer lllllllllllllIlIIlIlIlIIlIlllIll = (lllllllllllllIlIIlIlIlIIlIllIlll.length > 1) ? CommandBase.getPlayer(lllllllllllllIlIIlIlIlIIlIlllIIl, lllllllllllllIlIIlIlIlIIlIlllIII, lllllllllllllIlIIlIlIlIIlIllIlll[1]) : CommandBase.getCommandSenderAsPlayer(lllllllllllllIlIIlIlIlIIlIlllIII);
        if (lllllllllllllIlIIlIlIlIIlIlllllI) {
            lllllllllllllIlIIlIlIlIIlIlllIII.setCommandStat(CommandResultStats.Type.QUERY_RESULT, lllllllllllllIlIIlIlIlIIlIlllIll.experienceLevel);
            if (lllllllllllllIlIIlIlIlIIlIllllII) {
                lllllllllllllIlIIlIlIlIIlIlllIll.addExperienceLevel(-lllllllllllllIlIIlIlIlIIlIllllIl);
                CommandBase.notifyCommandListener(lllllllllllllIlIIlIlIlIIlIlllIII, this, "commands.xp.success.negative.levels", lllllllllllllIlIIlIlIlIIlIllllIl, lllllllllllllIlIIlIlIlIIlIlllIll.getName());
            }
            else {
                lllllllllllllIlIIlIlIlIIlIlllIll.addExperienceLevel(lllllllllllllIlIIlIlIlIIlIllllIl);
                CommandBase.notifyCommandListener(lllllllllllllIlIIlIlIlIIlIlllIII, this, "commands.xp.success.levels", lllllllllllllIlIIlIlIlIIlIllllIl, lllllllllllllIlIIlIlIlIIlIlllIll.getName());
            }
        }
        else {
            lllllllllllllIlIIlIlIlIIlIlllIII.setCommandStat(CommandResultStats.Type.QUERY_RESULT, lllllllllllllIlIIlIlIlIIlIlllIll.experienceTotal);
            if (lllllllllllllIlIIlIlIlIIlIllllII) {
                throw new CommandException("commands.xp.failure.widthdrawXp", new Object[0]);
            }
            lllllllllllllIlIIlIlIlIIlIlllIll.addExperience(lllllllllllllIlIIlIlIlIIlIllllIl);
            CommandBase.notifyCommandListener(lllllllllllllIlIIlIlIlIIlIlllIII, this, "commands.xp.success", lllllllllllllIlIIlIlIlIIlIllllIl, lllllllllllllIlIIlIlIlIIlIlllIll.getName());
        }
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIlIIlIlIlIIllIIllIl) {
        return "commands.xp.usage";
    }
}
