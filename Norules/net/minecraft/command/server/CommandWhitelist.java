package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.util.text.*;
import net.minecraft.command.*;
import com.mojang.authlib.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;

public class CommandWhitelist extends CommandBase
{
    @Override
    public void execute(final MinecraftServer lllllllllllllIIlIIIllllIIlIIIIll, final ICommandSender lllllllllllllIIlIIIllllIIlIIIIlI, final String[] lllllllllllllIIlIIIllllIIIlllIlI) throws CommandException {
        if (lllllllllllllIIlIIIllllIIIlllIlI.length < 1) {
            throw new WrongUsageException("commands.whitelist.usage", new Object[0]);
        }
        if ("on".equals(lllllllllllllIIlIIIllllIIIlllIlI[0])) {
            lllllllllllllIIlIIIllllIIlIIIIll.getPlayerList().setWhiteListEnabled(true);
            CommandBase.notifyCommandListener(lllllllllllllIIlIIIllllIIlIIIIlI, this, "commands.whitelist.enabled", new Object[0]);
        }
        else if ("off".equals(lllllllllllllIIlIIIllllIIIlllIlI[0])) {
            lllllllllllllIIlIIIllllIIlIIIIll.getPlayerList().setWhiteListEnabled(false);
            CommandBase.notifyCommandListener(lllllllllllllIIlIIIllllIIlIIIIlI, this, "commands.whitelist.disabled", new Object[0]);
        }
        else if ("list".equals(lllllllllllllIIlIIIllllIIIlllIlI[0])) {
            lllllllllllllIIlIIIllllIIlIIIIlI.addChatMessage(new TextComponentTranslation("commands.whitelist.list", new Object[] { lllllllllllllIIlIIIllllIIlIIIIll.getPlayerList().getWhitelistedPlayerNames().length, lllllllllllllIIlIIIllllIIlIIIIll.getPlayerList().getAvailablePlayerDat().length }));
            final String[] lllllllllllllIIlIIIllllIIlIIIIII = lllllllllllllIIlIIIllllIIlIIIIll.getPlayerList().getWhitelistedPlayerNames();
            lllllllllllllIIlIIIllllIIlIIIIlI.addChatMessage(new TextComponentString(CommandBase.joinNiceString(lllllllllllllIIlIIIllllIIlIIIIII)));
        }
        else if ("add".equals(lllllllllllllIIlIIIllllIIIlllIlI[0])) {
            if (lllllllllllllIIlIIIllllIIIlllIlI.length < 2) {
                throw new WrongUsageException("commands.whitelist.add.usage", new Object[0]);
            }
            final GameProfile lllllllllllllIIlIIIllllIIIllllll = lllllllllllllIIlIIIllllIIlIIIIll.getPlayerProfileCache().getGameProfileForUsername(lllllllllllllIIlIIIllllIIIlllIlI[1]);
            if (lllllllllllllIIlIIIllllIIIllllll == null) {
                throw new CommandException("commands.whitelist.add.failed", new Object[] { lllllllllllllIIlIIIllllIIIlllIlI[1] });
            }
            lllllllllllllIIlIIIllllIIlIIIIll.getPlayerList().addWhitelistedPlayer(lllllllllllllIIlIIIllllIIIllllll);
            CommandBase.notifyCommandListener(lllllllllllllIIlIIIllllIIlIIIIlI, this, "commands.whitelist.add.success", lllllllllllllIIlIIIllllIIIlllIlI[1]);
        }
        else if ("remove".equals(lllllllllllllIIlIIIllllIIIlllIlI[0])) {
            if (lllllllllllllIIlIIIllllIIIlllIlI.length < 2) {
                throw new WrongUsageException("commands.whitelist.remove.usage", new Object[0]);
            }
            final GameProfile lllllllllllllIIlIIIllllIIIlllllI = lllllllllllllIIlIIIllllIIlIIIIll.getPlayerList().getWhitelistedPlayers().getByName(lllllllllllllIIlIIIllllIIIlllIlI[1]);
            if (lllllllllllllIIlIIIllllIIIlllllI == null) {
                throw new CommandException("commands.whitelist.remove.failed", new Object[] { lllllllllllllIIlIIIllllIIIlllIlI[1] });
            }
            lllllllllllllIIlIIIllllIIlIIIIll.getPlayerList().removePlayerFromWhitelist(lllllllllllllIIlIIIllllIIIlllllI);
            CommandBase.notifyCommandListener(lllllllllllllIIlIIIllllIIlIIIIlI, this, "commands.whitelist.remove.success", lllllllllllllIIlIIIllllIIIlllIlI[1]);
        }
        else if ("reload".equals(lllllllllllllIIlIIIllllIIIlllIlI[0])) {
            lllllllllllllIIlIIIllllIIlIIIIll.getPlayerList().reloadWhitelist();
            CommandBase.notifyCommandListener(lllllllllllllIIlIIIllllIIlIIIIlI, this, "commands.whitelist.reloaded", new Object[0]);
        }
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIIlIIIllllIIIllIIIl, final ICommandSender lllllllllllllIIlIIIllllIIIllIlII, final String[] lllllllllllllIIlIIIllllIIIllIIII, @Nullable final BlockPos lllllllllllllIIlIIIllllIIIllIIlI) {
        if (lllllllllllllIIlIIIllllIIIllIIII.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIlIIIllllIIIllIIII, "on", "off", "list", "add", "remove", "reload");
        }
        if (lllllllllllllIIlIIIllllIIIllIIII.length == 2) {
            if ("remove".equals(lllllllllllllIIlIIIllllIIIllIIII[0])) {
                return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIlIIIllllIIIllIIII, lllllllllllllIIlIIIllllIIIllIIIl.getPlayerList().getWhitelistedPlayerNames());
            }
            if ("add".equals(lllllllllllllIIlIIIllllIIIllIIII[0])) {
                return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIlIIIllllIIIllIIII, lllllllllllllIIlIIIllllIIIllIIIl.getPlayerProfileCache().getUsernames());
            }
        }
        return Collections.emptyList();
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIIlIIIllllIIlIIlIlI) {
        return "commands.whitelist.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public String getCommandName() {
        return "whitelist";
    }
}
