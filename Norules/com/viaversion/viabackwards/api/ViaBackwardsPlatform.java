package com.viaversion.viabackwards.api;

import java.io.*;
import java.util.logging.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.update.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viabackwards.protocol.protocol1_9_4to1_10.*;
import com.viaversion.viaversion.api.protocol.version.*;
import com.viaversion.viabackwards.protocol.protocol1_10to1_11.*;
import com.viaversion.viabackwards.protocol.protocol1_11to1_11_1.*;
import com.viaversion.viabackwards.protocol.protocol1_11_1to1_12.*;
import com.viaversion.viabackwards.protocol.protocol1_12to1_12_1.*;
import com.viaversion.viabackwards.protocol.protocol1_12_1to1_12_2.*;
import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.*;
import com.viaversion.viabackwards.protocol.protocol1_13to1_13_1.*;
import com.viaversion.viabackwards.protocol.protocol1_13_1to1_13_2.*;
import com.viaversion.viabackwards.protocol.protocol1_13_2to1_14.*;
import com.viaversion.viabackwards.protocol.protocol1_14to1_14_1.*;
import com.viaversion.viabackwards.protocol.protocol1_14_1to1_14_2.*;
import com.viaversion.viabackwards.protocol.protocol1_14_2to1_14_3.*;
import com.viaversion.viabackwards.protocol.protocol1_14_3to1_14_4.*;
import com.viaversion.viabackwards.protocol.protocol1_14_4to1_15.*;
import com.viaversion.viabackwards.protocol.protocol1_15to1_15_1.*;
import com.viaversion.viabackwards.protocol.protocol1_15_1to1_15_2.*;
import com.viaversion.viabackwards.protocol.protocol1_15_2to1_16.*;
import com.viaversion.viabackwards.protocol.protocol1_16to1_16_1.*;
import com.viaversion.viabackwards.protocol.protocol1_16_1to1_16_2.*;
import com.viaversion.viabackwards.protocol.protocol1_16_2to1_16_3.*;
import com.viaversion.viabackwards.protocol.protocol1_16_3to1_16_4.*;
import com.viaversion.viabackwards.protocol.protocol1_16_4to1_17.*;
import com.viaversion.viabackwards.protocol.protocol1_17to1_17_1.*;
import com.viaversion.viaversion.api.protocol.*;

public interface ViaBackwardsPlatform
{
    File getDataFolder();
    
    Logger getLogger();
    
    default boolean isOutdated() {
        final String lllllllllllllIIlllIIlIIIIlIlllll = Via.getPlatform().getPluginVersion();
        if (lllllllllllllIIlllIIlIIIIlIlllll != null && new Version(lllllllllllllIIlllIIlIIIIlIlllll).compareTo(new Version("4.0.1--")) < 0) {
            this.getLogger().severe("================================");
            this.getLogger().severe("YOUR VIAVERSION IS OUTDATED");
            this.getLogger().severe("PLEASE USE VIAVERSION 4.0.1 OR NEWER");
            this.getLogger().severe("LINK: https://ci.viaversion.com/");
            this.getLogger().severe("VIABACKWARDS WILL NOW DISABLE");
            this.getLogger().severe("================================");
            this.disable();
            return true;
        }
        return false;
    }
    
    default void init(final File lllllllllllllIIlllIIlIIIIllIlIIl) {
        final ViaBackwardsConfig lllllllllllllIIlllIIlIIIIllIlIII = new ViaBackwardsConfig(new File(lllllllllllllIIlllIIlIIIIllIlIIl, "config.yml"));
        lllllllllllllIIlllIIlIIIIllIlIII.reloadConfig();
        ViaBackwards.init(this, lllllllllllllIIlllIIlIIIIllIlIII);
        if (this.isOutdated()) {
            return;
        }
        Via.getManager().getSubPlatforms().add("git-ViaBackwards-4.0.2-SNAPSHOT:54dc050");
        this.getLogger().info("Loading translations...");
        TranslatableRewriter.loadTranslatables();
        final ProtocolManager lllllllllllllIIlllIIlIIIIllIIlll = Via.getManager().getProtocolManager();
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_9_4To1_10(), ProtocolVersion.v1_9_3, ProtocolVersion.v1_10);
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_10To1_11(), ProtocolVersion.v1_10, ProtocolVersion.v1_11);
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_11To1_11_1(), ProtocolVersion.v1_11, ProtocolVersion.v1_11_1);
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_11_1To1_12(), ProtocolVersion.v1_11_1, ProtocolVersion.v1_12);
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_12To1_12_1(), ProtocolVersion.v1_12, ProtocolVersion.v1_12_1);
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_12_1To1_12_2(), ProtocolVersion.v1_12_1, ProtocolVersion.v1_12_2);
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_12_2To1_13(), ProtocolVersion.v1_12_2, ProtocolVersion.v1_13);
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_13To1_13_1(), ProtocolVersion.v1_13, ProtocolVersion.v1_13_1);
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_13_1To1_13_2(), ProtocolVersion.v1_13_1, ProtocolVersion.v1_13_2);
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_13_2To1_14(), ProtocolVersion.v1_13_2, ProtocolVersion.v1_14);
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_14To1_14_1(), ProtocolVersion.v1_14, ProtocolVersion.v1_14_1);
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_14_1To1_14_2(), ProtocolVersion.v1_14_1, ProtocolVersion.v1_14_2);
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_14_2To1_14_3(), ProtocolVersion.v1_14_2, ProtocolVersion.v1_14_3);
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_14_3To1_14_4(), ProtocolVersion.v1_14_3, ProtocolVersion.v1_14_4);
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_14_4To1_15(), ProtocolVersion.v1_14_4, ProtocolVersion.v1_15);
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_15To1_15_1(), ProtocolVersion.v1_15, ProtocolVersion.v1_15_1);
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_15_1To1_15_2(), ProtocolVersion.v1_15_1, ProtocolVersion.v1_15_2);
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_15_2To1_16(), ProtocolVersion.v1_15_2, ProtocolVersion.v1_16);
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_16To1_16_1(), ProtocolVersion.v1_16, ProtocolVersion.v1_16_1);
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_16_1To1_16_2(), ProtocolVersion.v1_16_1, ProtocolVersion.v1_16_2);
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_16_2To1_16_3(), ProtocolVersion.v1_16_2, ProtocolVersion.v1_16_3);
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_16_3To1_16_4(), ProtocolVersion.v1_16_3, ProtocolVersion.v1_16_4);
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_16_4To1_17(), ProtocolVersion.v1_16_4, ProtocolVersion.v1_17);
        lllllllllllllIIlllIIlIIIIllIIlll.registerProtocol(new Protocol1_17To1_17_1(), ProtocolVersion.v1_17, ProtocolVersion.v1_17_1);
    }
    
    void disable();
}
