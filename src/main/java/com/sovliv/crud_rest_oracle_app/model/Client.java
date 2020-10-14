package com.sovliv.crud_rest_oracle_app.model;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @Embedded
    private Address address;

    @OneToMany( fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id",  referencedColumnName = "id")
    //@NotFound(action = NotFoundAction.IGNORE)
    private List<Order> orders;

}
