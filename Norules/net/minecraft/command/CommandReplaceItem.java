package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.*;
import javax.annotation.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.inventory.*;

public class CommandReplaceItem extends CommandBase
{
    private static final /* synthetic */ Map<String, Integer> SHORTCUTS;
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIIlIIllIIlllllIIlIl, final ICommandSender lllllllllllllIIlIIllIIlllllIIlII, final String[] lllllllllllllIIlIIllIIlllllIIIll) throws CommandException {
        if (lllllllllllllIIlIIllIIlllllIIIll.length < 1) {
            throw new WrongUsageException("commands.replaceitem.usage", new Object[0]);
        }
        boolean lllllllllllllIIlIIllIIlllllIIIIl = false;
        if ("entity".equals(lllllllllllllIIlIIllIIlllllIIIll[0])) {
            final boolean lllllllllllllIIlIIllIIlllllIIIlI = false;
        }
        else {
            if (!"block".equals(lllllllllllllIIlIIllIIlllllIIIll[0])) {
                throw new WrongUsageException("commands.replaceitem.usage", new Object[0]);
            }
            lllllllllllllIIlIIllIIlllllIIIIl = true;
        }
        int lllllllllllllIIlIIllIIllllIlllll = 0;
        if (lllllllllllllIIlIIllIIlllllIIIIl) {
            if (lllllllllllllIIlIIllIIlllllIIIll.length < 6) {
                throw new WrongUsageException("commands.replaceitem.block.usage", new Object[0]);
            }
            final int lllllllllllllIIlIIllIIlllllIIIII = 4;
        }
        else {
            if (lllllllllllllIIlIIllIIlllllIIIll.length < 4) {
                throw new WrongUsageException("commands.replaceitem.entity.usage", new Object[0]);
            }
            lllllllllllllIIlIIllIIllllIlllll = 2;
        }
        final String lllllllllllllIIlIIllIIllllIllllI = lllllllllllllIIlIIllIIlllllIIIll[lllllllllllllIIlIIllIIllllIlllll];
        final int lllllllllllllIIlIIllIIllllIlllIl = this.getSlotForShortcut(lllllllllllllIIlIIllIIlllllIIIll[lllllllllllllIIlIIllIIllllIlllll++]);
        Item lllllllllllllIIlIIllIIllllIllIll = null;
        try {
            final Item lllllllllllllIIlIIllIIllllIlllII = CommandBase.getItemByText(lllllllllllllIIlIIllIIlllllIIlII, lllllllllllllIIlIIllIIlllllIIIll[lllllllllllllIIlIIllIIllllIlllll]);
        }
        catch (NumberInvalidException lllllllllllllIIlIIllIIllllIllIlI) {
            if (Block.getBlockFromName(lllllllllllllIIlIIllIIlllllIIIll[lllllllllllllIIlIIllIIllllIlllll]) != Blocks.AIR) {
                throw lllllllllllllIIlIIllIIllllIllIlI;
            }
            lllllllllllllIIlIIllIIllllIllIll = null;
        }
        ++lllllllllllllIIlIIllIIllllIlllll;
        final int lllllllllllllIIlIIllIIllllIllIIl = (lllllllllllllIIlIIllIIlllllIIIll.length > lllllllllllllIIlIIllIIllllIlllll) ? CommandBase.parseInt(lllllllllllllIIlIIllIIlllllIIIll[lllllllllllllIIlIIllIIllllIlllll++], 1, lllllllllllllIIlIIllIIllllIllIll.getItemStackLimit()) : 1;
        final int lllllllllllllIIlIIllIIllllIllIII = (lllllllllllllIIlIIllIIlllllIIIll.length > lllllllllllllIIlIIllIIllllIlllll) ? CommandBase.parseInt(lllllllllllllIIlIIllIIlllllIIIll[lllllllllllllIIlIIllIIllllIlllll++]) : 0;
        final ItemStack lllllllllllllIIlIIllIIllllIlIlll = new ItemStack(lllllllllllllIIlIIllIIllllIllIll, lllllllllllllIIlIIllIIllllIllIIl, lllllllllllllIIlIIllIIllllIllIII);
        if (lllllllllllllIIlIIllIIlllllIIIll.length > lllllllllllllIIlIIllIIllllIlllll) {
            final String lllllllllllllIIlIIllIIllllIlIllI = CommandBase.buildString(lllllllllllllIIlIIllIIlllllIIIll, lllllllllllllIIlIIllIIllllIlllll);
            try {
                lllllllllllllIIlIIllIIllllIlIlll.setTagCompound(JsonToNBT.getTagFromJson(lllllllllllllIIlIIllIIllllIlIllI));
            }
            catch (NBTException lllllllllllllIIlIIllIIllllIlIlIl) {
                throw new CommandException("commands.replaceitem.tagError", new Object[] { lllllllllllllIIlIIllIIllllIlIlIl.getMessage() });
            }
        }
        if (lllllllllllllIIlIIllIIlllllIIIIl) {
            lllllllllllllIIlIIllIIlllllIIlII.setCommandStat(CommandResultStats.Type.AFFECTED_ITEMS, 0);
            final BlockPos lllllllllllllIIlIIllIIllllIlIlII = CommandBase.parseBlockPos(lllllllllllllIIlIIllIIlllllIIlII, lllllllllllllIIlIIllIIlllllIIIll, 1, false);
            final World lllllllllllllIIlIIllIIllllIlIIll = lllllllllllllIIlIIllIIlllllIIlII.getEntityWorld();
            final TileEntity lllllllllllllIIlIIllIIllllIlIIlI = lllllllllllllIIlIIllIIllllIlIIll.getTileEntity(lllllllllllllIIlIIllIIllllIlIlII);
            if (lllllllllllllIIlIIllIIllllIlIIlI == null || !(lllllllllllllIIlIIllIIllllIlIIlI instanceof IInventory)) {
                throw new CommandException("commands.replaceitem.noContainer", new Object[] { lllllllllllllIIlIIllIIllllIlIlII.getX(), lllllllllllllIIlIIllIIllllIlIlII.getY(), lllllllllllllIIlIIllIIllllIlIlII.getZ() });
            }
            final IInventory lllllllllllllIIlIIllIIllllIlIIIl = (IInventory)lllllllllllllIIlIIllIIllllIlIIlI;
            if (lllllllllllllIIlIIllIIllllIlllIl >= 0 && lllllllllllllIIlIIllIIllllIlllIl < lllllllllllllIIlIIllIIllllIlIIIl.getSizeInventory()) {
                lllllllllllllIIlIIllIIllllIlIIIl.setInventorySlotContents(lllllllllllllIIlIIllIIllllIlllIl, lllllllllllllIIlIIllIIllllIlIlll);
            }
        }
        else {
            final Entity lllllllllllllIIlIIllIIllllIlIIII = CommandBase.getEntity(lllllllllllllIIlIIllIIlllllIIlIl, lllllllllllllIIlIIllIIlllllIIlII, lllllllllllllIIlIIllIIlllllIIIll[1]);
            lllllllllllllIIlIIllIIlllllIIlII.setCommandStat(CommandResultStats.Type.AFFECTED_ITEMS, 0);
            if (lllllllllllllIIlIIllIIllllIlIIII instanceof EntityPlayer) {
                ((EntityPlayer)lllllllllllllIIlIIllIIllllIlIIII).inventoryContainer.detectAndSendChanges();
            }
            if (!lllllllllllllIIlIIllIIllllIlIIII.replaceItemInInventory(lllllllllllllIIlIIllIIllllIlllIl, lllllllllllllIIlIIllIIllllIlIlll)) {
                throw new CommandException("commands.replaceitem.failed", new Object[] { lllllllllllllIIlIIllIIllllIllllI, lllllllllllllIIlIIllIIllllIllIIl, lllllllllllllIIlIIllIIllllIlIlll.func_190926_b() ? "Air" : lllllllllllllIIlIIllIIllllIlIlll.getTextComponent() });
            }
            if (lllllllllllllIIlIIllIIllllIlIIII instanceof EntityPlayer) {
                ((EntityPlayer)lllllllllllllIIlIIllIIllllIlIIII).inventoryContainer.detectAndSendChanges();
            }
        }
        lllllllllllllIIlIIllIIlllllIIlII.setCommandStat(CommandResultStats.Type.AFFECTED_ITEMS, lllllllllllllIIlIIllIIllllIllIIl);
        CommandBase.notifyCommandListener(lllllllllllllIIlIIllIIlllllIIlII, this, "commands.replaceitem.success", lllllllllllllIIlIIllIIllllIllllI, lllllllllllllIIlIIllIIllllIllIIl, lllllllllllllIIlIIllIIllllIlIlll.func_190926_b() ? "Air" : lllllllllllllIIlIIllIIllllIlIlll.getTextComponent());
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllllIIlIIllIIlllIlIllIl, final int lllllllllllllIIlIIllIIlllIlIllII) {
        return lllllllllllllIIlIIllIIlllIlIllIl.length > 0 && "entity".equals(lllllllllllllIIlIIllIIlllIlIllIl[0]) && lllllllllllllIIlIIllIIlllIlIllII == 1;
    }
    
    private int getSlotForShortcut(final String lllllllllllllIIlIIllIIlllIllllIl) throws CommandException {
        if (!CommandReplaceItem.SHORTCUTS.containsKey(lllllllllllllIIlIIllIIlllIllllIl)) {
            throw new CommandException("commands.generic.parameter.invalid", new Object[] { lllllllllllllIIlIIllIIlllIllllIl });
        }
        return CommandReplaceItem.SHORTCUTS.get(lllllllllllllIIlIIllIIlllIllllIl);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIIlIIllIIllllllIlll) {
        return "commands.replaceitem.usage";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIIlIIllIIlllIllIlll, final ICommandSender lllllllllllllIIlIIllIIlllIllIllI, final String[] lllllllllllllIIlIIllIIlllIllIlIl, @Nullable final BlockPos lllllllllllllIIlIIllIIlllIllIlII) {
        if (lllllllllllllIIlIIllIIlllIllIlIl.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIlIIllIIlllIllIlIl, "entity", "block");
        }
        if (lllllllllllllIIlIIllIIlllIllIlIl.length == 2 && "entity".equals(lllllllllllllIIlIIllIIlllIllIlIl[0])) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIlIIllIIlllIllIlIl, lllllllllllllIIlIIllIIlllIllIlll.getAllUsernames());
        }
        if (lllllllllllllIIlIIllIIlllIllIlIl.length >= 2 && lllllllllllllIIlIIllIIlllIllIlIl.length <= 4 && "block".equals(lllllllllllllIIlIIllIIlllIllIlIl[0])) {
            return CommandBase.getTabCompletionCoordinate(lllllllllllllIIlIIllIIlllIllIlIl, 1, lllllllllllllIIlIIllIIlllIllIlII);
        }
        if ((lllllllllllllIIlIIllIIlllIllIlIl.length != 3 || !"entity".equals(lllllllllllllIIlIIllIIlllIllIlIl[0])) && (lllllllllllllIIlIIllIIlllIllIlIl.length != 5 || !"block".equals(lllllllllllllIIlIIllIIlllIllIlIl[0]))) {
            return ((lllllllllllllIIlIIllIIlllIllIlIl.length != 4 || !"entity".equals(lllllllllllllIIlIIllIIlllIllIlIl[0])) && (lllllllllllllIIlIIllIIlllIllIlIl.length != 6 || !"block".equals(lllllllllllllIIlIIllIIlllIllIlIl[0]))) ? Collections.emptyList() : CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIlIIllIIlllIllIlIl, Item.REGISTRY.getKeys());
        }
        return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIlIIllIIlllIllIlIl, CommandReplaceItem.SHORTCUTS.keySet());
    }
    
    static {
        SHORTCUTS = Maps.newHashMap();
        for (int lllllllllllllIIlIIllIlIIIIIIIlII = 0; lllllllllllllIIlIIllIlIIIIIIIlII < 54; ++lllllllllllllIIlIIllIlIIIIIIIlII) {
            CommandReplaceItem.SHORTCUTS.put(String.valueOf(new StringBuilder("slot.container.").append(lllllllllllllIIlIIllIlIIIIIIIlII)), lllllllllllllIIlIIllIlIIIIIIIlII);
        }
        for (int lllllllllllllIIlIIllIlIIIIIIIIll = 0; lllllllllllllIIlIIllIlIIIIIIIIll < 9; ++lllllllllllllIIlIIllIlIIIIIIIIll) {
            CommandReplaceItem.SHORTCUTS.put(String.valueOf(new StringBuilder("slot.hotbar.").append(lllllllllllllIIlIIllIlIIIIIIIIll)), lllllllllllllIIlIIllIlIIIIIIIIll);
        }
        for (int lllllllllllllIIlIIllIlIIIIIIIIlI = 0; lllllllllllllIIlIIllIlIIIIIIIIlI < 27; ++lllllllllllllIIlIIllIlIIIIIIIIlI) {
            CommandReplaceItem.SHORTCUTS.put(String.valueOf(new StringBuilder("slot.inventory.").append(lllllllllllllIIlIIllIlIIIIIIIIlI)), 9 + lllllllllllllIIlIIllIlIIIIIIIIlI);
        }
        for (int lllllllllllllIIlIIllIlIIIIIIIIIl = 0; lllllllllllllIIlIIllIlIIIIIIIIIl < 27; ++lllllllllllllIIlIIllIlIIIIIIIIIl) {
            CommandReplaceItem.SHORTCUTS.put(String.valueOf(new StringBuilder("slot.enderchest.").append(lllllllllllllIIlIIllIlIIIIIIIIIl)), 200 + lllllllllllllIIlIIllIlIIIIIIIIIl);
        }
        for (int lllllllllllllIIlIIllIlIIIIIIIIII = 0; lllllllllllllIIlIIllIlIIIIIIIIII < 8; ++lllllllllllllIIlIIllIlIIIIIIIIII) {
            CommandReplaceItem.SHORTCUTS.put(String.valueOf(new StringBuilder("slot.villager.").append(lllllllllllllIIlIIllIlIIIIIIIIII)), 300 + lllllllllllllIIlIIllIlIIIIIIIIII);
        }
        for (int lllllllllllllIIlIIllIIllllllllll = 0; lllllllllllllIIlIIllIIllllllllll < 15; ++lllllllllllllIIlIIllIIllllllllll) {
            CommandReplaceItem.SHORTCUTS.put(String.valueOf(new StringBuilder("slot.horse.").append(lllllllllllllIIlIIllIIllllllllll)), 500 + lllllllllllllIIlIIllIIllllllllll);
        }
        CommandReplaceItem.SHORTCUTS.put("slot.weapon", 98);
        CommandReplaceItem.SHORTCUTS.put("slot.weapon.mainhand", 98);
        CommandReplaceItem.SHORTCUTS.put("slot.weapon.offhand", 99);
        CommandReplaceItem.SHORTCUTS.put("slot.armor.head", 100 + EntityEquipmentSlot.HEAD.getIndex());
        CommandReplaceItem.SHORTCUTS.put("slot.armor.chest", 100 + EntityEquipmentSlot.CHEST.getIndex());
        CommandReplaceItem.SHORTCUTS.put("slot.armor.legs", 100 + EntityEquipmentSlot.LEGS.getIndex());
        CommandReplaceItem.SHORTCUTS.put("slot.armor.feet", 100 + EntityEquipmentSlot.FEET.getIndex());
        CommandReplaceItem.SHORTCUTS.put("slot.horse.saddle", 400);
        CommandReplaceItem.SHORTCUTS.put("slot.horse.armor", 401);
        CommandReplaceItem.SHORTCUTS.put("slot.horse.chest", 499);
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandName() {
        return "replaceitem";
    }
}
