package ch.grailsgroup

class Image {
	
	byte[] image
	String contentType
	String alias
	boolean oeffentlich
	
    static constraints = {
		alias(blank:false, nullable:false, unique:true)
		image(nullable: true, maxSize: 2048000 /* 2M */)
		contentType(nullable:true, display:false)
		oeffentlich(nullable:false)
    }
	
	public String toString(){
		return alias
	}
	
	static transients =["filename"]
	
	public String getFilename(){
		String fileEnd = contentType.split("/")[1]
		return "${alias}.${fileEnd}"
	}
}
