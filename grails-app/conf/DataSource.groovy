dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    username = "ggs"
    password = "ggs"
	dialect = 'org.hibernate.dialect.MySQL5InnoDBDialect'
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
            dbCreate = "update" // one of 'create', 'create-drop','update'
            url = "jdbc:mysql://localhost/ggs"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://localhost/ggs"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
			password = ""
		    url = "jdbc:mysql://localhost/ggs"
        }
    }
}