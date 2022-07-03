package net.minecraft.util.datafix;

import java.util.*;
import net.minecraft.nbt.*;
import org.apache.logging.log4j.*;
import net.minecraft.util.*;
import com.google.common.collect.*;

public class DataFixer implements IDataFixer
{
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ Map<IFixType, List<IFixableData>> fixMap;
    private final /* synthetic */ int version;
    private final /* synthetic */ Map<IFixType, List<IDataWalker>> walkerMap;
    
    public void registerWalker(final FixTypes lllllllllllllIIIlIIIIIllIIIIIlll, final IDataWalker lllllllllllllIIIlIIIIIllIIIIIllI) {
        this.registerWalkerAdd(lllllllllllllIIIlIIIIIllIIIIIlll, lllllllllllllIIIlIIIIIllIIIIIllI);
    }
    
    public void registerWalkerAdd(final IFixType lllllllllllllIIIlIIIIIlIlllllIll, final IDataWalker lllllllllllllIIIlIIIIIlIlllllIlI) {
        this.getTypeList(this.walkerMap, lllllllllllllIIIlIIIIIlIlllllIll).add(lllllllllllllIIIlIIIIIlIlllllIlI);
    }
    
    public NBTTagCompound process(final IFixType lllllllllllllIIIlIIIIIllIlIIIIIl, final NBTTagCompound lllllllllllllIIIlIIIIIllIlIIIlII) {
        final int lllllllllllllIIIlIIIIIllIlIIIIll = lllllllllllllIIIlIIIIIllIlIIIlII.hasKey("DataVersion", 99) ? lllllllllllllIIIlIIIIIllIlIIIlII.getInteger("DataVersion") : -1;
        return (lllllllllllllIIIlIIIIIllIlIIIIll >= 1343) ? lllllllllllllIIIlIIIIIllIlIIIlII : this.process(lllllllllllllIIIlIIIIIllIlIIIIIl, lllllllllllllIIIlIIIIIllIlIIIlII, lllllllllllllIIIlIIIIIllIlIIIIll);
    }
    
