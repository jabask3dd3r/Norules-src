package net.minecraft.client.main;

import com.mojang.authlib.properties.*;
import net.minecraft.util.*;
import java.net.*;
import java.io.*;
import net.minecraft.client.resources.*;
import javax.annotation.*;

public class GameConfiguration
{
    public final /* synthetic */ FolderInformation folderInfo;
    public final /* synthetic */ DisplayInformation displayInfo;
    public final /* synthetic */ UserInformation userInfo;
    public final /* synthetic */ ServerInformation serverInfo;
    public final /* synthetic */ GameInformation gameInfo;
    
    public GameConfiguration(final UserInformation lllllllllllllIIIllIIlllIlIIllIlI, final DisplayInformation lllllllllllllIIIllIIlllIlIIlIIll, final FolderInformation lllllllllllllIIIllIIlllIlIIllIII, final GameInformation lllllllllllllIIIllIIlllIlIIlIlll, final ServerInformation lllllllllllllIIIllIIlllIlIIlIllI) {
        this.userInfo = lllllllllllllIIIllIIlllIlIIllIlI;
        this.displayInfo = lllllllllllllIIIllIIlllIlIIlIIll;
        this.folderInfo = lllllllllllllIIIllIIlllIlIIllIII;
        this.gameInfo = lllllllllllllIIIllIIlllIlIIlIlll;
        this.serverInfo = lllllllllllllIIIllIIlllIlIIlIllI;
    }
    
    public static class GameInformation
    {
        public final /* synthetic */ boolean isDemo;
        public final /* synthetic */ String versionType;
        public final /* synthetic */ String version;
        
        public GameInformation(final boolean lllllllllllllIIIllllIllllllIIIII, final String lllllllllllllIIIllllIlllllIllIll, final String lllllllllllllIIIllllIlllllIllIlI) {
            this.isDemo = lllllllllllllIIIllllIllllllIIIII;
            this.version = lllllllllllllIIIllllIlllllIllIll;
            this.versionType = lllllllllllllIIIllllIlllllIllIlI;
        }
    }
    
    public static class DisplayInformation
    {
        public final /* synthetic */ boolean checkGlErrors;
        public final /* synthetic */ boolean fullscreen;
        public final /* synthetic */ int height;
        public final /* synthetic */ int width;
        
        public DisplayInformation(final int lllllllllllllIIlIlllllIlIllIlIIl, final int lllllllllllllIIlIlllllIlIllIllIl, final boolean lllllllllllllIIlIlllllIlIllIIlll, final boolean lllllllllllllIIlIlllllIlIllIIllI) {
            this.width = lllllllllllllIIlIlllllIlIllIlIIl;
            this.height = lllllllllllllIIlIlllllIlIllIllIl;
            this.fullscreen = lllllllllllllIIlIlllllIlIllIIlll;
            this.checkGlErrors = lllllllllllllIIlIlllllIlIllIIllI;
        }
    }
    
    public static class ServerInformation
    {
        public final /* synthetic */ int serverPort;
        public final /* synthetic */ String serverName;
        
        public ServerInformation(final String llllllllllllllIlIlIlIlIlIlIllIII, final int llllllllllllllIlIlIlIlIlIlIlIlll) {
            this.serverName = llllllllllllllIlIlIlIlIlIlIllIII;
            this.serverPort = llllllllllllllIlIlIlIlIlIlIlIlll;
        }
    }
    
    public static class UserInformation
    {
        public final /* synthetic */ PropertyMap userProperties;
        public final /* synthetic */ Session session;
        public final /* synthetic */ PropertyMap profileProperties;
        public final /* synthetic */ Proxy proxy;
        
        public UserInformation(final Session lllllllllllllIIIIlIIIlIlllIIllII, final PropertyMap lllllllllllllIIIIlIIIlIlllIIlIll, final PropertyMap lllllllllllllIIIIlIIIlIlllIIlIlI, final Proxy lllllllllllllIIIIlIIIlIlllIIIlII) {
            this.session = lllllllllllllIIIIlIIIlIlllIIllII;
            this.userProperties = lllllllllllllIIIIlIIIlIlllIIlIll;
            this.profileProperties = lllllllllllllIIIIlIIIlIlllIIlIlI;
            this.proxy = lllllllllllllIIIIlIIIlIlllIIIlII;
        }
    }
    
    public static class FolderInformation
    {
        public final /* synthetic */ File mcDataDir;
        public final /* synthetic */ File assetsDir;
        public final /* synthetic */ File resourcePacksDir;
        public final /* synthetic */ String assetIndex;
        
        public ResourceIndex getAssetsIndex() {
            return (this.assetIndex == null) ? new ResourceIndexFolder(this.assetsDir) : new ResourceIndex(this.assetsDir, this.assetIndex);
        }
        
        public FolderInformation(final File lllllllllllllIIlIllIllIIllIllllI, final File lllllllllllllIIlIllIllIIlllIIIlI, final File lllllllllllllIIlIllIllIIllIlllII, @Nullable final String lllllllllllllIIlIllIllIIllIllIll) {
            this.mcDataDir = lllllllllllllIIlIllIllIIllIllllI;
            this.resourcePacksDir = lllllllllllllIIlIllIllIIlllIIIlI;
            this.assetsDir = lllllllllllllIIlIllIllIIllIlllII;
            this.assetIndex = lllllllllllllIIlIllIllIIllIllIll;
        }
    }
}
