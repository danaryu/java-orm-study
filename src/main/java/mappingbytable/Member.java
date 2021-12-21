package mappingbytable;


import javax.persistence.*;

//@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

  /*
    @Column(name = "TEAM_ID")
    private Long teamId;
  */

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void changeTeam(Team team) {
        this.team = team;
        // 연관관계 설정 시 나 자신의 인스턴스도 상대 객체에다가 설정
        team.getMembers().add(this);
    }
}
