package org.framework.api;

import org.framework.api.methods.GetToken;

public class Spotify {
    public void api(String clientId, String clientSecret, String redirectUri, String code){
        GetToken getToken = new GetToken();
        getToken.getSpotifyToken(clientId, clientSecret, redirectUri, code);
    }
}
