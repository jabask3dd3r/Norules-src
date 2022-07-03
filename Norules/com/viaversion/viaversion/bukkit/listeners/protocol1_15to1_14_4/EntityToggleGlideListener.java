package com.viaversion.viaversion.bukkit.listeners.protocol1_15to1_14_4;

import com.viaversion.viaversion.bukkit.listeners.*;
import com.viaversion.viaversion.*;
import org.bukkit.plugin.*;
import com.viaversion.viaversion.api.protocol.*;
import org.bukkit.entity.*;
import org.bukkit.event.entity.*;
import com.viaversion.viaversion.protocols.protocol1_15to1_14_4.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import org.bukkit.potion.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import java.util.*;
import org.bukkit.event.*;

public class EntityToggleGlideListener extends ViaBukkitListener
{
    private /* synthetic */ boolean swimmingMethodExists;
    
    public EntityToggleGlideListener(final ViaVersionPlugin lllllllllllllIllIlIlIIIIllIIlIII) {
        super((Plugin)lllllllllllllIllIlIlIIIIllIIlIII, Protocol1_15To1_14_4.class);
        try {
            Player.class.getMethod("isSwimming", (Class<?>[])new Class[0]);
            this.swimmingMethodExists = true;
        }
        catch (NoSuchMethodException ex) {}
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void entityToggleGlide(final EntityToggleGlideEvent lllllllllllllIllIlIlIIIIlIlllIII) {
        if (!(lllllllllllllIllIlIlIIIIlIlllIII.getEntity() instanceof Player)) {
            return;
        }
        final Player lllllllllllllIllIlIlIIIIlIlllIlI = (Player)lllllllllllllIllIlIlIIIIlIlllIII.getEntity();
        if (!this.isOnPipe(lllllllllllllIllIlIlIIIIlIlllIlI)) {
            return;
        }
        if (lllllllllllllIllIlIlIIIIlIlllIII.isGliding() && lllllllllllllIllIlIlIIIIlIlllIII.isCancelled()) {
            final PacketWrapper lllllllllllllIllIlIlIIIIlIllllIl = PacketWrapper.create(ClientboundPackets1_15.ENTITY_METADATA, null, this.getUserConnection(lllllllllllllIllIlIlIIIIlIlllIlI));
            try {
                lllllllllllllIllIlIlIIIIlIllllIl.write(Type.VAR_INT, lllllllllllllIllIlIlIIIIlIlllIlI.getEntityId());
                byte lllllllllllllIllIlIlIIIIlIllllll = 0;
                if (lllllllllllllIllIlIlIIIIlIlllIlI.getFireTicks() > 0) {
                    lllllllllllllIllIlIlIIIIlIllllll |= 0x1;
                }
                if (lllllllllllllIllIlIlIIIIlIlllIlI.isSneaking()) {
                    lllllllllllllIllIlIlIIIIlIllllll |= 0x2;
                }
                if (lllllllllllllIllIlIlIIIIlIlllIlI.isSprinting()) {
                    lllllllllllllIllIlIlIIIIlIllllll |= 0x8;
                }
                if (this.swimmingMethodExists && lllllllllllllIllIlIlIIIIlIlllIlI.isSwimming()) {
                    lllllllllllllIllIlIlIIIIlIllllll |= 0x10;
                }
                if (lllllllllllllIllIlIlIIIIlIlllIlI.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
                    lllllllllllllIllIlIlIIIIlIllllll |= 0x20;
                }
                if (lllllllllllllIllIlIlIIIIlIlllIlI.isGlowing()) {
                    lllllllllllllIllIlIlIIIIlIllllll |= 0x40;
                }
                lllllllllllllIllIlIlIIIIlIllllIl.write(Types1_14.METADATA_LIST, Arrays.asList(new Metadata(0, MetaType1_14.Byte, lllllllllllllIllIlIlIIIIlIllllll)));
                lllllllllllllIllIlIlIIIIlIllllIl.scheduleSend(Protocol1_15To1_14_4.class);
            }
            catch (Exception lllllllllllllIllIlIlIIIIlIlllllI) {
                lllllllllllllIllIlIlIIIIlIlllllI.printStackTrace();
            }
        }
    }
}
