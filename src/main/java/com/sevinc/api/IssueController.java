package com.sevinc.api;


import com.sevinc.dto.IssueDto;
import com.sevinc.service.impl.IssueServiceImpl;
import com.sevinc.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Api(value = ApiPaths.IssueCtrl.CTRL, description = "Issue APIs")
public class IssueController {

    private final IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = IssueDto.class)
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id",required = true) Long id) {
        IssueDto issue = issueServiceImpl.getById(id);
        return ResponseEntity.ok(issue);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation", response = IssueDto.class)
    public ResponseEntity<IssueDto> createProject( @RequestBody IssueDto issue){
        return ResponseEntity.ok(issueServiceImpl.save(issue));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = IssueDto.class)
    public ResponseEntity<IssueDto> updateProject(@PathVariable(value = "id", required = true) Long id, @RequestBody IssueDto issue){
        return ResponseEntity.ok(issueServiceImpl.update(id,issue));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id){
        return  ResponseEntity.ok(issueServiceImpl.delete(id));
    }
}
