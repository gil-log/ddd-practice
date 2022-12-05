package com.huvenet.practice.ddd.core.domain;

import java.util.Date;
import lombok.Getter;

@Getter
public class DomainModel {

    protected Long id;
    protected Date createdAt;
    protected Date updatedAt;
}
