package pl.edu.wszib.todolist.springtodolist.configuration;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class DozerConfiguration {

    @Bean
    public Mapper mapper() {
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.setMappingFiles(Collections.singletonList("dozer_mapping.xml"));
        return mapper;
    }

}
