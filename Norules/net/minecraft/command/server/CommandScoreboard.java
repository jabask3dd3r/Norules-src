package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.util.text.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.nbt.*;
import com.google.common.collect.*;
import net.minecraft.command.*;
import net.minecraft.scoreboard.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;

public class CommandScoreboard extends CommandBase
{
    protected ScoreObjective convertToObjective(final String lllllllllllllllllIIlIIllIlllIIIl, final boolean lllllllllllllllllIIlIIllIllIlIlI, final MinecraftServer lllllllllllllllllIIlIIllIllIllll) throws CommandException {
        final Scoreboard lllllllllllllllllIIlIIllIllIlllI = this.getScoreboard(lllllllllllllllllIIlIIllIllIllll);
        final ScoreObjective lllllllllllllllllIIlIIllIllIllIl = lllllllllllllllllIIlIIllIllIlllI.getObjective(lllllllllllllllllIIlIIllIlllIIIl);
        if (lllllllllllllllllIIlIIllIllIllIl == null) {
            throw new CommandException("commands.scoreboard.objectiveNotFound", new Object[] { lllllllllllllllllIIlIIllIlllIIIl });
        }
        if (lllllllllllllllllIIlIIllIllIlIlI && lllllllllllllllllIIlIIllIllIllIl.getCriteria().isReadOnly()) {
            throw new CommandException("commands.scoreboard.objectiveReadOnly", new Object[] { lllllllllllllllllIIlIIllIlllIIIl });
        }
        return lllllllllllllllllIIlIIllIllIllIl;
    }
    
    protected void listPlayers(final ICommandSender lllllllllllllllllIIlIIlIIIIlIlII, final String[] lllllllllllllllllIIlIIlIIIIIIlll, final int lllllllllllllllllIIlIIlIIIIlIIlI, final MinecraftServer lllllllllllllllllIIlIIlIIIIIIlIl) throws CommandException {
        final Scoreboard lllllllllllllllllIIlIIlIIIIlIIII = this.getScoreboard(lllllllllllllllllIIlIIlIIIIIIlIl);
        if (lllllllllllllllllIIlIIlIIIIIIlll.length > lllllllllllllllllIIlIIlIIIIlIIlI) {
            final String lllllllllllllllllIIlIIlIIIIIllll = CommandBase.getEntityName(lllllllllllllllllIIlIIlIIIIIIlIl, lllllllllllllllllIIlIIlIIIIlIlII, lllllllllllllllllIIlIIlIIIIIIlll[lllllllllllllllllIIlIIlIIIIlIIlI]);
            final Map<ScoreObjective, Score> lllllllllllllllllIIlIIlIIIIIlllI = lllllllllllllllllIIlIIlIIIIlIIII.getObjectivesForEntity(lllllllllllllllllIIlIIlIIIIIllll);
            lllllllllllllllllIIlIIlIIIIlIlII.setCommandStat(CommandResultStats.Type.QUERY_RESULT, lllllllllllllllllIIlIIlIIIIIlllI.size());
            if (lllllllllllllllllIIlIIlIIIIIlllI.isEmpty()) {
                throw new CommandException("commands.scoreboard.players.list.player.empty", new Object[] { lllllllllllllllllIIlIIlIIIIIllll });
            }
            final TextComponentTranslation lllllllllllllllllIIlIIlIIIIIllIl = new TextComponentTranslation("commands.scoreboard.players.list.player.count", new Object[] { lllllllllllllllllIIlIIlIIIIIlllI.size(), lllllllllllllllllIIlIIlIIIIIllll });
            lllllllllllllllllIIlIIlIIIIIllIl.getStyle().setColor(TextFormatting.DARK_GREEN);
            lllllllllllllllllIIlIIlIIIIlIlII.addChatMessage(lllllllllllllllllIIlIIlIIIIIllIl);
            for (final Score lllllllllllllllllIIlIIlIIIIIllII : lllllllllllllllllIIlIIlIIIIIlllI.values()) {
                lllllllllllllllllIIlIIlIIIIlIlII.addChatMessage(new TextComponentTranslation("commands.scoreboard.players.list.player.entry", new Object[] { lllllllllllllllllIIlIIlIIIIIllII.getScorePoints(), lllllllllllllllllIIlIIlIIIIIllII.getObjective().getDisplayName(), lllllllllllllllllIIlIIlIIIIIllII.getObjective().getName() }));
            }
        }
        else {
            final Collection<String> lllllllllllllllllIIlIIlIIIIIlIll = lllllllllllllllllIIlIIlIIIIlIIII.getObjectiveNames();
            lllllllllllllllllIIlIIlIIIIlIlII.setCommandStat(CommandResultStats.Type.QUERY_RESULT, lllllllllllllllllIIlIIlIIIIIlIll.size());
            if (lllllllllllllllllIIlIIlIIIIIlIll.isEmpty()) {
                throw new CommandException("commands.scoreboard.players.list.empty", new Object[0]);
            }
            final TextComponentTranslation lllllllllllllllllIIlIIlIIIIIlIlI = new TextComponentTranslation("commands.scoreboard.players.list.count", new Object[] { lllllllllllllllllIIlIIlIIIIIlIll.size() });
            lllllllllllllllllIIlIIlIIIIIlIlI.getStyle().setColor(TextFormatting.DARK_GREEN);
            lllllllllllllllllIIlIIlIIIIlIlII.addChatMessage(lllllllllllllllllIIlIIlIIIIIlIlI);
            lllllllllllllllllIIlIIlIIIIlIlII.addChatMessage(new TextComponentString(CommandBase.joinNiceString(lllllllllllllllllIIlIIlIIIIIlIll.toArray())));
        }
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllllllIIlIIlllIlIIIll, final ICommandSender lllllllllllllllllIIlIIlllIlIIIlI, final String[] lllllllllllllllllIIlIIlllIlIIIIl) throws CommandException {
        if (!this.handleUserWildcards(lllllllllllllllllIIlIIlllIlIIIll, lllllllllllllllllIIlIIlllIlIIIlI, lllllllllllllllllIIlIIlllIlIIIIl)) {
            if (lllllllllllllllllIIlIIlllIlIIIIl.length < 1) {
                throw new WrongUsageException("commands.scoreboard.usage", new Object[0]);
            }
            if ("objectives".equalsIgnoreCase(lllllllllllllllllIIlIIlllIlIIIIl[0])) {
                if (lllllllllllllllllIIlIIlllIlIIIIl.length == 1) {
                    throw new WrongUsageException("commands.scoreboard.objectives.usage", new Object[0]);
                }
                if ("list".equalsIgnoreCase(lllllllllllllllllIIlIIlllIlIIIIl[1])) {
                    this.listObjectives(lllllllllllllllllIIlIIlllIlIIIlI, lllllllllllllllllIIlIIlllIlIIIll);
                }
                else if ("add".equalsIgnoreCase(lllllllllllllllllIIlIIlllIlIIIIl[1])) {
                    if (lllllllllllllllllIIlIIlllIlIIIIl.length < 4) {
                        throw new WrongUsageException("commands.scoreboard.objectives.add.usage", new Object[0]);
                    }
                    this.addObjective(lllllllllllllllllIIlIIlllIlIIIlI, lllllllllllllllllIIlIIlllIlIIIIl, 2, lllllllllllllllllIIlIIlllIlIIIll);
                }
                else if ("remove".equalsIgnoreCase(lllllllllllllllllIIlIIlllIlIIIIl[1])) {
                    if (lllllllllllllllllIIlIIlllIlIIIIl.length != 3) {
                        throw new WrongUsageException("commands.scoreboard.objectives.remove.usage", new Object[0]);
                    }
                    this.removeObjective(lllllllllllllllllIIlIIlllIlIIIlI, lllllllllllllllllIIlIIlllIlIIIIl[2], lllllllllllllllllIIlIIlllIlIIIll);
                }
                else {
                    if (!"setdisplay".equalsIgnoreCase(lllllllllllllllllIIlIIlllIlIIIIl[1])) {
                        throw new WrongUsageException("commands.scoreboard.objectives.usage", new Object[0]);
                    }
                    if (lllllllllllllllllIIlIIlllIlIIIIl.length != 3 && lllllllllllllllllIIlIIlllIlIIIIl.length != 4) {
                        throw new WrongUsageException("commands.scoreboard.objectives.setdisplay.usage", new Object[0]);
                    }
                    this.setDisplayObjective(lllllllllllllllllIIlIIlllIlIIIlI, lllllllllllllllllIIlIIlllIlIIIIl, 2, lllllllllllllllllIIlIIlllIlIIIll);
                }
            }
            else if ("players".equalsIgnoreCase(lllllllllllllllllIIlIIlllIlIIIIl[0])) {
                if (lllllllllllllllllIIlIIlllIlIIIIl.length == 1) {
                    throw new WrongUsageException("commands.scoreboard.players.usage", new Object[0]);
                }
                if ("list".equalsIgnoreCase(lllllllllllllllllIIlIIlllIlIIIIl[1])) {
                    if (lllllllllllllllllIIlIIlllIlIIIIl.length > 3) {
                        throw new WrongUsageException("commands.scoreboard.players.list.usage", new Object[0]);
                    }
                    this.listPlayers(lllllllllllllllllIIlIIlllIlIIIlI, lllllllllllllllllIIlIIlllIlIIIIl, 2, lllllllllllllllllIIlIIlllIlIIIll);
                }
                else if ("add".equalsIgnoreCase(lllllllllllllllllIIlIIlllIlIIIIl[1])) {
                    if (lllllllllllllllllIIlIIlllIlIIIIl.length < 5) {
                        throw new WrongUsageException("commands.scoreboard.players.add.usage", new Object[0]);
                    }
                    this.addPlayerScore(lllllllllllllllllIIlIIlllIlIIIlI, lllllllllllllllllIIlIIlllIlIIIIl, 2, lllllllllllllllllIIlIIlllIlIIIll);
                }
                else if ("remove".equalsIgnoreCase(lllllllllllllllllIIlIIlllIlIIIIl[1])) {
                    if (lllllllllllllllllIIlIIlllIlIIIIl.length < 5) {
                        throw new WrongUsageException("commands.scoreboard.players.remove.usage", new Object[0]);
                    }
                    this.addPlayerScore(lllllllllllllllllIIlIIlllIlIIIlI, lllllllllllllllllIIlIIlllIlIIIIl, 2, lllllllllllllllllIIlIIlllIlIIIll);
                }
                else if ("set".equalsIgnoreCase(lllllllllllllllllIIlIIlllIlIIIIl[1])) {
                    if (lllllllllllllllllIIlIIlllIlIIIIl.length < 5) {
                        throw new WrongUsageException("commands.scoreboard.players.set.usage", new Object[0]);
                    }
                    this.addPlayerScore(lllllllllllllllllIIlIIlllIlIIIlI, lllllllllllllllllIIlIIlllIlIIIIl, 2, lllllllllllllllllIIlIIlllIlIIIll);
                }
                else if ("reset".equalsIgnoreCase(lllllllllllllllllIIlIIlllIlIIIIl[1])) {
                    if (lllllllllllllllllIIlIIlllIlIIIIl.length != 3 && lllllllllllllllllIIlIIlllIlIIIIl.length != 4) {
                        throw new WrongUsageException("commands.scoreboard.players.reset.usage", new Object[0]);
                    }
                    this.resetPlayerScore(lllllllllllllllllIIlIIlllIlIIIlI, lllllllllllllllllIIlIIlllIlIIIIl, 2, lllllllllllllllllIIlIIlllIlIIIll);
                }
                else if ("enable".equalsIgnoreCase(lllllllllllllllllIIlIIlllIlIIIIl[1])) {
                    if (lllllllllllllllllIIlIIlllIlIIIIl.length != 4) {
                        throw new WrongUsageException("commands.scoreboard.players.enable.usage", new Object[0]);
                    }
                    this.enablePlayerTrigger(lllllllllllllllllIIlIIlllIlIIIlI, lllllllllllllllllIIlIIlllIlIIIIl, 2, lllllllllllllllllIIlIIlllIlIIIll);
                }
                else if ("test".equalsIgnoreCase(lllllllllllllllllIIlIIlllIlIIIIl[1])) {
                    if (lllllllllllllllllIIlIIlllIlIIIIl.length != 5 && lllllllllllllllllIIlIIlllIlIIIIl.length != 6) {
                        throw new WrongUsageException("commands.scoreboard.players.test.usage", new Object[0]);
                    }
                    this.testPlayerScore(lllllllllllllllllIIlIIlllIlIIIlI, lllllllllllllllllIIlIIlllIlIIIIl, 2, lllllllllllllllllIIlIIlllIlIIIll);
                }
                else if ("operation".equalsIgnoreCase(lllllllllllllllllIIlIIlllIlIIIIl[1])) {
                    if (lllllllllllllllllIIlIIlllIlIIIIl.length != 7) {
                        throw new WrongUsageException("commands.scoreboard.players.operation.usage", new Object[0]);
                    }
                    this.applyPlayerOperation(lllllllllllllllllIIlIIlllIlIIIlI, lllllllllllllllllIIlIIlllIlIIIIl, 2, lllllllllllllllllIIlIIlllIlIIIll);
                }
                else {
                    if (!"tag".equalsIgnoreCase(lllllllllllllllllIIlIIlllIlIIIIl[1])) {
                        throw new WrongUsageException("commands.scoreboard.players.usage", new Object[0]);
                    }
                    if (lllllllllllllllllIIlIIlllIlIIIIl.length < 4) {
                        throw new WrongUsageException("commands.scoreboard.players.tag.usage", new Object[0]);
                    }
                    this.applyPlayerTag(lllllllllllllllllIIlIIlllIlIIIll, lllllllllllllllllIIlIIlllIlIIIlI, lllllllllllllllllIIlIIlllIlIIIIl, 2);
                }
            }
            else {
                if (!"teams".equalsIgnoreCase(lllllllllllllllllIIlIIlllIlIIIIl[0])) {
                    throw new WrongUsageException("commands.scoreboard.usage", new Object[0]);
                }
                if (lllllllllllllllllIIlIIlllIlIIIIl.length == 1) {
                    throw new WrongUsageException("commands.scoreboard.teams.usage", new Object[0]);
                }
                if ("list".equalsIgnoreCase(lllllllllllllllllIIlIIlllIlIIIIl[1])) {
                    if (lllllllllllllllllIIlIIlllIlIIIIl.length > 3) {
                        throw new WrongUsageException("commands.scoreboard.teams.list.usage", new Object[0]);
                    }
                    this.listTeams(lllllllllllllllllIIlIIlllIlIIIlI, lllllllllllllllllIIlIIlllIlIIIIl, 2, lllllllllllllllllIIlIIlllIlIIIll);
                }
                else if ("add".equalsIgnoreCase(lllllllllllllllllIIlIIlllIlIIIIl[1])) {
                    if (lllllllllllllllllIIlIIlllIlIIIIl.length < 3) {
                        throw new WrongUsageException("commands.scoreboard.teams.add.usage", new Object[0]);
                    }
                    this.addTeam(lllllllllllllllllIIlIIlllIlIIIlI, lllllllllllllllllIIlIIlllIlIIIIl, 2, lllllllllllllllllIIlIIlllIlIIIll);
                }
                else if ("remove".equalsIgnoreCase(lllllllllllllllllIIlIIlllIlIIIIl[1])) {
                    if (lllllllllllllllllIIlIIlllIlIIIIl.length != 3) {
                        throw new WrongUsageException("commands.scoreboard.teams.remove.usage", new Object[0]);
                    }
                    this.removeTeam(lllllllllllllllllIIlIIlllIlIIIlI, lllllllllllllllllIIlIIlllIlIIIIl, 2, lllllllllllllllllIIlIIlllIlIIIll);
                }
                else if ("empty".equalsIgnoreCase(lllllllllllllllllIIlIIlllIlIIIIl[1])) {
                    if (lllllllllllllllllIIlIIlllIlIIIIl.length != 3) {
                        throw new WrongUsageException("commands.scoreboard.teams.empty.usage", new Object[0]);
                    }
                    this.emptyTeam(lllllllllllllllllIIlIIlllIlIIIlI, lllllllllllllllllIIlIIlllIlIIIIl, 2, lllllllllllllllllIIlIIlllIlIIIll);
                }
                else if ("join".equalsIgnoreCase(lllllllllllllllllIIlIIlllIlIIIIl[1])) {
                    if (lllllllllllllllllIIlIIlllIlIIIIl.length < 4 && (lllllllllllllllllIIlIIlllIlIIIIl.length != 3 || !(lllllllllllllllllIIlIIlllIlIIIlI instanceof EntityPlayer))) {
                        throw new WrongUsageException("commands.scoreboard.teams.join.usage", new Object[0]);
                    }
                    this.joinTeam(lllllllllllllllllIIlIIlllIlIIIlI, lllllllllllllllllIIlIIlllIlIIIIl, 2, lllllllllllllllllIIlIIlllIlIIIll);
                }
                else if ("leave".equalsIgnoreCase(lllllllllllllllllIIlIIlllIlIIIIl[1])) {
                    if (lllllllllllllllllIIlIIlllIlIIIIl.length < 3 && !(lllllllllllllllllIIlIIlllIlIIIlI instanceof EntityPlayer)) {
                        throw new WrongUsageException("commands.scoreboard.teams.leave.usage", new Object[0]);
                    }
                    this.leaveTeam(lllllllllllllllllIIlIIlllIlIIIlI, lllllllllllllllllIIlIIlllIlIIIIl, 2, lllllllllllllllllIIlIIlllIlIIIll);
                }
                else {
                    if (!"option".equalsIgnoreCase(lllllllllllllllllIIlIIlllIlIIIIl[1])) {
                        throw new WrongUsageException("commands.scoreboard.teams.usage", new Object[0]);
                    }
                    if (lllllllllllllllllIIlIIlllIlIIIIl.length != 4 && lllllllllllllllllIIlIIlllIlIIIIl.length != 5) {
                        throw new WrongUsageException("commands.scoreboard.teams.option.usage", new Object[0]);
                    }
                    this.setTeamOption(lllllllllllllllllIIlIIlllIlIIIlI, lllllllllllllllllIIlIIlllIlIIIIl, 2, lllllllllllllllllIIlIIlllIlIIIll);
                }
            }
        }
    }
    
