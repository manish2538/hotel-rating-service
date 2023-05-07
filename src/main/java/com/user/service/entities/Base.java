package com.user.service.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public class Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String externalId;

    private Timestamp createdAt;

    private Timestamp updatedAt;


    @PrePersist
    public void prePersist() {
        final Timestamp now = new Timestamp(System.currentTimeMillis());
        setCreatedAt(now);
        setUpdatedAt(now);
        if (Strings.isBlank(this.externalId)) {
            setExternalId(UUID.randomUUID().toString());
        }
    }

    @PreUpdate
    public void preUpdate() {
        setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        if (Strings.isBlank(this.externalId)) {
            setExternalId(UUID.randomUUID().toString());
        }
    }


}
