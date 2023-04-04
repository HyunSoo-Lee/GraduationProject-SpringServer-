package graduation.app.Graduation_app.Service;

import graduation.app.Graduation_app.DTO.CreateSleepTimeDto;
import graduation.app.Graduation_app.DTO.UpdateSleepTimeDto;
import graduation.app.Graduation_app.Domain.SleepTime;
import graduation.app.Graduation_app.Domain.User;
import graduation.app.Graduation_app.Repository.SleepTimeRepository;
import graduation.app.Graduation_app.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SleepTimeService {
    private final SleepTimeRepository sleepTimeRepository;
    private final UserRepository userRepository;

    //수면시간 생성
    @Transactional
    public Long createSleepTime(Long userId, CreateSleepTimeDto createSleepTimeDto){

        User user = userRepository.findOne(userId);

        SleepTime sleepTime = SleepTime.createSleepTime(user,user.getBabyName(),
                createSleepTimeDto.getStartT(), createSleepTimeDto.getEndT(), createSleepTimeDto.getTurn_cnt());
        sleepTimeRepository.save(sleepTime);
        return sleepTime.getId();
    }

    //수면시간 업데이트
    @Transactional
    public Long updateSleepTime(Long sleepTimeId, UpdateSleepTimeDto sleepTimeDto){

        SleepTime sleepTime = sleepTimeRepository.findOne(sleepTimeId);

        sleepTime.setStartT(sleepTimeDto.getStartT());
        sleepTime.setEndT(sleepTimeDto.getEndT());
        sleepTime.setTurn_cnt(sleepTimeDto.getTurn_cnt());

        return sleepTime.getId();
    }

    //수면시간 삭제
    @Transactional
    public void deleteSleepTime(Long sleepTimeId){
        //게시글 엔티티 조회
        SleepTime findSleepTime = sleepTimeRepository.findOne(sleepTimeId);

        //삭제
        sleepTimeRepository.delete(findSleepTime);
    }
}
