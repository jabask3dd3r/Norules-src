package net.minecraft.client.renderer;

import net.minecraft.client.renderer.color.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import shadersmod.client.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import optifine.*;
import net.minecraft.block.*;

public class BlockFluidRenderer
{
    private /* synthetic */ TextureAtlasSprite atlasSpriteWaterOverlay;
    private final /* synthetic */ TextureAtlasSprite[] atlasSpritesWater;
    private final /* synthetic */ TextureAtlasSprite[] atlasSpritesLava;
    private final /* synthetic */ BlockColors blockColors;
    
    public BlockFluidRenderer(final BlockColors llllllllllllllIlIlllllIIlllllIIl) {
        this.atlasSpritesLava = new TextureAtlasSprite[2];
        this.atlasSpritesWater = new TextureAtlasSprite[2];
        this.blockColors = llllllllllllllIlIlllllIIlllllIIl;
        this.initAtlasSprites();
    }
    
    protected void initAtlasSprites() {
        final TextureMap llllllllllllllIlIlllllIIllllIIll = Minecraft.getMinecraft().getTextureMapBlocks();
        this.atlasSpritesLava[0] = llllllllllllllIlIlllllIIllllIIll.getAtlasSprite("minecraft:blocks/lava_still");
        this.atlasSpritesLava[1] = llllllllllllllIlIlllllIIllllIIll.getAtlasSprite("minecraft:blocks/lava_flow");
        this.atlasSpritesWater[0] = llllllllllllllIlIlllllIIllllIIll.getAtlasSprite("minecraft:blocks/water_still");
        this.atlasSpritesWater[1] = llllllllllllllIlIlllllIIllllIIll.getAtlasSprite("minecraft:blocks/water_flow");
        this.atlasSpriteWaterOverlay = llllllllllllllIlIlllllIIllllIIll.getAtlasSprite("minecraft:blocks/water_overlay");
    }
    
    private float getFluidHeight(final IBlockAccess llllllllllllllIlIllllIllllllIllI, final BlockPos llllllllllllllIlIllllIllllllIlIl, final Material llllllllllllllIlIllllIlllllIlIlI) {
        int llllllllllllllIlIllllIllllllIIll = 0;
        float llllllllllllllIlIllllIllllllIIlI = 0.0f;
        for (int llllllllllllllIlIllllIllllllIIIl = 0; llllllllllllllIlIllllIllllllIIIl < 4; ++llllllllllllllIlIllllIllllllIIIl) {
            final BlockPos llllllllllllllIlIllllIllllllIIII = llllllllllllllIlIllllIllllllIlIl.add(-(llllllllllllllIlIllllIllllllIIIl & 0x1), 0, -(llllllllllllllIlIllllIllllllIIIl >> 1 & 0x1));
            if (llllllllllllllIlIllllIllllllIllI.getBlockState(llllllllllllllIlIllllIllllllIIII.up()).getMaterial() == llllllllllllllIlIllllIlllllIlIlI) {
                return 1.0f;
            }
            final IBlockState llllllllllllllIlIllllIlllllIllll = llllllllllllllIlIllllIllllllIllI.getBlockState(llllllllllllllIlIllllIllllllIIII);
            final Material llllllllllllllIlIllllIlllllIlllI = llllllllllllllIlIllllIlllllIllll.getMaterial();
            if (llllllllllllllIlIllllIlllllIlllI != llllllllllllllIlIllllIlllllIlIlI) {
                if (!llllllllllllllIlIllllIlllllIlllI.isSolid()) {
                    ++llllllllllllllIlIllllIllllllIIlI;
                    ++llllllllllllllIlIllllIllllllIIll;
                }
            }
            else {
                final int llllllllllllllIlIllllIlllllIllIl = llllllllllllllIlIllllIlllllIllll.getValue((IProperty<Integer>)BlockLiquid.LEVEL);
                if (llllllllllllllIlIllllIlllllIllIl >= 8 || llllllllllllllIlIllllIlllllIllIl == 0) {
                    llllllllllllllIlIllllIllllllIIlI += BlockLiquid.getLiquidHeightPercent(llllllllllllllIlIllllIlllllIllIl) * 10.0f;
                    llllllllllllllIlIllllIllllllIIll += 10;
                }
                llllllllllllllIlIllllIllllllIIlI += BlockLiquid.getLiquidHeightPercent(llllllllllllllIlIllllIlllllIllIl);
                ++llllllllllllllIlIllllIllllllIIll;
            }
        }
        return 1.0f - llllllllllllllIlIllllIllllllIIlI / llllllllllllllIlIllllIllllllIIll;
    }
    
