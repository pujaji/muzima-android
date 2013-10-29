package com.muzima.adapters.cohort;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;

import com.muzima.R;
import com.muzima.adapters.ListAdapter;
import com.muzima.api.model.Cohort;
import com.muzima.controller.CohortController;
import com.muzima.utils.Fonts;

public abstract class CohortsAdapter extends ListAdapter<Cohort> {
    protected CohortController cohortController;
    protected BackgroundListQueryTaskListener backgroundListQueryTaskListener;

    public CohortsAdapter(Context context, int textViewResourceId, CohortController cohortController) {
        super(context, textViewResourceId);
        this.cohortController = cohortController;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(
                    R.layout.item_cohorts_list, parent, false);
            holder = new ViewHolder();
            holder.name = (CheckedTextView) convertView
                    .findViewById(R.id.cohort_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Cohort cohort = getItem(position);

        holder.name.setText(cohort.getName());
        holder.name.setTypeface(Fonts.roboto_medium(getContext()));

        return convertView;
    }

    protected static class ViewHolder {
        CheckedTextView name;
    }

    public void setBackgroundListQueryTaskListener(BackgroundListQueryTaskListener backgroundListQueryTaskListener) {
        this.backgroundListQueryTaskListener = backgroundListQueryTaskListener;
    }
}
