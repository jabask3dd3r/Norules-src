package net.minecraft.client.renderer.block.statemap;

import java.util.*;
import net.minecraft.block.state.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.*;
import com.google.common.collect.*;

public abstract class StateMapperBase implements IStateMapper
{
    protected /* synthetic */ Map<IBlockState, ModelResourceLocation> mapStateModelLocations;
    
    public StateMapperBase() {
        this.mapStateModelLocations = (Map<IBlockState, ModelResourceLocation>)Maps.newLinkedHashMap();
    }
    
    private <T extends Comparable<T>> String getPropertyName(final IProperty<T> llllllllllllllIlllIIIIlIIllIllll, final Comparable<?> llllllllllllllIlllIIIIlIIlllIIII) {
        return llllllllllllllIlllIIIIlIIllIllll.getName((T)llllllllllllllIlllIIIIlIIlllIIII);
    }
    
    public String getPropertyString(final Map<IProperty<?>, Comparable<?>> llllllllllllllIlllIIIIlIIllllIIl) {
        final StringBuilder llllllllllllllIlllIIIIlIIlllllIl = new StringBuilder();
        for (final Map.Entry<IProperty<?>, Comparable<?>> llllllllllllllIlllIIIIlIIlllllII : llllllllllllllIlllIIIIlIIllllIIl.entrySet()) {
            if (llllllllllllllIlllIIIIlIIlllllIl.length() != 0) {
                llllllllllllllIlllIIIIlIIlllllIl.append(",");
            }
            final IProperty<?> llllllllllllllIlllIIIIlIIllllIll = llllllllllllllIlllIIIIlIIlllllII.getKey();
            llllllllllllllIlllIIIIlIIlllllIl.append(llllllllllllllIlllIIIIlIIllllIll.getName());
            llllllllllllllIlllIIIIlIIlllllIl.append("=");
            llllllllllllllIlllIIIIlIIlllllIl.append(this.getPropertyName(llllllllllllllIlllIIIIlIIllllIll, llllllllllllllIlllIIIIlIIlllllII.getValue()));
        }
        if (llllllllllllllIlllIIIIlIIlllllIl.length() == 0) {
            llllllllllllllIlllIIIIlIIlllllIl.append("normal");
        }
        return String.valueOf(llllllllllllllIlllIIIIlIIlllllIl);
    }
    
    @Override
    public Map<IBlockState, ModelResourceLocation> putStateModelLocations(final Block llllllllllllllIlllIIIIlIIllIlIII) {
        for (final IBlockState llllllllllllllIlllIIIIlIIllIIllI : llllllllllllllIlllIIIIlIIllIlIII.getBlockState().getValidStates()) {
            this.mapStateModelLocations.put(llllllllllllllIlllIIIIlIIllIIllI, this.getModelResourceLocation(llllllllllllllIlllIIIIlIIllIIllI));
        }
        return this.mapStateModelLocations;
    }
    
    protected abstract ModelResourceLocation getModelResourceLocation(final IBlockState p0);
}
