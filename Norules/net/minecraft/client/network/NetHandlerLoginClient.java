package net.minecraft.client.network;

import net.minecraft.network.login.*;
import javax.annotation.*;
import com.mojang.authlib.*;
import net.minecraft.client.*;
import net.minecraft.realms.*;
import net.minecraft.client.gui.*;
import com.mojang.authlib.minecraft.*;
import org.apache.logging.log4j.*;
import net.minecraft.network.login.server.*;
import net.minecraft.util.*;
import java.math.*;
import net.minecraft.util.text.*;
import com.mojang.authlib.exceptions.*;
import net.minecraft.network.login.client.*;
import io.netty.util.concurrent.*;
import javax.crypto.*;
import net.minecraft.network.*;
import java.security.*;

public class NetHandlerLoginClient implements INetHandlerLoginClient
{
    private final /* synthetic */ NetworkManager networkManager;
    @Nullable
    private final /* synthetic */ GuiScreen previousGuiScreen;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ GameProfile gameProfile;
    private final /* synthetic */ Minecraft mc;
    
    @Override
    public void handleLoginSuccess(final SPacketLoginSuccess llllllllllllllIllIIIlIlllIlIlIlI) {
        this.gameProfile = llllllllllllllIllIIIlIlllIlIlIlI.getProfile();
        this.networkManager.setConnectionState(EnumConnectionState.PLAY);
        this.networkManager.setNetHandler(new NetHandlerPlayClient(this.mc, this.previousGuiScreen, this.networkManager, this.gameProfile));
    }
    
    @Override
    public void onDisconnect(final ITextComponent llllllllllllllIllIIIlIlllIlIIlII) {
        if (this.previousGuiScreen != null && this.previousGuiScreen instanceof GuiScreenRealmsProxy) {
            this.mc.displayGuiScreen(new DisconnectedRealmsScreen(((GuiScreenRealmsProxy)this.previousGuiScreen).getProxy(), "connect.failed", llllllllllllllIllIIIlIlllIlIIlII).getProxy());
        }
        else {
            this.mc.displayGuiScreen(new GuiDisconnected(this.previousGuiScreen, "connect.failed", llllllllllllllIllIIIlIlllIlIIlII));
        }
    }
    
    private MinecraftSessionService getSessionService() {
        return this.mc.getSessionService();
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public void handleDisconnect(final SPacketDisconnect llllllllllllllIllIIIlIlllIlIIIII) {
        this.networkManager.closeChannel(llllllllllllllIllIIIlIlllIlIIIII.getReason());
    }
    
    @Override
    public void handleEnableCompression(final SPacketEnableCompression llllllllllllllIllIIIlIlllIIllIlI) {
        if (!this.networkManager.isLocalChannel()) {
            this.networkManager.setCompressionThreshold(llllllllllllllIllIIIlIlllIIllIlI.getCompressionThreshold());
        }
    }
    
    @Override
    public void handleEncryptionRequest(final SPacketEncryptionRequest llllllllllllllIllIIIlIlllIlllIII) {
        final SecretKey llllllllllllllIllIIIlIllllIIIIIl = CryptManager.createNewSharedKey();
        final String llllllllllllllIllIIIlIllllIIIIII = llllllllllllllIllIIIlIlllIlllIII.getServerId();
        final PublicKey llllllllllllllIllIIIlIlllIllllll = llllllllllllllIllIIIlIlllIlllIII.getPublicKey();
        final String llllllllllllllIllIIIlIlllIlllllI = new BigInteger(CryptManager.getServerIdHash(llllllllllllllIllIIIlIllllIIIIII, llllllllllllllIllIIIlIlllIllllll, llllllllllllllIllIIIlIllllIIIIIl)).toString(16);
        if (this.mc.getCurrentServerData() != null && this.mc.getCurrentServerData().isOnLAN()) {
            try {
                this.getSessionService().joinServer(this.mc.getSession().getProfile(), this.mc.getSession().getToken(), llllllllllllllIllIIIlIlllIlllllI);
            }
            catch (AuthenticationException llllllllllllllIllIIIlIlllIllllIl) {
                NetHandlerLoginClient.LOGGER.warn("Couldn't connect to auth servers but will continue to join LAN");
            }
        }
        else {
            try {
                this.getSessionService().joinServer(this.mc.getSession().getProfile(), this.mc.getSession().getToken(), llllllllllllllIllIIIlIlllIlllllI);
            }
            catch (AuthenticationUnavailableException llllllllllllllIllIIIlIlllIllllII) {
                this.networkManager.closeChannel(new TextComponentTranslation("disconnect.loginFailedInfo", new Object[] { new TextComponentTranslation("disconnect.loginFailedInfo.serversUnavailable", new Object[0]) }));
                return;
            }
            catch (InvalidCredentialsException llllllllllllllIllIIIlIlllIlllIll) {
                this.networkManager.closeChannel(new TextComponentTranslation("disconnect.loginFailedInfo", new Object[] { new TextComponentTranslation("disconnect.loginFailedInfo.invalidSession", new Object[0]) }));
                return;
            }
            catch (AuthenticationException llllllllllllllIllIIIlIlllIlllIlI) {
                this.networkManager.closeChannel(new TextComponentTranslation("disconnect.loginFailedInfo", new Object[] { llllllllllllllIllIIIlIlllIlllIlI.getMessage() }));
                return;
            }
        }
        this.networkManager.sendPacket(new CPacketEncryptionResponse(llllllllllllllIllIIIlIllllIIIIIl, llllllllllllllIllIIIlIlllIllllll, llllllllllllllIllIIIlIlllIlllIII.getVerifyToken()), (GenericFutureListener<? extends Future<? super Void>>)new GenericFutureListener<Future<? super Void>>() {
            public void operationComplete(final Future<? super Void> llllllllllllllIllllIIIlIllllIIIl) throws Exception {
                NetHandlerLoginClient.this.networkManager.enableEncryption(llllllllllllllIllIIIlIllllIIIIIl);
            }
        }, (GenericFutureListener<? extends Future<? super Void>>[])new GenericFutureListener[0]);
    }
    
    public NetHandlerLoginClient(final NetworkManager llllllllllllllIllIIIlIllllIIllIl, final Minecraft llllllllllllllIllIIIlIllllIlIIII, @Nullable final GuiScreen llllllllllllllIllIIIlIllllIIlIll) {
        this.networkManager = llllllllllllllIllIIIlIllllIIllIl;
        this.mc = llllllllllllllIllIIIlIllllIlIIII;
        this.previousGuiScreen = llllllllllllllIllIIIlIllllIIlIll;
    }
}
