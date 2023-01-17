package ru.kirillnsb.otk.model;

import jakarta.persistence.*;



@Entity
@Table(name = "checkups")
public class Checkup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long checkup_id;
    private Long session_id;
    private Integer quantity;
    @Column(name = "invalid_quant")
    private Integer invalid_quantity;
    private String consign_num;
    private String item_type;

    @ManyToOne
    @JoinColumn(name = "employee_ref")
    private User employeeRef;

    public User getEmployeeRef() {
        return employeeRef;
    }

    public void setEmployeeRef(User employeeRef) {
        this.employeeRef = employeeRef;
    }

    public Long getCheckup_id() {
        return checkup_id;
    }

    public void setCheckup_id(Long checkup_id) {
        this.checkup_id = checkup_id;
    }

    public Long getSession_id() {
        return session_id;
    }

    public void setSession_id(Long session_id) {
        this.session_id = session_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getInvalid_quantity() {
        return invalid_quantity;
    }

    public void setInvalid_quantity(Integer invalid_quantity) {
        this.invalid_quantity = invalid_quantity;
    }

    public String getConsign_num() {
        return consign_num;
    }

    public void setConsign_num(String consign_num) {
        this.consign_num = consign_num;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    @Override
    public String toString() {
        return "Checkup{" +
                "checkup_id=" + checkup_id +
                ", session_id=" + session_id +
                ", quantity=" + quantity +
                ", invalid_quantity=" + invalid_quantity +
                ", consign_num='" + consign_num + '\'' +
                ", item_type='" + item_type + '\'' +
                ", employee_ref=" + employeeRef +
                '}';
    }
}
