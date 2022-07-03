package com.viaversion.viaversion.libs.kyori.adventure.text;

import com.viaversion.viaversion.libs.kyori.adventure.text.renderer.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.event.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.function.*;
import java.util.regex.*;

final class TextReplacementRenderer implements ComponentRenderer<State>
{
    private TextReplacementRenderer() {
    }
    
    @NotNull
    @Override
    public Component render(@NotNull final Component llllllllllllllllIIlllllIIIIIIIIl, @NotNull final State llllllllllllllllIIlllllIIIIIIIlI) {
        if (!llllllllllllllllIIlllllIIIIIIIlI.running) {
            return llllllllllllllllIIlllllIIIIIIIIl;
        }
        final boolean llllllllllllllllIIllllIllllIlIlI = llllllllllllllllIIlllllIIIIIIIlI.firstMatch;
        llllllllllllllllIIlllllIIIIIIIlI.firstMatch = true;
        final List<Component> llllllllllllllllIIllllIllllIlIIl = llllllllllllllllIIlllllIIIIIIIIl.children();
        final int llllllllllllllllIIllllIllllIlIII = llllllllllllllllIIllllIllllIlIIl.size();
        List<Component> llllllllllllllllIIllllIllllIIlll = null;
        Component llllllllllllllllIIllllIllllIIllI = llllllllllllllllIIlllllIIIIIIIIl;
        if (llllllllllllllllIIlllllIIIIIIIIl instanceof TextComponent) {
            final String llllllllllllllllIIllllIlllllllII = ((TextComponent)llllllllllllllllIIlllllIIIIIIIIl).content();
            final Matcher llllllllllllllllIIllllIllllllIll = llllllllllllllllIIlllllIIIIIIIlI.pattern.matcher(llllllllllllllllIIllllIlllllllII);
            int llllllllllllllllIIllllIllllllIlI = 0;
            while (llllllllllllllllIIllllIllllllIll.find()) {
                final PatternReplacementResult llllllllllllllllIIllllIlllllllIl = llllllllllllllllIIlllllIIIIIIIlI.continuer.shouldReplace(llllllllllllllllIIllllIllllllIll, ++llllllllllllllllIIlllllIIIIIIIlI.matchCount, llllllllllllllllIIlllllIIIIIIIlI.replaceCount);
                if (llllllllllllllllIIllllIlllllllIl == PatternReplacementResult.CONTINUE) {
                    continue;
                }
                if (llllllllllllllllIIllllIlllllllIl == PatternReplacementResult.STOP) {
                    llllllllllllllllIIlllllIIIIIIIlI.running = false;
                    break;
                }
                if (llllllllllllllllIIllllIllllllIll.start() == 0) {
                    if (llllllllllllllllIIllllIllllllIll.end() == llllllllllllllllIIllllIlllllllII.length()) {
                        final ComponentLike llllllllllllllllIIlllllIIIIIIIII = llllllllllllllllIIlllllIIIIIIIlI.replacement.apply(llllllllllllllllIIllllIllllllIll, ((ComponentBuilder<C, TextComponent.Builder>)Component.text().content(llllllllllllllllIIllllIllllllIll.group())).style(llllllllllllllllIIlllllIIIIIIIIl.style()));
                        llllllllllllllllIIllllIllllIIllI = ((llllllllllllllllIIlllllIIIIIIIII == null) ? Component.empty() : llllllllllllllllIIlllllIIIIIIIII.asComponent());
                        if (llllllllllllllllIIllllIllllIIlll == null) {
                            llllllllllllllllIIllllIllllIIlll = new ArrayList<Component>(llllllllllllllllIIllllIllllIlIII + llllllllllllllllIIllllIllllIIllI.children().size());
                            llllllllllllllllIIllllIllllIIlll.addAll(llllllllllllllllIIllllIllllIIllI.children());
                        }
                    }
                    else {
                        llllllllllllllllIIllllIllllIIllI = Component.text("", llllllllllllllllIIlllllIIIIIIIIl.style());
                        final ComponentLike llllllllllllllllIIllllIlllllllll = llllllllllllllllIIlllllIIIIIIIlI.replacement.apply(llllllllllllllllIIllllIllllllIll, Component.text().content(llllllllllllllllIIllllIllllllIll.group()));
                        if (llllllllllllllllIIllllIlllllllll != null) {
                            if (llllllllllllllllIIllllIllllIIlll == null) {
                                llllllllllllllllIIllllIllllIIlll = new ArrayList<Component>(llllllllllllllllIIllllIllllIlIII + 1);
                            }
                            llllllllllllllllIIllllIllllIIlll.add(llllllllllllllllIIllllIlllllllll.asComponent());
                        }
                    }
                }
                else {
                    if (llllllllllllllllIIllllIllllIIlll == null) {
                        llllllllllllllllIIllllIllllIIlll = new ArrayList<Component>(llllllllllllllllIIllllIllllIlIII + 2);
                    }
                    if (llllllllllllllllIIlllllIIIIIIIlI.firstMatch) {
                        llllllllllllllllIIllllIllllIIllI = ((TextComponent)llllllllllllllllIIlllllIIIIIIIIl).content(llllllllllllllllIIllllIlllllllII.substring(0, llllllllllllllllIIllllIllllllIll.start()));
                    }
                    else if (llllllllllllllllIIllllIllllllIlI < llllllllllllllllIIllllIllllllIll.start()) {
                        llllllllllllllllIIllllIllllIIlll.add(Component.text(llllllllllllllllIIllllIlllllllII.substring(llllllllllllllllIIllllIllllllIlI, llllllllllllllllIIllllIllllllIll.start())));
                    }
                    final ComponentLike llllllllllllllllIIllllIllllllllI = llllllllllllllllIIlllllIIIIIIIlI.replacement.apply(llllllllllllllllIIllllIllllllIll, Component.text().content(llllllllllllllllIIllllIllllllIll.group()));
                    if (llllllllllllllllIIllllIllllllllI != null) {
                        llllllllllllllllIIllllIllllIIlll.add(llllllllllllllllIIllllIllllllllI.asComponent());
                    }
                }
                ++llllllllllllllllIIlllllIIIIIIIlI.replaceCount;
                llllllllllllllllIIlllllIIIIIIIlI.firstMatch = false;
                llllllllllllllllIIllllIllllllIlI = llllllllllllllllIIllllIllllllIll.end();
            }
            if (llllllllllllllllIIllllIllllllIlI < llllllllllllllllIIllllIlllllllII.length() && llllllllllllllllIIllllIllllllIlI > 0) {
                if (llllllllllllllllIIllllIllllIIlll == null) {
                    llllllllllllllllIIllllIllllIIlll = new ArrayList<Component>(llllllllllllllllIIllllIllllIlIII);
                }
                llllllllllllllllIIllllIllllIIlll.add(Component.text(llllllllllllllllIIllllIlllllllII.substring(llllllllllllllllIIllllIllllllIlI)));
            }
        }
        else if (llllllllllllllllIIllllIllllIIllI instanceof TranslatableComponent) {
            final List<Component> llllllllllllllllIIllllIlllllIlIl = ((TranslatableComponent)llllllllllllllllIIllllIllllIIllI).args();
            List<Component> llllllllllllllllIIllllIlllllIlII = null;
            for (int llllllllllllllllIIllllIlllllIlll = 0, llllllllllllllllIIllllIlllllIllI = llllllllllllllllIIllllIlllllIlIl.size(); llllllllllllllllIIllllIlllllIlll < llllllllllllllllIIllllIlllllIllI; ++llllllllllllllllIIllllIlllllIlll) {
                final Component llllllllllllllllIIllllIllllllIIl = llllllllllllllllIIllllIlllllIlIl.get(llllllllllllllllIIllllIlllllIlll);
                final Component llllllllllllllllIIllllIllllllIII = this.render(llllllllllllllllIIllllIllllllIIl, llllllllllllllllIIlllllIIIIIIIlI);
                if (llllllllllllllllIIllllIllllllIII != llllllllllllllllIIlllllIIIIIIIIl && llllllllllllllllIIllllIlllllIlII == null) {
                    llllllllllllllllIIllllIlllllIlII = new ArrayList<Component>(llllllllllllllllIIllllIlllllIllI);
                    if (llllllllllllllllIIllllIlllllIlll > 0) {
                        llllllllllllllllIIllllIlllllIlII.addAll(llllllllllllllllIIllllIlllllIlIl.subList(0, llllllllllllllllIIllllIlllllIlll));
                    }
                }
                if (llllllllllllllllIIllllIlllllIlII != null) {
                    llllllllllllllllIIllllIlllllIlII.add(llllllllllllllllIIllllIllllllIII);
                }
            }
            if (llllllllllllllllIIllllIlllllIlII != null) {
                llllllllllllllllIIllllIllllIIllI = ((TranslatableComponent)llllllllllllllllIIllllIllllIIllI).args(llllllllllllllllIIllllIlllllIlII);
            }
        }
        if (llllllllllllllllIIlllllIIIIIIIlI.running) {
            final HoverEvent<?> llllllllllllllllIIllllIllllIllll = llllllllllllllllIIllllIllllIIllI.style().hoverEvent();
            if (llllllllllllllllIIllllIllllIllll != null) {
                final HoverEvent<?> llllllllllllllllIIllllIlllllIIll = llllllllllllllllIIllllIllllIllll.withRenderedValue(this, llllllllllllllllIIlllllIIIIIIIlI);
                if (llllllllllllllllIIllllIllllIllll != llllllllllllllllIIllllIlllllIIll) {
                    llllllllllllllllIIllllIllllIIllI = llllllllllllllllIIllllIllllIIllI.style(llllllllllllllllIIllllIlllIIlIll -> llllllllllllllllIIllllIlllIIlIll.hoverEvent(llllllllllllllllIIllllIlllllIIll));
                }
            }
            boolean llllllllllllllllIIllllIllllIlllI = true;
            for (int llllllllllllllllIIllllIlllllIIII = 0; llllllllllllllllIIllllIlllllIIII < llllllllllllllllIIllllIllllIlIII; ++llllllllllllllllIIllllIlllllIIII) {
                final Component llllllllllllllllIIllllIlllllIIlI = llllllllllllllllIIllllIllllIlIIl.get(llllllllllllllllIIllllIlllllIIII);
                final Component llllllllllllllllIIllllIlllllIIIl = this.render(llllllllllllllllIIllllIlllllIIlI, llllllllllllllllIIlllllIIIIIIIlI);
                if (llllllllllllllllIIllllIlllllIIIl != llllllllllllllllIIllllIlllllIIlI) {
                    if (llllllllllllllllIIllllIllllIIlll == null) {
                        llllllllllllllllIIllllIllllIIlll = new ArrayList<Component>(llllllllllllllllIIllllIllllIlIII);
                    }
                    if (llllllllllllllllIIllllIllllIlllI) {
                        llllllllllllllllIIllllIllllIIlll.addAll(llllllllllllllllIIllllIllllIlIIl.subList(0, llllllllllllllllIIllllIlllllIIII));
                    }
                    llllllllllllllllIIllllIllllIlllI = false;
                }
                if (llllllllllllllllIIllllIllllIIlll != null) {
                    llllllllllllllllIIllllIllllIIlll.add(llllllllllllllllIIllllIlllllIIIl);
                }
            }
        }
        else if (llllllllllllllllIIllllIllllIIlll != null) {
            llllllllllllllllIIllllIllllIIlll.addAll(llllllllllllllllIIllllIllllIlIIl);
        }
        llllllllllllllllIIlllllIIIIIIIlI.firstMatch = llllllllllllllllIIllllIllllIlIlI;
        if (llllllllllllllllIIllllIllllIIlll != null) {
            return llllllllllllllllIIllllIllllIIllI.children(llllllllllllllllIIllllIllllIIlll);
        }
        return llllllllllllllllIIllllIllllIIllI;
    }
    
    static {
        INSTANCE = new TextReplacementRenderer();
    }
    
    static final class State
    {
        final /* synthetic */ BiFunction<MatchResult, TextComponent.Builder, ComponentLike> replacement;
        final /* synthetic */ Pattern pattern;
        /* synthetic */ boolean running;
        /* synthetic */ int matchCount;
        /* synthetic */ int replaceCount;
        /* synthetic */ boolean firstMatch;
        final /* synthetic */ TextReplacementConfig.Condition continuer;
        
        State(@NotNull final Pattern llllllllllllllIlIIIIllIlllIIlllI, @NotNull final BiFunction<MatchResult, TextComponent.Builder, ComponentLike> llllllllllllllIlIIIIllIlllIlIIIl, final TextReplacementConfig.Condition llllllllllllllIlIIIIllIlllIIllII) {
            this.running = true;
            this.matchCount = 0;
            this.replaceCount = 0;
            this.firstMatch = true;
            this.pattern = llllllllllllllIlIIIIllIlllIIlllI;
            this.replacement = llllllllllllllIlIIIIllIlllIlIIIl;
            this.continuer = llllllllllllllIlIIIIllIlllIIllII;
        }
    }
}
