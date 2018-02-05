package com.tamboraagungmakmur.adsplus.config;

/**
 * Created by RedLyst on 17/01/2018.
 */

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {

    @POST("otoads/")
    Call<ServerResponse> operation(@Body ServerRequest request);

}
