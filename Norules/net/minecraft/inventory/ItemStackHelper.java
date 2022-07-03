package net.minecraft.inventory;

import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import java.util.*;

public class ItemStackHelper
{
    public static void func_191283_b(final NBTTagCompound llllllllllllllIIIIlIlIIIlIlllIll, final NonNullList<ItemStack> llllllllllllllIIIIlIlIIIlIlllIlI) {
        final NBTTagList llllllllllllllIIIIlIlIIIlIlllIIl = llllllllllllllIIIIlIlIIIlIlllIll.getTagList("Items", 10);
        for (int llllllllllllllIIIIlIlIIIlIlllIII = 0; llllllllllllllIIIIlIlIIIlIlllIII < llllllllllllllIIIIlIlIIIlIlllIIl.tagCount(); ++llllllllllllllIIIIlIlIIIlIlllIII) {
            final NBTTagCompound llllllllllllllIIIIlIlIIIlIllIlll = llllllllllllllIIIIlIlIIIlIlllIIl.getCompoundTagAt(llllllllllllllIIIIlIlIIIlIlllIII);
            final int llllllllllllllIIIIlIlIIIlIllIllI = llllllllllllllIIIIlIlIIIlIllIlll.getByte("Slot") & 0xFF;
            if (llllllllllllllIIIIlIlIIIlIllIllI >= 0 && llllllllllllllIIIIlIlIIIlIllIllI < llllllllllllllIIIIlIlIIIlIlllIlI.size()) {
                llllllllllllllIIIIlIlIIIlIlllIlI.set(llllllllllllllIIIIlIlIIIlIllIllI, new ItemStack(llllllllllllllIIIIlIlIIIlIllIlll));
            }
        }
    }
    
    public static NBTTagCompound func_191281_a(final NBTTagCompound llllllllllllllIIIIlIlIIIllIIlIII, final NonNullList<ItemStack> llllllllllllllIIIIlIlIIIllIIlllI, final boolean llllllllllllllIIIIlIlIIIllIIIllI) {
        final NBTTagList llllllllllllllIIIIlIlIIIllIIllII = new NBTTagList();
        for (int llllllllllllllIIIIlIlIIIllIIlIll = 0; llllllllllllllIIIIlIlIIIllIIlIll < llllllllllllllIIIIlIlIIIllIIlllI.size(); ++llllllllllllllIIIIlIlIIIllIIlIll) {
            final ItemStack llllllllllllllIIIIlIlIIIllIIlIlI = llllllllllllllIIIIlIlIIIllIIlllI.get(llllllllllllllIIIIlIlIIIllIIlIll);
            if (!llllllllllllllIIIIlIlIIIllIIlIlI.func_190926_b()) {
                final NBTTagCompound llllllllllllllIIIIlIlIIIllIIlIIl = new NBTTagCompound();
                llllllllllllllIIIIlIlIIIllIIlIIl.setByte("Slot", (byte)llllllllllllllIIIIlIlIIIllIIlIll);
                llllllllllllllIIIIlIlIIIllIIlIlI.writeToNBT(llllllllllllllIIIIlIlIIIllIIlIIl);
                llllllllllllllIIIIlIlIIIllIIllII.appendTag(llllllllllllllIIIIlIlIIIllIIlIIl);
            }
        }
        if (!llllllllllllllIIIIlIlIIIllIIllII.hasNoTags() || llllllllllllllIIIIlIlIIIllIIIllI) {
            llllllllllllllIIIIlIlIIIllIIlIII.setTag("Items", llllllllllllllIIIIlIlIIIllIIllII);
        }
        return llllllllllllllIIIIlIlIIIllIIlIII;
    }
    
    public static ItemStack getAndRemove(final List<ItemStack> llllllllllllllIIIIlIlIIIllIllllI, final int llllllllllllllIIIIlIlIIIllIlllIl) {
        return (llllllllllllllIIIIlIlIIIllIlllIl >= 0 && llllllllllllllIIIIlIlIIIllIlllIl < llllllllllllllIIIIlIlIIIllIllllI.size()) ? llllllllllllllIIIIlIlIIIllIllllI.set(llllllllllllllIIIIlIlIIIllIlllIl, ItemStack.field_190927_a) : ItemStack.field_190927_a;
    }
    
    public static ItemStack getAndSplit(final List<ItemStack> llllllllllllllIIIIlIlIIIlllIlIII, final int llllllllllllllIIIIlIlIIIlllIIlll, final int llllllllllllllIIIIlIlIIIlllIIllI) {
        return (llllllllllllllIIIIlIlIIIlllIIlll >= 0 && llllllllllllllIIIIlIlIIIlllIIlll < llllllllllllllIIIIlIlIIIlllIlIII.size() && !llllllllllllllIIIIlIlIIIlllIlIII.get(llllllllllllllIIIIlIlIIIlllIIlll).func_190926_b() && llllllllllllllIIIIlIlIIIlllIIllI > 0) ? llllllllllllllIIIIlIlIIIlllIlIII.get(llllllllllllllIIIIlIlIIIlllIIlll).splitStack(llllllllllllllIIIIlIlIIIlllIIllI) : ItemStack.field_190927_a;
    }
    
    public static NBTTagCompound func_191282_a(final NBTTagCompound llllllllllllllIIIIlIlIIIllIllIlI, final NonNullList<ItemStack> llllllllllllllIIIIlIlIIIllIlIlll) {
        return func_191281_a(llllllllllllllIIIIlIlIIIllIllIlI, llllllllllllllIIIIlIlIIIllIlIlll, true);
    }
}
