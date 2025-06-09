package com.test.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@ToString(exclude = "company")
@Table(name = "h_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @AttributeOverride(name = "birthDate", column = @Column(name = "birth_date"))
    private PersonalInfo personalInfo;

    @Column(unique = true, nullable = false)
    private String username;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "info", columnDefinition = "jsonb")
    private String info;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.PERSIST}) // Uni-directional mapping
    @JoinColumn(name = "company_id")
    private Company company;
}
