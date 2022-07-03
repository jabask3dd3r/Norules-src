package com.viaversion.viabackwards.protocol.protocol1_12_2to1_13;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.protocols.protocol1_12_1to1_12.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.data.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.providers.*;
import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.data.*;
import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.packets.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.data.entity.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.storage.*;
import com.viaversion.viaversion.api.protocol.*;

public class Protocol1_12_2To1_13 extends BackwardsProtocol<ClientboundPackets1_13, ClientboundPackets1_12_1, ServerboundPackets1_13, ServerboundPackets1_12_1>
{
    private final /* synthetic */ EntityRewriter entityRewriter;
    public static final /* synthetic */ BackwardsMappings MAPPINGS;
    private final /* synthetic */ BlockItemPackets1_13 blockItemPackets;
    
    @Override
    protected void registerPackets() {
        this.executeAsyncAfterLoaded(Protocol1_13To1_12_2.class, () -> {
            Protocol1_12_2To1_13.MAPPINGS.load();
            PaintingMapping.init();
            Via.getManager().getProviders().register(BackwardsBlockEntityProvider.class, new BackwardsBlockEntityProvider());
            return;
        });
        final TranslatableRewriter lllllllllllllllIIlIllllIllllIIIl = new TranslatableRewriter(this) {
            @Override
            protected void handleTranslate(final JsonObject lllllllllllllIIIllllIlllIllIlllI, final String lllllllllllllIIIllllIlllIllIlIIl) {
                String lllllllllllllIIIllllIlllIllIllII = this.newTranslatables.get(lllllllllllllIIIllllIlllIllIlIIl);
                if (lllllllllllllIIIllllIlllIllIllII != null || (lllllllllllllIIIllllIlllIllIllII = Protocol1_12_2To1_13.this.getMappingData().getTranslateMappings().get(lllllllllllllIIIllllIlllIllIlIIl)) != null) {
                    lllllllllllllIIIllllIlllIllIlllI.addProperty("translate", lllllllllllllIIIllllIlllIllIllII);
                }
            }
        };
        lllllllllllllllIIlIllllIllllIIIl.registerPing();
        lllllllllllllllIIlIllllIllllIIIl.registerBossBar(ClientboundPackets1_13.BOSSBAR);
        lllllllllllllllIIlIllllIllllIIIl.registerChatMessage(ClientboundPackets1_13.CHAT_MESSAGE);
        lllllllllllllllIIlIllllIllllIIIl.registerLegacyOpenWindow(ClientboundPackets1_13.OPEN_WINDOW);
        lllllllllllllllIIlIllllIllllIIIl.registerDisconnect(ClientboundPackets1_13.DISCONNECT);
        lllllllllllllllIIlIllllIllllIIIl.registerCombatEvent(ClientboundPackets1_13.COMBAT_EVENT);
        lllllllllllllllIIlIllllIllllIIIl.registerTitle(ClientboundPackets1_13.TITLE);
        lllllllllllllllIIlIllllIllllIIIl.registerTabList(ClientboundPackets1_13.TAB_LIST);
        this.blockItemPackets.register();
        this.entityRewriter.register();
        new PlayerPacket1_13(this).register();
        new SoundPackets1_13(this).register();
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this).cancelClientbound(ClientboundPackets1_13.NBT_QUERY);
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this).cancelClientbound(ClientboundPackets1_13.CRAFT_RECIPE_RESPONSE);
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this).cancelClientbound(ClientboundPackets1_13.UNLOCK_RECIPES);
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this).cancelClientbound(ClientboundPackets1_13.ADVANCEMENTS);
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this).cancelClientbound(ClientboundPackets1_13.DECLARE_RECIPES);
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this).cancelClientbound(ClientboundPackets1_13.TAGS);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_12_1>)this).cancelServerbound(ServerboundPackets1_12_1.CRAFT_RECIPE_REQUEST);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_12_1>)this).cancelServerbound(ServerboundPackets1_12_1.RECIPE_BOOK_DATA);
    }
    
    @Override
    public BackwardsMappings getMappingData() {
        return Protocol1_12_2To1_13.MAPPINGS;
    }
    
    static {
        MAPPINGS = new BackwardsMappings();
    }
    
    public Protocol1_12_2To1_13() {
        super(ClientboundPackets1_13.class, ClientboundPackets1_12_1.class, ServerboundPackets1_13.class, ServerboundPackets1_12_1.class);
        this.entityRewriter = new EntityPackets1_13(this);
        this.blockItemPackets = new BlockItemPackets1_13(this);
    }
    
    @Override
    public EntityRewriter getEntityRewriter() {
        return this.entityRewriter;
    }
    
    @Override
    public BlockItemPackets1_13 getItemRewriter() {
        return this.blockItemPackets;
    }
    
    @Override
    public void init(final UserConnection lllllllllllllllIIlIllllIlllIlIIl) {
        if (!lllllllllllllllIIlIllllIlllIlIIl.has(ClientWorld.class)) {
            lllllllllllllllIIlIllllIlllIlIIl.put(new ClientWorld(lllllllllllllllIIlIllllIlllIlIIl));
        }
        lllllllllllllllIIlIllllIlllIlIIl.addEntityTracker(this.getClass(), new EntityTrackerBase(lllllllllllllllIIlIllllIlllIlIIl, Entity1_13Types.EntityType.PLAYER));
        lllllllllllllllIIlIllllIlllIlIIl.put(new BackwardsBlockStorage());
        lllllllllllllllIIlIllllIlllIlIIl.put(new TabCompleteStorage());
        if (ViaBackwards.getConfig().isFix1_13FacePlayer() && !lllllllllllllllIIlIllllIlllIlIIl.has(PlayerPositionStorage1_13.class)) {
            lllllllllllllllIIlIllllIlllIlIIl.put(new PlayerPositionStorage1_13());
        }
    }
}
