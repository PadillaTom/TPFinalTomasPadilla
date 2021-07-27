package Persistencia;

import Logica.Empleado;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.Reserva;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmpleadoJpaController implements Serializable {

    public EmpleadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public EmpleadoJpaController() {
        emf = Persistence.createEntityManagerFactory("TPFinalTomasPadillaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empleado empleado) {
        if (empleado.getEmpReservas() == null) {
            empleado.setEmpReservas(new ArrayList<Reserva>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Reserva> attachedEmpReservas = new ArrayList<Reserva>();
            for (Reserva empReservasReservaToAttach : empleado.getEmpReservas()) {
                empReservasReservaToAttach = em.getReference(empReservasReservaToAttach.getClass(), empReservasReservaToAttach.getId_reserva());
                attachedEmpReservas.add(empReservasReservaToAttach);
            }
            empleado.setEmpReservas(attachedEmpReservas);
            em.persist(empleado);
            for (Reserva empReservasReserva : empleado.getEmpReservas()) {
                Empleado oldResEmpleadoOfEmpReservasReserva = empReservasReserva.getResEmpleado();
                empReservasReserva.setResEmpleado(empleado);
                empReservasReserva = em.merge(empReservasReserva);
                if (oldResEmpleadoOfEmpReservasReserva != null) {
                    oldResEmpleadoOfEmpReservasReserva.getEmpReservas().remove(empReservasReserva);
                    oldResEmpleadoOfEmpReservasReserva = em.merge(oldResEmpleadoOfEmpReservasReserva);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empleado empleado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado persistentEmpleado = em.find(Empleado.class, empleado.getId_empleado());
            List<Reserva> empReservasOld = persistentEmpleado.getEmpReservas();
            List<Reserva> empReservasNew = empleado.getEmpReservas();
            List<Reserva> attachedEmpReservasNew = new ArrayList<Reserva>();
            for (Reserva empReservasNewReservaToAttach : empReservasNew) {
                empReservasNewReservaToAttach = em.getReference(empReservasNewReservaToAttach.getClass(), empReservasNewReservaToAttach.getId_reserva());
                attachedEmpReservasNew.add(empReservasNewReservaToAttach);
            }
            empReservasNew = attachedEmpReservasNew;
            empleado.setEmpReservas(empReservasNew);
            empleado = em.merge(empleado);
            for (Reserva empReservasOldReserva : empReservasOld) {
                if (!empReservasNew.contains(empReservasOldReserva)) {
                    empReservasOldReserva.setResEmpleado(null);
                    empReservasOldReserva = em.merge(empReservasOldReserva);
                }
            }
            for (Reserva empReservasNewReserva : empReservasNew) {
                if (!empReservasOld.contains(empReservasNewReserva)) {
                    Empleado oldResEmpleadoOfEmpReservasNewReserva = empReservasNewReserva.getResEmpleado();
                    empReservasNewReserva.setResEmpleado(empleado);
                    empReservasNewReserva = em.merge(empReservasNewReserva);
                    if (oldResEmpleadoOfEmpReservasNewReserva != null && !oldResEmpleadoOfEmpReservasNewReserva.equals(empleado)) {
                        oldResEmpleadoOfEmpReservasNewReserva.getEmpReservas().remove(empReservasNewReserva);
                        oldResEmpleadoOfEmpReservasNewReserva = em.merge(oldResEmpleadoOfEmpReservasNewReserva);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = empleado.getId_empleado();
                if (findEmpleado(id) == null) {
                    throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado empleado;
            try {
                empleado = em.getReference(Empleado.class, id);
                empleado.getId_empleado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.", enfe);
            }
            List<Reserva> empReservas = empleado.getEmpReservas();
            for (Reserva empReservasReserva : empReservas) {
                empReservasReserva.setResEmpleado(null);
                empReservasReserva = em.merge(empReservasReserva);
            }
            em.remove(empleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empleado> findEmpleadoEntities() {
        return findEmpleadoEntities(true, -1, -1);
    }

    public List<Empleado> findEmpleadoEntities(int maxResults, int firstResult) {
        return findEmpleadoEntities(false, maxResults, firstResult);
    }

    private List<Empleado> findEmpleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleado.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Empleado findEmpleado(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleado> rt = cq.from(Empleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
