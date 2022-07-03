package net.minecraft.client.model;

import net.optifine.entity.model.anim.*;
import net.minecraft.util.*;
import java.util.*;
import com.google.common.collect.*;
import optifine.*;
import me.nrules.*;
import me.nrules.module.render.*;
import net.minecraft.client.renderer.*;

public class ModelRenderer
{
    public /* synthetic */ float rotateAngleY;
    public /* synthetic */ float offsetY;
    public /* synthetic */ boolean mirrorV;
    public /* synthetic */ float scaleZ;
    private /* synthetic */ boolean compiled;
    public /* synthetic */ List spriteList;
    public /* synthetic */ float textureWidth;
    public /* synthetic */ float offsetZ;
    public final /* synthetic */ String boxName;
    public /* synthetic */ float rotationPointZ;
    public /* synthetic */ float rotateAngleX;
    public /* synthetic */ List<ModelBox> cubeList;
    private /* synthetic */ RenderGlobal renderGlobal;
    private final /* synthetic */ ModelBase baseModel;
    private /* synthetic */ int textureOffsetY;
    public /* synthetic */ boolean showModel;
    private /* synthetic */ ModelUpdater modelUpdater;
    public /* synthetic */ List<ModelRenderer> childModels;
    public /* synthetic */ float rotationPointY;
    private /* synthetic */ float savedScale;
    private /* synthetic */ ResourceLocation textureLocation;
    public /* synthetic */ float offsetX;
    public /* synthetic */ boolean isHidden;
    public /* synthetic */ float textureHeight;
    private /* synthetic */ int displayList;
    public /* synthetic */ float scaleY;
    public /* synthetic */ float rotationPointX;
    public /* synthetic */ float rotateAngleZ;
    public /* synthetic */ float scaleX;
    private /* synthetic */ String id;
    public /* synthetic */ boolean mirror;
    private /* synthetic */ int textureOffsetX;
    
    @Override
    public String toString() {
        final StringBuffer lllllllllllllIIlIllIlIIlllIIIllI = new StringBuffer();
        lllllllllllllIIlIllIlIIlllIIIllI.append(String.valueOf(new StringBuilder("id: ").append(this.id).append(", boxes: ").append((this.cubeList != null) ? Integer.valueOf(this.cubeList.size()) : null).append(", submodels: ").append((this.childModels != null) ? Integer.valueOf(this.childModels.size()) : null)));
        return lllllllllllllIIlIllIlIIlllIIIllI.toString();
    }
    
    public ModelRenderer setTextureOffset(final int lllllllllllllIIlIllIlIllIIIIIllI, final int lllllllllllllIIlIllIlIllIIIIIIlI) {
        this.textureOffsetX = lllllllllllllIIlIllIlIllIIIIIllI;
        this.textureOffsetY = lllllllllllllIIlIllIlIllIIIIIIlI;
        return this;
    }
    
    public boolean getCompiled() {
        return this.compiled;
    }
    
    public void setId(final String lllllllllllllIIlIllIlIlIIIIIlIIl) {
        this.id = lllllllllllllIIlIllIlIlIIIIIlIIl;
    }
    
    public ModelRenderer(final ModelBase lllllllllllllIIlIllIlIllIlIIlIII, final String lllllllllllllIIlIllIlIllIlIIlIlI) {
        this.spriteList = new ArrayList();
        this.mirrorV = false;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.scaleZ = 1.0f;
        this.textureLocation = null;
        this.id = null;
        this.renderGlobal = Config.getRenderGlobal();
        this.textureWidth = 64.0f;
        this.textureHeight = 32.0f;
        this.showModel = true;
        this.cubeList = (List<ModelBox>)Lists.newArrayList();
        this.baseModel = lllllllllllllIIlIllIlIllIlIIlIII;
        lllllllllllllIIlIllIlIllIlIIlIII.boxList.add(this);
        this.boxName = lllllllllllllIIlIllIlIllIlIIlIlI;
        this.setTextureSize(lllllllllllllIIlIllIlIllIlIIlIII.textureWidth, lllllllllllllIIlIllIlIllIlIIlIII.textureHeight);
    }
    
