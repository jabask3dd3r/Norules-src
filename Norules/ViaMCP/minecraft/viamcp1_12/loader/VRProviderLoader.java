package ViaMCP.minecraft.viamcp1_12.loader;

import com.viaversion.viaversion.api.platform.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.providers.*;
import com.viaversion.viaversion.bungee.providers.*;
import com.viaversion.viaversion.api.protocol.version.*;
import com.viaversion.viaversion.protocols.base.*;
import com.viaversion.viaversion.api.connection.*;
import ViaMCP.minecraft.viamcp1_12.*;

public class VRProviderLoader implements ViaPlatformLoader
{
    @Override
    public void unload() {
    }
    
    @Override
    public void load() {
        Via.getManager().getProviders().use((Class<BungeeMovementTransmitter>)MovementTransmitterProvider.class, new BungeeMovementTransmitter());
        Via.getManager().getProviders().use((Class<VRProviderLoader$1>)VersionProvider.class, new BaseVersionProvider() {
            @Override
            public int getClosestServerProtocol(final UserConnection lllllllllllllIIIIllIlIIllIIIlllI) throws Exception {
                if (lllllllllllllIIIIllIlIIllIIIlllI.isClientSide()) {
                    return ViaMCP.getInstance().getVersion();
                }
                return super.getClosestServerProtocol(lllllllllllllIIIIllIlIIllIIIlllI);
            }
        });
    }
}
