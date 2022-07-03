package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import net.minecraft.block.*;
import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.init.*;
import net.minecraft.command.*;
import net.minecraft.inventory.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;

public class CommandSetBlock extends CommandBase
{
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIllIIllIIIlllIIIIlI, final ICommandSender lllllllllllllIllIIllIIIlllIIIIIl, final String[] lllllllllllllIllIIllIIIllIlllllI, @Nullable final BlockPos lllllllllllllIllIIllIIIllIllllll) {
        if (lllllllllllllIllIIllIIIllIlllllI.length > 0 && lllllllllllllIllIIllIIIllIlllllI.length <= 3) {
            return CommandBase.getTabCompletionCoordinate(lllllllllllllIllIIllIIIllIlllllI, 0, lllllllllllllIllIIllIIIllIllllll);
        }
        if (lllllllllllllIllIIllIIIllIlllllI.length == 4) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIllIIllIIIllIlllllI, Block.REGISTRY.getKeys());
        }
        return (lllllllllllllIllIIllIIIllIlllllI.length == 6) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIllIIllIIIllIlllllI, "replace", "destroy", "keep") : Collections.emptyList();
    }
    
    @Override
    public String getCommandName() {
        return "setblock";
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIllIIllIIIlllIllllI, final ICommandSender lllllllllllllIllIIllIIIlllIlllIl, final String[] lllllllllllllIllIIllIIIlllIlllII) throws CommandException {
        if (lllllllllllllIllIIllIIIlllIlllII.length < 4) {
            throw new WrongUsageException("commands.setblock.usage", new Object[0]);
        }
        lllllllllllllIllIIllIIIlllIlllIl.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, 0);
        final BlockPos lllllllllllllIllIIllIIIlllIllIll = CommandBase.parseBlockPos(lllllllllllllIllIIllIIIlllIlllIl, lllllllllllllIllIIllIIIlllIlllII, 0, false);
        final Block lllllllllllllIllIIllIIIlllIllIlI = CommandBase.getBlockByText(lllllllllllllIllIIllIIIlllIlllIl, lllllllllllllIllIIllIIIlllIlllII[3]);
        IBlockState lllllllllllllIllIIllIIIlllIllIII = null;
        if (lllllllllllllIllIIllIIIlllIlllII.length >= 5) {
            final IBlockState lllllllllllllIllIIllIIIlllIllIIl = CommandBase.func_190794_a(lllllllllllllIllIIllIIIlllIllIlI, lllllllllllllIllIIllIIIlllIlllII[4]);
        }
        else {
            lllllllllllllIllIIllIIIlllIllIII = lllllllllllllIllIIllIIIlllIllIlI.getDefaultState();
        }
        final World lllllllllllllIllIIllIIIlllIlIlll = lllllllllllllIllIIllIIIlllIlllIl.getEntityWorld();
        if (!lllllllllllllIllIIllIIIlllIlIlll.isBlockLoaded(lllllllllllllIllIIllIIIlllIllIll)) {
            throw new CommandException("commands.setblock.outOfWorld", new Object[0]);
        }
        NBTTagCompound lllllllllllllIllIIllIIIlllIlIllI = new NBTTagCompound();
        boolean lllllllllllllIllIIllIIIlllIlIlIl = false;
        if (lllllllllllllIllIIllIIIlllIlllII.length >= 7 && lllllllllllllIllIIllIIIlllIllIlI.hasTileEntity()) {
            final String lllllllllllllIllIIllIIIlllIlIlII = CommandBase.buildString(lllllllllllllIllIIllIIIlllIlllII, 6);
            try {
                lllllllllllllIllIIllIIIlllIlIllI = JsonToNBT.getTagFromJson(lllllllllllllIllIIllIIIlllIlIlII);
                lllllllllllllIllIIllIIIlllIlIlIl = true;
            }
            catch (NBTException lllllllllllllIllIIllIIIlllIlIIll) {
                throw new CommandException("commands.setblock.tagError", new Object[] { lllllllllllllIllIIllIIIlllIlIIll.getMessage() });
            }
        }
        if (lllllllllllllIllIIllIIIlllIlllII.length >= 6) {
            if ("destroy".equals(lllllllllllllIllIIllIIIlllIlllII[5])) {
                lllllllllllllIllIIllIIIlllIlIlll.destroyBlock(lllllllllllllIllIIllIIIlllIllIll, true);
                if (lllllllllllllIllIIllIIIlllIllIlI == Blocks.AIR) {
                    CommandBase.notifyCommandListener(lllllllllllllIllIIllIIIlllIlllIl, this, "commands.setblock.success", new Object[0]);
                    return;
                }
            }
            else if ("keep".equals(lllllllllllllIllIIllIIIlllIlllII[5]) && !lllllllllllllIllIIllIIIlllIlIlll.isAirBlock(lllllllllllllIllIIllIIIlllIllIll)) {
                throw new CommandException("commands.setblock.noChange", new Object[0]);
            }
        }
        final TileEntity lllllllllllllIllIIllIIIlllIlIIlI = lllllllllllllIllIIllIIIlllIlIlll.getTileEntity(lllllllllllllIllIIllIIIlllIllIll);
        if (lllllllllllllIllIIllIIIlllIlIIlI != null && lllllllllllllIllIIllIIIlllIlIIlI instanceof IInventory) {
            ((IInventory)lllllllllllllIllIIllIIIlllIlIIlI).clear();
        }
        if (!lllllllllllllIllIIllIIIlllIlIlll.setBlockState(lllllllllllllIllIIllIIIlllIllIll, lllllllllllllIllIIllIIIlllIllIII, 2)) {
            throw new CommandException("commands.setblock.noChange", new Object[0]);
        }
        if (lllllllllllllIllIIllIIIlllIlIlIl) {
            final TileEntity lllllllllllllIllIIllIIIlllIlIIIl = lllllllllllllIllIIllIIIlllIlIlll.getTileEntity(lllllllllllllIllIIllIIIlllIllIll);
            if (lllllllllllllIllIIllIIIlllIlIIIl != null) {
                lllllllllllllIllIIllIIIlllIlIllI.setInteger("x", lllllllllllllIllIIllIIIlllIllIll.getX());
                lllllllllllllIllIIllIIIlllIlIllI.setInteger("y", lllllllllllllIllIIllIIIlllIllIll.getY());
                lllllllllllllIllIIllIIIlllIlIllI.setInteger("z", lllllllllllllIllIIllIIIlllIllIll.getZ());
                lllllllllllllIllIIllIIIlllIlIIIl.readFromNBT(lllllllllllllIllIIllIIIlllIlIllI);
            }
        }
        lllllllllllllIllIIllIIIlllIlIlll.notifyNeighborsRespectDebug(lllllllllllllIllIIllIIIlllIllIll, lllllllllllllIllIIllIIIlllIllIII.getBlock(), false);
        lllllllllllllIllIIllIIIlllIlllIl.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, 1);
        CommandBase.notifyCommandListener(lllllllllllllIllIIllIIIlllIlllIl, this, "commands.setblock.success", new Object[0]);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIllIIllIIIllllIlIll) {
        return "commands.setblock.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
}
