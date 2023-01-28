package instagram.downloader.com.doskaobyavleniya.frag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;
import instagram.downloader.com.doskaobyavleniya.R;

/**
 * Created by Евгений on 28.01.2023.
 */

public class SelectImageRvAdapter extends RecyclerView.Adapter<SelectImageRvAdapter.ViewHolder> {
    ArrayList<String> mainArray = new ArrayList<>();


    @Override
    public SelectImageRvAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_image_frag_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SelectImageRvAdapter.ViewHolder holder, int position) {
        holder.setData(mainArray.get(position));

    }

    @Override
    public int getItemCount() {
        return mainArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void setData(String text) {

    }
}


    }
