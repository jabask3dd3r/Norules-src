package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.world.storage.*;

public class CommandWeather extends CommandBase
{
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIlIIIlIlIIlIIlIllll, final ICommandSender lllllllllllllIlIIIlIlIIlIIlIlllI, final String[] lllllllllllllIlIIIlIlIIlIIlIlIll, @Nullable final BlockPos lllllllllllllIlIIIlIlIIlIIlIllII) {
        return (lllllllllllllIlIIIlIlIIlIIlIlIll.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIlIIIlIlIIlIIlIlIll, "clear", "rain", "thunder") : Collections.emptyList();
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIlIIIlIlIIlIIlllllI, final ICommandSender lllllllllllllIlIIIlIlIIlIIllIllI, final String[] lllllllllllllIlIIIlIlIIlIIllllII) throws CommandException {
        if (lllllllllllllIlIIIlIlIIlIIllllII.length >= 1 && lllllllllllllIlIIIlIlIIlIIllllII.length <= 2) {
            int lllllllllllllIlIIIlIlIIlIIlllIll = (300 + new Random().nextInt(600)) * 20;
            if (lllllllllllllIlIIIlIlIIlIIllllII.length >= 2) {
                lllllllllllllIlIIIlIlIIlIIlllIll = CommandBase.parseInt(lllllllllllllIlIIIlIlIIlIIllllII[1], 1, 1000000) * 20;
            }
            final World lllllllllllllIlIIIlIlIIlIIlllIlI = lllllllllllllIlIIIlIlIIlIIlllllI.worldServers[0];
            final WorldInfo lllllllllllllIlIIIlIlIIlIIlllIIl = lllllllllllllIlIIIlIlIIlIIlllIlI.getWorldInfo();
            if ("clear".equalsIgnoreCase(lllllllllllllIlIIIlIlIIlIIllllII[0])) {
                lllllllllllllIlIIIlIlIIlIIlllIIl.setCleanWeatherTime(lllllllllllllIlIIIlIlIIlIIlllIll);
                lllllllllllllIlIIIlIlIIlIIlllIIl.setRainTime(0);
                lllllllllllllIlIIIlIlIIlIIlllIIl.setThunderTime(0);
                lllllllllllllIlIIIlIlIIlIIlllIIl.setRaining(false);
                lllllllllllllIlIIIlIlIIlIIlllIIl.setThundering(false);
                CommandBase.notifyCommandListener(lllllllllllllIlIIIlIlIIlIIllIllI, this, "commands.weather.clear", new Object[0]);
            }
            else if ("rain".equalsIgnoreCase(lllllllllllllIlIIIlIlIIlIIllllII[0])) {
                lllllllllllllIlIIIlIlIIlIIlllIIl.setCleanWeatherTime(0);
                lllllllllllllIlIIIlIlIIlIIlllIIl.setRainTime(lllllllllllllIlIIIlIlIIlIIlllIll);
                lllllllllllllIlIIIlIlIIlIIlllIIl.setThunderTime(lllllllllllllIlIIIlIlIIlIIlllIll);
                lllllllllllllIlIIIlIlIIlIIlllIIl.setRaining(true);
                lllllllllllllIlIIIlIlIIlIIlllIIl.setThundering(false);
                CommandBase.notifyCommandListener(lllllllllllllIlIIIlIlIIlIIllIllI, this, "commands.weather.rain", new Object[0]);
            }
            else {
                if (!"thunder".equalsIgnoreCase(lllllllllllllIlIIIlIlIIlIIllllII[0])) {
                    throw new WrongUsageException("commands.weather.usage", new Object[0]);
                }
                lllllllllllllIlIIIlIlIIlIIlllIIl.setCleanWeatherTime(0);
                lllllllllllllIlIIIlIlIIlIIlllIIl.setRainTime(lllllllllllllIlIIIlIlIIlIIlllIll);
                lllllllllllllIlIIIlIlIIlIIlllIIl.setThunderTime(lllllllllllllIlIIIlIlIIlIIlllIll);
                lllllllllllllIlIIIlIlIIlIIlllIIl.setRaining(true);
                lllllllllllllIlIIIlIlIIlIIlllIIl.setThundering(true);
                CommandBase.notifyCommandListener(lllllllllllllIlIIIlIlIIlIIllIllI, this, "commands.weather.thunder", new Object[0]);
            }
            return;
        }
        throw new WrongUsageException("commands.weather.usage", new Object[0]);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIlIIIlIlIIlIlIIIlll) {
        return "commands.weather.usage";
    }
    
    @Override
    public String getCommandName() {
        return "weather";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
}
