package net.minecraft.client.multiplayer;

import java.util.concurrent.atomic.*;
import org.apache.logging.log4j.*;
import java.io.*;
import java.nio.charset.*;
import java.net.*;

public class ThreadLanServerPing extends Thread
{
    private /* synthetic */ boolean isStopping;
    private static final /* synthetic */ AtomicInteger UNIQUE_THREAD_ID;
    private final /* synthetic */ DatagramSocket socket;
    private final /* synthetic */ String motd;
    private final /* synthetic */ String address;
    private static final /* synthetic */ Logger LOGGER;
    
    public static String getAdFromPingResponse(final String llllllllllllllIIlIIIllIlIIIlllIl) {
        final int llllllllllllllIIlIIIllIlIIlIIIIl = llllllllllllllIIlIIIllIlIIIlllIl.indexOf("[/MOTD]");
        if (llllllllllllllIIlIIIllIlIIlIIIIl < 0) {
            return null;
        }
        final int llllllllllllllIIlIIIllIlIIlIIIII = llllllllllllllIIlIIIllIlIIIlllIl.indexOf("[/MOTD]", llllllllllllllIIlIIIllIlIIlIIIIl + "[/MOTD]".length());
        if (llllllllllllllIIlIIIllIlIIlIIIII >= 0) {
            return null;
        }
        final int llllllllllllllIIlIIIllIlIIIlllll = llllllllllllllIIlIIIllIlIIIlllIl.indexOf("[AD]", llllllllllllllIIlIIIllIlIIlIIIIl + "[/MOTD]".length());
        if (llllllllllllllIIlIIIllIlIIIlllll < 0) {
            return null;
        }
        final int llllllllllllllIIlIIIllIlIIIllllI = llllllllllllllIIlIIIllIlIIIlllIl.indexOf("[/AD]", llllllllllllllIIlIIIllIlIIIlllll + "[AD]".length());
        return (llllllllllllllIIlIIIllIlIIIllllI < llllllllllllllIIlIIIllIlIIIlllll) ? null : llllllllllllllIIlIIIllIlIIIlllIl.substring(llllllllllllllIIlIIIllIlIIIlllll + "[AD]".length(), llllllllllllllIIlIIIllIlIIIllllI);
    }
    
    static {
        UNIQUE_THREAD_ID = new AtomicInteger(0);
        LOGGER = LogManager.getLogger();
    }
    
    public ThreadLanServerPing(final String llllllllllllllIIlIIIllIlIlIIlIll, final String llllllllllllllIIlIIIllIlIlIIlIlI) throws IOException {
        super(String.valueOf(new StringBuilder("LanServerPinger #").append(ThreadLanServerPing.UNIQUE_THREAD_ID.incrementAndGet())));
        this.isStopping = true;
        this.motd = llllllllllllllIIlIIIllIlIlIIlIll;
        this.address = llllllllllllllIIlIIIllIlIlIIlIlI;
        this.setDaemon(true);
        this.socket = new DatagramSocket();
    }
    
    @Override
    public void interrupt() {
        super.interrupt();
        this.isStopping = false;
    }
    
    public static String getPingResponse(final String llllllllllllllIIlIIIllIlIIllIlII, final String llllllllllllllIIlIIIllIlIIllIIIl) {
        return String.valueOf(new StringBuilder("[MOTD]").append(llllllllllllllIIlIIIllIlIIllIlII).append("[/MOTD][AD]").append(llllllllllllllIIlIIIllIlIIllIIIl).append("[/AD]"));
    }
    
    public static String getMotdFromPingResponse(final String llllllllllllllIIlIIIllIlIIlIllIl) {
        final int llllllllllllllIIlIIIllIlIIlIllII = llllllllllllllIIlIIIllIlIIlIllIl.indexOf("[MOTD]");
        if (llllllllllllllIIlIIIllIlIIlIllII < 0) {
            return "missing no";
        }
        final int llllllllllllllIIlIIIllIlIIlIlIll = llllllllllllllIIlIIIllIlIIlIllIl.indexOf("[/MOTD]", llllllllllllllIIlIIIllIlIIlIllII + "[MOTD]".length());
        return (llllllllllllllIIlIIIllIlIIlIlIll < llllllllllllllIIlIIIllIlIIlIllII) ? "missing no" : llllllllllllllIIlIIIllIlIIlIllIl.substring(llllllllllllllIIlIIIllIlIIlIllII + "[MOTD]".length(), llllllllllllllIIlIIIllIlIIlIlIll);
    }
    
    @Override
    public void run() {
        final String llllllllllllllIIlIIIllIlIlIIIIll = getPingResponse(this.motd, this.address);
        final byte[] llllllllllllllIIlIIIllIlIlIIIIlI = llllllllllllllIIlIIIllIlIlIIIIll.getBytes(StandardCharsets.UTF_8);
        while (!this.isInterrupted() && this.isStopping) {
            try {
                final InetAddress llllllllllllllIIlIIIllIlIlIIIIIl = InetAddress.getByName("224.0.2.60");
                final DatagramPacket llllllllllllllIIlIIIllIlIlIIIIII = new DatagramPacket(llllllllllllllIIlIIIllIlIlIIIIlI, llllllllllllllIIlIIIllIlIlIIIIlI.length, llllllllllllllIIlIIIllIlIlIIIIIl, 4445);
                this.socket.send(llllllllllllllIIlIIIllIlIlIIIIII);
            }
            catch (IOException llllllllllllllIIlIIIllIlIIllllll) {
                ThreadLanServerPing.LOGGER.warn("LanServerPinger: {}", (Object)llllllllllllllIIlIIIllIlIIllllll.getMessage());
                break;
            }
            try {
                Thread.sleep(1500L);
            }
            catch (InterruptedException ex) {}
        }
    }
}
