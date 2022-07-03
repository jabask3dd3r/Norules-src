package com.viaversion.viaversion.velocity.providers;

import com.viaversion.viaversion.protocols.base.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.api.connection.*;
import com.velocitypowered.api.network.*;
import java.util.function.*;
import com.viaversion.viaversion.velocity.platform.*;
import com.viaversion.viaversion.*;
import java.util.*;
import com.viaversion.viaversion.api.*;
import java.util.stream.*;
import com.velocitypowered.api.proxy.*;
import com.viaversion.viaversion.velocity.service.*;
import io.netty.channel.*;

public class VelocityVersionProvider extends BaseVersionProvider
{
    private static /* synthetic */ Method getAssociation;
    
    private int getFrontProtocol(final UserConnection lllllllllllllIIIlIIllIlIlIIlIlll) throws Exception {
        final int lllllllllllllIIIlIIllIlIlIIllIlI = lllllllllllllIIIlIIllIlIlIIlIlll.getProtocolInfo().getProtocolVersion();
        IntStream lllllllllllllIIIlIIllIlIlIIllIIl = ProtocolVersion.SUPPORTED_VERSIONS.stream().mapToInt(ProtocolVersion::getProtocol);
        if (VelocityViaInjector.getPlayerInfoForwardingMode != null && ((Enum)VelocityViaInjector.getPlayerInfoForwardingMode.invoke(VelocityPlugin.PROXY.getConfiguration(), new Object[0])).name().equals("MODERN")) {
            lllllllllllllIIIlIIllIlIlIIllIIl = lllllllllllllIIIlIIllIlIlIIllIIl.filter(lllllllllllllIIIlIIllIlIlIIlIIII -> lllllllllllllIIIlIIllIlIlIIlIIII >= com.viaversion.viaversion.api.protocol.version.ProtocolVersion.v1_13.getVersion());
        }
        final int[] lllllllllllllIIIlIIllIlIlIIllIII = lllllllllllllIIIlIIllIlIlIIllIIl.toArray();
        if (Arrays.binarySearch(lllllllllllllIIIlIIllIlIlIIllIII, lllllllllllllIIIlIIllIlIlIIllIlI) >= 0) {
            return lllllllllllllIIIlIIllIlIlIIllIlI;
        }
        if (lllllllllllllIIIlIIllIlIlIIllIlI < lllllllllllllIIIlIIllIlIlIIllIII[0]) {
            return lllllllllllllIIIlIIllIlIlIIllIII[0];
        }
        for (int lllllllllllllIIIlIIllIlIlIIlllIl = lllllllllllllIIIlIIllIlIlIIllIII.length - 1; lllllllllllllIIIlIIllIlIlIIlllIl >= 0; --lllllllllllllIIIlIIllIlIlIIlllIl) {
            final int lllllllllllllIIIlIIllIlIlIIllllI = lllllllllllllIIIlIIllIlIlIIllIII[lllllllllllllIIIlIIllIlIlIIlllIl];
            if (lllllllllllllIIIlIIllIlIlIIllIlI > lllllllllllllIIIlIIllIlIlIIllllI && com.viaversion.viaversion.api.protocol.version.ProtocolVersion.isRegistered(lllllllllllllIIIlIIllIlIlIIllllI)) {
                return lllllllllllllIIIlIIllIlIlIIllllI;
            }
        }
        Via.getPlatform().getLogger().severe(String.valueOf(new StringBuilder().append("Panic, no protocol id found for ").append(lllllllllllllIIIlIIllIlIlIIllIlI)));
        return lllllllllllllIIIlIIllIlIlIIllIlI;
    }
    
    @Override
    public int getClosestServerProtocol(final UserConnection lllllllllllllIIIlIIllIlIlIlIlllI) throws Exception {
        return lllllllllllllIIIlIIllIlIlIlIlllI.isClientSide() ? this.getBackProtocol(lllllllllllllIIIlIIllIlIlIlIlllI) : this.getFrontProtocol(lllllllllllllIIIlIIllIlIlIlIlllI);
    }
    
    private int getBackProtocol(final UserConnection lllllllllllllIIIlIIllIlIlIlIlIII) throws Exception {
        final ChannelHandler lllllllllllllIIIlIIllIlIlIlIIlll = lllllllllllllIIIlIIllIlIlIlIlIII.getChannel().pipeline().get("handler");
        return ProtocolDetectorService.getProtocolId(((ServerConnection)VelocityVersionProvider.getAssociation.invoke(lllllllllllllIIIlIIllIlIlIlIIlll, new Object[0])).getServerInfo().getName());
    }
    
    static {
        try {
            VelocityVersionProvider.getAssociation = Class.forName("com.velocitypowered.proxy.connection.MinecraftConnection").getMethod("getAssociation", (Class<?>[])new Class[0]);
        }
        catch (NoSuchMethodException | ClassNotFoundException ex2) {
            final ReflectiveOperationException ex;
            final ReflectiveOperationException lllllllllllllIIIlIIllIlIlIIIllIl = ex;
            lllllllllllllIIIlIIllIlIlIIIllIl.printStackTrace();
        }
    }
}
