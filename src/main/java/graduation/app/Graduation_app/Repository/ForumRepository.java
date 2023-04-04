package graduation.app.Graduation_app.Repository;

import graduation.app.Graduation_app.Domain.Forum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ForumRepository {
    private final EntityManager em;

    //글 게시
    public void save(Forum forum){
        em.persist(forum);
    }

    //찾기
    public Forum findOne(Long id){
        return em.find(Forum.class,id);
    }

    //삭제
    public void delete(Forum forum){
        em.remove(forum);
    }

    //모든 게시글 보여주기
    public List<Forum> findAll(){
        return em.createQuery("select r from Forum r", Forum.class)
                .getResultList();
    }

    // 내가 쓴 게시글 보여주기
    public List<Forum> createdByMe(Long id){
        return em.createQuery("select r from Forum r" +
                        " join fetch r.user m where m.id =: userId", Forum.class)
                .setParameter("userId",id).getResultList();
    }
}
