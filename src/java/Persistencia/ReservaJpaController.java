package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.Huesped;
import Logica.Empleado;
import Logica.Habitacion;
import Logica.Reserva;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReservaJpaController implements Serializable {

    public ReservaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

   
    public ReservaJpaController() {
        emf = Persistence.createEntityManagerFactory("TPFinalTomasPadillaPU");
    }
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reserva reserva) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Huesped resHuesped = reserva.getResHuesped();
            if (resHuesped != null) {
                resHuesped = em.getReference(resHuesped.getClass(), resHuesped.getId_huesped());
                reserva.setResHuesped(resHuesped);
            }
            Empleado resEmpleado = reserva.getResEmpleado();
            if (resEmpleado != null) {
                resEmpleado = em.getReference(resEmpleado.getClass(), resEmpleado.getId_empleado());
                reserva.setResEmpleado(resEmpleado);
            }
            Habitacion resHabitacion = reserva.getResHabitacion();
            if (resHabitacion != null) {
                resHabitacion = em.getReference(resHabitacion.getClass(), resHabitacion.getId_habitacion());
                reserva.setResHabitacion(resHabitacion);
            }
            em.persist(reserva);
            if (resHuesped != null) {
                resHuesped.getHuesReserva().add(reserva);
                resHuesped = em.merge(resHuesped);
            }
            if (resEmpleado != null) {
                resEmpleado.getEmpReservas().add(reserva);
                resEmpleado = em.merge(resEmpleado);
            }
            if (resHabitacion != null) {
                resHabitacion.getHabReservas().add(reserva);
                resHabitacion = em.merge(resHabitacion);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reserva reserva) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reserva persistentReserva = em.find(Reserva.class, reserva.getId_reserva());
            Huesped resHuespedOld = persistentReserva.getResHuesped();
            Huesped resHuespedNew = reserva.getResHuesped();
            Empleado resEmpleadoOld = persistentReserva.getResEmpleado();
            Empleado resEmpleadoNew = reserva.getResEmpleado();
            Habitacion resHabitacionOld = persistentReserva.getResHabitacion();
            Habitacion resHabitacionNew = reserva.getResHabitacion();
            if (resHuespedNew != null) {
                resHuespedNew = em.getReference(resHuespedNew.getClass(), resHuespedNew.getId_huesped());
                reserva.setResHuesped(resHuespedNew);
            }
            if (resEmpleadoNew != null) {
                resEmpleadoNew = em.getReference(resEmpleadoNew.getClass(), resEmpleadoNew.getId_empleado());
                reserva.setResEmpleado(resEmpleadoNew);
            }
            if (resHabitacionNew != null) {
                resHabitacionNew = em.getReference(resHabitacionNew.getClass(), resHabitacionNew.getId_habitacion());
                reserva.setResHabitacion(resHabitacionNew);
            }
            reserva = em.merge(reserva);
            if (resHuespedOld != null && !resHuespedOld.equals(resHuespedNew)) {
                resHuespedOld.getHuesReserva().remove(reserva);
                resHuespedOld = em.merge(resHuespedOld);
            }
            if (resHuespedNew != null && !resHuespedNew.equals(resHuespedOld)) {
                resHuespedNew.getHuesReserva().add(reserva);
                resHuespedNew = em.merge(resHuespedNew);
            }
            if (resEmpleadoOld != null && !resEmpleadoOld.equals(resEmpleadoNew)) {
                resEmpleadoOld.getEmpReservas().remove(reserva);
                resEmpleadoOld = em.merge(resEmpleadoOld);
            }
            if (resEmpleadoNew != null && !resEmpleadoNew.equals(resEmpleadoOld)) {
                resEmpleadoNew.getEmpReservas().add(reserva);
                resEmpleadoNew = em.merge(resEmpleadoNew);
            }
            if (resHabitacionOld != null && !resHabitacionOld.equals(resHabitacionNew)) {
                resHabitacionOld.getHabReservas().remove(reserva);
                resHabitacionOld = em.merge(resHabitacionOld);
            }
            if (resHabitacionNew != null && !resHabitacionNew.equals(resHabitacionOld)) {
                resHabitacionNew.getHabReservas().add(reserva);
                resHabitacionNew = em.merge(resHabitacionNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = reserva.getId_reserva();
                if (findReserva(id) == null) {
                    throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.");
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
            Reserva reserva;
            try {
                reserva = em.getReference(Reserva.class, id);
                reserva.getId_reserva();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.", enfe);
            }
            Huesped resHuesped = reserva.getResHuesped();
            if (resHuesped != null) {
                resHuesped.getHuesReserva().remove(reserva);
                resHuesped = em.merge(resHuesped);
            }
            Empleado resEmpleado = reserva.getResEmpleado();
            if (resEmpleado != null) {
                resEmpleado.getEmpReservas().remove(reserva);
                resEmpleado = em.merge(resEmpleado);
            }
            Habitacion resHabitacion = reserva.getResHabitacion();
            if (resHabitacion != null) {
                resHabitacion.getHabReservas().remove(reserva);
                resHabitacion = em.merge(resHabitacion);
            }
            em.remove(reserva);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reserva> findReservaEntities() {
        return findReservaEntities(true, -1, -1);
    }

    public List<Reserva> findReservaEntities(int maxResults, int firstResult) {
        return findReservaEntities(false, maxResults, firstResult);
    }

    private List<Reserva> findReservaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reserva.class));
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

    public Reserva findReserva(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reserva.class, id);
        } finally {
            em.close();
        }
    }

    public int getReservaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reserva> rt = cq.from(Reserva.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
