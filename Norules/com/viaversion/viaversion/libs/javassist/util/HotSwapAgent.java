package com.viaversion.viaversion.libs.javassist.util;

import java.lang.instrument.*;
import java.lang.management.*;
import com.sun.tools.attach.*;
import java.io.*;
import java.util.jar.*;
import java.util.zip.*;
import com.viaversion.viaversion.libs.javassist.*;

public class HotSwapAgent
{
    private static /* synthetic */ Instrumentation instrumentation;
    
    public static void redefine(final Class<?>[] llllIlIIllIllll, final CtClass[] llllIlIIllIlllI) throws IOException, CannotCompileException, NotFoundException {
        startAgent();
        final ClassDefinition[] llllIlIIllIllIl = new ClassDefinition[llllIlIIllIllll.length];
        for (int llllIlIIlllIIll = 0; llllIlIIlllIIll < llllIlIIllIllll.length; ++llllIlIIlllIIll) {
            llllIlIIllIllIl[llllIlIIlllIIll] = new ClassDefinition(llllIlIIllIllll[llllIlIIlllIIll], llllIlIIllIlllI[llllIlIIlllIIll].toBytecode());
        }
        try {
            HotSwapAgent.instrumentation.redefineClasses(llllIlIIllIllIl);
        }
        catch (ClassNotFoundException llllIlIIlllIIlI) {
            throw new NotFoundException(llllIlIIlllIIlI.getMessage(), llllIlIIlllIIlI);
        }
        catch (UnmodifiableClassException llllIlIIlllIIII) {
            throw new CannotCompileException(llllIlIIlllIIII.getMessage(), llllIlIIlllIIII);
        }
    }
    
    public Instrumentation instrumentation() {
        return HotSwapAgent.instrumentation;
    }
    
    public static void premain(final String llllIlIlIlIIlII, final Instrumentation llllIlIlIlIIlIl) throws Throwable {
        agentmain(llllIlIlIlIIlII, llllIlIlIlIIlIl);
    }
    
    public static void agentmain(final String llllIlIlIIllIlI, final Instrumentation llllIlIlIIllIII) throws Throwable {
        if (!llllIlIlIIllIII.isRedefineClassesSupported()) {
            throw new RuntimeException("this JVM does not support redefinition of classes");
        }
        HotSwapAgent.instrumentation = llllIlIlIIllIII;
    }
    
    private static void startAgent() throws NotFoundException {
        if (HotSwapAgent.instrumentation != null) {
            return;
        }
        try {
            final File llllIlIIlIlllII = createJarFile();
            final String llllIlIIlIllIll = ManagementFactory.getRuntimeMXBean().getName();
            final String llllIlIIlIllIlI = llllIlIIlIllIll.substring(0, llllIlIIlIllIll.indexOf(64));
            final VirtualMachine llllIlIIlIllIIl = VirtualMachine.attach(llllIlIIlIllIlI);
            llllIlIIlIllIIl.loadAgent(llllIlIIlIlllII.getAbsolutePath(), (String)null);
            llllIlIIlIllIIl.detach();
        }
        catch (Exception llllIlIIlIllIII) {
            throw new NotFoundException("hotswap agent", llllIlIIlIllIII);
        }
        for (int llllIlIIlIlIllI = 0; llllIlIIlIlIllI < 10; ++llllIlIIlIlIllI) {
            if (HotSwapAgent.instrumentation != null) {
                return;
            }
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException llllIlIIlIlIlll) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        throw new NotFoundException("hotswap agent (timeout)");
    }
    
    private static File createJarFile(final File llllIlIIIIlllll) throws CannotCompileException, NotFoundException, IOException {
        final Manifest llllIlIIIlIIIlI = new Manifest();
        final Attributes llllIlIIIlIIIIl = llllIlIIIlIIIlI.getMainAttributes();
        llllIlIIIlIIIIl.put(Attributes.Name.MANIFEST_VERSION, "1.0");
        llllIlIIIlIIIIl.put(new Attributes.Name("Premain-Class"), HotSwapAgent.class.getName());
        llllIlIIIlIIIIl.put(new Attributes.Name("Agent-Class"), HotSwapAgent.class.getName());
        llllIlIIIlIIIIl.put(new Attributes.Name("Can-Retransform-Classes"), "true");
        llllIlIIIlIIIIl.put(new Attributes.Name("Can-Redefine-Classes"), "true");
        JarOutputStream llllIlIIIlIIIII = null;
        try {
            llllIlIIIlIIIII = new JarOutputStream(new FileOutputStream(llllIlIIIIlllll), llllIlIIIlIIIlI);
            final String llllIlIIIlIIlll = HotSwapAgent.class.getName();
            final JarEntry llllIlIIIlIIllI = new JarEntry(String.valueOf(new StringBuilder().append(llllIlIIIlIIlll.replace('.', '/')).append(".class")));
            llllIlIIIlIIIII.putNextEntry(llllIlIIIlIIllI);
            final ClassPool llllIlIIIlIIlIl = ClassPool.getDefault();
            final CtClass llllIlIIIlIIlII = llllIlIIIlIIlIl.get(llllIlIIIlIIlll);
            llllIlIIIlIIIII.write(llllIlIIIlIIlII.toBytecode());
            llllIlIIIlIIIII.closeEntry();
        }
        finally {
            if (llllIlIIIlIIIII != null) {
                llllIlIIIlIIIII.close();
            }
        }
        return llllIlIIIIlllll;
    }
    
    static {
        HotSwapAgent.instrumentation = null;
    }
    
    public static void redefine(final Class<?> llllIlIlIIIllll, final CtClass llllIlIlIIIlllI) throws NotFoundException, IOException, CannotCompileException {
        final Class<?>[] llllIlIlIIlIIIl = (Class<?>[])new Class[] { llllIlIlIIIllll };
        final CtClass[] llllIlIlIIlIIII = { llllIlIlIIIlllI };
        redefine(llllIlIlIIlIIIl, llllIlIlIIlIIII);
    }
    
    private static File createJarFile() throws NotFoundException, IOException, CannotCompileException {
        final File llllIlIIlIIllIl = File.createTempFile("agent", ".jar");
        llllIlIIlIIllIl.deleteOnExit();
        return createJarFile(llllIlIIlIIllIl);
    }
    
    public static File createAgentJarFile(final String llllIlIIlIlIIII) throws CannotCompileException, IOException, NotFoundException {
        return createJarFile(new File(llllIlIIlIlIIII));
    }
}
