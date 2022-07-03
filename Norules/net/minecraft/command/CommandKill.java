package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;

public class CommandKill extends CommandBase
{
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIIIlIIllIIIIlIlIllI, final ICommandSender lllllllllllllIIIlIIllIIIIlIllIIl, final String[] lllllllllllllIIIlIIllIIIIlIllIII, @Nullable final BlockPos lllllllllllllIIIlIIllIIIIlIlIlll) {
        return (lllllllllllllIIIlIIllIIIIlIllIII.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIIlIIllIIIIlIllIII, lllllllllllllIIIlIIllIIIIlIlIllI.getAllUsernames()) : Collections.emptyList();
    }
    
    @Override
    public String getCommandName() {
        return "kill";
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllllIIIlIIllIIIIllIIIII, final int lllllllllllllIIIlIIllIIIIlIllllI) {
        return lllllllllllllIIIlIIllIIIIlIllllI == 0;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIIIlIIllIIIIlllIIll) {
        return "commands.kill.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIIIlIIllIIIIllIllII, final ICommandSender lllllllllllllIIIlIIllIIIIllIlIll, final String[] lllllllllllllIIIlIIllIIIIllIIlII) throws CommandException {
        if (lllllllllllllIIIlIIllIIIIllIIlII.length == 0) {
            final EntityPlayer lllllllllllllIIIlIIllIIIIllIlIIl = CommandBase.getCommandSenderAsPlayer(lllllllllllllIIIlIIllIIIIllIlIll);
            lllllllllllllIIIlIIllIIIIllIlIIl.onKillCommand();
            CommandBase.notifyCommandListener(lllllllllllllIIIlIIllIIIIllIlIll, this, "commands.kill.successful", lllllllllllllIIIlIIllIIIIllIlIIl.getDisplayName());
        }
        else {
            final Entity lllllllllllllIIIlIIllIIIIllIlIII = CommandBase.getEntity(lllllllllllllIIIlIIllIIIIllIllII, lllllllllllllIIIlIIllIIIIllIlIll, lllllllllllllIIIlIIllIIIIllIIlII[0]);
            lllllllllllllIIIlIIllIIIIllIlIII.onKillCommand();
            CommandBase.notifyCommandListener(lllllllllllllIIIlIIllIIIIllIlIll, this, "commands.kill.successful", lllllllllllllIIIlIIllIIIIllIlIII.getDisplayName());
        }
    }
}
