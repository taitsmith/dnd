package com.taitsmith.dnd.objects;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;

public class School extends RealmObject {
    private String name, url;

    @LinkingObjects("school")
    private final RealmResults<Spell> spells = null;
}
