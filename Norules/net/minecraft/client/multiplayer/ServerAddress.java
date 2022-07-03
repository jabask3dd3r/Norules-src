package net.minecraft.client.multiplayer;

import java.net.*;
import java.util.*;
import javax.naming.directory.*;

public class ServerAddress
{
    private final /* synthetic */ int serverPort;
    private final /* synthetic */ String ipAddress;
    
    public String getIP() {
        try {
            return IDN.toASCII(this.ipAddress);
        }
        catch (IllegalArgumentException lllllllllllllIlIllIIlIlllIIlllII) {
            return "";
        }
    }
    
    public int getPort() {
        return this.serverPort;
    }
    
    private static int getInt(final String lllllllllllllIlIllIIlIllIllIlIll, final int lllllllllllllIlIllIIlIllIllIlIlI) {
        try {
            return Integer.parseInt(lllllllllllllIlIllIIlIllIllIlIll.trim());
        }
        catch (Exception lllllllllllllIlIllIIlIllIllIllII) {
            return lllllllllllllIlIllIIlIllIllIlIlI;
        }
    }
    
    public static ServerAddress fromString(final String lllllllllllllIlIllIIlIlllIIIlIIl) {
        if (lllllllllllllIlIllIIlIlllIIIlIIl == null) {
            return null;
        }
        String[] lllllllllllllIlIllIIlIlllIIlIIII = lllllllllllllIlIllIIlIlllIIIlIIl.split(":");
        if (lllllllllllllIlIllIIlIlllIIIlIIl.startsWith("[")) {
            final int lllllllllllllIlIllIIlIlllIIIllll = lllllllllllllIlIllIIlIlllIIIlIIl.indexOf("]");
            if (lllllllllllllIlIllIIlIlllIIIllll > 0) {
                final String lllllllllllllIlIllIIlIlllIIIlllI = lllllllllllllIlIllIIlIlllIIIlIIl.substring(1, lllllllllllllIlIllIIlIlllIIIllll);
                String lllllllllllllIlIllIIlIlllIIIllIl = lllllllllllllIlIllIIlIlllIIIlIIl.substring(lllllllllllllIlIllIIlIlllIIIllll + 1).trim();
                if (lllllllllllllIlIllIIlIlllIIIllIl.startsWith(":") && !lllllllllllllIlIllIIlIlllIIIllIl.isEmpty()) {
                    lllllllllllllIlIllIIlIlllIIIllIl = lllllllllllllIlIllIIlIlllIIIllIl.substring(1);
                    lllllllllllllIlIllIIlIlllIIlIIII = new String[] { lllllllllllllIlIllIIlIlllIIIlllI, lllllllllllllIlIllIIlIlllIIIllIl };
                }
                else {
                    lllllllllllllIlIllIIlIlllIIlIIII = new String[] { lllllllllllllIlIllIIlIlllIIIlllI };
                }
            }
        }
        if (lllllllllllllIlIllIIlIlllIIlIIII.length > 2) {
            lllllllllllllIlIllIIlIlllIIlIIII = new String[] { lllllllllllllIlIllIIlIlllIIIlIIl };
        }
        String lllllllllllllIlIllIIlIlllIIIllII = lllllllllllllIlIllIIlIlllIIlIIII[0];
        int lllllllllllllIlIllIIlIlllIIIlIll = (lllllllllllllIlIllIIlIlllIIlIIII.length > 1) ? getInt(lllllllllllllIlIllIIlIlllIIlIIII[1], 25565) : 25565;
        if (lllllllllllllIlIllIIlIlllIIIlIll == 25565) {
            final String[] lllllllllllllIlIllIIlIlllIIIlIlI = getServerAddress(lllllllllllllIlIllIIlIlllIIIllII);
            lllllllllllllIlIllIIlIlllIIIllII = lllllllllllllIlIllIIlIlllIIIlIlI[0];
            lllllllllllllIlIllIIlIlllIIIlIll = getInt(lllllllllllllIlIllIIlIlllIIIlIlI[1], 25565);
        }
        return new ServerAddress(lllllllllllllIlIllIIlIlllIIIllII, lllllllllllllIlIllIIlIlllIIIlIll);
    }
    
    private static String[] getServerAddress(final String lllllllllllllIlIllIIlIllIllllllI) {
        try {
            final String lllllllllllllIlIllIIlIllIlllllIl = "com.sun.jndi.dns.DnsContextFactory";
            Class.forName("com.sun.jndi.dns.DnsContextFactory");
            final Hashtable<String, String> lllllllllllllIlIllIIlIllIlllllII = new Hashtable<String, String>();
            lllllllllllllIlIllIIlIllIlllllII.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
            lllllllllllllIlIllIIlIllIlllllII.put("java.naming.provider.url", "dns:");
            lllllllllllllIlIllIIlIllIlllllII.put("com.sun.jndi.dns.timeout.retries", "1");
            final DirContext lllllllllllllIlIllIIlIllIllllIll = new InitialDirContext(lllllllllllllIlIllIIlIllIlllllII);
            final Attributes lllllllllllllIlIllIIlIllIllllIlI = lllllllllllllIlIllIIlIllIllllIll.getAttributes(String.valueOf(new StringBuilder("_minecraft._tcp.").append(lllllllllllllIlIllIIlIllIllllllI)), new String[] { "SRV" });
            final String[] lllllllllllllIlIllIIlIllIllllIIl = lllllllllllllIlIllIIlIllIllllIlI.get("srv").get().toString().split(" ", 4);
            return new String[] { lllllllllllllIlIllIIlIllIllllIIl[3], lllllllllllllIlIllIIlIllIllllIIl[2] };
        }
        catch (Throwable lllllllllllllIlIllIIlIllIllllIII) {
            return new String[] { lllllllllllllIlIllIIlIllIllllllI, Integer.toString(25565) };
        }
    }
    
    private ServerAddress(final String lllllllllllllIlIllIIlIlllIlIIlII, final int lllllllllllllIlIllIIlIlllIlIIIII) {
        this.ipAddress = lllllllllllllIlIllIIlIlllIlIIlII;
        this.serverPort = lllllllllllllIlIllIIlIlllIlIIIII;
    }
}
