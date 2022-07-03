package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.util.text.*;
import net.minecraft.command.*;
import com.mojang.authlib.*;
import net.minecraft.entity.player.*;
import net.minecraft.server.management.*;

public class CommandBanPlayer extends CommandBase
{
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIlIlIIIIlIlIlllIlll, final ICommandSender lllllllllllllIlIlIIIIlIlIlllIllI, final String[] lllllllllllllIlIlIIIIlIlIlllIlIl, @Nullable final BlockPos lllllllllllllIlIlIIIIlIlIlllIlII) {
        return (lllllllllllllIlIlIIIIlIlIlllIlIl.length >= 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIlIlIIIIlIlIlllIlIl, lllllllllllllIlIlIIIIlIlIlllIlll.getAllUsernames()) : Collections.emptyList();
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIlIlIIIIlIllIIIlIIl, final ICommandSender lllllllllllllIlIlIIIIlIllIIIlIII, final String[] lllllllllllllIlIlIIIIlIlIlllllll) throws CommandException {
        if (lllllllllllllIlIlIIIIlIlIlllllll.length < 1 || lllllllllllllIlIlIIIIlIlIlllllll[0].length() <= 0) {
            throw new WrongUsageException("commands.ban.usage", new Object[0]);
        }
        final GameProfile lllllllllllllIlIlIIIIlIllIIIIllI = lllllllllllllIlIlIIIIlIllIIIlIIl.getPlayerProfileCache().getGameProfileForUsername(lllllllllllllIlIlIIIIlIlIlllllll[0]);
        if (lllllllllllllIlIlIIIIlIllIIIIllI == null) {
            throw new CommandException("commands.ban.failed", new Object[] { lllllllllllllIlIlIIIIlIlIlllllll[0] });
        }
        String lllllllllllllIlIlIIIIlIllIIIIlIl = null;
        if (lllllllllllllIlIlIIIIlIlIlllllll.length >= 2) {
            lllllllllllllIlIlIIIIlIllIIIIlIl = CommandBase.getChatComponentFromNthArg(lllllllllllllIlIlIIIIlIllIIIlIII, lllllllllllllIlIlIIIIlIlIlllllll, 1).getUnformattedText();
        }
        final UserListBansEntry lllllllllllllIlIlIIIIlIllIIIIlII = new UserListBansEntry(lllllllllllllIlIlIIIIlIllIIIIllI, null, lllllllllllllIlIlIIIIlIllIIIlIII.getName(), null, lllllllllllllIlIlIIIIlIllIIIIlIl);
        ((UserList<K, UserListBansEntry>)lllllllllllllIlIlIIIIlIllIIIlIIl.getPlayerList().getBannedPlayers()).addEntry(lllllllllllllIlIlIIIIlIllIIIIlII);
        final EntityPlayerMP lllllllllllllIlIlIIIIlIllIIIIIll = lllllllllllllIlIlIIIIlIllIIIlIIl.getPlayerList().getPlayerByUsername(lllllllllllllIlIlIIIIlIlIlllllll[0]);
        if (lllllllllllllIlIlIIIIlIllIIIIIll != null) {
            lllllllllllllIlIlIIIIlIllIIIIIll.connection.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.banned", new Object[0]));
        }
        CommandBase.notifyCommandListener(lllllllllllllIlIlIIIIlIllIIIlIII, this, "commands.ban.success", lllllllllllllIlIlIIIIlIlIlllllll[0]);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIlIlIIIIlIllIIlllII) {
        return "commands.ban.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public String getCommandName() {
        return "ban";
    }
    
    @Override
    public boolean checkPermission(final MinecraftServer lllllllllllllIlIlIIIIlIllIIlIlll, final ICommandSender lllllllllllllIlIlIIIIlIllIIlIIll) {
        return lllllllllllllIlIlIIIIlIllIIlIlll.getPlayerList().getBannedPlayers().isLanServer() && super.checkPermission(lllllllllllllIlIlIIIIlIllIIlIlll, lllllllllllllIlIlIIIIlIllIIlIIll);
    }
}
