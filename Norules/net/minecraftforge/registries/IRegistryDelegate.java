package net.minecraftforge.registries;

import net.minecraft.util.*;

public interface IRegistryDelegate<T>
{
    ResourceLocation name();
    
    Class<T> type();
    
    T get();
}
