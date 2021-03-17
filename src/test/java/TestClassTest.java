import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sda.Display;
import sda.Task;
import sda.TaskStore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestClassTest {


    String dueDate = "20-2-2021";
    String projectName = "Learning";
    String taskTitle = "Learn Java";


    @Test
    @DisplayName("when add task the array list size will increase and should pass")
    public void addTaskTest() throws ParseException {
        TaskStore ts = new TaskStore();
        String dueDate = "17-03-2021";
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dueDate);
        ts.addTask("Sara", date, "Java");
        Assertions.assertEquals(1, ts.getTaskListSize());
        //Assertions.assertNull();
    }

    @Test
    @DisplayName("when rempve task and array list has task should pass")
    public void removeTaskTestAfterAdding3TasksInArrayList() throws ParseException {
        TaskStore ts = new TaskStore();
        String dueDate = "17-03-2021";
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dueDate);
        ts.addTask(taskTitle, date, projectName);
        ts.addTask("playing football", date, "Entertainment");
        ts.addTask(taskTitle, date, projectName);
        Assertions.assertEquals(3, ts.getTaskListSize());
        ts.removeSelectedTask(1);
        Assertions.assertEquals(2, ts.getTaskListSize());
        // Assertions.assertNull();
    }

    @Test
    @DisplayName("when rempve task and array list has no task in it ,it shouldn't pass")

    public void removeTaskTestWhentheArraylistIsEmpty() {




        // Assertions.assertEquals(0, ts.getTaskListSize());
        TaskStore ts = new TaskStore();

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            ts.removeSelectedTask(0);
        });

    }

    @Test
    @DisplayName("When rempve task and array list has no task in it ,it shouldn't pass")
    public void markAsDoneTestShouldReturnTureToTheStatus()throws ParseException{
        //A: Arrange
        TaskStore ts = new TaskStore();
        String dueDate = "17-03-2021";
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dueDate);
        ts.addTask(taskTitle, date, projectName);

        //A: Act
        ts.MarkAsDone(0);

        //A: Assert
        Assertions.assertTrue(ts.getTaskbyId(0).getStatus());
    }

    @Test
    @DisplayName("When Mark As done for empty array list   ,it shouldn't pass")
    public void markAsDoneTestForEmptyArraylist()throws ParseException{
        TaskStore ts = new TaskStore();


        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            ts.MarkAsDone(0);
        });


}}