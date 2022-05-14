package com.victolee.board.domain.entity;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class TimeEntity {
    @CreatedDate //Entity가 처음 저장될때 생성일을 주입하는 어노테이션
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private  LocalDateTime modifiedDate;
}
