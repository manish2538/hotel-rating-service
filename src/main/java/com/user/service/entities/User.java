package com.user.service.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends Base {

    private String userId;
    private String emailId;
    private String name;
    private String about;

    @Transient
    private Set<Rating> ratings;

    @Override
    @PrePersist
    public void prePersist() {
        super.prePersist();
        setUserId(getExternalId());
    }

    @Override
    @PreUpdate
    public void preUpdate() {
        super.preUpdate();
        setUserId(getExternalId());
    }


}
