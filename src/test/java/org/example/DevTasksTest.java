package org.example;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.List;
import java.util.Map;

public class DevTasksTest extends TestCase  {

    public void testShouldAssignTaskByDev() {

        //given
        List<Main.Task> providedTasks = List.of(
                new Main.Task(1, "Task1"),
                new Main.Task(2, "Task2")
        );

        List<Main.Developer> providedDevelopers = List.of(
                new Main.Developer(1, "Dev1"),
                new Main.Developer(2, "Dev2")
        );

        List<Main.Assignment> providedAssigments = List.of(
                new Main.Assignment(1, 1),
                new Main.Assignment(2, 1)
        );

        //when
        Map<String, List<String>> devTasks = Main.report(providedTasks, providedDevelopers, providedAssigments);

        //then
        Assert.assertEquals(2, devTasks.get("Dev1").size());
        Assert.assertNull( devTasks.get("Dev2"));



    }
}
