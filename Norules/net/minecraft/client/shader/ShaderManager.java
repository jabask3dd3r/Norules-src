package net.minecraft.client.shader;

import com.google.common.collect.*;
import java.nio.charset.*;
import org.apache.commons.io.*;
import net.minecraft.util.*;
import net.minecraft.client.util.*;
import com.google.gson.*;
import net.minecraft.client.resources.*;
import java.util.*;
import java.io.*;
import org.apache.logging.log4j.*;
import javax.annotation.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.*;

public class ShaderManager
{
    private final /* synthetic */ List<Integer> shaderSamplerLocations;
    private final /* synthetic */ boolean useFaceCulling;
    private static /* synthetic */ ShaderManager staticShaderManager;
    private final /* synthetic */ ShaderLoader fragmentShaderLoader;
    private final /* synthetic */ JsonBlendingMode blendingMode;
    private final /* synthetic */ List<String> attributes;
    private final /* synthetic */ List<String> samplerNames;
    private final /* synthetic */ List<Integer> shaderUniformLocations;
    private static /* synthetic */ boolean lastCull;
    private final /* synthetic */ ShaderLoader vertexShaderLoader;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ List<Integer> attribLocations;
    private final /* synthetic */ String programFilename;
    private final /* synthetic */ List<ShaderUniform> shaderUniforms;
    private final /* synthetic */ int program;
    private /* synthetic */ boolean isDirty;
    private final /* synthetic */ Map<String, Object> shaderSamplers;
    private static /* synthetic */ int currentProgram;
    private static final /* synthetic */ ShaderDefault DEFAULT_SHADER_UNIFORM;
    private final /* synthetic */ Map<String, ShaderUniform> mappedShaderUniforms;
    
