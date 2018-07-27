package restapi.yoodobuzz.com.popularplace;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitInterface_Activity {

    public static APIInterface apiInterface;
    public static String BASE_URL = "http://macroidapps.com";


    public static APIInterface getClient() {

        if (apiInterface == null) {

            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient okHttpClient1 = new OkHttpClient().newBuilder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(130, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
//                    .build();

                    .addInterceptor(httpLoggingInterceptor).build();
            Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .client(okHttpClient1)
                    .addConverterFactory(GsonConverterFactory.create()).build();

            apiInterface = retrofit.create(APIInterface.class);
        }

        return apiInterface;
    }

    public interface APIInterface {
        // @Headers("Content-Type: application/json")
        @GET("/test/api/v1/all_ladieshostels")
        Call<PopularResponse> getLangResp();

    }
}

