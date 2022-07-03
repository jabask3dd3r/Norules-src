package net.minecraft.command;

import net.minecraft.server.*;

public class CommandSetPlayerTimeout extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIlIIlIlIIIllIlllIIl) {
        return "commands.setidletimeout.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public String getCommandName() {
        return "setidletimeout";
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIlIIlIlIIIllIlIIlll, final ICommandSender lllllllllllllIlIIlIlIIIllIIlllll, final String[] lllllllllllllIlIIlIlIIIllIlIIIll) throws CommandException {
        if (lllllllllllllIlIIlIlIIIllIlIIIll.length != 1) {
            throw new WrongUsageException("commands.setidletimeout.usage", new Object[0]);
        }
        final int lllllllllllllIlIIlIlIIIllIlIIIlI = CommandBase.parseInt(lllllllllllllIlIIlIlIIIllIlIIIll[0], 0);
        lllllllllllllIlIIlIlIIIllIlIIlll.setPlayerIdleTimeout(lllllllllllllIlIIlIlIIIllIlIIIlI);
        CommandBase.notifyCommandListener(lllllllllllllIlIIlIlIIIllIIlllll, this, "commands.setidletimeout.success", lllllllllllllIlIIlIlIIIllIlIIIlI);
    }
}
