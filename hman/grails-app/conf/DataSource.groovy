dataSource {
    pooled = true

    //driverClassName = "oracle.jdbc.driver.OracleDriver"
    //dialect = "org.hibernate.dialect.Oracle10gDialect"
    //driverClasName = "com.mysql.jdbc.Driver"
    //dialect = "org.hibernate.dialect.MySQLInnoDBDialect"

    dbCreate = "create-drop"
	driverClassName = "org.h2.Driver"
	url = "jdbc:h2:mem:testDb"
	username = "sa"
	password = ""
	
    //driverClassName = "org.postgresql.Driver"
    //dialect = org.hibernate.dialect.PostgreSQLDialect
    //url = "jdbc:postgresql://localhost/test"
	//username = test
	//password = test
	
    //uri = newURI(System.env.DATABASE_URL?:"postgres://test:test@localhost/test")
    //url = "jdbc:postgresql://"+uri.host+uri.path
    //username = uri.userInfo.split(":")[0]
    //password = uri.userInfo.split(":")[1]
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
            //dbCreate = "update" // one of 'create', 'create-drop','update'
            //url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"
            //url = "jdbc:mysql://127.0.0.1:3306/resrc"
            //username = "dev"
            //password = "dev"
        }
    }
    test {
        dataSource {
            //dbCreate = "update"
            //url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"
            //url = "jdbc:mysql://192.168.8.14:3306/resrc"
            //username = "resrc"
            //password = "resrc"
        }
    }
    production {
        dataSource {
            //dbCreate = "update"
            //url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"
            //url = "jdbc:mysql://192.168.8.14:3306/resrc"
            //username = "resrc"
            //password = "resrc"
        }
    }
}
