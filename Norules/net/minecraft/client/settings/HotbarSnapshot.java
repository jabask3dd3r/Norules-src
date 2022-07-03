package net.minecraft.client.settings;

import java.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;

public class HotbarSnapshot extends ArrayList<ItemStack>
{
    public static final /* synthetic */ int field_192835_a;
    
    static {
        field_192835_a = InventoryPlayer.getHotbarSize();
    }
    
    @Override
    public boolean isEmpty() {
        for (int lIlllIllIIlllll = 0; lIlllIllIIlllll < HotbarSnapshot.field_192835_a; ++lIlllIllIIlllll) {
            if (!this.get(lIlllIllIIlllll).func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    public NBTTagList func_192834_a() {
        final NBTTagList lIlllIllIllIIII = new NBTTagList();
        for (int lIlllIllIlIllll = 0; lIlllIllIlIllll < HotbarSnapshot.field_192835_a; ++lIlllIllIlIllll) {
            lIlllIllIllIIII.appendTag(this.get(lIlllIllIlIllll).writeToNBT(new NBTTagCompound()));
        }
        return lIlllIllIllIIII;
    }
    
    public HotbarSnapshot() {
        this.ensureCapacity(HotbarSnapshot.field_192835_a);
        for (int lIlllIllIllIlll = 0; lIlllIllIllIlll < HotbarSnapshot.field_192835_a; ++lIlllIllIllIlll) {
            this.add(ItemStack.field_190927_a);
        }
    }
    
    public void func_192833_a(final NBTTagList lIlllIllIlIIlII) {
        for (int lIlllIllIlIIllI = 0; lIlllIllIlIIllI < HotbarSnapshot.field_192835_a; ++lIlllIllIlIIllI) {
            this.set(lIlllIllIlIIllI, new ItemStack(lIlllIllIlIIlII.getCompoundTagAt(lIlllIllIlIIllI)));
        }
    }
}
