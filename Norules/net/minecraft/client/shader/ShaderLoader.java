package net.minecraft.client.shader;

import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import org.apache.commons.io.*;
import org.lwjgl.*;
import org.apache.commons.lang3.*;
import net.minecraft.client.util.*;
import net.minecraft.client.resources.*;
import java.nio.*;
import java.io.*;
import java.util.*;
import com.google.common.collect.*;

public class ShaderLoader
{
    private final /* synthetic */ String shaderFilename;
    private final /* synthetic */ int shader;
    private /* synthetic */ int shaderAttachCount;
    private final /* synthetic */ ShaderType shaderType;
    
    public String getShaderFilename() {
        return this.shaderFilename;
    }
    
    private ShaderLoader(final ShaderType llllllllllllllIIIIIlIlIIlIIIllll, final int llllllllllllllIIIIIlIlIIlIIIlllI, final String llllllllllllllIIIIIlIlIIlIIlIIIl) {
        this.shaderType = llllllllllllllIIIIIlIlIIlIIIllll;
        this.shader = llllllllllllllIIIIIlIlIIlIIIlllI;
        this.shaderFilename = llllllllllllllIIIIIlIlIIlIIlIIIl;
    }
    
    public void attachShader(final ShaderManager llllllllllllllIIIIIlIlIIlIIIlIII) {
        ++this.shaderAttachCount;
        OpenGlHelper.glAttachShader(llllllllllllllIIIIIlIlIIlIIIlIII.getProgram(), this.shader);
    }
    
    public static ShaderLoader loadShader(final IResourceManager llllllllllllllIIIIIlIlIIIlllIIlI, final ShaderType llllllllllllllIIIIIlIlIIIllIIllI, final String llllllllllllllIIIIIlIlIIIlllIIII) throws IOException {
        ShaderLoader llllllllllllllIIIIIlIlIIIllIllll = llllllllllllllIIIIIlIlIIIllIIllI.getLoadedShaders().get(llllllllllllllIIIIIlIlIIIlllIIII);
        if (llllllllllllllIIIIIlIlIIIllIllll == null) {
            final ResourceLocation llllllllllllllIIIIIlIlIIIllIlllI = new ResourceLocation(String.valueOf(new StringBuilder("shaders/program/").append(llllllllllllllIIIIIlIlIIIlllIIII).append(llllllllllllllIIIIIlIlIIIllIIllI.getShaderExtension())));
            final IResource llllllllllllllIIIIIlIlIIIllIllIl = llllllllllllllIIIIIlIlIIIlllIIlI.getResource(llllllllllllllIIIIIlIlIIIllIlllI);
            try {
                final byte[] llllllllllllllIIIIIlIlIIIllIllII = IOUtils.toByteArray((InputStream)new BufferedInputStream(llllllllllllllIIIIIlIlIIIllIllIl.getInputStream()));
                final ByteBuffer llllllllllllllIIIIIlIlIIIllIlIll = BufferUtils.createByteBuffer(llllllllllllllIIIIIlIlIIIllIllII.length);
                llllllllllllllIIIIIlIlIIIllIlIll.put(llllllllllllllIIIIIlIlIIIllIllII);
                llllllllllllllIIIIIlIlIIIllIlIll.position(0);
                final int llllllllllllllIIIIIlIlIIIllIlIlI = OpenGlHelper.glCreateShader(llllllllllllllIIIIIlIlIIIllIIllI.getShaderMode());
                OpenGlHelper.glShaderSource(llllllllllllllIIIIIlIlIIIllIlIlI, llllllllllllllIIIIIlIlIIIllIlIll);
                OpenGlHelper.glCompileShader(llllllllllllllIIIIIlIlIIIllIlIlI);
                if (OpenGlHelper.glGetShaderi(llllllllllllllIIIIIlIlIIIllIlIlI, OpenGlHelper.GL_COMPILE_STATUS) == 0) {
                    final String llllllllllllllIIIIIlIlIIIllIlIIl = StringUtils.trim(OpenGlHelper.glGetShaderInfoLog(llllllllllllllIIIIIlIlIIIllIlIlI, 32768));
                    final JsonException llllllllllllllIIIIIlIlIIIllIlIII = new JsonException(String.valueOf(new StringBuilder("Couldn't compile ").append(llllllllllllllIIIIIlIlIIIllIIllI.getShaderName()).append(" program: ").append(llllllllllllllIIIIIlIlIIIllIlIIl)));
                    llllllllllllllIIIIIlIlIIIllIlIII.setFilenameAndFlush(llllllllllllllIIIIIlIlIIIllIlllI.getResourcePath());
                    throw llllllllllllllIIIIIlIlIIIllIlIII;
                }
                llllllllllllllIIIIIlIlIIIllIllll = new ShaderLoader(llllllllllllllIIIIIlIlIIIllIIllI, llllllllllllllIIIIIlIlIIIllIlIlI, llllllllllllllIIIIIlIlIIIlllIIII);
                llllllllllllllIIIIIlIlIIIllIIllI.getLoadedShaders().put(llllllllllllllIIIIIlIlIIIlllIIII, llllllllllllllIIIIIlIlIIIllIllll);
            }
            finally {
                IOUtils.closeQuietly((Closeable)llllllllllllllIIIIIlIlIIIllIllIl);
            }
            IOUtils.closeQuietly((Closeable)llllllllllllllIIIIIlIlIIIllIllIl);
        }
        return llllllllllllllIIIIIlIlIIIllIllll;
    }
    
    public void deleteShader(final ShaderManager llllllllllllllIIIIIlIlIIlIIIIIll) {
        --this.shaderAttachCount;
        if (this.shaderAttachCount <= 0) {
            OpenGlHelper.glDeleteShader(this.shader);
            this.shaderType.getLoadedShaders().remove(this.shaderFilename);
        }
    }
    
    public enum ShaderType
    {
        private final /* synthetic */ String shaderName;
        
        FRAGMENT("FRAGMENT", 1, "fragment", ".fsh", OpenGlHelper.GL_FRAGMENT_SHADER), 
        VERTEX("VERTEX", 0, "vertex", ".vsh", OpenGlHelper.GL_VERTEX_SHADER);
        
        private final /* synthetic */ int shaderMode;
        private final /* synthetic */ Map<String, ShaderLoader> loadedShaders;
        private final /* synthetic */ String shaderExtension;
        
        public String getShaderName() {
            return this.shaderName;
        }
        
        private Map<String, ShaderLoader> getLoadedShaders() {
            return this.loadedShaders;
        }
        
        private int getShaderMode() {
            return this.shaderMode;
        }
        
        private String getShaderExtension() {
            return this.shaderExtension;
        }
        
        private ShaderType(final String lllllllllllllllIIlIlllIlIlIllIll, final int lllllllllllllllIIlIlllIlIlIllIlI, final String lllllllllllllllIIlIlllIlIlIlllll, final String lllllllllllllllIIlIlllIlIlIllllI, final int lllllllllllllllIIlIlllIlIlIlIlll) {
            this.loadedShaders = (Map<String, ShaderLoader>)Maps.newHashMap();
            this.shaderName = lllllllllllllllIIlIlllIlIlIlllll;
            this.shaderExtension = lllllllllllllllIIlIlllIlIlIllllI;
            this.shaderMode = lllllllllllllllIIlIlllIlIlIlIlll;
        }
    }
}
