package net.minecraft.world.gen.structure.template;

import java.util.*;
import com.google.common.collect.*;
import net.minecraft.server.*;
import javax.annotation.*;
import net.minecraft.util.*;
import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;
import java.io.*;

public class TemplateManager
{
    private final /* synthetic */ String baseFolder;
    private final /* synthetic */ Map<String, Template> templates;
    private final /* synthetic */ DataFixer field_191154_c;
    
    public TemplateManager(final String lllllllllllllIlIIIIIlIIlIIIlIIII, final DataFixer lllllllllllllIlIIIIIlIIlIIIIllll) {
        this.templates = (Map<String, Template>)Maps.newHashMap();
        this.baseFolder = lllllllllllllIlIIIIIlIIlIIIlIIII;
        this.field_191154_c = lllllllllllllIlIIIIIlIIlIIIIllll;
    }
    
    @Nullable
    public Template get(@Nullable final MinecraftServer lllllllllllllIlIIIIIlIIIlllllIlI, final ResourceLocation lllllllllllllIlIIIIIlIIIlllllIIl) {
        final String lllllllllllllIlIIIIIlIIIlllllIII = lllllllllllllIlIIIIIlIIIlllllIIl.getResourcePath();
        if (this.templates.containsKey(lllllllllllllIlIIIIIlIIIlllllIII)) {
            return this.templates.get(lllllllllllllIlIIIIIlIIIlllllIII);
        }
        if (lllllllllllllIlIIIIIlIIIlllllIlI == null) {
            this.readTemplateFromJar(lllllllllllllIlIIIIIlIIIlllllIIl);
        }
        else {
            this.readTemplate(lllllllllllllIlIIIIIlIIIlllllIIl);
        }
        return this.templates.containsKey(lllllllllllllIlIIIIIlIIIlllllIII) ? this.templates.get(lllllllllllllIlIIIIIlIIIlllllIII) : null;
    }
    
    private void readTemplateFromStream(final String lllllllllllllIlIIIIIlIIIlIllllIl, final InputStream lllllllllllllIlIIIIIlIIIlIllllII) throws IOException {
        final NBTTagCompound lllllllllllllIlIIIIIlIIIlIlllIll = CompressedStreamTools.readCompressed(lllllllllllllIlIIIIIlIIIlIllllII);
        if (!lllllllllllllIlIIIIIlIIIlIlllIll.hasKey("DataVersion", 99)) {
            lllllllllllllIlIIIIIlIIIlIlllIll.setInteger("DataVersion", 500);
        }
        final Template lllllllllllllIlIIIIIlIIIlIlllIlI = new Template();
        lllllllllllllIlIIIIIlIIIlIlllIlI.read(this.field_191154_c.process(FixTypes.STRUCTURE, lllllllllllllIlIIIIIlIIIlIlllIll));
        this.templates.put(lllllllllllllIlIIIIIlIIIlIllllIl, lllllllllllllIlIIIIIlIIIlIlllIlI);
    }
    
