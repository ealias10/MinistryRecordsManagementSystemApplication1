package com.example.Ministry.Records.Management.System.vo;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PaginatedRepositeryVOAndCount<T>{

    private  long totalCount;
    private List<T> data;
}
