package school.cactus.succulentshop.Enum

enum class ValidatorEnum(val constraint: Int) {
    minLengthEmail(5),
    maxLengthEmail(50),
    minLengthUsername(2),
    maxLengthUsername(20),
    minLengthPassword(7),
    maxLengthPassword(40)
}