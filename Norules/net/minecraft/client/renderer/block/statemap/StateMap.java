package net.minecraft.client.renderer.block.statemap;

import net.minecraft.block.properties.*;
import javax.annotation.*;
import net.minecraft.block.state.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import com.google.common.collect.*;
import java.util.*;

public class StateMap extends StateMapperBase
{
    private final /* synthetic */ IProperty<?> name;
    private final /* synthetic */ String suffix;
    private final /* synthetic */ List<IProperty<?>> ignored;
    
    private StateMap(@Nullable final IProperty<?> lllllllllllllIIIlIlllIllIIllIlIl, @Nullable final String lllllllllllllIIIlIlllIllIIlllIII, final List<IProperty<?>> lllllllllllllIIIlIlllIllIIllIIll) {
        this.name = lllllllllllllIIIlIlllIllIIllIlIl;
        this.suffix = lllllllllllllIIIlIlllIllIIlllIII;
        this.ignored = lllllllllllllIIIlIlllIllIIllIIll;
    }
    
    private <T extends Comparable<T>> String removeName(final IProperty<T> lllllllllllllIIIlIlllIllIIIlllII, final Map<IProperty<?>, Comparable<?>> lllllllllllllIIIlIlllIllIIIllIII) {
        return lllllllllllllIIIlIlllIllIIIlllII.getName((T)lllllllllllllIIIlIlllIllIIIllIII.remove(this.name));
    }
    
    @Override
    protected ModelResourceLocation getModelResourceLocation(final IBlockState lllllllllllllIIIlIlllIllIIlIlIll) {
        final Map<IProperty<?>, Comparable<?>> lllllllllllllIIIlIlllIllIIlIlIlI = (Map<IProperty<?>, Comparable<?>>)Maps.newLinkedHashMap((Map)lllllllllllllIIIlIlllIllIIlIlIll.getProperties());
        String lllllllllllllIIIlIlllIllIIlIlIII = null;
        if (this.name == null) {
            final String lllllllllllllIIIlIlllIllIIlIlIIl = Block.REGISTRY.getNameForObject(lllllllllllllIIIlIlllIllIIlIlIll.getBlock()).toString();
        }
        else {
            lllllllllllllIIIlIlllIllIIlIlIII = this.removeName(this.name, lllllllllllllIIIlIlllIllIIlIlIlI);
        }
        if (this.suffix != null) {
            lllllllllllllIIIlIlllIllIIlIlIII = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIlIlllIllIIlIlIII)).append(this.suffix));
        }
        for (final IProperty<?> lllllllllllllIIIlIlllIllIIlIIlll : this.ignored) {
            lllllllllllllIIIlIlllIllIIlIlIlI.remove(lllllllllllllIIIlIlllIllIIlIIlll);
        }
        return new ModelResourceLocation(lllllllllllllIIIlIlllIllIIlIlIII, this.getPropertyString(lllllllllllllIIIlIlllIllIIlIlIlI));
    }
    
    public static class Builder
    {
        private /* synthetic */ String suffix;
        private /* synthetic */ IProperty<?> name;
        private final /* synthetic */ List<IProperty<?>> ignored;
        
        public Builder withName(final IProperty<?> lllllllllllllIIIlllllIlIIlllIlII) {
            this.name = lllllllllllllIIIlllllIlIIlllIlII;
            return this;
        }
        
        public Builder() {
            this.ignored = (List<IProperty<?>>)Lists.newArrayList();
        }
        
        public Builder ignore(final IProperty<?>... lllllllllllllIIIlllllIlIIllIIllI) {
            Collections.addAll(this.ignored, lllllllllllllIIIlllllIlIIllIIllI);
            return this;
        }
        
        public Builder withSuffix(final String lllllllllllllIIIlllllIlIIllIlllI) {
            this.suffix = lllllllllllllIIIlllllIlIIllIlllI;
            return this;
        }
        
        public StateMap build() {
            return new StateMap(this.name, this.suffix, this.ignored, null);
        }
    }
}
