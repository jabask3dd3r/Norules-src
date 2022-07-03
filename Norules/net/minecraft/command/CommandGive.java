package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.nbt.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;

public class CommandGive extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIIlIIllIlIlIIlllII) {
        return "commands.give.usage";
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllIIlIIllIlIlIIIllll, final ICommandSender llllllllllllllIIlIIllIlIlIIIlllI, final String[] llllllllllllllIIlIIllIlIlIIIllIl) throws CommandException {
        if (llllllllllllllIIlIIllIlIlIIIllIl.length < 2) {
            throw new WrongUsageException("commands.give.usage", new Object[0]);
        }
        final EntityPlayer llllllllllllllIIlIIllIlIlIIIllII = CommandBase.getPlayer(llllllllllllllIIlIIllIlIlIIIllll, llllllllllllllIIlIIllIlIlIIIlllI, llllllllllllllIIlIIllIlIlIIIllIl[0]);
        final Item llllllllllllllIIlIIllIlIlIIIlIll = CommandBase.getItemByText(llllllllllllllIIlIIllIlIlIIIlllI, llllllllllllllIIlIIllIlIlIIIllIl[1]);
        final int llllllllllllllIIlIIllIlIlIIIlIlI = (llllllllllllllIIlIIllIlIlIIIllIl.length >= 3) ? CommandBase.parseInt(llllllllllllllIIlIIllIlIlIIIllIl[2], 1, llllllllllllllIIlIIllIlIlIIIlIll.getItemStackLimit()) : 1;
        final int llllllllllllllIIlIIllIlIlIIIlIIl = (llllllllllllllIIlIIllIlIlIIIllIl.length >= 4) ? CommandBase.parseInt(llllllllllllllIIlIIllIlIlIIIllIl[3]) : 0;
        final ItemStack llllllllllllllIIlIIllIlIlIIIlIII = new ItemStack(llllllllllllllIIlIIllIlIlIIIlIll, llllllllllllllIIlIIllIlIlIIIlIlI, llllllllllllllIIlIIllIlIlIIIlIIl);
        if (llllllllllllllIIlIIllIlIlIIIllIl.length >= 5) {
            final String llllllllllllllIIlIIllIlIlIIIIlll = CommandBase.buildString(llllllllllllllIIlIIllIlIlIIIllIl, 4);
            try {
                llllllllllllllIIlIIllIlIlIIIlIII.setTagCompound(JsonToNBT.getTagFromJson(llllllllllllllIIlIIllIlIlIIIIlll));
            }
            catch (NBTException llllllllllllllIIlIIllIlIlIIIIllI) {
                throw new CommandException("commands.give.tagError", new Object[] { llllllllllllllIIlIIllIlIlIIIIllI.getMessage() });
            }
        }
        final boolean llllllllllllllIIlIIllIlIlIIIIlIl = llllllllllllllIIlIIllIlIlIIIllII.inventory.addItemStackToInventory(llllllllllllllIIlIIllIlIlIIIlIII);
        if (llllllllllllllIIlIIllIlIlIIIIlIl) {
            llllllllllllllIIlIIllIlIlIIIllII.world.playSound(null, llllllllllllllIIlIIllIlIlIIIllII.posX, llllllllllllllIIlIIllIlIlIIIllII.posY, llllllllllllllIIlIIllIlIlIIIllII.posZ, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.2f, ((llllllllllllllIIlIIllIlIlIIIllII.getRNG().nextFloat() - llllllllllllllIIlIIllIlIlIIIllII.getRNG().nextFloat()) * 0.7f + 1.0f) * 2.0f);
            llllllllllllllIIlIIllIlIlIIIllII.inventoryContainer.detectAndSendChanges();
        }
        if (llllllllllllllIIlIIllIlIlIIIIlIl && llllllllllllllIIlIIllIlIlIIIlIII.func_190926_b()) {
            llllllllllllllIIlIIllIlIlIIIlIII.func_190920_e(1);
            llllllllllllllIIlIIllIlIlIIIlllI.setCommandStat(CommandResultStats.Type.AFFECTED_ITEMS, llllllllllllllIIlIIllIlIlIIIlIlI);
            final EntityItem llllllllllllllIIlIIllIlIlIIIIlII = llllllllllllllIIlIIllIlIlIIIllII.dropItem(llllllllllllllIIlIIllIlIlIIIlIII, false);
            if (llllllllllllllIIlIIllIlIlIIIIlII != null) {
                llllllllllllllIIlIIllIlIlIIIIlII.makeFakeItem();
            }
        }
        else {
            llllllllllllllIIlIIllIlIlIIIlllI.setCommandStat(CommandResultStats.Type.AFFECTED_ITEMS, llllllllllllllIIlIIllIlIlIIIlIlI - llllllllllllllIIlIIllIlIlIIIlIII.func_190916_E());
            final EntityItem llllllllllllllIIlIIllIlIlIIIIIll = llllllllllllllIIlIIllIlIlIIIllII.dropItem(llllllllllllllIIlIIllIlIlIIIlIII, false);
            if (llllllllllllllIIlIIllIlIlIIIIIll != null) {
                llllllllllllllIIlIIllIlIlIIIIIll.setNoPickupDelay();
                llllllllllllllIIlIIllIlIlIIIIIll.setOwner(llllllllllllllIIlIIllIlIlIIIllII.getName());
            }
        }
        CommandBase.notifyCommandListener(llllllllllllllIIlIIllIlIlIIIlllI, this, "commands.give.success", llllllllllllllIIlIIllIlIlIIIlIII.getTextComponent(), llllllllllllllIIlIIllIlIlIIIlIlI, llllllllllllllIIlIIllIlIlIIIllII.getName());
    }
    
    @Override
    public String getCommandName() {
        return "give";
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllllIIlIIllIlIIllIllII, final int llllllllllllllIIlIIllIlIIllIlIlI) {
        return llllllllllllllIIlIIllIlIIllIlIlI == 0;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllllIIlIIllIlIIlllIIII, final ICommandSender llllllllllllllIIlIIllIlIIlllIIll, final String[] llllllllllllllIIlIIllIlIIllIllll, @Nullable final BlockPos llllllllllllllIIlIIllIlIIlllIIIl) {
        if (llllllllllllllIIlIIllIlIIllIllll.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIlIIllIlIIllIllll, llllllllllllllIIlIIllIlIIlllIIII.getAllUsernames());
        }
        return (llllllllllllllIIlIIllIlIIllIllll.length == 2) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIlIIllIlIIllIllll, Item.REGISTRY.getKeys()) : Collections.emptyList();
    }
}
