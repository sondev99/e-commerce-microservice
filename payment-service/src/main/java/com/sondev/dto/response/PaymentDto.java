package com.sondev.dto.response;

import com.sondev.dto.AbstractDto;
import com.sondev.entity.PaymentMethod;
import com.sondev.entity.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto extends AbstractDto<Integer> {

    private String id;
    private String paymentId;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;



}