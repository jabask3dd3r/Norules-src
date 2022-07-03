package net.minecraft.command;

import net.minecraft.server.*;
import javax.annotation.*;
import net.minecraft.block.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;

public class CommandExecuteAt extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllllIIlIlIllIIlIIIllll, final int llllllllllllllIIlIlIllIIlIIIllIl) {
        return llllllllllllllIIlIlIllIIlIIIllIl == 0;
    }
    
    @Override
    public String getCommandName() {
        return "execute";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIIlIlIllIIllIlIIlI) {
        return "commands.execute.usage";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllllIIlIlIllIIlIIllIII, final ICommandSender llllllllllllllIIlIlIllIIlIIlIlll, final String[] llllllllllllllIIlIlIllIIlIIlIIll, @Nullable final BlockPos llllllllllllllIIlIlIllIIlIIlIlIl) {
        if (llllllllllllllIIlIlIllIIlIIlIIll.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIlIlIllIIlIIlIIll, llllllllllllllIIlIlIllIIlIIllIII.getAllUsernames());
        }
        if (llllllllllllllIIlIlIllIIlIIlIIll.length > 1 && llllllllllllllIIlIlIllIIlIIlIIll.length <= 4) {
            return CommandBase.getTabCompletionCoordinate(llllllllllllllIIlIlIllIIlIIlIIll, 1, llllllllllllllIIlIlIllIIlIIlIlIl);
        }
        if (llllllllllllllIIlIlIllIIlIIlIIll.length > 5 && llllllllllllllIIlIlIllIIlIIlIIll.length <= 8 && "detect".equals(llllllllllllllIIlIlIllIIlIIlIIll[4])) {
            return CommandBase.getTabCompletionCoordinate(llllllllllllllIIlIlIllIIlIIlIIll, 5, llllllllllllllIIlIlIllIIlIIlIlIl);
        }
        return (llllllllllllllIIlIlIllIIlIIlIIll.length == 9 && "detect".equals(llllllllllllllIIlIlIllIIlIIlIIll[4])) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIlIlIllIIlIIlIIll, Block.REGISTRY.getKeys()) : Collections.emptyList();
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllIIlIlIllIIlIlIllII, final ICommandSender llllllllllllllIIlIlIllIIlIlIlIll, final String[] llllllllllllllIIlIlIllIIlIlllllI) throws CommandException {
        if (llllllllllllllIIlIlIllIIlIlllllI.length < 5) {
            throw new WrongUsageException("commands.execute.usage", new Object[0]);
        }
        final Entity llllllllllllllIIlIlIllIIlIllllIl = CommandBase.getEntity(llllllllllllllIIlIlIllIIlIlIllII, llllllllllllllIIlIlIllIIlIlIlIll, llllllllllllllIIlIlIllIIlIlllllI[0], (Class<? extends Entity>)Entity.class);
        final double llllllllllllllIIlIlIllIIlIllllII = CommandBase.parseDouble(llllllllllllllIIlIlIllIIlIllllIl.posX, llllllllllllllIIlIlIllIIlIlllllI[1], false);
        final double llllllllllllllIIlIlIllIIlIlllIll = CommandBase.parseDouble(llllllllllllllIIlIlIllIIlIllllIl.posY, llllllllllllllIIlIlIllIIlIlllllI[2], false);
        final double llllllllllllllIIlIlIllIIlIlllIlI = CommandBase.parseDouble(llllllllllllllIIlIlIllIIlIllllIl.posZ, llllllllllllllIIlIlIllIIlIlllllI[3], false);
        new BlockPos(llllllllllllllIIlIlIllIIlIllllII, llllllllllllllIIlIlIllIIlIlllIll, llllllllllllllIIlIlIllIIlIlllIlI);
        int llllllllllllllIIlIlIllIIlIlllIIl = 4;
        if ("detect".equals(llllllllllllllIIlIlIllIIlIlllllI[4]) && llllllllllllllIIlIlIllIIlIlllllI.length > 10) {
            final World llllllllllllllIIlIlIllIIlIlllIII = llllllllllllllIIlIlIllIIlIllllIl.getEntityWorld();
            final double llllllllllllllIIlIlIllIIlIllIlll = CommandBase.parseDouble(llllllllllllllIIlIlIllIIlIllllII, llllllllllllllIIlIlIllIIlIlllllI[5], false);
            final double llllllllllllllIIlIlIllIIlIllIllI = CommandBase.parseDouble(llllllllllllllIIlIlIllIIlIlllIll, llllllllllllllIIlIlIllIIlIlllllI[6], false);
            final double llllllllllllllIIlIlIllIIlIllIlIl = CommandBase.parseDouble(llllllllllllllIIlIlIllIIlIlllIlI, llllllllllllllIIlIlIllIIlIlllllI[7], false);
            final Block llllllllllllllIIlIlIllIIlIllIlII = CommandBase.getBlockByText(llllllllllllllIIlIlIllIIlIlIlIll, llllllllllllllIIlIlIllIIlIlllllI[8]);
            final BlockPos llllllllllllllIIlIlIllIIlIllIIll = new BlockPos(llllllllllllllIIlIlIllIIlIllIlll, llllllllllllllIIlIlIllIIlIllIllI, llllllllllllllIIlIlIllIIlIllIlIl);
            if (!llllllllllllllIIlIlIllIIlIlllIII.isBlockLoaded(llllllllllllllIIlIlIllIIlIllIIll)) {
                throw new CommandException("commands.execute.failed", new Object[] { "detect", llllllllllllllIIlIlIllIIlIllllIl.getName() });
            }
            final IBlockState llllllllllllllIIlIlIllIIlIllIIlI = llllllllllllllIIlIlIllIIlIlllIII.getBlockState(llllllllllllllIIlIlIllIIlIllIIll);
            if (llllllllllllllIIlIlIllIIlIllIIlI.getBlock() != llllllllllllllIIlIlIllIIlIllIlII) {
                throw new CommandException("commands.execute.failed", new Object[] { "detect", llllllllllllllIIlIlIllIIlIllllIl.getName() });
            }
            if (!CommandBase.func_190791_b(llllllllllllllIIlIlIllIIlIllIlII, llllllllllllllIIlIlIllIIlIlllllI[9]).apply((Object)llllllllllllllIIlIlIllIIlIllIIlI)) {
                throw new CommandException("commands.execute.failed", new Object[] { "detect", llllllllllllllIIlIlIllIIlIllllIl.getName() });
            }
            llllllllllllllIIlIlIllIIlIlllIIl = 10;
        }
        final String llllllllllllllIIlIlIllIIlIllIIIl = CommandBase.buildString(llllllllllllllIIlIlIllIIlIlllllI, llllllllllllllIIlIlIllIIlIlllIIl);
        final ICommandSender llllllllllllllIIlIlIllIIlIllIIII = CommandSenderWrapper.func_193998_a(llllllllllllllIIlIlIllIIlIlIlIll).func_193997_a(llllllllllllllIIlIlIllIIlIllllIl, new Vec3d(llllllllllllllIIlIlIllIIlIllllII, llllllllllllllIIlIlIllIIlIlllIll, llllllllllllllIIlIlIllIIlIlllIlI)).func_194001_a(llllllllllllllIIlIlIllIIlIlIllII.worldServers[0].getGameRules().getBoolean("commandBlockOutput"));
        final ICommandManager llllllllllllllIIlIlIllIIlIlIllll = llllllllllllllIIlIlIllIIlIlIllII.getCommandManager();
        try {
            final int llllllllllllllIIlIlIllIIlIlIlllI = llllllllllllllIIlIlIllIIlIlIllll.executeCommand(llllllllllllllIIlIlIllIIlIllIIII, llllllllllllllIIlIlIllIIlIllIIIl);
            if (llllllllllllllIIlIlIllIIlIlIlllI < 1) {
                throw new CommandException("commands.execute.allInvocationsFailed", new Object[] { llllllllllllllIIlIlIllIIlIllIIIl });
            }
        }
        catch (Throwable llllllllllllllIIlIlIllIIlIlIllIl) {
            throw new CommandException("commands.execute.failed", new Object[] { llllllllllllllIIlIlIllIIlIllIIIl, llllllllllllllIIlIlIllIIlIllllIl.getName() });
        }
    }
}
