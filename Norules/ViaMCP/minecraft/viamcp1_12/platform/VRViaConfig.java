package ViaMCP.minecraft.viamcp1_12.platform;

import com.viaversion.viaversion.configuration.*;
import java.net.*;
import java.util.*;
import java.io.*;

public class VRViaConfig extends AbstractViaConfig
{
    private static /* synthetic */ List<String> UNSUPPORTED;
    
    @Override
    public boolean isAntiXRay() {
        return false;
    }
    
    @Override
    public boolean is1_14HitboxFix() {
        return false;
    }
    
    @Override
    public List<String> getUnsupportedOptions() {
        return VRViaConfig.UNSUPPORTED;
    }
    
    @Override
    public URL getDefaultConfigURL() {
        return this.getClass().getClassLoader().getResource("assets/viaversion/config.yml");
    }
    
    @Override
    public boolean is1_12QuickMoveActionFix() {
        return false;
    }
    
    @Override
    public String getBlockConnectionMethod() {
        return "packet";
    }
    
    static {
        VRViaConfig.UNSUPPORTED = Arrays.asList("anti-xray-patch", "bungee-ping-interval", "bungee-ping-save", "bungee-servers", "quick-move-action-fix", "nms-player-ticking", "velocity-ping-interval", "velocity-ping-save", "velocity-servers", "blockconnection-method", "change-1_9-hitbox", "change-1_14-hitbox");
    }
    
    @Override
    protected void handleConfig(final Map<String, Object> lllllllllllllIlIlIIIlllllIlIlIIl) {
    }
    
    @Override
    public boolean is1_9HitboxFix() {
        return false;
    }
    
    public VRViaConfig(final File lllllllllllllIlIlIIIlllllIllIIII) {
        super(lllllllllllllIlIlIIIlllllIllIIII);
        this.reloadConfig();
    }
    
    @Override
    public boolean isNMSPlayerTicking() {
        return false;
    }
}
