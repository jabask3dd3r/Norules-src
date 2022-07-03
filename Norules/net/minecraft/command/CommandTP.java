package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.play.server.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;

public class CommandTP extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllIlIIIllllllllIIlll, final ICommandSender llllllllllllllIlIIIllllllllIIllI, final String[] llllllllllllllIlIIIlllllllIlIllI) throws CommandException {
        if (llllllllllllllIlIIIlllllllIlIllI.length < 1) {
            throw new WrongUsageException("commands.tp.usage", new Object[0]);
        }
        int llllllllllllllIlIIIllllllllIIlII = 0;
        Entity llllllllllllllIlIIIllllllllIIIlI = null;
        if (llllllllllllllIlIIIlllllllIlIllI.length != 2 && llllllllllllllIlIIIlllllllIlIllI.length != 4 && llllllllllllllIlIIIlllllllIlIllI.length != 6) {
            final Entity llllllllllllllIlIIIllllllllIIIll = CommandBase.getCommandSenderAsPlayer(llllllllllllllIlIIIllllllllIIllI);
        }
        else {
            llllllllllllllIlIIIllllllllIIIlI = CommandBase.getEntity(llllllllllllllIlIIIllllllllIIlll, llllllllllllllIlIIIllllllllIIllI, llllllllllllllIlIIIlllllllIlIllI[0]);
            llllllllllllllIlIIIllllllllIIlII = 1;
        }
        if (llllllllllllllIlIIIlllllllIlIllI.length != 1 && llllllllllllllIlIIIlllllllIlIllI.length != 2) {
            if (llllllllllllllIlIIIlllllllIlIllI.length < llllllllllllllIlIIIllllllllIIlII + 3) {
                throw new WrongUsageException("commands.tp.usage", new Object[0]);
            }
            if (llllllllllllllIlIIIllllllllIIIlI.world != null) {
                final int llllllllllllllIlIIIllllllllIIIIl = 4096;
                int llllllllllllllIlIIIllllllllIIIII = llllllllllllllIlIIIllllllllIIlII + 1;
                final CoordinateArg llllllllllllllIlIIIlllllllIlllll = CommandBase.parseCoordinate(llllllllllllllIlIIIllllllllIIIlI.posX, llllllllllllllIlIIIlllllllIlIllI[llllllllllllllIlIIIllllllllIIlII], true);
                final CoordinateArg llllllllllllllIlIIIlllllllIllllI = CommandBase.parseCoordinate(llllllllllllllIlIIIllllllllIIIlI.posY, llllllllllllllIlIIIlllllllIlIllI[llllllllllllllIlIIIllllllllIIIII++], -4096, 4096, false);
                final CoordinateArg llllllllllllllIlIIIlllllllIlllIl = CommandBase.parseCoordinate(llllllllllllllIlIIIllllllllIIIlI.posZ, llllllllllllllIlIIIlllllllIlIllI[llllllllllllllIlIIIllllllllIIIII++], true);
                final CoordinateArg llllllllllllllIlIIIlllllllIlllII = CommandBase.parseCoordinate(llllllllllllllIlIIIllllllllIIIlI.rotationYaw, (llllllllllllllIlIIIlllllllIlIllI.length > llllllllllllllIlIIIllllllllIIIII) ? llllllllllllllIlIIIlllllllIlIllI[llllllllllllllIlIIIllllllllIIIII++] : "~", false);
                final CoordinateArg llllllllllllllIlIIIlllllllIllIll = CommandBase.parseCoordinate(llllllllllllllIlIIIllllllllIIIlI.rotationPitch, (llllllllllllllIlIIIlllllllIlIllI.length > llllllllllllllIlIIIllllllllIIIII) ? llllllllllllllIlIIIlllllllIlIllI[llllllllllllllIlIIIllllllllIIIII] : "~", false);
                teleportEntityToCoordinates(llllllllllllllIlIIIllllllllIIIlI, llllllllllllllIlIIIlllllllIlllll, llllllllllllllIlIIIlllllllIllllI, llllllllllllllIlIIIlllllllIlllIl, llllllllllllllIlIIIlllllllIlllII, llllllllllllllIlIIIlllllllIllIll);
                CommandBase.notifyCommandListener(llllllllllllllIlIIIllllllllIIllI, this, "commands.tp.success.coordinates", llllllllllllllIlIIIllllllllIIIlI.getName(), llllllllllllllIlIIIlllllllIlllll.getResult(), llllllllllllllIlIIIlllllllIllllI.getResult(), llllllllllllllIlIIIlllllllIlllIl.getResult());
            }
        }
        else {
            final Entity llllllllllllllIlIIIlllllllIllIlI = CommandBase.getEntity(llllllllllllllIlIIIllllllllIIlll, llllllllllllllIlIIIllllllllIIllI, llllllllllllllIlIIIlllllllIlIllI[llllllllllllllIlIIIlllllllIlIllI.length - 1]);
            if (llllllllllllllIlIIIlllllllIllIlI.world != llllllllllllllIlIIIllllllllIIIlI.world) {
                throw new CommandException("commands.tp.notSameDimension", new Object[0]);
            }
            llllllllllllllIlIIIllllllllIIIlI.dismountRidingEntity();
            if (llllllllllllllIlIIIllllllllIIIlI instanceof EntityPlayerMP) {
                ((EntityPlayerMP)llllllllllllllIlIIIllllllllIIIlI).connection.setPlayerLocation(llllllllllllllIlIIIlllllllIllIlI.posX, llllllllllllllIlIIIlllllllIllIlI.posY, llllllllllllllIlIIIlllllllIllIlI.posZ, llllllllllllllIlIIIlllllllIllIlI.rotationYaw, llllllllllllllIlIIIlllllllIllIlI.rotationPitch);
            }
            else {
                llllllllllllllIlIIIllllllllIIIlI.setLocationAndAngles(llllllllllllllIlIIIlllllllIllIlI.posX, llllllllllllllIlIIIlllllllIllIlI.posY, llllllllllllllIlIIIlllllllIllIlI.posZ, llllllllllllllIlIIIlllllllIllIlI.rotationYaw, llllllllllllllIlIIIlllllllIllIlI.rotationPitch);
            }
            CommandBase.notifyCommandListener(llllllllllllllIlIIIllllllllIIllI, this, "commands.tp.success", llllllllllllllIlIIIllllllllIIIlI.getName(), llllllllllllllIlIIIlllllllIllIlI.getName());
        }
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIlIIIlllllllllIllI) {
        return "commands.tp.usage";
    }
    
    private static void teleportEntityToCoordinates(final Entity llllllllllllllIlIIIllllllIlllIII, final CoordinateArg llllllllllllllIlIIIlllllllIIIIlI, final CoordinateArg llllllllllllllIlIIIllllllIllIllI, final CoordinateArg llllllllllllllIlIIIlllllllIIIIII, final CoordinateArg llllllllllllllIlIIIllllllIllIlII, final CoordinateArg llllllllllllllIlIIIllllllIlllllI) {
        if (llllllllllllllIlIIIllllllIlllIII instanceof EntityPlayerMP) {
            final Set<SPacketPlayerPosLook.EnumFlags> llllllllllllllIlIIIllllllIllllIl = EnumSet.noneOf(SPacketPlayerPosLook.EnumFlags.class);
            if (llllllllllllllIlIIIlllllllIIIIlI.isRelative()) {
                llllllllllllllIlIIIllllllIllllIl.add(SPacketPlayerPosLook.EnumFlags.X);
            }
            if (llllllllllllllIlIIIllllllIllIllI.isRelative()) {
                llllllllllllllIlIIIllllllIllllIl.add(SPacketPlayerPosLook.EnumFlags.Y);
            }
            if (llllllllllllllIlIIIlllllllIIIIII.isRelative()) {
                llllllllllllllIlIIIllllllIllllIl.add(SPacketPlayerPosLook.EnumFlags.Z);
            }
            if (llllllllllllllIlIIIllllllIlllllI.isRelative()) {
                llllllllllllllIlIIIllllllIllllIl.add(SPacketPlayerPosLook.EnumFlags.X_ROT);
            }
            if (llllllllllllllIlIIIllllllIllIlII.isRelative()) {
                llllllllllllllIlIIIllllllIllllIl.add(SPacketPlayerPosLook.EnumFlags.Y_ROT);
            }
            float llllllllllllllIlIIIllllllIllllII = (float)llllllllllllllIlIIIllllllIllIlII.getAmount();
            if (!llllllllllllllIlIIIllllllIllIlII.isRelative()) {
                llllllllllllllIlIIIllllllIllllII = MathHelper.wrapDegrees(llllllllllllllIlIIIllllllIllllII);
            }
            float llllllllllllllIlIIIllllllIlllIll = (float)llllllllllllllIlIIIllllllIlllllI.getAmount();
            if (!llllllllllllllIlIIIllllllIlllllI.isRelative()) {
                llllllllllllllIlIIIllllllIlllIll = MathHelper.wrapDegrees(llllllllllllllIlIIIllllllIlllIll);
            }
            llllllllllllllIlIIIllllllIlllIII.dismountRidingEntity();
            ((EntityPlayerMP)llllllllllllllIlIIIllllllIlllIII).connection.setPlayerLocation(llllllllllllllIlIIIlllllllIIIIlI.getAmount(), llllllllllllllIlIIIllllllIllIllI.getAmount(), llllllllllllllIlIIIlllllllIIIIII.getAmount(), llllllllllllllIlIIIllllllIllllII, llllllllllllllIlIIIllllllIlllIll, llllllllllllllIlIIIllllllIllllIl);
            llllllllllllllIlIIIllllllIlllIII.setRotationYawHead(llllllllllllllIlIIIllllllIllllII);
        }
        else {
            final float llllllllllllllIlIIIllllllIlllIlI = (float)MathHelper.wrapDegrees(llllllllllllllIlIIIllllllIllIlII.getResult());
            float llllllllllllllIlIIIllllllIlllIIl = (float)MathHelper.wrapDegrees(llllllllllllllIlIIIllllllIlllllI.getResult());
            llllllllllllllIlIIIllllllIlllIIl = MathHelper.clamp(llllllllllllllIlIIIllllllIlllIIl, -90.0f, 90.0f);
            llllllllllllllIlIIIllllllIlllIII.setLocationAndAngles(llllllllllllllIlIIIlllllllIIIIlI.getResult(), llllllllllllllIlIIIllllllIllIllI.getResult(), llllllllllllllIlIIIlllllllIIIIII.getResult(), llllllllllllllIlIIIllllllIlllIlI, llllllllllllllIlIIIllllllIlllIIl);
            llllllllllllllIlIIIllllllIlllIII.setRotationYawHead(llllllllllllllIlIIIllllllIlllIlI);
        }
        if (!(llllllllllllllIlIIIllllllIlllIII instanceof EntityLivingBase) || !((EntityLivingBase)llllllllllllllIlIIIllllllIlllIII).isElytraFlying()) {
            llllllllllllllIlIIIllllllIlllIII.motionY = 0.0;
            llllllllllllllIlIIIllllllIlllIII.onGround = true;
        }
    }
    
    @Override
    public String getCommandName() {
        return "tp";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllllIlIIIllllllIlIlIII, final ICommandSender llllllllllllllIlIIIllllllIlIlIll, final String[] llllllllllllllIlIIIllllllIlIIlll, @Nullable final BlockPos llllllllllllllIlIIIllllllIlIlIIl) {
        return (llllllllllllllIlIIIllllllIlIIlll.length != 1 && llllllllllllllIlIIIllllllIlIIlll.length != 2) ? Collections.emptyList() : CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIlIIIllllllIlIIlll, llllllllllllllIlIIIllllllIlIlIII.getAllUsernames());
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllllIlIIIllllllIlIIlII, final int llllllllllllllIlIIIllllllIlIIIll) {
        return llllllllllllllIlIIIllllllIlIIIll == 0;
    }
}