    public ShaderManager(final IResourceManager lllllllllllllIlIIIlIIIIIllIlIIII, final String lllllllllllllIlIIIlIIIIIlllIlIll) throws IOException, JsonException {
        this.shaderSamplers = (Map<String, Object>)Maps.newHashMap();
        this.samplerNames = (List<String>)Lists.newArrayList();
        this.shaderSamplerLocations = (List<Integer>)Lists.newArrayList();
        this.shaderUniforms = (List<ShaderUniform>)Lists.newArrayList();
        this.shaderUniformLocations = (List<Integer>)Lists.newArrayList();
        this.mappedShaderUniforms = (Map<String, ShaderUniform>)Maps.newHashMap();
        final JsonParser lllllllllllllIlIIIlIIIIIlllIlIlI = new JsonParser();
        final ResourceLocation lllllllllllllIlIIIlIIIIIlllIlIIl = new ResourceLocation(String.valueOf(new StringBuilder("shaders/program/").append(lllllllllllllIlIIIlIIIIIlllIlIll).append(".json")));
        this.programFilename = lllllllllllllIlIIIlIIIIIlllIlIll;
        IResource lllllllllllllIlIIIlIIIIIlllIlIII = null;
        try {
            lllllllllllllIlIIIlIIIIIlllIlIII = lllllllllllllIlIIIlIIIIIllIlIIII.getResource(lllllllllllllIlIIIlIIIIIlllIlIIl);
            final JsonObject lllllllllllllIlIIIlIIIIIlllIIlll = lllllllllllllIlIIIlIIIIIlllIlIlI.parse(IOUtils.toString(lllllllllllllIlIIIlIIIIIlllIlIII.getInputStream(), StandardCharsets.UTF_8)).getAsJsonObject();
            final String lllllllllllllIlIIIlIIIIIlllIIllI = JsonUtils.getString(lllllllllllllIlIIIlIIIIIlllIIlll, "vertex");
            final String lllllllllllllIlIIIlIIIIIlllIIlIl = JsonUtils.getString(lllllllllllllIlIIIlIIIIIlllIIlll, "fragment");
            final JsonArray lllllllllllllIlIIIlIIIIIlllIIlII = JsonUtils.getJsonArray(lllllllllllllIlIIIlIIIIIlllIIlll, "samplers", null);
            if (lllllllllllllIlIIIlIIIIIlllIIlII != null) {
                int lllllllllllllIlIIIlIIIIIlllIIIll = 0;
                for (final JsonElement lllllllllllllIlIIIlIIIIIlllIIIlI : lllllllllllllIlIIIlIIIIIlllIIlII) {
                    try {
                        this.parseSampler(lllllllllllllIlIIIlIIIIIlllIIIlI);
                    }
                    catch (Exception lllllllllllllIlIIIlIIIIIlllIIIIl) {
                        final JsonException lllllllllllllIlIIIlIIIIIlllIIIII = JsonException.forException(lllllllllllllIlIIIlIIIIIlllIIIIl);
                        lllllllllllllIlIIIlIIIIIlllIIIII.prependJsonKey(String.valueOf(new StringBuilder("samplers[").append(lllllllllllllIlIIIlIIIIIlllIIIll).append("]")));
                        throw lllllllllllllIlIIIlIIIIIlllIIIII;
                    }
                    ++lllllllllllllIlIIIlIIIIIlllIIIll;
                }
            }
            final JsonArray lllllllllllllIlIIIlIIIIIllIlllll = JsonUtils.getJsonArray(lllllllllllllIlIIIlIIIIIlllIIlll, "attributes", null);
            if (lllllllllllllIlIIIlIIIIIllIlllll != null) {
                int lllllllllllllIlIIIlIIIIIllIllllI = 0;
                this.attribLocations = (List<Integer>)Lists.newArrayListWithCapacity(lllllllllllllIlIIIlIIIIIllIlllll.size());
                this.attributes = (List<String>)Lists.newArrayListWithCapacity(lllllllllllllIlIIIlIIIIIllIlllll.size());
                for (final JsonElement lllllllllllllIlIIIlIIIIIllIlllIl : lllllllllllllIlIIIlIIIIIllIlllll) {
                    try {
                        this.attributes.add(JsonUtils.getString(lllllllllllllIlIIIlIIIIIllIlllIl, "attribute"));
                    }
                    catch (Exception lllllllllllllIlIIIlIIIIIllIlllII) {
                        final JsonException lllllllllllllIlIIIlIIIIIllIllIll = JsonException.forException(lllllllllllllIlIIIlIIIIIllIlllII);
                        lllllllllllllIlIIIlIIIIIllIllIll.prependJsonKey(String.valueOf(new StringBuilder("attributes[").append(lllllllllllllIlIIIlIIIIIllIllllI).append("]")));
                        throw lllllllllllllIlIIIlIIIIIllIllIll;
                    }
                    ++lllllllllllllIlIIIlIIIIIllIllllI;
                }
            }
            else {
                this.attribLocations = null;
                this.attributes = null;
            }
            final JsonArray lllllllllllllIlIIIlIIIIIllIllIlI = JsonUtils.getJsonArray(lllllllllllllIlIIIlIIIIIlllIIlll, "uniforms", null);
            if (lllllllllllllIlIIIlIIIIIllIllIlI != null) {
                int lllllllllllllIlIIIlIIIIIllIllIIl = 0;
                for (final JsonElement lllllllllllllIlIIIlIIIIIllIllIII : lllllllllllllIlIIIlIIIIIllIllIlI) {
                    try {
                        this.parseUniform(lllllllllllllIlIIIlIIIIIllIllIII);
                    }
                    catch (Exception lllllllllllllIlIIIlIIIIIllIlIlll) {
                        final JsonException lllllllllllllIlIIIlIIIIIllIlIllI = JsonException.forException(lllllllllllllIlIIIlIIIIIllIlIlll);
                        lllllllllllllIlIIIlIIIIIllIlIllI.prependJsonKey(String.valueOf(new StringBuilder("uniforms[").append(lllllllllllllIlIIIlIIIIIllIllIIl).append("]")));
                        throw lllllllllllllIlIIIlIIIIIllIlIllI;
                    }
                    ++lllllllllllllIlIIIlIIIIIllIllIIl;
                }
            }
            this.blendingMode = JsonBlendingMode.parseBlendNode(JsonUtils.getJsonObject(lllllllllllllIlIIIlIIIIIlllIIlll, "blend", null));
            this.useFaceCulling = JsonUtils.getBoolean(lllllllllllllIlIIIlIIIIIlllIIlll, "cull", true);
            this.vertexShaderLoader = ShaderLoader.loadShader(lllllllllllllIlIIIlIIIIIllIlIIII, ShaderLoader.ShaderType.VERTEX, lllllllllllllIlIIIlIIIIIlllIIllI);
            this.fragmentShaderLoader = ShaderLoader.loadShader(lllllllllllllIlIIIlIIIIIllIlIIII, ShaderLoader.ShaderType.FRAGMENT, lllllllllllllIlIIIlIIIIIlllIIlIl);
            this.program = ShaderLinkHelper.getStaticShaderLinkHelper().createProgram();
            ShaderLinkHelper.getStaticShaderLinkHelper().linkProgram(this);
            this.setupUniforms();
            if (this.attributes != null) {
                for (final String lllllllllllllIlIIIlIIIIIllIlIlIl : this.attributes) {
                    final int lllllllllllllIlIIIlIIIIIllIlIlII = OpenGlHelper.glGetAttribLocation(this.program, lllllllllllllIlIIIlIIIIIllIlIlIl);
                    this.attribLocations.add(lllllllllllllIlIIIlIIIIIllIlIlII);
                }
            }
        }
        catch (Exception lllllllllllllIlIIIlIIIIIllIlIIll) {
            final JsonException lllllllllllllIlIIIlIIIIIllIlIIlI = JsonException.forException(lllllllllllllIlIIIlIIIIIllIlIIll);
            lllllllllllllIlIIIlIIIIIllIlIIlI.setFilenameAndFlush(lllllllllllllIlIIIlIIIIIlllIlIIl.getResourcePath());
            throw lllllllllllllIlIIIlIIIIIllIlIIlI;
        }
        finally {
            IOUtils.closeQuietly((Closeable)lllllllllllllIlIIIlIIIIIlllIlIII);
        }
        IOUtils.closeQuietly((Closeable)lllllllllllllIlIIIlIIIIIlllIlIII);
        this.markDirty();
    }
    
