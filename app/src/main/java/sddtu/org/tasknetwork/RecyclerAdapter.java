package sddtu.org.tasknetwork;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ASHISH KUMAR on 3/15/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CardDataHolder> {

    private ArrayList<CardData> arrayList;

    public RecyclerAdapter(ArrayList arrayList){
        this.arrayList=arrayList;
    }

    public class CardDataHolder extends RecyclerView.ViewHolder  {

        TextView textView;
        public CardDataHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.textView);
        }


    }

    @Override
    public RecyclerAdapter.CardDataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout,parent,false);
        CardDataHolder cardDataHolder=new CardDataHolder(view);
        return cardDataHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.CardDataHolder holder, int position) {

        holder.textView.setText(arrayList.get(position).getT1());

    }

    @Override
    public int getItemCount() {
        return arrayList.size() ;
    }



}
