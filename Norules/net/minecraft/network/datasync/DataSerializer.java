package net.minecraft.network.datasync;

import net.minecraft.network.*;
import java.io.*;

public interface DataSerializer<T>
{
    T func_192717_a(final T p0);
    
    T read(final PacketBuffer p0) throws IOException;
    
    DataParameter<T> createKey(final int p0);
    
    void write(final PacketBuffer p0, final T p1);
}
