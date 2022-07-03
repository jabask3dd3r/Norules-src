package net.optifine.entity.model;

import optifine.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.optifine.entity.model.anim.*;
import net.minecraft.client.*;
import java.util.*;
import net.minecraft.client.renderer.entity.*;
import com.google.gson.*;
import java.io.*;
import net.minecraft.client.renderer.tileentity.*;

public class CustomEntityModels
{
    private static /* synthetic */ Map<Class, TileEntitySpecialRenderer> originalTileEntityRenderMap;
    private static /* synthetic */ Map<Class, Render> originalEntityRenderMap;
    private static /* synthetic */ boolean active;
    
    public static void update() {
        final Map<Class, Render> llllllllllllllllIllIlIlIIlllllII = getEntityRenderMap();
        final Map<Class, TileEntitySpecialRenderer> llllllllllllllllIllIlIlIIllllIll = getTileEntityRenderMap();
        if (llllllllllllllllIllIlIlIIlllllII == null) {
            Config.warn("Entity render map not found, custom entity models are DISABLED.");
        }
        else if (llllllllllllllllIllIlIlIIllllIll == null) {
            Config.warn("Tile entity render map not found, custom entity models are DISABLED.");
        }
        else {
            CustomEntityModels.active = false;
            llllllllllllllllIllIlIlIIlllllII.clear();
            llllllllllllllllIllIlIlIIllllIll.clear();
            llllllllllllllllIllIlIlIIlllllII.putAll(CustomEntityModels.originalEntityRenderMap);
            llllllllllllllllIllIlIlIIllllIll.putAll(CustomEntityModels.originalTileEntityRenderMap);
            if (Config.isCustomEntityModels()) {
                final ResourceLocation[] llllllllllllllllIllIlIlIIllllIlI = getModelLocations();
                for (int llllllllllllllllIllIlIlIIllllIIl = 0; llllllllllllllllIllIlIlIIllllIIl < llllllllllllllllIllIlIlIIllllIlI.length; ++llllllllllllllllIllIlIlIIllllIIl) {
                    final ResourceLocation llllllllllllllllIllIlIlIIllllIII = llllllllllllllllIllIlIlIIllllIlI[llllllllllllllllIllIlIlIIllllIIl];
                    Config.dbg(String.valueOf(new StringBuilder("CustomEntityModel: ").append(llllllllllllllllIllIlIlIIllllIII.getResourcePath())));
                    final IEntityRenderer llllllllllllllllIllIlIlIIlllIlll = parseEntityRender(llllllllllllllllIllIlIlIIllllIII);
                    if (llllllllllllllllIllIlIlIIlllIlll != null) {
                        final Class llllllllllllllllIllIlIlIIlllIllI = llllllllllllllllIllIlIlIIlllIlll.getEntityClass();
                        if (llllllllllllllllIllIlIlIIlllIllI != null) {
                            if (llllllllllllllllIllIlIlIIlllIlll instanceof Render) {
                                llllllllllllllllIllIlIlIIlllllII.put(llllllllllllllllIllIlIlIIlllIllI, (Render)llllllllllllllllIllIlIlIIlllIlll);
                            }
                            else if (llllllllllllllllIllIlIlIIlllIlll instanceof TileEntitySpecialRenderer) {
                                llllllllllllllllIllIlIlIIllllIll.put(llllllllllllllllIllIlIlIIlllIllI, (TileEntitySpecialRenderer)llllllllllllllllIllIlIlIIlllIlll);
                            }
                            else {
                                Config.warn(String.valueOf(new StringBuilder("Unknown renderer type: ").append(llllllllllllllllIllIlIlIIlllIlll.getClass().getName())));
                            }
                            CustomEntityModels.active = true;
                        }
                    }
                }
            }
        }
    }
    
