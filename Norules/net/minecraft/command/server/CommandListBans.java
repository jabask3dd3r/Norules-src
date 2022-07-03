package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.util.text.*;
import net.minecraft.command.*;

public class CommandListBans extends CommandBase
{
    @Override
    public String getCommandName() {
        return "banlist";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIlIIlllIIIIIIIIllII, final ICommandSender lllllllllllllIlIIlllIIIIIIIIlIll, final String[] lllllllllllllIlIIlllIIIIIIIIlIlI, @Nullable final BlockPos lllllllllllllIlIIlllIIIIIIIIlIIl) {
        return (lllllllllllllIlIIlllIIIIIIIIlIlI.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIlIIlllIIIIIIIIlIlI, "players", "ips") : Collections.emptyList();
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIlIIlllIIIIIIIllIIl) {
        return "commands.banlist.usage";
    }
    
    @Override
    public boolean checkPermission(final MinecraftServer lllllllllllllIlIIlllIIIIIIIlllII, final ICommandSender lllllllllllllIlIIlllIIIIIIIllllI) {
        return (lllllllllllllIlIIlllIIIIIIIlllII.getPlayerList().getBannedIPs().isLanServer() || lllllllllllllIlIIlllIIIIIIIlllII.getPlayerList().getBannedPlayers().isLanServer()) && super.checkPermission(lllllllllllllIlIIlllIIIIIIIlllII, lllllllllllllIlIIlllIIIIIIIllllI);
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIlIIlllIIIIIIIlIIIl, final ICommandSender lllllllllllllIlIIlllIIIIIIIlIIll, final String[] lllllllllllllIlIIlllIIIIIIIIllll) throws CommandException {
        if (lllllllllllllIlIIlllIIIIIIIIllll.length >= 1 && "ips".equalsIgnoreCase(lllllllllllllIlIIlllIIIIIIIIllll[0])) {
            lllllllllllllIlIIlllIIIIIIIlIIll.addChatMessage(new TextComponentTranslation("commands.banlist.ips", new Object[] { lllllllllllllIlIIlllIIIIIIIlIIIl.getPlayerList().getBannedIPs().getKeys().length }));
            lllllllllllllIlIIlllIIIIIIIlIIll.addChatMessage(new TextComponentString(CommandBase.joinNiceString(lllllllllllllIlIIlllIIIIIIIlIIIl.getPlayerList().getBannedIPs().getKeys())));
        }
        else {
            lllllllllllllIlIIlllIIIIIIIlIIll.addChatMessage(new TextComponentTranslation("commands.banlist.players", new Object[] { lllllllllllllIlIIlllIIIIIIIlIIIl.getPlayerList().getBannedPlayers().getKeys().length }));
            lllllllllllllIlIIlllIIIIIIIlIIll.addChatMessage(new TextComponentString(CommandBase.joinNiceString(lllllllllllllIlIIlllIIIIIIIlIIIl.getPlayerList().getBannedPlayers().getKeys())));
        }
    }
}
