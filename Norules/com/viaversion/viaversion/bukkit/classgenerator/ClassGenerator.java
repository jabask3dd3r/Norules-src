package com.viaversion.viaversion.bukkit.classgenerator;

import com.viaversion.viaversion.*;
import org.bukkit.*;
import java.lang.reflect.*;
import org.bukkit.event.*;
import org.bukkit.plugin.*;
import com.viaversion.viaversion.libs.javassist.expr.*;
import com.viaversion.viaversion.bukkit.util.*;
import com.viaversion.viaversion.bukkit.handlers.*;
import com.viaversion.viaversion.classgenerator.generated.*;
import com.viaversion.viaversion.libs.javassist.*;

public final class ClassGenerator
{
    private static final /* synthetic */ boolean useModules;
    private static /* synthetic */ Class psConnectListener;
    private static /* synthetic */ String psPackage;
    private static /* synthetic */ HandlerConstructor constructor;
    
    public static Class getPSConnectListener() {
        return ClassGenerator.psConnectListener;
    }
    
    public static HandlerConstructor getConstructor() {
        return ClassGenerator.constructor;
    }
    
    public static void registerPSConnectListener(final ViaVersionPlugin llllllllllllIlllllIIlllllIIllIII) {
        if (ClassGenerator.psConnectListener != null) {
            try {
                final Class<? extends Event> llllllllllllIlllllIIlllllIIllIlI = (Class<? extends Event>)Class.forName("protocolsupport.api.events.ConnectionOpenEvent");
                Bukkit.getPluginManager().registerEvent((Class)llllllllllllIlllllIIlllllIIllIlI, (Listener)new Listener() {}, EventPriority.HIGH, (EventExecutor)new EventExecutor() {
                    public void execute(final Listener lllllllllllllIlIlIIIlIIIIllIIIlI, final Event lllllllllllllIlIlIIIlIIIIlIllllI) throws EventException {
                        try {
                            final Object lllllllllllllIlIlIIIlIIIIllIllII = lllllllllllllIlIlIIIlIIIIlIllllI.getClass().getMethod("getConnection", (Class<?>[])new Class[0]).invoke(lllllllllllllIlIlIIIlIIIIlIllllI, new Object[0]);
                            final Object lllllllllllllIlIlIIIlIIIIllIlIlI = ClassGenerator.psConnectListener.getConstructor(lllllllllllllIlIlIIIlIIIIllIllII.getClass()).newInstance(lllllllllllllIlIlIIIlIIIIllIllII);
                            final Method lllllllllllllIlIlIIIlIIIIllIlIII = lllllllllllllIlIlIIIlIIIIllIllII.getClass().getMethod("addPacketListener", Class.forName("protocolsupport.api.Connection$PacketListener"));
                            lllllllllllllIlIlIIIlIIIIllIlIII.invoke(lllllllllllllIlIlIIIlIIIIllIllII, lllllllllllllIlIlIIIlIIIIllIlIlI);
                        }
                        catch (Exception lllllllllllllIlIlIIIlIIIIllIIllI) {
                            lllllllllllllIlIlIIIlIIIIllIIllI.printStackTrace();
                        }
                    }
                }, (Plugin)llllllllllllIlllllIIlllllIIllIII);
            }
            catch (Exception llllllllllllIlllllIIlllllIIllIIl) {
                llllllllllllIlllllIIlllllIIllIIl.printStackTrace();
            }
        }
    }
    
    public static String getOldPSPackage() {
        if (ClassGenerator.psPackage == null) {
            try {
                Class.forName("protocolsupport.protocol.core.IPacketDecoder");
                ClassGenerator.psPackage = "protocolsupport.protocol.core";
            }
            catch (ClassNotFoundException llllllllllllIlllllIIlllllIIlIIlI) {
                try {
                    Class.forName("protocolsupport.protocol.pipeline.IPacketDecoder");
                    ClassGenerator.psPackage = "protocolsupport.protocol.pipeline";
                }
                catch (ClassNotFoundException llllllllllllIlllllIIlllllIIlIIll) {
                    ClassGenerator.psPackage = "unknown";
                }
            }
        }
        return ClassGenerator.psPackage;
    }
    
