package com.virgo.cloud.service.impl;

import com.virgo.cloud.domain.Pay;
import com.virgo.cloud.repository.PayRepository;
import com.virgo.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PayServiceImpl implements PayService {
    @Resource
    private PayRepository payRepository;

    @Override
    public int add(Pay pay) {
        return payRepository.save(pay) != null ? 1 : 0;
    }

    @Override
    public int deleteById(Long id) {
        try {
            payRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int update(Pay pay) {
        try {
            payRepository.save(pay);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Optional<Pay> findById(Long id) {
        return payRepository.findById(id);
    }

    @Override
    public List<Pay> findAll() {
        return payRepository.findAll();
    }
}
