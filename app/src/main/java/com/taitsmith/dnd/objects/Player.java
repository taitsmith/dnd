package com.taitsmith.dnd.objects;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Player extends RealmObject {
    private String name, clazz, background, race, alignment;
    private int str, dex, con, intel, wis, cha, xp, hpCurrent, hpMax,
            hpTemp, gold, hitDice, level, armorClass, initiative, speed, profBonus;
    private RealmList<String> skills, savingThrows, languages, equipment;

    public int getProfBonus() { return profBonus; }

    public void setProfBonus(int profBonus) { this.profBonus = profBonus; }

    public int getArmorClass() { return armorClass; }

    public void setArmorClass(int armorClass) { this.armorClass = armorClass; }

    public int getInitiative() { return initiative; }

    public void setInitiative(int initiative) { this.initiative = initiative; }

    public int getSpeed() { return speed; }

    public void setSpeed(int speed) { this.speed = speed; }

    public int getLevel() { return level; }

    public void setLevel(int level) { this.level = level; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public int getStr() { return str; }

    public void setStr(int str) {
        this.str = str;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getCon() {
        return con;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public int getIntel() {
        return intel;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public int getWis() {
        return wis;
    }

    public void setWis(int wis) {
        this.wis = wis;
    }

    public int getCha() {
        return cha;
    }

    public void setCha(int cha) {
        this.cha = cha;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getHpCurrent() {
        return hpCurrent;
    }

    public void setHpCurrent(int hpCurrent) {
        this.hpCurrent = hpCurrent;
    }

    public int getHpMax() {
        return hpMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public int getHpTemp() {
        return hpTemp;
    }

    public void setHpTemp(int hpTemp) {
        this.hpTemp = hpTemp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getHitDice() {
        return hitDice;
    }

    public void setHitDice(int hitDice) {
        this.hitDice = hitDice;
    }

    public RealmList<String> getSkills() {
        return skills;
    }

    public void setSkills(RealmList<String> skills) {
        this.skills = skills;
    }

    public RealmList<String> getSavingThrows() {
        return savingThrows;
    }

    public void setSavingThrows(RealmList<String> savingThrows) {
        this.savingThrows = savingThrows;
    }

    public RealmList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(RealmList<String> languages) {
        this.languages = languages;
    }

    public RealmList<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(RealmList<String> equipment) {
        this.equipment = equipment;
    }
}
