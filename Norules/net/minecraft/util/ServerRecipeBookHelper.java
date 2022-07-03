package net.minecraft.util;

import net.minecraft.client.util.*;
import net.minecraft.item.*;
import it.unimi.dsi.fastutil.ints.*;
import net.minecraft.entity.player.*;
import javax.annotation.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.inventory.*;
import net.minecraft.item.crafting.*;
import java.util.*;
import org.apache.logging.log4j.*;

public class ServerRecipeBookHelper
{
    private final /* synthetic */ Logger field_194330_a;
    private /* synthetic */ List<Slot> field_194337_h;
    private /* synthetic */ InventoryCraftResult field_194335_f;
    private /* synthetic */ EntityPlayerMP field_194332_c;
    private final /* synthetic */ RecipeItemHelper field_194331_b;
    private /* synthetic */ boolean field_194334_e;
    private /* synthetic */ IRecipe field_194333_d;
    private /* synthetic */ InventoryCrafting field_194336_g;
    
    private void func_194329_b() {
        final boolean llllllllllllllIllIIlIIIIIllIlIlI = this.field_194333_d.matches(this.field_194336_g, this.field_194332_c.world);
        final int llllllllllllllIllIIlIIIIIllIlIIl = this.field_194331_b.func_194114_b(this.field_194333_d, null);
        if (llllllllllllllIllIIlIIIIIllIlIlI) {
            boolean llllllllllllllIllIIlIIIIIllIlIII = true;
            for (int llllllllllllllIllIIlIIIIIllIIlll = 0; llllllllllllllIllIIlIIIIIllIIlll < this.field_194336_g.getSizeInventory(); ++llllllllllllllIllIIlIIIIIllIIlll) {
                final ItemStack llllllllllllllIllIIlIIIIIllIIllI = this.field_194336_g.getStackInSlot(llllllllllllllIllIIlIIIIIllIIlll);
                if (!llllllllllllllIllIIlIIIIIllIIllI.func_190926_b() && Math.min(llllllllllllllIllIIlIIIIIllIlIIl, llllllllllllllIllIIlIIIIIllIIllI.getMaxStackSize()) > llllllllllllllIllIIlIIIIIllIIllI.func_190916_E()) {
                    llllllllllllllIllIIlIIIIIllIlIII = false;
                }
            }
            if (llllllllllllllIllIIlIIIIIllIlIII) {
                return;
            }
        }
        final int llllllllllllllIllIIlIIIIIllIIlIl = this.func_194324_a(llllllllllllllIllIIlIIIIIllIlIIl, llllllllllllllIllIIlIIIIIllIlIlI);
        final IntList llllllllllllllIllIIlIIIIIllIIlII = (IntList)new IntArrayList();
        if (this.field_194331_b.func_194118_a(this.field_194333_d, llllllllllllllIllIIlIIIIIllIIlII, llllllllllllllIllIIlIIIIIllIIlIl)) {
            int llllllllllllllIllIIlIIIIIllIIIll = llllllllllllllIllIIlIIIIIllIIlIl;
            for (final int llllllllllllllIllIIlIIIIIllIIIIl : llllllllllllllIllIIlIIIIIllIIlII) {
                final int llllllllllllllIllIIlIIIIIllIIIII = RecipeItemHelper.func_194115_b(llllllllllllllIllIIlIIIIIllIIIIl).getMaxStackSize();
                if (llllllllllllllIllIIlIIIIIllIIIII < llllllllllllllIllIIlIIIIIllIIIll) {
                    llllllllllllllIllIIlIIIIIllIIIll = llllllllllllllIllIIlIIIIIllIIIII;
                }
            }
            if (this.field_194331_b.func_194118_a(this.field_194333_d, llllllllllllllIllIIlIIIIIllIIlII, llllllllllllllIllIIlIIIIIllIIIll)) {
                this.func_194326_a();
                this.func_194323_a(llllllllllllllIllIIlIIIIIllIIIll, llllllllllllllIllIIlIIIIIllIIlII);
            }
        }
    }
    
