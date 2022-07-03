package org.yaml.snakeyaml.scanner;

import org.yaml.snakeyaml.tokens.*;

public interface Scanner
{
    Token peekToken();
    
    boolean checkToken(final Token.ID... p0);
    
    Token getToken();
}
