package net.minecraft.command;

import net.minecraft.util.text.*;
import net.minecraft.entity.*;
import net.minecraft.server.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;

public abstract class CommandHandler implements ICommandManager
{
    private final /* synthetic */ Map<String, ICommand> commandMap;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ Set<ICommand> commandSet;
    
    @Override
    public int executeCommand(final ICommandSender lllllllllllllIlllIllIlIIlIIlIIlI, String lllllllllllllIlllIllIlIIlIIlIIIl) {
        lllllllllllllIlllIllIlIIlIIlIIIl = (double)((String)lllllllllllllIlllIllIlIIlIIlIIIl).trim();
        if (((String)lllllllllllllIlllIllIlIIlIIlIIIl).startsWith("/")) {
            lllllllllllllIlllIllIlIIlIIlIIIl = (double)((String)lllllllllllllIlllIllIlIIlIIlIIIl).substring(1);
        }
        String[] lllllllllllllIlllIllIlIIlIIlllll = ((String)lllllllllllllIlllIllIlIIlIIlIIIl).split(" ");
        final String lllllllllllllIlllIllIlIIlIIllllI = lllllllllllllIlllIllIlIIlIIlllll[0];
        lllllllllllllIlllIllIlIIlIIlllll = dropFirstString(lllllllllllllIlllIllIlIIlIIlllll);
        final ICommand lllllllllllllIlllIllIlIIlIIlllIl = this.commandMap.get(lllllllllllllIlllIllIlIIlIIllllI);
        int lllllllllllllIlllIllIlIIlIIlllII = 0;
        try {
            final int lllllllllllllIlllIllIlIIlIIllIll = this.getUsernameIndex(lllllllllllllIlllIllIlIIlIIlllIl, lllllllllllllIlllIllIlIIlIIlllll);
            if (lllllllllllllIlllIllIlIIlIIlllIl == null) {
                final TextComponentTranslation lllllllllllllIlllIllIlIIlIIllIlI = new TextComponentTranslation("commands.generic.notFound", new Object[0]);
                lllllllllllllIlllIllIlIIlIIllIlI.getStyle().setColor(TextFormatting.RED);
                lllllllllllllIlllIllIlIIlIIlIIlI.addChatMessage(lllllllllllllIlllIllIlIIlIIllIlI);
            }
            else if (lllllllllllllIlllIllIlIIlIIlllIl.checkPermission(this.getServer(), lllllllllllllIlllIllIlIIlIIlIIlI)) {
                if (lllllllllllllIlllIllIlIIlIIllIll > -1) {
                    final List<Entity> lllllllllllllIlllIllIlIIlIIllIIl = EntitySelector.matchEntities(lllllllllllllIlllIllIlIIlIIlIIlI, lllllllllllllIlllIllIlIIlIIlllll[lllllllllllllIlllIllIlIIlIIllIll], (Class<? extends Entity>)Entity.class);
                    final String lllllllllllllIlllIllIlIIlIIllIII = lllllllllllllIlllIllIlIIlIIlllll[lllllllllllllIlllIllIlIIlIIllIll];
                    lllllllllllllIlllIllIlIIlIIlIIlI.setCommandStat(CommandResultStats.Type.AFFECTED_ENTITIES, lllllllllllllIlllIllIlIIlIIllIIl.size());
                    if (lllllllllllllIlllIllIlIIlIIllIIl.isEmpty()) {
                        throw new PlayerNotFoundException("commands.generic.selector.notFound", new Object[] { lllllllllllllIlllIllIlIIlIIlllll[lllllllllllllIlllIllIlIIlIIllIll] });
                    }
                    for (final Entity lllllllllllllIlllIllIlIIlIIlIlll : lllllllllllllIlllIllIlIIlIIllIIl) {
                        lllllllllllllIlllIllIlIIlIIlllll[lllllllllllllIlllIllIlIIlIIllIll] = lllllllllllllIlllIllIlIIlIIlIlll.getCachedUniqueIdString();
                        if (this.tryExecute(lllllllllllllIlllIllIlIIlIIlIIlI, lllllllllllllIlllIllIlIIlIIlllll, lllllllllllllIlllIllIlIIlIIlllIl, (String)lllllllllllllIlllIllIlIIlIIlIIIl)) {
                            ++lllllllllllllIlllIllIlIIlIIlllII;
                        }
                    }
                    lllllllllllllIlllIllIlIIlIIlllll[lllllllllllllIlllIllIlIIlIIllIll] = lllllllllllllIlllIllIlIIlIIllIII;
                }
                else {
                    lllllllllllllIlllIllIlIIlIIlIIlI.setCommandStat(CommandResultStats.Type.AFFECTED_ENTITIES, 1);
                    if (this.tryExecute(lllllllllllllIlllIllIlIIlIIlIIlI, lllllllllllllIlllIllIlIIlIIlllll, lllllllllllllIlllIllIlIIlIIlllIl, (String)lllllllllllllIlllIllIlIIlIIlIIIl)) {
                        ++lllllllllllllIlllIllIlIIlIIlllII;
                    }
                }
            }
            else {
                final TextComponentTranslation lllllllllllllIlllIllIlIIlIIlIllI = new TextComponentTranslation("commands.generic.permission", new Object[0]);
                lllllllllllllIlllIllIlIIlIIlIllI.getStyle().setColor(TextFormatting.RED);
                lllllllllllllIlllIllIlIIlIIlIIlI.addChatMessage(lllllllllllllIlllIllIlIIlIIlIllI);
            }
        }
        catch (CommandException lllllllllllllIlllIllIlIIlIIlIlIl) {
            final TextComponentTranslation lllllllllllllIlllIllIlIIlIIlIlII = new TextComponentTranslation(lllllllllllllIlllIllIlIIlIIlIlIl.getMessage(), lllllllllllllIlllIllIlIIlIIlIlIl.getErrorObjects());
            lllllllllllllIlllIllIlIIlIIlIlII.getStyle().setColor(TextFormatting.RED);
            lllllllllllllIlllIllIlIIlIIlIIlI.addChatMessage(lllllllllllllIlllIllIlIIlIIlIlII);
        }
        lllllllllllllIlllIllIlIIlIIlIIlI.setCommandStat(CommandResultStats.Type.SUCCESS_COUNT, lllllllllllllIlllIllIlIIlIIlllII);
        return lllllllllllllIlllIllIlIIlIIlllII;
    }
    
