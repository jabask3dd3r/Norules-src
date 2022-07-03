package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.command.*;
import net.minecraft.world.*;

public class CommandSaveOff extends CommandBase
{
    @Override
    public String getCommandName() {
        return "save-off";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lIIllIIllI) {
        return "commands.save-off.usage";
    }
    
    @Override
    public void execute(final MinecraftServer lIIlIlIlll, final ICommandSender lIIlIlllIl, final String[] lIIlIlllII) throws CommandException {
        boolean lIIlIllIll = false;
        for (int lIIlIllIlI = 0; lIIlIllIlI < lIIlIlIlll.worldServers.length; ++lIIlIllIlI) {
            if (lIIlIlIlll.worldServers[lIIlIllIlI] != null) {
                final WorldServer lIIlIllIIl = lIIlIlIlll.worldServers[lIIlIllIlI];
                if (!lIIlIllIIl.disableLevelSaving) {
                    lIIlIllIIl.disableLevelSaving = true;
                    lIIlIllIll = true;
                }
            }
        }
        if (lIIlIllIll) {
            CommandBase.notifyCommandListener(lIIlIlllIl, this, "commands.save.disabled", new Object[0]);
            return;
        }
        throw new CommandException("commands.save-off.alreadyOff", new Object[0]);
    }
}
