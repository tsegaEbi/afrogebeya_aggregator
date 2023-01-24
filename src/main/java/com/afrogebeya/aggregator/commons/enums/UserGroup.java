package com.afrogebeya.aggregator.commons.enums;

public enum UserGroup {
    LEGEND(0,"Legend"),
    SUPER_ADMIN(1,"Super Admin"),
    ADMIN(2,"Admin"),
    DELEGATED_ADMIN(3,"Delegated  Admin"),
    OFFICER(4,"Officer"),
    AGENT(5,"Agent"),
    MEMBER(6,"Member"),
    DEFAULT(7,"Default"),
    OTHER(8,"Other");

    int id;
    String name;

    UserGroup(int id, String name){
        this.id=id;
        this.name=name;
    }

}
