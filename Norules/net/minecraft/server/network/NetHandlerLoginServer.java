package net.minecraft.server.network;

import net.minecraft.network.login.*;
import javax.crypto.*;
import net.minecraft.entity.player.*;
import com.mojang.authlib.*;
import net.minecraft.server.*;
import java.util.concurrent.atomic.*;
import java.nio.charset.*;
import org.apache.commons.lang3.*;
import net.minecraft.network.*;
import org.apache.logging.log4j.*;
import net.minecraft.util.text.*;
import io.netty.channel.*;
import io.netty.util.concurrent.*;
import net.minecraft.network.login.client.*;
import java.util.*;
import java.net.*;
import javax.annotation.*;
import net.minecraft.util.*;
import java.math.*;
import com.mojang.authlib.exceptions.*;
import java.security.*;
import net.minecraft.network.login.server.*;

public class NetHandlerLoginServer implements ITickable, INetHandlerLoginServer
{
    private final /* synthetic */ byte[] verifyToken;
    private static final /* synthetic */ Random RANDOM;
    private /* synthetic */ LoginState currentLoginState;
    private /* synthetic */ SecretKey secretKey;
    private /* synthetic */ EntityPlayerMP player;
    private /* synthetic */ GameProfile loginGameProfile;
    public final /* synthetic */ NetworkManager networkManager;
    private final /* synthetic */ MinecraftServer server;
    private /* synthetic */ int connectionTimer;
    private static final /* synthetic */ Logger LOGGER;
    private static final /* synthetic */ AtomicInteger AUTHENTICATOR_THREAD_ID;
    
    public NetHandlerLoginServer(final MinecraftServer lllllllllllllllIlllIIIIIIIllIIll, final NetworkManager lllllllllllllllIlllIIIIIIIlIllll) {
        this.verifyToken = new byte[4];
        this.currentLoginState = LoginState.HELLO;
        this.server = lllllllllllllllIlllIIIIIIIllIIll;
        this.networkManager = lllllllllllllllIlllIIIIIIIlIllll;
        NetHandlerLoginServer.RANDOM.nextBytes(this.verifyToken);
    }
    
    static /* synthetic */ void access$5(final NetHandlerLoginServer lllllllllllllllIllIllllllllIlIll, final LoginState lllllllllllllllIllIllllllllIlIlI) {
        lllllllllllllllIllIllllllllIlIll.currentLoginState = lllllllllllllllIllIllllllllIlIlI;
    }
    
    protected GameProfile getOfflineProfile(final GameProfile lllllllllllllllIllIllllllllllIll) {
        final UUID lllllllllllllllIllIllllllllllIlI = UUID.nameUUIDFromBytes(String.valueOf(new StringBuilder("OfflinePlayer:").append(lllllllllllllllIllIllllllllllIll.getName())).getBytes(StandardCharsets.UTF_8));
        return new GameProfile(lllllllllllllllIllIllllllllllIlI, lllllllllllllllIllIllllllllllIll.getName());
    }
    
    @Override
    public void processLoginStart(final CPacketLoginStart lllllllllllllllIlllIIIIIIIIIlIII) {
        Validate.validState(this.currentLoginState == LoginState.HELLO, "Unexpected hello packet", new Object[0]);
        this.loginGameProfile = lllllllllllllllIlllIIIIIIIIIlIII.getProfile();
        if (this.server.isServerInOnlineMode() && !this.networkManager.isLocalChannel()) {
            this.currentLoginState = LoginState.KEY;
            this.networkManager.sendPacket(new SPacketEncryptionRequest("", this.server.getKeyPair().getPublic(), this.verifyToken));
        }
        else {
            this.currentLoginState = LoginState.READY_TO_ACCEPT;
        }
    }
    
    static {
        AUTHENTICATOR_THREAD_ID = new AtomicInteger(0);
        LOGGER = LogManager.getLogger();
        RANDOM = new Random();
    }
    
    static /* synthetic */ void access$3(final NetHandlerLoginServer lllllllllllllllIllIllllllllIllll, final GameProfile lllllllllllllllIllIllllllllIlllI) {
        lllllllllllllllIllIllllllllIllll.loginGameProfile = lllllllllllllllIllIllllllllIlllI;
    }
    
