package net.minecraft.command;

import net.minecraft.server.*;
import javax.annotation.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;

public class CommandParticle extends CommandBase
{
    @Override
    public String getCommandName() {
        return "particle";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIlllIlIlIIIIIlIIIII, final ICommandSender lllllllllllllIlllIlIlIIIIIIlllll, final String[] lllllllllllllIlllIlIlIIIIIIllIll, @Nullable final BlockPos lllllllllllllIlllIlIlIIIIIIlllIl) {
        if (lllllllllllllIlllIlIlIIIIIIllIll.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIlllIlIlIIIIIIllIll, EnumParticleTypes.getParticleNames());
        }
        if (lllllllllllllIlllIlIlIIIIIIllIll.length > 1 && lllllllllllllIlllIlIlIIIIIIllIll.length <= 4) {
            return CommandBase.getTabCompletionCoordinate(lllllllllllllIlllIlIlIIIIIIllIll, 1, lllllllllllllIlllIlIlIIIIIIlllIl);
        }
        if (lllllllllllllIlllIlIlIIIIIIllIll.length == 10) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIlllIlIlIIIIIIllIll, "normal", "force");
        }
        return (lllllllllllllIlllIlIlIIIIIIllIll.length == 11) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIlllIlIlIIIIIIllIll, lllllllllllllIlllIlIlIIIIIlIIIII.getAllUsernames()) : Collections.emptyList();
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIlllIlIlIIIIIlllIII, final ICommandSender lllllllllllllIlllIlIlIIIIIllIlll, final String[] lllllllllllllIlllIlIlIIIIIllIllI) throws CommandException {
        if (lllllllllllllIlllIlIlIIIIIllIllI.length < 8) {
            throw new WrongUsageException("commands.particle.usage", new Object[0]);
        }
        final boolean lllllllllllllIlllIlIlIIIIlIIllIl = false;
        final EnumParticleTypes lllllllllllllIlllIlIlIIIIlIIllII = EnumParticleTypes.getByName(lllllllllllllIlllIlIlIIIIIllIllI[0]);
        if (lllllllllllllIlllIlIlIIIIlIIllII == null) {
            throw new CommandException("commands.particle.notFound", new Object[] { lllllllllllllIlllIlIlIIIIIllIllI[0] });
        }
        final String lllllllllllllIlllIlIlIIIIlIIlIll = lllllllllllllIlllIlIlIIIIIllIllI[0];
        final Vec3d lllllllllllllIlllIlIlIIIIlIIlIlI = lllllllllllllIlllIlIlIIIIIllIlll.getPositionVector();
        final double lllllllllllllIlllIlIlIIIIlIIlIIl = (float)CommandBase.parseDouble(lllllllllllllIlllIlIlIIIIlIIlIlI.xCoord, lllllllllllllIlllIlIlIIIIIllIllI[1], true);
        final double lllllllllllllIlllIlIlIIIIlIIlIII = (float)CommandBase.parseDouble(lllllllllllllIlllIlIlIIIIlIIlIlI.yCoord, lllllllllllllIlllIlIlIIIIIllIllI[2], true);
        final double lllllllllllllIlllIlIlIIIIlIIIlll = (float)CommandBase.parseDouble(lllllllllllllIlllIlIlIIIIlIIlIlI.zCoord, lllllllllllllIlllIlIlIIIIIllIllI[3], true);
        final double lllllllllllllIlllIlIlIIIIlIIIllI = (float)CommandBase.parseDouble(lllllllllllllIlllIlIlIIIIIllIllI[4]);
        final double lllllllllllllIlllIlIlIIIIlIIIlIl = (float)CommandBase.parseDouble(lllllllllllllIlllIlIlIIIIIllIllI[5]);
        final double lllllllllllllIlllIlIlIIIIlIIIlII = (float)CommandBase.parseDouble(lllllllllllllIlllIlIlIIIIIllIllI[6]);
        final double lllllllllllllIlllIlIlIIIIlIIIIll = (float)CommandBase.parseDouble(lllllllllllllIlllIlIlIIIIIllIllI[7]);
        int lllllllllllllIlllIlIlIIIIlIIIIlI = 0;
        if (lllllllllllllIlllIlIlIIIIIllIllI.length > 8) {
            lllllllllllllIlllIlIlIIIIlIIIIlI = CommandBase.parseInt(lllllllllllllIlllIlIlIIIIIllIllI[8], 0);
        }
        boolean lllllllllllllIlllIlIlIIIIlIIIIIl = false;
        if (lllllllllllllIlllIlIlIIIIIllIllI.length > 9 && "force".equals(lllllllllllllIlllIlIlIIIIIllIllI[9])) {
            lllllllllllllIlllIlIlIIIIlIIIIIl = true;
        }
        EntityPlayerMP lllllllllllllIlllIlIlIIIIIllllll = null;
        if (lllllllllllllIlllIlIlIIIIIllIllI.length > 10) {
            final EntityPlayerMP lllllllllllllIlllIlIlIIIIlIIIIII = CommandBase.getPlayer(lllllllllllllIlllIlIlIIIIIlllIII, lllllllllllllIlllIlIlIIIIIllIlll, lllllllllllllIlllIlIlIIIIIllIllI[10]);
        }
        else {
            lllllllllllllIlllIlIlIIIIIllllll = null;
        }
        final int[] lllllllllllllIlllIlIlIIIIIlllllI = new int[lllllllllllllIlllIlIlIIIIlIIllII.getArgumentCount()];
        for (int lllllllllllllIlllIlIlIIIIIllllIl = 0; lllllllllllllIlllIlIlIIIIIllllIl < lllllllllllllIlllIlIlIIIIIlllllI.length; ++lllllllllllllIlllIlIlIIIIIllllIl) {
            if (lllllllllllllIlllIlIlIIIIIllIllI.length > 11 + lllllllllllllIlllIlIlIIIIIllllIl) {
                try {
                    lllllllllllllIlllIlIlIIIIIlllllI[lllllllllllllIlllIlIlIIIIIllllIl] = Integer.parseInt(lllllllllllllIlllIlIlIIIIIllIllI[11 + lllllllllllllIlllIlIlIIIIIllllIl]);
                }
                catch (NumberFormatException lllllllllllllIlllIlIlIIIIIllllII) {
                    throw new CommandException("commands.particle.invalidParam", new Object[] { lllllllllllllIlllIlIlIIIIIllIllI[11 + lllllllllllllIlllIlIlIIIIIllllIl] });
                }
            }
        }
        final World lllllllllllllIlllIlIlIIIIIlllIll = lllllllllllllIlllIlIlIIIIIllIlll.getEntityWorld();
        if (lllllllllllllIlllIlIlIIIIIlllIll instanceof WorldServer) {
            final WorldServer lllllllllllllIlllIlIlIIIIIlllIlI = (WorldServer)lllllllllllllIlllIlIlIIIIIlllIll;
            if (lllllllllllllIlllIlIlIIIIIllllll == null) {
                lllllllllllllIlllIlIlIIIIIlllIlI.spawnParticle(lllllllllllllIlllIlIlIIIIlIIllII, lllllllllllllIlllIlIlIIIIlIIIIIl, lllllllllllllIlllIlIlIIIIlIIlIIl, lllllllllllllIlllIlIlIIIIlIIlIII, lllllllllllllIlllIlIlIIIIlIIIlll, lllllllllllllIlllIlIlIIIIlIIIIlI, lllllllllllllIlllIlIlIIIIlIIIllI, lllllllllllllIlllIlIlIIIIlIIIlIl, lllllllllllllIlllIlIlIIIIlIIIlII, lllllllllllllIlllIlIlIIIIlIIIIll, lllllllllllllIlllIlIlIIIIIlllllI);
            }
            else {
                lllllllllllllIlllIlIlIIIIIlllIlI.spawnParticle(lllllllllllllIlllIlIlIIIIIllllll, lllllllllllllIlllIlIlIIIIlIIllII, lllllllllllllIlllIlIlIIIIlIIIIIl, lllllllllllllIlllIlIlIIIIlIIlIIl, lllllllllllllIlllIlIlIIIIlIIlIII, lllllllllllllIlllIlIlIIIIlIIIlll, lllllllllllllIlllIlIlIIIIlIIIIlI, lllllllllllllIlllIlIlIIIIlIIIllI, lllllllllllllIlllIlIlIIIIlIIIlIl, lllllllllllllIlllIlIlIIIIlIIIlII, lllllllllllllIlllIlIlIIIIlIIIIll, lllllllllllllIlllIlIlIIIIIlllllI);
            }
            CommandBase.notifyCommandListener(lllllllllllllIlllIlIlIIIIIllIlll, this, "commands.particle.success", lllllllllllllIlllIlIlIIIIlIIlIll, Math.max(lllllllllllllIlllIlIlIIIIlIIIIlI, 1));
        }
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllllIlllIlIlIIIIIIlIlll, final int lllllllllllllIlllIlIlIIIIIIlIlIl) {
        return lllllllllllllIlllIlIlIIIIIIlIlIl == 10;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIlllIlIlIIIIllIIlll) {
        return "commands.particle.usage";
    }
}