    public boolean writeTemplate(@Nullable final MinecraftServer lllllllllllllIlIIIIIlIIIlIIlllII, final ResourceLocation lllllllllllllIlIIIIIlIIIlIIllIll) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   net/minecraft/util/ResourceLocation.getResourcePath:()Ljava/lang/String;
        //     4: astore_3        /* lllllllllllllIlIIIIIlIIIlIIllIlI */
        //     5: aload_1         /* lllllllllllllIlIIIIIlIIIlIlIlIII */
        //     6: ifnull          176
        //     9: aload_0         /* lllllllllllllIlIIIIIlIIIlIIlllIl */
        //    10: getfield        net/minecraft/world/gen/structure/template/TemplateManager.templates:Ljava/util/Map;
        //    13: aload_3         /* lllllllllllllIlIIIIIlIIIlIlIIllI */
        //    14: invokeinterface java/util/Map.containsKey:(Ljava/lang/Object;)Z
        //    19: ifeq            176
        //    22: new             Ljava/io/File;
        //    25: dup            
        //    26: aload_0         /* lllllllllllllIlIIIIIlIIIlIIlllIl */
        //    27: getfield        net/minecraft/world/gen/structure/template/TemplateManager.baseFolder:Ljava/lang/String;
        //    30: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //    33: astore          lllllllllllllIlIIIIIlIIIlIlIIlIl
        //    35: aload           lllllllllllllIlIIIIIlIIIlIlIIlIl
        //    37: invokevirtual   java/io/File.exists:()Z
        //    40: ifne            53
        //    43: aload           lllllllllllllIlIIIIIlIIIlIlIIlIl
        //    45: invokevirtual   java/io/File.mkdirs:()Z
        //    48: ifne            63
        //    51: iconst_0       
        //    52: ireturn        
        //    53: aload           lllllllllllllIlIIIIIlIIIlIlIIlIl
        //    55: invokevirtual   java/io/File.isDirectory:()Z
        //    58: ifne            63
        //    61: iconst_0       
        //    62: ireturn        
        //    63: new             Ljava/io/File;
        //    66: dup            
        //    67: aload           lllllllllllllIlIIIIIlIIIlIlIIlIl
        //    69: new             Ljava/lang/StringBuilder;
        //    72: dup            
        //    73: aload_3         /* lllllllllllllIlIIIIIlIIIlIlIIllI */
        //    74: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    77: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    80: ldc             ".nbt"
        //    82: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    85: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    88: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //    91: astore          lllllllllllllIlIIIIIlIIIlIlIIlII
        //    93: aload_0         /* lllllllllllllIlIIIIIlIIIlIIlllIl */
        //    94: getfield        net/minecraft/world/gen/structure/template/TemplateManager.templates:Ljava/util/Map;
        //    97: aload_3         /* lllllllllllllIlIIIIIlIIIlIlIIllI */
        //    98: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   103: checkcast       Lnet/minecraft/world/gen/structure/template/Template;
        //   106: astore          lllllllllllllIlIIIIIlIIIlIlIIIll
        //   108: aconst_null    
        //   109: astore          lllllllllllllIlIIIIIlIIIlIlIIIlI
        //   111: aload           lllllllllllllIlIIIIIlIIIlIlIIIll
        //   113: new             Lnet/minecraft/nbt/NBTTagCompound;
        //   116: dup            
        //   117: invokespecial   net/minecraft/nbt/NBTTagCompound.<init>:()V
        //   120: invokevirtual   net/minecraft/world/gen/structure/template/Template.writeToNBT:(Lnet/minecraft/nbt/NBTTagCompound;)Lnet/minecraft/nbt/NBTTagCompound;
        //   123: astore          lllllllllllllIlIIIIIlIIIlIIlllll
        //   125: new             Ljava/io/FileOutputStream;
        //   128: dup            
        //   129: aload           lllllllllllllIlIIIIIlIIIlIlIIlII
        //   131: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //   134: astore          lllllllllllllIlIIIIIlIIIlIlIIIlI
        //   136: aload           lllllllllllllIlIIIIIlIIIlIIlllll
        //   138: aload           lllllllllllllIlIIIIIlIIIlIlIIIlI
        //   140: invokestatic    net/minecraft/nbt/CompressedStreamTools.writeCompressed:(Lnet/minecraft/nbt/NBTTagCompound;Ljava/io/OutputStream;)V
        //   143: aload           lllllllllllllIlIIIIIlIIIlIlIIIlI
        //   145: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/OutputStream;)V
        //   148: iconst_1       
        //   149: ireturn        
        //   150: astore          lllllllllllllIlIIIIIlIIIlIIllllI
        //   152: iconst_0       
        //   153: istore          lllllllllllllIlIIIIIlIIIlIlIIIIl
        //   155: aload           lllllllllllllIlIIIIIlIIIlIlIIIlI
        //   157: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/OutputStream;)V
        //   160: goto            173
        //   163: astore          lllllllllllllIlIIIIIlIIIlIIlIIll
        //   165: aload           lllllllllllllIlIIIIIlIIIlIlIIIlI
        //   167: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/OutputStream;)V
        //   170: aload           lllllllllllllIlIIIIIlIIIlIIlIIll
        //   172: athrow         
        //   173: iload           lllllllllllllIlIIIIIlIIIlIlIIIII
        //   175: ireturn        
        //   176: iconst_0       
        //   177: ireturn        
        //    RuntimeVisibleTypeAnnotations: 00 01 16 00 00 00 28 00 00
        //    StackMapTable: 00 06 FD 00 35 07 00 50 07 00 8F 09 FF 00 56 00 08 07 00 02 07 00 DD 07 00 2A 07 00 50 07 00 8F 07 00 8F 07 00 39 07 00 B3 00 01 07 00 8D 4C 07 00 8D FD 00 09 01 07 00 8D FF 00 02 00 04 07 00 02 07 00 DD 07 00 2A 07 00 50 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  111    143    150    163    Ljava/lang/Throwable;
        //  111    143    163    173    Any
        //  150    155    163    173    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public boolean readTemplate(final ResourceLocation lllllllllllllIlIIIIIlIIIlllIIIlI) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   net/minecraft/util/ResourceLocation.getResourcePath:()Ljava/lang/String;
        //     4: astore_2        /* lllllllllllllIlIIIIIlIIIlllIIIIl */
        //     5: new             Ljava/io/File;
        //     8: dup            
        //     9: aload_0         /* lllllllllllllIlIIIIIlIIIlllIlIll */
        //    10: getfield        net/minecraft/world/gen/structure/template/TemplateManager.baseFolder:Ljava/lang/String;
        //    13: new             Ljava/lang/StringBuilder;
        //    16: dup            
        //    17: aload_2         /* lllllllllllllIlIIIIIlIIIlllIlIIl */
        //    18: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    21: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    24: ldc             ".nbt"
        //    26: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    29: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    32: invokespecial   java/io/File.<init>:(Ljava/lang/String;Ljava/lang/String;)V
        //    35: astore_3        /* lllllllllllllIlIIIIIlIIIlllIIIII */
        //    36: aload_3         /* lllllllllllllIlIIIIIlIIIlllIlIII */
        //    37: invokevirtual   java/io/File.exists:()Z
        //    40: ifne            49
        //    43: aload_0         /* lllllllllllllIlIIIIIlIIIlllIlIll */
        //    44: aload_1         /* lllllllllllllIlIIIIIlIIIlllIlIlI */
        //    45: invokespecial   net/minecraft/world/gen/structure/template/TemplateManager.readTemplateFromJar:(Lnet/minecraft/util/ResourceLocation;)Z
        //    48: ireturn        
        //    49: aconst_null    
        //    50: astore          lllllllllllllIlIIIIIlIIIlllIIlll
        //    52: new             Ljava/io/FileInputStream;
        //    55: dup            
        //    56: aload_3         /* lllllllllllllIlIIIIIlIIIlllIlIII */
        //    57: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    60: astore          lllllllllllllIlIIIIIlIIIlllIIlll
        //    62: aload_0         /* lllllllllllllIlIIIIIlIIIlllIlIll */
        //    63: aload_2         /* lllllllllllllIlIIIIIlIIIlllIlIIl */
        //    64: aload           lllllllllllllIlIIIIIlIIIlllIIlll
        //    66: invokespecial   net/minecraft/world/gen/structure/template/TemplateManager.readTemplateFromStream:(Ljava/lang/String;Ljava/io/InputStream;)V
        //    69: aload           lllllllllllllIlIIIIIlIIIlllIIlll
        //    71: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    74: iconst_1       
        //    75: ireturn        
        //    76: astore          lllllllllllllIlIIIIIlIIIlllIIlII
        //    78: iconst_0       
        //    79: istore          lllllllllllllIlIIIIIlIIIlllIIllI
        //    81: aload           lllllllllllllIlIIIIIlIIIlllIIlll
        //    83: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    86: goto            99
        //    89: astore          lllllllllllllIlIIIIIlIIIllIlllII
        //    91: aload           lllllllllllllIlIIIIIlIIIlllIIlll
        //    93: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    96: aload           lllllllllllllIlIIIIIlIIIllIlllII
        //    98: athrow         
        //    99: iload           lllllllllllllIlIIIIIlIIIlllIIlIl
        //   101: ireturn        
        //    StackMapTable: 00 04 FD 00 31 07 00 50 07 00 8F FF 00 1A 00 05 07 00 02 07 00 2A 07 00 50 07 00 8F 07 00 E2 00 01 07 00 8D 4C 07 00 8D FD 00 09 01 07 00 8D
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  52     69     76     89     Ljava/lang/Throwable;
        //  52     69     89     99     Any
        //  76     81     89     99     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void remove(final ResourceLocation lllllllllllllIlIIIIIlIIIlIIIllIl) {
        this.templates.remove(lllllllllllllIlIIIIIlIIIlIIIllIl.getResourcePath());
    }
    
    private boolean readTemplateFromJar(final ResourceLocation lllllllllllllIlIIIIIlIIIllIlIIlI) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   net/minecraft/util/ResourceLocation.getResourceDomain:()Ljava/lang/String;
        //     4: astore_2        /* lllllllllllllIlIIIIIlIIIllIlIIIl */
        //     5: aload_1         /* lllllllllllllIlIIIIIlIIIllIIlIlI */
        //     6: invokevirtual   net/minecraft/util/ResourceLocation.getResourcePath:()Ljava/lang/String;
        //     9: astore_3        /* lllllllllllllIlIIIIIlIIIllIlIIII */
        //    10: aconst_null    
        //    11: astore          lllllllllllllIlIIIIIlIIIllIIllll
        //    13: ldc             Lnet/minecraft/server/MinecraftServer;.class
        //    15: new             Ljava/lang/StringBuilder;
        //    18: dup            
        //    19: ldc_w           "/assets/"
        //    22: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    25: aload_2         /* lllllllllllllIlIIIIIlIIIllIlIIIl */
        //    26: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    29: ldc_w           "/structures/"
        //    32: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    35: aload_3         /* lllllllllllllIlIIIIIlIIIllIlIIII */
        //    36: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    39: ldc             ".nbt"
        //    41: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    44: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    47: invokevirtual   java/lang/Class.getResourceAsStream:(Ljava/lang/String;)Ljava/io/InputStream;
        //    50: astore          lllllllllllllIlIIIIIlIIIllIIllll
        //    52: aload_0         /* lllllllllllllIlIIIIIlIIIllIlIIll */
        //    53: aload_3         /* lllllllllllllIlIIIIIlIIIllIlIIII */
        //    54: aload           lllllllllllllIlIIIIIlIIIllIIllll
        //    56: invokespecial   net/minecraft/world/gen/structure/template/TemplateManager.readTemplateFromStream:(Ljava/lang/String;Ljava/io/InputStream;)V
        //    59: aload           lllllllllllllIlIIIIIlIIIllIIllll
        //    61: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    64: iconst_1       
        //    65: ireturn        
        //    66: astore          lllllllllllllIlIIIIIlIIIllIIllII
        //    68: iconst_0       
        //    69: istore          lllllllllllllIlIIIIIlIIIllIIlllI
        //    71: aload           lllllllllllllIlIIIIIlIIIllIIllll
        //    73: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    76: goto            89
        //    79: astore          lllllllllllllIlIIIIIlIIIllIIIlII
        //    81: aload           lllllllllllllIlIIIIIlIIIllIIllll
        //    83: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    86: aload           lllllllllllllIlIIIIIlIIIllIIIlII
        //    88: athrow         
        //    89: iload           lllllllllllllIlIIIIIlIIIllIIllIl
        //    91: ireturn        
        //    StackMapTable: 00 03 FF 00 42 00 05 07 00 02 07 00 2A 07 00 50 07 00 50 07 01 20 00 01 07 00 8D 4C 07 00 8D FD 00 09 01 07 00 8D
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  13     59     66     79     Ljava/lang/Throwable;
        //  13     59     79     89     Any
        //  66     71     79     89     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public Template getTemplate(@Nullable final MinecraftServer lllllllllllllIlIIIIIlIIlIIIIIllI, final ResourceLocation lllllllllllllIlIIIIIlIIlIIIIIlIl) {
        Template lllllllllllllIlIIIIIlIIlIIIIIlII = this.get(lllllllllllllIlIIIIIlIIlIIIIIllI, lllllllllllllIlIIIIIlIIlIIIIIlIl);
        if (lllllllllllllIlIIIIIlIIlIIIIIlII == null) {
            lllllllllllllIlIIIIIlIIlIIIIIlII = new Template();
            this.templates.put(lllllllllllllIlIIIIIlIIlIIIIIlIl.getResourcePath(), lllllllllllllIlIIIIIlIIlIIIIIlII);
        }
        return lllllllllllllIlIIIIIlIIlIIIIIlII;
    }
}
