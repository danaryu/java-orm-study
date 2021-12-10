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
        tx.begin(); // Transaction 시작

        Member member = new Member();

        member.setId(2L);
        member.setName("helloB");
        // JPA에서 데이터를 변경하는 작업은 반드시 Transaction안에서 진행해야함!

        em.persist(member);

        tx.commit();

        em.close();

        emf.close();

    }

}


