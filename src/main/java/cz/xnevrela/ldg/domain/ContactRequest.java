package cz.xnevrela.ldg.domain;

import cz.xnevrela.ldg.validation.AlphaNumeric;
import cz.xnevrela.ldg.validation.Alphabetic;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Customer request
 */
@Entity
public class ContactRequest implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    // Customer
    @Size(max = 50)
    @Alphabetic
    private String name;
    @Size(max = 50)
    @Alphabetic
    private String surname;
    @NotBlank
    @Size(max = 50)
    @AlphaNumeric
    private String policyNumber;

    // Request
    @NotBlank
    @Size(max = 2000)
    @Column(length = 2000)
    private String request;
    @NotNull
    @ManyToOne
    private ContactRequestType requestType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public ContactRequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(ContactRequestType requestType) {
        this.requestType = requestType;
    }

    // There is no natural id if we allow customer to send multiple identical requests over time
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactRequest that = (ContactRequest) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