    public void tryAcceptPlayer() {
        if (!this.loginGameProfile.isComplete()) {
            this.loginGameProfile = this.getOfflineProfile(this.loginGameProfile);
        }
        final String lllllllllllllllIlllIIIIIIIIllIll = this.server.getPlayerList().allowUserToConnect(this.networkManager.getRemoteAddress(), this.loginGameProfile);
        if (lllllllllllllllIlllIIIIIIIIllIll != null) {
            this.func_194026_b(new TextComponentTranslation(lllllllllllllllIlllIIIIIIIIllIll, new Object[0]));
        }
        else {
            this.currentLoginState = LoginState.ACCEPTED;
            if (this.server.getNetworkCompressionThreshold() >= 0 && !this.networkManager.isLocalChannel()) {
                this.networkManager.sendPacket(new SPacketEnableCompression(this.server.getNetworkCompressionThreshold()), (GenericFutureListener<? extends Future<? super Void>>)new ChannelFutureListener() {
                    public void operationComplete(final ChannelFuture llllllllllllllIlIlIllIllIllIIIIl) throws Exception {
                        NetHandlerLoginServer.this.networkManager.setCompressionThreshold(NetHandlerLoginServer.this.server.getNetworkCompressionThreshold());
                    }
                }, (GenericFutureListener<? extends Future<? super Void>>[])new GenericFutureListener[0]);
            }
            this.networkManager.sendPacket(new SPacketLoginSuccess(this.loginGameProfile));
            final EntityPlayerMP lllllllllllllllIlllIIIIIIIIllIlI = this.server.getPlayerList().getPlayerByUUID(this.loginGameProfile.getId());
            if (lllllllllllllllIlllIIIIIIIIllIlI != null) {
                this.currentLoginState = LoginState.DELAY_ACCEPT;
                this.player = this.server.getPlayerList().createPlayerForUser(this.loginGameProfile);
            }
            else {
                this.server.getPlayerList().initializeConnectionToPlayer(this.networkManager, this.server.getPlayerList().createPlayerForUser(this.loginGameProfile));
            }
        }
    }
    
    public String getConnectionInfo() {
        return (this.loginGameProfile != null) ? String.valueOf(new StringBuilder().append(this.loginGameProfile).append(" (").append(this.networkManager.getRemoteAddress()).append(")")) : String.valueOf(this.networkManager.getRemoteAddress());
    }
    
    @Override
    public void onDisconnect(final ITextComponent lllllllllllllllIlllIIIIIIIIlIIIl) {
        NetHandlerLoginServer.LOGGER.info("{} lost connection: {}", (Object)this.getConnectionInfo(), (Object)lllllllllllllllIlllIIIIIIIIlIIIl.getUnformattedText());
    }
    
