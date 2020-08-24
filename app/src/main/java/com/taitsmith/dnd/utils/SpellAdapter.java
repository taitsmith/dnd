package com.taitsmith.dnd.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.taitsmith.dnd.R;
import com.taitsmith.dnd.objects.School;
import com.taitsmith.dnd.objects.Spell;

import io.realm.RealmResults;


public class SpellAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private RealmResults<Spell> spells;

    public SpellAdapter(Context context, RealmResults<Spell> spellList) {
        this.spells = spellList;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return spells.size();
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
        Spell spell = spells.get(i);
        School school = spell.getSchool();

        if (view == null) {
            view = inflater.inflate(R.layout.list_item_spell, null);
            viewHolder = new ViewHolder();

            view.setTag(viewHolder);
            viewHolder.spellName = view.findViewById(R.id.spell_list_item_name);
            viewHolder.spellSchool = view.findViewById(R.id.spell_list_item_school);
            viewHolder.spellLevel = view.findViewById(R.id.spell_list_item_level);

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.spellName.setText(spell.getName());
        viewHolder.spellLevel.setText(Integer.toString(spell.getLevel()));
        viewHolder.spellSchool.setText(school.getName());

        return view;
    }

    private class ViewHolder {
        TextView spellName;
        TextView spellLevel;
        TextView spellComponents;
        TextView spellSchool;
    }
}
