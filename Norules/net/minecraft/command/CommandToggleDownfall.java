package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.world.storage.*;

public class CommandToggleDownfall extends CommandBase
{
    protected void toggleRainfall(final MinecraftServer lllllllllllllIlllIlllIllIIlIIIIl) {
        final WorldInfo lllllllllllllIlllIlllIllIIlIIIlI = lllllllllllllIlllIlllIllIIlIIIIl.worldServers[0].getWorldInfo();
        lllllllllllllIlllIlllIllIIlIIIlI.setRaining(!lllllllllllllIlllIlllIllIIlIIIlI.isRaining());
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIlllIlllIllIIlIllII, final ICommandSender lllllllllllllIlllIlllIllIIlIIlll, final String[] lllllllllllllIlllIlllIllIIlIlIlI) throws CommandException {
        this.toggleRainfall(lllllllllllllIlllIlllIllIIlIllII);
        CommandBase.notifyCommandListener(lllllllllllllIlllIlllIllIIlIIlll, this, "commands.downfall.success", new Object[0]);
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIlllIlllIllIIllIIIl) {
        return "commands.downfall.usage";
    }
    
    @Override
    public String getCommandName() {
        return "toggledownfall";
    }
}
