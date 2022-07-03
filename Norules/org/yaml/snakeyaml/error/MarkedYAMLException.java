package org.yaml.snakeyaml.error;

public class MarkedYAMLException extends YAMLException
{
    private /* synthetic */ String problem;
    private /* synthetic */ String context;
    private /* synthetic */ String note;
    private /* synthetic */ Mark contextMark;
    private /* synthetic */ Mark problemMark;
    
    public Mark getProblemMark() {
        return this.problemMark;
    }
    
    public Mark getContextMark() {
        return this.contextMark;
    }
    
    public String getProblem() {
        return this.problem;
    }
    
    protected MarkedYAMLException(final String lllllllllllllllIlIllIlllllllIIII, final Mark lllllllllllllllIlIllIllllllIlIlI, final String lllllllllllllllIlIllIllllllIlIIl, final Mark lllllllllllllllIlIllIllllllIllIl) {
        this(lllllllllllllllIlIllIlllllllIIII, lllllllllllllllIlIllIllllllIlIlI, lllllllllllllllIlIllIllllllIlIIl, lllllllllllllllIlIllIllllllIllIl, null, null);
    }
    
    @Override
    public String getMessage() {
        return this.toString();
    }
    
    protected MarkedYAMLException(final String lllllllllllllllIlIlllIIIIIIlIIII, final Mark lllllllllllllllIlIlllIIIIIIIllll, final String lllllllllllllllIlIlllIIIIIIIlllI, final Mark lllllllllllllllIlIlllIIIIIIIllIl, final String lllllllllllllllIlIlllIIIIIIIllII) {
        this(lllllllllllllllIlIlllIIIIIIlIIII, lllllllllllllllIlIlllIIIIIIIllll, lllllllllllllllIlIlllIIIIIIIlllI, lllllllllllllllIlIlllIIIIIIIllIl, lllllllllllllllIlIlllIIIIIIIllII, null);
    }
    
    protected MarkedYAMLException(final String lllllllllllllllIlIllIlllllllllII, final Mark lllllllllllllllIlIllIllllllllIll, final String lllllllllllllllIlIlllIIIIIIIIIIl, final Mark lllllllllllllllIlIlllIIIIIIIIIII, final String lllllllllllllllIlIllIllllllllIII, final Throwable lllllllllllllllIlIllIllllllllllI) {
        super(String.valueOf(new StringBuilder().append(lllllllllllllllIlIllIlllllllllII).append("; ").append(lllllllllllllllIlIlllIIIIIIIIIIl).append("; ").append(lllllllllllllllIlIlllIIIIIIIIIII)), lllllllllllllllIlIllIllllllllllI);
        this.context = lllllllllllllllIlIllIlllllllllII;
        this.contextMark = lllllllllllllllIlIllIllllllllIll;
        this.problem = lllllllllllllllIlIlllIIIIIIIIIIl;
        this.problemMark = lllllllllllllllIlIlllIIIIIIIIIII;
        this.note = lllllllllllllllIlIllIllllllllIII;
    }
    
    public String getContext() {
        return this.context;
    }
    
    protected MarkedYAMLException(final String lllllllllllllllIlIllIllllllIIIII, final Mark lllllllllllllllIlIllIlllllIlllll, final String lllllllllllllllIlIllIlllllIllIII, final Mark lllllllllllllllIlIllIlllllIlllIl, final Throwable lllllllllllllllIlIllIlllllIlllII) {
        this(lllllllllllllllIlIllIllllllIIIII, lllllllllllllllIlIllIlllllIlllll, lllllllllllllllIlIllIlllllIllIII, lllllllllllllllIlIllIlllllIlllIl, null, lllllllllllllllIlIllIlllllIlllII);
    }
    
    @Override
    public String toString() {
        final StringBuilder lllllllllllllllIlIllIlllllIIllll = new StringBuilder();
        if (this.context != null) {
            lllllllllllllllIlIllIlllllIIllll.append(this.context);
            lllllllllllllllIlIllIlllllIIllll.append("\n");
        }
        if (this.contextMark != null && (this.problem == null || this.problemMark == null || this.contextMark.getName().equals(this.problemMark.getName()) || this.contextMark.getLine() != this.problemMark.getLine() || this.contextMark.getColumn() != this.problemMark.getColumn())) {
            lllllllllllllllIlIllIlllllIIllll.append(this.contextMark.toString());
            lllllllllllllllIlIllIlllllIIllll.append("\n");
        }
        if (this.problem != null) {
            lllllllllllllllIlIllIlllllIIllll.append(this.problem);
            lllllllllllllllIlIllIlllllIIllll.append("\n");
        }
        if (this.problemMark != null) {
            lllllllllllllllIlIllIlllllIIllll.append(this.problemMark.toString());
            lllllllllllllllIlIllIlllllIIllll.append("\n");
        }
        if (this.note != null) {
            lllllllllllllllIlIllIlllllIIllll.append(this.note);
            lllllllllllllllIlIllIlllllIIllll.append("\n");
        }
        return String.valueOf(lllllllllllllllIlIllIlllllIIllll);
    }
}
