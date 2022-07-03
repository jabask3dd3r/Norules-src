package shadersmod.client;

import optifine.*;

public class BlockAlias
{
    private /* synthetic */ int blockId;
    private /* synthetic */ MatchBlock[] matchBlocks;
    
    public BlockAlias(final int lllllllllllllIIlIIlIllIllIllllII, final MatchBlock[] lllllllllllllIIlIIlIllIllIlllIII) {
        this.blockId = lllllllllllllIIlIIlIllIllIllllII;
        this.matchBlocks = lllllllllllllIIlIIlIllIllIlllIII;
    }
    
    public int getBlockId() {
        return this.blockId;
    }
    
    public int[] getMatchBlockIds() {
        final int[] lllllllllllllIIlIIlIllIllIlIIIIl = new int[this.matchBlocks.length];
        for (int lllllllllllllIIlIIlIllIllIlIIIII = 0; lllllllllllllIIlIIlIllIllIlIIIII < lllllllllllllIIlIIlIllIllIlIIIIl.length; ++lllllllllllllIIlIIlIllIllIlIIIII) {
            lllllllllllllIIlIIlIllIllIlIIIIl[lllllllllllllIIlIIlIllIllIlIIIII] = this.matchBlocks[lllllllllllllIIlIIlIllIllIlIIIII].getBlockId();
        }
        return lllllllllllllIIlIIlIllIllIlIIIIl;
    }
    
    public boolean matches(final int lllllllllllllIIlIIlIllIllIlIlllI, final int lllllllllllllIIlIIlIllIllIlIllIl) {
        for (int lllllllllllllIIlIIlIllIllIlIllII = 0; lllllllllllllIIlIIlIllIllIlIllII < this.matchBlocks.length; ++lllllllllllllIIlIIlIllIllIlIllII) {
            final MatchBlock lllllllllllllIIlIIlIllIllIlIlIll = this.matchBlocks[lllllllllllllIIlIIlIllIllIlIllII];
            if (lllllllllllllIIlIIlIllIllIlIlIll.matches(lllllllllllllIIlIIlIllIllIlIlllI, lllllllllllllIIlIIlIllIllIlIllIl)) {
                return true;
            }
        }
        return false;
    }
}
