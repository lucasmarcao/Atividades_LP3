package DAOs;

import Entidades.Aliens;

import java.util.ArrayList;
import java.util.List;

public class DAOAliens extends DAOGenerico<Aliens> {

    private List<Aliens> lista = new ArrayList<>();

    public DAOAliens() {
        super(Aliens.class);
    }
    
    
    
    
    public int autoIdAliens() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.aliensPK) FROM Aliens e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Aliens> listByNome(String tipoAlien) {
        return em.createQuery("SELECT e FROM Aliens e WHERE e.aliensPK) LIKE :tipoAlien").setParameter("tipoAlien", "%" + tipoAlien + "%").getResultList();
    }

    public List<Aliens> listById(int id) {
        return em.createQuery("SELECT e FROM Aliens + e WHERE e.aliensPK= :id").setParameter("id", id).getResultList();
    }

    public List<Aliens> listInOrderNome() {
        return em.createQuery("SELECT e FROM Aliens e ORDER BY e.tipoAlien").getResultList();
    }

    public List<Aliens> listInOrderId() {
        return em.createQuery("SELECT e FROM Aliens e ORDER BY e.aliensPK").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Aliens> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getNomeAlien()+ "-" + lf.get(i).getTipoAlien());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOAliens daoAliens = new DAOAliens();
        List<Aliens> listaAliens = daoAliens.list();
        for (Aliens trabalhador : listaAliens) {
            System.out.println(trabalhador.getNomeAlien()+ "-" + trabalhador.getTipoAlien());
        }
    }
}
