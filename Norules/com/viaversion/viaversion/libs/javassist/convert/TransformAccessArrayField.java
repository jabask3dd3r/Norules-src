package com.viaversion.viaversion.libs.javassist.convert;

import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.bytecode.analysis.*;

public final class TransformAccessArrayField extends Transformer
{
    private /* synthetic */ Frame[] frames;
    private final /* synthetic */ CodeConverter.ArrayAccessReplacementMethodNames names;
    private final /* synthetic */ String methodClassname;
    private /* synthetic */ int offset;
    
    private int updatePos(final int lllllllllllllIlIllIIIIlIIIIIlllI, final int lllllllllllllIlIllIIIIlIIIIlIIII) {
        if (this.offset > -1) {
            this.offset += lllllllllllllIlIllIIIIlIIIIlIIII;
        }
        return lllllllllllllIlIllIIIIlIIIIIlllI + lllllllllllllIlIllIIIIlIIIIlIIII;
    }
    
    public TransformAccessArrayField(final Transformer lllllllllllllIlIllIIIIlIIlIIIlll, final String lllllllllllllIlIllIIIIlIIlIIlIlI, final CodeConverter.ArrayAccessReplacementMethodNames lllllllllllllIlIllIIIIlIIlIIIlIl) throws NotFoundException {
        super(lllllllllllllIlIllIIIIlIIlIIIlll);
        this.methodClassname = lllllllllllllIlIllIIIIlIIlIIlIlI;
        this.names = lllllllllllllIlIllIIIIlIIlIIIlIl;
    }
    
    private int replace(final ConstPool lllllllllllllIlIllIIIIIllllIIlll, final CodeIterator lllllllllllllIlIllIIIIIllllIIllI, int lllllllllllllIlIllIIIIIllllIIlIl, final int lllllllllllllIlIllIIIIIllllIIlII, final String lllllllllllllIlIllIIIIIllllIIIll) throws BadBytecode {
        String lllllllllllllIlIllIIIIIllllIlIlI = null;
        final String lllllllllllllIlIllIIIIIllllIlIIl = this.getMethodName(lllllllllllllIlIllIIIIIllllIIlII);
        if (lllllllllllllIlIllIIIIIllllIlIIl != null) {
            if (lllllllllllllIlIllIIIIIllllIIlII == 50) {
                lllllllllllllIlIllIIIIIllllIlIlI = this.getTopType(lllllllllllllIlIllIIIIIllllIIllI.lookAhead());
                if (lllllllllllllIlIllIIIIIllllIlIlI == null) {
                    return lllllllllllllIlIllIIIIIllllIIlIl;
                }
                if ("java/lang/Object".equals(lllllllllllllIlIllIIIIIllllIlIlI)) {
                    lllllllllllllIlIllIIIIIllllIlIlI = null;
                }
            }
            lllllllllllllIlIllIIIIIllllIIllI.writeByte(0, lllllllllllllIlIllIIIIIllllIIlIl);
            final CodeIterator.Gap lllllllllllllIlIllIIIIIlllllIIll = lllllllllllllIlIllIIIIIllllIIllI.insertGapAt(lllllllllllllIlIllIIIIIllllIIlIl, (lllllllllllllIlIllIIIIIllllIlIlI != null) ? 5 : 2, false);
            lllllllllllllIlIllIIIIIllllIIlIl = lllllllllllllIlIllIIIIIlllllIIll.position;
            final int lllllllllllllIlIllIIIIIlllllIIlI = lllllllllllllIlIllIIIIIllllIIlll.addClassInfo(this.methodClassname);
            final int lllllllllllllIlIllIIIIIlllllIIIl = lllllllllllllIlIllIIIIIllllIIlll.addMethodrefInfo(lllllllllllllIlIllIIIIIlllllIIlI, lllllllllllllIlIllIIIIIllllIlIIl, lllllllllllllIlIllIIIIIllllIIIll);
            lllllllllllllIlIllIIIIIllllIIllI.writeByte(184, lllllllllllllIlIllIIIIIllllIIlIl);
            lllllllllllllIlIllIIIIIllllIIllI.write16bit(lllllllllllllIlIllIIIIIlllllIIIl, lllllllllllllIlIllIIIIIllllIIlIl + 1);
            if (lllllllllllllIlIllIIIIIllllIlIlI != null) {
                final int lllllllllllllIlIllIIIIIlllllIlII = lllllllllllllIlIllIIIIIllllIIlll.addClassInfo(lllllllllllllIlIllIIIIIllllIlIlI);
                lllllllllllllIlIllIIIIIllllIIllI.writeByte(192, lllllllllllllIlIllIIIIIllllIIlIl + 3);
                lllllllllllllIlIllIIIIIllllIIllI.write16bit(lllllllllllllIlIllIIIIIlllllIlII, lllllllllllllIlIllIIIIIllllIIlIl + 4);
            }
            lllllllllllllIlIllIIIIIllllIIlIl = this.updatePos(lllllllllllllIlIllIIIIIllllIIlIl, lllllllllllllIlIllIIIIIlllllIIll.length);
        }
        return lllllllllllllIlIllIIIIIllllIIlIl;
    }
    
