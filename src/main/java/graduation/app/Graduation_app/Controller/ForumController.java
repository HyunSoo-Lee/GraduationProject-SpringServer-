package graduation.app.Graduation_app.Controller;

import graduation.app.Graduation_app.DTO.AllForumDto;
import graduation.app.Graduation_app.DTO.CreateForumDto;
import graduation.app.Graduation_app.DTO.UpdateForumDto;
import graduation.app.Graduation_app.Domain.Forum;
import graduation.app.Graduation_app.Service.ForumService;
import graduation.app.Graduation_app.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/forum")
@RequiredArgsConstructor
public class ForumController {
    private final ForumService forumService;

    //게시글 생성하기
    @PostMapping("/create/userId/{userId}")
    public ResponseEntity createForum(@PathVariable Long userId, @RequestBody CreateForumDto createForumDto){

        Long forumId = forumService.createForum(userId,createForumDto);

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,forumId));
    }

    //모든 게시글 보여주기
    @GetMapping("/get/all")
    public ResponseEntity getAllForum(){

        List<Forum> forum = forumService.allForum();

        List<AllForumDto> collect = forum.stream().map(r -> new AllForumDto(r)).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,collect));

    }

    //게시글 업데이트
    @PostMapping("/edit/forumId/{forumId}")
    public ResponseEntity updateForum(@PathVariable Long forumId, @RequestBody UpdateForumDto forumDto) {

        Long forum = forumService.updateForum(forumId, forumDto);

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200, forum));
    }

    //게시글 삭제하기
    @DeleteMapping("/delete/forumId/{forumId}")
    public ResponseEntity deleteForum(@PathVariable Long forumId){

        forumService.deleteForum(forumId);

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200, null));
    }

}
