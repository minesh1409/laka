package com.lakazambia.api.connection;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;

@PropertySource("classpath:db.properties")
public class DbInitializer implements InitializingBean {

	@Value("${rethink.db}")
	public String db;

	@Value("${rethink.schema}")
	public String tab;

	@Value("${rethink.schema1}")
	public String tab1;

	@Autowired
	private RethinkDBConnectionFactory connectionFactory;

	@Autowired
	// private ChatChangesListener chatChangesListenur;

	private static final RethinkDB r = RethinkDB.r;

	@Override
	public void afterPropertiesSet() throws Exception {
		createDb();
		// chatChangesListener.pushChangesToWebSocket();
	}

	private void createDb() {
		Connection connection = connectionFactory.createConnection();
		@SuppressWarnings("unused")
		List<String> dbList = null;
		r.dbList().run(connection);

		/*
		 * System.out.println("Database Name :: " +db);
		 * System.out.println("Table Name :: " +tab); if (!dbList.contains(db)) {
		 * r.dbCreate(db).run(connection); } List<String> tables =
		 * r.db(db).tableList().run(connection); if (!tables.contains(tab)) {
		 * r.db(db).tableCreate(tab).optArg("primary_key", "uid").run(connection); //
		 * r.db("chat").table("messages").indexCreate("time").run(connection); }
		 */
	}
}
