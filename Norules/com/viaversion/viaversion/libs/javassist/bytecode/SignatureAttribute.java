package com.viaversion.viaversion.libs.javassist.bytecode;

import java.io.*;
import java.util.*;
import com.viaversion.viaversion.libs.javassist.*;

public class SignatureAttribute extends AttributeInfo
{
    private static ClassSignature parseSig(final String lllllllllllllIlIIIlIlllIIlIIlllI) throws BadBytecode, IndexOutOfBoundsException {
        final Cursor lllllllllllllIlIIIlIlllIIlIIllIl = new Cursor();
        final TypeParameter[] lllllllllllllIlIIIlIlllIIlIIllII = parseTypeParams(lllllllllllllIlIIIlIlllIIlIIlllI, lllllllllllllIlIIIlIlllIIlIIllIl);
        final ClassType lllllllllllllIlIIIlIlllIIlIIlIll = parseClassType(lllllllllllllIlIIIlIlllIIlIIlllI, lllllllllllllIlIIIlIlllIIlIIllIl);
        final int lllllllllllllIlIIIlIlllIIlIIlIlI = lllllllllllllIlIIIlIlllIIlIIlllI.length();
        final List<ClassType> lllllllllllllIlIIIlIlllIIlIIlIIl = new ArrayList<ClassType>();
        while (lllllllllllllIlIIIlIlllIIlIIllIl.position < lllllllllllllIlIIIlIlllIIlIIlIlI && lllllllllllllIlIIIlIlllIIlIIlllI.charAt(lllllllllllllIlIIIlIlllIIlIIllIl.position) == 'L') {
            lllllllllllllIlIIIlIlllIIlIIlIIl.add(parseClassType(lllllllllllllIlIIIlIlllIIlIIlllI, lllllllllllllIlIIIlIlllIIlIIllIl));
        }
        final ClassType[] lllllllllllllIlIIIlIlllIIlIIlIII = lllllllllllllIlIIIlIlllIIlIIlIIl.toArray(new ClassType[lllllllllllllIlIIIlIlllIIlIIlIIl.size()]);
        return new ClassSignature(lllllllllllllIlIIIlIlllIIlIIllII, lllllllllllllIlIIIlIlllIIlIIlIll, lllllllllllllIlIIIlIlllIIlIIlIII);
    }
    
    private static BadBytecode error(final String lllllllllllllIlIIIlIllIllIlIllll) {
        return new BadBytecode(String.valueOf(new StringBuilder().append("bad signature: ").append(lllllllllllllIlIIIlIllIllIlIllll)));
    }
    
    private static MethodSignature parseMethodSig(final String lllllllllllllIlIIIlIlllIIIlIllII) throws BadBytecode {
        final Cursor lllllllllllllIlIIIlIlllIIIlIlIll = new Cursor();
        final TypeParameter[] lllllllllllllIlIIIlIlllIIIlIlIlI = parseTypeParams(lllllllllllllIlIIIlIlllIIIlIllII, lllllllllllllIlIIIlIlllIIIlIlIll);
        if (lllllllllllllIlIIIlIlllIIIlIllII.charAt(lllllllllllllIlIIIlIlllIIIlIlIll.position++) != '(') {
            throw error(lllllllllllllIlIIIlIlllIIIlIllII);
        }
        final List<Type> lllllllllllllIlIIIlIlllIIIlIlIIl = new ArrayList<Type>();
        while (lllllllllllllIlIIIlIlllIIIlIllII.charAt(lllllllllllllIlIIIlIlllIIIlIlIll.position) != ')') {
            final Type lllllllllllllIlIIIlIlllIIIlIlllI = parseType(lllllllllllllIlIIIlIlllIIIlIllII, lllllllllllllIlIIIlIlllIIIlIlIll);
            lllllllllllllIlIIIlIlllIIIlIlIIl.add(lllllllllllllIlIIIlIlllIIIlIlllI);
        }
        final Cursor cursor = lllllllllllllIlIIIlIlllIIIlIlIll;
        ++cursor.position;
        final Type lllllllllllllIlIIIlIlllIIIlIlIII = parseType(lllllllllllllIlIIIlIlllIIIlIllII, lllllllllllllIlIIIlIlllIIIlIlIll);
        final int lllllllllllllIlIIIlIlllIIIlIIlll = lllllllllllllIlIIIlIlllIIIlIllII.length();
        final List<ObjectType> lllllllllllllIlIIIlIlllIIIlIIllI = new ArrayList<ObjectType>();
        while (lllllllllllllIlIIIlIlllIIIlIlIll.position < lllllllllllllIlIIIlIlllIIIlIIlll && lllllllllllllIlIIIlIlllIIIlIllII.charAt(lllllllllllllIlIIIlIlllIIIlIlIll.position) == '^') {
            final Cursor cursor2 = lllllllllllllIlIIIlIlllIIIlIlIll;
            ++cursor2.position;
            final ObjectType lllllllllllllIlIIIlIlllIIIlIllIl = parseObjectType(lllllllllllllIlIIIlIlllIIIlIllII, lllllllllllllIlIIIlIlllIIIlIlIll, false);
            if (lllllllllllllIlIIIlIlllIIIlIllIl instanceof ArrayType) {
                throw error(lllllllllllllIlIIIlIlllIIIlIllII);
            }
            lllllllllllllIlIIIlIlllIIIlIIllI.add(lllllllllllllIlIIIlIlllIIIlIllIl);
        }
        final Type[] lllllllllllllIlIIIlIlllIIIlIIlIl = lllllllllllllIlIIIlIlllIIIlIlIIl.toArray(new Type[lllllllllllllIlIIIlIlllIIIlIlIIl.size()]);
        final ObjectType[] lllllllllllllIlIIIlIlllIIIlIIlII = lllllllllllllIlIIIlIlllIIIlIIllI.toArray(new ObjectType[lllllllllllllIlIIIlIlllIIIlIIllI.size()]);
        return new MethodSignature(lllllllllllllIlIIIlIlllIIIlIlIlI, lllllllllllllIlIIIlIlllIIIlIIlIl, lllllllllllllIlIIIlIlllIIIlIlIII, lllllllllllllIlIIIlIlllIIIlIIlII);
    }
    
    @Override
    void renameClass(final Map<String, String> lllllllllllllIlIIIlIlllIlIlIIIlI) {
        final String lllllllllllllIlIIIlIlllIlIlIIlII = renameClass(this.getSignature(), lllllllllllllIlIIIlIlllIlIlIIIlI);
        this.setSignature(lllllllllllllIlIIIlIlllIlIlIIlII);
    }
    
    static {
        tag = "Signature";
    }
    
    @Override
    public AttributeInfo copy(final ConstPool lllllllllllllIlIIIlIlllIlIllIllI, final Map<String, String> lllllllllllllIlIIIlIlllIlIlllIII) {
        return new SignatureAttribute(lllllllllllllIlIIIlIlllIlIllIllI, this.getSignature());
    }
    
