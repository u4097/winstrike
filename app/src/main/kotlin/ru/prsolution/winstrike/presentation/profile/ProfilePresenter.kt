package ru.prsolution.winstrike.presentation.profile


import ru.prsolution.winstrike.ui.Screens
import ru.prsolution.winstrike.networking.Service
import rx.subscriptions.CompositeSubscription

/**
 * Created by oleg 24.01.2019
 */

class ProfilePresenter(private val service: Service,
                       private val number: Int)  {
	private val subscriptions: CompositeSubscription? = null


	fun onForwardPressed() {
//		router.navigateTo(Screens.FORWARD_SCREEN, number + 1)
	}

	fun onGithubPressed() {
//		router.navigateTo(Screens.GITHUB_SCREEN)
	}

	fun onBackPressed() {
		//router.exit();
//		router.replaceScreen(Screens.START_SCREEN, 0)
	}

	fun onStop() {
		subscriptions!!.unsubscribe()
	}

}