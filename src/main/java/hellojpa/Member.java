package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Table(name = "USER")
public class Member {

    @Id
    private Long id;
    private String name;

    // JPA는 동적으로 객체를 생성하기 때문에, 기본 생성자가 반드시 필요.
    Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
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
    }
}
