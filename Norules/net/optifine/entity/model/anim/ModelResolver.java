package net.optifine.entity.model.anim;

import net.minecraft.client.model.*;
import net.optifine.entity.model.*;
import optifine.*;
import net.minecraft.tileentity.*;

public class ModelResolver implements IModelResolver
{
    private /* synthetic */ ModelRenderer thisModelRenderer;
    private /* synthetic */ CustomModelRenderer[] customModelRenderers;
    private /* synthetic */ ModelBase model;
    private /* synthetic */ IRenderResolver renderResolver;
    private /* synthetic */ ModelAdapter modelAdapter;
    private /* synthetic */ ModelRenderer partModelRenderer;
    
    public void setThisModelRenderer(final ModelRenderer llllllllllllIlllllIlllIllIlIllIl) {
        this.thisModelRenderer = llllllllllllIlllllIlllIllIlIllIl;
    }
    
    @Override
    public ModelRenderer getModelRenderer(final String llllllllllllIlllllIlllIlllIlllIl) {
        if (llllllllllllIlllllIlllIlllIlllIl == null) {
            return null;
        }
        if (llllllllllllIlllllIlllIlllIlllIl.indexOf(":") >= 0) {
            final String[] llllllllllllIlllllIlllIlllIlllII = Config.tokenize(llllllllllllIlllllIlllIlllIlllIl, ":");
            ModelRenderer llllllllllllIlllllIlllIlllIllIll = this.getModelRenderer(llllllllllllIlllllIlllIlllIlllII[0]);
            for (int llllllllllllIlllllIlllIlllIllIlI = 1; llllllllllllIlllllIlllIlllIllIlI < llllllllllllIlllllIlllIlllIlllII.length; ++llllllllllllIlllllIlllIlllIllIlI) {
                final String llllllllllllIlllllIlllIlllIllIIl = llllllllllllIlllllIlllIlllIlllII[llllllllllllIlllllIlllIlllIllIlI];
                final ModelRenderer llllllllllllIlllllIlllIlllIllIII = llllllllllllIlllllIlllIlllIllIll.getChildDeep(llllllllllllIlllllIlllIlllIllIIl);
                if (llllllllllllIlllllIlllIlllIllIII == null) {
                    return null;
                }
                llllllllllllIlllllIlllIlllIllIll = llllllllllllIlllllIlllIlllIllIII;
            }
            return llllllllllllIlllllIlllIlllIllIll;
        }
        if (this.thisModelRenderer != null && llllllllllllIlllllIlllIlllIlllIl.equals("this")) {
            return this.thisModelRenderer;
        }
        if (this.partModelRenderer != null && llllllllllllIlllllIlllIlllIlllIl.equals("part")) {
            return this.partModelRenderer;
        }
        final ModelRenderer llllllllllllIlllllIlllIlllIlIlll = this.modelAdapter.getModelRenderer(this.model, llllllllllllIlllllIlllIlllIlllIl);
        if (llllllllllllIlllllIlllIlllIlIlll != null) {
            return llllllllllllIlllllIlllIlllIlIlll;
        }
        for (int llllllllllllIlllllIlllIlllIlIllI = 0; llllllllllllIlllllIlllIlllIlIllI < this.customModelRenderers.length; ++llllllllllllIlllllIlllIlllIlIllI) {
            final CustomModelRenderer llllllllllllIlllllIlllIlllIlIlIl = this.customModelRenderers[llllllllllllIlllllIlllIlllIlIllI];
            final ModelRenderer llllllllllllIlllllIlllIlllIlIlII = llllllllllllIlllllIlllIlllIlIlIl.getModelRenderer();
            if (llllllllllllIlllllIlllIlllIlllIl.equals(llllllllllllIlllllIlllIlllIlIlII.getId())) {
                return llllllllllllIlllllIlllIlllIlIlII;
            }
            final ModelRenderer llllllllllllIlllllIlllIlllIlIIll = llllllllllllIlllllIlllIlllIlIlII.getChildDeep(llllllllllllIlllllIlllIlllIlllIl);
            if (llllllllllllIlllllIlllIlllIlIIll != null) {
                return llllllllllllIlllllIlllIlllIlIIll;
            }
        }
        return null;
    }
    
    @Override
    public IExpression getExpression(final String llllllllllllIlllllIlllIllllIlIII) {
        final ModelVariable llllllllllllIlllllIlllIllllIlIll = this.getModelVariable(llllllllllllIlllllIlllIllllIlIII);
        if (llllllllllllIlllllIlllIllllIlIll != null) {
            return llllllllllllIlllllIlllIllllIlIll;
        }
        final IExpression llllllllllllIlllllIlllIllllIlIlI = this.renderResolver.getParameter(llllllllllllIlllllIlllIllllIlIII);
        return (llllllllllllIlllllIlllIllllIlIlI != null) ? llllllllllllIlllllIlllIllllIlIlI : null;
    }
    
    public ModelResolver(final ModelAdapter llllllllllllIlllllIlllIlllllIlIl, final ModelBase llllllllllllIlllllIlllIlllllIlII, final CustomModelRenderer[] llllllllllllIlllllIlllIlllllIIll) {
        this.modelAdapter = llllllllllllIlllllIlllIlllllIlIl;
        this.model = llllllllllllIlllllIlllIlllllIlII;
        this.customModelRenderers = llllllllllllIlllllIlllIlllllIIll;
        final Class llllllllllllIlllllIlllIlllllIlll = llllllllllllIlllllIlllIlllllIlIl.getEntityClass();
        if (TileEntity.class.isAssignableFrom(llllllllllllIlllllIlllIlllllIlll)) {
            this.renderResolver = new RenderResolverTileEntity();
        }
        else {
            this.renderResolver = new RenderResolverEntity();
        }
    }
    
    @Override
    public ModelVariable getModelVariable(final String llllllllllllIlllllIlllIllIllllII) {
        final String[] llllllllllllIlllllIlllIlllIIIIlI = Config.tokenize(llllllllllllIlllllIlllIllIllllII, ".");
        if (llllllllllllIlllllIlllIlllIIIIlI.length != 2) {
            return null;
        }
        final String llllllllllllIlllllIlllIlllIIIIIl = llllllllllllIlllllIlllIlllIIIIlI[0];
        final String llllllllllllIlllllIlllIlllIIIIII = llllllllllllIlllllIlllIlllIIIIlI[1];
        final ModelRenderer llllllllllllIlllllIlllIllIllllll = this.getModelRenderer(llllllllllllIlllllIlllIlllIIIIIl);
        if (llllllllllllIlllllIlllIllIllllll == null) {
            return null;
        }
        final EnumModelVariable llllllllllllIlllllIlllIllIlllllI = EnumModelVariable.parse(llllllllllllIlllllIlllIlllIIIIII);
        return (llllllllllllIlllllIlllIllIlllllI == null) ? null : new ModelVariable(llllllllllllIlllllIlllIllIllllII, llllllllllllIlllllIlllIllIllllll, llllllllllllIlllllIlllIllIlllllI);
    }
    
    public void setPartModelRenderer(final ModelRenderer llllllllllllIlllllIlllIllIllIIll) {
        this.partModelRenderer = llllllllllllIlllllIlllIllIllIIll;
    }
}
