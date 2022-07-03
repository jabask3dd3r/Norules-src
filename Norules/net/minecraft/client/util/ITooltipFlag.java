package net.minecraft.client.util;

public interface ITooltipFlag
{
    boolean func_194127_a();
    
    public enum TooltipFlags implements ITooltipFlag
    {
        ADVANCED("ADVANCED", 1, true);
        
        final /* synthetic */ boolean field_194131_c;
        
        NORMAL("NORMAL", 0, false);
        
        @Override
        public boolean func_194127_a() {
            return this.field_194131_c;
        }
        
        private TooltipFlags(final String lllllllllllllIlIIIlllllllllIlllI, final int lllllllllllllIlIIIlllllllllIllIl, final boolean lllllllllllllIlIIIllllllllllIIII) {
            this.field_194131_c = lllllllllllllIlIIIllllllllllIIII;
        }
    }
}
