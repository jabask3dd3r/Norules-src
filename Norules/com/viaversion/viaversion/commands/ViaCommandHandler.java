package com.viaversion.viaversion.commands;

import com.viaversion.viaversion.api.command.*;
import com.viaversion.viaversion.api.*;
import com.google.common.base.*;
import com.viaversion.viaversion.commands.defaultsubs.*;
import java.util.*;

public abstract class ViaCommandHandler implements ViaVersionCommand
{
    private final /* synthetic */ Map<String, ViaSubCommand> commandMap;
    
    @Override
    public void showHelp(final ViaCommandSender lllllllllllllIIIlIllIlIlIlllllII) {
        final Set<ViaSubCommand> lllllllllllllIIIlIllIlIlIllllllI = this.calculateAllowedCommands(lllllllllllllIIIlIllIlIlIlllllII);
        if (lllllllllllllIIIlIllIlIlIllllllI.isEmpty()) {
            lllllllllllllIIIlIllIlIlIlllllII.sendMessage(ViaSubCommand.color("&cYou are not allowed to use these commands!"));
            return;
        }
        lllllllllllllIIIlIllIlIlIlllllII.sendMessage(ViaSubCommand.color(String.valueOf(new StringBuilder().append("&aViaVersion &c").append(Via.getPlatform().getPluginVersion()))));
        lllllllllllllIIIlIllIlIlIlllllII.sendMessage(ViaSubCommand.color("&6Commands:"));
        for (final ViaSubCommand lllllllllllllIIIlIllIlIllIIIIIIl : lllllllllllllIIIlIllIlIlIllllllI) {
            lllllllllllllIIIlIllIlIlIlllllII.sendMessage(ViaSubCommand.color(String.format("&2/viaversion %s &7- &6%s", lllllllllllllIIIlIllIlIllIIIIIIl.usage(), lllllllllllllIIIlIllIlIllIIIIIIl.description())));
        }
        lllllllllllllIIIlIllIlIlIllllllI.clear();
    }
    
    protected ViaCommandHandler() {
        this.commandMap = new HashMap<String, ViaSubCommand>();
        this.registerDefaults();
    }
    
    private boolean hasPermission(final ViaCommandSender lllllllllllllIIIlIllIlIlIllIIlll, final String lllllllllllllIIIlIllIlIlIllIIlII) {
        return lllllllllllllIIIlIllIlIlIllIIlII == null || lllllllllllllIIIlIllIlIlIllIIlll.hasPermission(lllllllllllllIIIlIllIlIlIllIIlII);
    }
    
    private Set<ViaSubCommand> calculateAllowedCommands(final ViaCommandSender lllllllllllllIIIlIllIlIlIlllIIIl) {
        final Set<ViaSubCommand> lllllllllllllIIIlIllIlIlIlllIIII = new HashSet<ViaSubCommand>();
        for (final ViaSubCommand lllllllllllllIIIlIllIlIlIlllIIll : this.commandMap.values()) {
            if (this.hasPermission(lllllllllllllIIIlIllIlIlIlllIIIl, lllllllllllllIIIlIllIlIlIlllIIll.permission())) {
                lllllllllllllIIIlIllIlIlIlllIIII.add(lllllllllllllIIIlIllIlIlIlllIIll);
            }
        }
        return lllllllllllllIIIlIllIlIlIlllIIII;
    }
    
    @Override
    public void registerSubCommand(final ViaSubCommand lllllllllllllIIIlIllIlIlllIIIIIl) {
        Preconditions.checkArgument(lllllllllllllIIIlIllIlIlllIIIIIl.name().matches("^[a-z0-9_-]{3,15}$"), (Object)String.valueOf(new StringBuilder().append(lllllllllllllIIIlIllIlIlllIIIIIl.name()).append(" is not a valid sub-command name.")));
        Preconditions.checkArgument(!this.hasSubCommand(lllllllllllllIIIlIllIlIlllIIIIIl.name()), (Object)String.valueOf(new StringBuilder().append("ViaSubCommand ").append(lllllllllllllIIIlIllIlIlllIIIIIl.name()).append(" does already exists!")));
        this.commandMap.put(lllllllllllllIIIlIllIlIlllIIIIIl.name().toLowerCase(Locale.ROOT), lllllllllllllIIIlIllIlIlllIIIIIl);
    }
    
    private void registerDefaults() {
        this.registerSubCommand(new ListSubCmd());
        this.registerSubCommand(new PPSSubCmd());
        this.registerSubCommand(new DebugSubCmd());
        this.registerSubCommand(new DumpSubCmd());
        this.registerSubCommand(new DisplayLeaksSubCmd());
        this.registerSubCommand(new DontBugMeSubCmd());
        this.registerSubCommand(new AutoTeamSubCmd());
        this.registerSubCommand(new HelpSubCmd());
        this.registerSubCommand(new ReloadSubCmd());
    }
    
    @Override
    public boolean hasSubCommand(final String lllllllllllllIIIlIllIlIllIlllIll) {
        return this.commandMap.containsKey(lllllllllllllIIIlIllIlIllIlllIll.toLowerCase(Locale.ROOT));
    }
    