    protected List<String> getTriggerNames(final MinecraftServer lllllllllllllllllIIlIIIlIIIIIIlI) {
        final Collection<ScoreObjective> lllllllllllllllllIIlIIIlIIIIIllI = this.getScoreboard(lllllllllllllllllIIlIIIlIIIIIIlI).getScoreObjectives();
        final List<String> lllllllllllllllllIIlIIIlIIIIIlIl = (List<String>)Lists.newArrayList();
        for (final ScoreObjective lllllllllllllllllIIlIIIlIIIIIlII : lllllllllllllllllIIlIIIlIIIIIllI) {
            if (lllllllllllllllllIIlIIIlIIIIIlII.getCriteria() == IScoreCriteria.TRIGGER) {
                lllllllllllllllllIIlIIIlIIIIIlIl.add(lllllllllllllllllIIlIIIlIIIIIlII.getName());
            }
        }
        return lllllllllllllllllIIlIIIlIIIIIlIl;
    }
    
    protected void setDisplayObjective(final ICommandSender lllllllllllllllllIIlIIlIIIllIIIl, final String[] lllllllllllllllllIIlIIlIIIllIIII, int lllllllllllllllllIIlIIlIIIlIllll, final MinecraftServer lllllllllllllllllIIlIIlIIIlIlllI) throws CommandException {
        final Scoreboard lllllllllllllllllIIlIIlIIIlIllIl = this.getScoreboard(lllllllllllllllllIIlIIlIIIlIlllI);
        final String lllllllllllllllllIIlIIlIIIlIllII = lllllllllllllllllIIlIIlIIIllIIII[lllllllllllllllllIIlIIlIIIlIllll++];
        final int lllllllllllllllllIIlIIlIIIlIlIll = Scoreboard.getObjectiveDisplaySlotNumber(lllllllllllllllllIIlIIlIIIlIllII);
        ScoreObjective lllllllllllllllllIIlIIlIIIlIlIlI = null;
        if (lllllllllllllllllIIlIIlIIIllIIII.length == 4) {
            lllllllllllllllllIIlIIlIIIlIlIlI = this.convertToObjective(lllllllllllllllllIIlIIlIIIllIIII[lllllllllllllllllIIlIIlIIIlIllll], false, lllllllllllllllllIIlIIlIIIlIlllI);
        }
        if (lllllllllllllllllIIlIIlIIIlIlIll < 0) {
            throw new CommandException("commands.scoreboard.objectives.setdisplay.invalidSlot", new Object[] { lllllllllllllllllIIlIIlIIIlIllII });
        }
        lllllllllllllllllIIlIIlIIIlIllIl.setObjectiveInDisplaySlot(lllllllllllllllllIIlIIlIIIlIlIll, lllllllllllllllllIIlIIlIIIlIlIlI);
        if (lllllllllllllllllIIlIIlIIIlIlIlI != null) {
            CommandBase.notifyCommandListener(lllllllllllllllllIIlIIlIIIllIIIl, this, "commands.scoreboard.objectives.setdisplay.successSet", Scoreboard.getObjectiveDisplaySlot(lllllllllllllllllIIlIIlIIIlIlIll), lllllllllllllllllIIlIIlIIIlIlIlI.getName());
        }
        else {
            CommandBase.notifyCommandListener(lllllllllllllllllIIlIIlIIIllIIIl, this, "commands.scoreboard.objectives.setdisplay.successCleared", Scoreboard.getObjectiveDisplaySlot(lllllllllllllllllIIlIIlIIIlIlIll));
        }
    }
    
    protected void removeObjective(final ICommandSender lllllllllllllllllIIlIIlIIlIlIlll, final String lllllllllllllllllIIlIIlIIlIlllII, final MinecraftServer lllllllllllllllllIIlIIlIIlIllIll) throws CommandException {
        final Scoreboard lllllllllllllllllIIlIIlIIlIllIlI = this.getScoreboard(lllllllllllllllllIIlIIlIIlIllIll);
        final ScoreObjective lllllllllllllllllIIlIIlIIlIllIIl = this.convertToObjective(lllllllllllllllllIIlIIlIIlIlllII, false, lllllllllllllllllIIlIIlIIlIllIll);
        lllllllllllllllllIIlIIlIIlIllIlI.removeObjective(lllllllllllllllllIIlIIlIIlIllIIl);
        CommandBase.notifyCommandListener(lllllllllllllllllIIlIIlIIlIlIlll, this, "commands.scoreboard.objectives.remove.success", lllllllllllllllllIIlIIlIIlIlllII);
    }
    
