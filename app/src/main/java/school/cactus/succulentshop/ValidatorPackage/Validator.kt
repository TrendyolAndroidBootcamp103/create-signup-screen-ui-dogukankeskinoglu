package school.cactus.succulentshop.ValidatorPackage

interface Validator {

    fun validateLogin(field: String):Int?

    fun validateSignIn(field: String):Int?

    fun validateEmpty(field: String)=field.isEmpty()

    fun validateShort(field: String,constrain:Int)=field.length<=constrain

    fun validateLong(field: String,constrain: Int)=field.length>=constrain

    fun validateContain(field: String):Boolean?

}