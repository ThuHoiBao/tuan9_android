package com.example.recycleview_indicator_search;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private IconAdapter iconAdapter;
    private List<IconModel> arrayList = new ArrayList<>();
    private RecyclerView rcIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcIcon = findViewById(R.id.rlcon);

        // Thêm dữ liệu vào arrayList
        arrayList.add(new IconModel(R.drawable.livechat, "jfjdjfdjfd"));
        arrayList.add(new IconModel(R.drawable.money, "sdffd sfdsf"));
        arrayList.add(new IconModel(R.drawable.people, "dfgfhhyh sxdf"));
        arrayList.add(new IconModel(R.drawable.order, "tran anh thu"));
        arrayList.add(new IconModel(R.drawable.phone, "Anh Thư"));
        arrayList.add(new IconModel(R.drawable.people, "Thanh thuy"));
        // Tiếp tục thêm các dữ liệu...

        // Tạo LayoutManager và Adapter
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        rcIcon.setLayoutManager(gridLayoutManager);

        iconAdapter = new IconAdapter(this, arrayList);
        rcIcon.setAdapter(iconAdapter);

        // Thêm sự kiện cho SearchView
        SearchView searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;  // Không làm gì khi nhấn submit
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterListener(newText);  // Lọc dữ liệu khi người dùng gõ
                return true;
            }
        });
    }

    private void filterListener(String text) {
        List<IconModel> list = new ArrayList<>();
        // Lọc danh sách các item dựa trên mô tả (description)
        for (IconModel iconModel : arrayList) {
            if (iconModel.getDesc().toLowerCase().contains(text.toLowerCase())) {
                list.add(iconModel);
            }
        }

        // Nếu danh sách trống, hiển thị Toast thông báo
        if (list.isEmpty()) {
            Toast.makeText(this, "Không có dữ liệu", Toast.LENGTH_SHORT).show();
        } else {
            // Cập nhật danh sách vào Adapter
            iconAdapter.setListenerList(list);
        }
    }
}
