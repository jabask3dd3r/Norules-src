package net.minecraft.world;

import javax.annotation.concurrent.*;
import net.minecraft.nbt.*;

@Immutable
public class LockCode
{
    public static final /* synthetic */ LockCode EMPTY_CODE;
    private final /* synthetic */ String lock;
    
    public static LockCode fromNBT(final NBTTagCompound llllllllllllIlllllIlIIIlllIIIlII) {
        if (llllllllllllIlllllIlIIIlllIIIlII.hasKey("Lock", 8)) {
            final String llllllllllllIlllllIlIIIlllIIIIll = llllllllllllIlllllIlIIIlllIIIlII.getString("Lock");
            return new LockCode(llllllllllllIlllllIlIIIlllIIIIll);
        }
        return LockCode.EMPTY_CODE;
    }
    
    static {
        EMPTY_CODE = new LockCode("");
    }
    
    public void toNBT(final NBTTagCompound llllllllllllIlllllIlIIIlllIIIlll) {
        llllllllllllIlllllIlIIIlllIIIlll.setString("Lock", this.lock);
    }
    
    public LockCode(final String llllllllllllIlllllIlIIIlllIlIlIl) {
        this.lock = llllllllllllIlllllIlIIIlllIlIlIl;
    }
    
    public boolean isEmpty() {
        return this.lock == null || this.lock.isEmpty();
    }
    
    public String getLock() {
        return this.lock;
    }
}
