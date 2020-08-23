package com.taitsmith.dnd.objects;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;

public class Damage extends RealmObject {
    private String damage_type, damage_at_slot_level;

    @LinkingObjects("damage")
    private final RealmResults<Spell> spells = null;
}