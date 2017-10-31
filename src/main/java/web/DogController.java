package web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@RestController
@Slf4j
public class DogController {

    //key는 dog의 이름 value는 dog객체
    private Map<String, Dog> dogMap = new HashMap<String, Dog>();

    @RequestMapping(value = "dogs/{name}", method = RequestMethod.GET)
    public Dog selectDogsMyName(@PathVariable String name) {
        log.info("Hey this is dog select controller!!!!{}", name);
        return dogMap.get(name);
    }

    @RequestMapping(value = "dogs", method = RequestMethod.POST)
    public void createDog(@RequestBody Dog dog) {
        dogMap.put(dog.getName(), dog);
    }

    @RequestMapping(value = "dogs/count", method = RequestMethod.GET)
    public int selectTotalDogCount() {
        return dogMap.size();
    }

    //dog type 변경 API
    @RequestMapping(value = "dog/{name}", method = RequestMethod.PUT)
    public Dog updateDogType(@PathVariable String name) throws Exception {
        if (dogMap.containsKey(name)) {
            return dogMap.remove(name);
        }
        //없는 개를 지우면 메시지 남기기
        throw new Exception();
    }
}
