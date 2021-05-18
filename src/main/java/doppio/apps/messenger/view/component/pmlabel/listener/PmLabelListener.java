package doppio.apps.messenger.view.component.pmlabel.listener;

import doppio.apps.messenger.controller.PmController;

public class PmLabelListener {

    PmController pmController = new PmController();

    public void removePm(int pmId) {
        pmController.removePm(pmId);
    }

    public void editPm(int pmId, String text) {
        pmController.editPm(pmId, text);
    }
}
