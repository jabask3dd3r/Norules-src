package net.minecraft.client.renderer.debug;

import net.minecraft.client.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import com.google.common.collect.*;
import java.util.*;

public class DebugRendererNeighborsUpdate implements DebugRenderer.IDebugRenderer
{
    private final /* synthetic */ Map<Long, Map<BlockPos, Integer>> field_191555_b;
    private final /* synthetic */ Minecraft field_191554_a;
    
    @Override
    public void render(final float llllllllllllllllIllIIllIIIlIIlll, final long llllllllllllllllIllIIllIIIlIIllI) {
        final long llllllllllllllllIllIIllIIIlIIlIl = this.field_191554_a.world.getTotalWorldTime();
        final EntityPlayer llllllllllllllllIllIIllIIIlIIlII = this.field_191554_a.player;
        final double llllllllllllllllIllIIllIIIlIIIll = llllllllllllllllIllIIllIIIlIIlII.lastTickPosX + (llllllllllllllllIllIIllIIIlIIlII.posX - llllllllllllllllIllIIllIIIlIIlII.lastTickPosX) * llllllllllllllllIllIIllIIIlIIlll;
        final double llllllllllllllllIllIIllIIIlIIIlI = llllllllllllllllIllIIllIIIlIIlII.lastTickPosY + (llllllllllllllllIllIIllIIIlIIlII.posY - llllllllllllllllIllIIllIIIlIIlII.lastTickPosY) * llllllllllllllllIllIIllIIIlIIlll;
        final double llllllllllllllllIllIIllIIIlIIIIl = llllllllllllllllIllIIllIIIlIIlII.lastTickPosZ + (llllllllllllllllIllIIllIIIlIIlII.posZ - llllllllllllllllIllIIllIIIlIIlII.lastTickPosZ) * llllllllllllllllIllIIllIIIlIIlll;
        final World llllllllllllllllIllIIllIIIlIIIII = this.field_191554_a.player.world;
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.glLineWidth(2.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask(false);
        final int llllllllllllllllIllIIllIIIIlllll = 200;
        final double llllllllllllllllIllIIllIIIIllllI = 0.0025;
        final Set<BlockPos> llllllllllllllllIllIIllIIIIlllIl = (Set<BlockPos>)Sets.newHashSet();
        final Map<BlockPos, Integer> llllllllllllllllIllIIllIIIIlllII = (Map<BlockPos, Integer>)Maps.newHashMap();
        final Iterator<Map.Entry<Long, Map<BlockPos, Integer>>> llllllllllllllllIllIIllIIIIllIll = this.field_191555_b.entrySet().iterator();
        while (llllllllllllllllIllIIllIIIIllIll.hasNext()) {
            final Map.Entry<Long, Map<BlockPos, Integer>> llllllllllllllllIllIIllIIIIllIlI = llllllllllllllllIllIIllIIIIllIll.next();
            final Long llllllllllllllllIllIIllIIIIllIIl = llllllllllllllllIllIIllIIIIllIlI.getKey();
            final Map<BlockPos, Integer> llllllllllllllllIllIIllIIIIllIII = llllllllllllllllIllIIllIIIIllIlI.getValue();
            final long llllllllllllllllIllIIllIIIIlIlll = llllllllllllllllIllIIllIIIlIIlIl - llllllllllllllllIllIIllIIIIllIIl;
            if (llllllllllllllllIllIIllIIIIlIlll > 200L) {
                llllllllllllllllIllIIllIIIIllIll.remove();
            }
            else {
                for (final Map.Entry<BlockPos, Integer> llllllllllllllllIllIIllIIIIlIllI : llllllllllllllllIllIIllIIIIllIII.entrySet()) {
                    final BlockPos llllllllllllllllIllIIllIIIIlIlIl = llllllllllllllllIllIIllIIIIlIllI.getKey();
                    final Integer llllllllllllllllIllIIllIIIIlIlII = llllllllllllllllIllIIllIIIIlIllI.getValue();
                    if (llllllllllllllllIllIIllIIIIlllIl.add(llllllllllllllllIllIIllIIIIlIlIl)) {
                        RenderGlobal.drawSelectionBoundingBox(new AxisAlignedBB(BlockPos.ORIGIN).expandXyz(0.002).contract(0.0025 * llllllllllllllllIllIIllIIIIlIlll).offset(llllllllllllllllIllIIllIIIIlIlIl.getX(), llllllllllllllllIllIIllIIIIlIlIl.getY(), llllllllllllllllIllIIllIIIIlIlIl.getZ()).offset(-llllllllllllllllIllIIllIIIlIIIll, -llllllllllllllllIllIIllIIIlIIIlI, -llllllllllllllllIllIIllIIIlIIIIl), 1.0f, 1.0f, 1.0f, 1.0f);
                        llllllllllllllllIllIIllIIIIlllII.put(llllllllllllllllIllIIllIIIIlIlIl, llllllllllllllllIllIIllIIIIlIlII);
                    }
                }
            }
        }
        for (final Map.Entry<BlockPos, Integer> llllllllllllllllIllIIllIIIIlIIll : llllllllllllllllIllIIllIIIIlllII.entrySet()) {
            final BlockPos llllllllllllllllIllIIllIIIIlIIlI = llllllllllllllllIllIIllIIIIlIIll.getKey();
            final Integer llllllllllllllllIllIIllIIIIlIIIl = llllllllllllllllIllIIllIIIIlIIll.getValue();
            DebugRenderer.func_191556_a(String.valueOf(llllllllllllllllIllIIllIIIIlIIIl), llllllllllllllllIllIIllIIIIlIIlI.getX(), llllllllllllllllIllIIllIIIIlIIlI.getY(), llllllllllllllllIllIIllIIIIlIIlI.getZ(), llllllllllllllllIllIIllIIIlIIlll, -1);
        }
        GlStateManager.depthMask(true);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
    
    DebugRendererNeighborsUpdate(final Minecraft llllllllllllllllIllIIllIIlIIllIl) {
        this.field_191555_b = (Map<Long, Map<BlockPos, Integer>>)Maps.newTreeMap((Comparator)Ordering.natural().reverse());
        this.field_191554_a = llllllllllllllllIllIIllIIlIIllIl;
    }
    
    public void func_191553_a(final long llllllllllllllllIllIIllIIlIIIIIl, final BlockPos llllllllllllllllIllIIllIIlIIIIII) {
        Map<BlockPos, Integer> llllllllllllllllIllIIllIIlIIIlII = this.field_191555_b.get(llllllllllllllllIllIIllIIlIIIIIl);
        if (llllllllllllllllIllIIllIIlIIIlII == null) {
            llllllllllllllllIllIIllIIlIIIlII = (Map<BlockPos, Integer>)Maps.newHashMap();
            this.field_191555_b.put(llllllllllllllllIllIIllIIlIIIIIl, llllllllllllllllIllIIllIIlIIIlII);
        }
        Integer llllllllllllllllIllIIllIIlIIIIll = llllllllllllllllIllIIllIIlIIIlII.get(llllllllllllllllIllIIllIIlIIIIII);
        if (llllllllllllllllIllIIllIIlIIIIll == null) {
            llllllllllllllllIllIIllIIlIIIIll = 0;
        }
        llllllllllllllllIllIIllIIlIIIlII.put(llllllllllllllllIllIIllIIlIIIIII, llllllllllllllllIllIIllIIlIIIIll + 1);
    }
}
