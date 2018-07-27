package restapi.yoodobuzz.com.popularplace;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private PlaceAdapter_Activity adapter;
    private List<ProductModel> placeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyler_placeList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, 10, true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        PlaceField();

    }

    private void PlaceField() {
        progressDialog = new ProgressDialog(this);
        progressDialog.show();
        progressDialog.setMessage("Loading");
        progressDialog.setCancelable(true);

        RetrofitInterface_Activity.APIInterface apiInterface = RetrofitInterface_Activity.getClient();

        Call<PopularResponse> call1 = apiInterface.getLangResp();

        call1.enqueue(new Callback<PopularResponse>() {
            @Override
            public void onResponse(Call<PopularResponse> call, Response<PopularResponse> response) {
                //progressDialog.dismiss();
                PopularResponse user = response.body();
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), user.getResponse().status, Toast.LENGTH_SHORT).show();
                 placeList = new ArrayList<>();

                placeList = user.response.products;
                Log.w("MainActivity", String.valueOf(placeList.size()));
                recyclerView.setHasFixedSize(true);
                adapter = new PlaceAdapter_Activity(MainActivity.this, placeList);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<PopularResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Please try again", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        });

    }

}

