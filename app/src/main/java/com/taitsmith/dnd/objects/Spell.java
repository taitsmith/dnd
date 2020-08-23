package com.taitsmith.dnd.objects;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Spell extends RealmObject {
    private int level;
    private String _id, index, name, page, range, material, duration, casting_time, url;
    private RealmList<String>  classes, subclasses, desc, higher_level, components, damage_type,
            damage_at_slot_level;
    private boolean ritual, concentration;
    private Damage damage;
    private School school;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCasting_time() {
        return casting_time;
    }

    public void setCasting_time(String casting_time) {
        this.casting_time = casting_time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public RealmList<String> getClasses() {
        return classes;
    }

    public void setClasses(RealmList<String> classes) {
        this.classes = classes;
    }

    public RealmList<String> getSubclasses() {
        return subclasses;
    }

    public void setSubclasses(RealmList<String> subclasses) {
        this.subclasses = subclasses;
    }

    public RealmList<String> getDesc() {
        return desc;
    }

    public void setDesc(RealmList<String> desc) {
        this.desc = desc;
    }

    public RealmList<String> getHigher_level() {
        return higher_level;
    }

    public void setHigher_level(RealmList<String> higher_level) {
        this.higher_level = higher_level;
    }

    public RealmList<String> getComponents() {
        return components;
    }

    public void setComponents(RealmList<String> components) {
        this.components = components;
    }

    public RealmList<String> getDamage_type() {
        return damage_type;
    }

    public void setDamage_type(RealmList<String> damage_type) {
        this.damage_type = damage_type;
    }

    public Damage getDamage() {
        return damage;
    }

    public void setDamage(Damage damage) {
        this.damage = damage;
    }

    public RealmList<String> getDamage_at_slot_level() {
        return damage_at_slot_level;
    }

    public void setDamage_at_slot_level(RealmList<String> damage_at_slot_level) {
        this.damage_at_slot_level = damage_at_slot_level;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public boolean isRitual() {
        return ritual;
    }

    public void setRitual(boolean ritual) {
        this.ritual = ritual;
    }

    public boolean isConcentration() {
        return concentration;
    }

    public void setConcentration(boolean concentration) {
        this.concentration = concentration;
    }
}
