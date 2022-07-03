package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.entity.*;
import net.minecraft.enchantment.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;

public class CommandEnchant extends CommandBase
{
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllllIIlllIlIIIllIIIIll, final int llllllllllllllIIlllIlIIIllIIIIIl) {
        return llllllllllllllIIlllIlIIIllIIIIIl == 0;
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllIIlllIlIIIllIllIIl, final ICommandSender llllllllllllllIIlllIlIIIlllIIllI, final String[] llllllllllllllIIlllIlIIIllIlIlll) throws CommandException {
        if (llllllllllllllIIlllIlIIIllIlIlll.length < 2) {
            throw new WrongUsageException("commands.enchant.usage", new Object[0]);
        }
        final EntityLivingBase llllllllllllllIIlllIlIIIlllIIlII = CommandBase.getEntity(llllllllllllllIIlllIlIIIllIllIIl, llllllllllllllIIlllIlIIIlllIIllI, llllllllllllllIIlllIlIIIllIlIlll[0], (Class<? extends EntityLivingBase>)EntityLivingBase.class);
        llllllllllllllIIlllIlIIIlllIIllI.setCommandStat(CommandResultStats.Type.AFFECTED_ITEMS, 0);
        Enchantment llllllllllllllIIlllIlIIIlllIIIlI = null;
        try {
            final Enchantment llllllllllllllIIlllIlIIIlllIIIll = Enchantment.getEnchantmentByID(CommandBase.parseInt(llllllllllllllIIlllIlIIIllIlIlll[1], 0));
        }
        catch (NumberInvalidException llllllllllllllIIlllIlIIIlllIIIIl) {
            llllllllllllllIIlllIlIIIlllIIIlI = Enchantment.getEnchantmentByLocation(llllllllllllllIIlllIlIIIllIlIlll[1]);
        }
        if (llllllllllllllIIlllIlIIIlllIIIlI == null) {
            throw new NumberInvalidException("commands.enchant.notFound", new Object[] { llllllllllllllIIlllIlIIIllIlIlll[1] });
        }
        int llllllllllllllIIlllIlIIIlllIIIII = 1;
        final ItemStack llllllllllllllIIlllIlIIIllIlllll = llllllllllllllIIlllIlIIIlllIIlII.getHeldItemMainhand();
        if (llllllllllllllIIlllIlIIIllIlllll.func_190926_b()) {
            throw new CommandException("commands.enchant.noItem", new Object[0]);
        }
        if (!llllllllllllllIIlllIlIIIlllIIIlI.canApply(llllllllllllllIIlllIlIIIllIlllll)) {
            throw new CommandException("commands.enchant.cantEnchant", new Object[0]);
        }
        if (llllllllllllllIIlllIlIIIllIlIlll.length >= 3) {
            llllllllllllllIIlllIlIIIlllIIIII = CommandBase.parseInt(llllllllllllllIIlllIlIIIllIlIlll[2], llllllllllllllIIlllIlIIIlllIIIlI.getMinLevel(), llllllllllllllIIlllIlIIIlllIIIlI.getMaxLevel());
        }
        if (llllllllllllllIIlllIlIIIllIlllll.hasTagCompound()) {
            final NBTTagList llllllllllllllIIlllIlIIIllIllllI = llllllllllllllIIlllIlIIIllIlllll.getEnchantmentTagList();
            for (int llllllllllllllIIlllIlIIIllIlllIl = 0; llllllllllllllIIlllIlIIIllIlllIl < llllllllllllllIIlllIlIIIllIllllI.tagCount(); ++llllllllllllllIIlllIlIIIllIlllIl) {
                final int llllllllllllllIIlllIlIIIllIlllII = llllllllllllllIIlllIlIIIllIllllI.getCompoundTagAt(llllllllllllllIIlllIlIIIllIlllIl).getShort("id");
                if (Enchantment.getEnchantmentByID(llllllllllllllIIlllIlIIIllIlllII) != null) {
                    final Enchantment llllllllllllllIIlllIlIIIllIllIll = Enchantment.getEnchantmentByID(llllllllllllllIIlllIlIIIllIlllII);
                    if (!llllllllllllllIIlllIlIIIlllIIIlI.func_191560_c(llllllllllllllIIlllIlIIIllIllIll)) {
                        throw new CommandException("commands.enchant.cantCombine", new Object[] { llllllllllllllIIlllIlIIIlllIIIlI.getTranslatedName(llllllllllllllIIlllIlIIIlllIIIII), llllllllllllllIIlllIlIIIllIllIll.getTranslatedName(llllllllllllllIIlllIlIIIllIllllI.getCompoundTagAt(llllllllllllllIIlllIlIIIllIlllIl).getShort("lvl")) });
                    }
                }
            }
        }
        llllllllllllllIIlllIlIIIllIlllll.addEnchantment(llllllllllllllIIlllIlIIIlllIIIlI, llllllllllllllIIlllIlIIIlllIIIII);
        CommandBase.notifyCommandListener(llllllllllllllIIlllIlIIIlllIIllI, this, "commands.enchant.success", new Object[0]);
        llllllllllllllIIlllIlIIIlllIIllI.setCommandStat(CommandResultStats.Type.AFFECTED_ITEMS, 1);
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllllIIlllIlIIIllIIIlll, final ICommandSender llllllllllllllIIlllIlIIIllIIlIlI, final String[] llllllllllllllIIlllIlIIIllIIIllI, @Nullable final BlockPos llllllllllllllIIlllIlIIIllIIlIII) {
        if (llllllllllllllIIlllIlIIIllIIIllI.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIlllIlIIIllIIIllI, llllllllllllllIIlllIlIIIllIIIlll.getAllUsernames());
        }
        return (llllllllllllllIIlllIlIIIllIIIllI.length == 2) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIlllIlIIIllIIIllI, Enchantment.REGISTRY.getKeys()) : Collections.emptyList();
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIIlllIlIIIllllIlIl) {
        return "commands.enchant.usage";
    }
    
    @Override
    public String getCommandName() {
        return "enchant";
    }
}
