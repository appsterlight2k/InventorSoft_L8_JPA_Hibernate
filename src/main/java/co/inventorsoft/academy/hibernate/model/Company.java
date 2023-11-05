package co.inventorsoft.academy.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
//@RequiredArgsConstructor
@Getter @Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "companies")
public class Company {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
//    @NonNull
    @Column(nullable = false)
    private Long id;
    @Column(name = "company_name")
    private String companyName;
    private String phone;
    private String address;
    private String city;
    private String region;
    private String zip;
    private String country;

    public Company(String companyName, String phone, String address, String city, String region, String zip, String country) {
        this.companyName = companyName;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.region = region;
        this.zip = zip;
        this.country = country;
    }
}
