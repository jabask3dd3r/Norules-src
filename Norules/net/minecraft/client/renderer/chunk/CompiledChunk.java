package net.minecraft.client.renderer.chunk;

import net.minecraft.client.renderer.*;
import java.util.*;
import net.minecraft.tileentity.*;
import com.google.common.collect.*;
import net.minecraft.util.*;

public class CompiledChunk
{
    private /* synthetic */ BufferBuilder.State state;
    private final /* synthetic */ boolean[] layersUsed;
    private /* synthetic */ SetVisibility setVisibility;
    private final /* synthetic */ boolean[] layersStarted;
    private final /* synthetic */ List<TileEntity> tileEntities;
    private /* synthetic */ boolean empty;
    
    public void setState(final BufferBuilder.State llllllllllllllllllIIlIIIlIllIlll) {
        this.state = llllllllllllllllllIIlIIIlIllIlll;
    }
    
    public CompiledChunk() {
        this.layersUsed = new boolean[BlockRenderLayer.values().length];
        this.layersStarted = new boolean[BlockRenderLayer.values().length];
        this.empty = true;
        this.tileEntities = (List<TileEntity>)Lists.newArrayList();
        this.setVisibility = new SetVisibility();
    }
    
    public void setLayerStarted(final BlockRenderLayer llllllllllllllllllIIlIIIllIlllII) {
        this.layersStarted[llllllllllllllllllIIlIIIllIlllII.ordinal()] = true;
    }
    
    static {
        DUMMY = new CompiledChunk() {
            @Override
            public void setLayerStarted(final BlockRenderLayer lllllllllllllIllllIIllllllIIIlll) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            protected void setLayerUsed(final BlockRenderLayer lllllllllllllIllllIIllllllIIlIIl) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public boolean isVisible(final EnumFacing lllllllllllllIllllIIllllllIIIlIl, final EnumFacing lllllllllllllIllllIIllllllIIIlII) {
                return false;
            }
        };
    }
    
    public boolean isVisible(final EnumFacing llllllllllllllllllIIlIIIllIIlIII, final EnumFacing llllllllllllllllllIIlIIIllIIIlII) {
        return this.setVisibility.isVisible(llllllllllllllllllIIlIIIllIIlIII, llllllllllllllllllIIlIIIllIIIlII);
    }
    
    public void addTileEntity(final TileEntity llllllllllllllllllIIlIIIllIIllll) {
        this.tileEntities.add(llllllllllllllllllIIlIIIllIIllll);
    }
    
    public void setVisibility(final SetVisibility llllllllllllllllllIIlIIIllIIIIII) {
        this.setVisibility = llllllllllllllllllIIlIIIllIIIIII;
    }
    
    public BufferBuilder.State getState() {
        return this.state;
    }
    
    public boolean isLayerStarted(final BlockRenderLayer llllllllllllllllllIIlIIIllIllIII) {
        return this.layersStarted[llllllllllllllllllIIlIIIllIllIII.ordinal()];
    }
    
    protected void setLayerUsed(final BlockRenderLayer llllllllllllllllllIIlIIIlllIlIlI) {
        this.empty = false;
        this.layersUsed[llllllllllllllllllIIlIIIlllIlIlI.ordinal()] = true;
    }
    
    public boolean isEmpty() {
        return this.empty;
    }
    
    public boolean isLayerEmpty(final BlockRenderLayer llllllllllllllllllIIlIIIlllIIlII) {
        return !this.layersUsed[llllllllllllllllllIIlIIIlllIIlII.ordinal()];
    }
    
    public List<TileEntity> getTileEntities() {
        return this.tileEntities;
    }
}
