package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.world.gen.structure.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.tileentity.*;
import javax.annotation.*;
import java.util.*;

public class CommandCompare extends CommandBase
{
    @Override
    public String getCommandName() {
        return "testforblocks";
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllIIlIIIlIIlIllIIIlI, final ICommandSender llllllllllllllIIlIIIlIIlIllIIIIl, final String[] llllllllllllllIIlIIIlIIlIllIIIII) throws CommandException {
        if (llllllllllllllIIlIIIlIIlIllIIIII.length < 9) {
            throw new WrongUsageException("commands.compare.usage", new Object[0]);
        }
        llllllllllllllIIlIIIlIIlIllIIIIl.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, 0);
        final BlockPos llllllllllllllIIlIIIlIIlIlIlllll = CommandBase.parseBlockPos(llllllllllllllIIlIIIlIIlIllIIIIl, llllllllllllllIIlIIIlIIlIllIIIII, 0, false);
        final BlockPos llllllllllllllIIlIIIlIIlIlIllllI = CommandBase.parseBlockPos(llllllllllllllIIlIIIlIIlIllIIIIl, llllllllllllllIIlIIIlIIlIllIIIII, 3, false);
        final BlockPos llllllllllllllIIlIIIlIIlIlIlllIl = CommandBase.parseBlockPos(llllllllllllllIIlIIIlIIlIllIIIIl, llllllllllllllIIlIIIlIIlIllIIIII, 6, false);
        final StructureBoundingBox llllllllllllllIIlIIIlIIlIlIlllII = new StructureBoundingBox(llllllllllllllIIlIIIlIIlIlIlllll, llllllllllllllIIlIIIlIIlIlIllllI);
        final StructureBoundingBox llllllllllllllIIlIIIlIIlIlIllIll = new StructureBoundingBox(llllllllllllllIIlIIIlIIlIlIlllIl, llllllllllllllIIlIIIlIIlIlIlllIl.add(llllllllllllllIIlIIIlIIlIlIlllII.getLength()));
        int llllllllllllllIIlIIIlIIlIlIllIlI = llllllllllllllIIlIIIlIIlIlIlllII.getXSize() * llllllllllllllIIlIIIlIIlIlIlllII.getYSize() * llllllllllllllIIlIIIlIIlIlIlllII.getZSize();
        if (llllllllllllllIIlIIIlIIlIlIllIlI > 524288) {
            throw new CommandException("commands.compare.tooManyBlocks", new Object[] { llllllllllllllIIlIIIlIIlIlIllIlI, 524288 });
        }
        if (llllllllllllllIIlIIIlIIlIlIlllII.minY < 0 || llllllllllllllIIlIIIlIIlIlIlllII.maxY >= 256 || llllllllllllllIIlIIIlIIlIlIllIll.minY < 0 || llllllllllllllIIlIIIlIIlIlIllIll.maxY >= 256) {
            throw new CommandException("commands.compare.outOfWorld", new Object[0]);
        }
        final World llllllllllllllIIlIIIlIIlIlIllIIl = llllllllllllllIIlIIIlIIlIllIIIIl.getEntityWorld();
        if (llllllllllllllIIlIIIlIIlIlIllIIl.isAreaLoaded(llllllllllllllIIlIIIlIIlIlIlllII) && llllllllllllllIIlIIIlIIlIlIllIIl.isAreaLoaded(llllllllllllllIIlIIIlIIlIlIllIll)) {
            boolean llllllllllllllIIlIIIlIIlIlIllIII = false;
            if (llllllllllllllIIlIIIlIIlIllIIIII.length > 9 && "masked".equals(llllllllllllllIIlIIIlIIlIllIIIII[9])) {
                llllllllllllllIIlIIIlIIlIlIllIII = true;
            }
            llllllllllllllIIlIIIlIIlIlIllIlI = 0;
            final BlockPos llllllllllllllIIlIIIlIIlIlIlIlll = new BlockPos(llllllllllllllIIlIIIlIIlIlIllIll.minX - llllllllllllllIIlIIIlIIlIlIlllII.minX, llllllllllllllIIlIIIlIIlIlIllIll.minY - llllllllllllllIIlIIIlIIlIlIlllII.minY, llllllllllllllIIlIIIlIIlIlIllIll.minZ - llllllllllllllIIlIIIlIIlIlIlllII.minZ);
            final BlockPos.MutableBlockPos llllllllllllllIIlIIIlIIlIlIlIllI = new BlockPos.MutableBlockPos();
            final BlockPos.MutableBlockPos llllllllllllllIIlIIIlIIlIlIlIlIl = new BlockPos.MutableBlockPos();
            for (int llllllllllllllIIlIIIlIIlIlIlIlII = llllllllllllllIIlIIIlIIlIlIlllII.minZ; llllllllllllllIIlIIIlIIlIlIlIlII <= llllllllllllllIIlIIIlIIlIlIlllII.maxZ; ++llllllllllllllIIlIIIlIIlIlIlIlII) {
                for (int llllllllllllllIIlIIIlIIlIlIlIIll = llllllllllllllIIlIIIlIIlIlIlllII.minY; llllllllllllllIIlIIIlIIlIlIlIIll <= llllllllllllllIIlIIIlIIlIlIlllII.maxY; ++llllllllllllllIIlIIIlIIlIlIlIIll) {
                    for (int llllllllllllllIIlIIIlIIlIlIlIIlI = llllllllllllllIIlIIIlIIlIlIlllII.minX; llllllllllllllIIlIIIlIIlIlIlIIlI <= llllllllllllllIIlIIIlIIlIlIlllII.maxX; ++llllllllllllllIIlIIIlIIlIlIlIIlI) {
                        llllllllllllllIIlIIIlIIlIlIlIllI.setPos(llllllllllllllIIlIIIlIIlIlIlIIlI, llllllllllllllIIlIIIlIIlIlIlIIll, llllllllllllllIIlIIIlIIlIlIlIlII);
                        llllllllllllllIIlIIIlIIlIlIlIlIl.setPos(llllllllllllllIIlIIIlIIlIlIlIIlI + llllllllllllllIIlIIIlIIlIlIlIlll.getX(), llllllllllllllIIlIIIlIIlIlIlIIll + llllllllllllllIIlIIIlIIlIlIlIlll.getY(), llllllllllllllIIlIIIlIIlIlIlIlII + llllllllllllllIIlIIIlIIlIlIlIlll.getZ());
                        boolean llllllllllllllIIlIIIlIIlIlIlIIIl = false;
                        final IBlockState llllllllllllllIIlIIIlIIlIlIlIIII = llllllllllllllIIlIIIlIIlIlIllIIl.getBlockState(llllllllllllllIIlIIIlIIlIlIlIllI);
                        if (!llllllllllllllIIlIIIlIIlIlIllIII || llllllllllllllIIlIIIlIIlIlIlIIII.getBlock() != Blocks.AIR) {
                            if (llllllllllllllIIlIIIlIIlIlIlIIII == llllllllllllllIIlIIIlIIlIlIllIIl.getBlockState(llllllllllllllIIlIIIlIIlIlIlIlIl)) {
                                final TileEntity llllllllllllllIIlIIIlIIlIlIIllll = llllllllllllllIIlIIIlIIlIlIllIIl.getTileEntity(llllllllllllllIIlIIIlIIlIlIlIllI);
                                final TileEntity llllllllllllllIIlIIIlIIlIlIIlllI = llllllllllllllIIlIIIlIIlIlIllIIl.getTileEntity(llllllllllllllIIlIIIlIIlIlIlIlIl);
                                if (llllllllllllllIIlIIIlIIlIlIIllll != null && llllllllllllllIIlIIIlIIlIlIIlllI != null) {
                                    final NBTTagCompound llllllllllllllIIlIIIlIIlIlIIllIl = llllllllllllllIIlIIIlIIlIlIIllll.writeToNBT(new NBTTagCompound());
                                    llllllllllllllIIlIIIlIIlIlIIllIl.removeTag("x");
                                    llllllllllllllIIlIIIlIIlIlIIllIl.removeTag("y");
                                    llllllllllllllIIlIIIlIIlIlIIllIl.removeTag("z");
                                    final NBTTagCompound llllllllllllllIIlIIIlIIlIlIIllII = llllllllllllllIIlIIIlIIlIlIIlllI.writeToNBT(new NBTTagCompound());
                                    llllllllllllllIIlIIIlIIlIlIIllII.removeTag("x");
                                    llllllllllllllIIlIIIlIIlIlIIllII.removeTag("y");
                                    llllllllllllllIIlIIIlIIlIlIIllII.removeTag("z");
                                    if (!llllllllllllllIIlIIIlIIlIlIIllIl.equals(llllllllllllllIIlIIIlIIlIlIIllII)) {
                                        llllllllllllllIIlIIIlIIlIlIlIIIl = true;
                                    }
                                }
                                else if (llllllllllllllIIlIIIlIIlIlIIllll != null) {
                                    llllllllllllllIIlIIIlIIlIlIlIIIl = true;
                                }
                            }
                            else {
                                llllllllllllllIIlIIIlIIlIlIlIIIl = true;
                            }
                            ++llllllllllllllIIlIIIlIIlIlIllIlI;
                            if (llllllllllllllIIlIIIlIIlIlIlIIIl) {
                                throw new CommandException("commands.compare.failed", new Object[0]);
                            }
                        }
                    }
                }
            }
            llllllllllllllIIlIIIlIIlIllIIIIl.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, llllllllllllllIIlIIIlIIlIlIllIlI);
            CommandBase.notifyCommandListener(llllllllllllllIIlIIIlIIlIllIIIIl, this, "commands.compare.success", llllllllllllllIIlIIIlIIlIlIllIlI);
            return;
        }
        throw new CommandException("commands.compare.outOfWorld", new Object[0]);
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllllIIlIIIlIIlIIllIIIl, final ICommandSender llllllllllllllIIlIIIlIIlIIllIIII, final String[] llllllllllllllIIlIIIlIIlIIlIllll, @Nullable final BlockPos llllllllllllllIIlIIIlIIlIIlIlllI) {
        if (llllllllllllllIIlIIIlIIlIIlIllll.length > 0 && llllllllllllllIIlIIIlIIlIIlIllll.length <= 3) {
            return CommandBase.getTabCompletionCoordinate(llllllllllllllIIlIIIlIIlIIlIllll, 0, llllllllllllllIIlIIIlIIlIIlIlllI);
        }
        if (llllllllllllllIIlIIIlIIlIIlIllll.length > 3 && llllllllllllllIIlIIIlIIlIIlIllll.length <= 6) {
            return CommandBase.getTabCompletionCoordinate(llllllllllllllIIlIIIlIIlIIlIllll, 3, llllllllllllllIIlIIIlIIlIIlIlllI);
        }
        if (llllllllllllllIIlIIIlIIlIIlIllll.length > 6 && llllllllllllllIIlIIIlIIlIIlIllll.length <= 9) {
            return CommandBase.getTabCompletionCoordinate(llllllllllllllIIlIIIlIIlIIlIllll, 6, llllllllllllllIIlIIIlIIlIIlIlllI);
        }
        return (llllllllllllllIIlIIIlIIlIIlIllll.length == 10) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIlIIIlIIlIIlIllll, "masked", "all") : Collections.emptyList();
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIIlIIIlIIlIllllIll) {
        return "commands.compare.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
}
