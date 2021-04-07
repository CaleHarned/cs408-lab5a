package edu.jsu.mcis.cs408.cs408lab5a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<String> data;
    public RecyclerViewAdapter(List<String> data) {
        this.data = data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.memo_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setMemo(data.get(position));
        holder.bindData();
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private String memo;
        private TextView memoLabel;

        public ViewHolder(View itemView) {

            super(itemView);
        }
        public String getmemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public void bindData() {
            if (memoLabel== null) {memoLabel= (TextView) itemView.findViewById(R.id.memoLabel);
            }

            memoLabel.setText(memo);
        }

    }
}

