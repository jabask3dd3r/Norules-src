package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.util.text.*;
import net.minecraft.command.*;

public class CommandListPlayers extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    @Override
    public String getCommandName() {
        return "list";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIllllIIIIIIIlIIIll) {
        return "commands.players.usage";
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllIllllIIIIIIIIlllIl, final ICommandSender llllllllllllllIllllIIIIIIIIlllII, final String[] llllllllllllllIllllIIIIIIIIllIll) throws CommandException {
        final int llllllllllllllIllllIIIIIIIIllIlI = llllllllllllllIllllIIIIIIIIlllIl.getCurrentPlayerCount();
        llllllllllllllIllllIIIIIIIIlllII.addChatMessage(new TextComponentTranslation("commands.players.list", new Object[] { llllllllllllllIllllIIIIIIIIllIlI, llllllllllllllIllllIIIIIIIIlllIl.getMaxPlayers() }));
        llllllllllllllIllllIIIIIIIIlllII.addChatMessage(new TextComponentString(llllllllllllllIllllIIIIIIIIlllIl.getPlayerList().getFormattedListOfPlayers(llllllllllllllIllllIIIIIIIIllIll.length > 0 && "uuids".equalsIgnoreCase(llllllllllllllIllllIIIIIIIIllIll[0]))));
        llllllllllllllIllllIIIIIIIIlllII.setCommandStat(CommandResultStats.Type.QUERY_RESULT, llllllllllllllIllllIIIIIIIIllIlI);
    }
}
