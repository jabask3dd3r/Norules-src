package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.util.math.*;
import net.minecraft.command.*;
import javax.annotation.*;
import java.util.*;

public class CommandSetDefaultSpawnpoint extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllllIlIIIIIlIIIlllIl, final ICommandSender llllllllllllllllIlIIIIIlIIIlIllI, final String[] llllllllllllllllIlIIIIIlIIIllIll) throws CommandException {
        BlockPos llllllllllllllllIlIIIIIlIIIllIIl = null;
        if (llllllllllllllllIlIIIIIlIIIllIll.length == 0) {
            final BlockPos llllllllllllllllIlIIIIIlIIIllIlI = CommandBase.getCommandSenderAsPlayer(llllllllllllllllIlIIIIIlIIIlIllI).getPosition();
        }
        else {
            if (llllllllllllllllIlIIIIIlIIIllIll.length != 3 || llllllllllllllllIlIIIIIlIIIlIllI.getEntityWorld() == null) {
                throw new WrongUsageException("commands.setworldspawn.usage", new Object[0]);
            }
            llllllllllllllllIlIIIIIlIIIllIIl = CommandBase.parseBlockPos(llllllllllllllllIlIIIIIlIIIlIllI, llllllllllllllllIlIIIIIlIIIllIll, 0, true);
        }
        llllllllllllllllIlIIIIIlIIIlIllI.getEntityWorld().setSpawnPoint(llllllllllllllllIlIIIIIlIIIllIIl);
        llllllllllllllllIlIIIIIlIIIlllIl.getPlayerList().sendPacketToAllPlayers(new SPacketSpawnPosition(llllllllllllllllIlIIIIIlIIIllIIl));
        CommandBase.notifyCommandListener(llllllllllllllllIlIIIIIlIIIlIllI, this, "commands.setworldspawn.success", llllllllllllllllIlIIIIIlIIIllIIl.getX(), llllllllllllllllIlIIIIIlIIIllIIl.getY(), llllllllllllllllIlIIIIIlIIIllIIl.getZ());
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllllllIlIIIIIlIIIlIIII, final ICommandSender llllllllllllllllIlIIIIIlIIIIllll, final String[] llllllllllllllllIlIIIIIlIIIIlllI, @Nullable final BlockPos llllllllllllllllIlIIIIIlIIIIllIl) {
        return (llllllllllllllllIlIIIIIlIIIIlllI.length > 0 && llllllllllllllllIlIIIIIlIIIIlllI.length <= 3) ? CommandBase.getTabCompletionCoordinate(llllllllllllllllIlIIIIIlIIIIlllI, 0, llllllllllllllllIlIIIIIlIIIIllIl) : Collections.emptyList();
    }
    
    @Override
    public String getCommandName() {
        return "setworldspawn";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllllIlIIIIIlIIlIIlII) {
        return "commands.setworldspawn.usage";
    }
}
