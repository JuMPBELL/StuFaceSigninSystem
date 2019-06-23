package com.stufacesigninsystem.demo.Mapper;

import com.auth0.jwt.interfaces.DecodedJWT;

public interface TokenInterface {
    public String createToken(String stuid, String password);
    public DecodedJWT parseJWT(String jwt);

}
