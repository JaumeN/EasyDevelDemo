package demo.EasyDevel.demo.services;

import demo.EasyDevel.demo.exceptions.ResourceNotFoundException;
import demo.EasyDevel.demo.model.Section;
import demo.EasyDevel.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {
    @Autowired
    DemoRepository demoRepository;

    public Section addSection(Section section) {
        return demoRepository.save(section);
    }
    public List<Section> getAllSections() {
        return demoRepository.findAll();
    }
    @Cacheable("getSection")
    public Section getSection(Long id) {
        return demoRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException());
    }
}
