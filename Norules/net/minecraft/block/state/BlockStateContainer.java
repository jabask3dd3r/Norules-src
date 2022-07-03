package net.minecraft.block.state;

import net.minecraft.block.properties.*;
import java.util.regex.*;
import javax.annotation.*;
import net.minecraftforge.common.property.*;
import com.google.common.base.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import optifine.*;
import com.google.common.collect.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import java.util.*;

public class BlockStateContainer
{
    private final /* synthetic */ ImmutableSortedMap<String, IProperty<?>> properties;
    private static final /* synthetic */ Pattern NAME_PATTERN;
    private static final /* synthetic */ Function<IProperty<?>, String> GET_NAME_FUNC;
    private final /* synthetic */ Block block;
    private final /* synthetic */ ImmutableList<IBlockState> validStates;
    
    public static <T extends Comparable<T>> String validateProperty(final Block llllllllllllllIllIIIlIlIlIlIlIIl, final IProperty<T> llllllllllllllIllIIIlIlIlIlIllIl) {
        final String llllllllllllllIllIIIlIlIlIlIllII = llllllllllllllIllIIIlIlIlIlIllIl.getName();
        if (!BlockStateContainer.NAME_PATTERN.matcher(llllllllllllllIllIIIlIlIlIlIllII).matches()) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Block: ").append(llllllllllllllIllIIIlIlIlIlIlIIl.getClass()).append(" has invalidly named property: ").append(llllllllllllllIllIIIlIlIlIlIllII)));
        }
        for (final T llllllllllllllIllIIIlIlIlIlIlIll : llllllllllllllIllIIIlIlIlIlIllIl.getAllowedValues()) {
            final String llllllllllllllIllIIIlIlIlIlIlIlI = llllllllllllllIllIIIlIlIlIlIllIl.getName(llllllllllllllIllIIIlIlIlIlIlIll);
            if (!BlockStateContainer.NAME_PATTERN.matcher(llllllllllllllIllIIIlIlIlIlIlIlI).matches()) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder("Block: ").append(llllllllllllllIllIIIlIlIlIlIlIIl.getClass()).append(" has property: ").append(llllllllllllllIllIIIlIlIlIlIllII).append(" with invalidly named value: ").append(llllllllllllllIllIIIlIlIlIlIlIlI)));
            }
        }
        return llllllllllllllIllIIIlIlIlIlIllII;
    }
    
    public Block getBlock() {
        return this.block;
    }
    
    public ImmutableList<IBlockState> getValidStates() {
        return this.validStates;
    }
    
    @Nullable
    public IProperty<?> getProperty(final String llllllllllllllIllIIIlIlIlIIIIIlI) {
        return (IProperty<?>)this.properties.get((Object)llllllllllllllIllIIIlIlIlIIIIIlI);
    }
    
    public BlockStateContainer(final Block llllllllllllllIllIIIlIlIlllIIIll, final IProperty<?>... llllllllllllllIllIIIlIlIllIlllll) {
        this(llllllllllllllIllIIIlIlIlllIIIll, llllllllllllllIllIIIlIlIllIlllll, null);
    }
    
    protected StateImplementation createState(final Block llllllllllllllIllIIIlIlIllIllIll, final ImmutableMap<IProperty<?>, Comparable<?>> llllllllllllllIllIIIlIlIllIlIlll, @Nullable final ImmutableMap<IUnlistedProperty<?>, Optional<?>> llllllllllllllIllIIIlIlIllIllIIl) {
        return new StateImplementation(llllllllllllllIllIIIlIlIllIllIll, llllllllllllllIllIIIlIlIllIlIlll, (StateImplementation)null);
    }
    
    public IBlockState getBaseState() {
        return (IBlockState)this.validStates.get(0);
    }
    
    private List<Iterable<Comparable<?>>> getAllowedValues() {
        final List<Iterable<Comparable<?>>> llllllllllllllIllIIIlIlIlIIllIlI = (List<Iterable<Comparable<?>>>)Lists.newArrayList();
        final ImmutableCollection<IProperty<?>> llllllllllllllIllIIIlIlIlIIllIIl = (ImmutableCollection<IProperty<?>>)this.properties.values();
        for (final IProperty<?> llllllllllllllIllIIIlIlIlIIlIlll : llllllllllllllIllIIIlIlIlIIllIIl) {
            llllllllllllllIllIIIlIlIlIIllIlI.add((Iterable<Comparable<?>>)llllllllllllllIllIIIlIlIlIIlIlll.getAllowedValues());
        }
        return llllllllllllllIllIIIlIlIlIIllIlI;
    }
    
    public Collection<IProperty<?>> getProperties() {
        return (Collection<IProperty<?>>)this.properties.values();
    }
    
    static {
        NAME_PATTERN = Pattern.compile("^[a-z0-9_]+$");
        GET_NAME_FUNC = (Function)new Function<IProperty<?>, String>() {
            @Nullable
            public String apply(@Nullable final IProperty<?> llllllllllllllIIllIIlIllIIIIIIll) {
                return (llllllllllllllIIllIIlIllIIIIIIll == null) ? "<NULL>" : llllllllllllllIIllIIlIllIIIIIIll.getName();
            }
        };
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper((Object)this).add("block", (Object)Block.REGISTRY.getNameForObject(this.block)).add("properties", (Object)Iterables.transform((Iterable)this.properties.values(), (Function)BlockStateContainer.GET_NAME_FUNC)).toString();
    }
    
    protected BlockStateContainer(final Block llllllllllllllIllIIIlIlIlIlllllI, final IProperty<?>[] llllllllllllllIllIIIlIlIllIIlIIl, final ImmutableMap<IUnlistedProperty<?>, Optional<?>> llllllllllllllIllIIIlIlIlIllllII) {
        this.block = llllllllllllllIllIIIlIlIlIlllllI;
        final Map<String, IProperty<?>> llllllllllllllIllIIIlIlIllIIIlll = (Map<String, IProperty<?>>)Maps.newHashMap();
        byte llllllllllllllIllIIIlIlIlIllIlll = (Object)llllllllllllllIllIIIlIlIllIIlIIl;
        for (int length = llllllllllllllIllIIIlIlIllIIlIIl.length, i = 0; i < length; ++i) {
            final IProperty<?> llllllllllllllIllIIIlIlIllIIIllI = llllllllllllllIllIIIlIlIlIllIlll[i];
            validateProperty(llllllllllllllIllIIIlIlIlIlllllI, llllllllllllllIllIIIlIlIllIIIllI);
            llllllllllllllIllIIIlIlIllIIIlll.put(llllllllllllllIllIIIlIlIllIIIllI.getName(), llllllllllllllIllIIIlIlIllIIIllI);
        }
        this.properties = (ImmutableSortedMap<String, IProperty<?>>)ImmutableSortedMap.copyOf((Map)llllllllllllllIllIIIlIlIllIIIlll);
        final Map<Map<IProperty<?>, Comparable<?>>, StateImplementation> llllllllllllllIllIIIlIlIllIIIlIl = (Map<Map<IProperty<?>, Comparable<?>>, StateImplementation>)Maps.newLinkedHashMap();
        final List<StateImplementation> llllllllllllllIllIIIlIlIllIIIlII = (List<StateImplementation>)Lists.newArrayList();
        llllllllllllllIllIIIlIlIlIllIlll = (byte)Cartesian.cartesianProduct((Iterable<? extends Iterable<?>>)this.getAllowedValues()).iterator();
        while (((Iterator)llllllllllllllIllIIIlIlIlIllIlll).hasNext()) {
            final List<Comparable<?>> llllllllllllllIllIIIlIlIllIIIIll = ((Iterator<List<Comparable<?>>>)llllllllllllllIllIIIlIlIlIllIlll).next();
            final Map<IProperty<?>, Comparable<?>> llllllllllllllIllIIIlIlIllIIIIlI = MapPopulator.createMap((Iterable<IProperty<?>>)this.properties.values(), llllllllllllllIllIIIlIlIllIIIIll);
            final StateImplementation llllllllllllllIllIIIlIlIllIIIIIl = this.createState(llllllllllllllIllIIIlIlIlIlllllI, (ImmutableMap<IProperty<?>, Comparable<?>>)ImmutableMap.copyOf((Map)llllllllllllllIllIIIlIlIllIIIIlI), llllllllllllllIllIIIlIlIlIllllII);
            llllllllllllllIllIIIlIlIllIIIlIl.put(llllllllllllllIllIIIlIlIllIIIIlI, llllllllllllllIllIIIlIlIllIIIIIl);
            llllllllllllllIllIIIlIlIllIIIlII.add(llllllllllllllIllIIIlIlIllIIIIIl);
        }
        llllllllllllllIllIIIlIlIlIllIlll = (byte)llllllllllllllIllIIIlIlIllIIIlII.iterator();
        while (((Iterator)llllllllllllllIllIIIlIlIlIllIlll).hasNext()) {
            final StateImplementation llllllllllllllIllIIIlIlIllIIIIII = ((Iterator<StateImplementation>)llllllllllllllIllIIIlIlIlIllIlll).next();
            llllllllllllllIllIIIlIlIllIIIIII.buildPropertyValueTable(llllllllllllllIllIIIlIlIllIIIlIl);
        }
        this.validStates = (ImmutableList<IBlockState>)ImmutableList.copyOf((Collection)llllllllllllllIllIIIlIlIllIIIlII);
    }
    
    public static class Builder
    {
        private final /* synthetic */ List<IProperty<?>> listed;
        private final /* synthetic */ Block block;
        private final /* synthetic */ List<IUnlistedProperty<?>> unlisted;
        
        public Builder(final Block llllllllllllllIlIIIlIIlIIIllIlIl) {
            this.listed = (List<IProperty<?>>)Lists.newArrayList();
            this.unlisted = (List<IUnlistedProperty<?>>)Lists.newArrayList();
            this.block = llllllllllllllIlIIIlIIlIIIllIlIl;
        }
        
        public Builder add(final IProperty<?>... llllllllllllllIlIIIlIIlIIIlIlIlI) {
            final Exception llllllllllllllIlIIIlIIlIIIlIIllI = (Object)llllllllllllllIlIIIlIIlIIIlIlIlI;
            for (char llllllllllllllIlIIIlIIlIIIlIIlll = (char)llllllllllllllIlIIIlIIlIIIlIlIlI.length, llllllllllllllIlIIIlIIlIIIlIlIII = '\0'; llllllllllllllIlIIIlIIlIIIlIlIII < llllllllllllllIlIIIlIIlIIIlIIlll; ++llllllllllllllIlIIIlIIlIIIlIlIII) {
                final IProperty<?> llllllllllllllIlIIIlIIlIIIlIllII = llllllllllllllIlIIIlIIlIIIlIIllI[llllllllllllllIlIIIlIIlIIIlIlIII];
                this.listed.add(llllllllllllllIlIIIlIIlIIIlIllII);
            }
            return this;
        }
        
        public Builder add(final IUnlistedProperty<?>... llllllllllllllIlIIIlIIlIIIIllllI) {
            final double llllllllllllllIlIIIlIIlIIIIlIlll = (Object)llllllllllllllIlIIIlIIlIIIIllllI;
            final double llllllllllllllIlIIIlIIlIIIIllIII = llllllllllllllIlIIIlIIlIIIIllllI.length;
            for (final IUnlistedProperty<?> llllllllllllllIlIIIlIIlIIIIlllIl : llllllllllllllIlIIIlIIlIIIIlIlll) {
                this.unlisted.add(llllllllllllllIlIIIlIIlIIIIlllIl);
            }
            return this;
        }
        
        public BlockStateContainer build() {
            IProperty[] llllllllllllllIlIIIlIIlIIIIlIIlI = new IProperty[this.listed.size()];
            llllllllllllllIlIIIlIIlIIIIlIIlI = this.listed.toArray(llllllllllllllIlIIIlIIlIIIIlIIlI);
            if (this.unlisted.size() == 0) {
                return new BlockStateContainer(this.block, (IProperty<?>[])llllllllllllllIlIIIlIIlIIIIlIIlI);
            }
            IUnlistedProperty[] llllllllllllllIlIIIlIIlIIIIlIIIl = new IUnlistedProperty[this.unlisted.size()];
            llllllllllllllIlIIIlIIlIIIIlIIIl = this.unlisted.toArray(llllllllllllllIlIIIlIIlIIIIlIIIl);
            return (BlockStateContainer)Reflector.newInstance(Reflector.ExtendedBlockState_Constructor, this.block, llllllllllllllIlIIIlIIlIIIIlIIlI, llllllllllllllIlIIIlIIlIIIIlIIIl);
        }
    }
    
    static class StateImplementation extends BlockStateBase
    {
        private final /* synthetic */ ImmutableMap<IProperty<?>, Comparable<?>> properties;
        private /* synthetic */ ImmutableTable<IProperty<?>, Comparable<?>, IBlockState> propertyValueTable;
        private final /* synthetic */ Block block;
        
        @Override
        public int getWeakPower(final IBlockAccess llllllllllllllIIIIIlIIlIIlIIlIlI, final BlockPos llllllllllllllIIIIIlIIlIIlIIlIII, final EnumFacing llllllllllllllIIIIIlIIlIIIllllll) {
            return this.block.getWeakPower(this, llllllllllllllIIIIIlIIlIIlIIlIlI, llllllllllllllIIIIIlIIlIIlIIlIII, llllllllllllllIIIIIlIIlIIIllllll);
        }
        
        @Override
        public void neighborChanged(final World llllllllllllllIIIIIlIIIlIlIIIllI, final BlockPos llllllllllllllIIIIIlIIIlIlIIIlII, final Block llllllllllllllIIIIIlIIIlIlIIIIlI, final BlockPos llllllllllllllIIIIIlIIIlIlIIlIII) {
            this.block.neighborChanged(this, llllllllllllllIIIIIlIIIlIlIIIllI, llllllllllllllIIIIIlIIIlIlIIIlII, llllllllllllllIIIIIlIIIlIlIIIIlI, llllllllllllllIIIIIlIIIlIlIIlIII);
        }
        
        public boolean doesSideBlockRendering(final IBlockAccess llllllllllllllIIIIIlIIIIllllIlIl, final BlockPos llllllllllllllIIIIIlIIIIllllIlII, final EnumFacing llllllllllllllIIIIIlIIIIllllIlll) {
            return Reflector.callBoolean(this.block, Reflector.ForgeBlock_doesSideBlockRendering, this, llllllllllllllIIIIIlIIIIllllIlIl, llllllllllllllIIIIIlIIIIllllIlII, llllllllllllllIIIIIlIIIIllllIlll);
        }
        
        @Override
        public AxisAlignedBB getSelectedBoundingBox(final World llllllllllllllIIIIIlIIIlllIllIll, final BlockPos llllllllllllllIIIIIlIIIlllIlllIl) {
            return this.block.getSelectedBoundingBox(this, llllllllllllllIIIIIlIIIlllIllIll, llllllllllllllIIIIIlIIIlllIlllIl);
        }
        
        public int getLightOpacity(final IBlockAccess llllllllllllllIIIIIlIIIlIIlIIIIl, final BlockPos llllllllllllllIIIIIlIIIlIIlIIlII) {
            return Reflector.callInt(this.block, Reflector.ForgeBlock_getLightOpacity, this, llllllllllllllIIIIIlIIIlIIlIIIIl, llllllllllllllIIIIIlIIIlIIlIIlII);
        }
        
        @Override
        public MapColor getMapColor(final IBlockAccess llllllllllllllIIIIIlIIlIlIIlIIII, final BlockPos llllllllllllllIIIIIlIIlIlIIIllII) {
            return this.block.getMapColor(this, llllllllllllllIIIIIlIIlIlIIlIIII, llllllllllllllIIIIIlIIlIlIIIllII);
        }
        
        @Override
        public float getAmbientOcclusionLightValue() {
            return this.block.getAmbientOcclusionLightValue(this);
        }
        
        @Override
        public AxisAlignedBB getBoundingBox(final IBlockAccess llllllllllllllIIIIIlIIIllIlIIIIl, final BlockPos llllllllllllllIIIIIlIIIllIlIIlIl) {
            final Block.EnumOffsetType llllllllllllllIIIIIlIIIllIlIIlII = this.block.getOffsetType();
            if (llllllllllllllIIIIIlIIIllIlIIlII != Block.EnumOffsetType.NONE && !(this.block instanceof BlockFlower)) {
                AxisAlignedBB llllllllllllllIIIIIlIIIllIlIIIll = this.block.getBoundingBox(this, llllllllllllllIIIIIlIIIllIlIIIIl, llllllllllllllIIIIIlIIIllIlIIlIl);
                llllllllllllllIIIIIlIIIllIlIIIll = BlockModelUtils.getOffsetBoundingBox(llllllllllllllIIIIIlIIIllIlIIIll, llllllllllllllIIIIIlIIIllIlIIlII, llllllllllllllIIIIIlIIIllIlIIlIl);
                return llllllllllllllIIIIIlIIIllIlIIIll;
            }
            return this.block.getBoundingBox(this, llllllllllllllIIIIIlIIIllIlIIIIl, llllllllllllllIIIIIlIIIllIlIIlIl);
        }
        
        @Override
        public boolean isFullyOpaque() {
            return this.block.isFullyOpaque(this);
        }
        
        @Override
        public boolean hasComparatorInputOverride() {
            return this.block.hasComparatorInputOverride(this);
        }
        
        @Override
        public boolean equals(final Object llllllllllllllIIIIIlIIlIllIlIIll) {
            return this == llllllllllllllIIIIIlIIlIllIlIIll;
        }
        
        @Override
        public boolean isTranslucent() {
            return this.block.isTranslucent(this);
        }
        
        @Nullable
        @Override
        public AxisAlignedBB getCollisionBoundingBox(final IBlockAccess llllllllllllllIIIIIlIIIlllIIIllI, final BlockPos llllllllllllllIIIIIlIIIlllIIIlIl) {
            return this.block.getCollisionBoundingBox(this, llllllllllllllIIIIIlIIIlllIIIllI, llllllllllllllIIIIIlIIIlllIIIlIl);
        }
        
        @Override
        public <T extends Comparable<T>, V extends T> IBlockState withProperty(final IProperty<T> llllllllllllllIIIIIlIIlIlllIIlll, final V llllllllllllllIIIIIlIIlIlllIIllI) {
            final Comparable<?> llllllllllllllIIIIIlIIlIlllIIlIl = (Comparable<?>)this.properties.get((Object)llllllllllllllIIIIIlIIlIlllIIlll);
            if (llllllllllllllIIIIIlIIlIlllIIlIl == null) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder("Cannot set property ").append(llllllllllllllIIIIIlIIlIlllIIlll).append(" as it does not exist in ").append(this.block.getBlockState())));
            }
            if (llllllllllllllIIIIIlIIlIlllIIlIl == llllllllllllllIIIIIlIIlIlllIIllI) {
                return this;
            }
            final IBlockState llllllllllllllIIIIIlIIlIlllIIlII = (IBlockState)this.propertyValueTable.get((Object)llllllllllllllIIIIIlIIlIlllIIlll, (Object)llllllllllllllIIIIIlIIlIlllIIllI);
            if (llllllllllllllIIIIIlIIlIlllIIlII == null) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder("Cannot set property ").append(llllllllllllllIIIIIlIIlIlllIIlll).append(" to ").append(llllllllllllllIIIIIlIIlIlllIIllI).append(" on block ").append(Block.REGISTRY.getNameForObject(this.block)).append(", it is not an allowed value")));
            }
            return llllllllllllllIIIIIlIIlIlllIIlII;
        }
        
        @Override
        public IBlockState withRotation(final Rotation llllllllllllllIIIIIlIIlIlIIIIllI) {
            return this.block.withRotation(this, llllllllllllllIIIIIlIIlIlIIIIllI);
        }
        
        @Override
        public boolean isBlockNormalCube() {
            return this.block.isBlockNormalCube(this);
        }
        
        public boolean isSideSolid(final IBlockAccess llllllllllllllIIIIIlIIIlIIIIIlIl, final BlockPos llllllllllllllIIIIIlIIIlIIIIIIII, final EnumFacing llllllllllllllIIIIIlIIIIllllllll) {
            return Reflector.callBoolean(this.block, Reflector.ForgeBlock_isSideSolid, this, llllllllllllllIIIIIlIIIlIIIIIlIl, llllllllllllllIIIIIlIIIlIIIIIIII, llllllllllllllIIIIIlIIIIllllllll);
        }
        
        @Override
        public boolean isOpaqueCube() {
            return this.block.isOpaqueCube(this);
        }
        
        @Override
        public Block getBlock() {
            return this.block;
        }
        
        @Override
        public int getComparatorInputOverride(final World llllllllllllllIIIIIlIIlIIIlIlIIl, final BlockPos llllllllllllllIIIIIlIIlIIIlIIlll) {
            return this.block.getComparatorInputOverride(this, llllllllllllllIIIIIlIIlIIIlIlIIl, llllllllllllllIIIIIlIIlIIIlIIlll);
        }
        
        @Override
        public ImmutableTable<IProperty<?>, Comparable<?>, IBlockState> getPropertyValueTable() {
            return this.propertyValueTable;
        }
        
        @Override
        public float getBlockHardness(final World llllllllllllllIIIIIlIIlIIIIllIll, final BlockPos llllllllllllllIIIIIlIIlIIIIllIlI) {
            return this.block.getBlockHardness(this, llllllllllllllIIIIIlIIlIIIIllIll, llllllllllllllIIIIIlIIlIIIIllIlI);
        }
        
        public void buildPropertyValueTable(final Map<Map<IProperty<?>, Comparable<?>>, StateImplementation> llllllllllllllIIIIIlIIlIlIllllll) {
            if (this.propertyValueTable != null) {
                throw new IllegalStateException();
            }
            final Table<IProperty<?>, Comparable<?>, IBlockState> llllllllllllllIIIIIlIIlIllIIIlIl = (Table<IProperty<?>, Comparable<?>, IBlockState>)HashBasedTable.create();
            for (final Map.Entry<IProperty<?>, Comparable<?>> llllllllllllllIIIIIlIIlIllIIIIll : this.properties.entrySet()) {
                final IProperty<?> llllllllllllllIIIIIlIIlIllIIIIlI = llllllllllllllIIIIIlIIlIllIIIIll.getKey();
                for (final Comparable<?> llllllllllllllIIIIIlIIlIllIIIIIl : llllllllllllllIIIIIlIIlIllIIIIlI.getAllowedValues()) {
                    if (llllllllllllllIIIIIlIIlIllIIIIIl != llllllllllllllIIIIIlIIlIllIIIIll.getValue()) {
                        llllllllllllllIIIIIlIIlIllIIIlIl.put((Object)llllllllllllllIIIIIlIIlIllIIIIlI, (Object)llllllllllllllIIIIIlIIlIllIIIIIl, (Object)llllllllllllllIIIIIlIIlIlIllllll.get(this.getPropertiesWithValue(llllllllllllllIIIIIlIIlIllIIIIlI, llllllllllllllIIIIIlIIlIllIIIIIl)));
                    }
                }
            }
            this.propertyValueTable = (ImmutableTable<IProperty<?>, Comparable<?>, IBlockState>)ImmutableTable.copyOf((Table)llllllllllllllIIIIIlIIlIllIIIlIl);
        }
        
        @Override
        public IBlockState getActualState(final IBlockAccess llllllllllllllIIIIIlIIIllllIIlII, final BlockPos llllllllllllllIIIIIlIIIllllIIllI) {
            return this.block.getActualState(this, llllllllllllllIIIIIlIIIllllIIlII, llllllllllllllIIIIIlIIIllllIIllI);
        }
        
        public int getLightValue(final IBlockAccess llllllllllllllIIIIIlIIIlIIIllIlI, final BlockPos llllllllllllllIIIIIlIIIlIIIllIII) {
            return Reflector.callInt(this.block, Reflector.ForgeBlock_getLightValue, this, llllllllllllllIIIIIlIIIlIIIllIlI, llllllllllllllIIIIIlIIIlIIIllIII);
        }
        
        @Override
        public Material getMaterial() {
            return this.block.getMaterial(this);
        }
        
        @Override
        public int getLightValue() {
            return this.block.getLightValue(this);
        }
        
        @Override
        public boolean func_191058_s() {
            return this.block.causesSuffocation(this);
        }
        
        @Override
        public EnumBlockRenderType getRenderType() {
            return this.block.getRenderType(this);
        }
        
        private Map<IProperty<?>, Comparable<?>> getPropertiesWithValue(final IProperty<?> llllllllllllllIIIIIlIIlIlIlIllll, final Comparable<?> llllllllllllllIIIIIlIIlIlIlIlllI) {
            final Map<IProperty<?>, Comparable<?>> llllllllllllllIIIIIlIIlIlIllIIIl = (Map<IProperty<?>, Comparable<?>>)Maps.newHashMap((Map)this.properties);
            llllllllllllllIIIIIlIIlIlIllIIIl.put(llllllllllllllIIIIIlIIlIlIlIllll, llllllllllllllIIIIIlIIlIlIlIlllI);
            return llllllllllllllIIIIIlIIlIlIllIIIl;
        }
        
        @Override
        public boolean isFullCube() {
            return this.block.isFullCube(this);
        }
        
        @Override
        public int getLightOpacity() {
            return this.block.getLightOpacity(this);
        }
        
        @Override
        public boolean isFullBlock() {
            return this.block.isFullBlock(this);
        }
        
        @Override
        public boolean shouldSideBeRendered(final IBlockAccess llllllllllllllIIIIIlIIIlllIlIlII, final BlockPos llllllllllllllIIIIIlIIIlllIlIIll, final EnumFacing llllllllllllllIIIIIlIIIlllIIlllI) {
            return this.block.shouldSideBeRendered(this, llllllllllllllIIIIIlIIIlllIlIlII, llllllllllllllIIIIIlIIIlllIlIIll, llllllllllllllIIIIIlIIIlllIIlllI);
        }
        
        @Override
        public int getStrongPower(final IBlockAccess llllllllllllllIIIIIlIIIlllllIlIl, final BlockPos llllllllllllllIIIIIlIIIllllllIlI, final EnumFacing llllllllllllllIIIIIlIIIllllllIII) {
            return this.block.getStrongPower(this, llllllllllllllIIIIIlIIIlllllIlIl, llllllllllllllIIIIIlIIIllllllIlI, llllllllllllllIIIIIlIIIllllllIII);
        }
        
        @Override
        public void addCollisionBoxToList(final World llllllllllllllIIIIIlIIIllIllIIlI, final BlockPos llllllllllllllIIIIIlIIIllIllIIIl, final AxisAlignedBB llllllllllllllIIIIIlIIIllIllIIII, final List<AxisAlignedBB> llllllllllllllIIIIIlIIIllIlIllll, @Nullable final Entity llllllllllllllIIIIIlIIIllIllIlIl, final boolean llllllllllllllIIIIIlIIIllIlIllIl) {
            this.block.addCollisionBoxToList(this, llllllllllllllIIIIIlIIIllIllIIlI, llllllllllllllIIIIIlIIIllIllIIIl, llllllllllllllIIIIIlIIIllIllIIII, llllllllllllllIIIIIlIIIllIlIllll, llllllllllllllIIIIIlIIIllIllIlIl, llllllllllllllIIIIIlIIIllIlIllIl);
        }
        
        @Override
        public boolean onBlockEventReceived(final World llllllllllllllIIIIIlIIIlIllIIIlI, final BlockPos llllllllllllllIIIIIlIIIlIllIlIII, final int llllllllllllllIIIIIlIIIlIllIIIII, final int llllllllllllllIIIIIlIIIlIllIIlII) {
            return this.block.eventReceived(this, llllllllllllllIIIIIlIIIlIllIIIlI, llllllllllllllIIIIIlIIIlIllIlIII, llllllllllllllIIIIIlIIIlIllIIIII, llllllllllllllIIIIIlIIIlIllIIlII);
        }
        
        @Override
        public int hashCode() {
            return this.properties.hashCode();
        }
        
        @Override
        public EnumPushReaction getMobilityFlag() {
            return this.block.getMobilityFlag(this);
        }
        
        @Override
        public Vec3d func_191059_e(final IBlockAccess llllllllllllllIIIIIlIIIllIIIIIII, final BlockPos llllllllllllllIIIIIlIIIlIllllIII) {
            return this.block.func_190949_e(this, llllllllllllllIIIIIlIIIllIIIIIII, llllllllllllllIIIIIlIIIlIllllIII);
        }
        
        @Override
        public ImmutableMap<IProperty<?>, Comparable<?>> getProperties() {
            return this.properties;
        }
        
        @Override
        public boolean canEntitySpawn(final Entity llllllllllllllIIIIIlIIlIlIlIIIIl) {
            return this.block.canEntitySpawn(this, llllllllllllllIIIIIlIIlIlIlIIIIl);
        }
        
        @Override
        public boolean func_191057_i() {
            return this.block.func_190946_v(this);
        }
        
        @Override
        public float getPlayerRelativeBlockHardness(final EntityPlayer llllllllllllllIIIIIlIIlIIIIIlIlI, final World llllllllllllllIIIIIlIIlIIIIlIIII, final BlockPos llllllllllllllIIIIIlIIlIIIIIlllI) {
            return this.block.getPlayerRelativeBlockHardness(this, llllllllllllllIIIIIlIIlIIIIIlIlI, llllllllllllllIIIIIlIIlIIIIlIIII, llllllllllllllIIIIIlIIlIIIIIlllI);
        }
        
        @Override
        public boolean isNormalCube() {
            return this.block.isNormalCube(this);
        }
        
        @Override
        public RayTraceResult collisionRayTrace(final World llllllllllllllIIIIIlIIIllIIlIlll, final BlockPos llllllllllllllIIIIIlIIIllIIlIIIl, final Vec3d llllllllllllllIIIIIlIIIllIIlIIII, final Vec3d llllllllllllllIIIIIlIIIllIIlIlII) {
            return this.block.collisionRayTrace(this, llllllllllllllIIIIIlIIIllIIlIlll, llllllllllllllIIIIIlIIIllIIlIIIl, llllllllllllllIIIIIlIIIllIIlIIII, llllllllllllllIIIIIlIIIllIIlIlII);
        }
        
        @Override
        public <T extends Comparable<T>> T getValue(final IProperty<T> llllllllllllllIIIIIlIIlIlllIllll) {
            final Comparable<?> llllllllllllllIIIIIlIIlIllllIIIl = (Comparable<?>)this.properties.get((Object)llllllllllllllIIIIIlIIlIlllIllll);
            if (llllllllllllllIIIIIlIIlIllllIIIl == null) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder("Cannot get property ").append(llllllllllllllIIIIIlIIlIlllIllll).append(" as it does not exist in ").append(this.block.getBlockState())));
            }
            return llllllllllllllIIIIIlIIlIlllIllll.getValueClass().cast(llllllllllllllIIIIIlIIlIllllIIIl);
        }
        
        private StateImplementation(final Block llllllllllllllIIIIIlIIllIIIIlIlI, final ImmutableMap<IProperty<?>, Comparable<?>> llllllllllllllIIIIIlIIllIIIIIllI) {
            this.block = llllllllllllllIIIIIlIIllIIIIlIlI;
            this.properties = llllllllllllllIIIIIlIIllIIIIIllI;
        }
        
        @Override
        public BlockFaceShape func_193401_d(final IBlockAccess llllllllllllllIIIIIlIIIIlllIlIIl, final BlockPos llllllllllllllIIIIIlIIIIlllIllII, final EnumFacing llllllllllllllIIIIIlIIIIlllIIlll) {
            return this.block.func_193383_a(llllllllllllllIIIIIlIIIIlllIlIIl, this, llllllllllllllIIIIIlIIIIlllIllII, llllllllllllllIIIIIlIIIIlllIIlll);
        }
        
        @Override
        public Collection<IProperty<?>> getPropertyNames() {
            return Collections.unmodifiableCollection((Collection<? extends IProperty<?>>)this.properties.keySet());
        }
        
        @Override
        public boolean canProvidePower() {
            return this.block.canProvidePower(this);
        }
        
        @Override
        public IBlockState withMirror(final Mirror llllllllllllllIIIIIlIIlIlIIIIIlI) {
            return this.block.withMirror(this, llllllllllllllIIIIIlIIlIlIIIIIlI);
        }
        
        @Override
        public boolean useNeighborBrightness() {
            return this.block.getUseNeighborBrightness(this);
        }
        
        @Override
        public int getPackedLightmapCoords(final IBlockAccess llllllllllllllIIIIIlIIlIIllIllIl, final BlockPos llllllllllllllIIIIIlIIlIIllIlIll) {
            return this.block.getPackedLightmapCoords(this, llllllllllllllIIIIIlIIlIIllIllIl, llllllllllllllIIIIIlIIlIIllIlIll);
        }
        
        protected StateImplementation(final Block llllllllllllllIIIIIlIIlIllllllII, final ImmutableMap<IProperty<?>, Comparable<?>> llllllllllllllIIIIIlIIlIlllllIll, final ImmutableTable<IProperty<?>, Comparable<?>, IBlockState> llllllllllllllIIIIIlIIlIlllllllI) {
            this.block = llllllllllllllIIIIIlIIlIllllllII;
            this.properties = llllllllllllllIIIIIlIIlIlllllIll;
            this.propertyValueTable = llllllllllllllIIIIIlIIlIlllllllI;
        }
    }
}
