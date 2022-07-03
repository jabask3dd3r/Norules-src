package net.minecraft.stats;

import net.minecraft.server.*;
import com.google.common.collect.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.entity.player.*;
import org.apache.logging.log4j.*;
import net.minecraft.util.*;
import java.lang.reflect.*;
import java.util.*;
import org.apache.commons.io.*;
import java.io.*;
import com.google.gson.*;

public class StatisticsManagerServer extends StatisticsManager
{
    private final /* synthetic */ Set<StatBase> dirty;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ MinecraftServer mcServer;
    private final /* synthetic */ File statsFile;
    private /* synthetic */ int lastStatRequest;
    
    private Set<StatBase> getDirty() {
        final Set<StatBase> lllllllllllllIllIlllllIIlIIllIII = (Set<StatBase>)Sets.newHashSet((Iterable)this.dirty);
        this.dirty.clear();
        return lllllllllllllIllIlllllIIlIIllIII;
    }
    
    public static String dumpJson(final Map<StatBase, TupleIntJsonSerializable> lllllllllllllIllIlllllIIIllIlIll) {
        final JsonObject lllllllllllllIllIlllllIIIllIlIlI = new JsonObject();
        for (final Map.Entry<StatBase, TupleIntJsonSerializable> lllllllllllllIllIlllllIIIllIlIIl : lllllllllllllIllIlllllIIIllIlIll.entrySet()) {
            if (lllllllllllllIllIlllllIIIllIlIIl.getValue().getJsonSerializableValue() != null) {
                final JsonObject lllllllllllllIllIlllllIIIllIlIII = new JsonObject();
                lllllllllllllIllIlllllIIIllIlIII.addProperty("value", (Number)lllllllllllllIllIlllllIIIllIlIIl.getValue().getIntegerValue());
                try {
                    lllllllllllllIllIlllllIIIllIlIII.add("progress", lllllllllllllIllIlllllIIIllIlIIl.getValue().getJsonSerializableValue().getSerializableElement());
                }
                catch (Throwable lllllllllllllIllIlllllIIIllIIlll) {
                    StatisticsManagerServer.LOGGER.warn("Couldn't save statistic {}: error serializing progress", (Object)lllllllllllllIllIlllllIIIllIlIIl.getKey().getStatName(), (Object)lllllllllllllIllIlllllIIIllIIlll);
                }
                lllllllllllllIllIlllllIIIllIlIlI.add(lllllllllllllIllIlllllIIIllIlIIl.getKey().statId, (JsonElement)lllllllllllllIllIlllllIIIllIlIII);
            }
            else {
                lllllllllllllIllIlllllIIIllIlIlI.addProperty(lllllllllllllIllIlllllIIIllIlIIl.getKey().statId, (Number)lllllllllllllIllIlllllIIIllIlIIl.getValue().getIntegerValue());
            }
        }
        return lllllllllllllIllIlllllIIIllIlIlI.toString();
    }
    
    public void sendStats(final EntityPlayerMP lllllllllllllIllIlllllIIIlIlIIIl) {
        final int lllllllllllllIllIlllllIIIlIlIlIl = this.mcServer.getTickCounter();
        final Map<StatBase, Integer> lllllllllllllIllIlllllIIIlIlIlII = (Map<StatBase, Integer>)Maps.newHashMap();
        if (lllllllllllllIllIlllllIIIlIlIlIl - this.lastStatRequest > 300) {
            this.lastStatRequest = lllllllllllllIllIlllllIIIlIlIlIl;
            for (final StatBase lllllllllllllIllIlllllIIIlIlIIll : this.getDirty()) {
                lllllllllllllIllIlllllIIIlIlIlII.put(lllllllllllllIllIlllllIIIlIlIIll, this.readStat(lllllllllllllIllIlllllIIIlIlIIll));
            }
        }
        lllllllllllllIllIlllllIIIlIlIIIl.connection.sendPacket(new SPacketStatistics(lllllllllllllIllIlllllIIIlIlIlII));
    }
    
