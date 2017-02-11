modules = {
    jqueryPlugins {
		dependsOn "jquery" 
		resource url:'js/jquery.jcarousel.min.js', disposition: 'head'
		resource url:'js/jquery.pikachoose.js', disposition: 'head'
		resource url:'js/jquery-ui-1.9.1.custom.min.js', disposition: 'head'
		resource url:'js/bootstrap.min.js', disposition: 'head'
	}
	
	application {
		dependsOn "jqueryPlugins"
        resource url:'js/application.js', disposition: 'head'
    }
	
    wysiwyg {
        dependsOn 'jquery'
        defaultBundle false

        resource url: 'js/ckeditor/ckeditor.js', disposition: 'head', exclude: 'hashandcache'
    	resource url: 'js/ckeditor/config.js', disposition: 'head', exclude: 'hashandcache'
		resource url: 'js/ckeditor/skins/moono/editor_gecko.css', disposition: 'head', exclude: 'hashandcache'
		resource url: 'js/ckeditor/lang/de.js', disposition: 'head', exclude: 'hashandcache'
		resource url: 'js/ckeditor/plugins/sourcearea/plugin.js', disposition: 'head', exclude: 'hashandcache'
		resource url: 'js/ckeditor/plugins/sourcearea/lang/de.js', disposition: 'head', exclude: 'hashandcache'
		resource url: 'js/ckeditor/plugins/sourcearea/icons/source.png', disposition: 'head', exclude: 'hashandcache'
        resource url: 'js/wysiwyg.js'
    }

	css {
		resource url:'css/main.css', disposition: 'head'
		//resource url:'css/mobile.css', disposition: 'head' //TODO remove? Replaced by bootstrap?
		resource url:'css/pikachoose.css', disposition: 'head'
		resource url:'css/jquery-ui-1.9.1.custom.min.css', disposition: 'head'
		resource url:'css/bootstrap.min.css', disposition: 'head'
	}
}
