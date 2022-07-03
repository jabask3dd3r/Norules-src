package optifine;

public class VillagerProfession
{
    private /* synthetic */ int[] careers;
    private /* synthetic */ int profession;
    
    public VillagerProfession(final int llllllllllllllIllIIIllllIlIllIII) {
        this(llllllllllllllIllIIIllllIlIllIII, null);
    }
    
    public boolean addCareer(final int llllllllllllllIllIIIllllIIlIIlIl) {
        if (this.careers == null) {
            this.careers = new int[] { llllllllllllllIllIIIllllIIlIIlIl };
            return true;
        }
        if (this.hasCareer(llllllllllllllIllIIIllllIIlIIlIl)) {
            return false;
        }
        this.careers = Config.addIntToArray(this.careers, llllllllllllllIllIIIllllIIlIIlIl);
        return true;
    }
    
    public VillagerProfession(final int llllllllllllllIllIIIllllIlIIlIII, final int[] llllllllllllllIllIIIllllIlIIIlll) {
        this.profession = llllllllllllllIllIIIllllIlIIlIII;
        this.careers = llllllllllllllIllIIIllllIlIIIlll;
    }
    
    public int[] getCareers() {
        return this.careers;
    }
    
    @Override
    public String toString() {
        return (this.careers == null) ? String.valueOf(new StringBuilder().append(this.profession)) : String.valueOf(new StringBuilder().append(this.profession).append(":").append(Config.arrayToString(this.careers)));
    }
    
    private boolean hasCareer(final int llllllllllllllIllIIIllllIIlIllII) {
        return this.careers != null && Config.equalsOne(llllllllllllllIllIIIllllIIlIllII, this.careers);
    }
    
    public VillagerProfession(final int llllllllllllllIllIIIllllIlIlIIIl, final int llllllllllllllIllIIIllllIlIIllIl) {
        this(llllllllllllllIllIIIllllIlIlIIIl, new int[] { llllllllllllllIllIIIllllIlIIllIl });
    }
    
    public int getProfession() {
        return this.profession;
    }
    
    public boolean matches(final int llllllllllllllIllIIIllllIIlllllI, final int llllllllllllllIllIIIllllIIllllIl) {
        return this.profession == llllllllllllllIllIIIllllIIlllllI && (this.careers == null || Config.equalsOne(llllllllllllllIllIIIllllIIllllIl, this.careers));
    }
}
