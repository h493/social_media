package com.social.media.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private SocialUser socialUser;

    private String description;

    public void setSocialUser(SocialUser socialUser) {
        if (this.socialUser != socialUser) {  // Prevent infinite recursion
            this.socialUser = socialUser;
            if (socialUser != null && socialUser.getSocialProfile() != this) {
                socialUser.setSocialProfile(this);
            }
        }
    }
}
