package imaisan;

public class DatabaseMetaDataResponse {

  private final String databaseProductName;
  private final int databaseMajorVersion;
  private final String driverVersion;

  public DatabaseMetaDataResponse(String databaseProductName, int databaseMajorVersion, String driverVersion) {
    this.databaseProductName = databaseProductName;
    this.databaseMajorVersion = databaseMajorVersion;
    this.driverVersion = driverVersion;
  }

  public String getDatabaseProductName() {
    return databaseProductName;
  }

  public int getDatabaseMajorVersion() {
    return databaseMajorVersion;
  }

  public String getDriverVersion() {
    return driverVersion;
  }

}
