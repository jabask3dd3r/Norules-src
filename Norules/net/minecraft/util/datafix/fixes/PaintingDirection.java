package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;

public class PaintingDirection implements IFixableData
{
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound llllllllllllllIIlllllIIIIIlIIllI) {
        final String llllllllllllllIIlllllIIIIIlIIlII = llllllllllllllIIlllllIIIIIlIIllI.getString("id");
        final boolean llllllllllllllIIlllllIIIIIlIIIlI = "Painting".equals(llllllllllllllIIlllllIIIIIlIIlII);
        final boolean llllllllllllllIIlllllIIIIIIlllll = "ItemFrame".equals(llllllllllllllIIlllllIIIIIlIIlII);
        if ((llllllllllllllIIlllllIIIIIlIIIlI || llllllllllllllIIlllllIIIIIIlllll) && !llllllllllllllIIlllllIIIIIlIIllI.hasKey("Facing", 99)) {
            EnumFacing llllllllllllllIIlllllIIIIIIllIll = null;
            if (llllllllllllllIIlllllIIIIIlIIllI.hasKey("Direction", 99)) {
                final EnumFacing llllllllllllllIIlllllIIIIIIlllIl = EnumFacing.getHorizontal(llllllllllllllIIlllllIIIIIlIIllI.getByte("Direction"));
                llllllllllllllIIlllllIIIIIlIIllI.setInteger("TileX", llllllllllllllIIlllllIIIIIlIIllI.getInteger("TileX") + llllllllllllllIIlllllIIIIIIlllIl.getFrontOffsetX());
                llllllllllllllIIlllllIIIIIlIIllI.setInteger("TileY", llllllllllllllIIlllllIIIIIlIIllI.getInteger("TileY") + llllllllllllllIIlllllIIIIIIlllIl.getFrontOffsetY());
                llllllllllllllIIlllllIIIIIlIIllI.setInteger("TileZ", llllllllllllllIIlllllIIIIIlIIllI.getInteger("TileZ") + llllllllllllllIIlllllIIIIIIlllIl.getFrontOffsetZ());
                llllllllllllllIIlllllIIIIIlIIllI.removeTag("Direction");
                if (llllllllllllllIIlllllIIIIIIlllll && llllllllllllllIIlllllIIIIIlIIllI.hasKey("ItemRotation", 99)) {
                    llllllllllllllIIlllllIIIIIlIIllI.setByte("ItemRotation", (byte)(llllllllllllllIIlllllIIIIIlIIllI.getByte("ItemRotation") * 2));
                }
            }
            else {
                llllllllllllllIIlllllIIIIIIllIll = EnumFacing.getHorizontal(llllllllllllllIIlllllIIIIIlIIllI.getByte("Dir"));
                llllllllllllllIIlllllIIIIIlIIllI.removeTag("Dir");
            }
            llllllllllllllIIlllllIIIIIlIIllI.setByte("Facing", (byte)llllllllllllllIIlllllIIIIIIllIll.getHorizontalIndex());
        }
        return llllllllllllllIIlllllIIIIIlIIllI;
    }
    
    @Override
    public int getFixVersion() {
        return 111;
    }
}
