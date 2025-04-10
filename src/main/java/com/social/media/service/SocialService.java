package com.social.media.service;

import com.social.media.model.SocialUser;
import com.social.media.repository.SocialUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SocialService {
    @Autowired
    private SocialUserRepository socialUserRepository;

    public List<SocialUser> getAllUsers(){
        return socialUserRepository.findAll();
    }

    public SocialUser saveUser(SocialUser socialUser) {
        return socialUserRepository.save(socialUser);
    }

    public SocialUser delete(Long id) {
        SocialUser socialUser = socialUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
         socialUserRepository.delete(socialUser);
         return socialUser;
    }
}
