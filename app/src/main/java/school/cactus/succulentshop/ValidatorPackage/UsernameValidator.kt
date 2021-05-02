package school.cactus.succulentshop.ValidatorPackage


import school.cactus.succulentshop.Enum.ValidatorEnum
import school.cactus.succulentshop.R


class UsernameValidator : Validator {

    override fun validateLogin(field: String)= when {
        field.isEmpty() -> R.string.usernameEmptyError
        else->null
    }

    override fun validateSignIn(field: String)=when {
        validateEmpty(field)-> R.string.usernameEmptyError
        validateContain(field)->R.string.usernameContainError
        validateShort(field,ValidatorEnum.minLengthUsername.constraint)->R.string.usernameShortError
        validateLong(field,ValidatorEnum.maxLengthUsername.constraint)->R.string.usernameLongError
        else->null
    }

    override fun validateContain(field: String)=!(field.all { it.isLowerCase() || it.isDigit() || it=='_' })





}