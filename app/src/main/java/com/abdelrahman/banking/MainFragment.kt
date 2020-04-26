package com.abdelrahman.banking

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.abdelrahman.banking.errorhandler.RetryHandler
import com.abdelrahman.banking.errorhandler.domain.chains.DomainErrorChain
import com.abdelrahman.presentation.model.UserInfoUi
import com.abdelrahman.presentation.resource.PresentationResource
import com.abdelrahman.presentation.viewmodelfactory.ViewModelFactory
import com.abdelrahman.presentation.viewmodels.HomeVM
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject


/**
 *@author: Abdel-Rahman El-Shikh on 25-Apr-20.
 */
class MainFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var homeVM: HomeVM

    private var userInfo: UserInfoUi? = null
    private val domainErrorChain = DomainErrorChain.BUILDER().buildWithDefaultChainLinks()

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeVM = ViewModelProvider(this, viewModelFactory).get(HomeVM::class.java)
        homeVM.requestUserInfo()
        homeVM.getUserInfo().observe(this, Observer { resource ->
            println("here ${resource.status}")
            when (resource.status) {
                PresentationResource.Status.LOADING -> {
                    println("Loading")
                    showLoader()
                }
                PresentationResource.Status.API_ERROR -> {
                    println("ERROR")
                    userInfo = null
                    hideLoader()
                    tvHomeMessage.text = getText(R.string.msg_something_went_wrong)
                }
                PresentationResource.Status.DOMAIN_ERROR ->{
                    domainErrorChain.execute(resource.throwable,this,object:RetryHandler{
                        override fun onRetry() {
                            homeVM.requestUserInfo()
                        }
                    })
                    hideLoader()
                }
                PresentationResource.Status.SUCCESS -> {
                    println("Success: ${resource.data}")
                    hideLoader()
                    resource.data?.let {
                        tvHomeUserName.text = it.userInfo.displayName
                        tvHomeAccountNumber.text =
                            String.format(
                                getString(R.string.display_account_num),
                                it.userInfo.accountNumber
                            )
                        tvHomeBalance.text =
                            String.format(
                                getString(R.string.display_account_balance),
                                it.userInfo.accountBalance
                            )

                        tvHomePremiumAccount.text = when (it.userInfo.premiumCustomer) {
                            true -> getText(R.string.title_premium_perks)
                            false -> getText(R.string.title_upgrade_to_premium)
                        }

                        tvHomeAccountType.text = it.userInfo.accountType.capitalize()

                        userInfo = it.userInfo
                    }
                }
            }
        })


        setClickListeners()

    }

    private fun setClickListeners() {
        llHomePremiumAccount.setOnClickListener {
            userInfo?.let {
                val title = when (it.premiumCustomer) {
                    true -> getText(R.string.title_premium_perks)
                    false -> getText(R.string.title_upgrade_to_premium)
                }
                showAlertDialog(
                    title,
                    R.string.msg_premium_account_benefits
                )

            }
        }

        llHomeImportantInfo.setOnClickListener {
            userInfo?.let {
                showAlertDialog(
                    getText(R.string.title_important_info),
                    R.string.msg_important_information
                )
            }
        }

        llHomeAccountType.setOnClickListener {
            userInfo?.let {
                showAlertDialog(
                    getText(R.string.title_important_info),
                    R.string.msg_account_type_info
                )
            }
        }

        llHomeTransactions.setOnClickListener {
            val transactionsIntent = Intent(activity, TransactionsActivity::class.java)
            startActivity(transactionsIntent)
        }
    }

    /**
     * SHows loading indicator and blurs other views
     */
    private fun showLoader() {
        cvAccountInfoHolder.alpha = Companion.ALPHA_HIDDEN
        tvHomeMessage.alpha = Companion.ALPHA_HIDDEN
        llHomeActionHolder.alpha = Companion.ALPHA_HIDDEN
        pbHomeLoader.visibility = View.VISIBLE
    }

    /**
     * Hides loading indicator
     */
    private fun hideLoader() {
        cvAccountInfoHolder.alpha = Companion.ALPHA_VISIBLE
        tvHomeMessage.alpha = Companion.ALPHA_VISIBLE
        llHomeActionHolder.alpha = Companion.ALPHA_VISIBLE
        pbHomeLoader.visibility = View.GONE
    }

    /**
     * Displays dummy Message, shows (current date + 3) days as bank closed day
     */
//    private fun displayBankOperationsClosedMessage() {
//        val operationShutDay = Calendar.getInstance().addDays(DAYS_AFTER_CURRENT_DATE)
//        tvHomeMessage.text = String.format(
//            getString(R.string.msg_operations_closed),
//            dateFormat.format(operationShutDay.time)
//        )
//    }

    /**
     * Displays an alert dialog
     * @param title Title of the alert dialog
     * @param contentId string resource id of the content
     */
    private fun showAlertDialog(title: CharSequence, @StringRes contentId: Int) {
        AlertDialog.Builder(context as Context)
            .setTitle(title)
            .setMessage(contentId)
            .setCancelable(true)
            .setPositiveButton(R.string.btn_txt_dismiss) { dialog, _ ->
                dialog.dismiss()
            }.create()
            .show()
    }

    companion object {
        const val ALPHA_HIDDEN = 0.2f
        const val ALPHA_VISIBLE = 1.0f
    }
}