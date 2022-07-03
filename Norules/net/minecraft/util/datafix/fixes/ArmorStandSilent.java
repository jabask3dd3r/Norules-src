package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;

public class ArmorStandSilent implements IFixableData
{
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound llllllllllllllIIIIIlIllllIllIllI) {
        if ("ArmorStand".equals(llllllllllllllIIIIIlIllllIllIllI.getString("id")) && llllllllllllllIIIIIlIllllIllIllI.getBoolean("Silent") && !llllllllllllllIIIIIlIllllIllIllI.getBoolean("Marker")) {
            llllllllllllllIIIIIlIllllIllIllI.removeTag("Silent");
        }
        return llllllllllllllIIIIIlIllllIllIllI;
    }
    
    @Override
    public int getFixVersion() {
        return 147;
    }
}
