package com.social.media.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "socialUser", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private SocialProfile socialProfile;

    @OneToMany(mappedBy = "socialUser", fetch = FetchType.EAGER)
    private List<Post> posts = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_group",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<SocialGroup> socialGroups = new HashSet<>();

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    public void setSocialProfile(SocialProfile socialProfile) {
        if (this.socialProfile != socialProfile) {  // Prevent infinite recursion
            this.socialProfile = socialProfile;
            if (socialProfile != null && socialProfile.getSocialUser() != this) {
                socialProfile.setSocialUser(this);
            }
        }
    }
}
