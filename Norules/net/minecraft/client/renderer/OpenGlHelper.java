package net.minecraft.client.renderer;

import optifine.*;
import net.minecraft.client.*;
import org.apache.logging.log4j.*;
import java.nio.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.util.*;
import java.io.*;
import java.net.*;
import org.lwjgl.*;
import java.util.*;
import net.minecraft.client.settings.*;
import oshi.*;
import org.lwjgl.opengl.*;
import oshi.hardware.*;

public class OpenGlHelper
{
    public static /* synthetic */ int GL_FB_INCOMPLETE_DRAW_BUFFER;
    public static /* synthetic */ int GL_FRAMEBUFFER;
    public static /* synthetic */ int GL_COMBINE;
    public static /* synthetic */ boolean extBlendFuncSeparate;
    private static /* synthetic */ boolean arbShaders;
    private static /* synthetic */ boolean arbVbo;
    public static /* synthetic */ boolean vboSupportedAti;
    public static /* synthetic */ int GL_DEPTH_ATTACHMENT;
    public static /* synthetic */ boolean framebufferSupported;
    public static /* synthetic */ int GL_FB_INCOMPLETE_READ_BUFFER;
    public static /* synthetic */ int GL_FRAMEBUFFER_COMPLETE;
    public static /* synthetic */ int GL_FB_INCOMPLETE_MISS_ATTACH;
    public static /* synthetic */ int GL_COMBINE_ALPHA;
    public static /* synthetic */ boolean shadersSupported;
    public static /* synthetic */ int GL_OPERAND1_ALPHA;
    private static /* synthetic */ FboMode framebufferType;
    public static /* synthetic */ float lastBrightnessY;
    public static /* synthetic */ boolean nvidia;
    public static /* synthetic */ int GL_OPERAND1_RGB;
    public static /* synthetic */ int GL_SOURCE1_ALPHA;
    private static /* synthetic */ boolean arbMultitexture;
    public static /* synthetic */ int GL_PRIMARY_COLOR;
    private static /* synthetic */ String cpu;
    public static /* synthetic */ float lastBrightnessX;
    public static /* synthetic */ int GL_COMPILE_STATUS;
    public static /* synthetic */ int GL_SOURCE2_ALPHA;
    public static /* synthetic */ int GL_TEXTURE2;
    public static /* synthetic */ boolean openGL21;
    public static /* synthetic */ int GL_OPERAND0_ALPHA;
    public static /* synthetic */ int GL_PREVIOUS;
    private static /* synthetic */ boolean openGL14;
    public static /* synthetic */ int GL_CONSTANT;
    public static /* synthetic */ int GL_LINK_STATUS;
    public static /* synthetic */ int GL_STATIC_DRAW;
    public static /* synthetic */ int GL_RENDERBUFFER;
    private static /* synthetic */ String logText;
    public static /* synthetic */ int GL_COMBINE_RGB;
    public static /* synthetic */ boolean vboSupported;
    public static /* synthetic */ int GL_INTERPOLATE;
    public static /* synthetic */ int GL_OPERAND2_RGB;
    private static /* synthetic */ boolean shadersAvailable;
    public static /* synthetic */ int GL_OPERAND2_ALPHA;
    public static /* synthetic */ int GL_FRAGMENT_SHADER;
    public static /* synthetic */ int defaultTexUnit;
    public static /* synthetic */ int GL_SOURCE2_RGB;
    public static /* synthetic */ int GL_FB_INCOMPLETE_ATTACHMENT;
    public static /* synthetic */ int GL_SOURCE0_RGB;
    private static final /* synthetic */ Logger LOGGER;
    private static /* synthetic */ boolean arbTextureEnvCombine;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode;
    public static /* synthetic */ int GL_COLOR_ATTACHMENT0;
    public static /* synthetic */ boolean ati;
    public static /* synthetic */ int GL_VERTEX_SHADER;
    public static /* synthetic */ int GL_OPERAND0_RGB;
    public static /* synthetic */ int lightmapTexUnit;
    public static /* synthetic */ int GL_SOURCE0_ALPHA;
    public static /* synthetic */ int GL_ARRAY_BUFFER;
    public static /* synthetic */ int GL_SOURCE1_RGB;
    
