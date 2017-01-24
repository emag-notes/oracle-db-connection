package imaisan;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

@Path("/")
public class DbConnectionController {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public DatabaseMetaDataResponse get() {

    DataSource ds = null;
    try {
      ds = InitialContext.doLookup("java:comp/env/jdbc/TestDS");
    } catch (NamingException e) {
      e.printStackTrace();
    }

    try (Connection connection = ds.getConnection()) {

      DatabaseMetaData metaData = connection.getMetaData();

      return new DatabaseMetaDataResponse(
        metaData.getDatabaseProductName(),
        metaData.getDatabaseMajorVersion(),
        metaData.getDriverVersion()
      );

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return new DatabaseMetaDataResponse("Unknown", -1, "Unknown");
  }

}
