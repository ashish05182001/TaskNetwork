package sddtu.org.tasknetwork;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dell on 3/17/2017.
 */

public class RecyclerInnerAdapter extends RecyclerView.Adapter<RecyclerInnerAdapter.CardListHolder> {

    private ArrayList<Provider> arraylList;

    public RecyclerInnerAdapter(ArrayList<Provider> arrayList){
        this.arraylList=arrayList;
    }

    public class CardListHolder extends RecyclerView.ViewHolder{

        TextView mNameView;
        TextView mDescriptionView;
        public CardListHolder(final View itemView) {
            super(itemView);
            mNameView = (TextView)itemView.findViewById(R.id.textViewPersonName);
            mDescriptionView = (TextView) itemView.findViewById(R.id.textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //TODO: Start booking procedure here

                }
            });
        }
    }
    @Override
    public RecyclerInnerAdapter.CardListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_provider,parent,false);
        CardListHolder cardListHolder=new CardListHolder(view);
        return cardListHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerInnerAdapter.CardListHolder holder, int position) {
        holder.mNameView.setText(arraylList.get(position).getName());
        holder.mDescriptionView.setText(arraylList.get(position).getDescription());
    }
    @Override
    public int getItemCount() {
        return arraylList.size() ;
    }
}
