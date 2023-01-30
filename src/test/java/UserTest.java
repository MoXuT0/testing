import me.denis.User;
import org.junit.jupiter.api.*;

public class UserTest {

    private String expectedLogin = "test";
    private String expectedEmail = "test@gmail.com";
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User(expectedLogin, expectedEmail);
    }

    @Test
    @DisplayName("Тест на создание объекта User с передачей двух параметров")
    public void isUserCreated(){
        Assertions.assertEquals(expectedLogin, user.getLogin(), "Логин не создан");
        Assertions.assertEquals(expectedEmail, user.getEmail(), "Email не создан");
    }

    @Test
    @DisplayName("Тест на создание объекта User без передачи параметров")
    public void isUserCreatedEmpty() {
        User userEmpty = new User();
        Assertions.assertNull(userEmpty.getLogin());
        Assertions.assertNull(userEmpty.getEmail());
    }

    @Test
    @DisplayName("Тест на установленный корректный Email с содержанием @ и знака точки")
    public void isCorrectEmail() {
        Assertions.assertTrue((user.getEmail().contains("@")
                && user.getEmail().contains(".")), "Некорректный email.");
    }

    @Test
    @DisplayName("Тест на несовпадение логина и email")
    public void isLoginEmailNotEquals() {
        Assertions.assertNotEquals(user.getLogin(), user.getEmail(), "Логин и email совпадают");
    }

}
