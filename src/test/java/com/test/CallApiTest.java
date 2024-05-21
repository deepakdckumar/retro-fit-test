package com.test;

import com.test.dto.GetApiResponse;
import com.test.service.ReqResService;
import lombok.extern.log4j.Log4j2;
import okhttp3.OkHttpClient;
import org.testng.annotations.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.time.Duration;

@Log4j2
public class CallApiTest {
    @Test
    public void callApiTest() throws IOException {
        String baseUrl = "https://reqres.in/";
        OkHttpClient client = new OkHttpClient().newBuilder()
                .readTimeout(Duration.ofSeconds(10))
                .writeTimeout(Duration.ofSeconds(10))
                .connectTimeout(Duration.ofSeconds(10)).build();
        Retrofit retrofit = new Retrofit.Builder().client(client).baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build();
        ReqResService reqResService = retrofit.create(ReqResService.class);
        Call<GetApiResponse> call = reqResService.getData(2);
        Response<GetApiResponse> response = call.execute();
        log.info(response.body());
    }
}
