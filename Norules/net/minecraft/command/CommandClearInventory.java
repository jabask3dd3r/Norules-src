package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.util.text.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;

public class CommandClearInventory extends CommandBase
{
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllllIlIIllIlIllIIIIlII, final int llllllllllllllIlIIllIlIllIIIIIll) {
        return llllllllllllllIlIIllIlIllIIIIIll == 0;
    }
    
    @Override
    public String getCommandName() {
        return "clear";
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllIlIIllIlIllIlIIIll, final ICommandSender llllllllllllllIlIIllIlIllIIlIlll, final String[] llllllllllllllIlIIllIlIllIlIIIIl) throws CommandException {
        final EntityPlayerMP llllllllllllllIlIIllIlIllIlIIIII = (llllllllllllllIlIIllIlIllIlIIIIl.length == 0) ? CommandBase.getCommandSenderAsPlayer(llllllllllllllIlIIllIlIllIIlIlll) : CommandBase.getPlayer(llllllllllllllIlIIllIlIllIlIIIll, llllllllllllllIlIIllIlIllIIlIlll, llllllllllllllIlIIllIlIllIlIIIIl[0]);
        final Item llllllllllllllIlIIllIlIllIIlllll = (llllllllllllllIlIIllIlIllIlIIIIl.length >= 2) ? CommandBase.getItemByText(llllllllllllllIlIIllIlIllIIlIlll, llllllllllllllIlIIllIlIllIlIIIIl[1]) : null;
        final int llllllllllllllIlIIllIlIllIIllllI = (llllllllllllllIlIIllIlIllIlIIIIl.length >= 3) ? CommandBase.parseInt(llllllllllllllIlIIllIlIllIlIIIIl[2], -1) : -1;
        final int llllllllllllllIlIIllIlIllIIlllIl = (llllllllllllllIlIIllIlIllIlIIIIl.length >= 4) ? CommandBase.parseInt(llllllllllllllIlIIllIlIllIlIIIIl[3], -1) : -1;
        NBTTagCompound llllllllllllllIlIIllIlIllIIlllII = null;
        if (llllllllllllllIlIIllIlIllIlIIIIl.length >= 5) {
            try {
                llllllllllllllIlIIllIlIllIIlllII = JsonToNBT.getTagFromJson(CommandBase.buildString(llllllllllllllIlIIllIlIllIlIIIIl, 4));
            }
            catch (NBTException llllllllllllllIlIIllIlIllIIllIll) {
                throw new CommandException("commands.clear.tagError", new Object[] { llllllllllllllIlIIllIlIllIIllIll.getMessage() });
            }
        }
        if (llllllllllllllIlIIllIlIllIlIIIIl.length >= 2 && llllllllllllllIlIIllIlIllIIlllll == null) {
            throw new CommandException("commands.clear.failure", new Object[] { llllllllllllllIlIIllIlIllIlIIIII.getName() });
        }
        final int llllllllllllllIlIIllIlIllIIllIlI = llllllllllllllIlIIllIlIllIlIIIII.inventory.clearMatchingItems(llllllllllllllIlIIllIlIllIIlllll, llllllllllllllIlIIllIlIllIIllllI, llllllllllllllIlIIllIlIllIIlllIl, llllllllllllllIlIIllIlIllIIlllII);
        llllllllllllllIlIIllIlIllIlIIIII.inventoryContainer.detectAndSendChanges();
        if (!llllllllllllllIlIIllIlIllIlIIIII.capabilities.isCreativeMode) {
            llllllllllllllIlIIllIlIllIlIIIII.updateHeldItem();
        }
        llllllllllllllIlIIllIlIllIIlIlll.setCommandStat(CommandResultStats.Type.AFFECTED_ITEMS, llllllllllllllIlIIllIlIllIIllIlI);
        if (llllllllllllllIlIIllIlIllIIllIlI == 0) {
            throw new CommandException("commands.clear.failure", new Object[] { llllllllllllllIlIIllIlIllIlIIIII.getName() });
        }
        if (llllllllllllllIlIIllIlIllIIlllIl == 0) {
            llllllllllllllIlIIllIlIllIIlIlll.addChatMessage(new TextComponentTranslation("commands.clear.testing", new Object[] { llllllllllllllIlIIllIlIllIlIIIII.getName(), llllllllllllllIlIIllIlIllIIllIlI }));
        }
        else {
            CommandBase.notifyCommandListener(llllllllllllllIlIIllIlIllIIlIlll, this, "commands.clear.success", llllllllllllllIlIIllIlIllIlIIIII.getName(), llllllllllllllIlIIllIlIllIIllIlI);
        }
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIlIIllIlIllIllIIII) {
        return "commands.clear.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllllIlIIllIlIllIIIlIII, final ICommandSender llllllllllllllIlIIllIlIllIIIlIll, final String[] llllllllllllllIlIIllIlIllIIIIlll, @Nullable final BlockPos llllllllllllllIlIIllIlIllIIIlIIl) {
        if (llllllllllllllIlIIllIlIllIIIIlll.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIlIIllIlIllIIIIlll, llllllllllllllIlIIllIlIllIIIlIII.getAllUsernames());
        }
        return (llllllllllllllIlIIllIlIllIIIIlll.length == 2) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIlIIllIlIllIIIIlll, Item.REGISTRY.getKeys()) : Collections.emptyList();
    }
}
