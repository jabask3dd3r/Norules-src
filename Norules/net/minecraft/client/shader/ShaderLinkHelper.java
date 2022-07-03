package net.minecraft.client.shader;

import net.minecraft.client.renderer.*;
import net.minecraft.client.util.*;
import java.io.*;
import org.apache.logging.log4j.*;

public class ShaderLinkHelper
{
    private static final /* synthetic */ Logger LOGGER;
    private static /* synthetic */ ShaderLinkHelper staticShaderLinkHelper;
    
    public static void setNewStaticShaderLinkHelper() {
        ShaderLinkHelper.staticShaderLinkHelper = new ShaderLinkHelper();
    }
    
    public int createProgram() throws JsonException {
        final int lllllllllllllIlIlIIlIIIlIlIlIlIl = OpenGlHelper.glCreateProgram();
        if (lllllllllllllIlIlIIlIIIlIlIlIlIl <= 0) {
            throw new JsonException(String.valueOf(new StringBuilder("Could not create shader program (returned program ID ").append(lllllllllllllIlIlIIlIIIlIlIlIlIl).append(")")));
        }
        return lllllllllllllIlIlIIlIIIlIlIlIlIl;
    }
    
    public void linkProgram(final ShaderManager lllllllllllllIlIlIIlIIIlIlIlIIII) throws IOException {
        lllllllllllllIlIlIIlIIIlIlIlIIII.getFragmentShaderLoader().attachShader(lllllllllllllIlIlIIlIIIlIlIlIIII);
        lllllllllllllIlIlIIlIIIlIlIlIIII.getVertexShaderLoader().attachShader(lllllllllllllIlIlIIlIIIlIlIlIIII);
        OpenGlHelper.glLinkProgram(lllllllllllllIlIlIIlIIIlIlIlIIII.getProgram());
        final int lllllllllllllIlIlIIlIIIlIlIIllll = OpenGlHelper.glGetProgrami(lllllllllllllIlIlIIlIIIlIlIlIIII.getProgram(), OpenGlHelper.GL_LINK_STATUS);
        if (lllllllllllllIlIlIIlIIIlIlIIllll == 0) {
            ShaderLinkHelper.LOGGER.warn("Error encountered when linking program containing VS {} and FS {}. Log output:", (Object)lllllllllllllIlIlIIlIIIlIlIlIIII.getVertexShaderLoader().getShaderFilename(), (Object)lllllllllllllIlIlIIlIIIlIlIlIIII.getFragmentShaderLoader().getShaderFilename());
            ShaderLinkHelper.LOGGER.warn(OpenGlHelper.glGetProgramInfoLog(lllllllllllllIlIlIIlIIIlIlIlIIII.getProgram(), 32768));
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public void deleteShader(final ShaderManager lllllllllllllIlIlIIlIIIlIlIllIIl) {
        lllllllllllllIlIlIIlIIIlIlIllIIl.getFragmentShaderLoader().deleteShader(lllllllllllllIlIlIIlIIIlIlIllIIl);
        lllllllllllllIlIlIIlIIIlIlIllIIl.getVertexShaderLoader().deleteShader(lllllllllllllIlIlIIlIIIlIlIllIIl);
        OpenGlHelper.glDeleteProgram(lllllllllllllIlIlIIlIIIlIlIllIIl.getProgram());
    }
    
    public static ShaderLinkHelper getStaticShaderLinkHelper() {
        return ShaderLinkHelper.staticShaderLinkHelper;
    }
}
