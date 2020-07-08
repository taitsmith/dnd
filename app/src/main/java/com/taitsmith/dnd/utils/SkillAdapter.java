package com.taitsmith.dnd.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Switch;
import android.widget.TextView;

import com.taitsmith.dnd.R;

public class SkillAdapter extends BaseAdapter {
    private String[] skills;
    private LayoutInflater inflater;

    public SkillAdapter(Context context, String[] skills) {
        this.skills = skills;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return skills.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            view = inflater.inflate(R.layout.skill_list_item, null);
            viewHolder = new ViewHolder();

            view.setTag(viewHolder);
            viewHolder.skillName = view.findViewById(R.id.skill_list_skill_name);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.skillName.setText(skills[i]);

        return view;
    }

    private class ViewHolder {
        TextView skillName;


    }
}
