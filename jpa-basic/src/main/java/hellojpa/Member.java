package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {

    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

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
