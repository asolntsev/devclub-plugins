package eu.devclub.plugins;

import java.util.Optional;

public final class UserRepository {
  public Optional<Long> findUser(String username) {
    return Optional.of(1L);
  }
}
