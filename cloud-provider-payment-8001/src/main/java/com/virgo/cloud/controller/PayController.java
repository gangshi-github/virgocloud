package com.virgo.cloud.controller;

import com.virgo.cloud.domain.Pay;
import com.virgo.cloud.domain.dto.PayDTO;
import com.virgo.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/provider/pay")
@Validated
@Tag(name = "支付微服务模块", description = "CRUD")
public class PayController {

    private static final Log log = LogFactory.getLog(PayController.class);
    @Resource
    PayService payService;

    @PostMapping("/")
    @Operation(summary = "新增方法", description = "参数DTO：JSON对象")
    public ResponseEntity<String> add(@Validated @RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanCopier beanCopier = BeanCopier.create(PayDTO.class, Pay.class, false);
        beanCopier.copy(payDTO, pay, null);
        int entry = payService.add(pay);
        return new ResponseEntity<>("新增支付数据:" + entry + "条记录", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除方法", description = "参数：主键ID")
    public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id) {
        int entry = payService.deleteById(id);
        return new ResponseEntity<>("删除支付数据:" + entry + "条记录", HttpStatus.OK);
    }

    @PutMapping("/")
    @Operation(summary = "更新方法", description = "参数DTO：JSON对象")
    public ResponseEntity<String> update(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanCopier beanCopier = BeanCopier.create(PayDTO.class, Pay.class, false);
        beanCopier.copy(payDTO, pay, null);
        int entry = payService.update(pay);
        return new ResponseEntity<>("修改支付数据:" + entry + "条记录", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "查询数据方法", description = "参数：主键ID")
    public ResponseEntity<String> findById(@PathVariable(name = "id") Long id) throws InterruptedException {
        log.info("查询支付微服务数据请求开始访问：" + LocalDateTime.now());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            log.info("查询支付微服务数据请求结束访问：" + LocalDateTime.now());
            throw new InterruptedException();
        }
        PayDTO payDTO = new PayDTO();
        Optional<Pay> optional = payService.findById(id);
        Pay pay = null;
        if (optional.isPresent()) {
            pay = optional.get();
        }
        if (!Objects.isNull(pay)) {

            BeanUtils.copyProperties(pay, payDTO);
        }

        return new ResponseEntity<>("查询支付数据:" + payDTO, HttpStatus.OK);
    }


}
