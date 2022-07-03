package net.minecraft.world.storage;

import java.util.*;
import net.minecraft.nbt.*;
import com.google.common.collect.*;
import javax.annotation.*;
import java.io.*;

public class MapStorage
{
    private final /* synthetic */ Map<String, Short> idCounts;
    protected /* synthetic */ Map<String, WorldSavedData> loadedDataMap;
    private final /* synthetic */ List<WorldSavedData> loadedDataList;
    private final /* synthetic */ ISaveHandler saveHandler;
    
    private void loadIdCounts() {
        try {
            this.idCounts.clear();
            if (this.saveHandler == null) {
                return;
            }
            final File lllllllllllllllllIIIllIIlIIIllIl = this.saveHandler.getMapFileFromName("idcounts");
            if (lllllllllllllllllIIIllIIlIIIllIl != null && lllllllllllllllllIIIllIIlIIIllIl.exists()) {
                final DataInputStream lllllllllllllllllIIIllIIlIIIllII = new DataInputStream(new FileInputStream(lllllllllllllllllIIIllIIlIIIllIl));
                final NBTTagCompound lllllllllllllllllIIIllIIlIIIlIll = CompressedStreamTools.read(lllllllllllllllllIIIllIIlIIIllII);
                lllllllllllllllllIIIllIIlIIIllII.close();
                for (final String lllllllllllllllllIIIllIIlIIIlIlI : lllllllllllllllllIIIllIIlIIIlIll.getKeySet()) {
                    final NBTBase lllllllllllllllllIIIllIIlIIIlIIl = lllllllllllllllllIIIllIIlIIIlIll.getTag(lllllllllllllllllIIIllIIlIIIlIlI);
                    if (lllllllllllllllllIIIllIIlIIIlIIl instanceof NBTTagShort) {
                        final NBTTagShort lllllllllllllllllIIIllIIlIIIlIII = (NBTTagShort)lllllllllllllllllIIIllIIlIIIlIIl;
                        final short lllllllllllllllllIIIllIIlIIIIlll = lllllllllllllllllIIIllIIlIIIlIII.getShort();
                        this.idCounts.put(lllllllllllllllllIIIllIIlIIIlIlI, lllllllllllllllllIIIllIIlIIIIlll);
                    }
                }
            }
        }
        catch (Exception lllllllllllllllllIIIllIIlIIIIllI) {
            lllllllllllllllllIIIllIIlIIIIllI.printStackTrace();
        }
    }
    
    public MapStorage(final ISaveHandler lllllllllllllllllIIIllIlIIIlIIll) {
        this.loadedDataMap = (Map<String, WorldSavedData>)Maps.newHashMap();
        this.loadedDataList = (List<WorldSavedData>)Lists.newArrayList();
        this.idCounts = (Map<String, Short>)Maps.newHashMap();
        this.saveHandler = lllllllllllllllllIIIllIlIIIlIIll;
        this.loadIdCounts();
    }
    
    @Nullable
    public WorldSavedData getOrLoadData(final Class<? extends WorldSavedData> lllllllllllllllllIIIllIIllllIIlI, final String lllllllllllllllllIIIllIIllllIIII) {
        WorldSavedData lllllllllllllllllIIIllIIlllIllll = this.loadedDataMap.get(lllllllllllllllllIIIllIIllllIIII);
        if (lllllllllllllllllIIIllIIlllIllll != null) {
            return lllllllllllllllllIIIllIIlllIllll;
        }
        if (this.saveHandler != null) {
            try {
                final File lllllllllllllllllIIIllIIlllIllIl = this.saveHandler.getMapFileFromName(lllllllllllllllllIIIllIIllllIIII);
                if (lllllllllllllllllIIIllIIlllIllIl != null && lllllllllllllllllIIIllIIlllIllIl.exists()) {
                    try {
                        lllllllllllllllllIIIllIIlllIllll = (WorldSavedData)lllllllllllllllllIIIllIIllllIIlI.getConstructor(String.class).newInstance(lllllllllllllllllIIIllIIllllIIII);
                    }
                    catch (Exception lllllllllllllllllIIIllIIlllIlIlI) {
                        throw new RuntimeException(String.valueOf(new StringBuilder("Failed to instantiate ").append(lllllllllllllllllIIIllIIllllIIlI)), lllllllllllllllllIIIllIIlllIlIlI);
                    }
                    final FileInputStream lllllllllllllllllIIIllIIlllIlIIl = new FileInputStream(lllllllllllllllllIIIllIIlllIllIl);
                    final NBTTagCompound lllllllllllllllllIIIllIIlllIlIII = CompressedStreamTools.readCompressed(lllllllllllllllllIIIllIIlllIlIIl);
                    lllllllllllllllllIIIllIIlllIlIIl.close();
                    lllllllllllllllllIIIllIIlllIllll.readFromNBT(lllllllllllllllllIIIllIIlllIlIII.getCompoundTag("data"));
                }
            }
            catch (Exception lllllllllllllllllIIIllIIlllIIlll) {
                lllllllllllllllllIIIllIIlllIIlll.printStackTrace();
            }
        }
        if (lllllllllllllllllIIIllIIlllIllll != null) {
            this.loadedDataMap.put(lllllllllllllllllIIIllIIllllIIII, lllllllllllllllllIIIllIIlllIllll);
            this.loadedDataList.add(lllllllllllllllllIIIllIIlllIllll);
        }
        return lllllllllllllllllIIIllIIlllIllll;
    }
    
