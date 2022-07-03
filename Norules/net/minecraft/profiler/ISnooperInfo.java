package net.minecraft.profiler;

public interface ISnooperInfo
{
    void addServerStatsToSnooper(final Snooper p0);
    
    boolean isSnooperEnabled();
    
    void addServerTypeToSnooper(final Snooper p0);
}
