import com.thoughtworks.TodoApp;
import com.thoughtworks.TodoList;
import com.thoughtworks.TodoRepository;

public class Main {

    public static void main(String[] args) {
        TodoList todoList = new TodoList(new TodoRepository());
        new TodoApp(System.in, System.out, todoList).run();
    }
}