    private static boolean modifyModel(final ModelAdapter llllllllllllllllIllIlIIlllllIIll, final ModelBase llllllllllllllllIllIlIIlllllIIlI, final CustomModelRenderer llllllllllllllllIllIlIIlllllIIIl, final ModelResolver llllllllllllllllIllIlIIlllllIIII) {
        final String llllllllllllllllIllIlIIlllllIllI = llllllllllllllllIllIlIIlllllIIIl.getModelPart();
        final ModelRenderer llllllllllllllllIllIlIIlllllIlIl = llllllllllllllllIllIlIIlllllIIll.getModelRenderer(llllllllllllllllIllIlIIlllllIIlI, llllllllllllllllIllIlIIlllllIllI);
        if (llllllllllllllllIllIlIIlllllIlIl == null) {
            Config.warn(String.valueOf(new StringBuilder("Model part not found: ").append(llllllllllllllllIllIlIIlllllIllI).append(", model: ").append(llllllllllllllllIllIlIIlllllIIlI)));
            return false;
        }
        if (!llllllllllllllllIllIlIIlllllIIIl.isAttach()) {
            if (llllllllllllllllIllIlIIlllllIlIl.cubeList != null) {
                llllllllllllllllIllIlIIlllllIlIl.cubeList.clear();
            }
            if (llllllllllllllllIllIlIIlllllIlIl.spriteList != null) {
                llllllllllllllllIllIlIIlllllIlIl.spriteList.clear();
            }
            if (llllllllllllllllIllIlIIlllllIlIl.childModels != null) {
                llllllllllllllllIllIlIIlllllIlIl.childModels.clear();
            }
        }
        llllllllllllllllIllIlIIlllllIlIl.addChild(llllllllllllllllIllIlIIlllllIIIl.getModelRenderer());
        final ModelUpdater llllllllllllllllIllIlIIlllllIlII = llllllllllllllllIllIlIIlllllIIIl.getModelUpdater();
        if (llllllllllllllllIllIlIIlllllIlII != null) {
            llllllllllllllllIllIlIIlllllIIII.setThisModelRenderer(llllllllllllllllIllIlIIlllllIIIl.getModelRenderer());
            llllllllllllllllIllIlIIlllllIIII.setPartModelRenderer(llllllllllllllllIllIlIIlllllIlIl);
            if (!llllllllllllllllIllIlIIlllllIlII.initialize(llllllllllllllllIllIlIIlllllIIII)) {
                return false;
            }
            llllllllllllllllIllIlIIlllllIIIl.getModelRenderer().setModelUpdater(llllllllllllllllIllIlIIlllllIlII);
        }
        return true;
    }
    
    private static void checkNull(final Object llllllllllllllllIllIlIIllllIlIlI, final String llllllllllllllllIllIlIIllllIlIIl) {
        if (llllllllllllllllIllIlIIllllIlIlI == null) {
            throw new JsonParseException(llllllllllllllllIllIlIIllllIlIIl);
        }
    }
    
    static {
        CustomEntityModels.active = false;
        CustomEntityModels.originalEntityRenderMap = null;
        CustomEntityModels.originalTileEntityRenderMap = null;
    }
    
    public static boolean isActive() {
        return CustomEntityModels.active;
    }
    
    private static boolean modifyModel(final ModelAdapter llllllllllllllllIllIlIlIIIIIllIl, final ModelBase llllllllllllllllIllIlIlIIIIIllII, final CustomModelRenderer[] llllllllllllllllIllIlIlIIIIIIlIl, final ModelResolver llllllllllllllllIllIlIlIIIIIIlII) {
        for (int llllllllllllllllIllIlIlIIIIIlIIl = 0; llllllllllllllllIllIlIlIIIIIlIIl < llllllllllllllllIllIlIlIIIIIIlIl.length; ++llllllllllllllllIllIlIlIIIIIlIIl) {
            final CustomModelRenderer llllllllllllllllIllIlIlIIIIIlIII = llllllllllllllllIllIlIlIIIIIIlIl[llllllllllllllllIllIlIlIIIIIlIIl];
            if (!modifyModel(llllllllllllllllIllIlIlIIIIIllIl, llllllllllllllllIllIlIlIIIIIllII, llllllllllllllllIllIlIlIIIIIlIII, llllllllllllllllIllIlIlIIIIIIlII)) {
                return false;
            }
        }
        return true;
    }
    
