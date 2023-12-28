package hellojpa.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Member extends BaseEntity {

    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    private LocalDate createdDate;
    private LocalDateTime lastModifiedDate;

    @Lob
    private String description;

    @Transient
    private int temp;

    protected Member() {
    }
}
