package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.command.*;
import net.minecraft.entity.*;
import net.minecraft.nbt.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;

public class CommandTestFor extends CommandBase
{
    @Override
    public void execute(final MinecraftServer lllllllllllllIIIIIIIlllIllllIlII, final ICommandSender lllllllllllllIIIIIIIlllIllllIIll, final String[] lllllllllllllIIIIIIIlllIlllllIlI) throws CommandException {
        if (lllllllllllllIIIIIIIlllIlllllIlI.length < 1) {
            throw new WrongUsageException("commands.testfor.usage", new Object[0]);
        }
        final Entity lllllllllllllIIIIIIIlllIlllllIIl = CommandBase.getEntity(lllllllllllllIIIIIIIlllIllllIlII, lllllllllllllIIIIIIIlllIllllIIll, lllllllllllllIIIIIIIlllIlllllIlI[0]);
        NBTTagCompound lllllllllllllIIIIIIIlllIlllllIII = null;
        if (lllllllllllllIIIIIIIlllIlllllIlI.length >= 2) {
            try {
                lllllllllllllIIIIIIIlllIlllllIII = JsonToNBT.getTagFromJson(CommandBase.buildString(lllllllllllllIIIIIIIlllIlllllIlI, 1));
            }
            catch (NBTException lllllllllllllIIIIIIIlllIllllIlll) {
                throw new CommandException("commands.testfor.tagError", new Object[] { lllllllllllllIIIIIIIlllIllllIlll.getMessage() });
            }
        }
        if (lllllllllllllIIIIIIIlllIlllllIII != null) {
            final NBTTagCompound lllllllllllllIIIIIIIlllIllllIllI = CommandBase.entityToNBT(lllllllllllllIIIIIIIlllIlllllIIl);
            if (!NBTUtil.areNBTEquals(lllllllllllllIIIIIIIlllIlllllIII, lllllllllllllIIIIIIIlllIllllIllI, true)) {
                throw new CommandException("commands.testfor.failure", new Object[] { lllllllllllllIIIIIIIlllIlllllIIl.getName() });
            }
        }
        CommandBase.notifyCommandListener(lllllllllllllIIIIIIIlllIllllIIll, this, "commands.testfor.success", lllllllllllllIIIIIIIlllIlllllIIl.getName());
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIIIIIIIlllIlllIIIlI, final ICommandSender lllllllllllllIIIIIIIlllIlllIIlIl, final String[] lllllllllllllIIIIIIIlllIlllIIIIl, @Nullable final BlockPos lllllllllllllIIIIIIIlllIlllIIIll) {
        return (lllllllllllllIIIIIIIlllIlllIIIIl.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIIIIIIlllIlllIIIIl, lllllllllllllIIIIIIIlllIlllIIIlI.getAllUsernames()) : Collections.emptyList();
    }
    
    @Override
    public String getCommandName() {
        return "testfor";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIIIIIIIllllIIIIIlIl) {
        return "commands.testfor.usage";
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllllIIIIIIIlllIlllIllII, final int lllllllllllllIIIIIIIlllIlllIlIlI) {
        return lllllllllllllIIIIIIIlllIlllIlIlI == 0;
    }
}
