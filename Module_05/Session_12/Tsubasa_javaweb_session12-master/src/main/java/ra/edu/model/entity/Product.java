package ra.edu.model.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id") //Ten cot trong bang
    private int productId; //Quy tac dat ten thuoc tinh cua lop (cammelCase)
    @Column(name = "product_name",length = 100, nullable = false)
    private String productName;
    @Column(name = "producer",length = 100, nullable = false)
    private String producer;
    @Column(name = "year_making")
    private Integer yearMaking;
    @Column(name = "expire_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expireDate;
    @Column(name = "price")
    private Double price;

    public Product() {
    }

    public Product(int productId, String productName, String producer, Integer yearMaking, Date expireDate, Double price) {
        this.productId = productId;
        this.productName = productName;
        this.producer = producer;
        this.yearMaking = yearMaking;
        this.expireDate = expireDate;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getYearMaking() {
        return yearMaking;
    }

    public void setYearMaking(Integer yearMaking) {
        this.yearMaking = yearMaking;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
