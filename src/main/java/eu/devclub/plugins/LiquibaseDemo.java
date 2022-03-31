package eu.devclub.plugins;

import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LiquibaseDemo {
  private static final Logger log = LoggerFactory.getLogger(LiquibaseDemo.class);

  public static void main(String[] args) throws LiquibaseException, SQLException {
    // System.setProperty("zopa", "zopa");

    try (Connection connection = connect()) {
      new Liquibase("changelog.xml", new ClassLoaderResourceAccessor(), new JdbcConnection(connection)).update("");
      log.info("DB update complete");
    }
  }

  private static Connection connect() throws SQLException {
    DriverManager.registerDriver(new org.postgresql.Driver());
    Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "devclub");
    connection.setAutoCommit(false);
    return connection;
  }
}
