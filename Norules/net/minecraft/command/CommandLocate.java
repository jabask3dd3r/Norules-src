package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.util.text.*;

public class CommandLocate extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIIllIIIlIIlIIIlIIl) {
        return "commands.locate.usage";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllllIIllIIIlIIIllllIII, final ICommandSender llllllllllllllIIllIIIlIIIlllIlll, final String[] llllllllllllllIIllIIIlIIIlllIllI, @Nullable final BlockPos llllllllllllllIIllIIIlIIIlllIlIl) {
        return (llllllllllllllIIllIIIlIIIlllIllI.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIllIIIlIIIlllIllI, "Stronghold", "Monument", "Village", "Mansion", "EndCity", "Fortress", "Temple", "Mineshaft") : Collections.emptyList();
    }
    
    @Override
    public String getCommandName() {
        return "locate";
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllIIllIIIlIIlIIIIIll, final ICommandSender llllllllllllllIIllIIIlIIIllllllI, final String[] llllllllllllllIIllIIIlIIlIIIIIIl) throws CommandException {
        if (llllllllllllllIIllIIIlIIlIIIIIIl.length != 1) {
            throw new WrongUsageException("commands.locate.usage", new Object[0]);
        }
        final String llllllllllllllIIllIIIlIIlIIIIIII = llllllllllllllIIllIIIlIIlIIIIIIl[0];
        final BlockPos llllllllllllllIIllIIIlIIIlllllll = llllllllllllllIIllIIIlIIIllllllI.getEntityWorld().func_190528_a(llllllllllllllIIllIIIlIIlIIIIIII, llllllllllllllIIllIIIlIIIllllllI.getPosition(), false);
        if (llllllllllllllIIllIIIlIIIlllllll != null) {
            llllllllllllllIIllIIIlIIIllllllI.addChatMessage(new TextComponentTranslation("commands.locate.success", new Object[] { llllllllllllllIIllIIIlIIlIIIIIII, llllllllllllllIIllIIIlIIIlllllll.getX(), llllllllllllllIIllIIIlIIIlllllll.getZ() }));
            return;
        }
        throw new CommandException("commands.locate.failure", new Object[] { llllllllllllllIIllIIIlIIlIIIIIII });
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
}
