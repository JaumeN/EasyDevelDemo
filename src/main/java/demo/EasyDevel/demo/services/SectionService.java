package demo.EasyDevel.demo.services;

import demo.EasyDevel.demo.exceptions.ResourceNotFoundException;
import demo.EasyDevel.demo.model.Section;
import demo.EasyDevel.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {
    @Autowired
    DemoRepository demoRepository;

    public Section addSection(Section section) {
        return demoRepository.save(section);
    }

    @Cacheable("section-all")
    public List<Section> getAllSections() {
        return demoRepository.findAll();
    }
    @Cacheable("section")
    public Section getSection(Integer id) {
        return demoRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException());
    }

    @Caching(evict = {
            @CacheEvict(value = "section", key = "#section.id"),
            @CacheEvict(value = "section-all", allEntries = true)
    })
    public Section modifySection(Section section) {
        return demoRepository.save(section);
    }

    @Caching(evict = {
            @CacheEvict(value = "section", key = "#id"),
            @CacheEvict(value = "section-all", allEntries = true)
    })
    public void deleteSection(Integer id) {
        demoRepository.deleteById(id);
    }
}
