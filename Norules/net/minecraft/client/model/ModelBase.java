package net.minecraft.client.model;

import java.util.*;
import net.minecraft.entity.*;
import com.google.common.collect.*;

public abstract class ModelBase
{
    public /* synthetic */ boolean isRiding;
    public /* synthetic */ int textureWidth;
    private final /* synthetic */ Map<String, TextureOffset> modelTextureMap;
    public /* synthetic */ float swingProgress;
    public /* synthetic */ boolean isChild;
    public /* synthetic */ int textureHeight;
    public /* synthetic */ List<ModelRenderer> boxList;
    
    public void setLivingAnimations(final EntityLivingBase llllllllllllllIlllIIIIlIIIlIllll, final float llllllllllllllIlllIIIIlIIIlIlllI, final float llllllllllllllIlllIIIIlIIIlIllIl, final float llllllllllllllIlllIIIIlIIIlIllII) {
    }
    
    public ModelRenderer getRandomModelBox(final Random llllllllllllllIlllIIIIlIIIlIIllI) {
        return this.boxList.get(llllllllllllllIlllIIIIlIIIlIIllI.nextInt(this.boxList.size()));
    }
    
    public void setRotationAngles(final float llllllllllllllIlllIIIIlIIIllIlll, final float llllllllllllllIlllIIIIlIIIllIllI, final float llllllllllllllIlllIIIIlIIIllIlIl, final float llllllllllllllIlllIIIIlIIIllIlII, final float llllllllllllllIlllIIIIlIIIllIIll, final float llllllllllllllIlllIIIIlIIIllIIlI, final Entity llllllllllllllIlllIIIIlIIIllIIIl) {
    }
    
    public void render(final Entity llllllllllllllIlllIIIIlIIIllllll, final float llllllllllllllIlllIIIIlIIIlllllI, final float llllllllllllllIlllIIIIlIIIllllIl, final float llllllllllllllIlllIIIIlIIIllllII, final float llllllllllllllIlllIIIIlIIIlllIll, final float llllllllllllllIlllIIIIlIIIlllIlI, final float llllllllllllllIlllIIIIlIIIlllIIl) {
    }
    
    protected void setTextureOffset(final String llllllllllllllIlllIIIIlIIIIlllII, final int llllllllllllllIlllIIIIlIIIIlllll, final int llllllllllllllIlllIIIIlIIIIllIlI) {
        this.modelTextureMap.put(llllllllllllllIlllIIIIlIIIIlllII, new TextureOffset(llllllllllllllIlllIIIIlIIIIlllll, llllllllllllllIlllIIIIlIIIIllIlI));
    }
    
    public TextureOffset getTextureOffset(final String llllllllllllllIlllIIIIlIIIIlIllI) {
        return this.modelTextureMap.get(llllllllllllllIlllIIIIlIIIIlIllI);
    }
    
    public static void copyModelAngles(final ModelRenderer llllllllllllllIlllIIIIlIIIIlIIIl, final ModelRenderer llllllllllllllIlllIIIIlIIIIIlllI) {
        llllllllllllllIlllIIIIlIIIIIlllI.rotateAngleX = llllllllllllllIlllIIIIlIIIIlIIIl.rotateAngleX;
        llllllllllllllIlllIIIIlIIIIIlllI.rotateAngleY = llllllllllllllIlllIIIIlIIIIlIIIl.rotateAngleY;
        llllllllllllllIlllIIIIlIIIIIlllI.rotateAngleZ = llllllllllllllIlllIIIIlIIIIlIIIl.rotateAngleZ;
        llllllllllllllIlllIIIIlIIIIIlllI.rotationPointX = llllllllllllllIlllIIIIlIIIIlIIIl.rotationPointX;
        llllllllllllllIlllIIIIlIIIIIlllI.rotationPointY = llllllllllllllIlllIIIIlIIIIlIIIl.rotationPointY;
        llllllllllllllIlllIIIIlIIIIIlllI.rotationPointZ = llllllllllllllIlllIIIIlIIIIlIIIl.rotationPointZ;
    }
    
    public void setModelAttributes(final ModelBase llllllllllllllIlllIIIIlIIIIIlIlI) {
        this.swingProgress = llllllllllllllIlllIIIIlIIIIIlIlI.swingProgress;
        this.isRiding = llllllllllllllIlllIIIIlIIIIIlIlI.isRiding;
        this.isChild = llllllllllllllIlllIIIIlIIIIIlIlI.isChild;
    }
    
    public ModelBase() {
        this.isChild = true;
        this.boxList = (List<ModelRenderer>)Lists.newArrayList();
        this.modelTextureMap = (Map<String, TextureOffset>)Maps.newHashMap();
        this.textureWidth = 64;
        this.textureHeight = 32;
    }
}
