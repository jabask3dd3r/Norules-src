package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.util.text.*;
import net.minecraft.command.*;

public class CommandBroadcast extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIlIlIIlllIllIIIIIlI) {
        return "commands.say.usage";
    }
    
    @Override
    public String getCommandName() {
        return "say";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIlIlIIlllIlIlllIIIl, final ICommandSender lllllllllllllIlIlIIlllIlIlllIIII, final String[] lllllllllllllIlIlIIlllIlIllIllll, @Nullable final BlockPos lllllllllllllIlIlIIlllIlIllIlllI) {
        return (lllllllllllllIlIlIIlllIlIllIllll.length >= 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIlIlIIlllIlIllIllll, lllllllllllllIlIlIIlllIlIlllIIIl.getAllUsernames()) : Collections.emptyList();
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 1;
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIlIlIIlllIlIlllllII, final ICommandSender lllllllllllllIlIlIIlllIlIlllIlll, final String[] lllllllllllllIlIlIIlllIlIllllIlI) throws CommandException {
        if (lllllllllllllIlIlIIlllIlIllllIlI.length > 0 && lllllllllllllIlIlIIlllIlIllllIlI[0].length() > 0) {
            final ITextComponent lllllllllllllIlIlIIlllIlIllllIIl = CommandBase.getChatComponentFromNthArg(lllllllllllllIlIlIIlllIlIlllIlll, lllllllllllllIlIlIIlllIlIllllIlI, 0, true);
            lllllllllllllIlIlIIlllIlIlllllII.getPlayerList().sendChatMsg(new TextComponentTranslation("chat.type.announcement", new Object[] { lllllllllllllIlIlIIlllIlIlllIlll.getDisplayName(), lllllllllllllIlIlIIlllIlIllllIIl }));
            return;
        }
        throw new WrongUsageException("commands.say.usage", new Object[0]);
    }
}
