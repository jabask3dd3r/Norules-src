package net.minecraftforge.fml.common.registry;

import net.minecraft.util.*;

public interface RegistryDelegate<T>
{
    Class<T> type();
    
    T get();
    
    ResourceLocation name();
}
