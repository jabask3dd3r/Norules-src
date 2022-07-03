package net.minecraft.item;

import net.minecraft.world.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.client.util.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.stats.*;
import net.minecraft.util.*;
import net.minecraft.command.*;
import net.minecraft.entity.*;
import net.minecraft.util.text.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.nbt.*;
import net.minecraft.inventory.*;

public class ItemWrittenBook extends Item
{
    @Override
    public String getItemStackDisplayName(final ItemStack lllllllllllllIIlIlIllIllIIIIlIII) {
        if (lllllllllllllIIlIlIllIllIIIIlIII.hasTagCompound()) {
            final NBTTagCompound lllllllllllllIIlIlIllIllIIIIlIll = lllllllllllllIIlIlIllIllIIIIlIII.getTagCompound();
            final String lllllllllllllIIlIlIllIllIIIIlIlI = lllllllllllllIIlIlIllIllIIIIlIll.getString("title");
            if (!StringUtils.isNullOrEmpty(lllllllllllllIIlIlIllIllIIIIlIlI)) {
                return lllllllllllllIIlIlIllIllIIIIlIlI;
            }
        }
        return super.getItemStackDisplayName(lllllllllllllIIlIlIllIllIIIIlIII);
    }
    
    @Override
    public void addInformation(final ItemStack lllllllllllllIIlIlIllIllIIIIIIII, @Nullable final World lllllllllllllIIlIlIllIlIllllllll, final List<String> lllllllllllllIIlIlIllIlIlllllllI, final ITooltipFlag lllllllllllllIIlIlIllIlIllllllIl) {
        if (lllllllllllllIIlIlIllIllIIIIIIII.hasTagCompound()) {
            final NBTTagCompound lllllllllllllIIlIlIllIlIllllllII = lllllllllllllIIlIlIllIllIIIIIIII.getTagCompound();
            final String lllllllllllllIIlIlIllIlIlllllIll = lllllllllllllIIlIlIllIlIllllllII.getString("author");
            if (!StringUtils.isNullOrEmpty(lllllllllllllIIlIlIllIlIlllllIll)) {
                lllllllllllllIIlIlIllIlIlllllllI.add(String.valueOf(new StringBuilder().append(TextFormatting.GRAY).append(I18n.translateToLocalFormatted("book.byAuthor", lllllllllllllIIlIlIllIlIlllllIll))));
            }
            lllllllllllllIIlIlIllIlIlllllllI.add(String.valueOf(new StringBuilder().append(TextFormatting.GRAY).append(I18n.translateToLocal(String.valueOf(new StringBuilder("book.generation.").append(lllllllllllllIIlIlIllIlIllllllII.getInteger("generation")))))));
        }
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World lllllllllllllIIlIlIllIlIlllIlIll, final EntityPlayer lllllllllllllIIlIlIllIlIlllIlIlI, final EnumHand lllllllllllllIIlIlIllIlIlllIlIIl) {
        final ItemStack lllllllllllllIIlIlIllIlIlllIllIl = lllllllllllllIIlIlIllIlIlllIlIlI.getHeldItem(lllllllllllllIIlIlIllIlIlllIlIIl);
        if (!lllllllllllllIIlIlIllIlIlllIlIll.isRemote) {
            this.resolveContents(lllllllllllllIIlIlIllIlIlllIllIl, lllllllllllllIIlIlIllIlIlllIlIlI);
        }
        lllllllllllllIIlIlIllIlIlllIlIlI.openBook(lllllllllllllIIlIlIllIlIlllIllIl, lllllllllllllIIlIlIllIlIlllIlIIl);
        lllllllllllllIIlIlIllIlIlllIlIlI.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, lllllllllllllIIlIlIllIlIlllIllIl);
    }
    
    @Override
    public boolean hasEffect(final ItemStack lllllllllllllIIlIlIllIlIllIIlIll) {
        return true;
    }
    
    public static boolean validBookTagContents(final NBTTagCompound lllllllllllllIIlIlIllIllIIIlIllI) {
        if (!ItemWritableBook.isNBTValid(lllllllllllllIIlIlIllIllIIIlIllI)) {
            return false;
        }
        if (!lllllllllllllIIlIlIllIllIIIlIllI.hasKey("title", 8)) {
            return false;
        }
        final String lllllllllllllIIlIlIllIllIIIlIlll = lllllllllllllIIlIlIllIllIIIlIllI.getString("title");
        return lllllllllllllIIlIlIllIllIIIlIlll != null && lllllllllllllIIlIlIllIllIIIlIlll.length() <= 32 && lllllllllllllIIlIlIllIllIIIlIllI.hasKey("author", 8);
    }
    
    public ItemWrittenBook() {
        this.setMaxStackSize(1);
    }
    
    public static int getGeneration(final ItemStack lllllllllllllIIlIlIllIllIIIlIIlI) {
        return lllllllllllllIIlIlIllIllIIIlIIlI.getTagCompound().getInteger("generation");
    }
    
    private void resolveContents(final ItemStack lllllllllllllIIlIlIllIlIllIllllI, final EntityPlayer lllllllllllllIIlIlIllIlIllIlIIll) {
        if (lllllllllllllIIlIlIllIlIllIllllI.getTagCompound() != null) {
            final NBTTagCompound lllllllllllllIIlIlIllIlIllIlllII = lllllllllllllIIlIlIllIlIllIllllI.getTagCompound();
            if (!lllllllllllllIIlIlIllIlIllIlllII.getBoolean("resolved")) {
                lllllllllllllIIlIlIllIlIllIlllII.setBoolean("resolved", true);
                if (validBookTagContents(lllllllllllllIIlIlIllIlIllIlllII)) {
                    final NBTTagList lllllllllllllIIlIlIllIlIllIllIll = lllllllllllllIIlIlIllIlIllIlllII.getTagList("pages", 8);
                    for (int lllllllllllllIIlIlIllIlIllIllIlI = 0; lllllllllllllIIlIlIllIlIllIllIlI < lllllllllllllIIlIlIllIlIllIllIll.tagCount(); ++lllllllllllllIIlIlIllIlIllIllIlI) {
                        final String lllllllllllllIIlIlIllIlIllIllIIl = lllllllllllllIIlIlIllIlIllIllIll.getStringTagAt(lllllllllllllIIlIlIllIlIllIllIlI);
                        ITextComponent lllllllllllllIIlIlIllIlIllIlIlll = null;
                        try {
                            ITextComponent lllllllllllllIIlIlIllIlIllIllIII = ITextComponent.Serializer.fromJsonLenient(lllllllllllllIIlIlIllIlIllIllIIl);
                            lllllllllllllIIlIlIllIlIllIllIII = TextComponentUtils.processComponent(lllllllllllllIIlIlIllIlIllIlIIll, lllllllllllllIIlIlIllIlIllIllIII, lllllllllllllIIlIlIllIlIllIlIIll);
                        }
                        catch (Exception lllllllllllllIIlIlIllIlIllIlIllI) {
                            lllllllllllllIIlIlIllIlIllIlIlll = new TextComponentString(lllllllllllllIIlIlIllIlIllIllIIl);
                        }
                        lllllllllllllIIlIlIllIlIllIllIll.set(lllllllllllllIIlIlIllIlIllIllIlI, new NBTTagString(ITextComponent.Serializer.componentToJson(lllllllllllllIIlIlIllIlIllIlIlll)));
                    }
                    lllllllllllllIIlIlIllIlIllIlllII.setTag("pages", lllllllllllllIIlIlIllIlIllIllIll);
                    if (lllllllllllllIIlIlIllIlIllIlIIll instanceof EntityPlayerMP && lllllllllllllIIlIlIllIlIllIlIIll.getHeldItemMainhand() == lllllllllllllIIlIlIllIlIllIllllI) {
                        final Slot lllllllllllllIIlIlIllIlIllIlIlIl = lllllllllllllIIlIlIllIlIllIlIIll.openContainer.getSlotFromInventory(lllllllllllllIIlIlIllIlIllIlIIll.inventory, lllllllllllllIIlIlIllIlIllIlIIll.inventory.currentItem);
                        ((EntityPlayerMP)lllllllllllllIIlIlIllIlIllIlIIll).connection.sendPacket(new SPacketSetSlot(0, lllllllllllllIIlIlIllIlIllIlIlIl.slotNumber, lllllllllllllIIlIlIllIlIllIllllI));
                    }
                }
            }
        }
    }
}