    private void func_194326_a() {
        final InventoryPlayer llllllllllllllIllIIlIIIIIlllllll = this.field_194332_c.inventory;
        for (int llllllllllllllIllIIlIIIIIllllllI = 0; llllllllllllllIllIIlIIIIIllllllI < this.field_194336_g.getSizeInventory(); ++llllllllllllllIllIIlIIIIIllllllI) {
            final ItemStack llllllllllllllIllIIlIIIIIlllllIl = this.field_194336_g.getStackInSlot(llllllllllllllIllIIlIIIIIllllllI);
            if (!llllllllllllllIllIIlIIIIIlllllIl.func_190926_b()) {
                while (llllllllllllllIllIIlIIIIIlllllIl.func_190916_E() > 0) {
                    int llllllllllllllIllIIlIIIIIlllllII = llllllllllllllIllIIlIIIIIlllllll.storeItemStack(llllllllllllllIllIIlIIIIIlllllIl);
                    if (llllllllllllllIllIIlIIIIIlllllII == -1) {
                        llllllllllllllIllIIlIIIIIlllllII = llllllllllllllIllIIlIIIIIlllllll.getFirstEmptyStack();
                    }
                    final ItemStack llllllllllllllIllIIlIIIIIllllIll = llllllllllllllIllIIlIIIIIlllllIl.copy();
                    llllllllllllllIllIIlIIIIIllllIll.func_190920_e(1);
                    llllllllllllllIllIIlIIIIIlllllll.func_191971_c(llllllllllllllIllIIlIIIIIlllllII, llllllllllllllIllIIlIIIIIllllIll);
                    this.field_194336_g.decrStackSize(llllllllllllllIllIIlIIIIIllllllI, 1);
                }
            }
        }
        this.field_194336_g.clear();
        this.field_194335_f.clear();
    }
    
