package com.app.subscription.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import com.app.subscription.dtos.ApplicationType;
import com.app.subscription.dtos.UserType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Subscription {
    @Id
    private String id;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(name = "userType")
    private UserType userType;
    private String company;
    @Enumerated(EnumType.STRING)
    @Column(name = "applicationType")
    private ApplicationType applicationType;
    private LocalDateTime dateTime;
}
