package com.viaversion.viaversion.libs.kyori.adventure.text;

import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import java.util.regex.*;

public interface BlockNBTComponent extends NBTComponent<BlockNBTComponent, Builder>, ScopedComponent<BlockNBTComponent>
{
    @Contract(pure = true)
    @NotNull
    BlockNBTComponent pos(@NotNull final Pos lllllllllllllIIIIlIIIIIIllllIlll);
    
    @NotNull
    @Contract(pure = true)
    default BlockNBTComponent worldPos(final WorldPos.Coordinate lllllllllllllIIIIlIIIIIIlllIIIlI, final WorldPos.Coordinate lllllllllllllIIIIlIIIIIIlllIIIIl, final WorldPos.Coordinate lllllllllllllIIIIlIIIIIIlllIIIll) {
        return this.pos(WorldPos.of(lllllllllllllIIIIlIIIIIIlllIIIlI, lllllllllllllIIIIlIIIIIIlllIIIIl, lllllllllllllIIIIlIIIIIIlllIIIll));
    }
    
    @NotNull
    Pos pos();
    
    @Contract(pure = true)
    @NotNull
    default BlockNBTComponent localPos(final double lllllllllllllIIIIlIIIIIIllllIIlI, final double lllllllllllllIIIIlIIIIIIllllIIII, final double lllllllllllllIIIIlIIIIIIllllIIIl) {
        return this.pos(LocalPos.of(lllllllllllllIIIIlIIIIIIllllIIlI, lllllllllllllIIIIlIIIIIIllllIIII, lllllllllllllIIIIlIIIIIIllllIIIl));
    }
    
    @Contract(pure = true)
    @NotNull
    default BlockNBTComponent absoluteWorldPos(final int lllllllllllllIIIIlIIIIIIllIlIIlI, final int lllllllllllllIIIIlIIIIIIllIlIIll, final int lllllllllllllIIIIlIIIIIIllIlIlII) {
        return this.worldPos(WorldPos.Coordinate.absolute(lllllllllllllIIIIlIIIIIIllIlIIlI), WorldPos.Coordinate.absolute(lllllllllllllIIIIlIIIIIIllIlIIll), WorldPos.Coordinate.absolute(lllllllllllllIIIIlIIIIIIllIlIlII));
    }
    
    @NotNull
    @Contract(pure = true)
    default BlockNBTComponent relativeWorldPos(final int lllllllllllllIIIIlIIIIIIllIIIlIl, final int lllllllllllllIIIIlIIIIIIllIIIIll, final int lllllllllllllIIIIlIIIIIIllIIIlII) {
        return this.worldPos(WorldPos.Coordinate.relative(lllllllllllllIIIIlIIIIIIllIIIlIl), WorldPos.Coordinate.relative(lllllllllllllIIIIlIIIIIIllIIIIll), WorldPos.Coordinate.relative(lllllllllllllIIIIlIIIIIIllIIIlII));
    }
    
    public interface WorldPos extends Pos
    {
        @NotNull
        default WorldPos of(@NotNull final Coordinate lllllllllllllIIlIIlIllIlIIlIlIII, @NotNull final Coordinate lllllllllllllIIlIIlIllIlIIlIlIlI, @NotNull final Coordinate lllllllllllllIIlIIlIllIlIIlIlIIl) {
            return new BlockNBTComponentImpl.WorldPosImpl(lllllllllllllIIlIIlIllIlIIlIlIII, lllllllllllllIIlIIlIllIlIIlIlIlI, lllllllllllllIIlIIlIllIlIIlIlIIl);
        }
        
        @NotNull
        Coordinate z();
        
        @NotNull
        Coordinate y();
        
        @NotNull
        Coordinate x();
        
        public interface Coordinate extends Examinable
        {
            @NotNull
            default Coordinate of(final int llllllllllllllllIlIlllllIIIllllI, @NotNull final Type llllllllllllllllIlIlllllIIIlllIl) {
                return new BlockNBTComponentImpl.WorldPosImpl.CoordinateImpl(llllllllllllllllIlIlllllIIIllllI, llllllllllllllllIlIlllllIIIlllIl);
            }
            
            @NotNull
            default Coordinate relative(final int llllllllllllllllIlIlllllIIlIIIll) {
                return of(llllllllllllllllIlIlllllIIlIIIll, Type.RELATIVE);
            }
            
            @NotNull
            Type type();
            
            int value();
            
            @NotNull
            default Coordinate absolute(final int llllllllllllllllIlIlllllIIlIIlll) {
                return of(llllllllllllllllIlIlllllIIlIIlll, Type.ABSOLUTE);
            }
            
            public enum Type
            {
                RELATIVE, 
                ABSOLUTE;
                
                private static /* synthetic */ Type[] $values() {
                    return new Type[] { Type.ABSOLUTE, Type.RELATIVE };
                }
                
                static {
                    $VALUES = $values();
                }
            }
        }
    }
    
