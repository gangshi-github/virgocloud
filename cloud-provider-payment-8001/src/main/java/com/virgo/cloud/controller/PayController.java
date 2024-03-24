package com.virgo.cloud.controller;

import com.virgo.cloud.domain.Pay;
import com.virgo.cloud.domain.dto.PayDTO;
import com.virgo.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/pay")
@Validated
public class PayController {
    @Resource
    PayService payService;

    @PostMapping("/")
    public ResponseEntity<String> add(@Validated @RequestBody PayDTO payDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            StringBuilder line = new StringBuilder();
            for (ObjectError error : errors) {
                line.append(error.getDefaultMessage());
            }
            return new ResponseEntity<>("新增支付数据异常:" + line, HttpStatus.OK);
        }
        Pay pay = new Pay();
        BeanCopier beanCopier = BeanCopier.create(PayDTO.class, Pay.class, false);
        beanCopier.copy(payDTO, pay, null);
        int entry = payService.add(pay);
        return new ResponseEntity<>("新增支付数据:" + entry + "条记录", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id) {
        int entry = payService.deleteById(id);
        return new ResponseEntity<>("删除支付数据:" + entry + "条记录", HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<String> update(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanCopier beanCopier = BeanCopier.create(PayDTO.class, Pay.class, false);
        beanCopier.copy(payDTO, pay, null);
        int entry = payService.update(pay);
        return new ResponseEntity<>("修改支付数据:" + entry + "条记录", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable(name = "id") Long id) {
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
