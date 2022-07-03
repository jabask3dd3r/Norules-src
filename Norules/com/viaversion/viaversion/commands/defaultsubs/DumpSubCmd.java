package com.viaversion.viaversion.commands.defaultsubs;

import com.viaversion.viaversion.api.command.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.dump.*;
import java.net.*;
import java.util.logging.*;
import java.nio.charset.*;
import com.google.common.io.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.util.*;
import java.io.*;
import java.util.*;

public class DumpSubCmd extends ViaSubCommand
{
    @Override
    public boolean execute(final ViaCommandSender lllllllllllllllIIllIllllIllllIIl, final String[] lllllllllllllllIIllIlllllIIIIIlI) {
        final VersionInfo lllllllllllllllIIllIllllIlllllll = new VersionInfo(System.getProperty("java.version"), System.getProperty("os.name"), Via.getAPI().getServerVersion().lowestSupportedVersion(), Via.getManager().getProtocolManager().getSupportedVersions(), Via.getPlatform().getPlatformName(), Via.getPlatform().getPlatformVersion(), Via.getPlatform().getPluginVersion(), "git-ViaVersion-4.0.2-SNAPSHOT:9ee548b", Via.getManager().getSubPlatforms());
        final Map<String, Object> lllllllllllllllIIllIllllIlllllIl = Via.getPlatform().getConfigurationProvider().getValues();
        final DumpTemplate lllllllllllllllIIllIllllIllllIll = new DumpTemplate(lllllllllllllllIIllIllllIlllllll, lllllllllllllllIIllIllllIlllllIl, Via.getPlatform().getDump(), Via.getManager().getInjector().getDump());
        Via.getPlatform().runAsync(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection lllllllllllllIIlIIlIlllIllllIIll = null;
                try {
                    lllllllllllllIIlIIlIlllIllllIIll = (HttpURLConnection)new URL("https://dump.viaversion.com/documents").openConnection();
                }
                catch (IOException lllllllllllllIIlIIlIlllIlllllIll) {
                    lllllllllllllllIIllIllllIllllIIl.sendMessage("§4Failed to dump, please check the console for more information");
                    Via.getPlatform().getLogger().log(Level.WARNING, "Could not paste ViaVersion dump to ViaVersion Dump", lllllllllllllIIlIIlIlllIlllllIll);
                    return;
                }
                try {
                    lllllllllllllIIlIIlIlllIllllIIll.setRequestProperty("Content-Type", "application/json");
                    lllllllllllllIIlIIlIlllIllllIIll.addRequestProperty("User-Agent", String.valueOf(new StringBuilder().append("ViaVersion/").append(lllllllllllllllIIllIllllIlllllll.getPluginVersion())));
                    lllllllllllllIIlIIlIlllIllllIIll.setRequestMethod("POST");
                    lllllllllllllIIlIIlIlllIllllIIll.setDoOutput(true);
                    final OutputStream lllllllllllllIIlIIlIlllIlllllIlI = lllllllllllllIIlIIlIlllIllllIIll.getOutputStream();
                    lllllllllllllIIlIIlIlllIlllllIlI.write(new GsonBuilder().setPrettyPrinting().create().toJson(lllllllllllllllIIllIllllIllllIll).getBytes(StandardCharsets.UTF_8));
                    lllllllllllllIIlIIlIlllIlllllIlI.close();
                    if (lllllllllllllIIlIIlIlllIllllIIll.getResponseCode() == 429) {
                        lllllllllllllllIIllIllllIllllIIl.sendMessage("§4You can only paste once every minute to protect our systems.");
                        return;
                    }
                    final String lllllllllllllIIlIIlIlllIlllllIIl = CharStreams.toString((Readable)new InputStreamReader(lllllllllllllIIlIIlIlllIllllIIll.getInputStream()));
                    lllllllllllllIIlIIlIlllIllllIIll.getInputStream().close();
                    final JsonObject lllllllllllllIIlIIlIlllIlllllIII = GsonUtil.getGson().fromJson(lllllllllllllIIlIIlIlllIlllllIIl, JsonObject.class);
                    if (!lllllllllllllIIlIIlIlllIlllllIII.has("key")) {
                        throw new InvalidObjectException("Key is not given in Hastebin output");
                    }
                    lllllllllllllllIIllIllllIllllIIl.sendMessage(String.valueOf(new StringBuilder().append("§2We've made a dump with useful information, report your issue and provide this url: ").append(DumpSubCmd.this.getUrl(lllllllllllllIIlIIlIlllIlllllIII.get("key").getAsString()))));
                }
                catch (Exception lllllllllllllIIlIIlIlllIllllIlIl) {
                    lllllllllllllllIIllIllllIllllIIl.sendMessage("§4Failed to dump, please check the console for more information");
                    Via.getPlatform().getLogger().log(Level.WARNING, "Could not paste ViaVersion dump to Hastebin", lllllllllllllIIlIIlIlllIllllIlIl);
                    try {
                        if (lllllllllllllIIlIIlIlllIllllIIll.getResponseCode() < 200 || lllllllllllllIIlIIlIlllIllllIIll.getResponseCode() > 400) {
                            final String lllllllllllllIIlIIlIlllIllllIlll = CharStreams.toString((Readable)new InputStreamReader(lllllllllllllIIlIIlIlllIllllIIll.getErrorStream()));
                            lllllllllllllIIlIIlIlllIllllIIll.getErrorStream().close();
                            Via.getPlatform().getLogger().log(Level.WARNING, String.valueOf(new StringBuilder().append("Page returned: ").append(lllllllllllllIIlIIlIlllIllllIlll)));
                        }
                    }
                    catch (IOException lllllllllllllIIlIIlIlllIllllIllI) {
                        Via.getPlatform().getLogger().log(Level.WARNING, "Failed to capture further info", lllllllllllllIIlIIlIlllIllllIllI);
                    }
                }
            }
        });
        return true;
    }
    
    private String getUrl(final String lllllllllllllllIIllIllllIllIlllI) {
        return String.format("https://dump.viaversion.com/%s", lllllllllllllllIIllIllllIllIlllI);
    }
    
    @Override
    public String description() {
        return "Dump information about your server, this is helpful if you report bugs.";
    }
    
    @Override
    public String name() {
        return "dump";
    }
}
