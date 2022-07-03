package de.gerrygames.viarewind.utils;

import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.exception.*;

public class PacketUtil
{
    public static boolean sendPacket(final PacketWrapper llllllllllllIlllllIlIllllIlllIll, final Class<? extends Protocol> llllllllllllIlllllIlIllllIllIllI, final boolean llllllllllllIlllllIlIllllIlllIIl, final boolean llllllllllllIlllllIlIllllIlllIII) {
        try {
            if (llllllllllllIlllllIlIllllIlllIII) {
                llllllllllllIlllllIlIllllIlllIll.send(llllllllllllIlllllIlIllllIllIllI, llllllllllllIlllllIlIllllIlllIIl);
            }
            else {
                llllllllllllIlllllIlIllllIlllIll.scheduleSend(llllllllllllIlllllIlIllllIllIllI, llllllllllllIlllllIlIllllIlllIIl);
            }
            return true;
        }
        catch (CancelException llllllllllllIlllllIlIllllIllIIll) {}
        catch (Exception llllllllllllIlllllIlIllllIllllII) {
            llllllllllllIlllllIlIllllIllllII.printStackTrace();
        }
        return false;
    }
    
    public static void sendToServer(final PacketWrapper llllllllllllIlllllIlIlllllIlIIll, final Class<? extends Protocol> llllllllllllIlllllIlIlllllIlIIlI, final boolean llllllllllllIlllllIlIlllllIlIlIl, final boolean llllllllllllIlllllIlIlllllIlIlII) {
        try {
            if (llllllllllllIlllllIlIlllllIlIlII) {
                llllllllllllIlllllIlIlllllIlIIll.sendToServer(llllllllllllIlllllIlIlllllIlIIlI, llllllllllllIlllllIlIlllllIlIlIl);
            }
            else {
                llllllllllllIlllllIlIlllllIlIIll.scheduleSendToServer(llllllllllllIlllllIlIlllllIlIIlI, llllllllllllIlllllIlIlllllIlIlIl);
            }
        }
        catch (CancelException ex) {}
        catch (Exception llllllllllllIlllllIlIlllllIllIII) {
            llllllllllllIlllllIlIlllllIllIII.printStackTrace();
        }
    }
    
    public static boolean sendPacket(final PacketWrapper llllllllllllIlllllIlIlllllIIIllI, final Class<? extends Protocol> llllllllllllIlllllIlIlllllIIIlIl, final boolean llllllllllllIlllllIlIlllllIIIlII) {
        return sendPacket(llllllllllllIlllllIlIlllllIIIllI, llllllllllllIlllllIlIlllllIIIlIl, true, false);
    }
    
    public static boolean sendPacket(final PacketWrapper llllllllllllIlllllIlIlllllIIlIlI, final Class<? extends Protocol> llllllllllllIlllllIlIlllllIIlIll) {
        return sendPacket(llllllllllllIlllllIlIlllllIIlIlI, llllllllllllIlllllIlIlllllIIlIll, true);
    }
    
    public static void sendToServer(final PacketWrapper llllllllllllIlllllIlIllllllIIIll, final Class<? extends Protocol> llllllllllllIlllllIlIllllllIIIlI, final boolean llllllllllllIlllllIlIllllllIIIIl) {
        sendToServer(llllllllllllIlllllIlIllllllIIIll, llllllllllllIlllllIlIllllllIIIlI, llllllllllllIlllllIlIllllllIIIIl, false);
    }
    
    public static void sendToServer(final PacketWrapper llllllllllllIlllllIlIllllllIlIII, final Class<? extends Protocol> llllllllllllIlllllIlIllllllIlIIl) {
        sendToServer(llllllllllllIlllllIlIllllllIlIII, llllllllllllIlllllIlIllllllIlIIl, true);
    }
}
