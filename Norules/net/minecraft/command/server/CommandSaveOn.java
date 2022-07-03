package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.command.*;
import net.minecraft.world.*;

public class CommandSaveOn extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIIlIlIIlIlIlllIlIl) {
        return "commands.save-on.usage";
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllIIlIlIIlIlIllIIllI, final ICommandSender llllllllllllllIIlIlIIlIlIllIllII, final String[] llllllllllllllIIlIlIIlIlIllIlIll) throws CommandException {
        boolean llllllllllllllIIlIlIIlIlIllIlIlI = false;
        for (int llllllllllllllIIlIlIIlIlIllIlIIl = 0; llllllllllllllIIlIlIIlIlIllIlIIl < llllllllllllllIIlIlIIlIlIllIIllI.worldServers.length; ++llllllllllllllIIlIlIIlIlIllIlIIl) {
            if (llllllllllllllIIlIlIIlIlIllIIllI.worldServers[llllllllllllllIIlIlIIlIlIllIlIIl] != null) {
                final WorldServer llllllllllllllIIlIlIIlIlIllIlIII = llllllllllllllIIlIlIIlIlIllIIllI.worldServers[llllllllllllllIIlIlIIlIlIllIlIIl];
                if (llllllllllllllIIlIlIIlIlIllIlIII.disableLevelSaving) {
                    llllllllllllllIIlIlIIlIlIllIlIII.disableLevelSaving = false;
                    llllllllllllllIIlIlIIlIlIllIlIlI = true;
                }
            }
        }
        if (llllllllllllllIIlIlIIlIlIllIlIlI) {
            CommandBase.notifyCommandListener(llllllllllllllIIlIlIIlIlIllIllII, this, "commands.save.enabled", new Object[0]);
            return;
        }
        throw new CommandException("commands.save-on.alreadyOn", new Object[0]);
    }
    
    @Override
    public String getCommandName() {
        return "save-on";
    }
}
