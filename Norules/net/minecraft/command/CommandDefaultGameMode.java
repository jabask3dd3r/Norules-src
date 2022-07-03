package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;

public class CommandDefaultGameMode extends CommandGameMode
{
    @Override
    public void execute(final MinecraftServer llllllllllllllIllllllIIIllllIlII, final ICommandSender llllllllllllllIllllllIIIllllIIll, final String[] llllllllllllllIllllllIIIlllIllIl) throws CommandException {
        if (llllllllllllllIllllllIIIlllIllIl.length <= 0) {
            throw new WrongUsageException("commands.defaultgamemode.usage", new Object[0]);
        }
        final GameType llllllllllllllIllllllIIIllllIIIl = this.getGameModeFromCommand(llllllllllllllIllllllIIIllllIIll, llllllllllllllIllllllIIIlllIllIl[0]);
        this.setDefaultGameType(llllllllllllllIllllllIIIllllIIIl, llllllllllllllIllllllIIIllllIlII);
        CommandBase.notifyCommandListener(llllllllllllllIllllllIIIllllIIll, this, "commands.defaultgamemode.success", new TextComponentTranslation(String.valueOf(new StringBuilder("gameMode.").append(llllllllllllllIllllllIIIllllIIIl.getName())), new Object[0]));
    }
    
    @Override
    public String getCommandName() {
        return "defaultgamemode";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIllllllIIIlllllIll) {
        return "commands.defaultgamemode.usage";
    }
    
    protected void setDefaultGameType(final GameType llllllllllllllIllllllIIIlllIIllI, final MinecraftServer llllllllllllllIllllllIIIlllIIIlI) {
        llllllllllllllIllllllIIIlllIIIlI.setGameType(llllllllllllllIllllllIIIlllIIllI);
        if (llllllllllllllIllllllIIIlllIIIlI.getForceGamemode()) {
            for (final EntityPlayerMP llllllllllllllIllllllIIIlllIIlII : llllllllllllllIllllllIIIlllIIIlI.getPlayerList().getPlayerList()) {
                llllllllllllllIllllllIIIlllIIlII.setGameType(llllllllllllllIllllllIIIlllIIllI);
            }
        }
    }
}
