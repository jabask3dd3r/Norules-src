package de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage;

import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.*;
import de.gerrygames.viarewind.utils.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.connection.*;

public class Levitation extends StoredObject implements Tickable
{
    private volatile /* synthetic */ boolean active;
    private /* synthetic */ int amplifier;
    
    public void setAmplifier(final int llllllllllllllIIIllIllIllllllIll) {
        this.amplifier = llllllllllllllIIIllIllIllllllIll;
    }
    
    @Override
    public void tick() {
        if (!this.active) {
            return;
        }
        final int llllllllllllllIIIllIlllIIIIIlIll = (this.amplifier + 1) * 360;
        final PacketWrapper llllllllllllllIIIllIlllIIIIIlIlI = PacketWrapper.create(18, null, this.getUser());
        llllllllllllllIIIllIlllIIIIIlIlI.write(Type.VAR_INT, this.getUser().get(EntityTracker.class).getPlayerId());
        llllllllllllllIIIllIlllIIIIIlIlI.write(Type.SHORT, (Short)0);
        llllllllllllllIIIllIlllIIIIIlIlI.write(Type.SHORT, (short)llllllllllllllIIIllIlllIIIIIlIll);
        llllllllllllllIIIllIlllIIIIIlIlI.write(Type.SHORT, (Short)0);
        PacketUtil.sendPacket(llllllllllllllIIIllIlllIIIIIlIlI, Protocol1_8TO1_9.class);
    }
    
    public void setActive(final boolean llllllllllllllIIIllIlllIIIIIIIll) {
        this.active = llllllllllllllIIIllIlllIIIIIIIll;
    }
    
    public Levitation(final UserConnection llllllllllllllIIIllIlllIIIIlIIII) {
        super(llllllllllllllIIIllIlllIIIIlIIII);
        this.active = false;
    }
}
