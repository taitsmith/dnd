package com.taitsmith.dnd.objects;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;

public class School extends RealmObject {
    private String name, url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public RealmResults<Spell> getSpells() {
        return spells;
    }

    @LinkingObjects("school")
    private final RealmResults<Spell> spells = null;
}
