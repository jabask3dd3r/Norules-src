package de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage;

import java.util.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.*;
import de.gerrygames.viarewind.utils.*;
import com.viaversion.viaversion.api.protocol.*;

public class Windows extends StoredObject
{
    private /* synthetic */ HashMap<Short, Item[]> brewingItems;
    private /* synthetic */ HashMap<Short, String> types;
    
    public String get(final short llllllllllllllIIIIlIIlllIlIIIIII) {
        return this.types.get(llllllllllllllIIIIlIIlllIlIIIIII);
    }
    
    public Item[] getBrewingItems(final short llllllllllllllIIIIlIIlllIIlIllIl) {
        return this.brewingItems.computeIfAbsent(llllllllllllllIIIIlIIlllIIlIllIl, llllllllllllllIIIIlIIlllIIIlIIlI -> new Item[] { new DataItem(), new DataItem(), new DataItem(), new DataItem() });
    }
    
    public void put(final short llllllllllllllIIIIlIIlllIIlllIll, final String llllllllllllllIIIIlIIlllIIllIlll) {
        this.types.put(llllllllllllllIIIIlIIlllIIlllIll, llllllllllllllIIIIlIIlllIIllIlll);
    }
    
    public void remove(final short llllllllllllllIIIIlIIlllIIllIIIl) {
        this.types.remove(llllllllllllllIIIIlIIlllIIllIIIl);
        this.brewingItems.remove(llllllllllllllIIIIlIIlllIIllIIIl);
    }
    
    public Windows(final UserConnection llllllllllllllIIIIlIIlllIlIIIllI) {
        super(llllllllllllllIIIIlIIlllIlIIIllI);
        this.types = new HashMap<Short, String>();
        this.brewingItems = new HashMap<Short, Item[]>();
    }
    
    public static void updateBrewingStand(final UserConnection llllllllllllllIIIIlIIlllIIlIIIII, final Item llllllllllllllIIIIlIIlllIIIlllll, final short llllllllllllllIIIIlIIlllIIIllllI) {
        if (llllllllllllllIIIIlIIlllIIIlllll != null && llllllllllllllIIIIlIIlllIIIlllll.identifier() != 377) {
            return;
        }
        final int llllllllllllllIIIIlIIlllIIIlllIl = (llllllllllllllIIIIlIIlllIIIlllll == null) ? 0 : llllllllllllllIIIIlIIlllIIIlllll.amount();
        final PacketWrapper llllllllllllllIIIIlIIlllIIIlllII = PacketWrapper.create(45, null, llllllllllllllIIIIlIIlllIIlIIIII);
        llllllllllllllIIIIlIIlllIIIlllII.write(Type.UNSIGNED_BYTE, llllllllllllllIIIIlIIlllIIIllllI);
        llllllllllllllIIIIlIIlllIIIlllII.write(Type.STRING, "minecraft:brewing_stand");
        llllllllllllllIIIIlIIlllIIIlllII.write(Type.STRING, String.valueOf(new StringBuilder().append("[{\"translate\":\"container.brewing\"},{\"text\":\": \",\"color\":\"dark_gray\"},{\"text\":\"§4").append(llllllllllllllIIIIlIIlllIIIlllIl).append(" \",\"color\":\"dark_red\"},{\"translate\":\"item.blazePowder.name\",\"color\":\"dark_red\"}]")));
        llllllllllllllIIIIlIIlllIIIlllII.write(Type.UNSIGNED_BYTE, (Short)420);
        PacketUtil.sendPacket(llllllllllllllIIIIlIIlllIIIlllII, Protocol1_8TO1_9.class);
        final Item[] llllllllllllllIIIIlIIlllIIIllIll = llllllllllllllIIIIlIIlllIIlIIIII.get(Windows.class).getBrewingItems(llllllllllllllIIIIlIIlllIIIllllI);
        for (int llllllllllllllIIIIlIIlllIIlIIIIl = 0; llllllllllllllIIIIlIIlllIIlIIIIl < llllllllllllllIIIIlIIlllIIIllIll.length; ++llllllllllllllIIIIlIIlllIIlIIIIl) {
            final PacketWrapper llllllllllllllIIIIlIIlllIIlIIIlI = PacketWrapper.create(47, null, llllllllllllllIIIIlIIlllIIlIIIII);
            llllllllllllllIIIIlIIlllIIlIIIlI.write(Type.BYTE, (byte)llllllllllllllIIIIlIIlllIIIllllI);
            llllllllllllllIIIIlIIlllIIlIIIlI.write(Type.SHORT, (short)llllllllllllllIIIIlIIlllIIlIIIIl);
            llllllllllllllIIIIlIIlllIIlIIIlI.write(Type.ITEM, llllllllllllllIIIIlIIlllIIIllIll[llllllllllllllIIIIlIIlllIIlIIIIl]);
            PacketUtil.sendPacket(llllllllllllllIIIIlIIlllIIlIIIlI, Protocol1_8TO1_9.class);
        }
    }
}
