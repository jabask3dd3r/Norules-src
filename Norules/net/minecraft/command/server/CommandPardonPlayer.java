package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.command.*;
import com.mojang.authlib.*;
import net.minecraft.server.management.*;

public class CommandPardonPlayer extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIllIIIllIllIIIlllIl) {
        return "commands.unban.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIllIIIllIlIllllllIl, final ICommandSender lllllllllllllIllIIIllIllIIIIIIII, final String[] lllllllllllllIllIIIllIlIllllllII, @Nullable final BlockPos lllllllllllllIllIIIllIlIlllllllI) {
        return (lllllllllllllIllIIIllIlIllllllII.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIllIIIllIlIllllllII, lllllllllllllIllIIIllIlIllllllIl.getPlayerList().getBannedPlayers().getKeys()) : Collections.emptyList();
    }
    
    @Override
    public boolean checkPermission(final MinecraftServer lllllllllllllIllIIIllIllIIIllIII, final ICommandSender lllllllllllllIllIIIllIllIIIlIlII) {
        return lllllllllllllIllIIIllIllIIIllIII.getPlayerList().getBannedPlayers().isLanServer() && super.checkPermission(lllllllllllllIllIIIllIllIIIllIII, lllllllllllllIllIIIllIllIIIlIlII);
    }
    
    @Override
    public String getCommandName() {
        return "pardon";
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIllIIIllIllIIIIlIII, final ICommandSender lllllllllllllIllIIIllIllIIIIllII, final String[] lllllllllllllIllIIIllIllIIIIlIll) throws CommandException {
        if (lllllllllllllIllIIIllIllIIIIlIll.length != 1 || lllllllllllllIllIIIllIllIIIIlIll[0].length() <= 0) {
            throw new WrongUsageException("commands.unban.usage", new Object[0]);
        }
        final GameProfile lllllllllllllIllIIIllIllIIIIlIlI = lllllllllllllIllIIIllIllIIIIlIII.getPlayerList().getBannedPlayers().getBannedProfile(lllllllllllllIllIIIllIllIIIIlIll[0]);
        if (lllllllllllllIllIIIllIllIIIIlIlI == null) {
            throw new CommandException("commands.unban.failed", new Object[] { lllllllllllllIllIIIllIllIIIIlIll[0] });
        }
        ((UserList<GameProfile, V>)lllllllllllllIllIIIllIllIIIIlIII.getPlayerList().getBannedPlayers()).removeEntry(lllllllllllllIllIIIllIllIIIIlIlI);
        CommandBase.notifyCommandListener(lllllllllllllIllIIIllIllIIIIllII, this, "commands.unban.success", lllllllllllllIllIIIllIllIIIIlIll[0]);
    }
}
