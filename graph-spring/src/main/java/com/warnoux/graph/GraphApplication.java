package com.warnoux.graph;

import com.warnoux.graph.model.Element;
import com.warnoux.graph.repository.GraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GraphApplication.class, args);
    }

    @Autowired
    GraphRepository graphRepository;

    @Override
    public void run(String... args) throws Exception {
        this.graphRepository.save(new Element(1));
        this.graphRepository.save(new Element(100));
        this.graphRepository.save(new Element(30));
        this.graphRepository.save(new Element(50));
        this.graphRepository.save(new Element(75));
        this.graphRepository.save(new Element(25));
        this.graphRepository.save(new Element(80));
        this.graphRepository.save(new Element(80));

    }
}