    @Override
    public void unlockAchievement(final EntityPlayer lllllllllllllIllIlllllIIlIIllllI, final StatBase lllllllllllllIllIlllllIIlIlIIIIl, final int lllllllllllllIllIlllllIIlIlIIIII) {
        super.unlockAchievement(lllllllllllllIllIlllllIIlIIllllI, lllllllllllllIllIlllllIIlIlIIIIl, lllllllllllllIllIlllllIIlIlIIIII);
        this.dirty.add(lllllllllllllIllIlllllIIlIlIIIIl);
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public StatisticsManagerServer(final MinecraftServer lllllllllllllIllIlllllIIlIllIllI, final File lllllllllllllIllIlllllIIlIllIlIl) {
        this.dirty = (Set<StatBase>)Sets.newHashSet();
        this.lastStatRequest = -300;
        this.mcServer = lllllllllllllIllIlllllIIlIllIllI;
        this.statsFile = lllllllllllllIllIlllllIIlIllIlIl;
    }
    
    public Map<StatBase, TupleIntJsonSerializable> parseJson(final String lllllllllllllIllIlllllIIlIIIlIII) {
        final JsonElement lllllllllllllIllIlllllIIlIIIIlll = new JsonParser().parse(lllllllllllllIllIlllllIIlIIIlIII);
        if (!lllllllllllllIllIlllllIIlIIIIlll.isJsonObject()) {
            return (Map<StatBase, TupleIntJsonSerializable>)Maps.newHashMap();
        }
        final JsonObject lllllllllllllIllIlllllIIlIIIIllI = lllllllllllllIllIlllllIIlIIIIlll.getAsJsonObject();
        final Map<StatBase, TupleIntJsonSerializable> lllllllllllllIllIlllllIIlIIIIlIl = (Map<StatBase, TupleIntJsonSerializable>)Maps.newHashMap();
        for (final Map.Entry<String, JsonElement> lllllllllllllIllIlllllIIlIIIIlII : lllllllllllllIllIlllllIIlIIIIllI.entrySet()) {
            final StatBase lllllllllllllIllIlllllIIlIIIIIll = StatList.getOneShotStat(lllllllllllllIllIlllllIIlIIIIlII.getKey());
            if (lllllllllllllIllIlllllIIlIIIIIll != null) {
                final TupleIntJsonSerializable lllllllllllllIllIlllllIIlIIIIIlI = new TupleIntJsonSerializable();
                if (lllllllllllllIllIlllllIIlIIIIlII.getValue().isJsonPrimitive() && lllllllllllllIllIlllllIIlIIIIlII.getValue().getAsJsonPrimitive().isNumber()) {
                    lllllllllllllIllIlllllIIlIIIIIlI.setIntegerValue(lllllllllllllIllIlllllIIlIIIIlII.getValue().getAsInt());
                }
                else if (lllllllllllllIllIlllllIIlIIIIlII.getValue().isJsonObject()) {
                    final JsonObject lllllllllllllIllIlllllIIlIIIIIIl = lllllllllllllIllIlllllIIlIIIIlII.getValue().getAsJsonObject();
                    if (lllllllllllllIllIlllllIIlIIIIIIl.has("value") && lllllllllllllIllIlllllIIlIIIIIIl.get("value").isJsonPrimitive() && lllllllllllllIllIlllllIIlIIIIIIl.get("value").getAsJsonPrimitive().isNumber()) {
                        lllllllllllllIllIlllllIIlIIIIIlI.setIntegerValue(lllllllllllllIllIlllllIIlIIIIIIl.getAsJsonPrimitive("value").getAsInt());
                    }
                    if (lllllllllllllIllIlllllIIlIIIIIIl.has("progress") && lllllllllllllIllIlllllIIlIIIIIll.getSerializableClazz() != null) {
                        try {
                            final Constructor<? extends IJsonSerializable> lllllllllllllIllIlllllIIlIIIIIII = lllllllllllllIllIlllllIIlIIIIIll.getSerializableClazz().getConstructor((Class<?>[])new Class[0]);
                            final IJsonSerializable lllllllllllllIllIlllllIIIlllllll = (IJsonSerializable)lllllllllllllIllIlllllIIlIIIIIII.newInstance(new Object[0]);
                            lllllllllllllIllIlllllIIIlllllll.fromJson(lllllllllllllIllIlllllIIlIIIIIIl.get("progress"));
                            lllllllllllllIllIlllllIIlIIIIIlI.setJsonSerializableValue(lllllllllllllIllIlllllIIIlllllll);
                        }
                        catch (Throwable lllllllllllllIllIlllllIIIllllllI) {
                            StatisticsManagerServer.LOGGER.warn("Invalid statistic progress in {}", (Object)this.statsFile, (Object)lllllllllllllIllIlllllIIIllllllI);
                        }
                    }
                }
                lllllllllllllIllIlllllIIlIIIIlIl.put(lllllllllllllIllIlllllIIlIIIIIll, lllllllllllllIllIlllllIIlIIIIIlI);
            }
            else {
                StatisticsManagerServer.LOGGER.warn("Invalid statistic in {}: Don't know what {} is", (Object)this.statsFile, (Object)lllllllllllllIllIlllllIIlIIIIlII.getKey());
            }
        }
        return lllllllllllllIllIlllllIIlIIIIlIl;
    }
    
    public void markAllDirty() {
        this.dirty.addAll(this.statsData.keySet());
    }
    
    public void readStatFile() {
        if (this.statsFile.isFile()) {
            try {
                this.statsData.clear();
                this.statsData.putAll(this.parseJson(FileUtils.readFileToString(this.statsFile)));
            }
            catch (IOException lllllllllllllIllIlllllIIlIllIIIl) {
                StatisticsManagerServer.LOGGER.error("Couldn't read statistics file {}", (Object)this.statsFile, (Object)lllllllllllllIllIlllllIIlIllIIIl);
            }
            catch (JsonParseException lllllllllllllIllIlllllIIlIllIIII) {
                StatisticsManagerServer.LOGGER.error("Couldn't parse statistics file {}", (Object)this.statsFile, (Object)lllllllllllllIllIlllllIIlIllIIII);
            }
        }
    }
    
    public void saveStatFile() {
        try {
            FileUtils.writeStringToFile(this.statsFile, dumpJson(this.statsData));
        }
        catch (IOException lllllllllllllIllIlllllIIlIlIlIlI) {
            StatisticsManagerServer.LOGGER.error("Couldn't save stats", (Throwable)lllllllllllllIllIlllllIIlIlIlIlI);
        }
    }
}
