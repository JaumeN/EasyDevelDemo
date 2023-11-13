package demo.EasyDevel.demo.repository;

import demo.EasyDevel.demo.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoRepository extends JpaRepository<Section, Integer> {

}
