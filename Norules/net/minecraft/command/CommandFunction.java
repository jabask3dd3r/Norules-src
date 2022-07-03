package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.util.*;

public class CommandFunction extends CommandBase
{
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllllIlIllllIIlllIIIIl, final ICommandSender lllllllllllllllIlIllllIIlllIIlII, final String[] lllllllllllllllIlIllllIIlllIIIll, @Nullable final BlockPos lllllllllllllllIlIllllIIlllIIIlI) {
        if (lllllllllllllllIlIllllIIlllIIIll.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIlIllllIIlllIIIll, lllllllllllllllIlIllllIIlllIIIIl.func_193030_aL().func_193066_d().keySet());
        }
        if (lllllllllllllllIlIllllIIlllIIIll.length == 2) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIlIllllIIlllIIIll, "if", "unless");
        }
        return (lllllllllllllllIlIllllIIlllIIIll.length == 3) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIlIllllIIlllIIIll, lllllllllllllllIlIllllIIlllIIIIl.getAllUsernames()) : Collections.emptyList();
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllllIlIllllIIllllIIIl, final ICommandSender lllllllllllllllIlIllllIIllllIIII, final String[] lllllllllllllllIlIllllIIlllIllll) throws CommandException {
        if (lllllllllllllllIlIllllIIlllIllll.length != 1 && lllllllllllllllIlIllllIIlllIllll.length != 3) {
            throw new WrongUsageException("commands.function.usage", new Object[0]);
        }
        final ResourceLocation lllllllllllllllIlIllllIIlllllIIl = new ResourceLocation(lllllllllllllllIlIllllIIlllIllll[0]);
        final FunctionObject lllllllllllllllIlIllllIIlllllIII = lllllllllllllllIlIllllIIllllIIIl.func_193030_aL().func_193058_a(lllllllllllllllIlIllllIIlllllIIl);
        if (lllllllllllllllIlIllllIIlllllIII == null) {
            throw new CommandException("commands.function.unknown", new Object[] { lllllllllllllllIlIllllIIlllllIIl });
        }
        if (lllllllllllllllIlIllllIIlllIllll.length == 3) {
            final String lllllllllllllllIlIllllIIllllIlll = lllllllllllllllIlIllllIIlllIllll[1];
            boolean lllllllllllllllIlIllllIIllllIlIl = false;
            if ("if".equals(lllllllllllllllIlIllllIIllllIlll)) {
                final boolean lllllllllllllllIlIllllIIllllIllI = true;
            }
            else {
                if (!"unless".equals(lllllllllllllllIlIllllIIllllIlll)) {
                    throw new WrongUsageException("commands.function.usage", new Object[0]);
                }
                lllllllllllllllIlIllllIIllllIlIl = false;
            }
            boolean lllllllllllllllIlIllllIIllllIlII = false;
            try {
                lllllllllllllllIlIllllIIllllIlII = !CommandBase.getEntityList(lllllllllllllllIlIllllIIllllIIIl, lllllllllllllllIlIllllIIllllIIII, lllllllllllllllIlIllllIIlllIllll[2]).isEmpty();
            }
            catch (EntityNotFoundException ex) {}
            if (lllllllllllllllIlIllllIIllllIlIl != lllllllllllllllIlIllllIIllllIlII) {
                throw new CommandException("commands.function.skipped", new Object[] { lllllllllllllllIlIllllIIlllllIIl });
            }
        }
        final int lllllllllllllllIlIllllIIllllIIll = lllllllllllllllIlIllllIIllllIIIl.func_193030_aL().func_194019_a(lllllllllllllllIlIllllIIlllllIII, CommandSenderWrapper.func_193998_a(lllllllllllllllIlIllllIIllllIIII).func_194000_i().func_193999_a(2).func_194001_a(false));
        CommandBase.notifyCommandListener(lllllllllllllllIlIllllIIllllIIII, this, "commands.function.success", lllllllllllllllIlIllllIIlllllIIl, lllllllllllllllIlIllllIIllllIIll);
    }
    
    @Override
    public String getCommandName() {
        return "function";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllIlIllllIlIIIIlIII) {
        return "commands.function.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
}