    @Override
    public void processEncryptionResponse(final CPacketEncryptionResponse lllllllllllllllIlllIIIIIIIIIIIII) {
        Validate.validState(this.currentLoginState == LoginState.KEY, "Unexpected key packet", new Object[0]);
        final PrivateKey lllllllllllllllIlllIIIIIIIIIIIlI = this.server.getKeyPair().getPrivate();
        if (!Arrays.equals(this.verifyToken, lllllllllllllllIlllIIIIIIIIIIIII.getVerifyToken(lllllllllllllllIlllIIIIIIIIIIIlI))) {
            throw new IllegalStateException("Invalid nonce!");
        }
        this.secretKey = lllllllllllllllIlllIIIIIIIIIIIII.getSecretKey(lllllllllllllllIlllIIIIIIIIIIIlI);
        this.currentLoginState = LoginState.AUTHENTICATING;
        this.networkManager.enableEncryption(this.secretKey);
        new Thread(String.valueOf(new StringBuilder("User Authenticator #").append(NetHandlerLoginServer.AUTHENTICATOR_THREAD_ID.incrementAndGet()))) {
            @Nullable
            private InetAddress func_191235_a() {
                final SocketAddress lllllllllllllllIllllIIlIllIIlIlI = NetHandlerLoginServer.this.networkManager.getRemoteAddress();
                return (NetHandlerLoginServer.this.server.func_190518_ac() && lllllllllllllllIllllIIlIllIIlIlI instanceof InetSocketAddress) ? ((InetSocketAddress)lllllllllllllllIllllIIlIllIIlIlI).getAddress() : null;
            }
            
            @Override
            public void run() {
                final GameProfile lllllllllllllllIllllIIlIllIlIIll = NetHandlerLoginServer.this.loginGameProfile;
                try {
                    final String lllllllllllllllIllllIIlIllIlIIlI = new BigInteger(CryptManager.getServerIdHash("", NetHandlerLoginServer.this.server.getKeyPair().getPublic(), NetHandlerLoginServer.this.secretKey)).toString(16);
                    NetHandlerLoginServer.access$3(NetHandlerLoginServer.this, NetHandlerLoginServer.this.server.getMinecraftSessionService().hasJoinedServer(new GameProfile((UUID)null, lllllllllllllllIllllIIlIllIlIIll.getName()), lllllllllllllllIllllIIlIllIlIIlI, this.func_191235_a()));
                    if (NetHandlerLoginServer.this.loginGameProfile != null) {
                        NetHandlerLoginServer.LOGGER.info("UUID of player {} is {}", (Object)NetHandlerLoginServer.this.loginGameProfile.getName(), (Object)NetHandlerLoginServer.this.loginGameProfile.getId());
                        NetHandlerLoginServer.access$5(NetHandlerLoginServer.this, LoginState.READY_TO_ACCEPT);
                    }
                    else if (NetHandlerLoginServer.this.server.isSinglePlayer()) {
                        NetHandlerLoginServer.LOGGER.warn("Failed to verify username but will let them in anyway!");
                        NetHandlerLoginServer.access$3(NetHandlerLoginServer.this, NetHandlerLoginServer.this.getOfflineProfile(lllllllllllllllIllllIIlIllIlIIll));
                        NetHandlerLoginServer.access$5(NetHandlerLoginServer.this, LoginState.READY_TO_ACCEPT);
                    }
                    else {
                        NetHandlerLoginServer.this.func_194026_b(new TextComponentTranslation("multiplayer.disconnect.unverified_username", new Object[0]));
                        NetHandlerLoginServer.LOGGER.error("Username '{}' tried to join with an invalid session", (Object)lllllllllllllllIllllIIlIllIlIIll.getName());
                    }
                }
                catch (AuthenticationUnavailableException lllllllllllllllIllllIIlIllIlIIIl) {
                    if (NetHandlerLoginServer.this.server.isSinglePlayer()) {
                        NetHandlerLoginServer.LOGGER.warn("Authentication servers are down but will let them in anyway!");
                        NetHandlerLoginServer.access$3(NetHandlerLoginServer.this, NetHandlerLoginServer.this.getOfflineProfile(lllllllllllllllIllllIIlIllIlIIll));
                        NetHandlerLoginServer.access$5(NetHandlerLoginServer.this, LoginState.READY_TO_ACCEPT);
                    }
                    else {
                        NetHandlerLoginServer.this.func_194026_b(new TextComponentTranslation("multiplayer.disconnect.authservers_down", new Object[0]));
                        NetHandlerLoginServer.LOGGER.error("Couldn't verify username because servers are unavailable");
                    }
                }
            }
        }.start();
    }
    
    public void func_194026_b(final ITextComponent lllllllllllllllIlllIIIIIIIlIIIIl) {
        try {
            NetHandlerLoginServer.LOGGER.info("Disconnecting {}: {}", (Object)this.getConnectionInfo(), (Object)lllllllllllllllIlllIIIIIIIlIIIIl.getUnformattedText());
            this.networkManager.sendPacket(new SPacketDisconnect(lllllllllllllllIlllIIIIIIIlIIIIl));
            this.networkManager.closeChannel(lllllllllllllllIlllIIIIIIIlIIIIl);
        }
        catch (Exception lllllllllllllllIlllIIIIIIIlIIIll) {
            NetHandlerLoginServer.LOGGER.error("Error whilst disconnecting player", (Throwable)lllllllllllllllIlllIIIIIIIlIIIll);
        }
    }
    
    @Override
    public void update() {
        if (this.currentLoginState == LoginState.READY_TO_ACCEPT) {
            this.tryAcceptPlayer();
        }
        else if (this.currentLoginState == LoginState.DELAY_ACCEPT) {
            final EntityPlayerMP lllllllllllllllIlllIIIIIIIlIlIll = this.server.getPlayerList().getPlayerByUUID(this.loginGameProfile.getId());
            if (lllllllllllllllIlllIIIIIIIlIlIll == null) {
                this.currentLoginState = LoginState.READY_TO_ACCEPT;
                this.server.getPlayerList().initializeConnectionToPlayer(this.networkManager, this.player);
                this.player = null;
            }
        }
        if (this.connectionTimer++ == 600) {
            this.func_194026_b(new TextComponentTranslation("multiplayer.disconnect.slow_login", new Object[0]));
        }
    }
    
    enum LoginState
    {
        READY_TO_ACCEPT("READY_TO_ACCEPT", 3), 
        DELAY_ACCEPT("DELAY_ACCEPT", 4), 
        HELLO("HELLO", 0), 
        KEY("KEY", 1), 
        ACCEPTED("ACCEPTED", 5), 
        AUTHENTICATING("AUTHENTICATING", 2);
        
        private LoginState(final String lllllllllllllllIllIIIlIllIIIIlll, final int lllllllllllllllIllIIIlIllIIIIllI) {
        }
    }
}
