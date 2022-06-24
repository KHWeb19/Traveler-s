package com.example.demo.service.wish;


import com.example.demo.repository.wish.WishRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class WishServiceImpl implements WishService{

    @Autowired
    private WishRepository wishRepository;

    @Override
    public void deleteWish(Long wishNo) {
        wishRepository.deleteById(wishNo);
    }
}
