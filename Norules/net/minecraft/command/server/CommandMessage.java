package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.text.*;
import net.minecraft.command.*;
import java.util.*;

public class CommandMessage extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllllIllIIIIIllIlIII) {
        return "commands.message.usage";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllllllIllIIIIIlIIlllI, final ICommandSender lllllllllllllllllIllIIIIIlIIllIl, final String[] lllllllllllllllllIllIIIIIlIIllII, @Nullable final BlockPos lllllllllllllllllIllIIIIIlIIlIll) {
        return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIllIIIIIlIIllII, lllllllllllllllllIllIIIIIlIIlllI.getAllUsernames());
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllllllllIllIIIIIlIIIllI, final int lllllllllllllllllIllIIIIIlIIIlIl) {
        return lllllllllllllllllIllIIIIIlIIIlIl == 0;
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllllllIllIIIIIlIllIII, final ICommandSender lllllllllllllllllIllIIIIIlIlIlll, final String[] lllllllllllllllllIllIIIIIlIlIllI) throws CommandException {
        if (lllllllllllllllllIllIIIIIlIlIllI.length < 2) {
            throw new WrongUsageException("commands.message.usage", new Object[0]);
        }
        final EntityPlayer lllllllllllllllllIllIIIIIlIlllII = CommandBase.getPlayer(lllllllllllllllllIllIIIIIlIllIII, lllllllllllllllllIllIIIIIlIlIlll, lllllllllllllllllIllIIIIIlIlIllI[0]);
        if (lllllllllllllllllIllIIIIIlIlllII == lllllllllllllllllIllIIIIIlIlIlll) {
            throw new PlayerNotFoundException("commands.message.sameTarget");
        }
        final ITextComponent lllllllllllllllllIllIIIIIlIllIll = CommandBase.getChatComponentFromNthArg(lllllllllllllllllIllIIIIIlIlIlll, lllllllllllllllllIllIIIIIlIlIllI, 1, !(lllllllllllllllllIllIIIIIlIlIlll instanceof EntityPlayer));
        final TextComponentTranslation lllllllllllllllllIllIIIIIlIllIlI = new TextComponentTranslation("commands.message.display.incoming", new Object[] { lllllllllllllllllIllIIIIIlIlIlll.getDisplayName(), lllllllllllllllllIllIIIIIlIllIll.createCopy() });
        final TextComponentTranslation lllllllllllllllllIllIIIIIlIllIIl = new TextComponentTranslation("commands.message.display.outgoing", new Object[] { lllllllllllllllllIllIIIIIlIlllII.getDisplayName(), lllllllllllllllllIllIIIIIlIllIll.createCopy() });
        lllllllllllllllllIllIIIIIlIllIlI.getStyle().setColor(TextFormatting.GRAY).setItalic(true);
        lllllllllllllllllIllIIIIIlIllIIl.getStyle().setColor(TextFormatting.GRAY).setItalic(true);
        lllllllllllllllllIllIIIIIlIlllII.addChatMessage(lllllllllllllllllIllIIIIIlIllIlI);
        lllllllllllllllllIllIIIIIlIlIlll.addChatMessage(lllllllllllllllllIllIIIIIlIllIIl);
    }
    
    @Override
    public String getCommandName() {
        return "tell";
    }
    
    @Override
    public List<String> getCommandAliases() {
        return Arrays.asList("w", "msg");
    }
}
