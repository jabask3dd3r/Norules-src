package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;

public class ForceVBOOn implements IFixableData
{
    @Override
    public int getFixVersion() {
        return 505;
    }
    
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound llllllllllllllIlIlIlllIllIlIlIll) {
        llllllllllllllIlIlIlllIllIlIlIll.setString("useVbo", "true");
        return llllllllllllllIlIlIlllIllIlIlIll;
    }
}
