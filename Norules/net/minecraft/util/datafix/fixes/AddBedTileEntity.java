package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import org.apache.logging.log4j.*;
import net.minecraft.nbt.*;

public class AddBedTileEntity implements IFixableData
{
    private static final /* synthetic */ Logger field_193842_a;
    
    static {
        field_193842_a = LogManager.getLogger();
    }
    
    @Override
    public int getFixVersion() {
        return 1125;
    }
    
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound lllllllllllllIIllIIlIIlIlIlIIlll) {
        final int lllllllllllllIIllIIlIIlIlIlIIllI = 416;
        try {
            final NBTTagCompound lllllllllllllIIllIIlIIlIlIlIIlIl = lllllllllllllIIllIIlIIlIlIlIIlll.getCompoundTag("Level");
            final int lllllllllllllIIllIIlIIlIlIlIIlII = lllllllllllllIIllIIlIIlIlIlIIlIl.getInteger("xPos");
            final int lllllllllllllIIllIIlIIlIlIlIIIll = lllllllllllllIIllIIlIIlIlIlIIlIl.getInteger("zPos");
            final NBTTagList lllllllllllllIIllIIlIIlIlIlIIIlI = lllllllllllllIIllIIlIIlIlIlIIlIl.getTagList("TileEntities", 10);
            final NBTTagList lllllllllllllIIllIIlIIlIlIlIIIIl = lllllllllllllIIllIIlIIlIlIlIIlIl.getTagList("Sections", 10);
            for (int lllllllllllllIIllIIlIIlIlIlIIIII = 0; lllllllllllllIIllIIlIIlIlIlIIIII < lllllllllllllIIllIIlIIlIlIlIIIIl.tagCount(); ++lllllllllllllIIllIIlIIlIlIlIIIII) {
                final NBTTagCompound lllllllllllllIIllIIlIIlIlIIlllll = lllllllllllllIIllIIlIIlIlIlIIIIl.getCompoundTagAt(lllllllllllllIIllIIlIIlIlIlIIIII);
                final int lllllllllllllIIllIIlIIlIlIIllllI = lllllllllllllIIllIIlIIlIlIIlllll.getByte("Y");
                final byte[] lllllllllllllIIllIIlIIlIlIIlllIl = lllllllllllllIIllIIlIIlIlIIlllll.getByteArray("Blocks");
                for (int lllllllllllllIIllIIlIIlIlIIlllII = 0; lllllllllllllIIllIIlIIlIlIIlllII < lllllllllllllIIllIIlIIlIlIIlllIl.length; ++lllllllllllllIIllIIlIIlIlIIlllII) {
                    if (416 == (lllllllllllllIIllIIlIIlIlIIlllIl[lllllllllllllIIllIIlIIlIlIIlllII] & 0xFF) << 4) {
                        final int lllllllllllllIIllIIlIIlIlIIllIll = lllllllllllllIIllIIlIIlIlIIlllII & 0xF;
                        final int lllllllllllllIIllIIlIIlIlIIllIlI = lllllllllllllIIllIIlIIlIlIIlllII >> 8 & 0xF;
                        final int lllllllllllllIIllIIlIIlIlIIllIIl = lllllllllllllIIllIIlIIlIlIIlllII >> 4 & 0xF;
                        final NBTTagCompound lllllllllllllIIllIIlIIlIlIIllIII = new NBTTagCompound();
                        lllllllllllllIIllIIlIIlIlIIllIII.setString("id", "bed");
                        lllllllllllllIIllIIlIIlIlIIllIII.setInteger("x", lllllllllllllIIllIIlIIlIlIIllIll + (lllllllllllllIIllIIlIIlIlIlIIlII << 4));
                        lllllllllllllIIllIIlIIlIlIIllIII.setInteger("y", lllllllllllllIIllIIlIIlIlIIllIlI + (lllllllllllllIIllIIlIIlIlIIllllI << 4));
                        lllllllllllllIIllIIlIIlIlIIllIII.setInteger("z", lllllllllllllIIllIIlIIlIlIIllIIl + (lllllllllllllIIllIIlIIlIlIlIIIll << 4));
                        lllllllllllllIIllIIlIIlIlIlIIIlI.appendTag(lllllllllllllIIllIIlIIlIlIIllIII);
                    }
                }
            }
        }
        catch (Exception lllllllllllllIIllIIlIIlIlIIlIlll) {
            AddBedTileEntity.field_193842_a.warn("Unable to datafix Bed blocks, level format may be missing tags.");
        }
        return lllllllllllllIIllIIlIIlIlIlIIlll;
    }
}
