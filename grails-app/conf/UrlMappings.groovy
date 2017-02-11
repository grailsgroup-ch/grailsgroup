class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		
		//create url like "/image/alias.png"
		"/image/$alias.$contentType?"(controller:"image", action:'index')

		"/"(controller:"welcome")
		"500"(view:'/error')
	}
}
