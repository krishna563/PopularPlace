package restapi.yoodobuzz.com.popularplace;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import java.util.List;

public class PlaceAdapter_Activity extends RecyclerView.Adapter<PlaceAdapter_Activity.MovieHolder> {

    private Context mContext;
    private List<ProductModel> placeList;

    public PlaceAdapter_Activity(Context mContext, List<ProductModel> placeList) {
        this.mContext = mContext;
        this.placeList = placeList;

    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_place, parent, false);
        return new MovieHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MovieHolder holder, int position) {
        ProductModel Placeload = placeList.get(position);

            holder.title.setText(Placeload.getPname());
            holder.area.setText(Placeload.getArea());
            Glide.with(mContext).load(Placeload.getImage()).into(holder.thumbnail);


    }

    @Override
    public int getItemCount() {
        return 5;
    }



    public class MovieHolder extends RecyclerView.ViewHolder {
        public TextView title, area;
        public ImageView thumbnail;


        public MovieHolder(View View) {
            super(View);

            title = (TextView) View.findViewById(R.id.txt_pname);
            area = (TextView) View.findViewById(R.id.txt_area);
            thumbnail = (ImageView) View.findViewById(R.id.title_image);


        }
    }
}
