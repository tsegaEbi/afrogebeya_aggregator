package com.afrogebeya.aggregator.commons.services.apis.ids.models;

import com.afrogebeya.posts.commons.enums.Status;
import lombok.Data;

@Data
public class IdsValidateResponseViewModel {
    String username;
    String name;
    String followName;
    String userGroup;
    Long parentId;

    Long userId;
    Status status;
    String roles;
}
