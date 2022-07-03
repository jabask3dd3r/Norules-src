package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.util.text.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;

public class CommandServerKick extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIIllIIlIlIlIIIllIll) {
        return "commands.kick.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public String getCommandName() {
        return "kick";
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIIllIIlIlIlIIIIllIl, final ICommandSender lllllllllllllIIllIIlIlIlIIIlIIlI, final String[] lllllllllllllIIllIIlIlIlIIIlIIIl) throws CommandException {
        if (lllllllllllllIIllIIlIlIlIIIlIIIl.length <= 0 || lllllllllllllIIllIIlIlIlIIIlIIIl[0].length() <= 1) {
            throw new WrongUsageException("commands.kick.usage", new Object[0]);
        }
        final EntityPlayerMP lllllllllllllIIllIIlIlIlIIIlIIII = lllllllllllllIIllIIlIlIlIIIIllIl.getPlayerList().getPlayerByUsername(lllllllllllllIIllIIlIlIlIIIlIIIl[0]);
        if (lllllllllllllIIllIIlIlIlIIIlIIII == null) {
            throw new PlayerNotFoundException("commands.generic.player.notFound", new Object[] { lllllllllllllIIllIIlIlIlIIIlIIIl[0] });
        }
        if (lllllllllllllIIllIIlIlIlIIIlIIIl.length >= 2) {
            final ITextComponent lllllllllllllIIllIIlIlIlIIIIllll = CommandBase.getChatComponentFromNthArg(lllllllllllllIIllIIlIlIlIIIlIIlI, lllllllllllllIIllIIlIlIlIIIlIIIl, 1);
            lllllllllllllIIllIIlIlIlIIIlIIII.connection.func_194028_b(lllllllllllllIIllIIlIlIlIIIIllll);
            CommandBase.notifyCommandListener(lllllllllllllIIllIIlIlIlIIIlIIlI, this, "commands.kick.success.reason", lllllllllllllIIllIIlIlIlIIIlIIII.getName(), lllllllllllllIIllIIlIlIlIIIIllll.getUnformattedText());
        }
        else {
            lllllllllllllIIllIIlIlIlIIIlIIII.connection.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.kicked", new Object[0]));
            CommandBase.notifyCommandListener(lllllllllllllIIllIIlIlIlIIIlIIlI, this, "commands.kick.success", lllllllllllllIIllIIlIlIlIIIlIIII.getName());
        }
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIIllIIlIlIlIIIIIlIl, final ICommandSender lllllllllllllIIllIIlIlIlIIIIIlII, final String[] lllllllllllllIIllIIlIlIlIIIIIIII, @Nullable final BlockPos lllllllllllllIIllIIlIlIlIIIIIIlI) {
        return (lllllllllllllIIllIIlIlIlIIIIIIII.length >= 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIllIIlIlIlIIIIIIII, lllllllllllllIIllIIlIlIlIIIIIlIl.getAllUsernames()) : Collections.emptyList();
    }
}