    public ResourceLocation getTextureLocation() {
        return this.textureLocation;
    }
    
    public void setRotationPoint(final float lllllllllllllIIlIllIlIlIIlllllIl, final float lllllllllllllIIlIllIlIlIlIIIIIII, final float lllllllllllllIIlIllIlIlIIlllllll) {
        this.rotationPointX = lllllllllllllIIlIllIlIlIIlllllIl;
        this.rotationPointY = lllllllllllllIIlIllIlIlIlIIIIIII;
        this.rotationPointZ = lllllllllllllIIlIllIlIlIIlllllll;
    }
    
    public ModelRenderer setTextureSize(final int lllllllllllllIIlIllIlIlIIIllllIl, final int lllllllllllllIIlIllIlIlIIIllllII) {
        this.textureWidth = (float)lllllllllllllIIlIllIlIlIIIllllIl;
        this.textureHeight = (float)lllllllllllllIIlIllIlIlIIIllllII;
        return this;
    }
    
    public ModelRenderer getChildDeep(final String lllllllllllllIIlIllIlIIlllIllIlI) {
        if (lllllllllllllIIlIllIlIIlllIllIlI == null) {
            return null;
        }
        final ModelRenderer lllllllllllllIIlIllIlIIlllIllIIl = this.getChild(lllllllllllllIIlIllIlIIlllIllIlI);
        if (lllllllllllllIIlIllIlIIlllIllIIl != null) {
            return lllllllllllllIIlIllIlIIlllIllIIl;
        }
        if (this.childModels != null) {
            for (int lllllllllllllIIlIllIlIIlllIllIII = 0; lllllllllllllIIlIllIlIIlllIllIII < this.childModels.size(); ++lllllllllllllIIlIllIlIIlllIllIII) {
                final ModelRenderer lllllllllllllIIlIllIlIIlllIlIlll = this.childModels.get(lllllllllllllIIlIllIlIIlllIllIII);
                final ModelRenderer lllllllllllllIIlIllIlIIlllIlIllI = lllllllllllllIIlIllIlIIlllIlIlll.getChildDeep(lllllllllllllIIlIllIlIIlllIllIlI);
                if (lllllllllllllIIlIllIlIIlllIlIllI != null) {
                    return lllllllllllllIIlIllIlIIlllIlIllI;
                }
            }
        }
        return null;
    }
    
    public ModelRenderer addBox(final float lllllllllllllIIlIllIlIlIlIlIllIl, final float lllllllllllllIIlIllIlIlIlIlIIlII, final float lllllllllllllIIlIllIlIlIlIlIlIll, final int lllllllllllllIIlIllIlIlIlIlIlIlI, final int lllllllllllllIIlIllIlIlIlIlIlIIl, final int lllllllllllllIIlIllIlIlIlIlIlIII, final boolean lllllllllllllIIlIllIlIlIlIlIIlll) {
        this.cubeList.add(new ModelBox(this, this.textureOffsetX, this.textureOffsetY, lllllllllllllIIlIllIlIlIlIlIllIl, lllllllllllllIIlIllIlIlIlIlIIlII, lllllllllllllIIlIllIlIlIlIlIlIll, lllllllllllllIIlIllIlIlIlIlIlIlI, lllllllllllllIIlIllIlIlIlIlIlIIl, lllllllllllllIIlIllIlIlIlIlIlIII, 0.0f, lllllllllllllIIlIllIlIlIlIlIIlll));
        return this;
    }
    
    public void setModelUpdater(final ModelUpdater lllllllllllllIIlIllIlIIlllIIllII) {
        this.modelUpdater = lllllllllllllIIlIllIlIIlllIIllII;
    }
    
    public void resetDisplayList() {
        if (this.compiled) {
            this.compiled = false;
            this.compileDisplayList(this.savedScale);
        }
    }
    
