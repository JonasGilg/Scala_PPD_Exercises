package e6

import java.sql.{Connection, PreparedStatement, ResultSet}

object E65 {
	trait JdbcTemplate {
		def query(
			            psc: Connection => PreparedStatement,
			            rowMapper: (ResultSet, Int) => AnyRef
		            ): List[AnyRef]
	}
}
