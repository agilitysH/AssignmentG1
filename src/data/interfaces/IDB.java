
package data.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDB extends Connection {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
