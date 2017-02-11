databaseChangeLog = {

	changeSet(author: "ms", id: "1") {
		sqlFile(path: '01.000/01_requestmap_settings.sql')
	}
	
	//Neu gibts die Table Anmeldungen
	changeSet(author: "anna", id: "anmeldungen 2") {
		sql('drop table if exists groupsession_user')
	}
	
	//Bemerkungsfeld vergrössern
	changeSet(author: "ali", id: "3") {
		sql('alter table groupsession modify column remark longtext')
		sql('ALTER TABLE groupsession CHANGE remark remark LONGTEXT CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ')
		sql('alter table lectures modify column groupsession_id bigint(20) ')
	}
}