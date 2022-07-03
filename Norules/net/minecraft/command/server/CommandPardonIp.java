package net.minecraft.command.server;

import net.minecraft.server.*;
import java.util.regex.*;
import net.minecraft.command.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.server.management.*;

public class CommandPardonIp extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIIIlIllIlIIIIllIII) {
        return "commands.unbanip.usage";
    }
    
    @Override
    public String getCommandName() {
        return "pardon-ip";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllIIIlIllIlIIIIIllII, final ICommandSender llllllllllllllIIIlIllIlIIIIIlIll, final String[] llllllllllllllIIIlIllIlIIIIIlIlI) throws CommandException {
        if (llllllllllllllIIIlIllIlIIIIIlIlI.length != 1 || llllllllllllllIIIlIllIlIIIIIlIlI[0].length() <= 1) {
            throw new WrongUsageException("commands.unbanip.usage", new Object[0]);
        }
        final Matcher llllllllllllllIIIlIllIlIIIIIlllI = CommandBanIp.IP_PATTERN.matcher(llllllllllllllIIIlIllIlIIIIIlIlI[0]);
        if (llllllllllllllIIIlIllIlIIIIIlllI.matches()) {
            ((UserList<String, V>)llllllllllllllIIIlIllIlIIIIIllII.getPlayerList().getBannedIPs()).removeEntry(llllllllllllllIIIlIllIlIIIIIlIlI[0]);
            CommandBase.notifyCommandListener(llllllllllllllIIIlIllIlIIIIIlIll, this, "commands.unbanip.success", llllllllllllllIIIlIllIlIIIIIlIlI[0]);
            return;
        }
        throw new SyntaxErrorException("commands.unbanip.invalid", new Object[0]);
    }
    
    @Override
    public boolean checkPermission(final MinecraftServer llllllllllllllIIIlIllIlIIIIllllI, final ICommandSender llllllllllllllIIIlIllIlIIIIlllIl) {
        return llllllllllllllIIIlIllIlIIIIllllI.getPlayerList().getBannedIPs().isLanServer() && super.checkPermission(llllllllllllllIIIlIllIlIIIIllllI, llllllllllllllIIIlIllIlIIIIlllIl);
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllllIIIlIllIlIIIIIIlIl, final ICommandSender llllllllllllllIIIlIllIlIIIIIIlII, final String[] llllllllllllllIIIlIllIlIIIIIIIll, @Nullable final BlockPos llllllllllllllIIIlIllIlIIIIIIIlI) {
        return (llllllllllllllIIIlIllIlIIIIIIIll.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIIlIllIlIIIIIIIll, llllllllllllllIIIlIllIlIIIIIIlIl.getPlayerList().getBannedIPs().getKeys()) : Collections.emptyList();
    }
}
