package school.cactus.succulentshop.ValidatorPackage


import school.cactus.succulentshop.Enum.ValidatorEnum
import school.cactus.succulentshop.R

class PasswordValidator : Validator {

    override fun validateLogin(field: String)= when {
        field.isEmpty() -> R.string.passwordEmptyError
        else->null
    }
    override fun validateSignIn(field: String)=when {
        validateEmpty(field) -> R.string.passwordEmptyError
        validateShort(field,ValidatorEnum.minLengthPassword.constraint)->R.string.passwordShortError
        validateLong(field,ValidatorEnum.maxLengthPassword.constraint)->R.string.passwordLongError
        !validateContain(field)->R.string.passwordContainError
        else->null

    }

    override fun validateContain(field: String)=
        field.any{it.isLowerCase()} &&
        field.any{it.isUpperCase()} &&
        field.any{it.isDigit()} &&
        field.any{!it.isLetterOrDigit()}


}