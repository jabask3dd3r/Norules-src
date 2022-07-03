package net.minecraft.world.storage;

import net.minecraft.nbt.*;
import java.io.*;
import net.minecraft.world.chunk.storage.*;
import net.minecraft.world.gen.structure.template.*;
import net.minecraft.world.*;
import javax.annotation.*;

public interface ISaveHandler
{
    void saveWorldInfo(final WorldInfo p0);
    
    void flush();
    
    void saveWorldInfoWithPlayer(final WorldInfo p0, final NBTTagCompound p1);
    
    File getWorldDirectory();
    
    IChunkLoader getChunkLoader(final WorldProvider p0);
    
    TemplateManager getStructureTemplateManager();
    
    IPlayerFileData getPlayerNBTManager();
    
    File getMapFileFromName(final String p0);
    
    void checkSessionLock() throws MinecraftException;
    
    @Nullable
    WorldInfo loadWorldInfo();
}
