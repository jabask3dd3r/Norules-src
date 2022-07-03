package net.minecraft.client.network;

import java.util.concurrent.atomic.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;
import net.minecraft.client.multiplayer.*;
import java.util.*;
import java.io.*;
import java.net.*;
import java.nio.charset.*;

public class LanServerDetector
{
    private static final /* synthetic */ Logger LOGGER;
    private static final /* synthetic */ AtomicInteger ATOMIC_COUNTER;
    
    static {
        ATOMIC_COUNTER = new AtomicInteger(0);
        LOGGER = LogManager.getLogger();
    }
    
    public static class LanServerList
    {
        private final /* synthetic */ List<LanServerInfo> listOfLanServers;
        /* synthetic */ boolean wasUpdated;
        
        public synchronized boolean getWasUpdated() {
            return this.wasUpdated;
        }
        
        public LanServerList() {
            this.listOfLanServers = (List<LanServerInfo>)Lists.newArrayList();
        }
        
        public synchronized void addServer(final String llllllllllllllIIIllllIlIIllIIIll, final InetAddress llllllllllllllIIIllllIlIIllIIIlI) {
            final String llllllllllllllIIIllllIlIIllIlIII = ThreadLanServerPing.getMotdFromPingResponse(llllllllllllllIIIllllIlIIllIIIll);
            String llllllllllllllIIIllllIlIIllIIlll = ThreadLanServerPing.getAdFromPingResponse(llllllllllllllIIIllllIlIIllIIIll);
            if (llllllllllllllIIIllllIlIIllIIlll != null) {
                llllllllllllllIIIllllIlIIllIIlll = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIllllIlIIllIIIlI.getHostAddress())).append(":").append(llllllllllllllIIIllllIlIIllIIlll));
                boolean llllllllllllllIIIllllIlIIllIIllI = false;
                for (final LanServerInfo llllllllllllllIIIllllIlIIllIIlIl : this.listOfLanServers) {
                    if (llllllllllllllIIIllllIlIIllIIlIl.getServerIpPort().equals(llllllllllllllIIIllllIlIIllIIlll)) {
                        llllllllllllllIIIllllIlIIllIIlIl.updateLastSeen();
                        llllllllllllllIIIllllIlIIllIIllI = true;
                        break;
                    }
                }
                if (!llllllllllllllIIIllllIlIIllIIllI) {
                    this.listOfLanServers.add(new LanServerInfo(llllllllllllllIIIllllIlIIllIlIII, llllllllllllllIIIllllIlIIllIIlll));
                    this.wasUpdated = true;
                }
            }
        }
        
        public synchronized void setWasNotUpdated() {
            this.wasUpdated = false;
        }
        
        public synchronized List<LanServerInfo> getLanServers() {
            return Collections.unmodifiableList((List<? extends LanServerInfo>)this.listOfLanServers);
        }
    }
    
    public static class ThreadLanServerFind extends Thread
    {
        private final /* synthetic */ MulticastSocket socket;
        private final /* synthetic */ LanServerList localServerList;
        private final /* synthetic */ InetAddress broadcastAddress;
        
        public ThreadLanServerFind(final LanServerList llllllllllllllIIlllIllIIIlIIllIl) throws IOException {
            super(String.valueOf(new StringBuilder("LanServerDetector #").append(LanServerDetector.ATOMIC_COUNTER.incrementAndGet())));
            this.localServerList = llllllllllllllIIlllIllIIIlIIllIl;
            this.setDaemon(true);
            this.socket = new MulticastSocket(4445);
            this.broadcastAddress = InetAddress.getByName("224.0.2.60");
            this.socket.setSoTimeout(5000);
            this.socket.joinGroup(this.broadcastAddress);
        }
        
        @Override
        public void run() {
            final byte[] llllllllllllllIIlllIllIIIlIIIlll = new byte[1024];
            while (!this.isInterrupted()) {
                final DatagramPacket llllllllllllllIIlllIllIIIlIIIllI = new DatagramPacket(llllllllllllllIIlllIllIIIlIIIlll, llllllllllllllIIlllIllIIIlIIIlll.length);
                try {
                    this.socket.receive(llllllllllllllIIlllIllIIIlIIIllI);
                }
                catch (SocketTimeoutException llllllllllllllIIlllIllIIIlIIIlIl) {
                    continue;
                }
                catch (IOException llllllllllllllIIlllIllIIIlIIIlII) {
                    LanServerDetector.LOGGER.error("Couldn't ping server", (Throwable)llllllllllllllIIlllIllIIIlIIIlII);
                    break;
                }
                final String llllllllllllllIIlllIllIIIlIIIIll = new String(llllllllllllllIIlllIllIIIlIIIllI.getData(), llllllllllllllIIlllIllIIIlIIIllI.getOffset(), llllllllllllllIIlllIllIIIlIIIllI.getLength(), StandardCharsets.UTF_8);
                LanServerDetector.LOGGER.debug("{}: {}", (Object)llllllllllllllIIlllIllIIIlIIIllI.getAddress(), (Object)llllllllllllllIIlllIllIIIlIIIIll);
                this.localServerList.addServer(llllllllllllllIIlllIllIIIlIIIIll, llllllllllllllIIlllIllIIIlIIIllI.getAddress());
            }
            try {
                this.socket.leaveGroup(this.broadcastAddress);
            }
            catch (IOException ex) {}
            this.socket.close();
        }
    }
}
