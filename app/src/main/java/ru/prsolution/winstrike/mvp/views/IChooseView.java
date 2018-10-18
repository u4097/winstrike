package ru.prsolution.winstrike.mvp.views;

import ru.prsolution.winstrike.mvp.apimodels.Arenas;
import ru.prsolution.winstrike.mvp.apimodels.RoomLayoutFactory;
import ru.prsolution.winstrike.mvp.apimodels.Rooms;


public interface IChooseView {

    void showWait();

    void removeWait();

    void onGetArenasResponseSuccess(Arenas authResponse,int selectedArena);

    void onGetAcitivePidFailure(String appErrorMessage);

    void onDateClickListener();

    void onTimeClickListener();

    void onNextButtonClickListener();


    void onGetArenaByTimeResponseSuccess(RoomLayoutFactory authResponse);

    void onGetArenaByTimeFailure(String appErrorMessage);
}
