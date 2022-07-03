package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import net.minecraft.block.*;
import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.command.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.tileentity.*;

public class CommandTestForBlock extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIIlIIIIlIlIIllIIllI, final ICommandSender lllllllllllllIIlIIIIlIlIIllIIlIl, final String[] lllllllllllllIIlIIIIlIlIIllIIIlI, @Nullable final BlockPos lllllllllllllIIlIIIIlIlIIllIIIll) {
        if (lllllllllllllIIlIIIIlIlIIllIIIlI.length > 0 && lllllllllllllIIlIIIIlIlIIllIIIlI.length <= 3) {
            return CommandBase.getTabCompletionCoordinate(lllllllllllllIIlIIIIlIlIIllIIIlI, 0, lllllllllllllIIlIIIIlIlIIllIIIll);
        }
        return (lllllllllllllIIlIIIIlIlIIllIIIlI.length == 4) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIlIIIIlIlIIllIIIlI, Block.REGISTRY.getKeys()) : Collections.emptyList();
    }
    
    @Override
    public String getCommandName() {
        return "testforblock";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIIlIIIIlIlIlIIlIIll) {
        return "commands.testforblock.usage";
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIIlIIIIlIlIlIIIIlIl, final ICommandSender lllllllllllllIIlIIIIlIlIIlllIlII, final String[] lllllllllllllIIlIIIIlIlIIlllIIll) throws CommandException {
        if (lllllllllllllIIlIIIIlIlIIlllIIll.length < 4) {
            throw new WrongUsageException("commands.testforblock.usage", new Object[0]);
        }
        lllllllllllllIIlIIIIlIlIIlllIlII.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, 0);
        final BlockPos lllllllllllllIIlIIIIlIlIlIIIIIlI = CommandBase.parseBlockPos(lllllllllllllIIlIIIIlIlIIlllIlII, lllllllllllllIIlIIIIlIlIIlllIIll, 0, false);
        final Block lllllllllllllIIlIIIIlIlIlIIIIIIl = CommandBase.getBlockByText(lllllllllllllIIlIIIIlIlIIlllIlII, lllllllllllllIIlIIIIlIlIIlllIIll[3]);
        if (lllllllllllllIIlIIIIlIlIlIIIIIIl == null) {
            throw new NumberInvalidException("commands.setblock.notFound", new Object[] { lllllllllllllIIlIIIIlIlIIlllIIll[3] });
        }
        final World lllllllllllllIIlIIIIlIlIlIIIIIII = lllllllllllllIIlIIIIlIlIIlllIlII.getEntityWorld();
        if (!lllllllllllllIIlIIIIlIlIlIIIIIII.isBlockLoaded(lllllllllllllIIlIIIIlIlIlIIIIIlI)) {
            throw new CommandException("commands.testforblock.outOfWorld", new Object[0]);
        }
        NBTTagCompound lllllllllllllIIlIIIIlIlIIlllllll = new NBTTagCompound();
        boolean lllllllllllllIIlIIIIlIlIIllllllI = false;
        if (lllllllllllllIIlIIIIlIlIIlllIIll.length >= 6 && lllllllllllllIIlIIIIlIlIlIIIIIIl.hasTileEntity()) {
            final String lllllllllllllIIlIIIIlIlIIlllllIl = CommandBase.buildString(lllllllllllllIIlIIIIlIlIIlllIIll, 5);
            try {
                lllllllllllllIIlIIIIlIlIIlllllll = JsonToNBT.getTagFromJson(lllllllllllllIIlIIIIlIlIIlllllIl);
                lllllllllllllIIlIIIIlIlIIllllllI = true;
            }
            catch (NBTException lllllllllllllIIlIIIIlIlIIlllllII) {
                throw new CommandException("commands.setblock.tagError", new Object[] { lllllllllllllIIlIIIIlIlIIlllllII.getMessage() });
            }
        }
        final IBlockState lllllllllllllIIlIIIIlIlIIllllIll = lllllllllllllIIlIIIIlIlIlIIIIIII.getBlockState(lllllllllllllIIlIIIIlIlIlIIIIIlI);
        final Block lllllllllllllIIlIIIIlIlIIllllIlI = lllllllllllllIIlIIIIlIlIIllllIll.getBlock();
        if (lllllllllllllIIlIIIIlIlIIllllIlI != lllllllllllllIIlIIIIlIlIlIIIIIIl) {
            throw new CommandException("commands.testforblock.failed.tile", new Object[] { lllllllllllllIIlIIIIlIlIlIIIIIlI.getX(), lllllllllllllIIlIIIIlIlIlIIIIIlI.getY(), lllllllllllllIIlIIIIlIlIlIIIIIlI.getZ(), lllllllllllllIIlIIIIlIlIIllllIlI.getLocalizedName(), lllllllllllllIIlIIIIlIlIlIIIIIIl.getLocalizedName() });
        }
        if (lllllllllllllIIlIIIIlIlIIlllIIll.length >= 5 && !CommandBase.func_190791_b(lllllllllllllIIlIIIIlIlIlIIIIIIl, lllllllllllllIIlIIIIlIlIIlllIIll[4]).apply((Object)lllllllllllllIIlIIIIlIlIIllllIll)) {
            try {
                final int lllllllllllllIIlIIIIlIlIIllllIIl = lllllllllllllIIlIIIIlIlIIllllIll.getBlock().getMetaFromState(lllllllllllllIIlIIIIlIlIIllllIll);
                throw new CommandException("commands.testforblock.failed.data", new Object[] { lllllllllllllIIlIIIIlIlIlIIIIIlI.getX(), lllllllllllllIIlIIIIlIlIlIIIIIlI.getY(), lllllllllllllIIlIIIIlIlIlIIIIIlI.getZ(), lllllllllllllIIlIIIIlIlIIllllIIl, Integer.parseInt(lllllllllllllIIlIIIIlIlIIlllIIll[4]) });
            }
            catch (NumberFormatException lllllllllllllIIlIIIIlIlIIllllIII) {
                throw new CommandException("commands.testforblock.failed.data", new Object[] { lllllllllllllIIlIIIIlIlIlIIIIIlI.getX(), lllllllllllllIIlIIIIlIlIlIIIIIlI.getY(), lllllllllllllIIlIIIIlIlIlIIIIIlI.getZ(), lllllllllllllIIlIIIIlIlIIllllIll.toString(), lllllllllllllIIlIIIIlIlIIlllIIll[4] });
            }
        }
        if (lllllllllllllIIlIIIIlIlIIllllllI) {
            final TileEntity lllllllllllllIIlIIIIlIlIIlllIlll = lllllllllllllIIlIIIIlIlIlIIIIIII.getTileEntity(lllllllllllllIIlIIIIlIlIlIIIIIlI);
            if (lllllllllllllIIlIIIIlIlIIlllIlll == null) {
                throw new CommandException("commands.testforblock.failed.tileEntity", new Object[] { lllllllllllllIIlIIIIlIlIlIIIIIlI.getX(), lllllllllllllIIlIIIIlIlIlIIIIIlI.getY(), lllllllllllllIIlIIIIlIlIlIIIIIlI.getZ() });
            }
            final NBTTagCompound lllllllllllllIIlIIIIlIlIIlllIllI = lllllllllllllIIlIIIIlIlIIlllIlll.writeToNBT(new NBTTagCompound());
            if (!NBTUtil.areNBTEquals(lllllllllllllIIlIIIIlIlIIlllllll, lllllllllllllIIlIIIIlIlIIlllIllI, true)) {
                throw new CommandException("commands.testforblock.failed.nbt", new Object[] { lllllllllllllIIlIIIIlIlIlIIIIIlI.getX(), lllllllllllllIIlIIIIlIlIlIIIIIlI.getY(), lllllllllllllIIlIIIIlIlIlIIIIIlI.getZ() });
            }
        }
        lllllllllllllIIlIIIIlIlIIlllIlII.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, 1);
        CommandBase.notifyCommandListener(lllllllllllllIIlIIIIlIlIIlllIlII, this, "commands.testforblock.success", lllllllllllllIIlIIIIlIlIlIIIIIlI.getX(), lllllllllllllIIlIIIIlIlIlIIIIIlI.getY(), lllllllllllllIIlIIIIlIlIlIIIIIlI.getZ());
    }
}
