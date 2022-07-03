package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;
import java.util.*;

public class OptionsLowerCaseLanguage implements IFixableData
{
    @Override
    public int getFixVersion() {
        return 816;
    }
    
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound llllllllllllllIllIIlIlIIIIlllIIl) {
        if (llllllllllllllIllIIlIlIIIIlllIIl.hasKey("lang", 8)) {
            llllllllllllllIllIIlIlIIIIlllIIl.setString("lang", llllllllllllllIllIIlIlIIIIlllIIl.getString("lang").toLowerCase(Locale.ROOT));
        }
        return llllllllllllllIllIIlIlIIIIlllIIl;
    }
}
