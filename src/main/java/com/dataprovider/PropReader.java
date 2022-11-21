package com.dataprovider;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/main/resources/envconfig.properties"})
public interface PropReader extends Config {

    @DefaultValue("staging")
    String environment();

    @Key("${environment}.usernameMerchant")
    String usernameMerchant();
    @Key("${environment}.passwordMerchant")
    String passwordMerchant();
    @Key("${environment}.urlMerchant")
    String urlMerchant();
    @Key("${environment}.usernameAdmin")
    String usernameAdmin();
    @Key("${environment}.passwordAdmin")
    String passwordAdmin();
    @Key("${environment}.urlAdmin")
    String urlAdmin();
    @Key("${environment}.urlCustomer")
    String urlCustomer();

}
