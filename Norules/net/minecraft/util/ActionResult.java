package net.minecraft.util;

public class ActionResult<T>
{
    private final /* synthetic */ T result;
    private final /* synthetic */ EnumActionResult type;
    
    public EnumActionResult getType() {
        return this.type;
    }
    
    public T getResult() {
        return this.result;
    }
    
    public ActionResult(final EnumActionResult lllllllllllllIllIIIlllIlIlIllIIl, final T lllllllllllllIllIIIlllIlIlIllIII) {
        this.type = lllllllllllllIllIIIlllIlIlIllIIl;
        this.result = lllllllllllllIllIIIlllIlIlIllIII;
    }
}