    public void addSprite(final float lllllllllllllIIlIllIlIlIIIllIIlI, final float lllllllllllllIIlIllIlIlIIIllIIIl, final float lllllllllllllIIlIllIlIlIIIllIIII, final int lllllllllllllIIlIllIlIlIIIlIllll, final int lllllllllllllIIlIllIlIlIIIlIlllI, final int lllllllllllllIIlIllIlIlIIIlIllIl, final float lllllllllllllIIlIllIlIlIIIlIIlII) {
        this.spriteList.add(new ModelSprite(this, this.textureOffsetX, this.textureOffsetY, lllllllllllllIIlIllIlIlIIIllIIlI, lllllllllllllIIlIllIlIlIIIllIIIl, lllllllllllllIIlIllIlIlIIIllIIII, lllllllllllllIIlIllIlIlIIIlIllll, lllllllllllllIIlIllIlIlIIIlIlllI, lllllllllllllIIlIllIlIlIIIlIllIl, lllllllllllllIIlIllIlIlIIIlIIlII));
    }
    
    public void render(final float lllllllllllllIIlIllIlIlIIlllIlII) {
        if (!this.isHidden && this.showModel) {
            if (!this.compiled) {
                this.compileDisplayList(lllllllllllllIIlIllIlIlIIlllIlII);
            }
            int lllllllllllllIIlIllIlIlIIlllIIll = 0;
            if (this.textureLocation != null && !this.renderGlobal.renderOverlayDamaged) {
                if (this.renderGlobal.renderOverlayEyes) {
                    return;
                }
                lllllllllllllIIlIllIlIlIIlllIIll = GlStateManager.getBoundTexture();
                Config.getTextureManager().bindTexture(this.textureLocation);
            }
            if (this.modelUpdater != null) {
                this.modelUpdater.update();
            }
            final boolean lllllllllllllIIlIllIlIlIIlllIIlI = this.scaleX != 1.0f || this.scaleY != 1.0f || this.scaleZ != 1.0f;
            GlStateManager.translate(this.offsetX, this.offsetY, this.offsetZ);
            if (this.rotateAngleX == 0.0f && this.rotateAngleY == 0.0f && this.rotateAngleZ == 0.0f) {
                if (this.rotationPointX == 0.0f && this.rotationPointY == 0.0f && this.rotationPointZ == 0.0f) {
                    if (lllllllllllllIIlIllIlIlIIlllIIlI) {
                        GlStateManager.scale(this.scaleX, this.scaleY, this.scaleZ);
                    }
                    GlStateManager.callList(this.displayList);
                    if (this.childModels != null) {
                        for (int lllllllllllllIIlIllIlIlIIlllIIIl = 0; lllllllllllllIIlIllIlIlIIlllIIIl < this.childModels.size(); ++lllllllllllllIIlIllIlIlIIlllIIIl) {
                            this.childModels.get(lllllllllllllIIlIllIlIlIIlllIIIl).render(lllllllllllllIIlIllIlIlIIlllIlII);
                        }
                    }
                    if (lllllllllllllIIlIllIlIlIIlllIIlI) {
                        GlStateManager.scale(1.0f / this.scaleX, 1.0f / this.scaleY, 1.0f / this.scaleZ);
                    }
                }
                else {
                    GlStateManager.translate(this.rotationPointX * lllllllllllllIIlIllIlIlIIlllIlII, this.rotationPointY * lllllllllllllIIlIllIlIlIIlllIlII, this.rotationPointZ * lllllllllllllIIlIllIlIlIIlllIlII);
                    if (lllllllllllllIIlIllIlIlIIlllIIlI) {
                        GlStateManager.scale(this.scaleX, this.scaleY, this.scaleZ);
                    }
                    GlStateManager.callList(this.displayList);
                    if (this.childModels != null) {
                        for (int lllllllllllllIIlIllIlIlIIlllIIII = 0; lllllllllllllIIlIllIlIlIIlllIIII < this.childModels.size(); ++lllllllllllllIIlIllIlIlIIlllIIII) {
                            this.childModels.get(lllllllllllllIIlIllIlIlIIlllIIII).render(lllllllllllllIIlIllIlIlIIlllIlII);
                        }
                    }
                    if (lllllllllllllIIlIllIlIlIIlllIIlI) {
                        GlStateManager.scale(1.0f / this.scaleX, 1.0f / this.scaleY, 1.0f / this.scaleZ);
                    }
                    GlStateManager.translate(-this.rotationPointX * lllllllllllllIIlIllIlIlIIlllIlII, -this.rotationPointY * lllllllllllllIIlIllIlIlIIlllIlII, -this.rotationPointZ * lllllllllllllIIlIllIlIlIIlllIlII);
                }
            }
            else {
                GlStateManager.pushMatrix();
                if (Main.moduleManager.getModule(CustomModel.class).isToggled()) {
                    GlStateManager.translate(this.rotationPointX * lllllllllllllIIlIllIlIlIIlllIlII * 0.9, this.rotationPointY * lllllllllllllIIlIllIlIlIIlllIlII * 0.7, this.rotationPointZ * lllllllllllllIIlIllIlIlIIlllIlII * 0.9);
                }
                else {
                    GlStateManager.translate(this.rotationPointX * lllllllllllllIIlIllIlIlIIlllIlII, this.rotationPointY * lllllllllllllIIlIllIlIlIIlllIlII, this.rotationPointZ * lllllllllllllIIlIllIlIlIIlllIlII);
                }
                if (this.rotateAngleZ != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleZ * 57.295776f, 0.0f, 0.0f, 1.0f);
                }
                if (this.rotateAngleY != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleY * 57.295776f, 0.0f, 1.0f, 0.0f);
                }
                if (this.rotateAngleX != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleX * 57.295776f, 1.0f, 0.0f, 0.0f);
                }
                if (lllllllllllllIIlIllIlIlIIlllIIlI) {
                    GlStateManager.scale(this.scaleX, this.scaleY, this.scaleZ);
                }
                GlStateManager.callList(this.displayList);
                if (this.childModels != null) {
                    for (int lllllllllllllIIlIllIlIlIIllIllll = 0; lllllllllllllIIlIllIlIlIIllIllll < this.childModels.size(); ++lllllllllllllIIlIllIlIlIIllIllll) {
                        this.childModels.get(lllllllllllllIIlIllIlIlIIllIllll).render(lllllllllllllIIlIllIlIlIIlllIlII);
                    }
                }
                GlStateManager.popMatrix();
            }
            GlStateManager.translate(-this.offsetX, -this.offsetY, -this.offsetZ);
            if (lllllllllllllIIlIllIlIlIIlllIIll != 0) {
                GlStateManager.bindTexture(lllllllllllllIIlIllIlIlIIlllIIll);
            }
        }
    }
    
    public ModelRenderer addBox(final float lllllllllllllIIlIllIlIlIllIIIIll, final float lllllllllllllIIlIllIlIlIllIIIIlI, final float lllllllllllllIIlIllIlIlIlIlllIlI, final int lllllllllllllIIlIllIlIlIlIlllIIl, final int lllllllllllllIIlIllIlIlIlIlllIII, final int lllllllllllllIIlIllIlIlIlIlllllI) {
        this.cubeList.add(new ModelBox(this, this.textureOffsetX, this.textureOffsetY, lllllllllllllIIlIllIlIlIllIIIIll, lllllllllllllIIlIllIlIlIllIIIIlI, lllllllllllllIIlIllIlIlIlIlllIlI, lllllllllllllIIlIllIlIlIlIlllIIl, lllllllllllllIIlIllIlIlIlIlllIII, lllllllllllllIIlIllIlIlIlIlllllI, 0.0f));
        return this;
    }
    
    public void addBox(final int[][] lllllllllllllIIlIllIlIIllllllllI, final float lllllllllllllIIlIllIlIIlllllllIl, final float lllllllllllllIIlIllIlIIlllllllII, final float lllllllllllllIIlIllIlIIlllllIIlI, final float lllllllllllllIIlIllIlIIllllllIlI, final float lllllllllllllIIlIllIlIIlllllIIII, final float lllllllllllllIIlIllIlIIllllllIII, final float lllllllllllllIIlIllIlIIlllllIlll) {
        this.cubeList.add(new ModelBox(this, lllllllllllllIIlIllIlIIllllllllI, lllllllllllllIIlIllIlIIlllllllIl, lllllllllllllIIlIllIlIIlllllllII, lllllllllllllIIlIllIlIIlllllIIlI, lllllllllllllIIlIllIlIIllllllIlI, lllllllllllllIIlIllIlIIlllllIIII, lllllllllllllIIlIllIlIIllllllIII, lllllllllllllIIlIllIlIIlllllIlll, this.mirror));
    }
    
    private void compileDisplayList(final float lllllllllllllIIlIllIlIlIIlIIlllI) {
        if (this.displayList == 0) {
            this.savedScale = lllllllllllllIIlIllIlIlIIlIIlllI;
            this.displayList = GLAllocation.generateDisplayLists(1);
        }
        GlStateManager.glNewList(this.displayList, 4864);
        final BufferBuilder lllllllllllllIIlIllIlIlIIlIIllIl = Tessellator.getInstance().getBuffer();
        for (int lllllllllllllIIlIllIlIlIIlIIllII = 0; lllllllllllllIIlIllIlIlIIlIIllII < this.cubeList.size(); ++lllllllllllllIIlIllIlIlIIlIIllII) {
            this.cubeList.get(lllllllllllllIIlIllIlIlIIlIIllII).render(lllllllllllllIIlIllIlIlIIlIIllIl, lllllllllllllIIlIllIlIlIIlIIlllI);
        }
        for (int lllllllllllllIIlIllIlIlIIlIIlIll = 0; lllllllllllllIIlIllIlIlIIlIIlIll < this.spriteList.size(); ++lllllllllllllIIlIllIlIlIIlIIlIll) {
            final ModelSprite lllllllllllllIIlIllIlIlIIlIIlIlI = this.spriteList.get(lllllllllllllIIlIllIlIlIIlIIlIll);
            lllllllllllllIIlIllIlIlIIlIIlIlI.render(Tessellator.getInstance(), lllllllllllllIIlIllIlIlIIlIIlllI);
        }
        GlStateManager.glEndList();
        this.compiled = true;
    }
    
    public int getDisplayList() {
        return this.displayList;
    }
    
    public void setTextureLocation(final ResourceLocation lllllllllllllIIlIllIlIlIIIIlIlII) {
        this.textureLocation = lllllllllllllIIlIllIlIlIIIIlIlII;
    }
    
    public void renderWithRotation(final float lllllllllllllIIlIllIlIlIIlIllllI) {
        if (!this.isHidden && this.showModel) {
            if (!this.compiled) {
                this.compileDisplayList(lllllllllllllIIlIllIlIlIIlIllllI);
            }
            int lllllllllllllIIlIllIlIlIIllIIIlI = 0;
            if (this.textureLocation != null && !this.renderGlobal.renderOverlayDamaged) {
                if (this.renderGlobal.renderOverlayEyes) {
                    return;
                }
                lllllllllllllIIlIllIlIlIIllIIIlI = GlStateManager.getBoundTexture();
                Config.getTextureManager().bindTexture(this.textureLocation);
            }
            if (this.modelUpdater != null) {
                this.modelUpdater.update();
            }
            final boolean lllllllllllllIIlIllIlIlIIllIIIIl = this.scaleX != 1.0f || this.scaleY != 1.0f || this.scaleZ != 1.0f;
            GlStateManager.pushMatrix();
            GlStateManager.translate(this.rotationPointX * lllllllllllllIIlIllIlIlIIlIllllI, this.rotationPointY * lllllllllllllIIlIllIlIlIIlIllllI, this.rotationPointZ * lllllllllllllIIlIllIlIlIIlIllllI);
            if (this.rotateAngleY != 0.0f) {
                GlStateManager.rotate(this.rotateAngleY * 57.295776f, 0.0f, 1.0f, 0.0f);
            }
            if (this.rotateAngleX != 0.0f) {
                GlStateManager.rotate(this.rotateAngleX * 57.295776f, 1.0f, 0.0f, 0.0f);
            }
            if (this.rotateAngleZ != 0.0f) {
                GlStateManager.rotate(this.rotateAngleZ * 57.295776f, 0.0f, 0.0f, 1.0f);
            }
            if (lllllllllllllIIlIllIlIlIIllIIIIl) {
                GlStateManager.scale(this.scaleX, this.scaleY, this.scaleZ);
            }
            GlStateManager.callList(this.displayList);
            if (this.childModels != null) {
                for (int lllllllllllllIIlIllIlIlIIllIIIII = 0; lllllllllllllIIlIllIlIlIIllIIIII < this.childModels.size(); ++lllllllllllllIIlIllIlIlIIllIIIII) {
                    this.childModels.get(lllllllllllllIIlIllIlIlIIllIIIII).render(lllllllllllllIIlIllIlIlIIlIllllI);
                }
            }
            GlStateManager.popMatrix();
            if (lllllllllllllIIlIllIlIlIIllIIIlI != 0) {
                GlStateManager.bindTexture(lllllllllllllIIlIllIlIlIIllIIIlI);
            }
        }
    }
    
    public void addBox(final float lllllllllllllIIlIllIlIlIlIIIllIl, final float lllllllllllllIIlIllIlIlIlIIlIlII, final float lllllllllllllIIlIllIlIlIlIIIlIll, final int lllllllllllllIIlIllIlIlIlIIIlIlI, final int lllllllllllllIIlIllIlIlIlIIlIIIl, final int lllllllllllllIIlIllIlIlIlIIlIIII, final float lllllllllllllIIlIllIlIlIlIIIllll) {
        this.cubeList.add(new ModelBox(this, this.textureOffsetX, this.textureOffsetY, lllllllllllllIIlIllIlIlIlIIIllIl, lllllllllllllIIlIllIlIlIlIIlIlII, lllllllllllllIIlIllIlIlIlIIIlIll, lllllllllllllIIlIllIlIlIlIIIlIlI, lllllllllllllIIlIllIlIlIlIIlIIIl, lllllllllllllIIlIllIlIlIlIIlIIII, lllllllllllllIIlIllIlIlIlIIIllll));
    }
    
    public ModelRenderer(final ModelBase lllllllllllllIIlIllIlIllIlIIIIII) {
        this(lllllllllllllIIlIllIlIllIlIIIIII, null);
    }
    
    public void postRender(final float lllllllllllllIIlIllIlIlIIlIlIlIl) {
        if (!this.isHidden && this.showModel) {
            if (!this.compiled) {
                this.compileDisplayList(lllllllllllllIIlIllIlIlIIlIlIlIl);
            }
            if (this.rotateAngleX == 0.0f && this.rotateAngleY == 0.0f && this.rotateAngleZ == 0.0f) {
                if (this.rotationPointX != 0.0f || this.rotationPointY != 0.0f || this.rotationPointZ != 0.0f) {
                    GlStateManager.translate(this.rotationPointX * lllllllllllllIIlIllIlIlIIlIlIlIl, this.rotationPointY * lllllllllllllIIlIllIlIlIIlIlIlIl, this.rotationPointZ * lllllllllllllIIlIllIlIlIIlIlIlIl);
                }
            }
            else {
                GlStateManager.translate(this.rotationPointX * lllllllllllllIIlIllIlIlIIlIlIlIl, this.rotationPointY * lllllllllllllIIlIllIlIlIIlIlIlIl, this.rotationPointZ * lllllllllllllIIlIllIlIlIIlIlIlIl);
                if (this.rotateAngleZ != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleZ * 57.295776f, 0.0f, 0.0f, 1.0f);
                }
                if (this.rotateAngleY != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleY * 57.295776f, 0.0f, 1.0f, 0.0f);
                }
                if (this.rotateAngleX != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleX * 57.295776f, 1.0f, 0.0f, 0.0f);
                }
            }
        }
    }
    
    public String getId() {
        return this.id;
    }
    
    public void addChild(final ModelRenderer lllllllllllllIIlIllIlIllIIIlIlIl) {
        if (this.childModels == null) {
            this.childModels = (List<ModelRenderer>)Lists.newArrayList();
        }
        this.childModels.add(lllllllllllllIIlIllIlIllIIIlIlIl);
    }
    
    public ModelRenderer addBox(String lllllllllllllIIlIllIlIlIlllIIIII, final float lllllllllllllIIlIllIlIlIllllIIII, final float lllllllllllllIIlIllIlIlIllIlllIl, final float lllllllllllllIIlIllIlIlIllIllIll, final int lllllllllllllIIlIllIlIlIllIllIlI, final int lllllllllllllIIlIllIlIlIlllIlIIl, final int lllllllllllllIIlIllIlIlIllIllIII) {
        lllllllllllllIIlIllIlIlIlllIIIII = String.valueOf(new StringBuilder(String.valueOf(this.boxName)).append(".").append(lllllllllllllIIlIllIlIlIlllIIIII));
        final TextureOffset lllllllllllllIIlIllIlIlIlllIIlII = this.baseModel.getTextureOffset(lllllllllllllIIlIllIlIlIlllIIIII);
        this.setTextureOffset(lllllllllllllIIlIllIlIlIlllIIlII.textureOffsetX, lllllllllllllIIlIllIlIlIlllIIlII.textureOffsetY);
        this.cubeList.add(new ModelBox(this, this.textureOffsetX, this.textureOffsetY, lllllllllllllIIlIllIlIlIllllIIII, lllllllllllllIIlIllIlIlIllIlllIl, lllllllllllllIIlIllIlIlIllIllIll, lllllllllllllIIlIllIlIlIllIllIlI, lllllllllllllIIlIllIlIlIlllIlIIl, lllllllllllllIIlIllIlIlIllIllIII, 0.0f).setBoxName(lllllllllllllIIlIllIlIlIlllIIIII));
        return this;
    }
    
    public ModelRenderer getChild(final String lllllllllllllIIlIllIlIIllllIlIII) {
        if (lllllllllllllIIlIllIlIIllllIlIII == null) {
            return null;
        }
        if (this.childModels != null) {
            for (int lllllllllllllIIlIllIlIIllllIIlll = 0; lllllllllllllIIlIllIlIIllllIIlll < this.childModels.size(); ++lllllllllllllIIlIllIlIIllllIIlll) {
                final ModelRenderer lllllllllllllIIlIllIlIIllllIIllI = this.childModels.get(lllllllllllllIIlIllIlIIllllIIlll);
                if (lllllllllllllIIlIllIlIIllllIlIII.equals(lllllllllllllIIlIllIlIIllllIIllI.getId())) {
                    return lllllllllllllIIlIllIlIIllllIIllI;
                }
            }
        }
        return null;
    }
    
    public ModelRenderer(final ModelBase lllllllllllllIIlIllIlIllIIlIlllI, final int lllllllllllllIIlIllIlIllIIlIllIl, final int lllllllllllllIIlIllIlIllIIlIllII) {
        this(lllllllllllllIIlIllIlIllIIlIlllI);
        this.setTextureOffset(lllllllllllllIIlIllIlIllIIlIllIl, lllllllllllllIIlIllIlIllIIlIllII);
    }
}
