package net.minecraft.client.multiplayer;

import net.minecraft.client.*;
import java.util.*;
import java.io.*;
import net.minecraft.nbt.*;
import com.google.common.collect.*;
import org.apache.logging.log4j.*;

public class ServerList
{
    private final /* synthetic */ Minecraft mc;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ List<ServerData> servers;
    
    public void saveServerList() {
        try {
            final NBTTagList lllllllllllllIIllIIIlIIlIIIIIllI = new NBTTagList();
            for (final ServerData lllllllllllllIIllIIIlIIlIIIIIlIl : this.servers) {
                lllllllllllllIIllIIIlIIlIIIIIllI.appendTag(lllllllllllllIIllIIIlIIlIIIIIlIl.getNBTCompound());
            }
            final NBTTagCompound lllllllllllllIIllIIIlIIlIIIIIlII = new NBTTagCompound();
            lllllllllllllIIllIIIlIIlIIIIIlII.setTag("servers", lllllllllllllIIllIIIlIIlIIIIIllI);
            CompressedStreamTools.safeWrite(lllllllllllllIIllIIIlIIlIIIIIlII, new File(this.mc.mcDataDir, "servers.dat"));
        }
        catch (Exception lllllllllllllIIllIIIlIIlIIIIIIll) {
            ServerList.LOGGER.error("Couldn't save server list", (Throwable)lllllllllllllIIllIIIlIIlIIIIIIll);
        }
    }
    
    public void addServerData(final ServerData lllllllllllllIIllIIIlIIIlllIllIl) {
        this.servers.add(lllllllllllllIIllIIIlIIIlllIllIl);
    }
    
    public void set(final int lllllllllllllIIllIIIlIIIllIllIIl, final ServerData lllllllllllllIIllIIIlIIIllIllIII) {
        this.servers.set(lllllllllllllIIllIIIlIIIllIllIIl, lllllllllllllIIllIIIlIIIllIllIII);
    }
    
    public void removeServerData(final int lllllllllllllIIllIIIlIIIllllIlIl) {
        this.servers.remove(lllllllllllllIIllIIIlIIIllllIlIl);
    }
    
    public void swapServers(final int lllllllllllllIIllIIIlIIIlllIIIII, final int lllllllllllllIIllIIIlIIIlllIIIll) {
        final ServerData lllllllllllllIIllIIIlIIIlllIIIlI = this.getServerData(lllllllllllllIIllIIIlIIIlllIIIII);
        this.servers.set(lllllllllllllIIllIIIlIIIlllIIIII, this.getServerData(lllllllllllllIIllIIIlIIIlllIIIll));
        this.servers.set(lllllllllllllIIllIIIlIIIlllIIIll, lllllllllllllIIllIIIlIIIlllIIIlI);
        this.saveServerList();
    }
    
    public void loadServerList() {
        try {
            this.servers.clear();
            final NBTTagCompound lllllllllllllIIllIIIlIIlIIIlIIll = CompressedStreamTools.read(new File(this.mc.mcDataDir, "servers.dat"));
            if (lllllllllllllIIllIIIlIIlIIIlIIll == null) {
                return;
            }
            final NBTTagList lllllllllllllIIllIIIlIIlIIIlIIlI = lllllllllllllIIllIIIlIIlIIIlIIll.getTagList("servers", 10);
            for (int lllllllllllllIIllIIIlIIlIIIlIIIl = 0; lllllllllllllIIllIIIlIIlIIIlIIIl < lllllllllllllIIllIIIlIIlIIIlIIlI.tagCount(); ++lllllllllllllIIllIIIlIIlIIIlIIIl) {
                this.servers.add(ServerData.getServerDataFromNBTCompound(lllllllllllllIIllIIIlIIlIIIlIIlI.getCompoundTagAt(lllllllllllllIIllIIIlIIlIIIlIIIl)));
            }
        }
        catch (Exception lllllllllllllIIllIIIlIIlIIIlIIII) {
            ServerList.LOGGER.error("Couldn't load server list", (Throwable)lllllllllllllIIllIIIlIIlIIIlIIII);
        }
    }
    
    public static void saveSingleServer(final ServerData lllllllllllllIIllIIIlIIIllIlIIII) {
        final ServerList lllllllllllllIIllIIIlIIIllIIllll = new ServerList(Minecraft.getMinecraft());
        lllllllllllllIIllIIIlIIIllIIllll.loadServerList();
        for (int lllllllllllllIIllIIIlIIIllIIlllI = 0; lllllllllllllIIllIIIlIIIllIIlllI < lllllllllllllIIllIIIlIIIllIIllll.countServers(); ++lllllllllllllIIllIIIlIIIllIIlllI) {
            final ServerData lllllllllllllIIllIIIlIIIllIIllIl = lllllllllllllIIllIIIlIIIllIIllll.getServerData(lllllllllllllIIllIIIlIIIllIIlllI);
            if (lllllllllllllIIllIIIlIIIllIIllIl.serverName.equals(lllllllllllllIIllIIIlIIIllIlIIII.serverName) && lllllllllllllIIllIIIlIIIllIIllIl.serverIP.equals(lllllllllllllIIllIIIlIIIllIlIIII.serverIP)) {
                lllllllllllllIIllIIIlIIIllIIllll.set(lllllllllllllIIllIIIlIIIllIIlllI, lllllllllllllIIllIIIlIIIllIlIIII);
                break;
            }
        }
        lllllllllllllIIllIIIlIIIllIIllll.saveServerList();
    }
    
    public int countServers() {
        return this.servers.size();
    }
    
    public ServerList(final Minecraft lllllllllllllIIllIIIlIIlIIIllIIl) {
        this.servers = (List<ServerData>)Lists.newArrayList();
        this.mc = lllllllllllllIIllIIIlIIlIIIllIIl;
        this.loadServerList();
    }
    
    public ServerData getServerData(final int lllllllllllllIIllIIIlIIIlllllIll) {
        return this.servers.get(lllllllllllllIIllIIIlIIIlllllIll);
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
}