    private static void addSpigotCompatibility(final ClassPool llllllllllllIlllllIIllllllIIIllI, final Class llllllllllllIlllllIIllllllIIlIIl, final Class llllllllllllIlllllIIllllllIIIlII) {
        final String llllllllllllIlllllIIllllllIIIlll = String.valueOf(new StringBuilder().append("com.viaversion.viaversion.classgenerator.generated.").append(llllllllllllIlllllIIllllllIIlIIl.getSimpleName()));
        try {
            final CtClass llllllllllllIlllllIIllllllIIllIl = llllllllllllIlllllIIllllllIIIllI.getAndRename(llllllllllllIlllllIIllllllIIlIIl.getName(), llllllllllllIlllllIIllllllIIIlll);
            if (llllllllllllIlllllIIllllllIIIlII != null) {
                final CtClass llllllllllllIlllllIIllllllIIlllI = llllllllllllIlllllIIllllllIIIllI.get(llllllllllllIlllllIIllllllIIIlII.getName());
                llllllllllllIlllllIIllllllIIllIl.setSuperclass(llllllllllllIlllllIIllllllIIlllI);
                if (llllllllllllIlllllIIllllllIIIlII.getName().startsWith("net.minecraft") && llllllllllllIlllllIIllllllIIllIl.getConstructors().length != 0) {
                    llllllllllllIlllllIIllllllIIllIl.getConstructors()[0].instrument(new ExprEditor() {
                        @Override
                        public void edit(final ConstructorCall lllllllllllllIlIIIIllIIIIllIIIlI) throws CannotCompileException {
                            if (lllllllllllllIlIIIIllIIIIllIIIlI.isSuper()) {
                                lllllllllllllIlIIIIllIIIIllIIIlI.replace("super(null);");
                            }
                            super.edit(lllllllllllllIlIIIIllIIIIllIIIlI);
                        }
                    });
                }
            }
            toClass(llllllllllllIlllllIIllllllIIllIl);
        }
        catch (NotFoundException llllllllllllIlllllIIllllllIIllII) {
            llllllllllllIlllllIIllllllIIllII.printStackTrace();
        }
        catch (CannotCompileException llllllllllllIlllllIIllllllIIlIll) {
            llllllllllllIlllllIIllllllIIlIll.printStackTrace();
        }
    }
    
