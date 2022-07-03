package net.minecraft.command;

import net.minecraft.server.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.text.*;
import net.minecraft.world.border.*;

public class CommandWorldBorder extends CommandBase
{
    @Override
    public String getCommandName() {
        return "worldborder";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIIIIlIlIIlIIIlllIII, final ICommandSender lllllllllllllIIIIlIlIIlIIIllIlll, final String[] lllllllllllllIIIIlIlIIlIIIllIlII, @Nullable final BlockPos lllllllllllllIIIIlIlIIlIIIllIlIl) {
        if (lllllllllllllIIIIlIlIIlIIIllIlII.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIIIlIlIIlIIIllIlII, "set", "center", "damage", "warning", "add", "get");
        }
        if (lllllllllllllIIIIlIlIIlIIIllIlII.length == 2 && "damage".equals(lllllllllllllIIIIlIlIIlIIIllIlII[0])) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIIIlIlIIlIIIllIlII, "buffer", "amount");
        }
        if (lllllllllllllIIIIlIlIIlIIIllIlII.length >= 2 && lllllllllllllIIIIlIlIIlIIIllIlII.length <= 3 && "center".equals(lllllllllllllIIIIlIlIIlIIIllIlII[0])) {
            return CommandBase.getTabCompletionCoordinateXZ(lllllllllllllIIIIlIlIIlIIIllIlII, 1, lllllllllllllIIIIlIlIIlIIIllIlIl);
        }
        return (lllllllllllllIIIIlIlIIlIIIllIlII.length == 2 && "warning".equals(lllllllllllllIIIIlIlIIlIIIllIlII[0])) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIIIlIlIIlIIIllIlII, "time", "distance") : Collections.emptyList();
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIIIIlIlIIlIIlIlllll, final ICommandSender lllllllllllllIIIIlIlIIlIIlIllllI, final String[] lllllllllllllIIIIlIlIIlIIlIIIllI) throws CommandException {
        if (lllllllllllllIIIIlIlIIlIIlIIIllI.length < 1) {
            throw new WrongUsageException("commands.worldborder.usage", new Object[0]);
        }
        final WorldBorder lllllllllllllIIIIlIlIIlIIlIlllII = this.getWorldBorder(lllllllllllllIIIIlIlIIlIIlIlllll);
        if ("set".equals(lllllllllllllIIIIlIlIIlIIlIIIllI[0])) {
            if (lllllllllllllIIIIlIlIIlIIlIIIllI.length != 2 && lllllllllllllIIIIlIlIIlIIlIIIllI.length != 3) {
                throw new WrongUsageException("commands.worldborder.set.usage", new Object[0]);
            }
            final double lllllllllllllIIIIlIlIIlIIlIllIll = lllllllllllllIIIIlIlIIlIIlIlllII.getTargetSize();
            final double lllllllllllllIIIIlIlIIlIIlIllIlI = CommandBase.parseDouble(lllllllllllllIIIIlIlIIlIIlIIIllI[1], 1.0, 6.0E7);
            final long lllllllllllllIIIIlIlIIlIIlIllIIl = (lllllllllllllIIIIlIlIIlIIlIIIllI.length > 2) ? (CommandBase.parseLong(lllllllllllllIIIIlIlIIlIIlIIIllI[2], 0L, 9223372036854775L) * 1000L) : 0L;
            if (lllllllllllllIIIIlIlIIlIIlIllIIl > 0L) {
                lllllllllllllIIIIlIlIIlIIlIlllII.setTransition(lllllllllllllIIIIlIlIIlIIlIllIll, lllllllllllllIIIIlIlIIlIIlIllIlI, lllllllllllllIIIIlIlIIlIIlIllIIl);
                if (lllllllllllllIIIIlIlIIlIIlIllIll > lllllllllllllIIIIlIlIIlIIlIllIlI) {
                    CommandBase.notifyCommandListener(lllllllllllllIIIIlIlIIlIIlIllllI, this, "commands.worldborder.setSlowly.shrink.success", String.format("%.1f", lllllllllllllIIIIlIlIIlIIlIllIlI), String.format("%.1f", lllllllllllllIIIIlIlIIlIIlIllIll), Long.toString(lllllllllllllIIIIlIlIIlIIlIllIIl / 1000L));
                }
                else {
                    CommandBase.notifyCommandListener(lllllllllllllIIIIlIlIIlIIlIllllI, this, "commands.worldborder.setSlowly.grow.success", String.format("%.1f", lllllllllllllIIIIlIlIIlIIlIllIlI), String.format("%.1f", lllllllllllllIIIIlIlIIlIIlIllIll), Long.toString(lllllllllllllIIIIlIlIIlIIlIllIIl / 1000L));
                }
            }
            else {
                lllllllllllllIIIIlIlIIlIIlIlllII.setTransition(lllllllllllllIIIIlIlIIlIIlIllIlI);
                CommandBase.notifyCommandListener(lllllllllllllIIIIlIlIIlIIlIllllI, this, "commands.worldborder.set.success", String.format("%.1f", lllllllllllllIIIIlIlIIlIIlIllIlI), String.format("%.1f", lllllllllllllIIIIlIlIIlIIlIllIll));
            }
        }
        else if ("add".equals(lllllllllllllIIIIlIlIIlIIlIIIllI[0])) {
            if (lllllllllllllIIIIlIlIIlIIlIIIllI.length != 2 && lllllllllllllIIIIlIlIIlIIlIIIllI.length != 3) {
                throw new WrongUsageException("commands.worldborder.add.usage", new Object[0]);
            }
            final double lllllllllllllIIIIlIlIIlIIlIllIII = lllllllllllllIIIIlIlIIlIIlIlllII.getDiameter();
            final double lllllllllllllIIIIlIlIIlIIlIlIlll = lllllllllllllIIIIlIlIIlIIlIllIII + CommandBase.parseDouble(lllllllllllllIIIIlIlIIlIIlIIIllI[1], -lllllllllllllIIIIlIlIIlIIlIllIII, 6.0E7 - lllllllllllllIIIIlIlIIlIIlIllIII);
            final long lllllllllllllIIIIlIlIIlIIlIlIllI = lllllllllllllIIIIlIlIIlIIlIlllII.getTimeUntilTarget() + ((lllllllllllllIIIIlIlIIlIIlIIIllI.length > 2) ? (CommandBase.parseLong(lllllllllllllIIIIlIlIIlIIlIIIllI[2], 0L, 9223372036854775L) * 1000L) : 0L);
            if (lllllllllllllIIIIlIlIIlIIlIlIllI > 0L) {
                lllllllllllllIIIIlIlIIlIIlIlllII.setTransition(lllllllllllllIIIIlIlIIlIIlIllIII, lllllllllllllIIIIlIlIIlIIlIlIlll, lllllllllllllIIIIlIlIIlIIlIlIllI);
                if (lllllllllllllIIIIlIlIIlIIlIllIII > lllllllllllllIIIIlIlIIlIIlIlIlll) {
                    CommandBase.notifyCommandListener(lllllllllllllIIIIlIlIIlIIlIllllI, this, "commands.worldborder.setSlowly.shrink.success", String.format("%.1f", lllllllllllllIIIIlIlIIlIIlIlIlll), String.format("%.1f", lllllllllllllIIIIlIlIIlIIlIllIII), Long.toString(lllllllllllllIIIIlIlIIlIIlIlIllI / 1000L));
                }
                else {
                    CommandBase.notifyCommandListener(lllllllllllllIIIIlIlIIlIIlIllllI, this, "commands.worldborder.setSlowly.grow.success", String.format("%.1f", lllllllllllllIIIIlIlIIlIIlIlIlll), String.format("%.1f", lllllllllllllIIIIlIlIIlIIlIllIII), Long.toString(lllllllllllllIIIIlIlIIlIIlIlIllI / 1000L));
                }
            }
            else {
                lllllllllllllIIIIlIlIIlIIlIlllII.setTransition(lllllllllllllIIIIlIlIIlIIlIlIlll);
                CommandBase.notifyCommandListener(lllllllllllllIIIIlIlIIlIIlIllllI, this, "commands.worldborder.set.success", String.format("%.1f", lllllllllllllIIIIlIlIIlIIlIlIlll), String.format("%.1f", lllllllllllllIIIIlIlIIlIIlIllIII));
            }
        }
        else if ("center".equals(lllllllllllllIIIIlIlIIlIIlIIIllI[0])) {
            if (lllllllllllllIIIIlIlIIlIIlIIIllI.length != 3) {
                throw new WrongUsageException("commands.worldborder.center.usage", new Object[0]);
            }
            final BlockPos lllllllllllllIIIIlIlIIlIIlIlIlIl = lllllllllllllIIIIlIlIIlIIlIllllI.getPosition();
            final double lllllllllllllIIIIlIlIIlIIlIlIlII = CommandBase.parseDouble(lllllllllllllIIIIlIlIIlIIlIlIlIl.getX() + 0.5, lllllllllllllIIIIlIlIIlIIlIIIllI[1], true);
            final double lllllllllllllIIIIlIlIIlIIlIlIIll = CommandBase.parseDouble(lllllllllllllIIIIlIlIIlIIlIlIlIl.getZ() + 0.5, lllllllllllllIIIIlIlIIlIIlIIIllI[2], true);
            lllllllllllllIIIIlIlIIlIIlIlllII.setCenter(lllllllllllllIIIIlIlIIlIIlIlIlII, lllllllllllllIIIIlIlIIlIIlIlIIll);
            CommandBase.notifyCommandListener(lllllllllllllIIIIlIlIIlIIlIllllI, this, "commands.worldborder.center.success", lllllllllllllIIIIlIlIIlIIlIlIlII, lllllllllllllIIIIlIlIIlIIlIlIIll);
        }
        else if ("damage".equals(lllllllllllllIIIIlIlIIlIIlIIIllI[0])) {
            if (lllllllllllllIIIIlIlIIlIIlIIIllI.length < 2) {
                throw new WrongUsageException("commands.worldborder.damage.usage", new Object[0]);
            }
            if ("buffer".equals(lllllllllllllIIIIlIlIIlIIlIIIllI[1])) {
                if (lllllllllllllIIIIlIlIIlIIlIIIllI.length != 3) {
                    throw new WrongUsageException("commands.worldborder.damage.buffer.usage", new Object[0]);
                }
                final double lllllllllllllIIIIlIlIIlIIlIlIIlI = CommandBase.parseDouble(lllllllllllllIIIIlIlIIlIIlIIIllI[2], 0.0);
                final double lllllllllllllIIIIlIlIIlIIlIlIIIl = lllllllllllllIIIIlIlIIlIIlIlllII.getDamageBuffer();
                lllllllllllllIIIIlIlIIlIIlIlllII.setDamageBuffer(lllllllllllllIIIIlIlIIlIIlIlIIlI);
                CommandBase.notifyCommandListener(lllllllllllllIIIIlIlIIlIIlIllllI, this, "commands.worldborder.damage.buffer.success", String.format("%.1f", lllllllllllllIIIIlIlIIlIIlIlIIlI), String.format("%.1f", lllllllllllllIIIIlIlIIlIIlIlIIIl));
            }
            else if ("amount".equals(lllllllllllllIIIIlIlIIlIIlIIIllI[1])) {
                if (lllllllllllllIIIIlIlIIlIIlIIIllI.length != 3) {
                    throw new WrongUsageException("commands.worldborder.damage.amount.usage", new Object[0]);
                }
                final double lllllllllllllIIIIlIlIIlIIlIlIIII = CommandBase.parseDouble(lllllllllllllIIIIlIlIIlIIlIIIllI[2], 0.0);
                final double lllllllllllllIIIIlIlIIlIIlIIllll = lllllllllllllIIIIlIlIIlIIlIlllII.getDamageAmount();
                lllllllllllllIIIIlIlIIlIIlIlllII.setDamageAmount(lllllllllllllIIIIlIlIIlIIlIlIIII);
                CommandBase.notifyCommandListener(lllllllllllllIIIIlIlIIlIIlIllllI, this, "commands.worldborder.damage.amount.success", String.format("%.2f", lllllllllllllIIIIlIlIIlIIlIlIIII), String.format("%.2f", lllllllllllllIIIIlIlIIlIIlIIllll));
            }
        }
        else if ("warning".equals(lllllllllllllIIIIlIlIIlIIlIIIllI[0])) {
            if (lllllllllllllIIIIlIlIIlIIlIIIllI.length < 2) {
                throw new WrongUsageException("commands.worldborder.warning.usage", new Object[0]);
            }
            if ("time".equals(lllllllllllllIIIIlIlIIlIIlIIIllI[1])) {
                if (lllllllllllllIIIIlIlIIlIIlIIIllI.length != 3) {
                    throw new WrongUsageException("commands.worldborder.warning.time.usage", new Object[0]);
                }
                final int lllllllllllllIIIIlIlIIlIIlIIlllI = CommandBase.parseInt(lllllllllllllIIIIlIlIIlIIlIIIllI[2], 0);
                final int lllllllllllllIIIIlIlIIlIIlIIllIl = lllllllllllllIIIIlIlIIlIIlIlllII.getWarningTime();
                lllllllllllllIIIIlIlIIlIIlIlllII.setWarningTime(lllllllllllllIIIIlIlIIlIIlIIlllI);
                CommandBase.notifyCommandListener(lllllllllllllIIIIlIlIIlIIlIllllI, this, "commands.worldborder.warning.time.success", lllllllllllllIIIIlIlIIlIIlIIlllI, lllllllllllllIIIIlIlIIlIIlIIllIl);
            }
            else if ("distance".equals(lllllllllllllIIIIlIlIIlIIlIIIllI[1])) {
                if (lllllllllllllIIIIlIlIIlIIlIIIllI.length != 3) {
                    throw new WrongUsageException("commands.worldborder.warning.distance.usage", new Object[0]);
                }
                final int lllllllllllllIIIIlIlIIlIIlIIllII = CommandBase.parseInt(lllllllllllllIIIIlIlIIlIIlIIIllI[2], 0);
                final int lllllllllllllIIIIlIlIIlIIlIIlIll = lllllllllllllIIIIlIlIIlIIlIlllII.getWarningDistance();
                lllllllllllllIIIIlIlIIlIIlIlllII.setWarningDistance(lllllllllllllIIIIlIlIIlIIlIIllII);
                CommandBase.notifyCommandListener(lllllllllllllIIIIlIlIIlIIlIllllI, this, "commands.worldborder.warning.distance.success", lllllllllllllIIIIlIlIIlIIlIIllII, lllllllllllllIIIIlIlIIlIIlIIlIll);
            }
        }
        else {
            if (!"get".equals(lllllllllllllIIIIlIlIIlIIlIIIllI[0])) {
                throw new WrongUsageException("commands.worldborder.usage", new Object[0]);
            }
            final double lllllllllllllIIIIlIlIIlIIlIIlIlI = lllllllllllllIIIIlIlIIlIIlIlllII.getDiameter();
            lllllllllllllIIIIlIlIIlIIlIllllI.setCommandStat(CommandResultStats.Type.QUERY_RESULT, MathHelper.floor(lllllllllllllIIIIlIlIIlIIlIIlIlI + 0.5));
            lllllllllllllIIIIlIlIIlIIlIllllI.addChatMessage(new TextComponentTranslation("commands.worldborder.get.success", new Object[] { String.format("%.0f", lllllllllllllIIIIlIlIIlIIlIIlIlI) }));
        }
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIIIIlIlIIlIIllIlIll) {
        return "commands.worldborder.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    protected WorldBorder getWorldBorder(final MinecraftServer lllllllllllllIIIIlIlIIlIIIllllIl) {
        return lllllllllllllIIIIlIlIIlIIIllllIl.worldServers[0].getWorldBorder();
    }
}
