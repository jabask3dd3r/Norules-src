package shadersmod.client;

public class ShaderLine
{
    private /* synthetic */ int type;
    private /* synthetic */ String line;
    private /* synthetic */ String name;
    private /* synthetic */ String value;
    
    public String getValue() {
        return this.value;
    }
    
    public boolean isConstInt(final String llllllllllllllIlIIIIllllllllIIII) {
        return this.isConstInt() && llllllllllllllIlIIIIllllllllIIII.equals(this.name);
    }
    
    public boolean isConstBool(final String llllllllllllllIlIIIIlllllIlIlIIl, final String llllllllllllllIlIIIIlllllIlIIlII, final boolean llllllllllllllIlIIIIlllllIlIIIll) {
        return this.isConstBool(llllllllllllllIlIIIIlllllIlIlIIl, llllllllllllllIlIIIIlllllIlIIlII) && this.getValueBool() == llllllllllllllIlIIIIlllllIlIIIll;
    }
    
    public ShaderLine(final int llllllllllllllIlIIIlIIIIIIllIlIl, final String llllllllllllllIlIIIlIIIIIIllIIll, final String llllllllllllllIlIIIlIIIIIIllIIIl, final String llllllllllllllIlIIIlIIIIIIlIlIlI) {
        this.type = llllllllllllllIlIIIlIIIIIIllIlIl;
        this.name = llllllllllllllIlIIIlIIIIIIllIIll;
        this.value = llllllllllllllIlIIIlIIIIIIllIIIl;
        this.line = llllllllllllllIlIIIlIIIIIIlIlIlI;
    }
    
    public boolean isConstBool() {
        return this.type == 5;
    }
    
    public boolean isConstBool(final String llllllllllllllIlIIIIlllllIllIIII, final boolean llllllllllllllIlIIIIlllllIlIllll) {
        return this.isConstBool(llllllllllllllIlIIIIlllllIllIIII) && this.getValueBool() == llllllllllllllIlIIIIlllllIlIllll;
    }
    
    public boolean isConstBoolSuffix(final String llllllllllllllIlIIIIllllllIllIII) {
        return this.isConstBool() && this.name.endsWith(llllllllllllllIlIIIIllllllIllIII);
    }
    
    static {
        TYPE_CONST_FLOAT = 4;
        TYPE_UNIFORM = 1;
        TYPE_CONST_INT = 3;
        TYPE_CONST_BOOL = 5;
        TYPE_COMMENT = 2;
    }
    
    public boolean isComment(final String llllllllllllllIlIIIIllllllllIlIl, final String llllllllllllllIlIIIIllllllllIlII) {
        return this.isComment(llllllllllllllIlIIIIllllllllIlIl) && llllllllllllllIlIIIIllllllllIlII.equals(this.value);
    }
    
    public boolean isConstFloat(final String llllllllllllllIlIIIIlllllllIIIlI) {
        return this.isConstFloat() && llllllllllllllIlIIIIlllllllIIIlI.equals(this.name);
    }
    
    public boolean isConstBoolSuffix(final String llllllllllllllIlIIIIllllllIIlllI, final boolean llllllllllllllIlIIIIllllllIIllIl) {
        return this.isConstBoolSuffix(llllllllllllllIlIIIIllllllIIlllI) && this.getValueBool() == llllllllllllllIlIIIIllllllIIllIl;
    }
    
    public float getValueFloat() {
        try {
            return Float.parseFloat(this.value);
        }
        catch (NumberFormatException llllllllllllllIlIIIIllllIlllllII) {
            throw new NumberFormatException(String.valueOf(new StringBuilder("Invalid float: ").append(this.value).append(", line: ").append(this.line)));
        }
    }
    
    public boolean isUniform(final String llllllllllllllIlIIIlIIIIIIIIllll) {
        return this.isUniform() && llllllllllllllIlIIIlIIIIIIIIllll.equals(this.name);
    }
    
    public boolean isConstInt() {
        return this.type == 3;
    }
    
    public boolean isConstIntSuffix(final String llllllllllllllIlIIIIlllllllIlIlI) {
        return this.isConstInt() && this.name.endsWith(llllllllllllllIlIIIIlllllllIlIlI);
    }
    
    public String getName() {
        return this.name;
    }
    
    public boolean isComment() {
        return this.type == 2;
    }
    
    public boolean isConstBool(final String llllllllllllllIlIIIIllllllIlllII) {
        return this.isConstBool() && llllllllllllllIlIIIIllllllIlllII.equals(this.name);
    }
    
    public int getType() {
        return this.type;
    }
    
    public boolean isConstFloat() {
        return this.type == 4;
    }
    
    public boolean isUniform() {
        return this.type == 1;
    }
    
    public boolean isConstBool(final String llllllllllllllIlIIIIllllllIIlIII, final String llllllllllllllIlIIIIllllllIIIlII) {
        return this.isConstBool(llllllllllllllIlIIIIllllllIIlIII) || this.isConstBool(llllllllllllllIlIIIIllllllIIIlII);
    }
    
    public boolean isConstBool(final String llllllllllllllIlIIIIlllllIIlIlll, final String llllllllllllllIlIIIIlllllIIllIll, final String llllllllllllllIlIIIIlllllIIllIlI, final boolean llllllllllllllIlIIIIlllllIIlIlII) {
        return this.isConstBool(llllllllllllllIlIIIIlllllIIlIlll, llllllllllllllIlIIIIlllllIIllIll, llllllllllllllIlIIIIlllllIIllIlI) && this.getValueBool() == llllllllllllllIlIIIIlllllIIlIlII;
    }
    
    public boolean getValueBool() {
        final String llllllllllllllIlIIIIllllIlllIlII = this.value.toLowerCase();
        if (!llllllllllllllIlIIIIllllIlllIlII.equals("true") && !llllllllllllllIlIIIIllllIlllIlII.equals("false")) {
            throw new RuntimeException(String.valueOf(new StringBuilder("Invalid boolean: ").append(this.value).append(", line: ").append(this.line)));
        }
        return Boolean.valueOf(this.value);
    }
    
    public int getValueInt() {
        try {
            return Integer.parseInt(this.value);
        }
        catch (NumberFormatException llllllllllllllIlIIIIlllllIIIlIIl) {
            throw new NumberFormatException(String.valueOf(new StringBuilder("Invalid integer: ").append(this.value).append(", line: ").append(this.line)));
        }
    }
    
    public boolean isConstBool(final String llllllllllllllIlIIIIlllllIlllllI, final String llllllllllllllIlIIIIlllllIlllIIl, final String llllllllllllllIlIIIIlllllIlllIII) {
        return this.isConstBool(llllllllllllllIlIIIIlllllIlllllI) || this.isConstBool(llllllllllllllIlIIIIlllllIlllIIl) || this.isConstBool(llllllllllllllIlIIIIlllllIlllIII);
    }
    
    public boolean isComment(final String llllllllllllllIlIIIIllllllllllll) {
        return this.isComment() && llllllllllllllIlIIIIllllllllllll.equals(this.name);
    }
}