    @Override
    public ViaSubCommand getSubCommand(final String lllllllllllllIIIlIllIlIllIllIIll) {
        return this.commandMap.get(lllllllllllllIIIlIllIlIllIllIIll.toLowerCase(Locale.ROOT));
    }
    
    @Override
    public List<String> onTabComplete(final ViaCommandSender lllllllllllllIIIlIllIlIllIIlIIlI, final String[] lllllllllllllIIIlIllIlIllIIIllII) {
        final Set<ViaSubCommand> lllllllllllllIIIlIllIlIllIIlIIII = this.calculateAllowedCommands(lllllllllllllIIIlIllIlIllIIlIIlI);
        final List<String> lllllllllllllIIIlIllIlIllIIIllll = new ArrayList<String>();
        if (lllllllllllllIIIlIllIlIllIIIllII.length == 1) {
            if (!lllllllllllllIIIlIllIlIllIIIllII[0].isEmpty()) {
                for (final ViaSubCommand lllllllllllllIIIlIllIlIllIIllIII : lllllllllllllIIIlIllIlIllIIlIIII) {
                    if (lllllllllllllIIIlIllIlIllIIllIII.name().toLowerCase().startsWith(lllllllllllllIIIlIllIlIllIIIllII[0].toLowerCase(Locale.ROOT))) {
                        lllllllllllllIIIlIllIlIllIIIllll.add(lllllllllllllIIIlIllIlIllIIllIII.name());
                    }
                }
            }
            else {
                for (final ViaSubCommand lllllllllllllIIIlIllIlIllIIlIlll : lllllllllllllIIIlIllIlIllIIlIIII) {
                    lllllllllllllIIIlIllIlIllIIIllll.add(lllllllllllllIIIlIllIlIllIIlIlll.name());
                }
            }
        }
        else if (lllllllllllllIIIlIllIlIllIIIllII.length >= 2 && this.getSubCommand(lllllllllllllIIIlIllIlIllIIIllII[0]) != null) {
            final ViaSubCommand lllllllllllllIIIlIllIlIllIIlIllI = this.getSubCommand(lllllllllllllIIIlIllIlIllIIIllII[0]);
            if (!lllllllllllllIIIlIllIlIllIIlIIII.contains(lllllllllllllIIIlIllIlIllIIlIllI)) {
                return lllllllllllllIIIlIllIlIllIIIllll;
            }
            final String[] lllllllllllllIIIlIllIlIllIIlIlIl = Arrays.copyOfRange(lllllllllllllIIIlIllIlIllIIIllII, 1, lllllllllllllIIIlIllIlIllIIIllII.length);
            final List<String> lllllllllllllIIIlIllIlIllIIlIlII = lllllllllllllIIIlIllIlIllIIlIllI.onTabComplete(lllllllllllllIIIlIllIlIllIIlIIlI, lllllllllllllIIIlIllIlIllIIlIlIl);
            Collections.sort(lllllllllllllIIIlIllIlIllIIlIlII);
            return lllllllllllllIIIlIllIlIllIIlIlII;
        }
        return lllllllllllllIIIlIllIlIllIIIllll;
    }
    
    @Override
    public boolean onCommand(final ViaCommandSender lllllllllllllIIIlIllIlIllIlIIlIl, final String[] lllllllllllllIIIlIllIlIllIlIlIlI) {
        if (lllllllllllllIIIlIllIlIllIlIlIlI.length == 0) {
            this.showHelp(lllllllllllllIIIlIllIlIllIlIIlIl);
            return false;
        }
        if (!this.hasSubCommand(lllllllllllllIIIlIllIlIllIlIlIlI[0])) {
            lllllllllllllIIIlIllIlIllIlIIlIl.sendMessage(ViaSubCommand.color("&cThis command does not exist."));
            this.showHelp(lllllllllllllIIIlIllIlIllIlIIlIl);
            return false;
        }
        final ViaSubCommand lllllllllllllIIIlIllIlIllIlIlIIl = this.getSubCommand(lllllllllllllIIIlIllIlIllIlIlIlI[0]);
        if (!this.hasPermission(lllllllllllllIIIlIllIlIllIlIIlIl, lllllllllllllIIIlIllIlIllIlIlIIl.permission())) {
            lllllllllllllIIIlIllIlIllIlIIlIl.sendMessage(ViaSubCommand.color("&cYou are not allowed to use this command!"));
            return false;
        }
        final String[] lllllllllllllIIIlIllIlIllIlIlIII = Arrays.copyOfRange(lllllllllllllIIIlIllIlIllIlIlIlI, 1, lllllllllllllIIIlIllIlIllIlIlIlI.length);
        final boolean lllllllllllllIIIlIllIlIllIlIIlll = lllllllllllllIIIlIllIlIllIlIlIIl.execute(lllllllllllllIIIlIllIlIllIlIIlIl, lllllllllllllIIIlIllIlIllIlIlIII);
        if (!lllllllllllllIIIlIllIlIllIlIIlll) {
            lllllllllllllIIIlIllIlIllIlIIlIl.sendMessage(String.valueOf(new StringBuilder().append("Usage: /viaversion ").append(lllllllllllllIIIlIllIlIllIlIlIIl.usage())));
        }
        return lllllllllllllIIIlIllIlIllIlIIlll;
    }
}
