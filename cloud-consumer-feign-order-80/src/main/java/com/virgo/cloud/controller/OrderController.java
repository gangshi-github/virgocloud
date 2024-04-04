package com.virgo.cloud.controller;

import com.virgo.cloud.domain.dto.PayDTO;
import com.virgo.cloud.feign.PayFeignClient;
import jakarta.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumer/feign/order")
@Validated
public class OrderController {

    private static final Log log = LogFactory.getLog(OrderController.class);

    @Resource
    private PayFeignClient payFeignClient;

    @PostMapping("/pay")
    public ResponseEntity<String> add(@Validated @RequestBody PayDTO payDTO) {
        log.info("新增订单成功 , 远程调用支付微服务openFeign新增接口");
        return payFeignClient.add(payDTO);
    }

    @GetMapping("/pay/{id}")
    public ResponseEntity<String> getOrder(@PathVariable(name = "id") Long id) {
        return payFeignClient.findById(id);
    }

    @GetMapping("/loadbalancer")
    ResponseEntity<String> feignLoadbalancer() {
        return payFeignClient.feignLoadbalancer();
    }
}
