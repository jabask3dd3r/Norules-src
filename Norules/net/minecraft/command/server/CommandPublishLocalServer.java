package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.world.*;
import net.minecraft.command.*;

public class CommandPublishLocalServer extends CommandBase
{
    @Override
    public void execute(final MinecraftServer lllllllllllllIllIllllIIIIIIlllll, final ICommandSender lllllllllllllIllIllllIIIIIIllllI, final String[] lllllllllllllIllIllllIIIIIIlllIl) throws CommandException {
        final String lllllllllllllIllIllllIIIIIIlllII = lllllllllllllIllIllllIIIIIIlllll.shareToLAN(GameType.SURVIVAL, false);
        if (lllllllllllllIllIllllIIIIIIlllII != null) {
            CommandBase.notifyCommandListener(lllllllllllllIllIllllIIIIIIllllI, this, "commands.publish.started", lllllllllllllIllIllllIIIIIIlllII);
        }
        else {
            CommandBase.notifyCommandListener(lllllllllllllIllIllllIIIIIIllllI, this, "commands.publish.failed", new Object[0]);
        }
    }
    
    @Override
    public String getCommandName() {
        return "publish";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIllIllllIIIIIlIIlIl) {
        return "commands.publish.usage";
    }
}