    private static TypeArgument[] parseTypeArgs(final String lllllllllllllIlIIIlIllIlllIIllII, final Cursor lllllllllllllIlIIIlIllIlllIIlIll) throws BadBytecode {
        final List<TypeArgument> lllllllllllllIlIIIlIllIlllIIlIlI = new ArrayList<TypeArgument>();
        char lllllllllllllIlIIIlIllIlllIIlIIl;
        while ((lllllllllllllIlIIIlIllIlllIIlIIl = lllllllllllllIlIIIlIllIlllIIllII.charAt(lllllllllllllIlIIIlIllIlllIIlIll.position++)) != '>') {
            TypeArgument lllllllllllllIlIIIlIllIlllIIllIl = null;
            if (lllllllllllllIlIIIlIllIlllIIlIIl == '*') {
                final TypeArgument lllllllllllllIlIIIlIllIlllIIlllI = new TypeArgument(null, '*');
            }
            else {
                if (lllllllllllllIlIIIlIllIlllIIlIIl != '+' && lllllllllllllIlIIIlIllIlllIIlIIl != '-') {
                    lllllllllllllIlIIIlIllIlllIIlIIl = ' ';
                    --lllllllllllllIlIIIlIllIlllIIlIll.position;
                }
                lllllllllllllIlIIIlIllIlllIIllIl = new TypeArgument(parseObjectType(lllllllllllllIlIIIlIllIlllIIllII, lllllllllllllIlIIIlIllIlllIIlIll, false), lllllllllllllIlIIIlIllIlllIIlIIl);
            }
            lllllllllllllIlIIIlIllIlllIIlIlI.add(lllllllllllllIlIIIlIllIlllIIllIl);
        }
        return lllllllllllllIlIIIlIllIlllIIlIlI.toArray(new TypeArgument[lllllllllllllIlIIIlIllIlllIIlIlI.size()]);
    }
    
    private static Type parseType(final String lllllllllllllIlIIIlIllIllIllIlll, final Cursor lllllllllllllIlIIIlIllIllIllIllI) throws BadBytecode {
        Type lllllllllllllIlIIIlIllIllIllIlIl = parseObjectType(lllllllllllllIlIIIlIllIllIllIlll, lllllllllllllIlIIIlIllIllIllIllI, true);
        if (lllllllllllllIlIIIlIllIllIllIlIl == null) {
            lllllllllllllIlIIIlIllIllIllIlIl = new BaseType(lllllllllllllIlIIIlIllIllIllIlll.charAt(lllllllllllllIlIIIlIllIllIllIllI.position++));
        }
        return lllllllllllllIlIIIlIllIllIllIlIl;
    }
    
    public static Type toTypeSignature(final String lllllllllllllIlIIIlIlllIIlIlIlll) throws BadBytecode {
        try {
            return parseType(lllllllllllllIlIIIlIlllIIlIlIlll, new Cursor());
        }
        catch (IndexOutOfBoundsException lllllllllllllIlIIIlIlllIIlIllIIl) {
            throw error(lllllllllllllIlIIIlIlllIIlIlIlll);
        }
    }
    
    SignatureAttribute(final ConstPool lllllllllllllIlIIIlIlllIllIllllI, final int lllllllllllllIlIIIlIlllIllIllIIl, final DataInputStream lllllllllllllIlIIIlIlllIllIlllII) throws IOException {
        super(lllllllllllllIlIIIlIlllIllIllllI, lllllllllllllIlIIIlIlllIllIllIIl, lllllllllllllIlIIIlIlllIllIlllII);
    }
    
    public static ObjectType toFieldSignature(final String lllllllllllllIlIIIlIlllIIlIlllIl) throws BadBytecode {
        try {
            return parseObjectType(lllllllllllllIlIIIlIlllIIlIlllIl, new Cursor(), false);
        }
        catch (IndexOutOfBoundsException lllllllllllllIlIIIlIlllIIlIlllll) {
            throw error(lllllllllllllIlIIIlIlllIIlIlllIl);
        }
    }
    
    @Override
    void renameClass(final String lllllllllllllIlIIIlIlllIlIlIllII, final String lllllllllllllIlIIIlIlllIlIlIlIll) {
        final String lllllllllllllIlIIIlIlllIlIlIlllI = renameClass(this.getSignature(), lllllllllllllIlIIIlIlllIlIlIllII, lllllllllllllIlIIIlIlllIlIlIlIll);
        this.setSignature(lllllllllllllIlIIIlIlllIlIlIlllI);
    }
    
    static String renameClass(final String lllllllllllllIlIIIlIlllIlIIlllII, final String lllllllllllllIlIIIlIlllIlIIllIll, final String lllllllllllllIlIIIlIlllIlIIlIllI) {
        final Map<String, String> lllllllllllllIlIIIlIlllIlIIllIIl = new HashMap<String, String>();
        lllllllllllllIlIIIlIlllIlIIllIIl.put(lllllllllllllIlIIIlIlllIlIIllIll, lllllllllllllIlIIIlIlllIlIIlIllI);
        return renameClass(lllllllllllllIlIIIlIlllIlIIlllII, lllllllllllllIlIIIlIlllIlIIllIIl);
    }
    
    private static ObjectType parseObjectType(final String lllllllllllllIlIIIlIllIlllllIlll, final Cursor lllllllllllllIlIIIlIllIlllllIllI, final boolean lllllllllllllIlIIIlIllIlllllIlIl) throws BadBytecode {
        final int lllllllllllllIlIIIlIllIllllllIII = lllllllllllllIlIIIlIllIlllllIllI.position;
        switch (lllllllllllllIlIIIlIllIlllllIlll.charAt(lllllllllllllIlIIIlIllIllllllIII)) {
            case 'L': {
                return parseClassType2(lllllllllllllIlIIIlIllIlllllIlll, lllllllllllllIlIIIlIllIlllllIllI, null);
            }
            case 'T': {
                final int lllllllllllllIlIIIlIllIlllllllII = lllllllllllllIlIIIlIllIlllllIllI.indexOf(lllllllllllllIlIIIlIllIlllllIlll, 59);
                return new TypeVariable(lllllllllllllIlIIIlIllIlllllIlll, lllllllllllllIlIIIlIllIllllllIII + 1, lllllllllllllIlIIIlIllIlllllllII);
            }
            case '[': {
                return parseArray(lllllllllllllIlIIIlIllIlllllIlll, lllllllllllllIlIIIlIllIlllllIllI);
            }
            default: {
                if (lllllllllllllIlIIIlIllIlllllIlIl) {
                    return null;
                }
                throw error(lllllllllllllIlIIIlIllIlllllIlll);
            }
        }
    }
    
    private static boolean isNamePart(final int lllllllllllllIlIIIlIlllIIllIlllI) {
        return lllllllllllllIlIIIlIlllIIllIlllI != 59 && lllllllllllllIlIIIlIlllIIllIlllI != 60;
    }
    
