package com.viaversion.viaversion.protocols.protocol1_9to1_8.providers;

import com.viaversion.viaversion.api.platform.providers.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.*;
import java.util.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.storage.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.type.*;

public class CommandBlockProvider implements Provider
{
    private CommandBlockStorage getStorage(final UserConnection lllllllllllllIIlllllllllIlllIIIl) {
        return lllllllllllllIIlllllllllIlllIIIl.get(CommandBlockStorage.class);
    }
    
    public void unloadChunks(final UserConnection lllllllllllllIIlllllllllIlIlIllI) {
        if (this.isEnabled()) {
            this.getStorage(lllllllllllllIIlllllllllIlIlIllI).unloadChunks();
        }
    }
    
    public boolean isEnabled() {
        return true;
    }
    
    private void checkPermission(final UserConnection lllllllllllllIIlllllllllIlIlllII) throws Exception {
        if (!this.isEnabled()) {
            return;
        }
        final CommandBlockStorage lllllllllllllIIlllllllllIlIllllI = this.getStorage(lllllllllllllIIlllllllllIlIlllII);
        if (!lllllllllllllIIlllllllllIlIllllI.isPermissions()) {
            this.sendPermission(lllllllllllllIIlllllllllIlIlllII);
        }
    }
    
    public Optional<CompoundTag> get(final UserConnection lllllllllllllIIllllllllllIIIIlII, final Position lllllllllllllIIllllllllllIIIIIll) throws Exception {
        this.checkPermission(lllllllllllllIIllllllllllIIIIlII);
        if (this.isEnabled()) {
            return this.getStorage(lllllllllllllIIllllllllllIIIIlII).getCommandBlock(lllllllllllllIIllllllllllIIIIIll);
        }
        return Optional.empty();
    }
    
    public void sendPermission(final UserConnection lllllllllllllIIlllllllllIllIlIlI) throws Exception {
        if (!this.isEnabled()) {
            return;
        }
        final PacketWrapper lllllllllllllIIlllllllllIllIlIIl = PacketWrapper.create(ClientboundPackets1_9.ENTITY_STATUS, null, lllllllllllllIIlllllllllIllIlIlI);
        final EntityTracker1_9 lllllllllllllIIlllllllllIllIlIII = lllllllllllllIIlllllllllIllIlIlI.getEntityTracker(Protocol1_9To1_8.class);
        lllllllllllllIIlllllllllIllIlIIl.write(Type.INT, lllllllllllllIIlllllllllIllIlIII.getProvidedEntityId());
        lllllllllllllIIlllllllllIllIlIIl.write(Type.BYTE, (Byte)26);
        lllllllllllllIIlllllllllIllIlIIl.scheduleSend(Protocol1_9To1_8.class);
        lllllllllllllIIlllllllllIllIlIlI.get(CommandBlockStorage.class).setPermissions(true);
    }
    
    public void unloadChunk(final UserConnection lllllllllllllIIlllllllllIllllIlI, final int lllllllllllllIIlllllllllIlllIlIl, final int lllllllllllllIIlllllllllIllllIII) throws Exception {
        this.checkPermission(lllllllllllllIIlllllllllIllllIlI);
        if (this.isEnabled()) {
            this.getStorage(lllllllllllllIIlllllllllIllllIlI).unloadChunk(lllllllllllllIIlllllllllIlllIlIl, lllllllllllllIIlllllllllIllllIII);
        }
    }
    
    public void addOrUpdateBlock(final UserConnection lllllllllllllIIllllllllllIIIllll, final Position lllllllllllllIIllllllllllIIIlllI, final CompoundTag lllllllllllllIIllllllllllIIIlIIl) throws Exception {
        this.checkPermission(lllllllllllllIIllllllllllIIIllll);
        if (this.isEnabled()) {
            this.getStorage(lllllllllllllIIllllllllllIIIllll).addOrUpdateBlock(lllllllllllllIIllllllllllIIIlllI, lllllllllllllIIllllllllllIIIlIIl);
        }
    }
}
