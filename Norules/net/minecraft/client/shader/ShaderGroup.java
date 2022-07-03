package net.minecraft.client.shader;

import org.lwjgl.util.vector.*;
import com.google.common.collect.*;
import net.minecraft.client.util.*;
import net.minecraft.util.*;
import org.apache.commons.io.*;
import java.io.*;
import net.minecraft.client.renderer.*;
import java.util.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.renderer.texture.*;
import com.google.gson.*;
import java.nio.charset.*;

public class ShaderGroup
{
    private /* synthetic */ int mainFramebufferWidth;
    private final /* synthetic */ String shaderGroupName;
    public final /* synthetic */ Framebuffer mainFramebuffer;
    private final /* synthetic */ List<Framebuffer> listFramebuffers;
    private final /* synthetic */ Map<String, Framebuffer> mapFramebuffers;
    private final /* synthetic */ IResourceManager resourceManager;
    private /* synthetic */ int mainFramebufferHeight;
    private /* synthetic */ float time;
    private final /* synthetic */ List<Shader> listShaders;
    private /* synthetic */ Matrix4f projectionMatrix;
    private /* synthetic */ float lastStamp;
    
    public ShaderGroup(final TextureManager llllllllllllllIIlIIlIlIIIIlIlIll, final IResourceManager llllllllllllllIIlIIlIlIIIIlIIlII, final Framebuffer llllllllllllllIIlIIlIlIIIIlIIIlI, final ResourceLocation llllllllllllllIIlIIlIlIIIIlIIIII) throws JsonException, IOException, JsonSyntaxException {
        this.listShaders = (List<Shader>)Lists.newArrayList();
        this.mapFramebuffers = (Map<String, Framebuffer>)Maps.newHashMap();
        this.listFramebuffers = (List<Framebuffer>)Lists.newArrayList();
        this.resourceManager = llllllllllllllIIlIIlIlIIIIlIIlII;
        this.mainFramebuffer = llllllllllllllIIlIIlIlIIIIlIIIlI;
        this.time = 0.0f;
        this.lastStamp = 0.0f;
        this.mainFramebufferWidth = llllllllllllllIIlIIlIlIIIIlIIIlI.framebufferWidth;
        this.mainFramebufferHeight = llllllllllllllIIlIIlIlIIIIlIIIlI.framebufferHeight;
        this.shaderGroupName = llllllllllllllIIlIIlIlIIIIlIIIII.toString();
        this.resetProjectionMatrix();
        this.parseGroup(llllllllllllllIIlIIlIlIIIIlIlIll, llllllllllllllIIlIIlIlIIIIlIIIII);
    }
    
