package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.command.*;
import com.mojang.authlib.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;

public class CommandDeOp extends CommandBase
{
    @Override
    public void execute(final MinecraftServer lllllllllllllIlllIIIIIIIlllIIlII, final ICommandSender lllllllllllllIlllIIIIIIIllIllllI, final String[] lllllllllllllIlllIIIIIIIllIlllIl) throws CommandException {
        if (lllllllllllllIlllIIIIIIIllIlllIl.length != 1 || lllllllllllllIlllIIIIIIIllIlllIl[0].length() <= 0) {
            throw new WrongUsageException("commands.deop.usage", new Object[0]);
        }
        final GameProfile lllllllllllllIlllIIIIIIIlllIIIIl = lllllllllllllIlllIIIIIIIlllIIlII.getPlayerList().getOppedPlayers().getGameProfileFromName(lllllllllllllIlllIIIIIIIllIlllIl[0]);
        if (lllllllllllllIlllIIIIIIIlllIIIIl == null) {
            throw new CommandException("commands.deop.failed", new Object[] { lllllllllllllIlllIIIIIIIllIlllIl[0] });
        }
        lllllllllllllIlllIIIIIIIlllIIlII.getPlayerList().removeOp(lllllllllllllIlllIIIIIIIlllIIIIl);
        CommandBase.notifyCommandListener(lllllllllllllIlllIIIIIIIllIllllI, this, "commands.deop.success", lllllllllllllIlllIIIIIIIllIlllIl[0]);
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIlllIIIIIIIlllIlIll) {
        return "commands.deop.usage";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIlllIIIIIIIllIlIlII, final ICommandSender lllllllllllllIlllIIIIIIIllIlIlll, final String[] lllllllllllllIlllIIIIIIIllIlIllI, @Nullable final BlockPos lllllllllllllIlllIIIIIIIllIlIlIl) {
        return (lllllllllllllIlllIIIIIIIllIlIllI.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIlllIIIIIIIllIlIllI, lllllllllllllIlllIIIIIIIllIlIlII.getPlayerList().getOppedPlayerNames()) : Collections.emptyList();
    }
    
    @Override
    public String getCommandName() {
        return "deop";
    }
}
