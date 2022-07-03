package com.kisman.nr.cc.manager;

import com.kisman.nr.cc.manager.managers.*;

public class Managers
{
    public static /* synthetic */ Managers instance;
    public /* synthetic */ ServerManager serverManager;
    
    public void init() {
        this.serverManager = new ServerManager();
    }
    
    public Managers() {
        Managers.instance = this;
    }
}
