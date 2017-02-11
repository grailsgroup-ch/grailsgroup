INSERT INTO requestmap(version, config_attribute, url, date_created, last_updated)
VALUES(0, "ROLE_ADMIN", "/settings/**", NOW(), NOW()),
(0, "ROLE_ADMIN", "/jobFire/**", NOW(), NOW())
go
INSERT INTO settings(version, code, value, description, date_created, last_updated)
VALUES(0, "initialInviteDayLimit", "35", "Daylimit to send the initial invite Mail for a Groupsession", NOW(), NOW()),
(0, "reminderInviteDayLimit", "10", "Daylimit to send a reminder invitation Mail for a Groupsession", NOW(), NOW()),
(0, "reminderMailDayLimit", "2", "Daylimit to send a reminder Mail for a Groupsession", NOW(), NOW()),
(0, "tweetingDayLimit", "1", "Daylimit to tweet the data of a Groupsession", NOW(), NOW()),
(0, "lectureLimit", "2", "Limit of Lectures per Groupsession to send an invitation Mail", NOW(), NOW()),
(0, "ggsMailSenderHost", "vmg-admin", "smtp Host to send emails", NOW(), NOW()),
(0, "ggsMailSenderFrom", "info@grailsgroup.ch", "Email account to send emails", NOW(), NOW())
go
UPDATE post
SET publication_date = date_created
go