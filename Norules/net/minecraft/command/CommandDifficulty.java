package net.minecraft.command;

import net.minecraft.world.*;
import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.util.text.*;

public class CommandDifficulty extends CommandBase
{
    @Override
    public String getCommandName() {
        return "difficulty";
    }
    
    protected EnumDifficulty getDifficultyFromCommand(final String lllllllllllllllllIlIIllIlIIIIIlI) throws CommandException, NumberInvalidException {
        if ("peaceful".equalsIgnoreCase(lllllllllllllllllIlIIllIlIIIIIlI) || "p".equalsIgnoreCase(lllllllllllllllllIlIIllIlIIIIIlI)) {
            return EnumDifficulty.PEACEFUL;
        }
        if ("easy".equalsIgnoreCase(lllllllllllllllllIlIIllIlIIIIIlI) || "e".equalsIgnoreCase(lllllllllllllllllIlIIllIlIIIIIlI)) {
            return EnumDifficulty.EASY;
        }
        if (!"normal".equalsIgnoreCase(lllllllllllllllllIlIIllIlIIIIIlI) && !"n".equalsIgnoreCase(lllllllllllllllllIlIIllIlIIIIIlI)) {
            return (!"hard".equalsIgnoreCase(lllllllllllllllllIlIIllIlIIIIIlI) && !"h".equalsIgnoreCase(lllllllllllllllllIlIIllIlIIIIIlI)) ? EnumDifficulty.getDifficultyEnum(CommandBase.parseInt(lllllllllllllllllIlIIllIlIIIIIlI, 0, 3)) : EnumDifficulty.HARD;
        }
        return EnumDifficulty.NORMAL;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllllllIlIIllIIlllllll, final ICommandSender lllllllllllllllllIlIIllIIllllllI, final String[] lllllllllllllllllIlIIllIIlllllIl, @Nullable final BlockPos lllllllllllllllllIlIIllIIlllllII) {
        return (lllllllllllllllllIlIIllIIlllllIl.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIlIIllIIlllllIl, "peaceful", "easy", "normal", "hard") : Collections.emptyList();
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllllIlIIllIlIIlIlIl) {
        return "commands.difficulty.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllllllIlIIllIlIIIlllI, final ICommandSender lllllllllllllllllIlIIllIlIIIllIl, final String[] lllllllllllllllllIlIIllIlIIIllII) throws CommandException {
        if (lllllllllllllllllIlIIllIlIIIllII.length <= 0) {
            throw new WrongUsageException("commands.difficulty.usage", new Object[0]);
        }
        final EnumDifficulty lllllllllllllllllIlIIllIlIIIlIll = this.getDifficultyFromCommand(lllllllllllllllllIlIIllIlIIIllII[0]);
        lllllllllllllllllIlIIllIlIIIlllI.setDifficultyForAllWorlds(lllllllllllllllllIlIIllIlIIIlIll);
        CommandBase.notifyCommandListener(lllllllllllllllllIlIIllIlIIIllIl, this, "commands.difficulty.success", new TextComponentTranslation(lllllllllllllllllIlIIllIlIIIlIll.getDifficultyResourceKey(), new Object[0]));
    }
}
