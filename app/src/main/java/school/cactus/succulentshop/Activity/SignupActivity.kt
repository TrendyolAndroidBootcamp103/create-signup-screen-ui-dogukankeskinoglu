package school.cactus.succulentshop.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import school.cactus.succulentshop.R
import school.cactus.succulentshop.ValidatorPackage.EmailValidator
import school.cactus.succulentshop.ValidatorPackage.PasswordValidator
import school.cactus.succulentshop.ValidatorPackage.UsernameValidator

import school.cactus.succulentshop.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity(){
    private lateinit var binding: ActivitySignupBinding

    private val emailValidator=EmailValidator()
    private val usernameValidator = UsernameValidator()
    private val passwordValidator = PasswordValidator()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title=getString(R.string.signupTitle)

        binding.apply {
            alreadyHaveButton.setOnClickListener{navigateToLoginActivity()}
            signUpButton.setOnClickListener{
                    emailInput.validate()
                    usernameInput.validate()
                    passwordInput.validate()
            }

        }

    }

    private fun TextInputLayout.validator()=when(this){
        binding.emailInput->emailValidator
        binding.usernameInput->usernameValidator
        binding.passwordInput->passwordValidator
        else->throw IllegalAccessException("Cannot find any validator for the given TextInputLayout")
    }

    private fun TextInputLayout.validate(){
        val errorMessage=validator().validateSignIn(editText!!.text.toString())
        error=errorMessage?.resolveAsString()
        isErrorEnabled=errorMessage!=null
    }
    private fun Int.resolveAsString()=getString(this)

    private fun navigateToLoginActivity(){
        val intent=Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

}