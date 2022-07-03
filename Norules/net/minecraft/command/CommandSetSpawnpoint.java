package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.entity.player.*;

public class CommandSetSpawnpoint extends CommandBase
{
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllllllllIlIIlIIlllIIlII, final int lllllllllllllllllIlIIlIIlllIIIll) {
        return lllllllllllllllllIlIIlIIlllIIIll == 0;
    }
    
    @Override
    public String getCommandName() {
        return "spawnpoint";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllllllIlIIlIIlllIllIl, final ICommandSender lllllllllllllllllIlIIlIIlllIllII, final String[] lllllllllllllllllIlIIlIIlllIlIII, @Nullable final BlockPos lllllllllllllllllIlIIlIIlllIlIlI) {
        if (lllllllllllllllllIlIIlIIlllIlIII.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIlIIlIIlllIlIII, lllllllllllllllllIlIIlIIlllIllIl.getAllUsernames());
        }
        return (lllllllllllllllllIlIIlIIlllIlIII.length > 1 && lllllllllllllllllIlIIlIIlllIlIII.length <= 4) ? CommandBase.getTabCompletionCoordinate(lllllllllllllllllIlIIlIIlllIlIII, 1, lllllllllllllllllIlIIlIIlllIlIlI) : Collections.emptyList();
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllllIlIIlIlIIIIIlII) {
        return "commands.spawnpoint.usage";
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllllllIlIIlIIllllllII, final ICommandSender lllllllllllllllllIlIIlIIlllllIll, final String[] lllllllllllllllllIlIIlIIlllllIlI) throws CommandException {
        if (lllllllllllllllllIlIIlIIlllllIlI.length > 1 && lllllllllllllllllIlIIlIIlllllIlI.length < 4) {
            throw new WrongUsageException("commands.spawnpoint.usage", new Object[0]);
        }
        final EntityPlayerMP lllllllllllllllllIlIIlIIlllllIIl = (lllllllllllllllllIlIIlIIlllllIlI.length > 0) ? CommandBase.getPlayer(lllllllllllllllllIlIIlIIllllllII, lllllllllllllllllIlIIlIIlllllIll, lllllllllllllllllIlIIlIIlllllIlI[0]) : CommandBase.getCommandSenderAsPlayer(lllllllllllllllllIlIIlIIlllllIll);
        final BlockPos lllllllllllllllllIlIIlIIlllllIII = (lllllllllllllllllIlIIlIIlllllIlI.length > 3) ? CommandBase.parseBlockPos(lllllllllllllllllIlIIlIIlllllIll, lllllllllllllllllIlIIlIIlllllIlI, 1, true) : lllllllllllllllllIlIIlIIlllllIIl.getPosition();
        if (lllllllllllllllllIlIIlIIlllllIIl.world != null) {
            lllllllllllllllllIlIIlIIlllllIIl.setSpawnPoint(lllllllllllllllllIlIIlIIlllllIII, true);
            CommandBase.notifyCommandListener(lllllllllllllllllIlIIlIIlllllIll, this, "commands.spawnpoint.success", lllllllllllllllllIlIIlIIlllllIIl.getName(), lllllllllllllllllIlIIlIIlllllIII.getX(), lllllllllllllllllIlIIlIIlllllIII.getY(), lllllllllllllllllIlIIlIIlllllIII.getZ());
        }
    }
}
