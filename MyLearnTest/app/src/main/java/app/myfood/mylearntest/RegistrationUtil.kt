package app.myfood.mylearntest

object RegistrationUtil {

    private val existingUsers = listOf("Agostinho", "Santos")
    /**
     * the input is not valid if...
     * ...the username/password is empty
     * ...the username is already token
     * ...the confirmed password is not the same as the real password
     * ...the password contains less than 2 digits
     */
    fun validateRegistrationInput(
        username: String,
        password: String,
        confirmedPassword: String,
    ): Boolean {
        return true
    }
}