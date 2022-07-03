package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;

public class ShulkerBoxItemColor implements IFixableData
{
    public static final /* synthetic */ String[] field_191278_a;
    
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound llllllllllllllIlIlIllIlIllllIIII) {
        if ("minecraft:shulker_box".equals(llllllllllllllIlIlIllIlIllllIIII.getString("id")) && llllllllllllllIlIlIllIlIllllIIII.hasKey("tag", 10)) {
            final NBTTagCompound llllllllllllllIlIlIllIlIllllIIll = llllllllllllllIlIlIllIlIllllIIII.getCompoundTag("tag");
            if (llllllllllllllIlIlIllIlIllllIIll.hasKey("BlockEntityTag", 10)) {
                final NBTTagCompound llllllllllllllIlIlIllIlIllllIIlI = llllllllllllllIlIlIllIlIllllIIll.getCompoundTag("BlockEntityTag");
                if (llllllllllllllIlIlIllIlIllllIIlI.getTagList("Items", 10).hasNoTags()) {
                    llllllllllllllIlIlIllIlIllllIIlI.removeTag("Items");
                }
                final int llllllllllllllIlIlIllIlIllllIIIl = llllllllllllllIlIlIllIlIllllIIlI.getInteger("Color");
                llllllllllllllIlIlIllIlIllllIIlI.removeTag("Color");
                if (llllllllllllllIlIlIllIlIllllIIlI.hasNoTags()) {
                    llllllllllllllIlIlIllIlIllllIIll.removeTag("BlockEntityTag");
                }
                if (llllllllllllllIlIlIllIlIllllIIll.hasNoTags()) {
                    llllllllllllllIlIlIllIlIllllIIII.removeTag("tag");
                }
                llllllllllllllIlIlIllIlIllllIIII.setString("id", ShulkerBoxItemColor.field_191278_a[llllllllllllllIlIlIllIlIllllIIIl % 16]);
            }
        }
        return llllllllllllllIlIlIllIlIllllIIII;
    }
    
    static {
        field_191278_a = new String[] { "minecraft:white_shulker_box", "minecraft:orange_shulker_box", "minecraft:magenta_shulker_box", "minecraft:light_blue_shulker_box", "minecraft:yellow_shulker_box", "minecraft:lime_shulker_box", "minecraft:pink_shulker_box", "minecraft:gray_shulker_box", "minecraft:silver_shulker_box", "minecraft:cyan_shulker_box", "minecraft:purple_shulker_box", "minecraft:blue_shulker_box", "minecraft:brown_shulker_box", "minecraft:green_shulker_box", "minecraft:red_shulker_box", "minecraft:black_shulker_box" };
    }
    
    @Override
    public int getFixVersion() {
        return 813;
    }
}