    private boolean func_194328_c() {
        final InventoryPlayer llllllllllllllIllIIlIIIIIIIIIlll = this.field_194332_c.inventory;
        for (int llllllllllllllIllIIlIIIIIIIIIllI = 0; llllllllllllllIllIIlIIIIIIIIIllI < this.field_194336_g.getSizeInventory(); ++llllllllllllllIllIIlIIIIIIIIIllI) {
            final ItemStack llllllllllllllIllIIlIIIIIIIIIlIl = this.field_194336_g.getStackInSlot(llllllllllllllIllIIlIIIIIIIIIllI);
            if (!llllllllllllllIllIIlIIIIIIIIIlIl.func_190926_b()) {
                int llllllllllllllIllIIlIIIIIIIIIlII = llllllllllllllIllIIlIIIIIIIIIlll.storeItemStack(llllllllllllllIllIIlIIIIIIIIIlIl);
                if (llllllllllllllIllIIlIIIIIIIIIlII == -1) {
                    llllllllllllllIllIIlIIIIIIIIIlII = llllllllllllllIllIIlIIIIIIIIIlll.getFirstEmptyStack();
                }
                if (llllllllllllllIllIIlIIIIIIIIIlII == -1) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private int func_194324_a(final int llllllllllllllIllIIlIIIIIlIIllll, final boolean llllllllllllllIllIIlIIIIIlIIlIII) {
        int llllllllllllllIllIIlIIIIIlIIllIl = 1;
        if (this.field_194334_e) {
            llllllllllllllIllIIlIIIIIlIIllIl = llllllllllllllIllIIlIIIIIlIIllll;
        }
        else if (llllllllllllllIllIIlIIIIIlIIlIII) {
            llllllllllllllIllIIlIIIIIlIIllIl = 64;
            for (int llllllllllllllIllIIlIIIIIlIIllII = 0; llllllllllllllIllIIlIIIIIlIIllII < this.field_194336_g.getSizeInventory(); ++llllllllllllllIllIIlIIIIIlIIllII) {
                final ItemStack llllllllllllllIllIIlIIIIIlIIlIll = this.field_194336_g.getStackInSlot(llllllllllllllIllIIlIIIIIlIIllII);
                if (!llllllllllllllIllIIlIIIIIlIIlIll.func_190926_b() && llllllllllllllIllIIlIIIIIlIIllIl > llllllllllllllIllIIlIIIIIlIIlIll.func_190916_E()) {
                    llllllllllllllIllIIlIIIIIlIIllIl = llllllllllllllIllIIlIIIIIlIIlIll.func_190916_E();
                }
            }
            if (llllllllllllllIllIIlIIIIIlIIllIl < 64) {
                ++llllllllllllllIllIIlIIIIIlIIllIl;
            }
        }
        return llllllllllllllIllIIlIIIIIlIIllIl;
    }
    
    public void func_194327_a(final EntityPlayerMP llllllllllllllIllIIlIIIIlIIIlIlI, @Nullable final IRecipe llllllllllllllIllIIlIIIIlIIIlIIl, final boolean llllllllllllllIllIIlIIIIlIIIlIII) {
        if (llllllllllllllIllIIlIIIIlIIIlIIl != null && llllllllllllllIllIIlIIIIlIIIlIlI.func_192037_E().func_193830_f(llllllllllllllIllIIlIIIIlIIIlIIl)) {
            this.field_194332_c = llllllllllllllIllIIlIIIIlIIIlIlI;
            this.field_194333_d = llllllllllllllIllIIlIIIIlIIIlIIl;
            this.field_194334_e = llllllllllllllIllIIlIIIIlIIIlIII;
            this.field_194337_h = llllllllllllllIllIIlIIIIlIIIlIlI.openContainer.inventorySlots;
            final Container llllllllllllllIllIIlIIIIlIIIllII = llllllllllllllIllIIlIIIIlIIIlIlI.openContainer;
            this.field_194335_f = null;
            this.field_194336_g = null;
            if (llllllllllllllIllIIlIIIIlIIIllII instanceof ContainerWorkbench) {
                this.field_194335_f = ((ContainerWorkbench)llllllllllllllIllIIlIIIIlIIIllII).craftResult;
                this.field_194336_g = ((ContainerWorkbench)llllllllllllllIllIIlIIIIlIIIllII).craftMatrix;
            }
            else if (llllllllllllllIllIIlIIIIlIIIllII instanceof ContainerPlayer) {
                this.field_194335_f = ((ContainerPlayer)llllllllllllllIllIIlIIIIlIIIllII).craftResult;
                this.field_194336_g = ((ContainerPlayer)llllllllllllllIllIIlIIIIlIIIllII).craftMatrix;
            }
            if (this.field_194335_f != null && this.field_194336_g != null && (this.func_194328_c() || llllllllllllllIllIIlIIIIlIIIlIlI.isCreative())) {
                this.field_194331_b.func_194119_a();
                llllllllllllllIllIIlIIIIlIIIlIlI.inventory.func_194016_a(this.field_194331_b, false);
                this.field_194336_g.func_194018_a(this.field_194331_b);
                if (this.field_194331_b.func_194116_a(llllllllllllllIllIIlIIIIlIIIlIIl, null)) {
                    this.func_194329_b();
                }
                else {
                    this.func_194326_a();
                    llllllllllllllIllIIlIIIIlIIIlIlI.connection.sendPacket(new SPacketPlaceGhostRecipe(llllllllllllllIllIIlIIIIlIIIlIlI.openContainer.windowId, llllllllllllllIllIIlIIIIlIIIlIIl));
                }
                llllllllllllllIllIIlIIIIlIIIlIlI.inventory.markDirty();
            }
        }
    }
    
    private void func_194323_a(final int llllllllllllllIllIIlIIIIIIllIlll, final IntList llllllllllllllIllIIlIIIIIIlIlIIl) {
        int llllllllllllllIllIIlIIIIIIllIlIl = this.field_194336_g.getWidth();
        int llllllllllllllIllIIlIIIIIIllIlII = this.field_194336_g.getHeight();
        if (this.field_194333_d instanceof ShapedRecipes) {
            final ShapedRecipes llllllllllllllIllIIlIIIIIIllIIll = (ShapedRecipes)this.field_194333_d;
            llllllllllllllIllIIlIIIIIIllIlIl = llllllllllllllIllIIlIIIIIIllIIll.func_192403_f();
            llllllllllllllIllIIlIIIIIIllIlII = llllllllllllllIllIIlIIIIIIllIIll.func_192404_g();
        }
        int llllllllllllllIllIIlIIIIIIllIIlI = 1;
        final Iterator<Integer> llllllllllllllIllIIlIIIIIIllIIIl = (Iterator<Integer>)llllllllllllllIllIIlIIIIIIlIlIIl.iterator();
        for (int llllllllllllllIllIIlIIIIIIllIIII = 0; llllllllllllllIllIIlIIIIIIllIIII < this.field_194336_g.getWidth() && llllllllllllllIllIIlIIIIIIllIlII != llllllllllllllIllIIlIIIIIIllIIII; ++llllllllllllllIllIIlIIIIIIllIIII) {
            for (int llllllllllllllIllIIlIIIIIIlIllll = 0; llllllllllllllIllIIlIIIIIIlIllll < this.field_194336_g.getHeight(); ++llllllllllllllIllIIlIIIIIIlIllll) {
                if (llllllllllllllIllIIlIIIIIIllIlIl == llllllllllllllIllIIlIIIIIIlIllll || !llllllllllllllIllIIlIIIIIIllIIIl.hasNext()) {
                    llllllllllllllIllIIlIIIIIIllIIlI += this.field_194336_g.getWidth() - llllllllllllllIllIIlIIIIIIlIllll;
                    break;
                }
                final Slot llllllllllllllIllIIlIIIIIIlIlllI = this.field_194337_h.get(llllllllllllllIllIIlIIIIIIllIIlI);
                final ItemStack llllllllllllllIllIIlIIIIIIlIllIl = RecipeItemHelper.func_194115_b(llllllllllllllIllIIlIIIIIIllIIIl.next());
                if (llllllllllllllIllIIlIIIIIIlIllIl.func_190926_b()) {
                    ++llllllllllllllIllIIlIIIIIIllIIlI;
                }
                else {
                    for (int llllllllllllllIllIIlIIIIIIlIllII = 0; llllllllllllllIllIIlIIIIIIlIllII < llllllllllllllIllIIlIIIIIIllIlll; ++llllllllllllllIllIIlIIIIIIlIllII) {
                        this.func_194325_a(llllllllllllllIllIIlIIIIIIlIlllI, llllllllllllllIllIIlIIIIIIlIllIl);
                    }
                    ++llllllllllllllIllIIlIIIIIIllIIlI;
                }
            }
            if (!llllllllllllllIllIIlIIIIIIllIIIl.hasNext()) {
                break;
            }
        }
    }
    
    public ServerRecipeBookHelper() {
        this.field_194330_a = LogManager.getLogger();
        this.field_194331_b = new RecipeItemHelper();
    }
    
    private void func_194325_a(final Slot llllllllllllllIllIIlIIIIIIIlIIlI, final ItemStack llllllllllllllIllIIlIIIIIIIlIlll) {
        final InventoryPlayer llllllllllllllIllIIlIIIIIIIlIllI = this.field_194332_c.inventory;
        final int llllllllllllllIllIIlIIIIIIIlIlIl = llllllllllllllIllIIlIIIIIIIlIllI.func_194014_c(llllllllllllllIllIIlIIIIIIIlIlll);
        if (llllllllllllllIllIIlIIIIIIIlIlIl != -1) {
            final ItemStack llllllllllllllIllIIlIIIIIIIlIlII = llllllllllllllIllIIlIIIIIIIlIllI.getStackInSlot(llllllllllllllIllIIlIIIIIIIlIlIl).copy();
            if (!llllllllllllllIllIIlIIIIIIIlIlII.func_190926_b()) {
                if (llllllllllllllIllIIlIIIIIIIlIlII.func_190916_E() > 1) {
                    llllllllllllllIllIIlIIIIIIIlIllI.decrStackSize(llllllllllllllIllIIlIIIIIIIlIlIl, 1);
                }
                else {
                    llllllllllllllIllIIlIIIIIIIlIllI.removeStackFromSlot(llllllllllllllIllIIlIIIIIIIlIlIl);
                }
                llllllllllllllIllIIlIIIIIIIlIlII.func_190920_e(1);
                if (llllllllllllllIllIIlIIIIIIIlIIlI.getStack().func_190926_b()) {
                    llllllllllllllIllIIlIIIIIIIlIIlI.putStack(llllllllllllllIllIIlIIIIIIIlIlII);
                }
                else {
                    llllllllllllllIllIIlIIIIIIIlIIlI.getStack().func_190917_f(1);
                }
            }
        }
    }
}
