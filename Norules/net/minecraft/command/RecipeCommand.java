package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.item.crafting.*;
import com.google.common.collect.*;

public class RecipeCommand extends CommandBase
{
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIlllIlIllIlIlllllll, final ICommandSender lllllllllllllIlllIlIllIllIIIIIlI, final String[] lllllllllllllIlllIlIllIllIIIIIIl, @Nullable final BlockPos lllllllllllllIlllIlIllIllIIIIIII) {
        if (lllllllllllllIlllIlIllIllIIIIIIl.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIlllIlIllIllIIIIIIl, "give", "take");
        }
        if (lllllllllllllIlllIlIllIllIIIIIIl.length == 2) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIlllIlIllIllIIIIIIl, lllllllllllllIlllIlIllIlIlllllll.getAllUsernames());
        }
        return (lllllllllllllIlllIlIllIllIIIIIIl.length == 3) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIlllIlIllIllIIIIIIl, CraftingManager.field_193380_a.getKeys()) : Collections.emptyList();
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIlllIlIllIllIIllIll, final ICommandSender lllllllllllllIlllIlIllIllIIllIlI, final String[] lllllllllllllIlllIlIllIllIIllIIl) throws CommandException {
        if (lllllllllllllIlllIlIllIllIIllIIl.length < 2) {
            throw new WrongUsageException("commands.recipe.usage", new Object[0]);
        }
        final boolean lllllllllllllIlllIlIllIllIIllIII = "give".equalsIgnoreCase(lllllllllllllIlllIlIllIllIIllIIl[0]);
        final boolean lllllllllllllIlllIlIllIllIIlIlll = "take".equalsIgnoreCase(lllllllllllllIlllIlIllIllIIllIIl[0]);
        if (!lllllllllllllIlllIlIllIllIIllIII && !lllllllllllllIlllIlIllIllIIlIlll) {
            throw new WrongUsageException("commands.recipe.usage", new Object[0]);
        }
        for (final EntityPlayerMP lllllllllllllIlllIlIllIllIIlIllI : CommandBase.func_193513_a(lllllllllllllIlllIlIllIllIIllIll, lllllllllllllIlllIlIllIllIIllIlI, lllllllllllllIlllIlIllIllIIllIIl[1])) {
            if ("*".equals(lllllllllllllIlllIlIllIllIIllIIl[2])) {
                if (lllllllllllllIlllIlIllIllIIllIII) {
                    lllllllllllllIlllIlIllIllIIlIllI.func_192021_a(this.func_192556_d());
                    CommandBase.notifyCommandListener(lllllllllllllIlllIlIllIllIIllIlI, this, "commands.recipe.give.success.all", lllllllllllllIlllIlIllIllIIlIllI.getName());
                }
                else {
                    lllllllllllllIlllIlIllIllIIlIllI.func_192022_b(this.func_192556_d());
                    CommandBase.notifyCommandListener(lllllllllllllIlllIlIllIllIIllIlI, this, "commands.recipe.take.success.all", lllllllllllllIlllIlIllIllIIlIllI.getName());
                }
            }
            else {
                final IRecipe lllllllllllllIlllIlIllIllIIlIlIl = CraftingManager.func_193373_a(new ResourceLocation(lllllllllllllIlllIlIllIllIIllIIl[2]));
                if (lllllllllllllIlllIlIllIllIIlIlIl == null) {
                    throw new CommandException("commands.recipe.unknownrecipe", new Object[] { lllllllllllllIlllIlIllIllIIllIIl[2] });
                }
                if (lllllllllllllIlllIlIllIllIIlIlIl.func_192399_d()) {
                    throw new CommandException("commands.recipe.unsupported", new Object[] { lllllllllllllIlllIlIllIllIIllIIl[2] });
                }
                final List<IRecipe> lllllllllllllIlllIlIllIllIIlIlII = (List<IRecipe>)Lists.newArrayList((Object[])new IRecipe[] { lllllllllllllIlllIlIllIllIIlIlIl });
                if (lllllllllllllIlllIlIllIllIIllIII == lllllllllllllIlllIlIllIllIIlIllI.func_192037_E().func_193830_f(lllllllllllllIlllIlIllIllIIlIlIl)) {
                    final String lllllllllllllIlllIlIllIllIIlIIll = lllllllllllllIlllIlIllIllIIllIII ? "commands.recipe.alreadyHave" : "commands.recipe.dontHave";
                    throw new CommandException(lllllllllllllIlllIlIllIllIIlIIll, new Object[] { lllllllllllllIlllIlIllIllIIlIllI.getName(), lllllllllllllIlllIlIllIllIIlIlIl.getRecipeOutput().getDisplayName() });
                }
                if (lllllllllllllIlllIlIllIllIIllIII) {
                    lllllllllllllIlllIlIllIllIIlIllI.func_192021_a(lllllllllllllIlllIlIllIllIIlIlII);
                    CommandBase.notifyCommandListener(lllllllllllllIlllIlIllIllIIllIlI, this, "commands.recipe.give.success.one", lllllllllllllIlllIlIllIllIIlIllI.getName(), lllllllllllllIlllIlIllIllIIlIlIl.getRecipeOutput().getDisplayName());
                }
                else {
                    lllllllllllllIlllIlIllIllIIlIllI.func_192022_b(lllllllllllllIlllIlIllIllIIlIlII);
                    CommandBase.notifyCommandListener(lllllllllllllIlllIlIllIllIIllIlI, this, "commands.recipe.take.success.one", lllllllllllllIlllIlIllIllIIlIlIl.getRecipeOutput().getDisplayName(), lllllllllllllIlllIlIllIllIIlIllI.getName());
                }
            }
        }
    }
    
    private List<IRecipe> func_192556_d() {
        return (List<IRecipe>)Lists.newArrayList((Iterable)CraftingManager.field_193380_a);
    }
    
    @Override
    public String getCommandName() {
        return "recipe";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIlllIlIllIllIlIlIII) {
        return "commands.recipe.usage";
    }
}
