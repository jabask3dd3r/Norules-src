package net.minecraft.client.renderer.block.statemap;

import net.minecraft.block.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.block.state.*;
import net.minecraft.client.renderer.block.model.*;
import com.google.common.base.*;
import net.minecraft.util.*;

public class BlockStateMapper
{
    private final /* synthetic */ Map<Block, IStateMapper> blockStateMap;
    private final /* synthetic */ Set<Block> setBuiltInBlocks;
    
    public void registerBlockStateMapper(final Block lllllllllllllllIllIlIIlIIIIlllll, final IStateMapper lllllllllllllllIllIlIIlIIIlIIIIl) {
        this.blockStateMap.put(lllllllllllllllIllIlIIlIIIIlllll, lllllllllllllllIllIlIIlIIIlIIIIl);
    }
    
    public void registerBuiltInBlocks(final Block... lllllllllllllllIllIlIIlIIIIllIlI) {
        Collections.addAll(this.setBuiltInBlocks, lllllllllllllllIllIlIIlIIIIllIlI);
    }
    
    public BlockStateMapper() {
        this.blockStateMap = (Map<Block, IStateMapper>)Maps.newIdentityHashMap();
        this.setBuiltInBlocks = (Set<Block>)Sets.newIdentityHashSet();
    }
    
    public Map<IBlockState, ModelResourceLocation> getVariants(final Block lllllllllllllllIllIlIIIllllllIII) {
        return this.setBuiltInBlocks.contains(lllllllllllllllIllIlIIIllllllIII) ? Collections.emptyMap() : ((IStateMapper)MoreObjects.firstNonNull((Object)this.blockStateMap.get(lllllllllllllllIllIlIIIllllllIII), (Object)new DefaultStateMapper())).putStateModelLocations(lllllllllllllllIllIlIIIllllllIII);
    }
    
    public Set<ResourceLocation> getBlockstateLocations(final Block lllllllllllllllIllIlIIlIIIIIIlIl) {
        if (this.setBuiltInBlocks.contains(lllllllllllllllIllIlIIlIIIIIIlIl)) {
            return Collections.emptySet();
        }
        final IStateMapper lllllllllllllllIllIlIIlIIIIIIlII = this.blockStateMap.get(lllllllllllllllIllIlIIlIIIIIIlIl);
        if (lllllllllllllllIllIlIIlIIIIIIlII == null) {
            return Collections.singleton(Block.REGISTRY.getNameForObject(lllllllllllllllIllIlIIlIIIIIIlIl));
        }
        final Set<ResourceLocation> lllllllllllllllIllIlIIlIIIIIIIll = (Set<ResourceLocation>)Sets.newHashSet();
        for (final ModelResourceLocation lllllllllllllllIllIlIIlIIIIIIIlI : lllllllllllllllIllIlIIlIIIIIIlII.putStateModelLocations(lllllllllllllllIllIlIIlIIIIIIlIl).values()) {
            lllllllllllllllIllIlIIlIIIIIIIll.add(new ResourceLocation(lllllllllllllllIllIlIIlIIIIIIIlI.getResourceDomain(), lllllllllllllllIllIlIIlIIIIIIIlI.getResourcePath()));
        }
        return lllllllllllllllIllIlIIlIIIIIIIll;
    }
    
    public Map<IBlockState, ModelResourceLocation> putAllStateModelLocations() {
        final Map<IBlockState, ModelResourceLocation> lllllllllllllllIllIlIIlIIIIlIIlI = (Map<IBlockState, ModelResourceLocation>)Maps.newIdentityHashMap();
        for (final Block lllllllllllllllIllIlIIlIIIIlIIIl : Block.REGISTRY) {
            lllllllllllllllIllIlIIlIIIIlIIlI.putAll(this.getVariants(lllllllllllllllIllIlIIlIIIIlIIIl));
        }
        return lllllllllllllllIllIlIIlIIIIlIIlI;
    }
}
