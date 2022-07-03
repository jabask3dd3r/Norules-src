package net.optifine.entity.model.anim;

import optifine.*;
import java.io.*;
import java.util.*;

public class ExpressionParser
{
    private /* synthetic */ IModelResolver modelResolver;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$optifine$entity$model$anim$EnumTokenType;
    
    private static IExpression makeFunction(final EnumFunctionType lllllllllllllIIIlIllIIllllIlIlll, final IExpression[] lllllllllllllIIIlIllIIllllIlIlII) throws ParseException {
        if (lllllllllllllIIIlIllIIllllIlIlll.getCountArguments() != lllllllllllllIIIlIllIIllllIlIlII.length) {
            throw new ParseException(String.valueOf(new StringBuilder("Invalid number of arguments: ").append(lllllllllllllIIIlIllIIllllIlIlII.length).append(", should be: ").append(lllllllllllllIIIlIllIIllllIlIlll.getCountArguments()).append(", function: ").append(lllllllllllllIIIlIllIIllllIlIlll.getName())));
        }
        return new Function(lllllllllllllIIIlIllIIllllIlIlll, lllllllllllllIIIlIllIIllllIlIlII);
    }
    
    public static void main(final String[] lllllllllllllIIIlIllIIlllIlIIIIl) throws Exception {
        final ExpressionParser lllllllllllllIIIlIllIIlllIlIIIII = new ExpressionParser(null);
    Label_0009_Outer:
        while (true) {
            while (true) {
                try {
                    while (true) {
                        final InputStreamReader lllllllllllllIIIlIllIIlllIIlllll = new InputStreamReader(System.in);
                        final BufferedReader lllllllllllllIIIlIllIIlllIIllllI = new BufferedReader(lllllllllllllIIIlIllIIlllIIlllll);
                        final String lllllllllllllIIIlIllIIlllIIlllIl = lllllllllllllIIIlIllIIlllIIllllI.readLine();
                        if (lllllllllllllIIIlIllIIlllIIlllIl.length() <= 0) {
                            break;
                        }
                        final IExpression lllllllllllllIIIlIllIIlllIIlllII = lllllllllllllIIIlIllIIlllIlIIIII.parse(lllllllllllllIIIlIllIIlllIIlllIl);
                        final float lllllllllllllIIIlIllIIlllIIllIll = lllllllllllllIIIlIllIIlllIIlllII.eval();
                        Config.dbg(String.valueOf(new StringBuilder().append(lllllllllllllIIIlIllIIlllIIlllIl).append(" = ").append(lllllllllllllIIIlIllIIlllIIllIll)));
                    }
                    return;
                }
                catch (Exception lllllllllllllIIIlIllIIlllIIllIlI) {
                    lllllllllllllIIIlIllIIlllIIllIlI.printStackTrace();
                    continue Label_0009_Outer;
                }
                continue;
            }
        }
    }
    
