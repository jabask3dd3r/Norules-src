package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.text.*;
import net.minecraft.util.text.event.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;

public class CommandHelp extends CommandBase
{
    private static final /* synthetic */ String[] seargeSays;
    private final /* synthetic */ Random rand;
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIIlllIIIIIIIIlIIIIl) {
        return "commands.help.usage";
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIIlllIIIIIIIIIlIIIl, final ICommandSender lllllllllllllIIlllIIIIIIIIIlIIII, final String[] lllllllllllllIIllIlllllllllllllI) throws CommandException {
        if (lllllllllllllIIlllIIIIIIIIIlIIII instanceof CommandBlockBaseLogic) {
            lllllllllllllIIlllIIIIIIIIIlIIII.addChatMessage(new TextComponentString("Searge says: ").appendText(CommandHelp.seargeSays[this.rand.nextInt(CommandHelp.seargeSays.length) % CommandHelp.seargeSays.length]));
        }
        else {
            final List<ICommand> lllllllllllllIIlllIIIIIIIIIIlllI = this.getSortedPossibleCommands(lllllllllllllIIlllIIIIIIIIIlIIII, lllllllllllllIIlllIIIIIIIIIlIIIl);
            final int lllllllllllllIIlllIIIIIIIIIIllIl = 7;
            final int lllllllllllllIIlllIIIIIIIIIIllII = (lllllllllllllIIlllIIIIIIIIIIlllI.size() - 1) / 7;
            int lllllllllllllIIlllIIIIIIIIIIlIll = 0;
            try {
                lllllllllllllIIlllIIIIIIIIIIlIll = ((lllllllllllllIIllIlllllllllllllI.length == 0) ? 0 : (CommandBase.parseInt(lllllllllllllIIllIlllllllllllllI[0], 1, lllllllllllllIIlllIIIIIIIIIIllII + 1) - 1));
            }
            catch (NumberInvalidException lllllllllllllIIlllIIIIIIIIIIlIlI) {
                final Map<String, ICommand> lllllllllllllIIlllIIIIIIIIIIlIIl = this.getCommandMap(lllllllllllllIIlllIIIIIIIIIlIIIl);
                final ICommand lllllllllllllIIlllIIIIIIIIIIlIII = lllllllllllllIIlllIIIIIIIIIIlIIl.get(lllllllllllllIIllIlllllllllllllI[0]);
                if (lllllllllllllIIlllIIIIIIIIIIlIII != null) {
                    throw new WrongUsageException(lllllllllllllIIlllIIIIIIIIIIlIII.getCommandUsage(lllllllllllllIIlllIIIIIIIIIlIIII), new Object[0]);
                }
                if (MathHelper.getInt(lllllllllllllIIllIlllllllllllllI[0], -1) == -1 && MathHelper.getInt(lllllllllllllIIllIlllllllllllllI[0], -2) == -2) {
                    throw new CommandNotFoundException();
                }
                throw lllllllllllllIIlllIIIIIIIIIIlIlI;
            }
            final int lllllllllllllIIlllIIIIIIIIIIIlll = Math.min((lllllllllllllIIlllIIIIIIIIIIlIll + 1) * 7, lllllllllllllIIlllIIIIIIIIIIlllI.size());
            final TextComponentTranslation lllllllllllllIIlllIIIIIIIIIIIllI = new TextComponentTranslation("commands.help.header", new Object[] { lllllllllllllIIlllIIIIIIIIIIlIll + 1, lllllllllllllIIlllIIIIIIIIIIllII + 1 });
            lllllllllllllIIlllIIIIIIIIIIIllI.getStyle().setColor(TextFormatting.DARK_GREEN);
            lllllllllllllIIlllIIIIIIIIIlIIII.addChatMessage(lllllllllllllIIlllIIIIIIIIIIIllI);
            for (int lllllllllllllIIlllIIIIIIIIIIIlIl = lllllllllllllIIlllIIIIIIIIIIlIll * 7; lllllllllllllIIlllIIIIIIIIIIIlIl < lllllllllllllIIlllIIIIIIIIIIIlll; ++lllllllllllllIIlllIIIIIIIIIIIlIl) {
                final ICommand lllllllllllllIIlllIIIIIIIIIIIlII = lllllllllllllIIlllIIIIIIIIIIlllI.get(lllllllllllllIIlllIIIIIIIIIIIlIl);
                final TextComponentTranslation lllllllllllllIIlllIIIIIIIIIIIIll = new TextComponentTranslation(lllllllllllllIIlllIIIIIIIIIIIlII.getCommandUsage(lllllllllllllIIlllIIIIIIIIIlIIII), new Object[0]);
                lllllllllllllIIlllIIIIIIIIIIIIll.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, String.valueOf(new StringBuilder("/").append(lllllllllllllIIlllIIIIIIIIIIIlII.getCommandName()).append(" "))));
                lllllllllllllIIlllIIIIIIIIIlIIII.addChatMessage(lllllllllllllIIlllIIIIIIIIIIIIll);
            }
            if (lllllllllllllIIlllIIIIIIIIIIlIll == 0) {
                final TextComponentTranslation lllllllllllllIIlllIIIIIIIIIIIIlI = new TextComponentTranslation("commands.help.footer", new Object[0]);
                lllllllllllllIIlllIIIIIIIIIIIIlI.getStyle().setColor(TextFormatting.GREEN);
                lllllllllllllIIlllIIIIIIIIIlIIII.addChatMessage(lllllllllllllIIlllIIIIIIIIIIIIlI);
            }
        }
    }
    
    protected List<ICommand> getSortedPossibleCommands(final ICommandSender lllllllllllllIIllIlllllllllIllIl, final MinecraftServer lllllllllllllIIllIlllllllllIllll) {
        final List<ICommand> lllllllllllllIIllIlllllllllIlllI = lllllllllllllIIllIlllllllllIllll.getCommandManager().getPossibleCommands(lllllllllllllIIllIlllllllllIllIl);
        Collections.sort(lllllllllllllIIllIlllllllllIlllI);
        return lllllllllllllIIllIlllllllllIlllI;
    }
    
    protected Map<String, ICommand> getCommandMap(final MinecraftServer lllllllllllllIIllIlllllllllIIlll) {
        return lllllllllllllIIllIlllllllllIIlll.getCommandManager().getCommands();
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIIllIllllllllIllIll, final ICommandSender lllllllllllllIIllIlllllllllIIIII, final String[] lllllllllllllIIllIllllllllIlllll, @Nullable final BlockPos lllllllllllllIIllIllllllllIllllI) {
        if (lllllllllllllIIllIllllllllIlllll.length == 1) {
            final Set<String> lllllllllllllIIllIllllllllIlllIl = this.getCommandMap(lllllllllllllIIllIllllllllIllIll).keySet();
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIllIllllllllIlllll, (String[])lllllllllllllIIllIllllllllIlllIl.toArray(new String[lllllllllllllIIllIllllllllIlllIl.size()]));
        }
        return Collections.emptyList();
    }
    
    @Override
    public List<String> getCommandAliases() {
        return Arrays.asList("?");
    }
    
    @Override
    public String getCommandName() {
        return "help";
    }
    
    static {
        seargeSays = new String[] { "Yolo", "Ask for help on twitter", "/deop @p", "Scoreboard deleted, commands blocked", "Contact helpdesk for help", "/testfornoob @p", "/trigger warning", "Oh my god, it's full of stats", "/kill @p[name=!Searge]", "Have you tried turning it off and on again?", "Sorry, no help today" };
    }
    
    public CommandHelp() {
        this.rand = new Random();
    }
}
