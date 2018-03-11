package com.example.jaisa.smarttraumareliever_flawsome.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.jaisa.smarttraumareliever_flawsome.R;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Varsha on 11-03-2018.
 */

public class LawsAdapter extends RecyclerView.Adapter<LawsAdapter.ViewHolder> {

    private ArrayList<String> mLawNames;
    private ArrayList<String> mLawDescriptions;
    public ExpandableRelativeLayout mLawDesc;
    public Button mLawName;
    public TextView mLawText;

    public LawsAdapter(ArrayList<String> lawNames, ArrayList<String> lawDescriptions) {
        this.mLawNames = lawNames;
        this.mLawDescriptions = lawDescriptions;
    }

    @Override
    public final ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_law, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public int getItemCount() {
        //return mLawNames.size() ;
        return 4;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String lawName = mLawNames.get(position);
        String lawDescription = mLawDescriptions.get(position);
        holder.bindLaw(lawName, lawDescription);
    }

    public void expandableButton(View view) {
        mLawDesc.toggle(); // toggle expand and collapse
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
            mLawName = (Button) itemView.findViewById(R.id.expandableButton);
            mLawDesc = (ExpandableRelativeLayout) itemView.findViewById(R.id.el1);
            mLawText = (TextView) itemView.findViewById(R.id.elt1);

            mLawName.setText("Law name 1");
            mLawDesc.toggle();
            mLawText.setText("Law Desc 1");
        }
        public void bindLaw(String lawName, String lawDescription){
            mLawName.setText(lawName);
            mLawText.setText(lawDescription);
        }
    }

}
