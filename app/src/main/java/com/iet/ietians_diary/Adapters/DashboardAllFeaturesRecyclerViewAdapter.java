package com.iet.ietians_diary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.iet.ietians_diary.Models.DashboardAllFeaturesModel;
import com.iet.ietians_diary.R;

import java.util.ArrayList;

public class DashboardAllFeaturesRecyclerViewAdapter extends RecyclerView.Adapter<DashboardAllFeaturesRecyclerViewAdapter.viewHolder>  {

    ArrayList<DashboardAllFeaturesModel> list;
    Context context;
    private ClickListener mClickListener;
    public DashboardAllFeaturesRecyclerViewAdapter(ArrayList<DashboardAllFeaturesModel> list, Context context, ClickListener mClickListener) {
        this.list = list;
        this.context = context;
        this.mClickListener = mClickListener;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.component_allfeature_card, parent,false);
        return new viewHolder(view, mClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        DashboardAllFeaturesModel model = list.get(position);

        holder.title.setText(model.getTitle());
        holder.description.setText(model.getDescription());
        holder.linearLayout.setBackgroundResource(model.getBgColor());
        holder.icon.setImageResource(model.getIcon());

    }

    @Override
    public int getItemCount() { return list.size(); }


    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title, description;
        LinearLayout linearLayout;
        ImageView icon;
        //ConstraintLayout constraintLayout;

        ClickListener clickListenerObject;
        public viewHolder(@NonNull View itemView , ClickListener clickListenerObject) {
            super(itemView);

            title = itemView.findViewById(R.id.tvFeatureTitle);
            description = itemView.findViewById(R.id.tvFeatureDesc);
            linearLayout = itemView.findViewById(R.id.llFeatureImageBG);
            icon = itemView.findViewById(R.id.ivFeatureImage);
            this.clickListenerObject = clickListenerObject;
            //constraintLayout = itemView.findViewById(R.id.allfeaturecontraintlayout);

            itemView.setOnClickListener(this);

        }
        @Override
        public void onClick(View view) {
            clickListenerObject.clickListener(list.get(getAdapterPosition()));
        }

    }

        public  interface ClickListener{
            void clickListener(DashboardAllFeaturesModel featureModel);
        }

    }




