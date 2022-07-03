package de.gerrygames.viarewind.storage;

public class BlockState
{
    public static int stateToRaw(final int lllllllllllllIlllIIIIllIlIIlIlll, final int lllllllllllllIlllIIIIllIlIIllIII) {
        return lllllllllllllIlllIIIIllIlIIlIlll << 4 | (lllllllllllllIlllIIIIllIlIIllIII & 0xF);
    }
    
    public static int extractId(final int lllllllllllllIlllIIIIllIlIlIIIII) {
        return lllllllllllllIlllIIIIllIlIlIIIII >> 4;
    }
    
    public static int extractData(final int lllllllllllllIlllIIIIllIlIIlllII) {
        return lllllllllllllIlllIIIIllIlIIlllII & 0xF;
    }
}
