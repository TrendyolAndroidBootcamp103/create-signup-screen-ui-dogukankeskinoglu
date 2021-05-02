package school.cactus.succulentshop.ValidatorPackage


import school.cactus.succulentshop.Enum.ValidatorEnum
import school.cactus.succulentshop.R

class EmailValidator : Validator {

    override fun validateLogin(field: String)= when {
        field.isEmpty() -> R.string.emailEmptyError
        else->null
    }
    override fun validateSignIn(field: String)=when {
        validateEmpty(field) -> R.string.emailEmptyError
        validateContain(field)->R.string.emailContainError
        validateLong(field,ValidatorEnum.maxLengthEmail.constraint)->R.string.emailLongError
        validateShort(field,ValidatorEnum.minLengthEmail.constraint)->R.string.emailShortError
        else->null
    }

    override fun validateContain(field: String)= !(field.contains("@") && field.contains("."))


}