package com.company.entity;

import com.company.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "payment_detail_id")// this is the default one without annotation
    private PaymentDetail paymentDetail;
    @ManyToOne
    private Merchant merchant;
    public Payment(LocalDate createdDate, BigDecimal amount, Status status) {
        this.createdDate = createdDate;
        this.amount = amount;
        this.status = status;
    }
}
