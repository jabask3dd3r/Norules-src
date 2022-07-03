package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;

public class SkeletonSplit implements IFixableData
{
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound llllllllllllllllIlIIIIIIIIllIlII) {
        final String llllllllllllllllIlIIIIIIIIllIllI = llllllllllllllllIlIIIIIIIIllIlII.getString("id");
        if ("Skeleton".equals(llllllllllllllllIlIIIIIIIIllIllI)) {
            final int llllllllllllllllIlIIIIIIIIllIlIl = llllllllllllllllIlIIIIIIIIllIlII.getInteger("SkeletonType");
            if (llllllllllllllllIlIIIIIIIIllIlIl == 1) {
                llllllllllllllllIlIIIIIIIIllIlII.setString("id", "WitherSkeleton");
            }
            else if (llllllllllllllllIlIIIIIIIIllIlIl == 2) {
                llllllllllllllllIlIIIIIIIIllIlII.setString("id", "Stray");
            }
            llllllllllllllllIlIIIIIIIIllIlII.removeTag("SkeletonType");
        }
        return llllllllllllllllIlIIIIIIIIllIlII;
    }
    
    @Override
    public int getFixVersion() {
        return 701;
    }
}
