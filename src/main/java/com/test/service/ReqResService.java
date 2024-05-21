package com.test.service;

import com.test.dto.GetApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ReqResService {
    @Headers({"Content-Type: application/json"})
    @GET("api/users")
    Call<GetApiResponse> getData(@Query("page") int page);
}
