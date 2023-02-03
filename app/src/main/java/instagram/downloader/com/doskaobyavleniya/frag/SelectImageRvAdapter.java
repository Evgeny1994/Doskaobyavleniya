package instagram.downloader.com.doskaobyavleniya.frag;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import instagram.downloader.com.doskaobyavleniya.R;

/**
 * Created by Евгений on 28.01.2023.
 */

public class SelectImageRvAdapter extends RecyclerView.Adapter<SelectImageRvAdapter.ViewHolder> {

    SelectImageItem selectImageItem;

    public SelectImageRvAdapter() {
        this.selectImageItem = selectImageItem;
    }

    public SelectImageItem getSelectImageItem() {
        return selectImageItem;
    }

    ArrayList<SelectImageItem> mainArray = new ArrayList<>();



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

//    public void updateAdapter(List<SelectImageItem> newList) {
//        mainArray.clear();
//        mainArray.addAll(newList);
 //       notifyDataSetChanged();
//    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void setData(SelectImageItem item) {
            TextView tvTitle = itemView.findViewById(R.id.tvTitle);
            ImageView image = itemView.findViewById(R.id.imageView);
            tvTitle.setText(item.title);
            image.setImageURI(Uri.parse(item.imageUrl));


    }
}

  public void  updateAdapter(List<SelectImageItem> newList)
  {
      mainArray.clear();
      mainArray.addAll(newList);
      notifyDataSetChanged();


  }


    }
