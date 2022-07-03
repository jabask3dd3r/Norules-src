package net.minecraft.command;

import net.minecraft.util.text.*;
import net.minecraft.server.*;
import javax.annotation.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;

public interface ICommandSender
{
    default boolean sendCommandFeedback() {
        return false;
    }
    
    default ITextComponent getDisplayName() {
        return new TextComponentString(this.getName());
    }
    
    @Nullable
    MinecraftServer getServer();
    
    World getEntityWorld();
    
    boolean canCommandSenderUseCommand(final int p0, final String p1);
    
    default BlockPos getPosition() {
        return BlockPos.ORIGIN;
    }
    
    default void setCommandStat(final CommandResultStats.Type lllllllllllllIIIIllIIlIllIlIlllI, final int lllllllllllllIIIIllIIlIllIlIllIl) {
    }
    
    default void addChatMessage(final ITextComponent lllllllllllllIIIIllIIlIllIllIlII) {
    }
    
    default Vec3d getPositionVector() {
        return Vec3d.ZERO;
    }
    
    String getName();
    
    @Nullable
    default Entity getCommandSenderEntity() {
        return null;
    }
}
