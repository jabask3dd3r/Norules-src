package com.viaversion.viaversion.sponge.listeners.protocol1_9to1_8.sponge4;

import com.viaversion.viaversion.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.api.protocol.*;
import org.spongepowered.api.entity.living.player.*;
import com.viaversion.viaversion.api.*;
import java.util.*;
import org.spongepowered.api.event.entity.*;
import org.spongepowered.api.world.*;
import org.spongepowered.api.event.*;
import org.spongepowered.api.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import org.spongepowered.api.event.action.*;
import org.spongepowered.api.event.filter.cause.*;
import org.spongepowered.api.event.item.inventory.*;
import org.spongepowered.api.item.inventory.transaction.*;
import org.spongepowered.api.item.inventory.*;
import org.spongepowered.api.event.network.*;
import org.spongepowered.api.event.entity.living.humanoid.player.*;

public class Sponge4ArmorListener extends ViaListener
{
    private static final /* synthetic */ UUID ARMOR_ATTRIBUTE;
    private static /* synthetic */ Field entityIdField;
    
    public Sponge4ArmorListener() {
        super(Protocol1_9To1_8.class);
    }
    
    protected int getEntityId(final Player llIlIIIllIllII) {
        try {
            if (Sponge4ArmorListener.entityIdField == null) {
                (Sponge4ArmorListener.entityIdField = llIlIIIllIllII.getClass().getSuperclass().getSuperclass().getSuperclass().getDeclaredField("field_145783_c")).setAccessible(true);
            }
            return Sponge4ArmorListener.entityIdField.getInt(llIlIIIllIllII);
        }
        catch (Exception llIlIIIllIlllI) {
            Via.getPlatform().getLogger().severe("Could not get the entity id, please report this on our Github");
            llIlIIIllIlllI.printStackTrace();
            Via.getPlatform().getLogger().severe("Could not get the entity id, please report this on our Github");
            return -1;
        }
    }
    
    private int calculate(final Optional<ItemStack> llIlIIlIlIIIlI) {
        if (llIlIIlIlIIIlI.isPresent()) {
            return ArmorType.findByType(llIlIIlIlIIIlI.get().getItem().getType().getId()).getArmorPoints();
        }
        return 0;
    }
    
    @Listener
    public void onWorldChange(final DisplaceEntityEvent.Teleport llIlIIIllllIlI) {
        if (!(llIlIIIllllIlI.getTargetEntity() instanceof Player)) {
            return;
        }
        if (!((World)llIlIIIllllIlI.getFromTransform().getExtent()).getUniqueId().equals(((World)llIlIIIllllIlI.getToTransform().getExtent()).getUniqueId())) {
            this.sendArmorUpdate((Player)llIlIIIllllIlI.getTargetEntity());
        }
    }
    
    static {
        ARMOR_ATTRIBUTE = UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150");
    }
    
    @Override
    public void register() {
        if (this.isRegistered()) {
            return;
        }
        Sponge.getEventManager().registerListeners((Object)Via.getPlatform(), (Object)this);
        this.setRegistered(true);
    }
    
    public void sendArmorUpdate(final Player llIlIIlIlIllII) {
        if (!this.isOnPipe(llIlIIlIlIllII.getUniqueId())) {
            return;
        }
        int llIlIIlIlIlIll = 0;
        llIlIIlIlIlIll += this.calculate(llIlIIlIlIllII.getHelmet());
        llIlIIlIlIlIll += this.calculate(llIlIIlIlIllII.getChestplate());
        llIlIIlIlIlIll += this.calculate(llIlIIlIlIllII.getLeggings());
        llIlIIlIlIlIll += this.calculate(llIlIIlIlIllII.getBoots());
        final PacketWrapper llIlIIlIlIlIlI = PacketWrapper.create(ClientboundPackets1_9.ENTITY_PROPERTIES, null, this.getUserConnection(llIlIIlIlIllII.getUniqueId()));
        try {
            llIlIIlIlIlIlI.write(Type.VAR_INT, this.getEntityId(llIlIIlIlIllII));
            llIlIIlIlIlIlI.write(Type.INT, 1);
            llIlIIlIlIlIlI.write(Type.STRING, "generic.armor");
            llIlIIlIlIlIlI.write(Type.DOUBLE, 0.0);
            llIlIIlIlIlIlI.write(Type.VAR_INT, 1);
            llIlIIlIlIlIlI.write(Type.UUID, Sponge4ArmorListener.ARMOR_ATTRIBUTE);
            llIlIIlIlIlIlI.write(Type.DOUBLE, (double)llIlIIlIlIlIll);
            llIlIIlIlIlIlI.write(Type.BYTE, (Byte)0);
            llIlIIlIlIlIlI.scheduleSend(Protocol1_9To1_8.class);
        }
        catch (Exception llIlIIlIlIlllI) {
            llIlIIlIlIlllI.printStackTrace();
        }
    }
    
    @Listener
    public void onInteract(final InteractEvent llIlIIlIIIllll, @Root final Player llIlIIlIIIlllI) {
        if (llIlIIlIIIlllI.getItemInHand().isPresent() && ArmorType.isArmor(llIlIIlIIIlllI.getItemInHand().get().getItem().getId())) {
            this.sendDelayedArmorUpdate(llIlIIlIIIlllI);
        }
    }
    
    @Listener
    public void onInventoryClick(final ClickInventoryEvent llIlIIlIIlIllI, @Root final Player llIlIIlIIllIII) {
        for (final SlotTransaction llIlIIlIIllIll : llIlIIlIIlIllI.getTransactions()) {
            if (ArmorType.isArmor(((ItemStackSnapshot)llIlIIlIIllIll.getFinal()).getType().getId()) || ArmorType.isArmor(((ItemStackSnapshot)llIlIIlIIlIllI.getCursorTransaction().getFinal()).getType().getId())) {
                this.sendDelayedArmorUpdate(llIlIIlIIllIII);
                break;
            }
        }
    }
    
    public void sendDelayedArmorUpdate(final Player llIlIIIlllIllI) {
        if (!this.isOnPipe(llIlIIIlllIllI.getUniqueId())) {
            return;
        }
        Via.getPlatform().runSync(new Runnable() {
            @Override
            public void run() {
                Sponge4ArmorListener.this.sendArmorUpdate(llIlIIIlllIllI);
            }
        });
    }
    
    @Listener
    public void onJoin(final ClientConnectionEvent.Join llIlIIlIIIIllI) {
        this.sendArmorUpdate(llIlIIlIIIIllI.getTargetEntity());
    }
    
    @Listener
    public void onRespawn(final RespawnPlayerEvent llIlIIlIIIIIlI) {
        this.sendDelayedArmorUpdate(llIlIIlIIIIIlI.getTargetEntity());
    }
}
