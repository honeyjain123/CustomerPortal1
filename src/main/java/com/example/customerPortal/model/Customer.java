package com.example.customerPortal.model;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Customer Basic Details Table")
    public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @ApiModelProperty(notes = "ID for unique identification of a Customer")
        private long id;
        @ApiModelProperty(notes = "First Name of Customer")
        private String firstname;
        @ApiModelProperty(notes = "Last Name of Customer")
        private String lastname;
        @ApiModelProperty(notes = "Date Of Birth of Customer")
        private String dob;


        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }

	public Customer() {
		
	}

	public Customer(long id, String firstname, String lastname, String dob) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
	}
    
	
    
    
}

