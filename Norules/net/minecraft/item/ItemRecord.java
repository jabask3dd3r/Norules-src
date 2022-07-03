package net.minecraft.item;

import com.google.common.collect.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.stats.*;
import net.minecraft.block.state.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.client.util.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.creativetab.*;

public class ItemRecord extends Item
{
    private static final /* synthetic */ Map<SoundEvent, ItemRecord> RECORDS;
    private final /* synthetic */ SoundEvent sound;
    private final /* synthetic */ String displayName;
    
    static {
        RECORDS = Maps.newHashMap();
    }
    
    @Override
    public EnumActionResult onItemUse(final EntityPlayer lllllllllllllIIIllIIlIllIIlIlIll, final World lllllllllllllIIIllIIlIllIIlIlIlI, final BlockPos lllllllllllllIIIllIIlIllIIlIlIIl, final EnumHand lllllllllllllIIIllIIlIllIIlIlIII, final EnumFacing lllllllllllllIIIllIIlIllIIllIIlI, final float lllllllllllllIIIllIIlIllIIllIIIl, final float lllllllllllllIIIllIIlIllIIllIIII, final float lllllllllllllIIIllIIlIllIIlIllll) {
        final IBlockState lllllllllllllIIIllIIlIllIIlIlllI = lllllllllllllIIIllIIlIllIIlIlIlI.getBlockState(lllllllllllllIIIllIIlIllIIlIlIIl);
        if (lllllllllllllIIIllIIlIllIIlIlllI.getBlock() == Blocks.JUKEBOX && !lllllllllllllIIIllIIlIllIIlIlllI.getValue((IProperty<Boolean>)BlockJukebox.HAS_RECORD)) {
            if (!lllllllllllllIIIllIIlIllIIlIlIlI.isRemote) {
                final ItemStack lllllllllllllIIIllIIlIllIIlIllIl = lllllllllllllIIIllIIlIllIIlIlIll.getHeldItem(lllllllllllllIIIllIIlIllIIlIlIII);
                ((BlockJukebox)Blocks.JUKEBOX).insertRecord(lllllllllllllIIIllIIlIllIIlIlIlI, lllllllllllllIIIllIIlIllIIlIlIIl, lllllllllllllIIIllIIlIllIIlIlllI, lllllllllllllIIIllIIlIllIIlIllIl);
                lllllllllllllIIIllIIlIllIIlIlIlI.playEvent(null, 1010, lllllllllllllIIIllIIlIllIIlIlIIl, Item.getIdFromItem(this));
                lllllllllllllIIIllIIlIllIIlIllIl.func_190918_g(1);
                lllllllllllllIIIllIIlIllIIlIlIll.addStat(StatList.RECORD_PLAYED);
            }
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }
    
    @Override
    public EnumRarity getRarity(final ItemStack lllllllllllllIIIllIIlIllIIIllIII) {
        return EnumRarity.RARE;
    }
    
    @Override
    public void addInformation(final ItemStack lllllllllllllIIIllIIlIllIIlIIIlI, @Nullable final World lllllllllllllIIIllIIlIllIIlIIIIl, final List<String> lllllllllllllIIIllIIlIllIIlIIIII, final ITooltipFlag lllllllllllllIIIllIIlIllIIIlllll) {
        lllllllllllllIIIllIIlIllIIlIIIII.add(this.getRecordNameLocal());
    }
    
    public SoundEvent getSound() {
        return this.sound;
    }
    
    public String getRecordNameLocal() {
        return I18n.translateToLocal(this.displayName);
    }
    
    @Nullable
    public static ItemRecord getBySound(final SoundEvent lllllllllllllIIIllIIlIllIIIlIllI) {
        return ItemRecord.RECORDS.get(lllllllllllllIIIllIIlIllIIIlIllI);
    }
    
    protected ItemRecord(final String lllllllllllllIIIllIIlIllIlIIIIII, final SoundEvent lllllllllllllIIIllIIlIllIIllllll) {
        this.displayName = String.valueOf(new StringBuilder("item.record.").append(lllllllllllllIIIllIIlIllIlIIIIII).append(".desc"));
        this.sound = lllllllllllllIIIllIIlIllIIllllll;
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.MISC);
        ItemRecord.RECORDS.put(this.sound, this);
    }
}
