package net.minecraft.world.storage;

import net.minecraft.util.*;
import java.util.*;
import net.minecraft.client.*;
import javax.annotation.*;
import java.io.*;

public interface ISaveFormat
{
    boolean deleteWorldDirectory(final String p0);
    
    boolean convertMapFormat(final String p0, final IProgressUpdate p1);
    
    void flushCache();
    
    void renameWorld(final String p0, final String p1);
    
    boolean isConvertible(final String p0);
    
    String getName();
    
    ISaveHandler getSaveLoader(final String p0, final boolean p1);
    
    boolean isOldMapFormat(final String p0);
    
    List<WorldSummary> getSaveList() throws AnvilConverterException;
    
    @Nullable
    WorldInfo getWorldInfo(final String p0);
    
    File getFile(final String p0, final String p1);
    
    boolean canLoadWorld(final String p0);
    
    boolean isNewLevelIdAcceptable(final String p0);
}
