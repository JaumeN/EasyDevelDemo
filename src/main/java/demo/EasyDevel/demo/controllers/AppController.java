package demo.EasyDevel.demo.controllers;

import demo.EasyDevel.demo.exceptions.ResourceNotFoundException;
import demo.EasyDevel.demo.model.Section;
import demo.EasyDevel.demo.repository.DemoRepository;
import demo.EasyDevel.demo.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController {
    @Autowired
    SectionService sectionService;

    @PostMapping(path = "api/v1/addSection")
    public Section addSection(@RequestBody Section section) {
        return sectionService.addSection(section);
    }

    @GetMapping(path = "api/v1/getAllSections")
    public List<Section> getAllSections() {
        return sectionService.getAllSections();
    }

    @GetMapping(path = "api/v1/getSection")
    public Section getSection(@RequestParam Long id) {
        return sectionService.getSection(id);
    }

}
