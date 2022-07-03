package net.minecraft.network;

import net.minecraft.util.*;

public class PacketThreadUtil
{
    public static <T extends INetHandler> void checkThreadAndEnqueue(final Packet<T> llllllllllllllIIIlIIIIIlIIlIlIII, final T llllllllllllllIIIlIIIIIlIIlIIlII, final IThreadListener llllllllllllllIIIlIIIIIlIIlIIllI) throws ThreadQuickExitException {
        if (!llllllllllllllIIIlIIIIIlIIlIIllI.isCallingFromMinecraftThread()) {
            llllllllllllllIIIlIIIIIlIIlIIllI.addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    llllllllllllllIIIlIIIIIlIIlIlIII.processPacket(llllllllllllllIIIlIIIIIlIIlIIlII);
                }
            });
            throw ThreadQuickExitException.INSTANCE;
        }
    }
}