    public ShaderLoader getVertexShaderLoader() {
        return this.vertexShaderLoader;
    }
    
    public ShaderLoader getFragmentShaderLoader() {
        return this.fragmentShaderLoader;
    }
    
    private void setupUniforms() {
        for (int lllllllllllllIlIIIlIIIIIlIIlIIII = 0, lllllllllllllIlIIIlIIIIIlIIIllll = 0; lllllllllllllIlIIIlIIIIIlIIlIIII < this.samplerNames.size(); ++lllllllllllllIlIIIlIIIIIlIIlIIII, ++lllllllllllllIlIIIlIIIIIlIIIllll) {
            final String lllllllllllllIlIIIlIIIIIlIIIlllI = this.samplerNames.get(lllllllllllllIlIIIlIIIIIlIIlIIII);
            final int lllllllllllllIlIIIlIIIIIlIIIllIl = OpenGlHelper.glGetUniformLocation(this.program, lllllllllllllIlIIIlIIIIIlIIIlllI);
            if (lllllllllllllIlIIIlIIIIIlIIIllIl == -1) {
                ShaderManager.LOGGER.warn("Shader {}could not find sampler named {} in the specified shader program.", (Object)this.programFilename, (Object)lllllllllllllIlIIIlIIIIIlIIIlllI);
                this.shaderSamplers.remove(lllllllllllllIlIIIlIIIIIlIIIlllI);
                this.samplerNames.remove(lllllllllllllIlIIIlIIIIIlIIIllll);
                --lllllllllllllIlIIIlIIIIIlIIIllll;
            }
            else {
                this.shaderSamplerLocations.add(lllllllllllllIlIIIlIIIIIlIIIllIl);
            }
        }
        for (final ShaderUniform lllllllllllllIlIIIlIIIIIlIIIllII : this.shaderUniforms) {
            final String lllllllllllllIlIIIlIIIIIlIIIlIll = lllllllllllllIlIIIlIIIIIlIIIllII.getShaderName();
            final int lllllllllllllIlIIIlIIIIIlIIIlIlI = OpenGlHelper.glGetUniformLocation(this.program, lllllllllllllIlIIIlIIIIIlIIIlIll);
            if (lllllllllllllIlIIIlIIIIIlIIIlIlI == -1) {
                ShaderManager.LOGGER.warn("Could not find uniform named {} in the specified shader program.", (Object)lllllllllllllIlIIIlIIIIIlIIIlIll);
            }
            else {
                this.shaderUniformLocations.add(lllllllllllllIlIIIlIIIIIlIIIlIlI);
                lllllllllllllIlIIIlIIIIIlIIIllII.setUniformLocation(lllllllllllllIlIIIlIIIIIlIIIlIlI);
                this.mappedShaderUniforms.put(lllllllllllllIlIIIlIIIIIlIIIlIll, lllllllllllllIlIIIlIIIIIlIIIllII);
            }
        }
    }
    
