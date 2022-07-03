package net.minecraft.client.main;

import java.io.*;
import net.minecraft.client.*;
import java.net.*;
import com.mojang.authlib.properties.*;
import java.lang.reflect.*;
import net.minecraft.util.*;
import joptsimple.*;
import java.util.*;
import com.google.gson.*;

public class Main
{
    private static boolean isNullOrEmpty(final String llllllllllllllIlllIIIIIIIIIIlIll) {
        return llllllllllllllIlllIIIIIIIIIIlIll != null && !llllllllllllllIlllIIIIIIIIIIlIll.isEmpty();
    }
    
    public static void main(final String[] llllllllllllllIlllIIIIIIIllIllII) {
        final OptionParser llllllllllllllIlllIIIIIIIllIlIll = new OptionParser();
        llllllllllllllIlllIIIIIIIllIlIll.allowsUnrecognizedOptions();
        llllllllllllllIlllIIIIIIIllIlIll.accepts("demo");
        llllllllllllllIlllIIIIIIIllIlIll.accepts("fullscreen");
        llllllllllllllIlllIIIIIIIllIlIll.accepts("checkGlErrors");
        final OptionSpec<String> llllllllllllllIlllIIIIIIIllIlIlI = (OptionSpec<String>)llllllllllllllIlllIIIIIIIllIlIll.accepts("server").withRequiredArg();
        final OptionSpec<Integer> llllllllllllllIlllIIIIIIIllIlIIl = (OptionSpec<Integer>)llllllllllllllIlllIIIIIIIllIlIll.accepts("port").withRequiredArg().ofType((Class)Integer.class).defaultsTo((Object)25565, (Object[])new Integer[0]);
        final OptionSpec<File> llllllllllllllIlllIIIIIIIllIlIII = (OptionSpec<File>)llllllllllllllIlllIIIIIIIllIlIll.accepts("gameDir").withRequiredArg().ofType((Class)File.class).defaultsTo((Object)new File("."), (Object[])new File[0]);
        final OptionSpec<File> llllllllllllllIlllIIIIIIIllIIlll = (OptionSpec<File>)llllllllllllllIlllIIIIIIIllIlIll.accepts("assetsDir").withRequiredArg().ofType((Class)File.class);
        final OptionSpec<File> llllllllllllllIlllIIIIIIIllIIllI = (OptionSpec<File>)llllllllllllllIlllIIIIIIIllIlIll.accepts("resourcePackDir").withRequiredArg().ofType((Class)File.class);
        final OptionSpec<String> llllllllllllllIlllIIIIIIIllIIlIl = (OptionSpec<String>)llllllllllllllIlllIIIIIIIllIlIll.accepts("proxyHost").withRequiredArg();
        final OptionSpec<Integer> llllllllllllllIlllIIIIIIIllIIlII = (OptionSpec<Integer>)llllllllllllllIlllIIIIIIIllIlIll.accepts("proxyPort").withRequiredArg().defaultsTo((Object)"8080", (Object[])new String[0]).ofType((Class)Integer.class);
        final OptionSpec<String> llllllllllllllIlllIIIIIIIllIIIll = (OptionSpec<String>)llllllllllllllIlllIIIIIIIllIlIll.accepts("proxyUser").withRequiredArg();
        final OptionSpec<String> llllllllllllllIlllIIIIIIIllIIIlI = (OptionSpec<String>)llllllllllllllIlllIIIIIIIllIlIll.accepts("proxyPass").withRequiredArg();
        final OptionSpec<String> llllllllllllllIlllIIIIIIIllIIIIl = (OptionSpec<String>)llllllllllllllIlllIIIIIIIllIlIll.accepts("username").withRequiredArg().defaultsTo((Object)String.valueOf(new StringBuilder("Sosat").append(Minecraft.getSystemTime() % 1000L)), (Object[])new String[0]);
        final OptionSpec<String> llllllllllllllIlllIIIIIIIllIIIII = (OptionSpec<String>)llllllllllllllIlllIIIIIIIllIlIll.accepts("uuid").withRequiredArg();
        final OptionSpec<String> llllllllllllllIlllIIIIIIIlIlllll = (OptionSpec<String>)llllllllllllllIlllIIIIIIIllIlIll.accepts("accessToken").withRequiredArg().required();
        final OptionSpec<String> llllllllllllllIlllIIIIIIIlIllllI = (OptionSpec<String>)llllllllllllllIlllIIIIIIIllIlIll.accepts("version").withRequiredArg().required();
        final OptionSpec<Integer> llllllllllllllIlllIIIIIIIlIlllIl = (OptionSpec<Integer>)llllllllllllllIlllIIIIIIIllIlIll.accepts("width").withRequiredArg().ofType((Class)Integer.class).defaultsTo((Object)854, (Object[])new Integer[0]);
        final OptionSpec<Integer> llllllllllllllIlllIIIIIIIlIlllII = (OptionSpec<Integer>)llllllllllllllIlllIIIIIIIllIlIll.accepts("height").withRequiredArg().ofType((Class)Integer.class).defaultsTo((Object)480, (Object[])new Integer[0]);
        final OptionSpec<String> llllllllllllllIlllIIIIIIIlIllIll = (OptionSpec<String>)llllllllllllllIlllIIIIIIIllIlIll.accepts("userProperties").withRequiredArg().defaultsTo((Object)"{}", (Object[])new String[0]);
        final OptionSpec<String> llllllllllllllIlllIIIIIIIlIllIlI = (OptionSpec<String>)llllllllllllllIlllIIIIIIIllIlIll.accepts("profileProperties").withRequiredArg().defaultsTo((Object)"{}", (Object[])new String[0]);
        final OptionSpec<String> llllllllllllllIlllIIIIIIIlIllIIl = (OptionSpec<String>)llllllllllllllIlllIIIIIIIllIlIll.accepts("assetIndex").withRequiredArg();
        final OptionSpec<String> llllllllllllllIlllIIIIIIIlIllIII = (OptionSpec<String>)llllllllllllllIlllIIIIIIIllIlIll.accepts("userType").withRequiredArg().defaultsTo((Object)"legacy", (Object[])new String[0]);
        final OptionSpec<String> llllllllllllllIlllIIIIIIIlIlIlll = (OptionSpec<String>)llllllllllllllIlllIIIIIIIllIlIll.accepts("versionType").withRequiredArg().defaultsTo((Object)"release", (Object[])new String[0]);
        final OptionSpec<String> llllllllllllllIlllIIIIIIIlIlIllI = (OptionSpec<String>)llllllllllllllIlllIIIIIIIllIlIll.nonOptions();
        final OptionSet llllllllllllllIlllIIIIIIIlIlIlIl = llllllllllllllIlllIIIIIIIllIlIll.parse(llllllllllllllIlllIIIIIIIllIllII);
        final List<String> llllllllllllllIlllIIIIIIIlIlIlII = (List<String>)llllllllllllllIlllIIIIIIIlIlIlIl.valuesOf((OptionSpec)llllllllllllllIlllIIIIIIIlIlIllI);
        if (!llllllllllllllIlllIIIIIIIlIlIlII.isEmpty()) {
            System.out.println(String.valueOf(new StringBuilder("Completely ignored arguments: ").append(llllllllllllllIlllIIIIIIIlIlIlII)));
        }
        final String llllllllllllllIlllIIIIIIIlIlIIll = (String)llllllllllllllIlllIIIIIIIlIlIlIl.valueOf((OptionSpec)llllllllllllllIlllIIIIIIIllIIlIl);
        Proxy llllllllllllllIlllIIIIIIIlIlIIlI = Proxy.NO_PROXY;
        if (llllllllllllllIlllIIIIIIIlIlIIll != null) {
            try {
                llllllllllllllIlllIIIIIIIlIlIIlI = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(llllllllllllllIlllIIIIIIIlIlIIll, (int)llllllllllllllIlllIIIIIIIlIlIlIl.valueOf((OptionSpec)llllllllllllllIlllIIIIIIIllIIlII)));
            }
            catch (Exception ex) {}
        }
        final String llllllllllllllIlllIIIIIIIlIlIIIl = (String)llllllllllllllIlllIIIIIIIlIlIlIl.valueOf((OptionSpec)llllllllllllllIlllIIIIIIIllIIIll);
        final String llllllllllllllIlllIIIIIIIlIlIIII = (String)llllllllllllllIlllIIIIIIIlIlIlIl.valueOf((OptionSpec)llllllllllllllIlllIIIIIIIllIIIlI);
        if (!llllllllllllllIlllIIIIIIIlIlIIlI.equals(Proxy.NO_PROXY) && isNullOrEmpty(llllllllllllllIlllIIIIIIIlIlIIIl) && isNullOrEmpty(llllllllllllllIlllIIIIIIIlIlIIII)) {
            Authenticator.setDefault(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(llllllllllllllIlllIIIIIIIlIlIIIl, llllllllllllllIlllIIIIIIIlIlIIII.toCharArray());
                }
            });
        }
        final int llllllllllllllIlllIIIIIIIlIIllll = (int)llllllllllllllIlllIIIIIIIlIlIlIl.valueOf((OptionSpec)llllllllllllllIlllIIIIIIIlIlllIl);
        final int llllllllllllllIlllIIIIIIIlIIlllI = (int)llllllllllllllIlllIIIIIIIlIlIlIl.valueOf((OptionSpec)llllllllllllllIlllIIIIIIIlIlllII);
        final boolean llllllllllllllIlllIIIIIIIlIIllIl = llllllllllllllIlllIIIIIIIlIlIlIl.has("fullscreen");
        final boolean llllllllllllllIlllIIIIIIIlIIllII = llllllllllllllIlllIIIIIIIlIlIlIl.has("checkGlErrors");
        final boolean llllllllllllllIlllIIIIIIIlIIlIll = llllllllllllllIlllIIIIIIIlIlIlIl.has("demo");
        final String llllllllllllllIlllIIIIIIIlIIlIlI = (String)llllllllllllllIlllIIIIIIIlIlIlIl.valueOf((OptionSpec)llllllllllllllIlllIIIIIIIlIllllI);
        final Gson llllllllllllllIlllIIIIIIIlIIlIIl = new GsonBuilder().registerTypeAdapter((Type)PropertyMap.class, (Object)new PropertyMap.Serializer()).create();
        final PropertyMap llllllllllllllIlllIIIIIIIlIIlIII = JsonUtils.gsonDeserialize(llllllllllllllIlllIIIIIIIlIIlIIl, (String)llllllllllllllIlllIIIIIIIlIlIlIl.valueOf((OptionSpec)llllllllllllllIlllIIIIIIIlIllIll), PropertyMap.class);
        final PropertyMap llllllllllllllIlllIIIIIIIlIIIlll = JsonUtils.gsonDeserialize(llllllllllllllIlllIIIIIIIlIIlIIl, (String)llllllllllllllIlllIIIIIIIlIlIlIl.valueOf((OptionSpec)llllllllllllllIlllIIIIIIIlIllIlI), PropertyMap.class);
        final String llllllllllllllIlllIIIIIIIlIIIllI = (String)llllllllllllllIlllIIIIIIIlIlIlIl.valueOf((OptionSpec)llllllllllllllIlllIIIIIIIlIlIlll);
        final File llllllllllllllIlllIIIIIIIlIIIlIl = (File)llllllllllllllIlllIIIIIIIlIlIlIl.valueOf((OptionSpec)llllllllllllllIlllIIIIIIIllIlIII);
        final File llllllllllllllIlllIIIIIIIlIIIlII = (File)(llllllllllllllIlllIIIIIIIlIlIlIl.has((OptionSpec)llllllllllllllIlllIIIIIIIllIIlll) ? llllllllllllllIlllIIIIIIIlIlIlIl.valueOf((OptionSpec)llllllllllllllIlllIIIIIIIllIIlll) : new File(llllllllllllllIlllIIIIIIIlIIIlIl, "assets/"));
        final File llllllllllllllIlllIIIIIIIlIIIIll = (File)(llllllllllllllIlllIIIIIIIlIlIlIl.has((OptionSpec)llllllllllllllIlllIIIIIIIllIIllI) ? llllllllllllllIlllIIIIIIIlIlIlIl.valueOf((OptionSpec)llllllllllllllIlllIIIIIIIllIIllI) : new File(llllllllllllllIlllIIIIIIIlIIIlIl, "resourcepacks/"));
        final String llllllllllllllIlllIIIIIIIlIIIIlI = (String)(llllllllllllllIlllIIIIIIIlIlIlIl.has((OptionSpec)llllllllllllllIlllIIIIIIIllIIIII) ? llllllllllllllIlllIIIIIIIllIIIII.value(llllllllllllllIlllIIIIIIIlIlIlIl) : ((String)llllllllllllllIlllIIIIIIIllIIIIl.value(llllllllllllllIlllIIIIIIIlIlIlIl)));
        final String llllllllllllllIlllIIIIIIIlIIIIIl = llllllllllllllIlllIIIIIIIlIlIlIl.has((OptionSpec)llllllllllllllIlllIIIIIIIlIllIIl) ? ((String)llllllllllllllIlllIIIIIIIlIllIIl.value(llllllllllllllIlllIIIIIIIlIlIlIl)) : null;
        final String llllllllllllllIlllIIIIIIIlIIIIII = (String)llllllllllllllIlllIIIIIIIlIlIlIl.valueOf((OptionSpec)llllllllllllllIlllIIIIIIIllIlIlI);
        final Integer llllllllllllllIlllIIIIIIIIllllll = (Integer)llllllllllllllIlllIIIIIIIlIlIlIl.valueOf((OptionSpec)llllllllllllllIlllIIIIIIIllIlIIl);
        final Session llllllllllllllIlllIIIIIIIIlllllI = new Session((String)llllllllllllllIlllIIIIIIIllIIIIl.value(llllllllllllllIlllIIIIIIIlIlIlIl), llllllllllllllIlllIIIIIIIlIIIIlI, (String)llllllllllllllIlllIIIIIIIlIlllll.value(llllllllllllllIlllIIIIIIIlIlIlIl), (String)llllllllllllllIlllIIIIIIIlIllIII.value(llllllllllllllIlllIIIIIIIlIlIlIl));
        final GameConfiguration llllllllllllllIlllIIIIIIIIllllIl = new GameConfiguration(new GameConfiguration.UserInformation(llllllllllllllIlllIIIIIIIIlllllI, llllllllllllllIlllIIIIIIIlIIlIII, llllllllllllllIlllIIIIIIIlIIIlll, llllllllllllllIlllIIIIIIIlIlIIlI), new GameConfiguration.DisplayInformation(llllllllllllllIlllIIIIIIIlIIllll, llllllllllllllIlllIIIIIIIlIIlllI, llllllllllllllIlllIIIIIIIlIIllIl, llllllllllllllIlllIIIIIIIlIIllII), new GameConfiguration.FolderInformation(llllllllllllllIlllIIIIIIIlIIIlIl, llllllllllllllIlllIIIIIIIlIIIIll, llllllllllllllIlllIIIIIIIlIIIlII, llllllllllllllIlllIIIIIIIlIIIIIl), new GameConfiguration.GameInformation(llllllllllllllIlllIIIIIIIlIIlIll, llllllllllllllIlllIIIIIIIlIIlIlI, llllllllllllllIlllIIIIIIIlIIIllI), new GameConfiguration.ServerInformation(llllllllllllllIlllIIIIIIIlIIIIII, llllllllllllllIlllIIIIIIIIllllll));
        Runtime.getRuntime().addShutdownHook(new Thread("Client Shutdown Thread") {
            @Override
            public void run() {
                Minecraft.stopIntegratedServer();
            }
        });
        Thread.currentThread().setName("Client thread");
        new Minecraft(llllllllllllllIlllIIIIIIIIllllIl).run();
    }
}
