package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import net.minecraft.nbt.*;
import com.google.common.collect.*;
import net.minecraft.init.*;
import net.minecraft.inventory.*;
import net.minecraft.block.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import javax.annotation.*;
import java.util.*;

public class CommandFill extends CommandBase
{
    @Override
    public void execute(final MinecraftServer lllllllllllllIIIlIllIlllIlllIlIl, final ICommandSender lllllllllllllIIIlIllIlllIlIllIII, final String[] lllllllllllllIIIlIllIlllIlllIIll) throws CommandException {
        if (lllllllllllllIIIlIllIlllIlllIIll.length < 7) {
            throw new WrongUsageException("commands.fill.usage", new Object[0]);
        }
        lllllllllllllIIIlIllIlllIlIllIII.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, 0);
        final BlockPos lllllllllllllIIIlIllIlllIlllIIlI = CommandBase.parseBlockPos(lllllllllllllIIIlIllIlllIlIllIII, lllllllllllllIIIlIllIlllIlllIIll, 0, false);
        final BlockPos lllllllllllllIIIlIllIlllIlllIIIl = CommandBase.parseBlockPos(lllllllllllllIIIlIllIlllIlIllIII, lllllllllllllIIIlIllIlllIlllIIll, 3, false);
        final Block lllllllllllllIIIlIllIlllIlllIIII = CommandBase.getBlockByText(lllllllllllllIIIlIllIlllIlIllIII, lllllllllllllIIIlIllIlllIlllIIll[6]);
        IBlockState lllllllllllllIIIlIllIlllIllIlllI = null;
        if (lllllllllllllIIIlIllIlllIlllIIll.length >= 8) {
            final IBlockState lllllllllllllIIIlIllIlllIllIllll = CommandBase.func_190794_a(lllllllllllllIIIlIllIlllIlllIIII, lllllllllllllIIIlIllIlllIlllIIll[7]);
        }
        else {
            lllllllllllllIIIlIllIlllIllIlllI = lllllllllllllIIIlIllIlllIlllIIII.getDefaultState();
        }
        final BlockPos lllllllllllllIIIlIllIlllIllIllIl = new BlockPos(Math.min(lllllllllllllIIIlIllIlllIlllIIlI.getX(), lllllllllllllIIIlIllIlllIlllIIIl.getX()), Math.min(lllllllllllllIIIlIllIlllIlllIIlI.getY(), lllllllllllllIIIlIllIlllIlllIIIl.getY()), Math.min(lllllllllllllIIIlIllIlllIlllIIlI.getZ(), lllllllllllllIIIlIllIlllIlllIIIl.getZ()));
        final BlockPos lllllllllllllIIIlIllIlllIllIllII = new BlockPos(Math.max(lllllllllllllIIIlIllIlllIlllIIlI.getX(), lllllllllllllIIIlIllIlllIlllIIIl.getX()), Math.max(lllllllllllllIIIlIllIlllIlllIIlI.getY(), lllllllllllllIIIlIllIlllIlllIIIl.getY()), Math.max(lllllllllllllIIIlIllIlllIlllIIlI.getZ(), lllllllllllllIIIlIllIlllIlllIIIl.getZ()));
        int lllllllllllllIIIlIllIlllIllIlIll = (lllllllllllllIIIlIllIlllIllIllII.getX() - lllllllllllllIIIlIllIlllIllIllIl.getX() + 1) * (lllllllllllllIIIlIllIlllIllIllII.getY() - lllllllllllllIIIlIllIlllIllIllIl.getY() + 1) * (lllllllllllllIIIlIllIlllIllIllII.getZ() - lllllllllllllIIIlIllIlllIllIllIl.getZ() + 1);
        if (lllllllllllllIIIlIllIlllIllIlIll > 32768) {
            throw new CommandException("commands.fill.tooManyBlocks", new Object[] { lllllllllllllIIIlIllIlllIllIlIll, 32768 });
        }
        if (lllllllllllllIIIlIllIlllIllIllIl.getY() < 0 || lllllllllllllIIIlIllIlllIllIllII.getY() >= 256) {
            throw new CommandException("commands.fill.outOfWorld", new Object[0]);
        }
        final World lllllllllllllIIIlIllIlllIllIlIlI = lllllllllllllIIIlIllIlllIlIllIII.getEntityWorld();
        for (int lllllllllllllIIIlIllIlllIllIlIIl = lllllllllllllIIIlIllIlllIllIllIl.getZ(); lllllllllllllIIIlIllIlllIllIlIIl <= lllllllllllllIIIlIllIlllIllIllII.getZ(); lllllllllllllIIIlIllIlllIllIlIIl += 16) {
            for (int lllllllllllllIIIlIllIlllIllIlIII = lllllllllllllIIIlIllIlllIllIllIl.getX(); lllllllllllllIIIlIllIlllIllIlIII <= lllllllllllllIIIlIllIlllIllIllII.getX(); lllllllllllllIIIlIllIlllIllIlIII += 16) {
                if (!lllllllllllllIIIlIllIlllIllIlIlI.isBlockLoaded(new BlockPos(lllllllllllllIIIlIllIlllIllIlIII, lllllllllllllIIIlIllIlllIllIllII.getY() - lllllllllllllIIIlIllIlllIllIllIl.getY(), lllllllllllllIIIlIllIlllIllIlIIl))) {
                    throw new CommandException("commands.fill.outOfWorld", new Object[0]);
                }
            }
        }
        NBTTagCompound lllllllllllllIIIlIllIlllIllIIlll = new NBTTagCompound();
        boolean lllllllllllllIIIlIllIlllIllIIllI = false;
        if (lllllllllllllIIIlIllIlllIlllIIll.length >= 10 && lllllllllllllIIIlIllIlllIlllIIII.hasTileEntity()) {
            final String lllllllllllllIIIlIllIlllIllIIlIl = CommandBase.buildString(lllllllllllllIIIlIllIlllIlllIIll, 9);
            try {
                lllllllllllllIIIlIllIlllIllIIlll = JsonToNBT.getTagFromJson(lllllllllllllIIIlIllIlllIllIIlIl);
                lllllllllllllIIIlIllIlllIllIIllI = true;
            }
            catch (NBTException lllllllllllllIIIlIllIlllIllIIlII) {
                throw new CommandException("commands.fill.tagError", new Object[] { lllllllllllllIIIlIllIlllIllIIlII.getMessage() });
            }
        }
        final List<BlockPos> lllllllllllllIIIlIllIlllIllIIIll = (List<BlockPos>)Lists.newArrayList();
        lllllllllllllIIIlIllIlllIllIlIll = 0;
        for (int lllllllllllllIIIlIllIlllIllIIIlI = lllllllllllllIIIlIllIlllIllIllIl.getZ(); lllllllllllllIIIlIllIlllIllIIIlI <= lllllllllllllIIIlIllIlllIllIllII.getZ(); ++lllllllllllllIIIlIllIlllIllIIIlI) {
            for (int lllllllllllllIIIlIllIlllIllIIIIl = lllllllllllllIIIlIllIlllIllIllIl.getY(); lllllllllllllIIIlIllIlllIllIIIIl <= lllllllllllllIIIlIllIlllIllIllII.getY(); ++lllllllllllllIIIlIllIlllIllIIIIl) {
                for (int lllllllllllllIIIlIllIlllIllIIIII = lllllllllllllIIIlIllIlllIllIllIl.getX(); lllllllllllllIIIlIllIlllIllIIIII <= lllllllllllllIIIlIllIlllIllIllII.getX(); ++lllllllllllllIIIlIllIlllIllIIIII) {
                    final BlockPos lllllllllllllIIIlIllIlllIlIlllll = new BlockPos(lllllllllllllIIIlIllIlllIllIIIII, lllllllllllllIIIlIllIlllIllIIIIl, lllllllllllllIIIlIllIlllIllIIIlI);
                    if (lllllllllllllIIIlIllIlllIlllIIll.length >= 9) {
                        if (!"outline".equals(lllllllllllllIIIlIllIlllIlllIIll[8]) && !"hollow".equals(lllllllllllllIIIlIllIlllIlllIIll[8])) {
                            if ("destroy".equals(lllllllllllllIIIlIllIlllIlllIIll[8])) {
                                lllllllllllllIIIlIllIlllIllIlIlI.destroyBlock(lllllllllllllIIIlIllIlllIlIlllll, true);
                            }
                            else if ("keep".equals(lllllllllllllIIIlIllIlllIlllIIll[8])) {
                                if (!lllllllllllllIIIlIllIlllIllIlIlI.isAirBlock(lllllllllllllIIIlIllIlllIlIlllll)) {
                                    continue;
                                }
                            }
                            else if ("replace".equals(lllllllllllllIIIlIllIlllIlllIIll[8]) && !lllllllllllllIIIlIllIlllIlllIIII.hasTileEntity() && lllllllllllllIIIlIllIlllIlllIIll.length > 9) {
                                final Block lllllllllllllIIIlIllIlllIlIllllI = CommandBase.getBlockByText(lllllllllllllIIIlIllIlllIlIllIII, lllllllllllllIIIlIllIlllIlllIIll[9]);
                                if (lllllllllllllIIIlIllIlllIllIlIlI.getBlockState(lllllllllllllIIIlIllIlllIlIlllll).getBlock() != lllllllllllllIIIlIllIlllIlIllllI) {
                                    continue;
                                }
                                if (lllllllllllllIIIlIllIlllIlllIIll.length > 10 && !"-1".equals(lllllllllllllIIIlIllIlllIlllIIll[10]) && !"*".equals(lllllllllllllIIIlIllIlllIlllIIll[10]) && !CommandBase.func_190791_b(lllllllllllllIIIlIllIlllIlIllllI, lllllllllllllIIIlIllIlllIlllIIll[10]).apply((Object)lllllllllllllIIIlIllIlllIllIlIlI.getBlockState(lllllllllllllIIIlIllIlllIlIlllll))) {
                                    continue;
                                }
                            }
                        }
                        else if (lllllllllllllIIIlIllIlllIllIIIII != lllllllllllllIIIlIllIlllIllIllIl.getX() && lllllllllllllIIIlIllIlllIllIIIII != lllllllllllllIIIlIllIlllIllIllII.getX() && lllllllllllllIIIlIllIlllIllIIIIl != lllllllllllllIIIlIllIlllIllIllIl.getY() && lllllllllllllIIIlIllIlllIllIIIIl != lllllllllllllIIIlIllIlllIllIllII.getY() && lllllllllllllIIIlIllIlllIllIIIlI != lllllllllllllIIIlIllIlllIllIllIl.getZ() && lllllllllllllIIIlIllIlllIllIIIlI != lllllllllllllIIIlIllIlllIllIllII.getZ()) {
                            if ("hollow".equals(lllllllllllllIIIlIllIlllIlllIIll[8])) {
                                lllllllllllllIIIlIllIlllIllIlIlI.setBlockState(lllllllllllllIIIlIllIlllIlIlllll, Blocks.AIR.getDefaultState(), 2);
                                lllllllllllllIIIlIllIlllIllIIIll.add(lllllllllllllIIIlIllIlllIlIlllll);
                            }
                            continue;
                        }
                    }
                    final TileEntity lllllllllllllIIIlIllIlllIlIlllIl = lllllllllllllIIIlIllIlllIllIlIlI.getTileEntity(lllllllllllllIIIlIllIlllIlIlllll);
                    if (lllllllllllllIIIlIllIlllIlIlllIl != null && lllllllllllllIIIlIllIlllIlIlllIl instanceof IInventory) {
                        ((IInventory)lllllllllllllIIIlIllIlllIlIlllIl).clear();
                    }
                    if (lllllllllllllIIIlIllIlllIllIlIlI.setBlockState(lllllllllllllIIIlIllIlllIlIlllll, lllllllllllllIIIlIllIlllIllIlllI, 2)) {
                        lllllllllllllIIIlIllIlllIllIIIll.add(lllllllllllllIIIlIllIlllIlIlllll);
                        ++lllllllllllllIIIlIllIlllIllIlIll;
                        if (lllllllllllllIIIlIllIlllIllIIllI) {
                            final TileEntity lllllllllllllIIIlIllIlllIlIlllII = lllllllllllllIIIlIllIlllIllIlIlI.getTileEntity(lllllllllllllIIIlIllIlllIlIlllll);
                            if (lllllllllllllIIIlIllIlllIlIlllII != null) {
                                lllllllllllllIIIlIllIlllIllIIlll.setInteger("x", lllllllllllllIIIlIllIlllIlIlllll.getX());
                                lllllllllllllIIIlIllIlllIllIIlll.setInteger("y", lllllllllllllIIIlIllIlllIlIlllll.getY());
                                lllllllllllllIIIlIllIlllIllIIlll.setInteger("z", lllllllllllllIIIlIllIlllIlIlllll.getZ());
                                lllllllllllllIIIlIllIlllIlIlllII.readFromNBT(lllllllllllllIIIlIllIlllIllIIlll);
                            }
                        }
                    }
                }
            }
        }
        for (final BlockPos lllllllllllllIIIlIllIlllIlIllIll : lllllllllllllIIIlIllIlllIllIIIll) {
            final Block lllllllllllllIIIlIllIlllIlIllIlI = lllllllllllllIIIlIllIlllIllIlIlI.getBlockState(lllllllllllllIIIlIllIlllIlIllIll).getBlock();
            lllllllllllllIIIlIllIlllIllIlIlI.notifyNeighborsRespectDebug(lllllllllllllIIIlIllIlllIlIllIll, lllllllllllllIIIlIllIlllIlIllIlI, false);
        }
        if (lllllllllllllIIIlIllIlllIllIlIll <= 0) {
            throw new CommandException("commands.fill.failed", new Object[0]);
        }
        lllllllllllllIIIlIllIlllIlIllIII.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, lllllllllllllIIIlIllIlllIllIlIll);
        CommandBase.notifyCommandListener(lllllllllllllIIIlIllIlllIlIllIII, this, "commands.fill.success", lllllllllllllIIIlIllIlllIllIlIll);
    }
    
    @Override
    public String getCommandName() {
        return "fill";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIIIlIllIlllIlIIIIlI, final ICommandSender lllllllllllllIIIlIllIlllIlIIIIIl, final String[] lllllllllllllIIIlIllIlllIIlllllI, @Nullable final BlockPos lllllllllllllIIIlIllIlllIIllllll) {
        if (lllllllllllllIIIlIllIlllIIlllllI.length > 0 && lllllllllllllIIIlIllIlllIIlllllI.length <= 3) {
            return CommandBase.getTabCompletionCoordinate(lllllllllllllIIIlIllIlllIIlllllI, 0, lllllllllllllIIIlIllIlllIIllllll);
        }
        if (lllllllllllllIIIlIllIlllIIlllllI.length > 3 && lllllllllllllIIIlIllIlllIIlllllI.length <= 6) {
            return CommandBase.getTabCompletionCoordinate(lllllllllllllIIIlIllIlllIIlllllI, 3, lllllllllllllIIIlIllIlllIIllllll);
        }
        if (lllllllllllllIIIlIllIlllIIlllllI.length == 7) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIIlIllIlllIIlllllI, Block.REGISTRY.getKeys());
        }
        if (lllllllllllllIIIlIllIlllIIlllllI.length == 9) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIIlIllIlllIIlllllI, "replace", "destroy", "keep", "hollow", "outline");
        }
        return (lllllllllllllIIIlIllIlllIIlllllI.length == 10 && "replace".equals(lllllllllllllIIIlIllIlllIIlllllI[8])) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIIlIllIlllIIlllllI, Block.REGISTRY.getKeys()) : Collections.emptyList();
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIIIlIllIllllIIIlIll) {
        return "commands.fill.usage";
    }
}
