package shadersmod.client;

import java.util.*;

public class ShaderProfile
{
    private /* synthetic */ String name;
    private /* synthetic */ Map<String, String> mapOptionValues;
    private /* synthetic */ Set<String> disabledPrograms;
    
    public void addDisabledPrograms(final Collection<String> lllllllllllllIlIlIlIlIlIllIlllIl) {
        this.disabledPrograms.addAll(lllllllllllllIlIlIlIlIlIllIlllIl);
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getValue(final String lllllllllllllIlIlIlIlIlIlllIlllI) {
        return this.mapOptionValues.get(lllllllllllllIlIlIlIlIlIlllIlllI);
    }
    
    public void applyOptionValues(final ShaderOption[] lllllllllllllIlIlIlIlIllIIIIIlIl) {
        for (int lllllllllllllIlIlIlIlIllIIIIIlII = 0; lllllllllllllIlIlIlIlIllIIIIIlII < lllllllllllllIlIlIlIlIllIIIIIlIl.length; ++lllllllllllllIlIlIlIlIllIIIIIlII) {
            final ShaderOption lllllllllllllIlIlIlIlIllIIIIIIll = lllllllllllllIlIlIlIlIllIIIIIlIl[lllllllllllllIlIlIlIlIllIIIIIlII];
            final String lllllllllllllIlIlIlIlIllIIIIIIlI = lllllllllllllIlIlIlIlIllIIIIIIll.getName();
            final String lllllllllllllIlIlIlIlIllIIIIIIIl = this.mapOptionValues.get(lllllllllllllIlIlIlIlIllIIIIIIlI);
            if (lllllllllllllIlIlIlIlIllIIIIIIIl != null) {
                lllllllllllllIlIlIlIlIllIIIIIIll.setValue(lllllllllllllIlIlIlIlIllIIIIIIIl);
            }
        }
    }
    
    public void addOptionValue(final String lllllllllllllIlIlIlIlIllIIIlIlII, final String lllllllllllllIlIlIlIlIllIIIlIllI) {
        this.mapOptionValues.put(lllllllllllllIlIlIlIlIllIIIlIlII, lllllllllllllIlIlIlIlIllIIIlIllI);
    }
    
    public String[] getOptions() {
        final Set<String> lllllllllllllIlIlIlIlIlIllllIllI = this.mapOptionValues.keySet();
        final String[] lllllllllllllIlIlIlIlIlIllllIlIl = lllllllllllllIlIlIlIlIlIllllIllI.toArray(new String[lllllllllllllIlIlIlIlIlIllllIllI.size()]);
        return lllllllllllllIlIlIlIlIlIllllIlIl;
    }
    
    public boolean isProgramDisabled(final String lllllllllllllIlIlIlIlIlIllIlIlll) {
        return this.disabledPrograms.contains(lllllllllllllIlIlIlIlIlIllIlIlll);
    }
    
    public void addOptionValues(final ShaderProfile lllllllllllllIlIlIlIlIllIIIIllll) {
        if (lllllllllllllIlIlIlIlIllIIIIllll != null) {
            this.mapOptionValues.putAll(lllllllllllllIlIlIlIlIllIIIIllll.mapOptionValues);
        }
    }
    
    public Collection<String> getDisabledPrograms() {
        return new HashSet<String>(this.disabledPrograms);
    }
    
    public void addDisabledProgram(final String lllllllllllllIlIlIlIlIlIlllIIllI) {
        this.disabledPrograms.add(lllllllllllllIlIlIlIlIlIlllIIllI);
    }
    
    public ShaderProfile(final String lllllllllllllIlIlIlIlIllIIlIIIIl) {
        this.name = null;
        this.mapOptionValues = new HashMap<String, String>();
        this.disabledPrograms = new HashSet<String>();
        this.name = lllllllllllllIlIlIlIlIllIIlIIIIl;
    }
}
