package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;

public class ElderGuardianSplit implements IFixableData
{
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound llllllllllllllIIlIIIlIIllIlllIll) {
        if ("Guardian".equals(llllllllllllllIIlIIIlIIllIlllIll.getString("id"))) {
            if (llllllllllllllIIlIIIlIIllIlllIll.getBoolean("Elder")) {
                llllllllllllllIIlIIIlIIllIlllIll.setString("id", "ElderGuardian");
            }
            llllllllllllllIIlIIIlIIllIlllIll.removeTag("Elder");
        }
        return llllllllllllllIIlIIIlIIllIlllIll;
    }
    
    @Override
    public int getFixVersion() {
        return 700;
    }
}
