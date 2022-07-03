package net.minecraft.world.chunk.storage;

import java.io.*;
import net.minecraft.world.*;
import net.minecraft.util.datafix.*;
import net.minecraft.world.storage.*;
import net.minecraft.nbt.*;
import javax.annotation.*;

public class AnvilSaveHandler extends SaveHandler
{
    @Override
    public IChunkLoader getChunkLoader(final WorldProvider lllllllllllllIllIIlIIIIllIIlIIII) {
        final File lllllllllllllIllIIlIIIIllIIlIlII = this.getWorldDirectory();
        if (lllllllllllllIllIIlIIIIllIIlIIII instanceof WorldProviderHell) {
            final File lllllllllllllIllIIlIIIIllIIlIIll = new File(lllllllllllllIllIIlIIIIllIIlIlII, "DIM-1");
            lllllllllllllIllIIlIIIIllIIlIIll.mkdirs();
            return new AnvilChunkLoader(lllllllllllllIllIIlIIIIllIIlIIll, this.dataFixer);
        }
        if (lllllllllllllIllIIlIIIIllIIlIIII instanceof WorldProviderEnd) {
            final File lllllllllllllIllIIlIIIIllIIlIIlI = new File(lllllllllllllIllIIlIIIIllIIlIlII, "DIM1");
            lllllllllllllIllIIlIIIIllIIlIIlI.mkdirs();
            return new AnvilChunkLoader(lllllllllllllIllIIlIIIIllIIlIIlI, this.dataFixer);
        }
        return new AnvilChunkLoader(lllllllllllllIllIIlIIIIllIIlIlII, this.dataFixer);
    }
    
    @Override
    public void flush() {
        try {
            ThreadedFileIOBase.getThreadedIOInstance().waitForFinish();
        }
        catch (InterruptedException lllllllllllllIllIIlIIIIllIIIIIlI) {
            lllllllllllllIllIIlIIIIllIIIIIlI.printStackTrace();
        }
        RegionFileCache.clearRegionFileReferences();
    }
    
    public AnvilSaveHandler(final File lllllllllllllIllIIlIIIIllIIllllI, final String lllllllllllllIllIIlIIIIllIIlllIl, final boolean lllllllllllllIllIIlIIIIllIIlllII, final DataFixer lllllllllllllIllIIlIIIIllIIllIll) {
        super(lllllllllllllIllIIlIIIIllIIllllI, lllllllllllllIllIIlIIIIllIIlllIl, lllllllllllllIllIIlIIIIllIIlllII, lllllllllllllIllIIlIIIIllIIllIll);
    }
    
    @Override
    public void saveWorldInfoWithPlayer(final WorldInfo lllllllllllllIllIIlIIIIllIIIlIIl, @Nullable final NBTTagCompound lllllllllllllIllIIlIIIIllIIIIlIl) {
        lllllllllllllIllIIlIIIIllIIIlIIl.setSaveVersion(19133);
        super.saveWorldInfoWithPlayer(lllllllllllllIllIIlIIIIllIIIlIIl, lllllllllllllIllIIlIIIIllIIIIlIl);
    }
}
