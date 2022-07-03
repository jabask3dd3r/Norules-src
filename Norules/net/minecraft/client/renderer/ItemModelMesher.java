package net.minecraft.client.renderer;

import java.util.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.item.*;
import javax.annotation.*;
import com.google.common.collect.*;

public class ItemModelMesher
{
    private final /* synthetic */ Map<Item, ItemMeshDefinition> shapers;
    private final /* synthetic */ Map<Integer, ModelResourceLocation> simpleShapes;
    private final /* synthetic */ Map<Integer, IBakedModel> simpleShapesCache;
    private final /* synthetic */ ModelManager modelManager;
    
    public TextureAtlasSprite getParticleIcon(final Item llllllllllllllllIlllllIlIllIIIll, final int llllllllllllllllIlllllIlIllIIIlI) {
        return this.getItemModel(new ItemStack(llllllllllllllllIlllllIlIllIIIll, 1, llllllllllllllllIlllllIlIllIIIlI)).getParticleTexture();
    }
    
    @Nullable
    protected IBakedModel getItemModel(final Item llllllllllllllllIlllllIlIlIIIlll, final int llllllllllllllllIlllllIlIlIIlIIl) {
        return this.simpleShapesCache.get(this.getIndex(llllllllllllllllIlllllIlIlIIIlll, llllllllllllllllIlllllIlIlIIlIIl));
    }
    
    public void rebuildCache() {
        this.simpleShapesCache.clear();
        for (final Map.Entry<Integer, ModelResourceLocation> llllllllllllllllIlllllIlIIlIIIlI : this.simpleShapes.entrySet()) {
            this.simpleShapesCache.put(llllllllllllllllIlllllIlIIlIIIlI.getKey(), this.modelManager.getModel(llllllllllllllllIlllllIlIIlIIIlI.getValue()));
        }
    }
    
    public TextureAtlasSprite getParticleIcon(final Item llllllllllllllllIlllllIlIllIllIl) {
        return this.getParticleIcon(llllllllllllllllIlllllIlIllIllIl, 0);
    }
    
    public void register(final Item llllllllllllllllIlllllIlIIlIlllI, final ItemMeshDefinition llllllllllllllllIlllllIlIIlIllIl) {
        this.shapers.put(llllllllllllllllIlllllIlIIlIlllI, llllllllllllllllIlllllIlIIlIllIl);
    }
    
    private int getIndex(final Item llllllllllllllllIlllllIlIlIIIIlI, final int llllllllllllllllIlllllIlIIllllll) {
        return Item.getIdFromItem(llllllllllllllllIlllllIlIlIIIIlI) << 16 | llllllllllllllllIlllllIlIIllllll;
    }
    
    public IBakedModel getItemModel(final ItemStack llllllllllllllllIlllllIlIlIlIllI) {
        final Item llllllllllllllllIlllllIlIlIllIlI = llllllllllllllllIlllllIlIlIlIllI.getItem();
        IBakedModel llllllllllllllllIlllllIlIlIllIIl = this.getItemModel(llllllllllllllllIlllllIlIlIllIlI, this.getMetadata(llllllllllllllllIlllllIlIlIlIllI));
        if (llllllllllllllllIlllllIlIlIllIIl == null) {
            final ItemMeshDefinition llllllllllllllllIlllllIlIlIllIII = this.shapers.get(llllllllllllllllIlllllIlIlIllIlI);
            if (llllllllllllllllIlllllIlIlIllIII != null) {
                llllllllllllllllIlllllIlIlIllIIl = this.modelManager.getModel(llllllllllllllllIlllllIlIlIllIII.getModelLocation(llllllllllllllllIlllllIlIlIlIllI));
            }
        }
        if (llllllllllllllllIlllllIlIlIllIIl == null) {
            llllllllllllllllIlllllIlIlIllIIl = this.modelManager.getMissingModel();
        }
        return llllllllllllllllIlllllIlIlIllIIl;
    }
    
    public ModelManager getModelManager() {
        return this.modelManager;
    }
    
    protected int getMetadata(final ItemStack llllllllllllllllIlllllIlIlIIllll) {
        return (llllllllllllllllIlllllIlIlIIllll.getMaxDamage() > 0) ? 0 : llllllllllllllllIlllllIlIlIIllll.getMetadata();
    }
    
    public void register(final Item llllllllllllllllIlllllIlIIlllIIl, final int llllllllllllllllIlllllIlIIllIlII, final ModelResourceLocation llllllllllllllllIlllllIlIIllIlll) {
        this.simpleShapes.put(this.getIndex(llllllllllllllllIlllllIlIIlllIIl, llllllllllllllllIlllllIlIIllIlII), llllllllllllllllIlllllIlIIllIlll);
        this.simpleShapesCache.put(this.getIndex(llllllllllllllllIlllllIlIIlllIIl, llllllllllllllllIlllllIlIIllIlII), this.modelManager.getModel(llllllllllllllllIlllllIlIIllIlll));
    }
    
    public ItemModelMesher(final ModelManager llllllllllllllllIlllllIlIlllIIll) {
        this.simpleShapes = (Map<Integer, ModelResourceLocation>)Maps.newHashMap();
        this.simpleShapesCache = (Map<Integer, IBakedModel>)Maps.newHashMap();
        this.shapers = (Map<Item, ItemMeshDefinition>)Maps.newHashMap();
        this.modelManager = llllllllllllllllIlllllIlIlllIIll;
    }
}
