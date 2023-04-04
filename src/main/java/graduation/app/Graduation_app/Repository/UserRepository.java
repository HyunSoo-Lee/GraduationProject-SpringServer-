package graduation.app.Graduation_app.Repository;

import graduation.app.Graduation_app.Domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager em;

    //사용자 저장
    public void save(User user){
        em.persist(user);
    }

    //사용자 찾기
    public User findOne(Long id){
        return em.find(User.class,id);
    }
    public Long findId(String nickname, String password) {
        TypedQuery<Long> query = em.createQuery(
                "SELECT u.id FROM User u WHERE u.nickname = :nickname AND u.password = :password", Long.class);
        query.setParameter("nickname", nickname);
        query.setParameter("password", password);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    //사용자 삭제
    public void delete(User user){
        em.remove(user);
    }
}