    public static void glUniform3(final int llllllllllllllIIlIIIllIIIIlIIlll, final IntBuffer llllllllllllllIIlIIIllIIIIlIIllI) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniform3ARB(llllllllllllllIIlIIIllIIIIlIIlll, llllllllllllllIIlIIIllIIIIlIIllI);
        }
        else {
            GL20.glUniform3(llllllllllllllIIlIIIllIIIIlIIlll, llllllllllllllIIlIIIllIIIIlIIllI);
        }
    }
    
    public static void glUniformMatrix4(final int llllllllllllllIIlIIIlIlllllllIll, final boolean llllllllllllllIIlIIIlIlllllllIlI, final FloatBuffer llllllllllllllIIlIIIlIllllllllII) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniformMatrix4ARB(llllllllllllllIIlIIIlIlllllllIll, llllllllllllllIIlIIIlIlllllllIlI, llllllllllllllIIlIIIlIllllllllII);
        }
        else {
            GL20.glUniformMatrix4(llllllllllllllIIlIIIlIlllllllIll, llllllllllllllIIlIIIlIlllllllIlI, llllllllllllllIIlIIIlIllllllllII);
        }
    }
    
    public static String glGetShaderInfoLog(final int llllllllllllllIIlIIIllIIIllIIIII, final int llllllllllllllIIlIIIllIIIlIlllll) {
        return OpenGlHelper.arbShaders ? ARBShaderObjects.glGetInfoLogARB(llllllllllllllIIlIIIllIIIllIIIII, llllllllllllllIIlIIIllIIIlIlllll) : GL20.glGetShaderInfoLog(llllllllllllllIIlIIIllIIIllIIIII, llllllllllllllIIlIIIllIIIlIlllll);
    }
    
    public static String getLogText() {
        return OpenGlHelper.logText;
    }
    
    public static void glUniform2(final int llllllllllllllIIlIIIllIIIIlIllll, final FloatBuffer llllllllllllllIIlIIIllIIIIlIllII) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniform2ARB(llllllllllllllIIlIIIllIIIIlIllll, llllllllllllllIIlIIIllIIIIlIllII);
        }
        else {
            GL20.glUniform2(llllllllllllllIIlIIIllIIIIlIllll, llllllllllllllIIlIIIllIIIIlIllII);
        }
    }
    
    public static int glGenRenderbuffers() {
        if (!OpenGlHelper.framebufferSupported) {
            return -1;
        }
        switch ($SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode()[OpenGlHelper.framebufferType.ordinal()]) {
            case 1: {
                return GL30.glGenRenderbuffers();
            }
            case 2: {
                return ARBFramebufferObject.glGenRenderbuffers();
            }
            case 3: {
                return EXTFramebufferObject.glGenRenderbuffersEXT();
            }
            default: {
                return -1;
            }
        }
    }
    
    public static boolean isFramebufferEnabled() {
        return !Config.isFastRender() && !Config.isAntialiasing() && (OpenGlHelper.framebufferSupported && Minecraft.getMinecraft().gameSettings.fboEnable);
    }
    
    public static void glDeleteProgram(final int llllllllllllllIIlIIIllIIIlIlIIll) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glDeleteObjectARB(llllllllllllllIIlIIIllIIIlIlIIll);
        }
        else {
            GL20.glDeleteProgram(llllllllllllllIIlIIIllIIIlIlIIll);
        }
    }
    
    public static void glUniform3(final int llllllllllllllIIlIIIllIIIIlIIIll, final FloatBuffer llllllllllllllIIlIIIllIIIIlIIIII) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniform3ARB(llllllllllllllIIlIIIllIIIIlIIIll, llllllllllllllIIlIIIllIIIIlIIIII);
        }
        else {
            GL20.glUniform3(llllllllllllllIIlIIIllIIIIlIIIll, llllllllllllllIIlIIIllIIIIlIIIII);
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
        OpenGlHelper.logText = "";
        OpenGlHelper.lastBrightnessX = 0.0f;
        OpenGlHelper.lastBrightnessY = 0.0f;
    }
    
    public static void glUniform1(final int llllllllllllllIIlIIIllIIIIlllIIl, final FloatBuffer llllllllllllllIIlIIIllIIIIlllIII) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniform1ARB(llllllllllllllIIlIIIllIIIIlllIIl, llllllllllllllIIlIIIllIIIIlllIII);
        }
        else {
            GL20.glUniform1(llllllllllllllIIlIIIllIIIIlllIIl, llllllllllllllIIlIIIllIIIIlllIII);
        }
    }
    
    public static void glDeleteBuffers(final int llllllllllllllIIlIIIlIlllllIIIIl) {
        if (OpenGlHelper.arbVbo) {
            ARBVertexBufferObject.glDeleteBuffersARB(llllllllllllllIIlIIIlIlllllIIIIl);
        }
        else {
            GL15.glDeleteBuffers(llllllllllllllIIlIIIlIlllllIIIIl);
        }
    }
    
    public static void glBindRenderbuffer(final int llllllllllllllIIlIIIlIllllIlIllI, final int llllllllllllllIIlIIIlIllllIlIlIl) {
        if (OpenGlHelper.framebufferSupported) {
            switch ($SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode()[OpenGlHelper.framebufferType.ordinal()]) {
                case 1: {
                    GL30.glBindRenderbuffer(llllllllllllllIIlIIIlIllllIlIllI, llllllllllllllIIlIIIlIllllIlIlIl);
                    break;
                }
                case 2: {
                    ARBFramebufferObject.glBindRenderbuffer(llllllllllllllIIlIIIlIllllIlIllI, llllllllllllllIIlIIIlIllllIlIlIl);
                    break;
                }
                case 3: {
                    EXTFramebufferObject.glBindRenderbufferEXT(llllllllllllllIIlIIIlIllllIlIllI, llllllllllllllIIlIIIlIllllIlIlIl);
                    break;
                }
            }
        }
    }
    
    public static int glGenBuffers() {
        return OpenGlHelper.arbVbo ? ARBVertexBufferObject.glGenBuffersARB() : GL15.glGenBuffers();
    }
    
    public static void glCompileShader(final int llllllllllllllIIlIIIllIIIllIllII) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glCompileShaderARB(llllllllllllllIIlIIIllIIIllIllII);
        }
        else {
            GL20.glCompileShader(llllllllllllllIIlIIIllIIIllIllII);
        }
    }
    
    public static int glGenFramebuffers() {
        if (!OpenGlHelper.framebufferSupported) {
            return -1;
        }
        switch ($SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode()[OpenGlHelper.framebufferType.ordinal()]) {
            case 1: {
                return GL30.glGenFramebuffers();
            }
            case 2: {
                return ARBFramebufferObject.glGenFramebuffers();
            }
            case 3: {
                return EXTFramebufferObject.glGenFramebuffersEXT();
            }
            default: {
                return -1;
            }
        }
    }
    
    public static void setClientActiveTexture(final int llllllllllllllIIlIIIlIlllIlIIIII) {
        if (OpenGlHelper.arbMultitexture) {
            ARBMultitexture.glClientActiveTextureARB(llllllllllllllIIlIIIlIlllIlIIIII);
        }
        else {
            GL13.glClientActiveTexture(llllllllllllllIIlIIIlIlllIlIIIII);
        }
    }
    
    public static void glDeleteShader(final int llllllllllllllIIlIIIllIIIllllIII) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glDeleteObjectARB(llllllllllllllIIlIIIllIIIllllIII);
        }
        else {
            GL20.glDeleteShader(llllllllllllllIIlIIIllIIIllllIII);
        }
    }
    
    public static void glBindBuffer(final int llllllllllllllIIlIIIlIlllllIlllI, final int llllllllllllllIIlIIIlIlllllIllIl) {
        if (OpenGlHelper.arbVbo) {
            ARBVertexBufferObject.glBindBufferARB(llllllllllllllIIlIIIlIlllllIlllI, llllllllllllllIIlIIIlIlllllIllIl);
        }
        else {
            GL15.glBindBuffer(llllllllllllllIIlIIIlIlllllIlllI, llllllllllllllIIlIIIlIlllllIllIl);
        }
    }
    
    public static void glUseProgram(final int llllllllllllllIIlIIIllIIIlIlIlll) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUseProgramObjectARB(llllllllllllllIIlIIIllIIIlIlIlll);
        }
        else {
            GL20.glUseProgram(llllllllllllllIIlIIIllIIIlIlIlll);
        }
    }
    
    public static void glLinkProgram(final int llllllllllllllIIlIIIllIIIlIlIIII) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glLinkProgramARB(llllllllllllllIIlIIIllIIIlIlIIII);
        }
        else {
            GL20.glLinkProgram(llllllllllllllIIlIIIllIIIlIlIIII);
        }
    }
    
    public static void glRenderbufferStorage(final int llllllllllllllIIlIIIlIllllIIIllI, final int llllllllllllllIIlIIIlIllllIIlIIl, final int llllllllllllllIIlIIIlIllllIIIlII, final int llllllllllllllIIlIIIlIllllIIIIll) {
        if (OpenGlHelper.framebufferSupported) {
            switch ($SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode()[OpenGlHelper.framebufferType.ordinal()]) {
                case 1: {
                    GL30.glRenderbufferStorage(llllllllllllllIIlIIIlIllllIIIllI, llllllllllllllIIlIIIlIllllIIlIIl, llllllllllllllIIlIIIlIllllIIIlII, llllllllllllllIIlIIIlIllllIIIIll);
                    break;
                }
                case 2: {
                    ARBFramebufferObject.glRenderbufferStorage(llllllllllllllIIlIIIlIllllIIIllI, llllllllllllllIIlIIIlIllllIIlIIl, llllllllllllllIIlIIIlIllllIIIlII, llllllllllllllIIlIIIlIllllIIIIll);
                    break;
                }
                case 3: {
                    EXTFramebufferObject.glRenderbufferStorageEXT(llllllllllllllIIlIIIlIllllIIIllI, llllllllllllllIIlIIIlIllllIIlIIl, llllllllllllllIIlIIIlIllllIIIlII, llllllllllllllIIlIIIlIllllIIIIll);
                    break;
                }
            }
        }
    }
    
    public static void glShaderSource(final int llllllllllllllIIlIIIllIIIlllIIIl, final ByteBuffer llllllllllllllIIlIIIllIIIlllIIII) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glShaderSourceARB(llllllllllllllIIlIIIllIIIlllIIIl, llllllllllllllIIlIIIllIIIlllIIII);
        }
        else {
            GL20.glShaderSource(llllllllllllllIIlIIIllIIIlllIIIl, llllllllllllllIIlIIIllIIIlllIIII);
        }
    }
    
    public static void setActiveTexture(final int llllllllllllllIIlIIIlIlllIlIIIlI) {
        if (OpenGlHelper.arbMultitexture) {
            ARBMultitexture.glActiveTextureARB(llllllllllllllIIlIIIlIlllIlIIIlI);
        }
        else {
            GL13.glActiveTexture(llllllllllllllIIlIIIlIlllIlIIIlI);
        }
    }
    
    public static void glUniformMatrix2(final int llllllllllllllIIlIIIllIIIIIIllIl, final boolean llllllllllllllIIlIIIllIIIIIIllll, final FloatBuffer llllllllllllllIIlIIIllIIIIIIlIll) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniformMatrix2ARB(llllllllllllllIIlIIIllIIIIIIllIl, llllllllllllllIIlIIIllIIIIIIllll, llllllllllllllIIlIIIllIIIIIIlIll);
        }
        else {
            GL20.glUniformMatrix2(llllllllllllllIIlIIIllIIIIIIllIl, llllllllllllllIIlIIIllIIIIIIllll, llllllllllllllIIlIIIllIIIIIIlIll);
        }
    }
    
    public static int glCheckFramebufferStatus(final int llllllllllllllIIlIIIlIlllIllIlII) {
        if (!OpenGlHelper.framebufferSupported) {
            return -1;
        }
        switch ($SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode()[OpenGlHelper.framebufferType.ordinal()]) {
            case 1: {
                return GL30.glCheckFramebufferStatus(llllllllllllllIIlIIIlIlllIllIlII);
            }
            case 2: {
                return ARBFramebufferObject.glCheckFramebufferStatus(llllllllllllllIIlIIIlIlllIllIlII);
            }
            case 3: {
                return EXTFramebufferObject.glCheckFramebufferStatusEXT(llllllllllllllIIlIIIlIlllIllIlII);
            }
            default: {
                return -1;
            }
        }
    }
    
    public static void glUniform2(final int llllllllllllllIIlIIIllIIIIllIlIl, final IntBuffer llllllllllllllIIlIIIllIIIIllIlII) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniform2ARB(llllllllllllllIIlIIIllIIIIllIlIl, llllllllllllllIIlIIIllIIIIllIlII);
        }
        else {
            GL20.glUniform2(llllllllllllllIIlIIIllIIIIllIlIl, llllllllllllllIIlIIIllIIIIllIlII);
        }
    }
    
    public static void glDeleteFramebuffers(final int llllllllllllllIIlIIIlIllllIlIIII) {
        if (OpenGlHelper.framebufferSupported) {
            switch ($SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode()[OpenGlHelper.framebufferType.ordinal()]) {
                case 1: {
                    GL30.glDeleteFramebuffers(llllllllllllllIIlIIIlIllllIlIIII);
                    break;
                }
                case 2: {
                    ARBFramebufferObject.glDeleteFramebuffers(llllllllllllllIIlIIIlIllllIlIIII);
                    break;
                }
                case 3: {
                    EXTFramebufferObject.glDeleteFramebuffersEXT(llllllllllllllIIlIIIlIllllIlIIII);
                    break;
                }
            }
        }
    }
    
    public static void glDeleteRenderbuffers(final int llllllllllllllIIlIIIlIllllIlIIll) {
        if (OpenGlHelper.framebufferSupported) {
            switch ($SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode()[OpenGlHelper.framebufferType.ordinal()]) {
                case 1: {
                    GL30.glDeleteRenderbuffers(llllllllllllllIIlIIIlIllllIlIIll);
                    break;
                }
                case 2: {
                    ARBFramebufferObject.glDeleteRenderbuffers(llllllllllllllIIlIIIlIllllIlIIll);
                    break;
                }
                case 3: {
                    EXTFramebufferObject.glDeleteRenderbuffersEXT(llllllllllllllIIlIIIlIllllIlIIll);
                    break;
                }
            }
        }
    }
    
    public static String glGetProgramInfoLog(final int llllllllllllllIIlIIIllIIIlIlllII, final int llllllllllllllIIlIIIllIIIlIllIll) {
        return OpenGlHelper.arbShaders ? ARBShaderObjects.glGetInfoLogARB(llllllllllllllIIlIIIllIIIlIlllII, llllllllllllllIIlIIIllIIIlIllIll) : GL20.glGetProgramInfoLog(llllllllllllllIIlIIIllIIIlIlllII, llllllllllllllIIlIIIllIIIlIllIll);
    }
    
    public static void renderDirections(final int llllllllllllllIIlIIIlIlllIIIIIll) {
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask(false);
        final Tessellator llllllllllllllIIlIIIlIlllIIIIlIl = Tessellator.getInstance();
        final BufferBuilder llllllllllllllIIlIIIlIlllIIIIlII = llllllllllllllIIlIIIlIlllIIIIlIl.getBuffer();
        GL11.glLineWidth(4.0f);
        llllllllllllllIIlIIIlIlllIIIIlII.begin(1, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllIIlIIIlIlllIIIIlII.pos(0.0, 0.0, 0.0).color(0, 0, 0, 255).endVertex();
        llllllllllllllIIlIIIlIlllIIIIlII.pos(llllllllllllllIIlIIIlIlllIIIIIll, 0.0, 0.0).color(0, 0, 0, 255).endVertex();
        llllllllllllllIIlIIIlIlllIIIIlII.pos(0.0, 0.0, 0.0).color(0, 0, 0, 255).endVertex();
        llllllllllllllIIlIIIlIlllIIIIlII.pos(0.0, llllllllllllllIIlIIIlIlllIIIIIll, 0.0).color(0, 0, 0, 255).endVertex();
        llllllllllllllIIlIIIlIlllIIIIlII.pos(0.0, 0.0, 0.0).color(0, 0, 0, 255).endVertex();
        llllllllllllllIIlIIIlIlllIIIIlII.pos(0.0, 0.0, llllllllllllllIIlIIIlIlllIIIIIll).color(0, 0, 0, 255).endVertex();
        llllllllllllllIIlIIIlIlllIIIIlIl.draw();
        GL11.glLineWidth(2.0f);
        llllllllllllllIIlIIIlIlllIIIIlII.begin(1, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllIIlIIIlIlllIIIIlII.pos(0.0, 0.0, 0.0).color(255, 0, 0, 255).endVertex();
        llllllllllllllIIlIIIlIlllIIIIlII.pos(llllllllllllllIIlIIIlIlllIIIIIll, 0.0, 0.0).color(255, 0, 0, 255).endVertex();
        llllllllllllllIIlIIIlIlllIIIIlII.pos(0.0, 0.0, 0.0).color(0, 255, 0, 255).endVertex();
        llllllllllllllIIlIIIlIlllIIIIlII.pos(0.0, llllllllllllllIIlIIIlIlllIIIIIll, 0.0).color(0, 255, 0, 255).endVertex();
        llllllllllllllIIlIIIlIlllIIIIlII.pos(0.0, 0.0, 0.0).color(127, 127, 255, 255).endVertex();
        llllllllllllllIIlIIIlIlllIIIIlII.pos(0.0, 0.0, llllllllllllllIIlIIIlIlllIIIIIll).color(127, 127, 255, 255).endVertex();
        llllllllllllllIIlIIIlIlllIIIIlIl.draw();
        GL11.glLineWidth(1.0f);
        GlStateManager.depthMask(true);
        GlStateManager.enableTexture2D();
    }
    
    public static void openFile(final File llllllllllllllIIlIIIlIllIllllIll) {
        final String llllllllllllllIIlIIIlIllIllllIlI = llllllllllllllIIlIIIlIllIllllIll.getAbsolutePath();
        Label_0107: {
            if (Util.getOSType() == Util.EnumOS.OSX) {
                try {
                    OpenGlHelper.LOGGER.info(llllllllllllllIIlIIIlIllIllllIlI);
                    Runtime.getRuntime().exec(new String[] { "/usr/bin/open", llllllllllllllIIlIIIlIllIllllIlI });
                    return;
                }
                catch (IOException llllllllllllllIIlIIIlIllIllllIIl) {
                    OpenGlHelper.LOGGER.error("Couldn't open file", (Throwable)llllllllllllllIIlIIIlIllIllllIIl);
                    break Label_0107;
                }
            }
            if (Util.getOSType() == Util.EnumOS.WINDOWS) {
                final String llllllllllllllIIlIIIlIllIllllIII = String.format("cmd.exe /C start \"Open file\" \"%s\"", llllllllllllllIIlIIIlIllIllllIlI);
                try {
                    Runtime.getRuntime().exec(llllllllllllllIIlIIIlIllIllllIII);
                    return;
                }
                catch (IOException llllllllllllllIIlIIIlIllIlllIlll) {
                    OpenGlHelper.LOGGER.error("Couldn't open file", (Throwable)llllllllllllllIIlIIIlIllIlllIlll);
                }
            }
        }
        boolean llllllllllllllIIlIIIlIllIlllIllI = false;
        try {
            final Class<?> llllllllllllllIIlIIIlIllIlllIlIl = Class.forName("java.awt.Desktop");
            final Object llllllllllllllIIlIIIlIllIlllIlII = llllllllllllllIIlIIIlIllIlllIlIl.getMethod("getDesktop", (Class<?>[])new Class[0]).invoke(null, new Object[0]);
            llllllllllllllIIlIIIlIllIlllIlIl.getMethod("browse", URI.class).invoke(llllllllllllllIIlIIIlIllIlllIlII, llllllllllllllIIlIIIlIllIllllIll.toURI());
        }
        catch (Throwable llllllllllllllIIlIIIlIllIlllIIll) {
            OpenGlHelper.LOGGER.error("Couldn't open link", llllllllllllllIIlIIIlIllIlllIIll);
            llllllllllllllIIlIIIlIllIlllIllI = true;
        }
        if (llllllllllllllIIlIIIlIllIlllIllI) {
            OpenGlHelper.LOGGER.info("Opening via system class!");
            Sys.openURL(String.valueOf(new StringBuilder("file://").append(llllllllllllllIIlIIIlIllIllllIlI)));
        }
    }
    
    public static int glGetAttribLocation(final int llllllllllllllIIlIIIlIllllllIlII, final CharSequence llllllllllllllIIlIIIlIllllllIlIl) {
        return OpenGlHelper.arbShaders ? ARBVertexShader.glGetAttribLocationARB(llllllllllllllIIlIIIlIllllllIlII, llllllllllllllIIlIIIlIllllllIlIl) : GL20.glGetAttribLocation(llllllllllllllIIlIIIlIllllllIlII, llllllllllllllIIlIIIlIllllllIlIl);
    }
    
    public static void glUniform1(final int llllllllllllllIIlIIIllIIIlIIIlIl, final IntBuffer llllllllllllllIIlIIIllIIIlIIIllI) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniform1ARB(llllllllllllllIIlIIIllIIIlIIIlIl, llllllllllllllIIlIIIllIIIlIIIllI);
        }
        else {
            GL20.glUniform1(llllllllllllllIIlIIIllIIIlIIIlIl, llllllllllllllIIlIIIllIIIlIIIllI);
        }
    }
    
    public static void glAttachShader(final int llllllllllllllIIlIIIllIIIllllIll, final int llllllllllllllIIlIIIllIIIlllllII) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glAttachObjectARB(llllllllllllllIIlIIIllIIIllllIll, llllllllllllllIIlIIIllIIIlllllII);
        }
        else {
            GL20.glAttachShader(llllllllllllllIIlIIIllIIIllllIll, llllllllllllllIIlIIIllIIIlllllII);
        }
    }
    
    public static void glUniform4(final int llllllllllllllIIlIIIllIIIIIlIlIl, final FloatBuffer llllllllllllllIIlIIIllIIIIIlIllI) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniform4ARB(llllllllllllllIIlIIIllIIIIIlIlIl, llllllllllllllIIlIIIllIIIIIlIllI);
        }
        else {
            GL20.glUniform4(llllllllllllllIIlIIIllIIIIIlIlIl, llllllllllllllIIlIIIllIIIIIlIllI);
        }
    }
    
    public static void setLightmapTextureCoords(final int llllllllllllllIIlIIIlIlllIIllIII, final float llllllllllllllIIlIIIlIlllIIllIlI, final float llllllllllllllIIlIIIlIlllIIllIIl) {
        if (OpenGlHelper.arbMultitexture) {
            ARBMultitexture.glMultiTexCoord2fARB(llllllllllllllIIlIIIlIlllIIllIII, llllllllllllllIIlIIIlIlllIIllIlI, llllllllllllllIIlIIIlIlllIIllIIl);
        }
        else {
            GL13.glMultiTexCoord2f(llllllllllllllIIlIIIlIlllIIllIII, llllllllllllllIIlIIIlIlllIIllIlI, llllllllllllllIIlIIIlIlllIIllIIl);
        }
        if (llllllllllllllIIlIIIlIlllIIllIII == OpenGlHelper.lightmapTexUnit) {
            OpenGlHelper.lastBrightnessX = llllllllllllllIIlIIIlIlllIIllIlI;
            OpenGlHelper.lastBrightnessY = llllllllllllllIIlIIIlIlllIIllIIl;
        }
    }
    
    public static void glFramebufferRenderbuffer(final int llllllllllllllIIlIIIlIlllIlllllI, final int llllllllllllllIIlIIIlIlllIlllIIl, final int llllllllllllllIIlIIIlIlllIllllII, final int llllllllllllllIIlIIIlIlllIllIlll) {
        if (OpenGlHelper.framebufferSupported) {
            switch ($SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode()[OpenGlHelper.framebufferType.ordinal()]) {
                case 1: {
                    GL30.glFramebufferRenderbuffer(llllllllllllllIIlIIIlIlllIlllllI, llllllllllllllIIlIIIlIlllIlllIIl, llllllllllllllIIlIIIlIlllIllllII, llllllllllllllIIlIIIlIlllIllIlll);
                    break;
                }
                case 2: {
                    ARBFramebufferObject.glFramebufferRenderbuffer(llllllllllllllIIlIIIlIlllIlllllI, llllllllllllllIIlIIIlIlllIlllIIl, llllllllllllllIIlIIIlIlllIllllII, llllllllllllllIIlIIIlIlllIllIlll);
                    break;
                }
                case 3: {
                    EXTFramebufferObject.glFramebufferRenderbufferEXT(llllllllllllllIIlIIIlIlllIlllllI, llllllllllllllIIlIIIlIlllIlllIIl, llllllllllllllIIlIIIlIlllIllllII, llllllllllllllIIlIIIlIlllIllIlll);
                    break;
                }
            }
        }
    }
    
    public static void glUniform4(final int llllllllllllllIIlIIIllIIIIIlllIl, final IntBuffer llllllllllllllIIlIIIllIIIIIlllII) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniform4ARB(llllllllllllllIIlIIIllIIIIIlllIl, llllllllllllllIIlIIIllIIIIIlllII);
        }
        else {
            GL20.glUniform4(llllllllllllllIIlIIIllIIIIIlllIl, llllllllllllllIIlIIIllIIIIIlllII);
        }
    }
    
    public static void glBindFramebuffer(final int llllllllllllllIIlIIIlIllllIlllII, final int llllllllllllllIIlIIIlIllllIllIll) {
        if (OpenGlHelper.framebufferSupported) {
            switch ($SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode()[OpenGlHelper.framebufferType.ordinal()]) {
                case 1: {
                    GL30.glBindFramebuffer(llllllllllllllIIlIIIlIllllIlllII, llllllllllllllIIlIIIlIllllIllIll);
                    break;
                }
                case 2: {
                    ARBFramebufferObject.glBindFramebuffer(llllllllllllllIIlIIIlIllllIlllII, llllllllllllllIIlIIIlIllllIllIll);
                    break;
                }
                case 3: {
                    EXTFramebufferObject.glBindFramebufferEXT(llllllllllllllIIlIIIlIllllIlllII, llllllllllllllIIlIIIlIllllIllIll);
                    break;
                }
            }
        }
    }
    
    public static void glBlendFunc(final int llllllllllllllIIlIIIlIlllIIlIIIl, final int llllllllllllllIIlIIIlIlllIIIllII, final int llllllllllllllIIlIIIlIlllIIIlIll, final int llllllllllllllIIlIIIlIlllIIIlllI) {
        if (OpenGlHelper.openGL14) {
            if (OpenGlHelper.extBlendFuncSeparate) {
                EXTBlendFuncSeparate.glBlendFuncSeparateEXT(llllllllllllllIIlIIIlIlllIIlIIIl, llllllllllllllIIlIIIlIlllIIIllII, llllllllllllllIIlIIIlIlllIIIlIll, llllllllllllllIIlIIIlIlllIIIlllI);
            }
            else {
                GL14.glBlendFuncSeparate(llllllllllllllIIlIIIlIlllIIlIIIl, llllllllllllllIIlIIIlIlllIIIllII, llllllllllllllIIlIIIlIlllIIIlIll, llllllllllllllIIlIIIlIlllIIIlllI);
            }
        }
        else {
            GL11.glBlendFunc(llllllllllllllIIlIIIlIlllIIlIIIl, llllllllllllllIIlIIIlIlllIIIllII);
        }
    }
    
    public static void glUniformMatrix3(final int llllllllllllllIIlIIIllIIIIIIIlll, final boolean llllllllllllllIIlIIIllIIIIIIIIll, final FloatBuffer llllllllllllllIIlIIIllIIIIIIIlIl) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniformMatrix3ARB(llllllllllllllIIlIIIllIIIIIIIlll, llllllllllllllIIlIIIllIIIIIIIIll, llllllllllllllIIlIIIllIIIIIIIlIl);
        }
        else {
            GL20.glUniformMatrix3(llllllllllllllIIlIIIllIIIIIIIlll, llllllllllllllIIlIIIllIIIIIIIIll, llllllllllllllIIlIIIllIIIIIIIlIl);
        }
    }
    
    public static int glCreateShader(final int llllllllllllllIIlIIIllIIIlllIlIl) {
        return OpenGlHelper.arbShaders ? ARBShaderObjects.glCreateShaderObjectARB(llllllllllllllIIlIIIllIIIlllIlIl) : GL20.glCreateShader(llllllllllllllIIlIIIllIIIlllIlIl);
    }
    
    public static boolean useVbo() {
        return !Config.isMultiTexture() && (OpenGlHelper.vboSupported && Minecraft.getMinecraft().gameSettings.useVbo);
    }
    
    public static String getCpu() {
        return (OpenGlHelper.cpu == null) ? "<unknown>" : OpenGlHelper.cpu;
    }
    
    public static int glGetProgrami(final int llllllllllllllIIlIIIllIIlIIIIIIl, final int llllllllllllllIIlIIIllIIlIIIIIII) {
        return OpenGlHelper.arbShaders ? ARBShaderObjects.glGetObjectParameteriARB(llllllllllllllIIlIIIllIIlIIIIIIl, llllllllllllllIIlIIIllIIlIIIIIII) : GL20.glGetProgrami(llllllllllllllIIlIIIllIIlIIIIIIl, llllllllllllllIIlIIIllIIlIIIIIII);
    }
    
    public static void glBufferData(final int llllllllllllllIIlIIIlIlllllIIllI, final ByteBuffer llllllllllllllIIlIIIlIlllllIlIII, final int llllllllllllllIIlIIIlIlllllIIlll) {
        if (OpenGlHelper.arbVbo) {
            ARBVertexBufferObject.glBufferDataARB(llllllllllllllIIlIIIlIlllllIIllI, llllllllllllllIIlIIIlIlllllIlIII, llllllllllllllIIlIIIlIlllllIIlll);
        }
        else {
            GL15.glBufferData(llllllllllllllIIlIIIlIlllllIIllI, llllllllllllllIIlIIIlIlllllIlIII, llllllllllllllIIlIIIlIlllllIIlll);
        }
    }
    
    public static int glGetUniformLocation(final int llllllllllllllIIlIIIllIIIlIIllIl, final CharSequence llllllllllllllIIlIIIllIIIlIIllII) {
        return OpenGlHelper.arbShaders ? ARBShaderObjects.glGetUniformLocationARB(llllllllllllllIIlIIIllIIIlIIllIl, llllllllllllllIIlIIIllIIIlIIllII) : GL20.glGetUniformLocation(llllllllllllllIIlIIIllIIIlIIllIl, llllllllllllllIIlIIIllIIIlIIllII);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode() {
        final int[] $switch_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode = OpenGlHelper.$SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode;
        if ($switch_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode != null) {
            return $switch_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode;
        }
        final int llllllllllllllIIlIIIlIllIllIllII = (Object)new int[FboMode.values().length];
        try {
            llllllllllllllIIlIIIlIllIllIllII[FboMode.ARB.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIlIIIlIllIllIllII[FboMode.BASE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIlIIIlIllIllIllII[FboMode.EXT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return OpenGlHelper.$SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode = (int[])(Object)llllllllllllllIIlIIIlIllIllIllII;
    }
    
    public static void glFramebufferTexture2D(final int llllllllllllllIIlIIIlIlllIlIlllI, final int llllllllllllllIIlIIIlIlllIlIllIl, final int llllllllllllllIIlIIIlIlllIlIllII, final int llllllllllllllIIlIIIlIlllIlIlIll, final int llllllllllllllIIlIIIlIlllIlIlIlI) {
        if (OpenGlHelper.framebufferSupported) {
            switch ($SWITCH_TABLE$net$minecraft$client$renderer$OpenGlHelper$FboMode()[OpenGlHelper.framebufferType.ordinal()]) {
                case 1: {
                    GL30.glFramebufferTexture2D(llllllllllllllIIlIIIlIlllIlIlllI, llllllllllllllIIlIIIlIlllIlIllIl, llllllllllllllIIlIIIlIlllIlIllII, llllllllllllllIIlIIIlIlllIlIlIll, llllllllllllllIIlIIIlIlllIlIlIlI);
                    break;
                }
                case 2: {
                    ARBFramebufferObject.glFramebufferTexture2D(llllllllllllllIIlIIIlIlllIlIlllI, llllllllllllllIIlIIIlIlllIlIllIl, llllllllllllllIIlIIIlIlllIlIllII, llllllllllllllIIlIIIlIlllIlIlIll, llllllllllllllIIlIIIlIlllIlIlIlI);
                    break;
                }
                case 3: {
                    EXTFramebufferObject.glFramebufferTexture2DEXT(llllllllllllllIIlIIIlIlllIlIlllI, llllllllllllllIIlIIIlIlllIlIllIl, llllllllllllllIIlIIIlIlllIlIllII, llllllllllllllIIlIIIlIlllIlIlIll, llllllllllllllIIlIIIlIlllIlIlIlI);
                    break;
                }
            }
        }
    }
    
    public static boolean areShadersSupported() {
        return OpenGlHelper.shadersSupported;
    }
    
    public static int glGetShaderi(final int llllllllllllllIIlIIIllIIIllIlIII, final int llllllllllllllIIlIIIllIIIllIIlll) {
        return OpenGlHelper.arbShaders ? ARBShaderObjects.glGetObjectParameteriARB(llllllllllllllIIlIIIllIIIllIlIII, llllllllllllllIIlIIIllIIIllIIlll) : GL20.glGetShaderi(llllllllllllllIIlIIIllIIIllIlIII, llllllllllllllIIlIIIllIIIllIIlll);
    }
    
    public static int glCreateProgram() {
        return OpenGlHelper.arbShaders ? ARBShaderObjects.glCreateProgramObjectARB() : GL20.glCreateProgram();
    }
    
    public static void glUniform1i(final int llllllllllllllIIlIIIllIIIIllllll, final int llllllllllllllIIlIIIllIIIlIIIIII) {
        if (OpenGlHelper.arbShaders) {
            ARBShaderObjects.glUniform1iARB(llllllllllllllIIlIIIllIIIIllllll, llllllllllllllIIlIIIllIIIlIIIIII);
        }
        else {
            GL20.glUniform1i(llllllllllllllIIlIIIllIIIIllllll, llllllllllllllIIlIIIllIIIlIIIIII);
        }
    }
    
    public static void initializeTextures() {
        Config.initDisplay();
        final ContextCapabilities llllllllllllllIIlIIIllIIlIIIlIll = GLContext.getCapabilities();
        OpenGlHelper.arbMultitexture = (llllllllllllllIIlIIIllIIlIIIlIll.GL_ARB_multitexture && !llllllllllllllIIlIIIllIIlIIIlIll.OpenGL13);
        OpenGlHelper.arbTextureEnvCombine = (llllllllllllllIIlIIIllIIlIIIlIll.GL_ARB_texture_env_combine && !llllllllllllllIIlIIIllIIlIIIlIll.OpenGL13);
        if (OpenGlHelper.arbMultitexture) {
            OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("Using ARB_multitexture.\n"));
            OpenGlHelper.defaultTexUnit = 33984;
            OpenGlHelper.lightmapTexUnit = 33985;
            OpenGlHelper.GL_TEXTURE2 = 33986;
        }
        else {
            OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("Using GL 1.3 multitexturing.\n"));
            OpenGlHelper.defaultTexUnit = 33984;
            OpenGlHelper.lightmapTexUnit = 33985;
            OpenGlHelper.GL_TEXTURE2 = 33986;
        }
        if (OpenGlHelper.arbTextureEnvCombine) {
            OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("Using ARB_texture_env_combine.\n"));
            OpenGlHelper.GL_COMBINE = 34160;
            OpenGlHelper.GL_INTERPOLATE = 34165;
            OpenGlHelper.GL_PRIMARY_COLOR = 34167;
            OpenGlHelper.GL_CONSTANT = 34166;
            OpenGlHelper.GL_PREVIOUS = 34168;
            OpenGlHelper.GL_COMBINE_RGB = 34161;
            OpenGlHelper.GL_SOURCE0_RGB = 34176;
            OpenGlHelper.GL_SOURCE1_RGB = 34177;
            OpenGlHelper.GL_SOURCE2_RGB = 34178;
            OpenGlHelper.GL_OPERAND0_RGB = 34192;
            OpenGlHelper.GL_OPERAND1_RGB = 34193;
            OpenGlHelper.GL_OPERAND2_RGB = 34194;
            OpenGlHelper.GL_COMBINE_ALPHA = 34162;
            OpenGlHelper.GL_SOURCE0_ALPHA = 34184;
            OpenGlHelper.GL_SOURCE1_ALPHA = 34185;
            OpenGlHelper.GL_SOURCE2_ALPHA = 34186;
            OpenGlHelper.GL_OPERAND0_ALPHA = 34200;
            OpenGlHelper.GL_OPERAND1_ALPHA = 34201;
            OpenGlHelper.GL_OPERAND2_ALPHA = 34202;
        }
        else {
            OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("Using GL 1.3 texture combiners.\n"));
            OpenGlHelper.GL_COMBINE = 34160;
            OpenGlHelper.GL_INTERPOLATE = 34165;
            OpenGlHelper.GL_PRIMARY_COLOR = 34167;
            OpenGlHelper.GL_CONSTANT = 34166;
            OpenGlHelper.GL_PREVIOUS = 34168;
            OpenGlHelper.GL_COMBINE_RGB = 34161;
            OpenGlHelper.GL_SOURCE0_RGB = 34176;
            OpenGlHelper.GL_SOURCE1_RGB = 34177;
            OpenGlHelper.GL_SOURCE2_RGB = 34178;
            OpenGlHelper.GL_OPERAND0_RGB = 34192;
            OpenGlHelper.GL_OPERAND1_RGB = 34193;
            OpenGlHelper.GL_OPERAND2_RGB = 34194;
            OpenGlHelper.GL_COMBINE_ALPHA = 34162;
            OpenGlHelper.GL_SOURCE0_ALPHA = 34184;
            OpenGlHelper.GL_SOURCE1_ALPHA = 34185;
            OpenGlHelper.GL_SOURCE2_ALPHA = 34186;
            OpenGlHelper.GL_OPERAND0_ALPHA = 34200;
            OpenGlHelper.GL_OPERAND1_ALPHA = 34201;
            OpenGlHelper.GL_OPERAND2_ALPHA = 34202;
        }
        OpenGlHelper.extBlendFuncSeparate = (llllllllllllllIIlIIIllIIlIIIlIll.GL_EXT_blend_func_separate && !llllllllllllllIIlIIIllIIlIIIlIll.OpenGL14);
        OpenGlHelper.openGL14 = (llllllllllllllIIlIIIllIIlIIIlIll.OpenGL14 || llllllllllllllIIlIIIllIIlIIIlIll.GL_EXT_blend_func_separate);
        OpenGlHelper.framebufferSupported = (OpenGlHelper.openGL14 && (llllllllllllllIIlIIIllIIlIIIlIll.GL_ARB_framebuffer_object || llllllllllllllIIlIIIllIIlIIIlIll.GL_EXT_framebuffer_object || llllllllllllllIIlIIIllIIlIIIlIll.OpenGL30));
        if (OpenGlHelper.framebufferSupported) {
            OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("Using framebuffer objects because "));
            if (llllllllllllllIIlIIIllIIlIIIlIll.OpenGL30) {
                OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("OpenGL 3.0 is supported and separate blending is supported.\n"));
                OpenGlHelper.framebufferType = FboMode.BASE;
                OpenGlHelper.GL_FRAMEBUFFER = 36160;
                OpenGlHelper.GL_RENDERBUFFER = 36161;
                OpenGlHelper.GL_COLOR_ATTACHMENT0 = 36064;
                OpenGlHelper.GL_DEPTH_ATTACHMENT = 36096;
                OpenGlHelper.GL_FRAMEBUFFER_COMPLETE = 36053;
                OpenGlHelper.GL_FB_INCOMPLETE_ATTACHMENT = 36054;
                OpenGlHelper.GL_FB_INCOMPLETE_MISS_ATTACH = 36055;
                OpenGlHelper.GL_FB_INCOMPLETE_DRAW_BUFFER = 36059;
                OpenGlHelper.GL_FB_INCOMPLETE_READ_BUFFER = 36060;
            }
            else if (llllllllllllllIIlIIIllIIlIIIlIll.GL_ARB_framebuffer_object) {
                OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("ARB_framebuffer_object is supported and separate blending is supported.\n"));
                OpenGlHelper.framebufferType = FboMode.ARB;
                OpenGlHelper.GL_FRAMEBUFFER = 36160;
                OpenGlHelper.GL_RENDERBUFFER = 36161;
                OpenGlHelper.GL_COLOR_ATTACHMENT0 = 36064;
                OpenGlHelper.GL_DEPTH_ATTACHMENT = 36096;
                OpenGlHelper.GL_FRAMEBUFFER_COMPLETE = 36053;
                OpenGlHelper.GL_FB_INCOMPLETE_MISS_ATTACH = 36055;
                OpenGlHelper.GL_FB_INCOMPLETE_ATTACHMENT = 36054;
                OpenGlHelper.GL_FB_INCOMPLETE_DRAW_BUFFER = 36059;
                OpenGlHelper.GL_FB_INCOMPLETE_READ_BUFFER = 36060;
            }
            else if (llllllllllllllIIlIIIllIIlIIIlIll.GL_EXT_framebuffer_object) {
                OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("EXT_framebuffer_object is supported.\n"));
                OpenGlHelper.framebufferType = FboMode.EXT;
                OpenGlHelper.GL_FRAMEBUFFER = 36160;
                OpenGlHelper.GL_RENDERBUFFER = 36161;
                OpenGlHelper.GL_COLOR_ATTACHMENT0 = 36064;
                OpenGlHelper.GL_DEPTH_ATTACHMENT = 36096;
                OpenGlHelper.GL_FRAMEBUFFER_COMPLETE = 36053;
                OpenGlHelper.GL_FB_INCOMPLETE_MISS_ATTACH = 36055;
                OpenGlHelper.GL_FB_INCOMPLETE_ATTACHMENT = 36054;
                OpenGlHelper.GL_FB_INCOMPLETE_DRAW_BUFFER = 36059;
                OpenGlHelper.GL_FB_INCOMPLETE_READ_BUFFER = 36060;
            }
        }
        else {
            OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("Not using framebuffer objects because "));
            OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("OpenGL 1.4 is ").append(llllllllllllllIIlIIIllIIlIIIlIll.OpenGL14 ? "" : "not ").append("supported, "));
            OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("EXT_blend_func_separate is ").append(llllllllllllllIIlIIIllIIlIIIlIll.GL_EXT_blend_func_separate ? "" : "not ").append("supported, "));
            OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("OpenGL 3.0 is ").append(llllllllllllllIIlIIIllIIlIIIlIll.OpenGL30 ? "" : "not ").append("supported, "));
            OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("ARB_framebuffer_object is ").append(llllllllllllllIIlIIIllIIlIIIlIll.GL_ARB_framebuffer_object ? "" : "not ").append("supported, and "));
            OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("EXT_framebuffer_object is ").append(llllllllllllllIIlIIIllIIlIIIlIll.GL_EXT_framebuffer_object ? "" : "not ").append("supported.\n"));
        }
        OpenGlHelper.openGL21 = llllllllllllllIIlIIIllIIlIIIlIll.OpenGL21;
        OpenGlHelper.shadersAvailable = (OpenGlHelper.openGL21 || (llllllllllllllIIlIIIllIIlIIIlIll.GL_ARB_vertex_shader && llllllllllllllIIlIIIllIIlIIIlIll.GL_ARB_fragment_shader && llllllllllllllIIlIIIllIIlIIIlIll.GL_ARB_shader_objects));
        OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("Shaders are ").append(OpenGlHelper.shadersAvailable ? "" : "not ").append("available because "));
        if (OpenGlHelper.shadersAvailable) {
            if (llllllllllllllIIlIIIllIIlIIIlIll.OpenGL21) {
                OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("OpenGL 2.1 is supported.\n"));
                OpenGlHelper.arbShaders = false;
                OpenGlHelper.GL_LINK_STATUS = 35714;
                OpenGlHelper.GL_COMPILE_STATUS = 35713;
                OpenGlHelper.GL_VERTEX_SHADER = 35633;
                OpenGlHelper.GL_FRAGMENT_SHADER = 35632;
            }
            else {
                OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("ARB_shader_objects, ARB_vertex_shader, and ARB_fragment_shader are supported.\n"));
                OpenGlHelper.arbShaders = true;
                OpenGlHelper.GL_LINK_STATUS = 35714;
                OpenGlHelper.GL_COMPILE_STATUS = 35713;
                OpenGlHelper.GL_VERTEX_SHADER = 35633;
                OpenGlHelper.GL_FRAGMENT_SHADER = 35632;
            }
        }
        else {
            OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("OpenGL 2.1 is ").append(llllllllllllllIIlIIIllIIlIIIlIll.OpenGL21 ? "" : "not ").append("supported, "));
            OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("ARB_shader_objects is ").append(llllllllllllllIIlIIIllIIlIIIlIll.GL_ARB_shader_objects ? "" : "not ").append("supported, "));
            OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("ARB_vertex_shader is ").append(llllllllllllllIIlIIIllIIlIIIlIll.GL_ARB_vertex_shader ? "" : "not ").append("supported, and "));
            OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("ARB_fragment_shader is ").append(llllllllllllllIIlIIIllIIlIIIlIll.GL_ARB_fragment_shader ? "" : "not ").append("supported.\n"));
        }
        OpenGlHelper.shadersSupported = (OpenGlHelper.framebufferSupported && OpenGlHelper.shadersAvailable);
        final String llllllllllllllIIlIIIllIIlIIIlIlI = GL11.glGetString(7936).toLowerCase(Locale.ROOT);
        OpenGlHelper.nvidia = llllllllllllllIIlIIIllIIlIIIlIlI.contains("nvidia");
        OpenGlHelper.arbVbo = (!llllllllllllllIIlIIIllIIlIIIlIll.OpenGL15 && llllllllllllllIIlIIIllIIlIIIlIll.GL_ARB_vertex_buffer_object);
        OpenGlHelper.vboSupported = (llllllllllllllIIlIIIllIIlIIIlIll.OpenGL15 || OpenGlHelper.arbVbo);
        OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("VBOs are ").append(OpenGlHelper.vboSupported ? "" : "not ").append("available because "));
        if (OpenGlHelper.vboSupported) {
            if (OpenGlHelper.arbVbo) {
                OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("ARB_vertex_buffer_object is supported.\n"));
                OpenGlHelper.GL_STATIC_DRAW = 35044;
                OpenGlHelper.GL_ARRAY_BUFFER = 34962;
            }
            else {
                OpenGlHelper.logText = String.valueOf(new StringBuilder(String.valueOf(OpenGlHelper.logText)).append("OpenGL 1.5 is supported.\n"));
                OpenGlHelper.GL_STATIC_DRAW = 35044;
                OpenGlHelper.GL_ARRAY_BUFFER = 34962;
            }
        }
        OpenGlHelper.ati = llllllllllllllIIlIIIllIIlIIIlIlI.contains("ati");
        if (OpenGlHelper.ati) {
            if (OpenGlHelper.vboSupported) {
                OpenGlHelper.vboSupportedAti = true;
            }
            else {
                GameSettings.Options.RENDER_DISTANCE.setValueMax(16.0f);
            }
        }
        try {
            final Processor[] llllllllllllllIIlIIIllIIlIIIlIIl = new SystemInfo().getHardware().getProcessors();
            OpenGlHelper.cpu = String.format("%dx %s", llllllllllllllIIlIIIllIIlIIIlIIl.length, llllllllllllllIIlIIIllIIlIIIlIIl[0]).replaceAll("\\s+", " ");
        }
        catch (Throwable t) {}
    }
    
    enum FboMode
    {
        EXT("EXT", 2), 
        BASE("BASE", 0), 
        ARB("ARB", 1);
        
        private FboMode(final String lllllllllllllIIlIllIlIIlIlllllII, final int lllllllllllllIIlIllIlIIlIllllIll) {
        }
    }
}