    public interface Pos extends Examinable
    {
        @NotNull
        default Pos fromString(@NotNull final String lllllllllllllIllIIlIIIlIIIIllIlI) throws IllegalArgumentException {
            final Matcher lllllllllllllIllIIlIIIlIIIIllIII = BlockNBTComponentImpl.Tokens.LOCAL_PATTERN.matcher(lllllllllllllIllIIlIIIlIIIIllIlI);
            if (lllllllllllllIllIIlIIIlIIIIllIII.matches()) {
                return LocalPos.of(Double.parseDouble(lllllllllllllIllIIlIIIlIIIIllIII.group(1)), Double.parseDouble(lllllllllllllIllIIlIIIlIIIIllIII.group(3)), Double.parseDouble(lllllllllllllIllIIlIIIlIIIIllIII.group(5)));
            }
            final Matcher lllllllllllllIllIIlIIIlIIIIlIlll = BlockNBTComponentImpl.Tokens.WORLD_PATTERN.matcher(lllllllllllllIllIIlIIIlIIIIllIlI);
            if (lllllllllllllIllIIlIIIlIIIIlIlll.matches()) {
                return WorldPos.of(BlockNBTComponentImpl.Tokens.deserializeCoordinate(lllllllllllllIllIIlIIIlIIIIlIlll.group(1), lllllllllllllIllIIlIIIlIIIIlIlll.group(2)), BlockNBTComponentImpl.Tokens.deserializeCoordinate(lllllllllllllIllIIlIIIlIIIIlIlll.group(3), lllllllllllllIllIIlIIIlIIIIlIlll.group(4)), BlockNBTComponentImpl.Tokens.deserializeCoordinate(lllllllllllllIllIIlIIIlIIIIlIlll.group(5), lllllllllllllIllIIlIIIlIIIIlIlll.group(6)));
            }
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Cannot convert position specification '").append(lllllllllllllIllIIlIIIlIIIIllIlI).append("' into a position")));
        }
        
        @NotNull
        String asString();
    }
    
    public interface LocalPos extends Pos
    {
        @NotNull
        default LocalPos of(final double llllllllllllllIIIlllIllIIIlIlllI, final double llllllllllllllIIIlllIllIIIlIllIl, final double llllllllllllllIIIlllIllIIIlIllII) {
            return new BlockNBTComponentImpl.LocalPosImpl(llllllllllllllIIIlllIllIIIlIlllI, llllllllllllllIIIlllIllIIIlIllIl, llllllllllllllIIIlllIllIIIlIllII);
        }
        
        double up();
        
        double forwards();
        
        double left();
    }
    
    public interface Builder extends NBTComponentBuilder<BlockNBTComponent, Builder>
    {
        @Contract("_, _, _ -> this")
        @NotNull
        default Builder relativeWorldPos(final int lllllllllllllIlIlIIlllIIlllIllll, final int lllllllllllllIlIlIIlllIIllllIIII, final int lllllllllllllIlIlIIlllIIlllIlllI) {
            return this.worldPos(WorldPos.Coordinate.relative(lllllllllllllIlIlIIlllIIlllIllll), WorldPos.Coordinate.relative(lllllllllllllIlIlIIlllIIllllIIII), WorldPos.Coordinate.relative(lllllllllllllIlIlIIlllIIlllIlllI));
        }
        
        @NotNull
        @Contract("_ -> this")
        Builder pos(@NotNull final Pos lllllllllllllIlIlIIlllIlIIlIIIlI);
        
        @NotNull
        @Contract("_, _, _ -> this")
        default Builder localPos(final double lllllllllllllIlIlIIlllIlIIIlllIl, final double lllllllllllllIlIlIIlllIlIIIllIll, final double lllllllllllllIlIlIIlllIlIIIlllII) {
            return this.pos(LocalPos.of(lllllllllllllIlIlIIlllIlIIIlllIl, lllllllllllllIlIlIIlllIlIIIllIll, lllllllllllllIlIlIIlllIlIIIlllII));
        }
        
        @Contract("_, _, _ -> this")
        @NotNull
        default Builder worldPos(final WorldPos.Coordinate lllllllllllllIlIlIIlllIlIIIIllII, final WorldPos.Coordinate lllllllllllllIlIlIIlllIlIIIIllIl, final WorldPos.Coordinate lllllllllllllIlIlIIlllIlIIIIlllI) {
            return this.pos(WorldPos.of(lllllllllllllIlIlIIlllIlIIIIllII, lllllllllllllIlIlIIlllIlIIIIllIl, lllllllllllllIlIlIIlllIlIIIIlllI));
        }
        
        @Contract("_, _, _ -> this")
        @NotNull
        default Builder absoluteWorldPos(final int lllllllllllllIlIlIIlllIIllllllll, final int lllllllllllllIlIlIIlllIIlllllllI, final int lllllllllllllIlIlIIlllIIllllllIl) {
            return this.worldPos(WorldPos.Coordinate.absolute(lllllllllllllIlIlIIlllIIllllllll), WorldPos.Coordinate.absolute(lllllllllllllIlIlIIlllIIlllllllI), WorldPos.Coordinate.absolute(lllllllllllllIlIlIIlllIIllllllIl));
        }
    }
}
