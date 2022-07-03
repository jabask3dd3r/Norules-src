package net.minecraft.command;

import net.minecraft.server.*;
import javax.annotation.*;
import net.minecraft.block.*;
import net.minecraft.world.gen.structure.*;
import net.minecraft.util.math.*;
import com.google.common.collect.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.inventory.*;
import com.google.common.base.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import java.util.*;

public class CommandClone extends CommandBase
{
    @Override
    public String getCommandName() {
        return "clone";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIIIIIllIIllIIlIllII, final ICommandSender lllllllllllllIIIIIllIIllIIlIlIll, final String[] lllllllllllllIIIIIllIIllIIlIlIlI, @Nullable final BlockPos lllllllllllllIIIIIllIIllIIlIlIIl) {
        if (lllllllllllllIIIIIllIIllIIlIlIlI.length > 0 && lllllllllllllIIIIIllIIllIIlIlIlI.length <= 3) {
            return CommandBase.getTabCompletionCoordinate(lllllllllllllIIIIIllIIllIIlIlIlI, 0, lllllllllllllIIIIIllIIllIIlIlIIl);
        }
        if (lllllllllllllIIIIIllIIllIIlIlIlI.length > 3 && lllllllllllllIIIIIllIIllIIlIlIlI.length <= 6) {
            return CommandBase.getTabCompletionCoordinate(lllllllllllllIIIIIllIIllIIlIlIlI, 3, lllllllllllllIIIIIllIIllIIlIlIIl);
        }
        if (lllllllllllllIIIIIllIIllIIlIlIlI.length > 6 && lllllllllllllIIIIIllIIllIIlIlIlI.length <= 9) {
            return CommandBase.getTabCompletionCoordinate(lllllllllllllIIIIIllIIllIIlIlIlI, 6, lllllllllllllIIIIIllIIllIIlIlIIl);
        }
        if (lllllllllllllIIIIIllIIllIIlIlIlI.length == 10) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIIIIllIIllIIlIlIlI, "replace", "masked", "filtered");
        }
        if (lllllllllllllIIIIIllIIllIIlIlIlI.length == 11) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIIIIllIIllIIlIlIlI, "normal", "force", "move");
        }
        return (lllllllllllllIIIIIllIIllIIlIlIlI.length == 12 && "filtered".equals(lllllllllllllIIIIIllIIllIIlIlIlI[9])) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIIIIllIIllIIlIlIlI, Block.REGISTRY.getKeys()) : Collections.emptyList();
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIIIIIllIIlllIIlIIII) {
        return "commands.clone.usage";
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIIIIIllIIllIlllIIll, final ICommandSender lllllllllllllIIIIIllIIllIlIIlIIl, final String[] lllllllllllllIIIIIllIIllIlIIlIII) throws CommandException {
        if (lllllllllllllIIIIIllIIllIlIIlIII.length < 9) {
            throw new WrongUsageException("commands.clone.usage", new Object[0]);
        }
        lllllllllllllIIIIIllIIllIlIIlIIl.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, 0);
        final BlockPos lllllllllllllIIIIIllIIllIlllIIII = CommandBase.parseBlockPos(lllllllllllllIIIIIllIIllIlIIlIIl, lllllllllllllIIIIIllIIllIlIIlIII, 0, false);
        final BlockPos lllllllllllllIIIIIllIIllIllIllll = CommandBase.parseBlockPos(lllllllllllllIIIIIllIIllIlIIlIIl, lllllllllllllIIIIIllIIllIlIIlIII, 3, false);
        final BlockPos lllllllllllllIIIIIllIIllIllIlllI = CommandBase.parseBlockPos(lllllllllllllIIIIIllIIllIlIIlIIl, lllllllllllllIIIIIllIIllIlIIlIII, 6, false);
        final StructureBoundingBox lllllllllllllIIIIIllIIllIllIllIl = new StructureBoundingBox(lllllllllllllIIIIIllIIllIlllIIII, lllllllllllllIIIIIllIIllIllIllll);
        final StructureBoundingBox lllllllllllllIIIIIllIIllIllIllII = new StructureBoundingBox(lllllllllllllIIIIIllIIllIllIlllI, lllllllllllllIIIIIllIIllIllIlllI.add(lllllllllllllIIIIIllIIllIllIllIl.getLength()));
        int lllllllllllllIIIIIllIIllIllIlIll = lllllllllllllIIIIIllIIllIllIllIl.getXSize() * lllllllllllllIIIIIllIIllIllIllIl.getYSize() * lllllllllllllIIIIIllIIllIllIllIl.getZSize();
        if (lllllllllllllIIIIIllIIllIllIlIll > 32768) {
            throw new CommandException("commands.clone.tooManyBlocks", new Object[] { lllllllllllllIIIIIllIIllIllIlIll, 32768 });
        }
        boolean lllllllllllllIIIIIllIIllIllIlIlI = false;
        Block lllllllllllllIIIIIllIIllIllIlIIl = null;
        Predicate<IBlockState> lllllllllllllIIIIIllIIllIllIlIII = null;
        if ((lllllllllllllIIIIIllIIllIlIIlIII.length < 11 || (!"force".equals(lllllllllllllIIIIIllIIllIlIIlIII[10]) && !"move".equals(lllllllllllllIIIIIllIIllIlIIlIII[10]))) && lllllllllllllIIIIIllIIllIllIllIl.intersectsWith(lllllllllllllIIIIIllIIllIllIllII)) {
            throw new CommandException("commands.clone.noOverlap", new Object[0]);
        }
        if (lllllllllllllIIIIIllIIllIlIIlIII.length >= 11 && "move".equals(lllllllllllllIIIIIllIIllIlIIlIII[10])) {
            lllllllllllllIIIIIllIIllIllIlIlI = true;
        }
        if (lllllllllllllIIIIIllIIllIllIllIl.minY < 0 || lllllllllllllIIIIIllIIllIllIllIl.maxY >= 256 || lllllllllllllIIIIIllIIllIllIllII.minY < 0 || lllllllllllllIIIIIllIIllIllIllII.maxY >= 256) {
            throw new CommandException("commands.clone.outOfWorld", new Object[0]);
        }
        final World lllllllllllllIIIIIllIIllIllIIlll = lllllllllllllIIIIIllIIllIlIIlIIl.getEntityWorld();
        if (!lllllllllllllIIIIIllIIllIllIIlll.isAreaLoaded(lllllllllllllIIIIIllIIllIllIllIl) || !lllllllllllllIIIIIllIIllIllIIlll.isAreaLoaded(lllllllllllllIIIIIllIIllIllIllII)) {
            throw new CommandException("commands.clone.outOfWorld", new Object[0]);
        }
        boolean lllllllllllllIIIIIllIIllIllIIllI = false;
        if (lllllllllllllIIIIIllIIllIlIIlIII.length >= 10) {
            if ("masked".equals(lllllllllllllIIIIIllIIllIlIIlIII[9])) {
                lllllllllllllIIIIIllIIllIllIIllI = true;
            }
            else if ("filtered".equals(lllllllllllllIIIIIllIIllIlIIlIII[9])) {
                if (lllllllllllllIIIIIllIIllIlIIlIII.length < 12) {
                    throw new WrongUsageException("commands.clone.usage", new Object[0]);
                }
                lllllllllllllIIIIIllIIllIllIlIIl = CommandBase.getBlockByText(lllllllllllllIIIIIllIIllIlIIlIIl, lllllllllllllIIIIIllIIllIlIIlIII[11]);
                if (lllllllllllllIIIIIllIIllIlIIlIII.length >= 13) {
                    lllllllllllllIIIIIllIIllIllIlIII = CommandBase.func_190791_b(lllllllllllllIIIIIllIIllIllIlIIl, lllllllllllllIIIIIllIIllIlIIlIII[12]);
                }
            }
        }
        final List<StaticCloneData> lllllllllllllIIIIIllIIllIllIIlIl = (List<StaticCloneData>)Lists.newArrayList();
        final List<StaticCloneData> lllllllllllllIIIIIllIIllIllIIlII = (List<StaticCloneData>)Lists.newArrayList();
        final List<StaticCloneData> lllllllllllllIIIIIllIIllIllIIIll = (List<StaticCloneData>)Lists.newArrayList();
        final Deque<BlockPos> lllllllllllllIIIIIllIIllIllIIIlI = (Deque<BlockPos>)Lists.newLinkedList();
        final BlockPos lllllllllllllIIIIIllIIllIllIIIIl = new BlockPos(lllllllllllllIIIIIllIIllIllIllII.minX - lllllllllllllIIIIIllIIllIllIllIl.minX, lllllllllllllIIIIIllIIllIllIllII.minY - lllllllllllllIIIIIllIIllIllIllIl.minY, lllllllllllllIIIIIllIIllIllIllII.minZ - lllllllllllllIIIIIllIIllIllIllIl.minZ);
        for (int lllllllllllllIIIIIllIIllIllIIIII = lllllllllllllIIIIIllIIllIllIllIl.minZ; lllllllllllllIIIIIllIIllIllIIIII <= lllllllllllllIIIIIllIIllIllIllIl.maxZ; ++lllllllllllllIIIIIllIIllIllIIIII) {
            for (int lllllllllllllIIIIIllIIllIlIlllll = lllllllllllllIIIIIllIIllIllIllIl.minY; lllllllllllllIIIIIllIIllIlIlllll <= lllllllllllllIIIIIllIIllIllIllIl.maxY; ++lllllllllllllIIIIIllIIllIlIlllll) {
                for (int lllllllllllllIIIIIllIIllIlIllllI = lllllllllllllIIIIIllIIllIllIllIl.minX; lllllllllllllIIIIIllIIllIlIllllI <= lllllllllllllIIIIIllIIllIllIllIl.maxX; ++lllllllllllllIIIIIllIIllIlIllllI) {
                    final BlockPos lllllllllllllIIIIIllIIllIlIlllIl = new BlockPos(lllllllllllllIIIIIllIIllIlIllllI, lllllllllllllIIIIIllIIllIlIlllll, lllllllllllllIIIIIllIIllIllIIIII);
                    final BlockPos lllllllllllllIIIIIllIIllIlIlllII = lllllllllllllIIIIIllIIllIlIlllIl.add(lllllllllllllIIIIIllIIllIllIIIIl);
                    final IBlockState lllllllllllllIIIIIllIIllIlIllIll = lllllllllllllIIIIIllIIllIllIIlll.getBlockState(lllllllllllllIIIIIllIIllIlIlllIl);
                    if ((!lllllllllllllIIIIIllIIllIllIIllI || lllllllllllllIIIIIllIIllIlIllIll.getBlock() != Blocks.AIR) && (lllllllllllllIIIIIllIIllIllIlIIl == null || (lllllllllllllIIIIIllIIllIlIllIll.getBlock() == lllllllllllllIIIIIllIIllIllIlIIl && (lllllllllllllIIIIIllIIllIllIlIII == null || lllllllllllllIIIIIllIIllIllIlIII.apply((Object)lllllllllllllIIIIIllIIllIlIllIll))))) {
                        final TileEntity lllllllllllllIIIIIllIIllIlIllIlI = lllllllllllllIIIIIllIIllIllIIlll.getTileEntity(lllllllllllllIIIIIllIIllIlIlllIl);
                        if (lllllllllllllIIIIIllIIllIlIllIlI != null) {
                            final NBTTagCompound lllllllllllllIIIIIllIIllIlIllIIl = lllllllllllllIIIIIllIIllIlIllIlI.writeToNBT(new NBTTagCompound());
                            lllllllllllllIIIIIllIIllIllIIlII.add(new StaticCloneData(lllllllllllllIIIIIllIIllIlIlllII, lllllllllllllIIIIIllIIllIlIllIll, lllllllllllllIIIIIllIIllIlIllIIl));
                            lllllllllllllIIIIIllIIllIllIIIlI.addLast(lllllllllllllIIIIIllIIllIlIlllIl);
                        }
                        else if (!lllllllllllllIIIIIllIIllIlIllIll.isFullBlock() && !lllllllllllllIIIIIllIIllIlIllIll.isFullCube()) {
                            lllllllllllllIIIIIllIIllIllIIIll.add(new StaticCloneData(lllllllllllllIIIIIllIIllIlIlllII, lllllllllllllIIIIIllIIllIlIllIll, null));
                            lllllllllllllIIIIIllIIllIllIIIlI.addFirst(lllllllllllllIIIIIllIIllIlIlllIl);
                        }
                        else {
                            lllllllllllllIIIIIllIIllIllIIlIl.add(new StaticCloneData(lllllllllllllIIIIIllIIllIlIlllII, lllllllllllllIIIIIllIIllIlIllIll, null));
                            lllllllllllllIIIIIllIIllIllIIIlI.addLast(lllllllllllllIIIIIllIIllIlIlllIl);
                        }
                    }
                }
            }
        }
        if (lllllllllllllIIIIIllIIllIllIlIlI) {
            for (final BlockPos lllllllllllllIIIIIllIIllIlIllIII : lllllllllllllIIIIIllIIllIllIIIlI) {
                final TileEntity lllllllllllllIIIIIllIIllIlIlIlll = lllllllllllllIIIIIllIIllIllIIlll.getTileEntity(lllllllllllllIIIIIllIIllIlIllIII);
                if (lllllllllllllIIIIIllIIllIlIlIlll instanceof IInventory) {
                    ((IInventory)lllllllllllllIIIIIllIIllIlIlIlll).clear();
                }
                lllllllllllllIIIIIllIIllIllIIlll.setBlockState(lllllllllllllIIIIIllIIllIlIllIII, Blocks.BARRIER.getDefaultState(), 2);
            }
            for (final BlockPos lllllllllllllIIIIIllIIllIlIlIllI : lllllllllllllIIIIIllIIllIllIIIlI) {
                lllllllllllllIIIIIllIIllIllIIlll.setBlockState(lllllllllllllIIIIIllIIllIlIlIllI, Blocks.AIR.getDefaultState(), 3);
            }
        }
        final List<StaticCloneData> lllllllllllllIIIIIllIIllIlIlIlIl = (List<StaticCloneData>)Lists.newArrayList();
        lllllllllllllIIIIIllIIllIlIlIlIl.addAll(lllllllllllllIIIIIllIIllIllIIlIl);
        lllllllllllllIIIIIllIIllIlIlIlIl.addAll(lllllllllllllIIIIIllIIllIllIIlII);
        lllllllllllllIIIIIllIIllIlIlIlIl.addAll(lllllllllllllIIIIIllIIllIllIIIll);
        final List<StaticCloneData> lllllllllllllIIIIIllIIllIlIlIlII = (List<StaticCloneData>)Lists.reverse((List)lllllllllllllIIIIIllIIllIlIlIlIl);
        for (final StaticCloneData lllllllllllllIIIIIllIIllIlIlIIll : lllllllllllllIIIIIllIIllIlIlIlII) {
            final TileEntity lllllllllllllIIIIIllIIllIlIlIIlI = lllllllllllllIIIIIllIIllIllIIlll.getTileEntity(lllllllllllllIIIIIllIIllIlIlIIll.pos);
            if (lllllllllllllIIIIIllIIllIlIlIIlI instanceof IInventory) {
                ((IInventory)lllllllllllllIIIIIllIIllIlIlIIlI).clear();
            }
            lllllllllllllIIIIIllIIllIllIIlll.setBlockState(lllllllllllllIIIIIllIIllIlIlIIll.pos, Blocks.BARRIER.getDefaultState(), 2);
        }
        lllllllllllllIIIIIllIIllIllIlIll = 0;
        for (final StaticCloneData lllllllllllllIIIIIllIIllIlIlIIIl : lllllllllllllIIIIIllIIllIlIlIlIl) {
            if (lllllllllllllIIIIIllIIllIllIIlll.setBlockState(lllllllllllllIIIIIllIIllIlIlIIIl.pos, lllllllllllllIIIIIllIIllIlIlIIIl.blockState, 2)) {
                ++lllllllllllllIIIIIllIIllIllIlIll;
            }
        }
        for (final StaticCloneData lllllllllllllIIIIIllIIllIlIlIIII : lllllllllllllIIIIIllIIllIllIIlII) {
            final TileEntity lllllllllllllIIIIIllIIllIlIIllll = lllllllllllllIIIIIllIIllIllIIlll.getTileEntity(lllllllllllllIIIIIllIIllIlIlIIII.pos);
            if (lllllllllllllIIIIIllIIllIlIlIIII.nbt != null && lllllllllllllIIIIIllIIllIlIIllll != null) {
                lllllllllllllIIIIIllIIllIlIlIIII.nbt.setInteger("x", lllllllllllllIIIIIllIIllIlIlIIII.pos.getX());
                lllllllllllllIIIIIllIIllIlIlIIII.nbt.setInteger("y", lllllllllllllIIIIIllIIllIlIlIIII.pos.getY());
                lllllllllllllIIIIIllIIllIlIlIIII.nbt.setInteger("z", lllllllllllllIIIIIllIIllIlIlIIII.pos.getZ());
                lllllllllllllIIIIIllIIllIlIIllll.readFromNBT(lllllllllllllIIIIIllIIllIlIlIIII.nbt);
                lllllllllllllIIIIIllIIllIlIIllll.markDirty();
            }
            lllllllllllllIIIIIllIIllIllIIlll.setBlockState(lllllllllllllIIIIIllIIllIlIlIIII.pos, lllllllllllllIIIIIllIIllIlIlIIII.blockState, 2);
        }
        for (final StaticCloneData lllllllllllllIIIIIllIIllIlIIlllI : lllllllllllllIIIIIllIIllIlIlIlII) {
            lllllllllllllIIIIIllIIllIllIIlll.notifyNeighborsRespectDebug(lllllllllllllIIIIIllIIllIlIIlllI.pos, lllllllllllllIIIIIllIIllIlIIlllI.blockState.getBlock(), false);
        }
        final List<NextTickListEntry> lllllllllllllIIIIIllIIllIlIIllIl = lllllllllllllIIIIIllIIllIllIIlll.getPendingBlockUpdates(lllllllllllllIIIIIllIIllIllIllIl, false);
        if (lllllllllllllIIIIIllIIllIlIIllIl != null) {
            for (final NextTickListEntry lllllllllllllIIIIIllIIllIlIIllII : lllllllllllllIIIIIllIIllIlIIllIl) {
                if (lllllllllllllIIIIIllIIllIllIllIl.isVecInside(lllllllllllllIIIIIllIIllIlIIllII.position)) {
                    final BlockPos lllllllllllllIIIIIllIIllIlIIlIll = lllllllllllllIIIIIllIIllIlIIllII.position.add(lllllllllllllIIIIIllIIllIllIIIIl);
                    lllllllllllllIIIIIllIIllIllIIlll.scheduleBlockUpdate(lllllllllllllIIIIIllIIllIlIIlIll, lllllllllllllIIIIIllIIllIlIIllII.getBlock(), (int)(lllllllllllllIIIIIllIIllIlIIllII.scheduledTime - lllllllllllllIIIIIllIIllIllIIlll.getWorldInfo().getWorldTotalTime()), lllllllllllllIIIIIllIIllIlIIllII.priority);
                }
            }
        }
        if (lllllllllllllIIIIIllIIllIllIlIll <= 0) {
            throw new CommandException("commands.clone.failed", new Object[0]);
        }
        lllllllllllllIIIIIllIIllIlIIlIIl.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, lllllllllllllIIIIIllIIllIllIlIll);
        CommandBase.notifyCommandListener(lllllllllllllIIIIIllIIllIlIIlIIl, this, "commands.clone.success", lllllllllllllIIIIIllIIllIllIlIll);
    }
    
    static class StaticCloneData
    {
        public final /* synthetic */ IBlockState blockState;
        public final /* synthetic */ NBTTagCompound nbt;
        public final /* synthetic */ BlockPos pos;
        
        public StaticCloneData(final BlockPos llllllllllllllllllIIIlIIIIIIlIlI, final IBlockState llllllllllllllllllIIIlIIIIIIIlIl, final NBTTagCompound llllllllllllllllllIIIlIIIIIIlIII) {
            this.pos = llllllllllllllllllIIIlIIIIIIlIlI;
            this.blockState = llllllllllllllllllIIIlIIIIIIIlIl;
            this.nbt = llllllllllllllllllIIIlIIIIIIlIII;
        }
    }
}
