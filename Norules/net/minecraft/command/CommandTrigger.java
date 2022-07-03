package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.scoreboard.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import com.google.common.collect.*;
import java.util.*;

public class CommandTrigger extends CommandBase
{
    @Override
    public void execute(final MinecraftServer lllllllllllllIlIIIIllIllllIlllII, final ICommandSender lllllllllllllIlIIIIllIllllIllIll, final String[] lllllllllllllIlIIIIllIllllIllIlI) throws CommandException {
        if (lllllllllllllIlIIIIllIllllIllIlI.length < 3) {
            throw new WrongUsageException("commands.trigger.usage", new Object[0]);
        }
        EntityPlayerMP lllllllllllllIlIIIIllIllllIllIII = null;
        if (lllllllllllllIlIIIIllIllllIllIll instanceof EntityPlayerMP) {
            final EntityPlayerMP lllllllllllllIlIIIIllIllllIllIIl = (EntityPlayerMP)lllllllllllllIlIIIIllIllllIllIll;
        }
        else {
            final Entity lllllllllllllIlIIIIllIllllIlIlll = lllllllllllllIlIIIIllIllllIllIll.getCommandSenderEntity();
            if (!(lllllllllllllIlIIIIllIllllIlIlll instanceof EntityPlayerMP)) {
                throw new CommandException("commands.trigger.invalidPlayer", new Object[0]);
            }
            lllllllllllllIlIIIIllIllllIllIII = (EntityPlayerMP)lllllllllllllIlIIIIllIllllIlIlll;
        }
        final Scoreboard lllllllllllllIlIIIIllIllllIlIllI = lllllllllllllIlIIIIllIllllIlllII.worldServerForDimension(0).getScoreboard();
        final ScoreObjective lllllllllllllIlIIIIllIllllIlIlIl = lllllllllllllIlIIIIllIllllIlIllI.getObjective(lllllllllllllIlIIIIllIllllIllIlI[0]);
        if (lllllllllllllIlIIIIllIllllIlIlIl == null || lllllllllllllIlIIIIllIllllIlIlIl.getCriteria() != IScoreCriteria.TRIGGER) {
            throw new CommandException("commands.trigger.invalidObjective", new Object[] { lllllllllllllIlIIIIllIllllIllIlI[0] });
        }
        final int lllllllllllllIlIIIIllIllllIlIlII = CommandBase.parseInt(lllllllllllllIlIIIIllIllllIllIlI[2]);
        if (!lllllllllllllIlIIIIllIllllIlIllI.entityHasObjective(lllllllllllllIlIIIIllIllllIllIII.getName(), lllllllllllllIlIIIIllIllllIlIlIl)) {
            throw new CommandException("commands.trigger.invalidObjective", new Object[] { lllllllllllllIlIIIIllIllllIllIlI[0] });
        }
        final Score lllllllllllllIlIIIIllIllllIlIIll = lllllllllllllIlIIIIllIllllIlIllI.getOrCreateScore(lllllllllllllIlIIIIllIllllIllIII.getName(), lllllllllllllIlIIIIllIllllIlIlIl);
        if (lllllllllllllIlIIIIllIllllIlIIll.isLocked()) {
            throw new CommandException("commands.trigger.disabled", new Object[] { lllllllllllllIlIIIIllIllllIllIlI[0] });
        }
        if ("set".equals(lllllllllllllIlIIIIllIllllIllIlI[1])) {
            lllllllllllllIlIIIIllIllllIlIIll.setScorePoints(lllllllllllllIlIIIIllIllllIlIlII);
        }
        else {
            if (!"add".equals(lllllllllllllIlIIIIllIllllIllIlI[1])) {
                throw new CommandException("commands.trigger.invalidMode", new Object[] { lllllllllllllIlIIIIllIllllIllIlI[1] });
            }
            lllllllllllllIlIIIIllIllllIlIIll.increaseScore(lllllllllllllIlIIIIllIllllIlIlII);
        }
        lllllllllllllIlIIIIllIllllIlIIll.setLocked(true);
        if (lllllllllllllIlIIIIllIllllIllIII.interactionManager.isCreative()) {
            CommandBase.notifyCommandListener(lllllllllllllIlIIIIllIllllIllIll, this, "commands.trigger.success", lllllllllllllIlIIIIllIllllIllIlI[0], lllllllllllllIlIIIIllIllllIllIlI[1], lllllllllllllIlIIIIllIllllIllIlI[2]);
        }
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIlIIIIllIlllllIIlll) {
        return "commands.trigger.usage";
    }
    
    @Override
    public String getCommandName() {
        return "trigger";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIlIIIIllIllllIIIIlI, final ICommandSender lllllllllllllIlIIIIllIllllIIIIIl, final String[] lllllllllllllIlIIIIllIlllIlllIlI, @Nullable final BlockPos lllllllllllllIlIIIIllIlllIllllll) {
        if (lllllllllllllIlIIIIllIlllIlllIlI.length == 1) {
            final Scoreboard lllllllllllllIlIIIIllIlllIlllllI = lllllllllllllIlIIIIllIllllIIIIlI.worldServerForDimension(0).getScoreboard();
            final List<String> lllllllllllllIlIIIIllIlllIllllIl = (List<String>)Lists.newArrayList();
            for (final ScoreObjective lllllllllllllIlIIIIllIlllIllllII : lllllllllllllIlIIIIllIlllIlllllI.getScoreObjectives()) {
                if (lllllllllllllIlIIIIllIlllIllllII.getCriteria() == IScoreCriteria.TRIGGER) {
                    lllllllllllllIlIIIIllIlllIllllIl.add(lllllllllllllIlIIIIllIlllIllllII.getName());
                }
            }
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIlIIIIllIlllIlllIlI, (String[])lllllllllllllIlIIIIllIlllIllllIl.toArray(new String[lllllllllllllIlIIIIllIlllIllllIl.size()]));
        }
        return (lllllllllllllIlIIIIllIlllIlllIlI.length == 2) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIlIIIIllIlllIlllIlI, "add", "set") : Collections.emptyList();
    }
}
