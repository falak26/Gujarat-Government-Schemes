package in.ac.charusat.cspit.it.schemes;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<scheme> mData;
    Dialog myDialog;
    Intent i;

    public RecyclerViewAdapter(Context mContext, List<scheme> mData) {
        this.mContext = mContext;
        this.mData = mData;

    }
    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_scheme,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, final int position) {
        holder.scheme.setText(mData.get(position).getScheme());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mContext, "You clicked: "+mData.get(position).getScheme(), Toast.LENGTH_SHORT).show();
                String select = mData.get(position).getScheme();
                switch (select){
                    case "Concession in Food Bill to students studying in Medical and Engineering":
                        i = new Intent(mContext,Edu_sc1.class).putExtra("scheme","01").putExtra("Dept","01");
                        mContext.startActivity(i);break;
                    case "Financial Assistance to Purchase Medical and Engineering Instruments":
                        i = new Intent(mContext,Edu_sc1.class).putExtra("scheme","02").putExtra("Dept","01");
                        mContext.startActivity(i);break;
                    case "Post SSC Scholarship for boys":
                        i = new Intent(mContext,Edu_sc1.class).putExtra("scheme","03").putExtra("Dept","01");
                        mContext.startActivity(i);break;
                    case "Post SSC Scholarship to Girls":
                        i = new Intent(mContext,Edu_sc1.class).putExtra("scheme","04").putExtra("Dept","01");
                        mContext.startActivity(i);break;
                    case "Pre S.S.C Scholarship (Nomadic and Denotified Tribes)":
                        i = new Intent(mContext,Edu_sc1.class).putExtra("scheme","05").putExtra("Dept","01");
                        mContext.startActivity(i);break;
                    case "Pre S.S.C Scholarship (S.E.B.C, E.B.C and Minority)":
                        i = new Intent(mContext,Edu_sc1.class).putExtra("scheme","06").putExtra("Dept","01");
                        mContext.startActivity(i);break;
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout item_scheme;
        private TextView scheme;
        public MyViewHolder(View itemView){
            super(itemView);
            item_scheme = (LinearLayout) itemView.findViewById(R.id.scheme_item_id);
            scheme = (TextView) itemView.findViewById(R.id.scheme);
        }
    }
}
