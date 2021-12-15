package mappingbytable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class TableMappingMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.changeTeam(team);
            em.persist(member);

//            team.addMember(member);
/*
            em.flush();
            em.clear();
*/
            // Team은 영속성 컨텍스트에 들어가있는 상태 (1차캐시), 순수 객체
            Team findTeam = em.find(Team.class, team.getId());
            // 연관관계 설정이 되지않은 경우이기 때문에 members의 값은 없다
            List<Member> members = findTeam.getMembers();

            System.out.println("===========");

            for (Member m : members) {
                System.out.println("m.getUsername() = " + m.getUsername());
            }

            System.out.println("===========");

            //team.getMembers().add(member); // Team에 member를 집어넣음 (mapped by는 읽기전용)


/*

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            //member.setTeamId(team.getId());
            em.persist(member);
*/


/*
            Member findMember = em.find(Member.class, member.getId());
            List<Member> members = findMember.getTeam().getMembers();

            for (Member m : members) {
                System.out.println("m.getUsername() = " + m.getUsername());
            }
*/

//            System.out.println("findMember = " + findMember.getUsername());
//            Team findTeam = findMember.getTeam();
            //System.out.println("findTeam.getId() = " + findTeam.getId());
//
//            Member findMember = em.find(Member.class, member.getId());
//            Long findTeamId = findMember.getTeamId();
//            Team findTeam = em.find(Team.class, findTeamId);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