    protected void resetPlayerScore(final ICommandSender lllllllllllllllllIIlIIIlllIIIIll, final String[] lllllllllllllllllIIlIIIlllIIlIlI, int lllllllllllllllllIIlIIIlllIIIIIl, final MinecraftServer lllllllllllllllllIIlIIIlllIIlIII) throws CommandException {
        final Scoreboard lllllllllllllllllIIlIIIlllIIIlll = this.getScoreboard(lllllllllllllllllIIlIIIlllIIlIII);
        final String lllllllllllllllllIIlIIIlllIIIllI = CommandBase.getEntityName(lllllllllllllllllIIlIIIlllIIlIII, lllllllllllllllllIIlIIIlllIIIIll, lllllllllllllllllIIlIIIlllIIlIlI[lllllllllllllllllIIlIIIlllIIIIIl++]);
        if (lllllllllllllllllIIlIIIlllIIlIlI.length > lllllllllllllllllIIlIIIlllIIIIIl) {
            final ScoreObjective lllllllllllllllllIIlIIIlllIIIlIl = this.convertToObjective(lllllllllllllllllIIlIIIlllIIlIlI[lllllllllllllllllIIlIIIlllIIIIIl++], false, lllllllllllllllllIIlIIIlllIIlIII);
            lllllllllllllllllIIlIIIlllIIIlll.removeObjectiveFromEntity(lllllllllllllllllIIlIIIlllIIIllI, lllllllllllllllllIIlIIIlllIIIlIl);
            CommandBase.notifyCommandListener(lllllllllllllllllIIlIIIlllIIIIll, this, "commands.scoreboard.players.resetscore.success", lllllllllllllllllIIlIIIlllIIIlIl.getName(), lllllllllllllllllIIlIIIlllIIIllI);
        }
        else {
            lllllllllllllllllIIlIIIlllIIIlll.removeObjectiveFromEntity(lllllllllllllllllIIlIIIlllIIIllI, null);
            CommandBase.notifyCommandListener(lllllllllllllllllIIlIIIlllIIIIll, this, "commands.scoreboard.players.reset.success", lllllllllllllllllIIlIIIlllIIIllI);
        }
    }
    
    protected void enablePlayerTrigger(final ICommandSender lllllllllllllllllIIlIIIllIllIIlI, final String[] lllllllllllllllllIIlIIIllIllIIIl, int lllllllllllllllllIIlIIIllIllIIII, final MinecraftServer lllllllllllllllllIIlIIIllIlIIllI) throws CommandException {
        final Scoreboard lllllllllllllllllIIlIIIllIlIlllI = this.getScoreboard(lllllllllllllllllIIlIIIllIlIIllI);
        final String lllllllllllllllllIIlIIIllIlIllIl = CommandBase.getPlayerName(lllllllllllllllllIIlIIIllIlIIllI, lllllllllllllllllIIlIIIllIllIIlI, lllllllllllllllllIIlIIIllIllIIIl[lllllllllllllllllIIlIIIllIllIIII++]);
        if (lllllllllllllllllIIlIIIllIlIllIl.length() > 40) {
            throw new SyntaxErrorException("commands.scoreboard.players.name.tooLong", new Object[] { lllllllllllllllllIIlIIIllIlIllIl, 40 });
        }
        final ScoreObjective lllllllllllllllllIIlIIIllIlIllII = this.convertToObjective(lllllllllllllllllIIlIIIllIllIIIl[lllllllllllllllllIIlIIIllIllIIII], false, lllllllllllllllllIIlIIIllIlIIllI);
        if (lllllllllllllllllIIlIIIllIlIllII.getCriteria() != IScoreCriteria.TRIGGER) {
            throw new CommandException("commands.scoreboard.players.enable.noTrigger", new Object[] { lllllllllllllllllIIlIIIllIlIllII.getName() });
        }
        final Score lllllllllllllllllIIlIIIllIlIlIll = lllllllllllllllllIIlIIIllIlIlllI.getOrCreateScore(lllllllllllllllllIIlIIIllIlIllIl, lllllllllllllllllIIlIIIllIlIllII);
        lllllllllllllllllIIlIIIllIlIlIll.setLocked(false);
        CommandBase.notifyCommandListener(lllllllllllllllllIIlIIIllIllIIlI, this, "commands.scoreboard.players.enable.success", lllllllllllllllllIIlIIIllIlIllII.getName(), lllllllllllllllllIIlIIIllIlIllIl);
    }
    
    protected void applyPlayerOperation(final ICommandSender lllllllllllllllllIIlIIIlIllIIIll, final String[] lllllllllllllllllIIlIIIlIllIIIlI, int lllllllllllllllllIIlIIIlIllIIIIl, final MinecraftServer lllllllllllllllllIIlIIIlIllIlllI) throws CommandException {
        final Scoreboard lllllllllllllllllIIlIIIlIllIllIl = this.getScoreboard(lllllllllllllllllIIlIIIlIllIlllI);
        final String lllllllllllllllllIIlIIIlIllIllII = CommandBase.getEntityName(lllllllllllllllllIIlIIIlIllIlllI, lllllllllllllllllIIlIIIlIllIIIll, lllllllllllllllllIIlIIIlIllIIIlI[lllllllllllllllllIIlIIIlIllIIIIl++]);
        final ScoreObjective lllllllllllllllllIIlIIIlIllIlIll = this.convertToObjective(lllllllllllllllllIIlIIIlIllIIIlI[lllllllllllllllllIIlIIIlIllIIIIl++], true, lllllllllllllllllIIlIIIlIllIlllI);
        final String lllllllllllllllllIIlIIIlIllIlIlI = lllllllllllllllllIIlIIIlIllIIIlI[lllllllllllllllllIIlIIIlIllIIIIl++];
        final String lllllllllllllllllIIlIIIlIllIlIIl = CommandBase.getEntityName(lllllllllllllllllIIlIIIlIllIlllI, lllllllllllllllllIIlIIIlIllIIIll, lllllllllllllllllIIlIIIlIllIIIlI[lllllllllllllllllIIlIIIlIllIIIIl++]);
        final ScoreObjective lllllllllllllllllIIlIIIlIllIlIII = this.convertToObjective(lllllllllllllllllIIlIIIlIllIIIlI[lllllllllllllllllIIlIIIlIllIIIIl], false, lllllllllllllllllIIlIIIlIllIlllI);
        if (lllllllllllllllllIIlIIIlIllIllII.length() > 40) {
            throw new SyntaxErrorException("commands.scoreboard.players.name.tooLong", new Object[] { lllllllllllllllllIIlIIIlIllIllII, 40 });
        }
        if (lllllllllllllllllIIlIIIlIllIlIIl.length() > 40) {
            throw new SyntaxErrorException("commands.scoreboard.players.name.tooLong", new Object[] { lllllllllllllllllIIlIIIlIllIlIIl, 40 });
        }
        final Score lllllllllllllllllIIlIIIlIllIIlll = lllllllllllllllllIIlIIIlIllIllIl.getOrCreateScore(lllllllllllllllllIIlIIIlIllIllII, lllllllllllllllllIIlIIIlIllIlIll);
        if (!lllllllllllllllllIIlIIIlIllIllIl.entityHasObjective(lllllllllllllllllIIlIIIlIllIlIIl, lllllllllllllllllIIlIIIlIllIlIII)) {
            throw new CommandException("commands.scoreboard.players.operation.notFound", new Object[] { lllllllllllllllllIIlIIIlIllIlIII.getName(), lllllllllllllllllIIlIIIlIllIlIIl });
        }
        final Score lllllllllllllllllIIlIIIlIllIIllI = lllllllllllllllllIIlIIIlIllIllIl.getOrCreateScore(lllllllllllllllllIIlIIIlIllIlIIl, lllllllllllllllllIIlIIIlIllIlIII);
        if ("+=".equals(lllllllllllllllllIIlIIIlIllIlIlI)) {
            lllllllllllllllllIIlIIIlIllIIlll.setScorePoints(lllllllllllllllllIIlIIIlIllIIlll.getScorePoints() + lllllllllllllllllIIlIIIlIllIIllI.getScorePoints());
        }
        else if ("-=".equals(lllllllllllllllllIIlIIIlIllIlIlI)) {
            lllllllllllllllllIIlIIIlIllIIlll.setScorePoints(lllllllllllllllllIIlIIIlIllIIlll.getScorePoints() - lllllllllllllllllIIlIIIlIllIIllI.getScorePoints());
        }
        else if ("*=".equals(lllllllllllllllllIIlIIIlIllIlIlI)) {
            lllllllllllllllllIIlIIIlIllIIlll.setScorePoints(lllllllllllllllllIIlIIIlIllIIlll.getScorePoints() * lllllllllllllllllIIlIIIlIllIIllI.getScorePoints());
        }
        else if ("/=".equals(lllllllllllllllllIIlIIIlIllIlIlI)) {
            if (lllllllllllllllllIIlIIIlIllIIllI.getScorePoints() != 0) {
                lllllllllllllllllIIlIIIlIllIIlll.setScorePoints(lllllllllllllllllIIlIIIlIllIIlll.getScorePoints() / lllllllllllllllllIIlIIIlIllIIllI.getScorePoints());
            }
        }
        else if ("%=".equals(lllllllllllllllllIIlIIIlIllIlIlI)) {
            if (lllllllllllllllllIIlIIIlIllIIllI.getScorePoints() != 0) {
                lllllllllllllllllIIlIIIlIllIIlll.setScorePoints(lllllllllllllllllIIlIIIlIllIIlll.getScorePoints() % lllllllllllllllllIIlIIIlIllIIllI.getScorePoints());
            }
        }
        else if ("=".equals(lllllllllllllllllIIlIIIlIllIlIlI)) {
            lllllllllllllllllIIlIIIlIllIIlll.setScorePoints(lllllllllllllllllIIlIIIlIllIIllI.getScorePoints());
        }
        else if ("<".equals(lllllllllllllllllIIlIIIlIllIlIlI)) {
            lllllllllllllllllIIlIIIlIllIIlll.setScorePoints(Math.min(lllllllllllllllllIIlIIIlIllIIlll.getScorePoints(), lllllllllllllllllIIlIIIlIllIIllI.getScorePoints()));
        }
        else if (">".equals(lllllllllllllllllIIlIIIlIllIlIlI)) {
            lllllllllllllllllIIlIIIlIllIIlll.setScorePoints(Math.max(lllllllllllllllllIIlIIIlIllIIlll.getScorePoints(), lllllllllllllllllIIlIIIlIllIIllI.getScorePoints()));
        }
        else {
            if (!"><".equals(lllllllllllllllllIIlIIIlIllIlIlI)) {
                throw new CommandException("commands.scoreboard.players.operation.invalidOperation", new Object[] { lllllllllllllllllIIlIIIlIllIlIlI });
            }
            final int lllllllllllllllllIIlIIIlIllIIlIl = lllllllllllllllllIIlIIIlIllIIlll.getScorePoints();
            lllllllllllllllllIIlIIIlIllIIlll.setScorePoints(lllllllllllllllllIIlIIIlIllIIllI.getScorePoints());
            lllllllllllllllllIIlIIIlIllIIllI.setScorePoints(lllllllllllllllllIIlIIIlIllIIlIl);
        }
        CommandBase.notifyCommandListener(lllllllllllllllllIIlIIIlIllIIIll, this, "commands.scoreboard.players.operation.success", new Object[0]);
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllllllllIIlIIIIlllllIlI, final int lllllllllllllllllIIlIIIIllllIlll) {
        if (!"players".equalsIgnoreCase(lllllllllllllllllIIlIIIIlllllIlI[0])) {
            return "teams".equalsIgnoreCase(lllllllllllllllllIIlIIIIlllllIlI[0]) && lllllllllllllllllIIlIIIIllllIlll == 2;
        }
        if (lllllllllllllllllIIlIIIIlllllIlI.length > 1 && "operation".equalsIgnoreCase(lllllllllllllllllIIlIIIIlllllIlI[1])) {
            return lllllllllllllllllIIlIIIIllllIlll == 2 || lllllllllllllllllIIlIIIIllllIlll == 5;
        }
        return lllllllllllllllllIIlIIIIllllIlll == 2;
    }
    
