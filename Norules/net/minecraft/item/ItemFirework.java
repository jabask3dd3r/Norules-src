package net.minecraft.item;

import net.minecraft.world.*;
import javax.annotation.*;
import net.minecraft.client.util.*;
import net.minecraft.util.text.translation.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class ItemFirework extends Item
{
    @Override
    public void addInformation(final ItemStack llllllllllllllIlllIIIIIlIIIIIIIl, @Nullable final World llllllllllllllIlllIIIIIlIIIIIIII, final List<String> llllllllllllllIlllIIIIIIllllIllI, final ITooltipFlag llllllllllllllIlllIIIIIIlllllllI) {
        final NBTTagCompound llllllllllllllIlllIIIIIIllllllIl = llllllllllllllIlllIIIIIlIIIIIIIl.getSubCompound("Fireworks");
        if (llllllllllllllIlllIIIIIIllllllIl != null) {
            if (llllllllllllllIlllIIIIIIllllllIl.hasKey("Flight", 99)) {
                llllllllllllllIlllIIIIIIllllIllI.add(String.valueOf(new StringBuilder(String.valueOf(I18n.translateToLocal("item.fireworks.flight"))).append(" ").append(llllllllllllllIlllIIIIIIllllllIl.getByte("Flight"))));
            }
            final NBTTagList llllllllllllllIlllIIIIIIllllllII = llllllllllllllIlllIIIIIIllllllIl.getTagList("Explosions", 10);
            if (!llllllllllllllIlllIIIIIIllllllII.hasNoTags()) {
                for (int llllllllllllllIlllIIIIIIlllllIll = 0; llllllllllllllIlllIIIIIIlllllIll < llllllllllllllIlllIIIIIIllllllII.tagCount(); ++llllllllllllllIlllIIIIIIlllllIll) {
                    final NBTTagCompound llllllllllllllIlllIIIIIIlllllIlI = llllllllllllllIlllIIIIIIllllllII.getCompoundTagAt(llllllllllllllIlllIIIIIIlllllIll);
                    final List<String> llllllllllllllIlllIIIIIIlllllIIl = (List<String>)Lists.newArrayList();
                    ItemFireworkCharge.addExplosionInfo(llllllllllllllIlllIIIIIIlllllIlI, llllllllllllllIlllIIIIIIlllllIIl);
                    if (!llllllllllllllIlllIIIIIIlllllIIl.isEmpty()) {
                        for (int llllllllllllllIlllIIIIIIlllllIII = 1; llllllllllllllIlllIIIIIIlllllIII < llllllllllllllIlllIIIIIIlllllIIl.size(); ++llllllllllllllIlllIIIIIIlllllIII) {
                            llllllllllllllIlllIIIIIIlllllIIl.set(llllllllllllllIlllIIIIIIlllllIII, String.valueOf(new StringBuilder("  ").append(llllllllllllllIlllIIIIIIlllllIIl.get(llllllllllllllIlllIIIIIIlllllIII))));
                        }
                        llllllllllllllIlllIIIIIIllllIllI.addAll(llllllllllllllIlllIIIIIIlllllIIl);
                    }
                }
            }
        }
    }
    
    @Override
    public EnumActionResult onItemUse(final EntityPlayer llllllllllllllIlllIIIIIlIIlIIIll, final World llllllllllllllIlllIIIIIlIIlIIIlI, final BlockPos llllllllllllllIlllIIIIIlIIlIlIll, final EnumHand llllllllllllllIlllIIIIIlIIlIIIII, final EnumFacing llllllllllllllIlllIIIIIlIIlIlIIl, final float llllllllllllllIlllIIIIIlIIlIlIII, final float llllllllllllllIlllIIIIIlIIlIIlll, final float llllllllllllllIlllIIIIIlIIIlllIl) {
        if (!llllllllllllllIlllIIIIIlIIlIIIlI.isRemote) {
            final ItemStack llllllllllllllIlllIIIIIlIIlIIlIl = llllllllllllllIlllIIIIIlIIlIIIll.getHeldItem(llllllllllllllIlllIIIIIlIIlIIIII);
            final EntityFireworkRocket llllllllllllllIlllIIIIIlIIlIIlII = new EntityFireworkRocket(llllllllllllllIlllIIIIIlIIlIIIlI, llllllllllllllIlllIIIIIlIIlIlIll.getX() + llllllllllllllIlllIIIIIlIIlIlIII, llllllllllllllIlllIIIIIlIIlIlIll.getY() + llllllllllllllIlllIIIIIlIIlIIlll, llllllllllllllIlllIIIIIlIIlIlIll.getZ() + llllllllllllllIlllIIIIIlIIIlllIl, llllllllllllllIlllIIIIIlIIlIIlIl);
            llllllllllllllIlllIIIIIlIIlIIIlI.spawnEntityInWorld(llllllllllllllIlllIIIIIlIIlIIlII);
            if (!llllllllllllllIlllIIIIIlIIlIIIll.capabilities.isCreativeMode) {
                llllllllllllllIlllIIIIIlIIlIIlIl.func_190918_g(1);
            }
        }
        return EnumActionResult.SUCCESS;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World llllllllllllllIlllIIIIIlIIIIllll, final EntityPlayer llllllllllllllIlllIIIIIlIIIIlllI, final EnumHand llllllllllllllIlllIIIIIlIIIIllIl) {
        if (llllllllllllllIlllIIIIIlIIIIlllI.isElytraFlying()) {
            final ItemStack llllllllllllllIlllIIIIIlIIIlIIIl = llllllllllllllIlllIIIIIlIIIIlllI.getHeldItem(llllllllllllllIlllIIIIIlIIIIllIl);
            if (!llllllllllllllIlllIIIIIlIIIIllll.isRemote) {
                final EntityFireworkRocket llllllllllllllIlllIIIIIlIIIlIIII = new EntityFireworkRocket(llllllllllllllIlllIIIIIlIIIIllll, llllllllllllllIlllIIIIIlIIIlIIIl, llllllllllllllIlllIIIIIlIIIIlllI);
                llllllllllllllIlllIIIIIlIIIIllll.spawnEntityInWorld(llllllllllllllIlllIIIIIlIIIlIIII);
                if (!llllllllllllllIlllIIIIIlIIIIlllI.capabilities.isCreativeMode) {
                    llllllllllllllIlllIIIIIlIIIlIIIl.func_190918_g(1);
                }
            }
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, llllllllllllllIlllIIIIIlIIIIlllI.getHeldItem(llllllllllllllIlllIIIIIlIIIIllIl));
        }
        return new ActionResult<ItemStack>(EnumActionResult.PASS, llllllllllllllIlllIIIIIlIIIIlllI.getHeldItem(llllllllllllllIlllIIIIIlIIIIllIl));
    }
}
