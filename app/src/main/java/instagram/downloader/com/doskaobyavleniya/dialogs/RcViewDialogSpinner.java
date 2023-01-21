package instagram.downloader.com.doskaobyavleniya.dialogs;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import instagram.downloader.com.doskaobyavleniya.R;
import instagram.downloader.com.doskaobyavleniya.act.EditAdsAct;

/**
 * Created by Евгений on 18.01.2023.
 */

public class RcViewDialogSpinner extends RecyclerView.Adapter<RcViewDialogSpinner.ViewHolder> {


    public Context context;
    public AlertDialog dialog;

    public RcViewDialogSpinner(Context context, AlertDialog dialog) {
        this.context = context;
        this.dialog = dialog;
    }

    public AlertDialog getDialog() {
        return dialog;
    }

    public void setDialog(AlertDialog dialog) {
        this.dialog = dialog;
    }

    ArrayList<String> mainList = new ArrayList<>();


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sp_list_item, parent, false);
        return new ViewHolder(view, context, dialog);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.setData(mainList.get(position));
    }

    @Override
    public int getItemCount() {
        return mainList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ViewHolder(View view, Context context, AlertDialog dialog) {
            super(view);

            TextView tvSpItem = itemView.findViewById(R.id.tvSpItem);
            tvSpItem.getText();
        }

        public void setData(String text) {
            TextView tvSpItem = itemView.findViewById(R.id.tvSpItem);
            tvSpItem.setText(text);
            // final String S12 = tvSpItem.getText().toString();
            tvSpItem.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            TextView tvSpItem = itemView.findViewById(R.id.tvSpItem);
            Intent intent = new Intent(itemView.getContext(), EditAdsAct.class);
            intent.putExtra("fname", tvSpItem.getText().toString());
            itemView.getContext().startActivity(intent);


        }

    }

    public void updateAdapter(ArrayList<String> list) {
        mainList.clear();
        mainList.addAll(list);
        notifyDataSetChanged();
    }
}
