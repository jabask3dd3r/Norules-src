package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.util.text.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;

public class CommandGameMode extends CommandBase
{
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllllIlIIIlIllIlIlllIII, final int llllllllllllllIlIIIlIllIlIllIlll) {
        return llllllllllllllIlIIIlIllIlIllIlll == 1;
    }
    
    @Override
    public String getCommandName() {
        return "gamemode";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllIlIIIlIllIllIlIIIl, final ICommandSender llllllllllllllIlIIIlIllIllIlIlll, final String[] llllllllllllllIlIIIlIllIllIlIllI) throws CommandException {
        if (llllllllllllllIlIIIlIllIllIlIllI.length <= 0) {
            throw new WrongUsageException("commands.gamemode.usage", new Object[0]);
        }
        final GameType llllllllllllllIlIIIlIllIllIlIlIl = this.getGameModeFromCommand(llllllllllllllIlIIIlIllIllIlIlll, llllllllllllllIlIIIlIllIllIlIllI[0]);
        final EntityPlayer llllllllllllllIlIIIlIllIllIlIlII = (llllllllllllllIlIIIlIllIllIlIllI.length >= 2) ? CommandBase.getPlayer(llllllllllllllIlIIIlIllIllIlIIIl, llllllllllllllIlIIIlIllIllIlIlll, llllllllllllllIlIIIlIllIllIlIllI[1]) : CommandBase.getCommandSenderAsPlayer(llllllllllllllIlIIIlIllIllIlIlll);
        llllllllllllllIlIIIlIllIllIlIlII.setGameType(llllllllllllllIlIIIlIllIllIlIlIl);
        final ITextComponent llllllllllllllIlIIIlIllIllIlIIll = new TextComponentTranslation(String.valueOf(new StringBuilder("gameMode.").append(llllllllllllllIlIIIlIllIllIlIlIl.getName())), new Object[0]);
        if (llllllllllllllIlIIIlIllIllIlIlll.getEntityWorld().getGameRules().getBoolean("sendCommandFeedback")) {
            llllllllllllllIlIIIlIllIllIlIlII.addChatMessage(new TextComponentTranslation("gameMode.changed", new Object[] { llllllllllllllIlIIIlIllIllIlIIll }));
        }
        if (llllllllllllllIlIIIlIllIllIlIlII == llllllllllllllIlIIIlIllIllIlIlll) {
            CommandBase.notifyCommandListener(llllllllllllllIlIIIlIllIllIlIlll, this, 1, "commands.gamemode.success.self", llllllllllllllIlIIIlIllIllIlIIll);
        }
        else {
            CommandBase.notifyCommandListener(llllllllllllllIlIIIlIllIllIlIlll, this, 1, "commands.gamemode.success.other", llllllllllllllIlIIIlIllIllIlIlII.getName(), llllllllllllllIlIIIlIllIllIlIIll);
        }
    }
    
    protected GameType getGameModeFromCommand(final ICommandSender llllllllllllllIlIIIlIllIllIIlIII, final String llllllllllllllIlIIIlIllIllIIIlIl) throws CommandException, NumberInvalidException {
        final GameType llllllllllllllIlIIIlIllIllIIIllI = GameType.parseGameTypeWithDefault(llllllllllllllIlIIIlIllIllIIIlIl, GameType.NOT_SET);
        return (llllllllllllllIlIIIlIllIllIIIllI == GameType.NOT_SET) ? WorldSettings.getGameTypeById(CommandBase.parseInt(llllllllllllllIlIIIlIllIllIIIlIl, 0, GameType.values().length - 2)) : llllllllllllllIlIIIlIllIllIIIllI;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIlIIIlIllIlllIIIIl) {
        return "commands.gamemode.usage";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllllIlIIIlIllIlIllllII, final ICommandSender llllllllllllllIlIIIlIllIlIllllll, final String[] llllllllllllllIlIIIlIllIlIlllIll, @Nullable final BlockPos llllllllllllllIlIIIlIllIlIllllIl) {
        if (llllllllllllllIlIIIlIllIlIlllIll.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIlIIIlIllIlIlllIll, "survival", "creative", "adventure", "spectator");
        }
        return (llllllllllllllIlIIIlIllIlIlllIll.length == 2) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIlIIIlIllIlIlllIll, llllllllllllllIlIIIlIllIlIllllII.getAllUsernames()) : Collections.emptyList();
    }
}
