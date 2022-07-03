package net.minecraft.util;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;

public class CooldownTrackerServer extends CooldownTracker
{
    private final /* synthetic */ EntityPlayerMP player;
    
    public CooldownTrackerServer(final EntityPlayerMP lllllllllllllIllllIIIlIlllIlIIIl) {
        this.player = lllllllllllllIllllIIIlIlllIlIIIl;
    }
    
    @Override
    protected void notifyOnRemove(final Item lllllllllllllIllllIIIlIlllIIIIlI) {
        super.notifyOnRemove(lllllllllllllIllllIIIlIlllIIIIlI);
        this.player.connection.sendPacket(new SPacketCooldown(lllllllllllllIllllIIIlIlllIIIIlI, 0));
    }
    
    @Override
    protected void notifyOnSet(final Item lllllllllllllIllllIIIlIlllIIlIIl, final int lllllllllllllIllllIIIlIlllIIlIll) {
        super.notifyOnSet(lllllllllllllIllllIIIlIlllIIlIIl, lllllllllllllIllllIIIlIlllIIlIll);
        this.player.connection.sendPacket(new SPacketCooldown(lllllllllllllIllllIIIlIlllIIlIIl, lllllllllllllIllllIIIlIlllIIlIll));
    }
}
