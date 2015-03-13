package acc;

import entities.Applicationuser;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class ApplicationuserFacade {

    @PersistenceContext(unitName = "TestDB_PU")
    private EntityManager em;

    public void create(Applicationuser entity) {
        em.persist(entity);
    }

    public void edit(Applicationuser entity) {
        em.merge(entity);
    }

    public void remove(Applicationuser entity) {
        em.remove(em.merge(entity));
    }

    public Applicationuser find(Object id) {
        return em.find(Applicationuser.class, id);
    }

    public List<Applicationuser> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Applicationuser.class));
        return em.createQuery(cq).getResultList();
    }

    public List<Applicationuser> findRange(int[] range) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Applicationuser.class));
        Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Applicationuser> rt = cq.from(Applicationuser.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
