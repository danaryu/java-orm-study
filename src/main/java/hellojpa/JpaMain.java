package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        // Application 실행 시점에 단 한개만 실행
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // DB 단위 생성
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin(); // Transaction 시작     // JPA에서 데이터를 변경하는 작업은 반드시 Transaction안에서 진행해야함!

/* 실제는 스프링이 이런 코드들을 다 제거하기 때문에 아래와 같은 코드는 사라지게 된다!

        try {
            Member member = new Member();
            member.setId(2L);
            member.setName("helloB");

            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
*/
        try {
            /* 조회
             * entity manager는 java collection처럼 생각하면 된다!
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.getId = " + findMember.getId());
            System.out.println("findMember.getName = " + findMember.getName());
             */

            /* 삭제
             em.remove(findMember);
             */

            /* 수정 */
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");
//            // JPA를 통해 Entity를 가져오면, JPA가 변경여부를 CHECK! Update Query를 짜준다.

/*            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.getName() = " + member.getName());
            }
*/

            // 비영속
            Member member = new Member();
            member.setId(100L);
            member.setName("Hello JPA");

            // 영속 상태! -> Entity Manager를 통해 객체 관리
            System.out.println("=========> BEFORE");
            em.persist(member);
            System.out.println("=========> AFTER");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }

}


