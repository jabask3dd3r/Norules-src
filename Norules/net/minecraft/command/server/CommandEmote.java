package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.text.*;
import net.minecraft.command.*;

public class CommandEmote extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llIllIIIlIlIllI, final ICommandSender llIllIIIlIlIlIl, final String[] llIllIIIlIlIlII, @Nullable final BlockPos llIllIIIlIlIIll) {
        return CommandBase.getListOfStringsMatchingLastWord(llIllIIIlIlIlII, llIllIIIlIlIllI.getAllUsernames());
    }
    
    @Override
    public void execute(final MinecraftServer llIllIIIllIIIIl, final ICommandSender llIllIIIllIIIII, final String[] llIllIIIlIlllll) throws CommandException {
        if (llIllIIIlIlllll.length <= 0) {
            throw new WrongUsageException("commands.me.usage", new Object[0]);
        }
        final ITextComponent llIllIIIlIllllI = CommandBase.getChatComponentFromNthArg(llIllIIIllIIIII, llIllIIIlIlllll, 0, !(llIllIIIllIIIII instanceof EntityPlayer));
        llIllIIIllIIIIl.getPlayerList().sendChatMsg(new TextComponentTranslation("chat.type.emote", new Object[] { llIllIIIllIIIII.getDisplayName(), llIllIIIlIllllI }));
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llIllIIIllIIlll) {
        return "commands.me.usage";
    }
    
    @Override
    public String getCommandName() {
        return "me";
    }
}