    protected void emptyTeam(final ICommandSender lllllllllllllllllIIlIIlIIllIllIl, final String[] lllllllllllllllllIIlIIlIIllIllII, final int lllllllllllllllllIIlIIlIIllIlIll, final MinecraftServer lllllllllllllllllIIlIIlIIlllIIll) throws CommandException {
        final Scoreboard lllllllllllllllllIIlIIlIIlllIIlI = this.getScoreboard(lllllllllllllllllIIlIIlIIlllIIll);
        final ScorePlayerTeam lllllllllllllllllIIlIIlIIlllIIIl = this.convertToTeam(lllllllllllllllllIIlIIlIIllIllII[lllllllllllllllllIIlIIlIIllIlIll], lllllllllllllllllIIlIIlIIlllIIll);
        if (lllllllllllllllllIIlIIlIIlllIIIl != null) {
            final Collection<String> lllllllllllllllllIIlIIlIIlllIIII = (Collection<String>)Lists.newArrayList((Iterable)lllllllllllllllllIIlIIlIIlllIIIl.getMembershipCollection());
            lllllllllllllllllIIlIIlIIllIllIl.setCommandStat(CommandResultStats.Type.AFFECTED_ENTITIES, lllllllllllllllllIIlIIlIIlllIIII.size());
            if (lllllllllllllllllIIlIIlIIlllIIII.isEmpty()) {
                throw new CommandException("commands.scoreboard.teams.empty.alreadyEmpty", new Object[] { lllllllllllllllllIIlIIlIIlllIIIl.getRegisteredName() });
            }
            for (final String lllllllllllllllllIIlIIlIIllIllll : lllllllllllllllllIIlIIlIIlllIIII) {
                lllllllllllllllllIIlIIlIIlllIIlI.removePlayerFromTeam(lllllllllllllllllIIlIIlIIllIllll, lllllllllllllllllIIlIIlIIlllIIIl);
            }
            CommandBase.notifyCommandListener(lllllllllllllllllIIlIIlIIllIllIl, this, "commands.scoreboard.teams.empty.success", lllllllllllllllllIIlIIlIIlllIIII.size(), lllllllllllllllllIIlIIlIIlllIIIl.getRegisteredName());
        }
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    protected void addObjective(final ICommandSender lllllllllllllllllIIlIIllIlIIllII, final String[] lllllllllllllllllIIlIIllIlIIlIll, int lllllllllllllllllIIlIIllIlIIlIlI, final MinecraftServer lllllllllllllllllIIlIIllIIllllll) throws CommandException {
        final String lllllllllllllllllIIlIIllIlIIlIII = lllllllllllllllllIIlIIllIlIIlIll[lllllllllllllllllIIlIIllIlIIlIlI++];
        final String lllllllllllllllllIIlIIllIlIIIlll = lllllllllllllllllIIlIIllIlIIlIll[lllllllllllllllllIIlIIllIlIIlIlI++];
        final Scoreboard lllllllllllllllllIIlIIllIlIIIllI = this.getScoreboard(lllllllllllllllllIIlIIllIIllllll);
        final IScoreCriteria lllllllllllllllllIIlIIllIlIIIlIl = IScoreCriteria.INSTANCES.get(lllllllllllllllllIIlIIllIlIIIlll);
        if (lllllllllllllllllIIlIIllIlIIIlIl == null) {
            throw new WrongUsageException("commands.scoreboard.objectives.add.wrongType", new Object[] { lllllllllllllllllIIlIIllIlIIIlll });
        }
        if (lllllllllllllllllIIlIIllIlIIIllI.getObjective(lllllllllllllllllIIlIIllIlIIlIII) != null) {
            throw new CommandException("commands.scoreboard.objectives.add.alreadyExists", new Object[] { lllllllllllllllllIIlIIllIlIIlIII });
        }
        if (lllllllllllllllllIIlIIllIlIIlIII.length() > 16) {
            throw new SyntaxErrorException("commands.scoreboard.objectives.add.tooLong", new Object[] { lllllllllllllllllIIlIIllIlIIlIII, 16 });
        }
        if (lllllllllllllllllIIlIIllIlIIlIII.isEmpty()) {
            throw new WrongUsageException("commands.scoreboard.objectives.add.usage", new Object[0]);
        }
        if (lllllllllllllllllIIlIIllIlIIlIll.length > lllllllllllllllllIIlIIllIlIIlIlI) {
            final String lllllllllllllllllIIlIIllIlIIIlII = CommandBase.getChatComponentFromNthArg(lllllllllllllllllIIlIIllIlIIllII, lllllllllllllllllIIlIIllIlIIlIll, lllllllllllllllllIIlIIllIlIIlIlI).getUnformattedText();
            if (lllllllllllllllllIIlIIllIlIIIlII.length() > 32) {
                throw new SyntaxErrorException("commands.scoreboard.objectives.add.displayTooLong", new Object[] { lllllllllllllllllIIlIIllIlIIIlII, 32 });
            }
            if (lllllllllllllllllIIlIIllIlIIIlII.isEmpty()) {
                lllllllllllllllllIIlIIllIlIIIllI.addScoreObjective(lllllllllllllllllIIlIIllIlIIlIII, lllllllllllllllllIIlIIllIlIIIlIl);
            }
            else {
                lllllllllllllllllIIlIIllIlIIIllI.addScoreObjective(lllllllllllllllllIIlIIllIlIIlIII, lllllllllllllllllIIlIIllIlIIIlIl).setDisplayName(lllllllllllllllllIIlIIllIlIIIlII);
            }
        }
        else {
            lllllllllllllllllIIlIIllIlIIIllI.addScoreObjective(lllllllllllllllllIIlIIllIlIIlIII, lllllllllllllllllIIlIIllIlIIIlIl);
        }
        CommandBase.notifyCommandListener(lllllllllllllllllIIlIIllIlIIllII, this, "commands.scoreboard.objectives.add.success", lllllllllllllllllIIlIIllIlIIlIII);
    }
    
    protected void addTeam(final ICommandSender lllllllllllllllllIIlIIllIIllIIII, final String[] lllllllllllllllllIIlIIllIIlIllll, int lllllllllllllllllIIlIIllIIlIIllI, final MinecraftServer lllllllllllllllllIIlIIllIIlIIlIl) throws CommandException {
        final String lllllllllllllllllIIlIIllIIlIllII = lllllllllllllllllIIlIIllIIlIllll[lllllllllllllllllIIlIIllIIlIIllI++];
        final Scoreboard lllllllllllllllllIIlIIllIIlIlIll = this.getScoreboard(lllllllllllllllllIIlIIllIIlIIlIl);
        if (lllllllllllllllllIIlIIllIIlIlIll.getTeam(lllllllllllllllllIIlIIllIIlIllII) != null) {
            throw new CommandException("commands.scoreboard.teams.add.alreadyExists", new Object[] { lllllllllllllllllIIlIIllIIlIllII });
        }
        if (lllllllllllllllllIIlIIllIIlIllII.length() > 16) {
            throw new SyntaxErrorException("commands.scoreboard.teams.add.tooLong", new Object[] { lllllllllllllllllIIlIIllIIlIllII, 16 });
        }
        if (lllllllllllllllllIIlIIllIIlIllII.isEmpty()) {
            throw new WrongUsageException("commands.scoreboard.teams.add.usage", new Object[0]);
        }
        if (lllllllllllllllllIIlIIllIIlIllll.length > lllllllllllllllllIIlIIllIIlIIllI) {
            final String lllllllllllllllllIIlIIllIIlIlIlI = CommandBase.getChatComponentFromNthArg(lllllllllllllllllIIlIIllIIllIIII, lllllllllllllllllIIlIIllIIlIllll, lllllllllllllllllIIlIIllIIlIIllI).getUnformattedText();
            if (lllllllllllllllllIIlIIllIIlIlIlI.length() > 32) {
                throw new SyntaxErrorException("commands.scoreboard.teams.add.displayTooLong", new Object[] { lllllllllllllllllIIlIIllIIlIlIlI, 32 });
            }
            if (lllllllllllllllllIIlIIllIIlIlIlI.isEmpty()) {
                lllllllllllllllllIIlIIllIIlIlIll.createTeam(lllllllllllllllllIIlIIllIIlIllII);
            }
            else {
                lllllllllllllllllIIlIIllIIlIlIll.createTeam(lllllllllllllllllIIlIIllIIlIllII).setTeamName(lllllllllllllllllIIlIIllIIlIlIlI);
            }
        }
        else {
            lllllllllllllllllIIlIIllIIlIlIll.createTeam(lllllllllllllllllIIlIIllIIlIllII);
        }
        CommandBase.notifyCommandListener(lllllllllllllllllIIlIIllIIllIIII, this, "commands.scoreboard.teams.add.success", lllllllllllllllllIIlIIllIIlIllII);
    }
    
    private boolean handleUserWildcards(final MinecraftServer lllllllllllllllllIIlIIlllIIlIIll, final ICommandSender lllllllllllllllllIIlIIlllIIlIIlI, final String[] lllllllllllllllllIIlIIlllIIIIlIl) throws CommandException {
        int lllllllllllllllllIIlIIlllIIlIIII = -1;
        for (int lllllllllllllllllIIlIIlllIIIllll = 0; lllllllllllllllllIIlIIlllIIIllll < lllllllllllllllllIIlIIlllIIIIlIl.length; ++lllllllllllllllllIIlIIlllIIIllll) {
            if (this.isUsernameIndex(lllllllllllllllllIIlIIlllIIIIlIl, lllllllllllllllllIIlIIlllIIIllll) && "*".equals(lllllllllllllllllIIlIIlllIIIIlIl[lllllllllllllllllIIlIIlllIIIllll])) {
                if (lllllllllllllllllIIlIIlllIIlIIII >= 0) {
                    throw new CommandException("commands.scoreboard.noMultiWildcard", new Object[0]);
                }
                lllllllllllllllllIIlIIlllIIlIIII = lllllllllllllllllIIlIIlllIIIllll;
            }
        }
        if (lllllllllllllllllIIlIIlllIIlIIII < 0) {
            return false;
        }
        final List<String> lllllllllllllllllIIlIIlllIIIlllI = (List<String>)Lists.newArrayList((Iterable)this.getScoreboard(lllllllllllllllllIIlIIlllIIlIIll).getObjectiveNames());
        final String lllllllllllllllllIIlIIlllIIIllIl = lllllllllllllllllIIlIIlllIIIIlIl[lllllllllllllllllIIlIIlllIIlIIII];
        final List<String> lllllllllllllllllIIlIIlllIIIllII = (List<String>)Lists.newArrayList();
        for (final String lllllllllllllllllIIlIIlllIIIlIll : lllllllllllllllllIIlIIlllIIIlllI) {
            lllllllllllllllllIIlIIlllIIIIlIl[lllllllllllllllllIIlIIlllIIlIIII] = lllllllllllllllllIIlIIlllIIIlIll;
            try {
                this.execute(lllllllllllllllllIIlIIlllIIlIIll, lllllllllllllllllIIlIIlllIIlIIlI, lllllllllllllllllIIlIIlllIIIIlIl);
                lllllllllllllllllIIlIIlllIIIllII.add(lllllllllllllllllIIlIIlllIIIlIll);
            }
            catch (CommandException lllllllllllllllllIIlIIlllIIIlIlI) {
                final TextComponentTranslation lllllllllllllllllIIlIIlllIIIlIIl = new TextComponentTranslation(lllllllllllllllllIIlIIlllIIIlIlI.getMessage(), lllllllllllllllllIIlIIlllIIIlIlI.getErrorObjects());
                lllllllllllllllllIIlIIlllIIIlIIl.getStyle().setColor(TextFormatting.RED);
                lllllllllllllllllIIlIIlllIIlIIlI.addChatMessage(lllllllllllllllllIIlIIlllIIIlIIl);
            }
        }
        lllllllllllllllllIIlIIlllIIIIlIl[lllllllllllllllllIIlIIlllIIlIIII] = lllllllllllllllllIIlIIlllIIIllIl;
        lllllllllllllllllIIlIIlllIIlIIlI.setCommandStat(CommandResultStats.Type.AFFECTED_ENTITIES, lllllllllllllllllIIlIIlllIIIllII.size());
        if (lllllllllllllllllIIlIIlllIIIllII.isEmpty()) {
            throw new WrongUsageException("commands.scoreboard.allMatchesFailed", new Object[0]);
        }
        return true;
    }
    
    protected void addPlayerScore(final ICommandSender lllllllllllllllllIIlIIIllllIIIII, final String[] lllllllllllllllllIIlIIIlllIlllll, int lllllllllllllllllIIlIIIlllIllllI, final MinecraftServer lllllllllllllllllIIlIIIlllIlllIl) throws CommandException {
        final String lllllllllllllllllIIlIIIllllIllII = lllllllllllllllllIIlIIIlllIlllll[lllllllllllllllllIIlIIIlllIllllI - 1];
        final int lllllllllllllllllIIlIIIllllIlIll = lllllllllllllllllIIlIIIlllIllllI;
        final String lllllllllllllllllIIlIIIllllIlIlI = CommandBase.getEntityName(lllllllllllllllllIIlIIIlllIlllIl, lllllllllllllllllIIlIIIllllIIIII, lllllllllllllllllIIlIIIlllIlllll[lllllllllllllllllIIlIIIlllIllllI++]);
        if (lllllllllllllllllIIlIIIllllIlIlI.length() > 40) {
            throw new SyntaxErrorException("commands.scoreboard.players.name.tooLong", new Object[] { lllllllllllllllllIIlIIIllllIlIlI, 40 });
        }
        final ScoreObjective lllllllllllllllllIIlIIIllllIlIIl = this.convertToObjective(lllllllllllllllllIIlIIIlllIlllll[lllllllllllllllllIIlIIIlllIllllI++], true, lllllllllllllllllIIlIIIlllIlllIl);
        final int lllllllllllllllllIIlIIIllllIlIII = "set".equalsIgnoreCase(lllllllllllllllllIIlIIIllllIllII) ? CommandBase.parseInt(lllllllllllllllllIIlIIIlllIlllll[lllllllllllllllllIIlIIIlllIllllI++]) : CommandBase.parseInt(lllllllllllllllllIIlIIIlllIlllll[lllllllllllllllllIIlIIIlllIllllI++], 0);
        if (lllllllllllllllllIIlIIIlllIlllll.length > lllllllllllllllllIIlIIIlllIllllI) {
            final Entity lllllllllllllllllIIlIIIllllIIlll = CommandBase.getEntity(lllllllllllllllllIIlIIIlllIlllIl, lllllllllllllllllIIlIIIllllIIIII, lllllllllllllllllIIlIIIlllIlllll[lllllllllllllllllIIlIIIllllIlIll]);
            try {
                final NBTTagCompound lllllllllllllllllIIlIIIllllIIllI = JsonToNBT.getTagFromJson(CommandBase.buildString(lllllllllllllllllIIlIIIlllIlllll, lllllllllllllllllIIlIIIlllIllllI));
                final NBTTagCompound lllllllllllllllllIIlIIIllllIIlIl = CommandBase.entityToNBT(lllllllllllllllllIIlIIIllllIIlll);
                if (!NBTUtil.areNBTEquals(lllllllllllllllllIIlIIIllllIIllI, lllllllllllllllllIIlIIIllllIIlIl, true)) {
                    throw new CommandException("commands.scoreboard.players.set.tagMismatch", new Object[] { lllllllllllllllllIIlIIIllllIlIlI });
                }
            }
            catch (NBTException lllllllllllllllllIIlIIIllllIIlII) {
                throw new CommandException("commands.scoreboard.players.set.tagError", new Object[] { lllllllllllllllllIIlIIIllllIIlII.getMessage() });
            }
        }
        final Scoreboard lllllllllllllllllIIlIIIllllIIIll = this.getScoreboard(lllllllllllllllllIIlIIIlllIlllIl);
        final Score lllllllllllllllllIIlIIIllllIIIlI = lllllllllllllllllIIlIIIllllIIIll.getOrCreateScore(lllllllllllllllllIIlIIIllllIlIlI, lllllllllllllllllIIlIIIllllIlIIl);
        if ("set".equalsIgnoreCase(lllllllllllllllllIIlIIIllllIllII)) {
            lllllllllllllllllIIlIIIllllIIIlI.setScorePoints(lllllllllllllllllIIlIIIllllIlIII);
        }
        else if ("add".equalsIgnoreCase(lllllllllllllllllIIlIIIllllIllII)) {
            lllllllllllllllllIIlIIIllllIIIlI.increaseScore(lllllllllllllllllIIlIIIllllIlIII);
        }
        else {
            lllllllllllllllllIIlIIIllllIIIlI.decreaseScore(lllllllllllllllllIIlIIIllllIlIII);
        }
        CommandBase.notifyCommandListener(lllllllllllllllllIIlIIIllllIIIII, this, "commands.scoreboard.players.set.success", lllllllllllllllllIIlIIIllllIlIIl.getName(), lllllllllllllllllIIlIIIllllIlIlI, lllllllllllllllllIIlIIIllllIIIlI.getScorePoints());
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllllIIlIIlllIlIllIl) {
        return "commands.scoreboard.usage";
    }
    
    protected List<String> getObjectiveNames(final boolean lllllllllllllllllIIlIIIlIIIllIlI, final MinecraftServer lllllllllllllllllIIlIIIlIIIllIIl) {
        final Collection<ScoreObjective> lllllllllllllllllIIlIIIlIIIllIII = this.getScoreboard(lllllllllllllllllIIlIIIlIIIllIIl).getScoreObjectives();
        final List<String> lllllllllllllllllIIlIIIlIIIlIlll = (List<String>)Lists.newArrayList();
        for (final ScoreObjective lllllllllllllllllIIlIIIlIIIlIllI : lllllllllllllllllIIlIIIlIIIllIII) {
            if (!lllllllllllllllllIIlIIIlIIIllIlI || !lllllllllllllllllIIlIIIlIIIlIllI.getCriteria().isReadOnly()) {
                lllllllllllllllllIIlIIIlIIIlIlll.add(lllllllllllllllllIIlIIIlIIIlIllI.getName());
            }
        }
        return lllllllllllllllllIIlIIIlIIIlIlll;
    }
    
    protected void leaveTeam(final ICommandSender lllllllllllllllllIIlIIlIlIIIllII, final String[] lllllllllllllllllIIlIIlIlIIllIII, int lllllllllllllllllIIlIIlIlIIIlIlI, final MinecraftServer lllllllllllllllllIIlIIlIlIIIlIIl) throws CommandException {
        final Scoreboard lllllllllllllllllIIlIIlIlIIlIlIl = this.getScoreboard(lllllllllllllllllIIlIIlIlIIIlIIl);
        final Set<String> lllllllllllllllllIIlIIlIlIIlIlII = (Set<String>)Sets.newHashSet();
        final Set<String> lllllllllllllllllIIlIIlIlIIlIIll = (Set<String>)Sets.newHashSet();
        if (lllllllllllllllllIIlIIlIlIIIllII instanceof EntityPlayer && lllllllllllllllllIIlIIlIlIIIlIlI == lllllllllllllllllIIlIIlIlIIllIII.length) {
            final String lllllllllllllllllIIlIIlIlIIlIIlI = CommandBase.getCommandSenderAsPlayer(lllllllllllllllllIIlIIlIlIIIllII).getName();
            if (lllllllllllllllllIIlIIlIlIIlIlIl.removePlayerFromTeams(lllllllllllllllllIIlIIlIlIIlIIlI)) {
                lllllllllllllllllIIlIIlIlIIlIlII.add(lllllllllllllllllIIlIIlIlIIlIIlI);
            }
            else {
                lllllllllllllllllIIlIIlIlIIlIIll.add(lllllllllllllllllIIlIIlIlIIlIIlI);
            }
        }
        else {
            while (lllllllllllllllllIIlIIlIlIIIlIlI < lllllllllllllllllIIlIIlIlIIllIII.length) {
                final String lllllllllllllllllIIlIIlIlIIlIIIl = lllllllllllllllllIIlIIlIlIIllIII[lllllllllllllllllIIlIIlIlIIIlIlI++];
                if (EntitySelector.hasArguments(lllllllllllllllllIIlIIlIlIIlIIIl)) {
                    for (final Entity lllllllllllllllllIIlIIlIlIIlIIII : CommandBase.getEntityList(lllllllllllllllllIIlIIlIlIIIlIIl, lllllllllllllllllIIlIIlIlIIIllII, lllllllllllllllllIIlIIlIlIIlIIIl)) {
                        final String lllllllllllllllllIIlIIlIlIIIllll = CommandBase.getEntityName(lllllllllllllllllIIlIIlIlIIIlIIl, lllllllllllllllllIIlIIlIlIIIllII, lllllllllllllllllIIlIIlIlIIlIIII.getCachedUniqueIdString());
                        if (lllllllllllllllllIIlIIlIlIIlIlIl.removePlayerFromTeams(lllllllllllllllllIIlIIlIlIIIllll)) {
                            lllllllllllllllllIIlIIlIlIIlIlII.add(lllllllllllllllllIIlIIlIlIIIllll);
                        }
                        else {
                            lllllllllllllllllIIlIIlIlIIlIIll.add(lllllllllllllllllIIlIIlIlIIIllll);
                        }
                    }
                }
                else {
                    final String lllllllllllllllllIIlIIlIlIIIlllI = CommandBase.getEntityName(lllllllllllllllllIIlIIlIlIIIlIIl, lllllllllllllllllIIlIIlIlIIIllII, lllllllllllllllllIIlIIlIlIIlIIIl);
                    if (lllllllllllllllllIIlIIlIlIIlIlIl.removePlayerFromTeams(lllllllllllllllllIIlIIlIlIIIlllI)) {
                        lllllllllllllllllIIlIIlIlIIlIlII.add(lllllllllllllllllIIlIIlIlIIIlllI);
                    }
                    else {
                        lllllllllllllllllIIlIIlIlIIlIIll.add(lllllllllllllllllIIlIIlIlIIIlllI);
                    }
                }
            }
        }
        if (!lllllllllllllllllIIlIIlIlIIlIlII.isEmpty()) {
            lllllllllllllllllIIlIIlIlIIIllII.setCommandStat(CommandResultStats.Type.AFFECTED_ENTITIES, lllllllllllllllllIIlIIlIlIIlIlII.size());
            CommandBase.notifyCommandListener(lllllllllllllllllIIlIIlIlIIIllII, this, "commands.scoreboard.teams.leave.success", lllllllllllllllllIIlIIlIlIIlIlII.size(), CommandBase.joinNiceString(lllllllllllllllllIIlIIlIlIIlIlII.toArray(new String[lllllllllllllllllIIlIIlIlIIlIlII.size()])));
        }
        if (!lllllllllllllllllIIlIIlIlIIlIIll.isEmpty()) {
            throw new CommandException("commands.scoreboard.teams.leave.failure", new Object[] { lllllllllllllllllIIlIIlIlIIlIIll.size(), CommandBase.joinNiceString(lllllllllllllllllIIlIIlIlIIlIIll.toArray(new String[lllllllllllllllllIIlIIlIlIIlIIll.size()])) });
        }
    }
    
    protected void setTeamOption(final ICommandSender lllllllllllllllllIIlIIllIIIIlIll, final String[] lllllllllllllllllIIlIIllIIIlIllI, int lllllllllllllllllIIlIIllIIIIlIIl, final MinecraftServer lllllllllllllllllIIlIIllIIIIlIII) throws CommandException {
        final ScorePlayerTeam lllllllllllllllllIIlIIllIIIlIIll = this.convertToTeam(lllllllllllllllllIIlIIllIIIlIllI[lllllllllllllllllIIlIIllIIIIlIIl++], lllllllllllllllllIIlIIllIIIIlIII);
        if (lllllllllllllllllIIlIIllIIIlIIll != null) {
            final String lllllllllllllllllIIlIIllIIIlIIlI = lllllllllllllllllIIlIIllIIIlIllI[lllllllllllllllllIIlIIllIIIIlIIl++].toLowerCase(Locale.ROOT);
            if (!"color".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIlI) && !"friendlyfire".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIlI) && !"seeFriendlyInvisibles".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIlI) && !"nametagVisibility".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIlI) && !"deathMessageVisibility".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIlI) && !"collisionRule".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIlI)) {
                throw new WrongUsageException("commands.scoreboard.teams.option.usage", new Object[0]);
            }
            if (lllllllllllllllllIIlIIllIIIlIllI.length == 4) {
                if ("color".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIlI)) {
                    throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { lllllllllllllllllIIlIIllIIIlIIlI, CommandBase.joinNiceStringFromCollection(TextFormatting.getValidValues(true, false)) });
                }
                if ("friendlyfire".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIlI) || "seeFriendlyInvisibles".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIlI)) {
                    throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { lllllllllllllllllIIlIIllIIIlIIlI, CommandBase.joinNiceStringFromCollection(Arrays.asList("true", "false")) });
                }
                if ("nametagVisibility".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIlI) || "deathMessageVisibility".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIlI)) {
                    throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { lllllllllllllllllIIlIIllIIIlIIlI, CommandBase.joinNiceString(Team.EnumVisible.getNames()) });
                }
                if ("collisionRule".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIlI)) {
                    throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { lllllllllllllllllIIlIIllIIIlIIlI, CommandBase.joinNiceString(Team.CollisionRule.getNames()) });
                }
                throw new WrongUsageException("commands.scoreboard.teams.option.usage", new Object[0]);
            }
            else {
                final String lllllllllllllllllIIlIIllIIIlIIIl = lllllllllllllllllIIlIIllIIIlIllI[lllllllllllllllllIIlIIllIIIIlIIl];
                if ("color".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIlI)) {
                    final TextFormatting lllllllllllllllllIIlIIllIIIlIIII = TextFormatting.getValueByName(lllllllllllllllllIIlIIllIIIlIIIl);
                    if (lllllllllllllllllIIlIIllIIIlIIII == null || lllllllllllllllllIIlIIllIIIlIIII.isFancyStyling()) {
                        throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { lllllllllllllllllIIlIIllIIIlIIlI, CommandBase.joinNiceStringFromCollection(TextFormatting.getValidValues(true, false)) });
                    }
                    lllllllllllllllllIIlIIllIIIlIIll.setChatFormat(lllllllllllllllllIIlIIllIIIlIIII);
                    lllllllllllllllllIIlIIllIIIlIIll.setNamePrefix(lllllllllllllllllIIlIIllIIIlIIII.toString());
                    lllllllllllllllllIIlIIllIIIlIIll.setNameSuffix(TextFormatting.RESET.toString());
                }
                else if ("friendlyfire".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIlI)) {
                    if (!"true".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIIl) && !"false".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIIl)) {
                        throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { lllllllllllllllllIIlIIllIIIlIIlI, CommandBase.joinNiceStringFromCollection(Arrays.asList("true", "false")) });
                    }
                    lllllllllllllllllIIlIIllIIIlIIll.setAllowFriendlyFire("true".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIIl));
                }
                else if ("seeFriendlyInvisibles".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIlI)) {
                    if (!"true".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIIl) && !"false".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIIl)) {
                        throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { lllllllllllllllllIIlIIllIIIlIIlI, CommandBase.joinNiceStringFromCollection(Arrays.asList("true", "false")) });
                    }
                    lllllllllllllllllIIlIIllIIIlIIll.setSeeFriendlyInvisiblesEnabled("true".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIIl));
                }
                else if ("nametagVisibility".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIlI)) {
                    final Team.EnumVisible lllllllllllllllllIIlIIllIIIIllll = Team.EnumVisible.getByName(lllllllllllllllllIIlIIllIIIlIIIl);
                    if (lllllllllllllllllIIlIIllIIIIllll == null) {
                        throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { lllllllllllllllllIIlIIllIIIlIIlI, CommandBase.joinNiceString(Team.EnumVisible.getNames()) });
                    }
                    lllllllllllllllllIIlIIllIIIlIIll.setNameTagVisibility(lllllllllllllllllIIlIIllIIIIllll);
                }
                else if ("deathMessageVisibility".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIlI)) {
                    final Team.EnumVisible lllllllllllllllllIIlIIllIIIIlllI = Team.EnumVisible.getByName(lllllllllllllllllIIlIIllIIIlIIIl);
                    if (lllllllllllllllllIIlIIllIIIIlllI == null) {
                        throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { lllllllllllllllllIIlIIllIIIlIIlI, CommandBase.joinNiceString(Team.EnumVisible.getNames()) });
                    }
                    lllllllllllllllllIIlIIllIIIlIIll.setDeathMessageVisibility(lllllllllllllllllIIlIIllIIIIlllI);
                }
                else if ("collisionRule".equalsIgnoreCase(lllllllllllllllllIIlIIllIIIlIIlI)) {
                    final Team.CollisionRule lllllllllllllllllIIlIIllIIIIllIl = Team.CollisionRule.getByName(lllllllllllllllllIIlIIllIIIlIIIl);
                    if (lllllllllllllllllIIlIIllIIIIllIl == null) {
                        throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { lllllllllllllllllIIlIIllIIIlIIlI, CommandBase.joinNiceString(Team.CollisionRule.getNames()) });
                    }
                    lllllllllllllllllIIlIIllIIIlIIll.setCollisionRule(lllllllllllllllllIIlIIllIIIIllIl);
                }
                CommandBase.notifyCommandListener(lllllllllllllllllIIlIIllIIIIlIll, this, "commands.scoreboard.teams.option.success", lllllllllllllllllIIlIIllIIIlIIlI, lllllllllllllllllIIlIIllIIIlIIll.getRegisteredName(), lllllllllllllllllIIlIIllIIIlIIIl);
            }
        }
    }
    
    protected void removeTeam(final ICommandSender lllllllllllllllllIIlIIlIllllIlII, final String[] lllllllllllllllllIIlIIlIlllllIlI, final int lllllllllllllllllIIlIIlIllllIIlI, final MinecraftServer lllllllllllllllllIIlIIlIllllIIIl) throws CommandException {
        final Scoreboard lllllllllllllllllIIlIIlIllllIlll = this.getScoreboard(lllllllllllllllllIIlIIlIllllIIIl);
        final ScorePlayerTeam lllllllllllllllllIIlIIlIllllIllI = this.convertToTeam(lllllllllllllllllIIlIIlIlllllIlI[lllllllllllllllllIIlIIlIllllIIlI], lllllllllllllllllIIlIIlIllllIIIl);
        if (lllllllllllllllllIIlIIlIllllIllI != null) {
            lllllllllllllllllIIlIIlIllllIlll.removeTeam(lllllllllllllllllIIlIIlIllllIllI);
            CommandBase.notifyCommandListener(lllllllllllllllllIIlIIlIllllIlII, this, "commands.scoreboard.teams.remove.success", lllllllllllllllllIIlIIlIllllIllI.getRegisteredName());
        }
    }
    
    protected void listTeams(final ICommandSender lllllllllllllllllIIlIIlIllIlIlll, final String[] lllllllllllllllllIIlIIlIllIlIllI, final int lllllllllllllllllIIlIIlIllIlIlIl, final MinecraftServer lllllllllllllllllIIlIIlIllIlIlII) throws CommandException {
        final Scoreboard lllllllllllllllllIIlIIlIllIlllll = this.getScoreboard(lllllllllllllllllIIlIIlIllIlIlII);
        if (lllllllllllllllllIIlIIlIllIlIllI.length > lllllllllllllllllIIlIIlIllIlIlIl) {
            final ScorePlayerTeam lllllllllllllllllIIlIIlIllIllllI = this.convertToTeam(lllllllllllllllllIIlIIlIllIlIllI[lllllllllllllllllIIlIIlIllIlIlIl], lllllllllllllllllIIlIIlIllIlIlII);
            if (lllllllllllllllllIIlIIlIllIllllI == null) {
                return;
            }
            final Collection<String> lllllllllllllllllIIlIIlIllIlllIl = lllllllllllllllllIIlIIlIllIllllI.getMembershipCollection();
            lllllllllllllllllIIlIIlIllIlIlll.setCommandStat(CommandResultStats.Type.QUERY_RESULT, lllllllllllllllllIIlIIlIllIlllIl.size());
            if (lllllllllllllllllIIlIIlIllIlllIl.isEmpty()) {
                throw new CommandException("commands.scoreboard.teams.list.player.empty", new Object[] { lllllllllllllllllIIlIIlIllIllllI.getRegisteredName() });
            }
            final TextComponentTranslation lllllllllllllllllIIlIIlIllIlllII = new TextComponentTranslation("commands.scoreboard.teams.list.player.count", new Object[] { lllllllllllllllllIIlIIlIllIlllIl.size(), lllllllllllllllllIIlIIlIllIllllI.getRegisteredName() });
            lllllllllllllllllIIlIIlIllIlllII.getStyle().setColor(TextFormatting.DARK_GREEN);
            lllllllllllllllllIIlIIlIllIlIlll.addChatMessage(lllllllllllllllllIIlIIlIllIlllII);
            lllllllllllllllllIIlIIlIllIlIlll.addChatMessage(new TextComponentString(CommandBase.joinNiceString(lllllllllllllllllIIlIIlIllIlllIl.toArray())));
        }
        else {
            final Collection<ScorePlayerTeam> lllllllllllllllllIIlIIlIllIllIll = lllllllllllllllllIIlIIlIllIlllll.getTeams();
            lllllllllllllllllIIlIIlIllIlIlll.setCommandStat(CommandResultStats.Type.QUERY_RESULT, lllllllllllllllllIIlIIlIllIllIll.size());
            if (lllllllllllllllllIIlIIlIllIllIll.isEmpty()) {
                throw new CommandException("commands.scoreboard.teams.list.empty", new Object[0]);
            }
            final TextComponentTranslation lllllllllllllllllIIlIIlIllIllIlI = new TextComponentTranslation("commands.scoreboard.teams.list.count", new Object[] { lllllllllllllllllIIlIIlIllIllIll.size() });
            lllllllllllllllllIIlIIlIllIllIlI.getStyle().setColor(TextFormatting.DARK_GREEN);
            lllllllllllllllllIIlIIlIllIlIlll.addChatMessage(lllllllllllllllllIIlIIlIllIllIlI);
            for (final ScorePlayerTeam lllllllllllllllllIIlIIlIllIllIIl : lllllllllllllllllIIlIIlIllIllIll) {
                lllllllllllllllllIIlIIlIllIlIlll.addChatMessage(new TextComponentTranslation("commands.scoreboard.teams.list.entry", new Object[] { lllllllllllllllllIIlIIlIllIllIIl.getRegisteredName(), lllllllllllllllllIIlIIlIllIllIIl.getTeamName(), lllllllllllllllllIIlIIlIllIllIIl.getMembershipCollection().size() }));
            }
        }
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllllllIIlIIIlIIlIIlIl, final ICommandSender lllllllllllllllllIIlIIIlIIlIlIlI, final String[] lllllllllllllllllIIlIIIlIIlIIlII, @Nullable final BlockPos lllllllllllllllllIIlIIIlIIlIlIII) {
        if (lllllllllllllllllIIlIIIlIIlIIlII.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, "objectives", "players", "teams");
        }
        if ("objectives".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[0])) {
            if (lllllllllllllllllIIlIIIlIIlIIlII.length == 2) {
                return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, "list", "add", "remove", "setdisplay");
            }
            if ("add".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[1])) {
                if (lllllllllllllllllIIlIIIlIIlIIlII.length == 4) {
                    final Set<String> lllllllllllllllllIIlIIIlIIlIIlll = IScoreCriteria.INSTANCES.keySet();
                    return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, lllllllllllllllllIIlIIIlIIlIIlll);
                }
            }
            else if ("remove".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[1])) {
                if (lllllllllllllllllIIlIIIlIIlIIlII.length == 3) {
                    return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, this.getObjectiveNames(false, lllllllllllllllllIIlIIIlIIlIIlIl));
                }
            }
            else if ("setdisplay".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[1])) {
                if (lllllllllllllllllIIlIIIlIIlIIlII.length == 3) {
                    return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, Scoreboard.getDisplaySlotStrings());
                }
                if (lllllllllllllllllIIlIIIlIIlIIlII.length == 4) {
                    return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, this.getObjectiveNames(false, lllllllllllllllllIIlIIIlIIlIIlIl));
                }
            }
        }
        else if ("players".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[0])) {
            if (lllllllllllllllllIIlIIIlIIlIIlII.length == 2) {
                return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, "set", "add", "remove", "reset", "list", "enable", "test", "operation", "tag");
            }
            if (!"set".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[1]) && !"add".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[1]) && !"remove".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[1]) && !"reset".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[1])) {
                if ("enable".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[1])) {
                    if (lllllllllllllllllIIlIIIlIIlIIlII.length == 3) {
                        return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, lllllllllllllllllIIlIIIlIIlIIlIl.getAllUsernames());
                    }
                    if (lllllllllllllllllIIlIIIlIIlIIlII.length == 4) {
                        return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, this.getTriggerNames(lllllllllllllllllIIlIIIlIIlIIlIl));
                    }
                }
                else if (!"list".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[1]) && !"test".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[1])) {
                    if ("operation".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[1])) {
                        if (lllllllllllllllllIIlIIIlIIlIIlII.length == 3) {
                            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, this.getScoreboard(lllllllllllllllllIIlIIIlIIlIIlIl).getObjectiveNames());
                        }
                        if (lllllllllllllllllIIlIIIlIIlIIlII.length == 4) {
                            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, this.getObjectiveNames(true, lllllllllllllllllIIlIIIlIIlIIlIl));
                        }
                        if (lllllllllllllllllIIlIIIlIIlIIlII.length == 5) {
                            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, "+=", "-=", "*=", "/=", "%=", "=", "<", ">", "><");
                        }
                        if (lllllllllllllllllIIlIIIlIIlIIlII.length == 6) {
                            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, lllllllllllllllllIIlIIIlIIlIIlIl.getAllUsernames());
                        }
                        if (lllllllllllllllllIIlIIIlIIlIIlII.length == 7) {
                            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, this.getObjectiveNames(false, lllllllllllllllllIIlIIIlIIlIIlIl));
                        }
                    }
                    else if ("tag".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[1])) {
                        if (lllllllllllllllllIIlIIIlIIlIIlII.length == 3) {
                            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, this.getScoreboard(lllllllllllllllllIIlIIIlIIlIIlIl).getObjectiveNames());
                        }
                        if (lllllllllllllllllIIlIIIlIIlIIlII.length == 4) {
                            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, "add", "remove", "list");
                        }
                    }
                }
                else {
                    if (lllllllllllllllllIIlIIIlIIlIIlII.length == 3) {
                        return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, this.getScoreboard(lllllllllllllllllIIlIIIlIIlIIlIl).getObjectiveNames());
                    }
                    if (lllllllllllllllllIIlIIIlIIlIIlII.length == 4 && "test".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[1])) {
                        return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, this.getObjectiveNames(false, lllllllllllllllllIIlIIIlIIlIIlIl));
                    }
                }
            }
            else {
                if (lllllllllllllllllIIlIIIlIIlIIlII.length == 3) {
                    return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, lllllllllllllllllIIlIIIlIIlIIlIl.getAllUsernames());
                }
                if (lllllllllllllllllIIlIIIlIIlIIlII.length == 4) {
                    return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, this.getObjectiveNames(true, lllllllllllllllllIIlIIIlIIlIIlIl));
                }
            }
        }
        else if ("teams".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[0])) {
            if (lllllllllllllllllIIlIIIlIIlIIlII.length == 2) {
                return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, "add", "remove", "join", "leave", "empty", "list", "option");
            }
            if ("join".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[1])) {
                if (lllllllllllllllllIIlIIIlIIlIIlII.length == 3) {
                    return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, this.getScoreboard(lllllllllllllllllIIlIIIlIIlIIlIl).getTeamNames());
                }
                if (lllllllllllllllllIIlIIIlIIlIIlII.length >= 4) {
                    return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, lllllllllllllllllIIlIIIlIIlIIlIl.getAllUsernames());
                }
            }
            else {
                if ("leave".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[1])) {
                    return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, lllllllllllllllllIIlIIIlIIlIIlIl.getAllUsernames());
                }
                if (!"empty".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[1]) && !"list".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[1]) && !"remove".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[1])) {
                    if ("option".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[1])) {
                        if (lllllllllllllllllIIlIIIlIIlIIlII.length == 3) {
                            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, this.getScoreboard(lllllllllllllllllIIlIIIlIIlIIlIl).getTeamNames());
                        }
                        if (lllllllllllllllllIIlIIIlIIlIIlII.length == 4) {
                            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, "color", "friendlyfire", "seeFriendlyInvisibles", "nametagVisibility", "deathMessageVisibility", "collisionRule");
                        }
                        if (lllllllllllllllllIIlIIIlIIlIIlII.length == 5) {
                            if ("color".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[3])) {
                                return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, TextFormatting.getValidValues(true, false));
                            }
                            if ("nametagVisibility".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[3]) || "deathMessageVisibility".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[3])) {
                                return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, Team.EnumVisible.getNames());
                            }
                            if ("collisionRule".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[3])) {
                                return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, Team.CollisionRule.getNames());
                            }
                            if ("friendlyfire".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[3]) || "seeFriendlyInvisibles".equalsIgnoreCase(lllllllllllllllllIIlIIIlIIlIIlII[3])) {
                                return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, "true", "false");
                            }
                        }
                    }
                }
                else if (lllllllllllllllllIIlIIIlIIlIIlII.length == 3) {
                    return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIIlIIIlIIlIIlII, this.getScoreboard(lllllllllllllllllIIlIIIlIIlIIlIl).getTeamNames());
                }
            }
        }
        return Collections.emptyList();
    }
    
    protected void listObjectives(final ICommandSender lllllllllllllllllIIlIIlIIlIIIIlI, final MinecraftServer lllllllllllllllllIIlIIlIIlIIlIII) throws CommandException {
        final Scoreboard lllllllllllllllllIIlIIlIIlIIIlll = this.getScoreboard(lllllllllllllllllIIlIIlIIlIIlIII);
        final Collection<ScoreObjective> lllllllllllllllllIIlIIlIIlIIIllI = lllllllllllllllllIIlIIlIIlIIIlll.getScoreObjectives();
        if (lllllllllllllllllIIlIIlIIlIIIllI.isEmpty()) {
            throw new CommandException("commands.scoreboard.objectives.list.empty", new Object[0]);
        }
        final TextComponentTranslation lllllllllllllllllIIlIIlIIlIIIlIl = new TextComponentTranslation("commands.scoreboard.objectives.list.count", new Object[] { lllllllllllllllllIIlIIlIIlIIIllI.size() });
        lllllllllllllllllIIlIIlIIlIIIlIl.getStyle().setColor(TextFormatting.DARK_GREEN);
        lllllllllllllllllIIlIIlIIlIIIIlI.addChatMessage(lllllllllllllllllIIlIIlIIlIIIlIl);
        for (final ScoreObjective lllllllllllllllllIIlIIlIIlIIIlII : lllllllllllllllllIIlIIlIIlIIIllI) {
            lllllllllllllllllIIlIIlIIlIIIIlI.addChatMessage(new TextComponentTranslation("commands.scoreboard.objectives.list.entry", new Object[] { lllllllllllllllllIIlIIlIIlIIIlII.getName(), lllllllllllllllllIIlIIlIIlIIIlII.getDisplayName(), lllllllllllllllllIIlIIlIIlIIIlII.getCriteria().getName() }));
        }
    }
    
    protected ScorePlayerTeam convertToTeam(final String lllllllllllllllllIIlIIllIlIllIll, final MinecraftServer lllllllllllllllllIIlIIllIlIllIlI) throws CommandException {
        final Scoreboard lllllllllllllllllIIlIIllIlIllllI = this.getScoreboard(lllllllllllllllllIIlIIllIlIllIlI);
        final ScorePlayerTeam lllllllllllllllllIIlIIllIlIlllIl = lllllllllllllllllIIlIIllIlIllllI.getTeam(lllllllllllllllllIIlIIllIlIllIll);
        if (lllllllllllllllllIIlIIllIlIlllIl == null) {
            throw new CommandException("commands.scoreboard.teamNotFound", new Object[] { lllllllllllllllllIIlIIllIlIllIll });
        }
        return lllllllllllllllllIIlIIllIlIlllIl;
    }
    
    protected void applyPlayerTag(final MinecraftServer lllllllllllllllllIIlIIIlIIlllIll, final ICommandSender lllllllllllllllllIIlIIIlIIlllIlI, final String[] lllllllllllllllllIIlIIIlIlIIIlll, int lllllllllllllllllIIlIIIlIIlllIII) throws CommandException {
        final String lllllllllllllllllIIlIIIlIlIIIlIl = CommandBase.getEntityName(lllllllllllllllllIIlIIIlIIlllIll, lllllllllllllllllIIlIIIlIIlllIlI, lllllllllllllllllIIlIIIlIlIIIlll[lllllllllllllllllIIlIIIlIIlllIII]);
        final Entity lllllllllllllllllIIlIIIlIlIIIlII = CommandBase.getEntity(lllllllllllllllllIIlIIIlIIlllIll, lllllllllllllllllIIlIIIlIIlllIlI, lllllllllllllllllIIlIIIlIlIIIlll[lllllllllllllllllIIlIIIlIIlllIII++]);
        final String lllllllllllllllllIIlIIIlIlIIIIll = lllllllllllllllllIIlIIIlIlIIIlll[lllllllllllllllllIIlIIIlIIlllIII++];
        final Set<String> lllllllllllllllllIIlIIIlIlIIIIlI = lllllllllllllllllIIlIIIlIlIIIlII.getTags();
        if ("list".equals(lllllllllllllllllIIlIIIlIlIIIIll)) {
            if (!lllllllllllllllllIIlIIIlIlIIIIlI.isEmpty()) {
                final TextComponentTranslation lllllllllllllllllIIlIIIlIlIIIIIl = new TextComponentTranslation("commands.scoreboard.players.tag.list", new Object[] { lllllllllllllllllIIlIIIlIlIIIlIl });
                lllllllllllllllllIIlIIIlIlIIIIIl.getStyle().setColor(TextFormatting.DARK_GREEN);
                lllllllllllllllllIIlIIIlIIlllIlI.addChatMessage(lllllllllllllllllIIlIIIlIlIIIIIl);
                lllllllllllllllllIIlIIIlIIlllIlI.addChatMessage(new TextComponentString(CommandBase.joinNiceString(lllllllllllllllllIIlIIIlIlIIIIlI.toArray())));
            }
            lllllllllllllllllIIlIIIlIIlllIlI.setCommandStat(CommandResultStats.Type.QUERY_RESULT, lllllllllllllllllIIlIIIlIlIIIIlI.size());
        }
        else {
            if (lllllllllllllllllIIlIIIlIlIIIlll.length < 5) {
                throw new WrongUsageException("commands.scoreboard.players.tag.usage", new Object[0]);
            }
            final String lllllllllllllllllIIlIIIlIlIIIIII = lllllllllllllllllIIlIIIlIlIIIlll[lllllllllllllllllIIlIIIlIIlllIII++];
            if (lllllllllllllllllIIlIIIlIlIIIlll.length > lllllllllllllllllIIlIIIlIIlllIII) {
                try {
                    final NBTTagCompound lllllllllllllllllIIlIIIlIIllllll = JsonToNBT.getTagFromJson(CommandBase.buildString(lllllllllllllllllIIlIIIlIlIIIlll, lllllllllllllllllIIlIIIlIIlllIII));
                    final NBTTagCompound lllllllllllllllllIIlIIIlIIlllllI = CommandBase.entityToNBT(lllllllllllllllllIIlIIIlIlIIIlII);
                    if (!NBTUtil.areNBTEquals(lllllllllllllllllIIlIIIlIIllllll, lllllllllllllllllIIlIIIlIIlllllI, true)) {
                        throw new CommandException("commands.scoreboard.players.tag.tagMismatch", new Object[] { lllllllllllllllllIIlIIIlIlIIIlIl });
                    }
                }
                catch (NBTException lllllllllllllllllIIlIIIlIIllllIl) {
                    throw new CommandException("commands.scoreboard.players.tag.tagError", new Object[] { lllllllllllllllllIIlIIIlIIllllIl.getMessage() });
                }
            }
            if ("add".equals(lllllllllllllllllIIlIIIlIlIIIIll)) {
                if (!lllllllllllllllllIIlIIIlIlIIIlII.addTag(lllllllllllllllllIIlIIIlIlIIIIII)) {
                    throw new CommandException("commands.scoreboard.players.tag.tooMany", new Object[] { 1024 });
                }
                CommandBase.notifyCommandListener(lllllllllllllllllIIlIIIlIIlllIlI, this, "commands.scoreboard.players.tag.success.add", lllllllllllllllllIIlIIIlIlIIIIII);
            }
            else {
                if (!"remove".equals(lllllllllllllllllIIlIIIlIlIIIIll)) {
                    throw new WrongUsageException("commands.scoreboard.players.tag.usage", new Object[0]);
                }
                if (!lllllllllllllllllIIlIIIlIlIIIlII.removeTag(lllllllllllllllllIIlIIIlIlIIIIII)) {
                    throw new CommandException("commands.scoreboard.players.tag.notFound", new Object[] { lllllllllllllllllIIlIIIlIlIIIIII });
                }
                CommandBase.notifyCommandListener(lllllllllllllllllIIlIIIlIIlllIlI, this, "commands.scoreboard.players.tag.success.remove", lllllllllllllllllIIlIIIlIlIIIIII);
            }
        }
    }
    
    protected void joinTeam(final ICommandSender lllllllllllllllllIIlIIlIllIIIIII, final String[] lllllllllllllllllIIlIIlIlIllllll, int lllllllllllllllllIIlIIlIlIlllllI, final MinecraftServer lllllllllllllllllIIlIIlIlIllllIl) throws CommandException {
        final Scoreboard lllllllllllllllllIIlIIlIlIllllII = this.getScoreboard(lllllllllllllllllIIlIIlIlIllllIl);
        final String lllllllllllllllllIIlIIlIlIlllIll = lllllllllllllllllIIlIIlIlIllllll[lllllllllllllllllIIlIIlIlIlllllI++];
        final Set<String> lllllllllllllllllIIlIIlIlIlllIlI = (Set<String>)Sets.newHashSet();
        final Set<String> lllllllllllllllllIIlIIlIlIlllIIl = (Set<String>)Sets.newHashSet();
        if (lllllllllllllllllIIlIIlIllIIIIII instanceof EntityPlayer && lllllllllllllllllIIlIIlIlIlllllI == lllllllllllllllllIIlIIlIlIllllll.length) {
            final String lllllllllllllllllIIlIIlIlIlllIII = CommandBase.getCommandSenderAsPlayer(lllllllllllllllllIIlIIlIllIIIIII).getName();
            if (lllllllllllllllllIIlIIlIlIllllII.addPlayerToTeam(lllllllllllllllllIIlIIlIlIlllIII, lllllllllllllllllIIlIIlIlIlllIll)) {
                lllllllllllllllllIIlIIlIlIlllIlI.add(lllllllllllllllllIIlIIlIlIlllIII);
            }
            else {
                lllllllllllllllllIIlIIlIlIlllIIl.add(lllllllllllllllllIIlIIlIlIlllIII);
            }
        }
        else {
            while (lllllllllllllllllIIlIIlIlIlllllI < lllllllllllllllllIIlIIlIlIllllll.length) {
                final String lllllllllllllllllIIlIIlIlIllIlll = lllllllllllllllllIIlIIlIlIllllll[lllllllllllllllllIIlIIlIlIlllllI++];
                if (EntitySelector.hasArguments(lllllllllllllllllIIlIIlIlIllIlll)) {
                    for (final Entity lllllllllllllllllIIlIIlIlIllIllI : CommandBase.getEntityList(lllllllllllllllllIIlIIlIlIllllIl, lllllllllllllllllIIlIIlIllIIIIII, lllllllllllllllllIIlIIlIlIllIlll)) {
                        final String lllllllllllllllllIIlIIlIlIllIlIl = CommandBase.getEntityName(lllllllllllllllllIIlIIlIlIllllIl, lllllllllllllllllIIlIIlIllIIIIII, lllllllllllllllllIIlIIlIlIllIllI.getCachedUniqueIdString());
                        if (lllllllllllllllllIIlIIlIlIllllII.addPlayerToTeam(lllllllllllllllllIIlIIlIlIllIlIl, lllllllllllllllllIIlIIlIlIlllIll)) {
                            lllllllllllllllllIIlIIlIlIlllIlI.add(lllllllllllllllllIIlIIlIlIllIlIl);
                        }
                        else {
                            lllllllllllllllllIIlIIlIlIlllIIl.add(lllllllllllllllllIIlIIlIlIllIlIl);
                        }
                    }
                }
                else {
                    final String lllllllllllllllllIIlIIlIlIllIlII = CommandBase.getEntityName(lllllllllllllllllIIlIIlIlIllllIl, lllllllllllllllllIIlIIlIllIIIIII, lllllllllllllllllIIlIIlIlIllIlll);
                    if (lllllllllllllllllIIlIIlIlIllllII.addPlayerToTeam(lllllllllllllllllIIlIIlIlIllIlII, lllllllllllllllllIIlIIlIlIlllIll)) {
                        lllllllllllllllllIIlIIlIlIlllIlI.add(lllllllllllllllllIIlIIlIlIllIlII);
                    }
                    else {
                        lllllllllllllllllIIlIIlIlIlllIIl.add(lllllllllllllllllIIlIIlIlIllIlII);
                    }
                }
            }
        }
        if (!lllllllllllllllllIIlIIlIlIlllIlI.isEmpty()) {
            lllllllllllllllllIIlIIlIllIIIIII.setCommandStat(CommandResultStats.Type.AFFECTED_ENTITIES, lllllllllllllllllIIlIIlIlIlllIlI.size());
            CommandBase.notifyCommandListener(lllllllllllllllllIIlIIlIllIIIIII, this, "commands.scoreboard.teams.join.success", lllllllllllllllllIIlIIlIlIlllIlI.size(), lllllllllllllllllIIlIIlIlIlllIll, CommandBase.joinNiceString(lllllllllllllllllIIlIIlIlIlllIlI.toArray(new String[lllllllllllllllllIIlIIlIlIlllIlI.size()])));
        }
        if (!lllllllllllllllllIIlIIlIlIlllIIl.isEmpty()) {
            throw new CommandException("commands.scoreboard.teams.join.failure", new Object[] { lllllllllllllllllIIlIIlIlIlllIIl.size(), lllllllllllllllllIIlIIlIlIlllIll, CommandBase.joinNiceString(lllllllllllllllllIIlIIlIlIlllIIl.toArray(new String[lllllllllllllllllIIlIIlIlIlllIIl.size()])) });
        }
    }
    
    @Override
    public String getCommandName() {
        return "scoreboard";
    }
    
    protected void testPlayerScore(final ICommandSender lllllllllllllllllIIlIIIllIIlIlIl, final String[] lllllllllllllllllIIlIIIllIIIlIIl, int lllllllllllllllllIIlIIIllIIlIIll, final MinecraftServer lllllllllllllllllIIlIIIllIIlIIlI) throws CommandException {
        final Scoreboard lllllllllllllllllIIlIIIllIIlIIIl = this.getScoreboard(lllllllllllllllllIIlIIIllIIlIIlI);
        final String lllllllllllllllllIIlIIIllIIlIIII = CommandBase.getEntityName(lllllllllllllllllIIlIIIllIIlIIlI, lllllllllllllllllIIlIIIllIIlIlIl, lllllllllllllllllIIlIIIllIIIlIIl[lllllllllllllllllIIlIIIllIIlIIll++]);
        if (lllllllllllllllllIIlIIIllIIlIIII.length() > 40) {
            throw new SyntaxErrorException("commands.scoreboard.players.name.tooLong", new Object[] { lllllllllllllllllIIlIIIllIIlIIII, 40 });
        }
        final ScoreObjective lllllllllllllllllIIlIIIllIIIllll = this.convertToObjective(lllllllllllllllllIIlIIIllIIIlIIl[lllllllllllllllllIIlIIIllIIlIIll++], false, lllllllllllllllllIIlIIIllIIlIIlI);
        if (!lllllllllllllllllIIlIIIllIIlIIIl.entityHasObjective(lllllllllllllllllIIlIIIllIIlIIII, lllllllllllllllllIIlIIIllIIIllll)) {
            throw new CommandException("commands.scoreboard.players.test.notFound", new Object[] { lllllllllllllllllIIlIIIllIIIllll.getName(), lllllllllllllllllIIlIIIllIIlIIII });
        }
        final int lllllllllllllllllIIlIIIllIIIlllI = lllllllllllllllllIIlIIIllIIIlIIl[lllllllllllllllllIIlIIIllIIlIIll].equals("*") ? Integer.MIN_VALUE : CommandBase.parseInt(lllllllllllllllllIIlIIIllIIIlIIl[lllllllllllllllllIIlIIIllIIlIIll]);
        final int lllllllllllllllllIIlIIIllIIIllIl = (++lllllllllllllllllIIlIIIllIIlIIll < lllllllllllllllllIIlIIIllIIIlIIl.length && !lllllllllllllllllIIlIIIllIIIlIIl[lllllllllllllllllIIlIIIllIIlIIll].equals("*")) ? CommandBase.parseInt(lllllllllllllllllIIlIIIllIIIlIIl[lllllllllllllllllIIlIIIllIIlIIll], lllllllllllllllllIIlIIIllIIIlllI) : Integer.MAX_VALUE;
        final Score lllllllllllllllllIIlIIIllIIIllII = lllllllllllllllllIIlIIIllIIlIIIl.getOrCreateScore(lllllllllllllllllIIlIIIllIIlIIII, lllllllllllllllllIIlIIIllIIIllll);
        if (lllllllllllllllllIIlIIIllIIIllII.getScorePoints() >= lllllllllllllllllIIlIIIllIIIlllI && lllllllllllllllllIIlIIIllIIIllII.getScorePoints() <= lllllllllllllllllIIlIIIllIIIllIl) {
            CommandBase.notifyCommandListener(lllllllllllllllllIIlIIIllIIlIlIl, this, "commands.scoreboard.players.test.success", lllllllllllllllllIIlIIIllIIIllII.getScorePoints(), lllllllllllllllllIIlIIIllIIIlllI, lllllllllllllllllIIlIIIllIIIllIl);
            return;
        }
        throw new CommandException("commands.scoreboard.players.test.failed", new Object[] { lllllllllllllllllIIlIIIllIIIllII.getScorePoints(), lllllllllllllllllIIlIIIllIIIlllI, lllllllllllllllllIIlIIIllIIIllIl });
    }
    
    protected Scoreboard getScoreboard(final MinecraftServer lllllllllllllllllIIlIIllIllllIlI) {
        return lllllllllllllllllIIlIIllIllllIlI.worldServerForDimension(0).getScoreboard();
    }
}
