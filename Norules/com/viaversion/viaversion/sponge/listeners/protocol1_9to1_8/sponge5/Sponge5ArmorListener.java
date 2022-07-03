package com.viaversion.viaversion.sponge.listeners.protocol1_9to1_8.sponge5;

import com.viaversion.viaversion.sponge.listeners.*;
import org.spongepowered.api.event.entity.living.humanoid.player.*;
import org.spongepowered.api.event.*;
import com.viaversion.viaversion.*;
import com.viaversion.viaversion.api.protocol.*;
import org.spongepowered.api.entity.living.player.*;
import com.viaversion.viaversion.api.*;
import org.spongepowered.api.event.entity.*;
import org.spongepowered.api.world.*;
import org.spongepowered.api.event.action.*;
import org.spongepowered.api.event.filter.cause.*;
import org.spongepowered.api.data.type.*;
import java.util.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import org.spongepowered.api.event.network.*;
import org.spongepowered.api.event.item.inventory.*;
import org.spongepowered.api.item.inventory.transaction.*;
import org.spongepowered.api.item.inventory.*;

public class Sponge5ArmorListener extends ViaSpongeListener
{
    private static final /* synthetic */ UUID ARMOR_ATTRIBUTE;
    
    @Listener
    public void onRespawn(final RespawnPlayerEvent llllllllllllllllllIIllIllIIIllll) {
        this.sendDelayedArmorUpdate(llllllllllllllllllIIllIllIIIllll.getTargetEntity());
    }
    
    public Sponge5ArmorListener(final SpongePlugin llllllllllllllllllIIllIlllIIIlIl) {
        super(llllllllllllllllllIIllIlllIIIlIl, Protocol1_9To1_8.class);
    }
    
    public void sendDelayedArmorUpdate(final Player llllllllllllllllllIIllIllIIIIlIl) {
        if (!this.isOnPipe(llllllllllllllllllIIllIllIIIIlIl.getUniqueId())) {
            return;
        }
        Via.getPlatform().runSync(new Runnable() {
            @Override
            public void run() {
                Sponge5ArmorListener.this.sendArmorUpdate(llllllllllllllllllIIllIllIIIIlIl);
            }
        });
    }
    
    @Listener
    public void onWorldChange(final MoveEntityEvent.Teleport llllllllllllllllllIIllIllIIIlIIl) {
        if (!(llllllllllllllllllIIllIllIIIlIIl.getTargetEntity() instanceof Player)) {
            return;
        }
        if (!((World)llllllllllllllllllIIllIllIIIlIIl.getFromTransform().getExtent()).getUniqueId().equals(((World)llllllllllllllllllIIllIllIIIlIIl.getToTransform().getExtent()).getUniqueId())) {
            this.sendArmorUpdate((Player)llllllllllllllllllIIllIllIIIlIIl.getTargetEntity());
        }
    }
    
    static {
        ARMOR_ATTRIBUTE = UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150");
    }
    
    @Listener
    public void onInteract(final InteractEvent llllllllllllllllllIIllIllIIllllI, @Root final Player llllllllllllllllllIIllIllIIlllIl) {
        if (llllllllllllllllllIIllIllIIlllIl.getItemInHand(HandTypes.MAIN_HAND).isPresent() && ArmorType.isArmor(llllllllllllllllllIIllIllIIlllIl.getItemInHand(HandTypes.MAIN_HAND).get().getItem().getId())) {
            this.sendDelayedArmorUpdate(llllllllllllllllllIIllIllIIlllIl);
        }
    }
    
    public void sendArmorUpdate(final Player llllllllllllllllllIIllIllIllIlll) {
        if (!this.isOnPipe(llllllllllllllllllIIllIllIllIlll.getUniqueId())) {
            return;
        }
        int llllllllllllllllllIIllIllIlllIlI = 0;
        llllllllllllllllllIIllIllIlllIlI += this.calculate(llllllllllllllllllIIllIllIllIlll.getHelmet());
        llllllllllllllllllIIllIllIlllIlI += this.calculate(llllllllllllllllllIIllIllIllIlll.getChestplate());
        llllllllllllllllllIIllIllIlllIlI += this.calculate(llllllllllllllllllIIllIllIllIlll.getLeggings());
        llllllllllllllllllIIllIllIlllIlI += this.calculate(llllllllllllllllllIIllIllIllIlll.getBoots());
        final PacketWrapper llllllllllllllllllIIllIllIlllIIl = PacketWrapper.create(ClientboundPackets1_9.ENTITY_PROPERTIES, null, this.getUserConnection(llllllllllllllllllIIllIllIllIlll.getUniqueId()));
        try {
            llllllllllllllllllIIllIllIlllIIl.write(Type.VAR_INT, this.getEntityId(llllllllllllllllllIIllIllIllIlll));
            llllllllllllllllllIIllIllIlllIIl.write(Type.INT, 1);
            llllllllllllllllllIIllIllIlllIIl.write(Type.STRING, "generic.armor");
            llllllllllllllllllIIllIllIlllIIl.write(Type.DOUBLE, 0.0);
            llllllllllllllllllIIllIllIlllIIl.write(Type.VAR_INT, 1);
            llllllllllllllllllIIllIllIlllIIl.write(Type.UUID, Sponge5ArmorListener.ARMOR_ATTRIBUTE);
            llllllllllllllllllIIllIllIlllIIl.write(Type.DOUBLE, (double)llllllllllllllllllIIllIllIlllIlI);
            llllllllllllllllllIIllIllIlllIIl.write(Type.BYTE, (Byte)0);
            llllllllllllllllllIIllIllIlllIIl.scheduleSend(Protocol1_9To1_8.class);
        }
        catch (Exception llllllllllllllllllIIllIllIllllIl) {
            llllllllllllllllllIIllIllIllllIl.printStackTrace();
        }
    }
    
    @Listener
    public void onJoin(final ClientConnectionEvent.Join llllllllllllllllllIIllIllIIlIlIl) {
        this.sendArmorUpdate(llllllllllllllllllIIllIllIIlIlIl.getTargetEntity());
    }
    
    private int calculate(final Optional<ItemStack> llllllllllllllllllIIllIllIllIIII) {
        if (llllllllllllllllllIIllIllIllIIII.isPresent()) {
            return ArmorType.findByType(llllllllllllllllllIIllIllIllIIII.get().getItem().getType().getId()).getArmorPoints();
        }
        return 0;
    }
    
    @Listener
    public void onInventoryClick(final ClickInventoryEvent llllllllllllllllllIIllIllIlIlIII, @Root final Player llllllllllllllllllIIllIllIlIIlII) {
        for (final SlotTransaction llllllllllllllllllIIllIllIlIlIlI : llllllllllllllllllIIllIllIlIlIII.getTransactions()) {
            if (ArmorType.isArmor(((ItemStackSnapshot)llllllllllllllllllIIllIllIlIlIlI.getFinal()).getType().getId()) || ArmorType.isArmor(((ItemStackSnapshot)llllllllllllllllllIIllIllIlIlIII.getCursorTransaction().getFinal()).getType().getId())) {
                this.sendDelayedArmorUpdate(llllllllllllllllllIIllIllIlIIlII);
                break;
            }
        }
    }
}
