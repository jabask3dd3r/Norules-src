package net.minecraft.tileentity;

import net.minecraft.world.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.network.play.server.*;
import javax.annotation.*;
import net.minecraft.util.text.*;

public class TileEntityBanner extends TileEntity implements IWorldNameable
{
    private /* synthetic */ EnumDyeColor baseColor;
    private /* synthetic */ String field_190617_a;
    private /* synthetic */ List<BannerPattern> patternList;
    private /* synthetic */ NBTTagList patterns;
    private /* synthetic */ boolean patternDataSet;
    private /* synthetic */ List<EnumDyeColor> colorList;
    private /* synthetic */ String patternResourceLocation;
    
    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }
    
    private void initializeBannerData() {
        if (this.patternList == null || this.colorList == null || this.patternResourceLocation == null) {
            if (!this.patternDataSet) {
                this.patternResourceLocation = "";
            }
            else {
                this.patternList = (List<BannerPattern>)Lists.newArrayList();
                this.colorList = (List<EnumDyeColor>)Lists.newArrayList();
                this.patternList.add(BannerPattern.BASE);
                this.colorList.add(this.baseColor);
                this.patternResourceLocation = String.valueOf(new StringBuilder("b").append(this.baseColor.getDyeDamage()));
                if (this.patterns != null) {
                    for (int lllllllllllllIIlIIlIlIlIIIIlIIll = 0; lllllllllllllIIlIIlIlIlIIIIlIIll < this.patterns.tagCount(); ++lllllllllllllIIlIIlIlIlIIIIlIIll) {
                        final NBTTagCompound lllllllllllllIIlIIlIlIlIIIIlIIlI = this.patterns.getCompoundTagAt(lllllllllllllIIlIIlIlIlIIIIlIIll);
                        final BannerPattern lllllllllllllIIlIIlIlIlIIIIlIIIl = BannerPattern.func_190994_a(lllllllllllllIIlIIlIlIlIIIIlIIlI.getString("Pattern"));
                        if (lllllllllllllIIlIIlIlIlIIIIlIIIl != null) {
                            this.patternList.add(lllllllllllllIIlIIlIlIlIIIIlIIIl);
                            final int lllllllllllllIIlIIlIlIlIIIIlIIII = lllllllllllllIIlIIlIlIlIIIIlIIlI.getInteger("Color");
                            this.colorList.add(EnumDyeColor.byDyeDamage(lllllllllllllIIlIIlIlIlIIIIlIIII));
                            this.patternResourceLocation = String.valueOf(new StringBuilder(String.valueOf(this.patternResourceLocation)).append(lllllllllllllIIlIIlIlIlIIIIlIIIl.func_190993_b()).append(lllllllllllllIIlIIlIlIlIIIIlIIII));
                        }
                    }
                }
            }
        }
    }
    
    public ItemStack func_190615_l() {
        final ItemStack lllllllllllllIIlIIlIlIIllllllllI = ItemBanner.func_190910_a(this.baseColor, this.patterns);
        if (this.hasCustomName()) {
            lllllllllllllIIlIIlIlIIllllllllI.setStackDisplayName(this.getName());
        }
        return lllllllllllllIIlIIlIlIIllllllllI;
    }
    
    @Override
    public boolean hasCustomName() {
        return this.field_190617_a != null && !this.field_190617_a.isEmpty();
    }
    
    public static void removeBannerData(final ItemStack lllllllllllllIIlIIlIlIlIIIIIIlll) {
        final NBTTagCompound lllllllllllllIIlIIlIlIlIIIIIIllI = lllllllllllllIIlIIlIlIlIIIIIIlll.getSubCompound("BlockEntityTag");
        if (lllllllllllllIIlIIlIlIlIIIIIIllI != null && lllllllllllllIIlIIlIlIlIIIIIIllI.hasKey("Patterns", 9)) {
            final NBTTagList lllllllllllllIIlIIlIlIlIIIIIIlIl = lllllllllllllIIlIIlIlIlIIIIIIllI.getTagList("Patterns", 10);
            if (!lllllllllllllIIlIIlIlIlIIIIIIlIl.hasNoTags()) {
                lllllllllllllIIlIIlIlIlIIIIIIlIl.removeTag(lllllllllllllIIlIIlIlIlIIIIIIlIl.tagCount() - 1);
                if (lllllllllllllIIlIIlIlIlIIIIIIlIl.hasNoTags()) {
                    lllllllllllllIIlIIlIlIlIIIIIIlll.getTagCompound().removeTag("BlockEntityTag");
                    if (lllllllllllllIIlIIlIlIlIIIIIIlll.getTagCompound().hasNoTags()) {
                        lllllllllllllIIlIIlIlIlIIIIIIlll.setTagCompound(null);
                    }
                }
            }
        }
    }
    
    public String getPatternResourceLocation() {
        this.initializeBannerData();
        return this.patternResourceLocation;
    }
    
    public List<EnumDyeColor> getColorList() {
        this.initializeBannerData();
        return this.colorList;
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllllIIlIIlIlIlIIIllIlll) {
        super.writeToNBT(lllllllllllllIIlIIlIlIlIIIllIlll);
        lllllllllllllIIlIIlIlIlIIIllIlll.setInteger("Base", this.baseColor.getDyeDamage());
        if (this.patterns != null) {
            lllllllllllllIIlIIlIlIlIIIllIlll.setTag("Patterns", this.patterns);
        }
        if (this.hasCustomName()) {
            lllllllllllllIIlIIlIlIlIIIllIlll.setString("CustomName", this.field_190617_a);
        }
        return lllllllllllllIIlIIlIlIlIIIllIlll;
    }
    
    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 6, this.getUpdateTag());
    }
    
    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]);
    }
    
    public TileEntityBanner() {
        this.baseColor = EnumDyeColor.BLACK;
    }
    
    public static EnumDyeColor func_190616_d(final ItemStack lllllllllllllIIlIIlIlIIlllllIlll) {
        final NBTTagCompound lllllllllllllIIlIIlIlIIllllllIII = lllllllllllllIIlIIlIlIIlllllIlll.getSubCompound("BlockEntityTag");
        return (lllllllllllllIIlIIlIlIIllllllIII != null && lllllllllllllIIlIIlIlIIllllllIII.hasKey("Base")) ? EnumDyeColor.byDyeDamage(lllllllllllllIIlIIlIlIIllllllIII.getInteger("Base")) : EnumDyeColor.BLACK;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllllIIlIIlIlIlIIIlIllll) {
        super.readFromNBT(lllllllllllllIIlIIlIlIlIIIlIllll);
        if (lllllllllllllIIlIIlIlIlIIIlIllll.hasKey("CustomName", 8)) {
            this.field_190617_a = lllllllllllllIIlIIlIlIlIIIlIllll.getString("CustomName");
        }
        this.baseColor = EnumDyeColor.byDyeDamage(lllllllllllllIIlIIlIlIlIIIlIllll.getInteger("Base"));
        this.patterns = lllllllllllllIIlIIlIlIlIIIlIllll.getTagList("Patterns", 10);
        this.patternList = null;
        this.colorList = null;
        this.patternResourceLocation = null;
        this.patternDataSet = true;
    }
    
    public List<BannerPattern> getPatternList() {
        this.initializeBannerData();
        return this.patternList;
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.field_190617_a : "banner";
    }
    
    public void setItemValues(final ItemStack lllllllllllllIIlIIlIlIlIIlIIlIlI, final boolean lllllllllllllIIlIIlIlIlIIlIIlIIl) {
        this.patterns = null;
        final NBTTagCompound lllllllllllllIIlIIlIlIlIIlIIlIII = lllllllllllllIIlIIlIlIlIIlIIlIlI.getSubCompound("BlockEntityTag");
        if (lllllllllllllIIlIIlIlIlIIlIIlIII != null && lllllllllllllIIlIIlIlIlIIlIIlIII.hasKey("Patterns", 9)) {
            this.patterns = lllllllllllllIIlIIlIlIlIIlIIlIII.getTagList("Patterns", 10).copy();
        }
        this.baseColor = (lllllllllllllIIlIIlIlIlIIlIIlIIl ? func_190616_d(lllllllllllllIIlIIlIlIlIIlIIlIlI) : ItemBanner.getBaseColor(lllllllllllllIIlIIlIlIlIIlIIlIlI));
        this.patternList = null;
        this.colorList = null;
        this.patternResourceLocation = "";
        this.patternDataSet = true;
        this.field_190617_a = (lllllllllllllIIlIIlIlIlIIlIIlIlI.hasDisplayName() ? lllllllllllllIIlIIlIlIlIIlIIlIlI.getDisplayName() : null);
    }
    
    public static int getPatterns(final ItemStack lllllllllllllIIlIIlIlIlIIIlIIlII) {
        final NBTTagCompound lllllllllllllIIlIIlIlIlIIIlIIlIl = lllllllllllllIIlIIlIlIlIIIlIIlII.getSubCompound("BlockEntityTag");
        return (lllllllllllllIIlIIlIlIlIIIlIIlIl != null && lllllllllllllIIlIIlIlIlIIIlIIlIl.hasKey("Patterns")) ? lllllllllllllIIlIIlIlIlIIIlIIlIl.getTagList("Patterns", 10).tagCount() : 0;
    }
}
