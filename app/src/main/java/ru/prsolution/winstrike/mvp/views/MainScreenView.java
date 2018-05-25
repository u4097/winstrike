package ru.prsolution.winstrike.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.ArrayList;

import ru.prsolution.winstrike.mvp.models.MessageResponse;
import ru.prsolution.winstrike.mvp.apimodels.OrderModel;


/**
 * Created by terrakok 25.11.16
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface MainScreenView extends MvpView {
    int HOME_TAB_POSITION = 0;
    int PLACE_TAB_POSITION = 1;
    int USER_TAB_POSITION = 2;

    void highlightTab(int position);

    void hideBottomTab();

    void goHome();

    void showWait();

    void removeWait();

    void onGetOrdersSuccess(ArrayList<OrderModel> orders);

    void onGetOrdersFailure(String appErrorMessage);

    void showBottomTab();

    void setProfileScreenInterfaceVisibility(Boolean isVisible);

    void onProfileUpdateSuccessfully(MessageResponse authResponse);

    void onFailtureUpdateProfile(String appErrorMessage);
}
