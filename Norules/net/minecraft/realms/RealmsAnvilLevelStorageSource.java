package net.minecraft.realms;

import net.minecraft.util.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.world.storage.*;
import net.minecraft.client.*;

public class RealmsAnvilLevelStorageSource
{
    private final /* synthetic */ ISaveFormat levelStorageSource;
    
    public boolean levelExists(final String lllllllllllllIllIIIlIlIlllIIllII) {
        return this.levelStorageSource.canLoadWorld(lllllllllllllIllIIIlIlIlllIIllII);
    }
    
    public void clearAll() {
        this.levelStorageSource.flushCache();
    }
    
    public boolean convertLevel(final String lllllllllllllIllIIIlIlIlllIIIlll, final IProgressUpdate lllllllllllllIllIIIlIlIlllIIIIll) {
        return this.levelStorageSource.convertMapFormat(lllllllllllllIllIIIlIlIlllIIIlll, lllllllllllllIllIIIlIlIlllIIIIll);
    }
    
    public boolean requiresConversion(final String lllllllllllllIllIIIlIlIllIllllIl) {
        return this.levelStorageSource.isOldMapFormat(lllllllllllllIllIIIlIlIllIllllIl);
    }
    
    public RealmsAnvilLevelStorageSource(final ISaveFormat lllllllllllllIllIIIlIlIlllIlIlIl) {
        this.levelStorageSource = lllllllllllllIllIIIlIlIlllIlIlIl;
    }
    
    public boolean deleteLevel(final String lllllllllllllIllIIIlIlIllIllIIll) {
        return this.levelStorageSource.deleteWorldDirectory(lllllllllllllIllIIIlIlIllIllIIll);
    }
    
    public List<RealmsLevelSummary> getLevelList() throws AnvilConverterException {
        final List<RealmsLevelSummary> lllllllllllllIllIIIlIlIllIIllIIl = (List<RealmsLevelSummary>)Lists.newArrayList();
        for (final WorldSummary lllllllllllllIllIIIlIlIllIIllIII : this.levelStorageSource.getSaveList()) {
            lllllllllllllIllIIIlIlIllIIllIIl.add(new RealmsLevelSummary(lllllllllllllIllIIIlIlIllIIllIII));
        }
        return lllllllllllllIllIIIlIlIllIIllIIl;
    }
    
    public boolean isNewLevelIdAcceptable(final String lllllllllllllIllIIIlIlIllIllIlll) {
        return this.levelStorageSource.isNewLevelIdAcceptable(lllllllllllllIllIIIlIlIllIllIlll);
    }
    
    public String getName() {
        return this.levelStorageSource.getName();
    }
    
    public void renameLevel(final String lllllllllllllIllIIIlIlIllIlIIllI, final String lllllllllllllIllIIIlIlIllIlIIlIl) {
        this.levelStorageSource.renameWorld(lllllllllllllIllIIIlIlIllIlIIllI, lllllllllllllIllIIIlIlIllIlIIlIl);
    }
    
    public boolean isConvertible(final String lllllllllllllIllIIIlIlIllIlIllIl) {
        return this.levelStorageSource.isConvertible(lllllllllllllIllIIIlIlIllIlIllIl);
    }
}
