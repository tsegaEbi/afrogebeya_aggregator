package com.afrogebeya.aggregator.commons.models.views.pagination;

import com.afrogebeya.profile.commons.models.views.pagination.PageableViewModel;
import lombok.Data;

import java.util.List;

@Data
public class PageViewModel<T> {
    PageableViewModel pageable;
    List<T> contents;

}
