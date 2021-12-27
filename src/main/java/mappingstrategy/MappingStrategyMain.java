package mappingstrategy;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MappingStrategyMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Movie movie = new Movie();
            movie.setDirector("danadot");
            movie.setActor("meepong");
            movie.setName("단나와 미퐁의 모험");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush(); // 1차캐쉬에 아무것도 남지 않도록
            em.clear();

            Item findItem = em.find(Item.class, movie.getId());
            System.out.println("findMovie = " + findItem);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }

}
