dataSource {
    pooled = true
	//driverClassName = "oracle.jdbc.driver.OracleDriver"
	//dialect = "org.hibernate.dialect.Oracle10gDialect"
	driverClasName = "com.mysql.jdbc.Driver"
	dialect = "org.hibernate.dialect.MySQLInnoDBDialect"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop','update'
            //url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"
			url = "jdbc:mysql://127.0.0.1:3306/resrc"
			username = "dev"
			password = "dev"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            //url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"
			url = "jdbc:mysql://192.168.8.14:3306/resrc"
			username = "resrc"
			password = "resrc"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            //url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"
			url = "jdbc:mysql://192.168.8.14:3306/resrc"
			username = "resrc"
			password = "resrc"
        }
    }
}
