package shadersmod.client;

import net.minecraft.client.resources.*;
import net.minecraft.client.renderer.texture.*;
import org.apache.commons.io.*;
import java.awt.image.*;
import java.io.*;
import net.minecraft.client.resources.data.*;

public class SimpleShaderTexture extends AbstractTexture
{
    private /* synthetic */ String texturePath;
    
    @Override
    public void loadTexture(final IResourceManager lIIIIIIIlIIIIIl) throws IOException {
        this.deleteGlTexture();
        final InputStream lIIIIIIIlIIIIII = Shaders.getShaderPackResourceStream(this.texturePath);
        if (lIIIIIIIlIIIIII == null) {
            throw new FileNotFoundException(String.valueOf(new StringBuilder("Shader texture not found: ").append(this.texturePath)));
        }
        try {
            final BufferedImage lIIIIIIIIllllll = TextureUtil.readBufferedImage(lIIIIIIIlIIIIII);
            final TextureMetadataSection lIIIIIIIIlllllI = this.loadTextureMetadataSection();
            TextureUtil.uploadTextureImageAllocate(this.getGlTextureId(), lIIIIIIIIllllll, lIIIIIIIIlllllI.getTextureBlur(), lIIIIIIIIlllllI.getTextureClamp());
        }
        finally {
            IOUtils.closeQuietly(lIIIIIIIlIIIIII);
        }
        IOUtils.closeQuietly(lIIIIIIIlIIIIII);
    }
    
    private static MetadataSerializer makeMetadataSerializer() {
        final MetadataSerializer lIIIIIIIIIlIllI = new MetadataSerializer();
        lIIIIIIIIIlIllI.registerMetadataSectionType(new TextureMetadataSectionSerializer(), TextureMetadataSection.class);
        lIIIIIIIIIlIllI.registerMetadataSectionType(new FontMetadataSectionSerializer(), FontMetadataSection.class);
        lIIIIIIIIIlIllI.registerMetadataSectionType(new AnimationMetadataSectionSerializer(), AnimationMetadataSection.class);
        lIIIIIIIIIlIllI.registerMetadataSectionType(new PackMetadataSectionSerializer(), PackMetadataSection.class);
        lIIIIIIIIIlIllI.registerMetadataSectionType(new LanguageMetadataSectionSerializer(), LanguageMetadataSection.class);
        return lIIIIIIIIIlIllI;
    }
    
    public SimpleShaderTexture(final String lIIIIIIIlIIlIII) {
        this.texturePath = lIIIIIIIlIIlIII;
    }
    