    private NBTTagCompound processFixes(final IFixType lllllllllllllIIIlIIIIIllIIlIlIlI, NBTTagCompound lllllllllllllIIIlIIIIIllIIlIIIlI, final int lllllllllllllIIIlIIIIIllIIlIIIIl) {
        final List<IFixableData> lllllllllllllIIIlIIIIIllIIlIIlll = this.fixMap.get(lllllllllllllIIIlIIIIIllIIlIlIlI);
        if (lllllllllllllIIIlIIIIIllIIlIIlll != null) {
            for (int lllllllllllllIIIlIIIIIllIIlIIllI = 0; lllllllllllllIIIlIIIIIllIIlIIllI < lllllllllllllIIIlIIIIIllIIlIIlll.size(); ++lllllllllllllIIIlIIIIIllIIlIIllI) {
                final IFixableData lllllllllllllIIIlIIIIIllIIlIIlIl = lllllllllllllIIIlIIIIIllIIlIIlll.get(lllllllllllllIIIlIIIIIllIIlIIllI);
                if (lllllllllllllIIIlIIIIIllIIlIIlIl.getFixVersion() > lllllllllllllIIIlIIIIIllIIlIIIIl) {
                    lllllllllllllIIIlIIIIIllIIlIIIlI = lllllllllllllIIIlIIIIIllIIlIIlIl.fixTagCompound(lllllllllllllIIIlIIIIIllIIlIIIlI);
                }
            }
        }
        return lllllllllllllIIIlIIIIIllIIlIIIlI;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public DataFixer(final int lllllllllllllIIIlIIIIIllIlIIlIll) {
        this.walkerMap = (Map<IFixType, List<IDataWalker>>)Maps.newHashMap();
        this.fixMap = (Map<IFixType, List<IFixableData>>)Maps.newHashMap();
        this.version = lllllllllllllIIIlIIIIIllIlIIlIll;
    }
    
    @Override
    public NBTTagCompound process(final IFixType lllllllllllllIIIlIIIIIllIIlllIIl, NBTTagCompound lllllllllllllIIIlIIIIIllIIllIlII, final int lllllllllllllIIIlIIIIIllIIllIlll) {
        if (lllllllllllllIIIlIIIIIllIIllIlll < this.version) {
            lllllllllllllIIIlIIIIIllIIllIlII = (long)this.processFixes(lllllllllllllIIIlIIIIIllIIlllIIl, (NBTTagCompound)lllllllllllllIIIlIIIIIllIIllIlII, lllllllllllllIIIlIIIIIllIIllIlll);
            lllllllllllllIIIlIIIIIllIIllIlII = (long)this.processWalkers(lllllllllllllIIIlIIIIIllIIlllIIl, (NBTTagCompound)lllllllllllllIIIlIIIIIllIIllIlII, lllllllllllllIIIlIIIIIllIIllIlll);
        }
        return (NBTTagCompound)lllllllllllllIIIlIIIIIllIIllIlII;
    }
    
    private NBTTagCompound processWalkers(final IFixType lllllllllllllIIIlIIIIIllIIIlIIII, NBTTagCompound lllllllllllllIIIlIIIIIllIIIIllll, final int lllllllllllllIIIlIIIIIllIIIlIlII) {
        final List<IDataWalker> lllllllllllllIIIlIIIIIllIIIlIIll = this.walkerMap.get(lllllllllllllIIIlIIIIIllIIIlIIII);
        if (lllllllllllllIIIlIIIIIllIIIlIIll != null) {
            for (int lllllllllllllIIIlIIIIIllIIIlIIlI = 0; lllllllllllllIIIlIIIIIllIIIlIIlI < lllllllllllllIIIlIIIIIllIIIlIIll.size(); ++lllllllllllllIIIlIIIIIllIIIlIIlI) {
                lllllllllllllIIIlIIIIIllIIIIllll = lllllllllllllIIIlIIIIIllIIIlIIll.get(lllllllllllllIIIlIIIIIllIIIlIIlI).process(this, lllllllllllllIIIlIIIIIllIIIIllll, lllllllllllllIIIlIIIIIllIIIlIlII);
            }
        }
        return lllllllllllllIIIlIIIIIllIIIIllll;
    }
    
    public void registerFix(final IFixType lllllllllllllIIIlIIIIIlIllllIIlI, final IFixableData lllllllllllllIIIlIIIIIlIllllIIIl) {
        final List<IFixableData> lllllllllllllIIIlIIIIIlIllllIIII = this.getTypeList(this.fixMap, lllllllllllllIIIlIIIIIlIllllIIlI);
        final int lllllllllllllIIIlIIIIIlIlllIllll = lllllllllllllIIIlIIIIIlIllllIIIl.getFixVersion();
        if (lllllllllllllIIIlIIIIIlIlllIllll > this.version) {
            DataFixer.LOGGER.warn("Ignored fix registered for version: {} as the DataVersion of the game is: {}", (Object)lllllllllllllIIIlIIIIIlIlllIllll, (Object)this.version);
        }
        else if (!lllllllllllllIIIlIIIIIlIllllIIII.isEmpty() && Util.getLastElement(lllllllllllllIIIlIIIIIlIllllIIII).getFixVersion() > lllllllllllllIIIlIIIIIlIlllIllll) {
            for (int lllllllllllllIIIlIIIIIlIlllIlllI = 0; lllllllllllllIIIlIIIIIlIlllIlllI < lllllllllllllIIIlIIIIIlIllllIIII.size(); ++lllllllllllllIIIlIIIIIlIlllIlllI) {
                if (lllllllllllllIIIlIIIIIlIllllIIII.get(lllllllllllllIIIlIIIIIlIlllIlllI).getFixVersion() > lllllllllllllIIIlIIIIIlIlllIllll) {
                    lllllllllllllIIIlIIIIIlIllllIIII.add(lllllllllllllIIIlIIIIIlIlllIlllI, lllllllllllllIIIlIIIIIlIllllIIIl);
                    break;
                }
            }
        }
        else {
            lllllllllllllIIIlIIIIIlIllllIIII.add(lllllllllllllIIIlIIIIIlIllllIIIl);
        }
    }
    
    private <V> List<V> getTypeList(final Map<IFixType, List<V>> lllllllllllllIIIlIIIIIlIlllIIIII, final IFixType lllllllllllllIIIlIIIIIlIlllIIIlI) {
        List<V> lllllllllllllIIIlIIIIIlIlllIIIIl = lllllllllllllIIIlIIIIIlIlllIIIII.get(lllllllllllllIIIlIIIIIlIlllIIIlI);
        if (lllllllllllllIIIlIIIIIlIlllIIIIl == null) {
            lllllllllllllIIIlIIIIIlIlllIIIIl = (List<V>)Lists.newArrayList();
            lllllllllllllIIIlIIIIIlIlllIIIII.put(lllllllllllllIIIlIIIIIlIlllIIIlI, lllllllllllllIIIlIIIIIlIlllIIIIl);
        }
        return lllllllllllllIIIlIIIIIlIlllIIIIl;
    }
}
