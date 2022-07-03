package net.minecraft.command.server;

import net.minecraft.entity.player.*;
import net.minecraft.network.play.server.*;
import net.minecraft.entity.*;
import net.minecraft.server.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.command.*;

public class CommandTeleport extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIllIlIllIIIIlllIlIl) {
        return "commands.teleport.usage";
    }
    
    @Override
    public String getCommandName() {
        return "teleport";
    }
    
    private static void doTeleport(final Entity lllllllllllllIllIlIllIIIIlIIIIIl, final CoordinateArg lllllllllllllIllIlIllIIIIlIIIIII, final CoordinateArg lllllllllllllIllIlIllIIIIIllIlII, final CoordinateArg lllllllllllllIllIlIllIIIIIlllllI, final CoordinateArg lllllllllllllIllIlIllIIIIIllllIl, final CoordinateArg lllllllllllllIllIlIllIIIIIllllII) {
        if (lllllllllllllIllIlIllIIIIlIIIIIl instanceof EntityPlayerMP) {
            final Set<SPacketPlayerPosLook.EnumFlags> lllllllllllllIllIlIllIIIIIlllIll = EnumSet.noneOf(SPacketPlayerPosLook.EnumFlags.class);
            float lllllllllllllIllIlIllIIIIIlllIlI = (float)lllllllllllllIllIlIllIIIIIllllIl.getAmount();
            if (lllllllllllllIllIlIllIIIIIllllIl.isRelative()) {
                lllllllllllllIllIlIllIIIIIlllIll.add(SPacketPlayerPosLook.EnumFlags.Y_ROT);
            }
            else {
                lllllllllllllIllIlIllIIIIIlllIlI = MathHelper.wrapDegrees(lllllllllllllIllIlIllIIIIIlllIlI);
            }
            float lllllllllllllIllIlIllIIIIIlllIIl = (float)lllllllllllllIllIlIllIIIIIllllII.getAmount();
            if (lllllllllllllIllIlIllIIIIIllllII.isRelative()) {
                lllllllllllllIllIlIllIIIIIlllIll.add(SPacketPlayerPosLook.EnumFlags.X_ROT);
            }
            else {
                lllllllllllllIllIlIllIIIIIlllIIl = MathHelper.wrapDegrees(lllllllllllllIllIlIllIIIIIlllIIl);
            }
            lllllllllllllIllIlIllIIIIlIIIIIl.dismountRidingEntity();
            ((EntityPlayerMP)lllllllllllllIllIlIllIIIIlIIIIIl).connection.setPlayerLocation(lllllllllllllIllIlIllIIIIlIIIIII.getResult(), lllllllllllllIllIlIllIIIIIllIlII.getResult(), lllllllllllllIllIlIllIIIIIlllllI.getResult(), lllllllllllllIllIlIllIIIIIlllIlI, lllllllllllllIllIlIllIIIIIlllIIl, lllllllllllllIllIlIllIIIIIlllIll);
            lllllllllllllIllIlIllIIIIlIIIIIl.setRotationYawHead(lllllllllllllIllIlIllIIIIIlllIlI);
        }
        else {
            final float lllllllllllllIllIlIllIIIIIlllIII = (float)MathHelper.wrapDegrees(lllllllllllllIllIlIllIIIIIllllIl.getResult());
            float lllllllllllllIllIlIllIIIIIllIlll = (float)MathHelper.wrapDegrees(lllllllllllllIllIlIllIIIIIllllII.getResult());
            lllllllllllllIllIlIllIIIIIllIlll = MathHelper.clamp(lllllllllllllIllIlIllIIIIIllIlll, -90.0f, 90.0f);
            lllllllllllllIllIlIllIIIIlIIIIIl.setLocationAndAngles(lllllllllllllIllIlIllIIIIlIIIIII.getResult(), lllllllllllllIllIlIllIIIIIllIlII.getResult(), lllllllllllllIllIlIllIIIIIlllllI.getResult(), lllllllllllllIllIlIllIIIIIlllIII, lllllllllllllIllIlIllIIIIIllIlll);
            lllllllllllllIllIlIllIIIIlIIIIIl.setRotationYawHead(lllllllllllllIllIlIllIIIIIlllIII);
        }
        if (!(lllllllllllllIllIlIllIIIIlIIIIIl instanceof EntityLivingBase) || !((EntityLivingBase)lllllllllllllIllIlIllIIIIlIIIIIl).isElytraFlying()) {
            lllllllllllllIllIlIllIIIIlIIIIIl.motionY = 0.0;
            lllllllllllllIllIlIllIIIIlIIIIIl.onGround = true;
        }
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIllIlIllIIIIIlIIlIl, final ICommandSender lllllllllllllIllIlIllIIIIIlIlIII, final String[] lllllllllllllIllIlIllIIIIIlIIlll, @Nullable final BlockPos lllllllllllllIllIlIllIIIIIlIIllI) {
        if (lllllllllllllIllIlIllIIIIIlIIlll.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIllIlIllIIIIIlIIlll, lllllllllllllIllIlIllIIIIIlIIlIl.getAllUsernames());
        }
        return (lllllllllllllIllIlIllIIIIIlIIlll.length > 1 && lllllllllllllIllIlIllIIIIIlIIlll.length <= 4) ? CommandBase.getTabCompletionCoordinate(lllllllllllllIllIlIllIIIIIlIIlll, 1, lllllllllllllIllIlIllIIIIIlIIllI) : Collections.emptyList();
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllllIllIlIllIIIIIlIIIII, final int lllllllllllllIllIlIllIIIIIIllllI) {
        return lllllllllllllIllIlIllIIIIIIllllI == 0;
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIllIlIllIIIIlIlIlll, final ICommandSender lllllllllllllIllIlIllIIIIllIIlII, final String[] lllllllllllllIllIlIllIIIIlIlIlIl) throws CommandException {
        if (lllllllllllllIllIlIllIIIIlIlIlIl.length < 4) {
            throw new WrongUsageException("commands.teleport.usage", new Object[0]);
        }
        final Entity lllllllllllllIllIlIllIIIIllIIIlI = CommandBase.getEntity(lllllllllllllIllIlIllIIIIlIlIlll, lllllllllllllIllIlIllIIIIllIIlII, lllllllllllllIllIlIllIIIIlIlIlIl[0]);
        if (lllllllllllllIllIlIllIIIIllIIIlI.world != null) {
            final int lllllllllllllIllIlIllIIIIllIIIIl = 4096;
            final Vec3d lllllllllllllIllIlIllIIIIllIIIII = lllllllllllllIllIlIllIIIIllIIlII.getPositionVector();
            int lllllllllllllIllIlIllIIIIlIlllll = 1;
            final CoordinateArg lllllllllllllIllIlIllIIIIlIllllI = CommandBase.parseCoordinate(lllllllllllllIllIlIllIIIIllIIIII.xCoord, lllllllllllllIllIlIllIIIIlIlIlIl[lllllllllllllIllIlIllIIIIlIlllll++], true);
            final CoordinateArg lllllllllllllIllIlIllIIIIlIlllIl = CommandBase.parseCoordinate(lllllllllllllIllIlIllIIIIllIIIII.yCoord, lllllllllllllIllIlIllIIIIlIlIlIl[lllllllllllllIllIlIllIIIIlIlllll++], -4096, 4096, false);
            final CoordinateArg lllllllllllllIllIlIllIIIIlIlllII = CommandBase.parseCoordinate(lllllllllllllIllIlIllIIIIllIIIII.zCoord, lllllllllllllIllIlIllIIIIlIlIlIl[lllllllllllllIllIlIllIIIIlIlllll++], true);
            final Entity lllllllllllllIllIlIllIIIIlIllIll = (lllllllllllllIllIlIllIIIIllIIlII.getCommandSenderEntity() == null) ? lllllllllllllIllIlIllIIIIllIIIlI : lllllllllllllIllIlIllIIIIllIIlII.getCommandSenderEntity();
            final CoordinateArg lllllllllllllIllIlIllIIIIlIllIlI = CommandBase.parseCoordinate((lllllllllllllIllIlIllIIIIlIlIlIl.length > lllllllllllllIllIlIllIIIIlIlllll) ? ((double)lllllllllllllIllIlIllIIIIlIllIll.rotationYaw) : ((double)lllllllllllllIllIlIllIIIIllIIIlI.rotationYaw), (lllllllllllllIllIlIllIIIIlIlIlIl.length > lllllllllllllIllIlIllIIIIlIlllll) ? lllllllllllllIllIlIllIIIIlIlIlIl[lllllllllllllIllIlIllIIIIlIlllll] : "~", false);
            ++lllllllllllllIllIlIllIIIIlIlllll;
            final CoordinateArg lllllllllllllIllIlIllIIIIlIllIIl = CommandBase.parseCoordinate((lllllllllllllIllIlIllIIIIlIlIlIl.length > lllllllllllllIllIlIllIIIIlIlllll) ? ((double)lllllllllllllIllIlIllIIIIlIllIll.rotationPitch) : ((double)lllllllllllllIllIlIllIIIIllIIIlI.rotationPitch), (lllllllllllllIllIlIllIIIIlIlIlIl.length > lllllllllllllIllIlIllIIIIlIlllll) ? lllllllllllllIllIlIllIIIIlIlIlIl[lllllllllllllIllIlIllIIIIlIlllll] : "~", false);
            doTeleport(lllllllllllllIllIlIllIIIIllIIIlI, lllllllllllllIllIlIllIIIIlIllllI, lllllllllllllIllIlIllIIIIlIlllIl, lllllllllllllIllIlIllIIIIlIlllII, lllllllllllllIllIlIllIIIIlIllIlI, lllllllllllllIllIlIllIIIIlIllIIl);
            CommandBase.notifyCommandListener(lllllllllllllIllIlIllIIIIllIIlII, this, "commands.teleport.success.coordinates", lllllllllllllIllIlIllIIIIllIIIlI.getName(), lllllllllllllIllIlIllIIIIlIllllI.getResult(), lllllllllllllIllIlIllIIIIlIlllIl.getResult(), lllllllllllllIllIlIllIIIIlIlllII.getResult());
        }
    }
}
