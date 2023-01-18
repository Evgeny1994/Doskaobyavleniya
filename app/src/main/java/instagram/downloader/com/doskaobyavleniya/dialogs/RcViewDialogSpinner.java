package instagram.downloader.com.doskaobyavleniya.dialogs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;
import instagram.downloader.com.doskaobyavleniya.R;

/**
 * Created by Евгений on 18.01.2023.
 */

public class RcViewDialogSpinner extends RecyclerView.Adapter<RcViewDialogSpinner.ViewHolder> {
    ArrayList<String> mainList = new ArrayList<>();
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sp_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

      holder.setData(mainList.get(position));
        //mainList.get((Integer) mainList.get(position));
        //holder.getItemId(mainList.get(position));
     //   holder.getAdapterPosition(mainList.get(position));
     //   holder.getData(mainList.get(position));

    }

    @Override
    public int getItemCount() {
        return mainList.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder
    {

        public ViewHolder(View view) {
            super(view);
            TextView tvSpItem = itemView.findViewById(R.id.tvSpItem);
            tvSpItem.getText();
        }

        public void setData(String text) {
            TextView tvSpItem = itemView.findViewById(R.id.tvSpItem);
            tvSpItem.setText(text);
        }
    }

    public void updateAdapter(ArrayList<String> list)
    {
        mainList.clear();
        mainList.addAll(list);
        notifyDataSetChanged();
    }
}
