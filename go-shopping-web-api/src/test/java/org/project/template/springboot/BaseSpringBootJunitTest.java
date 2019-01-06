package org.project.template.springboot;

import org.junit.runner.RunWith;
import org.project.template.SpringBootMainWar;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootMainWar.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
public class BaseSpringBootJunitTest {

}
