package graduation.app.Graduation_app.Service;

import graduation.app.Graduation_app.DTO.CreateForumDto;
import graduation.app.Graduation_app.DTO.UpdateForumDto;
import graduation.app.Graduation_app.Domain.Forum;
import graduation.app.Graduation_app.Domain.User;
import graduation.app.Graduation_app.Repository.ForumRepository;
import graduation.app.Graduation_app.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ForumService {
    private final ForumRepository forumRepository;
    private final UserRepository userRepository;

    //게시글 생성
    @Transactional
    public Long createForum(Long userId, CreateForumDto createForumDto){

        User user = userRepository.findOne(userId);

        Forum forum = Forum.createForum(user,createForumDto.getPostT(),
                createForumDto.getTitle(), createForumDto.getContents(),user.getNickname());
        forumRepository.save(forum);
        return forum.getId();
    }

    // 모든 게시글 리스트 조회
    @Transactional
    public List<Forum> allForum(){
        List<Forum> forum = forumRepository.findAll();
        return forum;
    }

    // 업데이트
    @Transactional
    public Long updateForum(Long forumId, UpdateForumDto forumDto){

        Forum forum = forumRepository.findOne(forumId);

        forum.setTitle(forumDto.getTitle());
        forum.setContents(forumDto.getContents());
        forum.setPostT(forumDto.getPostT());

        return forum.getId();
    }

    //게시글 삭제
    @Transactional
    public void deleteForum(Long forumId){
        //게시글 엔티티 조회
        Forum findForum = forumRepository.findOne(forumId);

        //삭제
        forumRepository.delete(findForum);
    }
}