    @Override
    public void initialize(final ConstPool lllllllllllllIlIllIIIIlIIIllIlII, final CtClass lllllllllllllIlIllIIIIlIIIllIIll, final MethodInfo lllllllllllllIlIllIIIIlIIIllIIlI) throws CannotCompileException {
        final CodeIterator lllllllllllllIlIllIIIIlIIIllIllI = lllllllllllllIlIllIIIIlIIIllIIlI.getCodeAttribute().iterator();
        while (lllllllllllllIlIllIIIIlIIIllIllI.hasNext()) {
            try {
                int lllllllllllllIlIllIIIIlIIIllllIl = lllllllllllllIlIllIIIIlIIIllIllI.next();
                final int lllllllllllllIlIllIIIIlIIIllllII = lllllllllllllIlIllIIIIlIIIllIllI.byteAt(lllllllllllllIlIllIIIIlIIIllllIl);
                if (lllllllllllllIlIllIIIIlIIIllllII == 50) {
                    this.initFrames(lllllllllllllIlIllIIIIlIIIllIIll, lllllllllllllIlIllIIIIlIIIllIIlI);
                }
                if (lllllllllllllIlIllIIIIlIIIllllII == 50 || lllllllllllllIlIllIIIIlIIIllllII == 51 || lllllllllllllIlIllIIIIlIIIllllII == 52 || lllllllllllllIlIllIIIIlIIIllllII == 49 || lllllllllllllIlIllIIIIlIIIllllII == 48 || lllllllllllllIlIllIIIIlIIIllllII == 46 || lllllllllllllIlIllIIIIlIIIllllII == 47 || lllllllllllllIlIllIIIIlIIIllllII == 53) {
                    lllllllllllllIlIllIIIIlIIIllllIl = this.replace(lllllllllllllIlIllIIIIlIIIllIlII, lllllllllllllIlIllIIIIlIIIllIllI, lllllllllllllIlIllIIIIlIIIllllIl, lllllllllllllIlIllIIIIlIIIllllII, this.getLoadReplacementSignature(lllllllllllllIlIllIIIIlIIIllllII));
                }
                else {
                    if (lllllllllllllIlIllIIIIlIIIllllII != 83 && lllllllllllllIlIllIIIIlIIIllllII != 84 && lllllllllllllIlIllIIIIlIIIllllII != 85 && lllllllllllllIlIllIIIIlIIIllllII != 82 && lllllllllllllIlIllIIIIlIIIllllII != 81 && lllllllllllllIlIllIIIIlIIIllllII != 79 && lllllllllllllIlIllIIIIlIIIllllII != 80 && lllllllllllllIlIllIIIIlIIIllllII != 86) {
                        continue;
                    }
                    lllllllllllllIlIllIIIIlIIIllllIl = this.replace(lllllllllllllIlIllIIIIlIIIllIlII, lllllllllllllIlIllIIIIlIIIllIllI, lllllllllllllIlIllIIIIlIIIllllIl, lllllllllllllIlIllIIIIlIIIllllII, this.getStoreReplacementSignature(lllllllllllllIlIllIIIIlIIIllllII));
                }
                continue;
            }
            catch (Exception lllllllllllllIlIllIIIIlIIIlllIll) {
                throw new CannotCompileException(lllllllllllllIlIllIIIIlIIIlllIll);
            }
            break;
        }
    }
    
    private String getMethodName(final int lllllllllllllIlIllIIIIIlllIlIlIl) {
        String lllllllllllllIlIllIIIIIlllIlIlll = null;
        switch (lllllllllllllIlIllIIIIIlllIlIlIl) {
            case 50: {
                lllllllllllllIlIllIIIIIlllIlIlll = this.names.objectRead();
                break;
            }
            case 51: {
                lllllllllllllIlIllIIIIIlllIlIlll = this.names.byteOrBooleanRead();
                break;
            }
            case 52: {
                lllllllllllllIlIllIIIIIlllIlIlll = this.names.charRead();
                break;
            }
            case 49: {
                lllllllllllllIlIllIIIIIlllIlIlll = this.names.doubleRead();
                break;
            }
            case 48: {
                lllllllllllllIlIllIIIIIlllIlIlll = this.names.floatRead();
                break;
            }
            case 46: {
                lllllllllllllIlIllIIIIIlllIlIlll = this.names.intRead();
                break;
            }
            case 53: {
                lllllllllllllIlIllIIIIIlllIlIlll = this.names.shortRead();
                break;
            }
            case 47: {
                lllllllllllllIlIllIIIIIlllIlIlll = this.names.longRead();
                break;
            }
            case 83: {
                lllllllllllllIlIllIIIIIlllIlIlll = this.names.objectWrite();
                break;
            }
            case 84: {
                lllllllllllllIlIllIIIIIlllIlIlll = this.names.byteOrBooleanWrite();
                break;
            }
            case 85: {
                lllllllllllllIlIllIIIIIlllIlIlll = this.names.charWrite();
                break;
            }
            case 82: {
                lllllllllllllIlIllIIIIIlllIlIlll = this.names.doubleWrite();
                break;
            }
            case 81: {
                lllllllllllllIlIllIIIIIlllIlIlll = this.names.floatWrite();
                break;
            }
            case 79: {
                lllllllllllllIlIllIIIIIlllIlIlll = this.names.intWrite();
                break;
            }
            case 86: {
                lllllllllllllIlIllIIIIIlllIlIlll = this.names.shortWrite();
                break;
            }
            case 80: {
                lllllllllllllIlIllIIIIIlllIlIlll = this.names.longWrite();
                break;
            }
        }
        if (lllllllllllllIlIllIIIIIlllIlIlll.equals("")) {
            lllllllllllllIlIllIIIIIlllIlIlll = null;
        }
        return lllllllllllllIlIllIIIIIlllIlIlll;
    }
    
