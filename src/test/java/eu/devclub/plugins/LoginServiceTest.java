package eu.devclub.plugins;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginServiceTest {
  UserRepository repository = mock(UserRepository.class);
  LoginService service = new LoginService(repository);

  @Test
  void successfulLogin() {
    when(repository.findUser(any())).thenReturn(Optional.of(42L));

    assertThat(service.login("fedja")).isEqualTo(42);
  }

  @Test
  void failedLogin() {
    when(repository.findUser(any())).thenReturn(Optional.empty());

    assertThatThrownBy(() -> service.login("fedja"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Invalid credentials");
  }






  /*
  https://www.baeldung.com/mockito-final

  file: src/test/resources/mockito-extensions/org.mockito.plugins.MockMaker



  content 1: org.mockito.internal.creation.bytebuddy.InlineByteBuddyMockMaker


  content 2: mock-maker-inline
   */
}
