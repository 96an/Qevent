package com.example.qevent.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.qevent.EventDetails;
import com.example.qevent.R;
import com.example.qevent.models.Events;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by am on 1/24/2017.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> implements Filterable {

    public Context mContext;
    public List<Events> original_items = new ArrayList<>();
    public List<Events> filtered_items = new ArrayList<>();
    ItemFilter mFilters = new ItemFilter();

    public EventAdapter(Context mContext, List<Events> eventsList) {
        this.mContext = mContext;
        this.original_items = eventsList;
        this.filtered_items = eventsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_post_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
            final Events events = filtered_items.get(position);
            holder.event_title.setText(events.title);
            holder.event_date.setText(events.date);
            holder.event_month.setText(events.month);
            holder.event_body.setText(events.body);
            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext, EventDetails.class);
                    intent.putExtra("title",events.title);
                    intent.putExtra("date"+"month",events.date + " " + events.month);
                    intent.putExtra("body",events.body);
                    mContext.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return filtered_items.size();
    }

    @Override
    public Filter getFilter() {
        return mFilters;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView event_title,event_date,event_month,event_body;
        public LinearLayout layout;

        public ViewHolder(View itemView) {
            super(itemView);
            event_title = (TextView) itemView.findViewById(R.id.txt_title);
            event_date = (TextView) itemView.findViewById(R.id.txt_date);
            event_month = (TextView) itemView.findViewById(R.id.txt_month);
            event_body = (TextView) itemView.findViewById(R.id.txt_body);
            layout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }


    private class ItemFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            String query = charSequence.toString().toLowerCase();
            FilterResults results = new FilterResults();
            final List<Events> list = original_items;
            final List<Events> result_list = new ArrayList<>(list.size());
            for (int i = 0; i < list.size(); i++){
                String str_title = list.get(i).title;
                if (str_title.toLowerCase().contains(query)){
                    result_list.add(list.get(i));
                }
            }
            results.values = result_list;
            results.count = result_list.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            filtered_items = (List<Events>) filterResults.values;
            notifyDataSetChanged();

        }
    }

}
