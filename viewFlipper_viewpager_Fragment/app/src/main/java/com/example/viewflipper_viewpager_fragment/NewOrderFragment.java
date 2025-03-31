package com.example.viewflipper_viewpager_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.viewflipper_viewpager_fragment.databinding.FragmentNewOrderBinding;

public class NewOrderFragment extends Fragment {

    private FragmentNewOrderBinding binding; // Khai báo ViewBinding

    public NewOrderFragment() {
        super(R.layout.fragment_neworder); // Gắn layout XML cho Fragment
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentNewOrderBinding.inflate(inflater, container, false); // Sử dụng ViewBinding

        // Ví dụ sử dụng binding để thay đổi nội dung TextView
        binding.textView.setText("New Order"); // Giả sử bạn có TextView với ID textView trong layout

        // Nếu cần load dữ liệu từ Adapter hoặc RecyclerView, bạn có thể làm ở đây
        // Ví dụ:
        // Adapter adapter = new YourAdapter(data);
        // binding.recyclerView.setAdapter(adapter);

        return binding.getRoot(); // Trả về root view của layout
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Giải phóng tài nguyên khi Fragment bị hủy
    }
}