    private static ResourceLocation[] getModelLocations() {
        final String llllllllllllllllIllIlIlIIlIlllIl = "optifine/cem/";
        final String llllllllllllllllIllIlIlIIlIlllII = ".jem";
        final List<ResourceLocation> llllllllllllllllIllIlIlIIlIllIll = new ArrayList<ResourceLocation>();
        final String[] llllllllllllllllIllIlIlIIlIllIlI = CustomModelRegistry.getModelNames();
        for (int llllllllllllllllIllIlIlIIlIllIIl = 0; llllllllllllllllIllIlIlIIlIllIIl < llllllllllllllllIllIlIlIIlIllIlI.length; ++llllllllllllllllIllIlIlIIlIllIIl) {
            final String llllllllllllllllIllIlIlIIlIllIII = llllllllllllllllIllIlIlIIlIllIlI[llllllllllllllllIllIlIlIIlIllIIl];
            final String llllllllllllllllIllIlIlIIlIlIlll = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIllIlIlIIlIlllIl)).append(llllllllllllllllIllIlIlIIlIllIII).append(llllllllllllllllIllIlIlIIlIlllII));
            final ResourceLocation llllllllllllllllIllIlIlIIlIlIllI = new ResourceLocation(llllllllllllllllIllIlIlIIlIlIlll);
            if (Config.hasResource(llllllllllllllllIllIlIlIIlIlIllI)) {
                llllllllllllllllIllIlIlIIlIllIll.add(llllllllllllllllIllIlIlIIlIlIllI);
            }
        }
        final ResourceLocation[] llllllllllllllllIllIlIlIIlIlIlIl = llllllllllllllllIllIlIlIIlIllIll.toArray(new ResourceLocation[llllllllllllllllIllIlIlIIlIllIll.size()]);
        return llllllllllllllllIllIlIlIIlIlIlIl;
    }
    
    private static Map<Class, Render> getEntityRenderMap() {
        final RenderManager llllllllllllllllIllIlIlIIllIllII = Minecraft.getMinecraft().getRenderManager();
        final Map<Class, Render> llllllllllllllllIllIlIlIIllIlIll = llllllllllllllllIllIlIlIIllIllII.getEntityRenderMap();
        if (llllllllllllllllIllIlIlIIllIlIll == null) {
            return null;
        }
        if (CustomEntityModels.originalEntityRenderMap == null) {
            CustomEntityModels.originalEntityRenderMap = new HashMap<Class, Render>(llllllllllllllllIllIlIlIIllIlIll);
        }
        return llllllllllllllllIllIlIlIIllIlIll;
    }
    
    private static IEntityRenderer parseEntityRender(final JsonObject llllllllllllllllIllIlIlIIIllIIlI, final String llllllllllllllllIllIlIlIIIlllIII) {
        final CustomEntityRenderer llllllllllllllllIllIlIlIIIllIlll = CustomEntityModelParser.parseEntityRender(llllllllllllllllIllIlIlIIIllIIlI, llllllllllllllllIllIlIlIIIlllIII);
        final String llllllllllllllllIllIlIlIIIllIllI = llllllllllllllllIllIlIlIIIllIlll.getName();
        final ModelAdapter llllllllllllllllIllIlIlIIIllIlIl = CustomModelRegistry.getModelAdapter(llllllllllllllllIllIlIlIIIllIllI);
        checkNull(llllllllllllllllIllIlIlIIIllIlIl, String.valueOf(new StringBuilder("Entity not found: ").append(llllllllllllllllIllIlIlIIIllIllI)));
        final Class llllllllllllllllIllIlIlIIIllIlII = llllllllllllllllIllIlIlIIIllIlIl.getEntityClass();
        checkNull(llllllllllllllllIllIlIlIIIllIlII, String.valueOf(new StringBuilder("Entity class not found: ").append(llllllllllllllllIllIlIlIIIllIllI)));
        final IEntityRenderer llllllllllllllllIllIlIlIIIllIIll = makeEntityRender(llllllllllllllllIllIlIlIIIllIlIl, llllllllllllllllIllIlIlIIIllIlll);
        if (llllllllllllllllIllIlIlIIIllIIll == null) {
            return null;
        }
        llllllllllllllllIllIlIlIIIllIIll.setEntityClass(llllllllllllllllIllIlIlIIIllIlII);
        return llllllllllllllllIllIlIlIIIllIIll;
    }
    
    private static IEntityRenderer parseEntityRender(final ResourceLocation llllllllllllllllIllIlIlIIlIIIIll) {
        try {
            final JsonObject llllllllllllllllIllIlIlIIlIIlIII = CustomEntityModelParser.loadJson(llllllllllllllllIllIlIlIIlIIIIll);
            final IEntityRenderer llllllllllllllllIllIlIlIIlIIIlll = parseEntityRender(llllllllllllllllIllIlIlIIlIIlIII, llllllllllllllllIllIlIlIIlIIIIll.getResourcePath());
            return llllllllllllllllIllIlIlIIlIIIlll;
        }
        catch (IOException llllllllllllllllIllIlIlIIlIIIllI) {
            Config.error(String.valueOf(new StringBuilder().append(llllllllllllllllIllIlIlIIlIIIllI.getClass().getName()).append(": ").append(llllllllllllllllIllIlIlIIlIIIllI.getMessage())));
            return null;
        }
        catch (JsonParseException llllllllllllllllIllIlIlIIlIIIlIl) {
            Config.error(String.valueOf(new StringBuilder().append(llllllllllllllllIllIlIlIIlIIIlIl.getClass().getName()).append(": ").append(llllllllllllllllIllIlIlIIlIIIlIl.getMessage())));
            return null;
        }
        catch (Exception llllllllllllllllIllIlIlIIlIIIlII) {
            llllllllllllllllIllIlIlIIlIIIlII.printStackTrace();
            return null;
        }
    }
    
    private static IEntityRenderer makeEntityRender(final ModelAdapter llllllllllllllllIllIlIlIIIIllIll, final CustomEntityRenderer llllllllllllllllIllIlIlIIIIllIlI) {
        final ResourceLocation llllllllllllllllIllIlIlIIIlIIIIl = llllllllllllllllIllIlIlIIIIllIlI.getTextureLocation();
        final CustomModelRenderer[] llllllllllllllllIllIlIlIIIlIIIII = llllllllllllllllIllIlIlIIIIllIlI.getCustomModelRenderers();
        float llllllllllllllllIllIlIlIIIIlllll = llllllllllllllllIllIlIlIIIIllIlI.getShadowSize();
        if (llllllllllllllllIllIlIlIIIIlllll < 0.0f) {
            llllllllllllllllIllIlIlIIIIlllll = llllllllllllllllIllIlIlIIIIllIll.getShadowSize();
        }
        final ModelBase llllllllllllllllIllIlIlIIIIllllI = llllllllllllllllIllIlIlIIIIllIll.makeModel();
        if (llllllllllllllllIllIlIlIIIIllllI == null) {
            return null;
        }
        final ModelResolver llllllllllllllllIllIlIlIIIIlllIl = new ModelResolver(llllllllllllllllIllIlIlIIIIllIll, llllllllllllllllIllIlIlIIIIllllI, llllllllllllllllIllIlIlIIIlIIIII);
        if (!modifyModel(llllllllllllllllIllIlIlIIIIllIll, llllllllllllllllIllIlIlIIIIllllI, llllllllllllllllIllIlIlIIIlIIIII, llllllllllllllllIllIlIlIIIIlllIl)) {
            return null;
        }
        final IEntityRenderer llllllllllllllllIllIlIlIIIIlllII = llllllllllllllllIllIlIlIIIIllIll.makeEntityRender(llllllllllllllllIllIlIlIIIIllllI, llllllllllllllllIllIlIlIIIIlllll);
        if (llllllllllllllllIllIlIlIIIIlllII == null) {
            throw new JsonParseException(String.valueOf(new StringBuilder("Entity renderer is null, model: ").append(llllllllllllllllIllIlIlIIIIllIll.getName()).append(", adapter: ").append(llllllllllllllllIllIlIlIIIIllIll.getClass().getName())));
        }
        if (llllllllllllllllIllIlIlIIIlIIIIl != null) {
            llllllllllllllllIllIlIlIIIIlllII.setLocationTextureCustom(llllllllllllllllIllIlIlIIIlIIIIl);
        }
        return llllllllllllllllIllIlIlIIIIlllII;
    }
    
    private static Map<Class, TileEntitySpecialRenderer> getTileEntityRenderMap() {
        final Map<Class, TileEntitySpecialRenderer> llllllllllllllllIllIlIlIIllIIlll = TileEntityRendererDispatcher.instance.mapSpecialRenderers;
        if (CustomEntityModels.originalTileEntityRenderMap == null) {
            CustomEntityModels.originalTileEntityRenderMap = new HashMap<Class, TileEntitySpecialRenderer>(llllllllllllllllIllIlIlIIllIIlll);
        }
        return llllllllllllllllIllIlIlIIllIIlll;
    }
}
