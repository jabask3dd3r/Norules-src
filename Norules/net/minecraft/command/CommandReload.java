package net.minecraft.command;

import net.minecraft.server.*;

public class CommandReload extends CommandBase
{
    @Override
    public String getCommandName() {
        return "reload";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllllIlIlIllIIlIllllI, final ICommandSender llllllllllllllllIlIlIllIIlIlllIl, final String[] llllllllllllllllIlIlIllIIlIlllII) throws CommandException {
        if (llllllllllllllllIlIlIllIIlIlllII.length > 0) {
            throw new WrongUsageException("commands.reload.usage", new Object[0]);
        }
        llllllllllllllllIlIlIllIIlIllllI.func_193031_aM();
        CommandBase.notifyCommandListener(llllllllllllllllIlIlIllIIlIlllIl, this, "commands.reload.success", new Object[0]);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllllIlIlIllIIllIlIII) {
        return "commands.reload.usage";
    }
}