    public static void generate() {
        if (!ViaVersionPlugin.getInstance().isCompatSpigotBuild()) {
            if (!ViaVersionPlugin.getInstance().isProtocolSupport()) {
                return;
            }
        }
        try {
            final ClassPool llllllllllllIlllllIIllllllIlllIl = ClassPool.getDefault();
            llllllllllllIlllllIIllllllIlllIl.insertClassPath(new LoaderClassPath(Bukkit.class.getClassLoader()));
            final Plugin[] plugins = Bukkit.getPluginManager().getPlugins();
            final float llllllllllllIlllllIIllllllIlIlll = plugins.length;
            for (final Plugin llllllllllllIlllllIIlllllllIIIll : plugins) {
                llllllllllllIlllllIIllllllIlllIl.insertClassPath(new LoaderClassPath(llllllllllllIlllllIIlllllllIIIll.getClass().getClassLoader()));
            }
            Label_0241: {
                if (ViaVersionPlugin.getInstance().isCompatSpigotBuild()) {
                    final Class llllllllllllIlllllIIlllllllIIIlI = NMSUtil.nms("PacketDecoder", "net.minecraft.network.PacketDecoder");
                    final Class llllllllllllIlllllIIlllllllIIIIl = NMSUtil.nms("PacketEncoder", "net.minecraft.network.PacketEncoder");
                    addSpigotCompatibility(llllllllllllIlllllIIllllllIlllIl, BukkitDecodeHandler.class, llllllllllllIlllllIIlllllllIIIlI);
                    addSpigotCompatibility(llllllllllllIlllllIIllllllIlllIl, BukkitEncodeHandler.class, llllllllllllIlllllIIlllllllIIIIl);
                    break Label_0241;
                }
                if (isMultiplatformPS()) {
                    ClassGenerator.psConnectListener = makePSConnectListener(llllllllllllIlllllIIllllllIlllIl);
                    return;
                }
                try {
                    final String llllllllllllIlllllIIlllllllIIIII = getOldPSPackage();
                    final Class llllllllllllIlllllIIllllllIllllI = Class.forName(llllllllllllIlllllIIlllllllIIIII.equals("unknown") ? "protocolsupport.protocol.pipeline.common.PacketDecoder" : String.valueOf(new StringBuilder().append(llllllllllllIlllllIIlllllllIIIII).append(".wrapped.WrappedDecoder")));
                    final Class llllllllllllIlllllIIllllllIlllll = Class.forName(llllllllllllIlllllIIlllllllIIIII.equals("unknown") ? "protocolsupport.protocol.pipeline.common.PacketEncoder" : String.valueOf(new StringBuilder().append(llllllllllllIlllllIIlllllllIIIII).append(".wrapped.WrappedEncoder")));
                    addPSCompatibility(llllllllllllIlllllIIllllllIlllIl, BukkitDecodeHandler.class, llllllllllllIlllllIIllllllIllllI);
                    addPSCompatibility(llllllllllllIlllllIIllllllIlllIl, BukkitEncodeHandler.class, llllllllllllIlllllIIllllllIlllll);
                    final CtClass llllllllllllIlllllIIllllllIlllII = llllllllllllIlllllIIllllllIlllIl.makeClass("com.viaversion.viaversion.classgenerator.generated.GeneratedConstructor");
                    final CtClass llllllllllllIlllllIIllllllIllIll = llllllllllllIlllllIIllllllIlllIl.get(HandlerConstructor.class.getName());
                    llllllllllllIlllllIIllllllIlllII.setInterfaces(new CtClass[] { llllllllllllIlllllIIllllllIllIll });
                    llllllllllllIlllllIIllllllIlllIl.importPackage("com.viaversion.viaversion.classgenerator.generated");
                    llllllllllllIlllllIIllllllIlllIl.importPackage("com.viaversion.viaversion.classgenerator");
                    llllllllllllIlllllIIllllllIlllIl.importPackage("com.viaversion.viaversion.api.connection");
                    llllllllllllIlllllIIllllllIlllIl.importPackage("io.netty.handler.codec");
                    llllllllllllIlllllIIllllllIlllII.addMethod(CtMethod.make("public MessageToByteEncoder newEncodeHandler(UserConnection info, MessageToByteEncoder minecraftEncoder) {\n        return new BukkitEncodeHandler(info, minecraftEncoder);\n    }", llllllllllllIlllllIIllllllIlllII));
                    llllllllllllIlllllIIllllllIlllII.addMethod(CtMethod.make("public ByteToMessageDecoder newDecodeHandler(UserConnection info, ByteToMessageDecoder minecraftDecoder) {\n        return new BukkitDecodeHandler(info, minecraftDecoder);\n    }", llllllllllllIlllllIIllllllIlllII));
                    ClassGenerator.constructor = (HandlerConstructor)toClass(llllllllllllIlllllIIllllllIlllII).getConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
                }
                catch (CannotCompileException llllllllllllIlllllIIllllllIllIlI) {
                    llllllllllllIlllllIIllllllIllIlI.printStackTrace();
                }
            }
        }
        catch (ReflectiveOperationException ex) {}
        catch (CannotCompileException ex2) {}
        catch (NotFoundException ex3) {}
    }
    
