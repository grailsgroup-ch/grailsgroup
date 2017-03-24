package ch.grailsgroup

class SiteEntry extends Master {

    Date publicationDate

    static mapping = {
        tablePerHierarchy false
    }

    static constraints = {
        publicationDate		nullable:true
    }

    def beforeInsert(){
        publicationDate = new Date()
    }
}
