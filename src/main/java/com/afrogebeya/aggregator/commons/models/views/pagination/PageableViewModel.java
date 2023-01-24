package com.afrogebeya.aggregator.commons.models.views.pagination;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
public class PageableViewModel  {
    int pageNumber;
    int pageSize;
    int totalSize;
    Long offSet;

    Sort.Direction sort;


    public Pageable toPageable(String[] properties){
        Pageable pageable= PageRequest.of(this.pageNumber,this.pageSize,this.sort,properties);
        return pageable;
    }
}
