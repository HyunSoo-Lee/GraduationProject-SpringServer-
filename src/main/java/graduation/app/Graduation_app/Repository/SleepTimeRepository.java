package graduation.app.Graduation_app.Repository;

import graduation.app.Graduation_app.Domain.SleepTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SleepTimeRepository {
    private final EntityManager em;

    //시간 게시
    public void save(SleepTime sleepTime) {em.persist(sleepTime);}
    
    //시간 찾기
    public SleepTime findOne(Long id) {return em.find(SleepTime.class,id);}
    
    //삭제
    public void delete(SleepTime sleepTime) {em.remove(sleepTime);}

    //모든 수면시간 보여주기
    public List<SleepTime> findAll(){
        return em.createQuery("select r from SleepTime r", SleepTime.class)
                .getResultList();
    }

    // 특정 회원 시간 보여주기
    public List<SleepTime> createdByMe(Long id){
        return em.createQuery("select r from SleepTime r" +
                        " join fetch r.user m where m.id =: userId", SleepTime.class)
                .setParameter("userId",id).getResultList();
    }
}