    public boolean renderFluid(final IBlockAccess llllllllllllllIlIlllllIIIIlllllI, final IBlockState llllllllllllllIlIlllllIIlIllIIII, final BlockPos llllllllllllllIlIlllllIIIIllllII, final BufferBuilder llllllllllllllIlIlllllIIlIlIlllI) {
        try {
            if (Config.isShaders()) {
                SVertexBuilder.pushEntity(llllllllllllllIlIlllllIIlIllIIII, llllllllllllllIlIlllllIIIIllllII, llllllllllllllIlIlllllIIIIlllllI, llllllllllllllIlIlllllIIlIlIlllI);
            }
            final BlockLiquid llllllllllllllIlIlllllIIlIlIlIlI = (BlockLiquid)llllllllllllllIlIlllllIIlIllIIII.getBlock();
            final boolean llllllllllllllIlIlllllIIlIlIlIIl = llllllllllllllIlIlllllIIlIllIIII.getMaterial() == Material.LAVA;
            final TextureAtlasSprite[] llllllllllllllIlIlllllIIlIlIlIII = llllllllllllllIlIlllllIIlIlIlIIl ? this.atlasSpritesLava : this.atlasSpritesWater;
            final RenderEnv llllllllllllllIlIlllllIIlIlIIlll = llllllllllllllIlIlllllIIlIlIlllI.getRenderEnv(llllllllllllllIlIlllllIIIIlllllI, llllllllllllllIlIlllllIIlIllIIII, llllllllllllllIlIlllllIIIIllllII);
            final int llllllllllllllIlIlllllIIlIlIIllI = CustomColors.getFluidColor(llllllllllllllIlIlllllIIIIlllllI, llllllllllllllIlIlllllIIlIllIIII, llllllllllllllIlIlllllIIIIllllII, llllllllllllllIlIlllllIIlIlIIlll);
            final float llllllllllllllIlIlllllIIlIlIIlIl = (llllllllllllllIlIlllllIIlIlIIllI >> 16 & 0xFF) / 255.0f;
            final float llllllllllllllIlIlllllIIlIlIIlII = (llllllllllllllIlIlllllIIlIlIIllI >> 8 & 0xFF) / 255.0f;
            final float llllllllllllllIlIlllllIIlIlIIIll = (llllllllllllllIlIlllllIIlIlIIllI & 0xFF) / 255.0f;
            final boolean llllllllllllllIlIlllllIIlIlIIIlI = llllllllllllllIlIlllllIIlIllIIII.shouldSideBeRendered(llllllllllllllIlIlllllIIIIlllllI, llllllllllllllIlIlllllIIIIllllII, EnumFacing.UP);
            final boolean llllllllllllllIlIlllllIIlIlIIIIl = llllllllllllllIlIlllllIIlIllIIII.shouldSideBeRendered(llllllllllllllIlIlllllIIIIlllllI, llllllllllllllIlIlllllIIIIllllII, EnumFacing.DOWN);
            final boolean[] llllllllllllllIlIlllllIIlIlIIIII = llllllllllllllIlIlllllIIlIlIIlll.getBorderFlags();
            llllllllllllllIlIlllllIIlIlIIIII[0] = llllllllllllllIlIlllllIIlIllIIII.shouldSideBeRendered(llllllllllllllIlIlllllIIIIlllllI, llllllllllllllIlIlllllIIIIllllII, EnumFacing.NORTH);
            llllllllllllllIlIlllllIIlIlIIIII[1] = llllllllllllllIlIlllllIIlIllIIII.shouldSideBeRendered(llllllllllllllIlIlllllIIIIlllllI, llllllllllllllIlIlllllIIIIllllII, EnumFacing.SOUTH);
            llllllllllllllIlIlllllIIlIlIIIII[2] = llllllllllllllIlIlllllIIlIllIIII.shouldSideBeRendered(llllllllllllllIlIlllllIIIIlllllI, llllllllllllllIlIlllllIIIIllllII, EnumFacing.WEST);
            llllllllllllllIlIlllllIIlIlIIIII[3] = llllllllllllllIlIlllllIIlIllIIII.shouldSideBeRendered(llllllllllllllIlIlllllIIIIlllllI, llllllllllllllIlIlllllIIIIllllII, EnumFacing.EAST);
            if (llllllllllllllIlIlllllIIlIlIIIlI || llllllllllllllIlIlllllIIlIlIIIIl || llllllllllllllIlIlllllIIlIlIIIII[0] || llllllllllllllIlIlllllIIlIlIIIII[1] || llllllllllllllIlIlllllIIlIlIIIII[2] || llllllllllllllIlIlllllIIlIlIIIII[3]) {
                boolean llllllllllllllIlIlllllIIlIlIllIl = false;
                final float llllllllllllllIlIlllllIIlIIlllll = 0.5f;
                final float llllllllllllllIlIlllllIIlIIllllI = 1.0f;
                final float llllllllllllllIlIlllllIIlIIlllIl = 0.8f;
                final float llllllllllllllIlIlllllIIlIIlllII = 0.6f;
                final Material llllllllllllllIlIlllllIIlIIllIll = llllllllllllllIlIlllllIIlIllIIII.getMaterial();
                float llllllllllllllIlIlllllIIlIIllIlI = this.getFluidHeight(llllllllllllllIlIlllllIIIIlllllI, llllllllllllllIlIlllllIIIIllllII, llllllllllllllIlIlllllIIlIIllIll);
                float llllllllllllllIlIlllllIIlIIllIIl = this.getFluidHeight(llllllllllllllIlIlllllIIIIlllllI, llllllllllllllIlIlllllIIIIllllII.south(), llllllllllllllIlIlllllIIlIIllIll);
                float llllllllllllllIlIlllllIIlIIllIII = this.getFluidHeight(llllllllllllllIlIlllllIIIIlllllI, llllllllllllllIlIlllllIIIIllllII.east().south(), llllllllllllllIlIlllllIIlIIllIll);
                float llllllllllllllIlIlllllIIlIIlIlll = this.getFluidHeight(llllllllllllllIlIlllllIIIIlllllI, llllllllllllllIlIlllllIIIIllllII.east(), llllllllllllllIlIlllllIIlIIllIll);
                final double llllllllllllllIlIlllllIIlIIlIllI = llllllllllllllIlIlllllIIIIllllII.getX();
                final double llllllllllllllIlIlllllIIlIIlIlIl = llllllllllllllIlIlllllIIIIllllII.getY();
                final double llllllllllllllIlIlllllIIlIIlIlII = llllllllllllllIlIlllllIIIIllllII.getZ();
                final float llllllllllllllIlIlllllIIlIIlIIll = 0.001f;
                if (llllllllllllllIlIlllllIIlIlIIIlI) {
                    llllllllllllllIlIlllllIIlIlIllIl = true;
                    final float llllllllllllllIlIlllllIIlIIlIIlI = BlockLiquid.getSlopeAngle(llllllllllllllIlIlllllIIIIlllllI, llllllllllllllIlIlllllIIIIllllII, llllllllllllllIlIlllllIIlIIllIll, llllllllllllllIlIlllllIIlIllIIII);
                    final TextureAtlasSprite llllllllllllllIlIlllllIIlIIlIIIl = (llllllllllllllIlIlllllIIlIIlIIlI > -999.0f) ? llllllllllllllIlIlllllIIlIlIlIII[1] : llllllllllllllIlIlllllIIlIlIlIII[0];
                    llllllllllllllIlIlllllIIlIlIlllI.setSprite(llllllllllllllIlIlllllIIlIIlIIIl);
                    llllllllllllllIlIlllllIIlIIllIlI -= 0.001f;
                    llllllllllllllIlIlllllIIlIIllIIl -= 0.001f;
                    llllllllllllllIlIlllllIIlIIllIII -= 0.001f;
                    llllllllllllllIlIlllllIIlIIlIlll -= 0.001f;
                    float llllllllllllllIlIlllllIIlIIIllll = 0.0f;
                    float llllllllllllllIlIlllllIIlIIIIlll = 0.0f;
                    float llllllllllllllIlIlllllIIlIIIllIl = 0.0f;
                    float llllllllllllllIlIlllllIIlIIIIlIl = 0.0f;
                    float llllllllllllllIlIlllllIIlIIIlIll = 0.0f;
                    float llllllllllllllIlIlllllIIlIIIIIll = 0.0f;
                    float llllllllllllllIlIlllllIIlIIIlIIl = 0.0f;
                    float llllllllllllllIlIlllllIIlIIIIIIl = 0.0f;
                    if (llllllllllllllIlIlllllIIlIIlIIlI < -999.0f) {
                        final float llllllllllllllIlIlllllIIlIIlIIII = llllllllllllllIlIlllllIIlIIlIIIl.getInterpolatedU(0.0);
                        final float llllllllllllllIlIlllllIIlIIIlIII = llllllllllllllIlIlllllIIlIIlIIIl.getInterpolatedV(0.0);
                        final float llllllllllllllIlIlllllIIlIIIlllI = llllllllllllllIlIlllllIIlIIlIIII;
                        final float llllllllllllllIlIlllllIIlIIIIllI = llllllllllllllIlIlllllIIlIIlIIIl.getInterpolatedV(16.0);
                        final float llllllllllllllIlIlllllIIlIIIllII = llllllllllllllIlIlllllIIlIIlIIIl.getInterpolatedU(16.0);
                        final float llllllllllllllIlIlllllIIlIIIIlII = llllllllllllllIlIlllllIIlIIIIllI;
                        final float llllllllllllllIlIlllllIIlIIIlIlI = llllllllllllllIlIlllllIIlIIIllII;
                        final float llllllllllllllIlIlllllIIlIIIIIlI = llllllllllllllIlIlllllIIlIIIlIII;
                    }
                    else {
                        final float llllllllllllllIlIlllllIIlIIIIIII = MathHelper.sin(llllllllllllllIlIlllllIIlIIlIIlI) * 0.25f;
                        final float llllllllllllllIlIlllllIIIlllllll = MathHelper.cos(llllllllllllllIlIlllllIIlIIlIIlI) * 0.25f;
                        final float llllllllllllllIlIlllllIIIllllllI = 8.0f;
                        llllllllllllllIlIlllllIIlIIIllll = llllllllllllllIlIlllllIIlIIlIIIl.getInterpolatedU(8.0f + (-llllllllllllllIlIlllllIIIlllllll - llllllllllllllIlIlllllIIlIIIIIII) * 16.0f);
                        llllllllllllllIlIlllllIIlIIIIlll = llllllllllllllIlIlllllIIlIIlIIIl.getInterpolatedV(8.0f + (-llllllllllllllIlIlllllIIIlllllll + llllllllllllllIlIlllllIIlIIIIIII) * 16.0f);
                        llllllllllllllIlIlllllIIlIIIllIl = llllllllllllllIlIlllllIIlIIlIIIl.getInterpolatedU(8.0f + (-llllllllllllllIlIlllllIIIlllllll + llllllllllllllIlIlllllIIlIIIIIII) * 16.0f);
                        llllllllllllllIlIlllllIIlIIIIlIl = llllllllllllllIlIlllllIIlIIlIIIl.getInterpolatedV(8.0f + (llllllllllllllIlIlllllIIIlllllll + llllllllllllllIlIlllllIIlIIIIIII) * 16.0f);
                        llllllllllllllIlIlllllIIlIIIlIll = llllllllllllllIlIlllllIIlIIlIIIl.getInterpolatedU(8.0f + (llllllllllllllIlIlllllIIIlllllll + llllllllllllllIlIlllllIIlIIIIIII) * 16.0f);
                        llllllllllllllIlIlllllIIlIIIIIll = llllllllllllllIlIlllllIIlIIlIIIl.getInterpolatedV(8.0f + (llllllllllllllIlIlllllIIIlllllll - llllllllllllllIlIlllllIIlIIIIIII) * 16.0f);
                        llllllllllllllIlIlllllIIlIIIlIIl = llllllllllllllIlIlllllIIlIIlIIIl.getInterpolatedU(8.0f + (llllllllllllllIlIlllllIIIlllllll - llllllllllllllIlIlllllIIlIIIIIII) * 16.0f);
                        llllllllllllllIlIlllllIIlIIIIIIl = llllllllllllllIlIlllllIIlIIlIIIl.getInterpolatedV(8.0f + (-llllllllllllllIlIlllllIIIlllllll - llllllllllllllIlIlllllIIlIIIIIII) * 16.0f);
                    }
                    final int llllllllllllllIlIlllllIIIlllllIl = llllllllllllllIlIlllllIIlIllIIII.getPackedLightmapCoords(llllllllllllllIlIlllllIIIIlllllI, llllllllllllllIlIlllllIIIIllllII);
                    final int llllllllllllllIlIlllllIIIlllllII = llllllllllllllIlIlllllIIIlllllIl >> 16 & 0xFFFF;
                    final int llllllllllllllIlIlllllIIIllllIll = llllllllllllllIlIlllllIIIlllllIl & 0xFFFF;
                    final float llllllllllllllIlIlllllIIIllllIlI = 1.0f * llllllllllllllIlIlllllIIlIlIIlIl;
                    final float llllllllllllllIlIlllllIIIllllIIl = 1.0f * llllllllllllllIlIlllllIIlIlIIlII;
                    final float llllllllllllllIlIlllllIIIllllIII = 1.0f * llllllllllllllIlIlllllIIlIlIIIll;
                    llllllllllllllIlIlllllIIlIlIlllI.pos(llllllllllllllIlIlllllIIlIIlIllI + 0.0, llllllllllllllIlIlllllIIlIIlIlIl + llllllllllllllIlIlllllIIlIIllIlI, llllllllllllllIlIlllllIIlIIlIlII + 0.0).color(llllllllllllllIlIlllllIIIllllIlI, llllllllllllllIlIlllllIIIllllIIl, llllllllllllllIlIlllllIIIllllIII, 1.0f).tex(llllllllllllllIlIlllllIIlIIIllll, llllllllllllllIlIlllllIIlIIIIlll).lightmap(llllllllllllllIlIlllllIIIlllllII, llllllllllllllIlIlllllIIIllllIll).endVertex();
                    llllllllllllllIlIlllllIIlIlIlllI.pos(llllllllllllllIlIlllllIIlIIlIllI + 0.0, llllllllllllllIlIlllllIIlIIlIlIl + llllllllllllllIlIlllllIIlIIllIIl, llllllllllllllIlIlllllIIlIIlIlII + 1.0).color(llllllllllllllIlIlllllIIIllllIlI, llllllllllllllIlIlllllIIIllllIIl, llllllllllllllIlIlllllIIIllllIII, 1.0f).tex(llllllllllllllIlIlllllIIlIIIllIl, llllllllllllllIlIlllllIIlIIIIlIl).lightmap(llllllllllllllIlIlllllIIIlllllII, llllllllllllllIlIlllllIIIllllIll).endVertex();
                    llllllllllllllIlIlllllIIlIlIlllI.pos(llllllllllllllIlIlllllIIlIIlIllI + 1.0, llllllllllllllIlIlllllIIlIIlIlIl + llllllllllllllIlIlllllIIlIIllIII, llllllllllllllIlIlllllIIlIIlIlII + 1.0).color(llllllllllllllIlIlllllIIIllllIlI, llllllllllllllIlIlllllIIIllllIIl, llllllllllllllIlIlllllIIIllllIII, 1.0f).tex(llllllllllllllIlIlllllIIlIIIlIll, llllllllllllllIlIlllllIIlIIIIIll).lightmap(llllllllllllllIlIlllllIIIlllllII, llllllllllllllIlIlllllIIIllllIll).endVertex();
                    llllllllllllllIlIlllllIIlIlIlllI.pos(llllllllllllllIlIlllllIIlIIlIllI + 1.0, llllllllllllllIlIlllllIIlIIlIlIl + llllllllllllllIlIlllllIIlIIlIlll, llllllllllllllIlIlllllIIlIIlIlII + 0.0).color(llllllllllllllIlIlllllIIIllllIlI, llllllllllllllIlIlllllIIIllllIIl, llllllllllllllIlIlllllIIIllllIII, 1.0f).tex(llllllllllllllIlIlllllIIlIIIlIIl, llllllllllllllIlIlllllIIlIIIIIIl).lightmap(llllllllllllllIlIlllllIIIlllllII, llllllllllllllIlIlllllIIIllllIll).endVertex();
                    if (llllllllllllllIlIlllllIIlIlIlIlI.shouldRenderSides(llllllllllllllIlIlllllIIIIlllllI, llllllllllllllIlIlllllIIIIllllII.up())) {
                        llllllllllllllIlIlllllIIlIlIlllI.pos(llllllllllllllIlIlllllIIlIIlIllI + 0.0, llllllllllllllIlIlllllIIlIIlIlIl + llllllllllllllIlIlllllIIlIIllIlI, llllllllllllllIlIlllllIIlIIlIlII + 0.0).color(llllllllllllllIlIlllllIIIllllIlI, llllllllllllllIlIlllllIIIllllIIl, llllllllllllllIlIlllllIIIllllIII, 1.0f).tex(llllllllllllllIlIlllllIIlIIIllll, llllllllllllllIlIlllllIIlIIIIlll).lightmap(llllllllllllllIlIlllllIIIlllllII, llllllllllllllIlIlllllIIIllllIll).endVertex();
                        llllllllllllllIlIlllllIIlIlIlllI.pos(llllllllllllllIlIlllllIIlIIlIllI + 1.0, llllllllllllllIlIlllllIIlIIlIlIl + llllllllllllllIlIlllllIIlIIlIlll, llllllllllllllIlIlllllIIlIIlIlII + 0.0).color(llllllllllllllIlIlllllIIIllllIlI, llllllllllllllIlIlllllIIIllllIIl, llllllllllllllIlIlllllIIIllllIII, 1.0f).tex(llllllllllllllIlIlllllIIlIIIlIIl, llllllllllllllIlIlllllIIlIIIIIIl).lightmap(llllllllllllllIlIlllllIIIlllllII, llllllllllllllIlIlllllIIIllllIll).endVertex();
                        llllllllllllllIlIlllllIIlIlIlllI.pos(llllllllllllllIlIlllllIIlIIlIllI + 1.0, llllllllllllllIlIlllllIIlIIlIlIl + llllllllllllllIlIlllllIIlIIllIII, llllllllllllllIlIlllllIIlIIlIlII + 1.0).color(llllllllllllllIlIlllllIIIllllIlI, llllllllllllllIlIlllllIIIllllIIl, llllllllllllllIlIlllllIIIllllIII, 1.0f).tex(llllllllllllllIlIlllllIIlIIIlIll, llllllllllllllIlIlllllIIlIIIIIll).lightmap(llllllllllllllIlIlllllIIIlllllII, llllllllllllllIlIlllllIIIllllIll).endVertex();
                        llllllllllllllIlIlllllIIlIlIlllI.pos(llllllllllllllIlIlllllIIlIIlIllI + 0.0, llllllllllllllIlIlllllIIlIIlIlIl + llllllllllllllIlIlllllIIlIIllIIl, llllllllllllllIlIlllllIIlIIlIlII + 1.0).color(llllllllllllllIlIlllllIIIllllIlI, llllllllllllllIlIlllllIIIllllIIl, llllllllllllllIlIlllllIIIllllIII, 1.0f).tex(llllllllllllllIlIlllllIIlIIIllIl, llllllllllllllIlIlllllIIlIIIIlIl).lightmap(llllllllllllllIlIlllllIIIlllllII, llllllllllllllIlIlllllIIIllllIll).endVertex();
                    }
                }
                if (llllllllllllllIlIlllllIIlIlIIIIl) {
                    final float llllllllllllllIlIlllllIIIlllIlll = llllllllllllllIlIlllllIIlIlIlIII[0].getMinU();
                    final float llllllllllllllIlIlllllIIIlllIllI = llllllllllllllIlIlllllIIlIlIlIII[0].getMaxU();
                    final float llllllllllllllIlIlllllIIIlllIlIl = llllllllllllllIlIlllllIIlIlIlIII[0].getMinV();
                    final float llllllllllllllIlIlllllIIIlllIlII = llllllllllllllIlIlllllIIlIlIlIII[0].getMaxV();
                    final int llllllllllllllIlIlllllIIIlllIIll = llllllllllllllIlIlllllIIlIllIIII.getPackedLightmapCoords(llllllllllllllIlIlllllIIIIlllllI, llllllllllllllIlIlllllIIIIllllII.down());
                    final int llllllllllllllIlIlllllIIIlllIIlI = llllllllllllllIlIlllllIIIlllIIll >> 16 & 0xFFFF;
                    final int llllllllllllllIlIlllllIIIlllIIIl = llllllllllllllIlIlllllIIIlllIIll & 0xFFFF;
                    llllllllllllllIlIlllllIIlIlIlllI.pos(llllllllllllllIlIlllllIIlIIlIllI, llllllllllllllIlIlllllIIlIIlIlIl, llllllllllllllIlIlllllIIlIIlIlII + 1.0).color(llllllllllllllIlIlllllIIlIlIIlIl * 0.5f, llllllllllllllIlIlllllIIlIlIIlII * 0.5f, llllllllllllllIlIlllllIIlIlIIIll * 0.5f, 1.0f).tex(llllllllllllllIlIlllllIIIlllIlll, llllllllllllllIlIlllllIIIlllIlII).lightmap(llllllllllllllIlIlllllIIIlllIIlI, llllllllllllllIlIlllllIIIlllIIIl).endVertex();
                    llllllllllllllIlIlllllIIlIlIlllI.pos(llllllllllllllIlIlllllIIlIIlIllI, llllllllllllllIlIlllllIIlIIlIlIl, llllllllllllllIlIlllllIIlIIlIlII).color(llllllllllllllIlIlllllIIlIlIIlIl * 0.5f, llllllllllllllIlIlllllIIlIlIIlII * 0.5f, llllllllllllllIlIlllllIIlIlIIIll * 0.5f, 1.0f).tex(llllllllllllllIlIlllllIIIlllIlll, llllllllllllllIlIlllllIIIlllIlIl).lightmap(llllllllllllllIlIlllllIIIlllIIlI, llllllllllllllIlIlllllIIIlllIIIl).endVertex();
                    llllllllllllllIlIlllllIIlIlIlllI.pos(llllllllllllllIlIlllllIIlIIlIllI + 1.0, llllllllllllllIlIlllllIIlIIlIlIl, llllllllllllllIlIlllllIIlIIlIlII).color(llllllllllllllIlIlllllIIlIlIIlIl * 0.5f, llllllllllllllIlIlllllIIlIlIIlII * 0.5f, llllllllllllllIlIlllllIIlIlIIIll * 0.5f, 1.0f).tex(llllllllllllllIlIlllllIIIlllIllI, llllllllllllllIlIlllllIIIlllIlIl).lightmap(llllllllllllllIlIlllllIIIlllIIlI, llllllllllllllIlIlllllIIIlllIIIl).endVertex();
                    llllllllllllllIlIlllllIIlIlIlllI.pos(llllllllllllllIlIlllllIIlIIlIllI + 1.0, llllllllllllllIlIlllllIIlIIlIlIl, llllllllllllllIlIlllllIIlIIlIlII + 1.0).color(llllllllllllllIlIlllllIIlIlIIlIl * 0.5f, llllllllllllllIlIlllllIIlIlIIlII * 0.5f, llllllllllllllIlIlllllIIlIlIIIll * 0.5f, 1.0f).tex(llllllllllllllIlIlllllIIIlllIllI, llllllllllllllIlIlllllIIIlllIlII).lightmap(llllllllllllllIlIlllllIIIlllIIlI, llllllllllllllIlIlllllIIIlllIIIl).endVertex();
                    llllllllllllllIlIlllllIIlIlIllIl = true;
                }
                for (int llllllllllllllIlIlllllIIIlllIIII = 0; llllllllllllllIlIlllllIIIlllIIII < 4; ++llllllllllllllIlIlllllIIIlllIIII) {
                    int llllllllllllllIlIlllllIIIllIllll = 0;
                    int llllllllllllllIlIlllllIIIllIlllI = 0;
                    if (llllllllllllllIlIlllllIIIlllIIII == 0) {
                        --llllllllllllllIlIlllllIIIllIlllI;
                    }
                    if (llllllllllllllIlIlllllIIIlllIIII == 1) {
                        ++llllllllllllllIlIlllllIIIllIlllI;
                    }
                    if (llllllllllllllIlIlllllIIIlllIIII == 2) {
                        --llllllllllllllIlIlllllIIIllIllll;
                    }
                    if (llllllllllllllIlIlllllIIIlllIIII == 3) {
                        ++llllllllllllllIlIlllllIIIllIllll;
                    }
                    final BlockPos llllllllllllllIlIlllllIIIllIllIl = llllllllllllllIlIlllllIIIIllllII.add(llllllllllllllIlIlllllIIIllIllll, 0, llllllllllllllIlIlllllIIIllIlllI);
                    TextureAtlasSprite llllllllllllllIlIlllllIIIllIllII = llllllllllllllIlIlllllIIlIlIlIII[1];
                    llllllllllllllIlIlllllIIlIlIlllI.setSprite(llllllllllllllIlIlllllIIIllIllII);
                    float llllllllllllllIlIlllllIIIllIlIll = 0.0f;
                    float llllllllllllllIlIlllllIIIllIlIlI = 0.0f;
                    if (!llllllllllllllIlIlllllIIlIlIlIIl) {
                        final IBlockState llllllllllllllIlIlllllIIIllIlIIl = llllllllllllllIlIlllllIIIIlllllI.getBlockState(llllllllllllllIlIlllllIIIllIllIl);
                        final Block llllllllllllllIlIlllllIIIllIlIII = llllllllllllllIlIlllllIIIllIlIIl.getBlock();
                        if (llllllllllllllIlIlllllIIIllIlIII == Blocks.GLASS || llllllllllllllIlIlllllIIIllIlIII == Blocks.STAINED_GLASS || llllllllllllllIlIlllllIIIllIlIII == Blocks.BEACON || llllllllllllllIlIlllllIIIllIlIII == Blocks.SLIME_BLOCK) {
                            llllllllllllllIlIlllllIIIllIllII = this.atlasSpriteWaterOverlay;
                            llllllllllllllIlIlllllIIlIlIlllI.setSprite(llllllllllllllIlIlllllIIIllIllII);
                        }
                        if (llllllllllllllIlIlllllIIIllIlIII == Blocks.FARMLAND || llllllllllllllIlIlllllIIIllIlIII == Blocks.GRASS_PATH) {
                            llllllllllllllIlIlllllIIIllIlIll = 0.9375f;
                            llllllllllllllIlIlllllIIIllIlIlI = 0.9375f;
                        }
                        if (llllllllllllllIlIlllllIIIllIlIII instanceof BlockSlab) {
                            final BlockSlab llllllllllllllIlIlllllIIIllIIlll = (BlockSlab)llllllllllllllIlIlllllIIIllIlIII;
                            if (!llllllllllllllIlIlllllIIIllIIlll.isDouble() && llllllllllllllIlIlllllIIIllIlIIl.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.BOTTOM) {
                                llllllllllllllIlIlllllIIIllIlIll = 0.5f;
                                llllllllllllllIlIlllllIIIllIlIlI = 0.5f;
                            }
                        }
                    }
                    if (llllllllllllllIlIlllllIIlIlIIIII[llllllllllllllIlIlllllIIIlllIIII]) {
                        float llllllllllllllIlIlllllIIIllIIIll = 0.0f;
                        float llllllllllllllIlIlllllIIIlIlllll = 0.0f;
                        double llllllllllllllIlIlllllIIIlIllIll = 0.0;
                        double llllllllllllllIlIlllllIIIlIlIIll = 0.0;
                        double llllllllllllllIlIlllllIIIlIlIlll = 0.0;
                        double llllllllllllllIlIlllllIIIlIIllll = 0.0;
                        if (llllllllllllllIlIlllllIIIlllIIII == 0) {
                            final float llllllllllllllIlIlllllIIIllIIllI = llllllllllllllIlIlllllIIlIIllIlI;
                            final float llllllllllllllIlIlllllIIIllIIIlI = llllllllllllllIlIlllllIIlIIlIlll;
                            final double llllllllllllllIlIlllllIIIlIllllI = llllllllllllllIlIlllllIIlIIlIllI;
                            final double llllllllllllllIlIlllllIIIlIlIllI = llllllllllllllIlIlllllIIlIIlIllI + 1.0;
                            final double llllllllllllllIlIlllllIIIlIllIlI = llllllllllllllIlIlllllIIlIIlIlII + 0.0010000000474974513;
                            final double llllllllllllllIlIlllllIIIlIlIIlI = llllllllllllllIlIlllllIIlIIlIlII + 0.0010000000474974513;
                        }
                        else if (llllllllllllllIlIlllllIIIlllIIII == 1) {
                            final float llllllllllllllIlIlllllIIIllIIlIl = llllllllllllllIlIlllllIIlIIllIII;
                            final float llllllllllllllIlIlllllIIIllIIIIl = llllllllllllllIlIlllllIIlIIllIIl;
                            final double llllllllllllllIlIlllllIIIlIlllIl = llllllllllllllIlIlllllIIlIIlIllI + 1.0;
                            final double llllllllllllllIlIlllllIIIlIlIlIl = llllllllllllllIlIlllllIIlIIlIllI;
                            final double llllllllllllllIlIlllllIIIlIllIIl = llllllllllllllIlIlllllIIlIIlIlII + 1.0 - 0.0010000000474974513;
                            final double llllllllllllllIlIlllllIIIlIlIIIl = llllllllllllllIlIlllllIIlIIlIlII + 1.0 - 0.0010000000474974513;
                        }
                        else if (llllllllllllllIlIlllllIIIlllIIII == 2) {
                            final float llllllllllllllIlIlllllIIIllIIlII = llllllllllllllIlIlllllIIlIIllIIl;
                            final float llllllllllllllIlIlllllIIIllIIIII = llllllllllllllIlIlllllIIlIIllIlI;
                            final double llllllllllllllIlIlllllIIIlIlllII = llllllllllllllIlIlllllIIlIIlIllI + 0.0010000000474974513;
                            final double llllllllllllllIlIlllllIIIlIlIlII = llllllllllllllIlIlllllIIlIIlIllI + 0.0010000000474974513;
                            final double llllllllllllllIlIlllllIIIlIllIII = llllllllllllllIlIlllllIIlIIlIlII + 1.0;
                            final double llllllllllllllIlIlllllIIIlIlIIII = llllllllllllllIlIlllllIIlIIlIlII;
                        }
                        else {
                            llllllllllllllIlIlllllIIIllIIIll = llllllllllllllIlIlllllIIlIIlIlll;
                            llllllllllllllIlIlllllIIIlIlllll = llllllllllllllIlIlllllIIlIIllIII;
                            llllllllllllllIlIlllllIIIlIllIll = llllllllllllllIlIlllllIIlIIlIllI + 1.0 - 0.0010000000474974513;
                            llllllllllllllIlIlllllIIIlIlIIll = llllllllllllllIlIlllllIIlIIlIllI + 1.0 - 0.0010000000474974513;
                            llllllllllllllIlIlllllIIIlIlIlll = llllllllllllllIlIlllllIIlIIlIlII;
                            llllllllllllllIlIlllllIIIlIIllll = llllllllllllllIlIlllllIIlIIlIlII + 1.0;
                        }
                        if (llllllllllllllIlIlllllIIIllIIIll > llllllllllllllIlIlllllIIIllIlIll || llllllllllllllIlIlllllIIIlIlllll > llllllllllllllIlIlllllIIIllIlIlI) {
                            llllllllllllllIlIlllllIIIllIlIll = Math.min(llllllllllllllIlIlllllIIIllIlIll, llllllllllllllIlIlllllIIIllIIIll);
                            llllllllllllllIlIlllllIIIllIlIlI = Math.min(llllllllllllllIlIlllllIIIllIlIlI, llllllllllllllIlIlllllIIIlIlllll);
                            if (llllllllllllllIlIlllllIIIllIlIll > llllllllllllllIlIlllllIIlIIlIIll) {
                                llllllllllllllIlIlllllIIIllIlIll -= llllllllllllllIlIlllllIIlIIlIIll;
                            }
                            if (llllllllllllllIlIlllllIIIllIlIlI > llllllllllllllIlIlllllIIlIIlIIll) {
                                llllllllllllllIlIlllllIIIllIlIlI -= llllllllllllllIlIlllllIIlIIlIIll;
                            }
                            llllllllllllllIlIlllllIIlIlIllIl = true;
                            final float llllllllllllllIlIlllllIIIlIIlllI = llllllllllllllIlIlllllIIIllIllII.getInterpolatedU(0.0);
                            final float llllllllllllllIlIlllllIIIlIIllIl = llllllllllllllIlIlllllIIIllIllII.getInterpolatedU(8.0);
                            final float llllllllllllllIlIlllllIIIlIIllII = llllllllllllllIlIlllllIIIllIllII.getInterpolatedV((1.0f - llllllllllllllIlIlllllIIIllIIIll) * 16.0f * 0.5f);
                            final float llllllllllllllIlIlllllIIIlIIlIll = llllllllllllllIlIlllllIIIllIllII.getInterpolatedV((1.0f - llllllllllllllIlIlllllIIIlIlllll) * 16.0f * 0.5f);
                            final float llllllllllllllIlIlllllIIIlIIlIlI = llllllllllllllIlIlllllIIIllIllII.getInterpolatedV(8.0);
                            final float llllllllllllllIlIlllllIIIlIIlIIl = llllllllllllllIlIlllllIIIllIllII.getInterpolatedV((1.0f - llllllllllllllIlIlllllIIIllIlIll) * 16.0f * 0.5f);
                            final float llllllllllllllIlIlllllIIIlIIlIII = llllllllllllllIlIlllllIIIllIllII.getInterpolatedV((1.0f - llllllllllllllIlIlllllIIIllIlIlI) * 16.0f * 0.5f);
                            final int llllllllllllllIlIlllllIIIlIIIlll = llllllllllllllIlIlllllIIlIllIIII.getPackedLightmapCoords(llllllllllllllIlIlllllIIIIlllllI, llllllllllllllIlIlllllIIIllIllIl);
                            final int llllllllllllllIlIlllllIIIlIIIllI = llllllllllllllIlIlllllIIIlIIIlll >> 16 & 0xFFFF;
                            final int llllllllllllllIlIlllllIIIlIIIlIl = llllllllllllllIlIlllllIIIlIIIlll & 0xFFFF;
                            final float llllllllllllllIlIlllllIIIlIIIlII = (llllllllllllllIlIlllllIIIlllIIII < 2) ? 0.8f : 0.6f;
                            final float llllllllllllllIlIlllllIIIlIIIIll = 1.0f * llllllllllllllIlIlllllIIIlIIIlII * llllllllllllllIlIlllllIIlIlIIlIl;
                            final float llllllllllllllIlIlllllIIIlIIIIlI = 1.0f * llllllllllllllIlIlllllIIIlIIIlII * llllllllllllllIlIlllllIIlIlIIlII;
                            final float llllllllllllllIlIlllllIIIlIIIIIl = 1.0f * llllllllllllllIlIlllllIIIlIIIlII * llllllllllllllIlIlllllIIlIlIIIll;
                            llllllllllllllIlIlllllIIlIlIlllI.pos(llllllllllllllIlIlllllIIIlIllIll, llllllllllllllIlIlllllIIlIIlIlIl + llllllllllllllIlIlllllIIIllIIIll, llllllllllllllIlIlllllIIIlIlIlll).color(llllllllllllllIlIlllllIIIlIIIIll, llllllllllllllIlIlllllIIIlIIIIlI, llllllllllllllIlIlllllIIIlIIIIIl, 1.0f).tex(llllllllllllllIlIlllllIIIlIIlllI, llllllllllllllIlIlllllIIIlIIllII).lightmap(llllllllllllllIlIlllllIIIlIIIllI, llllllllllllllIlIlllllIIIlIIIlIl).endVertex();
                            llllllllllllllIlIlllllIIlIlIlllI.pos(llllllllllllllIlIlllllIIIlIlIIll, llllllllllllllIlIlllllIIlIIlIlIl + llllllllllllllIlIlllllIIIlIlllll, llllllllllllllIlIlllllIIIlIIllll).color(llllllllllllllIlIlllllIIIlIIIIll, llllllllllllllIlIlllllIIIlIIIIlI, llllllllllllllIlIlllllIIIlIIIIIl, 1.0f).tex(llllllllllllllIlIlllllIIIlIIllIl, llllllllllllllIlIlllllIIIlIIlIll).lightmap(llllllllllllllIlIlllllIIIlIIIllI, llllllllllllllIlIlllllIIIlIIIlIl).endVertex();
                            llllllllllllllIlIlllllIIlIlIlllI.pos(llllllllllllllIlIlllllIIIlIlIIll, llllllllllllllIlIlllllIIlIIlIlIl + llllllllllllllIlIlllllIIIllIlIlI, llllllllllllllIlIlllllIIIlIIllll).color(llllllllllllllIlIlllllIIIlIIIIll, llllllllllllllIlIlllllIIIlIIIIlI, llllllllllllllIlIlllllIIIlIIIIIl, 1.0f).tex(llllllllllllllIlIlllllIIIlIIllIl, llllllllllllllIlIlllllIIIlIIlIII).lightmap(llllllllllllllIlIlllllIIIlIIIllI, llllllllllllllIlIlllllIIIlIIIlIl).endVertex();
                            llllllllllllllIlIlllllIIlIlIlllI.pos(llllllllllllllIlIlllllIIIlIllIll, llllllllllllllIlIlllllIIlIIlIlIl + llllllllllllllIlIlllllIIIllIlIll, llllllllllllllIlIlllllIIIlIlIlll).color(llllllllllllllIlIlllllIIIlIIIIll, llllllllllllllIlIlllllIIIlIIIIlI, llllllllllllllIlIlllllIIIlIIIIIl, 1.0f).tex(llllllllllllllIlIlllllIIIlIIlllI, llllllllllllllIlIlllllIIIlIIlIIl).lightmap(llllllllllllllIlIlllllIIIlIIIllI, llllllllllllllIlIlllllIIIlIIIlIl).endVertex();
                            if (llllllllllllllIlIlllllIIIllIllII != this.atlasSpriteWaterOverlay) {
                                llllllllllllllIlIlllllIIlIlIlllI.pos(llllllllllllllIlIlllllIIIlIllIll, llllllllllllllIlIlllllIIlIIlIlIl + llllllllllllllIlIlllllIIIllIlIll, llllllllllllllIlIlllllIIIlIlIlll).color(llllllllllllllIlIlllllIIIlIIIIll, llllllllllllllIlIlllllIIIlIIIIlI, llllllllllllllIlIlllllIIIlIIIIIl, 1.0f).tex(llllllllllllllIlIlllllIIIlIIlllI, llllllllllllllIlIlllllIIIlIIlIIl).lightmap(llllllllllllllIlIlllllIIIlIIIllI, llllllllllllllIlIlllllIIIlIIIlIl).endVertex();
                                llllllllllllllIlIlllllIIlIlIlllI.pos(llllllllllllllIlIlllllIIIlIlIIll, llllllllllllllIlIlllllIIlIIlIlIl + llllllllllllllIlIlllllIIIllIlIlI, llllllllllllllIlIlllllIIIlIIllll).color(llllllllllllllIlIlllllIIIlIIIIll, llllllllllllllIlIlllllIIIlIIIIlI, llllllllllllllIlIlllllIIIlIIIIIl, 1.0f).tex(llllllllllllllIlIlllllIIIlIIllIl, llllllllllllllIlIlllllIIIlIIlIII).lightmap(llllllllllllllIlIlllllIIIlIIIllI, llllllllllllllIlIlllllIIIlIIIlIl).endVertex();
                                llllllllllllllIlIlllllIIlIlIlllI.pos(llllllllllllllIlIlllllIIIlIlIIll, llllllllllllllIlIlllllIIlIIlIlIl + llllllllllllllIlIlllllIIIlIlllll, llllllllllllllIlIlllllIIIlIIllll).color(llllllllllllllIlIlllllIIIlIIIIll, llllllllllllllIlIlllllIIIlIIIIlI, llllllllllllllIlIlllllIIIlIIIIIl, 1.0f).tex(llllllllllllllIlIlllllIIIlIIllIl, llllllllllllllIlIlllllIIIlIIlIll).lightmap(llllllllllllllIlIlllllIIIlIIIllI, llllllllllllllIlIlllllIIIlIIIlIl).endVertex();
                                llllllllllllllIlIlllllIIlIlIlllI.pos(llllllllllllllIlIlllllIIIlIllIll, llllllllllllllIlIlllllIIlIIlIlIl + llllllllllllllIlIlllllIIIllIIIll, llllllllllllllIlIlllllIIIlIlIlll).color(llllllllllllllIlIlllllIIIlIIIIll, llllllllllllllIlIlllllIIIlIIIIlI, llllllllllllllIlIlllllIIIlIIIIIl, 1.0f).tex(llllllllllllllIlIlllllIIIlIIlllI, llllllllllllllIlIlllllIIIlIIllII).lightmap(llllllllllllllIlIlllllIIIlIIIllI, llllllllllllllIlIlllllIIIlIIIlIl).endVertex();
                            }
                        }
                    }
                }
                llllllllllllllIlIlllllIIlIlIlllI.setSprite(null);
                final String llllllllllllllIlIlllllIIIIIIIIlI;
                final boolean llllllllllllllIlIlllllIIIlIIIIII = (boolean)(llllllllllllllIlIlllllIIIIIIIIlI = (String)llllllllllllllIlIlllllIIlIlIllIl);
                return (boolean)llllllllllllllIlIlllllIIIIIIIIlI;
            }
            final boolean llllllllllllllIlIlllllIIlIlIllII = false;
        }
        finally {
            if (Config.isShaders()) {
                SVertexBuilder.popEntity(llllllllllllllIlIlllllIIlIlIlllI);
            }
        }
        if (Config.isShaders()) {
            SVertexBuilder.popEntity(llllllllllllllIlIlllllIIlIlIlllI);
        }
        final boolean llllllllllllllIlIlllllIIlIlIlIll;
        return llllllllllllllIlIlllllIIlIlIlIll;
    }
}
