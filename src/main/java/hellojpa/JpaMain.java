package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
/*

            // 비영속
            Member member = new Member();
            member.setId(101L);
            member.setName("Hello JPA");

            // 영속 상태! -> Entity Manager를 통해 객체 관리
            System.out.println("=========> BEFORE");
            em.persist(member);
            System.out.println("=========> AFTER");

            Member findMember = em.find(Member.class, 101L);

            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());

            // 여기서 객체 조회가 일어났는데, DB에 SELECT 쿼리가 나가지 않음! -> 1차 캐시 조회
*/
            /* 지연 로딩
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);
            em.persist(member2); // Entity, Query를 영속성 컨텍스트에 차곡차곡 쌓아둔다.
            System.out.println("=============");
            */

/*
            Member member = em.find(Member.class, 150L);
            member.setName("DANADOT");
            // persist를 별도 호출해주지 않아도 됨! -> 변경감지!!
*/
/*
            Member member = new Member(201L, "MEEPONG");
            em.persist(member);

            em.flush(); // 강제 호출 -> DB에 있는 SQL을 보고싶어~
*/

/*            // 영속
            Member member = em.find(Member.class, 150L);
            member.setName("HEEEEELLO"); // Dirth Checking

*//*
            em.detach(member); // 영속성 컨텍스트에서 떼어냄, JPA에서 관리하지 않음
            // commit을 해도 Table의 데이터 변경이 되지 않음.
*//*

            em.clear();

            Member member2 = em.find(Member.class, 150L);

            System.out.println("===================");*/


            Member member = new Member();
            // member.setId("ID_A");
            member.setUsername("C");

            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }

}


