package com.viaversion.viaversion.libs.kyori.examination;

public abstract class ExaminableProperty
{
    public static ExaminableProperty of(final String lllllllllllllIIIIlIIIlIlIIllllII, final byte[] lllllllllllllIIIIlIIIlIlIIlllIll) {
        return new ExaminableProperty() {
            @Override
            public <R> R examine(final Examiner<? extends R> lllllllllllllllIllIIllllIIIlIIIl) {
                return (R)lllllllllllllllIllIIllllIIIlIIIl.examine(lllllllllllllIIIIlIIIlIlIIlllIll);
            }
            
            @Override
            public String name() {
                return lllllllllllllIIIIlIIIlIlIIllllII;
            }
        };
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("ExaminableProperty{").append(this.name()).append("}"));
    }
    
    public static ExaminableProperty of(final String lllllllllllllIIIIlIIIlIlIlIlIlII, final boolean lllllllllllllIIIIlIIIlIlIlIlIIll) {
        return new ExaminableProperty() {
            @Override
            public <R> R examine(final Examiner<? extends R> llllllllllllllIlIIIIlIIllIIlllIl) {
                return (R)llllllllllllllIlIIIIlIIllIIlllIl.examine(lllllllllllllIIIIlIIIlIlIlIlIIll);
            }
            
            @Override
            public String name() {
                return lllllllllllllIIIIlIIIlIlIlIlIlII;
            }
        };
    }
    
    public static ExaminableProperty of(final String lllllllllllllIIIIlIIIlIlIlIIIlII, final byte lllllllllllllIIIIlIIIlIlIlIIIIll) {
        return new ExaminableProperty() {
            @Override
            public <R> R examine(final Examiner<? extends R> lllllllllllllIIIIlIIlllIIIlllIll) {
                return (R)lllllllllllllIIIIlIIlllIIIlllIll.examine(lllllllllllllIIIIlIIIlIlIlIIIIll);
            }
            
            @Override
            public String name() {
                return lllllllllllllIIIIlIIIlIlIlIIIlII;
            }
        };
    }
    
    public static ExaminableProperty of(final String lllllllllllllIIIIlIIIlIlIIlIIlII, final double lllllllllllllIIIIlIIIlIlIIlIIIll) {
        return new ExaminableProperty() {
            @Override
            public <R> R examine(final Examiner<? extends R> lllllllllllllIIllIIIIIlIIlIIIlII) {
                return (R)lllllllllllllIIllIIIIIlIIlIIIlII.examine(lllllllllllllIIIIlIIIlIlIIlIIIll);
            }
            
            @Override
            public String name() {
                return lllllllllllllIIIIlIIIlIlIIlIIlII;
            }
        };
    }
    
    public static ExaminableProperty of(final String lllllllllllllIIIIlIIIlIlIlIllIll, final String lllllllllllllIIIIlIIIlIlIlIlllII) {
        return new ExaminableProperty() {
            @Override
            public <R> R examine(final Examiner<? extends R> lllllllllllllIlllIIIlIllllllllIl) {
                return (R)lllllllllllllIlllIIIlIllllllllIl.examine(lllllllllllllIIIIlIIIlIlIlIlllII);
            }
            
            @Override
            public String name() {
                return lllllllllllllIIIIlIIIlIlIlIllIll;
            }
        };
    }
    
    public static ExaminableProperty of(final String lllllllllllllIIIIlIIIlIIlllIIlII, final short lllllllllllllIIIIlIIIlIIlllIIIll) {
        return new ExaminableProperty() {
            @Override
            public <R> R examine(final Examiner<? extends R> llllllllllllllIlIlIIllIllllIIllI) {
                return (R)llllllllllllllIlIlIIllIllllIIllI.examine(lllllllllllllIIIIlIIIlIIlllIIIll);
            }
            
            @Override
            public String name() {
                return lllllllllllllIIIIlIIIlIIlllIIlII;
            }
        };
    }
    
    public static ExaminableProperty of(final String lllllllllllllIIIIlIIIlIlIllIIlII, final Object lllllllllllllIIIIlIIIlIlIllIIIll) {
        return new ExaminableProperty() {
            @Override
            public String name() {
                return lllllllllllllIIIIlIIIlIlIllIIlII;
            }
            
            @Override
            public <R> R examine(final Examiner<? extends R> lllllllllllllIIIIlIlllIllllIlIII) {
                return (R)lllllllllllllIIIIlIlllIllllIlIII.examine(lllllllllllllIIIIlIIIlIlIllIIIll);
            }
        };
    }
    
    public static ExaminableProperty of(final String lllllllllllllIIIIlIIIlIlIIIIlIll, final float[] lllllllllllllIIIIlIIIlIlIIIIllII) {
        return new ExaminableProperty() {
            @Override
            public <R> R examine(final Examiner<? extends R> llllllllllllllIlIllllllllIIlIIll) {
                return (R)llllllllllllllIlIllllllllIIlIIll.examine(lllllllllllllIIIIlIIIlIlIIIIllII);
            }
            
            @Override
            public String name() {
                return lllllllllllllIIIIlIIIlIlIIIIlIll;
            }
        };
    }
    
    public static ExaminableProperty of(final String lllllllllllllIIIIlIIIlIlIIlIllII, final char[] lllllllllllllIIIIlIIIlIlIIlIlIll) {
        return new ExaminableProperty() {
            @Override
            public String name() {
                return lllllllllllllIIIIlIIIlIlIIlIllII;
            }
            
            @Override
            public <R> R examine(final Examiner<? extends R> llllllllllllllllIlIIIIIlllIIlIIl) {
                return (R)llllllllllllllllIlIIIIIlllIIlIIl.examine(lllllllllllllIIIIlIIIlIlIIlIlIll);
            }
        };
    }
    
    public static ExaminableProperty of(final String lllllllllllllIIIIlIIIlIlIlIIllII, final boolean[] lllllllllllllIIIIlIIIlIlIlIIlIll) {
        return new ExaminableProperty() {
            @Override
            public <R> R examine(final Examiner<? extends R> lllllllllllllIIlIlIllllllIlIlIII) {
                return (R)lllllllllllllIIlIlIllllllIlIlIII.examine(lllllllllllllIIIIlIIIlIlIlIIlIll);
            }
            
            @Override
            public String name() {
                return lllllllllllllIIIIlIIIlIlIlIIllII;
            }
        };
    }
    
    public static ExaminableProperty of(final String lllllllllllllIIIIlIIIlIlIIllIIll, final char lllllllllllllIIIIlIIIlIlIIllIlII) {
        return new ExaminableProperty() {
            @Override
            public String name() {
                return lllllllllllllIIIIlIIIlIlIIllIIll;
            }
            
            @Override
            public <R> R examine(final Examiner<? extends R> llllllllllllllllllllIllIlIlIllll) {
                return (R)llllllllllllllllllllIllIlIlIllll.examine(lllllllllllllIIIIlIIIlIlIIllIlII);
            }
        };
    }
    
    public static ExaminableProperty of(final String lllllllllllllIIIIlIIIlIIllllIlII, final long lllllllllllllIIIIlIIIlIIllllIIll) {
        return new ExaminableProperty() {
            @Override
            public <R> R examine(final Examiner<? extends R> lllllllllllllIlIlIIlIIIllIllIIII) {
                return (R)lllllllllllllIlIlIIlIIIllIllIIII.examine(lllllllllllllIIIIlIIIlIIllllIIll);
            }
            
            @Override
            public String name() {
                return lllllllllllllIIIIlIIIlIIllllIlII;
            }
        };
    }
    
    public static ExaminableProperty of(final String lllllllllllllIIIIlIIIlIlIIIIIIll, final int lllllllllllllIIIIlIIIlIlIIIIIlII) {
        return new ExaminableProperty() {
            @Override
            public String name() {
                return lllllllllllllIIIIlIIIlIlIIIIIIll;
            }
            
            @Override
            public <R> R examine(final Examiner<? extends R> lllllllllllllIlIIllllIIIllllIIlI) {
                return (R)lllllllllllllIlIIllllIIIllllIIlI.examine(lllllllllllllIIIIlIIIlIlIIIIIlII);
            }
        };
    }
    
    public static ExaminableProperty of(final String lllllllllllllIIIIlIIIlIIlllIllII, final long[] lllllllllllllIIIIlIIIlIIlllIlIll) {
        return new ExaminableProperty() {
            @Override
            public <R> R examine(final Examiner<? extends R> llllllllllllllIlIlIIlIllIIlllIlI) {
                return (R)llllllllllllllIlIlIIlIllIIlllIlI.examine(lllllllllllllIIIIlIIIlIIlllIlIll);
            }
            
            @Override
            public String name() {
                return lllllllllllllIIIIlIIIlIIlllIllII;
            }
        };
    }
    
    public static ExaminableProperty of(final String lllllllllllllIIIIlIIIlIlIIIlIlII, final float lllllllllllllIIIIlIIIlIlIIIlIIll) {
        return new ExaminableProperty() {
            @Override
            public String name() {
                return lllllllllllllIIIIlIIIlIlIIIlIlII;
            }
            
            @Override
            public <R> R examine(final Examiner<? extends R> lllllllllllllIIlIIlIIIIIIlIlIlll) {
                return (R)lllllllllllllIIlIIlIIIIIIlIlIlll.examine(lllllllllllllIIIIlIIIlIlIIIlIIll);
            }
        };
    }
    
    private ExaminableProperty() {
    }
    
    public abstract String name();
    
    public static ExaminableProperty of(final String lllllllllllllIIIIlIIIlIIllllllII, final int[] lllllllllllllIIIIlIIIlIIlllllIll) {
        return new ExaminableProperty() {
            @Override
            public <R> R examine(final Examiner<? extends R> lllllllllllllIllllIlllllllIllIIl) {
                return (R)lllllllllllllIllllIlllllllIllIIl.examine(lllllllllllllIIIIlIIIlIIlllllIll);
            }
            
            @Override
            public String name() {
                return lllllllllllllIIIIlIIIlIIllllllII;
            }
        };
    }
    
    public static ExaminableProperty of(final String lllllllllllllIIIIlIIIlIlIIIllIll, final double[] lllllllllllllIIIIlIIIlIlIIIlllII) {
        return new ExaminableProperty() {
            @Override
            public String name() {
                return lllllllllllllIIIIlIIIlIlIIIllIll;
            }
            
            @Override
            public <R> R examine(final Examiner<? extends R> lllllllllllllIIIIllIllIlIlIIIlIl) {
                return (R)lllllllllllllIIIIllIllIlIlIIIlIl.examine(lllllllllllllIIIIlIIIlIlIIIlllII);
            }
        };
    }
    
    public static ExaminableProperty of(final String lllllllllllllIIIIlIIIlIIllIllIll, final short[] lllllllllllllIIIIlIIIlIIllIlllII) {
        return new ExaminableProperty() {
            @Override
            public <R> R examine(final Examiner<? extends R> lllllllllllllIIIlIIlIlIlllIllIIl) {
                return (R)lllllllllllllIIIlIIlIlIlllIllIIl.examine(lllllllllllllIIIIlIIIlIIllIlllII);
            }
            
            @Override
            public String name() {
                return lllllllllllllIIIIlIIIlIIllIllIll;
            }
        };
    }
    
    public abstract <R> R examine(final Examiner<? extends R> lllllllllllllIIIIlIIIlIlIllIlIlI);
}
