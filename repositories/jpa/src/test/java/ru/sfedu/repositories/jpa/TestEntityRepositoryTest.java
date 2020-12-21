package ru.sfedu.repositories.jpa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import ru.sfedu.repositories.jpa.entity.TestEntity;
import ru.sfedu.repositories.jpa.repository.TestEntityRepository;
import ru.sfedu.repositories.jpa.repository.impl.TestEntityRepositoryImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static ru.sfedu.repositories.jpa.Constant.PERSISTENCE_UNIT_NAME;

public class TestEntityRepositoryTest extends Instance {
    private static final Logger log = LogManager.getLogger(TestEntityRepositoryTest.class);

    private final TestEntityRepository repository;

    public TestEntityRepositoryTest() {
        System.setProperty(PERSISTENCE_UNIT_NAME, "h2-test");
        this.repository = new TestEntityRepositoryImpl();
    }

    @Test
    public void save() {
        Assert.assertNotNull(repository.save(te1).getId());
    }

    @Test
    public void saveAll() {
        List<TestEntity> list = generate(1000);
        long startTime = System.currentTimeMillis();
        repository.saveAll(list);
        System.out.println(startTime - System.currentTimeMillis());
    }

    private List<TestEntity> generate(int count) {
        List<TestEntity> list = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            list.add(new TestEntity(String.valueOf(i), new Date()));
        }
        return list;
    }

}
