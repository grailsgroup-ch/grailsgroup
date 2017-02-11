/*
 * Kopiert die Posts aus grailsgroup_wpress nach ggs. Irgendwie geht das mit dem Zeichensatz nicht wirklich.... 
 */
Insert into ggs.post (ID, version, active, alias, content, date_created, last_updated,title, user_id)
select id, 1, 1, '', CONVERT(post_content USING latin1), post_date_gmt, post_date_gmt, CONVERT(post_title USING latin1), 1
from wp_posts
where post_status = 'publish'

/*

Keine schlauen Comments vorhanden, deshalb müssen diese nicht übernommen werden 
 
Insert into ggs.comment (id, version, content, date_created, last_updated, post_id, user_id)
select comment_id, 1, comment_content, comment_date, comment_date, comment_post_id, 1
from wp_comments
*/