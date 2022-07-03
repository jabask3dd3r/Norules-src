package net.minecraft.tileentity;

import net.minecraft.command.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.server.*;
import net.minecraft.util.math.*;
import io.netty.buffer.*;
import net.minecraft.world.*;
import net.minecraft.network.play.server.*;
import javax.annotation.*;

public class TileEntityCommandBlock extends TileEntity
{
    private /* synthetic */ boolean conditionMet;
    private /* synthetic */ boolean sendToClient;
    private /* synthetic */ boolean auto;
    private final /* synthetic */ CommandBlockBaseLogic commandBlockLogic;
    private /* synthetic */ boolean powered;
    
    public boolean isPowered() {
        return this.powered;
    }
    
    public CommandResultStats getCommandResultStats() {
        return this.commandBlockLogic.getCommandResultStats();
    }
    
    public boolean isSendToClient() {
        return this.sendToClient;
    }
    
    public boolean isConditionMet() {
        return this.conditionMet;
    }
    
    public void setPowered(final boolean lllllllllllllIIIllIIllllIIlIIlll) {
        this.powered = lllllllllllllIIIllIIllllIIlIIlll;
    }
    
    @Override
    public boolean onlyOpsCanSetNbt() {
        return true;
    }
    
    public Mode getMode() {
        final Block lllllllllllllIIIllIIlllIlllllIlI = this.getBlockType();
        if (lllllllllllllIIIllIIlllIlllllIlI == Blocks.COMMAND_BLOCK) {
            return Mode.REDSTONE;
        }
        if (lllllllllllllIIIllIIlllIlllllIlI == Blocks.REPEATING_COMMAND_BLOCK) {
            return Mode.AUTO;
        }
        return (lllllllllllllIIIllIIlllIlllllIlI == Blocks.CHAIN_COMMAND_BLOCK) ? Mode.SEQUENCE : Mode.REDSTONE;
    }
    
    @Override
    public void validate() {
        this.blockType = null;
        super.validate();
    }
    
    public void setAuto(final boolean lllllllllllllIIIllIIllllIIIlIlIl) {
        final boolean lllllllllllllIIIllIIllllIIIllIII = this.auto;
        this.auto = lllllllllllllIIIllIIllllIIIlIlIl;
        if (!lllllllllllllIIIllIIllllIIIllIII && lllllllllllllIIIllIIllllIIIlIlIl && !this.powered && this.world != null && this.getMode() != Mode.SEQUENCE) {
            final Block lllllllllllllIIIllIIllllIIIlIlll = this.getBlockType();
            if (lllllllllllllIIIllIIllllIIIlIlll instanceof BlockCommandBlock) {
                this.setConditionMet();
                this.world.scheduleUpdate(this.pos, lllllllllllllIIIllIIllllIIIlIlll, lllllllllllllIIIllIIllllIIIlIlll.tickRate(this.world));
            }
        }
    }
    
    public boolean isConditional() {
        final IBlockState lllllllllllllIIIllIIlllIllllIlII = this.world.getBlockState(this.getPos());
        return lllllllllllllIIIllIIlllIllllIlII.getBlock() instanceof BlockCommandBlock && lllllllllllllIIIllIIlllIllllIlII.getValue((IProperty<Boolean>)BlockCommandBlock.CONDITIONAL);
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllllIIIllIIllllIlIIIIII) {
        super.writeToNBT(lllllllllllllIIIllIIllllIlIIIIII);
        this.commandBlockLogic.writeToNBT(lllllllllllllIIIllIIllllIlIIIIII);
        lllllllllllllIIIllIIllllIlIIIIII.setBoolean("powered", this.isPowered());
        lllllllllllllIIIllIIllllIlIIIIII.setBoolean("conditionMet", this.isConditionMet());
        lllllllllllllIIIllIIllllIlIIIIII.setBoolean("auto", this.isAuto());
        return lllllllllllllIIIllIIllllIlIIIIII;
    }
    
