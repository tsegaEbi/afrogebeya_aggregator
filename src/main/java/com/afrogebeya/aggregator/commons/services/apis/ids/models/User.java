package com.afrogebeya.aggregator.commons.services.apis.ids.models;

import com.afrogebeya.posts.commons.enums.Status;
import com.afrogebeya.posts.commons.enums.UserGroup;
import lombok.Data;

@Data
public class User {
    Long userId;
    String username;// email or mobile
    String email;
    String name;
    String followName;
    UserGroup userGroup;
    Long parentId;

    Status status;
    String roles;
}
