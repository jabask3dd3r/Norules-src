package net.minecraft.item;

import net.minecraft.block.*;
import net.minecraft.world.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.client.util.*;

public class ItemAir extends Item
{
    private final /* synthetic */ Block field_190904_a;
    
    @Override
    public void addInformation(final ItemStack lllllllllllllIlIIllIlIlIlIlIIlIl, @Nullable final World lllllllllllllIlIIllIlIlIlIIlllll, final List<String> lllllllllllllIlIIllIlIlIlIIllllI, final ITooltipFlag lllllllllllllIlIIllIlIlIlIlIIIlI) {
        super.addInformation(lllllllllllllIlIIllIlIlIlIlIIlIl, lllllllllllllIlIIllIlIlIlIIlllll, lllllllllllllIlIIllIlIlIlIIllllI, lllllllllllllIlIIllIlIlIlIlIIIlI);
        this.field_190904_a.func_190948_a(lllllllllllllIlIIllIlIlIlIlIIlIl, lllllllllllllIlIIllIlIlIlIIlllll, lllllllllllllIlIIllIlIlIlIIllllI, lllllllllllllIlIIllIlIlIlIlIIIlI);
    }
    
    @Override
    public String getUnlocalizedName() {
        return this.field_190904_a.getUnlocalizedName();
    }
    
    public ItemAir(final Block lllllllllllllIlIIllIlIlIlIllIIll) {
        this.field_190904_a = lllllllllllllIlIIllIlIlIlIllIIll;
    }
    
    @Override
    public String getUnlocalizedName(final ItemStack lllllllllllllIlIIllIlIlIlIllIIII) {
        return this.field_190904_a.getUnlocalizedName();
    }
}
