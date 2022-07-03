package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.scoreboard.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.*;

public class CommandStats extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllIllIlIIIIllIIllll) {
        return "commands.stats.usage";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllllIllIlIIIIlIIIlIII, final ICommandSender lllllllllllllllIllIlIIIIlIIIllII, final String[] lllllllllllllllIllIlIIIIlIIIlIll, @Nullable final BlockPos lllllllllllllllIllIlIIIIlIIIIllI) {
        if (lllllllllllllllIllIlIIIIlIIIlIll.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIllIlIIIIlIIIlIll, "entity", "block");
        }
        if (lllllllllllllllIllIlIIIIlIIIlIll.length == 2 && "entity".equals(lllllllllllllllIllIlIIIIlIIIlIll[0])) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIllIlIIIIlIIIlIll, lllllllllllllllIllIlIIIIlIIIlIII.getAllUsernames());
        }
        if (lllllllllllllllIllIlIIIIlIIIlIll.length >= 2 && lllllllllllllllIllIlIIIIlIIIlIll.length <= 4 && "block".equals(lllllllllllllllIllIlIIIIlIIIlIll[0])) {
            return CommandBase.getTabCompletionCoordinate(lllllllllllllllIllIlIIIIlIIIlIll, 1, lllllllllllllllIllIlIIIIlIIIIllI);
        }
        if ((lllllllllllllllIllIlIIIIlIIIlIll.length == 3 && "entity".equals(lllllllllllllllIllIlIIIIlIIIlIll[0])) || (lllllllllllllllIllIlIIIIlIIIlIll.length == 5 && "block".equals(lllllllllllllllIllIlIIIIlIIIlIll[0]))) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIllIlIIIIlIIIlIll, "set", "clear");
        }
        if ((lllllllllllllllIllIlIIIIlIIIlIll.length != 4 || !"entity".equals(lllllllllllllllIllIlIIIIlIIIlIll[0])) && (lllllllllllllllIllIlIIIIlIIIlIll.length != 6 || !"block".equals(lllllllllllllllIllIlIIIIlIIIlIll[0]))) {
            return ((lllllllllllllllIllIlIIIIlIIIlIll.length != 6 || !"entity".equals(lllllllllllllllIllIlIIIIlIIIlIll[0])) && (lllllllllllllllIllIlIIIIlIIIlIll.length != 8 || !"block".equals(lllllllllllllllIllIlIIIIlIIIlIll[0]))) ? Collections.emptyList() : CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIllIlIIIIlIIIlIll, this.getObjectiveNames(lllllllllllllllIllIlIIIIlIIIlIII));
        }
        return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIllIlIIIIlIIIlIll, CommandResultStats.Type.getTypeNames());
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllllllIllIlIIIIIlllIIll, final int lllllllllllllllIllIlIIIIIlllIIlI) {
        return lllllllllllllllIllIlIIIIIlllIIll.length > 0 && "entity".equals(lllllllllllllllIllIlIIIIIlllIIll[0]) && lllllllllllllllIllIlIIIIIlllIIlI == 1;
    }
    
    @Override
    public String getCommandName() {
        return "stats";
    }
    
    protected List<String> getObjectiveNames(final MinecraftServer lllllllllllllllIllIlIIIIIlllllll) {
        final Collection<ScoreObjective> lllllllllllllllIllIlIIIIIllllllI = lllllllllllllllIllIlIIIIIlllllll.worldServerForDimension(0).getScoreboard().getScoreObjectives();
        final List<String> lllllllllllllllIllIlIIIIIlllllIl = (List<String>)Lists.newArrayList();
        for (final ScoreObjective lllllllllllllllIllIlIIIIIlllllII : lllllllllllllllIllIlIIIIIllllllI) {
            if (!lllllllllllllllIllIlIIIIIlllllII.getCriteria().isReadOnly()) {
                lllllllllllllllIllIlIIIIIlllllIl.add(lllllllllllllllIllIlIIIIIlllllII.getName());
            }
        }
        return lllllllllllllllIllIlIIIIIlllllIl;
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllllIllIlIIIIlIIlllIl, final ICommandSender lllllllllllllllIllIlIIIIlIIlllII, final String[] lllllllllllllllIllIlIIIIlIIllIll) throws CommandException {
        if (lllllllllllllllIllIlIIIIlIIllIll.length < 1) {
            throw new WrongUsageException("commands.stats.usage", new Object[0]);
        }
        boolean lllllllllllllllIllIlIIIIlIlIlllI = false;
        if ("entity".equals(lllllllllllllllIllIlIIIIlIIllIll[0])) {
            final boolean lllllllllllllllIllIlIIIIlIlIllll = false;
        }
        else {
            if (!"block".equals(lllllllllllllllIllIlIIIIlIIllIll[0])) {
                throw new WrongUsageException("commands.stats.usage", new Object[0]);
            }
            lllllllllllllllIllIlIIIIlIlIlllI = true;
        }
        int lllllllllllllllIllIlIIIIlIlIllII = 0;
        if (lllllllllllllllIllIlIIIIlIlIlllI) {
            if (lllllllllllllllIllIlIIIIlIIllIll.length < 5) {
                throw new WrongUsageException("commands.stats.block.usage", new Object[0]);
            }
            final int lllllllllllllllIllIlIIIIlIlIllIl = 4;
        }
        else {
            if (lllllllllllllllIllIlIIIIlIIllIll.length < 3) {
                throw new WrongUsageException("commands.stats.entity.usage", new Object[0]);
            }
            lllllllllllllllIllIlIIIIlIlIllII = 2;
        }
        final String lllllllllllllllIllIlIIIIlIlIlIll = lllllllllllllllIllIlIIIIlIIllIll[lllllllllllllllIllIlIIIIlIlIllII++];
        if ("set".equals(lllllllllllllllIllIlIIIIlIlIlIll)) {
            if (lllllllllllllllIllIlIIIIlIIllIll.length < lllllllllllllllIllIlIIIIlIlIllII + 3) {
                if (lllllllllllllllIllIlIIIIlIlIllII == 5) {
                    throw new WrongUsageException("commands.stats.block.set.usage", new Object[0]);
                }
                throw new WrongUsageException("commands.stats.entity.set.usage", new Object[0]);
            }
        }
        else {
            if (!"clear".equals(lllllllllllllllIllIlIIIIlIlIlIll)) {
                throw new WrongUsageException("commands.stats.usage", new Object[0]);
            }
            if (lllllllllllllllIllIlIIIIlIIllIll.length < lllllllllllllllIllIlIIIIlIlIllII + 1) {
                if (lllllllllllllllIllIlIIIIlIlIllII == 5) {
                    throw new WrongUsageException("commands.stats.block.clear.usage", new Object[0]);
                }
                throw new WrongUsageException("commands.stats.entity.clear.usage", new Object[0]);
            }
        }
        final CommandResultStats.Type lllllllllllllllIllIlIIIIlIlIlIlI = CommandResultStats.Type.getTypeByName(lllllllllllllllIllIlIIIIlIIllIll[lllllllllllllllIllIlIIIIlIlIllII++]);
        if (lllllllllllllllIllIlIIIIlIlIlIlI == null) {
            throw new CommandException("commands.stats.failed", new Object[0]);
        }
        final World lllllllllllllllIllIlIIIIlIlIlIIl = lllllllllllllllIllIlIIIIlIIlllII.getEntityWorld();
        CommandResultStats lllllllllllllllIllIlIIIIlIlIIllI;
        if (lllllllllllllllIllIlIIIIlIlIlllI) {
            final BlockPos lllllllllllllllIllIlIIIIlIlIIlIl = CommandBase.parseBlockPos(lllllllllllllllIllIlIIIIlIIlllII, lllllllllllllllIllIlIIIIlIIllIll, 1, false);
            final TileEntity lllllllllllllllIllIlIIIIlIlIIlII = lllllllllllllllIllIlIIIIlIlIlIIl.getTileEntity(lllllllllllllllIllIlIIIIlIlIIlIl);
            if (lllllllllllllllIllIlIIIIlIlIIlII == null) {
                throw new CommandException("commands.stats.noCompatibleBlock", new Object[] { lllllllllllllllIllIlIIIIlIlIIlIl.getX(), lllllllllllllllIllIlIIIIlIlIIlIl.getY(), lllllllllllllllIllIlIIIIlIlIIlIl.getZ() });
            }
            if (lllllllllllllllIllIlIIIIlIlIIlII instanceof TileEntityCommandBlock) {
                final CommandResultStats lllllllllllllllIllIlIIIIlIlIlIII = ((TileEntityCommandBlock)lllllllllllllllIllIlIIIIlIlIIlII).getCommandResultStats();
            }
            else {
                if (!(lllllllllllllllIllIlIIIIlIlIIlII instanceof TileEntitySign)) {
                    throw new CommandException("commands.stats.noCompatibleBlock", new Object[] { lllllllllllllllIllIlIIIIlIlIIlIl.getX(), lllllllllllllllIllIlIIIIlIlIIlIl.getY(), lllllllllllllllIllIlIIIIlIlIIlIl.getZ() });
                }
                final CommandResultStats lllllllllllllllIllIlIIIIlIlIIlll = ((TileEntitySign)lllllllllllllllIllIlIIIIlIlIIlII).getStats();
            }
        }
        else {
            final Entity lllllllllllllllIllIlIIIIlIlIIIll = CommandBase.getEntity(lllllllllllllllIllIlIIIIlIIlllIl, lllllllllllllllIllIlIIIIlIIlllII, lllllllllllllllIllIlIIIIlIIllIll[1]);
            lllllllllllllllIllIlIIIIlIlIIllI = lllllllllllllllIllIlIIIIlIlIIIll.getCommandStats();
        }
        if ("set".equals(lllllllllllllllIllIlIIIIlIlIlIll)) {
            final String lllllllllllllllIllIlIIIIlIlIIIlI = lllllllllllllllIllIlIIIIlIIllIll[lllllllllllllllIllIlIIIIlIlIllII++];
            final String lllllllllllllllIllIlIIIIlIlIIIIl = lllllllllllllllIllIlIIIIlIIllIll[lllllllllllllllIllIlIIIIlIlIllII];
            if (lllllllllllllllIllIlIIIIlIlIIIlI.isEmpty() || lllllllllllllllIllIlIIIIlIlIIIIl.isEmpty()) {
                throw new CommandException("commands.stats.failed", new Object[0]);
            }
            CommandResultStats.setScoreBoardStat(lllllllllllllllIllIlIIIIlIlIIllI, lllllllllllllllIllIlIIIIlIlIlIlI, lllllllllllllllIllIlIIIIlIlIIIlI, lllllllllllllllIllIlIIIIlIlIIIIl);
            CommandBase.notifyCommandListener(lllllllllllllllIllIlIIIIlIIlllII, this, "commands.stats.success", lllllllllllllllIllIlIIIIlIlIlIlI.getTypeName(), lllllllllllllllIllIlIIIIlIlIIIIl, lllllllllllllllIllIlIIIIlIlIIIlI);
        }
        else if ("clear".equals(lllllllllllllllIllIlIIIIlIlIlIll)) {
            CommandResultStats.setScoreBoardStat(lllllllllllllllIllIlIIIIlIlIIllI, lllllllllllllllIllIlIIIIlIlIlIlI, null, null);
            CommandBase.notifyCommandListener(lllllllllllllllIllIlIIIIlIIlllII, this, "commands.stats.cleared", lllllllllllllllIllIlIIIIlIlIlIlI.getTypeName());
        }
        if (lllllllllllllllIllIlIIIIlIlIlllI) {
            final BlockPos lllllllllllllllIllIlIIIIlIlIIIII = CommandBase.parseBlockPos(lllllllllllllllIllIlIIIIlIIlllII, lllllllllllllllIllIlIIIIlIIllIll, 1, false);
            final TileEntity lllllllllllllllIllIlIIIIlIIlllll = lllllllllllllllIllIlIIIIlIlIlIIl.getTileEntity(lllllllllllllllIllIlIIIIlIlIIIII);
            lllllllllllllllIllIlIIIIlIIlllll.markDirty();
        }
    }
}
