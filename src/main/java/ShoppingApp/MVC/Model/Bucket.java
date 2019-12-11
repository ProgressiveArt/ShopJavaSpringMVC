package ShoppingApp.MVC.Model;

import javax.persistence.*;

@Entity
@Table(name = "bucket")
public class Bucket {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_description")
    private String description;

    @Column(name = "product_cost")
    private double cost;

    @Column(name = "product_status")
    private String status;

    public Bucket(String name, String description, double cost, String status) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.status = status;
    }

    public Bucket() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
