package de.gerrygames.viarewind.protocol.protocol1_8to1_9;

import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.protocols.protocol1_8.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import java.util.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import de.gerrygames.viarewind.utils.*;
import com.viaversion.viaversion.api.connection.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.api.protocol.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.packets.*;

public class Protocol1_8TO1_9 extends AbstractProtocol<ClientboundPackets1_9, ClientboundPackets1_8, ServerboundPackets1_9, ServerboundPackets1_8>
{
    public static final /* synthetic */ Set<String> VALID_ATTRIBUTES;
    
    static {
        TIMER = new Timer("ViaRewind-1_8TO1_9", true);
        VALID_ATTRIBUTES = new HashSet<String>();
        TO_OLD_INT = new ValueTransformer<Double, Integer>() {
            @Override
            public Integer transform(final PacketWrapper lllllIIllIlIlI, final Double lllllIIllIlIII) {
                return (int)(lllllIIllIlIII * 32.0);
            }
        };
        DEGREES_TO_ANGLE = new ValueTransformer<Float, Byte>() {
            @Override
            public Byte transform(final PacketWrapper lllllllllllllIIIlIIIlIIlIIlIIIII, final Float lllllllllllllIIIlIIIlIIlIIIlllll) throws Exception {
                return (byte)(lllllllllllllIIIlIIIlIIlIIIlllll / 360.0f * 256.0f);
            }
        };
        Protocol1_8TO1_9.VALID_ATTRIBUTES.add("generic.maxHealth");
        Protocol1_8TO1_9.VALID_ATTRIBUTES.add("generic.followRange");
        Protocol1_8TO1_9.VALID_ATTRIBUTES.add("generic.knockbackResistance");
        Protocol1_8TO1_9.VALID_ATTRIBUTES.add("generic.movementSpeed");
        Protocol1_8TO1_9.VALID_ATTRIBUTES.add("generic.attackDamage");
        Protocol1_8TO1_9.VALID_ATTRIBUTES.add("horse.jumpStrength");
        Protocol1_8TO1_9.VALID_ATTRIBUTES.add("zombie.spawnReinforcements");
    }
    
    @Override
    public void init(final UserConnection lllllllllllllIlIllllIIIIIIIlIlll) {
        Ticker.init();
        lllllllllllllIlIllllIIIIIIIlIlll.put(new Windows(lllllllllllllIlIllllIIIIIIIlIlll));
        lllllllllllllIlIllllIIIIIIIlIlll.put(new EntityTracker(lllllllllllllIlIllllIIIIIIIlIlll));
        lllllllllllllIlIllllIIIIIIIlIlll.put(new Levitation(lllllllllllllIlIllllIIIIIIIlIlll));
        lllllllllllllIlIllllIIIIIIIlIlll.put(new PlayerPosition(lllllllllllllIlIllllIIIIIIIlIlll));
        lllllllllllllIlIllllIIIIIIIlIlll.put(new Cooldown(lllllllllllllIlIllllIIIIIIIlIlll));
        lllllllllllllIlIllllIIIIIIIlIlll.put(new BlockPlaceDestroyTracker(lllllllllllllIlIllllIIIIIIIlIlll));
        lllllllllllllIlIllllIIIIIIIlIlll.put(new BossBarStorage(lllllllllllllIlIllllIIIIIIIlIlll));
        lllllllllllllIlIllllIIIIIIIlIlll.put(new ClientWorld(lllllllllllllIlIllllIIIIIIIlIlll));
    }
    
    @Override
    protected void registerPackets() {
        EntityPackets.register(this);
        InventoryPackets.register(this);
        PlayerPackets.register(this);
        ScoreboardPackets.register(this);
        SpawnPackets.register(this);
        WorldPackets.register(this);
    }
    
    public Protocol1_8TO1_9() {
        super(ClientboundPackets1_9.class, ClientboundPackets1_8.class, ServerboundPackets1_9.class, ServerboundPackets1_8.class);
    }
}
