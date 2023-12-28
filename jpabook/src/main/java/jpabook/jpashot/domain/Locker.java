package jpabook.jpashot.domain;

import javax.persistence.*;

@Entity
public class Locker {

    @Id
    @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    @Column
    private String name;

    @OneToOne(mappedBy = "locker")
    private Member member;

}
