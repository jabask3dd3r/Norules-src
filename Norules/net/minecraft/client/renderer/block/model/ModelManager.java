package net.minecraft.client.renderer.block.model;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.registry.*;
import net.minecraft.client.resources.*;

public class ModelManager implements IResourceManagerReloadListener
{
    private final /* synthetic */ TextureMap texMap;
    private final /* synthetic */ BlockModelShapes modelProvider;
    private /* synthetic */ IRegistry<ModelResourceLocation, IBakedModel> modelRegistry;
    private /* synthetic */ IBakedModel defaultModel;
    
    @Override
    public void onResourceManagerReload(final IResourceManager llllllllllllllllIllIIllllIlIlIII) {
        final ModelBakery llllllllllllllllIllIIllllIlIIlll = new ModelBakery(llllllllllllllllIllIIllllIlIlIII, this.texMap, this.modelProvider);
        this.modelRegistry = llllllllllllllllIllIIllllIlIIlll.setupModelRegistry();
        this.defaultModel = this.modelRegistry.getObject(ModelBakery.MODEL_MISSING);
        this.modelProvider.reloadModels();
    }
    
    public ModelManager(final TextureMap llllllllllllllllIllIIllllIlIllll) {
        this.texMap = llllllllllllllllIllIIllllIlIllll;
        this.modelProvider = new BlockModelShapes(this);
    }
    
    public BlockModelShapes getBlockModelShapes() {
        return this.modelProvider;
    }
    
    public IBakedModel getMissingModel() {
        return this.defaultModel;
    }
    
    public IBakedModel getModel(final ModelResourceLocation llllllllllllllllIllIIllllIIlllII) {
        if (llllllllllllllllIllIIllllIIlllII == null) {
            return this.defaultModel;
        }
        final IBakedModel llllllllllllllllIllIIllllIIllllI = this.modelRegistry.getObject(llllllllllllllllIllIIllllIIlllII);
        return (llllllllllllllllIllIIllllIIllllI == null) ? this.defaultModel : llllllllllllllllIllIIllllIIllllI;
    }
    
    public TextureMap getTextureMap() {
        return this.texMap;
    }
}
