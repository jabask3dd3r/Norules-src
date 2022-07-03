package clickui.component;

public abstract class Parentable<O, P> extends Component<O>
{
    private /* synthetic */ boolean expand;
    private /* synthetic */ P parent;
    
    public boolean isExpand() {
        return this.expand;
    }
    
    public void setParent(final P lllllllllllllllIlIllIIlIIIIIlIlI) {
        this.parent = lllllllllllllllIlIllIIlIIIIIlIlI;
    }
    
    public Parentable(final O lllllllllllllllIlIllIIlIIIIllIII, final P lllllllllllllllIlIllIIlIIIlIIIII, final float lllllllllllllllIlIllIIlIIIIlllll, final float lllllllllllllllIlIllIIlIIIIllllI, final float lllllllllllllllIlIllIIlIIIIlllIl, final float lllllllllllllllIlIllIIlIIIIlllII, final float lllllllllllllllIlIllIIlIIIIllIll, final float lllllllllllllllIlIllIIlIIIIllIlI) {
        super(lllllllllllllllIlIllIIlIIIIllIII, lllllllllllllllIlIllIIlIIIIlllll, lllllllllllllllIlIllIIlIIIIllllI, lllllllllllllllIlIllIIlIIIIlllIl, lllllllllllllllIlIllIIlIIIIlllII, lllllllllllllllIlIllIIlIIIIllIll, lllllllllllllllIlIllIIlIIIIllIlI);
        this.parent = lllllllllllllllIlIllIIlIIIlIIIII;
    }
    
    public boolean isVisible() {
        return true;
    }
    
    public void setExpand(final boolean lllllllllllllllIlIllIIlIIIIIIIIl) {
        this.expand = lllllllllllllllIlIllIIlIIIIIIIIl;
    }
    
    @Override
    public abstract void updatePosition(final float p0, final float p1);
    
    public P getParent() {
        return this.parent;
    }
}