    private static void addPSCompatibility(final ClassPool llllllllllllIlllllIIlllllIllIlIl, final Class llllllllllllIlllllIIlllllIlIllll, final Class llllllllllllIlllllIIlllllIllIIll) {
        final boolean llllllllllllIlllllIIlllllIllIIlI = getOldPSPackage().equals("unknown");
        final String llllllllllllIlllllIIlllllIllIIIl = String.valueOf(new StringBuilder().append("com.viaversion.viaversion.classgenerator.generated.").append(llllllllllllIlllllIIlllllIlIllll.getSimpleName()));
        try {
            final CtClass llllllllllllIlllllIIlllllIlllIII = llllllllllllIlllllIIlllllIllIlIl.getAndRename(llllllllllllIlllllIIlllllIlIllll.getName(), llllllllllllIlllllIIlllllIllIIIl);
            if (llllllllllllIlllllIIlllllIllIIll != null) {
                final CtClass llllllllllllIlllllIIlllllIlllIIl = llllllllllllIlllllIIlllllIllIlIl.get(llllllllllllIlllllIIlllllIllIIll.getName());
                llllllllllllIlllllIIlllllIlllIII.setSuperclass(llllllllllllIlllllIIlllllIlllIIl);
                if (!llllllllllllIlllllIIlllllIllIIlI) {
                    llllllllllllIlllllIIlllllIllIlIl.importPackage(getOldPSPackage());
                    llllllllllllIlllllIIlllllIllIlIl.importPackage(String.valueOf(new StringBuilder().append(getOldPSPackage()).append(".wrapped")));
                    if (llllllllllllIlllllIIlllllIllIIll.getName().endsWith("Decoder")) {
                        llllllllllllIlllllIIlllllIlllIII.addMethod(CtMethod.make("public void setRealDecoder(IPacketDecoder dec) {\n        ((WrappedDecoder) this.minecraftDecoder).setRealDecoder(dec);\n    }", llllllllllllIlllllIIlllllIlllIII));
                    }
                    else {
                        llllllllllllIlllllIIlllllIllIlIl.importPackage("protocolsupport.api");
                        llllllllllllIlllllIIlllllIllIlIl.importPackage("java.lang.reflect");
                        llllllllllllIlllllIIlllllIlllIII.addMethod(CtMethod.make("public void setRealEncoder(IPacketEncoder enc) {\n         try {\n             Field field = enc.getClass().getDeclaredField(\"version\");\n             field.setAccessible(true);\n             ProtocolVersion version = (ProtocolVersion) field.get(enc);\n             if (version == ProtocolVersion.MINECRAFT_FUTURE) enc = enc.getClass().getConstructor(\n                 new Class[]{ProtocolVersion.class}).newInstance(new Object[] {ProtocolVersion.getLatest()});\n         } catch (Exception e) {\n         }\n        ((WrappedEncoder) this.minecraftEncoder).setRealEncoder(enc);\n    }", llllllllllllIlllllIIlllllIlllIII));
                    }
                }
            }
            toClass(llllllllllllIlllllIIlllllIlllIII);
        }
        catch (NotFoundException llllllllllllIlllllIIlllllIllIlll) {
            llllllllllllIlllllIIlllllIllIlll.printStackTrace();
        }
        catch (CannotCompileException llllllllllllIlllllIIlllllIllIllI) {
            llllllllllllIlllllIIlllllIllIllI.printStackTrace();
        }
    }
    
    public static boolean isMultiplatformPS() {
        try {
            Class.forName("protocolsupport.zplatform.impl.spigot.network.pipeline.SpigotPacketEncoder");
            return true;
        }
        catch (ClassNotFoundException llllllllllllIlllllIIlllllIIIlllI) {
            return false;
        }
    }
    
    static {
        useModules = hasModuleMethod();
        ClassGenerator.constructor = new BasicHandlerConstructor();
    }
    
    public static HandshakeProtocolType handshakeVersionMethod() {
        Class<?> llllllllllllIlllllIIlllllIIIlIII = null;
        try {
            llllllllllllIlllllIIlllllIIIlIII = NMSUtil.nms("PacketHandshakingInSetProtocol", "net.minecraft.network.protocol.handshake.PacketHandshakingInSetProtocol");
            llllllllllllIlllllIIlllllIIIlIII.getMethod("getProtocolVersion", (Class<?>[])new Class[0]);
            return HandshakeProtocolType.MAPPED;
        }
        catch (ClassNotFoundException llllllllllllIlllllIIlllllIIIlIlI) {
            throw new RuntimeException(llllllllllllIlllllIIlllllIIIlIlI);
        }
        catch (NoSuchMethodException llllllllllllIlllllIIlllllIIIIllI) {
            try {
                if (llllllllllllIlllllIIlllllIIIlIII.getMethod("b", (Class<?>[])new Class[0]).getReturnType() == Integer.TYPE) {
                    return HandshakeProtocolType.OBFUSCATED_OLD;
                }
                if (llllllllllllIlllllIIlllllIIIlIII.getMethod("c", (Class<?>[])new Class[0]).getReturnType() == Integer.TYPE) {
                    return HandshakeProtocolType.OBFUSCATED_NEW;
                }
                throw new UnsupportedOperationException(String.valueOf(new StringBuilder().append("Protocol version method not found in ").append(llllllllllllIlllllIIlllllIIIlIII.getSimpleName())));
            }
            catch (ReflectiveOperationException llllllllllllIlllllIIlllllIIIlIIl) {
                throw new RuntimeException(llllllllllllIlllllIIlllllIIIlIIl);
            }
        }
    }
    
