import static org.junit.jupiter.api.Assertions.*;
import com.SaraSDA.ToDoListApp_V2.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class TestClassTest {


    @Test
    @DisplayName("First Test")
    public void addTaskTest() throws ParseException {
        TaskStore ts = new TaskStore();
        String dueDate = "17-03-2021";
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dueDate);
        ts.addTask("Sara", date, "Java" );
        Assertions.assertEquals(1, ts.getTaskListSize());
        //Assertions.assertNull();
    }


}