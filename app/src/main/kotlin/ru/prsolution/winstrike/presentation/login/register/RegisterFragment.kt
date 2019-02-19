package ru.prsolution.winstrike.presentation.login.register

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.ac_smshelp.*
import kotlinx.android.synthetic.main.fmt_register.*
import org.jetbrains.anko.support.v4.longToast
import org.jetbrains.anko.support.v4.toast
import ru.prsolution.winstrike.R
import ru.prsolution.winstrike.presentation.utils.pref.PrefUtils
import ru.prsolution.winstrike.presentation.utils.TextFormat
import ru.prsolution.winstrike.domain.models.login.LoginModel
import ru.prsolution.winstrike.domain.models.common.MessageResponse
import ru.prsolution.winstrike.domain.models.login.UserModel
import timber.log.Timber
import ru.prsolution.winstrike.presentation.utils.TextFormat.setTextFoot1Color
import ru.prsolution.winstrike.presentation.utils.TextFormat.setTextFoot2Color
import ru.prsolution.winstrike.datasource.model.login.AuthResponseEntity
import ru.prsolution.winstrike.domain.models.login.SmsModel
import ru.prsolution.winstrike.presentation.login.LoginActivity
import ru.prsolution.winstrike.presentation.utils.Constants
import ru.prsolution.winstrike.presentation.utils.inflate

/*
 * Created by oleg on 31.01.2018.
 */

class RegisterFragment : Fragment() {

//    private var presenter: RegisterPresenter? = null
    private var user: LoginModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return context?.inflate(R.layout.fmt_register)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        register_button.setOnClickListener {
            val action = RegisterFragmentDirections.actionToNavigationCode()
            Navigation.findNavController(requireActivity(),R.id.login_host_fragment).navigate(action)
        }
    }

    fun init() {
/*        next_button_phone!!.setOnClickListener {
            // Создание пользователя и переход на страницу подтверждения пароля
            user = LoginModel(
                phone = formatPhone(et_phone?.text.toString()),
                password = et_password?.text.toString()
            )

//            presenter!!.createUser(user!!)
        }

        setFooter()*/
    }

    fun onSendSmsSuccess(authResponse: MessageResponse) {
        Timber.d("Sms send successfully: %s", authResponse.message)
        toast("Код выслан")
        val intent = Intent(requireActivity(), CodeFragment::class.java)
        intent.putExtra("phone", user!!.phone)
        startActivity(intent)
    }

    fun onSmsSendFailure(appErrorMessage: String) {
        Timber.d("Sms send failure: %s", appErrorMessage)
    }

    private fun getConfirmSmsModel(phone: String): SmsModel {
        return SmsModel(phone)
    }

    private fun setFooter() {
//        TextFormat.formatText(et_phone, Constants.PHONE_MASK)
//        setTextFoot1Color(tv_register!!, "Уже есть аккаунт?", "#9b9b9b")
//        setTextFoot2Color(tv_register2!!, "Войдите", "#c9186c")

//        tv_register2!!.setOnClickListener { startActivity(Intent(requireActivity(), LoginActivity::class.java)) }
    }


    /**
     * Register new user and send him sms with confirm code.
     */
    fun onRegisterSuccess(authResponse: AuthResponseEntity) {
        with(PrefUtils) {
            token = authResponse.token
            publicid = authResponse.user?.publicId!!
            isConfirmed = false
            phone = user?.phone
            name = "NoName"
        }

        val userDb = UserModel(
            id = null,
            confirmed = false,
            phone = user?.phone,
            publickId = authResponse.user?.publicId,
            token = authResponse.token
        )

        val intent = Intent(requireActivity(), CodeFragment::class.java)
        intent.putExtra("phone", user!!.phone)
        startActivity(intent)
    }

    fun onRegisterFailure(appErrorMessage: String) {
        Timber.d("Register failure: %s", appErrorMessage)
        if (appErrorMessage.contains("409")) longToast("Пользователь уже существует")
        if (appErrorMessage.contains("422")) longToast("Пароль слишком короткий.")
        if (appErrorMessage.contains("413")) {
            Timber.w("RegisterUser: Передан не правильный формат данных JSON")
            longToast("Пользователь не создан")
        }
    }

    override fun onStop() {
        super.onStop()
    }

}