    private TextureMetadataSection loadTextureMetadataSection() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: aload_0         /* lIIIIIIIIlIllIl */
        //     5: getfield        shadersmod/client/SimpleShaderTexture.texturePath:Ljava/lang/String;
        //     8: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    11: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    14: ldc             ".mcmeta"
        //    16: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    19: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    22: astore_1        /* lIIIIIIIIlIIIIl */
        //    23: ldc             "texture"
        //    25: astore_2        /* lIIIIIIIIlIIIII */
        //    26: aload_1         /* lIIIIIIIIlIllII */
        //    27: invokestatic    shadersmod/client/Shaders.getShaderPackResourceStream:(Ljava/lang/String;)Ljava/io/InputStream;
        //    30: astore_3        /* lIIIIIIIIlIlIlI */
        //    31: aload_3         /* lIIIIIIIIlIlIlI */
        //    32: ifnull          229
        //    35: getstatic       shadersmod/client/SimpleShaderTexture.METADATA_SERIALIZER:Lnet/minecraft/client/resources/data/MetadataSerializer;
        //    38: astore          lIIIIIIIIlIlIIl
        //    40: new             Ljava/io/BufferedReader;
        //    43: dup            
        //    44: new             Ljava/io/InputStreamReader;
        //    47: dup            
        //    48: aload_3         /* lIIIIIIIIlIlIlI */
        //    49: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //    52: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //    55: astore          lIIIIIIIIlIlIII
        //    57: new             Lcom/google/gson/JsonParser;
        //    60: dup            
        //    61: invokespecial   com/google/gson/JsonParser.<init>:()V
        //    64: aload           lIIIIIIIIlIlIII
        //    66: invokevirtual   com/google/gson/JsonParser.parse:(Ljava/io/Reader;)Lcom/google/gson/JsonElement;
        //    69: invokevirtual   com/google/gson/JsonElement.getAsJsonObject:()Lcom/google/gson/JsonObject;
        //    72: astore          lIIIIIIIIlIIlIl
        //    74: aload           lIIIIIIIIlIlIIl
        //    76: aload_2         /* lIIIIIIIIlIlIll */
        //    77: aload           lIIIIIIIIlIIlIl
        //    79: invokevirtual   net/minecraft/client/resources/data/MetadataSerializer.parseMetadataSection:(Ljava/lang/String;Lcom/google/gson/JsonObject;)Lnet/minecraft/client/resources/data/IMetadataSection;
        //    82: checkcast       Lnet/minecraft/client/resources/data/TextureMetadataSection;
        //    85: astore          lIIIIIIIIlIIlII
        //    87: aload           lIIIIIIIIlIIlII
        //    89: ifnonnull       115
        //    92: new             Lnet/minecraft/client/resources/data/TextureMetadataSection;
        //    95: dup            
        //    96: iconst_0       
        //    97: iconst_0       
        //    98: invokespecial   net/minecraft/client/resources/data/TextureMetadataSection.<init>:(ZZ)V
        //   101: astore          lIIIIIIIIIllIII
        //   103: aload           lIIIIIIIIlIlIII
        //   105: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Reader;)V
        //   108: aload_3         /* lIIIIIIIIlIlIlI */
        //   109: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //   112: aload           lIIIIIIIIIllIII
        //   114: areturn        
        //   115: aload           lIIIIIIIIlIIlII
        //   117: astore          lIIIIIIIIlIIlll
        //   119: goto            217
        //   122: astore          lIIIIIIIIlIIIll
        //   124: new             Ljava/lang/StringBuilder;
        //   127: dup            
        //   128: ldc             "Error reading metadata: "
        //   130: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   133: aload_1         /* lIIIIIIIIlIllII */
        //   134: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   137: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   140: invokestatic    shadersmod/common/SMCLog.warning:(Ljava/lang/String;)V
        //   143: new             Ljava/lang/StringBuilder;
        //   146: dup            
        //   147: invokespecial   java/lang/StringBuilder.<init>:()V
        //   150: aload           lIIIIIIIIlIIIll
        //   152: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //   155: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
        //   158: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   161: ldc             ": "
        //   163: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   166: aload           lIIIIIIIIlIIIll
        //   168: invokevirtual   java/lang/RuntimeException.getMessage:()Ljava/lang/String;
        //   171: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   174: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   177: invokestatic    shadersmod/common/SMCLog.warning:(Ljava/lang/String;)V
        //   180: new             Lnet/minecraft/client/resources/data/TextureMetadataSection;
        //   183: dup            
        //   184: iconst_0       
        //   185: iconst_0       
        //   186: invokespecial   net/minecraft/client/resources/data/TextureMetadataSection.<init>:(ZZ)V
        //   189: astore          lIIIIIIIIIllIII
        //   191: aload           lIIIIIIIIlIlIII
        //   193: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Reader;)V
        //   196: aload_3         /* lIIIIIIIIlIlIlI */
        //   197: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //   200: aload           lIIIIIIIIIllIII
        //   202: areturn        
        //   203: astore          lIIIIIIIIIllIIl
        //   205: aload           lIIIIIIIIlIlIII
        //   207: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Reader;)V
        //   210: aload_3         /* lIIIIIIIIlIlIlI */
        //   211: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //   214: aload           lIIIIIIIIIllIIl
        //   216: athrow         
        //   217: aload           lIIIIIIIIlIlIII
        //   219: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Reader;)V
        //   222: aload_3         /* lIIIIIIIIlIlIlI */
        //   223: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //   226: aload           lIIIIIIIIlIIllI
        //   228: areturn        
        //   229: new             Lnet/minecraft/client/resources/data/TextureMetadataSection;
        //   232: dup            
        //   233: iconst_0       
        //   234: iconst_0       
        //   235: invokespecial   net/minecraft/client/resources/data/TextureMetadataSection.<init>:(ZZ)V
        //   238: areturn        
        //    StackMapTable: 00 05 FF 00 73 00 09 07 00 02 07 00 28 07 00 28 07 00 64 07 00 6C 07 00 9B 00 07 00 ED 07 00 3D 00 00 FF 00 06 00 06 07 00 02 07 00 28 07 00 28 07 00 64 07 00 6C 07 00 9B 00 01 07 00 93 F7 00 50 07 00 66 FE 00 0D 07 00 3D 07 00 ED 07 00 3D FF 00 0B 00 04 07 00 02 07 00 28 07 00 28 07 00 64 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                        
        //  -----  -----  -----  -----  ----------------------------
        //  57     103    122    203    Ljava/lang/RuntimeException;
        //  115    119    122    203    Ljava/lang/RuntimeException;
        //  57     103    203    217    Any
        //  115    191    203    217    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static {
        METADATA_SERIALIZER = makeMetadataSerializer();
    }
}
