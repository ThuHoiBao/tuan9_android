package com.example.recycleview_indicator_search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.IconHolder> {

    private Context context;
    private List<IconModel> arrayList;

    // Constructor nhận Context và List IconModel
    public IconAdapter(Context context, List<IconModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public IconHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Tạo ViewHolder từ layout item_icon_promotion
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_icon_promotion, parent, false);
        return new IconHolder(view);
    }

    @Override
    public void onBindViewHolder(IconHolder holder, int position) {
        // Gán dữ liệu vào ViewHolder
        IconModel iconModel = arrayList.get(position);
        Glide.with(context).load(iconModel.getImgId()).into(holder.imageView);
        holder.tvIcon.setText(iconModel.getDesc());
    }

    @Override
    public int getItemCount() {
        // Trả về số lượng phần tử trong arrayList
        return arrayList != null ? arrayList.size() : 0;
    }

    // Lớp IconHolder kế thừa từ RecyclerView.ViewHolder
    public static class IconHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView tvIcon;

        public IconHolder(View itemView) {
            super(itemView);
            // Khởi tạo các view từ itemView
            imageView = itemView.findViewById(R.id.ivImgIcon);
            tvIcon = itemView.findViewById(R.id.tvIcon);
        }
    }

    // Phương thức để cập nhật danh sách sau khi lọc
    public void setListenerList(List<IconModel> iconModelList) {
        this.arrayList = iconModelList;
        notifyDataSetChanged();  // Thông báo thay đổi dữ liệu
    }
}
