package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "USER")
public class Member {

    //@Column(name = "USERNAME")
    //@Column(unique = true, length = 10)
    //private String name;

    @Id
    private Long id;

    @Column(name = "name", nullable = false) // DB Column명은 name
            //, columnDefinition = "varchar(100) default 'EMPTY'")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    @Transient
    private int temp;

    // JPA는 동적으로 객체를 생성하기 때문에, 기본 생성자가 반드시 필요.
    public Member() {
    }

    /*
    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    */

  /*  public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/
}