    public boolean setConditionMet() {
        this.conditionMet = true;
        if (this.isConditional()) {
            final BlockPos lllllllllllllIIIllIIllllIIIIlIll = this.pos.offset(this.world.getBlockState(this.pos).getValue((IProperty<EnumFacing>)BlockCommandBlock.FACING).getOpposite());
            if (this.world.getBlockState(lllllllllllllIIIllIIllllIIIIlIll).getBlock() instanceof BlockCommandBlock) {
                final TileEntity lllllllllllllIIIllIIllllIIIIlIlI = this.world.getTileEntity(lllllllllllllIIIllIIllllIIIIlIll);
                this.conditionMet = (lllllllllllllIIIllIIllllIIIIlIlI instanceof TileEntityCommandBlock && ((TileEntityCommandBlock)lllllllllllllIIIllIIllllIIIIlIlI).getCommandBlockLogic().getSuccessCount() > 0);
            }
            else {
                this.conditionMet = false;
            }
        }
        return this.conditionMet;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllllIIIllIIllllIIlllIII) {
        super.readFromNBT(lllllllllllllIIIllIIllllIIlllIII);
        this.commandBlockLogic.readDataFromNBT(lllllllllllllIIIllIIllllIIlllIII);
        this.powered = lllllllllllllIIIllIIllllIIlllIII.getBoolean("powered");
        this.conditionMet = lllllllllllllIIIllIIllllIIlllIII.getBoolean("conditionMet");
        this.setAuto(lllllllllllllIIIllIIllllIIlllIII.getBoolean("auto"));
    }
    
    public void setSendToClient(final boolean lllllllllllllIIIllIIlllIlllllllI) {
        this.sendToClient = lllllllllllllIIIllIIlllIlllllllI;
    }
    
    public CommandBlockBaseLogic getCommandBlockLogic() {
        return this.commandBlockLogic;
    }
    
    public TileEntityCommandBlock() {
        this.commandBlockLogic = new CommandBlockBaseLogic() {
            @Override
            public MinecraftServer getServer() {
                return TileEntityCommandBlock.this.world.getMinecraftServer();
            }
            
            @Override
            public int getCommandBlockType() {
                return 0;
            }
            
            @Override
            public Vec3d getPositionVector() {
                return new Vec3d(TileEntityCommandBlock.this.pos.getX() + 0.5, TileEntityCommandBlock.this.pos.getY() + 0.5, TileEntityCommandBlock.this.pos.getZ() + 0.5);
            }
            
            @Override
            public void setCommand(final String llllllllllllllIIIIlIIIIlllIlllIl) {
                super.setCommand(llllllllllllllIIIIlIIIIlllIlllIl);
                TileEntityCommandBlock.this.markDirty();
            }
            
            @Override
            public void fillInInfo(final ByteBuf llllllllllllllIIIIlIIIIlllIlIIlI) {
                llllllllllllllIIIIlIIIIlllIlIIlI.writeInt(TileEntityCommandBlock.this.pos.getX());
                llllllllllllllIIIIlIIIIlllIlIIlI.writeInt(TileEntityCommandBlock.this.pos.getY());
                llllllllllllllIIIIlIIIIlllIlIIlI.writeInt(TileEntityCommandBlock.this.pos.getZ());
            }
            
            @Override
            public BlockPos getPosition() {
                return TileEntityCommandBlock.this.pos;
            }
            
            @Override
            public World getEntityWorld() {
                return TileEntityCommandBlock.this.getWorld();
            }
            
            @Override
            public void updateCommand() {
                final IBlockState llllllllllllllIIIIlIIIIlllIllIIl = TileEntityCommandBlock.this.world.getBlockState(TileEntityCommandBlock.this.pos);
                TileEntityCommandBlock.this.getWorld().notifyBlockUpdate(TileEntityCommandBlock.this.pos, llllllllllllllIIIIlIIIIlllIllIIl, llllllllllllllIIIIlIIIIlllIllIIl, 3);
            }
        };
    }
    
    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        if (this.isSendToClient()) {
            this.setSendToClient(false);
            final NBTTagCompound lllllllllllllIIIllIIllllIIllIlII = this.writeToNBT(new NBTTagCompound());
            return new SPacketUpdateTileEntity(this.pos, 2, lllllllllllllIIIllIIllllIIllIlII);
        }
        return null;
    }
    
    public boolean isAuto() {
        return this.auto;
    }
    
    public enum Mode
    {
        AUTO("AUTO", 1), 
        SEQUENCE("SEQUENCE", 0), 
        REDSTONE("REDSTONE", 2);
        
        private Mode(final String lllllllllllllllllIlIIllIIIllIlll, final int lllllllllllllllllIlIIllIIIllIllI) {
        }
    }
}
