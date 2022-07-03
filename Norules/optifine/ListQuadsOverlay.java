package optifine;

import net.minecraft.block.state.*;
import net.minecraft.client.renderer.block.model.*;
import java.util.*;
import net.minecraft.init.*;

public class ListQuadsOverlay
{
    private /* synthetic */ List<IBlockState> listBlockStates;
    private /* synthetic */ List<BakedQuad> listQuads;
    private /* synthetic */ List<BakedQuad> listQuadsSingle;
    
    public ListQuadsOverlay() {
        this.listQuads = new ArrayList<BakedQuad>();
        this.listBlockStates = new ArrayList<IBlockState>();
        this.listQuadsSingle = Arrays.asList(new BakedQuad[0]);
    }
    
    public IBlockState getBlockState(final int llllllllllllllIlIlIlllIlIllIIllI) {
        return (llllllllllllllIlIlIlllIlIllIIllI >= 0 && llllllllllllllIlIlIlllIlIllIIllI < this.listBlockStates.size()) ? this.listBlockStates.get(llllllllllllllIlIlIlllIlIllIIllI) : Blocks.AIR.getDefaultState();
    }
    
    public void clear() {
        this.listQuads.clear();
        this.listBlockStates.clear();
    }
    
    public List<BakedQuad> getListQuadsSingle(final BakedQuad llllllllllllllIlIlIlllIlIllIIIII) {
        this.listQuadsSingle.set(0, llllllllllllllIlIlIlllIlIllIIIII);
        return this.listQuadsSingle;
    }
    
    public void addQuad(final BakedQuad llllllllllllllIlIlIlllIlIlllIlll, final IBlockState llllllllllllllIlIlIlllIlIlllIIll) {
        this.listQuads.add(llllllllllllllIlIlIlllIlIlllIlll);
        this.listBlockStates.add(llllllllllllllIlIlIlllIlIlllIIll);
    }
    
    public BakedQuad getQuad(final int llllllllllllllIlIlIlllIlIllIlIlI) {
        return this.listQuads.get(llllllllllllllIlIlIlllIlIllIlIlI);
    }
    
    public int size() {
        return this.listQuads.size();
    }
}