    static String renameClass(final String lllllllllllllIlIIIlIlllIlIIIIIIl, final Map<String, String> lllllllllllllIlIIIlIlllIlIIIIIII) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ifnonnull       6
        //     4: aload_0         /* lllllllllllllIlIIIlIlllIIllllIll */
        //     5: areturn        
        //     6: new             Ljava/lang/StringBuilder;
        //     9: dup            
        //    10: invokespecial   java/lang/StringBuilder.<init>:()V
        //    13: astore_2        /* lllllllllllllIlIIIlIlllIIlllllll */
        //    14: iconst_0       
        //    15: istore_3        /* lllllllllllllIlIIIlIlllIIllllllI */
        //    16: iconst_0       
        //    17: istore          lllllllllllllIlIIIlIlllIIlllllIl
        //    19: aload_0         /* lllllllllllllIlIIIlIlllIIllllIll */
        //    20: bipush          76
        //    22: iload           lllllllllllllIlIIIlIlllIIlllllIl
        //    24: invokevirtual   java/lang/String.indexOf:(II)I
        //    27: istore          lllllllllllllIlIIIlIlllIlIIIIlll
        //    29: iload           lllllllllllllIlIIIlIlllIlIIIIlll
        //    31: ifge            37
        //    34: goto            199
        //    37: new             Ljava/lang/StringBuilder;
        //    40: dup            
        //    41: invokespecial   java/lang/StringBuilder.<init>:()V
        //    44: astore          lllllllllllllIlIIIlIlllIlIIIIllI
        //    46: iload           lllllllllllllIlIIIlIlllIlIIIIlll
        //    48: istore          lllllllllllllIlIIIlIlllIlIIIIlIl
        //    50: aload_0         /* lllllllllllllIlIIIlIlllIIllllIll */
        //    51: iinc            lllllllllllllIlIIIlIlllIlIIIIlIl, 1
        //    54: iload           lllllllllllllIlIIIlIlllIlIIIIlIl
        //    56: invokevirtual   java/lang/String.charAt:(I)C
        //    59: dup            
        //    60: istore          lllllllllllllIlIIIlIlllIlIIIlIIl
        //    62: bipush          59
        //    64: if_icmpeq       121
        //    67: aload           lllllllllllllIlIIIlIlllIlIIIIllI
        //    69: iload           lllllllllllllIlIIIlIlllIlIIIlIIl
        //    71: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //    74: pop            
        //    75: iload           lllllllllllllIlIIIlIlllIlIIIlIIl
        //    77: bipush          60
        //    79: if_icmpne       50
        //    82: aload_0         /* lllllllllllllIlIIIlIlllIIllllIll */
        //    83: iinc            lllllllllllllIlIIIlIlllIlIIIIlIl, 1
        //    86: iload           lllllllllllllIlIIIlIlllIlIIIIlIl
        //    88: invokevirtual   java/lang/String.charAt:(I)C
        //    91: dup            
        //    92: istore          lllllllllllllIlIIIlIlllIlIIIlIIl
        //    94: bipush          62
        //    96: if_icmpeq       110
        //    99: aload           lllllllllllllIlIIIlIlllIlIIIIllI
        //   101: iload           lllllllllllllIlIIIlIlllIlIIIlIIl
        //   103: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   106: pop            
        //   107: goto            82
        //   110: aload           lllllllllllllIlIIIlIlllIlIIIIllI
        //   112: iload           lllllllllllllIlIIIlIlllIlIIIlIIl
        //   114: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   117: pop            
        //   118: goto            50
        //   121: goto            129
        //   124: astore          lllllllllllllIlIIIlIlllIlIIIlIII
        //   126: goto            199
        //   129: iload           lllllllllllllIlIIIlIlllIlIIIIlIl
        //   131: iconst_1       
        //   132: iadd           
        //   133: istore          lllllllllllllIlIIIlIlllIIlllllIl
        //   135: aload           lllllllllllllIlIIIlIlllIlIIIIllI
        //   137: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   140: astore          lllllllllllllIlIIIlIlllIlIIIIIll
        //   142: aload_1         /* lllllllllllllIlIIIlIlllIIllllIlI */
        //   143: aload           lllllllllllllIlIIIlIlllIlIIIIIll
        //   145: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   150: checkcast       Ljava/lang/String;
        //   153: astore          lllllllllllllIlIIIlIlllIlIIIIIlI
        //   155: aload           lllllllllllllIlIIIlIlllIlIIIIIlI
        //   157: ifnull          196
        //   160: aload_2         /* lllllllllllllIlIIIlIlllIIlllllll */
        //   161: aload_0         /* lllllllllllllIlIIIlIlllIIllllIll */
        //   162: iload_3         /* lllllllllllllIlIIIlIlllIIllllllI */
        //   163: iload           lllllllllllllIlIIIlIlllIlIIIIlll
        //   165: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //   168: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   171: pop            
        //   172: aload_2         /* lllllllllllllIlIIIlIlllIIlllllll */
        //   173: bipush          76
        //   175: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   178: pop            
        //   179: aload_2         /* lllllllllllllIlIIIlIlllIIlllllll */
        //   180: aload           lllllllllllllIlIIIlIlllIlIIIIIlI
        //   182: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   185: pop            
        //   186: aload_2         /* lllllllllllllIlIIIlIlllIIlllllll */
        //   187: iload           lllllllllllllIlIIIlIlllIlIIIIlII
        //   189: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   192: pop            
        //   193: iload           lllllllllllllIlIIIlIlllIIlllllIl
        //   195: istore_3        /* lllllllllllllIlIIIlIlllIIllllllI */
        //   196: goto            19
        //   199: iload_3         /* lllllllllllllIlIIIlIlllIIllllllI */
        //   200: ifne            205
        //   203: aload_0         /* lllllllllllllIlIIIlIlllIIllllIll */
        //   204: areturn        
        //   205: aload_0         /* lllllllllllllIlIIIlIlllIIllllIll */
        //   206: invokevirtual   java/lang/String.length:()I
        //   209: istore          lllllllllllllIlIIIlIlllIIlllllII
        //   211: iload_3         /* lllllllllllllIlIIIlIlllIIllllllI */
        //   212: iload           lllllllllllllIlIIIlIlllIIlllllII
        //   214: if_icmpge       229
        //   217: aload_2         /* lllllllllllllIlIIIlIlllIIlllllll */
        //   218: aload_0         /* lllllllllllllIlIIIlIlllIIllllIll */
        //   219: iload_3         /* lllllllllllllIlIIIlIlllIIllllllI */
        //   220: iload           lllllllllllllIlIIIlIlllIIlllllII
        //   222: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //   225: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   228: pop            
        //   229: aload_2         /* lllllllllllllIlIIIlIlllIIlllllll */
        //   230: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   233: areturn        
        //    Signature:
        //  (Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;)Ljava/lang/String;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                 
        //  -----  -----  -----  -----  -------------------------------------
        //  50     121    124    129    Ljava/lang/IndexOutOfBoundsException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static ClassSignature toClassSignature(final String lllllllllllllIlIIIlIlllIIllIlIlI) throws BadBytecode {
        try {
            return parseSig(lllllllllllllIlIIIlIlllIIllIlIlI);
        }
        catch (IndexOutOfBoundsException lllllllllllllIlIIIlIlllIIllIlIll) {
            throw error(lllllllllllllIlIIIlIlllIIllIlIlI);
        }
    }
    
    public static MethodSignature toMethodSignature(final String lllllllllllllIlIIIlIlllIIllIIlII) throws BadBytecode {
        try {
            return parseMethodSig(lllllllllllllIlIIIlIlllIIllIIlII);
        }
        catch (IndexOutOfBoundsException lllllllllllllIlIIIlIlllIIllIIlIl) {
            throw error(lllllllllllllIlIIIlIlllIIllIIlII);
        }
    }
    
    public String getSignature() {
        return this.getConstPool().getUtf8Info(ByteArray.readU16bit(this.get(), 0));
    }
    
    private static ClassType parseClassType2(final String lllllllllllllIlIIIlIllIlllIllIll, final Cursor lllllllllllllIlIIIlIllIlllIllIlI, final ClassType lllllllllllllIlIIIlIllIllllIIIIl) throws BadBytecode {
        final int lllllllllllllIlIIIlIllIllllIIIII = ++lllllllllllllIlIIIlIllIlllIllIlI.position;
        char lllllllllllllIlIIIlIllIlllIlllll;
        do {
            lllllllllllllIlIIIlIllIlllIlllll = lllllllllllllIlIIIlIllIlllIllIll.charAt(lllllllllllllIlIIIlIllIlllIllIlI.position++);
        } while (lllllllllllllIlIIIlIllIlllIlllll != '$' && lllllllllllllIlIIIlIllIlllIlllll != '<' && lllllllllllllIlIIIlIllIlllIlllll != ';');
        final int lllllllllllllIlIIIlIllIlllIllllI = lllllllllllllIlIIIlIllIlllIllIlI.position - 1;
        TypeArgument[] lllllllllllllIlIIIlIllIlllIlllIl = null;
        if (lllllllllllllIlIIIlIllIlllIlllll == '<') {
            final TypeArgument[] lllllllllllllIlIIIlIllIllllIIlII = parseTypeArgs(lllllllllllllIlIIIlIllIlllIllIll, lllllllllllllIlIIIlIllIlllIllIlI);
            lllllllllllllIlIIIlIllIlllIlllll = lllllllllllllIlIIIlIllIlllIllIll.charAt(lllllllllllllIlIIIlIllIlllIllIlI.position++);
        }
        else {
            lllllllllllllIlIIIlIllIlllIlllIl = null;
        }
        final ClassType lllllllllllllIlIIIlIllIlllIlllII = ClassType.make(lllllllllllllIlIIIlIllIlllIllIll, lllllllllllllIlIIIlIllIllllIIIII, lllllllllllllIlIIIlIllIlllIllllI, lllllllllllllIlIIIlIllIlllIlllIl, lllllllllllllIlIIIlIllIllllIIIIl);
        if (lllllllllllllIlIIIlIllIlllIlllll == '$' || lllllllllllllIlIIIlIllIlllIlllll == '.') {
            --lllllllllllllIlIIIlIllIlllIllIlI.position;
            return parseClassType2(lllllllllllllIlIIIlIllIlllIllIll, lllllllllllllIlIIIlIllIlllIllIlI, lllllllllllllIlIIIlIllIlllIlllII);
        }
        return lllllllllllllIlIIIlIllIlllIlllII;
    }
    
    private static TypeParameter[] parseTypeParams(final String lllllllllllllIlIIIlIlllIIIIIlIIl, final Cursor lllllllllllllIlIIIlIlllIIIIIlIll) throws BadBytecode {
        final List<TypeParameter> lllllllllllllIlIIIlIlllIIIIIlIlI = new ArrayList<TypeParameter>();
        if (lllllllllllllIlIIIlIlllIIIIIlIIl.charAt(lllllllllllllIlIIIlIlllIIIIIlIll.position) == '<') {
            ++lllllllllllllIlIIIlIlllIIIIIlIll.position;
            while (lllllllllllllIlIIIlIlllIIIIIlIIl.charAt(lllllllllllllIlIIIlIlllIIIIIlIll.position) != '>') {
                final int lllllllllllllIlIIIlIlllIIIIlIIIl = lllllllllllllIlIIIlIlllIIIIIlIll.position;
                final int lllllllllllllIlIIIlIlllIIIIlIIII = lllllllllllllIlIIIlIlllIIIIIlIll.indexOf(lllllllllllllIlIIIlIlllIIIIIlIIl, 58);
                final ObjectType lllllllllllllIlIIIlIlllIIIIIllll = parseObjectType(lllllllllllllIlIIIlIlllIIIIIlIIl, lllllllllllllIlIIIlIlllIIIIIlIll, true);
                final List<ObjectType> lllllllllllllIlIIIlIlllIIIIIlllI = new ArrayList<ObjectType>();
                while (lllllllllllllIlIIIlIlllIIIIIlIIl.charAt(lllllllllllllIlIIIlIlllIIIIIlIll.position) == ':') {
                    ++lllllllllllllIlIIIlIlllIIIIIlIll.position;
                    final ObjectType lllllllllllllIlIIIlIlllIIIIlIIlI = parseObjectType(lllllllllllllIlIIIlIlllIIIIIlIIl, lllllllllllllIlIIIlIlllIIIIIlIll, false);
                    lllllllllllllIlIIIlIlllIIIIIlllI.add(lllllllllllllIlIIIlIlllIIIIlIIlI);
                }
                final TypeParameter lllllllllllllIlIIIlIlllIIIIIllIl = new TypeParameter(lllllllllllllIlIIIlIlllIIIIIlIIl, lllllllllllllIlIIIlIlllIIIIlIIIl, lllllllllllllIlIIIlIlllIIIIlIIII, lllllllllllllIlIIIlIlllIIIIIllll, lllllllllllllIlIIIlIlllIIIIIlllI.toArray(new ObjectType[lllllllllllllIlIIIlIlllIIIIIlllI.size()]));
                lllllllllllllIlIIIlIlllIIIIIlIlI.add(lllllllllllllIlIIIlIlllIIIIIllIl);
            }
            ++lllllllllllllIlIIIlIlllIIIIIlIll.position;
        }
        return lllllllllllllIlIIIlIlllIIIIIlIlI.toArray(new TypeParameter[lllllllllllllIlIIIlIlllIIIIIlIlI.size()]);
    }
    
    public SignatureAttribute(final ConstPool lllllllllllllIlIIIlIlllIllIlIIIl, final String lllllllllllllIlIIIlIlllIllIlIIII) {
        super(lllllllllllllIlIIIlIlllIllIlIIIl, "Signature");
        final int lllllllllllllIlIIIlIlllIllIIllll = lllllllllllllIlIIIlIlllIllIlIIIl.addUtf8Info(lllllllllllllIlIIIlIlllIllIlIIII);
        final byte[] lllllllllllllIlIIIlIlllIllIIlllI = { (byte)(lllllllllllllIlIIIlIlllIllIIllll >>> 8), (byte)lllllllllllllIlIIIlIlllIllIIllll };
        this.set(lllllllllllllIlIIIlIlllIllIIlllI);
    }
    
    public void setSignature(final String lllllllllllllIlIIIlIlllIllIIIIIl) {
        final int lllllllllllllIlIIIlIlllIllIIIIII = this.getConstPool().addUtf8Info(lllllllllllllIlIIIlIlllIllIIIIIl);
        ByteArray.write16bit(lllllllllllllIlIIIlIlllIllIIIIII, this.info, 0);
    }
    
    private static ClassType parseClassType(final String lllllllllllllIlIIIlIllIllllIlllI, final Cursor lllllllllllllIlIIIlIllIllllIllIl) throws BadBytecode {
        if (lllllllllllllIlIIIlIllIllllIlllI.charAt(lllllllllllllIlIIIlIllIllllIllIl.position) == 'L') {
            return parseClassType2(lllllllllllllIlIIIlIllIllllIlllI, lllllllllllllIlIIIlIllIllllIllIl, null);
        }
        throw error(lllllllllllllIlIIIlIllIllllIlllI);
    }
    
    private static ObjectType parseArray(final String lllllllllllllIlIIIlIllIllIllllIl, final Cursor lllllllllllllIlIIIlIllIllIllllII) throws BadBytecode {
        int lllllllllllllIlIIIlIllIllIlllllI = 1;
        while (lllllllllllllIlIIIlIllIllIllllIl.charAt(++lllllllllllllIlIIIlIllIllIllllII.position) == '[') {
            ++lllllllllllllIlIIIlIllIllIlllllI;
        }
        return new ArrayType(lllllllllllllIlIIIlIllIllIlllllI, parseType(lllllllllllllIlIIIlIllIllIllllIl, lllllllllllllIlIIIlIllIllIllllII));
    }
    
    public static class MethodSignature
    {
        /* synthetic */ TypeParameter[] typeParams;
        /* synthetic */ Type[] params;
        /* synthetic */ ObjectType[] exceptions;
        /* synthetic */ Type retType;
        
        public Type getReturnType() {
            return this.retType;
        }
        
        public Type[] getParameterTypes() {
            return this.params;
        }
        
        public String encode() {
            final StringBuffer lllllllllllllIIIIlllIIIllIlllIll = new StringBuffer();
            if (this.typeParams.length > 0) {
                lllllllllllllIIIIlllIIIllIlllIll.append('<');
                for (int lllllllllllllIIIIlllIIIllIllllll = 0; lllllllllllllIIIIlllIIIllIllllll < this.typeParams.length; ++lllllllllllllIIIIlllIIIllIllllll) {
                    this.typeParams[lllllllllllllIIIIlllIIIllIllllll].encode(lllllllllllllIIIIlllIIIllIlllIll);
                }
                lllllllllllllIIIIlllIIIllIlllIll.append('>');
            }
            lllllllllllllIIIIlllIIIllIlllIll.append('(');
            for (int lllllllllllllIIIIlllIIIllIlllllI = 0; lllllllllllllIIIIlllIIIllIlllllI < this.params.length; ++lllllllllllllIIIIlllIIIllIlllllI) {
                this.params[lllllllllllllIIIIlllIIIllIlllllI].encode(lllllllllllllIIIIlllIIIllIlllIll);
            }
            lllllllllllllIIIIlllIIIllIlllIll.append(')');
            this.retType.encode(lllllllllllllIIIIlllIIIllIlllIll);
            if (this.exceptions.length > 0) {
                for (int lllllllllllllIIIIlllIIIllIllllIl = 0; lllllllllllllIIIIlllIIIllIllllIl < this.exceptions.length; ++lllllllllllllIIIIlllIIIllIllllIl) {
                    lllllllllllllIIIIlllIIIllIlllIll.append('^');
                    this.exceptions[lllllllllllllIIIIlllIIIllIllllIl].encode(lllllllllllllIIIIlllIIIllIlllIll);
                }
            }
            return lllllllllllllIIIIlllIIIllIlllIll.toString();
        }
        
        public TypeParameter[] getTypeParameters() {
            return this.typeParams;
        }
        
        public ObjectType[] getExceptionTypes() {
            return this.exceptions;
        }
        
        public MethodSignature(final TypeParameter[] lllllllllllllIIIIlllIIIlllIlllIl, final Type[] lllllllllllllIIIIlllIIIlllIlllII, final Type lllllllllllllIIIIlllIIIlllIllIll, final ObjectType[] lllllllllllllIIIIlllIIIlllIlIlIl) {
            this.typeParams = ((lllllllllllllIIIIlllIIIlllIlllIl == null) ? new TypeParameter[0] : lllllllllllllIIIIlllIIIlllIlllIl);
            this.params = ((lllllllllllllIIIIlllIIIlllIlllII == null) ? new Type[0] : lllllllllllllIIIIlllIIIlllIlllII);
            this.retType = ((lllllllllllllIIIIlllIIIlllIllIll == null) ? new BaseType("void") : lllllllllllllIIIIlllIIIlllIllIll);
            this.exceptions = ((lllllllllllllIIIIlllIIIlllIlIlIl == null) ? new ObjectType[0] : lllllllllllllIIIIlllIIIlllIlIlIl);
        }
        
        @Override
        public String toString() {
            final StringBuffer lllllllllllllIIIIlllIIIlllIIIlIl = new StringBuffer();
            TypeParameter.toString(lllllllllllllIIIIlllIIIlllIIIlIl, this.typeParams);
            lllllllllllllIIIIlllIIIlllIIIlIl.append(" (");
            Type.toString(lllllllllllllIIIIlllIIIlllIIIlIl, this.params);
            lllllllllllllIIIIlllIIIlllIIIlIl.append(") ");
            lllllllllllllIIIIlllIIIlllIIIlIl.append(this.retType);
            if (this.exceptions.length > 0) {
                lllllllllllllIIIIlllIIIlllIIIlIl.append(" throws ");
                Type.toString(lllllllllllllIIIIlllIIIlllIIIlIl, this.exceptions);
            }
            return lllllllllllllIIIIlllIIIlllIIIlIl.toString();
        }
    }
    
    public static class TypeParameter
    {
        /* synthetic */ String name;
        /* synthetic */ ObjectType superClass;
        /* synthetic */ ObjectType[] superInterfaces;
        
        public String getName() {
            return this.name;
        }
        
        public ObjectType getClassBound() {
            return this.superClass;
        }
        
        void encode(final StringBuffer lllllllllllllllIIlIIlIIIlllllllI) {
            lllllllllllllllIIlIIlIIIlllllllI.append(this.name);
            if (this.superClass == null) {
                lllllllllllllllIIlIIlIIIlllllllI.append(":Ljava/lang/Object;");
            }
            else {
                lllllllllllllllIIlIIlIIIlllllllI.append(':');
                this.superClass.encode(lllllllllllllllIIlIIlIIIlllllllI);
            }
            for (int lllllllllllllllIIlIIlIIlIIIIIIlI = 0; lllllllllllllllIIlIIlIIlIIIIIIlI < this.superInterfaces.length; ++lllllllllllllllIIlIIlIIlIIIIIIlI) {
                lllllllllllllllIIlIIlIIIlllllllI.append(':');
                this.superInterfaces[lllllllllllllllIIlIIlIIlIIIIIIlI].encode(lllllllllllllllIIlIIlIIIlllllllI);
            }
        }
        
        @Override
        public String toString() {
            final StringBuffer lllllllllllllllIIlIIlIIlIIIlIlII = new StringBuffer(this.getName());
            if (this.superClass != null) {
                lllllllllllllllIIlIIlIIlIIIlIlII.append(" extends ").append(this.superClass.toString());
            }
            final int lllllllllllllllIIlIIlIIlIIIlIIll = this.superInterfaces.length;
            if (lllllllllllllllIIlIIlIIlIIIlIIll > 0) {
                for (int lllllllllllllllIIlIIlIIlIIIlIllI = 0; lllllllllllllllIIlIIlIIlIIIlIllI < lllllllllllllllIIlIIlIIlIIIlIIll; ++lllllllllllllllIIlIIlIIlIIIlIllI) {
                    if (lllllllllllllllIIlIIlIIlIIIlIllI > 0 || this.superClass != null) {
                        lllllllllllllllIIlIIlIIlIIIlIlII.append(" & ");
                    }
                    else {
                        lllllllllllllllIIlIIlIIlIIIlIlII.append(" extends ");
                    }
                    lllllllllllllllIIlIIlIIlIIIlIlII.append(this.superInterfaces[lllllllllllllllIIlIIlIIlIIIlIllI].toString());
                }
            }
            return lllllllllllllllIIlIIlIIlIIIlIlII.toString();
        }
        
        static void toString(final StringBuffer lllllllllllllllIIlIIlIIlIIIIlIII, final TypeParameter[] lllllllllllllllIIlIIlIIlIIIIIlll) {
            lllllllllllllllIIlIIlIIlIIIIlIII.append('<');
            for (int lllllllllllllllIIlIIlIIlIIIIlIll = 0; lllllllllllllllIIlIIlIIlIIIIlIll < lllllllllllllllIIlIIlIIlIIIIIlll.length; ++lllllllllllllllIIlIIlIIlIIIIlIll) {
                if (lllllllllllllllIIlIIlIIlIIIIlIll > 0) {
                    lllllllllllllllIIlIIlIIlIIIIlIII.append(", ");
                }
                lllllllllllllllIIlIIlIIlIIIIlIII.append(lllllllllllllllIIlIIlIIlIIIIIlll[lllllllllllllllIIlIIlIIlIIIIlIll]);
            }
            lllllllllllllllIIlIIlIIlIIIIlIII.append('>');
        }
        
        public TypeParameter(final String lllllllllllllllIIlIIlIIlIIllIIII, final ObjectType lllllllllllllllIIlIIlIIlIIlIlIll, final ObjectType[] lllllllllllllllIIlIIlIIlIIlIlllI) {
            this.name = lllllllllllllllIIlIIlIIlIIllIIII;
            this.superClass = lllllllllllllllIIlIIlIIlIIlIlIll;
            if (lllllllllllllllIIlIIlIIlIIlIlllI == null) {
                this.superInterfaces = new ObjectType[0];
            }
            else {
                this.superInterfaces = lllllllllllllllIIlIIlIIlIIlIlllI;
            }
        }
        
        TypeParameter(final String lllllllllllllllIIlIIlIIlIIlllIlI, final int lllllllllllllllIIlIIlIIlIIllllll, final int lllllllllllllllIIlIIlIIlIIlllllI, final ObjectType lllllllllllllllIIlIIlIIlIIllllIl, final ObjectType[] lllllllllllllllIIlIIlIIlIIllIllI) {
            this.name = lllllllllllllllIIlIIlIIlIIlllIlI.substring(lllllllllllllllIIlIIlIIlIIllllll, lllllllllllllllIIlIIlIIlIIlllllI);
            this.superClass = lllllllllllllllIIlIIlIIlIIllllIl;
            this.superInterfaces = lllllllllllllllIIlIIlIIlIIllIllI;
        }
        
        public ObjectType[] getInterfaceBound() {
            return this.superInterfaces;
        }
        
        public TypeParameter(final String lllllllllllllllIIlIIlIIlIIlIIllI) {
            this(lllllllllllllllIIlIIlIIlIIlIIllI, null, null);
        }
    }
    
    public abstract static class ObjectType extends Type
    {
        public String encode() {
            final StringBuffer lllllllllllllllIIIllIlIIIIIIIIIl = new StringBuffer();
            this.encode(lllllllllllllllIIIllIlIIIIIIIIIl);
            return lllllllllllllllIIIllIlIIIIIIIIIl.toString();
        }
    }
    
    public abstract static class Type
    {
        static void toString(final StringBuffer llIlIIllIIIIIII, final Type[] llIlIIlIlllllll) {
            for (int llIlIIllIIIIIll = 0; llIlIIllIIIIIll < llIlIIlIlllllll.length; ++llIlIIllIIIIIll) {
                if (llIlIIllIIIIIll > 0) {
                    llIlIIllIIIIIII.append(", ");
                }
                llIlIIllIIIIIII.append(llIlIIlIlllllll[llIlIIllIIIIIll]);
            }
        }
        
        abstract void encode(final StringBuffer p0);
        
        public String jvmTypeName() {
            return this.toString();
        }
    }
    
    public static class BaseType extends Type
    {
        /* synthetic */ char descriptor;
        
        @Override
        public String toString() {
            return Descriptor.toClassName(Character.toString(this.descriptor));
        }
        
        public CtClass getCtlass() {
            return Descriptor.toPrimitiveClass(this.descriptor);
        }
        
        public BaseType(final String llllllllllllIlllllIIIIlIIIllIIIl) {
            this(Descriptor.of(llllllllllllIlllllIIIIlIIIllIIIl).charAt(0));
        }
        
        @Override
        void encode(final StringBuffer llllllllllllIlllllIIIIlIIIlIIIlI) {
            llllllllllllIlllllIIIIlIIIlIIIlI.append(this.descriptor);
        }
        
        BaseType(final char llllllllllllIlllllIIIIlIIIlllIIl) {
            this.descriptor = llllllllllllIlllllIIIIlIIIlllIIl;
        }
        
        public char getDescriptor() {
            return this.descriptor;
        }
    }
    
    public static class TypeArgument
    {
        /* synthetic */ char wildcard;
        /* synthetic */ ObjectType arg;
        
        TypeArgument(final ObjectType lllllllllllllIlIlIIlIIlIIlIlIIIl, final char lllllllllllllIlIlIIlIIlIIlIlIIII) {
            this.arg = lllllllllllllIlIlIIlIIlIIlIlIIIl;
            this.wildcard = lllllllllllllIlIlIIlIIlIIlIlIIII;
        }
        
        @Override
        public String toString() {
            if (this.wildcard == '*') {
                return "?";
            }
            final String lllllllllllllIlIlIIlIIlIIIlIIlII = this.arg.toString();
            if (this.wildcard == ' ') {
                return lllllllllllllIlIlIIlIIlIIIlIIlII;
            }
            if (this.wildcard == '+') {
                return String.valueOf(new StringBuilder().append("? extends ").append(lllllllllllllIlIlIIlIIlIIIlIIlII));
            }
            return String.valueOf(new StringBuilder().append("? super ").append(lllllllllllllIlIlIIlIIlIIIlIIlII));
        }
        
        public static TypeArgument superOf(final ObjectType lllllllllllllIlIlIIlIIlIIlIIIIlI) {
            return new TypeArgument(lllllllllllllIlIlIIlIIlIIlIIIIlI, '-');
        }
        
        public static TypeArgument subclassOf(final ObjectType lllllllllllllIlIlIIlIIlIIlIIIlII) {
            return new TypeArgument(lllllllllllllIlIlIIlIIlIIlIIIlII, '+');
        }
        
        public ObjectType getType() {
            return this.arg;
        }
        
        static void encode(final StringBuffer lllllllllllllIlIlIIlIIlIIIIlIlII, final TypeArgument[] lllllllllllllIlIlIIlIIlIIIIlIIlI) {
            lllllllllllllIlIlIIlIIlIIIIlIlII.append('<');
            for (int lllllllllllllIlIlIIlIIlIIIIlIlIl = 0; lllllllllllllIlIlIIlIIlIIIIlIlIl < lllllllllllllIlIlIIlIIlIIIIlIIlI.length; ++lllllllllllllIlIlIIlIIlIIIIlIlIl) {
                final TypeArgument lllllllllllllIlIlIIlIIlIIIIlIlll = lllllllllllllIlIlIIlIIlIIIIlIIlI[lllllllllllllIlIlIIlIIlIIIIlIlIl];
                if (lllllllllllllIlIlIIlIIlIIIIlIlll.isWildcard()) {
                    lllllllllllllIlIlIIlIIlIIIIlIlII.append(lllllllllllllIlIlIIlIIlIIIIlIlll.wildcard);
                }
                if (lllllllllllllIlIlIIlIIlIIIIlIlll.getType() != null) {
                    lllllllllllllIlIlIIlIIlIIIIlIlll.getType().encode(lllllllllllllIlIlIIlIIlIIIIlIlII);
                }
            }
            lllllllllllllIlIlIIlIIlIIIIlIlII.append('>');
        }
        
        public TypeArgument() {
            this(null, '*');
        }
        
        public TypeArgument(final ObjectType lllllllllllllIlIlIIlIIlIIlIIlIlI) {
            this(lllllllllllllIlIlIIlIIlIIlIIlIlI, ' ');
        }
        
        public char getKind() {
            return this.wildcard;
        }
        
        public boolean isWildcard() {
            return this.wildcard != ' ';
        }
    }
    
    public static class ClassType extends ObjectType
    {
        public static /* synthetic */ ClassType OBJECT;
        /* synthetic */ String name;
        /* synthetic */ TypeArgument[] arguments;
        
        static ClassType make(final String lllllllllllllllIllIllIlIIIIlIIIl, final int lllllllllllllllIllIllIlIIIIlIIII, final int lllllllllllllllIllIllIlIIIIIIlll, final TypeArgument[] lllllllllllllllIllIllIlIIIIIlllI, final ClassType lllllllllllllllIllIllIlIIIIIllIl) {
            if (lllllllllllllllIllIllIlIIIIIllIl == null) {
                return new ClassType(lllllllllllllllIllIllIlIIIIlIIIl, lllllllllllllllIllIllIlIIIIlIIII, lllllllllllllllIllIllIlIIIIIIlll, lllllllllllllllIllIllIlIIIIIlllI);
            }
            return new NestedClassType(lllllllllllllllIllIllIlIIIIlIIIl, lllllllllllllllIllIllIlIIIIlIIII, lllllllllllllllIllIllIlIIIIIIlll, lllllllllllllllIllIllIlIIIIIlllI, lllllllllllllllIllIllIlIIIIIllIl);
        }
        
        @Override
        public String toString() {
            final StringBuffer lllllllllllllllIllIllIIllIllIlIl = new StringBuffer();
            final ClassType lllllllllllllllIllIllIIllIllIIll = this.getDeclaringClass();
            if (lllllllllllllllIllIllIIllIllIIll != null) {
                lllllllllllllllIllIllIIllIllIlIl.append(lllllllllllllllIllIllIIllIllIIll.toString()).append('.');
            }
            return this.toString2(lllllllllllllllIllIllIIllIllIlIl);
        }
        
        @Override
        void encode(final StringBuffer lllllllllllllllIllIllIIllIIIlllI) {
            lllllllllllllllIllIllIIllIIIlllI.append('L');
            this.encode2(lllllllllllllllIllIllIIllIIIlllI);
            lllllllllllllllIllIllIIllIIIlllI.append(';');
        }
        
        void encode2(final StringBuffer lllllllllllllllIllIllIIllIIIIlII) {
            final ClassType lllllllllllllllIllIllIIllIIIIllI = this.getDeclaringClass();
            if (lllllllllllllllIllIllIIllIIIIllI != null) {
                lllllllllllllllIllIllIIllIIIIllI.encode2(lllllllllllllllIllIllIIllIIIIlII);
                lllllllllllllllIllIllIIllIIIIlII.append('$');
            }
            lllllllllllllllIllIllIIllIIIIlII.append(this.name.replace('.', '/'));
            if (this.arguments != null) {
                TypeArgument.encode(lllllllllllllllIllIllIIllIIIIlII, this.arguments);
            }
        }
        
        @Override
        public String jvmTypeName() {
            final StringBuffer lllllllllllllllIllIllIIllIIlIllI = new StringBuffer();
            final ClassType lllllllllllllllIllIllIIllIIlIlIl = this.getDeclaringClass();
            if (lllllllllllllllIllIllIIllIIlIlIl != null) {
                lllllllllllllllIllIllIIllIIlIllI.append(lllllllllllllllIllIllIIllIIlIlIl.jvmTypeName()).append('$');
            }
            return this.toString2(lllllllllllllllIllIllIIllIIlIllI);
        }
        
        public String getName() {
            return this.name;
        }
        
        public TypeArgument[] getTypeArguments() {
            return this.arguments;
        }
        
        public ClassType getDeclaringClass() {
            return null;
        }
        
        static {
            ClassType.OBJECT = new ClassType("java.lang.Object", null);
        }
        
        ClassType(final String lllllllllllllllIllIllIIlllllIIII, final int lllllllllllllllIllIllIIlllllIlII, final int lllllllllllllllIllIllIIlllllIIll, final TypeArgument[] lllllllllllllllIllIllIIlllllIIlI) {
            this.name = lllllllllllllllIllIllIIlllllIIII.substring(lllllllllllllllIllIllIIlllllIlII, lllllllllllllllIllIllIIlllllIIll).replace('/', '.');
            this.arguments = lllllllllllllllIllIllIIlllllIIlI;
        }
        
        public ClassType(final String lllllllllllllllIllIllIIlllIlIIIl) {
            this(lllllllllllllllIllIllIIlllIlIIIl, null);
        }
        
        private String toString2(final StringBuffer lllllllllllllllIllIllIIllIIlllll) {
            lllllllllllllllIllIllIIllIIlllll.append(this.name);
            if (this.arguments != null) {
                lllllllllllllllIllIllIIllIIlllll.append('<');
                for (int lllllllllllllllIllIllIIllIlIIIIl = this.arguments.length, lllllllllllllllIllIllIIllIlIIIlI = 0; lllllllllllllllIllIllIIllIlIIIlI < lllllllllllllllIllIllIIllIlIIIIl; ++lllllllllllllllIllIllIIllIlIIIlI) {
                    if (lllllllllllllllIllIllIIllIlIIIlI > 0) {
                        lllllllllllllllIllIllIIllIIlllll.append(", ");
                    }
                    lllllllllllllllIllIllIIllIIlllll.append(this.arguments[lllllllllllllllIllIllIIllIlIIIlI].toString());
                }
                lllllllllllllllIllIllIIllIIlllll.append('>');
            }
            return lllllllllllllllIllIllIIllIIlllll.toString();
        }
        
        public ClassType(final String lllllllllllllllIllIllIIlllIlllIl, final TypeArgument[] lllllllllllllllIllIllIIlllIllIll) {
            this.name = lllllllllllllllIllIllIIlllIlllIl;
            this.arguments = lllllllllllllllIllIllIIlllIllIll;
        }
    }
    
    public static class NestedClassType extends ClassType
    {
        /* synthetic */ ClassType parent;
        
        public NestedClassType(final ClassType lllllllllllllIlIIIIllIIIlllIllll, final String lllllllllllllIlIIIIllIIIlllIlllI, final TypeArgument[] lllllllllllllIlIIIIllIIIlllIllIl) {
            super(lllllllllllllIlIIIIllIIIlllIlllI, lllllllllllllIlIIIIllIIIlllIllIl);
            this.parent = lllllllllllllIlIIIIllIIIlllIllll;
        }
        
        NestedClassType(final String lllllllllllllIlIIIIllIIIllllllIl, final int lllllllllllllIlIIIIllIIIllllllII, final int lllllllllllllIlIIIIllIIlIIIIIIIl, final TypeArgument[] lllllllllllllIlIIIIllIIlIIIIIIII, final ClassType lllllllllllllIlIIIIllIIIllllllll) {
            super(lllllllllllllIlIIIIllIIIllllllIl, lllllllllllllIlIIIIllIIIllllllII, lllllllllllllIlIIIIllIIlIIIIIIIl, lllllllllllllIlIIIIllIIlIIIIIIII);
            this.parent = lllllllllllllIlIIIIllIIIllllllll;
        }
        
        @Override
        public ClassType getDeclaringClass() {
            return this.parent;
        }
    }
    
    public static class ClassSignature
    {
        /* synthetic */ ClassType[] interfaces;
        /* synthetic */ ClassType superClass;
        /* synthetic */ TypeParameter[] params;
        
        public ClassType getSuperClass() {
            return this.superClass;
        }
        
        public ClassSignature(final TypeParameter[] lllllllllllllIlllllIIIIlIIllIllI, final ClassType lllllllllllllIlllllIIIIlIIllIlIl, final ClassType[] lllllllllllllIlllllIIIIlIIllIlII) {
            this.params = ((lllllllllllllIlllllIIIIlIIllIllI == null) ? new TypeParameter[0] : lllllllllllllIlllllIIIIlIIllIllI);
            this.superClass = ((lllllllllllllIlllllIIIIlIIllIlIl == null) ? ClassType.OBJECT : lllllllllllllIlllllIIIIlIIllIlIl);
            this.interfaces = ((lllllllllllllIlllllIIIIlIIllIlII == null) ? new ClassType[0] : lllllllllllllIlllllIIIIlIIllIlII);
        }
        
        public ClassSignature(final TypeParameter[] lllllllllllllIlllllIIIIlIIllIIII) {
            this(lllllllllllllIlllllIIIIlIIllIIII, null, null);
        }
        
        @Override
        public String toString() {
            final StringBuffer lllllllllllllIlllllIIIIlIIlIIIIl = new StringBuffer();
            TypeParameter.toString(lllllllllllllIlllllIIIIlIIlIIIIl, this.params);
            lllllllllllllIlllllIIIIlIIlIIIIl.append(" extends ").append(this.superClass);
            if (this.interfaces.length > 0) {
                lllllllllllllIlllllIIIIlIIlIIIIl.append(" implements ");
                Type.toString(lllllllllllllIlllllIIIIlIIlIIIIl, this.interfaces);
            }
            return lllllllllllllIlllllIIIIlIIlIIIIl.toString();
        }
        
        public TypeParameter[] getParameters() {
            return this.params;
        }
        
        public ClassType[] getInterfaces() {
            return this.interfaces;
        }
        
        public String encode() {
            final StringBuffer lllllllllllllIlllllIIIIlIIIllIII = new StringBuffer();
            if (this.params.length > 0) {
                lllllllllllllIlllllIIIIlIIIllIII.append('<');
                for (int lllllllllllllIlllllIIIIlIIIllIll = 0; lllllllllllllIlllllIIIIlIIIllIll < this.params.length; ++lllllllllllllIlllllIIIIlIIIllIll) {
                    this.params[lllllllllllllIlllllIIIIlIIIllIll].encode(lllllllllllllIlllllIIIIlIIIllIII);
                }
                lllllllllllllIlllllIIIIlIIIllIII.append('>');
            }
            this.superClass.encode(lllllllllllllIlllllIIIIlIIIllIII);
            for (int lllllllllllllIlllllIIIIlIIIllIlI = 0; lllllllllllllIlllllIIIIlIIIllIlI < this.interfaces.length; ++lllllllllllllIlllllIIIIlIIIllIlI) {
                this.interfaces[lllllllllllllIlllllIIIIlIIIllIlI].encode(lllllllllllllIlllllIIIIlIIIllIII);
            }
            return lllllllllllllIlllllIIIIlIIIllIII.toString();
        }
    }
    
    private static class Cursor
    {
        /* synthetic */ int position;
        
        int indexOf(final String lllllllllllllIlIIIIIIlllIIIIllIl, final int lllllllllllllIlIIIIIIlllIIIIllII) throws BadBytecode {
            final int lllllllllllllIlIIIIIIlllIIIIllll = lllllllllllllIlIIIIIIlllIIIIllIl.indexOf(lllllllllllllIlIIIIIIlllIIIIllII, this.position);
            if (lllllllllllllIlIIIIIIlllIIIIllll < 0) {
                throw error(lllllllllllllIlIIIIIIlllIIIIllIl);
            }
            this.position = lllllllllllllIlIIIIIIlllIIIIllll + 1;
            return lllllllllllllIlIIIIIIlllIIIIllll;
        }
        
        private Cursor() {
            this.position = 0;
        }
    }
    
    public static class ArrayType extends ObjectType
    {
        /* synthetic */ int dim;
        /* synthetic */ Type componentType;
        
        @Override
        void encode(final StringBuffer lllllllllllllIIIlIIlIIIIllIIIIll) {
            for (int lllllllllllllIIIlIIlIIIIllIIIlIl = 0; lllllllllllllIIIlIIlIIIIllIIIlIl < this.dim; ++lllllllllllllIIIlIIlIIIIllIIIlIl) {
                lllllllllllllIIIlIIlIIIIllIIIIll.append('[');
            }
            this.componentType.encode(lllllllllllllIIIlIIlIIIIllIIIIll);
        }
        
        public ArrayType(final int lllllllllllllIIIlIIlIIIIllIlllII, final Type lllllllllllllIIIlIIlIIIIllIllIII) {
            this.dim = lllllllllllllIIIlIIlIIIIllIlllII;
            this.componentType = lllllllllllllIIIlIIlIIIIllIllIII;
        }
        
        public int getDimension() {
            return this.dim;
        }
        
        public Type getComponentType() {
            return this.componentType;
        }
        
        @Override
        public String toString() {
            final StringBuffer lllllllllllllIIIlIIlIIIIllIIllII = new StringBuffer(this.componentType.toString());
            for (int lllllllllllllIIIlIIlIIIIllIIlllI = 0; lllllllllllllIIIlIIlIIIIllIIlllI < this.dim; ++lllllllllllllIIIlIIlIIIIllIIlllI) {
                lllllllllllllIIIlIIlIIIIllIIllII.append("[]");
            }
            return lllllllllllllIIIlIIlIIIIllIIllII.toString();
        }
    }
    
    public static class TypeVariable extends ObjectType
    {
        /* synthetic */ String name;
        
        @Override
        void encode(final StringBuffer lllllllllllllIllIlllIIIIlIIlIIlI) {
            lllllllllllllIllIlllIIIIlIIlIIlI.append('T').append(this.name).append(';');
        }
        
        public TypeVariable(final String lllllllllllllIllIlllIIIIlIIllllI) {
            this.name = lllllllllllllIllIlllIIIIlIIllllI;
        }
        
        TypeVariable(final String lllllllllllllIllIlllIIIIlIlIlIlI, final int lllllllllllllIllIlllIIIIlIlIIlIl, final int lllllllllllllIllIlllIIIIlIlIIlII) {
            this.name = lllllllllllllIllIlllIIIIlIlIlIlI.substring(lllllllllllllIllIlllIIIIlIlIIlIl, lllllllllllllIllIlllIIIIlIlIIlII);
        }
        
        public String getName() {
            return this.name;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
    }
}
