package com.virgo.cloud.feign;

import com.virgo.cloud.domain.dto.PayDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 与支付微服务的访问地址保存一致
 */
@FeignClient(value = "cloud-payment-service")
@Validated
public interface PayFeignClient {
    @PostMapping("/virgoCloud/provider/pay/")
    ResponseEntity<String> add(@Validated @RequestBody PayDTO payDTO);

    @GetMapping("/virgoCloud/provider/pay/{id}")
    ResponseEntity<String> findById(@PathVariable(name = "id") Long id);

    @GetMapping("/virgoCloud/provider/consul/")
    ResponseEntity<String> feignLoadbalancer();
}
