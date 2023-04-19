package com.company.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class PaymentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal merchantPayoutAmount;
    private BigDecimal CommissionAmount;
    @Column(name = "DATE")
    private LocalDate payoutDate;
    @OneToOne(mappedBy = "paymentDetail")
    private Payment payment;
    public PaymentDetail(BigDecimal merchantPayoutAmount, BigDecimal commissionAmount, LocalDate payoutDate) {
        this.merchantPayoutAmount = merchantPayoutAmount;
        CommissionAmount = commissionAmount;
        this.payoutDate = payoutDate;
    }
}
