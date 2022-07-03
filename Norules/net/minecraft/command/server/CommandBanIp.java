package net.minecraft.command.server;

import net.minecraft.server.*;
import java.util.regex.*;
import net.minecraft.entity.player.*;
import javax.annotation.*;
import net.minecraft.util.text.*;
import net.minecraft.command.*;
import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.server.management.*;

public class CommandBanIp extends CommandBase
{
    public static final /* synthetic */ Pattern IP_PATTERN;
    
    @Override
    public String getCommandName() {
        return "ban-ip";
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIllIllIllIlllIIIIll, final ICommandSender lllllllllllllIllIllIllIllIlllIll, final String[] lllllllllllllIllIllIllIlllIIIIIl) throws CommandException {
        if (lllllllllllllIllIllIllIlllIIIIIl.length >= 1 && lllllllllllllIllIllIllIlllIIIIIl[0].length() > 1) {
            final ITextComponent lllllllllllllIllIllIllIlllIIIIII = (lllllllllllllIllIllIllIlllIIIIIl.length >= 2) ? CommandBase.getChatComponentFromNthArg(lllllllllllllIllIllIllIllIlllIll, lllllllllllllIllIllIllIlllIIIIIl, 1) : null;
            final Matcher lllllllllllllIllIllIllIllIllllll = CommandBanIp.IP_PATTERN.matcher(lllllllllllllIllIllIllIlllIIIIIl[0]);
            if (lllllllllllllIllIllIllIllIllllll.matches()) {
                this.banIp(lllllllllllllIllIllIllIlllIIIIll, lllllllllllllIllIllIllIllIlllIll, lllllllllllllIllIllIllIlllIIIIIl[0], (lllllllllllllIllIllIllIlllIIIIII == null) ? null : lllllllllllllIllIllIllIlllIIIIII.getUnformattedText());
            }
            else {
                final EntityPlayerMP lllllllllllllIllIllIllIllIlllllI = lllllllllllllIllIllIllIlllIIIIll.getPlayerList().getPlayerByUsername(lllllllllllllIllIllIllIlllIIIIIl[0]);
                if (lllllllllllllIllIllIllIllIlllllI == null) {
                    throw new PlayerNotFoundException("commands.banip.invalid");
                }
                this.banIp(lllllllllllllIllIllIllIlllIIIIll, lllllllllllllIllIllIllIllIlllIll, lllllllllllllIllIllIllIllIlllllI.getPlayerIP(), (lllllllllllllIllIllIllIlllIIIIII == null) ? null : lllllllllllllIllIllIllIlllIIIIII.getUnformattedText());
            }
            return;
        }
        throw new WrongUsageException("commands.banip.usage", new Object[0]);
    }
    
    protected void banIp(final MinecraftServer lllllllllllllIllIllIllIllIIlIlll, final ICommandSender lllllllllllllIllIllIllIllIIlIllI, final String lllllllllllllIllIllIllIllIIlIlIl, @Nullable final String lllllllllllllIllIllIllIllIIllllI) {
        final UserListIPBansEntry lllllllllllllIllIllIllIllIIlllIl = new UserListIPBansEntry(lllllllllllllIllIllIllIllIIlIlIl, null, lllllllllllllIllIllIllIllIIlIllI.getName(), null, lllllllllllllIllIllIllIllIIllllI);
        ((UserList<K, UserListIPBansEntry>)lllllllllllllIllIllIllIllIIlIlll.getPlayerList().getBannedIPs()).addEntry(lllllllllllllIllIllIllIllIIlllIl);
        final List<EntityPlayerMP> lllllllllllllIllIllIllIllIIlllII = lllllllllllllIllIllIllIllIIlIlll.getPlayerList().getPlayersMatchingAddress(lllllllllllllIllIllIllIllIIlIlIl);
        final String[] lllllllllllllIllIllIllIllIIllIll = new String[lllllllllllllIllIllIllIllIIlllII.size()];
        int lllllllllllllIllIllIllIllIIllIlI = 0;
        for (final EntityPlayerMP lllllllllllllIllIllIllIllIIllIIl : lllllllllllllIllIllIllIllIIlllII) {
            lllllllllllllIllIllIllIllIIllIIl.connection.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.ip_banned", new Object[0]));
            lllllllllllllIllIllIllIllIIllIll[lllllllllllllIllIllIllIllIIllIlI++] = lllllllllllllIllIllIllIllIIllIIl.getName();
        }
        if (lllllllllllllIllIllIllIllIIlllII.isEmpty()) {
            CommandBase.notifyCommandListener(lllllllllllllIllIllIllIllIIlIllI, this, "commands.banip.success", lllllllllllllIllIllIllIllIIlIlIl);
        }
        else {
            CommandBase.notifyCommandListener(lllllllllllllIllIllIllIllIIlIllI, this, "commands.banip.success.players", lllllllllllllIllIllIllIllIIlIlIl, CommandBase.joinNiceString(lllllllllllllIllIllIllIllIIllIll));
        }
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIllIllIllIlllIIllII) {
        return "commands.banip.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIllIllIllIllIlIllll, final ICommandSender lllllllllllllIllIllIllIllIllIIlI, final String[] lllllllllllllIllIllIllIllIlIlllI, @Nullable final BlockPos lllllllllllllIllIllIllIllIllIIII) {
        return (lllllllllllllIllIllIllIllIlIlllI.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIllIllIllIllIlIlllI, lllllllllllllIllIllIllIllIlIllll.getAllUsernames()) : Collections.emptyList();
    }
    
    static {
        IP_PATTERN = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    }
    
    @Override
    public boolean checkPermission(final MinecraftServer lllllllllllllIllIllIllIlllIlIIlI, final ICommandSender lllllllllllllIllIllIllIlllIlIIIl) {
        return lllllllllllllIllIllIllIlllIlIIlI.getPlayerList().getBannedIPs().isLanServer() && super.checkPermission(lllllllllllllIllIllIllIlllIlIIlI, lllllllllllllIllIllIllIlllIlIIIl);
    }
}
