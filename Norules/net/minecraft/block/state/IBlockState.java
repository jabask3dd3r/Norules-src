package net.minecraft.block.state;

import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import com.google.common.collect.*;
import java.util.*;

public interface IBlockState extends IBlockProperties, IBlockBehaviors
{
    Block getBlock();
    
     <T extends Comparable<T>> T getValue(final IProperty<T> p0);
    
    ImmutableMap<IProperty<?>, Comparable<?>> getProperties();
    
     <T extends Comparable<T>, V extends T> IBlockState withProperty(final IProperty<T> p0, final V p1);
    
     <T extends Comparable<T>> IBlockState cycleProperty(final IProperty<T> p0);
    
    Collection<IProperty<?>> getPropertyNames();
}
