package eu.devclub.plugins;

public class LoginService {
  private final UserRepository repository;

  LoginService(UserRepository repository) {
    this.repository = repository;
  }

  public Long login(String username) {
    return repository.findUser(username)
        .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));
  }
}
