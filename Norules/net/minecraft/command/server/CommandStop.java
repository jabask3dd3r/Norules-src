package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.command.*;

public class CommandStop extends CommandBase
{
    @Override
    public String getCommandName() {
        return "stop";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIlIllIllIlIIllllIIl) {
        return "commands.stop.usage";
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIlIllIllIlIIlllIIII, final ICommandSender lllllllllllllIlIllIllIlIIllIllll, final String[] lllllllllllllIlIllIllIlIIlllIIlI) throws CommandException {
        if (lllllllllllllIlIllIllIlIIlllIIII.worldServers != null) {
            CommandBase.notifyCommandListener(lllllllllllllIlIllIllIlIIllIllll, this, "commands.stop.start", new Object[0]);
        }
        lllllllllllllIlIllIllIlIIlllIIII.initiateShutdown();
    }
}
