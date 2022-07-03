package me.nrules.commands;

public abstract class Command
{
    public abstract String getSyntax();
    
    public abstract String getDescription();
    
    public abstract void onCommand(final String p0, final String[] p1) throws Exception;
    
    public abstract String getAlias();
}