    public void markDirty() {
        this.isDirty = true;
    }
    
    public ShaderUniform getShaderUniformOrDefault(final String lllllllllllllIlIIIlIIIIIlIIllIIl) {
        final ShaderUniform lllllllllllllIlIIIlIIIIIlIIllIll = this.getShaderUniform(lllllllllllllIlIIIlIIIIIlIIllIIl);
        return (lllllllllllllIlIIIlIIIIIlIIllIll == null) ? ShaderManager.DEFAULT_SHADER_UNIFORM : lllllllllllllIlIIIlIIIIIlIIllIll;
    }
    
    public int getProgram() {
        return this.program;
    }
    
    public void addSamplerTexture(final String lllllllllllllIlIIIlIIIIIIlllIIll, final Object lllllllllllllIlIIIlIIIIIIllIllll) {
        if (this.shaderSamplers.containsKey(lllllllllllllIlIIIlIIIIIIlllIIll)) {
            this.shaderSamplers.remove(lllllllllllllIlIIIlIIIIIIlllIIll);
        }
        this.shaderSamplers.put(lllllllllllllIlIIIlIIIIIIlllIIll, lllllllllllllIlIIIlIIIIIIllIllll);
        this.markDirty();
    }
    
    private void parseUniform(final JsonElement lllllllllllllIlIIIlIIIIIIllIIIII) throws JsonException {
        final JsonObject lllllllllllllIlIIIlIIIIIIlIlllll = JsonUtils.getJsonObject(lllllllllllllIlIIIlIIIIIIllIIIII, "uniform");
        final String lllllllllllllIlIIIlIIIIIIlIllllI = JsonUtils.getString(lllllllllllllIlIIIlIIIIIIlIlllll, "name");
        final int lllllllllllllIlIIIlIIIIIIlIlllIl = ShaderUniform.parseType(JsonUtils.getString(lllllllllllllIlIIIlIIIIIIlIlllll, "type"));
        final int lllllllllllllIlIIIlIIIIIIlIlllII = JsonUtils.getInt(lllllllllllllIlIIIlIIIIIIlIlllll, "count");
        final float[] lllllllllllllIlIIIlIIIIIIlIllIll = new float[Math.max(lllllllllllllIlIIIlIIIIIIlIlllII, 16)];
        final JsonArray lllllllllllllIlIIIlIIIIIIlIllIlI = JsonUtils.getJsonArray(lllllllllllllIlIIIlIIIIIIlIlllll, "values");
        if (lllllllllllllIlIIIlIIIIIIlIllIlI.size() != lllllllllllllIlIIIlIIIIIIlIlllII && lllllllllllllIlIIIlIIIIIIlIllIlI.size() > 1) {
            throw new JsonException(String.valueOf(new StringBuilder("Invalid amount of values specified (expected ").append(lllllllllllllIlIIIlIIIIIIlIlllII).append(", found ").append(lllllllllllllIlIIIlIIIIIIlIllIlI.size()).append(")")));
        }
        int lllllllllllllIlIIIlIIIIIIlIllIIl = 0;
        for (final JsonElement lllllllllllllIlIIIlIIIIIIlIllIII : lllllllllllllIlIIIlIIIIIIlIllIlI) {
            try {
                lllllllllllllIlIIIlIIIIIIlIllIll[lllllllllllllIlIIIlIIIIIIlIllIIl] = JsonUtils.getFloat(lllllllllllllIlIIIlIIIIIIlIllIII, "value");
            }
            catch (Exception lllllllllllllIlIIIlIIIIIIlIlIlll) {
                final JsonException lllllllllllllIlIIIlIIIIIIlIlIllI = JsonException.forException(lllllllllllllIlIIIlIIIIIIlIlIlll);
                lllllllllllllIlIIIlIIIIIIlIlIllI.prependJsonKey(String.valueOf(new StringBuilder("values[").append(lllllllllllllIlIIIlIIIIIIlIllIIl).append("]")));
                throw lllllllllllllIlIIIlIIIIIIlIlIllI;
            }
            ++lllllllllllllIlIIIlIIIIIIlIllIIl;
        }
        if (lllllllllllllIlIIIlIIIIIIlIlllII > 1 && lllllllllllllIlIIIlIIIIIIlIllIlI.size() == 1) {
            while (lllllllllllllIlIIIlIIIIIIlIllIIl < lllllllllllllIlIIIlIIIIIIlIlllII) {
                lllllllllllllIlIIIlIIIIIIlIllIll[lllllllllllllIlIIIlIIIIIIlIllIIl] = lllllllllllllIlIIIlIIIIIIlIllIll[0];
                ++lllllllllllllIlIIIlIIIIIIlIllIIl;
            }
        }
        final int lllllllllllllIlIIIlIIIIIIlIlIlIl = (lllllllllllllIlIIIlIIIIIIlIlllII > 1 && lllllllllllllIlIIIlIIIIIIlIlllII <= 4 && lllllllllllllIlIIIlIIIIIIlIlllIl < 8) ? (lllllllllllllIlIIIlIIIIIIlIlllII - 1) : 0;
        final ShaderUniform lllllllllllllIlIIIlIIIIIIlIlIlII = new ShaderUniform(lllllllllllllIlIIIlIIIIIIlIllllI, lllllllllllllIlIIIlIIIIIIlIlllIl + lllllllllllllIlIIIlIIIIIIlIlIlIl, lllllllllllllIlIIIlIIIIIIlIlllII, this);
        if (lllllllllllllIlIIIlIIIIIIlIlllIl <= 3) {
            lllllllllllllIlIIIlIIIIIIlIlIlII.set((int)lllllllllllllIlIIIlIIIIIIlIllIll[0], (int)lllllllllllllIlIIIlIIIIIIlIllIll[1], (int)lllllllllllllIlIIIlIIIIIIlIllIll[2], (int)lllllllllllllIlIIIlIIIIIIlIllIll[3]);
        }
        else if (lllllllllllllIlIIIlIIIIIIlIlllIl <= 7) {
            lllllllllllllIlIIIlIIIIIIlIlIlII.setSafe(lllllllllllllIlIIIlIIIIIIlIllIll[0], lllllllllllllIlIIIlIIIIIIlIllIll[1], lllllllllllllIlIIIlIIIIIIlIllIll[2], lllllllllllllIlIIIlIIIIIIlIllIll[3]);
        }
        else {
            lllllllllllllIlIIIlIIIIIIlIlIlII.set(lllllllllllllIlIIIlIIIIIIlIllIll);
        }
        this.shaderUniforms.add(lllllllllllllIlIIIlIIIIIIlIlIlII);
    }
    
