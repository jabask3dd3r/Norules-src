package me.nrules.utils.render;

import org.lwjgl.opengl.*;
import java.io.*;

public class GLSLSandboxShader
{
    private final /* synthetic */ int programId;
    private final /* synthetic */ int resolutionUniform;
    private final /* synthetic */ int timeUniform;
    private final /* synthetic */ int mouseUniform;
    
    private int createShader(final InputStream llIlIIlIlIIIIll, final int llIlIIlIlIIIIlI) throws IOException {
        final int llIlIIlIlIIIIIl = GL20.glCreateShader(llIlIIlIlIIIIlI);
        GL20.glShaderSource(llIlIIlIlIIIIIl, (CharSequence)this.readStreamToString(llIlIIlIlIIIIll));
        GL20.glCompileShader(llIlIIlIlIIIIIl);
        final int llIlIIlIlIIIIII = GL20.glGetShaderi(llIlIIlIlIIIIIl, 35713);
        if (llIlIIlIlIIIIII == 0) {
            System.err.println(GL20.glGetShaderInfoLog(llIlIIlIlIIIIIl, GL20.glGetShaderi(llIlIIlIlIIIIIl, 35716)));
            throw new IllegalStateException("Failed to compile shader");
        }
        return llIlIIlIlIIIIIl;
    }
    
    private String readStreamToString(final InputStream llIlIIlIIllIIII) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/io/ByteArrayOutputStream.<init>:()V
        //     7: astore_2        /* llIlIIlIIlIllll */
        //     8: sipush          512
        //    11: newarray        B
        //    13: astore_3        /* llIlIIlIIlIlllI */
        //    14: goto            25
        //    17: aload_2         /* llIlIIlIIllIlII */
        //    18: aload_3         /* llIlIIlIIllIIll */
        //    19: iconst_0       
        //    20: iload           llIlIIlIIllIIlI
        //    22: invokevirtual   java/io/ByteArrayOutputStream.write:([BII)V
        //    25: aload_1         /* llIlIIlIIllIlIl */
        //    26: aload_3         /* llIlIIlIIllIIll */
        //    27: iconst_0       
        //    28: aload_3         /* llIlIIlIIllIIll */
        //    29: arraylength    
        //    30: invokevirtual   java/io/InputStream.read:([BII)I
        //    33: dup            
        //    34: istore          llIlIIlIIllIIIl
        //    36: iconst_m1      
        //    37: if_icmpne       17
        //    40: new             Ljava/lang/String;
        //    43: dup            
        //    44: aload_2         /* llIlIIlIIllIlII */
        //    45: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //    48: getstatic       java/nio/charset/StandardCharsets.UTF_8:Ljava/nio/charset/Charset;
        //    51: invokespecial   java/lang/String.<init>:([BLjava/nio/charset/Charset;)V
        //    54: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 02 FE 00 11 07 00 4E 07 00 78 01 FA 00 07
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public GLSLSandboxShader(final String llIlIIlIllIIIlI) throws IOException {
        final int llIlIIlIllIIIIl = GL20.glCreateProgram();
        GL20.glAttachShader(llIlIIlIllIIIIl, this.createShader(GLSLSandboxShader.class.getResourceAsStream("/assets/minecraft/nrules/shaders/passthrough.vsh"), 35633));
        GL20.glAttachShader(llIlIIlIllIIIIl, this.createShader(GLSLSandboxShader.class.getResourceAsStream(llIlIIlIllIIIlI), 35632));
        GL20.glLinkProgram(llIlIIlIllIIIIl);
        final int llIlIIlIllIIIII = GL20.glGetProgrami(llIlIIlIllIIIIl, 35714);
        if (llIlIIlIllIIIII == 0) {
            System.err.println(GL20.glGetProgramInfoLog(llIlIIlIllIIIIl, GL20.glGetProgrami(llIlIIlIllIIIIl, 35716)));
            throw new IllegalStateException("Shader failed to link");
        }
        this.programId = llIlIIlIllIIIIl;
        GL20.glUseProgram(llIlIIlIllIIIIl);
        this.timeUniform = GL20.glGetUniformLocation(llIlIIlIllIIIIl, (CharSequence)"time");
        this.mouseUniform = GL20.glGetUniformLocation(llIlIIlIllIIIIl, (CharSequence)"mouse");
        this.resolutionUniform = GL20.glGetUniformLocation(llIlIIlIllIIIIl, (CharSequence)"resolution");
        GL20.glUseProgram(0);
    }
    
    public void useShader(final int llIlIIlIlIIlllI, final int llIlIIlIlIlIIll, final float llIlIIlIlIIllII, final float llIlIIlIlIlIIIl, final float llIlIIlIlIlIIII) {
        GL20.glUseProgram(this.programId);
        GL20.glUniform2f(this.resolutionUniform, (float)llIlIIlIlIIlllI, (float)llIlIIlIlIlIIll);
        GL20.glUniform2f(this.mouseUniform, llIlIIlIlIIllII / llIlIIlIlIIlllI, 1.0f - llIlIIlIlIlIIIl / llIlIIlIlIlIIll);
        GL20.glUniform1f(this.timeUniform, llIlIIlIlIlIIII);
    }
}
