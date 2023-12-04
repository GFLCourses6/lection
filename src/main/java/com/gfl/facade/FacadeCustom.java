package com.gfl.facade;

import com.gfl.facade.singletones.SingletonA;
import com.gfl.facade.singletones.SingletonB;
import com.gfl.facade.singletones.SingletonC;
import com.gfl.facade.singletones.SingletonD;

public class FacadeCustom {
    public void create(){
        SingletonA.getInstance().action();
        SingletonB.getInstance().action();
        SingletonC.getInstance().action();
        SingletonD.getInstance().action();
    }
}
