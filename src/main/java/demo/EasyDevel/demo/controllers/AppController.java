package demo.EasyDevel.demo.controllers;

import demo.EasyDevel.demo.model.Section;
import demo.EasyDevel.demo.services.SectionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "EasyDevel API")
public class AppController {
    @Autowired
    SectionService sectionService;

    @Operation(summary = "Add new section", description = "Adds a new section to the database")
    @PostMapping(path = "api/v1/section")
    public Section addSection(@RequestBody Section section) {
        return sectionService.addSection(section);
    }

    @Operation(summary = "Get all sections", description = "Gets all the sections from the database")
    @GetMapping(path = "api/v1/section")
    public List<Section> getAllSections() {
        return sectionService.getAllSections();
    }

    @Operation(summary = "Get section", description = "Gets an specific section from the database")
    @GetMapping(path = "api/v1/section/{id}")
    public Section getSection(@PathVariable Integer id) {
        return sectionService.getSection(id);
    }

    @Operation(summary = "Modify section", description = "Modifies info about an specific section")
    @PostMapping(path = "api/v1/section/{id}")
    public Section modifySection(@PathVariable Integer id, @RequestBody Section section) {
        section.setId(id);
        return sectionService.modifySection(section);
    }

    @Operation(summary = "Delete section", description = "Deletes a section from the database")
    @DeleteMapping(path = "api/v1/section/{id}")
    public String deleteSection(@PathVariable Integer id) {
        sectionService.deleteSection(id);
        return "OK";
    }

}
