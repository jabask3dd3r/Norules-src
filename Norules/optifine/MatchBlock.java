package optifine;

import net.minecraft.block.state.*;

public class MatchBlock
{
    private /* synthetic */ int[] metadatas;
    private /* synthetic */ int blockId;
    
    public int[] getMetadatas() {
        return this.metadatas;
    }
    
    public MatchBlock(final int llllllllllllllIIlIIllIIIlIlIIIll, final int llllllllllllllIIlIIllIIIlIIlllll) {
        this.blockId = -1;
        this.metadatas = null;
        this.blockId = llllllllllllllIIlIIllIIIlIlIIIll;
        if (llllllllllllllIIlIIllIIIlIIlllll >= 0 && llllllllllllllIIlIIllIIIlIIlllll <= 15) {
            this.metadatas = new int[] { llllllllllllllIIlIIllIIIlIIlllll };
        }
    }
    
    public int getBlockId() {
        return this.blockId;
    }
    
    public boolean matches(final int llllllllllllllIIlIIllIIIlIIIIIlI, final int llllllllllllllIIlIIllIIIlIIIIlII) {
        return llllllllllllllIIlIIllIIIlIIIIIlI == this.blockId && Matches.metadata(llllllllllllllIIlIIllIIIlIIIIlII, this.metadatas);
    }
    
    public MatchBlock(final int llllllllllllllIIlIIllIIIlIIlIlll, final int[] llllllllllllllIIlIIllIIIlIIlIllI) {
        this.blockId = -1;
        this.metadatas = null;
        this.blockId = llllllllllllllIIlIIllIIIlIIlIlll;
        this.metadatas = llllllllllllllIIlIIllIIIlIIlIllI;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.blockId).append(":").append(Config.arrayToString(this.metadatas)));
    }
    
    public boolean matches(final BlockStateBase llllllllllllllIIlIIllIIIlIIIlIlI) {
        return llllllllllllllIIlIIllIIIlIIIlIlI.getBlockId() == this.blockId && Matches.metadata(llllllllllllllIIlIIllIIIlIIIlIlI.getMetadata(), this.metadatas);
    }
    
    public void addMetadata(final int llllllllllllllIIlIIllIIIIlllllII) {
        if (this.metadatas != null && llllllllllllllIIlIIllIIIIlllllII >= 0 && llllllllllllllIIlIIllIIIIlllllII <= 15) {
            for (int llllllllllllllIIlIIllIIIIllllIll = 0; llllllllllllllIIlIIllIIIIllllIll < this.metadatas.length; ++llllllllllllllIIlIIllIIIIllllIll) {
                if (this.metadatas[llllllllllllllIIlIIllIIIIllllIll] == llllllllllllllIIlIIllIIIIlllllII) {
                    return;
                }
            }
            this.metadatas = Config.addIntToArray(this.metadatas, llllllllllllllIIlIIllIIIIlllllII);
        }
    }
    
    public MatchBlock(final int llllllllllllllIIlIIllIIIlIlIlIlI) {
        this.blockId = -1;
        this.metadatas = null;
        this.blockId = llllllllllllllIIlIIllIIIlIlIlIlI;
    }
}
