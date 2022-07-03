package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

public class CommandShowSeed extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIlllIlIIIIIIllIlIl) {
        return "commands.seed.usage";
    }
    
    @Override
    public String getCommandName() {
        return "seed";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllIlllIlIIIIIIllIIII, final ICommandSender llllllllllllllIlllIlIIIIIIlIlIll, final String[] llllllllllllllIlllIlIIIIIIlIlllI) throws CommandException {
        final World llllllllllllllIlllIlIIIIIIlIllIl = (llllllllllllllIlllIlIIIIIIlIlIll instanceof EntityPlayer) ? ((EntityPlayer)llllllllllllllIlllIlIIIIIIlIlIll).world : llllllllllllllIlllIlIIIIIIllIIII.worldServerForDimension(0);
        llllllllllllllIlllIlIIIIIIlIlIll.addChatMessage(new TextComponentTranslation("commands.seed.success", new Object[] { llllllllllllllIlllIlIIIIIIlIllIl.getSeed() }));
    }
    
    @Override
    public boolean checkPermission(final MinecraftServer llllllllllllllIlllIlIIIIIIllllIl, final ICommandSender llllllllllllllIlllIlIIIIIIllllII) {
        return llllllllllllllIlllIlIIIIIIllllIl.isSinglePlayer() || super.checkPermission(llllllllllllllIlllIlIIIIIIllllIl, llllllllllllllIlllIlIIIIIIllllII);
    }
}
