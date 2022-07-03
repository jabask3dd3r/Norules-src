package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;
import net.minecraft.util.text.*;

public class CommandEffect extends CommandBase
{
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIlIlIllIIIllIlIIlII, final ICommandSender lllllllllllllIlIlIllIIIllIlIIlll, final String[] lllllllllllllIlIlIllIIIllIlIIllI, @Nullable final BlockPos lllllllllllllIlIlIllIIIllIlIIlIl) {
        if (lllllllllllllIlIlIllIIIllIlIIllI.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIlIlIllIIIllIlIIllI, lllllllllllllIlIlIllIIIllIlIIlII.getAllUsernames());
        }
        if (lllllllllllllIlIlIllIIIllIlIIllI.length == 2) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIlIlIllIIIllIlIIllI, Potion.REGISTRY.getKeys());
        }
        return (lllllllllllllIlIlIllIIIllIlIIllI.length == 5) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIlIlIllIIIllIlIIllI, "true", "false") : Collections.emptyList();
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIlIlIllIIIlllIIIIlI, final ICommandSender lllllllllllllIlIlIllIIIlllIIIIIl, final String[] lllllllllllllIlIlIllIIIlllIIIIII) throws CommandException {
        if (lllllllllllllIlIlIllIIIlllIIIIII.length < 2) {
            throw new WrongUsageException("commands.effect.usage", new Object[0]);
        }
        final EntityLivingBase lllllllllllllIlIlIllIIIllIllllll = CommandBase.getEntity(lllllllllllllIlIlIllIIIlllIIIIlI, lllllllllllllIlIlIllIIIlllIIIIIl, lllllllllllllIlIlIllIIIlllIIIIII[0], (Class<? extends EntityLivingBase>)EntityLivingBase.class);
        if ("clear".equals(lllllllllllllIlIlIllIIIlllIIIIII[1])) {
            if (lllllllllllllIlIlIllIIIllIllllll.getActivePotionEffects().isEmpty()) {
                throw new CommandException("commands.effect.failure.notActive.all", new Object[] { lllllllllllllIlIlIllIIIllIllllll.getName() });
            }
            lllllllllllllIlIlIllIIIllIllllll.clearActivePotions();
            CommandBase.notifyCommandListener(lllllllllllllIlIlIllIIIlllIIIIIl, this, "commands.effect.success.removed.all", lllllllllllllIlIlIllIIIllIllllll.getName());
        }
        else {
            Potion lllllllllllllIlIlIllIIIllIllllIl = null;
            try {
                final Potion lllllllllllllIlIlIllIIIllIlllllI = Potion.getPotionById(CommandBase.parseInt(lllllllllllllIlIlIllIIIlllIIIIII[1], 1));
            }
            catch (NumberInvalidException lllllllllllllIlIlIllIIIllIllllII) {
                lllllllllllllIlIlIllIIIllIllllIl = Potion.getPotionFromResourceLocation(lllllllllllllIlIlIllIIIlllIIIIII[1]);
            }
            if (lllllllllllllIlIlIllIIIllIllllIl == null) {
                throw new NumberInvalidException("commands.effect.notFound", new Object[] { lllllllllllllIlIlIllIIIlllIIIIII[1] });
            }
            int lllllllllllllIlIlIllIIIllIlllIll = 600;
            int lllllllllllllIlIlIllIIIllIlllIlI = 30;
            int lllllllllllllIlIlIllIIIllIlllIIl = 0;
            if (lllllllllllllIlIlIllIIIlllIIIIII.length >= 3) {
                lllllllllllllIlIlIllIIIllIlllIlI = CommandBase.parseInt(lllllllllllllIlIlIllIIIlllIIIIII[2], 0, 1000000);
                if (lllllllllllllIlIlIllIIIllIllllIl.isInstant()) {
                    lllllllllllllIlIlIllIIIllIlllIll = lllllllllllllIlIlIllIIIllIlllIlI;
                }
                else {
                    lllllllllllllIlIlIllIIIllIlllIll = lllllllllllllIlIlIllIIIllIlllIlI * 20;
                }
            }
            else if (lllllllllllllIlIlIllIIIllIllllIl.isInstant()) {
                lllllllllllllIlIlIllIIIllIlllIll = 1;
            }
            if (lllllllllllllIlIlIllIIIlllIIIIII.length >= 4) {
                lllllllllllllIlIlIllIIIllIlllIIl = CommandBase.parseInt(lllllllllllllIlIlIllIIIlllIIIIII[3], 0, 255);
            }
            boolean lllllllllllllIlIlIllIIIllIlllIII = true;
            if (lllllllllllllIlIlIllIIIlllIIIIII.length >= 5 && "true".equalsIgnoreCase(lllllllllllllIlIlIllIIIlllIIIIII[4])) {
                lllllllllllllIlIlIllIIIllIlllIII = false;
            }
            if (lllllllllllllIlIlIllIIIllIlllIlI > 0) {
                final PotionEffect lllllllllllllIlIlIllIIIllIllIlll = new PotionEffect(lllllllllllllIlIlIllIIIllIllllIl, lllllllllllllIlIlIllIIIllIlllIll, lllllllllllllIlIlIllIIIllIlllIIl, false, lllllllllllllIlIlIllIIIllIlllIII);
                lllllllllllllIlIlIllIIIllIllllll.addPotionEffect(lllllllllllllIlIlIllIIIllIllIlll);
                CommandBase.notifyCommandListener(lllllllllllllIlIlIllIIIlllIIIIIl, this, "commands.effect.success", new TextComponentTranslation(lllllllllllllIlIlIllIIIllIllIlll.getEffectName(), new Object[0]), Potion.getIdFromPotion(lllllllllllllIlIlIllIIIllIllllIl), lllllllllllllIlIlIllIIIllIlllIIl, lllllllllllllIlIlIllIIIllIllllll.getName(), lllllllllllllIlIlIllIIIllIlllIlI);
            }
            else {
                if (!lllllllllllllIlIlIllIIIllIllllll.isPotionActive(lllllllllllllIlIlIllIIIllIllllIl)) {
                    throw new CommandException("commands.effect.failure.notActive", new Object[] { new TextComponentTranslation(lllllllllllllIlIlIllIIIllIllllIl.getName(), new Object[0]), lllllllllllllIlIlIllIIIllIllllll.getName() });
                }
                lllllllllllllIlIlIllIIIllIllllll.removePotionEffect(lllllllllllllIlIlIllIIIllIllllIl);
                CommandBase.notifyCommandListener(lllllllllllllIlIlIllIIIlllIIIIIl, this, "commands.effect.success.removed", new TextComponentTranslation(lllllllllllllIlIlIllIIIllIllllIl.getName(), new Object[0]), lllllllllllllIlIlIllIIIllIllllll.getName());
            }
        }
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIlIlIllIIIlllIIllll) {
        return "commands.effect.usage";
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllllIlIlIllIIIllIlIIIII, final int lllllllllllllIlIlIllIIIllIIlllll) {
        return lllllllllllllIlIlIllIIIllIIlllll == 0;
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandName() {
        return "effect";
    }
}
