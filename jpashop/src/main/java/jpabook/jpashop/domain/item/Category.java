package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "category_item", // 다대다 관계를 일대다, 다대일 관계로 풀어낸다
            joinColumns = @JoinColumn(name = "category_id"), // 다대일 관계의 주인
            inverseJoinColumns = @JoinColumn(name = "item_id")) // 다대일 관계의 주인이 아닌 쪽
    private List<Item> items = new ArrayList<Item>();

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    // 연관관계 편의 메서드
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }

}
