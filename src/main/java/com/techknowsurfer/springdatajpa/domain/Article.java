package com.techknowsurfer.springdatajpa.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ARTICLE")
public class Article{

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String articleId;

    @Column
    private String articleTitle;

    @Column
    private String authorFirstName;

    @Column
    private String authorLastName;

    @Column
    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Category category;
}
