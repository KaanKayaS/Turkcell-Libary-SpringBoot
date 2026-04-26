package turkcell.libaryspringboot.libary.entity;

import jakarta.persistence.*;
import turkcell.libaryspringboot.libary.enums.FineReason;

import java.math.BigDecimal;

@Entity
@Table(name = "fines")
public class Fine extends BaseEntity {

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "is_paid", nullable = false)
    private boolean isPaid;

    @Enumerated(EnumType.STRING)
    @Column(name = "reason", nullable = false)
    private FineReason reason;

    @ManyToOne
    @JoinColumn(name = "transaction_id", nullable = false)
    private Transaction transaction;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public FineReason getReason() {
        return reason;
    }

    public void setReason(FineReason reason) {
        this.reason = reason;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

}