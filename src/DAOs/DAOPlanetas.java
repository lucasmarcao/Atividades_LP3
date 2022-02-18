package DAOs;

import Entidades.Planetas;
import java.util.ArrayList;
import java.util.List;

public class DAOPlanetas extends DAOGenerico<Planetas> {

    private List<Planetas> lista = new ArrayList<>();

    public DAOPlanetas() {
        super(Planetas.class);
    }

    public int autoIdPlanetas() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.siglaPlaneta) FROM Planetas e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Planetas> listByNome(String nomePlaneta) {
        return em.createQuery("SELECT e FROM Planetas e WHERE e.siglaPlaneta) LIKE :nomePlaneta").setParameter("nomePlaneta", "%" + nomePlaneta + "%").getResultList();
    }

    public List<Planetas> listById(int id) {
        return em.createQuery("SELECT e FROM Planetas + e WHERE e.siglaPlaneta= :id").setParameter("id", id).getResultList();
    }

    public List<Planetas> listInOrderNome() {
        return em.createQuery("SELECT e FROM Planetas e ORDER BY e.nomePlaneta").getResultList();
    }

    public List<Planetas> listInOrderId() {
        return em.createQuery("SELECT e FROM Planetas e ORDER BY e.siglaPlaneta").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Planetas> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getSiglaPlaneta()+ "-" + lf.get(i).getNomePlaneta());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOPlanetas daoPlanetas = new DAOPlanetas();
        List<Planetas> listaPlanetas = daoPlanetas.list();
        for (Planetas trabalhador : listaPlanetas) {
            System.out.println(trabalhador.getSiglaPlaneta()+ "-" + trabalhador.getNomePlaneta());
        }
    }
}
