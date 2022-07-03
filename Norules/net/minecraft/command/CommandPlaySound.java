package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import net.minecraft.util.*;
import java.util.*;

public class CommandPlaySound extends CommandBase
{
    @Override
    public String getCommandName() {
        return "playsound";
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lIlIlIlIIlIII, final int lIlIlIlIIIlll) {
        return lIlIlIlIIIlll == 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lIlIllIIllIII) {
        return "commands.playsound.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public void execute(final MinecraftServer lIlIllIIIIIII, final ICommandSender lIlIlIlllllll, final String[] lIlIlIllIIlll) throws CommandException {
        if (lIlIlIllIIlll.length < 2) {
            throw new WrongUsageException(this.getCommandUsage(lIlIlIlllllll), new Object[0]);
        }
        int lIlIlIlllllIl = 0;
        final String lIlIlIlllllII = lIlIlIllIIlll[lIlIlIlllllIl++];
        final String lIlIlIllllIll = lIlIlIllIIlll[lIlIlIlllllIl++];
        final SoundCategory lIlIlIllllIlI = SoundCategory.getByName(lIlIlIllllIll);
        if (lIlIlIllllIlI == null) {
            throw new CommandException("commands.playsound.unknownSoundSource", new Object[] { lIlIlIllllIll });
        }
        final EntityPlayerMP lIlIlIllllIIl = CommandBase.getPlayer(lIlIllIIIIIII, lIlIlIlllllll, lIlIlIllIIlll[lIlIlIlllllIl++]);
        final Vec3d lIlIlIllllIII = lIlIlIlllllll.getPositionVector();
        double lIlIlIlllIlll = (lIlIlIllIIlll.length > lIlIlIlllllIl) ? CommandBase.parseDouble(lIlIlIllllIII.xCoord, lIlIlIllIIlll[lIlIlIlllllIl++], true) : lIlIlIllllIII.xCoord;
        double lIlIlIlllIllI = (lIlIlIllIIlll.length > lIlIlIlllllIl) ? CommandBase.parseDouble(lIlIlIllllIII.yCoord, lIlIlIllIIlll[lIlIlIlllllIl++], 0, 0, false) : lIlIlIllllIII.yCoord;
        double lIlIlIlllIlIl = (lIlIlIllIIlll.length > lIlIlIlllllIl) ? CommandBase.parseDouble(lIlIlIllllIII.zCoord, lIlIlIllIIlll[lIlIlIlllllIl++], true) : lIlIlIllllIII.zCoord;
        double lIlIlIlllIlII = (lIlIlIllIIlll.length > lIlIlIlllllIl) ? CommandBase.parseDouble(lIlIlIllIIlll[lIlIlIlllllIl++], 0.0, 3.4028234663852886E38) : 1.0;
        final double lIlIlIlllIIll = (lIlIlIllIIlll.length > lIlIlIlllllIl) ? CommandBase.parseDouble(lIlIlIllIIlll[lIlIlIlllllIl++], 0.0, 2.0) : 1.0;
        final double lIlIlIlllIIlI = (lIlIlIllIIlll.length > lIlIlIlllllIl) ? CommandBase.parseDouble(lIlIlIllIIlll[lIlIlIlllllIl], 0.0, 1.0) : 0.0;
        final double lIlIlIlllIIIl = (lIlIlIlllIlII > 1.0) ? (lIlIlIlllIlII * 16.0) : 16.0;
        final double lIlIlIlllIIII = lIlIlIllllIIl.getDistance(lIlIlIlllIlll, lIlIlIlllIllI, lIlIlIlllIlIl);
        if (lIlIlIlllIIII > lIlIlIlllIIIl) {
            if (lIlIlIlllIIlI <= 0.0) {
                throw new CommandException("commands.playsound.playerTooFar", new Object[] { lIlIlIllllIIl.getName() });
            }
            final double lIlIlIllIllll = lIlIlIlllIlll - lIlIlIllllIIl.posX;
            final double lIlIlIllIlllI = lIlIlIlllIllI - lIlIlIllllIIl.posY;
            final double lIlIlIllIllIl = lIlIlIlllIlIl - lIlIlIllllIIl.posZ;
            final double lIlIlIllIllII = Math.sqrt(lIlIlIllIllll * lIlIlIllIllll + lIlIlIllIlllI * lIlIlIllIlllI + lIlIlIllIllIl * lIlIlIllIllIl);
            if (lIlIlIllIllII > 0.0) {
                lIlIlIlllIlll = lIlIlIllllIIl.posX + lIlIlIllIllll / lIlIlIllIllII * 2.0;
                lIlIlIlllIllI = lIlIlIllllIIl.posY + lIlIlIllIlllI / lIlIlIllIllII * 2.0;
                lIlIlIlllIlIl = lIlIlIllllIIl.posZ + lIlIlIllIllIl / lIlIlIllIllII * 2.0;
            }
            lIlIlIlllIlII = lIlIlIlllIIlI;
        }
        lIlIlIllllIIl.connection.sendPacket(new SPacketCustomSound(lIlIlIlllllII, lIlIlIllllIlI, lIlIlIlllIlll, lIlIlIlllIllI, lIlIlIlllIlIl, (float)lIlIlIlllIlII, (float)lIlIlIlllIIll));
        CommandBase.notifyCommandListener(lIlIlIlllllll, this, "commands.playsound.success", lIlIlIlllllII, lIlIlIllllIIl.getName());
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lIlIlIlIIllIl, final ICommandSender lIlIlIlIlIIII, final String[] lIlIlIlIIllII, @Nullable final BlockPos lIlIlIlIIlllI) {
        if (lIlIlIlIIllII.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lIlIlIlIIllII, SoundEvent.REGISTRY.getKeys());
        }
        if (lIlIlIlIIllII.length == 2) {
            return CommandBase.getListOfStringsMatchingLastWord(lIlIlIlIIllII, SoundCategory.getSoundCategoryNames());
        }
        if (lIlIlIlIIllII.length == 3) {
            return CommandBase.getListOfStringsMatchingLastWord(lIlIlIlIIllII, lIlIlIlIIllIl.getAllUsernames());
        }
        return (lIlIlIlIIllII.length > 3 && lIlIlIlIIllII.length <= 6) ? CommandBase.getTabCompletionCoordinate(lIlIlIlIIllII, 3, lIlIlIlIIlllI) : Collections.emptyList();
    }
}
