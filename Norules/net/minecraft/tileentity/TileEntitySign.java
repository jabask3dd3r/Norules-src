package net.minecraft.tileentity;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.nbt.*;
import net.minecraft.util.math.*;
import net.minecraft.server.*;
import net.minecraft.entity.*;
import net.minecraft.command.*;
import net.minecraft.util.text.event.*;
import net.minecraft.util.text.*;
import net.minecraft.network.play.server.*;
import javax.annotation.*;

public class TileEntitySign extends TileEntity
{
    public final /* synthetic */ ITextComponent[] signText;
    private /* synthetic */ EntityPlayer player;
    private /* synthetic */ boolean isEditable;
    private final /* synthetic */ CommandResultStats stats;
    public /* synthetic */ int lineBeingEdited;
    
    @Override
    protected void setWorldCreate(final World lllllllllllllllIlllllIIIllIllIll) {
        this.setWorldObj(lllllllllllllllIlllllIIIllIllIll);
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllllllIlllllIIIllIlIIII) {
        this.isEditable = false;
        super.readFromNBT(lllllllllllllllIlllllIIIllIlIIII);
        final ICommandSender lllllllllllllllIlllllIIIllIIllll = new ICommandSender() {
            @Override
            public BlockPos getPosition() {
                return TileEntitySign.this.pos;
            }
            
            @Override
            public Vec3d getPositionVector() {
                return new Vec3d(TileEntitySign.this.pos.getX() + 0.5, TileEntitySign.this.pos.getY() + 0.5, TileEntitySign.this.pos.getZ() + 0.5);
            }
            
            @Override
            public boolean canCommandSenderUseCommand(final int lllllllllllllIIIIllIIIIlIlIIIIlI, final String lllllllllllllIIIIllIIIIlIlIIIIIl) {
                return true;
            }
            
            @Override
            public World getEntityWorld() {
                return TileEntitySign.this.world;
            }
            
            @Override
            public MinecraftServer getServer() {
                return TileEntitySign.this.world.getMinecraftServer();
            }
            
            @Override
            public String getName() {
                return "Sign";
            }
        };
        for (int lllllllllllllllIlllllIIIllIIlllI = 0; lllllllllllllllIlllllIIIllIIlllI < 4; ++lllllllllllllllIlllllIIIllIIlllI) {
            final String lllllllllllllllIlllllIIIllIIllIl = lllllllllllllllIlllllIIIllIlIIII.getString(String.valueOf(new StringBuilder("Text").append(lllllllllllllllIlllllIIIllIIlllI + 1)));
            final ITextComponent lllllllllllllllIlllllIIIllIIllII = ITextComponent.Serializer.jsonToComponent(lllllllllllllllIlllllIIIllIIllIl);
            try {
                this.signText[lllllllllllllllIlllllIIIllIIlllI] = TextComponentUtils.processComponent(lllllllllllllllIlllllIIIllIIllll, lllllllllllllllIlllllIIIllIIllII, null);
            }
            catch (CommandException lllllllllllllllIlllllIIIllIIlIll) {
                this.signText[lllllllllllllllIlllllIIIllIIlllI] = lllllllllllllllIlllllIIIllIIllII;
            }
        }
        this.stats.readStatsFromNBT(lllllllllllllllIlllllIIIllIlIIII);
    }
    
    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }
    
    public EntityPlayer getPlayer() {
        return this.player;
    }
    
    public TileEntitySign() {
        this.signText = new ITextComponent[] { new TextComponentString(""), new TextComponentString(""), new TextComponentString(""), new TextComponentString("") };
        this.lineBeingEdited = -1;
        this.isEditable = true;
        this.stats = new CommandResultStats();
    }
    
    public void setPlayer(final EntityPlayer lllllllllllllllIlllllIIIlIlIlllI) {
        this.player = lllllllllllllllIlllllIIIlIlIlllI;
    }
    
    public boolean getIsEditable() {
        return this.isEditable;
    }
    
    @Override
    public boolean onlyOpsCanSetNbt() {
        return true;
    }
    
    public CommandResultStats getStats() {
        return this.stats;
    }
    
    public boolean executeCommand(final EntityPlayer lllllllllllllllIlllllIIIlIIllIlI) {
        final ICommandSender lllllllllllllllIlllllIIIlIIlllll = new ICommandSender() {
            @Override
            public MinecraftServer getServer() {
                return lllllllllllllllIlllllIIIlIIllIlI.getServer();
            }
            
            @Override
            public void addChatMessage(final ITextComponent llllllllllllllIllllllIlllIllIIlI) {
            }
            
            @Override
            public ITextComponent getDisplayName() {
                return lllllllllllllllIlllllIIIlIIllIlI.getDisplayName();
            }
            
            @Override
            public World getEntityWorld() {
                return lllllllllllllllIlllllIIIlIIllIlI.getEntityWorld();
            }
            
            @Override
            public BlockPos getPosition() {
                return TileEntitySign.this.pos;
            }
            
            @Override
            public Vec3d getPositionVector() {
                return new Vec3d(TileEntitySign.this.pos.getX() + 0.5, TileEntitySign.this.pos.getY() + 0.5, TileEntitySign.this.pos.getZ() + 0.5);
            }
            
            @Override
            public void setCommandStat(final CommandResultStats.Type llllllllllllllIllllllIlllIIllIII, final int llllllllllllllIllllllIlllIIllIlI) {
                if (TileEntitySign.this.world != null && !TileEntitySign.this.world.isRemote) {
                    TileEntitySign.this.stats.setCommandStatForSender(TileEntitySign.this.world.getMinecraftServer(), this, llllllllllllllIllllllIlllIIllIII, llllllllllllllIllllllIlllIIllIlI);
                }
            }
            
            @Override
            public Entity getCommandSenderEntity() {
                return lllllllllllllllIlllllIIIlIIllIlI;
            }
            
            @Override
            public boolean canCommandSenderUseCommand(final int llllllllllllllIllllllIlllIlIllIl, final String llllllllllllllIllllllIlllIlIlllI) {
                return llllllllllllllIllllllIlllIlIllIl <= 2;
            }
            
            @Override
            public String getName() {
                return lllllllllllllllIlllllIIIlIIllIlI.getName();
            }
            
            @Override
            public boolean sendCommandFeedback() {
                return false;
            }
        };
        final byte lllllllllllllllIlllllIIIlIIlIlIl;
        final Exception lllllllllllllllIlllllIIIlIIlIllI = (Exception)((ITextComponent[])(Object)(lllllllllllllllIlllllIIIlIIlIlIl = (byte)(Object)this.signText)).length;
        for (char lllllllllllllllIlllllIIIlIIlIlll = '\0'; lllllllllllllllIlllllIIIlIIlIlll < lllllllllllllllIlllllIIIlIIlIllI; ++lllllllllllllllIlllllIIIlIIlIlll) {
            final ITextComponent lllllllllllllllIlllllIIIlIIllllI = lllllllllllllllIlllllIIIlIIlIlIl[lllllllllllllllIlllllIIIlIIlIlll];
            final Style lllllllllllllllIlllllIIIlIIlllIl = (lllllllllllllllIlllllIIIlIIllllI == null) ? null : lllllllllllllllIlllllIIIlIIllllI.getStyle();
            if (lllllllllllllllIlllllIIIlIIlllIl != null && lllllllllllllllIlllllIIIlIIlllIl.getClickEvent() != null) {
                final ClickEvent lllllllllllllllIlllllIIIlIIlllII = lllllllllllllllIlllllIIIlIIlllIl.getClickEvent();
                if (lllllllllllllllIlllllIIIlIIlllII.getAction() == ClickEvent.Action.RUN_COMMAND) {
                    lllllllllllllllIlllllIIIlIIllIlI.getServer().getCommandManager().executeCommand(lllllllllllllllIlllllIIIlIIlllll, lllllllllllllllIlllllIIIlIIlllII.getValue());
                }
            }
        }
        return true;
    }
    
    public void setEditable(final boolean lllllllllllllllIlllllIIIlIllIllI) {
        this.isEditable = lllllllllllllllIlllllIIIlIllIllI;
        if (!lllllllllllllllIlllllIIIlIllIllI) {
            this.player = null;
        }
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllllllIlllllIIIlllIlIlI) {
        super.writeToNBT(lllllllllllllllIlllllIIIlllIlIlI);
        for (int lllllllllllllllIlllllIIIlllIlllI = 0; lllllllllllllllIlllllIIIlllIlllI < 4; ++lllllllllllllllIlllllIIIlllIlllI) {
            final String lllllllllllllllIlllllIIIlllIllIl = ITextComponent.Serializer.componentToJson(this.signText[lllllllllllllllIlllllIIIlllIlllI]);
            lllllllllllllllIlllllIIIlllIlIlI.setString(String.valueOf(new StringBuilder("Text").append(lllllllllllllllIlllllIIIlllIlllI + 1)), lllllllllllllllIlllllIIIlllIllIl);
        }
        this.stats.writeStatsToNBT(lllllllllllllllIlllllIIIlllIlIlI);
        return lllllllllllllllIlllllIIIlllIlIlI;
    }
    
    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 9, this.getUpdateTag());
    }
}
