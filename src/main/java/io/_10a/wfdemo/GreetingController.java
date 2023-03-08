package io._10a.wfdemo;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.transaction.Transactional;

import java.util.List;

@Stateless
public class GreetingController {

    @PersistenceContext
    EntityManager entityManager;

    public List<Greeting> getAllGreetings() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Greeting> query = criteriaBuilder.createQuery(Greeting.class);

        query.from(Greeting.class);

        List<Greeting> resultList = entityManager.createQuery(query).getResultList();

        resultList.forEach(g -> g.setGreeting(g.getGreeting().toUpperCase()));

        return resultList;

    }

    public void saveGreeting(Greeting greeting) {
        entityManager.merge(greeting);
    }

}
