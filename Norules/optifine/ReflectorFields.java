package optifine;

public class ReflectorFields
{
    private /* synthetic */ int fieldCount;
    private /* synthetic */ Class fieldType;
    private /* synthetic */ ReflectorField[] reflectorFields;
    private /* synthetic */ ReflectorClass reflectorClass;
    
    public ReflectorClass getReflectorClass() {
        return this.reflectorClass;
    }
    
    public Class getFieldType() {
        return this.fieldType;
    }
    
    public ReflectorField getReflectorField(final int lllllllllllllIIIIIlIIlllIIIlllll) {
        return (lllllllllllllIIIIIlIIlllIIIlllll >= 0 && lllllllllllllIIIIIlIIlllIIIlllll < this.reflectorFields.length) ? this.reflectorFields[lllllllllllllIIIIIlIIlllIIIlllll] : null;
    }
    
    public int getFieldCount() {
        return this.fieldCount;
    }
    
    public ReflectorFields(final ReflectorClass lllllllllllllIIIIIlIIlllIIllIIIl, final Class lllllllllllllIIIIIlIIlllIIllIlIl, final int lllllllllllllIIIIIlIIlllIIllIlII) {
        this.reflectorClass = lllllllllllllIIIIIlIIlllIIllIIIl;
        this.fieldType = lllllllllllllIIIIIlIIlllIIllIlIl;
        if (lllllllllllllIIIIIlIIlllIIllIIIl.exists() && lllllllllllllIIIIIlIIlllIIllIlIl != null) {
            this.reflectorFields = new ReflectorField[lllllllllllllIIIIIlIIlllIIllIlII];
            for (int lllllllllllllIIIIIlIIlllIIllIIll = 0; lllllllllllllIIIIIlIIlllIIllIIll < this.reflectorFields.length; ++lllllllllllllIIIIIlIIlllIIllIIll) {
                this.reflectorFields[lllllllllllllIIIIIlIIlllIIllIIll] = new ReflectorField(lllllllllllllIIIIIlIIlllIIllIIIl, lllllllllllllIIIIIlIIlllIIllIlIl, lllllllllllllIIIIIlIIlllIIllIIll);
            }
        }
    }
}
