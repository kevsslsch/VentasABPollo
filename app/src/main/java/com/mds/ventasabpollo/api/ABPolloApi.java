package com.mds.ventasabpollo.api;

import com.mds.ventasabpollo.models.WResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ABPolloApi {

    @GET("abpollo")
    Call<WResponse> getConnectionData();

    @GET("versions/abpollo")
    Call<WResponse> getLastVersion();

}