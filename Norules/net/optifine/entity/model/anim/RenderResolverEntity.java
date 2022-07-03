package net.optifine.entity.model.anim;

public class RenderResolverEntity implements IRenderResolver
{
    @Override
    public IExpression getParameter(final String lllllllllllllIIlllIIlIIllIlllIll) {
        final EnumRenderParameterEntity lllllllllllllIIlllIIlIIllIlllIlI = EnumRenderParameterEntity.parse(lllllllllllllIIlllIIlIIllIlllIll);
        return lllllllllllllIIlllIIlIIllIlllIlI;
    }
}
