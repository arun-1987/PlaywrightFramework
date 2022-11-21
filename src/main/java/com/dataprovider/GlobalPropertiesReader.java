package com.dataprovider;

import org.aeonbits.owner.ConfigFactory;

public class GlobalPropertiesReader {

    public static PropReader propReader(){
        return ConfigFactory.create(PropReader.class);
    }

}
