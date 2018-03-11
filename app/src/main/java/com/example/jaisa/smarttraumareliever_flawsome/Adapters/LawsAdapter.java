package com.example.jaisa.smarttraumareliever_flawsome.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.jaisa.smarttraumareliever_flawsome.Beans.Law;
import com.example.jaisa.smarttraumareliever_flawsome.R;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.ArrayList;

/**
 * Created by Varsha on 11-03-2018.
 */

public class LawsAdapter extends RecyclerView.Adapter<LawsAdapter.ViewHolder> {

    private ArrayList<Law> mLawNames;

    public LawsAdapter(ArrayList<Law> mLawNames) {
        this.mLawNames = mLawNames;
    }

    @Override
    public final ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_law, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mLawName.setText("Law name" + position);
        holder.mLawText.setText("Law Desc" + position);

        holder.mLawName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.mLawDesc.toggle();
            }
        });

    }

    @Override
    public int getItemCount() {
        //return mLawNames.size() ;
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ExpandableRelativeLayout mLawDesc;
        public Button mLawName;
        public TextView mLawText;

        public ViewHolder(View itemView) {
            super(itemView);
            mLawDesc = (ExpandableRelativeLayout) itemView.findViewById(R.id.el1);
            mLawDesc.toggle();

            mLawName = (Button) itemView.findViewById(R.id.expandableButton);
            mLawName.setText("Law name");

            mLawText = (TextView) itemView.findViewById(R.id.elt1);
            mLawText.setText("Law Desc");

            mLawName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mLawDesc.toggle();
                }
            });
        }
    }
}
