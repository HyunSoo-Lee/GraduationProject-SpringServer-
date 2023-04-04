package graduation.app.Graduation_app.Service;

import graduation.app.Graduation_app.DTO.AddUserDto;
import graduation.app.Graduation_app.DTO.UpdateUserDto;
import graduation.app.Graduation_app.Domain.Forum;
import graduation.app.Graduation_app.Domain.SleepTime;
import graduation.app.Graduation_app.Domain.User;
import graduation.app.Graduation_app.Repository.ForumRepository;
import graduation.app.Graduation_app.Repository.SleepTimeRepository;
import graduation.app.Graduation_app.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ForumRepository forumRepository;
    private final SleepTimeRepository sleepTimeRepository;

    //사용자 생성
    @Transactional
    public Long createUser(AddUserDto addUserDto){
        User user = User.addUser(addUserDto.getBaby_name(),
                addUserDto.getNickname(),
                addUserDto.getPassword(),
                addUserDto.getBaby_gender(),
                addUserDto.getBaby_birth());
        userRepository.save(user);
        return user.getId();
    }

    // 업데이트
    @Transactional
    public Long updateUser(Long userId, UpdateUserDto userDto){

        User user = userRepository.findOne(userId);

        user.setNickname(userDto.getNickname());
        user.setPassword(userDto.getPassword());
        user.setBabyGender(userDto.getBaby_gender());
        user.setBabyBirth(userDto.getBaby_birth());
        user.setBabyName(userDto.getBaby_name());

        return user.getId();
    }

    public Long getMyUserIdList(String nickname, String password) { return userRepository.findId(nickname, password);}

    //본인 게시글 조회
    public List<Forum> getMyforumList(Long userId){
        return forumRepository.createdByMe(userId);
    }
    
    //본인 아이 수면시간 조회
    public List<SleepTime> getMysleepList(Long userId){
        return sleepTimeRepository.createdByMe(userId);
    }

    //삭제
    @Transactional
    public void deleteUser(Long userId){
        User findUser = userRepository.findOne(userId);
        userRepository.delete(findUser);
    }
}
