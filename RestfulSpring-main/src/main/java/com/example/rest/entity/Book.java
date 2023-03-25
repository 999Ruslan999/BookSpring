package com.example.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    private BigDecimal price;

    @Column(name="publication_date")
    private LocalDate publicationDate;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonIgnore
    private Author author;
}