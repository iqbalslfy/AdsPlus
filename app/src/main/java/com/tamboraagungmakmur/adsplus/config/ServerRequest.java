package com.tamboraagungmakmur.adsplus.config;

/**
 * Created by RedLyst on 17/01/2018.
 */

public class ServerRequest {

    private String operation;
    private User user;

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