    public void setData(final String lllllllllllllllllIIIllIIllIIlIlI, final WorldSavedData lllllllllllllllllIIIllIIllIIlllI) {
        if (this.loadedDataMap.containsKey(lllllllllllllllllIIIllIIllIIlIlI)) {
            this.loadedDataList.remove(this.loadedDataMap.remove(lllllllllllllllllIIIllIIllIIlIlI));
        }
        this.loadedDataMap.put(lllllllllllllllllIIIllIIllIIlIlI, lllllllllllllllllIIIllIIllIIlllI);
        this.loadedDataList.add(lllllllllllllllllIIIllIIllIIlllI);
    }
    
    private void saveData(final WorldSavedData lllllllllllllllllIIIllIIlIIllIll) {
        if (this.saveHandler != null) {
            try {
                final File lllllllllllllllllIIIllIIlIlIIIIl = this.saveHandler.getMapFileFromName(lllllllllllllllllIIIllIIlIIllIll.mapName);
                if (lllllllllllllllllIIIllIIlIlIIIIl != null) {
                    final NBTTagCompound lllllllllllllllllIIIllIIlIIlllll = new NBTTagCompound();
                    lllllllllllllllllIIIllIIlIIlllll.setTag("data", lllllllllllllllllIIIllIIlIIllIll.writeToNBT(new NBTTagCompound()));
                    final FileOutputStream lllllllllllllllllIIIllIIlIIllllI = new FileOutputStream(lllllllllllllllllIIIllIIlIlIIIIl);
                    CompressedStreamTools.writeCompressed(lllllllllllllllllIIIllIIlIIlllll, lllllllllllllllllIIIllIIlIIllllI);
                    lllllllllllllllllIIIllIIlIIllllI.close();
                }
            }
            catch (Exception lllllllllllllllllIIIllIIlIIlllIl) {
                lllllllllllllllllIIIllIIlIIlllIl.printStackTrace();
            }
        }
    }
    
    public void saveAllData() {
        for (int lllllllllllllllllIIIllIIlIlllIlI = 0; lllllllllllllllllIIIllIIlIlllIlI < this.loadedDataList.size(); ++lllllllllllllllllIIIllIIlIlllIlI) {
            final WorldSavedData lllllllllllllllllIIIllIIlIlllIIl = this.loadedDataList.get(lllllllllllllllllIIIllIIlIlllIlI);
            if (lllllllllllllllllIIIllIIlIlllIIl.isDirty()) {
                this.saveData(lllllllllllllllllIIIllIIlIlllIIl);
                lllllllllllllllllIIIllIIlIlllIIl.setDirty(false);
            }
        }
    }
    
    public int getUniqueDataId(final String lllllllllllllllllIIIllIIIllIllII) {
        Short lllllllllllllllllIIIllIIIlllIIll = this.idCounts.get(lllllllllllllllllIIIllIIIllIllII);
        if (lllllllllllllllllIIIllIIIlllIIll == null) {
            lllllllllllllllllIIIllIIIlllIIll = 0;
        }
        else {
            lllllllllllllllllIIIllIIIlllIIll = (short)(lllllllllllllllllIIIllIIIlllIIll + 1);
        }
        this.idCounts.put(lllllllllllllllllIIIllIIIllIllII, lllllllllllllllllIIIllIIIlllIIll);
        if (this.saveHandler == null) {
            return lllllllllllllllllIIIllIIIlllIIll;
        }
        try {
            final File lllllllllllllllllIIIllIIIlllIIlI = this.saveHandler.getMapFileFromName("idcounts");
            if (lllllllllllllllllIIIllIIIlllIIlI != null) {
                final NBTTagCompound lllllllllllllllllIIIllIIIlllIIIl = new NBTTagCompound();
                for (final String lllllllllllllllllIIIllIIIlllIIII : this.idCounts.keySet()) {
                    lllllllllllllllllIIIllIIIlllIIIl.setShort(lllllllllllllllllIIIllIIIlllIIII, this.idCounts.get(lllllllllllllllllIIIllIIIlllIIII));
                }
                final DataOutputStream lllllllllllllllllIIIllIIIllIllll = new DataOutputStream(new FileOutputStream(lllllllllllllllllIIIllIIIlllIIlI));
                CompressedStreamTools.write(lllllllllllllllllIIIllIIIlllIIIl, lllllllllllllllllIIIllIIIllIllll);
                lllllllllllllllllIIIllIIIllIllll.close();
            }
        }
        catch (Exception lllllllllllllllllIIIllIIIllIlllI) {
            lllllllllllllllllIIIllIIIllIlllI.printStackTrace();
        }
        return lllllllllllllllllIIIllIIIlllIIll;
    }
}