    private static Class makePSConnectListener(final ClassPool llllllllllllIlllllIIlllllIlIIIlI) {
        final HandshakeProtocolType llllllllllllIlllllIIlllllIlIIIIl = handshakeVersionMethod();
        try {
            final CtClass llllllllllllIlllllIIlllllIlIIlIl = llllllllllllIlllllIIlllllIlIIIlI.get("protocolsupport.api.Connection$PacketListener");
            final CtClass llllllllllllIlllllIIlllllIlIIlII = llllllllllllIlllllIIlllllIlIIIlI.makeClass("com.viaversion.viaversion.classgenerator.generated.ProtocolSupportConnectListener");
            llllllllllllIlllllIIlllllIlIIlII.setSuperclass(llllllllllllIlllllIIlllllIlIIlIl);
            llllllllllllIlllllIIlllllIlIIIlI.importPackage("java.util.Arrays");
            llllllllllllIlllllIIlllllIlIIIlI.importPackage("protocolsupport.api.ProtocolVersion");
            llllllllllllIlllllIIlllllIlIIIlI.importPackage("protocolsupport.api.ProtocolType");
            llllllllllllIlllllIIlllllIlIIIlI.importPackage("protocolsupport.api.Connection");
            llllllllllllIlllllIIlllllIlIIIlI.importPackage("protocolsupport.api.Connection.PacketListener");
            llllllllllllIlllllIIlllllIlIIIlI.importPackage("protocolsupport.api.Connection.PacketListener.PacketEvent");
            llllllllllllIlllllIIlllllIlIIIlI.importPackage("protocolsupport.protocol.ConnectionImpl");
            llllllllllllIlllllIIlllllIlIIIlI.importPackage(NMSUtil.nms("PacketHandshakingInSetProtocol", "net.minecraft.network.protocol.handshake.PacketHandshakingInSetProtocol").getName());
            llllllllllllIlllllIIlllllIlIIlII.addField(CtField.make("private ConnectionImpl connection;", llllllllllllIlllllIIlllllIlIIlII));
            llllllllllllIlllllIIlllllIlIIlII.addConstructor(CtNewConstructor.make("public ProtocolSupportConnectListener (ConnectionImpl connection) {\n    this.connection = connection;\n}", llllllllllllIlllllIIlllllIlIIlII));
            llllllllllllIlllllIIlllllIlIIlII.addMethod(CtNewMethod.make(String.valueOf(new StringBuilder().append("public void onPacketReceiving(protocolsupport.api.Connection.PacketListener.PacketEvent event) {\n    if (event.getPacket() instanceof PacketHandshakingInSetProtocol) {\n        PacketHandshakingInSetProtocol packet = (PacketHandshakingInSetProtocol) event.getPacket();\n        int protoVersion = packet.").append(llllllllllllIlllllIIlllllIlIIIIl.methodName()).append("();\n        if (connection.getVersion() == ProtocolVersion.MINECRAFT_FUTURE && protoVersion == com.viaversion.viaversion.api.Via.getAPI().getServerVersion().lowestSupportedVersion()) {\n            connection.setVersion(ProtocolVersion.getLatest(ProtocolType.PC));\n        }\n    }\n    connection.removePacketListener(this);\n}")), llllllllllllIlllllIIlllllIlIIlII));
            return toClass(llllllllllllIlllllIIlllllIlIIlII);
        }
        catch (Exception llllllllllllIlllllIIlllllIlIIIll) {
            llllllllllllIlllllIIlllllIlIIIll.printStackTrace();
            return null;
        }
    }
    
    private static Class<?> toClass(final CtClass llllllllllllIlllllIIlllllIIIIlII) throws CannotCompileException {
        return ClassGenerator.useModules ? llllllllllllIlllllIIlllllIIIIlII.toClass(HandlerConstructor.class) : llllllllllllIlllllIIlllllIIIIlII.toClass(HandlerConstructor.class.getClassLoader());
    }
    
    private static boolean hasModuleMethod() {
        try {
            Class.class.getDeclaredMethod("getModule", (Class<?>[])new Class[0]);
            return true;
        }
        catch (NoSuchMethodException llllllllllllIlllllIIlllllIIIIIIl) {
            return false;
        }
    }
    
    private enum HandshakeProtocolType
    {
        OBFUSCATED_NEW("c"), 
        OBFUSCATED_OLD("b");
        
        private final /* synthetic */ String methodName;
        
        MAPPED("getProtocolVersion");
        
        private HandshakeProtocolType(final String lllllllllllllIllIllllIlIIIIllIll) {
            this.methodName = lllllllllllllIllIllllIlIIIIllIll;
        }
        
        public String methodName() {
            return this.methodName;
        }
    }
}
