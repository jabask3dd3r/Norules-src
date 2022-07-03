package net.minecraft.nbt;

public class NBTException extends Exception
{
    private static String func_193592_a(final String llllllllllllllIlIIIlIllIIIIlIllI, final int llllllllllllllIlIIIlIllIIIIlIlIl) {
        final StringBuilder llllllllllllllIlIIIlIllIIIIllIII = new StringBuilder();
        final int llllllllllllllIlIIIlIllIIIIlIlll = Math.min(llllllllllllllIlIIIlIllIIIIlIllI.length(), llllllllllllllIlIIIlIllIIIIlIlIl);
        if (llllllllllllllIlIIIlIllIIIIlIlll > 35) {
            llllllllllllllIlIIIlIllIIIIllIII.append("...");
        }
        llllllllllllllIlIIIlIllIIIIllIII.append(llllllllllllllIlIIIlIllIIIIlIllI.substring(Math.max(0, llllllllllllllIlIIIlIllIIIIlIlll - 35), llllllllllllllIlIIIlIllIIIIlIlll));
        llllllllllllllIlIIIlIllIIIIllIII.append("<--[HERE]");
        return String.valueOf(llllllllllllllIlIIIlIllIIIIllIII);
    }
    
    public NBTException(final String llllllllllllllIlIIIlIllIIIlIIlIl, final String llllllllllllllIlIIIlIllIIIlIIlII, final int llllllllllllllIlIIIlIllIIIIlllll) {
        super(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIIIlIllIIIlIIlIl)).append(" at: ").append(func_193592_a(llllllllllllllIlIIIlIllIIIlIIlII, llllllllllllllIlIIIlIllIIIIlllll))));
    }
}