    static {
        LOGGER = LogManager.getLogger();
        DEFAULT_SHADER_UNIFORM = new ShaderDefault();
        ShaderManager.currentProgram = -1;
        ShaderManager.lastCull = true;
    }
    
    public void deleteShader() {
        ShaderLinkHelper.getStaticShaderLinkHelper().deleteShader(this);
    }
    
    @Nullable
    public ShaderUniform getShaderUniform(final String lllllllllllllIlIIIlIIIIIlIlIIIll) {
        return this.mappedShaderUniforms.get(lllllllllllllIlIIIlIIIIIlIlIIIll);
    }
    
    public void useShader() {
        this.isDirty = false;
        ShaderManager.staticShaderManager = this;
        this.blendingMode.apply();
        if (this.program != ShaderManager.currentProgram) {
            OpenGlHelper.glUseProgram(this.program);
            ShaderManager.currentProgram = this.program;
        }
        if (this.useFaceCulling) {
            GlStateManager.enableCull();
        }
        else {
            GlStateManager.disableCull();
        }
        for (int lllllllllllllIlIIIlIIIIIlIllIIIl = 0; lllllllllllllIlIIIlIIIIIlIllIIIl < this.shaderSamplerLocations.size(); ++lllllllllllllIlIIIlIIIIIlIllIIIl) {
            if (this.shaderSamplers.get(this.samplerNames.get(lllllllllllllIlIIIlIIIIIlIllIIIl)) != null) {
                GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit + lllllllllllllIlIIIlIIIIIlIllIIIl);
                GlStateManager.enableTexture2D();
                final Object lllllllllllllIlIIIlIIIIIlIllIIII = this.shaderSamplers.get(this.samplerNames.get(lllllllllllllIlIIIlIIIIIlIllIIIl));
                int lllllllllllllIlIIIlIIIIIlIlIllll = -1;
                if (lllllllllllllIlIIIlIIIIIlIllIIII instanceof Framebuffer) {
                    lllllllllllllIlIIIlIIIIIlIlIllll = ((Framebuffer)lllllllllllllIlIIIlIIIIIlIllIIII).framebufferTexture;
                }
                else if (lllllllllllllIlIIIlIIIIIlIllIIII instanceof ITextureObject) {
                    lllllllllllllIlIIIlIIIIIlIlIllll = ((ITextureObject)lllllllllllllIlIIIlIIIIIlIllIIII).getGlTextureId();
                }
                else if (lllllllllllllIlIIIlIIIIIlIllIIII instanceof Integer) {
                    lllllllllllllIlIIIlIIIIIlIlIllll = (int)lllllllllllllIlIIIlIIIIIlIllIIII;
                }
                if (lllllllllllllIlIIIlIIIIIlIlIllll != -1) {
                    GlStateManager.bindTexture(lllllllllllllIlIIIlIIIIIlIlIllll);
                    OpenGlHelper.glUniform1i(OpenGlHelper.glGetUniformLocation(this.program, this.samplerNames.get(lllllllllllllIlIIIlIIIIIlIllIIIl)), lllllllllllllIlIIIlIIIIIlIllIIIl);
                }
            }
        }
        for (final ShaderUniform lllllllllllllIlIIIlIIIIIlIlIlllI : this.shaderUniforms) {
            lllllllllllllIlIIIlIIIIIlIlIlllI.upload();
        }
    }
    
    public void endShader() {
        OpenGlHelper.glUseProgram(0);
        ShaderManager.currentProgram = -1;
        ShaderManager.staticShaderManager = null;
        ShaderManager.lastCull = true;
        for (int lllllllllllllIlIIIlIIIIIlIlllIIl = 0; lllllllllllllIlIIIlIIIIIlIlllIIl < this.shaderSamplerLocations.size(); ++lllllllllllllIlIIIlIIIIIlIlllIIl) {
            if (this.shaderSamplers.get(this.samplerNames.get(lllllllllllllIlIIIlIIIIIlIlllIIl)) != null) {
                GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit + lllllllllllllIlIIIlIIIIIlIlllIIl);
                GlStateManager.bindTexture(0);
            }
        }
    }
    
    private void parseSampler(final JsonElement lllllllllllllIlIIIlIIIIIIllllllI) throws JsonException {
        final JsonObject lllllllllllllIlIIIlIIIIIIlllllIl = JsonUtils.getJsonObject(lllllllllllllIlIIIlIIIIIIllllllI, "sampler");
        final String lllllllllllllIlIIIlIIIIIIlllllII = JsonUtils.getString(lllllllllllllIlIIIlIIIIIIlllllIl, "name");
        if (!JsonUtils.isString(lllllllllllllIlIIIlIIIIIIlllllIl, "file")) {
            this.shaderSamplers.put(lllllllllllllIlIIIlIIIIIIlllllII, null);
            this.samplerNames.add(lllllllllllllIlIIIlIIIIIIlllllII);
        }
        else {
            this.samplerNames.add(lllllllllllllIlIIIlIIIIIIlllllII);
        }
    }
}
