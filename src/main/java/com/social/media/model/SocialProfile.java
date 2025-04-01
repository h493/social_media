package com.social.media.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@OneToOne(mappedBy = "socialProfile") //socialProfile -> FieldName in SocialUser
    @OneToOne
    @JoinColumn(name = "social_user") //Defining the name of the foreign key column
    private SocialUser socialUser;
}
