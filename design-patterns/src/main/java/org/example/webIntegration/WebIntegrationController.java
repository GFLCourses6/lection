package org.example.webIntegration;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping(path = "/api/web/integration")
public class WebIntegrationController {

    // http://localhost:8080/api/web/integration/1/test
    @GetMapping(path = "/{clientID}/{type}") // через PathVariable
    public ResponseEntity<Void> getURLMethod(@PathVariable(value = "clientID") Integer clientID,
                                             @PathVariable(value = "type") String type){
        return ResponseEntity.ok().build();
    }
    // http://localhost:8080/api/web/integration?clientID=1&type=test
    @GetMapping // через RequestParam
    public ResponseEntity<Void> getRequestMethod(@RequestParam(value = "clientID") Integer clientID,
                                                 @RequestParam(value = "type") String type){
        return ResponseEntity.ok().build();
    }
    //  http://localhost:8080/api/web/integration
//    {
//      "password": "Test"
//      "type":"Test".
//       "id": 1,
//       "object": {
//          "type": ""
//       }
//     }
    @PostMapping
    public ResponseEntity<Void> postMethod(@RequestBody @Valid TestObject testObject){
        return ResponseEntity.ok().build();
    }

    //     [{
    //      "password": "Test43583fovj@#",
    //      "type":"Test",
    //       "id": 3,
    //       "object": {
    //          "type": "qwer"
    //       },
    //       "list": [
    //          {"type": "qwer"}
    //       ]
    //     }]
    @PostMapping(path = "/test")
    public ResponseEntity<Void> postSecondMethod(@RequestBody @Valid @NotNull(message = "test object shouldn't be not null") List<TestObject> testObject){
        return ResponseEntity.ok().build();
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteMethod(){
        return ResponseEntity.ok().build();
    }
    //  http://localhost:8080/api/web/integration
    //{
    //  "type":"Test".
    //   "id": 1
    // }
    @PutMapping // передаем полностью весь объект и изменяем
    public ResponseEntity<Void> putMethod(@RequestBody TestObject testObject){
        return ResponseEntity.ok().build();
    }
    @PatchMapping // передаем частично только те поля которые изменяем(есть большой объект, его нужно поменять, то не нужно перекидать весь объект)
    public ResponseEntity<Void> patchMethod(){
        return ResponseEntity.ok().build();
    }

}
