package jpabook.jpashop;

import hellojpa.Member;
import jpabook.jpashop.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            /*
                주문한 member를 찾고 싶을 때, order에서 memberId get
                    -> Id로 Member table에서 find
                    > 객체지향스럽지 않음 (객체지향 그래프 탐색 불가)
                Order order = em.find(Order.class, 1L);
                Long memberId = order.getMemberId();
                Member member = em.find(Member.class, memberId);

                따라서, order.getMember(); 와 객체지향적으로 쓰는것이 맞음(객체 참조)
                    -> Order는 Member를 가지는 것이 객체지향적이다.
            */

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
