package toong.vn.androidmarqueeinrecyclerview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OneItemTypeAdapter extends RecyclerView.Adapter<OneItemTypeAdapter.ViewHolder> {
    private static final String TAG = "OneItemTypeAdapter";
    private Item[] mData;
    private LayoutInflater mInflater;
    private ItemClickListener mItemClickListener;

    public OneItemTypeAdapter(Context context, Item[] data) {
        mInflater = LayoutInflater.from(context);
        mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, mItemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = mData[position];
        holder.bindItem(item);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemClickListener mItemClickListener;
        private TextView myTextView;
        private LinearLayout linear_parent;

        private ViewHolder(View itemView, ItemClickListener itemClickListener) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.info_text);
            linear_parent = itemView.findViewById(R.id.linear_parent);
            mItemClickListener = itemClickListener;

            itemView.setOnClickListener(this);
        }

        void bindItem(Item item) {
            myTextView.setText(item.getTitle());
            if(getAdapterPosition() == 5){
                linear_parent.setSelected(true);
                myTextView.setTextColor(Color.RED);
            }else{
                linear_parent.setSelected(false);
                myTextView.setTextColor(Color.BLACK);
            }
            myTextView.setSelected(true);
        }

        @Override
        public void onClick(View view) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}