    private int getUsernameIndex(final ICommand lllllllllllllIlllIllIlIIIIlIIlll, final String[] lllllllllllllIlllIllIlIIIIlIIllI) throws CommandException {
        if (lllllllllllllIlllIllIlIIIIlIIlll == null) {
            return -1;
        }
        for (int lllllllllllllIlllIllIlIIIIlIlIII = 0; lllllllllllllIlllIllIlIIIIlIlIII < lllllllllllllIlllIllIlIIIIlIIllI.length; ++lllllllllllllIlllIllIlIIIIlIlIII) {
            if (lllllllllllllIlllIllIlIIIIlIIlll.isUsernameIndex(lllllllllllllIlllIllIlIIIIlIIllI, lllllllllllllIlllIllIlIIIIlIlIII) && EntitySelector.matchesMultiplePlayers(lllllllllllllIlllIllIlIIIIlIIllI[lllllllllllllIlllIllIlIIIIlIlIII])) {
                return lllllllllllllIlllIllIlIIIIlIlIII;
            }
        }
        return -1;
    }
    
    protected abstract MinecraftServer getServer();
    
    @Override
    public List<ICommand> getPossibleCommands(final ICommandSender lllllllllllllIlllIllIlIIIIllIlIl) {
        final List<ICommand> lllllllllllllIlllIllIlIIIIlllIII = (List<ICommand>)Lists.newArrayList();
        for (final ICommand lllllllllllllIlllIllIlIIIIllIlll : this.commandSet) {
            if (lllllllllllllIlllIllIlIIIIllIlll.checkPermission(this.getServer(), lllllllllllllIlllIllIlIIIIllIlIl)) {
                lllllllllllllIlllIllIlIIIIlllIII.add(lllllllllllllIlllIllIlIIIIllIlll);
            }
        }
        return lllllllllllllIlllIllIlIIIIlllIII;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public ICommand registerCommand(final ICommand lllllllllllllIlllIllIlIIIllIIlII) {
        this.commandMap.put(lllllllllllllIlllIllIlIIIllIIlII.getCommandName(), lllllllllllllIlllIllIlIIIllIIlII);
        this.commandSet.add(lllllllllllllIlllIllIlIIIllIIlII);
        for (final String lllllllllllllIlllIllIlIIIllIIlll : lllllllllllllIlllIllIlIIIllIIlII.getCommandAliases()) {
            final ICommand lllllllllllllIlllIllIlIIIllIIllI = this.commandMap.get(lllllllllllllIlllIllIlIIIllIIlll);
            if (lllllllllllllIlllIllIlIIIllIIllI == null || !lllllllllllllIlllIllIlIIIllIIllI.getCommandName().equals(lllllllllllllIlllIllIlIIIllIIlll)) {
                this.commandMap.put(lllllllllllllIlllIllIlIIIllIIlll, lllllllllllllIlllIllIlIIIllIIlII);
            }
        }
        return lllllllllllllIlllIllIlIIIllIIlII;
    }
    
    public CommandHandler() {
        this.commandMap = (Map<String, ICommand>)Maps.newHashMap();
        this.commandSet = (Set<ICommand>)Sets.newHashSet();
    }
    
    protected boolean tryExecute(final ICommandSender lllllllllllllIlllIllIlIIIlllllll, final String[] lllllllllllllIlllIllIlIIIlllIIll, final ICommand lllllllllllllIlllIllIlIIIlllIIlI, final String lllllllllllllIlllIllIlIIIlllIIIl) {
        try {
            lllllllllllllIlllIllIlIIIlllIIlI.execute(this.getServer(), lllllllllllllIlllIllIlIIIlllllll, lllllllllllllIlllIllIlIIIlllIIll);
            return true;
        }
        catch (WrongUsageException lllllllllllllIlllIllIlIIIllllIll) {
            final TextComponentTranslation lllllllllllllIlllIllIlIIIllllIlI = new TextComponentTranslation("commands.generic.usage", new Object[] { new TextComponentTranslation(lllllllllllllIlllIllIlIIIllllIll.getMessage(), lllllllllllllIlllIllIlIIIllllIll.getErrorObjects()) });
            lllllllllllllIlllIllIlIIIllllIlI.getStyle().setColor(TextFormatting.RED);
            lllllllllllllIlllIllIlIIIlllllll.addChatMessage(lllllllllllllIlllIllIlIIIllllIlI);
        }
        catch (CommandException lllllllllllllIlllIllIlIIIllllIIl) {
            final TextComponentTranslation lllllllllllllIlllIllIlIIIllllIII = new TextComponentTranslation(lllllllllllllIlllIllIlIIIllllIIl.getMessage(), lllllllllllllIlllIllIlIIIllllIIl.getErrorObjects());
            lllllllllllllIlllIllIlIIIllllIII.getStyle().setColor(TextFormatting.RED);
            lllllllllllllIlllIllIlIIIlllllll.addChatMessage(lllllllllllllIlllIllIlIIIllllIII);
        }
        catch (Throwable lllllllllllllIlllIllIlIIIlllIlll) {
            final TextComponentTranslation lllllllllllllIlllIllIlIIIlllIllI = new TextComponentTranslation("commands.generic.exception", new Object[0]);
            lllllllllllllIlllIllIlIIIlllIllI.getStyle().setColor(TextFormatting.RED);
            lllllllllllllIlllIllIlIIIlllllll.addChatMessage(lllllllllllllIlllIllIlIIIlllIllI);
            CommandHandler.LOGGER.warn(String.valueOf(new StringBuilder("Couldn't process command: ").append(lllllllllllllIlllIllIlIIIlllIIIl)), lllllllllllllIlllIllIlIIIlllIlll);
        }
        return false;
    }
    
    @Override
    public Map<String, ICommand> getCommands() {
        return this.commandMap;
    }
    
    private static String[] dropFirstString(final String[] lllllllllllllIlllIllIlIIIlIlllII) {
        final String[] lllllllllllllIlllIllIlIIIlIlllIl = new String[lllllllllllllIlllIllIlIIIlIlllII.length - 1];
        System.arraycopy(lllllllllllllIlllIllIlIIIlIlllII, 1, lllllllllllllIlllIllIlIIIlIlllIl, 0, lllllllllllllIlllIllIlIIIlIlllII.length - 1);
        return lllllllllllllIlllIllIlIIIlIlllIl;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final ICommandSender lllllllllllllIlllIllIlIIIlIIIlll, final String lllllllllllllIlllIllIlIIIlIIIllI, @Nullable final BlockPos lllllllllllllIlllIllIlIIIlIIlllI) {
        final String[] lllllllllllllIlllIllIlIIIlIIllIl = lllllllllllllIlllIllIlIIIlIIIllI.split(" ", -1);
        final String lllllllllllllIlllIllIlIIIlIIllII = lllllllllllllIlllIllIlIIIlIIllIl[0];
        if (lllllllllllllIlllIllIlIIIlIIllIl.length == 1) {
            final List<String> lllllllllllllIlllIllIlIIIlIIlIll = (List<String>)Lists.newArrayList();
            for (final Map.Entry<String, ICommand> lllllllllllllIlllIllIlIIIlIIlIlI : this.commandMap.entrySet()) {
                if (CommandBase.doesStringStartWith(lllllllllllllIlllIllIlIIIlIIllII, lllllllllllllIlllIllIlIIIlIIlIlI.getKey()) && lllllllllllllIlllIllIlIIIlIIlIlI.getValue().checkPermission(this.getServer(), lllllllllllllIlllIllIlIIIlIIIlll)) {
                    lllllllllllllIlllIllIlIIIlIIlIll.add(lllllllllllllIlllIllIlIIIlIIlIlI.getKey());
                }
            }
            return lllllllllllllIlllIllIlIIIlIIlIll;
        }
        if (lllllllllllllIlllIllIlIIIlIIllIl.length > 1) {
            final ICommand lllllllllllllIlllIllIlIIIlIIlIIl = this.commandMap.get(lllllllllllllIlllIllIlIIIlIIllII);
            if (lllllllllllllIlllIllIlIIIlIIlIIl != null && lllllllllllllIlllIllIlIIIlIIlIIl.checkPermission(this.getServer(), lllllllllllllIlllIllIlIIIlIIIlll)) {
                return lllllllllllllIlllIllIlIIIlIIlIIl.getTabCompletionOptions(this.getServer(), lllllllllllllIlllIllIlIIIlIIIlll, dropFirstString(lllllllllllllIlllIllIlIIIlIIllIl), lllllllllllllIlllIllIlIIIlIIlllI);
            }
        }
        return Collections.emptyList();
    }
}
