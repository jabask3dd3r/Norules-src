package net.minecraft.world.storage;

import java.io.*;
import net.minecraft.nbt.*;
import net.minecraft.world.gen.structure.template.*;
import net.minecraft.world.*;
import net.minecraft.world.chunk.storage.*;

public class SaveHandlerMP implements ISaveHandler
{
    @Override
    public File getMapFileFromName(final String llllllllllllllIIlIlIlIIIIIllIllI) {
        return null;
    }
    
    @Override
    public IPlayerFileData getPlayerNBTManager() {
        return null;
    }
    
    @Override
    public void checkSessionLock() throws MinecraftException {
    }
    
    @Override
    public WorldInfo loadWorldInfo() {
        return null;
    }
    
    @Override
    public void saveWorldInfoWithPlayer(final WorldInfo llllllllllllllIIlIlIlIIIIIllllIl, final NBTTagCompound llllllllllllllIIlIlIlIIIIIllllII) {
    }
    
    @Override
    public void flush() {
    }
    
    @Override
    public File getWorldDirectory() {
        return null;
    }
    
    @Override
    public TemplateManager getStructureTemplateManager() {
        return null;
    }
    
    @Override
    public IChunkLoader getChunkLoader(final WorldProvider llllllllllllllIIlIlIlIIIIIllllll) {
        return null;
    }
    
    @Override
    public void saveWorldInfo(final WorldInfo llllllllllllllIIlIlIlIIIIIlllIlI) {
    }
}
