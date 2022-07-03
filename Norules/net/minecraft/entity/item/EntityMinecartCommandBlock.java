package net.minecraft.entity.item;

import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import io.netty.buffer.*;
import net.minecraft.server.*;
import net.minecraft.util.text.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.datafix.*;
import net.minecraft.network.datasync.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;

public class EntityMinecartCommandBlock extends EntityMinecart
{
    private static final /* synthetic */ DataParameter<String> COMMAND;
    private final /* synthetic */ CommandBlockBaseLogic commandBlockLogic;
    private /* synthetic */ int activatorRailCooldown;
    private static final /* synthetic */ DataParameter<ITextComponent> LAST_OUTPUT;
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound llllllllllllllIllllIllIIIlIIlIII) {
        super.writeEntityToNBT(llllllllllllllIllllIllIIIlIIlIII);
        this.commandBlockLogic.writeToNBT(llllllllllllllIllllIllIIIlIIlIII);
    }
    
    public EntityMinecartCommandBlock(final World llllllllllllllIllllIllIIIllIIIlI, final double llllllllllllllIllllIllIIIllIIIIl, final double llllllllllllllIllllIllIIIllIIIII, final double llllllllllllllIllllIllIIIlIllIlI) {
        super(llllllllllllllIllllIllIIIllIIIlI, llllllllllllllIllllIllIIIllIIIIl, llllllllllllllIllllIllIIIllIIIII, llllllllllllllIllllIllIIIlIllIlI);
        this.commandBlockLogic = new CommandBlockBaseLogic() {
            @Override
            public BlockPos getPosition() {
                return new BlockPos(EntityMinecartCommandBlock.this.posX, EntityMinecartCommandBlock.this.posY + 0.5, EntityMinecartCommandBlock.this.posZ);
            }
            
            @Override
            public Vec3d getPositionVector() {
                return new Vec3d(EntityMinecartCommandBlock.this.posX, EntityMinecartCommandBlock.this.posY, EntityMinecartCommandBlock.this.posZ);
            }
            
            @Override
            public Entity getCommandSenderEntity() {
                return EntityMinecartCommandBlock.this;
            }
            
            @Override
            public World getEntityWorld() {
                return EntityMinecartCommandBlock.this.world;
            }
            
            @Override
            public void updateCommand() {
                EntityMinecartCommandBlock.this.getDataManager().set(EntityMinecartCommandBlock.COMMAND, this.getCommand());
                EntityMinecartCommandBlock.this.getDataManager().set(EntityMinecartCommandBlock.LAST_OUTPUT, this.getLastOutput());
            }
            
            @Override
            public void fillInInfo(final ByteBuf lllllllllllllIIIIllIlIIIlllIIIII) {
                lllllllllllllIIIIllIlIIIlllIIIII.writeInt(EntityMinecartCommandBlock.this.getEntityId());
            }
            
            @Override
            public MinecraftServer getServer() {
                return EntityMinecartCommandBlock.this.world.getMinecraftServer();
            }
            
            @Override
            public int getCommandBlockType() {
                return 1;
            }
        };
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataManager().register(EntityMinecartCommandBlock.COMMAND, "");
        this.getDataManager().register((DataParameter<TextComponentString>)EntityMinecartCommandBlock.LAST_OUTPUT, new TextComponentString(""));
    }
    
    public static void registerFixesMinecartCommand(final DataFixer llllllllllllllIllllIllIIIlIlIlll) {
        EntityMinecart.registerFixesMinecart(llllllllllllllIllllIllIIIlIlIlll, EntityMinecartCommandBlock.class);
        llllllllllllllIllllIllIIIlIlIlll.registerWalker(FixTypes.ENTITY, new IDataWalker() {
            @Override
            public NBTTagCompound process(final IDataFixer lllllllllllllIIllIllllIIIllIIlIl, final NBTTagCompound lllllllllllllIIllIllllIIIllIIlII, final int lllllllllllllIIllIllllIIIllIIllI) {
                if (TileEntity.func_190559_a(TileEntityCommandBlock.class).equals(new ResourceLocation(lllllllllllllIIllIllllIIIllIIlII.getString("id")))) {
                    lllllllllllllIIllIllllIIIllIIlII.setString("id", "Control");
                    lllllllllllllIIllIllllIIIllIIlIl.process(FixTypes.BLOCK_ENTITY, lllllllllllllIIllIllllIIIllIIlII, lllllllllllllIIllIllllIIIllIIllI);
                    lllllllllllllIIllIllllIIIllIIlII.setString("id", "MinecartCommandBlock");
                }
                return lllllllllllllIIllIllllIIIllIIlII;
            }
        });
    }
    
    public EntityMinecartCommandBlock(final World llllllllllllllIllllIllIIIllIlIll) {
        super(llllllllllllllIllllIllIIIllIlIll);
        this.commandBlockLogic = new CommandBlockBaseLogic() {
            @Override
            public BlockPos getPosition() {
                return new BlockPos(EntityMinecartCommandBlock.this.posX, EntityMinecartCommandBlock.this.posY + 0.5, EntityMinecartCommandBlock.this.posZ);
            }
            
            @Override
            public Vec3d getPositionVector() {
                return new Vec3d(EntityMinecartCommandBlock.this.posX, EntityMinecartCommandBlock.this.posY, EntityMinecartCommandBlock.this.posZ);
            }
            
            @Override
            public Entity getCommandSenderEntity() {
                return EntityMinecartCommandBlock.this;
            }
            
            @Override
            public World getEntityWorld() {
                return EntityMinecartCommandBlock.this.world;
            }
            
            @Override
            public void updateCommand() {
                EntityMinecartCommandBlock.this.getDataManager().set(EntityMinecartCommandBlock.COMMAND, this.getCommand());
                EntityMinecartCommandBlock.this.getDataManager().set(EntityMinecartCommandBlock.LAST_OUTPUT, this.getLastOutput());
            }
            
            @Override
            public void fillInInfo(final ByteBuf lllllllllllllIIIIllIlIIIlllIIIII) {
                lllllllllllllIIIIllIlIIIlllIIIII.writeInt(EntityMinecartCommandBlock.this.getEntityId());
            }
            
            @Override
            public MinecraftServer getServer() {
                return EntityMinecartCommandBlock.this.world.getMinecraftServer();
            }
            
            @Override
            public int getCommandBlockType() {
                return 1;
            }
        };
    }
    
    @Override
    public Type getType() {
        return Type.COMMAND_BLOCK;
    }
    
    public CommandBlockBaseLogic getCommandBlockLogic() {
        return this.commandBlockLogic;
    }
    
    static {
        COMMAND = EntityDataManager.createKey(EntityMinecartCommandBlock.class, DataSerializers.STRING);
        LAST_OUTPUT = EntityDataManager.createKey(EntityMinecartCommandBlock.class, DataSerializers.TEXT_COMPONENT);
    }
    
    @Override
    public void onActivatorRailPass(final int llllllllllllllIllllIllIIIIllllll, final int llllllllllllllIllllIllIIIIlllllI, final int llllllllllllllIllllIllIIIIllllIl, final boolean llllllllllllllIllllIllIIIIllllII) {
        if (llllllllllllllIllllIllIIIIllllII && this.ticksExisted - this.activatorRailCooldown >= 4) {
            this.getCommandBlockLogic().trigger(this.world);
            this.activatorRailCooldown = this.ticksExisted;
        }
    }
    
    @Override
    public IBlockState getDefaultDisplayTile() {
        return Blocks.COMMAND_BLOCK.getDefaultState();
    }
    
    @Override
    public boolean processInitialInteract(final EntityPlayer llllllllllllllIllllIllIIIIllIllI, final EnumHand llllllllllllllIllllIllIIIIllIlIl) {
        this.commandBlockLogic.tryOpenEditCommandBlock(llllllllllllllIllllIllIIIIllIllI);
        return false;
    }
    
    @Override
    public void notifyDataManagerChange(final DataParameter<?> llllllllllllllIllllIllIIIIlIllII) {
        super.notifyDataManagerChange(llllllllllllllIllllIllIIIIlIllII);
        if (EntityMinecartCommandBlock.LAST_OUTPUT.equals(llllllllllllllIllllIllIIIIlIllII)) {
            try {
                this.commandBlockLogic.setLastOutput(this.getDataManager().get(EntityMinecartCommandBlock.LAST_OUTPUT));
            }
            catch (Throwable llllllllllllllIllllIllIIIIlIlIll) {}
        }
        else if (EntityMinecartCommandBlock.COMMAND.equals(llllllllllllllIllllIllIIIIlIllII)) {
            this.commandBlockLogic.setCommand(this.getDataManager().get(EntityMinecartCommandBlock.COMMAND));
        }
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound llllllllllllllIllllIllIIIlIlIIII) {
        super.readEntityFromNBT(llllllllllllllIllllIllIIIlIlIIII);
        this.commandBlockLogic.readDataFromNBT(llllllllllllllIllllIllIIIlIlIIII);
        this.getDataManager().set(EntityMinecartCommandBlock.COMMAND, this.getCommandBlockLogic().getCommand());
        this.getDataManager().set(EntityMinecartCommandBlock.LAST_OUTPUT, this.getCommandBlockLogic().getLastOutput());
    }
    
    @Override
    public boolean ignoreItemEntityData() {
        return true;
    }
}
