package com.taitsmith.dnd.objects;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Spell extends RealmObject {
    private int _id, level;
    private String index, name, desc, higher_level, page, range, material, duration, casting_time,
            school, url;
    private RealmList<String> components, classes, subclasses;
    private boolean ritual, concentration;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getCasting_time() {
        return casting_time;
    }

    public void setCasting_time(String casting_time) {
        this.casting_time = casting_time;
    }

    public RealmList<String> getComponents() {
        return components;
    }

    public void setComponents(RealmList<String> components) {
        this.components = components;
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

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHigher_level() {
        return higher_level;
    }

    public void setHigher_level(String higher_level) {
        this.higher_level = higher_level;
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
