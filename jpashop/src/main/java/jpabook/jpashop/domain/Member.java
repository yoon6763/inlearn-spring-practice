package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;

    @Embedded
    private Address address;

    // 매핑이 된 것. 거울. 읽기 전용이라 볼 수 있음
    // 값을 변경한다 해서 적용이 되진 않음
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}