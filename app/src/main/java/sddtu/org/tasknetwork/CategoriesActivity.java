package sddtu.org.tasknetwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lapism.searchview.SearchView;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Category> dataset = new TestData().getTestData();
        MyAdapter adapter = new MyAdapter(dataset);
        recyclerView.setAdapter(adapter);

        SearchView searchView = (SearchView) findViewById(R.id.searchView);


    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

        private ArrayList<Category> mDataset;

        MyAdapter(ArrayList<Category> data){
            mDataset = data;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = getLayoutInflater().inflate(R.layout.card_item_category, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.mTitleTv.setText(mDataset.get(position).mTitle);
            Glide.with(getApplicationContext())
                    .load(mDataset.get(position).mUrl)
                    .centerCrop()
                    .into(holder.mImageView);
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            TextView mTitleTv;
            ImageView mImageView;
            ViewHolder(View v) {
                super(v);
                mTitleTv = (TextView) v.findViewById(R.id.textViewTitle);
                mImageView = (ImageView) v.findViewById(R.id.imageViewCategory);
            }
        }
    }

    // Just for testing
    private class TestData {
        ArrayList<Category> mCategoryList;
        ArrayList<Category> getTestData(){
            mCategoryList = new ArrayList<>();

            Category category;

            category = new Category("Carpenter", "https://res.cloudinary.com/urbanclap/image/upload/t_medium_res_category/categories/home_screen/carpenter.jpg");
            mCategoryList.add(category);

            category = new Category("Doctor", "https://www.iaspaper.net/wp-content/uploads/2017/01/Doctor.jpg");
            mCategoryList.add(category);

            category = new Category("Yoga Trainer", "https://res.cloudinary.com/urbanclap/image/upload/t_medium_res_category/categories/home_screen/categories/Yoga-at-home.jpg");
            mCategoryList.add(category);

            category = new Category("Electrician", "https://res.cloudinary.com/urbanclap/image/upload/t_medium_res_category/categories/home_screen/electrician.jpg");
            mCategoryList.add(category);

            category = new Category("Wedding Photographer", "https://res.cloudinary.com/urbanclap/image/upload/t_medium_res_category/categories/home_screen/wedding_photographer.jpg");
            mCategoryList.add(category);

            category = new Category("Tutor", "https://res.cloudinary.com/urbanclap/image/upload/t_medium_res_category/categories/bigpictures/version-2-2/android/science_tutor.jpg");
            mCategoryList.add(category);

            category = new Category("Packers and Movers", "https://res.cloudinary.com/urbanclap/image/upload/t_medium_res_category/categories/home_screen/categories/nonbooking/packers-and-movers.jpg");
            mCategoryList.add(category);

            category = new Category("Lawyer", "https://res.cloudinary.com/urbanclap/image/upload/t_medium_res_category/categories/bigpictures/version-2-2/android/lawyer.jpg");
            mCategoryList.add(category);

            category = new Category("Web Developer", "https://res.cloudinary.com/urbanclap/image/upload/t_medium_res_category/categories/home_screen/categories/nonbooking/web-designer.jpg");
            mCategoryList.add(category);

            //            new Category("", "");

            return mCategoryList;
        }
    }

    // Will be moved to its own file later on.
    private class Category {
        String mTitle;
        String mUrl;

        Category(String title, String url){
            mTitle = title;
            mUrl = url;
        }
    }
}