    private String getTopType(final int lllllllllllllIlIllIIIIlIIIIIIlll) throws BadBytecode {
        final Frame lllllllllllllIlIllIIIIlIIIIIIllI = this.getFrame(lllllllllllllIlIllIIIIlIIIIIIlll);
        if (lllllllllllllIlIllIIIIlIIIIIIllI == null) {
            return null;
        }
        final CtClass lllllllllllllIlIllIIIIlIIIIIIlIl = lllllllllllllIlIllIIIIlIIIIIIllI.peek().getCtClass();
        return (lllllllllllllIlIllIIIIlIIIIIIlIl != null) ? Descriptor.toJvmName(lllllllllllllIlIllIIIIlIIIIIIlIl) : null;
    }
    
    @Override
    public void clean() {
        this.frames = null;
        this.offset = -1;
    }
    
    private String getLoadReplacementSignature(final int lllllllllllllIlIllIIIIIlllIlIIIl) throws BadBytecode {
        switch (lllllllllllllIlIllIIIIIlllIlIIIl) {
            case 50: {
                return "(Ljava/lang/Object;I)Ljava/lang/Object;";
            }
            case 51: {
                return "(Ljava/lang/Object;I)B";
            }
            case 52: {
                return "(Ljava/lang/Object;I)C";
            }
            case 49: {
                return "(Ljava/lang/Object;I)D";
            }
            case 48: {
                return "(Ljava/lang/Object;I)F";
            }
            case 46: {
                return "(Ljava/lang/Object;I)I";
            }
            case 53: {
                return "(Ljava/lang/Object;I)S";
            }
            case 47: {
                return "(Ljava/lang/Object;I)J";
            }
            default: {
                throw new BadBytecode(lllllllllllllIlIllIIIIIlllIlIIIl);
            }
        }
    }
    
    private Frame getFrame(final int lllllllllllllIlIllIIIIlIIIIlllll) throws BadBytecode {
        return this.frames[lllllllllllllIlIllIIIIlIIIIlllll - this.offset];
    }
    
    private String getStoreReplacementSignature(final int lllllllllllllIlIllIIIIIlllIIllII) throws BadBytecode {
        switch (lllllllllllllIlIllIIIIIlllIIllII) {
            case 83: {
                return "(Ljava/lang/Object;ILjava/lang/Object;)V";
            }
            case 84: {
                return "(Ljava/lang/Object;IB)V";
            }
            case 85: {
                return "(Ljava/lang/Object;IC)V";
            }
            case 82: {
                return "(Ljava/lang/Object;ID)V";
            }
            case 81: {
                return "(Ljava/lang/Object;IF)V";
            }
            case 79: {
                return "(Ljava/lang/Object;II)V";
            }
            case 86: {
                return "(Ljava/lang/Object;IS)V";
            }
            case 80: {
                return "(Ljava/lang/Object;IJ)V";
            }
            default: {
                throw new BadBytecode(lllllllllllllIlIllIIIIIlllIIllII);
            }
        }
    }
    
    private void initFrames(final CtClass lllllllllllllIlIllIIIIlIIIIlIlll, final MethodInfo lllllllllllllIlIllIIIIlIIIIlIllI) throws BadBytecode {
        if (this.frames == null) {
            this.frames = new Analyzer().analyze(lllllllllllllIlIllIIIIlIIIIlIlll, lllllllllllllIlIllIIIIlIIIIlIllI);
            this.offset = 0;
        }
    }
    
    @Override
    public int transform(final CtClass lllllllllllllIlIllIIIIlIIIlIlIIl, final int lllllllllllllIlIllIIIIlIIIlIIlIl, final CodeIterator lllllllllllllIlIllIIIIlIIIlIIlll, final ConstPool lllllllllllllIlIllIIIIlIIIlIIllI) throws BadBytecode {
        return lllllllllllllIlIllIIIIlIIIlIIlIl;
    }
}
