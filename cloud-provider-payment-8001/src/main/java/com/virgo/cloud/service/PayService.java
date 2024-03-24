package com.virgo.cloud.service;

import com.virgo.cloud.domain.Pay;

import java.util.List;
import java.util.Optional;

public interface PayService {

    int add(Pay pay);

    int deleteById(Long id);

    int update(Pay pay);

    Optional<Pay> findById(Long id);

    List<Pay> findAll();
}
