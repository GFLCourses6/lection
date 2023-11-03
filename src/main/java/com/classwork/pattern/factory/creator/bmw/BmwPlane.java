package com.classwork.pattern.factory.creator.bmw;

import com.classwork.pattern.factory.creator.Plane;

public class BmwPlane extends Plane<Bmw> {

    public BmwPlane(Bmw driver, Bmw navigator) {
        super(driver, navigator);

    }

    @Override
    public void create() {
        System.out.println("Creating Bmw Plane");
    }
}