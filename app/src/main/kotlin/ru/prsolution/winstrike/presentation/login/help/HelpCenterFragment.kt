package ru.prsolution.winstrike.presentation.login.help

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fmt_help_center.tv_help_centr
import kotlinx.android.synthetic.main.fmt_help_center.tv_sms
import org.jetbrains.anko.support.v4.longToast
import ru.prsolution.winstrike.R
import ru.prsolution.winstrike.presentation.utils.Constants
import ru.prsolution.winstrike.presentation.utils.inflate

/*
 * Created by oleg on 01.02.2018.
 */

class HelpCenterFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return context?.inflate(R.layout.fmt_help_center)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        tv_sms.setOnClickListener {
//            startActivity(Intent(requireActivity(), HelpSmsFragment::class.java))
            longToast("TODO: Open restore password page")
        }

        tv_help_centr.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(Constants.URL_WINSTRIKE))
            startActivity(browserIntent)
        }
    }

}