    private void initTarget(final JsonElement llllllllllllllIIlIIlIIlllIIIlIlI) throws JsonException {
        if (JsonUtils.isString(llllllllllllllIIlIIlIIlllIIIlIlI)) {
            this.addFramebuffer(llllllllllllllIIlIIlIIlllIIIlIlI.getAsString(), this.mainFramebufferWidth, this.mainFramebufferHeight);
        }
        else {
            final JsonObject llllllllllllllIIlIIlIIlllIIIllll = JsonUtils.getJsonObject(llllllllllllllIIlIIlIIlllIIIlIlI, "target");
            final String llllllllllllllIIlIIlIIlllIIIlllI = JsonUtils.getString(llllllllllllllIIlIIlIIlllIIIllll, "name");
            final int llllllllllllllIIlIIlIIlllIIIllIl = JsonUtils.getInt(llllllllllllllIIlIIlIIlllIIIllll, "width", this.mainFramebufferWidth);
            final int llllllllllllllIIlIIlIIlllIIIllII = JsonUtils.getInt(llllllllllllllIIlIIlIIlllIIIllll, "height", this.mainFramebufferHeight);
            if (this.mapFramebuffers.containsKey(llllllllllllllIIlIIlIIlllIIIlllI)) {
                throw new JsonException(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIIlIIlllIIIlllI)).append(" is already defined")));
            }
            this.addFramebuffer(llllllllllllllIIlIIlIIlllIIIlllI, llllllllllllllIIlIIlIIlllIIIllIl, llllllllllllllIIlIIlIIlllIIIllII);
        }
    }
    
    public Shader addShader(final String llllllllllllllIIlIIlIIlIllllIIlI, final Framebuffer llllllllllllllIIlIIlIIlIllllIIIl, final Framebuffer llllllllllllllIIlIIlIIlIlllIlIll) throws IOException, JsonException {
        final Shader llllllllllllllIIlIIlIIlIlllIllll = new Shader(this.resourceManager, llllllllllllllIIlIIlIIlIllllIIlI, llllllllllllllIIlIIlIIlIllllIIIl, llllllllllllllIIlIIlIIlIlllIlIll);
        this.listShaders.add(this.listShaders.size(), llllllllllllllIIlIIlIIlIlllIllll);
        return llllllllllllllIIlIIlIIlIlllIllll;
    }
    
    public void loadShaderGroup(final float llllllllllllllIIlIIlIIlIllIIllll) {
        if (llllllllllllllIIlIIlIIlIllIIllll < this.lastStamp) {
            this.time += 1.0f - this.lastStamp;
            this.time += llllllllllllllIIlIIlIIlIllIIllll;
        }
        else {
            this.time += llllllllllllllIIlIIlIIlIllIIllll - this.lastStamp;
        }
        this.lastStamp = llllllllllllllIIlIIlIIlIllIIllll;
        while (this.time > 20.0f) {
            this.time -= 20.0f;
        }
        for (final Shader llllllllllllllIIlIIlIIlIllIlIIIl : this.listShaders) {
            llllllllllllllIIlIIlIIlIllIlIIIl.loadShader(this.time / 20.0f);
        }
    }
    
    private void resetProjectionMatrix() {
        this.projectionMatrix = new Matrix4f();
        this.projectionMatrix.setIdentity();
        this.projectionMatrix.m00 = 2.0f / this.mainFramebuffer.framebufferTextureWidth;
        this.projectionMatrix.m11 = 2.0f / -this.mainFramebuffer.framebufferTextureHeight;
        this.projectionMatrix.m22 = -0.0020001999f;
        this.projectionMatrix.m33 = 1.0f;
        this.projectionMatrix.m03 = -1.0f;
        this.projectionMatrix.m13 = 1.0f;
        this.projectionMatrix.m23 = -1.0001999f;
    }
    
    public void createBindFramebuffers(final int llllllllllllllIIlIIlIIlIllIllIll, final int llllllllllllllIIlIIlIIlIllIlllll) {
        this.mainFramebufferWidth = this.mainFramebuffer.framebufferTextureWidth;
        this.mainFramebufferHeight = this.mainFramebuffer.framebufferTextureHeight;
        this.resetProjectionMatrix();
        for (final Shader llllllllllllllIIlIIlIIlIllIllllI : this.listShaders) {
            llllllllllllllIIlIIlIIlIllIllllI.setProjectionMatrix(this.projectionMatrix);
        }
        for (final Framebuffer llllllllllllllIIlIIlIIlIllIlllIl : this.listFramebuffers) {
            llllllllllllllIIlIIlIIlIllIlllIl.createBindFramebuffer(llllllllllllllIIlIIlIIlIllIllIll, llllllllllllllIIlIIlIIlIllIlllll);
        }
    }
    
    public final String getShaderGroupName() {
        return this.shaderGroupName;
    }
    
    public void deleteShaderGroup() {
        for (final Framebuffer llllllllllllllIIlIIlIIlIllllllIl : this.mapFramebuffers.values()) {
            llllllllllllllIIlIIlIIlIllllllIl.deleteFramebuffer();
        }
        for (final Shader llllllllllllllIIlIIlIIlIllllllII : this.listShaders) {
            llllllllllllllIIlIIlIIlIllllllII.deleteShader();
        }
        this.listShaders.clear();
    }
    
    private Framebuffer getFramebuffer(final String llllllllllllllIIlIIlIIlIllIIIlII) {
        if (llllllllllllllIIlIIlIIlIllIIIlII == null) {
            return null;
        }
        return llllllllllllllIIlIIlIIlIllIIIlII.equals("minecraft:main") ? this.mainFramebuffer : this.mapFramebuffers.get(llllllllllllllIIlIIlIIlIllIIIlII);
    }
    
    private void initUniform(final JsonElement llllllllllllllIIlIIlIIllIIlIIIII) throws JsonException {
        final JsonObject llllllllllllllIIlIIlIIllIIlIlIIl = JsonUtils.getJsonObject(llllllllllllllIIlIIlIIllIIlIIIII, "uniform");
        final String llllllllllllllIIlIIlIIllIIlIlIII = JsonUtils.getString(llllllllllllllIIlIIlIIllIIlIlIIl, "name");
        final ShaderUniform llllllllllllllIIlIIlIIllIIlIIlll = this.listShaders.get(this.listShaders.size() - 1).getShaderManager().getShaderUniform(llllllllllllllIIlIIlIIllIIlIlIII);
        if (llllllllllllllIIlIIlIIllIIlIIlll == null) {
            throw new JsonException(String.valueOf(new StringBuilder("Uniform '").append(llllllllllllllIIlIIlIIllIIlIlIII).append("' does not exist")));
        }
        final float[] llllllllllllllIIlIIlIIllIIlIIllI = new float[4];
        int llllllllllllllIIlIIlIIllIIlIIlIl = 0;
        for (final JsonElement llllllllllllllIIlIIlIIllIIlIIlII : JsonUtils.getJsonArray(llllllllllllllIIlIIlIIllIIlIlIIl, "values")) {
            try {
                llllllllllllllIIlIIlIIllIIlIIllI[llllllllllllllIIlIIlIIllIIlIIlIl] = JsonUtils.getFloat(llllllllllllllIIlIIlIIllIIlIIlII, "value");
            }
            catch (Exception llllllllllllllIIlIIlIIllIIlIIIll) {
                final JsonException llllllllllllllIIlIIlIIllIIlIIIlI = JsonException.forException(llllllllllllllIIlIIlIIllIIlIIIll);
                llllllllllllllIIlIIlIIllIIlIIIlI.prependJsonKey(String.valueOf(new StringBuilder("values[").append(llllllllllllllIIlIIlIIllIIlIIlIl).append("]")));
                throw llllllllllllllIIlIIlIIllIIlIIIlI;
            }
            ++llllllllllllllIIlIIlIIllIIlIIlIl;
        }
        switch (llllllllllllllIIlIIlIIllIIlIIlIl) {
            case 1: {
                llllllllllllllIIlIIlIIllIIlIIlll.set(llllllllllllllIIlIIlIIllIIlIIllI[0]);
                break;
            }
            case 2: {
                llllllllllllllIIlIIlIIllIIlIIlll.set(llllllllllllllIIlIIlIIllIIlIIllI[0], llllllllllllllIIlIIlIIllIIlIIllI[1]);
                break;
            }
            case 3: {
                llllllllllllllIIlIIlIIllIIlIIlll.set(llllllllllllllIIlIIlIIllIIlIIllI[0], llllllllllllllIIlIIlIIllIIlIIllI[1], llllllllllllllIIlIIlIIllIIlIIllI[2]);
                break;
            }
            case 4: {
                llllllllllllllIIlIIlIIllIIlIIlll.set(llllllllllllllIIlIIlIIllIIlIIllI[0], llllllllllllllIIlIIlIIllIIlIIllI[1], llllllllllllllIIlIIlIIllIIlIIllI[2], llllllllllllllIIlIIlIIllIIlIIllI[3]);
                break;
            }
        }
    }
    
    public Framebuffer getFramebufferRaw(final String llllllllllllllIIlIIlIIllIIIlIIIl) {
        return this.mapFramebuffers.get(llllllllllllllIIlIIlIIllIIIlIIIl);
    }
    
    private void parsePass(final TextureManager llllllllllllllIIlIIlIIllIllIllII, final JsonElement llllllllllllllIIlIIlIIllIlIIllII) throws IOException, JsonException {
        final JsonObject llllllllllllllIIlIIlIIllIllIlIlI = JsonUtils.getJsonObject(llllllllllllllIIlIIlIIllIlIIllII, "pass");
        final String llllllllllllllIIlIIlIIllIllIlIIl = JsonUtils.getString(llllllllllllllIIlIIlIIllIllIlIlI, "name");
        final String llllllllllllllIIlIIlIIllIllIlIII = JsonUtils.getString(llllllllllllllIIlIIlIIllIllIlIlI, "intarget");
        final String llllllllllllllIIlIIlIIllIllIIlll = JsonUtils.getString(llllllllllllllIIlIIlIIllIllIlIlI, "outtarget");
        final Framebuffer llllllllllllllIIlIIlIIllIllIIllI = this.getFramebuffer(llllllllllllllIIlIIlIIllIllIlIII);
        final Framebuffer llllllllllllllIIlIIlIIllIllIIlIl = this.getFramebuffer(llllllllllllllIIlIIlIIllIllIIlll);
        if (llllllllllllllIIlIIlIIllIllIIllI == null) {
            throw new JsonException(String.valueOf(new StringBuilder("Input target '").append(llllllllllllllIIlIIlIIllIllIlIII).append("' does not exist")));
        }
        if (llllllllllllllIIlIIlIIllIllIIlIl == null) {
            throw new JsonException(String.valueOf(new StringBuilder("Output target '").append(llllllllllllllIIlIIlIIllIllIIlll).append("' does not exist")));
        }
        final Shader llllllllllllllIIlIIlIIllIllIIlII = this.addShader(llllllllllllllIIlIIlIIllIllIlIIl, llllllllllllllIIlIIlIIllIllIIllI, llllllllllllllIIlIIlIIllIllIIlIl);
        final JsonArray llllllllllllllIIlIIlIIllIllIIIll = JsonUtils.getJsonArray(llllllllllllllIIlIIlIIllIllIlIlI, "auxtargets", null);
        if (llllllllllllllIIlIIlIIllIllIIIll != null) {
            int llllllllllllllIIlIIlIIllIllIIIlI = 0;
            for (final JsonElement llllllllllllllIIlIIlIIllIllIIIIl : llllllllllllllIIlIIlIIllIllIIIll) {
                try {
                    final JsonObject llllllllllllllIIlIIlIIllIllIIIII = JsonUtils.getJsonObject(llllllllllllllIIlIIlIIllIllIIIIl, "auxtarget");
                    final String llllllllllllllIIlIIlIIllIlIlllll = JsonUtils.getString(llllllllllllllIIlIIlIIllIllIIIII, "name");
                    final String llllllllllllllIIlIIlIIllIlIllllI = JsonUtils.getString(llllllllllllllIIlIIlIIllIllIIIII, "id");
                    final Framebuffer llllllllllllllIIlIIlIIllIlIlllIl = this.getFramebuffer(llllllllllllllIIlIIlIIllIlIllllI);
                    if (llllllllllllllIIlIIlIIllIlIlllIl == null) {
                        final ResourceLocation llllllllllllllIIlIIlIIllIlIlllII = new ResourceLocation(String.valueOf(new StringBuilder("textures/effect/").append(llllllllllllllIIlIIlIIllIlIllllI).append(".png")));
                        IResource llllllllllllllIIlIIlIIllIlIllIll = null;
                        try {
                            llllllllllllllIIlIIlIIllIlIllIll = this.resourceManager.getResource(llllllllllllllIIlIIlIIllIlIlllII);
                        }
                        catch (FileNotFoundException llllllllllllllIIlIIlIIllIlIllIlI) {
                            throw new JsonException(String.valueOf(new StringBuilder("Render target or texture '").append(llllllllllllllIIlIIlIIllIlIllllI).append("' does not exist")));
                        }
                        finally {
                            IOUtils.closeQuietly((Closeable)llllllllllllllIIlIIlIIllIlIllIll);
                        }
                        IOUtils.closeQuietly((Closeable)llllllllllllllIIlIIlIIllIlIllIll);
                        llllllllllllllIIlIIlIIllIllIllII.bindTexture(llllllllllllllIIlIIlIIllIlIlllII);
                        final ITextureObject llllllllllllllIIlIIlIIllIlIllIIl = llllllllllllllIIlIIlIIllIllIllII.getTexture(llllllllllllllIIlIIlIIllIlIlllII);
                        final int llllllllllllllIIlIIlIIllIlIllIII = JsonUtils.getInt(llllllllllllllIIlIIlIIllIllIIIII, "width");
                        final int llllllllllllllIIlIIlIIllIlIlIlll = JsonUtils.getInt(llllllllllllllIIlIIlIIllIllIIIII, "height");
                        final boolean llllllllllllllIIlIIlIIllIlIlIllI = JsonUtils.getBoolean(llllllllllllllIIlIIlIIllIllIIIII, "bilinear");
                        if (llllllllllllllIIlIIlIIllIlIlIllI) {
                            GlStateManager.glTexParameteri(3553, 10241, 9729);
                            GlStateManager.glTexParameteri(3553, 10240, 9729);
                        }
                        else {
                            GlStateManager.glTexParameteri(3553, 10241, 9728);
                            GlStateManager.glTexParameteri(3553, 10240, 9728);
                        }
                        llllllllllllllIIlIIlIIllIllIIlII.addAuxFramebuffer(llllllllllllllIIlIIlIIllIlIlllll, llllllllllllllIIlIIlIIllIlIllIIl.getGlTextureId(), llllllllllllllIIlIIlIIllIlIllIII, llllllllllllllIIlIIlIIllIlIlIlll);
                    }
                    else {
                        llllllllllllllIIlIIlIIllIllIIlII.addAuxFramebuffer(llllllllllllllIIlIIlIIllIlIlllll, llllllllllllllIIlIIlIIllIlIlllIl, llllllllllllllIIlIIlIIllIlIlllIl.framebufferTextureWidth, llllllllllllllIIlIIlIIllIlIlllIl.framebufferTextureHeight);
                    }
                }
                catch (Exception llllllllllllllIIlIIlIIllIlIlIlIl) {
                    final JsonException llllllllllllllIIlIIlIIllIlIlIlII = JsonException.forException(llllllllllllllIIlIIlIIllIlIlIlIl);
                    llllllllllllllIIlIIlIIllIlIlIlII.prependJsonKey(String.valueOf(new StringBuilder("auxtargets[").append(llllllllllllllIIlIIlIIllIllIIIlI).append("]")));
                    throw llllllllllllllIIlIIlIIllIlIlIlII;
                }
                ++llllllllllllllIIlIIlIIllIllIIIlI;
            }
        }
        final JsonArray llllllllllllllIIlIIlIIllIlIlIIll = JsonUtils.getJsonArray(llllllllllllllIIlIIlIIllIllIlIlI, "uniforms", null);
        if (llllllllllllllIIlIIlIIllIlIlIIll != null) {
            int llllllllllllllIIlIIlIIllIlIlIIlI = 0;
            for (final JsonElement llllllllllllllIIlIIlIIllIlIlIIIl : llllllllllllllIIlIIlIIllIlIlIIll) {
                try {
                    this.initUniform(llllllllllllllIIlIIlIIllIlIlIIIl);
                }
                catch (Exception llllllllllllllIIlIIlIIllIlIlIIII) {
                    final JsonException llllllllllllllIIlIIlIIllIlIIllll = JsonException.forException(llllllllllllllIIlIIlIIllIlIlIIII);
                    llllllllllllllIIlIIlIIllIlIIllll.prependJsonKey(String.valueOf(new StringBuilder("uniforms[").append(llllllllllllllIIlIIlIIllIlIlIIlI).append("]")));
                    throw llllllllllllllIIlIIlIIllIlIIllll;
                }
                ++llllllllllllllIIlIIlIIllIlIlIIlI;
            }
        }
    }
    
    public void addFramebuffer(final String llllllllllllllIIlIIlIIllIIIIlIlI, final int llllllllllllllIIlIIlIIllIIIIIlII, final int llllllllllllllIIlIIlIIllIIIIIIll) {
        final Framebuffer llllllllllllllIIlIIlIIllIIIIIlll = new Framebuffer(llllllllllllllIIlIIlIIllIIIIIlII, llllllllllllllIIlIIlIIllIIIIIIll, true);
        llllllllllllllIIlIIlIIllIIIIIlll.setFramebufferColor(0.0f, 0.0f, 0.0f, 0.0f);
        this.mapFramebuffers.put(llllllllllllllIIlIIlIIllIIIIlIlI, llllllllllllllIIlIIlIIllIIIIIlll);
        if (llllllllllllllIIlIIlIIllIIIIIlII == this.mainFramebufferWidth && llllllllllllllIIlIIlIIllIIIIIIll == this.mainFramebufferHeight) {
            this.listFramebuffers.add(llllllllllllllIIlIIlIIllIIIIIlll);
        }
    }
    
    public void parseGroup(final TextureManager llllllllllllllIIlIIlIIllllIlIlIl, final ResourceLocation llllllllllllllIIlIIlIIllllIlIIlI) throws JsonException, JsonSyntaxException, IOException {
        final JsonParser llllllllllllllIIlIIlIIllllIlIIII = new JsonParser();
        IResource llllllllllllllIIlIIlIIllllIIllll = null;
        try {
            llllllllllllllIIlIIlIIllllIIllll = this.resourceManager.getResource(llllllllllllllIIlIIlIIllllIlIIlI);
            final JsonObject llllllllllllllIIlIIlIIllllIIllIl = llllllllllllllIIlIIlIIllllIlIIII.parse(IOUtils.toString(llllllllllllllIIlIIlIIllllIIllll.getInputStream(), StandardCharsets.UTF_8)).getAsJsonObject();
            if (JsonUtils.isJsonArray(llllllllllllllIIlIIlIIllllIIllIl, "targets")) {
                final JsonArray llllllllllllllIIlIIlIIllllIIlIll = llllllllllllllIIlIIlIIllllIIllIl.getAsJsonArray("targets");
                int llllllllllllllIIlIIlIIllllIIlIIl = 0;
                for (final JsonElement llllllllllllllIIlIIlIIllllIIIlll : llllllllllllllIIlIIlIIllllIIlIll) {
                    try {
                        this.initTarget(llllllllllllllIIlIIlIIllllIIIlll);
                    }
                    catch (Exception llllllllllllllIIlIIlIIllllIIIllI) {
                        final JsonException llllllllllllllIIlIIlIIllllIIIlII = JsonException.forException(llllllllllllllIIlIIlIIllllIIIllI);
                        llllllllllllllIIlIIlIIllllIIIlII.prependJsonKey(String.valueOf(new StringBuilder("targets[").append(llllllllllllllIIlIIlIIllllIIlIIl).append("]")));
                        throw llllllllllllllIIlIIlIIllllIIIlII;
                    }
                    ++llllllllllllllIIlIIlIIllllIIlIIl;
                }
            }
            if (JsonUtils.isJsonArray(llllllllllllllIIlIIlIIllllIIllIl, "passes")) {
                final JsonArray llllllllllllllIIlIIlIIllllIIIIlI = llllllllllllllIIlIIlIIllllIIllIl.getAsJsonArray("passes");
                int llllllllllllllIIlIIlIIlllIllllll = 0;
                for (final JsonElement llllllllllllllIIlIIlIIlllIlllllI : llllllllllllllIIlIIlIIllllIIIIlI) {
                    try {
                        this.parsePass(llllllllllllllIIlIIlIIllllIlIlIl, llllllllllllllIIlIIlIIlllIlllllI);
                    }
                    catch (Exception llllllllllllllIIlIIlIIlllIllllIl) {
                        final JsonException llllllllllllllIIlIIlIIlllIllllII = JsonException.forException(llllllllllllllIIlIIlIIlllIllllIl);
                        llllllllllllllIIlIIlIIlllIllllII.prependJsonKey(String.valueOf(new StringBuilder("passes[").append(llllllllllllllIIlIIlIIlllIllllll).append("]")));
                        throw llllllllllllllIIlIIlIIlllIllllII;
                    }
                    ++llllllllllllllIIlIIlIIlllIllllll;
                }
            }
        }
        catch (Exception llllllllllllllIIlIIlIIlllIlllIlI) {
            final JsonException llllllllllllllIIlIIlIIlllIlllIII = JsonException.forException(llllllllllllllIIlIIlIIlllIlllIlI);
            llllllllllllllIIlIIlIIlllIlllIII.setFilenameAndFlush(llllllllllllllIIlIIlIIllllIlIIlI.getResourcePath());
            throw llllllllllllllIIlIIlIIlllIlllIII;
        }
        finally {
            IOUtils.closeQuietly((Closeable)llllllllllllllIIlIIlIIllllIIllll);
        }
        IOUtils.closeQuietly((Closeable)llllllllllllllIIlIIlIIllllIIllll);
    }
}
