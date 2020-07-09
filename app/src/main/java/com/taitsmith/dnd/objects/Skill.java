package com.taitsmith.dnd.objects;

import io.realm.RealmObject;

public class Skill extends RealmObject {
    private String name, stat;
    private boolean isProficient;
}