    private IExpression parseExpression(final Deque<Token> lllllllllllllIIIlIllIlIIIIIllIlI) throws ParseException {
        final Token lllllllllllllIIIlIllIlIIIIIllIIl = lllllllllllllIIIlIllIlIIIIIllIlI.poll();
        checkNull(lllllllllllllIIIlIllIlIIIIIllIIl, "Missing expression");
        switch ($SWITCH_TABLE$net$optifine$entity$model$anim$EnumTokenType()[lllllllllllllIIIlIllIlIIIIIllIIl.getType().ordinal()]) {
            case 2: {
                return makeConstant(lllllllllllllIIIlIllIlIIIIIllIIl);
            }
            case 1: {
                final EnumFunctionType lllllllllllllIIIlIllIlIIIIIllIII = this.getFunctionType(lllllllllllllIIIlIllIlIIIIIllIIl, lllllllllllllIIIlIllIlIIIIIllIlI);
                if (lllllllllllllIIIlIllIlIIIIIllIII != null) {
                    return this.makeFunction(lllllllllllllIIIlIllIlIIIIIllIII, lllllllllllllIIIlIllIlIIIIIllIlI);
                }
                return this.makeVariable(lllllllllllllIIIlIllIlIIIIIllIIl);
            }
            case 5: {
                return this.makeBracketed(lllllllllllllIIIlIllIlIIIIIllIIl, lllllllllllllIIIlIllIlIIIIIllIlI);
            }
            case 3: {
                final EnumFunctionType lllllllllllllIIIlIllIlIIIIIlIlll = EnumFunctionType.parse(lllllllllllllIIIlIllIlIIIIIllIIl.getText());
                checkNull(lllllllllllllIIIlIllIlIIIIIlIlll, String.valueOf(new StringBuilder("Invalid operator: ").append(lllllllllllllIIIlIllIlIIIIIllIIl)));
                if (lllllllllllllIIIlIllIlIIIIIlIlll == EnumFunctionType.PLUS) {
                    return this.parseExpression(lllllllllllllIIIlIllIlIIIIIllIlI);
                }
                if (lllllllllllllIIIlIllIlIIIIIlIlll == EnumFunctionType.MINUS) {
                    final IExpression lllllllllllllIIIlIllIlIIIIIlIllI = this.parseExpression(lllllllllllllIIIlIllIlIIIIIllIlI);
                    return new Function(EnumFunctionType.NEG, new IExpression[] { lllllllllllllIIIlIllIlIIIIIlIllI });
                }
                break;
            }
        }
        throw new ParseException(String.valueOf(new StringBuilder("Invalid expression: ").append(lllllllllllllIIIlIllIlIIIIIllIIl)));
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$optifine$entity$model$anim$EnumTokenType() {
        final int[] $switch_TABLE$net$optifine$entity$model$anim$EnumTokenType = ExpressionParser.$SWITCH_TABLE$net$optifine$entity$model$anim$EnumTokenType;
        if ($switch_TABLE$net$optifine$entity$model$anim$EnumTokenType != null) {
            return $switch_TABLE$net$optifine$entity$model$anim$EnumTokenType;
        }
        final long lllllllllllllIIIlIllIIlllIIlIIlI = (Object)new int[EnumTokenType.values().length];
        try {
            lllllllllllllIIIlIllIIlllIIlIIlI[EnumTokenType.BRACKET_CLOSE.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIIlIllIIlllIIlIIlI[EnumTokenType.BRACKET_OPEN.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIIlIllIIlllIIlIIlI[EnumTokenType.COMMA.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIIlIllIIlllIIlIIlI[EnumTokenType.CONSTANT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIIIlIllIIlllIIlIIlI[EnumTokenType.IDENTIFIER.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIIIlIllIIlllIIlIIlI[EnumTokenType.OPERATOR.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return ExpressionParser.$SWITCH_TABLE$net$optifine$entity$model$anim$EnumTokenType = (int[])(Object)lllllllllllllIIIlIllIIlllIIlIIlI;
    }
    
    private IExpression makeVariable(final Token lllllllllllllIIIlIllIIllllIIllII) throws ParseException {
        if (this.modelResolver == null) {
            throw new ParseException(String.valueOf(new StringBuilder("Model variable not found: ").append(lllllllllllllIIIlIllIIllllIIllII)));
        }
        final IExpression lllllllllllllIIIlIllIIllllIIlllI = this.modelResolver.getExpression(lllllllllllllIIIlIllIIllllIIllII.getText());
        if (lllllllllllllIIIlIllIIllllIIlllI == null) {
            throw new ParseException(String.valueOf(new StringBuilder("Model variable not found: ").append(lllllllllllllIIIlIllIIllllIIllII)));
        }
        return lllllllllllllIIIlIllIIllllIIlllI;
    }
    
    private IExpression makeInfixFunc(final List<IExpression> lllllllllllllIIIlIllIlIIIlIIIlll, final List<EnumFunctionType> lllllllllllllIIIlIllIlIIIIllllll) throws ParseException {
        if (lllllllllllllIIIlIllIlIIIlIIIlll.size() != lllllllllllllIIIlIllIlIIIIllllll.size() + 1) {
            throw new ParseException(String.valueOf(new StringBuilder("Invalid infix expression, expressions: ").append(lllllllllllllIIIlIllIlIIIlIIIlll.size()).append(", operators: ").append(lllllllllllllIIIlIllIlIIIIllllll.size())));
        }
        if (lllllllllllllIIIlIllIlIIIlIIIlll.size() == 1) {
            return lllllllllllllIIIlIllIlIIIlIIIlll.get(0);
        }
        int lllllllllllllIIIlIllIlIIIlIIIlIl = Integer.MAX_VALUE;
        int lllllllllllllIIIlIllIlIIIlIIIlII = Integer.MIN_VALUE;
        for (final EnumFunctionType lllllllllllllIIIlIllIlIIIlIIIIll : lllllllllllllIIIlIllIlIIIIllllll) {
            lllllllllllllIIIlIllIlIIIlIIIlIl = Math.min(lllllllllllllIIIlIllIlIIIlIIIIll.getPrecedence(), lllllllllllllIIIlIllIlIIIlIIIlIl);
            lllllllllllllIIIlIllIlIIIlIIIlII = Math.max(lllllllllllllIIIlIllIlIIIlIIIIll.getPrecedence(), lllllllllllllIIIlIllIlIIIlIIIlII);
        }
        if (lllllllllllllIIIlIllIlIIIlIIIlII < lllllllllllllIIIlIllIlIIIlIIIlIl || lllllllllllllIIIlIllIlIIIlIIIlII - lllllllllllllIIIlIllIlIIIlIIIlIl > 10) {
            throw new ParseException(String.valueOf(new StringBuilder("Invalid infix precedence, min: ").append(lllllllllllllIIIlIllIlIIIlIIIlIl).append(", max: ").append(lllllllllllllIIIlIllIlIIIlIIIlII)));
        }
        for (int lllllllllllllIIIlIllIlIIIlIIIIlI = lllllllllllllIIIlIllIlIIIlIIIlII; lllllllllllllIIIlIllIlIIIlIIIIlI >= lllllllllllllIIIlIllIlIIIlIIIlIl; --lllllllllllllIIIlIllIlIIIlIIIIlI) {
            this.mergeOperators(lllllllllllllIIIlIllIlIIIlIIIlll, lllllllllllllIIIlIllIlIIIIllllll, lllllllllllllIIIlIllIlIIIlIIIIlI);
        }
        if (lllllllllllllIIIlIllIlIIIlIIIlll.size() == 1 && lllllllllllllIIIlIllIlIIIIllllll.size() == 0) {
            return lllllllllllllIIIlIllIlIIIlIIIlll.get(0);
        }
        throw new ParseException(String.valueOf(new StringBuilder("Error merging operators, expressions: ").append(lllllllllllllIIIlIllIlIIIlIIIlll.size()).append(", operators: ").append(lllllllllllllIIIlIllIlIIIIllllll.size())));
    }
    
    private static IExpression makeConstant(final Token lllllllllllllIIIlIllIlIIIIIIlIll) throws ParseException {
        final float lllllllllllllIIIlIllIlIIIIIIllII = Config.parseFloat(lllllllllllllIIIlIllIlIIIIIIlIll.getText(), Float.NaN);
        if (lllllllllllllIIIlIllIlIIIIIIllII == Float.NaN) {
            throw new ParseException(String.valueOf(new StringBuilder("Invalid float value: ").append(lllllllllllllIIIlIllIlIIIIIIlIll)));
        }
        return new Constant(lllllllllllllIIIlIllIlIIIIIIllII);
    }
    
    private void mergeOperators(final List<IExpression> lllllllllllllIIIlIllIlIIIIlIlIIl, final List<EnumFunctionType> lllllllllllllIIIlIllIlIIIIlIlIII, final int lllllllllllllIIIlIllIlIIIIlIllll) {
        for (int lllllllllllllIIIlIllIlIIIIlIlllI = 0; lllllllllllllIIIlIllIlIIIIlIlllI < lllllllllllllIIIlIllIlIIIIlIlIII.size(); ++lllllllllllllIIIlIllIlIIIIlIlllI) {
            final EnumFunctionType lllllllllllllIIIlIllIlIIIIlIllIl = lllllllllllllIIIlIllIlIIIIlIlIII.get(lllllllllllllIIIlIllIlIIIIlIlllI);
            if (lllllllllllllIIIlIllIlIIIIlIllIl.getPrecedence() == lllllllllllllIIIlIllIlIIIIlIllll) {
                lllllllllllllIIIlIllIlIIIIlIlIII.remove(lllllllllllllIIIlIllIlIIIIlIlllI);
                final IExpression lllllllllllllIIIlIllIlIIIIlIllII = lllllllllllllIIIlIllIlIIIIlIlIIl.remove(lllllllllllllIIIlIllIlIIIIlIlllI);
                final IExpression lllllllllllllIIIlIllIlIIIIlIlIll = lllllllllllllIIIlIllIlIIIIlIlIIl.remove(lllllllllllllIIIlIllIlIIIIlIlllI);
                final IExpression lllllllllllllIIIlIllIlIIIIlIlIlI = new Function(lllllllllllllIIIlIllIlIIIIlIllIl, new IExpression[] { lllllllllllllIIIlIllIlIIIIlIllII, lllllllllllllIIIlIllIlIIIIlIlIll });
                lllllllllllllIIIlIllIlIIIIlIlIIl.add(lllllllllllllIIIlIllIlIIIIlIlllI, lllllllllllllIIIlIllIlIIIIlIlIlI);
                --lllllllllllllIIIlIllIlIIIIlIlllI;
            }
        }
    }
    
    private IExpression[] parseExpressions(final Deque<Token> lllllllllllllIIIlIllIIlllllIIlII) throws ParseException {
        final List<IExpression> lllllllllllllIIIlIllIIlllllIIIll = new ArrayList<IExpression>();
        while (true) {
            final Deque<Token> lllllllllllllIIIlIllIIlllllIIIlI = getGroup(lllllllllllllIIIlIllIIlllllIIlII, EnumTokenType.COMMA, false);
            final IExpression lllllllllllllIIIlIllIIlllllIIIIl = this.parseInfix(lllllllllllllIIIlIllIIlllllIIIlI);
            if (lllllllllllllIIIlIllIIlllllIIIIl == null) {
                break;
            }
            lllllllllllllIIIlIllIIlllllIIIll.add(lllllllllllllIIIlIllIIlllllIIIIl);
        }
        final IExpression[] lllllllllllllIIIlIllIIlllllIIIII = lllllllllllllIIIlIllIIlllllIIIll.toArray(new IExpression[lllllllllllllIIIlIllIIlllllIIIll.size()]);
        return lllllllllllllIIIlIllIIlllllIIIII;
    }
    
    private IExpression makeBracketed(final Token lllllllllllllIIIlIllIIllllIIIllI, final Deque<Token> lllllllllllllIIIlIllIIllllIIIIlI) throws ParseException {
        final Deque<Token> lllllllllllllIIIlIllIIllllIIIlII = getGroup(lllllllllllllIIIlIllIIllllIIIIlI, EnumTokenType.BRACKET_CLOSE, true);
        return this.parseInfix(lllllllllllllIIIlIllIIllllIIIlII);
    }
    
    private static void checkNull(final Object lllllllllllllIIIlIllIIlllIlIlIll, final String lllllllllllllIIIlIllIIlllIlIlIlI) throws ParseException {
        if (lllllllllllllIIIlIllIIlllIlIlIll == null) {
            throw new ParseException(lllllllllllllIIIlIllIIlllIlIlIlI);
        }
    }
    
    public IExpression parse(final String lllllllllllllIIIlIllIlIIIllllIll) throws ParseException {
        try {
            final Token[] lllllllllllllIIIlIllIlIIIlllllll = TokenParser.parse(lllllllllllllIIIlIllIlIIIllllIll);
            if (lllllllllllllIIIlIllIlIIIlllllll == null) {
                return null;
            }
            final Deque<Token> lllllllllllllIIIlIllIlIIIllllllI = new ArrayDeque<Token>(Arrays.asList(lllllllllllllIIIlIllIlIIIlllllll));
            return this.parseInfix(lllllllllllllIIIlIllIlIIIllllllI);
        }
        catch (IOException lllllllllllllIIIlIllIlIIIlllllIl) {
            throw new ParseException(lllllllllllllIIIlIllIlIIIlllllIl.getMessage(), lllllllllllllIIIlIllIlIIIlllllIl);
        }
    }
    
    private IExpression makeInfix(final List<IExpression> lllllllllllllIIIlIllIlIIIlIllIll, final List<Token> lllllllllllllIIIlIllIlIIIlIllIlI) throws ParseException {
        final List<EnumFunctionType> lllllllllllllIIIlIllIlIIIlIllIIl = new LinkedList<EnumFunctionType>();
        for (final Token lllllllllllllIIIlIllIlIIIlIllIII : lllllllllllllIIIlIllIlIIIlIllIlI) {
            final EnumFunctionType lllllllllllllIIIlIllIlIIIlIlIlll = EnumFunctionType.parse(lllllllllllllIIIlIllIlIIIlIllIII.getText());
            checkNull(lllllllllllllIIIlIllIlIIIlIlIlll, String.valueOf(new StringBuilder("Invalid operator: ").append(lllllllllllllIIIlIllIlIIIlIllIII)));
            lllllllllllllIIIlIllIlIIIlIllIIl.add(lllllllllllllIIIlIllIlIIIlIlIlll);
        }
        return this.makeInfixFunc(lllllllllllllIIIlIllIlIIIlIllIll, lllllllllllllIIIlIllIlIIIlIllIIl);
    }
    
    private IExpression makeFunction(final EnumFunctionType lllllllllllllIIIlIllIIllllllIIII, final Deque<Token> lllllllllllllIIIlIllIIllllllIlIl) throws ParseException {
        if (lllllllllllllIIIlIllIIllllllIIII.getCountArguments() == 0) {
            return makeFunction(lllllllllllllIIIlIllIIllllllIIII, new IExpression[0]);
        }
        final Token lllllllllllllIIIlIllIIllllllIlII = lllllllllllllIIIlIllIIllllllIlIl.poll();
        final Deque<Token> lllllllllllllIIIlIllIIllllllIIll = getGroup(lllllllllllllIIIlIllIIllllllIlIl, EnumTokenType.BRACKET_CLOSE, true);
        final IExpression[] lllllllllllllIIIlIllIIllllllIIlI = this.parseExpressions(lllllllllllllIIIlIllIIllllllIIll);
        return makeFunction(lllllllllllllIIIlIllIIllllllIIII, lllllllllllllIIIlIllIIllllllIIlI);
    }
    
    private IExpression parseInfix(final Deque<Token> lllllllllllllIIIlIllIlIIIllIlIIl) throws ParseException {
        if (lllllllllllllIIIlIllIlIIIllIlIIl.isEmpty()) {
            return null;
        }
        final List<IExpression> lllllllllllllIIIlIllIlIIIllIllll = new LinkedList<IExpression>();
        final List<Token> lllllllllllllIIIlIllIlIIIllIlllI = new LinkedList<Token>();
        final IExpression lllllllllllllIIIlIllIlIIIllIllIl = this.parseExpression(lllllllllllllIIIlIllIlIIIllIlIIl);
        checkNull(lllllllllllllIIIlIllIlIIIllIllIl, "Missing expression");
        lllllllllllllIIIlIllIlIIIllIllll.add(lllllllllllllIIIlIllIlIIIllIllIl);
        while (true) {
            final Token lllllllllllllIIIlIllIlIIIllIllII = lllllllllllllIIIlIllIlIIIllIlIIl.poll();
            if (lllllllllllllIIIlIllIlIIIllIllII == null) {
                return this.makeInfix(lllllllllllllIIIlIllIlIIIllIllll, lllllllllllllIIIlIllIlIIIllIlllI);
            }
            if (lllllllllllllIIIlIllIlIIIllIllII.getType() != EnumTokenType.OPERATOR) {
                throw new ParseException(String.valueOf(new StringBuilder("Invalid operator: ").append(lllllllllllllIIIlIllIlIIIllIllII)));
            }
            final IExpression lllllllllllllIIIlIllIlIIIllIlIll = this.parseExpression(lllllllllllllIIIlIllIlIIIllIlIIl);
            checkNull(lllllllllllllIIIlIllIlIIIllIlIll, "Missing expression");
            lllllllllllllIIIlIllIlIIIllIlllI.add(lllllllllllllIIIlIllIlIIIllIllII);
            lllllllllllllIIIlIllIlIIIllIllll.add(lllllllllllllIIIlIllIlIIIllIlIll);
        }
    }
    
    private static Deque<Token> getGroup(final Deque<Token> lllllllllllllIIIlIllIIlllIlllIlI, final EnumTokenType lllllllllllllIIIlIllIIlllIlllIIl, final boolean lllllllllllllIIIlIllIIlllIllIIlI) throws ParseException {
        final Deque<Token> lllllllllllllIIIlIllIIlllIllIlll = new ArrayDeque<Token>();
        int lllllllllllllIIIlIllIIlllIllIllI = 0;
        final Iterator lllllllllllllIIIlIllIIlllIllIlIl = lllllllllllllIIIlIllIIlllIllIlll.iterator();
        while (lllllllllllllIIIlIllIIlllIllIlIl.hasNext()) {
            final Token lllllllllllllIIIlIllIIlllIllIlII = lllllllllllllIIIlIllIIlllIllIlIl.next();
            lllllllllllllIIIlIllIIlllIllIlIl.remove();
            if (lllllllllllllIIIlIllIIlllIllIllI == 0 && lllllllllllllIIIlIllIIlllIllIlII.getType() == lllllllllllllIIIlIllIIlllIlllIIl) {
                return lllllllllllllIIIlIllIIlllIllIlll;
            }
            lllllllllllllIIIlIllIIlllIllIlll.add(lllllllllllllIIIlIllIIlllIllIlII);
            if (lllllllllllllIIIlIllIIlllIllIlII.getType() == EnumTokenType.BRACKET_OPEN) {
                ++lllllllllllllIIIlIllIIlllIllIllI;
            }
            if (lllllllllllllIIIlIllIIlllIllIlII.getType() != EnumTokenType.BRACKET_CLOSE) {
                continue;
            }
            --lllllllllllllIIIlIllIIlllIllIllI;
        }
        if (lllllllllllllIIIlIllIIlllIllIIlI) {
            throw new ParseException(String.valueOf(new StringBuilder("Missing end token: ").append(lllllllllllllIIIlIllIIlllIlllIIl)));
        }
        return lllllllllllllIIIlIllIIlllIllIlll;
    }
    
    private EnumFunctionType getFunctionType(final Token lllllllllllllIIIlIllIlIIIIIIIlIl, final Deque<Token> lllllllllllllIIIlIllIlIIIIIIIlII) throws ParseException {
        final Token lllllllllllllIIIlIllIlIIIIIIIIll = lllllllllllllIIIlIllIlIIIIIIIlII.peek();
        if (lllllllllllllIIIlIllIlIIIIIIIIll != null && lllllllllllllIIIlIllIlIIIIIIIIll.getType() == EnumTokenType.BRACKET_OPEN) {
            final EnumFunctionType lllllllllllllIIIlIllIlIIIIIIIIlI = EnumFunctionType.parse(lllllllllllllIIIlIllIlIIIIIIIIll.getText());
            checkNull(lllllllllllllIIIlIllIlIIIIIIIIlI, String.valueOf(new StringBuilder("Unknown function: ").append(lllllllllllllIIIlIllIlIIIIIIIIll)));
            return lllllllllllllIIIlIllIlIIIIIIIIlI;
        }
        final EnumFunctionType lllllllllllllIIIlIllIlIIIIIIIIIl = EnumFunctionType.parse(lllllllllllllIIIlIllIlIIIIIIIIll.getText());
        if (lllllllllllllIIIlIllIlIIIIIIIIIl == null) {
            return null;
        }
        if (lllllllllllllIIIlIllIlIIIIIIIIIl.getCountArguments() > 0) {
            throw new ParseException(String.valueOf(new StringBuilder("Missing arguments: ").append(lllllllllllllIIIlIllIlIIIIIIIIIl)));
        }
        return lllllllllllllIIIlIllIlIIIIIIIIIl;
    }
    
    public ExpressionParser(final IModelResolver lllllllllllllIIIlIllIlIIlIIIlIII) {
        this.modelResolver = lllllllllllllIIIlIllIlIIlIIIlIII;
    }
}
