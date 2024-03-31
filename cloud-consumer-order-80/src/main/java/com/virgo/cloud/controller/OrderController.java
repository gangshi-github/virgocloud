package com.virgo.cloud.controller;

import com.virgo.cloud.domain.dto.PayDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/consumer")
@Validated
public class OrderController {

    public static final String PROVIDER_PAYMENT_URL = "http://localhost:8001/virgoCloud/provider/pay/";
    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/pay")
    public ResponseEntity<String> postOrder(@Validated @RequestBody PayDTO payDTO) {
        log.info("消费者新增对象：" + payDTO.toString());
        return restTemplate.postForEntity(PROVIDER_PAYMENT_URL, payDTO, String.class);
    }

    @GetMapping("/pay/{id}")
    public ResponseEntity<String> getOrder(@PathVariable(name = "id") Long id) {
        return restTemplate.getForEntity(PROVIDER_PAYMENT_URL + id, String.class);
    }

    @PutMapping("/pay")
    public ResponseEntity<String> putOrder(@Validated @RequestBody PayDTO payDTO) {
        log.info("消费者修改对象：" + payDTO.toString());
        return restTemplate.exchange(PROVIDER_PAYMENT_URL, HttpMethod.PUT, new HttpEntity<>(payDTO), String.class);
    }

    @DeleteMapping("/pay/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable(name = "id") Long id) {
        log.info("消费者删除对象：" + id);
        return restTemplate.exchange(PROVIDER_PAYMENT_URL + id, HttpMethod.DELETE, null, String.class);
    }
}
